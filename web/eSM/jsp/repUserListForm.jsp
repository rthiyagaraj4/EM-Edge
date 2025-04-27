<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



<script>
async function searchCode(obj,target)
{

	var facilityid	   = document.forms[0].p_facility_id.value;
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=encodeURIComponent(getLabel('Common.user.label','Common'));
	var sql="";	

    sql="select APPL_USER_ID code,APPL_USER_NAME description from sm_appl_user where upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) order by 2 ";
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;

	var retVal=await CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	{
	target.value=retVal[0];
	
	
	}
}

function oncheck()
	{
	 parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
	}
	 /* function searchCode1(obj,target){
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="select APPL_USER_ID,APPL_USER_NAME from sm_appl_user ";
			var search_code="APPL_USER_ID";
			var search_desc="APPL_USER_NAME";
			var tit=encodeURIComponent(getLabel('Common.user.label','Common'));
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
*/ 
function CheckString1(str,fromobj,toobj,messageFrame) 
{
	if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
		if(fromobj.value <= toobj.value) 
		{
			return true;
		}
		else 
		{ 
			//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0053 - To " + str + " should be greater than or equal to From " + str ;		
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" +getMessage('TO_USER_GE_FROM_USER','SM') ;		
			return false;
		}
	}	
	else {
		return true;		
	}	

}
</script>
<%
     request.setCharacterEncoding("UTF-8");
	String p_module_id		= "SM" ;
	String p_report_id		= "SMBUSER" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<body onload='FocusFirstElement()' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>
<center>
	<form name="repUserList" id="repUserList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table border='0' align='center' cellspacing='0' cellpadding='0' width='80%'>
		<tr>
					<td width='10%'>&nbsp;</td>
					<td colspan='4'>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
					
		</tr>	
				<TR>
				<td width='20%' class="label" nowrap><fmt:message key="eSM.UserIDFrom.label" bundle="${sm_labels}"/></td>
				<td width='10%' class='fields'>
				<input type="text" name="p_from_appl_user_id" id="p_from_appl_user_id" size="30" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(from_user_id,this);oncheck();'>
				<td width='10%' ><input type='button' align='left' name='from_user_id' id='from_user_id' value='?' class='button' onclick='searchCode(this,p_from_appl_user_id)'><img src='../../eCommon/images/mandatory.gif'></img></td>
				<td width='20%' class="label" width='20%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td width='20%' class='fields'><input type="text" name="p_to_appl_user_id" id="p_to_appl_user_id" size="20" maxlength="30" OnBlur='ChangeUpperCase(this);if(this.value != "") searchCode(to_user_id,this);oncheck();'><input type='button' align='left' name='to_user_id' id='to_user_id' value='?' class='button' onclick='searchCode(this, p_to_appl_user_id)'><img src='../../eCommon/images/mandatory.gif'></img></td>
				<td width='20%' >&nbsp;</td>
			</TR>
			<tr>
				<td width='10%'>&nbsp;</td>
				<td colspan='4'>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
			</tr>	

			<tr>
				<td class="label" nowrap>
					<fmt:message key="eSM.ReportNature.label" bundle="${sm_labels}"/>
				</td>

				<td class='fields'>
					
					<select name="p_report_nature" id="p_report_nature">
					<option value="B"> <fmt:message key="Common.Both.label" bundle="${common_labels}"/>
					<option value="E"> <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
					<option value="D"> <fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
				</select>
				</td>
				<td>&nbsp;</td>

			<td colspan='2'>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td colspan='4'>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	</form>
</center>
</body>

