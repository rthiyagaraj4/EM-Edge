<!DOCTYPE html>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="ePH.DrugSearchBean"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.NotesData"%>
<%@page import="eIPAD.HealthObjects.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ePH.DrugSearchBean"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<%@page import="eIPAD.chartsummary.encounterlist.request.EncounterListRequest"%>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<jsp:useBean id="CommonBean" class="eCommon.Common.CommonBean" scope="page" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPadPharmaColumLayout.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" /> 	
<%
String orderNature="A";
%>
<div id="OrdListHWrapper_<%=orderNature%>" style="position: relative; height:100%; width: 100%; overflow: hidden;" class="ordListHWrapper table">
		<div style="position:absolute; width: auto; height: 100%;" id="OrdItemscroller_<%=orderNature %>"> 	
<%
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String patient_id = patientContext.getPatientId();
String encounter_id	= patientContext.getEncounterId();
String patient_class = patientContext.getPatientClass();
String facility_id = patientContext.getFacilityId();
String locale = patientContext.getLocale();			
String bean_name				= "eOR.OrderEntryBean";
String bean_id				= "@orderentrybean"+patient_id+encounter_id;
String  order_dispaly_verticalYN		= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");		
OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
String order_type 			= "";
String activity_type 		= "";
String order_category 		= "PH";
String tick_sheet_id 		= request.getParameter("tick_sheet_id");
String section_code 		=request.getParameter("codeValue");
String function_from		= "";
String order_catalog_nature	= "";
String priv_applicability_yn= "Y"; 
String prev_group_title		= "";
String checkedAttribute 	= "";
String disabled				= "";
String care_set_order		= "";
String order_catalog_category = "";
String entryValue			= "";	
int display_records = 44;
String key					= (bean.getPatientId()+bean.getEncounterId());
if(!order_type.equals(""))	order_type = order_type.trim();
if(!order_category.equals(""))	order_category = order_category.trim();
if(!tick_sheet_id.equals(""))	tick_sheet_id = tick_sheet_id.trim();
if(!section_code.equals(""))	section_code = section_code.trim();
int i=0;int count = 0;
String amend_key	= "";
HashMap previousValues		= null;
HashMap amendPreviousValues = null;
Set setValues 				= null;
Iterator iterator			= null;
StringTokenizer stBillMsg	= null;
String measure_id			= "";
String contr_msr_panel_id = "";
String category				= "";
String group_title="";
String order_nature = "A";
String from_obj = null;
if("S".equals(order_nature)){
	from_obj = "resultHdrFrame";
	}else if("P".equals(order_nature)){
	from_obj = "resultListFrame";
	}else if("A".equals(order_nature)){
	from_obj = "resultDtlFrame";
}
String sqlQuery	= "";
String str	= "";
String orderSetVal = "";
String panelVal = "";
String individualVal  = "";
String frm1 = "" , frm2 = "" , frm3 = "";
ArrayList records= null;

sqlQuery  ="SELECT a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text,e.drug_class ,e.in_formulary_yn , (select Ph_Drug_Appl_For_Pat_age_grp(E.drug_code,?,?) from dual) appl_for_age_grp_yn,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code =ph_elig.term_code AND pr_diag.patient_id = ?),NULL, 'N','Y')) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = E.drug_code AND ph_elig.eff_status = 'E'),'Y') diagnosis_found_yn,or_get_priv_appl_yn (?,?,'OR',E.drug_code,?,b.order_type_code,'PH') priv_appl_yn FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d, ph_drug e, or_order_type f WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and a.order_catalog_code=e.drug_code and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!'))   AND b.order_type_code = NVL (?, b.order_type_code)  AND b.order_type_code=f.order_type_code AND f.order_category='PH' and f.freq_APPLICABLE_YN='Y'  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";

if(priv_applicability_yn.equalsIgnoreCase("Y")){
	sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
	sqlQuery = sqlQuery.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
}else if(priv_applicability_yn.equalsIgnoreCase("N")){
	sqlQuery = sqlQuery.replace("##FILTERCAT##","");
	sqlQuery = sqlQuery.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
}else{
	sqlQuery = sqlQuery.replace("##FILTERCAT##","");
	sqlQuery = sqlQuery.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
}
HashMap sqlMap = new HashMap();
//Include all the common parameters.
sqlMap.put( "sqlData",sqlQuery);
//Function Parameters
HashMap funcMap = new HashMap();

//Display Fields
ArrayList displayFields = new ArrayList();
displayFields.add("order_catalog_code");
displayFields.add("catalog_synonym");
displayFields.add("order_catalog_nature");
displayFields.add("discr_msr_panel_id");//3
displayFields.add("prompt_alert_yn");
displayFields.add("prompt_alert_msg");
displayFields.add("order_category");
displayFields.add("order_type_code");
displayFields.add("ord_auth_reqd_yn");//8
displayFields.add("contr_msr_panel_id");
displayFields.add("ord_spl_appr_reqd_yn");//10
displayFields.add("priv_yn");//11
displayFields.add("explanatory_text");//12
displayFields.add("drug_class");//13
displayFields.add("in_formulary_yn");//14
displayFields.add("appl_for_age_grp_yn");//15
displayFields.add("diagnosis_found_yn");//16
displayFields.add("priv_appl_yn");//17

ArrayList chkFields = new ArrayList();
	chkFields.add(bean.getPractitionerType());
	chkFields.add(bean.getLanguageId());
	chkFields.add(bean.getLoginFacilityId());
	chkFields.add(bean.getLocationType());
	chkFields.add(bean.getLocationCode());

if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N"))){
	chkFields.add(bean.getPractitionerId());
	chkFields.add(bean.getResponsibilityId());
	chkFields.add(bean.getAuthorisationOrOrderingYn("ORD"));
}
	chkFields.add(bean.checkForNull(bean.getDob(),""));
	chkFields.add(bean.checkForNull(bean.getSex(),""));
	chkFields.add(bean.checkForNull(bean.getPatientId(),""));
	
	chkFields.add(bean.getPractitionerId());
	chkFields.add(bean.getResponsibilityId());
	chkFields.add(bean.getPrivilegeApplicability());
	
	chkFields.add(bean.checkForNull(tick_sheet_id.trim(),""));
	chkFields.add(bean.checkForNull(section_code,""));

	chkFields.add(bean.getPatientClass());
	chkFields.add(bean.getPatientClass());
	chkFields.add(bean.checkForNull(bean.getSex(),""));
	chkFields.add(bean.checkForNull(bean.getDob(),""));
	chkFields.add(bean.getLoginFacilityId());
	chkFields.add(bean.checkForNull(bean.getEncounterId(),""));
	chkFields.add(bean.getPatientClass());
	chkFields.add(bean.getVisitAdmDate());
	chkFields.add(bean.checkForNull(bean.getDischargeDateTime(),""));
	chkFields.add(bean.getPractitionerType());
	
	if((bean.checkForNull(order_category.trim(),"")).equals("*A")){
		chkFields.add("");
	}else{
		chkFields.add(bean.checkForNull(order_category.trim(),""));
	}
	chkFields.add(bean.checkForNull(activity_type,""));
	chkFields.add(bean.checkForNull(order_type,""));
	if(priv_applicability_yn.equalsIgnoreCase("Y")){
		chkFields.add(bean.getPractitionerId());
		chkFields.add(bean.getResponsibilityId());
		chkFields.add(bean.getPrivilegeApplicability());
	}
			
	// Adding function related array list into the HashMap
	funcMap.put("displayFields",displayFields);
	funcMap.put("chkFields",chkFields);

	ArrayList TickSheetItems=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,display_records);
	records	 =new ArrayList();
	
	ArrayList stock_dtls	=	null;
	
	String avl_qty="0";
	String  store_desc="";
	String  stock_yn="";
	String allow_yn="";
	String DrugSearchbean_id 			= "@DrugSearchBean"+patient_id+encounter_id;
	String	DrugSearchbean_name			=	"ePH.DrugSearchBean";	
	DrugSearchBean DrugSearchbean = (DrugSearchBean)PersistenceHelper.getBeanObject(DrugSearchbean_id, DrugSearchbean_name, request ) ;
	ArrayList drug_dtls =	null;
	
	if(TickSheetItems!=null && TickSheetItems.size()>2)
	{%>
	<ul id="OrdListColWrap_<%=orderNature %>" class="ordListColWrap row" style="height: 100%; margin-top: 0px; padding-left: 0px;">
	<%
	for(int recCount=2; recCount<TickSheetItems.size(); recCount++)
		{
			records=(ArrayList) TickSheetItems.get(recCount);
			String drugType= (String) records.get(7);
			
			String id_drug=(String)records.get(0);
			id_drug= id_drug.replaceAll("[-+.^:,]",""); 
			String trade_name="";
			String description=(String)records.get(1);
			String drug_code=(String)records.get(0);
			String id_trad= drug_code.replaceAll("[-+.^:,]","");
			String id_drugName_tradeName=id_trad+"_"+"T";
			String trade_code="";
			String drug_class=(String)records.get(13);
			String in_formulary_yn=(String)records.get(14);
			String appl_for_age_grp_yn=(String)records.get(15);
			String diagnosis_found_yn=(String)records.get(16);
			String previligeGroupDrugOrdering_YN=(String)records.get(17);					
			drug_dtls	=	DrugSearchbean.getPreferredDrugDetails(id_drug);
			if(drug_dtls!=null && drug_dtls.size() > 0) 
			{				
				trade_code=	(String)drug_dtls.get(3);
				trade_name=	(String)drug_dtls.get(4);
			}			
			stock_dtls		= DrugSearchbean.checkStock(drug_code, trade_code, drug_class, "","","",patient_id,encounter_id);			
			avl_qty="0";
			stock_yn="";
			allow_yn="";
			if(stock_dtls!=null && stock_dtls.size() > 0)
			{
				 stock_yn	=	(String)stock_dtls.get(0);
				 avl_qty		=	(String)stock_dtls.get(1);
			}
			ArrayList stock_params_check	=	DrugSearchbean.validateForStock();
			allow_yn	=	(String)stock_params_check.get(1);
	%>
	<li>
		<div  id="<%=id_drugName_tradeName%>" data-currentid="<%=id_drugName_tradeName%>"  data-drugCodeUnique="<%=id_drug%>" 
		data-drugName="<%=description%>" data-drugCode="<%=drug_code%>" data-tradeCodes="<%=trade_code%>" data-tradeName="<%=trade_name%>" 		
		data-Priority="R" data-OrderCatCode="<%=order_category%>"		
		data-previligeGroupDrugOrdering_YN="<%=previligeGroupDrugOrdering_YN%>" data-diagnosis_found_yn="<%=diagnosis_found_yn%>" data-appl_for_age_grp_yn="<%=appl_for_age_grp_yn%>"		
		data-in_formulary="<%=in_formulary_yn%>"
		data-drug_class="<%=drug_class%>" data-stock_yn="<%=stock_yn%>" data-allow_yn="<%=allow_yn%>"
		class="rxBuble rxBubleTable ordDraggable_<%=orderNature %>">
			<div class="rxBubleRow">
				<div class="rxBubleCellContent">
					<div class="rxBubleLable"><%=description%>  <%=trade_name%></div>
				</div>
				<%
					if(Float.parseFloat(avl_qty)>0){%>
						<div class="rxBubleCellIconInStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}else{%>
						<div class="rxBubleCellIconOutStock"><img src="${path}/eIPAD/images/Drag25x25.png"></div>
					<%}%>
			</div>
		</div>
</li>
	<%}%>
	</ul>
	<%} else {%>
	
	<div id="noticksheetitemsMsg" data-no_records="true"  style="display: table;height: 100%;width: 100%;" >			
	    <div class="pharmEmptyData">No ticksheet items found</div>
	</div>
	<%}%>
	</div>
	</div>
	
<script src="${path}/eIPAD/js/PharamaColumnLayout.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo.all.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/kendo/kendo.common.min.css" />
<script>
    $(document).ready(function() {
        var checkForRec = $('#no_record').val();
        if (checkForRec != 'no') 
		{		
            var ordListColWrap = $('#' + "OrdListColWrap_A");
            var ordListColParent = ordListColWrap.parent();
           var ordListColItems1 = ordListColWrap.children();         
           onOriChange();
           //assignOrdItemsHScroll_S();
          // dragAndDrop();
            $('#no_record').val("");
        }    }); 
</script>
</html>

