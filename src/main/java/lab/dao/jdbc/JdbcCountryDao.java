package lab.dao.jdbc;

import io.vavr.Function2;
import io.vavr.Tuple;
import lab.dao.CountryNotFoundException;
import lab.model.Country;
import lab.model.SimpleCountry;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static common.Utils.mapOf;
import static java.util.Collections.singletonMap;
import static lombok.AccessLevel.PRIVATE;

@Repository
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class JdbcCountryDao extends NamedParameterJdbcDaoSupport {

    static String CODE_NAME = "codeName";
    static String NAME = "name";

    public static String[][] COUNTRY_INIT_DATA = {
            {"Australia", "AU"},
            {"Canada", "CA"},
            {"France", "FR"},
            {"Hong Kong", "HK"},
            {"Iceland", "IC"},
            {"Japan", "JP"},
            {"Nepal", "NP"},
            {"Russian Federation", "RU"},
            {"Sweden", "SE"},
            {"Switzerland", "CH"},
            {"United Kingdom", "GB"},
            {"United States", "US"}};

    static String INSERT_SQL = "insert into country (name, code_name) values (:name, :codeName)";
    static String GET_ALL_SQL = "select id, name, code_name from country";
    static String GET_COUNTRIES_BY_NAME_SQL = "select id, name, code_name from country where name like :name";
    static String GET_COUNTRY_BY_NAME_SQL = "select id, name, code_name from country where name = :name";
    static String GET_COUNTRY_BY_CODE_SQL = "select id, name, code_name from country where code_name = :codeName";
    static String UPDATE_COUNTRY_NAME_BY_CODE_SQL = "update country set name = :name where code_name = :codeName";

    static RowMapper<Country> COUNTRY_ROW_MAPPER = (rs, __) ->
            new SimpleCountry(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code_name"));

    Function<Map<String, String>, Integer> insert;

    public JdbcCountryDao(DataSource dataSource) {
        setDataSource(dataSource);
        insert = Function2.<String, Map<String, String>, Integer>of(getNamedParameterJdbcTemplate()::update)
                .apply(INSERT_SQL);
    }

    public void loadCountries() {
        Arrays.stream(COUNTRY_INIT_DATA)
                .map(countryData -> mapOf(
                        Tuple.of(NAME, countryData[0]),
                        Tuple.of(CODE_NAME, countryData[1])))
                .forEach(insert::apply);
    }

    public List<Country> getCountryList() {
        return getJdbcTemplate().query(GET_ALL_SQL, COUNTRY_ROW_MAPPER);
    }

    public List<Country> getCountryListStartWith(String name) {
        return getNamedParameterJdbcTemplate()
                .query(GET_COUNTRIES_BY_NAME_SQL,
                        singletonMap(NAME, name + "%"),
                        COUNTRY_ROW_MAPPER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        //noinspection unchecked
        getNamedParameterJdbcTemplate().update(UPDATE_COUNTRY_NAME_BY_CODE_SQL,
                mapOf(Tuple.of(NAME, newCountryName),
                        Tuple.of(CODE_NAME, codeName)));
    }

    public Country getCountryByCodeName(String codeName) {
        return getNamedParameterJdbcTemplate().query(GET_COUNTRY_BY_CODE_SQL,
                singletonMap(CODE_NAME, codeName),
                COUNTRY_ROW_MAPPER)
                .get(0);
    }

    public Country getCountryByName(String name) {
        List<Country> countryList =
                getNamedParameterJdbcTemplate().query(GET_COUNTRY_BY_NAME_SQL,
                        singletonMap(NAME, name),
                        COUNTRY_ROW_MAPPER);

        if (countryList.isEmpty())
            throw new CountryNotFoundException();

        return countryList.get(0);
    }
}
