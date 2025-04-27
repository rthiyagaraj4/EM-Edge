/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import eSS.*;
public final class CodeSetupBean extends eSS.Common.SsAdapter implements Serializable{

/*	ArrayList alRecords			=	null;
	
	public void init(String module_id, String function_id, String resp_id, String menu_id)throws Exception{
		String []stParameters	=	{resp_id, menu_id, function_id, module_id, menu_id, function_id};
		alRecords				=	fetchRecords(getMmRepositoryValue("SQL_SM_SUB_FUNCTION_SELECT_MENU"),stParameters);
	}
 

	public String getScript(){
		HashMap hmRecord		=	null;
		StringBuffer sbScript	=	new StringBuffer();
		String table_name		=	null;
		try { 
			for (int i=0;i<alRecords.size() ;i++ ) {
				hmRecord=(HashMap)alRecords.get(i);
				if (hmRecord.get("INCL_YN").toString().equals("N")) continue;		
				if (i==0) table_name=hmRecord.get("TABLE_NAME").toString();
				if (!hmRecord.get("TABLE_NAME").toString().equals(table_name) && i!=0) break;
				sbScript.append(hmRecord.get("SUBFUNCTIONS").toString());
				sbScript.append("\n");
			}
		}
		catch (Exception exception) {
				sbScript.append(exception.toString());
		}
		return sbScript.toString();
	}

	public ArrayList getMenuDetail(){
		HashMap hmRecord		=	null;
		ArrayList alReturn		=	new ArrayList();
		String table_name		=	null;
		try { 
			for (int i=0;i<alRecords.size() ;i++ ) {
				hmRecord=(HashMap)alRecords.get(i);
				if (hmRecord.get("INCL_YN").toString().equals("N")) continue;		
				if (i==0) table_name=hmRecord.get("TABLE_NAME").toString();
				if (!hmRecord.get("TABLE_NAME").toString().equals(table_name) && i!=0) break;
				alReturn.add(hmRecord);
			}
		}
		catch (Exception exception) {
				alReturn.add(exception.toString());
		}
		return alReturn;
	}

	public ArrayList isSSIVModuleInstalled() throws Exception
		{
		HashMap		hmSSIV		=	null;	
		ArrayList	arrSSIV		=	new  ArrayList();
        
		hmSSIV	=	new HashMap();
		hmSSIV.put("IV",checkForNull(MM_license_rights.getSTboundary()));
		hmSSIV.put("SS",checkForNull(MM_license_rights.getSSboundary()));
		hmSSIV.put("PO",checkForNull(MM_license_rights.getPOboundary()));
		arrSSIV.add(hmSSIV);

/*		HashMap		hmSSIV		=	null;	

		java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_ITEM_INST_PARAM"));
			resultSet=preparedStatement.executeQuery();
			while ((resultSet != null) && (resultSet.next()))
				{
					hmSSIV	=	new HashMap();
					hmSSIV.put("IV",checkForNull(resultSet.getString(1)));
					hmSSIV.put("SS",checkForNull(resultSet.getString(2)));
					arrSSIV.add(hmSSIV);
				}
		}
		catch (Exception exception){
			exception.printStackTrace();
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
		
		return arrSSIV;
	}	*/


}
