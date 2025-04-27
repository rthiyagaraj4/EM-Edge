<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"  import=" eST.*,eST.Common.*,java.util.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
<%
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String pat_net_amt			=		"";
	String gross_charge_amt		=		"";
	String return_allowed_yn	=		"";
	int rec_high_no				=		-1;

	mode						=		request.getParameter( "mode" ) ;
	if(mode==null){	
		mode		=		"1";
	}
	function_id					=		request.getParameter( "function_id" ) ;

	if(request.getParameter("index") != null){
		rec_high_no				=		Integer.parseInt(request.getParameter("index"));
	}
	
	java.util.Properties prop	=		(java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		=		prop.getProperty( "client_ip_address" );
	bean_id						=		"salesReturnBean"+login_at_ws_no;
	bean_name					=		"eST.SalesReturnBean";

	SalesReturnBean bean		=		(SalesReturnBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	String cost_details_yn		=		bean.getAccessCostDetails();
/*Code added for SRR walk-thru on 3/3/2010*/
	StringTokenizer stRecordsToDelete	=	new StringTokenizer(bean.getRecords_to_delete(),",");
	String deleted				=		"";
	String billable_item_yn				=		"N";
/*Code added for SRR walk-thru on 3/4/2010*/
	String fontClass			=	"HYPERLINK";
	String curChange			=	"changeCursor(this);";
/*Code ended*/

	ArrayList alDetailData		=		new ArrayList(); 
	if(!bean.checkForNull((String)request.getParameter("sales_doc_no_flag")).equals("EMPTY")){
		alDetailData				=		bean.getDtlRecords();//bean.getDetailValues();
	}

%>
	</head>
<body>
<form name='formSalesReturnDetail' id='formSalesReturnDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 align="center">
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>

	<%
	String display_flag				=	"visibility:hidden";
	HashMap ht						=	null;
	//phy_inv_id=
	for(i=0;i<alDetailData.size();i++)
	{
		/*Code added for SRR walk-thru on 3/3/2010*/
			if(stRecordsToDelete.hasMoreTokens() && ((stRecordsToDelete.nextToken()).equals("Y"))){
				deleted = "checked";
				/*Code added for SRR walk-thru on 3/4/2010*/
				fontClass = "";
				curChange = "";
			}else{
				deleted = "";
				/*Code added for SRR walk-thru on 3/4/2010*/
				fontClass = "HYPERLINK";
				curChange = "changeCursor(this);";
			}
		/*Code ended*/
				String classValue		=		"";
			ht						=		(HashMap)alDetailData.get(i);
			return_allowed_yn		=		bean.checkForNull((String)ht.get("return_allowed_yn"));
			pat_net_amt				=		bean.checkForNull((String)ht.get("pat_net_amt"),"0") ;	
			gross_charge_amt		=		bean.checkForNull((String)ht.get("gross_charge_amt"),"0" );
			billable_item_yn		=		bean.checkForNull((String)ht.get("billable_item_yn"),"N" );
			if(cost_details_yn.equals("Y") && billable_item_yn.equals("Y")){
			display_flag			=		"visibility:visible";
			}
	
			if(i%2==0){
				classValue	=		"QRYEVEN";
			}
			else{		
				classValue	=		"QRYODD";
			}

			if(i == rec_high_no){
				classValue			=		"STLIGHTPINK";
			}
	if(((String)ht.get("item_qty")).equals("0") || return_allowed_yn.equals("N")){
%>
	<tr id="tr_<%=i%>">
		<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" checked disabled></td>
		<td width='268' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
		<font size=1><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=ht.get("item_qty")%>&nbsp;<span style=<%=display_flag%>>Return Amount:<%=gross_charge_amt%>&nbsp;&nbsp;</span></font>
		

	</tr>
<%}else{
		%>
	<tr id="tr_<%=i%>">
		<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=deleted%> onclick="disabledPreviwButton(this,'<%=i%>')"></td>
		<td width='268' class="<%=classValue%>" id="td_<%=i%>" style="WORD-BREAK:BREAK-ALL;" onmouseover="<%=curChange%>">
		<font size=1 class='<%=fontClass%>' id="font_<%=i%>" onclick="javascript:modifyData(<%=i%>);"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=ht.get("item_qty")%>&nbsp;<span style=<%=display_flag%>>Return Amount:<%=gross_charge_amt%>&nbsp;&nbsp;</span></font></a></font></a>
	
	</tr>
	<%}}
				//Added for GHL-CRF-0413 starts
				bean.getTempBatchRecords().clear();
				bean.getAlTempExpRecords().clear();
				//Added for GHL-CRF-0413 ends
				%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="return_allowed_yn" id="return_allowed_yn"		value="<%=return_allowed_yn%>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">

	</form>
</body>

<%if (request.getParameter("index")!=null) {%>
<script language="JavaScript">
	document.getElementById("font_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
	changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>
<script>
	/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - IN018239
 * @Desc - Sales Return Preview Details - web page showing wrongly.javascript function onclick="disabledPreviwButton()" is added   
			 
 */
	var count = 0;
	var totalCBox=document.formSalesReturnDetail.total_checkboxes.value;
	for (i = 0; i <= totalCBox - 1; i++) {
		if (eval("document.formSalesReturnDetail.checkbox" + i + ".checked")) {
			count=count+1;
		}
	}
	if(eval(count)==eval(totalCBox)){
		if(parent.frameSalesReturnHeader.document.formSalesReturnHeader!=null)
	parent.frameSalesReturnHeader.document.formSalesReturnHeader.preview.disabled=true;
	}
	</script>
</html>

