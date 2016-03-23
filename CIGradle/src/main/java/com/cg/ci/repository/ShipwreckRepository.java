package com.cg.ci.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ci.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
