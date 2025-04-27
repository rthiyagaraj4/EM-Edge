<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.http.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/BedforTreatmentArea.js'></script>
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
	 String clinic			= " select  distinct  CLINIC_LONG_DESC clinic_desc  from ae_tmt_area_for_clinic_vw where  facility_id=? and clinic_code=?";
	 String trmt="select  distinct  short_desc   from  ae_tmt_area_for_clinic  where  facility_id=? and Treatment_area_code=?";
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
	 String clinic_desc                    ="";
	 String treatment_area_code			= "";
 	 String bed_no						= "";            
	 String eff_status					= "";	
	 String pseudo_bed					= "";
	 String checkBoxAttribute			= "";
	 String checkBoxAttribute1			= "";
	 String bay_type_code="";
     String treatment_area_description="";
	
	mode							= "INSERT";
   
    String sql = "select clinic_code,treatment_area_code,bed_no,pseudo_bed_yn, eff_status,bay_type_code from AE_BED_FOR_TRMT_AREA where clinic_code=? and treatment_area_code=? and bed_no=? and facility_id=? AND bed_no IN(SELECT BAY_NO FROM AE_SPARE_BAYS WHERE facility_id='"+facilityId+"' AND eff_status='E') ";

	
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

			bed_no				        = rset.getString("bed_no");
			bed_no 			            = (bed_no == null)?"":bed_no;

			eff_status					= rset.getString("eff_status");
			pseudo_bed					= rset.getString("pseudo_bed_yn")==null?"N":rset.getString("pseudo_bed_yn");
			
			bay_type_code				= rset.getString("bay_type_code");
			bay_type_code 			= (bay_type_code == null)?"":bay_type_code;

	
			
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
				checkBoxAttribute ="";
            }


			if(pseudo_bed!=null && pseudo_bed.equalsIgnoreCase("Y"))
			{
					checkBoxAttribute1   = "CHECKED";
			}

			if(pseudo_bed!=null && pseudo_bed.equalsIgnoreCase("N"))
			{
					checkBoxAttribute1   = "";
			}

			mode						= "MODIFY";
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if clinic_code	  

	  
	  
	  if(mode.equalsIgnoreCase("INSERT"))
		{
		  checkBoxAttribute = "CHECKED";
		  checkBoxAttribute1 = "CHECKED";
		}

   pstmt   = con.prepareStatement(clinic);
    	pstmt.setString(1,facilityId);
   	pstmt.setString(2,clinic_code);
   

    	rset = pstmt.executeQuery();

	 while(rset!=null && rset.next())

	  {
	  clinic_desc					= rset.getString("clinic_desc");    
      clinic_desc 				= (clinic_desc == null)?"":clinic_desc;
	 }
	 if(rset!=null)  rset.close();
     if(pstmt!=null)  pstmt.close();
     pstmt   = con.prepareStatement(trmt);
     pstmt.setString(1,facilityId);
     pstmt.setString(2,treatment_area_code);
   	rset = pstmt.executeQuery();
     
	  while(rset!=null && rset.next())

	  {
	 treatment_area_description 		= rset.getString("short_desc");  
      treatment_area_description  	= (treatment_area_description  == null)?"":treatment_area_description ;
	 }
     
     

   %>

	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
	 <form name="bed_treatment_area_form" id="bed_treatment_area_form" action="../../servlet/eAE.AESpAssgnBedToTrtmtAreaServlet?modi=modi" method="post" target="messageFrame">

	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	     <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/> </td>
		      <td class='field'  width='40%'><Input name='clinic_code' id='clinic_code' maxlength=4 size=4  value="<%=clinic_code%>" readonly>
				  <td>
		      </tr> 
		  <tr>
		   <td colspan='4'>&nbsp</td>
		</tr>
	    
			  <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="Common.ClinicDescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='40%'><Input name='clinic_desc' id='clinic_desc' maxlength=25 size=25  value="<%=clinic_desc%>" readonly onBlur="makeValidString(this)">
				  <img src='../../eMP/images/mandatory.gif'align='center'></img>
				  <td>
		      </tr> 
		  <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	    

             <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="eAE.TreatmentAreaCode.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='40%'><Input name='trmt_code' id='trmt_code' maxlength=15 size=15  value="<%=treatment_area_code%>" readonly>
				  <td>
		      </tr> 
 <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
            
			<tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="eAE.TreatmentAreaDesc.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='40%'><Input name='trmt_desc' id='trmt_desc' maxlength=15 size=15  value="<%=treatment_area_description%>" readonly  onBlur="makeValidString(this)">
			<img src='../../eMP/images/mandatory.gif'align='center'></img>	 
			<td>
		      </tr> 
		 <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
   <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label'  width='25%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='40%'><Input name='bay_no' id='bay_no' maxlength=15 size=15  value="<%=bed_no%>" readonly>
				  <td>
		      </tr> 
 <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>


          <tr><td align='left' width='12%'>&nbsp;</td> 	
						<td class='label'  width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			    	    <td class='field'  width='40%'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=checkBoxAttribute%>  onClick='chkval(this);'>
						</td>
		                <td align='left' width='13%'>&nbsp;</td> 
			        </tr>
 <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
			  <tr><td align='left' width='12%'>&nbsp;</td> 	
						<td class='label'  width='25%'><fmt:message key="eAE.PseudoBedBay.label" bundle="${ae_labels}"/></td>
			    	    <td class='field'  width='40%'><input type='checkbox' name='pseudo_bay' id='pseudo_bay'value="Y" <%=checkBoxAttribute1%>  onClick='chkValue(this);' disabled>
						</td>
		                <td align='left' width='13%'>&nbsp;</td> 
			        </tr>
                      <INPUT TYPE="HIDDEN" name="fnname" id="fnname" value="mod">
</form>
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

