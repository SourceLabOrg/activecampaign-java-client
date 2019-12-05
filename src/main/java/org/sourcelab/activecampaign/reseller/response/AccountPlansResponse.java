package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class AccountPlansResponse {
    private final Map<String, AccountPlan> plans;

    @JsonCreator
    public AccountPlansResponse(
        @JsonProperty("plans") final Map<String, AccountPlan> plans
    ) {
        this.plans = plans;
    }

    public List<AccountPlan> getPlans() {
        return Collections.unmodifiableList(new ArrayList<>(plans.values()));
    }

    public AccountPlan getPlanById(final int id) {
        return plans.get(Integer.toString(id));
    }

    @Override
    public String toString() {
        return "AccountPlansResponse{"
            + "plans=" + plans
            + '}';
    }
}
