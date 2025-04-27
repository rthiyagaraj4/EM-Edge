<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import= "eOT.ChkOutFromORBean,java.sql.Connection,java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
<script language="Javascript" src="../../eCommon/js/common.js" ></script>
<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/CheckOutFromOR.js"></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String) session.getAttribute("facility_id");
	Connection conn=null;
	Statement stmt = null ;
	Statement stmt1 = null ;
	ResultSet resultSet			= null ;
	ResultSet resultSet1			= null ;
	String current_date	= "",current_time	= "",current_date_time= "",charge_operating_room_yn= "",bl_interface_flag= "",current_date_time_db="",current_time_db="";
	String multi_check_in_yn="";//PMG2016-KDAH-CRF-0001
	try
	{
		conn	= ConnectionManager.getConnection(request);
		}catch(Exception e){
			System.err.println("Err in ChkOutFromOR.jsp ----> "+e);
			e.printStackTrace();
		}
		finally{
			try{
					if(resultSet!=null) resultSet.close();
					if(stmt!=null) stmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception es){
					es.printStackTrace();
				}
		}
	
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String anaesthesia_doc_comp_yn = CommonBean.checkForNull(request.getParameter("anaesthesia_doc_comp_yn"));
	String called_from		= CommonBean.checkForNull(request.getParameter("called_from"));
	String slate_user_id	= CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String oper_num			= CommonBean.checkForNull(request.getParameter("oper_num"));
	String order_id			= CommonBean.checkForNull(request.getParameter("order_id"));
	String module_id		= CommonBean.checkForNull(request.getParameter("module_id"));
	String patient_id		= CommonBean.checkForNull(request.getParameter("patient_id"));
	String oper_code		= CommonBean.checkForNull(request.getParameter("oper_code"));
	String surgeon_code		= CommonBean.checkForNull(request.getParameter("surgeon_code"));
	String mode	= CommonBean.checkForNull(request.getParameter("mode"));
	mode = CommonRepository.getCommonKeyValue("MODE_INSERT");
	String role_id_1		= "",role_id_2		= "",role_id_3		= "",role_id_4		= "",verify_checklist_codes="",old_post_oper_user1_id	= "",old_post_oper_user2_id	= "",old_post_oper_user3_id	= "",old_post_oper_user4_id	= "";
	String booking_num		= CommonBean.checkForNull(request.getParameter("booking_num"));
	String speciality_code	= CommonBean.checkForNull(request.getParameter("speciality_code"),"");
	String checklist_completed_yn = "N";
	String post_oper_user1_completed_yn = "N";
	String post_oper_user2_completed_yn = "N";
	String post_oper_user3_completed_yn = "N";
	String post_oper_user4_completed_yn = "N";
	String check_for_check_list_compl = "N";
	String no_of_verifications = "1";
	String bean_id = "ChkOutFromORBean";
	String bean_name = "eOT.ChkOutFromORBean";

	String check_in_recovery_time = "",cur_date="",cur_time="",doc_comp_yn="",chk_into_or="",episode_id="",episode_type="",visit_id="",oper_room_desc="",oper_rm_chk_yn="",patient_class="",bl_episode_type="",oper_room_code="",customer_id="",chk_into_or_beforeConvert="";
	// customer_id added against for MO-GN-5505 [IN058517]

	try
	{
		conn	= ConnectionManager.getConnection(request);
		stmt	= conn.createStatement() ;
		stmt1	= conn.createStatement() ;

		String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
		resultSet			= stmt.executeQuery(sql_curr_date);

		if(resultSet!=null && resultSet.next()){
			current_time_db = resultSet.getString("CUR_DATE");
			//current_time_db = resultSet.getString("CUR_TIME");
			current_date=checkForNull(com.ehis.util.DateUtils.convertDate(resultSet.getString("CUR_DATE"),"DMY","en",locale));
			current_time=resultSet.getString("CUR_TIME");
			//current_time = resultSet.getString("CUR_TIME");
			current_date_time_db = com.ehis.util.DateUtils.convertDate(resultSet.getString("CURRENT_DATE_TIME"),"DMYHM","en",locale);
			current_date_time=com.ehis.util.DateUtils.convertDate(resultSet.getString("CURRENT_DATE_TIME"),"DMYHM","en",locale);
		}

		String sql_param_check="SELECT BL_INTERFACE_FLAG,CHARGE_OPERATING_ROOM_YN,MULTI_CHECK_IN_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";//PMG2016-KDAH-CRF-0001
		resultSet			= stmt.executeQuery(sql_param_check);

		if(resultSet!=null && resultSet.next()){
				bl_interface_flag = resultSet.getString("BL_INTERFACE_FLAG");
				charge_operating_room_yn = resultSet.getString("CHARGE_OPERATING_ROOM_YN");
				multi_check_in_yn=resultSet.getString("MULTI_CHECK_IN_YN");//PMG2016-KDAH-CRF-0001
		}

		String sql_chk_in_or="SELECT A.EPISODE_ID EPISODE_ID,A.EPISODE_TYPE EPISODE_TYPE,A.VISIT_ID VISIT_ID,TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,A.OPER_ROOM_CODE, (SELECT SHORT_DESC FROM OT_OPER_ROOM WHERE OPER_ROOM_CODE=A.OPER_ROOM_CODE) OPER_ROOM_DESC, A.PATIENT_CLASS PATIENT_CLASS FROM OT_POST_OPER_HDR A WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"' ";

		resultSet1			= stmt1.executeQuery(sql_chk_in_or);
		if(resultSet1!=null && resultSet1.next()){
			chk_into_or_beforeConvert = CommonBean.checkForNull(resultSet1.getString("CHECK_INTO_OR_TIME")); //Added Against SKR-SCF-1288
			chk_into_or=checkForNull(com.ehis.util.DateUtils.convertDate(resultSet1.getString("CHECK_INTO_OR_TIME"),"DMYHM","en",locale));
			oper_room_code = CommonBean.checkForNull(resultSet1.getString("OPER_ROOM_CODE"));
			episode_id = CommonBean.checkForNull(resultSet1.getString("EPISODE_ID"));
			episode_type = CommonBean.checkForNull(resultSet1.getString("EPISODE_TYPE"));
			visit_id = CommonBean.checkForNull(resultSet1.getString("VISIT_ID"));
			oper_room_desc = CommonBean.checkForNull(resultSet1.getString("OPER_ROOM_DESC"));
			patient_class = CommonBean.checkForNull(resultSet1.getString("PATIENT_CLASS"));
		}

		if(resultSet1!=null) resultSet1.close();

		String sql_chk_eps_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";

		resultSet1			= stmt1.executeQuery(sql_chk_eps_type);
		if(resultSet1!=null && resultSet1.next()){
			bl_episode_type= CommonBean.checkForNull(resultSet1.getString("bl_episode_type"));	
		}

		if(resultSet1!=null) resultSet1.close();

		String sql_oper_room_chrg_yn="SELECT CHARGEABLE_YN FROM OT_OPER_ROOM_LANG_VW WHERE OPER_ROOM_CODE='"+oper_room_code+"' AND LANGUAGE_ID='"+locale+"'";
			resultSet1		= stmt1.executeQuery(sql_oper_room_chrg_yn);
			if(resultSet1!=null && resultSet1.next()){
				oper_rm_chk_yn = CommonBean.checkForNull(resultSet1.getString("CHARGEABLE_YN"));
			}
		/* Added start against for MO-GN-5505 [IN058517] */
		if(resultSet1!=null) resultSet1.close();
		
		String sql_customer_id="SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE ROWNUM = 1";
		resultSet1		= stmt1.executeQuery(sql_customer_id);
		if(resultSet1!=null && resultSet1.next()){
				customer_id = CommonBean.checkForNull(resultSet1.getString("CUSTOMER_ID"));
			}
		/* Added end against for MO-GN-5505 [IN058517] */
				
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;

		ChkOutFromORBean bean = (ChkOutFromORBean)getBeanObject( bean_id,bean_name,request);
		bean.clear();

		String list[] =  bean.getAllDocumentionReqdYN(facility_id);
		
		surgeon_doc_comp_yn=("N"==list[0].intern() )?"Y":surgeon_doc_comp_yn;
		nursing_doc_comp_yn=("N"==list[1].intern() )?"Y":nursing_doc_comp_yn;
		anaesthesia_doc_comp_yn=("N"==list[2].intern() )?"Y":anaesthesia_doc_comp_yn;
		
		String anaesthesia_eval_reqd_yn = bean.getAnaesthesiaApplicableYN(order_id);
		if("N".equals(anaesthesia_eval_reqd_yn)){
			doc_comp_yn=( surgeon_doc_comp_yn.equals("Y") && nursing_doc_comp_yn.equals("Y") )?"Y":"N";
		}else{
			doc_comp_yn=( surgeon_doc_comp_yn.equals("Y") && nursing_doc_comp_yn.equals("Y") &&  "Y".equals(anaesthesia_doc_comp_yn) )?"Y":"N";
		}

		ArrayList timeList = bean.getSysDateTime();
		cur_date= (String) timeList.get(1);
		cur_time = (String) timeList.get(2);
		bean.loadDisposalDtls(locale,facility_id,oper_num);
		check_for_check_list_compl = bean.getCheckListReqdYNFlag(locale,"23");	
		order_id			= CommonBean.checkForNull(request.getParameter("order_id"),"");

		int no_of_verifications_int = 1;

		ArrayList verify_checklist_arr = null;
		ArrayList user_info_arr = null;

		verify_checklist_arr	= new ArrayList();
		user_info_arr			= new ArrayList();

		verify_checklist_arr = bean.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
		if(verify_checklist_arr.size()>0){
			verify_checklist_codes=(String)verify_checklist_arr.get(0);
			no_of_verifications = (String)verify_checklist_arr.get(1);
			no_of_verifications=no_of_verifications==null?"1":no_of_verifications;
			no_of_verifications=no_of_verifications.equalsIgnoreCase("null")?"1":no_of_verifications;
			no_of_verifications=no_of_verifications.equals("null")?"1":no_of_verifications;
			no_of_verifications_int = Integer.parseInt(no_of_verifications);
			role_id_1 = (String)verify_checklist_arr.get(2);
			role_id_2 = (String)verify_checklist_arr.get(3);
			role_id_3 = (String)verify_checklist_arr.get(4);
			role_id_4 = (String)verify_checklist_arr.get(5);
		}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			no_of_verifications_int = 1;
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
		}
		user_info_arr = (ArrayList)bean.getUserInfo(facility_id,booking_num,oper_num,"1",order_id);
		if(user_info_arr.size()>0){
			post_oper_user1_completed_yn = (String)user_info_arr.get(9);
			post_oper_user2_completed_yn = (String)user_info_arr.get(11);
			post_oper_user3_completed_yn = (String)user_info_arr.get(13);
			post_oper_user4_completed_yn = (String)user_info_arr.get(15);

			old_post_oper_user1_id		 = (String)user_info_arr.get(8);
			old_post_oper_user2_id		 = (String)user_info_arr.get(10);
			old_post_oper_user3_id		 = (String)user_info_arr.get(12);
			old_post_oper_user4_id		 = (String)user_info_arr.get(14);

			if(no_of_verifications_int==1){
				if(post_oper_user1_completed_yn.equals("Y"))
					checklist_completed_yn		 = "Y";
				else
					checklist_completed_yn		 = "N";
			}else if(no_of_verifications_int==2){ 
				if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y"))
					checklist_completed_yn		 = "Y";
				else
					checklist_completed_yn		 = "N";
			}else if(no_of_verifications_int==3){ 
				if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y"))
					checklist_completed_yn		 = "Y";
				else
					checklist_completed_yn		 = "N";
			}else if(no_of_verifications_int==4){ 
				if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y") && post_oper_user4_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			}else
				checklist_completed_yn		 = "N";
			}else{
				old_post_oper_user1_id		 = "";
				old_post_oper_user2_id		 = "";
				old_post_oper_user3_id		 = "";
				checklist_completed_yn		 = "N";
			}
		
		}catch(Exception e){
			System.err.println("Err in ChkOutFromOR.jsp ----> "+e);
			e.printStackTrace();
		}
	finally{
		try{
				if(resultSet1!=null) resultSet1.close();
				if(stmt1!=null) stmt1.close();
				ConnectionManager.returnConnection(conn,request);
			}catch(Exception es){
				es.printStackTrace();
			}
	}
	// till here
	// End of Verify CheckList Logic	
%>
	<%if(bl_interface_flag.equals("Y") && charge_operating_room_yn.equals("Y") && oper_rm_chk_yn.equals("Y")){%>
		<body onload='assignLegend();callChargableUnits();'OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<%}else{%>
		<body onload='assignLegend();'OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<%}%>
<form name='CheckOutFromORForm' id='CheckOutFromORForm'>
<table border='0' cellpadding='0' cellspacing='0' width='100%'>
	<tr>
		<td colspan="8" class='CAGROUPHEADING'>
			<fmt:message key="eOT.CheckOutFromOR.Label" bundle="${ot_labels}"/>
		</td> 
	</tr>
	<tr>
		<td colspan="6" class='CAGROUPHEADING'></td> 
	</tr>
	<tr>
		<td class='label' width='8%'>
			<fmt:message key="Common.CheckOut.label" bundle="${common_labels}"/> &nbsp;
		</td>
		<td class='label' width='25%'>
			<input type='checkbox' name='check_out' id='check_out' onClick='validateCheckBox();'>
			<input type='hidden' name='check_out_time' id='check_out_time' size='3' maxlength='3' >
		</td>

		<td class='label' width='15%'>
			<fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/>
		</td> 
		<td >
			<select name="transfer" id="transfer" onchange="disableWardAndStatus(); assignLegend();" >
			<option value='W'><fmt:message key="Common.Ward.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="eOT.Mortuary.Label" bundle="${ot_labels}"/></option>
			<option value='R'><fmt:message key="eOT.RecoveryRoom.Label" bundle="${ot_labels}"/></option>
		<!-- Added by Muthukumar on 06-02-12 -->
			<option value='H'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
		<!-- Added by Muthukumar on 06-02-12 -->
			</select>&nbsp;
				<img id="img1" src='../../eCommon/images/Blank1.gif' >
		</td>

		<td class='label' ></td> 
		<td class='label' align='right' id="test"><fmt:message key="Common.Ward.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class='label' align='left' nowrap>
			<input type='hidden' name='ward_code' id='ward_code' value='' >
			<!-- ML-MMOH-CRF-0752.3-US001 -->
			<input type='text' name='ward_desc' id='ward_desc' id='hidedesc' size='36' onBlur="if(this.value!='')srchCommonCode(ward_code,ward_desc,transfer.options[transfer.selectedIndex].text,document.forms[0].qry_sql.value);else ward_code.value='' ">
			<input type='button' class='button' value='?' name='CommonLookUp1' id='CommonLookUp1' id='hidelookup'onClick="srchCommonCode(ward_code,ward_desc,transfer.options[transfer.selectedIndex].text,document.forms[0].qry_sql.value);" >
			<img id="img2" src='../../eCommon/images/Blank1.gif' >
		</td>
	</tr>
	<tr>
			<td class='label' align='right' nowrap><fmt:message key="eOT.CheckinToORDateTime.Label" bundle="${ot_labels}"/></td> 
			<td align='left' nowrap>
				<input type='text' name='check_in_dt_time' id='check_in_dt_time' size='15'  value='<%=chk_into_or%>' disabled>
			</td>

			<td class='label' align='right' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td align='left' nowrap width>
				<select name="status" id="status"  >
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='I'><fmt:message key="eOT.Intubated.Label" bundle="${ot_labels}"/></option>
					<option value='E'><fmt:message key="eOT.Extubated.Label" bundle="${ot_labels}"/></option>
				</select>				
				</td>
	</tr>
	<tr>

	<!-- Modified by DhanasekarV against issue IN026657 -->
			<td class='label' align='right' nowrap><fmt:message key="eOT.CheckOutFromORDateTime.Label" bundle="${ot_labels}"/></td> 
			<td align='left' nowrap>
				<!--input type='text' name='check_out_date' size='10' maxlength='10' value='<%=current_date%>' onblur="if(validateDate(check_out_date)==true && document.forms[0].check_out_date.value!='') validateDateTime();" onkeypress="return checkForSpecCharsforID(event);" -->
				<input type='text' name='check_out_date' id='check_out_date' size='10' maxlength='10' value='<%=current_date%>' onblur="if(isValidDate(check_out_date)==true && document.forms[0].check_out_date.value!='') validateDateTime();" onkeypress="return checkForSpecCharsforID(event);" ><!--Modified Against SKR-SCF-1288-->
				<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('check_out_date'); ">
				<input type='text' name='check_out_time_or' id='check_out_time_or' size='4' tabindex='0' maxlength='6' onkeypress="return checkSpecCharsforID(event);" value='<%=current_time%>' onBlur='if(document.forms[0].check_out_date.value!="")validateDateTime(); '>
				<img id="img3" src='../../eCommon/images/Blank1.gif' >					
			</td>
	<%if(bl_interface_flag.equals("Y") && charge_operating_room_yn.equals("Y") && oper_rm_chk_yn.equals("Y")){%>
			<td class='label' tabindex='2' width="25%" id='pyble_unit_show_yn_td'>
				<fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> 
			</td> 
			 <td class='fields' width="25%" id='pyble_unit_show_yn' style='visible:inline;'>
					<input type='text' class='fields' name='charge_units' id='charge_units' size='3'  maxlength='3' value='' onblur="if(document.forms[0].check_out_time_or.value!='')onBlurGetServPanelDtls(charge_units, serv_code);" onkeypress="return checkForSpecCharsforID(event);" tabindex=-1 disabled> <!--Modified Against SKR-SCF-1522-->
					<b id='cashcounter_desc'></b>
			</td> 
	<%}else{%>
			<td class='label' width="25%" id='pyble_unit_show_yn_td'></td> 
			 <td class='fields' width="25%" id='pyble_unit_show_yn' style='visible:inline;' ></td> 
	<%}%>
	</tr>
	<%if(bl_interface_flag.equals("Y") && charge_operating_room_yn.equals("Y") && oper_rm_chk_yn.equals("Y")){%>
	<tr>
		<td class='label'></td>
			<td class="gridData" colspan ='3' >
				<div id="charge_details_1" style='visible:hidden;display:none'>
				</div>
		</td>
	</tr>
	<% } %>
</table>
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
	<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
	<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >	
	<input type='hidden' name='doc_comp_yn' id='doc_comp_yn' value='<%=doc_comp_yn%>' >	
	<input type='hidden' name='check_out_flag' id='check_out_flag' value='N' >	
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' >
	<input type='hidden' name='slate_user_id' id='slate_user_id' value="<%=slate_user_id%>">
	<input type='hidden' name="order_id" id="order_id" value="<%=order_id%>">
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>' >
	<input type='hidden' name='booking_num' id='booking_num' value='<%=booking_num%>' >
	<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>' >
	<input type='hidden' name='current_date_time_db' id='current_date_time_db' value='<%=current_time_db%>' >
	<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>' >
	<input type='hidden' name='oper_room' id='oper_room' value='<%=oper_room_code%>' >
	<input type='hidden' name='oper_code' id='oper_code' value='<%=oper_code%>' >
	<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>' >
	<input type='hidden' name='check_in_recovery_time' id='check_in_recovery_time' value='<%=check_in_recovery_time%>' >
	<input type='hidden' name="size" id="size" value='0' >
	<input type='hidden' name="size1" id="size1" value='0' >
	<input type='hidden' name="user_id" id="user_id" value="<%=slate_user_id%>" >
	<input type='hidden' name="no_of_verifications" id="no_of_verifications" value="<%=no_of_verifications%>">
	<input type='hidden' name="role_id_1" id="role_id_1" value="<%=role_id_1%>">
	<input type='hidden' name="role_id_2" id="role_id_2" value="<%=role_id_2%>">
	<input type='hidden' name="role_id_3" id="role_id_3" value="<%=role_id_3%>">
	<input type='hidden' name="role_id_4" id="role_id_4" value="<%=role_id_4%>">
	<input type='hidden' name="checklist_completed_yn" id="checklist_completed_yn" value="<%=checklist_completed_yn%>">
	<input type='hidden' name='post_oper_user1_completed_yn' id='post_oper_user1_completed_yn' value="<%=post_oper_user1_completed_yn%>">
	<input type='hidden' name='post_oper_user2_completed_yn' id='post_oper_user2_completed_yn' value="<%=post_oper_user2_completed_yn%>">
	<input type='hidden' name='post_oper_user3_completed_yn' id='post_oper_user3_completed_yn' value="<%=post_oper_user3_completed_yn%>">
	<input type='hidden' name='post_oper_user4_completed_yn' id='post_oper_user4_completed_yn' value="<%=post_oper_user4_completed_yn%>">
	<input type='hidden' name="old_post_oper_user1_id" id="old_post_oper_user1_id" value="<%=old_post_oper_user1_id%>">
	<input type='hidden' name="old_post_oper_user2_id" id="old_post_oper_user2_id" value="<%=old_post_oper_user2_id%>">
	<input type='hidden' name="old_post_oper_user3_id" id="old_post_oper_user3_id" value="<%=old_post_oper_user3_id%>">
	<input type='hidden' name="old_post_oper_user4_id" id="old_post_oper_user4_id" value="<%=old_post_oper_user4_id%>">
	<input type='hidden' name="check_for_check_list_compl" id="check_for_check_list_compl" value="<%=check_for_check_list_compl%>">
	<input type='hidden' name="current_date" id="current_date" value="<%=current_date%>">
	<input type='hidden' name="current_time" id="current_time" value="<%=current_time%>">
	<input type='hidden' name="current_date_time" id="current_date_time" value="<%=current_date_time%>">
	<input type='hidden' name="verify_checklist_codes" id="verify_checklist_codes" value="<%=verify_checklist_codes%>">
	<input type='hidden' name="chk_oper_room_yn" id="chk_oper_room_yn" value="">
	<input type='hidden' name="or_bill_accession_num" id="or_bill_accession_num" value="">
	<input type='hidden' name="calc_charge_units" id="calc_charge_units" value="">
	<input type='hidden' name="oper_room_chrging_stg" id="oper_room_chrging_stg" value="">
	<input type='hidden' name="episode_id" id="episode_id" value="<%=episode_id%>">
	<input type='hidden' name="episode_type" id="episode_type" value="<%=bl_episode_type%>">
	<input type='hidden' name="visit_id" id="visit_id" value="<%=visit_id%>">
	<input type='hidden' name="oper_room_desc" id="oper_room_desc" value="<%=oper_room_desc%>">
	<input type='hidden' name="oper_rm_chk_yn" id="oper_rm_chk_yn" value="<%=oper_rm_chk_yn%>">
	<input type='hidden' name="charge_operating_room_yn" id="charge_operating_room_yn" value="<%=charge_operating_room_yn%>">
	<input type='hidden' name="bl_interface_flag" id="bl_interface_flag" value="<%=bl_interface_flag%>">
	<input type='hidden' name="chk_into_or_beforeConvert" id="chk_into_or_beforeConvert" value="<%=chk_into_or_beforeConvert%>">
	<input type='hidden' name="customer_id" id="customer_id" value="<%=customer_id%>"> <!-- Added against for MO-GN-5505 [IN058517] -->
	<input type='hidden' name="bl_panel_str" id="bl_panel_str" value=''>
	<input type='hidden' name='include_exclude' id='include_exclude' value=''>
	<input type='hidden' name='appr_reqd_val' id='appr_reqd_val' value=''>
	<input type='hidden' name='reason_inc_exe' id='reason_inc_exe' value=''>
	<input type='hidden' name='inc_exe_blng_wdw' id='inc_exe_blng_wdw' value=''>

	<input type='hidden' name="bill_service_code" id="bill_service_code" value="">
	<input type="hidden" name="qry_sql" id="qry_sql" value="" disabled>
	<input type="hidden" name="multi_check_in_yn" id="multi_check_in_yn" id="multi_check_in_yn" value='<%=multi_check_in_yn %>'><!-- PMG KDAH CRF-0001 -->
</form>
</html>

