package com.bigdeal.incheonerang.matching.controller;

import com.bigdeal.incheonerang.common.ResponseDTO;
import com.bigdeal.incheonerang.matching.dto.LocationDTO;
import com.bigdeal.incheonerang.matching.dto.MatchingDTO;
import com.bigdeal.incheonerang.matching.dto.MatchingMemberDTO;
import com.bigdeal.incheonerang.matching.service.MatchingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/matching")
public class MatchingController {

    private final MatchingService matchingService;
    public MatchingController(MatchingService matchingService) {this.matchingService = matchingService;}

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> matchingList(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "매칭게시판 조회 성공", matchingService.selectMatchingList()));
    }

    @GetMapping("/location/select/last")
    public ResponseEntity<ResponseDTO> selectLocationLast(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "마지막 게시물 조회 성공", matchingService.selectLocationLast()));
    }

    @GetMapping("/select/{matchingCode}")
    public ResponseEntity<ResponseDTO> selectMatching(@PathVariable int matchingCode ){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "코드번호 게시물 조회 성공", matchingService.selectMatchingByCode(matchingCode)));
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertMatching(@RequestBody MatchingDTO matchingDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"매칭게시판 작성 성공", matchingService.insertMatching(matchingDTO)));
    }
    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateMatching(@RequestBody MatchingDTO matchingDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"매칭게시판 수정 성공", matchingService.updateMatching(matchingDTO)));
    }
    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteMatching(@RequestBody MatchingDTO matchingDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"매칭게시판 삭제 성공", matchingService.deleteMatching(matchingDTO)));
    }

    // ---------- 매칭 참여하기 ----------------
    @PostMapping("/join")
    public ResponseEntity<ResponseDTO> joinMatching(@RequestBody MatchingMemberDTO matchingMemberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"매칭 완료 여부", matchingService.joinMatching(matchingMemberDTO)));
        //matchingCode와 memberId를 보내줘야함
    }
    @PostMapping("/join/delete")
    public ResponseEntity<ResponseDTO> deletejoinMatching(@RequestBody MatchingMemberDTO matchingMemberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"매칭 완료 여부", matchingService.deletejoinMatching(matchingMemberDTO)));
        //matchingCode와 memberId를 보내줘야함
    }

    // ------------- 장소 등록 -------------------
    @GetMapping("/location")
    public ResponseEntity<ResponseDTO> selectLocationList(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전체 장소 조회 성공", matchingService.selectLocationList()));
    }

    @GetMapping("/location/{matchingCode}")
    public ResponseEntity<ResponseDTO> selectLocationListByMatchingCode(@PathVariable int matchingCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "입력된 장소 조회 성공", matchingService.selectLocationListByMatchingCode(matchingCode)));
    }
    @PostMapping("/location")
    public ResponseEntity<ResponseDTO> updateLocation(@RequestBody LocationDTO locationDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"장소 등록 성공", matchingService.updateLocation(locationDTO)));
    }
    @GetMapping("/location/rank")
    public ResponseEntity<ResponseDTO> selectLocationRank(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "장소 순위 조회 성공", matchingService.selectLocationRank()));
    }

//    ------------- 검색 기능 --------------
    @GetMapping("/search/category/{category}")
    public ResponseEntity<ResponseDTO> searchMatchingByCategory(@PathVariable String category) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"(카테고리) 매칭 검색 성공", matchingService.searchMatchingByCategory(category)));
    }
    @GetMapping("/search/title/{title}")
    public ResponseEntity<ResponseDTO> searchMatchingByTitle(@PathVariable String title) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"(제목) 매칭 검색 성공", matchingService.searchMatchingByTitle(title)));
    }
    @GetMapping("/search/hashtag/{hashtag}")
    public ResponseEntity<ResponseDTO> searchMatchingByHastag(@PathVariable String hashtag) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"(해시태그) 매칭 검색 성공", matchingService.searchMatchingByHashtag(hashtag)));
    }

    //마이페이지를 위해 특정 id가 작성한 게시물의 수 count하기
    @GetMapping("/select/count/{memberId}")
    public ResponseEntity<ResponseDTO> selectMatchingCount(@PathVariable String memberId ){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "게시물 작성 수 조회 성공", matchingService.selectMatchingCount(memberId)));
    }



}
