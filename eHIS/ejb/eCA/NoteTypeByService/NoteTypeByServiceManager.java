/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.NoteTypeByService;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.transaction.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

/**
*
* @ejb.bean
*	name="NoteTypeByService"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="NoteTypeByService"
*	local-jndi-name="NoteTypeByService"
*	impl-class-name="eCA.NoteTypeByService.NoteTypeByServiceManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.NoteTypeByService.NoteTypeByServiceLocal"
*	remote-class="eCA.NoteTypeByService.NoteTypeByServiceRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.NoteTypeByService.NoteTypeByServiceLocalHome"
*	remote-class="eCA.NoteTypeByService.NoteTypeByServiceHome"
*	generate= "local,remote"
*
*
*/


public class NoteTypeByServiceManager implements SessionBean
{
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	SessionContext ctx;

	public void ejbCreate(){
	}

	public void ejbRemove(){
	}

	public void ejbActivate(){
	}

	public void ejbPassivate(){
	}

	public void setSessionContext(SessionContext context){
		this.ctx=context;
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.Hashtable insertNoteType
		(
							java.util.Properties p,
							String note_type,
							String []formats,
							String facilityId,
							String client_ip_address
								 ){

	Connection con = null;
	PreparedStatement pstmtCheck = null ;
	PreparedStatement pstmtInsert = null ;

	java.util.Hashtable message = new java.util.Hashtable() ;
		
		boolean result = false ;
		boolean insertable = false ;
		boolean inserted[];
		StringBuffer sb = new StringBuffer("");

		String addedById = p.getProperty( "login_user" ) ;
		String locale		= (String) p.getProperty("LOCALE");
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		String modifiedDate = addedDate ;
		String modifiedAtWorkstation = client_ip_address ;

		java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
		
		String addedFacilityId=facilityId;
		
		try
		{

			con = ConnectionManager.getConnection(p);

			/* Check if the facility already exists in the database table -- remove it if it exists*/
			String check_sql = "delete from ca_note_type_by_serv  where note_type = ? ";
			pstmtCheck = con.prepareStatement(check_sql);
			
			pstmtCheck.setString(1,note_type);
			int delCount = pstmtCheck.executeUpdate();
			
			if (delCount >= 0){
				insertable = true;
			}
			pstmtCheck.clearParameters();
			if(pstmtCheck !=null) pstmtCheck.close();
			/* Check if the facility already exists in the database table -- remove it if it exists*/


			StringBuffer insert_sql =new StringBuffer();
						insert_sql.append(" Insert into ca_note_type_by_serv ( note_type,");
						insert_sql.append(" service_code,");
						insert_sql.append(" facility_id,");
						insert_sql.append(" added_by_id,");
						insert_sql.append(" added_date,");
						insert_sql.append(" added_at_ws_no,");
						insert_sql.append(" added_facility_id,");
						insert_sql.append(" modified_by_id,");
						insert_sql.append(" modified_date,");
						insert_sql.append(" modified_at_ws_no,");
						insert_sql.append(" modified_facility_id ) ");
						insert_sql.append("  values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmtInsert = con.prepareStatement(insert_sql.toString());
			inserted = new boolean[formats.length];
			if (insertable){

				for(int j = 0;j< formats.length;j++)
				{
					if (formats[j] != null)
					{	
						pstmtInsert.setString(1,note_type);
						pstmtInsert.setString(2,formats[j]);
						pstmtInsert.setString(3,facilityId);
						pstmtInsert.setString(4,addedById);
						pstmtInsert.setDate(5,added_date);
						pstmtInsert.setString(6,client_ip_address);
						pstmtInsert.setString(7,addedFacilityId);
						pstmtInsert.setString(8,modifiedById);
						pstmtInsert.setDate(9,modified_date);
						pstmtInsert.setString(10,modifiedAtWorkstation);
						pstmtInsert.setString(11,addedFacilityId);

						/*
						if(formatCheck[j] == null || formatCheck[j].equals("null") || formatCheck[j] == "" || formatCheck[j].equals("")  )
						formatCheck[j] = "0";
						pstmtInsert.setInt(11,Integer.parseInt(formatCheck[j]));
						*/
						int count = pstmtInsert.executeUpdate();
						//if(pstmtInsert !=null) pstmtInsert.close();
						
						if (count > 0 )
						{
							inserted[j] = true;
						}
						pstmtInsert.clearParameters();
						

					}else{
						inserted[j] = true;
					}
				}
				if(pstmtInsert !=null) pstmtInsert.close();
				boolean insertedAll = true;
				for (int k = 0;k<inserted.length;k++){
					if (inserted[k]){
					}else{
						insertedAll = false;
						break;
					}
				}
				if (insertedAll)
					{
						result = true;

						con.commit();
						//java.util.Hashtable message = MessageManager.getMessage(con,"RECORD_INSERTED");
						sb.append(getMessage(locale, "RECORD_INSERTED","CA"));
					}
					else
					{

						con.rollback();
					}
			}
		}catch(Exception e)
			{
				e.printStackTrace();
				sb.append("<br>"+e);
			}
		finally
	 	{
			 try{
				 if(con != null) ConnectionManager.returnConnection(con,p);
			 }catch(Exception exc){
				 exc.printStackTrace();
			 }
	 	}

		message.put( "status", new Boolean(result) ) ;
		message.put( "error", sb.toString() ) ;
		return message ;
	}
}
