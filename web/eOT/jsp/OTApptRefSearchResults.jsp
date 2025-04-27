<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.ResultSet,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement ,webbeans.eCommon.ConnectionManager" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<%
	
	request.setCharacterEncoding("UTF-8");
	
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset=null ;
	ResultSet rset1=null ;

	String classValue="";
try{
	con = ConnectionManager.getConnection(request);
	String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String theatre_date_from	= checkForNull(request.getParameter("theatre_date_from"));
	String theatre_date_to = checkForNull(request.getParameter("theatre_date_to"));
	
	String from				= checkForNull(request.getParameter("from")).intern() ;
	String to				= checkForNull(request.getParameter("to")).intern() ;
	String view_by			= checkForNull(request.getParameter("view_by"));
	String func_id			= checkForNull(request.getParameter("func_id"));
	String	appt_date1		="";
	String	appt_ref_numm		="";
	String cnt_sql = "";
	String sql_patient="";
	String order_id="";

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;

	start = (from!="")?Integer.parseInt( from ):1;
	end =	(to!="")?Integer.parseInt( to ):14;

	stmt1=con.createStatement();
	if(func_id.equals("Chk_In")){
		cnt_sql = " SELECT count(*) FROM OT_SCHD_OPERS_VW WHERE PATIENT_ID='"+patient_id+"' AND APPT_DATE BETWEEN TO_DATE('"+theatre_date_from+"','DD/MM/YYYY') AND TO_DATE('"+theatre_date_to+"','DD/MM/YYYY') AND OPER_STATUS IN('10','15','20','25','30','35') ";
	}else{
		cnt_sql = " SELECT count(*) FROM OT_SCHD_OPERS_VW WHERE PATIENT_ID='"+patient_id+"' AND APPT_DATE BETWEEN TO_DATE('"+theatre_date_from+"','DD/MM/YYYY') AND TO_DATE('"+theatre_date_to+"','DD/MM/YYYY') AND OPER_STATUS IN('40','45') ";
	}

	rset1 = stmt1.executeQuery(cnt_sql);
	rset1.next();
	maxRecord = rset1.getInt(1);
%>

<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOT/js/OTApptRefNumSearch.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}

</script>
</head>
<body  onLoad="FocusFirstElement();" ;onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<form name='responsibility_form' id='responsibility_form' action='../../eOT/jsp/OTApptRefSearchResults.jsp' method='post' >
	<table width='100%'>
	<tr>
	<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
	    <!-- <a href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'>
		<fmt:message key="Common.previous.label" bundle="${common_labels}"/>
		</a> -->
	
	<%
	    }
	    if ( !((start+14) > maxRecord )){
	%>
	    <!-- <a href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'>
		<fmt:message key="Common.next.label" bundle="${common_labels}"/></a> -->
			
	<%
	    }
	%>
	</td>
	</tr>
	</table>

	<table border='1' cellpadding=3 cellspacing='0' align='center'  width='100%' >
		<td   class="columnHeader" width="10%">
			<fmt:message key="eOT.DateTimeSlot.Label" bundle="${ot_labels}"/>
		</td>
		<%
	  if(func_id.equals("Chk_In")){%>
		<td   class="columnHeader" width="10%">
			<fmt:message key="eOT.ApptRefnum.Label" bundle="${ot_labels}"/>
		</td><%}else{%>
		<td   class="columnHeader" width="10%">
			<fmt:message key="eOT.OperationNo.Label" bundle="${ot_labels}"/>
		</td><%}%>
<%
	if(func_id.equals("Chk_In")){
		//sql_patient="SELECT TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') APPT_DATE,A.APPT_REF_NUM APPT_REF_NUM FROM OT_SCHD_OPERS_VW A WHERE PATIENT_ID='"+patient_id+"' AND APPT_DATE BETWEEN TO_DATE('"+theatre_date_from+"','DD/MM/YYYY') AND TO_DATE('"+theatre_date_to+"','DD/MM/YYYY') and language_id='"+locale+"' AND OPER_STATUS IN('10','15','20','25','30','35')  ";
		sql_patient="SELECT TO_CHAR(A.APPT_DATE,'DD/MM/YYYY')||'('||to_char(APPT_FROM_TIME,'HH24:MI')||'-'|| to_char(APPT_TO_TIME,'HH24:MI')||')' APPT_DATE1,A.APPT_REF_NUM APPT_REF_NUM,ORDER_ID ORDER_ID1 FROM OT_SCHD_OPERS_VW A WHERE PATIENT_ID='"+patient_id+"' AND APPT_DATE BETWEEN TO_DATE('"+theatre_date_from+"','DD/MM/YYYY') AND TO_DATE('"+theatre_date_to+"','DD/MM/YYYY') AND OPER_STATUS IN('10','15','20','25','30','35')  and language_id='"+locale+"' ";
	}else{
	//sql_patient="SELECT TO_CHAR(A.OPER_DATE,'DD/MM/YYYY') OPER_DATE,A.OPER_NUM OPER_NUM FROM OT_SCHD_OPERS_VW A WHERE PATIENT_ID='"+patient_id+"' AND APPT_DATE BETWEEN TO_DATE('"+theatre_date_from+"','DD/MM/YYYY') AND TO_DATE('"+theatre_date_to+"','DD/MM/YYYY') and language_id='"+locale+"' AND OPER_STATUS IN('40','45')  ";
	sql_patient="SELECT TO_CHAR(A.APPT_DATE,'DD/MM/YYYY')||'('||to_char(APPT_FROM_TIME,'HH24:MI')||'-'|| to_char(APPT_TO_TIME,'HH24:MI')||')' OPER_DATE,A.OPER_NUM OPER_NUM,ORDER_ID ORDER_ID1 FROM OT_SCHD_OPERS_VW A WHERE PATIENT_ID='"+patient_id+"' AND APPT_DATE BETWEEN TO_DATE('"+theatre_date_from+"','DD/MM/YYYY') AND TO_DATE('"+theatre_date_to+"','DD/MM/YYYY') and language_id='"+locale+"' AND OPER_STATUS IN('40','45')  ";
	}

	stmt=con.createStatement();
	rset=stmt.executeQuery(sql_patient);

	if(rset!=null)
	{
		if ( start != 0 ){
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
		}
		}
	
		while(rset.next() && i<end ){
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				appt_date1=rset.getString(1);
				appt_ref_numm=rset.getString(2);
				order_id=rset.getString(3);
				out.println("<tr>");
				out.println("<td class='"+classValue+"' onClick=returnPatientDetails('"+i+"','"+appt_date1+"','"+appt_ref_numm+"','"+order_id+"');><font class='HYPERLINK' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'>"+appt_date1+"</font></td>");
				//out.println("<td class='"+classValue+"' >"+encounter_id1+"</td>");
				out.println("<td class='"+classValue+"' >"+appt_ref_numm+"</td>");
			out.println("</tr>");
		%>
				<input type='hidden' name='appt_ref_num_<%=i%>' id='appt_ref_num_<%=i%>' value="<%=appt_ref_numm%>" >
		<%
		
			i++;
		}
	}

	if(i==0) 
		out.println("<SCRIPT>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</SCRIPT>");
%>	
	</table>
		<input type='hidden' name=from id=from value='<%=start%>'>
		<input type='hidden' name=to id=to value='<%=end%>'>
		<input type='hidden' name='start' id='start' value='<%=start%>'>
		<input type='hidden' name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='appt_ref_num' id='appt_ref_num' value="<%=appt_ref_numm%>" >
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
		<input type='hidden' name='appt_date' id='appt_date' value="<%=appt_date1%>" >
		<input type='hidden' name='view_by' id='view_by' value="<%=view_by%>" >
		<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>" >


	
<%	}catch(Exception e){
	e.printStackTrace();
	out.println("err---1"+e);}
	finally {
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					if(rset1!=null) rset1.close();
					if(stmt1!=null) stmt1.close();
					if(pstmt!=null) pstmt.close();
					ConnectionManager.returnConnection(con,request);
	}	
	%>
	</form>
	</body>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</html>

