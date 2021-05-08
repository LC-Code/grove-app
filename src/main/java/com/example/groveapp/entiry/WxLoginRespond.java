package com.example.groveapp.entiry;

import lombok.*;

/*@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxLoginRespond {
   private String session_key;
   private String opendid;

}
