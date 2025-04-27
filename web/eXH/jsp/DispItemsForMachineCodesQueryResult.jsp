<!DOCTYPE html>
<HTML>  
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page import = "java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE")); 
 %>
<HEAD>  
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>					  
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<Script Language="JavaScript" src="../../eXH/js/DispenseItemMachineCodes.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<Script>
function chkSelectFlag(obj){

	select_val = document.forms[0].select_flag.value;

    if(obj.value=='Y'){
		document.forms[0].select_flag.value = 'Y';
	}
	else if(select_val!='Y'){
		document.forms[0].select_flag.value = 'N';
	}
}
function funModify(facility, disp_locn, machine, item, high_alert_drug, pack_only_exp, rowCount, facilityName, dispLocnName, machineName, itemName)
{
	
	var mode = "Modify";
	//alert("funModify.."+parent.f_query_add_mod.location.href);
	
	parent.f_query_add_mod.location.href = "../../eXH/jsp/ItemForAutoDispenserMain.jsp?mode=" + mode+"&facility_id="+facility+"&disp_locn="+disp_locn+"&machine_code="+machine+"&item_desc="+item+"&high_alert_yn="+high_alert_drug+"&pack_only_yn="+pack_only_exp+"&facilityName="+facilityName+"&dispLocnName="+dispLocnName+"&machineName="+machineName+"&itemName="+itemName;
	
	
}
</Script>
<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2' onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
int rowCount=0;

String   classValue="";
String facilityId = "";
String DispLocnCode = "";
String MachineCode = "";
String ItemCode = "";
String HighAlertDrugYN = "";
String PackOnlyExpensiveDrugYN = "";
String EFFStatus = "";
String class_val = "";
String select = "";


String mode=request.getParameter("mode");
String user_id=XHDBAdapter.checkNull(request.getParameter("user_id"));

String disp_locn_code = XHDBAdapter.checkNull(request.getParameter("disp_locn_code"));
String machine_code =  XHDBAdapter.checkNull(request.getParameter("machine_code"));	
String item_code = XHDBAdapter.checkNull(request.getParameter("item_code"));
System.out.println("disp_locn_code.."+disp_locn_code+"..machine_code.."+machine_code+"...item_code.."+item_code);

String disp_locn_desc = XHDBAdapter.checkNull(request.getParameter("disp_locn_desc"));
String machine_desc = XHDBAdapter.checkNull(request.getParameter("machine_desc"));
String item_desc = XHDBAdapter.checkNull(request.getParameter("item_desc"));

//appending order by clause
	//String ord[] = request.getParameterValues("orderbycolumns");
	//System.out.println("Orderby...."+ord[0]);
	//System.out.println("orderbycolumns...."+request.getParameterValues("orderbycolumns"));

%>
<form name="AuthorisedUsers_Result" id="AuthorisedUsers_Result" target='' method='post' action=''>
<!-- <input type="hidden" name="mode" id="mode" value='<%=mode%>'/>-->
<input type="hidden" name="mode" id="mode" value=''/>
<input type="hidden" name="Machine_code" id="Machine_code" />
<input type="hidden" name="Patient_class" id="Patient_class" />
<input type="hidden" name="Long_desc" id="Long_desc" />
<input type="hidden" name="Short_desc" id="Short_desc" />
<input type="hidden" name="eff_status" id="eff_status" />
 <br>
<%

try{
		con=ConnectionManager.getConnection();
		StringBuffer whereClause = new StringBuffer();
		StringBuffer whereCond = new StringBuffer();
		String sql = "";
		boolean flag = false;
		
		//sql = "SELECT FACILITY_ID, DISP_LOCN_CODE, MACHINE_CODE, ITEM_CODE, HIGH_ALERT_DRUG_YN, PACK_ONLY_EXPENSIVE_DRUG_YN FROM XH_DISP_LOCN_MACHINES";
		sql = "SELECT FACILITY_ID, DISP_LOCN_CODE, MACHINE_CODE, ITEM_CODE, HIGH_ALERT_DRUG_YN, PACK_ONLY_EXPENSIVE_DRUG_YN, facility_name, disp_locn_name, item_name, machine_name FROM xh_disp_mach_vw";

		if(disp_locn_code.length() != 0 || item_code.length() != 0 || machine_code.length() != 0 || disp_locn_desc.length() != 0 || machine_desc.length() != 0 || item_desc.length() != 0){
			
			whereClause.append(" where ");
			if(disp_locn_code.length() != 0){
				
				flag = true;
				whereCond.append("UPPER(DISP_LOCN_CODE) = UPPER('"+disp_locn_code+"')");
				/*if(item_code.length() !=0){
					whereCond.append(" AND UPPER(ITEM_CODE) = UPPER('"+item_code+"')");
				}*/
			} if(item_code.length() != 0 && flag){
				whereCond.append(" AND UPPER(ITEM_CODE) = UPPER('"+item_code+"')");
			}else if(item_code.length() != 0){
				System.out.println("machine_code not equal to zero..");
				flag = true;
				whereCond.append(" UPPER(ITEM_CODE) = UPPER('"+item_code+"')");
			}
			if(machine_code.length() != 0 && flag){
				whereCond.append(" AND UPPER(MACHINE_CODE) = UPPER('"+machine_code+"')");
			}else if(machine_code.length() != 0){
				System.out.println("machine_code not equal to zero..");
				flag = true;
				whereCond.append(" UPPER(MACHINE_CODE) = UPPER('"+machine_code+"')");
			}

			//Desc code start
			if(disp_locn_desc.length() != 0 && flag){
				whereCond.append(" AND UPPER(DISP_LOCN_NAME) = UPPER('"+disp_locn_desc+"')");
			}else if(disp_locn_desc.length() != 0){
				
				flag = true;
				whereCond.append(" UPPER(DISP_LOCN_NAME) = UPPER('"+disp_locn_desc+"')");
			}
			if(machine_desc.length() != 0 && flag){
				whereCond.append(" AND UPPER(MACHINE_NAME) = UPPER('"+machine_desc+"')");
			}else if(machine_desc.length() != 0){
				
				flag = true;
				whereCond.append(" UPPER(MACHINE_NAME) = UPPER('"+machine_desc+"')");
			}

			if(item_desc.length() != 0 && flag){
				whereCond.append(" AND UPPER(ITEM_NAME) = UPPER('"+item_desc+"')");
			}else if(item_desc.length() != 0){
				
				//flag = true;
				whereCond.append(" UPPER(ITEM_NAME) = UPPER('"+item_desc+"')");
			}
			// end

			whereClause.append(whereCond);

			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) )
			{
				whereClause.append(" order by ");

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					whereClause.append(ord[i]);
				else
					whereClause.append(ord[i]+",");
				}
			}
				
			sql = sql + whereClause.toString();	

			//order by 

		}else {
			String ord[] = request.getParameterValues("orderbycolumns");

			if ( !(ord == null || ord .equals("")) )
			{
				//whereClause.append(" order by ");
				sql = sql + " order by ";

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					//whereClause.append(ord[i]);
					sql = sql + ord[i];
				else
					//whereClause.append(ord[i]+",");
					sql = sql + ord[i]+",";
				}
			}


			sql = sql.toString();
		}



		System.out.println("MachineForAutoDispenserQueryResult..."+sql);
		System.out.println("MachineForAutoDispenserQueryResult...whereCond..."+whereCond);
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
		rs.last(); 
		if(rs.getRow()==0)
	    { %>
		<script>
		this.document.forms[0].mode.value='E';
		alert(getMessage("XH1021","XH"));history.go(-1);
		</script>
		<%}
		else{
		
		rs.beforeFirst();
	   %>
		<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>

<td class='COLUMNHEADER' width='20%'><fmt:message key="eXH.FacilityID.label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.DispLocnCode.label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.Machine.label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.item.label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.HighAlertDrugYN.label" bundle="${xh_labels}"/></td>
<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.PackOnlyExpensiveDrugYN.label" bundle="${xh_labels}"/></td>
<!--<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>-->



   	 <%
  
		while(rs.next()) 
		{
			if ( rowCount % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			
			
			facilityId = rs.getString(1);
			DispLocnCode = rs.getString(2);
			MachineCode = rs.getString(3);
			ItemCode = rs.getString(4);
			HighAlertDrugYN = rs.getString(5);
			PackOnlyExpensiveDrugYN = rs.getString(6);

			String facility_name = "";
			String disp_locn_name = "";
			String item_name = "";
			String machine_name = "";
			facility_name = rs.getString(7);
			disp_locn_name = rs.getString(8);
			item_name = rs.getString(9);
			machine_name = rs.getString(10);

			System.out.println("DispItemsForMachineCodesQueryResults facility_name :: "+facility_name+" :: disp_locn_name :: "+disp_locn_name+" :: item_name :: "+item_name+" :: machine_name :: "+machine_name);
			%>
			
			<%
				rowCount++;
			//out.println("<script>fetchStatusValue('"+status.toUpperCase()+"');</script>");

	out.println("<tr>");
	out.println("<td id='"+"facilityId"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:funModify('"+facilityId+"','"+DispLocnCode+"','"+MachineCode+"','"+ItemCode+"','"+HighAlertDrugYN+"','"+PackOnlyExpensiveDrugYN+"','"+rowCount+"','"+facility_name+"','"+disp_locn_name+"','"+machine_name+"','"+item_name+"');\">"+facility_name+"</a></td><input type='hidden' name='"+"hid_item_slr"+rowCount+"' id='"+"hid_item_slr"+rowCount+"' value='"+facilityId+"'/>");

	out.println("<td id='"+"DispLocnCode"+rowCount+"' class='"+class_val+"'>"+disp_locn_name+"</td><input type='hidden' name='"+"hid_item_Type"+rowCount+"' id='"+"hid_item_Type"+rowCount+"' value='"+DispLocnCode+"'/>");

	out.println("<td id='"+"MachineCode"+rowCount+"' class='"+class_val+"'>"+machine_name+"</td><input type='hidden' name='"+"hid_item_Code"+rowCount+"' id='"+"hid_item_Code"+rowCount+"' value='"+MachineCode+"'/>");

	out.println("<td id='"+"ItemCode"+rowCount+"' class='"+class_val+"'>"+item_name+"</td><input type='hidden' name='"+"hid_item_Qty"+rowCount+"' id='"+"hid_item_Qty"+rowCount+"' value='"+ItemCode+"'/>");

	out.println("<td id='"+"HighAlertDrugYN"+rowCount+"' class='"+class_val+"'>"+HighAlertDrugYN+"</td><input type='hidden' name='"+"hid_spl_Food_Item_Yn"+rowCount+"' id='"+"hid_spl_Food_Item_Yn"+rowCount+"' value='"+HighAlertDrugYN+"'/>");

	out.println("<td id='"+"PackOnlyExpensiveDrugYN"+rowCount+"' class='"+class_val+"'>"+PackOnlyExpensiveDrugYN+"</td><input type='hidden' name='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' value='update'/><input type='hidden' name='"+"hid_freq_Yn"+rowCount+"' id='"+"hid_freq_Yn"+rowCount+"' value='"+PackOnlyExpensiveDrugYN+"'/>");

	//out.println("<td id='"+"select"+rowCount+"' class='"+class_val+"'>"+select+"<input type='checkbox' name='"+"selectBox"+rowCount+"' id='"+"selectBox"+rowCount+"' value='"+select+"' /><input type='hidden' name='"+"hid_selectBox"+rowCount+"' id='"+"hid_selectBox"+rowCount+"' /></td>");

	out.println("</tr>");

		}
		}
}catch(Exception e1)
{
		System.out.println("(MachineForAutoDispenserQueryResult.jsp:Error) :  "+e1.toString());
		e1.printStackTrace();
}
finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
				}catch(Exception e)
				{
				System.out.println("(MachineForAutoDispenserQueryResult.jsp:Error) : "+e);
				}
			}
		
%>
</table>
</form>
</body>
</html>

