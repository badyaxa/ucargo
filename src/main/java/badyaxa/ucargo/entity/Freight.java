package badyaxa.ucargo.entity;

import javax.persistence.*;

@Entity
@Table(name = "freight")
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
