package co.develhope.demo_webapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }

    //Para dizer que algum parametro não é obrigatorio, deve apenas colocar o required false
    @RequestMapping(path = "/ciao")
    public String greet(@RequestParam(required = true) String name, @RequestParam(required = false, defaultValue = "") String lastname) {
        return "Ciao " + name + " " + lastname + "!";
    }
}
