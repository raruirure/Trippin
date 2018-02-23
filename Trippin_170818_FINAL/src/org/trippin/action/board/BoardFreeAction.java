package org.trippin.action.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.BoardFreeService;
import org.trippin.vo.BoardVo;
import org.trippin.vo.PageInfo;

public class BoardFreeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {

		String viewName = "WEB-INF/view/board/board_free_list.jsp";
		ActionForward forward = null;
		ArrayList<BoardVo> boardList = new ArrayList<BoardVo>();
		String code_key = "F";
		String fBSSelect = req.getParameter("fBSSelect");
		String fBSText = req.getParameter("fBSText");
		
		
		BoardFreeService boardFreeService = new BoardFreeService();
		
		int page=1;
		int limit = 10;
		
		if(req.getParameter("page")!=null){
			page=Integer.parseInt(req.getParameter("page"));
		}
		
		int listCount = 0;
		try {
			listCount = boardFreeService.getListCount(code_key, fBSSelect, fBSText);
			boardList = boardFreeService.getBoardFreeList(code_key,page, limit, fBSSelect, fBSText);
		} catch (Exception e) {		
			e.printStackTrace();
		}		
		
		int maxPage=(int)((double)listCount/limit+0.95);
		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage+10-1;
		if (endPage> maxPage) endPage= maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("boardList", boardList);
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
