package co.develhope.ex002;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class UserController {
    @GetMapping(path = "/ciao/{provincia}")
    public User ciao(@PathVariable String provincia, String nome) {
        String saluto = "Ciao " + nome + ", com'è il tempo in " + provincia + "?";
        return new User(nome, provincia, saluto);
    }
}
