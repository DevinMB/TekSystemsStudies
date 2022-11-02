package jpa.entitymodels;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"sCourses"})
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "email")
    private String sEmail;
    @Column(name = "name")
    private String sName;
    @Column(name = "password")
    private String sPass;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Student_Course",
            joinColumns = { @JoinColumn(name = "student_email") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private List<Course> sCourses;


}
