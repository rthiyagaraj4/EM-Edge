<!DOCTYPE html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/RelationshipLevel.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script>
		function allowNumOnly(event)
		{
			var strCheck = '0123456789';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1)
				return false;  
			else
				return true ;			
		}		
	</script>


</head>
<form name='facility_form' id='facility_form' method='post' target='messageFrame'>
<%
		request.setCharacterEncoding("UTF-8");
		//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		//String params = request.getQueryString() ;
		//String source = url + params ;
		

		Connection con = null;
		Statement stmt=null;
		ResultSet rset=null ;

		//String facility_id = (String)session.getValue( "facility_id" );	
		
		String relationship_level="";

		String relationship_level_code = "";
	    String relationship_level_desc = "";
	    String linked_relnship_level_code = "";
        String linked_relnship_level_desc = "";
        String mode = "";
        String disable_code="";
        String linked_relationship_desc="";
	    String srno="";	 

		String relationship_code = (request.getParameter("relationship_code")==null)?"":request.getParameter("relationship_code");

		String linked_relationship_code = (request.getParameter("linked_relationship_code")==null)?"": request.getParameter("linked_relationship_code");		   
	
		srno=(request.getParameter("srno")==null)?"":request.getParameter("srno");
		linked_relationship_desc=(request.getParameter("linked_relationship_desc")==null)?"":request.getParameter("linked_relationship_desc");
		relationship_level_code=(request.getParameter("relationship_level_code")==null)?"":request.getParameter("relationship_level_code");
		mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
		relationship_level_desc=(request.getParameter("relationship_level_desc")==null)?"":request.getParameter("relationship_level_desc");

		linked_relnship_level_code=(request.getParameter("linked_relnship_level_code")==null)?"": request.getParameter("linked_relnship_level_code");

		linked_relnship_level_desc=(request.getParameter("linked_relnship_level_desc")==null)?"": request.getParameter("linked_relnship_level_desc");			
		
		try
		{
	
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			
			int cnt = 0;		
		 
			rset = stmt.executeQuery("select RELATIONSHIP_LEVEL from MP_RELATIONSHIP where relationship_code='"+relationship_code+"'");
			if(rset!= null && rset.next())
			{
				relationship_level = rset.getString("RELATIONSHIP_LEVEL");
				if(relationship_level ==null) relationship_level="";		
			}			

			if(rset!=null)
				rset.close();
			
			rset = stmt.executeQuery("select count(*) cnt from MP_RELATIONSHIP_LEVEL where relationship_level_code='"+relationship_level_code+"'");

			if(rset!= null && rset.next())
			{
				cnt = rset.getInt("cnt");	
			}
			
			if(stmt!=null)
				stmt.close();
			if(rset!=null)
				rset.close();			

			if(cnt>0)
				disable_code = "disabled";
			else
				disable_code = "";	
			
		if(!relationship_level.equals("0"))	{
		
		%>
	
		<table border='0' cellpadding='1' cellspacing='0' width='99%' align='center'>
		
			<tr>
				<td colspan='2' width='100%' class='label'>&nbsp;</td>
			</tr>
			<tr>
				  <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
                  <td width="60%" class='fields'>				  
					  <INPUT TYPE="text" name="relationship_level_code" id="relationship_level_code" <%=disable_code%> value="<%=relationship_level_code%>" maxlength = "4" size='6' onKeyPress='return allowNumOnly(event);'>	<img align='center' src='../../eCommon/images/mandatory.gif'></img>				  
				  </td>
			</tr>
			<tr>
					<td width="40%" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
                    <td width="60%" class='fields'>			  
					  <INPUT TYPE="text" name="relationship_level_desc" id="relationship_level_desc" value="<%=relationship_level_desc%>" maxlength="30" size='30'>	<img align='center' src='../../eCommon/images/mandatory.gif'></img>				  
			 </td>	
			</tr>
			

		<% if(relationship_level.equals("2")){
		%>
			<tr>                 
				  <td width="40%" class="label"><fmt:message key="eMP.LinkedRelnshpLevel.label" bundle="${mp_labels}"/></td>
                  <td width="60%" class='fields'><INPUT TYPE="text" name="linked_relnship_level_desc" id="linked_relnship_level_desc" <%=disable_code%> value="<%=linked_relnship_level_desc%>" size = '20'  onblur='if(this.value!=""){getRelation(linked_relnship_level_code,linked_relnship_level_desc);}'><input type='button' name='linked_relationship_level_btn' id='linked_relationship_level_btn' value='?' class='button' <%=disable_code%> onClick='getRelation(linked_relnship_level_code,linked_relnship_level_desc);'><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				  <input type='hidden' name='linked_relnship_level_code' id='linked_relnship_level_code' value="<%=linked_relnship_level_code%>"
				  </td>					  
		    </tr>

			<script>
				
				parent.frames[1].document.getElementById('relnlabel').innerHTML="<fmt:message key='eMP.LinkedRelnshp.label' bundle='${common_labels}'/>";
				parent.frames[1].document.getElementById('relntext').innerHTML="<INPUT TYPE='text' name='linked_relationship_desc' id='linked_relationship_desc' value='<%=linked_relationship_desc%>' onblur='onblurgetRelation(linked_relationship_code,linked_relationship_desc);'><input type='button' name='linked_reln_btn' id='linked_reln_btn' value='?' class='button' onClick='getRelation(linked_relationship_code,linked_relationship_desc);'><img align='center' src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='linked_relationship_code' id='linked_relationship_code' value='<%=linked_relationship_code%>'>";	
				
			</script>
			
		<% 
		} else if(relationship_level.equals("1")) {
				
		%>

		<script>				
				parent.frames[1].document.getElementById('relnlabel').innerHTML="&nbsp;";
				parent.frames[1].document.getElementById('relntext').innerHTML="&nbsp;";				
		</script>

		<% } %>	
						  
<tr >
	<td class='label' width='40%'></td>
	<td class='fields' width="60%">

	<%if(!(mode.equals("modify")))
	{
	%>
		<input type='button' name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class='button' onClick='addPanel()'><input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearFields()'>
	<%}else
	  {
	%>
		<input type='button' name='cancel' id='cancel' value='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>' class='button' onClick='modify()'><input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearFields()'>
	<%}%>
	</td>
</tr>
<tr>
	<td colspan='2' width='100%' class='label'>&nbsp;</td>
</tr>
</table>
  <%
  }

  %>
<input type='hidden' name='relationship_code' id='relationship_code' value='<%=relationship_code%>'>
<input type='hidden' name='relationship_level' id='relationship_level' value='<%=relationship_level%>'>
<input type='hidden' name='srno' id='srno' value='<%=srno%>'>
</form>
</body>
<%
	  if(mode.equals("update"))
	  {
		if(relationship_level.equals("1"))
		{
			%>
			<script>loadResultPage();</script>
			<%
		}
	  }		
%>
<%

	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
finally { 
	ConnectionManager.returnConnection(con,request);
}
	%> 

