package org.app.pricing_models;

import lombok.Getter;

@Getter
public class PriceCalculator {
    PricingModel pricingModel;

    public PriceCalculator(PricingModel pricingModel){
        this.pricingModel = pricingModel;
    }
}
