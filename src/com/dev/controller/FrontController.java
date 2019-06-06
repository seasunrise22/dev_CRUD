package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;

	/*
	 * init() : Ŭ���̾�Ʈ�κ��� ���ʷ� ������ ȣ��޾��� �� ����Ǵ� �޼ҵ�
	 */
	@Override
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do", new MemberInsertController());
//		list.put("/memberSearch.do", new MemberSearchController());
//		list.put("/memberUpdate.do", new MemberUpdateController());
//		list.put("/memberDelete.do", new MemberDeleteController());
//		list.put("/memberList.do", new MemberListController());
	}

	/*
	 * service() : Ŭ���̾�Ʈ�κ��� ��û�� ���� �� ���� ����Ǵ� �޼ҵ�
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String uri = request.getRequestURI();			// => /dev_CRUD/xxx.do
		String contextPath = request.getContextPath(); 	// => /dev_CRUD
		String path = uri.substring(contextPath.length()); 	// => /xxx.do
		Controller subController = list.get(path);			// => key���� /xxx.do�� HashMap�� Value ��ü
		subController.execute(request, response);		
	}
}
