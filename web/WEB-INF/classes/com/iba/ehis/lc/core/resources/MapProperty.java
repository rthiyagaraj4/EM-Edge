/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.core.resources;

import java.util.*;

public class MapProperty {
	public String mapLabel(String bundle, String key) {
		Locale locale = Locale.ENGLISH;
		ResourceBundle myResources = ResourceBundle.getBundle(bundle, locale);
		String label = myResources.getString(key);
		return label;
	}
}
