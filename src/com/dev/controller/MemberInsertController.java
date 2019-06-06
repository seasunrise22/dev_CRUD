package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �Ķ���� ����
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		// ��ȿ�� üũ
		if(id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "��� �׸��� �������� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		// VO ��ü�� ������ ���ε�
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		// Service ��ü�� �޼ҵ� ȣ��
		MemberService service = MemberService.getInstance(); // �̱��� ������ �̿��� ��ü ����?
		service.memberInsert(member);
		
		// Output View �������� �̵�
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
	}	

}
