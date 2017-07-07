package sherry.domain;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crossing on 2017-7-4.
 */
@Repository
public class CustomerRepositoryImpl implements iCustomerRepository {
    private final List<Customer> customers = new ArrayList<Customer>();

    public CustomerRepositoryImpl() {
        this.customers.add(new Customer(1L, "Oliver", "Gierke"));
        this.customers.add(new Customer(2L, "andy", "Wilkinson"));
        this.customers.add(new Customer(2L, "Dave", "Syer"));
    }

    @Override
    public List<Customer> findAll() {
        return this.customers;
    }

    @Override
    public Customer findOne(Long id) {
        for (Customer customer : customers) {
            if (ObjectUtils.nullSafeEquals(customer.getId(), id)) {
                return customer;
            }
        }
        return null;
    }
}
