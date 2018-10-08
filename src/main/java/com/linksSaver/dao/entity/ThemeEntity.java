package com.linksSaver.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "themes")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ThemeEntity {
    @Id
    @GeneratedValue
    private long id_theme;

    @Column(unique = true)
    private String name_theme;

    @Column
    @OneToMany(mappedBy = "theme",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<LinkEntity> link_entities = new HashSet<>();

}
