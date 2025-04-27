/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to add the Specialities for Nursing Unit.
@author - 
@version - V3
*/
package eIP.IPNursUnitSpeciality;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPNursUnitSpeciality"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPNursUnitSpeciality"
*	local-jndi-name="IPNursUnitSpeciality"
*	impl-class-name="eIP.IPNursUnitSpeciality.IPNursUnitSpecialityManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPNursUnitSpeciality.IPNursUnitSpecialityManagerLocal"
*	remote-class="eIP.IPNursUnitSpeciality.IPNursUnitSpecialityManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPNursUnitSpeciality.IPNursUnitSpecialityManagerLocalHome"
*	remote-class="eIP.IPNursUnitSpeciality.IPNursUnitSpecialityManagerHome"
*	generate= "local,remote"
*
*
*/
public class IPNursUnitSpecialityManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
    Statement stmt3 = null;
    ResultSet rstlRs3 = null;
	SessionContext ctx;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}
	/**
	This method is used to add or modify the specialities for the nursing unit
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap SpecialityAddModify(java.util.Properties p,java.util.HashMap tabdata)
	{
		String locale = p.getProperty("LOCALE");
		java.util.HashMap	results				= new java.util.HashMap() ;
        String				added_by_id			= (String)tabdata.get("modified_by_id");
        String				client_ip_address	= (String)tabdata.get("modified_at_ws_no");
		String				nursing_unit_code	= (String)tabdata.get("nursing_unit_code");
		String				facility_id			= (String)tabdata.get("facilityId");
        StringBuffer		messageBuffer		= new StringBuffer();
        StringBuffer		sqlQuery			= new StringBuffer();
		Integer				totCount			= (Integer)tabdata.get("totCount");
        int					totalCount			= totCount.intValue();
		int					n_records			= 0;
		boolean				result				= true;
		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			/*Stmt=con.createStatement();
			String sql = "select count(*) from IP_NURS_UNIT_FOR_SPECIALTY where nursing_unit_code='"+nursing_unit_code+"' and FACILITY_ID = '"+facility_id+"'");
			rs = Stmt.executeQuery(sql);
			if(rs!=null )
			{
				int rec_count = rset.getInt(1);
			}
			if (rec_count == 0)
			{
				result=false;
				avoid_delete = true
			}*/

	String search_by			= (String) tabdata.get("search_by");
	String search_txt			= (String) tabdata.get("search_txt");
	String search_criteria		= "";
	String n_code				= "";
	String n_code_list			= "";

	if(search_by != null && !search_by.equals("00"))
	{
		if(search_txt != null && !search_txt.equals(""))
		{
			if(search_by.equals("01"))
				search_criteria  = " and UPPER(SPECIALTY_CODE) like UPPER('"+search_txt+"%') ";
			else if(search_by.equals("02"))
				search_criteria  = " and UPPER(SPECIALTY_SHORT_DESC) like UPPER('"+search_txt+"%') ";
		}
	}


		StringBuffer sql = new StringBuffer();
/*
		sql.append(" SELECT A.specialty_code, B.long_desc short_desc, 'Y' ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY A, AM_SPECIALITY B ");
		sql.append(" WHERE A.facility_id = '"+facility_id+"' ");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND A.specialty_code = b.speciality_code AND B.eff_status='E' ");
		sql.append(search_criteria);
		sql.append(" UNION ");
		sql.append("SELECT speciality_code, long_desc short_desc, 'N' ");
		sql.append(" FROM AM_SPECIALITY ");
		sql.append(" WHERE speciality_code NOT IN ( SELECT specialty_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY ");
		sql.append(" WHERE facility_id='"+facility_id+"' ");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ) ");
		sql.append(" AND eff_status='E' ");
		sql.append(search_criteria);
		sql.append("  ORDER BY 2 "); 
*/

		sql.append(" SELECT specialty_code FROM IP_NURS_UNIT_FOR_SPECIALTY_VW WHERE Facility_id = '"+facility_id+"' AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(search_criteria);
		sql.append("  ORDER BY 1 ");




		stmt3   = con.createStatement();
		rstlRs3 = stmt3.executeQuery(sql.toString()); 

		boolean first_time = true;

		while(rstlRs3.next())
		{
			n_code = rstlRs3.getString(1);

			if(first_time)
			   n_code_list = "('"+n_code+"'" ;
			else
				n_code_list = n_code_list + ",'" +n_code +"'";

			first_time = false;
		}

		if(!first_time)
			n_code_list = n_code_list + ")";

		if(n_code_list.equals(""))
			n_code_list = "('')";

		if(stmt3!=null)   stmt3.close();
		if(rstlRs3!=null) rstlRs3.close();

		sqlQuery.append("delete from IP_NURS_UNIT_FOR_SPECIALTY where ");
		sqlQuery.append("nursing_unit_code = ? and FACILITY_ID = ? ");
		sqlQuery.append(" and specialty_code in "); 
		sqlQuery.append(n_code_list); 


		try
		{	
			pstmt=con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1,nursing_unit_code);
			pstmt.setString(2,facility_id);
			n_records=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			messageBuffer.append("Error while deleting from ip_nurs_unit_for_specialty "+e.getMessage());
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
			clearValues(sqlQuery);
		}

		if(result)
		{	
			String specialty_code = "";

			for(int i=0;i<totalCount;i++)
			{
				specialty_code = (String)tabdata.get("chk"+i);
				sqlQuery.append(" Insert into ip_nurs_unit_for_specialty");
				sqlQuery.append(" (FACILITY_ID, ");
				sqlQuery.append(" NURSING_UNIT_CODE, ");
				sqlQuery.append(" SPECIALTY_CODE, ");
				sqlQuery.append(" ADDED_BY_ID, ");
				sqlQuery.append(" ADDED_DATE, ");
				sqlQuery.append(" ADDED_AT_WS_NO, ");
				sqlQuery.append(" ADDED_FACILITY_ID, ");
				sqlQuery.append(" MODIFIED_BY_ID, ");
				sqlQuery.append(" MODIFIED_DATE, ");
				sqlQuery.append(" MODIFIED_AT_WS_NO, ");
				sqlQuery.append(" MODIFIED_FACILITY_ID ) ");
				sqlQuery.append(" values ( ");
				sqlQuery.append(" ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? ) ");

				try
				{
					pstmt=con.prepareStatement(sqlQuery.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,nursing_unit_code);
					pstmt.setString(3,specialty_code );
					pstmt.setString (4, added_by_id);
					pstmt.setString(5, client_ip_address) ;
					pstmt.setString(6, facility_id  ) ;
					pstmt.setString(7, added_by_id ) ;
					pstmt.setString(8, client_ip_address) ;
					pstmt.setString(9, facility_id  ) ;

					n_records =pstmt.executeUpdate();

					if(n_records>0) result=true;
					else result=false;
				}
				catch(Exception e)
				{
					messageBuffer.append("Error while Inserting into ip_nurs_unit_for_specialty "+e.getMessage());
				}
				finally
				{
				  if(pstmt!=null) pstmt.close();
				  clearValues(sqlQuery);
				}
			}
		}
		if(result)
			{
			  con.commit();
			  final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			  messageBuffer.append( (String) message.get("message") ) ;
			  message.clear();
			}
		else
			  con.rollback();

		tabdata.clear();
	}
	catch(Exception ee)
	{
		messageBuffer.append("Error in main try "+ee.getMessage());
		ee.printStackTrace(System.err);
	}
	finally
	{
		if (con != null)
        {
			try
			{
				if(pstmt != null) pstmt.close();
            }
			catch (Exception ee) { ee.printStackTrace();}
			if( con != null ) ConnectionManager.returnConnection(con,p);
        }
	}

	results.put( "status", new Boolean(result) ) ;
	results.put( "error", messageBuffer.toString() ) ;
	return results ;
	}

	/**
	This method is used to clear the stringbuffer data
	@version - V3
	@param1 - StringBuffer
	@return - StringBuffer
	*/

	public StringBuffer clearValues(StringBuffer sbSql)
	{
		if(sbSql.length() > 0) 
			sbSql.delete(0,sbSql.length());
		return sbSql;
	}
} // end session bean
