package com.linksSaver.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TagEntity implements Serializable {
    @Column(name = "tag_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tagId;

    @Column(name = "tag")
    private String tagName;

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tags_id")
    private Set<LinkEntity> links = new HashSet<>();

}
