<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
   <%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eSM/js/FacilitiesForUser.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


function mandatoryChk()
{
	 var fields = new Array ( document.forms[0].userID);
	 var message=document.forms[0].label.value;
    
	 var names  = new Array (message);
	 if(checkFieldsofMst( fields, names, parent.parent.frames[2])) {
	 parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	 return true;
	 }
	 else
	 return false;
}
function displayDetails()
{
	
	var searchText = document.resp_form.searchText.value
	var label=document.forms[0].label.value;
    var filter = document.resp_form.filter.value

	if(mandatoryChk())	
	{				  parent.result.location.href="../../eSM/jsp/FacilityforUserDetailForm.jsp?userID="+document.forms[0].userID.value+"&flagSelect=fromSelect&searchText="+searchText+"&label="+label+"&filter="+filter+"&label="+document.forms[0].label.value;
	} else
	{
	 parent.result.location.href="../../eCommon/html/blank.html";

	}
}

function clearValues()
{
	parent.result.location.href="../../eCommon/html/blank.html";
}
function callMember(varAlpha)
{
	

}
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
					document.forms[0].userID.value='';
					parent.result.location.href="../../eCommon/html/blank.html";

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

			sql="select  appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";
			

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
	
	Statement stmt=null;
	ResultSet rset=null ;
	String label = request.getParameter("label")==null ? "" : request.getParameter("label");
	String sqlUser = "";
	String dat="";
	String fnval="insert";
	String id="";
		
	try
	{
%>		
	</head>

	<body  onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()";>
		<form name='resp_form' id='resp_form' action='../../servlet/eSM.FacilityForResponsibilityServlet' method='post' target='messageFrame'>
			
		<table border='0' cellpadding='3' cellspacing='0' align='center'  width='91%' >
			<tr> 
			    <td width="25%" colspan=4>&nbsp;</td>
			    <td width="25%"><td>
			    <td width="25%"><td>
			    <td width="25%"><td>
			</tr>
				    <tr>
				     
					 <td class='label' id ='tdLabel' width="25%"><%=label%></td>
    				 <td class='FIELDS' width="25%">

    				    	<%
    				    		
								if(label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){%>
							<input type='text' name='userName' id='userName' size=22 onblur='GetLookupBlur(userName)'>
							<input type=button class=button name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(userName)'>	
							<img src='../../eCommon/images/mandatory.gif' align='center'>
							<input type='hidden' name='userID' id='userID' value=''>
							</td>

							<%}
							else
							{%>
							<select name='userID' id='userID' onChange='clearValues()'><option value='' selected> ------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
							<%
								stmt=con.createStatement();
								sqlUser = "select facility_name,facility_id from sm_facility_param order by facility_name";
							
							rset=stmt.executeQuery(sqlUser);
				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString(1).trim();
    				    		   id=rset.getString(2);
								   %>
    				    				<option value='<%=id%>' ><%=dat%></option>
    								<%
    				    		   }
    				    		}
								%> </select><img src='../../eCommon/images/mandatory.gif' align='center'>
    				    	  <%
									if(rset!=null)	rset.close();
									if(stmt!=null)	stmt.close();
							}
					 }
				     catch(Exception e){out.print(e);}
				     %>
    				    	
    				     </td>
							<td width="25%"><td>
			    <td width="25%"><td> 
    				</tr>
					
				<tr>
					
					
    					<td  class='label' width="25%">
							
							
							
						<%
							if(label.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels"))){
							out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.SearchFacility.label","sm_labels"));
						}
						else{
							out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SearchUser.label","common_labels"));
						}
						
							%>
							</td>
						
						<td class='FIELDS' width="25%"><input type="text" onBlur='makeValidQueryCriteria(this)' name="searchText" id="searchText" maxLength='35' size='35' onKeyPress="return blockevent(event)"></td><td  class='label' width="25%"><fmt:message key="Common.criteria.label" bundle="${common_labels}"/>
						<select name="filter" id="filter" >
								<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
						</select>
						</td>
							<td width="25%">&nbsp;</td>
							
						</tr>
						<tr >
							<td width="25%">&nbsp;</td>
							<td width="25%">&nbsp;</td>
							<td width="25%">&nbsp;</td>
							
							<td class="BUTTON"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onclick='displayDetails()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onclick='clearValues()'></td>				
					</tr>
			 </table> 
		<input type='hidden' name='function1' id='function1' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		<input type='hidden' name='label' id='label' value='<%=label%>'>	
	</form>

</body>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>
</html>

