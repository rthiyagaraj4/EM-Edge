package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __appointmentdetails1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AppointmentDetails1.jsp", 1730878199894L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n    ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n \n\t<html>\n\t<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title></head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String apptrefno=request.getParameter("i_appt_ref_no");
	
	String transfer=request.getParameter("transfer");
	if(transfer == null)transfer="";
	String i_from_time=request.getParameter("i_from_time");
	if(i_from_time == null) i_from_time="";
	String i_to_time=request.getParameter("i_to_time");
	if(i_to_time == null) i_to_time="";
	String value13=request.getParameter("value13");
	if(value13 == null) value13="";
	String i_clinic_code=request.getParameter("i_clinic_code");
	
	String i_practitioner_id=request.getParameter("i_practitioner_id");


	
	String i_appt_date=request.getParameter("i_appt_date");
	if(i_appt_date ==null) i_appt_date="";
	String over_booked=request.getParameter("over_booked");
	if(over_booked == null) over_booked="";
	String i_time_table_type=request.getParameter("i_time_table_type");
	if(i_time_table_type == null) i_time_table_type="";
	
	String old_date=(String)request.getParameter("old_date");
	if(old_date  == null || old_date.equals("null")) old_date="";
	
	String flag=(String)request.getParameter("flag");
	if(flag == null || flag.equals("null")) flag="";
	String pre_pat_alcn_catg_code= request.getParameter("pre_pat_alcn_catg_code");
	if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";


	String old_from_time = request.getParameter("old_from_time");
	if( old_from_time == null) old_from_time="";
	
	String old_to_time = request.getParameter("old_to_time");
	if( old_to_time == null) old_to_time="";
	String book_appt_wo_pid_yn = request.getParameter("book_appt_wo_pid_yn");
	String obook_appt_yn = request.getParameter("obook_appt_yn");
	String tfr_appt_yn = request.getParameter("tfr_appt_yn");
	String tfr_appt_across_catg_yn = request.getParameter("tfr_appt_across_catg_yn");
	String canc_appt_yn = request.getParameter("canc_appt_yn");
	String alcn_criteria = request.getParameter("alcn_criteria");
	String call_function_ip = request.getParameter("call_function");
	if(call_function_ip==null) call_function_ip="";
	String Forced=request.getParameter("Forced");
	String calling_mode=request.getParameter("calling_mode");
	if(calling_mode== null) calling_mode="";
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	String performing_facility_id=request.getParameter("performing_facility_id");
	String from_page=request.getParameter("from_page");
	String wtListControl			= request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
	
	//added forBru-HIMS-CRF-380 Start
	String facility_id	= request.getParameter("FacilityId") ;
	if(facility_id==null)
		facility_id = (String) session.getValue("facility_id");
	//added forBru-HIMS-CRF-380 End
	
	
	
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	if (performing_facility_id==null) performing_facility_id = "";
	out.println("<iframe name='f_apptdetails' id='f_apptdetails' src='../../eOA/jsp/AddModifyAppointmentDetails.jsp?i_appt_ref_no="+apptrefno+"&transfer="+transfer+"&i_from_time="+i_from_time+"&i_to_time="+i_to_time+"&value13="+value13+"&i_clinic_code="+i_clinic_code+"&i_practitioner_id="+i_practitioner_id+"&i_appt_date="+i_appt_date+"&over_booked="+over_booked+"&i_time_table_type="+i_time_table_type+"&old_date="+old_date+"&flag="+flag+"&old_from_time="+old_from_time+"&old_to_time="+old_to_time+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&pre_pat_alcn_catg_code="+pre_pat_alcn_catg_code+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&calling_mode="+calling_mode+"&from_page="+from_page+"&call_function_ip="+call_function_ip+"&performing_facility_id="+performing_facility_id+"&wtListControl="+wtListControl+"&facility_id="+facility_id+"'  frameborder='0'  scrolling='no' marginheight='0' marginwidth='0' style='height:100vh;width:97vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0' style='height:0vh;width:97vw'></iframe>");
	out.println("</html>");

            _bw.write(_wl_block8Bytes, _wl_block8);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AppointmentDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
