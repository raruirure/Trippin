package org.trippin.action.main;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.product.ProductSelectService;
import org.trippin.vo.ProductVo;

public class MainProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String viewName = "WEB-INF/view/search/resultNation_product.jsp";
		ActionForward forward = null;
		ArrayList<ProductVo> product = null;
		
		//��瑜� cateogory parameter �솗�씤
		String category = "99";
		if(req.getParameter("category") !=null){
			category = req.getParameter("category");
		}
		
		//select box �꽑�깮 �젙�젹
		String select = "s1";
		if(req.getParameter("select") !=null){
			select = req.getParameter("select");
		}
		

		ProductSelectService pss = new ProductSelectService();
		
		try{
			product = pss.ProductListAll(category, select);
			if(product==null){
				 resp.setContentType("text/html;charset=UTF-8");
		         PrintWriter out = resp.getWriter();
		         out.println("<script>");
		         out.println("alert('議고쉶�떎�뙣')");
		         out.println("history.back();");
		         out.println("</script>");
			} else {
				session.setAttribute("product", product);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
