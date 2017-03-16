package com.rpicloud.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tharindu on 3/16/17.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
@Entity
public class CarHireEvent implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "EQUIP_INIT", length = 4)
    private String equipInitial;

    @Column(name = "EQUIP_NUM")
    private Integer equipNum;

    @Column(name = "EVENT_DATE_TIME")
    private Date eventDateTime;

    @Column(name = "EVENT_TYPE", length = 4)
    private String eventType;

    public CarHireEvent(String equipInitial, Integer equipNum, Date eventDateTime, String eventType) {
        this.equipInitial = equipInitial;
        this.equipNum = equipNum;
        this.eventDateTime = eventDateTime;
        this.eventType = eventType;
    }

    protected CarHireEvent() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipInitial() {
        return equipInitial;
    }

    public void setEquipInitial(String equipInitial) {
        this.equipInitial = equipInitial;
    }

    public Integer getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(Integer equipNum) {
        this.equipNum = equipNum;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarHireEvent)) return false;

        CarHireEvent that = (CarHireEvent) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (equipInitial != null ? !equipInitial.equals(that.equipInitial) : that.equipInitial != null) return false;
        if (equipNum != null ? !equipNum.equals(that.equipNum) : that.equipNum != null) return false;
        if (eventDateTime != null ? !eventDateTime.equals(that.eventDateTime) : that.eventDateTime != null)
            return false;
        return eventType != null ? eventType.equals(that.eventType) : that.eventType == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (equipInitial != null ? equipInitial.hashCode() : 0);
        result = 31 * result + (equipNum != null ? equipNum.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarhireEvent{" +
                "id=" + id +
                ", equipInitial='" + equipInitial + '\'' +
                ", equipNum=" + equipNum +
                ", eventDateTime=" + eventDateTime +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
