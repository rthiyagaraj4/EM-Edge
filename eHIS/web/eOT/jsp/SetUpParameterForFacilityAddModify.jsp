<!DOCTYPE html>
<%@ page import ="java.util.HashMap,eOT.SetUpParamForFacilityBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getAttribute("facility_id");
	
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	
	</script>
</head>
<body onload='enabletime();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%  
		String bean_id = "SetUpParamForFacilityBean";
		String bean_name = "eOT.SetUpParamForFacilityBean";
		SetUpParamForFacilityBean bean = (SetUpParamForFacilityBean) mh.getBeanObject( bean_id, request, bean_name );
		String  empty = "".intern();
		String	unit_ot_time=empty;
		String	start_ot_booking_time=empty;
		String	end_ot_booking_time=empty;
		String	start_hol_book_time=empty;
		String	end_hol_book_time=empty;
		String	print_booking_slip=empty;
		String	ot_sec1_notice_fm_time=empty;
		String	ot_sec1_notice_to_time=empty;
		String	ot_sec2_notice_fm_time=empty;
		String	ot_sec2_notice_to_time=empty;
		String	ot_sec3_notice_fm_time=empty;
		String	ot_sec3_notice_to_time=empty;
		String	next_booking_num=empty;
		String	max_booking_num=empty;
		String	next_waitlist_num=empty;
		String	max_waitlist_num=empty;
		String	next_oper_num_ip=empty;
		String	max_oper_num_ip=empty;
		String	next_oper_num_op=empty;
		String	max_oper_num_op=empty;
		//CRF 298
		String multiFacility = empty;
		HashMap map=new HashMap();
		String	tab_id="MainPage";
		String  mode=bean.getMode();
		String  restrict_theatre_booking_yn=empty;
		map=(session.getAttribute(tab_id)!=null)?(HashMap)session.getAttribute(tab_id):bean.getQueryDtls(tab_id,facility_id);
//		map=(session.getAttribute(tab_id)!=null)?bean.getQueryDtls(tab_id,facility_id):bean.getQueryDtls(tab_id,facility_id);
		String session_facility_id=(String) map.get("facility_id");
		
		if(!facility_id.equals(session_facility_id)){
			map=bean.getQueryDtls(tab_id,facility_id);
		}
		
		if( ("UPDATE".equals(mode) || "INSERT".equals(mode)) ){
			unit_ot_time			=(String) map.get("unit_ot_time");           
			start_ot_booking_time	=(String) map.get("start_ot_booking_time");  
			end_ot_booking_time		=(String) map.get("end_ot_booking_time");    
			start_hol_book_time		=(String) map.get("start_hol_book_time");    
			end_hol_book_time		=(String) map.get("end_hol_book_time");      
			print_booking_slip		=(String) map.get("print_booking_slip");     
			ot_sec1_notice_fm_time	=(String) map.get("ot_sec1_notice_fm_time"); 
			ot_sec1_notice_to_time	=(String) map.get("ot_sec1_notice_to_time"); 
			ot_sec2_notice_fm_time	=(String) map.get("ot_sec2_notice_fm_time"); 
			ot_sec2_notice_to_time	=(String) map.get("ot_sec2_notice_to_time");
			ot_sec3_notice_fm_time	=(String) map.get("ot_sec3_notice_fm_time");
			ot_sec3_notice_to_time	=(String) map.get("ot_sec3_notice_to_time");
			next_booking_num		=(String) map.get("next_booking_num");      
			max_booking_num			=(String) map.get("max_booking_num");       
			next_waitlist_num		=(String) map.get("next_waitlist_num");			
			max_waitlist_num		=(String) map.get("max_waitlist_num");      
			next_oper_num_ip		=(String) map.get("next_oper_num_ip");      
			max_oper_num_ip			=(String) map.get("max_oper_num_ip");       
			next_oper_num_op		=(String) map.get("next_oper_num_op");      
			max_oper_num_op			=(String) map.get("max_oper_num_op");       
			restrict_theatre_booking_yn	=(String) map.get("restrict_theatre_booking_yn");       
			//CRF 298
			multiFacility	=(String) map.get("multi_facility");
			if(multiFacility != null && multiFacility.equals("Y"))
			{
				multiFacility = "checked";
			}
			else
			{
				multiFacility = "";
			}
		}

		
		String checked = ( "Y".equals(print_booking_slip) )?"checked":"";
		String checked1 = ( "Y".equals(restrict_theatre_booking_yn) )?"checked":"";
		String disable_flag = "UPDATE".equals(mode)?"disabled":"";
		//CRF 298
		boolean showAltFacChkBox = bean.fetchCustomerId();
%>
<form name="SetUpParameterForFacilityForm" id="SetUpParameterForFacilityForm"  onload='FocusFirstElement();'  target="messageFrame"> 
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align=center id='t' >
<!-- Page formated By yadav -->
<tr>
		<td width="100%" class="BORDERX">
				<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
					<td class=label width='25%'>
						<fmt:message key="eOT.UnitTimeforBooking.Label" bundle="${ot_labels}"/>
					</td>
					<td class=label width='25%'>
<%
	if(unit_ot_time.equals(""))
	{
%>
						<input type="text" name="unit_ot_time" id="unit_ot_time" value="<%=unit_ot_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)">
						<img src='../../eCommon/images/mandatory.gif'>
<%
	}else{
%>				
						<input type="text" name="unit_ot_time" id="unit_ot_time" value="<%=unit_ot_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)" disabled>
						<img src='../../eCommon/images/mandatory.gif'>
<%
	}
%>								
					</td>
					 
<%
	//CRF 298
	if(showAltFacChkBox)
	{
%>					
					<td class=label width='30%' >
						<fmt:message key="eOT.MultiFacility.Label" bundle="${ot_labels}"/>
					</td>
					<td width='25%' class=label>
						<input type="checkbox" name="multi_facility" id="multi_facility"  value="Y" <%=multiFacility %>>
					</td>
<%
	}else{
%>			
					<td width='25%'></td>
					<td width='25%'></td>
<%
	}
%>				
				</table>
			</td>
</tr>

<tr>
	<td>
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<tr>
			 <td class='COLUMNHEADERCENTER' width='100%'>
				<fmt:message key="Common.BookingTime.label" bundle="${common_labels}"/>
			</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td width="100%" class="BORDERX">
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<td class=label width='25%'>
			<fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/>
			<fmt:message key="Common.Start.label" bundle="${common_labels}"/>
			</td>
			<td class=label width='25%'>
			<input type="text" name="start_ot_booking_time" id="start_ot_booking_time" value="<%=start_ot_booking_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)">
			-
			<input type="text" name="end_ot_booking_time" id="end_ot_booking_time" value="<%=end_ot_booking_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)">
			</td>
			<td class=label width='25%'>
			<fmt:message key="Common.Holiday.label" bundle="${common_labels}"/>
			<fmt:message key="Common.Start.label" bundle="${common_labels}"/>
			</td>
			<td class=label width='25%'>
			<input type="text" name="start_hol_book_time" id="start_hol_book_time" value="<%=start_hol_book_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)">
			-
			<input type="text" name="end_hol_book_time" id="end_hol_book_time" value="<%=end_hol_book_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)">
			</td>
			
		</table>	
	</td>
</tr>

<tr>
	<td width="100%" class="BORDERX">
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<!-- Commented by rajesh according to bavani's instruction on 14/11/07 -->
			<!-- <td class=label width='50%'>
			<fmt:message key="eOT.PrintBookingSlipOnConfirmation.Label" bundle="${ot_labels}"/>
			<input type="checkbox" class='fields' name="print_booking_slip" id="print_booking_slip" value="<%=print_booking_slip%>" <%=checked%> onclick="setChkBoxValue(this);" >
			</td> -->
			<td class=label width='25%'>
			<fmt:message key="eOT.RestrictTheatreBooking.Label" bundle="${ot_labels}"/>
			</td>
			<td class=label width='25%'>
			<input type="checkbox" class='fields' name="restrict_theatre_booking_yn" id="restrict_theatre_booking_yn" value="<%=restrict_theatre_booking_yn%>"<%=checked1%>  onclick="setChkBoxValue(this);" >
			</td>
			<td class=label width='25%'></td>
			<td class=label width='25%'></td>
		</table>
	</td>
</tr>

<tr>
	<td>
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<tr>
			 <td class='COLUMNHEADERCENTER' width='100%'>
			 <fmt:message key="eOT.OTNotificationWithinADay.Label" bundle="${ot_labels}"/>
			 </td>
			</tr>
		</table>
	</td>
</tr>

<tr>
	<td width="100%" class="BORDERX">
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<td class=label width='25%'>
			<fmt:message key="eOT.Section1.Label" bundle="${ot_labels}"/>
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td class=label width='25%'>
			<input type="text" name="ot_sec1_notice_fm_time" id="ot_sec1_notice_fm_time" value="<%=ot_sec1_notice_fm_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="if(this.value!='')isValidTime(this);chkTimeSec11()"> 
			<fmt:message key="Common.to.label" bundle="${common_labels}"/> 
			<input type="text" name="ot_sec1_notice_to_time" id="ot_sec1_notice_to_time" value="<%=ot_sec1_notice_to_time%>"  size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="if(document.forms[0].ot_sec1_notice_fm_time.value!='')isValidTime(this);chkTimeSec1()"> 
			</td>
			<td class=label width='25%'>
			<fmt:message key="eOT.Section2.Label" bundle="${ot_labels}"/>
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td class=label width='25%'>
			<input type="text" name="ot_sec2_notice_fm_time" id="ot_sec2_notice_fm_time" value="<%=ot_sec2_notice_fm_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="if(this.value!='')isValidTime(this); chkfrmtime4();">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			<input type="text" name="ot_sec2_notice_to_time" id="ot_sec2_notice_to_time" value="<%=ot_sec2_notice_to_time%>"  size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="if(document.forms[0].ot_sec2_notice_fm_time.value!='')isValidTime(this);chktotimesec2();chkTimeSec2(); ">
			</td>
		</table>
	</td>
</tr>

<tr>
	<td width="100%" class="BORDERX">
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<td class=label width='25%'>
			<fmt:message key="eOT.Section3.Label" bundle="${ot_labels}"/>
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td class=label width='25%'>
			<input type="text" name="ot_sec3_notice_fm_time" id="ot_sec3_notice_fm_time" value="<%=ot_sec3_notice_fm_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this);chkfrmtime5();">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			<input type="text" name="ot_sec3_notice_to_time" id="ot_sec3_notice_to_time" value="<%=ot_sec3_notice_to_time%>" size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this);chkTimeSec3();">
			</td>
			<td></td>	
		</table>
	</td>
</tr>

<tr>
            <td>
                <table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
                    <tr >
                       <td class="COLUMNHEADERCENTER" width="25%" colspan="2" >
							<fmt:message key="eOT.BookingNumbering.Label" bundle="${ot_labels}"/>
                        </td>
                        <td class="COLUMNHEADERCENTER" width="25%" colspan="2" >
								<fmt:message key="eOT.WaitListNumbering.Label" bundle="${ot_labels}"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
<tr>
    <td></td>
 </tr>

		
 <tr>
	<td width="100%" class="BORDERX">
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
		<tr>
			<td class=label width="25%">
				<fmt:message key="eOT.NextNo.Label" bundle="${ot_labels}"/>
				</td>
				<td class=label width='25%'>
				<input type='textbox' name='next_booking_num' id='next_booking_num' value="<%=next_booking_num%>" size='5' maxlength='8' <%=disable_flag%>> 
					<img src='../../eCommon/images/mandatory.gif'>     
				<fmt:message key="eIP.MaxNo.label" bundle="${ip_labels}"/>
				<input type='textbox' name='max_booking_num' id='max_booking_num' value="<%=max_booking_num%>" size=5  onkeypress="return checkForSpecChars(event);" onblur="CheckForPositiveNumber(this);" maxlength='8'>
					<img src='../../eCommon/images/mandatory.gif'>     
			</td>
								  
			<td  class=label width="25%" >
				<fmt:message key="eOT.NextNo.Label" bundle="${ot_labels}"/>
			</td>
			<td class=label width='25%'>
				<input type='textbox' name='next_waitlist_num' id='next_waitlist_num' value="<%=next_waitlist_num%>" size='5' maxlength='8' <%=disable_flag%>>
					<img src='../../eCommon/images/mandatory.gif'>     
				<fmt:message key="eIP.MaxNo.label" bundle="${ip_labels}"/>
				<input type='textbox' name='max_waitlist_num' id='max_waitlist_num' value="<%=max_waitlist_num%>" size=5 onkeypress="return checkForSpecChars(event);" onblur="CheckForPositiveNumber(this);"maxlength='8'>
					<img src='../../eCommon/images/mandatory.gif'>     
			</td>
		</tr>
		</table>
	</td>
</tr>

<tr>
	<td>
		<table border='0' cellpadding=3  cellspacing='0' width='100%'>
			<tr>
                <td class="COLUMNHEADERCENTER" width="25%" colspan="2" >
					<fmt:message key="eOT.OperationNumberingIPDC.Label" bundle="${ot_labels}"/>
				</td>
				<!--<td class="COLUMNHEADER" width="15%" align="left"></td>
				<td class="COLUMNHEADER" width="25%" align="left"></td>-->
                <td class="COLUMNHEADERCENTER" width="25%" colspan="2" >
					<fmt:message key="eOT.OperationNumberingOPEM.Label" bundle="${ot_labels}"/>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
         <td></td>
</tr>
<tr>
	<td width="100%" class="BORDERX">
		<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
			<tr>
			   
				<td class=label width="25%">
					<fmt:message key="eOT.NextNo.Label" bundle="${ot_labels}"/>
				</td>
				<td class=label width='25%'>
					<input type='textbox' name='next_oper_num_ip' id='next_oper_num_ip' value="<%=next_oper_num_ip%>" size='5' maxlength='8' <%=disable_flag%> >
						<img src='../../eCommon/images/mandatory.gif'>     
					<fmt:message key="eIP.MaxNo.label" bundle="${ip_labels}"/>
					<input type='textbox' name='max_oper_num_ip' id='max_oper_num_ip' value="<%=max_oper_num_ip%>" size='5' maxlength='8' onkeypress="return checkForSpecChars(event);" onblur="CheckForPositiveNumber(this);"maxlength='8'>
						<img src='../../eCommon/images/mandatory.gif'>     
				</td>
				
				<td  class=label width="25%">
					<fmt:message key="eOT.NextNo.Label" bundle="${ot_labels}"/>
				</td>
				<td class=label width='25%'>
					<input type='textbox' name='next_oper_num_op' id='next_oper_num_op' value="<%=next_oper_num_op%>" size='5' maxlength='8' <%=disable_flag%> >
						<img src='../../eCommon/images/mandatory.gif'>     
					<fmt:message key="eIP.MaxNo.label" bundle="${ip_labels}"/>
					<input type='textbox' name='max_oper_num_op' id='max_oper_num_op' value="<%=max_oper_num_op%>" size=5 onkeypress="return checkForSpecChars(event);" onblur="CheckForPositiveNumber(this);"maxlength='8'>
						<img src='../../eCommon/images/mandatory.gif'>     
				</td>
			</tr>
		</table>
	</td>
</tr>

</table>

	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="tab_id" id="tab_id" value="<%=tab_id%>">
	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
	<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
</form>
</body>
</html>


