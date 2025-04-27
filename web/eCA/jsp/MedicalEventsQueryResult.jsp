<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added by Archana Kumari Dhal @15/12/2008-->
    
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCA/js/MedicalEvents.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


</script>
</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll='scrollTitle()'>

<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String		patient_id			=	"";
	String		from				=	"";
	String		to					=	"";

	// variables for query retrieval

	String med_event_type_code		=	"";
	String event_sdate				=	"";
	String event_edate				=	"";
	String event_psdate				=	"";
	String event_pedate				=	"";
	String event_details			=	"";
	String strsql2					=	"";
	String classValue				=	"";
	String eventType="";

	patient_id						=	checkForNull(request.getParameter("patient_id"),"");
	from							=	checkForNull(request.getParameter("from"),"1");
	to								=	checkForNull(request.getParameter("to"),"14");


	int			start				=	0,		end				=	0;
	int			i					=	1;

	if ( from == null )		start	=	1 ;
	else					start	=	Integer.parseInt( from ) ;

	if ( to == null )		end		=	14 ;
	else					end		=	Integer.parseInt( to ) ;

	try
	{
		con			=	ConnectionManager.getConnection(request);

		//strsql2		=	" select  SHORT_DESC des, a.med_event_type_code, to_char(event_sdate,'dd/mm/yyyy') event_sdate1,  to_char(event_edate,'dd/mm/yyyy') event_edate1, event_details, event_confirmed_flag from mr_med_event_log a, mr_med_event_type b where patient_id = ? and a.MED_EVENT_TYPE_CODE=b.MED_EVENT_TYPE_CODE  ";
		strsql2 = "select  MR_GET_DESC.MR_MED_EVENT_TYPE(a.MED_EVENT_TYPE_CODE,?,'2')  des, a.med_event_type_code, to_char(event_sdate,'dd/mm/yyyy') event_sdate1,  to_char(event_edate,'dd/mm/yyyy') event_edate1, event_details, event_confirmed_flag from mr_med_event_log a where patient_id = ? ";

		pstmt		=	con.prepareStatement(strsql2);
		pstmt.setString	(	1,	locale	);
		pstmt.setString	(	2,	patient_id	);
		rs			=	pstmt.executeQuery();

		%>
		<div id='divDataTitle' style='postion:relative'>
		<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
			<tr>
				<th class='columnHeadercenter' align='left'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' align='left'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' align='left'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' align='left'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></th>
			</tr>
		</table>
		</div>
		<table width='100%' id='dataTable' class='grid' align='center'>
		<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while ( rs.next() && i<=end )
		{
			eventType	=checkForNull(rs.getString("des"),"&nbsp;");
			med_event_type_code 	=	checkForNull(rs.getString("med_event_type_code"),"&nbsp;");
			event_sdate				=	checkForNull(rs.getString("event_sdate1"),"&nbsp;");
			event_edate				=	checkForNull(rs.getString("event_edate1"),"&nbsp;");
			event_details			=	checkForNull(rs.getString("event_details"),"&nbsp;");

			if(!event_sdate.equals("&nbsp;") )
				event_psdate	= com.ehis.util.DateUtils.convertDate(event_sdate,"DMY","en",locale);

			if(!event_edate.equals("&nbsp;") )
				event_pedate	= com.ehis.util.DateUtils.convertDate(event_edate,"DMY","en",locale);
			
			/*if ( i % 2 == 0 )		classValue = "QRYEVEN" ;
			else					classValue = "QRYODD" ;*/

			classValue = "gridData" ;


			out.println("<tr><td class='" + classValue + "'><a class='gridLink' href=\"../../eCA/jsp/MedicalEventsDetail.jsp?patient_id="+patient_id+"&med_event_type_code="+med_event_type_code+"&event_sdate="+event_sdate+"\"  target='MedicalEventsDtlFrame'>");

			out.println(eventType+"</a></td>");

			out.println("<td class='" + classValue + "'><a class='gridLink' href=\"../../eCA/jsp/MedicalEventsDetail.jsp?patient_id="+patient_id+"&med_event_type_code="+med_event_type_code+"&event_sdate="+event_sdate+"\"  target='MedicalEventsDtlFrame'>");
			out.println(event_details+"</a></td><td class='" + classValue + "'><a class='gridLink' href=\"../../eCA/jsp/MedicalEventsDetail.jsp?patient_id="+patient_id+"&med_event_type_code="+med_event_type_code+"&event_sdate="+event_sdate+"\"  target='MedicalEventsDtlFrame'>");
			out.println(event_psdate);
			out.println("</td><td class='" + classValue + "'><a class='gridLink' href=\"../../eCA/jsp/MedicalEventsDetail.jsp?patient_id="+patient_id+"&med_event_type_code="+med_event_type_code+"&event_sdate="+event_sdate+"\"  target='MedicalEventsDtlFrame'>");
			out.println(event_pedate);
			out.println("</td>");
			out.println("<td  class='" + classValue + "'>");
			if ( rs.getString("event_confirmed_flag").equals("Y") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
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
<TR style='visibility:hidden'>
	<th class='columnHeader' ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></th>
	<th class='columnHeader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th class='columnHeader'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
	<th class='columnHeader'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
	<th class='columnHeader'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></th>
</tr>
</table>
<br><center>
</center>
</body>
</html>
<script>alignWidth();</script>

