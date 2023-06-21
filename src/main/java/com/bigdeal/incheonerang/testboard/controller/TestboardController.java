package com.bigdeal.incheonerang.testboard.controller;

import com.bigdeal.incheonerang.common.ResponseDTO;
import com.bigdeal.incheonerang.testboard.dto.TestboardDTO;
import com.bigdeal.incheonerang.testboard.service.TestboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testboard")
public class TestboardController {

    private final TestboardService testboardService;
    public TestboardController(TestboardService testboardService) {this.testboardService = testboardService;}

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> testboardList(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "테스트보드 조회 성공", testboardService.selectTestboardList()));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertNotice(@RequestBody TestboardDTO testboardDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"테스트보드 작성 성공", testboardService.insertTestboard(testboardDTO)));
        //noticeTitle, noticeContent 넘겨주기
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateNotice(@RequestBody TestboardDTO testboardDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"테스트보드 수정 성공", testboardService.updateTestboard(testboardDTO)));
        //작성 정보(수정된 정보 포함)와 추가로 noticeCode를 넘겨주어야함.
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteNotice(@RequestBody TestboardDTO testboardDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"테스트보드 삭제 성공", testboardService.deleteTestboard(testboardDTO)));
        //noticeCode만 넘겨주면 됨
    }
}
