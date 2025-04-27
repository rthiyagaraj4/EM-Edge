<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" %>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/OPSPractitioner.js' language='javascript'></script>
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
	function callPractitioner()
	{
	if(chkPractitionerList())
	{
		var splty_code=document.forms[0].splty_code.value;
		var facility_id= document.forms[0].facility_id.value;
		if(parent.frames[1].document.forms[0])
			parent.frames[1].document.forms[0].submit();
	    var search_by=document.forms[0].search_by.value;
		var search_txt=document.forms[0].search_txt.value;

		refreshFinalValues();
	 	parent.frames[1].location.href="../../eAM/jsp/md_addModifyOPSPractitionerResult.jsp?splty_code="+splty_code+"&facility_id="+facility_id+"&search_txt="+search_txt+"&search_by="+search_by;
		
	}
	}
	function focusObj()
	{
			document.forms[0].facility_id.focus();
	}
	
	function dispBlank()
	{
	document.forms[0].splty_code.value=''
	parent.frames[1].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}
	function dispBlankResult()
	{
	parent.frames[1].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}
	
</script>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
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
	String en="";
	String id="";
	String globaluser="";
	
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	globaluser = (String)p.getProperty("login_user");
	
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
			
			<table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
				<tr>
					<td colspan='1' width="15%"></td>
					<td colspan='1' width="40%"></td>
					<td colspan='1' width="10%"></td>
					<td colspan='1' width="20%"></td>
				</tr>
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>

				<tr>
				     <td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				     <td class='fields'><select name='facility_id' id='facility_id' onChange='dispBlank()'>
					<option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>

					<%
		             if(rset!=null)rset.close();
					 if(pstmt!=null)pstmt.close();
       
					 pstmt=con.prepareStatement("Select facility_name,facility_id  from sm_facility_for_user_vw where appl_user_id ='"+ globaluser+"' and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)");
						rset=pstmt.executeQuery();
						if(rset!=null)
						{
						   while(rset.next())
						   {
						   dat=rset.getString("Facility_Name");
						   id=rset.getString("Facility_Id");
						   if(id.equals(facilityId))
							en="selected";
						    else
							en="";

						 out.println("<option value='"+id+ "' "+en+">"+dat);

						   }
						}
						out.print("</select>");
					%>
					 <img src='../../eMP/images/mandatory.gif'>
				     </td>
   				     <td  class='label' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    				     <td class='fields' nowrap><select name='splty_code' id='splty_code' onChange='dispBlankResult()'>
    				   	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

    				    	<%
    				    		if(rset!=null)rset.close();
							    if(pstmt!=null)pstmt.close();
							     
							    stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select short_desc,speciality_code from am_speciality where eff_status='E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by (short_desc)");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString("short_desc");
    				    		   id=rset.getString("speciality_code");
    				    		   if(id.equals(pract))
    				    		   	en="selected";
    				    		    else
    				    			en="";

    				    		 out.println("<option value='"+id+ "' "+en+">"+dat);

    				    		   }
    				    		}
    				    	 	out.print("</select>");
					%>
    				    	 <img src='../../eMP/images/mandatory.gif'>
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
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" disabled size=15 maxlength=15></td>
	</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
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
		<%	 }
			  catch(Exception e){
				  //out.print(e);
				  e.printStackTrace();
				  }
			  finally
			  {
				try
				{
				  if(stmt!=null)	stmt.close();
				  if(pstmt!=null)	pstmt.close();
				  if(rset!=null)	rset.close();
				}
				catch(Exception e)
				  {
					e.printStackTrace();
				}
				ConnectionManager.returnConnection(con,request);

			  }%>

