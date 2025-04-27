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

public class WriteOffReasonBean  extends SsMultipleInsertMasterBean implements java.io.Serializable{

	public WriteOffReasonBean() 	{
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_REASON_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_REASON_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_REASON_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_WRITE_OFF_REASON_COUNT");
		super.codeFieldName = "write_off_reason_code";
	}
}
