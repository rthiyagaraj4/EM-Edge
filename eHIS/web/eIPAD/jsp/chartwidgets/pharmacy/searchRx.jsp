<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.NotesData"%>
<%@page import="eIPAD.HealthObjects.Notes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ePH.DrugSearchBean"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/eIPAD/css/iPadPharmaColumLayout.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" /> 
<%
String orderNature="A";
%>
<div id="OrdListHWrapper_<%=orderNature %>" style="position: relative; height:100%; width: 100%; overflow: hidden;" class="ordListHWrapper table">
    <div style="position:absolute; width: auto; height: 100%;" id="OrdItemscroller_<%=orderNature %>">
        <ul id="OrdListColWrap_<%=orderNature %>" class="ordListColWrap row" style="height: 100%; margin-top: 0px; padding-left: 0px;">
            <%
        PatContext patientContextInsit = (PatContext)session.getAttribute("PatientContext"); 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
		String rxSeachValue= request.getParameter("enterTypes");	
		String act_patient_class = request.getParameter("act_patient_class")==null?"IP":request.getParameter("act_patient_class");
		String bean_id 				= "@DrugSearchBean"+patientContextInsit.getPatientId()+patientContextInsit.getEncounterId();					
		String ivrxModeValue = request.getParameter("mode");
		String	bean_name			=	"ePH.DrugSearchBean";		
		DrugSearchBean bean = (DrugSearchBean)PersistenceHelper.getBeanObject(  bean_id, bean_name, request ) ;			
	    bean.setLanguageId(locale);	    
	    bean.setDrugSearchBy("C");
		bean.setPatientId(patientContextInsit.getPatientId());
		bean.setEncounterId(patientContextInsit.getEncounterId());
		bean.setGender(patientContextInsit.getGender());
		bean.setPriviligeDrugCheck("A");
		bean.setPatientClass(act_patient_class);	   
		Hashtable table = new Hashtable();
	    table.put("name", rxSeachValue);
	    table.put("priviligeCheck", "A");	    
	    table.put("code", "");
	    table.put("strength_value", "");
	    table.put("npb_drug", "D");	    
	    table.put("form_code", "");
	    table.put("route_code", "");
	    table.put("identity", "MedicationOrder");
	    table.put("in_formulary_yn","");
	    table.put("search_by","A");
	    table.put("order_type_code",""); 
	    table.put("strength_uom","");
	    table.put("drug_search_by","C"); 
	    table.put("res_by_service","N");
	    
	    bean.setMainCriteriaData(table);		
		String from="0";
		String to="1000";		
		String search_by		="A";
		String searchBasedOn="Drug";		
		String bl_install_yn= "Y";
		String disp_charge_dtl_in_drug_lkp_yn ="Y"; 
		String disp_price_type_in_drug_lkp="P";
		String priviligeCheck_fromSearch="A";
		String practitionerId =patientContextInsit.getClinicianId();
		String resp_id =patientContextInsit.getResponsibilityID();
		String drug_priv_appln_yn= bean.getDrugPrivilegeYN();
		ArrayList arrList = new ArrayList();		
		bean.setPriviligeDrugCheck(priviligeCheck_fromSearch);					
		bean.setSearchBy("A");	
		bean.setDrugOrFluid(ivrxModeValue);	
		arrList	=     (ArrayList)bean.searchBasedOnDataSelected(from, to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp, priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn);			
		String drug_code;
		String description;
		ArrayList stock_dtls	=	null;
		String trade_code; 
		String drug_class;
		String order_type_code;
		String consider_stock="A";		
		String patient_id=bean.getPatientId();
		String encounter_id=bean.getEncounterId();
		String trade_name;		
		String stock_yn="";
		String avl_qty;
		String store_desc;
		String store_code;
		String strEnableDisable="disabled";		
		order_type_code=bean.getOrderTypeCode();
		ArrayList stock_params	=	bean.validateForStock();
		if(stock_params.size() > 1) 
		{
		consider_stock					= (String)stock_params.get(0);
		disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
		disp_price_type_in_drug_lkp		= (String)stock_params.get(3);
		}							
	if(!rxSeachValue.equalsIgnoreCase(""))	{		
		if(arrList.size()!=1){
		for(int i=1;i<arrList.size();i++){	
	      String[] strArray=(String[])arrList.get(i);
							drug_code		= strArray[0];
							if(search_by.equals("G")) {
								description	=	strArray[8];
							}
							else {
								description	=	strArray[1];
							}							
							trade_code= strArray[10]==null?"":strArray[10];
							trade_name=java.net.URLEncoder.encode(strArray[11]);
							drug_class=strArray[21];
							
							stock_dtls		= bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
							avl_qty="0";
							if(stock_dtls!=null && stock_dtls.size() > 0) {
									stock_yn			=	(String)stock_dtls.get(0);
									avl_qty				=	(String)stock_dtls.get(1);
									store_desc			=	(String)stock_dtls.get(2)==null?"":(String)stock_dtls.get(2);
									if(store_desc.indexOf('|') != -1)
										store_desc = store_desc.substring(0,store_desc.indexOf('|'));
									if(strEnableDisable.equals(""))
										strEnableDisable	=	(String)stock_dtls.get(3);						
									store_code			=	(String)stock_dtls.get(4)==null?"":(String)stock_dtls.get(4);
								}
String id_drug= drug_code.replaceAll("[-+.^:,]","");						
String trad="T";
if(!trade_name.equalsIgnoreCase("")){	
	trad=trade_name;
}	
String id_trad= trad.replaceAll("[-+.^:,]","");	
String id_drugName_tradeName=id_drug+"_"+id_trad;
ArrayList stock_params_check	=	bean.validateForStock();
String allow_yn	=	(String)stock_params_check.get(1);
	%>
	<li>									
                    <div  id="<%=id_drugName_tradeName%>" data-currentid="<%=id_drugName_tradeName%>"  data-drugCodeUnique="<%=id_drug%>" data-drugName="<%=description%>" data-drugCode="<%=drug_code%>" data-tradeCodes="<%=trade_code%>" data-tradeName="<%=trade_name%>" data-Priority="R" data-OrderCatCode="PH" data-previligeGroupDrugOrdering_YN="<%=strArray[25]%>" data-diagnosis_found_yn="<%=strArray[20]%>" data-appl_for_age_grp_yn="<%=strArray[22]%>" data-in_formulary="<%=strArray[13]%>" data-drug_class="<%=strArray[21]%>" data-stock_yn="<%=stock_yn%>" data-allow_yn="<%=allow_yn%>" data-avl_qty="<%=avl_qty %>>" class="rxBuble rxBubleTable ordDraggable_<%=orderNature %>">
                        <div class="rxBubleRow">
                            <div class="rxBubleCellContent">
                                <div class="rxBubleLable">
                                    <%= description %>  <%=trade_name%>
                                </div>
                            </div>
                            <%
			if(Float.parseFloat(avl_qty)>0){%>
                                <div class="rxBubleCellIconInStock">
                                    <img src="${path}/eIPAD/images/Drag25x25.png">
                                </div>
                                <%}else{%>
                                    <div class="rxBubleCellIconOutStock">
                                        <img src="${path}/eIPAD/images/Drag25x25.png">
                                    </div>
                                    <%}%>
                        </div>
                    </div>
                </li>
                <%} 
				}else{
			
	%>                    <input type="hidden" id="no_record" value="no">
                    <%		}
}%>
        </ul>
    </div>
</div>
<script src="${path}/eIPAD/js/PharamaColumnLayout.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo.all.min.js"></script>
<%-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> --%>
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
           // assignOrdItemsHScroll_S();
           // dragAndDrop();
            $('#no_record').val("");
        }         	
	}); 
</script>
</html>

