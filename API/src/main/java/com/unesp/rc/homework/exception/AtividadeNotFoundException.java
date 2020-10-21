package com.unesp.rc.homework.exception;

public class AtividadeNotFoundException extends Exception {
    private long atividadeId;

    public AtividadeNotFoundException(long atividadeId) {
        super(String.format("Nenhuma atividade encontrada para o id: %d", atividadeId));
    }
}
