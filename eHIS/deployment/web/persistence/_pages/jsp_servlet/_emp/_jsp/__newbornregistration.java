package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __newbornregistration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NewbornRegistration.jsp", 1733138540345L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 11:26 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\t/*var sStyle = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\tvar HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'>\";\n            HTMLVal = HTMLVal +\"<form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp\'>\";\n            HTMLVal = HTMLVal +\"<input name=\'pat_id\' id=\'pat_id\' type=\'hidden\' value= \\\"escape(";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =") \\\">\";\n            HTMLVal = HTMLVal +\"<input name=\'jsp_name\' id=\'jsp_name\' type=\'hidden\' value= \'\'>\";\n            HTMLVal = HTMLVal +\"<input name=\'flag\' id=\'flag\' type=\'hidden\' value= \'\'>\";\n            HTMLVal = HTMLVal +\"<input name=\'func_id\' id=\'func_id\' type=\'hidden\' value= \'\'>\";\n            HTMLVal = HTMLVal +\"<input name=\'sflag\' id=\'sflag\' type=\'hidden\' value= \'\'>\";\n\t\t\tparent.messageFrame.document.write(HTMLVal);\n\t\t\tparent.messageFrame.document.form1.submit();*/\n\t\t\tparent.frames[5].location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t</script>\t\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t<html>\n\t\t<head>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\t\n\t\t\t<script language=\'javascript\' src=\'../../eMP/js/NewbornRegistration.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eMP/js/NewbornRegistration1.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eMP/js/NewbornRegistration2.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t<script>\n\t\t\t\tasync function query(){\n\t\t\t\t\tvar patientid= await PatientSearchWithDefaultGender(\'F\',\'N\');\n\t\t\t\t\tif(patientid!=null){ \n\t\t\t\t\t\t frames[1].location.href = \'../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id=\'+patientid+\'&accessRights=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&parent_details=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&function_invoked=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&mother_nursing_unit=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&mother_bed_no=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&function_name=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&calling_module_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t<title>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </title>\t\t \t\n\t\t</head>\n\n\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" frameborder=0 style=\'height:84vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\n\t</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
	private String checkForNull(String inputString){
		return (inputString == null) ? "" : inputString;
	}	
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String frameSetRows="";
	String patient_id		= request.getParameter("Patient_ID");
	String function_id		= request.getParameter("function_id");
	String parent_details	= request.getParameter("parent_details");
	String function_invoked = request.getParameter("function_invoked");
	String function_name 	= request.getParameter( "function_name" ) ;
	String mother_patient_id="";
	String ca_encounter_id="";
	if(function_name	== null ) function_name	= "" ;	
	if(patient_id == null) patient_id = "" ;
	if(function_id == null) function_id = "" ;
	if( parent_details == null) parent_details = "";
	if(function_invoked == null) function_invoked = "";
	String module_invoked			= request.getParameter("module_invoked") == null ? "" : request.getParameter("module_invoked");
	String calling_module_id		= request.getParameter("calling_module_id") == null ? "" : request.getParameter("calling_module_id");
	String mother_nursing_unit		= request.getParameter("mother_nursing_unit") == null ? "" : request.getParameter("mother_nursing_unit");
	String mother_bed_no			= request.getParameter("mother_bed_no") == null ? "" : request.getParameter("mother_bed_no");
	String called_from_mothercare	= request.getParameter("called_from_mothercare") == null ? "" : request.getParameter("called_from_mothercare");
	ca_encounter_id					= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	parent_details = java.net.URLEncoder.encode(parent_details);
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;	
	if(!function_id.equals("") && !function_id.equals("NEWBORN_REG") &&!function_id.equals("REG_NEWBORN_FOR_IP")){
		source = source+"&home_required_yn = N";					
	}	
	int src = source.indexOf("access",0);
	String accessRights = source.substring(src+7,src+12);
	//if(called_from_mothercare.equals("MC")){
		mother_patient_id=patient_id;
	//}

	session.putValue("accessRights", accessRights);
	session.setAttribute("paramsValue", params);  
	
	String file_name = "";
	file_name = "../../eMP/jsp/NewbornRegistrationInvoke.jsp?accessRights="+accessRights+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&function_invoked="+function_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name+"&calling_module_id="+calling_module_id;

	if(!(patient_id.equals(""))){ 
		file_name = "../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id="+patient_id+"&function_id="+function_id+"&accessRights="+accessRights+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&function_invoked="+function_invoked+"&module_invoked="+module_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name+"&calling_module_id="+calling_module_id+"&called_from_mothercare="+called_from_mothercare+"&mother_patient_id="+mother_patient_id+"&ca_encounter_id="+ca_encounter_id;
	}
	

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	if(called_from_mothercare.equals("MC")){
		frameSetRows="0%,*,5%";
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
		frameSetRows="6%,*,8%";
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(accessRights));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(parent_details));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_invoked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mother_nursing_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mother_bed_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(source));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(file_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegNewBorn.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
