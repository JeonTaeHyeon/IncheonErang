package com.bigdeal.incheonerang.testboard.dao;

import com.bigdeal.incheonerang.testboard.dto.TestboardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestboardMapper {
    List<TestboardDTO> selectTestboardList();

    int insertTestboard(TestboardDTO testboardDTO);

    int updateTestboard(TestboardDTO testboardDTO);

    int deleteTestboard(TestboardDTO testboardDTO);
}
