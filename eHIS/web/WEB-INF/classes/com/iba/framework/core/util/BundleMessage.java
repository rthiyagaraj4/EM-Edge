/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

import java.util.ResourceBundle;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;

public final class BundleMessage {

	public static String getBundleMessage(PageContext pageContext,
			String messageKey, String bundleName, String[] params) {
		String returnText = getBundleMessage(pageContext, messageKey,
				bundleName);

		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				messageKey = params[i];
				if (messageKey != null) {
					if (messageKey.indexOf(".") != -1) {
						int msgLen = messageKey.length();
						bundleName = ((messageKey.substring(1, messageKey
								.indexOf("."))).toLowerCase())
								+ "_labels";
						String val = com.iba.framework.core.util.BundleMessage
								.getBundleMessage(pageContext, messageKey,
										bundleName);
						// System.out.println("value is here:"+val);
						if (!val.equals(""))
							params[i] = val;
					}
				}

			}
		}

		returnText = java.text.MessageFormat.format(returnText, params);
		return returnText;

	}

	public static String getBundleMessage(PageContext pageContext,
			String messageKey, String bundleName) {

		LocalizationContext locCxt = null;

		if ((pageContext.getSession()).getAttribute(bundleName) != null) {
			locCxt = (LocalizationContext) (pageContext.getSession())
					.getAttribute(bundleName);
		} else if ((pageContext.getServletContext()).getAttribute(bundleName) != null) {
			locCxt = (LocalizationContext) (pageContext.getServletContext())
					.getAttribute(bundleName);
		} else if ((pageContext.getRequest()).getAttribute(bundleName) != null) {
			locCxt = (LocalizationContext) (pageContext.getRequest())
					.getAttribute(bundleName);
		}

		String returnText = "???" + messageKey + "???";

		if (locCxt != null) {
			if (locCxt.getResourceBundle() != null) {
				ResourceBundle rsrcBundle = (ResourceBundle) locCxt
						.getResourceBundle();

				if (rsrcBundle.getString(messageKey) != null)
					returnText = rsrcBundle.getString(messageKey);

			} else
				returnText = "bundle not available";
		}
		return returnText;

	}

}
