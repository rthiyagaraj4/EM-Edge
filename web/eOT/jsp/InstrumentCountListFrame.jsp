<!DOCTYPE html>

<!--
Developed by    : Bhavani Shankar.
Module/Function : Frame having Instrument Count List
Start Date		: 07/02/2006
-->
<%@page  import="eOT.*,eOT.Common.*, eCommon.Common.CommonBean, java.util.HashMap,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<!-- CRF-268 Instrument Count - Rajesh V -->
<% String locale = (String)session.getAttribute("LOCALE"); 
	String otParam=""; %>
<!-- CRF-268 Instrument Count - Rajesh V -->
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/InstrumentCount.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<title>
<fmt:message key="eOT.InstrumentCount.Label" bundle="${ot_labels}"/>
</title>
<%
	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id");
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String patient_id	= request.getParameter("patient_id");
	booking_num=booking_num==null?"":booking_num;
	booking_num=booking_num.equalsIgnoreCase("null")?"":booking_num;
	oper_num=oper_num==null?"":oper_num;
	oper_num=oper_num.equalsIgnoreCase("null")?"":oper_num;
	String tray_num  =  "",set_desc =  "",oper_code = "",oper_desc = "",set_code="",map_key = "",hdr_sql = "",item_sql = "",sql = "";
	String bean_id	 = "InstrumentCountBean";
	String bean_name = "eOT.InstrumentCountBean";
	InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	HashMap item_map = null;
	HashMap temp_map = null;
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement item_pstmt = null ;
	PreparedStatement hdr_pstmt = null ;
	ResultSet rs = null ;
	ResultSet item_resultset = null ;
	ResultSet hdr_resultset = null ;
	int row_num = 0;
	//CRF-268 Instrument Count - Rajesh V
	int allocAty = 0;
	String itemType = "";
	//CRF-268 Instrument Count - Rajesh V
	
	try{
		connection	= ConnectionManager.getConnection(request);
		//CRF-268 Instrument Count - Rajesh V
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";

		pstmt = connection.prepareStatement(sqlOtParam);
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			otParam=rs.getString("facility");		
		}
		pstmt = null;
		rs = null;
		
		if("Y".equalsIgnoreCase(otParam)){
			item_sql = "SELECT SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM, OPER_NUM, DOC_NUM, SET_CODE, TRAY_NUM, ITEM_TYPE, A.ITEM_CODE ITEM_CODE, ITEM_NAME, NVL(B.CONSUMABLE_YN,'N') CONSUMABLE_YN, STD_QTY, CSSD_QTY, OPEN_QTY, INITIAL_STATUS, INITIAL_STATUS_REMARKS, RETURN_QTY, FINAL_STATUS, FINAL_REMARKS, NVL(FINALIZED_YN,'N') FINALIZED_YN,GENERAL_REMARKS FROM OT_STORE_ISSUE_DTLS A, OT_SS_COMPONENTS B WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND PATIENT_ID = ? AND OPER_CODE=? AND SET_CODE=? AND A.ITEM_CODE=B.ITEM_CODE";
			hdr_sql = "SELECT NVL(INITIAL_COUNT_CMPL_YN,'N') INITIAL_COUNT_CMPL_YN, NVL(FINAL_COUNT_CMPL_YN,'N') FINAL_COUNT_CMPL_YN FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))   AND OPER_NUM=? AND PATIENT_ID = ? AND SET_CODE=? ";
			sql =	"SELECT opl.oper_code,(select short_desc from ot_oper_mast where oper_code = opl.oper_code) oper_desc, "+
					" opl.item_type,opl.item_id,(select short_desc from ot_instrument where instr_code = opl.item_id) desce, no_of_units "+
					" FROM ot_pick_lists opl "+
					" WHERE opl.OPERATING_FACILITY_ID = ? "+
					" AND NVL(opl.BOOKING_NUM,'XX')   =NVL( ?,NVL(opl.BOOKING_NUM,'XX')) "+
					" AND opl.PATIENT_ID = ? and opl.item_type = 'I' and opl.CSSD_STATUS='F'";
		}
		else{
			item_sql = "SELECT SURGERY_DATE, TEAM_DOCTOR_CODE, BOOKING_NUM, OPER_NUM, DOC_NUM, SET_CODE, TRAY_NUM, ITEM_TYPE, A.ITEM_CODE ITEM_CODE, ITEM_NAME, NVL(B.CONSUMABLE_YN,'N') CONSUMABLE_YN, STD_QTY, CSSD_QTY, OPEN_QTY, INITIAL_STATUS, INITIAL_STATUS_REMARKS, RETURN_QTY, FINAL_STATUS, FINAL_REMARKS, NVL(FINALIZED_YN,'N') FINALIZED_YN,GENERAL_REMARKS FROM OT_STORE_ISSUE_DTLS A, OT_SS_COMPONENTS B WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND PATIENT_ID = ? AND OPER_CODE=? AND SET_CODE=? AND TRAY_NUM=? AND A.ITEM_CODE=B.ITEM_CODE";
			hdr_sql = "SELECT NVL(INITIAL_COUNT_CMPL_YN,'N') INITIAL_COUNT_CMPL_YN, NVL(FINAL_COUNT_CMPL_YN,'N') FINAL_COUNT_CMPL_YN FROM OT_STORE_ISSUE_HDR WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))   AND OPER_NUM=? AND PATIENT_ID = ? AND SET_CODE=? AND TRAY_NUM=?";
			sql = "SELECT OPER_CODE, OPER_DESC, SET_CODE, SET_DESC, TRAY_NUM FROM OT_SET_DETAILS_VW WHERE OPERATING_FACILITY_ID = ? AND nvl(BOOKING_NUM,'XX')=NVL( ?,nvl(BOOKING_NUM,'XX'))  AND OPER_NUM=? AND PATIENT_ID = ?";
		}
		//CRF-268 Instrument Count - Rajesh V
		item_pstmt		= connection.prepareStatement(item_sql) ;
		hdr_pstmt		= connection.prepareStatement(hdr_sql) ;

		pstmt	= connection.prepareStatement(sql) ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,booking_num);
		//CRF-268 Instrument Count - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
			pstmt.setString(3,patient_id);
		}
		else{
			pstmt.setString(3,oper_num);
			pstmt.setString(4,patient_id);
		}
		//CRF-268 Instrument Count - Rajesh V
		rs		= pstmt.executeQuery();
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="InstrumentCountListForm" id="InstrumentCountListForm">
<table cellpadding=3="3" cellspacing="0" width="100%" align="center" border="1">
	<tr id="instr_count_set_hdr_table">
	<td class="columnHeader" width="3%"></td>
	<td class="columnHeader" width="35%" >
	<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
	</td>
	<td class="columnHeader"  width="35%" >
	<fmt:message key="Common.Set.label" bundle="${common_labels}"/>
	</td>
	<!-- CRF-268 Instrument Count - Rajesh V -->
	<%if("Y".equalsIgnoreCase(otParam)){ %>
	<td class="columnHeader" width="19%"  >
	<fmt:message key="Common.type.label" bundle="${common_labels}"/>
	</td>
	<td class="columnHeader" width="19%"  >
	<fmt:message key="eOT.AllocatedQuantity.Label" bundle="${ot_labels}"/>
	</td>
	<%}else{ %>
	<td class="columnHeader" width="19%"  >
	<fmt:message key="Common.Tray.label" bundle="${common_labels}"/>
	</td>
	<%} %>
	<!-- CRF-268 Instrument Count - Rajesh V -->
	</tr>		
<%
	int item_count=0;
	String classvalue = "";
	String initial_count_cmpl_yn = "";
	String final_count_cmpl_yn = "";
	while(rs!=null && rs.next()){
		row_num++;
		item_map=new HashMap();
		if ( row_num % 2 == 0 )
			classvalue = "gridData" ;
		else
			classvalue = "gridData" ;
		
		//CRF-268 Instrument Count - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
			oper_code	= rs.getString("OPER_CODE");
			oper_desc	= rs.getString("OPER_DESC");
			set_desc	= rs.getString("desce");
			set_code	= rs.getString("item_id");
			itemType	= rs.getString("item_type");
			allocAty    =  rs.getInt("no_of_units");
		}
		else{
			oper_code	= rs.getString("OPER_CODE");
			oper_desc	= rs.getString("OPER_DESC");
			set_desc	= rs.getString("SET_DESC");
			set_code	= rs.getString("SET_CODE");
			tray_num	= rs.getString("TRAY_NUM");
		}

		//CRF-268 Instrument Count - Rajesh V

		hdr_pstmt.setString(1,facility_id);
		hdr_pstmt.setString(2,booking_num);
		hdr_pstmt.setString(3,oper_num);
		hdr_pstmt.setString(4,patient_id);
		hdr_pstmt.setString(5,set_code);
		//CRF-268 Instrument Count - Rajesh V
		if(!("Y".equalsIgnoreCase(otParam))){
			hdr_pstmt.setString(6,tray_num);	
		}
		//CRF-268 Instrument Count - Rajesh V
		if(hdr_resultset!=null) hdr_resultset.close();
		hdr_resultset	= hdr_pstmt.executeQuery();
		while(hdr_resultset!=null && hdr_resultset.next()){
			initial_count_cmpl_yn	= hdr_resultset.getString("INITIAL_COUNT_CMPL_YN");
			final_count_cmpl_yn		= hdr_resultset.getString("FINAL_COUNT_CMPL_YN");
		}
		item_pstmt.setString(1,facility_id);
		item_pstmt.setString(2,booking_num);
		item_pstmt.setString(3,oper_num);
		item_pstmt.setString(4,patient_id);
		item_pstmt.setString(5,oper_code);
		item_pstmt.setString(6,set_code);
		//CRF-268 Instrument Count - Rajesh V
		if(!("Y".equalsIgnoreCase(otParam))){
			item_pstmt.setString(7,tray_num);	
		}
		//CRF-268 Instrument Count - Rajesh V
		if(item_resultset!=null) item_resultset.close();
		item_resultset	= item_pstmt.executeQuery();
		item_count=0;
		while(item_resultset!=null && item_resultset.next()){
			item_count++;
			temp_map=new HashMap();
			temp_map.put("SET_CODE",set_code);
			temp_map.put("TRAY_NUM",tray_num);
			temp_map.put("SURGERY_DATE",item_resultset.getString("SURGERY_DATE"));
			temp_map.put("ITEM_TYPE",item_resultset.getString("ITEM_TYPE"));
			temp_map.put("ITEM_CODE",item_resultset.getString("ITEM_CODE"));
			temp_map.put("CONSUMABLE_YN",item_resultset.getString("CONSUMABLE_YN"));			
			temp_map.put("ITEM_NAME",item_resultset.getString("ITEM_NAME"));
			temp_map.put("STD_QTY",item_resultset.getString("STD_QTY"));
			temp_map.put("CSSD_QTY",item_resultset.getString("CSSD_QTY"));
			temp_map.put("OPEN_QTY",item_resultset.getString("OPEN_QTY"));
			temp_map.put("INITIAL_STATUS",item_resultset.getString("INITIAL_STATUS"));
			temp_map.put("INITIAL_STATUS_REMARKS",item_resultset.getString("INITIAL_STATUS_REMARKS"));
			temp_map.put("RETURN_QTY",item_resultset.getString("RETURN_QTY"));
			temp_map.put("FINAL_STATUS",item_resultset.getString("FINAL_STATUS"));
			temp_map.put("FINALIZED_YN",item_resultset.getString("FINALIZED_YN"));
			temp_map.put("INITIAL_STATUS_REMARKS",item_resultset.getString("INITIAL_STATUS_REMARKS"));
			temp_map.put("FINAL_REMARKS",item_resultset.getString("FINAL_REMARKS"));
			temp_map.put("GENERAL_REMARKS",item_resultset.getString("GENERAL_REMARKS"));
			temp_map.put("INITIAL_COUNT_CMPL_YN",initial_count_cmpl_yn);
			temp_map.put("FINAL_COUNT_CMPL_YN",final_count_cmpl_yn);
			
			temp_map.put("UPDATE_FLAG","N");
			item_map.put(item_count+"",temp_map);
		}
		map_key=oper_code+set_code+tray_num;	
		bean.storeSetDetails(map_key,item_map); // store the Item Details in the bean
		bean.storeMapKeys(map_key); // store the Item Details in the bean
%>
	<tr>
	<input type="hidden" name="oper_code_<%=row_num%>" id="oper_code_<%=row_num%>" value="<%=oper_code%>">
	<input type="hidden" name="set_code_<%=row_num%>" id="set_code_<%=row_num%>" value="<%=set_code%>">
	<input type="hidden" name="tray_num_<%=row_num%>" id="tray_num_<%=row_num%>" value="<%=tray_num%>">
	<input type="hidden" name="initial_count_cmpl_yn_<%=row_num%>" id="initial_count_cmpl_yn_<%=row_num%>"	value="<%=initial_count_cmpl_yn%>">
	<input type="hidden" name="final_count_cmpl_yn_<%=row_num%>" id="final_count_cmpl_yn_<%=row_num%>"	value="<%=final_count_cmpl_yn%>">

	<td class="<%=classvalue%>" id="ind_<%=row_num%>" width="3%" nowrap></td>
	<td class="<%=classvalue%>" id="oper_<%=row_num%>" style="font-size:7pt;font-weight:normal;" width="60%" nowrap> <%=oper_desc%>
	</td>
	<td class="<%=classvalue%>" id="set_<%=row_num%>" style="font-size:7pt;font-weight:normal;" wrap width="15%" nowrap> <%=set_desc%>
	</td>
	<td style="font-size:7pt;font-weight:normal;color:blue" class="<%=classvalue%>" id="tray_<%=row_num%>"  width="20%" onClick="populateDetails('<%=row_num%>');" nowrap>
		<font class='HYPERLINK' style="font-size:7pt;color:blue;cursor:pointer;font-weight:normal">
		<!-- CRF-268 Instrument Count - Rajesh V-->
		<%if("Y".equalsIgnoreCase(otParam)){
			out.println(itemType);
		}
		else{
			out.println(tray_num);
		}
		%>
		</font>
	</td>
	<%if("Y".equalsIgnoreCase(otParam)){%>
	<td class="<%=classvalue%>" id="alloc_<%=row_num%>" style="font-size:7pt;font-weight:normal;" wrap width="15%" nowrap> <%=allocAty%>
	</td>	
	<%} %>
	<!-- CRF-268 Instrument Count - Rajesh V-->
	</tr>
<%
	}// end of while
%>
</table>
<%
if(item_resultset!=null) item_resultset.close();	
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountListFrame: "+e);
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(hdr_pstmt!=null) hdr_pstmt.close();
			if(hdr_resultset!=null) hdr_resultset.close();
			if(item_resultset!=null) item_resultset.close();			
			if(pstmt!=null) pstmt.close();
			if(item_pstmt!=null) item_pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){es.printStackTrace();}
	}
%>  <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="params" id="params" value="<%=params%>">
	<input type="hidden" name="total_rows" id="total_rows" value="<%=row_num%>">	
	<input type="hidden" name="oper_num" id="oper_num" value="<%=oper_num%>">	
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">	
	<input type="hidden" name="booking_num" id="booking_num" value="<%=booking_num%>">	
	<input type="hidden" name="oper_code" id="oper_code" value="<%=oper_code%>">	
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

