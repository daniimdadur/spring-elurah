package com.gentara.elurah.master.repository;

import com.gentara.elurah.master.model.entity.RwEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RwRepository extends JpaRepository<RwEntity, String> {
}
