package com.example.togglzDemo;

import jdk.jfr.Label;
import org.togglz.core.Feature;

public enum FeatureFlags implements Feature {

    @Label("increase the price for Diwali")
    PRICE_INCREASE;
}
