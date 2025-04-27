<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //String locale			= (String)session.getAttribute("LOCALE");
	   	String facility_id					= (String) session.getValue("facility_id");
 
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/DrugNameCommonLookup.js"></script>
	<script language="javascript" src="../js/OncologyRegimen.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("encounter_id");
	String patient_class			= request.getParameter("act_patient_class");
	String params					= request.getQueryString() ;
	String serialNum				= request.getParameter("serial_no") == null ? "":request.getParameter("serial_no");	
	String amend_serial_no          = request.getParameter("amend_serial_no") == null ? "":request.getParameter("amend_serial_no");
	String MAR_app_yn               = request.getParameter("MAR_app_yn") == null ? "":request.getParameter("MAR_app_yn");
	String fluid_frame_display_yn	= request.getParameter("fluid_frame_display_yn") == null ? "Y":request.getParameter("fluid_frame_display_yn");
	String start_date				= request.getParameter("start_date");
	
	String bean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name				= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean		= (OncologyRegimenBean)getBeanObject( bean_id, bean_name , request) ;
	//String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	//String or_bean_name				= "eOR.OrderEntryBean";
//	OrderEntryBean ORbean			= (OrderEntryBean)mh.getBeanObject( or_bean_id, request, or_bean_name ) ;
	String amend_fluid_code				= "";
	String amend_fluid_name				= "";
	String amend_stock_value			= "";
	String amend_stock_uom				= "";
	String amend_infusion_period_value	= "";
	String amend_infusion_period_uom	= "";
	String drug_code					= "";
	String iv_fluid_yn					= "";
    String iv_ingredient_yn				= "visibility:visible";
	String visibility					= "visibility:visible";
	String deflt_fluid_form_code		= "";
	String deflt_fluid_route_code       = "";
	String deflt_fluid_pres_base_uom    = "";
	String comp_freq_code				= "";
	String comp_durn_value				= "";
	String comp_durn_type				= "";
	String amend_yn						= "";
	String defaultfluidchanged          ="N";
	String remarks_visible				="visibility:hidden";
	String default_fluid_name           ="";
	String amend_stock_uom_code         ="";
	String order_catalog_code           ="";
	String catalog_desc                 =""; 
	//int    count                        =0;
	String chngd_fluid_remarks          ="";
	String disable_existing             ="";
	String mfr_display                  ="visibility:hidden"; //ML-MMOH-CRF-1014 - start
	String mfr_img_display              = "visible"; 
	HashMap mfr_recs                    = null; 
	String mfr_checked                  = "";
	String mfr_yn_value					= "";
	String ocurrance_num				= "";
	String default_stock_val			= "";
//ML-MMOH-CRF-1014 - end
//added for MMS-KH-SCF-0060 start
      String disabled="diabled";
      boolean enableFluidText				=bean.isSiteSpecific("PH", "ENABLE_FLUID_TEXT");//ADDED FOR MMS-KH-SCF-0060
    		  if(enableFluidText){
    			  disabled=""; 
    		  }
    		//added for MMS-KH-SCF-0060 end
	if(!serialNum.equals(""))
	{
		int srlNo						= 0;
		srlNo							= Integer.parseInt(serialNum);
		ArrayList drugList				= bean.getDrugDetails();
		if(drugList!=null)
		{
			HashMap drugDetails				= (HashMap)drugList.get(srlNo-1);
			
			drug_code						= (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
			iv_fluid_yn						= (String)drugDetails.get("IV_FLUID_YN")==null?"":(String)drugDetails.get("IV_FLUID_YN");
			iv_ingredient_yn				= (String)drugDetails.get("IV_INGREDIENT_YN")==null?"":(String)drugDetails.get("IV_INGREDIENT_YN");
			amend_fluid_code				= (String)drugDetails.get("amend_fluid_code")==null?"":(String)drugDetails.get("amend_fluid_code");
			amend_fluid_name				= (String)drugDetails.get("amend_fluid_name")==null?"":(String)drugDetails.get("amend_fluid_name");
			amend_stock_value				= (String)drugDetails.get("amend_stock_value")==null?"":(String)drugDetails.get("amend_stock_value");
			bean.setdrugCode(drug_code);//ML-MMOH-CRF-1014
			ocurrance_num			        = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");//ML-MMOH-CRF-1014		
			

			default_stock_val = (String)drugDetails.get("default_stock_val")==null?"":(String)drugDetails.get("default_stock_val");

			if(default_stock_val.equals(""))
			default_stock_val = amend_stock_value;
			
			amend_infusion_period_value		= (String)drugDetails.get("amend_infusion_period_value")==null?"":(String)drugDetails.get("amend_infusion_period_value");
			amend_infusion_period_uom		= (String)drugDetails.get("amend_infusion_period_uom")==null?"":(String)drugDetails.get("amend_infusion_period_uom");
			amend_stock_uom					= (String)drugDetails.get("amend_stock_uom")==null?"":(String)drugDetails.get("amend_stock_uom");

            amend_yn	    = (String)drugDetails.get("AMEND_YN"); 

			if( (iv_fluid_yn.equals("N"))&&(iv_ingredient_yn.equals("N"))||(iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("Y"))||(iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("N")))
	        {
				  visibility="visibility:hidden";
				  //flag      ="hide";
				 
	    	}
			else{
				if(amend_yn.equals("N")){
				  amend_fluid_code		= (String)drugDetails.get("DEFLT_FLUID_CODE")==null?"":(String)drugDetails.get("DEFLT_FLUID_CODE");
				  amend_fluid_name		= (String)drugDetails.get("DEFLT_FLUID_DESC")==null?"":(String)drugDetails.get("DEFLT_FLUID_DESC");
				  default_fluid_name=amend_fluid_name;
				  deflt_fluid_form_code	= (String)drugDetails.get("DEFLT_FLUID_FORM_CODE")==null?"":(String)drugDetails.get("DEFLT_FLUID_FORM_CODE");
				  deflt_fluid_route_code= (String)drugDetails.get("DEFLT_FLUID_ROUTE_CODE")==null?"":(String)drugDetails.get("DEFLT_FLUID_ROUTE_CODE");
				  deflt_fluid_pres_base_uom	= (String)drugDetails.get("DEFLT_FLUID_PRES_BASE_UOM")==null?"":(String)drugDetails.get("DEFLT_FLUID_PRES_BASE_UOM");
				}
				else if(amend_yn.equals("Y")){
                   defaultfluidchanged = (String)drugDetails.get("DefaultFluidchanged");
				   default_fluid_name		= (String)drugDetails.get("DEFLT_FLUID_DESC");
				   amend_stock_uom_code				= (String)drugDetails.get("amend_stock_uom_code");
				 }
			}
			if( (iv_fluid_yn.equals("N"))&&(iv_ingredient_yn.equals("N"))){
				fluid_frame_display_yn="N";
			}

			comp_freq_code		= (String)drugDetails.get("comp_freq_code");
			comp_durn_value	= (String)drugDetails.get("comp_durn_value");
			comp_durn_type		= (String)drugDetails.get("comp_durn_type");
			if(defaultfluidchanged.equals("Y")){
				remarks_visible="visibility:visible";
			}
		}		 
	}

	/*======================amend==========================================*/
		String order_id				= "";

		HashMap Existingrecord;
		String order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
       	String amend_search_yn		= "";
		if(order_type_flag.equals("Existing")) {
			amend_search_yn	= "DISABLED";
		}       
    if(fluid_frame_display_yn.equals("Y")){
		if(order_type_flag.equals("Existing")) {
		//	order_id=request.getParameter("order_id"); 		  
			ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();
			if(!amend_serial_no.equals("")){
				int srlNo					= 0;
				   
					srlNo					= Integer.parseInt(amend_serial_no)+1;
			
			//	if( srlNo <=(getExistingCYTORecords.size()-3)){
					if(!amend_serial_no.equals("")){         
						Existingrecord	        = (HashMap) getExistingCYTORecords.get(srlNo);
						iv_fluid_yn			    = (String)Existingrecord.get("IV_FLUID_YN");
						iv_ingredient_yn		= (String)Existingrecord.get("IV_INGREDIENT_YN");  
						amend_stock_value		= (String)Existingrecord.get("QTY_VALUE");
						amend_stock_uom			= (String)Existingrecord.get("QTY_UNIT");		  
						order_catalog_code      = (String)Existingrecord.get("ORDER_CATALOG_CODE");
						catalog_desc		    = (String)Existingrecord.get("CATALOG_DESC");
						chngd_fluid_remarks     = (String)Existingrecord.get("CHNGD_FLUID_REMARKS");
						order_id				= (String)Existingrecord.get("ORDER_ID");//ML-MMOH-CRF-1014 - start

						if(amend_yn.equals("N")){
							ArrayList getExsitorder =  bean.getExistingOncoIVRecords(order_id); 
						}
					    
						mfr_recs                = new HashMap();
						mfr_recs                = bean.getMFRRecs();
						if(mfr_recs != null && mfr_recs.size() > 0){
						      mfr_display       ="visibility:visible";
							  mfr_img_display   = "";
							  mfr_checked       ="checked";
							  //System.err.println("OncologyRegimenFluidDetail.jsp-----------mfr_recs----------271---->"+mfr_recs);
							  bean.setMFRRecs(mfr_recs);
						} // End//ML-MMOH-CRF-1014 - end

						if((iv_fluid_yn.equals("Y")&& iv_ingredient_yn.equals("N"))){				 
							amend_fluid_name=catalog_desc;
							amend_fluid_code=order_catalog_code;
						}
						else{
							amend_fluid_name="";
						}
					//	count++;
						if(!chngd_fluid_remarks.equals("")){
							remarks_visible="visibility:visible";
							bean.setDefaultFluidremarks(chngd_fluid_remarks);
						 
						}
						disable_existing="disabled";
					}
				//}
			}
		 }
	 }

	if(amend_yn.equals("Y")){ //ML-MMOH-CRF-1014 - start
          mfr_recs               = bean.getMFRRecs();
			if(mfr_recs != null && mfr_recs.size() > 0){
				mfr_display          = "visibility:visible";
				mfr_img_display      = ""; 
				  mfr_checked       ="checked";
			}
        }//ML-MMOH-CRF-1014 - end




/*====================================================================*/ 
	
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="oncologyRegimenFluidDetail" id="oncologyRegimenFluidDetail">
<%
	if(!visibility.equals("visibility:hidden")){
	
%>
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" style="<%=visibility%>">
	
	 
	
	<th colspan="5"><font style="font-size:9">
	<fmt:message key="ePH.FluidDetails.label" bundle="${ph_labels}"/></font></th>
	<tr >
		<td width="30%"  class="label">
		<fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/>&nbsp;
			<input type="hidden" name="fluid_code" id="fluid_code" value="<%=amend_fluid_code%>">
			<%
			amend_fluid_name=amend_fluid_name.replaceAll(" ","%20");
			amend_fluid_name=java.net.URLEncoder.encode(amend_fluid_name,"UTF-8");//added for REGRATION ISSUE
			amend_fluid_name=amend_fluid_name.replaceAll("%2520","%20");
			
			%>
			<input type="text" name="fluid_name" id="fluid_name" value="<%=amend_fluid_name%>" size="30" maxlength="40" onBlur="checkValidDrug('F', this.value,'<%=drug_code%>');" <%=disable_existing%> <%=amend_search_yn%> ><input type="button" class="button" name="fluid_search" id="fluid_search" VALUE="?" <%=disable_existing%>  onClick="searchIVFluid('D', fluid_name,'<%=drug_code%>');" <%=amend_search_yn%> >
			<img src="../../eCommon/images/mandatory.gif" border="0"></img>
<%			if(amend_fluid_code != null && !amend_fluid_code.equals("")){
%>
				<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails('<%=amend_fluid_code%>');"></img>
<%}			else{
%>
			<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails('<%=amend_fluid_code%>');"></img>
<%}%>
		</td>
        <td class="label" width="10%">
			<A HREF title='<fmt:message key="ePH.DfltFldaltrd.label" bundle="${ph_labels}"/>' onMouseOver="changeCursor(this);" onClick="fluidRemarks();" style="<%=remarks_visible%>" id='remarks'>
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>&nbsp;<img style="<%=remarks_visible%>" id="mandatory1" src="../../eCommon/images/mandatory.gif" ></img></td>

		<td width="20%" class="label" nowrap id="DfltVolume"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>&nbsp;
		
			<input type="hidden" name="stock_uom_code" id="stock_uom_code" value="">

<%
	if (bean.checkForStock()) {
//out.println("asdgajsdh----->  "+amend_stock_value+"  <---");
		
%>

			<input type="text" class="number" name="stock_value" id="stock_value" value="<%=amend_stock_value%>" size="2" maxlength="4"  <%=disabled%> >	<!-- disabled removed for MMS-KH-SCF-0060 -->	
			<label  width='5%'class='label' id="stock_uom"><%=amend_stock_uom%></label> 
			

<%
	}
	else {
%>

			<input type="text" class="number" name="stock_value" id="stock_value" value="<%=amend_stock_value%>" size="2" maxlength="4" >
			<select name="stock_uom" id="stock_uom" > 
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
			</select>
<%
	}
%>

			<img src="../../eCommon/images/mandatory.gif" border="0"></img>
		</td><!--ML-MMOH-CRF-1014 - start-->
		<td class="label" width="30%" id="MFR_YN"> 
		
<%
			boolean site_spec_mfr				= bean.isSiteSpecific("OR", "OR_ORDER_SET");//ML-MMOH-CRF-1014
			if(site_spec_mfr){
			if(!order_type_flag.equals("Existing") ){
%>			<input type="checkbox" name="MFR_YN_chk" id="MFR_YN_chk" onClick="assignMfrValueforOngo(this);" value=""  <%=mfr_checked%> >
			<a href="#"  title ='Multiple Flow Rate' onMouseOver="changeCursor(this);" onClick="javascript:showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','','<%=amend_fluid_code%>','<%=drug_code%>');" id='ongomfrLink'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/></a>

   <%		}else{
			if(mfr_img_display.equals("")){ %>
			<input type="checkbox" name="MFR_YN_chk" id="MFR_YN_chk" onClick="assignMfrValueforOngo(this);" value=""  <%=mfr_checked%> >
			<a href="#"  title ='Multiple Flow Rate' onMouseOver="changeCursor(this);" onClick="javascript:showMultipleFlowRate('<%=patient_id %>','<%=encounter_id %>','','<%=amend_fluid_code%>','<%=drug_code%>');" id='ongomfrLink'><fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/></a>

<%			}else{
%>			<input type="checkbox" name="MFR_YN_chk" id="MFR_YN_chk" onClick="" value="" >
			<fmt:message key="ePH.MultipleFlowRate.label" bundle="${common_labels}"/>	   
			   
	<%		}
			}
			}
System.err.println("mfr_img_display==269s=>"+mfr_img_display);
		 if(mfr_img_display.equals("")) 
			 mfr_yn_value ="Y";
		 else
			 mfr_yn_value ="N";


		System.err.println("mfr_yn_value==274=d>"+mfr_yn_value);
			   if(mfr_img_display.equals("")){%> 
			      	 <img src="../../eCommon/images/enabled.gif"  id='MFR_Indicator'>
					 
<%					}else{%>
					<img src="../../eCommon/images/disabled.gif"  id='MFR_Indicator'>
<%					     } %>

             <br> <label class="label" ><a href="#"  onMouseOver="changeCursor(this);" onClick="showMFRRemarks('<%=drug_code%>');"  id='mfrRemarksLink' style="<%=mfr_display%>" title='<fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.MFRRemarks.label" bundle="${ph_labels}"/></label></a></br>   <!--ML-MMOH-CRF-1014 and title added for 1014- end-->
		</td>
	</tr>
	
	</table>
<%
		}
	else{
%>
		<table cellpadding="1" cellspacing="1" width="100%" align="center" border="0" >	
		<tr height='40'><td class="label" colspan='5' >&nbsp;&nbsp;&nbsp;</td></tr>    
		</table>
<%
	}
%>
	<input type="hidden" name="def_inf_prd" id="def_inf_prd"	   value="">
	<input type="hidden" name="patient_class" id="patient_class"  value="<%= patient_class %>">
	<input type="hidden" name="bean_id" id="bean_id"		   value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name"	   value="<%= bean_name %>">
	<input type="hidden" name="patient_id" id="patient_id"	   value="<%= patient_id %>">
	<input type="hidden" name="encounter_id" id="encounter_id"   value="<%= encounter_id %>">
	<input type="hidden" name="order_type_code" id="order_type_code"value="">
	<input type="hidden" name="form_code" id="form_code"	   value="<%=deflt_fluid_form_code%>">
	<input type="hidden" name="route_code" id="route_code"     value="<%=deflt_fluid_route_code%>">
	<input type="hidden" name="base_uom" id="base_uom"       value="<%=deflt_fluid_pres_base_uom%>">
	<input type="hidden" name="drug_code" id="drug_code"      value="<%=drug_code%>">
	<input type="hidden" name="fluid_remarks" id="fluid_remarks"  value="0"	>
	<input type="hidden" name="params" id="params"         value="<%=params%>"	>
	<input type="hidden" name="serialNum" id="serialNum"      value="<%=serialNum%>">	
	<input type="hidden" name="infuseovervalue" id="infuseovervalue"value=""	>
	<input type="hidden" name="infuseoverdurntype" id="infuseoverdurntype" value="">		
	<input type="hidden" name="stock_uom_val" id="stock_uom_val" value="<%=amend_stock_uom_code%>">
	<input type="hidden" name="default_fluid_changed" id="default_fluid_changed" value="<%=defaultfluidchanged%>">
	<input type="hidden" name="default_fluid_name" id="default_fluid_name" value="<%=default_fluid_name%>">
    <input type="hidden" name="fluid_frame_display_yn" id="fluid_frame_display_yn"  value="<%=fluid_frame_display_yn%>">
	<input type="hidden" name="mfr_remarks" id="mfr_remarks" value=""><!--ML-MMOH-CRF-1014 -->
	<input type="hidden" name="default_stock_val" id="default_stock_val" value="<%=default_stock_val%>" ><!--ML-MMOH-CRF-1014 -->

	
	
	
</form>
</body>
 <% 
	if(fluid_frame_display_yn.equals("Y")){
		if(amend_yn.equals("N")){
%>
			<script>
				defaultIVFluid(<%=order_type_flag.equals("Existing")%>);
				if(document.oncologyRegimenFluidDetail.MFR_YN_chk!=undefined){
					document.oncologyRegimenFluidDetail.MFR_YN_chk.disabled = true;
					if(document.oncologyRegimenFluidDetail.ongomfrLink)
					document.oncologyRegimenFluidDetail.ongomfrLink.disabled=true;
				}

			</script>
<%
		}else{//ML-MMOH-CRF-1014
			if(amend_yn.equals("Y") && mfr_yn_value.equals("N")){
%>
		<script>
				if(document.oncologyRegimenFluidDetail.MFR_YN_chk!=undefined){
					document.oncologyRegimenFluidDetail.MFR_YN_chk.disabled = true;
				}
		</script>
<%			}
			}
	}

	if(mfr_yn_value.equals("Y") && !amend_yn.equals("Y")&& order_type_flag.equals("Existing")){ // ML-MMOH-CRF-1014-start
%>
<script>
	//alert("339");
getDefaultMFRvalue('<%=bean_id%>','<%=bean_name%>','<%=order_id%>','<%=drug_code%>','<%=ocurrance_num%>');	

</script>
<%}//ML-MMOH-CRF-1014 - end

   if(!serialNum.equals("")){
%>
		 <script>
			var infuseovervalue=document.oncologyRegimenFluidDetail.infuseovervalue.value;
			var  infuseoverdurntype=document.oncologyRegimenFluidDetail.infuseoverdurntype.value;
			var  stock_uom_val=document.oncologyRegimenFluidDetail.stock_uom_val.value;	
			
		parent.oncology_admin.location.href="../jsp/OncologyRegimenAdminDetail.jsp?<%=params%>"+"&serial_no="+'<%=serialNum%>'+"&comp_freq_code="+'<%=comp_freq_code%>'+"&comp_durn_value="+'<%=comp_durn_value%>'+"&comp_durn_type="+'<%=comp_durn_type%>'+"&start_date="+'<%=start_date%>'+"&fluid_frame_display_yn="+'<%=fluid_frame_display_yn%>'+"&infuseovervalue="+infuseovervalue+"&infuseoverdurntype="+infuseoverdurntype+"&stock_uom_val="+stock_uom_val+"&amend_serial_no="+'<%=amend_serial_no%>'+"&MAR_app_yn="+'<%=MAR_app_yn%>'+"&mfr_yn_value="+'<%=mfr_yn_value%>';//MFR added for CRF-1004
		  
		 </script>
<%
	 }
%>

</html>
<%
putObjectInBean(bean_id,bean,request);
%>

