package org.trippin.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.ModifyBoardService;
import org.trippin.vo.BoardVo;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/board/normal_modifyForm.jsp";
		ActionForward forward = null;
		
		String write_no = req.getParameter("write_no");
		ModifyBoardService modifyBoardService = new ModifyBoardService();
		BoardVo boardVo = modifyBoardService.modifyBoard(write_no);
		
		req.setAttribute("boardVo", boardVo);
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
