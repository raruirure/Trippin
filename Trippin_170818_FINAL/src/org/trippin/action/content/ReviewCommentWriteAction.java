package org.trippin.action.content;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.content.ReviewCommentWriteService;
import org.trippin.service.member.MemberLoginService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.ReviewCommentVo;


public class ReviewCommentWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("member");
		ReviewCommentWriteService service_review = new ReviewCommentWriteService();
		

		String code_class = req.getParameter("code");
		String code = req.getParameter("pro_cd");
		String userId = vo.getUserId();
		String reCmtContent = req.getParameter("content_review_content"); 
		
		int num = service_review.getReviewNum(code);
		String result_num = String.format("%04d", num);
		String code_cmt = code+"RC"+result_num;
		ReviewCommentVo Rc_vo = new ReviewCommentVo();
		Rc_vo.setcode_class(code_class);
		Rc_vo.setcode(code);
		Rc_vo.setUserId(userId);
		Rc_vo.setCodeCmt(code_cmt);
		Rc_vo.setReCmtContent(reCmtContent);
		service_review.getProductReviewComment(Rc_vo);
		
		String viewName = "productDetail.con?pro_cd="+code;
		ActionForward forward = null;
		forward = new ActionForward(viewName, true);
		return forward;
	}
}