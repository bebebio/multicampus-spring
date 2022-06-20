package vo;

import java.util.List;

public class MemberListVo extends CommonVo {
	
	private List<MemberVo> memberList;
	
	public List<MemberVo> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberVo> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "MemberListVo [memberList=" + memberList + "]";
	}
	
}
