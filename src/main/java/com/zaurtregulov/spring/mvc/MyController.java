package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller //Контроллер - разновидность компонента. Когда будет происходить сканирование, контроллер будет найден.
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails() {
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        //Модель это контейнер для каких угодно данных
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("description", " - udemy instructor");
//        return "show-emp-details-view";
//    }

    @RequestMapping("/showDetails")
    //@RequestParam - получаем на бэк данные от пользователя
    //Аннотация @RequestParam позволяет spring захватывать входные данные, которые
    // могут быть переданы в виде запроса, данных формы или любых произвольных пользовательских данных.
    // Он используется для привязки параметра веб-запроса к параметру метода.
    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
        empName = "Mr. " + empName + "!";
        //Модель это контейнер для каких угодно данных
        model.addAttribute("nameAttribute", empName);
        return "show-emp-details-view";
    }
}