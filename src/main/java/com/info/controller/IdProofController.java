package com.info.controller;

import com.info.payload.IdProofDTO;
import com.info.service.IdProofService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/idproof")
public class IdProofController {

    private IdProofService idProofService;

    public IdProofController(IdProofService idProofService) {
        this.idProofService = idProofService;
    }



    // http://localhost:8080/api/idproof/1/pancardnumber
    @PutMapping("/{id}/pancardnumber")
    public ResponseEntity<IdProofDTO> updatePancardNumberById(@PathVariable("id") Long id,
                                                              @RequestBody IdProofDTO dto) {
        IdProofDTO updatedIdProofDTO = idProofService.updatePancardNumberById(id, dto.getPancardnumber());
        return ResponseEntity.ok(updatedIdProofDTO);
    }
}

