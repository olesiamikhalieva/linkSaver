package com.linksSaver.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long linkId;

    @Column(name = "link", unique = true)
    private String linkName;

    @Column
    private String description;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;


}