package co.kiw.notice.vo;

import java.sql.Date;

public class NoticeVo {
   private int noticeId;
   private String noticeWriter;
   private String noticeTitle;
   private String noticeContent;
   private int noticeHit;
   private Date noticeDate;
   private String noticeAttach;
   /**
    * @return the notiveAttatch
    */
   public String getNoticeAttach() {
      return noticeAttach;
   }
   /**
    * @param notiveAttatch the notiveAttatch to set
    */
   public void setNoticeAttach(String noticeAttach) {
      this.noticeAttach = noticeAttach;
   }
   /**
    * @return the noticeId
    */
   public int getNoticeId() {
      return noticeId;
   }
   /**
    * @param noticeId the noticeId to set
    */
   public void setNoticeId(int noticeId) {
      this.noticeId = noticeId;
   }
   /**
    * @return the noticeWriter
    */
   public String getNoticeWriter() {
      return noticeWriter;
   }
   /**
    * @param noticeWriter the noticeWriter to set
    */
   public void setNoticeWriter(String noticeWriter) {
      this.noticeWriter = noticeWriter;
   }
   /**
    * @return the noticeTitle
    */
   public String getNoticeTitle() {
      return noticeTitle;
   }
   /**
    * @param noticeTitle the noticeTitle to set
    */
   public void setNoticeTitle(String noticeTitle) {
      this.noticeTitle = noticeTitle;
   }
   /**
    * @return the noticeContent
    */
   public String getNoticeContent() {
      return noticeContent;
   }
   /**
    * @param noticeContent the noticeContent to set
    */
   public void setNoticeContent(String noticeContent) {
      this.noticeContent = noticeContent;
   }
   /**
    * @return the noticeHit
    */
   public int getNoticeHit() {
      return noticeHit;
   }
   /**
    * @param noticeHit the noticeHit to set
    */
   public void setNoticeHit(int noticeHit) {
      this.noticeHit = noticeHit;
   }
   /**
    * @return the notiveDate
    */
   public Date getNoticeDate() {
      return noticeDate;
   }
   /**
    * @param notiveDate the notiveDate to set
    */
   public void setNoticeDate(Date noticeDate) {
      this.noticeDate = noticeDate;
   }
   
   
}