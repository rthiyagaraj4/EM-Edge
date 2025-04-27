/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

public class WashingTypeBean  extends SsMultipleInsertMasterBean implements java.io.Serializable{
	public WashingTypeBean() {
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WASHING_TYPE_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WASHING_TYPE_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WASHING_TYPE_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WASHING_TYPE_COUNT");
		super.codeFieldName = "washing_type";
	}
}
