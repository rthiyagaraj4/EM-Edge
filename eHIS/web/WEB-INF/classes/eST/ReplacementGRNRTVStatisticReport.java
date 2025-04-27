/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;


//* pmd 21/02/2005
//*import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
//*import javax.naming.InitialContext;
//*import javax.rmi.PortableRemoteObject;
//import eCoon.Coon.CoonRepository;
import eST.Common.StRepository;
import eCommon.SingleTableHandler.*;
//*import java.util.StringTokenizer;



public class ReplacementGRNRTVStatisticReport extends eST.Common.StTransaction implements java.io.Serializable{
//private String language;
public ArrayList getStoreList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrStore		=	new  ArrayList();
		HashMap		hmStore			=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LIST")); 
				pstmt.setString(1, getLanguageId());
				resultSet = pstmt.executeQuery();
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmStore			=	new HashMap();
					hmStore.put("code",checkForNull(resultSet.getString(1)));
					hmStore.put("description",checkForNull(resultSet.getString(2)));
					arrStore.add(hmStore);
				}
			} 
			catch (Exception e )
			{
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrStore;
		}

/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}
*/
}
