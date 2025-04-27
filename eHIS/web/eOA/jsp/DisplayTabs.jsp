<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<%
	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;	
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");		
	String callingMode=request.getParameter("callingMode");
	if (callingMode==null) callingMode = "";
	String facilityid=(String)session.getValue("facility_id");
	String install_yn_val="";
	String frmCa=(String) session.getValue("ca_mode");
	if (frmCa==null) frmCa = "";
	String from_OR=request.getParameter("from_OR");
	if(from_OR ==null) from_OR="N";

	String speciality=request.getParameter("speciality");
	if(speciality ==null) speciality="";
	String clinic_old=request.getParameter("clinic_old");
	if(clinic_old ==null) clinic_old="";
	String practitioner_old=request.getParameter("practitioner_old");
	if(practitioner_old ==null) practitioner_old="";
	String practitioner_type=request.getParameter("practitioner_type");
	if(practitioner_type ==null) practitioner_type="";
	String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");//for pending orders
	String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String pref_start_date=request.getParameter("pref_start_date");
	if(pref_start_date ==null) pref_start_date="";
	String pref_end_date=request.getParameter("pref_end_date");
	if(pref_end_date ==null) pref_end_date="";
	String care_locn_ind=request.getParameter("clinic_type");
	if(care_locn_ind ==null) care_locn_ind="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null) no_dwm="";
	String visittype=(String)request.getParameter("visittype");
	if(visittype == null || visittype.equals("null")) visittype ="";
	String dwm_desc=request.getParameter("dwm_desc");
	if(dwm_desc ==null) dwm_desc="";
	String calledFrom=request.getParameter("calledFrom");
	if(calledFrom ==null) calledFrom="";
	
	String ca_patient_id=request.getParameter("ca_patient_id");
	if(ca_patient_id ==null) ca_patient_id="";

 	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"":request.getParameter("rd_appt_yn");

	
	try{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String sql="select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR' ";
		rs=stmt.executeQuery(sql);
		if(rs !=null ){
			while (rs.next()){
				install_yn_val=rs.getString("Operational_yn");
			}
		}	

%>
<script>		

	function tab_click2(id){
			selectTab(id);
			tab_click(id);
	}
	function tab_click(objName){
		if (objName == 'order_tab' ){
			var install_yn_val=document.forms[0].install_yn_val.value;
			var url="../../eOA/jsp/DisplayPendingSchedule.jsp?install_yn_val="+install_yn_val;
			parent.parent.frames[1].location.href=url;
		}else if (objName == 'additional_tab' || objName == 'additional_tab1'){
			parent.patsearch.document.getElementById("pat_search").rows="20,190,20,*";
			moveToTab(2);
		}else if(objName == 'pending_tab'){
		//modified by N Munisekhar for[IN:048929] 
		 var callingMode = document.forms[0].callingMode.value;
			var install_yn_val=document.forms[0].install_yn_val.value;
			var url='../../eOA/jsp/DisplayPendingReferral.jsp?install_yn_val='+install_yn_val+'&callingMode='+callingMode;
		    //var url='../../eOA/jsp/DisplayPendingReferral.jsp?install_yn_val='+install_yn_val;
			//parent.parent.frames[1].location.href=url;
			if (callingMode=="MR"   || callingMode=="OP_RV"){
			parent.parent.document.getElementById("dis_page").rows='*';
			parent.parent.frames[0].location.href=url;
			//parent.parent.frames[1].location.href='../../eCommon/html/blank.html';
		     }else{
			parent.parent.frames[1].location.href=url;
		      }
		}else if(objName == 'schedule_tab' || objName == 'schedule_tab'){
			var callingMode = document.forms[0].callingMode.value;
			var cmd=document.forms[0].caMod.value;
			var qStr=document.forms[0].qStr.value;
			var from_wait_list=document.forms[0].from_wait_list.value;
			var speciality=document.forms[0].speciality.value;
			var practitioner_old=document.forms[0].practitioner_old.value;
			var clinic_old=document.forms[0].clinic_old.value;
			var practitioner_type=document.forms[0].practitioner_type.value;
			var or_catalogue_code=document.forms[0].or_catalogue_code.value;
			var pref_start_date=document.forms[0].pref_start_date.value;
			var pref_end_date=document.forms[0].pref_end_date.value;
			var care_locn_ind=document.forms[0].care_locn_ind.value;
			var no_dwm=document.forms[0].no_dwm.value;
			var visittype=document.forms[0].visittype.value;
			var dwm_desc=document.forms[0].dwm_desc.value;
			var order_catalog_code=document.forms[0].order_catalog_code.value;
			var order_id=document.forms[0].order_id.value;
			var calledFrom=document.forms[0].calledFrom.value;
			var from_OR=document.forms[0].from_OR.value;
			var ca_patient_id=document.forms[0].ca_patient_id.value;			
			var position=document.forms[0].position.value;			
			var addtl_splty=document.forms[0].addtl_splty.value;			
			var rd_appt_yn=document.forms[0].rd_appt_yn.value;		
			var install_yn_val=document.forms[0].install_yn_val.value;//@UAT-3			
			if (callingMode=="" || callingMode=="CA"  ){
				if(cmd=='Y'){
					var qStr1='CA=Y&module_id=OA&loc_type='+care_locn_ind+'&specialty_code='+speciality+'&practitioner_id='+practitioner_old+'&clinic_code='+clinic_old+'&resource_class='+practitioner_type+'&or_catalogue_code='+or_catalogue_code+'&recall_date='+pref_start_date+'&quer_date_end='+pref_end_date+'&callingMode='+callingMode+'&no_dwm='+no_dwm+'&visittype='+visittype+'&dwm_desc='+dwm_desc+'&qStr='+qStr+'&position='+position+'&addtl_splty='+addtl_splty+"&rd_appt_yn="+rd_appt_yn;
					parent.location.href='../../eOA/jsp/CAOAAppointment.jsp?'+qStr1;
				}else{
					var url='../../eOA/jsp/Appointment.jsp?CA=N&module_id=OA&care_locn_ind='+care_locn_ind+'&specialty_code='+speciality+'&practitioner_id='+practitioner_old+'&clinic_code='+clinic_old+'&resource_class='+practitioner_type+'&or_catalogue_code='+or_catalogue_code+'&recall_date='+pref_start_date+'&quer_date_end='+pref_end_date+'&callingMode='+callingMode+"&no_dwm="+no_dwm+"&visittype="+visittype+"&dwm_desc="+dwm_desc+"&position="+position+"&addtl_splty="+addtl_splty+"&install_yn_val="+install_yn_val+"&rd_appt_yn="+rd_appt_yn;//+"&install_yn_val="+install_yn_val added  @UAT-3
					parent.location.href=url;
				}
			}else{
					var qrs='CA=N&module_id=OA&care_locn_ind='+care_locn_ind+'&specialty_code='+speciality+'&practitioner_id='+practitioner_old+'&clinic_code='+clinic_old+'&resource_class='+practitioner_type+'&or_catalogue_code='+or_catalogue_code+'&recall_date='+pref_start_date+'&quer_date_end='+pref_end_date+'&callingMode='+callingMode+'&no_dwm='+no_dwm+'&visittype='+visittype+'&dwm_desc='+dwm_desc+"&order_catalog_code="+order_catalog_code+"&order_id="+order_id+"&specialty_codema="+speciality+"&calledFrom="+calledFrom+"&from_OR="+from_OR+"&patient_id="+ca_patient_id+"&position="+position+"&addtl_splty="+addtl_splty+"&install_yn_val="+install_yn_val+"&rd_appt_yn="+rd_appt_yn;//+"&install_yn_val="+install_yn_val added  @UAT-3
					if(callingMode == "OR" && calledFrom == "OR"){ //Added by Sathish.S for IN020026 onMonday, March 22, 2010
						parent.location.href='../../eOA/jsp/Appointment.jsp?'+qrs;
					}
					else{
					parent.window.returnValue="1"+"^"+qrs;
					parent.window.close();					
					}
			}
		}
	}
</script>
<html>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eOA/js/ChangeDate.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name=image>
		<a name='demo'></a>
			<ul id="tablist" class="tablist" >
				<li class="tablistitem" title="Schedules">
					<a onclick="tab_click2('schedule_tab')" class="tabA" id='schedule_tab' >
						<span class="tabAspan" id="schedule_tabspan" ><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Day Schedule">
					<a onclick="tab_click2('day_tab')" class="tabClicked" id='day_tab' >
						<span class="tabSpanclicked" id="day_tabspan" ><fmt:message key="Common.day.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			<%if(callingMode.equals("")|| callingMode.equals("OP_RV")|| callingMode.equals("MR")) {%>
				<li class="tablistitem" title="Pending Referral">
					<a onclick="tab_click2('pending_tab')" class="tabA" id='pending_tab' >
						<span class="tabAspan" id="pending_tabspan" ><fmt:message key="eOA.Pendingreferral.label" bundle="${oa_labels}"/></span>
					</a>
				</li>
			<%}%>
			<%if ((from_OR.equals("Y") || callingMode.equals("")) && install_yn_val.equals("Y")) {%>
			<li class="tablistitem" title="Pending Order">
					<a onclick="tab_click2('order_tab')" class="tabA" id='order_tab' >
						<span class="tabAspan" id="order_tabspan" ><fmt:message key="eOA.PendingOrderSchedule.label" bundle="${oa_labels}"/></span>
					</a>
				</li>
		<%}else{%>			
		<%}%>
			
		</ul>
        <br>
			<input type="hidden" name="caMod" id="caMod" value ="<%=frmCa%>">
			<%String qStr=(String) session.getValue("qStr");
			String from_wait_list=(String) session.getValue("from_wait_list");%>
			<input type="hidden" name="qStr" id="qStr" value ="<%=qStr%>">
			<input type="hidden" name="from_wait_list" id="from_wait_list" value ="<%=from_wait_list%>">
			<input type="hidden" name="callingMode" id="callingMode" value='<%=callingMode%>'>
			<input type='hidden' name='ct_tab_name' id='ct_tab_name'>
			<input type='hidden' name='install_yn_val' id='install_yn_val' value='<%=install_yn_val%>'>
			<input type='hidden' name='from_OR' id='from_OR' value='<%=from_OR%>'>
			<input type='hidden' name='speciality' id='speciality' value='<%=speciality%>'>
			<input type='hidden' name='clinic_old' id='clinic_old' value='<%=clinic_old%>'>
			<input type='hidden' name='practitioner_old' id='practitioner_old' value='<%=practitioner_old%>'>
			<input type='hidden' name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
			<input type='hidden' name='or_catalogue_code' id='or_catalogue_code' value='<%=or_catalogue_code%>'>
			<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
			<input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
			<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>
			<input type='hidden' name='pref_start_date' id='pref_start_date' value='<%=pref_start_date%>'>
			<input type='hidden' name='pref_end_date' id='pref_end_date' value='<%=pref_end_date%>'>
			<input type='hidden' name='care_locn_ind' id='care_locn_ind' value='<%=care_locn_ind%>'>
			<input type='hidden' name='no_dwm' id='no_dwm' value='<%=no_dwm%>'>
			<input type='hidden' name='visittype' id='visittype' value='<%=visittype%>'>
			<input type='hidden' name='dwm_desc' id='dwm_desc' value='<%=dwm_desc%>'>
			<input type='hidden' name='calledFrom' id='calledFrom' value='<%=calledFrom%>'>
			<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>'>
			<input type="hidden" name='position' id='position' value='<%=position%>'>
			<input type="hidden" name='addtl_splty' id='addtl_splty' value='<%=addtl_splty%>'>
			<input type="hidden" name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>'>
	</body>
	</form>
				<%
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
}
catch(Exception es)
{
	//out.println("Exception :"+es);
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
	%>
</html>

