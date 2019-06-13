package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameter ����
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String path = null;
		
		// ��ȿ�� üũ���� ƨ���� �� �ٽ� �ǵ��� ������ ����
		if(job.equals("search"))
			path = "/memberSearch.jsp";
		else if(job.equals("update"))
			path = "/memberUpdate.jsp";
		else if(job.equals("delete"))
			path = "/memberDelete.jsp";
		
		// ��ȿ�� üũ
		if(id.isEmpty()) {
			request.setAttribute("error", "���� ���� �� �� ID �Է��ض�");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		// Service ��ü�� �޼ҵ� ȣ��
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id); // �Ű������� id�� �˻� �� ValueObject�� MemberVO ��ü ����
		
		// Output View �������� �̵�
		if(member == null) 
			request.setAttribute("result", "�˻��� ������ ���µ�?");
		
		request.setAttribute("member", member);
		
		if(job.equals("search"))
			path = "/result/memberSearchOutput.jsp"; // ����Ϸ�� path ���� �������ؼ� Output �������� �̵���Ŵ 
		
		HttpUtil.forward(request, response, path);	
	}
	
}
