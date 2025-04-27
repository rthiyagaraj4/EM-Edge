<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*" %>  
<%String p_facility_id		= (String) session.getValue( "facility_id" ) ; %>
<head>   
  
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eOA/js/repNoshowsAppointments.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
  <script src="../../eCommon/js/common.js"></script>
  <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
  <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>




</script>
</head>

<%
  	String p_module_id		= "OA" ;
	String p_report_id		= "OABNOSH" ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	
	StringBuffer fm_strt=new StringBuffer("");
	StringBuffer to_strt=new StringBuffer("");
	String isSpltyNurUnitToEnableYNAppl="";
	String currentdate="";	
	Connection con = null;
	ResultSet rs = null;
    Statement stmtlen   = null;
	ResultSet rs1 = null;
	Statement stmt1 = null;
	ResultSet rs2 = null;
	ResultSet rslen=null;
	Statement stmt2 = null;
	String sql1="";
	String p_passing_local_date="";
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th"))
	{
		p_passing_local_date="Y";
	}else 
	{
		p_passing_local_date="N";
	}
	request.setCharacterEncoding("UTF-8");

    try {
		con = ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		stmtlen   = con.createStatement() ;
	stmt2 = con.createStatement();

	stmt1=con.createStatement();
	rs1 = stmt1.executeQuery("Select nvl(ci_period_in_min_for_noshow,0) t ,to_char(sysdate,'dd/mm/yyyy') d from op_param where operating_facility_id='"+p_facility_id+"'");
       String p_ci_period_in_min_for_noshow="";
       if(rs1 != null &&  rs1.next()) {
       
     	p_ci_period_in_min_for_noshow= rs1.getString("t");
		 currentdate = rs1.getString("d");
	}
	if(rs1 !=null) rs1.close();
	if(rs !=null) rs.close();

	int pat_id_len=0;
    rslen=stmtlen.executeQuery("Select Patient_Id_Length from mp_param");
	
	if(rslen !=null && rslen.next())
			
	pat_id_len=rslen.getInt("Patient_Id_Length");


%>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br>
      <div>
        <table cellpadding='0' cellspacing='0' width='60%' align='center' border='0'>
        
          <tr>
            <td width='30%'>&nbsp;</td>
            <td class='querydata' width='30%' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata' width='30%' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr>

          <tr>
             <td class='label'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input type="text" id='apptdatefrom' name='p_fm_appt_date' id='p_fm_appt_date' value='' size='10' maxlength='10' title='From Appt Date' onBlur="DateCompare_from('from',this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');"></input><img src='../../eCommon/images/mandatory.gif'></img>
              </td>
              <td class='fields'>
               <input type="text" id='apptdateto' name='p_to_appt_date' id='p_to_appt_date' value='' size='10' maxlength='10' title='To Appt Date' onBlur="DateCompare_from('To',this);DateCompare_apply(p_fm_appt_date,this)"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');"></input><img src='../../eCommon/images/mandatory.gif'></img>
             </td>
          </tr>

		  <tr><td colspan='3'>&nbsp;</td></tr>

		  <tr>
             <td  class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
             <TD class='fields'>
				 <%
				 sql1 = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
				  rs2 = stmt2.executeQuery(sql1);
				  %>
					<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> 						<option value='' style='align:center'>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
						<%
						 String locn_type="";
                         String short_desc="";
                         while(rs2.next() && rs2 !=null){
                         locn_type=rs2.getString("care_locn_type_ind");
                         short_desc=rs2.getString("short_desc");
                         out.println("<option value='"+locn_type+"'>"+short_desc);
						}
						%>

					</SELECT></td>
              <td class='label'>&nbsp;</td>
          </tr>
						
	   <tr><td colspan='4'>&nbsp;</td></tr>

          <tr>
             <td  class='label'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

             <td class='fields'>
               <input name='p_fm_locn_code' id='p_fm_locn_code' value='' size='5' maxlength='4' title='From Location' onblur='if(this.value !="") searchCode1(this, p_fm_locn_code,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, p_fm_locn_code,p_fm_locn)'>
              </td>
              <td class='fields'>
               <input name='p_to_locn_code' id='p_to_locn_code' value='' size='5' maxlength='4' title='To Location' onblur='if(this.value !="") searchCode1(this, p_to_locn_code,p_to_locn)'><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, p_to_locn_code,p_to_locn)'>
             </td>
          </tr>

	   <tr><td colspan='4'>&nbsp;</td></tr>
	   <!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
	<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_speciality"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality"/>
					</jsp:include>
					</tr>
		<%}else{%>
          <tr>
             <td  class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input name='p_fm_speciality' id='p_fm_speciality' value='' size='5' maxlength='4' title='From speciality Code' onblur='if(this.value !="") searchCode1(this, p_fm_speciality,p_fm_speciality_desc)'><input type="hidden" name="p_fm_speciality_desc" id="p_fm_speciality_desc"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode1(this, p_fm_speciality,p_fm_speciality_desc)'>
              </td>
              <td class='fields'>
               <input name='p_to_speciality' id='p_to_speciality' value='' size='5' maxlength='4' title='To speciality_code' onblur='if(this.value !="") searchCode1(this, p_to_speciality,p_to_speciality_desc)'><input type="hidden" name="p_to_speciality_desc" id="p_to_speciality_desc"><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode1(this, p_to_speciality,p_to_speciality_desc)'>
             </td>
		</tr><%}%>

		<tr><td colspan='4'>&nbsp;</td></tr>

        <tr> 
             <td  class='label'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input name='p_fm_service' id='p_fm_service' value='' size='5' maxlength='4' title='From Service Code' onblur='if(this.value !="") searchCode1(this, p_fm_service,p_fm_service_desc)'><input type="hidden" name="p_fm_service_desc" id="p_fm_service_desc"><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode1(this, p_fm_service,p_fm_service_desc)'>
              </td>
              <td class='fields'>
               <input name='p_to_service' id='p_to_service' value='' size='5' maxlength='4' title='To service code' onblur='if(this.value !="") searchCode1(this, p_to_service,p_to_service_desc)'><input type="hidden" name="p_to_service_desc" id="p_to_service_desc" ><input type='button' name='service' id='service' value='?' class='button' onclick='searchCode1(this, p_to_service,p_to_service_desc)'>
             </td>
        </tr>

		<tr><td colspan='4'>&nbsp;</td></tr>
		
		<tr>
             <td  class='label'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			 <TD class='fields'><SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
				<OPTION value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
                <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				<OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
                </SELECT></td>
             <td align='left'>&nbsp;</td>
       </tr>

	   <tr><td colspan='4'>&nbsp;</td></tr>
        
	   <tr>
             <td class='label'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			
			 <TD class='fields' id='loc' >

				<SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
				<OPTION value='' >&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</SELECT>
            
			<TD class='fields' id='loc' >
			  <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
			  <OPTION value='' >&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;</SELECT>
        </tr>

		<tr><td colspan='4'>&nbsp;</td></tr>

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "reports" />
				<jsp:param name ="pract_value" value= "" />
				</jsp:include>

	   <!-- <tr>
             <td  class='label'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input name='p_fm_pract_id' id='p_fm_pract_id' onblur="onblurcheck(this,p_fm_pract_id)"value='' size='15' maxlength='15' title='From Practitioner Id' disabled><input type='button' name='fm_pract_id' id='fm_pract_id' value='?' class='button'  disabled onclick='callPractSearch(this, p_fm_pract_id)'>
              </td>

              <td class='fields' >
               <input name='p_to_pract_id' id='p_to_pract_id'onblur= "onblurcheck(this,p_to_pract_id)" value='' size='15' maxlength='15' title='To Practitioner Id' disabled><input type='button' name='to_pract_id' id='to_pract_id' value='?' class='button' disabled onclick='callPractSearch(this, p_to_pract_id)'>
              </td>
           </tr> -->

           <tr> <td colspan='4'>&nbsp;</td></tr>

           <tr>
             
             <td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			 <td  class='fields'><input type='text' name='b_patient_id' id='b_patient_id' size='<%=pat_id_len%>' maxlength='<%=pat_id_len%>' onBlur="ChangeUpperCase(this);" ><input type='button' name="search" id="search" value="?" onClick="patqry()" class='button'></td>
			 
            	  
             
             <td class='fields'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>      
				  <select name='sex' id='sex'>
				  <option value=""> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				  <option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				  <option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				  <option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				  </select>
			   </td>
          </tr>

           <tr><td  colspan='4'>&nbsp;</td></tr>

			  <tr>
			  <td class='label'  ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
			 
			  <td class='fields'>
			  <select name='report_type' id='report_type'  >
			  <option value="R"><fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
			  <option value="L"><fmt:message key="eOA.Letter.label" bundle="${oa_labels}"/></option>
			  </select>
			  </td>
			  <td>&nbsp;</td>
			  </tr>
			<!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] Start-->	
				<%
				Boolean isAppointmentThrough	= CommonBean.isSiteSpecific(con, "OA","OA_PORTAL_APP_REPORTS");
				if(isAppointmentThrough){
				
				%>
			 <tr>
				<td  colspan='4'>&nbsp;</td>
			</tr>

			  <tr>
				  <td class='label'  ><fmt:message key="eOA.AppointmentThrough.label" bundle="${oa_labels}"/></td>
				 
				  <td class='fields'>
					 <select name="P_APPT_THROUGH" id="P_APPT_THROUGH">
						<OPTION value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>			
						<OPTION value='O'><fmt:message key="eOA.Online.label" bundle="${oa_labels}"/>
						<OPTION value='H'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/>
					</select>
				  </td>
				  <td>&nbsp;</td>
			  </tr>
			 <%}else{%>
				<input type='hidden' name='P_APPT_THROUGH' id='P_APPT_THROUGH' value='' />
			<%}%>
			  <!--Added By Dharma on Feb 8th 2016 against PMG2016-CRF-MMS-0001 [IN:059014] End-->
        </table>
     </div>
     <input type='hidden' name='p_report_id' id='p_report_id' value='<%=p_report_id%>'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='<%=p_module_id%>'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
     <input type='hidden' name='p_ci_period_in_min_for_noshow' id='p_ci_period_in_min_for_noshow' value='<%=p_ci_period_in_min_for_noshow%>'></input>
	 <input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
	<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

<%
		  if (rs != null) rs.close();
		  if (rs1 != null) rs1.close();
		  if(rs2 !=null)rs2.close();
		  if(rslen !=null)rslen.close();
          if (stmt1 != null) stmt1.close();
		  if (stmtlen !=null) stmtlen.close();
		  if (stmt2 !=null) stmt2.close();
		  fm_strt.setLength(0);
		  to_strt.setLength(0);

     } catch(Exception e) {
      //out.println(e.toString());
      e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165  
     }
     finally {
         
		  ConnectionManager.returnConnection(con,request);

     }
%>
  </form>

</body><script>document.forms[0].p_fm_appt_date.focus();</script>

</html>

