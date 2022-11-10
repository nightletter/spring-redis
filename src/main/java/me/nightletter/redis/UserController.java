package me.nightletter.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestParam String name,
                              @RequestParam Integer age) {

        userService.add(name, age);
        return ResponseEntity.ok().build();
    }
}
