package com.example.groveapp.depart.entiry;

import com.example.groveapp.appointment.entiry.AppointmentItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "gove_part")
@JsonIgnoreProperties(value = {"items"})
public class GoveDepart implements Serializable {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;*/
    @Id
   /* @GenericGenerator(name = "code_uuid",strategy = "")
    @GeneratedValue(generator = "code_uuid")*/
    @Column(name = "part_code")
    @JsonProperty("code")
    private String part_code;

    @Column(name = "part_name")
    @JsonProperty("name")
    private String part_name;

    @JsonIgnore
    @Column(name = "part_power")
    private String part_power;

    @Column(name = "part_level")
    @JsonIgnore
    private String part_level;
    @OneToMany(mappedBy = "depart",cascade = CascadeType.MERGE)
    private Set<AppointmentItem> items;

    public GoveDepart(String part_code,String part_name){
      this.part_code = part_code;
      this.part_name = part_name;
    }
    public GoveDepart(){}

/*
  public String getPart_code() {
    return part_code;
  }

  public void setPart_code(String part_code) {
    this.part_code = part_code;
  }

  public String getPart_name() {
    return part_name;
  }

  public void setPart_name(String part_name) {
    this.part_name = part_name;
  }

  public String getPart_power() {
    return part_power;
  }

  public void setPart_power(String part_power) {
    this.part_power = part_power;
  }

  public String getPart_level() {
    return part_level;
  }

  public void setPart_level(String part_level) {
    this.part_level = part_level;
  }
  public Set<AppointmentItem> getItems() {
    return items;
  }

  public void setItems(Set<AppointmentItem> items) {
    this.items = items;
  }
*/

  @Override
  public String toString() {
    return "{'depart_code'="+part_code+"'depart_name'="+part_name+"}" ;
  }
}
