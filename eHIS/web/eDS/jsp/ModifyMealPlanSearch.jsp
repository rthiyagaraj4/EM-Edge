<!DOCTYPE html>
<%@  page import="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
<%
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eDS/js/ModifyMealPlan.js'></script>
</head>
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eBL/js/BLEnterServiceRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection conn	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	try
	{
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		//Checkstyle Violation commented by Munisekhar
		//String params = request.getQueryString();
		String locale = (String)session.getAttribute("LOCALE");
		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";
		String strloggeduser =  (String) session.getValue("login_user");
		if (strloggeduser==null) strloggeduser = "";
		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
		String patient_id = request.getParameter("patient_id");
		if(patient_id==null) patient_id="";
		String episode_type = request.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		String episode_id = request.getParameter("episode_id");
		if(episode_id==null) episode_id="";
		String visit_id = request.getParameter("visit_id");
		if(visit_id==null) visit_id="";
		String encounter_id = request.getParameter("encounterId");
		if(encounter_id==null) encounter_id="";
		//String service_date = request.getParameter("servingDate");
		String service_date = com.ehis.util.DateUtils.convertDate(request.getParameter("servingDate"),"DMY",locale,"en");
		if(service_date==null) service_date="";
		String kitchenCode = request.getParameter("kitchenCode");
		if(kitchenCode==null) kitchenCode="";
		String mealType = request.getParameter("mealType");
		if(mealType==null) mealType="";
		String dietType = request.getParameter("dietType");
		if(dietType==null) dietType="";
		String frequency = "";
		String flag ="";
		String mode="";

		String class_val = "";
		int rowCount=0;
		String item_slr   = "";
		String item_Type   = "";
		String item_Code   = "";
		String short_Desc   = "";
		// Added for INC 41451
		String short_Desc1   = "";
		String item_Qty   = "";
		String meal_Category   = "";
		String patient_Class = "";
		String serving_Uom_Code = "";
		String spl_Food_Item_Yn = "";
		String freq_Yn = "";
		String status = "";
		String rowNum = "";
		//Added for MMS-KH-CRF-0029.1 - US009
		String remarks = "";
		String enbDrugYN = "";

%>

<form name="ModifyMealPlanSearch_form" id="ModifyMealPlanSearch_form"  onload='FocusFirstElement()'  action="../../servlet/eDL.ModifyMealPlanServlet" method="post" target="messageFrame">

	<table id="listContentTable" border='1' cellpadding=0  cellspacing='0' width='100%'>
	<tr>
			<th class='columnheader'>
				<fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>
			</th>
			<th class='columnheader'>
				<fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/>
			</th>
			<th class='columnheader'>
				<fmt:message key="Common.item.label" bundle="${common_labels}"/>
			</th>
			<th class='columnheader'>
				<fmt:message key="eOT.ServingQty.Label" bundle="${ot_labels}"/>
			</th>
			<th class='columnheader' width = '25%'>
				<fmt:message key="eOT.SpclFoodItems.Label" bundle="${ot_labels}"/>
			</th>
			<th class='columnheader'>
				<fmt:message key="eOT.Freq.Label" bundle="${ot_labels}"/>
			</th>
	</tr>
<!-- modified by N Munisekhar on 21-May-2013 against [IN39611]-->
<!-- modified by Subhani on 09-July-2013 against [INC 41451]-->
<% if ( (!kitchenCode.equals("")) && (kitchenCode!=null)) {
		conn	=	ConnectionManager.getConnection(request);

		String sql1="";
		sql1 = "select rowNum, plandtl.item_Sl,plandtl.item_Type,plandtl.item_Code,items.short_Desc as itemShortDesc ,itmtype.short_desc as itemTypeShortDesc,plandtl.item_Qty, plandtl.meal_Category,plandtl.patient_Class,planhdr.status,items.serving_Uom_Code,plandtl.spl_Food_Item_Yn,plandtl.freq_Yn,to_char(plandtl.serving_Date,'dd/mm/yyyy') from Ds_Epsd_Meal_Plan_Dtl plandtl ,Ds_Epsd_Meal_Plan_Hdr planhdr,Ds_Items items,ds_Item_Type itmtype where plandtl.operating_Facility_Id = planhdr.operating_facility_Id and plandtl.encounter_Id = planhdr.encounter_Id and   plandtl.serving_Date = planhdr.serving_Date and plandtl.meal_Type = planhdr.meal_Type and plandtl.item_Code = items.food_Item_Code and plandtl.item_type = itmtype.item_type and plandtl.operating_Facility_Id like '"+facilityid+"' and to_char(plandtl.serving_Date,'dd/mm/yyyy') like '"+service_date+"' and plandtl.kitchen_Code like '"+kitchenCode+"' and plandtl.encounter_Id like nvl('"+encounter_id+"',plandtl.encounter_Id) and nvl(planhdr.diet_Type,'##') like nvl('"+dietType+"','##') and nvl(planhdr.meal_Type,'##') like nvl('"+mealType+"','##') and  items.language_Id like '"+locale+"' ORDER BY item_sl ASC ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		if(rs!=null){
			while(rs.next())
			{
					rowNum = rs.getString(1);
					item_slr=rs.getString(2);
					item_Type=rs.getString(3);
					item_Code=rs.getString(4);
					short_Desc=rs.getString(5);
					short_Desc1=rs.getString(6);
					item_Qty=rs.getString(7);
					meal_Category=rs.getString(8);
					patient_Class=rs.getString(9);
					status=rs.getString(10);
					serving_Uom_Code=rs.getString(11);
					spl_Food_Item_Yn=rs.getString(12);
					freq_Yn=rs.getString(13);
					service_date=rs.getString(14);
					
					if (status==null) status="";

	rowCount++;
	//IN:39963 
	out.println("<script>fetchStatusValue('"+status.toUpperCase()+"');</script>");

	out.println("<tr>");
	out.println("<td id='"+"item_slr"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:getItemDetails('"+item_slr+"','"+item_Type+"','"+item_Code+"','"+short_Desc+"','"+spl_Food_Item_Yn+"','"+freq_Yn+"','"+rowCount+"');\">"+item_slr+"</a></td><input type='hidden' name='"+"hid_item_slr"+rowCount+"' id='"+"hid_item_slr"+rowCount+"' value='"+item_slr+"'/>");

	out.println("<td id='"+"item_Type"+rowCount+"' class='"+class_val+"'>"+short_Desc1+"</td><input type='hidden' name='"+"hid_item_Type"+rowCount+"' id='"+"hid_item_Type"+rowCount+"' value='"+item_Type+"'/>");

	out.println("<td id='"+"item_Code"+rowCount+"' class='"+class_val+"'>"+short_Desc+"</td><input type='hidden' name='"+"hid_item_Code"+rowCount+"' id='"+"hid_item_Code"+rowCount+"' value='"+item_Code+"'/>");

	out.println("<td id='"+"item_Qty"+rowCount+"' class='"+class_val+"'>"+item_Qty+"</td><input type='hidden' name='"+"hid_item_Qty"+rowCount+"' id='"+"hid_item_Qty"+rowCount+"' value='"+item_Qty+"'/>");

	out.println("<td id='"+"spl_Food_Item_Yn"+rowCount+"' class='"+class_val+"'>"+spl_Food_Item_Yn+"</td><input type='hidden' name='"+"hid_spl_Food_Item_Yn"+rowCount+"' id='"+"hid_spl_Food_Item_Yn"+rowCount+"' value='"+spl_Food_Item_Yn+"'/>");

	out.println("<td id='"+"freq_Yn"+rowCount+"' class='"+class_val+"'>"+freq_Yn+"</td><input type='hidden' name='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' value='update'/><input type='hidden' name='"+"hid_freq_Yn"+rowCount+"' id='"+"hid_freq_Yn"+rowCount+"' value='"+freq_Yn+"'/>");

	out.println("</tr>");
	}
	}
	//Added for MMS-KH-CRF-0029.1 - US009 Start
	enbDrugYN = request.getParameter("enbDrugYN");
	if(enbDrugYN.equals("Y")){
		sql1 = "SELECT b.override_reason FROM ds_epsd_diet_profile_hdr a, or_order_drug_interaction b WHERE a.order_id = b.order_id AND a.encounter_id = "+encounter_id+" AND TO_DATE ('"+service_date+"', 'dd/mm/yyyy') BETWEEN period_from AND period_to and ROWNUM = 1";			
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		if(rs!=null && rs.next()){
			remarks = rs.getString(1);
		}
	}
	//Added for MMS-KH-CRF-0029.1 - US009 End
	// added by N Munisekhar on 21-May-2013 against [IN39611]
	 if(rowCount==0)
	 {
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); //history.go(-1);</script>");
	}
				rs.close();
				stmt.close();
				}
	%>
</table>
		<input type=hidden name="rowCount" id="rowCount" value="" />
		<input type=hidden name="flag" id="flag" value="<%=flag%>" />
		<input type=hidden name="item_slr" id="item_slr" value="<%=item_slr%>" />
		<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>" />
		<input type=hidden name="service_date" id="service_date" value="<%=service_date%>" />
		<input type=hidden name="kitchenCode" id="kitchenCode" value="<%=kitchenCode%>" />
		<input type=hidden name="mealType" id="mealType" value="<%=mealType%>" />
		<input type=hidden name="dietType" id="dietType" value="<%=dietType%>" />
		<input type=hidden name="frequency" id="frequency" value="<%=frequency%>" />
		<input type=hidden name="item_Type" id="item_Type" value="<%=item_Type%>" />
		<input type=hidden name="item_Code" id="item_Code" value="<%=item_Code%>" />
		<input type=hidden name="short_Desc" id="short_Desc" value="<%=short_Desc%>" />
		<input type=hidden name="item_Qty" id="item_Qty" value="<%=item_Qty%>" />
		<input type=hidden name="meal_Category" id="meal_Category" value="<%=meal_Category%>" />
		<input type=hidden name="patient_Class" id="patient_Class" value="<%=patient_Class%>" />
		<input type=hidden name="status" id="status" value="<%=status%>" />
		<input type=hidden name="spl_Food_Item_Yn" id="spl_Food_Item_Yn" value="<%=spl_Food_Item_Yn%>" />
		<input type=hidden name="serving_Uom_Code" id="serving_Uom_Code" value="<%=serving_Uom_Code%>" />
		<input type=hidden name="locale" id="locale" value="<%=locale%>" />
		<input type=hidden name="freq_Yn" id="freq_Yn" value="<%=freq_Yn%>" />
		<input type=hidden name="facilityid" id="facilityid" value="<%=facilityid%>" />
		<input type=hidden name="mode" id="mode" value="<%=mode%>" />
		<!-- Added for MMS-KH-CRF-0029.1-US009-->
		<input type=hidden name="onLoadRem" id="onLoadRem" value="<%=remarks%>" />
<%
}catch(Exception ee)
	{
		out.println("from main :"+ee);
	}
	finally
	{
		if(conn!=null){
						ConnectionManager.returnConnection(conn, request);
					  }
	}
%>

</form>
</body>
</html>

