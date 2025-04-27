<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	
<% 
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<TITLE><fmt:message key="ePH.UOMDetails.label" bundle="${ph_labels}"/></TITLE>
</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" STYLE="overflow-y:hidden">

<%

	String uom_code	= request.getParameter( "code" ) ;
	String bean_id 			= "UomForFormBean" ;
	String bean_name 		= "ePH.UomForFormBean";
	String long_desc		=	"";
	String short_desc		=	"";
	String stock_yn			=	"";
	String purchase_yn		=	"";
	String sale_yn			=	"";
	String strength_yn		=	"";
	String qty_uom_yn		=	"";

	HashMap	uom_detail	=	null;

	/* Initialize Function specific start */
	UomForFormBean bean = (UomForFormBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	uom_detail			=  bean.getUomDetail(uom_code);
	if(uom_detail.size() > 1) {
		long_desc	=	(String)uom_detail.get("ldesc");
		short_desc	=	(String)uom_detail.get("sdesc");
		purchase_yn	=	(String)uom_detail.get("pur_yn");
		stock_yn	=	(String)uom_detail.get("stock_yn");
		sale_yn		=	(String)uom_detail.get("sale_yn");
		strength_yn	=	(String)uom_detail.get("strength_yn");
		qty_uom_yn	=	(String)uom_detail.get("qty_uom_yn");

	}
	

	/* Initialize Function specific end */


%>
<FORM name="formUomForForm" id="formUomForForm" ><BR>
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="0">
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD WIDTH="40%" CLASS="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></TD>
			<TD  WIDTH="60%" CLASS="label">&nbsp;&nbsp;<B><%=long_desc%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD WIDTH="40%" CLASS="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></TD>
			<TD WIDTH="60%" CLASS="label">&nbsp;&nbsp;<B><%=short_desc%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		</TABLE>
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="0">
		<TR>
			<Th COLSPAN="2" ><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></Th>
		</TR>
		<TR>
			<TD CLASS="label" WIDTH="40%"><fmt:message key="Common.Purchase.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" WIDTH="60%">&nbsp;&nbsp;<B><%=getImage(purchase_yn)%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD CLASS="label" WIDTH="40%"><fmt:message key="Common.Stock.label" bundle="${common_labels}"/></TD>
			<TD   CLASS="label" WIDTH="60%">&nbsp;&nbsp;<B><%=getImage(stock_yn)%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  CLASS="label"><fmt:message key="Common.Sale.label" bundle="${common_labels}"/></TD>
			<TD  CLASS="label">&nbsp;&nbsp;<B><%=getImage(sale_yn)%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  CLASS="label"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></TD>
			<TD  CLASS="label">&nbsp;&nbsp;<B><%=getImage(strength_yn)%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  CLASS="label"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label">&nbsp;&nbsp;<B><%=getImage(qty_uom_yn)%></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="2"  class="white" align="right" ><input type="button" value="Close"  class="button" onClick="parent.window.close()"></TD>
		</TR>
</TABLE>
</FORM>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</BODY>
</HTML>

