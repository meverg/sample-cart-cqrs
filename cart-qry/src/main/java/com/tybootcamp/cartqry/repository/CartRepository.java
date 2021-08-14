package com.tybootcamp.cartqry.repository;

import com.tybootcamp.cartqry.entity.Cart;
import java.util.Optional;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author meverg
 */
@Repository
public interface CartRepository extends CouchbaseRepository<Cart, String> {

  Optional<Cart> findByCustomerIdAndActive(String customerId, Boolean active);
}
