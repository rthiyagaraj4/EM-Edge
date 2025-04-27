<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>
 
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  
      <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></script>
	  <script language='javascript' src='../../eMO/js/MOBurialPermit.js' ></script>
	  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
	  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
String sql_query			= request.getParameter("sql_query");
String facilityId 			= (String) session.getValue( "facility_id" ) ;
String patient_id			= request.getParameter("patient_id");
String from 				= request.getParameter("from") ;
String to 					= request.getParameter("to") ;
%>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name = "SearchBurialQueryResult" action="../../eMO/jsp/MOBurialPermitResultPage.jsp" method="post"  >
<%  
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int aname=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;   

		Connection con = null;
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

	try
	{
		con =  ConnectionManager.getConnection(request);
	    stmt = con.createStatement();
	    String strsql1="",strsql2="";
		strsql1 ="select count(*) as total from mo_burial_permit_vw where patient_id not in (select NVL(patient_id,'*') patient_id from mo_mortuary_regn) and facility_id='"+facilityId+"'"+sql_query;
		
		rs = stmt.executeQuery(strsql1);

		while(rs!=null && rs.next())
		{
		  maxRecord = rs.getInt(1);
		}
	if (maxRecord==0)  
	{
    %>
		<script>		
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); 			
		</script>
   <%
	if(rs!=null) rs.close();
  	}else{
		strsql2="select patient_id, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, burial_permit_no, burial_permit_approved_by_name,burial_permit_approved_date from mo_burial_permit_vw where patient_id not in (select NVL(patient_id,'*') patient_id from mo_mortuary_regn) and facility_id='"+facilityId+"' "+sql_query+"  order by burial_permit_approved_date desc"; 
		rs = stmt.executeQuery(strsql2);  
%>

	<p>
	<table align='right'>
	<tr>
	<td>
	<%  
	if ( !(start <= 1) )
	out.println("<A HREF='../../eMO/jsp/MOBurialPermitResultPage.jsp?from="+(start-10)+"&to="+(end-10)+"&sql_query="+URLEncoder.encode(sql_query)+"&patient_id="+patient_id+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+10) > maxRecord ) )
	out.println("<A HREF='../../eMO/jsp/MOBurialPermitResultPage.jsp?from="+(start+10)+"&to="+(end+10)+"&sql_query="+URLEncoder.encode(sql_query)+"&patient_id="+patient_id+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
	%>
</td>
</tr>
</table>
<br>	
</p>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th nowrap>	<fmt:message key="eMO.DeceasedPatientID.label" bundle="${mo_labels}"/>		 </th>
<th>	<fmt:message key="eMO.DeceasedPatientName.label" bundle="${mo_labels}"/>	 </th>
<th>	<fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></th>
<th>	<fmt:message key="eMO.BurialPermitApprovedByName.label" bundle="${mo_labels}"/>	</th>
<th>	<fmt:message key="Common.BurialPermitApprovedDate.label" bundle="${common_labels}"/>		</th>
<% 
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
 String classValue = "" ;

 while ( rs!=null && rs.next() && i<=end )
 {
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	
	patient_id                            = rs.getString("patient_id");
	String patient_name                   = rs.getString("patient_name");
	String burial_permit_no               = rs.getString("burial_permit_no");
	String burial_permit_approved_by_name = rs.getString("burial_permit_approved_by_name");
	String burial_permit_approved_date= rs.getString("burial_permit_approved_date");
    patient_name	= (patient_name== null) ? "" :patient_name;
	burial_permit_no	= (burial_permit_no== null) ? "" :burial_permit_no;
	burial_permit_approved_by_name	= (burial_permit_approved_by_name== null) ? "" :burial_permit_approved_by_name;
	burial_permit_approved_date	= (burial_permit_approved_date== null) ? "" :burial_permit_approved_date;

	out.println("<tr style='background-color:'><td class='"+classValue+"'>");

%>
    <a name="<%=aname%>" onClick=""  href="javascript:callpage('<%=patient_id%>','<%=burial_permit_no%>');">
 
<% 
	out.println(patient_id+"</td><td class='" + classValue + "'>");
	out.println(patient_name+"</td><td class='" + classValue + "'>");
	out.println(burial_permit_no+"</td><td class='" + classValue + "'>");
	out.println(burial_permit_approved_by_name+"</td><td class='" + classValue + "'>");
	out.println(burial_permit_approved_date+"</td>");
	aname++;
	i++;
 }//endwhile         
 %>
</td></tr>
<script>
    parent.frames[0].document.forms[0].apply.disabled=true;
    parent.frames[0].document.forms[0].reset.disabled=true;
</script>
</table>
<%}%>
<br>
<%    
if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();
%>
</form>
<%
}catch(Exception e)
     {
		e.toString();
		out.println(e.toString());
     }
	finally   
	{
		 out.println("<script>parent.frames[1].document.forms[0].search.disabled = false;</script>"); 
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
    }  
%>
</body>
</html>

