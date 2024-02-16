package cl.colabora.service.impl;


import cl.colabora.model.Project;
import cl.colabora.repository.ProjectRepository;
import cl.colabora.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project) {
        return null;
    }

    @Override
    public Project getProjectById(Long id) {
        return null;
    }

    @Override
    public void deleteProject(Long id) {

    }
}
