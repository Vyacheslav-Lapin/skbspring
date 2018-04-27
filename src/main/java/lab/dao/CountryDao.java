package lab.dao;

import lab.model.Country;
import lab.model.SimpleCountry;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Repository
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CountryDao extends NamedParameterJdbcDaoSupport {

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

    static String INSERT_COUNTRIES = "insert into country (name, code_name) values ('%s', '%s')";
    static String GET_ALL_COUNTRIES = "select id, name, code_name from country";
    static String GET_COUNTRIES_BY_NAME = "select id, name, code_name from country where name like :name";
    static String GET_COUNTRY_BY_NAME = "select id, name, code_name from country where name = '%s'";
    static String GET_COUNTRY_BY_CODE_NAME = "select id, name, code_name from country where code_name = '%s'";
    static String UPDATE_COUNTRY_NAME_BY_CODE = "update country set name='%s' where code_name='%s'";

    static RowMapper<Country> COUNTRY_ROW_MAPPER = (rs, __) ->
            new SimpleCountry(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code_name"));

    public CountryDao(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public List<Country> getCountryList() {
        return getJdbcTemplate().query(GET_ALL_COUNTRIES, COUNTRY_ROW_MAPPER);
    }

    public List<Country> getCountryListStartWith(String name) {
        return getNamedParameterJdbcTemplate()
                .query(GET_COUNTRIES_BY_NAME,
                        Collections.singletonMap("name", name + "%"),
                        COUNTRY_ROW_MAPPER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().update(
                String.format(UPDATE_COUNTRY_NAME_BY_CODE,
                        newCountryName,
                        codeName));
    }

    public void loadCountries() {
        Arrays.stream(COUNTRY_INIT_DATA)
                .map(countryData -> String.format(INSERT_COUNTRIES, countryData[0], countryData[1]))
                .forEach(getJdbcTemplate()::execute);
    }

    public Country getCountryByCodeName(String codeName) {
        String sql = String.format(GET_COUNTRY_BY_CODE_NAME, codeName);
        return getJdbcTemplate().query(sql, COUNTRY_ROW_MAPPER).get(0);
    }

    public Country getCountryByName(String name) {
        List<Country> countryList = getJdbcTemplate().query(
                String.format(GET_COUNTRY_BY_NAME, name), COUNTRY_ROW_MAPPER);
        if (countryList.isEmpty())
            throw new CountryNotFoundException();
        return countryList.get(0);
    }
}
