package com.trendyol.stockqry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

/**
 * @author meverg
 */
@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

  @Override public String getConnectionString() {
    return "localhost";
  }

  @Override public String getUserName() {
    return "admin";
  }

  @Override public String getPassword() {
    return "123456gs";
  }

  @Override public String getBucketName() {
    return "products";
  }
}
