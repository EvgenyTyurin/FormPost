package evgenyt.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Show input form for new person, and handles input
 */

@Controller
@RequestMapping("/")
public class HelloController {

    // Init new person and pass it to form
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("person", new Person());
        return "/";
    }

    // Get submit request from person form
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String submit(@ModelAttribute("person") Person person,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors() || person.getName().equals("")) {
            // Redirect to error page errorperson.jsp
            return "error";
        }
        // We can add person to database etc here and...
        // redirect ok answer addedperson.jsp with new person name
        model.addAttribute("name", person.getName());
        return "added";
    }
}
