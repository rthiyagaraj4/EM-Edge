<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con					= null;
	Statement stmt=null;
	ResultSet rs =null;
	String facility_id=(String)session.getValue("facility_id");

String operating_facility_id="";
operating_facility_id=(String) session.getValue("facility_id");
	try{
		con=ConnectionManager.getConnection(request);
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function chk_age_validity(obj){
var age_group=obj.value;
if(age_group!="")
		{
			var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='chk_age' id='chk_age' method='post' action='../../eIP/jsp/AgeGroupValidityCheck.jsp'><input type='hidden' name='age_group' id='age_group' value='"+age_group+"'></form></body></html>";	
			parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.frames[2].document.forms[0].submit();
		}
}

// Added by Sridhar on 6 APR 2004
// This is fired on onClick of the button.... 
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty..

function checkTxtVal(target_id,target)
{
	if(document.forms[0].age_group_desc.value == "")
		Lookup(target_id,target);
}


// Added by Sridhar on 3 APR 2004
// Function will check for empty values before calling up the common lookup func..
		
function beforeGetAgeGroup(target_id,target)
{
	if(document.forms[0].agegrp_desc_hid.value != document.forms[0].age_group_desc.value)
	{
		if(document.forms[0].age_group_desc.value != "")
			Lookup(target_id,target);
	}
}
	

/* CODED ON 07/02/04 by SRIDHAR */
/* COMMON LOOKUP FOR AGEGROUP START */
async function Lookup(target_id,target)
{
	var facility_id = "<%=operating_facility_id%>";
	var title="";
	
	var argumentArray=new Array(8);
	
	if(target_id.name == "age_group")
	{
		title=getLabel('Common.agegroup.label','common');

		argumentArray[0]="select AGE_GROUP_CODE code, SHORT_DESC description from AM_AGE_GROUP where EFF_STATUS like ? and upper(AGE_GROUP_CODE) like upper(nvl(?,AGE_GROUP_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";
		
		argumentArray[1]=new Array("EFF_STATUS");
		argumentArray[2]=new Array("E");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
}
			
var retVal= await CommonLookup(title,argumentArray);
var ret1=unescape(retVal);
arr=ret1.split(",");
			
	if(retVal ==null || retVal=="" || !retVal)
	{
		target.value="";
		target_id.value="";
	}
	else
	{
		
		target_id.value=arr[0];
		target.value=arr[1];
		document.forms[0].agegrp_desc_hid.value = document.forms[0].age_group_desc.value
		chk_age_validity(target_id);
	}
}

/* COMMON LOOKUP FOR AGEGROUP END */

function PopulateResult()
{
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	var age_group=document.forms[0].age_group.value;
	document.forms[0].statusval.value='Y';
	if(age_group.length>0)
	{
			parent.frames[1].location.href='../../eIP/jsp/addModifyAgeGroupBkgLimit.jsp?age_group='+age_group;
			parent.frames[2].location.href='../../eIP/jsp/AgeGroupDynamicValues.jsp';
	}
	else
	{
		var err= getMessage("CAN_NOT_BE_BLANK","Common");		
		err= err.replace("$","Age Group");
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err
		
	}
}
</script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
		<td width="20%" >&nbsp;</td>
		<td width="30%" >&nbsp;</td>
	</tr>
	 <tr>
	  	<td align='right' class='label' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		 <td align='left' class='fields' width='60%' id=td5>
		 
		 
			 <!--************ Common Lookup code for Agegroup *************-->
			 <input type="text" name="age_group_desc" id="age_group_desc" size="15" maxlength="15" onblur="beforeGetAgeGroup(age_group,age_group_desc)" ><input type="button" class="button" name="?" id="?" value="?" onclick="checkTxtVal(age_group,age_group_desc)"><input type="hidden" name="age_group" id="age_group" size="2" maxlength="2" ><img align="center" src="../../eCommon/images/mandatory.gif"></img></td> 
			<input type=hidden name="agegrp_desc_hid" id="agegrp_desc_hid" value=''>
	</tr>
	<tr>
		<td colspan=1>&nbsp;&nbsp;</td>
		<td align=right><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search_age' onclick='PopulateResult()'>
		<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='Clear' onclick="parent.frames[1].location.href='../../eCommon/html/blank.html'" ></td>
	</tr>
<input type=hidden name=facility_id value='<%=facility_id%>'>
<input type='hidden' name='statusval' id='statusval' value=''>

</form>
<%
}
catch ( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
	}
finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

