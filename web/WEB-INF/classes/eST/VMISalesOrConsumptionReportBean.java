/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.CommonAdapter;
import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class VMISalesOrConsumptionReportBean extends StAdapter implements Serializable
{
	private String supp_code="";
	
public ArrayList getArrayCodeList() throws Exception{

        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"));
          
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
}

public String getDoc_type_code_ListOptions(){
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add( getLanguageId());	 
		return getListOptionTag(getListOptionArrayList("SELECT   a.doc_type_code, b.short_desc FROM st_trn_doc_type a,sy_doc_type_master_lang_vw b,sy_acc_entity_doc_type c WHERE a.facility_id = ? AND a.doc_type_code = b.doc_type_code AND a.trn_type  IN ('SAL', 'SRT') AND  a.doc_type_code = c.doc_type_code AND b.language_id = ?  ORDER BY 2, 1",alParameters));
}

public void setSupp_code(String supp_code) {
		 this.supp_code = checkForNull(supp_code);
}

public String getSupp_code( ) {
		 return supp_code;
}

public String getSupp_code_List() {
			
return  getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),getLanguageId()),getSupp_code());
}


}
