package com.bigdeal.incheonerang.member.service;

import com.bigdeal.incheonerang.matching.dto.MatchingDTO;
import com.bigdeal.incheonerang.member.dao.MemberMapper;
import com.bigdeal.incheonerang.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Object selectMemberList() {
        List<MemberDTO> memberList = memberMapper.selectMemberList();
        return memberList;
    }

    public Object insertMember(MemberDTO memberDTO) {
        int insertMember = memberMapper.insertMember(memberDTO);
        return (insertMember > 0) ? "맴버 입력 성공!" : "맴버 입력 실패 ㅜ";
    }

    public Object updateMember(MemberDTO memberDTO) {
        int updateMember = memberMapper.updateMember(memberDTO);
        return (updateMember > 0) ? "맴버 수정 성공!" : "맴버 수정 실패 ㅜ";
    }

    public Object deleteMember(MemberDTO memberDTO) {
        int deleteMember = memberMapper.deleteMember(memberDTO);
        return (deleteMember > 0) ? "맴버 삭제 성공!" : "맴버 삭제 실패 ㅠ";
    }

    public String login(MemberDTO memberDTO) {
        String memberCode = memberMapper.login(memberDTO);
        return memberCode;
    }

    public Object selectmemberInfoByCode(String memberId) {
        List<MemberDTO> selectmemberInfoByCode = memberMapper.selectmemberInfoByCode(memberId);
        return selectmemberInfoByCode;
    }
}
