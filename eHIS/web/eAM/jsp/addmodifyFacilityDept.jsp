<!DOCTYPE html>
<%--
	FileName	: addmodifyFacilityDept.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eAM/js/FacilityDept.js' language='javascript'></SCRIPT>
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
		/*var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*'";
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

		return true ;*/
	}

</script>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String dat="";
	String facility="";
	String dept="";
	String en="";
	String ID="";
	String facilityid=(String)session.getValue("facility_id") ;
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 
	String fid=p.getProperty( "login_user" ) ;
	facility=request.getParameter("operating_facility_id");
	dept=request.getParameter("dept_code");
	try
	{
	con = ConnectionManager.getConnection(request);	
	if(facility!=null )
	{
		pstmt=con.prepareStatement("select * from am_facility_dept_vw where operating_facility_id=? and dept_code=?");
		pstmt.setString(1,facility);
		pstmt.setString(2,dept);
		rset=pstmt.executeQuery();
		rset.next();
	}
%>
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement()" >
		<form name='Facility_dept' id='Facility_dept' action='../../servlet/eAM.FacilityDeptServlet' method='post' target='messageFrame'>
			<div>
			<br>
			<br>
			<table border='0' cellpadding='0' width='98%' cellspacing='0' align='center' width='auto'>
			<tr>
				<td width='10%'>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
			</tr>
    				<tr>
    				     <td>&nbsp;</td>
    				     <td  align='left' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
    				     <td  align='left'>
					 <select name='facility' id='facility' onChange='clearResult()' >
							 <option >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				       <%
    				    		if(pstmt!=null)pstmt.close();
					            if(rset!=null)rset.close();
					            stmt=con.createStatement();
    				    		rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+fid+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("Operating_facility_id");
    				    			ID=rset.getString("facility_id");
    				    			if(ID.equals(facilityId))
    				    			  en="selected";
    				    			else
    				    			    en="";
    				    			out.println("<option value=\""+ID+ "\" "+en+">"+dat+"</option>");

    				    		   }%>
    				    		  </select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'>
    				    	<%} %>

    				   </td>
					 <td colspan='1'>&nbsp;</td>
					 </tr>

					 <tr>
						<td colspan='4'>&nbsp;</td>
					</tr>

					<tr>
						<td colspan='1'>&nbsp;</td>
						<td class='label'  id = 'lab1' ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
						<td  colspan=2 class='fields' >
						<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
						<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
						<option value="01"><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></option>
						<option value="02"><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></option>
						</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" onKeyPress='return CheckForSpecChars_local(event)' disabled size=30 maxlength=30></td>
					</tr>
					 
					<tr>
    				   <td colspan='4' nowrap align='right'><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchValues()'></td>
    				</tr>
						
    				<tr>
						<td colspan='4'>&nbsp;</td>
					</tr>
    				</table>

    				<%    	  }
    				    	  catch(Exception e){out.print(e);}
    				    	  finally
    				    	  {
								try
								{
    				    	  	if(stmt!=null)	stmt.close();
    				    	  	if(pstmt!=null)	pstmt.close();
								if(rset!=null)	rset.close();
								}
								catch(Exception e)
								{}
    				    	  	ConnectionManager.returnConnection(con,request);
    				    	  }
					%>


	</form>
</body>
</html>

