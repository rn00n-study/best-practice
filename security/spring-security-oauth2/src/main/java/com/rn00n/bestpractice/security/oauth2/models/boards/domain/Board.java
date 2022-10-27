package com.rn00n.bestpractice.security.oauth2.models.boards.domain;

import com.rn00n.bestpractice.security.oauth2.models.boards.Account;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne
    private Account writer;

}
