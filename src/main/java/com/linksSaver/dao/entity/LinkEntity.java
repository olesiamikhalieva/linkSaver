package com.linksSaver.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "links")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkEntity implements Serializable {

    @Column(name = "link_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long linkId;

    @Column(name = "link")
    private String linkName;

    @Column
    private String description;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "link_id")
    private List<TagEntity> tags= new ArrayList<>();



}