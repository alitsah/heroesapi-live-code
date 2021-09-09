package one.digitalinnovation.heroesapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeroDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 80)
    private String heroName;

    @NotEmpty
    private String heroCod;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<CommunicatorDTO> communicators;
}
