package badyaxa.ucargo.entity;

import javax.persistence.*;

@Entity
@Table(name = "carrier")
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;
}