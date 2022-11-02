package jpa.entitymodels;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "id")
    private Integer cId;
    @Column(name = "name")
    private String cName;
    @Column(name = "instructor")
    private String cInstructorName;

//  To Allow For BiDirectional
//    @ManyToMany(mappedBy = "sCourses",fetch = FetchType.EAGER)
//    private List<Student> students;


}
