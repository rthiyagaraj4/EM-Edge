<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.HashMap,java.util.ArrayList, eST.SalesBean,eST.Common.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eST.Sales/PatientIssuesPreviewDetails.label" bundle="${st_labels}"/> </title>		
<%
		 request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/Sales.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	

	mode						=		request.getParameter( "mode" ) ;
	if(mode==null)	mode		=		"1";
	
	
	bean_id						=		"salesBean" ;
	bean_name					=		"eST.SalesBean";

	SalesBean bean				=		(SalesBean) getBeanObject( bean_id,  bean_name,request  );  
	bean.setLanguageId(locale);


	String classValue			=		"";
	String store_code		    =		request.getParameter("store_code");
	String store_desc		    =		bean.getStore_desc(store_code);
	String doc_type_code	    =		request.getParameter("doc_type_code");
	String doc_type_desc	    =		bean.getDoc_type_desc(doc_type_code);
	String patient_id		    =		request.getParameter("patient_id");
	String patient_name		    =		request.getParameter("patient_name");
	String encounter		    =		request.getParameter("encounter");
	String checkedbox			=		request.getParameter("checkedbox");
	
	String current_item		    =		"";
	String previous_item	    =		"";
	float gross_charge_amt		=	    0.00f;
	float pat_net_amt			=		0.00f;
	String netchargeamt			=		"";
	String grosschargeamt		=		"";
	String billyn				=		(String)bean.getBLModuleInstalled();
	String uom_desc				=		"";
	//DecimalFormat dfTest = new DecimalFormat("##.00");
	String trn_type				=	bean.checkForNull(bean.getTrn_type());
	String facility_id			=   bean.checkForNull(bean.getLoginFacilityId());
	boolean	BARCODE_YN			=   bean.isBarCodeApplicable(facility_id,trn_type); 
	System.out.println("BARCODE_YN----------59-->"+BARCODE_YN);
 %>
	</head>
<body>
<form name='formGrnPreviewDetails' id='formGrnPreviewDetails' >
	<br>
	<table border=2 cellpadding=0 cellspacing=0  width='100%' height=20 align="center">
	<tr>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b>&nbsp;<%=doc_type_desc%></td>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.DocDate.label"  bundle="${common_labels}"/>:</b>&nbsp;<%=bean.getDoc_date()%></td>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b>&nbsp;<%=store_desc%></td>
	</tr>
	<tr>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</b>&nbsp;<%=patient_id%> </td>
	<td class=ITEMSELECT valign='top' ><b><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>: </b>&nbsp;<%=patient_name%></td>
	<td class=ITEMSELECT nowrap valign='top'><b><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>:  </b>&nbsp;<%=encounter%></td>
	</tr>
	</table>
	<br>
	<div id='patinsID' style='width:865;height:183;overflow-y:auto;overflow-x:auto'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align="center" >
	<%	if(billyn.equals("Y")){%>
		<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
				<th colspan=1>&nbsp;</th>
				<th colspan=2>	<fmt:message key="eST.PayableAmount.label" bundle="${st_labels}"/></th>
				<th colspan=5>&nbsp;</th>
				
		</tr>
	<%}%>
		<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
			<th><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
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
		//int size							=	((HashMap)bean.getExpRecords()).size();
		int size							= 0;
		if (BARCODE_YN){
		size							=	((HashMap)bean.getExpRecordsforBarCode()).size();
		}
		else{
		size							=	((HashMap)bean.getExpRecords()).size();
		}
		//System.out.println("size--------->"+size);
		int flag							=	0;
		HashMap   alData					=	null;
		HashMap   ht						=	null;
		HashMap   ht2						=	null;
		ArrayList alDetailData				=	null;
		int flag1							=		0;
		StringTokenizer stToken				=		null;
		boolean flag3=false;

		for(i=0;i<size;i++)
		{
			//alData					=	(HashMap)bean.getDtlRecord(i);
			//alDetailData			=	(ArrayList)bean.getExpRecords(i);
			if (BARCODE_YN){
			alData					=   (HashMap)bean.getDtlRecordforBarCode(i);
			}
			else{
			alData					=	(HashMap)bean.getDtlRecord(i);
			}

			if (BARCODE_YN){
			alDetailData			=	(ArrayList)bean.getExpRecordsforBarCode(i);
			}
			else{
			alDetailData			=	(ArrayList)bean.getExpRecords(i);
			}


			stToken			=	new StringTokenizer(checkedbox,"@");
			flag1							=		0;
			while (stToken.hasMoreTokens()) 
			{
			int a						=		Integer.parseInt(stToken.nextToken());
			if(a == i)		flag1		=		1;
			}
			if(flag1==0){
			for(int j=0;j<alDetailData.size();j++)
			{
				ht					=	(HashMap)alDetailData.get(j);
				//ht2					=   (HashMap)bean.getDtlRecord(i);
				if (BARCODE_YN){
				ht2					=   (HashMap)bean.getDtlRecordforBarCode(i);
				}
				else{
				ht2					=   (HashMap)bean.getDtlRecord(i);
				}


				
				flag3=true;
				current_item				=	(String)ht2.get("item_desc");
				if(billyn.equals("Y") && !current_item.equals(previous_item)){
				netchargeamt				=	((String)ht2.get("pat_net_amt"))==null?"0":((String)ht2.get("pat_net_amt"));
				grosschargeamt				=	((String)ht2.get("gross_charge_amt"))==null?"0":((String)ht2.get("gross_charge_amt"));
				gross_charge_amt=gross_charge_amt+Float.parseFloat(netchargeamt);   
				pat_net_amt=pat_net_amt+Float.parseFloat(grosschargeamt);  
						}
				uom_desc					=	(String)ht2.get("uom_desc");
			
				if(flag%2==0 )classValue	=	"QRYEVEN";
				else 
							  classValue	=	"QRYODD";	   						
	%>
		<tr>
		<%if(current_item.equals(previous_item)) {%>
				<td class="<%=classValue%>" >&nbsp;</td>
			<%if(billyn.equals("Y")){%>
				<td class="<%=classValue%>" >&nbsp;</td>
				<td class="<%=classValue%>" >&nbsp;</td>
			<%}%>
				<td class="<%=classValue%>" >&nbsp;</td>
				<td class="<%=classValue%>" >&nbsp;</td>
		<%} else{%>
				<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;" ><%=ht2.get("item_desc")%></td>
			<%if(billyn.equals("Y")){%>
				<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=grosschargeamt%>&nbsp;</td>
				<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=netchargeamt%>&nbsp;</td> 
			<%}%>
				<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%=ht2.get("item_qty")%>&nbsp;</td>
				<td class="<%=classValue%>" ><%=uom_desc%></td>
		<%}%>
					 			
			<td class="<%=classValue%>" ><%=ht.get("BATCH_ID")%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=ht.get("TRADE_NAME")%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=ht.get("BIN_DESC")%>&nbsp;</td>		   	
		</tr>
	<%
		previous_item		= current_item;
		
		flag++;	
		}
		}	
	}
	%>
	<%	if(billyn.equals("Y") && flag3){%>
		<tr>
			<td class="<%=classValue%>" ><fmt:message key="Common.total.label" bundle="${common_labels}"/> 		
			<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%= bean.setNumber(pat_net_amt+"",2)%>&nbsp;</td>
			<td class="<%=classValue%>" style="TEXT-ALIGN:right"><%= bean.setNumber(gross_charge_amt+"",2)%>&nbsp;</td>
			<td class="<%=classValue%>" colspan=6>&nbsp;</td>
		</tr>	
	<%}%>
	</table>
	</div>
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

