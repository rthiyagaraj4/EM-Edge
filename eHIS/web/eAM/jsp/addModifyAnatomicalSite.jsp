<!DOCTYPE html>
<%--
	FileName	: addModifyAnatomicalSite.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAM/js/AnatomicalSite.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <%	
	request.setCharacterEncoding("UTF-8");
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
//	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	 String mode						= "";

     String anatomical_site_code_result	= request.getParameter("anatomical_site_code");
		 anatomical_site_code_result	= (anatomical_site_code_result == null)?"":anatomical_site_code_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 String anatomical_site_code		= "";
	 String long_desc					= "";
	 String short_desc					= "";
	 String applicable_to_iss_yn		= "";
	 String eff_status					= "";

	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
	 String disabledField				= "";
	 String checkBoxAttribute1			= "";
	 String oral_cavity_yn				= "";
	 String checkBoxAttribute2			= "";
		mode							= "INSERT";
   
    String sql = "select * from AM_ANATOMICAL_SITE where anatomical_site_code	 = ? ";
 if(!(anatomical_site_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,anatomical_site_code_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		anatomical_site_code		= rset.getString("ANATOMICAL_SITE_CODE");    
			anatomical_site_code		= (anatomical_site_code == null)?"":anatomical_site_code;
			long_desc					= rset.getString("LONG_DESC");
			long_desc 					= (long_desc == null)?"":long_desc;
			short_desc					= rset.getString("short_desc");
			short_desc 					= (short_desc == null)?"":short_desc;
			applicable_to_iss_yn		= rset.getString("APPLICABLE_TO_ISS_YN");
			if(applicable_to_iss_yn!=null && applicable_to_iss_yn.equalsIgnoreCase("Y"))
					checkBoxAttribute1  = "CHECKED";
			oral_cavity_yn				= rset.getString("oral_cavity_yn");
			if(oral_cavity_yn!=null && oral_cavity_yn.equalsIgnoreCase("Y"))
					checkBoxAttribute2  = "CHECKED";
			eff_status					= rset.getString("EFF_STATUS");
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
					readOnlyAttribute	 = "READONLY";
					disabledField		 = "DISABLED";
	   	    }
			mode						 = "MODIFY";
			readOnlyAttribute1			 = "READONLY";
	  }
	  

	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if anatomical_site_code_result	  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="anatomical_site" id="anatomical_site" action="../../servlet/eAM.AnatomicalSiteServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		 <br><br><br><br><br><br><br><br>
	    <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	    <tr>
		      <td  width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='40%'>&nbsp;&nbsp;<input type='text' name='anatomical_site_code' id='anatomical_site_code' value='<%=anatomical_site_code%>' maxLength='4' size='4' <%=readOnlyAttribute1%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
   		      <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			  </td> 	
		      <td  width='13%'>&nbsp;</td>
	    </tr>	
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
		<tr>
		      <td  width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='40%'>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' value="<%=long_desc%>" maxLength='30' size='30' <%=readOnlyAttribute%> onBlur="makeValidString(this)">
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
	          <td width='13%'>&nbsp;</td> 
        </tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		<tr>
		      <td  width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='40%'>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' value="<%=short_desc%>" maxLength='15' size='15' <%=readOnlyAttribute%> onBlur="makeValidString(this)" >
 		      <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
	          <td  width='13%'>&nbsp;</td> 
        </tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		<tr>
		      <td  width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="eAM.ApplicabletoISS.label" bundle="${am_labels}"/></td>
		      <td class='fields' width='40%'>&nbsp;<input type='checkbox' name='applicable_to_iss_yns' id='applicable_to_iss_yns' value='<%=applicable_to_iss_yn%>' <%=checkBoxAttribute1%>  <%= disabledField%> onClick='chkValue(this);'>
              </td>
	          <td  width='13%'>&nbsp;</td> 
        </tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		<tr>
		      <td  width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="eMR.OralCavity.label" bundle="${mr_labels}"/></td>
		      <td class='fields' width='40%'>&nbsp;<input type='checkbox' name='oral_cavity_yns' id='oral_cavity_yns' value='<%=oral_cavity_yn%>' <%=checkBoxAttribute2%>  <%= disabledField%> onClick='chkValue(this);'>
              </td>
	          <td  width='13%'>&nbsp;</td> 
        </tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		<tr>
		      <td  width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='fields' width='40%'>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>' <%=checkBoxAttribute%>  onClick='chkValue(this);'>
              </td>
	          <td  width='13%'>&nbsp;</td> 
        </tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	    
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
		     <input type='hidden' name='applicable_to_iss_yn' id='applicable_to_iss_yn' value='' >	
		     <input type='hidden' name='oral_cavity_yn' id='oral_cavity_yn' value='' >	
	 </form>
		  <%
                if(mode.equals("INSERT"))
					out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].anatomical_site_code.focus();</script>");
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
    	
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

