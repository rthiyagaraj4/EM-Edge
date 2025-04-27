package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescription extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/Prescription.jsp", 1734850696998L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--saved on 27th Oct 2005 -->\n<!--\nDeveloped by    : P.Sudhakaran.\nModule/Function : OP/IP Prescription Transaction calling from CA\n-->\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/IVPrescription.js\"></script> \n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<!-- \t<frameset rows=\"50,*\" > -->\n\t\t\t<iframe name=\"f_header\" id=\"f_header\" frameborder=\"0\" scrolling=\"no\"  noresize src=\"../../ePH/jsp/PrescriptionHeader_2.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  style=\'height:19vh;width:97vw\'></iframe>\n\t\t\t<iframe name=\"f_options\"  id=\"f_options\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/IVPrescriptionOptions.jsp?iv_prep_yn=+";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&patient_id=+";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&act_patient_class=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&encounter_id=+";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\'height:9vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\"f_detail\" id=\"f_detail\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" style=\'height:74vh;width:72vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\"f_button\" id=\"f_button\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/IVPrescriptionButtons.jsp?iv_prep_yn=+";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\'height:12vh;width:100vw\'></iframe>\n\t\t<!-- \t<frameset cols=\"27%,*\" id=\"PrescriptionDetailFrameSet\" name=\"PrescriptionDetailFrameSet\"> -->\n\t\t\t\t<iframe name=\"f_prescription\" id=\"f_prescription\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"CATHIRDWORKAREA\" style=\'height:73vh;width:26vw\'></iframe>\n\t\t\t\t<iframe name=\"f_options\"  id=\"f_options\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/IVPrescriptionOptions.jsp?iv_prep_yn=+";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t<!-- \t<frameset rows=\"*,10.5\" > -->\n\t\t\t\t\t<iframe name=\"f_detail\" id=\"f_detail\" frameborder=\"0\" scrolling=\"no\"  src=\"../../eCommon/html/blank.html\" style=\'height:74vh;width:72vw\'></iframe>\n\t\t\t\t\t<iframe name=\"f_button\" id=\"f_button\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"FR_BORDER2\" style=\'height:12vh;width:100vw\'></iframe>\n\t\t<!-- \t\t</frameset> -->\n\t\t\t<!-- </frameset> -->\n\t\t<!-- </frameset> -->\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<!-- <frameset rows=\"10%,*\" > -->\n\t\t<div style=\"display:flex ; flex-direction: column;\" >\n\t\t\t<iframe name=\"f_header\" id=\"f_header\" frameborder=\"0\" scrolling=\"no\"  noresize src=\"../../ePH/jsp/PrescriptionHeader_2.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  style=\'height:7vh;width:97vw\'></iframe>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<!-- <frameset rows=\"8%,80%,*\" > -->\n\t\t\t\t\t\t<iframe name=\"f_options\"  id=\"f_options\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/IVPrescriptionOptions.jsp?iv_prep_yn=+";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\t<!-- </frameset> -->\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<!-- <FRAMESET ROWS=\"39,*\" FRAMESPACING=\"0\"> -->\n\t\t\t\t\t\t<IFRAME NAME=\"f_tpnregimenselect\" id=\"f_tpnregimenselect\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE  src=\"../../eCommon/html/blank.html\" style=\'height:9vh;width:100vw\'></IFRAME>   \n\t\t\t\t\t\t<!-- //src=\"../../ePH/jsp/TPNRegimenOptions.jsp?iv_prep_yn=+";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patient_class=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" > -->\n\t\t\t\t\t\t<IFRAME NAME=\"f_tpnregimen\" id=\"f_tpnregimen\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE\tsrc=\"../../eCommon/html/blank.html\" style=\'height:89vh;width:100vw\'></IFRAME>\n\t\t\t\t\t\t<!-- /*src=\"../../ePH/jsp/TPNRegStdRegFrames.jsp?iv_prep_yn=+";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"> -->\n\t\t\t\t\t<!-- </FRAMESET> -->\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<!-- <FRAMESET  FRAMESPACING=\"0\"> -->\n\t\t\t\t\t\t<IFRAME NAME=\"oncology_detail\" id=\"oncology_detail\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE src=\"../../eCommon/html/blank.html\" style=\'height:9vh;width:100vw\'></IFRAME>\n\t\t\t\t\t<!-- </FRAMESET> -->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<!-- <FRAMESET  FRAMESPACING=\"0\"> -->\n\t\t\t\t\t\t<IFRAME NAME=\"f_compound\" id=\"f_compound\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE src=\"../../eCommon/html/blank.html\" style=\'height:9vh;width:100vw\'></IFRAME>\n\t\t\t\t\t<!-- </FRAMESET> -->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<!-- <div style=\"display:flex; height: 93vh;\">\n\t\t\t\t\t\t<iframe name=\"f_prescription\" id=\"f_prescription\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"CATHIRDWORKAREA\" ></iframe> \n\t\t\t\t<div id=\"PrescriptionDetailFrameSet\" name=\"PrescriptionDetailFrameSet\" style=\"display:flex; flex-direction: column;height: 93vh;\">\n\t\t\t\t\t\t<iframe style=\"height: 87vh; width: 73vw;\" name=\"f_detail\" id=\"f_detail\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" ></iframe>\n\t\t\t\t\t\t<iframe style=\"height: 5vh; width: 73vw;\" name=\"f_button\" id=\"f_button\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"CATHIRDWORKAREA\"></iframe>\n -->\n \t\t\t\t<div style=\"display:flex; height: 93vh; width: 99vw;\">\n    <iframe name=\"f_prescription\" id=\"f_prescription\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"CATHIRDWORKAREA\"></iframe> \n    <div id=\"PrescriptionDetailFrameSet\" name=\"PrescriptionDetailFrameSet\" style=\"display:flex; flex-direction: column; height: 93vh; width: 100%;\">\n        <iframe style=\"height: 87vh; width: 100%;\" name=\"f_detail\" id=\"f_detail\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></iframe>\n        <iframe style=\"height: 5vh; width: 100%;\" name=\"f_button\" id=\"f_button\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"CATHIRDWORKAREA\"></iframe>\n    </div>\n</div>\n \t\t\t\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<!-- </frameset> -->\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<div style=\"display:flex ; flex-direction: column;\" > \n<!-- <frameset rows=\"77,*\" > -->\n<iframe style=\"height: 19vh; width: 100vw;\" name=\"f_header\"  id=\"f_header\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/PrescriptionHeader_1.jsp?";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ></iframe>\n<div style=\"display:flex; height: 80vh;\">\n<!-- <frameset cols=\"27%,*\" id=\"PrescriptionDetailFrameSet\" name=\"PrescriptionDetailFrameSet\"> -->\n<iframe name=\"f_prescription\" id=\"f_prescription\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"CATHIRDWORKAREA\" ></iframe>\n<div id=\"PrescriptionDetailFrameSet\" name=\"PrescriptionDetailFrameSet\" style=\"display:flex; flex-direction: column;height: 75vh;\">\n<!-- <frameset rows=\"*,23.5\" > -->\n<iframe style=\"height: 70vh; width: 73vw;\" name=\"f_detail\" id=\"f_detail\" frameborder=\"0\" scrolling=\"auto\"  src=\"../../eCommon/html/blank.html\" ></iframe>\n<iframe style=\"height: 7vh; width: 80vw;\" name=\"f_button\" id=\"f_button\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" class=\"FR_BORDER2\"></iframe>\n<!-- </frameset> -->\n</div>\n<!-- </frameset> -->\n</div>\n<!-- </frameset> -->\n</div>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</html>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------  
23/02/2018  IN066779       Sharanraj    23/02/2018       Chandra            ML-MMOH-CRF-1000.1
08/06/2020  IN:072715      B Haribabu                                                  GHL-ICN-0071  
---------------------------------------------------------------------------------------------------------------------------------------------------------- 
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

try{
	String params = request.getQueryString() ;
	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String patient_class = request.getParameter("patient_class");
	//String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
	//String bean_name	= "ePH.PrescriptionBean_1";
	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request );
	String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;//Adding start for TH-KW-CRF-0007
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );//Adding end for TH-KW-CRF-0007
	String Consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
	String Consumable_bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean Consumable_bean		= (ConsumableOrderBean)getBeanObject( Consumable_bean_id,Consumable_bean_name, request );
	Consumable_bean.clear();
	
	//Added for IN:072715 start
	String ext_beanid = "@ExternalProductLinkBean";
	String ext_beanname = "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
	ext_beanObj.clear();
	//Added for IN:072715 end
	
	String or_bean_name	="eOR.OrderEntryBean";
	String or_bean_id="@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
	String or_mode= (String) orbean.getAmendOrder();
	String iv_prep_yn = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String p_called_from_ca	= request.getParameter("p_called_from_ca")==null?"": request.getParameter("p_called_from_ca"); //Added for ML-BRU-SCF-0098 [IN031837] -moved from PrescriptionHeader_2.jsp HSA-CRF-0147.1 [IN:049419]-RameshGoli
	bean.setCalledFromAmend(p_called_from_ca); //Added for ML-BRU-SCF-0098 [IN031837] -moved from PrescriptionHeader_2.jsp HSA-CRF-0147.1 [IN:049419]-RameshGoli
	
	/*IN066779 starts*/
		String IVbean_id					= "@IVPrescriptionBean"+patient_id+encounter_id;
		String IVbean_name				= "ePH.IVPrescriptionBean";
		IVPrescriptionBean IVbean			= (IVPrescriptionBean)getBeanObject( IVbean_id, IVbean_name, request );
		IVbean.setCalledFromAmend(p_called_from_ca);
		
		String Oncobean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
		String Oncobean_name				= "ePH.OncologyRegimenBean";
		OncologyRegimenBean Oncobean			= (OncologyRegimenBean)getBeanObject( Oncobean_id, Oncobean_name, request );
	/*IN066779 ends*/
	

            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		bean.setLanguageId(locale);
		orbean.setLanguageId(locale);
		IVbean.setLanguageId(locale);//IN066779
		Oncobean.setLanguageId(locale);//IN066779
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String called_from		=	orbean.getCalledFromFunction(); //added for Bru-HIMS-CRF-400 [IN:044502]
	if(called_from.equals("RENEW_ORDER")){ 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);

	} //added for Bru-HIMS-CRF-400 [IN:044502]-end
	else if(or_mode!=null && or_mode.equals("existing_order")){
		//if(iv_prep_yn==null || iv_prep_yn.equals("")){	
		String order_id=request.getParameter("order_id")==null?"":(String)request.getParameter("order_id");//Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli -end
		if(!"".equals(order_id) &&  !bean.getCalledFromAmend().equals("PH") ){
			ArrayList reason_val	= new ArrayList();
			reason_val.add(order_id);
			reason_val.add("");
			reason_val.add((String)orbean.getAmend_reason());
			bean.clearAmendReason(order_id);
			bean.setAmendReason(order_id,reason_val);
		} //Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli-end
		/*IN066779 starts*/
		 if(iv_prep_yn.equals("1")|| iv_prep_yn.equals("2") || iv_prep_yn.equals("3")|| iv_prep_yn.equals("4") || iv_prep_yn.equals("5")){
				ArrayList reason_val1	= new ArrayList();
				reason_val1.add(order_id);
				reason_val1.add("");
				reason_val1.add((String)orbean.getAmend_reason());
				IVbean.clearAmendReason1(order_id);
				IVbean.setAmendReason1(order_id,reason_val1);
		 }
		
		 else if(iv_prep_yn.equals("9") || iv_prep_yn.equals("0")){
			 ArrayList reason_val2	= new ArrayList();
			 reason_val2.add(order_id);
			 reason_val2.add("");
			 reason_val2.add((String)orbean.getAmend_reason());
			 Oncobean.clearAmendReason1(order_id);
			 Oncobean.setAmendReason1(order_id,reason_val2);
		 }
		/*IN066779 Ends*/
		bean.setAuditTrailReqYN((String)orbean.getAmend_auditTrailYN());

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(iv_prep_yn!=null && !iv_prep_yn.equals("")){    
					if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4") || iv_prep_yn.equals("5")){

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				else if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
	
				}
				else if(iv_prep_yn.equals("9") || iv_prep_yn.equals("0")){

            _bw.write(_wl_block24Bytes, _wl_block24);
 
				}
				else if(iv_prep_yn.equals("6")){

            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			}
			else{

            _bw.write(_wl_block26Bytes, _wl_block26);

		}

            _bw.write(_wl_block27Bytes, _wl_block27);

		/*}else if(iv_prep_yn!= null && iv_prep_yn.equals("N")){
			out.println("<script>reloadScreens('4','"+patient_id+"','"+encounter_id+"','','OP','"+order_id+"')</script>");
		}*/
	}
	else{	
		bean.clear();
		presBean.clear();//Adding  for TH-KW-CRF-0007

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(params));
            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	putObjectInBean(or_bean_id,orbean,request); 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(presBean_id,presBean,request);//Adding  for TH-KW-CRF-0007
	putObjectInBean(Consumable_bean_id,Consumable_bean,request);
	putObjectInBean(ext_beanid,ext_beanObj,request);//Added for IN:072715
}
catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
