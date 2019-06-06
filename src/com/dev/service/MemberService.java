package com.dev.service;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();

	private MemberService() {} // �����ڸ� private���� �����Ͽ� �ܺο��� ������ �� ���� �Ѵٴ� ���� ��ü�� ������ �� ���ٴ� �ǹ�.
	
	public static MemberService getInstance() { // MemberService ��ü�� �ܺο��� ����� �� �ֵ��� �ϱ� ���� ������ �޼ҵ�.
		return service; // �ܺο��� MemberService ��ü�� ������ �� �޼ҵ带 ���ؼ� �̹� ������� �� �ϳ��� MemberService ��ü�� �����ٰ� �����.
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
}
