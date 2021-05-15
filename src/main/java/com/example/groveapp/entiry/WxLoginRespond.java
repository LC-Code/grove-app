package com.example.groveapp.entiry;

import lombok.*;

import java.io.Serializable;

/*@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor*/
@Data
public class WxLoginRespond implements Serializable {
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
