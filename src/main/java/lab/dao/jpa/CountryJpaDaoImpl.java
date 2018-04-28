package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDao")
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    @Override
    public void save(Country country) {
        withEntityManagerInTransaction(em -> em.merge(country));
    }

    @Override
    public List<Country> getAllCountries() {
        return mapEntityManagerInTransaction(em ->
                em.createQuery(
                        "select c from SimpleCountry c", Country.class)
                        .getResultList());
    }

    @Override
    public Country getCountryByName(String name) {
        return mapEntityManagerInTransaction(em ->
                em.createQuery(
                        "select c from SimpleCountry c where c.name like :name",
                        Country.class)
                        .setParameter("name", name)
                        .getSingleResult());
    }

}
