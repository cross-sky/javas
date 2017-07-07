package sherry.web;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sherry.domain.Customer;
import sherry.domain.iCustomerRepository;



/**
 * Created by Crossing on 2017-7-4.
 */
@Controller
@RequestMapping("/customers")
@ExposesResourceFor(Customer.class)
public class CustomerController {
    private final iCustomerRepository repository;
    private final EntityLinks entityLinks;

    public CustomerController(iCustomerRepository repository, EntityLinks entityLinks) {
        this.repository = repository;
        this.entityLinks = entityLinks;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resources<Customer>> showCustomers() {
        Resources<Customer> resources = new Resources<Customer>(this.repository.findAll());
        resources.add(this.entityLinks.linkToCollectionResource(Customer.class));
        return new ResponseEntity<Resources<Customer>>(resources, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HttpEntity<Resource<Customer>> showCustomer(@PathVariable Long id) {
        Resource<Customer> resource = new Resource<Customer>(this.repository.findOne(id));
        resource.add(this.entityLinks.linkToCollectionResource(Customer.class));
        return new ResponseEntity<Resource<Customer>>(resource, HttpStatus.OK);
    }


}
