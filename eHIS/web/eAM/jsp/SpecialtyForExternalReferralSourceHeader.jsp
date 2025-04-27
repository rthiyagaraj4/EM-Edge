<!DOCTYPE html>
<%--
	FileName	: SpecialtyForExternalReferralSourceHeader.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 



<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eAM/js/SpecialtyForExternalReferralSource.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function clearResult()
	{
		parent.frames[1].location.href='../../eCommon/html/blank.html'
	}

	function enable_txt(obj)
		{
			if(obj.value!='00')
					
			  document.forms[0].search_txt.disabled=false;
					
			else
			{
			  document.forms[0].search_txt.disabled=true;
			   document.forms[0].search_txt.value="";
			}
		}

		function CheckForSpecChars_local(event)
		{
			var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*'";
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

			return true ;
		}
	

</script>
<%
request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String sql_query="";
	String dat="";
	String en="";
	String ID="";
	String facilityid=(String)session.getValue("facility_id") ;
	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 


	try
	{
		con = ConnectionManager.getConnection(request);
	
%>
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement(); " >
		<form name='Facility_dept' id='Facility_dept' action='' method='post' target='messageFrame' >
			<div>
			<br>
			<br>
			<table border='0' cellpadding='0' width='90%' cellspacing='0' align='center' width='auto'>
			<tr>
				<td width='10%'>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
			</tr>
    				<tr>
    				     <td>&nbsp;</td>
    				     <td  class='label'><fmt:message key="eAM.ExternalReferralSource.label" bundle="${am_labels}"/></td>
    				     <td  align='left'>
					 <select name='facility' id='facility' onChange='assignVal5(this.value)' >
							 <option value="" >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				       <%
    				stmt = con.createStatement();
					sql_query ="SELECT referral_code,long_desc FROM AM_REFERRAL WHERE eff_status='E' order by long_desc";

					rset=stmt.executeQuery(sql_query);
   				    			if(rset!=null){
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("long_desc");
    				    			ID=rset.getString("referral_code");
    				    	
    				    			out.println("<option value=\""+ID+ "\" "+en+">"+dat+"</option>");

    				    		   }%>
    				    		  </select>&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'>
    				    	<%} %>

    				   </td>
					   <td colspan='1'>&nbsp;</td>
    				   <!-- <td><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchValues()'></td> -->
    				</tr>
    				<tr><td colspan='4'>&nbsp;</td></tr>

					<tr>

					<td colspan='1'>&nbsp;</td>
				
					<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td  colspan=2 class='fields' >
					
					<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
					<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<option value="01"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></option>
					<option value="02"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></option>
					</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=30 maxlength=30></td>

<!--Removed for ICN-7143
onKeyPress='return CheckForSpecChars_local(event)'-->
					
					</tr>

					<tr>

					<td colspan='4' align='right'><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchValues()'></td>

					</tr>

    				</table>

    				<%		
									if(rset!=null)	rset.close();
								if(stmt!=null)	stmt.close();
    				    	  	if(pstmt!=null)	pstmt.close();
    				    	  
					
					
					}
    				    	  catch(Exception e){out.print(e);}
    				    	  finally
    				    	  {
    				    	  	
    				    	  	ConnectionManager.returnConnection(con,request);
    				    	  }%>


	</form>
</body>
</html>

