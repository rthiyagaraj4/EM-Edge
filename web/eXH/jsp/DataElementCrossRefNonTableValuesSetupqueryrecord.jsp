<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML> 
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String applicationid = request.getParameter("applicationid");
String elementid = request.getParameter("nontabelementid");

//System.out.println("applicationid"+applicationid+"elementid"+elementid);

String eHiscode = XHDBAdapter.checkNull(request.getParameter("eHiscode"));
String crossrefcode = XHDBAdapter.checkNull(request.getParameter("crossrefcode"));
String crossRefdesc = XHDBAdapter.checkNull(request.getParameter("crossRefdesc"));
String act_mode = XHDBAdapter.checkNull(request.getParameter("act_mode"));
//System.out.println("act_mode16"+act_mode);
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<Script>
function funMasterCode()
{
	this.document.forms[0].submit();
}

function funAction(typ)
{
	document.forms[0].action_type.value = typ;
var act = '../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target="applnontablecode";
	this.document.forms[0].submit();
}
 function addRecord()
{

var fields="";
var names="";
fields = new Array ( 
					     document.forms[0].nontabmedicomcode1				     
					   );
names = new Array (getLabel("eXH.ibaehisCode.Label","XH"));

if(!checkFields( fields, names, parent.parent.parent.parent.messageFrame))
	{
	
	}
	else
	{
		
this.document.forms[0].nontabmedicomcode.value=this.document.forms[0].nontabmedicomcode1.value;
this.document.forms[0].action="../../servlet/eXH.DataElementCrossRefNonTableValuesServlet";	

this.document.forms[0].submit();
	}



}
function hide()
{
	
	if(this.document.forms[0].mode.value=='U')
	{
		
		document.forms[0].nontabmedicomcode1.disabled=true;
	}
}


</Script>
</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload='hide();'>
<form name="application_element_setup_form1" id="application_element_setup_form1" method='post' target='messageFrame' action=''>
<input type=hidden name=action_type>
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>

<td class=label ><fmt:message key="eXH.ibaehisCode.Label" bundle="${xh_labels}"/></td>

<td align=left><input type=text name=nontabmedicomcode1 id="nontabmedicomcode1" size=25 value='<%=eHiscode%>'  ><img src='../../eCommon/images/mandatory.gif' align=middle><input type=hidden name=nontabmedicomcode value='<%=eHiscode%>'></td><td></td><td></td></tr>
<tr><td class=label ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>

<td align=left><input type=text name=nontabcrosscode id="nontabcrosscode" size=25 value='<%=crossrefcode%>'  ></td><td></td><td></td></tr>
<tr><td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td align=left><input type=text name=nontabcrossdesc id="nontabcrossdesc" size=25 value='<%=crossRefdesc%>'  ></td>
<td></td><td></td>

</tr>

<tr>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td class=label></dt>
<td class="BUTTON"><input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="addRecord()"></td></tr>
</table>

<input type=hidden name='applicationid' id='applicationid' value='<%=applicationid%>'>
<input type=hidden name='nontabelementid' id='nontabelementid' value='<%=elementid%>'>
<input type=hidden name='mode' id='mode' value='<%=act_mode%>'>
</form>
</BODY>
</HTML>

