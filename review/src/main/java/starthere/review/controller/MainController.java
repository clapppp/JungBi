package starthere.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import starthere.review.dto.LoginDto;
import starthere.review.service.LoggedManageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class MainController {

    private final LoggedManageService loggedManageService;
    private final H2Repository h2Repository;

    public MainController(LoggedManageService loggedManageService, H2Repository h2Repository){
        this.loggedManageService = loggedManageService;
        this.h2Repository = h2Repository;
    }

    @GetMapping("/")
    public String firstPage() {
        boolean logged = loggedManageService.logged();
        if (logged)
            return "redirect:/main";
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
    
    @PostMapping("/login")
    public String loginPost(@RequestBody LoginDto loginDto) {
        boolean success = h2Repository.login(loginDto.getId(),loginDto.getPassword());
        if (success) loggedManageService.setId(loginDto.getId());
        return "redirect:/";
    }
    
    
}
