package org.rich.gcp.sql.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.rich.gcp.sql.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> findByFirstName(String firstName) {
        return list("firstname", firstName);
    }
}
