package aop.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by songbo on 2018/7/23.
 */
@RestController
@Slf4j
public class IndexController {
    @GetMapping({"", ""})
    public String index() {
        return "index";
    }

    @GetMapping({"/test"})
    public Map test(@RequestParam String name,@RequestParam String password) {
        ConcurrentMap<String, Object> ret = Maps.newConcurrentMap();
        ret.put("name", name);
        return ret;
    }
}
