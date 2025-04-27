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
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Washing.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()">
<%
	
	String mode					=		"";
	String bean_id				=		"WashingBean" ;
	String bean_name			=		"eSS.WashingBean";
	String classvalue			=		"";
	String dispMode				=		request.getParameter( "dispMode" ) ;
	String temperature			=		"";
	String entry_completed_yn	=		"";
	String washing_uint_desc	=		"";
	String washing_type_desc	=		"";
	String service_location_desc=		"";
	String store_code			=		"";
	String store_desc			=		"";

	int maxRec=0; 
	if(dispMode==null) dispMode =		"";
	int start					=		0;
	int end						=		0;
	int displaySize				=		0;
	int count					=		0;
	
	String autoclave_wash_unit_code		=	request.getParameter( "autoclave_wash_unit_code" ) ==null?"":request.getParameter( "autoclave_wash_unit_code" );
	String load_no						=	request.getParameter( "load_no" ) ==null?"%":request.getParameter( "load_no" );
	String washing_type					=	request.getParameter( "load_no" ) ==null?"%":request.getParameter( "washing_type" );
	String from							=	request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=	request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;

	WashingBean bean					=	(WashingBean)getBeanObject( "WashingBean",   "eSS.WashingBean", request);  
	bean.clear() ;
	bean.setLanguageId(locale);

	ArrayList result				=		new ArrayList();	
	HashMap dataList				=		 null;
try{
	/* Mandatory checks start */
	mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	bean.setMode( mode ) ;
	bean.setAutoclave_wash_unit_code(autoclave_wash_unit_code) ;
	bean.setLoad_no(load_no) ;
	bean.setWashing_type(washing_type) ;
	
	result							=		bean.loadResultPage(); 
	maxRec							=		result.size();
	displaySize						=		Integer.parseInt( (String) SsRepository.getSsKeyValue("QUERY_RESULT"));

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
	<form name="formWashingDetail" id="formWashingDetail"  >
	<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrevOne('query');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNextOne('query');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>
	<%
	if(result.size() > 0 ){
		%>
			<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
			<th><fmt:message key="eSS.WashingUnit.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.WashingType.label" bundle="${ss_labels}"/></th>
		<%
		count	= start;
		int chkCount = 0;
		while ( count < maxRec && count < end)
		{
				dataList = (HashMap)result.get(count);
				
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				       
                   
                        
				autoclave_wash_unit_code		= (String)dataList.get("AUTOCLAVE_WASH_UNIT_CODE");
				washing_uint_desc				= (String)dataList.get("WASHING_UNIT_DESC");
				washing_type					= (String)dataList.get("WASHING_TYPE");
				washing_type_desc				= (String)dataList.get("WASHING_TYPE_DESC");
				load_no							= (String)dataList.get("LOAD_NO");
				temperature						= (String)dataList.get("TEMPERATURE");
				entry_completed_yn				= (String)dataList.get("ENTRY_COMPLETED_YN");
				service_location_desc			= (String)dataList.get("SERVICE_LOCATION_DESC");
				store_code						= (String)dataList.get("STORE_CODE");
				store_desc						= (String)dataList.get("STORE_DESC");

		%>
			    <tr  onClick="popDtlData('<%=autoclave_wash_unit_code%>','<%=washing_type%>','<%=load_no%>','<%=temperature%>','<%=entry_completed_yn%>','<%=service_location_desc%>','<%=store_code%>','<%=store_desc%>')">
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%= washing_uint_desc %>
				</font></td>
				<td class="<%=classvalue%>" ><%= load_no %></td>
				<td class="<%=classvalue%>" ><%= washing_type_desc %></td>
				</tr>
		<%
			count++;
			chkCount++;
		}
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
		<input type="hidden"  name="choosen_link" id="choosen_link"	value="select">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<%
if(dispMode.equals("")){
%>
	<script>
	maxRec				=	<%=maxRec%> ;
	displaySize			=	<%=displaySize%> ;
	end					=	displaySize ;
	activeLink();
	</script>
<%
}
	else{
	%>
	<script>
	maxRec				=	<%=maxRec%> ;
	displaySize			=	<%=displaySize%> ;
	end					=	<%=end%> ;
	start				=	<%=start%>;
	activeLink();
	</script>
<%
	}
%>
		</form>
		
<%
putObjectInBean("WashingBean",bean,request);
%>
	</body>
</html>

