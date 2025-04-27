<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.io.*,eOR.*, webbeans.eCommon.*,eCA.CommonCollectionUtils,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) props.getProperty("LOCALE");
	String bean_id = "Or_OrderEntryRptGrp" ;
	String bean_name = "eOR.OrderEntryReportGrouping";
	OrderEntryReportGrouping orderEntryGrpBean = (OrderEntryReportGrouping)getObjectFromBean(bean_id,bean_name,session);	
	//orderEntryGrpBean.setLanguageId(localeName);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language='javascript' src='../../eOR/js/OROrderEntryRepGrp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	
	//String sql="";
	//sString ordertypes="";
	//String ordertypecode="";
	String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");
	String cust_rep_grp_code=request.getParameter("cust_rep_grp_code")==null?"":request.getParameter("cust_rep_grp_code");
	String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
	String from = request.getParameter("from")==null?"0":request.getParameter("from");
	String to = request.getParameter("to")==null?"10":request.getParameter("to");;
	//int rowCount = 0;
	int maxRecord = 0;
	int start = 0;
	int end = 0;
	String error_msg = "";	
	end = Integer.parseInt(to);
	start = Integer.parseInt(from);	
	CommonCollectionUtils<String, String> orderTypeMap = null;
	List<String> order_type_lst = null;
	
	try 
	{		
		orderEntryGrpBean.loadOrderTypes(cust_rep_grp_code); 
		orderTypeMap = orderEntryGrpBean.getOrderTypes(order_category,mode,cust_rep_grp_code);		
		order_type_lst =  orderEntryGrpBean.getOrderTypes();
		
		maxRecord = orderTypeMap.size();	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	%>
<body>
<form name='OROrderentryreportgrp1' id='OROrderentryreportgrp1'>
<table cellpadding='0' cellspacing='0' width='50%' align='center'>
	<tr>
		<td class='white' width='100%'></td> 
		<td class='label' width='16%' align='right' nowrap>
			<%
				if ( !(start <= 1) )
					out.println("<A class='gridLink' href='../../eOR/jsp/OROrderEntryRepGrpDetail.jsp?from="+(start-10)+"&order_category="+order_category+"&mode="+mode+"&cust_rep_grp_code="+cust_rep_grp_code+"&to="+(end-10)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				if ( !( (end) >= maxRecord ) )
					out.println("&nbsp;<A class='gridLink' href='../../eOR/jsp/OROrderEntryRepGrpDetail.jsp?from="+(start+10)+"&order_category="+order_category+"&mode="+mode+"&cust_rep_grp_code="+cust_rep_grp_code+"&to="+(end+10)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
		</td>
	</tr>
</table>

<style>
    table {
        width: 60%;
        margin: 0 auto;
        border-collapse: separate; /* Prevents borders between individual cells */
        border-spacing: 0; /* Optional: removes space between cells */
    }

    td {
        padding: 3px;
    }

    .COLUMNHEADER {
        font-weight: bold;
    }

    /* Specific styles for the second table */
    .table-with-border {
        border: 1px solid black; /* Adds border to the table itself */
    }
</style>

<table class="table-with-border">
    <tr>
        <td class="COLUMNHEADER" width="30%" height="20" nowrap>
            <fmt:message key="eOR.ApplicableOrderType.label" bundle="${or_labels}"/>
        </td>
        <td class="COLUMNHEADER">
            <fmt:message key="Common.Applicable.label" bundle="${common_labels}"/> 
        </td>
    </tr>	
    <%
        try { 		
            if (orderTypeMap != null && orderTypeMap.size() > 0) {
                String orderType = ""; 
                String orderTypeDesc = ""; 
                List<String> orderTypeLst = orderTypeMap.keyList();
                int cnt = 1;
                for (int i = start; i < end; i++) {
                    if (i < orderTypeLst.size()) {
                        orderType = orderTypeLst.get(i);	
                        orderTypeDesc = orderTypeMap.get(orderTypeLst.get(i));									
    %>
                    <tr>
                        <td class="gridData" width="75%"><%= orderTypeDesc %></td>
                        <td class="gridData" width="25%">
                            <input type="checkbox" name="order_type_<%= cnt %>" id="order_type_<%= cnt %>" value="<%= orderType %>" onClick="setOrderType(this)" <% if (order_type_lst.contains(orderType)) { %>checked<% } %>>
                        </td>
                    </tr>
    <%
                        cnt++;
                    }	
                }	
            } else {
                error_msg = "NO_RECORD_FOUND_FOR_CRITERIA";
                out.println("<script>alert(getMessage('" + error_msg + "','Common'));</script>");						
                out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
            }
        } catch (Exception e) {
            System.out.println("Exception in OROrderEntryRepGrpDetail.jsp---" + e.toString());
            e.printStackTrace(System.err);
        }
    %>
</table>


<input type="hidden" name='finalcheck1' id='finalcheck1' value='<%=orderTypeMap.values()%>'/>
<input type="hidden" name='finalcheck' id='finalcheck' value='<%=orderTypeMap.keyList()%>'/>
</form>
</body>
</html>

	


	




