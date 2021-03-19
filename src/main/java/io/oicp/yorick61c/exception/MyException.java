package io.oicp.yorick61c.exception;

public class MyException extends Exception {

    private String message;

    public MyException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }
}
