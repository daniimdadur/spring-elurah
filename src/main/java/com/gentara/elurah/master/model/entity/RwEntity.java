package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE t_rw SET deleted_at=CURRENT_TIMESTAMP WHERE id=?")
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
