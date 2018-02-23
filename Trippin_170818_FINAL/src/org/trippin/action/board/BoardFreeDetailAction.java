package org.trippin.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.BoardFreeDetailService;
import org.trippin.vo.BoardVo;

public class BoardFreeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/board/free_detail.jsp";
		ActionForward forward = null;
		
		BoardVo boardVo= null;
		String write_no=req.getParameter("write_no");
		//System.out.println("write_no"+write_no);

		BoardFreeDetailService boardFreeDetailService = new BoardFreeDetailService();
		boardVo = boardFreeDetailService.getFreeDetail(write_no);
		
		req.setAttribute("boardVo", boardVo);
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
