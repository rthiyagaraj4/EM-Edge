<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*,java.sql.Connection,  java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)
session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


//Added by MuthuN for CRF-268 PicklistBean for CSSD Transaction 
	String pick_bean_id 			=	"OTPickListBean";
	String pick_bean_name 			=	"eOT.OTPickListBean";
	OTPickListBean picklist_bean	=	(OTPickListBean)getBeanObject( pick_bean_id, pick_bean_name, request );
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
 	<script src="../../eOT/js/PickList.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String from_val="";
	from_val=request.getParameter("from_val");
	String patient_id	= request.getParameter("patient_id");
	String mode=request.getParameter("mode");
	if(mode ==null) mode="I";
	if(from_val ==null) from_val="PI";

	String surgeryDate = CommonBean.checkForNull(request.getParameter("surgeryDate"));
	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num"));
	String facilityid	= (String)session.getValue("facility_id");	
	String req_on_store_code = CommonBean.checkForNull(request.getParameter("req_on_store_code"));
	String req_by_store_code = CommonBean.checkForNull(request.getParameter("req_by_store_code"));
	String strItemId =CommonBean.checkForNull(request.getParameter("item_id"));
	String item_type =CommonBean.checkForNull(request.getParameter("item_type"));
	String noofunits = CommonBean.checkForNull(request.getParameter("noofunits"));
	String quantity_available_cssd = CommonBean.checkForNull(request.getParameter("qtyavail"));
	//Condition Below for requesting the quantity from the CSSD 
	int request_qty = (Integer.parseInt(noofunits)-Integer.parseInt(quantity_available_cssd));	
	String group_type ="";
	String req_group_code="";
	String description="";
	String available_qty="";
	String group_code ="";	
	String ot_Param="";
	
	Connection conn   = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_count = null;
	PreparedStatement pstmt_count_pick = null;
	PreparedStatement pstmt_group = null;
	ResultSet rs = null;
	ResultSet rst_count = null;
	ResultSet  rst_count_pick = null;
	ResultSet  rst_group = null;
	ArrayList picklist_array	= null;
	try{
		conn	= ConnectionManager.getConnection(request);
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
		pstmt = conn.prepareStatement(sqlOtParam);
		pstmt.setString(1,facilityid);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");
		}
		pstmt = null;
		rs = null;

	//To find the group_code in instrument for the specified Instrument Code(item_id) as well as Package Code 
	/* Based on the Item_type the query will execute and generate the ArrayList of HashMap values */
	if(item_type.equalsIgnoreCase("I")){
		String sql_group_code ="select SS_GROUP_CODE from ot_instrument where status ='E' and INSTR_CODE ='"+strItemId+"'";
		pstmt_group = conn.prepareStatement(sql_group_code);
		rst_group = pstmt_group.executeQuery();
		while(rst_group!=null && rst_group.next()){
			group_code=rst_group.getString(1);
		}


		/* Below Query is to get the Group Related values */
		String sql_group_pick = "SELECT  sg.group_type, st.group_code, sg.short_desc group_desc, SUM (CASE WHEN status = 'S' THEN 1 ELSE 0 END) sterlized FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code AND st.group_code = sg.group_code   AND st.owner_store_code LIKE ('"+req_on_store_code+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+req_on_store_code+"') AND sg.group_type LIKE ('%') AND st.group_code LIKE ('"+group_code+"') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id AND ms.language_id = '"+locale+"' GROUP BY st.group_code, ms.short_desc, sg.group_type, sg.short_desc";

		pstmt_count_pick = conn.prepareStatement(sql_group_pick) ;
		rst_count_pick = pstmt_count_pick.executeQuery();
		if(picklist_bean.getPickList() != null) picklist_array=picklist_bean.getPickList();
		else picklist_array = new ArrayList();		

		while(rst_count_pick!=null && rst_count_pick.next()){
			group_type=rst_count_pick.getString(1);
			req_group_code=rst_count_pick.getString(2);
			description=rst_count_pick.getString(3);
			available_qty=rst_count_pick.getString(4);		
			
		//HashMap for passing the request to the RequestGroup Page
			HashMap hash = new HashMap(); 
			hash.put("group_type", group_type);
			hash.put("req_group_code", req_group_code);
			hash.put("auth_group_code", req_group_code);
			hash.put("request_qty", request_qty);
			hash.put("description", description);
			hash.put("auth_group_desc", description);
			hash.put("available_qty", available_qty);
			hash.put("mode", 1);
			picklist_array.add(hash);
		}
		picklist_bean.setPickList(picklist_array);
	}else if(item_type.equalsIgnoreCase("P")){
		String sql_group_code ="select SS_GROUP_CODE from ot_package_hdr where status ='E' and PACKAGE_CODE ='"+strItemId+"'";
		pstmt_group = conn.prepareStatement(sql_group_code);
		rst_group = pstmt_group.executeQuery();
		while(rst_group!=null && rst_group.next()){
			group_code=rst_group.getString(1);
		}


		/* Below Query is to get the Group Related values */
		String sql_group_pick = "SELECT  sg.group_type, st.group_code, sg.short_desc group_desc, SUM (CASE WHEN status = 'S' THEN 1 ELSE 0 END) sterlized FROM ss_tray_dtls st, mm_store_lang_vw ms, mm_store_lang_vw ms1, ss_group_lang_vw sg WHERE st.status <> 'W' AND st.owner_store_code = ms.store_code AND NVL (curr_store_code, owner_store_code) = ms1.store_code AND st.group_code = sg.group_code   AND st.owner_store_code LIKE ('"+req_on_store_code+"') AND NVL (curr_store_code, owner_store_code) LIKE ('"+req_on_store_code+"') AND sg.group_type LIKE ('%') AND st.group_code LIKE ('"+group_code+"') AND ms.language_id = ms1.language_id AND ms.language_id = sg.language_id AND ms.language_id = '"+locale+"' GROUP BY st.group_code, ms.short_desc, sg.group_type, sg.short_desc";

		pstmt_count_pick = conn.prepareStatement(sql_group_pick) ;
		rst_count_pick = pstmt_count_pick.executeQuery();
		if(picklist_bean.getPickList() != null) picklist_array=picklist_bean.getPickList();
		else picklist_array = new ArrayList();

		while(rst_count_pick!=null && rst_count_pick.next()){
			group_type=rst_count_pick.getString(1);
			req_group_code=rst_count_pick.getString(2);
			description=rst_count_pick.getString(3);
			available_qty=rst_count_pick.getString(4);		
			
		//HashMap for passing the request to the RequestGroup Page
			HashMap hash = new HashMap(); 
			hash.put("group_type", group_type);
			hash.put("req_group_code", req_group_code);
			hash.put("auth_group_code", req_group_code);
			hash.put("request_qty", request_qty);
			hash.put("description", description);
			hash.put("auth_group_desc", description);
			hash.put("available_qty", available_qty);
			hash.put("mode", 1);
			picklist_array.add(hash);
		}
		picklist_bean.setPickList(picklist_array);
	}

%>
<body onLoad='' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='PickListFinalDtl' id='PickListFinalDtl'>
<%
  String flag=CommonBean.checkForNull(request.getParameter("flag"));
  if(flag.length()==0)
  flag="0";
	%>
<%
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
		e.printStackTrace() ;
	}finally {
		try{			
			if(rs!=null) rs.close();   
			if(rst_count!=null) rst_count.close();
			if(rst_count_pick!=null) rst_count_pick.close();
			if(rst_group!=null) rst_group.close();
			if(pstmt!=null) pstmt.close();     
			if(pstmt_count!=null) pstmt_count.close();
			if(pstmt_count_pick!=null) pstmt_count_pick.close();
			if(pstmt_group!=null) pstmt_group.close();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}catch(Exception es){}
	}
%>
</form>
</body>
</html>

