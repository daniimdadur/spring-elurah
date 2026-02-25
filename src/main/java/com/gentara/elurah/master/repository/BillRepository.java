package com.gentara.elurah.master.repository;

import com.gentara.elurah.master.model.entity.BillEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<@NonNull BillEntity, @NonNull String> {
}
