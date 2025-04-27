/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
*Module			:	eSS
*Function		:	Surgery Type
*/
package eSS ;

public class SubClassificationBean  extends SsMultipleInsertMasterBean implements java.io.Serializable{

	public SubClassificationBean() 	{
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SUB_CLASSIFICATION_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SUB_CLASSIFICATION_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SUB_CLASSIFICATION_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SUB_CLASSIFICATION_COUNT");
		super.codeFieldName = "sub_classification_code";
		
	}
}
