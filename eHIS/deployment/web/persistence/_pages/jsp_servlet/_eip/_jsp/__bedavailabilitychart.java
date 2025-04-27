package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import eCommon.XSSRequestWrapper;

public final class __bedavailabilitychart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BedAvailabilityChart.jsp", 1735645281667L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<iframe name=\'processBar\' frameborder=0  noresize  scrolling=\'no\' style=\'height:0.1vh;width:99vw\'></iframe>\n\t\t<iframe name=\'criteria0\' src=\'../jsp/BedAvailabilityChartCriteria0.jsp?P_call_func=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nursing_unit_code=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&reserve_bed_selectable=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patient_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&enable_bed_date=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&med_service_grp=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&practitioner_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&ipparam_bed_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&speciality_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&bed_class_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&bed_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&age=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&gender=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&practitioner_desc=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&wherecondn=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&disable_field=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&bedClass_dis_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&main_bed_no=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&call_function=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&oper_stn_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&patient_class=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&room_no_code=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&exp_discharge_date=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&create_booking_admission_date_time=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&bed_booking_ref_no=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  frameborder=0 scrolling=\'no\' style=\'height:32vh;width:99vw\'></iframe>\n\t\t<iframe name=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=auto style=\'height:34vh;width:99vw\'></iframe>\n\t\t<iframe name=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=0  scrolling=\'no\' style=\'height:2vh;width:99vw\'></iframe>\n\t\t<iframe name=\'status\' src=\'../jsp/CheckBoxStatus.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:22vh;width:99vw\'></iframe>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<iframe name=\'processBar\' frameborder=0  noresize  scrolling=\'no\' style=\'height:0vh;width:99vw\'></iframe>\n\t\t<iframe name=\'criteria0\' src=\'../jsp/BedAvailabilityChartCriteria0.jsp?P_call_func=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\n\t\t\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

// Added by Sridhar R on 2/23/2005... 
// This func will check for null values & return empty string if Null...
	private String checkForNull(String inputString)
	{
		return (inputString==null)? "" : inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue

	String call_func		= checkForNull(request.getParameter("P_call_func")); //added by chitra to invoke Admit Patient from Bed Chart
	String ipparam_bed_yn	= checkForNull(request.getParameter("ipparam_bed_yn"));
	String nursingunitcode	= checkForNull(request.getParameter("nursing_unit_code"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String practitionerid	= checkForNull(request.getParameter("practitioner_id"));
	String practitioner_desc= checkForNull(request.getParameter("practitioner_desc"));
	String specialitycode	= checkForNull(request.getParameter("speciality_code"));
	String bedclasscode		= checkForNull(request.getParameter("bed_class_code"));
	String bed_type			= checkForNull(request.getParameter("bed_type"));
	String age				= checkForNull(request.getParameter("age"));
	String gender			= checkForNull(request.getParameter("gender"));
	String wherecondn 		= checkForNull(request.getParameter("wherecondn"));
	String disable_field 	= checkForNull(request.getParameter("disable_field"));
	String patient_class 	= checkForNull(request.getParameter("patient_class"));
	String bedClass_dis_yn 	= checkForNull(request.getParameter("bedClass_dis_yn"));
	String room_no_code 	= checkForNull(request.getParameter("room_no_code"));
// Added by Sridhar R 
	String main_bed_no 		= checkForNull(request.getParameter("main_bed_no"));
	String med_service_grp	= checkForNull(request.getParameter("med_service_grp"));
	String call_function 	= checkForNull(request.getParameter("call_function"));
	String facility_id		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String enable_bed_date	= checkForNull(request.getParameter("enable_bed_date"),"N");
	String reserve_bed_selectable	= checkForNull(request.getParameter("reserve_bed_selectable"),"N");
	String create_booking_admission_date_time	= checkForNull(request.getParameter("create_booking_admission_date_time"));
	String exp_discharge_date	= checkForNull(request.getParameter("exp_discharge_date"));
	String bed_booking_ref_no	= checkForNull(request.getParameter("bed_booking_ref_no"));
	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	if(oper_stn_id.equals(""))
	{
		Connection con			= null;
		Statement stmt_oper		= null;
		ResultSet rs_oper		= null;

		try
		{
			con	= ConnectionManager.getConnection();
			String operSql = " select a.oper_stn_id oper_stn_id from AM_OPER_STN a, AM_USER_FOR_OPER_STN b where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id	and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";
			stmt_oper = con.createStatement();
			rs_oper = stmt_oper.executeQuery(operSql);
			if (rs_oper.next())
			{
				oper_stn_id	 = checkForNull(rs_oper.getString("oper_stn_id"));
			}
		}catch (Exception exp)
		{
			exp.printStackTrace();
		}
		finally 
		{
			ConnectionManager.returnConnection(con);
		}
	}

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
	if (!call_func.equals("ADMIT") && !call_func.equals("QUERY_BED_AVAIL")) 
	{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(java.net.URLEncoder.encode(call_func)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reserve_bed_selectable));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(enable_bed_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(med_service_grp)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionerid)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialitycode)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclasscode)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(age)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(gender)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_desc)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(wherecondn)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(disable_field)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedClass_dis_yn)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(main_bed_no)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(call_function)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(oper_stn_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(room_no_code)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(exp_discharge_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(java.net.URLEncoder.encode(create_booking_admission_date_time)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_booking_ref_no)));
            _bw.write(_wl_block33Bytes, _wl_block33);
	}
	else
	{	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(call_func)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(java.net.URLEncoder.encode(nursingunitcode)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reserve_bed_selectable));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(enable_bed_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(med_service_grp)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitionerid)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(specialitycode)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedclasscode)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_type)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(age)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(gender)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_desc)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(wherecondn)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(disable_field)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(bedClass_dis_yn)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(main_bed_no)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(call_function)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(oper_stn_id)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_class)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(room_no_code)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(exp_discharge_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(java.net.URLEncoder.encode(create_booking_admission_date_time)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_booking_ref_no)));
            _bw.write(_wl_block33Bytes, _wl_block33);
	}	
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedAvailabilityChart.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
