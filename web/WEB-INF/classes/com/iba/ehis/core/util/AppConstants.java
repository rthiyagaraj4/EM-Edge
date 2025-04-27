/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.ehis.core.util;

import com.iba.framework.core.util.Constants;

/**
 * @author yadavk
 * 
 */
public interface AppConstants extends Constants {
	String DUPLICATE_RECORD = "APP_501";

	public int QUERY_CRITERIA = 11;

	public int QUERY_RESULT = 12;

	public String CODE_DESC = "CODE_DESC";

	public String DESC_CODE = "DESC_CODE";

	public String searchByCode = "searchByCode";

	public String searchByDesc = "searchByDesc";

	public String OPERATION_CHILD__FAILURE = "MESSAGE.OPERATION.CHILDRECORD_FAILURE";

	String DIETRY = "DS";

	String LINEN = "LC";

	String JBOSSCACHE ="jbosscache";

	String EHCACHE ="ehcache";
}
