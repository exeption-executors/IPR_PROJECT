package ru.raiffeisen.ipr.mappers;

import org.modelmapper.ModelMapper;
import ru.raiffeisen.ipr.dto.CreatePointDTO;
import ru.raiffeisen.ipr.dto.DeletePointDTO;
import ru.raiffeisen.ipr.dto.UpdatePointDTO;
import ru.raiffeisen.ipr.entity.Point;

public class PointMapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static Point fromPointDTOToPointEntity(CreatePointDTO createPointDTO) {
        return  modelMapper.map(createPointDTO, Point.class);
    }

    public static DeletePointDTO deletePointDTO(Point point){
        return modelMapper.map(point, DeletePointDTO.class);
    }

    public static UpdatePointDTO updatePointDTO(Point point){
        return modelMapper.map(point, UpdatePointDTO.class);
    }
}
