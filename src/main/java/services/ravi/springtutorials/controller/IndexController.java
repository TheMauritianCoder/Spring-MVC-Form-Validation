package services.ravi.springtutorials.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.ravi.springtutorials.model.Customer;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping
    public ModelAndView getForm(Model model){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @PostMapping
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }else{
            return "processed";
        }
    }

}
