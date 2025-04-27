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
  <script language='javascript' src='../../eAE/js/InjuryCategory.js'></script>
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

     String inj_category_code_result	= request.getParameter("inj_category_code");  
		inj_category_code_result	= (inj_category_code_result == null)?"":inj_category_code_result;
  try 
  {
     con								= ConnectionManager.getConnection(request);
	 String inj_category_code			= "";
	 String long_desc					= "";
	 String short_desc					= "";
	 String oscc_yn					    = "";
	 String eff_status					= "";
	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
	 String checkBoxAttribute1          = "";
	 String disabledField1              = "";
		mode							= "INSERT";
   
    String sql = "select * from AE_INJURY_CATEGORY where INJ_CATEGORY_CODE= ?";
 if(!(inj_category_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,inj_category_code_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		inj_category_code			= rset.getString("INJ_CATEGORY_CODE");    
			inj_category_code 		= (inj_category_code == null)?"":inj_category_code;
			long_desc					= rset.getString("LONG_DESC");
			long_desc 					= (long_desc == null)?"":long_desc;
			short_desc					= rset.getString("short_desc");
			short_desc 					= (short_desc == null)?"":short_desc;
			oscc_yn                     = rset.getString("OSCC_YN");
			oscc_yn 					= (oscc_yn == null)?"":oscc_yn;
			eff_status					= rset.getString("EFF_STATUS");
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
					
					
			}
			else
		    {
					disabledField1		 = "DISABLED";
					readOnlyAttribute	 = "READONLY";
	   	    }
			if(oscc_yn!=null && oscc_yn.equalsIgnoreCase("Y"))
			{
					checkBoxAttribute1   = "CHECKED";
			}
			else
		    {
	   	    }
			mode						 = "MODIFY";
			readOnlyAttribute1			 = "READONLY";
	  }
	  
    
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if inj_category_code_result	  

  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="inj_category_form" id="inj_category_form" action="../../servlet/eAE.InjuryCategoryServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='inj_category_code' id='inj_category_code' value="<%=inj_category_code%>" maxLength='10' size='10' <%=readOnlyAttribute1%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
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
		      <td class='label'  width='50%'><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='checkbox' name='oscc_yn' id='oscc_yn' value='<%=oscc_yn%>'  <%=checkBoxAttribute1%>  onClick='chkValue1(this);' <%=disabledField1%> >
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
					out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].inj_category_code.focus();</script>");
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
    	if(con!=null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

