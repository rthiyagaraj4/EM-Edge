package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eIPAD.chartsummary.pharmacy.response.PharmFieldResponse;
import eIPAD.chartsummary.pharmacy.healthobject.PharmFieldItem;
import com.ehis.persist.PersistenceHelper;
import ePH.IVPrescriptionBean;
import com.google.gson.Gson;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import eOR.Common.*;
import ePH.*;
import eOR.*;
import com.ehis.util.*;

public final class __prescriptioncrxvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/PrescriptionCrxValidation.jsp", 1709116948270L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

try{ 
	String validate		= request.getParameter("validate")==null?"":request.getParameter("validate");
	String facility_id  = (String)session.getValue( "facility_id" );
	
	
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");
	
	IVPrescriptionBean bean_IVD 	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
	
	String locale = bean_IVD.getLanguageId();
	String patient_id	= bean_IVD.getPatId();
	String encounter_id	= bean_IVD.getEncId();
	String order_date	= bean_IVD.getOrderDate();
	String pat_class	= bean_IVD.getPatientClass();
	String priority = "R";
	String take_home_medication = "N";
	validate	=	validate.trim();
	String freq_nature			= "";
	String drugCode = "";
	String rownumber ="";
	
	String iv_bean_id			= "@IVPrescriptionBean_CRX"+patient_id+encounter_id;
	String iv_bean_name			= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject( iv_bean_id,iv_bean_name, request) ;
	
	if(validate.equals("DRUGCODE")){
		String drugCodes				  = (String)hash.get("drugCodes");
		patient_id				  = (String)hash.get("patient_id");
		encounter_id				  = (String)hash.get("encounter_id");
	  	String Trade_Codes = request.getParameter("Trade_Codes");
			if(Trade_Codes == null) Trade_Codes = "";
		String Trade_Names = request.getParameter("Trade_Names");
			if(Trade_Names == null) Trade_Names = "";
		
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
		priority	  			  =	(String)hash.get("priority");
		String source_code	  		  =	(String)hash.get("source_code");
		take_home_medication	  =	(String)hash.get("take_home_medication");
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

		// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule for the first drug selected-- begin
		if(recno.equals("1")){
			
			String buildMAR_Rule=hm.get("BUILD_MAR_RULE").toString();
			if(buildMAR_Rule.equals("CE") || buildMAR_Rule.equals("CD"))
				iv_bean.setBuildMAR_yn("Y");
			else
				iv_bean.setBuildMAR_yn("N");
			out.println("setBuildMAR('"+buildMAR_Rule+"');");
		}
		// RUT-CRF-0062 [IN029600]  Added to get Build MAR Rule for the first drug selected-- end
		
/* 		drug_desc=drug_desc.replaceAll(" ","%20");
		drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
		drug_desc=drug_desc.replaceAll("%2520","%20");
		//Modified for CRF--0749 INC-13640
		out.println("assignDosageDetails('"+(String)hm.get("DRUG_CODE")+"','"+drug_desc+"','"+strength+"','"+strength_uom+"','"+strength_uom_need+"','"+dosage+"','"+dosage_uom+"','"+form_desc+"','"+stock_uom+"','"+pres_base_uom+"','"+pres_base_uom_need+"','"+external_product_id+"','"+perform_ext_db_checks+"','"+drug_class+"','"+generic_id+"','"+generic_name+"');");
		
			ArrayList exProd				= new ArrayList();
			ArrayList drugDesc				= new ArrayList();
			String dup_drug_det			    = "";
			HashMap drug_Interactions		= null;

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
			ExternalProductLinkBean beanex = (ExternalProductLinkBean)PersistenceHelper.getBeanObject(ex_bean_id,ex_bean_name,request);
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
			
			if(!ext_prod_id.equals("")){
				
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
						tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
						if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
							drug_db_contraind_check_flag="Y";
						}		
					}
				}
			}
			hm.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
			hm.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
			hm.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
			hm.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
			hm.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);
           //putObjectInBean(ex_bean_id,beanex,request);
	     //putObjectInBean(iv_bean_id,iv_bean,request);  */
	    }
	else if(validate!= null && validate.equals("populateDurationDesc")){
		
		String freq_code			= request.getParameter("freq_code" );
		patient_id			= request.getParameter("patient_id");
		encounter_id			= request.getParameter("encounter_id");
		//iv_bean_id			= "IVPrescriptionBean"+patient_id+encounter_id;
		//iv_bean_name			= "ePH.IVPrescriptionBean";
		//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject( iv_bean_id,iv_bean_name, request) ;

		String durn_desc			= "";
		String repeat_durn_type		= "";
		String freq_value			= "";
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
		//PersistenceHelper.putObjectInBean(iv_bean_id,iv_bean,request); 
		freqNature	=	null;
	}
	else if(validate.equals("POPULATEENDDATE")) {
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		//String mode			= request.getParameter("mode");
		patient_id	= request.getParameter("patient_id");
		encounter_id	= request.getParameter("encounter_id");
		freq_nature	= request.getParameter("freq_nature");

		//iv_bean_id	= "IVPrescriptionBean"+patient_id+encounter_id;
		//iv_bean_name	= "ePH.IVPrescriptionBean";
		//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject( iv_bean_id,iv_bean_name, request) ;		
		
		locale			= 	(String)session.getAttribute("LOCALE"); //Added for SRR20056-SCF-9368 [IN:037482]
     		if(!locale.equals("en")); //if block Added for SRR20056-SCF-9368 [IN:037482] 
			start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
		String end_date		= iv_bean.populateEndDate(freq_nature,start_date, durn_value, durn_unit);
		if(!locale.equals("en")){//if block Added for SRR20056-SCF-9368 [IN:037482] 
			end_date  = com.ehis.util.DateUtils.convertDate(end_date, "DMYHM","en",locale);
			start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM","en",locale); 
		}
		out.println("setEndDate(\""+ end_date +"\");");
		//PersistenceHelper.putObjectInBean(iv_bean_id,iv_bean,request); 
	}
    else if (validate.equals("EQUIVALENT_UOM")) {
		String finalUOM			= request.getParameter("finalUOM");
		String type			= request.getParameter("type");
		ArrayList	factor = new ArrayList();
		String factor_str;
		String equValue1;
		String factor1;
		String contPresBaseUOM;
		String stockUOM;
		rownumber		= request.getParameter("rownumber");
		ArrayList	presDetails	= (ArrayList) iv_bean.getDrugDetails();	
		for(int i=0; i<presDetails.size(); i++){
			HashMap drugDetails			= (HashMap)presDetails.get(i);
			String Drug_Code = (String)drugDetails.get("DRUG_CODE");
			String drugUOM = (String)drugDetails.get("PRES_BASE_UOM"); 

			ArrayList equValues		= iv_bean.getEquvalentUOMConversionValue(finalUOM,drugUOM,Drug_Code);
			factor_str = (String)equValues.get(1);
			
			if(factor_str.equals("MULTIPLY")){
			    out.println("setDerivedQuantity('M','"+rownumber+"','"+type+"');");
			}
			else if(factor_str.equals("DEVIDE")){
			    out.println("setDerivedQuantity('D','"+rownumber+"','"+type+"');");
			}
			else{
				out.println("setDerivedQuantity('N','"+rownumber+"','"+type+"');");
			}
			
		}
	}
    else if(validate.equals("CALC_DERIVED_QTY")){
		String finalUOM			= request.getParameter("finalUOM");
		String drugUOM			= request.getParameter("drugUOM");
		String type				= request.getParameter("type");
		rownumber				= request.getParameter("rownumber");	
		drugCode				= request.getParameter("drugCode");	
		String equValue			= "";
		String factor			= request.getParameter("factor");
		String contPresBaseUOM	= "";
		String stockUOM			= "";
		//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		ArrayList equValues		= iv_bean.getEquvalentUOMConversionValue(finalUOM,drugUOM,drugCode);
		if(equValues!=null)
		{  if(equValues.size()==4)
		   {
			 equValue	= (String)equValues.get(0);
			 //factor		= (String)equValues.get(1);
			 contPresBaseUOM		= (String)equValues.get(2);
			 stockUOM	= (String)equValues.get(3);
		   }
		}
		if(equValue!="")
		{
			if(factor.equals("M"))
			{
				out.println("setCalculatedDerivedQuantity('"+equValue+"','M','"+rownumber+"','"+contPresBaseUOM+"','"+stockUOM+"','"+type+"')");
			}
			else if(factor.equals("D"))
			{
				out.println("setCalculatedDerivedQuantity('"+equValue+"','D','"+rownumber+"','"+contPresBaseUOM+"','"+stockUOM+"','"+type+"')");
			}
		}
	} 	
	else if (validate.equals("CALC_ORDER_QTY")){
		rownumber		= request.getParameter("rownumber");	
		drugCode			= request.getParameter("drugCode");	
		//iv_bean_id		= request.getParameter("bean_id");
		//iv_bean_name		= request.getParameter("bean_name");
		String contentInPresBaseUOM="1";
		String uomOfContentInPresBaseUOM="";
		//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject( iv_bean_id, iv_bean_name , request) ;
		ArrayList content		= iv_bean.getContentInPresBaseUOMValue(drugCode);
		if(content!=null)
		{
			contentInPresBaseUOM=(String)content.get(0);
			uomOfContentInPresBaseUOM=(String)content.get(1);			
		}		out.println("updateOrderQuantiyInStrengthMode('"+contentInPresBaseUOM+"','"+uomOfContentInPresBaseUOM+"','"+rownumber+"')");
	}else if(validate.equals("RELEASE")){
		

		String patient_ids		= request.getParameter("patient_id");
		//String priority		    = request.getParameter("priority");
		String encounter_ids		= request.getParameter("encounter_id");
		String freq_code		= request.getParameter("freq_code");
		String durn_value		= request.getParameter("durn_value");
		String durn_type		= request.getParameter("durn_type");
		String start_date		= request.getParameter("start_date");
		String end_date			= request.getParameter("end_date");		
		String presByBase		= request.getParameter("PresByBase");	
		
		String ord_qty1				= request.getParameter("ord_qty1").equalsIgnoreCase("")?"0":request.getParameter("ord_qty1");		
		String ord_qty2				= request.getParameter("ord_qty2").equalsIgnoreCase("")?"0":request.getParameter("ord_qty2");		
		String ord_qty3				= request.getParameter("ord_qty3").equalsIgnoreCase("")?"0":request.getParameter("ord_qty3");		
		String ord_qty4				= request.getParameter("ord_qty4").equalsIgnoreCase("")?"0":request.getParameter("ord_qty4");		
		String ord_qty5				= request.getParameter("ord_qty5").equalsIgnoreCase("")?"0":request.getParameter("ord_qty5");		
		String ord_qty6				= request.getParameter("ord_qty6").equalsIgnoreCase("")?"0":request.getParameter("ord_qty6");		
		String ord_qty7				= request.getParameter("ord_qty7").equalsIgnoreCase("")?"0":request.getParameter("ord_qty7");		
		String ord_qty8				= request.getParameter("ord_qty8").equalsIgnoreCase("")?"0":request.getParameter("ord_qty8");		
		String ord_qty9				= request.getParameter("ord_qty9").equalsIgnoreCase("")?"0":request.getParameter("ord_qty9");		
		String ord_qty10			= request.getParameter("ord_qty10").equalsIgnoreCase("")?"0":request.getParameter("ord_qty10");		
		
		
		//String ord_qty1			= request.getParameter("ord_qty1");		
		//String ord_qty2			= request.getParameter("ord_qty2");		
		//String ord_qty3			= request.getParameter("ord_qty3");		
		//String ord_qty4			= request.getParameter("ord_qty4");		
		//String ord_qty5			= request.getParameter("ord_qty5");		
		//String ord_qty6			= request.getParameter("ord_qty6");		
		//String ord_qty7			= request.getParameter("ord_qty7");		
		//String ord_qty8			= request.getParameter("ord_qty8");		
		//String ord_qty9			= request.getParameter("ord_qty9");		
		//String ord_qty10		= request.getParameter("ord_qty10");	
		
		String drugRemark1			= request.getParameter("drugRemark1");		
		String drugRemark2			= request.getParameter("drugRemark2");		
		String drugRemark3			= request.getParameter("drugRemark3");		
		String drugRemark4			= request.getParameter("drugRemark4");		
		String drugRemark5			= request.getParameter("drugRemark5");		
		String drugRemark6			= request.getParameter("drugRemark6");		
		String drugRemark7			= request.getParameter("drugRemark7");		
		String drugRemark8			= request.getParameter("drugRemark8");		
		String drugRemark9			= request.getParameter("drugRemark9");		
		String drugRemark10		    = request.getParameter("drugRemark10");
		
		
		
		
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
		
		
		//current Rx:
			
		String currentRemark1		    = request.getParameter("currentRemark1");
		if(!currentRemark1.equals(""))
			currentRemark1 = java.net.URLDecoder.decode(currentRemark1,"UTF-8"); 
		
		String currentRemark2			= request.getParameter("currentRemark2");
		if(!currentRemark2.equals(""))
			currentRemark2 = java.net.URLDecoder.decode(currentRemark2,"UTF-8"); 
		
		String currentRemark3			= request.getParameter("currentRemark3");
		if(!currentRemark3.equals(""))
			currentRemark3 = java.net.URLDecoder.decode(currentRemark3,"UTF-8"); 
		
		String currentRemark4			= request.getParameter("currentRemark4");
		if(!currentRemark4.equals(""))
			currentRemark4 = java.net.URLDecoder.decode(currentRemark4,"UTF-8"); 
		
		String currentRemark5			= request.getParameter("currentRemark5");
		if(!currentRemark5.equals(""))
			currentRemark5 = java.net.URLDecoder.decode(currentRemark5,"UTF-8"); 
		
		String currentRemark6			= request.getParameter("currentRemark6");
		if(!currentRemark6.equals(""))
			currentRemark6 = java.net.URLDecoder.decode(currentRemark6,"UTF-8"); 
		
		String currentRemark7			= request.getParameter("currentRemark7");
		if(!currentRemark7.equals(""))
			currentRemark7 = java.net.URLDecoder.decode(currentRemark7,"UTF-8"); 
		
		String currentRemark8			= request.getParameter("currentRemark8");
		if(!currentRemark8.equals(""))
			currentRemark8 = java.net.URLDecoder.decode(currentRemark8,"UTF-8"); 
		
		String currentRemark9			= request.getParameter("currentRemark9");
		if(!currentRemark9.equals(""))
			currentRemark9 = java.net.URLDecoder.decode(currentRemark9,"UTF-8"); 
		
		String currentRemark10			= request.getParameter("currentRemark10");
		if(!currentRemark10.equals(""))
			currentRemark10 = java.net.URLDecoder.decode(currentRemark10,"UTF-8"); 
		
		
		//allergy:
			
			String allerygRemark1		    = request.getParameter("allerygRemark1");
		if(!allerygRemark1.equals(""))
			allerygRemark1 = java.net.URLDecoder.decode(allerygRemark1,"UTF-8"); 
		
		String allerygRemark2			= request.getParameter("allerygRemark2");
		if(!allerygRemark2.equals(""))
			allerygRemark2 = java.net.URLDecoder.decode(allerygRemark2,"UTF-8"); 
		
		String allerygRemark3			= request.getParameter("allerygRemark3");
		if(!allerygRemark3.equals(""))
			allerygRemark3 = java.net.URLDecoder.decode(allerygRemark3,"UTF-8"); 
		
		String allerygRemark4			= request.getParameter("allerygRemark4");
		if(!allerygRemark4.equals(""))
			allerygRemark4 = java.net.URLDecoder.decode(allerygRemark4,"UTF-8"); 
		
		String allerygRemark5			= request.getParameter("allerygRemark5");
		if(!allerygRemark5.equals(""))
			allerygRemark5 = java.net.URLDecoder.decode(allerygRemark5,"UTF-8"); 
		
		String allerygRemark6			= request.getParameter("allerygRemark6");
		if(!allerygRemark6.equals(""))
			allerygRemark6 = java.net.URLDecoder.decode(allerygRemark6,"UTF-8"); 
		
		
		String allerygRemark7			= request.getParameter("allerygRemark7");
		if(!allerygRemark7.equals(""))
			allerygRemark7 = java.net.URLDecoder.decode(allerygRemark7,"UTF-8"); 
		
		String allerygRemark8			= request.getParameter("allerygRemark8");
		if(!allerygRemark8.equals(""))
			allerygRemark8 = java.net.URLDecoder.decode(allerygRemark8,"UTF-8"); 
		
		String allerygRemark9			= request.getParameter("allerygRemark9");
		if(!allerygRemark9.equals(""))
			allerygRemark9 = java.net.URLDecoder.decode(allerygRemark9,"UTF-8"); 
		
		String allerygRemark10			= request.getParameter("allerygRemark10");
		if(!allerygRemark10.equals(""))
			allerygRemark10 = java.net.URLDecoder.decode(allerygRemark10,"UTF-8"); 
		
		
		//dose remarks:
			
			//allergy:
			
			String doseRemark1		    = request.getParameter("doseRemark1");
		if(!doseRemark1.equals(""))
			doseRemark1 = java.net.URLDecoder.decode(doseRemark1,"UTF-8"); 
		
		String doseRemark2			= request.getParameter("doseRemark2");
		if(!doseRemark2.equals(""))
			doseRemark2 = java.net.URLDecoder.decode(doseRemark2,"UTF-8"); 
		
		String doseRemark3			= request.getParameter("doseRemark3");
		if(!doseRemark3.equals(""))
			doseRemark3 = java.net.URLDecoder.decode(doseRemark3,"UTF-8"); 
		
		String doseRemark4			= request.getParameter("doseRemark4");
		if(!doseRemark4.equals(""))
			doseRemark4 = java.net.URLDecoder.decode(doseRemark4,"UTF-8"); 
		
		String doseRemark5			= request.getParameter("doseRemark5");
		if(!doseRemark5.equals(""))
			doseRemark5 = java.net.URLDecoder.decode(doseRemark5,"UTF-8"); 
		
		String doseRemark6			= request.getParameter("doseRemark6");
		if(!doseRemark6.equals(""))
			doseRemark6 = java.net.URLDecoder.decode(doseRemark6,"UTF-8"); 
		
		
		String doseRemark7			= request.getParameter("doseRemark7");
		if(!doseRemark7.equals(""))
			doseRemark7 = java.net.URLDecoder.decode(doseRemark7,"UTF-8"); 
		
		String doseRemark8			= request.getParameter("doseRemark8");
		if(!doseRemark8.equals(""))
			doseRemark8 = java.net.URLDecoder.decode(doseRemark8,"UTF-8"); 
		
		String doseRemark9			= request.getParameter("doseRemark9");
		if(!doseRemark9.equals(""))
			doseRemark9 = java.net.URLDecoder.decode(doseRemark9,"UTF-8"); 
		
		String doseRemark10			= request.getParameter("doseRemark10");
		if(!doseRemark10.equals(""))
			doseRemark10 = java.net.URLDecoder.decode(doseRemark10,"UTF-8"); 
		
		
		
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
		
		
		String RP1				= request.getParameter("RP1").equalsIgnoreCase("")?"0":request.getParameter("RP1");				
		String RP2				= request.getParameter("RP2").equalsIgnoreCase("")?"0":request.getParameter("RP2");		
		System.out.println("RP222::::"+RP2);
		String RP3				= request.getParameter("RP3").equalsIgnoreCase("")?"0":request.getParameter("RP3");
		String RP4				= request.getParameter("RP4").equalsIgnoreCase("")?"0":request.getParameter("RP4");
		String RP5				= request.getParameter("RP5").equalsIgnoreCase("")?"0":request.getParameter("RP5");
		String RP6				= request.getParameter("RP6").equalsIgnoreCase("")?"0":request.getParameter("RP6");
		String RP7				= request.getParameter("RP7").equalsIgnoreCase("")?"0":request.getParameter("RP7");
		String RP8				= request.getParameter("RP8").equalsIgnoreCase("")?"0":request.getParameter("RP8");
		String RP9				= request.getParameter("RP9").equalsIgnoreCase("")?"0":request.getParameter("RP9");
		String RP10				= request.getParameter("RP10").equalsIgnoreCase("")?"0":request.getParameter("RP10");
			
		
		
		
		
		String baseDrug1				= request.getParameter("baseDrug1");				
		String baseDrug2				= request.getParameter("baseDrug2");				
		String baseDrug3				= request.getParameter("baseDrug3");				
		String baseDrug4				= request.getParameter("baseDrug4");				
		String baseDrug5				= request.getParameter("baseDrug5");				
		String baseDrug6				= request.getParameter("baseDrug6");				
		String baseDrug7				= request.getParameter("baseDrug7");				
		String baseDrug8				= request.getParameter("baseDrug8");				
		String baseDrug9				= request.getParameter("baseDrug9");				
		String baseDrug10				= request.getParameter("baseDrug10");	
		
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
		String totalRatio			= request.getParameter("totalRatio");
		String totalRatioQuantity			= request.getParameter("totalRatioQuantity");
		String totalPercentQuantity			= request.getParameter("totalPercentQuantity");

		 
		  iv_bean_id			= "@IVPrescriptionBean_CRX"+patient_id+encounter_id;
		  iv_bean_name			= "ePH.IVPrescriptionBean";
		 IVPrescriptionBean bean	= (IVPrescriptionBean)PersistenceHelper.getBeanObject( iv_bean_id,iv_bean_name, request) ;
			
			
		//IVPrescriptionBean bean = (IVPrescriptionBean)PersistenceHelper.getBeanObject(iv_bean_id,iv_bean_name,request);       
		
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
		PrescriptionBean_1 pres_bean	= (PrescriptionBean_1)PersistenceHelper.getBeanObject( bean_id_1, bean_name_1 , request);

		bean.setAmendRemarks((String)pres_bean.getPresRemarks());

		//String order_id	= bean.getOrderID();
		ArrayList drugList	= bean.getDrugDetails();

		if (drugList.size() != 0) {
			HashMap record	=	null;
			for(int i=0;i<drugList.size();i++) {
				record	=	(HashMap)drugList.get(i);    
    
				
				bean.setFREQ_CODE(freq_code);
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
				record.put("TOTAL_RATIO",totalRatio);
				record.put("TOTAL_RATIO_QTY",totalRatioQuantity);
				record.put("TOTAL_PERCENT_QTY",totalPercentQuantity);
				
				if(((String)record.get("DRUG_CODE")).equals(drug_code1)) {
					record.put("ABSOL_QTY",ord_qty1);
					record.put("DRUG_REMARKS",drugRemark1);
					record.put("CURRENTRX_REMARKS",currentRemark1);
					record.put("ALLERGY_REMARKS",allerygRemark1);
					record.put("DOSE_REMARKS",doseRemark1);
					record.put("BASE_DRUG",baseDrug1);
					
					record.put("RATIO_PERCENTAGE",RP1);
					record.put("REQD_QTY",reqQty[0]);
					record.put("ORDER_QTY",ordQty[0]);
					record.put("ORDER_UOM",ordQtyUOM[0]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[0]);//Added for  ML-BRU-CRF-072[Inc:29938]
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code2)) {
					record.put("ABSOL_QTY",ord_qty2);
					record.put("DRUG_REMARKS",drugRemark2);
					record.put("CURRENTRX_REMARKS",currentRemark2);
					record.put("ALLERGY_REMARKS",allerygRemark2);
					record.put("DOSE_REMARKS",doseRemark2);
					record.put("BASE_DRUG",baseDrug2);
					record.put("RATIO_PERCENTAGE",RP2);
					record.put("REQD_QTY",reqQty[1]);
					record.put("ORDER_QTY",ordQty[1]);
					record.put("ORDER_UOM",ordQtyUOM[1]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[1]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code3)) {
					record.put("ABSOL_QTY",ord_qty3);
					record.put("DRUG_REMARKS",drugRemark3);
					record.put("CURRENTRX_REMARKS",currentRemark3);
					record.put("ALLERGY_REMARKS",allerygRemark3);
					record.put("DOSE_REMARKS",doseRemark3);
					record.put("BASE_DRUG",baseDrug3);
					record.put("RATIO_PERCENTAGE",RP3);
					record.put("REQD_QTY",reqQty[2]);
					record.put("ORDER_QTY",ordQty[2]);
					record.put("ORDER_UOM",ordQtyUOM[2]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[2]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code4)) {
					record.put("ABSOL_QTY",ord_qty4);
					record.put("DRUG_REMARKS",drugRemark4);
					
					record.put("CURRENTRX_REMARKS",currentRemark4);
					record.put("ALLERGY_REMARKS",allerygRemark4);
					record.put("DOSE_REMARKS",doseRemark4);
					record.put("BASE_DRUG",baseDrug4);
					record.put("RATIO_PERCENTAGE",RP4);
					record.put("REQD_QTY",reqQty[3]);
					record.put("ORDER_QTY",ordQty[3]);
					record.put("ORDER_UOM",ordQtyUOM[3]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[3]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 	
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code5)) {
					record.put("ABSOL_QTY",ord_qty5);
					record.put("DRUG_REMARKS",drugRemark5);
					
					record.put("CURRENTRX_REMARKS",currentRemark5);
					record.put("ALLERGY_REMARKS",allerygRemark5);
					record.put("DOSE_REMARKS",doseRemark5);
					record.put("BASE_DRUG",baseDrug5);
					record.put("RATIO_PERCENTAGE",RP5);
					record.put("REQD_QTY",reqQty[4]);
					record.put("ORDER_QTY",ordQty[4]);
					record.put("ORDER_UOM",ordQtyUOM[4]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[4]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code6)) {
					record.put("ABSOL_QTY",ord_qty6);
					record.put("DRUG_REMARKS",drugRemark6);
					
					record.put("CURRENTRX_REMARKS",currentRemark6);
					record.put("ALLERGY_REMARKS",allerygRemark6);
					record.put("DOSE_REMARKS",doseRemark6);
					record.put("BASE_DRUG",baseDrug6);
					record.put("RATIO_PERCENTAGE",RP6);
					record.put("REQD_QTY",reqQty[5]);
					record.put("ORDER_QTY",ordQty[5]);
					record.put("ORDER_UOM",ordQtyUOM[5]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[5]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code7)) {
					record.put("ABSOL_QTY",ord_qty7);
					record.put("DRUG_REMARKS",drugRemark7);
					
					record.put("CURRENTRX_REMARKS",currentRemark7);
					record.put("ALLERGY_REMARKS",allerygRemark7);
					record.put("DOSE_REMARKS",doseRemark7);
					record.put("BASE_DRUG",baseDrug7);
					record.put("RATIO_PERCENTAGE",RP7);
					record.put("REQD_QTY",reqQty[6]);
					record.put("ORDER_QTY",ordQty[6]);
					record.put("ORDER_UOM",ordQtyUOM[6]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[6]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code8)) {
					record.put("ABSOL_QTY",ord_qty8);
					record.put("DRUG_REMARKS",drugRemark8);
					record.put("BASE_DRUG",baseDrug8);
					record.put("CURRENTRX_REMARKS",currentRemark8);
					record.put("ALLERGY_REMARKS",allerygRemark8);
					record.put("DOSE_REMARKS",doseRemark8);
					
					
					record.put("RATIO_PERCENTAGE",RP8);
					record.put("REQD_QTY",reqQty[7]);
					record.put("ORDER_QTY",ordQty[7]);
					record.put("ORDER_UOM",ordQtyUOM[7]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[7]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				}
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code9)) {
					record.put("ABSOL_QTY",ord_qty9);
					record.put("DRUG_REMARKS",drugRemark9);
					
					record.put("CURRENTRX_REMARKS",currentRemark9);
					record.put("ALLERGY_REMARKS",allerygRemark9);
					record.put("DOSE_REMARKS",doseRemark9);
					record.put("BASE_DRUG",baseDrug9);
					
					record.put("RATIO_PERCENTAGE",RP9);
					record.put("REQD_QTY",reqQty[8]);
					record.put("ORDER_QTY",ordQty[8]);
					record.put("ORDER_UOM",ordQtyUOM[8]);
					record.put("DRUG_INDICATION",DrugIndicationRemarks[8]);//Added for  ML-BRU-CRF-072[Inc:29938] Start
				} 
				else if( ((String)record.get("DRUG_CODE")).equals(drug_code10)) {
					record.put("ABSOL_QTY",ord_qty10);
					record.put("DRUG_REMARKS",drugRemark10);
					
					record.put("CURRENTRX_REMARKS",currentRemark10);
					record.put("ALLERGY_REMARKS",allerygRemark10);
					record.put("DOSE_REMARKS",doseRemark10);
					record.put("BASE_DRUG",baseDrug10);
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
		OrderEntryBean orbean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		
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
						String drug_remstr			=   (String) drugDetails.get("DRUG_REMARKS")==null?"":(String) drugDetails.get("DRUG_REMARKS");
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
							//Drug remarks related code for EM Mobility STARTS
							int compCount = 0;//alsways zero since we assume only one component in drug remarks for pharmacy drug alone
							orderFormatHash.put("drug_code", drug_code);
							
							orderFormatHash.put("order_format_values", "DRUG_REMARKS : "+drug_remstr);
							orderFormatHash.put("field_values"+compCount, drug_remstr);
							orderFormatHash.put("label_text"+compCount, "DRUG_REMARKS");
							orderFormatHash.put("field_type"+compCount, "A");
							orderFormatHash.put("order_format_count", "1");
							orderFormatHash.put("seq_num"+compCount, "0");
							orderFormatHash.put("field_mnemonic"+compCount, "DRUG_REMARKS");
							orderFormatHash.put("accept_option"+compCount, "O");
							
							//Drug remarks related code for EM Mobility ENDS
						}
						DrugRemarks.add(orderFormatHash);
					}
			}
		}
		bean.setDrugRemarks(DrugRemarks);

		/* HashMap returndata = bean.releaseCompoundRx();
		String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();
		boolean result	= ((Boolean)returndata.get("result")).booleanValue();
		String message	= (String)returndata.get("message");
		String flag		= (String)returndata.get("flag");
		flag		= "";
		if(message==null)
			message		=	"";
		out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\", \"" + print_ord_sht_rule_ind +"\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	 */
	//	putObjectInBean(iv_bean_id,bean,request); 
		//putObjectInBean(bean_id_1,pres_bean,request); 
	//	putObjectInBean(or_bean_id,orbean,request); 

		
		
		
		
	}
	//PersistenceHelper.putObjectInBean(bean_id,bean_IVD,request);
}
catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
