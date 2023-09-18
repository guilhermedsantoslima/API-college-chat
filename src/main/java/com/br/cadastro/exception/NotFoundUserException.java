package com.br.cadastro.exception;

public class NotFoundUserException extends Exception {

    public NotFoundUserException() {
        super("Usuário não encontrado");
    }
}
