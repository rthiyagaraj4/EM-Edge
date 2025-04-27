<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
    request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	PreparedStatement pstmt= null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null;

	String ora_pwd_grace_time="";
	String ora_pwd_life_time="";
	String ora_pwd_reuse_time="";
	String ora_pwd_reuse_max="";
	String ora_failed_login_attempts="";
	String ora_pwd_lock_time="";
	String ora_idle_time="";
	String ora_private_sga_unit="";
	String ora_rsrc_group_name="" ;
	String disp="";
	String p_reuse_time="";
	String p_reuse_max_time="";
	String PASSWORD_EXPIRY_ALERT_DAYS="";

	String operation = request.getParameter("operation");	
	if(operation==null) operation="";
	String ora_rsrc_group_id   = request.getParameter("ora_rsrc_group_id");
	if(ora_rsrc_group_id==null) ora_rsrc_group_id="";

	if(!(operation.equals("insert")))
	{
	
	  String sql ="SELECT ora_rsrc_group_id,ora_rsrc_group_name,ora_pwd_grace_time,nvl(ora_pwd_life_time,null)ora_pwd_life_time,ora_pwd_reuse_time,ora_pwd_reuse_max,ora_failed_login_attempts,ora_pwd_lock_time,ora_idle_time,ora_sessions_per_user,ora_connect_time ,ora_private_sga	,ora_private_sga_unit,ora_cpu_per_session,ora_cpu_per_call,ora_ir_per_session,ora_ir_per_call,PASSWORD_EXPIRY_ALERT_DAYS from SM_ORA_RSRC_GRP where ora_rsrc_group_id =? ";
	  
	  System.err.println("AddModifyDatabaseRsrcgrp.jsp====>"+sql);
	  
		pstmt = con.prepareStatement( sql );
		pstmt.setString	(	1,	ora_rsrc_group_id		);
		rs    = pstmt.executeQuery() ;
		
		if(rs!=null)
		{
		 if(rs.next())
		  {
			ora_rsrc_group_id = rs.getString ("ora_rsrc_group_id");
			if(ora_rsrc_group_id == null ) ora_rsrc_group_id = "";

			ora_rsrc_group_name = rs.getString ("ora_rsrc_group_name");
			if(ora_rsrc_group_name == null ) ora_rsrc_group_name = "";

			ora_pwd_grace_time  = rs.getString ("ora_pwd_grace_time");
			if(ora_pwd_grace_time == null ) ora_pwd_grace_time = "";

			ora_pwd_life_time   = rs.getString ("ora_pwd_life_time");
			if(ora_pwd_life_time == null ) ora_pwd_life_time = "";

			ora_pwd_reuse_time  = rs.getString ("ora_pwd_reuse_time");
			if(ora_pwd_reuse_time == null ) ora_pwd_reuse_time = "";

			ora_pwd_reuse_max   = rs.getString ("ora_pwd_reuse_max");
			if(ora_pwd_reuse_max == null ) ora_pwd_reuse_max = "";

			ora_failed_login_attempts = rs.getString ("ora_failed_login_attempts");
			if(ora_failed_login_attempts == null ) ora_failed_login_attempts = "";

			ora_pwd_lock_time  = rs.getString ("ora_pwd_lock_time");
			if(ora_pwd_lock_time == null ) ora_pwd_lock_time = "";
			
			PASSWORD_EXPIRY_ALERT_DAYS  = rs.getString ("PASSWORD_EXPIRY_ALERT_DAYS");
			if(PASSWORD_EXPIRY_ALERT_DAYS == null ) PASSWORD_EXPIRY_ALERT_DAYS = "";
			}
	}	
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
}
%>

<HTML>
<HEAD>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eSM/js/DatabaseRsrcgrp.js' language='javascript'></script>
	<TITLE><fmt:message key="eSM.DatabaseResourceGroup.label" bundle="${sm_labels}"/></TITLE>
	

<SCRIPT language = "JavaScript">
   function enableReuseOption(obj)
	{
	//document.forms[0].ORA_PWD_REUSE_TIME.value="";
//	if(document.forms[0].changes.value=='C')
   // obj.value='R';
	if(obj.value=='R')
	{
	document.forms[0].ORA_PWD_REUSE_TIME.style.visibility='visible';
	document.forms[0].changes.style.visibility='visible';
	document.getElementById('reuseafterhide').style.visibility='visible';
	//Maheshwaran K added for Password Validation as on 18/07/2012
	document.forms[0].mand_img.style.visibility='visible';
	
	}else
	{
	document.forms[0].ORA_PWD_REUSE_TIME.style.visibility='hidden';
	document.forms[0].ORA_PWD_REUSE_TIME.value='';
	document.forms[0].changes.style.visibility='hidden';
	document.getElementById('reuseafterhide').style.visibility='hidden';
	//Maheshwaran K added for Password Validation as on 18/07/2012
	document.forms[0].mand_img.style.visibility='hidden';
	}
		
		
	}
	
	function ExpVal()
	{	
		//document.DBResourceGrp_form.changes.value = 'D';
		//document.DBResourceGrp_form.changes.disabled = false;//Maheshwaran K changed

		if(document.DBResourceGrp_form.elements[2].checked)
		{	
			document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.value = "";
			document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.value = "";						
			document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.readOnly  = true;
			document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.readOnly = true;			
			document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.disabled  = true;
			document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled = true;	
			document.DBResourceGrp_form.changes.disabled=false;
			document.DBResourceGrp_form.password_expiry_alert_days.disabled=true;
			document.DBResourceGrp_form.password_expiry_alert_days.value="";
			
			document.DBResourceGrp_form.img_password_expiry_alert_days.style.visibility='hidden';
			
			
		}	
		
		if(document.DBResourceGrp_form.elements[3].checked){			
			document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.readOnly = false;
			document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.disabled = false;
			document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.readOnly = false;						
			document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled = false;
			document.DBResourceGrp_form.password_expiry_alert_days.disabled=false;
			document.DBResourceGrp_form.img_password_expiry_alert_days.style.visibility='visible';
			document.DBResourceGrp_form.password_expiry_alert_days.value="14";
		}				
		
		
		if(document.DBResourceGrp_form.prohibitReuse.value=='R')
		{		
			document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = false;		
			//document.DBResourceGrp_form.changes.disabled=false;
		}
		else
		{
			document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value	= "";		
			//document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = true;		
			//document.DBResourceGrp_form.changes.disabled=true;
		}
		if(document.DBResourceGrp_form.changes.checked)
		{		
			
			document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = false;		
			//document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = true;		
		}
		else
		{		
			
			document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value= "";		
			document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;		
		}
		
				

		if(document.DBResourceGrp_form.prohibitReuse.value=='P')
		{				
			//document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.readOnly = true;
			document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.readOnly  = true;	
		}
		else
		{		
			document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.readOnly = false;
			document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.readOnly  = false;	
		}
	}
	
	function ExpVal1(Obj)
	{
	var val = Obj.name;
	
	
		if(val== "TimesOutAfter")
		{				
			document.DBResourceGrp_form.NeverTimesOut.checked  = false;			
			document.DBResourceGrp_form.TimesOutAfter.checked  = true;
			
			
		}	

		else if(val =="NeverTimesOut")
		{				
			document.DBResourceGrp_form.ExpPeriodVal.value = 			document.DBResourceGrp_form.TimesOutAfter.checked  = false
			document.DBResourceGrp_form.NeverTimesOut.checked  = true;
		}
	}	
	
	function ExpVal2()
		{
			if(document.DBResourceGrp_form.reuseAfter.checked==true)
			{	
		
				document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = false;		
				document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;		
				document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value = "";						
				document.DBResourceGrp_form.changes.disabled =false;			
			}
			else
			{
				document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value = "";	
				document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;	
				//document.DBResourceGrp_form.changes.disabled =true;			
				document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.disabled = true;		
			}

		}	

	function ExpVal3()
		{
			if(document.DBResourceGrp_form.changes.value=='C')
			{			
			}
			else
			{
			}
		}

	function CheckForNumber(obj) 
	{
		if (obj.value.length > 0 )
		{
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)
			{		
				alert(getMessage('CANNOT_START_WITH_NUMERIC','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}

			if (obj.value.substr(0,1) >= 0)
			{
				alert(getMessage('CANNOT_START_WITH_NUMERIC','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}
		}
	}
	
	
	
	function DisabFunc()
	{
		
		//document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.disabled = false;
		//document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled = false;
		document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.disabled = true;		
	}

function CheckPositiveNumber1(obj)
		{	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage('VALUE_SHOULD_BE_GR_ZERO','Common'));
  			obj.select();
  			obj.focus();
  		}
  	}
}
function CheckSpecialChar(obj)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();

	SpChar[0] = '~';
	SpChar[1] = '`';
	SpChar[2] = '!';
	SpChar[3] = '@';
	SpChar[4] = '#';
	SpChar[5] = '$';
	SpChar[6] = '%';
	SpChar[7] = '^';
	SpChar[8] = '&';
	SpChar[9] = '*';
	SpChar[10] = '(';
	SpChar[11] = ')';
	SpChar[12] = '-';
	SpChar[13] = '+';
	SpChar[14] = '=';
	SpChar[15] = '|';
	SpChar[16] = '\\';
	SpChar[17] = '[';
	SpChar[18] = ']';
	SpChar[19] = '{';
	SpChar[20] = '}';
	SpChar[21] = ':';
	SpChar[22] = ';';
	SpChar[23] = '"';
	SpChar[24] = '<';
	SpChar[25] = '>';
	SpChar[26] = '?';
	SpChar[27] = '/';
	SpChar[28] = '\'';
	SpChar[29] = '';
	SpChar[30] = ',';
	SpChar[31] = '.';

	if (fieldval.substr(0,1) == '_'  ) 
	{
		to_check = false;
	}

	for (var i=0;i<fieldlen;i++)
	{

		if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null)
		{
			to_check = false;
		}

		for (var j=0;j<=31;j++)
		{
			if (fieldval.substr(i,1) == SpChar[j])
			{
				to_check = false;
			}
		}
	}

	if (to_check == false)
	{
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		obj.select();
		obj.focus();
		obj.value='';
	}
}

function enabdisbpasswdlock()
{
	if (parseInt(document.DBResourceGrp_form.ORA_FAILED_LOGIN_ATTEMPTS.value.substring(0,1)) > 0 )
	{
		document.DBResourceGrp_form.ORA_PWD_LOCK_TIME.disabled=false;
	}
	else
	{
		document.DBResourceGrp_form.ORA_PWD_LOCK_TIME.value="";
		document.DBResourceGrp_form.ORA_PWD_LOCK_TIME.disabled=true;
	}

}

function enabdisblifegrace()
{
	if (parseInt(document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.value.substring(0,1)) > 0 )
	{
		document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled=false;
	}
	else
	{
		document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.value="";
		document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.disabled=true;
	}

}
function CheckForSpecCharsforID(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</HEAD>

<BODY  onload='FocusFirstElement();enableReuseOption(document.forms[0].prohibitReuse)' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<FORM name='DBResourceGrp_form' id='DBResourceGrp_form' ACTION='../../servlet/eSM.DatabaseRsrcgrpServlet' method='post' target='messageFrame'>
<BR><BR><BR><BR><BR><BR><BR>

<table width='95%' cellpadding='0' cellspacing='0' align='center' border='0'>
<tr>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	
</tr>
<tr>
	
	<td class='label' ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<input type="text" name="ORA_RSRC_GROUP_ID" id="ORA_RSRC_GROUP_ID" maxlength='20' onBlur="ChangeUpperCase(this)" onKeyUp="CheckForNumber(this);" onKeyPress="return CheckForSpecCharsforID(event)" value="<%=ora_rsrc_group_id%>"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
	</td>
	<td class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" onBlur='makeValidQueryCriteria(this)' name="ORA_RSRC_GROUP_NAME" id="ORA_RSRC_GROUP_NAME" maxlength='30' size = '10' value="<%=ora_rsrc_group_name%>"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	
</tr>
<tr><td colspan='4' class='label'>&nbsp;</td></tr>

<tr><th colspan='4' align='left' width='100%'><fmt:message key="eSM.PasswordControl.label" bundle="${sm_labels}"/></th></tr>
<tr>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
</tr>
<tr>	
	<td class='label' ><fmt:message key="eSM.ExpirationPeriod.label" bundle="${sm_labels}"/></td>
	<td class='fields'>
	<%
		String ednone = "";
		String eddays = "";
		String imgvis = "visibility:hidden";

		//if (ora_pwd_life_time!=null && !ora_pwd_life_time.equals(""))
		if (PASSWORD_EXPIRY_ALERT_DAYS!=null && !PASSWORD_EXPIRY_ALERT_DAYS.equals(""))	
		{
			ednone = "";
			disp="";
			eddays = "checked";
			imgvis = "visibility:visible";
		}
		else
		{
			ednone = "checked";
			disp="disabled";
			eddays = "";
		}
	%>
	<input type="radio" name="ExpPeriod1" id="ExpPeriod1"  value="none" onClick="ExpVal()" <%=ednone%> ><fmt:message key="Common.none.label" bundle="${common_labels}"/>
	<input type="radio" name="ExpPeriod1" id="ExpPeriod1"  value="days"  onClick="ExpVal()" <%=eddays%> >
	<input type="text" name="ORA_PWD_LIFE_TIME" id="ORA_PWD_LIFE_TIME"  <%=disp%> size='3'  onBlur="CheckPositiveNumber1(this)" onKeyUp="enabdisblifegrace()" onKeyPress="return(ChkNumberInput(this,event,0))" maxlength='3' value='<%=ora_pwd_life_time%>' >&nbsp;<span ><fmt:message key="Common.days.label" bundle="${common_labels}"/></span></td>
	<td class='label'><fmt:message key="eSM.GraceTime.label" bundle="${sm_labels}"/></td>
	<td class='fields'>
	<input type="text" name="ORA_PWD_GRACE_TIME" id="ORA_PWD_GRACE_TIME" size='3' onBlur="CheckPositiveNumber1(this)" onKeyPress="return(ChkNumberInput(this,event,0))" maxlength='3' value='<%=ora_pwd_grace_time%>' <%=disp%>>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
</tr>



<tr>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eSM.ReuseOption.label" bundle="${sm_labels}"/></td>
	<td class='fields'>
		

    <SELECT name="prohibitReuse" id="prohibitReuse" onChange='enableReuseOption(this)'>
	 
	  <option value='P' ><fmt:message key="eSM.ProhibitReuse.label" bundle="${sm_labels}"/></option>
	  <option  value='R'><fmt:message key="eSM.Reuse.label" bundle="${sm_labels}"/></option>
	 </select>
	</td>
	<input type="hidden" name="ORA_PWD_REUSE_MAX" id="ORA_PWD_REUSE_MAX" size='3' value='2147483646'  onBlur="CheckPositiveNumber1(this)" maxlength='3'>
	</td>
	
	<%if ((ora_pwd_reuse_time.equals("") && !ora_pwd_reuse_max.equals("") ) || (ora_pwd_reuse_time==null && ora_pwd_reuse_max!=null ))
	{p_reuse_max_time = ora_pwd_reuse_max;%>
	
<script>
//Maheshwaran K has modified the Option value to display the Reuse Option for Password Validation as on 18/07/2012
document.forms[0].prohibitReuse.options[1].selected=true</script>
	<%}
	else if ((!ora_pwd_reuse_time.equals("") && ora_pwd_reuse_max.equals("") ) || (ora_pwd_reuse_time!=null && ora_pwd_reuse_max==null ))
	{
		p_reuse_max_time = ora_pwd_reuse_time;%>
	<script>document.forms[0].prohibitReuse.options[1].selected=true</script>
		
	<%}

%>
	
	<td class='label'  >

<label id='reuseafterhide'><fmt:message key="eSM.Reuse.label" bundle="${sm_labels}"/> <fmt:message key="Common.After.label" bundle="${common_labels}"/>
</label></td><td>
	<input type="text" style='visibility:hidden' name=ORA_PWD_REUSE_TIME size='3' maxlength='3' colspan=1 value='<%=p_reuse_max_time%>' onBlur="putDecimal(this,3,0);CheckPositiveNumber1(this)" onKeyPress="return(ChkNumberInput(this,event,0))" <%=p_reuse_time%> >
	<!--Maheshwaran K added for Password validation as on 18/07/2012-->
	<img name ='mand_img' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'align='center'>&nbsp;
	<!--End-->

	<select name=changes style='visibility:hidden' onChange='ExpVal3()'>
<%

	String d_checked="";
	String c_checked="";

	if (ora_pwd_reuse_max!=null && !ora_pwd_reuse_max.equals(""))
	{
		c_checked="selected";
		d_checked="";
	}
	else
	{
		c_checked="";
		d_checked="selected";
	}

%>
		<option value='D' <%=d_checked%>><fmt:message key="Common.days.label" bundle="${common_labels}"/>
		<option value='C' <%=c_checked%>><fmt:message key="eSM.Changes.label" bundle="${sm_labels}"/>
	</select>
</td>

</tr>



<tr >
	<td colspan='4' class='label'>&nbsp;</td>
</tr>

<TR>	
	<td class='label'   width='20%'><fmt:message key="eSM.FailedLoginAttempts.label" bundle="${sm_labels}"/></td>
	<td class='fields' width='25%' ><input type="text" name="ORA_FAILED_LOGIN_ATTEMPTS" id="ORA_FAILED_LOGIN_ATTEMPTS" size='3' onBlur="putDecimal(this,3,0);CheckPositiveNumber1(this)" onKeyPress="return(ChkNumberInput(this,event,0))" onKeyUp="enabdisbpasswdlock()" maxlength='3' value="<%=ora_failed_login_attempts%>"></td>
	<td class='label'  width='25%'><fmt:message key="eSM.PasswordLockPeriod.label" bundle="${sm_labels}"/></td>
	<td class='fields' width='35%'><input type="text" name="ORA_PWD_LOCK_TIME" id="ORA_PWD_LOCK_TIME" size = '3' onBlur="CheckPositiveNumber1(this)" onKeyPress="return(ChkNumberInput(this,event,0))" MAXLENGTH='3' value="<%=ora_pwd_lock_time%>">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td colspan='4' width='100%' class='label'>&nbsp;</td>
</tr>
<TR>	
	<td class='label'  width='25%'><fmt:message key="eSM.PasswordExpiryAlert.label" bundle="${sm_labels}"/></td>
	<td class='fields' width='35%'><input type="text" name="password_expiry_alert_days" id="password_expiry_alert_days" size = '3' onBlur="CheckPositiveNumber1(this)" onKeyPress="return(ChkNumberInput(this,event,0))" MAXLENGTH='3' value="<%=PASSWORD_EXPIRY_ALERT_DAYS%>" <%=disp%>>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/> <img src='../../eCommon/images/mandatory.gif'align='center' name="img_password_expiry_alert_days" style="<%=imgvis%>"></img></td>
	
</tr>
<tr>
	<td colspan='4' width='100%' class='label'>&nbsp;</td>
</tr>
</table>	

	<input type='hidden' name='function_name' id='function_name' value='<%=operation%>'>
	<input type='hidden' name='ExpPeriodVal' id='ExpPeriodVal'>
	
<%
	if(!(operation.equals("insert")))
	{
%>	
	<SCRIPT>
	
	document.DBResourceGrp_form.ORA_RSRC_GROUP_ID.value="<%=ora_rsrc_group_id %>";	
	document.DBResourceGrp_form.ORA_RSRC_GROUP_ID.readOnly= true;
	document.DBResourceGrp_form.ORA_RSRC_GROUP_NAME.value="<%=ora_rsrc_group_name %>"; 
	document.DBResourceGrp_form.ORA_PWD_GRACE_TIME.value="<%=ora_pwd_grace_time %>";  
	document.DBResourceGrp_form.ORA_PWD_LIFE_TIME.value="<%=ora_pwd_life_time %>";   
	document.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value="<%=p_reuse_max_time%>";  
	document.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value="<%=ora_pwd_reuse_max %>";   
	document.DBResourceGrp_form.ORA_FAILED_LOGIN_ATTEMPTS.value="<%=ora_failed_login_attempts %>"; 
	document.DBResourceGrp_form.ORA_PWD_LOCK_TIME.value="<%=ora_pwd_lock_time %>";  
	</SCRIPT>
<%
	if(ora_private_sga_unit.equals("KB"))
	{
%>	
<%	}	
	else
	{
%>	
<%
	}
%>
<%
	}	
%>



<%
	if ((ora_pwd_grace_time != "")||(ora_pwd_life_time != ""))
	{
%>	
	<SCRIPT>
//		document.DBResourceGrp_form.elements[2].checked = true; 
	</SCRIPT>		
<%	
	}
	else
	{
%>	
	<SCRIPT>
//		document.DBResourceGrp_form.elements[3].checked = true; 
	</SCRIPT>		
<%	
	}

	if ((ora_idle_time != ""))
	{
%>	
	<SCRIPT>		
//		document.DBResourceGrp_form.elements[13].checked = true; 
	</SCRIPT>		
<%	
	}
	else
	{
%>	
	<SCRIPT>		
//		document.DBResourceGrp_form.elements[15].checked = true; 
	</SCRIPT>		
<%	
	}
%>	



<input type=hidden name='change_type' id='change_type' value=''>

</FORM>
</BODY>
<%
}catch(Exception e){out.println(e);
e.printStackTrace();}
			finally {
				if(pstmt != null) pstmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
<script>
DisabFunc();
</script>
</HTML>

