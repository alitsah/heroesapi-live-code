package one.digitalinnovation.heroesapi.mapper;

import one.digitalinnovation.heroesapi.dto.request.HeroDTO;
import one.digitalinnovation.heroesapi.entity.Hero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HeroMapper {

    HeroMapper INSTANCE = Mappers.getMapper(HeroMapper.class);

    @Mapping(target =  "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Hero toModel(HeroDTO heroDTO);

    HeroDTO toDTO(Hero hero);

}
