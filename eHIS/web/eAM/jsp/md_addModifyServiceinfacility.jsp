<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eAM/js/GenderGroup.js'  language='javascript'></script>
	<script src='../../eAM/js/Serviceinfacility.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function displayQuery()
		{
			var facility_id=serviceinfacilityQuery_form.operating_facility_id.value;
			var dept_code=serviceinfacilityQuery_form.dept_code.value;
			
			if(chkMandatory())
			{				
				parent.frames[0].temp='';
				var search_by=document.forms[0].search_by.value;
				var search_txt=document.forms[0].search_txt.value;
				if(search_txt.indexOf("'")!=-1)
		        {			
			      search_txt = search_txt.replace("'","''");
		        }
			parent.frames[1].location.href='../../eAM/jsp/md_addModifyServiceinfacilityResult.jsp?facility_id='+facility_id+'&dept_code='+dept_code+'&search_by='+search_by+'&search_txt='+encodeURIComponent(search_txt);	

			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';

			}
		}
		
		function populateBlank()
		{
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		}
		
		function focusOnfirstObj(Obj)
		{
			serviceinfacilityQuery_form.operating_facility_id.focus();


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
			/*var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_' '*'";
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

			return true ;*/
		}

	</script>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
		String facilityid=(String)session.getValue("facility_id") ;
		String facilityId= request.getParameter("facilityId");
			if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 
	
		String globaluser="";

		Statement stmt = null;
		ResultSet rset=null;
		ResultSet rset1=null;
		Connection conn = null;
		Properties p=(Properties)session.getValue("jdbc");
		globaluser = (String)p.getProperty("login_user");
		try
		{
	    conn = ConnectionManager.getConnection(request);
	    stmt = conn.createStatement();

		%>
</head>
<body onLoad='focusOnfirstObj()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> 
	<form name='serviceinfacilityQuery_form' id='serviceinfacilityQuery_form'>
	<br><br>
		<table border='0' cellpadding='0' cellspacing='0' align='center' width='75%'>
		<tr>
			  <td colspan='4'>&nbsp;</td>
		</tr>
		<tr>
			  <td   class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			  <td  class='fields'><select name="operating_facility_id" id="operating_facility_id"  onChange='PopulateList()'>
			  <OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- 
		<%
			   rset1 = stmt.executeQuery( "Select facility_name,facility_id operating_facility_id from sm_facility_for_user_vw where appl_user_id ='"+ globaluser+"' and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)");
				if( rset1 != null )
				{
					 while( rset1.next() )
					 {
						 String faccode1 = rset1.getString( "operating_facility_id" ) ;
						 String facdesc1 = rset1.getString( "facility_name" ) ;

						if ( faccode1.equals( facilityId ) )
							 out.println( "<option value='" + faccode1 + "' SELECTED > "+ facdesc1);
						else
							 out.println( "<option value='" + faccode1 + "' >" + facdesc1 ) ;
					 }
				}
	%>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				  <td   class="label"><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
				  <td class='fields'><select name="dept_code" id="dept_code" onChange='populateBlank()' >
				  <OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- 
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td colspan='4'>&nbsp;</td>
		</tr>

		<tr>
				
				<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
				<td  colspan=2 class='fields' >
				
				<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
				<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<option value="01"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></option>
				<option value="02"><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></option>
				</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" onKeyPress='return CheckForSpecChars_local(event)' disabled size=30 maxlength=30></td>

				<td colspan='1'>&nbsp;</td>
		</tr>

		<tr>
			<td   colspan='4' align='right'><input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='displayQuery()'></td>
		</tr>
		<tr>
			<td colspan='4'>&nbsp;</td>
		</tr>
		  <script>PopulateList()</script>
			<% 
			} 
			catch(Exception e)
			{
				//out.println(e);
				e.printStackTrace();
			}
			finally
			{
				try
				{
				if(stmt!=null) stmt.close();
				if(rset!=null) rset.close(); 
				if(rset1!=null) rset1.close(); 
				}
				catch(Exception r)
				{}

				ConnectionManager.returnConnection(conn,request);
		}
	%>
	 </table>
</form>
</body>
</html>

