<!DOCTYPE html>
<!--
   
   Developed By : Venkatesh.S
   Date         : 28-Nov-2013    
   Against      : Bru-HIMS-CRF-348 [IN038247] 
 
 -->

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
<%
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
%>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eMO/js/MORegisterAttn.js'> </script>
  	<script src='../../eMO/js/MOEmbalmRegistration.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
 
   <%
          String patient_length		=   "";
	      Connection con			=	null;
	      Statement	st				=	null;
	      PreparedStatement pstmt	=   null;
	      ResultSet	rs				=	null;
   
     try{
	        con					    =	(Connection)ConnectionManager.getConnection(request);
		    st					    = 	con.createStatement();
			rs						=	st.executeQuery("select patient_id_length from mp_param");
			String	facility_id		=  (String) session.getValue( "facility_id" ) ;
			String mode             =   request.getParameter("mode")==null?"":request.getParameter("mode");
			String patient_id       =   request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String srl_no           =   request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
			String applicant_id     =   request.getParameter("app_id")==null?"":request.getParameter("app_id");
			 
				
		
			if(rs.next())
			{
			patient_length		    = rs.getString(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
	    
	    
    %>
   
    <BODY OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
  <form name='embalm_criteria_form' id='embalm_criteria_form' target='messageFrame' >
    <br>
     <table border='0' cellpadding='2' cellspacing='0' width='100%'>
     <tr>
		<td class=label ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><!--bundle change for PAS-MO-PMG2020-TECH-CRF-0010/02-Label Name-->
		 <td class='field' ><input type='text'  name='patient_id' id='patient_id'  value='<%=patient_id%>' maxLength="<%=patient_length%>"   size='<%=patient_length%>' onBlur='ChangeCase(this);if(this.value!=""){submitPage(this.value);}' onKeyPress="return CheckForSpecChars(event);" ><input type="button" name="patient_search" id="patient_search" class=BUTTON  value="?" onClick="callpatientsearch(this,'<%=facility_id%>',patient_id)" ><img name='mandatory' src='../../eCommon/images/mandatory.gif'></td>
        <td width='25%'>&nbsp;</td>
        <td width='25%'>&nbsp;</td>
  
		 <td class='button' colspan=4>
		 <input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='submitPage(patient_id.value);'>
		 <input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearData()'>
		 </td> 
	</tr>
	<input type='hidden' name = 'srl_no' value = <%=srl_no%>>
	<input type='hidden' name = 'app_id' value = <%=applicant_id%>>
	<input type='hidden' name = 'mode' value = <%=mode%>>
   </table>
   <%}catch(Exception e)
	    {
	     e.printStackTrace();
	    }finally 
		{
		ConnectionManager.returnConnection(con,request);
		}
		
		%>
		<script>
		if(document.forms[0].srl_no.value!="" && document.forms[0].patient_id.value!=""){
				 document.forms[0].search.click();
				 document.forms[0].patient_id.disabled=true;
				  document.forms[0].patient_search.disabled=true;
				 document.forms[0].search.disabled=true;
				 document.forms[0].clear.disabled=true;
		}

		 
		 </script>
  </form>  
 </BODY>
</HTML>
 

