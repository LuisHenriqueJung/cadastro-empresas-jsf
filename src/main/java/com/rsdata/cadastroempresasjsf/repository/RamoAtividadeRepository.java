package com.rsdata.cadastroempresasjsf.repository;

import com.rsdata.cadastroempresasjsf.model.RamoAtividade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class RamoAtividadeRepository implements Serializable {

    @Inject
    private EntityManager entityManager;

    public List<RamoAtividade> search(String  descricao){
        return entityManager.createQuery("from RamoAtividade r where descricao like :descricao", RamoAtividade.class)
                .setParameter("descricao", "%" + descricao +"%")
                .getResultList();
    }
}
