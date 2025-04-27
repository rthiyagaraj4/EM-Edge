<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eOT.*, eOT.Common.*,java.util.HashMap,java.util.ArrayList,eCommon.Common.CommonBean" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,webbeans.eCommon.ConnectionManager,java.net.URLDecoder" %>
<html>
<head>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<title></title>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eOT/js/Slate.js"></script>
<script>
	var operationsProcedures_value=getLabel("eOT.OperationsProcedures.Label","OT");
	var reason_value=getLabel("Common.reason.label","common");
	var ctxPath = "<%=request.getContextPath()%>"; //Modified against 50878
</script>
</head>
<%
	Connection conn=null;
	PreparedStatement pstmt_locn_room_bed=null;
	PreparedStatement pstmt1=null;
	ResultSet rs_locn_room_bed=null;
	ResultSet rst1=null;
	String facilityid  = (String) session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE"); 
	String tab_name = (String)session.getAttribute("tab_name"); //Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03
	String auto_schdl_yn = "" ; //Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03
	String surgeon_code_all = "" ; //Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
	PreparedStatement pstmt2 = null;
	ResultSet rst2 = null;
	String Disp_Image="";
	String patient_id = "";
	String calledFrom = ""; //IN052054
try{
		conn = ConnectionManager.getConnection(request);
		
		//Added by Gaurav Against ML-MMOH-CRF-1791-US03...starts
		
		String sql_2 = "SELECT AUTO_SCHDL_TO_NXTDAY_YN FROM OT_PARAM_FOR_FACILITY ";
		
		pstmt2 = conn.prepareStatement(sql_2);
		rst2=pstmt2.executeQuery();
		if(rst2 !=null && rst2.next())
		{			
			auto_schdl_yn = rst2.getString("AUTO_SCHDL_TO_NXTDAY_YN");			
		}
		//Added by Gaurav Against ML-MMOH-CRF-1791-US03...ends
		
		String oper_date_hmap="",surgery_date="",more_Less_result_Flag="";
		
		 //Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
		 pstmt2 = conn.prepareStatement("SELECT * from PR_HIGH_RISK_CONDITION where PATIENT_ID=? AND CLOSE_DATE IS NULL") ;
		
		String sql="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";        
		pstmt1 = conn.prepareStatement(sql) ;
		rst1 = pstmt1.executeQuery();
		while(rst1.next()){
		surgery_date=com.ehis.util.DateUtils.convertDate(rst1.getString("CURRENT_DATE"),"DMY","en",locale);
		}

	more_Less_result_Flag	=	request.getParameter("more_Less_result_Flag");
	calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");//IN052054
	if(more_Less_result_Flag==null || more_Less_result_Flag.equals("null") || more_Less_result_Flag.equals(""))
	more_Less_result_Flag = "N";
	String room_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels") ;
	String bed_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels") ;

	String view_by = request.getParameter("view_by");
	request.setCharacterEncoding("UTF-8");
	String login_user	= (String)session.getValue("login_user");
	String user_role = request.getParameter("user_role");
	String bill_flag = request.getParameter("bill_flag");
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap all_scheduled_case_details = bean.getUnScheduledCases();
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="SlateSchSearchResultForm" id="SlateSchSearchResultForm">
 <table class='grid' border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
 	<%if(view_by.equals("A")){%>
	<tr id="slate_results_table_row1">
			<td class="columnHeader"  colspan="11">
			<fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img id="img_src_res" src='../../eOT/images/gripper1.gif' onclick='extractResultUnschFrame()'>
			</td>
			
	</tr>
	<%}else{%>
<tr id="slate_results_table_row1">
			<td class="columnHeader"  colspan="11">
			<fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/>
			</td>
	</tr>
<%}%>
<tr></tr>
 <tr id="slate_unsch_results_table_row1">
						<td class='columnHeader' ></td>
	<td class='columnHeader' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="eOT.AsaScore.Label" bundle="${ot_labels}"/></td> <!-- CRF-0021-->
	<td class='columnHeader' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class='columnHeader' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
</tr>		
 <%
	String classvalue="", oper_num="",order_status_unsch_text = "",room_bed_no="",curr_locn="",roomNo="",bed_no="",color_ind = "",text_color = "",encounter_id="",current_locn="",asa_score_code=""; // Added asa_score_code crf-0021
	/*Added by Suma for showing the location details wrt CRF SRR20056-CRF-0311-OT*/

			String sql_locn_room_bed = "select OT_PAT_CURR_LOCATION (?,?,?,?,?) from dual";

			pstmt_locn_room_bed=conn.prepareStatement(sql_locn_room_bed);

	/*ends here*/

	HashMap scheduled_case_details=new HashMap();
	int size = all_scheduled_case_details.size();

	for (int i=1;i<=size;i++){
		classvalue = (i%2==0)?"gridData":"gridData";// modified by Sathish for Amazon changes on 07-02-2009
		scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");
		oper_num	= (String)scheduled_case_details.get("oper_num");
		encounter_id	= (String)scheduled_case_details.get("encounter_id");
		color_ind	= (String)scheduled_case_details.get("color_ind");
		text_color	= (String)scheduled_case_details.get("text_color");
		asa_score_code	= (String)scheduled_case_details.get("asa_score_code"); // crf - 0021

				 pstmt_locn_room_bed.setString(1,facilityid);
				 pstmt_locn_room_bed.setString(2,encounter_id);
				 pstmt_locn_room_bed.setString(3,"");
				 pstmt_locn_room_bed.setString(4,"");
				 pstmt_locn_room_bed.setString(5,locale);

				rs_locn_room_bed = pstmt_locn_room_bed.executeQuery();
				if( rs_locn_room_bed.next())
				{
					current_locn=rs_locn_room_bed.getString(1);
					if(current_locn ==null) current_locn="";
				}

		if( current_locn !="")
		{
			int counter=0;
			StringTokenizer strToken1=new StringTokenizer(current_locn,"$$");
			 counter=strToken1.countTokens();
				
			if(strToken1.hasMoreTokens()){
					 if(counter <=1)
					{
						 curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo="";
						 bed_no="";
					}else if(counter <=2)
					{
						 curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						  if(roomNo.equals("^")) roomNo="";
						  bed_no="";
					}else
					{
						curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						 if(roomNo.equals("^")) roomNo="";
						 bed_no=strToken1.nextToken();
						 if(bed_no.equals("^")) bed_no="";
					}
		}
		
				room_bed_no=room_no_legend+" : "+roomNo+" "+bed_no_legend+" : "+bed_no; 
	}
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 starts here
	patient_id = (String)scheduled_case_details.get("patient_id");
	pstmt2.setString(1,patient_id);
		rst2 = pstmt2.executeQuery();
		if(rst2.next()){
			Disp_Image ="../../eOT/images/High_risk.gif";
				}
		else{
			Disp_Image ="../../eOT/images/drugInfo.gif";
				}
    //Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 ends here
				
	%>
		<tr >
		<!--<td style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
			<img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(indicatorToolTipUnSchCases('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"; onmouseout='UnTip();'>
		</td>-->
		<!--Modified by lakshmi against high risk image CRF-->
		<td style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" onmouseover="Tip(indicatorToolTipUnSchCases('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"; onmouseout='UnTip();'>
			<img src='<%=Disp_Image%>'>
		</td>
			<input type="hidden" name="order_status_text_<%=i%>" id="order_status_text_<%=i%>" value="<%=order_status_unsch_text%>">
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=com.ehis.util.DateUtils.convertDate((String )scheduled_case_details.get("oper_date"),"DMY","en",locale)%>
			</td>
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=scheduled_case_details.get("patient_id")%>
			</td>
			<%
			oper_date_hmap=com.ehis.util.DateUtils.convertDate((String )scheduled_case_details.get("oper_date"),"DMY","en",locale);
			boolean flag=com.ehis.util.DateUtils.isBefore(oper_date_hmap,surgery_date,"DMY",locale);
			if(flag)
			{
%>
			<td   id='orderctl<%=i%>' onClick="displayToolTip('<%=i%>',this,'SLATE',this,'imgArrow<%=i%>','<%=encounter_id%>','<%=current_locn%>');" style='cursor:pointer' class='gridDataBlue' onMouseOver="hidemenu();" ><!-- hideToolTip(this,'imgArrow<%=i%>','<%=i%>'); -->
					 <%=scheduled_case_details.get("patient_name")%>
<%
					//IN052054 start
					if(calledFrom != null && !calledFrom.equals("CA"))
					{
%>
						<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>
<%
					}
					//IN052054 end
%>
				</td>
<%
			}
			else
			{
%>
			<td class="gridDataBlue" style='cursor:pointer'  >
				<%=(String)scheduled_case_details.get("patient_name")%>
		   </td>
<%
			}
%>

			<td   class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=scheduled_case_details.get("oper_room_desc")%>
				<!-- ML-BRU-SCF-1054 by MuthuN -->
			</td>
				
				<td  class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" onMouseOver="Tip(reasonToolTip('<%=i%>','un_scheduled_cases'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"  onMouseOut='UnTip();'>
					<img src='../../eOT/images/drugInfo.gif'  >
					<%=checkForNull((String)scheduled_case_details.get("oper_desc"))%>
			
			</td>
			<!-- Added New CRF-0021		-->
				<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				 <%=checkForNull((String)scheduled_case_details.get("asa_score_code"))%> 
				
				</td>
		    <!-- end  -->
			
			
			<td   class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=checkForNull((String)scheduled_case_details.get("speciality_desc"))%>
			</td>
			<%
				String surgeon_name=checkForNull((String)scheduled_case_details.get("surgeon_name"));
				if(surgeon_name.equals("")){
			%>
			<td  class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >All Surgeons
				
			</td>
			<%}else{%>
			<td  class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=checkForNull((String)scheduled_case_details.get("surgeon_name"))%>
			</td>
			<%}%>
			
		
			<td  class="gridDataBlue"   style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="Tip(reasonToolTip3('reason','<%=i%>','un_sch_case'),JUMPHORZ,true)" onMouseOut="UnTip();">
			<img src='../../eOT/images/drugInfo.gif' >
			<%=checkForNull((String)scheduled_case_details.get("status_desc"))%>
			</td>
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%if(!current_locn.equals(curr_locn+"$$^$$^")) {%><img src='../../eOT/images/drugInfo.gif' onmouseover="Tip(reasonStatusToolTip('<%=room_bed_no%>'),JUMPHORZ,true)"  onmouseout="UnTip();"><%}%><%=curr_locn%>
			</td>
			<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=scheduled_case_details.get("patient_id")%>" >
			
			<input type="hidden" name="patient_name_<%=i%>" id="patient_name_<%=i%>" value="<%=scheduled_case_details.get("patient_name")%>" >
			
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value="<%=scheduled_case_details.get("order_id")%>" >

			<input type="hidden" name="oper_code_<%=i%>" id="oper_code_<%=i%>" value="<%=scheduled_case_details.get("oper_code")%>">
			<input type="hidden" name="speciality_code_<%=i%>" id="speciality_code_<%=i%>" value="<%=scheduled_case_details.get("speciality_code")%>">
			<input type="hidden" name="speciality_desc_<%=i%>" id="speciality_desc_<%=i%>" value="<%=scheduled_case_details.get("speciality_desc")%>">
			<input type="hidden" name="surgeon_code_<%=i%>" id="surgeon_code_<%=i%>" value="<%=scheduled_case_details.get("surgeon_code")%>">
			<input type="hidden" name="surgeon_desc_<%=i%>" id="surgeon_desc_<%=i%>" value="<%=scheduled_case_details.get("surgeon_name")%>">
			<input type="hidden" name="oper_status_<%=i%>" id="oper_status_<%=i%>" value="<%=scheduled_case_details.get("oper_status")%>">
			<input type="hidden" name="oper_num_<%=i%>" id="oper_num_<%=i%>" value="<%=scheduled_case_details.get("oper_num")%>">
			<input type="hidden" name="asa_score_code_<%=i%>" id="asa_score_code_<%=i%>" value="<%=scheduled_case_details.get("asa_score_code")%>"> <!-- crf-0021 -->
			<input type="hidden" name="appt_ref_num_<%=i%>" id="appt_ref_num_<%=i%>" value="">
			<input type="hidden" name="waitlist_num_<%=i%>" id="waitlist_num_<%=i%>" value="">
			<input type="hidden" name="nursing_doc_comp_yn_<%=i%>" id="nursing_doc_comp_yn_<%=i%>" value="<%=scheduled_case_details.get("nursing_doc_comp_yn")%>">
			<input type="hidden" name="surgeon_doc_comp_yn_<%=i%>" id="surgeon_doc_comp_yn_<%=i%>" value="<%=scheduled_case_details.get("surgeon_doc_comp_yn")%>">
					<!-- Added by Suma for 12329 incident no -->
					
			<input type="hidden" name="proc_chrg_cmp_yn_<%=i%>" id="proc_chrg_cmp_yn_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("proc_chrg_cmp_yn"))%>"> 
			<input type="hidden" name="implant_entry_cmp_yn_<%=i%>" id="implant_entry_cmp_yn_<%=i%>" value="<%=scheduled_case_details.get("implant_entry_cmp_yn")%>">
			<input type="hidden" name="consumable_entry_cmp_yn_<%=i%>" id="consumable_entry_cmp_yn_<%=i%>" value="<%=scheduled_case_details.get("consumable_entry_cmp_yn")%>">
			<input type="hidden" name="equipment_entry_cmp_yn_<%=i%>" id="equipment_entry_cmp_yn_<%=i%>" value="<%=scheduled_case_details.get("equipment_entry_cmp_yn")%>">
			<input type="hidden" name="instrument_entry_cmp_yn_<%=i%>" id="instrument_entry_cmp_yn_<%=i%>" value="<%=scheduled_case_details.get("instrument_entry_cmp_yn")%>">
			<input type="hidden" name="anaesthesia_doc_comp_yn_<%=i%>" id="anaesthesia_doc_comp_yn_<%=i%>" value="<%=scheduled_case_details.get("anaesthesia_doc_comp_yn")%>" >	
				<%
				// no appt_ref_num for unscheduled cases
				%>
		</tr>
	<%
		}// }
	%>

	</table>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=(String)session.getValue("facility_id")%>">
	<input type="hidden" name="menu_id" id="menu_id" value="<%=request.getParameter("menu_id")%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="user_role" id="user_role" value="<%=user_role%>">
	<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
	<input type="hidden" name="function_id_list" id="function_id_list" value="">
	<input type="hidden" name="function_name_list" id="function_name_list" value="">
	<input type="hidden" name="url_desc_list" id="url_desc_list" value="">
	<input type="hidden" name="sch_unsch_flag" id="sch_unsch_flag" value="UNSCHEDULED">
	<input type="hidden" name="bill_flag" id="bill_flag" value="<%=bill_flag%>">
	<input type="hidden" name="search_page_view_by" id="search_page_view_by" value="<%=view_by%>">
	<input type="hidden" name="more_Less_result_Flag" id="more_Less_result_Flag" value="<%=more_Less_result_Flag%>">
	<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
	<input type="hidden" name="calledFrom" id="calledFrom" value="<%=calledFrom%>" > <%-- IN052054 --%>
	<input type="hidden" name="tab_name" id="tab_name" value="<%=tab_name%>" ><!--Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03--> 
	<input type="hidden" name="auto_schdl_yn" id="auto_schdl_yn" value="<%=auto_schdl_yn%>" ><!--Added by Gaurav Agaisnt ML-MMOH-CRF-1791-US03-->

</form>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	</div>
	<div name='tooltiplayer3' id='tooltiplayer3' style='position:absolute; width:36%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer2' id='tooltiplayer2' style='position:absolute; width:50%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding="0" cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
<script language="javascript">
// any script code
</script>
<%
//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012	    
        if(rst2 != null) rst2.close();
		if(pstmt2 != null) pstmt2.close();
				}catch(Exception e){
			out.println(e);
		}finally{
		if(rs_locn_room_bed!=null) rs_locn_room_bed.close();
		if(pstmt_locn_room_bed!=null)pstmt_locn_room_bed.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
	}
%>

