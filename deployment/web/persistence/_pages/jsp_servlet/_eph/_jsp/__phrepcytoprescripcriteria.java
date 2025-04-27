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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __phrepcytoprescripcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PhRepCytoPrescripCriteria.jsp", 1709121077173L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PhMessages.js\"></script>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script LANGUAGE=\"javascript\" src=\"../../ePH/js/PhRepCytoPrescription.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n<form name=\"frmCytoPrescriptionQueryCriteria\" id=\"frmCytoPrescriptionQueryCriteria\" ACTION=\"../../eCommon/jsp/report_options.jsp\" TARGET=\"messageFrame\"> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\" id=\"prescriptionquerycriteriatable\">\n\t<tr>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"ePH.PrescriptionNo.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\n\t\t<td align=\"left\" >&nbsp;\n\t\t\t<input type=\"text\" name=\"order_id\" id=\"order_id\" maxlength=\"15\" size=\"20\" onKeyPress=\"changeToUpper()\">\n\t\t</td>\t\t\n\t\t<td align=\"right\" class=\"label\">Order Date From</td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<input type=\"text\" name=\"order_date_from\" id=\"order_date_from\" class=\"DATE\" value=\"\" size=\"10\" onBlur=\"CheckDate(this);DateCheck(sysdate,order_date_from);validate_date(this,\'TO_DATE_LESS_FROM\')\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"return showCalendar(\'order_date_from\');\"\n\t\t\tonblur=\"document.forms[0].order_date_from.focus();\">\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.to.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></td>\n\t\t<td align=\"left\" >&nbsp;\n\t\t\t<input type=\"text\" name=\"order_date_to\" id=\"order_date_to\" size=\"10\" class=\"DATE\" value=\"\"onBlur=\"CheckDate(this);DateCheck(sysdate,order_date_to);validate_date(this,\'TO_DATE_LESS_FROM\')\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"return showCalendar(\'order_date_to\');\" \n\t\t\tonblur=\"document.forms[0].order_date_to.focus();\">\n\t\t</td>\t\t\n\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.patientId.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<input type=\"text\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  maxlength=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=\"20\" onKeyPress=\"changeToUpper()\">\n\t\t\t<input type=\"button\" value=\"?\" class=\"button\" name=\"btnPatientID\" id=\"btnPatientID\" onClick=\"callPatientSearch()\"  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.nationality.label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/></td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<input type=\"text\" name=\"nationality\" id=\"nationality\" maxlength=\"20\" size=\"20\"  disabled>\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<input type=\"text\" name=\"healthCardNo\" id=\"healthCardNo\" maxlength=\"20\" size=\"20\" disabled>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.encounterid.label\" bundle=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/></td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<input type=\"text\" name=\"encounter_id\" id=\"encounter_id\" maxlength=\"20\" size=\"20\"  >\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.practitionerid.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/></td>\n\t\t<td align=\"left\" >&nbsp;\n\t\t\t<input type=\"text\" name=\"practitioner_id\" id=\"practitioner_id\" maxlength=\"20\" size=\"20\"  >\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"ePH.CytoType.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/></td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<select name=\"iv_type\" id=\"iv_type\" >\n\t\t\t    <option value=\"\">--- <fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/> ---</option>\n\t\t\t\t<option value=\"9\">Cyto(Direct)</option>\n\t\t\t\t<option value=\"0\">Cyto(Admixture)</option>\n\t\t\t</select><img id=\"mandatory\"src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.locationtype.label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/></td>\n\t\t<td align=\"left\">&nbsp;\n\t\t\t<select name=\"locn_type\" id=\"locn_type\" onChange=\"resetLocation()\">\n\t\t\t\t<option value=\"\">----<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>----</option>\n\t\t\t\t<option value=\"C\"><fmt:message key=\"Common.clinic.label\" bundle=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/></option>\n\t\t\t\t<option value=\"N\"><fmt:message key=\"Common.nursingUnit.label\" bundle=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/></option>\n\t\t\t</select>\n\t\t</td>\n\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.Location.label\" bundle=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/></td>\n\t\t<td align=\"left\" >&nbsp;&nbsp;<input type=\"text\" name=\"locn_name\" id=\"locn_name\" maxlength=\"20\" size=\"20\"  disabled><input type=\"button\" name=\"btnLocation\" id=\"btnLocation\" class=\"button\" value=\"?\" onfocus=\"locationLookup(locn_name)\" onClick=\"locationLookup(locn_name)\"><input type=\"hidden\" name=\"locn_code\" id=\"locn_code\">\n\t\t</td>\t\t\n\t\t<td colspan=\"2\" align=\"right\"> \n\t\t\t<input type=\"button\" name=\"btnSearch\" id=\"btnSearch\" value=\"Search\" class=\"button\" onClick=\"showResults(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\">\n\t\t</td>\n\t</tr>\n</table>\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"p_fm_order_id\" id=\"p_fm_order_id\" value=\"\">\n\t<input type=\"hidden\" name=\"p_to_order_id\" id=\"p_to_order_id\" value=\"\">\n\t<input type=\"hidden\" name=\"p_patclass\" id=\"p_patclass\" value=\"\">\n\t<INPUT TYPE=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" VALUE=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"p_user_name\" id=\"p_user_name\" VALUE=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" VALUE=\"PH\">\n\t<INPUT TYPE=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" VALUE=\"PHBOPPCYTO\">\n\t<input type=\"hidden\" name=\"p_locncode\" id=\"p_locncode\" value=\"\">\n\t<input type=\"hidden\" name=\"p_iv_prep_yn\" id=\"p_iv_prep_yn\" value=\"\"> \n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"sysdate\" id=\"sysdate\" VALUE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\n</form>\n\t<input type=\"hidden\" name=\"SQL_PH_PRINT_PRESCRIPTIONS_SELECT1\" id=\"SQL_PH_PRINT_PRESCRIPTIONS_SELECT1\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"SQL_PH_PRINT_PRESCRIPTIONS_SELECT2\" id=\"SQL_PH_PRINT_PRESCRIPTIONS_SELECT2\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n</body>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n<script>\n ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n showResults()\n ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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
        response.setHeader("Content-Type", "text/html; ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; ");
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
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String bean_id		= "PrintPrescriptionReportBean" ;
	String bean_name	= "ePH.PrintPrescriptionReportBean";
	PrintPrescriptionReportBean bean = (PrintPrescriptionReportBean)getBeanObject( bean_id,bean_name, request) ;

	String patient_id	=	request.getParameter("patient_id"); 
	
	String status		= "";
	if(patient_id==null || patient_id.equals("null")) {
		patient_id	=	"";
	} else {
		status		=	"";
	}
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= dtSystemFormat.format(date_time); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean.getPatientIDLength()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean.getNationID()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( session.getValue( "facility_id" ) ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( session.getValue( "login_user" ) ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Sysdate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")));
            _bw.write(_wl_block32Bytes, _wl_block32);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(!patient_id.equals("")){ 
            _bw.write(_wl_block34Bytes, _wl_block34);
	}	
            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
