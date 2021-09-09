package one.digitalinnovation.heroesapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommunicatorType {

    FOLKS("Folks"),
    VEHICLE("Vehicle"),
    HEADQUARTERS("Headquarters");

    private final String description;
}
