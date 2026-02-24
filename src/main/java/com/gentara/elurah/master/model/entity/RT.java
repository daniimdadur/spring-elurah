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
@Table(name = "t_rt")
public class RT {

    @Id
    private String id;

    @Column(name = "number")
    private String number;
}
