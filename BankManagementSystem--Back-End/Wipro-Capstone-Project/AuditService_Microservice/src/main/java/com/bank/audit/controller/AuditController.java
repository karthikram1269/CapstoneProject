package com.bank.audit.controller;

import com.bank.audit.entity.AuditRecord;
import com.bank.audit.service.AuditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private final AuditService service;

    public AuditController(AuditService service) { this.service = service; }

    // Trigger a sync from PaymentService and store locally
    @PostMapping("/sync")
    public ResponseEntity<List<AuditRecord>> sync() {
        return ResponseEntity.ok(service.syncPaymentsToAudit());
    }

    @GetMapping
    public ResponseEntity<List<AuditRecord>> getAll() {
        return ResponseEntity.ok(service.getAllAuditRecords());
    }
}
