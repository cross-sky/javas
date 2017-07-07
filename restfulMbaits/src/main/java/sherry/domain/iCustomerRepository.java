package sherry.domain;

import java.util.List;

/**
 * Created by Crossing on 2017-7-4.
 */
public interface iCustomerRepository {
    List<Customer> findAll();
    Customer findOne(Long id);
}
