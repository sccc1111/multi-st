package exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songbo on 2018/7/23.
 */
@RestController
public class JsonController {
    @RequestMapping("/json")
    public R index() {
        throw new JsonException(501, "DemoJsonException");
    }
}
