package com.gentara.elurah.master.repository;

import com.gentara.elurah.master.model.entity.RtEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RtRepository extends JpaRepository<@NonNull RtEntity, @NonNull String> {
}
