<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onKeyDown = 'lockKey();'>
<form name="dynamic_checkout_form" id="dynamic_checkout_form">
<%
	request.setCharacterEncoding("UTF-8");
	String encounter = request.getParameter("encounterid");
	String practitioner = request.getParameter("practitionerid");
	String locncode = request.getParameter("locncode");
	String patient = request.getParameter("patientid");
	String locntype = request.getParameter("locntype");
	String dispdatetime = request.getParameter("dispdatetime");
	
	PreparedStatement stmt 	= null;
	ResultSet rs	= null;	
	ResultSet rs1	= null;

	String fac_id   = (String) session.getValue( "facility_id" ) ;
	StringBuffer sql		= new StringBuffer();
	int maxRecord =0;
	
	Connection conn	= null;	
	try
	{
		conn=ConnectionManager.getConnection(request);
		

		sql.append("Select 'X' from OP_PATIENT_QUEUE where greatest(nvl(CHECK_IN_DATE_TIME,SYSDATE), nvl(ARRIVE_DATE_TIME,SYSDATE), nvl(SUBS_ARRIVE_DATE_TIME,SYSDATE), nvl(VITAL_SIGNS_DATE_TIME,SYSDATE), nvl(CONS_SRVC_START_DATE_TIME,SYSDATE)) >=to_date( ?,'dd/mm/yyyy hh24:mi') ");
		sql.append(" and patient_id = ? and facility_id = ? and trunc(queue_date) = trunc(sysdate) and locn_type =? and locn_code = ? and practitionerd_id = nvl(?,'*ALL') and queue_status = '*ALL' and encounter_id = ?");

		stmt=conn.prepareStatement(sql.toString());
		stmt.setString(1,dispdatetime);
		stmt.setString(2,patient);
		stmt.setString(3,fac_id);
		stmt.setString(4,locntype);
		stmt.setString(5,locncode);
		stmt.setString(6,practitioner);
		stmt.setString(7,encounter);

		rs = stmt.executeQuery();
						
		if(rs.next())
		{
			%>
			<script>
				var error = getMessage("DATE1_LT_DATE2","OP");
				error = error.replace("$",getLabel('eOP.DispDateTime.label','OP'));
				error = error.replace("#",getLabel('Common.SystemDate.label','Common'));
				alert(error);							
				parent.window.close(); 
			</script> 
			<%
		}
		else
		{				
			sql.append("Select count(*) as COUNT from op_patient_queue where encounter_id ="+encounter+" and facility_id = '"+fac_id+"' and queue_date =to_date('"+dispdatetime+"','dd/mm/yyyy hh24:mi') ");

			stmt=conn.prepareStatement(sql.toString());
			rs1=stmt.executeQuery();
			if(rs1 != null && rs1.next())
			{
				maxRecord = rs1.getInt("COUNT");
			}
				
			if(maxRecord != 0)
			{
				%>
				<script>
					alert(getMessage('DISP_DATE_GREATER_TODAY','OP'));
					parent.window.close();
				</script> 
				<%
			}
			if(rs1 != null) rs1.close();				
		}				
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

		sql.setLength(0);
	}
	catch (Exception e) { out.print(e.toString()); out.print("x:--"+sql); }
	finally
	{
		try
		{
			if( rs != null) rs.close();					
			if(rs1 != null) rs1.close();
			if(stmt != null) stmt.close();
			if(conn!=null)
				ConnectionManager.returnConnection(conn,request);		

		}
		catch(Exception e){}				
		
	}
	%> 
	<script>
		parent.frames[1].document.forms[0].submit();
	</script> 
</form>
</body>	
</html>

 

