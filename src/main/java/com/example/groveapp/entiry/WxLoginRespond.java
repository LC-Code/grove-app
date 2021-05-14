package com.example.groveapp.entiry;

import lombok.*;

/*@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor*/
@Data
public class WxLoginRespond {
   private String session_key;
   private String opendid;
   private String errcode;
   private String errmsg;

   public WxLoginRespond(String session_key,String opendid ){
      this.session_key = session_key;
      this.opendid = opendid;
      this.errcode = null;
      this.errmsg = null;
   }



}
