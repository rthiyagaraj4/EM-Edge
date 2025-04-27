<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,java.sql.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String drug_name = request.getParameter("drug_name");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/> - <%=drug_name%></title>
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frmDiscCancelledDrugDetails" id="frmDiscCancelledDrugDetails">
<%
		try{
			String bean_id = "DispMedicationBean";
			String bean_name = "ePH.DispMedicationBean";
			DispMedicationBean bean = (DispMedicationBean) getBeanObject(bean_id, bean_name, request);
			bean.setLanguageId(locale);
			String disc_cancelled_orders	=	request.getParameter("disc_cancelled_orders")==null?"":request.getParameter("disc_cancelled_orders");
			int recCount=0;
			String classvalue="";
			StringTokenizer stDisCanOrderIds = null;
			if(disc_cancelled_orders.indexOf("##")!= -1)
				stDisCanOrderIds =	new StringTokenizer(disc_cancelled_orders,"##");
			else
				stDisCanOrderIds = new StringTokenizer(disc_cancelled_orders);
			StringTokenizer stDisCanOrders = null;
			StringBuilder sbDiscCancellesOrderIds = new StringBuilder();
			while(stDisCanOrderIds.hasMoreTokens()){
				stDisCanOrders = new StringTokenizer(stDisCanOrderIds.nextToken(),"~");
				if(stDisCanOrders.hasMoreTokens()){
					if(sbDiscCancellesOrderIds.length()>0)
						sbDiscCancellesOrderIds.append(", ");
					sbDiscCancellesOrderIds.append("( '"+stDisCanOrders.nextToken()+"', '"+stDisCanOrders.nextToken()+"' )");
				}
			}
			ArrayList discCancelledOrderDetails = bean.getDiscCancelledOrderDetails(sbDiscCancellesOrderIds.toString());
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="tblDiscCancelledDrugDetails">
				<tr>
					<td class='COLUMNHEADER' nowrap width='10%'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' nowrap width='20%'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' nowrap width='10%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' nowrap width='10%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' nowrap width='15%'>&nbsp;<fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='COLUMNHEADER' nowrap width='15%'>&nbsp;<fmt:message key="ePH.DiscCancellingPract.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class='COLUMNHEADER' nowrap width='20%'>&nbsp;<fmt:message key="ePH.DiscCancelReason.label" bundle="${ph_labels}"/>&nbsp;</td>
				</tr>
<%
					for(int i=0; i<discCancelledOrderDetails.size(); i+=9){ 
						if ( recCount % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;
%>
						<TR>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i)%>&nbsp;</td>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i+1)%>&nbsp;</td>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i+2)%>&nbsp;</td>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i+3)%>&nbsp;</td>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i+4)%>&nbsp;</td>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i+6)%>&nbsp;</td>
							<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)discCancelledOrderDetails.get(i+8)%>&nbsp;</td>
						</TR>
<%
					recCount++;
				}
%>
			</table>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="tblDiscCancelledDrugDetails">
				<tr>
					<td colspan='7' >&nbsp;</td>
				</tr>
				<tr>
					<td colspan='7' >&nbsp;</td>
				</tr>
				<tr align="right">
				<td colspan='6' class='label'>&nbsp;</td>
				<td class='button'>
				<input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick="window.close();" name="close" ></input></td>
				</tr>
			</table>
<%
			putObjectInBean(bean_id, bean, request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
</html>

