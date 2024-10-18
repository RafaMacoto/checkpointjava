package org.example.factory;

import org.example.dao.*;

public class DaoFactory {
    private DaoFactory() {}

    public static ClienteDao getClienteDao() {
        return new ClienteDaoImpl();
    }

    public static ApoliceDao getApoliceDao() {
        return new ApoliceDaoImpl();
    }

    public static SeguroDao getSeguroDao() {
        return new SeguroDaoImpl();
    }

    public static SinistroDao getSinistroDao() {
        return new SinistroDaoImpl();
    }

    public static CorretorDao getCorretorDao() {
        return new CorretorDaoImpl();
    }
}
