package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.repository.PlanRepository;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.repository.TasksListRepository;
import ru.raiffeisen.ipr.service.PlanService;

import java.sql.Date;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.saveAndFlush(plan);
    }

    @Autowired
    private SectionRepository sectionRepository;
    @Override
    public void createSection(Long plan_id, Date section_date_end, String section_description, String priority) {
        sectionRepository.createSection(plan_id, section_date_end, section_description, priority);
    }

    @Override
    public void deleteSectionById(Long id) {
        sectionRepository.deleteSectionById(id);
    }

    @Override
    public void updateSection(Date section_date_end, String section_description, String priority, Long id) {
        sectionRepository.updateSection(section_date_end, section_description, priority, id);
    }

    @Autowired
    private TasksListRepository tasksListRepository;

    @Override
    public void createTaskList(Long section_id, boolean task_is_done, String task_description) {
        tasksListRepository.createTaskList(section_id, task_is_done, task_description);
    }

    @Override
    public void deleteTaskList(Long id) {
        tasksListRepository.deleteTaskListById(id);
    }

    @Override
    public void updateTaskList(boolean task_is_done, String task_description, Long id) {
        tasksListRepository.updateTaskList(task_is_done, task_description, id);
    }

    @Override
    public void deletePlanById(Long id) {
        planRepository.deleteById(id);
    }
}
