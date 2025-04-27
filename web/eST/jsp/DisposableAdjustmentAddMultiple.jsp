<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList, eST.*, eST.Common.*, eCommon.Common.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>  -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/DisposableAdjustment.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
		<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body onMouseDown='CodeArrest();'>
<%
		String mode = null;
		String bean_id = null;
		String bean_name = null;

		mode	= request.getParameter( "mode") ;
		if ((mode == null) || (mode.equals(""))) 
			return ;
		if (!(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return ;
	
		bean_id = "DisposableAdjustmentBean" ;
		bean_name = "eST.DisposableAdjustmentBean";
		
		DisposableAdjustmentBean bean = (DisposableAdjustmentBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear();
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
		//String stores = bean.getStores();
%>
		
<form name="formDisposableAdjustment" id="formDisposableAdjustment" >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">	
		<table cellpadding="0" cellspacing="0" align="center" border=1>
		<tr>
			<th align="center" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="eST.GenerateBatch.label" bundle="${st_labels}"/></th>
			<th align="center" ><fmt:message key="eST.BatchSeries.label" bundle="${st_labels}"/></th>
			<th align="center" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			String classValue = null;
			int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				if(cnt%2 ==0)
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
		%>
			 <tr>  
			   <td align="center" class="<%=classValue %>" >
					<select name="store_code_<%=cnt %>" id="store_code_<%=cnt %>"><%=bean.getStores()%> </select>
				</td>
				<td align="center" class="<%=classValue %>">
					<input type="checkBox" name="auto_gen_batch_yn_<%=cnt %>" id="auto_gen_batch_yn_<%=cnt %>" value="N" onclick="return checkbatchid(this,<%=cnt %>);" >
				</td>
				<td align="center" class="<%=classValue %>"> 
					<input type="text" name="batch_series_<%=cnt %>" id="batch_series_<%=cnt %>" size="1" maxlength="2" 
					onKeyPress="return CheckForChars(event)"  onBlur="resetColorCode(this);convertToUpperCase(this);checkSpecialChars(this);">
				</td>
				<td align="center" class="<%=classValue %>">
					<input type="text" name="batch_id_<%=cnt %>" id="batch_id_<%=cnt %>" size="8" maxlength="8" 
					onkeypress="return isValidInteger(this);" onBlur="checkIntegerFormat(this);resetColorCode(this);">
				</td>
				<td align="center" class="<%=classValue %>">
					<input type="checkBox" name="eff_status_<%=cnt %>" id="eff_status_<%=cnt %>" value="E" CHECKED >
				</td>
			</tr>
	<%
		}
	%>		
		</table>
	</td>
	</tr>
	</table> 
	<script>
		document.formDisposableAdjustment.store_code_0.focus() ;
	</script>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=max_rows%>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

