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
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha">

<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Washing.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		
<%
		
	String disabled			=		"";
	String mode				=		"";
	ArrayList result		=		new ArrayList();
	String bean_id			=		 "WashingBean" ;
	String bean_name		=		"eSS.WashingBean";
	
	String autoclave_wash_unit_code		=	request.getParameter( "autoclave_wash_unit_code" ) ==null?"":request.getParameter( "autoclave_wash_unit_code" );
	String washing_type					=	request.getParameter( "washing_type" ) ==null?"":request.getParameter( "washing_type" );
	String temperature					=	request.getParameter( "temperature" ) ==null?"":request.getParameter( "temperature" );
	String load_no						=	request.getParameter( "load_no" ) ==null?"":request.getParameter( "load_no" );
	String rof_doc_type_code			=	request.getParameter( "rof_doc_type_code" ) ==null?"":request.getParameter( "rof_doc_type_code" );
	String store_code					=	request.getParameter( "store_code" ) ==null?"":request.getParameter( "store_code" );

	String  str_select		=		"";
	String  group_desc		=		"";
	String  tray_no			=		"";
	String  doc_no			=		""; 
	
	
	WashingBean bean		=		(WashingBean)getBeanObject( "WashingBean", "eSS.WashingBean",request);  
	bean.clear() ;
	bean.setLanguageId(locale);
	int maxRec				=		0; 
	String dispMode			=		request.getParameter( "dispMode" ) ;
	String initString		=		"";
	if(dispMode==null) dispMode	=	"";
	int start				=		0;
	int end					=		0;
	int displaySize			=		0;
	int count				=		0;
	int count_yes			=		 0;
	String classvalue		=		"";

	String from				=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to				=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	count					=		start;
	String group_code		=		"";
	

		
	HashMap dataList		=	null;
try{
	/* Mandatory checks start */
	mode					=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	
	
	bean.setMode( mode ) ;
	bean.setAutoclave_wash_unit_code(autoclave_wash_unit_code) ;
	bean.setWashing_type(washing_type) ;
	bean.setLoad_no(load_no) ;
	bean.setTemperature(temperature) ;
	bean.setStore_code(store_code) ;
	bean.setRof_doc_type_code(rof_doc_type_code) ;
	
	
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		disabled		=	"";
		result			=	bean.loadDisplayResultPage();
	}
	else{
		disabled		=	"";
		result			=	bean.getDataList();
	}
	maxRec				=	result.size();
	displaySize			=	Integer.parseInt( (String) SsRepository.getSsKeyValue("QUERY_RESULT"));


	if ( from == null || from =="" )
		start = 0;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to ==""){
		end = displaySize ;
	}
	else{
		end = Integer.parseInt( to ) ;	
	}
	%>
	<body onMouseDown="CodeArrest()" onLoad="checkSelect('<%=start%>','<%=end%>','<%=maxRec%>')">
	<form name="formWashingDetail" id="formWashingDetail"  >
	<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>

	<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrevOne('select');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNextOne('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>

	<%
	if(result.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/> </th>
		<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.SterReqDocType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type=checkbox name='selectAll' id='selectAll' onClick="changeStatusCheckBox(this);"></th>
<%
	
	count	= start;
	int chkCount = 0;
	
	initString = "";
	while ( count < maxRec && count < end)
	{
			dataList = (HashMap)result.get(count);
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			
		group_code			 =	(String)dataList.get("GROUP_CODE");
		group_desc			 =	(String)dataList.get("GROUP_DESC");
		tray_no				 =	(String)dataList.get("TRAY_NO");
		rof_doc_type_code	 =	(String)dataList.get("DOC_TYPE_DESC");
		doc_no				 =	(String)dataList.get("DOC_NO");
		store_code			 =	(String)dataList.get("STORE_CODE_DESC");
		str_select			 =	(String)dataList.get("SELECTED");
		

		

	%>
		 <tr>
			<td class="<%=classvalue%>" ><%= group_desc %>
			</td>
			<td class="<%=classvalue%>" ><%= tray_no %>
			</td>
			<td class="<%=classvalue%>" ><%= rof_doc_type_code %>
			</td>
			<td class="<%=classvalue%>" ><%= doc_no %>
			</td>
			<td class="<%=classvalue%>" ><%= store_code %>
			</td>
			<td class="<%=classvalue%>" align="center" width="10%">
			<input type="checkbox"  align="center" name="checkbox<%=count%>" id="checkbox<%=count%>"   value="<%=str_select%>"  <%=str_select.equals("Y")?"checked":""%> onclick="assignValue(this);"    <%=disabled%> ></input></td>
		</tr>
	<%
		if(str_select.equals("Y")) count_yes++;
		count++;
		chkCount++;
	}
	%>
	
<%
	}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common" ));</script> 
	<%
	
	}
	}
	catch(Exception e){
	// out.println(es);
	e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</table>
		<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="start" id="start"			value="<%=start%>">
		<input type="hidden" name="end" id="end"				value="<%=end%>">
		<input type="hidden" name="totalRecords" id="totalRecords"	value='<%=result.size()%>'>
		<input type="hidden" name="displaySize" id="displaySize"		value="<%=displaySize%>">
		<input type="hidden" name="count_yes" id="count_yes"		value="<%=count_yes%>">
		<input type="hidden" name="choosen_link" id="choosen_link"	value="select">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<%
if(dispMode.equals("")){
%>
	<script>
	maxRec			=	 <%=maxRec%> ;
	displaySize		=	<%=displaySize%> ;
	end				=	displaySize ;
	activeLink();
	</script>
<%
}
	else{
	%>
	<script>
	maxRec			=	<%=maxRec%> ;
	displaySize		=	<%=displaySize%> ;
	end				=	 <%=end%> ;
	start			=	<%=start%>;
	activeLink();
	</script>
<%
	
	}
%>
		</form>
		
<%
putObjectInBean( "WashingBean",bean,request);
%>
	</body>
</html>

