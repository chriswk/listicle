package db.migration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.flywaydb.core.api.migration.MigrationChecksumProvider;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;
import org.springframework.core.io.ClassPathResource;

public class V4__Import_Countries_From_Csv implements JdbcMigration, MigrationChecksumProvider {

    @Override
    public void migrate(Connection connection) throws Exception {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("iso_3166_alpha2")
                .addColumn("iso_3166_alpha3")
                .addColumn("name")
                .build();
        MappingIterator<Map<String, String>> countryRowIterator = mapper
                .readerFor(Map.class)
                .with(schema)
                .readValues(new ClassPathResource("countries.csv").getURL());
        String insertSql = "INSERT INTO listicle.country(id, iso_3166_alpha2, iso_3166_alpha3, name) VALUES (?," +
                " ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
            connection.setAutoCommit(false);
            while (countryRowIterator.hasNext()) {
                Map<String, String> country = countryRowIterator.next();
                ps.setLong(1, getLong(country, "id"));
                ps.setString(2, country.get("iso_3166_alpha2"));
                ps.setString(3, country.get("iso_3166_alpha3"));
                ps.setString(4, country.get("name"));
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
        }
    }

    private long getLong(Map<String, String> country, String id) {
        return Long.parseLong(country.get(id));
    }

    @Override
    public Integer getChecksum() {
        try {
            return new ClassPathResource("countries.csv").getFile().hashCode();
        } catch (IOException e) {
            return -1;
        }
    }
}
