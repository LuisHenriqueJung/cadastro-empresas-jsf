package com.rsdata.cadastroempresasjsf.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesMessages implements Serializable {

    private static final long serialVersionUID = 1L;

    private void add(String msg, FacesMessage.Severity severity){
        FacesMessage message = new FacesMessage(severity, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void info(String msg){
        add(msg, FacesMessage.SEVERITY_INFO);
    }
}
