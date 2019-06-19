package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.CreatePartnerDTO;
import ru.raiffeisen.ipr.dto.UpdatePartnerDTO;
import ru.raiffeisen.ipr.entity.Partner;

public class PartnerMapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static Partner fromPartnerDTOToPartnerEntity(CreatePartnerDTO createPartnerDTO) {
        return  modelMapper.map(createPartnerDTO, Partner.class);
    }
    public static Partner updatePartnerDTO(UpdatePartnerDTO updatePartnerDTO){
        return modelMapper.map(updatePartnerDTO, Partner.class);
    }
}
