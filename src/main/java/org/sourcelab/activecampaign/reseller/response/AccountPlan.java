package org.sourcelab.activecampaign.reseller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class AccountPlan {
    private final long id;
    private final int term;
    private final int tier;
    private final int price;
    private final String currency;
    private final String priceFormatted;
    private final int limitMail;
    private final String limitMailFormatted;
    private final int limitSub;
    private final String limitSubFormatted;
    private final String style;
    private final String type;
    private final int emailTestCredits;
    private final String emailTestCreditsFormatted;
    private final int smsCredits;
    private final String smsCreditsFormatted;
    private final String erja;
    private final String termFormatted;
    private final String termFormattedPer;
    private final String termFormattedId;
    private final String termFormattedLy;
    private final String termFormattedShort;
    private final String pricePerMonthFormatted;
    private final String pricePerMonthFormattedShort;
    private final String pricePerMonthFormattedSmart;
    private final int price2Show;
    private final String price2ShowFormatted;

    /**
     * Constructor.
     */
    public AccountPlan(
        @JsonProperty("id") final long id,
        @JsonProperty("term") final int term,
        @JsonProperty("tier") final int tier,
        @JsonProperty("price") final int price,
        @JsonProperty("currency") final String currency,
        @JsonProperty("price_formatted") final String priceFormatted,
        @JsonProperty("limit_mail") final int limitMail,
        @JsonProperty("limit_mail_formatted") final String limitMailFormatted,
        @JsonProperty("limit_sub") final int limitSub,
        @JsonProperty("limit_sub_formatted") final String limitSubFormatted,
        @JsonProperty("style") final String style,
        @JsonProperty("type") final String type,
        @JsonProperty("emailtestcredits") final int emailTestCredits,
        @JsonProperty("emailtestcredits_formatted") final String emailTestCreditsFormatted,
        @JsonProperty("smscredits") final int smsCredits,
        @JsonProperty("smscredits_formatted") final String smsCreditsFormatted,
        @JsonProperty("erja") final String erja,
        @JsonProperty("term_formatted") final String termFormatted,
        @JsonProperty("term_formatted_per") final String termFormattedPer,
        @JsonProperty("term_formatted_id") final String termFormattedId,
        @JsonProperty("term_formatted_ly") final String termFormattedLy,
        @JsonProperty("term_formatted_short") final String termFormattedShort,
        @JsonProperty("price_permonth_formatted") final String pricePerMonthFormatted,
        @JsonProperty("price_permonth_formatted_short") final String pricePerMonthFormattedShort,
        @JsonProperty("price_permonth_formatted_smart") final String pricePerMonthFormattedSmart,
        @JsonProperty("price2show") final int price2Show,
        @JsonProperty("price2show_formatted") final String price2ShowFormatted) {
        this.id = id;
        this.term = term;
        this.tier = tier;
        this.price = price;
        this.currency = currency;
        this.priceFormatted = priceFormatted;
        this.limitMail = limitMail;
        this.limitMailFormatted = limitMailFormatted;
        this.limitSub = limitSub;
        this.limitSubFormatted = limitSubFormatted;
        this.style = style;
        this.type = type;
        this.emailTestCredits = emailTestCredits;
        this.emailTestCreditsFormatted = emailTestCreditsFormatted;
        this.smsCredits = smsCredits;
        this.smsCreditsFormatted = smsCreditsFormatted;
        this.erja = erja;
        this.termFormatted = termFormatted;
        this.termFormattedPer = termFormattedPer;
        this.termFormattedId = termFormattedId;
        this.termFormattedLy = termFormattedLy;
        this.termFormattedShort = termFormattedShort;
        this.pricePerMonthFormatted = pricePerMonthFormatted;
        this.pricePerMonthFormattedShort = pricePerMonthFormattedShort;
        this.pricePerMonthFormattedSmart = pricePerMonthFormattedSmart;
        this.price2Show = price2Show;
        this.price2ShowFormatted = price2ShowFormatted;
    }

    public long getId() {
        return id;
    }

    public int getTerm() {
        return term;
    }

    public int getTier() {
        return tier;
    }

    public int getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public int getLimitMail() {
        return limitMail;
    }

    public String getLimitMailFormatted() {
        return limitMailFormatted;
    }

    public int getLimitSub() {
        return limitSub;
    }

    public String getLimitSubFormatted() {
        return limitSubFormatted;
    }

    public String getStyle() {
        return style;
    }

    public String getType() {
        return type;
    }

    public int getEmailTestCredits() {
        return emailTestCredits;
    }

    public String getEmailTestCreditsFormatted() {
        return emailTestCreditsFormatted;
    }

    public int getSmsCredits() {
        return smsCredits;
    }

    public String getSmsCreditsFormatted() {
        return smsCreditsFormatted;
    }

    public String getErja() {
        return erja;
    }

    public String getTermFormatted() {
        return termFormatted;
    }

    public String getTermFormattedPer() {
        return termFormattedPer;
    }

    public String getTermFormattedId() {
        return termFormattedId;
    }

    public String getTermFormattedLy() {
        return termFormattedLy;
    }

    public String getTermFormattedShort() {
        return termFormattedShort;
    }

    public String getPricePerMonthFormatted() {
        return pricePerMonthFormatted;
    }

    public String getPricePerMonthFormattedShort() {
        return pricePerMonthFormattedShort;
    }

    public String getPricePerMonthFormattedSmart() {
        return pricePerMonthFormattedSmart;
    }

    public int getPrice2Show() {
        return price2Show;
    }

    public String getPrice2ShowFormatted() {
        return price2ShowFormatted;
    }

    @Override
    public String toString() {
        return "AccountPlan{"
            + "id=" + id
            + ", term=" + term
            + ", tier=" + tier
            + ", price=" + price
            + ", currency='" + currency + '\''
            + ", priceFormatted='" + priceFormatted + '\''
            + ", limitMail=" + limitMail
            + ", limitMailFormatted='" + limitMailFormatted + '\''
            + ", limitSub=" + limitSub
            + ", limitSubFormatted='" + limitSubFormatted + '\''
            + ", style='" + style + '\''
            + ", type='" + type + '\''
            + ", emailTestCredits=" + emailTestCredits
            + ", emailTestCreditsFormatted=" + emailTestCreditsFormatted
            + ", smsCredits=" + smsCredits
            + ", smsCreditsFormatted='" + smsCreditsFormatted + '\''
            + ", erja='" + erja + '\''
            + ", termFormatted='" + termFormatted + '\''
            + ", termFormattedPer='" + termFormattedPer + '\''
            + ", termFormattedId='" + termFormattedId + '\''
            + ", termFormattedLy='" + termFormattedLy + '\''
            + ", termFormattedShort='" + termFormattedShort + '\''
            + ", pricePerMonthFormatted='" + pricePerMonthFormatted + '\''
            + ", pricePerMonthFormattedShort='" + pricePerMonthFormattedShort + '\''
            + ", pricePerMonthFormattedSmart='" + pricePerMonthFormattedSmart + '\''
            + ", price2Show=" + price2Show
            + ", price2ShowFormatted='" + price2ShowFormatted + '\''
            + '}';
    }
}
