/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.RecPatChiefComplaint;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="RecPatChiefComplaint"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RecPatChiefComplaint"
*	local-jndi-name="RecPatChiefComplaint"
*	impl-class-name="eCA.RecPatChiefComplaint.RecPatChiefComplaintManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.RecPatChiefComplaint.RecPatChiefComplaintLocal"
*	remote-class="eCA.RecPatChiefComplaint.RecPatChiefComplaintRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.RecPatChiefComplaint.RecPatChiefComplaintLocalHome"
*	remote-class="eCA.RecPatChiefComplaint.RecPatChiefComplaintHome"
*	generate= "local,remote"
*
*
*/

public class RecPatChiefComplaintManager implements SessionBean
{
	java.text.SimpleDateFormat dateFormat		= new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm" ) ;

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext(SessionContext context) {this.ctx=context;}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertChiefComplaint
	(
			java.util.Properties p,
			String x_facility_id,
			Long x_encounter_id,
			String x_complaint_id,            
			String x_onset_date,
			String x_remarks,
			String client_ip_address,
			String locale,
			String x_complaint_details
	)
{
	Connection con					= null;
	PreparedStatement ins_pstmt		= null;

	StringBuffer sb = new StringBuffer( "" ) ;
	
	java.util.HashMap results = new java.util.HashMap() ;

	boolean insertable		=	true;
	
	long encounter_id		=	0;
	
	int res = 0;
	
	encounter_id			= x_encounter_id.longValue();

	String addedById				= (String) p.getProperty( "login_user" ) ;
	String modifiedById				= addedById ;
	String modifiedAtWorkstation	= client_ip_address ;
	String addedAtWorkstation		= modifiedAtWorkstation;

	java.util.Hashtable message = new Hashtable();
	try
	{
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit(false);

		PreparedStatement duplicate_stmt = null;
		ResultSet duplicate_rs = null;

		try
		{
			StringBuffer duplicate_sql = new StringBuffer();
			duplicate_sql.append("select 1 from ca_encntr_chief_complaint 	where complaint_id = ? and facility_id = ? and encounter_id = ? ");
			
			duplicate_stmt = con.prepareStatement(duplicate_sql.toString());
			
			duplicate_stmt.setString(1,x_complaint_id);
			duplicate_stmt.setString(2,x_facility_id);
			duplicate_stmt.setLong(3,encounter_id);
			
			duplicate_rs = duplicate_stmt.executeQuery();
			
			
			while(duplicate_rs.next())
			{
				insertable = false;
				message = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common" ) ;
				sb.append( (String) message.get("message")) ;
				message.clear();
			}

			if(duplicate_stmt!=null)
				duplicate_stmt.close();

			if(duplicate_rs!=null)
				duplicate_rs.close();
				
		}
		catch(Exception ex)
		{
			sb.append("Exception @ duplicatechck "+ex.toString());
			ex.printStackTrace();
		}
			
		if(insertable)
		{
			String insert_sql = " insert into ca_encntr_chief_complaint(FACILITY_ID,ENCOUNTER_ID,COMPLAINT_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ONSET_DATETIME,REMARKS,COMPLAINT_DESC) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?)";

			ins_pstmt = con.prepareStatement(insert_sql);
			ins_pstmt.setString(1,x_facility_id);
			ins_pstmt.setLong(2,encounter_id);
			ins_pstmt.setString(3,x_complaint_id);
			ins_pstmt.setString(4,addedById);
			ins_pstmt.setString(5,addedAtWorkstation);
			ins_pstmt.setString(6,x_facility_id);
			ins_pstmt.setString(7,modifiedById);
			ins_pstmt.setString(8,modifiedAtWorkstation);
			ins_pstmt.setString(9,x_facility_id);
			ins_pstmt.setString(10,x_onset_date);
			ins_pstmt.setString(11,x_remarks);
			ins_pstmt.setString(12,x_complaint_details);

			res = ins_pstmt.executeUpdate();

			if(ins_pstmt!=null)
				ins_pstmt.close();
		}
		if(res > 0)
		{
			con.commit();
			message = MessageManager.getMessage( locale, "RECORD_INSERTED","CA" ) ;
			sb.append( (String) message.get("message") ) ;
			message.clear();
		}
		else
		{
			insertable = false;
			con.rollback();
		}
	}
	catch(Exception e)
	{
		insertable = false ;
		sb.append( "Exception @ catch"+e.toString()+ "<br>" ) ;
		e.printStackTrace() ;
	
		try
		{
			if (con != null)
				con.rollback();
		}
		catch (Exception eeee)
		{}
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con, p);
	}
		
	results.put( "status", new Boolean(insertable) ) ;
	results.put("error",sb.toString());
	return results;
}
		
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap modifyChiefComplaint
	(
		java.util.Properties p,
		String x_facility_id,
		Long x_encounter_id,
		String x_complaint_id,
		String x_onset_date,
		String x_remarks,
		String client_ip_address,
		String locale,
		String err_remarks,
	    String x_complaint_details,
        String x_error_yn
	)	
{
	Connection con = null;
	PreparedStatement select_pstmt	= null;
	PreparedStatement insert_pstmt	= null;
	PreparedStatement delete_pstmt	= null;
	PreparedStatement update_pstmt	= null;

	ResultSet rs =null ;

	java.util.HashMap results = new java.util.HashMap() ;

	long encounter_id		=	0;
	encounter_id			=	x_encounter_id.longValue();

	StringBuffer sb = new StringBuffer( "" ) ;

	String addedById				= (String) p.getProperty( "login_user" ) ;
	//String modifiedById				= addedById ;
	//String modifiedAtWorkstation	= client_ip_address ;

	boolean insertable=true;
	boolean result = false;
	int res = 0;
	int ins = 0;
	int upd = 0;
    //String sql="";


	String ADDED_BY_ID ="", ADDED_DATE = "", ADDED_AT_WS_NO="";
	String ADDED_FACILITY_ID ="", MODIFIED_BY_ID ="", MODIFIED_DATE ="";
	String MODIFIED_AT_WS_NO ="",MODIFIED_FACILITY_ID ="";
	try
	{
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit(false);
		
		String select_sql="SELECT ADDED_BY_ID,to_char(ADDED_DATE,'dd/mm/yyyy') ADDED_DATE ,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID ,to_char(MODIFIED_DATE,'dd/mm/yyyy') MODIFIED_DATE ,MODIFIED_AT_WS_NO ,MODIFIED_FACILITY_ID FROM CA_ENCNTR_CHIEF_COMPLAINT  WHERE FACILITY_ID = ? and ENCOUNTER_ID = ? and COMPLAINT_ID = ?";
		
		String insert_sql ="INSERT INTO CA_ENCNTR_CC_ERRLOG (FACILITY_ID,ENCOUNTER_ID,COMPLAINT_ID,ERROR_DATE,ERROR_MARKED_BY_USER,ERROR_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ONSET_DATETIME,REMARKS) VALUES (?,?,?,SYSDATE ,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?)";	

		String update_sql = "update ca_encntr_chief_complaint set REMARKS = ?,MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID = ?,MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?,COMPLAINT_DESC = ?  where FACILITY_ID = ? and ENCOUNTER_ID = ? and COMPLAINT_ID = ? ";
		
		//String update_sql = "update ca_encntr_chief_complaint set REMARKS = ?,MODIFIED_BY_ID = ?,MODIFIED_FACILITY_ID = ?,MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ? where FACILITY_ID = ? and ENCOUNTER_ID = ? and COMPLAINT_ID = ? ";
		String delete_sql ="DELETE FROM  CA_ENCNTR_CHIEF_COMPLAINT WHERE FACILITY_ID=? AND ENCOUNTER_ID = ? AND COMPLAINT_ID = ? ";		
		select_pstmt = con.prepareStatement(select_sql);
		select_pstmt.setString(1,x_facility_id);
		select_pstmt.setLong(2,encounter_id);
		select_pstmt.setString(3,x_complaint_id);
		rs = select_pstmt.executeQuery();
		
		while(rs.next())
		{
		  ADDED_BY_ID = rs.getString("ADDED_BY_ID");	
		  ADDED_DATE = rs.getString("ADDED_DATE");	
		  ADDED_AT_WS_NO = rs.getString("ADDED_AT_WS_NO");	
		  ADDED_FACILITY_ID = rs.getString("ADDED_FACILITY_ID");	
		  MODIFIED_BY_ID = rs.getString("MODIFIED_BY_ID");	
		  MODIFIED_DATE = rs.getString("MODIFIED_DATE");	
		  MODIFIED_AT_WS_NO = rs.getString("MODIFIED_AT_WS_NO");	
		  MODIFIED_FACILITY_ID = rs.getString("MODIFIED_FACILITY_ID");
		}
		
		if(select_pstmt!=null)
			select_pstmt.close();
		if(rs!=null)
			rs.close();
 
		if(x_error_yn.equals("Y"))
	    {
			insert_pstmt= con.prepareStatement(insert_sql);
			insert_pstmt.setString(1,x_facility_id);
			insert_pstmt.setLong(2,encounter_id);
			insert_pstmt.setString(3,x_complaint_id);
			insert_pstmt.setString(4,addedById);
			insert_pstmt.setString(5,err_remarks);
			insert_pstmt.setString(6,ADDED_BY_ID);
			insert_pstmt.setString(7,ADDED_DATE);
			insert_pstmt.setString(8,ADDED_AT_WS_NO);
			insert_pstmt.setString(9,ADDED_FACILITY_ID);
			insert_pstmt.setString(10,MODIFIED_BY_ID);
			insert_pstmt.setString(11,MODIFIED_DATE);
			insert_pstmt.setString(12,MODIFIED_AT_WS_NO);
			insert_pstmt.setString(13,MODIFIED_FACILITY_ID);
			insert_pstmt.setString(14,x_onset_date);
			insert_pstmt.setString(15,x_remarks);

			ins =insert_pstmt.executeUpdate();
			if(insert_pstmt !=null)
				insert_pstmt.close();

			if(ins> 0)
			{
				delete_pstmt = con.prepareStatement(delete_sql);	
				delete_pstmt.setString(1,x_facility_id);
				delete_pstmt.setLong(2,encounter_id);
				delete_pstmt.setString(3,x_complaint_id);
				res = delete_pstmt.executeUpdate();
				
				if(delete_pstmt!=null)
					delete_pstmt.close();
			
				if(res > 0)
				{				
					con.commit();
					result = true ;
						
					final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				else
				{
					if (con != null)
					{
						try
						{
							con.rollback() ;
						}
						catch (Exception ce) 
						{
							ce.printStackTrace();
						}
					}

				}		
			}
	    }
		else
		{
			update_pstmt = con.prepareStatement(update_sql);
			update_pstmt.setString(1, x_remarks);
			update_pstmt.setString(2, MODIFIED_BY_ID);
			update_pstmt.setString(3, MODIFIED_FACILITY_ID);
			update_pstmt.setString(4, MODIFIED_AT_WS_NO);
			update_pstmt.setString(5, x_complaint_details);
			update_pstmt.setString(6, x_facility_id);
			update_pstmt.setLong(7, encounter_id);
			update_pstmt.setString(8, x_complaint_id);

			upd =update_pstmt.executeUpdate();
			if(update_pstmt !=null)
				update_pstmt.close();
			
            if(upd >= 0)
			{				
				con.commit();
				result = true ;
					
				final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","CA" ) ;
				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
			else
			{
				if (con != null)
				{
					try
					{
						con.rollback() ;
					}
					catch (Exception ce) 
					{
						ce.printStackTrace();
					}
				}

			}
		}	
	}//end of try
		catch(Exception e)
		{
			insertable = false ;
			sb.append( "Exception @ catch update"+e.toString()+ "<br>" ) ;
			e.printStackTrace() ;
			
			if (con != null)
			{
				try
				{
					con.rollback() ;
				}
				catch (Exception ce) 
				{
					ce.printStackTrace();
				}
		    }
		}
		finally
		{
			try
			{
					if(delete_pstmt != null)
						delete_pstmt.close();
			}
			catch(Exception ex)
			{
				sb.append("Exception @ final try"+ex.toString());
				ex.printStackTrace();
			}
			finally
			{
					if(con!=null) ConnectionManager.returnConnection(con, p);
			}

		}
		
		results.put( "status", new Boolean(result) ) ;
		results.put("error",sb.toString());
		return results;
	}
		
}
