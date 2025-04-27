<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String classvalue = "";
try{
	String patient_class = request.getParameter("patient_class");
	String long_desc		= request.getParameter("long_desc");
	String Intervention_code		= request.getParameter("Intervention_code");
	String short_desc		= request.getParameter("short_desc");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(patient_class == null || patient_class.equals("null")) patient_class =" "; else patient_class = patient_class.trim();
	if(long_desc == null || long_desc.equals("null")) long_desc =" "; else long_desc = long_desc.trim();
	if(Intervention_code == null || Intervention_code.equals("null")) Intervention_code =" "; else Intervention_code = Intervention_code.trim();
	if(short_desc == null || short_desc.equals("null")) short_desc =" "; else short_desc = short_desc.trim();

    HashMap sqlMap = new HashMap();
//	String sql_Intervention="select a.patient_class, b.long_desc, a.intervention_code, c.short_desc  from ca_pat_class_intervention a, am_patient_class b, ca_intervention c where a.patient_class = b.patient_class and a.Intervention_code = c.Intervention_code  and upper(a.patient_class) like upper(?) and upper(b.long_desc) like upper(?) and upper(a.Intervention_code) like upper(?) and upper(c.short_desc) like upper(?)";
	String sql_Intervention="SELECT a.patient_class, b.long_desc, a.intervention_code, c.short_desc  FROM ca_pat_class_intervention a, am_patient_class_lang_vw b, ca_intervention_lang_vw c WHERE a.patient_class = b.patient_class AND a.Intervention_code = c.Intervention_code  AND UPPER(a.patient_class) LIKE UPPER(?) AND UPPER(b.long_desc) LIKE UPPER(?) AND UPPER(a.Intervention_code) LIKE UPPER(?) AND UPPER(c.short_desc) LIKE UPPER(?) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = ?";

	sqlMap.put( "sqlData",sql_Intervention);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("patient_class");
	displayFields.add("long_desc");
	displayFields.add("Intervention_code");
	displayFields.add("short_desc");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add( patient_class+"%");
	chkFields.add( long_desc+"%");
	chkFields.add( Intervention_code+"%");
	chkFields.add( short_desc+"%");
	chkFields.add( locale);
	chkFields.add( locale);


	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

 %>
	 <table cellpadding=0 cellspacing=0 width="98%" align="center">
<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
<%
	// For display the previous/next link
     out.println(result.get(1));
%>
	</td>
</tr>
</table>

<table cellpadding=0 cellspacing=0 border=1 align=center width='98%'>
<tr>

	<th width="15%" align='left'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
	<th width="20%" align='left'><fmt:message key="Common.PatientClassDescription.label" bundle="${common_labels}"/></th>
	<th width="10%" align='left'><fmt:message key="eCP.InterventionCode.label" bundle="${cp_labels}"/></th>
	<th width="20%" align='left'><fmt:message key="eCP.InterventionDescription.label" bundle="${cp_labels}"/></th>
</tr>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
			records=(ArrayList) result.get( recCount );
		%>				
		<tr>   
		<%
		for(int colCount=0; colCount<records.size(); colCount++){		
			String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
			if(str.equals("")){%>
			<td class="<%=classvalue%>">&nbsp;</td>
 		<%} else {
		 %>
				<td class="<%=classvalue%>"><%=str%></td>
		  <%}}//end of for loop
		  %>
</tr>
<%}//Loop for all records%>


		  </table>
	<%
	//out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/InterventionForPatientClassQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  




	


