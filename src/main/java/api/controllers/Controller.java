package api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class Controller {
    @GetMapping("/main")
    public ResponseEntity<String> getMain() {
        String message = "Добро пожаловать в Main!";
        log.info("Добро пожаловать в Main!");
        return ResponseEntity.ok(message);
    }
}
