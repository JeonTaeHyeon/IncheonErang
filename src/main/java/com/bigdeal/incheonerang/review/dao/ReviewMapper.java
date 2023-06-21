package com.bigdeal.incheonerang.review.dao;

import com.bigdeal.incheonerang.review.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> selectReviewList();

    int insertReview(ReviewDTO reviewDTO);

    int updateReview(ReviewDTO reviewDTO);

    int deleteReview(ReviewDTO reviewDTO);
}
