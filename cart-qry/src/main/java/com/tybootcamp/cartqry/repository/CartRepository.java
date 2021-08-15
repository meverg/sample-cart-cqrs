package com.tybootcamp.cartqry.repository;

import com.tybootcamp.cartqry.entity.Cart;
import java.util.List;
import java.util.Optional;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author meverg
 */
@Repository
public interface CartRepository extends CouchbaseRepository<Cart, String> {

  Optional<Cart> findByCustomerIdAndActive(String customerId, Boolean active);

  @Query(
      "SELECT carts.*, META(`carts`).id AS __id, META(`carts`).cas AS __cas FROM `carts` UNNEST items item WHERE "
      + "item.productId = \"bac8e899-3cd9-4930-a292-2b92aafd5d3d\"")
  List<Cart> findAllCartsContainingProduct(@Param("productId") String productId);
}
