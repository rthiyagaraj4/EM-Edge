<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
</head>
  <%	
      request.setCharacterEncoding("UTF-8");
	 Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String mode	 					= "";

     String gcs_code_result				= request.getParameter("gcs_code");
		 gcs_code_result				= (gcs_code_result == null)?"":gcs_code_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 String gcs_code					= "";
	 String gcs_desc					= "";
	 String appl_gcs_response_code		= "";
	 String appl_gcs_response_desc		= "";

	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
		mode							= "";
   
    String sql = "select * from ae_gcs_for_response_vw where GCS_CODE = ? ";
 if(!(gcs_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,gcs_code_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		gcs_code					= rset.getString("GCS_CODE");    
			gcs_code 					= (gcs_code == null)?"":gcs_code;
			gcs_desc					= rset.getString("GCS_DESC");
			gcs_desc 					= (gcs_desc == null)?"":gcs_desc;
			appl_gcs_response_code		= rset.getString("APPL_GCS_RESPONSE_CODE");
			appl_gcs_response_code 		= (appl_gcs_response_code == null)?"":appl_gcs_response_code;
			appl_gcs_response_desc		= rset.getString("GCS_RESPONSE_DESC");
			appl_gcs_response_desc 		= (appl_gcs_response_desc == null)?"":appl_gcs_response_desc;
			mode						= "MODIFY";
			readOnlyAttribute1			= "READONLY";
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if gcs_code_result	  
	%>
		

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="gcs_form" id="gcs_form" action="../../servlet/eAE.GCSServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		 <br><br><br><br><br><br><br><br><br><br>
	    <tr>
		   <td colspan='2'>&nbsp;</td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='gcs_code' id='gcs_code' value='<%=gcs_code%>' maxLength='2' size='2' <%=readOnlyAttribute1%> >
   		      </td> 	
	    </tr>	
		<tr>
		   <td colspan='2'>&nbsp;</td>
		</tr>
		
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='gcs_desc' id='gcs_desc' value="<%=gcs_desc%>" maxLength='40' size='40' <%=readOnlyAttribute%> onBlur="makeValidString(this)">
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'>&nbsp;</td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='appl_gcs_response_code' id='appl_gcs_response_code' value="<%=appl_gcs_response_desc%>" maxLength='30' size='30' <%=readOnlyAttribute1%> >
			  </td>
        </tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
	 </form>
		  <%
                if(!mode.equals("INSERT"))
				 out.println("<script>document.forms[0].gcs_desc.focus();</script>");
		 %>
    </body>

<%

} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

