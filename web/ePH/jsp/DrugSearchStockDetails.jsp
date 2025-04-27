<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eST.Common.*, eCommon.Common.*, java.text.DecimalFormat,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../ePH/js/IVPrescription.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.AvlQtyInVrsDispLocn.label" bundle="${ph_labels}"/></title>

</HEAD>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String	bean_id		= request.getParameter("bean_id");
	String bean_name	= "ePH.DrugSearchBean";
	DrugSearchBean bean	 =	(DrugSearchBean)getBeanObject( bean_id,bean_name, request ) ;
    bean.setLanguageId(locale);
	String facility_id   = (String)session.getValue( "facility_id" );
	String item_code		=	request.getParameter("drug_code");
	String trade_code		=	request.getParameter("trade_code")==null?"":request.getParameter("trade_code");
	String curr_store_code	=	request.getParameter("curr_store_code")==null?"":request.getParameter("curr_store_code");
	String curr_store_desc	=	request.getParameter("curr_store_desc")==null?"":request.getParameter("curr_store_desc");
	if(curr_store_desc.indexOf('|') != -1)
		curr_store_desc = curr_store_desc.substring(0,curr_store_desc.indexOf('|'));
	
	String uom				=	bean.getStockUOM1(item_code);
	String qty_uom			=	bean.getUomDisplay(facility_id,uom);
//out.println("qty_uom===="+qty_uom);
	String drug_desc		=	request.getParameter("drug_desc");
	ArrayList stock_values	=	bean.showStockValues(item_code, trade_code);
	String store_code		=	bean.getStoreCode();
	String  classValue		=	"";
	int recno				=	0;
	boolean entered			=	false;
	String curr_store_qty	=	"0";
	//drug_desc = java.net.URLDecoder.decode(drug_desc);
	drug_desc = drug_desc;
	qty_uom = qty_uom==null?"":qty_uom;
//commented during PE By Naveen
	//bean.setNoOfDecimals();
	int noOfDecimals = bean.getNoOfDecimals();
	String decimalStringFormat = "#.";
	// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
	if(noOfDecimals == 0)
		decimalStringFormat = "#";
	for (int i=0;i<noOfDecimals;i++){
	   	decimalStringFormat += "#";
	}
	 DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);
	 
%>

<!--Insufficient stock message table ends-->
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1">
<%

if(stock_values.size()==0) { %>
<br><br><br>
<th  style="background-color:#FFFFCC;font-size:9;color:black"><%=drug_desc%> <fmt:message key="ePH.IsNtAvlbleAnyDispLocn.label" bundle="${ph_labels}"/></th>
<%	} else {	
		  //if(stock_values.contains(store_code)) { //changes made by abdul
		  if(stock_values.contains(curr_store_code)) {
			  //int index	=	stock_values.indexOf(store_code);
			  int index	=	stock_values.indexOf(curr_store_code);			  
			  if(stock_values.size() >= (index+2)) {
				  if(curr_store_code.equals((String)stock_values.get(index))){
					  curr_store_desc	=	(String)stock_values.get(index+1);
					   curr_store_qty	=	(String)stock_values.get(index+2);
					  if(curr_store_qty != null && !curr_store_qty.equals(""))
						{
							curr_store_qty = dfToInteger.format(Double.parseDouble(curr_store_qty));
						}
					 
				  }
			  }
		  }
%>
<tr>
	<th  style="background-color:#FFFFCC;font-size:9;color:black" colspan="2" align="left"><%=drug_desc%></th>
</tr>
<th colspan="2" align="left"><fmt:message key="ePH.CurrentDispenseLocation.label" bundle="${ph_labels}"/></th> 
<tr>
	<td class="<%=classValue%>"><%=curr_store_desc%>&nbsp;</td>
	<td class="<%=classValue%>"><%=curr_store_qty%>&nbsp;<%=qty_uom%></td>
</tr>
<%
	String currentMedicationQuantity = ""; 
	for(int i=0; i<stock_values.size(); i+=3) { 
			if(recno%2==0) {
				classValue	=	"QRYEVEN";
			} else {
				classValue	=	"QRYODD";
			}

		//if(!store_code.equals(stock_values.get(i))) { 
		if(!curr_store_code.equals(stock_values.get(i))) { 
			if(!entered) {
				entered	=	true;
%>
			<th colspan="2" align="left"><fmt:message key="ePH.OthDispLocn(s).label" bundle="${ph_labels}"/></th>
<%			}	%>
			<tr>
				<td class="<%=classValue%>"><%=stock_values.get(i+1)%></td>
				<%	currentMedicationQuantity = stock_values.get(i+2).toString();
					if(currentMedicationQuantity != null && !currentMedicationQuantity.equals(""))
						{
							currentMedicationQuantity = dfToInteger.format(Double.parseDouble(currentMedicationQuantity));
						}	
				%>
				<td class="<%=classValue%>"><%=currentMedicationQuantity%>&nbsp;<%=qty_uom%></td>
				
			</tr>
<%			recno++;	
		}
	}
	
}	
%>
</table>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

