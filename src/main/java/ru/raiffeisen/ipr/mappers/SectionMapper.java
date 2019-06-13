package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.DeleteSectionByIdDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Section;

public class SectionMapper {
    public  static ModelMapper modelMapper = new ModelMapper();

    public  static DeleteSectionByIdDTO deleteSectionByIdDTO(Section section) {
        return modelMapper.map(section, DeleteSectionByIdDTO.class);
    }
    public static Section fromSectionDTOToSectionEntity(PostSectionDTO postSectionDTO) {
        return  modelMapper.map(postSectionDTO, Section.class);
    }
}
