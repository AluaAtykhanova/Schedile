package com.V0.Th.Controlers;
import com.V0.Th.models.TimeTable;
import com.V0.Th.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Test {
    @Autowired
    private TimeTableRepository time_tableRepository;

    @GetMapping("/test")
    public String Schedule(Model model) {
        Iterable<TimeTable> parameters= time_tableRepository.findAll();
        model.addAttribute("parameters",parameters);
        return "indextest";
    }
    @PostMapping("/test")
    public String home_find(@RequestParam String find,String tabs, Model model) {
        model.addAttribute("find",find);
        TimeTable find1 = time_tableRepository.findFirstByGroupNameContainingOrTeacherContainingOrRoomContaining(find, find , find);
        if(find1==time_tableRepository.searchFirstByGroupNameContains(find)){//PageRequest.of(0,6, Sort.by("day","time"))
            model.addAttribute("find",find1.getGroupName());
            model.addAttribute("Monday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Monday"));
            model.addAttribute("Tuesday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Tuesday"));
            model.addAttribute("Wednesday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Wednesday"));
            model.addAttribute("Tuesday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Tuesday"));
            model.addAttribute("Wednesday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Wednesday"));
            return "test";
        }
        else if(find1==time_tableRepository.searchFirstByTeacherContains(find)){//В тесте нет необходимости во всех днях недели
            model.addAttribute("find",find1.getTeacher());
            model.addAttribute("Monday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Monday"));
            model.addAttribute("Tuesday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Tuesday"));
            model.addAttribute("Wednesday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Wednesday"));
            return "teachers";
        }
        else{
            if(find1==time_tableRepository.searchFirstByRoomContains(find)){
                model.addAttribute("find",find1.getRoom());
                model.addAttribute("Monday", time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Monday"));
                model.addAttribute("Tuesday", time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Tuesday"));
                return "rooms";
            }
        }
        return "test";
    }
}
