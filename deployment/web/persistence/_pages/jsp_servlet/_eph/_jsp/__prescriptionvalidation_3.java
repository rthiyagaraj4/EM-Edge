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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __prescriptionvalidation_3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionValidation_3.jsp", 1729069742263L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="   \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="     \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

/* 

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/07/2021  	AAKH-CRF-0140	  prathyusha                                   
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block3Bytes, _wl_block3);
 
	try{
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		String locale = bean.getLanguageId();
		String presBean_id			= (String) hash.get( "presBean_id" )==null?"PrescriptionBean":(String) hash.get( "presBean_id" );
		String presBean_name		=  (String) hash.get( "presBean_name" )==null?"ePH.PrescriptionBean":(String) hash.get( "presBean_name" );
		PrescriptionBean presBean 	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);

	  if(func_mode != null && func_mode.equals("chkOverRideRemarks")) {  
			String patient_id				= (String) hash.get( "patient_id" );
			String encounter_id				= (String) hash.get( "encounter_id" );
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String drug_db_duptherapy_yn = (String)hash.get("drug_db_duptherapy_yn")==null?"":(String)hash.get("drug_db_duptherapy_yn");
			String trade_code = (String)hash.get("trade_code")==null?"":(String)hash.get("trade_code");
			String buildMAR_yn = (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn"); //added for  SKR-SCF-0606 [IN:034766]
			String cur_drug_code = (String)hash.get("drug_code")==null?"":(String)hash.get("drug_code");//added for  SKR-SCF-0606 [IN:034766]
			String cur_srl_no = (String)hash.get("srl_no")==null?"":(String)hash.get("srl_no");//added for  SKR-SCF-0606 [IN:034766]
			String allow_duplicate = (String)hash.get("allow_duplicate")==null?"":(String)hash.get("allow_duplicate");// added for MO-GN-5490 [IN:054620]
			String quota_limit_exceded_yn	= (String) hash.get( "quota_limit_excess_yn" )==null?"":(String) hash.get("quota_limit_excess_yn"); // ML-MMOH-CRF-1823 US008- 43528
			String srlNo = "", intr_drug_desc="", interaction_exists="" , interaction_override="", intr_drcCode="", intr_srlNo="" ; //Added for	RUT-CRF-0066 IN[029604] - start
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			boolean interaction_overrided	= true;
			boolean can_allow_1	= false;
			boolean can_allow_2	= false;
			boolean can_allow_3	= false;
			boolean can_allow_4	= false;
			boolean can_allow_5	= false;
			boolean can_allow_stat_prn = true;
			boolean ext_flag = true;
			String intr_restric_trn = "";
			String abuse_restric_trn="";
			String intr_msg_content = "";
			String drug_indication_mdry=(String)hash.get("drug_indication_mdry")==null?"":(String)hash.get("drug_indication_mdry");//added for jd-crf-0220
			String drug_indication="";//added for jd-crf-0220
			boolean can_allow_6=false;//added for jd-crf-0220
			boolean can_allow_7=false;	//added for mms-dm-crf-0204	
		//	String search_bean_id="@DrugSearchBean"+patient_id+encounter_id;
		//	String search_bean_name="ePH.DrugSearchBean";
		//	DrugSearchBean searchbean = (DrugSearchBean)getBeanObject( search_bean_id, search_bean_name , request) ;
			boolean no_stock_found=false;
			HashMap ext_drugData		=		null;
			String drug_code			=		null;
			String stock_available_yn	=		null;
			String consider_stock_for_pres_yn		=	null;
			String allow_pres_without_stock_yn		=	null;
			String tapered_yn="", amend_yn=""; //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency. 
			String preg_remarks            = (String) hash.get("preg_remarks")==null?"":(String)hash.get("preg_remarks");// added for CRF RUT-CRF-0063[29601]
			String ext_prod_id="", drug_db_duptherapy_flag="";
			String parent_stat_yn		= ""; //AAKH-CRF-0091
			String stat_yn		= "";	//AAKH-CRF-0091
			if(!preg_remarks.equals(""))
				preg_remarks = java.net.URLDecoder.decode(preg_remarks,"UTF-8");// added for CRF RUT-CRF-0063[29601]
		
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") ){
				if( ((String)hash.get( "drug_code" )) != null) {
					String freq_nature , start_date, end_date,freq_code;
					ArrayList	schedule = null;
					for(int j=0;j<prescriptionDetails.size();j++){
						interaction_overrided = true;//added for mms-kh-scf-0186
						ext_drugData				=(HashMap) prescriptionDetails.get(j);
						drug_code					=(String) ext_drugData.get("DRUG_CODE");
						start_date		= (String)ext_drugData.get("START_DATE");
						end_date		= (String)ext_drugData.get("END_DATE");
						freq_code		= (String)ext_drugData.get("FREQ_CODE");
						freq_nature			= (String)ext_drugData.get("FREQ_NATURE");
						srlNo			= (String)ext_drugData.get("SRL_NO");
						if(!locale.equals("en")){
							start_date = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
							end_date = DateUtils.convertDate(end_date, "DMYHM",locale,"en");
						}
						if(drug_code.equals((String)hash.get( "drug_code" ))){
							ext_prod_id		= ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String)ext_drugData.get("EXTERNAL_PRODUCT_ID");
							drug_db_duptherapy_flag		= ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG");
							if( !drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || drug_db_duptherapy_yn.equals("N") ){
								if(presBean.checkDuplicateDrug(patient_id, (String) ext_drugData.get("GENERIC_ID"), start_date,end_date, freq_code,"")){
									ext_drugData.put("CURRENT_RX","Y");
									out.println("showDuplicateInd('"+srlNo+"','Y','"+(String)ext_drugData.get("SLIDING_SCALE_YN")+"','','','"+allow_duplicate+"');"); // allow_duplicate added for MO-GN-5490 [IN:054620]
									if(bean.getCancelDiscConDupOrders().equals("Y") && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") ))  && (((String)ext_drugData.get("ORIG_CURRENT_RX")).equals("Y") || drug_db_duptherapy_flag.equals("Y"))){ //added for Bru-HIMS-CRF-0265 [IN032315]
										ext_drugData.put("ORIG_CURRENT_RX","Y");//Moved from out of if for HSA-CRF-0151 [IN:048468]
										if(!bean.getAmend_alternate_yn().equals("Y"))
										out.println("enableDiscCancelOrders('"+patient_id+"', '"+encounter_id+"', '"+(String) ext_drugData.get("GENERIC_ID")+"', '"+start_date+"', '"+end_date+"', '"+freq_code+"', '"+drug_code+"', '"+srlNo+"', '"+drug_db_interface_yn+"', '"+ext_drugData.get("EXTERNAL_PRODUCT_ID")+"', 'R', '"+(String)ext_drugData.get("SLIDING_SCALE_YN")+"');");
									}
								}
								else{
									ext_drugData.put("CURRENT_RX","N");
									//ext_drugData.put("ORIG_CURRENT_RX","N");  //Commented for [IN:044495]
									ext_drugData.put("CURRENTRX_REMARKS","");  //Added for [IN:044495]
									out.println("showDuplicateInd('"+srlNo+"','N','"+(String)ext_drugData.get("SLIDING_SCALE_YN")+"','','','"+allow_duplicate+"');"); // allow_duplicate added for MO-GN-5490 [IN:054620]
								}
							}
							break;
						}		
					}
				}//Code added for ML-BRU-SCF-0136 IN{032327] -end
			 }
			 else if( ((String)hash.get( "drug_code" )) != null) {		
				String conv_factor		=	"", available_stock;
				String disp_locn_code, qty_value, end_date,durn_value, repeat_value,dosage , qty_desc, pres_base_uom, dosage_type,freq_nature ,absol_qty, sch_size="";
				ArrayList	schedule = null;
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData				=(HashMap) prescriptionDetails.get(j);
					consider_stock_for_pres_yn = (String)ext_drugData.get("CONSIDER_STOCK_FOR_PRES_YN");
					allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N":(String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
					if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
						drug_code					=(String) ext_drugData.get("DRUG_CODE");
						disp_locn_code		= (String) hash.get( "disp_locn_code" );
						qty_value			= (String)ext_drugData.get("QTY_VALUE");
						end_date			= (String) ext_drugData.get("END_DATE");
						durn_value			= (String) ext_drugData.get("DURN_VALUE");
						repeat_value			= (String) ext_drugData.get("DURN_VALUE");
						dosage				= (String)ext_drugData.get("DOSAGE_TYPE");
						qty_desc				= (String)ext_drugData.get("QTY_DESC");
						pres_base_uom		= (String)ext_drugData.get("PRES_BASE_UOM");
						srlNo				= "";
						dosage_type			= (String)ext_drugData.get("DOSAGE_TYPE");
						freq_nature			= (String)ext_drugData.get("FREQ_NATURE");
						absol_qty			= (String)ext_drugData.get("ABSOL_QTY");;
						schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srlNo,"0");
						sch_size			=	"";
						if(dosage_type.equals("Q"))
							conv_factor = (String) bean.getConvFactor(qty_desc,pres_base_uom);
						if(schedule.size() > 0) {
							/*HashMap detail	=	(HashMap)schedule.get(0);
							qty_value		=	(String)detail.get("admin_qty");*/
	 						ArrayList dose_list		= (ArrayList)schedule.get(4);
							if(dose_list!=null && dose_list.size()>0)
								qty_value		= (String)dose_list.get(0);
							sch_size			=  ""+schedule.size();
						} 
						else {
							sch_size		=	repeat_value;
						}
						allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N":(String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
						if(drug_code.equals(drug_code)){
							if(((String)ext_drugData.get("IN_FORMULARY_YN")).equals("Y") ) {
								if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
									if(allow_pres_without_stock_yn.equals("N")){
										if(!locale.equals("en"))
											end_date = DateUtils.convertDate(end_date, "DMYHM",locale,"en");
										HashMap stockValues			=(HashMap) bean.chkStockAvail(drug_code,disp_locn_code,qty_value,end_date, trade_code);
										stock_available_yn			=(String) stockValues.get("STOCK_AVAILABLE_YN");
										available_stock		=(String) stockValues.get("AVAILABLE_STOCK");
										if(dosage_type.equals("A") || freq_nature.equals("P")) {
											qty_value	=	absol_qty;
											dosage		=	"A";
										}
										if(Float.parseFloat(bean.getOrderQty(ext_drugData,qty_value,sch_size,durn_value,dosage,conv_factor)) >	Float.parseFloat(available_stock)) {
											no_stock_found=true;
											break;
										}
									}
								}
							}
						}
					}
				}//for
				if(no_stock_found){
					out.println("alertNoAvailStock()") ;
					return ;
				} 
			 }
			//ended..
			String freq_code="", qty_value="", route_code="", durn_value="", freq_chng_durn_value="", disp_locn_code="",freq_chng_durn_desc="", repeat_durn_type="";
			String pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for  RUT-CRF-0063 [IN:029601]
			String preg_effect;
			for(int j=0;j<prescriptionDetails.size();j++){
				interaction_overrided = true;//added for mms-kh-scf-186
				ext_drugData=(HashMap) prescriptionDetails.get(j);
				drug_code =(String) ext_drugData.get("DRUG_CODE");
				srlNo			= (String)ext_drugData.get("SRL_NO"); //added for  SKR-SCF-0606 [IN:034766] - start
				if(drug_code.equals(cur_drug_code) && srlNo.equals(cur_srl_no)){
					ext_drugData.put("BUILDMAR_YN",buildMAR_yn);
					ext_drugData.put("PREG_REMARKS",preg_remarks); // added for CRF RUT-CRF-0063[29601]
					ext_drugData.put("QUOTA_LIMIT_EXCEDED_YN",quota_limit_exceded_yn); //ML-MMOH-CRF-1823 US008- 43528
				} //added for  SKR-SCF-0606 [IN:034766] -end
				durn_value = (String)ext_drugData.get("DURN_VALUE")==null?"": (String)ext_drugData.get("DURN_VALUE"); //Added for MAR Live issue -start
				repeat_durn_type = (String)ext_drugData.get("REPEAT_DURN_TYPE")==null?"": (String)ext_drugData.get("REPEAT_DURN_TYPE"); 
				freq_chng_durn_value = (String)ext_drugData.get("freq_chng_durn_value")==null?"": (String)ext_drugData.get("freq_chng_durn_value");
				freq_chng_durn_desc = (String)ext_drugData.get("freq_chng_durn_desc")==null?"": (String)ext_drugData.get("freq_chng_durn_desc");
				if(repeat_durn_type.equals(freq_chng_durn_desc) && !durn_value.equals(freq_chng_durn_value)){
					out.println("alert('APP-PH000001 Duration value is not updated. Kindly check the duration.');");
					return;
				}  //Added for MAR Live issue -end
				//Added for	RUT-CRF-0066 IN[029604] - start
				intr_restric_trn = (String)ext_drugData.get("INTR_RESTRIC_TRN")==null?"": (String)ext_drugData.get("INTR_RESTRIC_TRN");
				abuse_restric_trn=(String) ext_drugData.get("ABUSE_RESTRIC_TRN")==null?"N": (String) ext_drugData.get("ABUSE_RESTRIC_TRN");
				interaction_exists = (String)ext_drugData.get("INTERACTION_EXISTS")==null?"N": (String)ext_drugData.get("INTERACTION_EXISTS");
				interaction_override = (String)ext_drugData.get("DRUGINTRACTION_OVERRIDE")==null?"N": (String)ext_drugData.get("DRUGINTRACTION_OVERRIDE");
				freq_code = (String)ext_drugData.get("FREQ_CODE")==null?"": (String)ext_drugData.get("FREQ_CODE");
				qty_value = (String)ext_drugData.get("QTY_VALUE")==null?"": (String)ext_drugData.get("QTY_VALUE");
				route_code = (String)ext_drugData.get("ROUTE_CODE")==null?"": (String)ext_drugData.get("ROUTE_CODE");
				disp_locn_code = (String)ext_drugData.get("DISP_LOCN_CODE")==null?"": (String)ext_drugData.get("DISP_LOCN_CODE");
				preg_effect = (String)ext_drugData.get("PREG_EFFECT")==null?"": (String)ext_drugData.get("PREG_EFFECT");
				preg_remarks = (String)ext_drugData.get("PREG_REMARKS")==null?"": (String)ext_drugData.get("PREG_REMARKS");
				if(pregnency_yn.equals("Y") && !preg_effect.equals("") && preg_remarks.equals("")){
					out.println("alert(getMessage('PH_SELECT_PREG_OVERRIDE_RESONE','PH'));"); 
					return;
				}
				if(freq_code.equals("") || qty_value.equals("") || route_code.equals("") || disp_locn_code.equals("")){
					out.println("alertMandFlds('"+drug_code+"','"+srlNo+"');");
					return;
				}System.out.println("interaction_exists"+interaction_exists);
				System.out.println("interaction_override"+interaction_override);
				System.out.println("interaction_overrided"+interaction_overrided);
				if(interaction_exists.equals("Y") && interaction_override.equals("N") && interaction_overrided){
					System.out.println("221 interaction_overrided"+interaction_overrided);
					interaction_overrided = false;
				}
				if(intr_restric_trn.equals("Y") && intr_msg_content.equals("")){
					intr_drcCode =(String)ext_drugData.get("DRUG_CODE")==null?"": (String)ext_drugData.get("DRUG_CODE");
					intr_srlNo =(String)ext_drugData.get("SRL_NO")==null?"": (String)ext_drugData.get("SRL_NO");
				}
				if(abuse_restric_trn.equals("Y")){
					intr_drcCode =(String)ext_drugData.get("DRUG_CODE")==null?"": (String)ext_drugData.get("DRUG_CODE");
					intr_srlNo =(String)ext_drugData.get("SRL_NO")==null?"": (String)ext_drugData.get("SRL_NO");
				} 
				//Added for	RUT-CRF-0066 IN[029604] - end
				stock_available_yn = (String)ext_drugData.get("STOCK_AVAILABLE_YN");
				consider_stock_for_pres_yn = (String)ext_drugData.get("CONSIDER_STOCK_FOR_PRES_YN");
				allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N": (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
				if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
					if(allow_pres_without_stock_yn.equals("N")){
						if(stock_available_yn.equals("N")){
							bean.removeNoStockDrug(drug_code);					
							out.println("deleteOROrderCatalogforNoStock('"+drug_code+"')");
							j--;
						}
					}
				}
			}//for
			String allergy_yn		   =	null;
			String limit_ind		   =	null;
			String current_rx		   =	null;
			String allergy_override    =	null;
			String dose_override	   =	null;
			String currentrx_override  =    null;
			String flag				   =  "N";
			String duplicate_check_at_atc_yn=null;
			String tappered_over	   =    "";
			ArrayList atc_dup_drug_code=    null;
			String drug1, drug2, drug_code_1, currentrx_override1, tappered_over1, drug1_drug_code, drug2_drug_code, freq_nature, exist_drug_freq_nature ;
			HashMap ext_drugData1 = null;
			float ext_total_qty_value = 0; //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
			float new_total_qty		=0.0f;
			boolean taper_cofirmed = true;
			String taper_up_yn="", taper_down_yn="", multiFreq_yn="", freq="", qtyValue="" ; //Added for  [IN:043763] -end
			if(prescriptionDetails !=null && prescriptionDetails.size()>0){
				//Code for checking ATC level-4 duplication checking
				ext_drugData				    =  (HashMap) prescriptionDetails.get(0);
				duplicate_check_at_atc_yn       = (String) ext_drugData.get("DUPLICATE_CHECK_AT_ATC_YN");
				if(duplicate_check_at_atc_yn.equals("Y")){
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData		=  (HashMap) prescriptionDetails.get(j);
						drug_code			= (String) ext_drugData.get("DRUG_CODE");
						current_rx          = (String) ext_drugData.get("CURRENT_RX");
						currentrx_override  = (String) ext_drugData.get("CURRENTRX_OVERRIDE");
						tappered_over       = (String) ext_drugData.get("TAPPERED_OVER");
						drug1 = ext_drugData.get("ATC_CLASS_LEV4_CODE")==null?"":(String) ext_drugData.get("ATC_CLASS_LEV4_CODE");
						for(int k=j+1;k<prescriptionDetails.size();k++){
							ext_drugData1 = (HashMap) prescriptionDetails.get(k);
							drug2					= (String) ext_drugData1.get("DRUG_CODE");
							drug_code_1           =  drug2;
							currentrx_override1   = (String) ext_drugData1.get("CURRENTRX_OVERRIDE");
							tappered_over1        = (String) ext_drugData1.get("TAPPERED_OVER");
							drug2 = ext_drugData1.get("ATC_CLASS_LEV4_CODE")==null?"":(String) ext_drugData1.get("ATC_CLASS_LEV4_CODE");
							// This code disallows same drug with same frequency nature for PRN and Stat frequencies // Code added for IN24061 --06/10/2010-- priya
							drug1_drug_code = (String)ext_drugData.get("DRUG_CODE");
							drug2_drug_code = (String)ext_drugData1.get("DRUG_CODE");
							if(!(drug1_drug_code.equals("") && drug2_drug_code.equals("")) && drug1_drug_code.equals(drug2_drug_code)){	
								if(tappered_over1.equals("N")){ // tappered_over changed to tappered_over1 for [IN:043763] 
									if( ext_drugData1.containsKey("FREQ_NATURE") ){
										freq_nature = (String)ext_drugData1.get("FREQ_NATURE")==null?"":(String)ext_drugData1.get("FREQ_NATURE");
										exist_drug_freq_nature = (String)ext_drugData.get("FREQ_NATURE")==null?"":(String)ext_drugData.get("FREQ_NATURE");

										if((freq_nature.equals("P") || freq_nature.equals("O")) && (exist_drug_freq_nature.equals("P") || exist_drug_freq_nature.equals("O")) && (freq_nature.equals(exist_drug_freq_nature))){
											ext_flag = false;
											can_allow_stat_prn = false;
											break;
										}
									}
								}
								else{ //Added for  [IN:043763] User can able to do Taper without changing the Dosage and frequency.  -Start
									new_total_qty   = Float.parseFloat((String) ext_drugData1.get("TOTAL_QTY_VALUE"));
									freq				=  (String) ext_drugData1.get("FREQ_CODE")==null?"":(String) ext_drugData1.get("FREQ_CODE");
									qty_value				=  (String) ext_drugData1.get("QTY_VALUE")==null?"":(String) ext_drugData1.get("QTY_VALUE");
									ext_total_qty_value   = Float.parseFloat((String) ext_drugData.get("TOTAL_QTY_VALUE"));
									freq_code				=  (String) ext_drugData.get("FREQ_CODE")==null?"":(String) ext_drugData.get("FREQ_CODE");
									qtyValue				=  (String) ext_drugData.get("QTY_VALUE")==null?"":(String) ext_drugData.get("QTY_VALUE");
									taper_up_yn					=  (String)ext_drugData.get("TAPER_UP")==null?"":(String)ext_drugData.get("TAPER_UP");
									taper_down_yn				=  (String) ext_drugData.get("TAPER_DOSE_YN")==null?"":(String) ext_drugData.get("TAPER_DOSE_YN");
									if(taper_up_yn.equals("Y")||taper_down_yn.equals("Y"))
										multiFreq_yn = "N";
									else
										multiFreq_yn = "Y";
									if(taper_up_yn.equals("N") && multiFreq_yn.equals("N")){
										if( (new_total_qty >= ext_total_qty_value)){
											out.println("alertNoTaper('greater')") ;
											taper_cofirmed = false;
											ext_flag = false;
											flag = "Y";
											break;
										}
									}	
									else if( multiFreq_yn.equals("N")){
										if(new_total_qty <= ext_total_qty_value){
											out.println("alertNoTaper('lesser')") ;
											taper_cofirmed = false;
											ext_flag = false;
											flag = "Y";
											break;
										}
									}
									if(freq.equals(freq_code) && qty_value.equals(qtyValue)){
										//if(multiFreq_yn.equals("N")){
											out.println("alertNoTaper('nochange')") ;
											taper_cofirmed = false;
											ext_flag = false;
											flag = "Y";
											break;
										//}
									}  
								} //Added for  [IN:043763] - end
							}
						   if(!(drug1.equals("") && drug2.equals("")) && drug1.equals(drug2)){	
								if((currentrx_override.equals("N"))&&(tappered_over.equals("N"))){
									if(!drug_code.equals(drug_code_1) && ((ext_drugData1.get("CURRENT_RX"))==null ||  !((String)ext_drugData1.get("CURRENT_RX")).equals("Y"))){
										if( (( ext_drugData.get("EXTERNAL_PRODUCT_ID")==null || ((String) ext_drugData.get("EXTERNAL_PRODUCT_ID")).equals("") ) && drug_db_duptherapy_yn.equals("Y")) || (drug_db_duptherapy_yn.equals("N"))){  //condition added for IN22902 --28/07/2010-- priya
											ext_drugData.put("CURRENT_RX","Y");										
											flag ="Y";
										}
									}
								}
								if(((String)ext_drugData.get("ALERT_YN"))==null || !((String)ext_drugData.get("ALERT_YN")).equals("Generic :")){
									ext_drugData.put("ATC_LEVEL4_DUPLICATION","Y");
									atc_dup_drug_code = (ArrayList)ext_drugData.get("ATC_LEVEL4_DUP_DRUG_CODE");
									if(atc_dup_drug_code == null)
										atc_dup_drug_code = new ArrayList();
									atc_dup_drug_code.add(drug_code_1);
									ext_drugData.put("ATC_LEVEL4_DUP_DRUG_CODE",atc_dup_drug_code);
									//ext_drugData.put("ATC_DUP_DRUG_CODE",drug_code_1);
									if((currentrx_override1.equals("N")) && (tappered_over1.equals("N"))){
										if(!drug_code.equals(drug_code_1)&&(((String)ext_drugData1.get("CURRENT_RX"))==null ||  !((String)ext_drugData1.get("CURRENT_RX")).equals("Y"))){
											if( (( ext_drugData1.get("EXTERNAL_PRODUCT_ID")==null || ((String) ext_drugData1.get("EXTERNAL_PRODUCT_ID")).equals("") ) && drug_db_duptherapy_yn.equals("Y")) || (drug_db_duptherapy_yn.equals("N"))){   //condition added for IN22902 --28/07/2010-- priya
												ext_drugData1.put("CURRENT_RX","Y");										
												flag ="Y";
											}
										}
									}
								}
								
								//ext_drugData1.put("ATC_DUP_DRUG_CODE",drug_code);	
							}//if
						}//	for--inner loop				  
					}//for--main loop
				}//if
				if(flag.equals("N")) {
					can_allow_5   =  true;
				}
				else{
					can_allow_5  =  false;
					can_allow_4  =  true;
				}
				//ATC duplication checking ends 
				String dsg_reason, dup_reason, con_reason ,int_reason, alg_reason, drug_db_dosage_check_flag, drug_db_contraind_check_flag, drug_db_interact_check_flag,  drug_db_allergy_flag;
				String diagnosis_found_yn="",ord_set_reqd_or_opt="";
				
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData = (HashMap) prescriptionDetails.get(j);
					drug_code    = (String) ext_drugData.get("DRUG_CODE");		

					allergy_yn   = (String) ext_drugData.get("ALLERGY_YN");
					limit_ind    = (String) ext_drugData.get("LIMIT_IND")==null?"":(String)ext_drugData.get("LIMIT_IND");  //Modified for AAKH-CRF-0091
					current_rx   = (String) ext_drugData.get("CURRENT_RX");
					allergy_override    = (String) ext_drugData.get("ALLERGY_OVERRIDE");
					dose_override       = (String) ext_drugData.get("DOSE_OVERRIDE");
					currentrx_override  = (String) ext_drugData.get("CURRENTRX_OVERRIDE");
					ext_prod_id			= (String)ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"": (String)ext_drugData.get("EXTERNAL_PRODUCT_ID");
					stat_yn			= (String)ext_drugData.get("stat_yn")==null?"":(String)ext_drugData.get("stat_yn");						//Added forAAKH-CRF-0091
					parent_stat_yn  = (String)ext_drugData.get( "parent_stat_yn" )==null?"":(String)ext_drugData.get("parent_stat_yn");		//Added forAAKH-CRF-0091
					dsg_reason = (String)ext_drugData.get("EXT_DDB_DSG_REASON")==null?"":(String)ext_drugData.get("EXT_DDB_DSG_REASON");
					dup_reason = (String)ext_drugData.get("EXT_DDB_DUP_REASON")==null?"":(String)ext_drugData.get("EXT_DDB_DUP_REASON");
					con_reason = (String)ext_drugData.get("EXT_DDB_CON_REASON")==null?"":(String)ext_drugData.get("EXT_DDB_CON_REASON");
					int_reason = (String)ext_drugData.get("EXT_DDB_INT_REASON")==null?"":(String)ext_drugData.get("EXT_DDB_INT_REASON");
					alg_reason = (String)ext_drugData.get("EXT_DDB_ALG_REASON")==null?"":(String)ext_drugData.get("EXT_DDB_ALG_REASON");
					drug_db_dosage_check_flag    = (String) ext_drugData.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)ext_drugData.get("DRUG_DB_DOSAGE_CHECK_FLAG");
					drug_db_contraind_check_flag = (String) ext_drugData.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)ext_drugData.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
					drug_db_interact_check_flag  = (String) ext_drugData.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)ext_drugData.get("DRUG_DB_INTERACT_CHECK_FLAG");
					drug_db_duptherapy_flag      = (String) ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG");
					drug_db_allergy_flag         = (String) ext_drugData.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)ext_drugData.get("DRUG_DB_ALLERGY_FLAG");
					drug_indication= (String) ext_drugData.get("DRUG_INDICATION")==null?"":(String)ext_drugData.get("DRUG_INDICATION");
					 diagnosis_found_yn= (String) ext_drugData.get("DIAGNOSIS_FOUND_YN")==null?"":(String)ext_drugData.get("DIAGNOSIS_FOUND_YN");
					  ord_set_reqd_or_opt= (String) ext_drugData.get("REQD_OR_OPT_IND")==null?"":(String)ext_drugData.get("REQD_OR_OPT_IND");
					System.out.println(diagnosis_found_yn+"diagnosis_found_yn in validation3"+ord_set_reqd_or_opt);
					if(drug_db_interface_yn.equals("Y") && !ext_prod_id.equals("") && drug_db_duptherapy_flag.equals("Y")){
						current_rx = "N";
					}
					if(drug_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){
						can_allow_1=true;
						can_allow_2=true;
						can_allow_3=true;
						can_allow_4=true;
						can_allow_5=true;
						can_allow_6=true;//added for jd-crf-0220
						can_allow_7=true;//added for mms-dm-crf-0204
						if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) ||(drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) || (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) || (drug_db_interact_check_flag.equals("Y") && (int_reason.equals("")))||  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){
							ext_flag = false;
							break;
						}//ext_flag = true;  // Commented for IN24061 --06/10/2010-- priya
					}
					
						//	ext_flag = true;
						if( allergy_yn.equals("Y") && !drug_db_allergy_flag.equals("Y")){
							if(allergy_override.equals("N")){
								can_allow_1=false;
								break;
							}
							else{
								can_allow_1=true;
							}
						}
						else{
							can_allow_1=true;
						}
						if(limit_ind.equals("N") && drug_db_dosage_check_flag.equals("Y")){ // Removed ! from the above condition for Overridereason alert without any indicator for External dosage check.
							if(dose_override.equals("N")){
								
									can_allow_2=false;
								break;
							
							}
							else{
								can_allow_2=true;
							}
						}
						else{
							can_allow_2=true;
						}
						if(current_rx !=null && current_rx.equals("Y") && (drug_db_interface_yn==null || !drug_db_interface_yn.equals("Y") || ext_prod_id==null || ext_prod_id.equals(""))){ //drug_db_duptherapy_flag replaced with drug_db_interface_yn to avoid the duplicate alert //|| ext_prod_id==null || ext_prod_id.equals("") added for [IN036011]
							if(currentrx_override!=null && currentrx_override.equals("N") && (dup_reason.equals(""))){
								can_allow_3=false;
								break;
							}
							else{
								can_allow_3=true;
							}
						}
						else{
							can_allow_3=true;
						}
						if( drug_indication_mdry.equals("Y") && !drug_db_allergy_flag.equals("Y")){//added for jd-crf-0220
							if(drug_indication.equals("") || drug_indication==null){
								can_allow_6=false;
								break;
							}
							else{
								can_allow_6=true;
							}
						}
						else{
							can_allow_6=true;
						}
						
						if( diagnosis_found_yn.equals("N") ){//added for mms-dm-crf-0204
							
								can_allow_7=false;
								break;
							}
							else{
								can_allow_7=true;
							}
					
						
						
						
						can_allow_4=true; 
				//	}
				}
				if(flag.equals("Y")){ // if condition added for IN26131 -- 31/01/2011-- priya
					can_allow_5 = false;
				}
				if(abuse_restric_trn.equals("Y")){ // && !intr_msg_content.equals("")
					out.println("alertAbuse('"+intr_drcCode+"','"+intr_srlNo+"','"+patient_id+"','"+encounter_id+"','"+abuse_restric_trn+"');"); 
				} 
				if(intr_restric_trn.equals("Y")){ // && !intr_msg_content.equals("")
					out.println("alertIntr('"+intr_drcCode+"','"+intr_srlNo+"','"+patient_id+"','"+encounter_id+"','"+intr_restric_trn+"');"); 
				}
				 
				else if(!interaction_overrided){
					System.out.println("interaction_overrided"+interaction_overrided);
					can_allow_2 = false; 
					
					out.println("allowRelease('"+can_allow_1+"','"+can_allow_2+"','"+can_allow_3+"','"+can_allow_4+"','"+can_allow_5+"','"+can_allow_6+"','"+can_allow_7+"','"+stat_yn+"')");
				}
				else if(ext_flag){
					if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091
						can_allow_1=true;can_allow_2=true;can_allow_3=true;can_allow_6=true;
					}
					out.println("allowRelease('"+can_allow_1+"','"+can_allow_2+"','"+can_allow_3+"','"+can_allow_4+"','"+can_allow_5+"','"+can_allow_6+"','"+can_allow_7+"','"+stat_yn+"')");
				}
				
				else{
					if(stat_yn.equals("Y")){//added forMMS-KH-SCF-0186
					can_allow_2 = true;
			     	}
					if(!can_allow_stat_prn)  //if condition added for IN24061 --06/10/2010-- priya
						out.println("alertNoTaper('changefreq');");
					else{
						if(flag.equals("N")){// added if-else condition instead of code in if part for IN26131 --31/01/2011-- priya
						    out.println("alert(getMessage('OVERRIDE_REASON_NOT_BLANK','PH'));");
						}
						else if(taper_cofirmed){ //if(taper_cofirmed) Added for  [IN:043763] 
							out.println("allowRelease('"+can_allow_1+"','"+can_allow_2+"','"+can_allow_3+"','"+can_allow_4+"','"+can_allow_5+"','"+can_allow_6+"','"+can_allow_7+"','"+stat_yn+"')");
						}
					}
				}
			}
			else{
				out.println("noDrugforRelease()");
			}
		
		}
	 putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch (Exception e) {
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
