package org.trippin.action.message;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.message.MessageNormalViewService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.MessageVo;

public class MessageNormalViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("member");
		
		
		MessageNormalViewService service_message_read = new MessageNormalViewService();
		ArrayList<MessageVo> message_listN = service_message_read.getMessageNormalAll(vo.getUserId());
		if(message_listN!=null){
			req.setAttribute("message_listN", message_listN);
		}		
		
		
		// 페이징 시작
				int curPage = 0;
				if(req.getParameter("curPage") != null){
					curPage = Integer.parseInt(req.getParameter("curPage"));
				}
				
				int curBlock = 0;
				if(req.getParameter("curBlock") != null){
					curBlock = Integer.parseInt(req.getParameter("curBlock"));
				}
				
				req.setAttribute("curPage", curPage);
				req.setAttribute("curBlock", curBlock);
		//페이징 끝
		
		
		String viewName = "popup/message_list.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		return forward;
	}
}