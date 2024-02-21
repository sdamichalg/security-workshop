package pl.sda.micgeb.securityworkshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDto {
    private String username;
    private String password;
}
