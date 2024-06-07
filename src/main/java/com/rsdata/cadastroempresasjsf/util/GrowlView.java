package com.rsdata.cadastroempresasjsf.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class GrowlView {
    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void showInfo(String msg) {
        addMessage(FacesMessage.SEVERITY_INFO, "Info Message", msg);
    }

    public void showWarn(String msg) {
        addMessage(FacesMessage.SEVERITY_WARN, "Warn Message", msg);
    }

    public void showError(String msg) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", msg);
    }
}
