package org.trippin.action.board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.ModifyOkBoardService;
import org.trippin.vo.BoardVo;

public class BoardModifyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ActionForward forward = null;
		
		boolean isModifySuccess = false;
		BoardVo boardVo = new BoardVo();
		
		String code_key = req.getParameter("code_key");
		String write_no = req.getParameter("write_no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		boardVo.setWrite_no(write_no);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		
		ModifyOkBoardService modifyOkBoardService = new ModifyOkBoardService();
		isModifySuccess = modifyOkBoardService.modifyBoard(boardVo);
		
		if(isModifySuccess) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>수정성공");
		} else {
			System.out.println(">>>>>>>>>>>>>>>>수정실패");
		}
		if(code_key.equals("N")) {
			forward = new ActionForward("begin.board", true);
		}else if(code_key.equals("F")) {
			forward = new ActionForward("freeList.board", true);
		}
		return forward;
	}

}
