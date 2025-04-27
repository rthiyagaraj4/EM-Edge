<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>		
		<script language="javascript" src="../../eMR/js/BloodGroup.js"></script>
		</head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   String BloodGroup="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String effstatus_ind="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String checkBoxAttribute_ind="";
   String eventFunctionForCase="";
   String disabledAttrib="";
   boolean NewBloodGroup = false;
   String sql="";
   Connection conn=null;
   try{
	   conn=ConnectionManager.getConnection(request);
%>
<%
	BloodGroup=request.getParameter("blood_grp");
	if(BloodGroup==null){
		BloodGroup="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		effstatus_ind="N";
		disabledAttrib="";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		checkBoxAttribute_ind="";
		NewBloodGroup=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	      //Statement stmt=null;
		   PreparedStatement stmt = null;
	    	ResultSet rset=null;
     try{

		//stmt = conn.createStatement();

		sql = "select blood_grp,long_desc,short_desc,eff_status,indeterminate_yn from mr_blood_grp where blood_grp =?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,BloodGroup);
		rset = stmt.executeQuery();
		rset.next();
		BloodGroup=rset.getString("blood_grp");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");


		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			disabledAttrib="disabled";			
			checkBoxAttribute="";
		}else{

			otherTextAttribute="";
			disabledAttrib="enabled";
			checkBoxAttribute="CHECKED";
		}
		
		effstatus_ind=rset.getString("indeterminate_yn");
		if(effstatus_ind.equals("Y"))
			checkBoxAttribute_ind="CHECKED";
		else
			checkBoxAttribute_ind="";


	     }catch(Exception e){
			e.toString();
	     }
	   finally{
			 try
			 {
	     	if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
			 }
			 catch(Exception e){
	     }

	     }
		codeTextAttribute="READONLY";
		NewBloodGroup=false;
		eventFunctionForCase="";
	}

%>

      	<form name='BloodGroup_form' id='BloodGroup_form' action='../../servlet/eMR.BloodGroupServlet' method='post' target='messageFrame'>
      	<div align='left'><BR><BR><BR><BR><BR>
      	<BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' align='center' width='auto'>
      
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='blood_grp' id='blood_grp' value="<%=BloodGroup%>" size='4' maxlength='4' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      
      		<tr>
      		    <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='40' maxlength='40' value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      	
      		<tr>
      		     <td class='label'><fmt:message key="eMR.Indeterminate.label" bundle="${mr_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='indeterminate_yn' id='indeterminate_yn' value="<%=effstatus_ind%>" <%=checkBoxAttribute_ind%> onClick="change_ind()" <%=disabledAttrib%>></td>
      		</tr>

			<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
      	

      	</table>
      	</div>
    <%  if(NewBloodGroup){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
      	</form>
      	</body>
      	</html>
<%
   }catch(Exception e){/* out.println(e.toString()); */ e.printStackTrace();}
finally{
	
	ConnectionManager.returnConnection(conn,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

