<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%

	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <!-- <script language="JavaScript" src="../js/PhCommon.js"></script> -->
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<!--<script language="JavaScript" src="../js/PhMessages.js"></script>-->
    <script language="JavaScript" src="../js/ReconstituentFluid.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
 <%
	String mode	= request.getParameter( "mode" ) ;
	String Immodule_Yn		=	"";
	String rfid		=	"";
	String rfname		=	"";
	String rfbaseuom		=	"";
	String bean_id	 ="ReconstituentFluidBean";
	String bean_name ="ePH.ReconstituentFluidBean";
	ReconstituentFluidBean bean = (ReconstituentFluidBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Immodule_Yn=(String) bean.getImModule();
	String rfiddisabled="";

	

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	//out.println("mode=========48===>" +mode);	 
	if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
	{
		rfid = request.getParameter("rf_id");
		rfiddisabled="disabled";
		ArrayList arec = bean.getRecords(rfid);
		if(arec.size() > 1) {
		rfname = (String)arec.get(1);
		rfbaseuom = (String)arec.get(2);
		}
		if(rfname==null)
			rfname="";
		if(rfbaseuom==null)
			rfbaseuom="";

	}

	ArrayList all = bean.loadUom();
	ArrayList base_uom	 = (ArrayList)all.get(0);
	ArrayList short_desc = (ArrayList)all.get(1);

%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()"> 
<form name="formReconstituentFluid" id="formReconstituentFluid">
<%
	if(!Immodule_Yn.equals("1"))
	{
%>
		<br><br><br><br><br><br><br><br><br><br><br>
<%
	}
	%>
<table width="90%" CELLPADDING="0" CELLSPACING="0" BORDER="0" align='center'>
<tr>
	<th colspan="2"><fmt:message key="ePH.ReconstituentFluid.label" bundle="${ph_labels}"/></th>
</tr>
<tr>
	<td class="label"><fmt:message key="ePH.FluidID.label" bundle="${ph_labels}"/></td>
	<td ><INPUT TYPE="text" <%=rfiddisabled%> NAME="RF_ID" SIZE="14" MAXLENGTH="15" value="<%=rfid%>" onKeyPress="changeToUpper(this);charsCapsSpaceDotCamasOnly()" onBlur="FluidTest(this);"><img src="../../eCommon/images/mandatory.gif"></img></td> 
</tr>
<tr>
	<td class="label"><fmt:message key="Common.FluidName.label" bundle="${common_labels}"/></td><td><INPUT TYPE="text" name="RF_NAME" id="RF_NAME" SIZE="65" MAXLENGTH="60"  value="<%=rfname%>"><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="ePH.BaseUnit.label" bundle="${ph_labels}"/></td>
	<td><select name="RF_BASE_UNIT" id="RF_BASE_UNIT" id="Base Unit"  >
	<%
	for(int i=0; i<base_uom.size();i++)
	{
		if (rfbaseuom.equals(base_uom.get(i)) )
		{
		%>
		<option value="<%=base_uom.get(i)%>"  selected><%=short_desc.get(i)%></option>
		<%
		}
			else
		{
		%>
		<option value="<%=base_uom.get(i)%>" ><%=short_desc.get(i)%></option>
		<%
		}
	}
	%>
	</select><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="4">&nbsp</td>
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input TYPE="hidden" name="Immodule_Yn" id="Immodule_Yn" value="<%=Immodule_Yn%>">
</form>


<%if(mode.equals("1"))
{%>

<script>	
	
	document.forms[0].RF_ID.focus();
	</script>
<%} 
	else{%>
<script>	
	
	document.forms[0].RF_NAME.focus();
	</script>
<%	}
%>


<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

