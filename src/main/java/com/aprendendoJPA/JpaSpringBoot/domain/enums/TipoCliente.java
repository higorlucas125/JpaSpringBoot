package com.aprendendoJPA.JpaSpringBoot.domain.enums;

public enum  TipoCliente {

    PESSOAFISICA(1,"Pessoa Física"),
    PESSSOAJURIDICA(1,"Pesso Jurídica");

    private int COD;
    private String descricao;

    private TipoCliente(int COD,String descricao){
         this.COD = COD;
         this.descricao = descricao;
    }

    public int getCOD() {
        return COD;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer COD){
        if(COD == null){
            return null;
        }
        for (TipoCliente x : TipoCliente.values()){
            if (COD.equals(x.getCOD())){
                return x;
            }
        }

        throw new IllegalArgumentException("ID inválido " + COD);
    }
}
