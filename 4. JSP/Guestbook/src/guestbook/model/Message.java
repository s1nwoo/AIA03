package guestbook.model;

public class Message {
   
   private int mid; //이 메세지 객체를 받을 때도 쓸건데 DB에서 가져올 때도 쓸거여서다. 
   private String uname; 
   private String pw; 
   private String message;
  
   public Message(int mid, String uname, String pw, String message) {
      super();
      this.mid = mid;
      this.uname = uname;
      this.pw = pw;
      this.message = message;
   }
   public Message() {
      super();

   }
   public int getMid() {
      return mid;
   }
   public void setMid(int mid) {
      this.mid = mid;
   }
   public String getUname() {
      return uname;
   }
   public void setUname(String uname) {
      this.uname = uname;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
   @Override
   public String toString() {
      return "Message [mid=" + mid + ", uname=" + uname + ", pw=" + pw + ", message=" + message + "]";
   }
   

   

}