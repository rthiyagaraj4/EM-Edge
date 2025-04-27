<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/ConstituentPrecipitationLimit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
</head>
<%
String const_from_code			= request.getParameter("const_from_code") ;
String mol_from_code			= request.getParameter("mol_from_code") ;
String const_to_code			= request.getParameter("const_to_code") ;
String mol_to_code			= request.getParameter("mol_to_code") ;
String const_presc_limit_alert			= request.getParameter("const_presc_limit_alert") ;

String seq_no			= request.getParameter("seq_no") ;
String mode			= request.getParameter("mode") ;
//String alertYN			= request.getParameter("alertYN") ;
String const_from_code_min			= "" ;
String const_from_code_max			= "" ;

String const_to_code_min			= "" ;
String const_to_code_max			= "" ;

String const_pres_ind			= "" ;
String const_from_desc			= "" ;
String const_to_desc			= "" ;
String const_pres_alertYN			= "" ;
String alertYN			= "" ;
String const_genric_uom			= "" ;
String const_genric_uom_vol		= "" ;
int const_genric_uom_conv			= 0 ;

String locale			= (String)session.getAttribute("LOCALE");
ArrayList Const_Pres_Limit_Dtl=new ArrayList();

String bean_id					= "ConstituentPrecipitationLimitBean";
String bean_name				= "ePH.ConstituentPrecipitationLimitBean";
ConstituentPrecipitationLimitBean bean			= (ConstituentPrecipitationLimitBean)getBeanObject( bean_id,bean_name,request);
bean.setLanguageId(locale);
//Const_Pres_Limit_Dtl=bean.getConstituentPrecipitationLimitDetails(const_from_code,mol_from_code,const_to_code,mol_to_code,seq_no);
Const_Pres_Limit_Dtl=bean.getConstituentPrecipitationLimitDetails(seq_no);
if(Const_Pres_Limit_Dtl.size()>0)
{
const_from_desc=(String)Const_Pres_Limit_Dtl.get(0);
const_to_desc=(String)Const_Pres_Limit_Dtl.get(2);
mol_from_code=(String)Const_Pres_Limit_Dtl.get(1);
mol_to_code=(String)Const_Pres_Limit_Dtl.get(3);
const_from_code_min=(String)Const_Pres_Limit_Dtl.get(4);
const_from_code_max=(String)Const_Pres_Limit_Dtl.get(5);
const_to_code_min=(String)Const_Pres_Limit_Dtl.get(6);
const_to_code_max=(String)Const_Pres_Limit_Dtl.get(7);
const_pres_ind=(String)Const_Pres_Limit_Dtl.get(8);
const_from_code=(String)Const_Pres_Limit_Dtl.get(11);
const_to_code=(String)Const_Pres_Limit_Dtl.get(12);
const_genric_uom=(String)Const_Pres_Limit_Dtl.get(13);
const_genric_uom_conv=(Integer)Const_Pres_Limit_Dtl.get(14);

if(const_pres_ind.equals("W"))
	{
	const_pres_ind ="Warning";
	}
	else if(const_pres_ind.equals("E"))
	{
	const_pres_ind ="Error";
	}
	else
	{
	const_pres_ind ="Information";
	}

	const_pres_alertYN=(String)Const_Pres_Limit_Dtl.get(10);
	if(const_pres_alertYN.equals("E"))
	{
		alertYN="Checked";
	}else
	{
		alertYN="";
	}

		if(const_genric_uom_conv==100)
	{
		const_genric_uom_vol=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Perdecilitre.label","ph_labels");
	}else
	{
		const_genric_uom_vol=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PerLitre.label","ph_labels");;
	}

	
}










%>
	<body onMouseDown="" onKeyDown="lockKey()">



		<form name="FormConstituentPresLimitDisplayResult" id="FormConstituentPresLimitDisplayResult" >
			<table cellpadding="0" cellspacing="0" width="200%"  border='1'>
			<tr>
			<th width="15%"><fmt:message key="ePH.ConstituentGenericNameLimitingFrom.label" bundle="${ph_labels}"/></th>
			<th width="10%"><fmt:message key="ePH.MoleculeNameLimitingFrom.label" bundle="${ph_labels}"/></th>
			<th width="15%"><fmt:message key="ePH.ConstituentGenericNameLimitedTo.label" bundle="${ph_labels}"/></th>
			<th width="10%"><fmt:message key="ePH.MoleculeNameLimitedTo.label" bundle="${ph_labels}"/></th>
			<th width="10%"><fmt:message key="ePH.ConstituentConcentrationFrom.label" bundle="${ph_labels}"/><br><fmt:message key="ePH.RangeBetween.label" bundle="${ph_labels}"/></th>
			<th width="10%"><fmt:message key="ePH.ConstituentConcentrationTo.label" bundle="${ph_labels}"/><br><fmt:message key="ePH.RangeBetween.label" bundle="${ph_labels}"/></th>
			<th width="15%"><fmt:message key="ePH.PrecipitationIndicator .label" bundle="${ph_labels}"/></th>
			<th width="75%"><fmt:message key="ePH.PrecipitationAlertMessage.label" bundle="${ph_labels}"/></th>
			<th width="5%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
			<td><%=const_from_desc%></td>
			<td><%=mol_from_code%></td>
			<td><%=const_to_desc%></td>
			<td><%=mol_to_code%></td>
			<td><%=const_from_code_min%>&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;<%=const_from_code_max%>&nbsp;&nbsp;&nbsp;&nbsp;<%=const_genric_uom%>&nbsp;&nbsp;<%=const_genric_uom_vol%></td>
			<td><%=const_to_code_min%>&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;<%=const_to_code_max%>&nbsp;&nbsp;&nbsp;&nbsp;<%=const_genric_uom%>&nbsp;&nbsp;<%=const_genric_uom_vol%></td>
			<td><%=const_pres_ind%></td><td><%=const_presc_limit_alert%></td>
			<td><input type="checkbox" name="Con_Alert_YN" id="Con_Alert_YN" value="D" onChange="changeValue(this); " <%=alertYN%>></td>
			</tr>
					
		<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
		<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
		<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">		    
		<INPUT TYPE="hidden" name="const_from_code" id="const_from_code" VALUE="<%= const_from_code %>">		    
		<INPUT TYPE="hidden" name="mol_from_code" id="mol_from_code" VALUE="<%= mol_from_code %>">		    
		<INPUT TYPE="hidden" name="const_to_code" id="const_to_code" VALUE="<%= const_to_code %>">		    
		<INPUT TYPE="hidden" name="mol_to_code" id="mol_to_code" VALUE="<%= mol_to_code %>">		    
		<INPUT TYPE="hidden" name="seq_no" id="seq_no" VALUE="<%= seq_no %>">		    
			</table>
		</form>
	</body>
</html>

