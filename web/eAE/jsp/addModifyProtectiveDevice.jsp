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
  <script language='javascript' src='../../eAE/js/ProtectiveDevice.js'></script>
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

     String protective_device_code_result= request.getParameter("protective_device_code");
		 protective_device_code_result	= (protective_device_code_result == null)?"":protective_device_code_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 String protective_device_code		= "";
	 String long_desc					= "";
	 String short_desc					= "";
	 String eff_status					= "";

	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
		mode							= "INSERT";
   
    String sql = "select * from AE_PROTECTIVE_DEVICE where PROTECTIVE_DEVICE_CODE= ? ";
 if(!(protective_device_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,protective_device_code_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		protective_device_code		= rset.getString("PROTECTIVE_DEVICE_CODE");    
			protective_device_code 		= (protective_device_code == null)?"":protective_device_code;
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
  } // end of if protective_device_code_result	  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="protective_device_form" id="protective_device_form" action="../../servlet/eAE.ProtectiveDeviceServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='protective_device_code' id='protective_device_code' value='<%=protective_device_code%>' maxLength='4' size='4' <%=readOnlyAttribute1%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
	    </tr>	
		<tr>
		   <td colspan='2'></td>
		</tr>
		
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='long_desc' id='long_desc' value="<%=long_desc%>" maxLength='30' size='30' <%=readOnlyAttribute%> onBlur="makeValidString(this)" >
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
						out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].protective_device_code.focus();</script>");
				else
					out.println("<script>document.forms[0].long_desc.focus();</script>");
		 %>
    </body>

<%
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close();


} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

