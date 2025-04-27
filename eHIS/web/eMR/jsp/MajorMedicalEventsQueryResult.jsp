<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,com.ehis.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!--,oracle.jdbc.driver.*-->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eMR/js/CreatePatientFile.js" language="JavaScript"></Script>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'>");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patID=request.getParameter("Patient_Id");
String locale=(String)session.getAttribute("LOCALE"); 

Connection conn =null;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

PreparedStatement stmt=null;
ResultSet rs=null;


try{
conn=ConnectionManager.getConnection(request);

/*String strsql2="select  a.MED_EVENT_TYPE_CODE, to_char(a.EVENT_SDATE,'dd/mm/yyyy') event_sdate1, to_char(a.EVENT_EDATE,'dd/mm/yyyy') event_edate1, a.EVENT_DETAILS, a.EVENT_CONFIRMED_FLAG,b.LONG_DESC  from MR_MED_EVENT_LOG a , mr_med_event_type b  where patient_id = ? and a. MED_EVENT_TYPE_CODE = b.MED_EVENT_TYPE_CODE";
*/

String strsql2 = "select a.med_event_type_code, to_char(a.event_sdate,'dd/mm/yyyy') event_sdate1, to_char(a.event_edate,'dd/mm/yyyy') event_edate1, a.event_details, a.event_confirmed_flag, b.long_desc  from MR_MED_EVENT_LOG a , MR_MED_EVENT_TYPE_LANG_VW b where patient_id = ? and a.med_event_type_code = b.med_event_type_code and b.language_id ='"+locale+"'";

stmt=conn.prepareStatement(strsql2);
stmt.setString(1,patID);
rs = stmt.executeQuery();

// variables for query retrieval

String med_event_type_code 	= "";
String event_sdate	= "";
String event_sdate_display = "";
String event_edate	= "";
String event_edate_display	= "";
String event_details	= "";
String event_confirmed_flag	= "";
String long_desc="";

%>
<table border="1" width="100%" cellspacing='0' cellpadding='3' align=center>
<tr>
<td class="COLUMNHEADER"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td class="COLUMNHEADER"><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/> </td>
<td class="COLUMNHEADER"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
<td class="COLUMNHEADER"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
<td class="COLUMNHEADER"><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></td>
</tr>
<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	    String classValue = "" ;
while ( rs.next() && i<=end )
{
	med_event_type_code 	= rs.getString("med_event_type_code");
	if(med_event_type_code==null) med_event_type_code="&nbsp;";

	event_sdate	= rs.getString("event_sdate1");
	if(event_sdate==null)
	{
		event_sdate="&nbsp;";
		event_sdate_display = "&nbsp;"; 
	}
	else
		event_sdate_display = DateUtils.convertDate(event_sdate,"DMY","en",locale);

	event_edate	= rs.getString("event_edate1");
	if(event_edate==null)
	{ 
		event_edate="&nbsp;";
		event_edate_display = "&nbsp;";
	}
	else
		event_edate_display = DateUtils.convertDate(event_edate,"DMY","en",locale);

	event_details	= rs.getString("event_details");
	if(event_details==null) event_details="&nbsp;";
	event_confirmed_flag 	= rs.getString("event_confirmed_flag");
	if(event_confirmed_flag==null) event_confirmed_flag="N";
	long_desc = rs.getString("long_desc");
		if(long_desc == null) long_desc="";

	
if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'><a href=\"../../eMR/jsp/MajorMedicalEventsAddModify.jsp?long_desc="+java.net.URLEncoder.encode(long_desc)+"&Patient_Id="+patID+"&med_event_type_code="+med_event_type_code+"&event_sdate="+event_sdate+"\"  target='addmodify'>");
	out.println(long_desc+"</a></td>");
	//out.println("<td class='" + classValue + "'><input type='hidden' name='hidden"+i+"' id='hidden"+i+"' value=\""+event_details+"\"><a href='javascript:displayDetails(document.getElementById('hidden')"+i+")' > ");
	out.println("<td class='" + classValue + "'>" +
    "<input type='hidden' name='hidden" + i + "' id='hidden" + i + "' value=\"" + event_details + "\">" +
    "<a href='javascript:displayDetails(document.getElementById(\"hidden" + i + "\"))'>Details</a>" +
    "</td>");
	//out.println("<fmt:message key='Common.details.label' bundle='${common_labels}'/></a></td><td class='" + classValue + "'>");
	%>
	<fmt:message key='Common.details.label' bundle='${common_labels}'/></a></td>
	<%
	out.println("<td class='" + classValue + "'>");
	out.println(event_sdate_display);
	out.println("</td><td class='" + classValue + "'>");
	out.println(event_edate_display);
	out.println("</td>");
	out.println("<td  class='" + classValue + "'>");

	if ( rs.getString("event_confirmed_flag").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("&nbsp;");
	i++;

  }//endwhile
}catch(Exception e){
		//out.print(e.toString());
		e.printStackTrace();
}
	finally   {
try
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
	}

catch(Exception e){
	//out.println("Exception @ finally"+e.toString());
	e.printStackTrace();
}
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

