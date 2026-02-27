package com.gentara.elurah.master.repository;

import com.gentara.elurah.master.model.entity.ContributionEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<@NonNull ContributionEntity, @NonNull String> {
    @Query("SELECT c FROM ContributionEntity c WHERE c.rt.id = :rtId")
    List<ContributionEntity> findAllByRtId(@Param("rtId") String rtId);
}
