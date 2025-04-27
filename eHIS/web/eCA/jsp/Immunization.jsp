<!DOCTYPE html>

<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	 <%
	  request.setCharacterEncoding("UTF-8");
	  String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
	<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title> <fmt:message key="eCA.ImmunizationDetails.label" bundle="${ca_labels}"/> </title>

</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()"  >
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String		patient_id			=	"";
	String		from				=	"";
	String		to					=	"";

	// variables for query retrieval


	String immunization_schedule_date				=	"";
	String immunization_actual_date					=	"";
	String immunization_details						=	"";

	String strsql2									=	"";
	String classValue								=	"";
	String vaccine_name								=	"";
	String administered_username					=	"";

	patient_id										=	checkForNull(request.getParameter("patient_id"),"");
	from											=	checkForNull(request.getParameter("from"),"1");
	to												=	checkForNull(request.getParameter("to"),"14");

	Properties p					=	(Properties)session.getValue("jdbc");
	String locale					=	(String) p.getProperty("LOCALE");

	int			start				=	0,		end				=	0;
	int			i					=	1		;

	if ( from == null )		start	=	1 ;
	else					start	=	Integer.parseInt( from ) ;

	if ( to == null )		end		=	14 ;
	else					end		=	Integer.parseInt( to ) ;

	try
	{
		con			=	ConnectionManager.getConnection(request);

		//strsql2="SELECT   A.VACCINE_ID,CA_GET_DESC.CA_IM_VACCINE(A.VACCINE_ID,?,2)SHORT_DESC,to_char(A.SCHEDULE_DATE,'DD/MM/YYYY HH:MI') SCHEDULE_DATE, to_char(A.ADMINISTERED_DATE,'DD/MM/YYYY HH24:MI') ADMINISTERED_DATE,a.BATCH_ID,AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  WHERE a.VAC_SCH_REF = B.VAC_SCH_REF and b.PATIENT_ID= ? and A.OUTCOME_CODE = 'C' Order by A.SCHEDULE_DATE DESC";
		strsql2="SELECT   A.VACCINE_ID,CA_GET_DESC.CA_IM_VACCINE(A.VACCINE_ID,?,2)SHORT_DESC,SM_CONVERT_DATETIME_2T(A.SCHEDULE_DATE,?) SCHEDULE_DATE, SM_CONVERT_DATETIME_2T(A.ADMINISTERED_DATE,?) ADMINISTERED_DATE,a.BATCH_ID,AM_GET_DESC.AM_ANATOMICAL_SITE (A.ADMIN_SITE_ID,?,2) ADMIN_SITE_DESC, SM_GET_DESC.SM_APPL_USER (A.ADMINISTERED_BY,?,1) Administered_UserName FROM CA_IM_PAT_VAC_SCH_DTL A,CA_IM_PAT_VAC_SCH_HDR B  WHERE a.VAC_SCH_REF = B.VAC_SCH_REF and b.PATIENT_ID= ? and A.OUTCOME_CODE = 'C' Order by A.SCHEDULE_DATE DESC";

		pstmt		=	con.prepareStatement(strsql2);
		pstmt.setString	(	1,	locale	);
		pstmt.setString	(	2,	locale	);
		pstmt.setString	(	3,	locale	);
		pstmt.setString	(	4,	locale	);
		pstmt.setString	(	5,	locale	);
		pstmt.setString	(	6,	patient_id	);
		rs			=	pstmt.executeQuery();

%>

		<!-- <div id='divDataTitle' style='postion:relative'> -->
		<table width='100%' id='dataTitleTable' class='grid' align='center' >
			<TR>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.ActualDate.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.BatchNumber.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
			</tr>
		<!-- </table>
		</div>
		<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff"> -->
		<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while ( rs.next() && i<=end ){
			//vaccine_name	=checkForNull(rs.getString(1),"&nbsp;");
			vaccine_name				=	checkForNull(rs.getString("SHORT_DESC"),"&nbsp;");
			immunization_schedule_date	=	checkForNull(rs.getString("SCHEDULE_DATE"),"&nbsp;");
			immunization_actual_date	=	checkForNull(rs.getString("ADMINISTERED_DATE"),"&nbsp;");
			immunization_details		=	checkForNull(rs.getString(5));
			administered_username		=	checkForNull(rs.getString("Administered_UserName"),"&nbsp;");
			

			/*if ( i % 2 == 0 )		classValue = "QRYEVEN" ;
			else					classValue = "QRYODD" ;
			*/
			classValue="gridData";

			out.println("<tr><td  width='20%' class='" + classValue +"'>"+vaccine_name+"</td>");
			out.println("<td width='20%' class='" + classValue +"'>"+immunization_schedule_date+"</td>");
			out.println("<td width='20%' class='" + classValue +"'>"+immunization_actual_date+"</td>");
			out.println("<td width='20%' class='" + classValue +"'>"+immunization_details+"</td>");
			out.println("<td width='20%' class='" + classValue +"'>"+administered_username+"</td></tr>");
			i++;
		}//endwhile

		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception e)
	{
		//out.print("Exception@1: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181

	}
	finally   
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
<%!
	public String checkForNull(String inputString, String defaultValue)
	{
		return ( (inputString==null) ? defaultValue : inputString );
	}
	public String checkForNull(String inputString)
	{
		return ( (inputString==null) ? "" : inputString );
	}
%>
</td></tr>
</table>
<br><center>
</center>
</body>
</html>

