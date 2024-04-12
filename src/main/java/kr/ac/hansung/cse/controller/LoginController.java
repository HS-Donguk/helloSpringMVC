package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")  // login으로 부터 매핑.
//    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String showLogin(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {
        System.out.println("OfferController called");
        if (error != null) {        // error 파라미터가 있으면
            model.addAttribute("errorMsg", "Invalid username or password");
        }

        if (logout != null) {   // logout 파라미터가 있으면
            model.addAttribute("logoutMsg", "You have been logged out successfully ");
        }

        return "login";
    }
}
