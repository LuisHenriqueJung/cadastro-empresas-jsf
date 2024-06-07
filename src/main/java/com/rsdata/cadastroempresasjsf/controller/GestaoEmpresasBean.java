package com.rsdata.cadastroempresasjsf.controller;

import com.rsdata.cadastroempresasjsf.model.Empresa;
import com.rsdata.cadastroempresasjsf.model.RamoAtividade;
import com.rsdata.cadastroempresasjsf.model.TipoEmpresa;
import com.rsdata.cadastroempresasjsf.repository.EmpresasRepository;
import com.rsdata.cadastroempresasjsf.repository.RamoAtividadeRepository;
import com.rsdata.cadastroempresasjsf.service.CadastroEmpresaService;
import com.rsdata.cadastroempresasjsf.util.FacesMessages;
import com.rsdata.cadastroempresasjsf.util.GrowlView;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.PrimeRequestContext;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
//@RequestScoped //É recarregado toda vez que uma requisição é feita, seja ela um get ou um post.
@ViewScoped
//É recarregado tão e somente quando a tela é recarregada, termina junto com a sessão ou quando acontece uma navegação.
//@SessionScoped //É recarregado quando a sessão terminar, termina junto com a sessão.
//@ApplicationScoped //É recarregado quando o aplicativo terminar.

public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresasRepository empresasRepository;

    @Inject
    private RamoAtividadeRepository ramoAtividadeRepository;

    @Inject
    private FacesMessages messages;

    @Inject
    private GrowlView growlView;

    @Getter
    @Setter
    private Empresa empresa = new Empresa();

    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    @Getter
    @Setter
    private String searchValue;

    @Getter
    @Setter
    private Converter ramoAtividadeConverter;

    @Getter
    @Setter
    private List<Empresa> empresasList;

    public void createNewEmpresa(){
        this.empresa = new Empresa();
    }

    public void edit(){
        ramoAtividadeConverter = new RamoAtividadeConverter(Collections.singletonList(empresa.getRamoAtividade()));
    }

    public void delete(){
        cadastroEmpresaService.delete(empresa);
        empresa = null;
        updateTable();
        growlView.showInfo("Empresa excluída com sucesso!");
    }

    public void findAllEmpresas() {
        this.empresasList = this.empresasRepository.findAll();
    }

    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }

    public void save() {
        this.cadastroEmpresaService.save(this.empresa);
        updateTable();
        growlView.showInfo("Empresa Cadastrada com sucesso!");
    }


    public void search() {
        empresasList = this.empresasRepository.search(this.searchValue);
        if (empresasList.isEmpty()) {
            growlView.showInfo("Sua pesquisa encontrou 0 resultados");
        }
    }

    public List<RamoAtividade> searchRamoAtividade(String query) {
        List<RamoAtividade> ramoAtividadeList = this.ramoAtividadeRepository.search(query);
        ramoAtividadeConverter = new RamoAtividadeConverter(ramoAtividadeList);
        return ramoAtividadeList;
    }

    public boolean searchIsNotNull(){
        return this.searchValue != null && !this.searchValue.isEmpty();
    }

    public boolean isEmpresaSelecionada(){
        return empresa!= null && empresa.getId() != null;
    }

    public void updateTable(){
        if(searchIsNotNull()){
            search();
        }else{
            findAllEmpresas();
        }
    }
}

