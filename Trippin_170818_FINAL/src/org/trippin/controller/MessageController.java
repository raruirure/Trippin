 package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.message.MessageNormalDeleteAction;
import org.trippin.action.message.MessageNormalDetailAction;
import org.trippin.action.message.MessageNormalViewAction;
import org.trippin.action.message.MessageNormalWriteAction;
import org.trippin.action.message.MessageReportDeleteAction;
import org.trippin.action.message.MessageReportDetailAction;
import org.trippin.action.message.MessageReportViewAction;
import org.trippin.action.message.MessageReportWriteAction;
import org.trippin.action.message.MessageToNWriteAction;
import org.trippin.action.message.MessageToRWriteAction;


@WebServlet("*.msg")
public class MessageController extends Controller {
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		System.out.println(command);
		if("/reviewViewN.msg".equals(command)) {
			action = new MessageNormalViewAction();
		} else if("/reviewViewR.msg".equals(command)){
			action = new MessageReportViewAction();
		} else if("/message_normal_write_view.msg".equals(command)){
			action = new MessageToNWriteAction();
		} else if("/message_report_write_view.msg".equals(command)){
			action = new MessageToRWriteAction();
		} else if("/writeN.msg".equals(command)){
			action = new MessageNormalWriteAction();
		} else if("/writeR.msg".equals(command)){
			action = new MessageReportWriteAction();
		} else if("/NormalDelete.msg".equals(command)){
			action = new MessageNormalDeleteAction();
		} else if("/ReportDelete.msg".equals(command)){
			action = new MessageReportDeleteAction();
		} else if("/NormalDetail.msg".equals(command)){
			action = new MessageNormalDetailAction();
		} else if("/ReportDetail.msg".equals(command)){
			action = new MessageReportDetailAction();
		}
		
//		else if("/product_detailView.con".equals(command)) {
//			action = new ProductViewAction();
//		} 
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
