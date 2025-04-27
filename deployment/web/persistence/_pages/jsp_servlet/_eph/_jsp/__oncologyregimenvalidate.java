package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.DecimalFormat;
import ePH.Common.*;
import ePH.*;
import eOR.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __oncologyregimenvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyRegimenValidate.jsp", 1743130508267L ,"10.3.6.0","Asia/Calcutta")) return true;
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
/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
12/08/2019	IN070451		B Haribabu          12/08/2019     Manickavasagam J	    ML-MMOH-CRF-1408
1/6/2020    IN072753        Prabha											       NMC-JD-CRF-0046 
25/06/2020      IN:072715       Haribabu        25/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
14/12/2020  	6041			Shazana       	14/12/2020	   Manickavasagam J		NMC-JD-CRF-0063
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

Connection con			= null;//added for NMC-JD-CRF-0063
try{
	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");
	String validate		= request.getParameter("validate");
	String patient_id	= request.getParameter("patient_id");
	String facility_id	= "";
	facility_id	= (String) session.getValue("facility_id");
	
	String locale			= (String)session.getAttribute("LOCALE");     // Added for scf-9366 [IN 57051]

	if (bean_id == null || bean_id.equals(""))
		return ;

	OncologyRegimenBean bean = (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
	if(patient_id !=null){
		bean.setPatId(patient_id);
	}

	patient_id	= bean.getPatId();
	String encounter_id	= bean.getEncId();
	String order_date	= bean.getOrderDate();
	String pat_class	= bean.getPatientClass();
	String problem_ind	= bean.getProblemInd();
	PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;//ADDED FOR NMC-JD-CRF-0063 START

	con				= ConnectionManager.getConnection(request);
	boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");
	
	if(pat_class!=null){
		if(pat_class.equals("EM")|| pat_class.equals("OP")){
			if(op_take_home_med_flag){
				bean.setTakeHomeMedicationOp("Y");
			}else{
				bean.setTakeHomeMedicationOp("N");
			} 
		}
	}
	if(beanPres.getOpDischMedInd()==null){
		bean.setOpDischMedInd("N");
	}
	else if(beanPres.getOpDischMedInd()!=null){
		bean.setOpDischMedInd(beanPres.getOpDischMedInd());
	}
	if(beanPres.getPatient_class_tkHome().equals("IP")){
		bean.setTakeHomeMedicationOp("N");  
	} 

	
	if (validate.equals("AccessionNumber")) { 

		HashMap record2=new HashMap(); 
		String oncology_screening_type="";
		String note_type="";
		String accession_num="";
		
		record2=bean.ChkAdMixture();
		oncology_screening_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_TYPE"));
		note_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_FORM_ID"));
			   
		if(!oncology_screening_type.equals("")){
			HashMap record3=new HashMap();
			record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
			accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
		}
		out.println("CheckAccessionNumber(\""+ accession_num + "\");");
	}

	if (validate.equals("before")) {

		HashMap record2=new HashMap(); 
		String oncology_screening_type="";
		String note_type="";
		String accession_num="";

		record2=bean.ChkAdMixture();
		oncology_screening_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_TYPE"));
		note_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_FORM_ID"));
			   
		if(!oncology_screening_type.equals("")){
			HashMap record3=new HashMap();
			record3=bean.ChkScreeningDetails(facility_id,encounter_id,note_type);
			accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
		}
		out.println("beforAccessionNumber(\""+ accession_num + "\");");
	}
	
	if (validate.equals("Discrete")) {

		HashMap record2=new HashMap(); 
		String oncology_screening_type="";
		String note_type="";
		String test_observ_dt_tm="";
		
		record2=bean.ChkAdMixture();
		oncology_screening_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_TYPE"));
		note_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_FORM_ID"));
			   
		if(!oncology_screening_type.equals("")){
			HashMap record3=new HashMap();
			record3=bean.ChkDiscrete(facility_id,encounter_id,note_type);
			test_observ_dt_tm=CommonBean.checkForNull((String)record3.get("TEST_OBSERV_DT_TM"));
		}
		out.println("beforDiscrete(\""+ test_observ_dt_tm + "\");");
	}

	if (validate.equals("beforeDiscrete")) {

		HashMap record2=new HashMap(); 
		String oncology_screening_type="";
		String note_type="";
		String test_observ_dt_tm="";
		
		record2=bean.ChkAdMixture();
		oncology_screening_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_TYPE"));
		note_type=CommonBean.checkForNull((String)record2.get("ONCOLOGY_SCREENING_FORM_ID"));
			   
		if(!oncology_screening_type.equals("")){
			HashMap record3=new HashMap();
			record3=bean.ChkDiscrete(facility_id,encounter_id,note_type);
			test_observ_dt_tm=CommonBean.checkForNull((String)record3.get("TEST_OBSERV_DT_TM"));
	
		}
		out.println("CheckbeforeDis(\""+ test_observ_dt_tm + "\");");
	}

	if (validate.equals("DRUGCODES")) {

		String drugCodes = request.getParameter("drugCodes");
		String order_id  = request.getParameter("order_id");
		String Order_Date= request.getParameter("ord_date");
	
 //if(! bean.getLanguageId().equals("en"))
           //Order_Date =com.ehis.util.DateUtils.convertDate(Order_Date,"DMYHM",bean.getLanguageId(),"en");
		bean.setOrderDate(Order_Date);
		Hashtable hash   = (Hashtable)XMLobj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		
		String source_code=hash.get("source_code").toString(); // RUT-CRF-0062 [IN029600] NEWLY ADDED
		String priority=hash.get("priority").toString(); // RUT-CRF-0062 [IN029600] NEWLY ADDED
		String atc_allergy_alert_level=hash.get("atc_allergy_alert_level").toString(); // RUT-CRF-0065 [IN029603] NEWLY ADDED
		facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);

		param_bean.clear();
		bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);	
        bean.setPatientClass((String)hash.get("patient_class"));	
		if(!bean.ItemLinkcheck(drugCodes)){
			out.println("alert(getMessage('PH_DRUG_ITEM_NOT_LINKED','PH'));");
			out.println("callClearAll('4');");
			return;
		}
		String act_pat_class	= hash.get("act_pat_class").toString(); // RUT-CRF-0062
		bean.setExistingCYTORecords(order_id,act_pat_class,source_code,priority,atc_allergy_alert_level);	// RUT-CRF-0062 [IN029600]  NEWLY ADDED TO GET BUILD MAR RULE atc_allergy_alert_level added for  RUT-CRF-0065 [IN029603] 
		bean.setDrugDetails(drugCodes,hash);

		ArrayList drugList					= bean.getDrugDetails();
		
		if (drugList!=null && drugList.size() > 0) {	
			String perform_external_database_checks_yn	= "";	
			String ext_prod_id							= "";
			String loading_ext_prod_id					= "";
		    HashMap drug_Interactions					= null;
			String dup_drug_det							= "";
			String drug_db_interact_check_flag			= "N";
			String drug_db_duptherapy_flag				= "N";
			String drug_db_contraind_check_flag			= "N";
			//String drug_db_dosage_check_flag			= "N";
			String ex_bean_id   = "@ExternalProductLinkBean";
			String ex_bean_name = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

		    ArrayList exProd				= new ArrayList();
			ArrayList drugDesc				= new ArrayList();
			HashMap drugDetails = null;
			String ext_drug_code = "";
			String 	srl_no = "";
			String startdate="",enddate="";// Added for ML-BRU-SCF-0811 [IN:039394]
			for(int i=0;i<drugList.size();i++){
				drugDetails				=(HashMap) drugList.get(i);
				ext_drug_code				=(String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
				if(!exProd.contains(ext_drug_code)){
					drugDesc.add((String)drugDetails.get("DRUG_DESC"));
					if(!ext_drug_code.equals("")){
					    exProd.add((String)drugDetails.get("EXTERNAL_PRODUCT_ID"));
					}
				}
			}
			/*
			if(exProd.size()>0)
				beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
			*/
			for(int i=0;i<drugList.size();i++) {
				drugDetails = (HashMap)drugList.get(i);
				if (drugDetails!=null && drugDetails.size() > 0){
					perform_external_database_checks_yn	= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
					ext_prod_id							= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
					srl_no= (String)drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");
					startdate				= (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
					enddate				    = (String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]


					loading_ext_prod_id					= ext_prod_id;
					if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
						drug_Interactions					=	null;
						dup_drug_det						=	"";
						/*
						if(drug_db_interact_check_yn.equals("Y")){
							if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
								beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
								drug_Interactions		= beanex.getInteractions();//get Interactions
								if(drug_Interactions.size()>0){							
									drug_db_interact_check_flag="Y";
								}
							 }
						}
						if(drug_db_duptherapy_yn.equals("Y")){ 
							if(ext_prod_id!=null&& !ext_prod_id.equals("")){
								dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result

								if(!dup_drug_det.equals("")&&dup_drug_det!=null)
									drug_db_duptherapy_flag="Y";
								}
						}
						if(drug_db_contraind_check_yn.equals("Y")){
							if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
								ArrayList ex_prod_ids =new ArrayList();
									ex_prod_ids.add(loading_ext_prod_id);
									boolean flag1 = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
									HashMap contra_indications =(HashMap)beanex.getContraIndications();
									if(contra_indications.containsKey(ext_prod_id)){
										String  contra_indication_for_drug   =(String)contra_indications.get(ext_prod_id);
										drug_db_contraind_check_flag="Y";
									}					  
							 }
							 */
						if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")){
							String storeIDs = "N";
							if(exProd.size()>0 )
								storeIDs = "Y";
								
							HashMap tempDetails= null;
							ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add("N"); //AllergyCheck -
							HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);


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
								if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ //adding start for IN066787- Performance
										tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */
										if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
												 drug_db_contraind_check_flag="Y";
											}
										}else{//Adding end for IN066787- Performance
												tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
										   if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
											   drug_db_contraind_check_flag="Y";
										}		
										  else
											   drug_db_contraind_check_flag="N";
									}	
								}
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);

				   }else{
						drug_db_product_id = "";
				   }

				   drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
				}
			}
		}

		putObjectInBean(bean_id,bean,request);
	}
	else if (validate.equals("STOCKDETAILS")) {
		
		String drug_code			= request.getParameter("drug_code");
		String org_drug_code		= request.getParameter("org_drug_code");
		String ocurrance_num		= request.getParameter("ocurrance_num");
       	String orderType			= bean.getOrderType(drug_code);
		bean.setFluidDetails(drug_code,org_drug_code,ocurrance_num);
		HashMap tmp					=	bean.getFluidDetails();
		String infuseovervalue		=(String)tmp.get("INFUSE_OVER_VALUE");
		String infuseoverdurntype	=(String)tmp.get("INFUSE_OVER_DURN_TYPE");
		

		out.println("setOrderType(\""+ orderType + "\");");
		

		if (bean.checkForStock()) {
	
			ArrayList stockDetails = bean.getStockDetails(drug_code, "1");
			String stock_Details_uom	=bean.getUomDisplay(facility_id,(String)stockDetails.get(1));
			//String stock_Details_uom1	=bean.getUomDisplay(facility_id,(String)stockDetails.get(2));//Un used variable
			
			if (stockDetails.size() != 0)
			{
				//out.println("setStockDetails(1,'"+stockDetails.get(0)+"','"+stockDetails.get(1)+"','"+stockDetails.get(2)+"');")  commented on 9/10/09 ;
				out.println("setStockDetails(1,'"+stockDetails.get(0)+"','"+stock_Details_uom+"','"+stockDetails.get(2)+"','"+(String)stockDetails.get(1)+"');") ;
				//out.println("setStockDetails(1,'"+stockDetails.get(0)+"','"+(bean.getUomDisplay(facility_id,(String)stockDetails.get(1)))+"','"+stockDetails.get(2)+"');") ;
						
			}
			else{	
				out.println("setStockDetails(2);") ;
			}

		}
		else {
			out.println("clearData('document.OncologyRegimenFluidDetail.stock_uom', '1');") ;
			ArrayList stockDetails = bean.getStockDetails(drug_code, "2");
			if (stockDetails.size() != 0) {
				
				for (int datacnt = 0; datacnt < stockDetails.size(); datacnt+=2) {
					
					out.println("addData(\""+ stockDetails.get(datacnt) + "\", \"" + stockDetails.get(datacnt+1) +"\", 'document.OncologyRegimenFluidDetail.stock_uom');");
				}
			}
		}
		out.println("defaultinfuseover(\""+ infuseovervalue + "\",\""+infuseoverdurntype+"\");");
		putObjectInBean(bean_id,bean,request);
	}
	else if (validate.equals("DELETEDRUG")) {
		String drug_code	= request.getParameter("drug_code");
		String ocurrance_num	= request.getParameter("ocurrance_num")==null?"":request.getParameter("ocurrance_num");
		int srl_no			= Integer.parseInt(request.getParameter( "srl_no" )) ;			
		bean.removeDrugFromList(srl_no-1, drug_code,ocurrance_num);
		out.println("refreshLocation(\"" + patient_id + "\", \"" + encounter_id + "\",\""+problem_ind+"\", \""+order_date+"\",'2');") ;
		ArrayList drugList					= bean.getDrugDetails();
		putObjectInBean(bean_id,bean,request);
	}
	else if (validate.equals("AMENDDRUG")) {
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);		
		hash				= (Hashtable)hash.get("SEARCH") ;			

		int srl_no			= Integer.parseInt((String)hash.get("SRL_NO"));

		String drug_code	            = (String)hash.get("drug_code");
		String order_type_flag			= (String)hash.get("order_type_flag");
//		String qty_value						= (String)hash.get("dose");
		String qty_value						= (String)hash.get("totalDose");
		String dosage_type						= (String)hash.get("dosage_type");
		String repeat_value					= (String)hash.get("repeat_value");
		String temp_qty					=  (String)hash.get("temp_qty");//ML-MMOH-CRF-1408
		String flag                     =   "Y";
		String allergy_remarks_yn="N", dup_remarks_yn="N", dose_remarks_yn="N";//Added for IN:069887
		String ext_srl_no				=	null;
		String perform_external_database_checks_yn = "N";
		String limit_ind                =   "";
		String no_of_cycle				= (String)hash.get("no_of_cycle")==null?"":(String)hash.get("no_of_cycle");//ML-MMOH-CRF-0345
		String location_type			= (String)hash.get("location_type");
		String location_code			= (String)hash.get("location_code");
		String take_home_medication		= (String)hash.get("take_home_medication");
		String priority					= (String)hash.get("priority");
		String iv_prep_yn				= (String)hash.get("iv_presc_yn");
		String freq_chng_durn_desc		= (String)hash.get("freq_chng_durn_desc");
		String amend_frequency_desc		= (String)hash.get("amend_frequency_desc");
		String amend_start_date		= (String)hash.get("amend_start_date"); //added for SRR20056-SCF-7257 IN27448
		String amend_end_date		= (String)hash.get("amend_end_date"); //added for SRR20056-SCF-7257 IN27448
		String amend_durn_value			= (String)hash.get("amend_durn_value")==null?"":(String)hash.get("amend_durn_value");//ML-MMOH-CRF-1014
		String mfr_yn					= (String)hash.get("mfr_yn")==null?"N":(String)hash.get("mfr_yn");//ML-MMOH-CRF-1014
		String amend_durn_type		= (String)hash.get("amend_durn_type")==null?"":(String)hash.get("amend_durn_type");//ML-MMOH-CRF-0345
		String buildMAR_yn		= (String)hash.get("buildMAR_yn"); 
		String DrugRemarksEntered		= (String)hash.get("DrugRemarksEntered")==null?"":(String)hash.get("DrugRemarksEntered");//added for [IN:039576]
		String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");//Added For ML-BRU-CRF-072[Inc:29938]
		String validate_overide_on_confirm_yn            = (String) hash.get("validate_overide_on_confirm_yn")==null?"N":(String)hash.get("validate_overide_on_confirm_yn");//Added for IN:069887
		if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8");//Added For ML-BRU-CRF-072[Inc:29938]
		//bean.setBuildMAR_yn(buildMAR_yn);

	/*	String calc_dose				= (String)hash.get("dose")==null?"":(String)hash.get("dose");
		String calc_dose_uom				= (String)hash.get("doseUom")==null?"":(String)hash.get("doseUom");
		String calc_dose_by				= (String)hash.get("caclDoseBy_unit")==null?"":(String)hash.get("caclDoseBy_unit");
	 */	
		String allow_alternate =  (String)hash.get("allow_alternate")==null?"":(String)hash.get("allow_alternate");//GHL-CRF-0549
		String dflt_disp_locn	= "";	
		String ext_rsn_flag		= "Y";
		String ext_prod_id		= "";
		//String pract_name		= "";//Un used variable
		//String drug_db_dosecheck_yn	= "";//Un used variable

		String EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	= "";

		String EXTERNAL_DUPLICATE_OVERRIDE_REASON			= "";
		String EXTERNAL_DOSAGE_OVERRIDE_REASON				= "";
		String EXTERNAL_INTERACTION_OVERRIDE_REASON			= "";
		String EXTERNAL_CONTRA_OVERRIDE_REASON				= "";
		String EXTERNAL_ALERGY_OVERRIDE_REASON				= "";
		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocationForCyto(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]

		if(ord_disp_location != null & ord_disp_location.size()>0){ 
			dflt_disp_locn	= (String)ord_disp_location.get(0); 
		}
		ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();

		HashMap ext_drugData			=	null;
		String ext_drug_code			=	"";
			   ext_srl_no				=	"";
		String srlno                    =   srl_no+"";
		String freq_nature				= "";//ML-MMOH-CRF-0345
	//ML-MMOH-CRF-0345 - start
		ArrayList time_list = null;
		ArrayList time      = null;
		String day_list,cycle_no,cycle_start_date,cycle_end_date = "";
	    String freq_code = "";//ML-MMOH-CRF-1014
	    String freq_desc = "";//ML-MMOH-CRF-1014
	//ML-MMOH-CRF-0345 - end
		for(int j=0;j<prescriptionDetails.size();j++){
			 ext_drugData	=(HashMap) prescriptionDetails.get(j);
			 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
			 ext_srl_no		=(String) ext_drugData.get("SRL_NO");			 	
			 //ML-MMOH-CRF-0345 - start
			 freq_nature    = (String) ext_drugData.get("FREQ_NATURE");
			 HashMap hm = bean.getCycleDetails();	//ML-MMOH-CRF-0345 
			 HashMap hm_details = null; 	//ML-MMOH-CRF-0345 
			 if(freq_nature==null)
				 freq_nature = "";
				 ////ML-MMOH-CRF-0345 - end
			 if( drug_code.equals(ext_drug_code) && srlno.equals(ext_srl_no)){
				 ext_drugData.put("amend_frequency_desc",amend_frequency_desc);
				 ext_drugData.put("PERF_LOCN_CODE", dflt_disp_locn);
				  ext_drugData.put("DRUG_INDICATION", DrugIndicationRemarks);//Added For ML-BRU-CRF-072[Inc:29938]
				 ext_drugData.put("amend_start_date", amend_start_date); //added for SRR20056-SCF-7257 IN27448
				 ext_drugData.put("amend_end_date", amend_end_date); //added for SRR20056-SCF-7257 IN27448
				  ext_drugData.put("DrugRemarksEntered", DrugRemarksEntered);//added for [IN:039576]
				  ext_drugData.put("mfr_yn",mfr_yn);//ML-MMOH-CRF-1014 - start
	  			  ext_drugData.put("allow_alternate",allow_alternate);//GHL-CRF-0549
				  if(mfr_yn.equals("Y")){

					  ext_drugData.put("amend_durn_unit","H"); 
					  ext_drugData.put("freq_chng_durn_desc","H"); 
					  ext_drugData.put("amend_durn_value","1");
					  ext_drugData.put("amend_repeat_value","1");
					  ext_drugData.put("REPEAT_VALUE","1");
					  ext_drugData.put("INFUSE_OVER",bean.getMFRRecs().get("totFlowDurnHrs"));
					  ext_drugData.put("DURN_VALUE", bean.getMFRRecs().get("totDurnHrs"));
					  ext_drugData.put("STOCK_VALUE",(String)hash.get("amend_stock_value"));
					  ext_drugData.put("FLUID_UNIT_QTY_UOM",(String)hash.get("amend_stock_uom_val"));
					  ext_drugData.put("default_stock_val", (String)hash.get("default_stock_val")==null?"1":(String)hash.get("default_stock_val") );
					
					ArrayList frequency = bean.getFrequency();
					if(frequency.size() > 0){
						freq_code = (String)frequency.get(0);
						freq_desc = (String)frequency.get(1);
						ext_drugData.put("FREQ_CODE",freq_code); 
						ext_drugData.put("FREQ_DESC",freq_desc); 
						ext_drugData.put("amend_frequency",freq_code);
						ext_drugData.put("amend_frequency_desc",freq_desc); 
						hash.put("amend_frequency",freq_code);
					}		

				  }//ML-MMOH-CRF-1014 - end
			//ML-MMOH-CRF-0345 - start
				 if(freq_nature.equals("Y") && !mfr_yn.equals("Y")){//mfr_yn added for ML-MMOH-CRF-1014
					 ext_drugData.put("CYCLE_FREQ_YN", "Y");
 					 ext_drugData.put("NO_OF_CYCLE", no_of_cycle);
					 ext_drugData.put("CYCLE_FREQ_DURN_TYPE",amend_durn_type );
  					 ext_drugData.put("FREQ_NATURE",freq_nature);
				    if(order_type_flag.equals("Existing")){
						if(hm!=null && hm.size()>0){
							hm_details = (HashMap)hm.get(drug_code+srl_no);
						}
						if(hm_details!=null){
						time_list	= (ArrayList)hm_details.get("cycle_0");
						time		= (ArrayList)time_list.get(0);
						day_list	=  (String)time_list.get(1);
						cycle_no	= (String)time_list.get(2);
						cycle_start_date  =  (String)time_list.get(3);
						cycle_end_date =   (String)time_list.get(4);
						ext_drugData.put("CYCLE_START_DATE",cycle_start_date);
						ext_drugData.put("CYCLE_END_DATE",cycle_end_date);
						ext_drugData.put("TIME_LIST",time);
						ext_drugData.put("DAY_LIST",day_list);
						ext_drugData.put("CYCLE_NO",cycle_no);
						ext_drugData.put("START_DATE_TIME",amend_start_date);
						ext_drugData.put("DURN_VALUE","1");
						ext_drugData.put("CYCLE_FREQ_DURN_TYPE",amend_durn_type);
						ext_drugData.put("allow_alternate",allow_alternate);//GHL-CRF-0549
						}
				   }
				  }
			//ML-MMOH-CRF-0345 - end
				  
				 break;
			 }
		}
	
//		if(!order_type_flag.equals("Existing")){		
			
			String dose_remarks				=   null;
			String allergy_remarks			=   null;
			String currentrx_remarks		=   null;
			String allergy_yn               =   null;
			String current_rx               =   null;
			

			for(int j=0;j<prescriptionDetails.size();j++){
				 ext_drugData	=(HashMap) prescriptionDetails.get(j);

			if(ext_drugData != null && ext_drugData.size()>0){
				 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				 ext_srl_no		=(String) ext_drugData.get("SRL_NO");

               if(drug_code.equals(ext_drug_code)  && srlno.equals(ext_srl_no)){

				 EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
				 EXTERNAL_DUPLICATE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
				 EXTERNAL_DOSAGE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
				 EXTERNAL_INTERACTION_OVERRIDE_REASON		=(String) ext_drugData.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
				 EXTERNAL_CONTRA_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN");
				 EXTERNAL_ALERGY_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
				 ext_prod_id								=(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");
				ext_drugData.put("buildMAR_yn",buildMAR_yn); // RUT-CRF-0062 [IN029600] Added to retain the Build MAR value during confirm button click
				bean.setBuildMAR_yn(buildMAR_yn);
				 ext_drugData.put("DRUG_INDICATION", DrugIndicationRemarks);//Added For ML-BRU-CRF-072[Inc:29938]
                 ext_drugData.put("DrugRemarksEntered", DrugRemarksEntered);//added for [IN:039576]
				if((EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN.equals("Y") && EXTERNAL_DUPLICATE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN.equals("Y") && EXTERNAL_DOSAGE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN.equals("Y") && EXTERNAL_INTERACTION_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN.equals("Y") && EXTERNAL_CONTRA_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN.equals("Y") && EXTERNAL_ALERGY_OVERRIDE_REASON.equals("")) ){

					//ext_rsn_flag	= "N";
					//break;
				}

				 perform_external_database_checks_yn = (String) ext_drugData.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	

				//if( drug_code.equals(ext_drug_code) && srlno.equals(ext_srl_no) && !perform_external_database_checks_yn.equals("Y")){
			    if( drug_code.equals(ext_drug_code) && srlno.equals(ext_srl_no)){
		            allergy_yn						= (String)ext_drugData.get("ALLERGY_YN");
		            current_rx						= (String)ext_drugData.get("CURRENT_RX");

					HashMap dosageDetails= (HashMap) bean.chkMaxDosageLimit(drug_code,patient_id,temp_qty,dosage_type,repeat_value);//changed qty_value to temp_qty for ML-MMOH-CRF-1408

				if(!perform_external_database_checks_yn.equals("Y")){
					limit_ind = (String)dosageDetails.get("LIMIT_IND");
					if(limit_ind !=null){
						ext_drugData.put("LIMIT_IND",limit_ind);
						if(limit_ind.equals("Y"))
							ext_drugData.put("DOSE_REMARKS","");
					}
				 }
				limit_ind	= (String)ext_drugData.get("LIMIT_IND")==null?"":(String)ext_drugData.get("LIMIT_IND");

					if(limit_ind.equals("N")){
						dose_remarks=(String)ext_drugData.get("DOSE_REMARKS");
						if(dose_remarks == null ||dose_remarks.equals("")){
							dose_remarks = (String)ext_drugData.get("DOSAGE_LIMIT_OVERRIDE_REASON");
							if(dose_remarks != null){
								ext_drugData.put("DOSE_REMARKS",dose_remarks);
							}
						}

						if(dose_remarks==null ||dose_remarks.equals("")){
							flag ="N";
							dose_remarks_yn="Y"; //IN069887
						}
					}

					if(EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN.equals("N") && allergy_yn.equals("Y")){
						allergy_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
						if(allergy_remarks == null ||allergy_remarks.equals("")){
							allergy_remarks = (String)ext_drugData.get("ALLERGY_OVERRIDE_REASON");
							if(allergy_remarks != null){
								ext_drugData.put("ALLERGY_REMARKS",allergy_remarks);
							}
						}
						if(allergy_remarks==null ||allergy_remarks.equals("")){
							flag ="N";
							allergy_remarks_yn="Y"; //IN069887
						}
					}
					if(EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN.equals("N") && current_rx.equals("Y")){
						currentrx_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
						if(currentrx_remarks == null ||currentrx_remarks.equals("")){
							currentrx_remarks = (String)ext_drugData.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							if(currentrx_remarks != null){
								ext_drugData.put("CURRENTRX_REMARKS",currentrx_remarks);
							}
						}
						if(currentrx_remarks==null ||currentrx_remarks.equals("")){
							flag ="N";
							dup_remarks_yn="Y"; //IN069887
						}
					}
					break;
				}
				
			   }	
			  }
			}
		//}
		ext_drugData.put("freq_chng_durn_desc",freq_chng_durn_desc);
		if(ext_rsn_flag.equals("Y")){
				if(flag.equals("Y")){
					bean.amendDrugs(srl_no-1, hash);
					
					out.println("refreshLocation(\"" + patient_id + "\", \"" + encounter_id + "\",\""+problem_ind+"\", \""+order_date+"\",'3');") ;
				}
				else{
					//if(perform_external_database_checks_yn.equals("N")){
					//Added for IN:069887 start
					if(validate_overide_on_confirm_yn.equals("Y")){
						out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"')");
					}
					else{
					out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
					}
					//Added for IN:069887 end
				//		out.println("showOverRideRemarks('" + ext_srl_no + "','"+limit_ind+"');");
					//}
				}
		}else{			
			out.println("alert(getMessage('EXT_OVR_RSN_CANT_BLANK','PH'));");
       }
		putObjectInBean(bean_id,bean,request);	
	}
	else if (validate.equals("GETSCHEDULEDFREQORNOT")) {

		String freq_code	= request.getParameter("freq_code");
		String mode			= request.getParameter("mode");
		String serialNum    = request.getParameter("srl_no");
		String durn_value	= request.getParameter("durn_value");
		String amend_durn_type	= request.getParameter("durn_type"); //priya
		
		boolean sched_yn    = bean.getScheduledFreqYN(freq_code);
        String drug_code    = "";
		String ocurrance_num = "";

		bean.setFreq_code(freq_code);

		String durn_type=bean.getDurnType(freq_code);
		String repeat_value = bean.getRepeatValue();
		out.println("setSchedFreqActivated(\"" + sched_yn + "\", \"" + repeat_value + "\", \"" + mode + "\", \"" + durn_type+ "\");") ; //passed durn_type for IN26009 --20/01/2011-- priya
		String freqNature=bean.getFrequencyNature();
		out.println("StatFrequencyorNot('"+freqNature+"')");

		//out.println("setdurntype('"+durn_type+"')");

		ArrayList drugList			= bean.getDrugDetails();
		HashMap CompFluidDetails    = bean.getCompFluidDetails();
		
		if(drugList!=null&& !serialNum.equals("")){
			int srl_no =Integer.parseInt(serialNum);
			HashMap drugDetails			= (HashMap)drugList.get(srl_no-1);

			drug_code			            = (String)drugDetails.get("DRUG_CODE");			
			drugDetails.put("INTERVAL_VALUE",bean.getIntervalValue());
			drugDetails.put("amend_repeat_value",repeat_value);
			drugDetails.put("amend_durn_value",durn_value);
			drugDetails.put("amend_durn_type",amend_durn_type); //priya
			drugDetails.put("REPEAT_VALUE",repeat_value);
			drugDetails.put("FREQ_NATURE",freqNature);
			drugDetails.put("REPEAT_DURN_TYPE",durn_type); //added for IN26009 --20/01/2011-- priya
		}
       if(CompFluidDetails.containsKey("drug_code")){ 
		   HashMap fluidDetails =(HashMap) CompFluidDetails.get(drug_code+"_"+ocurrance_num);
	   }
		putObjectInBean(bean_id,bean,request);	
	}
	else if(validate.equals("GETFORMATID")) {

		String or_bean_name	= "eOR.OrderEntryBean";
		String or_bean_id	= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean = (OrderEntryBean)getBeanObject(or_bean_id, or_bean_name, request);
		//eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();

		String order_catalog_code	= request.getParameter("drug_code");
		String ocurrance_num	= request.getParameter("ocurrance_num");
		String order_type			= request.getParameter("order_type");
		String form_code			= request.getParameter("form_code");
		String route_code			= request.getParameter("route_code");
		String called_frm			= request.getParameter("called_frm");
		String click_yn			= request.getParameter("click_yn")==null?"":request.getParameter("click_yn");
		String order_category		= "PH";

		String format_id		= bean.getFormatId(order_category, order_type, order_catalog_code);	
		/*ArrayList pres_values	= bean.getPresValues(form_code, route_code, order_catalog_code);
		for(int i=0; i<pres_values.size(); i++)	{
			out.println("prescriptionValues(\""+(String)pres_values.get(i)+"\")");
		}
		out.println("validateRemarks(\"" + format_id + "\", '" + called_frm + "')");*/
		out.println("callOrder('" + format_id + "','"+called_frm+"','"+order_catalog_code+"','"+ocurrance_num+"','"+form_code+"','"+route_code+"','"+click_yn+"');");

		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(bean_id,bean,request);
	}
	else if(validate.equals("POPULATEENDDATE")) {
		String start_date	= request.getParameter("start_date");
		if(!locale.equals("en") && start_date!=null);  //if block added for scf-9366 [IN 57051]
			start_date  = com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",locale,"en"); 
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		String amend_yn=request.getParameter("amend_yn");//added for ml-mmoh-scf-1050
		String freq_nature=request.getParameter("freq_nature");//added for ml-mmoh-scf-1050
		String end_date		= bean.populateEndDate(start_date, durn_value, durn_unit);
	    if(!locale.equals("en") && end_date!=null) //if block added for scf-9366 [IN 57051]
		end_date  = com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);
	    //added for ml-mmoh-scf-1050 start
		if(amend_yn.equals("Y") && freq_nature.equals("Y")){
	    	
	    }
		else{
	    		out.println("setEndDate(\""+ end_date +"\", 'document.oncologyRegimenAdminDetail.end_date');");
	    }
	//added for ml-mmoh-scf-1050 end
		putObjectInBean(bean_id,bean,request);

	}
	else if(validate.equals("RELEASE")) {

		String ph_bean_name		= "ePH.PrescriptionBean_1";
		String ph_bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
		PrescriptionBean_1 phbean = (PrescriptionBean_1)getBeanObject(ph_bean_id, ph_bean_name, request);
		bean.setPresRemarks(phbean.getPresRemarks());

		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id, or_bean_name, request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

		ArrayList DrugRemarks	= new ArrayList();
		ArrayList fluidRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable

		HashMap orderFormatFluidHash	= new HashMap();	// To store it in the HashMap
		String order_format_values		= "";
		String row_value				= "";
		String catalog_code 			= "", drug_code = "";
		String drug_class 				= "";
		String ocurrance_num			= "";

		int seq_num = 0;

		String ext_rsn_flag		= "Y";
		
		String EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	= "";

		String EXTERNAL_DUPLICATE_OVERRIDE_REASON			= "";
		String EXTERNAL_DOSAGE_OVERRIDE_REASON				= "";
		String EXTERNAL_INTERACTION_OVERRIDE_REASON			= "";
		String EXTERNAL_CONTRA_OVERRIDE_REASON				= "";
		String EXTERNAL_ALERGY_OVERRIDE_REASON				= "";
		String narcotic_yn				= "N";
		String field_values_tmp = "";
		HashMap ext_drugData								= null;

		ArrayList drugList	= bean.getDrugDetails();
		//ML-MMOH-CRF-0345 - start
		String cycle_freq_yn								= "";
		String no_of_cycle									= "";
		HashMap duplicate									= null;
		ArrayList duplicate_list							= new ArrayList();
	
		
		String srl_no		= "";
		ArrayList time		= new ArrayList();
//		HashMap time_map	= null;
		ArrayList time_list = null;
		String day_list     = "1";
		String cycle_start_date = "";
		String cycle_end_date = "";
		String cycle_no		  = "";	//ML-MMOH-CRF-0345
		String checked_yn	  = "";//ML-MMOH-CRF-1004
		int kk			  =  0;//ML-MMOH-CRF-1004
		int mm			  = 0;//ML-MMOH-CRF-1227.1
		String allow_alternate = "";//GHL-CRF-0549
		System.err.println("drugList.size()====before add cycle===>"+drugList.size());
// added for CRF-345 - start
		if (drugList!=null && drugList.size() != 0) {
			for(int i=0;i<drugList.size();i++) {
				HashMap drugDetails = (HashMap)drugList.get(i);
				if (drugDetails!=null && drugDetails.size() != 0) {
					kk=0;//added for ML-MMOH-CRF-1004
					cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");
					allow_alternate = (String)drugDetails.get("allow_alternate")==null?"N":(String)drugDetails.get("allow_alternate"); //GHL-CRF-0549
					if(cycle_freq_yn.equals("Y")){
						no_of_cycle   = (String)drugDetails.get("NO_OF_CYCLE")==null?"":(String)drugDetails.get("NO_OF_CYCLE");
						drug_code	= (String)drugDetails.get("DRUG_CODE");
					
					    	srl_no	= (String)drugDetails.get("SRL_NO");
						HashMap hm = bean.getCycleDetails();
						HashMap hm_details = null;
						System.err.println("hm=============701===>"+hm);
						if(hm!=null && hm.size()>0){
							hm_details = (HashMap)hm.get(drug_code+srl_no);
						}
						for(int j = 0;j<Integer.parseInt(no_of_cycle);j++){
							duplicate	=	new HashMap();
							checked_yn  = "";//ML-MMOH-CRF-1004
			
							System.err.println("hm_details===707==>"+hm_details);
							if(hm_details!=null){
								time_list	= (ArrayList)hm_details.get("cycle_"+j);
								time		= (ArrayList)time_list.get(0);
								day_list	=  (String)time_list.get(1);
								cycle_no	= (String)time_list.get(2);
								cycle_start_date  =  (String)time_list.get(3);
								cycle_end_date =   (String)time_list.get(4);
								checked_yn	   =  (String)time_list.get(5);//ML-MMOH-CRF-1004
							}
							//ML-MMOH-CRF-1004 - start
							if(checked_yn==null)
								checked_yn = "";
							if(checked_yn.equals("Y")){
								kk++;
								mm++;//ML-MMOH-CRF-1227.1
							}
							

						//System.err.println("OncologyRegimenValidate.jsp=====kk value====767====>"+kk);
								if(kk!=0 && j!=Integer.parseInt(no_of_cycle) && checked_yn.equals("Y"))
								 duplicate	=	(HashMap)drugDetails.clone();

								if(kk==1 && checked_yn.equals("Y")){
									drugDetails.put("TIME_LIST",time);
									drugDetails.put("DAY_LIST",day_list);
									drugDetails.put("CYCLE_START_DATE",cycle_start_date);
									drugDetails.put("CYCLE_END_DATE",cycle_end_date);
									drugDetails.put("CYCLE_NO",cycle_no);
									drugDetails.put("CYCLE_INDEX",j+"");
									drugDetails.put("DRUG_INDEX",mm+""); //ML-MMOH-CRF-1227.1
									drugDetails.put("CYCLE_OCURRANCE_NUM",mm+""); //ML-MMOH-CRF-1227.1
									drugDetails.put("allow_alternate",allow_alternate);//GHL-CRF-0549
									//drugDetails.put("amend_start_date",cycle_start_date);
									//drugDetails.put("amend_end_date",cycle_end_date);
								}

							
							if(kk>1 && j!=Integer.parseInt(no_of_cycle) && checked_yn.equals("Y") ){//checked_yn added for ML-MMOH-CRF-1004
								duplicate.put("TIME_LIST",time);
								duplicate.put("DAY_LIST",day_list);
								duplicate.put("CYCLE_START_DATE",cycle_start_date);
								duplicate.put("CYCLE_END_DATE",cycle_end_date);
								duplicate.put("CYCLE_NO",cycle_no);
								duplicate.put("CYCLE_INDEX",j+"");
								duplicate.put("DRUG_INDEX",mm+""); //ML-MMOH-CRF-1227.1
								duplicate.put("CYCLE_OCURRANCE_NUM",mm+""); //ML-MMOH-CRF-1227.1
								duplicate.put("allow_alternate",allow_alternate);//GHL-CRF-0549
								//duplicate.put("amend_start_date",cycle_start_date);
								//duplicate.put("amend_end_date",cycle_end_date);
								duplicate_list.add(duplicate);
							}
						}

						
					}
				}
			}
		}
	HashMap hm1 = null;//ML-MMOH-CRF-1227.1 
	String dup_cycle_srl_no = "";//ML-MMOH-CRF-1227.1 
		if(duplicate_list!=null && duplicate_list.size()>0){
				for(int p=0; p<duplicate_list.size(); p++) {
					hm1 = (HashMap)duplicate_list.get(p);
					dup_cycle_srl_no = (String)hm1.get("DRUG_INDEX");
						drugList.add((Integer.parseInt(dup_cycle_srl_no)-1),hm1);
						//drugList.add(hm1);
			}
		}
		
// added for ML-MMOH-CRF-0345 - end
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
					drug_class		= (String)drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
					ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");					catalog_code	= drug_code+ocurrance_num; //+"Drug"
					row_value		= (catalog_code+"_"+"0");
					arrSeq_num		= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
					cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");//added for mms-kh-scf-0059
					if(drug_class.equals("N"))
						narcotic_yn = "Y";
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
	
							seq_num		= ((Integer.parseInt((String)arrSeq_num.get(k))) );
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
							//added for SRR20056-SCF-7085 IN26862 - start
							field_values_tmp = "";
							if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")){
								field_values_tmp = bean.getDrugRemarks((String) template.get("field_values"));
							}
							else{
								field_values_tmp = ((String) template.get("field_values")).trim();
							}
							if(field_values_tmp != null && !field_values_tmp.equals("") ){
								order_format_values =order_format_values+ ((String) template.get("label_text"))+" : "+ field_values_tmp +",";														
							}
							//added for SRR20056-SCF-7085 IN26862-end
							//order_format_values =order_format_values+((String) template.get("label_text") + " : " + (String) template.get("field_values")) +","; //commented for SRR20056-SCF-7085 IN26862
						}
						orderFormatHash.put("order_format_count", (String.valueOf(k)));
						orderFormatHash.put("order_format_values", order_format_values);
						orderFormatHash.put("drug_code", drug_code);
						orderFormatHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862

					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_format_values", "");
						orderFormatHash.put("drug_code", drug_code);
						orderFormatHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862
					}
					orderFormatHash.put("CYCLE_FREQ_YN", cycle_freq_yn); //added for mms-kh-scf-0059
					
					DrugRemarks.add(orderFormatHash);
				}
				// To get the Fluid Details
				if (drugDetails!=null && drugDetails.size() != 0) {
					orderFormatFluidHash= new HashMap();	// To store it in the HashMap
					arrSeq_num			= new ArrayList();	// get the seq in ArrayList
					template			= new Hashtable();	// get the template values in the HashTable
					drug_code			= (String)drugDetails.get("DRUG_CODE");
					ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
					catalog_code		= drug_code+ocurrance_num; //+"Fluid"
					row_value			= (catalog_code+"_"+"0");
					arrSeq_num 			= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
					cycle_freq_yn = (String)drugDetails.get("CYCLE_FREQ_YN")==null?"":(String)drugDetails.get("CYCLE_FREQ_YN");//added for mms-kh-scf-0059
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
							seq_num		= ((Integer.parseInt((String)arrSeq_num.get(k))) );
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatFluidHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatFluidHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatFluidHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatFluidHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatFluidHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatFluidHash.put("field_values"+k,(String) template.get("field_values"));
							//added for SRR20056-SCF-7085 IN26862 - start
							field_values_tmp = "";
							if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")){
								field_values_tmp = bean.getDrugRemarks((String) template.get("field_values"));
							}
							else{
								field_values_tmp = ((String) template.get("field_values")).trim();
							}
							if(field_values_tmp != null && !field_values_tmp.equals("") ){
								order_format_values =order_format_values+ ((String) template.get("label_text"))+" : "+ field_values_tmp +",";														
							}
							//added for SRR20056-SCF-7085 IN26862 - end
							//order_format_values =order_format_values+((String) template.get("label_text") + " : " + (String) template.get("field_values")) +","; //commented for SRR20056-SCF-7085 IN26862
						}
						orderFormatFluidHash.put("order_format_fluid_count", (String.valueOf(k)));
						orderFormatFluidHash.put("order_format_fluid_values", order_format_values);
						orderFormatFluidHash.put("drug_code", drug_code);
						orderFormatFluidHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862

					}
					else {
						orderFormatFluidHash.put("order_format_fluid_count", "0");
						orderFormatFluidHash.put("order_format_fluid_values", "");
						orderFormatFluidHash.put("drug_code", drug_code);
						orderFormatFluidHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862
					} 
					orderFormatFluidHash.put("CYCLE_FREQ_YN", cycle_freq_yn); //added for mms-kh-scf-0059
					fluidRemarks.add(orderFormatFluidHash);
				}
			}

			for(int j=0;j<drugList.size();j++){
				ext_drugData	=(HashMap) drugList.get(j);
				if(ext_drugData != null && ext_drugData.size()>0){
					 EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
					 EXTERNAL_DUPLICATE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
					 EXTERNAL_DOSAGE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
					 EXTERNAL_INTERACTION_OVERRIDE_REASON		=(String) ext_drugData.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
					 EXTERNAL_CONTRA_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN");
					 EXTERNAL_ALERGY_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
					 
					if((EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN.equals("Y") && EXTERNAL_DUPLICATE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN.equals("Y") && EXTERNAL_DOSAGE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN.equals("Y") && EXTERNAL_INTERACTION_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN.equals("Y") && EXTERNAL_CONTRA_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN.equals("Y") && EXTERNAL_ALERGY_OVERRIDE_REASON.equals("")) ){
						ext_rsn_flag	= "N";
						break;
					}
				}
			}
		}
		bean.setDrugRemarks(DrugRemarks);
		bean.setFluidRemarks(fluidRemarks);

		if(ext_rsn_flag.equals("N")){
			out.println("alert(getMessage('EXT_OVR_RSN_CANT_BLANK','PH'));");
       }
	   else{
		  	Hashtable hash	= (Hashtable)XMLobj.parseXMLString(request);
			hash			= (Hashtable)hash.get("SEARCH");
			String discharge_yn		= (String)hash.get("take_home_medication");
				if(discharge_yn.equals("Y")){bean.setPatientClass("OP");}
			hash.put("buildMAR_yn",bean.getBuildMAR_yn());
			HashMap returndata = bean.prepareOrderDetails(hash);
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			boolean result	= ((Boolean)returndata.get("result")).booleanValue();
			String message	= (String)returndata.get("message");
			if(message==null) message = "";
			String flag		= (String)returndata.get("flag");
			flag		= "";
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\", \"" + narcotic_yn + "\", \"" + print_ord_sht_rule_ind +"\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
	   }
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(ph_bean_id,phbean,request);
	}
	else if(validate.equals("AMENDRELEASE")){
		String ph_bean_name		= "ePH.PrescriptionBean_1";
		String ph_bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
		PrescriptionBean_1 phbean = (PrescriptionBean_1)getBeanObject(ph_bean_id, ph_bean_name, request);
		bean.setPresRemarks(phbean.getPresRemarks());

		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id, or_bean_name, request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

		ArrayList DrugRemarks	= new ArrayList();
		ArrayList fluidRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable

		HashMap orderFormatFluidHash	= new HashMap();	// To store it in the HashMap
		String order_format_values		= "";
		String row_value				= "";
		String catalog_code 			= "", drug_code = "";
		String ocurrance_num				= "";
		String drug_class				= "";
		String narcotic_yn				= "N";

		String ext_rsn_flag		= "Y";
		
		String EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	= "";

		String EXTERNAL_DUPLICATE_OVERRIDE_REASON			= "";
		String EXTERNAL_DOSAGE_OVERRIDE_REASON				= "";
		String EXTERNAL_INTERACTION_OVERRIDE_REASON			= "";
		String EXTERNAL_CONTRA_OVERRIDE_REASON				= "";
		String EXTERNAL_ALERGY_OVERRIDE_REASON				= "";
		HashMap ext_drugData								= null;
		String field_values_tmp = "";

		int seq_num = 0;
		ArrayList drugList	= bean.getDrugDetails();
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
					drug_class		= (String)drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
					if(drug_class.equals("N"))
						narcotic_yn = "Y"; 
					ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
					catalog_code	= drug_code+(i+1); //+"Drug";
					row_value		= (catalog_code+"_"+"0");
					arrSeq_num		= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
							seq_num		= ((Integer.parseInt((String)arrSeq_num.get(k))) );
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
							//added for SRR20056-SCF-7085 IN26862 - start
							field_values_tmp = "";
							if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")){
								field_values_tmp = bean.getDrugRemarks((String) template.get("field_values"));
							}
							else{
								field_values_tmp = ((String) template.get("field_values")).trim();
							}
							if(field_values_tmp != null && !field_values_tmp.equals("") ){
								order_format_values =order_format_values+ ((String) template.get("label_text"))+" : "+ field_values_tmp +",";														
							}
							//added for SRR20056-SCF-7085 IN26862 - end
							//order_format_values =order_format_values+((String) template.get("label_text") + " : " + (String) template.get("field_values")) +","; //commented for SRR20056-SCF-7085 IN26862
						}
						orderFormatHash.put("order_format_count", (String.valueOf(k)));
						orderFormatHash.put("order_format_values", order_format_values);
						orderFormatHash.put("drug_code", drug_code);
						orderFormatHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862
					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_format_values", "");
						orderFormatHash.put("drug_code", drug_code);
						orderFormatHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862
					}
					DrugRemarks.add(orderFormatHash);
				}

				// To get the Fluid Details
				if (drugDetails!=null && drugDetails.size() != 0) {
					orderFormatFluidHash= new HashMap();	// To store it in the HashMap
					arrSeq_num			= new ArrayList();	// get the seq in ArrayList
					template			= new Hashtable();	// get the template values in the HashTable
					drug_code			= (String)drugDetails.get("DRUG_CODE");
					ocurrance_num			= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
					catalog_code		= drug_code+"Fluid"+ocurrance_num;
					row_value			= (catalog_code+"_"+"0");
					arrSeq_num 			= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
							seq_num		= ((Integer.parseInt((String)arrSeq_num.get(k))) );
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatFluidHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatFluidHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatFluidHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatFluidHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatFluidHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatFluidHash.put("field_values"+k,(String) template.get("field_values"));
							//added for SRR20056-SCF-7085 IN26862 - start
							field_values_tmp = "";
							if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")){
								field_values_tmp = bean.getDrugRemarks((String) template.get("field_values"));
							}
							else{
								field_values_tmp = ((String) template.get("field_values")).trim();
							}
							if(field_values_tmp != null && !field_values_tmp.equals("") ){
								order_format_values =order_format_values+ ((String) template.get("label_text"))+" : "+ field_values_tmp +",";														
							}
							//added for SRR20056-SCF-7085 IN26862 - end
							//order_format_values =order_format_values+((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
						}
						orderFormatFluidHash.put("order_format_fluid_count", (String.valueOf(k)));
						orderFormatFluidHash.put("order_format_fluid_values", order_format_values);
						orderFormatFluidHash.put("drug_code", drug_code);
						orderFormatHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862 
					}
					else {
						orderFormatFluidHash.put("order_format_fluid_count", "0");
						orderFormatFluidHash.put("order_format_fluid_values", "");
						orderFormatFluidHash.put("drug_code", drug_code);
						orderFormatHash.put("OCURRANCE_NUM", ocurrance_num); //added for SRR20056-SCF-7085 IN26862
					}
					fluidRemarks.add(orderFormatFluidHash);
				}
			}

			for(int j=0;j<drugList.size();j++){
				 ext_drugData	=(HashMap) drugList.get(j);

				if(ext_drugData != null && ext_drugData.size()>0){

					 EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
					 EXTERNAL_DUPLICATE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
					 EXTERNAL_DOSAGE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
					 EXTERNAL_INTERACTION_OVERRIDE_REASON		=(String) ext_drugData.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
					 EXTERNAL_CONTRA_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
					 EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN");
					 EXTERNAL_ALERGY_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_ALERGY_OVERRIDE_REASON");

					if((EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN.equals("Y") && EXTERNAL_DUPLICATE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN.equals("Y") && EXTERNAL_DOSAGE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN.equals("Y") && EXTERNAL_INTERACTION_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN.equals("Y") && EXTERNAL_CONTRA_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN.equals("Y") && EXTERNAL_ALERGY_OVERRIDE_REASON.equals("")) ){
						ext_rsn_flag	= "N";
						break;
					}
				}
			}
		}
		
		bean.setDrugRemarks(DrugRemarks);
		bean.setFluidRemarks(fluidRemarks);
		if(ext_rsn_flag.equals("N")){
			out.println("alert(getMessage('EXT_OVR_RSN_CANT_BLANK','PH'));");
		}
		else{
			Hashtable hash	= (Hashtable)XMLobj.parseXMLString(request);
			hash			= (Hashtable)hash.get("SEARCH")	;	
			hash.put("buildMAR_yn",bean.getBuildMAR_yn());
			HashMap returndata = bean.prepareAmendOrderDetails(hash);
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			boolean result	= ((Boolean)returndata.get("result")).booleanValue();
			String message	= (String)returndata.get("message");
			if(message==null) message = "";
			String flag		= (String)returndata.get("flag");
			flag		= "";
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag+ "\", \"" + narcotic_yn + "\", \"" + print_ord_sht_rule_ind +"\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		}

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(ph_bean_id,phbean,request);
	}
	else if(validate!= null && validate.equals("clearData")){
		out.println("reloadPage()");
		bean.clear();
		putObjectInBean(bean_id,bean,request);
	}
	else if(validate.equals("CLEARBEAN")) {
		String calledFrom = request.getParameter("calledFrom");
		bean.clear();
		out.println("reloadScreens(\""+ calledFrom +"\", \""+ patient_id +"\", \""+ encounter_id +"\", \""+ order_date +"\", \""+ pat_class +"\",\""+problem_ind+"\");");
		putObjectInBean(bean_id,bean,request);
	}
	else if (validate.equals("AUTOSCHEDULE")) {

		Hashtable   schedule_val	= new Hashtable();
		//ArrayList   schedule		= null;
		Hashtable   sch_output		= null;
					patient_id		= request.getParameter("patient_id");
					encounter_id	= request.getParameter("encounter_id");
					bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
					bean_name		= "ePH.OncologyRegimenBean";
		OncologyRegimenBean on_bean	= (OncologyRegimenBean)getBeanObject( bean_id, bean_name , request) ;
		
		String durationType		= "D";
		String start_date		= request.getParameter("start_date");
		String qty_value		= request.getParameter("qty_value");
		String freq_code		= request.getParameter("freq_code");
		String drug_code		= request.getParameter("drug_code");
		String ocurrance_num	= request.getParameter("ocurrance_num");
		String repeat_durn_type	= request.getParameter("repeat_durn_type");
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";	
		String freqNature=bean.getFrequencyNature();//ML-MMOH-CRF-0345
		if(!on_bean.checkPreScheduled(freq_code).equals("0") && on_bean.getScheduledFreqYN(freq_code) && !freqNature.equals("Y") ) { // !freqNature.equals("Y") added for ML-MMOH-CRF-0345
			//schedule	=	(ArrayList)on_bean.getScheduleFrequencyStr(drug_code+ocurrance_num,"0");
			//if(schedule.size()==0) {
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request );
				schedule_bean.setLanguageId(on_bean.getLanguageId());
				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", "N"); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );				
				schedule_val.put("code",drug_code+ocurrance_num);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);		
				sch_output.put("code",drug_code+ocurrance_num);
				sch_output.put("row_value","1"); 		
				sch_output.put("start_date_time",start_date);

				durationType = (String)sch_output.get("durationType");
				on_bean.setScheduleFrequencyStr(sch_output);

				putObjectInBean(sch_bean_id,schedule_bean,request);
             //}   			
		}
		else{
				on_bean.clearscheduleFrequency(drug_code+ocurrance_num);
		}
		out.println("reloadDurnTypeList('"+durationType+"','"+repeat_durn_type+"')");
		putObjectInBean(bean_id,on_bean,request);

	}
	else if (validate.equals("DELETESCHEDULE")) {

		bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
		bean_name		= "ePH.OncologyRegimenBean";
		OncologyRegimenBean on_bean	= (OncologyRegimenBean)getBeanObject( bean_id, bean_name , request) ;
		
		String drug_code		= request.getParameter("drug_code");
		on_bean.clearscheduleFrequency(drug_code);
		//ArrayList schedule		=	null;
		//schedule	            =	(ArrayList)on_bean.getScheduleFrequencyStr(drug_code,"0");

		putObjectInBean(bean_id,on_bean,request);
	}
	else if(validate.equals("FLUIDREMARKS")){
	
		String fluid_remarks    = request.getParameter("fluid_remarks");

		bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
		bean_name		= "ePH.OncologyRegimenBean";
		OncologyRegimenBean on_bean	= (OncologyRegimenBean)getBeanObject( bean_id, bean_name , request) ;
		on_bean.setDefaultFluidremarks(fluid_remarks);

		putObjectInBean(bean_id,on_bean,request);

	}
	else if(validate.equals("OnlineReport")){
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);
		String prescriptionPrint		= (String)request.getParameter("prescriptionPrint");
		String NarcoticPrint			= (String)request.getParameter("NarcoticPrint");

		 String patient_class=request.getParameter("patient_class"); 
		 if(patient_class.equals("null")){patient_class="";}	
			String ReportOutput = bean.doPrinting(request,response,"", patient_class,prescriptionPrint,NarcoticPrint,patient_id);//code added for SKR-SCF-0915[IN046734]	
	}
	else if(validate.equals("OVERRIDE_REASON")) {
		
		    Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);
		              hash		= (Hashtable)hash.get("SEARCH") ;
			String drugCode		= (String)hash.get("drug_code");
			String srlNo		= (String)hash.get("srl_no");
			String allergy_yn	= (String)hash.get("allergy_yn");
			String limit_ind	= (String)hash.get("limit_ind");
			String current_rx	= (String)hash.get("current_rx");
			String allergy		=	"";
			String exceed_dose	=	"";
			String dup_drug		=	"";
			// Modified for IN:072715 START
			String dose_remarks_code = "", allergy_remarks_code = "", dup_drug_remarks_code = "";

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
				if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
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

      putObjectInBean(bean_id,bean,request);
	  prescriptionDetails	=	null;
	  ext_drugData		    =	null;
    }
	else if (validate != null &&  validate.equals("InsertExternalOverrideReason")) {
  		 Hashtable hash   = (Hashtable)XMLobj.parseXMLString(request);
		 hash			  = (Hashtable)hash.get("SEARCH") ;

		 HashMap drugDetails							=	null;
		 String extdrugCode								=	"";
		 String extsrlNo								=	"";
		 String drug_code								= (String)hash.get( "drug_code" );
		 String srl_no									= (String)hash.get( "srl_no" );
		 String External_Dosage_Override_Reason			= (String)hash.get("External_Dosage_Override_Reason");
		 String External_Duplicate_Override_Reason		= (String)hash.get("External_Duplicate_Override_Reason");
		 String External_Interaction_Override_Reason	= (String)hash.get("External_Interaction_Override_Reason");
		 String External_Contra_Override_Reason			= (String)hash.get("External_Contra_Override_Reason");
		 String External_Alergy_Override_Reason			= (String)hash.get("External_Alergy_Override_Reason");

		 if(!External_Dosage_Override_Reason.equals("")&& External_Dosage_Override_Reason!=null){
			External_Dosage_Override_Reason	=	java.net.URLDecoder.decode(External_Dosage_Override_Reason,"UTF-8");
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

		 ArrayList drugList	= bean.getDrugDetails();

		 if(drugList!=null && drugList.size()>0){
			
			for(int i=0;i<drugList.size();i++){
				drugDetails				= (HashMap)drugList.get(i);
				if(drugDetails != null && drugDetails.size()>0){
					extdrugCode				= (String)drugDetails.get("DRUG_CODE");
					extsrlNo				= (String)drugDetails.get("SRL_NO");

					if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){

						drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",External_Dosage_Override_Reason);
						drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",External_Duplicate_Override_Reason);
						drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",External_Interaction_Override_Reason);
						drugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON",External_Contra_Override_Reason);
						drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",External_Alergy_Override_Reason);
						drugDetails.put("ALLERGY_OVERRIDE_REASON",External_Alergy_Override_Reason);
						drugDetails.put("DUPLICATE_DRUG_OVERRIDE_REASON",External_Duplicate_Override_Reason);
					}
				}
			}
		 }
	}
	else if(validate.equals("ExternalDoseCheck")){
		Hashtable hash   = (Hashtable)XMLobj.parseXMLString(request);
		hash			  = (Hashtable)hash.get("SEARCH") ;
		String adm_prsc				=	(String)hash.get("adm_prsc");	
		String called_from					=	(String)hash.get("called_from");
			   patient_id					=	(String)hash.get("patient_id");
		String weight						=	(String)hash.get("weight");				        
		String bsa							=	(String)hash.get("bsa");	
		String pract_name                   =   (String)hash.get("pract_name");
		String repeat_value					=	(String)hash.get("repeat_value");		
		String interval_value				=	(String)hash.get("interval_value");			
		String duration					    =	(String)hash.get("durn_value");			
		String drug_db_dose_check_flag		=   "N";
		String frequency					=   (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
	
		ArrayList drugList	= bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		String extdrugCode						=   "";
		String extsrlNo							=   "";

		String external_prod_id             =	(String)hash.get("external_prod_id");
		String dosage						=	(String)hash.get("dose");
		String dosage_by					=	(String)hash.get("dosage_by");	
		String dose_uom						=	(String)hash.get("dose_uom");         
		String drug_code					=	(String)hash.get("drug_code");				
		String srl_no						=	(String)hash.get("srl_no");				
		String strength_per_pres_uom	    =	(String)hash.get("strength_per_pres_uom");	
		String strength_per_value_pres_uom	=	(String)hash.get("strength_per_value_pres_uom");	
		String fract_dose_round_up_yn		=	(String)hash.get("fract_dose_round_up_yn");		
		String external_dosage_override_reason		=	(String)hash.get("external_dosage_override_reason");
		String route_code	= (String)hash.get("route_code")==null?"":(String) hash.get( "route_code" );// Added in January 2014 for CIMS dosage check -start
		String qty_desc_code= (String)hash.get("qty_desc_code")==null?"":(String) hash.get( "qty_desc_code" );
		String repeat_durn_type	= hash.get("repeat_durn_type")==null?"":(String) hash.get( "repeat_durn_type" );
		String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
		String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end

		if(adm_prsc.equals("presc")){ // will not enter anytime
		   if(dosage_by != null && dosage_by.equals("S")){
				if(fract_dose_round_up_yn.equals("Y")){
					float unit_qty	 =  (float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
					dosage			 =   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
				}
				else{
					dosage			 =  (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
					dosage			 =  (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
				}
				DecimalFormat dfTest =  new DecimalFormat("##.000");
				dosage				 =  dfTest.format(Double.parseDouble(dosage));
				dosage				 =	Math.ceil(Float.parseFloat(dosage))+"";
			}

			String ext_beanid   = "@ExternalProductLinkBean";
			String ext_beanname = "ePH.ExternalProductLinkBean";
			ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
			HashMap drugDosageResult	= new HashMap();
			ArrayList dosageCheckParams = new ArrayList();
			dosageCheckParams.add(patient_id);
			dosageCheckParams.add(external_prod_id);
			dosageCheckParams.add(weight);
			dosageCheckParams.add(bsa);
			dosageCheckParams.add(dosage);
			if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
				dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
			else
				dosageCheckParams.add(dose_uom);
			dosageCheckParams.add(frequency);
			dosageCheckParams.add(duration);
			dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
			dosageCheckParams.add(repeat_durn_type);	 
			 if(freq_nature!=null && !freq_nature.equals(""))
				 freq_nature_pas =  freq_nature;
			 dosageCheckParams.add(freq_nature_pas);	
			 dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
			/* //commented for FDB Tuning
			drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);
			if(drugDosageResult != null && drugDosageResult.size() > 0){
				ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);	
				drug_db_dose_check_flag="Y";
			}
			else{
				HashMap ext_dosage_det =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
				if(ext_dosage_det != null && ext_dosage_det.size()>0){
					ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
				}
			}*/
			ArrayList reqChecks = new ArrayList();
			reqChecks.add("Y"); //Dosage Check 
			reqChecks.add("N"); //Duplicate Check
			reqChecks.add("N"); //DrugInteraction
			reqChecks.add("N"); //Contra Indication
			reqChecks.add("N"); //AllergyCheck
			HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", null ,null, dosageCheckParams, "N", "", ""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 

			drug_db_dose_check_flag = "N";
			if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
				drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
				if(drugDosageResult != null && drugDosageResult.size() > 0){
					ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);
					drug_db_dose_check_flag = "Y";
				}
			}
			if(drug_db_dose_check_flag.equals("N")){
				drugDosageResult =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
				if(drugDosageResult != null && drugDosageResult.containsKey(external_prod_id)){
					ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
				}
			}

			putObjectInBean(ext_beanid,ext_beanObj,request);
			if(drugList!=null && drugList.size()>0){
				for(int i=0;i<drugList.size();i++){
					drugDetails				= (HashMap)drugList.get(i);
					if(drugDetails != null && drugDetails.size()>0){
						extdrugCode				= (String)drugDetails.get("DRUG_CODE");
						extsrlNo				= (String)drugDetails.get("SRL_NO");
						if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
							drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
						}
					}
				}
			}
			if(!called_from.equals("ONLOAD")&& drug_db_dose_check_flag.equals("Y")){
				out.println("viewMedicationAlert('"+patient_id+"','"+external_prod_id+"','N','N','N','"+drug_db_dose_check_flag+"','"+called_from+"','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','','','','"+pract_name+"','')");
			}
			else{
				out.println("setextdoseflag('"+drug_db_dose_check_flag+"')");
			}
		}
		else{
			if(drugList!=null && drugList.size()>0){
				for(int i=0;i<drugList.size();i++){
					drugDetails					= (HashMap)drugList.get(i);
				//added for IN26007 --24/01/2011-- priya
					if(drugDetails.size()>0){
						extdrugCode				= (String)drugDetails.get("DRUG_CODE");
						extsrlNo				= (String)drugDetails.get("SRL_NO");
						if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){			
							
							if(drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS") != null && ((String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")).equals("Y")){
								external_prod_id				=	(String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
								//commented for IN26007 --24/01/2011-- priya
							//	dosage							=	(String)drugDetails.get("STRENGTH_VALUE"); 
					//			dosage_by						=	(String)drugDetails.get("DOSAGE_TYPE");	
					/*			if(dosage_by.equals("S")){
									dose_uom						=	(String)drugDetails.get("STRENGTH_UOM");         
								}else if(dosage_by.equals("Q")){ */

								dose_uom						=	(String)drugDetails.get("PRES_BASE_UOM");
					//			} 
								drug_code						=	(String)drugDetails.get("DRUG_CODE");				
								srl_no							=	(String)drugDetails.get("SRL_NO");				
								strength_per_pres_uom			=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
								strength_per_value_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
								fract_dose_round_up_yn			=	bean.getFractDoseRndyn(drug_code);
							
								if(dosage_by != null && dosage_by.equals("S")){

									if(fract_dose_round_up_yn.equals("Y")){
										float unit_qty	 =  (float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
										dosage			 =   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
									}
									else{
										dosage			 =  (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
										dosage			 =  (float)(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
									}

									DecimalFormat dfTest =  new DecimalFormat("##.000");
									dosage				 =  dfTest.format(Double.parseDouble(dosage));
									dosage				 =	Math.ceil(Float.parseFloat(dosage))+"";
								}

								String ext_beanid   = "@ExternalProductLinkBean";
								String ext_beanname = "ePH.ExternalProductLinkBean";
								ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
								HashMap drugDosageResult	= new HashMap();
								ArrayList dosageCheckParams = new ArrayList();
								dosageCheckParams.add(patient_id);
								dosageCheckParams.add(external_prod_id);
								dosageCheckParams.add(weight);
								dosageCheckParams.add(bsa);
								dosageCheckParams.add(dosage);
								if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
									dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
								else
									dosageCheckParams.add(dose_uom);
								dosageCheckParams.add(frequency);
								dosageCheckParams.add(duration);
								dosageCheckParams.add(route_code);	 // Added in January 2014 for CIMS-Dosage Checks -start
								dosageCheckParams.add(repeat_durn_type);	 
								if(freq_nature!=null && !freq_nature.equals(""))
									 freq_nature_pas =  freq_nature;
								dosageCheckParams.add(freq_nature_pas);	
								dosageCheckParams.add(interval_value);	 // Added in January 2014 for CIMS-Dosage Checks -end
								/*drugDosageResult = ext_beanObj.getDrugDosageCheck(dosageCheckParams);
								if(drugDosageResult != null && drugDosageResult.size() > 0){
									ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);	
									drug_db_dose_check_flag="Y";
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
									out.println("DisplayFDBOverrideImage('"+srl_no+"','DOSAGE');");	
								}else{
									
									 HashMap ext_dosage_det =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
									 if(ext_dosage_det != null && ext_dosage_det.size()>0){
											drug_db_dose_check_flag="N";
											drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
											ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
											out.println("HideFDBOverrideImage('"+srl_no+"','DOSAGE');");									
									 }
								}	*/
								ArrayList reqChecks = new ArrayList();
								reqChecks.add("Y"); //Dosage Check 
								reqChecks.add("N"); //Duplicate Check
								reqChecks.add("N"); //DrugInteraction
								reqChecks.add("N"); //Contra Indication
								reqChecks.add("N"); //AllergyCheck
								HashMap drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, external_prod_id, patient_id, "", null ,null, dosageCheckParams, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
								drug_db_dose_check_flag = "N";
								if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
									drugDosageResult = (HashMap)drugDBCheckResult.get("DOSECHECK");
									if(drugDosageResult != null && drugDosageResult.size() > 0){
										ext_beanObj.setDosageCheck(external_prod_id, srl_no,drugDosageResult);
										drug_db_dose_check_flag = "Y";
										drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
										out.println("DisplayFDBOverrideImage('"+srl_no+"','DOSAGE');");	
									}
								}
								if(drug_db_dose_check_flag.equals("N")){
									drugDosageResult =ext_beanObj.getDosageCheck(external_prod_id, srl_no);
									if(drugDosageResult != null && drugDosageResult.containsKey(external_prod_id)){
										ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
									}
									drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
									ext_beanObj.removeDosageCheck(external_prod_id, srl_no);
									out.println("HideFDBOverrideImage('"+srl_no+"','DOSAGE');");
								}
							}
						}//
					}//
				}
			}
		}
	}
	else if(validate.equals("dfltDispLocn")){
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);		
		hash				= (Hashtable)hash.get("SEARCH") ;			

		 String location_type			= (String)hash.get("location_type");
		 String location_code			= (String)hash.get("location_code");
		 String take_home_medication	= (String)hash.get("take_home_medication");
		 String priority				= (String)hash.get("priority");
		 String iv_prep_yn				= (String)hash.get("iv_prep_yn");
		 //String drug_code	            = (String)hash.get("drug_code");
		  patient_id				= (String)hash.get("patient_id");//added for MMS-QH-CRF-0048 [IN:037704]
		  encounter_id			= (String)hash.get("encounter_id");//added for MMS-QH-CRF-0048 [IN:037704]
	 	 String dflt_disp_locn	= "";	

		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocationForCyto(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
		String time_flag = "";

		if(ord_disp_location != null & ord_disp_location.size()>0){ 
			dflt_disp_locn	= (String)ord_disp_location.get(2); 
			if(dflt_disp_locn == null ){
				dflt_disp_locn = "";
			}
			bean.setDispLocnCode((String)ord_disp_location.get(0)); //Added for NMC-JD-CRF-0046
			time_flag   =  bean.ChkWorkingHours( (String)ord_disp_location.get(0));

			out.println("paintDispLocn('"+dflt_disp_locn+"','"+time_flag+"');");
		}
	}
	else if (validate!= null && validate.equals("GET_TRNGROUPREF")){
		String tokens_generated_yn = bean.getTokensGeneratedYN();
		String trn_group_ref = "";
		if(tokens_generated_yn.equals("Y")){
			trn_group_ref = bean.getTrnGroupRef();
		}
		out.println(trn_group_ref);
	}
	else if (validate!= null && validate.equals("SAVE_SCREEN_VALUES")){
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);		
		hash				= (Hashtable)hash.get("SEARCH") ;			
		patient_id				= (String)hash.get("patient_id")==null?"":(String)hash.get("patient_id");
		encounter_id				= (String)hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
		String drug_code	            = (String)hash.get("drug_code");
		String amend_fluid_code	            = (String)hash.get("amend_fluid_code")==null?"":(String)hash.get("amend_fluid_code");
		String	dose	= (String)hash.get("dose")==null?"":(String)hash.get("dose");
		String	durn_value=(String)hash.get("DURN_VALUE")==null?"":(String)hash.get("DURN_VALUE");
		String	amend_repeat_value=(String)hash.get("amend_repeat_value")==null?"":(String)hash.get("amend_repeat_value");	
		String	amend_durn_value=(String)hash.get("amend_durn_value")==null?"":(String)hash.get("amend_durn_value");	
		String	amend_stock_value=(String)hash.get("amend_stock_value")==null?"":(String)hash.get("amend_stock_value");	
		String	ocurrance_num=(String)hash.get("ocurrance_num")==null?"":(String)hash.get("ocurrance_num");	
		String amend_durn_type = (String)hash.get("amend_durn_type")==null?"":(String)hash.get("amend_durn_type"); //priya
		String temp_drug_code = "";
		//String fluid_code = "";
		HashMap drugDetails = new HashMap();
		ArrayList drugList = bean.getDrugDetails();

		for(int i=0;i<drugList.size();i++){
			drugDetails = (HashMap)drugList.get(i);
			temp_drug_code	= (String)drugDetails.get("DRUG_CODE");
			if(drug_code.equals(temp_drug_code)){
				drugDetails.put("dose",dose);
				drugDetails.put("durn_value",durn_value);
				drugDetails.put("amend_repeat_value",amend_repeat_value);
				drugDetails.put("amend_durn_value",amend_durn_value);
				drugDetails.put("amend_durn_type",amend_durn_type); //priya
				drugDetails.put("amend_stock_value",amend_stock_value);
				if((!amend_fluid_code.equals(""))&& !amend_fluid_code.equals((String)drugDetails.get("amend_fluid_code"))){
					drugDetails.put("amend_fluid_code",amend_fluid_code);
					bean.setFluidDetails(amend_fluid_code, drug_code,ocurrance_num);
				}
				break;
			}
		}
	}
	else if (validate!= null && validate.equals("GET_BL_ERROR_DRUGS")){
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);		
		hash				= (Hashtable)hash.get("SEARCH") ;			
		patient_id				= (String)hash.get("patient_id")==null?"":(String)hash.get("patient_id");
		encounter_id				= (String)hash.get("encounter_id")==null?"":(String)hash.get("encounter_id");
		String drug_code	            = (String)hash.get("drug_code");
		String ocurrance_num	            = (String)hash.get("ocurrance_num");
		String amend_fluid_code	            = (String)hash.get("amend_fluid_code")==null?"":(String)hash.get("amend_fluid_code");
		String actual_patient_class				= (String)hash.get("actual_patient_class")==null?"":(String)hash.get("actual_patient_class");
		String episode_type = actual_patient_class.substring(0,1);
		if(episode_type.equals("X"))
			episode_type = "R";
		String strength_per_value_pres_uom = "";
		String strength_per_pres_uom = "";
		String fract_dose_round_up_yn = "";
		String ordered_qty = "";
		String interval_value = "";
		String durn_value = "";
		String amend_durn_value = "";
		String amend_repeat_value = "";
		String qty_value = "";
		String pack_size = "";
		String temp_drug_code = "";
		String temp_ocurrance_num  = "";
		String in_formulary_yn = "";
		String fluid_code = "";
		String fluid_name = "";
		String drug_desc = "";
		String item_code = "";
		String freq_nature = "";
		String bl_error_code	="";
		String bl_sys_message_id = "";
		String bl_error_text	 = "";
		String dose	 = "";
		String take_home_medication		= (String)hash.get("take_home_medication");
		float ing_unit_qty = 0.0f;
		float in_tot_qty	= 0.0f;	
		HashMap drugDetails = new HashMap();
		HashMap fluidDetails = new HashMap();
		ArrayList drugList = bean.getDrugDetails();
		ArrayList blErrorDrugs = new ArrayList();

		HashMap CompFluidDetails = bean.getCompFluidDetails();


		for(int i=0;i<drugList.size();i++){
			fluidDetails = new HashMap();
			drugDetails = (HashMap)drugList.get(i);

			temp_drug_code		= (String)drugDetails.get("DRUG_CODE");
			temp_ocurrance_num	= (String)drugDetails.get("OCURRANCE_NUM");

			if((!amend_fluid_code.equals(""))&& drug_code.equals(temp_drug_code) && (!amend_fluid_code.equals((String)drugDetails.get("amend_fluid_code")))){
				bean.setFluidDetails(amend_fluid_code, drug_code,ocurrance_num);
			}

			drug_desc	= (String)drugDetails.get("DRUG_DESC");
			item_code=(String)drugDetails.get("ITEM_CODE");
			in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
			if(in_formulary_yn.equals("Y")){
				pack_size	= bean.getPackSize(temp_drug_code);	
				if(drug_code.equals(temp_drug_code)){
					dose	= (String)hash.get("dose");
					durn_value=(String)hash.get("DURN_VALUE")==null?"":(String)hash.get("DURN_VALUE");
					amend_repeat_value=(String)hash.get("amend_repeat_value")==null?"":(String)hash.get("amend_repeat_value");	
					amend_durn_value=(String)hash.get("amend_durn_value")==null?"":(String)hash.get("amend_durn_value");	
				}
				else{
					dose	= (String)drugDetails.get("dose");
					durn_value=(String)drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
					amend_repeat_value=(String)drugDetails.get("amend_repeat_value")==null?"":(String)drugDetails.get("amend_repeat_value");	
					amend_durn_value=(String)drugDetails.get("amend_durn_value")==null?"":(String)drugDetails.get("amend_durn_value");	
				}
				if(dose == null || dose.equals("")){
					dose = (String)drugDetails.get("QTY_VALUE");
				}
				ing_unit_qty = Float.parseFloat(dose);

				if(drugDetails.get("DOSAGE_TYPE") !=null){
				   if(drugDetails.get("DOSAGE_TYPE").toString().equals("S")) {				
						strength_per_value_pres_uom	=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
						strength_per_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM")==null?"":(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
						fract_dose_round_up_yn     =(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");	
						interval_value     =(String)drugDetails.get("INTERVAL_VALUE")==null?"":(String)drugDetails.get("INTERVAL_VALUE");	

						in_tot_qty	= 0.0f;

						if(fract_dose_round_up_yn.equals("Y")){
							in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);

						}
						else{
							in_tot_qty	=new Double(Math.ceil(ing_unit_qty/Float.parseFloat(strength_per_pres_uom))).floatValue() * Float.parseFloat(strength_per_value_pres_uom);

						}
						if (freq_nature.equals("I")) {
							in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
						}
						else if (freq_nature.equals("F") || freq_nature.equals("C")) {
							in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));
						}
						else if (freq_nature.equals("O")) {
							in_tot_qty = in_tot_qty;
						}
						
					   ordered_qty=in_tot_qty+"";
					   ordered_qty=(Math.ceil(Float.parseFloat(ordered_qty)/Float.parseFloat(pack_size)))+"";

						
					}
					else{
						String qty_unit				= (String)drugDetails.get("QTY_DESC_CODE");
						String ing_order_uom		= (String)drugDetails.get("PRES_BASE_UOM");
						String eqvl_value			=  bean.getConvFactor(ing_order_uom,qty_unit);
						if(eqvl_value.equals(""))	eqvl_value	=	"1";
						
						in_tot_qty	= 0.0f;
						if(fract_dose_round_up_yn.equals("Y")){
							in_tot_qty	=new Double(Math.ceil(ing_unit_qty/(Float.parseFloat(pack_size)))).floatValue() * Float.parseFloat(eqvl_value);	
						}
						else{
							in_tot_qty = ing_unit_qty*Float.parseFloat(eqvl_value);
						}

						if (freq_nature.equals("I")) {
							in_tot_qty = in_tot_qty*(Float.parseFloat(durn_value))*(24/(Float.parseFloat(interval_value)));
						}
						else if (freq_nature.equals("F") || freq_nature.equals("C")) {
							in_tot_qty = in_tot_qty*(Float.parseFloat(amend_repeat_value))*(Float.parseFloat(amend_durn_value));
						}
						else if (freq_nature.equals("O")) {
							in_tot_qty = in_tot_qty;
						}

						if(!fract_dose_round_up_yn.equals("Y")){
							in_tot_qty	=   new Double(Math.ceil((in_tot_qty)/Float.parseFloat(pack_size))).floatValue();
						}	
						ordered_qty=in_tot_qty+"";

					}
					ordered_qty=new Float(ordered_qty).intValue()+"";

					bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
					bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
					bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
					bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
					drug_desc			= (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");

					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add("D");
						blErrorDrugs.add(temp_drug_code);
						blErrorDrugs.add(drug_desc);
						blErrorDrugs.add(bl_error_code);
						blErrorDrugs.add(bl_sys_message_id);
						blErrorDrugs.add(bl_error_text);
					}
				}
			}

				if(drug_code.equals(temp_drug_code)){
					fluidDetails =(HashMap) CompFluidDetails.get(temp_drug_code+"_"+temp_ocurrance_num);
				}

			if(fluidDetails !=null && fluidDetails.size()>0){
				in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
				if(in_formulary_yn.equals("Y")){
					fluid_name			= (String)fluidDetails.get("DRUG_DESC");
					qty_value			= (String)fluidDetails.get("QTY_VALUE");

					fluid_code=(String)fluidDetails.get("DRUG_CODE");
					item_code=(String)fluidDetails.get("ITEM_CODE");
					pack_size	= bean.getPackSize(fluid_code);			
					ordered_qty		= (Math.ceil((Float.parseFloat(qty_value)) / Float.parseFloat(pack_size)))+""; 

					ordered_qty		= (Math.ceil((Float.parseFloat(ordered_qty)) * (Float.parseFloat(amend_durn_value))*(Float.parseFloat(amend_repeat_value))))+"";

					ordered_qty=new Float(ordered_qty).intValue()+"";				
					
					bean.setBillingDetail(fluidDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication);
					bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
					bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
					bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
					drug_desc			= (String)drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");

					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add("F");
						blErrorDrugs.add(fluid_code);
						blErrorDrugs.add(fluid_name);
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
	}else if (validate!= null && validate.equals("addNewDrugToList")){
		String drugCodes = request.getParameter("drugCodes");

		Hashtable hash   = (Hashtable)XMLobj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		bean.setBuildMAR_yn((String)hash.get("buildMAR_yn"));	 //CRF-0062 NEWLY ADDED
		boolean is_dup	= false;
		ArrayList drugList					= bean.getDrugDetails();

		ArrayList exstng_drug_codes			= bean.getDrugCodes();
		ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();

		HashMap	fluid_details		= (HashMap)bean.getCompFluidDetails();
		HashMap exst_fluid_dtls		= new HashMap();
		HashMap exst_drug_dtls		= new HashMap();
		String	dflt_fluid_code		= "";
		String  exst_drug_code		= "";
		if(exstng_drug_codes.contains(drugCodes)){
			is_dup	= true;
		}

		if(!is_dup){
			for(int i = 0;i<exstng_drug_codes.size()-1;i=i+2){ // -1 Added for 69759
				if(fluid_details.size()>0){
					exst_fluid_dtls	= (HashMap)fluid_details.get(exstng_drug_codes.get(i)+"_"+exstng_drug_codes.get(i+1));
				}
				if(exst_fluid_dtls != null && exst_fluid_dtls.size()>0){
					if(drugCodes.equals(exst_fluid_dtls.get("DRUG_CODE"))){
						is_dup	= true;
						break;
					}
				}
			}
		}

		if(!is_dup){
			for(int j = 0;j<drugList.size();j++){
				dflt_fluid_code = "";
				exst_drug_code	= "";
				exst_drug_dtls	= (HashMap)drugList.get(j);
				if(exst_drug_dtls != null && exst_drug_dtls.size()>0){
					exst_drug_code		= (String)exst_drug_dtls.get("DRUG_CODE"); 
					if(!fluid_details.containsKey(exst_drug_code)){
						dflt_fluid_code		= (String)exst_drug_dtls.get("DEFLT_FLUID_CODE");
						if(dflt_fluid_code == null){dflt_fluid_code = "";}
						if(drugCodes.equals(dflt_fluid_code)){
							is_dup	= true;
							break;
						}
					}
				}
			}
		}

		if(is_dup){
			out.println("alredyInRegimen();");
		}
		else{			
			bean.addToDrugCodes(drugCodes);
			bean.setDrugDetails(drugCodes,hash);
		}
	}
	else if (validate.equals("OverRideReasonChecks")) {
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString(request);		
		hash				= (Hashtable)hash.get("SEARCH") ;			

		String flag                     = "Y";
		String ext_rsn_flag				= "Y";
		String dose_remarks				= "";
		String allergy_remarks			= "";
		String currentrx_remarks		= "";
		String limit_ind                = "";
		String allergy_yn               = "";
		String current_rx               = "";

		String EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN		= "";
		String EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	= "";

		String EXTERNAL_DUPLICATE_OVERRIDE_REASON			= "";
		String EXTERNAL_DOSAGE_OVERRIDE_REASON				= "";
		String EXTERNAL_INTERACTION_OVERRIDE_REASON			= "";
		String EXTERNAL_CONTRA_OVERRIDE_REASON				= "";
		String EXTERNAL_ALERGY_OVERRIDE_REASON				= "";

		ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();
		HashMap ext_drugData			=	null;

		for(int j=0;j<prescriptionDetails.size();j++){
			 ext_drugData	=(HashMap) prescriptionDetails.get(j);
			if(ext_drugData != null && ext_drugData.size()>0){
				 				 
				 EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
				 EXTERNAL_DUPLICATE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
				 EXTERNAL_DOSAGE_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN		=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
				 EXTERNAL_INTERACTION_OVERRIDE_REASON		=(String) ext_drugData.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
				 EXTERNAL_CONTRA_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
				 EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN	=(String) ext_drugData.get("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN");
				 EXTERNAL_ALERGY_OVERRIDE_REASON			=(String) ext_drugData.get("EXTERNAL_ALERGY_OVERRIDE_REASON");

				if((EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN.equals("Y") && EXTERNAL_DUPLICATE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN.equals("Y") && EXTERNAL_DOSAGE_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN.equals("Y") && EXTERNAL_INTERACTION_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN.equals("Y") && EXTERNAL_CONTRA_OVERRIDE_REASON.equals("")) || (EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN.equals("Y") && EXTERNAL_ALERGY_OVERRIDE_REASON.equals("")) ){
					ext_rsn_flag	= "N";
					break;
				}

				    allergy_yn	= (String)ext_drugData.get("ALLERGY_YN");
		            current_rx	= (String)ext_drugData.get("CURRENT_RX");
					limit_ind	= (String)ext_drugData.get("LIMIT_IND")==null?"":(String)ext_drugData.get("LIMIT_IND");;

					if(limit_ind.equals("N")){
						dose_remarks=(String)ext_drugData.get("DOSE_REMARKS");

						if(dose_remarks==null ||dose_remarks.equals("")){
							flag ="N";
						}
					}
					if(EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN.equals("N") && allergy_yn.equals("Y")){
						allergy_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
						if(allergy_remarks==null ||allergy_remarks.equals("")){
							flag ="N";
						}
					}
					if(EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN.equals("N") && current_rx.equals("Y")){
						currentrx_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
						if(currentrx_remarks==null ||currentrx_remarks.equals("")){
							flag ="N";
						}
					}
					//break;  code commented by kiran
			  }
			}


		if(ext_rsn_flag.equals("Y")){
				if(!flag.equals("Y")){
					out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
					out.println("changeRsnStatus('false')");
				}
				else{ //else part added by kiranon 19/3/2010
				out.println("changeRsnStatus('true')"); //line added by kiran on 19/3/2010
				}
		}else{
			out.println("alert(getMessage('EXT_OVR_RSN_CANT_BLANK','PH'));");
			out.println("changeRsnStatus('false')");
       }
	}else if (validate!= null && validate.equals("setChangedDosage")){
		Hashtable hash			= (Hashtable)XMLobj.parseXMLString(request);		
		hash					= (Hashtable)hash.get("SEARCH") ;			
		String drug_code	    = (String)hash.get("drug_code");
		String ocurrance_num	= (String)hash.get("ocurrance_num");
		String chngd_dose_value	= (String)hash.get("chngd_dose_value");

		HashMap		drugFrequencies	= new HashMap();
		ArrayList	frequencyValues = new ArrayList();
		ArrayList	dose_list		= new ArrayList();
		

			drugFrequencies = (HashMap)bean.getscheduleFrequency();
			frequencyValues = (ArrayList)drugFrequencies.get(drug_code+ocurrance_num);
			if(frequencyValues != null && frequencyValues.size()>0){
					dose_list = (ArrayList)frequencyValues.get(4);
					int list_size = dose_list.size();
					dose_list.clear();
					for(int i=0;i<list_size;i++){
						dose_list.add(chngd_dose_value);
					}
			}

	}
/*================================================================================================================*/
//added for IN27290 --24/05/2011-- priya
	else if (validate!= null && validate.equals("setChangedUom")){
		Hashtable hash			= (Hashtable)XMLobj.parseXMLString(request);		
		hash					= (Hashtable)hash.get("SEARCH") ;			
		String drug_code	    = (String)hash.get("drug_code");
		String drug_unit_code	= (String)hash.get("drug_unit_code");
		HashMap dosageUOM = new HashMap();
		dosageUOM = bean.getDosageUOMS();
		dosageUOM.put(drug_code,drug_unit_code);

		bean.setDosageUOMS(dosageUOM);

	}
/*================================================================================================================*/
	else if (validate!= null && validate.equals("SAVECYCLESCHEDULE")){ //added for ML-MMOH-CRF-0345  -start
	Hashtable hash			= (Hashtable)XMLobj.parseXMLString(request);		
	hash					= (Hashtable)hash.get("SEARCH") ;	

	int no_of_cyle			= Integer.parseInt((String)hash.get("no_of_cyle")==null?"1":(String)hash.get("no_of_cyle"));
	int repeat_value		= Integer.parseInt((String)hash.get("repeat_value")==null?"1":(String)hash.get("repeat_value"));
	String repeat_drun_type =  (String)hash.get("repeat_drun_type");
	String drug_code		=  (String)hash.get("drug_code");
	String srl_no			=  (String)hash.get("srl_no");
	ArrayList timeList      = new ArrayList();
//	ArrayList dayList       = new ArrayList();
	ArrayList cycleList     = new ArrayList();
	HashMap  hm = new HashMap();

	String	time        = "";
	String  day_list	= "";
	String  cycle_start_date = "";
	String  cycle_end_date = "";
	String	admin_cycle    = "";
	String  start_date	   = "";
	String cycle_checked_yn	   = "";//ML-MMOH-CRF-1004

	

	//if(repeat_drun_type.equals("W")){
		
		for(int i=0;i<no_of_cyle;i++){
		time = "";
		day_list =(String)hash.get("admin_day_"+i+"");
		cycle_checked_yn = (String)hash.get("cycle_checked_yn_"+i+"");//ML-MMOH-CRF-1004
		cycle_start_date = (String)hash.get("cycle_start_date_"+i+"");
		if(i==0)
			start_date = cycle_start_date;
		cycle_end_date = (String)hash.get("cycle_end_date_"+i+"");
		if(repeat_drun_type.equals("W") || repeat_drun_type.equals("L"))
			admin_cycle	   = (String)hash.get("cycle_"+i+"");

		timeList = new ArrayList();
		cycleList = new ArrayList();
		 for(int j=0;j<repeat_value;j++){
		 	time = (String)hash.get("time_"+i+"_"+j+"");
			timeList.add(time);
		 }
		cycleList.add(timeList);
		cycleList.add(day_list);

		if(repeat_drun_type.equals("W") || repeat_drun_type.equals("L"))
		  cycleList.add(admin_cycle);
		else
   		  cycleList.add("");

		cycleList.add(cycle_start_date);
		cycleList.add(cycle_end_date);
		cycleList.add(cycle_checked_yn);//added for ML-MMOH-CRF-1004

		hm.put("cycle_"+i,cycleList);
		}

	
	//}
		bean.setCycleDetails(drug_code+srl_no,hm);
		out.println("windowReturn(\"" + start_date + "\", \"" + cycle_end_date + "\")");

	
//	bean.setCycleDetails(drug_code+srl_no,hm);
	}else if (validate!= null && validate.equals("getToolTipData")){
	Hashtable hash			= (Hashtable)XMLobj.parseXMLString(request);		
	hash					= (Hashtable)hash.get("SEARCH") ;	

	String drug_code		=  (String)hash.get("drug_code");
	String no_of_cycle		=  (String)hash.get("no_of_cycle")==null?"0":(String)hash.get("no_of_cycle");
	String srl_no			=  (String)hash.get("srl_no");
	String qty_value		=  (String)hash.get("qty_value");
	String dose_uom			=  (String)hash.get("dose_uom")==null?"":(String)hash.get("dose_uom");//ML-MMOH-CRF-1004
	String tooltiptable		= "";
	String admin_time       = "";
	
		
	tooltiptable = (String)bean.getTooltipStringFrFreq(drug_code,srl_no,no_of_cycle,qty_value,dose_uom);//dose_uom added for ML-MMOH-CRF-1004
	admin_time = tooltiptable;
	
	out.println("displayCycleToolTip1(\"" + admin_time + "\", \"" + qty_value + "\")");
	//out.println("displayCycleToolTip1('"+tooltiptable+"','"+admin_qty+"')");

	}else if(validate!= null && validate.equals("getStartDateForCycle")){
	
	Hashtable hash			=  (Hashtable)XMLobj.parseXMLString(request);		
	hash					=  (Hashtable)hash.get("SEARCH") ;	
	String admin_day		=  (String)hash.get("admin_day");
	String start_date_time	=  (String)hash.get("start_date_time");
	String cycle_row		=  (String)hash.get("cycle_row");
	String start_date		=   bean.getSysdatePlusDays(start_date_time,admin_day+"");
	String end_date			=   bean.getSysdatePlusDays(start_date,1+"");
	
	out.println("assignStartEndDate(\"" + start_date + "\", \"" + end_date + "\", \"" + cycle_row + "\")");

	}else if(validate!= null && validate.equals("getCycleFreqDetails")){
	
	Hashtable hash			=  (Hashtable)XMLobj.parseXMLString(request);		
	hash					=  (Hashtable)hash.get("SEARCH") ;
	String freq_code		=  (String)hash.get("freq_code");
	String repeat_durn_type	=  (String)hash.get("repeat_durn_type");
	String repeat_value		=  (String)hash.get("repeat_value");
	String start_date		=  (String)hash.get("start_date");
	String drug_code		=  (String)hash.get("drug_code");
	String srlNo			=  (String)hash.get("srlNo");
	String no_of_cycle		=	"";

	bean.setFreq_code(freq_code);
	String freqNature=bean.getFrequencyNature();
	bean.setCycleDetails(drug_code+srlNo,new HashMap());
	if(freqNature.equals("Y")){
	 bean.loadCycleFreqDetails(freq_code,facility_id,repeat_durn_type,repeat_value,start_date,drug_code,srlNo);
	 no_of_cycle = bean.getMaxCycle(freq_code)+"";
	 String end_date = bean.getOrderEndDate();
	 out.println("assignNoOfCycle(\"" + no_of_cycle + "\", \"" + repeat_durn_type + "\", \"" + end_date + "\")");
	}
	}//added for ML-MMOH-CRF-0345  -end
	else if(validate.equals("POPULATEENDDATE1")) {//ML-MMOH-CRF-1014 - start
		String start_date	= request.getParameter("start_date");
		String durn_value	= request.getParameter("durn_value");
		String durn_unit	= request.getParameter("durn_unit");
		String mode			= request.getParameter("mode");
		String end_date		= bean.populateEndDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",bean.getLanguageId(),"en"), durn_value, durn_unit); 
        
		if(!bean.getLanguageId().equals("en")){
			end_date=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",bean.getLanguageId());  
		}
		String rowNum = "";
		
		if (mode.equals("MFR")){
			rowNum = request.getParameter("rowNum");
			out.println("setEndDate('"+ end_date +"','"+rowNum+"');");
		}
		else if (mode.equals("MFRStart")){
			rowNum = request.getParameter("rowNum");
			out.println("setStartDate('"+ end_date +"','"+rowNum+"');");
		}
		else
			out.println("setEndDate('"+ end_date +"','document.oncologyRegimenAdminDetail.END_DATE');");
	}else if(validate.equals("SAVE_MFR")){
		Hashtable hash   = (Hashtable)XMLobj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		String totRec		= (String)hash.get("noOfRows")==null?"0":(String)hash.get("noOfRows");
		String drug_code    = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String srlNo		= request.getParameter("srlNo")==null?"":request.getParameter("srlNo");
//System.err.println("OncologyRegimenValidate.jsp===2211==drug_code===>"+drug_code+"=srlNo==>"+srlNo);
		int iTotRec = 0;
		String infVolume	= "";
		String infRate		= "";
		String infRateHrMin	= "";
		String infOverHr	= "";
		String infOverMin	= "";
		String startDateTime	= "";
		String endDateTime	= "";
		String infGapHr		= "";
		String infGapMin	= "";
		String infusion_over_insert_value	= "";
		String totInfVolume	= "";
		String totFlowDurn	= "";
		String totFlowDurnHrs= "";
		String totDuration	= "";
		String totDurnHrs	= "";
		String flowStartDate	= "";
		String flowEndDate	= "";
		String infGapInHr	= "";
		HashMap MFR_Recs	= new HashMap();
		ArrayList MFR_Detail	= new ArrayList();
		ArrayList MFRRecord = new ArrayList();
		HashMap MFRRecDetail = null;
		//drug_code="PIN0753";
		//srlNo = "1";

		if(!totRec.equals(""))
			iTotRec = Integer.parseInt(totRec);
		if(iTotRec > 1)
			bean.setMFRYN("Y");
		if(iTotRec >= 1){
			totInfVolume	= (String)hash.get("TotInfVolume");
			totFlowDurn		= (String)hash.get("TotFlowDurn");
			totDuration		= (String)hash.get("TotDuration");
			totFlowDurnHrs	= (String)hash.get("TotFlowDurnHrs");
			totDurnHrs		= (String)hash.get("TotDurnHrs");
			for(int i = 1; i<=iTotRec; i++){
				MFR_Detail = new ArrayList();
				MFRRecDetail = new HashMap();
				infVolume		= (String)hash.get("InfVolume"+i);
				infRate			= (String)hash.get("InfRate"+i);
				infRateHrMin	= (String)hash.get("InfRateHrMin"+i);
				infOverHr		= (String)hash.get("InfOverHr"+i);
				infOverMin		= (String)hash.get("InfOverMin"+i);
				startDateTime	= (String)hash.get("StartDateTime"+i);
				endDateTime		= (String)hash.get("EndDateTime"+i);
				infGapHr		= (String)hash.get("InfGapHr"+i);
				infGapMin		= (String)hash.get("InfGapMin"+i);
				infusion_over_insert_value		= (String)hash.get("infusion_over_insert_value"+i);
				infGapInHr		= (String)hash.get("InfGapInHr"+i);
				
				MFRRecDetail.put("TOT_STRENGTH",infVolume);
				MFRRecDetail.put("INFUSION_RATE",infRate);
				MFRRecDetail.put("INFUSION_PER_UNIT",infRateHrMin);
				MFRRecDetail.put("INFUSE_OVER",infusion_over_insert_value);
				MFRRecDetail.put("START_DATE_TIME",startDateTime);
				MFRRecDetail.put("END_DATE_TIME",endDateTime);
				MFRRecDetail.put("GAP_DURATION_IN_HRS",infGapInHr);
				MFRRecord.add(MFRRecDetail);

				MFR_Detail.add(infVolume);//1
				MFR_Detail.add(infRate);//2
				MFR_Detail.add(infRateHrMin);//3
				MFR_Detail.add(infOverHr);//4
				MFR_Detail.add(infOverMin);//5
				MFR_Detail.add(infusion_over_insert_value);//6
				MFR_Detail.add(startDateTime);//7
				MFR_Detail.add(endDateTime);//8
				MFR_Detail.add(infGapHr);//9
				MFR_Detail.add(infGapMin);//10
				MFR_Detail.add(infGapInHr);//11

				MFR_Recs.put("MFR"+i,MFR_Detail);
			}
			MFR_Recs.put("totInfVolume",totInfVolume);
			MFR_Recs.put("totFlowDurn",totFlowDurn);
			MFR_Recs.put("totDuration",totDuration);
			MFR_Recs.put("totFlowDurnHrs",totFlowDurnHrs);
			MFR_Recs.put("totDurnHrs",totDurnHrs);
			MFR_Recs.put("flowStartDate",request.getParameter("flowStartDate"));
			MFR_Recs.put("flowEndDate",request.getParameter("flowEndDate"));
			MFR_Recs.put("totRec",totRec);

			bean.setMFRRecs(MFR_Recs);

			ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();

		HashMap ext_drugData			=	null;
		String ext_drug_code			=	"";
		String mfr_yn                   =   "N";
		String	ocurrance_num			=	""; 

			for(int j=0;j<prescriptionDetails.size();j++){
				 ext_drugData	=(HashMap) prescriptionDetails.get(j);
				 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				 ocurrance_num  = (String) ext_drugData.get("OCURRANCE_NUM");  
				 
				 if( drug_code.equals(ext_drug_code) && srlNo.equals(ocurrance_num) ){
					 
						ext_drugData.put("MFR_Rec_details",MFR_Recs);
						ext_drugData.put("amend_end_date",request.getParameter("flowEndDate"));
						ext_drugData.put("MFRRecord",MFRRecord);
						break;
					}
			}

		}
		putObjectInBean(bean_id,bean,request);
	}else if(validate.equals("SAVE_MFR_FLUIDS")){
		Hashtable hash   = (Hashtable)XMLobj.parseXMLString(request);
		hash = (Hashtable)hash.get("SEARCH") ;
		String totRec		= (String)hash.get("noOfRows")==null?"0":(String)hash.get("noOfRows");
		int iTotRec = 0;
		String infVolume	= "";
		String infRate		= "";
		String infRateHrMin	= "";
		String infOverHr	= "";
		String infOverMin	= "";
		String startDateTime	= "";
		String endDateTime	= "";
		String infGapHr		= "";
		String infGapMin	= "";
		String infusion_over_insert_value	= "";
		String totInfVolume	= "";
		String totFlowDurn	= "";
		String totFlowDurnHrs= "";
		String totDuration	= "";
		String totDurnHrs	= "";
		String flowStartDate	= "";
		String flowEndDate	= "";
		String infGapInHr	= "";
		String fluidCode	= (String)hash.get("fluidCode");
		HashMap MFR_Recs	= new HashMap();
		ArrayList MFR_Detail	= new ArrayList();
		
		if(!totRec.equals(""))
			iTotRec = Integer.parseInt(totRec);
		if(iTotRec > 1)
			bean.setMFRYN("Y");
		if(iTotRec >= 1){
			totInfVolume	= (String)hash.get("TotInfVolume");
			totFlowDurn		= (String)hash.get("TotFlowDurn");
			totDuration		= (String)hash.get("TotDuration");
			totFlowDurnHrs	= (String)hash.get("TotFlowDurnHrs");
			totDurnHrs		= (String)hash.get("TotDurnHrs");
			for(int i = 1; i<=iTotRec; i++){
				MFR_Detail = new ArrayList();
				infVolume		= (String)hash.get("InfVolume"+i);
				infRate			= (String)hash.get("InfRate"+i);
				infRateHrMin	= (String)hash.get("InfRateHrMin"+i);
				infOverHr		= (String)hash.get("InfOverHr"+i);
				infOverMin		= (String)hash.get("InfOverMin"+i);
				startDateTime	= (String)hash.get("StartDateTime"+i);
				endDateTime		= (String)hash.get("EndDateTime"+i);
				infGapHr		= (String)hash.get("InfGapHr"+i);
				infGapMin		= (String)hash.get("InfGapMin"+i);
				infusion_over_insert_value		= (String)hash.get("infusion_over_insert_value"+i);
				infGapInHr		= (String)hash.get("InfGapInHr"+i);

				MFR_Detail.add(infVolume);//1
				MFR_Detail.add(infRate);//2
				MFR_Detail.add(infRateHrMin);//3
				MFR_Detail.add(infOverHr);//4
				MFR_Detail.add(infOverMin);//5
				MFR_Detail.add(infusion_over_insert_value);//6
				MFR_Detail.add(startDateTime);//7
				MFR_Detail.add(endDateTime);//8
				MFR_Detail.add(infGapHr);//9
				MFR_Detail.add(infGapMin);//10
				MFR_Detail.add(infGapInHr);//11
				MFR_Detail.add("");//11 admin detail
				
				MFR_Recs.put("MFR"+i,MFR_Detail);
			}
			MFR_Recs.put("totInfVolume",totInfVolume);
			MFR_Recs.put("totFlowDurn",totFlowDurn);
			MFR_Recs.put("totDuration",totDuration);
			MFR_Recs.put("totFlowDurnHrs",totFlowDurnHrs);
			MFR_Recs.put("totDurnHrs",totDurnHrs);
			MFR_Recs.put("flowStartDate",request.getParameter("flowStartDate"));
			MFR_Recs.put("flowEndDate",request.getParameter("flowEndDate"));
			MFR_Recs.put("totRec",totRec);

			//bean.setMFRRecs_fluids(MFR_Recs,fluidCode);
		}
	}else if(validate.equals("MFR_RECS_CLEAR")){ 
	   String Mfr_yn = request.getParameter("MFR_YN");
	   String drug_code = bean.getdrugCode();
	   //ML-MMOH-CRF-1014
	   	ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();

		HashMap ext_drugData			=	null;
		String ext_drug_code			=	"";
		String ext_srl_no				=	"";
		String srlno                    =   request.getParameter("srl_no");

		for(int j=0;j<prescriptionDetails.size();j++){
				 ext_drugData	=(HashMap) prescriptionDetails.get(j);
				 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				 ext_srl_no		=(String) ext_drugData.get("SRL_NO");	
				 if(drug_code.equals(ext_drug_code) && srlno.equals(ext_srl_no)){			
					ext_drugData.put("mfr_yn","N");
					break;
				 }
		}

		if(Mfr_yn.equals("N")){
			 bean.setMFRRecs(new HashMap());
			 bean.setmfr_remark(drug_code,"");
		}
		  
    }	else if(validate.equals("DEFAULT_MFR_AT_LOADING")){ 
        String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id"); 
		String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String srlNo     = request.getParameter("srlNo")==null?"":request.getParameter("srlNo");
		//System.err.println("OncologyRegimenValidate.jsp======order_id===ds======2862===>"+order_id);
		ArrayList MFRRecord = (ArrayList)bean.getMFRRecsView(order_id);
		//System.err.println("OncologyRegimenValidate.jsp======MFRRecord===ds======2880==>"+MFRRecord);
		String mfr_remarks = (String)bean.getMfrRemarks(order_id);
		//System.err.println("OncologyRegimenValidate.jsp======MFRRecord=====ds====2866===>"+MFRRecord+"==mfr_remarks==>"+mfr_remarks);
		ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();
		HashMap ext_drugData			=	null;
		String ext_drug_code			=	"";
		String mfr_yn                   =   "N";
		String ocurrance_num			=   "";//added for CRF-673.2
			for(int j=0;j<prescriptionDetails.size();j++){
				 ext_drugData	=(HashMap) prescriptionDetails.get(j);
				 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				 ocurrance_num  = (String) ext_drugData.get("OCURRANCE_NUM");//added for CRF-673.2 on 8/19/2014
				 
					 if(drug_code.equals(ext_drug_code) && srlNo.equals(ocurrance_num) ){
//System.err.println("OncologyRegimenValidate.jsp===MFRRecord==2979==>"+MFRRecord);
						ext_drugData.put("MFRRecord",MFRRecord);
						ext_drugData.put("MFR_REMARKS",mfr_remarks);
						
				 }
				 break;
			}
		

			   
	}else if(validate.equals("SAVE_MFR_REMARKS")){ 
			String mfr_remark = request.getParameter("mfr_remark");
			String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
			String srlNo	 = request.getParameter("srlNo")==null?"":request.getParameter("srlNo");//CRF-673.2 on 8/19/2014
			String parent_drug_code = bean.getdrugCode();
			bean.setmfr_remark(parent_drug_code,mfr_remark);
			ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();
			HashMap ext_drugData			=	null;
			String ext_drug_code			=	"";
			String mfr_yn                    =   "N";
			String ocurrance_num			= "";  
			for(int j=0;j<prescriptionDetails.size();j++){
				 ext_drugData	=(HashMap) prescriptionDetails.get(j);
				 ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				 ocurrance_num  = (String) ext_drugData.get("OCURRANCE_NUM"); 
 
				 if( drug_code.equals(ext_drug_code) && srlNo.equals(ocurrance_num)){ 

					ext_drugData.put("MFR_REMARKS",mfr_remark);
					break;
				 }
			}
                    
	}//ML-MMOH-CRF-1014 - end
	//Added for IN:070451 start
	else if(validate.equals("setWtBsa")){ 
		String bsa=(String) request.getParameter("bsa");
		String weight=(String) request.getParameter("weight");
		bean.setWeight(weight);
		bean.setBsa(bsa);
                
}
	else if(validate.equals("LMITIND")){ 
		String temp_qty = (String)request.getParameter("temp_qty");
		String repeat_value = (String)request.getParameter("repeat_value");
		String dosage_type = (String)request.getParameter("dosage_type");
		String drug_code = (String)request.getParameter("drug_code");
		
		HashMap dosageDetails= (HashMap) bean.chkMaxDosageLimit(drug_code,patient_id,temp_qty,dosage_type,repeat_value);
		String limit_ind = (String)dosageDetails.get("LIMIT_IND");
		if(limit_ind.equals("N")){
			out.println("parent.oncology_admin.oncologyRegimenAdminDetail.dosage_label.style.visibility='visible';");
			out.println("parent.oncology_admin.oncologyRegimenAdminDetail.value='Y';");
			out.println("parent.oncology_admin.oncologyRegimenAdminDetail.mand2.style.visibility='visible';");
		}
		out.println("parent.f_oncology_sub_drugs.document.onCologyRegimenDrugDetails.limit_ind.value = '"+limit_ind+"';");

                
}
//Added for IN:070451 end
//Added for IN:072715 start
else if(validate.equals("override_remarks")) {
	Hashtable hash			=  (Hashtable)XMLobj.parseXMLString(request);		
	hash					=  (Hashtable)hash.get("SEARCH") ;
					String reason_code		= (String)hash.get("reason_code"); 
					String trn_type		= (String)hash.get("trn_type");
					String field		= (String)hash.get("field");
				
					String remarks = bean.getOverrideRemarks(trn_type, reason_code);
					out.println("document.DispQueueMgmtHoldReason."+field+".value = '"+remarks+"';");
					out.println("document.DispQueueMgmtHoldReason."+field+".readOnly = true;");
					
					
				}
				//Added for IN:072715 END
	putObjectInBean(bean_id,bean,request);
}catch(Exception e){
		e.printStackTrace();
}
finally{//added for NMC-JD-CRF-0063
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
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
