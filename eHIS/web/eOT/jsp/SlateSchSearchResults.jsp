<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page import ="eOT.SlateBean,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<% request.setCharacterEncoding("UTF-8"); %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,webbeans.eCommon.ConnectionManager,java.net.URLDecoder,java.lang.Object" %>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <html>
	<head>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eOT/js/Slate.js"></script>
		<script>
			var operationsProcedures_value=getLabel("eOT.OperationsProcedures.Label","OT");
			var reason_value=getLabel("Common.reason.label","common");
			var ctxPath = "<%=request.getContextPath()%>"; //Modified against 50878
			function clickDrugInfo()
			{
				return true;
			}
//Added by MuthuN against CRF-268 Starts Here 

function hideToolTip(){
  document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

function localTrimString(sInString) {
	  return sInString.replace(/[\[\]']+/g,"");
}
function  reasonToolTip1(rownum,patient_id,appt_ref_num,appt_date){
	var formObj = document.SlateSchSearchResultForm;
	var facilityid=formObj.facilityid.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=pick_list_slate_status&facilityid="+facilityid+"&appt_date="+appt_date+"&patient_id="+patient_id+"&appt_ref_num="+appt_ref_num,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrMsg=retVal;
	var arr=new Array();
	arr=arrMsg.split(",");
	var cou=0;
	var oper_proc_label=getLabel("eOT.PickListStatus.Label","ot_labels");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	var id_name_colval  ='';
	//if(arr[0]=="" || arr[0]==null){
	//id_name_colval  =oper_proc_label;
	//}else{
	id_name_colval  = "Pick List Generation Status"
	//}
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B>"+id_name_colval + " </B> </a> </th>"
	tab_dat     += "</tr> ";

	for( cou=0;cou<arr.length;cou++){
		msg=arr[cou]; // commented by MuthuN for testing
		var msg1 = localTrimString(msg);//Added By MuthuN against CRF-268
		tab_dat     += "<tr>"
		tab_dat     += "<td class='label' > <B>"+msg1+ " </B> </a> </td>"
		tab_dat     += "</tr> ";
	}
	tab_dat     += "</table> ";
	document.getElementById("tooltiplayer1").innerHTML = tab_dat;
	resizeWindow1();
}

function resizeWindow1(){ 
	bodwidth = parent.frames[1].document.body.offsetWidth
	bodheight = parent.frames[1].document.body.offsetHeight

	var x =event.x
	var y =  event.y;

	x = x + (document.getElementById("tooltiplayer1").offsetWidth)
	y = y + (document.getElementById("tooltiplayer1").offsetHeight)

	if(x<bodwidth)
		x =event.x
	else
		x = x - (document.getElementById("tooltiplayer1").offsetWidth*1)

	if(y<bodheight){
		 y =event.y
	}else{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*1)
	}

	y+=document.body.scrollTop
	x+=document.body.scrollLeft

	document.getElementById("tooltiplayer1").style.posLeft= x
	document.getElementById("tooltiplayer1").style.posTop = y
	document.getElementById("tooltiplayer1").style.visibility='visible'
}
//Added by MuthuN against CRF-268 Ends Here
</script>
</head>
<%
	Connection conn=null;
	ResultSet rs_locn_room_bed=null;
	String surgery_date="",appt_date_hmap="",more_Less_result_Flag="",reschedule_count="",splty_and_nature_desc = "",nature_short_desc = "",current_locn="",room_bed_no="",curr_locn="",roomNo="",bed_no="",classvalue="",color_ind	= "",text_color	= "",appt_ref_num = "",oper_num="",case_called_time="",check_out_from_ward_time="",rescheduled_count="",appt_date="",asa_score_code="";
	String locale = (String)session.getAttribute("LOCALE"); 
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
	PreparedStatement pstmt2 = null;	
	ResultSet rst2 = null;
	PreparedStatement pstmt = null;	
	ResultSet rst = null;
	String Disp_Image="";
	//Added by MuthuN against CRF-268 Starts Here
	PreparedStatement pstmt3 = null;
	ResultSet rst3 = null;
	PreparedStatement pstmt4 = null;
	ResultSet rst4 = null;
	PreparedStatement pstmt5 = null;
	ResultSet rst5 = null;
	int count=0;
	String auto_schdl_yn = "";// Added By Gaurav Against ML-MMOH-CRF-1791-US04...
    String item_type="";
	String ot_Param="";
	String curr_encounter_id="";
	String curr_patient_class="";
	String episod_id="";
	String visit_id="";
	String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1"; 
	String calledFrom = ""; //IN052054	 
	//Added by MuthuN against CRF-268 Starts Here
try{
	
	more_Less_result_Flag	=	request.getParameter("more_Less_result_Flag");
	calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");//IN052054
	if(more_Less_result_Flag==null || more_Less_result_Flag.equals("null") || more_Less_result_Flag.equals(""))
	more_Less_result_Flag = "N";
	String room_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels") ;
	String bed_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels") ;
	String facilityid  = (String) session.getValue("facility_id");
	String login_user	= (String)session.getValue("login_user");
	String user_role = request.getParameter("user_role");
	String theatre_date = request.getParameter("theatre_date");
	String bill_flag = request.getParameter("bill_flag");
	String view_by = request.getParameter("view_by");
	theatre_date = com.ehis.util.DateUtils.convertDate(request.getParameter("theatre_date"),"DMY",locale,"en");
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	String patient_id = "";
	int count_val=0;
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap all_scheduled_case_details = bean.getScheduledCases();
	HashMap scheduled_case_details=new HashMap();
	int size = all_scheduled_case_details.size();
		conn = ConnectionManager.getConnection(request);
		pstmt1=conn.prepareStatement(sql_sm_report); // Added for IN:41808
			rst1=pstmt1.executeQuery();
			if(rst1 !=null && rst1.next())
			{
			customer_id1=checkForNull(rst1.getString("customer_id"));
			}	
			if(rst1!=null)rst1.close();
			if(pstmt1!=null)pstmt1.close();// End for IN:41808
		//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
		 pstmt2 = conn.prepareStatement("SELECT * from PR_HIGH_RISK_CONDITION where PATIENT_ID=? AND CLOSE_DATE IS NULL") ;

		String sql="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
		pstmt1 = conn.prepareStatement(sql) ;
		rst1 = pstmt1.executeQuery();
		while(rst1.next()){
			surgery_date=com.ehis.util.DateUtils.convertDate(rst1.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	//Added by Muthu against CRF_268 starts here
	String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
	try{
			pstmt3 = conn.prepareStatement(sqlOtParam);
			pstmt3.setString(1,facilityid);
			rst3=pstmt3.executeQuery();
			if(rst3 !=null && rst3.next())
			{
				ot_Param=rst3.getString("facility");
			}		
		}catch(Exception e){	
				System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
				e.printStackTrace();
			}finally{
			try{
			if(rst3!=null)    rst3.close();
			if(pstmt3!=null)  pstmt3.close();
			}catch(Exception e){}
		}
	//Added by Muthu against CRF_268 ends here
	%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="SlateSchSearchResultForm" id="SlateSchSearchResultForm">   
	<table class='grid' border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
	<%if(view_by.equals("A")){%>
	<tr id="slate_results_table_row1">
			<td class="columnHeader"  colspan="11">
			<fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img id="img_src_res" src='../../eOT/images/gripper.gif' onclick='extractResultFrame()'>
			</td>
	</tr>
	<%}else{%>
<tr id="slate_results_table_row1">
			<td class="columnHeader"  colspan="11">
			<fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/>
			</td>
	</tr>
<%}%>
	<tr>
	</tr>
	
	<tr id="slate_results_table_row1">
			<td class='columnHeader' ></td>
			<%if("Y".equalsIgnoreCase(ot_Param)){%> 
			<td class='columnHeader' ></td><!-- Added by MuthuN against CRF - 268 -->
			<%}%>
				<td class='columnHeader' ><fmt:message key="eOT.DateTimeSlot.Label" bundle="${ot_labels}"/> </td>
				<td class='columnHeader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
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
	for (int i=1;i<=size;i++){
		scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");
		appt_ref_num	= (String)scheduled_case_details.get("appt_ref_num");
		appt_date = (String)scheduled_case_details.get("appt_date");
		/*Below line was added by venkatesh.s on 27 -Aug-2013 againt against RUT-CRF-0083.4[IN041509] */
		curr_encounter_id=(String)scheduled_case_details.get("curr_encounter_id")==null ? "" :(String)scheduled_case_details.get("curr_encounter_id");		
        curr_patient_class=(String)scheduled_case_details.get("curr_patient_class")==null ? "" :(String)scheduled_case_details.get("curr_patient_class");
		
		  
		  if(!curr_encounter_id.equals("") && !curr_patient_class.equals("") && curr_patient_class.equals("IP") ){
		     episod_id=curr_encounter_id;
			
		  }else{
                if( !curr_encounter_id.equals("") && !curr_patient_class.equals("")){
				   
				   episod_id=curr_encounter_id.substring(0,8);
				   visit_id=curr_encounter_id.substring(8,curr_encounter_id.length());
				   
				  
				 }}		  
		       /* end against RUT-CRF-0083.4[IN041509] */
		    
		case_called_time	= (String)scheduled_case_details.get("case_called_time");
		check_out_from_ward_time	= (String)scheduled_case_details.get("check_out_from_ward_time");
		rescheduled_count	= (String)scheduled_case_details.get("reschedule_count");
		oper_num	= (String)scheduled_case_details.get("oper_num");
		if(oper_num==null) oper_num="";
		current_locn	= (String)scheduled_case_details.get("current_locn");
		if(current_locn ==null) current_locn="";
		asa_score_code	= (String)scheduled_case_details.get("asa_score_code"); //crf-0021
		if(asa_score_code ==null) asa_score_code="";
		
		reschedule_count	= checkForNull((String)scheduled_case_details.get("reschedule_count"));
		if(reschedule_count.equals("")) reschedule_count="0";
		classvalue = (i%2==0)?"gridData":"gridData";
		color_ind	= (String)scheduled_case_details.get("color_ind");
		text_color	= (String)scheduled_case_details.get("text_color");

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
	//IN:051238 start
	else {
			curr_locn="";
			roomNo="";
			bed_no="";
			room_bed_no=room_no_legend+" : "+roomNo+" "+bed_no_legend+" : "+bed_no; 
	     }
	 //IN:051238 end
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
	<%
	//Added Newly for Icon Disable on 12/28/2012 AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') 
	if("Y".equalsIgnoreCase(ot_Param)){	
	String sqlOTSlate_Status = "SELECT count(*) FROM ot_pick_lists WHERE booking_num = '"+appt_ref_num+"' AND operating_facility_id = '"+facilityid+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and (item_type='I' or item_type='P')  and (nvl(cssd_status,'X') <>'F')";
	try{
			pstmt5 = conn.prepareStatement(sqlOTSlate_Status);
			pstmt5.setString(1, appt_date);
			rst5=pstmt5.executeQuery();
			if(rst5 !=null && rst5.next())
			{
				count_val=rst5.getInt(1);
			}		
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rst5!=null)    rst5.close();
			if(pstmt5!=null)  pstmt5.close();
			}catch(Exception e){}
		}
	}
	String orderid=checkForNull((String)scheduled_case_details.get("order_id"));// GHL-CRF 356.1
	//Added Newly for Icon Disable on 12/28/2012
	
	    //Added by Gaurav Against ML-MMOH-CRF-1791-US04...starts
	
		String sql_2 = "SELECT AUTO_SCHDL_TO_NXTDAY_YN FROM OT_PARAM_FOR_FACILITY ";
		pstmt = conn.prepareStatement(sql_2);
		rst=pstmt.executeQuery();
		if(rst !=null && rst.next())
		{			
			auto_schdl_yn = rst.getString(1);			
		}
		
	     //Added by Gaurav Against ML-MMOH-CRF-1791-US04...ends
		%>
	<tr>		
			<!--Modified by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012-->
			<td style="font-size:10pt;font-weight:bold;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="Tip(indicatorToolTip('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"  onmouseout="UnTip()" >
			<img src='<%=Disp_Image%>' class='img' name='img1<%=i%>'  id='img1<%=i%>'  OnMouseDown="clickDrugInfo()">
			</td>
		<!-- Added by MuthuN against CRF-268 Starts Here -->
	<%if("Y".equalsIgnoreCase(ot_Param)){
				if(count_val>0){%>
			<td style="font-size:10pt;font-weight:bold;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="reasonToolTip1('<%=i%>','<%=patient_id%>','<%=appt_ref_num%>','<%=appt_date%>')"  onmouseout="hideToolTip1()" >
			<img src='../../eOT/images/picklist.png' class='img' name='img1<%=i%>'  id='img1<%=i%>'  OnMouseDown="clickDrugInfo()">
			</td>
			<%}else{%>
			<td></td>
			<%}	}%>
		<!-- Added by MuthuN against CRF-268 Ends Here -->
			<%if(!reschedule_count.equals("0") && auto_schdl_yn.equals("Y")){%>
			<td class="gridData" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="Tip(reasonToolTip4('reason','<%=i%>','sch_case'),JUMPHORZ,true)" onMouseOut="UnTip();">
			
				<%=com.ehis.util.DateUtils.convertDate((String)scheduled_case_details.get("appt_date"),"DMY","en",locale)%>&nbsp;&nbsp;<%=(String)scheduled_case_details.get("appt_from_time")%>-
				<%=(String)scheduled_case_details.get("appt_to_time")%>
				<img src='../../eOT/images/R_indicator.png' class='img' name='img3<%=i%>' id='img3<%=i%>'   Onmousedown="clickDrugInfo()">
			</td>
			<%}else{%>
				<td class="gridData" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=com.ehis.util.DateUtils.convertDate((String)scheduled_case_details.get("appt_date"),"DMY","en",locale)%>&nbsp;&nbsp;<%=(String)scheduled_case_details.get("appt_from_time")%>-
				<%=(String)scheduled_case_details.get("appt_to_time")%>
			</td>
			<%}%>
			<td  class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>"  > <%=(String)scheduled_case_details.get("patient_id")%></font>					
			</td>
			<%
			appt_date_hmap=com.ehis.util.DateUtils.convertDate((String)scheduled_case_details.get("appt_date"),"DMY","en",locale);

			boolean flag=com.ehis.util.DateUtils.isBefore(appt_date_hmap,surgery_date,"DMY",locale);
			//belosw stmt Added by DhanasekarV on 07/06/2012  for report intenernalization leap year
			//flag = true;
			if(flag)
			{
%>
			<!-- GHL-CRF 356.1-->
				<td id='orderctl<%=i%>'  onClick="displayToolTip('<%=i%>',this,'SLATE',this,'imgArrow<%=i%>','<%=curr_encounter_id%>','<%=current_locn%>');external_doc('patient_id_<%=i%>');" style='cursor:pointer' class='gridDataBlue' onMouseOver=" hidemenu();" >
					<%=(String)scheduled_case_details.get("patient_name")%>
<%
					//IN052054
					if(calledFrom != null && !calledFrom.equals("CA"))
					{
%>
						<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'>
<%
					}
					//IN052054
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
			<input type='hidden' name="patient_name_<%=i%>" id="patient_name_<%=i%>" value="<%=scheduled_case_details.get("patient_name")%>">
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>"  wrap><%=(String)scheduled_case_details.get("oper_room_desc")%></td>
			<!-- ML-BRU-SCF-1054 by MuthuN -->
					<!--<td  class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="reasonToolTip('<%=i%>','scheduled_cases')"   onmouseout="hideToolTip1()">-->
					<!--Tip(indicatorToolTip('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)-->
					<td  class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="Tip(reasonToolTip('<%=i%>','scheduled_cases'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)"   onmouseout="UnTip()"><!--058860-->
					<img src='../../eOT/images/drugInfo.gif' class = 'img' name='img2<%=i%>' id =name='img2<%=i%>'   Onmousedown="clickDrugInfo()">
						<%=checkForNull((String)scheduled_case_details.get("oper_desc"))%>
                       
					</td>
				<!-- Added New CRF-0021		-->
				<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				 <%=checkForNull((String)scheduled_case_details.get("asa_score_code"))%> 
				
				</td>
		    <!-- end  -->	
		
			<%
				
				
				splty_and_nature_desc = checkForNull((String)scheduled_case_details.get("speciality_desc"));
				nature_short_desc = checkForNull((String)scheduled_case_details.get("nature_short_desc"));
				nature_short_desc = nature_short_desc==null?"":nature_short_desc;
				nature_short_desc = nature_short_desc.equals("null")?"":nature_short_desc;
				if(!nature_short_desc.equals(""))
					splty_and_nature_desc= splty_and_nature_desc+"("+nature_short_desc+")";
			%>
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" >
				<%=splty_and_nature_desc%>
			</td>
			<%
			String surgeon_name=checkForNull((String)scheduled_case_details.get("surgeon_name"));
				if(surgeon_name.equals("")){
			%>
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color: <%=color_ind%>" >All Surgeons
				
			</td>
			<%}else {%>
			<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color: <%=color_ind%>" >
				<%=checkForNull((String)scheduled_case_details.get("surgeon_name"))%>
			</td>
			<%}%>
			<%
			//status_times = bean.getSlateStatusTimes("SCH",scheduled_case_details,reschedule_count);
			out.println("<input type='hidden' name='check_out_from_ward_time_"+i+"' id='check_out_from_ward_time_"+i+"' value=\""+check_out_from_ward_time+"\" >");
			out.println("<input type='hidden' name='case_called_time_"+i+"' id='case_called_time_"+i+"' value=\""+case_called_time+"\" >");
			out.println("<input type='hidden' name='rescheduled_count_"+i+"' id='rescheduled_count_"+i+"' value=\""+rescheduled_count+"\" >");
			%>
				
		<!--<td class="<%=classvalue%>"  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="reasonToolTip3('reason','<%=i%>','sch_case')" onMouseOut="hideToolTip3();">-->
		<!--Tip(indicatorToolTip('<%=i%>'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)-->
		<td class="<%=classvalue%>"  style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="Tip(reasonToolTip3('reason','<%=i%>','sch_case'),JUMPHORZ,true)" onMouseOut="UnTip();"><!--058860-->

			 <img src='../../eOT/images/drugInfo.gif' class='img' name='img3<%=i%>' id='img3<%=i%>'   Onmousedown="clickDrugInfo()">
				<%=checkForNull((String)scheduled_case_details.get("status_desc"))%> 
				<%if(Integer.parseInt(reschedule_count)>0 && checkForNull((String)scheduled_case_details.get("status_desc")).equals("Scheduled"))
		{%>	(<%=checkForNull((String)scheduled_case_details.get("reschedule_count"))+"R"%>)
			<%}%>
           
			</td>  
				<%if(!current_locn.equals(curr_locn+"$$^$$^")){
				%>
				<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%> "OnMouseOver="Tip(reasonStatusToolTip('<%=room_bed_no%>'),JUMPHORZ,true)" onmouseout="UnTip()">
				<img src='../../eOT/images/drugInfo.gif' class = 'img' name='img4<%=i%>' id='img4<%=i%>'  onmousedown="clickDrugInfo()">
				<%} else {
				//IN:051238
				%>
				<td class="<%=classvalue%>" style="font-size:7pt;font-weight:normal;color:<%=text_color%>;background-color:<%=color_ind%>" OnMouseOver="Tip(reasonStatusToolTip('<%=room_bed_no%>'),JUMPHORZ,true)"  onmouseout="UnTip()">
				<img src='../../eOT/images/drugInfo.gif' class = 'img' name='img4<%=i%>' id='img4<%=i%>'  onmousedown="clickDrugInfo()">
				<% } 
				%>								
				<%=curr_locn%><!-- MMS-SCF-0430 [IN:051824] -->
			</td>
			<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>" value="<%=(String)scheduled_case_details.get("patient_id")%>">
			<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("order_id"))%>">
			<input type="hidden" name="oper_code_<%=i%>" id="oper_code_<%=i%>" value="<%=(String)scheduled_case_details.get("oper_code")%>">
			<input type="hidden" name="speciality_code_<%=i%>" id="speciality_code_<%=i%>" value="<%=(String)scheduled_case_details.get("speciality_code")%>">
			<input type="hidden" name="surgeon_code_<%=i%>" id="surgeon_code_<%=i%>" value="<%=(String)scheduled_case_details.get("surgeon_code")%>">
			<input type="hidden" name="oper_status_<%=i%>" id="oper_status_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("oper_status"))%>">
			<input type="hidden" name="oper_num_<%=i%>" id="oper_num_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("oper_num"))%>">
			<input type="hidden" name="asa_score_code_<%=i%>" id="asa_score_code_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("asa_score_code"))%>"> <!-- crf -0021-->
<!-- 
			 <input type="hidden" name="implant_entry_cmp_yn_<%=i%>" id="implant_entry_cmp_yn_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("implant_entry_cmp_yn"))%>">
			<input type="hidden" name="consumable_entry_cmp_yn_<%=i%>" id="consumable_entry_cmp_yn_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("consumable_entry_cmp_yn"))%>">
			<input type="hidden" name="equipment_entry_cmp_yn_<%=i%>" id="equipment_entry_cmp_yn_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("equipment_entry_cmp_yn"))%>">
			<input type="hidden" name="instrument_entry_cmp_yn_<%=i%>" id="instrument_entry_cmp_yn_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("instrument_entry_cmp_yn"))%>"> 
			<input type="hidden" name="proc_chrg_cmp_yn_<%=i%>" id="proc_chrg_cmp_yn_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("proc_chrg_cmp_yn"))%>"> -->
			<input type="hidden" name="appt_ref_num_<%=i%>" id="appt_ref_num_<%=i%>" value="<%=appt_ref_num%>"> 
			<input type="hidden" name="facilityid<%=i%>" id="facilityid<%=i%>" value=<%=facilityid%>><!--IE-11 Issue-->
			<input type="hidden" name="appt_date<%=i%>" id="appt_date<%=i%>" value="<%=appt_date%>">			
			<input type="hidden" name="waitlist_num_<%=i%>" id="waitlist_num_<%=i%>" value="">
			<input type="hidden" name="nursing_doc_comp_yn_<%=i%>" id="nursing_doc_comp_yn_<%=i%>" value="<%=(String)scheduled_case_details.get("nursing_doc_comp_yn")%>">
			<input type="hidden" name="surgeon_doc_comp_yn_<%=i%>" id="surgeon_doc_comp_yn_<%=i%>" value="<%=(String)scheduled_case_details.get("surgeon_doc_comp_yn")%>">
			<input type="hidden" name="anaesthesia_doc_comp_yn_<%=i%>" id="anaesthesia_doc_comp_yn_<%=i%>" value="<%=(String)scheduled_case_details.get("anaesthesia_doc_comp_yn")%>">	
			
			<input type="hidden" name="speciality_desc_<%=i%>" id="speciality_desc_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("speciality_desc"))%>">	

			<input type="hidden" name="surgeon_desc_<%=i%>" id="surgeon_desc_<%=i%>" value="<%=checkForNull((String)scheduled_case_details.get("surgeon_name"))%>">
			<!-- Below line was added by venkatesh.S on 27-Aug-2013 against RUT-CRF-0083.4[IN041509] -->
			<input type="hidden" name="episod_id_<%=i%>" id="episod_id_<%=i%>" value="<%=episod_id%>">
			<input type="hidden" name="patient_class_<%=i%>" id="patient_class_<%=i%>" value="<%=curr_patient_class%>">
			<input type="hidden" name="current_locn_<%=i%>" id="current_locn_<%=i%>" value="<%=current_locn%>">
			<!-- end RUT-CRF-0083.4[IN041509] --> 
		
		</tr>
	<% 
		}
	%>

	</table>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=(String)session.getValue("facility_id")%>">
	<input type="hidden" name="appt_ref_date" id="appt_ref_date" value="<%=(String)scheduled_case_details.get("appt_date")%>">
	<input type="hidden" name="menu_id" id="menu_id" value="<%="26"%>">		
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="user_role" id="user_role" value="<%=user_role%>">		
	<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">		

	<input type="hidden" name="function_id_list" id="function_id_list" value="">		
	<input type="hidden" name="function_name_list" id="function_name_list" value="">		
	<input type="hidden" name="url_desc_list" id="url_desc_list" value="">		
	<input type="hidden" name="sch_unsch_flag" id="sch_unsch_flag" value="SCHEDULED">
	 <input type="hidden" name="text_color_1" id="text_color_1" value="<%=color_ind%>">		 
	<input type="hidden" name="text_color_2" id="text_color_2" value="<%=text_color%>">
	<input type="hidden" name="bill_flag" id="bill_flag" value="<%=bill_flag%>">
	<input type="hidden" name="search_page_view_by" id="search_page_view_by" value="<%=view_by%>">
	<input type="hidden" name="more_Less_result_Flag" id="more_Less_result_Flag" value="<%=more_Less_result_Flag%>">
	<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="surgery_date" id="surgery_date" value="<%=surgery_date%>">
	<input type="hidden" name="appt_ref_num" id="appt_ref_num" value="<%=appt_ref_num%>">
	<input type="hidden" name="appt_date" id="appt_date" value="<%=appt_date%>">
 	  <!-- Below line was added by venkatesh.S on 27-Aug-2013 against RUT-CRF-0083.4[IN041509] -->
	<input type="hidden" name="size" id="size" value="<%=size%>">
	<input type="hidden" name="resp_id" id="resp_id" value="<%=resp_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="OT">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>" >
	<input type="hidden" name="calledFrom" id="calledFrom" value="<%=calledFrom%>" > <%-- IN052054 --%>
	<input type="hidden" name="customer_name" id="customer_name" value="<%=customer_id1%>"> <!-- Added for IN:41808 -->
	<!-- end RUT-CRF-0083.4[IN041509] --> 
	<input type="hidden" name="auto_schdl_yn" id="auto_schdl_yn" value="<%=auto_schdl_yn%>"> <!-- Added by Gaurav Against ML-MMOH-CRF-1791-US04-->		
			
</form>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute;  width:30%; visibility:hidden;' bgcolor='blue' ></div>
	<div name='tooltiplayer3' id='tooltiplayer3' style='position:absolute; width:36%; visibility:hidden;' bgcolor='blue'></div>
 	<div name='tooltiplayer2' id='tooltiplayer2' style='position:absolute; width:70%; visibility:hidden; overflow:auto' bgcolor='blue'></div>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>

	 <table id='tooltiptable' cellpadding="0" cellspacing=0 border='0'   style='position:absolute;' width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
<script language="javascript">

</script>
<%
		//bean.clear();
		if(rst2 != null) rst2.close();
		if(pstmt2 != null) pstmt2.close();
		
		}catch(Exception e){
			out.println(e);
		}finally{
		if(rs_locn_room_bed!=null) rs_locn_room_bed.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
	}
%>

