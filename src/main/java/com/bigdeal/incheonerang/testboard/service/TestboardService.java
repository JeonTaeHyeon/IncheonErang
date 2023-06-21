package com.bigdeal.incheonerang.testboard.service;

import com.bigdeal.incheonerang.testboard.dao.TestboardMapper;
import com.bigdeal.incheonerang.testboard.dto.TestboardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestboardService {

    private final TestboardMapper testboardMapper;

    public TestboardService(TestboardMapper testboardMapper) {
        this.testboardMapper = testboardMapper;
    }

    public Object selectTestboardList() {
        List<TestboardDTO> testboardList = testboardMapper.selectTestboardList();
        return testboardList;
    }

    public Object insertTestboard(TestboardDTO testboardDTO) {
        int insertNotice = testboardMapper.insertTestboard(testboardDTO);
        return (insertNotice > 0) ? "테스트보드 입력 성공!" : "테스트보드 입력 실패 ㅜ";
    }

    public Object updateTestboard(TestboardDTO testboardDTO) {
        int updateNotice = testboardMapper.updateTestboard(testboardDTO);
        return (updateNotice > 0) ? "테스트보드 수정 성공!" : "테스트보드 수정 실패 ㅜ";
    }

    public Object deleteTestboard(TestboardDTO testboardDTO) {
        int deleteNotice = testboardMapper.deleteTestboard(testboardDTO);
        return (deleteNotice > 0) ? "테스트보드 삭제 성공!" : "테스트보드 삭제 실패 ㅠ";
    }
}
