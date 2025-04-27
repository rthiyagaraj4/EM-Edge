<!DOCTYPE html>
 <%@page  import=" eST.IssueReturnBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eST.IssueReturnPreviewDetails.label" bundle="${st_labels}"/></title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;

	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)	
	   mode							=		"1";

	bean_id							=		"issueReturnBean";
	bean_name						=		"eST.IssueReturnBean";

	eST.IssueReturnBean bean		=		(eST.IssueReturnBean)getBeanObject( bean_id,  bean_name,request );
	bean.setLanguageId(locale);
	String classValue				=		 "" ;
	String from_store_code			=		request.getParameter("from_store_code");
    String to_store_code			=		request.getParameter("to_store_code");
	String doc_type_code			=		request.getParameter("doc_type_code");
    String doc_date					=		request.getParameter("doc_date");
    String doc_ref					=		bean.checkForNull(request.getParameter("doc_ref"),"");
    String	item_class_code			=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );
	String  item_class_description	=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
	{
		 item_class_description		= (request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
		 
	}
	else
	{
		 item_class_description		= bean.getItem_class_description(item_class_code);
		 
	}
	String from_store_code_desc		=		bean.getFrom_store_description(from_store_code);
    String to_store_code_desc		=		bean.getTo_store_description(to_store_code);
	String doc_type_desc			=		bean.getDoc_type_description(doc_type_code);
    //String item_class_description	=		bean.getItem_class_description(item_class_code);
	String current_item			    =		"";
	String previous_item			=		"";

	//String curr_item_cost_val		=		"";
	//String pre_item_cost_val		=		"";
	int no_of_decimals=bean.getNoOfDecimals();
	String ret_qty="";
%>
	</head>
<body>
<form name='formIssueReturnPreviewDetails' id='formIssueReturnPreviewDetails'>
	<br>

	<table border=0 cellpadding=0 cellspacing=0  width='100%' height=20>
	<tr>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.DocType.label" bundle="${common_labels}"/>:</b>&nbsp<%=doc_type_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/>:</b>&nbsp<%=doc_date%></td>
    <td class=ITEMSELECT  ><b><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/>:<b>&nbsp;<%=doc_ref%></td>
	</tr>
	<tr>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/>:</b>&nbsp<%=from_store_code_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/>:</b>&nbsp<%=to_store_code_desc%></td>
	<td class=ITEMSELECT  ><b><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>:</b>&nbsp;<%=item_class_description%></td>
	</tr>
	</table>

	<br>
	<div id='patinsID' style='width:705;height:195;overflow-y:auto;overflow-x:no'>
	<table border='1' cellpadding='0' cellspacing='0' width='100%'  align=center>
	<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
	<th style='WORD-BREAK:BREAK-ALL;'  width="25%"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
    <th  ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>	</th>
	<th  ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th  ><fmt:message key="eST.ToBinLocation.label" bundle="${st_labels}"/></th>
	<th  ><fmt:message key="Common.ReturnQty.label" bundle="${common_labels}"/></th>
	</tr>
	<%
	int size = ((HashMap)bean.getExpRecords()).size();


ArrayList alDetailData  = null;
HashMap hmExpRecord		= null;
	for(i=0;i<size;i++){
		alDetailData= (ArrayList)bean.getExpRecords(i);
		for(int j=0;j<alDetailData.size();j++){
			hmExpRecord			=		(HashMap)alDetailData.get(j);
			if(j%2==0)classValue		=		"QRYEVEN";
			else classValue				=		"QRYODD";
			current_item				=		(String)hmExpRecord.get("ITEM_DESC");
			if(bean.getAllowDecimalsYN((String)hmExpRecord.get("ITEM_CODE")).equals("Y")){
			ret_qty=bean.setNumber((String)(hmExpRecord.get("QTY")==null?hmExpRecord.get("AVAIL_QTY"):hmExpRecord.get("QTY")),no_of_decimals);
			}else{
			ret_qty=bean.setNumber((String)(hmExpRecord.get("QTY")==null?hmExpRecord.get("AVAIL_QTY"):hmExpRecord.get("QTY")),0);

			}
			%>
			<%if(!current_item.equals(previous_item)){
			
			%>
			<tr>
			   <td class=ITEMSELECT  colspan=6 style='WORD-BREAK:BREAK-ALL;'><B>Item	:&nbsp;</b><%=hmExpRecord.get("ITEM_DESC")%></td>
            </tr>
			<%}%>
			<!--<td class="<%=classValue%>" ><%=hmExpRecord.get("EXPIRY_RECEIPT_DT")%>&nbsp;</td>-->
			<td class="<%=classValue%>" ><%=com.ehis.util.DateUtils.convertDate((String)hmExpRecord.get("EXPIRY_RECEIPT_DT"),"DMY","en",locale)%>&nbsp;</td>
			<td class="<%=classValue%>" ><%=hmExpRecord.get("BATCH_ID")%>&nbsp;&nbsp;</td>
			<td class="<%=classValue%>" ><%=hmExpRecord.get("TRADE_NAME")%>&nbsp;</td>
			<td class="<%=classValue%>"  ><%=bean.getBinLocation_desc((String)hmExpRecord.get("NEW_BIN_LOCATION_CODE"))%>&nbsp;&nbsp;</td>
			<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align ReturnQty.				
					-->
			<td class="<%=classValue%>"   style="TEXT-ALIGN:right"><%=ret_qty%>&nbsp;</td>
	</tr>
	<%
			previous_item				=		current_item;
			
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

