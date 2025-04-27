<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import=" eST.IssueBean, java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.IssuePreviewDetails.label" bundle="${st_labels}"/>   </title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/Issue.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)mode				=		"1";
	bean_id							=		"issueBean" ;
	bean_name						=		"eST.IssueBean";
	IssueBean bean					=		(IssueBean) getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals_temp			=			bean.getNoOfDecimals();
	int no_of_decimals				=			0;

	String classValue				=		"";
	String from_store_code			=		request.getParameter("from_store_code");
	String from_store_desc			=		bean.checkForNull(bean.getStore_desc(from_store_code));
	String to_store_code			=		request.getParameter("to_store_code");
	String to_store_desc			=		bean.checkForNull(bean.getStore_desc(to_store_code));
	String	item_class_code			=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );
	String item_class_desc			=		"";

	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
	{
		 item_class_desc			=		request.getParameter("item_class_desc");
	}
	else
	{
		 item_class_desc			=		bean.checkForNull(bean.getItem_class_desc(item_class_code));
	}
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_type_desc			=		bean.getDoc_type_desc(doc_type_code);
	String doc_date					=		request.getParameter("doc_date");
	String doc_ref					=		request.getParameter("doc_ref");
	String remarks					=		request.getParameter("remarks");
	String checkedbox				=		request.getParameter("checkedbox");
	String current_item				=		 "";
	String previous_item			=		"";

	boolean	BARCODE_YN			=   bean.isBarCodeApplicable(bean.getLoginFacilityId(),"URG"); 
	System.out.println("BARCODE_YN----------59-->"+BARCODE_YN);


 %>
</head>
<body>
<form name='formIssuePreviewDetails' id='formIssuePreviewDetails' >
	<br>
	<table border="0" cellpadding=0 cellspacing=0  width='100%' height=20 align=center>
	<tr>
		<td class=ITEMSELECT   width ="20%" nowrap> &nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b><%=doc_type_desc%> </td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b> <%=doc_date%></td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/>:</b> <%=doc_ref%> 	</td>
	</tr>
	<tr>
		<td class=ITEMSELECT   width ="20%" nowrap> &nbsp;&nbsp;&nbsp;<b><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/>: </b> <%=from_store_desc%> </td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/>:</b> <%= to_store_desc%> 	</td>
		<td class=ITEMSELECT   width ="20%" nowrap> <b><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>: </b> <%=item_class_desc%>
		</td>
	</tr>
	<tr>
			<td  class=ITEMSELECT wrap colspan='3'>&nbsp;&nbsp; <b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>:</b> <%=remarks%> </td>
		</tr>
	</table>
	<br>
	<div id='patinsID' style='width:710;height:350;overflow-y:auto;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
		<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
		<th  width="30%" style='WORD-BREAK:BREAK-ALL;'><fmt:message key="Common.item.label" bundle="${common_labels}"/>			</th>
		<th nowrap><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>	</th>
		<th nowrap><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>		</th>
		<th nowrap><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>		</th>
		<th nowrap><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/> </th>
		<th nowrap><fmt:message key="eST.ToStoreBin.label" bundle="${st_labels}"/> </th>
		</tr>
	<%	
	//int size							=		((HashMap)bean.getExpRecords()).size();
	int size							= 0;

	if (BARCODE_YN){
		size							=	((HashMap)bean.getExpRecordsforBarCode()).size();
	}
	else{
		size							=	((HashMap)bean.getExpRecords()).size();
	}

	int flag							=		0;
	int flag1							=		0;
	StringTokenizer stToken				=		null;
	ArrayList alDetailData				=       null;
	HashMap ht  = null;
	HashMap ht2 = null;
	for(i=0;i<size;i++)
	{
		//alDetailData	=	(ArrayList)bean.getExpRecords(i);

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
			ht							=		(HashMap)alDetailData.get(j);

			//ht2							=		(HashMap)bean.getDtlRecord(i);
			if (BARCODE_YN){
				ht2					=   (HashMap)bean.getDtlRecordforBarCode(i);
			}
			else{
				ht2					=   (HashMap)bean.getDtlRecord(i);
			}


			current_item				=		(String) ht2.get("item_code");
			//curr_item_cost_val		=		(String)ht2.get("item_cost_value");
			if(flag%2==0)classValue		=		"QRYEVEN";
			else classValue				=		"QRYODD";				
		%>
			<tr>
				<%if(current_item.equals(previous_item))
					{
			
					%>
					<td class="<%=classValue%>" width="30%" >&nbsp;</td>
				<%}
				else{
 	/**
	* @Name - Mahesh
	* @Date - 20/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
					if((bean.getAllowDecimalsYN(current_item)).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals = no_of_decimals_temp;
					}

				%>
					<td class="<%=classValue%>"   style='WORD-BREAK:BREAK-ALL;' width="30%"><%=ht2.get("item_desc")%> </td>
				<%}%>
			
			<td class="<%=classValue%>" ><%=com.ehis.util.DateUtils.convertDate((String)ht.get("EXPIRY_DATE"),"DMY","en",locale)%>&nbsp;</td>
			<td class="<%=classValue%>">   <%=ht.get("BATCH_ID")%>		&nbsp; </td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Qty.				
					-->
			<td class="<%=classValue%>" style="TEXT-ALIGN:right">   <%=bean.setNumber((String)ht.get("QTY"),no_of_decimals)%>	(<%=(String)ht2.get("uom_desc")%>)&nbsp; </td>	
			<td class="<%=classValue%>">  <%=ht.get("BIN_DESC")%>		&nbsp; </td>
			<td class="<%=classValue%>">  <%=bean.checkForNull(bean.getTo_Store_Bin_desc(((String)ht.get("TO_BIN_LOCATION_CODE")),to_store_code))%>&nbsp;</td>
		</tr>
	<%
			previous_item				=		current_item;
	//		pre_item_cost_val			=		curr_item_cost_val;
			flag++;		
		}
	  }	
	}
	%>
	</table>
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

