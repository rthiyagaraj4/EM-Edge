<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePO.*, ePO.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/PoCommon.js"></script>	
	<script language="JavaScript" src="../js/PurchaseUnit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown='CodeArrest();' >
<%
		String	mode			=	request.getParameter( "mode" ) ;
		String	bean_id			=	"purchaseUnitBean" ;
		String	bean_name		=	"ePO.PurchaseUnitBean";
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		PurchaseUnitBean bean = (PurchaseUnitBean) getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
%>
<form name="formPurchaseUnit" id="formPurchaseUnit"  >
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
	<tr>
	<td width='100%'   class="WHITE">	
		<table cellpadding="0" cellspacing="0"  border=1 align=center >
		<tr>
		<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/><%=bean.getImage("M")%></th>
		<th ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/><%=bean.getImage("M")%></th>
		<th ><fmt:message key="ePO.GlobalUnit.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="ePO.AddressLine1.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.AddressLine2.label" bundle="${po_labels}"/></th>
		<th ><fmt:message key="ePO.AddressLine3.label" bundle="${po_labels}"/></th>
		</tr>
		<%
			String classValue = null;
			int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
			System.out.println("max_rows = "+max_rows);
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
		%>
			 <TR>
				<td  class="<%=classValue %>" >
					<input type="text" name="unit_code_<%=cnt %>" id="unit_code_<%=cnt %>"  size="10" maxlength="6" class="UPPER" onKeyPress="return CheckForSpecChars(event)" onBlur="resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);">
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="long_desc_<%=cnt %>" id="long_desc_<%=cnt %>"  size="42" maxlength="40" onBlur="resetColorCode(this);makeValidString(this);">
				</td>
				<td  class="<%=classValue %>" >
					<input type="text" name="short_desc_<%=cnt %>" id="short_desc_<%=cnt %>" size="20" maxlength="15" onBlur="resetColorCode(this);makeValidString(this);">
				</td>
				<td align="center" class="<%=classValue %>">
					<input type="checkBox" name="global_unit_<%=cnt %>" id="global_unit_<%=cnt %>" value="Y" >
				</td>
				<td align="center" class="<%=classValue %>">
					<input type="checkBox" name="eff_status_<%=cnt %>" id="eff_status_<%=cnt %>" value="E" checked>
				</td>
		
				<td class="<%=classValue %>"> 
				<input type="text" value = "" name="supp_address1_<%=cnt %>" id="supp_address1_<%=cnt %>" size='35' maxLength='60' >
				</td>
				<td class="<%=classValue %>">
				<input type="text" value = "" name="supp_address2_<%=cnt %>" id="supp_address2_<%=cnt %>" size='35' maxLength='60' >
				</td>
				<td class="<%=classValue %>">
				<input type="text" value = "" name="supp_address3_<%=cnt %>" id="supp_address3_<%=cnt %>" size='35' maxLength='60' >
				</td>
			</TR>
	<%
		}
	%>		
		</table>
	</td>
	</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=max_rows%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
</center>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

