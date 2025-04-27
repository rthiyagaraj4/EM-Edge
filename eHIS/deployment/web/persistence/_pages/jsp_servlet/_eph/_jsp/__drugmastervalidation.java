package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import ePH.Common.*;
import ePH.DrugMasterBean;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __drugmastervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugMasterValidation.jsp", 1742369099732L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	try {
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );

		DrugMasterBean beanObj		= (DrugMasterBean)getBeanObject(bean_id, bean_name, request);
		beanObj.setLanguageId(locale);
		
		ArrayList	characteristics			=	new ArrayList();
		ArrayList	prescribing_det			=	new ArrayList();
		ArrayList	dispensing				=	new ArrayList();
		ArrayList	trade					=	new ArrayList();
		ArrayList	iv_char					=	new ArrayList();
		ArrayList	inventory				=	new ArrayList();
		ArrayList	generic					=	new ArrayList();
		ArrayList	external_db				=	new ArrayList();
		ArrayList	cautionTmp				=	new ArrayList();
		ArrayList	spl_instructionTmp		=	new ArrayList();
		ArrayList	Comp_Fluids				=	new ArrayList();
		ArrayList	ageGroup				=	new ArrayList();
		ArrayList sliding_scale			=	new ArrayList();
		HashMap		labelsTmp				=	null;
		HashMap		inventory_record		=	null;
		HashMap		trade_record			=	null;
		HashMap		generic_record			=	null;
		HashMap		dup_record				=	null;
		HashMap		age_record				=	null;
		HashMap		dup_age_record			=	null;

		String	trial_drug_yn					=	"";
		String	schedule						=	"";
		String	restricted_drug_yn				=	"";
		String	affects_pregnancy_yn			=	"";
		String	affects_breast_feeding_yn		=	"";
		String	affects_lab_results_yn			=	"";
		String	stability_reqd_yn				=	"";
		String	stability_hrs					=	"";
		String	pat_con_req						=	"";
		String  tdm_applicable_yn				=   "";
		String  var_order_appl_during_MAR_yn	=   "";
		String  app_for_comprx_yn				=   "";
		String  medn_admin_dtl_reqd_yn			=   "";
		String	drug_type						=	"";
		String	pres_base_uom					=	"";
		String	strength_value					=	"";
		String  strength_uom					=	"";
		String	strength_per_pres_uom			=	"";
		String	strength_per_value_pres_uom_qty		=	"";
		String	vol								=	"";
		String	qty								=	"";
		String	pres_catg_code					=	"";
		String  label_text_id                    =   "";
		String  label_text_1                     =   "";
		String  label_text_loc_lang              =   "";
		String	calc_dosg_by_freq_durn_yn		=	"";
		String	fract_dose_round_up_yn			=	"";
		String	stock_uom						=	"";
		String	content_in_pres_base_uom		=	"";
		String  disp_alt_form_yn				=	"";
		String	disp_multi_strength_yn			=	"";
		String	prn_doses_pres_prd_fill			=	"";
		String	prn_doses_cont_daily_fill		=	"";
		String	disp_auth_reqd_yn				=	"";
		String	disp_via_pres_only_yn			=	"";
		String	disp_against_damage_yn			=	"";
		String	caution_label_test_id_1			=	"";
		String	caution_label_test_id_2			=	"";
		String	spl_instr_label_text_id			=	"";
		String	allow_morethan_pres_qty_yn	=	"";
		String	spl_instr_label_text_id1		=	"";//added by senthil kumar on 15/4/2004
		String	how_to_take_text				=	"";
		String	how_to_take_text_local			=	"";
		String	iv_ingredient_yn				=	"";
		String	iv_fluid_yn						=	"";
		String	infuse_over_value				=	"";
		String  physical_form					=   "";
		String	item_code						=	"";
		String	item_desc						=	"";
		String	base_uom						=	"";
		String	select							=	"";
		String	trade_id						=	"";
		String  trade_name						=	"";
		String	stock_uom_code					=	"";
		String	stock_uom_desc					=	"";
		String	manufacturer_id					=	"";
		String  manufacturer_name				=	"";
		String	generic_id						=	"";
		String  generic_name					=	"";
		String  drug_class						=	"";
		String	disp_no							=	"";
		String  flag							=	"";
		String	bean_trade_id					=	"";
		String  bean_disp_no					=	"";
		String  bean_generic_id					=	"";
		String	bean_item_code					=	"";
		String  dup_trade_id					=	"";
		String	dup_generic_id					=	"";
		String  dup_disp_no						=	"";
		String calc_def_dosage_yn				=	"";
		String cyto_toxic_yn					=	"";
		String dflt_fluid    					=   "";
		String appl_piggy_back_yn				=   "";
		String appl_recn_fld_yn					=   "";
		String drug_information					=	"";
		String patient_education				=	"";
		String weight_record					=	"";
		String diag_record						=	"";
		String screen_note						=	"";
		String item_image_filename				=	"";
		String trade_image_filename				=	"";
		String FractionalDoseApplicable			=	"";
		String	age_group_code					=	"";
		String  short_desc						=	"";
		String	gender							=	"";
		String	max_age							=	"";
		String	age_unit						=	"";
		String  min_age							=	"";
		String	bean_agegroup_id				=	"";
		String  dup_agegroup_id					=	"";
		String	select_weight					=	"";
		String	ht_mand_yn					=	""; //added for Bru-HIMS-CRF-079 IN[029945]
		String	select_drug_appl				=	"";
		String	virification_required_yn		=	"";
		String  strEDLCodes						=	"";
		String  strEDLRemarks					=	"";
		String template_id		=	"";
		String fdaSearch						=	"";
		String fdaSearchText						=	"";
		String fda_FirstTrimester				=	"";
		String fda_SecondTrimester				=	"";
		String fda_ThridTrimester				=	"";
		String category_code					=	"";
		String print_label_based_on_qty_yn      =   "";  //Code Added For RUT-CRF-0067
		String	default_dosage_by				=	""; //Code Added For SKR-CRF-PHIS-003[IN028182]
		String	npb_drug						=	""; //code added for Bru-HIMS-CRF-070 [IN029935]
		String	drug_indication					=	""; //Code Added For  ML-BRU-CRF-072[Inc:29938]
		String	drug_eff_to_preg				=	""; //Code Added For RUT-CRF-0063 [IN:029601]
		String	drug_eff_to_preg_st				=	""; //Code Added For RUT-CRF-0063 [IN:029601]
		String	drug_eff_to_preg_tt				=	""; //Code Added For RUT-CRF-0063 [IN:029601]
		String	warn_reqd_yn_ft				=	"N"; //Code Added For RUT-CRF-0063 [IN:029601]
		String	warn_reqd_yn_st				=	"N"; //Code Added For RUT-CRF-0063 [IN:029601]
		String	warn_reqd_yn_tt				=	"N"; //Code Added For RUT-CRF-0063 [IN:029601]
		String  reissue_type_ind			=   ""; //Added for Bru-HIMS-CRF-405[IN 044830]  
		String  reissue_count_by_ind        =   ""; //Added for Bru-HIMS-CRF-405[IN 044830]
		String  reissue_count				=   ""; //Added for Bru-HIMS-CRF-405[IN 044830]
		String Add = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
		String patient_stock_required_yn			=	"N";//added for ghl-crf-0482
		String expiry_alert_days                  ="";//Added for TH-KW-CRF-0008
		String rest_anti_justform_yn			= "N";
		String rest_anti_justform_duration		= "";

		boolean dup_found						=	false;
		String default_dosage_by_yn				=""; //AAKH-CRF-089
		if(func_mode!= null && func_mode.equals("routePopulate")){
			String form_code			= (String) hash.get( "form_code" );
			String bean_route_code		= (String) hash.get( "bean_route_code" );
			//Hashtable record			=	null;
			out.println( "clearList('document') ; " ) ;
			ArrayList	route_values	=	beanObj.loadRoute(form_code); //Changed from HashMap to ArrayList for CRF RUT-CRF-0034.1[IN:037389]
			//Enumeration keys			=	route_values.keys(); //Commented for CRF RUT-CRF-0034.1[IN:037389]
			String	route_code					=	"";
			String	route_desc					=	"";
			String  route_color = "", fntColor="",backgrndColor =""; // added for CRF RUT-CRF-0034.1[IN:037389]
			//while(keys.hasMoreElements()){
			for(int i=0;i<route_values.size();i+=3){
				route_code	=	(String)route_values.get(i);
				route_desc	=	(String)route_values.get(i+1);
				route_color =   (String)route_values.get(i+2);	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color!= null && !route_color.equals("")){
					if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}
				else{
					fntColor= "";
					backgrndColor= "";
				}	// added for CRF RUT-CRF-0034.1[IN:037389]-End
				out.println("addList('"+route_code+"','"+route_desc+"','"+bean_route_code+"','"+fntColor+"','"+backgrndColor+"')");
			}
		}
		else if(func_mode != null && func_mode.equals("xcludeRecInCmb" ) ){
			String strCmbParms =  request.getParameter("cmbLoad");
			String strSelCmbVal = request.getParameter("selCmbVal");
			labelsTmp		= (HashMap) beanObj.loadLabels();
			cautionTmp		= (ArrayList) labelsTmp.get("caution");
			out.println("clearCaution();");

			for (int nCtr = 0; nCtr < cautionTmp.size(); nCtr++){
				HashMap dataTmp	 = new HashMap();
				dataTmp		= (HashMap) cautionTmp.get(nCtr);
				label_text_id       =(String)dataTmp.get("label_text_id")==null?"":(String)dataTmp.get("label_text_id");
				label_text_1        =(String)dataTmp.get("label_text_1")==null?"":(String)dataTmp.get("label_text_1");
				label_text_loc_lang =(String)dataTmp.get("label_text_1_loc_lang")==null?"":(String)dataTmp.get("label_text_1_loc_lang");
				label_text_1=label_text_1.replaceAll(" ","%20");
				label_text_1 = java.net.URLEncoder.encode(label_text_1,"UTF-8");
				label_text_1=label_text_1.replaceAll("%2520","%20");
				label_text_loc_lang=label_text_loc_lang.replaceAll(" ","%20");
				label_text_loc_lang = java.net.URLEncoder.encode(label_text_loc_lang,"UTF-8");
				label_text_loc_lang=label_text_loc_lang.replaceAll("%2520","%20");
				if(strCmbParms != null && strCmbParms.equals("caution_label_test_id_1") )	{
					out.println("addOption(\""+label_text_loc_lang+"\",\""+label_text_id+"\",\""+label_text_1+"\",\""+strSelCmbVal+"\",\"Caution\");");
				}
			}
		}
		else if(func_mode != null && func_mode.equals("xcludeRecInCmbSplInstr" ) ){
			String strCmbParms =  request.getParameter("cmbLoad");
			String strSelCmbVal = request.getParameter("selCmbVal");
			labelsTmp		= (HashMap) beanObj.loadLabels();
			spl_instructionTmp = (ArrayList) labelsTmp.get("spl_instruction");
			out.println("clearSplInstr();");
			for (int nCtr = 0; nCtr < spl_instructionTmp.size(); nCtr++){
				HashMap dataTmp	 = new HashMap();
				dataTmp		= (HashMap) spl_instructionTmp.get(nCtr);
				label_text_id       =(String)dataTmp.get("label_text_id")==null?"":(String)dataTmp.get("label_text_id");
				label_text_1        =(String)dataTmp.get("label_text_1")==null?"":(String)dataTmp.get("label_text_1");
				label_text_loc_lang =(String)dataTmp.get("label_text_1_loc_lang")==null?"":(String)dataTmp.get("label_text_1_loc_lang");
				label_text_1=label_text_1.replaceAll(" ","%20");
				label_text_1 = java.net.URLEncoder.encode(label_text_1,"UTF-8");
				label_text_1=label_text_1.replaceAll("%2520","%20");
				label_text_loc_lang=label_text_loc_lang.replaceAll(" ","%20");
				label_text_loc_lang = java.net.URLEncoder.encode(label_text_loc_lang,"UTF-8");
				label_text_loc_lang=label_text_loc_lang.replaceAll("%2520","%20");
				
				if(strCmbParms != null && strCmbParms.equals("spl_instr_label_text_id") ){
					out.println("addOption(\""+label_text_loc_lang+"\",\""+label_text_id+"\",\""+label_text_1+"\",\""+strSelCmbVal+"\",\"SplInstr\");");
				}
			}
		}
		else if (func_mode!= null && func_mode.equals("changeLableText")){
			// We remove the selected id in label text1 from label text 2
			String labeltextid=(String)request.getParameter("labeltextid");	out.println("tmpobj=parent.parent.f_query_add_mod.f_tab_detail.f_detail.document.drugMasterAddModifyForm.caution_label_test_id_2;");
			out.println("clearData(tmpobj);");

			HashMap labels				= (HashMap)beanObj.loadLabels();
			ArrayList	caution			= (ArrayList)labels.get("caution");
			out.println("addData('','-------------------------------Select--------------------------------',tmpobj);");
			for(int i=0;i<caution.size();i++){
				HashMap data = new HashMap();
				data = (HashMap)caution.get(i);
				if ( (labeltextid!=null) && (!labeltextid.equals((String)data.get("label_text_id")))){
					out.println("addData(\""+data.get("label_text_id")+"\",\""+data.get("label_text_1")+"\",tmpobj);");
					out.println("addData(\""+data.get("label_text_id")+"\",\""+data.get("label_text_2")+"\",tmpobj);");
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("packSize")){
			String uom_code			= (String) hash.get( "uom_code" );
			String eqvl_uom_code	= (String) hash.get( "eqvl_uom_code" );
			String sor_mode			= (String) hash.get( "sor_mode" );

			String eqvl_value=beanObj.getEqvlValue(uom_code,eqvl_uom_code);
			out.println("assignPackSize('"+eqvl_value+"','"+sor_mode+"')");

		}
		else if(func_mode!= null && func_mode.equals("loadStockUnit")) {
			String base_unit			= (String) hash.get( "base_unit" );
			ArrayList	stock_unit		= beanObj.loadStockUnit(base_unit);
			out.println("clearStockList()");

			for(int i=0; i<stock_unit.size(); i+=2) {
				String code	=	(String)stock_unit.get(i);
				String desc	=	(String)stock_unit.get(i+1);
				out.println("addStockList('"+code+"','"+desc+"')");
			}
		}
		else if(func_mode!= null && func_mode.equals("inventoryPackSize")){
			String uom_code			= (String) hash.get( "uom_code" );
			String eqvl_uom_code	= (String) hash.get( "eqvl_uom_code" );
			String eqvl_value		=beanObj.getEqvlValue(uom_code,eqvl_uom_code);

			out.println("assignInventoryPackSize('"+eqvl_value+"')");
		}
		else if(func_mode!= null && func_mode.equals("getPackSize")){
			out.println("called");
			String uom_code			= (String) hash.get( "uom_code" );
			String uom_desc			= (String) hash.get( "uom_desc" );
			String eqvl_uom_code	= (String) hash.get( "eqvl_uom_code" );
			String strength			= (String) hash.get( "strength" );
			String itm_code		= (String) hash.get( "item_code" );
			String itm_desc		= (String) hash.get( "item_desc" );
			ArrayList check	=beanObj.makeInventoryRecord(uom_code,uom_desc,eqvl_uom_code,strength,itm_code,itm_desc);
			out.println("check size is"+check.size());
		}
		else if(func_mode!= null && func_mode.equals("checkOrderable")){
			String drug			= (String) hash.get( "drug_code" );
			out.println("setOrderableTab('"+beanObj.checkOrderable(drug)+"')");
		}

		else if(func_mode!= null && func_mode.equals("characteristics_tab")){

			drug_type							= (String) hash.get( "drug_type" );
			schedule							= (String) hash.get( "schedule" );
			restricted_drug_yn					= (String) hash.get( "restricted_drug_yn" );
			trial_drug_yn						= (String) hash.get( "trial_drug_yn" );
			affects_pregnancy_yn				= (String) hash.get( "affects_pregnancy_yn" );
			affects_breast_feeding_yn			= (String) hash.get( "affects_breast_feeding_yn" );
			affects_lab_results_yn				= (String) hash.get( "affects_lab_results_yn" );
			stability_reqd_yn					= (String) hash.get( "stability_reqd_yn" );
			stability_hrs						= (String) hash.get( "stability_hrs" );
			pat_con_req							= (String) hash.get( "pat_con_req" );
			tdm_applicable_yn					= (String) hash.get( "tdm_applicable_yn" );
			var_order_appl_during_MAR_yn		= (String) hash.get( "var_order_appl_during_MAR_yn");
			app_for_comprx_yn                   = (String) hash.get("app_for_comprx_yn");
			medn_admin_dtl_reqd_yn              = (String) hash.get("medn_admin_dtl_reqd_yn");
			drug_information			        = (String) hash.get("druginfo_text");
			patient_education		            = (String) hash.get("patientedu_text");
			weight_record						= (String) hash.get("Weight_record");
			diag_record 						= (String) hash.get("diag_recording");
			screen_note 						= (String) hash.get("screen_note");
			item_image_filename 				= (String) hash.get("item_image_filename");
			strEDLCodes							= (String) hash.get("EDLClassCodes");
			strEDLRemarks						= (String) hash.get("EDLClassRemarks");
			fdaSearch							= (String) hash.get("fdaCategorySearchCode");
			fdaSearchText						= (String) hash.get("fdaSearch");
			fda_FirstTrimester					= (String) hash.get("fda_FirstTrimester");
			fda_SecondTrimester					= (String) hash.get("fda_SecondTrimester");
			fda_ThridTrimester					= (String) hash.get("fda_ThridTrimester");
			npb_drug							= (String) hash.get("npb_drug");//code added for Bru-HIMS-CRF-070 [IN029935]
			drug_eff_to_preg                    = (String) hash.get("DrugEffectToPregnancy"); //code added for  RUT-CRF-0063 [IN:029601]
			drug_eff_to_preg_st                 = (String) hash.get("DrugEffectToPregnancyforsecondtrim"); //code added for  RUT-CRF-0063 [IN:029601]
			drug_eff_to_preg_tt                 = (String) hash.get("DrugEffectToPregnancyforthirdtrim"); //code added for  RUT-CRF-0063 [IN:029601]
			warn_reqd_yn_ft                     = (String) hash.get("warn_reqd_yn_ft"); //code added for  RUT-CRF-0063 [IN:029601]
			warn_reqd_yn_st                     = (String) hash.get("warn_reqd_yn_st"); //code added for  RUT-CRF-0063 [IN:029601]
			warn_reqd_yn_tt                     = (String) hash.get("warn_reqd_yn_tt"); //code added for  RUT-CRF-0063 [IN:029601]
			patient_stock_required_yn		=	(String) hash.get("patient_stock_required");//added for ghl-crf-0482
			expiry_alert_days               =	(String) hash.get("expiry_alert_days");//Added for TH-KW-CRF-0008
			rest_anti_justform_yn				= (String) hash.get("rest_anti_justform_yn");//Added for KDAH-CRF-0610
			rest_anti_justform_duration			= (String) hash.get("rest_anti_justform_duration");//Added for KDAH-CRF-0610	
			
					fdaSearch = affects_pregnancy_yn.equals("Y") ? fdaSearch : "";
			characteristics.add(drug_type					);  //0
			characteristics.add(schedule					);  //1
			characteristics.add(restricted_drug_yn			);  //2
			characteristics.add(trial_drug_yn				);  //3
			characteristics.add(affects_pregnancy_yn		);  //4
			characteristics.add(affects_breast_feeding_yn	);  //5
			characteristics.add(affects_lab_results_yn		);  //6
			characteristics.add(stability_reqd_yn			);  //7
			characteristics.add(stability_hrs				);  //8
			characteristics.add(pat_con_req					);  //9
			characteristics.add(tdm_applicable_yn			);  //10
			characteristics.add(var_order_appl_during_MAR_yn);  //11
			characteristics.add(app_for_comprx_yn			);  //12
			characteristics.add(medn_admin_dtl_reqd_yn		);  //13
			characteristics.add(drug_information			);  //14
			characteristics.add(patient_education			);  //15
			characteristics.add(weight_record				);  //16
			characteristics.add(diag_record					);  //17
			characteristics.add(screen_note					);  //18
			characteristics.add(item_image_filename			);  //19
			characteristics.add(strEDLCodes					);  //20
			characteristics.add(strEDLRemarks				);  //21
			characteristics.add(fdaSearch					);  //22
			characteristics.add(fda_FirstTrimester			);  //23
			characteristics.add(fda_SecondTrimester			);  //24
			characteristics.add(fda_ThridTrimester			);  //25
			characteristics.add(fdaSearchText				);  //26
			characteristics.add(npb_drug					);  //27 --code added for Bru-HIMS-CRF-070 [IN029935]
			characteristics.add(drug_eff_to_preg			);  //28 --code added for  RUT-CRF-0063 [IN:029601]
			characteristics.add(drug_eff_to_preg_st			);  //29 --code added for  RUT-CRF-0063 [IN:029601]
			characteristics.add(drug_eff_to_preg_tt			);  //30 --code added for  RUT-CRF-0063 [IN:029601]
			characteristics.add(warn_reqd_yn_ft			    );  //31 --code added for  RUT-CRF-0063 [IN:029601]
			characteristics.add(warn_reqd_yn_st			    );  //32 --code added for  RUT-CRF-0063 [IN:029601]
			characteristics.add(warn_reqd_yn_tt			    );  //33 --code added for  RUT-CRF-0063 [IN:029601]
			characteristics.add(patient_stock_required_yn); //34 added for ghl-crf-0482
			characteristics.add(expiry_alert_days);//Added for TH-KW-CRF-0008

			characteristics.add(rest_anti_justform_yn);//Added for KDAH-CRF-0610
			characteristics.add(rest_anti_justform_duration);//37 Added for KDAH-CRF-0610

			beanObj.setCharacteristics(	characteristics	);
		}
		else if(func_mode!= null && func_mode.equals("prescribingdet_tab")){

			pres_base_uom					= (String) hash.get( "pres_base_uom" );
			calc_dosg_by_freq_durn_yn		= (String) hash.get( "calc_dosg_by_freq_durn_yn" );
			strength_value					= (String) hash.get( "strength_value" );
			strength_uom					= (String) hash.get( "strength_uom" );
			strength_per_pres_uom			= (String) hash.get( "strength_per_pres_uom" );
			strength_per_value_pres_uom_qty		= (String) hash.get( "strength_per_value_pres_uom_qty" );
			pres_catg_code					= (String) hash.get( "pres_catg_code" );
			vol								= (String) hash.get( "strength_per_pres_uom_qty" );
			qty								= (String) hash.get( "strength_per_value_pres_uom" );
			stock_uom						= (String) hash.get( "stock_uom" );
			content_in_pres_base_uom		= (String) hash.get( "content_in_pres_base_uom" );
			calc_def_dosage_yn				= (String) hash.get( "calc_def_dosage_yn" );
			default_dosage_by_yn				=(String)hash.get("default_dosage_by_yn");//AAKH-CRF-089  
			prescribing_det.add(pres_base_uom				);
			prescribing_det.add(calc_dosg_by_freq_durn_yn	);
			prescribing_det.add(strength_value				);
			prescribing_det.add(strength_uom				);
			prescribing_det.add(strength_per_pres_uom		);
			prescribing_det.add(strength_per_value_pres_uom_qty	);
			prescribing_det.add(pres_catg_code				);
			prescribing_det.add(vol							);
			prescribing_det.add(qty							);

			// Added by raghunath
			prescribing_det.add(stock_uom					);
			prescribing_det.add(content_in_pres_base_uom	);
			// ends here..
			//Added for Cyto
			prescribing_det.add(calc_def_dosage_yn			);
			prescribing_det.add(default_dosage_by_yn			);//AAKH-CRF-089
			// ends for Cyto
			//	out.println("alert('"+prescribing_det+"')");
			dispensing = beanObj.getDispensing();
			if(calc_dosg_by_freq_durn_yn==null || !calc_dosg_by_freq_durn_yn.equals("Y")){
				if(dispensing!=null & dispensing.size()>0)//added for GDOH-SCF-0014[IN:048882]
					dispensing.set(18,"");
				beanObj.setDispensing(dispensing);
			}
			beanObj.setPrescription(prescribing_det	);

		}
		else if(func_mode!= null && func_mode.equals("dispensingdet_tab")){
		
			fract_dose_round_up_yn		= (String)hash.get("fract_dose_round_up_yn")==null?"N":(String) hash.get("fract_dose_round_up_yn");
			/*
			//		Commented by raghunath to move from dispensing tab to prescription tab
					stock_uom					= (String) hash.get( "stock_uom" );
					content_in_pres_base_uom	= (String) hash.get( "content_in_pres_base_uom" );
			*/
			disp_alt_form_yn			= (String) hash.get( "disp_by_alt_form_yn" );
			disp_multi_strength_yn		= (String) hash.get( "disp_multi_strength_yn" );
			prn_doses_pres_prd_fill		= (String) hash.get( "prn_doses_pres_prd_fill" );
			prn_doses_cont_daily_fill	= (String) hash.get( "prn_doses_cont_daily_fill" );
			disp_auth_reqd_yn			= (String) hash.get( "disp_auth_reqd_yn" );
			disp_via_pres_only_yn		= (String) hash.get( "disp_via_pres_only_yn" );
			disp_against_damage_yn		= (String) hash.get( "disp_against_damage_yn" );
			caution_label_test_id_1		= (String) hash.get( "caution_label_test_id_1" );
			caution_label_test_id_2		= (String) hash.get( "caution_label_test_id_2" );
			spl_instr_label_text_id		= (String) hash.get( "spl_instr_label_text_id" );
			how_to_take_text			= (String) hash.get( "how_to_take_text" );
			virification_required_yn	= (String) hash.get( "virification_required_yn" );
			print_label_based_on_qty_yn	= (String) hash.get( "print_label_based_on_qty_yn" ); //Code Added  For RUT-CRF-0067 Start
			allow_morethan_pres_qty_yn	=	(String) hash.get("allow_morethan_pres_qty_yn")==null?"N":(String) hash.get("allow_morethan_pres_qty_yn");
			//Added by Anuradha on 11/2/2006
			how_to_take_text_local		= (String) hash.get( "how_to_take_text_local" );
			//Added by senthil kumar on 15/4/2004
			spl_instr_label_text_id1		= (String) hash.get( "spl_instr_label_text_id1" );
			FractionalDoseApplicable		= (String)hash.get("FractionalDoseApplicable")==null?"N":(String) hash.get("FractionalDoseApplicable");
			default_dosage_by			= (String) hash.get("default_dosage_by" );//Code Added For SKR-CRF-PHIS-003[IN028182]
			drug_indication				= (String) hash.get("drug_ind" );//Code Added For  ML-BRU-CRF-072[Inc:29938]
			if(disp_against_damage_yn.equals("Y")){//Added if condition for Bru-HIMS-CRF-405[IN 044830]
				reissue_type_ind			= (String) hash.get( "reissue_type_ind" );
				reissue_count_by_ind		= (String) hash.get( "reissue_count_by_ind" );
				reissue_count				= (String) hash.get( "reissue_count" );
			}
			dispensing.add(fract_dose_round_up_yn	);//0
			dispensing.add(disp_alt_form_yn	);//1
			dispensing.add(disp_multi_strength_yn	);//2
			dispensing.add(prn_doses_pres_prd_fill	);//3
			dispensing.add(prn_doses_cont_daily_fill);//4
			dispensing.add(disp_auth_reqd_yn		);//5
			dispensing.add(disp_via_pres_only_yn	);//6
			dispensing.add(disp_against_damage_yn	);//7
			dispensing.add(caution_label_test_id_1	);//8
			dispensing.add(caution_label_test_id_2	);//9
			dispensing.add(spl_instr_label_text_id	);//10
			dispensing.add(how_to_take_text			);//11
			dispensing.add(how_to_take_text_local			);//12
			dispensing.add(spl_instr_label_text_id1);//13
			dispensing.add(FractionalDoseApplicable);//14
			dispensing.add(virification_required_yn);//15
			dispensing.add(allow_morethan_pres_qty_yn);//16
			dispensing.add(print_label_based_on_qty_yn);//17 -->Code Added For RUT-CRF-0067 
			dispensing.add(default_dosage_by);//18 --> Code Added For SKR-CRF-PHIS-003[IN028182]
			dispensing.add(drug_indication);//19 --> Code Added For ML-BRU-CRF-072[Inc:29938]
			dispensing.add(reissue_type_ind);//20 -->Added for Bru-HIMS-CRF-405[IN 044830]
			dispensing.add(reissue_count_by_ind);//21 -->Added for Bru-HIMS-CRF-405[IN 044830]
			dispensing.add(reissue_count);//22 -->Added for Bru-HIMS-CRF-405[IN 044830]
			beanObj.setDispensing(dispensing);
		}
		else if(func_mode!= null && func_mode.equals("ivchar_tab")){

			iv_ingredient_yn			= (String) hash.get( "iv_ingredient_yn" );
			iv_fluid_yn					= (String) hash.get( "iv_fluid_yn" );
			infuse_over_value			= (String) hash.get( "infuse_over_value" );
		//	infuse_over_value_mins	= (String) hash.get("infuse_over_value_mins");
			//infuse_over_durn_type		= (String) hash.get( "infuse_over_durn_type" );
			physical_form				= (String) hash.get( "physical_form" );
			cyto_toxic_yn				= (String) hash.get( "cyto_toxic_yn" );	
			dflt_fluid					= (String) hash.get( "dflt_fluid");
			appl_piggy_back_yn			= (String) hash.get("appl_piggy_back_yn");
			appl_recn_fld_yn			= (String) hash.get("appl_recn_fld_yn");
			iv_char.add(iv_ingredient_yn		);
			iv_char.add(iv_fluid_yn				);
			iv_char.add(infuse_over_value		);
			iv_char.add("H"	);
			iv_char.add(physical_form			);
			iv_char.add(cyto_toxic_yn			);
			iv_char.add(dflt_fluid				);
			iv_char.add(appl_piggy_back_yn		);
			iv_char.add(appl_recn_fld_yn		);
			//iv_char.add(infuse_over_value_mins	);
			beanObj.setIVChar(iv_char);
		}
		else if(func_mode!= null && func_mode.equals("external_tab")){

			//external_drug_id			= (String) hash.get( "external_drug_id" );
			//external_db.add(external_drug_id		);
			//beanObj.setExternalDB(external_db);
			//out.println("value"+beanObj.getExternalDB());
			String fdb_text=(String) hash.get( "FDB_Text" );
			//String mims_text= (String) hash.get( "MIMS_Text" );
			if(((fdb_text).length())!=0){
				external_db.add((String) hash.get( "product_id1" ));
				external_db.add((String) hash.get( "FDB_Text" ));
				external_db.add((String) hash.get( "eff_status" ));
				external_db.add((String) hash.get( "db_action1" ));	
				external_db.add((String) hash.get( "external_db_legend" ));
			}
			
			beanObj.setExternalDB(external_db);
		}
		else if(func_mode!= null && func_mode.equals("inventory_tab")){
			HashMap record		=	null;
			inventory			=	beanObj.getInventory();

			if( (String) hash.get("flag0")==null)	{
				item_code			= (String) hash.get( "item_code" );
				item_desc			= (String) hash.get( "item_desc" );
				stock_uom_code		= (String) hash.get( "stock_uom_code" );
				stock_uom_desc		= (String) hash.get( "stock_uom_desc" );
				base_uom			= (String) hash.get( "content_in_pres_base_uom" );
				strength_uom		= (String) hash.get( "content_in_strength_uom" );
				flag				= (String) hash.get( "flag" );
				if(flag.equals(""))
					flag		=	"I";
				select				=	"Y";

					/***Check Duplicate Record***/
				for(int k=0; k<inventory.size(); k++)	{
					record			=	(HashMap) inventory.get(k);
					bean_item_code	=	(String)record.get("item_code");

					if(bean_item_code.equals(item_code)){
						dup_found	=	true;
						break;
					}
				}
					/**Duplication Check Ends****/

				if(!dup_found)	{
					inventory_record	=	new HashMap();
					inventory_record.put("item_code",item_code);
					inventory_record.put("item_desc",item_desc);
					inventory_record.put("stock_uom_code",stock_uom_code);
					inventory_record.put("stock_uom_desc",stock_uom_desc);
					inventory_record.put("base_uom",base_uom);
					inventory_record.put("strength_uom",strength_uom);
					inventory_record.put("select",select);
					inventory_record.put("flag",flag);

					inventory.add(inventory_record);
					beanObj.setInventory(inventory);
				}

				if(!dup_found)
					out.println("refreshParentTab('"+func_mode+"')");
				else	{
					out.println("displayDuplicate('"+func_mode+"')");
				}

			}
			else{
				int i	=	0;

				while( (String) hash.get("flag"+i)!=null)	{
					select				= (String)hash.get("select"+i);
					record	=	(HashMap)inventory.get(i);
					record.put("select",select);
					i++;
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("trade_tab")){
			trade				=	beanObj.getTradeNames();
			HashMap record		=	null;

			if( (String) hash.get("flag0")==null)	{
					if(hash.containsKey("add_butt")){
					if( ((String)hash.get("add_butt")).equals(Add) )	{
						try{
							trade_id			= (String) hash.get( "trade_id");
							trade_name			= (String) hash.get( "trade_name");
							manufacturer_id		= (String) hash.get( "manufacturer_id");
							manufacturer_name	= (String) hash.get( "manufacturer_name");
							disp_no				= (String) hash.get( "disp_seq_no");
							flag				= (String) hash.get( "flag");
							trade_image_filename = (String) hash.get( "trade_image_filename");
						}
						catch(Exception e){
							e.printStackTrace();
						}
						if(flag.equals("")){
							flag	=	"I";
						}
						select				=	"Y";
			  
					/***Check Duplicate Record***/
						for(int k=0; k<trade.size(); k++)	{
							record			=	(HashMap) trade.get(k);
							bean_trade_id	=	(String)record.get("trade_id");
							bean_disp_no	=	(String)record.get("disp_seq_no");
							if(bean_trade_id.equals(trade_id) || bean_disp_no.equals(disp_no)){
								dup_found	=	true;
								break;
							}
						}
						/**Duplication Check Ends****/

						if(!dup_found)	{
							
							trade_record	=	new HashMap();
							trade_record.put("trade_id",trade_id);
							trade_record.put("trade_name",trade_name);
							trade_record.put("manufacturer_id",manufacturer_id);
							trade_record.put("manufacturer_name",manufacturer_name);
							trade_record.put("disp_seq_no",disp_no);
							trade_record.put("select",select);
							trade_record.put("flag",flag);
							trade_record.put("trade_image_filename",trade_image_filename);
				
							trade.add(trade_record);
							beanObj.setTradeNames(trade);
						}
					}	

					else{
				
						trade_id			= (String) hash.get( "trade_id");
						disp_no				= (String) hash.get( "disp_seq_no");
						flag				= (String) hash.get( "flag");
						trade_image_filename = (String) hash.get( "trade_image_filename");
			
						if(flag.equals("DB"))	
							flag	=	"U";
		
				/***chk Duplicate Display seq no in all other items ***/
						for(int k=0; k<trade.size(); k++)	{
							dup_record		=	(HashMap) trade.get(k);
							dup_trade_id	=	(String)dup_record.get("trade_id");
							dup_disp_no		=	(String)dup_record.get("disp_seq_no");
							if(!dup_trade_id.equals(trade_id) && dup_disp_no.equals(disp_no)){
								dup_found	=	true;
								break;
							}
						}

				/***Duplicate disp seq no ends*****/
						if(!dup_found)	{
							for(int i=0; i<trade.size(); i++)	{
								record	=	new HashMap();
								record	=	(HashMap)trade.get(i);
								bean_trade_id	=	(String)record.get("trade_id");
								if(bean_trade_id.equals(trade_id)){
									record.put("disp_seq_no",disp_no);
									record.put("flag",flag);
									record.put("trade_image_filename",trade_image_filename);
								}
							}
						}
					}

				}
				if(!dup_found)
					out.println("refreshParentTab('"+func_mode+"')");
				else	{
					out.println("displayDuplicate('"+func_mode+"')");
				}

			}
			else{

				int i	=	0;
				//HashMap record	=	null;

				while( (String) hash.get("flag"+i)!=null)	{
					disp_no				= (String) hash.get( "disp_seq_no"+i);
					flag				= (String) hash.get( "flag"+i);
					select				= (String)hash.get("select"+i);
					String select1 = (String) hash.get("select_chk1"+i);
					
					record	=	(HashMap)trade.get(i);
					record.put("disp_seq_no",disp_no);
					record.put("flag",flag);
					record.put("select",select);
					record.put("eff_status",select1);
					i++;

				
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("generic_tab")){
			HashMap record		=	null;
			generic				=	beanObj.getGenericNames();	
			dup_found = false;
			String tmpFlag = "";
			if( (String) hash.get("flag0")==null)	{
				if( ((String)hash.get("add_butt")).equals(Add) )	{
					generic_id			= (String) hash.get( "generic_id");
					drug_class			=	beanObj.getDrugClassName(generic_id);
					generic_name		= (String) hash.get( "generic_name");
					disp_no				= (String) hash.get( "disp_seq_no");
					flag				= (String) hash.get( "flag");
					if(flag.equals(""))	flag	=	"I";
						select				=	"Y";
				/***Check Duplicate Record***/
					for(int k=0; k<generic.size(); k++)	{
						record			=	(HashMap) generic.get(k);
						bean_generic_id	=	(String)record.get("generic_id");
						bean_disp_no	=	(String)record.get("disp_seq_no");
						tmpFlag	=	(String)record.get("flag");
						if((bean_generic_id.equals(generic_id) || bean_disp_no.equals(disp_no)) && !tmpFlag.equals("D")){
							dup_found	=	true;
							break;
						}
					}

				/**Duplication Check Ends****/
					if(!dup_found)	{
						generic_record	=	new HashMap();
						generic_record.put("generic_id",generic_id);
						generic_record.put("generic_name",generic_name);
						generic_record.put("drug_class",drug_class);
						generic_record.put("disp_seq_no",disp_no);
						generic_record.put("select",select);
						generic_record.put("flag",flag);
						generic.add(generic_record);
						beanObj.setGenericNames(generic);
					}
				}
				else{
					generic_id			= (String) hash.get( "generic_id");
					disp_no				= (String) hash.get( "disp_seq_no");
					flag				= (String) hash.get( "flag");
					if(flag.equals("DB"))	flag	=	"U";

				/***chk Duplicate Display seq no in all other items ***/
						for(int k=0; k<generic.size(); k++)	{
							dup_record		=	(HashMap) generic.get(k);
							dup_generic_id	=	(String)dup_record.get("generic_id");
							dup_disp_no		=	(String)dup_record.get("disp_seq_no");
							if(!dup_generic_id.equals(generic_id) && dup_disp_no.equals(disp_no)){
								dup_found	=	true;
								break;
							}
						}

				/***Duplicate disp seq no ends*****/

					if(!dup_found)	{
						for(int i=0; i<generic.size(); i++)	{
							record	=	(HashMap)generic.get(i);
							bean_generic_id	=	(String)record.get("generic_id");
							if(bean_generic_id.equals(generic_id)){
								record.put("disp_seq_no",disp_no);
								record.put("flag",flag);
							}
						}
					}
				}

				if(!dup_found)
					out.println("refreshParentTab('"+func_mode+"')");
				else	{
					out.println("displayDuplicate('"+func_mode+"')");
				}
			}
			else{		
				int i	=	0;
				String gen_id="";
				while((String) hash.get("flag"+i)!=null)	
				{
					gen_id				= (String) hash.get( "generic_id"+i);
					disp_no				= (String) hash.get( "disp_seq_no"+i);
					flag				= (String) hash.get( "flag"+i);
					select				= (String) hash.get( "select"+i);	
					int k;
					for(k=0; k<generic.size(); k++)	
					{						
							record		=	(HashMap) generic.get(k);
							if(((String)record.get("generic_id")).equals(gen_id))
								break;
					}
					//cord	=	(HashMap)generic.get(i);
					if(select==null||select.equals("Y"))
					{
					record.put("disp_seq_no",disp_no);
					record.put("flag",flag);
					record.put("select",select);
					}
					else
					{
						generic.remove(k);
					}
					i++;
				}
			}

		}else if(func_mode!= null && func_mode.equals("getDrugClass")){

			String DrugClass=beanObj.getDrugClass((String)hash.get( "generic_id" ));
			if(DrugClass==null) DrugClass="";
			out.println("setDrugClass('"+DrugClass+"')");

		}
		else if(func_mode!= null && func_mode.equals("test")){

			ArrayList	drugmastermain			=	beanObj.getDrugmastermain();
			ArrayList	characteristics_test	=	beanObj.getCharacteristics();
			ArrayList	pres					=	beanObj.getPrescription();
			ArrayList	dispense				=	beanObj.getDispensing();
			ArrayList	ivchar					=	beanObj.getIVChar();
			ArrayList	inven_test				=	beanObj.getInventory();
			ArrayList	trade_test				=	beanObj.getTradeNames();
			ArrayList	gene_test				=	beanObj.getGenericNames();

			out.print(drugmastermain);
			out.print(characteristics_test);
			out.print(pres);
			out.print(dispense);
			out.print(ivchar);
			out.print(inven_test);
			out.print(trade_test);
			out.print(gene_test);

		//out.println("inside");
		}
		else if(func_mode!= null && func_mode.equals("searchManufacturer")){

			String tradeId				= (String) hash.get( "code" );
			out.println("setManufacturerName('"+java.net.URLEncoder.encode(beanObj.getManufacturerName(tradeId))+"');");
			//out.println("setManufacturerName('"+beanObj.getManufacturerName(tradeId)+"');");//8/12/08
		}
		else if(func_mode!= null && func_mode.equals("searchItem")){
			String itemCode				= (String) hash.get( "code" );
			out.println("setItemDescription('"+java.net.URLEncoder.encode(beanObj.getItemDescription(itemCode),"UTF-8")+"');");
		}
		else if(func_mode!= null && func_mode.equals("searchForInventoryItem")){
			String itemCode				= (String) hash.get( "code" );
			out.println("setStockDescription('"+java.net.URLEncoder.encode(beanObj.getItemDescription(itemCode),"UTF-8")+"');");
		}
		else if(func_mode!= null && func_mode.equals("drug_code")){

			String drugCode				= (String) hash.get( "drug_code" );
			boolean result				= beanObj.validateDrugCode(drugCode);
			out.println("drugCodeResult('"+result+"');");

		}
		else if(func_mode!= null && func_mode.equals("delete")){
			String	link					=	(String)hash.get("link");
			boolean result					=	false;

			if(link.equals("generic_tab"))	{
				String genericId				= (String) hash.get( "code" );
				result							= beanObj.updateGeneric(genericId);
			}
			else if(link.equals("trade_tab")){
				String tradeId				= (String) hash.get( "code" );
				result						= beanObj.updateTrade(tradeId);
			}
			else if(link.equals("inventory_tab")){
				String itemCode				= (String) hash.get( "code" );
				result						= beanObj.updateInventory(itemCode);
			}
			if(result)
				out.println("refreshParentTab('"+link+"')");
		}
		else if(func_mode!= null && func_mode.equals("toolBar"))  {
		 //  out.println("alert(\"toolBarString:"+request+"\")" ) ;
		   String toolBarString = request.getQueryString() ;
		 //  out.println("alert(\"Before:"+toolBarString+"\")") ;
		   session.removeValue("queryString") ;
		   session.putValue( "queryString", toolBarString ) ;
		  // out.println("alert(\"After:"+session.getValue("queryString")+"\")") ;
		}
		else if(func_mode!= null && func_mode.equals("getItemCodeLink"))  {
			String drugCode				= (String) hash.get( "drug_code" );
			String drug_code_and_item				= (String) hash.get( "drug_code_and_item" );
			item_code = (String)beanObj.getItemCode(drugCode);
			if(item_code == null || item_code.equals("")){
				out.println("alertDrugItemLink('"+drug_code_and_item+"');");
			}
			else{
				out.println("	checkItemCode1();");
			}
		}
		else if(func_mode!= null && func_mode.equals("compatible")){
			String comps			=	(String)hash.get("CompFluids");
			StringTokenizer	 vals	=	new StringTokenizer(comps,"+");

			while(vals.hasMoreTokens()){
				Comp_Fluids.add((String)vals.nextToken());
			}
			beanObj.setCompFluids(Comp_Fluids);
		}
		else if(func_mode!= null && func_mode.equals("checkCompFldStatus")){
			String fluid_code		= (String)hash.get("fluid_code");
			boolean cmpFldStatus		= (boolean)beanObj.getCompFldStatus(fluid_code);
			
			if(cmpFldStatus){
				out.println("cmpFldWarning('"+fluid_code+"');");
			}
		}
		else if(func_mode!= null && func_mode.equals("changeCmpFldStatus")){
			String fluid_code		= (String)hash.get("fluid_code");
			boolean cmpFldUpdateFld = (boolean)beanObj.changeCompFldStatus(fluid_code);

			if(cmpFldUpdateFld){
				out.println("setcmpFldUpdateFld('"+cmpFldUpdateFld+"');");
			}
		}
		else if(func_mode!= null && func_mode.equals("selected_age_group")){
			ArrayList age_group=	beanObj.getAgeGroupID();
		
			String selected_age=(String)hash.get("selected_age");
			for(int i=0;i<age_group.size();i++){
				HashMap data = new HashMap();
				data = (HashMap)age_group.get(i);
				String age_group_code1=(String)data.get("age_group_code");
				if(age_group_code1.equals(selected_age) )	{
				
				   age_group_code1	=(String)(data.get("age_group_code"));
					String short_desc1		=(String)(data.get("short_desc"));
					String min_age1			=(String)(data.get("min_age"));
					String max_age1			=(String)(data.get("max_age"));
					String age_unit1		=(String)(data.get("age_unit"));
					String gender1			=(String)(data.get("gender"));
					out.println("setAgefields('"+age_group_code1+"','"+short_desc1+"','"+min_age1+"','"+max_age1+"','"+age_unit1+"','"+gender1+"');");
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("weightrecording_tab")){
			ageGroup				=	beanObj.getAgeGroups();
			HashMap record		=	null;
			if( (String) hash.get("flag0")==null)	{
				if(hash.containsKey("add_butt")){
					if(((String)hash.get( "age_group_code")).length()!=0){
						if( ((String)hash.get("add_butt")).equals(Add) ){
							try{
								age_group_code			= (String) hash.get( "age_group_code");
								short_desc				= (String) hash.get( "short_desc");
								gender					= (String) hash.get( "gender");
								max_age					= (String) hash.get( "max_age");
								age_unit				= (String) hash.get( "age_unit");
								flag					= (String) hash.get( "flag");
								min_age				    = (String) hash.get( "min_age");
							}
							catch(Exception e){
								e.printStackTrace();
							}
							if(flag.equals(""))
								flag	=	"I";

								select				=	"Y";
								select_weight		=	"N";
								select_drug_appl	=	"Y";
								ht_mand_yn	=	"N"; //added for Bru-HIMS-CRF-079 IN[029945]
				
						/***Check Duplicate Record***/
					
							if(ageGroup!=null && ageGroup.size()!=0)	{
								for(int k=0; k<ageGroup.size(); k++)	{
									record			=	(HashMap) ageGroup.get(k);
									bean_agegroup_id	=	(String)record.get("age_group_code");
									if(bean_agegroup_id.equals(age_group_code)){
										dup_found	=	true;
										break;
									}
								}
							}
							/**Duplication Check Ends****/

							if(!dup_found)	{
								age_record	=	new HashMap();
								age_record.put("age_group_code",age_group_code);
								age_record.put("short_desc",short_desc);
								age_record.put("gender",gender);
								age_record.put("max_age",max_age);
								age_record.put("age_unit",age_unit);
								age_record.put("select",select);
								age_record.put("flag",flag);
								age_record.put("min_age",min_age);
								age_record.put("select_weight",select_weight);
								age_record.put("select_drug_appl",select_drug_appl);
								age_record.put("ht_mand_yn",ht_mand_yn); // added for Bru-HIMS-CRF-079 IN[029945]
								ageGroup.add(age_record);
								beanObj.setAgeGroups(ageGroup);
							}
						}
						else{			
							age_group_code			= (String) hash.get( "age_group_code");
								flag				= (String) hash.get( "flag");
						
							if(flag.equals("DB"))	
								flag	=	"U";
			
							for(int k=0; k<ageGroup.size(); k++)	{
								dup_age_record			=	(HashMap) ageGroup.get(k);
								dup_agegroup_id			=	(String)dup_age_record	.get("age_group_code");
								if(!dup_agegroup_id.equals(age_group_code)){
									dup_found	=	true;
									break;
								}
							}
						}
					}
				}
				if(!dup_found)
					out.println("refreshParentTab('"+func_mode+"')");
				else{
					out.println("displayDuplicate('"+func_mode+"')");
					out.println("refreshParentTab('"+func_mode+"')");
				}
			}
			else{
				int i	=	0;
				while( (String) hash.get("flag"+i)!=null)	{
					flag						= (String) hash.get( "flag"+i);
					select						= (String)hash.get("select"+i);
					String select1				= (String) hash.get("select_chk1"+i);
					select_weight				= (String)hash.get("select_weight"+i);
					String select1_weight		= (String) hash.get("select_chk1_weight"+i);
					select_drug_appl			= (String)hash.get("select_drug_appl"+i);
					String select1_drug_appl	= (String) hash.get("select_chk1_drug_appl"+i);
					ht_mand_yn			= (String)hash.get("ht_mand_yn"+i); //added for Bru-HIMS-CRF-079 IN[029945]
					record	=	(HashMap)ageGroup.get(i);
					record.put("flag",flag);
					record.put("select",select);
					record.put("eff_status",select1);
					record.put("select_weight",select_weight);
					record.put("eff_status_weight",select1_weight);
					record.put("select_drug_appl",select_drug_appl);
					record.put("eff_status_drug_appl",select1_drug_appl);
					record.put("ht_mand_yn",ht_mand_yn); //added for Bru-HIMS-CRF-079 IN[029945]
					i++;
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("Update")){
			trade				=	beanObj.getTradeNames();
			HashMap record		=	null;
			String func_mode1="trade_tab";
			//if( (String) hash.get("flag0")==null)	{
			//	if(hash.containsKey("add_butt")){
				//	if( ((String)hash.get("add_butt")).equals(Add) )	{
			try{
			
				trade_id			= (String) hash.get( "trade_id");
				trade_name			= (String) hash.get( "trade_name");
				manufacturer_id		= (String) hash.get( "manufacturer_id");
				manufacturer_name	= (String) hash.get( "manufacturer_name");
				disp_no				= (String) hash.get( "disp_seq_no");
				flag				= "U";//(String) hash.get( "flag");
				trade_image_filename = (String) hash.get( "trade_image_filename");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int k=0; k<trade.size(); k++)	{
				record			=	(HashMap) trade.get(k);
				bean_trade_id	=	(String)record.get("trade_id");
				bean_disp_no	=	(String)record.get("disp_seq_no");
				if(bean_trade_id.equals(trade_id)){
					record.put("trade_image_filename",trade_image_filename);	
				}
			}
			beanObj.setTradeNames(trade);
			out.println("refreshParentTab('"+func_mode1+"')");
		}
		else if(func_mode!= null && func_mode.equals("sliding_scale")){
			sliding_scale= (ArrayList) beanObj.getSlidingScaleChkdValues();
			template_id = (String) hash.get( "template_id");
			String sld_chkd="";
			sld_chkd=(String) hash.get("sld_chkd");

			if(sld_chkd.equals("yes")){
				if(!sliding_scale.contains(template_id))
					sliding_scale.add(template_id);
			}
			else if(sld_chkd.equals("no")){
				if(sliding_scale.contains(template_id))
					sliding_scale.remove(template_id);
			}
			beanObj.setSlidingScaleChkdValues(sliding_scale);
		}
		else if (func_mode != null && func_mode.equals("FDACategoryCodeSearch")) {
			category_code = request.getParameter("category_code") == null ? "": request.getParameter("category_code");
			ArrayList fdaCategoryList = beanObj.getFDACategoryCodes(category_code,locale);
			String cCode="";
			String cDesc = "";
			for (int i = 0; i < fdaCategoryList.size(); i++) {
				cCode = java.net.URLEncoder.encode(fdaCategoryList.get(i).toString(),"UTF-8");
				cDesc = java.net.URLEncoder.encode(fdaCategoryList.get(++i).toString(),"UTF-8");
				out.println("loadPregnancyTrimesterList(\""+ cCode + "\",\""+ cDesc + "\") ; ");
			}
		}else if (func_mode != null && func_mode.equals("ValidateDrug")) {//Adding start TH-KW-CRF-0007
			String drug_code = (String)hash.get("drug_code")==null?"": (String)hash.get("drug_code");
			ArrayList DrugList = beanObj.getSupportdrugList();
              
			  if(DrugList.contains(drug_code)){
				  out.println("alert('Selected Supportive Drug Already Added To List');");
			  }
		}
		else if (func_mode != null && func_mode.equals("RemoveSupDrug")) {
			String drug_code = (String)hash.get("drug_code")==null?"": (String)hash.get("drug_code");
			int index = Integer.parseInt(hash.get( "index" ).toString());
			ArrayList DrugList = beanObj.getSupportdrugList();
			HashMap   SupportDrugs = beanObj.getSupportDrugs();

			for(int i=0;i<DrugList.size();i++){
				  String temp_drug_code =(String)DrugList.get(i);
					  System.err.println("temp_drug_code=="+temp_drug_code+"drug_code=="+drug_code);
				  if(temp_drug_code.equals(drug_code)){
					  DrugList.remove(i);
				      SupportDrugs.remove(drug_code);
				      beanObj.setSupportDrugs(SupportDrugs);
                      beanObj.setnewSupdrugList(DrugList);
				  }
			}
              

		}//Adding end for TH-KW-CRF-0007
		putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) {
		e.printStackTrace() ;
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
