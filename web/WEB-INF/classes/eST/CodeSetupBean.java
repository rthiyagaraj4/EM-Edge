/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public final class CodeSetupBean extends eST.Common.StAdapter implements Serializable{


	public String getScript(String module_id){
		ArrayList alRecords		=	null;
		HashMap hmRecord		=	null;
		StringBuffer sbScript	=	new StringBuffer();
		try { 
			alRecords	=	fetchRecords(getStRepositoryValue("SQL_SM_SUBFUNCTION_SELECT_MENU_SCRIPT"),module_id);
			for (int i=0;i<alRecords.size() ;i++ ) {
				hmRecord=(HashMap)alRecords.get(i);
				sbScript.append(hmRecord.get("MASTER").toString());
				sbScript.append("\n");
			}
		}
		catch (Exception exception) {
				sbScript.append(exception.toString());
		}
		return sbScript.toString();
	}

	public ArrayList getMenuDetail(String menu_func_id) throws Exception{
		return fetchRecords(getStRepositoryValue("SQL_SM_MASTER_CODE_SELECT_MENU"),menu_func_id);
	}

}
