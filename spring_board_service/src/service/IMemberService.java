package service;

import vo.MemberListVo;
import vo.MemberVo;

public interface IMemberService {
	
	public boolean insertMember(MemberVo vo) throws Exception;
	
	public boolean updateMember(MemberVo vo) throws Exception;
	
	public boolean deleteMember(MemberVo vo) throws Exception;
	
	public MemberVo selectMember(MemberVo vo) throws Exception;
	
	public MemberListVo selectMemberList(MemberVo vo) throws Exception;
	
}
