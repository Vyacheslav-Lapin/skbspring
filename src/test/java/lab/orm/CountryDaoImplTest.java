package lab.orm;

import lab.JavaConfig;
import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.SimpleCountry;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE)
class CountryDaoImplTest {

    @NonFinal
	Country exampleCountry = new SimpleCountry(1,"Australia", "AU");

	@Autowired
    CountryDao countryDao;

	static int countryCounter;

    @BeforeEach
    void setUp() {
        if (countryDao.getAllCountries().stream()
                .filter(country -> country.equals(exampleCountry))
                .collect(Collectors.toList()).isEmpty()) {
            countryDao.save(exampleCountry);
            countryCounter++;
        }
    }

    @Test
    void testSaveCountry() {
		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(countryCounter, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
    void testGetAllCountries() {

		countryDao.save(new SimpleCountry("Canada", "CA"));
		countryCounter++;

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(countryCounter, countryList.size());
	}

	@Test
    void testGetCountryByName() {
		Country country = countryDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
