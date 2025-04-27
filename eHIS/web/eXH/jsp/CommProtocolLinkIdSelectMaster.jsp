<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	%>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
%>										 			   
<HEAD>
<%														  
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/CommProtocolLinkId.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script language="JavaScript"> 
function CheckForSpecCharsforID(event){ 
		var strCheck = '0123456789abcdefghitjklmnopqrsuvwxyzABCDEFGHIJKLMNOTPQRSUVWXYZ';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
function checkEmptyChar(obj)
{
var fields=obj.value;
obj.value=fields.toUpperCase();
if(fields.indexOf(' ')!=-1)
{
alert(getMessage('XH0068','XH')); 
obj.focus();
}

}
function checkfun(obj)
{
if(obj.value=='')
{
	 this.document.forms[0].application_id.value = '';
	this.document.forms[0].application_name.value = '';
	this.document.forms[0].standard_code.value = '';
	this.document.forms[0].standard_name.value='';
}
}
function formload()
{
	
	
}
</script>


</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='formload()'>
<%

String protocol_id=""; 
String datagroup_id="";  

String protocol_linkId = "";
String protocol_linkName = "";
String protocol_name = "";
String datagroup_name = "";
String standard_code = "";
String standard_name = "";

String profile_id="";
String profile_desc="";
String application_id="";
String application_name="";
String comm_mode="";
String auditYN="";
String debugYN="";
String outbndLogYN="";
String inbndLogYN="";
String chkDisp="none";
String chkDispI="none";
String mode				=	XHDBAdapter.checkNull(request.getParameter("mode"));
String outbndLogYNval="N";
String inbndLogYNval="N";

String tmp_standard_code = "";
if(mode.equals("U"))
{
	protocol_linkId=XHDBAdapter.checkNull(request.getParameter("protocol_linkId"));
    //System.out.println("CommProtocolLinkIdSelectMaster.jsp protocol_linkId : "+protocol_linkId);

	protocol_linkName=XHDBAdapter.checkNull(request.getParameter("protocol_linkName"));  
	protocol_name=XHDBAdapter.checkNull(request.getParameter("protocol_name"));
	datagroup_name=XHDBAdapter.checkNull(request.getParameter("dg_desc"));
	    //System.out.println("datagroup_name : "+datagroup_name);

	standard_code = XHDBAdapter.checkNull(request.getParameter("standard_code"));
		    //System.out.println("standard_code : "+standard_code);
	standard_name = XHDBAdapter.checkNull(request.getParameter("standard_name"));

	profile_id=XHDBAdapter.checkNull(request.getParameter("profile_id"));
	profile_desc=XHDBAdapter.checkNull(request.getParameter("profile_desc"));
	application_id=XHDBAdapter.checkNull(request.getParameter("application_id"));
	application_name=XHDBAdapter.checkNull(request.getParameter("application_name"));
	auditYN=XHDBAdapter.checkNull(request.getParameter("auditYN"));
	debugYN=XHDBAdapter.checkNull(request.getParameter("debugYN")); 

  
	outbndLogYN=XHDBAdapter.checkNull(request.getParameter("outbndLogYN"));
		//System.out.println("outbndLogYN : "+outbndLogYN);
	inbndLogYN=XHDBAdapter.checkNull(request.getParameter("inbndLogYN"));
		//System.out.println("inbndLogYN : "+inbndLogYN);
	comm_mode=XHDBAdapter.checkNull(request.getParameter("comm_mode"));	
		//System.out.println("CommProtocolLinkIdSelectMaster.jsp comm_mode : "+comm_mode);
    if(comm_mode.equals("O"))
	{
		chkDisp = "block";
		chkDispI= "none";
	}

	if(comm_mode.equals("I"))
	{
		chkDisp = "none";
		chkDispI= "block";
	}
     
	if(auditYN.equalsIgnoreCase("Y")){
		auditYN = "checked";
	}
	else{
		auditYN = "";
	}
	if(debugYN.equalsIgnoreCase("Y")){
		debugYN = "checked";
	}
	else{
		debugYN = "";
	}
	if(outbndLogYN.equalsIgnoreCase("Y")){
		outbndLogYNval=outbndLogYN;
		outbndLogYN = "checked";
	}
	else{
		outbndLogYN = "";
	}
	if(inbndLogYN.equalsIgnoreCase("Y")){
         inbndLogYNval=inbndLogYN;
		inbndLogYN = "checked";
	}
	else{
		inbndLogYN = "";
	}

}

	protocol_id			=	XHDBAdapter.checkNull(request.getParameter("protocol_id"));
	datagroup_id		=	XHDBAdapter.checkNull(request.getParameter("datagroup_id"));
	try{
		con=ConnectionManager.getConnection(); 
	}catch(Exception ex ){
		System.out.println("(CommProtocolLinkIdSelectMaster.jsp:error) :"+ex.toString());
	}

%>
<form name="Comm_protocol_linkId_form" id="Comm_protocol_linkId_form" target='messageFrame' method='post' action='../../servlet/eXH.CommProtocolLinkIdAddModifyServlet'> 
<table cellspacing=0 cellpadding=3 width='100%' align=center >

<tr>
	<td width='20%'></td>  
	<td width='45%'></td>
	<td width='20%'></td> 
	<td width='50%'></td>
</tr>
<tr> 
	<td class=label ><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/> <fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name='protocol_linkId' id='protocol_linkId' size=15 maxlength=10 value='<%=XHDBAdapter.checkNull(protocol_linkId)%>' <%=mode.equals("U")?"readonly":""%> onKeyPress='return CheckForSpecCharsforID(event);' 'onblur='checkEmptyChar(this);'><img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td></td> <td></td>
</tr>
 
<tr>
	<td class=label ><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name='protocol_linkName' id='protocol_linkName' size=40 maxlength=30 value='<%=XHDBAdapter.checkNull(protocol_linkName)%>'><img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td></td> <td></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.Communication.Label" bundle="${xh_labels}"/></td>
<td align=left>
	<input type="hidden" name="protocol_id" id="protocol_id" size=10 value="<%=XHDBAdapter.checkNull(protocol_id)%>">
	<input type=text id="protocol_name"  name =protocol_name size=40 value='<%=XHDBAdapter.checkNull(protocol_name)%>'  onBlur="searchProtocol()"> <input class="button" type="button"  name=ProtocolSearch value='?'    onClick="searchProtocol()">
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td></td> <td></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.DataGroup.Label" bundle="${xh_labels}"/></td>
<td align=left>
	<input type="hidden" name="datagroup_id" id="datagroup_id" size=10 value="<%=XHDBAdapter.checkNull(datagroup_id)%>">
	<input type=text id="datagroup_name"  name =datagroup_name size=40 value='<%=XHDBAdapter.checkNull(datagroup_name)%>' onBlur="searchDataGroup();checkfun(this);" disabled> <input class='button' type="button"  name=DataGroupSearch value='?'    onClick="searchDataGroup()" disabled>
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td></td> <td></td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type=hidden id="standard_code"  name ='standard_code'  readOnly value='<%=XHDBAdapter.checkNull(standard_code)%>' size=10 >
<input type=text id="standard_name"  name ='standard_name' readOnly value='<%=XHDBAdapter.checkNull(standard_name)%>' size=40 >
</td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type=hidden id="application_id"  name ='application_id'  readOnly value='<%=XHDBAdapter.checkNull(application_id)%>' size=10 >
<input type=text id="application_name"  name ='application_name' readOnly value='<%=XHDBAdapter.checkNull(application_name)%>' size=40 >
</td>
<td> </td><td> </td>
</tr>

<tr>
<td class=label ><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
<td align=left>
	<input type=hidden id="profile_id"  name ='profile_id' value='<%=XHDBAdapter.checkNull(profile_id)%>' size=10 >
	<input type=text id="profile_desc"  name ='profile_desc' value='<%=XHDBAdapter.checkNull(profile_desc)%>' size=40  onBlur="searchProfile();" > <input class="button" type="button"  name='ProfileSearch' id='ProfileSearch' value='?'    onClick="searchProfile();" >
</td>
<td> </td><td> </td>
</tr>
<!--
<tr>
	<td class=label > Audit	</td>
	<td><INPUT TYPE="checkbox" name="auditYN" id="auditYN" <%=auditYN%>  > </td>
	<td class=label > Debug	</td>
	<td><INPUT TYPE="checkbox" name="debugYN" id="debugYN" <%=debugYN%> > </td>
</tr>

-->
<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>

</table>
<div id='outbound' style="display:<%=chkDisp%>" >
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.OutboundLog.Label" bundle="${xh_labels}"/></td>
<td align=left style="FONT-SIZE:8pt;COLOR:navy;" ><INPUT TYPE="checkbox" name="outbndLogYN" id="outbndLogYN" <%=outbndLogYN%> <%=chkDisp%> value='<%=outbndLogYNval%>'></td>
<td> </td><td> </td>
</tr>
</table> 

</tr>
</div>

<div id='inbound' style="display:<%=chkDispI%>" >
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
</tr>
<tr>
<td class=label ><fmt:message key="eXH.InboundLog.Label" bundle="${xh_labels}"/></td>
<td align=left style="FONT-SIZE:8pt;COLOR:navy;" ><INPUT TYPE="checkbox" name="inbndLogYN" id="inbndLogYN" <%=inbndLogYN%> value='<%=inbndLogYNval%>' <%=chkDispI%> >	</td>
<td> </td><td> </td>
</tr>
</table>


<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>
		<input type=hidden name=option value=''> 
		<input type=hidden name=act_mode value='<%=mode%>'>
		<input type=hidden name=auditYN value=''>
		<input type=hidden name=debugYN value=''>
        <input type=hidden name=comm_mode value='<%=comm_mode%>'>
		<input type=hidden name=tmp_protocol_linkId value='<%=protocol_linkId%>'>
		<input type=hidden name=tmp_protocol_linkName value='<%=protocol_linkName%>'>
		<input type=hidden name=tmp_protocol_id value='<%=protocol_id%>'>
		<input type=hidden name=tmp_protocol_name value='<%=protocol_name%>'>
		<input type=hidden name=tmp_datagroup_id value='<%=datagroup_id%>'>
		<input type=hidden name=tmp_datagroup_name value='<%=datagroup_name%>'>
		<input type=hidden name=tmp_standard_code value='<%=standard_code%>'>
		<input type=hidden name=tmp_standard_name value='<%=standard_name%>'>
		<input type=hidden name=tmp_application_id value='<%=application_id%>'>
		<input type=hidden name=tmp_application_name value='<%=application_name%>'>
		<input type=hidden name=tmp_profile_id value='<%=profile_id%>'>
		<input type=hidden name=tmp_profile_desc value='<%=profile_desc%>'>
		<input type=hidden name=tmp_comm_mode value='<%=comm_mode%>'>
		<input type=hidden name=tmp_inbndLogYN value='<%=inbndLogYNval%>'>
		<input type=hidden name=tmp_outbndLogYN value='<%=outbndLogYNval%>'>		
		

</form> 
</BODY>  
</HTML> 

