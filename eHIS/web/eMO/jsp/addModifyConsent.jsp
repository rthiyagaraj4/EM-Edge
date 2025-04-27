<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../js/MOConsent.js" language="javascript"></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>
 <body OnMouseDown='CodeArrest()' onLoad="FocusFirstElement();change();" onKeyDown = 'lockKey()'>
<%
   request.setCharacterEncoding("UTF-8");
   String servicecode="";
   String title="";
   String shortdesc="";
  
    String effstatus="";
    String codeTextAttribute="";
    String otherTextAttribute="";
    String checkBoxAttribute="";
    String eventFunctionForCase="";
    String enblothrs="";
    boolean newSpeciality=false;
    StringBuffer sql=new StringBuffer();
    servicecode=request.getParameter("servicecode");
   
	if(servicecode==null){
		servicecode="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		checkBoxAttribute="CHECKED";
		
		newSpeciality=true;
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
     try{
		conn = ConnectionManager.getConnection(request);
		sql.setLength(0);
		sql.append("select CONSENT_FORM_CODE,title,DESCRIPTION,eff_status from mo_consent_form where CONSENT_FORM_CODE='"+servicecode+"'");   
		pstmt = conn.prepareStatement(sql.toString());
		rset = pstmt.executeQuery();
		rset.next();
		servicecode=rset.getString("CONSENT_FORM_CODE");
		title=rset.getString("title");
		shortdesc=rset.getString("DESCRIPTION");
		if(shortdesc==null) shortdesc="";
		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D"))
		{
		otherTextAttribute="READONLY";
		enblothrs="READONLY";
		checkBoxAttribute="";
		}else{
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		}	
		sql.setLength(0);
     }catch(Exception e){
		e.toString();
     }
     finally
     {
     	if(pstmt!=null)
     	pstmt.close();
     	if(rset!=null)
     	rset.close();	     	
     	ConnectionManager.returnConnection(conn,request);	
     }
		codeTextAttribute="READONLY";
		newSpeciality=false;
		eventFunctionForCase="";
	}

%>
  <form name="MOConsent_form" id="MOConsent_form"  action='../../servlet/eMO.MOConsentServlet' method='post' target='messageFrame'>
      	<div>
      	
      <br>
      	<table border='0' cellpadding='3' cellspacing='0'  width='100%' align='center'>
      	<tr>
      			
      		    <td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class='fields'><input type='text'  onKeyPress="return CheckForSpecChars(event)" name='service_code' id='service_code'   value="<%=servicecode%>" size='4' maxlength='4' <%=codeTextAttribute%>                 <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
				<td colspan="3"></td>
				<td colspan="1"></td>
		</tr>
        <tr>
      		
      		    <td class='label'><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
      		    <td class='fields'><input type='text' name='long_desc' id='long_desc' size='40' maxlength='40' value="<%=title%>" <%=otherTextAttribute%> <%=enblothrs%> onBlur="makeValidString(this)"  >
      		    <img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
      		    <td colspan="3"></td> 
			    <td colspan="1"></td>
		</tr>
      	<tr>
	     	    <td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		        <td class='fields'><TEXTAREA id=TEXTAREA1 <%=enblothrs%> cols=63 rows=20    name='terms_desc' onblur="SPCheckMaxLen('Description',this,2000)"><%=shortdesc%></TEXTAREA>
		           <img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		        <td colspan="3"></td>
		        <td colspan="1"></td>
	   </tr>	
       <tr>
       		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td  class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
                 <td colspan="3"></td>
				 <td colspan="2"></td>
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

