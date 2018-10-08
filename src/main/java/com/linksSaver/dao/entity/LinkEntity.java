package com.linksSaver.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "links_table")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkEntity {
    @Id
    @GeneratedValue
    private long id_link;

    @Column
    private String link_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_theme", referencedColumnName = "id_theme", insertable = false, updatable = false, unique = true)
    private ThemeEntity theme;

}