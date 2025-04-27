<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Modified 9/16/2005 -->
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<jsp:useBean id="TerminologyLookup" scope="session" class="webbeans.eCommon.RecordSet" />
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="JavaScript" src="../js/NewProcedure.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		
	String mode	   = request.getParameter( "mode" ) ;
	//String proc_code = request.getParameter("note_type")==null?"":request.getParameter("note_type") ;
	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set") ;
	String term_code_associated = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated") ;
	//String level1 = request.getParameter("level")==null?"":request.getParameter("level") ;
	String radioval = request.getParameter("radioval")==null?"G":request.getParameter("radioval") ;

		
	String classvalue="";//String checked = "";
	//int db_count=0;
	String temp_term_code="";
	//String tag = "",tag1="";
	//out.println("=request.getQueryString()=="+request.getQueryString()+"=====");	
	//String temp_db_chk = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy H:mm" ) ;
	String	currentdate			= dateFormat.format(new java.util.Date()) ;
	//String	onset_date			= currentdate;
	//out.println("=term_code_associated============"+term_code_associated+"====");
	StringTokenizer stoken=new StringTokenizer(term_code_associated,"`");
	int cnt=stoken.countTokens();
//out.println("=cnt============"+cnt+"====");
	StringBuffer sql1= new StringBuffer();
	Connection con      = null;
	PreparedStatement pstmt	= null;
	ResultSet rset		= null;
try
{
	con = ConnectionManager.getConnection(request);
	
	//sql1.append("SELECT TERM_SET_ID,TERM_GROUP_ID,TERM_GROUP_DESC FROM MR_TERM_GROUP_HDR WHERE  EFF_STATUS = 'E' AND TERM_SET_ID LIKE NVL(?,TERM_SET_ID) AND TERM_GROUP_APPLICABLITY ='P' ORDER BY 1,2");
	
	sql1.append("SELECT a.term_set_id TERM_SET_ID,a. term_group_id term_group_id,a. term_group_desc, b.term_code term_code,d.short_desc term_code_description, d.code_level code_level,DECODE (d.code_level,'1', level_1_desc,'2', level_2_desc,'3', level_3_desc,'4', level_4_desc,'5', level_5_desc,'6', level_6_desc,'7', level_7_desc,  '8', level_8_desc,'9', level_9_desc,'10', level_10_desc) code_level_desc, c.term_set_desc term_set_desc,c.term_set_id term_set_id FROM mr_term_group_hdr a, mr_term_group_dtl b, mr_term_set c, mr_term_code d WHERE a.eff_status = 'E' AND a.term_set_id LIKE NVL (?, a.term_set_id) AND a.term_group_applicablity = 'P' AND b.term_set_id = c.term_set_id AND c.term_set_id = d.term_set_id AND b.term_code = d.term_code AND b.term_group_id = a.term_group_id AND b.term_set_id = a.term_set_id ORDER BY 1,2,3");
	
%>

<form name='multi_procedure' id='multi_procedure' method='post' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0 border=1 width="100%" align=center id='term_associated'>
<tr>
	<td class=columnheader width='80%'>Procedure</td>
	<td class=columnheader width='20%'>Select</td>
</tr>
<% //String term_assc_temp = "";
String term_code="",level="",level_code_desc="",term_code_desc=""; 

if(radioval.equals("C"))
cnt =1;
//out.println("===="+radioval+"===");
if(cnt > 0){
//for(int i=0;i<cnt;i++)
//	{
	//out.println("<script>alert('=tag=="+tag+"==tag1=="+tag1+"==db_count="+db_count+"==i="+i+"==')</script>"
	//	out.println("<script>alert('checked ="+checked+" &&  i="+i+"')</script>");
		/*if(stoken.hasMoreTokens()){
				term_assc_temp=stoken.nextToken();
				StringTokenizer token= new StringTokenizer(term_assc_temp,"~");
				term_code=token.nextToken();
				level=token.nextToken();
				level_code_desc=token.nextToken();
				term_code_desc=token.nextToken();
				temp_term_code +=term_code+"~";
				if(level.equals(""))
					level = "0";
		}*/
	ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
	cnt = TerminologyLookup.getSize();
	HashMap Termcode= new HashMap();
	//TerminologyLookup.clearAll();
	//out.println("--Termcode-size-"+Terminology.size()+"====");
	if(Terminology.size()>0)
	{
		//Termcode=(HashMap)Terminology.get(0);
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		//while(Terminology.size() >1){
		//	TerminologyLookup.removeObject(1);
		//}
		//out.println("--Termcode-s-"+TerminologyLookup.getSize()+"====");
	}
		int i=0;
		Set itr_set			=	Termcode.keySet();
		//out.println("--Termcode--"+Termcode.size()+"====");
		Iterator recordItr	=	itr_set.iterator();
		while(recordItr.hasNext()){
			String grpid1="";
			grpid1=(String)recordItr.next();
			//out.println("--value--"+((grpid1))+"====");
			
			if((Termcode.get(grpid1)) != null && (Termcode.get(grpid1)).equals("Y") && (grpid1.indexOf("|")) != -1 ){
			
				StringTokenizer token= new StringTokenizer(grpid1,"|");
				term_code=token.nextToken();
				term_code_desc=token.nextToken();
			
				//out.println("--term_code--"+term_code+"===-term_code_desc--"+term_code_desc+"====");
				level="";
				level_code_desc="";
				
			
	if ( i % 2 == 0 )
		classvalue = "QRYEVEN" ;
	else
		classvalue = "QRYODD" ;
	
	
	%>
	
<tr>
	<td class='<%=classvalue%>' align=''><font size="1"><a href="javascript:showTermDetails('<%=i%>')"><%=term_code_desc%></a></font></td>
	<td class='<%=classvalue%>' align='center'>  
	<input type="checkbox" name="multi_proc_chk<%=i%>" id="multi_proc_chk<%=i%>" checked>
	</td>
</tr>
		<input type="hidden" name="termset_id<%=i%>" id="termset_id<%=i%>" value="<%//=tmp_setid%>">		
		<input type="hidden" name="term_code<%=i%>" id="term_code<%=i%>" value="<%=term_code%>">
		<input type="hidden" name="code_level<%=i%>" id="code_level<%=i%>" value="<%=level%>">
		<input type="hidden" name="termdetails<%=i%>" id="termdetails<%=i%>" value="">
		
			<!--<script>alert(document.forms[0].all.term_codeS<%=i%>.value)</script> -->
<% i++;
			}
			
		}
//}
}else{
	int i=0;
	cnt = TerminologyLookup.getSize();
	ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
	HashMap Termcode= new HashMap();
	String tmp_grpdesc = "",tmp_grpid="",tmp_setid="",chk_val="";
	//TerminologyLookup.clearAll();
	if(Terminology.size()>0)
	{
		//Termcode=(HashMap)Terminology.get(0);
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		while(Terminology.size() >1){
			TerminologyLookup.removeObject(1);
		}
		out.println("--Termgrpcode-s-"+TerminologyLookup.getSize()+"====");
	}
	//if(sql1.length() > 0) sql1.delete(0,sql1.length());
	//sql1.append(" ");
    try
	{
		pstmt =con.prepareStatement(sql1.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,"");
		rset=pstmt.executeQuery();
		String tmp_head ="",tmp_grpdesc1="",tmp_setdesc="",tmp_desc="";
		while(rset!=null && rset.next())
		{
			tmp_setid = rset.getString(1);
			tmp_grpid = rset.getString(2);
			tmp_grpdesc = rset.getString(3);
			tmp_desc	=rset.getString(5);
			tmp_setdesc =rset.getString(8);
			if(Termcode.containsKey(tmp_setid+tmp_grpid)){
				chk_val = (String)Termcode.get(tmp_setid+tmp_grpid);
				//out.println("==in=="+(String)Termcode.get(tmp_setid+tmp_grpid));
				if(chk_val != null && chk_val.equals("Y")){
					
					if ( i % 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
					if(!tmp_head.equals(tmp_setid)){
						tmp_head = tmp_setid;   
		%>
		<tr>
			<td class='CAHIGHER' align='' colspan='2'><font size="1"><b><%=tmp_setdesc%></b></font></td>
			<!-- <td class='CAHIGHER' align=''>
			</td> -->
		</tr>	
				<%}if(!tmp_grpdesc1.equals(tmp_grpdesc)){
						tmp_grpdesc1 = tmp_grpdesc;   
		%>
		<tr>
			<td class='CAHIGHER' align='' colspan='2'><font size="1"><%=tmp_grpdesc%></font></td>
			<!-- <td class='CAHIGHER' align=''></td> -->
		</tr>	
				<%}%>
		<tr>
			<td class='<%=classvalue%>' align=''><font size="1"><a href="javascript:showTermDetails('<%=i%>')"><%=tmp_desc%></a></font></td>
			<td class='<%=classvalue%>' align='center'>  
			<input type="checkbox" name="multi_proc_chk<%=i%>" id="multi_proc_chk<%=i%>" checked>
			</td>
		</tr>
			<input type="hidden" name="termset_id<%=i%>" id="termset_id<%=i%>" value="<%=tmp_setid%>">
			<input type="hidden" name="termgrp_id<%=i%>" id="termgrp_id<%=i%>" value="<%=tmp_grpid%>">
			<input type="hidden" name="termdetails<%=i%>" id="termdetails<%=i%>" value="">
		<% 
			i++;
				}
			}			

			

			
		}
		
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		
		
	}catch(Exception e){
		System.out.println("Exception "+e.toString());
		e.printStackTrace();
	}
	
}
%>
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=cnt%>">
<input type="hidden" name="term_set_id" id="term_set_id" value="<%=term_set%>">
<input type="hidden" name="temp_term_code" id="temp_term_code" value="<%=temp_term_code%>">
<input type="hidden" name="term_code_associated" id="term_code_associated" value="<%=term_code_associated%>">
<input type="hidden" name="radioval" id="radioval" value="<%=radioval%>">
<input type="hidden" name="currentdate" id="currentdate" value ="<%=currentdate%>">

<%

} 
catch(Exception e)
{
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>

</form>

</body>
</html>

