/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
This ejb is used to add the Services for Nursing Unit.
@author - 
@version - V3
*/
package eIP.IPNursUnitService;
import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.rmi.*;
import webbeans.eCommon.*;
/**
*
* @ejb.bean
*	name="IPNursUnitService"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="IPNursUnitService"
*	local-jndi-name="IPNursUnitService"
*	impl-class-name="eIP.IPNursUnitService.IPNursUnitServiceManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eIP.IPNursUnitService.IPNursUnitServiceManagerLocal"
*	remote-class="eIP.IPNursUnitService.IPNursUnitServiceManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eIP.IPNursUnitService.IPNursUnitServiceManagerLocalHome"
*	remote-class="eIP.IPNursUnitService.IPNursUnitServiceManagerHome"
*	generate= "local,remote"
*
*
*/
public class IPNursUnitServiceManager implements SessionBean 
{
	Connection con ;
	PreparedStatement pstmt ;
	SessionContext ctx;
	public void ejbCreate(){}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext( SessionContext context ) {this.ctx=context;}

	/**
	This method is used to add the services for Nursing Unit
	@author - 
	@version - V3
	@param1 - java.util.Properties
	@param2 - java.util.HashMap
	*/
/**
* @ejb.interface-method
*	 view-type="both"
*/

public java.util.HashMap ServiceAddModify(java.util.Properties p,java.util.HashMap tabdata)
{
	String locale = p.getProperty("LOCALE");
	java.util.HashMap results   = new java.util.HashMap() ;
	String added_by_id			= (String)tabdata.get("modified_by_id");
	String client_ip_address    = (String)tabdata.get("modified_at_ws_no");
	Integer integer				= (Integer)tabdata.get("totCount");
	int TotalCount				= integer.intValue();
	StringBuffer sb				= new StringBuffer();
	String nursing_unit_code	= "";
	String dept_code			= "";
	nursing_unit_code			= (String) tabdata.get("nursing_unit_code");
	dept_code					= (String) tabdata.get("dept_code");
	String facility_id			= (String) tabdata.get("facilityId");
	String search_by			= (String) tabdata.get("search_by");
	String search_txt			= (String) tabdata.get("search_txt");
	boolean result=true;
	Statement stmt3 = null;
	ResultSet rstlRs3 = null;



	try
	{
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit(false);
		StringBuffer sql	= null;
		int res=0;

		String search_criteria  = "";
		String n_code			= "";
		String n_code_list		= "";

		if(search_by != null && !search_by.equals("00"))
		{
		if(search_txt != null && !search_txt.equals(""))
		{
		if(search_by.equals("01"))
			search_criteria  = " and UPPER(SERVICE_CODE) like UPPER('"+search_txt+"%') ";
		else if(search_by.equals("02"))
			search_criteria  = " and UPPER(SERVICE_SHORT_DESC) like UPPER('"+search_txt+"%')  ";
		}
		}
		StringBuffer sql2 = new StringBuffer();
		/*sql2.append(" SELECT A.service_code, c.long_desc short_desc , 'Y' ");
		sql2.append(" FROM IP_NURS_UNIT_FOR_SERVICE A, AM_FACILITY_SERVICE B, AM_SERVICE C");
		sql2.append(" WHERE A.facility_id= B.OPERATING_FACILITY_ID ");
		sql2.append(" AND A.dept_code = B.dept_code ");
		sql2.append(" AND A.facility_id='"+facility_id+"' ");			
		sql2.append(" AND B.dept_code = '"+dept_code+"'");
		sql2.append(" AND B.service_code = C.service_code ");
		sql2.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql2.append(" AND A.service_code=b.service_code AND B.eff_status='E'");
		sql2.append(" AND A.service_code not in (select service_code from ip_nursing_unit "); 
		sql2.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql2.append(search_criteria2);
		sql2.append(" UNION ");
		sql2.append(" SELECT A.service_code, b.long_desc short_desc , 'N' ");
		sql2.append(" FROM AM_FACILITY_SERVICE A, AM_SERVICE B");
		sql2.append(" WHERE A.service_code = B.service_code ");
		sql2.append(" AND A.dept_code = '"+dept_code+"'");
		sql2.append(" AND A.operating_facility_id='"+facility_id+"' ");
		sql2.append(" and A.service_code NOT IN ( SELECT service_code ");
		sql2.append(" FROM IP_NURS_UNIT_FOR_SERVICE ");
		sql2.append(" WHERE facility_id='"+facility_id+"' ");
		sql2.append(" AND dept_code = '"+dept_code+"'");
		sql2.append(" AND nursing_unit_code='"+nursing_unit_code+"') ");
		sql2.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql2.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql2.append(" AND A.eff_status='E' ");
		sql2.append(" AND A.eff_status='E' ");
		sql2.append(search_criteria3);
		sql2.append(" ORDER BY 2 ");*/

		if(!dept_code.equals(""))
		sql2.append(" select SERVICE_CODE from IP_NURS_UNIT_FOR_SERVICE_VW where NURSING_UNIT_CODE='"+nursing_unit_code+"' and dept_code = '"+dept_code+"' and FACILITY_ID='"+facility_id+"' ");
		else
		sql2.append(" select SERVICE_CODE from IP_NURS_UNIT_FOR_SERVICE_VW where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facility_id+"' ");

		sql2.append(search_criteria);

		stmt3   = con.createStatement();
		rstlRs3 = stmt3.executeQuery(sql2.toString());

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


		if(!dept_code.equals(""))
		sql=new StringBuffer("delete from IP_NURS_UNIT_FOR_SERVICE where  nursing_unit_code='"+nursing_unit_code+"' and FACILITY_ID ='"+facility_id+"' and DEPT_CODE='"+dept_code+"' ");
		else
		sql=new StringBuffer("delete from IP_NURS_UNIT_FOR_SERVICE where  nursing_unit_code='"+nursing_unit_code+"' and FACILITY_ID ='"+facility_id+"' ");

		sql.append(" and service_code in "); 
		sql.append(n_code_list); 



		pstmt = con.prepareStatement(sql.toString());
		res=pstmt.executeUpdate();


		if(res >0)  result=true;
		else		result = false;

		if(pstmt!=null) pstmt.close();

			for(int i=0;i<TotalCount;i++)
			{
				String service_code = (String)tabdata.get("chk"+i);
				String department_code = (String)tabdata.get("dept"+i);



				StringBuffer  sqli  =  new StringBuffer();
				sqli.append("Insert into IP_NURS_UNIT_FOR_SERVICE (FACILITY_ID,  NURSING_UNIT_CODE, SERVICE_CODE, DEPT_CODE, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values (?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )");


				pstmt=con.prepareStatement(sqli.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,nursing_unit_code);
				pstmt.setString(3, service_code );
				pstmt.setString(4, department_code );
				pstmt.setString(5, added_by_id);
				pstmt.setString(6, client_ip_address) ;
				pstmt.setString(7, facility_id  ) ;
				pstmt.setString(8, added_by_id ) ;
				pstmt.setString(9, client_ip_address) ;
				pstmt.setString(10, facility_id  ) ;

				int res1=pstmt.executeUpdate();

				if(res1>0) 
					result=true;
				else 
					result=false;
				if(pstmt!=null) 
					pstmt.close();
				
			}
	
	
			if(result)
				con.commit();
			else
				con.rollback();

			final java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM") ;
			sb.append( (String) message.get("message") ) ;
			
			message.clear();
			tabdata.clear();

		}catch(Exception ee)
		{
				
		
			sb.append("Error in main try "+ee.toString());
			ee.printStackTrace(System.out);
			try
			{
				con.rollback();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		finally
		{
			if (con != null)
			{
				try
				{
					if(pstmt != null) pstmt.close();
				}
				catch (Exception ee) {   ee.printStackTrace();  }
					if( con != null ) ConnectionManager.returnConnection(con,p);
			}
		}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	return results ;
}
} // end session bean
