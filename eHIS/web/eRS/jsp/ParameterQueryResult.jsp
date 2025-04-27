<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	29th Dec 2004
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.URLEncoder,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/Parameter.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	try{

        boolean searched = request.getParameter( "searched" ) == null? false : true;
	
		//Common parameters.
		HashMap sqlMap = new HashMap();
		//include all the common parameters.
		//String SelectSql="select a.facility_id, nvl (b.facility_name, 'Enterprise') fac_name, a.overlap_shifts_in_workplace_yn, a.work_cycle_basis, a.period_for_work_schedule_gen, a.max_continuous_work_duration,a.staff_subs_same_grade_yn, a.staff_subs_high_to_low_yn, a.staff_subs_low_to_high_yn, a.attendance_feature_reqd_yn, a.max_durn_to_mark_attendance, a.vald_staff_acc_by_work_sch_yn,a.vald_staff_acc_by_att_yn, a.curr_shift_allocation_yn, a.curr_shift_change_yn, a.curr_shift_cancellation_yn, a.curr_shift_transfer_yn, a.curr_shift_swap_yn, a.curr_shift_overtime_yn, a.curr_shift_leave_yn,a.durn_for_allocation_from_sos, a.durn_for_change_from_sos, a.durn_for_transfer_from_sos, a.durn_for_swap_from_sos, a.durn_for_overtime_from_sos,  a.durn_for_leave_from_sos,a.durn_for_cancel_from_sos from rs_parameter a, sm_facility_param b WHERE b.facility_id(+) = a.facility_id order by fac_name";
		String SelectSql="select a.facility_id, nvl (b.facility_name, 'Enterprise') fac_name, a.overlap_shifts_in_workplace_yn, a.work_cycle_basis, a.period_for_work_schedule_gen, a.max_continuous_work_duration,a.staff_subs_same_grade_yn, a.staff_subs_high_to_low_yn, a.staff_subs_low_to_high_yn, a.attendance_feature_reqd_yn, a.max_durn_to_mark_attendance, a.vald_staff_acc_by_work_sch_yn,a.vald_staff_acc_by_att_yn, a.curr_shift_allocation_yn, a.curr_shift_change_yn, a.curr_shift_cancellation_yn, a.curr_shift_transfer_yn, a.curr_shift_swap_yn, a.curr_shift_overtime_yn, a.curr_shift_leave_yn,a.durn_for_allocation_from_sos, a.durn_for_change_from_sos, a.durn_for_transfer_from_sos, a.durn_for_swap_from_sos, a.durn_for_overtime_from_sos,  a.durn_for_leave_from_sos,a.durn_for_cancel_from_sos from rs_parameter a, sm_facility_param_lang_vw b WHERE b.facility_id(+) = a.facility_id and b.language_id(+) = ? ";

		String facility_id="";
		String facility_name="";
		String overlap_shifts_in_workplace_yn="";
		String work_cycle_basis="";
		String period_for_work_schedule_gen="";
		String max_continuous_work_duration="";
		String staff_subs_same_grade_yn="";
		String staff_subs_high_to_low_yn="";
		String staff_subs_low_to_high_yn="";
		String attendance_feature_reqd_yn="";
		String max_durn_to_mark_attendance="";
		String vald_staff_acc_by_work_sch_yn="";
		String vald_staff_acc_by_att_yn="";
		String curr_shift_allocation_yn="";
		String curr_shift_change_yn="";
		String curr_shift_cancellation_yn="";
		String curr_shift_transfer_yn="";
		String curr_shift_swap_yn="";
		String curr_shift_overtime_yn="";
		String curr_shift_leave_yn="";
		String durn_for_allocation_from_sos="";
		String durn_for_change_from_sos="";
		String durn_for_transfer_from_sos="";
		String durn_for_swap_from_sos="";
		String durn_for_overtime_from_sos="";
		String durn_for_leave_from_sos="";
		String durn_for_cancel_from_sos="";

		sqlMap.put( "sqlData",SelectSql);

		//The fields are going to be display.
		ArrayList displayFields = new ArrayList();
		displayFields.add("facility_id" );
		displayFields.add("fac_name");
		displayFields.add("overlap_shifts_in_workplace_yn");
		displayFields.add("work_cycle_basis");
		displayFields.add("period_for_work_schedule_gen");
		displayFields.add("max_continuous_work_duration");
		displayFields.add("staff_subs_same_grade_yn");
		displayFields.add("staff_subs_high_to_low_yn");
		displayFields.add("staff_subs_low_to_high_yn");
		displayFields.add("attendance_feature_reqd_yn");
		displayFields.add("max_durn_to_mark_attendance");
		displayFields.add("vald_staff_acc_by_work_sch_yn");
		displayFields.add("vald_staff_acc_by_att_yn");
		displayFields.add("curr_shift_allocation_yn");
		displayFields.add("curr_shift_change_yn");
		displayFields.add("curr_shift_cancellation_yn");
		displayFields.add("curr_shift_transfer_yn");
		displayFields.add("curr_shift_swap_yn");
		displayFields.add("curr_shift_overtime_yn");
		displayFields.add("curr_shift_leave_yn");
		displayFields.add("durn_for_allocation_from_sos");
		displayFields.add("durn_for_change_from_sos");
		displayFields.add("durn_for_transfer_from_sos");
		displayFields.add("durn_for_swap_from_sos");
		displayFields.add("durn_for_overtime_from_sos");
		displayFields.add("durn_for_leave_from_sos");
		displayFields.add("durn_for_cancel_from_sos");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add( locale);	

		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){	
%>
			<table cellpadding=0 cellspacing=0 width="98%" align="center">
				<tr>
					<td width="80%" class="white">&nbsp;</td>
					<td width="20%" class="white">&nbsp;
<%
					// For display the previous/next link
					out.println(result.get(1));
%>
					</td>
				</tr>
			</table>
			<table cellpadding=0 cellspacing=0 border=1 width='98%' align="center">
			<tr>
				<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
			</tr>
<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				 records=(ArrayList) result.get( recCount );

				facility_id=(String)records.get(0)==null?"":(String)records.get(0);
				facility_name=(String)records.get(1)==null?"":(String)records.get(1);
				overlap_shifts_in_workplace_yn=(String)records.get(2)==null?"":(String)records.get(2);
				work_cycle_basis=(String)records.get(3)==null?"":(String)records.get(3);
				period_for_work_schedule_gen=(String)records.get(4)==null?"":(String)records.get(4);
				max_continuous_work_duration=(String)records.get(5)==null?"":(String)records.get(5);
				staff_subs_same_grade_yn=(String)records.get(6)==null?"":(String)records.get(6);
				staff_subs_high_to_low_yn=(String)records.get(7)==null?"":(String)records.get(7);
				staff_subs_low_to_high_yn=(String)records.get(8)==null?"":(String)records.get(8);
				attendance_feature_reqd_yn=(String)records.get(9)==null?"":(String)records.get(9);
				max_durn_to_mark_attendance=(String)records.get(10)==null?"":(String)records.get(10);
				vald_staff_acc_by_work_sch_yn=(String)records.get(11)==null?"":(String)records.get(11);
				vald_staff_acc_by_att_yn=(String)records.get(12)==null?"":(String)records.get(12);
				curr_shift_allocation_yn=(String)records.get(13)==null?"":(String)records.get(13);
				curr_shift_change_yn=(String)records.get(14)==null?"":(String)records.get(14);
				curr_shift_cancellation_yn=(String)records.get(15)==null?"":(String)records.get(15);
				curr_shift_transfer_yn=(String)records.get(16)==null?"":(String)records.get(16);
				curr_shift_swap_yn=(String)records.get(17)==null?"":(String)records.get(17);
				curr_shift_overtime_yn=(String)records.get(18)==null?"":(String)records.get(18);
				curr_shift_leave_yn=(String)records.get(19)==null?"":(String)records.get(19);
				durn_for_allocation_from_sos=(String)records.get(20)==null?"":(String)records.get(20);
				durn_for_change_from_sos=(String)records.get(21)==null?"":(String)records.get(21);
				durn_for_transfer_from_sos=(String)records.get(22)==null?"":(String)records.get(22);
				durn_for_swap_from_sos=(String)records.get(23)==null?"":(String)records.get(23);
				durn_for_overtime_from_sos=(String)records.get(24)==null?"":(String)records.get(24);
				durn_for_leave_from_sos=(String)records.get(25)==null?"":(String)records.get(25);
				durn_for_cancel_from_sos=(String)records.get(26)==null?"":(String)records.get(26);

				out.println("<tr><td class='" + classvalue + "' align='left'><a	 href='../../eRS/jsp/ParameterAddModify.jsp?mode=2&facility_id="+facility_id+"&facility_name="+URLEncoder.encode(facility_name,"UTF-8")+"&overlap_shifts_in_workplace_yn="+overlap_shifts_in_workplace_yn+"&work_cycle_basis="+work_cycle_basis+"&period_for_work_schedule_gen="+period_for_work_schedule_gen+"&max_continuous_work_duration="+max_continuous_work_duration+"&staff_subs_same_grade_yn="+staff_subs_same_grade_yn+"&staff_subs_high_to_low_yn="+staff_subs_high_to_low_yn+"&staff_subs_low_to_high_yn="+staff_subs_low_to_high_yn+"&attendance_feature_reqd_yn="+attendance_feature_reqd_yn+"&max_durn_to_mark_attendance="+max_durn_to_mark_attendance+"&vald_staff_acc_by_work_sch_yn="+vald_staff_acc_by_work_sch_yn+"&vald_staff_acc_by_att_yn="+vald_staff_acc_by_att_yn+"&curr_shift_allocation_yn="+curr_shift_allocation_yn+"&curr_shift_change_yn="+curr_shift_change_yn+"&curr_shift_cancellation_yn="+curr_shift_cancellation_yn+"&curr_shift_transfer_yn="+curr_shift_transfer_yn+"&curr_shift_swap_yn="+curr_shift_swap_yn+"&curr_shift_overtime_yn="+curr_shift_overtime_yn+"&curr_shift_leave_yn="+curr_shift_leave_yn+"&durn_for_allocation_from_sos="+durn_for_allocation_from_sos+"&durn_for_change_from_sos="+durn_for_change_from_sos+"&durn_for_transfer_from_sos="+durn_for_transfer_from_sos+"&durn_for_swap_from_sos="+durn_for_swap_from_sos+"&durn_for_overtime_from_sos="+durn_for_overtime_from_sos+"&durn_for_leave_from_sos="+durn_for_leave_from_sos+"&durn_for_cancel_from_sos="+durn_for_cancel_from_sos+"'>");
				out.println("<font class='HYPERLINK'>"+facility_name +"</font></a></td></tr>");

			}//Loop for all records
%>
			</table>
<%
			out.flush();
			} else{
%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
			</script>
<%
		}
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/ParameterQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
%>
</body>
</html>

