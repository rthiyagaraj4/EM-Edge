<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../js/AmendBooking.js'></script>
	<script language ='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 
<%
	request.setCharacterEncoding("UTF-8");
	String url			= "../../eCommon/jsp/commonToolbar.jsp?";
	String params		= request.getQueryString();
	String source		= url + params;
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");

	Connection con		= null;
	Statement stmt		= null;
	Statement stmt1		= null;
	ResultSet rs 		= null; 
	ResultSet rs1 		= null; 
	ResultSet rset 		= null;
	String oper_stn_id  = "";  
	boolean result 		= true;

	String revise_booking_yn	= "";
	String cancel_booking_yn	= "";
	String reject_admission_yn	= "";
	String confirm_booking_yn  = "";
	String create_booking_yn	= "";
	String create_booking_with_conf_yn = "";
	String bkg_grace_period = "";
	StringBuffer sbSql	= new StringBuffer();

	try{
		con = ConnectionManager.getConnection(request);		
		stmt = con.createStatement();		

		rs = stmt.executeQuery("select 1,bkg_grace_period from ip_param where facility_id='"+facilityId+"' ") ;
	   if(rs.next())
		{
			bkg_grace_period = rs.getString("bkg_grace_period");
		//Added By Devang for Operation & clinic Check
		sbSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b  ");
		sbSql.append(" WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id ");
		sbSql.append(" AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  ");
		sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				
		stmt1 = con.createStatement();
		rs1  = stmt1.executeQuery(sbSql.toString());
		if(rs1!=null)
		{
			if(rs1.next())
			{
			   	oper_stn_id = checkForNull(rs1.getString("OPER_STN_ID"));
			}	
			else
			{%>
				 <script>
					alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				</script>
			<%	 result = false;
			}
		}
		if (sbSql.length() > 0)
		sbSql.delete(0, sbSql.length());	

		if (!oper_stn_id.equals("") && result)
	   {
	     try
		 {

			// This query is used for finding whether the nursing units are defined to operator station or not
			/*sbSql.append( "select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facilityId+"' and ");
			sbSql.append( " a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'");*/

			sbSql.append("SELECT distinct(locn_code) FROM am_locn_for_oper_stn WHERE facility_id = '"+facilityId+"' ");
			sbSql.append(" AND locn_type = 'N' AND eff_status = 'E' AND oper_stn_id = '"+oper_stn_id+"' ");

			  rset = stmt.executeQuery(sbSql.toString());
			  if (!rset.next())
			  { %>
				  <script>
				  alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));
				  document.location.href='../../eCommon/jsp/dmenu.jsp';
				  </script>
			  <%    result = false;
			   }
			}
	       catch(Exception e) { result = false; out.println(e.toString());}
	       finally 
			 {
				if (rset != null)   rset.close();
			 }
      } 

		if (sbSql.length() > 0)
		sbSql.delete(0, sbSql.length());	

		// This query is used for finding the access rights for user
		sbSql.append( "select revise_booking_yn ,canc_booking_yn ,reject_admission_yn,CONFIRM_BOOKING_YN,create_booking_yn,CREATE_BOOKING_WITH_CONF_YN from am_oper_stn ");
		sbSql.append(" where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  ");
		sbSql.append(" where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and  nvl(eff_date_to,trunc(sysdate))) ");
		
		rs = stmt.executeQuery(sbSql.toString());		
		if(rs!= null)
		{
			if(rs.next())			
			{
				revise_booking_yn   = checkForNull(rs.getString(1));
				cancel_booking_yn   = checkForNull(rs.getString(2));
				reject_admission_yn = checkForNull(rs.getString(3));
				confirm_booking_yn  = checkForNull(rs.getString(4));
				create_booking_yn	= checkForNull(rs.getString(5));
				create_booking_with_conf_yn = checkForNull(rs.getString(6));
			}
		}
		
if((revise_booking_yn.equals("Y")) || (cancel_booking_yn.equals("Y")) ||(reject_admission_yn.equals("Y")))
{	
%>
<iframe name = 'commontoolbarFrame'	src = <%=source%> frameborder=0 scrolling = 'no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../jsp/BookingReferenceLookup.jsp?oper_stn_id=<%=oper_stn_id%>&revise_booking_yn=<%=revise_booking_yn%>&cancel_booking_yn=<%=cancel_booking_yn%>&confirm_booking_yn=<%=confirm_booking_yn%>&create_booking_yn=<%=create_booking_yn%>&create_booking_with_conf_yn=<%=create_booking_with_conf_yn%>&call_function=BookingReport&bkg_grace_period=<%=bkg_grace_period%>"  frameborder=0 scrolling='auto' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
<%}
else
{%>
	<script>
	alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))
	document.location.href ='../../eCommon/jsp/dmenu.jsp'
	</script>
<%}

}else %>
            <script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
			document.location.href= '../../eCommon/jsp/dmenu.jsp'
			</script>

<%
	if(rset != null)	rset.close();
	if(rs != null)		rs.close();
	if(rs1 != null)		rs1.close();
	if(stmt != null)	stmt.close();
	if(stmt1 != null)	stmt1.close();

}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>	
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

