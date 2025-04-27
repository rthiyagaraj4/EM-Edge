<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/ViewDebugInformation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
	boolean boolToggle =  true;	
	String strTDClass = "";
	String qry_id = "VIEWPROCEDUREDEBUG";
	Connection conn = null;
	
	try
	{
		request.setAttribute(XHQueryRender.strQueryId,qry_id);
		request.setAttribute(XHQueryRender.col,"6");
		request.setAttribute(XHQueryRender.maxRec,"16");
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
		
		String vapplname=request.getParameter("vapplname"); 
		String vfacility=request.getParameter("vfacility");
	    String vmsgid=request.getParameter("vmsgid"); 
        String veventtype=request.getParameter("veventtype");
        String mode=request.getParameter("sortMode");
   
%> 

<form name="debug_info_procedure_form" id="debug_info_procedure_form">

<input type="hidden" name=vapplname id=vapplname value='<%=vapplname%>' />
<input type="hidden" name=vfacility id=vfacility value='<%=vfacility%>' />
<input type="hidden" name=vmsgid id=vmsgid value='<%=vmsgid%>' />
<input type="hidden" name=veventtype id=veventtype value='<%=veventtype%>' />
<input type="hidden" name="action_type" id="action_type" value=''/>

<input type="hidden" name="OPERATEDDATETIME" id="OPERATEDDATETIME" id="OPERATEDDATETIME" value=""/>
<input type="hidden" name="OPERATEDBY" id="OPERATEDBY" id="OPERATEDBY" value=""/>
<input type="hidden" name="INVOKEPRODUCTNAME" id="INVOKEPRODUCTNAME" id="INVOKEPRODUCTNAME" value=""/>
<input type="hidden" name="PROCESSID" id="PROCESSID" id="PROCESSID" value=""/>
<input type="hidden" name="PROCEDURENAME" id="PROCEDURENAME" id="PROCEDURENAME" value=""/>
<input type="hidden" name="PROCEDUREPARAMETER" id="PROCEDUREPARAMETER" id="PROCEDUREPARAMETER" value=""/>

<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=''/>
<input type="hidden" name="sortMode" id="sortMode" id="sortMode2"/>
<input type="hidden" name="sortMode1" id="sortMode1" id="sortMode1" value='<%=mode%>'/>

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
	<td colspan="5" align="right" class="CAGROUP" >
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>

	<tr>
	<td class='COLUMNHEADER' width='25%'><a name='OPERATED_DATE_TIME' id='OPERATED_DATE_TIME' href="javascript:callSort('OPERATED_DATE_TIME');" ><font color=white><fmt:message key="eXH.OperatedDate.Label" bundle="${xh_labels}"/></font></td> 
	<td class='COLUMNHEADER' width='15%'><a name='OPERATED_BY' id='OPERATED_BY'  href="javascript:callSort('OPERATED_BY');" ><font color=white><fmt:message key="eXH.OperatedBy.Label" bundle="${xh_labels}"/></font></td>
   	<td class='COLUMNHEADER' width='10%'><a name='INVOKE_PRODUCT_NAME' id='INVOKE_PRODUCT_NAME' href="javascript:callSort('INVOKE_PRODUCT_NAME');" ><font color=white><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></font></td>
	<td class='COLUMNHEADER' width='10%'><a name='PROCESS_ID' id='PROCESS_ID'  href="javascript:callSort('PROCESS_ID');" ><font color=white><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></font></td>
	<td class='COLUMNHEADER' width='25%'><a id='PROCEDURE_NAME' id='PROCEDURE_NAME'  href="javascript:callSort('PROCEDURE_NAME');" ><font color=white><fmt:message key="Common.ProcessName.label" bundle="${common_labels}"/></font></td>
	
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

	
	String opertedDate="";
	String stropertedDate="";
	opertedDate=((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);
	if(!opertedDate.equals("")) stropertedDate =com.ehis.util.DateUtils.convertDate(opertedDate,"DMYHMS","en",locale);

	%>
	<tr>
	<td <%=strTDClass%> align="center">
	<a id="ref" name="ref" href='#' onClick='funShow(this)' OPERATEDDATETIME='<%=arrCol.get(0)+""%>' OPERATEDBY='<%=arrCol.get(1)+""%>' INVOKEPRODUCTNAME='<%=arrCol.get(2)+""%>' PROCESSID='<%=arrCol.get(3)+""%>' PROCEDURENAME='<%=arrCol.get(4)+""%>' PROCEDUREPARAMETER='<%=arrCol.get(5)+""%>'>
   &nbsp; <%=stropertedDate+""%>
	</a>
	</b>
	</td>
	<td <%=strTDClass%> align="center">&nbsp; <%=((String)arrCol.get(1)).equals("null")?"":arrCol.get(1)%></td>
	<td <%=strTDClass%> align="center">&nbsp; <%=((String)arrCol.get(2)).equals("null")?"":arrCol.get(2)%></td>
	<td <%=strTDClass%> align="center">&nbsp;<%=((String)arrCol.get(3)).equals("null")?"":arrCol.get(3)%></td>
	<td <%=strTDClass%> align="center">&nbsp; <%=((String)arrCol.get(4)).equals("null")?"":arrCol.get(4)%></td>
	</tr>
	<%
	}
	}
    if(arrRow!=null) arrRow.clear();
    if(arrCol!=null) arrCol.clear();
    if(resultsQry!=null)  resultsQry.clear();

    }catch(Exception e1)
	{
		out.println("Error="+e1);
		e1.printStackTrace(System.err);
	}
	finally
	{
		
		ConnectionManager.returnConnection(conn);
	}
	%>
</table>
</form>	
</BODY>
</HTML>

