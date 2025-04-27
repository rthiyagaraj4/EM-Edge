<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->

<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
   	request.setCharacterEncoding("UTF-8");

%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eDS/js/DSProcessSupplementary.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="SupplBasedHeaderForm" id="SupplBasedHeaderForm" >
<style>
		TD.OS{
		BACKGROUND-COLOR:#6666FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.PR{
		BACKGROUND-COLOR:#FF99FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.IN{
		BACKGROUND-COLOR:#CC0099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.PO{
		BACKGROUND-COLOR:#FFCC33;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.FN{
		BACKGROUND-COLOR:#990099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

	</style>
	<%  
	     String facility_id=(request.getParameter("facility_id"));
       	 String nursingUnit_code= (request.getParameter("nursingUnit_code"));
	     String date_SupplBased=(request.getParameter("date_SupplBased"));
	     date_SupplBased = DateUtils.convertDate(date_SupplBased,"DMY", locale, "en");
	     String patient_id=(request.getParameter("patient_id"));
         String kitchen_code=(request.getParameter("kitchen_code"));
		 String supplementary_for_desc=(request.getParameter("supplementary_for_desc"));
		 String whereClause = checkForNull(request.getParameter("whereclause"));
	     if(whereClause==null) whereClause="";
	     int maxRecord = 0;
		 String Start_Numb="1";
		 String End_Numb="14";
	%>
	
		<table border='1' cellspacing='0' width='100%' align='center' id="SupplBasedSelectedTable">
        
			<tr>
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</TH>

				<TH valign='top' class='ColumnHeaderCenter'>
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</TH>

				<TH  class='ColumnHeaderCenter'>
 				  <fmt:message key="Common.gender.label" bundle="${common_labels}" />
				</TH>

				<TH  class='ColumnHeaderCenter'>
 				  <fmt:message key="eDS.RoomNo.Label" bundle="${ds_labels}" />
			    </TH>

				<TH  class='ColumnHeaderCenter'>
 				  <fmt:message key="eDS.BedNo.Label" bundle="${ds_labels}" />
			    </TH>

                <TH  class='ColumnHeaderCenter'>
 				    <fmt:message key="eDS.SupplementaryOrderFor.Label" bundle="${ds_labels}"/>
			    </TH>
				
				<TH  class='ColumnHeaderCenter'>
				   <fmt:message key="eDS.ItemType.Label" bundle="${ds_labels}"/>
				</TH>
				
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
				</TH>
				
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}"/>
				</TH>
				
				<TH class='ColumnHeaderCenter'>
				    <fmt:message key="eDS.MealType.Label"	bundle="${ds_labels}"/>
                </TH>
				
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</TH>
			
				<TH class='ColumnHeaderCenter'>
					<fmt:message key="eDS.Remarks.Label" bundle="${ds_labels}"/>
				</TH>

			</tr>	
    <%	
		//String sql="select * from ds_place_supplementary_order";
		//String sql="SELECT distinct sup.encounter_id ,mp.patient_id, mp.patient_name,v.nursing_Unit_code,v.kitchen_area_code, DECODE (sex, 'M', 'Male', 'F', 'Female') sex, nvl(pr.assign_room_num,'-') room_no, nvl(pr.assign_bed_num,'-') bed_no,sup.status,sup.remarks,sup.supplementary_order_for AS supplementry_for_code,DECODE (sup.supplementary_order_for,'A', 'Attented','P', 'Patient') AS supplementary_for_desc, sup.item_type, item.short_desc item_type_desc,item_code item_code, items.short_desc item_desc, sup.item_qty AS qty,sup.meal_type, nvl(mealtype.short_desc,  '- ') mealtype_desc FROM ds_place_supplementary_order sup,pr_encounter pr, mp_patient mp,ds_item_type_lang_vw item,ds_items items,ds_meal_type_lang_vw mealtype,Ip_Nursing_Unit_Lang_Vw v, Ds_Kitchen_Area_Lang_Vw v WHERE sup.encounter_id = pr.encounter_id AND pr.patient_id = mp.patient_id AND sup.item_type = item.item_type AND sup.item_code =items.food_item_code AND sup.meal_type = mealtype.meal_type(+) AND item.language_id =? AND items.language_id = ? AND NVL (mealtype.language_id,?) = ? ";	  
	   	  
		String sql="select * from (select rownum rnum,a.* from (SELECT distinct sup.encounter_id,COUNT(*) over () Total_Record,sup.serving_date, mp.patient_id, mp.patient_name, DECODE (sex, 'M', 'Male', 'F', 'Female') sex,NVL (pr.assign_room_num, ' ') room_no,NVL (pr.assign_bed_num, ' ') bed_no,sup.status, sup.remarks,sup.supplementary_order_for AS supplementry_for_code,DECODE(sup.supplementary_order_for,'A', 'Attentant','P', 'Patient') AS supplementary_for_desc,sup.item_type, item.short_desc item_type_desc,item_code item_code, items.short_desc item_desc, sup.item_qty AS qty, sup.meal_type, NVL (mealtype.short_desc, ' ')mealtype_desc FROM ds_place_supplementary_order sup,pr_encounter pr,mp_patient mp,ds_item_type_lang_vw item,ds_items items,ds_meal_type_lang_vw mealtype,ds_wards_for_kitchen kit,ip_nursing_unit_lang_vw i WHERE sup.operating_facility_id = ? AND sup.operating_facility_id = pr.facility_id AND sup.encounter_id = pr.encounter_id AND pr.patient_id = mp.patient_id AND sup.item_type = item.item_type AND items.item_type = item.item_type AND item.language_id = ? AND sup.item_code = items.food_item_code AND items.language_id = ? AND kit.operating_facility_id = pr.facility_id AND kit.ward_code = pr.assign_care_locn_code AND sup.meal_type = mealtype.meal_type(+)AND NVL (mealtype.language_id, ?) = ? ";
	  
		if((whereClause == null || whereClause.equals(""))){
    		int cnt=0;
			   
			/* if ( !(date_SupplBased == null || date_SupplBased.equals("")) ){
			   if(cnt>0)
				sql = sql + "	and (trunc(sup.serving_date)) = replace('"+date_SupplBased+"','%',','dd/mm/yyyy')";
			   else{
				if ( !(date_SupplBased == null || date_SupplBased.equals("")) ){
				sql = sql + "	and (trunc(sup.serving_date)) = replace('"+date_SupplBased+"','%','15/09/1947','dd/mm/yyyy')";
					cnt=1;
					}					
			}
			}*/
     			if ( !(nursingUnit_code == null || nursingUnit_code.equals("")) ){
    				sql = sql + "	AND i.nursing_unit_code = REPLACE ('"+nursingUnit_code+"', '%', '')";
    					cnt++;
    			
				}
				if(!(kitchen_code==null||kitchen_code.equals(""))){
				    sql=sql+ " and kit.KITCHEN_CODE=replace('"+kitchen_code+"','%','')	";
				      cnt++;
					  }
					  
					  
				if ( !(patient_id == null || patient_id.equals("")) ){
					if(cnt>0)
						sql = sql + " and mp.patient_id = NVL('"+patient_id+"',mp.patient_id)";
					else{
						sql=sql+" where mp.patient_id = NVL('"+patient_id+"',mp.patient_id)";
						cnt=1;
						
					}
				    }
					
				if ( !(supplementary_for_desc == null || supplementary_for_desc.equals("")) ){
					if(cnt>0)
						sql = sql + " and sup.supplementary_order_for  = replace('"+supplementary_for_desc+"','%','' )";
					else{
						sql=sql+" where sup.supplementary_order_for  = replace('"+supplementary_for_desc+"','%','' )";
						cnt=1;
					}
				    }				
		     if(cnt>0){
				sql =sql+ " )a where rownum <= ?) where rnum>=?";
				}
		 	}
		else
				sql = whereClause;

		String visibleStyle="";
		String status="";
		String selectedItem = "";
		String selectedOptionVal = "";
		String selectedItemPK = "";
		String selectedItemRK = "";
		String selectedItemAP = "";

		String selectedItemRP = "";
	    Connection connection   = null;
	    PreparedStatement pstmt = null;
	    ResultSet resultSet     = null;

		try{
			connection	= ConnectionManager.getConnection(request);
			
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,End_Numb);
			pstmt.setString(7,Start_Numb);

		    resultSet = pstmt.executeQuery();
			resultSet.last();
			maxRecord = resultSet.getRow();

		    if(maxRecord == 0){					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));//history.go(-1);</script>");
			   }
			    resultSet.beforeFirst();
			    while(resultSet.next()){
					status= selectedItemPK = selectedItemRK=selectedItemAP =selectedItemRP ="";			   
					status=(resultSet.getString("status"));
				if(status!="" && status!=null) {
				if(status.equals("PK")){
					selectedOptionVal = "Processed by Kitchen";selectedItemPK = "Selected";
					}
				else if(status.equals("RK")) {
					selectedOptionVal = "Rejected by Kitchen";selectedItemRK = "Selected";
					}
				else if(status.equals("AP")) {
					selectedOptionVal = "Accepted by Patient/Attendant";selectedItemAP = "Selected";
					}
				else if(status.equals("RP")) {
					selectedOptionVal = "Rejected by Patient/Attendant";selectedItemRP = "Selected";
					}
			      }
				else status="";

				String room_no=resultSet.getString("room_no");

				%>
					<tr>
						<td><%=resultSet.getString("patient_id")%></td>
						<td><%=resultSet.getString("patient_name")%></td>
						<td><%=resultSet.getString("sex")%></td>
						<td><%=room_no%></td>
						<td><%=resultSet.getString("bed_no")%></td>
						<td><%=resultSet.getString("supplementary_for_desc")%></td>
						<td><%=resultSet.getString("item_type_desc")%></td>
						<td><%=resultSet.getString("item_desc")%></td>
						<td><%=resultSet.getString("qty")%></td>
						<td><%=resultSet.getString("MEALTYPE_DESC")%></td>
		             	<td><select name="effStatus" id="effStatus" id="effStatus" >
						
						<option value="<%=selectedItem%>"><fmt:message key="Common.Select.label" bundle="${common_labels}" /></option>
					   <option value="PK"<%=selectedItemPK%>/><fmt:message key="eDS.ProcessedbyKitchen.Label" bundle="${ds_labels}" /></option>
					   <option value="RK"<%=selectedItemRK%>/><fmt:message key="eDS.RejectedbyKitchen.Label" bundle="${ds_labels}" /></option>
					   <option value="AP"<%=selectedItemAP%>/><fmt:message key="eDS.AcceptedbyPatient.Label" bundle="${ds_labels}" /></option>
					   <option value="RP"<%=selectedItemRP%>/><fmt:message key="eDS.RejectedbyPatient.Label" bundle="${ds_labels}" /></option>
					   </select></td>
						<td colspan="2">
						<textarea name="remarks" ></textarea>
					    </td>
					    <td>						
					    </td>
					    <td>
					    </td>
					    <td></td>
				        </tr>
				        <tr>
					    <td></td>
					    <td>					
					    </td>
					   </tr>
			<%	
			}
			%>
			
			<%
			}
		catch(Exception e) {
				e.printStackTrace();
				System.err.println("Exception=="+e);
	         }
		finally
			{
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null)
				ConnectionManager.returnConnection(connection,request);
              }	       
	%>
	</td></tr>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	</div>
</form>
</body>
</html>

