package com.rn00n.bestpractice.security.oauth2.models.boards;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Account {

    @Id
    private Long id;

    @OneToMany
    private List<Board> boards;

}
