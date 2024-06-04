package com.rsdata.cadastroempresasjsf.repository;

import com.rsdata.cadastroempresasjsf.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Empresas implements Serializable {

    private EntityManager entityManager;

    public Empresa findById(Long id){
        return entityManager.find(Empresa.class, id);
    }

    public List<Empresa> search(String nome){
        return entityManager.createQuery("from Empresa e where nomeFantasia like :nome", Empresa.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public Empresa save(Empresa empresa){
        return entityManager.merge(empresa);
    }

    public void delete(Empresa empresa){
        entityManager.remove(empresa);
    }

}
