<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name = 'NonValidRecsForm' >
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='left'>
<tr class='HEADER'><b><fmt:message key="eFM.FollowingFilesReturnDatecannotbeChanged.label" bundle="${fm_labels}"/></b></tr>
<td class='columnheader'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></td>
<td class='columnheader'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
<%
	Connection con = ConnectionManager.getConnection(request);
	Statement stmt		= null;
	ResultSet rs		= null;
try
{
	stmt				= con.createStatement();
	String facility_id 	= (String) session.getValue("facility_id");
	String patient_id	= request.getParameter("patient_id");
	String classValue	= "";
	String bgcolor		= "";
	String sql			= "";
	int i = 0;
	
	sql="select decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status,curr_file_status curr_file_status1 ,get_patient_line('"+patient_id+"','"+localeName+"')patient_line, curr_fs_locn_code , curr_fs_locn_short_desc curr_fs_locn_desc, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time,to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, file_no,MR_PAT_LOCN_SHORT_DESC  MR_PAT_FS_LOCN_DESC,decode(MR_PAT_FS_LOCN_IDENTITY,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')MR_PAT_FS_LOCN_IDENTITY, decode(curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','E','External')curr_fs_locn_identity, curr_facility_name FROM fm_curr_locn_vw WHERE facility_id='"+facility_id+"'AND patient_id='"+patient_id+"' AND ((curr_file_status = 'I' AND mr_pat_fs_locn_code = curr_fs_locn_code ) OR curr_file_status IN ('T','L','A'))";


// 	out.println("sql :"+sql);

	rs = stmt.executeQuery(sql);

	while ( rs.next() )
	{ 
		if ( i % 2 == 0 ) classValue = "QRYEVEN" ;		else	classValue = "QRYODD" ;

		if (rs.getString("curr_file_status1").equals("A"))
			bgcolor	= "FFEECC";
		else if (rs.getString("curr_file_status1").equals("T"))
			bgcolor = "CCEEDD";
		else if (rs.getString("curr_file_status1").equals("L"))
			bgcolor = "FFFFEE";
		else if (rs.getString("curr_file_status1").equals("I"))
			bgcolor = "FFB6C1";
		else
			bgcolor = "";

		

		out.println("<tr><td width=45%  style='background-color:"+bgcolor+"' class='" + classValue + "' ><font size=1><b>");
		out.println( rs.getString("file_no") +"<input type=hidden name=p_file_no"+i+" value="+rs.getString("file_no")+"></b><br>&nbsp;&nbsp;" +rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6));
		out.println("</font></td>");
		out.println("<td  class='"+classValue+"'><font size=1>"+rs.getString("curr_facility_name") +"</font></td>");
		out.println("<td width=15% class='" + classValue + "'><font size=1>");
		out.println(rs.getString("MR_PAT_FS_LOCN_DESC")+"");
		out.println("</font></td>");
		out.println("<td width=15%  class='" + classValue + "'><font size=1>");
		out.println(rs.getString("curr_fs_locn_desc") +"<br>&nbsp;&nbsp;&nbsp;(" + rs.getString("curr_fs_locn_identity")+")"+"");
		out.println("</font></td></tr>");
		
		i++;
	} //endwhile
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
}
catch(Exception e)
{}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</TABLE>
</FORM>
</BODY>
</HTML>

