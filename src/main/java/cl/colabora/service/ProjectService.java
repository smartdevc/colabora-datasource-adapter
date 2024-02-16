package cl.colabora.service;

import cl.colabora.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);

    List<Project> getAllProject();

    Project updateProject(Project project);

    Project getProjectById(Long id);

    void deleteProject(Long id);
}
