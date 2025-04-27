<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXI.*,eXI.XIDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXI/js/QueryTransaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<title>Document Details</title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="TRANSACTIONSTATUS_DETAILS" id="TRANSACTIONSTATUS_DETAILS" method="POST" action=''  >

	<%
										 
			boolean boolToggle =  true;	
			String strTDClass = "";
			String qry_id = "";
			String doc_type1 = "";
            String doc_type = "";
			String doc_no = "";
	//		String p_status = "";
			String colspan ="";
			Connection conn = null;
			String whereClause = " WHERE  ";

			String item_code = "";
			String store_code = "";
			String entered_by_id = "";
			String finalized_by_id = "";
			String from_date = "";
			String to_date = "";
			String statusval1 = "";



			whereClause	=	whereClause+"a.item_code = b.item_code  ";

			try
			{
				item_code =XIDBAdapter.checkNull(request.getParameter("item_code"));
//					System.out.println("QueryTransactionStatusDetailsResult item_code : "+item_code);			
				store_code =XIDBAdapter.checkNull(request.getParameter("store_code"));
//					System.out.println("QueryTransactionStatusDetailsResult store_code : "+store_code);	
				from_date =XIDBAdapter.checkNull(request.getParameter("from_date"));
//					System.out.println("QueryTransactionStatusDetailsResult from_date : "+from_date);			
				to_date =XIDBAdapter.checkNull(request.getParameter("to_date"));
//					System.out.println("QueryTransactionStatusDetailsResult to_date : "+to_date);			
				entered_by_id =XIDBAdapter.checkNull(request.getParameter("entered_by_id"));
//					System.out.println("QueryTransactionStatusDetailsResult entered_by_id : "+entered_by_id);			
				finalized_by_id =XIDBAdapter.checkNull(request.getParameter("finalized_by_id"));
//					System.out.println("QueryTransactionStatusDetailsResult finalized_by_id : "+finalized_by_id);			

				doc_type1=XIDBAdapter.checkNull(request.getParameter("doc_type1"));
//					System.out.println("QueryTransactionStatusDetailsResult doc_type1 : "+doc_type1);
				doc_type=XIDBAdapter.checkNull(request.getParameter("doc_type"));
//					System.out.println("QueryTransactionStatusDetailsResult doc_type : "+doc_type);
				doc_no =XIDBAdapter.checkNull(request.getParameter("doc_no"));
//					System.out.println("QueryTransactionStatusDetailsResult doc_no : "+doc_no);			
				statusval1 =XIDBAdapter.checkNull(request.getParameter("p_status"));
//					System.out.println("QueryTransactionStatusDetailsResult statusval1 : "+statusval1);	
   

	
			if(doc_type1.equals("RP")) {
//							System.out.println("doc_type RP");
							qry_id = "REQDTL";
							if(statusval1.equals("L") || statusval1.equals("C") ){
//								 whereClause = " AND STATUS_CODE=NVL('R',STATUS_CODE) ";
//								 System.out.println("QueryTransactionStatusDetailsResult 75 REQDTL : ");
 								 whereClause = " AND STATUS_DESC=NVL('#p_status',STATUS_DESC)  ";
							}
							else{
//								 System.out.println("QueryTransactionStatusDetailsResult 79 else : ");
								 whereClause = " AND STATUS_DESC=NVL('#p_status',STATUS_DESC) ";
							}

							 whereClause =whereClause + "  AND TO_CHAR(REQ_DATE,'DD/MM/YYYY') BETWEEN							NVL('#from_date', TO_CHAR(REQ_DATE,'DD/MM/YYYY')) AND NVL('#to_date',										TO_CHAR(REQ_DATE,'DD/MM/YYYY'))  AND  REQ_BY_ORGANIZATION_ID =NVL('#store_code',REQ_BY_ORGANIZATION_ID) AND  ITEM_CODE =NVL('#item_code',ITEM_CODE)	AND  REQ_NUM = NVL('#doc_no',REQ_NUM) AND  MODIFIED_BY_ID =NVL('#finalized_by_id',MODIFIED_BY_ID)  AND  ADDED_BY_ID =NVL('#entered_by_id',ADDED_BY_ID	) ORDER BY REQ_NUM ";
							request.setAttribute(XIQueryRender.col,"6");
							colspan = "6";
				}

				else if(doc_type1.equals("GRO")) {
//							System.out.println("doc_type RecWReq");
							qry_id = "RECWRD";
						    whereClause = " AND STATUS_DESC=NVL('#p_status',STATUS_DESC) ";
 							request.setAttribute(XIQueryRender.col,"4");
							colspan = "4";
				}
				else if(doc_type1.equals("GR")) {
//							System.out.println("doc_type RecWithout Req");
							qry_id = "RECWORD";
							whereClause = " AND STATUS_DESC=NVL('#p_status',STATUS_DESC) ";
							request.setAttribute(XIQueryRender.col,"4");
							colspan = "4";
				}
				else if(doc_type1.equals("GRNR")) {
//							System.out.println("doc_type Goods Returns");
							qry_id = "RETWGRND";
							 whereClause = " AND STATUS_DESC=NVL('#p_status',STATUS_DESC) ";
							request.setAttribute(XIQueryRender.col,"4");
							colspan = "4";
				}
				else if(doc_type1.equals("NR")) {
//							System.out.println("doc_type Normal Retruns");
							qry_id = "RETWOGRND";
							 whereClause = " AND STATUS_DESC=NVL('#p_status',STATUS_DESC) ";
							request.setAttribute(XIQueryRender.col,"4");
							colspan = "4";
				}

							if(!doc_type1.equals("RP")){
	 							 whereClause =whereClause + "  AND TO_CHAR(REQ_DATE,'DD/MM/YYYY') BETWEEN NVL('#from_date', TO_CHAR(REQ_DATE,'DD/MM/YYYY')) AND NVL('#to_date',TO_CHAR(REQ_DATE,'DD/MM/YYYY'))  AND  REQ_BY_ORGANIZATION_ID =NVL('#store_code',REQ_BY_ORGANIZATION_ID) AND  ITEM_CODE =NVL('#item_code',ITEM_CODE) AND  DOC_NO = NVL('#doc_no',DOC_NO) AND MODIFIED_BY_ID = NVL('#finalized_by_id',MODIFIED_BY_ID)  AND  ADDED_BY_ID =NVL('#entered_by_id',ADDED_BY_ID)	ORDER BY DOC_SRL_NO ";
							}

//				System.out.println("125 qry_id : "+qry_id);
				request.setAttribute(XIQueryRender.strQueryId,qry_id);
				// #MOD#04 
//				request.setAttribute(XIQueryRender.col,"6");
			    request.setAttribute(XIQueryRender.whereClause,whereClause);
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XIQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				}
				else
				{
					strNext  = " ";
				}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>

<%
//		System.out.println("arrRow.size() : "+arrRow.size());

if(arrRow.size()==0)
{
//	System.out.println("QueryTransactionStatusDetailsResult RowZs 0 ");
%>

<script>
//alert("APP-XI0021 Query caused no records to be retrived");
alert(getMessage('XH1021','XH'));
window.close();
</script>

<% } else { %>
	<tr>
	<td colspan="<%=colspan%>" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='10%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>	
	<% if(doc_type1.equals("RP")){
			%>
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="eXI.QtyFinalized.Label" bundle="${xi_labels}"/></td>	
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="eXI.QtyApproved.Label" bundle="${xi_labels}"/></td>	
<!--	<td class='COLUMNHEADER'  width='15%'><fmt:message key="eXI.QtyReceived.Label" bundle="${xi_labels}"/></td>	 -->
	<% }else if(doc_type1.equals("GR")||doc_type1.equals("GRO")){
			%>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="eXI.QtyReceived.Label" bundle="${xi_labels}"/></td>	
	<% } else  if(doc_type1.equals("GRNR") || doc_type1.equals("NR")){
			%>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="eXI.QtyIssued.Label" bundle="${xi_labels}"/></td>	
	<% } %>

</tr>




	<%
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
//		System.out.println("API Rslt arrCol.get(0) : "+arrCol.get(0));
	%>
	<tr>
	<td <%=strTDClass%> align="left"> 
	<%=""+XIDBAdapter.checkNull((String)arrCol.get(0))%>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+XIDBAdapter.checkNull((String)arrCol.get(1))%>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+XIDBAdapter.checkNull((String)arrCol.get(2)) %>
	</td>

	<% if(doc_type1.equals("RP")){
	%>
	<td <%=strTDClass%> align="left">
	<%=""+XIDBAdapter.checkNull((String)arrCol.get(3)) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+XIDBAdapter.checkNull((String)arrCol.get(4)) %>
	</td>
<!--	<td <%=strTDClass%> align="left">
	<%=""+XIDBAdapter.checkNull((String)arrCol.get(5)) %>
	</td> -->
	<% }  else if(doc_type1.equals("GR") || doc_type1.equals("GRO")){
	%>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(3) %>
	</td>
	<% }  else if(doc_type1.equals("GRNR") || doc_type1.equals("NR")){ %>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(3) %>
	</td>
	</tr>
	<%
	}
}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		System.out.println("QueryTransactionStatusDetailsResult Error: "+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>

	</table>

	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='action_type' id='action_type' value=''>


	<input type='hidden' name='s_no' id='s_no' value=''>
	<input type='hidden' name='item_code' id='item_code' value=''>
	<input type='hidden' name='item_desc' id='item_desc' value=''>
	<input type='hidden' name='ord_qty' id='ord_qty' value=''>
	<input type='hidden' name='app_qty' id='app_qty' value=''>
	<input type='hidden' name='rec_qty' id='rec_qty' value=''>
	<input type='hidden' name='doc_type1' id='doc_type1' value='<%=doc_type1%>'>
	

</form>
</html>


