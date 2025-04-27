<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name			Rev.Date		Rev.Name			DescriptionDescription
--------------------------------------------------------------------------------------------------------------
?             	100            		?           										created
19/04/2020    	IN072876	    	Ramesh Goli		19/04/2020		Ramesh G			MMS-KH-SCF-0063
05/06/2024   60772      Twinkle Shah    05/06/2024	    Ramesh Goli      MMS-JU-SCF-0267
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

*/
%>
<html>
<%@page import="java.sql.*, java.io.*, java.util.*, java.lang.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>
<title>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String read_only =(String)request.getParameter("read_only") == null ? "" : request.getParameter("read_only");
String disabled ="";
if(read_only.equals("readonly")){
	read_only ="readonly";disabled = "disabled";
%>
<fmt:message key="eCP.LibraryDescription.label" bundle="${cp_labels}"/>
<%
}else{%>
<fmt:message key="eCP.StandardCarePlans.label" bundle="${cp_labels}"/>
	<%}%> 
</title>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type ="text/css" href="../../eCP/html/GCPStyle.css"></link>
<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload=''>
<script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="generate_libraires" id="generate_libraires"  method ='post' target='' action=''>

<%
  
Connection con = null;
PreparedStatement ps = null,pstmt=null;
ResultSet rs = null,rst=null;

con = ConnectionManager.getConnection(request);

String patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String encounterId		= request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");	 ///60772

String case_type_code	= (String)request.getParameter("casetype_code") == null ? "" : request.getParameter("casetype_code");
String casetype_desc	= (String)request.getParameter("casetype_desc") == null ? "" : request.getParameter("casetype_desc");
String patient_class	= (String)request.getParameter("patient_class");
String term_set_id		= (String)request.getParameter("termset_id") == null ? "" : request.getParameter("termset_id");
String term_code		= (String)request.getParameter("term_code") == null ? "" : request.getParameter("term_code");
String term_code_desc	= (String)request.getParameter("term_code_desc") == null ? "" : request.getParameter("term_code_desc");
String Library			= (String)request.getParameter("Library") == null ? "" : request.getParameter("Library");
String lib_id			= (String)request.getParameter("lib_id") == null ? "" : request.getParameter("lib_id");
String vers_no			= (String)request.getParameter("versn_no") == null ? "" : request.getParameter("versn_no");

String show_diag		= (String)request.getParameter("show_diag") == null ? "" : request.getParameter("show_diag");
	
StringBuffer sql = new StringBuffer();
String classValue="";
String case_type_code1="",term_code1="";
HashMap codeKeyValue = new HashMap();
String checked = ""; 
int i=0;
try
{   
	eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	%>
	<table border='0' cellspacing='1' cellpadding='1' width='100%'  align='center'>
<%
		if(!read_only.equals("readonly")){

%>
	<tr>
		<th colspan='4' height='1' class='PLANHEAD' align='left'><font size="1.5"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCP.StandardCarePlans.label" bundle="${cp_labels}"/> </font></th>
		<!-- <th colspan='4'>Library</th> -->
	</tr><%}%>
	<tr>
		<th colspan='' height='1' class='PLANSUBHEAD' width='18%'><font size="1"><fmt:message key="eCP.Library.label" bundle="${cp_labels}"/></font></th>
		<th colspan='' height='1' class='PLANSUBHEAD' width='25%'><font size="1"><fmt:message key="eCP.Guideline.label" bundle="${cp_labels}"/></font></th>
		<th colspan='' height='1' class='PLANSUBHEAD' width='20%'><font size="1"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font></th>
		<th colspan='' height='1' class='PLANSUBHEAD' width='2%'><font size="1"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font></th>
		
	</tr>
	</table>	
	<%
	if(!case_type_code.equals(""))
	{

//	sql.append("SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE=? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO )");
	sql.append("SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY_LANG_VW B ,CP_CASE_TYPE_LANG_VW C WHERE A.CASE_TYPE_CODE=? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID");

	//case_type_code="";
	ps = con.prepareStatement(sql.toString());
	ps.setString(1, case_type_code);
	ps.setString(2, patient_class);
	ps.setString(3, locale);
	rs = ps.executeQuery();
%>
<table border='1' cellspacing='0' cellpadding='0' width='100%' align='center'>
<tr>
<%
	while(rs.next())
	{	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		
		case_type_code = rs.getString(1);
		if(!case_type_code.equals(case_type_code1)){
%>
			
			<td colspan='5' class='CAGROUPHEADING' height='1%'><font size="1" ><%out.println(rs.getString(2));%></font></td>
			</tr>
			<tr>
				<th colspan='' height='1'><font size="1"><fmt:message key="eCP.LibraryDescription.label" bundle="${cp_labels}"/></font></th>
				<th colspan='' height='1'><font size="1"><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></font></th>
				<th colspan='' height='1'><font size="1"><fmt:message key="eCP.Guideline.label" bundle="${cp_labels}"/></font></th>
				<th colspan='' height='1'><font size="1"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font></th>
			</tr>
			<tr>
			
			<%
			case_type_code1=case_type_code;			
		}
		codeKeyValue = bean.getCaseCode();
		String temp_chk= "";
		temp_chk =(String)codeKeyValue.get(case_type_code)== null?"":(String)codeKeyValue.get(case_type_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "";
		
%>
		<td class='<%=classValue%>' width='25%' height='1'><font size="1" color=""> <%=rs.getString(5)%>&nbsp;(<fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/>: <%=rs.getString(4)%>)</font></td>		
		<input type ='hidden' name='casetype_code<%=i%>' id='casetype_code<%=i%>' value='<%=rs.getString(1)%>'>		
		<input type ='hidden' name='casetype_desc<%=i%>' id='casetype_desc<%=i%>' value='<%=rs.getString(2)%>'>
		<input type ='hidden' name='library_code<%=i%>' id='library_code<%=i%>' value='<%=rs.getString(3)%>'>
		<input type ='hidden' name='version_no<%=i%>' id='version_no<%=i%>' value='<%=rs.getString(4)%>'>
		<input type ='hidden' name='lib_short_desc<%=i%>' id='lib_short_desc<%=i%>' value='<%=rs.getString(5)%>'>
	
	<td class='<%=classValue%>' width='10%' height='1'><font size="1" color=""> 
	<%out.println(rs.getString(4));%></font>			
	</td>
	<td class='<%=classValue%>' width='40%' height='1' align='center'>
	<textarea name="" rows="3" cols="60"><%out.println(rs.getString(6));%></textarea>
				
	</td>
	
	<td class='<%=classValue%>' width='5%' height='1' align='center'>
	<input type="checkbox" name='chk_library<%=i%>' id='chk_library<%=i%>' onClick='populateLibDetails("<%=i%>")' <%=checked%>> </td>
	</tr>
<%
		i++;
	}	
	rs.close();
	ps.close();
%>

</table>
<input type ='hidden' name='i' id='i' value='<%=i%>'>
<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>

<%	}
		else if(!term_set_id.equals("") && !term_code.equals("")){
//			con = ConnectionManager.getConnection(request);
//			sql.append("SELECT A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE A.LIBRARY_ID = ? AND B.VERSION_NO = ? AND A.TERM_SET_ID=? AND A.TERM_CODE  =? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO )");
			sql.append("SELECT A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY_LANG_VW B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE A.LIBRARY_ID = ? AND B.VERSION_NO = ? AND A.TERM_SET_ID=? AND A.TERM_CODE  =? AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS=? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) AND B.LANGUAGE_ID = ?");
	
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, lib_id);
			ps.setString(2, vers_no);
			ps.setString(3, term_set_id);
			ps.setString(4, term_code);
			ps.setString(5, patient_class);
			ps.setString(6, locale);
			rs = ps.executeQuery();

%>

<table border='0' cellspacing='0' cellpadding='0' width='100%' align='center' >
<tr>
<%
	while(rs.next())
	{	if ( i % 2 == 0 )
			classValue = "GRPEVEN" ;
		else
			classValue = "GRPOD" ;
		
		term_code = rs.getString(3);
		if(!term_code.equals(term_code1)){
%>
		<tr>
			
<%
			term_code1=term_code;			
			
		}
		String tmp_term_code ="";
		tmp_term_code = rs.getString(5)+"~"+rs.getString(6)+"~"+rs.getString(1)+"~"+rs.getString(3)+"~";
		codeKeyValue = bean.getTermCode();
		String temp_chk= "";
		//Set s=codeKeyValue.keySet();
		temp_chk =(String)codeKeyValue.get(tmp_term_code)== null?"":(String)codeKeyValue.get(tmp_term_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "checked";
		%>
		<td class='<%=classValue%>' width='20%' height='1'><font size="1" color=""> 
		<B><%out.println(rs.getString(7));%>&nbsp;(<fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/>: <%=rs.getString(6)%>)</B></font></td>			
<input type ='hidden' name='term_set_id<%=i%>' id='term_set_id<%=i%>' value='<%=rs.getString(1)%>'>		
<input type ='hidden' name='term_code<%=i%>' id='term_code<%=i%>' value='<%=rs.getString(3)%>'>
<input type ='hidden' name='library_code<%=i%>' id='library_code<%=i%>' value='<%=rs.getString(5)%>'>
<input type ='hidden' name='version_no<%=i%>' id='version_no<%=i%>' value='<%=rs.getString(6)%>'>
<input type ='hidden' name='lib_short_desc<%=i%>' id='lib_short_desc<%=i%>' value='<%=rs.getString(7)%>'>
	
	</td>
	<td class='<%=classValue%>' width='25%' height='1' align='left' <%=read_only%>><font size="1"><%out.println(rs.getString(8));%></FONT>
				
	</td>
	<td class='<%=classValue%>' width='20%' height='1'><font size="1" color=""> 
	<B><%out.println(rs.getString(4));%></B></font>			
	</td>
	<td class='<%=classValue%>' width='3%' height='1' align='center'>
	 <input type="checkbox" name='chk_library<%=i%>' id='chk_library<%=i%>' <%=disabled%> onClick='populateLibDetails1("<%=i%>")' <%=checked%>> </td>
	</tr>
<%
		i++;
	}	
	
	rs.close();
	ps.close();
%>
	<tr>
		<td colspan='4' height='' class='<%=classValue%>'>&nbsp;</td>
	</tr>
<input type ='hidden' name='i' id='i' value='<%=i%>'>
<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
</table>

<%
	}
if(Library.equals("EntireLibrary") && !show_diag.equals("showall")){
	
	patient_id			= bean.getPatientId();
	String library_id	="",tmp_library_id="",library_desc="",version_no="",tmp_version_no="";
	String termsetid	= "";
	String termcode		= "";
	String record1		= "";
	String chk_tid="",chk_tid1="";String sql_query="";
	String recordKey = "";

	codeKeyValue = bean.getLimitLib();
	Set s=codeKeyValue.keySet();
	Collection ct = codeKeyValue.values();
	
	Object[] record =  s.toArray();
	for(int c=0;c<record.length;c++){
		record1 = record[c].toString();
	}
	
	StringTokenizer stk=new StringTokenizer(record1,",");
	while(stk.hasMoreTokens()){
		chk_tid = stk.nextToken();
		if(!chk_tid1.equals(chk_tid)){
			recordKey = recordKey +""+chk_tid+"";
			termsetid =termsetid +"'"+chk_tid+"',";
			chk_tid1=chk_tid;
		}
	}
	if(termsetid.length()>0)
		termsetid = termsetid.substring(0,termsetid.length()-1);
	else
		termsetid ="''";
	record =  ct.toArray();
	for(int c=0;c<record.length;c++){
		record1 = record[c].toString();
	}
	
	String sel_diags = "";
	sel_diags = bean.getDiags();
	if(!sel_diags.equals("")){
	sel_diags = sel_diags.substring(0,sel_diags.length()-1);
	}else
		sel_diags = "('','')";

	StringTokenizer stk1=new StringTokenizer(record1,",");
	while(stk1.hasMoreTokens()){
		termcode =termcode +"'"+stk1.nextToken()+"',";
			
	}
	if(termcode.length()>0)
		termcode = termcode.substring(0,termcode.length()-1);
	else
		termcode = "''";

	codeKeyValue = bean.getDgCaseCode();
	s=codeKeyValue.keySet();
	record =  s.toArray();
	String case_code = "";
	for(int c=0;c<record.length;c++){
		
		record1 = record[c].toString();
		case_code = case_code +"'"+record1+"',"; 
	}

//	con = ConnectionManager.getConnection(request);
	if(case_code.length()>0){
		case_code = case_code.substring(0,case_code.length()-1);//to remove last ',' char

		//sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC ,'00' CATEG_CODE, 'CASE_TYPE' CATEG_DESC, A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE in (");
		sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC, B.VERSION_REMARKS GUIDELINE_DESC ,'00' CATEG_CODE, 'CASE_TYPE' CATEG_DESC, A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A ,CP_LIBRARY_LANG_VW B ,CP_CASE_TYPE_LANG_VW C WHERE A.CASE_TYPE_CODE in (");
		//sql.append(case_code);
		sql.append(case_code);
		//sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO  AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE ))) ");
		sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND B.LANGUAGE_ID = '");
		sql.append(locale);
		//IN072876 Start.
		//sql.append("' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND C.LANGUAGE_ID = B.LANGUAGE_ID AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO  AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE ))) ");
		sql.append("' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE AND C.LANGUAGE_ID = B.LANGUAGE_ID AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO  AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND ((TRUNC (SYSDATE) - IB.DATE_OF_BIRTH BETWEEN DECODE (IA.AGE_UNIT, 'D', IA.MIN_AGE, 'M', 30 * IA.MIN_AGE, 'Y', 365 * IA.MIN_AGE ) AND DECODE (IA.AGE_UNIT, 'D', IA.MAX_AGE, 'M', 30 * IA.MAX_AGE, 'Y', 365 * IA.MAX_AGE )) OR ((SYSDATE - IB.DATE_OF_BIRTH)*24 BETWEEN DECODE (IA.AGE_UNIT,'H', IA.MIN_AGE) AND DECODE (IA.AGE_UNIT,'H', IA.MAX_AGE ))))) ");
		//IN072876 End.
	}
	else{

		//sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC, A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE (A.TERM_SET_ID,A.TERM_CODE) IN (");
		sql.append("SELECT A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC, A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY_LANG_VW B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE (A.TERM_SET_ID,A.TERM_CODE) IN (");
		//sql.append(sel_diags);
		sql.append(sel_diags);
		//sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE )))  ORDER  BY 5,1,2");
		sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.LANGUAGE_ID ='");
		sql.append(locale);
		//IN072876 Start.
		//sql.append("' AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  		DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE )))  ORDER  BY 5,1,2");
		sql.append("' AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND ( NOT EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) OR EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY IC,AM_AGE_GROUP IA, MP_PATIENT IB  WHERE IC.LIBRARY_ID=A.LIBRARY_ID AND IC.VERSION_NO=A.VERSION_NO AND IA.AGE_GROUP_CODE=IC.AGE_GROUP_CODE AND  IB.PATIENT_ID= ? AND ((TRUNC (SYSDATE) - IB.DATE_OF_BIRTH BETWEEN DECODE (IA.AGE_UNIT, 'D', IA.MIN_AGE, 'M', 30 * IA.MIN_AGE, 'Y', 365 * IA.MIN_AGE ) AND DECODE (IA.AGE_UNIT, 'D', IA.MAX_AGE, 'M', 30 * IA.MAX_AGE, 'Y', 365 * IA.MAX_AGE )) OR ((SYSDATE - IB.DATE_OF_BIRTH)*24 BETWEEN DECODE (IA.AGE_UNIT,'H', IA.MIN_AGE) AND DECODE (IA.AGE_UNIT,'H', IA.MAX_AGE ))) ))  ORDER  BY 5,1,2");
		//IN072876 End.
	}
	
//	sql_query = "SELECT DISTINCT C.CASE_TYPE_CODE , C.SHORT_DESC CASE_TYPE_DESC, D.TERM_SET_DESC, E. SHORT_DESC TERM_DESC,B.TERM_SET_ID,B.TERM_CODE FROM PR_DIAGNOSIS A, CP_TERM_CODE_FOR_CASE_TYPE B, CP_CASE_TYPE C, MR_TERM_SET  D , MR_TERM_CODE E WHERE A.PATIENT_ID = ? AND  A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B') AND B.CASE_TYPE_CODE= ? AND B.TERM_SET_ID=A.TERM_SET_ID AND B.TERM_CODE  =A.TERM_CODE AND D.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_CODE  =B.TERM_CODE AND C.EFF_STATUS='E' AND C.CASE_TYPE_CODE=B.CASE_TYPE_CODE ORDER BY C.SHORT_DESC, D.TERM_SET_DESC, E. SHORT_DESC  ";
	sql_query = "SELECT DISTINCT C.CASE_TYPE_CODE , C.SHORT_DESC CASE_TYPE_DESC, D.TERM_SET_DESC, E. SHORT_DESC TERM_DESC,B.TERM_SET_ID,B.TERM_CODE FROM PR_DIAGNOSIS A, CP_TERM_CODE_FOR_CASE_TYPE B, CP_CASE_TYPE_LANG_VW C, MR_TERM_SET  D , MR_TERM_CODE E WHERE A.PATIENT_ID = ? AND  A.CURR_STATUS  ='A' AND EXISTS ( SELECT 1 FROM CP_PARAMETER WHERE ACCURACY_FOR_CARE_PLANS = A.CURR_ACCURACY_IND OR ACCURACY_FOR_CARE_PLANS ='B') AND B.CASE_TYPE_CODE= ? AND B.TERM_SET_ID=A.TERM_SET_ID AND B.TERM_CODE  =A.TERM_CODE AND D.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_SET_ID=B.TERM_SET_ID AND E.TERM_CODE  =B.TERM_CODE AND C.EFF_STATUS='E' AND C.CASE_TYPE_CODE=B.CASE_TYPE_CODE AND C.LANGUAGE_ID = ? ORDER BY C.SHORT_DESC, D.TERM_SET_DESC, E. SHORT_DESC  ";
	
	ps = con.prepareStatement(sql.toString());
	ps.setString(1, patient_class);
	ps.setString(2, patient_id);
	rs = ps.executeQuery();
	pstmt = con.prepareStatement(sql_query);

%>
	<table border='0' cellspacing='0' cellpadding='0' width='100%' align='center' >

<%String diag_desc="",diag_desc1="";int k=0,h=0,cs_cnt=1;
	while(rs.next())
	{	
		if ( i % 2 == 0 )
			classValue = "GRPEVEN" ;
		else
			classValue = "GRPOD" ;

		String temp_chk= "",temp_chk1="";String term_desc="";
		String version_desc="";String clkvalue="";
		String tmp_term_code ="";
		tmp_term_code = rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(5)+"~"+rs.getString(7)+"~";
		codeKeyValue = bean.getTermCode();
		
		temp_chk =(String)codeKeyValue.get(tmp_term_code)== null?"":(String)codeKeyValue.get(tmp_term_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "";
		if(rs.getString(5).equals("00")){	
		codeKeyValue = bean.getCaseCode();
		temp_chk1 =(String)codeKeyValue.get(rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(7))== null?"":(String)codeKeyValue.get(rs.getString(1)+"~"+rs.getString(2)+"~"+rs.getString(7));
		if(!temp_chk1.equals("") && temp_chk1.equals("Y"))
			checked = "checked";
		else
			checked = "";
		}
		library_id = rs.getString(1);
		version_no = rs.getString(2);

		if(!tmp_library_id.equals(library_id)){
			library_desc= rs.getString(3)+"&nbsp;(Version No:&nbsp;"+version_no+"&nbsp;)";
			tmp_version_no="";
		}else if(tmp_library_id.equals(library_id) && !tmp_version_no.equals(version_no))
			library_desc= rs.getString(3)+"&nbsp;(Version No:&nbsp;"+version_no+"&nbsp;)";
		else
			library_desc = "";
			
		if(!library_desc.equals("")){
			if(h>1){
%>
			<script>
				document.getElementById('chk_spanlib' + (<%= (i - 1) %>)).rowSpan = <%= h %>;
			</script>
<%
				}
%>
		<tr>
		<td class='<%=classValue%>' colspan='4' align='center'>&nbsp;</td>
		</tr>
<%
			h=0;
		}
		
		if(!tmp_version_no.equals(version_no)){
				if(k>0){k=i-1;
%>
	<script>
					eval("document.generate_libraires.term_code"+"<%=k%>").value = "<%=diag_desc%>";
	</script>	
<%
			}
			diag_desc="";k=0;
			diag_desc = rs.getString(7)+"|";
			version_desc= rs.getString(4);
				
		}
		else{
			version_desc =  "";k++;
			diag_desc =diag_desc+rs.getString(7)+"|";
		}
		tmp_library_id = library_id;
		tmp_version_no = version_no;
%>
		<tr>
		<td class='<%=classValue%>' width='20%' height='1' valign='top'><font size="1" color=""> 
		<b><%=library_desc%>&nbsp;</b></font></td>	
<%
	if(!version_desc.equals("")){
%>
<input type ='hidden' name='casetype_code<%=i%>' id='casetype_code<%=i%>' value='<%=rs.getString(5).equals("00")?rs.getString(7):""%>'>
<input type ='hidden' name='term_set_id<%=i%>' id='term_set_id<%=i%>' value='<%=rs.getString(5)%>'>	
<input type ='hidden' name='term_code<%=i%>' id='term_code<%=i%>' value='<%=rs.getString(7)==null?"":rs.getString(7)%>'>
<input type ='hidden' name='library_code<%=i%>' id='library_code<%=i%>' value='<%=rs.getString(1)%>'>
<input type ='hidden' name='version_no<%=i%>' id='version_no<%=i%>' value='<%=rs.getString(2)%>'>
<input type ='hidden' name='lib_short_desc<%=i%>' id='lib_short_desc<%=i%>' value='<%=rs.getString(3)%>'>
<%
	}		
%>
	<td class='<%=classValue%>' width='25%' height='1' valign='top'><font size="1" color=""><%=version_desc%>&nbsp;&nbsp;<!-- <%=rs.getString(2)%> --> </font>
	</td>
	<td class='<%=classValue%>' width='20%' height='1' valign='top'><font size="1" color=""> 
	<b><%=rs.getString(8)%></b></font>	
<%
		clkvalue="populateLibDetails1("+i+")";
		if(rs.getString(5).equals("00")){
		
		clkvalue="populateLibDetails("+i+")";
		

	pstmt.setString(1, patient_id);
	pstmt.setString(2, rs.getString(7));
	pstmt.setString(3,locale);
	rst = pstmt.executeQuery();
				
%>
		<table border='0' cellspacing='0' cellpadding='0' width='100%' align='center' >
<%
	if(!library_desc.equals("") && !version_desc.equals("")){
				diag_desc1="";term_desc = "";cs_cnt=1;
		 }
			while(rst.next()){
			
				k=0;
				term_desc = rst.getString(5);
				diag_desc1 =diag_desc1 + rst.getString(6)+"|";
						
			%>
		<tr>
		<td width='30%' class='<%=classValue%>'>&nbsp;<td>
		<td width='70%' class='<%=classValue%>'><font size="1" color="navy"><b><%=rst.getString(4)%></b></font><td>
		<tr>
<%
		}
		rst.close();
		pstmt.close();

		if(library_desc.equals("") && version_desc.equals("")){
%>
	<script>
		eval("document.generate_libraires.term_code"+"<%=(i-cs_cnt)%>").value = "<%=diag_desc1%>";
	</script>	
<%			
		cs_cnt++;
		}else{
%>
		<script>
			eval("document.generate_libraires.term_set_id"+"<%=i%>").value = "<%=term_desc%>";
			eval("document.generate_libraires.term_code"+"<%=i%>").value = "<%=diag_desc1%>";
		</script>
<%
		}
%>
		</table>
<%
	}
%>
	</td>
<%
	if(!version_desc.equals("")){
%>
	<td class='<%=classValue%>' width='3%' height='1' align='center' id='chk_spanlib<%=i%>'>		
	<input type="checkbox" name='chk_library<%=i%>' id='chk_library<%=i%>'onClick='<%=clkvalue%>' <%=checked%>>
	 </td>
<%
		i++; 
	}
%> 
	</tr>

<%
	h++;	
	}	

	rs.close();
	ps.close();

	if(h>1){
%>
		<script>
			document.getElementById('chk_spanlib' + (<%= (i - 1) %>)).rowSpan = <%= h %>;
		</script>
<%
	}
	
%>
	<tr>
	<td class='GRPEVEN' colspan='4' align='center'>&nbsp;</td>
	</tr> 
<input type ='hidden' name='i' id='i' value='<%=i%>'>
<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
<input type ='hidden' name='encounterId'  id='encounterId' value='<%=encounterId%>'><!-- 60772 -->

</table>
<script>
checkExistingDiags();
</script>

<%	
	}
if(show_diag.equals("showall")){
	
	int j=0;
	codeKeyValue = bean.getLimitLib();
	Set ss=codeKeyValue.keySet();
	Object[] record =  ss.toArray();
	if(record.length>0){
		term_set_id = record[0].toString();
		term_code = (String)codeKeyValue.get(term_set_id);
	}
	
	StringTokenizer stk=new StringTokenizer(term_set_id,",");
	term_set_id="";
	while(stk.hasMoreTokens()){
		term_set_id = term_set_id +"'"+stk.nextToken()+"',";
	}
	StringTokenizer stk1=new StringTokenizer(term_code,",");
	term_code="";
	while(stk1.hasMoreTokens()){
		term_code = term_code +"'"+stk1.nextToken()+"',";
	}
	if(term_set_id.length()>0)
		term_set_id = term_set_id.substring(0,term_set_id.length()-1);
	else
		term_set_id="''";
	if(term_code.length()>0)
		term_code = term_code.substring(0,term_code.length()-1);
	else
		term_code="''";

	case_type_code = "''";	
//	con = ConnectionManager.getConnection(request);
	/*sql.append("SELECT TO_CHAR(NULL) CASE_TYPE_CODE ,TO_CHAR(NULL) CASE_TYPE_DESC ,A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE A.TERM_SET_ID IN(");
	sql.append(term_set_id);
	sql.append(") AND A.TERM_CODE IN(");
	sql.append(term_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID  AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) UNION ALL SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,TO_CHAR(NULL) TERM_SET_ID ,TO_CHAR(NULL) TERM_SET_DESC ,TO_CHAR(NULL) TERM_CODE ,TO_CHAR(NULL) TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE IN(");
	sql.append(case_type_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE  AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO) ORDER BY TERM_CODE");
	*/
	sql.append("SELECT TO_CHAR(NULL) CASE_TYPE_CODE ,TO_CHAR(NULL) CASE_TYPE_DESC ,A.TERM_SET_ID ,C.TERM_SET_DESC ,A.TERM_CODE ,D.SHORT_DESC TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_LIBRARY_TERM_CODE A ,CP_LIBRARY_LANG_VW B ,MR_TERM_SET C ,MR_TERM_CODE D WHERE B.LANGUAGE_ID = '");
	sql.append(locale);
	sql.append("' AND A.TERM_SET_ID IN(");
	sql.append(term_set_id);
	sql.append(") AND A.TERM_CODE IN(");
	sql.append(term_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID  AND B.EFF_STATUS='E' AND C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE  =A.TERM_CODE AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO ) UNION ALL SELECT A.CASE_TYPE_CODE ,C.SHORT_DESC CASE_TYPE_DESC ,TO_CHAR(NULL) TERM_SET_ID ,TO_CHAR(NULL) TERM_SET_DESC ,TO_CHAR(NULL) TERM_CODE ,TO_CHAR(NULL) TERM_SHORT_DESC ,A.LIBRARY_ID ,A.VERSION_NO ,B.SHORT_DESC LIBRARY_DESC ,B.VERSION_REMARKS GUIDELINE_DESC FROM CP_CASE_TYPE_FOR_LIBRARY A,CP_LIBRARY B ,CP_CASE_TYPE C WHERE A.CASE_TYPE_CODE IN(");
	sql.append(case_type_code);
	sql.append(") AND B.LIBRARY_ID=A.LIBRARY_ID AND B.VERSION_NO=A.VERSION_NO AND B.EFF_STATUS='E' AND C.CASE_TYPE_CODE  =A.CASE_TYPE_CODE  AND EXISTS (SELECT 1 FROM CP_PAT_CLASS_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO AND PATIENT_CLASS= ? ) AND EXISTS (SELECT 1 FROM CP_AGE_GRP_FOR_LIBRARY WHERE LIBRARY_ID=A.LIBRARY_ID AND VERSION_NO=A.VERSION_NO) ORDER BY TERM_CODE");
	

	ps = con.prepareStatement(sql.toString());
	ps.setString(1, patient_class);
	ps.setString(2, patient_class);
	rs = ps.executeQuery();

%>
	<table border='1' cellspacing='0' cellpadding='0' width='100%' align='center'>
<tr>
<%
	while(rs.next())
	{	
		
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		
		if(rs.getString(3)!= null){
		String tmp_term_code ="";
		tmp_term_code = rs.getString(7)+"~"+rs.getString(8)+"~"+rs.getString(3)+"~"+rs.getString(5)+"~";
		codeKeyValue = bean.getTermCode();
		String temp_chk= "";
		//Set s=codeKeyValue.keySet();
		temp_chk =(String)codeKeyValue.get(tmp_term_code)== null?"":(String)codeKeyValue.get(tmp_term_code);
		if(!temp_chk.equals("") && temp_chk.equals("Y"))
			checked = "checked";
		else
			checked = "";
		}
		if(rs.getString(1)!= null){
			codeKeyValue = bean.getCaseCode();
			case_type_code = rs.getString(1);
			String temp_chk= "";
			temp_chk =(String)codeKeyValue.get(case_type_code)== null?"":(String)codeKeyValue.get(case_type_code);
			if(!temp_chk.equals("") && temp_chk.equals("Y"))
				checked = "checked";
			else
				checked = "";
		}
		term_code = rs.getString(5);
		if(!term_code.equals(term_code1)){
%>
			
			<td colspan='5' class='CAGROUPHEADING' height='1%'><font size="1" >&nbsp;<%out.println(rs.getString(6)==null?rs.getString(2):rs.getString(6));%></font></td>
			</tr>
			<tr>
				<th colspan='' height='1'><font size="1"><fmt:message key="eCP.LibraryDescription.label" bundle="${cp_labels}"/></font></th>
				<th colspan='' height='1'><font size="1"><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></font></th>
				<th colspan='' height='1'><font size="1"><fmt:message key="eCP.Guideline.label" bundle="${cp_labels}"/></font></th>
				<th colspan='' height='1'><font size="1"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></font></th>
			</tr>
			<tr>
			<input type ='hidden' name='i<%=j%>' id='i<%=j%>' value='<%=i%>'>
			<%//out.println("<script>alert('i::"+i+"-j::"+j+"--')</script>");
			i=0;
			term_code1=term_code; j++;		
		}
%>
		<td class='<%=classValue%>' width='25%' height='1'><font size="1" color=""> 
		<%out.println(rs.getString(9));%></font></td>	
<input type ='hidden' name='casetype_code<%=i%><%=j%>' id='casetype_code<%=i%><%=j%>' value='<%=rs.getString(1)==null?"":rs.getString(1)%>'>
<input type ='hidden' name='term_set_id<%=i%><%=j%>' id='term_set_id<%=i%><%=j%>' value='<%=rs.getString(3)==null?"":rs.getString(3)%>'>	
<input type ='hidden' name='term_code<%=i%><%=j%>' id='term_code<%=i%><%=j%>' value='<%=rs.getString(5)==null?"":rs.getString(5)%>'>
<input type ='hidden' name='library_code<%=i%><%=j%>' id='library_code<%=i%><%=j%>' value='<%=rs.getString(7)%>'>
<input type ='hidden' name='version_no<%=i%><%=j%>' id='version_no<%=i%><%=j%>' value='<%=rs.getString(8)%>'>
<input type ='hidden' name='lib_short_desc<%=i%><%=j%>' id='lib_short_desc<%=i%><%=j%>' value='<%=rs.getString(9)%>'>
	
	<td class='<%=classValue%>' width='10%' height='1'><font size="1" color=""> 
	<%out.println(rs.getString(8));%></font>			
	</td>
	<td class='<%=classValue%>' width='40%' height='1' align='center'>
	<textarea name="" rows="3" cols="60"><%out.println(rs.getString(10));%></textarea>
	</td>
	<td class='<%=classValue%>' width='5%' height='1' align='center'>
	<input type="checkbox" name='chk_library<%=i%><%=j%>' id='chk_library<%=i%><%=j%>' onClick='populateLibDetails2("<%=i%>","<%=j%>")' <%=checked%> ></td>
	</tr>
	
<%
		i++;
	}	

	rs.close();
	ps.close();
%>
<input type ='hidden' name='i<%=j%>' id='i<%=j%>' value='<%=i%>'>
<input type ='hidden' name='j' id='j' value='<%=j%>'>
<input type ='hidden' name='i' id='i' value='<%=i%>'>
<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
</table>
<%	
	}
	if(i==0){out.println("<script>alert(getMessage('NO_STD_CP_AVAIL','CP'))</script>");	
%>
<table border='0' cellspacing='0' cellpadding='0' width='100%'  align='center'>
<tr>
	<td colspan='2' height='1' align='center' class='GRPEVEN'><font size="1"><b> <fmt:message key="eCP.NoStandardCarePlanAvailable.label" bundle="${cp_labels}"/></b></font></td>
	<!-- <th colspan='4'>Library</th> -->
</tr>
<tr>
	<td colspan='' height='1'align='left' width='97%'  class='GRPEVEN'><font size="1" >
		<%if(!term_code_desc.equals(""))
			 out.println(term_code_desc);
		  else if(!casetype_desc.equals(""))
			 out.println(casetype_desc);%>&nbsp;</font>
	</td>
	<td colspan='' height='1' align='right'  class='GRPEVEN'><%if(!term_code_desc.equals("") || !casetype_desc.equals("") ){%><input type="checkbox" name="" id=""><%}else{%>&nbsp;<%}%>
	</td>
</tr> 
</table>	
<input type ='hidden' name='i' id='i' value='<%=i%>'>
<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
<input type ='hidden' name='encounterId'  id='encounterId' value='<%=encounterId%>'><!-- 60772 -->
<%}
}
catch(Exception ee)
{
	out.println("Exception while populating the values of case type r diagnosis Module "+ee.toString());
	System.out.println("Exception while populating the values of case type r diagnosis Module "+ee.toString());
	ee.printStackTrace();
}
finally
{
	try{
			if(rs != null) rs.close();
			if(rst != null) rst.close();
			if(ps != null) ps.close();
			if(pstmt != null) pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
		}
}

%>
</form>
</body>
</html>

