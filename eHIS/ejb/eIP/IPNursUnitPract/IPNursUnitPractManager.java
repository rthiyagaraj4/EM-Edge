/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to add the Practitioner based on Nursing Unit or Services.
@author - 
@version - V3
*/
package eIP.IPNursUnitPract;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPNursUnitPract"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPNursUnitPract"
*	local-jndi-name="IPNursUnitPract"
*	impl-class-name="eIP.IPNursUnitPract.IPNursUnitPractManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPNursUnitPract.IPNursUnitPractLocal"
*	remote-class="eIP.IPNursUnitPract.IPNursUnitPractRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPNursUnitPract.IPNursUnitPractLocalHome"
*	remote-class="eIP.IPNursUnitPract.IPNursUnitPractHome"
*	generate= "local,remote"
*
*
*/
public class IPNursUnitPractManager implements SessionBean
{
	Connection con ;
	PreparedStatement pstmt_ins			  =	null;
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;
	PreparedStatement pstmt_del			  =	null;
	SessionContext ctx;

	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context)
	{
		this.ctx=context;
	}

	/**
	This method is used to add or delete the practioners for Nursing Unit/Services
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	@return - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

	public java.util.HashMap InsDelIPNursUnitPract(java.util.Properties p,java.util.HashMap tabdata)
	{
		String locale = p.getProperty("LOCALE");
		StringBuffer sb					= new StringBuffer( "" ) ;
		java.util.HashMap results		= new java.util.HashMap() ;
		boolean result					= false ;
		String facilityId				= (String)tabdata.get("facilityId");
        String added_by_id				= (String)tabdata.get("modified_by_id");
        String modifiedFacilityId		= (String)tabdata.get("modified_facility_id");
        String client_ip_address		= (String)tabdata.get("modified_at_ws_no");
        Integer totCount				= (Integer)tabdata.get("totCount");
		String delete_id				= (String)tabdata.get("delete_id");
		//String insert_id				= (String)tabdata.get("insert_id");     
        int totalCount					= totCount.intValue();
		StringBuffer operation_ins_sql	= new StringBuffer( "" ) ;
		StringBuffer operation_del_sql	= new StringBuffer( "" ) ;
		//StringBuffer sql				= new StringBuffer( "" ) ;
		int operation_ins_count=0, operation_del_count=0;

		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			String Function				= "";
			Function					= (String) tabdata.get("Function");
			String function_code		= "";
			function_code				= (String) tabdata.get("function_code");

			String search_by    = "";
		    String search_txt   = "" ;
			String search_criteria = "";
			//String n_code = "";
			String n_code_list = "";
			search_by = (String) tabdata.get("search_by");
			search_txt = (String) tabdata.get("search_txt");

			if(search_by != null && !search_by.equals(""))
			{
				if(search_txt != null && !search_txt.equals(""))
				{
					if(Function.equals("pract"))
					{
						if(search_by.equals("01"))
							search_criteria = " and UPPER(NURSING_UNIT_CODE) like upper('"+search_txt+"%') ";
						else if(search_by.equals("02"))
							search_criteria = " and UPPER(NURSING_UNIT_SHORT_DESC) like UPPER('"+search_txt+"%') ";
					}
					else if(Function.equals("nurs"))
					{
						if(search_by.equals("01"))
							search_criteria = " and UPPER(PRACTITIONER_ID) like UPPER('"+search_txt+"%') ";
						else if(search_by.equals("02"))
							search_criteria = " and UPPER(PRACTITIONER_NAME) like UPPER('"+search_txt+"%') ";
					}
				}
			}

			/*if(Function.equals("nurs"))
			{
				//sql.append("select a.practitioner_id \"code\", a.practitioner_name \"desc\",a.pract_type practype, 'Y',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facilityId+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facilityId+"' and nursing_unit_code='"+function_code+"' )and a.pract_type = b.pract_type "+search_criteria+" UNION select practitioner_id \"code\", practitioner_name \"desc\",a.pract_type,'N',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facilityId+"' and a.eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facilityId+"' and nursing_unit_code='"+function_code+"') and a.pract_type = b.pract_type "+search_criteria+" order by 2"); 
				
				sql.append(" select practitioner_id from IP_NURSING_UNIT_FOR_PRACT_VW WHERE facility_id = '"+facilityId+"' AND nursing_unit_code = '"+function_code+"' "+search_criteria+" order by 1 ");
			}
			else if(Function.equals("pract"))
			{
				//sql.append("select nursing_unit_code \"code\", short_desc \"desc\", 'N' from ip_nursing_unit where facility_id='"+facilityId+"' AND eff_status='E' and locn_type = 'N' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facilityId+"') "+search_criteria2+" union select a.nursing_unit_code, short_desc,'Y' from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facilityId+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code "+search_criteria3+" order by 2");

				sql.append(" select nursing_unit_code from IP_NURSING_UNIT_FOR_PRACT_VW WHERE facility_id = '"+facilityId+"' AND practitioner_id = '"+function_code+"' "+search_criteria+" order by 1 ");
			}

			stmt3   = con.createStatement();
			rstlRs3 = stmt3.executeQuery(sql.toString());
			boolean first_time = true;
			while(rstlRs3.next())
			{
				if(Function.equals("nurs"))
					n_code = rstlRs3.getString("practitioner_id");
				else if(Function.equals("pract"))
					n_code = rstlRs3.getString("nursing_unit_code");

				if(first_time)
				   n_code_list = "('"+n_code+"'" ;
				else
					n_code_list = n_code_list + ",'" +n_code +"'";

				first_time = false;
			}


			if(stmt3!=null)   stmt3.close();
			if(rstlRs3!=null) rstlRs3.close();*/



			//if(!first_time)
			//	n_code_list = n_code_list + ")";
			
			

			if(delete_id.equals(""))
				n_code_list = "('')";
			else
				n_code_list = "("+delete_id+")" ;


			if(Function.equals("nurs"))
			{
				operation_del_sql.append("Delete from IP_NURSING_UNIT_FOR_PRACT where FACILITY_ID=? and  NURSING_UNIT_CODE =? ");
				operation_del_sql.append(" and PRACTITIONER_ID in "); 
				operation_del_sql.append(n_code_list); 

				operation_ins_sql.append("Insert into IP_NURSING_UNIT_FOR_PRACT( FACILITY_ID, NURSING_UNIT_CODE, PRACTITIONER_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
			}
			else if(Function.equals("pract"))
			{
				operation_del_sql.append("Delete from IP_NURSING_UNIT_FOR_PRACT where FACILITY_ID=? and PRACTITIONER_ID  =? ");
				operation_del_sql.append(" and NURSING_UNIT_CODE in "); 
				operation_del_sql.append(n_code_list); 

				operation_ins_sql.append("Insert into IP_NURSING_UNIT_FOR_PRACT( FACILITY_ID, PRACTITIONER_ID, NURSING_UNIT_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
			}

			pstmt_ins					=	con.prepareStatement(operation_ins_sql.toString());
			pstmt_del					=	con.prepareStatement(operation_del_sql.toString());

			pstmt_del.setString	(1,facilityId );
			pstmt_del.setString	(2,function_code );

			operation_del_count			= pstmt_del.executeUpdate() ;
			for(int k=0; k<totalCount; k++)
			{
				String select_yn		=	(String)tabdata.get("select_yn"+k);
				pstmt_ins.setString	(1,	facilityId );
				pstmt_ins.setString	(2,	function_code );
				pstmt_ins.setString	(3, select_yn );
				pstmt_ins.setString	(4, added_by_id );
				pstmt_ins.setString	(5, client_ip_address );
				pstmt_ins.setString	(6, modifiedFacilityId );
				pstmt_ins.setString	(7, added_by_id );
				pstmt_ins.setString	(8, client_ip_address );
				pstmt_ins.setString	(9, modifiedFacilityId );
				operation_ins_count	= pstmt_ins.executeUpdate() ;
			}
			tabdata.clear();
			if((operation_ins_count > 0 && totalCount>0) || (operation_del_count > 0))
			{
				result = true ;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM" ) ;
				sb.append( (String) message.get("message"));
				message.clear();
			}
			else if(totalCount==0)
			{
				result = true ;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM" ) ;
				sb.append( (String) message.get("message"));
				message.clear();
			}
			else
			{
				result = false ;
				con.rollback();
			}
		}
		catch(Exception e)
		{
			sb.append(e.getMessage());
			e.printStackTrace();
			result = false ;
			if ( con != null )
			{
				try
				{
					con.rollback();
				}
				catch( Exception ce ) {}
			}
		}
		finally
		{
			try
			{
				if(pstmt_ins !=	null) pstmt_ins.close();
				if(pstmt_del !=	null) pstmt_del.close();
			}
			catch(Exception e) {}
				if(con!=null) ConnectionManager.returnConnection(con, p);
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}
}
