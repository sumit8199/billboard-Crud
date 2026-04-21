package com.example.billboard.repository;

import com.example.billboard.entity.Billboard;
import com.example.billboard.entity.BillboardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillboardRepository extends JpaRepository<Billboard, Long> {

    List<Billboard> findByActiveTrue();

    List<Billboard> findByType(BillboardType type);

    List<Billboard> findByLocationContainingIgnoreCase(String location);

    List<Billboard> findByActiveTrueAndType(BillboardType type);
}