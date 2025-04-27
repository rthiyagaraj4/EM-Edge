<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<jsp:useBean id="alAlternateGroupList" scope="session" class="java.util.ArrayList"/>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha">
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/AlternateGroup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onMouseDown='CodeArrest();'>
<%
	

	
	String mode						=		"";
	
	String bean_id					=		"AlternateGroupBean" ;
	String bean_name				=		"eSS.AlternateGroupBean";
	String group_code				=		request.getParameter( "group_code" ) ==null?"":request.getParameter( "group_code" );
	String group_type				=		request.getParameter( "group_type" ) ==null?"":request.getParameter( "group_type" );
	String usage_desc				=		request.getParameter( "usage_desc" ) ==null?"%":request.getParameter( "usage_desc" );
	String surgery_type				=		request.getParameter( "surgery_type" ) ==null?"%":request.getParameter( "surgery_type" );
	String classvalue				=		"";
	int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));


	String search = request.getParameter("search")==null?"":request.getParameter("search");

	
	if(usage_desc.equals("") || usage_desc=="")usage_desc="%";
	if(surgery_type.equals("") || surgery_type=="")surgery_type="%";
	
	ArrayList alternateGroupDetails=new ArrayList();
	
	AlternateGroupBean bean			=		(AlternateGroupBean) getBeanObject( bean_id, bean_name, request  );  
	if(search.equals("new")){
		bean.clear();
		alternateGroupDetails = (ArrayList)bean.loadData(group_code,group_type,usage_desc,surgery_type) ;
		}else{
	alternateGroupDetails = bean.getalternateGroupDetails();
		}
	int maxRecord = (alternateGroupDetails.size() / 5);
	if(maxRecord <= to)
	to = maxRecord-1;
	int index=(from*5);
	int count=from;
String alternative_group_code="";


	String dispMode					=		request.getParameter( "dispMode" ) ;

	String initString				=		"";
	if(dispMode==null) dispMode		=		"";

	int end							=		0;
	int displaySize					=		0;
String classValue="";
		

	String dbaction="";
try{
	mode							=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;


	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.setLanguageId(locale);
	String delete_checked="";
	String select_checked="";
	String select="";
	
	%>
	<form name="formAlternateGroupDetail" id="formAlternateGroupDetail"  >

	<table  width='100%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type=hidden name='from' id='from' value='<%=from%>'>
						<input type=hidden name='to' id='to' value='<%=to%>'>
<%
						if(from > 0) {
%>
							<a href='javascript:submitPrevNext(<%=(from-20)%>,<%=(from-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='prevPage' id='prevPage' value='prev'>
<%
						}
						if(!((from+20) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(from+20)%>,<%=(from+39)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>

	<%
	if(alternateGroupDetails!= null && alternateGroupDetails.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="eSS.AlternateGroupCode.label" bundle="${ss_labels}"/></th><th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
<%

	while(count <= to){
					alternative_group_code = (String)alternateGroupDetails.get(index);
					if( (count+1)%2 == 0)  
						classValue="QRYODD";
					else
						classValue="QRYEVEN";
					dbaction=(String)alternateGroupDetails.get(index+3);
					select=(String)alternateGroupDetails.get(index+4);
%>
<tr>
						<input type='hidden' name='alternative_group_code<%=count%>' id='alternative_group_code<%=count%>' value='<%=alternative_group_code%>'>
<%if(dbaction.equals("U")){
	if(select.equals("Y"))
	delete_checked="checked";
	else
	delete_checked="";
	%>
						<td class='<%=classValue%>' width='70%'>&nbsp;<font color=#000000 style="font-weight:500"><%=alternateGroupDetails.get(index+1)%></font></td>
					<td class="<%=classvalue%>" align="center" width="10%" >&nbsp;</td>
						<td class="<%=classvalue%>" align="center" width="10%" ><input type="checkbox"  align="center" name="delete_row<%=count%>" id="delete_row<%=count%>" value="" onclick="dispTypeCheck(this, '<%=alternative_group_code%>','delete');" <%=delete_checked%>   ></input></td>
						<%}else{
	if(select.equals("Y"))
	select_checked="checked";
	else
	select_checked="";
		%>
		<td class='<%=classValue%>' width='70%'>&nbsp;<%=alternateGroupDetails.get(index+1)%></td>
		<td class="<%=classvalue%>" align="center" width="10%" ><input type="checkbox"  align="center" name="select<%=count%>" id="select<%=count%>" value="" onclick="dispTypeCheck(this, '<%=alternative_group_code%>','select');"     <%=select_checked%>  ></input></td>
		<td class="<%=classvalue%>" align="center" width="10%" >&nbsp;</td>
	
		<%	}%>
<%
	
					index+=5;
					count++;
	}
	}else{
		%>
		<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common" ));</script>
	<%
	}
}catch(Exception e){
	// out.println(es);
	e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</table>

		<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden" name="group_code" id="group_code"			value="<%=group_code%>">
		<input type="hidden" name="group_type" id="group_type"			value="<%=group_type%>">
	
		<input type="hidden" name="count" id="count"				value="<%=count%>">
		<input type="hidden" name="end" id="end"					value="<%=end%>">
	
		<input type="hidden" name="displaySize" id="displaySize"			value="<%=displaySize%>">
		<input type="hidden" name="choosen_link" id="choosen_link"		value="select" >
		<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="initString" id="initString"			value="<%=java.net.URLEncoder.encode(initString)%>">
		<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
		<input type="hidden" name="locale" id="locale"				value="<%=locale%>">

		


		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

