package com.bigdeal.incheonerang.review.dto;

import java.util.Date;

public class ReviewDTO {

    private int reviewCode;
    private String reviewTitle;
    private String reviewContent;
    private String reviewMemberId;
    private Date reviewDate;

    public ReviewDTO() {}

    public ReviewDTO(int reviewCode, String reviewTitle, String reviewContent, String reviewMemberId, Date reviewDate) {
        this.reviewCode = reviewCode;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.reviewMemberId = reviewMemberId;
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewCode=" + reviewCode +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewMemberId='" + reviewMemberId + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }

    public int getReviewCode() {
        return reviewCode;
    }

    public void setReviewCode(int reviewCode) {
        this.reviewCode = reviewCode;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewMemberId() {
        return reviewMemberId;
    }

    public void setReviewMemberId(String reviewMemberId) {
        this.reviewMemberId = reviewMemberId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}