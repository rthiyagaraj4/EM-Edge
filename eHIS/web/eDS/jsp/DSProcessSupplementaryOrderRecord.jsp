<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,eDS.Common.JSONObject,eDS.SupplementaryOrder.bc.SupplementaryPlaceOrderBC,eDS.SupplementaryOrder.model.SupplementaryProcessRequest,eDS.SupplementaryOrder.model.SupplementaryPlaceOrderResponse,eDS.SupplementaryOrder.model.SupplementaryProcessResponse"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");
	String facility_id		= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";
	String Total_Record="";
	String StartNum="";
	String EndNum="";
	int sno=0;
	String date="";
	String selectedItem="";
	String selectedItemPK = "";
	String selectedItemRK = "";
	String selectedItemAP = "";
	String selectedItemRP = "";
	String patient_id="";
	String nursingUnit_code="";
	String kitchen_code="";
	String supplementary_for_Code="";
	String GracePeriod="",Attendent_Label_Name="";
		
	String ProcessedbyKitchen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.ProcessedbyKitchen.Label","ds_labels");
	String RejectedbyKitchen=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.RejectedbyKitchen.Label","ds_labels");
	String AcceptedbyPatient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.AcceptedbyPatient.Label","ds_labels");
	String RejectedbyPatient=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.RejectedbyPatient.Label","ds_labels");
		
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
		<script language="JavaScript" src="../../framework/js/PopupWindow.js" type="text/javascript"></script>
		<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
		<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
		<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
		<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
		<!--script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script-->
		<script language="Javascript" src="../../eDS/js/json.js"></script>		
		<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script language="Javascript" src="../../eDS/js/Moment.js"></script>
		<script language="Javascript" src="../../eDS/js/MomentRange.js"></script>
		<script language="Javascript" src="../../eDS/js/DSProcessSupplementary.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
		 
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script>
  		$(document).ready(function() {	  	
		});
		</script>
		
	</head>
<body>
	<form action="" name="Record" id="Record">			
<%
	Connection con = null;
	try{
		con = ConnectionManager.getConnection();
		date=request.getParameter("date");
		patient_id=request.getParameter("patient_id");
		nursingUnit_code=request.getParameter("nursingUnit_code");
		kitchen_code=request.getParameter("kitchen_code");
		supplementary_for_Code=request.getParameter("supplementary_for_Code");
		StartNum=request.getParameter("start_num");
		EndNum=request.getParameter("end_num");
		GracePeriod=request.getParameter("GracePeriod");
		Attendent_Label_Name=request.getParameter("Attendent_Label_Name");	
	
		AcceptedbyPatient=AcceptedbyPatient.replace("#",Attendent_Label_Name);
		RejectedbyPatient=RejectedbyPatient.replace("#",Attendent_Label_Name);
		
		SupplementaryPlaceOrderBC BC_Obj=new SupplementaryPlaceOrderBC();
		SupplementaryProcessRequest request_obj=new SupplementaryProcessRequest();
		SupplementaryPlaceOrderResponse response_obj=new SupplementaryPlaceOrderResponse();
	
		request_obj.setLocale(locale);
		request_obj.setFacilityId(facility_id);
		request_obj.setDate(date);
		request_obj.setPatientId(patient_id);
		request_obj.setKitchen(kitchen_code);
		request_obj.setNursingUnit(nursingUnit_code);
		request_obj.setSupplementaryOrderFor(supplementary_for_Code);
		request_obj.setStartNum(StartNum);
		request_obj.setEndNum(EndNum);
		request_obj.setGracePeriod(GracePeriod);
	
		response_obj=BC_Obj.getProcessSupplementaryOrderList(request_obj,con);
	
		List<SupplementaryProcessResponse> processSupplementaryOrderResponseList=new ArrayList<SupplementaryProcessResponse>();
		processSupplementaryOrderResponseList=response_obj.getProcessSearchList();		
	
		sno=Integer.parseInt(StartNum);
	
	for(SupplementaryProcessResponse itrres:	processSupplementaryOrderResponseList){
		Total_Record=itrres.getTotalRecord();
		
	}
	if(Total_Record.equals("")){
		Total_Record="0";
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
	}
	
	%>
	<div id="SearchLayer1" style=" width:100%;height:15px;border: 0px outset #9999FF;">
	<table border="0" cellpadding="2" name="nextprev" id="nextprev" id="nextprev" cellspacing="0" width="100%" align="center" style="position: absolute">
		<tr>
			<td align="right">
				<%
					if(Integer.parseInt(Total_Record)>14 && Integer.parseInt(StartNum)==1 && Integer.parseInt(EndNum)==14){
						System.out.println("if");
				%>
					&nbsp;&nbsp;&nbsp;<a align="right"><a href="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp?date=<%=date %>&patient_id=<%=patient_id %>&nursingUnit_code=<%=nursingUnit_code %>&kitchen_code=<%=kitchen_code %>&supplementary_for_Code=<%=supplementary_for_Code %>&start_num=<%=Integer.parseInt(StartNum)+14 %>&end_num=<%=Integer.parseInt(EndNum)+14 %>&GracePeriod=<%=GracePeriod %>&Attendent_Label_Name=<%=Attendent_Label_Name %>" ><fmt:message key="Common.next.label" bundle='${common_labels}' /></a>
				<%		
					}
			
				else if(Integer.parseInt(Total_Record)>14 && Integer.parseInt(StartNum)>14 && Integer.parseInt(EndNum)<Integer.parseInt(Total_Record)){
					System.out.println("else if 1");
				%>
					<a align="right"><a align="right"><a href="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp?date=<%=date %>&patient_id=<%=patient_id %>&nursingUnit_code=<%=nursingUnit_code %>&kitchen_code=<%=kitchen_code %>&supplementary_for_Code=<%=supplementary_for_Code %>&start_num=<%=Integer.parseInt(StartNum)+14 %>&end_num=<%=Integer.parseInt(EndNum)+14 %>&GracePeriod=<%=GracePeriod %>&Attendent_Label_Name=<%=Attendent_Label_Name %>" ><fmt:message key="Common.next.label" bundle='${common_labels}' /></a>
					<a align="right"><a align="right"><a href="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp?date=<%=date %>&patient_id=<%=patient_id %>&nursingUnit_code=<%=nursingUnit_code %>&kitchen_code=<%=kitchen_code %>&supplementary_for_Code=<%=supplementary_for_Code %>&start_num=<%=Integer.parseInt(StartNum)-14 %>&end_num=<%=Integer.parseInt(EndNum)-14 %>&GracePeriod=<%=GracePeriod %>&Attendent_Label_Name=<%=Attendent_Label_Name %>" ><fmt:message key="Common.previous.label" bundle='${common_labels}' /></a>
				<%	
				}
				else if(Integer.parseInt(Total_Record)<=Integer.parseInt(EndNum) && Integer.parseInt(StartNum)>=14){
					System.out.println("else if 2");
				%>
					<a align="right"><a align="right"><a href="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp?date=<%=date %>&patient_id=<%=patient_id %>&nursingUnit_code=<%=nursingUnit_code %>&kitchen_code=<%=kitchen_code %>&supplementary_for_Code=<%=supplementary_for_Code %>&start_num=<%=Integer.parseInt(StartNum)-14 %>&end_num=<%=Integer.parseInt(EndNum)-14 %>&GracePeriod=<%=GracePeriod %>&Attendent_Label_Name=<%=Attendent_Label_Name %>"><fmt:message key="Common.previous.label" bundle='${common_labels}' /></a>
				<%	
				}
				%>			
			</td>
		</tr>
	</table>
	</div>
	<div id="SearchLayer2" style=" width:100%;height:50px;border: 0px outset #9999FF;">
	<table border="1" cellpadding="1" cellspacing="0" width="100%" align="center" id="result" style="overflow-y: scroll;width:100%;border-bottom: 1pt solid black;">
	<tr>
	<thead>
				<th >
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</th>
				<th >
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</th>
				<th >
 				  <fmt:message key="Common.gender.label" bundle="${common_labels}" />
				  </th>
				<th >
 				  <fmt:message key="eDS.RoomNo.Label" bundle="${ds_labels}" />
				</th>
				<th >
	 			   <fmt:message key="eDS.BedNo.Label" bundle="${ds_labels}" />
				</th> 
	                	<th >
	 			    <fmt:message key="eDS.SupplementaryOrderFor.Label" bundle="${ds_labels}"/>
				</th>				
				<th >
				   <fmt:message key="eDS.ItemType.Label" bundle="${ds_labels}"/>
				</th>
				
				<th >
					<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
				</th>
				
				<th >
					<fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}"/>
				</th>
				
				<th >
				    <fmt:message key="eDS.MealType.Label"	bundle="${ds_labels}"/>
                		</th>
				
				<th >
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</th>
			
				<th >
					<fmt:message key="eDS.Remarks.Label" bundle="${ds_labels}"/>
				</th>
	</thead>			
			</tr>
		
	<%
	for(SupplementaryProcessResponse res:	processSupplementaryOrderResponseList){
		
	%>
		<tr>
			<td><%=res.getPatientId() %></td>
			<td><%=res.getPatientName() %></td>
			<td><%=res.getGender() %></td>
			<%
			//System.err.println("Room no-->"+checkForNull(res.getRoomNo()).trim()+"<--");
			%>
			<td><%=checkForNull(res.getRoomNo()).trim().equals("")?"&nbsp;":checkForNull(res.getRoomNo()) %></td>
			
			<td><%=checkForNull(res.getBedNo()).trim().equals("")?"&nbsp;":checkForNull(res.getBedNo()) %></td>
			<td><%=res.getSupplementaryOrderFor() %></td>
			<td><%=res.getItemType() %></td>
			<td><%=res.getFoodItem() %></td>
			<td><%=res.getItemQty() %></td>
			
			<td><%=checkForNull(res.getMealType()).trim().equals("")?"&nbsp;":checkForNull(res.getMealType()) %></td>
			<!-- <td><%=checkForNull(res.getStatus()).trim().equals("")?"&nbsp;":checkForNull(res.getStatus()) %></td>-->
	<%
			selectedItem=checkForNull(res.getStatus()).trim();
			selectedItemPK="";selectedItemRK="";selectedItemAP="";selectedItemRP="";
			if(selectedItem.equals("PK")){
				selectedItemPK="Selected";
			}else if(selectedItem.equals("RK")){
				selectedItemRK="Selected";
			}else if(selectedItem.equals("AP")){
				selectedItemAP="Selected";
			}else if(selectedItem.equals("RP")){
				selectedItemRP="Selected";
			}			
			
	%>
			<td>
				<select name="effStatus_<%=sno %>" id="effStatus_<%=sno %>" id="effStatus_<%=sno %>">
				   <option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}" /></option>
				   <option value="PK" <%=selectedItemPK %>><%=ProcessedbyKitchen %></option>
				   <option value="RK" <%=selectedItemRK %>/><%=RejectedbyKitchen %></option>
				   <option value="AP" <%=selectedItemAP %>/><%=AcceptedbyPatient %></option>
				   <option value="RP" <%=selectedItemRP %>/><%=RejectedbyPatient %></option>
			       </select>
		       </td>
		       <script>		       
		       
		       </script>
			<td><textarea name="remarks_<%=sno %>" id="remarks_<%=sno %>" style ="resize:none;" onblur="textAreaLimit(this,255);"> <%=checkForNull(res.getRemarks()).trim()%></textarea></td>
			<input type="hidden" name="Encounter_Id_<%=sno %>" id="Encounter_Id_<%=sno %>" id="Encounter_Id_<%=sno %>" value="<%=res.getEncounter_Id() %>">
			<input type="hidden" name="o_oremarks_<%=sno %>" id="o_oremarks_<%=sno %>" id="o_oremarks_<%=sno %>" value="<%=checkForNull(res.getRemarks()).trim() %>">
			<input type="hidden" name="o_effStatus_<%=sno %>" id="o_effStatus_<%=sno %>" id="o_effStatus_<%=sno %>" value="<%=checkForNull(res.getStatus()).trim() %>">
			
			<input type="hidden" name="sup_order_<%=sno %>" id="sup_order_<%=sno %>" id="sup_order_<%=sno %>" value="<%=checkForNull(res.getSupplementaryOrderForCode()).trim() %>">
			<input type="hidden" name="item_type_<%=sno %>" id="item_type_<%=sno %>" id="item_type_<%=sno %>" value="<%=checkForNull(res.getItemTypeCode()).trim() %>">
			<input type="hidden" name="food_item_<%=sno %>" id="food_item_<%=sno %>" id="food_item_<%=sno %>" value="<%=checkForNull(res.getFoodItemCode()).trim() %>">
			<input type="hidden" name="meal_type_<%=sno %>" id="meal_type_<%=sno %>" id="meal_type_<%=sno %>" value="<%=checkForNull(res.getMealTypeCode()).trim() %>">
			
		</tr>
	<%	
		sno++;
		}
	%>	
	
	<%
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null){
				ConnectionManager.returnConnection(con);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>			
			
	</table>
	</div>
	<input type="hidden" name="Total_Record" id="Total_Record" id="Total_Record" value=<%=Total_Record %>>
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value=<%=facility_id %>>
	<input type="hidden" name="StartNum" id="StartNum" id="StartNum" value=<%=StartNum %>>
	<input type="hidden" name="EndNum" id="EndNum" id="EndNum" value=<%=EndNum %>>
	<input type="hidden" name="sno" id="sno" id="sno" value=<%=sno %>>
	<input type="hidden" name="locale" id="locale" id="locale" value=<%=locale %>>
	<input type="hidden" name="serving_date" id="serving_date" id="serving_date" value=<%=date %>>	
	<input type="hidden" name="date" id="date" id="date" value=<%=date %>>	
	<input type="hidden" name="patient_id" id="patient_id" id="patient_id" value="<%=patient_id %>">
	<input type="hidden" name="nursingUnit_code" id="nursingUnit_code" id="nursingUnit_code" value="<%=nursingUnit_code %>">
	<input type="hidden" name="kitchen_code" id="kitchen_code" id="kitchen_code" value="<%=kitchen_code %>">
	<input type="hidden" name="supplementary_for_Code" id="supplementary_for_Code" id="supplementary_for_Code" value="<%=supplementary_for_Code %>">
	<input type="hidden" name="StartNum" id="StartNum" id="StartNum" value="<%=StartNum %>">
	<input type="hidden" name="EndNum" id="EndNum" id="EndNum" value="<%=EndNum %>">
	<input type="hidden" name="GracePeriod" id="GracePeriod" id="GracePeriod" value="<%=GracePeriod %>">
	<input type="hidden" name="Attendent_Label_Name" id="Attendent_Label_Name" id="Attendent_Label_Name" value="<%=Attendent_Label_Name %>">
	</form>
</body>

