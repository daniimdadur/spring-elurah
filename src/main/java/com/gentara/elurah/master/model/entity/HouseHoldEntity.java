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
@Table(name = "t_house_hold")
public class HouseHoldEntity extends BaseAuditableSoftDelete {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    private RtEntity rt;

    @Column(name = "family_card_number")
    private String familyCardNumber;

    @Column(name = "head_of_family_name")
    private String headOfFamilyName;

    @Column(name = "address")
    private String address;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "houseHold", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillEntity> billEntities;
}
