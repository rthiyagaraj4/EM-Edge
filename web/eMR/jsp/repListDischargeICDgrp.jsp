<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<head>

  <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

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
	function resetValue(){
		document.forms[0].p_fm_diag_grp_code.value="";
		document.forms[0].p_to_diag_grp_code.value="";

  }

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
			document.forms[0].p_to_discharge_date.focus();
			document.forms[0].p_to_discharge_date.select();
		}
	}
}

	</script>

</head>
<%


  Connection con=null;
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
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  String URL = "../../eCommon/jsp/commonToolbar.jsp?";
  String params = request.getQueryString();
  String source = URL + params;
  String call_from=request.getParameter("call_from");
  if(call_from==null) call_from="";
if (call_from.equals("MAIN"))
{
  String p_user_name		= (String) session.getValue( "login_user" ) ;
 con = ConnectionManager.getConnection(request);
 

  String term_set_id="";
  String term_set_desc="";
try 
{
    String p_facility_id		= (String) session.getValue( "facility_id" ) ;

	Boolean renameTermnGrpToDiagGrp = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","RENAME_TERMN_GRP_TO_DIAG_GRP");//Added by Ashwini on 24-Nov-2017 for ML-MMOH-CRF-0986
/*
	String pat_length="";
	stmt = con.createStatement();
	rs=stmt.executeQuery("select patient_id_length from mp_param");
	if (rs!=null&&rs.next())
       pat_length = rs.getString(1);
*/
%>

<body onLoad="FocusFirstElement()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'search_form_Discharge' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br><br><br><br>
      <div>
        <table cellpadding='3' cellspacing='0' width='60%' align='center' >
          <tr>
            <td  class='label' colspan='3'>&nbsp;</td>
           </tr>
          <tr>
           	<td width='20%' class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields'> <select name='p_enc_type' id='p_enc_type'>
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value='O'><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/></option>
					<option value='I'><fmt:message key="Common.Inpatients.label" bundle="${common_labels}"/></option></select>
					</td>
            <td width='20%'class='label'>&nbsp;</td>
		</tr>
<!--31/12/2008 spr-6747 -->
			<tr>
				<td width='20%' class="label"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
				<fmt:message key="Common.Set.label" bundle="${common_labels}"/>
				</td>
				<td class='fields'>
				 <select name='p_diag_set' id='p_diag_set' onchange='resetValue()'>	
				 <option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
				 
			<%
			 stmt = con.createStatement();
	    
		  String sql = " select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ";

	     rs = stmt.executeQuery(sql);
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	term_set_id = rs.getString("term_set_id") ;
	        	term_set_desc=rs.getString("term_set_desc");
	

%>
			<option value='<%= term_set_id %>'><%= term_set_desc %></option>

<%
			  }
		  }
//out.println("<script>alert(\"term_set_id"+term_set_id+"\");</script>");
			%>

			 </select><img src="../../eCommon/images/mandatory.gif"></img>          
             </td>

			</tr>

          	<tr>
            <td class='label'>&nbsp;</td>
            <td class='querydata'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr>
			<tr>
			 <td class='label'>
			 <!--Added by Ashwini on 24-Nov-2017 for ML-MMOH-CRF-0986-->
			 <%if(!renameTermnGrpToDiagGrp){%>
			 <fmt:message key="eMR.TerminologyGroup.label" bundle="${mr_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>
			 <%}else{%>
			 <fmt:message key="eMR.DiagnosisGroupCode.label" bundle="${mr_labels}"/>
			 <%}%>
			 </td>
             <td class='fields'>
               <input name='p_fm_diag_grp_code' id='p_fm_diag_grp_code' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCodeDischarge(this, p_fm_diag_grp_code)'>
              </td>
              <td class='fields'>
               <input name='p_to_diag_grp_code' id='p_to_diag_grp_code' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCodeDischarge(this, p_to_diag_grp_code)'>
             </td>
          </tr>
            <tr>
             <td class='label'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
             <td class='fields'>
               <input type='text' id='birthfrom' name='p_fm_discharge_date' id='p_fm_discharge_date' value='' size='10' maxlength='10' title='From discharge Date' Onblur="if(validDateObj(this,'DMY',localeName))validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/><img src="../../eCommon/images/mandatory.gif"></img>
              </td>
              <td class='fields'>
               <input type='text' id='birthto' name='p_to_discharge_date' id='p_to_discharge_date' value='' size='10' maxlength='10' title='To discharge Date' Onblur="if(validDateObj(this,'DMY',localeName))validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/><img src="../../eCommon/images/mandatory.gif"></img>
             </td>
          </tr>
		    <tr>
            <td class='label' colspan='3'>&nbsp;</td>
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
	
     <input type='hidden' name='p_report_id' id='p_report_id' value='MRBDIGGP'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
	 <input type="hidden" name="CurrentDate" id="CurrentDate"	 value="<%= CurrentDate %>">
	
	 
<%
     } catch(Exception e) 
	{
          //out.println(e.toString());
		  e.printStackTrace();
    }
    finally 
	{
		try
		{
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		}
		catch(Exception e) 
	{
    }
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
  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repListDischargeICDgrp.jsp?call_from=MAIN' scrolling='no' noresize frameborder='0' style='height:83vh;width:100vw'></iframe>
  <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' noresize' frameborder='0' style='height:9vh;width:100vw'></iframe>

<%}%>

