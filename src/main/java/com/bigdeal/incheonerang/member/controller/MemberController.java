package com.bigdeal.incheonerang.member.controller;

import com.bigdeal.incheonerang.common.ResponseDTO;
import com.bigdeal.incheonerang.member.dto.MemberDTO;
import com.bigdeal.incheonerang.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {this.memberService = memberService;}

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> memberList(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "맴버 조회 성공", memberService.selectMemberList()));
    }

    @GetMapping("/select/{memberId}")
    public ResponseEntity<ResponseDTO> selectmemberInfoByCode(@PathVariable String memberId){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "마이페이지 정보 조회 성공", memberService.selectmemberInfoByCode(memberId)));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"맴버 작성 성공", memberService.insertMember(memberDTO)));
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"맴버 수정 성공", memberService.updateMember(memberDTO)));
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"맴버 삭제 성공", memberService.deleteMember(memberDTO)));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"login", memberService.login(memberDTO)));
    }
}
