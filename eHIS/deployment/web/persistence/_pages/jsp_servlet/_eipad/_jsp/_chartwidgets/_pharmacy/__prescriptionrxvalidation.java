package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.pharmacy.response.PharmFieldResponse;
import eIPAD.chartsummary.pharmacy.healthobject.PharmFieldItem;
import com.ehis.persist.PersistenceHelper;
import ePH.PrescriptionBean_1;
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

public final class __prescriptionrxvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/PrescriptionRxValidation.jsp", 1709116948379L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n       ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

	private String getOrderQty(HashMap ext_drugData,String qty_value,String repeat_value,String durn_value,String dosage_type,String conv_factor){
		String fract_dose				=	(String)ext_drugData.get("FRACT_DOSE_ROUND_UP_YN");
		String content_in_pres_base_uom	=	(String)ext_drugData.get("CONTENT_IN_PRES_BASE_UOM");
		String strength_per_value_per_pres_uom	= (String)ext_drugData.get("STRENGTH_PER_VALUE_PRES_UOM");
		String strength_per_pres_uom			= (String)ext_drugData.get("STRENGTH_PER_PRES_UOM");
		String interval_value					= (String)ext_drugData.get("INTERVAL_VALUE");
		String freq_nature						= (String)ext_drugData.get("FREQ_NATURE");
		String ord_qty					=	"";
		String	tmp_qty					=	"";
		try {
			if(dosage_type!=null && dosage_type.equals("A")){
				ord_qty	=	qty_value;
			}  
			else if(dosage_type!=null && dosage_type.equals("Q")){
				if(fract_dose != null && !fract_dose.equals("Y"))	{
					ord_qty		=  (Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)* Float.parseFloat(conv_factor))+"";
					ord_qty		=	Math.ceil(Float.parseFloat(ord_qty)/(Float.parseFloat(content_in_pres_base_uom)))+"";
					if(ord_qty.equals("0")){
						ord_qty	=	"1";
					}
				} 
				else{
					if( (Float.parseFloat(qty_value)*Float.parseFloat(conv_factor)) < Float.parseFloat(content_in_pres_base_uom))
						tmp_qty	=	1+"";
					else
						tmp_qty	=  Math.ceil((Float.parseFloat(qty_value)*Float.parseFloat(conv_factor))/Float.parseFloat(content_in_pres_base_uom))+"";
					ord_qty	=  (Float.parseFloat(tmp_qty) *Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";
				}
				ord_qty	=	String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				if(freq_nature != null && freq_nature.equals("F")){
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}
			} 
			else if(dosage_type!=null && dosage_type.equals("S")){
				if(fract_dose != null && !fract_dose.equals("Y"))	{	
					ord_qty		=((Float.parseFloat(qty_value)*Float.parseFloat(durn_value)*Float.parseFloat(repeat_value)*Float.parseFloat(strength_per_value_per_pres_uom))/(Float.parseFloat(strength_per_pres_uom)))+"";
					ord_qty		=	String.valueOf(Math.ceil(new Double(Float.parseFloat(ord_qty)/Float.parseFloat(content_in_pres_base_uom)).doubleValue()));
				}
				else{
					double unit_qty	= Math.ceil(Double.parseDouble(qty_value)/Double.parseDouble(strength_per_pres_uom)) * (Double.parseDouble(strength_per_value_per_pres_uom));
					tmp_qty			=  (Math.ceil(unit_qty /Float.parseFloat(content_in_pres_base_uom))+"");
					ord_qty			=  (Float.parseFloat(tmp_qty) * Float.parseFloat(durn_value)*Float.parseFloat(repeat_value))+"";					
				}
				ord_qty=String.valueOf(Math.ceil(Double.parseDouble(String.valueOf(ord_qty))));
				if(freq_nature != null && freq_nature.equals("F")){
					ord_qty	=	String.valueOf(Math.ceil(Float.parseFloat(ord_qty) / Integer.parseInt(interval_value)));
				}
			}
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return ord_qty;
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	try{ 
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request);
		String locale = bean.getLanguageId();
		String presBean_id			= (String) hash.get( "presBean_id" )==null?"PrescriptionBean":(String) hash.get( "presBean_id" );
		String presBean_name		=  (String) hash.get( "presBean_name" )==null?"ePH.PrescriptionBean":(String) hash.get( "presBean_name" );
		PrescriptionBean presBean 	= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id,presBean_name,request);
		if(func_mode != null && func_mode.equals("RXINSERT" )){
					try {
				PhAdapter beanObj = (PhAdapter)PersistenceHelper.getBeanObject( bean_id,bean_name,request ) ;
				hash.remove( "bean_id" ) ;
				hash.remove( "bean_name" );
				beanObj.setAll(hash) ;	
				HashMap map = beanObj.validate() ;
				boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
				String validationMessage = (String) map.get( "message" ) ;				
				if ( validated ) {
					map = beanObj.apply() ;						
					boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
					if(result)
					{	
					}
					String message = (String) map.get( "message" );
					String flag = (String) map.get( "flag" );					
					String invalidCode = "" ;
					if(map.get("invalidCode") != null)
						invalidCode = (String) map.get( "invalidCode" ) ;			
					out.println("assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\") ; ") ; 
				} else {
					out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\", \"0\" ) ; ") ;
				}
				 PersistenceHelper.putObjectInBean(bean_id,beanObj,request); 
			}
			catch (Exception e) {
				out.println("alert(\"Exception in Controller : " + e + "\");") ;
				e.printStackTrace();
			}			
		}		
		else if(func_mode != null && func_mode.equals("completeRxDetails" )){ 
			String DRUG_CODE	= (String) hash.get( "DRUG_CODE" );
			String SRL_NO	= (String) hash.get( "SRL_NO" );
			String LIMIT_IND	= (String) hash.get( "LIMIT_IND" );
			String DOSAGE_TYPE	= (String) hash.get( "DOSAGE_TYPE" );
			String QTY_VALUE		= (String) hash.get( "QTY_VALUE" );
			String STRENGTH_VALUE	= (String) hash.get( "STRENGTH_VALUE" );
			String TAB_QTY_VALUE	= (String) hash.get( "TAB_QTY_VALUE" );
			String FREQ_CODE		= (String) hash.get( "FREQ_CODE" );
			String SCHEDULED_YN		= (String) hash.get( "SCHEDULED_YN" );
			String START_DATE		= (String) hash.get( "START_DATE" );
			String SPLIT_DOSE_YN		= (String) hash.get( "SPLIT_DOSE_YN" );
			String ROWVAL		= (String) hash.get( "ROWVAL" );
			String ROUTE_CODE 	= (String) hash.get( "ROUTE_CODE" );
			String PRIORITY 	= (String) hash.get( "PRIORITY" );
			String TRADE_NAME 	= (String) hash.get( "TRADE_NAME" );
			String PRN_REMARKS 	= (String) hash.get( "PRN_REMARKS" );
			String DRUG_REMARKS 	= (String) hash.get( "DRUG_REMARKS" );
			
			HashMap prn = new HashMap();
			prn.put("prn_remarks_dtl", PRN_REMARKS);
			prn.put("prn_remarks_code", "");			
			bean.addPRNRemarks(DRUG_CODE, prn);
			
			if(TRADE_NAME != null && TRADE_NAME != "") 
				TRADE_NAME 			= java.net.URLDecoder.decode(TRADE_NAME,"UTF-8");
			String TRADE_CODE 	= (String) hash.get( "TRADE_CODE" );
			String BUILDMAR_YN 	= (String) hash.get( "BUILDMAR_YN" );
			String DURN_VALUE 	= (String) hash.get( "DURN_VALUE" );
			String DURN_TYPE 	= (String) hash.get( "DURN_TYPE" );
			String END_DATE= (String) hash.get( "END_DATE" );
			String BROUGHT_BY_PAT= (String) hash.get( "BROUGHT_BY_PAT" );
			String ALLERGY_REMARKS = (String) hash.get( "ALLERGY_REMARKS" );
			if(ALLERGY_REMARKS != null && !ALLERGY_REMARKS.equals(""))
				ALLERGY_REMARKS			= java.net.URLDecoder.decode(ALLERGY_REMARKS,"UTF-8");
			String CURRENTRX_REMARKS = (String) hash.get( "CURRENTRX_REMARKS");
			if(CURRENTRX_REMARKS != null && !CURRENTRX_REMARKS.equals(""))
			CURRENTRX_REMARKS			= java.net.URLDecoder.decode(CURRENTRX_REMARKS,"UTF-8");
			String DOSE_REMARKS = (String) hash.get( "DOSE_REMARKS");
			if(DOSE_REMARKS != null && !DOSE_REMARKS.equals(""))
			DOSE_REMARKS			= java.net.URLDecoder.decode(DOSE_REMARKS,"UTF-8");
			String INTERACTION_REMARKS = (String) hash.get( "INTERACTION_REMARKS");
			if(INTERACTION_REMARKS != null && !INTERACTION_REMARKS.equals(""))
			INTERACTION_REMARKS			= java.net.URLDecoder.decode(INTERACTION_REMARKS,"UTF-8");
			String DRUG_INDICATION = (String) hash.get( "DRUG_INDICATION");
			if(DRUG_INDICATION != null && !DRUG_INDICATION.equals(""))
			DRUG_INDICATION			= java.net.URLDecoder.decode(DRUG_INDICATION,"UTF-8");
			String str_drug_code = "";
			String str_srl_no = "";			
			HashMap hm_drugData            = null;  
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				hm_drugData				=(HashMap) prescriptionDetails.get(j);
				str_drug_code				=(String) hm_drugData.get("DRUG_CODE");
				str_srl_no				=(String) hm_drugData.get("SRL_NO");
				
				out.println("console.log('"+str_srl_no+"')");
				out.println("console.log('"+SRL_NO+"')");
				out.println("console.log('"+str_drug_code+"')");
				out.println("console.log('"+DRUG_CODE+"')");
				if( DRUG_CODE.equals(str_drug_code)){ //&& (SRL_NO.equals(str_srl_no)
					
					out.println("console.log('"+CURRENTRX_REMARKS+"')");	
					
					hm_drugData.put("LIMIT_IND",LIMIT_IND);
					hm_drugData.put("DOSE_REMARKS",DOSE_REMARKS);
					hm_drugData.put("DOSAGE_TYPE",DOSAGE_TYPE);
					hm_drugData.put("QTY_VALUE",QTY_VALUE);
					hm_drugData.put("PRN_REMARKS",PRN_REMARKS);
					hm_drugData.put("DRUG_REMARKS",DRUG_REMARKS);
					
					hm_drugData.put("STRENGTH_VALUE",STRENGTH_VALUE);
					hm_drugData.put("TAB_QTY_VALUE",TAB_QTY_VALUE);
					hm_drugData.put("FREQ_CODE",FREQ_CODE);
					hm_drugData.put("SCHEDULED_YN",SCHEDULED_YN);
					hm_drugData.put("START_DATE",START_DATE);
					hm_drugData.put("SPLIT_DOSE_YN",SPLIT_DOSE_YN);
					hm_drugData.put("ROWVAL",ROWVAL);
					hm_drugData.put("ROUTE_CODE",ROUTE_CODE);
					hm_drugData.put("PRIORITY",PRIORITY);
					hm_drugData.put("TRADE_NAME",TRADE_NAME);
					hm_drugData.put("TRADE_CODE",TRADE_CODE);
					hm_drugData.put("BUILDMAR_YN",BUILDMAR_YN);
					hm_drugData.put("DURN_VALUE",DURN_VALUE);
					hm_drugData.put("freq_chng_durn_desc",DURN_TYPE);
					hm_drugData.put("END_DATE",END_DATE);
					hm_drugData.put("BROUGHT_BY_PAT",BROUGHT_BY_PAT);
					hm_drugData.put("ALLERGY_REMARKS",ALLERGY_REMARKS);
					hm_drugData.put("CURRENTRX_REMARKS",CURRENTRX_REMARKS);
					hm_drugData.put("DOSE_REMARKS",DOSE_REMARKS);
					hm_drugData.put("INTERACTION_REMARKS",INTERACTION_REMARKS);
					hm_drugData.put("DRUG_INDICATION",DRUG_INDICATION);
				}
			}
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable schedule_val	=	null; 
			Hashtable sch_output	=	null;			
			out.println("okClickDialog()");			
		}
		else if(func_mode != null && func_mode.equals("InsertRec")){
			String oper_mode		= (String)hash.get("oper_mode"); 
			String trade_code		= (String) hash.get("trade_code")==null?"":(String)hash.get("trade_code");
			String trade_name		= (String) hash.get("trade_name")==null?"":(String)hash.get("trade_name");
			trade_name= java.net.URLDecoder.decode(trade_name,"UTF-8");
			String buildMAR_yn		= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn");
			String order_set_code	= (String)hash.get("order_set_code")==null?"":(String)hash.get("order_set_code");
			String split_dose_yn_val= (String)hash.get("split_dose_yn_val");
			String DrugRemarksEntered= (String)hash.get("DrugRemarksEntered"); 
			String patient_id		= (String) hash.get( "patient_id" );
			String encounter_id		= (String) hash.get( "encounter_id" ); 
			String addext_drug_code	=	null;
			String ext_drug_code	=	null;
			String addext_srl_no	=	null;
			String durnValue		=	"";
			String freq_code		=	"";
			String qtyValue			=	"";
			String total_qty_value	=	"";
			String multiFreq_yn		=	"N";
			String taper_up_yn		=	"";
			String taper_down_yn	=	"";
			String interval_value	=	"";  
			String repeat_durn_type	=	"";  
			String durn_desc_code	=	"";  
			String bl_incl_excl_override_reason_code = (String) hash.get("bl_incl_excl_override_reason_code")==null?"":(String)hash.get("bl_incl_excl_override_reason_code");
			String bl_incl_excl_override_reason_desc = (String) hash.get("bl_incl_excl_override_reason_desc")==null?"":(String)hash.get("bl_incl_excl_override_reason_desc");
			String bl_def_override_excl_incl_ind     = (String) hash.get("bl_def_override_excl_incl_ind")==null?"":(String)hash.get("bl_def_override_excl_incl_ind");
			String bl_override_excl_incl_ind         = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String)hash.get("bl_override_excl_incl_ind");
			String bl_override_allowed_yn            = (String) hash.get("bl_override_allowed_yn")==null?"":(String)hash.get("bl_override_allowed_yn");
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String drug_db_duptherapy_yn = (String)hash.get("drug_db_duptherapy_yn")==null?"":(String)hash.get("drug_db_duptherapy_yn");
			String preg_remarks            = (String) hash.get("preg_remarks")==null?"":(String)hash.get("preg_remarks");
			String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
			String ext_prod_id = "";
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); ;
			if(!preg_remarks.equals(""))
				preg_remarks = java.net.URLDecoder.decode(preg_remarks,"UTF-8"); 
			String intr_msg_content ="", intr_restric_trn="N", severity_level="", st_date_local="",end_date_local="" ;
			HashMap hmDrugInteractionDtl = null;
			ArrayList alDrugIntrDtlList = null;
			float ext_total_qty_value = 0;
			
			ArrayList addprescriptionDetails	=	(ArrayList)bean.getpresDetails();
			HashMap temp			=	new HashMap();
			HashMap ext_drugData	=	null;
			HashMap addext_drugData	=	null;
			float new_qty			=	0.0f;
			int new_repeat_value	=0;
			float new_total_qty		=0.0f;
			if(oper_mode != null && oper_mode.equals("taper")){
				boolean can_taper		= false;
				String override_check		= (String) hash.get("override_remarks");
				String checkEnabled			= (String) hash.get("checkEnabled");
				if(override_check==null)
					override_check="";
				if(checkEnabled==null)
					checkEnabled="";			
				String drugCode			= (String)hash.get("drug_code");
				String srlNo			= (String)hash.get("srl_no");
				String durn_value		= (String)hash.get("durn_value");
				String freq				= (String)hash.get("frequency");
				String qty_value		= (String)hash.get("qty_value");
				String repeat_value		= (String)hash.get("repeat_value");
				String ph_version		= (String)hash.get("ph_version");
				int srl_no				= Integer.parseInt(srlNo);
				new_qty			=	Float.parseFloat(qty_value);
				new_repeat_value	=	Integer.parseInt(repeat_value);
				if(split_dose_yn_val!=null && !split_dose_yn_val.equals("Y"))
					new_total_qty	=	(new_qty*new_repeat_value);
				else 
					new_total_qty = new_qty;
				durnValue		=	"";    
				freq_code		=	"";    
				qtyValue			=	"";
				total_qty_value	=	"";
				if(repeat_value==null || repeat_value.equals(""))
					repeat_value="1";
				String pract_name			 = (String) hash.get("pract_name");
				for(int j=0;j<addprescriptionDetails.size();j++){
					addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
					addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
					addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
					if( drugCode.equals(addext_drug_code) ){
						durnValue	=  (String) addext_drugData.get("DURN_VALUE");
						freq_code	=  (String) addext_drugData.get("FREQ_CODE");
						qtyValue	=  (String) addext_drugData.get("QTY_VALUE");
						total_qty_value=  (String) addext_drugData.get("TOTAL_QTY_VALUE");
						taper_up_yn=  (String)addext_drugData.get("TAPER_UP")==null?"":(String)addext_drugData.get("TAPER_UP");
						taper_down_yn=  (String) addext_drugData.get("TAPER_DOSE_YN")==null?"":(String) addext_drugData.get("TAPER_DOSE_YN");
						ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");
						ext_total_qty_value=Float.parseFloat(total_qty_value.trim());
						if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
							if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no)){
								addext_drugData.put("INTERACTION_EXISTS", "N" );
								addext_drugData.put("INTR_MSG_CONTENT","");
								addext_drugData.put("INTR_RESTRIC_TRN","N");
								st_date_local = (String) hash.get("start_date");
								end_date_local =  (String) hash.get("end_date");
								if(!locale.equals("en")){
									st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
									end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
								}
								alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code, (String) addext_drugData.get("FORM_CODE"), (String) addext_drugData.get("GENERIC_ID"),st_date_local ,end_date_local , patient_id);
								if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
									severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
									intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
									addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
									addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
									addext_drugData.put("INTERACTION_EXISTS", "Y" );
									if(intr_restric_trn.equals("Y") ){
										temp.put("INTR_ALERT","Y");
										if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
											out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
										can_taper=false;
										break;
									}
								}
								else{
									addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
									addext_drugData.put("INTERACTION_REMARKS","");
								}
							}
						}
						if(taper_up_yn.equals("Y")||taper_down_yn.equals("Y"))
							multiFreq_yn = "N";
						else
							multiFreq_yn = "Y";
						if((!srlNo.equals(addext_srl_no)) && ((String)addext_drugData.get("TAPER_UP")).equals("N") && multiFreq_yn.equals("N")){
							if( (new_total_qty >= ext_total_qty_value)){
								can_taper=false;
								out.println("alertNoTaper('greater')") ;
								break;
							}
						}	
						else if((!srlNo.equals(addext_srl_no)) && multiFreq_yn.equals("N")){
							if(new_total_qty <= ext_total_qty_value){
								can_taper=false;
								out.println("alertNoTaper('lesser')") ;
								break;
							}
						}
						if((!srlNo.equals(addext_srl_no)) && freq.equals(freq_code) && qty_value.equals(qtyValue)){
							if(multiFreq_yn.equals("N")){
								can_taper=false;
								out.println("alertNoTaper('nochange')") ;
								break;
							}
							else{
								if((!srlNo.equals(addext_srl_no)) && split_dose_yn_val.equals("N")){
									can_taper=false;

									out.println("alertNoTaper('nochange')") ;
									break;
								}
								else{
									ArrayList	schedule_prev	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
									ArrayList	schedule_curr	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srl_no,"0");

									can_taper = false;
									for(int i=0;i<schedule_prev.size();i++){
										if(!((String)((HashMap)schedule_prev.get(i)).get("admin_qty")).equals((String)((HashMap)schedule_curr.get(i)).get("admin_qty"))){
											can_taper=true;
											break;
										}
									}
									if((!srlNo.equals(addext_srl_no)) && !can_taper ){
										out.println("alertNoTaper('nochange')") ;
										break;
									}
								}
							}
						}
						else{
							can_taper=true;
						}
					}
				}
				//chekcing the stock avail
				boolean no_stock_allow=true;
				if(can_taper){
					if( ph_version != null && !(ph_version.equals("PHBASIC"))){
						String consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
						if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
							ArrayList details=(ArrayList)bean.getpresDetails();
							String addext_durn_value	=	null;
							String addext_repeat_value	=	null;
							String addext_qty_value		=	null;
							for(int j=0;j<details.size();j++){
								addext_drugData=(HashMap) details.get(j);
								addext_drug_code=(String) addext_drugData.get("DRUG_CODE");
								addext_durn_value=(String) addext_drugData.get("DURN_VALUE");
								addext_repeat_value=(String) addext_drugData.get("REPEAT_VALUE");
								addext_qty_value=(String) addext_drugData.get("QTY_VALUE");
							}
							consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
							boolean no_stock_found				=	false;
							ArrayList prescriptionDetails		=	(ArrayList)bean.getpresDetails();
							String stock_available_yn			=	null;
							String allow_pres_without_stock_yn	=	null;
							for(int j=0;j<prescriptionDetails.size();j++){
								ext_drugData=(HashMap) prescriptionDetails.get(j);
								stock_available_yn = (String)ext_drugData.get("STOCK_AVAILABLE_YN");
								allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N":(String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
								if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
									if(allow_pres_without_stock_yn.equals("N")){
										if(stock_available_yn.equals("N")){
											no_stock_found=true;
											no_stock_allow	=	false;
											break;
										}
									}
								}
							}
							if(no_stock_found){
								out.println("alertNoAvailStock()") ;
							}
						}
					}
				}
				if(no_stock_allow){
					if(can_taper){
						ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
						String ext_srl_no			=	null;
						String freq_desc = "";
						String drug_tapered = "";
						String tapered_over = "";
						String allergy_yn="", limit_ind="", current_rx="", interaction_exists="", Override_remarks="";
						HashMap prev_extdrugData;
						for(int j=0;j<prescriptionDetails.size();j++){
							ext_drugData=(HashMap) prescriptionDetails.get(j);
							ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
							ext_srl_no=(String) ext_drugData.get("SRL_NO");
							if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
								new_qty=Float.parseFloat(qty_value);
								new_repeat_value=Integer.parseInt(repeat_value);
								durnValue	    =  (String) hash.get("durn_value");
								repeat_durn_type = (String) hash.get("repeat_durn_type");
								if(repeat_durn_type == null || repeat_durn_type.equals(""))
									repeat_durn_type = (String) hash.get("repeat_durn_type");
								durn_desc_code = (String) hash.get("durn_desc");
								if(durn_desc_code == null || durn_desc_code.equals(""))
									durn_desc_code = (String) hash.get("durn_desc");
								if(durnValue==null || durnValue.equals(""))
									durnValue = "1";
								interval_value		= (String)hash.get("interval_value");
								if(interval_value==null || interval_value.equals(""))
									interval_value = "1";
								durnValue =	(String)bean.getFreqDurnConvValue(repeat_durn_type,durnValue,durn_desc_code);
								new_total_qty=(new_qty*new_repeat_value*(Integer.parseInt(durnValue)/Integer.parseInt(interval_value)));
								ext_drugData.put("ROUTE_CODE",(String) hash.get("route_code"));
								ext_drugData.put("ROUTE_DESC",(String) hash.get("route_desc"));
								ext_drugData.put("DOSAGE_TYPE",(String) hash.get("dosage"));
								ext_drugData.put("FREQ_CODE",(String) hash.get("frequency"));
								ext_drugData.put("REPEAT_VALUE",repeat_value);
								ext_drugData.put("AMEND_YN","Y");
								ext_drugData.put("INTERVAL_VALUE",interval_value); 
								ext_drugData.put("FREQ_NATURE",(String) hash.get("freq_nature"));						
								ext_drugData.put("DURN_TYPE",(String) hash.get("repeat_durn_type"));
								ext_drugData.put("REPEAT_DURN_TYPE",(String) hash.get("repeat_durn_type"));
								freq_desc=(String) hash.get("freq_desc");
								freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
								ext_drugData.put("FREQ_DESC",freq_desc);
								ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
								String quantity_desc = (String) hash.get("qty_desc");
								quantity_desc = java.net.URLDecoder.decode(quantity_desc,"UTF-8");
								ext_drugData.put("QTY_DESC", quantity_desc);
								ext_drugData.put("OR_QTY_DESC",(String) hash.get("or_qty_desc"));
								ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
								String DURN_DESC = (String) hash.get("durn_desc");
								DURN_DESC = java.net.URLDecoder.decode(DURN_DESC,"UTF-8");
								ext_drugData.put("DURN_DESC",DURN_DESC);
								ext_drugData.put("freq_chng_durn_desc",(String) hash.get("durn_desc"));								
								ext_drugData.put("TAPPERED_OVER","Y");
								ext_drugData.put("TOTTAPPERQTY",(String) hash.get("totTapperQty"));   
								ext_drugData.put("PREVTOTTAPPERQTY",(String) hash.get("prevTotalTaperQty"));  
								ext_drugData.put("TAP_LVL_QTY",(String) hash.get("tap_lvl_qty"));  
								ext_drugData.put("TOTAL_QTY_VALUE",""+new_total_qty); 
								ext_drugData.put("DOSE_OVERRIDE",(String) hash.get("dose_override"));
								ext_drugData.put("QTY_DESC_CODE",(String) hash.get("qty_desc"));
								ext_drugData.put("OR_DURN_DESC",(String) hash.get("or_durn_desc"));
								ext_drugData.put("SPLIT_DOSE",(String) hash.get("split_dose"));
								ext_drugData.put("SPLIT_DOSE_YN",(String) hash.get("split_dose_yn"));
								ext_drugData.put("SPLIT_DOSE_YN_VAL",(String) hash.get("split_dose_yn_val"));
								ext_drugData.put("START_DATE",(String) hash.get("start_date"));
								ext_drugData.put("END_DATE",(String) hash.get("end_date"));
								ext_drugData.put("AUTH_YN_VAL",(String) hash.get("authroize_yn_val"));
								ext_drugData.put("APPROVAL_YN_VAL",(String) hash.get("approval_yn_val"));
								ext_drugData.put("COSIGN_YN_VAL",(String) hash.get("cosign_yn_val"));
								ext_drugData.put("ALLOW_REFILL",(String) hash.get("allow_refill"));
								ext_drugData.put("NO_REFILL",(String) hash.get("no_refill"));
								ext_drugData.put("REFILL_START_DATE",(String) hash.get("refill_start_date"));
								ext_drugData.put("REFILL_END_DATE",(String) hash.get("refill_end_date"));
								ext_drugData.put("ADMIN_TIME",(String) hash.get("admin_time"));
								ext_drugData.put("ADMIN_QTY",(String) hash.get("admin_qty"));
								ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("dflt_qty_uom"));
								ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("in_dispensed_uom"));
								ext_drugData.put("TOT_STRENGTH",(String) hash.get("in_total_strength"));
								ext_drugData.put("TOT_STRENGTH_UOM",(String) hash.get("in_total_strength_uom"));
								ext_drugData.put("DISPENSED_QTY",(String) hash.get("in_dispensed_qty"));
								ext_drugData.put("DISPENSED_UOM",(String) hash.get("in_dispensed_uom"));
								ext_drugData.put("BMS_QTY",(String) hash.get("in_bms_qty"));
								ext_drugData.put("SCH_OVER_YN",(String) hash.get("sch_over_yn"));
								ext_drugData.put("TRADE_CODE",trade_code);
								ext_drugData.put("TRADE_NAME",trade_name);
								ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
								ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
								ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); 
								ext_drugData.put("BUILDMAR_YN",buildMAR_yn);
								ext_drugData.put("DrugRemarksEntered",DrugRemarksEntered); 
								ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks); 
								ext_drugData.put("PREG_REMARKS",preg_remarks); 
								if(ext_drugData.containsKey("TAP_LVL_QTY"))   
									ext_drugData.put("TAP_LVL_QTY",(String) hash.get("tap_lvl_qty")); 
								allergy_yn  =(String) hash.get("allergy_yn")==null?"N":(String) hash.get("allergy_yn");
								limit_ind  =(String) hash.get("limit_ind")==null?"N":(String) hash.get("limit_ind");
								current_rx  =(String) hash.get("current_rx")==null?"":(String) hash.get("current_rx");
								interaction_exists  =(String) hash.get("interaction_exists")==null?"":(String) hash.get("interaction_exists"); 
								if(override_check.equals("Y") && !checkEnabled.equals("disabled")){
									Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
									if(current_rx.equals("Y")){
										ext_drugData.put("CURRENTRX_OVERRIDE","Y");
										ext_drugData.put("CURRENTRX_REMARKS",Override_remarks);
									}
									if(limit_ind.equals("N")){
										ext_drugData.put("DOSE_OVERRIDE","Y");
										ext_drugData.put("DOSE_REMARKS",Override_remarks);
									}
									if( allergy_yn.equals("Y")){
										ext_drugData.put("ALLERGY_OVERRIDE","Y");
										ext_drugData.put("ALLERGY_REMARKS",Override_remarks);
									}
									if( interaction_exists.equals("Y")){ 
										ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
										ext_drugData.put("INTERACTION_REMARKS",Override_remarks);
									} 
									ext_drugData.put("Override_Check",override_check);
								}
								break;
							}
						}
						tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
						if(tapered_over.equals("Y")){
							for(int j=0;j<prescriptionDetails.size();j++){
								prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
								ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
								ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
								if(prev_extdrugData!=null){
									if(drugCode.equals(ext_drug_code) &&! (String.valueOf(srl_no)).equals(ext_srl_no)){
										if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))) {
											prev_extdrugData.put("DRUG_TAPERED_YN","Y");
											prev_extdrugData.put("TOTTAPPERQTY",(String)ext_drugData.get("TOTTAPPERQTY")==null?"1":(String)ext_drugData.get("TOTTAPPERQTY"));	 
											prev_extdrugData.put("BL_ERROR_CODE",(String)ext_drugData.get("BL_ERROR_CODE")==null?"":(String)ext_drugData.get("BL_ERROR_CODE"));
											prev_extdrugData.put("BL_SYS_MESSAGE_ID",(String)ext_drugData.get("BL_SYS_MESSAGE_ID")==null?"":(String)ext_drugData.get("BL_SYS_MESSAGE_ID"));                        
											prev_extdrugData.put("BL_ERROR_TEXT",(String)ext_drugData.get("BL_ERROR_TEXT")==null?"":(String)ext_drugData.get("BL_ERROR_TEXT"));  
										}
									}
								}
							}
						}
					}
				}
			}
			else if(oper_mode.equals("modify") || oper_mode.equals("tapered") ){
				ext_drugData		=	null;
				String drug_code			=	null;
				String allow_pres_without_stock_yn	=	null;
				ext_drug_code	=	null;
				String ext_srl_no		=	null;
				String drug_tapered, tapered_over;
				String drugCode			= (String)hash.get("drug_code");
				String srlNo			= (String)hash.get("srl_no");
				String durn_value		= ((String)hash.get("durn_value")).trim();
				String qty_value		= ((String)hash.get("qty_value")).trim();
				String freq				= (String)hash.get("frequency");
				String freq_desc        = (String) hash.get("freq_desc");
				freq_desc 				= java.net.URLDecoder.decode(freq_desc,"UTF-8");
				String repeat_value		= (String)hash.get("repeat_value");
				String dosage			= ((String)hash.get("dosage")).trim();
				String pres_base_uom	= (String)hash.get("pres_base_uom");
				String qty_desc_code	= (String)hash.get("qty_desc");
				String ph_version		= (String)hash.get("ph_version");
				String end_date			= (String)hash.get("end_date");
				String start_date		= (String)hash.get("start_date");
				String dosage_type		= (String) hash.get( "dosage_type" );
				String absol_qty		= (String) hash.get("absol_qty");
				String brought_by_pat	= (String) hash.get("brought_by_pat");
				String freq_nature		= (String) hash.get("freq_nature");
				String current_rx		= (String) hash.get("current_rx");
				String allow_duplicate	= (String) hash.get("allow_duplicate");
				String patient_class	= (String) hash.get("patient_class");
				String take_home		= (String) hash.get("take_home");
				String pat_counseling_reqd	=( ((String)hash.get("pat_counseling_reqd")) ==null)?"N":(String)hash.get("pat_counseling_reqd") ;
				String override_check		= (String) hash.get("override_remarks");
				String checkEnabled			= (String) hash.get("checkEnabled");
				String disp_locn_code		= (String)hash.get("disp_locn_code");
				String drug_db_dosecheck_yn  = (String)hash.get("drug_db_dosecheck_yn")==null?"":(String)hash.get("drug_db_dosecheck_yn");
				ext_prod_id			 = (String)hash.get("ext_prod_id")==null?"":(String)hash.get("ext_prod_id");
				String pract_name			 = (String) hash.get("pract_name");
				if(!locale.equals("en")){
					end_date = DateUtils.convertDate(end_date, "DMYHM",locale,"en");
					start_date = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
				}
				if(repeat_value==null || repeat_value.equals(""))
					repeat_value="1";
				int drug_index=0;
				boolean can_modify	= true;
				if(oper_mode.equals("tapered")){
					new_qty			    =	Float.parseFloat(qty_value);
					new_repeat_value	=	Integer.parseInt(repeat_value);
					if(split_dose_yn_val!=null && !split_dose_yn_val.equals("Y"))
						new_total_qty	=	(new_qty*new_repeat_value);
					else 
						new_total_qty = new_qty;
					int srl_no				= bean.getSrlNo()-1;
					durnValue		=	"";    
					freq_code		=	"";    
					qtyValue			=	"";
					total_qty_value	=	"";
					for(int j=0;j<addprescriptionDetails.size();j++){
						addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
						addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
						addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
						ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");
						if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
							if( drugCode.equals(addext_drug_code) && srlNo.equals(addext_srl_no)){
								addext_drugData.put("INTERACTION_EXISTS", "N" );
								addext_drugData.put("INTR_RESTRIC_TRN","N");
								st_date_local = (String) hash.get("start_date");
								end_date_local =  (String) hash.get("end_date");
								if(!locale.equals("en")){
									st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
									end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
								}
								alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code,  (String) addext_drugData.get("FORM_CODE"),(String) addext_drugData.get("GENERIC_ID"),st_date_local,end_date_local , patient_id);
								if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
									severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
									intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
									addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
									addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
									addext_drugData.put("INTERACTION_EXISTS", "Y" );
									if(intr_restric_trn.equals("Y") ){
										addext_drugData.put("INTR_ALERT","Y");
										if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
											out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
										can_modify=false;
										break;
									}
								}
								else{
									addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
									addext_drugData.put("INTERACTION_REMARKS","");
								}
							}
						}
					}
					if(can_modify){ 
						for(int j=0;j<addprescriptionDetails.size();j++){
							addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
							addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
							addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
							if( drugCode.equals(addext_drug_code) && (Float.parseFloat(srlNo) == (Float.parseFloat(addext_srl_no))+1) ){
								durnValue	    =  (String) addext_drugData.get("DURN_VALUE");
								freq_code	    =  (String) addext_drugData.get("FREQ_CODE");
								qtyValue	    =  (String) addext_drugData.get("QTY_VALUE");
								total_qty_value =  (String) addext_drugData.get("TOTAL_QTY_VALUE");
								ext_total_qty_value   = Float.parseFloat(total_qty_value.trim());
								taper_up_yn					=  (String)addext_drugData.get("TAPER_UP")==null?"":(String)addext_drugData.get("TAPER_UP");
								taper_down_yn				=  (String) addext_drugData.get("TAPER_DOSE_YN")==null?"":(String) addext_drugData.get("TAPER_DOSE_YN");
								if(taper_up_yn.equals("Y")||taper_down_yn.equals("Y"))
									multiFreq_yn = "N";
								else
									multiFreq_yn = "Y";
								if(((String) addext_drugData.get("TAPER_UP")).equals("N") && multiFreq_yn.equals("N")){
									if( (new_total_qty >= ext_total_qty_value)){
										can_modify=false;
										out.println("alertNoTaper('greater')") ;
										break;
									}
								}	
								else if (multiFreq_yn.equals("N")){
									if( (new_total_qty <= ext_total_qty_value)){
										can_modify=false;
										out.println("alertNoTaper('lesser')") ;
										break;
									}
								}
								if(freq.equals(freq_code) && qty_value.equals(qtyValue) ){
									if(multiFreq_yn.equals("N")){
										can_modify=false;
										out.println("alertNoTaper('nochange')") ;
										break;
									}
									else{
										if(split_dose_yn_val.equals("N")){
											can_modify=false;
											out.println("alertNoTaper('nochange')") ;
											break;
										}
										else{
											ArrayList	schedule_prev	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
											ArrayList	schedule_curr	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srl_no,"0");

											can_modify = false;
											for(int i=0;i<schedule_prev.size();i++){
												if(!((String)((HashMap)schedule_prev.get(i)).get("admin_qty")).equals((String)((HashMap)schedule_curr.get(i)).get("admin_qty"))){
													can_modify=true;
													break;
												}
											}
											if(!can_modify){
												out.println("alertNoTaper('nochange')") ;
												break;
											}
										}
									}
								}
								else{
									can_modify=true;
								}
								break;
							}
						}
					} 
				}
				String durn_Value="", freq_chng_durn_value="", freq_chng_durn_desc="";  
				if(oper_mode.equals("modify") && order_set_code.equals("")){
					for(int j=0;j<addprescriptionDetails.size();j++){
						addext_drugData		=	(HashMap) addprescriptionDetails.get(j);
						addext_drug_code	=	(String) addext_drugData.get("DRUG_CODE");
						addext_srl_no		=	(String) addext_drugData.get("SRL_NO");
						ext_prod_id=  (String) addext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) addext_drugData.get("EXTERNAL_PRODUCT_ID");
						if( drugCode.equals(addext_drug_code) && !((String.valueOf(srlNo)).equals(addext_srl_no))){
								if(addext_drugData.containsKey("FREQ_NATURE")){
									String exist_drug_freq_nature = (String)addext_drugData.get("FREQ_NATURE")==null?"":(String)addext_drugData.get("FREQ_NATURE");
									if((freq_nature.equals("P") || freq_nature.equals("O")) && (exist_drug_freq_nature.equals("P") || exist_drug_freq_nature.equals("O")) && (freq_nature.equals(exist_drug_freq_nature))){										
										out.println("alertNoTaper('changefreq');");
										break;
									}
								}
							}
							if( drugCode.equals(addext_drug_code) && ((String.valueOf(srlNo)).equals(addext_srl_no))){
								durn_Value = (String)addext_drugData.get("DURN_VALUE")==null?"": (String)addext_drugData.get("DURN_VALUE"); 
								repeat_durn_type = (String)addext_drugData.get("REPEAT_DURN_TYPE")==null?"": (String)addext_drugData.get("REPEAT_DURN_TYPE"); 
								freq_chng_durn_value = (String)addext_drugData.get("freq_chng_durn_value")==null?"": (String)addext_drugData.get("freq_chng_durn_value");
								freq_chng_durn_desc = (String)addext_drugData.get("freq_chng_durn_desc")==null?"": (String)addext_drugData.get("freq_chng_durn_desc");
								if(repeat_durn_type.equals(freq_chng_durn_desc) && !durn_Value.equals(freq_chng_durn_value)){
									System.err.println("==Confirm==DRUG_CODE===>"+drug_code+" repeat_durn_type="+repeat_durn_type+" freq_chng_durn_desc="+freq_chng_durn_desc+" durn_Value="+durn_Value+" freq_chng_durn_value="+freq_chng_durn_value);
									out.println("showToastMsg('Duration value is not updated. Kindly check the duration.');");
									return;
								} 
							}
							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
								if( drugCode.equals(addext_drug_code) && ((String.valueOf(srlNo)).equals(addext_srl_no))){
									addext_drugData.put("INTERACTION_EXISTS", "N" );
									addext_drugData.put("INTR_MSG_CONTENT","");
									addext_drugData.put("INTR_RESTRIC_TRN","N");
									st_date_local = (String) hash.get("start_date");
									end_date_local =  (String) hash.get("end_date");
									if(!locale.equals("en")){
										st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
										end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
									}
									alDrugIntrDtlList = bean.getDrugInteractionDtls(addext_drug_code, (String) addext_drugData.get("FORM_CODE"), (String) addext_drugData.get("GENERIC_ID"),st_date_local,end_date_local , patient_id);
									if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
										severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2);
										intr_restric_trn = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
										addext_drugData.put("INTR_RESTRIC_TRN", intr_restric_trn );
										addext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
										addext_drugData.put("INTERACTION_EXISTS", "Y" );
										if(intr_restric_trn.equals("Y") ){
											addext_drugData.put("INTR_ALERT","Y");
											if(addext_drugData.get("AMEND_YN")!=null && ((String)addext_drugData.get("AMEND_YN")).equals("Y"))
												out.println("alertIntr('"+drugCode+"','"+srlNo+"','"+patient_id+"','"+encounter_id+"','N');");
											can_modify=false;
											break;
										}
									}
									else{
										addext_drugData.put("DRUGINTRACTION_OVERRIDE","N");
										addext_drugData.put("INTERACTION_REMARKS","");
									}
								}
							}
					}
				}				
				if(can_modify){
					if(pract_name==null && pract_name.equals("null"))
						pract_name="";
					if(override_check==null)
						override_check="";
					if(checkEnabled==null)
						checkEnabled="";
					if(brought_by_pat == null) {
						brought_by_pat		=	"";
					} 
					if(absol_qty == null || absol_qty == "")
						 absol_qty		=	"1";
					if(current_rx.equals("Y") && allow_duplicate.equals("N") && !freq_nature.equals("O")) { 
						out.println("duplicateWarning()");
						return;
					}
					ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drugCode+srlNo,"0");
					String sch_size			=	"";
					if(schedule.size() > 0) {
						 ArrayList dose_list		= (ArrayList)schedule.get(4);
						 if(dose_list!=null && dose_list.size()>0)
							 qty_value		= (String)dose_list.get(0);
						 sch_size		=	""+dose_list.size();
					}
					else {
						sch_size		=	repeat_value;
					}
					boolean no_stock_allow=true;
					if( !(ph_version.equals("PHBASIC"))){
						bean.setDispLocation(srlNo,disp_locn_code);
						String consider_stock_for_pres_yn=(String)hash.get("consider_stock_for_pres_yn");
						if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
							boolean no_stock_found	=	false;
							String conv_factor		=	"";
							ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
							if(dosage_type.equals("Q"))
								conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
							String available_stock;HashMap stockValues = null;
							for(int j=0;j<prescriptionDetails.size();j++){
								ext_drugData		=(HashMap) prescriptionDetails.get(j);
								drug_code			=(String) ext_drugData.get("DRUG_CODE");
								allow_pres_without_stock_yn = (String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN")==null?"N":(String)ext_drugData.get("ALLOW_PRES_WITHOUT_STOCK_YN");
								if(drugCode.equals(drug_code)){
									if(((String)ext_drugData.get("IN_FORMULARY_YN")).equals("Y")) {
										if(consider_stock_for_pres_yn != null && consider_stock_for_pres_yn.equals("Y")){
											if(allow_pres_without_stock_yn.equals("N")){
												stockValues			=(HashMap) bean.chkStockAvail(drugCode,disp_locn_code,qty_value,end_date, trade_code);
												available_stock		=(String) stockValues.get("AVAILABLE_STOCK");
												if(dosage_type.equals("A") || freq_nature.equals("P")) {
													qty_value	=	absol_qty;
													dosage		=	"A";
												}
												if(Float.parseFloat(getOrderQty(ext_drugData,qty_value,sch_size,durn_value,dosage,conv_factor)) > Float.parseFloat(available_stock)) {
													no_stock_allow=false;
													out.println("alertNoAvailStock('"+available_stock+"','"+(String)hash.get("stock_uom")+"')") ;
													break;
												}
											}
										}
									}
								}
							}
							if(no_stock_found){
								out.println("alertNoAvailStock()") ;
							} 
						}
						else{
							no_stock_allow=true;
						}
					}
					else{
						no_stock_allow=true;
					}
					if(no_stock_allow){
						new_qty=Float.parseFloat(qty_value);
						new_repeat_value=Integer.parseInt(repeat_value);
						durnValue	    =  hash.get("durn_value")==null?"1":(String) hash.get("durn_value");
						repeat_durn_type =hash.get("repeat_durn_type")==null?"":(String) hash.get("repeat_durn_type");
						durn_desc_code =hash.get("durn_desc")==null?"":(String) hash.get("durn_desc");
						interval_value		= hash.get("interval_value")==null?"1":(String) hash.get("interval_value");
						durnValue =	(String)bean.getFreqDurnConvValue(repeat_durn_type,durnValue,durn_desc_code);
						new_total_qty=new_qty*new_repeat_value*(Integer.parseInt(durnValue)/Integer.parseInt(interval_value)); 
						int codeCount_1		= 0;
						int codeCount_2		= 0;
						ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
						can_modify	= false;
						for(int j=0;j<prescriptionDetails.size();j++){
							ext_drugData=(HashMap) prescriptionDetails.get(j);
							ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
							ext_srl_no=(String) ext_drugData.get("SRL_NO");
							if(drugCode.equals(ext_drug_code)){
								codeCount_1++;
							}
							if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no))
								drug_index = j;
						}
						if(codeCount_1>1){
							for(int k=drug_index;k<prescriptionDetails.size();k++){
								ext_drugData=(HashMap) prescriptionDetails.get(k);
								ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
								if(drugCode.equals(ext_drug_code)){
									codeCount_2++;
								}
							}
						}
						if(codeCount_1>1 && codeCount_2!=1 && order_set_code.equals("") && !totalTaperQtyDisplay.equals("Y")){
							can_modify=false;
							out.println("alertParentRecord('modify')") ;
						}
						else{
							can_modify=true;
						}
						if(can_modify){
							prescriptionDetails=(ArrayList)bean.getpresDetails();
							HashMap prev_extdrugData;
							boolean dupCheck = false;
							String interaction_exists="", allergy_yn="", limit_ind="", Override_remarks="", drug_db_duptherapy_flag="";
							for(int j=0;j<prescriptionDetails.size();j++){
								ext_drugData	=	(HashMap) prescriptionDetails.get(j);
								ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
								ext_srl_no		=	(String) ext_drugData.get("SRL_NO");
								ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");
								if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
									ext_drugData.put("AMEND_YN","Y");
									ext_drugData.put("ROUTE_CODE",(String) hash.get("route_code"));
									ext_drugData.put("PRIORITY",(String) hash.get("priority"));
									ext_drugData.put("BROUGHT_BY_PAT",brought_by_pat);
									ext_drugData.put("FREQ_NATURE",(String) hash.get("freq_nature"));
									ext_drugData.put("ROUTE_DESC",(String) hash.get("route_desc"));
									ext_drugData.put("DOSAGE_TYPE",(String) hash.get("dosage"));
									ext_drugData.put("FREQ_CODE",(String) hash.get("frequency"));
									ext_drugData.put("FREQ_DESC",(String) freq_desc);
									ext_drugData.put("QTY_VALUE",(String) hash.get("qty_value"));
									String quantity_desc = (String) hash.get("qty_desc");
									quantity_desc = java.net.URLDecoder.decode(quantity_desc,"UTF-8");
									ext_drugData.put("QTY_DESC", quantity_desc);
									ext_drugData.put("QTY_DESC_CODE",(String) hash.get("qty_desc_code"));
									ext_drugData.put("REPEAT_VALUE",repeat_value);
									ext_drugData.put("INTERVAL_VALUE",interval_value);
									ext_drugData.put("DURN_TYPE",(String) hash.get("repeat_durn_type"));
									ext_drugData.put("REPEAT_DURN_TYPE",(String) hash.get("repeat_durn_type"));
									ext_drugData.put("DURN_VALUE",(String) hash.get("durn_value"));
									String DURN_DESC = (String)hash.get("durn_desc");
									DURN_DESC = java.net.URLDecoder.decode(DURN_DESC,"UTF-8");
									ext_drugData.put("DURN_DESC", DURN_DESC);
									ext_drugData.put("freq_chng_durn_desc",(String) hash.get("durn_desc"));							
									ext_drugData.put("SPLIT_DOSE",(String) hash.get("split_dose"));
									ext_drugData.put("SPLIT_DOSE_YN",(String) hash.get("split_dose_yn"));
									ext_drugData.put("SPLIT_DOSE_YN_VAL",(String) hash.get("split_dose_yn_val"));
									ext_drugData.put("TRADE_CODE",trade_code);
									ext_drugData.put("TRADE_NAME",trade_name);
									ext_drugData.put("BUILDMAR_YN",(String) hash.get("buildMAR_yn"));
									ext_drugData.put("DrugRemarksEntered",(String) hash.get("DrugRemarksEntered")); 
									ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks); 
									ext_drugData.put("PREG_REMARKS",preg_remarks);
									interaction_exists  =(String) ext_drugData.get("INTERACTION_EXISTS")==null?"N":(String) ext_drugData.get("INTERACTION_EXISTS"); 
									allergy_yn  =(String) ext_drugData.get("ALLERGY_YN")==null?"N":(String) ext_drugData.get("ALLERGY_YN");
									limit_ind  =(String) ext_drugData.get("LIMIT_IND")==null?"N":(String) ext_drugData.get("LIMIT_IND");
									current_rx  =(String) ext_drugData.get("CURRENT_RX")==null?"":(String) ext_drugData.get("CURRENT_RX");
									drug_db_duptherapy_flag  = ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String) ext_drugData.get("DRUG_DB_DUPTHERAPY_FLAG");
									Override_remarks="";
									if(!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || drug_db_duptherapy_yn.equals("N")){
										dupCheck = presBean.checkDuplicateDrug(patient_id, (String) ext_drugData.get("GENERIC_ID"), start_date,end_date, (String) hash.get("frequency"),"");
										if(!dupCheck && ext_drugData.get("ALERT_YN")==null){
											ext_drugData.put("CURRENT_RX","N");
										}
										if( (ext_drugData.get("ALERT_YN")!=null && (ext_drugData.get("CURRENTRX_REMARKS")==null || ((String)ext_drugData.get("CURRENTRX_REMARKS")).equals("") ) ) || dupCheck) {
											if(dupCheck){
												ext_drugData.put("CURRENT_RX","Y");
											}
											if(bean.getCancelDiscConDupOrders().equals("Y") && ((bean.getExternalpatient_id()==null) || (bean.getExternalpatient_id().equals("") )) && ext_drugData.get("ORIG_CURRENT_RX")!=null && (((String)ext_drugData.get("ORIG_CURRENT_RX")).equals("Y") || drug_db_duptherapy_flag.equals("Y")) && dupCheck) { 
												ext_drugData.put("ORIG_CURRENT_RX","Y");
												out.println("enableDiscCancelOrders('"+patient_id+"', '"+encounter_id+"', '"+(String) ext_drugData.get("GENERIC_ID")+"', '"+start_date+"', '"+end_date+"', '"+(String) hash.get("frequency")+"', '"+drugCode+"', '"+srlNo+"', '"+drug_db_interface_yn+"', '"+ext_prod_id+"', 'C', '"+(String) hash.get("sliding_scale_yn")+"');");
											}
										}
										if(override_check.equals("Y") && !checkEnabled.equals("disabled")){											
											if(current_rx.equals("Y")){
												Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
												if(Override_remarks==null || Override_remarks.equals(""))
													Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
												 ext_drugData.put("CURRENTRX_OVERRIDE","Y");
												 ext_drugData.put("CURRENTRX_REMARKS",Override_remarks);
											}
											if(limit_ind.equals("N")){
												Override_remarks=(String)ext_drugData.get("DOSE_REMARKS");
												if(Override_remarks==null || Override_remarks.equals(""))
													Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
												ext_drugData.put("DOSE_OVERRIDE","Y");
												ext_drugData.put("DOSE_REMARKS",Override_remarks);
											}
											if( allergy_yn.equals("Y")){
												Override_remarks=(String)ext_drugData.get("ALLERGY_REMARKS");
												if(Override_remarks==null || Override_remarks.equals(""))
													Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
												ext_drugData.put("ALLERGY_OVERRIDE","Y");
												ext_drugData.put("ALLERGY_REMARKS",Override_remarks);
											}
											if( interaction_exists.equals("Y") && (ext_drugData.get("DRUGINTRACTION_OVERRIDE")==null || !((String)ext_drugData.get("DRUGINTRACTION_OVERRIDE")).equals("Y"))){
												if(Override_remarks==null || Override_remarks.equals(""))
													Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
												ext_drugData.put("DRUGINTRACTION_OVERRIDE","Y");
												ext_drugData.put("INTERACTION_REMARKS",Override_remarks);
											} 
											ext_drugData.put("Override_Check",override_check);
										}
									}												
									else if(ext_drugData.get("ATC_DUP_DRUG_CODE")!=null && !ext_drugData.get("ATC_DUP_DRUG_CODE").equals("")){ 
										Override_remarks=(String)ext_drugData.get("CURRENTRX_REMARKS");
										if(override_check.equals("Y") && !checkEnabled.equals("disabled")){
											if(Override_remarks==null || Override_remarks.equals("")){
												Override_remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverriddenBy.label", "ph_labels")+" "+java.net.URLDecoder.decode(pract_name,"UTF-8");
											}
											ext_drugData.put("CURRENTRX_OVERRIDE","Y");
											ext_drugData.put("CURRENTRX_REMARKS",Override_remarks);
										}
										ext_drugData.put("Override_Check",override_check);
									}
									if( !current_rx.equals("Y") && !interaction_exists.equals("Y") && !allergy_yn.equals("Y") && !limit_ind.equals("N")){ //override_check.equals("Y") && removed for ML-BRU-SCF-1423 [IN:050857]
										ext_drugData.put("Override_Check","N");
									} 
									ext_drugData.put("START_DATE",(String) hash.get("start_date"));
									ext_drugData.put("END_DATE",(String) hash.get("end_date"));
									ext_drugData.put("OR_QTY_DESC",(String) hash.get("or_qty_desc"));
									ext_drugData.put("DFLT_QTY_UOM",(String) hash.get("dflt_qty_uom"));
									ext_drugData.put("SCHEDULED_YN",(String) hash.get("scheduled_yn"));
									ext_drugData.put("AUTH_YN_VAL",(String) hash.get("authroize_yn_val"));
									ext_drugData.put("APPROVAL_YN_VAL",(String) hash.get("approval_yn_val"));
									ext_drugData.put("COSIGN_YN_VAL",(String) hash.get("cosign_yn_val"));
									ext_drugData.put("ALLOW_REFILL",(String) hash.get("allow_refill"));
									ext_drugData.put("NO_REFILL",(String) hash.get("no_refill"));
									ext_drugData.put("REFILL_START_DATE",(String) hash.get("refill_start_date"));
									ext_drugData.put("REFILL_END_DATE",(String) hash.get("refill_end_date"));
									ext_drugData.put("ADMIN_TIME",(String) hash.get("admin_time"));
									ext_drugData.put("ADMIN_QTY",(String) hash.get("admin_qty"));
									ext_drugData.put("TOTAL_QTY_VALUE",""+new_total_qty);
									ext_drugData.put("TOT_STRENGTH",(String) hash.get("in_total_strength"));
									ext_drugData.put("TOT_STRENGTH_UOM",(String) hash.get("in_total_strength_uom"));
									ext_drugData.put("DISPENSED_QTY",(String) hash.get("in_dispensed_qty"));
									ext_drugData.put("DISPENSED_UOM",(String) hash.get("in_dispensed_uom"));
									ext_drugData.put("BMS_QTY",(String) hash.get("in_bms_qty"));
									ext_drugData.put("SCH_OVER_YN",(String) hash.get("sch_over_yn"));
									ext_drugData.put("LIMIT_IND",(String) hash.get("limit_ind"));
									ext_drugData.put("MONO_GRAPH",(String) hash.get("mono_graph"));
									ext_drugData.put("UNIT_DOSE",(String) hash.get("unit_dose"));
									ext_drugData.put("DAILY_DOSE",(String) hash.get("daily_dose"));
									ext_drugData.put("ABSOL_QTY",absol_qty);
									ext_drugData.put("STOCK_AVAILABLE_YN","Y");
									ext_drugData.put("PAT_COUNSELING_REQD",pat_counseling_reqd);
									ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
									ext_drugData.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_reason_desc);
									ext_drugData.put("DrugRemarksEntered",DrugRemarksEntered); 
									ext_drugData.put("TOTTAPPERQTY",(String) hash.get("totTapperQty"));  
									ext_drugData.put("PREVTOTTAPPERQTY",(String) hash.get("prevTotalTaperQty"));
									ext_drugData.put("TAP_LVL_QTY",hash.get("tap_lvl_qty").toString());
									ext_drugData.put("DRUG_INDICATION",DrugIndicationRemarks);
									ext_drugData.put("PREG_REMARKS",preg_remarks);
									ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND",bl_override_excl_incl_ind); 
									if( bean.getExternalpatient_id()!=null &&  !((String)bean.getExternalpatient_id()).equals("") )
										ext_drugData.put("DISP_LOCN_CODE",(String) hash.get("disp_locn_code"));
									if( (!((String) hash.get("dosage")).equals("A"))&&(ext_drugData.get("TAPER_DOSE_YN").equals("Y")|| ext_drugData.get("TAPER_UP").equals("Y"))&&(!(ext_drugData.get("FREQ_NATURE").equals("P")||ext_drugData.get("FREQ_NATURE").equals("O"))))
										ext_drugData.put("PROVIDE_TAPER","Y");
									else
										ext_drugData.put("PROVIDE_TAPER","N");
									break;
								}
							}
							tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
							if(tapered_over.equals("Y")){
								for(int j=0;j<prescriptionDetails.size();j++){
									prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
									ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
									ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
									if(prev_extdrugData!=null){
										if(drugCode.equals(ext_drug_code) && !srlNo.equals(ext_srl_no)){
											if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
												prev_extdrugData.put("DRUG_TAPERED_YN","Y");   
												prev_extdrugData.put("TOTTAPPERQTY",(String)ext_drugData.get("TOTTAPPERQTY")==null?"1":(String)ext_drugData.get("TOTTAPPERQTY"));
												prev_extdrugData.put("BL_ERROR_CODE",(String)ext_drugData.get("BL_ERROR_CODE")==null?"":(String)ext_drugData.get("BL_ERROR_CODE"));	prev_extdrugData.put("BL_SYS_MESSAGE_ID",(String)ext_drugData.get("BL_SYS_MESSAGE_ID")==null?"":(String)ext_drugData.get("BL_SYS_MESSAGE_ID"));                        
												prev_extdrugData.put("BL_ERROR_TEXT",(String)ext_drugData.get("BL_ERROR_TEXT")==null?"":(String)ext_drugData.get("BL_ERROR_TEXT"));     
											}
										}
									}
								}
							}
						}
					}
					schedule	=	null;
				}
			}
			else if(oper_mode.equals("delete")){
				String drugCode		= (String)hash.get("drug_code");
				String srlNo		= (String)hash.get("srl_no");
				String generic_id		= (String)hash.get("generic_id");
				int sno= 0;
				if(srlNo!=null && srlNo.trim().length()>0)
					sno  = Integer.parseInt(srlNo);
				String called_from	= (String)hash.get("called_from")==null?"":(String)hash.get("called_from");
				String search_bean_id	="@DrugSearchBean"+patient_id+encounter_id;
				String search_bean_name	="ePH.DrugSearchBean";
				drugCode = drugCode.trim();
				srlNo = srlNo.trim();
				int drug_index	=	-1;
				String temp_freq_nature="";
				DrugSearchBean searchbean = (DrugSearchBean)PersistenceHelper.getBeanObject( search_bean_id, search_bean_name , request) ;
				int remove_pos	=	0;
				ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
				int codeCount_1=0;
				int codeCount_2=0;
				ext_drugData	=	null;
				ext_drug_code	=	null;
				String ext_srl_no		=	null;
				String curr_yn    = "";
				ArrayList atc_dup_drug_code = new ArrayList();
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData      =  (HashMap) prescriptionDetails.get(j);
					curr_yn			  = "";
					if(ext_drugData.containsKey("ATC_DUP_DRUG_CODE")){
						atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(drugCode)){
							atc_dup_drug_code.remove(drugCode);
						}
						if(ext_drugData.get("GENERIC_ID").equals(generic_id))
							atc_dup_drug_code.clear();
						
						if(!(atc_dup_drug_code.size()>0)) {
							ext_drugData.put("CURRENT_RX",curr_yn);
							ext_drugData.put("ATC_LEVEL_DUPLICATION","N");
							ext_drugData.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							ext_drugData.put("CURRENTRX_REMARKS","");
							if(ext_drugData.containsKey("ALERT_YN"))
								ext_drugData.remove("ALERT_YN");
						}
					}
					if(ext_drugData.containsKey("ATC_LEVEL4_DUP_DRUG_CODE")){
						atc_dup_drug_code  =  (ArrayList) ext_drugData.get("ATC_LEVEL4_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.contains(drugCode)){
							atc_dup_drug_code.remove(drugCode);
						}
						if(!(atc_dup_drug_code.size()>0))	{
							ext_drugData.put("CURRENT_RX",curr_yn);
							ext_drugData.put("ATC_LEVEL4_DUPLICATION","N");
							ext_drugData.put("ATC_LEVEL4_DUP_DRUG_CODE",atc_dup_drug_code);
							ext_drugData.put("CURRENTRX_REMARKS","");
							if(ext_drugData.containsKey("ALERT_YN"))
								ext_drugData.remove("ALERT_YN");
						}
					}
				}
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no=(String) ext_drugData.get("SRL_NO");
					temp_freq_nature = ext_drugData.get("FREQ_NATURE")==null?"": (String) ext_drugData.get("FREQ_NATURE");
					if( !(temp_freq_nature.equals("P") || temp_freq_nature.equals("O"))){
						if(drugCode.equals(ext_drug_code)){
							codeCount_1++;
						}
						if(drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no))
							drug_index = j;
					}
				}
				if(codeCount_1>1){
					for(int k=drug_index; k<prescriptionDetails.size();k++){
						ext_drugData=(HashMap) prescriptionDetails.get(k);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						if(drugCode.equals(ext_drug_code)){
							codeCount_2++;
						}
					}
				}
				for(int h=0;h<prescriptionDetails.size();h++){
					ext_drugData=(HashMap) prescriptionDetails.get(h);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no=(String) ext_drugData.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && srlNo.equals(ext_srl_no)){
						remove_pos=h;
						break;
					}
				}
				if(codeCount_1>1 && codeCount_2>1 && order_set_code.equals("")){
					out.println("alertParentRecord('delete')") ;
				}
				else{
					prescriptionDetails.remove((remove_pos));
					searchbean.removeDrugCode(drugCode);
					searchbean.removeSelectedDrug(drugCode);
					bean.getclearscheduleFrequency(drugCode);
					bean.removePRNRemarks(drugCode);
					bean.clearCopiedDrugs(drugCode);
					if(prescriptionDetails.size()>0 && remove_pos>0){
						ext_drugData=(HashMap) prescriptionDetails.get(remove_pos-1);
						if(drugCode.equals((String)ext_drugData.get("DRUG_CODE")))
							ext_drugData.put("DRUG_TAPERED_YN","N");
					}
					if(codeCount_1>0 && prescriptionDetails.size()>0){
						HashMap prev_extdrugData=null;
						srlNo = (String)ext_drugData.get("SRL_NO");
						drugCode = (String)ext_drugData.get("DRUG_CODE");
						String tapered_over = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
						if(tapered_over.equals("Y")){
							float tap_lvl_qty = 0;   
							String Ccalled_from				= "ONCANCEL";
							float Cqty_value			= Float.parseFloat(ext_drugData.get("qty_value")==null?"1":(String) ext_drugData.get("qty_value"));
							float Crepeat_value			= Float.parseFloat( ext_drugData.get("repeat_value")==null?"1":(String) ext_drugData.get("repeat_value"));
							float Cdurn_value			= Float.parseFloat(ext_drugData.get("durn_value")==null?"1":(String) ext_drugData.get("durn_value"));
							float Cinterval_value			= Float.parseFloat( ext_drugData.get("interval_value")==null?"1":(String) ext_drugData.get("interval_value"));
							float totTapperQty = bean.getTotalTaperQty(drugCode, srlNo,Ccalled_from,Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);     
							float prevTotTapperQty = bean.getTotalTaperQty(drugCode, srlNo,"PREVTOTQTY",Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
							tap_lvl_qty=bean.getTotalTaperQty(drugCode, srlNo,Ccalled_from,Cqty_value,Crepeat_value,Cdurn_value,Cinterval_value);
							String tempsno = null;
							for(int j=0;j<prescriptionDetails.size();j++){
								prev_extdrugData =  (HashMap) addprescriptionDetails.get(j);
								ext_drug_code=(String) prev_extdrugData.get("DRUG_CODE");
								ext_srl_no=(String) prev_extdrugData.get("SRL_NO");
								tempsno = String.valueOf(sno);
								if(sno < Integer.parseInt(ext_srl_no)){
									prev_extdrugData.put("SRL_NO",tempsno);
									sno = sno+1;
								}
								if(prev_extdrugData!=null){
									if(drugCode.equals(ext_drug_code) ){
										if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
											if(!srlNo.equals(ext_srl_no))
												prev_extdrugData.put("DRUG_TAPERED_YN","Y");
											prev_extdrugData.put("TOTTAPPERQTY",totTapperQty+"");    
											prev_extdrugData.put("PREVTOTALTAPERQTY",prevTotTapperQty+"");
										}
									}
								}
							}
						}
						else{
							ext_drugData.remove("DRUG_TAPERED_YN");
							ext_drugData.remove("TAP_LVL_QTY");
							ext_drugData.remove("TOTTAPPERQTY");
							ext_drugData.remove("PREVTOTALTAPERQTY");   
						}
					}
					String inrteraction_exists="",  restrict_transaction="N"; 
					for(int h=0;h<prescriptionDetails.size();h++){
						ext_drugData=(HashMap) prescriptionDetails.get(h);
						if(ext_drugData!=null){
							ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
							ext_srl_no=(String) ext_drugData.get("SRL_NO");
							ext_prod_id=  (String) ext_drugData.get("EXTERNAL_PRODUCT_ID")==null?"":(String) ext_drugData.get("EXTERNAL_PRODUCT_ID");
							if((!drug_db_interface_yn.equals("Y")) || ext_prod_id.equals("")){
								inrteraction_exists=(String) ext_drugData.get("INTERACTION_EXISTS")==null?"":(String) ext_drugData.get("INTERACTION_EXISTS");
								if(inrteraction_exists.equals("Y")){
									ext_drugData.put("INTERACTION_EXISTS", "N" );
									ext_drugData.put("INTR_MSG_CONTENT","");
									ext_drugData.put("INTR_RESTRIC_TRN","N");
									st_date_local = (String)ext_drugData.get("START_DATE");
									end_date_local =  (String)ext_drugData.get("END_DATE");
									if(!locale.equals("en")){
										st_date_local =  DateUtils.convertDate(st_date_local, "DMYHM",locale,"en");
										end_date_local =  DateUtils.convertDate(end_date_local, "DMYHM",locale,"en");
									}
									alDrugIntrDtlList = bean.getDrugInteractionDtls(ext_drug_code,  (String) ext_drugData.get("FORM_CODE"), (String) ext_drugData.get("GENERIC_ID"), st_date_local, end_date_local, patient_id);
									if(alDrugIntrDtlList!=null && alDrugIntrDtlList.size()>2){
										severity_level = (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) ;
										restrict_transaction= (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1);
										ext_drugData.put("SEVERITY_LEVEL", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-2) );
										ext_drugData.put("INTR_RESTRIC_TRN", (String)alDrugIntrDtlList.get(alDrugIntrDtlList.size()-1) );
										ext_drugData.put("INTERACTION_DTL", alDrugIntrDtlList );
										ext_drugData.put("INTERACTION_EXISTS", "Y" );
										if(restrict_transaction.equals("Y") || severity_level.equals("H")){
											ext_drugData.put("INTR_ALERT", "Y" );
										}
									}
								}
							}
						}
					}
					out.println("deleteOROrderCatalog('"+drugCode+"','"+called_from+"')") ;
				}
				PersistenceHelper.putObjectInBean(search_bean_id,searchbean,request);
				return;
			}
		}
		else if(func_mode != null && func_mode.equals("formGrouping")){
			String patient_id		= (String)hash.get("patient_id");
			String encounter_id		= (String)hash.get("encounter_id");
			String bed_num	    	= (String)hash.get("bed_num")==null?"":(String)hash.get("bed_num");
			String room_num	    	= (String)hash.get("room_num")==null?"":(String)hash.get("room_num");
			String buildMAR_yn		= (String)hash.get("buildMAR_yn")==null?"":(String)hash.get("buildMAR_yn");
			String act_patient_class	      = (String)hash.get("act_patient_class")==null?"":(String)hash.get("act_patient_class");
			String split_based_priority_yn	  = (String)hash.get("split_based_priority_yn")==null?"":(String)hash.get("split_based_priority_yn");
			String split_based_drug_class_yn  = (String)hash.get("split_based_drug_class_yn")==null?"":(String)hash.get("split_based_drug_class_yn");
			String DrugRemarksEntered  = (String)hash.get("DrugRemarksEntered")==null?"":(String)hash.get("DrugRemarksEntered"); 
			String DrugIndicationRemarks            = (String) hash.get("DrugIndicationRemarks")==null?"":(String)hash.get("DrugIndicationRemarks");
			String function_from        = (String)hash.get("function_from")==null?"":(String)hash.get("function_from"); 
			if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLDecoder.decode(DrugIndicationRemarks,"UTF-8"); ;			
			String record_gen		=	"";
			String priority			=	"";
			String patient_class	=	"";
			String home_medication	=	"";
			String consent_reqd_yn	=	"";
			patient_class	        =(String) hash.get( "patient_class" );
			home_medication     	=(String) hash.get( "take_home_medication" );
			String allergic_yn	    = (String)hash.get( "allergic_yn" )==null?"N":(String)hash.get( "allergic_yn" );			
			String locn_type	    = "";
			
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
				locn_type	= (String)hash.get( "source_type" );	
			else
				locn_type	= "P";				
			String locn_code	= (String)hash.get( "source_code" );	
			String or_bean_name	="eOR.OrderEntryBean";
			String or_bean_id   ="@orderentrybean"+patient_id+encounter_id;
						
			OrderEntryBean orbean = (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id, or_bean_name,  request) ;			
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
			
			ArrayList uniqueCode	   = new ArrayList();
			HashMap prevDates		   = new HashMap();
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap ext_drugData		=	null;
			HashMap refill_detail		=	null;
			ArrayList	st_date			=	null;
			ArrayList en_date			=	null;
			HashMap duplicate			=	null;
			
			String start_date			=	null;
			String end_date				=	null;
			String ph_order_type		=	null;
			String approval_yn_val		=	null;
			String auth_yn_val			=	null;
			String refill_start_date	=	null;
			String refill_end_date		=	null;
			String disp_code			=	null;			                         
			String drug_code			=	null;
			String drug_start_date		=	"";
			String drug_end_date		=   "";
			String temp_auth_rqd_yn     =   "N";
			String temp_apprvl_rqd_yn   =   "N";
			String auth_reqd_yn         =   "";
			String apprvl_reqd_yn       =   "";
			String cosign_reqd_yn       =   "";
			String order_status         =   "10";			
			String disp_locn_desc		=	"";
			String disp_locn			=	"";
			String child_order_yn		=	"";
			String no_refill			=	"";
			String catalog_splty_code	=	"";
			String performing_facility_id=	"";
			String bl_override_excl_incl_ind=	"";
			String currentStage			= 	(String)hash.get("currentStage")==null?"":(String)hash.get("currentStage");//added for  JD-CRF-0198 [IN:058599]
			String srl_no = "";
			String tapered_over = "";
			String freq_nature = "";
			
			for(int n=0; n<prescriptionDetails.size(); n++){
				ext_drugData=(HashMap) prescriptionDetails.get(n);
				refill_detail = new HashMap();
				child_order_yn = (String)ext_drugData.get("CHILD_ORDER_YN")==null?"":(String)ext_drugData.get("CHILD_ORDER_YN");
				no_refill = (String)ext_drugData.get("NO_REFILL")==null?"":(String)ext_drugData.get("NO_REFILL");
				if(child_order_yn.equals("") && !no_refill.equals("")){
					refill_detail	=	bean.getRefillDetail(((String) ext_drugData.get("SRL_NO")));
					if(refill_detail.size()!=0) {
						st_date	=(ArrayList)refill_detail.get("refill_start_date");
						en_date	=(ArrayList)refill_detail.get("refill_end_date");
						ext_drugData.put("REFILL_START_DATE","");
						ext_drugData.put("REFILL_END_DATE","");
						ArrayList duplicate_list		=	new ArrayList();
						for(int y=0; y<st_date.size(); y++) {
							duplicate	=	new HashMap();
							start_date	=	(String)st_date.get(y);
							end_date	=	(String)en_date.get(y);
							duplicate	=	(HashMap)ext_drugData.clone();
							duplicate.put("REFILL_START_DATE",start_date);
							duplicate.put("REFILL_END_DATE",end_date);
							duplicate.put("CHILD_ORDER_YN","Y");
							duplicate_list.add(duplicate);
						}
						for(int p=0; p<duplicate_list.size(); p++) {
							prescriptionDetails.add((n+p+1),(HashMap)duplicate_list.get(p));
						}
					}
				}
			}			
			
			for(int j=0;j<prescriptionDetails.size();j++){				
				disp_code           =   "";
				ext_drugData		=   (HashMap) prescriptionDetails.get(j);
				drug_code			=   (String) ext_drugData.get("DRUG_CODE");
				srl_no					=	 (String) ext_drugData.get("SRL_NO");
				ph_order_type		=   (String) ext_drugData.get("ORDER_TYPE_CODE");
				performing_facility_id	=  (String) ext_drugData.get("PERFORMING_FACILITY_ID");
				approval_yn_val		=   (String) ext_drugData.get("ORD_APPROVED_YN")==null?"":(String) ext_drugData.get("ORD_APPROVED_YN");
				auth_yn_val			=   (String) ext_drugData.get("ORD_AUTHORIZED_YN")==null?"":(String) ext_drugData.get("ORD_AUTHORIZED_YN");
				refill_start_date	=   (String) ext_drugData.get("REFILL_START_DATE")==null?"":(String) ext_drugData.get("REFILL_START_DATE");
				refill_end_date		=   (String) ext_drugData.get("REFILL_END_DATE")==null?"":(String) ext_drugData.get("REFILL_END_DATE");
				auth_reqd_yn		=	(String) ext_drugData.get("ORD_AUTH_REQD_YN")==null?"":(String) ext_drugData.get("ORD_AUTH_REQD_YN");   
				apprvl_reqd_yn	    =	(String) ext_drugData.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) ext_drugData.get("ORD_SPL_APPR_REQD_YN");
				cosign_reqd_yn	    =	(String) ext_drugData.get("ORD_COSIGN_REQD_YN")==null?"":(String) ext_drugData.get("ORD_COSIGN_REQD_YN"); 
				priority	        =	(String) ext_drugData.get("PRIORITY")==null?"":(String) ext_drugData.get("PRIORITY"); 
				catalog_splty_code	=	(String) ext_drugData.get("CATALOG_SPLTY_CODE")==null?"":(String) ext_drugData.get("CATALOG_SPLTY_CODE"); 
				tapered_over =  (String)ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER");
				freq_nature =  (String)ext_drugData.get("FREQ_NATURE")==null?"":(String)ext_drugData.get("FREQ_NATURE");//added for MO-GN-5490 [IN:054620]
				if(freq_nature.equals("O"))
					ext_drugData.put("REPEAT_VALUE", "1");
				if(ext_drugData.get("BUILDMAR_YN")!=null && ((String)ext_drugData.get("BUILDMAR_YN")).equals("Y")) //added for MMS-QH-CRF-0080 [IN:038064]
					out.println("assignBuildMAR('Y')");
				
				if(!tapered_over.equals("Y")){
				    record_gen = "";
				}
				ArrayList schedule =	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
				boolean split_chk	 =	bean.checkSplit(schedule);
				if(split_chk){
					ext_drugData.put("SPLIT_DOSE_YN_VAL","Y");
				} 
				if(ext_drugData.containsKey("BL_OVERRIDE_EXCL_INCL_IND")){
					bl_override_excl_incl_ind = (String)ext_drugData.get("BL_OVERRIDE_EXCL_INCL_IND");
					if(bl_override_excl_incl_ind.equals("SEL"))
						 ext_drugData.put("BL_OVERRIDE_EXCL_INCL_IND","");
				}
				if(auth_reqd_yn.equals("Y")){					
					if(apprvl_reqd_yn.equals("Y")){						
						if(approval_yn_val.equals("Y")){
							if(auth_yn_val.equals("N")){
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "Y";  
								order_status	=	"03"; //PO - Pending Authorization
							}
							else{	
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "N";  
								order_status	=	"10"; //OS - Ordered
							}
						}
						else{
							if(auth_yn_val.equals("Y")){
								temp_apprvl_rqd_yn = "Y";
								temp_auth_rqd_yn = "N";  
								order_status	=	"05"; //PS - Pending Spl Approval
							}
							else{
								temp_apprvl_rqd_yn = "N";
								temp_auth_rqd_yn = "Y";  
								order_status	=	"03"; //PO - Pending Authorization
							}
						}
					}
					else{					
						if(auth_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "Y";  
							order_status	=	"03"; //PO - Pending Authorization
						}
					}
				}
				else{					
					if(apprvl_reqd_yn.equals("Y")){
						if(approval_yn_val.equals("Y")){
							temp_apprvl_rqd_yn = "N";
							temp_auth_rqd_yn = "N";  
							order_status	=	"10"; //OS - Ordered
						}
						else{
							temp_apprvl_rqd_yn = "Y";
							temp_auth_rqd_yn = "N";  
							order_status	=	"05"; //PS - Pending Spl Approva
						}
					}
					else{
						temp_apprvl_rqd_yn = "N";
						temp_auth_rqd_yn = "N";  
						order_status	=	"10"; //OS - Ordered
					}
				}
				if(currentStage!=null && !currentStage.equals("")){//added for  JD-CRF-0198 [IN:058599]
					order_status	=	currentStage;
				}
				if(ext_drugData.get("CONSENT_REQD_YN")==null)
					ext_drugData.put("CONSENT_REQD_YN","N");
				if(ext_drugData.get("CONSENT_REQD_YN").equals("Y") && ext_drugData.get("CONSENT_STAGE").equals("A"))
					order_status = "00"; //PC - Pending consent
				ext_drugData.put("ORDER_STATUS", order_status);
                		disp_code= (String) ext_drugData.get("DISP_LOCN_CODE");
				drug_start_date="N";
				drug_end_date="N";

				if(!tapered_over.equals("Y")){
					record_gen +=(String)ext_drugData.get("IN_FORMULARY_YN"); // Commented above and added here for IN25224 --30/11/2010-- priya
					record_gen += performing_facility_id;
					if(split_based_priority_yn.equals("Y"))
						record_gen += priority;
					if(split_based_drug_class_yn.equals("Y"))
						record_gen += (String) ext_drugData.get("DRUG_CLASS");
				}
				if(!uniqueCode.contains(drug_code) || ((String)ext_drugData.get("TAPPERED_OVER")).equals("Y")){
					drug_start_date=(String) ext_drugData.get("START_DATE");
					 if(drug_start_date==null) {
						 drug_start_date=(String) ext_drugData.get("START_DATE_TIME");
					 }
					drug_end_date=(String) ext_drugData.get("END_DATE");
					if(drug_end_date==null) {
						 drug_end_date=(String) ext_drugData.get("END_DATE_TIME");
					 }

					if(!tapered_over.equals("Y")){
						if(!(drug_start_date==null || drug_start_date.equals(""))){//KAUH-SCF-0077 [IN:035019]. Removing Timestamp on date- Begin
							drug_start_date=drug_start_date.substring(0,10);
						}
						if(!(refill_start_date==null || refill_start_date.equals(""))){
							refill_start_date=refill_start_date.substring(0,10);
						}
						if(!(refill_end_date==null || refill_end_date.equals(""))){
							refill_end_date=refill_end_date.substring(0,10);
						}//KAUH-SCF-0077 [IN:035019]. Removing Timestamp on date- End
					    record_gen = record_gen + temp_apprvl_rqd_yn+temp_auth_rqd_yn+drug_start_date+refill_start_date + refill_end_date + disp_code + catalog_splty_code;
					}
					prevDates.put(drug_code,drug_start_date);
				}
				else{
					refill_detail	=	bean.getRefillDetail(((String) ext_drugData.get("SRL_NO")));
					if(refill_detail.size()!=0){
						if(refill_start_date != null && !refill_start_date.equals("")){
							ext_drugData.put("START_DATE",refill_start_date);
							ext_drugData.put("END_DATE",refill_end_date);
						}
					}
					String date_val=(String)prevDates.get(drug_code);
					record_gen = record_gen + temp_apprvl_rqd_yn + temp_auth_rqd_yn + date_val + refill_start_date + refill_end_date + disp_code + catalog_splty_code;
				}
				ext_drugData.put("RECORD_GEN",record_gen);
				if((ext_drugData.containsKey("CHILD_ORDER_YN"))){
					ext_drugData.put("CONT_ORDER_IND","CR");
				}
				else{
					ext_drugData.put("CONT_ORDER_IND","CO");
				}
				uniqueCode.add(drug_code);
				if(ext_drugData.get("TAPPERED_OVER")!=null && ((String)ext_drugData.get("TAPPERED_OVER")).equals("Y")){
					ext_drugData.put("DRUG_TAPERED_YN","Y");
					HashMap prev_extdrugData =  (HashMap) prescriptionDetails.get(j-1);
					if(prev_extdrugData!=null){
						if((ext_drugData.get("DRUG_CODE")).equals(prev_extdrugData.get("DRUG_CODE"))){
							if(prev_extdrugData.get("FREQ_NATURE")!=null && !((prev_extdrugData.get("FREQ_NATURE")).equals("O")) && !((prev_extdrugData.get("FREQ_NATURE")).equals("P"))){
								prev_extdrugData.put("DRUG_TAPERED_YN","Y");
							}
						}
					}
				}
			}			
			
			ArrayList groupRecord=(ArrayList)bean.groupingOrder(patient_class);
			int groupSize=groupRecord.size();
			ArrayList OrderID = new ArrayList();
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") ){
				 OrderID=(ArrayList)bean.genOrderID(groupSize,patient_class);
			}
			else{
				patient_class = "XT";
				OrderID=(ArrayList)bean.genOrderID(groupSize,patient_class);
			}
			if(patient_class.equals("IP")){
				String debug= (String)bean.genOrderDetailsforIP();
			}
			else{
				bean.genOrderDetails();
			}
			ArrayList OrderDetails =(ArrayList) bean.getOrderDetails();
			ArrayList OrderHeader	=	new ArrayList();
			ArrayList tmp_order_id	=	new ArrayList();
			String parent_order_id	=	"";
			boolean firstTime		=	true;
			HashMap presHeader		=	null;
			ArrayList HeaderArr		=	null;        
			HashMap presDetails		=	null;
			String order_type_code	=	"";
			String ord_auth_reqd_yn	=	"";
			String ord_auth_level	=	""; 			                        
			String ord_appr_reqd_yn	=	"";
			String ord_cosign_reqd_yn	=	"";
			String med_admin_reqd_yn	=	"";
			for(int j=0;j<OrderID.size();j++){
				presHeader  = new HashMap();
				HeaderArr	= new ArrayList();
				HeaderArr			= (ArrayList) OrderDetails.get(j); 
				presDetails = new HashMap();
				presDetails = (HashMap) HeaderArr.get(0);
				String order_id			= (String) OrderID.get(j);
				tmp_order_id.add(order_id);
				if(!presDetails.containsKey("CHILD_ORDER_YN")){
					firstTime		=	true;
				}
				order_type_code	= (String) presDetails.get("ORDER_TYPE_CODE");
				ord_auth_reqd_yn = (String) presDetails.get("ORD_AUTH_REQD_YN")==null?"N":(String) presDetails.get("ORD_AUTH_REQD_YN");
				if((String) presDetails.get("ORD_AUTH_LEVEL")==null){
					presDetails.put("ORD_AUTH_LEVEL","");
				}
				ord_auth_level     = (String) presDetails.get("ORD_AUTH_LEVEL");
				ord_appr_reqd_yn   = (String) presDetails.get("ORD_SPL_APPR_REQD_YN")==null?"N":(String) presDetails.get("ORD_SPL_APPR_REQD_YN");
				ord_cosign_reqd_yn = (String) presDetails.get("ORD_COSIGN_REQD_YN")==null?"N":(String) presDetails.get("ORD_COSIGN_REQD_YN");
				consent_reqd_yn=(String)presDetails.get("CONSENT_REQD_YN")==null?"N":(String)presDetails.get("CONSENT_REQD_YN");
				if(consent_reqd_yn.equals(""))
					consent_reqd_yn = "N";
				med_admin_reqd_yn  = (String) presDetails.get("MED_ADMIN_REQD_YN");
				presHeader.put("ORDER_ID", order_id );
				presHeader.put("MED_ADMIN_REQD_YN", med_admin_reqd_yn );
				presHeader.put("ORDER_TYPE_CODE", order_type_code );
				presHeader.put("FACILITY_ID",(String) hash.get( "facility_id" ));
				presHeader.put("PATIENT_ID",(String) hash.get( "patient_id" ));
				presHeader.put("ENCOUNTER_ID",(String) hash.get( "encounter_id" ));
				presHeader.put("BED_NUM", bed_num);
				presHeader.put("ROOM_NUM", room_num);
				presHeader.put("HEIGHT",(String) hash.get( "height" ));
				presHeader.put("WEIGHT",(String) hash.get( "weight" ));
				presHeader.put("BSA",(String) hash.get( "bsa" ));
				presHeader.put("BMI",(String) hash.get( "bmi" ));
				presHeader.put("HEIGHT_UNIT",(String) hash.get( "height_unit" ));
				presHeader.put("WEIGHT_UNIT",(String) hash.get( "weight_unit" ));
				presHeader.put("BSA_UNIT",(String) hash.get( "bsa_unit" ));
				presHeader.put("PRIORITY",(String) hash.get( "priority" ));
				presHeader.put("ORDER_DATE_TIME",(String) hash.get( "order_date_time" ));
				presHeader.put("TAKE_HOME_MEDICATION",(String) hash.get( "take_home_medication" ));
				presHeader.put("PATIENT_CLASS",(String) hash.get( "patient_class" ));
				presHeader.put("SOURCE_TYPE",(String) hash.get( "source_type" ));
				presHeader.put("SOURCE_CODE",(String) hash.get( "source_code" ));
				presHeader.put("DISP_LOCN_CODE",(String) presDetails.get( "DISP_LOCN_CODE" ));		
				presHeader.put("ALLERGIC_YN",allergic_yn);
				presHeader.put("CATALOG_SPLTY_CODE",(String) presDetails.get( "CATALOG_SPLTY_CODE" ));		
				presHeader.put("HOME_LEAVE_YN_VAL",(String) hash.get( "home_leave_yn_val" ));// added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
				if( home_medication.equals("Y") )
						presHeader.put("DISCHARGE_IND","D");
				else
					presHeader.put("DISCHARGE_IND","");
				presHeader.put("ATTEND_PRACT_ID",(String) hash.get( "attend_pract_id" ));
				presHeader.put("ORD_PRACT_ID",(String) hash.get( "ord_pract_id" ));
				presHeader.put("ORD_AUTH_REQD_YN",ord_auth_reqd_yn);
				presHeader.put("ORD_AUTH_LEVEL",ord_auth_level);
				presHeader.put("ORD_APPR_REQD_YN",ord_appr_reqd_yn);
				presHeader.put("ORD_COSIGN_REQD_YN",ord_cosign_reqd_yn);
				presHeader.put("CONSENT_REQD_YN",consent_reqd_yn);
				presHeader.put("BROUGHT_BY_PAT",(String) presDetails.get( "BROUGHT_BY_PAT" ));
				presHeader.put("BUILDMAR_YN",buildMAR_yn);
				presHeader.put("DrugRemarksEntered",DrugRemarksEntered); //Added for Antibiotic Screen using Order Entry Format ICN 29904
				presHeader.put("DRUG_INDICATION",DrugIndicationRemarks);
				if( ( presDetails.containsKey("CHILD_ORDER_YN")) ){
					presHeader.put("CONT_ORDER_IND","CR");
					}
				else{
					presHeader.put("CONT_ORDER_IND","CO");
					}
				if((orbean.getCalledFromFunction()!=null) && (orbean.getCalledFromFunction()).equals("RENEW_ORDER")) {
					presHeader.put("CHILD_ORDER_YN","N");
					presHeader.put("PARENT_ORDER_ID","");
				} 
				else {
					if ( presDetails.containsKey("CHILD_ORDER_YN")) {
						presHeader.put("CHILD_ORDER_YN","Y");
						if(firstTime) {
							parent_order_id	=  (String)tmp_order_id.get(j-1);
							firstTime		=	false;
						}
						presHeader.put("PARENT_ORDER_ID",parent_order_id);
					}
					else{
						presHeader.put("CHILD_ORDER_YN","N");
						presHeader.put("PARENT_ORDER_ID","");
					}
				}
				//added for JD-CRF-198 - start
				if(function_from.equals("ALTERNATE_ORDER") ) 
					presHeader.put("ORG_ORDER_ID",bean.getParentOrderIdForAltOrder());
				else
					presHeader.put("ORG_ORDER_ID","");
				//added for JD-CRF-198 -end
				order_status=(String)presDetails.get( "ORDER_STATUS" );
				presHeader.put("ORD_AUTH_REQD_YN",(String)presDetails.get( "ORD_AUTH_REQD_YN" ));
				presHeader.put("ORDER_STATUS",order_status);
				OrderHeader.add(presHeader);
			}
			bean.setpresHeader(OrderHeader);
			OrderHeader=(ArrayList) bean.getpresHeader();
			ArrayList DrugRemarks	= new ArrayList();
			ArrayList OrderDrug		= new ArrayList();
			ArrayList grp=(ArrayList) bean.sortList();
			String exist_code="";
			String order_id="";
			String fr_drug_code="";
			HashMap orderFormatHash	=	null;
			ArrayList arrSeq_num	=	null;
			Hashtable template		=	null;
			
			for(int j=0;j<grp.size();j++){
				orderFormatHash	= new HashMap(); // To store it in the HashMap
				arrSeq_num	= new ArrayList(); // get the seq in ArrayList
				template		= new Hashtable(); // get the template values in the HashTable
				int seq_num 			= 0;
				String order_format_values = "";
				String catalog_code=(String) grp.get(j);
				String row_value="0";
				arrSeq_num				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_"+row_value);
				ArrayList headerList	=	null;
				HashMap DrugValues		=	null;	
				String serial_no		=	null;
				for(int k=0;k<OrderDetails.size();k++){
					headerList=new ArrayList();
					headerList=(ArrayList) OrderDetails.get(k);
					for(int h=0;h<headerList.size();h++){
						DrugValues= new HashMap();
						DrugValues=(HashMap) headerList.get(h);
						exist_code=(String)	DrugValues.get("DRUG_CODE");
						serial_no	=	(String)	DrugValues.get("SRL_NO");
						orderFormatHash	= new HashMap();
						if(exist_code.equals(catalog_code)){
							fr_drug_code=exist_code;
							orderFormatHash.put("fr_drug_code",fr_drug_code);
							orderFormatHash.put("serial_no",serial_no);
							if(k > (OrderID.size()-1))
								order_id=(String) OrderID.get(OrderID.size()-1);
							else
								order_id=(String) OrderID.get(k);
							arrSeq_num				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats((fr_drug_code+serial_no), (fr_drug_code+serial_no)+"_0");
							if(arrSeq_num!= null && arrSeq_num.size() >0){
								int i=0;
								order_format_values = "";
								for(i=0;i<arrSeq_num.size();i++){
									
									seq_num		=((Integer.parseInt(((String)arrSeq_num.get(i)).trim())) );
									template	= (java.util.Hashtable)	orderEntryRecordBean.getOrderFormats ( (catalog_code+serial_no), ((catalog_code+serial_no)+seq_num) );
									orderFormatHash.put("seq_num"+i,String.valueOf(seq_num));
									orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
									orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
									orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
									orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
									orderFormatHash.put("field_values"+i,(String) template.get("field_values"));
									String field_values_tmp = "";
									if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")){
										field_values_tmp = presBean.getPrescriptionRemarks((String) template.get("field_values"));
									}
									else{
										field_values_tmp = ((String) template.get("field_values")).trim();
									}
									if(field_values_tmp != null && !field_values_tmp.equals("") ){
										order_format_values =order_format_values+ ((String) template.get("label_text"))+" : "+ field_values_tmp +",";														
									}
								}
								orderFormatHash.put("order_format_count",(String.valueOf(i)));
								orderFormatHash.put("order_id",order_id);
								orderFormatHash.put("order_format_values",order_format_values);
							}
							else{
								orderFormatHash.put("order_id",order_id);
								orderFormatHash.put("order_format_count","0");
								orderFormatHash.put("order_format_values","");
							}
							DrugRemarks.add(orderFormatHash);
						}
					}
				}
			}
			
			String ext_order_id="", ext_order_format_count="",ord_id="" ;
			HashMap orderValues	=	null;
			for(int i=0;i<OrderID.size();i++){
				ord_id		=(String)OrderID.get(i);
				orderValues	=new HashMap();
				for(int p=0;p<DrugRemarks.size();p++){
					orderValues=(HashMap) DrugRemarks.get(p);
					ext_order_id = (String) orderValues.get("order_id");
					if(ext_order_id==null)
						ext_order_id="";
					ext_order_format_count= (String) orderValues.get("order_format_count");
					if(ord_id.equals(ext_order_id)){
						if(ext_order_format_count!=null && !(ext_order_format_count.equals(""))){
							OrderDrug.add(orderValues);
						}
					}
				}
			}
						
			String cn_bean_id					= "@ConsumableOrderBean"+patient_id+encounter_id;
			String cn_bean_name				= "ePH.ConsumableOrderBean";
			ConsumableOrderBean consumableBean = (ConsumableOrderBean)PersistenceHelper.getBeanObject( cn_bean_id, cn_bean_name, request );
			//Drug remarks related code for EM Mobility STARTS
			HashMap drugRemarksHash = new HashMap();
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData		=   (HashMap) prescriptionDetails.get(j);
				drug_code			=   (String) ext_drugData.get("DRUG_CODE");
				String drug_remstr			=   (String) ext_drugData.get("DRUG_REMARKS")==null?"":(String) ext_drugData.get("DRUG_REMARKS");
				drugRemarksHash.put(drug_code, drug_remstr);
			}
			for(int j=0;j<OrderDrug.size();j++){
				HashMap orderDrugItem = (HashMap)OrderDrug.get(j);
				String orderDrug_drugCode = (String)orderDrugItem.get("fr_drug_code");
				int compCount = 0;//alsways zero since we assume only one component in drug remarks for pharmacy drug alone
				if(drugRemarksHash.containsKey(orderDrug_drugCode)){
					String drug_remstr = (String)drugRemarksHash.get(orderDrug_drugCode);
					orderDrugItem.put("order_format_values", "DRUG_REMARKS : "+drug_remstr);
					orderDrugItem.put("field_values"+compCount, drug_remstr);
					orderDrugItem.put("label_text"+compCount, "DRUG_REMARKS");
					orderDrugItem.put("field_type"+compCount, "A");
					orderDrugItem.put("order_format_count", "1");
					orderDrugItem.put("seq_num"+compCount, "0");
					orderDrugItem.put("field_mnemonic"+compCount, "DRUG_REMARKS");
					orderDrugItem.put("accept_option"+compCount, "O");
				}
			}
			bean.genDrugRemarks(OrderDrug);
			//Drug remarks related code for EM Mobility ENDS
			ArrayList presItemList = consumableBean.getPresItemList();			
			if(presItemList!=null && presItemList.size()>0){
				HashMap itemDetails = null;
				for(int i=0; i<presItemList.size();i++){
					itemDetails = (HashMap)presItemList.get(i);
					itemDetails.put("ORDERED_DATE",(String) hash.get("order_date_time"));
					itemDetails.put("PATIENT_ID", patient_id);
					itemDetails.put("ENCOUNTER_ID", encounter_id);
					itemDetails.put("FACILITY_ID",(String) hash.get( "facility_id" ));
					itemDetails.put("BED_NUM", bed_num);
					itemDetails.put("ROOM_NUM", room_num);
					itemDetails.put("HEIGHT",(String)hash.get("height"));
					itemDetails.put("WEIGHT",(String) hash.get("weight"));
					itemDetails.put("BSA",(String) hash.get("bsa"));
					itemDetails.put("BMI",(String) hash.get("bmi"));
					itemDetails.put("HEIGHT_UNIT",(String) hash.get("height_unit" ));
					itemDetails.put("WEIGHT_UNIT",(String) hash.get("weight_unit" ));
					itemDetails.put("BSA_UNIT",(String) hash.get( "bsa_unit" ));
					itemDetails.put("PRIORITY",(String) hash.get( "priority" ));
					itemDetails.put("ORDER_DATE_TIME",(String) hash.get( "order_date_time" ));
					itemDetails.put("TAKE_HOME_MEDICATION",(String) hash.get( "take_home_medication" ));
					itemDetails.put("PATIENT_CLASS",(String) hash.get( "patient_class" ));
					itemDetails.put("SOURCE_TYPE",(String) hash.get( "source_type" ));
					itemDetails.put("SOURCE_CODE",(String) hash.get( "source_code" ));
					itemDetails.put("ALLERGIC_YN",allergic_yn);
					if( home_medication.equals("Y") ){
						itemDetails.put("DISCHARGE_IND","D");
					}
					else{
						itemDetails.put("DISCHARGE_IND","");
					}
					itemDetails.put("ATTEND_PRACT_ID",(String) hash.get( "attend_pract_id" ));
					itemDetails.put("ORD_PRACT_ID",(String) hash.get( "ord_pract_id" ));
					itemDetails.put("BROUGHT_BY_PAT",(String) presDetails.get( "BROUGHT_BY_PAT" ));
					itemDetails.put("CONT_ORDER_IND","CO");
					itemDetails.put("CHILD_ORDER_YN","N");
					itemDetails.put("PARENT_ORDER_ID","");
				}
				OrderID=(ArrayList)consumableBean.genOrderID(presItemList.size(),(String) hash.get( "patient_class" ));				
				for(int i=0; i<presItemList.size();i++){

					itemDetails = (HashMap)presItemList.get(i);
					itemDetails.put("ORDER_ID", (String)OrderID.get(i));
				}
			}						
			bean.setPresItemList(presItemList);			
			String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();
			out.println("showRecords(\""+print_ord_sht_rule_ind+"\")");
			PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
			PersistenceHelper.putObjectInBean(cn_bean_id,consumableBean,request);
		}			
		else if(func_mode != null && func_mode.equals("validateDuration")){
			String drug_code		= (String) hash.get( "drug_code" );
			String patient_class	= (String) hash.get( "patient_class" );
			String source	        = (String) hash.get( "source" );
			String srlNo			= (String) hash.get( "srlNo" );
			String frm				= hash.get( "frm" )==null?"":(String) hash.get( "frm" );
			String freq_chng_durn_desc = (String) hash.get( "freq_chng_durn_desc" );
			String freq_chng_durn_value = (String) hash.get( "freq_chng_durn_value" );
			String interval_value = hash.get( "interval_value" )==null?"1":(String) hash.get( "interval_value" ); 
			String sliding_scale_yn = (String) hash.get( "sliding_scale_yn" )==null?"N": (String) hash.get( "sliding_scale_yn" );
			String repeat_durn_type = (String) hash.get( "repeat_durn_type" ); 
			String order_set_code	= (String)hash.get("order_set_code")==null?"":(String)hash.get("order_set_code");
			HashMap durnValues=  (HashMap)presBean.validateDuration(drug_code,patient_class);
			HashMap ext_drugData	=	null;
			String ext_drug_code	=	null;
			String ext_srl_no		=	null;
			String ext_total_durn_value	=	null, prev_drun_value="";
			boolean	can_modify	= true;
			String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
			String tapered_yn="", amend_yn = ""; 
			if(source.equals("modify")||source.equals("taper")||source.equals("tapered")){
				ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
				
				int codeCount_1 =0;
				int codeCount_2 =0;
				int drug_index =0;
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no=(String) ext_drugData.get("SRL_NO");
					tapered_yn = ext_drugData.get("TAPPERED_OVER")==null?"":(String)ext_drugData.get("TAPPERED_OVER"); 
					amend_yn = ext_drugData.get("AMEND_YN")==null?"":(String)ext_drugData.get("AMEND_YN");
					if(!amend_yn.equals("Y") && tapered_yn.equals("Y") && frm.equals("release")){
						out.println("alertNoTaper('nochange');") ;
						can_modify=false;
						break;
					} 
					if(drug_code.equals(ext_drug_code)){
						codeCount_1++;
					}
					if(drug_code.equals(ext_drug_code) && srlNo.equals(ext_srl_no)){
						drug_index = j;
						prev_drun_value = (String)ext_drugData.get("DURN_VALUE");
					}
				}
				if(codeCount_1>1){
					for(int k=drug_index;k<prescriptionDetails.size();k++){
						ext_drugData=(HashMap) prescriptionDetails.get(k);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						if(drug_code.equals(ext_drug_code)){
							codeCount_2++;
						}
					}
				}
				if(can_modify && codeCount_1>1 && codeCount_2!=1 && order_set_code.equals("") && !totalTaperQtyDisplay.equals("Y") ){
					can_modify=false;
					out.println("alertParentRecord('modify','"+frm+"',"+prev_drun_value+")") ;
				}
				if(can_modify){
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData=(HashMap) prescriptionDetails.get(j);
						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no=(String) ext_drugData.get("SRL_NO");
						if( drug_code.equals(ext_drug_code) && srlNo.equals(ext_srl_no) ){
							ext_drugData.put("freq_chng_durn_desc",freq_chng_durn_desc);
							if(repeat_durn_type == null || repeat_durn_type.equals("")) 
								repeat_durn_type = (String)ext_drugData.get("REPEAT_DURN_TYPE");
							freq_chng_durn_value =	(String)bean.getFreqDurnConvValue(repeat_durn_type,freq_chng_durn_value,freq_chng_durn_desc);
							ext_drugData.put("freq_chng_durn_value",freq_chng_durn_value); 
							ext_drugData.put("FREQ_DURN_VALUE",freq_chng_durn_value);
							ext_drugData.put("INTERVAL_VALUE",interval_value); 
							ext_drugData.put("REPEAT_DURN_TYPE",repeat_durn_type); 
							break;
						}
					}
				}
			}
			if(can_modify){
				ArrayList prescription=(ArrayList)bean.getpresDetails();
				int total_durn=0;
				String present_durn_value=(String) hash.get("durn_value");
				for(int j=0;j<prescription.size();j++){
					ext_drugData=(HashMap) prescription.get(j);
					ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
					ext_total_durn_value=(String) ext_drugData.get("DURN_VALUE");
					if( drug_code.equals(ext_drug_code)){
						total_durn+=Integer.parseInt(ext_total_durn_value);
					}
				}
				if(!source.equals("modify")){
					total_durn+=Integer.parseInt(present_durn_value);
				}
				String total_durn_value=""+total_durn;
				if(durnValues.size()>0){
					String max_durn_value = (String)durnValues.get("max_durn_value")==null?"":(String)durnValues.get("max_durn_value");
					String chk_for_max_durn_action = (String)durnValues.get("chk_for_max_durn_action")==null?"":(String)durnValues.get("chk_for_max_durn_action");
					String prompt_msg = (String)durnValues.get("prompt_msg")==null?"":(String)durnValues.get("prompt_msg");
					String max_durn_type = (String)durnValues.get("max_durn_type")==null?"":(String)durnValues.get("max_durn_type");
					out.println("assignDurnvalue('"+total_durn_value+"','"+max_durn_value+"','"+chk_for_max_durn_action+"','"+java.net.URLEncoder.encode(prompt_msg,"UTF-8")+"','"+max_durn_type+"','"+sliding_scale_yn+"')"); 
				}
			}
		}
		else if(func_mode!= null && func_mode.equals("setDurationAction")){
			ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
			HashMap drugDetail	=	null;
			String curr_drug_code = "", curr_srl_no="";
			String drugCode = (String)hash.get("drug_code");
			String srlNo =  (String)hash.get("srl_no");
			String ord_authorized_prev_yn = (String) hash.get("ord_authorized_prev_yn")==null?"":(String)hash.get("ord_authorized_prev_yn");
			String ord_authorized_yn = (String) hash.get("ord_authorized_yn")==null?"":(String)hash.get("ord_authorized_yn");
			String ord_auth_reqd_yn = (String) hash.get("ord_auth_reqd_yn")==null?"":(String)hash.get("ord_auth_reqd_yn");
			for(int j=0;j<prescriptionDetails.size();j++){
				drugDetail	=(HashMap) prescriptionDetails.get(j);
				curr_drug_code	=(String) drugDetail.get("DRUG_CODE");
				curr_srl_no		=(String) drugDetail.get("SRL_NO");
				if( drugCode.equals(curr_drug_code) && srlNo.equals(curr_srl_no) ){
					drugDetail.put("ORD_AUTH_REQD_YN",ord_auth_reqd_yn);
					drugDetail.put("ORD_AUTHORIZED_PREV_YN",ord_authorized_prev_yn);
					drugDetail.put("ORD_AUTHORIZED_YN",ord_authorized_yn);
				}
			}
		}
		else if(func_mode != null && func_mode.equals("validateDosageLimit")){
			String daily_dose		= "";
			String unit_dose		= "";
			String limit_ind		= "";
			String mono_graph		= "";
			String min_daily_dose	= "";
			String min_unit_dose	= "";
			String dose_unit	= "";
			String drug_code	= (String) hash.get( "drug_code" );
			String qty_value	= (String) hash.get( "qty_value" );
			String repeat_value	= (String) hash.get( "repeat_value" );
			String dosage_type  = (String) hash.get( "dosage_type" );
			String patient_id	= (String) hash.get( "patient_id" );
			String srl_no		= (String) hash.get( "srl_no" );
			String freq_nature		= (String) hash.get("freq_nature")==null?"":(String) hash.get("freq_nature");
			String calc_def_dosage_yn		= (String) hash.get("calc_def_dosage_yn")==null?"":(String) hash.get("calc_def_dosage_yn");
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap ext_drugData            = null;  
			ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			if((freq_nature.equals("P") || freq_nature.equals("O"))&& prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData				=(HashMap) prescriptionDetails.get(j);
					ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						out.println("disableDosageLimit('Y','"+srl_no+"','"+ext_drug_code+"')"); //parameter srl_no added for	SRR20056-SCF-7690 IN 27798 & 28440
						return;
					 }
				}
			}
			if(schedule.size() > 0)
			{			 
				 ArrayList dose_list		= (ArrayList)schedule.get(4);
				 if(dose_list!=null && dose_list.size()>0)
					 qty_value		=	(String)dose_list.get(0);
				else
					 qty_value="1";
			}
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
				  ext_drugData				=(HashMap) prescriptionDetails.get(j);
				  ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
				  ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
						break;
					 }
				}
			}
			if(calc_def_dosage_yn.equals("Y")){
				HashMap dosageDetails= (HashMap) presBean.chkMaxDosageLimit(drug_code,patient_id,qty_value,dosage_type,repeat_value);
				limit_ind= (String) dosageDetails.get("LIMIT_IND");
				if(limit_ind != null && limit_ind.equals("N"))
				{	daily_dose = (String) dosageDetails.get("DAILY_DOSE");
					unit_dose = (String) dosageDetails.get("UNIT_DOSE");
					mono_graph = (String) dosageDetails.get("MONO_GRAPH");
					min_daily_dose= (String) dosageDetails.get("MIN_DAILY_DOSE");
					min_unit_dose= (String) dosageDetails.get("MIN_UNIT_DOSE");
					dose_unit= (String) dosageDetails.get("DOSAGE_UNIT");
					ext_drugData.put("DAILY_DOSE",daily_dose);
					ext_drugData.put("UNIT_DOSE", unit_dose);
					ext_drugData.put("MONO_GRAPH", mono_graph);
					ext_drugData.put("MIN_DAILY_DOSE", min_daily_dose);
					ext_drugData.put("MIN_UNIT_DOSE", min_unit_dose);
					ext_drugData.put("DOSAGE_UNIT",(String) dosageDetails.get("DOSAGE_UNIT"));
					mono_graph=mono_graph.replaceAll(" ","%20");
					mono_graph = java.net.URLEncoder.encode(mono_graph,"UTF-8");
					mono_graph=mono_graph.replaceAll("%2520","%20");
					out.println("enableDosageLimit('"+limit_ind+"','"+daily_dose+"','"+unit_dose+"','"+mono_graph+"','"+min_daily_dose+"','"+min_unit_dose+"','"+dose_unit+"','"+srl_no+"')"); //parameter srl_no added for	SRR20056-SCF-7690 IN 27798 & 28440
				}
				else{
					out.println("disableDosageLimit('"+limit_ind+"','"+srl_no+"','"+drug_code+"')"); //parameter srl_no added for	SRR20056-SCF-7690 IN 27798 & 28440
				}
			}
		}
		else if(func_mode != null && func_mode.equals("makeScheduleLink")){
			String drug_code	= (String) hash.get( "drug_code" );
			String drug_codeOnly	= (String) hash.get( "drug_codeOnly" ); //Added for ML-BRU-SCF-1231 [IN:046657]
			String srl_no		= (String) hash.get( "srl_no" );
			String sliding_scale_yn		= (String) hash.get( "sliding_scale_yn" );
			String admin_time	= "", admin_qty="", final_qty="",ad_qty="", temp_admin_time="" ;
			float total_qty		= 0.0f;
			String att="  class=TIP";
			String ext_drug_code	= "", ext_srl_no; //Added for ML-BRU-SCF-1231 [IN:046657] -start
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap ext_drugData =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData				=(HashMap) prescriptionDetails.get(j);
					ext_drug_code				=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no				=(String) ext_drugData.get("SRL_NO");
					if( drug_codeOnly.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
						ext_drugData.put("VALUES_CHANGED","Y");
						break;
					 }
				}
			} //Added for ML-BRU-SCF-1231 [IN:046657] -end
			HashMap chkValuescheduleFrequency=bean.getscheduleFrequency();
			ArrayList frequencyValues = new ArrayList();
			if(chkValuescheduleFrequency!=null && chkValuescheduleFrequency.size()>0){
				frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
			}
			HashMap data	=	null;
			if(frequencyValues !=null && frequencyValues.size()>0){
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList freqCharctValues = new ArrayList();
				if(chkValuescheduleFrequency.size()>0){
					frequencyValues = (ArrayList) chkValuescheduleFrequency.get(drug_code);
				}
				freqCharctValues = frequencyValues;
				admin_time = "";
				admin_qty = "";
				if(freqCharctValues != null && freqCharctValues.size() > 0){
					dose_list	= (ArrayList)freqCharctValues.get(4);
					if(dose_list==null  || dose_list.size()>0){
						total_qty	= 0.0f;
						for(int tqI=0;tqI<dose_list.size();tqI++){
							total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
							final_qty	=	(String)dose_list.get(tqI);
						}
						boolean split_chk	=	bean.checkSplit(frequencyValues);	
						if(split_chk)
							final_qty		=	total_qty+"";
						else
							ad_qty          =final_qty;
						if(freqCharctValues != null && freqCharctValues.size() > 0){
							 String tooltiptable ="";
							if(sliding_scale_yn.equals("N"))
								tooltiptable = (String)bean.getTooltipStringFrFreq(freqCharctValues,"toolTip");
							else
								tooltiptable = (String)bean.getTooltipStringFrFreq(freqCharctValues,"Sliding");
							admin_time = tooltiptable;	
						}
						out.println("makeScheduleLink('"+admin_time+"','"+admin_qty+"','"+final_qty+"','"+frequencyValues.size()+"','"+split_chk+"','Modify')");
					}
					else
						out.println("hideScheduleLink()");
				}
				else
					out.println("hideScheduleLink()");
			}
			else
				out.println("hideScheduleLink()");
		}
		else if(func_mode != null && func_mode.equals("disableScheduleLink")){
			HashMap ext_drugData		=	null;
			ArrayList prescriptionDetails=null;
			String drug_code	= (String) hash.get( "drug_code" );
			String amend_yn     ="N";
			String ext_drug_code=null;
			prescriptionDetails=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				ext_drugData	=	(HashMap) prescriptionDetails.get(j);
				ext_drug_code	=	(String) ext_drugData.get("DRUG_CODE");
				amend_yn		=	(String) ext_drugData.get("AMEND_YN");	
				if(drug_code.equals(ext_drug_code)&&amend_yn.equals("N")){
					bean.getclearscheduleFrequency(drug_code);
					out.println("deleteScheduleLink()");
				}
			}
		}
		else if(func_mode != null && func_mode.equals("storeSchedule")){
			String freq_code		= (String) hash.get( "freq_code" );
			String freq_desc		= (String)hash.get( "freq_desc");
			freq_desc = java.net.URLDecoder.decode(freq_desc,"UTF-8");
			String freq_nature		= (String)hash.get( "freq_nature");
			String start_date		= (String) hash.get( "start_date" );
			String split_dose_yn	= (String) hash.get( "split_dose_yn" );
			String qty_value		= (String) hash.get( "qty_value" );
			String drug_code		= (String) hash.get( "drug_code" );
			String srl_no			= (String) hash.get( "srl_no" );
			String rowVal			= (String) hash.get( "rowVal" );
			String scheduled_yn		= (String) hash.get( "scheduled_yn" );
			String dose_uom			= (String) hash.get( "dose_uom" );  // added for SKR-SCF-0561 [IN:033486]
			String qty_uom = (String) hash.get( "qty_uom" ); //added for IN23975 --28/09/2010-- priya
			String dosage_type = (String) hash.get( "dosage_type" ); //added for IN24132 --07/10/2010-- priya
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null; 
			String	 temp_drug_code ="";
			String	 temp_srl_no		="";
			if( scheduled_yn.equals("Y") ) {				
			} 
			ArrayList presDetails  = (ArrayList) bean.getpresDetails();
			HashMap drugDetails    = null;
			for(int i=0;i<presDetails.size();i++){
				drugDetails    = (HashMap)presDetails.get(i);
				temp_drug_code =(String)drugDetails.get("DRUG_CODE");
				temp_srl_no		=(String) drugDetails.get("SRL_NO");
				if( drug_code.equals(temp_drug_code) && srl_no.equals(temp_srl_no) ){					
					break;
				}
			}
		}
		else if(func_mode != null && func_mode.equals("populateDurationDesc")){
			String freq_code	= (String) hash.get( "freq_code" );
			String durn_desc= "", repeat_durn_type = "", freq_value	= "";
			String freq_nature			= "";
			String interval_value		= "";
			String repeat_value			= "";
			String schedule_yn			= "";
			HashMap freqNature			=(HashMap)presBean.freqValidate(freq_code);
			if(freqNature.size()>0){
				freq_nature		= (String)freqNature.get("freq_nature");
				freq_value		= (String)freqNature.get("freq_value");
				interval_value	= (String)freqNature.get("interval_value");
				repeat_value	= (String)freqNature.get("repeat_value");
				schedule_yn		= (String)freqNature.get("schedule_yn");
				repeat_durn_type= (String)freqNature.get("repeat_durn_type");
			}
			if(freq_nature != null && !freq_nature.equals("O")){
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
				out.println("dfltDurnDesc(\""+repeat_durn_type+"\")");			
			}
			else{
				durn_desc	="";
				freq_value	="";			
				out.println("assignDurnDesc(\""+repeat_value+"\",\""+repeat_durn_type+"\",\""+freq_nature+"\",\""+interval_value+"\",\""+durn_desc+"\",\""+freq_value+"\",\""+schedule_yn+"\")");
			}
		}
		else if(func_mode != null && func_mode.equals("populateDurnDesc"))	{
			String repeat_durn_type		= (String) hash.get( "repeat_durn_type" );
			Hashtable DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
			Enumeration keys_des		= DurnDescDetails.keys();
			String	durn_code	= "";
			String	durn_desc	= "";
			boolean flag		= true;
			while(keys_des.hasMoreElements()){
					durn_code	= (String)keys_des.nextElement();
					durn_desc	= (String)DurnDescDetails.get(durn_code);				
					if(repeat_durn_type.equals("M")){
						if(durn_code.equals("M") || durn_code.equals("H") || durn_code.equals("D"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("H")){
						if(durn_code.equals("H") || durn_code.equals("D") || durn_code.equals("W"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("D")){
						if(durn_code.equals("D") || durn_code.equals("W") || durn_code.equals("L") || durn_code.equals("Y"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("W")){
						if(durn_code.equals("W") || durn_code.equals("L") || durn_code.equals("Y"))
							flag		= true;
						else
							flag		= false;
					}
					else if(repeat_durn_type.equals("L")){
						if(durn_code.equals("L") || durn_code.equals("Y"))
							flag		= true;
						else
							flag		= false;
					}
					if(flag){
						out.println("addDurnDescList(\""+durn_code+"\",\""+durn_desc+"\")");
					}
			}
			out.println("dfltDurnDesc('"+repeat_durn_type+"')");
		}
		else if(func_mode != null && func_mode.equals("disableScheduleLink1"))	{
			String drug_code	= (String) hash.get( "drug_code" );
			bean.getclearscheduleFrequency(drug_code);
			out.println("deleteScheduleLink()");
		}
		else if(func_mode != null && func_mode.equals("populateEndDate")){
			String freq_nature			= (String) hash.get( "freq_nature" );
			String start_date			= (String) hash.get( "start_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String repeat_durn_type		= (String) hash.get( "repeat_durn_type" );
			String drugCode	= (String)hash.get( "drug_code");
			String def_freq_found	= (String)hash.get( "def_freq_found");
			String srlNo	= (String)hash.get( "srlNo");
			String absol_qty = (String) hash.get( "absol_qty" );
			String callFrom = hash.get( "callFrom")==null?"":(String) hash.get( "callFrom"); // added for MO-GN-5490 [IN:054620] - [IN:055921]
			String tmp_start_date = start_date; //added for  SKR-SCF-0547 [IN:033160]
			String ext_prod_id ="";
			if(!locale.equals("en")); 
				tmp_start_date  = DateUtils.convertDate(start_date, "DMYHM",locale,"en");
			String end_date=(String)bean.populateEndDate(freq_nature,tmp_start_date,durn_value,repeat_durn_type); //start_date changed to tmp_start_date for  SKR-SCF-0547 [IN:033160]
			boolean dupCheck = false;
			end_date  = DateUtils.convertDate(end_date, "DMYHM","en",locale);
			String ext_drug_code	= "";
			String ext_srl_no			=	"";
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						Drug_Details.put("DURN_VALUE", durn_value); //added for IN26267 --02/02/2011-- priya
						break;
					}
				}
			}			 
			out.println("assignEndDate('"+end_date+"','"+callFrom+"')"); // callFrom added for MO-GN-5490 [IN:054620] - [IN:055921]
		}
		else if(func_mode != null && func_mode.equals("populateStartDate")){
			String sys_date		= (String) hash.get( "start_date" );
			String source		= (String) hash.get( "source" );
			String sliding_scale_yn = (String) hash.get( "sliding_scale_yn" )==null?"":(String) hash.get( "sliding_scale_yn" );
			String future_date	= "";
			String back_date    = "";
			if(!locale.equals("en"))
				sys_date = DateUtils.convertDate(sys_date, "DMYHM",locale,"en");
			HashMap dateParams=(HashMap) presBean.populateDateParams(sys_date);
			if(dateParams.size()>0){
				future_date=(String) dateParams.get("future_date");
				back_date=(String) dateParams.get("back_date");
			}
			if(!locale.equals("en"))
				sys_date = DateUtils.convertDate(sys_date, "DMYHM","en",locale);
			out.println("assignStartDate('"+source+"','"+sys_date+"','"+future_date+"','"+back_date+"','"+sliding_scale_yn+"')"); //passed sliding_scale_yn  for IN22255 
		}
		else if(func_mode!= null && func_mode.equals("checkDuplicateDrug")){
			String start_date			= (String) hash.get( "start_date" );
			String durn_value			= (String) hash.get( "durn_value" );
			String end_date			= (String) hash.get( "end_date" );
			String drugCode	= (String)hash.get( "drug_code");
			String srlNo	= (String)hash.get( "srlNo");
			String ext_prod_id ="", ext_drug_code="", ext_srl_no="";
			String drug_db_interface_yn = (String)hash.get("drug_db_interface_yn")==null?"":(String)hash.get("drug_db_interface_yn");
			String drug_db_duptherapy_yn = (String)hash.get("drug_db_duptherapy_yn")==null?"":(String)hash.get("drug_db_duptherapy_yn");
			String allow_duplicate = (String)hash.get("allow_duplicate")==null?"":(String)hash.get("allow_duplicate"); //added for MO-GN-5490 [IN:054620]
			String freq_code = (String)hash.get("freq_code")==null?"":(String)hash.get("freq_code"); //added for MO-GN-5490 [IN:054620]
			String calledFrom = (String)hash.get("calledFrom")==null?"":(String)hash.get("calledFrom"); //added for MO-GN-5490 [IN:054620]
			String patient_id = (String)hash.get("patient_id");
			boolean dupCheck = false;
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			HashMap Drug_Details =null;
			if(prescriptionDetails!=null){
				for(int j=0;j<prescriptionDetails.size();j++){
					Drug_Details=(HashMap) prescriptionDetails.get(j);
					ext_drug_code=(String) Drug_Details.get("DRUG_CODE");
					ext_srl_no=(String) Drug_Details.get("SRL_NO");
					if( drugCode.equals(ext_drug_code) && (String.valueOf(srlNo)).equals(ext_srl_no) ){
						String current_rx = (String)Drug_Details.get("CURRENT_RX");
						if(freq_code==null || freq_code.equals("")) //added forMO-GN-5490 [IN:054620]
							freq_code = (String) Drug_Details.get("FREQ_CODE");
						ext_prod_id=  (String) Drug_Details.get("EXTERNAL_PRODUCT_ID")==null?"":(String) Drug_Details.get("EXTERNAL_PRODUCT_ID");
						if(!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || drug_db_duptherapy_yn.equals("N")){
							dupCheck =presBean.checkDuplicateDrug(patient_id, (String) Drug_Details.get("GENERIC_ID"), start_date,end_date,freq_code, (String) Drug_Details.get("TRN_GROUP_REF"));
							if(!dupCheck && Drug_Details.get("ALERT_YN")==null){
								Drug_Details.put("CURRENT_RX","N");
								Drug_Details.put("CURRENTRX_REMARKS","");  
								Drug_Details.put("CURRENTRX_OVERRIDE","N");
								out.println("showDuplicateInd('"+srlNo+"','N','"+(String)Drug_Details.get("SLIDING_SCALE_YN")+"','"+drugCode+"','"+calledFrom+"','"+allow_duplicate+"');"); 
							}
							else if(dupCheck){
								Drug_Details.put("CURRENT_RX","Y");
								Drug_Details.put("ORIG_CURRENT_RX","Y");
								if(presBean.checkForNull((String)Drug_Details.get("CURRENTRX_REMARKS")).equals(""))
									Drug_Details.put("CURRENTRX_OVERRIDE","N");
								out.println("showDuplicateInd('"+srlNo+"','R','"+ (String)Drug_Details.get("SLIDING_SCALE_YN")+"','"+drugCode+"','"+calledFrom+"','"+allow_duplicate+"');"); 
							}
						}
						break;
					}
				}
			}
		}
		 else if(func_mode!= null && func_mode.equals("populateQtyDesc")){			
			String form_code			= (String) hash.get("form_code");
			String pres_base_uom		= (String) hash.get("pres_base_uom")==null?"":(String) hash.get("pres_base_uom");
			String pres_base_uom_desc	= (String) hash.get("pres_base_uom_desc")==null?"":(String) hash.get("pres_base_uom_desc");
			String rx_qty_by_pres_base_uom_yn		= (String) hash.get("rx_qty_by_pres_base_uom_yn")==null?"N":(String) hash.get("rx_qty_by_pres_base_uom_yn");
			ArrayList QtyDescDetails	= (ArrayList)presBean.loadQtyDetails(form_code);
			String	uom_code	= "", uom_desc="", dflt_yn="";
			boolean deft_set = false;
			out.println("clearQtyDescList()");
			if(!rx_qty_by_pres_base_uom_yn.equals("Y")){
				for(int i=0; i<QtyDescDetails.size(); i+=3)	{
					uom_code	= (String)QtyDescDetails.get(i);
					uom_desc	= (String)QtyDescDetails.get(i+1);
					if(((String)QtyDescDetails.get(i+2)).equals("Y"))
						dflt_yn		= (String)QtyDescDetails.get(i+2);
					out.println("addQtyDescList('"+uom_code+"','"+uom_desc+"')");
					if((!pres_base_uom.equals("")) && pres_base_uom.equals(uom_code)){
						out.println("setdfltQtyUom('"+pres_base_uom+"')");
						deft_set = true;
					}					
				}
				if(!deft_set){
					String fitst_code = "";
					for(int i=0; i<QtyDescDetails.size(); i+=3)	{
						uom_code	= (String)QtyDescDetails.get(i);
						if(fitst_code.equals("")){
							fitst_code = uom_code;
						}
						if(!dflt_yn.equals("")){
							if(((String)QtyDescDetails.get(i+2)).equals("Y")){
								out.println("setdfltQtyUom('"+uom_code+"')");
								break;
							}
						}
						else{
							out.println("setdfltQtyUom('"+fitst_code+"')");
							break;
						}
					}
				}
				if(QtyDescDetails == null || QtyDescDetails.size()==0){
					out.println("addQtyDescList('','   ----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label", "common_labels")+"---   ');");
				}
				else
					out.println("dfltQtyDesc()");
			}
			else{
				if(!pres_base_uom.equals("")){
					out.println("addQtyDescList('"+pres_base_uom+"','"+pres_base_uom_desc+"')");
					out.println("setdfltQtyUom('"+pres_base_uom+"')");
					out.println("dfltQtyDesc()");
				}
				else{
					out.println("addQtyDescList('','   ----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label", "common_labels")+"---   ');");
				}
			}		
		}
		else if(func_mode!= null && func_mode.equals("MARDefault")){
			String facility_id	= (String)hash.get("facility_id"); 
			String patient_class	=(String)hash.get("patient_class"); 
			String location_code	= (String) hash.get("location_code")==null?"":(String)hash.get("location_code");
			String form_code		= (String) hash.get("form_code")==null?"":(String)hash.get("form_code");
			String priority			= (String)hash.get("priority");
			String build_MAR_Default =	bean.getMARDefaulting(patient_class,location_code,form_code,priority);
			out.println("setBuildMAR('"+build_MAR_Default+"');");
		}
		else if(func_mode!= null && func_mode.equals("loadFreqsForPriority")){			
			String priority		= (String) hash.get("priority")==null?"":(String) hash.get("priority");
			String patient_class		= (String) hash.get("patient_class")==null?"":(String) hash.get("patient_class");
			String act_patient_class		= (String) hash.get("act_patient_class")==null?"":(String) hash.get("act_patient_class");
			String calling_mode		= (String) hash.get("calling_mode")==null?"":(String) hash.get("calling_mode");
			String drug_code		= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String freq_code		= (String) hash.get("freq_code")==null?"":(String) hash.get("freq_code");
			String dup_found		= (String) hash.get("dup_found")==null?"":(String) hash.get("dup_found");
			String in_formulary_yn		= (String) hash.get("in_formulary_yn")==null?"":(String) hash.get("in_formulary_yn");
			String take_home_medication		= (String) hash.get("take_home_medication")==null?"":(String) hash.get("take_home_medication");
			String drug_class		= (String) hash.get("drug_class")==null?"":(String) hash.get("drug_class");
			String order_type_code		= (String) hash.get("order_type_code")==null?"":(String) hash.get("order_type_code");
			String srlNo		= (String) hash.get("srlNo")==null?"":(String) hash.get("srlNo");
			String callFrom		= (String) hash.get("callFrom")==null?"":(String) hash.get("callFrom");// added for MO-GN-5490 [IN:054620] - [IN:055921] -start
			String callFreqChange = "Y";
			if(callFrom.equals("DATECHANGE"))
				callFreqChange ="N";			
			String locn_code	= (String) hash.get("source_code")==null?"":(String)hash.get( "source_code" );
			String locn_type	= (String) hash.get("source_type")==null?"":(String)hash.get( "source_type" );	
			String disp_locn="";
			String disp_locn_code="";
			String disp_locn_desc="";
			String performing_facility_id="";
			String home_leave_yn_val=(String) hash.get("home_leave_yn_val")==null?"":(String)hash.get( "home_leave_yn_val" );
			String patient_id=(String) hash.get("patient_id")==null?"":(String)hash.get( "patient_id" );
			String encounter_id=(String) hash.get("encounter_id")==null?"":(String)hash.get( "encounter_id" );
			String freq_codeTmp="";
			int freq_count=0;
			boolean statFeqFound = false, priority_appl_for_freq=true;
			if( bean.getExternalpatient_id()==null ||  ((String)bean.getExternalpatient_id()).equals("") )
				locn_type	= (String)hash.get( "source_type" );	
			else
				locn_type	= "P";
			String freqCode = "";
			String freqDesc = "";
			HashMap freqValues = (HashMap)bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
			ArrayList	freqCodes	= (ArrayList) freqValues.get("FreqCode");
			ArrayList   freqDescs	= (ArrayList) freqValues.get("FreqDesc");
			ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
			if(freqCodes!=null && freqCodes.size()>0){
				if( dup_found.equals("true")){
					out.println("clearFrequencyList()");
					for(int i=0;i<freqCodes.size();i++){
						if(((String) FreqNature.get(i)).equals("O")) {// (bean.getFreqNature(((String) freqCodes.get(i))))
							freqCode=(String) freqCodes.get(i);
							freqDesc=(String) freqDescs.get(i);
							freqDesc=freqDesc.replaceAll(" ","%20");
							freqDesc = java.net.URLEncoder.encode(freqDesc,"UTF-8");
							freqDesc=freqDesc.replaceAll("%2520","%20");
							out.println("addFrequencyList('"+freqCode+"','"+freqDesc+"','"+freq_code.trim()+"')");
							freq_count++;
						}
					}					
					if(freq_count == 0){ 
						out.println("addFrequencyList('','---- Select Value ----')");
						out.println("alertNoApplicaFreq('"+priority+"')");
						priority_appl_for_freq=false;
					}
				}
				else {
					if(callFrom.equals("DATECHANGE")){ 
						out.println("clearFrequencyList()");
						for(int i=0;i<freqCodes.size();i++){
							freqCode=(String) freqCodes.get(i);
							freqDesc=(String) freqDescs.get(i);
							freqDesc=freqDesc.replaceAll(" ","%20");
							freqDesc = java.net.URLEncoder.encode(freqDesc,"UTF-8");
							freqDesc=freqDesc.replaceAll("%2520","%20");
							out.println("addFrequencyList('"+freqCode+"','"+freqDesc+"','"+freq_code.trim()+"')");
							freq_count++;
						}
						if(freq_count == 0){
							out.println("addFrequencyList('','---- Select Value ----')");
							priority_appl_for_freq=false;
						}
					}
				
					if(priority.equals("U")){
						ArrayList stat_freqs	=	presBean.loadStatFreqs();
						if(stat_freqs.size()>0){
							for(int i=0;i<stat_freqs.size();i+=2){
								freq_codeTmp =(String) stat_freqs.get(i);
								for(int j=0;j<freqCodes.size();j++){
									freqCode=(String) freqCodes.get(j);
									if(freq_codeTmp.equals(freqCode) ){
										out.println("dfltFreq('"+freqCode+"','"+callFreqChange+"')"); // 
										statFeqFound = true;
										break;
									}
								}
							}
						}
						if(!statFeqFound){ 
							out.println("alertNoApplicaFreq('"+priority+"')");
							out.println("dfltFreq('"+freq_code.trim()+"','"+callFreqChange+"')"); 
							priority_appl_for_freq = false;
						}
					}
					else{
						if(bean.getFreqNature(freq_code).equals("O")){//((String) FreqNature.get(i))
							for(int i=0;i<freqCodes.size();i++){
								freqCode=(String) freqCodes.get(i);
								if(!((String) FreqNature.get(i)).equals("O")){//bean.getFreqNature(freqCode)
									freq_code = freqCode;
									freq_count++;
									break;
								}
							}
						}
						else
							freq_count++;
						
						if(freq_count == 0){ 
							out.println("alertNoApplicaFreq('"+priority+"')");
							priority_appl_for_freq = false;
						}
						else
							out.println("dfltFreq('"+freq_code.trim()+"','"+callFreqChange+"')"); 
					}
				}
			}
			else{
				out.println("addFrequencyList('','---- Select Value ----')");
				out.println("alertNoApplicaFreq('"+priority+"')");
				priority_appl_for_freq = false;
			}
		}
		else if(func_mode != null && func_mode.equals("getActiontext" )){ 
			String form_code		= (String)hash.get("form_code")==null?"":(String)hash.get("form_code");
			String route_code		= (String)hash.get("route_code")==null?"":(String)hash.get("route_code");
			String actionText = presBean.getActionText(form_code,route_code);		
			out.println("assignActionText('"+actionText+"');"); 
		}
		else if(func_mode != null && func_mode.equals("revertRxDetails" )){ 
			String DURN_VALUE		= (String)hash.get("DURN_VALUE")==null?"":(String)hash.get("DURN_VALUE");
			String DRUG_CODE		= (String)hash.get("DRUG_CODE")==null?"":(String)hash.get("DRUG_CODE");
			String SRL_NO			= (String)hash.get("SRL_NO")==null?"":(String)hash.get("SRL_NO");
			String freq_chng_durn_desc = (String)hash.get("freq_chng_durn_desc")==null?"":(String)hash.get("freq_chng_durn_desc");
			
			HashMap hm_drugData            = null;  
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
				hm_drugData				=(HashMap) prescriptionDetails.get(j);
				String str_drug_code	=(String) hm_drugData.get("DRUG_CODE");
				String str_srl_no		=(String) hm_drugData.get("SRL_NO");
				if( DRUG_CODE.equals(str_drug_code) && (String.valueOf(SRL_NO)).equals(str_srl_no) ){
					hm_drugData.put("DURN_VALUE",DURN_VALUE);
					hm_drugData.put("freq_chng_durn_desc",freq_chng_durn_desc);
				}
			}
		}
		else if (func_mode!= null && func_mode.equals("getChargeDetails")){
			String drug_code			= (String) hash.get("drug_code")==null?"":(String) hash.get("drug_code");
			String srl_no				= (String) hash.get("srl_no")==null?"":(String) hash.get("srl_no");
			String qty_value			= (String) hash.get("qty_value")==null?"":(String) hash.get("qty_value");
			String repeat_value			= (String) hash.get("repeat_value")==null?"1":(String) hash.get("repeat_value");
			String dosage_type			= (String) hash.get("dosage_type")==null?"":(String) hash.get("dosage_type");
			String patient_id			= (String) hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			String encounter_id			= (String) hash.get("encounter_id")==null?"":(String) hash.get("encounter_id");
			String episode_type			= (String) hash.get("episode_type")==null?"":(String) hash.get("episode_type");
			String durn_value			= (String) hash.get("durn_value")==null?"1":(String) hash.get("durn_value");
			String interval_value		= (String) hash.get("interval_value")==null?"1":(String) hash.get("interval_value");
			String qty_desc_code		= (String) hash.get( "qty_desc_code" )==null?"":(String) hash.get("qty_desc_code");
			String bl_override_excl_incl_ind  = (String) hash.get("bl_override_excl_incl_ind")==null?"":(String) hash.get("bl_override_excl_incl_ind");
			String bl_overriden_action_reason = (String) hash.get("bl_overriden_action_reason")==null?"":(String) hash.get("bl_overriden_action_reason");
			String order_Date			= (String) hash.get("order_Date")==null?"":(String) hash.get("order_Date");
			String called_from			= (String) hash.get("called_from")==null?"":(String) hash.get("called_from");
			String sliding_scale_yn		= (String) hash.get("sliding_scale_yn")==null?"":(String) hash.get("sliding_scale_yn");
			String billable_item_yn	= (String) hash.get("billable_item_yn")==null?"":(String) hash.get("billable_item_yn");
			String pat_brought_medn = (String) hash.get("pat_brought_medn")==null?"":(String) hash.get("pat_brought_medn");
			String drug_desc			= "";
			String in_formulary_yn		= "";
			String bl_def_excl_incl_ind = "";
			String fract_dose_round_up_yn = "";
			String take_home_medication		= (String) hash.get("take_home_medication");
			if(!locale.equals("en"));
				order_Date				= DateUtils.convertDate(order_Date, "DMYHM",locale,"en");
			String ext_srl_no				= null;
			String ext_drug_code            = null;
			HashMap drug_detail             = null;  
			ArrayList prescriptionDetails	=(ArrayList)bean.getpresDetails();
			for(int j=0;j<prescriptionDetails.size();j++){
			  drug_detail					=(HashMap) prescriptionDetails.get(j);
			  ext_drug_code					=(String) drug_detail.get("DRUG_CODE");
			  ext_srl_no					=(String) drug_detail.get("SRL_NO");
				if( drug_code.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					 drug_detail.put("REPEAT_VALUE",repeat_value);
					drug_desc			    = (String)drug_detail.get("DRUG_DESC");
					in_formulary_yn			= (String)drug_detail.get("IN_FORMULARY_YN");
					drug_detail.put("BROUGHT_BY_PAT",pat_brought_medn);  // added for IN23880 --25/10/2010-- priya
					break;
				 }
			}
			if(drug_detail != null && in_formulary_yn.equals("Y")){ //Code added for IN22611 to calculate  quantity value for split dose and fract_dose_round_up 'Y'  -Start
				fract_dose_round_up_yn = (String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN")==null?"":(String) drug_detail.get("FRACT_DOSE_ROUND_UP_YN");
				ArrayList	schedule	=	(ArrayList)bean.getScheduleFrequencyStr(ext_drug_code+ext_srl_no,"0");
				ArrayList dose_list = null;
				if(schedule!=null && schedule.size() > 0) {
					 dose_list	=	(ArrayList)schedule.get(4);
					 if(dose_list !=null && dose_list.size()>0){
						 if(!dosage_type.equals("A") && !called_from.equals("TAPER_QTY"))
							qty_value		=	(String)dose_list.get(0);
					 }
				}
				boolean split_chk	=	bean.checkSplit(schedule);
				if(split_chk && dose_list !=null && dose_list.size()>0 && !called_from.equals("TAPER_QTY")){
					qty_value = "0";
					for(int d=0; d<dose_list.size(); d++){
						if(!((String)dose_list.get(d)).equals("")){
							if(fract_dose_round_up_yn.equals("N"))
								qty_value = (Float.parseFloat(qty_value) + Float.parseFloat((String)dose_list.get(d)))+"";
							else if(fract_dose_round_up_yn.equals("Y"))
								qty_value = (Float.parseFloat(qty_value) + Math.ceil(Float.parseFloat((String)dose_list.get(d))))+"";
						}
					}
				}//Code added for IN22611  -End
				if(!called_from.equals("ASSIGN_OVERRIDE")){
                  bl_override_excl_incl_ind = (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");
				}
    			if(billable_item_yn.equals("Y")){
					if(bl_override_excl_incl_ind.equals("SEL")){
						bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,"", bl_overriden_action_reason, called_from,take_home_medication);//,pat_brought_medn
					}
					else{
					   bean.setBillingDetail(drug_detail,dosage_type, qty_value, qty_desc_code, repeat_value,durn_value,interval_value, patient_id, encounter_id, episode_type, order_Date,bl_override_excl_incl_ind, bl_overriden_action_reason, called_from,take_home_medication);//,pat_brought_medn
					}
				}
				String bl_total_charge_amt		= (String)drug_detail.get("BL_TOTAL_CHARGE_AMT")==null?"0.0":(String)drug_detail.get("BL_TOTAL_CHARGE_AMT");
				String bl_patient_payable_amt	= (String)drug_detail.get("BL_PATIENT_PAYABLE_AMT")==null?"0.0":(String)drug_detail.get("BL_PATIENT_PAYABLE_AMT");
				String bl_approval_reqd_yn		= (String)drug_detail.get("BL_APPROVAL_REQD_YN")==null?"N":(String)drug_detail.get("BL_APPROVAL_REQD_YN");
				String bl_override_allowed_yn	= (String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drug_detail.get("BL_OVERRIDE_ALLOWED_YN");
				bl_def_excl_incl_ind		= (String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"":(String)drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");
				String bl_error_code			= (String)drug_detail.get("BL_ERROR_CODE")==null?"":(String)drug_detail.get("BL_ERROR_CODE"); 
				String bl_sys_message_id		= (String)drug_detail.get("BL_SYS_MESSAGE_ID")==null?"":(String)drug_detail.get("BL_SYS_MESSAGE_ID");
				String bl_error_text			= (String)drug_detail.get("BL_ERROR_TEXT")==null?"":(String)drug_detail.get("BL_ERROR_TEXT");
				if(!(bl_error_code.equals("") && bl_sys_message_id.equals("") && bl_error_text.equals(""))){
					ArrayList blErrorDrugs = new ArrayList();
					if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
						blErrorDrugs.add(drug_code.trim());
						blErrorDrugs.add(srl_no.trim());
						drug_desc=drug_desc.replaceAll(" ","%20");
						drug_desc = java.net.URLEncoder.encode(drug_desc,"UTF-8");
						drug_desc=drug_desc.replaceAll("%2520","%20");
						blErrorDrugs.add(drug_desc);
						blErrorDrugs.add(bl_error_code);
						blErrorDrugs.add(bl_sys_message_id);
						blErrorDrugs.add(bl_error_text);
					}
					if(blErrorDrugs.size()>0){
						out.println("alertBLErrorDrugs('"+blErrorDrugs+"','BLERRORDET');");
					}
				}
				else
					out.println("assignChargeDetails('"+bl_total_charge_amt+"','"+bl_patient_payable_amt+"','"+bl_def_excl_incl_ind+"','"+bl_approval_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+bl_override_excl_incl_ind+"');");

				return;
			}
			else{
				out.println("clearDrugdetails('"+sliding_scale_yn+"');");
			}
		}
		PersistenceHelper.putObjectInBean(bean_id,bean,request);
		PersistenceHelper.putObjectInBean(presBean_id,presBean,request);
	}
	catch (Exception e) {
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
