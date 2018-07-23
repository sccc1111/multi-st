package exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by songbo on 2018/7/23.
 */
@Controller
public class PageController {
    @GetMapping({"/page"})
    public ModelAndView index() {
        throw new PageException(600, "PageException");
    }
}
