<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.http.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <!--  <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/BedforTreatmentArea.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
  <script>
      function setFocus()
	  {
		  if(document.forms[0].clinic_code.disabled==false)
			  document.forms[0].clinic_code.focus();
		 
	  }
		

  </script>
</head>
  <%	
     request.setCharacterEncoding("UTF-8");
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	 String mode						= "";
	////////////////////
	ArrayList Arr_Of_HashMap=new ArrayList();
	HashMap general_HashMap=new HashMap();

///////////////////
	 

	 String clinic						= " select  distinct clinic_code, clinic_desc from ae_tmt_area_for_clinic_vw where eff_status = 'E' and facility_id=? order by 2 ";


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
	 String treatment_area_code_desc    = "";
 	 String bed_no						= "";            
	 String eff_status					= "";	
	 String pseudo_bed					= "";
	 String checkBoxAttribute			= "";
	 String checkBoxAttribute1			= "";
 	 //String disabledField				= "";
	 //String disabledfields				= "";
	 String bay_type_code="";
	 String bay_type_desc="";
	 String readonly  ="";
	 String modifymode="";

	// String modify						= "";
	// String readOnlyAttribute			= "";
	 //String readOnlyAttribute1			= "";
	
	mode							= "INSERT";
   
    String sql = "SELECT A.CLINIC_CODE, A.TREATMENT_AREA_CODE, B.SHORT_DESC trtmt_code_desc, A.BED_NO, A.PSEUDO_BED_YN, A.EFF_STATUS, A.BAY_TYPE_CODE,c.short_desc FROM AE_BED_FOR_TRMT_AREA A, AE_TMT_AREA_FOR_CLINIC B,ae_bay_type c WHERE A.TREATMENT_AREA_CODE = B.TREATMENT_AREA_CODE AND a.bay_type_code = c.bay_type_code and A.CLINIC_CODE=? AND A.TREATMENT_AREA_CODE=? AND A.BED_NO=? AND A.FACILITY_ID=? ";

//	AND B.OPEN_TO_ALL_PRAC_FOR_CLINIC_YN='N' AND B.EFF_STATUS='E'

//	"select clinic_code,treatment_area_code,bed_no,pseudo_bed_yn, eff_status,bay_type_code from AE_BED_FOR_TRMT_AREA where clinic_code=? and treatment_area_code=? and bed_no=? and facility_id=? ";

	
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
			clinic_code					= rset.getString(1);    
			clinic_code 				= (clinic_code == null)?"":clinic_code;

			treatment_area_code			= rset.getString(2);
			treatment_area_code 		= (treatment_area_code == null)?"":treatment_area_code;

			treatment_area_code_desc	= rset.getString(3);
			treatment_area_code_desc 	= (treatment_area_code_desc == null)?"":treatment_area_code_desc;

			bed_no				        = rset.getString(4);
			bed_no 			            = (bed_no == null)?"":bed_no;

			pseudo_bed					= rset.getString(5)==null?"N":rset.getString(5);

			eff_status					= rset.getString(6);

			bay_type_code				= rset.getString(7);
			bay_type_code 			    = (bay_type_code == null)?"":bay_type_code;

			bay_type_desc=(rset.getString(8) == null)?"":rset.getString(8);
			
			
			
			
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
				   readonly="disabled";
            }


			if(pseudo_bed!=null && pseudo_bed.equalsIgnoreCase("Y"))
			{
					checkBoxAttribute1   = "CHECKED";
					//disabledfields		 = "disabled";//naveen
			}

			if(pseudo_bed!=null && pseudo_bed.equalsIgnoreCase("N"))
			{
					checkBoxAttribute1   = "";
					//disabledfields		 = "disabled";//naveen
			}

			mode						= "MODIFY";
			//modify						= "READONLY";	
			//disabledField				= "DISABLED";
			
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if clinic_code	  
	  if(mode.equalsIgnoreCase("INSERT"))
		{
		  checkBoxAttribute = "CHECKED";
		  checkBoxAttribute1 = "CHECKED";
		}else if(mode.equalsIgnoreCase("MODIFY")) modifymode="disabled";

   %>

	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
	 <form name="bed_treatment_area_form" id="bed_treatment_area_form" action="../../servlet/eAE.BedforTreatmentAreaServlet" method="post" target="messageFrame">

	 <table border="0" cellpadding="0" cellspacing="0" align='center' width='90%'>
		 <br><br><br><br><br><br><br><br><br>
	    <tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	    <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'>&nbsp;<select name='clinic_code' id='clinic_code'  onChange='popTreatmentCode(this);' value='<%=clinic_code%>' <%=readonly%> <%=modifymode%>>
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

				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
              %>
		      </select>
   		      <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			  </td> 	
		      <td align='left' width='13%'>&nbsp;</td>
	    </tr>	
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>

				
<tr> 
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'>&nbsp;

			<%  if(mode.equalsIgnoreCase("MODIFY")) {%>
				   <input type='text' name='treatment_area_code1' id='treatment_area_code1' value='<%=treatment_area_code_desc%>' maxLength='15' size='15' <%=modifymode%>>  
				   <input type='hidden' name='treatment_area_code' id='treatment_area_code' value='<%=treatment_area_code%>' >   
	<%} else {%>
				<select name='treatment_area_code' id='treatment_area_code'  value='<%=treatment_area_code%>' <%=readonly%> <%=modifymode%>>
		      <option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- 
				<option value='<%=treatment_area_code%>' selected > <%=treatment_area_code_desc%></option>  -->
		      </select>
 		      
	<%}%>			
			  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
	          <td align='left' width='13%'>&nbsp;</td> 
        </tr>

		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
<tr>

	<td align='left' width='10%'>&nbsp;</td> 	
	<td class='label' align='right' width='30%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
	<td class='label' align='left' width='45%'>&nbsp;<input type='text' name='bed_no' id='bed_no' value='<%=bed_no%>'<%=readonly%> <%=modifymode%> maxLength='8' size='8' 
	onKeyPress="return CheckForSpecChars(event);" >
	  <img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	<td align='left' width='15%'>&nbsp;</td> 

</tr>
	<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
	
<tr>

<td colspan='1'>&nbsp;</td>
<td class='label' align='right' width=''><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></td>
<td align=left class=LABEL width='' >
	<%  if(eff_status.equals("D")) {%>
	<input type='text' name='bay_type_desc' id='bay_type_desc' value='<%=bay_type_desc%>' maxLength='15' size='15' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img> 
	<input type='hidden' name='bay_type' id='bay_type' value='<%=bay_type_code%>' > 
	
	<%}
else
	  {%>
	&nbsp;<select name='bay_type' id='bay_type'  >
<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%
	String sel="";
	
	String sqlBayType="select bay_type_code,short_desc from ae_bay_type where eff_status=? ORDER BY 2";

	String[] params={"E"};
	eAE.AEUtils oputils = new  eAE.AEUtils();
	
	Arr_Of_HashMap=oputils.getData(sqlBayType,params,request);
	general_HashMap.clear();

	for(int i=0; i<Arr_Of_HashMap.size();i++)
	{

	 sel="";
	 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
	 if(general_HashMap.get("BAY_TYPE_CODE").equals(bay_type_code)) sel="selected";
	
%>
	
<option value='<%=general_HashMap.get("BAY_TYPE_CODE")%>' <%=sel%>><%=general_HashMap.get("SHORT_DESC")%></option>
	<%						

}
%>
</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>


	<%}%>
</td>
<td colspan='1'>&nbsp;</td>	

</tr>
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		 <tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="eAE.PseudoBedBay.label" bundle="${ae_labels}"/></td>
		      <td class='label' align='left' width='40%'><input type='checkbox' name='pseudo_bed' id='pseudo_bed' value='<%=pseudo_bed%>' <%=checkBoxAttribute1%> <%=readonly%> onClick='chkValuePseudoBed(this);'>
              </td>
	          <td align='left' width='13%'>&nbsp;</td> 
		 </tr><tr>
		   <td colspan='4'>&nbsp;</td></tr><tr>
		      <td align='left' width='12%'>&nbsp;</td> 	
		      <td class='label' align='right' width='25%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='label' align='left' width='40%'><input type='checkbox' name='eff_status' id='eff_status'value="E"<%=checkBoxAttribute%>  onClick='chkValue(this);'>
              </td>
	          <td align='left' width='13%'>&nbsp;</td> 
        </tr>
		
		<tr>
		   <td colspan='4'>&nbsp;</td>
		</tr>
		
		
	    
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
			 <input type='hidden' name='clinic_code_val' id='clinic_code_val' value="<%=clinic_code%>" >	 	
			 <input type='hidden' name='treatment_area_code_val' id='treatment_area_code_val' value='<%=treatment_area_code%>' >	 	
			 <input type='hidden' name='bed_no_val' id='bed_no_val' value='<%=bed_no%>' >	 	
			 <input type='hidden' name='eff_status_val' id='eff_status_val' value='Y' >	
        	

			 <input type='hidden' name='pseudo_bed_val' id='pseudo_bed_val' value=<%=pseudo_bed%> >		 
			 <input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
			 
			 



	 </form>
		  
    </body>

<% 
	Arr_Of_HashMap.clear();
} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

