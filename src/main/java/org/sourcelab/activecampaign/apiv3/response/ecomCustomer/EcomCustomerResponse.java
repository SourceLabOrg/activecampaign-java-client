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

package org.sourcelab.activecampaign.apiv3.response.ecomCustomer;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcomCustomerResponse {
    private final Map<String, Object> ecomValues;

    public EcomCustomerResponse(
            @JsonProperty("ecomCustomer") final Map<String, Object> ecomValues) {
        this.ecomValues = ecomValues;
    }

    public Map<String, Object> getEcomValues() {
        return ecomValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EcomCustomerResponse that = (EcomCustomerResponse) o;
        return Objects.equals(ecomValues, that.ecomValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ecomValues);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EcomCustomerResponse.class.getSimpleName() + "[", "]")
                .add("ecomValues=" + ecomValues)
                .toString();
    }
}