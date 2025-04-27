<!DOCTYPE html>
<html>
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOP.*" contentType="text/html;charset=UTF-8" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>		
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOP/js/ClinicProcCategory.js'></script>
		<script language='javascript' src='../../eCommon/js/Colourpalette.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
 </head>


<%

   String facilityid = (String) session.getValue( "facility_id" ) ;	
   String clinic_proc_catg_code=""; // Used to Store Clinic/Procedure Category Code
   String mode=checkForNull(request.getParameter("mode"));
   String longdesc="";
   String shortdesc="";
 
   String effstatus=""; // Used to Store Effective Status either 'E' or 'D'
   String codeTextAttribute=""; // used for visit type code
   String otherTextAttribute=""; // Used for  effective status whether it is (enabled/disabled)  
   String checkBoxAttribute="";
   String eventFunctionForCase="";
 
 
   Connection conn =null;

  try
  {
	conn=ConnectionManager.getConnection(request);
	

	PreparedStatement st=null ;
	ResultSet rset=null;
	
	if(rset != null) rset.close();
	
	boolean newClinicProc=true; // Used whether the newClinicProc type is create mode or modify mode
  

%>
<%

	clinic_proc_catg_code=request.getParameter("CLINIC_PROC_CATG_CODE");
	               
	if((clinic_proc_catg_code==null || clinic_proc_catg_code.equals("")) && !mode.equals("modify")){
		clinic_proc_catg_code="";
		longdesc="";
		shortdesc="";

		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED"; //Used for checkbox is checked or not
		
		
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'"; //whatever case you enter either Lower OR Upper it will convert Uppercase 
		
	}else
		{
    	 
		try{
		String sql = "select long_desc, short_desc, eff_status from OP_CLINIC_PROC_CATEGORY where CLINIC_PROC_CATG_CODE = '"+clinic_proc_catg_code+"'";
		

		 st = conn.prepareStatement(sql);
		rset = st.executeQuery();
		if(rset != null){
			while(rset.next()){
		  longdesc=rset.getString("long_desc");
				shortdesc=rset.getString("short_desc");		
				effstatus=rset.getString("eff_status");
				if(effstatus.equals("D")){
					otherTextAttribute="READONLY";
					checkBoxAttribute="";
				}else{
					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				}
			}
		}
     }catch(Exception e){
		e.printStackTrace();
		 }
     finally 
		{        
		     try{
				if (rset!= null) rset.close();
	           	if (st != null) st.close();
			 }catch(Exception e){}
		}
		codeTextAttribute="READONLY";
		newClinicProc=false;
		eventFunctionForCase="";
	}
%>
     <body OnMouseDown='CodeArrest()' onload='FocusFirstElement();' onKeyDown = 'lockKey();' >
      	<form name='clinic_proc_catg_form' id='clinic_proc_catg_form' action='../../servlet/eOP.ClinicProcCategoryServlet' method='post' target='messageFrame'>
      	<!--<form name='clinic_proc_catg_form' id='clinic_proc_catg_form' action='addClinicProcCategory.jsp' method='post' target='messageFrame'>
	<div id='colorpicker201' class='colorpicker201'></div>-->
      	<BR><BR><BR><BR><BR>
			<div align='left' >
      	<table width='60%' border=0 align='center'>
      	<tr><td  valign='center' width='60%'>
      	<center>
      	<table border='0' cellpadding='2' cellspacing='0' >
      		<tr>
      		    <td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='60%' class='fields' colspan='2'><input type='text' name='clinic_proc_catg_code' id='clinic_proc_catg_code' value="<%=clinic_proc_catg_code%>" size='2' maxlength='2' onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>

     		<tr>
      		    <td  width='30%' class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td width='70%'  class='fields' colspan='2'><input type='text' name='long_desc' id='long_desc' size='40' onBlur = 'makeValidString(this)' maxlength='40' value="<%=longdesc%>" <%=otherTextAttribute%> >
      		    <img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>

     		<tr>
      		    <td  width='30%' class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td width='70%'  class='fields' colspan='2'>
		    <input type='text' name='short_desc' id='short_desc' size='20'  onBlur = 'makeValidString(this)' maxlength='20' value="<%=shortdesc%>" <%=otherTextAttribute%> >
		    <img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>

			<tr>
      		     <td width='30%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td width='70%' colspan='2'  class='fields'> 
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%>  onClick="change()"></td></tr> <!--  added by mujafar for KDAH-CRF-0526 -->
				 
		
      	</table>
      	</td>
      	</table>
      	</div>
    <%  if(newClinicProc){%>

      	<input type='hidden' name='mode' id='mode' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='mode' id='mode' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>

      	</form>
      	</body>

</html>

<%
  }catch(Exception e) {e.printStackTrace();}
finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
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

