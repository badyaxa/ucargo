package badyaxa.ucargo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicRestController {

    @GetMapping("/")
    public String homePageHelloMsg() {
        return "<h2>@RestController</h2> Hello, go to url <h1>/index.html</h1> home page";
    }

}