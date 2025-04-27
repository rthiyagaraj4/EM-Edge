<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <!-- Author - kumar: called from VisitRegistrationQuery.jsp if compute button is pressed-->
<%@ page import="java.sql.*, webbeans.eCommon.*" %>
<%@  page  contentType="text/html;charset=UTF-8" %>
 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String locale	= (String)session.getAttribute("LOCALE");
	
	try
	{

	con	=	ConnectionManager.getConnection(request);	
	//con = (Connection) session.getValue("connection" );
	request.setCharacterEncoding("UTF-8");
	
	String  billing_group		= request.getParameter("billing_group");
	String  billing_class		= request.getParameter("billing_class");
	String  pkg_serv_code   = request.getParameter("pkg_serv_code");
	String  gross_charge_amt   = request.getParameter("gross_charge_amt");
	String  disc_amt = request.getParameter("disc_amt");
	String  net_charge_amt   = request.getParameter("net_charge_amt");

	String blng_grp_desc = "";
	String blng_class_desc = "";
	String blng_serv_desc = "";

	try
	{
		pstmt  = con.prepareStatement("select short_desc from bl_blng_grp_lang_vw where language_id='"+locale+"' and blng_grp_id = '"+billing_group+"'");
		rs = pstmt.executeQuery();
		if (rs!= null)
		{
			if (rs.next())
			{
				blng_grp_desc = rs.getString(1);
			}
		}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}
	
	try 
	{
		pstmt  = con.prepareStatement("select short_desc from bl_blng_class_lang_vw where language_id='"+locale+"' and blng_class_code = '"+billing_class+"'");
		rs = pstmt.executeQuery();
		if (rs!= null)
		{
			if (rs.next())
			{
				blng_class_desc = rs.getString(1);
			}
		}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}

	try
	{
			pstmt  = con.prepareStatement("select short_desc from bl_blng_serv_lang_vw where language_id='"+locale+"' and blng_serv_code = '"+pkg_serv_code+"'");
			rs = pstmt.executeQuery();
			if (rs!= null)
			{
				if (rs.next())
				{
					blng_serv_desc = rs.getString(1);
				}
			}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (pstmt != null) pstmt.close();
		 if (rs != null)   rs.close();
	}

%>
<!--<frame name='f1' id='f1' frameborder=0 framespacing=0 scrolling='no'>-->
<html>
<head>
<!-- <title>Visit Charge Details</title> -->
	 <title><fmt:message key="eBL.VISIT_CHARGE_DTL.label" bundle="${bl_labels}"/></title>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="visit_details" id="visit_details" method=post action="">
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<!--
	<tr>
	<td class='label' colspan='10'>
		&nbsp;
	<td>
	</tr>

	<tr>
	<td class='label' colspan='10'>
		&nbsp;
	<td>
	</tr>
-->
	<tr>
	<td  class='label' width="25%"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td> 
	<td class="fields" width="25%"><input type='text' name='blng_grp_id' id='blng_grp_id' size='18' maxlength='15' readonly value="<%=blng_grp_desc%>"></td>
	<td  class='label' width="25%"><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td  class='fields' width="25%"><input type='text' name='blng_class_id' id='blng_class_id' size='18' maxlength='15' readonly value="<%=blng_class_desc%>"></td>
	</tr>

	<tr>
	<td class='label' width="25%"><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
	<td class="fields" width="25%"><input type='text' name='blng_serv_code' id='blng_serv_code' size='18' maxlength='15' readonly value="<%=blng_serv_desc%>"></td>
	<td class="label" width="25%"></td>
	<td class="label" width="25%"></td>
	</tr>
	
	<tr>
	<td  class='label' width="25%"><fmt:message key="eBL.GROSS_CHARGE.label" bundle="${bl_labels}"/></td>
	<td class="fields" width="25%"><input type='text' name='gross_charge' id='gross_charge' style='text-align:right' size='15' maxlength='15' readonly value="<%=gross_charge_amt%>"></td>
	<td  class='label' width="25%"><fmt:message key="eBL.DISCOUNT_AMT.label" bundle="${bl_labels}"/></td>
	<td class="fields" width="25%"><input type='text' name='discount' id='discount' size='15' style='text-align:right' maxlength='15' readonly value="<%=disc_amt%>"></td>
	</tr>

	<tr>
	<td  class='label' width="25%"><fmt:message key="eBL.NET_CHARGE.label" bundle="${bl_labels}"/></td>
	<td class="fields" width=25%"><input type='text' name='net_charge' id='net_charge' size='15' style='text-align:right' maxlength='15' readonly value="<%=net_charge_amt%>"></td>
	<td class="label" width="25%"></td>
	<td class="label" width="25%"></td>
	</tr>
<!--
	<tr>
	<td class='label' >
		
	<td>
	</tr>
	<tr>
	<td class='label' >
		
	<td>
	</tr>
-->
	<tr>
		<td class="button" ><input type="button" name="close" id="close" value = "<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class="Button" onClick="window.close();"></td>
	</tr>
<!--
		<tr>
	<td class='label' >
		
	<td>
	</tr>
-->
</table>
</form>
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
</body>
</html>
<%
	}
	catch(Exception ee)
	{
		out.println("Exception in main try"+ee);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	%>

<!--</frame>-->

