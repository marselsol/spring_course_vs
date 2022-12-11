package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller //Контроллер - разновидность компонента. Когда будет происходить сканирование, контроллер будет найден.
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

//    @RequestMapping("/askDetails")
//    public String askEmployeeDetails() {
//        return "ask-emp-details-view";
//    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
//        Employee emp = new Employee();
//        emp.setName("Mars");
//        emp.setSurname("Ga");
//        emp.setSalary(500);

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }

//    @RequestMapping("/showDetails")
//    //@RequestParam - получаем на бэк данные от пользователя
//    //Аннотация @RequestParam позволяет spring захватывать входные данные, которые
//    // могут быть переданы в виде запроса, данных формы или любых произвольных пользовательских данных.
//    // Он используется для привязки параметра веб-запроса к параметру метода.
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
//        empName = "Mr. " + empName + "!";
//        //Модель это контейнер для каких угодно данных
//        model.addAttribute("nameAttribute", empName);
//        return "show-emp-details-view";
//    }
    }
}