<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/04/2016		56060			B.Badmavathi						Authorize at Issue Store
31/10/2019              IN:071344               B Haribabu      15/10/2019              Manickam        GHL-CRF-0609   
08/06/2020              IN:072963               Haribabu                                               ML-MMOH-CRF-1389.1                                             
22/2/2022		TFS27891			Shazana	 											MO-CRF-20176
23/05/2023      TFS42938            Keerti                                     MMS-DM-CRF-0230-US002    
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@	page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<!DOCTYPE html>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html> 
	<head>
		<title> </title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086		
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/CommonLookup.js"></script> -->
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/Store.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onload="FocusFirstElement();">
<%
	String disabled						=		"";
	String def_disabled					=		"";
	String codeDisabled					=		"";
	String mode							=		"";
	String bean_id						=		"";
	String bean_name					=		"";
	String store_type					=		"";
//	String dis1							=		"";
	String dis2							=		"";
	String store_desc					=		"";
	String dept_desc					=		"";
	String external_yn					=		"";
	String external_label				=		"";
	//String scope						=		"";
	String optionTag					=		"";
	String storeTypeDisabled			=		"";
	String authorizesplreq_val			=		"";
	String authorizesplreq_chk			=		"";
	//String Op_sale_appl_check			=		"";
	//String Ip_sale_appl_check			=		"";
	//String Ref_sale_appl_check			=		"";
   // String Ref_sale_appl_check_value	=		"";
  //  String Ip_sale_appl_check_value		=		"";
  //  String Op_sale_appl_check_value		=		"";
	String check						=		"";
	String dis							=		"";
	String store_group = "";	
	//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013 Starts
	   HashMap hmrecords = new HashMap();
       String iss_checked        = "";
       String urg_iss_checked    = "";
	   String ret_checked        = "";
	   String tfr_checked        = "";
	   String records_exist_for_issue       =		"N";
	   String records_exist_for_issueReturn	 =		"N";
	   String records_exist_Stock_transfer  =		"N";
	   String con_period__disabled = "disabled";//Added for IN:071344
	   String mand_visibility =	"visibility:hidden";//Added for IN:071344
	  //ends
	   String auth_checked = "";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 

	String facility_id					=		(String)session.getValue("facility_id");
	/* Mandatory checks start */
	mode								=		request.getParameter( "mode" ) ;
	bean_id								=		"StoreBean" ;
	bean_name							=		"eST.StoreBean";

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	

	/* Initialize Function specific start */
	StoreBean bean						=		(StoreBean)getBeanObject(bean_id,bean_name,request) ;  
	bean.setLanguageId(locale);
	bean.clear() ;

	ServletContext context				=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

	String interface_to_external_po_yn =bean.getInterface_to_external_po_yn((String)session.getAttribute("ACC_ENTITY_ID"));
	String auth_allowed ="";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 
	/* Initialize Function specific end */
		//external_label				=		"External";
		 external_label					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
	//Added for IN:071344 start
     Connection con				= null;
	 
	boolean auto_rol_appl = false;
	boolean auto_config_intf_items_appl = false;//Added for IN:072963
	String auto_rol_appl_yn="N";//Added for IN:072784		
	boolean uom_for_pharmacy_interface = false; //Added for MMS-DM-CRF-0230 US002
	try 
	{
		con						= ConnectionManager.getConnection(request);
		auto_rol_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","AUTO_ROL_APPL");
		auto_config_intf_items_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_AUTO_CONFIG_ITEMS_APPL");
		uom_for_pharmacy_interface =eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_UOM_FOR_PHIS_INTERFACE"); //Added for MMS-DM-CRF-0230 US002
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	if(auto_rol_appl){
		auto_rol_appl_yn="Y";
	}
	//Added for IN:071344 end
boolean finalizedcount = false; //MO-CRF-20176  
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled					=		"disabled";
		if (null == request.getParameter( "store_code" ) )
			return;		
		bean.setStore_code(request.getParameter( "store_code" )) ;
		String def_store_code = (String)bean.fetchRecord("SELECT DEF_STORE_CODE_FOR_REC DEF_STORE_CODE FROM ST_FACILITY_PARAM WHERE FACILITY_ID =?",facility_id).get("DEF_STORE_CODE");
		bean.loadData() ;

		ArrayList arrParams = new ArrayList();
		arrParams.add(bean.checkForNull((String)bean.getStore_code()));
		arrParams.add(locale);
		store_group = bean.checkForNull((String)bean.fetchRecord("SELECT short_desc FROM mm_store_group_lang_vw WHERE store_group_code = (SELECT st.store_group_code FROM mm_store st WHERE st.store_code =?) and language_id = ?",arrParams).get("SHORT_DESC"));
		

		disabled						=		bean.isStoreDisabled()?"disabled":"";
		store_type						=		bean.getStore_type_flag();
		if(bean.checkForNull(def_store_code).equals((String)bean.getStore_code())|| bean.isStoreDisabled()||store_type.equals("S")||store_type.equals("N"))
			def_disabled				=       "disabled";
		else
			def_disabled				=		"";
		
		if(store_type.equals("N"))
		{
			dis2						=		"disabled";
		}

		store_desc						=		bean.getStore_desc();
		dept_desc						=		"<b>" + bean.getDept_desc() + "</b>";
		external_yn						=		bean.getExternal_yn();

		if(bean.getStoreTypeFlag().equals("N")) {
			storeTypeDisabled			=		"disabled";
		}
		
		if(external_yn.equals("Y"))
		{
		  external_yn					=		"<image src='../../eCommon/images/enabled.gif'></image>"; 
		  optionTag						=		"N" ;
        } 
		else
		{
		  external_yn					=		"<image src='../../eCommon/images/disabled.gif'></image>";
       	} 

		//code added for authorize  special request..
		
		if((bean.getAuthorizeSpecialRequest()).equals("Y")){
			authorizesplreq_val			=		"Y";
			authorizesplreq_chk			=		"checked";
		}else{
			authorizesplreq_val			=		"N";
			authorizesplreq_chk			=		"";
		}
// @ ---
/*
	
		Op_sale_appl_check				=		bean.getOp_sale_appl_check();
		Ip_sale_appl_check				=		bean.getIp_sale_appl_check();
		Ref_sale_appl_check				=		bean.getRef_sale_appl_check();

	
   if(Op_sale_appl_check.equals("Y"))
   {
	   
	   Op_sale_appl_check_value			=		"checked";
	   
   }
   else
   {
	   
	   Op_sale_appl_check_value			=		"";
   }

 if(Ip_sale_appl_check.equals("Y"))
   {
	   
	   Ip_sale_appl_check_value			 =		"checked";
	   
   }
   else
   {
	   
	   Ip_sale_appl_check_value			 =		"";
   }


 if(Ref_sale_appl_check.equals("Y"))
   {
	   
	   Ref_sale_appl_check_value		  =		"checked";
   }
   else
   {
	   
	   Ref_sale_appl_check_value		  =		"";
   }*/

    //Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013 Starts
      if(bean.getRecordCountForIssue())
			records_exist_for_issue = "Y";
		if(bean.getRecordCountForIssueReturn())
			records_exist_for_issueReturn = "Y";
		if(bean.getRecordCountForStockTransfer())
			records_exist_Stock_transfer = "Y";
			
			//ends
//Added for IN:071344 start
if(bean.getChecked(bean.getChk_auto_rol_yn())=="checked"){
	con_period__disabled = "";
	mand_visibility		 =	"visibility:visible";
}
//Added for IN:071344 end
finalizedcount = bean.getRecordCountForTransactionTables(bean.getStore_code()); //MO-CRF-20176
	}
	
else
{
	check="checked";
}
         //Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013 Starts
					 hmrecords = bean.getAckReqdyn();
					 String iss_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("ISS_ACK_REQ_YN"),"N");
					 String ret_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("RET_ACK_REQ_YN"),"N");
					 String tfr_ack_reqd_yn  = bean.checkForNull((String)hmrecords.get("TFR_ACK_REQ_YN"),"N");
					  
	                    if(iss_ack_reqd_yn.equals("Y") && bean.getIss_Ack_Yn().equals("Y")){
						 iss_checked = "checked";
						 }
						 if(iss_ack_reqd_yn.equals("Y") && bean.getUrg_Iss_Ack_Yn().equals("Y")){
						 urg_iss_checked = "checked";
						 }
						if(ret_ack_reqd_yn.equals("Y") && bean.getIss_Ret_Ack_Yn().equals("Y")){
						 ret_checked = "checked";
						}
						if(tfr_ack_reqd_yn.equals("Y") && bean.getTfr_Ack_Yn().equals("Y")){
						 tfr_checked = "checked";
						}
	                   //ends
	                     


%>
	<form name="formStore" id="formStore"   onreset="FocusFirstElement();"  onload="Status();" >
		<table border="0" cellpadding="1" cellspacing="0" style="width:100vw;height:20vh ">

			<tr>
				<td  class='label'><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td colspan=2 class=fields>
					<input type=text name="store_code" id="store_code" maxlength=6 size =6 value="<%=bean.getStore_code()%>" <%=codeDisabled%> class='UPPER' onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);"><input type=button value='?' class=button onClick="return searchCodeStore(store_code);" ><%=bean.getImage("M")%>&nbsp;&nbsp;<b><%=store_desc%></b>
					<label class=label id="td_storedesc"></label>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td class='label'>	<fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
				<td colspan=3 class=fields>	
				<input type=text name="bin_loc_desc" id="bin_loc_desc" maxlength=40 size =40 readonly value="<%=bean.getBin_loc_desc().trim()%>" ><input type=button value='?' class=button onClick="return searchCodeBinLocation(bin_loc_code,store_code);" ></td>
				<input type="hidden" name="bin_loc_code" id="bin_loc_code"				value="<%=bean.getBin_loc_code()%>">

		</tr>
        <tr>

		        <td  class=label id="td_department_label"><fmt:message key="Common.department.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td> 

		        <td  class=fields id="td_department" colspan=2><%=dept_desc%>&nbsp;&nbsp;</td> 

				<td  class="label"  id="td_external_gif_label"> <%=external_label%>
				</td>
                <td  class="fields" colspan=3  id="td_external"><%=external_yn%></td>
		</tr>

		<tr>
			<td  class='label' nowrap>
				<fmt:message key="Common.StoreType.label" bundle="${common_labels}"/>&nbsp;&nbsp;
			</td>
		<%
			if( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) { 
				if(optionTag.equals("N")) {
		%>
					<td  class=fields colspan=2>
						<select name=store_type_flag id=store_type_flag disabled>
							<option value="N">
								<fmt:message key="eST.NonStockStore.label" bundle="${st_labels}"/>&nbsp;&nbsp;
							</option>
						</select>
						<%=bean.getImage("M")%>
					</td>
		 <%
			} 
			else { 
		%>
				<td  class=fields colspan=2>
					<select name=store_type_flag id=store_type_flag onchange='validate_store_typeModify(this)' <%=storeTypeDisabled%>>  
						<%=bean.getStore_type_List(bean.Store_type())%>
					</select>
					<%=bean.getImage("M")%>
				</td>
	<% 
			} 
		} 
		else { 
	%>
				<td  class=fields colspan=2>
					<select name=store_type_flag id=store_type_flag onchange='validate_store_type(this)' onBlur="addParentStore(this);">
						<%=bean.getStore_type_List()%>
					</select>
					<%=bean.getImage("M")%>
				</td>

	<% 
		} 
	%>
				<td class=label >
				<fmt:message key="eMM.StoreGroup.label" bundle="${mm_labels}"/>
					&nbsp;&nbsp;
				</td>
				<td class=fields colspan=3>
				<label class=label id="td_storegroup"><b><%=store_group%></b></label>&nbsp;
				</td>
					
				</td>
				
			</tr>

			<tr>

		        <td  class=label >
				<fmt:message key="eST.ParentStore.label" bundle="${st_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;
				</td> 

		        <td  class=fields colspan=2>
				<select name="parent_store_code" id="parent_store_code">
						<%=bean.getParent_store_code_List()%>
				</select>&nbsp;&nbsp;
				</td> 

				<td  class=label>
				<fmt:message key="eST.ReorderDays.label" bundle="${st_labels}"/>
				</td>
                <td  class=fields colspan=3>
				<input type=text name=reorder_freq_days id=reorder_freq_days size=3 maxlength=3  class="NUMBER"  value="<%=bean.getReorder_freq_days()%>" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this);">
				</td>
			</tr>
		</table>

		<table border="0" cellpadding="0" cellspacing="0" style="width:100vw;height:20vh">
			<tr>
				<td  class=label nowrap width='8%'>
					<fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/>&nbsp;
				</td>
				<td class=fields width='5%'>
					<input type=checkbox name=medical_item_yn id=medical_item_yn  value="Y" <%=codeDisabled%>  <%=bean.getChecked(bean.getMedical_item_yn())%> >
					&nbsp;&nbsp;
				</td>
				<td  class=label nowrap width='9%'><fmt:message key="eST.NonMedicalItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;</td>
				<td class=fields width='5%'>&nbsp;<input type=checkbox name=nonmedical_item_yn id=nonmedical_item_yn  value="Y" <%=codeDisabled%>  <%=bean.getChecked(bean.getNonmedical_item_yn())%> ></td>
				
				<td width='20%' class=label nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.ConsiderStockpositionforReorder.label" bundle="${st_labels}"/>&nbsp;</td><td>
				<input type=checkbox name=chk_stk_lvl_for_pur_yn id=chk_stk_lvl_for_pur_yn value="Y"  <%=bean.getChecked(bean.getChk_stk_lvl_for_pur_yn())%>></td>
				<td colspan=8>&nbsp;</td>
				<!-- Modified for IN:071344  start -->
				<%if(auto_rol_appl) {%>
				<td width='10%' class=label nowrap>&nbsp;<fmt:message key="eST.ConsiderForAutoROLCalculation.label" bundle="${st_labels}"/>&nbsp;</td><td>
				<input type=checkbox name=chk_auto_rol_yn id=chk_auto_rol_yn value="Y"  <%=bean.getChecked(bean.getChk_auto_rol_yn())%> onclick="enableConPeriod(this)" ></td>
				<td colspan=8>&nbsp;</td>
				<td width='10%' class=label>
				<fmt:message key="eST.CunsumptionPeriod.label" bundle="${st_labels}"/>&nbsp;</td><td>
				<input type=text name=consm_freq_days id=consm_freq_days  size=2 maxlength=2  class="NUMBER"  value="<%=bean.getConsm_freq_days()%>"  <%=con_period__disabled%> onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this);"> &nbsp;<img align='center' id='span2'  style="<%=mand_visibility%>" src='../../eCommon/images/mandatory.gif'></img></td><!-- Modified for  IN:071344 -->
				</td>
				<%} %>
				<!-- Modified for IN:071344  end -->
			</tr>

			<tr>
				<td  class=label nowrap width='10%'><fmt:message key="eST.AlertPickSlipPrint.label" bundle="${st_labels}"/>&nbsp;</td>
				<td class=fields><input type=checkbox name=alert_pickslip_yn id=alert_pickslip_yn  value="Y" <%=bean.getChecked(bean.getAlertforPrint_yn())%> >&nbsp;</td>
				<td colspan=8>&nbsp;</td>
				<td colspan=2>&nbsp;</td>
			</tr> 
			<tr>
				<td  class=label nowrap width='10%'><fmt:message key="eST.InpatientSaleApplicable.label" bundle="${st_labels}"/>&nbsp;</td>
				<td class=fields><input type=checkbox name="Inpatient_sale_applicable_yn" id="Inpatient_sale_applicable_yn"  value="Y" <%=bean.getChecked(bean.getIp_sale_appl_yn())%>>&nbsp;</td>
				<td  class=label nowrap width='10%'><fmt:message key="eST.OutpatientSaleApplicable.label" bundle="${st_labels}"/>&nbsp;</td>
				<td class=fields>&nbsp;<input type=checkbox name="Outpatient_sale_applicable_yn" id="Outpatient_sale_applicable_yn"  value="Y" <%=bean.getChecked(bean.getOp_sale_appl_yn())%> >&nbsp;</td>				
				<td  class=label nowrap width='10%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.ReferralSaleApplicable.label" bundle="${st_labels}"/>&nbsp;</td>
				<td class=fields><input type=checkbox name="Ref_sale_applicable_yn" id="Ref_sale_applicable_yn"  value="Y" <%=bean.getChecked(bean.getRef_sale_appl_yn())%> >&nbsp;</td>
				<td colspan=8>&nbsp;</td>
				<!-- Modified for  MMS-DM-CRF-0230 US002 start -->
                <%if(uom_for_pharmacy_interface) { %>
                    <td width='10%' class="label" nowrap>&nbsp;<fmt:message key="eST.UomForPharmacyInterface.label" bundle="${mm_labels}"/>&nbsp;</td><td>
                    <select id="uom_id" name="uom1" id="uom1" >
                        <option value=''  <%if(bean.getUom().trim().equals("")) out.print("selected");%> >&nbsp;&nbsp;&nbsp--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp</option>
                        <option value="H" <%if(bean.getUom().trim().equals("H")) out.print("selected");%>><fmt:message key="eST.HighestUOM.label" bundle="${mm_labels}"/></option>
                        <option value="L" <%if(bean.getUom().trim().equals("L")) out.print("selected");%> ><fmt:message key="eST.LeastUOM.label" bundle="${mm_labels}"/></option>
                    </select>        
                    </td>
                <%} %>        
                <!-- Modified for  MMS-DM-CRF-0230 US002 end -->
			</tr>
			<tr>
				<td  class=label nowrap width='10%'>Day Care Sale Applicable&nbsp;</td>
				<td class=fields><input type=checkbox name="dc_sale_applicable_yn" id="dc_sale_applicable_yn"  value="Y" <%=bean.getChecked(bean.getDc_sale_appl_yn())%>>&nbsp;</td>
				<td  class=label nowrap width='10%'>Emergency Sale Applicable&nbsp;</td>
				<td class=fields>&nbsp;<input type=checkbox name="em_sale_applicable_yn" id="em_sale_applicable_yn"  value="Y" <%=bean.getChecked(bean.getEm_sale_appl_yn())%> >&nbsp;</td>				
				<td  class=label nowrap width='10%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Direct Sale Applicable&nbsp;</td>
				<td class=fields><input type=checkbox name="direct_sale_applicable_yn" id="direct_sale_applicable_yn"  value="Y" <%=bean.getChecked(bean.getDirect_sale_appl_yn())%> >&nbsp;</td>
				<td colspan=8>&nbsp;</td>
			</tr>
			<!-- Added for IN:072963 start -->
			<tr>
			
			<%if(auto_config_intf_items_appl){ %>
				<td  class=label nowrap width='10%'><fmt:message key="eST.AutomaticallyAssociateNewInterfaceItemsToStore.label" bundle="${st_labels}"/>&nbsp;</td>
				<td class=fields><input type=checkbox name="auto_associate_intf_items_yn" id="auto_associate_intf_items_yn"  value="Y" <%=bean.getChecked(bean.getAutoAssocIntfItemsYN())%>>&nbsp;</td>
				<%} %>
			</tr>	
			<!-- Added for IN:072963 end -->
			<tr><td colspan=8>&nbsp;</td><td colspan=8>&nbsp;</td></tr>
		</table>

		<br>

		<table border="1" cellpadding="0" cellspacing="0" style="width:90vw;height:42vh scroll:overflow" align="center">
				<tr>
					<th><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
					<!--Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013 Starts -->
					<th><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></th>
					<th>No. of records <br>per Transaction</th>
					
					<th><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.Acknowledge.label" bundle="${st_labels}"/></th>
					<th>No. of records <br>per Transaction</th>
				</tr>
				<tr>
						<td class='QRYODD' width='30%'><fmt:message key="eST.OpeningStock.label" bundle="${st_labels}"/></td>
						<td class='QRYODD'  width='20%'>&nbsp;<input type="checkbox" value="Y" name="obs_allowed_yn" id="obs_allowed_yn" <%=dis2%> <%=bean.getChecked(bean.getObs_allowed_yn())%> <%=disabled%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						
						<td class='QRYODD' width='30%' ><fmt:message key="eST.GoodsReceipt.label" bundle="${st_labels}"/></td>
						<td class='QRYODD'  width='20%' >&nbsp;<input type="checkbox" value="Y"  name="grn_allowed_yn" id="grn_allowed_yn" <%=bean.getChecked(bean.getGrn_allowed_yn())%> <%=def_disabled%>  onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
				</tr>
				<tr>
						<td class='QRYEVEN'><fmt:message key="eST.VendorReturn.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="rtv_allowed_yn" id="rtv_allowed_yn" <%=bean.getChecked(bean.getRtv_allowed_yn())%> <%=def_disabled%>  onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						<td class='QRYEVEN'><fmt:message key="eST.Requisition.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="req_allowed_yn" id="req_allowed_yn" <%=bean.getChecked(bean.getReq_allowed_yn())%> <%=disabled%>  onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYEVEN">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
				</tr>
				<tr>
				<!--Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts-->
						<td class='QRYODD'><fmt:message key="eST.AuthorizeatIssueStore.label" bundle="${st_labels}"/></td>
							<%if(bean.getAllow_Auth_Issue_store().equals("N")){
								dis = "disabled";
								auth_allowed ="";%>
				   				<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="auth_allowed_yn" id="auth_allowed_yn" <%=auth_allowed %> <%=dis%>  onclick="incrementCount(this);"></td>
				   			<%}
				   			else{
								dis = "";%>
				   				<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="auth_allowed_yn" id="auth_allowed_yn" <%=bean.getChecked(bean.getAuth_allowed_yn())%> <%=dis%> onclick="incrementCount(this);"></td>
							 <%}%>
						<td align='center' class = "QRYODD">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
				<!--Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends-->
						<td class='QRYODD'><fmt:message key="eST.RequisitionIssues.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="iss_allowed_yn" id="iss_allowed_yn"  <%=bean.getChecked(bean.getIss_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td class="QRYODD"><input type="checkbox" name="iss_ack_yn" id="iss_ack_yn"  value="Y" <%=iss_ack_reqd_yn.equals("Y") ?"":"disabled"%> <%=iss_checked%> onclick="checkRecordsForIssue(this)" ></td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' name="records_per_trn_iss" id="records_per_trn_iss" onKeyPress= "return isValidInteger()" onblur="checkZero(this,'<%=finalizedcount%>','<%=bean.getRecords_per_trn_iss()%>','ISS');"  value="<%=bean.getRecords_per_trn_iss()%>" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
				</tr>
				<tr>
						<td class='QRYEVEN'><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="urg_allowed_yn" id="urg_allowed_yn" <%=bean.getChecked(bean.getUrg_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td class="QRYEVEN"><input type="checkbox" name="urg_iss_ack_yn" id="urg_iss_ack_yn"  value="Y" <%=iss_ack_reqd_yn.equals("Y") ?"":"disabled"%> <%=urg_iss_checked%> onclick="checkRecordsForIssue(this)"></td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER'  name="records_per_trn_urg" id="records_per_trn_urg" onKeyPress= "return isValidInteger()" value="<%=bean.getRecords_per_trn_urg()%>" onblur="checkZero(this,'<%=finalizedcount%>','<%=bean.getRecords_per_trn_urg()%>','URG');" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						<td class='QRYEVEN'><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="ret_allowed_yn" id="ret_allowed_yn" <%=bean.getChecked(bean.getRet_allowed_yn())%> <%=disabled%> onclick="incrementCount(this);"></td>
						<td class="QRYEVEN"><input type="checkbox" name="iss_ret_ack_yn" id="iss_ret_ack_yn"  value="Y" <%=ret_ack_reqd_yn.equals("Y") ?"":"disabled"%> <%=ret_checked%> onclick="checkRecordsForIssueReturn(this)" ></td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER'  name="records_per_trn_ret" id="records_per_trn_ret" onKeyPress= "return isValidInteger()" value="<%=bean.getRecords_per_trn_ret()%>" onblur="checkZero(this,'<%=finalizedcount%>','<%=bean.getRecords_per_trn_ret()%>','RET');" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 --> 
						 
				</tr>
				<tr>
						
						<td class='QRYODD'><fmt:message key="eST.ManufacturingItems.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="mfg_allowed_yn" id="mfg_allowed_yn" <%=bean.getChecked(bean.getMfg_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						<td class='QRYODD'><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="tfr_allowed_yn" id="tfr_allowed_yn" <%=bean.getChecked(bean.getTfr_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td class="QRYODD"><input type="checkbox" name="tfr_ack_yn" id="tfr_ack_yn"  value="Y" <%=tfr_ack_reqd_yn.equals("Y") ?"":"disabled"%> <%=tfr_checked%> onclick="checkRecordsForStockTransfer(this)" ></td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
				</tr>
				<tr>
						
						<td class='QRYEVEN'><fmt:message key="eST.StockAdjustment.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="adj_allowed_yn" id="adj_allowed_yn" <%=bean.getChecked(bean.getAdj_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYEVEN">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						<td class='QRYEVEN'><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="var_allowed_yn" id="var_allowed_yn" <%=bean.getChecked(bean.getVar_allowed_yn())%> <%=disabled%>  <%=dis2%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYEVEN">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						 
				</tr>
				<tr>
					
						<td class='QRYODD'><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="prt_allowed_yn" id="prt_allowed_yn" <%=bean.getChecked(bean.getPrt_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						<td class='QRYODD'><fmt:message key="eST.ChangeBin.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="bin_change_allowed_yn" id="bin_change_allowed_yn" <%=bean.getChecked(bean.getBin_change_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>	
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
				</tr>
				<tr>
						<td class='QRYEVEN'><fmt:message key="eST.SplitBatch.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="split_batch_allowed_yn" id="split_batch_allowed_yn" <%=bean.getChecked(bean.getSplit_batch_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>	
                        <td align='center' class = "QRYEVEN">&nbsp;</td>	
                        <td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
                        
                        	
                        <td class='QRYEVEN'><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y" name="srt_allowed_yn" id="srt_allowed_yn" <%=bean.getChecked(bean.getSrt_allowed_yn())%> <%=disabled%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYEVEN">&nbsp;</td>				
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->			
						
				</tr>
				<tr>
						<td class='QRYODD'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y" name="sal_allowed_yn" id="sal_allowed_yn" <%=bean.getChecked(bean.getSal_allowed_yn())%> <%=disabled%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>	
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						
						<!--modified 21/6/04 -->
						<td class='QRYODD'><fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></td>
						<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y"  name='stock_item_cons_yn' id='stock_item_cons_yn' <%=bean.getChecked(bean.getStcons_allowed_yn())%> <%=disabled%> <%=dis2%> onclick="incrementCount(this);"></td>
						<td align='center' class = "QRYODD">&nbsp;</td>	
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
					<!--modified 21/6/04 ends-->
				</tr>
				<tr>
						<td class='QRYEVEN'><fmt:message key="eST.AuthorizeSpecialRequest.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="<%=authorizesplreq_val%>"  name='authorize_spl_req_yn' <%=authorizesplreq_chk%> onclick="incrementCount(this);setAuthorizeSplReq()" onBlur="setAuthorizeSplReq();"></td> 
						<td align='center' class = "QRYEVEN">&nbsp;</td>		
						<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
						<%if(interface_to_external_po_yn.equals("Y")){%>
							<%if(bean.getGrn_allowed_yn().equals("Y"))
								dis = "";
				   			else
								dis = "disabled";
				   			%>
                      	<td class='QRYEVEN'><fmt:message key="eST.PurchaseOrderRequest.label" bundle="${st_labels}"/></td>
						<td class='QRYEVEN' >&nbsp;<input type="checkbox" value="Y"  name='prq_allowed_yn' id='prq_allowed_yn' <%=bean.getChecked(bean.getPRQ_allowed_yn())%> onclick="incrementCount(this);" <%=dis%> ></td> 
						<td class="QRYEVEN">&nbsp;</td>
						<%}else{%>
						<td class="QRYEVEN">&nbsp;</td>
						<td class="QRYEVEN">&nbsp;</td>
						<td class="QRYEVEN">&nbsp;</td>
						<td class="QRYEVEN">&nbsp;</td>
						<%}%>
				</tr>
				<tr>
					<td class='QRYODD'><fmt:message key="eST.CondemnExpiredBatches.label" bundle="${st_labels}"/></td>
					<td class='QRYODD' >&nbsp;<input type="checkbox" value="Y"  name='cndmn_exp_btch_allowed_yn' id='cndmn_exp_btch_allowed_yn' <%=bean.getChecked(bean.getCndmn_exp_btch_allowed_yn())%> onclick="incrementCount(this);"></td>
					<td class="QRYODD">&nbsp;</td>
					<td class='QRYODD'><input type=text size=6 maxlength=4 class='NUMBER' onKeyPress= "return isValidInteger()" value="" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><!-- MO-CRF-20176 -->
					<td class="QRYODD">&nbsp;</td>
					<td class="QRYODD">&nbsp;</td>
					<td class="QRYODD">&nbsp;</td>
				</tr>
				</table>
				</td>
			<td colspan=1 class=WHITE>&nbsp;</td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
			<input type="hidden" name="auto_rol_appl_yn" id="auto_rol_appl_yn"			value="<%=auto_rol_appl_yn%>"><!-- Added for IN:072784 -->
			<input type="hidden" name="interface_to_external_po_yn" id="interface_to_external_po_yn"			value="<%=interface_to_external_po_yn%>">
			
			<input type="hidden" name="SQL_MM_STORE_LOOKUP" id="SQL_MM_STORE_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_MM_STORE_LOOKUP")%>">
			<input type=hidden name=scope id=scope					value='<%=bean.inventoryModuleScope()%>'>
			<input type=hidden name=count id=count>
			<input type="hidden"	name="records_exist_for_issue" id="records_exist_for_issue"				value="<%= records_exist_for_issue %>">
	        <input type="hidden"	name="records_exist_for_issueReturn" id="records_exist_for_issueReturn"		value="<%= records_exist_for_issueReturn %>">
	        <input type="hidden"	name="records_exist_Stock_transfer" id="records_exist_Stock_transfer"			value="<%= records_exist_Stock_transfer %>">
</form>
<%
		putObjectInBean(bean_id,bean,request);
%>
            
            </body>
            </html>
			
