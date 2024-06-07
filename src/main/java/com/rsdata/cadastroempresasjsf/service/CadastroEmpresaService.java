package com.rsdata.cadastroempresasjsf.service;

import com.rsdata.cadastroempresasjsf.model.Empresa;
import com.rsdata.cadastroempresasjsf.repository.EmpresasRepository;
import com.rsdata.cadastroempresasjsf.util.Transactional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class CadastroEmpresaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresasRepository empresasRepository;

    public List<Empresa> findAll(){
        return empresasRepository.findAll();
    }
    @Transactional
    public void save(Empresa empresa){
        empresasRepository.save(empresa);
    }
    @Transactional
    public void delete(Empresa empresa){
        empresasRepository.delete(empresa);
    }
}
