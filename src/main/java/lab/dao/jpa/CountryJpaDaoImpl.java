package lab.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import lombok.val;
import org.springframework.stereotype.Repository;

import lab.dao.CountryDao;
import lab.model.Country;

@Repository("countryDao")
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
        //		TODO: Implement it
		try (val em = new com.skb.lombok.demo.EntityManager(null)) {
            //		TODO: Implement it
        }
	}

	@Override
	public List<Country> getAllCountries() {
//	TODO: Implement it
		return null	;
	}// getAllcountries()

	@Override
	public Country getCountryByName(String name) {
//		TODO: Implement it

		return null;
	}

}
