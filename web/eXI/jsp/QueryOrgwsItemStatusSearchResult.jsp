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
<script language='javascript' src='../../eXI/js/QueryOrgwsItemStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="ORGWSITEMSTATUS_RESULTS" id="ORGWSITEMSTATUS_RESULTS" method="POST" action=''  >

	<%
										 
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "ORGWSITEMSTATUS";

			String item_code = "";
            String item_catg = "";
            String org_id = "";
            String status = "";
			Connection conn = null;
			String whereClause = " WHERE  ";

			try
			{
				item_code=XIDBAdapter.checkNull(request.getParameter("item_code"));
	//				System.out.println("TransactionStatus Search item_code : "+item_code);
				item_catg=XIDBAdapter.checkNull(request.getParameter("item_catg"));
	//				System.out.println("TransactionStatus Search item_catg : "+item_catg);
				org_id=XIDBAdapter.checkNull(request.getParameter("org_id"));
	//				System.out.println("TransactionStatus Search org_id : "+org_id);
				status=XIDBAdapter.checkNull(request.getParameter("status"));
	//				System.out.println("TransactionStatus Search status : "+status);

		//	   whereClause =whereClause + " a.ITEM_CODE = b.ITEM_CODE AND ";

				if(!(item_code.equals(" ")))			
				{					
				  whereClause =whereClause + "  ITEM_CODE = NVL('#item_code',ITEM_CODE) ";
 				} 

				if(!(item_catg.equals(" ")))			
				{					
				  whereClause =whereClause + " AND XI_ITEM_CATEGORY_CODE= NVL('#item_catg',XI_ITEM_CATEGORY_CODE) "; 
				}

				if(!(org_id.equals(" ")))			
				{					
				  whereClause =whereClause + " AND ORGANIZATION_ID= NVL('#org_id',ORGANIZATION_ID) "; 
				}

				if(!(status.equals(" ")))			
				{					
				  whereClause =whereClause + " AND STOCK_AVAIL_YN= NVL('#status',STOCK_AVAIL_YN) "; 
				}

				request.setAttribute(XIQueryRender.strQueryId,qry_id);
				// #MOD#04 
				request.setAttribute(XIQueryRender.col,"5");
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

<% } else { %>
	<tr>
	<td colspan="5" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  width='15%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>	
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>	
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
		if(arrCol.get(4).equals("Y")){
			status = "Available";
		}
		else if(arrCol.get(4).equals("N")){
			status = "Not Available";
		}
	%>
	<tr>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(0) %>
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
	<td <%=strTDClass%> align="left">
	<%=""+status %>
	</td>
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


	<input type='hidden' name='item_code' id='item_code' value=''>
	<input type='hidden' name='item_desc value=' id='item_desc value=''>
	<input type='hidden' name='item_catg' id='item_catg' value=''>
	<input type='hidden' name='org_id' id='org_id' value=''>
	<input type='hidden' name='status' id='status' value=''>

</form>
</html>


