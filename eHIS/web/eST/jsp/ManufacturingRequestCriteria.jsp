<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
08/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<%
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src="../../eST/js/ManufacturingRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale							=		(String)session.getAttribute("LOCALE");

//	pmd 29/01/05	
//	java.util.HashMap defaultParameter		=		null;
	String bean_id							=		"ManufacturingRequestBean";
	String bean_name						=		"eST.ManufacturingRequestBean";
	String disable							=		"";
	String allow_deci_yn        =       "";
	String no_deci              =       "";
	ManufacturingRequestBean bean			=		(ManufacturingRequestBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	int no_of_decimals					=			bean.getNoOfDecimals();

	String index							=		bean.checkForNull(request.getParameter("index"),"-1");
	String disablefield						=		"disabled";
	String disableAddMod					=		"disabled";
	String disableItem						=		"";
//	String disablePT						=		"";
	//String legend							=		"Add";
	String legend							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String pt								=		"";
	String mode								=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
//	String remarks							=		request.getParameter( "remarks" )==null?"":  request.getParameter( "remarks" );
	ArrayList recordSet						=		new ArrayList();
	int seq_no								=		bean.seq_no;

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	try{
	if(!index.equals("-1")){
		//legend							=		" Modify ";
	    legend								=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		disableAddMod						=		"";
		disableItem							=		"disabled";
		disablefield						=		"disabled";
//		disablePT							=		"disabled";
		recordSet							=		bean.getDataRecordList();
	
	
		HashMap record						=		(HashMap)	recordSet.get(Integer.parseInt(index));
			
		bean.setReq_store((String)record.get("REQUESTING_STORE_CODE"));
		bean.setPrep_loc((String)record.get("PREPARE_LOCATION_CODE"));
		bean.setReq_type((String)record.get("PREPARATION_TYPE"));
		bean.setPrep_mode((String)record.get("PREPARATION_MODE"));
		bean.setItem_code((String)record.get("ITEM_CODE"));
		allow_deci_yn        =       bean.getAllowDecimalsYN(bean.getItem_code());
       if(allow_deci_yn.equals("Y"))
		no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		else
         no_deci   = "0";

		bean.setReq_qty(bean.setNumber((String)record.get("REQUEST_QTY"),Integer.parseInt(no_deci)));
		bean.setPatient_id((String)record.get("PATIENT_ID"));
		bean.setEncounter_id((String)record.get("ENCOUNTER_ID"));
		bean.setShort_desc((String)record.get("SHORT_DESC"));
		bean.setStock_uom((String)record.get("STOCK_UOM"));
		bean.setRemarks((String)record.get("REMARKS"));
		seq_no=Integer.parseInt((String)record.get("MFG_REQUEST_NO"));
		bean.setPatient_name((String)record.get("PATIENT_NAME"));
		bean.setStock_label("Stock UOM");
		pt								=		(String)record.get("PREPARATION_TYPE");
		if(bean.getReq_type().equals("E")){
			disablefield				=		"";
			disable						=		"disabled";
			bean.setShort_desc((String)record.get("ITEM_CODE"));
			bean.setStock_label("");
		}
		if((bean.getAllowDecimalsYN(bean.getItem_code())).equals("N")){
			no_of_decimals = 0;
		}
	}
	else{
		seq_no							=		Integer.parseInt(bean.getExtemp_item_seq());
		if(seq_no==0)
			seq_no						=		bean.getSeqNo();

		bean.setReq_store("");
		//bean.setPrep_loc("");
		bean.setReq_type("");
		bean.setPrep_mode("");
		bean.setItem_code("");
		bean.setReq_qty("");
		bean.setPatient_id("");
		bean.setEncounter_id("");
		bean.setShort_desc("");
		bean.setStock_uom("");
		bean.setStock_label("");
		bean.setPatient_name("");
		bean.setRemarks("");
	}
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			disable						=		"disabled";
	
	
		allow_deci_yn        =       bean.getAllowDecimalsYN(bean.getItem_code());
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";
	}

	  /**
		 * @Name - Priya
		 * @Date - 03/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and round up cost with noOfDecimalsForCost
		 */
	        String noOfDecimalsForCost=bean.getNoOfDecimalsCost();
				 
				 
				//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
				    String ACC_ENTITY_ID = "ZZ";
				    HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
					
					 
				     String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
				     String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
				     String prep_extemp   =   bean.checkForNull((String)hmTemp.get("PREP_EXTEMP_LG"));
				     String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
				     
				     if(prep_prepack.equals("") && prep_standard.equals("") && prep_extemp.equals("") && prep_others.equals("") ){
				    	 prep_prepack  = "Pre Packing";
				         prep_standard = "Standard Formulary";
				         prep_extemp   = "Extemporaneous";
				         prep_others   =  "Others";
				     }
				 
	%>
<body onMouseDown="CodeArrest()">
<form name="manufacturing_form" id="manufacturing_form" >

<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
<tr>
	<td colspan=1 width='13%'>&nbsp;</td>
	<td colspan=1 width='35%'>&nbsp;</td>
	<td colspan=1 width='5%'>&nbsp;</td>
	<td colspan=1 width='8%'>&nbsp;</td>
	<td colspan=5>&nbsp;</td>
</tr>
<tr>
	<td   class="label" ><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
	<td  class='fields'>&nbsp;<select name='req_store' id='req_store' <%=disableItem%> ><%=bean.getRequestStore()%></select><%=bean.getImage("M")%></td>
	<td  class="label"  nowrap><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
	<td   colspan=3 class='fields'>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select><%=bean.getImage("M")%></td>
</tr>
<!-- 	("A, -------- Select -------- ;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type()); -->
<tr>
	<td   class="label" ><fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<select name='req_type' id='req_type' onChange="onChanegeVal(this)"  <%=disable%> <%=disableItem%>  > 
			
			   <OPTION VALUE="A" <%=bean.getReq_type().equals("A")?"Selected":""%>> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </OPTION>
			  <%if(!prep_prepack.equals("")){ %>
			 <OPTION VALUE="P" <%=bean.getReq_type().equals("P")?"Selected":""%>><%=prep_prepack %></OPTION>
			 <% } if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S" <%=bean.getReq_type().equals("S")?"Selected":""%>><%=prep_standard %></OPTION>
			<% } if(!prep_extemp.equals("")) {%>
			<OPTION VALUE="E" <%=bean.getReq_type().equals("E")?"Selected":""%>><%=prep_extemp %></OPTION>
			<% } if(!prep_others.equals("")){ %>
			<OPTION VALUE="O" <%=bean.getReq_type().equals("O")?"Selected":""%>><%=prep_others %></OPTION>
			<%} %>
			
			<!--  <OPTION VALUE="P" <%=bean.getReq_type().equals("P")?"Selected":""%>><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="S" <%=bean.getReq_type().equals("S")?"Selected":""%>><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="E" <%=bean.getReq_type().equals("E")?"Selected":""%>><fmt:message key="eST.Extemporaneous.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O" <%=bean.getReq_type().equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>  -->
	</select><%=bean.getImage("M")%></td>
	<td  class="label" nowrap><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></td>
	<td colspan=3  class='fields'>&nbsp;<select name='prep_mode' id='prep_mode'  <%=disableItem%>  ><OPTION VALUE=""  <%=bean.getPrep_mode().equals("")?"Selected":""%>>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
			<OPTION VALUE="S" <%=bean.getPrep_mode().equals("S")?"Selected":""%>><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="N" <%=bean.getPrep_mode().equals("N")?"Selected":""%>><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="O" <%=bean.getPrep_mode().equals("O")?"Selected":""%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION></select><%=bean.getImage("M")%></td>
   </td>
</tr>
<tr>
	<td  class="label"  nowrap><a href="javascript:callRemarksModal('<%=index%>',document.manufacturing_form.remarks.value)"><fmt:message key="Common.item.label" bundle="${common_labels}"/></a></td>
	<td  class='fields'>&nbsp;<input type='text' size=60  maxlength=60 name='item_code_desc' id='item_code_desc'   <%=disable%> <%=disableItem%> value="<%=bean.checkForNull(bean.getShort_desc())%>"><input type=button name='searchitem' id='searchitem' value="?" class='Button' <%=disable%> <%=disableItem%>  onClick="callItemSearchScreen(item_code_desc,document.forms[0]);"><%=bean.getImage("M")%></td><td  class="label"  nowrap id ="stock_label" name ="stock_label">&nbsp;<%=bean.checkForNull(bean.getStock_label(),"&nbsp;")%>&nbsp;</td>
	<td  id="stock_uom" name="stock_uom" class="QUERYDATA" ><%=bean.checkForNull(bean.getStock_uom(),"&nbsp;")%></td>
	<td  width='10%' class="label" nowrap><fmt:message key="Common.ReqQuantity.label" bundle="${common_labels}"/></td>
	<td   width="12%"  class='fields'>&nbsp;<input type='text'  onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"  onBlur="checkDoubleFormat(this,true); " name="req_qty" class="NUMBER" value="<%=bean.checkForNull(bean.getReq_qty())%>" size=12 maxlength=12><%=bean.getImage("M")%></td>
</tr>
<tr>
	<td class='label'   ><span id="pid"  style="visibility:hidden" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></span></td>
	<td colspan='5' class='fields'>&nbsp;<input type='text' size=20 maxLength=<%=bean.getpatlength()%> name="p_text" id="p_text"  style="visibility:hidden"  value="<%=bean.checkForNull(bean.getPatient_id())%>"  onBlur="getPatientName(patient_id,document.forms[0]);" ><input type='button' name="p_button" id="p_button" class='button' value="?"  style="visibility:hidden"   onClick="callPatientSearch(patient_id,patient_name,document.forms[0])" ><span id=im style="visibility:hidden"><%=bean.getImage("M")%></span><font size=1><b id="pn">&nbsp;<%=bean.checkForNull(bean.getPatient_name())%></b></font>
	</td>
</tr>
<tr>
	<td class='label'      ><span id="eid" style="visibility:hidden" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></span></td>
	<td class='fields'>&nbsp;<select  name="e_sel" id="e_sel" style="visibility:hidden"     >
	<%=bean.getEncounter_id_List()	%>
	</select></td>
	<td  colspan=4 class='fields'><input type=button name='ExItem' id='ExItem' value='<fmt:message key="eST.ExternalItem.label" bundle="${st_labels}"/>' class='Button'  onClick="callItemChildWindow('<%=index%>','<%=bean.getExtemp_item_seq()%>');"    <%=disablefield%> >&nbsp;<input type=button name='add' id='add' value=" <%=legend%> " class='Button' <%=disableAddMod%>   onClick="hdrData(<%=index%>);"    >&nbsp;<input type=reset name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='Button'  onClick="cancelHdrData(<%=index%>)">
	</td>
</tr>

</table>
<script>
	dispField("<%=pt%>");
</script>
	<input type='hidden' name='mode' id='mode'			value='<%=mode%>'>
	<input type='hidden' name='bean_id' id='bean_id'			value="<%=bean_id%>" >
	<input type='hidden' name='bean_name' id='bean_name'		value="<%=bean_name%>" >
	<input type='hidden' name='item_code' id='item_code'		value="<%=bean.getItem_code()%>" >
	<input type='hidden' name='patient_name' id='patient_name'	value="<%=bean.getPatient_name()%>" >
	<input type='hidden' name='extemp_item_seq' id='extemp_item_seq' value="<%=seq_no%>" >
	<input type='hidden' name='remarks' id='remarks'			value="<%=bean.checkForNull(bean.getRemarks())%>" >
	<input type='hidden' name='checkBoxVals' id='checkBoxVals'>
	<input type='hidden' name='stock_item_yn' id='stock_item_yn' >
	<input type='hidden' name='preptype' id='preptype' >
	<input type='hidden' name='prepmode' id='prepmode' >
	<input type='hidden' name='stock_available_yn' id='stock_available_yn' >
	<input type='hidden' name='phy_inv_id' id='phy_inv_id'		value="">
	<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>" >
	<input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>" >
	<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn" value="<%=bean.getAllowDecimalsYN(bean.getItem_code())%>">
	<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=no_of_decimals%>">
	<input type="hidden" name="no_of_decimals_for_cost" id="no_of_decimals_for_cost" value='<%=noOfDecimalsForCost%>'>

</form>
	<%
	}catch(Exception e){
		e.printStackTrace();
}	

putObjectInBean(bean_id,bean,request);

%>
</body>
</html>

