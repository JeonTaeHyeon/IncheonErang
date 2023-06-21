package com.bigdeal.incheonerang.matching.dto;

import java.util.Date;
public class MatchingDTO {

     private int matchingCode;
     private String matchingTitle;
     private String matchingContent;
     private String matchingHashtag;
     private String matchingMemberId;
     private Date matchingDate;
     private String matchingFinishYn;
     private String matchingImg;
     private String matchingMaxMember;
     private String matchingCurrentMember;
     private String matchingCategory;
     private String matchingFormatDate;

     public  MatchingDTO() {}

     public MatchingDTO(int matchingCode, String matchingTitle, String matchingContent, String matchingHashtag,
                        String matchingMemberId, Date matchingDate, String matchingFinishYn, String matchingImg,
                        String matchingMaxMember, String matchingCurrentMember, String matchingCategory,
                        String matchingFormatDate) {
          this.matchingCode = matchingCode;
          this.matchingTitle = matchingTitle;
          this.matchingContent = matchingContent;
          this.matchingHashtag = matchingHashtag;
          this.matchingMemberId = matchingMemberId;
          this.matchingDate = matchingDate;
          this.matchingFinishYn = matchingFinishYn;
          this.matchingImg = matchingImg;
          this.matchingMaxMember = matchingMaxMember;
          this.matchingCurrentMember = matchingCurrentMember;
          this.matchingCategory = matchingCategory;
          this.matchingFormatDate = matchingFormatDate;
     }

     @Override
     public String toString() {
          return "MatchingDTO{" +
                  "matchingCode=" + matchingCode +
                  ", matchingTitle='" + matchingTitle + '\'' +
                  ", matchingContent='" + matchingContent + '\'' +
                  ", matchingHashtag='" + matchingHashtag + '\'' +
                  ", matchingMemberId='" + matchingMemberId + '\'' +
                  ", matchingDate=" + matchingDate +
                  ", matchingFinishYn='" + matchingFinishYn + '\'' +
                  ", matchingImg='" + matchingImg + '\'' +
                  ", matchingMaxMember='" + matchingMaxMember + '\'' +
                  ", matchingCurrentMember='" + matchingCurrentMember + '\'' +
                  ", matchingCategory='" + matchingCategory + '\'' +
                  ", matchingFormatDate='" + matchingFormatDate + '\'' +
                  '}';
     }

     public int getMatchingCode() {
          return matchingCode;
     }

     public void setMatchingCode(int matchingCode) {
          this.matchingCode = matchingCode;
     }

     public String getMatchingTitle() {
          return matchingTitle;
     }

     public void setMatchingTitle(String matchingTitle) {
          this.matchingTitle = matchingTitle;
     }

     public String getMatchingContent() {
          return matchingContent;
     }

     public void setMatchingContent(String matchingContent) {
          this.matchingContent = matchingContent;
     }

     public String getMatchingHashtag() {
          return matchingHashtag;
     }

     public void setMatchingHashtag(String matchingHashtag) {
          this.matchingHashtag = matchingHashtag;
     }

     public String getMatchingMemberId() {
          return matchingMemberId;
     }

     public void setMatchingMemberId(String matchingMemberId) {
          this.matchingMemberId = matchingMemberId;
     }

     public Date getMatchingDate() {
          return matchingDate;
     }

     public void setMatchingDate(Date matchingDate) {
          this.matchingDate = matchingDate;
     }

     public String getMatchingFinishYn() {
          return matchingFinishYn;
     }

     public void setMatchingFinishYn(String matchingFinishYn) {
          this.matchingFinishYn = matchingFinishYn;
     }

     public String getMatchingImg() {
          return matchingImg;
     }

     public void setMatchingImg(String matchingImg) {
          this.matchingImg = matchingImg;
     }

     public String getMatchingMaxMember() {
          return matchingMaxMember;
     }

     public void setMatchingMaxMember(String matchingMaxMember) {
          this.matchingMaxMember = matchingMaxMember;
     }

     public String getMatchingCurrentMember() {
          return matchingCurrentMember;
     }

     public void setMatchingCurrentMember(String matchingCurrentMember) {
          this.matchingCurrentMember = matchingCurrentMember;
     }

     public String getMatchingCategory() {
          return matchingCategory;
     }

     public void setMatchingCategory(String matchingCategory) {
          this.matchingCategory = matchingCategory;
     }

     public String getMatchingFormatDate() {
          return matchingFormatDate;
     }

     public void setMatchingFormatDate(String matchingFormatDate) {
          this.matchingFormatDate = matchingFormatDate;
     }
}