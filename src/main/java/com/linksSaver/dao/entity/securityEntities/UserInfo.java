package com.linksSaver.dao.entity.securityEntities;

import com.linksSaver.dao.entity.TagEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

/**
 * Объект юзер инфо который связан с объектом роли как многие ко многим и при генерации таблиц
 * создадут 3-ю таблицу которая и будет связывать ети 2 сущности по ID
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = "roles")
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    transient private String passwordConfirm;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_info_id")
    private Set<TagEntity> tags;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}
