package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import eOR.Common.*;
import ePH.*;
import eOR.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ivpbvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPBValidate.jsp", 1732509479148L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
24/10/2019		INO71514			Shazana												SKR-SCF-1276
30/06/2020      IN:072715          Haribabu     30/06/2020     Manickavasagam J        MMS-DM-CRF-0165
27/08/2020      IN073660           Haribabu                                            SKR-SCF-1411
12/10/2020	IN073670	  	   Shazana											   MMS-KH-SCF-0096
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
11/12/2020		6041				Shazana       										NMC-JD-CRF-0063
11/1/2021 		9578				Shazana						Manickavasagam			SKR-SCF-1498
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);

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
	String locale			= (String)session.getAttribute("LOCALE");

	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	String iv_bean_id	= "@IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name	= "ePH.IVPrescriptionBean";
	
	IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
	iv_bean.setLanguageId(locale);
	
	String disp_locn_code=iv_bean.getDisp_locn_code();//Addeed for ml-mmoh-crf-0863 
	String auth_amend_pres_yn="";//added for ml-mmoh-crf-0863
	auth_amend_pres_yn = iv_bean.getAuthAmendPres(disp_locn_code);//added for ml-mmoh-crf-0863
	System.out.println("auth_amend_pres_yn"+auth_amend_pres_yn+"disp_locn_code"+disp_locn_code);	
	System.out.println("validate: "+validate);//added for NMC-JD-CRF0063
	//if (!lang_id.equals(""))

	if (bean_id == null || bean_id.equals("")){

		return ;
	}

	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	if(validate!=null && !validate.equals("RELEASE")&&!validate.equals("AMENDRELEASE")&&!validate.equals("InsertExternalOverrideReason") && !validate.equals("GET_TRNGROUPREF")&&!validate.equals("SAVE_FLUIDDETAILS")){
		

		IVPiggyBackBean bean = (IVPiggyBackBean)getBeanObject("@IVPiggyBackBean"+patient_id+encounter_id, "ePH.IVPiggyBackBean", request);
		if (validate.equals("VEHILEDETAILS")) {
			String drug_code		= request.getParameter("drug_code");
			String trade_code		= request.getParameter("trade_code");
			String pract_id		= request.getParameter("pract_id");
			String resp_id		= request.getParameter("resp_id");
			String pres_drug_code		= request.getParameter("pres_drug_code");//Added for ML-MMOH-CRF-1223
			String default_comp_fluid_falg = request.getParameter("default_comp_fluid_falg");//Added for ML-MMOH-CRF-1223
			if(trade_code == null)
				trade_code ="";

//			IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

			iv_bean.setFldTradeCode(trade_code);

			int fluid_adr_count = iv_bean.getADRCount(patient_id,drug_code);   
			out.println("displayADRimage(\""+ fluid_adr_count + "\");");
//commented during PE By Naveen
			//String orderType	= iv_bean.getOrderType(drug_code);
					   
			iv_bean.setFluidDetails(drug_code,"","","",""); // CRF-0062 NEWLY ADDED

			HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();
			String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");

			if (iv_bean.checkForStock()){
				ArrayList stockDetails = iv_bean.getStockDetails(drug_code, "1");
				if (stockDetails.size() != 0)
					out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949]

				else
					out.println("setStockDetails(2);") ;
			}
		
			out.println("setOrderType(\""+ orderType + "\");");
			String infuse	=	iv_bean.getInfuseOverValue(drug_code,pres_drug_code);//pres_drug_code Added for ML-MMOH-CRF-1223
			//out.println("setInfuseValue(\""+infuse+ "\",\""++ "\",\""+default_comp_fluid_falg+ "\");");//Commented  for ML-MMOH-CRF-1223
            out.println("setInfuseValue('"+infuse+"','','"+default_comp_fluid_falg+"');");//Added for ML-MMOH-CRF-1223
			out.println("setSchedule();");

			String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
			String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");
			String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
			String priority					= request.getParameter("priority")==null?"":request.getParameter("priority");
			String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
			String dflt_disp_locn	= "";	
			ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,drug_code,patient_id,encounter_id);//added drug_code,patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
			if(ord_disp_location != null & ord_disp_location.size()>0){
				dflt_disp_locn	= (String)ord_disp_location.get(2);
			}
			out.println("displayDispLocn('"+dflt_disp_locn+"');");
		}
		else if(validate.equals("DRUGCODE")){

			String drugCodes        = request.getParameter("drugCodes")==null?"":request.getParameter("drugCodes");

			String trade_code		= request.getParameter("trade_code")==null?"":request.getParameter("trade_code");
			String trade_name		= request.getParameter("trade_name")==null?"":request.getParameter("trade_name");
			String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
			String buildMAR_yn = request.getParameter("buildMAR_yn")==null?"":request.getParameter("buildMAR_yn");
//			IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
			iv_bean.setDrgTradeCodesArray(trade_code);

			String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
			String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");
			String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
			String priority					= request.getParameter("priority")==null?"":request.getParameter("priority");
			String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
			String weight					= request.getParameter("weight")==null?"":request.getParameter("weight");//Added for IN:070451
			String bsa				= request.getParameter("bsa")==null?"":request.getParameter("bsa");//Added for IN:070451
			String dflt_disp_locn	= "";	
		
			System.out.println("IVPBValidate.jsp - getOpDischMedInd "+iv_bean.getOpDischMedInd() +" getTakeHomeMedicationOp: "+iv_bean.getTakeHomeMedicationOp());	//ADDED FOR NMC-JD-CRF-0063 START
			System.out.println("getPatientClass "+iv_bean.getPatientClass());	
			PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;
			System.out.println("getPatient_class_tkHome: "+beanPres.getPatient_class_tkHome());  
			con				= ConnectionManager.getConnection(request);
			boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");
			String patient_class = iv_bean.getPatientClass();
			if(patient_class!=null){
				if(patient_class.equals("EM")|| patient_class.equals("OP")){
					if(op_take_home_med_flag){
						iv_bean.setTakeHomeMedicationOp("Y");
					}else{
						iv_bean.setTakeHomeMedicationOp("N");
					} 
				}
			}
			if(beanPres.getPatient_class_tkHome().equals("IP")){
				iv_bean.setTakeHomeMedicationOp("N");  
			} 
			System.out.println("beanPres.getOpDischMedInd() : "+beanPres.getOpDischMedInd());  //added for NMC-JD-CRF-0063 start
			if(beanPres.getOpDischMedInd()==null){
				iv_bean.setOpDischMedInd("N");
			}
			else if(beanPres.getOpDischMedInd()!=null){
				iv_bean.setOpDischMedInd(beanPres.getOpDischMedInd());
			}// NMC-JD-CRF-0063 END
			System.out.println("getOpDischMedInd "+iv_bean.getOpDischMedInd() +"getTakeHomeMedicationOp: "+iv_bean.getTakeHomeMedicationOp());	//ADDED FOR NMC-JD-CRF-0063 END
			//END		
			ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
			if(ord_disp_location != null & ord_disp_location.size()>0){
				dflt_disp_locn	= (String)ord_disp_location.get(2);
			}
			out.println("displayDispLocn('"+dflt_disp_locn+"');");

			String drug_db_interface_yn       = request.getParameter("drug_db_interface_yn");
			String drug_db_duptherapy_yn      = request.getParameter("drug_db_duptherapy_yn");
			String drug_db_interact_check_yn  = request.getParameter("drug_db_interact_check_yn");
			String drug_db_contraind_check_yn = request.getParameter("drug_db_contraind_check_yn");
			String drug_db_dose_check_yn	  = request.getParameter("drug_db_dosecheck_yn");
			String resp_id	  = request.getParameter("resp_id");
			String pract_id	  = request.getParameter("pract_id");
			String act_pat_class = hash.get("act_pat_class")==null?"":hash.get("act_pat_class").toString(); // RUT-CRF-0062
			String drug_db_product_id		  = iv_bean.getDrug_DB_Product_id();
			iv_bean.setWeight(weight);//Added for IN:070451
			iv_bean.setBSA(bsa);//Added for IN:070451
			iv_bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
			iv_bean.setExternalDosageYN(drug_db_dose_check_yn);
			iv_bean.setDrugDetails(drugCodes, pract_id, resp_id,act_pat_class,priority,location_code,take_home_medication); // CRF-0062

			ArrayList drugList			= iv_bean.getDrugDetails();
			HashMap hm	= (HashMap)drugList.get(0);
			
			String generic_id			= (String)hm.get("GENERIC_ID");
			String generic_name			= (String)hm.get("GENERIC_NAME");
			String strength				= (String)hm.get("STRENGTH_VALUE");
			String strength_uom			= (String)hm.get("STRENGTH_UOM");
			String dosage				= (String)hm.get("QTY_VALUE");
			String dosage_uom			= (String)hm.get("QTY_UOM");
			String freq_code			= (String)hm.get("FREQ_CODE");
			String allergy_override		= (String)hm.get("ALLERGY_OVERRIDE");
			String dose_override		= (String)hm.get("DOSE_OVERRIDE");
			String currentrx_override	= (String)hm.get("CURRENTRX_OVERRIDE");
			String drug_desc	        = (String)hm.get("DRUG_DESC");
			String dosage_unit	        = (String)hm.get("DOSAGE_UNIT");
			String daily_dose			= (String)hm.get("DAILY_DOSE");
			String min_daily_dose		= (String)hm.get("MIN_DAILY_DOSE")==null?"":(String)hm.get("MIN_DAILY_DOSE");
			String min_unit_dose		= (String)hm.get("MIN_UNIT_DOSE")==null?"":(String)hm.get("MIN_UNIT_DOSE");
			String unit_dose			= (String)hm.get("UNIT_DOSE")==null?"":(String)hm.get("UNIT_DOSE");
			String dosage_std			= (String)hm.get("DOSAGE_STD")==null?"":(String)hm.get("DOSAGE_STD");
			String recomm_dosage_by		= (String)hm.get("RECOMM_DOSAGE_BY")==null?"":(String)hm.get("RECOMM_DOSAGE_BY");
			String calc_by_ind			= (String)hm.get("CALC_BY_IND")==null?"":(String)hm.get("CALC_BY_IND");
			String mono_graph			= (String)hm.get("MONO_GRAPH")==null?"":(String)hm.get("MONO_GRAPH");
			String limit_ind			= (String)hm.get("LIMIT_IND")==null?"":(String)hm.get("LIMIT_IND");
			String recomm_yn			= (String)hm.get("RECOMM_YN")==null?"":(String)hm.get("RECOMM_YN");
			String dosage_by 		    = (String)hm.get("DOSAGE_TYPE");
			String volume	            = (String)hm.get("CONTENT_IN_PRES_BASE_UOM");
			String pres_base_uom		= (String)hm.get("PRES_BASE_UOM");
			String ord_auth_reqd_yn     = (String)hm.get("ORD_AUTH_REQD_YN");
			String auth_yn_val          = (String)hm.get("ORD_AUTHORIZED_YN");
			String ord_spl_appr_reqd_yn = (String)hm.get("ORD_SPL_APPR_REQD_YN");
			String approval_yn_val      = (String)hm.get("ORD_APPROVED_YN");
			String ord_cosign_reqd_yn   = (String)hm.get("ORD_COSIGN_REQD_YN");
			String cosign_yn_val        = (String)hm.get("ORD_COSIGNED_YN");
			String consent_reqd_yn      = (String)hm.get("CONSENT_REQD_YN");
			String allergy_yn			= (String)hm.get("ALLERGY_YN");
			String current_rx			= (String)hm.get("CURRENT_RX");
			String drug_code			= (String)hm.get("DRUG_CODE");
			String srl_no				= (String)hm.get("SRL_NO");
			String allergy_remarks		= (String)hm.get("ALLERGY_REMARKS");
			String dose_remarks			= (String)hm.get("DOSE_REMARKS");
			String currentrx_remarks	= (String)hm.get("CURRENTRX_REMARKS");
			String sRegRopt				= (String)hm.get("REQD_OR_OPT_IND"); 
			String external_product_id	= (String)hm.get("EXTERNAL_PRODUCT_ID"); 
			String perform_ext_db_checks= (String)hm.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
			String iv_ingredient_yn		= (String)hm.get("IV_INGREDIENT_YN");
			String iv_fluid_yn			= (String)hm.get("IV_FLUID_YN");	
			String startdate			= (String)hm.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
			String enddate				= (String)hm.get("END_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
		   int drug_adr_count = iv_bean.getADRCount(patient_id,drug_code);  
			//IN073670 START
		   mono_graph=mono_graph.replaceAll(" ","%20");
		   mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
			mono_graph=mono_graph.replaceAll("%2520","%20");
			//IN073670 END
			StringTokenizer st			=	new StringTokenizer(drugCodes,",");
			String  drug_code1			=	st.nextToken();
			String	back_date			= (String) hm.get("BACK_DATE");
			String  future_date			= (String) hm.get("FUTURE_DATE");
			out.println("setBackFutureDate('"+ back_date +"','"+ future_date +"','"+ (String)hm.get("DURN_VALUE") +"', \"DRUGLOAD\");");//Added DURN_VALUE,DRUGLOAD for ML-MMOH-CRF-1223(for SCF-7176)
			//added for SKR-SCF-1498 START
			boolean default_flag = false;
			String default_freq_code="";//END
//commented during PE  BY Naveen
			/*HashMap drugDtl			=	iv_bean.getAddDrugInfo(drug_code1);	
			String iv_ingredient_yn	=	(String)drugDtl.get("IV_INGREDIENT_YN");
			String iv_fluid_yn		=	(String)drugDtl.get("IV_FLUID_YN");	
			*/
			//String tdmOrderId		=	iv_bean.getOrderIdForTDMDtls(patient_id,drug_code);
			String tdmOrderId = "";
			if(hm.get("TDM_ORDER_ID")== null){
			   tdmOrderId = iv_bean.getOrderIdForTDMDtls(patient_id,drug_code);
				hm.put("TDM_ORDER_ID",tdmOrderId);
			}
			else 
				tdmOrderId = (String)hm.get("TDM_ORDER_ID");

			if(tdmOrderId !=null && !tdmOrderId.equals("")){
				out.println("assignTdmOrderid('"+tdmOrderId+"')");
			}
			if( iv_ingredient_yn.equals("Y")){
				out.println("clearData();") ;

				//ArrayList freqValues = bean.getDrugSheduleFrequency((String)hm.get("DRUG_CODE"));

				ArrayList freqValues = bean.getSheduleFrequency(drug_code);
				//SKR-SCF-1498 START
					default_freq_code = freq_code;
				    for (int i=0;i<freqValues.size();i+=2){   
				        if(freqValues.contains(freq_code.trim())){
				            default_flag =true;
				            break;
				        }
				    }				 
				    if(!default_flag)
				    default_freq_code=(String)freqValues.get(0);
				    freq_code = default_freq_code;//SKR-SCF-1498 END
				
				if(freqValues!=null && freqValues.size()>0){
					out.println("clearFrequencyList();") ;
					for (int i=0;i<freqValues.size();i+=2){
//						out.println("addOption('"+((String)freqValues.get(i))+"','"+((String)freqValues.get(i+1))+"');");
						out.println("addFrequencyList(\""+((String)freqValues.get(i))+"\",\""+((String)freqValues.get(i+1))+"\",\""+freq_code.trim()+"\")");
					}
					out.println("dfltFreq('"+freq_code.trim()+"')");
				}
				if(iv_fluid_yn.equals("Y") ){
					strength	 = volume;
					strength_uom = pres_base_uom;
				}
				if(!dosage_by.equals("S")){
					strength = dosage;
					strength_uom = pres_base_uom;
				}
			}			
			/*if(iv_ingredient_yn.equals("Y")){
				ArrayList shedule_freq	=  bean.getSheduleFrequency(drug_code);
				if(shedule_freq!=null && shedule_freq.size()>0){
					out.println("clearFrequencyList();") ;
					for(int i=0;i<shedule_freq.size();i+=2){
						out.println("addFrequencyList('"+ (String)shedule_freq.get(i) + "','" + (String)shedule_freq.get(i+1)+ "');") ;
					}
					out.println("setdefFrequency();") ;
				}
			}*/
	//added 29/4/2005
			int fluid_adr_count = 0;
			if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("Y")){
//commented during PE BY Naveen  code added below
				//String orderType	= iv_bean.getOrderType(drug_code1);
				fluid_adr_count     = iv_bean.getADRCount(patient_id,drug_code1);
				// volume was passed earlier, now passing dosage - sept-14-2010
				out.println("assignDfltVehicle('"+ drug_code1 + "', '" + java.net.URLEncoder.encode(drug_desc,"UTF-8") + "', '" + dosage +"','Y','" +trade_code+ "','"+java.net.URLEncoder.encode(trade_name,"UTF-8")+"','"+fluid_adr_count+"');") ;// added "java.net.URLEncoder.encode(<>,"UTF-8")" for SRR20056-SCF-7374 Incident No. 27415
				iv_bean.setFluidDetails(drug_code1,act_pat_class,priority,location_code,take_home_medication); // CRF-0062 NEWLY ADDED

                HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();
			    String orderType = (String)fluid_det.get("ORDER_TYPE_CODE");
				iv_bean.setFluidFlag("N");
				  
				if (iv_bean.checkForStock()) {
					ArrayList stockDetails = iv_bean.getStockDetails(drug_code1, "1");

					if (stockDetails.size() != 0){
						// stock_value=(String)stockDetails.get(0);
						out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					}
					else{
						 out.println("setStockDetails(2);") ;
					}
				} 

				out.println("setOrderType(\""+ orderType + "\");");
				String infuse	=	iv_bean.getInfuseOverValue(drug_code1,"");//Added Empty for ML-MMOH-CRF-1223
				out.println("setInfuseValue(\""+infuse+ "\", \"DRUGLOAD\");") ; //call_mode="DRUGLOAD" added for SRR20056-SCF-7374 Incident No. 27415
				
				out.println("setSchedule();");
				//out.println("setUOM(\""+strength_uom+ "\", \"" + strength + "\");") ; //Commented for SRR20056-SCF-7374 Incident No. 27415
				out.println("disableall();");    
			}
			else if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("N")){

				String or_bean_name				= "eOR.OrderEntryBean";
				String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
				OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
				String resp_id1					= (String) orbean.getResponsibilityId();
				String pract_id1				= (String) orbean.getPractitionerId();


				ArrayList dfltFluidDetails = iv_bean.getCompFluidDetails(drug_code1,pract_id1,resp_id1);

				String orderType	= iv_bean.getOrderType(drug_code);
				String fluid_code ="";

				if(dfltFluidDetails!=null && dfltFluidDetails.size() > 0) {
					out.println("clearDfltVehicle();");
					for(int j=0; j<dfltFluidDetails.size();j+=7 ){
						if(j==0)
							fluid_code = (String)dfltFluidDetails.get(j);
						fluid_adr_count = iv_bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
						out.println("assignDfltVehicle(\""+ dfltFluidDetails.get(j) + "\", \"" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "\", \"" + dfltFluidDetails.get(j+2)+ "\", \"" + dfltFluidDetails.get(j+3)+ "\", \"" + dfltFluidDetails.get(j+4)+ "\", \"" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "\",\"" + fluid_adr_count + "\");") ;
						if(((String)dfltFluidDetails.get(j+3)).equals("Y"))
							fluid_code = (String)dfltFluidDetails.get(j);
					}
					if(!order_set_code.equals("")){
						ArrayList orderSetCodes = (ArrayList) iv_bean.getOrdersetCodes(order_set_code);
						fluid_code = (String) orderSetCodes.get(0);
					}

					iv_bean.setFluidDetails(fluid_code,act_pat_class,priority,location_code,take_home_medication); // CRF-0062 NEWLY ADDED
					if (iv_bean.checkForStock()) {
						ArrayList stockDetails = iv_bean.getStockDetails(fluid_code, "1");

						if (stockDetails.size() != 0)
								out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
						else
						out.println("setStockDetails(2);") ;
					}
					out.println("setOrderType(\""+ orderType + "\");");
					//String infuse	=	iv_bean.getInfuseOverValue(fluid_code);
					String infuse	=	iv_bean.getInfuseOverValue(fluid_code,drug_code);//drug_code added for ML-MMOH-CRF-1223
					out.println("setInfuseValue(\""+infuse+ "\", \"DRUGLOAD\");");//Added DRUGLOAD for ML-MMOH-CRF-1223
				}
			}		out.println("assignDosageDetails('"+(String)hm.get("DRUG_CODE")+"','"+java.net.URLEncoder.encode(drug_desc,"UTF-8")+"','"+strength+"','"+strength_uom+"','"+dosage+"','"+dosage_uom+"','"+freq_code+"','"+allergy_override+"','"+dose_override+"','"+currentrx_override+"','"+sRegRopt+"','"+drug_adr_count+"','"+pract_id+"','"+resp_id+"','"+buildMAR_yn+"','"+iv_fluid_yn+"','"+(String)hm.get("DURN_VALUE")+"')"); //iv_fluid_yn parameter added for "SRR20056-SCF-7374 IN27415"

			out.println("assignAuthorization('"+ord_auth_reqd_yn+"','"+auth_yn_val+"','"+ord_spl_appr_reqd_yn+"','"+approval_yn_val+"','"+ord_cosign_reqd_yn+"','"+cosign_yn_val+"','"+consent_reqd_yn+"')");
			out.println("dtlsForOverride('"+generic_id+"','"+generic_name+"','"+java.net.URLEncoder.encode(drug_desc,"UTF-8")+"','"+limit_ind+"','"+allergy_yn+"','"+current_rx+"','"+drug_code+"','"+srl_no+"','"+allergy_remarks+"','"+dose_remarks+"','"+currentrx_remarks+"')");			
			
			if(perform_ext_db_checks.equals("N")){ 
				drug_db_product_id  = "";
				if(!(allergy_yn.equals("N") && limit_ind.equals("Y") && current_rx.equals("N"))){
					out.println("overrideImg('"+allergy_yn+"','"+allergy_override+"','"+limit_ind+"','"+dose_override+"','"+current_rx+"','"+currentrx_override+"')"); 
					//out.println("showOverRideRemarks()");
					//out.println("showOverRideRemarks('"+patient_id+"','"+encounter_id+"','"+generic_id+"','"+generic_name+"','"+drug_desc+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+limit_ind+"','"+allergy_yn+"','"+current_rx+"','"+drug_code+"','"+srl_no+"','"+allergy_remarks+"','"+dose_remarks+"','"+currentrx_remarks+"','"+min_unit_dose+"','"+min_daily_dose+"')");
				}
			}
			else{
				ArrayList exProd				= new ArrayList();
				ArrayList drugDesc				= new ArrayList();
				String dup_drug_det			    = "";
				HashMap drug_Interactions		= null;

				String drug_db_contraind_check_flag	="N";
				String drug_db_interact_check_flag	="N";
				String drug_db_duptherapy_flag		="N";
				String drug_db_dose_check_flag      ="Y"; 
				String ext_prod_id                   ="";
				
				ArrayList temp =(ArrayList)iv_bean.getDrugDetails();

				String ex_bean_id   = "@ExternalProductLinkBean";
				String ex_bean_name = "ePH.ExternalProductLinkBean";
				ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
				HashMap drug_data=new HashMap();
				for(int i=0;i<temp.size();i++){
					drug_data	=	(HashMap)temp.get(i);					
					drugDesc.add((String)drug_data.get("DRUG_DESC"));
					ext_prod_id= (String)drug_data.get("EXTERNAL_PRODUCT_ID");
					if(!ext_prod_id.equals(""))
						  exProd.add(ext_prod_id);
				 }
			  /* // Commented for FDB Tuning - start
				if(exProd.size() > 0){
					beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
				}

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
				*/  // Commented for FDB Tuning - end
				if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")){
					String storeIDs = "N";
					if(exProd.size()>0)
						storeIDs = "Y";
						
					HashMap tempDetails= null;
					ArrayList reqChecks = new ArrayList();
					reqChecks.add("N"); //Dosage Check 
					reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
					reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
					reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
					reqChecks.add("N"); //AllergyCheck  - is done in IVPiggyBackDrugDetails.jsp
					HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drugDesc, null, storeIDs, startdate, enddate); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
					if(drugDBCheckResult!=null)
						beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);

					if(drug_db_interact_check_yn.equals("Y")){
						tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
						if(tempDetails!=null && tempDetails.size()>0){
							 drug_db_interact_check_flag="Y";
						}
						else									
							 drug_db_interact_check_flag="N";
					}

					if(drug_db_duptherapy_yn.equals("Y")){ 
					   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
					   if(dup_drug_det!=null && !dup_drug_det.equals(""))
							drug_db_duptherapy_flag="Y";
					   else{
							drug_db_duptherapy_flag="N";
					   }
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
				hm.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				hm.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				hm.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				hm.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				if(drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")){
					out.println("DisplayFDBOverrideImage('"+external_product_id+"')");
					out.println("viewMedicationAlert('"+patient_id+"','"+external_product_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dose_check_flag+"','ONLOAD','','"+drug_code+"','"+srl_no+"','','','','','','"+drug_db_dose_check_yn+"')");
					
				}
			}        
			if(recomm_yn !=null && recomm_yn.equals("Y")){
				out.println("assignMonoGraphdetails('"+java.net.URLEncoder.encode(drug_desc,"UTF-8")+"','"+mono_graph+"','"+daily_dose+"','"+unit_dose+"','"+min_daily_dose+"','"+min_unit_dose+"','"+dosage_unit+"','"+recomm_yn+"','"+dosage_std+"','"+recomm_dosage_by+"','"+calc_by_ind+"','"+limit_ind+"','"+dosage_by+"')");
			} 
			hm.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
		} 
		else if (validate.equals("QUANTITY")) {
//			IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
			String drug_code = request.getParameter( "drug_code" ) ;
			String rx_qty_by_pres_base_uom_yn = request.getParameter( "rx_qty_by_pres_base_uom_yn" )==null?"N": request.getParameter( "rx_qty_by_pres_base_uom_yn" ) ;
			String pres_base_uom = request.getParameter( "pres_base_uom" )==null?"":request.getParameter( "pres_base_uom" ) ;
			out.println("clearData('document.formIVPiggyBackDrugDetails.STRENGTH_UOM', '1');") ;
			if(iv_bean.getLanguageId() == null || iv_bean.getLanguageId().equals(""))
					iv_bean.setLanguageId(locale);
			Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_code);
			Enumeration keys_des		= QtyDescDetails.keys();
			String uom_code				= "";
			String uom_desc				= "";
			String def_uom_code			= "";
			while(keys_des.hasMoreElements()) {
				uom_code = (String)keys_des.nextElement();
				uom_desc = (String)QtyDescDetails.get(uom_code);

				if(!uom_code.equals("dflt_code"))
					out.println("addData('"+ uom_code + "','" + uom_desc +"', 'document.formIVPiggyBackDrugDetails.STRENGTH_UOM');") ;
				else
					def_uom_code = (String)QtyDescDetails.get("dflt_code");
			}
			//if condition added for IN23357 -- 31/08/2010-- priya
			if(rx_qty_by_pres_base_uom_yn.equals("Y"))
				def_uom_code= pres_base_uom;
			out.println("setDefaultData('"+ def_uom_code +"', 'document.formIVPiggyBackDrugDetails', '1');") ;
		}
		else if(validate.equals("OVERRIDE_REASON")) {
			String drugCode		= request.getParameter("drug_code");
			String srlNo		= request.getParameter("srl_no");
			String allergy_yn	= request.getParameter("allergy_yn");
			String limit_ind	= request.getParameter("limit_ind");
			String current_rx	= request.getParameter("current_rx");
			String allergy		=	"";
			String exceed_dose	=	"";
			String dup_drug		=	"";
			// Modified for IN:072715 start
			String allergy_remarks_code		=	"";
			String dose_remarks_code	=	"";
			String currentrx_remarks_code		=	"";
			//added for aakh-crf-0140 start
			String abuse_override	= request.getParameter("abuse_override");
			String abuse_override_remarks	= request.getParameter("abuse_override_remarks");
			//added for aakh-crf-0140 end
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
			if(allergy_yn.equals("Y")){
				allergy				= request.getParameter("allergy");
				allergy_remarks_code				= request.getParameter("allergy_remarks_code");
			}
			if(limit_ind.equals("N")){
				exceed_dose			= request.getParameter("exceed_dose");
				dose_remarks_code			= request.getParameter("dose_remarks_code");
			}
			if(current_rx.equals("Y")){
				dup_drug			= request.getParameter("dup_drug");
				currentrx_remarks_code			= request.getParameter("currentrx_remarks_code");
			}
			if(abuse_override.equals("Y")){//added for aakh-crf-0140 
				
				 abuse_override	= request.getParameter("abuse_override");
				 abuse_override_remarks	= request.getParameter("abuse_override_remarks");

			}
			// Modified for IN:072715 end
			ArrayList prescriptionDetails	=	(ArrayList)iv_bean.getDrugDetails();
			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			for(int j=0;j<prescriptionDetails.size();j++){
				
				ext_drugData	=(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
				// Modified for IN:072715 start
				//ext_srl_no		=(String) ext_drugData.get("SRL_NO");// Modified for IN:072715 commentted for to fix existing bug

				if( drugCode.equals(ext_drug_code) ){
					if(!allergy.equals("") ) {
						ext_drugData.put("ALLERGY_REMARKS",allergy);
						ext_drugData.put("ALLERGY_OVERRIDE","Y");
						ext_drugData.put("ALLERGY_REMARKS_CODE",allergy_remarks_code);
					}
					if(!exceed_dose.equals("")) {
						ext_drugData.put("DOSE_REMARKS",exceed_dose);
						ext_drugData.put("DOSE_OVERRIDE","Y");
						ext_drugData.put("DOSE_REMARKS_CODE",dose_remarks_code);
					}

					if(!dup_drug.equals("")) {
						ext_drugData.put("CURRENTRX_REMARKS",dup_drug);	  
						ext_drugData.put("CURRENTRX_OVERRIDE","Y");	
						ext_drugData.put("CURRENTRX_REMARKS_CODE",currentrx_remarks_code);
					}
					if(!abuse_override.equals("")) {//added for aakh-crf-0140 
							ext_drugData.put("ABUSE_OVERRIDE","Y");	
						ext_drugData.put("abuse_override_remarks",abuse_override_remarks);
					}
					// Modified for IN:072715 end
					break;
				}
			}
			// objects nullified after usage
			prescriptionDetails	=	null;
			ext_drugData		=	null;
		
		}
		else if(validate.equals("FLUIDCODE")){
		
			String fluid_Code = request.getParameter("fluidCodes");
			String pract_id		= request.getParameter("pract_id");
			String resp_id		= request.getParameter("resp_id");
			String drug_code	= request.getParameter("drug_code");//Added for ML-MMOH-CRF-1223
			if (patient_id == null) 
				patient_id = ""; 
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
//commented during PE By Naveen
			//String orderType	= iv_bean.getOrderType(fluid_Code);
			
			iv_bean.setFluidDetails(fluid_Code,"","","",""); // CRF-0062 NEWLY ADDED
			HashMap hm	= iv_bean.getFluidDetails();
			String orderType = (String)hm.get("ORDER_TYPE_CODE");


			ArrayList orderSetValues = iv_bean.getOrderSetValues();
			String fluid_cmptble_yn	 = iv_bean.getFluidCompatibility();
			String freqCode			= "";
			String sRegRopt			= "";

			String fluidCode     = (String)hm.get("DRUG_CODE");
			String dosage		= (String)hm.get("QTY_VALUE");
			String dosage_uom   = (String)hm.get("QTY_UOM");
		
			if(orderSetValues.size() > 0){
				for(int i = 0; i < orderSetValues.size(); i=i+8){
					if(!orderSetValues.get(i).equals(fluidCode)){
						freqCode = (String)orderSetValues.get(i+3);
					}
					if(orderSetValues.get(i).equals(fluidCode)){
						sRegRopt = (String)orderSetValues.get(i+6);
					}
				}
			}
			out.println("clearData();") ;
			ArrayList freqValues = bean.getDrugSheduleFrequency((String)hm.get("DRUG_CODE"));
			for (int i=0;i<freqValues.size();i+=2){
				if(freqValues.get(i).equals(freqCode)){
					out.println("addOption('"+((String)freqValues.get(i))+"','"+((String)freqValues.get(i+1))+"','selected');");
				}
				else{
					out.println("addOption('"+((String)freqValues.get(i))+"','"+((String)freqValues.get(i+1))+"');");
				}
			}

			if(orderSetValues.size() > 0){
				if(fluid_cmptble_yn.equals("Y")){
					out.println("assignDfltVehicleWithAdmin('"+(String)hm.get("DRUG_CODE")+"','"+(String)hm.get("DRUG_DESC")+"','"+dosage+"','"+dosage_uom+"','','"+sRegRopt+"')");
				}
			}
			else{	
				out.println("assignDfltVehicleWithAdmin('"+(String)hm.get("DRUG_CODE")+"','"+(String)hm.get("DRUG_DESC")+"','"+(String)hm.get("QTY_VALUE")+"','"+(String)hm.get("PRES_BASE_UOM")+"')");
			}
		   
			if (iv_bean.checkForStock()){

				ArrayList stockDetails = iv_bean.getStockDetails(fluidCode, "1");

				if(orderSetValues.size() > 0){
					out.println("setStockDetails(1, \""+ dosage + "\", \"" + dosage_uom + "\");") ;
				} 
				else{
					if (stockDetails.size() != 0)
						out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					else
						out.println("setStockDetails(2);") ;
				}
			}
			out.println("setOrderType(\""+ orderType + "\");");
			String infuse	=	iv_bean.getInfuseOverValue(fluidCode,drug_code);//drug_code added for ML-MMOH-CRF-1223 
			out.println("setInfuseValue(\""+infuse+ "\");");
			out.println("setSchedule();");
		}
		else if (validate.equals("GETSCHEDULEDFREQORNOT")) {
			String freq_code	= request.getParameter("freq_code");
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;

			iv_bean.resetscheduleFrequency();
			boolean sched_yn	= iv_bean.getScheduledFreqYN(freq_code);
			String repeat_value = iv_bean.getRepeatValue();
			String freq_nature	= iv_bean.getFrequencyNature();
			String mode			=	"";
			out.println("setSchedFreqActivated(\"" + sched_yn + "\", \"" + repeat_value + "\", \"" + mode + "\", \"" + freq_nature + "\");") ;
			//out.println("setRepeatValue( \"" + repeat_value + "\");") ;

		}
		//if the drug is scheduled  - store the values in OR_BEAN
		else if (validate.equals("AUTOSCHEDULE")) {
			
			Hashtable schedule_val	=	new Hashtable();
			ArrayList schedule		=	null;
			Hashtable sch_output	=	null;
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

			String start_date		= request.getParameter("start_date");
			String qty_value		= request.getParameter("qty_value");
			String freq_code		= request.getParameter("freq_code");
			String drug_code		= request.getParameter("drug_code");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			if(iv_bean.getScheduledFreqYN(freq_code) && !iv_bean.checkPreScheduled(freq_code).equals("0")) {
				schedule	=	(ArrayList)iv_bean.getScheduleFrequencyStr(drug_code,"0");

				if(schedule.size()==0) {
					ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name ,request);
					schedule_bean.setLanguageId(locale);
					schedule_val.put("facility_id", (String)session.getValue("facility_id"));
					schedule_val.put("start_time_day_param", start_date);
					schedule_val.put("module_id", "PH"); 
					schedule_val.put("split_dose_yn", "N"); 
					schedule_val.put("split_qty",qty_value);
					schedule_val.put("freq_code",  freq_code );
					schedule_val.put("code",drug_code);
//out.println("alert('"+drug_code+"')");
					sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
					sch_output.put("code",drug_code);
					sch_output.put("row_value","1");
					sch_output.put("start_date_time",start_date);
					iv_bean.setScheduleFrequencyStr(sch_output);
					//out.println("makeLink()");
					putObjectInBean(sch_bean_id,schedule_bean,request);
				} 
				HashMap chkValuescheduleFrequency	=	null;
				ArrayList frequencyValues	        =	null;
				chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();

				if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
					frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code);
				}
			   HashMap data		    =	null;
			   String att			=	null;
			   String adm_time		=	"";
			   String adm_qty		=	"";
			   String total_qty	    =   "";

				if(frequencyValues!=null && frequencyValues.size()>0){
				/*	adm_time =adm_time +"<tr>";					
					for(int i=0;i<frequencyValues.size();i++){
						data=(HashMap)frequencyValues.get(i);
						att="align=center class=TIP";
						adm_time =adm_time +"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
					}
					adm_time =adm_time +"</tr>";
					adm_qty=adm_qty +"<tr>";
					for(int i=0;i<frequencyValues.size();i++){
						att="align=center class=TIP";
						data=(HashMap)frequencyValues.get(i);
						adm_qty=adm_qty +"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
						total_qty=(String) data.get("admin_qty");
					}
					adm_qty=adm_qty +"</tr>";*/
					String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
					boolean split_chk	=	iv_bean.checkSplit(frequencyValues);
					adm_qty = tooltiptable;
					out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','"+iv_bean.getRepeatValue()+"')");
				}
			}

		}
		else if (validate.equals("AUTOSCHEDULE1")) {

			String drug_code		= request.getParameter("drug_code");
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
			HashMap chkValuescheduleFrequency	=	null;
			ArrayList frequencyValues	        =	null;
			chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();

			if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0)
				   frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code);

			HashMap data		    =	null;
			String att			=	null;
			String adm_time		=	"";
			String adm_qty		=	"";
			String total_qty	    =   "";

			if(frequencyValues!=null && frequencyValues.size()>0){
/*				adm_time=adm_time +"<tr>";					
				for(int i=0;i<frequencyValues.size();i++){
					data=(HashMap)frequencyValues.get(i);
					att="align=center class=TIP";
					adm_time=adm_time +"<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
				}
				adm_time=adm_time +"</tr>";

				adm_qty=adm_qty +"<tr>";
				for(int i=0;i<frequencyValues.size();i++){
					att="align=center class=TIP";
					data=(HashMap)frequencyValues.get(i);
					adm_qty=adm_qty +"<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
					total_qty=(String) data.get("admin_qty");
				}
				adm_qty=adm_qty +"</tr>";
*/
					String tooltiptable = (String)bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
				adm_qty = tooltiptable;
				boolean split_chk	=	iv_bean.checkSplit(frequencyValues);
				out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"','"+iv_bean.getRepeatValue()+"')");
			}
		}
		else if (validate.equals("DELETESCHEDULE")) {
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;
			String drug_code		= request.getParameter("drug_code");
			iv_bean.clearscheduleFrequency(drug_code);
		}
		else if(validate != null && validate.equals("populateDurnDesc"))	{
			String repeat_durn_type		= (String) request.getParameter( "repeat_durn_type" );
			String formObj		= (String) request.getParameter( "formObj" );
			Hashtable DurnDescDetails	= (Hashtable)bean.loadDurnDesc();
			Enumeration keys_des		= DurnDescDetails.keys();
			String	durn_code	= "";
			String	durn_desc	= "";
			boolean flag		= true;

			while(keys_des.hasMoreElements()){
					durn_code	= (String)keys_des.nextElement();
					durn_desc	= (String)DurnDescDetails.get(durn_code);				
					if(repeat_durn_type.equals("M")){
						if(durn_code.equals("M") || durn_code.equals("H") || durn_code.equals("D")){
							flag		= true;
						}else{
							flag		= false;
						}
					}else if(repeat_durn_type.equals("H")){
						if(durn_code.equals("H") || durn_code.equals("D") || durn_code.equals("W")){
							flag		= true;
						}else{
							flag		= false;
						}
					}else if(repeat_durn_type.equals("D")){
						if(durn_code.equals("D") || durn_code.equals("W") || durn_code.equals("L") || durn_code.equals("Y")){
							flag		= true;
						}else{
							flag		= false;
						}
					}else if(repeat_durn_type.equals("W")){
						if(durn_code.equals("W") || durn_code.equals("L") || durn_code.equals("Y")){
							flag		= true;
						}else{
							flag		= false;
						}
					}else if(repeat_durn_type.equals("L")){
						if(durn_code.equals("L") || durn_code.equals("Y")){
							flag		= true;
						}else{
							flag		= false;
						}
					}
					if(flag){
						out.println("addDurnDescList(\""+durn_code+"\",\""+durn_desc+"\",\""+formObj+"\")");
					}
			}

			out.println("dfltDurnDesc('"+repeat_durn_type+"','"+formObj+"')");

		}
		else if(validate != null && validate.equals("populateDurationDesc")){
			String freq_code			= (String) request.getParameter( "freq_code" );
			String durn_desc			= "";
			String repeat_durn_type		= "";
			String freq_value			= "";
			String freq_nature			= "";
			String interval_value		= "";
			String interval_durn_type		= "";
			String repeat_value			= "";
			String schedule_yn			= "";
			String formObj =(String) request.getParameter( "formObj" );
			if(iv_bean.getLanguageId() == null || iv_bean.getLanguageId().equals(""))
					iv_bean.setLanguageId(locale);
          
			HashMap freqNature			=(HashMap)iv_bean.freqValidate(freq_code);
			if(freqNature.size()>0){
				freq_nature		= (String)freqNature.get("freq_nature");
				freq_value		= (String)freqNature.get("freq_value");
				interval_value	= (String)freqNature.get("interval_value");
				interval_durn_type	= (String)freqNature.get("interval_durn_type");
				repeat_value	= (String)freqNature.get("repeat_value");
				schedule_yn		= (String)freqNature.get("schedule_yn");
				repeat_durn_type= (String)freqNature.get("repeat_durn_type");
			}
			if(freq_nature != null && !freq_nature.equals("O")){
				out.println("dfltDurnDesc(\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+formObj+"\")");			
//out.println("alert('"+repeat_durn_type+"')");
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\",\""+formObj+"\")");
			}
			else{
				durn_desc	="";
				freq_value	="";			
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\",\""+formObj+"\")");
			}
		}
		else if(validate != null && validate.equals("populateEndDate")){
			String freq_nature			= (String) request.getParameter( "freq_nature" );
			String start_date			= (String) request.getParameter( "start_date" );
			String durn_value			= (String) request.getParameter( "durn_value" );
			String repeat_durn_type		= (String) request.getParameter( "repeat_durn_type" );
		
			if(!locale.equals("en"));
				start_date  = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
			String end_date=(String)iv_bean.populateEndDate(freq_nature,start_date,durn_value,repeat_durn_type);
			if(!locale.equals("en"));
				end_date  = DateUtils.convertDate(end_date, "DMYHM","en",locale);
			out.println("assignEndDate(\""+end_date+"\")");
		}
	/* 	else if(validate.equals("POPULATEENDDATE")) {
			String start_date	= request.getParameter("start_date");
			String durn_value	= request.getParameter("durn_value");
			String durn_unit	= request.getParameter("durn_unit");
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
			String end_date		= iv_bean.populateEndDate(start_date, durn_value, durn_unit);
			out.println("setEndDate(\""+ end_date +"\");");
		} */
		else if(validate.equals("GETVEHICLE")){//Hope This block is not used ("SRR20056-SCF-7374 IN27415")
			String drug_code = request.getParameter("drug_code");
			String pract_id		= request.getParameter("pract_id");
			String resp_id		= request.getParameter("resp_id");


			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name, request);
			ArrayList dfltFluidDetails = iv_bean.getCompFluidDetails(drug_code,pract_id,resp_id);
			String orderType	= iv_bean.getOrderType(drug_code);
			String fluid_code = "";
			if(dfltFluidDetails!=null && dfltFluidDetails.size() > 0) {
				out.println("clearDfltVehicle();");
				int fluid_adr_count = 0;
				for(int j=0; j<dfltFluidDetails.size();j+=7 ){
					fluid_adr_count = iv_bean.getADRCount(patient_id,(String)dfltFluidDetails.get(j));
					out.println("assignDfltVehicle(\""+ dfltFluidDetails.get(j) + "\", \"" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+1)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "\", \"" + dfltFluidDetails.get(j+2)+ "\", \"" + dfltFluidDetails.get(j+3)+ "\", \"" + dfltFluidDetails.get(j+4)+ "\", \"" + java.net.URLEncoder.encode(((String)dfltFluidDetails.get(j+5)).replaceAll(" ","%20"),"UTF-8").replaceAll("%2520","%20") + "\",\"" + fluid_adr_count + "\");") ;
					if(((String)dfltFluidDetails.get(j+3)).equals("Y")){
						fluid_code = (String)dfltFluidDetails.get(j);
					}
				}
				iv_bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED

				if (iv_bean.checkForStock()) {
					ArrayList stockDetails = iv_bean.getStockDetails(fluid_code, "1");
					if (stockDetails.size() != 0)
						out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					else
					out.println("setStockDetails(2);") ;
				}
				out.println("setOrderType(\""+ orderType + "\");");
				//String infuse	=	iv_bean.getInfuseOverValue(fluid_code);
				String infuse	=	iv_bean.getInfuseOverValue(fluid_code,drug_code);//drug_code added for ML-MMOH-CRF-1223
				out.println("setInfuseValue(\""+infuse+ "\");");
			}
					
			/*if(dfltFluidDetails!=null && dfltFluidDetails.size() > 0) {
				out.println("assignDfltVehicle(\""+ dfltFluidDetails.get(0) + "\", \"" + dfltFluidDetails.get(1) + "\", \"" + dfltFluidDetails.get(2) + "\");") ;
				String fluid_code=(String)dfltFluidDetails.get(0);
				iv_bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED

				if (iv_bean.checkForStock()) {
					ArrayList stockDetails = iv_bean.getStockDetails(fluid_code, "1");
				
					if (stockDetails.size() != 0)
						out.println("setStockDetails(1, \""+ stockDetails.get(0) + "\", \"" + stockDetails.get(1) + "\", \"" +iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1)) + "\");") ; // stockDetails.get(2)  replaced with bean.getUomDisplay((String)session.getValue("facility_id"),stockDetails.get(1)) for SKR-SCF-528 IN[032949] by Sureshkumar T on 06/06/2012
					else
						out.println("setStockDetails(2);") ;
				}
				out.println("setOrderType(\""+ orderType + "\");");
				String infuse	=	iv_bean.getInfuseOverValue(dfltFluidDetails.get(0).toString());
				out.println("setInfuseValue(\""+infuse+ "\");");
			}*/
		}
		else if(validate.equals("FLUIDREMARKS")){

			String fluid_remarks    = request.getParameter("fluid_remarks");
			String default_fluid_name    = request.getParameter("default_fluid_name");
			StringBuffer fld_rmrks	= new StringBuffer();
			//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name, request);

			if(iv_bean.getFluidRemarks() != null && !(iv_bean.getFluidRemarks().equals(""))){
				fld_rmrks.append(fluid_remarks);
			}
			else{
				fld_rmrks.append("Default Fluid ");
				fld_rmrks.append(default_fluid_name);
				fld_rmrks.append(" changed. Remarks : ");
				fld_rmrks.append(fluid_remarks);
			}
			iv_bean.setFluidRemarks(fld_rmrks.toString());
		}else if(validate.equals("SETUOM")){
			String strengthUom = request.getParameter("strengthUom");
			String drug_dosage = request.getParameter("drug_dosage");
			String dosage_type = request.getParameter("dosage_type");

			ArrayList drugList			= iv_bean.getDrugDetails();
			if(drugList!=null && drugList.size()>0){
			HashMap hm	= (HashMap)drugList.get(0);
			hm.put("PRES_QTY_UOM",strengthUom);
			hm.put("QTY_UOM",strengthUom);
			hm.put("QTY_DESC_CODE",strengthUom);
			hm.put("QTY_VALUE",drug_dosage);
			hm.put("DOSAGE_TYPE",dosage_type);
			}
			putObjectInBean(iv_bean_id,iv_bean,request);

		}else if(validate.equals("loadDoseDetails")){
			String dosage_type = request.getParameter("dosage_type");
		//	String rx_qty_by_pres_base_uom_yn = request.getParameter( "rx_qty_by_pres_base_uom_yn" )==null?"N": request.getParameter( "rx_qty_by_pres_base_uom_yn" ) ;
		//	String pres_base_uom = request.getParameter( "pres_base_uom" )==null?"":request.getParameter( "pres_base_uom" ) ;
			ArrayList drugList			= iv_bean.getDrugDetails();
			String StrengthValue = "";
			String StrengthUom = "";
			String strength_uom_desc = "";
			String QtyUom = ""; 
			String QtyUom_desc = "";
			String QtyValue = "";
			String drug_code = request.getParameter("drug_code");
			if(drugList!=null && drugList.size()>0){
				HashMap hm	= (HashMap)drugList.get(0);
				StrengthUom = (String)hm.get("STRENGTH_UOM");
				strength_uom_desc = (String)hm.get("STRENGTH_UOM_DESC");
				StrengthValue = (String)hm.get("STRENGTH_PER_PRES_UOM");
				
				QtyUom = (String)hm.get("QTY_UOM"); 
				QtyUom_desc = (String)hm.get("PRES_BASE_UOM");
				QtyValue = (String)hm.get("PRES_QTY_VALUE");
				
				if(dosage_type.equals("S")){
					out.println("setDosageDetails('"+StrengthValue+"')");
					out.println("addData('"+ StrengthUom + "','" + strength_uom_desc +"', 'document.formIVPiggyBackDrugDetails.STRENGTH_UOM');") ;
				}else{
					Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_code);
					Enumeration keys_des		= QtyDescDetails.keys();
					String uom_code				= "";
					String uom_desc				= "";
					String def_uom_code			= "";
					while(keys_des.hasMoreElements()) {
						uom_code = (String)keys_des.nextElement();
						uom_desc = (String)QtyDescDetails.get(uom_code);

						if(!uom_code.equals("dflt_code"))
							out.println("addData('"+ uom_code + "','" + uom_desc +"', 'document.formIVPiggyBackDrugDetails.STRENGTH_UOM');") ;
						else
							def_uom_code = (String)QtyDescDetails.get("dflt_code");
					}

			//			if(rx_qty_by_pres_base_uom_yn.equals("Y"))
				//			def_uom_code= pres_base_uom;
					
					out.println("setDosageDetails('"+QtyValue+"','"+def_uom_code+"')");

				}
				//out.println("setDefaultData('"+ def_uom_code +"', 'document.formIVPiggyBackDrugDetails', '1');") ;
			}
		}

		putObjectInBean(bean_id,bean,request);
	} //start at 33{
	if(validate.equals("RELEASE")){
		
		String dosage			= request.getParameter("dosage");
		String dosagetype		= request.getParameter("dosage_type");
		String volume			= request.getParameter("volume");
		String calc_dose_by		= request.getParameter("calc_dose_by");
		String calc_dose_value	= request.getParameter("calc_dose_value");
		String calc_dose_based_on = request.getParameter("calc_dose_based_on");
		String fluid_code		= (String)hash.get("vehicle");
		String pat_class		= request.getParameter("pat_class"); //added for the SKR-SCF-0536[Inc:33123] 
		String auth_yn_val		= (String)hash.get("AUTH_YN_VAL");
		String APPROVAL_YN_VAL  = (String)hash.get("APPROVAL_YN_VAL");
		String DRUG_QTY_UOM	= (String)hash.get("DRUG_QTY_UOM");
		String allow_alternate = (String)hash.get("allow_alternate")==null?"":(String)hash.get("allow_alternate");//GHL-CRF-0549
		String drug_indication		= (String)hash.get("DRUG_INDICATION")==null?"":(String)hash.get("DRUG_INDICATION");
		String lstInfusionRateDurnUnit		= (String)hash.get("INFUSE_OVER_UNIT")==null?"":(String)hash.get("INFUSE_OVER_UNIT");//INO71514
		String validate_overide_on_confirm_yn  = (String)hash.get("validate_overide_on_confirm_yn")==null?"N":(String)hash.get("validate_overide_on_confirm_yn");//Added for IN:069887 
		String abuse_override_remarks="";
		String abuse_override="";
		String abuse_exists="";
		String abuse_action="";
		
	
		if(!drug_indication.equals(""))
			drug_indication = java.net.URLDecoder.decode(drug_indication,"UTF-8"); ;
	/*=============================================================================================================*/
	/*=============================================================================================================*/
		String durn_value = (String)hash.get("DURN_VALUE")==null?"0":(String)hash.get("DURN_VALUE");
		String durn_type = (String)hash.get("durn_unit")==null?"0":(String)hash.get("durn_unit");
	/*=============================================================================================================*/

		String narcotic_yn = "N";

		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name, request);
     //   bean.setFluidDetails(fluid_code);
		bean.setDOSAGE(dosage);
		bean.setVOLUME(volume);
		bean.setPatientClass(pat_class); //added for the SKR-SCF-0536[Inc:33123] 
		  
		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name , request) ;
		
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id, or_bean_name, request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();
		bean.setAmendRemarks(pres_bean.getPresRemarks());
		
		ArrayList DrugRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable

		int seq_num = 0;		
		if(bean.getOrderID() == null || (bean.getOrderID()).equals(""))
			bean.setOrderID();
		
		String order_id	= bean.getOrderID();		
		String order_format_values = "";

		arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code, fluid_code+"_0");

		if(arrSeq_num!= null && arrSeq_num.size() >0) {
			int i=0;
			for(i=0;i<arrSeq_num.size();i++) {
				seq_num		= ((Integer)arrSeq_num.get(i)).intValue();	// get the seq_num
				template	= (java.util.Hashtable)	orderEntryRecordBean.getOrderFormats(fluid_code, (fluid_code+seq_num));
				orderFormatHash.put("seq_num"+i,String.valueOf(seq_num));
				orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
				orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
				orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
				orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
				orderFormatHash.put("field_values"+i,(String) template.get("field_values"));
				order_format_values =order_format_values + ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
			}
			orderFormatHash.put("order_format_count", (String.valueOf(i)));
			orderFormatHash.put("order_id", order_id);
			orderFormatHash.put("order_format_values", order_format_values);
		}
		else {
			orderFormatHash.put("order_format_count", "0");
			orderFormatHash.put("order_id", order_id);
			orderFormatHash.put("order_format_values", "");
		}
		DrugRemarks.add(orderFormatHash);
		ArrayList drugList	= bean.getDrugDetails();
		String freq_code	= (String)hash.get("FREQUENCY");
		TreeSet ordStat		= new TreeSet();
        bean.getScheduledFreqYN(freq_code);   
		boolean cont_flag	= true;
		if (drugList.size() != 0) {
			String allergy_override		= "";
			String dose_override		= "";
			String currentrx_override	= "";
			String currentrx_remarks	= "";
			String allergy_remarks		= "";
			String dose_remarks			= "";	
			String external_database_overrided_reason			= "";	
			String perform_external_database_checks_yn			= "";	
			
			
			for(int i=0;i<drugList.size();i++) {
				
				HashMap drugDetails = (HashMap)drugList.get(i);
				if(drugDetails.get("DRUG_CLASS") != null && ((String)drugDetails.get("DRUG_CLASS")).equals("N"))
					narcotic_yn = "Y";

				if (drugDetails.size() != 0) {
					
					orderFormatHash	= new HashMap();	// To store it in the HashMap
					arrSeq_num		= new ArrayList();	// get the seq in ArrayList
					template		= new Hashtable();	// get the template values in the HashTable
					seq_num 		= 0;
					drugDetails.put("DOSAGE_TYPE",dosagetype);
					drugDetails.put("QTY_VALUE",dosage);
					drugDetails.put("CALC_DOSE_BY",calc_dose_by);
					drugDetails.put("CALC_DOSE_VALUE",calc_dose_value);
					drugDetails.put("CALC_DOSE_BASED_ON",calc_dose_based_on);
					drugDetails.put("DURN_VALUE",durn_value);
					drugDetails.put("DRUG_QTY_UOM",DRUG_QTY_UOM);
					drugDetails.put("DURN_TYPE",durn_type);  //added while fixing IN25314 --01/12/2010-- priya
					drugDetails.put("DRUG_INDICATION",drug_indication);  //added while fixing IN25314 --01/12/2010-- priya
					drugDetails.put("allow_alternate",allow_alternate);//GHL-CRF-0549
					drugDetails.put("INFUSE_OVER_UNIT",lstInfusionRateDurnUnit);//INO71514
					order_format_values	= "";
					arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code, fluid_code+"_0");
					String catalog_code	= (String)drugDetails.get("DRUG_CODE");
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
							seq_num		= ((Integer)arrSeq_num.get(k)).intValue();	// get the seq_num
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
							order_format_values =order_format_values + ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
						}
						orderFormatHash.put("order_format_count", (String.valueOf(k)));
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", order_format_values);
					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", "");
					}
					DrugRemarks.add(orderFormatHash);
					allergy_override		= "";
					dose_override		= "";
					currentrx_override	= "";
					currentrx_remarks	= "";
					allergy_remarks		= "";
					dose_remarks			= "";	
					external_database_overrided_reason			= "";	
					perform_external_database_checks_yn			= "";	 
					cont_flag	= true;
					String allergy_remarks_yn="N", dup_remarks_yn="N", dose_remarks_yn="N",abuse_remarks_yn="N";//Added for IN:069887 

					if(drugDetails.containsKey("ALLERGY_YN") && drugDetails.get("ALLERGY_YN")!=null)
						allergy_override		= (String)drugDetails.get("ALLERGY_YN");
					if(drugDetails.containsKey("LIMIT_IND") && drugDetails.get("LIMIT_IND")!=null)
						dose_override		= (String)drugDetails.get("LIMIT_IND");
					if(drugDetails.containsKey("CURRENT_RX") && drugDetails.get("CURRENT_RX")!=null)
						currentrx_override	= (String)drugDetails.get("CURRENT_RX");
					if(drugDetails.containsKey("CURRENTRX_REMARKS") && drugDetails.get("CURRENTRX_REMARKS")!=null)
						currentrx_remarks	= (String)drugDetails.get("CURRENTRX_REMARKS");
				/*	//Added below condition for SKR-SCF-0693[Inc:36052] //Not required
					if(!currentrx_remarks.equals(""))
						currentrx_remarks = java.net.URLDecoder.decode(currentrx_remarks,"UTF-8");
					    drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					if(drugDetails.containsKey("ALLERGY_REMARKS") && drugDetails.get("ALLERGY_REMARKS")!=null)
						allergy_remarks		= (String)drugDetails.get("ALLERGY_REMARKS");
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!allergy_remarks.equals(""))
						allergy_remarks = java.net.URLDecoder.decode(allergy_remarks,"UTF-8");
					    drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					if(drugDetails.containsKey("DOSE_REMARKS") && drugDetails.get("DOSE_REMARKS")!=null)
						dose_remarks			= (String)drugDetails.get("DOSE_REMARKS");*/
					//Added below condition for SKR-SCF-0693[Inc:36052]
							//modified below condition for IN61417 chithra
						/*dose_remarks = java.net.URLDecoder.decode(dose_remarks,"UTF-8");
					    drugDetails.put("DOSE_REMARKS",dose_remarks);*/
						if(drugDetails.containsKey("DOSE_REMARKS") && drugDetails.get("DOSE_REMARKS")!=null)
					    dose_remarks=(String)drugDetails.get("DOSE_REMARKS");
					    //Added below condition for IN61417  --chithra
						if(drugDetails.containsKey("ALLERGY_REMARKS") && drugDetails.get("ALLERGY_REMARKS")!=null)
					    	allergy_remarks=(String)drugDetails.get("ALLERGY_REMARKS");
					DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( "@DrugInterfaceControlBean", "ePH.DrugInterfaceControlBean", request );
					 abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks");
					 abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");
					 abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
					 abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
					/* System.out.println("1538 ABUSE_EXISTS"+drugDetails.get("ABUSE_EXISTS"));
					System.out.println("ABUSE_EXISTS"+drugDetails.get("ABUSE_OVERRIDE"));
					System.out.println("ABUSE_EXISTS"+drugDetails.get("ABUSE_ACTION"));
					System.out.println("ABUSE_EXISTS"+drugDetails.get("abuse_override_remarks")); */
					
// for fixing 25941 start
					String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn((String)session.getValue("facility_id")); 
					String drug_db_duptherapy_yn			=	param_bean.getDrugDBDuptherapy_yn((String)session.getValue("facility_id"));    

					if(drug_db_dosecheck_yn.equals("Y") && drugDetails.get("EXTERNAL_PRODUCT_ID") != "") {
						drugDetails.put("LIMIT_IND","Y");
						dose_override = "Y";
					}
					if(drug_db_duptherapy_yn.equals("Y") && drugDetails.get("EXTERNAL_PRODUCT_ID") != "") {
						drugDetails.put("CURRENT_RX","N");
						currentrx_override = "N";
					}
// for fixing 25941 end

					if ((allergy_override.equals("Y") && allergy_remarks.equals("")) || (dose_override.equals("N") && dose_remarks.equals(""))  || (currentrx_override.equals("Y") && currentrx_remarks.equals(""))|| (abuse_exists.equals("Y") && abuse_action.equals("B") && abuse_override_remarks.equals(""))) {
					//Added for IN:069887 start
						if(allergy_override.equals("Y") && allergy_remarks.equals("")){
							allergy_remarks_yn="Y";
						}
						if(dose_override.equals("N") && dose_remarks.equals("")){
							dose_remarks_yn="Y";
						}
						if(currentrx_override.equals("Y") && currentrx_remarks.equals("")){
							dup_remarks_yn="Y";
						}
						if((abuse_exists.equals("Y") && abuse_action.equals("B") && abuse_override_remarks.equals(""))){
							abuse_remarks_yn="Y";
						}
						//Added for IN:069887  end
						cont_flag = false;
					}

					perform_external_database_checks_yn	= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
					external_database_overrided_reason	= (String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON")==null?"":(String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON");

					if(perform_external_database_checks_yn.equals("Y") && (external_database_overrided_reason.equals("") || external_database_overrided_reason.equals("N")))
						cont_flag = false;

					if(cont_flag){
						
						String ord_auth_reqd_yn			= "";
						String ord_appr_reqd_yn			= "";
						String ord_cosign_reqd_yn		= "";
						String init_auth_reqd_yn		= "";
						String init_spl_appr_reqd_yn	= "";
						String init_cosign_reqd_yn		= "";
						if(auth_yn_val.equals("Y")){
							  drugDetails.put("AUTH_YN_VAL","Y");
							  drugDetails.put("ORD_AUTHORIZED_YN","Y");
						}
						if(APPROVAL_YN_VAL.equals("Y")){
							  drugDetails.put("APPROVAL_YN_VAL","Y");
						}
						
						if(drugDetails.containsKey("ORD_AUTHORIZED_YN") && drugDetails.get("ORD_AUTHORIZED_YN")!=null)
							ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTHORIZED_YN");
						if(drugDetails.containsKey("APPROVAL_YN_VAL") && drugDetails.get("APPROVAL_YN_VAL")!=null)
							ord_appr_reqd_yn		= (String)drugDetails.get("APPROVAL_YN_VAL");
						if(drugDetails.containsKey("ORD_SPL_APPR_REQD_YN") && drugDetails.get("ORD_SPL_APPR_REQD_YN")!=null)
							ord_cosign_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
						if(drugDetails.containsKey("ORD_AUTH_REQD_YN") && drugDetails.get("ORD_AUTH_REQD_YN")!=null)
							init_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTH_REQD_YN");
						if(drugDetails.containsKey("ORD_SPL_APPR_REQD_YN") && drugDetails.get("ORD_SPL_APPR_REQD_YN")!=null)
							init_spl_appr_reqd_yn	= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
						if(drugDetails.containsKey("ORD_COSIGN_REQD_YN") && drugDetails.get("ORD_COSIGN_REQD_YN")!=null)
							init_cosign_reqd_yn		= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
						String order_status				= "";

						if(init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("N")){
							order_status="10";
						}
						else if (init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("Y")) {
							if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status	=	"05";
						}
						else if (init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("N")) {
							if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
								order_status	=	"10";
							else
								order_status="03";
						}
						else if(init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("Y")){
							if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
								order_status="10";
							}
							else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y")){
								order_status="03";
							}
							else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")){
								order_status="05";
							} 
							else {
								order_status="05";
							}
						}
						if(drugDetails.get("CONSENT_REQD_YN").equals("Y") && drugDetails.get("CONSENT_STAGE").equals("A")){
							order_status = "00"; //PC - Pending consent
						}
						ordStat.add(order_status);
					}
					else{
					// Modified for IN:069887 start
						if(validate_overide_on_confirm_yn.equals("Y")){
							
						if(perform_external_database_checks_yn.equals("Y") && (external_database_overrided_reason.equals("") || external_database_overrided_reason.equals("N"))){
							out.println("mandateRemarks();");
						}
						else{
							out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"','"+abuse_remarks_yn+"')");
						}
							
						}else{
							out.println("mandateRemarks();");
						}
						// Modified for IN:069887 end
						break;
					}
				}
			}
			if (cont_flag) {
				if (ordStat.size() != 0){
					bean.setOrderStatus(ordStat.last().toString());
				}
			}
		}
		boolean result	= false;
		if (cont_flag) {
			bean.genDrugRemarks(DrugRemarks);			
			bean.setPatId(patient_id);
			bean.setEncId(encounter_id);
			bean.setIVType("IVD");
			bean.setIVPB("Y");	
			
			HashMap returndata = bean.prepareOrderDetails(hash);
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
			result	= ((Boolean)returndata.get("result")).booleanValue();
			String message	= (String)returndata.get("message")==null?"":(String)returndata.get("message");
			String flag		= (String)returndata.get("flag")==null?"":(String)returndata.get("flag");
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\", \"" + narcotic_yn + "\", \"" + print_ord_sht_rule_ind + "\");");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		}
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(pres_bean_id,pres_bean,request);
		putObjectInBean(or_bean_id,orbean,request);
	} //start at 882
	if(validate.equals("AMENDRELEASE")){
		
		String order_id		= request.getParameter("order_id");      
		String fluid_code	= (String)hash.get("vehicle");
		String DRUG_QTY_UOM	= (String)hash.get("DRUG_QTY_UOM");
		String drug_indication =(String)hash.get("DRUG_INDICATION")==null?"":(String)hash.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938] 
		String dosage		= request.getParameter("dosage");
		String volume		= request.getParameter("volume");
		String pract_id		= request.getParameter("pract_id");
		String resp_id		= request.getParameter("resp_id");
		String buildMAR_yn  = request.getParameter("buildMAR_yn");
		String calc_dose_based_on  = request.getParameter("calc_dose_based_on");
		String calc_dose_value  = request.getParameter("calc_dose_value");
		String calc_dose_by  = request.getParameter("calc_dose_by");
		String validate_overide_on_confirm_yn  = (String)hash.get("validate_overide_on_confirm_yn")==null?"N":(String)hash.get("validate_overide_on_confirm_yn");//Added for IN:069887
		
		String narcotic_yn  = "N";
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
		bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED
		bean.setBuildMAR_yn(buildMAR_yn);
		bean.setDOSAGE(dosage);
		bean.setVOLUME(volume);
		if(!drug_indication.equals(""))
			drug_indication = java.net.URLDecoder.decode(drug_indication,"UTF-8"); ;
		   
		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name, request ) ;
		String or_bean_name		= "eOR.OrderEntryBean";
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean	= (OrderEntryBean)getBeanObject(or_bean_id, or_bean_name, request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean)orbean.getOrderEntryRecordBean();

		bean.setAmendRemarks(pres_bean.getPresRemarks());
		String called_amend_from=pres_bean.getCalledFromAmend();
		ArrayList DrugRemarks	= new ArrayList();
		HashMap orderFormatHash	= new HashMap();	// To store it in the HashMap
		ArrayList arrSeq_num	= new ArrayList();	// get the seq in ArrayList
		Hashtable template		= new Hashtable();	// get the template values in the HashTable
		int seq_num = 0;
		String abuse_override_remarks="";
		String abuse_override="";
		String abuse_exists="";
		String abuse_action="";
		bean.setOrderID(order_id);
		String order_format_values = "";
		arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code, fluid_code+"_0");
		if(arrSeq_num!= null && arrSeq_num.size() >0) {
			int i=0;
			for(i=0;i<arrSeq_num.size();i++) {
				seq_num		= ((Integer)arrSeq_num.get(i)).intValue();	// get the seq_num
				template	= (java.util.Hashtable)	orderEntryRecordBean.getOrderFormats(fluid_code, (fluid_code+seq_num));
				orderFormatHash.put("seq_num"+i,String.valueOf(seq_num));
				orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
				orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
				orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
				orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
				orderFormatHash.put("field_values"+i,(String) template.get("field_values"));
				order_format_values =order_format_values + ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
			}
			orderFormatHash.put("order_format_count", (String.valueOf(i)));
			orderFormatHash.put("order_id", order_id);
			orderFormatHash.put("order_format_values", order_format_values);
		}
		else {
			orderFormatHash.put("order_format_count", "0");
			orderFormatHash.put("order_id", order_id);
			orderFormatHash.put("order_format_values", "");
		}
		DrugRemarks.add(orderFormatHash);
		ArrayList drugList	= bean.getDrugDetails();
		String freq_code	= (String)hash.get("FREQUENCY");
        bean.getScheduledFreqYN(freq_code);
		TreeSet ordStat		= new TreeSet();
		boolean cont_flag	= true;
		if (drugList.size() != 0) {
			String allergy_override		= "";
			String dose_override		= "";
			String currentrx_override	= "";
			String currentrx_remarks	= "";
			String allergy_remarks		= "";
			String dose_remarks			= "";	
			String external_database_overrided_reason			= "";	
			String perform_external_database_checks_yn			= "";	
			String durn_value = "";
			String durn_type = "";
			 abuse_override_remarks="";
			 abuse_exists="";
			 abuse_action="";
			 abuse_override=""; 
			for(int i=0;i<drugList.size();i++) {
				HashMap drugDetails = (HashMap)drugList.get(i);

				if (drugDetails.size() != 0) {
					orderFormatHash	= new HashMap();	// To store it in the HashMap
					arrSeq_num		= new ArrayList();	// get the seq in ArrayList
					template		= new Hashtable();	// get the template values in the HashTable
					seq_num 		= 0;
					/*****   override check start *****/
					allergy_override		= "";
					dose_override		= "";
					currentrx_override	= "";
					currentrx_remarks	= "";
					allergy_remarks		= "";
					dose_remarks			= "";	
					external_database_overrided_reason			= "";	
					perform_external_database_checks_yn			= "";	
					cont_flag	= true;
					abuse_override_remarks="";
					abuse_override="";
					 abuse_exists="";
					 abuse_action="";
					String allergy_remarks_yn="N", dup_remarks_yn="N", dose_remarks_yn="N",abuse_remarks_yn="N";//Added for IN:069887
		/*=============================================================================================================*/
		//added while fixing IN25314 --01/12/2010-- priya
					 durn_value = (String)hash.get("DURN_VALUE")==null?"0":(String)hash.get("DURN_VALUE");
					 durn_type = (String)hash.get("durn_unit")==null?"0":(String)hash.get("durn_unit");
					drugDetails.put("DURN_VALUE",durn_value);
					drugDetails.put("DURN_TYPE",durn_type);
	/*=============================================================================================================*/
					if(drugDetails.get("DRUG_CLASS") != null && ((String)drugDetails.get("DRUG_CLASS")).equals("N"))
						narcotic_yn = "Y";
					drugDetails.put("CALC_DOSE_BASED_ON",calc_dose_based_on);
					drugDetails.put("CALC_DOSE_VALUE",calc_dose_value);
					drugDetails.put("CALC_DOSE_BY",calc_dose_by);
					drugDetails.put("DRUG_QTY_UOM",DRUG_QTY_UOM);
					drugDetails.put("DRUG_INDICATION",drug_indication);
					abuse_override_remarks=(String)hash.get("abuse_override_remarks")==null?"N":(String)hash.get("abuse_override_remarks");
					abuse_override=(String)hash.get("abuse_override")==null?"N":(String)hash.get("abuse_override");
					 abuse_exists=(String)hash.get("abuse_exists")==null?"N":(String)hash.get("abuse_exists");
					 abuse_action=(String)hash.get("abuse_action")==null?"N":(String)hash.get("abuse_action");
					
					
				System.out.println("abuse_override_remarks"+abuse_override_remarks+""+drugDetails.containsKey("ABUSE_OVERRIDE"));
		
					if(drugDetails.containsKey("ALLERGY_YN") && drugDetails.get("ALLERGY_YN")!=null)
						allergy_override		= (String)drugDetails.get("ALLERGY_YN");
					if(drugDetails.containsKey("LIMIT_IND") && drugDetails.get("LIMIT_IND")!=null)
						dose_override		= (String)drugDetails.get("LIMIT_IND");
					if(drugDetails.containsKey("CURRENT_RX") && drugDetails.get("CURRENT_RX")!=null)
						currentrx_override	= (String)drugDetails.get("CURRENT_RX");
					//Modified for IN:069887 start
					if(drugDetails.containsKey("CURRENTRX_REMARKS") && drugDetails.get("CURRENTRX_REMARKS")!=null){
						currentrx_remarks=(String)drugDetails.get("CURRENTRX_REMARKS");
						if(currentrx_remarks.equals("")){
							currentrx_remarks	= (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"):(String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON");// Modified for IN:069887						}
					}
				}	
						//Added below condition for SKR-SCF-0693[Inc:36052]
				   	if(!currentrx_remarks.equals(""))
						currentrx_remarks = java.net.URLDecoder.decode(currentrx_remarks,"UTF-8");
					    drugDetails.put("CURRENTRX_REMARKS",currentrx_remarks);
					if(drugDetails.containsKey("ALLERGY_REMARKS") && drugDetails.get("ALLERGY_REMARKS")!=null){
						allergy_remarks=(String)drugDetails.get("ALLERGY_REMARKS");
						if(allergy_remarks.equals("")){
							allergy_remarks		= (String)drugDetails.get("ALLERGY_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"):(String)drugDetails.get("ALLERGY_OVERRIDE_REASON");// Modified for IN:069887
						}
					}
						
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!allergy_remarks.equals(""))
						allergy_remarks = java.net.URLDecoder.decode(allergy_remarks,"UTF-8");
					    drugDetails.put("ALLERGY_REMARKS",allergy_remarks);
					if(drugDetails.containsKey("DOSE_REMARKS") && drugDetails.get("DOSE_REMARKS")!=null){
						dose_remarks=(String)drugDetails.get("DOSE_REMARKS");
						if(dose_remarks.equals("")){
							dose_remarks			= (String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"):(String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON");// Modified for IN:069887
						}
					}
					//Modified for IN:069887 end	
					//Added below condition for SKR-SCF-0693[Inc:36052]
					if(!dose_remarks.equals(""))//Modified for IN:069887 
						dose_remarks = java.net.URLDecoder.decode(dose_remarks,"UTF-8");
					    drugDetails.put("DOSE_REMARKS",dose_remarks);

					if ((allergy_override.equals("Y") && allergy_remarks.equals("")) || (dose_override.equals("N") && dose_remarks.equals(""))  || (currentrx_override.equals("Y") && currentrx_remarks.equals("")) || (abuse_exists.equals("Y") && abuse_action.equals("B") && abuse_override_remarks.equals(""))) {
					//Added for IN:069887  start	
						if(allergy_override.equals("Y") && allergy_remarks.equals("")){
							allergy_remarks_yn="Y";
						}
						if(dose_override.equals("N") && dose_remarks.equals("")){
							dose_remarks_yn="Y";
						}
						if(currentrx_override.equals("Y") && currentrx_remarks.equals("")){
							dup_remarks_yn="Y";
						}if(abuse_action=="B" && abuse_exists=="Y" && abuse_override_remarks==""){
							abuse_remarks_yn="Y";
						}
					//Added for IN:069887 end
						cont_flag = false;
					}


					perform_external_database_checks_yn	= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
					external_database_overrided_reason	= (String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON")==null?"":(String)drugDetails.get("EXTERNAL_DATABASE_OVERRIDED_REASON");

					if(perform_external_database_checks_yn.equals("Y") && (external_database_overrided_reason.equals("") || external_database_overrided_reason.equals("N")))
						cont_flag = false;
					/*****   override check end   *****/
					order_format_values	= "";
					arrSeq_num = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(fluid_code, fluid_code+"_0");
					String catalog_code	= (String)drugDetails.get("DRUG_CODE");
					if(arrSeq_num!= null && arrSeq_num.size() >0) {
						int k=0;
						for(k=0;k<arrSeq_num.size();k++) {
							seq_num		= ((Integer)arrSeq_num.get(k)).intValue();	// get the seq_num
							template	= (java.util.Hashtable)orderEntryRecordBean.getOrderFormats(catalog_code, (catalog_code+seq_num));
							orderFormatHash.put("seq_num"+k,String.valueOf(seq_num));
							orderFormatHash.put("field_mnemonic"+k,(String) template.get("field_mnemonic"));
							orderFormatHash.put("label_text"+k,(String) template.get("label_text"));
							orderFormatHash.put("accept_option"+k,(String) template.get("accept_option"));
							orderFormatHash.put("field_type"+k,(String) template.get("field_type"));
							orderFormatHash.put("field_values"+k,(String) template.get("field_values"));
							order_format_values =order_format_values + ((String) template.get("label_text") + " : " + (String) template.get("field_values")) +",";
						}
						orderFormatHash.put("order_format_count", (String.valueOf(k)));
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", order_format_values);
					}
					else {
						orderFormatHash.put("order_format_count", "0");
						orderFormatHash.put("order_id", order_id);
						orderFormatHash.put("order_format_values", "");
					}
					//Added for IN:069887 start
					if(!cont_flag){
						if(validate_overide_on_confirm_yn.equals("Y")){
							
						if(perform_external_database_checks_yn.equals("Y") && (external_database_overrided_reason.equals("") || external_database_overrided_reason.equals("N"))){
							out.println("mandateRemarks();");
						}
						else{
							out.println("showOverideMandAlert('"+allergy_remarks_yn+"','"+dup_remarks_yn+"','"+dose_remarks_yn+"','"+abuse_remarks_yn+"')");
						}
							
						}else{
							out.println("mandateRemarks();");
						}
						break;
					}
					//Added for IN:069887 end
					DrugRemarks.add(orderFormatHash);
					String ord_auth_reqd_yn			= "";
					String ord_appr_reqd_yn			= "";
					String ord_cosign_reqd_yn		= "";
					String init_auth_reqd_yn		= "";
					String init_spl_appr_reqd_yn	= "";
					String init_cosign_reqd_yn		= "";

					if(drugDetails.containsKey("ORD_AUTHORIZED_YN") && drugDetails.get("ORD_AUTHORIZED_YN")!=null)
						ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTHORIZED_YN");
					if(drugDetails.containsKey("APPROVAL_YN_VAL") && drugDetails.get("APPROVAL_YN_VAL")!=null)
						ord_appr_reqd_yn		= (String)drugDetails.get("APPROVAL_YN_VAL");
					if(drugDetails.containsKey("ORD_SPL_APPR_REQD_YN") && drugDetails.get("ORD_SPL_APPR_REQD_YN")!=null)
						ord_cosign_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
					if(drugDetails.containsKey("ORD_AUTH_REQD_YN") && drugDetails.get("ORD_AUTH_REQD_YN")!=null)
						init_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTH_REQD_YN");
					if(drugDetails.containsKey("ORD_SPL_APPR_REQD_YN") && drugDetails.get("ORD_SPL_APPR_REQD_YN")!=null)
						init_spl_appr_reqd_yn	= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
					if(drugDetails.containsKey("ORD_COSIGN_REQD_YN") && drugDetails.get("ORD_COSIGN_REQD_YN")!=null)
						init_cosign_reqd_yn		= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
					String order_status				= "";

					/*	if( (init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N")) ){
							order_status="10";
					}else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y"))){
						if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")))
							order_status	=	"10";
						else
							order_status	=	"00";
					}else if ((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N"))) {
						if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
							order_status	=	"10";
						else
							order_status	=	"05";
					}else if ((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("N"))) {
						if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y"))
							order_status	=	"10";
						else
							order_status="03";
					}
					else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("N"))){
						if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
							order_status="10";
						}
						else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y")){
							order_status="05";
						}else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")){
							order_status="03";
						} else {
							order_status="03";
						}
					}else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("N")) && (init_cosign_reqd_yn.equals("Y"))){
						if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
							order_status="10";
						}else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y"))){
							order_status="03";
						}else if((ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
							order_status="00";
						}else {
							order_status="00";
						}
					}else if((init_auth_reqd_yn.equals("N")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y"))){
						if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) ){
							order_status="10";
						}else {
							order_status="05";
						}
					} else if((init_auth_reqd_yn.equals("Y")) && (init_spl_appr_reqd_yn.equals("Y")) && (init_cosign_reqd_yn.equals("Y"))) {
						if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y"))) {
							order_status	=	"10";
						}
						else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) ) {
							order_status	=	"03";
						}
						else if((ord_cosign_reqd_yn!=null) && (ord_cosign_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) {
							order_status	=	"05";
						}
						else if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ) {
							order_status	=	"10";
						}
						else {
							order_status	=	"03";
						}
					}*/
					if(init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("N")){
						order_status="";//MODIFIED FOR IN073660
					}
					else if (init_auth_reqd_yn.equals("N") && init_spl_appr_reqd_yn.equals("Y")) {
						if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y"))
							order_status	=	"10";
						else
							order_status	=	"05";
					}
					else if (init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("N")) {
						if((ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")) )
							order_status	=	"10";
						else
							{//order_status="03"; commented for ml-mmoh-crf-0863 and new if else condtion added
							if( auth_amend_pres_yn.equalsIgnoreCase("Y") && called_amend_from.equals("PH")){
								order_status="";
							}
							else{
								order_status="03";
							}
							}
					}
					else if(init_auth_reqd_yn.equals("Y") && init_spl_appr_reqd_yn.equals("Y")){
						if((ord_appr_reqd_yn!=null) && (ord_appr_reqd_yn.equals("Y")) && (ord_auth_reqd_yn!=null) && (ord_auth_reqd_yn.equals("Y")) ){
							order_status="10";
						}
						else if(ord_appr_reqd_yn!=null && ord_appr_reqd_yn.equals("Y")){
							order_status="03";
						}
						else if(ord_auth_reqd_yn!=null && ord_auth_reqd_yn.equals("Y")){
							order_status="05";
						} 
						else {
							order_status="05";
						}
					}
					if(drugDetails.get("CONSENT_REQD_YN").equals("Y") && drugDetails.get("CONSENT_STAGE").equals("A")){
						order_status = "00"; //PC - Pending consent
					}
					ordStat.add(order_status);
				}

			}
		}
		if (ordStat.size() != 0){
			bean.setOrderStatus(ordStat.first().toString());
		}
		if (cont_flag) {//Added for IN:069887 
		bean.genDrugRemarks(DrugRemarks);		
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);
		bean.setIVType("IVD");
		bean.setIVPB("Y");
		
		HashMap returndata =null;        
		
		returndata = bean.prepareAmendOrderDetails(hash);
		String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0
		boolean result	= ((Boolean)returndata.get("result")).booleanValue();
		String message	= (String)returndata.get("message")==null?"":(String)returndata.get("message");
		String flag		= (String)returndata.get("flag")==null?"":(String)returndata.get("flag");
		
		out.println("assignResult('" + result + "','" + bean.replaceNewLineChar(message) + "','" + flag + "','" + narcotic_yn + "','" + print_ord_sht_rule_ind + "');");//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0
		}//Added for IN:069887 
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(pres_bean_id,pres_bean,request);
		putObjectInBean(or_bean_id,orbean,request);

	}
	if(validate != null && validate.equals("InsertExternalOverrideReason")){
		
	
		 String drug_code				 =	(String) hash.get( "drug_code" );
		 String srl_no					 =	(String) hash.get( "srl_no" );
		 String called_from				 =  (String) hash.get( "called_from" ); 
		 String External_Dosage_Override_Reason			= (String)hash.get("External_Dosage_Override_Reason");
		 String External_Duplicate_Override_Reason		= (String)hash.get("External_Duplicate_Override_Reason");
		 String External_Interaction_Override_Reason	= (String)hash.get("External_Interaction_Override_Reason");
		 String External_Contra_Override_Reason			= (String)hash.get("External_Contra_Override_Reason");
		 String External_Alergy_Override_Reason			= (String)hash.get("External_Alergy_Override_Reason");
		 String External_Database_Overrided_Reason			= (String)hash.get("External_Database_Overrided_Reason");
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

		 //IVPrescriptionBean iv_bean		= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;

			String iv_bean_id1			= "@IVPrescriptionBean"+patient_id+encounter_id;
			String iv_bean_name1			= "ePH.IVPrescriptionBean";
			IVPrescriptionBean iv_bean1	= (IVPrescriptionBean)getBeanObject( iv_bean_id1, iv_bean_name1, request ) ;
		    ArrayList drugDetails			= iv_bean1.getDrugDetails();

		 HashMap   drgDtls				= null;


		 for(int i = 0; i<drugDetails.size();i++){
			drgDtls = (HashMap)drugDetails.get(i);

//			if(drgDtls.get("DRUG_CODE").equals(drug_code)&& drgDtls.get("SRL_NO").equals(srl_no)){ chking for srl_no not required coz in iv intermittent there wil be only one drug unlike iv direct
			if(drgDtls.get("DRUG_CODE").equals(drug_code)){
				if(!External_Dosage_Override_Reason.equals("")){
					drgDtls.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",External_Dosage_Override_Reason);
					drgDtls.put("DOSE_REMARKS",External_Dosage_Override_Reason);
				}


				if(called_from != "DOSAGE"){
					if(!External_Duplicate_Override_Reason.equals(""))
						drgDtls.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",External_Duplicate_Override_Reason);
					
					drgDtls.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",External_Interaction_Override_Reason);
					drgDtls.put("EXTERNAL_CONTRA_OVERRIDE_REASON",External_Contra_Override_Reason);
					drgDtls.put("EXTERNAL_ALERGY_OVERRIDE_REASON",External_Alergy_Override_Reason);
					drgDtls.put("EXTERNAL_DATABASE_OVERRIDED_REASON",External_Database_Overrided_Reason);

					if(!(External_Duplicate_Override_Reason==null || External_Duplicate_Override_Reason.equals(""))){//modified on 21/10/2009
						drgDtls.put("CURRENTRX_REMARKS",External_Duplicate_Override_Reason);
					}
					if(!(External_Alergy_Override_Reason==null || External_Alergy_Override_Reason.equals(""))){ //modified on 21/10/2009
						drgDtls.put("ALLERGY_REMARKS",External_Alergy_Override_Reason);
					}
				}
				break;
			}
		}
		out.println("HideFDBOverrideImage('"+srl_no+"','"+called_from+"')");
		putObjectInBean(iv_bean_id,iv_bean,request);
   }
   else if(validate != null && validate.equals("ExternalDoseCheck")){
		String called_from					=	(String)hash.get("called_from");
		String weight						=	(String)hash.get("weight");				        
		String bsa							=	(String)hash.get("bsa");	
		String repeat_value					=	(String)hash.get("repeat_value");		
		String interval_value				=	(String)hash.get("interval_value");			
		String duration					    =	(String)hash.get("durn_value");			
		String drug_db_dose_check_flag		=   "N";
//		String frequency					=   (int)Math.ceil( Integer.parseInt(repeat_value) / Integer.parseInt(interval_value))+"";
		String frequency					=   repeat_value;
	
		String external_prod_id					=	"";
		String dosage							=	(String)hash.get("dose");	
		String dosage_by						=	(String)hash.get("DOSAGE_TYPE");	
		//String dosage_by						=	"";
		String dose_uom							=	"";
		String drug_code						=	"";
		String srl_no							=	"";
		String strength_per_pres_uom			=	"";
		String strength_per_value_pres_uom		=	"";
		String fract_dose_round_up_yn			=	"";
		String route_code	= (String)hash.get("route_code")==null?"":(String) hash.get( "route_code" );// Added in January 2014 for CIMS dosage check -start
		String qty_desc_code= (String)hash.get("qty_desc_code")==null?"":(String) hash.get( "qty_desc_code" );
		String repeat_durn_type	= hash.get("repeat_durn_type")==null?"":(String) hash.get( "repeat_durn_type" );
		String freq_nature	= hash.get( "freq_nature" )==null?"":(String) hash.get( "freq_nature" );
		String freq_nature_pas = "I";	  //Added in January 2014, CIMS Dosage Check -end
		//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name , request) ;
		ArrayList drugList	= iv_bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		if(drugList.size() > 0)
			drugDetails					= (HashMap)drugList.get(0);
		String extdrugCode						=   "";
		String extsrlNo							=   "";
		external_prod_id				=	(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
		//dosage							=	(String)drugDetails.get("STRENGTH_VALUE");
		//dosage_by						=	(String)drugDetails.get("DOSAGE_TYPE");	
		
		if(dosage_by.equals("S"))
			dose_uom						=	(String)drugDetails.get("STRENGTH_UOM");         
		else if(dosage_by.equals("Q") || dosage_by.equals("A"))
				dose_uom						=	(String)drugDetails.get("PRES_BASE_UOM");

		drug_code						=	(String)drugDetails.get("DRUG_CODE");				
		srl_no							=	(String)drugDetails.get("SRL_NO");				
		strength_per_pres_uom			=	(String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
		strength_per_value_pres_uom		=	(String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");	
		fract_dose_round_up_yn			=	iv_bean.getFractDoseRndyn(drug_code);

		if(dosage_by != null && dosage_by.equals("S")){
			if(fract_dose_round_up_yn.equals("Y")){
				float unit_qty	 =  (float) Math.ceil(Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom));	
				dosage			 =   unit_qty * Float.parseFloat(strength_per_value_pres_uom)+"";
			}
			else{
				dosage			 =  (Float.parseFloat(dosage)*Float.parseFloat(strength_per_value_pres_uom))+"";
				dosage			 =  (Float.parseFloat(dosage)/Float.parseFloat(strength_per_pres_uom))+"";
			}
			DecimalFormat dfTest =  new DecimalFormat("##.000");
			dosage				 =  dfTest.format(Double.parseDouble(dosage));
			dosage				 =	Math.ceil(Float.parseFloat(dosage))+"";
		}
		String ext_beanid   = "@ExternalProductLinkBean";
		String ext_beanname = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);

		HashMap drugDosageResult	= null;
		ArrayList dosageCheckParams = new ArrayList();
		dosageCheckParams.add(patient_id);
		dosageCheckParams.add(external_prod_id);
		dosageCheckParams.add(weight);
		dosageCheckParams.add(bsa);
		if(ext_beanObj!=null && (ext_beanObj.getProdID()).equals("CIMS"))  // Added in January 2014 - DOSAGE Checks Added
			dosageCheckParams.add(qty_desc_code);	// Added in January 2014 - DOSAGE Checks Added
		else
			dosageCheckParams.add(dosage);
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
				extdrugCode				= (String)drugDetails.get("DRUG_CODE");
				extsrlNo				= (String)drugDetails.get("SRL_NO");

				if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
					drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN",drug_db_dose_check_flag);
				}
			}
		}
		out.println("setextdoseflag('"+drug_db_dose_check_flag+"')");
	   if(!called_from.equals("ONLOAD")&& drug_db_dose_check_flag.equals("Y"))
			called_from = "DOSAGE";
	   else
			out.println("setextdoseflag('"+drug_db_dose_check_flag+"')");
	
		putObjectInBean(iv_bean_id,iv_bean,request);

	}
	else if (validate!= null && validate.equals("GET_TRNGROUPREF")){
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);

		String tokens_generated_yn = bean.getTokensGeneratedYN();
		String trn_group_ref = "";
		if(tokens_generated_yn.equals("Y")){
			trn_group_ref = bean.getTrnGroupRef();
		}
		out.println(trn_group_ref);
	}
	else if(validate.equals("DosageLimitCheck")){
		IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);

		String drug_code	= (String)hash.get("drug_code");
		String srl_no	= (String)hash.get("srl_no");
		String repeat_value			= (String)hash.get("repeat_value");
		String qty_value				= (String)hash.get("qty_value");
		String dosage_type				= (String)hash.get("dosage_type");

		ArrayList drugList	= bean.getDrugDetails();
		HashMap  drugDetails			= new HashMap();
		String extdrugCode = "";
		String extsrlNo = "";
		String factor="1";//Added for IN:070451

		HashMap dosageDetails= (HashMap) bean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value,factor);//Modified for IN:070451 Added factor
		String limit_ind= (String) dosageDetails.get("LIMIT_IND");

		if(drugList!=null && drugList.size()>0){
			for(int i=0;i<drugList.size();i++){
				drugDetails				= (HashMap)drugList.get(i);
				extdrugCode				= (String)drugDetails.get("DRUG_CODE");
				extsrlNo				= (String)drugDetails.get("SRL_NO");
				if(extdrugCode.equals(drug_code) && extsrlNo.equals(srl_no) ){					
					drugDetails.put("LIMIT_IND",limit_ind);
					if(limit_ind.equals("Y"))
						drugDetails.put("DOSE_REMARKS","");
				}
			}
		}

		if(limit_ind != null && limit_ind.equals("N")){
			String daily_dose = (String) dosageDetails.get("DAILY_DOSE");
			String unit_dose = (String) dosageDetails.get("UNIT_DOSE");
			String mono_graph = (String) dosageDetails.get("MONO_GRAPH");
			
			String min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE");
			String min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE");
			mono_graph=mono_graph.replaceAll(" ","%20");
			mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
			mono_graph=mono_graph.replaceAll("%2520","%20");
			out.println("enableDosageLimit('"+limit_ind+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+min_daily_dose+"','"+min_unit_dose+"')");
		}
		else{
			out.println("disableDosageLimit()");
		}
		putObjectInBean(bean_id, bean,request);

	}else if(validate.equals("SAVE_FLUIDDETAILS")){

			String fluid_code		= (String)hash.get("fluid_code");
			String drug_code		= (String)hash.get("drug_code");
			String infusion_over	= (String)hash.get("infusion_over");
			String tot_inf_prd		= (String)hash.get("tot_inf_prd");
			String durn_value		= (String)hash.get("durn_value");
			String drug_dosage		= (String)hash.get("drug_dosage");
			String fluid_volume		= (String)hash.get("fluid_volume");
			String repeat_value		= (String)hash.get("repeat_value");
			String freq_code		= (String)hash.get("freq_code");
			String freq_nature		= (String)hash.get("freq_nature");

			String mode		= (String)hash.get("mode");
			if(mode!=null && mode.equals("amend")){
			    String or_date_time		= (String)hash.get("or_date_time");

				iv_bean.setOrderDate(com.ehis.util.DateUtils.convertDate(or_date_time,"DMYHM",locale,"en"));			 
			} 
		//IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject(iv_bean_id, iv_bean_name, request);
		if(iv_bean.getLanguageId() == null || iv_bean.getLanguageId().equals(""))
					iv_bean.setLanguageId(locale);
          
			iv_bean.setDOSAGE(drug_dosage);
			iv_bean.setVOLUME(fluid_volume);

			float durn_value_f			= Float.parseFloat(durn_value);
			String pack_size	= iv_bean.getPackSize(fluid_code);
		//	durn_value_f		=	(durn_value_f/24);	
			HashMap fluidDetails	= iv_bean.getFluidDetails();
			HashMap freqDet = iv_bean.getscheduleFrequency();
			HashMap freqNature = null;
			String freqDurnType = "";
//for interval frequency there wont be schedule
			freqNature			=(HashMap)iv_bean.freqValidate(freq_code);
			if(!((String)freqNature.get("freq_nature")).equals("I") && freqDet!=null && freqDet.size()>0)	{
				freqDurnType = ((String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType")))==null?"":(String)(((HashMap)(((ArrayList)freqDet.get(drug_code)).get(0))).get("durationType"));
			}
			else{
				freqDurnType =  (String)freqNature.get("interval_durn_type");
				iv_bean.setRepeatValue((String)freqNature.get("freq_value"));
			}
		
			String durn_unit = (String)hash.get("durn_unit")==null?"":(String)hash.get("durn_unit");
		//	if(! freqDurnType.equals(durn_unit)) {
				int durn_calc = iv_bean.getDurationCalc(durn_unit,durn_value,freqDurnType);
				durn_value_f = Float.parseFloat(durn_calc+"");

				String interval_value_new  ="";
				if(mode.equals("amend")){
					HashMap freqNature_new 			=(HashMap)iv_bean.freqValidate(freq_code);
					 interval_value_new = (String)freqNature_new.get("interval_value")==null?"1":(String)freqNature_new.get("interval_value");

				}else{
                    interval_value_new =  (String)freqNature.get("interval_value");
				}

				if(freq_nature.equals("I") || (freq_nature.equals("F") && Float.parseFloat(interval_value_new) > 1 )){
					float interval_value = Float.parseFloat(interval_value_new);
					durn_value_f = durn_value_f / interval_value;
				}
		//	}
			
			if(repeat_value.equals(""))
				repeat_value			= iv_bean.getRepeatValue();
			
			String ordered_qty		=  "";
	
			if(freq_nature.equals("I") && mode!=null && mode.equals("amend")){
				ordered_qty = Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size))*durn_value_f+"";
			}else{

				ordered_qty = Math.ceil(Float.parseFloat(tot_inf_prd)/Float.parseFloat(pack_size))*durn_value_f*(Integer.parseInt(repeat_value))+"";
			}

			if(fluid_code.equals(fluidDetails.get("DRUG_CODE"))){
			
				fluidDetails.put("ORDERED_QTY",ordered_qty);
			}

			putObjectInBean(iv_bean_id,iv_bean,request);
		}
		else if(validate.equals("FINDDISPLOCATION")){
	DrugSearchBean	bean1	 =	(DrugSearchBean)getBeanObject( "DrugSearchBean", "ePH.DrugSearchBean", request ) ;
			out.print(bean1.getDispLocnCode());
	}
}
catch(Exception e){
	e.printStackTrace();
}
finally{ // Added for NMC-JD-CRF-0063
	
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
