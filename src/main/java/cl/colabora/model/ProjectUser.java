package cl.colabora.model;

import jakarta.persistence.*;


@Entity
@Table(name = "project_user")
public class ProjectUser {

    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id")
    @JoinColumn(name = "project_id")
    private Project projectId;


    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id")
    @JoinColumn(name = "user_id")
    private User userId;

}
