<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet, eCommon.XSSRequestWrapper, webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	Connection con = null;
	Statement stmt = null; 
	ResultSet rs   = null;
	PreparedStatement pstmt		= null;

	String readOnly = "false";
	String fieldMode = "ENABLE";

	int commFlag = 0;
	int CommProcessIdleTime = 0;

	String CommField = "disable";
%>
<HEAD>
<%											 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	

<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/CommProtocolId.js" ></script> 	    
<script language="javascript" src="../../eXH/js/CommProtocolIdFileCtrlStr.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<script language="JavaScript">
function CheckForSpecCharsforNumber(event){
		var strCheck = '0123456789ABACDEFGHIJKLMNOPQRSTUVWXYZabacdefghijklmnopqrstuvwxyz';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789:';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
function chkRange(obj){
	if(obj.value!=""){
		chkflag = checkValid(obj);
		if(chkflag != false){
			if(obj.value<=1024){
				alert("Port Number Should be greater than 1024");
				obj.focus();
				return false;
			}
		}
	}
}

function CheckForNumbers(event){
	var strCheck = '0123456789';
	 var whichCode = (window.Event) ? event.which : event.keyCode;
	 key = String.fromCharCode(whichCode);  // Get key value from key code
	 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='onLoadOfpage();dispSolicited()'>  

<% 

String filenaming_api_id = "";
String datainput_api_id  = "";
String statistics_api_id = "";
String protocol_id	 = "";
String protocol_name = "";
String protocol_type = "";
String protocol_mode = "";
String ack_type		= "";
String file_dir		= "";
String ack_dir		= "";
String file_type	= "";
String ip_address	= "";
String port_no		= "";
String retry_intrvl = "";
String max_retries	= "";
String file_intrvl	= "";
String filenaming_api = "";
String data_intrvl	 = "";
String datainput_api = "";
String statistics_api = "";
String auto_restart_type = "";
String auto_restart_time="";
String module_Id = "XH";   
String module_Name = "";
String sub_module_Id = "XH";   
String sub_module_Name = "";
String db_conn_string = "";
String db_driver = "";
String fax_id = "";
String recipient_name = "";
String mail_id = "";
String to_mail = "";
String oracle_table_qry = "";	  
String oracle_table_ins_qry = "";
String solicitedYN = "";
String chkDisp = "none";
String styleshtDisp  = "none";
String chkProtTypeI  = "none";
String chkProtTypeO  = "none";
String soapWebserviceDisp  = "none";
String stylesht_path = "";
String error_dir = "";
String odbc_uid = "";
String odbc_pwd = "";
String odbc_sid = "";
String dblink_name = "";
String mode	= request.getParameter("mode");
String url = null;
String userName = null;
String password = null;
String settingHeader = null;
String httpUserAgent =null;
String httpContentType =null;
String httpTransferEncoding =null;
String httpSoapAction =null;
String httpContentLength =null;

//Added By Niveditha on 22/01/2020 for AAKH-CRF-0113
String mail_uid = null; 
String mail_pwd = null; 
String mail_config =null;
String mail_host = null;
String mail_port = null;
String mail_smtp_auth_flag = "";
String mail_smtp_starttls_flag = "";
String mail_attachment_flag = "";




if(mode.equals("U"))
{
	module_Id				=	request.getParameter("module_Id");
	sub_module_Id			=	request.getParameter("sub_module_Id");
	protocol_id=request.getParameter("protocol_id");
	protocol_name=request.getParameter("protocol_name");
	protocol_type=request.getParameter("protocol_type");
	protocol_mode=request.getParameter("protocol_mode");
	file_dir=request.getParameter("file_dir");
	file_type=request.getParameter("file_type");
	ip_address=request.getParameter("ip_address");
	port_no=request.getParameter("port_no");
	ack_type=request.getParameter("ack_type");
	retry_intrvl=request.getParameter("retry_intrvl");
	max_retries=request.getParameter("max_retries");
	file_intrvl=request.getParameter("file_intrvl"); 
	filenaming_api=request.getParameter("filenaming_api");
	data_intrvl=request.getParameter("data_intrvl");
	datainput_api=request.getParameter("datainput_api");
	statistics_api=request.getParameter("statistics_api");
	auto_restart_type=request.getParameter("auto_restart_type");
	auto_restart_time=request.getParameter("auto_restart_time");
	db_conn_string=request.getParameter("db_conn_string");
	db_driver=request.getParameter("db_driver");
	module_Name=request.getParameter("module_Name");
	sub_module_Name=request.getParameter("sub_module_Name");		   
	recipient_name=request.getParameter("recipient_name");
	to_mail=request.getParameter("to_mail");  
	oracle_table_qry=java.net.URLDecoder.decode(request.getParameter("oracle_table_qry"));
	oracle_table_ins_qry = java.net.URLDecoder.decode(request.getParameter("oracle_table_ins_qry"));
	solicitedYN = request.getParameter("solicitedYN");
	ack_dir=request.getParameter("ack_dir");
	stylesht_path=request.getParameter("stylesht_path");
	url = stylesht_path;
	userName = request.getParameter("odbc_uid");
	password = request.getParameter("odbc_pwd");

	//Added By Niveditha on 22/01/2020 for AAKH-CRF-0113
	mail_uid = request.getParameter("odbc_uid");  
	mail_pwd = request.getParameter("odbc_pwd");  
	mail_config = request.getParameter("mail_config");
	mail_host = request.getParameter("mail_host");
	mail_port = request.getParameter("mail_port");
	mail_smtp_auth_flag = request.getParameter("mail_smtp_auth_flag");
	mail_smtp_starttls_flag = request.getParameter("mail_smtp_starttls_flag");
	mail_attachment_flag = request.getParameter("mail_attachment_flag");


	
	httpUserAgent = request.getParameter("httpUserAgent");
	httpContentType = request.getParameter("httpContentType");
	httpTransferEncoding = request.getParameter("httpTransferEncoding");
	httpSoapAction = request.getParameter("httpSoapAction");
	httpContentLength = request.getParameter("httpContentLength");

	if(protocol_mode.equalsIgnoreCase("I") && solicitedYN.equalsIgnoreCase("Y")){
		solicitedYN = "checked";
	}
	else{ 
		solicitedYN = "";
	}
	
	//Added By Niveditha on 12/02/2020 for AAKH-CRF-0113
	if(mail_smtp_auth_flag.equalsIgnoreCase("Y")){
		mail_smtp_auth_flag = "checked";
	}
	else{ 
		mail_smtp_auth_flag = "";
	}
	
	//Added By Niveditha on 12/02/2020 for AAKH-CRF-0113
	if(mail_smtp_starttls_flag.equalsIgnoreCase("Y")){
		mail_smtp_starttls_flag = "checked";
	}
	else{ 
		mail_smtp_starttls_flag = "";
	}
	

	if(mail_attachment_flag.equalsIgnoreCase("Y")){
		mail_attachment_flag = "checked";
	}
	else{ 
		mail_attachment_flag = "";
	}
	
	if(protocol_mode.equalsIgnoreCase("I")){
		chkDisp = "block";
		chkProtTypeI = "block";
	}
	if(protocol_mode.equalsIgnoreCase("O")){
		chkProtTypeO = "block";
	}
	if(protocol_mode.equalsIgnoreCase("I")&& protocol_type.equalsIgnoreCase("F") && file_type.equalsIgnoreCase("X")){
		styleshtDisp = "block";
	}
    
	//if(protocol_type.equalsIgnoreCase("SO")){
	//	soapWebserviceDisp = "block";
	//}

	error_dir	= request.getParameter("error_dir");
	odbc_uid	= request.getParameter("odbc_uid");
	odbc_pwd	= request.getParameter("odbc_pwd");
	odbc_sid	= request.getParameter("odbc_sid");
	dblink_name = request.getParameter("dblink_name");
}

filenaming_api_id	= request.getParameter("filenaming_api_id");
datainput_api_id	= request.getParameter("datainput_api_id");
statistics_api_id	= request.getParameter("statistics_api_id");
fax_id				= request.getParameter("fax_id");
mail_id				= request.getParameter("mail_id");

if("U".equals(mode)) 
{
	readOnly = "readonly";
	fieldMode = "DISABLE";
}
else 
{
	readOnly = "";
	fieldMode = "ENABLE";
}

	try
	{
		con = ConnectionManager.getConnection();
	}
	catch(Exception ex ){
		System.out.println("(CommProtocolIdSelectMaster.jsp: ERROR) :"+ex.toString());
	}
%>

<form name="Comm_protocol_id_form" id="Comm_protocol_id_form" target='messageFrame' method='post' >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td> 
</tr>
<tr>
	<td class=label >
		<fmt:message key="Common.identification.label" bundle="${common_labels}"/>
	</td>
	<td align=left>
		<input type=text name=protocol_id size=20 maxlength=30 value='<%=protocol_id%>' <%=readOnly%> onblur='ChangeUpperCase(this);' onkeypress='return CheckForSpecCharsforNumber(event)' > 
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td class=label width='10%'>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
	</td>
	<td align=left>
		<input type=text name=protocol_name size=30 maxlength=30 value='<%=protocol_name%>'> 
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
</tr>

<!--<tr>
	<td class=label >Comm Data I/O API</td>
	<td align=left><input type=text id="datainput_api"  name =datainput_api size=35 value='<%=datainput_api%>' onBlur="searchDataInputAPI()"> <input  type="button"  name=CommDataIOAPISearch value='?'    onClick="searchDataInputAPI()">
	<input type="hidden" name="datainput_api_id" id="datainput_api_id" <%=readOnly%> value="<%=datainput_api_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td class=label >Comm Statistics API</td>
	<td align=left><input type=text id="statistics_api"  name =statistics_api size=35 value='<%=statistics_api%>'  onBlur="searchCommStatAPI()"> <input type="button"  name=CommStatAPISearch value='?'    onClick="searchCommStatAPI()">
	<input type="hidden" name="statistics_api_id" id="statistics_api_id" <%=readOnly%> value="<%=statistics_api_id%>"><img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
-->									  
 <tr>
	<td class=label ><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>
	<td align=left>
		<input type="hidden" name="module_Id" id="module_Id" size=5 maxlength=2 <%=readOnly%> value="<%=XHDBAdapter.checkNull(module_Id)%>">
		<input type=text id="module_Name"  name =module_Name size=35 <%=readOnly%> value='<%=XHDBAdapter.checkNull(module_Name)%>' onBlur='searchInterfaceDomain();'> 
		<input type="button" name=moduleNameSearch <%=fieldMode%> value='?' onClick='searchInterfaceDomain();'>
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td class=label ><fmt:message key="eXH.SubDomain.Label" bundle="${xh_labels}"/></td>
	<td align=left>
		<input type="hidden" name="sub_module_Id" id="sub_module_Id" size=5 value="<%=XHDBAdapter.checkNull(sub_module_Id)%>">
		<input type=text id="sub_module_Name" name=sub_module_Name size=35 <%=readOnly%> value='<%=XHDBAdapter.checkNull(sub_module_Name)%>' onBlur='searchSubDomain();'> 
		<input type="button" name=submoduleNameSearch <%=fieldMode%> value='?' onClick='searchSubDomain();'>
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
</tr>														    

<tr>
	<td class=label ><fmt:message key="eXH.AcknowlegementType.Label" bundle="${xh_labels}"/></td> 
	<td class='fields'>
	<select name ='ack_type' <%=readOnly%>>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='0' <%=ack_type.equals("0")?"selected":""%>><fmt:message key="eXH.Always.Label" bundle="${xh_labels}"/></option>
		<option value='1' <%=ack_type.equals("1")?"selected":""%>><fmt:message key="eXH.Never.Label" bundle="${xh_labels}"/></option>
		<option value='2' <%=ack_type.equals("2")?"selected":""%>><fmt:message key="eXH.ErrorReject.Label" bundle="${xh_labels}"/></option>
	</select> 
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td class=label ><fmt:message key="eXH.CommunicationType.Label" bundle="${xh_labels}"/></td>
	<td class='fields'> 
	<select class='select' name='protocol_type' id='protocol_type' id='protocol_type'  onChange='onLoadOfpage();dispSolicited();' <%=fieldMode%>>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	<% 
		try															    
		{  
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='XH_COMM_TYPE'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);			
			
			while(rs.next())
			{
				if(protocol_type.equals(rs.getString(1).toString().trim()) && protocol_type.equalsIgnoreCase(rs.getString(1).toString().trim()))
				{
					settingHeader = rs.getString(2);
	%>				 
				<option value='<%=rs.getString(1).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>
	</select>
		
	<img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>

<tr>
	<td class=label ><fmt:message key="Common.mode.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<select class='select' name=protocol_mode id=protocol_mode <%=readOnly%> onChange="dispSolicited();">
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<option value='I' <%=protocol_mode.equals("I")?"selected":""%>><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></option> 
			<option value='O' <%=protocol_mode.equals("O")?"selected":""%>><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></option> 
		</select>
		<img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table>


<div id='solicitedYN' style="display:<%=chkDisp%>;" <%=readOnly%> >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class=label > <fmt:message key="eXH.Solicited.Label" bundle="${xh_labels}"/>	</td>
	<td><INPUT TYPE="checkbox" name="solicitedYN" id="solicitedYN" <%=solicitedYN%> > </td>
	<td></td> <td></td> 
</tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table>
</div>	

<div id='file' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr></tr>
<tr>
	<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.FileSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.FileDirectory.Label" bundle="${xh_labels}"/></td> 
	<td align=left><input type=text name=file_dir size=35 value='<%=XHDBAdapter.checkNull(file_dir)%>' onblur='validDir(this,"z Directory");'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td class=label width='10%'><fmt:message key="eXH.AckDir.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=ack_dir size=35 value='<%=XHDBAdapter.checkNull(ack_dir)%>' onblur='validDir(this,"Acknowlege Directory");'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr>

<!--<td colspan=2 id='filename_api1'>
<div id='filename_api'>				    
<table >
<tr>
<td width='33%'></td>
<td width='50%'></td>
</tr> -->
<tr>
	<td class=label ><fmt:message key="eXH.FileNamingAPI.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text id="filenaming_api"  name =filenaming_api size=35  value='<%=XHDBAdapter.checkNull(filenaming_api)%>' onBlur="searchFileNamingConv();"> <input type="button"  name=fileNamingSearch value='?' onClick="searchFileNamingConv();"> 
	<input type="hidden" name="filenaming_api_id" id="filenaming_api_id" value="<%=filenaming_api_id%>"></td>
<!--	
<img src='../../eCommon/images/mandatory.gif' align=middle> </tr>
<tr>
<td width='33%'></td>
<td width='50%'></td>										  
</tr>
</table>
</div>
</td> 
-->	
	<td class=label ><fmt:message key="eXH.FileType.Label" bundle="${xh_labels}"/></td> 
	<td class='fields'>
		<select class='select' name=file_type id=file_type onChange="dispStyleShtPath();">
			<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<option value='T' <%=file_type.equals("T")?"selected":""%>><fmt:message key="Common.Text.label" bundle="${common_labels}"/></option>
			<option value='F' <%=file_type.equals("F")?"selected":""%>><fmt:message key="eXH.FoxPro.Label" bundle="${xh_labels}"/></option>
			<option value='X' <%=file_type.equals("X")?"selected":""%>><fmt:message key="eXH.XML.Label" bundle="${xh_labels}"/></option>
			<option value='M' <%=file_type.equals("M")?"selected":""%>><fmt:message key="eXH.MDB.Label" bundle="${xh_labels}"/></option>
			<option value='N' <%=file_type.equals("N")?"selected":""%>><fmt:message key="eXH.NOTIFICATION.Label" bundle="${xh_labels}"/></option>
		</select>		
	</td>
	<!-- <img src='../../eCommon/images/mandatory.gif' align=middle>	 -->
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.FileInterval.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=file_intrvl size=5 
	value='<%=XHDBAdapter.checkNull(file_intrvl)%>' onblur='checkt(this);' onKeyPress='return CheckForSpecCharsforID(event);' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>

<!--   <td colspan=3 id='datainterval1'>							 
	<div id='datainterval'>
	<table>
	<tr>
	<td width='33%'></td>
	<td width='50%'></td> 
	</tr>
	<tr> -->
	<td class=label ><fmt:message key="eXH.DataInterval.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=data_intrvl size=5 value='<%=XHDBAdapter.checkNull(data_intrvl)%>' onblur='checkt(this);' onKeyPress='return CheckForSpecCharsforID(event);'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	</tr>
<!--	 
<td width='33%'></td>
	<td width='50%'></td>
	 </table>
	 </DIV>
	</td> 
</tr>
-->
<tr>
	<td class=label ><fmt:message key="eXH.ErrorDir.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=error_dir size=35 value='<%=XHDBAdapter.checkNull(error_dir)%>' onblur='validDir(this,"Error Directory");'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
    <td colspan=2>  </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table>
</div>	

<div id='styleshtPath' style="display:<%=styleshtDisp%>;" >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td></td> <td></td> 
	<td class=label > <fmt:message key="eXH.StyleShtPath.Label" bundle="${xh_labels}"/>
</td>
	<td><input type=text name=stylesht_path size=35 onblur='validXMLStyleSht(this);' value='<%=XHDBAdapter.checkNull(stylesht_path)%>'>
</td></tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table>
</div>	

<div id='tcpip' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr></tr>
<tr>
	<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.TCPIPSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr  id='dispIp_Port'  style="display:<%=chkProtTypeO%>;">	
	<td class=label  ><fmt:message key="eXH.IPAddress.Label" bundle="${xh_labels}"/></td>
	<td align=left  ><input type=text name=ip_address size=35 value='<%=XHDBAdapter.checkNull(ip_address)%>' onblur='checkIpAddress(this)'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>

	<td class=label  ><fmt:message key="eXH.PortNumber.Label" bundle="${xh_labels}"/></td>
	<td align=left  ><input type=text name='port_noO' id='port_noO' size=10  maxlength=6 value='<%=XHDBAdapter.checkNull(port_no)%>' onblur='chkRange(this);'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>

<tr  id='disp_Port'  style="display:<%=chkProtTypeI%>;">	
	<td class=label  ><fmt:message key="eXH.PortNumber.Label" bundle="${xh_labels}"/></td>
	<td align=left  ><input type=text name='port_noI' id='port_noI' size=10  maxlength=6 value='<%=XHDBAdapter.checkNull(port_no)%>' onblur='chkRange(this);'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td colspan=2 > <td>
</tr>

<tr id='disp_Retry'>
	<td class='label'><fmt:message key="eXH.RetryInterval.Label" bundle="${xh_labels}"/></td>
	<td align='left'>
		<input type='text' name='retry_intrvl' id='retry_intrvl' size='5' maxlength='3' value='<%=XHDBAdapter.checkNull(retry_intrvl)%>' onblur='checkNumber(this);'>
		<img src='../../eCommon/images/mandatory.gif' align='middle'>
	</td>
	<td class='label'><fmt:message key="eXH.MaximumRetries.Label" bundle="${xh_labels}"/></td>
	<td align='left'>
		<input type='text' name='max_retries' id='max_retries' size='5' maxlength='3' value='<%=XHDBAdapter.checkNull(max_retries)%>' onblur='checkNumber(this);'>
		<img src='../../eCommon/images/mandatory.gif' align='middle'>
	</td>

</tr>
<tr>
	<td class=label ><fmt:message key="eXH.AutomaticRestartType.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
	<select name ='auto_restart_type' onchange='setAutoRsrtTime(this);'>
		
		<option value='A' <%=auto_restart_type.equals("A")?"selected":""%>><fmt:message key="Common.At.label" bundle="${common_labels}"/></option> 
		<option value='E' <%=auto_restart_type.equals("E")?"selected":""%>><fmt:message key="Common.Every.label" bundle="${common_labels}"/></option>
		<option value='N' <%=auto_restart_type.equals("N")?"selected":""%>><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
	</select> 
	</td>
	<td class=label ><fmt:message key="eXH.AutomaticRestartTime.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name='auto_restart_time' id='auto_restart_time' size=5 maxlength=5  readOnly value='<%=XHDBAdapter.checkNull(auto_restart_time)%>' onBlur='checkAutoRstrtTm(this);' onKeyPress='return CheckForSpecCharsforID(event);' > 
	</td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table>
</div>	

<div id='fax' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='COLUMNHEADER' colspan=4 >Fax Settings</td>
</tr>
<tr>
	<td class=label >Fax</td>
	<td align=left>
	<input type="text" name="fax_id" id="fax_id" size='5' onBlur='searchFaxId();' value="<%=XHDBAdapter.checkNull(fax_id)%>">
	<input type=text id="recipient_name"  name =recipient_name size=25  value='<%=XHDBAdapter.checkNull(recipient_name)%>'> <input  type="button"  name=faxIdSearch value='?'    onClick="searchFaxId();">
	</td>
</tr>
</table>
</div>	

<div id='mail' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='COLUMNHEADER' colspan=4 >Mail Settings</td>
</tr>
<tr>
	<td class=label >Mail</td>
	<td align=left>
		<input type="text" name="mail_id" id="mail_id" size='5' onBlur='searchMailId();' value="<%=XHDBAdapter.checkNull(mail_id)%>">
		<input type=text id="to_mail"  name =to_mail size=25  value='<%=XHDBAdapter.checkNull(to_mail)%>'> <input  type="button"  name=mailIdSearch value='?'    onClick="searchMailId();">
</td>
</tr>
</table>
</div>

<div id='odbc' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
<tr>
	<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.ODBCSettings.Label" bundle="${xh_labels}"/></td>
</tr> 
<tr>
	<td class=label ><fmt:message key="eXH.DBCONNSTRING.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=db_conn_string size=30 value='<%=XHDBAdapter.checkNull(db_conn_string)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>

	<td class=label ><fmt:message key="eXH.DBDRIVER.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=db_driver size=30 value='<%=XHDBAdapter.checkNull(db_driver)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>

</tr>
<tr>														   
	<td class=label ><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td align=left><input type=text name=odbc_uid size=20 maxlength=30  value='<%=XHDBAdapter.checkNull(odbc_uid)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>

	<td class=label ><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td align=left><input type=password name=odbc_pwd size=22  maxlength=30 value='<%=XHDBAdapter.checkNull(odbc_pwd)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.ODBCSID.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=odbc_sid size=20 maxlength=30 value='<%=XHDBAdapter.checkNull(odbc_sid)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
 <!--  <td class=label ><fmt:message key="Common.URL.label" bundle="${common_labels}"/></td> -->
<td></td><td> </td>
</tr>
<tr id='oralceQuery' style="display:none">
	<td class=label  ><fmt:message key="eXH.OracleTableQuery.Label" bundle="${xh_labels}"/></td> 
	<td align=left colspan=2>
		<textarea name='oracle_table_qry2' rows="6" cols="60" ><%=XHDBAdapter.checkNull(oracle_table_qry)%></textarea> <img src='../../eCommon/images/mandatory.gif' align=middle>
	<td> </td> 
	
</tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table> 
</div>	


<!-- Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 --->
<div id='javamailDiv' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
<tr>
	<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.MailTitle.Label" bundle="${xh_labels}"/></td>
</tr>

<tr>														   
	<td class=label ><fmt:message key="eXH.MailUsername.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=mail_uid id="mail_uid" size=30 maxlength=30  value='<%=XHDBAdapter.checkNull(mail_uid)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
																
	<td class=label ><fmt:message key="eXH.MailPassword.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=password name=mail_pwd id="mail_pwd" size=30 maxlength=30  value='<%=XHDBAdapter.checkNull(mail_pwd)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr>														   
	<td class=label ><fmt:message key="eXH.MailConfiguration.Label" bundle="${xh_labels}"/></td>
		<td class='fields' align='LEFT'>
		<select name ='mail_config' id="mail_config" >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<% 
		try															    
		{  
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='XH_MAIL_CONFIGURATION'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);				
			while(rs.next())
			{
				if(mail_config.equals(rs.getString(2).toString().trim()))
				{
	%>				 
				<option value='<%=rs.getString(2).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(2).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>
		</select> 
		</td>	
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.MailSMTPAuth.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=checkbox name=mail_smtp_auth_flag <%=mail_smtp_auth_flag%>> </td>
		
	<td class=label ><fmt:message key="eXH.MailStarttls.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=checkbox name=mail_smtp_starttls_flag <%=mail_smtp_starttls_flag%>> </td>
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.MailHost.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=mail_host id="mail_host" value='<%=XHDBAdapter.checkNull(mail_host)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	
	<td class=label ><fmt:message key="eXH.MailPort.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=mail_port id="mail_port" value='<%=XHDBAdapter.checkNull(mail_port)%>'> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.MailAttachment.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=checkbox onclick="EnableDisableTextBox(this)" id="mail_attachment_flag" name=mail_attachment_flag <%=mail_attachment_flag%>> </td>
	

</tr>
<tr>
	<td width='20%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>
</table> 
</div>
</div>
<!-- Added By Niveditha on 22/01/2020 for AAKH-CRF-0113 --->


<div id='oracle_table' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
<tr>
	<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.OracleTableSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eXH.OracleTableQuery.Label" bundle="${xh_labels}"/></td>
	<td align=left>
		<textarea name='oracle_table_qry' rows="6" cols="60" > <%=XHDBAdapter.checkNull(oracle_table_qry)%></textarea> 
	<td> </td> <td> </td>
</tr>
<!--<tr>
	<td class=label ><fmt:message key="eXH.OracleTableInsertQuery.Label" bundle="${xh_labels}"/></td>
	<td align=left>	   
		<textarea name="oracle_table_ins_qry" rows="6" cols="60" > <%=XHDBAdapter.checkNull(oracle_table_ins_qry)%></textarea>
	</td>
	<td> </td> <td> </td>
</tr>
-->
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>	

<div id='replication' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td> 
	<td width='20%'></td>													  
</tr>
<tr>
	<td class='CAGROUP' colspan=4 align=left><font color=blue><fmt:message key="eXH.replication.Label" bundle="${xh_labels}"/></font></td>
</tr>
<tr></tr>
<tr>
	<td class='COLUMNHEADER' colspan=4 ><fmt:message key="eXH.replSettings.Label" bundle="${xh_labels}"/></td>
</tr>
<tr> 
	<td class=label ><fmt:message key="eXH.DBLink.Label" bundle="${xh_labels}"/></td>
	<td align=left>
	<input type="hidden" name="dblink_id" id="dblink_id" size='5'  value='' >
	<input type=text   name ='dblink_name' size=35  value='<%=XHDBAdapter.checkNull(dblink_name)%>'> <!-- <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=dbLinkSearch value='?'    onClick="searchDBLink();">-->  <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
    <td> </td>     <td> </td>
</tr>
<tr> 
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<div id='webserviceDiv' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center>	
	<tr></tr>
	<tr>
		<td class='COLUMNHEADER' colspan=4>
			<LABEL ID='labelhdr' FOR='labelhdr'><%= settingHeader %></LABEL>&nbsp;
			<fmt:message key="eXH.Settings.Label" bundle="${xh_labels}"/>
		</td>
	</tr>
	<tr id='webserviceURLTR'>	
		<td class='LABEL'>
			<fmt:message key="Common.URL.label" bundle="${common_labels}"/>
		</td>
		<td CLASS='fields' align='LEFT' >
			<input type='text' name='url' id='url' id='url' size='55' value='<%=XHDBAdapter.checkNull(url)%>'>
			<img src='../../eCommon/images/mandatory.gif' align='middle'>
		</td>		
	</tr>
	<tr>
		<td class='LABEL'>
			<fmt:message key="Common.username.label" bundle="${common_labels}"/>
		</td>
		<td CLASS='fields' align='LEFT'>
			<input type='text' name='userName' id='userName' id='userName' size='10' value='<%=XHDBAdapter.checkNull(userName)%>'> 
			<img src='../../eCommon/images/mandatory.gif' align='middle'>
		</td>
		<td class='LABEL'>
			<fmt:message key="Common.password.label" bundle="${common_labels}"/>
		</td>
		<td CLASS='fields' align='LEFT'>
			<input type='password' name='password' id='password' id='password' size='10' value='<%=XHDBAdapter.checkNull(password)%>'> 
			<img src='../../eCommon/images/mandatory.gif' align='middle'>
		</td>
	</tr>
	<tr id='disp_Retry'>
		<td class='label'><fmt:message key="eXH.RetryInterval.Label" bundle="${xh_labels}"/></td>
		<td align='left'>
			<input type=text name='wsRetryInterval' id='wsRetryInterval' size=5 maxlength=3 value='<%=XHDBAdapter.checkNull(retry_intrvl)%>' onblur='checkNumber(this);'>
			<img src='../../eCommon/images/mandatory.gif' align=middle>
		</td>
		<td class='label'><fmt:message key="eXH.MaximumRetries.Label" bundle="${xh_labels}"/></td>
		<td align='left' CLASS='fields'>
			<input type=text name='wsMaxRetries' id='wsMaxRetries' size=5 maxlength=3 value='<%=XHDBAdapter.checkNull(max_retries)%>' onblur='checkNumber(this);'>
			<img src='../../eCommon/images/mandatory.gif' align=middle>
		</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="eXH.AutomaticRestartType.Label" bundle="${xh_labels}"/></td>
		<td class='fields'>
		<select name ='wsAutoRestartType' onchange='setAutoRsrtTime(this);'>
			<option value='A' <%=auto_restart_type.equals("A")?"selected":""%>><fmt:message key="Common.At.label" bundle="${common_labels}"/></option> 
			<option value='E' <%=auto_restart_type.equals("E")?"selected":""%>><fmt:message key="Common.Every.label" bundle="${common_labels}"/></option>
			<option value='N' <%=auto_restart_type.equals("N")?"selected":""%>><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
		</select> 
		</td>
		<td class=label><fmt:message key="eXH.AutomaticRestartTime.Label" bundle="${xh_labels}"/></td>
		<td align='left' CLASS='fields'><input type=text name='wsAutoRestartTime' id='wsAutoRestartTime' size=5 maxlength=5 readOnly value='<%=XHDBAdapter.checkNull(auto_restart_time)%>' onBlur='checkAutoRstrtTm(this);' onKeyPress='return CheckForSpecCharsforID(event);' > 
		</td>
	</tr>
	<!-- //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification --soap communication added style="display:<%=soapWebserviceDisp%>;"-->
	<tr id='soaptr1' >	
		<td class='LABEL' >
			Soap Action
		</td>
		<td CLASS='fields' align='LEFT'>
			<input type='text' name='httpSoapAction' id='httpSoapAction' id='httpSoapAction' size='35' value='<%=XHDBAdapter.checkNull(httpSoapAction)%>'>
			
		</td>
		<td class=label >Http User Agent</td>
		<td class='fields'>
		<select name ='userAgent' >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<% 
		try															    
		{  
			// list_elmt_value and list_elmt_label are equal for soap transaction. we will store the label value to the xh_protocol table.
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='XH_HTTP_USER_AGENT'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);			
			
			while(rs.next())
			{
				if(httpUserAgent.equals(rs.getString(2).toString().trim()))
				{
	%>				 
				<option value='<%=rs.getString(2).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(2).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>
		</select> 
		
		</td>
	</tr>

	<tr id='soaptr2' >	
		
		<td class=label align='LEFT'> Content Type </td>
		<td class='fields' align='LEFT'>
		<select name ='contentType' >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<% 
		try															    
		{  
			// list_elmt_value and list_elmt_label are equal for soap transaction. we will store the label value to the xh_protocol table.
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='XH_HTTP_CONTENT_TYPE'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);			
			
			while(rs.next())
			{
				if(httpContentType.equals(rs.getString(2).toString().trim()))
				{System.out.println("*******************SOAP 2*******************"+httpContentType);
	%>				 
				<option value='<%=rs.getString(2).toString().trim()%>' selected><%=rs.getString(2)%></option> 
	<%
				}
				else
				{
	%>
				<option value='<%=rs.getString(2).toString().trim()%>' ><%=rs.getString(2)%></option> 
	<%
				}
			}
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}
	%>
		</select> 
		
		</td>	
		<td class='LABEL'>
			Transfer Encoding
		</td>
		<td CLASS='fields' align='LEFT'>
			<input type='text' name='httpTransferEncoding' id='httpTransferEncoding' id='httpTransferEncoding' size='30' value='<%=XHDBAdapter.checkNull(httpTransferEncoding)%>'> 
			
		</td>
	</tr>
	<tr id='soaptr3' >
		
		<td class='LABEL'>	
			Content Length
		</td>
		<td CLASS='fields' align='LEFT'>
			<input type='text' name='httpContentLength' id='httpContentLength' id='httpContentLength' size='10' value='<%=XHDBAdapter.checkNull(httpContentLength)%>'> 
			
		</td>
	</tr>
</table>
</div>
<!-- Added by Sethu for MMS-DM-CRF-0085.3 -->
<div id='connParamDiv'>
<% 
	try															    
		{  
			
			String queryCommApplication = "Select COMM_PROCESS_IDLE_TIME from     XH_PROTOCOL a,    XH_PROTOCOL_LINK b,    XH_INTERACTIVE_CONNECT_PARAM c "
											+ " where  a.PROTOCOL_ID = b.PROTOCOL_ID and b.APPLICATION_ID = c.PLUGIN_TYPE and a.PROTOCOL_ID = ?";
			pstmt = con.prepareStatement(queryCommApplication);
			pstmt.setString(1, protocol_id);
			rs	 =	pstmt.executeQuery();				
			while(rs.next())
			{
				commFlag = 1;
				CommProcessIdleTime = rs.getInt(1);				
			}
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1 queryCommApplication) "+e1.toString());
		}

		

		if (commFlag > 0)
			fieldMode = "ENABLE";
		else
			fieldMode = "DISABLED";
		

		System.out.println(" ::: commFlag ::: "+commFlag+ " ::: fieldMode ::: "+fieldMode);
%>
<table cellspacing=0 cellpadding=0	 width='32%' align=left>	
	<tr id='commProcessWaitTime' >		
		<td class='LABEL' align='LEFT'>	
			Wait Time (in seconds)
		</td>
		<td CLASS='fields' align='LEFT'>
			<input type='text' name='CommProcessIdleTime' id='CommProcessIdleTime' id='CommProcessIdleTime'  <%=fieldMode%> size='10' maxlength="4" value='<%=CommProcessIdleTime%>' onKeyPress='return CheckForNumbers(event);' > 			
		</td>
		<td class='LABEL' align='LEFT'>	
		</td>
		<td CLASS='fields' align='LEFT'>
		</td>
	</tr>
</table>
</div>


<table cellspacing=0 cellpadding=3 width='100%' align=center id='addFileCtrlStr' style='display:none'>
<!--<tr>
	<td width='75%'class=label > <td>
    <td>
		<input class='button' type="button"  name='add_butt' id='add_butt' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>'  onClick='funAdd()' >
		<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
	</td>
</tr>
-->																		 
<tr>																		   
<td> </td><td> </td>
<td colspan=2 class="BUTTON"><input class='button' type="button"  name='add_butt' id='add_butt' value='<fmt:message key="eXH.AddFileCtrlStr.Label" bundle="${xh_labels}"/>'  onClick='funAdd()' >
<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch()'>
</tr>

</table>									    					 

<%
        soapWebserviceDisp = "none";
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>


													 
<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>
<input type="hidden" name="strQry" id="strQry" value=""> 
<input type="hidden" name="tmformatflag" id="tmformatflag" value="">
<%---<input type="hidden" name="module_Id" id="module_Id" value="<%=module_Id%>">
<input type="hidden" name="sub_module_Id" id="sub_module_Id" value="<%=sub_module_Id%>">---%>

<input type="hidden" name="hidCommProcessIdleTime" id="hidCommProcessIdleTime" value="">


</form>
</BODY>
</HTML> 

