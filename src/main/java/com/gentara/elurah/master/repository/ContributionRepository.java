package com.gentara.elurah.master.repository;

import com.gentara.elurah.master.model.entity.ContributionEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<@NonNull ContributionEntity, @NonNull String> {
}
