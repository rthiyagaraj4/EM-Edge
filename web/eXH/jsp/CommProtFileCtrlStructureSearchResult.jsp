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
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<!--
<script language='javascript' src='../../eXH/js/CommProtocolId.js'></script> -->
<script language='javascript' src='../../eXH/js/CommProtocolIdFileCtrlStr.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="APPL_RESULTS" id="APPL_RESULTS" method="POST" action=''  >

	<%
										 
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "COMMPROTFILECTRLSTRUCTURE";

		//	String srlno = "";
			String prot_id = "";
		//	String prot_name = "";
		//	String fileCtrlTyp = "";
		//	String sgmnt_id = "";
		//	String sgmnt_name = "";

			Connection conn = null;
			String whereClause = "WHERE  ";

			whereClause	=	whereClause+"A.PROTOCOL_ID=B.PROTOCOL_ID and A.SEGMENT_ID=C.SEGMENT_TYPE ";

			try
			{

				prot_id=request.getParameter("prot_id");
				//System.out.println("FileCtrlStr Rslt prot_id : "+prot_id);

				if(!(prot_id.equals(" "))){					
				  whereClause =whereClause + " AND A.PROTOCOL_ID = NVL('#prot_id',A.PROTOCOL_ID) ORDER BY 1" ;
 				} 
					//System.out.println("(CommProtFileCtrlStructureSearchResult.jsp:WhrCls)   :"+whereClause);

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04 
				request.setAttribute(XHQueryRender.col,"6");
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
	<td colspan="10" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="eXH.Protocol.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="eXH.FileCtrlType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='70%'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/></td>	
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
		//System.out.println("API Rslt arrCol.get(0) : "+arrCol.get(0));
	%>
	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' srlno='<%=arrCol.get(0)+""%>' 
	protocol_id='<%=arrCol.get(1)+""%>'	file_ctrl_type='<%=arrCol.get(2)+""%>' segment_type_id='<%=arrCol.get(3)+""%>' protocol_name='<%=arrCol.get(4)+""%>' segment_type='<%=arrCol.get(5)+""%>' >
	<%=arrCol.get(0)+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(4) %>
	</td>
	<td <%=strTDClass%> align="left"> 
	<%=""+arrCol.get(2) %>
	</td>
	<td <%=strTDClass%> align="left">
	<%=""+arrCol.get(5) %>
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


	<input type='hidden' name='srlno' id='srlno' value=''>
	<input type='hidden' name='protocol_id' id='protocol_id' value=''>
	<input type='hidden' name='protocol_name' id='protocol_name' value=''>
	<input type='hidden' name='file_ctrl_type' id='file_ctrl_type' value=''>
	<input type='hidden' name='segment_type_id' id='segment_type_id' value=''>
	<input type='hidden' name='segment_type' id='segment_type' value=''>

	<input type='hidden' name='prot_id' id='prot_id' value=<%=prot_id%>>

</form>
</html>


