package org.trippin.action.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.BoardWriteOkService;
import org.trippin.vo.BoardVo;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ActionForward forward = null;
		BoardVo vo = new BoardVo();
		String code_key = req.getParameter("code_key");
 		String user_id = req.getParameter("user_id");
 		String user_name = req.getParameter("user_name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");	
		
		vo.setCode_key(code_key);
		vo.setUser_id(user_id);
		vo.setUser_name(user_name);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardWriteOkService boardWriteOkService = new BoardWriteOkService();
		boolean isWriteSuccess = boardWriteOkService.boardWriteOk(vo);
		
		if(isWriteSuccess) {
			System.out.println(">>>>>>>>>>>>>>글 작성 성공");
		} else {
			System.out.println(">>>>>>>>>>>>>>글 작성 실패");
		}
		if(code_key.equals("N")) {
			forward = new ActionForward("begin.board", true);
		}else if(code_key.equals("F")) {
			forward = new ActionForward("freeList.board", true);
		}
		return forward;
	}
}
