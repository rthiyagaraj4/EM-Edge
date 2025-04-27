<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/offlinegatewayschduling.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>											    
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="chkvalidate()">

<form name="comm_process_sleep_parameter_form" id="comm_process_sleep_parameter_form" method='post' target='' action=''>
<input type=hidden name=action_type>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
    <td class='COLUMNHEADER' align=center>Protocol Link</td>
	<td class='COLUMNHEADER' align=center><fmt:message key="eXH.Type.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  align=center><fmt:message key="eXH.Month.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' align=center><fmt:message key="eXH.Day.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  align=center><fmt:message key="eXH.DateNumber.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' align=center><fmt:message key="eXH.FromSleepTime.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  align=center><fmt:message key="eXH.ToSleepTime.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  align=center><fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/></td>
</tr>
<% 
Connection con=null;
XHSelectQuery xhSelect = null;
ArrayList arrRow = null,arrCol = null;
HashMap hashmpParams = null;
int size = 0;
String sql ="SELECT SLEEP_TYPE,SLEEP_MONTH,SLEEP_DAY,SLEEP_DATE_NO,TO_CHAR(FROM_SLEEP_TIME,'HH24:MI'),"+
" TO_CHAR(TO_SLEEP_TIME,'HH24:MI') ,ROWID FROM XH_GATEWAY_SLEEP_PARAM";
try
{
con=ConnectionManager.getConnection(request);
xhSelect = new XHSelectQuery();
hashmpParams = new HashMap(5);
hashmpParams.put("connection",con);
hashmpParams.put("sql",sql);
hashmpParams.put("col","7");
arrRow = xhSelect.getResults(hashmpParams);
arrCol = null;	
xhSelect = null;
hashmpParams.clear();

size = arrRow.size();
}catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }
%>
<%
boolean boolToggle =  true;	
String strTDClass = "";

for(int i=0;i<arrRow.size();i++)
{
	arrCol = (ArrayList)arrRow.get(i);

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

String status_msg="";
String int_status="";
status_msg=(String)arrCol.get(0); if(status_msg==null) status_msg="";
if(status_msg.equalsIgnoreCase("D")) int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daily.label","common_labels");
if(status_msg.equalsIgnoreCase("W")) 
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Weekly.Label","xh_labels");
if(status_msg.equalsIgnoreCase("M")) 
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Monthly.Label","xh_labels");
if(status_msg.equalsIgnoreCase("Y")) 
	int_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Yearly.Label","xh_labels");

String status_msg1="";
String int_status1="";
status_msg1=(String)arrCol.get(1); if(status_msg1==null) status_msg1="";
if(status_msg1.equalsIgnoreCase("01")) int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.January.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("02")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.February.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("03")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.March.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("04")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.April.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("05")) int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.May.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("06")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.June.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("07")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.July.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("08")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.August.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("09")) int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.September.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("10")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.October.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("11")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.November.Label","xh_labels");
if(status_msg1.equalsIgnoreCase("12")) 
	int_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.December.Label","xh_labels");


String status_msg2="";
String int_status2="";
status_msg2=(String)arrCol.get(2); if(status_msg2==null) status_msg2="";
if(status_msg2.equalsIgnoreCase("monday")) int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Monday.Label","xh_labels");
if(status_msg2.equalsIgnoreCase("tuesday")) 
	int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Tuesday.Label","xh_labels");
if(status_msg2.equalsIgnoreCase("wednesday")) 
	int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Wednesday.Label","xh_labels");
if(status_msg2.equalsIgnoreCase("thursday")) 
	int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Thursday.Label","xh_labels");
if(status_msg2.equalsIgnoreCase("friday")) int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Friday.Label","xh_labels");
if(status_msg2.equalsIgnoreCase("saturday")) 
	int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Saturday.Label","xh_labels");
if(status_msg2.equalsIgnoreCase("sunday")) 
	int_status2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Sunday.Label","xh_labels");

String status_msg3="";
status_msg3=(String)arrCol.get(3); 
if(status_msg3==null) status_msg3="";
if(status_msg3.equals("null")) status_msg3="";

String status_msg4="";
status_msg4=(String)arrCol.get(4); if(status_msg4==null) status_msg4="";

String status_msg5="";
status_msg5=(String)arrCol.get(5); if(status_msg5==null) status_msg5="";

%>
<tr>
<td <%=strTDClass%> >&nbsp;<%=int_status%></td>
<td <%=strTDClass%> >&nbsp;<%=int_status1%></td>
<td <%=strTDClass%> >&nbsp;<%=int_status2%></td>
<td <%=strTDClass%> >&nbsp;<%=status_msg3%></td>
<td <%=strTDClass%> >&nbsp;<%=status_msg4%></td>
<td <%=strTDClass%> >&nbsp;<%=status_msg5%></td>
<td><input class=Button type='button' name='deltebutton' id='deltebutton' value='<fmt:message key="eXH.Delete.Label" bundle="${xh_labels}"/>' onClick="DeleteRecord('<%=arrCol.get(6)%>')" ></td>
</tr>
<%
}
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
<td><input type='text' size='15' name='Protocol_linkname' id='Protocol_linkname' id='Protocol_link'  maxlength=5 ><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ElementSearch1 value='?' onClick='searchApplication()'><input type="hidden" name="Protocol_Link_id" id="Protocol_Link_id" value="null"></td>
<td <%=strTDClass%> ><select name='type' id='type' id='type' onChange='chkvalidate()'>
<option value='D'><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
<option value='W'><fmt:message key="eXH.Weekly.Label" bundle="${xh_labels}"/></option>
<option value='M'><fmt:message key="eXH.Monthly.Label" bundle="${xh_labels}"/></option>
<option value='Y'><fmt:message key="eXH.Yearly.Label" bundle="${xh_labels}"/></option>

</select></td>

<td <%=strTDClass%> ><select name='month' id='month' id='month' onBlur="chkvalidate()">
<option value=''>-----<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-----</option>
<option value='01'><fmt:message key="eXH.January.Label" bundle="${xh_labels}"/></option>
<option value='02'><fmt:message key="eXH.February.Label" bundle="${xh_labels}"/></option>
<option value='03'><fmt:message key="eXH.March.Label" bundle="${xh_labels}"/></option>
<option value='04'><fmt:message key="eXH.April.Label" bundle="${xh_labels}"/></option>
<option value='05'><fmt:message key="eXH.May.Label" bundle="${xh_labels}"/></option>
<option value='06'><fmt:message key="eXH.June.Label" bundle="${xh_labels}"/></option>
<option value='07'><fmt:message key="eXH.July.Label" bundle="${xh_labels}"/></option>
<option value='08'><fmt:message key="eXH.August.Label" bundle="${xh_labels}"/></option>
<option value='09'><fmt:message key="eXH.September.Label" bundle="${xh_labels}"/></option>
<option value='10'><fmt:message key="eXH.October.Label" bundle="${xh_labels}"/></option>
<option value='11'><fmt:message key="eXH.November.Label" bundle="${xh_labels}"/></option>
<option value='12'><fmt:message key="eXH.December.Label" bundle="${xh_labels}"/></option>
</select></td>

<td <%=strTDClass%> ><select name='day' id='day' id='day' onBlur="chkvalidate()">
<option value=''>---<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------</option>
<option value='monday'><fmt:message key="eXH.Monday.Label" bundle="${xh_labels}"/></option>
<option value='tuesday'><fmt:message key="eXH.Tuesday.Label" bundle="${xh_labels}"/></option>
<option value='wednesday'><fmt:message key="eXH.Wednesday.Label" bundle="${xh_labels}"/></option>
<option value='thursday'><fmt:message key="eXH.Thursday.Label" bundle="${xh_labels}"/></option>
<option value='friday'><fmt:message key="eXH.Friday.Label" bundle="${xh_labels}"/></option>
<option value='saturday'><fmt:message key="eXH.Saturday.Label" bundle="${xh_labels}"/></option>
<option value='sunday'><fmt:message key="eXH.Sunday.Label" bundle="${xh_labels}"/></option>
</select></td>

<td <%=strTDClass%> ><select name='datenumber' id='datenumber' id='datenumber' onBlur="chkvalidate()">
<option value=''>-----<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------</option>
<% for(int ii=1;ii<=31;ii++){%>
<option value='<%=ii%>'><%=ii%></option>
<%} %>
</select></td>

<td <%=strTDClass%> >
<input type='text' size='15' name='from_sleep_time' id='from_sleep_time' id='from_sleep_time'  onblur='checkt(this);' onkeypress='checkFormat(this)' onChange='checkFormat(this);'  maxlength=5 ></td>

<td <%=strTDClass%> ><input type='text' size='15' name='to_sleep_time' id='to_sleep_time'  id='to_sleep_time' onblur='checkt(this);checkvalueFormat();' onkeypress='checkFormat(this)' onChange='checkFormat(this);checkvalueFormat();' maxlength=5  ></td><td <%=strTDClass%> >
<input class=Button type='button' name='addbutton' id='addbutton' value='<fmt:message key="eXH.Record.Label" bundle="${xh_labels}"/>' onClick='addRecord()' >
</td>

</tr>
<%
try
{
	if(arrRow!=null) arrRow.clear();
	if(arrCol!=null) arrCol.clear();
ConnectionManager.returnConnection(con);
}catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }
%>
</table>
<input type='hidden' name='action_type' id='action_type' >
<input type='hidden' name='mode' id='mode' >
<input type='hidden' name='rowid' id='rowid' >
<input type='hidden' name='Protocol_id' id='Protocol_id' >
</form>
</BODY>
</HTML>


