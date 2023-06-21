package com.bigdeal.incheonerang.matching.dao;

import com.bigdeal.incheonerang.matching.dto.LocationDTO;
import com.bigdeal.incheonerang.matching.dto.MatchingDTO;
import com.bigdeal.incheonerang.matching.dto.MatchingMemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MatchingMapper {

    List<MatchingDTO> selectMatchingList();

    int insertMatching(MatchingDTO matchingDTO);

    int updateMatching(MatchingDTO matchingDTO);

    int deleteMatching(MatchingDTO matchingDTO);

    List<MatchingDTO> selectMatchingByCode(int matchingCode);

    //참여하기 버튼 눌렀을 때
    int insertJoinMatching(MatchingMemberDTO matchingMemberDTO);

    int updateJoinMatching(MatchingMemberDTO matchingMemberDTO);

    int updateMatchingFinishYn(MatchingMemberDTO matchingMemberDTO);

    String finishMatchingYn(MatchingMemberDTO matchingMemberDTO);

    int insertLocation(LocationDTO locationDTO);

    List<LocationDTO> selectLocationList();

    int countLocation(LocationDTO locationDTO);

    List<LocationDTO> selectLocationRank();

    List<MatchingDTO> searchMatchingByCategory(String category);

    List<MatchingDTO> searchMatchingByTitle(String title);

    List<MatchingDTO> searchMatchingByHashtag(String hashtag);

    List<MatchingMemberDTO> selectMatchingMemberByCode(MatchingMemberDTO matchingMemberDTO);

    int minusCurrentMatchingMember(MatchingMemberDTO matchingMemberDTO);

    int deleteMatchingMember(MatchingMemberDTO matchingMemberDTO);

    List<MatchingDTO> selectMatchingListByMemberId(String memberId);

    List<LocationDTO> selectLocationListByMatchingCode(int matchingCode);

    List<MatchingDTO> selectLocationLast();

    List<MatchingDTO> selectMatchingCodeForInsert(MatchingDTO matchingDTO);
}
