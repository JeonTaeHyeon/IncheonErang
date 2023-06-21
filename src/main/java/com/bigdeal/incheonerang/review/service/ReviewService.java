package com.bigdeal.incheonerang.review.service;

import com.bigdeal.incheonerang.review.dao.ReviewMapper;
import com.bigdeal.incheonerang.review.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public Object selectReviewList() {
        List<ReviewDTO> reviewList = reviewMapper.selectReviewList();
        return reviewList;
    }

    public Object insertReview(ReviewDTO reviewDTO) {
        int insertNotice = reviewMapper.insertReview(reviewDTO);
        return (insertNotice > 0) ? "리뷰 입력 성공!" : "리뷰 입력 실패 ㅜ";
    }

    public Object updateReview(ReviewDTO reviewDTO) {
        int updateNotice = reviewMapper.updateReview(reviewDTO);
        return (updateNotice > 0) ? "리뷰 수정 성공!" : "리뷰 수정 실패 ㅜ";
    }

    public Object deleteReview(ReviewDTO reviewDTO) {
        int deleteNotice = reviewMapper.deleteReview(reviewDTO);
        return (deleteNotice > 0) ? "리뷰 삭제 성공!" : "리뷰 삭제 실패 ㅠ";
    }
}
