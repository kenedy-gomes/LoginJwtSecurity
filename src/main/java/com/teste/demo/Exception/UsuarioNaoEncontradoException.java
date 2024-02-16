package com.teste.demo.Exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException() {
        super();
    }

    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
