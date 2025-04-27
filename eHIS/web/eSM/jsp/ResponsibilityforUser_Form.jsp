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
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eSM/js/FacilitiesForUser.js' language='javascript'></script>
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

function mandatoryChk()
{
 var objname = document.forms[0].object_name.value;
 if(objname == "User")
 {
	 var FIELDS = new Array ( document.forms[0].userName);
	 var names  = new Array (getLabel('Common.user.label','Common'));
	 if(checkFieldsofMst( FIELDS, names, parent.parent.frames[2])) {
	 parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	 return true;
	 }
	 else
	 return false;
 }
 else if(objname == "Resp")
 {
	 var FIELDS = new Array ( document.forms[0].respID);
	 var names  = new Array (getLabel('Common.responsibility.label','Common'));
	 if(checkFieldsofMst( FIELDS, names, parent.parent.frames[2])) {
	 parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	 return true;
	 }
	 else
	 return false;
 }
}
function displayDetails()
{
if(mandatoryChk())
{
var objname = document.forms[0].object_name.value;
var searchcriteria = document.forms[0].search_criteria.value;
if(objname == "User")
{
var searchresp = escape(document.forms[0].searchresp.value);
parent.frames[2].location.href="../../eSM/jsp/ResponsibilityforUserDetailForm.jsp?userID="+document.forms[0].userID.value+"&objname="+objname+"&searchresp="+searchresp+"&searchcriteria="+searchcriteria+"&flagSelect=fromSelect";
}
else if (objname == "Resp")
{
var searchresp = escape(document.forms[0].searchuser.value);
parent.frames[2].location.href="../../eSM/jsp/ResponsibilityforUserDetailForm.jsp?userID="+document.forms[0].respID.value+"&objname="+objname+"&searchresp="+searchresp+"&searchcriteria="+searchcriteria+"&flagSelect=fromSelect";
}
}
else
	{
		parent.frames[2].location.href="../../eCommon/html/blank.html";
	}
}

function clearValues()
{
parent.frames[2].location.href="../../eCommon/html/blank.html";

}
function blockevent(event){
       
	 var whichCode = (window.Event) ? event.which : event.keyCode;
    if (whichCode=='13')
	return false ;
}



		async function GetLookupBlur(target)
			{
				if(target.value != "")
				{
					await GetLookup(target);
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
			var tit				= getLabel("Common.user.label",'Common');

			sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate)  and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";
			

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
		  request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	//String dat="";
	String fnval="insert";
	//String id="";
	String dynlabel="";
	String objectname = request.getParameter("objectname");
	if(objectname.equals("User"))
		dynlabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels");      							
	else if(objectname.equals("Resp"))
		dynlabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels"); 
%>
</head>
<body  onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest()";>
<form name='respForUser_Form' id='respForUser_Form'>
<table border='0' cellpadding='3' cellspacing='0' align='center'  width='100%' >
	<tr> 
    <td colspan='4' width="25%">&nbsp;</td>
	<td width="25%"></td>
	<td width="25%"></td>
	<td width="25%"></td>
	</tr>
	<tr>
		<td width='25%' class='label' ><%=dynlabel%></td>
		<%if(objectname.equals("User")){%>
				<td class='FIELDS'  width='20%'>
				<input type='text' name='userName' id='userName' size=22 onblur='GetLookupBlur(userName)'>
				<input type=button class=BUTTON name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(userName)'>
			<img align='center' src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='userID' id='userID' value=''>
			</td>
			<td width="25%">&nbsp;</td><td width="25%">&nbsp;</td>
		</tr>
		<tr>
			<td width='25%' class='label'  ><fmt:message key="eSM.SearchResponsibility.label" bundle="${sm_labels}"/></td>
			<td  class='FIELDS' width='25%'><INPUT TYPE="text"onBlur='makeValidQueryCriteria(this)' maxlength="35" size="35" name="searchresp" id="searchresp" onKeyPress="return blockevent(event)"></td>
			<td width='25%' class='label'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td width='25%' class='FIELDS'><select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>
		</tr>
		<%}
		if(objectname.equals("Resp")){
		%>
			<td width='25%' class='FIELDS'>
			<select name='respID' id='respID' onChange='clearValues()'>
			<option value='' selected>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			<%
			try
			{
				stmt=con.createStatement();
				String sql3=" select resp_name, resp_id from sm_resp where eff_status='E' and ( (trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >=  trunc(sysdate) )  or (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and  eff_date_from is null)  or (eff_date_from is null and eff_date_to is null)) order by upper(resp_name)  ";
				rset=stmt.executeQuery(sql3);
				if(rset!=null)
				{
				   while(rset.next())
				   {
				   String respdat=rset.getString("resp_name");
				   String respid=rset.getString("resp_id");
				   out.println("<option value='"+respid+ "' >"+respdat+"</option>");
				   }
				}
				if(rset!=null)	rset.close();
				if(stmt!=null)	stmt.close();
				if(pstmt!=null)	pstmt.close();
			}
			catch(Exception e){out.print(e);}
			
			%>
			</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			</td><td width="25%">&nbsp;</td><td width="25%">&nbsp;</td>
		
		</tr>
		<tr>
			<td width='25%' class='label' ><fmt:message key="Common.SearchUser.label" bundle="${common_labels}"/></td>
			<td width='25%' class='FIELDS'><INPUT TYPE="text" onBlur='makeValidQueryCriteria(this)' maxlength="35" name="searchuser" id="searchuser" onKeyPress="return blockevent(event)"><td width='25%' class='label' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td width='25%' class='FIELDS'><select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>
		</tr>
		<%}%>		
	<tr>
	<td width="25%"></td><td width="25%"></td><td width="25%"></td>
		<td class='BUTTON' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onclick='displayDetails()'>
			<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onclick='clearValues()'></td>
	</tr>
</table>
<input type='hidden' name='function1' id='function1' value='<%=fnval%>'>
<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
<input type='hidden' name='object_name' id='object_name' value='<%=objectname%>'>
</form>
</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</html>

