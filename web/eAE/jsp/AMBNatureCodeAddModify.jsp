<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<html>
<head>
 <!--  <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/AMBNatureCode.js'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <!--<script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>-->
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/messages.js'></script>
  <script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <%	
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	// String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	 String mode						= "";

     String amb_nature_code	= request.getParameter("amb_nature_code");
		 amb_nature_code		= (amb_nature_code == null)?"":amb_nature_code;
  try
  {
     con								= ConnectionManager.getConnection(request);

	 String long_desc					= "";
	 String short_desc					= "";
	 String eff_status					= "";

	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
	// String disabledField				= "";
		mode							= "insert";
   
    String sql = "select * from AE_AMB_NATURE where amb_nature_code= ? ";
 if(!(amb_nature_code.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,amb_nature_code) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		amb_nature_code			= rset.getString("AMB_NATURE_CODE");    
			amb_nature_code 			= (amb_nature_code == null)?"":amb_nature_code;
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
					checkBoxAttribute="";
					//readOnlyAttribute	 = "READONLY";
	   	    }
			mode						 = "update";
			readOnlyAttribute1			 = "READONLY";
	  }
	  

	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if amb_nature_code	  
	  if(mode.equalsIgnoreCase("insert")){
		  checkBoxAttribute = "CHECKED";
		  eff_status="E";
		  }
   %>

	 <body  onload='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="amb_nature_form" id="amb_nature_form" action="../../servlet/eAE.AmbulanceNatureServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		 <br><br><br><br><br><br><br><br><br><br>
	  
	  <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	   
	   <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'>&nbsp;&nbsp;<input type="text" name="amb_nature_code" id="amb_nature_code" value="<%=amb_nature_code%>" maxLength="4" size="4" <%=readOnlyAttribute1%> onBlur="ChangeUpperCase(this)" onkeypress="return CheckForSpecChars(event)">
   		      <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			  </td> 	
		      <td align='left' width='13%'>&nbsp;</td>
	    </tr>	
		
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
		<tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.longdescription.label"  bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'>&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>" maxLength="30" size="30" <%=readOnlyAttribute%> onBlur = "return makeValidString(this)">
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
	          <td align='left' width='13%'>&nbsp;</td> 
        </tr>
		
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
		<tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'>&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>" maxLength="20" size="20" <%=readOnlyAttribute%>  onBlur = "return makeValidString(this)"	>
 		      <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
	          <td align='left' width='13%'>&nbsp;</td> 
        </tr>
		
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
		<tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'>&nbsp;<input type="checkbox"  name="eff_status" id="eff_status" value="<%=eff_status%>" <%=checkBoxAttribute%>  onClick="chkValue(this);">
              </td>
	          <td align='left' width='13%'>&nbsp;</td> 
        </tr>
		
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	    
	 </table> 
		     <input type="hidden" name="mode" id="mode" value="<%=mode%>" >	
	 </form>		
    </body>

<%
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close();

} catch(Exception e){

System.out.println("@@ Exception in AMBNatureCodeAddModify.jsp="+e.toString());
e.printStackTrace();
	
}
   finally
    {
    	if(con != null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

