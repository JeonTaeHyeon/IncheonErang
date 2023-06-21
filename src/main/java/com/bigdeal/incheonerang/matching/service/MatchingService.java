package com.bigdeal.incheonerang.matching.service;

import com.bigdeal.incheonerang.matching.dao.MatchingMapper;
import com.bigdeal.incheonerang.matching.dto.LocationDTO;
import com.bigdeal.incheonerang.matching.dto.MatchingDTO;
import com.bigdeal.incheonerang.matching.dto.MatchingMemberDTO;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MatchingService {

    private final MatchingMapper matchingMapper;

    public MatchingService(MatchingMapper matchingMapper) {
        this.matchingMapper = matchingMapper;
    }

    public Object selectMatchingList() {
        List<MatchingDTO> matchingList = matchingMapper.selectMatchingList();
        int length = matchingList.size();
        for(int i = 0; i < length; i++)
        {
            Date matchingDate = matchingList.get(i).getMatchingDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            String formatMatchingDate = simpleDateFormat.format(matchingDate);
            //format한 date는 String이므로 string타입의 컬럼에 담아 저장함
//            String [] dateArr;
//            dateArr = new String[length];
//            dateArr[i] = formatMatchingDate;
            matchingList.get(i).setMatchingFormatDate(formatMatchingDate);
        }

        return matchingList;
    }

    public Object insertMatching(MatchingDTO matchingDTO) {

        int insertMatching = matchingMapper.insertMatching(matchingDTO);

        List<MatchingDTO> selectMatchingCodeForInsert = matchingMapper.selectMatchingCodeForInsert(matchingDTO);
        int code = selectMatchingCodeForInsert.get(0).getMatchingCode();

        System.out.println("제발베ㅔ제렞렞렞레 : "+ code );

        return code;
    }

    public Object updateMatching(MatchingDTO matchingDTO) {
        int updateMatching = matchingMapper.updateMatching(matchingDTO);
        return (updateMatching > 0) ? "매칭게시판 수정 성공!" : "매칭게시판 수정 실패 ㅜ";
    }

    public Object deleteMatching(MatchingDTO matchingDTO) {
        int deleteMatching = matchingMapper.deleteMatching(matchingDTO);
        return (deleteMatching > 0) ? "매칭게시판 삭제 성공!" : "매칭게시판 삭제 실패 ㅠ";
    }

    public Object selectMatchingByCode(int matchingCode) {
        List<MatchingDTO> selectMatchingByCode = matchingMapper.selectMatchingByCode(matchingCode);
        Date matchingDate = selectMatchingByCode.get(0).getMatchingDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
        String formatMatchingDate = simpleDateFormat.format(matchingDate);
        return selectMatchingByCode;
    }

    //신청하기
    public String joinMatching(MatchingMemberDTO matchingMemberDTO) {

        //매칭참여하기를 누른 게시물코드에 따른 (게시물코드, 멤버아이디) 조회 -> 한 게시물에 여러 맴버 아이디가 있을것.
        List<MatchingMemberDTO> selectMatchingMemberByCode = matchingMapper.selectMatchingMemberByCode(matchingMemberDTO);

        //신청하기를 누른 적이 있는 사람인가?
        //->이미 신청하기를 누르셨습니다. 취소하시겠습니까?
        //->신청하기 flow진행

        int length = selectMatchingMemberByCode.size();

        System.out.println( "리스트 길이 !! " + length);

        for( int i =0; i<length; i++){

            String joinedMemberId = selectMatchingMemberByCode.get(i).getMemberId();
            String memberId = matchingMemberDTO.getMemberId();

            System.out.println("joinedMemberId ::: " + joinedMemberId);
            System.out.println("memberId ::: " + memberId);

            if(joinedMemberId.equals(memberId))
            {
                return "이미신청함";
            }
        }

        //신청한 멤버의 정보를 받아와서 mapper에 넘겨주고 데이터베이스에서 처리
        //matching-member 테이블에 insert
        //matching테이블에서 참여 인원 증가 update, 만약 최대 인원이 넘었으면 finishYn에서 Y로 변경한 값 리턴

        // 0. 게시물이 완료 되었는지 여부 확인을 우선으로 함.
        List<MatchingDTO> selectMatchingByCode = matchingMapper.selectMatchingByCode(matchingMemberDTO.getMatchingCode());
        String checkMatchingMemberCount = selectMatchingByCode.get(0).getMatchingFinishYn();

        String Y = "N";

        // matching테이블에서 현재인원이 최대인원보다 작은지 확인
        if(checkMatchingMemberCount.equals(Y))
        {
            // 1. matching-member테이블에 matchingCode와 memberId(insert)저장하기
            int insertJoinMatching = matchingMapper.insertJoinMatching(matchingMemberDTO);
            System.out.println(insertJoinMatching>0 ? "join insert 성공" : "join insert 실패");

            // 2. matching테이블에 (update) 현재 인원 수 증가하기
            int updateJoinMatching = matchingMapper.updateJoinMatching(matchingMemberDTO);
            System.out.println(updateJoinMatching>=0 ? "join update 성공" : "join update 실패");

            // 3. matching 테이블에서 최대인원 = 현재 인원이면 finishYn Y로 업데이트하기
            int updateMatchingFinishYn = matchingMapper.updateMatchingFinishYn(matchingMemberDTO);
            System.out.println(updateMatchingFinishYn>0 ? "join update YN성공" : "join update YN실패");

            // 4. matching 테이블에서 finishYn 값 (select)조회하기
            String finishYn = matchingMapper.finishMatchingYn(matchingMemberDTO);

            // 5. finishYn 값 리턴하기
            return finishYn;
        }
        else{ return "이미끝남"; }
    }

    public Object deletejoinMatching(MatchingMemberDTO matchingMemberDTO) {
        //매칭게시물 테이블에서 currentMember숫자 하나 줄이기
        //매칭-맴버 테이블에서 데이터 삭제하기
        int minusCurrentMatchingMember = matchingMapper.minusCurrentMatchingMember(matchingMemberDTO);
        int deleteMatchingMember = matchingMapper.deleteMatchingMember(matchingMemberDTO);

        return "매칭취소";
    }

    //장소 등록
    public Object selectLocationList() {
        List<LocationDTO> locationList = matchingMapper.selectLocationList();
        return locationList;
    }

    public Object updateLocation(LocationDTO locationDTO) {
        //만약 이미 있는 장소라면 count를 증가시키고 (띄어쓰기를 무시해야함)
        //System.out.println("공백제거 ==>[" + str.replaceAll(" ",  "") + "]");
        //없는 장소라면 insert를 진행함.

        // 1. 이미 등록된 장소인지 확인하기 -> 전체 테이블을 조회하고 일치하는지 확인하기
        List<LocationDTO> locationList = matchingMapper.selectLocationList();
        System.out.println("=== 장소 테이블 조회 === :: " + locationList);

        int length = locationList.size();
        System.out.println("리스트의 크기 :: " + length);

        int countLocation = 0;
        int insertLocation = 0;
        int count = 0;

        for(int i = 0; i < length; i++)
        {


            String place = locationList.get(i).getLocationName().replaceAll(" ", "");
            String newplace = locationDTO.getLocationName().replaceAll(" ", "");

            if(place.equals(newplace)){
                //count증가
                countLocation = matchingMapper.countLocation(locationDTO);
                System.out.println(countLocation>0 ? "count증가 성공" : "count증가 실패");
                break;
            }

            count++;
            System.out.println("count : " + count);
            System.out.println("length : " + length);

            if(count == length)
            {
                //location name insert
                insertLocation = matchingMapper.insertLocation(locationDTO);
                System.out.println(insertLocation>0 ? "장소 등록 성공" : "장소 등록 실패");
            }
        }

        if(countLocation>0){
            return "count증가 성공";
        }else if(insertLocation>0){
            return "장소 등록 성공";
        }

        return 0;
    }

    public Object selectLocationRank() {
        List<LocationDTO> locationRank = matchingMapper.selectLocationRank();
        return locationRank;
    }

//    검색 기능
    public Object searchMatchingByCategory(String category) {
        List<MatchingDTO> searchMatchingByCategory = matchingMapper.searchMatchingByCategory(category);

        int length = searchMatchingByCategory.size();

        for(int i = 0; i<length; i++){
            Date matchingDate = searchMatchingByCategory.get(i).getMatchingDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            String formatMatchingDate = simpleDateFormat.format(matchingDate);
            searchMatchingByCategory.get(i).setMatchingFormatDate(formatMatchingDate);
        }

        return searchMatchingByCategory;
    }

    public Object searchMatchingByTitle(String title) {
        List<MatchingDTO> searchMatchingByTitle = matchingMapper.searchMatchingByTitle(title);

        int length = searchMatchingByTitle.size();

        for(int i = 0; i<length; i++){
            Date matchingDate = searchMatchingByTitle.get(i).getMatchingDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            String formatMatchingDate = simpleDateFormat.format(matchingDate);
            searchMatchingByTitle.get(i).setMatchingFormatDate(formatMatchingDate);
        }
        return searchMatchingByTitle;
    }

    public Object searchMatchingByHashtag(String hashtag) {
        List<MatchingDTO> searchMatchingByHashtag = matchingMapper.searchMatchingByHashtag(hashtag);

        int length = searchMatchingByHashtag.size();

        for(int i = 0; i<length; i++){
            Date matchingDate = searchMatchingByHashtag.get(i).getMatchingDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            String formatMatchingDate = simpleDateFormat.format(matchingDate);
            searchMatchingByHashtag.get(i).setMatchingFormatDate(formatMatchingDate);
        }
        return searchMatchingByHashtag;
    }

    public Object selectMatchingCount(String memberId) {

        List<MatchingDTO> selectMatchingListByMemberId = matchingMapper.selectMatchingListByMemberId(memberId);
        int selectMatchingCount = selectMatchingListByMemberId.size();
        System.out.println("특정 아이디가 작성한 게시물 횟수 :: " +  selectMatchingCount);

        return selectMatchingCount;
    }

    public Object selectLocationListByMatchingCode(int matchingCode) {
        List<LocationDTO> selectLocationListByMatchingCode = matchingMapper.selectLocationListByMatchingCode(matchingCode);
        return selectLocationListByMatchingCode;
    }

    public Object selectLocationLast() {

        List<MatchingDTO> lastMatchingCode = matchingMapper.selectLocationLast();
        int code = lastMatchingCode.get(0).getMatchingCode();
        return code+1;
    }
}
