package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.mypage.MemberModifyActionPro;
import org.trippin.action.mypage.MyPageAdminReport;
import org.trippin.action.mypage.MyPageAdminSuperviseAction;
import org.trippin.action.mypage.MyPageAdminSuperviseBlackListAction;
import org.trippin.action.mypage.MyPageAdminSuperviseBlackListModifyAction;
import org.trippin.action.mypage.MyPageAdminSuperviseSellerAction;
import org.trippin.action.mypage.MyPageAdminSuperviseSellerModifyAction;
import org.trippin.action.mypage.MyPageAdminSuperviseUserAction;
import org.trippin.action.mypage.MyPageAdminSuperviseUserModifyAction;
import org.trippin.action.mypage.MyPageCheckCancelAction;
import org.trippin.action.mypage.MyPageCompletedCancelAction;
import org.trippin.action.mypage.MyPageDropAction;
import org.trippin.action.mypage.MyPageImgPopupAction;
import org.trippin.action.mypage.MyPageModifyAction;
import org.trippin.action.mypage.MyPageOrderListAction;
import org.trippin.action.mypage.MyPagePathAction;
import org.trippin.action.mypage.MyPagePlanAction;
import org.trippin.action.mypage.MyPageReViewAction;
import org.trippin.action.mypage.Mypage_fileupload;

@WebServlet("*.mypage")
public class MyPageFrontController extends Controller{
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		if("/go.mypage".equals(command)){
			action = new MyPageReViewAction();
		} else if("/user_review.mypage".equals(command)){
			action = new MyPageReViewAction();
		}else if("/user_plan.mypage".equals(command)){
			action = new MyPagePlanAction();
		}else if("/user_order_list.mypage".equals(command)){
			action = new MyPageOrderListAction();
		}else if("/user_path.mypage".equals(command)){
			action = new MyPagePathAction();
		}else if("/user_check_cancel.mypage".equals(command)){
			action = new MyPageCheckCancelAction();
		}else if("/user_modify.mypage".equals(command)) {
			action = new MyPageModifyAction();
		}else if("/order_completed_cancel.mypage".equals(command)){
			action = new MyPageCompletedCancelAction();
		}else if("/admin_supervise.mypage".equals(command)){
			action = new MyPageAdminSuperviseAction();
		}else if("/admin_supervise_seller.mypage".equals(command)){
			action = new MyPageAdminSuperviseSellerAction();
		}else if("/admin_supervise_sellser_modify.mypage".equals(command)){
			action = new MyPageAdminSuperviseSellerModifyAction();
		}else if("/admin_supervise_user.mypage".equals(command)){
			action = new MyPageAdminSuperviseUserAction();
		}else if("/admin_supervise_user_modify.mypage".equals(command)){
			action = new MyPageAdminSuperviseUserModifyAction();
		}else if("/admin_supervise_blacklist.mypage".equals(command)){
			action = new MyPageAdminSuperviseBlackListAction();
		}else if("/admin_supervise_black_modify.mypage".equals(command)){
			action = new MyPageAdminSuperviseBlackListModifyAction();
		}else if("/admin_report.mypage".equals(command)){
			action = new MyPageAdminReport();
		}else if("/modify_action_pro.mypage".equals(command)){
			action = new MemberModifyActionPro();			
		}else if("/drop_action_pro.mypage".equals(command)){
			action = new MyPageDropAction();
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