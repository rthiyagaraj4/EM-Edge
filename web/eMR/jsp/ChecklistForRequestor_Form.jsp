<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>


<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language="javascript" src="../js/ChecklistForRequestor.js"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
	function CheckMaxLen1(lab,obj,max,messageFrame) {
		if(obj.value.length > max) {
			msg=getMessage("REMARKS_NOT_EXCEED_200_CH",'SM');
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg ;
			return false;
		} else return true;
}

/*function mandatoryChk()
{
 
	 var fields = new Array ( document.forms[0].requestor_desc);
	 var names  = new Array (getLabel('Common.Requestor.label','Common'));
	 if(checkFieldsofMst( fields, names, parent.parent.frames[2])) {
	 parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	 return true;
	 }
	 else
	 return false;

}
function displayDetails()
{ alert('called');
if(mandatoryChk())
{

var searchcriteria = document.forms[0].search_criteria.value;
alert(searchcriteria);
var searchchklist = escape(document.forms[0].searchchklist.value);
alert("hi"+searchchklist);
parent.frames[2].location.href="../../eMR/jsp/ChecklistForRequestorDetailForm.jsp?userID="+document.forms[0].userID.value+"&searchchklist="+searchchklist+"&searchcriteria="+searchcriteria+"&flagSelect=fromSelect";
alert("end");
}
else
	{
		parent.frames[2].location.href="../../eCommon/html/blank.html";
	}
}*/

/*function clearValues()
{
parent.frames[2].location.href="../../eCommon/html/blank.html";

}*/
function blockevent(event){
       
	 var whichCode = (window.Event) ? event.which : event.keyCode;
    if (whichCode=='13')
	return false ;
}



		function GetLookupBlur(target)
			{
				if(target.value != "")
				{
					GetLookup(target);
				}
				else
				{
					document.forms[0].userID.value="";
					parent.frames[2].location.href="../../eCommon/html/blank.html";

				}
			}

			async function GetLookup(target){
	
			var sql="";			
			var retVal			= new String();
			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;			
			var tit				= getLabel("Common.Requestor.label",'Common');

			
			sql="select REQUESTOR_CODE code,LONG_DESC description from MR_REQUESTOR where eff_status='E' and upper(REQUESTOR_CODE) like upper(?) and upper(long_desc) like upper(?) order by upper(code)";

			argumentArray[0]	= sql;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
			argumentArray[3]	= dataTypeArray ;
			argumentArray[4]	= "1,2";
			argumentArray[5]	=target.value;
			argumentArray[6]	= DESC_LINK;
			argumentArray[7]	= DESC_CODE;

			retVal = await CommonLookup( tit, argumentArray );

			if(retVal != null && retVal != "" )
			{
				var ret1=unescape(retVal);
				arr=ret1.split(",");
				target.value=arr[1];
				//target_id.value=arr[0];
				//clearValues();
				document.forms[0].userID.value=arr[0];
			}
			else
			{
				target.value="";
				//target_id.value="";
				clearValues();

			}
	
}

</script>
<%
	Connection con=null;
	try{
		System.out.println("came=============>>>>>>");
		  request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	//String dat="";
	String fnval="insert";
	//String id="";
	
	
		    							
	
%>
</head>
<body  onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()";>
<form name='respForUser_Form' id='respForUser_Form'>
<table border='0' cellpadding='0' cellspacing='3' align='center'  width='100%' >
	<tr> 
    <td colspan='4' width="25%">&nbsp;</td>
	<td width="25%"></td>
	<td width="25%"></td>
	<td width="25%"></td>
	</tr>
	<tr>
		<td width='25%' class='label' ><fmt:message key="Common.Requestor.label" bundle="${common_labels}"/></td>
		
				<td class='fields'  width='20%'>
				<input type='text' name='requestor_desc' id='requestor_desc' size=22 onblur='GetLookupBlur(requestor_desc)'>
				<input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(requestor_desc)'>
			<img align='center' src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='userID' id='userID' value=''>
			</td>
			<td width="25%">&nbsp;</td><td width="25%">&nbsp;</td>
		</tr>
		<tr>
			<td width='25%' class='label'  ><fmt:message key="Common.search.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.CheckLists.label" bundle="${mr_labels}"/></td>
			<td  class='fields' width='25%'><INPUT TYPE="text"onBlur='makeValidQueryCriteria(this)' name="searchchklist" id="searchchklist" onKeyPress="return blockevent(event)" maxLength="250"></td>
			<td width='25%' class='label'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'><select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>
		</tr>
		
					
	<tr>
	<td width="25%"></td><td width="25%"></td><td width="25%"></td>
		<td class='BUTTON' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='displayDetails()'>
			<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearValues()'></td>
	</tr>
</table>
<input type='hidden' name='function1' id='function1' value='<%=fnval%>'>
<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>

</form>
</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</html>

