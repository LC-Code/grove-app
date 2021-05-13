package com.example.groveapp.appointment.entiry;

import com.example.groveapp.depart.entiry.GoveDepart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "appointment_item")
@JsonIgnoreProperties(value = {"depart","appointment"})
public class AppointmentItem implements Serializable {



   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;*/
    @Id
    @GenericGenerator(name = "code_uuid",strategy = "uuid")
    @GeneratedValue(generator = "code_uuid")
    @Column(name = "item_code")
    private String code;

    @Column(name = "item_name")
    @JsonProperty("item_name")
    private String itemName;
    @Column(name = "dispose_type")
    private String disposeType;
    @OneToOne(mappedBy = "item",cascade = CascadeType.MERGE)
    private Appointment appointment;

   @ManyToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "part_code")
    private GoveDepart depart;
   /* @Column(name = "part_code")
    private String part_code;*/
    public AppointmentItem(){};
   public AppointmentItem(String code,String itemName,String disposeType){
       this.code = code;
       this.itemName = itemName;
       this.disposeType = disposeType;
   }


    @Override
    public String toString() {
        return "{'code'="+code+"'itemName'="+itemName+"}";
    }
}
