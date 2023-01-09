package com.V0.Th.Controlers;

import com.V0.Th.models.TimeTable;
import com.V0.Th.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeTableController {
    @Autowired
    private TimeTableRepository time_tableRepository;

    @GetMapping("/Schedule")//Если ты руками введёшь это в поле поиска тебе выведятся все записи с бд
    public String Schedule(Model model) {
        Iterable<TimeTable> parameters= time_tableRepository.findAll();//Берём все записи с таблички
        model.addAttribute("parameters",parameters);// под названием parameters передаём записи с таблицы в файл "Sсhedule.html"
        return "Schedule";
    }
    @PostMapping("/Schedule")//нужно чтобы делать поиск на странице
    public String home_find(@RequestParam String find, Model model) {
        TimeTable find1 = time_tableRepository.findFirstByGroupNameContainingOrTeacherContainingOrRoomContaining(find, find , find);
        if(find1==time_tableRepository.searchFirstByGroupNameContains(find)){//PageRequest.of(0,6, Sort.by("day","time"))
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
}