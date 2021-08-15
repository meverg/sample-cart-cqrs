package com.trendyol.stockqry.repository;

import com.trendyol.stockqry.entity.Product;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author meverg
 */
@Repository
public interface ProductRepository extends CouchbaseRepository<Product, String> {

}
