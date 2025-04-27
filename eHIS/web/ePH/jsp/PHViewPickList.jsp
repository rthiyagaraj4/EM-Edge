<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHReports.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IPFill.js"></SCRIPT><!-- this js is used for some purpose making change in this will impact ipfill also -->

</HEAD>
<title><fmt:message key="ePH.FillList.label" bundle="${ph_labels}"/> </title>
<%
request.setCharacterEncoding("UTF-8");

//ends

	String facility_id				 = (String) session.getValue( "facility_id" );
	
	String disp_locn_code			 = request.getParameter("disp_locn_code");
	String OrderingFacility_code	 = request.getParameter("OrderingFacility_code");
	String compound_drug_ind		 = request.getParameter("compound_drug_ind");
	String nursing_unit_or_locn		 = request.getParameter("nursing_unit_or_locn");
	String Nursing_Unit_From		 = request.getParameter("Nursing_Unit_From");
	String patient_id_1			 = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
	String Nursing_Unit_To			 = request.getParameter("Nursing_Unit_To")==null ? "" : request.getParameter("Nursing_Unit_To");
	String Proc_Type				 = request.getParameter("Proc_Type")==null ? "R" : request.getParameter("Proc_Type");
//		   if(Proc_Type.equals("R")){Proc_Type = "Routine";}else if(Proc_Type.equals("I")){Proc_Type="Incremental";}
	String schedule_start			 = request.getParameter("schedule_start");
	String Ip_Fill_Prd_Ahead		 = request.getParameter("Ip_Fill_Prd_Ahead");
	//int Ip_Fill_Prd_Ahead_inDays     = Integer.parseInt(Ip_Fill_Prd_Ahead)/24;    Himanshu
	String Ip_Fill_Prd_Ahead_inDays     = "";
	String fill_int_start_date_time  = request.getParameter("fill_int_start_date_time");
	String fill_int_end_date_time	 = request.getParameter("fill_int_end_date_time");
	String order_by_for_list		 = request.getParameter("order_by_for_list");
	String Building_Code			 = request.getParameter("Building_Code");
	String Floor_Code				 = request.getParameter("Floor_Code");
	String Nursing_Unit_From_Code				 = request.getParameter("Nursing_Unit_From_Code");
		if(Building_Code ==  null){Building_Code = "";}
		if(Floor_Code ==  null){Floor_Code = "";}
	String intermittent				 = "N";

	String iv_drug_ind				 = request.getParameter("iv_drug_ind");	
	String ip_excl_intermittent_fill = request.getParameter("ip_excl_intermittent_fill");
	String ip_fill_prd_unit			 = request.getParameter("ip_fill_prd_unit");
	String ip_fill_excl_prd_behind   = request.getParameter("ip_fill_excl_prd_behind")==null ? "0" : request.getParameter("ip_fill_excl_prd_behind");
	String cut_off_limit_for_new_ord = request.getParameter("cut_off_limit_for_new_ord");

	String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");

	HashMap fill_list_dtl = new HashMap();
	
	fill_list_dtl.put("iv_drug_ind",iv_drug_ind);
	fill_list_dtl.put("compound_drug_ind",compound_drug_ind);
	fill_list_dtl.put("ip_excl_intermittent_fill",ip_excl_intermittent_fill);
	fill_list_dtl.put("nursing_unit_or_locn",nursing_unit_or_locn);
	fill_list_dtl.put("Nursing_Unit_From_Code",Nursing_Unit_From);
	fill_list_dtl.put("Nursing_Unit_To_Code",Nursing_Unit_To);
	fill_list_dtl.put("Building_Code",Building_Code);
	fill_list_dtl.put("Floor_Code",Floor_Code);
	fill_list_dtl.put("Proc_Type",Proc_Type);
	fill_list_dtl.put("schedule_start",schedule_start);
	fill_list_dtl.put("Ip_Fill_Prd_Ahead",Ip_Fill_Prd_Ahead_inDays+"");
	fill_list_dtl.put("Fill_Period_Unit",ip_fill_prd_unit);
	fill_list_dtl.put("ip_fill_excl_prd_behind",ip_fill_excl_prd_behind);	
	fill_list_dtl.put("order_by_for_list",order_by_for_list);
	fill_list_dtl.put("disp_locn_code",disp_locn_code);
	fill_list_dtl.put("fill_int_start_date_time",fill_int_start_date_time);
	fill_list_dtl.put("fill_int_end_date_time",fill_int_end_date_time);
	fill_list_dtl.put("cut_off_limit_for_new_ord",cut_off_limit_for_new_ord);
	fill_list_dtl.put("locale",locale);
	fill_list_dtl.put("patient_id",patient_id_1);
	fill_list_dtl.put("language_id",locale);

	String bean_id = "PHPickListBean" ;
	String bean_name = "ePH.PHPickListBean";
	/* Initialize Function specific start */
	PHPickListBean bean = (PHPickListBean)getBeanObject(bean_id, bean_name, request ) ;
//	bean.clear() ;
//	bean.setMode( mode ) ;
//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	

	bean.setFillListDtl(fill_list_dtl);

	ArrayList ip_fill_list = (ArrayList)bean.getIpPickList(fill_int_start_date_time,fill_int_end_date_time,Proc_Type,intermittent,disp_locn_code,nursing_unit_or_locn,compound_drug_ind,Building_Code,Floor_Code,Nursing_Unit_From,Nursing_Unit_To,order_by_for_list,locale,OrderingFacility_code,ip_fill_excl_prd_behind,patient_id_1);

	HashMap ip_fill_order		= new HashMap();
	String logged_fcy = bean.getLoggedInFacility();
	String prvs_nursing_unit_code = "";
	String nursing_unit_code = "";
	String nursing_unit_desc = "";
	StringTokenizer disp_qty_dtl  = new StringTokenizer("S");
//	StringTokenizer disp_qty_btch = new StringTokenizer("S");
	String disp_qty		= "";
	String disp_qty_uom	= "";
	String disp_qty_uom_desc="";
	String disp_btch = "";
	String disp_drug_code = "";
	String disp_drug_desc = "";
	String drug_choice	  = "";
	String patient_id	  = "";
	String patient_details= "";
	String drug_color	  = "";
	String order_id		  = "";
	String chk_dsbl		  = "";
	String ord_drug_code  = "";
	String ord_drug_name  = "";
	String ord_drug_qty	  = "";
	String ord_drug_uom   = "";
	String total_drugs	  = "";
	int total_patients	  = 0;
	String ip_fill_chk_value = "N";
	String ip_fill_chked	 = "checked";
	String line_flag  	  = "N";
	String sex  	  = "";
	String date_of_birth  	  = "";
	String patient_Name  	  = "";
	String gender  	  = "";
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="checkAll_patientsandorders(formPHViewFillList)">
<FORM name="formPHViewFillList" id="formPHViewFillList"  TARGET="messageFrame" >
<% 
	if(ip_fill_list != null && ip_fill_list.size()>0){
%>
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
<tr>
<td class="BODYCOLORFILLED" ALIGN="right"><input type="checkbox" name="select_all" id="select_all" onclick="checkAll_patientsandorders(this);" value="Y" checked></td>
</tr>
<table>
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
<%										
		total_drugs	  = ip_fill_list.size()+"";
		for(int i = 0; i<ip_fill_list.size();i++){
			ip_fill_order = (HashMap)ip_fill_list.get(i);
			if(!patient_id.equals((String)ip_fill_order.get("PATIENT_ID"))){
				patient_id		= (String)ip_fill_order.get("PATIENT_ID");
				patient_details	= (String)ip_fill_order.get("Patient_Details");	
	patient_details=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+":"+patient_details;
				sex	= (String)ip_fill_order.get("sex");
				if(sex.equals("M")){
				 gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				 gender=gender+",";
				}else if(sex.equals("F")){
				  gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				   gender=gender+",";
				}else if(sex.equals("Unknown"))
				{
				 gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				 gender=gender+",";

				}
				date_of_birth	= (String)ip_fill_order.get("date_of_birth");
				date_of_birth   = date_of_birth+",";
				patient_Name	= (String)ip_fill_order.get("patient_Name");	
				line_flag       = "Y";
			}else{
				patient_details	= "";
				line_flag       = "N";
				date_of_birth   = "";
				gender   = "";
				patient_Name   = "";
			}
			

			order_id		  = (String)ip_fill_order.get("ORDER_ID"); 
			ord_drug_code	  = (String)ip_fill_order.get("Drug_Code"); 	
			ord_drug_name	  =	(String)ip_fill_order.get("Drug_Name");
			ord_drug_qty	  =	(String)ip_fill_order.get("ORDER_QTY");
			ord_drug_uom	  =	(String)ip_fill_order.get("ORDER_UOM");
			nursing_unit_code = (String)ip_fill_order.get("SOURCE_CODE"); 
			nursing_unit_desc = (String)ip_fill_order.get("NURSING_UNIT_DESC"); 
            
					
			disp_qty_dtl = new StringTokenizer((String)ip_fill_order.get("Disp_qty"),"|");

			int count=disp_qty_dtl.countTokens();

			if(count==5){
			while(disp_qty_dtl.hasMoreTokens()){
				disp_qty		= disp_qty_dtl.nextToken();
				disp_qty_uom	= disp_qty_dtl.nextToken();
				disp_qty_uom =bean.getUomDisplay(facility_id,disp_qty_uom);
				bean.setLanguageId(locale);
				drug_choice		= disp_qty_dtl.nextToken();
				disp_drug_code  = disp_qty_dtl.nextToken();
				disp_drug_desc  = disp_qty_dtl.nextToken();
				if ( disp_drug_desc == null || disp_drug_desc.equals(" ") )
				{
				  disp_drug_desc= ord_drug_name;
				  ord_drug_code=ord_drug_code;
				  drug_choice="#990033";
				  
				 // ip_fill_chked	 = "checked";
				  if(disp_qty.equals("0")) {
				  ip_fill_chked	 = "";
				  ip_fill_chk_value = "N";
				  }else {
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y";
				  }
				  chk_dsbl = "";
				  
			    }
				 disp_btch		=" ^ ^ ^ ^";
			    }				
			}else if(count==6) {
				
				while(disp_qty_dtl.hasMoreTokens()){
				disp_qty		= disp_qty_dtl.nextToken();
				disp_qty_uom	= disp_qty_dtl.nextToken();
				
				drug_choice		= disp_qty_dtl.nextToken();
				disp_drug_code  = disp_qty_dtl.nextToken();
				disp_drug_desc  = disp_qty_dtl.nextToken();
				disp_btch		= disp_qty_dtl.nextToken();
				disp_qty_uom =bean.getUomDisplay(facility_id,disp_qty_uom);
				bean.setLanguageId(locale);
				if ( (disp_drug_desc == null || disp_drug_desc.equals(" ")&&(!drug_choice.equals("C"))) )
				{
				  disp_drug_desc= ord_drug_name;
				  ord_drug_code=ord_drug_code;
				  drug_choice="#990033";
				  if(disp_qty.equals("0")){
				  ip_fill_chked	 = "";
				  ip_fill_chk_value = "N";
				  }else{
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y";
				  }
				  chk_dsbl = "";
				 }
			   }//end while
		    }//end else
		if(drug_choice.equals("S")){
				drug_color = "";			
				chk_dsbl = "enabled";
				
				//ip_fill_chked	 = "checked";
				 if(disp_qty.equals("0")){
				  ip_fill_chked	 = "";
				 ip_fill_chk_value="N";
				 }else{
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y";
				  }

			}else if(drug_choice.equals("A")){
				drug_color = "#CC6600";			
				chk_dsbl = "";
				//ip_fill_chked	 = "checked";
				 if(disp_qty.equals("0")){
				  ip_fill_chked	 = "";
				  ip_fill_chk_value = "N"; 
				 }else{
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y"; 
				  }
			}else if(drug_choice.equals("M")){
				drug_color = "#CC00CC";
				chk_dsbl = "disabled";
				ip_fill_chk_value = "N";
				ip_fill_chked	 = "";
			}else if(drug_choice.equals("N")){
				drug_color = "";
				disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoStock.label","ph_labels")+"'>";
				chk_dsbl = "disabled";
				ip_fill_chk_value = "N";
				ip_fill_chked	 = "";
			}else if(drug_choice.equals("C")){
				drug_color = "red";
				disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ITEMSTORECOMBINOTFOUND.label","ph_labels")+"'>";
				chk_dsbl = "disabled";
				ip_fill_chk_value = "N";
				ip_fill_chked	 = "";
			}

			if(disp_qty.equals("0")){
				drug_color = "";
				chk_dsbl = "";
				ip_fill_chk_value = "N";
				//ip_fill_chked	 = "checked";
				ip_fill_chked	 = "";
			}

	if(!prvs_nursing_unit_code.equals(nursing_unit_code)){
		prvs_nursing_unit_code = nursing_unit_code;
%>
		<TR>
		<th COLSPAN="9" align="left"><%=nursing_unit_desc%> </th>
		</TR>
<%}	
		if(!line_flag.equals("N")){
%>
			<TR>
			<th height="1" COLSPAN="9" align="right"><input  type="checkbox"  name="select_patients<%=total_patients%>"  id="select_patients<%=total_patients%>"   onclick="checkAll_patientsorder(this,'<%=patient_id %>');" value="Y" checked></th>
			<input type="hidden" name="patient_id_check<%= total_patients%>" id="patient_id_check<%= total_patients%>" value="<%=patient_id%>">
			</TR>
<%
		total_patients++;
		}
%>
		<input type="hidden"   name="order_id_<%=patient_id%>"  id="order_id_<%=patient_id%>" value="'<%=order_id%>'">
		<%
		System.out.println("order_id==> "+order_id);
		
		
		%>
		<TR>
	   <TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="left" width = "27%">
		<font size="1" style="cursor:pointer;color:blue" title="Drug Profile"      onclick="showDrugProfile('<%=patient_id%>');"><%=patient_Name%><%=date_of_birth%><%=gender%>
		<%=patient_details%>&nbsp;</TD>
		<TD class="BODYCOLORFILLED" ALIGN="left" width = "22%" ><font size="1" style="cursor:pointer;color:blue" title="View Order"onClick="callMenuFunctions('View','Pharmacy','<%=order_id%>','','<%=patient_id%>')">&nbsp;
		<%=ord_drug_name%></TD>
		
		
		<TD class="BODYCOLORFILLED" width="3%" ALIGN="right"><font size="1"><%=ord_drug_qty%>&nbsp;</TD>
		<TD class="BODYCOLORFILLED" width="4%" style="BORDER-STYLE: none solid none none" ALIGN="left"><font size="1"><%=ord_drug_uom%>&nbsp;&nbsp;</TD>


<%if(drug_choice.equals("N")){%>
		<TD class="BODYCOLORFILLED" >&nbsp;&nbsp;</TD>
<%}else{%>
		<TD class="BODYCOLORFILLED" >&nbsp;&nbsp;</TD>
    <%}%>
		<input type="hidden" name="drug_code_<%=i%>" value="<%=disp_drug_code%>">
		<input type="hidden" name="ord_drug_code_<%=i%>" value="<%=ord_drug_code%>">


		<input type="hidden" name="end_date_time_<%=i%>" value="<%=fill_int_end_date_time%>">
		<TD class="BODYCOLORFILLED" ALIGN="left" width = "18%"  ><font size="1" color="<%=drug_color%>">
		<label id="disp_drug_id_<%=i%>" name="disp_drug_name_<%=i%>" ><%=disp_drug_desc%></label></TD>
		<TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="center" nowrap><font size="1"><%=(String)ip_fill_order.get("Tot_Disp_Qty")%></TD>
		<TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="left" nowrap><font size="1"  ><label id="disp_qty_id_<%=i%>" name="disp_qty_<%=i%>" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_qty%></label>
		&nbsp;<label id="disp_qty_uom_id_<%=i%>" name="disp_qty_uom_<%=i%>" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_qty_uom%></label>
		<input type="hidden" name="disp_batch_dtl_<%=i%>" value="<%=disp_btch%>">
		</TD>
		<input type="hidden" name="disp_uom_id_<%=i%>" value="<%=disp_qty_uom%>">
		<TD class="BODYCOLORFILLED" ALIGN="right"><input type="hidden"  name="ip_fill_chk_<%=i%>" value="<%=ip_fill_chk_value%>" <%=chk_dsbl%>  onclick="checkOne(this)"></TD>
		
		</TR>
		
		<input type="hidden"  name="order_id_<%= i%>" value="'<%=order_id%>'">
		
		
		
		<input type="hidden" name="Patient_id_<%= i%>" value="'<%=patient_id%>'">
<%
		}
%>
		<TR>
		<th height="1" COLSPAN="9" align="left"></th>
		</TR>
</TABLE>
<%
	}else{
%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		window.close();
		</script>
<%}%>

<INPUT TYPE="hidden" name="bean_id" id="bean_id"		VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name"	VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="total_drugs" id="total_drugs"	VALUE="<%= total_drugs %>">
<INPUT TYPE="hidden" name="store_code" id="store_code"	VALUE="<%=disp_locn_code%>">
<INPUT TYPE="hidden" name="facility_id" id="facility_id" value="<%=OrderingFacility_code%>"> 
<INPUT TYPE="hidden" name="total_patients" id="total_patients"	VALUE="<%= total_patients %>">
<INPUT TYPE="hidden" name="Nursing_Unit_From_Code_grn" id="Nursing_Unit_From_Code_grn"	VALUE="<%= Nursing_Unit_From_Code %>">
<INPUT TYPE="hidden" name="fill_int_start_date_time_grn" id="fill_int_start_date_time_grn"	 VALUE="<%= fill_int_start_date_time %>">
<INPUT TYPE="hidden" name="fill_int_end_date_time_grn" id="fill_int_end_date_time_grn"	VALUE="<%= fill_int_end_date_time %>">

</FORM>
 <FORM name="formPHGenerateFillList" id="formPHGenerateFillList"  TARGET="messageFrame" >
<br>
<br>
<INPUT TYPE="hidden" name="mode" id="mode"		VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= logged_fcy %>">
<INPUT TYPE="hidden" name="nursing_unit_query" id="nursing_unit_query" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_NURSINGUNIT_LOOKUP" ) %>">
<INPUT TYPE="hidden" name="Nursing_Unit_From_Code" id="Nursing_Unit_From_Code">
<INPUT TYPE="hidden" name="Nursing_Unit_To_Code" id="Nursing_Unit_To_Code" >
<INPUT TYPE="hidden" name="Default_Fill_Period" id="Default_Fill_Period" >
<INPUT TYPE="hidden" name="Schedule_Start_Time_Routine" id="Schedule_Start_Time_Routine" >
<INPUT TYPE="hidden" name="Exclude_Hrs" id="Exclude_Hrs" >
<INPUT TYPE="hidden" name="Disp_Locn" id="Disp_Locn" >
<INPUT TYPE="hidden" name="cDate" id="cDate" >
<INPUT TYPE="hidden" name="cMonth" id="cMonth">
<INPUT TYPE="hidden" name="cYear" id="cYear" >
<INPUT TYPE="hidden" name="cHours" id="cHours">
<INPUT TYPE="hidden" name="cMinutes" id="cMinutes">
<INPUT TYPE="hidden" name="currHours" id="currHours">
<INPUT TYPE="hidden" name="currMinutes" id="currMinutes">
<INPUT TYPE="hidden" name="Fill_Period_Unit" id="Fill_Period_Unit">
<INPUT TYPE="hidden" name="cut_off_limit_for_new_ord" id="cut_off_limit_for_new_ord">
<INPUT TYPE="hidden" name="routinefillalreadyinvoked" id="routinefillalreadyinvoked">
<INPUT TYPE="hidden" name="incstarttime" id="incstarttime">
<INPUT TYPE="hidden" name="incendtime" id="incendtime">
<INPUT TYPE="hidden" name="fill_int_start_date_time" id="fill_int_start_date_time" value="<%=fill_int_start_date_time%>"> 


</FORM> 
<!--<script>disableAll(true)</script>-->
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>
 

