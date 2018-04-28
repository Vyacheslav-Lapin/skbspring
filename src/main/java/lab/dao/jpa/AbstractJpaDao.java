package lab.dao.jpa;

import com.skb.lombok.demo.EntityManager;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class AbstractJpaDao {

    @Setter(onMethod = @__(@PersistenceUnit))
    protected EntityManagerFactory emf;

    protected <T> T mapEntityManagerInTransaction(Function<EntityManager, T> entityManagerMapper) {
        EntityTransaction transaction = null;
        try (val em = new com.skb.lombok.demo.EntityManager(
                emf.createEntityManager())) {
            transaction = em.getTransaction();
            transaction.begin();
            T result = entityManagerMapper.apply(em);
            transaction.commit();
            return result;
        } catch (Exception e) {
            log.error("Operation was not executed! - " + e);
            if (transaction != null)
                transaction.rollback();
            throw e;
        }
    }

    protected void withEntityManagerInTransaction(Consumer<EntityManager> entityManagerConsumer) {
        EntityTransaction transaction = null;
        try (val em = new com.skb.lombok.demo.EntityManager(
                emf.createEntityManager())) {
            transaction = em.getTransaction();
            transaction.begin();
            entityManagerConsumer.accept(em);
            transaction.commit();
        } catch (Exception e) {
            log.error("Operation was not executed! - " + e);
            if (transaction != null)
                transaction.rollback();
            throw e;
        }
    }
}