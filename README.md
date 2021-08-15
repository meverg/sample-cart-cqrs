# sample-cart-cqrs

These services needs below applications to run. A docker compose will be added but you need to run and configure them manually.
- axon server
- couchbase
  - set up new cluster ( cluster_name: trendyol | admin: admin | pass:123456gs )
  - in case memory error increase docker memory
  - add bucket: carts
  - CREATE INDEX `carts_customer_active_idx` ON `carts`(customerId, active)
  - CREATE INDEX carts_items_product_id_idx ON `carts`(DISTINCT ARRAY item.productId FOR item IN items END)
  - ————
  - add bucket: products
- rabbit mq
  - add queues (and needed exchanges and bindings): stock.product.quantity, stock.product.price
