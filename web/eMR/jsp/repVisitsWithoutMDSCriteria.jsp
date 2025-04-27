<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<head>
<%
String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ page import ="java.util.*" %>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js" language="javascript"></script>
 <script src="../../eCommon/js/DateUtils.js"></script>
 <script src="../../eCommon/js/CommonCalendar.js"></script>
   <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script> 
  <script>
	 function disablefieldsForMDS(){
	document.forms[0].p_fr_locn_code.disabled=true;
	document.forms[0].locn.disabled=true;
	document.forms[0].p_to_locn_code.disabled=true;
	document.forms[0].locn1.disabled=true;
  }
  /*function disableDiagnosisSet(){
	  document.forms[0].p_diag_set.disabled=true;
  }*/
function _enableDiagnosisSet(obj){

	if(obj.value!='')
	{
		//document.forms[0].p_diag_set.disabled=false;
		document.getElementById("p_mds_lbl").style.visibility='visible';
		document.getElementById("p_mds_type1").style.visibility='visible';
	}
	else
	{
		//document.forms[0].p_diag_set.disabled=true;
		document.getElementById("p_mds_lbl").style.visibility='hidden';
		document.getElementById("p_mds_type1").style.visibility='hidden';
		//document.forms[0].p_diag_set.value="";
	}

}


/*function validate_date(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.encounterdate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

*/

   function ComparePeriodFromToTime(from,to)
    {
	
    var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}

	if(greg_frdt != "" && greg_tdt !="")
	{


		if(greg_tdt < greg_frdt)
		{
		
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].p_to_vst_date.focus();
			document.forms[0].p_to_vst_date.select();
		}
	}
}

//july 13 2010
function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }

	  </script>
</head>
<%
  Connection con =null;
  ResultSet rs   = null;
  Statement stmt = null;
%>
<%
		
     String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
     String CurrentDate=" ";
	try{
		 con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
		

	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<%
  request.setCharacterEncoding("UTF-8");
  String p_user_name		= (String) session.getValue( "login_user" ) ;
 con = ConnectionManager.getConnection(request);

try {
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;


	String mds_code="";
	String mds_shrt_desc="";
	stmt = con.createStatement();
	rs=stmt.executeQuery("select mds_code,short_desc from mr_mds where eff_status = 'E' order by short_desc");
	if (rs!=null&&rs.next())
       mds_code = rs.getString("mds_code");
       mds_shrt_desc = rs.getString("short_desc");

%>

<body onLoad="FocusFirstElement();disableLocnTypes();"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form_repVisitWthotMDS' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br><br><br><br>
      <div>
        <table cellpadding='3' cellspacing='0' width='60%' align='center' >
          <tr class='label'>
            <td class='label' colspan='3'>&nbsp;</td>
           </tr>
     <tr>
	   <td align ='right' class = "label" id="loc_type_legend"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	   <td id="loc_type_name" align ='left' colspan='2'>
	   <select name='p_patient_class' id='p_patient_class' onChange='clearDetailForMDS(this);'>
		<option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</option>
			<%	rs = stmt.executeQuery(" select PATIENT_CLASS, short_desc from am_patient_class where PATIENT_CLASS <> 'XT' order by 1")  ;
			if(rs != null)
			{									
			while (rs.next())
			{	%>
				<option value='<%=rs.getString("PATIENT_CLASS")%>'><%=rs.getString("short_desc")%></option>
			<%	
			}
			}
			if(rs != null) rs.close();
			%>
		</select>
	 </td>
     </tr>
	 	   <tr>
            <td class='querydata' width='20%'>&nbsp;</td>
            <td class='querydata' width='20%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata' width='20%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr>

   	  <tr>
            <td align='right' class='label'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
             <td align='left'>
               <input name='p_fr_locn_code' id='p_fr_locn_code' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepVisitWthotMDS(this, p_fr_locn_code)'>
              </td>
              <td align='left'>
               <input name='p_to_locn_code' id='p_to_locn_code' value='' size='5' maxlength='4' ><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCoderepVisitWthotMDS(this, p_to_locn_code)'>
             </td>
			 
         </tr>
			 <tr>
             <td align='right' class='label'><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input type='text' id='birthfrom' name='p_fr_vst_date1' id='p_fr_vst_date1' value='' size='10' maxlength='10' title='From Encounter Date' Onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/><img src="../../eCommon/images/mandatory.gif"></img>
              </td>
              <td class='fields'>
               <input type='text' id='birthto' name='p_to_vst_date1' id='p_to_vst_date1' value='' size='10' maxlength='10' title='To Encounter Date' Onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/><img src="../../eCommon/images/mandatory.gif"></img>
             </td>
          </tr>
     <tr>
	   <td align ='right' class = "label" id="mds_type_legend"><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
	   <td id="p_mds_typeimg" align ='left' colspan='2'>
	   <SELECT name="p_mds_type" id="p_mds_type" onChange='_enableDiagnosisSet(this)' >
	  <option value="" >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	   <option value="<%=mds_code%>"><%=mds_shrt_desc%> </option>
	   </SELECT>
	 </td>
     </tr>

	  <tr>
	   <td align ='right' class = "label" id="p_mds_lbl" style='visibility:hidden'><fmt:message key="Common.diagnosis.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${mr_labels}"/></td>
	   <td id="p_mds_type1" align ='left' colspan='2' style='visibility:hidden'>
	   <SELECT name="p_diag_set" id="p_diag_set"  >
	   <option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
	  

	  <%
		  if(stmt!=null)stmt=null;
	       if(rs!=null) rs=null;
		   stmt = con.createStatement();
		   rs = stmt.executeQuery("select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ");

			if(rs != null)
			{									
			while (rs.next())
			{	%>
				<option value='<%=rs.getString("term_set_id")%>'><%=rs.getString("term_set_desc")%></option>
			<%	
			}
			}
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			%>	   
	   </SELECT><img src='../../eCommon/images/mandatory.gif'  style="visibility">
	 </td>
     </tr>

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
	
     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBVWMDS'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	 <input type="hidden" name="CurrentDate" id="CurrentDate"	 value="<%= CurrentDate %>">
	 <input type="hidden" name="p_to_vst_date" id="p_to_vst_date">
	 <input type="hidden" name="p_fr_vst_date" id="p_fr_vst_date">
	
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

