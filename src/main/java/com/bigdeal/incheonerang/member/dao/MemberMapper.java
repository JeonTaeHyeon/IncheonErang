package com.bigdeal.incheonerang.member.dao;

import com.bigdeal.incheonerang.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectMemberList();

    int insertMember(MemberDTO memberDTO);

    int updateMember(MemberDTO memberDTO);

    int deleteMember(MemberDTO memberDTO);

    String login(MemberDTO memberDTO);

    List<MemberDTO> selectmemberInfoByCode(String memberId);
}
