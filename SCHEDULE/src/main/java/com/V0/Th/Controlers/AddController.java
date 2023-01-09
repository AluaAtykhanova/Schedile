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
public class AddController {
    @Autowired
    private TimeTableRepository timeTableRepository;

    @GetMapping("/add") //ссылка на страницу localhost:8080/add Это страница на которой можно добавить данные в таблицу
    public String homepage_add(Model model) {
        model.addAttribute("title", "Добавка");
        return "add";
    }

    @PostMapping("/add")
    public String homepage_add(@RequestParam String day, @RequestParam String time, @RequestParam String course, @RequestParam String type, @RequestParam String groupName, @RequestParam String teacher, @RequestParam String room, Model model) {
        model.addAttribute("title", "Добавка");
        TimeTable timeTable= new TimeTable(day,time,course,type,groupName,teacher,room);
        timeTableRepository.save(timeTable);
        return "add";
    }
}
