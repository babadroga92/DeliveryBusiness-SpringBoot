package com.deliverybusiness.model;

import com.deliverybusiness.enums.DayOfWeek;
import com.deliverybusiness.enums.DayOfWeekConverter;

import javax.persistence.*;

@Entity
@Table(name = "Weekday")
public class Weekday {
    @Id
    @Column(name = "ID")
    private int id;
    @Convert(converter = DayOfWeekConverter.class)
    @Column(name = "Name")
    private DayOfWeek dayOfWeek;

    public Weekday() {
    }

    public Weekday(int id, DayOfWeek dayOfWeek) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
    }

    public int getId() {
        return id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Weekday{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
