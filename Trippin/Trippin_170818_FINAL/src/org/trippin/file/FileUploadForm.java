package org.trippin.file;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadForm {
	public HashMap<String, String> getParams(HttpServletRequest req, HttpServletResponse resp, String saveFolder) {
		HashMap<String, String> inputParams = new HashMap<String, String>();
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		ServletContext ctx = req.getServletContext();
		String path = req.getSession().getServletContext().getRealPath(saveFolder);
		String realFolder = ctx.getRealPath("/") + saveFolder;
		try {
			MultipartRequest multi = new MultipartRequest(req,path,maxSize,encType,new DefaultFileRenamePolicy());
			Enumeration params = multi.getParameterNames();
			while(params.hasMoreElements()) {
				String name = (String)params.nextElement();
				String value = multi.getParameter(name);
				inputParams.put(name, value);
			}
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				String fileName = multi.getFilesystemName(name);
				inputParams.put(name, fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputParams;
	}
}
