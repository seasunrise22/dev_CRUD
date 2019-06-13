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
		// Parameter 추출
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String path = null;
		
		// 유효성 체크에서 튕겼을 때 다시 되돌릴 페이지 저장
		if(job.equals("search"))
			path = "/memberSearch.jsp";
		else if(job.equals("update"))
			path = "/memberUpdate.jsp";
		else if(job.equals("delete"))
			path = "/memberDelete.jsp";
		
		// 유효성 체크
		if(id.isEmpty()) {
			request.setAttribute("error", "좋은 말로 할 때 ID 입력해라");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		// Service 객체의 메소드 호출
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id); // 매개변수의 id로 검색 후 ValueObject인 MemberVO 객체 받음
		
		// Output View 페이지로 이동
		if(member == null) 
			request.setAttribute("result", "검색된 정보가 없는데?");
		
		request.setAttribute("member", member);
		
		if(job.equals("search"))
			path = "/result/memberSearchOutput.jsp"; // 정상완료면 path 변수 재지정해서 Output 페이지로 이동시킴 
		
		HttpUtil.forward(request, response, path);	
	}
	
}
