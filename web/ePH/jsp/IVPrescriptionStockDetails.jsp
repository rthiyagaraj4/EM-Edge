<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eST.Common.*, eCommon.Common.*" %>
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

	<script language="JavaScript" src="../../ePH/js/IVPrescription.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<title><fmt:message key="ePH.InsfStkNrlyExpItms.label" bundle="${ph_labels}"/></title>

</HEAD>
<%
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");

	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

	ArrayList drug_stock_dtls	=	bean.getDrugStockDtls();
//	String classValue			=	"";
	String drug_type			=	"";
	String called_from			=	request.getParameter("called_from");
	String change_title			=	"";
	String fluid_flag           =   bean.getFluidFlag();
    if(fluid_flag == null){fluid_flag="";}
	if(called_from!=null && called_from.equals("COMP")) {
		change_title	=	"Y";
	}
%>
<!-- Below table for Stock details-->
<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr>
		<td class="CURRTEXT">
		<marquee scrollamount="3"><font  style="font-weight:bold;color:black" size=1><fmt:message key="ePH.InsfStkExpItms.label" bundle="${ph_labels}"/></font></marquee>
		</td>
</tr>
</table>
<!--Insufficient stock message table ends-->
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
<%	if(change_title.equals("")) { %>
<tr>
	<th width="40%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="ePH.Drug/FluidName.label" bundle="${ph_labels}"/></th>
	<th width="5%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="ePH.Fluid/Ingredient.label" bundle="${ph_labels}"/></th>
	<th width="15%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
	<th width="25%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
	<th width="15%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="ePH.OrderedQuantity.label" bundle="${ph_labels}"/></th>
</tr>
<%	} else {	%>
<tr> 
	<th width="40%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
	<th width="15%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></th>
	<th width="25%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
	<th width="15%" style="background-color:#FFFFCC;font-size:9;color:black"><fmt:message key="ePH.OrderedQuantity.label" bundle="${ph_labels}"/></th>
</tr>
<%	}	%>

<%	int cnt	=	0;
	for ( int i=0; i<drug_stock_dtls.size(); i+=5) { 
//		if(cnt%2==0)
//			classValue	=	"QRYEVENSMALL";
//		else 
//			classValue	=	"QRYODDSMALL";
        if(drug_stock_dtls.get(i+1).equals("F") && fluid_flag.equals("N")){
			continue;
		}
		if(drug_stock_dtls.get(i+1).equals("F")) {
			drug_type	=	"Fluid";
		} else {
			drug_type	=	"Ingredient";
		}

%>
	<tr>
		<td class="white"><font size="1" color="red"><%=(String)drug_stock_dtls.get(i)%></font></td>
		<% if(change_title.equals("")) { %>
		<td class="white"><font size="1" color="red"><%=drug_type%></font></td>
		<%	}	%>
		<td class="white" ><font size="1" color="red"><b><%=(String)drug_stock_dtls.get(i+2)%></b></font></td>
		<td class="white" ><font size="1" color="red"><%=(String)drug_stock_dtls.get(i+4)%></font></td>
		<td class="white" ><font size="1" color="red"><%=(String)drug_stock_dtls.get(i+3)%></font></td>
	</tr>
<%	cnt++;
	}	
%>
</table>
<br>
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
<tr>
	<td class="white" ><input type="button" class="button" value= '<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close()"></td>
</tr>
</table>
</html>
<%
bean.setFluidFlag("");

putObjectInBean(bean_id,bean,request);

%>

