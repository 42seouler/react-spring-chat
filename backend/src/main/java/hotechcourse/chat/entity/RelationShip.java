package hotechcourse.chat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class RelationShip {

    @Id
    @Column(name = "relationship_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User    userOne;

    @ManyToOne(fetch = FetchType.LAZY)
    private User    userTwo;

    @Enumerated(EnumType.STRING)
    private Status  status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User    actionUser;
}
