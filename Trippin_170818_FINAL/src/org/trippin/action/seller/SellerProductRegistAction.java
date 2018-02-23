package org.trippin.action.seller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.dao.ProductDao;
import org.trippin.file.FileUploadForm;
import org.trippin.service.seller.SellerProductRegistService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.ProductVo;

public class SellerProductRegistAction implements Action {
	HttpSession session;
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ActionForward forward = null;
		String viewName = "seller_product_manage.seller";
		FileUploadForm fileForm = new FileUploadForm();
		
		HashMap<String, String> productInfo = fileForm.getParams(req, resp, ProductVo.SAVEFOLDER);
		session = req.getSession();
		MemberVo member = (MemberVo)session.getAttribute("member");
		productInfo.put("seller_id", member.getUserId());
		SellerProductRegistService service = new SellerProductRegistService();
		service.setProductUpload(productInfo);
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
