package com.rsdata.cadastroempresasjsf.controller;

import com.rsdata.cadastroempresasjsf.model.RamoAtividade;
import lombok.AllArgsConstructor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;
@AllArgsConstructor
public class RamoAtividadeConverter implements Converter {

    List<RamoAtividade> ramosAtividadeList;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s == null){
            return null;
        }
        Long id = Long.valueOf(s);
        for(RamoAtividade ramo:ramosAtividadeList ){
            if(id.equals(ramo.getId())){
                return ramo;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        RamoAtividade ramoAtividade = (RamoAtividade) o;
        return ramoAtividade.getId().toString();
    }
}
