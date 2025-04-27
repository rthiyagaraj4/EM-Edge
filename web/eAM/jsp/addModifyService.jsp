<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>

      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eAM/js/Service.js' language='javascript'></script>
		<script>
		
      	function Change1(){
      	 if (service_form.eff_status.checked == true)
	      	 	service_form.eff_status.value	=	"E";
	      	 else
      		    service_form.eff_status.value	=	"D";     	      	
      	}      	
      	
		function change() {
      	if (service_form.medical_yn1.checked == true)
      	 	{
			   service_form.medical_yn.value		=	"Y";
      	 	   service_form.ancillary_yn1.disabled	=false;
      	 	}      	 	      	 	
      	 else
      		{
      		   service_form.ancillary_yn1.checked	=	false;
      		   service_form.medical_yn.value		=	"N";
      		   service_form.ancillary_yn1.disabled	=true;      		
      		}      		
      	      		
      	if(service_form.ancillary_yn1.checked == true)
		{
      	 	service_form.ancillary_yn.value	=	"Y";
			if(service_form.medical_yn1.checked == true && !service_form.medical_yn1.disabled )
				service_form.ancillary_yn1.disabled =	false;
			else
				service_form.ancillary_yn1.disabled =	true;
		}else
      		    service_form.ancillary_yn.value		=	"N";	
      	}
      	</script>
      	

      </head>

      <body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement();change();" onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   String servicecode="",longdesc="",shortdesc="",effstatus="",medical_yn="",ancillary_yn="",codeTextAttribute="",otherTextAttribute="",otherAttribute="",otherAttribute1="",checkBoxAttribute="",eventFunctionForCase="",CheckValue="",CheckValue1="",sql="";
   boolean newSpeciality		=	false;
  
%>
<%
	servicecode=request.getParameter("service_code");
	if(servicecode==null){
		servicecode				=	"";
		longdesc				=	"";
		shortdesc				=	"";
		effstatus				=	"E";
		medical_yn				=	"N";
		ancillary_yn			=	"N";
		codeTextAttribute		=	"";
		otherTextAttribute		=	"";
		checkBoxAttribute		=	"CHECKED";
		newSpeciality			=	true;
		eventFunctionForCase	=	"OnBlur='ChangeUpperCase(this)'";
	}else{
		Connection conn			=	null;
	    java.sql.Statement stmt	=	null;
		PreparedStatement pstmt = null;
	    ResultSet rset			=	null;
     try{
		conn = ConnectionManager.getConnection(request);

		//stmt = conn.createStatement();
		sql =  "select medical_yn,ancillary_yn,service_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from am_service where service_code=?"; 
		
		//rset = stmt.executeQuery(sql);
		
		
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	servicecode		);

		rset		 = pstmt.executeQuery();
		rset.next();
		servicecode				=	rset.getString("service_code");
		longdesc				=	rset.getString("long_desc");
		shortdesc				=	rset.getString("short_desc");
		medical_yn				=	rset.getString("medical_yn");
		ancillary_yn			=	rset.getString("ancillary_yn");
		effstatus				=rset.getString("eff_status");
		if(effstatus.equals("D"))
		{
			otherTextAttribute	=	"READONLY";
			checkBoxAttribute	=	"";

			if (medical_yn.equals("Y"))
			   {
			       CheckValue		=	"CHECKED";
			       otherAttribute	=	"DISABLED";
			   }
			else
			   {
			      CheckValue		=	"";
			      otherAttribute	=	"DISABLED";
			   }
			    
			if (ancillary_yn.equals("Y"))
			   {
			      CheckValue1		=	"CHECKED";
			      otherAttribute1	=	"DISABLED";
			   }
			else
			   {
			     CheckValue1		=	"";
			     otherAttribute1	=	"DISABLED";
			   }		    
					
		}else{

			otherTextAttribute		=	"";
			checkBoxAttribute		=	"CHECKED";
			otherAttribute			=	"";
			
		if (medical_yn.equals("Y"))
			{
			     CheckValue			=	"CHECKED";
			     otherAttribute		=	"";
			}
		else
			{
			    CheckValue			=	"";
			    otherAttribute		=	"";
		    }
			
	   if (ancillary_yn.equals("Y"))
		  {
		     CheckValue1			=	"CHECKED";
		     otherAttribute1		=	"";
		  }
	   else
		  {
			 CheckValue1			=	"";
			 otherAttribute1		=	"";
		  }
	
		}
	 }catch(Exception e){
			e.toString();
	 }
	 finally
	 {     
		    if(rset!=null)    	rset.close();	 
	     	if(stmt!=null)    	stmt.close();
	     	if(pstmt!=null)    	pstmt.close();
	     	ConnectionManager.returnConnection(conn,request);	
	 }
		codeTextAttribute	=	"READONLY";
		newSpeciality		=	false;
		eventFunctionForCase=	"";
	}
%>

      	<form name='service_form' id='service_form' action='../../servlet/eAM.ServiceServlet' method='post' target='messageFrame'>
      	<div>
      	<br><br><br><br><br><br><br>
      	
      	<table border='0' cellpadding='0' cellspacing='0' width='auto' align="center">
      		<tr>
      			<td width='10%' class="label">&nbsp;</td> 
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td width='10%' class="label">&nbsp;</td>
			</tr>
      		<tr>
      		    <td class="label">&nbsp;</td>
      		    <td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class="fields">
      		    <input type='text'  onKeyPress="return CheckForSpecChars(event)" name='service_code' id='service_code' value="<%=servicecode%>" size='4' maxlength='4' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
      		    <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
				<td class="label">&nbsp;</td>
		    </tr>
      		<tr>
      		    <td class="label">&nbsp;</td>
      		    <td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class="fields">
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"  >
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
      		    <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      		     <td class="label">&nbsp;</td>  
      		     <td class="label">&nbsp;</td>
			     <td class="label">&nbsp;</td>
			     <td class="label">&nbsp;</td>
		    </tr>
      		<tr>
      		    <td class="label">&nbsp;</td> 
      		    <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		        <td class="fields">
		        <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)" >
		        <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		        <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      			<td class="label">&nbsp;</td>
      			<td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
		</tr>
      		<tr>
      		     <td class="label">&nbsp;</td>	 
      		     <td class="label"><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></td>
      		     <td class="fields" >
      		     <input type='checkbox' name='medical_yn1' id='medical_yn1' value="<%=medical_yn%>"  <%=otherAttribute%> <%=CheckValue%> onClick="change()"></td>
    		     <input type='hidden' name='medical_yn' id='medical_yn' value="<%=medical_yn%>" ></td> 
          	     <td class="label">&nbsp;</td> 	     
      		</tr> 
      		<tr class="label">
      			<td class="label">&nbsp;</td>
      			<td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
		    </tr>
      		<tr>
      		    <td class="label">&nbsp;</td>
		        <td class="label"><fmt:message key="eAM.AncillaryMedicalService.label" bundle="${am_labels}"/></td>
		        <td class="fields" >
		        <input type='checkbox' name='ancillary_yn1' id='ancillary_yn1' disabled value="<%=ancillary_yn%>"  <%=otherAttribute1%> <%=CheckValue1%> onClick="change()"></td>
      		    <input type='hidden' name='ancillary_yn' id='ancillary_yn' value="<%=ancillary_yn%>" ></td> 
      		    <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      			<td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
		    </tr>
      		<tr>
      		     <td class="label">&nbsp;</td>	 
      		     <td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class="fields">
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="Change1()"></td>
      		     <td class="label">&nbsp;</td>
      		</tr>
      		<tr class="label">
      			<td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
			    <td class="label">&nbsp;</td>
		    </tr>
      	</table>
      	</div>
    <%  if(newSpeciality){%>
      		<input type='hidden' name='function' id='function' value='insert'>
      		<input type='hidden' name='function_name' id='function_name' value='insert'>
      <%}else{%>
      		<input type='hidden' name='function' id='function' value='modify'>
      		<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
      		<input type='hidden' name='eff_date_from' id='eff_date_from' >
      		<input type='hidden' name='eff_date_to' id='eff_date_to' >
      	</form>
      	</body>
      	</html>

