package com.em.test.entitymanagertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.test.entitymanagertest.entity.VinMaster;

public interface VinMasterRepository extends JpaRepository<VinMaster, Long> {
}
