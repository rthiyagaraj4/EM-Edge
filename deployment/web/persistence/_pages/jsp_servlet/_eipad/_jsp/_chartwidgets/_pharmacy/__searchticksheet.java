package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryBean;
import ePH.DrugSearchBean;
import eCommon.Common.CommonBean;
import eIPAD.chartsummary.clinicalnotes.healthobject.NotesData;
import eIPAD.HealthObjects.Notes;
import ePH.DrugSearchBean;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.healthobject.PatContext;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;

public final class __searchticksheet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/searchTicksheet.jsp", 1709118022443L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 =" \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPadPharmaColumLayout.css\" />\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" /> \t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<div id=\"OrdListHWrapper_";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" style=\"position: relative; height:100%; width: 100%; overflow: hidden;\" class=\"ordListHWrapper table\">\n\t\t<div style=\"position:absolute; width: auto; height: 100%;\" id=\"OrdItemscroller_";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"> \t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<ul id=\"OrdListColWrap_";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" class=\"ordListColWrap row\" style=\"height: 100%; margin-top: 0px; padding-left: 0px;\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<li>\n\t\t<div  id=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" data-currentid=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  data-drugCodeUnique=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" \n\t\tdata-drugName=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" data-drugCode=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" data-tradeCodes=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" data-tradeName=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" \t\t\n\t\tdata-Priority=\"R\" data-OrderCatCode=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\t\t\n\t\tdata-previligeGroupDrugOrdering_YN=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" data-diagnosis_found_yn=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" data-appl_for_age_grp_yn=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\t\t\n\t\tdata-in_formulary=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\n\t\tdata-drug_class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" data-stock_yn=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" data-allow_yn=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"\n\t\tclass=\"rxBuble rxBubleTable ordDraggable_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<div class=\"rxBubleRow\">\n\t\t\t\t<div class=\"rxBubleCellContent\">\n\t\t\t\t\t<div class=\"rxBubleLable\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div>\n\t\t\t\t</div>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<div class=\"rxBubleCellIconInStock\"><img src=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/Drag25x25.png\"></div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<div class=\"rxBubleCellIconOutStock\"><img src=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</div>\n\t\t</div>\n</li>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</ul>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\n\t<div id=\"noticksheetitemsMsg\" data-no_records=\"true\"  style=\"display: table;height: 100%;width: 100%;\" >\t\t\t\n\t    <div class=\"pharmEmptyData\">No ticksheet items found</div>\n\t</div>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t</div>\n\t</div>\n\t\n<script src=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="/eIPAD/js/PharamaColumnLayout.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="/eIPAD/js/lib/kendo/kendo.all.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/eIPAD/css/kendo/kendo.common.min.css\" />\n<script>\n    $(document).ready(function() {\n        var checkForRec = $(\'#no_record\').val();\n        if (checkForRec != \'no\') \n\t\t{\t\t\n            var ordListColWrap = $(\'#\' + \"OrdListColWrap_A\");\n            var ordListColParent = ordListColWrap.parent();\n           var ordListColItems1 = ordListColWrap.children();         \n           onOriChange();\n           //assignOrdItemsHScroll_S();\n          // dragAndDrop();\n            $(\'#no_record\').val(\"\");\n        }    }); \n</script>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );
	
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
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);

String orderNature="A";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(orderNature));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block8Bytes, _wl_block8);

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String patient_id = patientContext.getPatientId();
String encounter_id	= patientContext.getEncounterId();
String patient_class = patientContext.getPatientClass();
String facility_id = patientContext.getFacilityId();
String locale = patientContext.getLocale();			
String bean_name				= "eOR.OrderEntryBean";
String bean_id				= "@orderentrybean"+patient_id+encounter_id;
String  order_dispaly_verticalYN		= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");		
OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
String order_type 			= "";
String activity_type 		= "";
String order_category 		= "PH";
String tick_sheet_id 		= request.getParameter("tick_sheet_id");
String section_code 		=request.getParameter("codeValue");
String function_from		= "";
String order_catalog_nature	= "";
String priv_applicability_yn= "Y"; 
String prev_group_title		= "";
String checkedAttribute 	= "";
String disabled				= "";
String care_set_order		= "";
String order_catalog_category = "";
String entryValue			= "";	
int display_records = 44;
String key					= (bean.getPatientId()+bean.getEncounterId());
if(!order_type.equals(""))	order_type = order_type.trim();
if(!order_category.equals(""))	order_category = order_category.trim();
if(!tick_sheet_id.equals(""))	tick_sheet_id = tick_sheet_id.trim();
if(!section_code.equals(""))	section_code = section_code.trim();
int i=0;int count = 0;
String amend_key	= "";
HashMap previousValues		= null;
HashMap amendPreviousValues = null;
Set setValues 				= null;
Iterator iterator			= null;
StringTokenizer stBillMsg	= null;
String measure_id			= "";
String contr_msr_panel_id = "";
String category				= "";
String group_title="";
String order_nature = "A";
String from_obj = null;
if("S".equals(order_nature)){
	from_obj = "resultHdrFrame";
	}else if("P".equals(order_nature)){
	from_obj = "resultListFrame";
	}else if("A".equals(order_nature)){
	from_obj = "resultDtlFrame";
}
String sqlQuery	= "";
String str	= "";
String orderSetVal = "";
String panelVal = "";
String individualVal  = "";
String frm1 = "" , frm2 = "" , frm3 = "";
ArrayList records= null;

sqlQuery  ="SELECT a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text,e.drug_class ,e.in_formulary_yn , (select Ph_Drug_Appl_For_Pat_age_grp(E.drug_code,?,?) from dual) appl_for_age_grp_yn,NVL((SELECT MAX(DECODE ((SELECT pr_diag.term_set_id FROM pr_diagnosis pr_diag WHERE pr_diag.term_set_id = ph_elig.term_set_id AND pr_diag.term_code =ph_elig.term_code AND pr_diag.patient_id = ?),NULL, 'N','Y')) diag FROM ph_drug_eligible_term_code ph_elig WHERE ph_elig.drug_code = E.drug_code AND ph_elig.eff_status = 'E'),'Y') diagnosis_found_yn,or_get_priv_appl_yn (?,?,'OR',E.drug_code,?,b.order_type_code,'PH') priv_appl_yn FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d, ph_drug e, or_order_type f WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and a.order_catalog_code=e.drug_code and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!'))   AND b.order_type_code = NVL (?, b.order_type_code)  AND b.order_type_code=f.order_type_code AND f.order_category='PH' and f.freq_APPLICABLE_YN='Y'  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";

if(priv_applicability_yn.equalsIgnoreCase("Y")){
	sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
	sqlQuery = sqlQuery.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
}else if(priv_applicability_yn.equalsIgnoreCase("N")){
	sqlQuery = sqlQuery.replace("##FILTERCAT##","");
	sqlQuery = sqlQuery.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
}else{
	sqlQuery = sqlQuery.replace("##FILTERCAT##","");
	sqlQuery = sqlQuery.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
}
HashMap sqlMap = new HashMap();
//Include all the common parameters.
sqlMap.put( "sqlData",sqlQuery);
//Function Parameters
HashMap funcMap = new HashMap();

//Display Fields
ArrayList displayFields = new ArrayList();
displayFields.add("order_catalog_code");
displayFields.add("catalog_synonym");
displayFields.add("order_catalog_nature");
displayFields.add("discr_msr_panel_id");//3
displayFields.add("prompt_alert_yn");
displayFields.add("prompt_alert_msg");
displayFields.add("order_category");
displayFields.add("order_type_code");
displayFields.add("ord_auth_reqd_yn");//8
displayFields.add("contr_msr_panel_id");
displayFields.add("ord_spl_appr_reqd_yn");//10
displayFields.add("priv_yn");//11
displayFields.add("explanatory_text");//12
displayFields.add("drug_class");//13
displayFields.add("in_formulary_yn");//14
displayFields.add("appl_for_age_grp_yn");//15
displayFields.add("diagnosis_found_yn");//16
displayFields.add("priv_appl_yn");//17

ArrayList chkFields = new ArrayList();
	chkFields.add(bean.getPractitionerType());
	chkFields.add(bean.getLanguageId());
	chkFields.add(bean.getLoginFacilityId());
	chkFields.add(bean.getLocationType());
	chkFields.add(bean.getLocationCode());

if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N"))){
	chkFields.add(bean.getPractitionerId());
	chkFields.add(bean.getResponsibilityId());
	chkFields.add(bean.getAuthorisationOrOrderingYn("ORD"));
}
	chkFields.add(bean.checkForNull(bean.getDob(),""));
	chkFields.add(bean.checkForNull(bean.getSex(),""));
	chkFields.add(bean.checkForNull(bean.getPatientId(),""));
	
	chkFields.add(bean.getPractitionerId());
	chkFields.add(bean.getResponsibilityId());
	chkFields.add(bean.getPrivilegeApplicability());
	
	chkFields.add(bean.checkForNull(tick_sheet_id.trim(),""));
	chkFields.add(bean.checkForNull(section_code,""));

	chkFields.add(bean.getPatientClass());
	chkFields.add(bean.getPatientClass());
	chkFields.add(bean.checkForNull(bean.getSex(),""));
	chkFields.add(bean.checkForNull(bean.getDob(),""));
	chkFields.add(bean.getLoginFacilityId());
	chkFields.add(bean.checkForNull(bean.getEncounterId(),""));
	chkFields.add(bean.getPatientClass());
	chkFields.add(bean.getVisitAdmDate());
	chkFields.add(bean.checkForNull(bean.getDischargeDateTime(),""));
	chkFields.add(bean.getPractitionerType());
	
	if((bean.checkForNull(order_category.trim(),"")).equals("*A")){
		chkFields.add("");
	}else{
		chkFields.add(bean.checkForNull(order_category.trim(),""));
	}
	chkFields.add(bean.checkForNull(activity_type,""));
	chkFields.add(bean.checkForNull(order_type,""));
	if(priv_applicability_yn.equalsIgnoreCase("Y")){
		chkFields.add(bean.getPractitionerId());
		chkFields.add(bean.getResponsibilityId());
		chkFields.add(bean.getPrivilegeApplicability());
	}
			
	// Adding function related array list into the HashMap
	funcMap.put("displayFields",displayFields);
	funcMap.put("chkFields",chkFields);

	ArrayList TickSheetItems=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,display_records);
	records	 =new ArrayList();
	
	ArrayList stock_dtls	=	null;
	
	String avl_qty="0";
	String  store_desc="";
	String  stock_yn="";
	String allow_yn="";
	String DrugSearchbean_id 			= "@DrugSearchBean"+patient_id+encounter_id;
	String	DrugSearchbean_name			=	"ePH.DrugSearchBean";	
	DrugSearchBean DrugSearchbean = (DrugSearchBean)PersistenceHelper.getBeanObject(DrugSearchbean_id, DrugSearchbean_name, request ) ;
	ArrayList drug_dtls =	null;
	
	if(TickSheetItems!=null && TickSheetItems.size()>2)
	{
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block10Bytes, _wl_block10);

	for(int recCount=2; recCount<TickSheetItems.size(); recCount++)
		{
			records=(ArrayList) TickSheetItems.get(recCount);
			String drugType= (String) records.get(7);
			
			String id_drug=(String)records.get(0);
			id_drug= id_drug.replaceAll("[-+.^:,]",""); 
			String trade_name="";
			String description=(String)records.get(1);
			String drug_code=(String)records.get(0);
			String id_trad= drug_code.replaceAll("[-+.^:,]","");
			String id_drugName_tradeName=id_trad+"_"+"T";
			String trade_code="";
			String drug_class=(String)records.get(13);
			String in_formulary_yn=(String)records.get(14);
			String appl_for_age_grp_yn=(String)records.get(15);
			String diagnosis_found_yn=(String)records.get(16);
			String previligeGroupDrugOrdering_YN=(String)records.get(17);					
			drug_dtls	=	DrugSearchbean.getPreferredDrugDetails(id_drug);
			if(drug_dtls!=null && drug_dtls.size() > 0) 
			{				
				trade_code=	(String)drug_dtls.get(3);
				trade_name=	(String)drug_dtls.get(4);
			}			
			stock_dtls		= DrugSearchbean.checkStock(drug_code, trade_code, drug_class, "","","",patient_id,encounter_id);			
			avl_qty="0";
			stock_yn="";
			allow_yn="";
			if(stock_dtls!=null && stock_dtls.size() > 0)
			{
				 stock_yn	=	(String)stock_dtls.get(0);
				 avl_qty		=	(String)stock_dtls.get(1);
			}
			ArrayList stock_params_check	=	DrugSearchbean.validateForStock();
			allow_yn	=	(String)stock_params_check.get(1);
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id_drug));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(description));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(previligeGroupDrugOrdering_YN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diagnosis_found_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(appl_for_age_grp_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(in_formulary_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(stock_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(allow_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(description));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block29Bytes, _wl_block29);

					if(Float.parseFloat(avl_qty)>0){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
} else {
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
