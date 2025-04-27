<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html> 
<%@ page import="java.sql.*,java.util.*,eXB.*,webbeans.eCommon.ConnectionManager,eXB.XBDBAdapter,eXH.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eXB/js/XBMasterSetUp.js" ></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="XBMASTERSETUP_RESULTS" id="XBMASTERSETUP_RESULTS" method="POST" action=''  >

	<%
            String module_desc = "";
			boolean boolToggle =  true;	
			String strTDClass = "";

			String qry_id = "MASTERSETUP";
			Connection conn = null;
 
			try
			{				
				request.setAttribute(XBQueryRender.strQueryId,qry_id);
				request.setAttribute(XBQueryRender.col,"12");
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XBQueryRender.getResults(request,session,conn);
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
					strNext = " ";
				}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow.size()==0)
{
%>

<script>
	alert(getMessage("XH1021","XH"));history.go(-1);
</script>

<% } else { %>
	<tr>
	<td colspan="7" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
<!--	<td class='COLUMNHEADER'  width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td> -->

	<td class='COLUMNHEADER'  width='5%'>Module Type</td>
	<td class='COLUMNHEADER'  width='15%'>Module Type Desc</td>
	<td class='COLUMNHEADER'  width='15%'>Payer Group Desc</td>
	<td class='COLUMNHEADER'  width='20%'>Payer </td>
	<td class='COLUMNHEADER'  width='15%'>Policy Type </td>
	<td class='COLUMNHEADER'  width='10%'>Episode Type</td>
	<td class='COLUMNHEADER'  width='5%'>Enabled</td>
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
        String episode_typ = "";
		String enabled_yn = "";
		String policy_dsc = "";

		if(arrCol.get(8).equals("I")){
		    episode_typ = "Inpatient";
		}
		else if(arrCol.get(8).equals("O")){
		    episode_typ = "Outpatient";
		}
		else{
			episode_typ = "&nbsp";
		}

		if(arrCol.get(9).equals("Y")){
		    enabled_yn = "Yes";
		}
		else if(arrCol.get(9).equals("N")){
		    enabled_yn = "No";
		}

		policy_dsc = (String)arrCol.get(7);
//		System.out.println("policy_dsc : "+policy_dsc);
		if(policy_dsc.length()>19){
			policy_dsc = policy_dsc.substring(0,19);
		}
   
       String payer_cod = (String)arrCol.get(4);
	   String policy_cod = (String)arrCol.get(6);
	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' module_Id='<%=arrCol.get(0)+""%>' module_Name='<%=arrCol.get(1)+""%>' payer_group_code='<%=arrCol.get(2)+""%>' payer_group_desc='<%=arrCol.get(3)+""%>'
	payer_code='<%=arrCol.get(4)+""%>' payer_desc='<%=arrCol.get(5)+""%>'  policy_code='<%=arrCol.get(6)+""%>'
	policy_desc='<%=arrCol.get(7)+""%>' episode_type='<%=arrCol.get(8)+""%>' enabled_yn='<%=arrCol.get(9)+""%>' facility_Id='<%=arrCol.get(10)+""%>' facility_Name='<%=arrCol.get(11)+""%>''> 
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td  <%=strTDClass%> align="left" >
	     <% if(XBDBAdapter.checkNull((String)arrCol.get(1)).equals("")|| XBDBAdapter.checkNull((String)arrCol.get(1)).equals("null")){
				  module_desc = "&nbsp";
				}else{
					module_desc = XBDBAdapter.checkNull((String)arrCol.get(1));
				}
				%>
		<%=module_desc+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
			<%=XBDBAdapter.checkNull((String)arrCol.get(3))+""%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<% if(payer_cod.equals("*A")) { %>
				ALL
		<% } else { %>
				<%=XBDBAdapter.checkNull((String)arrCol.get(5)).equals("")?"&nbsp;":XBDBAdapter.checkNull((String)arrCol.get(5))+""%>
        <% } %>
	</td>
	<td  <%=strTDClass%> align="left" >
		<% if (policy_cod.equals("*A")) { %>
				ALL
		<% } else { %>
				<%= policy_dsc.equals("")?"&nbsp;": policy_dsc+""%>
        <% } %>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=episode_typ%>
	</td>
	<td  <%=strTDClass%> align="left" >
		<%=enabled_yn%>
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

	<input type='hidden' name='module_Id' id='module_Id' value=''>
	<input type='hidden' name='module_Name' id='module_Name' value=''>
	<input type='hidden' name='payer_group_code' id='payer_group_code' value=''>
	<input type='hidden' name='payer_group_desc' id='payer_group_desc' value=''>
	<input type='hidden' name='payer_code' id='payer_code' value=''>
	<input type='hidden' name='payer_desc' id='payer_desc' value=''>
	<input type='hidden' name='policy_code' id='policy_code' value=''>
	<input type='hidden' name='policy_desc' id='policy_desc' value=''>
	<input type='hidden' name='episode_type' id='episode_type' value=''>
	<input type='hidden' name='enabled_yn' id='enabled_yn' value=''>
	<input type='hidden' name='facility_Id' id='facility_Id' value=''>
	<input type='hidden' name='facility_Name' id='facility_Name' value=''>
</form>
</html>


