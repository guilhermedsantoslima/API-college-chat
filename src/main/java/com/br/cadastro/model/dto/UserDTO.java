package com.br.cadastro.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    private String email;

    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    @Pattern(regexp = "^(1[1-9]|2[12478]|3([1-5]|[7-8])|4[1-9]|5(1|[3-5])|6[1-9]|7[134579]|8[1-9]|9[1-9])9[0-9]{8}$",
            message = "{campo.telefone.invalido}")
    private String telefone;

    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;
}
