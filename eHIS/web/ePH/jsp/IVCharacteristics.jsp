<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DiscontinueDrug.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 

<%

	String	bean_id			=	"DrugDetailsBean" ;
	String	bean_name		=	"ePH.DrugDetailsBean";


DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
 //bean.getIVCharacteristics();



%>
<form name="DiscontinueDrugDetailsDosageDispensing" id="DiscontinueDrugDetailsDosageDispensing" >
<table cellpadding="1" cellspacing="0" width="30%"  align="center" border="0">
<BR><BR><BR><BR><BR><BR><BR><BR>
<tr>
	<th colspan="2"><fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></th>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="ePH.IVIngradients.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td  class="label" ><B><%=getImage(bean.getIV_INGREDIENT_YN())%></B></TD>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td  class="label" ><B><%=getImage(bean.getIV_FLUID_YN())%></B></TD>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td  class="label" >
<B><%=bean.getINFUSE_OVER_VALUE()%></B>&nbsp;
<B><%=bean.getINFUSE_OVER_DURN_TYPE()%></B>
</TD>
</tr>

</table>
</FORM>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
}
%>

</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>

