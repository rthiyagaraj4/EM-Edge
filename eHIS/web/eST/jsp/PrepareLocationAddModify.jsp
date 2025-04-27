<!DOCTYPE html>
<%--This JSP is call when a user clicks on Create Button --%>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
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
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/PrepareLocation.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script>
		<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
</head>
<body onLoad="FocusFirstElement()">
<%
		String mode;
		String bean_id;
		String bean_name;
		String disabled = "";
		String prepare_location_code = "";
		String iddisabled="";
		String disab="";
	try{
		mode	= request.getParameter( "mode");
		
		bean_id = "prepareLocationBean";
		bean_name = "eST.PrepareLocationBean";
		disabled = "";
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		PrepareLocationBean bean = (PrepareLocationBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear();
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));		
		if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			prepare_location_code = request.getParameter( "prepare_location_code");
			
			if (prepare_location_code == null) {
				return;		
			}
			bean.setCode(0,prepare_location_code);
			bean.setLanguageId(locale);
			bean.loadData();
			
			String batch_idyn=	CommonBean.checkForNull(bean.getBatch_yn(0));
			String batch_yn1=	CommonBean.checkForNull(bean.getBatch_yn(0));
			
			if(batch_yn1.equals("N"))
			{
				disab="disabled";
			}
			
			if(batch_idyn.equals(""))  iddisabled="disabled";
			else	iddisabled="enabled";
			if(bean.getEff_status(0).equals("D"))
				disabled = "disabled";
		}
%>
	

<form name="formPrepareLocation" id="formPrepareLocation" >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
	<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<input type="text" name="code_0" id="code_0" value="<%= bean.getCode(0) %>" size="8" maxlength="8" disabled>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<input type="text" name="long_desc_0" id="long_desc_0" value="<%=bean.getLong_desc(0) %>" size="42" maxlength="40" <%= disabled %> >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<input type="text" name="short_desc_0" id="short_desc_0" value="<%= bean.getShort_desc(0) %>" size="20" maxlength="15" <%= disabled %> >
		<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
	</tr>
	<tr>
		<td class="label" align="right"><fmt:message key="eST.GenerateBatch.label" bundle="${st_labels}"/></td>
		<td align="left">&nbsp;<input type="checkBox" name="auto_gen_batch_yn_0" id="auto_gen_batch_yn_0" value="N" disabled <%=(bean.getBatch_yn(0)).equals("Y")?"checked":"" %>    >
		</td>
	</tr>

	<tr>
		<td align="right" class="label"><fmt:message key="eST.BatchSeries.label" bundle="${st_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<input type="text" name="batch_series_0" id="batch_series_0" value="<%= CommonBean.checkForNull(bean.getBatch_series(0)) %>" size="8" maxlength="2" <%= disabled %> <%=iddisabled%> disabled>
		</td>
	</tr> 
	<tr>
		<td align="right" class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<input type="text" name="batch_id_0" id="batch_id_0" value="<%= CommonBean.checkForNull(bean.getBatch_id(0)) %>" size="8" maxlength="8" <%= disabled %> <%=iddisabled%>  <%=disab%> onkeypress="return isValidInteger(this);" onblur="return checkForNumber('<%=CommonBean.checkForNull(bean.getBatch_id(0))%>');"  >
		</td>
	</tr>
	
	<tr>
		<td class="label" align="right"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;<input type="checkBox" name="eff_status_0" id="eff_status_0" value="E" <%=(bean.getEff_status(0)).equals("E")?"checked":"" %> >
		</td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<%
		if((bean.getEff_status(0)).equals("E")) {
	%>
		<script language="javascript">
				document.formPrepareLocation.long_desc_0.focus();
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
			}
	%>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>

		<%
putObjectInBean(bean_id,bean,request);

		}	
		catch (Exception e)	{
			e.printStackTrace();
		}
%>

</body>
</html>

