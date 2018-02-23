package org.trippin.action.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.board.BoardNoticeService;
import org.trippin.vo.BoardVo;
import org.trippin.vo.PageInfo;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/board/board.jsp";
		ActionForward forward = null;
		ArrayList<BoardVo> boardList = new ArrayList<BoardVo>();
		String code_key = "N";
		String nBSSelect = req.getParameter("nBSSelect");
		String nBSText = req.getParameter("nBSText");
		
		BoardNoticeService boardNoticeService = new BoardNoticeService();
		
		int page=1;
		int limit = 10;
		
		if(req.getParameter("page")!=null){
			page=Integer.parseInt(req.getParameter("page"));
		}
		
		int listCount = 0;
		try {
			listCount = boardNoticeService.getListCount(code_key, nBSSelect, nBSText);
			boardList = boardNoticeService.getBoardNoticeList(code_key, page, limit, nBSSelect, nBSText);
		} catch (Exception e) {		
			e.printStackTrace();
		}		
		
		int maxPage=(int)((double)listCount/limit+0.95);
		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage+10-1;
		if (endPage> maxPage) endPage= maxPage;
		
		PageInfo npageInfo = new PageInfo();
		npageInfo.setEndPage(endPage);
   		npageInfo.setListCount(listCount);
		npageInfo.setMaxPage(maxPage);
		npageInfo.setPage(page);
		npageInfo.setStartPage(startPage);
		
		req.setAttribute("npageInfo", npageInfo);
		req.setAttribute("boardList", boardList);
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
