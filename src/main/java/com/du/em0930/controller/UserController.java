package com.du.em0930.controller;

import com.du.em0930.dto.UserRequest;
import com.du.em0930.entity.MyUser;
import com.du.em0930.repository.UserRepository;
import com.du.em0930.util.PassWordUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@Valid @ModelAttribute("userRequest") UserRequest userRequest,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        
        //실제 DB에 저장
        //MyUser myUser = userRequest.toEntity();

        //비번 암호화
        String hashedPassword = PassWordUtil.hashPassword(userRequest.getPassword());

        //엔티티로 변환
        MyUser myUser = userRequest.toEntity(hashedPassword);
        userRepository.save(myUser);


        model.addAttribute("message", "회원가입이 성공적으로 완료되었습니다.");
        return "signup";
    }


}
