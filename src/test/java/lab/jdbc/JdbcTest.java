package lab.jdbc;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lab.JavaConfig;
import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.SimpleCountry;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static lab.dao.CountryDao.COUNTRY_INIT_DATA;
import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE)
class JdbcTest {

    CountryDao countryDao;

    @NonFinal
    List<Country> expectedCountryList;

    @NonFinal
    List<Country> expectedCountryListStartsWithA;

    @BeforeEach
    void setUp() {
        initExpectedCountryLists();
        countryDao.loadCountries();
    }


    @Test
    @DirtiesContext
    void testCountryList() {
        List<Country> countryList = countryDao.getCountryList();
        assertNotNull(countryList);
        assertEquals(expectedCountryList.size(), countryList.size());
        for (int i = 0; i < expectedCountryList.size(); i++)
            assertThat(countryList.get(i), is(expectedCountryList.get(i)));
    }

    @Test
    @DirtiesContext
    void testCountryListStartsWithA() {
        List<Country> countryList = countryDao.getCountryListStartWith("A");
        assertNotNull(countryList);
        assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
        for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
            assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
        }
    }

    @Test
    @DirtiesContext
    void testCountryChange() {
        countryDao.updateCountryName("RU", "Russia");
        val country = new SimpleCountry(8, "Russia", "RU");
        assertThat(countryDao.getCountryByCodeName("RU"), is(country));
    }

    //    private void initExpectedCountryLists() {
//        expectedCountryList = IntStream.range(0, COUNTRY_INIT_DATA.length)
//                .mapToObj(i -> Tuple.of(COUNTRY_INIT_DATA[i], i + 1))
//                .map(countryDataAndIndex -> new SimpleCountry(
//                        countryDataAndIndex._2,
//                        countryDataAndIndex._1[0],
//                        countryDataAndIndex._1[1]))
//                .collect(Collectors.toList());
//
//        expectedCountryListStartsWithA = expectedCountryList.stream()
//                .filter(country -> country.getName().startsWith("A"))
//                .collect(Collectors.toList());
//    }
    private void initExpectedCountryLists() {
        expectedCountryList = new ArrayList<>();
        expectedCountryListStartsWithA = new ArrayList<>();
        int bound = COUNTRY_INIT_DATA.length;
        for (int i = 0; i < bound; i++) {
            Tuple2<String[], Integer> countryDataAndIndex =
                    Tuple.of(COUNTRY_INIT_DATA[i], i + 1);
            SimpleCountry country = new SimpleCountry(
                    countryDataAndIndex._2,
                    countryDataAndIndex._1[0],
                    countryDataAndIndex._1[1]);
            expectedCountryList.add(country);

            if (country.getName().startsWith("A")) {
                expectedCountryListStartsWithA.add(country);
            }
        }
    }
}