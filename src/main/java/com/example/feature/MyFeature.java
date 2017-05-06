package com.example.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyFeature implements Feature {

	@EnabledByDefault
	@Label("Feature One")
	FEATURE_ONE,
	
	@EnabledByDefault
	@Label("Feature Two")
	FEATURE_TWO;
	
	public boolean isActive() {
		return FeatureContext.getFeatureManager().isActive(this);
	}
}
