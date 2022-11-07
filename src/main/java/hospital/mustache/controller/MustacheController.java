package hospital.mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MustacheController {

    @GetMapping("/index")
    public String mustacheCon(Model model) {
        model.addAttribute("username", "서윤");
        return "greetings";
    }

    @GetMapping("/hi/{id}")
    public String mustacheCon(Model model, @PathVariable("id") int id) {
        model.addAttribute("username", "서윤");
        model.addAttribute("id", id);
        return "greetings";
    }

}
