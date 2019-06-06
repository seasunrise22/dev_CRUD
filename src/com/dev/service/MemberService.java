package com.dev.service;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();

	private MemberService() {} // 생성자를 private으로 선언하여 외부에서 접근할 수 없게 한다는 것은 객체를 생성할 수 없다는 의미.
	
	public static MemberService getInstance() { // MemberService 객체를 외부에서 사용할 수 있도록 하기 위해 선언한 메소드.
		return service; // 외부에서 MemberService 객체를 쓰려면 이 메소드를 통해서 이미 만들어진 단 하나의 MemberService 객체를 가져다가 써야함.
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
}
