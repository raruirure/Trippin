package org.trippin.action.mypage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.dao.MemberModifyDao;
import org.trippin.db.JdbcUtil;
import org.trippin.service.mypage.MypageModifyService;
import org.trippin.vo.MemberVo;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberModifyActionPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		// �꽌鍮꾩뒪
		MypageModifyService service = new MypageModifyService();
		ActionForward forward = null;

		String path = "/upload/";
		String realPath = req.getServletContext().getRealPath(path);
		int maxSize = 1024 * 1024 * 5;

		String modi_userPwd = "";
		File fileUpload = null;
		String fileName = "";
		MultipartRequest mr = new MultipartRequest(req, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		int num = Integer.parseInt(mr.getParameter("success"));
		modi_userPwd = mr.getParameter("modi_userPwd");
		fileUpload = mr.getFile("profilePhoto");
		fileName = "none";
	
		
		if (fileUpload != null) {
			fileName = fileUpload.getName();
		}
			System.out.println("mr.getparameter" + ">>>   " + modi_userPwd);
			System.out.println("fileName" + " >>>" + fileName);

			int result = 0;

			// �꽭�뀡�슜
			MemberVo vo = (MemberVo) session.getAttribute("member");

			MemberModifyDao member = MemberModifyDao.getInstance();

			Connection conn = JdbcUtil.getConnection();
			member.setConnection(conn);

			vo.setUserId(vo.getUserId());
			// MultipartRequest �뿉�꽌 媛����삩 媛�
			vo.setUserPass(modi_userPwd);
			vo.setUserProfile(fileName);


			result = member.updateMember(vo);// �뼐�뒗 0�씠怨�
			JdbcUtil.close(conn);

			PrintWriter out = resp.getWriter();
			System.out.println("result" + result);
			if (result > 0) {
				req.getSession().setAttribute("MSG", "�젙蹂댁닔�젙�씠 �셿猷뚮릺�뿀�뒿�땲�떎.");
				out.println("<script>");
				out.println("alert('�젙蹂댁닔�젙�씠 �셿猷뚮릺�뿀�뒿�땲�떎.')");
				out.println("</script>");
				//out.close();
			}
			// System.out.println(forward.getViewName());

			session.invalidate();


		return forward;
	}
}
