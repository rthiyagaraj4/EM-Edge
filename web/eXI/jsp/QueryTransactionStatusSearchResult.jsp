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
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="TRANSACTIONSTATUS_RESULTS" id="TRANSACTIONSTATUS_RESULTS" method="POST" action=''  >

	<%
										 
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
//			String qry_id = "TRANSACTIONSTATUS";
			String qry_id = "";

			String statusval = "";
			String doc_type = "";
			String doc_type1 = "";
            String from_date = "";
            String to_date = "";
			String colspan = "";

			String store_code = "";
			String item_code = "";
            String org_id = "";
            String doc_no = "";
			String finalized_by_id = "";
			String entered_by_id = "";
	
			String p_status = "";
			String p_statusdesc = "";
			Connection conn = null;
			String whereClause = " WHERE  ";

			try
			{

				doc_type=XIDBAdapter.checkNull(request.getParameter("doc_type"));
				doc_type1 = doc_type;
	//				System.out.println("TransactionStatus Search doc_type : "+doc_type);
				from_date=XIDBAdapter.checkNull(request.getParameter("from_date"));
	//				System.out.println("TransactionStatus Search from_date : "+from_date);
				to_date=XIDBAdapter.checkNull(request.getParameter("to_date"));
	//				System.out.println("TransactionStatus Search to_date : "+to_date);
				statusval=XIDBAdapter.checkNull(request.getParameter("status"));
	//				System.out.println("TransactionStatus Search statusval : "+statusval);
				store_code=XIDBAdapter.checkNull(request.getParameter("store_code"));
	//				System.out.println("TransactionStatus Search store_code : "+store_code);
				item_code=XIDBAdapter.checkNull(request.getParameter("item_code"));
	//				System.out.println("TransactionStatus Search item_code : "+item_code);
				org_id=XIDBAdapter.checkNull(request.getParameter("org_id"));
	//				System.out.println("TransactionStatus Search to_date : "+org_id);
				doc_no=XIDBAdapter.checkNull(request.getParameter("doc_no"));
	//				System.out.println("TransactionStatus Search doc_no : "+doc_no);
				finalized_by_id=XIDBAdapter.checkNull(request.getParameter("finalized_by_id"));
	//				System.out.println("TransactionStatus Search finalized_by_id : "+finalized_by_id);
				entered_by_id=XIDBAdapter.checkNull(request.getParameter("entered_by_id"));
	//				System.out.println("TransactionStatus Search entered_by_id : "+entered_by_id);

   				if(doc_type.equals("RP")) {
	//						System.out.println("doc_type RP");
							qry_id = "REQHDR";
			//				 whereClause = " AND STATUS_CODE=NVL('#status',STATUS_CODE) ";
				}
				else if(doc_type.equals("GRO")) {
//							System.out.println("doc_type RecWReq");
							qry_id = "RECWRH";
			//				 whereClause = " AND STATUS_CODE=NVL('#status',STATUS_CODE) ";
				}
				else if(doc_type.equals("GR")) {
//							System.out.println("doc_type RecWithout Req");
							qry_id = "RECWORH";
			//				 whereClause = " AND STATUS_CODE=NVL('#status',STATUS_CODE) ";
				}
				else if(doc_type.equals("GRNR")) {
//							System.out.println("doc_type Goods Returns");
							qry_id = "RETWGRNH";
			//				 whereClause = " AND STATUS_CODE=NVL('#status',STATUS_CODE) ";
				}
				else if(doc_type.equals("NR")) {
//							System.out.println("doc_type Normal Retruns");
							qry_id = "RETWOGRNH";
			//				 whereClause = " AND STATUS_CODE=NVL('#status',STATUS_CODE) ";
				}
				
//						 whereClause =whereClause + "  AND TO_CHAR(REQ_DATE,'DD/MM/YYYY') BETWEEN  NVL('#from_date', TO_CHAR(REQ_DATE,'DD/MM/YYYY')) AND NVL('#to_date', TO_CHAR(REQ_DATE,'DD/MM/YYYY'))  AND  REQ_BY_ORGANIZATION_ID = NVL('#store_code',REQ_BY_ORGANIZATION_ID) AND  ITEM_CODE = NVL('#item_code',ITEM_CODE) AND  REQ_NUM = NVL('#doc_no',REQ_NUM) AND  MODIFIED_BY_ID = NVL('#finalized_by_id',MODIFIED_BY_ID)  AND  ADDED_BY_ID = NVL('#entered_by_id',ADDED_BY_ID) ORDER BY REQ_NUM ";
				
						 whereClause = " AND STATUS_CODE=NVL('#status',STATUS_CODE)  AND  req_date BETWEEN NVL (to_date('#from_date','dd/mm/yyyy'),req_date) AND NVL (to_date('#to_date','dd/mm/yyyy'),req_date)  AND  REQ_BY_ORGANIZATION_ID = NVL('#store_code',REQ_BY_ORGANIZATION_ID) AND  ITEM_CODE = NVL('#item_code',ITEM_CODE) AND  REQ_NUM = NVL('#doc_no',REQ_NUM) AND  MODIFIED_BY_ID = NVL('#finalized_by_id',MODIFIED_BY_ID)  AND  ADDED_BY_ID = NVL('#entered_by_id',ADDED_BY_ID) ORDER BY REQ_NUM ";

			
				request.setAttribute(XIQueryRender.strQueryId,qry_id);
				// #MOD#04 
				request.setAttribute(XIQueryRender.col,"6");
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
if(arrRow.size()==0)
{
%>

<script>
//alert("APP-XI0021 Query caused no records to be retrived");
alert(getMessage('XH1021','XH'));
</script>

<% } else { if(statusval.equals("")){ 
					colspan = "5";
					}else{
					colspan = "4";
					}%>
	<tr>
	<td colspan="5" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.StoreCodeFrom.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.Destination.label" bundle="${common_labels}"/></td>	
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
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
	//		System.out.println("API Rslt arrCol.get(4) : "+arrCol.get(4));

	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' doc_no='<%=arrCol.get(0)+""%>' 
	doc_date='<%=arrCol.get(1)+""%>'	 store_from='<%=arrCol.get(2)+""%>' destination='<%=arrCol.get(3)+""%>' p_status='<%=(String)arrCol.get(4)+""%>' doc_type='<%=arrCol.get(5)+""%>' doc_type1='<%=doc_type1%>'>
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(1) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(2) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(3) %>
	</td>
	<%
		if(!doc_type.equals("GR")) {
		%>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(4)%>
	</td>	<%
		}
		else{
			%>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(4)%>
	</td>	<%
		}
	%>
	</tr>
	<%
	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>

	</table>

	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='action_type' id='action_type' value=''>

	<input type='hidden' name='doc_no' id='doc_no' value='<%=doc_no%>'>
	<input type='hidden' name='doc_date' id='doc_date' value=''>
	<input type='hidden' name='store_from' id='store_from' value=''>
	<input type='hidden' name='destination' id='destination' value=''>
	<input type='hidden' name='p_status' id='p_status' value=''>
	<input type='hidden' name='item_code' id='item_code' value='<%=item_code%>'>
	<input type='hidden' name='store_code' id='store_code' value='<%=store_code%>'>
	<input type='hidden' name='entered_by_id' id='entered_by_id' value='<%=entered_by_id%>'>
	<input type='hidden' name='finalized_by_id' id='finalized_by_id' value='<%=finalized_by_id%>'>
	<input type='hidden' name='from_date' id='from_date' value='<%=from_date%>'>
	<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'>
	<input type='hidden' name='doc_type' id='doc_type' value='<%=doc_type%>'>	
	<input type='hidden' name='doc_type1' id='doc_type1' value='<%=doc_type1%>'>	

</form>
</html>


