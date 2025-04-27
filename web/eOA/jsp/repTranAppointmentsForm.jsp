
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
     
<%@ page contentType="text/html;charset=UTF-8"  import='java.sql.*,webbeans.eCommon.*' %>
<%String p_facility_id		= (String) session.getValue( "facility_id" ) ; %>
<head>
  <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
   -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eOA/js/repTranAppointments.js'></script>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
  <script language='javascript' src="../../eCommon/js/common.js"></script>
   <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
   <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
  	String p_module_id		= "OA" ;
	String p_report_id		= "OABNRTR" ;
	String p_passing_local_date="";
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th"))
	{
		p_passing_local_date="Y";
	}else 
	{
		p_passing_local_date="N";
	}
	Connection con = null;
	ResultSet rs	   		= null;
	Statement stmt1   		= null ;
	ResultSet rs2	   		= null;
	String sql1="";
	request.setCharacterEncoding("UTF-8");
	
try{	
	
con = ConnectionManager.getConnection(request);
stmt1   		= con.createStatement() ;
%>




<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
       <br><br><br><br><!-- <br><br><br><br> -->
<div>
        <table cellpadding='0' cellspacing='0' width='60%' border='0' align='center' >
      
          <tr>
            <td width='30%'>&nbsp;</td>
            <td class='querydata' width='35%' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata' width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr>

          <tr>
             <td  class='label'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input type="text" id='apptdatefrom' name='p_fm_appt_date' id='p_fm_appt_date' value='' size='10' maxlength='10' title='From Appt Date' onblur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdatefrom');"></input><img src='../../eCommon/images/mandatory.gif'></img>
              </td>
              <td class='fields'>
               <input type="text" id='apptdateto' name='p_to_appt_date' id='p_to_appt_date' value='' size='10' maxlength='10' title='To Appt Date' onblur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptdateto');"></input><img src='../../eCommon/images/mandatory.gif'></img>
             </td>
          </tr>

	   <tr><td colspan='4'>&nbsp;</td></tr>

	    <tr>
             <td  class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
             <td class='fields'>
			 <%
					 sql1 = " Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
					  rs2 = stmt1.executeQuery(sql1);
			  %>
					<SELECT name='p_location_type1' id='p_location_type1'  onchange="changeVal(this);"> <!--onChange="javascript:populatePractitioner()"-->
						<option value='' style='align:center'>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;
						<%
						 String locn_type="";
                         String short_desc="";
                         while(rs2.next() && rs2 !=null){
                         locn_type=rs2.getString("care_locn_type_ind");
                         short_desc=rs2.getString("short_desc");
                         out.println("<option value='"+locn_type+"'>"+short_desc);
						}%>

					</SELECT>
              </td>
              <td align='left'>&nbsp;</td>
          </tr>

	   <tr><td colspan='4'>&nbsp;</td></tr>

          <tr>
             <td class='label'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input name='p_fm_locn_code' id='p_fm_locn_code' value='' size='5' maxlength='4' title='From Location' onblur='if(this.value!="")  searchCode1(this, p_fm_locn_code,p_fm_locn)'><input type="hidden" name="p_fm_locn" id="p_fm_locn"><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCode1(this, p_fm_locn_code,p_fm_locn)'>
              </td>
              <td class='fields'>
               <input name='p_to_locn_code' id='p_to_locn_code' value='' size='5' maxlength='4' title='To Location' onblur='if(this.value!="") searchCode1(this, p_to_locn_code,p_to_locn)'><input type="hidden" name="p_to_locn" id="p_to_locn"><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCode1(this, p_to_locn_code,p_to_locn)'>
             </td>
          </tr>

	   <tr><td colspan='4'>&nbsp;</td></tr>

	   <tr>
            <td class='label'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
           
			<TD class='fields' >
					<SELECT name='p_resource_class1' id='p_resource_class1' id='res' onchange='practValidate(this);getResource(this)' onblur='//resourceOnBlur();' >
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
             <td  class='label'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

			 <TD class='fields' id='loc' >
				  <SELECT name='fm_pract_type' id='fm_pract_type' onClick='//checkpract()' onChange='enablepr(this);//validateTbs();'>
				  <OPTION value='' >&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</SELECT></td>

			 <TD class='fields' id='loc' >
				  <SELECT name='to_pract_type' id='to_pract_type' onClick='//checkpract()' onChange='enablepr1(this);'>
				  <OPTION value='' >&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
				  </SELECT></td>
      </tr>

	   <tr><td colspan='4'>&nbsp;</td></tr>

	   <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
	   <jsp:param name ="from_page" value= "reports" />
	   <jsp:param name ="pract_value" value= "" />
	   </jsp:include>

       <tr><td colspan='4'>&nbsp;</td></tr>

       <tr>
             <td  class='label'><fmt:message key="Common.Generate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
             <select name="p_appt_status" id="p_appt_status" onChange ='chng_report_name(this)'>
			 <!--below modifed by Mano against ML-MMOH-CRF-609-->
					<option value='N'> <fmt:message key="eOA.NormalReschedule.label" bundle="${oa_labels}"/> 
					<option value='T'> <fmt:message key="Common.LocationReschedule.label" bundle="${common_labels}"/>
					<!--end of ML-MMOH-CRF-609-->
             </select>

             </td>
			
			 <td></td>
	   </tr>
		
			 <tr><td colspan='4'>&nbsp;</td></tr>

       </tr>
        </table>
     </div>
     <input type='hidden' name='p_report_id' id='p_report_id' value='<%=p_report_id%>'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='<%=p_module_id%>'></input>
	<input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''></input>
	<input type="hidden" name="P_RESOURCE_CLASS" id="P_RESOURCE_CLASS" value=''></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	 <input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
	 <!-- Monday, March 29, 2010 20345 venkat S -->
	 <input type='hidden' name='p_fm_speciality' id='p_fm_speciality' value=''></input>
	 <input type='hidden' name='p_to_speciality' id='p_to_speciality' value=''></input>
  </form>
<%
	if(rs !=null) rs.close();
	if(stmt1 !=null) stmt1.close();
	if(rs2 !=null) rs2.close();
}catch(Exception es){
//out.println(es.toString());
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{

ConnectionManager.returnConnection(con,request);

}

%>
</body><script>document.forms[0].p_fm_appt_date.focus();</script>

</html>

