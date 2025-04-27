<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;

	String facility_id			= ( String ) session.getValue( "facility_id" );
	String whereCond			= checkForNull(request.getParameter("whereCond"));
	String nursing_unit_code	= request.getParameter( "nursing_unit_code" );
	String bed_classification	= request.getParameter("bed_classification");
	if (bed_classification==null) 
		bed_classification="B";

	StringBuffer sql = new StringBuffer();

	String total		= "&nbsp;" ;
	String occupied		= "&nbsp;" ;
	String vacant		= "&nbsp;" ;
	String overridable	= "&nbsp;" ;
	String nonoverridable="&nbsp;" ;
	String bbed			= "&nbsp;";
	String p_pseudo_bed_yn =	"";

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt= con.createStatement();

		if(nursing_unit_code!=null)
		{
			// Added by Nanda 02/10/2002 
			if((whereCond.equalsIgnoreCase("CREATE_BOOKING_YN") || whereCond.equalsIgnoreCase("REVISE_BOOKING_YN")))
			{
				p_pseudo_bed_yn="N";
			}
			else
			{
				if (bed_classification.equals("N"))
					p_pseudo_bed_yn="N";
				else if (bed_classification.equals("P"))
					p_pseudo_bed_yn="Y";
				else if (bed_classification.equals("B"))
					p_pseudo_bed_yn="X";
			}

			sql.append(" SELECT d.num_of_beds total, d.num_of_beds_occupied occupied, blocked_count,");
			sql.append(" non_overrideable_count FROM IP_NURSING_UNIT a, ( SELECT COUNT(DISTINCT req_bed_no) non_overrideable_count ");
			sql.append(" FROM IP_BED_BOOKING ");
			sql.append(" WHERE booking_status='0' AND override_yn='N' AND ");
			sql.append(" SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time AND ");
			sql.append(" facility_id='"+facility_id+"' AND req_nursing_unit_code='"+nursing_unit_code+"') b, (SELECT COUNT(DISTINCT req_bed_no) blocked_count ");
			sql.append(" FROM IP_BED_BOOKING ");
			sql.append(" WHERE booking_status='0'  AND facility_id='"+facility_id+"' AND ");
			sql.append(" REQ_nursing_unit_code='"+nursing_unit_code+"' AND ");
			sql.append(" SYSDATE BETWEEN blocked_from_date_time AND ");
			sql.append(" blocked_until_date_time) c, (SELECT COUNT(g.bed_no) num_of_beds,SUM(DECODE(LTRIM(RTRIM(g.patient_id)),NULL,0,1)) num_of_beds_occupied ");
			sql.append(" FROM IP_NURSING_UNIT_BED_LOOKUP_VW g ");
			sql.append(" WHERE g.facility_id ='"+facility_id+"' AND g.nursing_unit_code='"+nursing_unit_code+"' AND ");			sql.append("g.pseudo_bed_yn=DECODE('"+p_pseudo_bed_yn+"','X',g.pseudo_bed_yn,'"+p_pseudo_bed_yn+"') ");
			sql.append(" AND g.EFF_STATUS='E' ) d ");
			sql.append(" WHERE A.facility_id='"+facility_id+"' ");
			sql.append(" AND A.nursing_unit_code='"+nursing_unit_code+"' ");

			rs = stmt.executeQuery( sql.toString());
			if(rs!=null)
			{
				if( rs.next() )
				{
					total			= String.valueOf(rs.getInt("total")); 
					occupied		= String.valueOf(rs.getInt("occupied")); 
					vacant			= String.valueOf(rs.getInt("total") - rs.getInt("occupied") - rs.getInt("blocked_count")); 
					bbed			= String.valueOf(rs.getInt("blocked_count")); 
					overridable		= String.valueOf(rs.getInt("blocked_count") - rs.getInt("non_overrideable_count")); 
					nonoverridable	= String.valueOf(rs.getInt("non_overrideable_count"));  
				}
			}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		}
		%>	

		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td class='label'>	<fmt:message key="eIP.BedDetails.label" bundle="${ip_labels}"/> :</td>
				<td align='right' class='label'><fmt:message key="Common.total.label" bundle="${common_labels}"/> :</td><td class='querydata'><%=total%></td>
				<td align='right' class='label'><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/> :</td><td class='querydata'><%=occupied%></td>
				<td align='right' class='label'><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/> :</td><td class='querydata'><%=vacant%></td>
				<td align='right' class='label'><fmt:message key="eIP.BookedBlocked.label" bundle="${ip_labels}"/></td><td class='querydata'><%=bbed%></td>
				<td align='right' class='label'><fmt:message key="eIP.Overrideable.label" bundle="${ip_labels}"/> :</td><td class='querydata'><%=overridable%></td>
				<td align='right' class='label'><fmt:message key="eIP.Nonoverrideable.label" bundle="${ip_labels}"/></td><td class='querydata'><%=nonoverridable%></td>
			</tr>
		</table>
		<%
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}		

	%>
	</body>
</html>

<%!
// Added by Sridhar R on 2/23/2005... 
// This func will check for null values & return empty string if Null...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

