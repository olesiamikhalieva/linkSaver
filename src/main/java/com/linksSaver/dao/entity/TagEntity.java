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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Column(name = "tag",unique = true)
    private String tagName;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tag_id")
    private Set<LinkEntity> links = new HashSet<>();

}
