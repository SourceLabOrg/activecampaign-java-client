/**
 * Copyright 2021 Unicornify https://github.com/unicornify/activecampaign-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.sourcelab.activecampaign.apiv3.request.ecomOrder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDate;
import java.util.List;

@JsonRootName(value = "ecomOrder")
public class EcomOrder {
    @JsonProperty("externalid")
    private final String externalId;
    @JsonProperty("externalcheckoutid")
    private final String externalCheckoutId;
    private final Long source;
    private final String email;
    private final List<Product> orderProducts;
    private final LocalDate externalCreatedDate;
    private final String shippingMethod;
    private final Integer totalPrice;
    private final String currency;
    @JsonProperty("connectionid")
    private final Long connectionId;
    @JsonProperty("customerid")
    private final Long customerId;

    public EcomOrder(String externalId, String externalCheckoutId, Long source, String email, List<Product> orderProducts,
                     LocalDate externalCreatedDate, String shippingMethod, Integer totalPrice, String currency,
                     Long connectionId, Long customerId) {
        this.externalId = externalId;
        this.externalCheckoutId = externalCheckoutId;
        this.source = source;
        this.email = email;
        this.orderProducts = orderProducts;
        this.externalCreatedDate = externalCreatedDate;
        this.shippingMethod = shippingMethod;
        this.totalPrice = totalPrice;
        this.currency = currency;
        this.connectionId = connectionId;
        this.customerId = customerId;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getExternalCheckoutId() {
        return externalCheckoutId;
    }

    public Long getSource() {
        return source;
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getOrderProducts() {
        return orderProducts;
    }

    public LocalDate getExternalCreatedDate() {
        return externalCreatedDate;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getConnectionId() {
        return connectionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        private final String name;
        private final Integer price;
        private final Integer quantity;
        private final String category;

        public Product(String name, Integer price, Integer quantity, String category) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public Integer getPrice() {
            return price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public String getCategory() {
            return category;
        }

    }
}

