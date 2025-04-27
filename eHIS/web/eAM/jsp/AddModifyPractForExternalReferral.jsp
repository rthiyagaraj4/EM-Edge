<!DOCTYPE html>
<%--
	FileName	: AddModifyPractForExternalReferral.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/PractForExternalReferral.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

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

	String fid=(String)session.getValue("facility_id") ;
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null || facilityId.equals("")) facilityId=fid;
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String dat="";
	String facility="";
	String pract="";

	String id="";

	
	facility=request.getParameter("practitioner_id");
	pract=request.getParameter("speciality_id");
	try
	{
		con = ConnectionManager.getConnection(request);

	if(facility!=null )
	{
		pstmt=con.prepareStatement("select am_practitioner.practitioner_name,am_pract_specialities.practitioner_id,am_pract_specialities.speciality_code,am_speciality.short_desc from am_practitioner,am_pract_for_facility, am_pract_specialities,am_speciality where am_pract_specialities.practitioner_id=am_pract_for_facility.practitioner_id and am_practitioner.practitioner_id=am_pract_for_facility.practitioner_id and am_speciality.speciality_code=am_pract_specialities.speciality_code and am_pract_specialities.facility_id=am_pract_for_facility.facility_id and am_pract_specialities.speciality_code=? and am_pract_specialities.practitioner_id=?");

		pstmt.setString(1,pract);
		pstmt.setString(2,facility);
		rset=pstmt.executeQuery();
		if(rset.next())
		{
		pract=rset.getString("Practitioner_id");
	

		}
 	}

%>

	</head>

	<body onLoad='focusObj()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='facility_form_query' id='facility_form_query'>
			<br><br>
			<table border='0' cellpadding='0' cellspacing='0' width='98%' align='center'>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
				     <td  class='label'><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></td>
				     <td class='fields'><select name='referral_code' id='referral_code' onChange='generateSpeciality(this);dispBlank()'>
					<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>

					<%
		             if(rset!=null)rset.close();
					 if(pstmt!=null)pstmt.close();
       
					 pstmt=con.prepareStatement("select referral_code, long_desc from am_referral order by 2");

						rset=pstmt.executeQuery();
						if(rset!=null)
						{
						   while(rset.next())
						   {
						   dat = rset.getString("long_desc");
						    id = rset.getString("referral_code");


						 out.println("<option value='"+id+"'>"+dat);

						   }
						}
						out.print("</select>");
					%>
					 <img src='../../eCommon/images/mandatory.gif'>
				     </td>
   				     <td  class='label' nowrap><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/> </td>
    				     <td class='fields' nowrap><select name='splty_code' id='splty_code' onChange='dispBlankResult()'>
    				   	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
							 </select>
    		
    				    	 <img src='../../eCommon/images/mandatory.gif'>
    				     </td>
    				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>

				<tr>
				<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
				<td  colspan=3 class='fields' >
				<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
				<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<option value="01"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
				<option value="02"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></option>
				</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" onKeyPress='return CheckForSpecChars_local(event)' disabled size=30 maxlength=30></td>
				</tr>

    				<tr>
    					<td colspan='4' nowrap align='right'>&nbsp;<input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='callPractitioner()'></td>
   				</tr>
			
  			</table>
		</div>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
	</form>
</body>
</html>
		<%

				if(rset!=null)	rset.close();
				 if(stmt!=null)	stmt.close();
				  if(pstmt!=null)	pstmt.close();
			  
				
			
			}
			  catch(Exception e){e.printStackTrace();}
			  finally
			  {
			 
				ConnectionManager.returnConnection(con,request);

			  }%>

