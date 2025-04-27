<!DOCTYPE html>
 <%@page import="eST.FileLine"%>
<%@page  import=" eST.PhysicalInventoryEntryBean,eST.Common.*,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head> 
		<title> </title>
<%
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
System.out.println("Inside File Detail");
String bean_id;
String bean_name;
String function_id;
//String avail_qty				=		"";
//String item_code				=		"";
String phy_inv_id				=		(String)request.getParameter("phy_inv_id");
String mode= CommonRepository.getCommonKeyValue("MODE_INSERT");
ArrayList allDetailData			=		new ArrayList();
function_id						=		request.getParameter( "function_id" ) ;
bean_id							=		"PhysicalInventoryEntryBean" ;
bean_name						=		"eST.PhysicalInventoryEntryBean";										
//HashMap expdtl				=		new HashMap();

PhysicalInventoryEntryBean bean =		(PhysicalInventoryEntryBean)getBeanObject( bean_id, bean_name,request );
System.out.println("bean"+bean);
bean.setLanguageId(locale);
bean.setMode( mode ) ;
allDetailData					=		bean.getFileDataList();
	
	%>	
	</head>
<body>
<form name='formPhysicalInventoryEntryFileDetail' id='formPhysicalInventoryEntryFileDetail' >
    <table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		
		<td width="20%" class="white">&nbsp;</td>
		</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
	<tr>
	<th ><fmt:message key="eST.ItemCode.label" bundle="${st_labels}"/> </th>
	<th ><fmt:message key="eST.ItemName.label" bundle="${st_labels}"/> </th>
	<th ><fmt:message key="eST.BatchID.label" bundle="${st_labels}"/> </th>
	<th ><fmt:message key="eST.BatchQuantity.label" bundle="${st_labels}"/> </th>
	<th ><fmt:message key="eST.BinLocationS.label" bundle="${st_labels}"/> </th>
	<th ><fmt:message key="eST.ExpiryDateS.label" bundle="${st_labels}"/> </th>
	<th ><fmt:message key="eST.Remarks.label" bundle="${st_labels}"/> </th>
	</tr>
   

			<%
			boolean unprocessed=false;
			System.out.println("In File Detail");
			    String classvalue="";
				ArrayList result = bean.getFileDataList();
				System.out.println("result ="+result);
				FileLine data = new FileLine();
				for (int i = 0; i < result.size(); i++) {
					data = (FileLine) result.get(i);
					if(data.getRemarks().equals("Data in wrong format"))
					{%>
						<script>alert("Unable to process the file")</script>
						<% unprocessed=true;
						break;
					}
				}
				if(unprocessed==false){
				for (int i = 0; i < result.size(); i++) {
					data = (FileLine) result.get(i);
					
					if ( i==0|| i% 2 == 0 )
						classvalue = "QRYEVEN" ;
					else
						classvalue = "QRYODD" ;
			%>
			<tr align='left'>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getItemCode()%></td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getItemName()%></td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getBatchId()%></td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getItemQuantity()%></td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getBinLocation()%></td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getExpiryDate()%></td>
				<td  class="<%=classvalue%>" style="TEXT-ALIGN: right">&nbsp;<%=data.getRemarks()%></td>
			</tr>
			<%
				}}
			%>
			    </table>
			    <input type='hidden' name='remark_count' id='remark_count'  value="<%=bean.getRemarks_count() %>" ></td>
			<%
				putObjectInBean(bean_id, bean, request);
			%>
</body>
</html>

