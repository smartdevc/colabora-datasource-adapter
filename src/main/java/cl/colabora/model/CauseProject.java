package cl.colabora.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cause_project")
public class CauseProject {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id")
    @JoinColumn(name = "cause_id")
    private Cause causeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id")
    @JoinColumn(name = "project_id")
    private Project projectId;

}
