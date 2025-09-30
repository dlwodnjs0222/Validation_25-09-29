package com.du.em0930.dto;

import com.du.em0930.entity.MyUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "이름을 반드시 입력해야 합니다.")
    private String name;

    @NotBlank(message = "이메일을 반드시 입력해야 합니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @Size(min = 6, max = 20, message = "비밀버호는 6자 이상 20자 이하로 입력해야 합니다.")
    private String password;

    public MyUser toEntity(String hashedPassword) {
        return MyUser.builder()
                .name(name)
                .email(email)
                .password(hashedPassword)
                .build();
    }
}
