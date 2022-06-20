package dao;

import java.util.List;

import vo.MemberVo;

public interface IMemberDao {
	
	public int insert(MemberVo vo) throws Exception;
	
	public int update(MemberVo vo) throws Exception;
	
	public int delete(MemberVo vo) throws Exception;
	
	public MemberVo selectOne(MemberVo vo) throws Exception;
	
	public List<MemberVo> selectList(MemberVo vo) throws Exception;
	
	public int selectTotalCount(MemberVo vo) throws Exception;
	
}
