<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.pharmacy.response.PharmFieldResponse"%>
<%@page import="eIPAD.chartsummary.pharmacy.healthobject.PharmFieldItem"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="ePH.PrescriptionBean_1"%>
<%@page import="com.google.gson.Gson"%> 
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page  import="java.sql.*,java.text.DecimalFormat, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*, com.ehis.util.* "  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
       <%	
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;		
		String bean_id				= (String) hash.get( "bean_id" );		
		String bean_name			= (String) hash.get( "bean_name" );		
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);		
		String locale = bean.getLanguageId();
		String presBean_id			= (String) hash.get( "presBean_id" )==null?"PrescriptionBean":(String) hash.get( "presBean_id" );
		String presBean_name		=  (String) hash.get( "presBean_name" )==null?"ePH.PrescriptionBean":(String) hash.get( "presBean_name" );				
		String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
		String bean_name_IVWA	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);		
		String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
		String bean_name_IVPB	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);		
		String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
		String bean_name_IVD	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
		PrescriptionBean presBean 	= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id,presBean_name,request);
		
		String  iv_bean_id			= "@IVPrescriptionBean_CRX"+patientContext.getPatientId() + patientContext.getEncounterId();
		String  iv_bean_name			= "ePH.IVPrescriptionBean";
		 IVPrescriptionBean bean_CRX	= (IVPrescriptionBean)PersistenceHelper.getBeanObject( iv_bean_id,iv_bean_name, request) ;
			
		
		
		
		if(func_mode != null && func_mode.equals("TRANSACTION" )){								
				boolean result=false;
				String invalidCode = "";
				String message="";
				String flag="";
				try {
				if(bean.getpresDetails()!=null && bean.getpresDetails().size()>0)
				{
				PhAdapter beanObj = (PhAdapter)PersistenceHelper.getBeanObject( bean_id,bean_name,request ) ;
				hash.remove( "bean_id" ) ;
				hash.remove( "bean_name" );
				beanObj.setAll(hash) ;	
				HashMap map = beanObj.validate() ;
				boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
				String validationMessage = (String) map.get( "message" ) ;
				
				if ( validated ) {
					map = beanObj.apply() ;						
					boolean rxresult = ((Boolean) map.get( "result" )).booleanValue() ;
					result=rxresult;
					if(rxresult)
					{											
					}
					 message = (String) map.get( "message" );
					flag = (String) map.get( "flag" );					
					if(map.get("invalidCode") != null)
						invalidCode = (String) map.get( "invalidCode" ) ;					
				}
				}
				
				//IVWOA Start	
				if(bean_IVWA.getAllFluids()!=null && bean_IVWA.getAllFluids().size()>0)
				{				
					String  order_id1="";
					String  from_order_id="";
					HashMap record = new HashMap();
					ArrayList newAllFluids = new ArrayList();	
					String buildMAR_yn = bean_IVWA.getBuildMAR_yn();
					if(buildMAR_yn.equals(""))
						bean_IVWA.setBuildMAR_yn("N");					
					String allergic_yn = bean_IVWA.getAllergic();
					if(allergic_yn.equals(""))
						bean_IVWA.setAllergic("N");
					allergic_yn = bean_IVWA.getAllergic();					
					ArrayList AllFluids = bean_IVWA.getAllFluids();
					for(int j=0; j<AllFluids.size(); j++){
						record = (HashMap) AllFluids.get(j);
						bean_IVWA.setOrderID();
						order_id1 = (String)bean_IVWA.getOrderID();
						record.put("ORDER_ID",order_id1);
						newAllFluids.add(record);
						if(from_order_id.equals(""))
							from_order_id = order_id1;
					}
					bean_IVWA.setOrderID(order_id1);
					bean_IVWA.setOrderId1(from_order_id);
					bean_IVWA.setAllFluids( newAllFluids);					
					HashMap returndata	=	bean_IVWA.ivFluidsInsert();
					String print_ord_sht_rule_ind=bean_IVWA.getPrintOrdShtRuleInd();
					boolean IVWOAresult	= ((Boolean)returndata.get("result")).booleanValue();
					result=IVWOAresult;
					message	= (String)returndata.get("message");
					flag		= (String)returndata.get("flag");
					
					invalidCode = (String) returndata.get( "invalidCode" ) ;
					if(message==null) message		=	"";
					if(flag==null) flag				=	"";
					if(IVWOAresult)
					{
					}
				}
				//IVWOA END				
				if(bean_IVPB.getAllFluids()!=null && bean_IVPB.getDrugDetails().size()>0) {					
					ArrayList drugList	= bean_IVPB.getDrugDetails();
					HashMap fluid_details = bean_IVPB.getFluidDetails();
					fluid_details.put("IV_PREP_YN","3");
					for(int i=0;i<drugList.size();i++) {
						HashMap drugDetails = (HashMap)drugList.get(i);						
						hash.put("DURN_VALUE",drugDetails.get("DURN_VALUE")==null?"":drugDetails.get("DURN_VALUE"));
						hash.put("DURN_UNIT",drugDetails.get("DURN_TYPE")==null?"":drugDetails.get("DURN_TYPE"));
						hash.put("infusion_time",drugDetails.get("infusion_time")==null?"":drugDetails.get("infusion_time"));
						hash.put("INFUSION_PERIOD_VALUE",drugDetails.get("INFUSION_PERIOD_VALUE")==null?"":drugDetails.get("INFUSION_PERIOD_VALUE"));
						hash.put("INFUSION_PERIOD_VALUE_MIN",drugDetails.get("INFUSION_PERIOD_VALUE_MIN")==null?"":drugDetails.get("INFUSION_PERIOD_VALUE_MIN"));
						hash.put("FREQUENCY",drugDetails.get("FREQ_CODE")==null?"":drugDetails.get("FREQ_CODE"));
						hash.put("FREQ_CODE",drugDetails.get("FREQ_CODE")==null?"":drugDetails.get("FREQ_CODE"));
						hash.put("START_DATE",drugDetails.get("START_DATE")==null?"":drugDetails.get("START_DATE"));
						hash.put("END_DATE",drugDetails.get("END_DATE")==null?"":drugDetails.get("END_DATE"));
						hash.put("INFUSION_PERIOD_UOM",drugDetails.get("INFUSION_PERIOD_UOM")==null?"":drugDetails.get("INFUSION_PERIOD_UOM"));
						hash.put("INFUSION_UOM",drugDetails.get("INFUSION_UOM")==null?"":drugDetails.get("INFUSION_UOM"));
						hash.put("STOCK_VALUE",drugDetails.get("STOCK_VALUE")==null?"0":drugDetails.get("STOCK_VALUE"));
					    hash.put("FLUID_UNIT_QTY",drugDetails.get("FLUID_UNIT_QTY")==null?"0":drugDetails.get("FLUID_UNIT_QTY"));
					    hash.put("PACK_SIZE",drugDetails.get("FLUID_UNIT_QTY")==null?"0":drugDetails.get("FLUID_UNIT_QTY"));
						hash.put("EQVL_UOM_CODE",drugDetails.get("EQVL_UOM_CODE")==null?"":drugDetails.get("EQVL_UOM_CODE"));
						hash.put("STOCK_UOM_CODE",drugDetails.get("STOCK_UOM_CODE")==null?"":drugDetails.get("STOCK_UOM_CODE"));
						hash.put("repeat_value",drugDetails.get("repeat_value")==null?"":drugDetails.get("repeat_value"));
						hash.put("calcualted_durn_value",drugDetails.get("calcualted_durn_value")==null?"":drugDetails.get("calcualted_durn_value"));
						hash.put("infusion_over_insert_value",bean_IVPB.getINFUSE_OVER());
						hash.put("interval_value",drugDetails.get("interval_value")==null?"":drugDetails.get("interval_value"));
						hash.put("freq_nature",drugDetails.get("freq_nature")==null?"":drugDetails.get("freq_nature"));
						hash.put("repeat_durn_type",drugDetails.get("repeat_durn_type")==null?"":drugDetails.get("repeat_durn_type"));
						hash.put("iv_calc_infuse_by",drugDetails.get("iv_calc_infuse_by")==null?"":drugDetails.get("iv_calc_infuse_by"));
						hash.put("vehicle",drugDetails.get("vehicle")==null?"":drugDetails.get("vehicle"));
						hash.put("vehicle_code",drugDetails.get("vehicle_code")==null?"":drugDetails.get("vehicle_code"));
						hash.put("volume",drugDetails.get("volume")==null?"":drugDetails.get("volume"));
						hash.put("volume_unit",drugDetails.get("volume_unit")==null?"":drugDetails.get("volume_unit"));
						hash.put("ORDER_TYPE_CODE",drugDetails.get("ORDER_TYPE_CODE")==null?"":drugDetails.get("ORDER_TYPE_CODE"));
						hash.put("IV_PRESC_YN","Y");
						hash.put("IV_PREP_YN","3");
						hash.put("buildMAR_yn",fluid_details.get("BUILD_MAR_YN")==null?"":fluid_details.get("BUILD_MAR_YN"));
						hash.put("calc_dose_value",drugDetails.get("CALC_DOSE_VALUE")==null?"":drugDetails.get("CALC_DOSE_VALUE"));
						hash.put("INFUSION_VALUE",(bean_IVPB.getINFUSION_RATE().equals("")||bean_IVPB.getINFUSION_RATE()==null)?"0":bean_IVPB.getINFUSION_RATE());
						hash.put("SCH_INFUSION_RATE",(bean_IVPB.getINFUSION_RATE().equals("")||bean_IVPB.getINFUSION_RATE()==null)?"0":bean_IVPB.getINFUSION_RATE());
						hash.put("drug_code",drugDetails.get("DRUG_CODE")==null?"":drugDetails.get("DRUG_CODE"));
						hash.put("dose_remarks",drugDetails.get("DOSE_REMARKS")==null?"":drugDetails.get("DOSE_REMARKS"));
						hash.put("currentrx_remarks",drugDetails.get("CURRENTRX_REMARKS")==null?"":drugDetails.get("CURRENTRX_REMARKS"));
						hash.put("allergy_remarks",drugDetails.get("ALLERGY_REMARKS")==null?"":drugDetails.get("ALLERGY_REMARKS"));
						bean_IVPB.getInfuseOverValue((String)drugDetails.get("DRUG_CODE"));
					}					
					bean_IVPB.setOrderID();
		
					//setPackSize
					bean_IVPB.setIVPrep("3");
					bean_IVPB.setOrderID((String)bean_IVPB.getOrderID());
					bean_IVPB.setOrderId1((String)bean_IVPB.getOrderID());
					HashMap returndata = bean_IVPB.prepareOrderDetails(hash);
					String print_ord_sht_rule_ind=bean_IVPB.getPrintOrdShtRuleInd();
					result	= ((Boolean)returndata.get("result")).booleanValue();
					message	= (String)returndata.get("message")==null?"":(String)returndata.get("message");
					flag		= (String)returndata.get("flag")==null?"":(String)returndata.get("flag");
				}
				
				if(bean_IVD.getAllFluids()!=null && bean_IVD.getDrugDetails().size()>0) {
					ArrayList drugList	= bean_IVD.getDrugDetails();
					for(int i=0;i<drugList.size();i++) {
						HashMap drugDetails = (HashMap)drugList.get(i);						
						hash.put("CALC_DOSE_BASED_ON"+i,drugDetails.get("CALC_DOSE_BASED_ON")==null?"":drugDetails.get("CALC_DOSE_BASED_ON"));
						hash.put("OR_QTY_DESC"+i,drugDetails.get("OR_QTY_DESC")==null?"":drugDetails.get("OR_QTY_DESC"));
						hash.put("QTY_UNIT"+i,drugDetails.get("QTY_UNIT")==null?"":drugDetails.get("QTY_UNIT"));
						hash.put("QTY_UOM"+i,drugDetails.get("QTY_UOM")==null?"":drugDetails.get("QTY_UOM"));
						hash.put("PRES_QTY_UOM"+i,drugDetails.get("PRES_QTY_UOM")==null?"":drugDetails.get("PRES_QTY_UOM"));
						hash.put("Dosage_Uom"+i,drugDetails.get("Dosage_Uom")==null?"":drugDetails.get("Dosage_Uom"));
						hash.put("QTY_VALUE"+i,drugDetails.get("QTY_VALUE")==null?"":drugDetails.get("QTY_VALUE"));
						hash.put("CURRENTRX_REMARKS"+i,drugDetails.get("CURRENTRX_REMARKS")==null?"":drugDetails.get("CURRENTRX_REMARKS"));
						hash.put("DOSE_REMARKS"+i,drugDetails.get("DOSE_REMARKS")==null?"":drugDetails.get("DOSE_REMARKS"));
						hash.put("ALLERGY_REMARKS"+i,drugDetails.get("ALLERGY_REMARKS")==null?"":drugDetails.get("ALLERGY_REMARKS"));
						hash.put("DOSAGE_TYPE"+i,drugDetails.get("DOSAGE_TYPE")==null?"":drugDetails.get("DOSAGE_TYPE"));
						hash.put("STRENGTH_VALUE"+i,drugDetails.get("STRENGTH_VALUE")==null?"":drugDetails.get("STRENGTH_VALUE"));
						if(drugDetails.get("CALC_DOSE_BASED_ON")!=null && drugDetails.get("CALC_DOSE_BASED_ON").equals("D")) {
							hash.put("QTY_DESC_CODE"+i,drugDetails.get("QTY_DESC_CODE")==null?"":drugDetails.get("QTY_DESC_CODE"));
							hash.put("QTY_DESC"+i,drugDetails.get("QTY_DESC")==null?"":drugDetails.get("QTY_DESC"));
							if(drugDetails.get("CALC_DOSE_BASED_ON")!=null && drugDetails.get("CALC_DOSE_BASED_ON").equals("S")) {
								hash.put("STRENGTH"+i,drugDetails.get("STRENGTH")==null?"":drugDetails.get("STRENGTH"));
							}
							else {
								hash.put("PRES_QTY_VALUE"+i,drugDetails.get("PRES_QTY_VALUE")==null?"":drugDetails.get("PRES_QTY_VALUE"));
							}
						}
						else {
							hash.put("CALC_DOSE_VALUE"+i,drugDetails.get("CALC_DOSE_VALUE")==null?"":drugDetails.get("CALC_DOSE_VALUE"));
							hash.put("CALC_DOSE_BY"+i,drugDetails.get("CALC_DOSE_BY")==null?"":drugDetails.get("CALC_DOSE_BY"));
							hash.put("STRENGTH"+i,drugDetails.get("STRENGTH")==null?"":drugDetails.get("STRENGTH"));
						}
					}
					hash.put("IV_PRESC_YN", "N");
					hash.put("buildMAR_yn", bean_IVD.getBuildMAR_yn());
					HashMap fluid_details = bean_IVD.getFluidDetails();
					hash.put("STOCK_VALUE",fluid_details.get("FLUID_UNIT_QTY")==null?"0":fluid_details.get("FLUID_UNIT_QTY"));
					hash.put("ORDER_TYPE_CODE",fluid_details.get("ORDER_TYPE_CODE")==null?"":fluid_details.get("ORDER_TYPE_CODE"));
					hash.put("infusion_over_insert_value",bean_IVD.getINFUSE_OVER());					
					hash.put("INFUSION_PERIOD_UOM",fluid_details.get("INFUSE_OVER_UNIT")==null?"":fluid_details.get("INFUSE_OVER_UNIT"));
					hash.put("INFUSION_VALUE",fluid_details.get("SCH_INFUSION_RATE")==null?"0":fluid_details.get("SCH_INFUSION_RATE"));
					hash.put("START_DATE",fluid_details.get("START_DATE")==null?"":fluid_details.get("START_DATE"));
					hash.put("END_DATE",fluid_details.get("END_DATE")==null?"":fluid_details.get("END_DATE"));
					hash.put("FREQUENCY",fluid_details.get("FREQ_CODE")==null?"":fluid_details.get("FREQ_CODE"));
					hash.put("DURN_TYPE",fluid_details.get("DURN_TYPE")==null?"":fluid_details.get("DURN_TYPE"));
					hash.put("DURN_UNIT",fluid_details.get("DURN_UNIT")==null?"":fluid_details.get("DURN_UNIT"));
					hash.put("INFUSION_UOM_DISPLAY",fluid_details.get("FLUID_UNIT_QTY_UOM")==null?"":fluid_details.get("FLUID_UNIT_QTY_UOM"));
					hash.put("EQVL_UOM_CODE",fluid_details.get("SCH_INFUSION_VOL_STR_UNIT")==null?"":fluid_details.get("SCH_INFUSION_VOL_STR_UNIT"));
					if(fluid_details.get("QTY_UOM")==null ||fluid_details.get("QTY_UOM").toString().equalsIgnoreCase("")){
						
						
						hash.put("STOCK_UOM_CODE",fluid_details.get("FLUID_STOCK_UOM")==null?"":fluid_details.get("FLUID_STOCK_UOM"));
					}  else{
						
						hash.put("STOCK_UOM_CODE",fluid_details.get("QTY_UOM")==null?"":fluid_details.get("QTY_UOM"));
						
					}
					
					hash.put("DURN_VALUE",fluid_details.get("DURN_VALUE")==null?"":fluid_details.get("DURN_VALUE"));
					hash.put("STRENGTH_PER_VALUE_PRES_UOM",fluid_details.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":fluid_details.get("STRENGTH_PER_VALUE_PRES_UOM"));
					hash.put("VOLUME",fluid_details.get("VOLUME")==null?"":fluid_details.get("VOLUME"));		
					if(bean_IVD.getOrderID() == null || (bean_IVD.getOrderID()).equals(""))
						bean_IVD.setOrderID();
					HashMap returndata =  bean_IVD.prepareOrderDetails(hash);
					String print_ord_sht_rule_ind=bean_IVD.getPrintOrdShtRuleInd();
					result	= ((Boolean)returndata.get("result")).booleanValue();
					message	= returndata.get("message")==null?"":(String)returndata.get("message");
					flag		= returndata.get("flag")==null?"":(String)returndata.get("flag");
				}		
				
			
				if(bean_CRX.getDrugDetails()!=null && bean_CRX.getDrugDetails().size()>0) {
				
			    HashMap returndata = bean_CRX.releaseCompoundRx();
				String print_ord_sht_rule_ind=bean_CRX.getPrintOrdShtRuleInd();
				 result	= ((Boolean)returndata.get("result")).booleanValue();
				 message	= (String)returndata.get("message");
				 flag		= (String)returndata.get("flag");
				flag		= "";
				if(message==null)
					message		=	"";
				//out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\", \"" + print_ord_sht_rule_ind +"\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
				}
			 
			 
				out.println("assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" , \"" + invalidCode + "\") ; ") ; 	
				}
			catch (Exception e) {
				out.println("alert(\"Exception in Controller : " + e + "\");") ;
				e.printStackTrace();
			}	
	}		
%>
