package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.UpdateSectionDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Section;

public class SectionMapper {
    public  static ModelMapper modelMapper = new ModelMapper();

    public static Section fromSectionDTOToSectionEntity(PostSectionDTO postSectionDTO) {
        return  modelMapper.map(postSectionDTO, Section.class);
    }

    public static Section updateSectionDTO(UpdateSectionDTO updateSectionDTO){
        return modelMapper.map(updateSectionDTO, Section.class);
    }
}
