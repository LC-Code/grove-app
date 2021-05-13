package com.example.groveapp.entiry;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.io.Serializable;

/*@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxLoginRespond implements Serializable {
   private String session_key;
   private String opendid;
   private String errcode;
   private String errmsg;

}
