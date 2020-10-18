package com.unesp.rc.homework.exception;

public class AtividadeNotFoundException extends Exception {
    private long atividadeId;

    public AtividadeNotFoundException(long atividadeId) {
        super(String.format("No assignment found for id: %d", atividadeId));
    }
}
