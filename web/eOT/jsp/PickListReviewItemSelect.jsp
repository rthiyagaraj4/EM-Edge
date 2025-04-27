<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eST.OTTransactionBean,eOT.OTPickListBean,eST.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

String bean_id 				    = "ottransactionbean";
String bean_name 			    = "eST.OTTransactionBean";
OTTransactionBean bean	= (OTTransactionBean)getBeanObject(bean_id, bean_name, request );

//Added by MuthuN for CRF-268 PicklistBean for CSSD Transaction 
	String pick_bean_id 			=	"OTPickListBean";
	String pick_bean_name 			=	"eOT.OTPickListBean";
	OTPickListBean picklist_bean	=	(OTPickListBean)getBeanObject( pick_bean_id, pick_bean_name, request );
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='StyleSheet' href='../../eCommon/html/Tabs.css' type='text/css'/>

	<script src="../../eOT/js/Booking.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
	<script language="JavaScript" src="../../eOT/js/PickList.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loaddefaultcodes();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PickListItemSelect" id="PickListItemSelect" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>"/>
<%	
    String facilityid=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt_count=null;//Added by MuthuN
	PreparedStatement pstmt_count_pick=null;//Added by MuthuN
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt_st=null;
	PreparedStatement pstmt_doc_type=null;
	PreparedStatement pstmt_st_intf=null;
	ResultSet rst=null;
	ResultSet rst_count=null;//Added by MuthuN
	ResultSet rst_count_pick=null;//Added by MuthuN
	ResultSet rst_st_intf=null;
	ResultSet rset_doc_type=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet  rst_st=null;
	ResultSet rs_req_store=null;
	ResultSet rs_reqdesc=null;
	ResultSet rs_issdesc=null;
	Statement stmt1=null;
	Statement stmt_store_desc=null;
	/*Below parameters for loading purpose */
	String doc_type_code			=		request.getParameter("cssd_doc_type");
	//System.out.println("doc_type_code in ItemSelect.jsp ===> "+doc_type_code);
	String doc_no					=		request.getParameter("doc_no");
	String doc_date					=		request.getParameter("doc_date");
	String req_by_store_code		=		request.getParameter("cssd_store_req");
	String req_on_store_code		=		request.getParameter("cssd_store_ret");
	String entry_completed_yn		=		request.getParameter("entry_completed_yn");
	String request_type				=		request.getParameter("request_type");
	//Bean Concept for CSSD Request
	String ot_Param ="";//Added By MuthuN
	String strCssdStatus ="";	
	String mode="";	
	int noofunits=0;
    int	no_of_units=0;
	int cssd_quantity =0;
	int strquantityAvail=0;
	//Bean Concept for CSSD Request
	String strPatientId="";
	String strSurgeryDate="";
	String strSurgeonCode="";
	String strBookingNum="";
	String strOperCode="";
	String strOperRoomCode="";
	String strItemType="";
	String strItemId="";
	String strItemDesc="";
	String strItemTypeDesc="";
	String strReq_code="";
	String strReq_on_code="";
	String strReserve_qty="";
	String strRequest_qty="";
	String from_val="PI";
	String avail_stock ="";
	String St_module_install ="";
	String sql="";
	String st_doc_type_rti="";
	String st_doc_type_sli="";
	String st_interface_flag="";
	String cssd_store_ret="";
	strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));	
	strSurgeryDate=CommonBean.checkForNull(request.getParameter("surgery_date"));	
	strSurgeonCode=CommonBean.checkForNull(request.getParameter("surgeoncode"));
	strBookingNum=CommonBean.checkForNull(request.getParameter("booking_no")); 
	strOperCode=CommonBean.checkForNull(request.getParameter("oper_code"));
	strOperRoomCode=CommonBean.checkForNull(request.getParameter("oper_room_code"));
	//from_val=CommonBean.checkForNull(request.getParameter("from_val"));
	//from_val=checkForNull(request.getParameter("from_val"));
	from_val=request.getParameter("from_val");
	if(from_val ==null) from_val="PI";
	ArrayList picklist_array	= null;
try{
	 conn = ConnectionManager.getConnection(request);
	 stmt1 = conn.createStatement();
	 stmt_store_desc = conn.createStatement();
	// Added newly by MuthuN against CRF-268 Starts	

	//Based on Site Param
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
		pstmt = conn.prepareStatement(sqlOtParam);
		pstmt.setString(1,facilityid);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");
		}
		pstmt = null;
		rs = null; %>
	<input type='hidden' name='surgery_date' id='surgery_date' value='<%=strSurgeryDate%>'>
	<input type='hidden' name='ot_Param' id='ot_Param' value='<%=ot_Param%>'>
	<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>
<%
if(from_val.equals("IE"))
	{
	//Based on the Parameter Value
	if("Y".equalsIgnoreCase(ot_Param)){ 
		//sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY , REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY , CSSD_STATUS FROM OT_PICK_LISTS WHERE FINALIZED_YN = 'N' AND	OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')		= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND	 BOOKING_NUM		= ? AND   	 OPER_CODE			= ? AND ITEM_TYPE IN ('I','E')";
		sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY , REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY , CSSD_STATUS FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')		= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND	 BOOKING_NUM		= ? AND   	 OPER_CODE			= ? AND ITEM_TYPE IN ('I','E')";			
	}else{
		sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY , REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY , CSSD_STATUS FROM OT_PICK_LISTS WHERE FINALIZED_YN = 'N' AND	OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')		= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND	 BOOKING_NUM		= ? AND   	 OPER_CODE			= ? AND ITEM_TYPE IN ('I','E')";
	}
	}else if(from_val.equals("PI"))
	{
		sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY, REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY, CSSD_STATUS  FROM OT_PICK_LISTS WHERE FINALIZED_YN = 'N' AND	OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')		= ? AND	 NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND	 BOOKING_NUM		= ? AND   	 OPER_CODE			= ? AND ITEM_TYPE ='S'";
	}else if(from_val.equals("PD"))
	{
		sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY, REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY, CSSD_STATUS  FROM OT_PICK_LISTS WHERE FINALIZED_YN = 'N' AND	OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')		= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND	 BOOKING_NUM		= ? AND   	 OPER_CODE			= ? AND ITEM_TYPE ='R' ";
	}else if(from_val.equals("PP"))
	{
	 //Based on the Parameter Value
	 if("Y".equalsIgnoreCase(ot_Param)){ 
		//sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY, REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY, CSSD_STATUS FROM OT_PICK_LISTS WHERE FINALIZED_YN = 'N' AND	OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')	= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND BOOKING_NUM = ? AND  OPER_CODE	= ? AND ITEM_TYPE ='P'";
		sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY, REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY, CSSD_STATUS FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID	= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')	= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND BOOKING_NUM		= ? AND  OPER_CODE	= ? AND ITEM_TYPE ='P'";
		}else{
		sql="SELECT ITEM_TYPE ITEM_TYPE1, DECODE(ITEM_TYPE,'I', 'Instrument', 'E', 'Equipment', 'P', 'Package', 'S', 'Implant','R','Resource Type') ITEM_TYPE_DESC1 , ITEM_ID ITEM_ID1, NO_OF_UNITS QTY, REQ_STORE_CODE,REQ_ON_STORE_CODE,RESERVED_QTY,REQUESTED_QTY, CSSD_STATUS  FROM OT_PICK_LISTS WHERE FINALIZED_YN = 'N' AND	OPERATING_FACILITY_ID 	= ?  AND PATIENT_ID			= ? AND	 TO_CHAR(SURGERY_DATE,'dd/mm/yyyy')		= ? AND	  NVL(TEAM_DOCTOR_CODE,'X')	= NVL(?,'X') AND	 BOOKING_NUM		= ? AND   	 OPER_CODE			= ? AND ITEM_TYPE ='P'";
	}
	}

String sql_st="select INSTALL_YN from sm_module where MODULE_ID='ST' ";

     pstmt_st=conn.prepareCall(sql_st);
	  rst_st=pstmt_st.executeQuery();
	  if(rst_st !=null && rst_st.next())
	  {
		St_module_install=rst_st.getString("INSTALL_YN");
	  }
String sql_st_intf="select NVL(ST_INTERFACE_FLAG,'N')  ST_INTERFACE_FLAG FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID ='"+facilityid+"'";

   pstmt_st_intf=conn.prepareCall(sql_st_intf);
	  rst_st_intf=pstmt_st_intf.executeQuery();
	  if(rst_st_intf !=null && rst_st_intf.next())
	  {
		st_interface_flag=rst_st_intf.getString("ST_INTERFACE_FLAG");
	  }	  
	  
	  if(St_module_install.equals("Y"))
		 {
if(st_interface_flag.equals("Y"))
			 {
if(from_val.equals("PI"))
		 {
	String sql_doc_type="SELECT ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+facilityid+"'";

			pstmt_doc_type=conn.prepareCall(sql_doc_type);
			rset_doc_type=pstmt_doc_type.executeQuery();

			if(rset_doc_type !=null && rset_doc_type.next())
			{
				st_doc_type_rti =rset_doc_type.getString("ST_DOC_TYPE_RTI");
				if(st_doc_type_rti==null) st_doc_type_rti="";
				st_doc_type_sli=rset_doc_type.getString("ST_DOC_TYPE_SLI");
				if(st_doc_type_sli==null) st_doc_type_sli="";
			}
		if(st_doc_type_rti.equals("") || st_doc_type_sli.equals(""))
		{
			out.println("<script>alert(getMessage('PRC-OT0055','OT')); history.go(-1);</script>");
		}
		 }
  }
}
if(rst_st !=null) rst_st.close();
     pstmt=conn.prepareCall(sql);

	 if(strSurgeonCode.equals("*ALL")) strSurgeonCode="";

	 pstmt.setString(1,facilityid);
	 pstmt.setString(2,strPatientId);
	 pstmt.setString(3,strSurgeryDate);
     pstmt.setString(4,strSurgeonCode);
     pstmt.setString(5,strBookingNum);
	 pstmt.setString(6,strOperCode);

	 rst=pstmt.executeQuery();
	 System.out.println("after EXECUTE QUERY");
	 int index=0;
	 String sql1="";
	 String sql_mm_code="";
	 String mm_item_code="";
	 String req_desc="";
	 String iss_desc="";
	 String fin_req_val="";
	 String fin_iss_val="";

	 while(rst.next()){

		++index;
		strItemType=CommonBean.checkForNull(rst.getString("ITEM_TYPE1"));
		strItemId=CommonBean.checkForNull(rst.getString("ITEM_ID1"));
		strReq_code=CommonBean.checkForNull(rst.getString("REQ_STORE_CODE"));
		strReq_on_code=CommonBean.checkForNull(rst.getString("REQ_ON_STORE_CODE"));
		strReserve_qty=CommonBean.checkForNull(rst.getString("RESERVED_QTY"));
		strRequest_qty=CommonBean.checkForNull(rst.getString("REQUESTED_QTY"));	
		strCssdStatus=CommonBean.checkForNull(rst.getString("CSSD_STATUS"));//Added by MuthuN
	
		if(St_module_install.equals("Y"))
		{		

		String req_store="SELECT SHORT_DESC FROM  MM_STORE_LANG_VW  WHERE STORE_CODE='"+strReq_code+"'	and language_id='"+locale+"'";
		rs_reqdesc=stmt_store_desc.executeQuery(req_store);

			if(rs_reqdesc !=null && rs_reqdesc.next())
			 {
				req_desc=rs_reqdesc.getString("SHORT_DESC");
			 }

		String iss_store="SELECT SHORT_DESC FROM  MM_STORE_LANG_VW  WHERE STORE_CODE='"+strReq_on_code+"'	and language_id='"+locale+"'";
		rs_issdesc=stmt_store_desc.executeQuery(iss_store);

			if(rs_issdesc !=null && rs_issdesc.next())
			 {
				iss_desc=rs_issdesc.getString("SHORT_DESC");
			 }
			

		fin_req_val= strReq_code+"|"+req_desc;
		fin_iss_val= strReq_on_code+"|"+iss_desc;

					if(!strItemId.equals("") && !strReq_code.equals(""))
		 {

					  sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+strItemId+"'";
					  pstmt_st=conn.prepareCall(sql_mm_code);
					  rst_st=pstmt_st.executeQuery();
	
				if(rst_st !=null && rst_st.next())
				{
					mm_item_code=rst_st.getString(1);
				}
		try 
			 {
			String[] stParameters = {mm_item_code, strReq_code, "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
			avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
			}catch(Exception e)
			 {
				out.println("<script>alert(getMessage('PRC-OT0054','OT'));return;</script>");
			 }
		 }
		 }
if(from_val.equals("IE"))
	{
		if(strItemType.equals("I"))
		{
			sql1=OTRepository.getOTKeyValue("SQL_OT_PICKVIEWITEM_SELECT2");
		}else if(strItemType.equals("E"))
		{
			sql1=OTRepository.getOTKeyValue("SQL_OT_PICKVIEWITEM_SELECT4");
		}
			
	}else if(from_val.equals("PI"))
		 {
		if(strItemType.equals("S"))
			 {
			sql1=OTRepository.getOTKeyValue("SQL_OT_PICKVIEWITEM_SELECT5");
			 }
			
		 }else if(from_val.equals("PD"))		
		 {
		if(strItemType.equals("R"))
			sql1=OTRepository.getOTKeyValue("SQL_OT_PICKVIEWITEM_SELECT6");
		 }else if(from_val.equals("PP"))
		 {
			 if(strItemType.equals("P"))
			 {
			sql1=OTRepository.getOTKeyValue("SQL_OT_PICKVIEWITEM_SELECT3");
			 }
		 }
			pstmt1=conn.prepareCall(sql1);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,strItemId);
			rs=pstmt1.executeQuery();

		if(rs !=null && rs.next()){
		    strItemDesc=rs.getString("ITEM_DESC1");
		}

		if(rs!=null) 
			rs.close();
		pstmt1.close();
	    strItemTypeDesc=CommonBean.checkForNull(rst.getString("ITEM_TYPE_DESC1"));

	    strItemTypeDesc=strItemTypeDesc.replace('\'','`');
		
		strItemDesc=strItemDesc.replace('\'','`');		

//Based on the Parameter Value
	if("Y".equalsIgnoreCase(ot_Param)){	out.println("<script>loadDBRows_pick('"+strItemType+"','"+strItemTypeDesc+"','"+strItemDesc+"','"+strItemId+"','"+strCssdStatus+"','"+strquantityAvail+"','"+CommonBean.checkForNull(rst.getString("QTY"))+"','"+index+"','"+fin_req_val+"','"+fin_iss_val+"','"+strReserve_qty+"','"+strRequest_qty+"','"+avail_stock+"'); </script>");
	}else{		out.println("<script>loadDBRows('"+strItemType+"','"+strItemTypeDesc+"','"+strItemDesc+"','"+strItemId+"','"+CommonBean.checkForNull(rst.getString("QTY"))+"','"+index+"','"+fin_req_val+"','"+fin_iss_val+"','"+strReserve_qty+"','"+strRequest_qty+"','"+avail_stock+"'); </script>");	
	 }
	 }
   out.println("<script>refresh()</script>");
%>

<table cellpadding=3  cellspacing="0" border="0" width="100%" align="center">
<tr> 
	<td class='label' width="25%" nowrap>
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" nowrap>
		<input type='text' name='patientid' id='patientid' maxlength='20' size='20' value= "<%=strPatientId%>" disabled>
	</td>
	<td class='label' width="25%"nowrap>
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" nowrap>
		<input type='text' name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=strOperCode%>" disabled>
	</td>
</tr>

<tr>
	<td class='label' width="25%" nowrap>
		<fmt:message key="eOT.BookingNO.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" nowrap>
		<input type='text' name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=strBookingNum%>" disabled>
	</td>
	<td class='label' width="25%" nowrap>
		<fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" nowrap>
	<% 
		if(strBookingNum.length()==0) 
			out.println("<select name='item_type' id='item_type' DB_VALUE='' disabled>");
		else
			out.println("<select name='item_type' id='item_type' DB_VALUE='' onchange=\"changelabel()\" >");
	%>
	<%if(from_val.equals("IE")) {%>
		<option value='' >
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
		<%}%>
		<%if(from_val.equals("IE")) {%>
		<option value='I' >
		<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/> </option>
		<option value='E' >
		<fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
		</option>
		<%}else if(from_val.equals("PI")) {%>
		<option value='S' >
		<fmt:message key="Common.Implant.label" bundle="${common_labels}"/></option>
		<%}else if(from_val.equals("PD")) {%>
		<option value='R' >
		<fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/>
		</option>
		<%}else if(from_val.equals("PP")){%>
			<option value='P' >
		<fmt:message key="Common.Package.label" bundle="${common_labels}"/></option>
		<%}%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td class='label' width="25%" nowrap>
		<fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" nowrap>
		<input type='text' name='item_desc' id='item_desc' size='20'  onblur='searchItemSelect(this);quantityavail(this)' value='' maxlength='20' >
	<% 
		if(strBookingNum.length()==0) 
			 out.println("<input type='button' class='button' value='?' name='chkbut' id='chkbut' onClick=\"searchItemSelect(item_desc)\" disabled >");
		else
			//out.println("<input type='button' class='button' value='?' name='chkbut' id='chkbut' onClick='searchItemSelect(item_desc);'  >");
			out.println("<input type='button' class='button' value='?' name='chkbut' id='chkbut' onClick='searchItemSelect(item_desc);quantityavail(this)'  >");
	%>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>

<!-- Added by MuthuN against CRF-268 Starts Here -->
<%
if(from_val.equals("IE")){
if("Y".equalsIgnoreCase(ot_Param)){ 
%>
	<td class='label' width="25%" id='noofqtyaval' nowrap>	
		<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>
		<fmt:message key="Common.available.label" bundle="${common_labels}"/>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td class='fields' width="25%"id='quantity_available' nowrap>
	<input type='text' name='quantity_avail' id='quantity_avail' size='10' value='' maxlength='6' OnBlur='chknum(this);' onkeypress='return checkForSpecCharsforID(event);'>
	</td>
	<%}
	}%>	
	<!-- Added by MuthuN against CRF-268 Ends Here -->

	<!-- Added by MuthuN against CRF-268 Starts Here-->	
	<%
	if(from_val.equals("PP")){
	if("Y".equalsIgnoreCase(ot_Param)){ 	
	%>
	<td class='label' width="25%" id='noofqtyaval' nowrap>	
		<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>
		<fmt:message key="Common.available.label" bundle="${common_labels}"/>	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	<td class='fields' width="25%"id='quantity_available' nowrap>
	<input type='text' name='quantity_avail' id='quantity_avail' size='10' value='' maxlength='6' OnBlur='chknum(this);' onkeypress='return checkForSpecCharsforID(event);'>
	</td>
	<%}
	}%>	
	<!-- Added by MuthuN against CRF-268 Ends Here -->
</tr>

<tr>
	<%if(from_val.equals("PD")){%>
	<td class='label' width="25%"id='noofperorunits' nowrap>
		<fmt:message key="eOT.NoOfPersons.Label" bundle="${ot_labels}"/>		
	</td>
	<%}else if(from_val.equals("IE")){%>
	<td class='label' width="25%"id='noofperorunits' nowrap>
		<fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/>
	</td>
	<%}else {%>
	<td class='label' width="25%"id='noofperorunits' nowrap>
		<fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/>		
	</td>
	<%}%>
	<%if(from_val.equals("IE")){%>
	<td class='fields' width="25%" id='noofperorunits' nowrap>
		<% 
		 if(strBookingNum.length()==0) {
			 out.println("<input type='text' name='quantity' id='quantity' size='6'  value='' maxlength='6' OnBlur='validateUnits(this)' disabled>");
			} else{
			out.println("<input type='text' name='quantity' id='quantity' size='6'  value='' maxlength='6' OnBlur='chknum(this);' onkeypress='return checkForSpecCharsforID(event);' >");
			 }
	 %>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
<%}else{%>
	<td class='fields' width="25%"id='noofperorunits' nowrap>
	<% 
		 if(strBookingNum.length()==0) {
			 out.println("<input type='text' name='quantity' id='quantity' size='6'  value='' maxlength='6' OnBlur='validateUnits(this)' disabled>");
	 }else{
		out.println("<input type='text' name='quantity' id='quantity' size='6'  value='' maxlength='6' OnBlur='chknum(this);' onkeypress='return checkForSpecCharsforID(event);' >");
	 }
	 %>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
		<%}%>
</tr>
	
	<%if(from_val.equals("PI") && st_interface_flag.equals("Y")) {%>
<tr> 

	<td class='label' width="25%" nowrap>	<fmt:message key="eOT.RequestingStore.Label" bundle="${ot_labels}"/></td>
	
	<td class='fields' width="25%" nowrap>
		<select name='requeststore' id='requeststore' tabindex=0  onchange = 'select_request_store(this)'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
<%
String store_code="";
String store_desc="";
String sql_req_store="";

		 sql_req_store="SELECT a.STORE_CODE,b.SHORT_DESC FROM OT_STORES_FOR_THEATRE a, MM_STORE_LANG_VW b WHERE a.STORE_CODE=b.STORE_CODE AND  a.STORE_TYPE='R' AND a.OPERATING_FACILITY_ID='"+facilityid+"' AND a.OPER_ROOM_CODE='"+strOperRoomCode+"' and b.language_id='"+locale+"'";
			rs_req_store=stmt1.executeQuery(sql_req_store);

			if(rs_req_store !=null)
		{
			while(rs_req_store.next())
			{
				store_code=rs_req_store.getString("STORE_CODE");
				store_desc=rs_req_store.getString("SHORT_DESC");
		%>		<option value='<%=store_code%>|<%=store_desc%>'><%=store_desc%>
			<%}
		}
%>
</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>

<td class='label' width="25%" nowrap><fmt:message key="eOT.IssuingStore.Label" bundle="${ot_labels}"/></td>
<td class='fields' width="25%" nowrap><select name='issuing_store' id='issuing_store' tabindex=0 onchange = 'select_issue_store(this)'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
	
	<%
String store_iss_code="";
String store_iss_desc="";
String default_store="";
String sql_iss_store="";

		 sql_iss_store="SELECT a.STORE_CODE,b.SHORT_DESC,a.DEFAULT_YN FROM OT_STORES_FOR_THEATRE a, MM_STORE_LANG_VW b WHERE a.STORE_CODE=b.STORE_CODE AND  a.STORE_TYPE='I' AND a.OPERATING_FACILITY_ID='"+facilityid+"' AND a.OPER_ROOM_CODE='"+strOperRoomCode+"' and b.language_id='"+locale+"'";
			rs_req_store=stmt1.executeQuery(sql_iss_store);

			if(rs_req_store !=null)
		{
			while(rs_req_store.next())
			{
				store_iss_code=rs_req_store.getString("STORE_CODE");
				store_iss_desc=rs_req_store.getString("SHORT_DESC");
				default_store=rs_req_store.getString("DEFAULT_YN");
		%>		<option value='<%=store_iss_code%>|<%=store_iss_desc%>'><%=store_iss_desc%>
			<%}
		}

%>
	
	</select>		<img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
	<tr>
	<td class='label' width="25%" nowrap><fmt:message key="eOT.QOHofReqStore.Label" bundle="${ot_labels}"/>&nbsp;<input type='text' name='QOHqty_qty' id='QOHqty_qty' size='6'   disabled value='' maxlength='6' >
	</td>
	<td class='label' width="25%" nowrap><fmt:message key="eOT.ReserveQty.Label" bundle="${ot_labels}"/>&nbsp;<input type='text' name='reserve_qty' id='reserve_qty' size='6'  onkeypress="return checkForSpecCharsforID(event);" onblur='chknum(this)' value='' maxlength='6'  disabled>
	</td>
	<td class='label' width="25%" nowrap><fmt:message key="eOT.RequestQty.Label" bundle="${ot_labels}"/>&nbsp;<input type='text' name='request_qty' id='request_qty' size='6'   onkeypress="return checkForSpecCharsforID(event);" onblur="chknum(this)" value='' maxlength='6'  >
	</td> </tr>
	<%}%>


<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.SelectDeselectAll.Label" bundle="${ot_labels}"/>
	</td>
	<td  class='fields' width="25%" >
		<input type='checkbox' name='select' id='select' onClick='selectDeselect(this)'>
	</td>
	<td  width="35%">

		<input type='button' class='button' name='selec' id='selec' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'>
	
		<input type='button' name='cancel' id='cancel' class='button' value="<fmt:message key='Common.cancel.label' bundle='${common_labels}'/>" onClick='removeRow();' disabled>
		
		<input type='button' class='button' value='<fmt:message key="eOT.Finalise.Label" bundle="${ot_labels}"/>' onClick='applyRecord();' >
	</td>
	<td class='label' width="25%" nowrap>
		&nbsp;
	</td>
</tr>

</table>

   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

	<input type='hidden' name='patient_id' id='patient_id' value='<%=strPatientId%>'>
	<!--<input type='hidden' name='surgery_date' id='surgery_date' value='<%=strSurgeryDate%>'>-->
	<input type='hidden' name='surgeoncode' id='surgeoncode' value='<%=strSurgeonCode%>'>
	<input type='hidden' name='booking_no' id='booking_no' value='<%=strBookingNum%>'>
	<input type='hidden' name='oper_code' id='oper_code' value='<%=strOperCode%>'>
	<input type='hidden' name='item_id' id='item_id' value=''>
	<input type='hidden' name='recId' id='recId' value=''>
	<input type='hidden' name='mode' id='mode' value='I'>
	<input type='hidden' name='exist_db' id='exist_db' value=''>
	<!--<input type='hidden' name='locale' id='locale' value="<%=locale%>">-->
	<input type='hidden' name='from_val' id='from_val' value="<%=from_val%>">
	<input type='hidden' name='OperRoomCode' id='OperRoomCode' value="<%=strOperRoomCode%>">
	<input type='hidden' name='St_module_install' id='St_module_install' value="<%=St_module_install%>">
	<input type='hidden' name='st_interface_flag' id='st_interface_flag' value="<%=st_interface_flag%>">
	<input type='hidden' name='strReq_code' id='strReq_code' value="<%=strReq_code%>">
	<input type='hidden' name='strReq_on_code' id='strReq_on_code' value="<%=strReq_on_code%>">

	<!-- Added by muthuN against BRU-CRF-268 -->
	<input type='hidden' name='quantity_avail1' id='quantity_avail1' value="<%=strquantityAvail%>">
	<input type='hidden' name='index' id='index' value='<%=index%>'>
	<input type='hidden' name='quantity1' id='quantity1' value='<%=noofunits%>'>
	<input type='hidden' name='cssdStatus' id='cssdStatus' value='<%=strCssdStatus%>'>
	<!--<input type='hidden' name='ot_Param' id='ot_Param' value='<%=ot_Param%>'>
	<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>-->

<%}catch(Exception ee){
	System.err.println("Err Msg in PickListReviewItemSelect.jsp"+ee);	
}
finally{
	if(rst!=null) rst.close();
	pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}%>

</form>
</body>
</html>

