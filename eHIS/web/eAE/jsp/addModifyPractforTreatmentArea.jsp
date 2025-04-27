<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/PractforTreatmentArea.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head> 
  <%	
  	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	 
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	  String	facilityId 				= (String) session.getValue( "facility_id" ) ; 
	 String mode						= "";
	
         
	 String clinic						= " select  distinct a.clinic_code, a.clinic_long_desc clinic_desc,a.open_to_all_prac_for_clinic_yn,b.SPECIALITY_CODE from ae_tmt_area_for_clinic_vw a,op_clinic b where a.eff_status = 'E'  and a.OPEN_TO_ALL_PRAC_FOR_CLINIC_YN = 'N' and a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.clinic_code order by 2 ";
 	  String clinic_code_result			= request.getParameter("clinic_code");
		 clinic_code_result 			= (clinic_code_result == null)?"":clinic_code_result;
	
	 String treatment_area_code_result	= request.getParameter("treatment_area_code");
		 treatment_area_code_result		= (treatment_area_code_result == null)?"":treatment_area_code_result;
	
	 String practitioner_id_result		= request.getParameter("practitioner_id");
	 	 practitioner_id_result			= (practitioner_id_result == null)?"":practitioner_id_result;

		 
	 try
  {
     con								= ConnectionManager.getConnection(request);
     String clinic_code					= "";
 	 String practitioner_id				= "", practitioner_desc = "";              
	 String eff_status					= "E";				
	 String checkBoxAttribute			= "";
 	 String disabledField				= "";
	 String treatment_area_code_desc="";
	 String clinic_code_desc="";
	  String practitioner_name="";
	
	  int rowIndex=1;
     String specialty_code="";
		mode							= "INSERT";
	
   
    String sql = "select CLINIC_LONG_DESC,TREATMENT_AREA_DESC,PRACTITIONER_SHORT_NAME,EFF_STATUS from AE_PRACT_FOR_TMT_AREA_vw where facility_id=? and CLINIC_CODE=? and TREATMENT_AREA_CODE=? and PRACTITIONER_ID =? ";
 if(!(clinic_code_result.equals("") && treatment_area_code_result.equals("") && practitioner_id_result.equals("")))
  {
	  
	pstmt   = con.prepareStatement(sql);
    pstmt.setString(1,facilityId);
	pstmt.setString(2,clinic_code_result) ;
	pstmt.setString(3,treatment_area_code_result) ;
	pstmt.setString(4,practitioner_id_result);
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
			clinic_code_desc					= rset.getString("CLINIC_LONG_DESC");    
			clinic_code_desc 				= (clinic_code_desc == null)?"":clinic_code_desc;

			treatment_area_code_desc		= rset.getString("TREATMENT_AREA_DESC");
			treatment_area_code_desc 		= (treatment_area_code_desc == null)?"":treatment_area_code_desc;


			practitioner_name				= rset.getString("PRACTITIONER_SHORT_NAME");
			practitioner_name 			= (practitioner_name == null)?"":practitioner_name;


			eff_status					= rset.getString("EFF_STATUS");

			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			mode						= "MODIFY";
			
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if clinic_code	
  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";

       if(mode.equalsIgnoreCase("INSERT"))
		  disabledField		= "DISABLED";
			
			
	   
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="pract_treatment_area_form" id="pract_treatment_area_form" action="../../servlet/eAE.PractforTreatmentAreaServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		       
		      <td class='label'  width='50%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				 <%if(mode.equalsIgnoreCase("insert"))
	           {%>
		      <td class='field'  width='50%'> <select name='clinic_code' id='clinic_code' onChange='popTreatmentCode(this);' >
		      <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <%
				 pstmt   = con.prepareStatement(clinic);
				 pstmt.setString(1,facilityId) ;
				 rset   = pstmt.executeQuery();
				
				

				 while(rset!=null && rset.next())
				 {
					
					specialty_code=rset.getString("SPECIALITY_CODE");

					if(clinic_code.equals(rset.getString(1)))
	                    out.println("<option value='"+rset.getString(1)+"$"+rset.getString(3)+"' selected>");	                
					else
                        out.println("<option value='"+rset.getString(1)+"$"+rset.getString(3)+"'>");	     
					out.println(rset.getString(2));
					out.println("</option>"); 
				 
				 %>
				<script>parent.frames[1].specialtyForClinc[<%=rowIndex%>]='<%=specialty_code%>';
				</script> 
				 <%
				rowIndex++; 
				}
				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
              %>
		      </select>
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
				  </td>
			    <%}else
				  {%>
                  <TD class='field'  width='50%'> <input type='text'  name='clinic_code' id='clinic_code'  value="<%=clinic_code_desc%>" maxLength='20' size='20'  readonly></TD>
				   <input type='hidden' name='clinic_code_val' id='clinic_code_val' value='<%=clinic_code_result%>' >
			     <%}%>
	    </tr>	
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
				   <%if(mode.equalsIgnoreCase("insert"))
	           {%>
		      <td class='field'  width='50%'> <select name='treatment_area_code' id='treatment_area_code' onchange='practionerenable();'>
		      <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      </select>
 		      <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
			   <%}else
				  {%>
                  <TD class='field'  width='50%'> <input type='text'  name='treatment_area_code' id='treatment_area_code'  value="<%=treatment_area_code_desc%>" maxLength='15' size='15'  readonly></TD>
				   <input type='hidden' name='treatment_area_code_val' id='treatment_area_code_val' value='<%=treatment_area_code_result%>' >	 	
			     <%}%>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>

           <input type=hidden name='practitioner_id' id='practitioner_id' value="">
 
	 <tr> 
		      <td class='label'  width='50%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		    <%if(mode.equalsIgnoreCase("insert"))
	      {%> 
		      
		      <td class='field'  width='50%' >
	             <input type=text  name='practitioner_desc' id='practitioner_desc' size=30 maxlength=30  onBlur="beforeGetPractitioner(document.forms[0].pract_button,practitioner_desc);"<%=disabledField%> >
	             <input type=button class=button name='pract_button' id='pract_button' value='?' onclick="aegetPractitioner(this,practitioner_desc)" style=""<%=disabledField%>>
	             <input type='hidden' name='prev_pract_name' id='prev_pract_name' value="">
		 	    <img src='../../eCommon/images/mandatory.gif' ></img> </td> 
		  <%} else 
	           { %> 
					 
		      <td class='field'  width='50%' >
	             <input type=text  name='practitioner_desc' id='practitioner_desc' size=30 maxlength=30 VALUE="<%=practitioner_name%>" READONLY>  </td> 
                     <input type='hidden' name='practitioner_id_val' id='practitioner_id_val' value='<%=practitioner_id_result%>' >
			  <% } %>
        </tr> 

				 
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>' <%=checkBoxAttribute%>  onClick='chkValue(this);'>
              </td>
        </tr>

<tr><td colspan='2' height='5'></td></tr>
</table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
			 <input type='hidden' name='clinic_code_val' id='clinic_code_val' value='<%=clinic_code_result%>' >	 	
			 <input type='hidden' name='treatment_area_code_val' id='treatment_area_code_val' value='<%=treatment_area_code_result%>' >	 	
			 <input type='hidden' name='practitioner_id_val' id='practitioner_id_val' value='<%=practitioner_id_result%>' >	 	
			 
			 <input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
	 </form>
		  <%
               if(mode.equals("MODIFY")){
									
			 }
				else
	        {
			       out.println("<script>popTreatmentCode(document.forms[0].clinic_code);");
				   out.println("document.forms[0].practitioner_desc.value=\""+practitioner_desc+"\"");
				  out.println("document.forms[0].practitioner_id.value=\""+practitioner_id+"\"");
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

