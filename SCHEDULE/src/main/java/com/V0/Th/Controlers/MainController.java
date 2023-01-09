package com.V0.Th.Controlers;
import com.V0.Th.models.TimeTable;
import com.V0.Th.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;


@Controller
public class MainController {
    @Autowired
    private TimeTableRepository time_tableRepository;

    @GetMapping("/")//Home
    public String home(Model model) {
        model.addAttribute("title", "Главная станица");
        return "index";
    }
    @PostMapping ("/")//Schedule
    public String home_find(@RequestParam String find, Model model) {
        model.addAttribute("title", "Главная страница");//Нужно добавить все параметры, это временный класс чтобы было проще добавлять данные в таблицу, дальше его устраним или вынесем в отдельную ссылку
        TimeTable find1 = time_tableRepository.findFirstByGroupNameContainingOrTeacherContainingOrRoomContaining(find, find , find);
        if(find1==time_tableRepository.searchFirstByGroupNameContains(find)){
            model.addAttribute("find",find1.getGroupName());
            model.addAttribute("Monday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Monday"));
            model.addAttribute("Tuesday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Tuesday"));
            model.addAttribute("Wednesday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Wednesday"));
            model.addAttribute("Thursday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Thursday"));
            model.addAttribute("Friday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Friday"));
            model.addAttribute("Saturday", time_tableRepository.searchByGroupNameContainingAndDayContainingOrderByTime(find1.getGroupName(),"Saturday"));
            return "group";
        }
        else if(find1==time_tableRepository.searchFirstByTeacherContains(find)){
            model.addAttribute("find",find1.getTeacher());
            model.addAttribute("Monday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Monday"));
            model.addAttribute("Tuesday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Tuesday"));
            model.addAttribute("Wednesday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Wednesday"));
            model.addAttribute("Thursday", time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Thursday"));
            model.addAttribute("Friday",time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Friday"));
            model.addAttribute("Saturday",time_tableRepository.searchByTeacherContainingAndDayContainingOrderByTime(find1.getTeacher(),"Saturday"));
            return "teachers";
        }
        else{
            if(find1==time_tableRepository.searchFirstByRoomContains(find)){
                model.addAttribute("find",find1.getRoom());
                model.addAttribute("Monday", time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Monday"));
                model.addAttribute("Tuesday", time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Tuesday"));
                model.addAttribute("Wednesday", time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Wednesday"));
                model.addAttribute("Thursday", time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Thursday"));
                model.addAttribute("Friday",time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Friday"));
                model.addAttribute("Saturday",time_tableRepository.searchByRoomContainingAndDayContainingOrderByTime(find1.getRoom(),"Saturday"));
                return "rooms";
            }
        }
        return "Schedule";
    }
    //SELECT * FROM `time_table` WHERE `group_name` LIKE '%SIS-2129%';
}