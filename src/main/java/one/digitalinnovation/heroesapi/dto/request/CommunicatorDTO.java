package one.digitalinnovation.heroesapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.heroesapi.enums.CommunicatorType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunicatorDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private CommunicatorType type;

    @NotEmpty
    @Size(min = 10, max = 15)
    private String number;
}
