package by.academy.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TilesController {

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = { "/page" }, method = RequestMethod.GET)
    public String pageOne(ModelMap model) {
        return "page";
    }

}