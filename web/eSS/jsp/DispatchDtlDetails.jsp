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
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha Krishnadasar">
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/Dispatch.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onMouseDown='CodeArrest();'>
<%
	

	String mode						=	"";
	ArrayList result				=	new ArrayList();
	String bean_id					=	"DispatchBean" ;
	String bean_name				=	"eSS.DispatchBean";
	
	String rof_doc_type_code		=	request.getParameter( "rof_doc_type_code" ) ==null?"":request.getParameter( "rof_doc_type_code" );
	String doc_no					=	request.getParameter( "doc_no" ) ==null?"":request.getParameter( "doc_no" );
	String doc_date					=	request.getParameter( "doc_date" ) ==null?"":request.getParameter( "doc_date" );
	String service_location			=	request.getParameter( "service_location" ) ==null?"":request.getParameter( "service_location" );
	String store_code				=	request.getParameter( "store_code" ) ==null?"":request.getParameter( "store_code" );
	String doc_type_desc			=	request.getParameter( "doc_type_desc" ) ==null?"":request.getParameter( "doc_type_desc" );
	
	String  tray_no					=	"";
	
	
	
	DispatchBean bean				=	 (DispatchBean)getBeanObject( "DispatchBean",  "eSS.DispatchBean", request );  
	bean.clear() ;
	int maxRec=0; 
	String dispMode					=	 request.getParameter( "dispMode" ) ;
	String initString				=	 "";
	if(dispMode==null) dispMode		=	"";
	int start						=	0;
	int end							=	0;
	int displaySize					=	0;
	int count						=	0;
	String classvalue				=	"";
	String from						=	request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to						=	request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	count							=	start;
	String group_code				=	"";

	String contaminated_yn			 = "";
	String sterile_type				 = "";
	String washing_type				 = "";
	String hold_reason				 = "";
	String hold_yn					 = "";
	String rof_status				 = "";
	String group_type_desc			 = "";
	String washing_type_desc		 = "";
	String sterile_type_desc		 = "";
	
	

	
	

	HashMap dataList	= null;
try{
	/* Mandatory checks start */
	mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	
	
	result=bean.loadResultPage(rof_doc_type_code,doc_no);//out.println(result);
	maxRec=  result.size();
	displaySize = Integer.parseInt( (String) SsRepository.getSsKeyValue("QUERY_RESULT"));

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
			<a href="javascript:goPrev('select');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>

	<%
	if(result.size() > 0 ){
	%>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="eSS.ROFDocType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ROFDocNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<tr  >
			<td class="<%=classvalue%>" ><%= doc_type_desc %>
			</td>
			<td class="<%=classvalue%>" ><%= doc_no %>
			</td>
			<td class="<%=classvalue%>" ><%= doc_date %>
			</td>
			<td class="<%=classvalue%>" ><%= service_location %>
			</td>
			<td class="<%=classvalue%>" ><%= store_code %>
			</td>
		</tr>
		</table>
		<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
		<th><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Sterilization.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Washing.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Hold.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
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
			
		group_code				= (String)dataList.get("GROUP_CODE");
		group_type_desc			= (String)dataList.get("GROUP_TYPE_DESC");
		tray_no					= (String)dataList.get("TRAY_NO");
		contaminated_yn			= (String)dataList.get("CONTAMINATED_YN");
		sterile_type			= (String)dataList.get("STERILE_TYPE");
		washing_type			= (String)dataList.get("WASHING_TYPE");
		washing_type_desc		= (String)dataList.get("WASHING_TYPE_DESC");
		hold_reason				= (String)dataList.get("HOLD_REASON")==null?"":(String)dataList.get("HOLD_REASON");
		hold_yn					= (String)dataList.get("HOLD_YN");
		rof_status				= (String)dataList.get("ROF_STATUS");
		sterile_type_desc		= (String)dataList.get("STERILE_TYPE_DESC");
		
	%>
		 <tr>
			<tr  >
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%= group_type_desc %>
				</font></td>
				<td class="<%=classvalue%>" ><%= group_code %>
				</td>
				<td class="<%=classvalue%>" ><%= tray_no %>
				</td>
				<td class="<%=classvalue%>" ><%= contaminated_yn %>
				</td>
				<td class="<%=classvalue%>" ><%= sterile_type_desc %>
				</td>
				<td class="<%=classvalue%>" ><%= washing_type_desc %>
				</td>
				<td class="<%=classvalue%>" ><%= hold_yn %>
				</td>
				<td class="<%=classvalue%>" ><%= hold_reason %>
				</td>
		</tr>
	<%
		count++;
		chkCount++;
	}
	%>
	
<%
	}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA" ));</script> 
	<%
	
	}
	}
	catch(Exception e){
	// out.println(es);
	e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</table>

		<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
		<input type="hidden" name="start" id="start"		value="<%=start%>">
		<input type="hidden" name="end" id="end"			value="<%=end%>">
		<input type="hidden" name="totalRecords" id="totalRecords" value='<%=result.size()%>'>
		<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
		<input type="hidden"  name="choosen_link" id="choosen_link" value="select">
		<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<%
if(dispMode.equals("")){
%>
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = displaySize ;
	</script>
<%
}
	else{
	%>
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = <%=end%> ;
	start=<%=start%>;
	</script>
<%
	
	}
%>
		</form>
	</body>
</html>

<%
	putObjectInBean("DispatchBean", bean,request);
%>


