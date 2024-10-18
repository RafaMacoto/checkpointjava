package org.example.model;

public enum TipoSeguro {

    VIDA, AUTOMOVEL, RESIDENCIAL, SAUDE, VIAGEM;

    @Override
    public String toString() {
        switch (this) {
            case VIDA:
                return "Seguro de Vida";
            case AUTOMOVEL:
                return "Seguro Automóvel";
            case RESIDENCIAL:
                return "Seguro Residencial";
            case SAUDE:
                return "Seguro Saúde";
            case VIAGEM:
                return "Seguro Viagem";
            default:
                return "Tipo Desconhecido";
        }
    }
}
