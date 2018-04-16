package lab.model;

public interface Country {
    int getId();

    String getName();

    String getCodeName();

    Country setId(int id);

    Country setName(String name);

    Country setCodeName(String codeName);
}
