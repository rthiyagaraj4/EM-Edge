<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?			?				?					?
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
15/01/2018  IN065844       Sharanraj                       Ramesh G         ML-MMOH-CRF-1000
13/03/2018  IN066974		Sharanraj   				   Ramesh G 		OR-ML-MMOH-CRF-1000/03
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import ="java.sql.*,java.net.*,java.text.*,eOR.ViewOrder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!-- IN065844 starts -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!--IN065844 ends -->
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script type="text/javascript">
	function closew(){
		const dialogTag = parent.parent.document.getElementById("dialog_tag");
		dialogTag.close();
	}
</script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	
//IN065844 starts
	String bean_id1 = "Or_ViewOrder" ;
	String bean_name1 = "eOR.ViewOrder";
//IN065844 ends

 	String function_from = request.getParameter( "colval" ) ;
	String accssion_num = request.getParameter("accssion_num")==null?"":request.getParameter("accssion_num");
	//String orderId = request.getParameter( "orderId" ) ; //IN049419
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");//IN065844
	String lineId = request.getParameter("lineId")==null?"":request.getParameter("lineId" ) ; //IN049419
	String orderFormatAuditTrailYN = request.getParameter("orderFormatAuditTrailYN")==null?"":request.getParameter("orderFormatAuditTrailYN" ) ;//IN049419
	String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");//IN061961
	String catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");//IN061961
	String view_by = (request.getParameter("view_by")==null||request.getParameter("view_by").equals("null"))?"":request.getParameter("view_by");//IN061961
	String category_code = request.getParameter("ord_cat_code")==null?"":request.getParameter("ord_cat_code");//IN061961
	String order_category = request.getParameter("val1")==null?"":request.getParameter("val1");//IN061961
	int i=0;
	Connection conn  = null;
	PreparedStatement pstmt;
	ResultSet rs = null;
	String tempTable = "OR_ORDER_FIELD_VALUES_ACTION";
	if(!"".equals(lineId)){
		tempTable = "OR_ORDER_LINE_FLD_VAL_ACTION";
	}
//IN065844 Starts	
	ViewOrder bean1=(ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	String orgid="N";

	bean1.setLanguageId(localeName);
	orgid=bean1.orgordid(orderId);
	if("N".equals(orgid))
	{
		orgid=bean1.checkAmendOrder(orderId);
	}
//IN065844 ends
	
	String strsql1="SELECT COUNT(*) FROM OR_ORDER_AMEND_REASON A, "+tempTable+" B WHERE A.ORDER_ID=? AND A.ACTION_SEQ_NUM = B.ACTION_SEQ_NUM AND A.ORDER_ID = B.ORDER_ID";
	try
	{
		conn 	= ConnectionManager.getConnection(request);
		pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,orderId);
		rs		= pstmt.executeQuery();		
		
		if(rs.next())
		{
 			i = rs.getInt(1);
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
	}catch(Exception e){
		//out.println("Exception : "+e.getMessage());//COMMON-ICN-0181
		e.printStackTrace();	
	}finally{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}
	
 %>
<form name='view_order_btn' id='view_order_btn' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center class="gridComponentHolder">
	
	<tr>
		<td  width='48%' class='label' width="" style="vertical-align:middle">&nbsp;
			<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center id="bill_dtl" style="display:none">
				<tr>
					<td width='40%' class="gridData" width="60%" style='border-width: 1;text-align: right;font-size: 3%'><font class='label' size="10"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
					<td width='18%' class="gridData" style='border-width: 1;text-align: right;'><font class='label' size="2" size="1"><B><span id='actual_'>0.0</span>&nbsp;</B></font></td>
					<td width='18%' class="gridData" style='border-width: 1;text-align: right;'><font class='label' size="2" size="1"><B><span id='payable_'>0.0</span>&nbsp;&nbsp;&nbsp;</B></font></td>
					<td width='18%' class="gridData" style='border-width: 1;text-align: right;' id="pat_paid_" style="visibility:hidden"><font class='label' size="2" size="1"><B><span id='pat_payable_'>0.0</span>&nbsp;&nbsp;</B></font></td>
					<td width='6%' class="gridData" style='border-width: 0;text-align: right;'>&nbsp;</td>
					
		</tr>

		</table>
	
	</td>
<!--IN065844 Starts   -->
	<td width='28%' class='button'>
	<% 
	if(!orgid.equals("") && !orgid.equals("N") && function_from!=null && function_from.equals("View") ) //IN066974
		{
			%>
			
			<INPUT TYPE="button" id="viewAmendOrder" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAmndReason.label","or_labels")%>' class='button' onClick="viewAmend('<%=orderId%>','<%=orgid%>')"  >
		<%	
		}
	
		%>
		
	</td>
	
<!-- IN065844 ends -->
		<td  width='40%' class='button' align="right">
		<%
		
		//out.println("<script>alert('"+function_from+"');</script>");
		
		if(function_from!=null && function_from.equals("View")) 
		{ 
		%>
			 <INPUT TYPE="button" id="showhistory" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAuditTrail.label","or_labels")%>' class='button' onClick="showHistory('<%=accssion_num%>')" disabled>
		<% 
		}
		//IN049419 Start.
		if("Y".equals(orderFormatAuditTrailYN) && i>0) 
		{
		%>				
		<INPUT TYPE="button" id="orderFormatAuditTrail" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAuditTrail.label","or_labels")%>' class='button' onClick="orderFormatAuditTrails('<%=orderId %>','<%=lineId %>')">	
		<%
		}
		//IN049419 End.
		%>
		<INPUT TYPE="button" id="close" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onClick="toCloseTopShowModal();">
		</td>
	</tr>

</table>
<input type="hidden" name="order_cat_code" id="ord_cat_code" value=<%=category_code%>><!--IN061961 -->
<input type="hidden" name="order_catalog_code" id="order_catalog_code" value=<%=catalog_code%>><!--IN061961 -->
<input type="hidden" name="order_line_num"  id="order_line_num" value=<%=order_line_num%>><!--IN061961 -->
<input type="hidden" name="view_by"  id="view_by" value=<%=view_by%>><!--IN061961 -->
<input type="hidden" name="order_category" id="order_category" value=<%=order_category%>><!--IN061961 -->

</form>

</body>
</html>

