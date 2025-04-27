<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
//function validatecheckbox
var act='';
var arguments  =new Array();
var features="";
function cancle(){

document.forms[0].DBconnection_string_txt.value='';
	
}
function apply()
{

if(document.getElementById("DBconnection_string_txt").value!='')
	{

	
var act = '../../eXI/jsp/XIPARAMDBConnectionString.jsp?rec_cultser='+document.forms[0].DBconnection_string_txt.value;
	this.document.forms[0].action = act;
	//var returnval=this.document.forms[0].submit();

this.document.forms[0].submit();


	
   
//=this.document.forms[0].DBconnection_string_txt.value;

window.returnValue=document.forms[0].DBconnection_string_txt.value;
	//document.forms[0].db_conn_string_txt.value

window.close();

	}
else
{ 
alert(getMessage('XH1055','XH'));
		
		
}
// window.commontoolbarFrame.document.location.href='../../eCommon/jsp/MstCodeToolbar.jsp';


}
	
 



</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="MasterInterfaceForm" id="MasterInterfaceForm" target='messageFrame' method='post' >
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<!---<tr>
	<td width='40%'></td>
	<td width='60%'></td>
	
</tr>----------->
<tr>
	<td class=label align=right><fmt:message key="eXH.DBConnectString.Label" bundle="${xh_labels}"/></td>
	<td align=lef colspan=3>
	<td class='fields'><textarea name="DBconnection_string_txt" id="DBconnection_string_txt" rows=2 cols=100 ></textarea>
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>

<tr>
<td colspan=6 class='BUTTON'><input class='BUTTON' type="button"  name=search value='<fmt:message key="Common.ok.label" bundle="${xh_labels}"/>' onClick="apply()">
<input class='BUTTON' type="button"  name=search value='<fmt:message key="Common.cancel.label" bundle="${xh_labels}"/>' onClick="cancle()"></td>
</tr>
<!---<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>-------->
</table>





</form>
</body>
</html>

