package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreatePointDTO;
import ru.raiffeisen.ipr.entity.Point;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.PointMapper;
import ru.raiffeisen.ipr.repository.PointRepository;
import ru.raiffeisen.ipr.service.PointService;
import ru.raiffeisen.ipr.service.SectionService;
import ru.raiffeisen.ipr.service.exeption.PlanNotFoundException;
import ru.raiffeisen.ipr.service.exeption.PointNotFoundException;
import ru.raiffeisen.ipr.service.exeption.SectionNotFoundException;

import java.util.Optional;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public void postPoint(CreatePointDTO createPointDTO, SectionService sectionService) {
        Point point = PointMapper.fromPointDTOToPointEntity(createPointDTO);
        Section section = sectionService.findById(createPointDTO.getSection_id())
                .orElseThrow(() -> { throw new SectionNotFoundException(createPointDTO.getSection_id());
                });
        section.addPointEntity(point);
        sectionService.saveSection(section);
    }

    @Override
    public void deletePointById(Long id) {
        Optional<Point> point = pointRepository.findById(id);
        point.orElseThrow(() -> {
            throw new PointNotFoundException(id);
        });
        pointRepository.deleteById(id);
    }

    @Override
    public void updatePointById(boolean pointIsDone, String pointDescription, Long id) {
        Optional<Point> point = pointRepository.findById(id);
        point.orElseThrow(()-> {throw new PointNotFoundException(id);
        });
        pointRepository.updatePoint(pointIsDone, pointDescription, id);
    }
}
