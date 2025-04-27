<!DOCTYPE html>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	webbeans.eCommon.RecordSet respRelnRecSet = (webbeans.eCommon.RecordSet)getObjectFromBean("respRelnRecSet","webbeans.eCommon.RecordSet",session);
%>

<%!int row_count=0;%>
<html>
<head>
<title> <fmt:message key="eCA.TaskForResponsibilityRelationship.label" bundle="${ca_labels}"/></title>
<%request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/TaskForResp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
Connection con			= null;
PreparedStatement pstmt = null,pstmt1=null;
ResultSet rs			= null,rs1=null;
HashMap hMapRecords		= null; 

int row_disp=14;
int start = 0 ;
int end = 0 ;
int fm_disp=0, to_disp=0;

String title_desc="",title_desc1="",  sql_query="", code="", desc="", classValue="";
String update_val ="", valid="", associate="";
String function_id="",function_name="";
String insUpd="",  srl_no="", privilege_status="",selectOption1 ="";
String selectOption2 ="", privilege_status_value = "";
String prevVal = "" ;
String access_rigths_appl ="",access="",accessOption1="",accessOption2="",accessOption3=""; //removed access_for_all,access_applicable for checkstyle
String amend_order="",cancel_order="",discontinue="",hold="";
String not_done = ""; //IN061903

String dispMode		=	request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
String from			=	request.getParameter( "from" )==null?"1": request.getParameter( "from" );
String to				=	request.getParameter( "to" )==null?String.valueOf(row_disp): request.getParameter( "to" );
String group_by = request.getParameter("group_by")==null?"":request.getParameter("group_by");
String grp_by_code = request.getParameter("grp_by_code")==null?"":request.getParameter("grp_by_code");
String dtl_grp_by_code = request.getParameter("dtl_grp_by_code")==null?"":request.getParameter("dtl_grp_by_code");
//HashMap<String,String> accessMap = new HashMap<String,String>(); //commented for checkstyle
start = Integer.parseInt( from ) ;
end = Integer.parseInt( to ) ;

try {
	con = ConnectionManager.getConnection(request);
	//IN061903 start
	//sql_query = "select APPL_TASK_ID ,ACCESS_RIGTHS_APPL from CA_APPL_TASK where APPL_TASK_ID IN ('AMEND_ORDER','CANCEL_ORDER','DISCONTINUE','HOLD')";
	sql_query = "select APPL_TASK_ID ,ACCESS_RIGTHS_APPL from CA_APPL_TASK where APPL_TASK_ID IN ('AMEND_ORDER','CANCEL_ORDER','DISCONTINUE','HOLD','NOTDONE')";
	//IN061903 ends
	pstmt = con.prepareStatement(sql_query);
	rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("APPL_TASK_ID").equals("AMEND_ORDER"))
				amend_order=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			else if(rs.getString("APPL_TASK_ID").equals("CANCEL_ORDER"))
				cancel_order=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			else if(rs.getString("APPL_TASK_ID").equals("DISCONTINUE"))
				discontinue=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			else if(rs.getString("APPL_TASK_ID").equals("HOLD"))
				hold=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			//IN061903 start
			else if(rs.getString("APPL_TASK_ID").equals("NOTDONE"))
				not_done=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			//IN061903 ends

			//accessMap.put( rs.getString("APPL_TASK_ID"), rs.getString("ACCESS_RIGTHS_APPL"));			
		}
		
	if(rs!=null) rs.close();	
	if(pstmt!=null) pstmt.close();
if(group_by.equals("TS")){
	if(dtl_grp_by_code.equals("DRS")){
		title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");

		sql_query = "select a.resp_name description, a.resp_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1)ACCESS_RIGTHS_APPL from  sm_resp a where a.eff_status='E' order by upper(a.resp_name)";
	}
	else if(dtl_grp_by_code.equals("DRL")){
		title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels");

		sql_query = "select a.pract_reln_name description, a.pract_reln_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and 	b.appl_task_id=?)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and b.appl_task_id=?) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and b.appl_task_id=?)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and b.appl_task_id=? and rownum=1)ACCESS_RIGTHS_APPL from  ca_pract_reln a order by upper(a.pract_reln_name)";
	}
}// TS
else if(group_by.equals("RS") )
{
	title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Task.label","common_labels");
	title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

	if(dtl_grp_by_code.equals("DT"))
	{
		title_desc1="";
        sql_query="select a.appl_task_desc description, a.appl_task_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.RESP_ID=? and rownum=1)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.resp_id =? and rownum=1) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.resp_id = ? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.RESP_ID=? and rownum=1)ACCESS_RIGTHS_APPL from ca_appl_task a where a.splty_spec_yn = 'N' order by upper(a.appl_task_desc)";  
		
	}// DT
	else if(dtl_grp_by_code.equals("DFN"))
		{
		   title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

		   sql_query ="select nvl(a.OPTION_ID,'*NONE') function_id, nvl(a.SHORT_DESc,'NOT FUNC SPEC') function_name, c.APPL_TASK_ID code,c.APPL_TASK_DESC description,(select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)privilege_status,(select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)srl_no,(select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)ACCESS_RIGTHS_APPL from ca_option a,ca_appl_task c where a.option_id(+)= c.option_id order by function_name,c.APPL_TASK_DESC ";
		   
 
		}//DFN
}// RS
else if(group_by.equals("RL")){
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Task.label","common_labels");
	title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");
if(dtl_grp_by_code.equals("DT"))
	{
		title_desc1="";
	sql_query = "select a.appl_task_desc description, a.appl_task_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id=?)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id=?) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id = ?)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id=?) ACCESS_RIGTHS_APPL from ca_appl_task a where a.splty_spec_yn = 'N'  order by upper(a.appl_task_desc)";
	}
	else if(dtl_grp_by_code.equals("DFN"))
		{
		   title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

sql_query ="select nvl(a.OPTION_ID,'*NONE') function_id, nvl(a.SHORT_DESc,'NOT FUNC SPEC')function_name, c.APPL_TASK_ID code,c.APPL_TASK_DESC description,(select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.pract_reln_id=? and rownum=1) privilege_status,(select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id  = c.appl_task_id and b.pract_reln_id=? and rownum=1)srl_no,(select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and  b.pract_reln_id=? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.pract_reln_id=? and rownum=1)ACCESS_RIGTHS_APPL from ca_option a,ca_appl_task c  where a.option_id(+)= c.option_id order by function_name,c.APPL_TASK_DESC ";
}

}else{
	title_desc = "";
}

try{

	if(dispMode.equals("")){
		respRelnRecSet.clearAll();
		pstmt = con.prepareStatement(sql_query);
		pstmt.setString(1,grp_by_code);
		pstmt.setString(2,grp_by_code);
		pstmt.setString(3,grp_by_code);
		pstmt.setString(4,grp_by_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			code				= rs.getString("code");
			desc				= rs.getString("description");
			privilege_status	= rs.getString("privilege_status");
			valid				= rs.getString("valid");
			srl_no				= rs.getString("srl_no");
			access_rigths_appl	= rs.getString("ACCESS_RIGTHS_APPL");//This line added by Channaveer B for for crf MO-CRF-33
	if((group_by.equals("RS") && dtl_grp_by_code.equals("DFN"))||(group_by.equals("RL") && dtl_grp_by_code.equals("DFN")))
			{
				function_id=rs.getString("function_id");
				function_name=rs.getString("function_name");
			}
			if(code == null || code.equals("null"))code="";
			if(desc == null || desc.equals("null"))desc="";
			if(privilege_status == null|| privilege_status.equals("null"))privilege_status="";
			if(valid == null || valid.equals("") || valid.equals("null"))valid="N";
			if(srl_no == null || srl_no.equals("") || srl_no.equals("null"))srl_no="";
			HashMap hMapRecs = new HashMap();
			hMapRecs.put("code"				, code);
			hMapRecs.put("desc"				, desc);
			hMapRecs.put("privilege_status"	, privilege_status);
			hMapRecs.put("associate"		, "N");
			hMapRecs.put("valid"			, valid);
			hMapRecs.put("srl_no"			, srl_no);
			hMapRecs.put("insUpd"			, "");
			hMapRecs.put("ACCESS_RIGTHS_APPL" , access_rigths_appl);/*This line added by Channaveer B for crf MO-CRF-33*/
		

	if((group_by.equals("RS") && dtl_grp_by_code.equals("DFN"))||(group_by.equals("RL") && dtl_grp_by_code.equals("DFN")))
			{
				hMapRecs.put("function_id",function_id);
				hMapRecs.put("function_name",function_name);
			}
		respRelnRecSet.putObject(hMapRecs);
		}

		row_count	=	respRelnRecSet.getSize();
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		%>
		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");	
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}// if dispmode
		else{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			title_desc	= title_desc;
			
		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			title_desc	= title_desc;
		}
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		String valid_rec = "";
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j)==null?"":request.getParameter("select_yn"+j);
			access = request.getParameter("access_rights"+j)==null?"":request.getParameter("access_rights"+j);/*this line added by Channaveer B for crf MO-CRF-33*/
			HashMap hMapAlter = (java.util.HashMap)respRelnRecSet.getObject(j);
			valid_rec = (String)hMapAlter.get("valid");
			if(valid_rec.equals("Y")) insUpd = "U" ;
				else if(valid_rec.equals("N")) insUpd = "I";
			if(valid_rec.equals("Y")){
				hMapAlter.put("privilege_status", update_val);
				hMapAlter.put("associate"	  , "Y");
				hMapAlter.put("insUpd"		  , insUpd);
				hMapAlter.put("ACCESS_RIGTHS_APPL" , access);//this line added by Channaveer B for crf MO-CRF-33
				respRelnRecSet.setObject(j, hMapAlter);
			}else if(valid_rec.equals("N")){
				if(!update_val.equals("")) {
					hMapAlter.put("privilege_status", update_val);
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , insUpd);
					hMapAlter.put("ACCESS_RIGTHS_APPL"  , access);/*this line added by Channaveer B for crf MO-CRF-33 */
					respRelnRecSet.setObject(j, hMapAlter);
				}else{
					if(update_val.equals("")){
						hMapAlter.put("privilege_status", update_val);
						hMapAlter.put("associate"	  , "N");
						hMapAlter.put("insUpd"		  , "");
						hMapAlter.put("ACCESS_RIGTHS_APPL" , access);/*this line added by Channaveer B for crf MO-CRF-33 */
						respRelnRecSet.setObject(j, hMapAlter);
					}
				}
			}
		}

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}

	putObjectInBean("respRelnRecSet",respRelnRecSet,session);
%>
<body onLoad="" class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='formTaskRespRelnResult' id='formTaskRespRelnResult'>
	<table cellpadding='3' cellspacing='0' border='0' width='85%' align='center'>
<tr  width='10%'>
<td class='white' width='89%'></td>
<%
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		
		<td width='6%' class='label'>
		<A class='gridLink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		</td>
	<%	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<td width='6%' class = 'label'><A class='gridLink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
%>
</tr>
</table> 
<div style="display: flex; justify-content: center;">
<table class='grid' width='90%' align='center'>
	<% if(title_desc1.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels")))
	{
	%>
		<td class='COLUMNHEADERCENTER' width='30%' ><%=title_desc1%></td>
		<% } %>
<td class='COLUMNHEADERCENTER' width='50%'><%=title_desc%></td>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></td>
<%
//IN061903 start
//if((group_by.equals("TS")&& (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE")))|| group_by.equals("RS") || group_by.equals("RL")){
if((group_by.equals("TS")&& (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE") || grp_by_code.equals("NOTDONE")))|| group_by.equals("RS") || group_by.equals("RL")){
//IN061903 ends	
%>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="eCA.AccessRestriction.label" bundle="${ca_labels}"/></td>
<%}else{%>
	<!-- <td class='COLUMNHEADERCENTER' width='25%'></td> -->
<%}%>
<%
	for(int i=fm_disp; i<=to_disp; i++){
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		 hMapRecords   = (java.util.HashMap)respRelnRecSet.getObject(i);
		code				=	(String)	hMapRecords.get("code");
		//out.println("code"+code);
		desc				=	(String)	hMapRecords.get("desc");
		privilege_status	=	(String)	hMapRecords.get("privilege_status");
		associate			=	(String)	hMapRecords.get("associate");
		access			=	hMapRecords.get("ACCESS_RIGTHS_APPL")==null?"":(String)	hMapRecords.get("ACCESS_RIGTHS_APPL");/*this line added by Channaveer B for crf MO-CRF-33*/
		function_id=(String)hMapRecords.get("function_id");
		function_name=(String)hMapRecords.get("function_name");
		if(function_id == null || function_id.equals("")) function_id="";
		if(function_name == null || function_name.equals("")) function_name="";
		/*if(code.equals("BY_LOCATION"))
			{
				out.println("Priv Sts="+privilege_status);
				out.println("Valid="+valid);
			}*/
		 //boolean sts=false;
		if(prevVal.equals(function_name.trim()))
		{
           //sts=true;
		   function_name="&nbsp;";
		}
		else{
         prevVal=function_name;
		 //sts=false;
		}
		/*out.println("function_name="+function_name);
		out.println("prevVal="+prevVal);
		out.println("status="+sts);*/
		
		if(associate == null || associate.equals(""))associate="N";
		if(associate.equals("Y")) //checkValue = "checked"; else checkValue = "";
		if(privilege_status.equals("")||privilege_status.equals("null"))
			privilege_status_value = "0";
		else
			privilege_status_value = privilege_status;
		if(privilege_status.equals("A")){
			selectOption1 = "selected";
			selectOption2 = "";
		}else if(privilege_status.equals("X")){
			selectOption1 = "";
			selectOption2 = "selected";
		}else{
			selectOption1 = "";
			selectOption2 = "";
		}
		/*Below code added by Channaveer B for crf MO-CRF-33 */
		if(access.equals("ALL")){
			accessOption1="selected";
			accessOption2="";
			accessOption3="";
		}else if(access.equals("MO")){
            accessOption1="";
			accessOption2="selected";
			accessOption3="";
		}else if(access.equals("MS")){
			accessOption1="";
			accessOption2="";
			accessOption3="selected";
		}else
		{
			accessOption1="";
			accessOption2="";
			accessOption3="";			
		}
		/*ENDS HERE */
		%>
		<tr id=''>
			<%
			if(dtl_grp_by_code.equals("DFN"))
			{
			  %>
          <td class='<%=classValue%>' >
				<%=function_name%>
				</td>
			<%
			}
			%>
			<td class='<%=classValue%>'><input type = "hidden"  name="description<%=i%>" id="description<%=i%>" value ="<%=code%>"><%=((equals(""))?"&nbsp;":desc)%></td>
			<td class='<%=classValue%>' ><select name="select_yn<%=i%>" id="select_yn<%=i%>" onChange='return checkNoteTypeForRes(this,"<%=code%>","<%=privilege_status_value%>","<%=i%>");'>
			<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -- </option>
			<option value="A" <%=selectOption1%> ><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></option>
			<option value="X" <%=selectOption2%> ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			<!--Below code added by channaveer B for crf MO-CRF-33 -->
			<!--IN061903 start-->
			<%//if((group_by.equals("TS") && (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE")))  || ((group_by.equals("RS") || group_by.equals("RL")) && (code.equals("AMEND_ORDER")|| code.equals("CANCEL_ORDER") || code.equals("HOLD") || code.equals("DISCONTINUE")))){
			if((group_by.equals("TS") && (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE") || grp_by_code.equals("NOTDONE")))  || ((group_by.equals("RS") || group_by.equals("RL")) && (code.equals("AMEND_ORDER")|| code.equals("CANCEL_ORDER") || code.equals("HOLD") || code.equals("DISCONTINUE") || code.equals("NOTDONE")))){%>
			<!--IN061903 end-->
			<td class="<%=classValue%>"><select name="access_rights<%=i%>" id="access_rights<%=i%>" style="width:150px" <%if(!privilege_status.equals("A")){%>disabled<%}%>>
			<%if(privilege_status.equals("A")){%>
			<option value='ALL' <%=accessOption1%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value='MO' <%=accessOption2%>><fmt:message key="eCA.SelfOrder.label" bundle="${ca_labels}"/></option>
			<option value='MS' <%=accessOption3%>><fmt:message key="eCA.SelfSpltyOrders.label" bundle="${ca_labels}"/></option>
			<%}else{%>
			<option  value='' ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
			<%}%>
		</select>
			</td>
			<%}else if(group_by.equals("RS") || group_by.equals("RL")){%>
					<td class='<%=classValue%>'></td>
			<%}%>
			<!-- ENDS HERE -->
		</tr>
		<%
				
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
        
		}//for
	}
	catch(Exception ee)
	{
			ee.printStackTrace();
	}
}catch(Exception e)
{
		e.printStackTrace();
}
finally
{		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}	
%>
	<td>
	</td>
	</table>
		</div>
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
	<input type="hidden" name="grp_by_code" id="grp_by_code" value="<%=grp_by_code%>">
	<input type="hidden" name="dtl_grp_by_code" id="dtl_grp_by_code" value="<%=dtl_grp_by_code%>">
	<input type="hidden" name="amend_order" id="amend_order" value="<%=amend_order%>">
	<input type="hidden" name="cancel_order" id="cancel_order" value="<%=cancel_order%>">
	<input type="hidden" name="discontinue" id="discontinue" value="<%=discontinue%>">
	<input type="hidden" name="hold" id="hold" value="<%=hold%>">
	<input type="hidden" name="not_done" id="not_done" value="<%=not_done%>"><!--IN061903-->
</form>
</body>
</html>

