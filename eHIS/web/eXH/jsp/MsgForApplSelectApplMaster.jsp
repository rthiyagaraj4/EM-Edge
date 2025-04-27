<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));	
       %>
<% 
Connection con=null;
Statement stmt = null;
Statement countstmt = null;
ResultSet rs  = null; 
ResultSet countrs  = null;
String selected = "selected";
//String defaultval = "";
%>
<HEAD>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<style>
ul {
       list-style-position: outside; /* Ensure bullets are outside the list */
       margin-left: 0; /* Remove any default margin */
       padding-left: 0; /* Remove any default padding */
   }
</style>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/MessagesForApplication.js" ></script>

<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
//function callJSPs
function callJSPs(str)
{

var tab1=document.getElementById("msg_type");
var tabspan1=document.getElementById("msg_type_tabspan");
var tab2=document.getElementById("app_wise_segment");
var tabspan2=document.getElementById("app_wise_segment_tabspan");

if(str=='msg_type')
{

tab1.className='tabClicked';
tabspan1.className='tabSpanclicked';
tab2.className='tabA';
tabspan2.className='tabAspan';

if(document.forms[0].appli.value=='')
{
	alert(getMessage( 'XH1003','XH'));
	document.forms[0].focus();
	return;
}

parent.frames[1].location.href='../../eXH/jsp/MsgForApplSelectMsgTypeMasterMain.jsp?&count_page=0';
document.forms[0].option.value='msg_type';
parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';

}


if(str=='app_wise_segment')
{

tab1.className='tabA';
tabspan1.className='tabAspan';

tab2.className='tabClicked';
tabspan2.className='tabSpanclicked';

document.forms[0].option.value="event";
var appl_id=document.forms[0].appli.value;
if(document.forms[0].appli.value=='')
	{
	alert(getMessage( 'XH1003','XH'));
	document.forms[0].focus();
	return;
	}
	
parent.frames[1].location.href='../../eXH/jsp/MsgForApplSelectEventTypeMasterMain.jsp?appl_id='+appl_id;
document.forms[0].option.value='app_wise_segment';
parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';

}
}
//function onSelectAppliction(obj)
function onSelectAppliction()
{
//		document.forms[0].appli.value=obj.value;
//		alert(	" frm1 : "+this.document.forms[0].appln_name.value);
		document.forms[0].appli.value=this.document.forms[0].appln_name.value;
//		alert(	" frm1 : "+parent.frames[1].name);
		parent.frames[1].location.href='../../eCommon/html/blank.html';
//		alert(	" frm3 : "+parent.parent.frames[2].name);
	    parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		var frmObj=document.forms[0].elements;
		frmObj[1].className = 'XHTAB2';
		frmObj[2].className = 'XHTAB2';

var appln_name=document.forms[0].appln_name.value;
if(appln_name=='')
{
}
else
{
	callJSPs('msg_type');
}



}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='onSelectAppliction();'>
<form name="application_setup_base_form" id="application_setup_base_form">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
</tr>
<tr>
	<td width='30%'></td>
	<td class=label align=center><fmt:message key="Common.Application.label" bundle="${common_labels}"/> </td>
	<td class='fields' colspan=2> 
	<select class='select' name='appln_name' id='appln_name' onChange='onSelectAppliction()' style='width:300'>
	  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
try
{
	con=ConnectionManager.getConnection();
// LANGUAGE_ID='"+locale+"'"
   String qry2="SELECT count(*) FROM XH_APPLICATION_LANG_VW WHERE IN_USE_YN='Y' and   LANGUAGE_ID='"+locale+"'";
   countstmt= con.createStatement();
   countrs = countstmt.executeQuery(qry2);
   countrs.next();
int count=Integer.parseInt(countrs.getString(1));

if(count==0)
	{
	%>


	<%
	}
else
	{
	String qry = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW WHERE IN_USE_YN='Y' and    LANGUAGE_ID='"+locale+"'";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
%>

           
<%



	while(rs.next())
            {
  /*            if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }
	  */
%>
<!--   <%=selected%> -->
	<option value='<%=rs.getString(1)%>'   ><%=rs.getString(2)%></option>
            
		<% 	}
	}%>

            </select>
 <% 

}catch(Exception e1)
{
	System.out.println("MsgForApplSelectApplMaster.jsp Error: "+e1.toString());
}

%>
<img src='../../eCommon/images/mandatory.gif' align='middle'></td></tr>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
</tr>
</table>

		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
        <tr><td>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title='Events'>
				<a onclick="callJSPs('msg_type')" class="tabA" id="msg_type" >
					<span class="tabAspan" id="msg_type_tabspan"><fmt:message key="Common.Events.label" bundle="${common_labels}"/></span>
				</a>
		    </li>
	

			<li class="tablistitem" title='Event wise Segments'>			
				<a onclick="callJSPs('app_wise_segment')" class="tabA" id='app_wise_segment' >
					<span class="tabAspan" id="app_wise_segment_tabspan"><fmt:message key="eXH.EventwiseSegments.Label" bundle="${xh_labels}"/></span>
				</a>
			</li>
		</ul>
	 </td>
   </tr>
</table>



		<input type=hidden name=option value=''> 
		<input type=hidden name=appli value=''> 
</form>
<%
if(countstmt!=null )countstmt.close();
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
if(countrs!=null)countrs.close();
		ConnectionManager.returnConnection(con);
%>
</BODY>
</HTML> 

