<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencemodule.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" method="POST" action=''  >
<input type=hidden name=temp id=temp >
<%

boolean boolToggle =  true;	
String strTDClass = "";
String strModuleId = XHDBAdapter.checkNull(request.getParameter("moduleid"));
if(strModuleId==null) strModuleId="";
String strApplId = XHDBAdapter.checkNull(request.getParameter("applicationid"));
if(strApplId==null) strApplId="";
String strFacility = XHDBAdapter.checkNull(request.getParameter("facilityid"));
if(strFacility==null) strFacility="";
String strBeanName = XHMasterCodeControllerBean.strBeanName;

			// #MOD#03
			Connection conn = null;
			String strPrevious = "";
			String strNext ="";
			ArrayList arrRow = null;
			ArrayList arrCol = null;

			try
			{  
				conn = ConnectionManager.getConnection(request);
				XHMasterCodeControllerBean	xhBean = XHMasterCodeControllerBean.getBean(strBeanName,request,session);
				xhBean.action(request,conn);
				HashMap resultsQry = xhBean.getResultSet();
				arrRow = (ArrayList)resultsQry.get("qry_result"); 
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				 strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				 strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
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
				strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
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
	if('<%=strModuleId%>'==' ')
   alert(getMessage('XH1012','XH')+"For Module "+'<%=strModuleId%>'+"At EHIS");
  else alert(getMessage('XH1012','XH'));
</script>
<% } else { %>	
			
	<tr>
	<td colspan="4" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>
<tr>
	<td class='COLUMNHEADER' colspan=2 align=center width='19%'><fmt:message key="eXH.IBAeHis.Label" bundle="${xh_labels}"/></td>
   <td class='COLUMNHEADER' colspan=2 align=center width='50%'><fmt:message key="eXH.CrossReference.Label" bundle="${xh_labels}"/></td>

</tr>
<tr>
	<td class='COLUMNHEADER' align=center width='4%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' align=center width='15%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' align=center width='14%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' align=center width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
</tr>
</table>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
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
	<td <%=strTDClass%> align="center"  nowrap width='8%'>
	<%=arrCol.get(0)+""%> 
	</td>
	<td <%=strTDClass%> align="center" nowrap width='21%'>
	<%=arrCol.get(1)+""%>
	</td>
	<td <%=strTDClass%> align="center" nowrap width='20%'>
	<input type="text" size="20" name='<%=arrCol.get(0)+"_code"%>' id='<%=arrCol.get(0)+"_code"%>'  value='<%=arrCol.get(2)+""%>'  maxlength="20" >
	</td>
	<td <%=strTDClass%> align="center" nowrap width='30%'>
	<input type="text" size="60" name='<%=arrCol.get(0)+"_desc"%>' id='<%=arrCol.get(0)+"_desc"%>' temp='<%=arrCol.get(0)+"_code"%>' value='<%=arrCol.get(3)+""%>' maxlength="60" onBlur="chkvalidate(this)">
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
		out.println("ERROR="+e1.toString());
		e1.printStackTrace(System.err);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
	</table>
	<input type='hidden' name='action_type' id='action_type' value='U' >
	<input type='hidden' name='applicationid' id='applicationid' value='<%=strApplId%>'>
	<input type='hidden' name='moduleid' id='moduleid' value='<%=strModuleId%>'>
	<input type='hidden' name='facilityid' id='facilityid' value='<%=strFacility%>'>
</form>
</html>


