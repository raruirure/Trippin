package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.board.BoardAction;
import org.trippin.action.board.BoardDeleteAction;
import org.trippin.action.board.BoardModifyAction;
import org.trippin.action.board.BoardModifyOkAction;
import org.trippin.action.board.BoardNoticeDetailAction;
import org.trippin.action.board.BoardFreeAction;
import org.trippin.action.board.BoardFreeDetailAction;
import org.trippin.action.board.BoardWriteAction;
import org.trippin.action.board.BoardWriteOkAction;

@WebServlet("*.board")
public class BoardFrontController extends Controller {
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;

		if ("/begin.board".equals(command)) {
			action = new BoardAction();
		}else if ("/freeList.board".equals(command)) {
			action = new BoardFreeAction();
		}
		// 글 상세보기
		else if ("/noticeD.board".equals(command)) {
			action = new BoardNoticeDetailAction();
		} else if ("/freeD.board".equals(command)) {
			action = new BoardFreeDetailAction();
		}
		// 글 작성
		else if ("/normalW.board".equals(command)) {
			action = new BoardWriteAction();
		} else if ("/normalWOK.board".equals(command)) {
			action = new BoardWriteOkAction();
		}
		// 글 수정
		else if ("/modifyFormBoard.board".equals(command)) {
			action = new BoardModifyAction();
		} else if ("/modify_ok_board.board".equals(command)) {
			action = new BoardModifyOkAction();
		}
		// 글 삭제
		else if ("/deleteBoard.board".equals(command)) {
			action = new BoardDeleteAction();
		}

		actionforward = action.execute(req, resp);
		forward(actionforward, req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
