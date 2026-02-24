package com.gentara.elurah.master.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_house_hold")
public class HouseHold {

    @Id
    private String id;

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
}
