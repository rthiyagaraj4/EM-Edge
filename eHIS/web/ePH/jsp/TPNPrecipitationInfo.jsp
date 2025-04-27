<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
     <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	 <script language="JavaScript" src="../../ePH/js/TPNWorkSheet.js"></script>
	 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	 String bean_id				= request.getParameter("bean_id");
	 String bean_name			= request.getParameter("bean_name");
	 String const_generic_code	= request.getParameter("const_generic_code");

 	TPNWorkSheetBean bean = (TPNWorkSheetBean)getBeanObject(bean_id,bean_name,request);
	ArrayList consPreciptateInfo = (ArrayList)bean.getConstPreciptInfo(const_generic_code);

	String const_genric_per_vol			= "";
	String const_genric_per_vol_desc	= "";
%>
<title>Constituent Precipitate Information </title>


<body style="background-color:#E2E3F0;" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="TpnConstGenericRemarks" id="TpnConstGenericRemarks" >
<table width='100%' border='1' cellspacing='0' cellpadding='0' align='center'>
	<tr>
		<td align='left' class='COLUMNHEADER' width='10%' nowrap >Constituent Generic Limiting frm</td>
		<td align='left' class='COLUMNHEADER' width='10%' nowrap >Constituent Generic Limiting to</td>
		<td align='left' class='COLUMNHEADER' width='10%' nowrap >Constituent Concern From</td>
		<td align='left' class='COLUMNHEADER' width='10%' nowrap >Constituent Concern To</td>
		<td align='left' class='COLUMNHEADER' width='10%' nowrap >Constituent Precipitate Alert Message</td>
	</tr>
	<%
	if(consPreciptateInfo != null && consPreciptateInfo.size()>0){
		for(int i=0;i<consPreciptateInfo.size(); i=i+14){
			const_genric_per_vol = (String)consPreciptateInfo.get(i+11);
			if(const_genric_per_vol.equals("100")){
				//const_genric_per_vol_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Perdecilitre.label","ph_labels");
				const_genric_per_vol_desc="Perdecilitre";
			}else{
//				const_genric_per_vol_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PerLitre.label","ph_labels");
				const_genric_per_vol_desc="PerLitre";
			}
			%>
			<tr>
	<!-- 			<td align='left' class='label' width='10%'>Calcium</td>
				<td align='left' class='label' width='10%'>Phosphates</td>
				<td align='left' class='label' width='10%'>10 mmol - 25 mmol</td>
				<td align='left' class='label' width='10%'>5 mmol -  12 mmol</td>
				<td align='left' class='label' width='10%'>Just take it yaar</td> -->

	 			<td align='left' class='label' width='10%' nowrap ><%=consPreciptateInfo.get(i+1)%></td>
				<td align='left' class='label' width='10%' nowrap ><%=consPreciptateInfo.get(i+3)%></td>
				<td align='left' class='label' width='10%' nowrap ><%=consPreciptateInfo.get(i+6)%> - <%=consPreciptateInfo.get(i+7)%> &nbsp;&nbsp; <%=consPreciptateInfo.get(i+10)%> &nbsp; <%=const_genric_per_vol_desc%></td>
				<td align='left' class='label' width='10%' nowrap ><%=consPreciptateInfo.get(i+8)%> - <%=consPreciptateInfo.get(i+9)%> &nbsp;&nbsp; <%=consPreciptateInfo.get(i+10)%> &nbsp; <%=const_genric_per_vol_desc%></td>
				<td align='left' class='label' width='10%' nowrap ><%=consPreciptateInfo.get(i+13)%></td>
			</tr>
		<%}
	}
	%>
</table>
<table width='100%' border='0' cellspacing='0' cellpadding='0' align='center'>
	<TR>
		<td class='label' colspan="10">&nbsp;</TD>
	</TR>
	<TR>
		<td class='label' colspan="10">
			<input type='Button' class='Button' name='Close' id='Close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();">
		</TD>
	</TR>
</table>
</body>

</html>

