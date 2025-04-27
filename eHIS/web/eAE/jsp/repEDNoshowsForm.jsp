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
  <script language='javascript' src='../../eAE/js/repEDNoshows.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
  <script src="../../eCommon/js/common.js"></script>
  <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

  <script>




</script>
</head>

<%
  	String p_module_id		= "AE" ;
	String p_report_id		= "AENSAPPT" ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	StringBuffer fm_strt=new StringBuffer("");
	StringBuffer to_strt=new StringBuffer("");
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
String isSpltyNurUnitToEnableYNAppl="";
    try {
		con = ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 25th-OCT-2018 for ML-MMOH-CRF-1115.1
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
	  <td class='label'><fmt:message key="Common.AppointmentDate.label" bundle="${common_labels}"/></td>
	  <td class='fields'>
         <input type="text" id='apptdatefrom' name='p_fm_appt_date' id='p_fm_appt_date' value='' size='10' maxlength='10' title='From Appt Date' onBlur="DateCompare_from('from',this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');"></input><img src='../../eCommon/images/mandatory.gif'></img>
      </td>
	  <td class='fields'>
         <input type="text" id='apptdateto' name='p_to_appt_date' id='p_to_appt_date' value='' size='10' maxlength='10' title='To Appt Date' onBlur="DateCompare_from('To',this);DateCompare_apply(p_fm_appt_date,this)"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');"></input><img src='../../eCommon/images/mandatory.gif'></img>
      </td>
      </tr>
	  <tr><td colspan='3'>&nbsp;</td></tr>
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
             
             <td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			 <td  class='fields'><input type='text' name='p_patient_id' id='p_patient_id' size='<%=pat_id_len%>' maxlength='<%=pat_id_len%>' onBlur="ChangeUpperCase(this);" ><input type='button' name="search" id="search" value="?" onClick="patqry()" class='button'></td>
			 
            	  
             
             <td class='fields'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>      
				  <select name='p_gender' id='p_gender'>
				  <option value=""> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
				  <option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				  <option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				  <option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				  </select>
			   </td>
          </tr>
		  </table>
		  </div>
		  <input type='hidden' name='p_report_id' id='p_report_id' value='<%=p_report_id%>'></input>
		  <input type='hidden' name='p_module_id' id='p_module_id' value='<%=p_module_id%>'></input>
		  <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
		  <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
		  <input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'></input>
		  <input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		  <input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
		  
		  
		  
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
	  e.printStackTrace();
      //out.println(e.toString());
         
     }
     finally {
         
		  ConnectionManager.returnConnection(con,request);

     }
%>
  </form>
 </body><script>document.forms[0].p_fm_appt_date.focus();</script> 
  </html>
		  

