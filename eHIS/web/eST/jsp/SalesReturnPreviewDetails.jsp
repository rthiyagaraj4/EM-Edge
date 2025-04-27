<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"  import=" eST.SalesReturnBean,java.util.HashMap,java.util.ArrayList"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eST.SalesReturnPreviewDetails.label" bundle="${st_labels}"/> </title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i=0;
	String mode;
	String bean_id;
	String bean_name;

	mode						=		request.getParameter( "mode" ) ;
	if(mode==null){
		mode		=		"1";
	}
	
	java.util.Properties prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= prop.getProperty( "client_ip_address" );
	bean_id						=		"salesReturnBean"+login_at_ws_no;
	bean_name					=		"eST.SalesReturnBean";
	
	SalesReturnBean bean		=		(SalesReturnBean)getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);

	String classValue			=		"";
	String store_desc			=		bean.getStore_desc();
	String doc_type_desc		=		bean.getDoc_type_desc();

	String patient_name			=		request.getParameter("patient_name");
    String encounter_id			=		request.getParameter("encounter_id");
	String sal_trn_type_desc	=		request.getParameter("sal_trn_type_desc");
	String checkedbox			=		request.getParameter("checkedbox");

	
	String current_item			=		"";
	String previous_item		=		"";
	float gross_charge_amt		=       0.00f;
	float pat_net_amt			=       0.00f;
	String netchargeamt			=		"";
	String grosschargeamt		=		"";
	String billyn				=		(String)bean.getBLModuleInstalled();

	String uom_desc				=		"";
%>
	</head>
<body>
<form name='formSalesReturnPreviewDetails' id='formSalesReturnPreviewDetails'>
	<br>

	<table border=0 cellpadding=0 cellspacing=0  width='100%' height=20 align="center">
	<tr>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b>&nbsp<%=doc_type_desc%></td>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b>&nbsp<%=com.ehis.util.DateUtils.convertDate((String)bean.getDoc_date(),"DMY","en",locale)%></td>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b>&nbsp<%=store_desc%></td>
	</tr>
	<tr>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="eST.SaleTrnType.label" bundle="${st_labels}"/>:</b>&nbsp<%=sal_trn_type_desc%></td>
	<td class=ITEMSELECT  valign='top'><b><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>:</b>&nbsp<%=patient_name%></td>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>:</b>&nbsp<%=encounter_id%></td>
	</tr>
	</table>

	<br>
	<div id='patinsID' style='width:865;height:183;overflow-y:auto;overflow-x:auto'>
	<table border='1' cellspacing='0' cellpadding='0' width='100%' align="center">
	<%	if(billyn.equals("Y")){%>
	<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
			<th colspan=1>&nbsp;</th>
			<th colspan=2>	<fmt:message key="eST.PayableAmount.label" bundle="${st_labels}"/></th>
			<th colspan=5>&nbsp;</th>
			
	</tr>
	<%}%>
		<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
			<th ><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<%	if(billyn.equals("Y")){%>
			<th ><fmt:message key="Common.total.label" bundle="${common_labels}"/> </th>
			<th ><fmt:message key="eST.Patient.label" bundle="${st_labels}"/></th>
			<%}%>
			<th ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
			<th ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
			</tr>
		<%
	int size = ((HashMap)bean.getExpRecords()).size();
	ArrayList alDetailData		=	null;
	HashMap hmExpRecord			=	null;
	HashMap   alData					=	null;
	HashMap   ht2						=	null;
	int flag1							=		0;
	StringTokenizer stToken				=		null;
	boolean flag3=false;
	for(i=0;i<size;i++){
		alDetailData				=	(ArrayList)bean.getExpRecords(i);
		stToken			=	new StringTokenizer(checkedbox,"@");
		flag1							=		0;
		while (stToken.hasMoreTokens()) 
		{
			int a						=		Integer.parseInt(stToken.nextToken());
			if(a == i)		flag1		=		1;
		}
		alData					=	(HashMap)bean.getDtlRecord(i);
		if(flag1==0){
		for(int j=0;j<alDetailData.size();j++){
			hmExpRecord				=	(HashMap)alDetailData.get(j);
			ht2					=   (HashMap)bean.getDtlRecord(i);
			flag3=true;
			if(j%2==0)
				classValue	=	"QRYEVEN";
			else		
				classValue	=	"QRYODD";
			current_item					= (String)hmExpRecord.get("ITEM_DESC");
			if(billyn.equals("Y") && !current_item.equals(previous_item)){
			netchargeamt				=	((String)ht2.get("pat_net_amt"))==null?"0":((String)ht2.get("pat_net_amt"));
			grosschargeamt				=	((String)ht2.get("gross_charge_amt"))==null?"0":((String)ht2.get("gross_charge_amt"));
			gross_charge_amt=gross_charge_amt+Float.parseFloat(netchargeamt);   
			pat_net_amt=pat_net_amt+Float.parseFloat(grosschargeamt);  
					}
			uom_desc					=	(String)ht2.get("uom_desc");

			
			
	%>
	<tr>
	<%	 if(!current_item.equals(previous_item)){%>

			<td class="<%=classValue%>"  ><%=hmExpRecord.get("ITEM_DESC")%></td>
		<%	if(billyn.equals("Y")){%>
			<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=netchargeamt%></td>
			<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=grosschargeamt%></td> 
		<%}%>
			<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=ht2.get("item_qty")%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=uom_desc%></td>
	<%}else{%>
			<td class="<%=classValue%>"  >&nbsp;</td>
		<%	if(billyn.equals("Y")){%>
			<td class="<%=classValue%>" >&nbsp;</td>
			<td class="<%=classValue%>" >&nbsp;</td>
		<%}%>
			<td class="<%=classValue%>" >&nbsp;</td>
			<td class="<%=classValue%>" >&nbsp;</td>
	<%}%>

			
			<td class="<%=classValue%>" ><%=hmExpRecord.get("BATCH_ID")%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=hmExpRecord.get("TRADE_NAME")%>&nbsp;</td>
			<td class="<%=classValue%>" align='left' ><%=hmExpRecord.get("BIN_DESC")%>&nbsp;</td>
		</tr>
	
	<%
		previous_item		= current_item;
		
			
		}
		}
}
	
	%>
	<% 

	
	if(billyn.equals("Y") && flag3){%>
	<tr>
	
	
	
	<td><fmt:message key="Common.total.label" bundle="${common_labels}"/>
	
	<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=bean.setNumber(gross_charge_amt+"",2)%></td>
	<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=bean.setNumber(pat_net_amt+"",2)%></td>
	<td class="<%=classValue%>" colspan=6>&nbsp;</td>
	</tr>	
	<%}%>
	</table>
	</form>
</body>
</html>

