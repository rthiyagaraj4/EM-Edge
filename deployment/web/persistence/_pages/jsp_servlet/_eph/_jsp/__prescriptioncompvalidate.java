package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import java.text.DecimalFormat;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __prescriptioncompvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eph/jsp/PrescriptionCompValidate.jsp", 1722856490080L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408

13/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
03/07/2020       IN:072715       Haribabu      03/07/2020     Manickavasagam    		 MMS-DM-CRF-0165
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
13/1/2020		12491				Shazana													NMC-JD-CRF-0063

--------------------------------------------------------------------------------------------------------------
*/
try {
	String bean_id		= request.getParameter("bean_id"); 
	String bean_name	= request.getParameter("bean_name");//added for NMC-JD-CRF-0063
	String validate		= request.getParameter("validate");
    String facility_id  = (String)session.getValue( "facility_id" );
    String login_user	= (String)session.getValue("login_user");

	if (bean_id == null || bean_id.equals(""))
		return ;

	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	if (validate.equals("VEHILEDETAILS")) {
		String drug_code		= request.getParameter("drug_code");
		//String base_uom			= request.getParameter("base_uom");
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");

		String iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

		String orderType		= iv_bean.getOrderType(drug_code);
		iv_bean.setFluidDetails(drug_code,"","","",""); // CRF-0062 NEWLY ADDED
		if (iv_bean.checkForStock()) {
			ArrayList stockDetails = iv_bean.getStockDetails(drug_code, "1");
			if (stockDetails.size() != 0)
				out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" + stockDetails.get(2) + "\");") ;
				
			else
				out.println("setStockDetails(2);") ;
		}
		
		out.println("setOrderType(\""+ orderType + "\");");
		String infuse	=	iv_bean.getInfuseOverValue(drug_code,"");//Added "" for ML-MMOH-CRF-1223
		out.println("setInfuseValue(\""+infuse+ "\");");
		putObjectInBean(iv_bean_id,iv_bean,request); 
	}
	else if(validate.equals("OrdDispenseLocation")){//Added for NMC-JD-CRF-0063 start
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request);
		String patient_id	= bean.getPatId();
		String encounter_id	= bean.getEncId();
		String location_type			= (String)hash.get("location_type");
		String location_code			= (String)hash.get("location_code");
		String take_home_medication	= (String)hash.get("take_home_medication");
		String priority				= (String)hash.get("priority");
		String iv_prep_yn				= (String)hash.get("iv_prep_yn");
		String take_home_medication_op				= (String)hash.get("take_home_medication_op");
		String take_home_medication_ckk_val				= (String)hash.get("take_home_medication_ckk_val");
		System.out.println("getOpDischMedInd: "+bean.getOpDischMedInd());
		if(take_home_medication_op!=null && !take_home_medication_op.equals("")){
			bean.setTakeHomeMedicationOp(take_home_medication_op);
		}
		bean.setOpDischMedInd(take_home_medication_ckk_val); //end
	 	String dflt_disp_locn	= "";	
		String time_flag ="";
		
		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added for Bru-HIMS-CRF-347 [IN:037862] ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]

		if(ord_disp_location != null & ord_disp_location.size()>0){
			dflt_disp_locn	= (String)ord_disp_location.get(2);
		}
		out.println("displayDispLocnCompRx('"+dflt_disp_locn+"');");//END
	}
	else if(validate.equals("DRUGCODE")){
		String drugCodes				  = (String)hash.get("drugCodes");
		String patient_id				  = (String)hash.get("patient_id");
		String encounter_id				  = (String)hash.get("encounter_id");
	  	String Trade_Codes = request.getParameter("Trade_Codes");
			if(Trade_Codes == null) Trade_Codes = "";
		String Trade_Names = request.getParameter("Trade_Names");
			if(Trade_Names == null) Trade_Names = "";

		String iv_bean_id				  = "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name				  = "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean		  = (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		
        String drug_db_interface_yn       = (String)hash.get("drug_db_interface_yn");
		String drug_db_duptherapy_yn      = (String)hash.get("drug_db_duptherapy_yn");
		String drug_db_interact_check_yn  = (String)hash.get("drug_db_interact_check_yn");
		String drug_db_contraind_check_yn = (String)hash.get("drug_db_contraind_check_yn");
		String drug_db_allergy_check_yn   = (String)hash.get("drug_db_allergy_check_yn");
		String drug_db_dose_check_yn	  = (String)hash.get("drug_db_dosecheck_yn");
		String drug_db_product_id		  = (String)hash.get("drug_db_product_id");
        String adr_count				  =	(String)hash.get("adr_count");
        String pract_id				  =	(String)hash.get("pract_id");
        String resp_id				  =	(String)hash.get("resp_id");
        String recno				  =	(String)hash.get("recno");
		// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule  -- begin
		String act_patient_class	  =	(String)hash.get("act_patient_class");  
		String priority	  			  =	(String)hash.get("priority");
		String source_code	  		  =	(String)hash.get("source_code");
		String take_home_medication	  =	(String)hash.get("take_home_medication");
		String startdate			  = (String) hash.get( "startdate" );// Added for ML-BRU-SCF-0811 [IN:039394]
		String enddate				  = (String) hash.get( "enddate" );// Added for ML-BRU-SCF-0811 [IN:039394]
		// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule  -- end
		iv_bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
		iv_bean.setDrug_DB_Product_id(drug_db_product_id);
		iv_bean.setExternalDosageYN(drug_db_dose_check_yn);
		
		iv_bean.setDrgTradeCodesArray(Trade_Codes);
		iv_bean.setDrugDetails(drugCodes, pract_id, resp_id,act_patient_class,priority,source_code,take_home_medication);  //CRF-0062 
		HashMap hm	= iv_bean.getCurrDrugDetails();
		//HashMap hm	= iv_bean.getDrugDetails();
		
		String strength				= (String)hm.get("STRENGTH_VALUE");
		String strength_uom			= (String)hm.get("STRENGTH_UOM");
		String strength_uom_need	= CommonBean.checkForNull( iv_bean.getUomDisplay(facility_id,strength_uom));//Modified for CRF--0749 INC-13640
		String dosage				= (String)hm.get("QTY_VALUE");
		String dosage_uom			= (String)hm.get("QTY_UOM");
		//String freq_code			= (String)hm.get("FREQ_CODE");
		String form_desc			= (String)hm.get("FORM_DESC");
		String allergy_override		= (String)hm.get("ALLERGY_OVERRIDE");
		String dose_override		= (String)hm.get("DOSE_OVERRIDE");
		String currentrx_override	= (String)hm.get("CURRENTRX_OVERRIDE");
		String stock_uom			=  	iv_bean.getStockUOM((String)hm.get("DRUG_CODE"));
		String generic_id			= (String)hm.get("GENERIC_ID");
		String generic_name			= (String)hm.get("GENERIC_NAME");
		String drug_desc            = (String)hm.get("DRUG_DESC")==null?"":(String)hm.get("DRUG_DESC");	
		//String daily_dose			= (String)hm.get("DAILY_DOSE");
		//String unit_dose			= (String)hm.get("UNIT_DOSE");
		//String mono_graph			= (String)hm.get("MONO_GRAPH");
		String limit_ind			= (String)hm.get("LIMIT_IND");

		String allergy_yn			= (String)hm.get("ALLERGY_YN");
		String current_rx			= (String)hm.get("CURRENT_RX");
		String drug_code			= (String)hm.get("DRUG_CODE");
		String srl_no				= (String)hm.get("SRL_NO");
		//String allergy_remarks		= (String)hm.get("ALLERGY_REMARKS");
		//String dose_remarks			= (String)hm.get("DOSE_REMARKS");
		//String currentrx_remarks	= (String)hm.get("CURRENTRX_REMARKS");
		//String min_unit_dose		= (String)hm.get("MIN_UNIT_DOSE");
		//String min_daily_dose		= (String)hm.get("MIN_DAILY_DOSE");
		String pres_base_uom		= (String)hm.get("PRES_BASE_UOM"); 
		String pres_base_uom_need   =  CommonBean.checkForNull( iv_bean.getUomDisplay(facility_id,pres_base_uom));//Modified for CRF--0749
		String external_product_id	= (String)hm.get("EXTERNAL_PRODUCT_ID");
        String perform_ext_db_checks	=(String)hm.get("PERFORM_EXTERNAL_DATABASE_CHECKS"); 
       // String ext_dup_theraphy_check	=(String)hm.get("Perform_External_Duplicate_Check"); 
		//String ext_dosage_check			=(String)hm.get("Perform_External_Dosage_Check"); 
		String drug_class = (String)hm.get("DRUG_CLASS")==null?"":(String)hm.get("DRUG_CLASS");	
		//added for ML-MMOH-CRF-1408 - start
		String max_daily_celing_dose  = (String)hm.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)hm.get("MAX_DAILY_CEELING_DOSE");
		String min_daily_ceiling_dose =(String)hm.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)hm.get("MIN_DAILY_CEELING_DOSE");
		String max_unit_ceiling_dose  =(String)hm.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)hm.get("MAX_UNIT_CEELING_DOSE");
		String min_unit_ceiling_dose  =(String)hm.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)hm.get("MIN_UNIT_CEELING_DOSE");
		//added for ML-MMOH-CRF-1408 - end
		// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule for the first drug selected-- begin
		if(recno.equals("1")){
			/*if(hm.containsKey("FORM_CODE")){
			String presBean_id			= "PrescriptionBean_1"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean_1";
			//String buildMAR_Rule=iv_bean.getMARDefaulting(act_patient_class,form_code,source_code,priority);}*/
			
			String buildMAR_Rule=hm.get("BUILD_MAR_RULE").toString();
			if(buildMAR_Rule.equals("CE") || buildMAR_Rule.equals("CD"))
				iv_bean.setBuildMAR_yn("Y");
			else
				iv_bean.setBuildMAR_yn("N");
			out.println("setBuildMAR('"+buildMAR_Rule+"');");
		}
		// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule for the first drug selected-- end
		String adr_display_yn="N";
		// TDM
		String tdmOrderId = iv_bean.getOrderIdForTDMDtls(patient_id,drug_code);
		if(tdmOrderId !=null && !tdmOrderId.equals("")){
			out.println("assignTdmOrderid('"+tdmOrderId+"');");
		}
		drug_desc=drug_desc.replaceAll(" ","%20");
		drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
		drug_desc=drug_desc.replaceAll("%2520","%20");
		//Modified for CRF--0749 INC-13640
		
		//Added for MMS-DM-CRF-0177
		String pre_alloc_appl = iv_bean.getPreAllocApplYN();
		String drug_search_by =(String)hm.get("DRUG_SEARCH_BY")==null?"":(String)hm.get("DRUG_SEARCH_BY");
		
		if(pre_alloc_appl.equals("Y") && drug_search_by.equals("G"))
			{
				drug_desc= (String)hm.get("DRUG_DESC_NEW")==null?"":(String)hm.get("DRUG_DESC_NEW");	
				drug_desc=drug_desc.replaceAll(" ","%20");
				drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
				drug_desc=drug_desc.replaceAll("%2520","%20");
			}
		//Added for MMS-DM-CRF-0177
		
		out.println("assignDosageDetails('"+(String)hm.get("DRUG_CODE")+"','"+drug_desc+"','"+strength+"','"+strength_uom+"','"+strength_uom_need+"','"+dosage+"','"+dosage_uom+"','"+form_desc+"','"+stock_uom+"','"+pres_base_uom+"','"+pres_base_uom_need+"','"+external_product_id+"','"+perform_ext_db_checks+"','"+drug_class+"','"+generic_id+"','"+generic_name+"');");

		if(Integer.parseInt(adr_count)>0){
			int  drug_adr_count = iv_bean.getADRCount(patient_id,(String)hm.get("DRUG_CODE")); 
			if(drug_adr_count>0){
				adr_display_yn="Y";
				out.println("adrdisplay('"+adr_display_yn+"');");
			}
		}
		//if(perform_ext_db_checks.equals("N")){     
			/*if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
				out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"')");
				//out.println("showOverRideRemarks('"+patient_id+"','"+encounter_id+"','"+generic_id+"','"+generic_name+"','"+drug_desc+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+limit_ind+"','"+allergy_yn+"','"+current_rx+"','"+drug_code+"','"+srl_no+"','"+allergy_remarks+"','"+dose_remarks+"','"+currentrx_remarks+"','"+min_unit_dose+"','"+min_daily_dose+"')");
			}*/
		//}else{
			ArrayList exProd				= new ArrayList();
			ArrayList drugDesc				= new ArrayList();
			String dup_drug_det			    = "";
			HashMap drug_Interactions		= null;
			//boolean chk_drug_med_condition	= false;
			//StringBuffer interaction_det    = new StringBuffer();
			//String contra_indication_for_drug   = "";

			String drug_db_contraind_check_flag	="N";
			String drug_db_interact_check_flag	="N";
			String drug_db_duptherapy_flag		="N";
			String drug_db_dose_check_flag      ="N"; 
			String drug_db_allergy_flag			="N";
			//String ext_override_reason			="";
			String ext_prod_id                   ="";

			ArrayList temp =(ArrayList)iv_bean.getDrugDetails();

			String ex_bean_id   = "@ExternalProductLinkBean";
			String ex_bean_name = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
			HashMap drug_data=new HashMap();
			 for(int i=0;i<temp.size();i++){
				drug_data	=	(HashMap)temp.get(i);					
				drugDesc.add((String)drug_data.get("DRUG_DESC"));
				ext_prod_id=(String)drug_data.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_data.get("EXTERNAL_PRODUCT_ID");
				if(!ext_prod_id.equals("")){
					 exProd.add(ext_prod_id);
				}
			 }
			 ext_prod_id = hm.get("EXTERNAL_PRODUCT_ID")==null?"":(String)hm.get("EXTERNAL_PRODUCT_ID");
			/*
			if(exProd.size()>0)
				beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
			*/
			if(!ext_prod_id.equals("")){
				/*
                if(drug_db_interact_check_yn.equals("Y")){
				   beanex.getDDInteractions(external_product_id);//Store interactions
				       drug_Interactions		= beanex.getInteractions();//get Interactions
					if(drug_Interactions.size()>0){							
                         drug_db_interact_check_flag="Y";
					}
		        }
                if(drug_db_duptherapy_yn.equals("Y")){ 
				   dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result

				   if(!dup_drug_det.equals("")&&dup_drug_det!=null)
                        drug_db_duptherapy_flag="Y";
				}
                if(drug_db_contraind_check_yn.equals("Y")){
					  ArrayList ex_prod_ids =new ArrayList();
					  ex_prod_ids.add(external_product_id);
				      boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
					  HashMap contra_indications =(HashMap)beanex.getContraIndications();
					  if(contra_indications.containsKey(external_product_id)){
						 drug_db_contraind_check_flag="Y";
					  }				  
				}

				if(drug_db_allergy_check_yn.equals("Y")){
					ArrayList ex_prod_ids =new ArrayList();
					ex_prod_ids.add(ext_prod_id);
					beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
					HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
					if(drug_alergies.containsKey(ext_prod_id)){
						drug_db_allergy_flag	= "Y";
					}	
				}*/
				if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
					String storeIDs = "N";
					if(exProd.size()>0 )
						storeIDs = "Y";
						
					HashMap tempDetails= null;
					ArrayList reqChecks = new ArrayList();
					reqChecks.add("N"); //Dosage Check 
					reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
					reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
					reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
					reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
					HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
					if(drugDBCheckResult!=null)
						beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
					if(drug_db_allergy_check_yn.equals("Y")){
					   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
						   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
						   if(allergy_alert!=null && !allergy_alert.equals(""))
								drug_db_allergy_flag="Y";
					   } 
					   else {  
							tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
							if(tempDetails!=null && tempDetails.size()>0){
								 drug_db_allergy_flag="Y";
							}
						} 
					}

					if(drug_db_interact_check_yn.equals("Y")){
						tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
						if(tempDetails!=null && tempDetails.size()>0){
							 drug_db_interact_check_flag="Y";
						}
					}

					if(drug_db_duptherapy_yn.equals("Y")){ 
					   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
					   if(dup_drug_det!=null && !dup_drug_det.equals(""))
							drug_db_duptherapy_flag="Y";
					}
					if(drug_db_contraind_check_yn.equals("Y")){
						if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // Adding start for IN066787- Performance
							tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */
						if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
							 drug_db_contraind_check_flag="Y";
						}
					}else{//Adding end for IN066787- Performance
						tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
						if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
							drug_db_contraind_check_flag="Y";
						}		
					}
				}
			 }
			}
			hm.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
			hm.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
			hm.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
			hm.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
			hm.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

			if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_yn.equals("Y")){
				out.println("viewMedicationAlert('"+drug_code+"','"+recno+"','"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ON_LOAD','','','','','','"+drug_db_allergy_flag+"');");
			}

			if(drug_db_duptherapy_flag.equals("Y")){
				current_rx ="N";
				hm.put("CURRENT_RX",current_rx);
			}

			if(drug_db_allergy_flag.equals("Y")){
				allergy_yn ="N";
				hm.put("ALLERGY_YN",allergy_yn);
			}

			if(drug_db_interface_yn.equals("Y") && drug_db_dose_check_yn.equals("Y") && !ext_prod_id.equals("")){ //modified for Ml-MMOH-CRF-1408
				limit_ind = "Y";
				hm.put("LIMIT_IND",limit_ind);
			}
			if(limit_ind==null)
				limit_ind = "";
			if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){			
				out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"');");
			}
           putObjectInBean(ex_bean_id,beanex,request);
		 //}	
	     putObjectInBean(iv_bean_id,iv_bean,request); 
	}
	else if(validate!= null && validate.equals("populateDurationDesc")){
		String freq_code			= request.getParameter("freq_code" );
		String patient_id			= request.getParameter("patient_id");
		String encounter_id			= request.getParameter("encounter_id");
		String iv_bean_id			= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id,iv_bean_name, request) ;

		String durn_desc			= "";
		String repeat_durn_type		= "";
		String freq_value			= "";
		String freq_nature			= "";
		String interval_value		= "";
		String repeat_value			= "";
		String schedule_yn			= "";
		HashMap freqNature			=(HashMap)iv_bean.freqValidate(freq_code);
		if(freqNature!=null && freqNature.size()>0){
			freq_nature				= (String)freqNature.get("freq_nature");
			freq_value				= (String)freqNature.get("freq_value");
			interval_value			= (String)freqNature.get("interval_value");
			repeat_value			= (String)freqNature.get("repeat_value");
			schedule_yn				= (String)freqNature.get("schedule_yn");
			repeat_durn_type		= (String)freqNature.get("repeat_durn_type");
		}
		if(!freq_nature.equals("O")){
			out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\");");
		}
		else{
			durn_desc	="";
			freq_value	="";			
			out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\");");
		}
		// objects nullified after usage
		putObjectInBean(iv_bean_id,iv_bean,request); 
		freqNature	=	null;
	}
	else if(validate.equals("POPULATEENDDATE")) {
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		//String mode			= request.getParameter("mode");
		String patient_id	= request.getParameter("patient_id");
		String encounter_id	= request.getParameter("encounter_id");
		String freq_nature	= request.getParameter("freq_nature");

		String iv_bean_id	= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id,iv_bean_name, request) ;		
		String locale			= 	(String)session.getAttribute("LOCALE"); //Added for SRR20056-SCF-9368 [IN:037482]
     		if(!locale.equals("en")); //if block Added for SRR20056-SCF-9368 [IN:037482] 
			start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
		String end_date		= iv_bean.populateEndDate(freq_nature,start_date, durn_value, durn_unit);
		if(!locale.equals("en")){//if block Added for SRR20056-SCF-9368 [IN:037482] 
			end_date  = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
			start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale); 
		}
		out.println("setEndDate(\""+ end_date +"\");");
		putObjectInBean(iv_bean_id,iv_bean,request); 
	} 
	else if(validate.equals("RELEASE")){
		String patient_id		= request.getParameter("patient_id");
		//String priority		    = request.getParameter("priority");
		String encounter_id		= request.getParameter("encounter_id");
		String freq_code		= request.getParameter("freq_code");
		String durn_value		= request.getParameter("durn_value");
		String durn_type		= request.getParameter("durn_type");
		String start_date		= request.getParameter("start_date");
		String end_date			= request.getParameter("end_date");		
		String presByBase		= request.getParameter("PresByBase");		
		String ord_qty1			= request.getParameter("ord_qty1");		
		String ord_qty2			= request.getParameter("ord_qty2");		
		String ord_qty3			= request.getParameter("ord_qty3");		
		String ord_qty4			= request.getParameter("ord_qty4");		
		String ord_qty5			= request.getParameter("ord_qty5");		
		String ord_qty6			= request.getParameter("ord_qty6");		
		String ord_qty7			= request.getParameter("ord_qty7");		
		String ord_qty8			= request.getParameter("ord_qty8");		
		String ord_qty9			= request.getParameter("ord_qty9");		
		String ord_qty10		= request.getParameter("ord_qty10");		
		//Added for  ML-BRU-CRF-072[Inc:29938] Start
		String DrugIndicationRemarks1		    = request.getParameter("DrugIndicationRemarks1");
		if(!DrugIndicationRemarks1.equals(""))
				DrugIndicationRemarks1 = java.net.URLDecoder.decode(DrugIndicationRemarks1,"UTF-8"); 
		String DrugIndicationRemarks2			= request.getParameter("DrugIndicationRemarks2");
		if(!DrugIndicationRemarks2.equals(""))
				DrugIndicationRemarks2 = java.net.URLDecoder.decode(DrugIndicationRemarks2,"UTF-8"); 
		String DrugIndicationRemarks3			= request.getParameter("DrugIndicationRemarks3");
		if(!DrugIndicationRemarks3.equals(""))
				DrugIndicationRemarks3 = java.net.URLDecoder.decode(DrugIndicationRemarks3,"UTF-8"); 
		String DrugIndicationRemarks4			= request.getParameter("DrugIndicationRemarks4");
		if(!DrugIndicationRemarks4.equals(""))
				DrugIndicationRemarks4 = java.net.URLDecoder.decode(DrugIndicationRemarks4,"UTF-8"); 
		String DrugIndicationRemarks5			= request.getParameter("DrugIndicationRemarks5");
		if(!DrugIndicationRemarks5.equals(""))
				DrugIndicationRemarks5 = java.net.URLDecoder.decode(DrugIndicationRemarks5,"UTF-8"); 
		String DrugIndicationRemarks6			= request.getParameter("DrugIndicationRemarks6");
		if(!DrugIndicationRemarks6.equals(""))
				DrugIndicationRemarks6 = java.net.URLDecoder.decode(DrugIndicationRemarks6,"UTF-8"); 
		String DrugIndicationRemarks7			= request.getParameter("DrugIndicationRemarks7");
		if(!DrugIndicationRemarks7.equals(""))
				DrugIndicationRemarks7 = java.net.URLDecoder.decode(DrugIndicationRemarks7,"UTF-8"); 
		String DrugIndicationRemarks8			= request.getParameter("DrugIndicationRemarks8");
		if(!DrugIndicationRemarks8.equals(""))
				DrugIndicationRemarks8 = java.net.URLDecoder.decode(DrugIndicationRemarks8,"UTF-8"); 
		String DrugIndicationRemarks9			= request.getParameter("DrugIndicationRemarks9");
		if(!DrugIndicationRemarks9.equals(""))
				DrugIndicationRemarks9 = java.net.URLDecoder.decode(DrugIndicationRemarks9,"UTF-8"); 
		String DrugIndicationRemarks10			= request.getParameter("DrugIndicationRemarks10");
		if(!DrugIndicationRemarks10.equals(""))
				DrugIndicationRemarks10 = java.net.URLDecoder.decode(DrugIndicationRemarks10,"UTF-8"); 
		//Added for  ML-BRU-CRF-072[Inc:29938] End
		String drug_code1		= request.getParameter("drug_code1");		
		String drug_code2		= request.getParameter("drug_code2");		
		String drug_code3		= request.getParameter("drug_code3");		
		String drug_code4		= request.getParameter("drug_code4"); 
		String drug_code5		= request.getParameter("drug_code5"); 
		String drug_code6		= request.getParameter("drug_code6"); 
		String drug_code7		= request.getParameter("drug_code7"); 
		String drug_code8		= request.getParameter("drug_code8"); 
		String drug_code9		= request.getParameter("drug_code9"); 
		String drug_code10		= request.getParameter("drug_code10");
		String RP1				= request.getParameter("RP1");				
		String RP2				= request.getParameter("RP2");				
		String RP3				= request.getParameter("RP3");				
		String RP4				= request.getParameter("RP4");				
		String RP5				= request.getParameter("RP5");				
		String RP6				= request.getParameter("RP6");				
		String RP7				= request.getParameter("RP7");				
		String RP8				= request.getParameter("RP8");				
		String RP9				= request.getParameter("RP9");				
		String RP10				= request.getParameter("RP10");	
		String narcotic_yn		= request.getParameter("narcotic_yn");	
		String[] reqQty			= new String[10]; 
		String[] ordQty			= new String[10]; 
		String[] ordQtyUOM		= new String[10]; 
		String[] DrugIndicationRemarks		= new String[10];
		for(int number=1;number<=10;number++){
			reqQty[number-1]=request.getParameter("reqQty"+number);
			ordQty[number-1]=request.getParameter("ordQty"+number);
			ordQtyUOM[number-1]=request.getParameter("ordQtyUOM"+number);
			DrugIndicationRemarks[number-1]=request.getParameter("DrugIndicationRemarks"+number);//Added for  ML-BRU-CRF-072[Inc:29938]
		}
		String dosage           = request.getParameter("dosage");
		String totalQty			= request.getParameter("totalQty");
		String dosage_uom		= request.getParameter("dosage_uom");
			   dosage_uom		= dosage_uom.trim();
		String mode             = request.getParameter("mode");
        String pract_id			= request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
        String resp_id			= request.getParameter("resp_id")==null?"":request.getParameter("resp_id");
		String discharge_yn		= request.getParameter("discharge_yn");

		String iv_bean_id	= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(iv_bean_id,iv_bean_name,request);       
	    PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;//Added for NMC-JD-CRF-0063
		bean.setPriority(request.getParameter("priority"));

		if(mode.equals("RENEW_ORDER")){
			if(!drug_code1.equals("")){
				bean.setDrugDetails(drug_code1+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code2.equals("")){
				bean.setDrugDetails(drug_code2+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code3.equals("")){
				bean.setDrugDetails(drug_code3+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code4.equals("")){
				bean.setDrugDetails(drug_code4+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code5.equals("")){
				bean.setDrugDetails(drug_code5+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code6.equals("")){
				bean.setDrugDetails(drug_code6+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code7.equals("")){
				bean.setDrugDetails(drug_code7+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code8.equals("")){
				bean.setDrugDetails(drug_code8+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code9.equals("")){
				bean.setDrugDetails(drug_code9+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
			if(!drug_code10.equals("")){
				bean.setDrugDetails(drug_code10+",",pract_id,resp_id,"","","","");  //CRF-0062 
			}
		}
		if(discharge_yn.equals("Y")){bean.setPatientClass("OP");}
		bean.setOrderID();
		bean.setBuildMAR_yn((String)hash.get("buildMAR_yn"));
		bean.setAllergic((String)hash.get("allergic_yn"));

		String bean_id_1				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name_1				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean	= (PrescriptionBean_1)getBeanObject( bean_id_1, bean_name_1 , request);

		bean.setAmendRemarks((String)pres_bean.getPresRemarks());

		//String order_id	= bean.getOrderID();
		ArrayList drugList	= bean.getDrugDetails();

		if (drugList.size() != 0) {
			HashMap record	=	null;
			for(int i=0;i<drugList.size();i++) {
				record	=	(HashMap)drugList.get(i);    
  
				record.put("FREQ_CODE",freq_code);
				record.put("DURN_VALUE",durn_value);
				record.put("DURN_TYPE",durn_type);
				if(!bean.getLanguageId().equals("en")){
					record.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",bean.getLanguageId(),"en"));
					record.put("END_DATE",com.ehis.util.DateUtils.convertDate(end_date,"DMYHM",bean.getLanguageId(),"en"));
				}
				else{
					record.put("START_DATE",start_date);
					record.put("END_DATE",end_date);
				}
				record.put("DOSAGE_VALUE",dosage);
				record.put("DOSAGE_UOM",dosage_uom);
				if(((String)record.get("DRUG_CODE")).equals(drug_code1)) {
					record.put("ABSOL_QTY",ord_qty1);
					record.put("RATIO_PERCENTAGE",RP1);
					record.put("REQD_QTY",reqQty[0]);
					record.put("ORDER_QTY",ordQty[0]);
					record.put("ORDER_UOM",ordQtyUOM[0]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[0]);//Added for  ML-BRU-CRF-072[Inc:29938]
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code2)) {
					record.put("ABSOL_QTY",ord_qty2);
					record.put("RATIO_PERCENTAGE",RP2);
					record.put("REQD_QTY",reqQty[1]);
					record.put("ORDER_QTY",ordQty[1]);
					record.put("ORDER_UOM",ordQtyUOM[1]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[1]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code3)) {
					record.put("ABSOL_QTY",ord_qty3);
					record.put("RATIO_PERCENTAGE",RP3);
					record.put("REQD_QTY",reqQty[2]);
					record.put("ORDER_QTY",ordQty[2]);
					record.put("ORDER_UOM",ordQtyUOM[2]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[2]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code4)) {
					record.put("ABSOL_QTY",ord_qty4);
					record.put("RATIO_PERCENTAGE",RP4);
					record.put("REQD_QTY",reqQty[3]);
					record.put("ORDER_QTY",ordQty[3]);
					record.put("ORDER_UOM",ordQtyUOM[3]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[3]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 	
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code5)) {
					record.put("ABSOL_QTY",ord_qty5);
					record.put("RATIO_PERCENTAGE",RP5);
					record.put("REQD_QTY",reqQty[4]);
					record.put("ORDER_QTY",ordQty[4]);
					record.put("ORDER_UOM",ordQtyUOM[4]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[4]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code6)) {
					record.put("ABSOL_QTY",ord_qty6);
					record.put("RATIO_PERCENTAGE",RP6);
					record.put("REQD_QTY",reqQty[5]);
					record.put("ORDER_QTY",ordQty[5]);
					record.put("ORDER_UOM",ordQtyUOM[5]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[5]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code7)) {
					record.put("ABSOL_QTY",ord_qty7);
					record.put("RATIO_PERCENTAGE",RP7);
					record.put("REQD_QTY",reqQty[6]);
					record.put("ORDER_QTY",ordQty[6]);
					record.put("ORDER_UOM",ordQtyUOM[6]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[6]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code8)) {
					record.put("ABSOL_QTY",ord_qty8);
					record.put("RATIO_PERCENTAGE",RP8);
					record.put("REQD_QTY",reqQty[7]);
					record.put("ORDER_QTY",ordQty[7]);
					record.put("ORDER_UOM",ordQtyUOM[7]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[7]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				}
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code9)) {
					record.put("ABSOL_QTY",ord_qty9);
					record.put("RATIO_PERCENTAGE",RP9);
					record.put("REQD_QTY",reqQty[8]);
					record.put("ORDER_QTY",ordQty[8]);
					record.put("ORDER_UOM",ordQtyUOM[8]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[8]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code10)) {
					record.put("ABSOL_QTY",ord_qty10);
					record.put("RATIO_PERCENTAGE",RP10);
					record.put("REQD_QTY",reqQty[9]);
					record.put("ORDER_QTY",ordQty[9]);
					record.put("ORDER_UOM",ordQtyUOM[9]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[9]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				record.put("PRES_BY_BASE",presByBase);
				record.put("TOTAL_QTY",totalQty);
				if(presByBase.equals("S"))
					record.put("TOTAL_QTY_UOM","");
				else
					record.put("TOTAL_QTY_UOM",dosage_uom);
			}
		}
        String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

		ArrayList DrugRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable
	
		String order_format_values		= "";
		String row_value				= "";
		String catalog_code 			= "", drug_code = "";

		int seq_num = 0;

			if (drugList!=null && drugList.size() != 0) {
				for(int i=0;i<drugList.size();i++) {
					HashMap drugDetails = (HashMap)drugList.get(i);
					if (drugDetails!=null && drugDetails.size() != 0) {
						orderFormatHash	= new HashMap();	// To store it in the HashMap
						arrSeq_num		= new ArrayList();	// get the seq in ArrayList
						template		= new Hashtable();	// get the template values in the HashTable
						seq_num 		= 0;
						order_format_values	= "";
						drug_code		= (String)drugDetails.get("DRUG_CODE");
						catalog_code	= drug_code;
						row_value		= (catalog_code+"_0");
						arrSeq_num		= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);

						if(arrSeq_num!= null && arrSeq_num.size() >0) {
							int k=0;
							for(k=0;k<arrSeq_num.size();k++) {
								//seq_num		= ((Integer)arrSeq_num.get(k)).intValue();	// get the seq_num
								seq_num		= ((Integer.parseInt((String)arrSeq_num.get(k))) );
								template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
								orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
								orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
								orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
								orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
								orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
								orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
								order_format_values =order_format_values+ ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
							}
							orderFormatHash.put("order_format_count", (String.valueOf(k)));
							orderFormatHash.put("order_format_values", order_format_values);
							orderFormatHash.put("drug_code", drug_code);

						}
						else {
							orderFormatHash.put("order_format_count", "0");
							orderFormatHash.put("order_format_values", "");
							orderFormatHash.put("drug_code", drug_code);
						}
						DrugRemarks.add(orderFormatHash);
					}
			}
		}
		bean.setDrugRemarks(DrugRemarks);
		//added for NMC-JD-CRF-0063  
		
		if(beanPres.getOpDischMedInd()==null){
			bean.setOpDischMedInd("N");
		}
		if(beanPres.getOpDischMedInd()!=null){
			bean.setOpDischMedInd(beanPres.getOpDischMedInd());
		}
		if(beanPres.getTakeHomeMedicationOp()==null){
			bean.setTakeHomeMedicationOp("N");
		}
		if(beanPres.getTakeHomeMedicationOp()!=null){
			bean.setTakeHomeMedicationOp(beanPres.getTakeHomeMedicationOp()); 
		}
	
		if(beanPres.getPatient_class_tkHome().equals("IP")){
			bean.setTakeHomeMedicationOp("N");
		}	//END
		  
		HashMap returndata = bean.releaseCompoundRx();
		String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
		boolean result	= ((Boolean)returndata.get("result")).booleanValue();
		String message	= (String)returndata.get("message");
		String flag		= (String)returndata.get("flag");
		flag		= "";
		if(message==null)
			message		=	"";
		out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\", \"" + print_ord_sht_rule_ind +"\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	
		putObjectInBean(iv_bean_id,bean,request); 
		putObjectInBean(bean_id_1,pres_bean,request); 
		putObjectInBean(or_bean_id,orbean,request); 

	}
	else if(validate.equals("AMEND_RELEASE")){
		String patient_id					= (String)hash.get("patient_id");
		String encounter_id					= (String)hash.get("encounter_id");
		String dosage						= (String)hash.get("dosage");
		String freq_code					= (String)hash.get("freq_code");
		String durn_value					= (String)hash.get("durn_value");
		String durn_type					= (String)hash.get("durn_type");
		String start_date					= (String)hash.get("start_date");
		String end_date						= (String)hash.get("end_date");		
		String order_id						= (String)hash.get("order_id");
		String no_of_drugs					= (String)hash.get("no_of_drugs");
		String ord_qty1						= (String)hash.get("ord_qty1");
		String ord_qty2						= (String)hash.get("ord_qty2");
		String ord_qty3						= (String)hash.get("ord_qty3");
		String ord_qty4						= (String)hash.get("ord_qty4");
		//Added for  ML-BRU-CRF-072[Inc:29938] Start
		String DrugIndicationRemarks1		= (String)hash.get("DrugIndicationRemarks1");
		if(!DrugIndicationRemarks1.equals(""))
				DrugIndicationRemarks1 = java.net.URLDecoder.decode(DrugIndicationRemarks1,"UTF-8"); 
		String DrugIndicationRemarks2		= (String)hash.get("DrugIndicationRemarks2");
		if(!DrugIndicationRemarks2.equals(""))
				DrugIndicationRemarks2 = java.net.URLDecoder.decode(DrugIndicationRemarks2,"UTF-8"); 
		String DrugIndicationRemarks3		= (String)hash.get("DrugIndicationRemarks3");
		if(!DrugIndicationRemarks3.equals(""))
				DrugIndicationRemarks3 = java.net.URLDecoder.decode(DrugIndicationRemarks3,"UTF-8"); 
		String DrugIndicationRemarks4		= (String)hash.get("DrugIndicationRemarks4");
		if(!DrugIndicationRemarks4.equals(""))
				DrugIndicationRemarks4 = java.net.URLDecoder.decode(DrugIndicationRemarks4,"UTF-8"); 
		//Added for  ML-BRU-CRF-072[Inc:29938] End
		String drug_codes					= (String)hash.get("drug_codes");
		String amnd_drg_code				= (String)hash.get("amnd_drg_code");
		String act_patient_class			= (String)hash.get("act_patient_class");
		String discharge_yn					= (String)hash.get("discharge_yn");
		String narcotic_yn		= request.getParameter("narcotic_yn");	

		if(discharge_yn.equals("Y")){act_patient_class ="OP";}

		String external_dosage_override_reason1	= (String)hash.get("external_dosage_override_reason1");
		String external_dosage_override_reason2	= (String)hash.get("external_dosage_override_reason2");
		String external_dosage_override_reason3	= (String)hash.get("external_dosage_override_reason3");
		String external_dosage_override_reason4	= (String)hash.get("external_dosage_override_reason4");
        String pract_id				  =	(String)hash.get("pract_id")==null?"":(String)hash.get("pract_id");
        String resp_id				  =	(String)hash.get("resp_id")==null?"":(String)hash.get("resp_id");

		String iv_bean_id					= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name					= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean				= (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name, request);

		String bean_id_1					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name_1					= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean		= (PrescriptionBean_1)getBeanObject( bean_id_1, bean_name_1 , request);

		bean.setAmendRemarks((String)pres_bean.getPresRemarks());
		bean.setDrugDetails(drug_codes,pract_id,resp_id,"","","","");  //CRF-0062 

		bean.setPatientClass(act_patient_class);
		bean.setOrderID(order_id);

		HashMap recd=new HashMap();
			recd.put("FREQ_CODE",freq_code);
			recd.put("DURN_VALUE",durn_value);
			if(!bean.getLanguageId().equals("en")){
				recd.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",bean.getLanguageId(),"en"));
				recd.put("END_DATE",com.ehis.util.DateUtils.convertDate(end_date,"DMYHM",bean.getLanguageId(),"en"));
			}
			else{
				recd.put("START_DATE",start_date);
				recd.put("END_DATE",end_date);
			}
			recd.put("DOSAGE",dosage);
			recd.put("ORDER_ID",order_id);
			recd.put("DURN_TYPE",durn_type);
			recd.put("DRUG_CODE",amnd_drg_code);				
			recd.put("NO_OF_DRUGS",no_of_drugs);
			recd.put("ORD_QTY1",ord_qty1);
			recd.put("ORD_QTY2",ord_qty2);
			recd.put("ORD_QTY3",ord_qty3);
			recd.put("ORD_QTY4",ord_qty4);
			//Added for  ML-BRU-CRF-072[Inc:29938] Start
			recd.put("DRUG_INDICATION",DrugIndicationRemarks1);
			recd.put("DRUG_INDICATION",DrugIndicationRemarks2);
			recd.put("DRUG_INDICATION",DrugIndicationRemarks3);
			recd.put("DRUG_INDICATION",DrugIndicationRemarks4);
			//Added for  ML-BRU-CRF-072[Inc:29938] End
			recd.put("EXTERNAL_DOSAGE_OVERRIDE_REASON1",external_dosage_override_reason1);
			recd.put("EXTERNAL_DOSAGE_OVERRIDE_REASON2",external_dosage_override_reason2);
			recd.put("EXTERNAL_DOSAGE_OVERRIDE_REASON3",external_dosage_override_reason3);
			recd.put("EXTERNAL_DOSAGE_OVERRIDE_REASON4",external_dosage_override_reason4);

			ArrayList drugList	= bean.getDrugDetails();

			String or_bean_name		= "eOR.OrderEntryBean";
			String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
			
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

			ArrayList DrugRemarks	= new ArrayList();
			HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
			ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
			Hashtable template		= new Hashtable();	// get the template values in the HashTable
		
			String order_format_values		= "";
			String row_value				= "";
			String catalog_code 			= "", drug_code = "";


			int seq_num = 0;
			if (drugList!=null && drugList.size() >0) {

				for(int i=0;i<drugList.size();i++) {
					HashMap drugDetails = (HashMap)drugList.get(i);
					if (drugDetails!=null && drugDetails.size() != 0) {
						orderFormatHash	= new HashMap();	// To store it in the HashMap
						arrSeq_num		= new ArrayList();	// get the seq in ArrayList
						template		= new Hashtable();	// get the template values in the HashTable
						seq_num 		= 0;
						order_format_values	= "";
						drug_code		= (String)drugDetails.get("DRUG_CODE");
						catalog_code	= drug_code;
						row_value		= (catalog_code+"_0");

						arrSeq_num		= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);

						if(arrSeq_num!= null && arrSeq_num.size() >0) {
							int k=0;
							for(k=0;k<arrSeq_num.size();k++) {
								//seq_num		= ((Integer)arrSeq_num.get(k)).intValue();	// get the seq_num
								seq_num		= ((Integer.parseInt((String)arrSeq_num.get(k))) );

								template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
								orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
								orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
								orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
								orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
								orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
								orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
								order_format_values =order_format_values+ ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
							}
							orderFormatHash.put("order_format_count", (String.valueOf(k)));
							orderFormatHash.put("order_format_values", order_format_values);
							orderFormatHash.put("drug_code", drug_code);

						}
						else {
							orderFormatHash.put("order_format_count", "0");
							orderFormatHash.put("order_format_values", "");
							orderFormatHash.put("drug_code", drug_code);
						}
						DrugRemarks.add(orderFormatHash);
					}
				}
			}
			bean.setDrugRemarks(DrugRemarks);

		   	HashMap returndata =  bean.releaseAmendCompoundRx(recd); 
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			boolean result	= ((Boolean)returndata.get("result")).booleanValue();
			String message	= (String)returndata.get("message");
			String flag		= (String)returndata.get("flag");
			//String msgid    = (String)returndata.get("msgid");
			flag			= "";
			if(message==null)
				message		=	"";
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\", \"" + print_ord_sht_rule_ind +"\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0

		putObjectInBean(iv_bean_id,bean,request); 
		putObjectInBean(bean_id_1,pres_bean,request); 
	}
	else if (validate.equals("AUTOSCHEDULE")) {

		Hashtable schedule_val	=	new Hashtable();
		ArrayList schedule		= null;
		Hashtable sch_output	= null;
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");

		String iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;

		String start_date		= request.getParameter("start_date");
		String qty_value		= request.getParameter("qty_value");
		String freq_code		= request.getParameter("freq_code");
		String drug_code		= request.getParameter("drug_code");
		
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";		
		if(!iv_bean.checkPreScheduled(freq_code).equals("0") && iv_bean.getScheduledFreqYN(freq_code)) {
			schedule	=	(ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");

				if(schedule.size()==0) {

					ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name ,request);
					schedule_bean.setLanguageId(iv_bean.getLanguageId());
					schedule_val.put("facility_id", (String)session.getValue("facility_id"));
					schedule_val.put("start_time_day_param", start_date);
					schedule_val.put("module_id", "PH"); 
					schedule_val.put("split_dose_yn", "N"); 
					schedule_val.put("split_qty",qty_value);
					schedule_val.put("freq_code",  freq_code );
					schedule_val.put("code",drug_code);
					sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
					sch_output.put("code",drug_code);
					sch_output.put("row_value","1");				
					iv_bean.setScheduleFrequencyStr(sch_output);
				   putObjectInBean(sch_bean_id,schedule_bean,request); 	
				} 
                HashMap chkValuescheduleFrequency	=	null;
                ArrayList frequencyValues	        =	null;
                chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();
				if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
	              frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code);
		        }

			   //HashMap data		=	null;
			   ArrayList dose_list	=	null;
		       String att			=	null;
		       String adm_time		=	"";
		       String adm_qty		=	"";
		       String total_qty	    =   "";			   
			   String tooltiptable		= "";
				if(frequencyValues!=null && frequencyValues.size()>0){
					
					/*adm_time=adm_time+"<tr>";					
					for(int i=0;i<frequencyValues.size();i++){
						data=(HashMap)frequencyValues.get(i);
						att="align=center class=TIP";
						adm_time=adm_time+"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
					}
					adm_time=adm_time+"</tr>";

					adm_qty=adm_qty+"<tr>";
					for(int i=0;i<frequencyValues.size();i++){
						att="align=center class=TIP";
						data=(HashMap)frequencyValues.get(i);
						adm_qty=adm_qty+"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
						total_qty=(String) data.get("admin_qty");
					}
					adm_qty=adm_qty+"</tr>";*/
					dose_list	= (ArrayList)frequencyValues.get(4);
					for(int tqI=0;tqI<dose_list.size();tqI++){						
						total_qty	=	(String)dose_list.get(tqI);
					}
					tooltiptable = (String)iv_bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
					
					adm_time = tooltiptable;
					boolean split_chk	=	iv_bean.checkSplit(frequencyValues);					
					out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"')");

			}
		}
	putObjectInBean(iv_bean_id,iv_bean,request); 
	
	}else if (validate.equals("AUTOSCHEDULE1")) {

	   	String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");
		String drug_code		= request.getParameter("drug_code");

		String iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

		HashMap chkValuescheduleFrequency	=	null;
        ArrayList frequencyValues	        =	null;
        chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency(); 

        if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
	           frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code);
		}

        //HashMap data		    =	null;
		ArrayList dose_list	=	null;
		String att			=	null;
		String adm_time		=	"";
		String adm_qty		=	"";
		String total_qty	=   "";
		String tooltiptable	=	"";
		if(frequencyValues!=null && frequencyValues.size()>0){
			/*adm_time=adm_time+"<tr>";					
			for(int i=0;i<frequencyValues.size();i++){
				data=(HashMap)frequencyValues.get(i);
				att="align=center class=TIP";
				adm_time=adm_time+"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
			}
			adm_time=adm_time+"</tr>";

			adm_qty=adm_qty+"<tr>";
			for(int i=0;i<frequencyValues.size();i++){
				att="align=center class=TIP";
				data=(HashMap)frequencyValues.get(i);
				adm_qty=adm_qty+"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
				total_qty=(String) data.get("admin_qty");
			}
			adm_qty=adm_qty+"</tr>";*/
			dose_list	= (ArrayList)frequencyValues.get(4);
			for(int tqI=0;tqI<dose_list.size();tqI++){						
				total_qty	=	(String)dose_list.get(tqI);
			}
			tooltiptable = (String)iv_bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
			adm_time = tooltiptable;
			boolean split_chk	=	iv_bean.checkSplit(frequencyValues);
			out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"')");
        }
		putObjectInBean(iv_bean_id,iv_bean,request); 
	}else if (validate.equals("DELETESCHEDULE")) {

		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");
		

		String iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		String drug_code		= request.getParameter("drug_code");
		iv_bean.clearscheduleFrequency(drug_code);
		iv_bean.resetscheduleFrequency();
		putObjectInBean(iv_bean_id,iv_bean,request); 			
	}else if(validate.equals("REMARKS")) {
        String drug_code    = request.getParameter("drug_code");
		String patient_id	= request.getParameter( "patient_id" );
		String encounter_id	= request.getParameter( "encounter_id" );
		String mode			= request.getParameter( "mode" );
		String rec_no			= request.getParameter( "rec_no" );
		String click_yn			= request.getParameter( "click_yn" )==null?"N":request.getParameter( "click_yn" );
		if(mode == null) mode="";
		
		String order_type	="";
		String route_code	="";
		String form_code	="";
		String iv_bean_id	= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name	= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name,request);
		HashMap drug_dtls=new HashMap();
		drug_dtls=(HashMap)bean.getDrugDtls(drug_code);
		if(drug_dtls != null){
		    order_type		=(String)drug_dtls.get("ORDER_TYPE_CODE");
		    route_code		=(String)drug_dtls.get("ROUTE_CODE");
		    form_code		=(String)drug_dtls.get("FORM_CODE");
		}
		String order_category	= "PH";
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
		//eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		String order_catalog_code	= drug_code;
		String format_id			= bean.getFormatId(order_category, order_type, order_catalog_code);
		/*ArrayList pres_values		= bean.getPresValues(form_code, route_code,order_catalog_code);
		out.println("clearArray()");
		for(int i=0; i<pres_values.size(); i++)	{
			out.println("prescriptionValues(\""+(String)pres_values.get(i)+"\")");
		}
		if(!mode.equals("new")){
			out.println("validateRemarksAmend('"+format_id+"')");
		}else{*/
		out.println("validateRemarks('" + format_id + "','" + drug_code + "','"+form_code+"','"+route_code+"','"+rec_no+"','"+click_yn+"')"); 
		//}
		putObjectInBean(iv_bean_id,bean,request); 
		putObjectInBean(or_bean_id,orbean,request); 
	}
	else if(validate!= null && validate.equals("PRINT")){

		String patient_id			= (String) hash.get( "patient_id" );
		String encounter_id			= (String) hash.get( "encounter_id" );
		String print_yn				= (String) hash.get( "print_yn" );
		String patient_class		= (String) hash.get( "patient_class" );
		String mode					= (String) hash.get( "mode" );
		String prescriptionPrint	= (String) hash.get( "prescriptionPrint" );
		String NarcoticPrint		= (String) hash.get( "NarcoticPrint" );

		if(mode == null) mode = "";
		String act_patient_class= (String) hash.get( "act_patient_class" );
		if(act_patient_class == null) act_patient_class = "";
		if(mode.equals("amend")){patient_class = act_patient_class;}

		String iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name, request);

		String order_id			= bean.getOrderID();

		
//		if(print_yn.equals("Y")){
		if(prescriptionPrint.equals("Y")){
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports();
			ecis.utils.OnlineReport report1			= new ecis.utils.OnlineReport(facility_id, "PH", "PHPRDPRESCOMP");

			report1.addParameter("p_facility_id", facility_id);
			report1.addParameter("p_module_id", "PH");
			report1.addParameter("p_report_id","PHPRDPRESCOMP");
			report1.addParameter("p_order_id", order_id);
			report1.addParameter("p_patclass", patient_class);
			report1.addParameter("p_user_name", login_user);
			report1.addParameter("p_language_id", bean.getLanguageId());
			report1.addParameter("p_patient_id", patient_id);//code added for SKR-SCF-0915[IN046734]
			onlineReports.add(report1);
			String ReportOutput = onlineReports.execute((HttpServletRequest)request, (HttpServletResponse)response);
		}
		if((NarcoticPrint.toUpperCase()).equals("Y")){
           ArrayList narcotic_nos = (ArrayList)bean.getNarc_nos(order_id);
			for(int i=0;i<narcotic_nos.size();i++){
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( facility_id, "PH", "PHRNARFORM") ;
			
				report2.addParameter("p_report_id", "PHRNARFORM") ;					
				report2.addParameter("P_LANGUAGE_ID", bean.getLanguageId()) ;
				report2.addParameter("P_FACILITY_ID", facility_id) ;
				report2.addParameter("P_NARCOTIC_NO",(String)narcotic_nos.get(i)) ;
				report2.addParameter("P_REPRINT", "N") ;
				report2.addParameter("p_patient_id", patient_id) ;//code added for SKR-SCF-0915[IN046734]
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
			}
		}
		putObjectInBean(iv_bean_id,bean,request); 
	}
	else if(validate.equals("OVERRIDEREMARKS")){
		String drugCode         = request.getParameter("drug_code");
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");

		String drug_db_interface_yn		= request.getParameter("drug_db_interface_yn");
		String drug_db_allergy_flag		= request.getParameter("drug_db_allergy_flag");
		String drug_db_duptherapy_flag	= request.getParameter("drug_db_duptherapy_flag");
		String drug_db_dosecheck_yn		= request.getParameter("drug_db_dosecheck_yn");//added for ML-MMOH-CRF-1408

		String iv_bean_id		= "IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

		//String strength				= "";
		//String strength_uom			= "";
		//String dosage				= "";
		//String dosage_uom			= "";
		//String freq_code			= "";
		//String form_desc			= "";
		String allergy_override		= "";
		String dose_override		= "";
		String currentrx_override	= "";
		//String stock_uom			= "";
		String generic_id			= "";
		String generic_name			= "";
		String drug_desc			= "";
		String daily_dose			= "";
		String unit_dose			= "";
		String mono_graph			= "";
		String limit_ind			= "";
		String allergy_yn			= "";
		String current_rx			= "";
		String drug_code			= "";
		String srl_no				= "";
		String allergy_remarks		= "";
		String dose_remarks			= "";
		String currentrx_remarks	= "";
		String min_unit_dose		= "";
		String min_daily_dose		= "";
		//added for ML-MMOH-CRF-1408 - start
		String max_daily_celing_dose = "";
		String min_daily_ceiling_dose = "";
		String max_unit_ceiling_dose = "";
		String min_unit_ceiling_dose = "";
		String dosage_unit	     = "";
		String dose_unit_desc	     = "";
		String dose_unit_desc1	     = "";
		String dosage_std			 = "";
		//added for ML-MMOH-CRF-1408 - end
		//Added for IN:072715 start
		String allergy_remarks_code="";
		String dose_remarks_code="";
		String currentrx_remarks_code="";
		//Added for IN:072715 end
		ArrayList drugDetails	= iv_bean.getDrugDetails();

		for(int i=0; i<drugDetails.size(); i++){
			HashMap hm = (HashMap)drugDetails.get(i);

			if(hm.get("DRUG_CODE").equals(drugCode)){

				//strength				= (String)hm.get("STRENGTH_VALUE");
				//strength_uom			= (String)hm.get("STRENGTH_UOM");
				//dosage					= (String)hm.get("QTY_VALUE");
				//dosage_uom				= (String)hm.get("QTY_UOM");
				//freq_code				= (String)hm.get("FREQ_CODE");
				//form_desc				= (String)hm.get("FORM_DESC");
				allergy_override		= (String)hm.get("ALLERGY_OVERRIDE");
				dose_override			= (String)hm.get("DOSE_OVERRIDE");
				currentrx_override		= (String)hm.get("CURRENTRX_OVERRIDE");
				//stock_uom				=	iv_bean.getStockUOM((String)hm.get("DRUG_CODE"));

				generic_id				= (String)hm.get("GENERIC_ID");
				generic_name			= (String)hm.get("GENERIC_NAME");
				drug_desc				= (String)hm.get("DRUG_DESC");
				daily_dose				= (String)hm.get("DAILY_DOSE");
				unit_dose				= (String)hm.get("UNIT_DOSE");
				mono_graph				= (String)hm.get("MONO_GRAPH");
				limit_ind				= (String)hm.get("LIMIT_IND");
				allergy_yn				= (String)hm.get("ALLERGY_YN");
				current_rx				= (String)hm.get("CURRENT_RX");
				drug_code				= (String)hm.get("DRUG_CODE");
				srl_no					= (String)hm.get("SRL_NO");
				allergy_remarks			= (String)hm.get("ALLERGY_REMARKS");
				dose_remarks			= (String)hm.get("DOSE_REMARKS");
				currentrx_remarks		= (String)hm.get("CURRENTRX_REMARKS");
				//Added for IN:072715 start
				allergy_remarks_code			= (String)hm.get("ALLERGY_REMARKS_CODE")==null?"":(String)hm.get("ALLERGY_REMARKS_CODE");
				dose_remarks_code			= (String)hm.get("DOSE_REMARKS_CODE")==null?"":(String)hm.get("DOSE_REMARKS_CODE");
				currentrx_remarks_code		= (String)hm.get("CURRENTRX_REMARKS_CODE")==null?"":(String)hm.get("CURRENTRX_REMARKS_CODE");
				//Added for IN:072715 end
				min_unit_dose			= (String)hm.get("MIN_UNIT_DOSE");
				min_daily_dose			= (String)hm.get("MIN_DAILY_DOSE");
				currentrx_remarks		= java.net.URLEncoder.encode(currentrx_remarks,"UTF-8");
			//added for ML-MMOH-CRF-1408 - start
				max_daily_celing_dose	= (String)hm.get("MAX_DAILY_CEELING_DOSE");
				min_daily_ceiling_dose  = (String)hm.get("MIN_DAILY_CEELING_DOSE");
				max_unit_ceiling_dose	= (String)hm.get("MAX_UNIT_CEELING_DOSE");
				min_unit_ceiling_dose   = (String)hm.get("MIN_UNIT_CEELING_DOSE");
				dosage_std				= (String)hm.get("DOSAGE_STD");
				dosage_unit			  = hm.get("DOSAGE_UNIT")==null?"":(String)hm.get("DOSAGE_UNIT");
 						if(!dosage_unit.equals("")){ 
						   dose_unit_desc      = iv_bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit);
						   dose_unit_desc1 =dose_unit_desc;
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = iv_bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
	 						 dose_unit_desc1= dose_unit_desc;
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
	 						} 
 						}
			} //added for ML-MMOH-CRF-1408 - end
		}
		if(limit_ind==null) // addded for ML-MMOH-CRF-1408
			limit_ind="";
		if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){							out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"')");
		
		// encoding and decoding  is added for drug_desc  IN062487
		drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
			out.println("showOverRideRemarks('"+patient_id+"','"+encounter_id+"','"+generic_id+"','"+generic_name+"','"+drug_desc+"','"+daily_dose+"','"+unit_dose+"','"+java.net.URLEncoder.encode(mono_graph,"UTF-8")+"','"+limit_ind+"','"+allergy_yn+"','"+current_rx+"','"+drug_code+"','"+srl_no+"','"+allergy_remarks+"','"+dose_remarks+"','"+currentrx_remarks+"','"+min_unit_dose+"','"+min_daily_dose+"','"+drug_db_interface_yn+"','"+drug_db_allergy_flag+"','"+drug_db_duptherapy_flag+"','"+dosage_std+"','"+max_daily_celing_dose+"','"+min_daily_ceiling_dose+"','"+max_unit_ceiling_dose+"','"+min_unit_ceiling_dose+"','"+dose_unit_desc+"','"+dose_unit_desc1+"','"+drug_db_dosecheck_yn+"','"+allergy_remarks_code+"','"+dose_remarks_code+"','"+currentrx_remarks_code+"')");// Modified for IN:072715
			//modified for ML-MMOH-CRF-1408 and encode( added for mono_graph ML-MMOH-CRF-1408 and drug_db_dosecheck_yn added for ML-MMOH-CRF-1408
		}
		putObjectInBean(iv_bean_id,iv_bean,request); 
	}
	else if(validate!= null && validate.equals("override_reason")) {

			String drugCode		= (String)hash.get("drug_code");
			//String srlNo		= (String)hash.get("srl_no");
			String allergy_yn	= (String)hash.get("allergy_yn");
			String limit_ind	= (String)hash.get("limit_ind");
			String current_rx	= (String)hash.get("current_rx");
			String allergy		=	"";
			String exceed_dose	=	"";
			String dup_drug		=	"";
			String dose_remarks_code = "", allergy_remarks_code = "", dup_drug_remarks_code = "";//Added for IN:072715 

			String iv_bean_id	= (String)hash.get("bean_id");
			String iv_bean_name	= (String)hash.get("bean_name");

			IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
			// Modified for IN:072715 START
			if(allergy_yn.equals("Y")){
				allergy				= java.net.URLDecoder.decode((String)hash.get("allergy")==null?"":(String)hash.get("allergy"),"UTF-8");
				allergy_remarks_code				= java.net.URLDecoder.decode((String)hash.get("allergy_remarks_code")==null?"":(String)hash.get("allergy_remarks_code"),"UTF-8");
			}
			
			if(limit_ind.equals("N")){
				exceed_dose			= java.net.URLDecoder.decode((String)hash.get("exceed_dose")==null?"":(String)hash.get("exceed_dose"),"UTF-8");
				dose_remarks_code			= java.net.URLDecoder.decode((String)hash.get("dose_remarks_code")==null?"":(String)hash.get("dose_remarks_code"),"UTF-8");
			}
			if(current_rx.equals("Y")){
				dup_drug			= java.net.URLDecoder.decode((String)hash.get("dup_drug")==null?"":(String)hash.get("dup_drug"),"UTF-8");
				dup_drug_remarks_code			= java.net.URLDecoder.decode((String)hash.get("dup_drug_remarks_code")==null?"":(String)hash.get("dup_drug_remarks_code"),"UTF-8");
			}
			// Modified for IN:072715 end
			ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();

			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			for(int j=0;j<prescriptionDetails.size();j++){
				 ext_drugData	=(HashMap) prescriptionDetails.get(j);
				 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				 ext_srl_no		=(String) ext_drugData.get("SRL_NO");
	//&& srlNo.equals(ext_srl_no)	

				if( drugCode.equals(ext_drug_code) ){
					if(!allergy.equals("") ) {
						ext_drugData.put("ALLERGY_REMARKS",allergy);
						ext_drugData.put("ALLERGY_OVERRIDE","Y");
						ext_drugData.put("ALLERGY_REMARKS_CODE",allergy_remarks_code);//Added for IN:072715
					}

					if(!exceed_dose.equals("")) {
						ext_drugData.put("DOSE_REMARKS",exceed_dose);
						ext_drugData.put("DOSE_OVERRIDE","Y");
						ext_drugData.put("DOSE_REMARKS_CODE",dose_remarks_code);//Added for IN:072715
					}

					if(!dup_drug.equals("")) {
						ext_drugData.put("CURRENTRX_REMARKS",dup_drug);
						ext_drugData.put("CURRENTRX_OVERRIDE","Y");
						ext_drugData.put("CURRENTRX_REMARKS_CODE",dup_drug_remarks_code);//Added for IN:072715
					}
					break;
				}
			}
		// objects nullified after usage
		putObjectInBean(iv_bean_id,bean,request); 
		prescriptionDetails	=	null;
		ext_drugData		=	null;
	}
	else if(validate!= null && validate.equals("DELETEDRUG")) {
		String drug_code    = request.getParameter("drug_code"); 
		String iv_bean_id	= request.getParameter("bean_id");
		String iv_bean_name	= request.getParameter("bean_name");
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

		ArrayList drugDetails = iv_bean.getDrugDetails();
		HashMap   drgDtls   = null;
		for(int i = 0; i<drugDetails.size();i++){
			drgDtls = (HashMap)drugDetails.get(i);
			
			if(drgDtls.get("DRUG_CODE").equals(drug_code)){
				drugDetails.remove(i);				
			}
		}
		putObjectInBean(iv_bean_id,iv_bean,request); 
	}
	else if(validate!= null && validate.equals("DELETE_ALL_DRUGs")) {

		String iv_bean_id	= request.getParameter("bean_id");
		String iv_bean_name	= request.getParameter("bean_name");
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

		ArrayList drugDetails = iv_bean.getDrugDetails();
		for(int i = 0; i<drugDetails.size();i++){
			drugDetails.remove(i);				
		}
		drugDetails.clear();

		putObjectInBean(iv_bean_id,iv_bean,request); 
	}
	else if(validate != null && validate.equals("InsertExternalOverrideReason")){
		 
		 String drug_code				 =	(String) hash.get( "drug_code" );
		 String srl_no					 =	(String) hash.get( "srl_no" );
		 String External_Dosage_Override_Reason			= (String)hash.get("External_Dosage_Override_Reason");
		 String External_Duplicate_Override_Reason		= (String)hash.get("External_Duplicate_Override_Reason");
		 String External_Interaction_Override_Reason	= (String)hash.get("External_Interaction_Override_Reason");
		 String External_Contra_Override_Reason			= (String)hash.get("External_Contra_Override_Reason");
		 String External_Alergy_Override_Reason			= (String)hash.get("External_Alergy_Override_Reason");

		 String EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN	=(String)hash.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
		 String EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		=(String)hash.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
		 String EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		=(String)hash.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
		 String EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN	=(String)hash.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
		 String EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	=(String)hash.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN");
//Added UTF==for FDB Reasons regarding incident num:24708 on 27/10/2010====By Sandhya
		 if(!External_Dosage_Override_Reason.equals("")&& External_Dosage_Override_Reason!=null){
			External_Dosage_Override_Reason	=	java.net.URLDecoder.decode(External_Dosage_Override_Reason);
			
		 }
		 if(!External_Duplicate_Override_Reason.equals("")&&External_Duplicate_Override_Reason!=null){
			External_Duplicate_Override_Reason	=	java.net.URLDecoder.decode(External_Duplicate_Override_Reason,"UTF-8");
		 }
		 if(!External_Interaction_Override_Reason.equals("")&&External_Interaction_Override_Reason!=null){
			External_Interaction_Override_Reason	=	java.net.URLDecoder.decode(External_Interaction_Override_Reason,"UTF-8");

		 }
		 if(!External_Contra_Override_Reason.equals("")&&External_Contra_Override_Reason!=null){
			External_Contra_Override_Reason	=	java.net.URLDecoder.decode(External_Contra_Override_Reason,"UTF-8");
		
		 }
		 if(!External_Alergy_Override_Reason.equals("")&&External_Alergy_Override_Reason!=null){
			External_Alergy_Override_Reason	=	java.net.URLDecoder.decode(External_Alergy_Override_Reason,"UTF-8");
	 }

		 String iv_bean_id				= request.getParameter("bean_id");
		 String iv_bean_name			= request.getParameter("bean_name");
		 IVPrescriptionBean iv_bean		= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;


		 ArrayList drugDetails			= iv_bean.getDrugDetails();

		 HashMap   drgDtls				= null;
		 for(int i = 0; i<drugDetails.size();i++){
			drgDtls = (HashMap)drugDetails.get(i);
			
			if(drgDtls.get("DRUG_CODE").equals(drug_code)&& drgDtls.get("SRL_NO").equals(srl_no)){
				//drgDtls.put("EXTERNAL_OVERRIDE_REASON",External_Override_Reason);
				drgDtls.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",External_Dosage_Override_Reason);
				drgDtls.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",External_Duplicate_Override_Reason);
				drgDtls.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",External_Interaction_Override_Reason);
				drgDtls.put("EXTERNAL_CONTRA_OVERRIDE_REASON",External_Contra_Override_Reason);
				drgDtls.put("EXTERNAL_ALERGY_OVERRIDE_REASON",External_Alergy_Override_Reason);

				drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN);
				drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN);
				drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN);
				drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN);
				drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN);
				break;

			}
		}
		out.println("HideFDBOverrideImage('"+srl_no+"')");
		putObjectInBean(iv_bean_id,iv_bean,request);
	}
	else if(validate != null && validate.equals("External_Dosage_Check")){
		String iv_bean_id				= request.getParameter("bean_id");
		String iv_bean_name			= request.getParameter("bean_name");
		IVPrescriptionBean iv_bean		= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		String ext_beanid					 = "@ExternalProductLinkBean";
		String ext_beanname			     = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
		ArrayList drugDetails			= (ArrayList)iv_bean.getDrugDetails();  
		String patient_id				= (String)hash.get( "patient_id" );
		String weight					= (String)hash.get( "weight" )==null?"0":(String) hash.get( "weight" );
		String bsa						= (String)hash.get( "bsa" )==null?"0":(String) hash.get( "bsa" );
		String freq_code				= (String)hash.get( "frequency" );
		String duration				= (String)hash.get( "duration" );
		String dosage_1				= (String)hash.get( "dosage_1" );
		String dosage_2				= (String)hash.get( "dosage_2" );
		String dosage_3				= (String)hash.get( "dosage_3" );
		String dosage_4				= (String)hash.get( "dosage_4" );
		String dosage_5				= (String)hash.get( "dosage_5" );
		String dosage_6				= (String)hash.get( "dosage_6" );
		String dosage_7				= (String)hash.get( "dosage_7" );
		String dosage_8				= (String)hash.get( "dosage_8" );
		String dosage_9				= (String)hash.get( "dosage_9" );
		String dosage_10				= (String)hash.get( "dosage_10" );
		HashMap freq_vals              = (HashMap)iv_bean.freqValidate(freq_code);
		String interval_value          = (String)freq_vals.get("interval_value");
		String repeat_value            = (String)freq_vals.get("repeat_value");

		String frequency				= (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
		String dose					= "";
		String external_product_id	    = "";
		String pres_base_uom           = "";
		String drug_code				= "";	
		String srl_no					= "";
		String ext_override_reason     = "";
		String drug_db_interface_yn    = request.getParameter("drug_db_interface_yn");

		String durn_type_desc		= (String)hash.get( "durn_type_desc" ); // added for IN2487 - to calculate dose qty based on frequency --19/10/2010-- priya -start
		String repeat_durn_type		=	(String)freq_vals.get("repeat_durn_type"); 
		String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );// Added in January 2014 for CIMS dosage check -start
		String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end
		String tmp_durn_value			= ""; 
		if(!(durn_type_desc.equals("D")) && repeat_durn_type.equals("D")){
			if(durn_type_desc.equals("W")){
				duration = (Integer.parseInt(duration) * 7)+"";
			}
			if(durn_type_desc.equals("L")){
				duration = (Integer.parseInt(duration)*30)+"";
			}
			if(durn_type_desc.equals("Y")){
				duration = (Integer.parseInt(duration)*365)+"";
			}
		} // added for IN2487 - to calculate dose qty based on frequency --19/10/2010-- priya -end

		HashMap   drgDtls				= null;
		ArrayList dosageCheckParams   = null;
		for(int i = 0; i<drugDetails.size();i++){
			external_product_id	    = ""; 
			pres_base_uom           = ""; 
			drgDtls    =   (HashMap)drugDetails.get(i);
			switch(i){// added if conditions in below switch cases for IN2487 - to calculate dose qty based on frequency --19/10/2010-- priya
				case 0: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_1)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_1;
					break;

				case 1: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_2)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						 dose=dosage_2;
					break;

				case 2: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_3)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_3;
					break;

				case 3: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_4)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_4;
					break;
				
				case 4: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_5)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_5;
					break;

				case 5: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_6)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_6;
					break;
				
				case 6: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_7)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_7;
					break;

				case 7: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_8)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_8;
					break;

				case 8: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_9)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_9;
					break;

				case 9: 
					if(repeat_durn_type.equals("D")){
						dose = (Float.parseFloat(dosage_10)/(Integer.parseInt(repeat_value) * Integer.parseInt(duration)))+"";
					}
					else
						dose=dosage_10;
					break;
			}

			//For formatting to 4 decimal places
			/*	DecimalFormat df = new DecimalFormat("0.0000");
			//df.setMinimumFractionDigits(2) ;
			df.setMinimumIntegerDigits(1);
			dose = df.format(Double.parseDouble(dose)); */

                 //if(!dose.equals("")&& dose!=null&&((String)drgDtls.get("PERFORM_EXTERNAL_DATABASE_CHECKS")).equals("Y")){
			 if(!dose.equals("")&& dose!=null&&drug_db_interface_yn.equals("Y")) {
				external_product_id	 = (String)drgDtls.get("EXTERNAL_PRODUCT_ID"); 
				pres_base_uom           = (String)drgDtls.get("PRES_BASE_UOM"); 
				drug_code				 = (String)drgDtls.get("DRUG_CODE"); 
				srl_no					 = (String)drgDtls.get("SRL_NO"); 
				ext_override_reason     = (String)drgDtls.get("EXTERNAL_OVERRIDE_REASON");
				String route_code	= (String)drgDtls.get("route_code")==null?"":(String) drgDtls.get( "route_code" );// Added in January 2014 for CIMS dosage check -start
				HashMap drugDosageResult = new HashMap();
				dosageCheckParams        = new ArrayList();
				dosageCheckParams.add(patient_id);
				dosageCheckParams.add(external_product_id);
				dosageCheckParams.add(weight);
				dosageCheckParams.add(bsa);
				dosageCheckParams.add(dose);
				dosageCheckParams.add(pres_base_uom);
				dosageCheckParams.add(frequency);
				dosageCheckParams.add(duration);
				dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
				dosageCheckParams.add(repeat_durn_type);	
				if(freq_nature!=null && !freq_nature.equals(""))
					 freq_nature_pas =  freq_nature;
				dosageCheckParams.add(freq_nature_pas);	 
				dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
				//Store Drug ids
				//drugDosageResult = beanex.getDrugDosageCheck(dosageCheckParams);
				ArrayList reqChecks = new ArrayList();
				reqChecks.add("Y"); //Dosage Check 
				reqChecks.add("N"); //Duplicate Check
				reqChecks.add("N"); //DrugInteraction
				reqChecks.add("N"); //Contra Indication
				reqChecks.add("N"); //AllergyCheck
				HashMap drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, external_product_id, patient_id, "", null ,null, dosageCheckParams, "N", "", ""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				String drug_db_dose_check_flag="N";
				if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
					drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
					if(drugDosageResult != null && drugDosageResult.size() > 0){
						beanex.setDosageCheck(external_product_id, srl_no,drugDosageResult);
						drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","Y");
						//out.println("DisplayFDBOverrideImage('"+srl_no+"','DOSAGE');");				
						out.println("DisplayFDBOverrideImage('"+(i+1)+"','DOSAGE');");// code added by rawther for scf 6572 
					}
				}
				if(drug_db_dose_check_flag.equals("N")){
					drugDosageResult =beanex.getDosageCheck(external_product_id, srl_no);
					if(drugDosageResult != null && drugDosageResult.containsKey(external_product_id)){
						beanex.removeDosageCheck(external_product_id, srl_no);
					}
					drgDtls.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
					out.println("HideFDBOverrideImage('"+srl_no+"','DOSAGE');");
				}
			}			   
		}
		putObjectInBean(ext_beanid,beanex,request);
        putObjectInBean(iv_bean_id,iv_bean,request);         
	}
	else if (validate!= null && validate.equals("GET_TRNGROUPREF")){
		String iv_bean_id				= request.getParameter("bean_id");
		String iv_bean_name				= request.getParameter("bean_name");
		IVPrescriptionBean iv_bean		= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

		String tokens_generated_yn = iv_bean.getTokensGeneratedYN();
		String trn_group_ref = "";
		if(tokens_generated_yn.equals("Y")){
			trn_group_ref = iv_bean.getTrnGroupRef();
		}
		out.println(trn_group_ref);
	}
	else if (validate!= null && validate.equals("SAVE_QTYDETAILS")){
		String iv_bean_id				= request.getParameter("bean_id");
		String iv_bean_name				= request.getParameter("bean_name");
		IVPrescriptionBean iv_bean		= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request);

		String drug_code1 = (String)hash.get("drug_code1")==null?"":(String)hash.get("drug_code1");
		String drug_code2 = (String)hash.get("drug_code2")==null?"":(String)hash.get("drug_code2");
		String drug_code3 = (String)hash.get("drug_code3")==null?"":(String)hash.get("drug_code3");
		String drug_code4 = (String)hash.get("drug_code4")==null?"":(String)hash.get("drug_code4");
		String drug_code5 = (String)hash.get("drug_code5")==null?"":(String)hash.get("drug_code5");
		String drug_code6 = (String)hash.get("drug_code6")==null?"":(String)hash.get("drug_code6");
		String drug_code7 = (String)hash.get("drug_code7")==null?"":(String)hash.get("drug_code7");
		String drug_code8 = (String)hash.get("drug_code8")==null?"":(String)hash.get("drug_code8");
		String drug_code9 = (String)hash.get("drug_code9")==null?"":(String)hash.get("drug_code9");
		String drug_code10 = (String)hash.get("drug_code10")==null?"":(String)hash.get("drug_code10");
		String absol_qty1 = (String)hash.get("absol_qty1")==null?"":(String)hash.get("absol_qty1");
		String absol_qty2 = (String)hash.get("absol_qty2")==null?"":(String)hash.get("absol_qty2");
		String absol_qty3 = (String)hash.get("absol_qty3")==null?"":(String)hash.get("absol_qty3");
		String absol_qty4 = (String)hash.get("absol_qty4")==null?"":(String)hash.get("absol_qty4");
		String absol_qty5 = (String)hash.get("absol_qty5")==null?"":(String)hash.get("absol_qty5");
		String absol_qty6 = (String)hash.get("absol_qty6")==null?"":(String)hash.get("absol_qty6");
		String absol_qty7 = (String)hash.get("absol_qty7")==null?"":(String)hash.get("absol_qty7");
		String absol_qty8 = (String)hash.get("absol_qty8")==null?"":(String)hash.get("absol_qty8");
		String absol_qty9 = (String)hash.get("absol_qty9")==null?"":(String)hash.get("absol_qty9");
		String absol_qty10 = (String)hash.get("absol_qty10")==null?"":(String)hash.get("absol_qty10");
		String iv_prep_yn = (String)hash.get("iv_prep_yn")==null?"":(String)hash.get("iv_prep_yn");
		String drugCode="";
		ArrayList drugDetails = iv_bean.getDrugDetails();
		HashMap   drgDtls   = null;
		for(int i = 0; i<drugDetails.size();i++){
			drgDtls = (HashMap)drugDetails.get(i);
			if(drgDtls.get("DRUG_CODE")==null)
				drgDtls.put("DRUG_CODE",(String)drgDtls.get("ORDER_CATALOG_CODE")==null?"":(String)drgDtls.get("ORDER_CATALOG_CODE"));
			if(drgDtls.get("DRUG_DESC")==null)
				drgDtls.put("DRUG_DESC",(String)drgDtls.get("SHORT_DESC")==null?"":(String)drgDtls.get("SHORT_DESC"));


			
			drugCode = (String)drgDtls.get("DRUG_CODE");
			if(drugCode.equals(drug_code1)){
				drgDtls.put("ORDERED_QTY",absol_qty1);
			}
			if(drugCode.equals(drug_code2)){
				drgDtls.put("ORDERED_QTY",absol_qty2);
			}
			if(drugCode.equals(drug_code3)){
				drgDtls.put("ORDERED_QTY",absol_qty3);
			}
			if(drugCode.equals(drug_code4)){
				drgDtls.put("ORDERED_QTY",absol_qty4);
			}
			if(drugCode.equals(drug_code5)){
				drgDtls.put("ORDERED_QTY",absol_qty5);
			}
			if(drugCode.equals(drug_code6)){
				drgDtls.put("ORDERED_QTY",absol_qty6);
			}
			if(drugCode.equals(drug_code7)){
				drgDtls.put("ORDERED_QTY",absol_qty7);
			}
			if(drugCode.equals(drug_code8)){
				drgDtls.put("ORDERED_QTY",absol_qty8);
			}
			if(drugCode.equals(drug_code9)){
				drgDtls.put("ORDERED_QTY",absol_qty9);
			}
			if(drugCode.equals(drug_code10)){
				drgDtls.put("ORDERED_QTY",absol_qty10);
			}
		}
        putObjectInBean(iv_bean_id,iv_bean,request);         
		
		out.println("displayChargeDetailsPage('"+iv_prep_yn+"');");
	}
	else if (validate!= null && validate.equals("GET_BL_ERROR_DRUGS")){
		String iv_bean_id				= request.getParameter("bean_id");
		String iv_bean_name				= request.getParameter("bean_name");
		String actual_patient_class				= (String)hash.get("actual_patient_class")==null?"":(String)hash.get("actual_patient_class");
		String patient_id				= (String)hash.get("patient_id")==null?"":(String)hash.get("patient_id");
		String encounter_id				= (String)hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
		String episode_type = actual_patient_class.substring(0,1);
		if(episode_type.equals("X"))
			episode_type = "R";

		String item_code = "";
		String drug_code = "";
		String in_formulary_yn = "";
		String bl_error_code	="";
		String bl_sys_message_id = "";
		String bl_error_text	 = "";
		String drug_desc = "";
		String ordered_qty = "";
       String take_home_medication					= (String)hash.get("take_home_medication");
		IVPrescriptionBean iv_bean		= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request);

		String drug_code1 = (String)hash.get("drug_code1")==null?"":(String)hash.get("drug_code1");
		String drug_code2 = (String)hash.get("drug_code2")==null?"":(String)hash.get("drug_code2");
		String drug_code3 = (String)hash.get("drug_code3")==null?"":(String)hash.get("drug_code3");
		String drug_code4 = (String)hash.get("drug_code4")==null?"":(String)hash.get("drug_code4");
		String drug_code5 = (String)hash.get("drug_code5")==null?"":(String)hash.get("drug_code5");
		String drug_code6 = (String)hash.get("drug_code6")==null?"":(String)hash.get("drug_code6");
		String drug_code7 = (String)hash.get("drug_code7")==null?"":(String)hash.get("drug_code7");
		String drug_code8 = (String)hash.get("drug_code8")==null?"":(String)hash.get("drug_code8");
		String drug_code9 = (String)hash.get("drug_code9")==null?"":(String)hash.get("drug_code9");
		String drug_code10 = (String)hash.get("drug_code10")==null?"":(String)hash.get("drug_code10");
		String absol_qty1 = (String)hash.get("absol_qty1")==null?"":(String)hash.get("absol_qty1");
		String absol_qty2 = (String)hash.get("absol_qty2")==null?"":(String)hash.get("absol_qty2");
		String absol_qty3 = (String)hash.get("absol_qty3")==null?"":(String)hash.get("absol_qty3");
		String absol_qty4 = (String)hash.get("absol_qty4")==null?"":(String)hash.get("absol_qty4");
		String absol_qty5 = (String)hash.get("absol_qty5")==null?"":(String)hash.get("absol_qty5");
		String absol_qty6 = (String)hash.get("absol_qty6")==null?"":(String)hash.get("absol_qty6");
		String absol_qty7 = (String)hash.get("absol_qty7")==null?"":(String)hash.get("absol_qty7");
		String absol_qty8 = (String)hash.get("absol_qty8")==null?"":(String)hash.get("absol_qty8");
		String absol_qty9 = (String)hash.get("absol_qty9")==null?"":(String)hash.get("absol_qty9");
		String absol_qty10 = (String)hash.get("absol_qty10")==null?"":(String)hash.get("absol_qty10");

		ArrayList drugList = iv_bean.getDrugDetails();
		HashMap   drugDetails   = null;
		ArrayList blErrorDrugs = new ArrayList();

		for(int i = 0; i<drugList.size();i++){
			drugDetails = (HashMap)drugList.get(i);

			if(drugDetails.get("DRUG_CODE").equals(drug_code1)){
				drugDetails.put("ORDERED_QTY",absol_qty1);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code2)){
				drugDetails.put("ORDERED_QTY",absol_qty2);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code3)){
				drugDetails.put("ORDERED_QTY",absol_qty3);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code4)){
				drugDetails.put("ORDERED_QTY",absol_qty4);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code5)){
				drugDetails.put("ORDERED_QTY",absol_qty5);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code6)){
				drugDetails.put("ORDERED_QTY",absol_qty6);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code7)){
				drugDetails.put("ORDERED_QTY",absol_qty7);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code8)){
				drugDetails.put("ORDERED_QTY",absol_qty8);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code9)){
				drugDetails.put("ORDERED_QTY",absol_qty9);
			}
			if(drugDetails.get("DRUG_CODE").equals(drug_code10)){
				drugDetails.put("ORDERED_QTY",absol_qty10);
			}
		}


		if(drugList!=null && drugList.size()>0){
			for(int i=0;i<drugList.size();i++){
				drugDetails				= (HashMap)drugList.get(i);
				in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
				if(in_formulary_yn.equals("Y")){
					item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
					drug_code = (String)drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
					ordered_qty = (String)drugDetails.get("ORDERED_QTY")==null?"":(String)drugDetails.get("ORDERED_QTY");
					iv_bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
					bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
					bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
					bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
					drug_desc			= (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");

					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add(drug_code);
						blErrorDrugs.add(drug_desc);
						blErrorDrugs.add(bl_error_code);
						blErrorDrugs.add(bl_sys_message_id);
						blErrorDrugs.add(bl_error_text);
					}
				}
			}
		}
		if(blErrorDrugs!=null && blErrorDrugs.size()>0){
			out.println("alertBLErrorDrugs('"+blErrorDrugs+"');");
		}
	}else if (validate.equals("EQUIVALENT_UOM")) {
		String finalUOM			= request.getParameter("finalUOM");
		String drugUOM			= request.getParameter("drugUOM");
		String iv_bean_id		= request.getParameter("bean_id");
		String iv_bean_name		= request.getParameter("bean_name");	
		String rownumber		= request.getParameter("rownumber");	
		String drugCode			= request.getParameter("drugCode");	
		String equValue			= "";
		String factor			= "";
		String contPresBaseUOM	= "";
		String stockUOM			= "";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		ArrayList equValues		= iv_bean.getEquvalentUOMConversionValue(finalUOM,drugUOM,drugCode);
		if(equValues!=null)
		{  if(equValues.size()==4)
		   {
			 equValue	= (String)equValues.get(0);
			 factor		= (String)equValues.get(1);
			 contPresBaseUOM		= (String)equValues.get(2);
			 stockUOM	= (String)equValues.get(3);
		   }
		}
		if(equValue!="")
		{
			if(factor.equals("MULTIPLY"))
			{
				out.println("setDerivedQuantity('"+equValue+"','M','"+rownumber+"','"+contPresBaseUOM+"','"+stockUOM+"')");
			}
			else if(factor.equals("DEVIDE"))
			{
				out.println("setDerivedQuantity('"+equValue+"','D','"+rownumber+"','"+contPresBaseUOM+"','"+stockUOM+"')");
			}
			else
			{
				out.println("setDerivedQuantity('','N','"+rownumber+"','','');");
			}
		}
		else
		{
			out.println("setDerivedQuantity('','N','"+rownumber+"','','');");
		}
	}
	else if (validate.equals("CALC_ORDER_QTY")){
		String rownumber		= request.getParameter("rownumber");	
		String drugCode			= request.getParameter("drugCode");	
		String iv_bean_id		= request.getParameter("bean_id");
		String iv_bean_name		= request.getParameter("bean_name");
		String contentInPresBaseUOM="1";
		String uomOfContentInPresBaseUOM="";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		ArrayList content		= iv_bean.getContentInPresBaseUOMValue(drugCode);
		if(content!=null)
		{
			contentInPresBaseUOM=(String)content.get(0);
			uomOfContentInPresBaseUOM=(String)content.get(1);			
		}		out.println("updateOrderQuantiyInStrengthMode('"+contentInPresBaseUOM+"','"+uomOfContentInPresBaseUOM+"','"+rownumber+"')");
	}
	//Added for IN:072715 start
	else if(validate.equals("override_remarks")) {
		String reason_code		= (String)hash.get("reason_code"); 
		String trn_type		= (String)hash.get("trn_type");
		String field		= (String)hash.get("field");
		String patient_id		= (String)hash.get("patient_id");
		String encounter_id		= (String)hash.get("encounter_id");
		String bean_id_1				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name_1				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean	= (PrescriptionBean_1)getBeanObject( bean_id_1, bean_name_1 , request);
		String remarks = pres_bean.getOverrideRemarks(trn_type, reason_code);
		out.println("document.DispQueueMgmtHoldReason."+field+".value = '"+remarks+"';");
		out.println("document.DispQueueMgmtHoldReason."+field+".readOnly = true;");
		putObjectInBean(bean_id_1,pres_bean,request); 
		}
		//Added for IN:072715 end
} 
catch(Exception e) {
	e.printStackTrace();
}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
