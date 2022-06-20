package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMemberDao;
import service.IMemberService;
import vo.MemberListVo;
import vo.MemberVo;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberDao memberDao;
	
	@Override
	public boolean insertMember(MemberVo vo) throws Exception {
		int insertResult = memberDao.insert(vo);
		System.out.println("- insertResult : " + insertResult);
		
		// https://programmer93.tistory.com/75
		if(true) {
			int temp = 1 / 0;
		}
		
		return insertResult > 0 ? true : false;
	}

	@Override
	public boolean updateMember(MemberVo vo) throws Exception {
		return memberDao.update(vo) > 0 ? true : false;
	}

	@Override
	public boolean deleteMember(MemberVo vo) throws Exception {
		return memberDao.delete(vo) > 0 ? true : false;
	}

	@Override
	public MemberVo selectMember(MemberVo vo) throws Exception {
		return memberDao.selectOne(vo);
	}

	@Override
	public MemberListVo selectMemberList(MemberVo vo) throws Exception {		
		int pageTotalCount = memberDao.selectTotalCount(vo);
		List<MemberVo> memberList = memberDao.selectList(vo);
		
		int pageIndex = vo.getPageIndex();
		int pageSize = vo.getPageSize();
		
		// 페이지 처리
		int pageFirst = 1;
		int pageBegin = (pageIndex - 1) / pageSize * pageSize  + 1;
		int pageEnd = ((pageIndex - 1) / pageSize + 1) * pageSize;
		int pageLast = (memberDao.selectTotalCount(vo) - 1) / pageSize + 1;
		pageEnd = pageEnd > pageLast ? pageLast : pageEnd; // 끝 페이지 검증 
		
		MemberListVo memberListVo = new MemberListVo();
		memberListVo.setPageIndex(pageIndex);
		memberListVo.setPageSize(pageSize);
		memberListVo.setPageFirst(pageFirst);
		memberListVo.setPageBegin(pageBegin);
		memberListVo.setPageEnd(pageEnd);
		memberListVo.setPageLast(pageLast);
		memberListVo.setPageTotalCount(pageTotalCount);
		memberListVo.setMemberList(memberList);
		
		return memberListVo;
	}
	
}
