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
	
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id); // DB���� id�� �˻��� ����� MemverVO(ValueObject)���·� �޾Ƽ� ����
		return member;
	}
	
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member); // db�� ȸ������ ���� ���� ���� �޼ҵ�� memberVO ��ü�� ����
	}
}
