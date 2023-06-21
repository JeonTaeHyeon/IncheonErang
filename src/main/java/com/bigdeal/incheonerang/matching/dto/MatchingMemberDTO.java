package com.bigdeal.incheonerang.matching.dto;

import java.util.List;

public class MatchingMemberDTO {

    private int matchingCode;
    private String memberId;

    public MatchingMemberDTO() {}

    public MatchingMemberDTO(int matchingCode, String memberId) {
        this.matchingCode = matchingCode;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MatchingMemberDTO{" +
                "matchingCode=" + matchingCode +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    public int getMatchingCode() {
        return matchingCode;
    }

    public void setMatchingCode(int matchingCode) {
        this.matchingCode = matchingCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


}
