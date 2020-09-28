package com.unesp.rc.homework.exception;

public class AssignmentNotFoundException extends Exception {
    private long assignmentId;

    public AssignmentNotFoundException(long assignmentId) {
        super(String.format("No assignment found for id: %d", assignmentId));
    }
}
