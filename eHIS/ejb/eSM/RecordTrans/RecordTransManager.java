/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM.RecordTrans;

import java.rmi.* ;
import javax.ejb.* ;
import java.io.*;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RecordTrans"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecordTrans"
*	local-jndi-name="RecordTrans"
*	impl-class-name="eSM.RecordTrans.RecordTransManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSM.RecordTrans.RecordTransLocal"
*	remote-class="eSM.RecordTrans.RecordTransRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSM.RecordTrans.RecordTransLocalHome"
*	remote-class="eSM.RecordTrans.RecordTransHome"
*	generate= "local,remote"
*
*
*/

public class RecordTransManager implements SessionBean {

	Connection		  con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	String locale="";
    SessionContext ctx;
	public final String RECORD_INSERTED = "RECORD_INSERTED" ;
	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx = context;
	}

	/**
	 *Method to Update Record Trans
	 *@param hashaMap Record data 
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertUpdateRecordTrans(
						HashMap argMap	
						) {
		java.util.Properties p=(java.util.Properties)argMap.get("p");
		locale = p.getProperty("LOCALE");
		String tableid=(String)argMap.get("tableid");
		String module_id=(String)argMap.get("module_id");
		String lang_id=(String)argMap.get("lang_id");
		String pk_value=(String)argMap.get("pk_value");
		ArrayList columnid=(ArrayList)argMap.get("columnid");
		ArrayList column_srl_no=(ArrayList)argMap.get("column_srl_no");
		ArrayList columnvalue=(ArrayList)argMap.get("columnvalue");
		String mode=(String)argMap.get("mode");
		String addedFacilityId=(String)argMap.get("addedFacilityId");
		String addedAtWorkstation=(String)argMap.get("addedAtWorkstation");
		
		java.util.HashMap results = new java.util.HashMap() ;
		int		 rs    = 0;
		String	sql    = "";
		String	sql1    = "";
		StringBuffer sb 	= new StringBuffer( "" ) ;
		boolean result = false ;
		try {
			String addedById = p.getProperty( "login_user" ) ;
			con = ConnectionManager.getConnection(p);			
            String columnid_t    = "";
            String columnvalue_t = "";
            int columnsrlno_t    = 0;
			sql = "Insert into sm_record_trans_data(module_id, table_id, column_id, column_srl_no, pk_value, language_id, column_value,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values (?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt = con.prepareStatement(sql);
			sql1 = "update sm_record_trans_data set column_value = ?, modified_by_id = ?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id =? where module_id = ? and table_id = ? and column_id = ? and  column_srl_no = ?  and pk_value = ? and language_id = ?";
			pstmt1 = con.prepareStatement( sql1 );		
			for(int j=0;j<columnvalue.size();j++)
			{
				columnid_t	  = columnid.get(j).toString();
				columnsrlno_t = Integer.parseInt(column_srl_no.get(j).toString());
				columnvalue_t = columnvalue.get(j).toString();
				if(!(columnvalue_t.equals("")))
				{
					InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( columnvalue_t.getBytes()), "windows-1256" ) ;
					columnvalue_t = (new BufferedReader(reader)).readLine() ;
				}
				if (mode.equalsIgnoreCase("I"))
					{
					pstmt.setString(1,module_id);
					pstmt.setString(2,tableid);
					pstmt.setString(3,columnid_t);
					pstmt.setLong(4,columnsrlno_t);
					pstmt.setString(5,pk_value);
					pstmt.setString(6,lang_id);
					pstmt.setString(7,columnvalue_t);
					pstmt.setString(8,addedById);
					pstmt.setString(9,addedAtWorkstation);
					pstmt.setString(10,addedFacilityId);
					pstmt.setString(11,addedById);
					pstmt.setString(12,addedAtWorkstation);
					pstmt.setString(13,addedFacilityId);
					rs = pstmt.executeUpdate();	
				   }
                else
				   {
					pstmt1.setString(1,columnvalue_t);
					pstmt1.setString(2,addedById);
					pstmt1.setString(3,addedAtWorkstation);
					pstmt1.setString(4,addedFacilityId);
					pstmt1.setString(5,module_id);
					pstmt1.setString(6,tableid);
					pstmt1.setString(7,columnid_t);
					pstmt1.setLong(8,columnsrlno_t);
					pstmt1.setString(9,pk_value);
					pstmt1.setString(10,lang_id);		
					rs = pstmt1.executeUpdate() ;			   
			   }
			  }

		pstmt.close();
		pstmt1.close();
		if (mode.equalsIgnoreCase("I"))
		   {
		   if (rs != 0)
			  {
			   result = true ;
			   java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
			   sb.append( (String) message.get("message") ) ;
			   con.commit();
			   pstmt.close() ;
               message.clear();
			}
           }
		else
		   {	
			if (rs != 0)
			  {
			  result = true ;
			   java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED", "SM");
			  sb.append( (String) message.get("message") ) ;
			  con.commit();
			  pstmt.close() ;
			  message.clear();
			}
		   }
		} catch ( Exception e )
		  {
			sb.append( e.getMessage() + "<br>" ) ;
				try{
					con.rollback();
				   }catch (Exception ce){}
		    }

		finally
		{
          try{
		  if  (pstmt != null)  pstmt.close();
		  }catch(Exception ee){} 
		  if (con != null)
		  {
		   try
		   {
		      ConnectionManager.returnConnection(con,p);
	       } catch (Exception ee) {}
	     }
        }
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
	argMap.clear();
	columnid.clear();
	column_srl_no.clear();
	columnvalue.clear();
		return results ;
	}//E.O.InsertOraRole
}//E.O.sess bean

