package com.bigdeal.incheonerang.member.dto;

public class MemberDTO {

     private int memberCode;
     private String memberId;
     private String memberPassword;
     private String memberPhone;
     private String memberEmail;
     private String memberAddress;
     private String memberNation;
     private String memberBirth;
     private String memberGender;
     private String memberLanguageAbility;

     public MemberDTO() {}

     public MemberDTO(int memberCode, String memberId, String memberPassword,
                      String memberPhone, String memberEmail, String memberAddress,
                      String memberNation, String memberBirth, String memberGender,
                      String memberLanguageAbility) {
          this.memberCode = memberCode;
          this.memberId = memberId;
          this.memberPassword = memberPassword;
          this.memberPhone = memberPhone;
          this.memberEmail = memberEmail;
          this.memberAddress = memberAddress;
          this.memberNation = memberNation;
          this.memberBirth = memberBirth;
          this.memberGender = memberGender;
          this.memberLanguageAbility = memberLanguageAbility;
     }

     @Override
     public String toString() {
          return "MemberDTO{" +
                  "memberCode=" + memberCode +
                  ", memberId='" + memberId + '\'' +
                  ", memberPassword='" + memberPassword + '\'' +
                  ", memberPhone='" + memberPhone + '\'' +
                  ", memberEmail='" + memberEmail + '\'' +
                  ", memberAddress='" + memberAddress + '\'' +
                  ", memberNation='" + memberNation + '\'' +
                  ", memberBirth='" + memberBirth + '\'' +
                  ", memberGender='" + memberGender + '\'' +
                  ", memberLanguageAbility='" + memberLanguageAbility + '\'' +
                  '}';
     }

     public int getMemberCode() {
          return memberCode;
     }

     public void setMemberCode(int memberCode) {
          this.memberCode = memberCode;
     }

     public String getMemberId() {
          return memberId;
     }

     public void setMemberId(String memberId) {
          this.memberId = memberId;
     }

     public String getMemberPassword() {
          return memberPassword;
     }

     public void setMemberPassword(String memberPassword) {
          this.memberPassword = memberPassword;
     }

     public String getMemberPhone() {
          return memberPhone;
     }

     public void setMemberPhone(String memberPhone) {
          this.memberPhone = memberPhone;
     }

     public String getMemberEmail() {
          return memberEmail;
     }

     public void setMemberEmail(String memberEmail) {
          this.memberEmail = memberEmail;
     }

     public String getMemberAddress() {
          return memberAddress;
     }

     public void setMemberAddress(String memberAddress) {
          this.memberAddress = memberAddress;
     }

     public String getMemberNation() {
          return memberNation;
     }

     public void setMemberNation(String memberNation) {
          this.memberNation = memberNation;
     }

     public String getMemberBirth() {
          return memberBirth;
     }

     public void setMemberBirth(String memberBirth) {
          this.memberBirth = memberBirth;
     }

     public String getMemberGender() {
          return memberGender;
     }

     public void setMemberGender(String memberGender) {
          this.memberGender = memberGender;
     }

     public String getMemberLanguageAbility() {
          return memberLanguageAbility;
     }

     public void setMemberLanguageAbility(String memberLanguageAbility) {
          this.memberLanguageAbility = memberLanguageAbility;
     }
}