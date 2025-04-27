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
  <script language='javascript' src="../../eAE/js/TreatmentAreaforClinic.js"></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>   
  <%	
     request.setCharacterEncoding("UTF-8");
     Connection con 			= null;
	 PreparedStatement pstmt	= null;
	 ResultSet rset				= null;
	 String	facilityId 			= (String) session.getValue( "facility_id" ) ;
	 String mode				= "";
	 
	
	 
	 
	 StringBuffer clinic = new StringBuffer(" ");
	 clinic.append("select a.clinic_code,  a.long_desc short_desc, a.open_to_all_pract_yn, ");
	 clinic.append("nvl(b.gender,'NA') gender from op_clinic a, am_age_group b");
     clinic.append(" where facility_id = ? and a.age_group_code = b.age_group_code(+) ");
	 clinic.append(" and a.LEVEL_OF_CARE_IND = 'E' and a.clinic_type in (select locn_type from ");
     clinic.append(" am_care_locn_type where care_locn_type_ind='C') and a.eff_status='E' ");
	 clinic.append(" order by 2 ");
     
    
	 String clinic_code_result= request.getParameter("clinic_code");
	 
	 	
	 
				
				  clinic_code_result 	= (clinic_code_result == null)?"":clinic_code_result;
				  
	 String treatment_area_code_result	= request.getParameter("treatment_area_code");
	 
	 treatment_area_code_result		= (treatment_area_code_result == null)?"":treatment_area_code_result;
  
  try
  {
     con								= ConnectionManager.getConnection(request);
     String clinic_code					= "";
	 String treatment_area_code			= "";
 	 String long_desc					= "";              
	 String	short_desc					= "";   
	 String priority_zone               = "";
	 String gender						= "";
	 String open_to_all_prac_for_clinic_yn = "Y";       
     String eff_status					= "";				
	 String checkBoxAttribute			= "";
 	 String checkBoxAttribute2			= "";
	 String disabledField				= "";
	 String disabledField1				= "";
	 String readOnlyAttribute			= "";
	  String readOnlyAttribute1			= "";
	 mode							    = "INSERT";
	 /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	 String sql_1                       ="";
	 String locale                      = (String)session.getAttribute("LOCALE");
	 /* CRF  SKR-CRF-0021 [IN028173] end  */
	 /* Below line are added by lakshmanan for Ml-MMOH-CRF-1973 on 01-07-2023 start */
	 boolean isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); 
	 String appearAsTabYN				="";
	 String tabColour					="";
	 String checkBoxAttribute3		 	= "";
	 String dispManTabColourGif		 	= "";
	 String disableTabColour			= "";
	 /* Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end */
	 
      String sql = "select * from AE_TMT_AREA_FOR_CLINIC where CLINIC_CODE= ?  and TREATMENT_AREA_CODE= ?  ";
    
    
 if(!(clinic_code_result.equals("") && treatment_area_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql.toString());
	pstmt.setString(1,clinic_code_result) ;
	pstmt.setString(2,treatment_area_code_result) ;
	
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
			clinic_code					= rset.getString("CLINIC_CODE");    
			clinic_code 				= (clinic_code == null)?"":clinic_code;
			
			
			
			treatment_area_code			= rset.getString("TREATMENT_AREA_CODE");
			treatment_area_code 		= (treatment_area_code == null)?"":treatment_area_code;

			long_desc					= rset.getString("LONG_DESC");
			long_desc 					= (long_desc == null)?"":long_desc;
			short_desc					= rset.getString("SHORT_DESC");
			short_desc 					= (short_desc == null)?"":short_desc;
			priority_zone				= rset.getString("PRIORITY_ZONE");
			priority_zone				= (priority_zone == null)?"":priority_zone;
			gender						= rset.getString("GENDER");
			gender 						= (gender == null)?"":gender;
			/* added by lakshmanan for ML-MMOH-CRF-1973 01-07-2023 on 01-07-2023 start*/
			if(isAppearAsTabEnable){
				appearAsTabYN 			= rset.getString("APPEAR_AS_TAB_YN");
				tabColour 				= rset.getString("TAB_COLOUR");
				appearAsTabYN 			= (appearAsTabYN == null)?"":appearAsTabYN;
				tabColour 				= (tabColour == null)?"":tabColour;
			}
			/*added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023  end */
			open_to_all_prac_for_clinic_yn= rset.getString("OPEN_TO_ALL_PRAC_FOR_CLINIC_YN");
			if(open_to_all_prac_for_clinic_yn!=null && open_to_all_prac_for_clinic_yn.equalsIgnoreCase("Y"))
				checkBoxAttribute= "CHECKED";
			eff_status					= rset.getString("EFF_STATUS");
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute2  = "CHECKED";
			}
			else
		    {
					disabledField		= "DISABLED";
					readOnlyAttribute	= "READONLY";
			}
			mode						= "MODIFY";
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  }	  
	   if(mode.equalsIgnoreCase("INSERT"))
	    {
		  checkBoxAttribute2 = "CHECKED";
		} 
      else
		{
		   disabledField1	  = "DISABLED";
		   readOnlyAttribute1 = "READONLY";
		}
   %>

	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
	 <form name="treatment_area_form" id="treatment_area_form" action="../../servlet/eAE.TreatmentAreaForClinicServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='90%'>
		 <br><br><br><br>
	    <tr>
		   <td colspan='4' height='5'></td>
		</tr>
	    <tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		      <td class='fields'  width='45%'><select name='clinic_code' id='clinic_code' onChange='getClinic(this);' <%=disabledField1%>>
		       readOnlyAttribute = "READONLY";
		       <option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
		      <%
				
			    pstmt   = con.prepareStatement(clinic.toString());
				 
				 pstmt.setString(1,facilityId) ;
 				 rset = pstmt.executeQuery();
				 while(rset!=null && rset.next())
				 {
					
    				if(clinic_code.equals(rset.getString(1)))
	                    out.println("<option value='"+rset.getString(1)+"::"+rset.getString(3)+"::"+rset.getString(4)+"' selected>");
					else
	                  out.println("<option value='"+rset.getString(1)+"::"+rset.getString(3)+"::"+rset.getString(4)+"'>");
                          
					out.println(rset.getString(2));
					out.println("</option>"); 
				 }
				 if(pstmt!=null){
					pstmt.close();
				 }
				 if(rset!=null){
					rset.close();
				 }
              %>
		      </select>
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
		      <td  width='15%'></td>
	    </tr>
		<tr>
		   <td colspan='4'></td>
		</tr>
				 
    	
				 
		<tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="eAE.TreatmentAreaCode.label" bundle="${ae_labels}"/></td>
		      <td class='field'  width='45%'><input type='text' name='treatment_area_code' id='treatment_area_code' value='<%=treatment_area_code%>'  <%=readOnlyAttribute1%> maxLength='2' size='2' onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
  			      <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
	          <td align='left' width='15%'></td> 
        </tr>
		<tr>
		   <td colspan='4'></td>
		</tr>
		<tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		      <td class='filed'  width='45%'><input type='text' name='long_desc' id='long_desc' value="<%=long_desc%>" <%=readOnlyAttribute%> maxLength='30' size='30' onBlur="makeValidString(this)">
                  <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
	          <td  width='15%'></td> 
        </tr>
		<tr>
		   <td colspan='4'></td>
		</tr>
		<tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='45%'><input type='text' name='short_desc' id='short_desc' value="<%=short_desc%>" <%=readOnlyAttribute%> maxLength='15' size='15' onBlur="makeValidString(this)">
				  <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
	          <td  width='15%'></td> 
        </tr>
		<tr>
		   <td colspan='4'></td>
		</tr>
		<tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='45%'><select name='gender' id='gender' <%=disabledField%>>
			  <%if (gender.equals("")){%>
					<option value='' selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <%}else {%>
					<option value='' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   <%}if (gender.equals("F")){%>
				 <option value='F' selected><fmt:message key="Common.female.label" bundle="${common_labels}"/>
  			   <%}else {%>
					 <option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			  <%}if (gender.equals("M")){%>
					 <option value='M' selected><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			   <%}else {%>
				     <option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>
			   <%}if (gender.equals("U")){%>
					 <option value='U' selected><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			    <%}else {%>
					 <option value='U' ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
			    <%}%>
		      </select>
			  </td> 	
		      <td  width='15%'></td>
	    </tr>	
		<tr>
		   <td colspan='4'></td>
		</tr>
		<tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%' nowrap><fmt:message key="eAE.OpentoAllPracLocation.label" bundle="${ae_labels}"/></td>
		      <td class='filed'  width='45%'><input type='checkbox' name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value='<%=open_to_all_prac_for_clinic_yn%>'  <%=checkBoxAttribute%> <%=disabledField%> onClick='chkValue(this);'> 
              </td>
	          <td  width='15%'></td> 
        </tr>
		<tr>
		   <td colspan='4'></td>
		</tr>
	  
		 <!--Added on 9/2/04 Gomathi Shankar...Adding priority zone -->
		<tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
			  <td class='field'  width='45%'><select name='priority_zone' id='priority_zone'
			  <%=disabledField%>>
			  <option value='' selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
			  <%
			  String AcessSql   = "SELECT five_level_triage_appl_yn FROM AE_PARAM WHERE OPERATING_FACILITY_ID=? ";
			  String five_level_triage_appl_yn	= "N";
			  pstmt=con.prepareStatement(AcessSql);
			  pstmt.setString(1,facilityId);
			  rset=pstmt.executeQuery();
			  while(rset!=null && rset.next()) {
				  five_level_triage_appl_yn	=  (rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");
			  }
			  if(rset!=null)  rset.close();
			  if(pstmt!=null)  pstmt.close();
			  
			  
		
			    sql_1   ="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' ";
				if(!five_level_triage_appl_yn.equals("Y")){
					sql_1	= sql_1 + "  and priority_zone not in ('B','W') ";
				}
				sql_1= sql_1 + " order by PRIORITY_ZONE_ORDER asc"; 
			    
			    pstmt   = con.prepareStatement(sql_1.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				
				while(rset!=null && rset.next())
								 {
							if(priority_zone.equals(rset.getString(1)))
							out.println("<option value='"+rset.getString(1)+"' selected>");	
							else
				            out.println("<option value='"+rset.getString(1)+"'>");	     
							out.println(rset.getString(2));
							out.println("</option>"); 
								 } %>
			 <!--CRF  SKR-CRF-0021 [IN028173] end-->
		
			 
			 
			  <!-- <% 
			  if (priority_zone.equals("")){%>
					<option value='' selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <%}else {%>
					<option value='' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%}if (priority_zone.equals("G")){%>
					 <option value='G' selected><fmt:message key="Common.Green.label" bundle="${common_labels}"/>
			    <%}else {%>
					 <option value='G' ><fmt:message key="Common.Green.label" bundle="${common_labels}"/>
				<%}if (priority_zone.equals("R")){%>
					 <option value='R' selected><fmt:message key="Common.Red.label" bundle="${common_labels}"/>
			    <%}else {%>
					 <option value='R' ><fmt:message key="Common.Red.label" bundle="${common_labels}"/>
			    <%}if (priority_zone.equals("Y")){%>
					 <option value='Y' selected><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/>
  			    <%}else {%>
					 <option value='Y' ><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/>
			    <%}if (priority_zone.equals("U")){%>
					 <option value='U' selected><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/>
			    <%}else {%>
					 <option value='U' ><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/>
			    <%}%>   -->
	
			  </select>
				  <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
		      <td  width='15%'>&nbsp;</td>
	    </tr>		
		<tr>
		   <td colspan='4'></td>
		</tr>	  
	 <!--priority zone field added -->
	     <!--added by lakshmanan for ML-MMOH-1973 on 01-07-2023 start  -->
		<% if(isAppearAsTabEnable) {%>
		<!---- Appears As Tab -->
		<tr> 
		<% if(appearAsTabYN!=null && appearAsTabYN.equals("Y")) { 
				checkBoxAttribute3="CHECKED";
				dispManTabColourGif="style='visibility:visible;'";
		} else {
			disableTabColour="disabled";
			dispManTabColourGif="style='visibility:hidden;'";
		}
			%>
		<td  width='10%'></td>
			<td class='label'  width='30%'><fmt:message key="eAE.AppearAsTab.label" bundle="${ae_labels}"/></td>
		    <td class='field'  width='45%'><input type='checkbox' name='AppearAsTab' id='AppearAsTab' value='<%=appearAsTabYN%>' <%=checkBoxAttribute3%> onClick='chkValue(this);'> 
		<td  width='15%'></td> 
		</tr>
		<!-- Tab Colour --> 
		<tr> 
		<td  width='10%'></td>
		<td class='label'  width='30%'><fmt:message key="eAE.TabColour.label" bundle="${ae_labels}"/></td>
		<td class='field'  width='45%'><select name='Tap_Colour' id='Tap_Colour' <%=disableTabColour%> >
		<% if (tabColour.equals("")){%>
			<option value='' selected>&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;
		<%}else {%>
			<option value=''>&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;
		<%} if (tabColour.equals("PR")){ %>
			<option value='PR' selected ><fmt:message key="eAE.Purple.label" bundle="${ae_labels}"/>
		<%}else {%>	
			<option value='PR'><fmt:message key="eAE.Purple.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("BR")){ %>
			<option value='BR' selected ><fmt:message key="eAE.Brown.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='BR'><fmt:message key="eAE.Brown.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("BL")){ %>
			<option value='BL' selected ><fmt:message key="eAE.Blue.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='BL'><fmt:message key="eAE.Blue.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("DB")){ %>
			<option value='DB' selected ><fmt:message key="eAE.Darkblue.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='DB'><fmt:message key="eAE.Darkblue.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("MG")){ %>
			<option value='MG' selected><fmt:message key="eAE.Magenta.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='MG' ><fmt:message key="eAE.Magenta.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("PK")){ %>
			<option value='PK' selected ><fmt:message key="eAE.Pink.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='PK'><fmt:message key="eAE.Pink.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("CY")){ %>
			<option value='CY' selected ><fmt:message key="eAE.Cyan.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='CY'><fmt:message key="eAE.Cyan.label" bundle="${ae_labels}"/>
		<%} if (tabColour.equals("GY")){ %>
			<option value='GY' selected ><fmt:message key="eAE.Grey.label" bundle="${ae_labels}"/>
		<%}else {%>
			<option value='GY'><fmt:message key="eAE.Grey.label" bundle="${ae_labels}"/>
		<% } %>
		</select> <img src='../../eCommon/images/mandatory.gif' name='disp_man_tab_clr_gif' <%=dispManTabColourGif%> ></img> </td>
		<td  width='15%'></td>
		</tr>
		<% } %>
		<tr>
		   <td colspan='4' height='5'></td>
		</tr>
		<!--added by lakshmanan for ML-MMOH-1973 on 01-07-2023 end  -->
		 <tr>
		      <td  width='10%'></td> 	
		      <td class='label'  width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='45%'><input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>' <%=checkBoxAttribute2%>  onClick='chkValue(this);'>
              </td>
	          <td  width='15%'></td> 
        </tr>
		
	    
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
			 <input type='hidden' name='clinic_code_val' id='clinic_code_val' value='' >	 	
 			 <input type='hidden' name='clinic_code_res' id='clinic_code_res' value="<%=clinic_code%>" >	 	
		 
			 <input type='hidden' name='treatment_area_code_val' id='treatment_area_code_val' value='' >	 	
			 <input type='hidden' name='long_desc_val' id='long_desc_val' value='' >	 	
			 <input type='hidden' name='short_desc_val' id='short_desc_val' value='' >	
			 <input type='hidden' name='priority_zone_val' id='priority_zone_val' value='' > <input type='hidden' name='gender_val' id='gender_val' value='' >								 
		   
		     <input type='hidden' name='open_to_all_prac_for_clinic_yn_val' id='open_to_all_prac_for_clinic_yn_val' value='' >	 	
    		 <input type='hidden' name='triage_yn_val' id='triage_yn_val' value='' >	 	
		     <input type='hidden' name='eff_status_val' id='eff_status_val' value='' >	
			 <input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value='<%=isAppearAsTabEnable%>'>	
		  	 
	 </form>
             
             <%
                if(mode.equals("INSERT"))
					out.println("<script>document.forms[0].eff_status.value='E';</script>");
			 %>
			 
    </body>

<% 
clinic.setLength(0);
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

