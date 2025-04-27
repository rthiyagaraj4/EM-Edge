package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.NotesData;
import eIPAD.HealthObjects.Notes;
import ePH.DrugSearchBean;
import com.ehis.persist.PersistenceHelper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __searchrx extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/searchRx.jsp", 1738426370434L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPadPharmaColumLayout.css\" />\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" /> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<div id=\"OrdListHWrapper_";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" style=\"position: relative; height:100%; width: 100%; overflow: hidden;\" class=\"ordListHWrapper table\">\n    <div style=\"position:absolute; width: auto; height: 100%;\" id=\"OrdItemscroller_";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n        <ul id=\"OrdListColWrap_";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" class=\"ordListColWrap row\" style=\"height: 100%; margin-top: 0px; padding-left: 0px;\">\n            ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<li>\t\t\t\t\t\t\t\t\t\n                    <div  id=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" data-currentid=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  data-drugCodeUnique=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" data-drugName=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" data-drugCode=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" data-tradeCodes=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" data-tradeName=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" data-Priority=\"R\" data-OrderCatCode=\"PH\" data-previligeGroupDrugOrdering_YN=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" data-diagnosis_found_yn=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" data-appl_for_age_grp_yn=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" data-in_formulary=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" data-drug_class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" data-stock_yn=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" data-allow_yn=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" data-avl_qty=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\" class=\"rxBuble rxBubleTable ordDraggable_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n                        <div class=\"rxBubleRow\">\n                            <div class=\"rxBubleCellContent\">\n                                <div class=\"rxBubleLable\">\n                                    ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n                                </div>\n                            </div>\n                            ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n                                <div class=\"rxBubleCellIconInStock\">\n                                    <img src=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="/eIPAD/images/Drag25x25.png\">\n                                </div>\n                                ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                                    <div class=\"rxBubleCellIconOutStock\">\n                                        <img src=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="/eIPAD/images/Drag25x25.png\">\n                                    </div>\n                                    ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n                        </div>\n                    </div>\n                </li>\n                ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="                    <input type=\"hidden\" id=\"no_record\" value=\"no\">\n                    ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n        </ul>\n    </div>\n</div>\n<script src=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="/eIPAD/js/PharamaColumnLayout.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="/eIPAD/js/lib/kendo/kendo.all.min.js\"></script>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="/eIPAD/css/kendo/kendo.common.min.css\" />\n<script>\n    $(document).ready(function() {\n        var checkForRec = $(\'#no_record\').val();\n        if (checkForRec != \'no\') \n\t\t{\t\t\n            var ordListColWrap = $(\'#\' + \"OrdListColWrap_A\");\n            var ordListColParent = ordListColWrap.parent();\n            var ordListColItems1 = ordListColWrap.children();         \n            onOriChange();\n           // assignOrdItemsHScroll_S();\n           // dragAndDrop();\n            $(\'#no_record\').val(\"\");\n        }         \t\n\t}); \n</script>\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);

String orderNature="A";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block9Bytes, _wl_block9);

        PatContext patientContextInsit = (PatContext)session.getAttribute("PatientContext"); 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
		String rxSeachValue= request.getParameter("enterTypes");	
		String act_patient_class = request.getParameter("act_patient_class")==null?"IP":request.getParameter("act_patient_class");
		String bean_id 				= "@DrugSearchBean"+patientContextInsit.getPatientId()+patientContextInsit.getEncounterId();					
		String ivrxModeValue = request.getParameter("mode");
		String	bean_name			=	"ePH.DrugSearchBean";		
		DrugSearchBean bean = (DrugSearchBean)PersistenceHelper.getBeanObject(  bean_id, bean_name, request ) ;			
	    bean.setLanguageId(locale);	    
	    bean.setDrugSearchBy("C");
		bean.setPatientId(patientContextInsit.getPatientId());
		bean.setEncounterId(patientContextInsit.getEncounterId());
		bean.setGender(patientContextInsit.getGender());
		bean.setPriviligeDrugCheck("A");
		bean.setPatientClass(act_patient_class);	   
		Hashtable table = new Hashtable();
	    table.put("name", rxSeachValue);
	    table.put("priviligeCheck", "A");	    
	    table.put("code", "");
	    table.put("strength_value", "");
	    table.put("npb_drug", "D");	    
	    table.put("form_code", "");
	    table.put("route_code", "");
	    table.put("identity", "MedicationOrder");
	    table.put("in_formulary_yn","");
	    table.put("search_by","A");
	    table.put("order_type_code",""); 
	    table.put("strength_uom","");
	    table.put("drug_search_by","C"); 
	    table.put("res_by_service","N");
	    
	    bean.setMainCriteriaData(table);		
		String from="0";
		String to="1000";		
		String search_by		="A";
		String searchBasedOn="Drug";		
		String bl_install_yn= "Y";
		String disp_charge_dtl_in_drug_lkp_yn ="Y"; 
		String disp_price_type_in_drug_lkp="P";
		String priviligeCheck_fromSearch="A";
		String practitionerId =patientContextInsit.getClinicianId();
		String resp_id =patientContextInsit.getResponsibilityID();
		String drug_priv_appln_yn= bean.getDrugPrivilegeYN();
		ArrayList arrList = new ArrayList();		
		bean.setPriviligeDrugCheck(priviligeCheck_fromSearch);					
		bean.setSearchBy("A");	
		bean.setDrugOrFluid(ivrxModeValue);	
		arrList	=     (ArrayList)bean.searchBasedOnDataSelected(from, to, bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp, priviligeCheck_fromSearch, practitionerId, resp_id, drug_priv_appln_yn);			
		String drug_code;
		String description;
		ArrayList stock_dtls	=	null;
		String trade_code; 
		String drug_class;
		String order_type_code;
		String consider_stock="A";		
		String patient_id=bean.getPatientId();
		String encounter_id=bean.getEncounterId();
		String trade_name;		
		String stock_yn="";
		String avl_qty;
		String store_desc;
		String store_code;
		String strEnableDisable="disabled";		
		order_type_code=bean.getOrderTypeCode();
		ArrayList stock_params	=	bean.validateForStock();
		if(stock_params.size() > 1) 
		{
		consider_stock					= (String)stock_params.get(0);
		disp_charge_dtl_in_drug_lkp_yn	= (String)stock_params.get(2);
		disp_price_type_in_drug_lkp		= (String)stock_params.get(3);
		}							
	if(!rxSeachValue.equalsIgnoreCase(""))	{		
		if(arrList.size()!=1){
		for(int i=1;i<arrList.size();i++){	
	      String[] strArray=(String[])arrList.get(i);
							drug_code		= strArray[0];
							if(search_by.equals("G")) {
								description	=	strArray[8];
							}
							else {
								description	=	strArray[1];
							}							
							trade_code= strArray[10]==null?"":strArray[10];
							trade_name=java.net.URLEncoder.encode(strArray[11]);
							drug_class=strArray[21];
							
							stock_dtls		= bean.checkStock(drug_code, trade_code, drug_class, order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id);
							avl_qty="0";
							if(stock_dtls!=null && stock_dtls.size() > 0) {
									stock_yn			=	(String)stock_dtls.get(0);
									avl_qty				=	(String)stock_dtls.get(1);
									store_desc			=	(String)stock_dtls.get(2)==null?"":(String)stock_dtls.get(2);
									if(store_desc.indexOf('|') != -1)
										store_desc = store_desc.substring(0,store_desc.indexOf('|'));
									if(strEnableDisable.equals(""))
										strEnableDisable	=	(String)stock_dtls.get(3);						
									store_code			=	(String)stock_dtls.get(4)==null?"":(String)stock_dtls.get(4);
								}
String id_drug= drug_code.replaceAll("[-+.^:,]","");						
String trad="T";
if(!trade_name.equalsIgnoreCase("")){	
	trad=trade_name;
}	
String id_trad= trad.replaceAll("[-+.^:,]","");	
String id_drugName_tradeName=id_drug+"_"+id_trad;
ArrayList stock_params_check	=	bean.validateForStock();
String allow_yn	=	(String)stock_params_check.get(1);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id_drugName_tradeName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id_drug));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(description));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strArray[25]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strArray[20]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strArray[22]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strArray[13]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strArray[21]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(stock_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(allow_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(avl_qty ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(orderNature ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( description ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(trade_name));
            _bw.write(_wl_block28Bytes, _wl_block28);

			if(Float.parseFloat(avl_qty)>0){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
				}else{
			
	
            _bw.write(_wl_block34Bytes, _wl_block34);
		}
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);
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
