<!DOCTYPE html>
<html lang="en">
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />		
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="demonstration of some noty capabilities">

<!--<link href='http://fonts.googleapis.com/css?family=PT+Sans:regular,italic,bold,bolditalic&amp;subset=latin,latin-ext,cyrillic' rel='stylesheet' type='text/css'>-->

<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


<style type="text/css">
        html {
            height: 100%;
            width: 100%;
        }

        body {
            font-family: 'PT Sans', Tahoma, Arial, serif;
            line-height: 13px
        }
    </style>

<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eXH/js/DomainApplication.js"></script>


<!--

<link rel="StyleSheet" type="text/css" href="../../eXH/js/noty/buttons.css"></link>
<link rel="StyleSheet" type="text/css" href="../../eXH/js/noty/animate.css"></link>
<link rel="StyleSheet" type="text/css" href="../../eXH/js/noty/font-awesome/css/font-awesome.min.css"></link>

<script language="javascript" src="../../eXH/js/noty/jquery-1.8.0.js"></script>
<script language="javascript" src="../../eXH/js/noty/promise.js"></script>
<script language="javascript" src="../../eXH/js/noty/packaged/jquery.noty.packaged.js"></script>
<script language="javascript" src="../../eXH/js/noty/EMNoty.js"></script>

-->

<%
    String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";
%>


<!--


<script type="text/javascript" src="../../eCommon/noty/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../../eCommon/noty/js/jquery.noty.js"></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/noty/css/jquery.noty.css"/>
<link rel="stylesheet" type="text/css" href="../../eCommon/noty/css/noty_theme_default.css"/>

-->


 
<script type="text/javascript">
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789abcdefghitjklmnopqrsuvwxyzABCDEFGHIJKLMNOTPQRSUVWXYZ';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
function checklength(event,obj) 
{
    var bool=true; 
	if(obj.name=='appl_id')
	{
	
		  if(obj.value.length<=10)
		{
			bool=true;
		}
		else
		{
			bool=false;
		}
	}
	else
	{
		if(obj.value.length<=16)
		{
			bool=true;
		}
		else
		{
			bool=false;
 
		}
	}
	return bool;
}

function checkEmptyChar(obj)
{
	var fields=obj.value;
	obj.value=fields.toUpperCase();	

	var message = getMessage('XH0068','XH');
	if(fields.indexOf(' ')!=-1)
	{
		//alert(getMessage('XH0068','XH'));

		//NotyMessage("success",message);

		getExtLink("AY","DH0000001919","ANAND","PAS","");
		
	}

}

function notyOkMessage(obj)
{
	if (obj == "true")
	{
		noty({text: 'Thank You, I am done', type: 'success'});
	}
	return true;
}

function notyCancelMessage()
{
	noty({text: 'Sorry, I stay ', type: 'error'});
	return false;
}


</script>
</HEAD>
<BODY  leftmargin=0 topmargin=0  bgcolor='' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="onLoadMethod();">

<%
String mode=request.getParameter("mode");
String appl_id="";
String appl_name="";
String facility="";
String enabled="";
String enabledvalue="Y";
String lang_id="";
//Connection con=null;
//Statement stmt=null;
//ResultSet rs=null; 

if(mode.equals("U"))
{
	appl_id=request.getParameter("appl_id");
	appl_name=request.getParameter("appl_name");
	facility=request.getParameter("facility");
	enabled=request.getParameter("enabled");
   
		//System.out.println("AppAddModMaster.jsp Updtd enabled : "+enabled);
	if(enabled.equalsIgnoreCase("Y")){
		enabled = "checked";
		enabledvalue="Y";
	}
	else{
		enabled = "";
		enabledvalue="N";
	}
}
		//System.out.println("AppAddModMaster.jsp Insrt enabled : "+enabled);

%>
<form id="Master_application_form" name="Master_application_form" id="Master_application_form" target='messageFrame' method='post' action='../../servlet/eXH.ApplicationAddModifyServlet'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
<td class=label><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=text name =appl_id size=10 maxlength=10 onKeyPress='return CheckForSpecCharsforID(event);return checklength(event,this);' value='<%=appl_id%>'  title='Application ID' <%=mode.equals("U")?"readonly":""%> onblur='checkEmptyChar(this);' ><img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>
<tr>
<td class=label><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=text name =appl_name size=50 maxlength=30  value='<%=appl_name%>' title='Application Name' onblur='checkEmptyChar(this);'><img src='../../eCommon/images/mandatory.gif' align=middle></td></tr>

<!-- Facility and FieldSeparator fields made invisible 
<tr>
<td class=label><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type=text name =facility size=50 value='<%=facility%>' title='Application Facility Name' ><img src='../../eCommon/images/mandatory.gif' align=middle> 
</td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.FieldSeparator.Label" bundle="${xh_labels}"/></td>
	<td class='fields'><input type=text name=field_sep id=field_sep size=1 readonly maxlength=1 value='|'  title='Field Seperator'><img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>

-->
<tr>
<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=checkbox name =in_use onClick='validatecheckbox(this);' value="<%=enabledvalue%>" <%=enabled%> ></td></tr>


</table>
<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name=lang_id value='<%=lang_id%>'>
<input type=hidden name=field_sep value='|'>

</body>
</html>	



