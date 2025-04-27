<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/AssignSpareBaysToTreatmentArea.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
  
</head>  
  <%	
  	 request.setCharacterEncoding("UTF-8");
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	 String mode						= "";
	 String clinic						= " select  distinct clinic_code, CLINIC_LONG_DESC clinic_desc from ae_tmt_area_for_clinic_vw where eff_status = 'E' and facility_id=? order by 2 ";
 	  String clinic_code_result			= request.getParameter("clinic_code");
		 clinic_code_result 			= (clinic_code_result == null)?"":clinic_code_result;
	
	     String treatment_area_code_result	= request.getParameter("treatment_area_code");
		 treatment_area_code_result		= (treatment_area_code_result == null)?"":treatment_area_code_result;
	
	     String bed_no_result		= request.getParameter("bed_no");
	 	 bed_no_result			= (bed_no_result == null)?"":bed_no_result;
	
  try
  {
     con								= ConnectionManager.getConnection(request);
     String clinic_code					= "";
	 String treatment_area_code			= "";
 	 String bed_no						= "";            
	 mode							= "INSERT";
   
    String sql = "select clinic_code,treatment_area_code,bed_no,pseudo_bed_yn, eff_status from AE_BED_FOR_TRMT_AREA where clinic_code=? and treatment_area_code=? and bed_no=? and facility_id=? ";

	
 if(!(clinic_code_result.equals("") && treatment_area_code_result.equals("") && bed_no_result.equals("")))
  {
	  
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,clinic_code_result);
	pstmt.setString(2,treatment_area_code_result);
	pstmt.setString(3,bed_no_result);
	pstmt.setString(4,facilityId);

	rset = pstmt.executeQuery();
	 while(rset!=null && rset.next())
	  {
			clinic_code					= rset.getString("clinic_code");    
			clinic_code 				= (clinic_code == null)?"":clinic_code;

			treatment_area_code			= rset.getString("treatment_area_code");
			treatment_area_code 		= (treatment_area_code == null)?"":treatment_area_code;

			bed_no				= rset.getString("bed_no");
			bed_no 			= (bed_no == null)?"":bed_no;

			//eff_status					= rset.getString("eff_status");
			//pseudo_bed					= rset.getString("pseudo_bed_yn")==null?"N":rset.getString("pseudo_bed_yn");
			mode						= "MODIFY";
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if clinic_code
   %>

	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
	 <form name="assign_sparebays_form" id="assign_sparebays_form" action="../../servlet/eAE.BedforTreatmentAreaServlet" method="post" target="messageFrame">

	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='90%'>
	 <br><br><br><br>
	 <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><select name='clinic_code' id='clinic_code'  onChange='popTreatmentCode(this);' value='<%=clinic_code%>'>
		      <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <%
				 pstmt   = con.prepareStatement(clinic);
				 pstmt.setString(1,facilityId) ;
				 rset   = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				 {
					if(clinic_code.equals(rset.getString(1)))
						
	                    out.println("<option value='"+rset.getString(1)+"' selected>");	                
					else
                        out.println("<option value='"+rset.getString(1)+"'>");	     
					out.println(rset.getString(2));
					out.println("</option>"); 
				 }

				 if(rset!=null) rset.close();
				 if(pstmt!=null) pstmt.close();
				 
              %>
		      </select>
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
	    </tr>	
		<tr>
		   <td colspan='2'></td>
		</tr>
<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><select name='treatment_area_code' id='treatment_area_code'  value='<%=treatment_area_code%>'>
		      <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      </select>
 		      <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>

	<tr>
		<td  width='50%' class='label'><fmt:message key="eAE.BedBay.label" bundle="${ae_labels}"/></td> 
		<td class='field'  width='50%'>
			<select name='bay_mode' id='bay_mode'>
				<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
				<option value='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<option value='P'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/>
				<option value='S'><fmt:message key="eIP.Pseudo.label" bundle="${ip_labels}"/>
				</select>
				
		</td>
	</tr>
	<tr>
		   <td colspan='2'></td>
		</tr>
   <tr>	
	<td class='button'  colspan='2' align="right">
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'>
	<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll();'></td>	
	</tr>
			<tr><td colspan='2' ></td></tr>
</table>

			 
 <input type='hidden' name='bed_no_val' id='bed_no_val' value='<%=bed_no%>' >	 	
<input type='hidden' name='treatment_area_code_val' id='treatment_area_code_val' value='<%=treatment_area_code%>' >	


	 </form>
		  <%
                if(mode.equals("MODIFY")){
				
			       out.println("<script>popTreatmentCode(document.forms[0].clinic_code);");
				
				   out.println("document.forms[0].bed_no.value=\""+bed_no+"\"");
				   out.println("</script>");
				   
			 }
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

