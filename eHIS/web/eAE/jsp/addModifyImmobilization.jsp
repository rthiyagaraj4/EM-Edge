<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/Immobilization.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <%
  	 request.setCharacterEncoding("UTF-8");
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String mode						= ""; 

     String immobli_code_result	= request.getParameter("immobilization_code");
		 immobli_code_result		= (immobli_code_result == null)?"":immobli_code_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 String immobilization_code			= "";
	 String long_desc					= "";
	 String short_desc					= "";
	 String eff_status					= "";

	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
		mode							= "INSERT";
   
    String sql = "select * from AE_IMMOBILIZATION  where IMMOBILIZATION_CODE= ? ";
 if(!(immobli_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,immobli_code_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		immobilization_code			= rset.getString("IMMOBILIZATION_CODE");    
			immobilization_code 			= (immobilization_code == null)?"":immobilization_code;
			long_desc					= rset.getString("LONG_DESC");
			long_desc 					= (long_desc == null)?"":long_desc;
			short_desc					= rset.getString("short_desc");
			short_desc 					= (short_desc == null)?"":short_desc;
			eff_status					= rset.getString("EFF_STATUS");
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
					readOnlyAttribute	 = "READONLY";
	   	    }
			mode						 = "MODIFY";
			readOnlyAttribute1			 = "READONLY";
	  }
	  

	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if rta_code_result	  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="immobil_form" id="immobil_form" action="../../servlet/eAE.ImmobilizationServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='immobilization_code' id='immobilization_code' value='<%=immobilization_code%>' maxLength='6' size='6' <%=readOnlyAttribute1%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
	    </tr>	
		<tr>
		   <td colspan='2'></td>
		</tr>
		
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='long_desc' id='long_desc' value="<%=long_desc%>" maxLength='30' size='30' <%=readOnlyAttribute%> onBlur="makeValidString(this)">
			  <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='short_desc' id='short_desc' value="<%=short_desc%>" maxLength='15' size='15' <%=readOnlyAttribute%> onBlur="makeValidString(this)">
 		      <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>' <%=checkBoxAttribute%>  onClick='chkValue(this);'>
              </td>
        </tr>
		<tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
	 </form>
		  <%
                if(mode.equals("INSERT"))
					out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].immobilization_code.focus();</script>");
				 else
					out.println("<script>document.forms[0].long_desc.focus();</script>");
		 %>
    </body>

<% } catch(Exception e){e.printStackTrace();}
   finally
    {
    	
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

