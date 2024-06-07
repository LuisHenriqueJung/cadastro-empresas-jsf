package com.rsdata.cadastroempresasjsf.repository;

import com.rsdata.cadastroempresasjsf.model.Empresa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class EmpresasRepository implements Serializable {

    @Inject
    private EntityManager entityManager;

    public EmpresasRepository(){}

    public EmpresasRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Empresa findById(Long id){
        return entityManager.find(Empresa.class, id);
    }

    public List<Empresa> search(String nome){
        return entityManager.createQuery("from Empresa e where nomeFantasia like :nome", Empresa.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public List<Empresa> findAll(){
        return entityManager.createQuery("from Empresa", Empresa.class).getResultList();
    }

    public Empresa save(Empresa empresa){
        return entityManager.merge(empresa);
    }

    public void delete(Empresa empresa){
        empresa = findById(empresa.getId());
        entityManager.remove(empresa);
    }

}
