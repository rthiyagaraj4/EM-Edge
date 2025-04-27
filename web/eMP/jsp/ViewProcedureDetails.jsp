<!DOCTYPE html>
﻿<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<title><fmt:message key="Common.Surgery.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
 Connection con=null;
 PreparedStatement stmt=null;
 ResultSet rs=null;
try{ 
    con=ConnectionManager.getConnection(request);
   
	String patient_id        = request.getParameter("patient_id");
    String operating_facility_id=(String) session.getValue("facility_id");
	String locale=(String)session.getAttribute("LOCALE");
    String procedure="";
    String date="";
    String practitioner="";
    String classValue="";
  
    int k=1;
   
%>
<form>
<table cellpadding=0 cellspacing=0 width='100%' align=center>
<tr>
   <td class='columnheader' ><fmt:message key="Common.Surgery.label" bundle="${common_labels}"/>&nbsp;</td>
   <td class='columnheader' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/>&nbsp;</td>
   <td class='columnheader' ><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>&nbsp;</td>
   </tr>

    <%

	String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') practitioner_name from pr_encounter_procedure a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' order by proc_date desc ";  
  
		stmt = con.prepareStatement(sql);
		stmt.setString(1, locale);
		stmt.setString(2, operating_facility_id);
		stmt.setString(3, patient_id);
		
        rs = stmt.executeQuery();		
		 while (rs.next()){ 
			if(k%2 == 0)
               classValue = "QRYEVEN" ;
            else
               classValue = "QRYODD" ;
            procedure       =(rs.getString("proc_narration")==null)?"&nbsp;":rs.getString("proc_narration");
            date            =(rs.getString("proc_date")==null)?"&nbsp;":rs.getString("proc_date");
            practitioner    =(rs.getString("practitioner_name")==null)?"&nbsp;":rs.getString("practitioner_name");

					if(!date.equals("&nbsp;"))
						date = com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);         
                  
			out.println("<tr><td nowrap class='"+classValue+"'>");	 
			out.println( procedure+"</td><td nowrap class='" + classValue + "'>");	
			out.println( date+"</td><td nowrap class='" + classValue + "'>");	
			out.println( practitioner );
			out.println("</td><td class='" + classValue + "'></tr>");
			k++;
        }
			if(rs!=null)    rs.close();
            if(stmt!=null)  stmt.close();
	%><tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
    <td align=right><input type=button class=button name=Close value='<fmt:message key="Common.close.label" bundle="${common_labels}"/> ' onclick='window.close()'></td>
    
	</tr>
<%}catch(Exception e){
	e.printStackTrace();
}finally{
	try{	
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}%>
</form>
</body>
</html>

