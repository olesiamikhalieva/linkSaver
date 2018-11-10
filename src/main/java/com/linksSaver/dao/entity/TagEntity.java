package com.linksSaver.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

}
