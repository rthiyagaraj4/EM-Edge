<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../js/PhMessages.js"></script>
	<script language="JavaScript" src="../js/GenericNameByATC.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "GenericNameByATC" ;
	String bean_name = "ePH.GenericNameByATCBean";
	
	String resultByATC=request.getParameter( "resultByATC" ) ;
	if (resultByATC==null || resultByATC.equals(" "))
	{
			resultByATC="N";
	}
	
	String generic_id= request.getParameter( "generic_id" ) ;

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	GenericNameByATCBean bean = (GenericNameByATCBean)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	/* Initialize Function specific end */
%>
<form name="frmGenericNameAddModify" id="frmGenericNameAddModify" id="Generic Name Add Modify" >
<%
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
%>
	<br> 
	<table cellpadding=0 cellspacing=0 width="80%" border="0" align="center" >
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="2" >&nbsp;&nbsp;
				<input type="text" id="Generic Name" name="generic_name" id="generic_name" onBlur="makeValidString(this)" size="42" maxlength="40" >
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td align="left" colspan="2">&nbsp;&nbsp;
				<select name="drug_name" id="drug_name">
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N">Narcotic</option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align="left" >&nbsp;&nbsp;
				<input type="checkbox" name="eff_status" id="eff_status" value="E" checked >
			</td>
			<td align="right">
				<input type="button" class="BUTTON" name="btnSelect" id="btnSelect" value="Associate ATC" onClick="callAssociateATC()">&nbsp;<input type="button" class="BUTTON" name="btnSelect2" id="btnSelect2" value="Associate Pharmaco" onClick="callAssociatePharmaco()">
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
<% } 
   if( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && (resultByATC.equals("N"))){

	String narcotic_select="", general_select="", controlled_select="";
	String drugclass=request.getParameter( "drugclass" ) ;
	String genericName="";

	if (drugclass !=null) {
		if (drugclass.equals("Narcotic")){
			narcotic_select = "selected";
		}
		else if (drugclass.equals("General")){
			general_select  = "selected";
		}
		else if (drugclass.equals("Controlled")){
			controlled_select = "selected";
		}
	}	
	ArrayList arrList= bean.getAllValuesForModify(generic_id,locale);	
	String select="";
	String enableDisable="";
	if (arrList.size() > 0){
			String record[]=(String[])arrList.get(0);
			if (record[4].equals("E")){
				select = "checked";
			}
			else {
				select = "";
				enableDisable="disabled";
			}
			genericName = record[2];
	}
	else{
		if ((bean.getEffStatus()).equals("E")){
			select = "checked";		
		}
		else{
			select = "";
			enableDisable="disabled";
		}
		genericName = bean.getGenericName();
	}

%>
	<br> 
	<table cellpadding=0 cellspacing=0 width="80%" align="center" >
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td align="left" colspan="2" >&nbsp;&nbsp;
				<input type="text" id="Generic Name" name="generic_name" id="generic_name" size="42" maxlength="40" value="<%= genericName %>" disabled onBlur="makeValidString(this);">
				<input type="hidden" value="<%=genericName%>" name="generic_name_with_no_modification"></td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td align="left" colspan="2" >&nbsp;&nbsp;
				<select name="drug_name" id="drug_name"  disabled>
					<option value="G" <%=general_select    %>><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N" <%=narcotic_select   %>>Narcotic</option>
					<option value="C" <%=controlled_select %>><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<%
			String result=	bean.checkForAssociation(generic_id);
			String disabledCheckBox = "";
			if(result.equals("N")){
				disabledCheckBox = "disabled";
			}
		%>
			<td align="left" >&nbsp;&nbsp;
				<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=select %> <%=disabledCheckBox%> onClick="controlDelete(this)">
			</td>
			<td align="right">
				<input type="button" class="BUTTON" name="btnSelect" id="btnSelect" value="Associate ATC" onClick="callAssociateATC()" <%=enableDisable %> ><input type="button" class="BUTTON" name="btnSelect2" id="btnSelect2" value="Associate Pharma" onClick="callAssociatePharmaco()" <%=enableDisable %> >
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
<%
   }
   else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && (resultByATC.equals("M")))
   {
		String codes=request.getParameter("atcclassification");
		StringTokenizer stCodes = new StringTokenizer(codes,"|");
		int count = stCodes.countTokens();
		String lev1desc="",lev2desc="",lev3desc="";
		if (count >1){		
				lev1desc = stCodes.nextToken();
				lev2desc = stCodes.nextToken();
				lev3desc = stCodes.nextToken();		
		}
		%>
	<br>
	<table cellpadding=0 cellspacing=0 width="84%" border="1" align="center">	
	<thead >
		<tr>
			<th colspan="3" align="left" style="font-size:xx-small"><fmt:message key="ePH.QueryResultByPharmacoClassification.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<th align="left" style="font-size:xx-small" width="30%"><fmt:message key="ePH.ATCClass.label" bundle="${ph_labels}"/></th>
		    <th colspan="2" align="left" style="font-size:xx-small" width="70%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>			
		</tr>
	</thead>
	</table>
	<table cellpadding=0 cellspacing=0 width="84%" border="0" align="center">
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold"><fmt:message key="ePH.AnatomicalClass.label" bundle="${ph_labels}"/></td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold"><%= lev1desc %>&nbsp;</td>
		</tr>
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">Therapeutic Class(Main)</td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold"><%= lev2desc %>&nbsp;</td>
		</tr>
		<tr>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold">Therapeutic Class(Sub)</td>
			<td style="border-top:none;font-size:xx-small;color:darkblue;font-weight:bold"><%= lev3desc %>&nbsp;</td>
		</tr>
	</table>
<%
		}
		else {
%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));history.go(-1);
	</script>
<%
	   }
   
%>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="generic_id" id="generic_id" value="<%= generic_id %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
</form>
<% if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
{
%>
<script>
	document.frmGenericNameAddModify.generic_name.focus() ;
</script>
<%}%>
	<% putObjectInBean(bean_id,bean,request ) ; %>
</body>
</HTML>

