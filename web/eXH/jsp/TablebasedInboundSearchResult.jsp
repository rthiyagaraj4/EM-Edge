<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!--
<script language='javascript' src='../../eXH/js/QueryBasedInbound.js'></script> 
--> 
<script language='javascript' src='../../eXH/js/APIBasedInbound.js'></script> 
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="TableBasedDetailResult" id="TableBasedDetailResult" method="POST" action=''  >

	<%

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
//			String qry_id = "QUERYBASEDINBOUND";
				String qry_id = "TABLEBASEDINBOUND";
			
			String appl_id = "";
			String fac_id = "";
			String evnt_id = "";
			String sgmnt_id = "";
			String inb_api = "";

		//	String exec_nature = "";

			Connection conn = null;
			String whereClause = "WHERE  ";
/*
			whereClause	=	whereClause+"A.APPLICATION_ID=C.APPLICATION_ID AND "+
			"A.FACILITY_ID=D.FACILITY_ID AND A.EVENT_TYPE=E.EVENT_TYPE(+) "+
			"AND A.SEGMENT_ID = E.SEGMENT_TYPE (+) AND  A.INBOUND_API=B.API_CODE "+ "AND D.language_id='en' AND a.segment_ID = F.SEGMENT_TYPE "+
			"AND A.EVENT_TYPE = G.EVENT_TYPE ";
*/
//			whereClause	=	whereClause+" A.STANDARD_CODE=B.STANDARD_CODE(+) AND ";

			//System.out.println("QueryResult "+whereClause);
			try
			{
		
	
				fac_id=request.getParameter("fac_id");
				//System.out.println("QryBsdInb Rslt fac_id : "+fac_id);

				if(!(appl_id.equals(" "))){					
				  whereClause =whereClause + " A.APPLICATION_ID = NVL('#appl_id',A.APPLICATION_ID)";
 				} 

				if(!(fac_id.equals(" "))){					
				  whereClause =whereClause + " AND A.FACILITY_ID = NVL('#fac_id',A.FACILITY_ID)";
 				} 

				if(!(evnt_id.equals(" "))){					
				  whereClause =whereClause + " AND A.EVENT_TYPE = NVL('#evnt_id',A.EVENT_TYPE)";
 				} 
				
				if(!(sgmnt_id.equals(" "))){					
				  whereClause =whereClause + " AND A.SEGMENT_ID = NVL('#sgmnt_id',A.SEGMENT_ID)";
 				} 
				
				if(!(inb_api.equals(" "))){					
				  whereClause =whereClause + " AND A.INBOUND_API = NVL('#inb_api',A.INBOUND_API)";
 				} 

				whereClause	=	whereClause+" ORDER BY A.SRL_NO";

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"3");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","xh_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","xh_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","xh_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","xh_labels");
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
alert(getMessage('XH1021','XH'));
</script>

<% } else { %>
	<tr>
	<td colspan="3" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>

	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.ExecOrder.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.Table.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="eXH.SubAPI.Label" bundle="${xh_labels}"/></td>

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

	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' srl_no='<%=arrCol.get(0)+""%>'	table_name='<%=arrCol.get(1)+""%>' sub_api='<%=arrCol.get(2)+""%>' >
	
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>

	<td <%=strTDClass%> align="left"> 
	<%=""+XHDBAdapter.checkNull((String)arrCol.get(1)) %>
	</td>

	<td <%=strTDClass%> align="left"> 
	<%=""+XHDBAdapter.checkNull((String)arrCol.get(2)) %>
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

	<input type='hidden' name='srl_no' id='srl_no' value=''>
	<input type='hidden' name='table_name' id='table_name' value=''>
	<!--
	<input type='hidden' name='stnd_code' id='stnd_code' value=''>
	<input type='hidden' name='stnd_desc' id='stnd_desc' value=''> -->
	<input type='hidden' name='sub_api' id='sub_api' value=''>

	<input type='hidden' name='modl_name' id='modl_name' value=''>

	<input type='hidden' name='appl_id' id='appl_id' value=<%=appl_id%>>
	<input type='hidden' name='fac_id' id='fac_id' value=<%=fac_id%>>
	<input type='hidden' name='evnt_id' id='evnt_id' value=<%=evnt_id%>>
	<input type='hidden' name='sgmnt_id' id='sgmnt_id' value=<%=sgmnt_id%>>
	<input type='hidden' name='inb_api' id='inb_api' value=<%=inb_api%>>

</form>
</html>


