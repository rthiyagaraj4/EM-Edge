<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,eST.RequestBean,eST.GenerateRequestBean,eST.AuthorizeAtIssueStoreBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id		= (String)request.getParameter("bean_id")==null?"":(String)request.getParameter("bean_id");
		String bean_name		= (String)request.getParameter("bean_name")==null?"":(String)request.getParameter("bean_name");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
<%
		if(bean_id.equals("requestBean")){
%>
			<script language="javascript" src="../../eST/js/Request.js"></script>
<%
		}
		else if(bean_id.equals("generateRequestBean")){
%>
			<script language="javascript" src="../../eST/js/GenerateRequest.js"></script>
<%
		}
		else if(bean_id.equals("authorizeAtIssueStoreBean")){
%>
			<script language="javascript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		}
%>
		<title><fmt:message key="eST.CurrentPendingRequests.label" bundle="${st_labels}"/></title>
	</head>
<%
	String request_by_store		=	(String)request.getParameter("request_by_store")==null?"":(String)request.getParameter("request_by_store");
	String request_on_store_code =	(String)request.getParameter("request_on_store_code")==null?"":(String)request.getParameter("request_on_store_code");
	String item_code	= "";
	ArrayList items		=	new ArrayList();
	if(bean_id.equals("requestBean")){
		RequestBean bean	=	(RequestBean) getBeanObject(bean_id,bean_name, request  ); 
		bean.setLanguageId(locale);
		items=bean.curerentPendingRequestDetalis(request_by_store);
	}
	else if(bean_id.equals("generateRequestBean")){
		GenerateRequestBean bean	=	(GenerateRequestBean) getBeanObject(bean_id,bean_name, request  ); 
		bean.setLanguageId(locale);
		items=bean.curerentPendingRequestDetalis(request_by_store,bean.getCheckedValues());
	}
	else if(bean_id.equals("authorizeAtIssueStoreBean")){
		AuthorizeAtIssueStoreBean bean	=	(AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name, request  ); 
		bean.setLanguageId(locale);
		items=bean.curerentPendingRequestDetalis(request_on_store_code);
	}
	int i = 0;
	//Added and Modified against TTM-SCF-0112,TTM-SCF-0124 on 22-05-2015
	ArrayList al = null;
	HashMap it_map = null;
	String classvalue ="";
%>
	<body>
		<form name="formPendingDetail" id="formPendingDetail">
		<div name='divPendingRequest' id='divPendingRequest' style='position:absolute;top:0px;left:0px;height:350px;overflow-x:no;overflow-y:auto;'>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border='1'>
				<tr id='trHeader' style='position:relative;' style='top:expression(this.offsetParent.scrollTop-2)'>
					<td width="55%" class="COLUMNHEADERCENTER" ><b><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td width="25%" class="COLUMNHEADERCENTER" ><b><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td width="10%" class="COLUMNHEADERCENTER" ><b><fmt:message key="eST.DocumentNo.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
					<td width="10%" class="COLUMNHEADERCENTER" ><b><fmt:message key="eST.Discard.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				</tr>
<%
				for(i=0;i<items.size();i++){
					al=(ArrayList)items.get(i);
					for(int j=0;j<al.size();j++){
						it_map=(HashMap)al.get(j);
							if ( j % 2 == 0 )
								classvalue = "QRYODDSMALL" ;
							else
								classvalue = "QRYEVENSMALL" ;
%>
						<tr>
<%
						if(!(item_code.equals((String)it_map.get("ITEM_CODE")))){
%>
							<td  width="55%" class="<%=classvalue%>" wrap> <%=(String)it_map.get("ITEM_DESC")%></td>
							<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=(String)it_map.get("ITEM_CODE")%>">
<%
						}
						else{
%>
							<td width="40%" class="<%=classvalue%>">&nbsp;</td>
<%
						}
%>
						<td width="25%" class="<%=classvalue%>" wrap ><%=(String)it_map.get("REQ_ON_STORE_DESC")%></td>
						<td  width="10%" class="<%=classvalue%>" nowrap ><%=(String)it_map.get("DOC_NO")%></td> 
						<td  width="10%" class="<%=classvalue%>">
<%
							if(!(item_code.equals((String)it_map.get("ITEM_CODE")))){
%>
								<input type="checkbox" name="discard_<%=i%>" id="discard_<%=i%>" onclick="appendValues();">
<%
							}
							else{
%>
								&nbsp;
<%
							}
%>
							</td>
						</tr>
<%
						item_code = (String)it_map.get("ITEM_CODE");
					}
				}
%>
				</table>
			</div>
			<div name='divPendingRequestBtn' id='divPendingRequestBtn' style='position:absolute;bottom:0px;left:0px;height:50px;'>
			<table cellpadding=0 border = '0' cellspacing=0 width="100%" align="center">
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td class='button'>
						<input type="button" class="button" name="continue" id="continue" value='<fmt:message key="Common.Continue.label" bundle="${common_labels}"/>' onClick="parent.returnValue=document.formPendingDetail.checked_values.value;window.close();">&nbsp;&nbsp;
						<input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="parent.returnValue=undefined;window.close();">&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			</div>
			<input type="hidden" name="checked_values" id="checked_values" value="">
			<input type="hidden" name="total_values" id="total_values" value="<%=i%>">
		</form>
	</body>
</html>

