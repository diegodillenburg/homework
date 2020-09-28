package com.unesp.rc.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.unesp.rc.homework.model.Assignment;
import com.unesp.rc.homework.repository.AssignmentRepository;
import com.unesp.rc.homework.exception.AssignmentNotFoundException;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @PostMapping("/assignments")
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @GetMapping("/assignments/{id}")
    public Assignment getAssignmentById(@PathVariable(value = "id") Long assignmentId) throws AssignmentNotFoundException {
        return assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new AssignmentNotFoundException(assignmentId));
    }

    @PutMapping("/assignments/{id}")
    public Assignment updateAssignment(@PathVariable(value = "id") Long assignmentId,
                                       @RequestBody Assignment assignmentDetails) throws AssignmentNotFoundException {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new AssignmentNotFoundException(assignmentId));

        assignment.setTitle(assignmentDetails.getTitle());
        assignment.setDescription(assignmentDetails.getDescription());
        assignment.setAssignmentType(assignmentDetails.getAssignmentType());

        Assignment updatedAssignment = assignmentRepository.save(assignment);

        return updatedAssignment;
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value  = "id") Long assignmentId) throws AssignmentNotFoundException {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new AssignmentNotFoundException(assignmentId));

        assignmentRepository.delete(assignment);

        return ResponseEntity.ok().build();
    }
}
