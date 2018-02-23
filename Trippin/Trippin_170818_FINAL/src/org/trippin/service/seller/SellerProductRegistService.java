package org.trippin.service.seller;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import org.trippin.dao.ProductDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;
import org.trippin.vo.ProductVo;

public class SellerProductRegistService {
	private ProductVo vo;
	public ProductVo setProductUpload(HashMap<String, String> productInfo) {
		vo = new ProductVo();
		setProduct(productInfo);
		boolean finishUpload = false;
		ProductDao dao = ProductDao.getInstance();
		Connection conn = JdbcUtil.getConnection();
		dao.setConnection(conn);
		String pro_cd = dao.registProduct(vo);
		vo.setPro_edate(getEndDate());
		if(pro_cd!=null) {
			vo.setPro_cd(pro_cd);
			boolean isOk = dao.registProductDetail(vo, vo.getPro_edate().length);
			if(isOk) {
				vo.setSeller_id(productInfo.get("seller_id"));
				finishUpload = dao.registSellerInfo(vo);
			}
		}
		
		JdbcUtil.close(conn);
		return vo;
	}
	private String[] getEndDate() {
		String[] pro_edate = new String[5];
		String[] results = null;
		int total_date = vo.getPro_total_date();
		int idx = 0;

		if (vo.getPro_sdate_1() != null) {
			pro_edate[idx++] = setEndDate(vo.getPro_sdate_1(), total_date);
		}
		if (vo.getPro_sdate_2() != null) {
			pro_edate[idx++] = setEndDate(vo.getPro_sdate_2(), total_date);
		}
		if (vo.getPro_sdate_3() != null) {
			pro_edate[idx++] = setEndDate(vo.getPro_sdate_3(), total_date);
		}
		if (vo.getPro_sdate_4() != null) {
			pro_edate[idx++] = setEndDate(vo.getPro_sdate_4(), total_date);
		}
		if (vo.getPro_sdate_5() != null) {
			pro_edate[idx++] = setEndDate(vo.getPro_sdate_5(), total_date);
		}
		results = new String[idx];
		System.arraycopy(pro_edate, 0, results, 0, idx);
		return results;
	}
	private String setEndDate(String pro_sdate, int pro_total_date) {
		
		int year = Integer.parseInt(pro_sdate.substring(0,4));
		int month = Integer.parseInt(pro_sdate.substring(4,6));
		int day =Integer.parseInt(pro_sdate.substring(6,8));
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		cal.add(Calendar.DATE, +pro_total_date);
		Date weekago = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
		String pro_edate = formatter.format(weekago);
		return pro_edate;
		
	}
	private void setProduct(HashMap<String, String> productInfo) {
		try {
			Class myClass = ProductVo.class;
			Field[] fields = myClass.getDeclaredFields();
			for(Field f : fields) {
				f.setAccessible(true);
				String name = f.getName();
				if(productInfo.containsKey(name)) {
					Object fType = f.getType();
					String value = productInfo.get(name);
					if(value != null && value.length()>0) {
						if(fType.toString().equals("int")) {
							int valueInt = Integer.parseInt(value);
							f.set(vo, valueInt);
						}
						else {
							f.set(vo, value);
						}
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
