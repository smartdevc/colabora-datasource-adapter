package cl.colabora.controller;


import cl.colabora.model.Project;
import cl.colabora.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProject(){
        List<Project> projects = projectService.getAllProject();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<String> createProject(@RequestBody Project project){
        try{
            projectService.createProject(project);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Project created", HttpStatus.CREATED);
    }

    @PostMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject (@PathVariable Long id, @RequestBody Project project) {

        Project newProject = projectService.getProjectById(id);
        newProject.setName(project.getName());
        try{
            projectService.updateProject(newProject);
        } catch (Exception ex){
            return new ResponseEntity<>(newProject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newProject, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id){
        try{
            projectService.deleteProject(id);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Project deleted", HttpStatus.OK);
    }
}
