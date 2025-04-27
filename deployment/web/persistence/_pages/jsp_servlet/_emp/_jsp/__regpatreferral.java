package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __regpatreferral extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegPatReferral.jsp", 1739169198290L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eMP/js/RegPatReferral.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script> \n\t<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\talert(getMessage(\'MP_PARAM_NOT_FOUND\',\'MP\'));\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" frameborder=0 scrolling=\'no\' noresize tabindex=-1 style=\'height:7vh;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" frameborder=0 scrolling=\'no\' tabindex=-1 style=\'height:90vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'auto\' tabindex=-1 style=\'height:3vh;width:100vw\'></iframe>\n\t\t<iframe name=\'dummy\' id=\'dummy\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize tabindex=-1 style=\'height:0vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=0 scrolling=\'no\' noresize tabindex=-1 style=\'height:7vh;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize tabindex=-1 style=\'height:88vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'auto\' tabindex=-1 style=\'height:5vh;width:100vw\'></iframe>\n\t\t<iframe name=\'dummy\' id=\'dummy\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize tabindex=-1 style=\'height:0vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<script>\n\t\talert(getMessage(\'REFERRAL_ID_NUM_NOT_DEFINED\',\'MP\'));\n\t\tparent.parent.parent.parent.frames[1].expand();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
	ResultSet rset=null;
	ResultSet rset1=null;
	
	try
	{
	String facilityid = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String calling_from =request.getParameter("calling_from"); 
	String speciality_code =request.getParameter("speciality_code"); 
	String patient_id = request.getParameter("patient_id");		
	String practitioner =request.getParameter("practitioner"); 
	String practitioner_name =request.getParameter("practitioner_name");
	String p_calling_function=(request.getParameter("p_calling_function") == null)?"":request.getParameter("p_calling_function");		
	String p_to_locn_type=(request.getParameter("p_to_locn_type") == null)?"":request.getParameter("p_to_locn_type");
	String p_to_locn_code=(request.getParameter("p_to_locn_code") == null)?"":request.getParameter("p_to_locn_code");
	String ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
	
	//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
	String p_service_desc=(request.getParameter("p_service_desc") == null)?"":request.getParameter("p_service_desc");
	String p_service_code=(request.getParameter("service_code") == null)?"":request.getParameter("service_code");
	//END
	
	if (calling_from==null) calling_from="";
	if (speciality_code==null) speciality_code="";
	if (practitioner==null) practitioner="";
	if (practitioner_name==null) practitioner_name="";
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

	//practitioner_name = java.net.URLEncoder.encode(practitioner_name);
	String utl1= "../../eMP/jsp/RegPatReferralMainPage.jsp?";
	utl1 =  utl1+params+"&function_id="+function_id+"&p_calling_function="+p_calling_function+"&p_to_locn_type="+p_to_locn_type+"&ass_func_id="+ass_func_id+"&patientid="+patient_id+"&p_to_locn_code="+p_to_locn_code+"&p_service_desc="+p_service_desc+"&p_service_code="+p_service_code;		
	 if (calling_from.equals("SEARCH"))
	 {
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
}
	int count=0;
	int operator_station_access=0;
	con = ConnectionManager.getConnection(request);
	pstmt1=con.prepareStatement("select count(*) as count  from AM_REF_ID_NUM_FOR_FCY where facility_id='"+facilityid+"'");
	rset1=pstmt1.executeQuery();

	if(rset1 != null)
	{
		if(rset1.next())
		{
			count=rset1.getInt(1);
		}
	}

	if(count != 0)
		{
	pstmt=con.prepareStatement("select count(*) as total from mp_param");
	rset=pstmt.executeQuery();

	if(rset != null)
	{
		if(rset.next())
		{
			operator_station_access=rset.getInt(1);
		}
	}

	
	if(operator_station_access == 0)
	{
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
            _bw.write(_wl_block11Bytes, _wl_block11);

	}

	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();
	
	if (calling_from.equals("SEARCH")) 
	{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( utl1 ));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	else
		{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
		if(rset1 != null) rset1.close();
	if(pstmt1 != null) pstmt1.close();
   }catch(Exception e)
	   {
		 out.println("Exception in main RegPatReferral="+e.toString());
		 e.printStackTrace();
	   }
	   finally
	   {
			if(con != null) ConnectionManager.returnConnection(con,request);
	   }

            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegisterPatientReferral.label", java.lang.String .class,"key"));
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
