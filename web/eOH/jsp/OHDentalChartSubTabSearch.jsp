<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String locale = (String)session.getAttribute("LOCALE"); 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
<head>
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
   <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

	<script language="javascript">

		function changeTab(objStr){
			var frmObj=document.forms[0];
			if(document.getElementById("tablist").disabled == false){
				selectTab(objStr);
				var param=frmObj.param.value;
			    //written by parul on 26/11/07
				var gs_dflt_tooth_no_Q1 = frmObj.gs_dflt_tooth_no_q1.value;
	            var gs_dflt_tooth_no_Q2 = frmObj.gs_dflt_tooth_no_q2.value;
	            var gs_dflt_tooth_no_Q3 = frmObj.gs_dflt_tooth_no_q3.value;
	            var gs_dflt_tooth_no_Q4 = frmObj.gs_dflt_tooth_no_q4.value;

				var gs_dflt_tooth_no_s1 = frmObj.gs_dflt_tooth_no_s1.value;
	            var gs_dflt_tooth_no_s2 = frmObj.gs_dflt_tooth_no_s2.value;
	            var gs_dflt_tooth_no_s3 = frmObj.gs_dflt_tooth_no_s3.value;
	            var gs_dflt_tooth_no_s4 = frmObj.gs_dflt_tooth_no_s4.value;
	            var gs_dflt_tooth_no_s5 = frmObj.gs_dflt_tooth_no_s5.value;
	            var gs_dflt_tooth_no_s6 = frmObj.gs_dflt_tooth_no_s6.value;

				switch(objStr){
					
					case "SendOut": 
						parent.frames[1].location.href="../../eOH/jsp/OHTrmtSendOut.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "Acknowledge": 
						parent.frames[1].location.href="../../eOH/jsp/OHTrmtAcknowledge.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "Recieve": 
						parent.frames[1].location.href="../../eOH/jsp/OHTrmtRecieveDetails.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;	  
					case "DentalCondition": 
						parent.frames[1].location.href="../../eOH/jsp/DentalCondition.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "ExtTreatment": 
						parent.frames[1].location.href="../../eOH/jsp/DentalExtTreatment.jsp?"+param;
						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						break;
					case "GingivalStatus": 
						//written by parul on 26/11/07 
						parent.frames[1].location.href="../../eOH/jsp/GingivalStatus.jsp?"+param+"&gs_dflt_tooth_no_Q1="+gs_dflt_tooth_no_Q1+"&gs_dflt_tooth_no_Q2="+gs_dflt_tooth_no_Q2+"&gs_dflt_tooth_no_Q3="+gs_dflt_tooth_no_Q3+"&gs_dflt_tooth_no_Q4="+gs_dflt_tooth_no_Q4+"&called_from_viewchart_gingival=Y&gs_dflt_tooth_no_s1="+gs_dflt_tooth_no_s1+"&gs_dflt_tooth_no_s2="+gs_dflt_tooth_no_s2+"&gs_dflt_tooth_no_s3="+gs_dflt_tooth_no_s3+"&gs_dflt_tooth_no_s4="+gs_dflt_tooth_no_s4+"&gs_dflt_tooth_no_s5="+gs_dflt_tooth_no_s5+"&gs_dflt_tooth_no_s6="+gs_dflt_tooth_no_s6;

						parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
						 break;
					//case "PeriodontalSummary": 
							 //written by parul 
					  //  var called_from_tab = "Y";
						//parent.frames[1].location.href="../../eOH/jsp/SummaryMainFrames.jsp?"+param+"&called_from_tab="+called_from_tab;
				        //parent.parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
					//	break;
				}
			}
		}

		function setClinicalCode(){ //Un commented to get assign the oh_clinical_group value to the select box
			/*var formObj = document.forms[0];
			var baseline_chart_yn = formObj.baseline_chart_yn.value;
			var add_new_yn = formObj.add_new_yn.value;
			var clinical_group_hid = formObj.clinical_group_hid.value;

			alert("clinical_group_hid:=="+clinical_group_hid);
			if(baseline_chart_yn != "Y" && clinical_group_hid != "undefined" && clinical_group_hid != undefined && clinical_group_hid != "" && clinical_group_hid != null && clinical_group_hid != "null"){
				//formObj.oh_clinical_group.value = clinical_group_hid;
				if(formObj.oh_clinical_group.value != "" && formObj.oh_clinical_group.value != "null" && formObj.oh_clinical_group.value != null){
					formObj.oh_clinical_group.disabled = "true";
				}
				
			}*/
			
		
			var formObj = document.forms[0];
			var patient_id = formObj.patient_id.value;
			var facility_id = formObj.facility_id.value;
			var baseline_chart_yn = formObj.baseline_chart_yn.value;
			var add_new_yn = formObj.add_new_yn.value;
			var clinical_code = trimString(formObj.clinical_code.value);
				clinical_code = localTrimString(clinical_code);
			if(baseline_chart_yn != "Y" && clinical_code != "undefined" && clinical_code != undefined){
				//formObj.oh_clinical_group.value = clinical_code;
				if(formObj.oh_clinical_group.value != "" && formObj.oh_clinical_group.value != "null" && formObj.oh_clinical_group.value != null){
					formObj.oh_clinical_group.disabled = "true";
				}
				
			}
		
			if(add_new_yn != "Y" && baseline_chart_yn != "Y"){
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "patient_id="+patient_id;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","CommonValidation.jsp?func_mode=onLoadClinicalCode&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				retVal = localTrimString(retVal);
				if(retVal.length>1){
					formObj.oh_clinical_group.value = retVal;
					formObj.clinical_group_hid.value = retVal;
					parent.frames[0].document.forms[0].clinical_group_hid.value = retVal;
					
					formObj.oh_clinical_group.disabled = "true";
				}
			}
		}

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="setClinicalCode();" >
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String db_clinical_group_code = "";
	String disabled="";
	String tab_disabled="";
	String selected="";
	String DC_tab_selected_class = "";
	String ET_tab_selected_class = "";
	String PC_tab_selected_class = "";
	String perio_selected_class = "";

	String DC_span_class = "";
	String ET_span_class = "";
	String PC_span_class = "";
	String perio_span_class = "";
	

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
	String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
	String chart_hdr_insert_yn = checkForNull(request.getParameter( "chart_hdr_insert_yn" )) ;
	String called_from_viewchart_yn = checkForNull(request.getParameter( "called_from_viewchart_yn" )) ;
	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
	String clinical_group_code = checkForNull(request.getParameter( "clinical_group_code" )) ;
	String defaultTab = checkForNull(request.getParameter( "defaultTab" )) ;
	String add_new_yn = checkForNull(request.getParameter( "add_new_yn" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	//String show_new_active_yn = checkForNull(request.getParameter( "show_new_active_yn" )) ;
	String clinical_group_before_refresh = checkForNull(request.getParameter( "clinical_group_before_refresh" )) ;
	//String permanent_deciduous_flag = checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
	//String mixed_dentition_YN        = request.getParameter("mixed_dentition_YN");
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));//added by parul  for other facility chart CRF#0423
	String clinical_code = "";
	if(!clinical_group_before_refresh.equals("")){
		clinical_code = clinical_group_before_refresh;
	}

   	//Added by Sharon Crasta on 1/11/2010 for IN017822
	//Used to disable the chart once the APP-OH000153 message is displayed and on cancel.
	String chart_disable_from_main = checkForNull(request.getParameter( "chart_disable_from_main" )) ;
   	//End
//written by parul on 27/11/07
    String record_gingival_status_yn = checkForNull(request.getParameter( "record_gingival_status_yn" )) ;
    String gs_dflt_tooth_no_q1 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q1" )) ;
    String gs_dflt_tooth_no_q2 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q2" )) ;
    String gs_dflt_tooth_no_q3 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q3" )) ;
	String gs_dflt_tooth_no_q4 = checkForNull(request.getParameter( "gs_dflt_tooth_no_q4" )) ;	 
    String called_from_viewchart_gingival = checkForNull(request.getParameter( "called_from_viewchart_gingival" )) ;

	String gs_dflt_tooth_no_s1 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s1" )) ;
    String gs_dflt_tooth_no_s2 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s2" )) ;
    String gs_dflt_tooth_no_s3 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s3" )) ;
	String gs_dflt_tooth_no_s4 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s4" )) ;
	String gs_dflt_tooth_no_s5 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s5" )) ;
	String gs_dflt_tooth_no_s6 = checkForNull(request.getParameter( "gs_dflt_tooth_no_s6" )) ;	
	//Added by Sharon Crasta on 7/28/2009
	//Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab.
	String called_from_Ext_Trmt = checkForNull(request.getParameter( "called_from_Ext_Trmt" )) ;
	//
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	//End
	
	//Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)
	String chart_type = checkForNull(request.getParameter("chart_type"));
	String called_from_Ging_Sts = checkForNull(request.getParameter("called_from_Ging_Sts"));
	//

	/*
	if(called_from_viewchart_yn.equals("Y")){
		if(defaultTab.equals("DentalCondition")){
			DC_tab_selected_class = "tabClicked";
			ET_tab_selected_class = "tabA";
			PC_tab_selected_class = "tabA";

			DC_span_class = "tabSpanclicked";
			ET_span_class = "tabAspan";
			PC_span_class = "tabAspan";

		}else if(defaultTab.equals("ExtTreatment")){
			DC_tab_selected_class = "tabA";
			ET_tab_selected_class = "tabClicked";
			PC_tab_selected_class = "tabA";

			DC_span_class = "tabAspan";
			ET_span_class = "tabSpanclicked";
			PC_span_class = "tabAspan";
		}
	}
	else{
		out.println(defaultTab);
		defaultTab = "DentalCondition";
		DC_tab_selected_class = "tabClicked";
		ET_tab_selected_class = "tabA";
		PC_tab_selected_class = "tabA";

		DC_span_class = "tabSpanclicked";
		ET_span_class = "tabAspan";
		PC_span_class = "tabAspan";
	}
	*/
	
	//Commented and Added by Sharon Crasta on 7/28/2009
	//Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab.
	//if(defaultTab.equals("ExtTreatment")){
	if(called_from_Ext_Trmt.equals("Y")){
		defaultTab="ExtTreatment";
	//
		DC_tab_selected_class = "tabA";
		ET_tab_selected_class = "tabClicked";
		PC_tab_selected_class = "tabA";
		perio_selected_class = "tabA";

		DC_span_class = "tabAspan";
		ET_span_class = "tabSpanclicked";
		PC_span_class = "tabAspan";
		perio_span_class  = "tabAspan";
	}
	//else if(defaultTab.equals("GingivalStatus")){
	else if(called_from_Ging_Sts.equals("Y")){
		//Added by Sharon Crasta on 7/28/2009
		//Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab.
		defaultTab="GingivalStatus";
		//
		DC_tab_selected_class = "tabA";
		ET_tab_selected_class = "tabA";
		perio_selected_class = "tabA";
		PC_tab_selected_class = "tabClicked";

		DC_span_class = "tabAspan";
		ET_span_class = "tabAspan";
		perio_span_class  = "tabAspan";
		PC_span_class = "tabSpanclicked";
	}
	/*else if(defaultTab.equals("PeriodontalSummary")){
		DC_tab_selected_class = "tabA";
		ET_tab_selected_class = "tabA";
		PC_tab_selected_class = "tabA";
		perio_selected_class = "tabClicked";
		
		DC_span_class = "tabAspan";
		ET_span_class = "tabAspan";
		PC_span_class = "tabAspan";
		perio_span_class  = "tabSpanclicked";
	}*/else {
		defaultTab="DentalCondition";
		DC_tab_selected_class = "tabClicked";
		ET_tab_selected_class = "tabA";
		PC_tab_selected_class = "tabA";
		perio_selected_class = "tabA";

		DC_span_class = "tabSpanclicked";
		ET_span_class = "tabAspan";
		PC_span_class = "tabAspan";
		perio_span_class  = "tabAspan";
	}



	
	try{
		con=ConnectionManager.getConnection(request);
		if(chart_hdr_insert_yn.equals("N") && add_new_yn != "Y"){
			pstmt = con.prepareStatement("SELECT CLINICAL_GROUP_CODE FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_STATUS = 'A'");
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				db_clinical_group_code = checkForNull(rs.getString("CLINICAL_GROUP_CODE"));
				//out.println("309 db_clinical_group_code:=="+db_clinical_group_code);
			}
		}

		//out.println("db_clinical_group_code:=="+db_clinical_group_code);
		//out.println("facility_id:=="+facility_id);
		//out.println("patient_id:=="+patient_id);
		//out.println("add_new_yn:=="+add_new_yn);
		//out.println("chart_hdr_insert_yn:=="+chart_hdr_insert_yn);

		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)	
		 if(chart_type.equals("RA")){
			 if(oh_chart_level.equals("E")){
				//written by parul on 26/11/07
				//if(record_gingival_status_yn.equals("Y")){
                pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,GS_DFLT_TOOTH_NO_Q1,GS_DFLT_TOOTH_NO_Q2,GS_DFLT_TOOTH_NO_Q3,GS_DFLT_TOOTH_NO_Q4, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
               // pstmt.setString(1,facility_id);
			 }else{	//End
			 	pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,GS_DFLT_TOOTH_NO_Q1,GS_DFLT_TOOTH_NO_Q2,GS_DFLT_TOOTH_NO_Q3,GS_DFLT_TOOTH_NO_Q4, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
                pstmt.setString(1,facility_id);
			 }
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				record_gingival_status_yn = checkForNull(rs.getString("RECORD_GINGIVAL_STATUS_YN"));
				if(record_gingival_status_yn.equals("Y")){
					gs_dflt_tooth_no_q1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q1"));
					gs_dflt_tooth_no_q2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q2"));
					gs_dflt_tooth_no_q3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q3"));
					gs_dflt_tooth_no_q4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_Q4"));

					gs_dflt_tooth_no_s1 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S1"));
					gs_dflt_tooth_no_s2 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S2"));
					gs_dflt_tooth_no_s3 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S3"));
					gs_dflt_tooth_no_s4 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S4"));
					gs_dflt_tooth_no_s5 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S5"));
					gs_dflt_tooth_no_s6 = checkForNull(rs.getString("GS_DFLT_TOOTH_NO_S6"));
				}
		   }
		}
		//Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)
		else if(chart_type.equals("RD")){
			if(oh_chart_level.equals("E")){
				//written by parul on 26/11/07
				//if(record_gingival_status_yn.equals("Y")){
                pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,DEC_GS_DFLT_TOOTH_NO_Q1,DEC_GS_DFLT_TOOTH_NO_Q2,DEC_GS_DFLT_TOOTH_NO_Q3,DEC_GS_DFLT_TOOTH_NO_Q4, DEC_GS_DFLT_TOOTH_NO_S1, DEC_GS_DFLT_TOOTH_NO_S2, DEC_GS_DFLT_TOOTH_NO_S3, DEC_GS_DFLT_TOOTH_NO_S4, DEC_GS_DFLT_TOOTH_NO_S5, DEC_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
               // pstmt.setString(1,facility_id);
			 }else{	//End
			 	pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,DEC_GS_DFLT_TOOTH_NO_Q1,DEC_GS_DFLT_TOOTH_NO_Q2,DEC_GS_DFLT_TOOTH_NO_Q3,DEC_GS_DFLT_TOOTH_NO_Q4, DEC_GS_DFLT_TOOTH_NO_S1, DEC_GS_DFLT_TOOTH_NO_S2, DEC_GS_DFLT_TOOTH_NO_S3, DEC_GS_DFLT_TOOTH_NO_S4, DEC_GS_DFLT_TOOTH_NO_S5, DEC_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
                pstmt.setString(1,facility_id);
			 }
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				record_gingival_status_yn = checkForNull(rs.getString("RECORD_GINGIVAL_STATUS_YN"));
				if(record_gingival_status_yn.equals("Y")){
					gs_dflt_tooth_no_q1 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q1"));
					gs_dflt_tooth_no_q2 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q2"));
					gs_dflt_tooth_no_q3 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q3"));
					gs_dflt_tooth_no_q4 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_Q4"));

					gs_dflt_tooth_no_s1 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S1"));
					gs_dflt_tooth_no_s2 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S2"));
					gs_dflt_tooth_no_s3 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S3"));
					gs_dflt_tooth_no_s4 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S4"));
					gs_dflt_tooth_no_s5 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S5"));
					gs_dflt_tooth_no_s6 = checkForNull(rs.getString("DEC_GS_DFLT_TOOTH_NO_S6"));
				}
		   }		
		}
		else{
			if(oh_chart_level.equals("E")){
				//written by parul on 26/11/07
				//if(record_gingival_status_yn.equals("Y")){
                pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,MD_GS_DFLT_TOOTH_NO_Q1,MD_GS_DFLT_TOOTH_NO_Q2,MD_GS_DFLT_TOOTH_NO_Q3,MD_GS_DFLT_TOOTH_NO_Q4, MD_GS_DFLT_TOOTH_NO_S1, MD_GS_DFLT_TOOTH_NO_S2, MD_GS_DFLT_TOOTH_NO_S3, MD_GS_DFLT_TOOTH_NO_S4, MD_GS_DFLT_TOOTH_NO_S5, MD_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM");
               // pstmt.setString(1,facility_id);
			 }else{	//End
			 	pstmt = con.prepareStatement("SELECT RECORD_GINGIVAL_STATUS_YN,MD_GS_DFLT_TOOTH_NO_Q1,MD_GS_DFLT_TOOTH_NO_Q2,MD_GS_DFLT_TOOTH_NO_Q3,MD_GS_DFLT_TOOTH_NO_Q4, MD_GS_DFLT_TOOTH_NO_S1, MD_GS_DFLT_TOOTH_NO_S2, MD_GS_DFLT_TOOTH_NO_S3, MD_GS_DFLT_TOOTH_NO_S4, MD_GS_DFLT_TOOTH_NO_S5, MD_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
                pstmt.setString(1,facility_id);
			 }
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				record_gingival_status_yn = checkForNull(rs.getString("RECORD_GINGIVAL_STATUS_YN"));
				if(record_gingival_status_yn.equals("Y")){
					gs_dflt_tooth_no_q1 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q1"));
					gs_dflt_tooth_no_q2 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q2"));
					gs_dflt_tooth_no_q3 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q3"));
					gs_dflt_tooth_no_q4 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_Q4"));

					gs_dflt_tooth_no_s1 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S1"));
					gs_dflt_tooth_no_s2 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S2"));
					gs_dflt_tooth_no_s3 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S3"));
					gs_dflt_tooth_no_s4 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S4"));
					gs_dflt_tooth_no_s5 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S5"));
					gs_dflt_tooth_no_s6 = checkForNull(rs.getString("MD_GS_DFLT_TOOTH_NO_S6"));
				}
		   }		
		}
		//End
		//}
		
		//Commented and Added by Sharon Crasta on 1/11/2010 for IN017822
		//Added chart_disable_from_main as "Y" in order to disable the chart on click of Cancel button of APP-OH000153 message
		//if(called_from_viewchart_yn.equals("Y") || other_facilitychart_yn.equals("Y")){

			//out.println("called_from_viewchart_yn:=="+called_from_viewchart_yn);
			//out.println("other_facilitychart_yn:=="+other_facilitychart_yn);
			//out.println("chart_disable_from_main:=="+chart_disable_from_main);

		if(called_from_viewchart_yn.equals("Y") || other_facilitychart_yn.equals("Y") || chart_disable_from_main.equals("Y")){//End
			disabled = "disabled";
			selected = "selected";
			tab_disabled = "disabled";
			db_clinical_group_code = clinical_group_code;
		}

		if(date_diff_flag.equals("disable")){
			tab_disabled = "disabled";
			disabled = "disabled";
		}
	
%>
<form name="OHSubTabForm" id="OHSubTabForm">

<table id="tab" cellspacing=0 cellpadding=3 border="0" width='93%'>
<tr>
	<td width= "100%" class="white">
		<ul id="tablist" class="tablist" <%=tab_disabled%>>
			<li class="tablistitem" title='DentalCondition' >
				<a  class="<%=DC_tab_selected_class%>"  onclick="changeTab('DentalCondition');" id="DentalCondition"> 
					<span class="<%=DC_span_class%>" id="DentalConditionspan"><fmt:message key="eOH.DentalCondition.Label" bundle="${oh_labels}"/></span>
				</a>
			</li>
			
			 <li class="tablistitem" title='ExtTreatment' >
				<a  class="<%=ET_tab_selected_class%>"  onclick="changeTab('ExtTreatment');" id="ExtTreatment"> 
					<span class="<%=ET_span_class%>" id="ExtTreatmentspan"><fmt:message key="eOH.ExternalTreatment.Label" bundle="${oh_labels}"/></span>
				</a>
			</li>
			    <%
				 //commented by parul on 7/13/2009 for CRF 0456 & 0457 ( ability to record ?Gingival Status? in restorative chart for patient at all age)
                   //  if(record_gingival_status_yn.equals("Y") && (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")) ){
                    if(record_gingival_status_yn.equals("Y")){
                     
				 %>
			          <li class="tablistitem" title='GingivalStatus'>
				          <a  class="<%=PC_tab_selected_class%>"  onclick="changeTab('GingivalStatus');" id="GingivalStatus" >
					       <span class="<%=PC_span_class%>" id="GingivalStatusspan"><fmt:message key="eOH.GingivalStatus.Label" bundle="${oh_labels}"/></span>
				        </a>
			          </li>
			   <%
			   }

			  %>
				<!-- written by parul  -->
			
				<!--  <li class="tablistitem" title='PeriodontalSummary' >
				<a  class="<%=perio_selected_class%>"  onclick="changeTab('PeriodontalSummary');" id="PeriodontalSummary"> 
					<span class="<%=perio_span_class%>" id="PeriodontalSummaryspan"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></span>
				</a>
			</li> -->
			
			<!-- <li class="tablistitem" title='sendOut' >
				<a  class="<%=ET_tab_selected_class%>"  onclick="changeTab('SendOut');" id="SendOut"> 
					<span class="<%=ET_span_class%>" id="SendOutspan">SendOut</span>
				</a>
			</li>
			<li class="tablistitem" title='Acknowledge' >
				<a  class="<%=ET_tab_selected_class%>"  onclick="changeTab('Acknowledge');" id="Acknowledge"> 
					<span class="<%=ET_span_class%>" id="Acknowledgespan">Acknowledge</span>
				</a>
			</li>
			<li class="tablistitem" title='Recieve' >
				<a  class="<%=ET_tab_selected_class%>"  onclick="changeTab('Recieve');" id="Recieve"> 
					<span class="<%=ET_span_class%>" id="Recievespan">Acknowledge</span>
				</a>
			</li> -->
			
			
             
		</ul>
		
	</td>
	

	<td class="label" nowrap width="25%"><fmt:message key="eOH.ClinicalGroup.Label" bundle="${oh_labels}"/></td>
	<td align="right">
		<select name = "oh_clinical_group" value ="" <%=disabled%>>
			<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				pstmt=con.prepareStatement("SELECT CLINICAL_GROUP_CODE, CLINICAL_GROUP_DESC FROM OH_CLINICAL_GROUP_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(EFF_STATUS,'E') = 'E' ORDER BY 2");
				pstmt.setString(1,locale);
				rs=pstmt.executeQuery();
				while(rs.next()){
					selected="";
					if(db_clinical_group_code.equals(rs.getString("CLINICAL_GROUP_CODE")))
						selected = "selected";
			%>
					<option <%=selected%> value='<%=rs.getString("CLINICAL_GROUP_CODE")%>'><%=rs.getString("CLINICAL_GROUP_DESC")%></option>
			<%
				}
			%>
		</select>
	</td>
</tr>
	

</table>
<input type="hidden" name="param" id="param" value="<%=request.getQueryString()%>">
<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
<input type = "hidden" name= "facility_id" value = "<%=facility_id%>"> 
<input type = "hidden" name= "clinical_group_hid" value = "<%=db_clinical_group_code%>"> 
<input type = "hidden" name= "called_from_viewchart_yn" value = "<%=called_from_viewchart_yn%>"> 
<input type = "hidden" name= "params" value = "<%=params%>"> 
<input type = "hidden" name= "add_new_yn" value = "<%=add_new_yn%>"> 
<input type = "hidden" name= "baseline_chart_yn" value = "<%=baseline_chart_yn%>">
<input type = "hidden" name= "clinical_code" value = "<%=clinical_code%>">


<!-- written by parul on 26/11/07 -->
<input type="hidden" name="gs_dflt_tooth_no_q1" id="gs_dflt_tooth_no_q1" value="<%=gs_dflt_tooth_no_q1%>">
<input type="hidden" name="gs_dflt_tooth_no_q2" id="gs_dflt_tooth_no_q2" value="<%=gs_dflt_tooth_no_q2 %>">
<input type="hidden" name="gs_dflt_tooth_no_q3" id="gs_dflt_tooth_no_q3" value="<%=gs_dflt_tooth_no_q3%>">
<input type="hidden" name="gs_dflt_tooth_no_q4" id="gs_dflt_tooth_no_q4" value="<%=gs_dflt_tooth_no_q4%>">

<!-- added by sridevi for Sextant -->
<input type="hidden" name="gs_dflt_tooth_no_s1" id="gs_dflt_tooth_no_s1" value="<%=gs_dflt_tooth_no_s1%>">
<input type="hidden" name="gs_dflt_tooth_no_s2" id="gs_dflt_tooth_no_s2" value="<%=gs_dflt_tooth_no_s2 %>">
<input type="hidden" name="gs_dflt_tooth_no_s3" id="gs_dflt_tooth_no_s3" value="<%=gs_dflt_tooth_no_s3%>">
<input type="hidden" name="gs_dflt_tooth_no_s4" id="gs_dflt_tooth_no_s4" value="<%=gs_dflt_tooth_no_s4%>">
<input type="hidden" name="gs_dflt_tooth_no_s5" id="gs_dflt_tooth_no_s5" value="<%=gs_dflt_tooth_no_s5%>">
<input type="hidden" name="gs_dflt_tooth_no_s6" id="gs_dflt_tooth_no_s6" value="<%=gs_dflt_tooth_no_s6%>">

<!--Added by Sharon Crasta on 7/28/2009 -->
<!--Added to display the Respective Tab on which the recordings have made rather than the Dental Condition tab as the default tab -->
<input type="hidden" name="called_from_Ext_Trmt" id="called_from_Ext_Trmt" value="<%=called_from_Ext_Trmt%>">
<!--Added by Sharon Crasta on 8/11/2009 for IN009739(SRR20056-CRF-0457)-->
<input type="hidden" name="chart_type" id="chart_type" value="<%=chart_type%>">
<!-- -->

<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->
<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
<input type="hidden" name="called_from_viewchart_gingival" id="called_from_viewchart_gingival" value="<%=called_from_viewchart_gingival%>">
<!-- -->	
</form>

	<script>
		parent.frames[0].document.forms[0].clinical_group_hid.value = "<%=db_clinical_group_code%>";
	</script>

	<!-- The below line is required to change the select state of Initial tab selected -->
	<script>
		prevTabObj='<%=defaultTab%>';
	</script>
	
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>





