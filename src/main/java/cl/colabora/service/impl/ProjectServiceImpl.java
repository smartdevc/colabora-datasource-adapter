package cl.colabora.service.impl;


import cl.colabora.model.Project;
import cl.colabora.repository.ProjectRepository;
import cl.colabora.service.ProjectService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Project> projectFinded = projectRepository.findById(project.getId());
        if (projectFinded.isPresent()){
            Project projectUpdated = projectFinded.get();
            projectUpdated.setName(project.getName());
            projectUpdated.setDescription(project.getDescription());
            projectRepository.save(projectUpdated);
            return projectUpdated;
    } else {
        throw new NoResultException("Project with id" + project.getId() + "was not found");
        }
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()){
            return project.get();
        } else{
            throw new NoResultException("Project with id" + id + "was not found");
        }
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()){
            projectRepository.delete(project.get());
        } else {
            throw new NoResultException("Project with id" + id + "was not found");
        }
    }
}
