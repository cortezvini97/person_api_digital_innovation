package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO
{
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @Email
    @Size(min = 2, max = 190)
    private String email;

    @NotEmpty
    @Size(min = 2, max = 2)
    private String state;

    @NotEmpty
    @Size(min = 2, max = 190)
    private String city;

    @NotEmpty
    @Size(min = 9, max = 9)
    private String zipcode;

    @NotEmpty
    @Size(min = 2, max = 190)
    private String district;

    @NotEmpty
    @Size(min = 2, max = 190)
    private String road;

    private int number;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
