package br.com.playground.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Map;

import static jakarta.persistence.Persistence.createEntityManagerFactory;
import static org.hibernate.cfg.SchemaToolingSettings.JAKARTA_HBM2DDL_DATABASE_ACTION;
import static org.hibernate.tool.schema.Action.CREATE;
import static org.hibernate.tool.schema.Action.UPDATE;

public class ConnectionFactory {
    private static final String PERSISTENCE_UNIT = "example";
    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager() {

         factory = createEntityManagerFactory(PERSISTENCE_UNIT,
                Map.of(JAKARTA_HBM2DDL_DATABASE_ACTION, UPDATE));

        return factory.createEntityManager();

    }
}
