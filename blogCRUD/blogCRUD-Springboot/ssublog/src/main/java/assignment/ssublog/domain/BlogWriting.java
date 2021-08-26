package assignment.yourssu.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BlogWriting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_posting_id")
    private Long id;

    private String author;

    private String title;

    private String posting_body;

}
