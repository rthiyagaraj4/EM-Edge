<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
        Connection con               = null;
    	PreparedStatement pstmt	     = null;
        ResultSet rset               = null;
		request.setCharacterEncoding("UTF-8");
		String locale				= (String)session.getAttribute("LOCALE");
		String 	facility_id			 = (String) session.getValue("facility_id");	
		String 	lastVisit24HrFlag 	 = request.getParameter("lastVisit24HrFlag");
		String func_source           = request.getParameter("func_source");
        func_source 		         = (func_source == null)?"":func_source;
		session.putValue("queryString",func_source);
		
		String 	patient_id 		     = request.getParameter("patient_id");
		String  visit_adm_date_time  = "";
		String  nature               = "";
		String  location             = "";
		String  practitioner         = "";
		String  dispositionType      = "";
		String  service              = "";
		String  patient_class        = "";
		
		/*Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652*/
		Boolean isDiagDtlsSectionAppl	= false;
		String class_val				= "QRYEVENSCROLL";
		String encounter_id				= "";
		String term_set_desc			= "";
		String term_code				= "";
		String term_code_short_desc		= "";
		String recorded_date_time		= "";
		String accuracy_short_desc		= "";
		String status					= "";
		String diag_nature				= "";
		String calledFrom			 	= checkForNull(request.getParameter("calledFrom"));
		String curr_encounter_id	 	= checkForNull(request.getParameter("curr_encounter_id"));
		String strIgnoreOpenEnc			= "";
		if(!("").equals(curr_encounter_id)){
			strIgnoreOpenEnc			= " and ENCOUNTER_ID!='"+curr_encounter_id+"'";
		}
		/*End ML-MMOH-CRF-0652*/

      	try{
                con   = ConnectionManager.getConnection(request);

				isDiagDtlsSectionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","DIAGNOSIS_DTLS_IN_24HRS_VISIT"); //Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652

/********* For Last Visit WithIn 24Hrs.  *********/
   if(lastVisit24HrFlag!=null)
		{
		  if(lastVisit24HrFlag.equals("Y"))
			{	
			  
				pstmt  = con.prepareStatement("SELECT a.encounter_id, a.patient_class, TO_CHAR (a.queue_date, 'dd/mm/yyyy hh24:mi') visit_adm_date_time, a.disposition_type, am_get_desc.am_service (a.service_code, '"+locale+"', 1) service_desc, am_get_desc.am_subservice (a.service_code, a.subservice_code, '"+locale+"', 1 ) subservice_desc, am_get_desc.am_practitioner (a.practitioner_id, '"+locale+"', 1 ) attend_practitioner_name, am_get_desc.am_contact_reason (a.contact_reason_code, '"+locale+"', 1 ) contact_reason, am_get_desc.am_disposition_type (a.disposition_type, '"+locale+"', 1 ) disposition_type_name, op_get_desc.op_clinic (a.facility_id, a.locn_code, '"+locale+"', 1 ) clinic_desc FROM op_patient_queue a WHERE a.facility_id = ? AND a.patient_id = ? AND queue_status != '99' AND TO_CHAR (a.queue_date, 'dd/mm/yyyy hh24:mi') = (SELECT MAX (TO_CHAR (queue_date, 'dd/mm/yyyy hh24:mi')) FROM op_patient_queue WHERE facility_id = ? AND patient_id = ? AND queue_status != '99' "+strIgnoreOpenEnc+")");
				 pstmt.setString(1, facility_id);
				 pstmt.setString(2, patient_id);
				 pstmt.setString(3, facility_id);
				 pstmt.setString(4, patient_id);
				 rset = pstmt.executeQuery();
					if( rset != null ) 
					{
						while( rset.next() ) 
						{
							visit_adm_date_time  =  checkForNull(rset.getString("visit_adm_date_time"));
							patient_class               =  checkForNull(rset.getString("PATIENT_CLASS"));
							location             =  checkForNull(rset.getString("clinic_desc"));
							practitioner         =  checkForNull(rset.getString("attend_practitioner_name"));
							dispositionType      =  checkForNull(rset.getString("disposition_type_name"));
							service              =  checkForNull(rset.getString("service_desc"));
							encounter_id         =  checkForNull(rset.getString("encounter_id"));
						}
					}
					if(pstmt!=null) pstmt.close();
					if(rset!=null) rset.close();
					if(patient_class.equals("EM"))
				    {
                      nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
					}
                    else if(patient_class.equals("OP"))
				    {
                      nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
					}
					visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);

					

		}
      }%>
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

  <script language='javascript'>
			function closing()
			{
				parent.window.close();
			}
  </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<!--Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652-->
	<style>
	.container {
		width:760px;
	}

	.container table {
		width: 750px;
		table-layout: fixed;
	}

	.inner_table_site { 
		width:100%; 
		height: 100px;
		overflow-y: auto;
	}
	</style>
	<!--End ML-MMOH-CRF-0652-->

  </head>
	 <body onKeyDown = 'lockKey()'>
	 <form name="ae_last_visit_form" id="ae_last_visit_form">
	 <br><br>
	   <table border="0" cellpadding="3" cellspacing="0" align='center' width='90%'>
	     <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
	     </tr>
		 <tr>
				 <td class='label' width='25%' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
				 <td class='QUERYDATA' width='25%'><%=visit_adm_date_time%>
				 </td>
				 <td class='label' width='25%' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
				 <td class='QUERYDATA' width='25%'><%=nature%>
				 </td>
		 </tr>
		 <tr>
				 <td class='label' width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				 <td class='QUERYDATA' width='25%'><%=location%>
				 </td>
				 <td class='label' width='25%' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				 <td class='QUERYDATA' width='25%'><%=practitioner%>
				 </td>
		 </tr>
         <tr><td colspan=4 class=label height=5>&nbsp;</td></tr>
		 <tr>
		    <td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	     </tr>
         <tr><td colspan=4 class=label height=5>&nbsp;</td></tr>

         <tr>
				 <td class='label' width='25%' ><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></td>
				 <td class='QUERYDATA' width='25%'><%=dispositionType%>
				 </td>
				 <td class='label' width='25%' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				 <td class='QUERYDATA' width='25%'><%=service%>
				 </td>
		 </tr>
         <tr><td colspan=4 class=label height=5>&nbsp;</td></tr>

		 <!--Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652-->
		<%
		 JSONArray diagDtlsArrJSON		= new JSONArray();
		 diagDtlsArrJSON				= eAE.AECommonBean.getDiagnosisDtls(con,locale,patient_id,encounter_id,facility_id);

		if(isDiagDtlsSectionAppl && (diagDtlsArrJSON.size() > 0) && ("SecondaryTriage").equals(calledFrom)){%>

		</table>

		<table border="0" cellpadding="3" cellspacing="0" align='center' width='90%'>

		<tr>
		<td colspan=4 class=label height=5>

		<div class="container">
		<table  border="1" width="100%" cellpadding='3' style='border-spacing:0px;border-collapse: collapse;'>

		<tr>
		    <td class='COLUMNHEADER' colspan='4'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	     </tr>

		 <tr></tr><tr></tr><tr></tr>

		 </table>

		 <div class="container">
		 <table  border="1" width="100%" cellpadding='3' style='border-spacing:0px;border-collapse: collapse;'>

         <tr>
			<td width='15%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Set.label" bundle="${common_labels}"/></td>
			<td width='30%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td width='25%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.and.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td width='10%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
			<td width='10%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td width='10%' class="columnheadercenter" align='center' nowrap><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td> 
		 </tr>
		 
		 </table>

		 <div class="inner_table_site">

		 <table  class="head" width="100%"  border="1" cellpadding='3' style='border-spacing:0px;border-collapse: collapse;'>

		 <%
			if(class_val.equals("QRYEVENSCROLL"))
				class_val = "QRYEVENSCROLL";
			else
				class_val = "QRYODDSCROLL";

			for(int i=0 ; i < diagDtlsArrJSON.size(); i++)
			{
				JSONObject json		 = (JSONObject)diagDtlsArrJSON.get(i);
				term_set_desc		 = (String) json.get("term_set_desc");
				term_code			 = (String) json.get("term_code");
				term_code_short_desc = (String) json.get("term_code_short_desc");
				recorded_date_time	 = (String) json.get("recorded_date_time");
				accuracy_short_desc	 = (String) json.get("accuracy_short_desc");
				status				 = (String) json.get("status");
				diag_nature			 = (String) json.get("nature");

			%>
			<tr>
				<td width='15%'  class='<%=class_val%>'><%=term_set_desc%>&nbsp;</td>
				<td width='30%'  class='<%=class_val%>'><%=term_code%>&nbsp;-&nbsp;<%=term_code_short_desc%>&nbsp;</td>
				<td width='25%'  class='<%=class_val%>'><%=recorded_date_time%>&nbsp;</td>
				<td width='10%'  class='<%=class_val%>'><%=accuracy_short_desc%>&nbsp;</td>
				<td width='10%'  class='<%=class_val%>'><%=status%>&nbsp;</td>
				<td width='10%'  class='<%=class_val%>'><%=diag_nature%>&nbsp;</td>
			</tr>
			<% } %>

		 </table>
		 </div>
		 </div>
		 </div>
		 </td>
		 </tr>

		 <tr><td colspan=4 class=label height=5>&nbsp;</td></tr>

		<%}%>
		<!--End ML-MMOH-CRF-0652-->

	     <tr>
				<td class='BUTTON' width='25%' colspan='4'>
						<input type="button" name="close" id="close" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="closing();"  class="Button">
				</td>
		</tr>
   	   </table> 
      </form>
	 </body>
  </html>
<%
    }
    catch(Exception e)
    {
       // out.print(e.toString());
		e.printStackTrace();
    }
    finally
    {
	    ConnectionManager.returnConnection(con,request);
    }
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

