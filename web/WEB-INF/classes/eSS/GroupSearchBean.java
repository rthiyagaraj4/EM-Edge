/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Group Search
*/
package eSS;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eSS.Common.SsAdapter;
import eSS.Common.SsRepository;


public class GroupSearchBean extends eSS.Common.SsTransaction implements java.io.Serializable {

	// Table Column Variables 
	private String group_code;
	private String group_type_code;
	private String group_desc;
	private boolean result;

	public GroupSearchBean() {
	}

	public void setGroup_code(String group_code) {
		 this.group_code = group_code;
	}

	public String getGroup_code() {
		 return this.group_code;
	}

	public void setGroup_type_code(String group_type_code) {
		 this.group_type_code = group_type_code;
	}

	public String getGroup_type_code() {
		 return this.group_type_code;
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc = group_desc;
	}

	public String getGroup_desc() {
		 return group_desc;
	}

	public void setResult(boolean result) {
		 this.result = result;
	}

	public boolean getResult() {
		 return this.result;
	}

	public void clear(){
		super.clear();
		group_desc="";
		group_code="";
		group_type_code="";
	}

	public void execute(int qry) {
		String sql  =null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		try {
            connection = getConnection();
			switch (qry) {
				case 1:
						sql = (String) eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_SEARCH_SELECT");
					//"SELECT group_code,short_desc group_desc FROM ss_group WHERE eff_status = 'E' AND group_code = ?";
					break;
				case 2:
						sql = (String) eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_TYPE_SEARCH_SELECT");
					//"SELECT group_code,short_desc group_desc FROM ss_group WHERE eff_status = 'E' AND group_code = ? AND group_type = ?";
					break;
				default :
					break;
			}
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, getGroup_code());
			if (qry == 2) {
				pstmt.setString(2, getGroup_type_code());
			}
            resultSet = pstmt.executeQuery();
			result = false;

            if (resultSet != null && resultSet.next()) {
				result = true;
				setGroup_code (resultSet.getString("group_code"));
				setGroup_desc (resultSet.getString("group_desc"));
			}
        }
		catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
	}
}
