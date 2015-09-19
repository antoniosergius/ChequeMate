package br.com.antoniosergius.chequemate.util;

import java.awt.Component;
import javax.swing.JLabel;

public class ChequeMateException extends Exception{
    private static final long serialVersionUID = 1L;

    private String message;
    private Component component;
    
    public ChequeMateException() {
    }

    public ChequeMateException(String message) {
        this.message = message;
    }

    public ChequeMateException(String message, Component component) {
        this.message = message;
        this.component = component;
    }
    
    public void showExceptionMessage() {
        ChequeMate.showErrorMessage(component, "Erro!", message);
        if (component!=null) {
            component.requestFocusInWindow();
        }
    }
    
    public void showExceptionMessage(JLabel label) {
        label.setText(message);
        if (component!=null) {
            component.requestFocusInWindow();
        }
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public ChequeMateException retrieve(String msg, Component component) {
        setMessage(msg);
        setComponent(component);
        return this;
    }
}
