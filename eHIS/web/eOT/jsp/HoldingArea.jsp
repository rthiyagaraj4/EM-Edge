<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.util.HashMap,webbeans.eCommon.ConnectionManager,java.net.URLDecoder,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<html>
<%@ page import ="java.util.ArrayList,eOT.HoldingAreaBean" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); 
%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script type='text/javascript' src='../../eCommon/js/DateUtils.js'></script>
<script type='text/javascript' src='../../eOT/js/HoldingArea.js'></script>
<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<form name='HoldingAreaForm' id='HoldingAreaForm'  >
<%
	String function_id_temp = checkForNull(request.getParameter("function_id_temp"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String slate_user_id = checkForNull(request.getParameter("slate_user_id"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String module_id = checkForNull(request.getParameter("module_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String order_id = checkForNull(request.getParameter("order_id"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String oper_code = checkForNull(request.getParameter("oper_code"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String chargable_amt="";
	String bean_id = "HoldingAreaBean";
	String bean_name = "eOT.HoldingAreaBean";
	HoldingAreaBean hold_bean = (HoldingAreaBean) mh.getBeanObject(bean_id, request, bean_name );
	String cur_date="";
	String cur_time="";
	ArrayList date_list = hold_bean.getSysDateTime(); // date_time, date, time
    cur_date = (String)date_list.get(1);
	cur_time = (String)date_list.get(2);
	hold_bean.loadHoldingAreaDtls(oper_num);
	ArrayList hold_area_list = hold_bean.getHoldingAreaDtls();
	int size = hold_area_list.size();
	String inventry_chk_yn="";
	String sql="",bill_acc_num_DB="",checked_in_date_DB="",checked_in_time_DB="",checked_out_date_DB="",checked_out_time_DB="",holding_area_code_DB="",holding_area_desc_DB="",modified_charge_units_DB="",calc_chargeable_units_DB="",holding_seq_num_DB="",charge_hold_area_yn="",oper_num_with_hb="";
	String checked_in_date_DB_disp="",checked_out_date_DB_disp="";
	String mode="insert";
	int bill_acc_temp=1;
	Connection con = null;
	Statement pstmt  = null;
	ResultSet rst = null;
	Connection conn	=null;
	Statement stmt  = null ;
	ResultSet rst1   = null ;
	try{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
//Added ADDED_DATE in query for 25523 by Anitha on 12/16/2010
	 sql="SELECT A.BL_ACCESSION_NUM BILL_ACCESSION_NUM,A.HOLDING_AREA_CODE HOLDING_AREA_CODE,B.HOLDING_AREA_DESC HOLDING_AREA_DESC,TO_CHAR(A.CHECKED_IN_DATE_TIME,'DD/MM/YYYY') CHECKED_IN_DATE,TO_CHAR(A.CHECKED_IN_DATE_TIME,'HH24:MI') CHK_IN_TIME,TO_CHAR(A.CHECKED_OUT_DATE_TIME,'DD/MM/YYYY') CHECKED_OUT_DATE,TO_CHAR(A.CHECKED_OUT_DATE_TIME,'HH24:MI') CHK_OUT_TIME,A.CHARGEABLE_UNITS MODIFIED_CHARGE_UNITS,A.CALC_CHARGEABLE_UNITS CALC_CHARGEABLE_UNITS,NVL(A.HOLDING_SEQ_NUM,0) HOLDING_SEQ_NUM FROM OT_OPER_HOLDING_DTLS A, OT_HOLDING_AREAS_LANG_VW B WHERE B.LANGUAGE_ID = '"+locale+"' AND A.OPERATING_FACILITY_ID ='"+facility_id+"' AND A.OPER_NUM ='"+oper_num+"' AND  HOLDING_SEQ_NUM = (SELECT MAX(HOLDING_SEQ_NUM) FROM OT_OPER_HOLDING_DTLS WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND OPER_NUM ='"+oper_num+"') AND A.HOLDING_AREA_CODE = B.HOLDING_AREA_CODE ORDER BY A.ADDED_DATE";

		rst1=stmt.executeQuery(sql);
		while(rst1 !=null && rst1.next())
		{
			bill_acc_num_DB=checkForNull(rst1.getString(1));
			holding_area_code_DB=checkForNull(rst1.getString(2));
			holding_area_desc_DB=checkForNull(rst1.getString(3));
			checked_in_date_DB=checkForNull(rst1.getString(4));
			checked_in_time_DB=checkForNull(rst1.getString(5));
			checked_out_date_DB=checkForNull(rst1.getString(6));
			checked_out_time_DB=checkForNull(rst1.getString(7));
			modified_charge_units_DB=checkForNull(rst1.getString(8));
			calc_chargeable_units_DB=checkForNull(rst1.getString(9));
			holding_seq_num_DB=checkForNull(rst1.getString(10));
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println(" Exception in Holding Area.jsp Bill_Accc_Num--->  "+e);
	}finally{
			if(rst1!=null) rst1.close();
			if(stmt!=null)stmt.close();
			if(conn!=null) conn.close();
		}

		if(!holding_seq_num_DB.equals("")){
			mode="update";
		}

		if(!holding_seq_num_DB.equals("") && mode.equals("insert")){
			bill_acc_temp=Integer.parseInt(holding_seq_num_DB)+1;
		}
		
//----------------------Forming Billing Accession Num Starts-----------------
if(function_id_temp.equals("33") && !oper_num_with_hb.equals("")){
		if(!bill_acc_num_DB.equals("")){
			oper_num_with_hb=bill_acc_num_DB.substring(0,12);
			bill_acc_temp=Integer.parseInt(holding_seq_num_DB)+1;

		}
}
//----------------------Forming Billing Accession Num Ends-----------------
			
	try{

		con = ConnectionManager.getConnection(request);
		pstmt = con.createStatement();
		 sql="SELECT NVL(BL_INTERFACE_FLAG,'N'),CHARGE_HOLDING_AREA_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		rst=pstmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			inventry_chk_yn=rst.getString(1);
			charge_hold_area_yn=rst.getString(2);
		}
		if(inventry_chk_yn.equals("N"))	charge_hold_area_yn="N";
			 
	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from HoldingArea.jsp :"+e);
		}
		finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
		}

if(function_id_temp.equals("")){ %>
	<body onLoad="isRecordVitalEnable(); assignSpecialityCode();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}else if( function_id_temp.equals("33")){%>
<body onLoad="isRecordVitalEnable(); assignSpecialityCode(); assignChkInOutTime();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>				
<%}%>
<table cellpadding=3  cellspacing='0' border='0' width='100%' align='center'>

<%if(function_id_temp.equals("")){%>

<tr>
	<td width='25%' colspan="4" class='CAGROUPHEADING'>
		<fmt:message key="eOT.HoldingAreaDetails.Label" bundle="${ot_labels}"/> 
	</td> 
</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> 
	</td> 
<%if("".equals(checked_in_date_DB)) {%>
	<td class='fields' width="25%" >
			<input type='text' class='fields' name='check_in_date' id='check_in_date' size='8'  value='<%=cur_date%>' readonly>
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar_loc_chk('check_in_date');"> 
			<input type='text' class='fields' name='check_date_time' id='check_date_time' size='2'  maxlength='5' value='<%=cur_time%>' onBlur='checkTime(this),checkInTimeChargeUnits(this);' onkeypress="return checkForSpecCharsforIDTime(event);" > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%}else{%>
	<td class='fields' width="25%" >
			<input type='text' class='fields' name='check_in_date' id='check_in_date' size='8'  value='<%=checked_in_date_DB%>'  disabled>
			<input type='text' class='fields' name='check_date_time' id='check_date_time' size='2'  maxlength='5' value='<%=checked_in_time_DB%>' onBlur='checkTime(this);' disabled>
	</td>
<%}%>
	<td  class='label' width="25%"> 
			<fmt:message key="eOT.HoldingBay.Label" bundle="${ot_labels}"/> 
	</td> 
<%
if(size==0){
%>
		<td  class='fields' width="25%" > 
			<input type='hidden' class='fields' name='change_holding_code' id='change_holding_code' value=''>
			<input type='text' class='fields' name='change_holding_desc' id='change_holding_desc' size='30'  value='' onBlur="if(this.value!='')searchHoldingAreaBay(change_holding_code, change_holding_desc);">
			<input type='button' class='button' value='?' name='HoldingBayLookUp' id='HoldingBayLookUp' onClick='searchHoldingAreaBay(change_holding_code, change_holding_desc);'><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%}else{%>
	<td  class='fields' width="25%" > 
			<input type='hidden' class='fields' name='change_holding_code' id='change_holding_code' value='<%=holding_area_code_DB%>' disabled>
			<input type='text' class='fields' name='change_holding_desc' id='change_holding_desc' size='30'  value='<%=holding_area_desc_DB%>' onBlur="if(this.value!='')searchHoldingAreaBay(change_holding_code, change_holding_desc);" disabled>		
			
	</td>
<%}%>

</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.CheckedOutDateTime.Label" bundle="${ot_labels}"/> 
	</td> 
<%if("".equals(checked_out_time_DB)  && !"".equals(holding_area_desc_DB) ) { //Added holding_area_desc_DB Against TH-KW-CRF-0135%>
	 <td class='fields' width="25%" >
	 <%if("Y".equals(charge_hold_area_yn)) {%>
			<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='<%=cur_date%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" >
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar_loc('change_out_date');"> 
			<input type='text' class='fields' name='change_out_date_time' id='change_out_date_time' size='2' onkeypress="return checkForSpecCharsforIDTime(event);" maxlength='5' value='<%=cur_time%>' onBlur='if(document.forms[0].change_out_date.value!="")validateDateTime();' ><!--Added cur_date and cur_time Against TH-KW-CRF-0135-->
				<!--<img src='../../eCommon/images/mandatory.gif'></img> -->
				<img id="hold_area_img" src='../../eCommon/images/mandatory.gif' style='position:absolute;visibility:visible'></img>	
			<%}else {%>
				<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='<%=cur_date%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" >
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar_loc('change_out_date');"> 
			<input type='text' class='fields' name='change_out_date_time' id='change_out_date_time' size='2' onkeypress="return checkForSpecCharsforIDTime(event);" maxlength='5' value='<%=cur_time%>' onBlur='if(document.forms[0].change_out_date.value!="")validateDateTime();' ><!--Added cur_date and cur_time Against TH-KW-CRF-0135-->
			<%}%>

	  </td> 
<%}else if("".equals(checked_out_time_DB)) { %>
	 <td class='fields' width="25%" >
	 <%if("Y".equals(charge_hold_area_yn)) {%>
			<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" >
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar_loc('change_out_date');"> 
			<input type='text' class='fields' name='change_out_date_time' id='change_out_date_time' size='2' onkeypress="return checkForSpecCharsforIDTime(event);" maxlength='5' value='' onBlur='if(document.forms[0].change_out_date.value!="")validateDateTime();' >
				<!--<img src='../../eCommon/images/mandatory.gif'></img> -->
				<img id="hold_area_img" src='../../eCommon/images/mandatory.gif' style='position:absolute;visibility:visible'></img>	
			<%}else {%>
				<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" >
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar_loc('change_out_date');"> 
			<input type='text' class='fields' name='change_out_date_time' id='change_out_date_time' size='2' onkeypress="return checkForSpecCharsforIDTime(event);" maxlength='5' value='' onBlur='if(document.forms[0].change_out_date.value!="")validateDateTime();' >
			<%}%>

	  </td> 
<%}else{%>
	 <td class='fields' width="25%" >
			<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='<%=checked_out_date_DB%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);"  disabled>
			<input type='text' class='fields' name='change_out_date_time' id='change_out_date_time' size='2' onkeypress="return checkForSpecCharsforIDTime(event);" maxlength='5' value='<%=checked_out_time_DB%>'disabled> 
	  </td> 
<%}%>

	
<%if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){
	%>
	<td class='label' width="25%" id='chrg_unit_show_yn' style='visible:inline;'>
		<fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> 
	</td> 
	 <td class='fields' width="25%" id='pyble_unit_show_yn' style='visible:inline;' onkeypress="return checkSpecCharsforID(event);" >
	 <%if(modified_charge_units_DB.equals("")){%>
			<input type='text' class='fields' name='charge_units' id='charge_units' size='3' maxlength='3' onblur="onBlurHoldingAreaChrgUnitspayale(serv_code);" value='<%=modified_charge_units_DB%>' tabindex=-1>
			<b id='cashcounter_desc'></b>
			<%}else{%>
			<input type='text' class='fields' name='charge_units' id='charge_units' size='3' maxlength='3' value='<%=modified_charge_units_DB%>' disabled>
			<b id='cashcounter_desc'></b>
			<%}%>
	</td> 
<%}else{%>
		<td class='label' width="25%" id='chrg_unit_show_yn' style='visible:hidden;'></td>
		<td class='fields' width="25%" id='pyble_unit_show_yn' style='visible:hidden;'></td>
<%}%>

</tr>
<tr>
<td class='label'></td>
	<td class="gridData" colspan ='3' >
		<div id="charge_details" style='display:none;'>
		</div>
	</td>
</tr>
<%}else if(function_id_temp.equals("33")){ 
	//Added below lines for 25523 by Anitha on 12/16/2010
	checked_in_date_DB_disp=com.ehis.util.DateUtils.convertDate(checked_in_date_DB,"DMY","en",locale);
	checked_out_date_DB_disp=com.ehis.util.DateUtils.convertDate(checked_out_date_DB,"DMY","en",locale);

	%>

<tr>
	<td width='25%' colspan="4" class='CAGROUPHEADING'><fmt:message key="eOT.HoldingAreaDetails.Label" bundle="${ot_labels}"/> </td>
</tr>

<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> 
	</td> 
		<td class='fields' width="25%" >
			<input type='text' class='fields' name='check_in_date' id='check_in_date' size='8' value='<%=checked_in_date_DB_disp%>'  disabled> 
			<input type='text' class='fields' name='checked_in_date_time' id='checked_in_date_time' size='2'  value='<%=checked_in_time_DB%>' disabled>
		</td>
	<td  class='label' width="25%"> 
			<fmt:message key="eOT.HoldingBay.Label" bundle="${ot_labels}"/> 
	</td> 
	<td  class='fields' width="25%" > 
		<input type='hidden' name='holding_bay_code' id='holding_bay_code' value='<%=holding_area_code_DB%>'>
		<input type='text' class='fields' name='holding_bay_desc' id='holding_bay_desc' size='25'  value='<%=holding_area_desc_DB%>' disabled>
	</td>
</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.CheckedOutDateTime.Label" bundle="${ot_labels}"/> 
	</td> 
	<%if(!"".equals(checked_out_date_DB) && !"".equals(checked_out_time_DB)) {%>
	 <td class='fields' width="25%" >
			<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='<%=checked_out_date_DB_disp%>' disabled>
			<input type='text' class='fields' name='checked_out_date_time' id='checked_out_date_time' size='2'  value='<%=checked_out_time_DB%>' disabled>
	</td> 
	<%}else{%>
		 <td class='fields' width="25%" >
			<input type='text' class='fields' name='change_out_date' id='change_out_date' size='8'  value='<%=cur_date%>' disabled>
			<input type='text' class='fields' name='checked_out_date_time' id='checked_out_date_time' size='2'  value='<%=cur_time%>' disabled>
	</td> 

	<%}%>
	<%if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){%>
	<td class='label' width="25%" id='chrg_unit_show_yn' style='visible:inline;'>
		<fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> 
	</td> 
	 <td class='fields' width="25%" id='pyble_unit_show_yn' style='visible:inline;' >
			<input type='text' class='fields' name='charge_units' id='charge_units' size='3' maxlength='3'onkeypress="return checkSpecCharsforID(event);"  value='<%=modified_charge_units_DB%>' disabled>
			
	</td> 
	<%}else{%>
		<td class='label' width="25%"></td>
		<td class='label' width="25%"></td>
	<%}%>

</tr>
<%if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){%>
<tr>
<td class='label'></td>
	<td class="gridData" colspan ='3' >
		<div id="charge_details" style='visible:hidden;'>
		</div>
	</td>
</tr>
	<%}%>
<tr>
	<td width='25%' colspan="4" class='CAGROUPHEADING'><fmt:message key="eOT.ChangeHoldingBay.Label" bundle="${ot_labels}"/></td>
</tr>

<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> 
	</td> 
	<td class='fields' width="25%" >
				<input type='text' name='change_date' id='change_date' size='8' value='<%=cur_date%>'  readonly>
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar_loc_chk('change_date');"">
		<input type='text' name='change_date_time' id='change_date_time' size='2'  maxlength='5' value='<%=cur_time%>' onBlur='checkTimeFormat(this);checkInTimeChargeUnits(this);' onkeypress="return checkForSpecCharsforIDTime(event);">
		<img src='../../eCommon/images/mandatory.gif'></img> 
	</td>
	<td  class='label' width="25%"> 
			<fmt:message key="eOT.HoldingBay.Label" bundle="${ot_labels}"/> 
	</td> 
	<td  class='fields' width="25%" > 
			<input type='hidden' name='change_holding_code_1' id='change_holding_code_1'>
		<input type='text' class='fields' name='change_holding_desc_1' id='change_holding_desc_1' size='25'  value='' onBlur="if(this.value!='')searchChangeHoldingAreaBay(change_holding_code_1, change_holding_desc_1);">
		<input type='button' class='button' value='?' name='HoldingBayLookUp' id='HoldingBayLookUp' onClick='searchChangeHoldingAreaBay(change_holding_code_1, change_holding_desc_1);' >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.CheckedOutDateTime.Label" bundle="${ot_labels}"/> 
	</td> 
	 <%if("Y".equals(charge_hold_area_yn)) {%> <!--Added by lakshmi against change in holding area issue -->
	 <td class='fields' width="25%" >
				<input type='text' name='change_date_1' id='change_date_1' size='8' value=''  readonly>
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="shwCalendar_loc('change_date_1');">
		<input type='text' name='change_date_time_1' id='change_date_time_1' size='2'  maxlength='5' value='' onBlur=' if(document.forms[0].change_date_time_1.value!="")validateDtTime();' onkeypress="return checkForSpecCharsforIDTime(event);">
		<img id="change_hold_img" src='../../eCommon/images/mandatory.gif' style='position:absolute;visibility:visible'></img>	
		<!--<img src='../../eCommon/images/mandatory.gif'></img>-->
		</td>
		<%}else {%>
		<td>
		<input type='text' name='change_date_1' id='change_date_1' size='8' value=''  readonly>
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="shwCalendar_loc('change_date_1');">
		<input type='text' name='change_date_time_1' id='change_date_time_1' size='2'  maxlength='5' value='' onBlur=' if(document.forms[0].change_date_time_1.value!="")validateDtTime();' onkeypress="return checkForSpecCharsforIDTime(event);">		
	</td>
	<%}%>
<%if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){%>
	<td class='label' width="25%" id='chrg_unit_show_yn_1' style='visible:inline;'>
		<fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> 
	</td> 
	 <td class='fields' width="25%" id='pyble_unit_show_yn_1' style='visible:inline;'>
			<input type='text' class='fields' name='charge_units_1' id='charge_units_1' onkeypress="return checkSpecCharsforID(event);" onblur="getServPanelDtls(serv_code_1);" size='3' maxlength='3' value='' tabindex=-1>
		</td> 
	<%}else{%>
		<td class='label' width="25%"></td>
		<td class='label' width="25%"></td>
	<%}%>
	
</tr>
<%if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){%>
<tr>
<td class='label'></td>
	<td class="gridData" colspan ='3' >
		<div id="charge_details_1" style='visible:hidden;'>
		</div>
	</td>
</tr>
	<%}%>
<% } %>

<tr>
<td class="fields" width="25%"> </td>
<td class="fields" width="25%"> </td>
<td class="fields" width="25%"> </td>

	
</tr>
</table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='cur_date' id='cur_date' value='<%=cur_date%>'>
<input type='hidden' name='cur_time' id='cur_time' value='<%=cur_time%>'>
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=slate_user_id%>'>
<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='size' id='size' value='<%=size%>'>
<input type='hidden' name='holding_bay_size' id='holding_bay_size' value='<%=size%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='booking_num' id='booking_num' value='<%=booking_num%>'>
<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
<input type='hidden' name='oper_code' id='oper_code' value='<%=oper_code%>'>
<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
<input type='hidden' name='chargable_amt' id='chargable_amt' value='<%=chargable_amt%>'>
<input type='hidden' name='inventry_chk_yn_DB' id='inventry_chk_yn_DB' value='<%=inventry_chk_yn%>'>
<input type='hidden' name='charge_hold_area_yn_DB' id='charge_hold_area_yn_DB' value='<%=charge_hold_area_yn%>'>
<input type='hidden' name='calc_chrge_units' id='calc_chrge_units' value=''>
<input type='hidden' name='panel_str' id='panel_str' value=''>
<input type='hidden' name='bl_panel_str' id='bl_panel_str' value=''>
<input type='hidden' name='calc_chrge_units_1' id='calc_chrge_units_1' value=''>
<input type='hidden' name='accession_num' id='accession_num' value=''>
<input type='hidden' name='accession_num_1' id='accession_num_1' value=''>
<input type='hidden' name='function_id_temp' id='function_id_temp' value='<%=function_id_temp%>'>
<input type='hidden' name='bill_acc_num_DB' id='bill_acc_num_DB' value='<%=bill_acc_num_DB%>'>
<input type='hidden' name='checked_in_date_DB' id='checked_in_date_DB' value='<%=checked_in_date_DB%>'>
<input type='hidden' name='checked_in_time_DB' id='checked_in_time_DB' value='<%=checked_in_time_DB%>'>
<input type='hidden' name='checked_out_date_DB' id='checked_out_date_DB' value='<%=checked_out_date_DB%>'>
<input type='hidden' name='checked_out_time_DB' id='checked_out_time_DB' value='<%=checked_out_time_DB%>'>
<input type='hidden' name='holding_area_code_DB' id='holding_area_code_DB' value='<%=holding_area_code_DB%>'>
<input type='hidden' name='modified_charge_units_DB' id='modified_charge_units_DB' value='<%=modified_charge_units_DB%>'>
<input type='hidden' name='calc_chargeable_units_DB' id='calc_chargeable_units_DB' value='<%=calc_chargeable_units_DB%>'>
<input type='hidden' name='bill_accession_num' id='bill_accession_num' value='<%=oper_num_with_hb%>'>
<input type='hidden' name='bill_acc_num_add' id='bill_acc_num_add' value='<%=bill_acc_temp%>'>
<input type='hidden' name='service_code' id='service_code' value=''>
<input type='hidden' name='service_code_1' id='service_code_1' value=''>
<input type='hidden' name='hold_area_chrging_stg' id='hold_area_chrging_stg' value=''>
<input type='hidden' name='chk_holding_area_chrg_yn_stg' id='chk_holding_area_chrg_yn_stg' value=''>
<input type='hidden' name='include_exclude' id='include_exclude' value=''>
<input type='hidden' name='appr_reqd_val' id='appr_reqd_val' value=''>
<input type='hidden' name='inc_exe_blng_wdw' id='inc_exe_blng_wdw' value=''>
<input type='hidden' name='reason_inc_exc' id='reason_inc_exc' value=''>
<input type='hidden' name='hide_hold_bay_1' id='hide_hold_bay_1' value=''>
<input type='hidden' name='holding_seq_num_DB' id='holding_seq_num_DB' value='<%=holding_seq_num_DB%>'>


</form>


</body>
</html>


