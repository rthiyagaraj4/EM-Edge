package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __userpinauthorization extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/UserPINAuthorization.jsp", 1709121549717L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script language=\"javascript\">\n\t\t\tfunction setFocus1(){\n\t\t\t\tdocument.frmUserPINAuthorization.user_pin.focus();\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'==\'MAR\' && \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'==\'Y\')\t\t// Added for AAKH-CRF-0023[IN:038259]\n\t\t\t\t\tdocument.frmUserPINAuthorization.user_name.focus();\t// Added for AAKH-CRF-0023[IN:038259]\n\t\t\t\treturn true;\n\t\t\t}\n\t\t</script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/DispMedicationAllStages.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\t</HEAD>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<body  onload=\"setFocus1()\" >  \n\t\t\t<form name=\"frmUserPINAuthorization\" id=\"frmUserPINAuthorization\" >\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" left=\"5%\" align=\"left\" border=\"0\" >\n\t\t\t\t\t<tr style=\"height:40px\">\n\t\t\t\t\t\t<td class=\"white\" colspan=\"2\">&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"height:40px\">\n\t\t\t\t\t\t<td  class=\'Label\'><label id=\'user_id1\' width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t</label></td>\n\t\t\t\t\t\t<td> <input type=text  name=\'user_name\' id=\'user_name\'  value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' size=\'30\' maxlength=\'30\' onChange=\"GetLookupBlur(user_name,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\"><!--onblur changed to onChange for  RUT-SCF-0351 [IN:044986]-->\n\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\"GetLookup(user_name,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\">\t\t\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t<td><input type=\"password\" name=\"user_pin\" id=\"user_pin\" size=\"30\" maxlength=\"64\" value=\"\" autocomplete=\"off\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>  <!--41741 autocomplete=\"off\"-->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"height:45px\">\n\t\t\t\t\t\t<td  colspan=\"2\" align=\"right\" >\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\'btnOk\' id=\'btnOk\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onClick=\"validateUserAuthPIN(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\">&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\'btnCancel\' id=\'btnCancel\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onClick=\"window.returnValue=\'C\';window.close();\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"disp_category\" id=\"disp_category\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"login_facility_id\" id=\"login_facility_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"login_at_ws_no\" id=\"login_at_ws_no\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sqlForMARUsers\" id=\"sqlForMARUsers\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"sqlForDispensingUsers\" id=\"sqlForDispensingUsers\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"witness\" id=\"witness\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\t<!--  Added for AAKH-CRF-0023[IN:038259] -->\n\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\t<!--  Added for AAKH-CRF-0023[IN:038259] -->\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t<!--  Added for AAKH-CRF-0023[IN:038259] -->\n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
		String locale				= (String)session.getAttribute("LOCALE");
		String appl_user_name		= (String)session.getAttribute("appl_user_name");
		String login_user			= (String)session.getAttribute("login_user");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String call_from = request.getParameter("call_from");
		String Witness 			= request.getParameter("Witness")==null?"":request.getParameter("Witness"); 	// Added for AAKH-CRF-0023[IN:038259]
		String patient_id		= request.getParameter("patient_id");	// Added for AAKH-CRF-0023[IN:038259]
		String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	// Added for AAKH-CRF-0023[IN:038259]

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Witness));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	try{
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String bean_id = "DispMedicationAllStages.java" ;
		String bean_name = "ePH.DispMedicationAllStages";
		DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request ) ;
		String bean_id1 = "MedicationAdministrationFTBean.java" ;
		String bean_name1 = "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean bean1 = (MedicationAdministrationFTBean)getBeanObject( bean_id1, bean_name1, request ) ;
		String disp_locn_code = request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
		String disp_category	= request.getParameter("disp_category")==null?"IP":request.getParameter("disp_category");
		String login_facility_id = (String)session.getValue( "facility_id" );
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String sqlForMARUsers="select  appl_user_id code,appl_user_name description from sm_appl_user_lang_vw a where eff_status='E' AND a.language_id ='"+locale+"' and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and (pin_no is not null or pin_no <> '') and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?)  ORDER BY 2";

		String sqlForDispensingUsers="SELECT a.appl_user_id code, a.appl_user_name description FROM sm_appl_user_lang_vw a, ph_disp_rights b WHERE b.facility_id = '"+login_facility_id+"' AND b.disp_locn_code = '"+disp_locn_code+"' AND a.language_id ='"+locale+"' and a.eff_status = 'E' and A.APPL_USER_ID = B.APPL_USER_ID AND ( (a.eff_date_from IS NULL AND a.eff_date_to IS NULL) OR (TRUNC (a.eff_date_from) <= TRUNC (SYSDATE) AND a.eff_date_to IS NULL ) OR (TRUNC (a.eff_date_to) >= TRUNC (SYSDATE) AND a.eff_date_from IS NULL ) OR ( TRUNC (SYSDATE) BETWEEN TRUNC (a.eff_date_from)   AND TRUNC (a.eff_date_to) AND a.eff_date_from IS NOT NULL AND a.eff_date_to IS NOT NULL ) ) and (pin_no is not null or pin_no <> '') AND UPPER (a.appl_user_id) LIKE UPPER (?) AND UPPER (a.appl_user_name) LIKE UPPER (?) ";
    
		String user_label="";
		String bundle="PH";
		if(call_from.equals("A")){
			user_label="ePH.AllocatedBy.label";
			sqlForDispensingUsers +=" and B.ALLOCATE_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("V")){
			user_label="Common.VerifiedBy.label";
			bundle	="Common";
			sqlForDispensingUsers +=" and B.VERIFY_YN='Y' ORDER BY 2";
			if(disp_category.equals("IP")  || disp_category.equals("I") )
				sqlForDispensingUsers +=" and B.IP_VERIFY_YN='Y' ORDER BY 2";
			else
				sqlForDispensingUsers +=" and B.VERIFY_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("F") ||  call_from.equals("IPFA")){
			user_label="ePH.FilledBy.label";
			if(disp_category.equals("IP") || disp_category.equals("I") || call_from.equals("IPFA"))
				sqlForDispensingUsers +=" and B.IP_ALLOCATE_YN='Y' ORDER BY 2";
			else
				sqlForDispensingUsers +=" and B.FILL_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("D")){
			user_label="ePH.DeliveredBy.label";
			sqlForDispensingUsers +=" and B.DELIVER_YN='Y' ORDER BY 2";
			if(disp_category.equals("IP")  || disp_category.equals("I") )
				sqlForDispensingUsers +=" and B.IP_DELIVER_YN='Y' ORDER BY 2";
			else
				sqlForDispensingUsers +=" and B.DELIVER_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("AS") || call_from.equals("DD")){
			user_label="ePH.DispensedBy.label";
			if(disp_category.equals("OP") || disp_category.equals("O") )
				sqlForDispensingUsers +=" and B.ALLOCATE_YN='Y' and B.DELIVER_YN='Y' ORDER BY 2";
			else if(disp_category.equals("IP")  || disp_category.equals("I") )
				sqlForDispensingUsers +=" and B.IP_ALLOCATE_YN='Y' and B.IP_DELIVER_YN='Y' ORDER BY 2";
			if(call_from.equals("DD") ){
				sqlForDispensingUsers ="SELECT  appl_user_id code, appl_user_name description FROM sm_appl_user_lang_vw a, am_practitioner b WHERE A.APPL_USER_ID = B.PRACTITIONER_ID and  (pin_no is not null or pin_no <> '') AND a.language_id ='"+locale+"' and  b.pract_type IN ('NS', 'MD', 'DN', 'PH') AND UPPER (appl_user_id) LIKE UPPER (?) AND UPPER (appl_user_name) LIKE UPPER (?) ORDER BY 2";
				//sqlForDispensingUsers =" SELECT a.appl_user_id code, a.appl_user_name description FROM sm_appl_user a, ph_disp_rights b , ph_disp_locn c WHERE b.facility_id = '"+login_facility_id+"' AND b.disp_locn_code = '"+disp_locn_code+"'  AND a.language_id = '"+locale+"' and a.eff_status = 'E' and A.APPL_USER_ID = B.APPL_USER_ID AND ( (a.eff_date_from IS NULL AND a.eff_date_to IS NULL) OR (TRUNC (a.eff_date_from) <= TRUNC (SYSDATE) AND a.eff_date_to IS NULL ) OR (TRUNC (a.eff_date_to) >= TRUNC (SYSDATE) AND a.eff_date_from IS NULL ) OR ( TRUNC (SYSDATE) BETWEEN TRUNC (a.eff_date_from)   AND TRUNC (a.eff_date_to) AND a.eff_date_from IS NOT NULL AND a.eff_date_to IS NOT NULL ) ) AND UPPER (a.appl_user_id) LIKE UPPER (?) AND UPPER (a.appl_user_name) LIKE UPPER (?) and B.DISP_LOCN_CODE = C.DISP_LOCN_CODE and C.DIRECT_DISP_ALLOWED_YN ='Y' ORDER BY 2";
			}
		}
		else if(call_from.equals("MAR")){
			user_label="Common.AdministeredBy.label";
			bundle	="Common";
			if(Witness.equals("Y")){	// Added for AAKH-CRF-0023[IN:038259] start
				user_label="ePH.WitnessedBy.label";
				bundle	="PH";
				appl_user_name = "";
				sqlForMARUsers="select  appl_user_id code,appl_user_name description from sm_appl_user_lang_vw a where eff_status='E' AND a.language_id ='"+locale+"' and a.appl_user_id != '"+login_user+"' and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and (pin_no is not null or pin_no <> '') and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?)  ORDER BY 2";
			}							// Added for AAKH-CRF-0023[IN:038259] end
		}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(MessageManager.getLabel(locale,user_label,bundle)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disp_category));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(login_facility_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(login_at_ws_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sqlForMARUsers));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sqlForDispensingUsers));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Witness));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block32Bytes, _wl_block32);

		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,bean1,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block33Bytes, _wl_block33);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PinAuth.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
