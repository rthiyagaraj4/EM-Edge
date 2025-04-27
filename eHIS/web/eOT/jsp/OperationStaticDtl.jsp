<!DOCTYPE html>

<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import= "java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.OperationDtlBean,eOT.Common.OTRepository,java.util.HashMap,java.util.StringTokenizer,eOT.OTBillingBean,eOT.*,eCommon.Common.CommonBean,eOR.OrderEntryBillingQueryBean,eOT.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String ot_bean_id = "OTBillingBean";
	String ot_bean_name= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;

	String or_bean_id 						= "Or_billingQueryBean";
	String or_bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)mh.getBeanObject( or_bean_id,request, or_bean_name ) ;
	
	// Added Against ML-MMOH-CRF-1939-US2...starts
	
    String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList Fpplist = new ArrayList();
    	String fpp_order_yn = "N";
	String fpp_category = ""; 
	String oper_code="";
	String selected1="",selected2="",selected3="";
	String Include_Fpp_yn = "N";
	String fppCatFromORDesc = "";
	boolean isIncludeFpp = false;
	Integer count = 0;
	int j;
	// Added Against ML-MMOH-CRF-1939-US2...ends
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String bill_flag = request.getParameter("bill_flag");
	String facility_id = (String)session.getValue("facility_id");

%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language='javascript' src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
	  
<link href="../../eCommon/html/jquery-ui.css" rel="stylesheet" type="text/css">
	<script language='javascript'>
	function callUpdateDtl(str)
	{
		var arr = str.split("::");
		arr[2] = arr[2].replace("%","'"); //Apostrophe in Operation Desc
		parent.frames[0].document.forms[0].durFromFrame.value = arr[4];
		var objFrm=document.forms[0];
		var remarks=eval("objFrm.xx"+arr[0]+".value");
		var avg_time=arr[5]=="ISNULL"?"":arr[5];
		var std_durn=arr[6]=="ISNULL"?"":arr[6];
		//Added By Gaurav Against ML-MMOH-SCF-2511
		var fpp_category = document.forms[0].fppCatFromORDesc.value;
		if(fpp_category!= "") //ML-MMOH-CRF-1939 US005
		{
			//fpp_order_yn = "Y";
			if(fpp_category === "Simple") fpp_category="S";
			if(fpp_category === "Moderate") fpp_category="M";
			if(fpp_category === "Complex") fpp_category="C";
			
			parent.frames[0].setAllValues(arr[0],arr[1],arr[2],arr[3],decodeURIComponent(remarks),arr[4],avg_time,std_durn,arr[7],fpp_category);
		}else{
		//Added By Gaurav Against ML-MMOH-SCF-2511
		parent.frames[0].setAllValues(arr[0],arr[1],arr[2],arr[3],decodeURIComponent(remarks),arr[4],avg_time,std_durn,arr[7],arr[8]);
		}//Added By Gaurav Against ML-MMOH-SCF-2511
		$("#fppCat"+arr[0]).prop('disabled', false);
		}	
	
	function fppCatValue(val)
	{
		parent.frames[0].document.forms[0].fpp_category.value = val;
	}
	function addToCollect(i)
	{
		var formObj=document.forms[0];
		var speciality_code_for_or1="";
		//var obj=formObj.opercode_OR.value+",";
		var obj=eval("formObj.opercode_OR_"+i).value+",";
		//var speciality_code_for_or1=formObj.speciality_code_for_or1.value+",";
		//parent.frames[0].document.forms[0].codeCollect.value+=obj;
		//console.log(parent.frames[0].document.getElementById('codeCollect'));
		parent.frames[0].document.getElementById('codeCollect').value+=obj;
		if(parent.frames[0].document.forms[0].specialityCollect.value=='')
		{   
		speciality_code_for_or1=eval("formObj.speciality_code_for_or1_"+i).value;
		parent.frames[0].document.forms[0].specialityCollect.value=","+speciality_code_for_or1+",";
		}else{
			speciality_code_for_or1=eval("formObj.speciality_code_for_or1_"+i).value;
			parent.frames[0].document.forms[0].specialityCollect.value+=speciality_code_for_or1+",";
		}
		//parent.frames[0].document.forms[0].specialityCollect.value=speciality_code_for_or1;
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name=existing_order_hdg>
<table cellpadding=2  cellspacing=0 border=1 width='98.8%' >
	<tr>
		<th class="columnHeader" nowrap>
			<fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/>
		</th>		
		<th class="columnHeader" nowrap>
			<fmt:message key="Common.description.label" bundle="${common_labels}"/>
		</th>		
		<th class="columnHeader" nowrap>
			<fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/>
		</th>		 
		<th class="columnHeader" nowrap>
			<fmt:message key="Common.duration.label" bundle="${common_labels}"/>
		</th>
         <%if(("true").equals(bill_flag))
	      {%>
		<th class='columnHeaderCenter' nowrap>
		    <fmt:message key="Common.Charge.label" bundle="${common_labels}"/>
		</th>
       <th class='columnHeaderCenter' nowrap>
       </th><%}%>
	</tr>

<%
	//request parameter
	String strOrderId=checkForNull(request.getParameter("orderid"));
	String fppCatFromOR=checkForNull(request.getParameter("fpp_category")); //ML-MMOH-CRF-1939 US005
	System.err.println("fpp_category in Static Dtl===>"+fppCatFromOR);
	String selOrderIds = checkForNull(request.getParameter("selOrderIds")).trim(); // ChAiTu - 186
	String ammendFlag = checkForNull(request.getParameter("ammendFlag")).trim(); // ChAiTu - 186
	if(selOrderIds != null && selOrderIds.contains(","))
		selOrderIds = selOrderIds.replaceAll(",", "','");
	String called_from=checkForNull(request.getParameter("called_from"));
	String surgeon_code=checkForNull(request.getParameter("surgeonCode"));
	String splty_code=checkForNull(request.getParameter("splty_code"));
	String mode=checkForNull(request.getParameter("mode"),"L");
	String selectAuthFlag = checkForNull(request.getParameter("selectAuthFlag")); //049829
	String patientId = checkForNull(request.getParameter("patientId"));
	String episode_id1 = "";//Added Against ML-MMOH-CRF-1939-US2
	String tempSelOrderIds = selOrderIds;
	System.out.println("====selectAuthFlag===OperationStaticDtl.jsp==="+selectAuthFlag);
	System.out.println("====selOrderIds===OperationStaticDtl.jsp==="+selOrderIds);
	System.out.println("====called_from===OperationStaticDtl.jsp==="+called_from);
	System.out.println("====patientId===OperationStaticDtl.jsp==="+patientId);
	System.out.println("====tempSelOrderIds===OperationStaticDtl.jsp==="+tempSelOrderIds);
	System.out.println("=========ammendFlag======OperationStaticDtl.jsp========="+ammendFlag);
	//variable initialization
	String empty = "".intern();
	String strOperationCode=empty;
	String strOperationDesc=empty;
	String strRightLeftFlag=empty;
	String strDuration=empty;
	String strRemarks=empty;
	String std_durn=empty;
	String surgeon_avg_time=empty;
	String strSide=empty;
	String durationSum=empty;
	String durationHour=empty;
	String durationMin=empty;
	String bill_str="";
	String panel_str="";
	String rate="";
	String ar[]=null;
	String order_line_num="";
	String ammendBooking = ""; //ChAiTu
	String chkBookingExistDays = ""; //ChAiTu
	String tempOrderCode="";//vikash Added For Duplicated Operation Code
	boolean temporderflag=true;//vikash Added For Duplicated Operation Code
	int CounterForOrderId=0;
	String orderArr[]=null;
	HashMap bill_info = new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	StringBuffer getOperDetsBuffer = new StringBuffer();
	int durH,durM;
	//int count=0;
	int fetchCount=0;
	//Database Related 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt1=null;
	ResultSet rst1=null;
	PreparedStatement pstmt2=null;
	ResultSet rst2=null;

	String overridden_action_reason_code=null;
	//getting Bean Reference 
    bean_id = "OperationDtlBean";
	bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);

	System.out.println("====strOrderId===OperationStaticDtl======"+strOrderId);
	System.out.println("====mode===OperationStaticDtl======"+mode);
	if(strOrderId.length()>0  && "L".equals(mode))
	{
			HashMap map;
			conn = ConnectionManager.getConnection(request);

		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
		String getValOfAmmendBooking = "select nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days from ot_param_for_facility where operating_facility_id = ?";
		pstmt = conn.prepareStatement(getValOfAmmendBooking);
		pstmt.setString(1,facility_id);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			ammendBooking = rs.getString("ammend_bookings");
			chkBookingExistDays = rs.getString("chk_bookings_exist_days");
		}
		System.out.println("=======ammendBooking=====OperationStaticDtl========="+ammendBooking);
		System.out.println("=======chkBookingExistDays===OperationStaticDtl==========="+chkBookingExistDays);
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();

			String surg_avg_time_sql = OTRepository.getOTKeyValue("SQL_OT_COLLECT_DURATION_SELECT2");
			String std_durn_sql ="SELECT TO_CHAR(APPT_TIME,'HH24:MI') APPT_TIME1, TO_CHAR(APPT_TIME,'DD/MM/YYYY HH24:MI') APPT_TIME2 FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID=? AND ORDER_CATEGORY = 'OT' AND ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE=?)";
			String duraiotn_ot_param_for_facility  ="SELECT TO_CHAR(UNIT_OT_TIME,'HH24:MI') OPER_DUR FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?";
			String speciality_code_for_or="";


		String sql = OTRepository.getOTKeyValue("SQL_OT_OPERATION_SERARCH_SELECT1");
		if(tempSelOrderIds == null || tempSelOrderIds.trim().length() == 0)
			tempSelOrderIds = strOrderId;
		System.out.println("====tempSelOrderIds===OperationStaticDtl======"+tempSelOrderIds);
		
		if(ammendFlag != null && ammendFlag.equals("Y"))
		{
		
		tempSelOrderIds=tempSelOrderIds.concat("','").concat(strOrderId);//186
		
		
/*
			getOperDetsBuffer.append("	SELECT DISTINCT oper_code oper_code1, oper_desc oper_desc1, order_id,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1,	");
			getOperDetsBuffer.append("	TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1,	");
			getOperDetsBuffer.append("	speciality_code FROM ot_pending_orders_dtl_vw	");
			getOperDetsBuffer.append("	WHERE order_id in('"+	tempSelOrderIds + "')	");
			getOperDetsBuffer.append("	AND oper_durn IS NOT NULL		");
			getOperDetsBuffer.append("	ORDER BY order_line_no	");
*/

			getOperDetsBuffer.append("	SELECT DISTINCT a.oper_code oper_code1, a.oper_desc oper_desc1,a.order_id order_id,	");//057524
			getOperDetsBuffer.append("	a.appl_right_left_flag appl_right_left_flag1, NVL (TO_CHAR (oper_durn, 'hh24:mi'),	");
			getOperDetsBuffer.append("	TO_CHAR (booking_duration, 'hh24:mi')) oper_durn1,	");
			getOperDetsBuffer.append("	a.oper_remarks oper_remarks1, a.order_line_no order_line_no1, a.speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw a, ot_booking_hdr b	");
			getOperDetsBuffer.append("	WHERE a.order_id IN ('"+	tempSelOrderIds + "')	");
			getOperDetsBuffer.append("	AND a.order_id = b.order_id(+)	");
			getOperDetsBuffer.append("	AND NVL (b.operating_facility_id, ?) = ?	");
			getOperDetsBuffer.append("	ORDER BY order_line_no	");
			
			System.err.println("207 if part query getOperDetsBuffer : "+getOperDetsBuffer);
			//MMS-QH-CRF-186 Added For Operation Failed while multiple Book Appointment
		}/*else if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0){
		
			System.err.println("came kin else if condition vikash");
			
			getOperDetsBuffer.append("	SELECT oper_code oper_code1, oper_desc oper_desc1,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1, TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1, speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw	");
			//getOperDetsBuffer.append("	WHERE order_id IN ('"+	strOrderId + "')	");
			getOperDetsBuffer.append("	WHERE order_id IN ('"+	tempSelOrderIds + "')	");
			getOperDetsBuffer.append("	ORDER BY order_line_no	");
			
		}*/
		else
		{
			//057524 starts
			getOperDetsBuffer.append("	SELECT oper_code oper_code1, oper_desc oper_desc1,order_id,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1, TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1, speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw	");
			getOperDetsBuffer.append("	WHERE order_id IN ('"+	strOrderId + "')	");
			getOperDetsBuffer.append("	union all	");
			//057524 ends
			//this above code added to displaying the selected operation first and making tat as primary Operation
			getOperDetsBuffer.append("	SELECT oper_code oper_code1, oper_desc oper_desc1,order_id,	");
			getOperDetsBuffer.append("	appl_right_left_flag appl_right_left_flag1, TO_CHAR (oper_durn, 'hh24:mi') oper_durn1,	");
			getOperDetsBuffer.append("	oper_remarks oper_remarks1, order_line_no order_line_no1, speciality_code	");
			getOperDetsBuffer.append("	FROM ot_pending_orders_dtl_vw	");
			getOperDetsBuffer.append("	WHERE order_id IN ('"+	tempSelOrderIds + "')	");
			//getOperDetsBuffer.append("	ORDER BY order_line_no	");
			//getOperDetsBuffer.append("	order by oper_desc desc	");
			System.err.println("else part of OperationStaticDtl.jsp tempSelOrderIds: "+tempSelOrderIds);
			System.out.println("====else part == query getOperDetsBuffer===OperationStaticDtl======"+getOperDetsBuffer);
		}

		System.out.println("====getOperDetsBuffer===OperationStaticDtl======"+getOperDetsBuffer);
		try
		{
			pstmt = conn.prepareStatement(getOperDetsBuffer.toString());
			if(ammendFlag != null && ammendFlag.equals("Y"))
			{
				pstmt.setString(1, facility_id);
				pstmt.setString(2, facility_id);
			}

			rs=pstmt.executeQuery();
			//57524
			if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0 ){
			orderArr=selOrderIds.split(",");
			}
			//57524
			while(rs.next())
{
				System.err.println("vikash while starts :"+strOrderId);
				//Vikash starts for duplicated order remvoing	057524
				oper_code = rs.getString("OPER_CODE1");//Added Against ML-MMOH-CRF-1939-US2
				temporderflag=true;
				if(tempOrderCode.length()>0){
					System.err.println("tempOrderCode :"+tempOrderCode);
					
					if(tempOrderCode.contains(rs.getString("OPER_CODE1"))){
						temporderflag=false;
					}
				}
							
				tempOrderCode=tempOrderCode.concat(rs.getString("OPER_CODE1")).concat(",");
				System.err.println("tempOrderCode : "+tempOrderCode);
				//057524 ends
				
				//Vikash End for duplicated order remvoing
				if(temporderflag){
				//Vikash End for duplicated order remvoing
				fetchCount++;
				speciality_code_for_or=checkForNull(rs.getString("SPECIALITY_CODE"));
				strOperationCode=checkForNull(rs.getString("OPER_CODE1"));
				strOperationDesc=checkForNull(rs.getString("OPER_DESC1"));
				strRightLeftFlag=checkForNull(rs.getString("APPL_RIGHT_LEFT_FLAG1"));
				strDuration=checkForNull(rs.getString("OPER_DURN1"));
				strRemarks=checkForNull(rs.getString("OPER_REMARKS1"));
				
				System.err.println("ammendBooking :"+ammendBooking);
				if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0 ){
					order_line_num = String.valueOf(fetchCount);//186
					//57524
					strOrderId=rs.getString("order_id");
					//if(CounterForOrderId>=1){
					//strOrderId=orderArr[CounterForOrderId];
					//}
					//57524
					System.err.println("newly implementt strOrderId if "+strOrderId);
					System.err.println("order_line_num if "+order_line_num);
				}
				else {				
					order_line_num = checkForNull(rs.getString("ORDER_LINE_NO1"));
					System.err.println("order_line_num else ");
				}
				CounterForOrderId++;//57524

				System.err.println("order_line_num : OperationStaticDtl.jsp"+order_line_num);
				//for getting surgeon avg time from order
				pstmt1 = conn.prepareStatement(surg_avg_time_sql);
				pstmt1.setString(1,surgeon_code);
				pstmt1.setString(2,strOperationCode);
				rst1 = pstmt1.executeQuery();
				while(rst1.next()){
					surgeon_avg_time =checkForNull(rst1.getString(1),"ISNULL");
				}

				//for getting Standard Duration
				pstmt1 = conn.prepareStatement(std_durn_sql);
				pstmt1.setString(1,locale);
				pstmt1.setString(2,strOperationCode);
				rst1 = pstmt1.executeQuery();
				while(rst1.next()){
					std_durn = checkForNull(rst1.getString(2),"ISNULL");
				}
			if(pstmt1!=null)pstmt1.close();
			if(rst1!=null)rst1.close();

			if(strDuration.length()==0)
			{
			pstmt2=conn.prepareStatement(duraiotn_ot_param_for_facility);
			pstmt2.setString(1,facility_id);
			rst2=pstmt2.executeQuery();
			while(rst2.next())
				{
                strDuration=checkForNull(rst2.getString("OPER_DUR"));
				}
			}

			if(strDuration.length()>0){
				String arr[] = strDuration.split(":");
				durationHour=arr[0];
				durationMin=arr[1];
			}else{
				durationHour="0";
				durationMin="0";
			}
            if(("true").equals(bill_flag))
	        {

				if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0)
				{
					bill_info = or_bean.getOrderBillDtls(patientId + strOperationCode);
					//bill_info = or_bean.getOrderBillDtls(strOrderId+rs.getString("ORDER_LINE_NO1"));
					
					//bill_info = or_bean.getOrderBillDtls(strOrderId+order_line_num);
					bill_info = or_bean.getOrderBillDtls(rs.getString("order_id")+order_line_num);//057524 for null issue
				}
				else
				{
				bill_info = or_bean.getOrderBillDtls(strOrderId+order_line_num);
				}


				System.out.println("===========bill_info====111========"+bill_info);
				if((bill_info==null || bill_info.size()==0) && !"".equals(called_from))
				{
					bill_info = new HashMap();
					//bill_info.put("key",strOrderId);//commented against null issue
					bill_info.put("key",rs.getString("order_id"));//057524 for null issue
					//bill_info.put("key_line_no",order_line_num);//commented against null issue
					bill_info.put("key_line_no",rs.getString("ORDER_LINE_NO1"));	//057524 for null issue
					bill_info.put("oper_code",strOperationCode);
					bill_info.put("locale",locale);
					bill_info.put("module_id","OR");//after booking billing is done need to change.
					bill_info.put("quantity","1");
					bill_info.put("called_from",called_from);
					bill_info.put("fpp_category",fppCatFromOR); //ML-MMOH-CRF-1939-US005
					System.err.println("line 370 bill_info :"+bill_info);
					bill_info = billing_bean.getCheckInBillingParams(bill_info,"S");
					episode_id1 = (String)bill_info.get("episode_id");

					if(ammendBooking != null && selOrderIds != null && ammendBooking.equals("Y") && selOrderIds.trim().length() > 0)
					{
						//bill_info.put("order_id", "");//commented against null issue
						//or_bean.setOrderBillDtls(patientId + rs.getString("ORDER_LINE_NO1"), bill_info);//commented against null issue
						//or_bean.setOrderBillDtls(strOrderId+order_line_num,bill_info);//commented against null issue
						or_bean.setOrderBillDtls(rs.getString("order_id")+order_line_num,bill_info);	//057524 for null issue
						
					}
					else
					{
					or_bean.setOrderBillDtls(strOrderId+order_line_num,bill_info);
					}
					putObjectInBean(or_bean_id,or_bean,request);
				}
				System.out.println("===========bill_info====222========"+bill_info);
				String overridden_incl_excl=null;
				panel_str=checkForNull((String) bill_info.get("bl_panel_str"));
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("err_id"),""));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
			}
			
			Fpplist = billing_bean.getFPPDetails(strOperationCode);
			for (j = 0; j < Fpplist.size(); j++){
			  if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
              if(j==1) fpp_category=checkForNull((String)Fpplist.get(j));
			}

			map=new HashMap();
			map.put("oper_code",strOperationCode);
			map.put("operation_desc",strOperationDesc);
			map.put("appl_right_left_flag",strRightLeftFlag);
			map.put("duration",strDuration);
			map.put("remarks",strRemarks);
			map.put("surgeon_avg_time",surgeon_avg_time);
			map.put("f_duration",std_durn);
			map.put("splty_code",splty_code);
			if(("true").equals(bill_flag))
	        {
				//Added By Gaurav Against ML-MMOH-SCF-2511
				map.put("fpp_yn",fpp_order_yn);
				if(fpp_order_yn.equals("N"))
					map.put("fpp_category","N");
				else
					map.put("fpp_category",fppCatFromOR);
				//Added By Gaurav Against ML-MMOH-SCF-2511
				map.put("bill_str",bill_str);
				map.put("panel_str",panel_str);
				map.put("rate",rate);
			}
			map.put("order_id",strOrderId);
			map.put("order_line_num",order_line_num);
			System.out.println("==========map======OperationStaticDtl============"+map);
			chk_bean.recordOperationDtls(map);
%>
			<input type='hidden' name='opercode_OR_<%=fetchCount%>' id='opercode_OR_<%=fetchCount%>'   value='<%=strOperationCode%>'>
			<input type='hidden' name='speciality_code_for_or1_<%=fetchCount%>' id='speciality_code_for_or1_<%=fetchCount%>'   value='<%=speciality_code_for_or%>'>	
			<script>
			setTimeout("addToCollect("+<%=fetchCount%>+")",500);
			</script>
			
<%
}//vikash  if closing for removing duplicate oper code	057524 for duplicate order
}// while looping ending here
rs.close();
pstmt.close();
}catch(Exception ee){	
	//System.err.println("Exception OperationStaticDtl.jsp"+ee);
	ee.printStackTrace();
}finally{
	ConnectionManager.returnConnection(conn, request);	
}
}

	HashMap operation_Map=chk_bean.getOperationDtls();
	HashMap temp_map=new HashMap();
	StringBuffer sbr = new StringBuffer();
	String classvalue = ""; 
	String val = "";
	String choice = "D";
	durationHour=checkForNull(request.getParameter("total_hour"),"0");
	durationMin=checkForNull(request.getParameter("total_min"),"0");
	durH=Integer.parseInt(durationHour);
	durM=Integer.parseInt(durationMin);
	StringTokenizer strtoken;

	System.out.println("====operation_Map===OperationStaticDtl======"+operation_Map);
	for(int i=1;i<=operation_Map.size();i++)
	{
		temp_map=(HashMap)operation_Map.get(""+i);
//Added try catch block on March 3,2011 by Anitha for Booking Internal server error issue.
  try{
		if(("true").equals(bill_flag) )
	    {
			panel_str=checkForNull((String)temp_map.get("panel_str")); 
			bill_str=checkForNull((String)temp_map.get("bill_str")); 
			rate=checkForNull((String)temp_map.get("rate")); 
			if(!(bill_str.trim()).equals(""))
			{
		//modified dhanasekarV
		//bill_str = "20000.0::19071.8::0.0::N::null::::S::null::I";
		//	bill_str = bill_str+"E";
				ar=bill_str.split("::");
			}else
			{
				 bill_str="0.0::0.0::0.0::N::null::N::L::null::";
				 ar=bill_str.split("::");
			}
		// Added Against ML-MMOH-CRF-1939-US2...starts
			
			conn = ConnectionManager.getConnection(request);
			Include_Fpp_yn = bean.getIncludeFpp(facility_id);
			System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
			isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
			System.err.println("isIncludeFpp --->"+isIncludeFpp);
		//	isIncludeFpp = true;
	
			count = bean.getFppIcon();
			System.err.println("COunt : "+count);
			oper_code = (String)temp_map.get("oper_code");
		// Added Against ML-MMOH-CRF-1939-US2...ends
	    }
    }catch(Exception e){
		e.printStackTrace();
		//System.err.println("exp in OperationStaticDtl.jsp "+e);
   }

		durationSum=""+temp_map.get("duration");
		strtoken=new StringTokenizer(durationSum,":");
		if(strtoken.hasMoreTokens()){
			durationHour=strtoken.nextToken().trim();
			durationMin=strtoken.nextToken().trim();
		}
	
	durM+=Integer.parseInt(durationMin);
	durH+=Integer.parseInt(durationHour)+(durM/60);
	durM%=60;
	classvalue = (i%2==0)?"gridData":"gridData";
	out.println("<tr>");
	out.println("<input type='hidden' name='xx"+i+"' id='xx"+i+"'  value=\""+temp_map.get("remarks")+"\">"); 
	out.println("<input type='hidden' name='oper_code"+i+"' id='oper_code"+i+"'  value=\""+temp_map.get("oper_code")+"\">"); 
	out.println("<input type='hidden' name='operation_desc"+i+"' id='operation_desc"+i+"'  value=\""+temp_map.get("operation_desc")+"\">"); 
	out.println("<input type='hidden' name='appl_right_left_flag"+i+"' id='appl_right_left_flag"+i+"'  value=\""+temp_map.get("appl_right_left_flag")+"\">"); 
	out.println("<input type='hidden' name='duration"+i+"' id='duration"+i+"'  value=\""+temp_map.get("duration")+"\">"); 
	out.println("<input type='hidden' name='f_duration"+i+"' id='f_duration"+i+"'  value=\""+temp_map.get("f_duration")+"\">"); 
	out.println("<input type='hidden' name='avgTime"+i+"' id='avgTime"+i+"'  value=\""+temp_map.get("surgeon_avg_time")+"\">"); 
	out.println("<input type='hidden' name='splty_code"+i+"' id='splty_code"+i+"'  value=\""+temp_map.get("splty_code")+"\">"); 
	if(("true").equals(bill_flag))
		out.println("<input type='hidden' name='bill_st"+i+"' id='bill_st"+i+"'  value=\""+temp_map.get("bill_str")+"\">"); 
		out.println("<input type='hidden' name='order_line_num"+i+"' id='order_line_num"+i+"'  value=\""+temp_map.get("order_line_num")+"\">"); 
		//if(mode.equals("U"))
		out.println("<input type='hidden' name='fppCat"+i+"' id='fppCat"+i+"'  value=\""+temp_map.get("fpp_category")+"\">"); 
		sbr.append(i).append("::");
		sbr.append(temp_map.get("oper_code")).append("::");
		//Apostrophe Available in Operation Description
		String desc = temp_map.get("operation_desc").toString();
		String operationDesc = desc.replaceAll("'", "%");
		sbr.append(operationDesc).append("::");
		//Apostrophe**
		sbr.append(temp_map.get("appl_right_left_flag")).append("::");
		sbr.append(temp_map.get("duration")).append("::");
		sbr.append(temp_map.get("surgeon_avg_time")).append("::");
		sbr.append(temp_map.get("f_duration")).append("::");
		sbr.append(temp_map.get("splty_code")).append("::");
		sbr.append(temp_map.get("fpp_category"));
		val = sbr.toString();
		sbr.setLength(0);
		out.println("<td width='8%' class='"+classvalue+"' align='left' nowrap><a href=\"javascript:callUpdateDtl('"+val+"');\" >"+temp_map.get("oper_code")+"</a></td>");
		out.println("<td width='8%' align='left' class='"+classvalue+"' nowrap>"+temp_map.get("operation_desc")+"</td>");
		choice = checkForNull((String) temp_map.get("appl_right_left_flag"),"D");
	switch(choice.charAt(0)){
		case 'B': 
				strSide=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Bilateral.Label","ot_labels");
				break;
		case 'L': 
				strSide=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LeftSide.Label","ot_labels");
				break;
		case 'R': 
				strSide=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RightSide.Label","ot_labels");
				break;
		default:  
				strSide="";
				break;
	}
		
	out.println("<td width='8%' align='left' class='"+classvalue+"' nowrap>"+strSide+"</td>");
	out.println("<td width='8%' align='right'class='"+classvalue+"' nowrap>"+temp_map.get("duration")+"</td>");
    
	String inclexcl="";
	String approvalreqd="";

	  if(isIncludeFpp)
	{
	Fpplist = billing_bean.getFPPDetails(oper_code);
			for (j = 0; j < Fpplist.size(); j++){
			  if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
              if(j==1) fpp_category=checkForNull((String)Fpplist.get(j));
			}		
		if("S".equals(temp_map.get("fpp_category")) || "M".equals(temp_map.get("fpp_category")) || "C".equals(temp_map.get("fpp_category")))
			{
				if(temp_map.get("fpp_category").equals("S")) selected1="selected";
				if(temp_map.get("fpp_category").equals("M")) selected2="selected";
				if(temp_map.get("fpp_category").equals("C")) selected3="selected";
			}
		else
	{
		if(fpp_category.equals("S")) selected1="selected";
		if(fpp_category.equals("M")) selected2="selected";
		if(fpp_category.equals("C")) selected3="selected";
	}

	 if(fppCatFromOR!= "") //ML-MMOH-CRF-1939 US005
	{
			//fpp_order_yn = "Y";
			if(fppCatFromOR.equals("S")) fppCatFromORDesc="Simple";
			if(fppCatFromOR.equals("M")) fppCatFromORDesc="Moderate";
			if(fppCatFromOR.equals("C")) fppCatFromORDesc="Complex";
			}
	}
	if(("true").equals(bill_flag))
	{
	if(("S").equals(ar[6]))
	{
	if(("E").equals(ar[8]) ||("").equals(ar[8])) inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
	if(("I").equals(ar[8])) inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	if(("Y").equals(ar[5])) approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	if(("N").equals(ar[5])) approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
	}else{
	inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
    approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
	}
	}
	
	
    if(("true").equals(bill_flag))
	{ 
	  //Added Against ML-MMOH-CRF-1939-US2...starts
	  if(fpp_order_yn.equals("Y") && called_from.equals("DIRECT_BOOKING") && isIncludeFpp && count==1 && Include_Fpp_yn.equals("Y") ){
	out.println("<td width='20%'align='left' class='"+classvalue+"' nowrap>"+"<div id='charge"+i+"'>"+"<B><font color='Indigo' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Payable.Label","ot_labels")+":&nbsp;"+ar[0]+"</font>&nbsp;<font color='crimson'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPayable.label","common_labels")+":&nbsp;"+ar[1]+"</font>&nbsp;<font color='green'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPaid.label","common_labels")+":&nbsp;"+ar[2]+"</font></B><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels")+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApprovalRequired.Label","common_labels")+approvalreqd+"<B><font color='Blue'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FppCategory.Label","ot_labels")+":&nbsp;"+"<select name = 'fppCat"+i+"' id = 'fppCat"+i+"'  onChange='javascript:fppCatValue(this.value)'; disabled><option value='S' "+selected1+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Simple.Label","ot_labels")+"</option><option value='M' "+selected2+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Moderate.Label","ot_labels")+"</option><option value='C' "+selected3+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Complex.Label","ot_labels")+"</option></select>"+"</td></div>"); //Added Against ML-MMOH-CRF-1939-US2...ends
	out.println("<td width='10%'align='left' class='"+classvalue+"'>"+"<a href='javascript:callBillingWindow1("+i+")';>"+"<img src='../../eOT/images/dollar.png'></img></a></td>");
	}
	else if(fpp_order_yn.equals("Y") && called_from.equals("OR") && isIncludeFpp && count==1 && Include_Fpp_yn.equals("Y") ) //ML-MMOH-CRF-1939 US005
	{
	out.println("<td width='20%'align='left' class='"+classvalue+"' nowrap>"+"<div id='charge"+i+"'>"+"<B><font color='Magenta' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FppCategory.Label","ot_labels")+":&nbsp;"+fppCatFromORDesc+"</font>&nbsp;<font color='Indigo' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Payable.Label","ot_labels")+":&nbsp;"+ar[0]+"</font>&nbsp;<font color='crimson'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPayable.label","common_labels")+":&nbsp;"+ar[1] +"</font>&nbsp;<font color='green'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPaid.label","common_labels")+":&nbsp;"+ar[2]+"</font></B><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels")+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApprovalRequired.Label","common_labels")+approvalreqd+"</td></div>");
	out.println("<td width='10%'align='left' class='"+classvalue+"'>"+"<a href='javascript:callBillingWindow1("+i+")';>"+"<img src='../../eOT/images/dollar.png'></img></a></td>");
	}
	else{
	out.println("<td width='20%'align='left' class='"+classvalue+"' nowrap>"+"<div id='charge"+i+"'>"+"<B><font color='Indigo' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Payable.Label","ot_labels")+":&nbsp;"+ar[0]+"</font>&nbsp;<font color='crimson'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPayable.label","common_labels")+":&nbsp;"+ar[1] +"</font>&nbsp;<font color='green'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientPaid.label","common_labels")+":&nbsp;"+ar[2]+"</font></B><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Included.label","common_labels")+"?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApprovalRequired.Label","common_labels")+approvalreqd+"</td></div>");
	out.println("<td width='10%'align='left' class='"+classvalue+"'>"+"<a href='javascript:callBillingWindow1("+i+")';>"+"<img src='../../eOT/images/dollar.png'></img></a></td>");		
	 }
	}
	
}

	if(durH<=9) 
		durationHour="0"+durH;
	else 
		durationHour=""+durH;

	if(durM<=9) 
		durationMin="0"+durM;
	else	
		durationMin=""+durM;
	
	out.println("<tr ></tr><tr><td colspan='3' class='label' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TotalDuration.Label","ot_labels")+"</td><td class='label' align='left' colspan='3'>"+durationHour+":"+durationMin+"</td></tr>");
	
	if(sbr!=null)sbr.setLength(0);
	System.out.println("===durationHour===="+durationHour);
	System.out.println("===durationMin===="+durationMin);
%>
</table>
<!-- Start PMG2014-CRF-0002 [IN:046043]-->
<%
	if(called_from.equalsIgnoreCase("OR")){
%>
<br>
	<table border='0' cellpadding=3  cellspacing='0' width='100%'>
		<tr>
		<td  width="25%"></td>
		<td  width="25%"></td>
		<td  width="25%"></td>
		<td  width='4%'>
		<input type='button' class='button' value='<fmt:message key="Common.close.label"  bundle="${common_labels}"/>' onClick='closeWindow()'>
		</td>
		</tr>
	</table>
<%
	}
%>
<!-- End PMG2014-CRF-0002 [IN:046043]-->
<input type='hidden' name='total_hour' id='total_hour' value='<%=durationHour%>'>
<input type='hidden' name='total_min' id='total_min' value='<%=durationMin%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
<input type='hidden' name='order_id' id='order_id' value='<%=strOrderId%>' >
<input type='hidden' name='selectAuthFlag' id='selectAuthFlag' id='selectAuthFlag' value='<%=selectAuthFlag%>'>  <!-- 049829 -->
<input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='ammendFlag' id='ammendFlag' id='ammendFlag' value='<%=ammendFlag%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='strat_time' id='strat_time' id='strat_time' value='<%=request.getParameter("strat_time")%>'> <%--186 --%>
<input type='hidden' name='fppCatFromORDesc' id='fppCatFromORDesc' id='fppCatFromORDesc' value='<%=fppCatFromORDesc%>'><!--Added By Gaurav Against ML-MMOH-SCF-2511--> 

</form>
</body>
</html>

