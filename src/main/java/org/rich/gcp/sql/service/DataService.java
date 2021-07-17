package org.rich.gcp.sql.service;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@ApplicationScoped
public class DataService {

    private static final Logger LOG = Logger.getLogger(DataService.class);
    @Inject
    DataSource dataSource;

    public void query() throws SQLException {
        String query = "SELECT * FROM customer";
        Connection connection = dataSource.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                LOG.info("customer name: " + resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            LOG.error("SQL error", e);
        }
    }
}
