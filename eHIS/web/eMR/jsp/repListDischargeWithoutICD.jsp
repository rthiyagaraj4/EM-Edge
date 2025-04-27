<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>
<head>
  <%String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script src="../../eCommon/js/common.js" language="javascript"></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language='javascript' src="../../eMR/js/MRReports.js"></script>
      <script src="../../eCommon/js/DateUtils.js"></script>
	  <script>
	 function disablefields(){
	document.forms[0].p_fm_loc_code.disabled=true;
	document.forms[0].locn.disabled=true;
	document.forms[0].p_to_loc_code.disabled=true;
	document.forms[0].locn1.disabled=true;
  }
	  </script>
</head>

<%
  request.setCharacterEncoding("UTF-8");
  String URL = "../../eCommon/jsp/commonToolbar.jsp?";
  String params = request.getQueryString();
  String source = URL + params;
  String call_from=request.getParameter("call_from");
 if(call_from==null) call_from="";
if (call_from.equals("MAIN"))
{
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs   = null;
  Statement stmt = null;
try {
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;

/*
	String pat_length="";
	stmt = con.createStatement();
	rs=stmt.executeQuery("select patient_id_length from mp_param");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);
*/
%>

<body onLoad="FocusFirstElement();disablefields()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form_repDischarge' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br><br><br><br>
      <div>
        <table cellpadding='3' cellspacing='0' width='60%' align='center' >
          <tr class='label'>
            <td class='label' colspan='3'>&nbsp;</td>
           </tr>
          <tr>							
          <td width='20%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
          <td width='20%' class='fields'>
        <SELECT name='p_enc_type' id='p_enc_type' onchange='disableLocationTypeMRBDSWDG(this)' >
        <option value='B' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/> </option>
        <option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
        <option value='OP'><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/> </option>
        </SELECT></td>
        <td width='20%'class='label'>&nbsp;</td>
        </tr>
     <tr>
	   <td align ='left' class = "label" id="loc_type_legend"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	   <td id="loc_type_name" align ='left' colspan='2'>
	   <SELECT name="p_location_type" id="p_location_type" onChange='clearDetail1(this);' >
	   <option value="">------Select-----</option>
	   <option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
	   <option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
	            </SELECT>
	 </td>
     </tr>
   	  <tr>
            <td align='left' class='label'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
             <td align='left'>
               <input name='p_fm_loc_code' id='p_fm_loc_code' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepDischarge(this, p_fm_loc_code)'>
              </td>
              <td align='left'>
               <input name='p_to_loc_code' id='p_to_loc_code' value='' size='5' maxlength='4' ><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCoderepDischarge(this, p_to_loc_code)'>
             </td>
         </tr>
	   <tr>
            <td class='querydata' width='20%'>&nbsp;</td>
            <td class='querydata' width='20%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata' width='20%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr>
			 <tr>
             <td class='label'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input type='text' id='birthfrom' name='p_fm_discharge_date' id='p_fm_discharge_date' value='' size='10' maxlength='10' title='From discharge Date' Onblur="validDateObj(this,'DMY','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/><img src="../../eCommon/images/mandatory.gif"></img>
              </td>
              <td class='fields'>
               <input type='text' id='birthto' name='p_to_discharge_date' id='p_to_discharge_date' value='' size='10' maxlength='10' title='To discharge Date' Onblur="validDateObj(this,'DMY','<%=localeName%>')"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/><img src="../../eCommon/images/mandatory.gif"></img>
             </td>
          </tr>
			 <!--<tr>
             <td class='label'><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input name='p_fm_nursing_unit_code' id='p_fm_nursing_unit_code' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepDischarge(this, p_fm_nursing_unit_code)'>
              </td>
              <td class='fields'>
               <input name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepDischarge(this, p_to_nursing_unit_code)'>
             </td>
          </tr>
          <tr class='label'>
            <td class='label' colspan='3'>&nbsp;</td>
          </tr>-->
	   </table>
     </div>
	 	 	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBDSWDG'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
<%
     } catch(Exception e) { /*  out.println(e.toString()); */ e.printStackTrace();  }
     finally {
		 try
		 {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		 }
		 catch(Exception e) {     }
		  ConnectionManager.returnConnection(con,request);

     }
%>
  </form>
</body>

</html>
<%}
else
{
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repListDischargeWithoutICD.jsp?call_from=MAIN' scrolling='no' noresize frameborder='0' style='height:83vh;width:100vw'></iframe>
  <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize' frameborder='0' style='height:9vh;width:100vw'></iframe>

<%}%>

