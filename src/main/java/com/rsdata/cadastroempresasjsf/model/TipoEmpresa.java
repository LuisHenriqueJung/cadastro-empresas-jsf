package com.rsdata.cadastroempresasjsf.model;

public enum TipoEmpresa {
    MEI("Microempreendedor Individual"),
    EIRELI("Empresarial Individual"),
    LTDA("Sociedade Limitada"),
    SA("Sociedade Anonima");
    private String descricao;
    TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }
}
