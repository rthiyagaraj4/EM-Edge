/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS.Common ;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import eCommon.Common.CommonAdapter;
import eCommon.Common.CommonRepository;

public abstract class DSAdapter extends CommonAdapter implements Serializable {
	public boolean flag=true;
	private PreparedStatement wrappedStatement;
	private String sqlTemplate;
	private ArrayList parameterValues;
	public DSAdapter() {
		super( CommonRepository.getCommonKeyValue("ID_DS")  ) ;
	}
	// To set the Mode for the Local EJB or Remote EJB
	public void setLocalEJB(boolean flag){
		this.flag=flag;
	}

	// To get the Mode for the Local EJB or Remote EJB
	public boolean getLocalEJB(){
		return flag;
	}
	
	  public void setAll( Hashtable recordSet ) {
	    }
	    
	    public void setFacilityId(String facility_id){
	    	
	    }
	    
	    
		public DSAdapter(Connection connection, String sql) throws SQLException {
			wrappedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sqlTemplate = sql;
			parameterValues = new ArrayList();
		}

		public String getQueryString() {

			StringBuffer buf = new StringBuffer();
			int qMarkCount = 0;
			StringTokenizer tok = new StringTokenizer(sqlTemplate + " ", "?");
			while (tok.hasMoreTokens()) {
				String oneChunk = tok.nextToken();

				buf.append(oneChunk);

				try {
					Object value = null;
					if (parameterValues.size() > 1 + qMarkCount) {
						value = parameterValues.get(1 + qMarkCount++);
					} else {
						if (tok.hasMoreTokens()) {
							value = null;
						} else {
							value = "";
						}
					}
					buf.append("" + value);
				} catch (Exception e) {
					buf.append("ERROR WHEN PRODUCING QUERY STRING FOR LOG."
							+ e.toString());
					// catch this without whining, if this fails the only thing
					// wrong is probably this class
				}
			}
			return buf.toString().trim();
		}

	    
}
