package org.trippin.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.DeleteBoardService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = null;

		String code_key = req.getParameter("code_key");
		String write_no = req.getParameter("write_no");

		DeleteBoardService deleteBoardService = new DeleteBoardService();
		boolean isDeleteSuccess = deleteBoardService.deleteBoard(write_no);
		
		
		if(isDeleteSuccess) {
			System.out.println(">>>>>>>>>>>>글삭제 성공");
		} else {
			System.out.println(">>>>>>>>>>>>글삭제 실패");
		}
		if(code_key.equals("N")) {
			forward = new ActionForward("begin.board", true);
		}else if(code_key.equals("F")) {
			forward = new ActionForward("freeList.board", true);
		}
		return forward;
	}

}
