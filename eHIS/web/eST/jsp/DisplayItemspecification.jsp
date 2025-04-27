<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		String bean_id						=			 "ItemSearchBean";
		String bean_name					=			 "eST.ItemSearchBean";
		ItemSearchBean bean					=			(ItemSearchBean) getBeanObject( bean_id,bean_name,request);
		
		
		String item_name					=		request.getParameter("item_name")==null?"":request.getParameter( "item_name" ) ;
		String item_code					=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		

		HashMap hmRecord	=	null;
		hmRecord = bean.getItemSpecfnRemarks(item_code,locale);
		String item_specfn_name = CommonBean.checkForNull((String)hmRecord.get("ITEM_SPECIFICATION"),"");
		String item_remarks = CommonBean.checkForNull((String)hmRecord.get("ITEM_REMARKS"),"");
					
	%>
	<title>Item Remarks and Item Specification</title>
	</head>
	<body onload="window.scrollTo(0,0)">
		<table border="1" cellpadding="0" cellspacing="0" width="100%"  align="center">
			<tr><td class="ITEMSELECT" align="left"><b><fmt:message key="Common.item.label" bundle="${common_labels}"/> :</b> <%=item_name%></td></tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>	
				<%if(!item_remarks.equals("")){%>
				<th  align="center" nowrap><fmt:message key="eMM.ItemRemarks.label" bundle="${mm_labels}"/></th></tr>
				<tr><td class="OAQRYEVEN" valign="top"><%=item_remarks%></td>
				<%}%>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<%if(!item_specfn_name.equals("")){%>
				<th align="center" nowrap><fmt:message key="eMM.ItemSpecification.label" bundle="${mm_labels}"/></th></tr>
				<tr><td class="OAQRYODD" valign="top"><%=item_specfn_name %></td>
				<%}%>

			</tr>
			
		</table>
<table border="0" cellpadding="0" cellspacing="0" width="100%"  align="center">
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
<tr>
	<td align="center"><input type="button" align="right" class="button" name="Ok" id="Ok" value=" Ok "  onClick="window.close();"></td></tr>

			</table>
	</body>
</html>
	

