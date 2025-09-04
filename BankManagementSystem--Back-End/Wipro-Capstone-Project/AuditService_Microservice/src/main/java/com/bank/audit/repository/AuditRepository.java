package com.bank.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.audit.entity.AuditRecord;

@Repository
public interface AuditRepository extends JpaRepository<AuditRecord, Long> {
}
