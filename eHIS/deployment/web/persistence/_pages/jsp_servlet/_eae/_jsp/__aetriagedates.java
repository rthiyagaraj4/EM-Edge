package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aetriagedates extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AETriageDates.jsp", 1709113864631L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eAE/js/AETriageDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n <body onKeyDown = \'lockKey()\'>\n   <form name=\"ae_triage_search_form\" id=\"ae_triage_search_form\" >\n <br>\n\t <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'100%\'>\n\t\t <tr><th align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th></tr>\n       ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t    </table>\n          <input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n   \t\t  <input type=\'hidden\' name=\'treatment_area_code\' id=\'treatment_area_code\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n          <input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\n\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</form>\n   </body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
   try{
		String facilityId			 = (String)session.getValue("facility_id");
		String clinic_code			 = request.getParameter("clinic_code");
			   clinic_code			 = (clinic_code == null)?"":clinic_code;
	    String orig_tmt_area_code	 = request.getParameter("orig_tmt_area_code");
			   orig_tmt_area_code	 = (orig_tmt_area_code == null)?"":orig_tmt_area_code;

		
	    String treatment_area_code	 = request.getParameter("treatment_area_code");
			   treatment_area_code	 = (treatment_area_code == null)?"":treatment_area_code;
	    String treatment_area_desc	 = request.getParameter("treatment_area_desc");
			   treatment_area_desc	 = (treatment_area_desc == null)?"":treatment_area_desc;
		String encounter_id			 = request.getParameter("encounter_id");
			   encounter_id			 = (encounter_id == null)?"":encounter_id;
		String  Temp_desc="";
		String queryString			 = request.getQueryString();
		String classValue			 = "";
		int i						 = 0;
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
		
		con                  = ConnectionManager.getConnection(request);
	
		String strsql = "select to_char(a.TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') "+
			"TRIAGE_START_DATE_TIME,b.SHORT_DESC ,a.ENCOUNTER_ID, "+
			" a.TREATMENT_AREA_CODE , a.TRIAGE_START_DATE_TIME "+
			"from AE_PAT_TRIAGE a,ae_tmt_area_for_clinic b where a.FACILITY_ID= ? and  "+
			"a.encounter_id = ? and a.CLINIC_CODE = ?  and "+
			"a.FACILITY_ID=b.FACILITY_ID  and  a.CLINIC_CODE=b.CLINIC_CODE and "+
			"a.TREATMENT_AREA_CODE=b.TREATMENT_AREA_CODE  order by a.TREATMENT_AREA_CODE,5 desc ";

		pstmt = con.prepareStatement(strsql);
		pstmt.setString	(1,	facilityId);
		pstmt.setString	(2,	encounter_id);
		pstmt.setString	(3,	clinic_code);
		rset = pstmt.executeQuery();
		
	    while(rset!=null && rset.next())
	    {
			String Short_desc =rset.getString("SHORT_DESC");
				if(!Short_desc.equals(Temp_desc )){
					out.println("<tr><th class='BLUECOLOR' align='left'>"+Short_desc+"</th></tr>");
				}
				Temp_desc=Short_desc;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
				out.println("<tr><td class='" + classValue + "'>");
				 out.println("<font size='1'><a href=\"javascript:callDate('"+rset.getString("TRIAGE_START_DATE_TIME")+"','"+rset.getString("ENCOUNTER_ID")+"','"+rset.getString("TREATMENT_AREA_CODE")+"','"+orig_tmt_area_code+"')\">");
			     out.println(rset.getString("TRIAGE_START_DATE_TIME")==null?"": rset.getString("TRIAGE_START_DATE_TIME") );
				out.println("</a></td></tr>");
			i++;
		}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(clinic_code)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(treatment_area_code)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(queryString)));
            _bw.write(_wl_block13Bytes, _wl_block13);

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close();
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.RecordedDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
