<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/OtherStaffForFacility.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function checkVal(Obj)
{
if(Obj.checked)
Obj.value='Y';
else
Obj.value='N';

}
	
	function call()
	{
		var error=getMessage("WELCOME","common");
		alert(error);
	}
	function focusObj()
	{
		document.forms[0].facility.focus();
	}
	
	function chgFacility()
	{
	parent.frames[1].location.href='../../eCommon/html/blank.html'		
	}
	function chgSpecialty()
	{
	parent.frames[1].location.href='../../eCommon/html/blank.html'
	}
</script>
<%
request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;
	String globaluser="";
	
	String dat="";
	String facility="";

	String en="";
	String id="";


	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	globaluser = (String)p.getProperty("login_user");

	String facilityid=(String)session.getValue("facility_id") ;
	
	
	
	facility=request.getParameter("facility_id")==null ||  request.getParameter("facility_id").equals("") ?facilityid:request.getParameter("facility_id");


	try
	{
	con = ConnectionManager.getConnection(request);

%>
	</head>

	<body  OnMouseDown="CodeArrest()" onSelect='call()' onLoad='focusObj()' onKeyDown = 'lockKey()'>
		<form name='facility_form' id='facility_form' action='../../servlet/eAM.OPPFServlet' method='post' target='messageFrame'>
			<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='80%'>
				<tr>
					<td width='35%'>&nbsp;</td>
					<td width='45%'>&nbsp;</td>
				</tr>
    				<tr>
    				     <td  class='label' width='35%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
    				     <td  align='left' width='45%'>&nbsp;<select name='facility' id='facility' onChange='chgFacility()'>
    				     <option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				       <%
    				    		String sqlfac="Select facility_name,facility_id  from sm_facility_for_user_vw where appl_user_id =? and nvl(access_eff_date_to,TO_DATE('31/12/9999','DD/MM/RRRR')) >= TRUNC(SYSDATE) order by upper(facility_name)";
    				    		pstmt=con.prepareStatement(sqlfac);
								pstmt.setString(1,globaluser);
    				    		rset=pstmt.executeQuery();
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("facility_name");
    				    			id=rset.getString("facility_id");
    				    			if(id.equals(facility))
    				    			  en="selected";

    				    			 else
    				    			    en="";

    				    			out.println("<option value='"+id+ "' "+en +">"+dat);
    				    		   }%>
    				    		</select>&nbsp<img src='../../eMP/images/mandatory.gif' align='center'>
		    				    
    				    		<%}
    				    	  }
    				    	  catch(Exception e){out.print(e);}
    				    	  finally
    				    	  {
    				    	  
    				    	  	if(pstmt!=null)	pstmt.close();
    				    	  	if(rset!=null)	rset.close();
    				    	  	ConnectionManager.returnConnection(con,request);
    				    	  }%>

    				     </td>
    				</tr>
    				<!-- ADDED BY SUJI KEERTHI FOR MOHE-CRF-0013 -->
    				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
    				<tr>
		<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td  colspan=2 class='fields' >&nbsp;
		<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
		<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<option value="01"><fmt:message key="Common.StaffID.label" bundle="${common_labels}"/></option>
		<option value="02"><fmt:message key="Common.StaffName.label" bundle="${common_labels}"/></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=15 maxlength=15></td>
	                </tr>
    				<tr>
    					<td>&nbsp;</td>
					<!--<td>&nbsp;</td>
					<td>&nbsp;</td>-->
					<td>&nbsp;</td>
				</tr>
				<tr>
				<td colspan='4' nowrap align='right'>&nbsp;<input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='callPractitioner()'></td>
				</tr>
				<tr ><td colspan='4'>&nbsp;</td></tr>
  	</table>

	</form>
</body>
</html>

