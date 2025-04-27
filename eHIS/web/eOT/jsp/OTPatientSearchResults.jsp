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
	String patient_class	= checkForNull(request.getParameter("patient_class"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String encounter_id		= checkForNull(request.getParameter("encounter_id"));
	String patient_name		= checkForNull(request.getParameter("patient_name"));
	String from				= checkForNull(request.getParameter("from")).intern() ;
	String to				= checkForNull(request.getParameter("to")).intern() ;
	String view_by			= checkForNull(request.getParameter("view_by"));
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;

	start = (from!="")?Integer.parseInt( from ):1;
	end =	(to!="")?Integer.parseInt( to ):14;

	/*if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
    if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }*/

  	StringBuffer append_str	= new StringBuffer();

	//String resp_id="";String commentVal="",fromDatVal="",toDatVal="";
	//String sqlUser="";
	if(patient_id==null) patient_id="";
	if(patient_id.equalsIgnoreCase("null")) patient_id="";

	if(patient_name==null) patient_name="";
	if(patient_name.equalsIgnoreCase("null")) patient_name="";
	if(encounter_id==null) encounter_id="";
	if(encounter_id.equalsIgnoreCase("null")) encounter_id="";
	if(patient_class==null) patient_class="";
	if(patient_class.equalsIgnoreCase("null")) patient_class="";
	if(!patient_id.equals(""))
	append_str = append_str.append(" AND PATIENT_ID LIKE '%"+patient_id+"%' ");

	if(!patient_class.equals("")){
		if(patient_class.equals("A"))
			append_str = append_str.append(" AND PATIENT_CLASS = PATIENT_CLASS ");
		else
			append_str = append_str.append(" AND UPPER(PATIENT_CLASS) LIKE UPPER('%"+patient_class+"%') ");
	}

	if(!encounter_id.equals(""))
	append_str = append_str.append(" AND ENCOUNTER_ID LIKE '%"+encounter_id+"%' ");
	if(!patient_name.equals(""))
	append_str = append_str.append(" AND UPPER(PATIENT_NAME) LIKE UPPER('%"+patient_name+"%') ");
	//append_str = append_str.append(" AND ROWNUM < "+(end+1));
	append_str = append_str.append(" ORDER BY "+view_by);
	stmt1=con.createStatement();
	String cnt_sql = " select count(*) FROM OT_PATIENT_LOOKUP_VW WHERE FACILITY_ID='"+facility_id+"'"+append_str;
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
<script src='../../eOT/js/OTPatientSearch.js' language='javascript'></SCRIPT>
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
<form name='responsibility_form' id='responsibility_form' action='../../eOT/jsp/OTPatientSearchResults.jsp' method='post' >
	<table width='100%'>
	<tr>
	<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
	    <a href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'>
		<fmt:message key="Common.previous.label" bundle="${common_labels}"/>
		</a>
	
	<%
	    }
	    if ( !((start+14) > maxRecord )){
	%>
	    <a href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'>
		<fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			
	<%
	    }
	%>
	</td>
	</tr>
	</table>

	<table border='1' cellpadding=3 cellspacing='0' align='center'  width='100%' >
		<td  class="columnHeader" width="10%">
			<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
		</td>
		<td  class="columnHeader" width="20%">
		<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
		</td>
<!-- 		<th width="10%">Patient Class</th>
 -->	<td  class="columnHeader" width="10%">
			<fmt:message key="Common.episodeid.label" bundle="${common_labels}"/>
		</td>
		<td   class="columnHeader" width="10%">
			<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
		</td>
<!-- 		<th width="10%">Visit Id</th> 
 -->	
		<td  class="columnHeader" width="7%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/>
		</td>
		<td  class="columnHeader" width="9%"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>
		</td>
	    <td  class="columnHeader" width="7%">
		<fmt:message key="Common.VisitID.label" bundle="${common_labels}"/>
		</td>
<%

	String sql_patient="SELECT PATIENT_ID, DECODE('"+locale+"', 'en',PATIENT_NAME, PATIENT_NAME_LOC_LANG) PATIENT_NAME, EPISODE_TYPE, PATIENT_CLASS, ENCOUNTER_ID, EPISODE_ID, OP_EPISODE_VISIT_NUM, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH, SEX,RACE_CODE FROM OT_PATIENT_LOOKUP_VW WHERE FACILITY_ID='"+facility_id+"'"+append_str;
	stmt=con.createStatement();
	rset=stmt.executeQuery(sql_patient);
	if(rset!=null)
	{
		if ( start != 0 ){
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
		}
		}
	//	String	HYPERLINK		= "HYPERLINK";
		String	patient_id1		="";
		String	patient_name1	="";
	//	String	patient_class1	="";
		String	episode_type1	= "";
		String	episode_id1		="";
		String	encounter_id1	="";
		String	visit_no1		="";
		String	sex1			="";
		String	date_of_birth1	="";
		while(rset.next() && i<end ){
				if((i%2) == 1)
					classValue = "QRYODD";
				else
					classValue ="QRYEVEN";
				patient_id1=rset.getString("PATIENT_ID");
				patient_name1=rset.getString("PATIENT_NAME");
				episode_type1=rset.getString("EPISODE_TYPE");				
			//	patient_class1=rset.getString("PATIENT_CLASS");
				episode_id1=rset.getString("EPISODE_ID");
				if(episode_id1==null) episode_id1="";
				encounter_id1=rset.getString("ENCOUNTER_ID");
				visit_no1=rset.getString("OP_EPISODE_VISIT_NUM");
				sex1=rset.getString("SEX");
				date_of_birth1=com.ehis.util.DateUtils.convertDate(rset.getString("DATE_OF_BIRTH"),"DMY","en",locale);
				if(visit_no1==null) visit_no1="";
				out.println("<tr>");
				out.println("<td class='"+classValue+"' onClick=returnPatientDetails('"+i+"','"+patient_id1+"','"+episode_type1+"','"+encounter_id1+"','"+episode_id1+"','"+date_of_birth1+"','"+sex1+"','"+visit_no1+"');><font class='HYPERLINK' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'> "+patient_id1+"</font></td>");
				out.println("<td class='"+classValue+"' >"+patient_name1+"</td>");
				//out.println("<td class='"+classValue+"' >"+patient_class1+"</td>");
				out.println("<td class='"+classValue+"' >"+episode_id1+"</td>");
				out.println("<td class='"+classValue+"' >"+encounter_id1+"</td>");
				//out.println("<td class='"+classValue+"' >"+visit_no1+"</td>");
				out.println("<td class='"+classValue+"' >"+sex1+"</td>");
				out.println("<td class='"+classValue+"' >"+date_of_birth1+"</td>");
				out.println("<td align='center'class='"+classValue+"' >"+visit_no1+"</td>");
				
			out.println("</tr>");
		%>
				<input type='hidden' name='patient_name_<%=i%>' id='patient_name_<%=i%>' value="<%=patient_name1%>" >
		<%
		
			i++;
		}
	}

	if(i==0) 
		out.println("<SCRIPT>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</SCRIPT>");
%>	
	</table>
		<input type=hidden name=from value='<%=start%>'>
		<input type=hidden name=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
		<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>" >
		<input type='hidden' name='patient_name' id='patient_name' value="<%=patient_name%>" >
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
		<input type='hidden' name='view_by' id='view_by' value="<%=view_by%>" >


	
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

