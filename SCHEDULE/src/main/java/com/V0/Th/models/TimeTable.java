package com.V0.Th.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String day,time,course,type,groupName,teacher,room; //день недели,время,предмет,тип урока,группа,преподаватель,кабинет

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public TimeTable() {
    }

    public TimeTable(String day, String time, String course, String type, String groupName, String teacher, String room) {
        this.day = day;
        this.time = time;
        this.course = course;
        this.type = type;
        this.groupName = groupName;
        this.teacher = teacher;
        this.room = room;
    }
}
