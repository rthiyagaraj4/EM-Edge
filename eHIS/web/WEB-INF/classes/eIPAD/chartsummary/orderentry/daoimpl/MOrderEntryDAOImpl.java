/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.orderentry.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;




import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.orderentry.dao.MOrderEntryDAO;
import eIPAD.chartsummary.orderentry.healthobject.MOrderCatalogHO;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsSearchRequest;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogCountResponse;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eIPAD.chartsummary.orderentry.response.MOrderEntryCatalogTransItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eOR.OrderEntryBean;
import eOR.Common.OrRepository;

/**
 * @author SaraswathiR
 *
 */
public class MOrderEntryDAOImpl extends GenericDAOImpl implements MOrderEntryDAO {

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getTickSheetOrders(eIPAD.chartsummary.orderentry.request.OrderCatalogsTickSearchRequest)
	 */
	public MOrderCatalogListResponse getTickSheetOrders(MOrderCatalogsTickSearchRequest request, boolean ignorePH) {
		MOrderCatalogListResponse response = new MOrderCatalogListResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(request != null){
			PatContext rPatContext = request.getPatientContext();
			OrderEntryBean bean = request.getOrderEntryBean();
			if(rPatContext != null && bean != null){
				locale = bean.getLanguageId();
				String patientId = bean.getPatientId();
				String encounterId = bean.getEncounterId();
				String respId = bean.getResponsibilityId() == null ?"":bean.getResponsibilityId();		
				String facilityId = bean.getLoginFacilityId();
				String patientClass = bean.getPatientClass();	
				String practType = bean.getPractitionerType();
				
				String orderNature = request.getOrderNature()==null?"":request.getOrderNature();
				String activityType = ""; //this is not included in the search criteria for mobility, hence kept as empty
				String orderType = request.getOrderType()==null?"":request.getOrderType();
				String orderCategory = request.getOrderCategory()==null?"":request.getOrderCategory();
				String tickSheetId = request.getTickSheetId()==null?"":request.getTickSheetId();
				String sectionCode = request.getSectionCode()==null?"":request.getSectionCode();
				ArrayList<MOrderCatalogHO> orderCatalogList = new ArrayList<MOrderCatalogHO>();
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				/* Below query used from:  OrderEntryTickSheetPanelsResult.jsp 
				 * Note: When the query in this jsp changes please change the query in code
				 * */
				String orderListTickQuery = "SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text  FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and b.order_catalog_nature ='"+orderNature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
				
				//if PH orders are not to be listed
				String ignorePHOrdersCondition = "";
				if(ignorePH){
					ignorePHOrdersCondition = "  and b.order_category!='PH' and 'PH' not in (SELECT ORDER_CATEGORY FROM or_order_set_component where order_set_code = a.order_catalog_code) ";
				}
				
				
				try{
					
					String priv_applicability_yn = "Y"; // always Y since the Limit to My Applicable Catalogs checkbox is not present and is default checked
					if(priv_applicability_yn.equalsIgnoreCase("Y")){
						orderListTickQuery = orderListTickQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) " + ignorePHOrdersCondition);
						orderListTickQuery = orderListTickQuery.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
					}else if(priv_applicability_yn.equalsIgnoreCase("N")){
						orderListTickQuery = orderListTickQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
						orderListTickQuery = orderListTickQuery.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
					}else{
						orderListTickQuery = orderListTickQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
						orderListTickQuery = orderListTickQuery.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
					}
					
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(orderListTickQuery);
						int i=0;
						pstmt.setString(++i,bean.getPractitionerType() );//1
						pstmt.setString(++i,bean.getLanguageId());//2
						pstmt.setString(++i,bean.getLoginFacilityId());//3
						pstmt.setString(++i,bean.getLocationType());//4
						pstmt.setString(++i,bean.getLocationCode());//5
						if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N"))){
							pstmt.setString(++i,bean.getPractitionerId());//6
							pstmt.setString(++i,bean.getResponsibilityId());//7
							pstmt.setString(++i,bean.getAuthorisationOrOrderingYn("ORD"));//8
						}
						pstmt.setString(++i,tickSheetId);//9
						pstmt.setString(++i,sectionCode);//10
						pstmt.setString(++i,bean.getPatientClass());//11
						pstmt.setString(++i,bean.getPatientClass());//12
						pstmt.setString(++i,bean.checkForNull(bean.getSex(),""));//13
						pstmt.setString(++i,bean.checkForNull(bean.getDob(),""));//14
						pstmt.setString(++i,bean.getLoginFacilityId());//15
						pstmt.setString(++i,bean.checkForNull(bean.getEncounterId(),""));//16
						pstmt.setString(++i,bean.getPatientClass());//17
						pstmt.setString(++i,bean.getVisitAdmDate());//18
						pstmt.setString(++i,bean.checkForNull(bean.getDischargeDateTime(),""));//19
						pstmt.setString(++i,bean.getPractitionerType());//20	
						if((bean.checkForNull(orderCategory.trim(),"")).equals("*A")){
							pstmt.setString(++i,orderCategory);//21		
						}else{
							pstmt.setString(++i,bean.checkForNull(orderCategory.trim(),""));//22
						}
						pstmt.setString(++i,activityType);//23
						pstmt.setString(++i,orderType);//24
						if(priv_applicability_yn.equalsIgnoreCase("Y")){
							pstmt.setString(++i,bean.getPractitionerId());//25
							pstmt.setString(++i,bean.getResponsibilityId());//26
							pstmt.setString(++i,bean.getPrivilegeApplicability());//27
						}
						
						
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							String orderCatalogCode;
							String catalogSynonym;
							String catalogNature;
							String discrMsrPanelId;
							String promptAlertYn;
							String promptAlertMsg;
							String orderCat;
							String orderTypeCode;
							String ordAuthReqdYn;
							String contrMsrPanelId;
							String ordSplApprReqdYn;
							String privYn;
							String explanatoryText;
							while(rs.next()){
								
								MOrderCatalogHO orderCatalogHO = new MOrderCatalogHO();
								orderCatalogCode = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
								catalogSynonym = rs.getString("catalog_synonym")==null?"":rs.getString("catalog_synonym");
								catalogNature = rs.getString("order_catalog_nature")==null?"":rs.getString("order_catalog_nature"); //P - Profile/Panel S - Group/Order Sets A - Atomic/Induvidual
								discrMsrPanelId = rs.getString("discr_msr_panel_id")==null?"":rs.getString("discr_msr_panel_id");
								promptAlertYn = rs.getString("prompt_alert_yn")==null?"":rs.getString("prompt_alert_yn");
								promptAlertMsg = rs.getString("prompt_alert_msg")==null?"":rs.getString("prompt_alert_msg");
								orderCat = rs.getString("order_category")==null?"":rs.getString("order_category");
								orderTypeCode = rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
								ordAuthReqdYn = rs.getString("ord_auth_reqd_yn")==null?"":rs.getString("ord_auth_reqd_yn");
								contrMsrPanelId = rs.getString("contr_msr_panel_id")==null?"":rs.getString("contr_msr_panel_id");
								ordSplApprReqdYn = rs.getString("ord_spl_appr_reqd_yn")==null?"":rs.getString("ord_spl_appr_reqd_yn");
								privYn = rs.getString("priv_yn")==null?"":rs.getString("priv_yn");
								explanatoryText = rs.getString("explanatory_text")==null?"":rs.getString("explanatory_text");
								
								orderCatalogHO.setOrderCatalogCode(orderCatalogCode);
								orderCatalogHO.setCatalogSynonym(catalogSynonym);
								orderCatalogHO.setCatalogNature(catalogNature);
								orderCatalogHO.setDiscrMsrPanelId(discrMsrPanelId);
								orderCatalogHO.setPromptAlertYn(promptAlertYn);
								orderCatalogHO.setPromptAlertMsg(promptAlertMsg);
								orderCatalogHO.setOrderCategory(orderCat);
								orderCatalogHO.setOrderTypeCode(orderTypeCode);
								orderCatalogHO.setOrdAuthReqdYn(ordAuthReqdYn);
								orderCatalogHO.setContrMsrPanelId(contrMsrPanelId);
								orderCatalogHO.setOrdSplApprReqdYn(ordSplApprReqdYn);
								orderCatalogHO.setPrivYn(privYn);
								orderCatalogHO.setExplanatoryText(explanatoryText);
								
								
								//if order nature is S-OrderSet, then a special check is required if the orderset contains PH category orders
								//if the orderset contains PH orders, then the orderset catalog item is not added to the response list
								/*if(catalogNature.equals("S")){
									if(ignorePH){
										String orderSetCats = bean.getCareSetOrderTypes(orderCatalogCode);
										if(!orderSetCats.contains("'PH'")){
											orderCatalogList.add(orderCatalogHO);
										}
									}
									else{
										orderCatalogList.add(orderCatalogHO);
									}
								}else{
									orderCatalogList.add(orderCatalogHO);
								}*/
								orderCatalogList.add(orderCatalogHO);
							}
							response.setOrderCatalogList(orderCatalogList);
							if(orderCatalogList.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching ticksheet order catalog details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
					
				}
			}
			else 
			{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getOrdersBySearch(eIPAD.chartsummary.orderentry.request.OrderCatalogsSearchRequest)
	 */
	public MOrderCatalogListResponse getOrdersBySearch(MOrderCatalogsSearchRequest request, boolean ignorePH) {
	
		MOrderCatalogListResponse response = new MOrderCatalogListResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(request != null){
			PatContext rPatContext = request.getPatientContext();
			OrderEntryBean bean = request.getOrderEntryBean();
			if(rPatContext != null && bean != null){

				locale = bean.getLanguageId();
				String patientId = bean.getPatientId();
				String encounterId = bean.getEncounterId();
				String respId = bean.getResponsibilityId() == null ?"":bean.getResponsibilityId();		
				String facilityId = bean.getLoginFacilityId();
				String patientClass = bean.getPatientClass();	
				String practType = bean.getPractitionerType();
				
				String orderNature = request.getOrderNature()==null?"":request.getOrderNature();
				String searchText = request.getSearchText()==null?"":request.getSearchText();
				String activityType = ""; //this is not included in the search criteria for mobility, hence kept as empty
				String orderType = request.getOrderType()==null?"":request.getOrderType();
				String orderCategory = request.getOrderCategory()==null?"":request.getOrderCategory();
				ArrayList<MOrderCatalogHO> orderCatalogList = new ArrayList<MOrderCatalogHO>();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				String orderListSearchQuery = "";
				
				try{
					
					/* Below query and logic used from:  OrderEntryOrderSetResult.jsp 
					 * Note: When the query in this jsp changes please change the query in code
					 * */
					String discharge_adv_date_time = bean.getDischargeAdvDateTime(patientId,encounterId); 
					if(discharge_adv_date_time==null || discharge_adv_date_time.equals("")){
						orderListSearchQuery = "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
					}
					else{
						orderListSearchQuery = "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
					}
					String  medico_legal_yn = ""; //Need to check if there is any logic/db column for this value
					String callingFrom = "";//this variable is also maintained as in the OrderEntryTickSheetPanelsResult.jsp
					String restrict_by = "N";// this is always N and is applicable only for Pharmacy orders -- Restrict by Service checkbox
					String priv_applicability_yn = "Y"; // always Y since the Limit to My Applicable Catalogs checkbox is not present and is default checked
					
					String l_synonym_type = "";
					
					String[] deceasRecord  = bean.getDeceasedPatientYn(bean.getPatientId());
					
					
					//if PH orders are not to be listed
					String ignorePHOrdersCondition = "";
					if(ignorePH){
						ignorePHOrdersCondition = " and a.order_category!='PH' and 'PH' not in (SELECT ORDER_CATEGORY FROM or_order_set_component where order_set_code = a.order_catalog_code) ";
					}
					
					
					if("MO".equalsIgnoreCase(respId)){
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON1##","'"+respId+"'");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON2##","'"+callingFrom+"'");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON3##","'"+medico_legal_yn+"'");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON4##","'Y'");
					}else{
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON1##","null");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON2##","null");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON3##","null");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON4##","'"+(String)deceasRecord[0]+"'");
					}
					orderListSearchQuery = orderListSearchQuery.replace("##CATCODE##","");//if(restrict_by.equalsIgnoreCase("N"))
					if(priv_applicability_yn.equalsIgnoreCase("Y"))
					{
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)" + ignorePHOrdersCondition);
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERPRIV##"," , OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
					}
					else if(priv_applicability_yn.equalsIgnoreCase("N"))
					{
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERPRIV##",",  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
					}
					else
					{
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERPRIV##",", 'Y' priv_yn");
					}
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(orderListSearchQuery);
						int i=0;
						pstmt.setString(++i,facilityId);//1
						pstmt.setString(++i,patientId);//2
						pstmt.setString(++i,encounterId);//3
						pstmt.setString(++i,patientClass);//4
						pstmt.setString(++i,bean.getEpisodeID());//5
						pstmt.setString(++i,bean.getEpisodeVisitNum());//6
						if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
						{
							pstmt.setString(++i,bean.getPractitionerId());//7
							pstmt.setString(++i,bean.getResponsibilityId());//8
							pstmt.setString(++i,bean.getPrivilegeApplicability());//9
						}
						
						pstmt.setString(++i,locale);//10
						pstmt.setString(++i,locale);//11
						
						if ((practType.equalsIgnoreCase("AN"))||(practType.equalsIgnoreCase("PS"))||(practType.equalsIgnoreCase("DN"))||(practType.equalsIgnoreCase("MD"))||(practType.equalsIgnoreCase ("SG"))||(practType.equalsIgnoreCase("NS"))) 
						{
							l_synonym_type = "DC" ;
						}
						else if((practType.equalsIgnoreCase("RD"))||(practType.equalsIgnoreCase("PT"))) 
						{
				  			 l_synonym_type = "AD" ;
						}
						
						pstmt.setString(++i,l_synonym_type);//12
						pstmt.setString(++i,bean.getPractitionerType());//13
						pstmt.setString(++i,orderCategory);//14
						pstmt.setString(++i,orderNature);//15
						pstmt.setString(++i,"C"); //16 always contains is the criteria, starts with and ends with are not considered
						pstmt.setString(++i,"%"+searchText+"%");//17
						pstmt.setString(++i,searchText+"%");//18
						pstmt.setString(++i,"%"+searchText);//19
						pstmt.setString(++i,"C"); //20 always contains is the criteria, starts with and ends with are not considered
						pstmt.setString(++i,"%"+searchText+"%");//21
						pstmt.setString(++i,searchText+"%");//22
						pstmt.setString(++i,"%"+searchText);//23
						pstmt.setString(++i,bean.getPatientClass());//24
						pstmt.setString(++i,bean.getPatientClass());//25
						pstmt.setString(++i,bean.getSex());//26
						pstmt.setString(++i,bean.getDob());//27
						pstmt.setString(++i,bean.getLoginFacilityId());//28
						pstmt.setString(++i,bean.getEncounterId());//29
						pstmt.setString(++i,bean.getPatientClass());//30
						pstmt.setString(++i,bean.getVisitAdmDate());//31
						pstmt.setString(++i,bean.getDischargeDateTime());//32
						if(discharge_adv_date_time != "" && discharge_adv_date_time!=null) 
						{
							pstmt.setString(++i,discharge_adv_date_time); //33 DISCHARGE_ADVICE_DATE_TIME 
						}
						pstmt.setString(++i,bean.getPractitionerType()); //34
						pstmt.setString(++i,orderCategory); //35
						pstmt.setString(++i,bean.getLoginFacilityId()); //36
						pstmt.setString(++i,bean.getServiceCode()); //37
						pstmt.setString(++i,bean.getPractitionerId()); //38
						pstmt.setString(++i,bean.getLocationType()); //39
						pstmt.setString(++i,bean.getLocationCode()); //40
						pstmt.setString(++i,orderType); //41
						pstmt.setString(++i,activityType); //42
						pstmt.setString(++i,bean.getPractitionerId()); //43
						pstmt.setString(++i,bean.getResponsibilityId()); //44
						pstmt.setString(++i,bean.getPrivilegeApplicability()); //45
						
						
						
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							String orderCatalogCode;
							String catalogSynonym;
							String catalogNature;
							String discrMsrPanelId;
							String promptAlertYn;
							String promptAlertMsg;
							String orderCat;
							String orderTypeCode;
							String ordAuthReqdYn;
							String contrMsrPanelId;
							String ordSplApprReqdYn;
							//String privYn;
							String explanatoryText;
							while(rs.next()){
								
								MOrderCatalogHO orderCatalogHO = new MOrderCatalogHO();
								orderCatalogCode = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
								catalogSynonym = rs.getString("catalog_synonym")==null?"":rs.getString("catalog_synonym");
								catalogNature = rs.getString("Group_Name")==null?"":rs.getString("Group_Name");
								discrMsrPanelId = rs.getString("discr_msr_panel_id")==null?"":rs.getString("discr_msr_panel_id");
								promptAlertYn = rs.getString("prompt_alert_yn")==null?"":rs.getString("prompt_alert_yn");
								promptAlertMsg = rs.getString("prompt_alert_msg")==null?"":rs.getString("prompt_alert_msg");
								orderCat = rs.getString("order_category")==null?"":rs.getString("order_category");
								orderTypeCode = rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
								ordAuthReqdYn = rs.getString("ord_auth_reqd_yn")==null?"":rs.getString("ord_auth_reqd_yn");
								contrMsrPanelId = rs.getString("contr_msr_panel_id")==null?"":rs.getString("contr_msr_panel_id");
								ordSplApprReqdYn = rs.getString("ord_spl_appr_reqd_yn")==null?"":rs.getString("ord_spl_appr_reqd_yn");
								//privYn = rs.getString("priv_yn")==null?"":rs.getString("priv_yn");
								explanatoryText = rs.getString("explanatory_text")==null?"":rs.getString("explanatory_text");
								
								orderCatalogHO.setOrderCatalogCode(orderCatalogCode);
								orderCatalogHO.setCatalogSynonym(catalogSynonym);
								orderCatalogHO.setCatalogNature(catalogNature);
								orderCatalogHO.setDiscrMsrPanelId(discrMsrPanelId);
								orderCatalogHO.setPromptAlertYn(promptAlertYn);
								orderCatalogHO.setPromptAlertMsg(promptAlertMsg);
								orderCatalogHO.setOrderCategory(orderCat);
								orderCatalogHO.setOrderTypeCode(orderTypeCode);
								orderCatalogHO.setOrdAuthReqdYn(ordAuthReqdYn);
								orderCatalogHO.setContrMsrPanelId(contrMsrPanelId);
								orderCatalogHO.setOrdSplApprReqdYn(ordSplApprReqdYn);
								//orderCatalogHO.setPrivYn(privYn);
								orderCatalogHO.setExplanatoryText(explanatoryText);
								
								//if order nature is S-OrderSet, then a special check is required if the orderset contains PH category orders
								//if the orderset contains PH orders, then the orderset catalog item is not added to the response list
								/*if(catalogNature.equals("S")){
									if(ignorePH){
										String orderSetCats = bean.getCareSetOrderTypes(orderCatalogCode);
										if(orderSetCats!=null && !orderSetCats.contains("'PH'")){
											orderCatalogList.add(orderCatalogHO);
										}
									}
									else{
										orderCatalogList.add(orderCatalogHO);
									}
								}else{
									orderCatalogList.add(orderCatalogHO);
								}*/
								orderCatalogList.add(orderCatalogHO);
							}
							response.setOrderCatalogList(orderCatalogList);
							if(orderCatalogList.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching Order catalog details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
					
				}
			}
			else 
			{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getTickSheet(java.lang.String, boolean)
	 * public ArrayList getTickSheet(String order_category) in OrderEntryBean
	 */
	public MOrderEntryFieldResponse getTickSheetList(OrderEntryBean bean, String orderCategory, boolean ignorePH) {
		MOrderEntryFieldResponse fieldResponse = new MOrderEntryFieldResponse();
		if(bean!=null){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				con	= createConnection();
				StringBuffer tickListQuery = new StringBuffer("SELECT   tick_sheet_id, tick_sheet_desc tick_sheet_desc, order_category, seq_no   FROM or_tick_sheet_lang_vw a WHERE order_category = NVL (?, order_category) and language_id=?     AND eff_status = 'E' AND (indexed_yn = 'N' or (indexed_yn = 'Y' and exists (select 1 from or_tick_sheet_by_index where order_category=a.order_category	and tick_sheet_id=a.tick_sheet_id and ((index_type='P' and practitioner_id = ?)  or (index_type='S' and service_code = ?) or  (index_type='F' and facility_id = ?  AND DECODE (source_type, 'A', ?, source_type) = ? AND DECODE (source_code, '*ALL', ? , source_code) = ? ))))) ");
				if(ignorePH){
					tickListQuery.append(" and order_category !='PH' ");
				}
				tickListQuery.append(" ORDER BY seq_no ");
				pstmt = con.prepareStatement(tickListQuery.toString());
				pstmt.setString(1, bean.checkForNull(orderCategory,""));
				pstmt.setString(2, bean.getLanguageId());
				pstmt.setString(3, bean.getPractitionerId());
				pstmt.setString(4, bean.getServiceCode());
				pstmt.setString(5, bean.getLoginFacilityId());
				pstmt.setString(6, bean.getLocationType());
				pstmt.setString(7, bean.getLocationType());
				pstmt.setString(8, bean.getLocationCode());
				pstmt.setString(9, bean.getLocationCode());
				rs	= pstmt.executeQuery() ;
				if(rs != null)
				{
					while(rs.next())
					{
						MOrderEntryFieldItem fieldItem = new MOrderEntryFieldItem();
						String code = rs.getString("tick_sheet_id") == null?"":rs.getString("tick_sheet_id");
						String desc = rs.getString( "tick_sheet_desc") == null?"":rs.getString( "tick_sheet_desc");
						fieldItem.setCode(code);
						fieldItem.setDesc(desc);
						fieldResponse.getFieldItems().add(fieldItem);
					}
				}
			}catch(SQLException e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("A database exception occurred while fetching ticksheet details" +e);
				e.printStackTrace() ;
			}catch(Exception e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("An exception occurred while fetching ticksheet details" +e);
				e.printStackTrace() ;
			} finally {
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		return fieldResponse;
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getSectionsUnderTickSheet(eOR.OrderEntryBean, java.lang.String, boolean)
	 * replicates getSectionPopulate(String order_category,String tick_sheet_id,String order_type_code) from OrderEntryBean
	 */
	public MOrderEntryFieldResponse getSectionsUnderTickSheet(OrderEntryBean bean, String tickSheetId, boolean ignorePH) {
		
		MOrderEntryFieldResponse fieldResponse = new MOrderEntryFieldResponse();
		if(bean!=null){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				con	= createConnection();
				StringBuffer tickSectQuery = new StringBuffer("SELECT   section_code, section_desc    FROM or_tick_sheet_section_lang_vw a   WHERE language_id = ? AND tick_sheet_id = ? AND eff_status = 'E'  AND exists (select 1 from or_tick_sheet_item where order_category= a.order_category and tick_sheet_id =a.tick_sheet_id and section_code =a.section_code) ");
				if(ignorePH){
					tickSectQuery.append(" and order_category !='PH' ");
				}
				tickSectQuery.append(" ORDER BY section_seq_num ");
				pstmt = con.prepareStatement(tickSectQuery.toString());
				pstmt.setString(1, bean.getLanguageId());
				pstmt.setString(2, tickSheetId);
				rs	= pstmt.executeQuery() ;
				if(rs != null)
				{
					while(rs.next())
					{
						MOrderEntryFieldItem fieldItem = new MOrderEntryFieldItem();
						String code = rs.getString("section_code") == null?"":rs.getString("section_code");
						String desc = rs.getString( "section_desc") == null?"":rs.getString( "section_desc");
						fieldItem.setCode(code);
						fieldItem.setDesc(desc);
						fieldResponse.getFieldItems().add(fieldItem);
					}
				}
			}catch(SQLException e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("A database exception occurred while fetching ticksheet section details" +e);
				e.printStackTrace() ;
			}catch(Exception e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("An exception occurred while fetching ticksheet section details" +e);
				e.printStackTrace() ;
			} finally {
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		return fieldResponse;
		
		
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getAllOrderCategories(eOR.OrderEntryBean, boolean)
	 * replicates bean.getOrderCategory("ALL_ORDER");
	 */
	public MOrderEntryFieldResponse getAllOrderCategories(OrderEntryBean bean, boolean ignorePH) {
		
		MOrderEntryFieldResponse fieldResponse = new MOrderEntryFieldResponse();
		if(bean!=null){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				con	= createConnection();
				StringBuffer ordCatQuery = new StringBuffer("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? ");
				if(ignorePH){
					ordCatQuery.append(" and order_category !='PH' ");
				}
				ordCatQuery.append(" ORDER BY short_desc ");
				pstmt = con.prepareStatement(ordCatQuery.toString());
				pstmt.setString(1, bean.getLanguageId());
				rs	= pstmt.executeQuery() ;
				if(rs != null)
				{
					while(rs.next())
					{
						MOrderEntryFieldItem fieldItem = new MOrderEntryFieldItem();
						String code = rs.getString("order_category") == null?"":rs.getString("order_category");
						String desc = rs.getString( "short_desc") == null?"":rs.getString( "short_desc");
						fieldItem.setCode(code);
						fieldItem.setDesc(desc);
						fieldResponse.getFieldItems().add(fieldItem);
					}
				}
			}catch(SQLException e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("A database exception occurred while fetching order category details" +e);
				e.printStackTrace() ;
			}catch(Exception e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("An exception occurred while fetching ordercategory details" +e);
				e.printStackTrace() ;
			} finally {
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		return fieldResponse;
	}
	
	public MOrderEntryFieldResponse getAllOrderCategories(String locale, boolean ignorePH) {
		
		MOrderEntryFieldResponse fieldResponse = new MOrderEntryFieldResponse();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con	= createConnection();
			StringBuffer ordCatQuery = new StringBuffer("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? ");
			if(ignorePH){
				ordCatQuery.append(" and order_category !='PH' ");
			}
			ordCatQuery.append(" ORDER BY short_desc ");
			pstmt = con.prepareStatement(ordCatQuery.toString());
			pstmt.setString(1, locale);
			rs	= pstmt.executeQuery() ;
			if(rs != null)
			{
				while(rs.next())
				{
					MOrderEntryFieldItem fieldItem = new MOrderEntryFieldItem();
					String code = rs.getString("order_category") == null?"":rs.getString("order_category");
					String desc = rs.getString( "short_desc") == null?"":rs.getString( "short_desc");
					fieldItem.setCode(code);
					fieldItem.setDesc(desc);
					fieldResponse.getFieldItems().add(fieldItem);
				}
			}
		}catch(SQLException e)	{
			fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
			System.out.println("A database exception occurred while fetching order category details" +e);
			e.printStackTrace() ;
		}catch(Exception e)	{
			fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
			System.out.println("An exception occurred while fetching ordercategory details" +e);
			e.printStackTrace() ;
		} finally {
			int conCloseFailure = closeConnection(con,pstmt,rs);
		}
		return fieldResponse;
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getOrderTypesUnderCategory(eOR.OrderEntryBean, java.lang.String, boolean)
	 */
	public MOrderEntryFieldResponse getOrderTypesUnderCategory(OrderEntryBean bean, String orderCategory, boolean ignorePH) {
		MOrderEntryFieldResponse fieldResponse = new MOrderEntryFieldResponse();
		if(bean!=null){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				con	= createConnection();
				StringBuffer ordTypesQuery = new StringBuffer("SELECT order_type_code code, short_desc description FROM or_order_type_lang_vw WHERE language_id= ? and eff_status='E' AND order_category = ? ");
				if(ignorePH){
					ordTypesQuery.append(" and order_category !='PH' ");
				}
				ordTypesQuery.append(" ORDER BY 2 ");
				pstmt = con.prepareStatement(ordTypesQuery.toString());
				pstmt.setString(1, bean.getLanguageId());
				pstmt.setString(2, orderCategory);
				rs	= pstmt.executeQuery() ;
				if(rs != null)
				{
					while(rs.next())
					{
						MOrderEntryFieldItem fieldItem = new MOrderEntryFieldItem();
						String code = rs.getString("code") == null?"":rs.getString("code");
						String desc = rs.getString( "description") == null?"":rs.getString( "description");
						fieldItem.setCode(code);
						fieldItem.setDesc(desc);
						fieldResponse.getFieldItems().add(fieldItem);
					}
				}
			}catch(SQLException e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("A database exception occurred while fetching order type details" +e);
				e.printStackTrace() ;
			}catch(Exception e)	{
				fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
				System.out.println("An exception occurred while fetching order type details" +e);
				e.printStackTrace() ;
			} finally {
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		return fieldResponse;
	
	
	}
	
	public MOrderEntryFieldResponse getOrderTypesUnderCategory(String locale, String orderCategory, boolean ignorePH) {
		MOrderEntryFieldResponse fieldResponse = new MOrderEntryFieldResponse();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con	= createConnection();
			StringBuffer ordTypesQuery = new StringBuffer("SELECT order_type_code code, short_desc description FROM or_order_type_lang_vw WHERE language_id= ? and eff_status='E' AND order_category = ? ");
			if(ignorePH){
				ordTypesQuery.append(" and order_category !='PH' ");
			}
			ordTypesQuery.append(" ORDER BY 2 ");
			pstmt = con.prepareStatement(ordTypesQuery.toString());
			pstmt.setString(1, locale);
			pstmt.setString(2, orderCategory);
			rs	= pstmt.executeQuery() ;
			if(rs != null)
			{
				while(rs.next())
				{
					MOrderEntryFieldItem fieldItem = new MOrderEntryFieldItem();
					String code = rs.getString("code") == null?"":rs.getString("code");
					String desc = rs.getString( "description") == null?"":rs.getString( "description");
					fieldItem.setCode(code);
					fieldItem.setDesc(desc);
					fieldResponse.getFieldItems().add(fieldItem);
				}
			}
		}catch(SQLException e)	{
			fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
			System.out.println("A database exception occurred while fetching order type details" +e);
			e.printStackTrace() ;
		}catch(Exception e)	{
			fieldResponse.setResponseStatus(fieldResponse.FIELD_DATAFETCH_FAILURE);
			System.out.println("An exception occurred while fetching order type details" +e);
			e.printStackTrace() ;
		} finally {
			int conCloseFailure = closeConnection(con,pstmt,rs);
		}
		return fieldResponse;
	
	
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getTickSheetOrdersCount(eIPAD.chartsummary.orderentry.request.OrderCatalogsTickSearchRequest, boolean)
	 * This method is used to get the count of orders 
	 */
	public MOrderCatalogCountResponse getTickSheetOrdersCount(MOrderCatalogsTickSearchRequest request, boolean ignorePH) {

		MOrderCatalogCountResponse response = new MOrderCatalogCountResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(request != null){
			PatContext rPatContext = request.getPatientContext();
			OrderEntryBean bean = request.getOrderEntryBean();
			if(rPatContext != null && bean != null){
				locale = bean.getLanguageId();
				String patientId = bean.getPatientId();
				String encounterId = bean.getEncounterId();
				String respId = bean.getResponsibilityId() == null ?"":bean.getResponsibilityId();		
				String facilityId = bean.getLoginFacilityId();
				String patientClass = bean.getPatientClass();	
				String practType = bean.getPractitionerType();
				
				String orderNature = request.getOrderNature()==null?"":request.getOrderNature();
				String activityType = ""; //this is not included in the search criteria for mobility, hence kept as empty
				String orderType = request.getOrderType()==null?"":request.getOrderType();
				String orderCategory = request.getOrderCategory()==null?"":request.getOrderCategory();
				String tickSheetId = request.getTickSheetId()==null?"":request.getTickSheetId();
				String sectionCode = request.getSectionCode()==null?"":request.getSectionCode();
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				/* Below query used from:  OrderEntryTickSheetPanelsResult.jsp 
				 * Note: When the query in this jsp changes please change the query in code
				 * */
				String orderListTickQuery = "SELECT b.order_catalog_nature, count(order_catalog_nature) count FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## group by b.order_catalog_nature";
				
				//if PH orders are not to be listed
				String ignorePHOrdersCondition = "";
				if(ignorePH){
					ignorePHOrdersCondition = " and b.order_category!='PH' and 'PH' not in (SELECT ORDER_CATEGORY FROM or_order_set_component where order_set_code = a.order_catalog_code)";
				}
				
				String priv_applicability_yn = "Y"; // always Y since the Limit to My Applicable Catalogs checkbox is not present and is default checked
				if(priv_applicability_yn.equalsIgnoreCase("Y")){
					orderListTickQuery = orderListTickQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) " + ignorePHOrdersCondition);
				}else if(priv_applicability_yn.equalsIgnoreCase("N")){
					orderListTickQuery = orderListTickQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
				}else{
					orderListTickQuery = orderListTickQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
				}
				
				try{
					
					
					
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(orderListTickQuery);
						int i=0;
						pstmt.setString(++i,tickSheetId);//9
						pstmt.setString(++i,sectionCode);//10
						pstmt.setString(++i,bean.getPatientClass());//11
						pstmt.setString(++i,bean.getPatientClass());//12
						pstmt.setString(++i,bean.checkForNull(bean.getSex(),""));//13
						pstmt.setString(++i,bean.checkForNull(bean.getDob(),""));//14
						pstmt.setString(++i,bean.getLoginFacilityId());//15
						pstmt.setString(++i,bean.checkForNull(bean.getEncounterId(),""));//16
						pstmt.setString(++i,bean.getPatientClass());//17
						pstmt.setString(++i,bean.getVisitAdmDate());//18
						pstmt.setString(++i,bean.checkForNull(bean.getDischargeDateTime(),""));//19
						pstmt.setString(++i,bean.getPractitionerType());//20	
						if((bean.checkForNull(orderCategory.trim(),"")).equals("*A")){
							pstmt.setString(++i,orderCategory);//21		
						}else{
							pstmt.setString(++i,bean.checkForNull(orderCategory.trim(),""));//22
						}
						pstmt.setString(++i,activityType);//23
						pstmt.setString(++i,orderType);//24
						if(priv_applicability_yn.equalsIgnoreCase("Y")){
							pstmt.setString(++i,bean.getPractitionerId());//25
							pstmt.setString(++i,bean.getResponsibilityId());//26
							pstmt.setString(++i,bean.getPrivilegeApplicability());//27
						}
						
						
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							String catalogNature;
							int count;
							while(rs.next()){
								
								catalogNature = rs.getString("order_catalog_nature")==null?"":rs.getString("order_catalog_nature"); //P - Profile/Panel S - Group/Order Sets A - Atomic/Induvidual
								count = rs.getInt("count");
								
								
								
								if(catalogNature.equals("S")){
									response.setOrderSetCount(count);
								}
								if(catalogNature.equals("P")){
									response.setPanelCount(count);
								}
								if(catalogNature.equals("A")){
									response.setIndividualCount(count);
								}
								
							}
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching ticksheet order catalog details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
					
				}
			}
			else 
			{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	
	}

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.orderentry.dao.OrderEntryDAO#getOrdersBySearchCount(eIPAD.chartsummary.orderentry.request.OrderCatalogsSearchRequest, boolean)
	 */
	public MOrderCatalogCountResponse getOrdersBySearchCount(MOrderCatalogsSearchRequest request, boolean ignorePH) {

		
		MOrderCatalogCountResponse response = new MOrderCatalogCountResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(request != null){
			PatContext rPatContext = request.getPatientContext();
			OrderEntryBean bean = request.getOrderEntryBean();
			if(rPatContext != null && bean != null){

				locale = bean.getLanguageId();
				String patientId = bean.getPatientId();
				String encounterId = bean.getEncounterId();
				String respId = bean.getResponsibilityId() == null ?"":bean.getResponsibilityId();		
				String facilityId = bean.getLoginFacilityId();
				String patientClass = bean.getPatientClass();	
				String practType = bean.getPractitionerType();
				
				String orderNature = request.getOrderNature()==null?"":request.getOrderNature();
				String searchText = request.getSearchText()==null?"":request.getSearchText();
				String activityType = ""; //this is not included in the search criteria for mobility, hence kept as empty
				String orderType = request.getOrderType()==null?"":request.getOrderType();
				String orderCategory = request.getOrderCategory()==null?"":request.getOrderCategory();
				ArrayList<MOrderCatalogHO> orderCatalogList = new ArrayList<MOrderCatalogHO>();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				String orderListSearchQuery = "";
				
				try{
					
					/* Below query and logic used from:  OrderEntryOrderSetResult.jsp 
					 * Note: When the query in this jsp changes please change the query in code
					 * */
					String discharge_adv_date_time = bean.getDischargeAdvDateTime(patientId,encounterId); 
					if(discharge_adv_date_time==null || discharge_adv_date_time.equals("")){
						orderListSearchQuery = "SELECT  a.order_catalog_nature,count(order_catalog_nature) count FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## GROUP BY a.order_catalog_nature";
					}
					else{
						orderListSearchQuery = "SELECT  a.order_catalog_nature,count(order_catalog_nature) count FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## GROUP BY a.order_catalog_nature";
					}
					String  medico_legal_yn = ""; //Need to check if there is any logic/db column for this value
					String callingFrom = "";//this variable is also maintained as in the OrderEntryTickSheetPanelsResult.jsp
					String restrict_by = "N";// this is always N and is applicable only for Pharmacy orders -- Restrict by Service checkbox
					String priv_applicability_yn = "Y"; // always Y since the Limit to My Applicable Catalogs checkbox is not present and is default checked
					
					String l_synonym_type = "";
					
					String[] deceasRecord  = bean.getDeceasedPatientYn(bean.getPatientId());
					
					
					//if PH orders are not to be listed
					String ignorePHOrdersCondition = "";
					if(ignorePH){
						ignorePHOrdersCondition = " and a.order_category!='PH' and 'PH' not in (SELECT ORDER_CATEGORY FROM or_order_set_component where order_set_code = a.order_catalog_code) ";
					}
					
					
					if("MO".equalsIgnoreCase(respId)){
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON1##","'"+respId+"'");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON2##","'"+callingFrom+"'");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON3##","'"+medico_legal_yn+"'");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON4##","'Y'");
					}else{
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON1##","null");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON2##","null");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON3##","null");
						orderListSearchQuery = orderListSearchQuery.replace("##MODECEASEDCON4##","'"+(String)deceasRecord[0]+"'");
					}
					orderListSearchQuery = orderListSearchQuery.replace("##CATCODE##","");//if(restrict_by.equalsIgnoreCase("N"))
					if(priv_applicability_yn.equalsIgnoreCase("Y"))
					{
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)" + ignorePHOrdersCondition);
					}
					else if(priv_applicability_yn.equalsIgnoreCase("N"))
					{
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
					}
					else
					{
						orderListSearchQuery = orderListSearchQuery.replace("##FILTERCAT##","" + ignorePHOrdersCondition);
					}
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(orderListSearchQuery);
						int i=0;
						
						
						pstmt.setString(++i,locale);//10
						pstmt.setString(++i,locale);//11
						
						if ((practType.equalsIgnoreCase("AN"))||(practType.equalsIgnoreCase("PS"))||(practType.equalsIgnoreCase("DN"))||(practType.equalsIgnoreCase("MD"))||(practType.equalsIgnoreCase ("SG"))||(practType.equalsIgnoreCase("NS"))) 
						{
							l_synonym_type = "DC" ;
						}
						else if((practType.equalsIgnoreCase("RD"))||(practType.equalsIgnoreCase("PT"))) 
						{
				  			 l_synonym_type = "AD" ;
						}
						
						pstmt.setString(++i,l_synonym_type);//12
						pstmt.setString(++i,bean.getPractitionerType());//13
						pstmt.setString(++i,orderCategory);//14
						pstmt.setString(++i,orderNature);//15
						pstmt.setString(++i,"C"); //16 always contains is the criteria, starts with and ends with are not considered
						pstmt.setString(++i,"%"+searchText+"%");//17
						pstmt.setString(++i,searchText+"%");//18
						pstmt.setString(++i,"%"+searchText);//19
						pstmt.setString(++i,"C"); //20 always contains is the criteria, starts with and ends with are not considered
						pstmt.setString(++i,"%"+searchText+"%");//21
						pstmt.setString(++i,searchText+"%");//22
						pstmt.setString(++i,"%"+searchText);//23
						pstmt.setString(++i,bean.getPatientClass());//24
						pstmt.setString(++i,bean.getPatientClass());//25
						pstmt.setString(++i,bean.getSex());//26
						pstmt.setString(++i,bean.getDob());//27
						pstmt.setString(++i,bean.getLoginFacilityId());//28
						pstmt.setString(++i,bean.getEncounterId());//29
						pstmt.setString(++i,bean.getPatientClass());//30
						pstmt.setString(++i,bean.getVisitAdmDate());//31
						pstmt.setString(++i,bean.getDischargeDateTime());//32
						if(discharge_adv_date_time != "" && discharge_adv_date_time!=null) 
						{
							pstmt.setString(++i,discharge_adv_date_time); //33 DISCHARGE_ADVICE_DATE_TIME 
						}
						pstmt.setString(++i,bean.getPractitionerType()); //34
						pstmt.setString(++i,orderCategory); //35
						pstmt.setString(++i,bean.getLoginFacilityId()); //36
						pstmt.setString(++i,bean.getServiceCode()); //37
						pstmt.setString(++i,bean.getPractitionerId()); //38
						pstmt.setString(++i,bean.getLocationType()); //39
						pstmt.setString(++i,bean.getLocationCode()); //40
						pstmt.setString(++i,orderType); //41
						pstmt.setString(++i,activityType); //42
						pstmt.setString(++i,bean.getPractitionerId()); //43
						pstmt.setString(++i,bean.getResponsibilityId()); //44
						pstmt.setString(++i,bean.getPrivilegeApplicability()); //45
						
						
						
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							
							String catalogNature;
							int count;
							while(rs.next()){
								
								catalogNature = rs.getString("order_catalog_nature")==null?"":rs.getString("order_catalog_nature");
								count = rs.getInt("count");
								
								if(catalogNature.equals("S")){
									response.setOrderSetCount(count);
								}
								if(catalogNature.equals("P")){
									response.setPanelCount(count);
								}
								if(catalogNature.equals("A")){
									response.setIndividualCount(count);
								}
								
							}
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching Order catalog details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
					
				}
			}
			else 
			{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	
	}
	
	public ArrayList<MOrderEntryCatalogTransItem> validateSuspendedCheck(OrderEntryBean bean){

		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String labchk="";
		//boolean result 				= false;
		String status				= "N";
		HashMap hashValues = bean.getAllValues();
		ArrayList<MOrderEntryCatalogTransItem> validErrorList = new ArrayList<MOrderEntryCatalogTransItem>();
		int count_chk_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
	try{
			String sql					= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SUSPENDED_CHECK");
			connection			= bean.getConnection();
			cstmt 				= connection.prepareCall("{ "+sql+" }");
			for(int i=0;i<count_chk_records;i++)
			{
				MOrderEntryCatalogTransItem validErrorItem;
				labchk=bean.getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),bean.getLoginFacilityId());//added on 7/9/2007 for lb_instal_yn logic by uma
				//if(!result  && (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))changed on 7/9/2007 for lb_instal_yn logic by uma
				if((bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))
				{
					cstmt.clearParameters();
					cstmt.setString(1, bean.checkForNull((String)hashValues.get("performing_facility_id"+i),""));
					cstmt.setString(2, bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
					cstmt.registerOutParameter( 3,  Types.VARCHAR ) ;

					cstmt.execute();
                	status 		 = bean.checkForNull(cstmt.getString(3),"");
                   	if(status.equals("N") || status.equals("D"))
                	{
						//result   = true;   // Atleast one item is suspened it will come out.
                   		validErrorItem = new MOrderEntryCatalogTransItem();
                   		validErrorItem.setCatalogCode(bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
                   		validErrorItem.setCatalogDesc(bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
                   		validErrorItem.setErrorMessage("This Order is Suspended");
                   		validErrorList.add(validErrorItem);
						//hashValues.put("susp_message",bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
					}
				} //End of lb_instal_yn
			} // End of for Loop
		}catch ( Exception e )	{

			e.printStackTrace() ;
			
		} finally {
			try{
				bean.closeStatement( cstmt ) ;
				closeConnection(connection);
			}catch(Exception e){
				
			}
			
	   }

	/*if(result)	//If there are duplicate checks return it as false
		return false;
	else
		return true;*/
	return validErrorList;
		
	}
	public ArrayList<MOrderEntryCatalogTransItem> validateSamePanelDuplCheck(OrderEntryBean bean) {


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int dupl_count 				= 0;
		String short_desc			= "";//  
		String order_catalog_code = "";
		String sql					= "",  str			      = "";
		StringBuffer sb				= new StringBuffer();
		StringBuffer sbRadialogy	= new StringBuffer();
		String labchk="";
		int total_count				= 0;
		HashMap hashValues = bean.getAllValues();
		int count_chk_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		int amend_total_count = 0;
		ArrayList<MOrderEntryCatalogTransItem> validErrorList = new ArrayList<MOrderEntryCatalogTransItem>();
		MOrderEntryCatalogTransItem validErrorItem;
try{
		connection		= bean.getConnection();
		total_count		= count_chk_records + amend_total_count;
		if(total_count > 1)
		{
			for(int k=0;k<amend_total_count;k++)		// Amend Orders
			{

				labchk=bean.getmoduleRL((String)hashValues.get("amend_catalog_code"+k),(String)hashValues.get("amend_order_category"+k),(String)hashValues.get("amend_order_type"+k),bean.getLoginFacilityId());//added on 7/9/2007 instead of lb_instal_yn by uma
				//if( ( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+k),"").equalsIgnoreCase("LB")) ) )changed on 7/9/2007 for lb_instal_yn by uma
			if( ( (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (bean.checkForNull((String)hashValues.get("amend_order_category"+k),"").equalsIgnoreCase("LB")) ) )
				{
					if(!bean.checkForNull((String)hashValues.get("amend_catalog_code"+k),"").equals(""))
					{
						sb.append("'"+bean.checkForNull((String)hashValues.get("amend_catalog_code"+k),"")+ "',");
					}
				} // End of lb_instal_yn for Amend Orders
				else if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("amend_order_category"+k),"").equalsIgnoreCase("RD")) )
				{
					if(!bean.checkForNull((String)hashValues.get("amend_catalog_code"+k),"").equals(""))
					{
						sbRadialogy.append("'"+bean.checkForNull((String)hashValues.get("amend_catalog_code"+k),"")+ "',");
					}
				} // End of rd_install_yn
			}
				for(int i=0;i<count_chk_records;i++)	// For New Orders
			{
				labchk=bean.getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),bean.getLoginFacilityId());//added on 7/9/2007 for lb_instal_yn logic by uma
				//if( ( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"").equalsIgnoreCase("LB")) ) )changed on 7/9/2007 for lb_instal_yn logic by uma
			if( ( (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"").equalsIgnoreCase("LB")) ) )
				{
					if(!bean.checkForNull((String)hashValues.get("catalog_code"+i),"").equals(""))
					{
						sb.append("'"+bean.checkForNull((String)hashValues.get("catalog_code"+i),"")+ "',");
					}
				} // End of lb_instal_yn
				else if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"").equalsIgnoreCase("RD")) )
				{
					if(!bean.checkForNull((String)hashValues.get("catalog_code"+i),"").equals(""))
					{
						sbRadialogy.append("'"+bean.checkForNull((String)hashValues.get("catalog_code"+i),"")+ "',");
					}
				} // End of rd_install_yn
		    } // End of for
		 	str =  sb.toString();
			if(str.length() > 0) // FOR LAB
			{
				str 			= str.substring(0, str.length()-1);
				sql 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_SAME_PANEL_CHECK_VALIDATON");
				// Since could not setString in the In operator , find the ? place holder and replace it with the values
				int count 		= sql.lastIndexOf("?");
				// Pass the already build string (consisting the catalog_code, which is used in the place order screen)
				sql  			= sql.substring(0,count) + str.trim() + sql.substring(count+1)  ;
				pstmt			= connection.prepareStatement(sql);
				resultSet		= pstmt.executeQuery() ;
				while( resultSet != null && resultSet.next())    // check only the first record
				{   
					
			        dupl_count 	= resultSet.getInt("count");
					short_desc 	= ((String)resultSet.getString( "short_desc" )); // Take the last one for the display
					order_catalog_code = ((String)resultSet.getString( "test_code" )); 
					validErrorItem = new MOrderEntryCatalogTransItem();
					validErrorItem.setCatalogCode(order_catalog_code);
					validErrorItem.setCatalogDesc(short_desc);
					validErrorItem.setErrorMessage("Duplicate Orders exist in Panels");
					validErrorList.add(validErrorItem);
				} // End of if resultSet
				try{ // Close the statements
					bean.closeResultSet( resultSet ) ;
					bean.closeStatement( pstmt ) ;
				   }catch(Exception e){
						e.printStackTrace();
				   }
			} // End of str.length()
			if(dupl_count==0)
			{
				str	= "";
				str =  sbRadialogy.toString(); // For Radialogy
				if(str.length() > 0)
				{
					str 			= str.substring(0, str.length()-1);
					sql 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_SAME_PANEL_CHECK_VALIDATON");
					// Since could not setString in the In operator , find the ? place holder and replace it with the values
					int count 		= sql.lastIndexOf("?");
					// Pass the already build string (consisting the catalog_code, which is used in the place order screen)
					sql  			= sql.substring(0,count) + str.trim() + sql.substring(count+1)  ;
					pstmt			= connection.prepareStatement(sql);
					resultSet		= pstmt.executeQuery() ;
					while ( resultSet != null && resultSet.next())    // check only the first record
					{   
			    	    dupl_count 	= resultSet.getInt("count");
						short_desc 	= ((String)resultSet.getString( "short_desc" )); // Take the last one for the display
						order_catalog_code = ((String)resultSet.getString( "component_exam_code" )); 
						validErrorItem = new MOrderEntryCatalogTransItem();
						validErrorItem.setCatalogCode(order_catalog_code);
						validErrorItem.setCatalogDesc(short_desc);
						validErrorItem.setErrorMessage("Duplicate Orders exist in Panels");
						validErrorList.add(validErrorItem);
					} // End of if resultSet
				} // End of str.length()
			} // End of dupl_count
		} // End of count_chk_records > 1
	}catch ( Exception e )	{

		e.printStackTrace() ;
	} finally {
		try{
		bean.closeResultSet( resultSet ) ;
		bean.closeStatement( pstmt ) ;
		closeConnection(connection);
		}catch(Exception e){
			
		}
	}

	sb.setLength(0);  // Clearing the string buffer
	sbRadialogy.setLength(0); // Clearing the string buffer
	return validErrorList;

	}
	
	public  ArrayList<MOrderEntryCatalogTransItem> validatePanelDuplCheck(OrderEntryBean bean){


		Connection connection 		= null;
		PreparedStatement pstmt 	= null;  PreparedStatement pstmt_rd = null;
		ResultSet resultSet 		= null;
		boolean result 				= false;
		String labchk="";
		ArrayList DuplCheck			= new ArrayList();
		HashMap hashValues = bean.getAllValues();
		int count_chk_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		int amend_total_count = 0;
		ArrayList<MOrderEntryCatalogTransItem> validErrorList = new ArrayList<MOrderEntryCatalogTransItem>();
		MOrderEntryCatalogTransItem validErrorItem;
	try{
			connection				= bean.getConnection();
			pstmt					= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
			pstmt_rd				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));
			// Amend Orders
			for(int j=0;j<amend_total_count;j++)		// Amend Orders
			{
					labchk=bean.getmoduleRL((String)hashValues.get("amend_catalog_code"+j),(String)hashValues.get("amend_order_category"+j),(String)hashValues.get("amend_order_type"+j),bean.getLoginFacilityId());

				//if( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")))changed on 7/9/2007 for lb_instal_yn logic by uma
			if( (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&  (bean.checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P"))  && (bean.checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")))
				{	//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
					pstmt.setString(1, bean.checkForNull((String)hashValues.get("amend_catalog_code"+j),""));
					resultSet	= pstmt.executeQuery() ;
				}
				else if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) &&  (bean.checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) && (bean.checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )
				{	//pstmt_rd		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));
					pstmt_rd.setString(1, bean.checkForNull((String)hashValues.get("amend_catalog_code"+j),""));
					resultSet	= pstmt_rd.executeQuery() ;
				}
				//if( (( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) )changed on 7/9/2007 for lb_instal_yn logic by uma
				if( (( (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (bean.checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")) )  || ((bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )) && (bean.checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) )
				if ((    ((bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )) && (bean.checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) )
				{//pstmt.setString(1, checkForNull((String)hashValues.get("amend_catalog_code"+j),""));
					//resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )    // One record
					{
						while(resultSet.next())
						{
							DuplCheck.add((String)resultSet.getString( "order_catalog_code" )); //Add the codes to the arraylist
						} // End of while
					} // End of if resultSet
					} //End of lb_instal_yn || rd_install_yn
					bean.closeResultSet( resultSet ) ;
			} // End of for loop in Amend Orders

			for(int i=0;i<count_chk_records;i++)	// New Orders
			{
				labchk=bean.getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),bean.getLoginFacilityId());//added on 7/9/2007 for lb_instal_yn logic by uma
				//if( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))//changed on 7/9/2007 for lb_instal_yn by uma
			if(  (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&  (bean.checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))
				{	// Already pstmt created pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
					pstmt.setString(1, bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
					resultSet	= pstmt.executeQuery() ;
				}
				else if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) &&  (bean.checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
				{	// Already pstmt_rd created	 pstmt_rd		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));
					pstmt_rd.setString(1, bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
					resultSet	= pstmt_rd.executeQuery() ;
				}
				//if( (( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )changed on 7/9/2007 for lb_instal_yn logic by uma
				if( (( (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (bean.checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )
				{	//pstmt.setString(1, checkForNull((String)hashValues.get("catalog_code"+i),""));
					//resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )    // One record
					{
						while(resultSet.next())
						{
							DuplCheck.add((String)resultSet.getString( "order_catalog_code" )); //Add the codes to the arraylist
						} // End of while
					} // End of if resultSet
					} //End of lb_instal_yn || rd_install_yn
				bean.closeResultSet( resultSet ) ;
			} // End of for Loop
			if((count_chk_records > 0 || amend_total_count > 0) && DuplCheck!=null && DuplCheck.size() > 0)
			{
				/*for(int l=0;l<count_chk_records;l++) // For total records (Amend Orders)
				{
					if(!result)
					{
						// check if the code is present
						result	= (DuplCheck.contains( bean.checkForNull((String)hashValues.get("amend_catalog_code"+l),"")) ) ; // Returns true if it is present
						hashValues.put("dupl_message",bean.checkForNull((String)hashValues.get("amend_cat_desc"+l),""));
					}
				} // End of k --> count_chk_records;k++)
				if(!result)
				{*/
					for(int k=0;k<count_chk_records;k++) // For total records (New 	Orders)
					{
							// check if the code is present
							result	= (DuplCheck.contains( bean.checkForNull((String)hashValues.get("catalog_code"+k),"")) ) ; // Returns true if it is present
							if(result){
								validErrorItem = new MOrderEntryCatalogTransItem();
								validErrorItem.setCatalogCode(bean.checkForNull((String)hashValues.get("catalog_code"+k),""));
		                   		validErrorItem.setCatalogDesc(bean.checkForNull((String)hashValues.get("cat_desc"+k),""));
		                   		validErrorItem.setErrorMessage("Duplicate Panel Check");
		                   		validErrorList.add(validErrorItem);
							}
								//hashValues.put("dupl_message",bean.checkForNull((String)hashValues.get("cat_desc"+k),""));
					} // End of k --> count_chk_records;k++)
		  	 //}	 // End of if result
		   }	 // End of count_chk_records || amend_total_count
		}catch ( Exception e )	{

			e.printStackTrace() ;
		} finally {
			try{
				bean.closeResultSet( resultSet ) ;
				bean.closeStatement( pstmt ) ;
				bean.closeStatement( pstmt_rd ) ;
				closeConnection(connection);
				DuplCheck= null;
			}catch(Exception e){
				
			}
			
	   }
	 	return validErrorList;

	}
	
	public ArrayList<MOrderEntryCatalogTransItem> validateDuplCheck(OrderEntryBean bean){

		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		PreparedStatement pstmt 	= null;PreparedStatement pstmt_rd 	= null;
		ResultSet resultSet 		= null;
		String sql					= ""  , pat_id = "";
		String record[]				= null;
		String catalog_type		=	"";
		ArrayList multi_patient		= null;
		String labchk="";
		int count_alert				= 0;int count_error	= 0;
		int count_records			= 0;int count_patient = 1;  // By Default one patient
		ArrayList pat_catalogs = new ArrayList();
		int total_dupl_count_records = 0;
		int dup_cat_count = 0;
		HashMap hashValues = bean.getAllValues();
		int count_chk_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		int amend_total_count = 0;
		ArrayList<MOrderEntryCatalogTransItem> validErrorList = new ArrayList<MOrderEntryCatalogTransItem>();
		MOrderEntryCatalogTransItem validErrorItem;
		
		try
		{
			connection					= bean.getConnection();

			sql 						= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_CHECK_VALIDATON");
			cstmt 						= connection.prepareCall("{ CALL "+sql+" }");
			pstmt						= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
			pstmt_rd					= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));

	// For patient it has to be done
			multi_patient				= bean.getMultiPatientDetails();
			if(multi_patient!=null && multi_patient.size() > 0)
				count_patient				= multi_patient.size();
				pat_id						= bean.checkForNull((String)hashValues.get("patient_id"),"");
			for(int k=0; k<count_patient; k++)   // For the Patients (atleast one) Selected
			{
				if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
				{
					record					= (String[]) multi_patient.get(k);
					pat_id					= bean.checkForNull(record[0],""); //patient_id
					/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
					pat_catalogs.clear();
					dup_cat_count = 0;
					/*Ends Here*/
				}
				for(int i=0;i<count_chk_records;i++)
				{
					//p_test_date_time_behind= "";test_date_time_ahead	 = "";ordered_pract_behind   = "";
					//ordered_pract_ahead    = "";order_status_behind	 = "";order_status_ahead	 = "";
					//end_date_time_behind   = "";end_date_time_ahead    = "";
					//catalog_desc_ahead	 = "";catalog_desc_behind	 = "";
					String vb_status				 = ""; String va_status			 = "";
					if(bean.checkForNull((String)hashValues.get("chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y"))
					{
						if( (bean.checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("R") &&  bean.checkForNull((String)hashValues.get("routine_chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y"))  || (bean.checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("U") &&  bean.checkForNull((String)hashValues.get("urgent_chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y")) || (bean.checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("S") &&  bean.checkForNull((String)hashValues.get("stat_chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y")) )
						{
							//cstmt.setString(1, checkForNull((String)hashValues.get("patient_id"),""));
							cstmt.clearParameters();
							cstmt.setString(1, bean.checkForNull(pat_id,""));
							cstmt.setString(2, bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
							cstmt.setString(3, bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_action"+i),""));
							cstmt.setString(4, bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""));
							cstmt.setString(5, bean.checkForNull((String)hashValues.get("start_date_time"+i),"")); //if date is reqd. in query put as (to_date(?,"dd/mm/yyyy hh24:mi"))
							cstmt.setInt(6, Integer.parseInt(bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),"0")));
							cstmt.setString(7, bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),""));
							cstmt.setString(8, bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_action"+i),""));
							cstmt.setInt(9, Integer.parseInt(bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),"0")));
							cstmt.setString(10, bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""));
							cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 16,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;
							cstmt.setString( 23, bean.checkForNull((String)hashValues.get("activity_type"+i),""));
							cstmt.execute();
							//p_test_date_time_behind 	= cstmt.getString(11);
							vb_status 		  			= cstmt.getString(12);
							/*catalog_desc_behind  		= cstmt.getString(13);ordered_pract_behind  		= cstmt.getString(14);
							order_status_behind 		= cstmt.getString(15);end_date_time_behind 		= cstmt.getString(16);*/
							va_status 					= cstmt.getString(17);
							/*catalog_desc_ahead  		= cstmt.getString(18);ordered_pract_ahead 		= cstmt.getString(19);
							order_status_ahead   		= cstmt.getString(20);end_date_time_ahead  		= cstmt.getString(21);
							test_date_time_ahead		= cstmt.getString(22);*/
							// the above values r commented, no need to get from the procedure, can fire from the query and get it
							if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB"))
							{
								//hashValues.put("reject_dupl_catalog_code"+count_error,bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
								count_error++;
								catalog_type = "R";
							}
							else if(va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
							{
								count_alert++;
								catalog_type = "W";
							}
							else
							{
								catalog_type = "";
							}
							/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
							if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB")||va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
							{
								String catalog_codes = bean.checkForNull((String)hashValues.get("catalog_code"+i),"");
								//hashValues.put("dupl_catalog_code"+count_records, checkForNull((String)hashValues.get("catalog_code"+i),""));		
								catalog_codes = catalog_codes+"##"+catalog_type;
								if(multi_patient!=null && multi_patient.size() > 0)
								{
									if(catalog_codes!=null)
									{
										//hashValues.put(pat_id+dup_cat_count,catalog_codes);
										dup_cat_count++;
									}								
								}
								total_dupl_count_records++;
								validErrorItem = new MOrderEntryCatalogTransItem();
								validErrorItem.setCatalogCode(bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
								validErrorItem.setCatalogDesc(bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
								validErrorItem.setErrorMessage("This Order is a duplicate");
								validErrorList.add(validErrorItem);
								//hashValues.put("dupl_catalog_code"+total_dupl_count_records,bean.checkForNull((String)hashValues.get("catalog_code"+i),""));							
								//hashValues.put("dupl_catalog_desc"+total_dupl_count_records,bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
								//hashValues.put("va_status"+total_dupl_count_records, bean.checkForNull(va_status,"N"));
								//hashValues.put("vb_status"+total_dupl_count_records, bean.checkForNull(vb_status,"N"));
								//hashValues.put("patient_id"+total_dupl_count_records, bean.checkForNull(pat_id,""));
								//hashValues.put("activity_type"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("activity_type"+i),""));
								//hashValues.put("chk_for_dupl_behind_unit"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""));
								//hashValues.put("chk_for_dupl_behind_period"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),""));
								//hashValues.put("chk_for_dupl_ahead_unit"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""));
								//hashValues.put("chk_for_dupl_ahead_period"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),""));
								//hashValues.put("chk_for_dupl_status"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),""));
								//hashValues.put("check_for_dupl_level"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("check_for_dupl_level"+i),""));
								//hashValues.put("test_date_time"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("start_date_time"+i),""));
								/*hashValues.put("p_test_date_time_behind"+count_records,checkForNull(p_test_date_time_behind,""));
								hashValues.put("catalog_desc_behind"+count_records,checkForNull(catalog_desc_behind,""));
								hashValues.put("ordered_pract_behind"+count_records,checkForNull(ordered_pract_behind,""));
								hashValues.put("order_status_behind"+count_records,checkForNull(order_status_behind,""));
								hashValues.put("end_date_time_behind"+count_records,checkForNull(end_date_time_behind,""));
								hashValues.put("catalog_desc_ahead"+count_records,checkForNull(catalog_desc_ahead,""));
								hashValues.put("ordered_pract_ahead"+count_records,checkForNull(ordered_pract_ahead,""));
								hashValues.put("order_status_ahead"+count_records,checkForNull(order_status_ahead,""));
								hashValues.put("end_date_time_ahead"+count_records,checkForNull(end_date_time_ahead,""));
								hashValues.put("test_date_time_ahead"+count_records,checkForNull(test_date_time_ahead,""));
								*/
							}// End of if dupChk
							count_records++;
						} // End of if routine
					} // End of	chk_for_dupl_yn ="Y"
					labchk=bean.getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),bean.getLoginFacilityId());//added on 7/9/2007 instead of lb_instal_yn logic
					//if( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))changed on 7/9/2007 for lb_instal_yn logic by uma
					if( (bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&  (bean.checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))
					{
						pstmt.setString(1, bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
						resultSet	= pstmt.executeQuery() ;
					}
					else if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) &&  (bean.checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")))
					{
						pstmt_rd.setString(1, bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
						resultSet	= pstmt_rd.executeQuery() ;
					}
					//if( (( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )changed on 7/9/2007 for lb_instal_yn logic by uma
					if( (( ( bean.checkForNull(labchk,"").equalsIgnoreCase("IBARL"))  && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (bean.checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )
					{
						if (resultSet != null )
						{
							while(resultSet.next())
							{
								// Call the procedure that many times for the test code in panels for Lab || Rad.
								if(bean.checkForNull((String)resultSet.getString( "chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y"))
								{
									if( (bean.checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("R") && bean.checkForNull((String)resultSet.getString( "routine_chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y")) || (bean.checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("U") && bean.checkForNull((String)resultSet.getString( "urgent_chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y")) || (bean.checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("S") && bean.checkForNull((String)resultSet.getString( "stat_chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y")) )
									{
										//Already Declared outside the loop
										//sql 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_CHECK_VALIDATON");
										//cstmt 		= connection.prepareCall("{ CALL "+sql+" }");
										//cstmt.setString(1, checkForNull((String)hashValues.get("patient_id"),""));
										cstmt.clearParameters();
										cstmt.setString(1, bean.checkForNull(pat_id,""));
										cstmt.setString(2, bean.checkForNull((String)resultSet.getString( "order_catalog_code" ),""));
										cstmt.setString(3, bean.checkForNull((String)resultSet.getString("chk_for_dupl_behind_action"),""));
										cstmt.setString(4, bean.checkForNull((String)resultSet.getString("chk_for_dupl_behind_unit"),""));
										cstmt.setString(5, bean.checkForNull((String)hashValues.get("start_date_time"+i),"")); //if date is reqd. in query put as (to_date(?,"dd/mm/yyyy hh24:mi"))
										cstmt.setInt(6, Integer.parseInt(bean.checkForNull((String)resultSet.getString("chk_for_dupl_behind_period"),"0")));
										cstmt.setString(7, bean.checkForNull((String)resultSet.getString("chk_for_dupl_status"),""));
										cstmt.setString(8, bean.checkForNull((String)resultSet.getString("chk_for_dupl_behind_action"),""));
										cstmt.setInt(9, Integer.parseInt(bean.checkForNull((String)resultSet.getString("chk_for_dupl_ahead_period"),"0")));
										cstmt.setString(10, bean.checkForNull((String)resultSet.getString("chk_for_dupl_ahead_unit"),""));
										cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 16,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;
										//cstmt.setString( 23, checkForNull((String)resultSet.getString("activity_type"),""));
										cstmt.setString( 23, bean.checkForNull((String)hashValues.get("activity_type"+i),""));
										cstmt.execute();
										//p_test_date_time_behind 	= cstmt.getString(11);
										vb_status 		  			= cstmt.getString(12);
										/*catalog_desc_behind  		= cstmt.getString(13);ordered_pract_behind  		= cstmt.getString(14);
										order_status_behind 		= cstmt.getString(15);end_date_time_behind 		= cstmt.getString(16);*/
										va_status 					= cstmt.getString(17);
										/*catalog_desc_ahead  		= cstmt.getString(18);ordered_pract_ahead 		= cstmt.getString(19);
										order_status_ahead   		= cstmt.getString(20);end_date_time_ahead  		= cstmt.getString(21);
										test_date_time_ahead		= cstmt.getString(22);*/
										if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB"))
											count_error++;
										else if(va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
											count_alert++;									
										/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
										if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB")||va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
										{
											String catalog_codes = bean.checkForNull((String)hashValues.get("catalog_code"+i),"");
											//hashValues.put("dupl_catalog_code"+count_records, checkForNull((String)hashValues.get("catalog_code"+i),""));
											//hashValues.put("dupl_catalog_code"+count_records,catalog_codes);
											/*if(multi_patient!=null && multi_patient.size() > 0)
											{
												if(catalog_codes!=null)
												{
													hashValues.put(pat_id+dup_cat_count,catalog_codes);
													dup_cat_count++;
												}
											}*/
											total_dupl_count_records++;
											validErrorItem = new MOrderEntryCatalogTransItem();
											validErrorItem.setCatalogCode(bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
											validErrorItem.setCatalogDesc(bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
											validErrorItem.setErrorMessage("This Order is Suspended");
											validErrorList.add(validErrorItem);
										//}
										/*Ends Here*/
											//hashValues.put("va_status"+total_dupl_count_records,bean.checkForNull(va_status,"N"));
											//hashValues.put("vb_status"+total_dupl_count_records,bean.checkForNull(vb_status,"N"));
											//hashValues.put("patient_id"+total_dupl_count_records, bean.checkForNull(pat_id,""));
											//hashValues.put("activity_type"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("activity_type"+i),""));
											//hashValues.put("chk_for_dupl_behind_unit"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""));
											//hashValues.put("chk_for_dupl_behind_period"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),""));
											//hashValues.put("chk_for_dupl_ahead_unit"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""));
											//hashValues.put("chk_for_dupl_ahead_period"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),""));
											//hashValues.put("chk_for_dupl_status"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("chk_for_dupl_status"+i),""));
											//hashValues.put("check_for_dupl_level"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("check_for_dupl_level"+i),""));
											//hashValues.put("test_date_time"+total_dupl_count_records, bean.checkForNull((String)hashValues.get("start_date_time"+i),""));	
											/*hashValues.put("p_test_date_time_behind"+count_records,checkForNull(p_test_date_time_behind,""));
											hashValues.put("catalog_desc_behind"+count_records,checkForNull(catalog_desc_behind,""));
											hashValues.put("ordered_pract_behind"+count_records,checkForNull(ordered_pract_behind,""));
											hashValues.put("order_status_behind"+count_records,checkForNull(order_status_behind,""));
											hashValues.put("end_date_time_behind"+count_records,checkForNull(end_date_time_behind,""));
											hashValues.put("catalog_desc_ahead"+count_records,checkForNull(catalog_desc_ahead,""));
											hashValues.put("ordered_pract_ahead"+count_records,checkForNull(ordered_pract_ahead,""));
											hashValues.put("order_status_ahead"+count_records,checkForNull(order_status_ahead,""));
											hashValues.put("end_date_time_ahead"+count_records,checkForNull(end_date_time_ahead,""));
											hashValues.put("test_date_time_ahead"+count_records,checkForNull(test_date_time_ahead,"")); */
											count_records++;
										}// End of if dupChk
									}// End of if routine
								} // End of	chk_for_dupl_yn ="Y"
							} // End of while
						} // End of if resultSet
						bean.closeResultSet( resultSet ) ;
					} //End of lb_instal_yn || rd_install_yn
				} // End of for Loop
				/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
//				if(multi_patient!=null && multi_patient.size() > 0)
//				{
//					hashValues.put(pat_id,dup_cat_count);
//				}
				/*Ends Here*/
			} // End of patient for loop
			//hashValues.put("dupl_count_alert",String.valueOf(count_alert));
			//hashValues.put("dupl_count_error",String.valueOf(count_error));
			//hashValues.put("total_dupl_count_records",String.valueOf(total_dupl_count_records));
			/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
//			if(multi_patient!=null && multi_patient.size() > 0)
//				hashValues.put("called_from_multi", "MULTI_PATIENT_ORDERS");
//			else
//				hashValues.put("called_from_multi", "");
//			hashValues.put("count_patient", count_patient);
//			hashValues.put("count_chk_records", count_chk_records);
			/*Ends Here*/
		}
		catch ( Exception e )	
		{

			e.printStackTrace() ;
		} 
		finally 
		{
			try{
				bean.closeStatement( cstmt ) ;
				bean.closeResultSet( resultSet ) ;
				bean.closeStatement( pstmt ) ;
				bean.closeStatement( pstmt_rd ) ;
				closeConnection(connection);
			}catch(Exception e){
				
			}
	   }
		return validErrorList;
	
	}
	
	public ArrayList<MOrderEntryCatalogTransItem> validateExamConflicts(OrderEntryBean bean){

		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String status				= "", conflict_exam 	= "", conflict_exam_desc = "";
		String reason				= "", exam_date_value	 = "";
		String pat_id				= "", conflict_type		= "";
		
		int count_patient			= 1; // By Default one patient
		String record[]				= null;
		ArrayList multi_patient		= null;
		java.sql.Date exam_date		= null;
		java.text.SimpleDateFormat dtSystemFormat 		= new java.text.SimpleDateFormat("dd/MM/yyyy k:mm");
		int count_records			= 0; int  conflict_records = 0;
		HashMap hashValues = bean.getAllValues();
		int count_chk_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		int amend_total_count = 0;
		ArrayList<MOrderEntryCatalogTransItem> validErrorList = new ArrayList<MOrderEntryCatalogTransItem>();
		MOrderEntryCatalogTransItem validErrorItem;
		try{
			String sql					= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_EXAM_CONFLICT");
				connection				= bean.getConnection();
				cstmt 					= connection.prepareCall("{ "+sql+" }");

				multi_patient			= bean.getMultiPatientDetails();
				if(multi_patient!=null && multi_patient.size() > 0)
					count_patient		= multi_patient.size();
				pat_id					= bean.checkForNull((String)hashValues.get("patient_id"),"");
				for(int k=0; k<count_patient; k++)   // For the Patients (atleast one) Selected
				{
					if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
					{
						record			= (String[]) multi_patient.get(k);
						pat_id			= bean.checkForNull(record[0],""); //patient_id
					}
					for(int i=0;i<count_chk_records;i++)
					{
						if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
						{
							cstmt.clearParameters();
							cstmt.setString(1, bean.checkForNull((String)hashValues.get("contr_msr_panel_id"+i),""));
							cstmt.setString(2, bean.checkForNull(pat_id,""));
							cstmt.setString(3, bean.checkForNull((String)hashValues.get("start_date_time"+i),""));
							cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 7,  Types.DATE ) ;
							cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;

							cstmt.execute();
			            	status 		 		= bean.checkForNull(cstmt.getString(4),"");	//P_STAT
				        	conflict_exam 		= bean.checkForNull(cstmt.getString(5),"");	//P_CONFLICT_EXM
					    	conflict_exam_desc 	= bean.checkForNull(cstmt.getString(6),"");	//P_CONF_EXM_DESC
							exam_date 			= cstmt.getDate(7);  // Date9P_EXM_DONE)
                    		reason 				= bean.checkForNull(cstmt.getString(8),""); //Reason
							conflict_type		= bean.checkForNull(cstmt.getString(9),""); //Conflict Type
							if(exam_date!=null)
								exam_date_value	 = dtSystemFormat.format(exam_date);
 							if(!status.equals("") && !status.equals("N"))
							{
								if(!conflict_type.equals("S")) // if S, then should be stopped ortherwise can proceed
									conflict_records++;   // that logic will be taken care in the jsp
 							/*	hashValues.put("status"+count_records,bean.checkForNull(status,""));
								hashValues.put("conflict_exam"+count_records,bean.checkForNull(conflict_exam,""));
								hashValues.put("conflict_exam_desc"+count_records,bean.checkForNull(conflict_exam_desc,""));
								hashValues.put("conflict_exam_date"+count_records,exam_date_value);
								hashValues.put("conflict_reason"+count_records,reason);
 							 */
								validErrorItem = new MOrderEntryCatalogTransItem();
								validErrorItem.setCatalogCode(bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
								validErrorItem.setCatalogDesc(bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
								validErrorItem.setErrorMessage("Exam Conflicts Exists");
								validErrorList.add(validErrorItem);
								count_records++;
							}
						} //End of rd_install_yn
					} // End of for Loop i
				} // End of for loop k (pat)
				/*hashValues.put("total_dupl_count_records","");
				hashValues.put("conflict_exam_count_records",String.valueOf(count_records));
				hashValues.put("conflict_records",String.valueOf(conflict_records));*/
			}catch ( Exception e )	{

				e.printStackTrace() ;
			} finally {
				try{
					bean.closeStatement( cstmt ) ;
					closeConnection(connection);
				}catch(Exception e){
					
				}
		   }
	 	return validErrorList;
	
	}
	public ArrayList<MOrderEntryCatalogTransItem> validateAppointment(OrderEntryBean bean){

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;	PreparedStatement pstmt_rd_appt = null;
		ResultSet resultSet 		= null;
		//boolean result 			= false;
		boolean appt_reqd			= false;
		String  rd_appt				= "";
		int count_records			= 0;
		String record[]				= null;
		ArrayList multi_patient		= null;
		int count_patient			= 1; // By Default one patient
		String pat_id				= "";
		HashMap hashValues = bean.getAllValues();
		int count_chk_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		int amend_total_count = 0;
		ArrayList<MOrderEntryCatalogTransItem> validErrorList = new ArrayList<MOrderEntryCatalogTransItem>();
		MOrderEntryCatalogTransItem validErrorItem;
		try{
				connection			= bean.getConnection();
				multi_patient		= bean.getMultiPatientDetails();
				if(multi_patient!=null && multi_patient.size() > 0)
					count_patient	= multi_patient.size();
				pat_id				= bean.checkForNull((String)hashValues.get("patient_id"),"");
				for(int j=0;j<amend_total_count;j++)		// Amend Orders
				{
					if( (bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+j),"CS").equalsIgnoreCase("RD")) )
					{
						appt_reqd = true;
						break;  // If atleast one item has appt_reqd, then come out of the loop
					}
				} // End of for loop in Amend Orders
				if(!appt_reqd)
				{
					for(int i=0;i<count_chk_records;i++)	// New Orders
					{
						 if((bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("appt_reqd_yn"+i),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
						 {
							appt_reqd = true;
							break;  // If atleast one item has appt_reqd, then come out of 	the loop
						 }
			  	   }
		  	   } // End of if appt_reqd
			   if(appt_reqd)
			   {
				    pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_APPT_REQD"));
					pstmt_rd_appt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_APPT_DETAILS"));

					for(int k=0; k<count_patient; k++)   // For the Patients (atleast one) Selected
					{
						if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
						{
							record	= (String[]) multi_patient.get(k);
							pat_id	= bean.checkForNull(record[0],""); //patient_id
						}
						// Amend Orders
						pstmt.clearParameters();
		  				pstmt.setString(1, bean.checkForNull(pat_id,""));//pstmt.setString(1, checkForNull((String)hashValues.get("patient_id"),""));
						pstmt.setString(2, bean.checkForNull(pat_id,""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )    // One record
						{
							while(resultSet.next())
							{
								// Take the last one for the display
								rd_appt		= bean.checkForNull( ((String)resultSet.getString(1)), "");
							} // End of while
						} // End of if resultSet
						bean.closeResultSet( resultSet ) ;
						if(rd_appt.equals("X")) // Do the query to display all the records
						{
 							 pstmt_rd_appt.clearParameters();
							 pstmt_rd_appt.setString(1, bean.checkForNull(pat_id,""));
							 pstmt_rd_appt.setString(2, bean.checkForNull(pat_id,""));
							 resultSet		= pstmt_rd_appt.executeQuery() ;
							 if ( resultSet != null )
							 {
								while(resultSet.next())
								{
									hashValues.put("appt_module_id"+count_records, bean.checkForNull( ((String)resultSet.getString("module_id")), "") );
									hashValues.put("appt_facility_name"+count_records, bean.checkForNull( ((String)resultSet.getString("facility_name")), "") );
									hashValues.put("appt_ref_no"+count_records, bean.checkForNull( ((String)resultSet.getString("appt_ref_no")), "") );
									hashValues.put("appt_date"+count_records, bean.checkForNull( ((String)resultSet.getString("appt_date")), "") );
									hashValues.put("clinic_desc"+count_records, bean.checkForNull( ((String)resultSet.getString("clinic_desc")), "") );
									hashValues.put("appt_start_time"+count_records, bean.checkForNull( ((String)resultSet.getString("appt_start_time")), "") );
									hashValues.put("appt_end_time"+count_records, bean.checkForNull( ((String)resultSet.getString("appt_end_time")), "") );
									count_records++;
								} // End of while
							} // End of if resultSet
							 bean.closeResultSet( resultSet ) ;
						}  // End of rd_appt.equals("X")
					} // End of for k (Patient)
			   } // End of if appt_reqd
			   hashValues.put("appt_count_records",String.valueOf(count_records));
			}catch ( Exception e )	{

				e.printStackTrace() ;
			} finally {
				try{
					bean.closeResultSet( resultSet ) ;
					bean.closeStatement( pstmt ) ;
					bean.closeStatement( pstmt_rd_appt ) ;
					bean.closeConnection(connection);
				}
				catch(Exception e){
					
				}
		   }
		 	if(rd_appt.equals("X") && count_records>0)	//If there are Appointments for the Patient then display the modal window
		 	{
				/*hashValues.put("rd_appt", rd_appt );
				return false;*/
		 		for(int i=0;i<count_chk_records;i++)	// New Orders
				{
					 if((bean.checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("appt_reqd_yn"+i),"N").equalsIgnoreCase("Y")) && (bean.checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
					 {
						//appt_reqd = true;
						 validErrorItem = new MOrderEntryCatalogTransItem();
						 validErrorItem.setCatalogCode(bean.checkForNull((String)hashValues.get("catalog_code"+i),""));
						 validErrorItem.setCatalogDesc(bean.checkForNull((String)hashValues.get("cat_desc"+i),""));
						 validErrorItem.setErrorMessage("Appointment Conflicts");
						 validErrorList.add(validErrorItem);
					 }
		  	   }
		 		
			}
			return validErrorList;
	
	}

//	to get induvidual items under panel or orderset
//	http://cscindae751658:7001/eHIS/eOR/jsp/OrderEntryToolTip.jsp?measure_id=NCORDSET&contr_msr_panel_id=null&order_catalog_nature=S&category=LB&bean_id=@orderentrybeanMC0000014910088913&bean_name=eOR.OrderEntryBean&catalog_desc=Order%20set%20for%20Lab%20order&encounter_id=10088913&patient_class=IP&admission_date=03/12/2010%2016:18&discharge_date_time=&catalog_code=NCORDSET&pract_type=RD
//	ArrayList Panels				= OrderEntryQueryBean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,catalog_code,pract_type);


}
