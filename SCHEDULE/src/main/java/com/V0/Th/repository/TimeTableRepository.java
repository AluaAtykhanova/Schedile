package com.V0.Th.repository;

import com.V0.Th.models.TimeTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable,Long> {
    TimeTable findFirstByGroupNameContainingOrTeacherContainingOrRoomContaining(String name, String teacher, String room);
    TimeTable searchFirstByGroupNameContains(String name);
    TimeTable searchFirstByTeacherContains(String name);
    TimeTable searchFirstByRoomContains(String name);
    //test table
    List <TimeTable> searchByGroupNameContainingAndDayContainingOrderByTime(String name,String day);
    List <TimeTable> searchByTeacherContainingAndDayContainingOrderByTime(String teacher,String day);
    List <TimeTable> searchByRoomContainingAndDayContainingOrderByTime(String room,String day);

}
