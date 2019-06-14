package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.CreatePointDTO;
import ru.raiffeisen.ipr.dto.DeletePointDTO;
import ru.raiffeisen.ipr.dto.UpdatePointDTO;
import ru.raiffeisen.ipr.entity.Point;
import ru.raiffeisen.ipr.mappers.PointMapper;
import ru.raiffeisen.ipr.service.PointService;
import ru.raiffeisen.ipr.service.SectionService;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;

    @Autowired
    private SectionService sectionService;

    /**-----CREATE POINT FUNCTION-----**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPoint(@RequestBody CreatePointDTO createPointDTO) {
        pointService.postPoint(createPointDTO,sectionService);
    }

    /**-----DELETE POINT FUNCTION----**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePoint(@RequestBody DeletePointDTO deletePointDTO){
        pointService.deletePointById(deletePointDTO.getId());
    }

    /**-----UPDATE POINT FUNCTION----**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePlan(@RequestBody Point point) {
        UpdatePointDTO updatePointDTO = PointMapper.updatePointDTO(point);
        pointService.updatePointById(point.getPointIsDone(), point.getPointDescription(), point.getId());

    }
}
