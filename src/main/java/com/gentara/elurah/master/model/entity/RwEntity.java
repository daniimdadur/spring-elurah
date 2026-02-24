package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_rw")
public class RwEntity extends BaseAuditableSoftDelete {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "rw", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RtEntity> rtEntities;
}
