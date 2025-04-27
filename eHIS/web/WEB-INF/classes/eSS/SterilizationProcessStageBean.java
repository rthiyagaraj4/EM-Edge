/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;

import eCommon.SingleTableHandler.*;


public class SterilizationProcessStageBean extends SsMultipleInsertMasterBean implements java.io.Serializable{
	public SterilizationProcessStageBean() 	{
		super.InsertSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STER_PROCESS_STAGE_INSERT");
		super.ModifySQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STER_PROCESS_STAGE_SELECT_SINGLE");
		super.UpdateSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STER_PROCESS_STAGE_UPDATE");
		super.SelectSQL = eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STER_PROCESS_STAGE_COUNT");
		super.codeFieldName = "process_stage_code";
	}
}
