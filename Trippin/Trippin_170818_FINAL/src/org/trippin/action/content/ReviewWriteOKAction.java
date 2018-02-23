package org.trippin.action.content;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.location.CodeInsertService;
import org.trippin.service.review.ReviewWriteService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.ReviewBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("member");
		String viewName = "WEB-INF/view/mypage/mypage_main.jsp";
		ActionForward forward = null;
		ReviewBean review = null;
		ReviewWriteService reviewWriteService = new ReviewWriteService();
		CodeInsertService codeInsertService = new CodeInsertService();
		
		/*Start of Image Upload*/
		String path = "/upload/";
		String realPath = req.getServletContext().getRealPath(path);
		int maxSize = 1024 * 1024 * 5;
		File fileUpload = null;
		String fileName = "";
		MultipartRequest mr = new MultipartRequest(req, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		fileUpload = mr.getFile("banner_img");
		fileName = "none";
		if (fileUpload != null) {
			fileName = fileUpload.getName();
		}
		System.out.println("realPath :"+realPath );
		System.out.println("fileName" + " >>>" + fileName);
		/*End of Image Upload*/
		String main_title = mr.getParameter("review_form_title");
		String code_class = "R";
		int write_no = reviewWriteService.getCount();
		String user_id = vo.getUserId();
		String sdate = mr.getParameter("fromCal");
		String edate = mr.getParameter("toCal");
		String category = mr.getParameter("selectContinents");
		String banner_img = fileName; 
		String review_content = mr.getParameter("review_form_content_detail");
		String codes = mr.getParameter("review_input_for_search");
		String code = code_class + write_no;
		int review_DayCnt = Integer.parseInt(mr.getParameter("review_daycnt"));
		//받은 좌표 코드 분할------------------------------
		ArrayList<String> codeList = new ArrayList<String>();
		String[] codeArr = codes.split("&");
		for(int i=0; i<codeArr.length;i++) {
			String[] codeArrs = codeArr[i].substring(1, codeArr[i].length()-1).split(",");
			for(int j=0;j<codeArrs.length;j++) {
				codeList.add(codeArrs[j]);
			}
		}
		String sql1 = "code,";
		String sql2 = "?,";
		for(int i=0;i<codeArr.length;i++) {
			sql1 += "pointX"+(i+1)+",pointY"+(i+1);
			sql2 += "?,?";
			if(i!=codeArr.length-1) {
				sql1 += ",";
				sql2 += ",";
			}
		}
		String sql = "INSERT INTO location("+sql1+")value("+sql2+")";
		codeInsertService.insertCode(code,codeList,sql);
		//------------------------------------------
		review = new ReviewBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, review_content, category, review_DayCnt, 0);
		boolean isWriteSuccess = false;
		try {
			isWriteSuccess = reviewWriteService.registReview(review);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(!isWriteSuccess){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward("go.mypage", true);
		}
		
		return forward;
	}

}
