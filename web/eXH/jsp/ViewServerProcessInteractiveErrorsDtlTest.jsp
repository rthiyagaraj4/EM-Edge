<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
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
<script language="JavaScript">
//function callSort
function callSort(obj)
{
   var previousMode= this.document.forms[0].sortMode1.value ;
   if(previousMode=="A") this.document.forms[0].sortMode.value="D";
   if(previousMode=="D") this.document.forms[0].sortMode.value="A";	
   this.document.forms[0].orderbycolumns.value=obj;
   parent.f_query_detail.location.href="../../eCommon/html/blank.html";

   this.document.forms[0].action='../../eXH/jsp/ViewServerProcessInteractiveErrorsDtlTest.jsp?';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();

}
//function funShow
function funShow(obj)
{    
	this.document.forms[0].Appl_msg.value = obj.getAttribute('Appl_msg');
	this.document.forms[0].Err_msg.value = obj.getAttribute('Err_msg');
	this.document.forms[0].Appl_key.value = obj.getAttribute('Appl_key');
	var act = '../../eXH/jsp/ViewServerProcessInteractiveErrorsFooter.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
	
}
//function funSubmit
function funSubmit()
{
	var act = '../../eXH/jsp/ViewServerProcessInteractiveErrorsDtlTest.jsp?';
	this.document.forms[0].action = act;
	document.forms[0].sortMode.value="A";
	this.document.forms[0].target='f_query_add_mod';
	this.document.forms[0].submit();
}
//function funAction
function funAction(typ)
{
	document.forms[0].action_type.value = typ;
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	funSubmit();

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
boolean boolToggle =  true;	
String strTDClass = "";
String qry_id = "VIEWINTERACTIVESERVERERROR";
Connection conn = null;
try
{
	request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.col,"6");
	request.setAttribute(XHQueryRender.maxRec,"11");
	conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
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
	String sprocessid=request.getParameter("sprocessid"); 
	String sfacility=request.getParameter("sfacility");
	String smsg_dt1=request.getParameter("smsg_dt1");
	String smsg_dt2=request.getParameter("smsg_dt2");
	String mode=request.getParameter("sortMode");
	

%>

<form name="viewserver_process_errorsdtltect_form" id="viewserver_process_errorsdtltect_form">

<input  type="hidden" name=sprocessid value='<%=sprocessid%>' />
<input  type="hidden" name=sfacility value='<%=sfacility%>' />
<input  type="hidden" name=smsg_dt1 value='<%=smsg_dt1%>' />
<input  type="hidden" name=smsg_dt2 value='<%=smsg_dt2%>' />
<input  type="hidden" name=locale value='<%=locale%>' />
<input type="hidden" name="action_type" id="action_type" value='S'/>
<input type="hidden" name="temp" id="temp" value=''/>

<input type="hidden" name="Facility_Id" id="Facility_Id" id="Facility_Id" value=''/>
<input type="hidden" name="Facility_Name" id="Facility_Name" id="Facility_Name" value=''/>
<input type="hidden" name="Process_Id" id="Process_Id" id="Process_Id" value=''/>
<input type="hidden" name="Failed_Proc" id="Failed_Proc" id="Failed_Proc" value=''/>
<input type="hidden" name="Msg_No" id="Msg_No" id="Msg_No" value=''/>
<input type="hidden" name="Appl_msg" id="Appl_msg" id="Appl_msg" value=''/>
<input type="hidden" name="Err_msg" id="Err_msg" id="Err_msg" value=''/>
<input type="hidden" name="Msg_date" id="Msg_date" id="Msg_date" value=''/>
<input type="hidden" name="Appl_key" id="Appl_key" id="Appl_key" value="" />
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=''/>
<input type="hidden" name="sortMode" id="sortMode" id="sortMode2"/>
<input type="hidden" name="sortMode1" id="sortMode1" id="sortMode1" value='<%=mode%>'/>


<%
	
if(arrRow.size()==0)
{
%>
<script>
	alert(getMessage('XH1021','XH'));
</script>
<% } else { %>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td colspan="5" align="right" class="CAGROUP">
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	<A class='label' style='cursor:pointer' onClick="funAction('N')"><%=strNext%></A>
	</td>
</tr>
<tr>
	<td class="COLUMNHEADER"><a id='OPERATING_FACILITY_ID' href="javascript:callSort('OPERATING_FACILITY_ID');"><font color=white><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font></td> 
	<td class="COLUMNHEADER"><a id='PGM_ID'  href="javascript:callSort('PGM_ID');"><font color=white><fmt:message key="Common.Program.label" bundle="${common_labels}"/></font></td>
   	<td class="COLUMNHEADER"><a id='MSG_NUM'  href="javascript:callSort('MSG_NUM');"><font color=white><fmt:message key="eXH.MessageNumber.Label" bundle="${xh_labels}"/></font></td>
	<td class="COLUMNHEADER"><a id='MSG_DATE_TIME'  href="javascript:callSort('MSG_DATE_TIME');"><font color=white><fmt:message key="Common.MessageDate.label" bundle="${common_labels}"/></font></td>
	</tr>
<%
for (int j=0; j<arrRow.size();j++)
{
	arrCol = (ArrayList)arrRow.get(j);
	if (boolToggle == true)
	{
		strTDClass = "QRYEVEN";
		boolToggle =  false;
	}
	else
	{
		strTDClass = "QRYODD";
		boolToggle =  true;
	}

String msgdate=((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);
String strSysDate ="";
if(!msgdate.equals("")) strSysDate=com.ehis.util.DateUtils.convertDate(msgdate,"DMYHMS","en",locale);

String facility =(String)arrCol.get(1); if(facility.equals("null")) facility="";
String process=(String)arrCol.get(2); if(process.equals("null")) process="";
//System.out.println(" (String)arrCol.get(4) :"+(String)arrCol.get(4));
String msgNumber=(String)arrCol.get(4); if(msgNumber.equals("null")) msgNumber=new String("");
//System.out.println(" msgNumber :"+msgNumber);

%>

<td class='<%=strTDClass%>' align="center">
<a id="link" href='#' onClick='funShow(this)' Facility_Id='<%=arrCol.get(0)+""%>' Facility_Name='<%=arrCol.get(1)+""%>' Process_Id='<%=arrCol.get(2)+""%>'  Msg_No='<%=arrCol.get(3)+""%>'  Msg_date='<%=arrCol.get(4)+""%>' >
&nbsp;<%=facility%>
</a>
</b>
</td>
<td class='<%=strTDClass%>' align="center">&nbsp;<%=process%></td>
<td nowrap class='<%=strTDClass%>'>&nbsp;<%=msgNumber%></td>
<td class='<%=strTDClass%>' align="center">&nbsp;<%=strSysDate%></td>
</tr>
<%
}
}
if(resultsQry!=null)  resultsQry.clear();
if(arrCol!=null) arrCol.clear();
if(arrRow!=null)  arrRow.clear();
}
catch(Exception exception)
{
	System.out.println("EXCEPTION IN ViewServerProcessInteractiveErrorsDtlTest.jsp :"+exception.toString());
	exception.printStackTrace(System.err);
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


