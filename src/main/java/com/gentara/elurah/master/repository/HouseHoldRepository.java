package com.gentara.elurah.master.repository;

import com.gentara.elurah.master.model.entity.HouseHoldEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseHoldRepository extends JpaRepository<@NonNull HouseHoldEntity, @NonNull String> {
}
