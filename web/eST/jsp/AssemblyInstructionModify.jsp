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
		
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/AssemblyInstruction.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>

	</head>
	<body onLoad="FocusFirstElement()">
<%
		String mode;
		String bean_id;
		String bean_name;
		String disabled			= "";
		String assm_instrn_code = "";
		String assm_instrn_desc = "";
		String eff_status		= "";
		try{
			mode	= request.getParameter( "mode");
			
			bean_id = "AssemblyInstructionBean";
			bean_name = "eST.AssemblyInstructionBean";
			disabled = "";
			if ((mode == null) || (mode.equals(""))) 
				return;
			if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
				return;
			AssemblyInstructionBean bean = (AssemblyInstructionBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			bean.clear();
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
				bean.setLocalEJB(false);

			bean.setMode( mode ) ;
			bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));		
			if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
				
				assm_instrn_code = request.getParameter( "assm_instrn_code");
				bean.setInstrnCode(assm_instrn_code);
				bean.loadData();
				assm_instrn_desc = bean.getInstrnDesc();
				eff_status		 = bean.getEffStatus();
				
				if (assm_instrn_code == null) {
					return;		
				}
				bean.setInstrnCode(assm_instrn_code);
				bean.setLanguageId(locale);

				if(bean.getEffStatus().equals("D"))
					disabled = "disabled";
			}
%>
			<form name="AssmblyInstrnCodeform" id="AssmblyInstrnCodeform" >
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
					<tr>
						<td width='100%' align='center' class="WHITE">
							<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr>
									<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
									<td align="left">&nbsp;&nbsp;<input type="text" name="assm_instrn_code" id="assm_instrn_code" value="<%= assm_instrn_code %>" size="8" maxlength="8" disabled>
									<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr>
									<td align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
									<td align="left">&nbsp;&nbsp;<input type="text" name="description" id="description" value="<%=assm_instrn_desc.trim()%>" size="42" maxlength="40" <%= disabled %> >
									<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
									
								<tr>
									<td class="label" align="right"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
									<td align="left">&nbsp;<input type="checkBox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=(eff_status).equals("E")?"checked":"" %> onclick="changestatus(this)" >
									</td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
<%
								if((bean.getEffStatus()).equals("E")) {
%>
									<script language="javascript">
											document.AssmblyInstrnCodeform.description.focus();
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

