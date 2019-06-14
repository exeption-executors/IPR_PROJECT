package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.CreatePointDTO;
import ru.raiffeisen.ipr.dto.UpdatePointDTO;
import ru.raiffeisen.ipr.entity.Point;

public class PointMapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static Point fromPointDTOToPointEntity(CreatePointDTO createPointDTO) {
        return  modelMapper.map(createPointDTO, Point.class);
    }

    public static Point updatePointDTO(UpdatePointDTO updatePointDTO){
        return modelMapper.map(updatePointDTO, Point.class);
    }
}
