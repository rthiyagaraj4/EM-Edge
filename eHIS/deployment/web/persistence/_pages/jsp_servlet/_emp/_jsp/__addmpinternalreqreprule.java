package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __addmpinternalreqreprule extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/addMpInternalReqRepRule.jsp", 1709118586104L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Latest Modified Date Time : 9/30/2005 10:54 AM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n      <head>\n      \t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t  </head>\n\n      <body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey();\' onLoad=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n      \t<form name=\'MpInternalReqRepRule_Form\' id=\'MpInternalReqRepRule_Form\' action=\'../../servlet/eMP.MpInternalReqRepRuleServlet\' method=\'post\' target=\'messageFrame\'>\n      \t<div align=\'left\'><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n      \t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\t\t\t<TR><td class=label colspan=\'3\'>&nbsp;</td></TR>\n      \t\t<tr>\n      \t\t    <td  width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n      \t\t    <td width=\'60%\' colspan=\'2\' class=\"fields\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<img src=\'../images/mandatory.gif\'></img></td>\n      \t\t</tr>\n     \t\t<tr>\n      \t\t    <td  width=\'40%\' class=label>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n      \t\t    <img src=\'../images/mandatory.gif\'></img></td>\n      \t\t</tr>\n      \t\t<TR><td class=label colspan=\'3\'>&nbsp;</td></TR>\n      \t</table>\n      \t</div>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n      \t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n\t      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t  \t<input type=\'hidden\' name=\'print_req_yn\' id=\'print_req_yn\' value=\'Y\'>\n\t\t    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n     \t \t<input type=\'hidden\' name=\'function\' id=\'function\'>\n      \t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\'>\n      \t\t<input type=\'hidden\' name=\'report_id\' id=\'report_id\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n      \t\t<input type=\'hidden\' name=\'pat_ser_grp_code\' id=\'pat_ser_grp_code\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n      \t</form>\n  \t</body>\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection conn			= null;
	java.sql.Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;

	String  reportdesc			= "";
	String  reportid			= "";
	String focus				= "";
	String pshortdesc			= "";
	String pseriescode			= "";
	String maintain_doc_or_file = "";
	
	StringBuffer str1 = null;
	StringBuffer str2 = null;

	str1 = new StringBuffer();
	str2 = new StringBuffer();

	boolean newReqType = false;

	reportid	= request.getParameter("report_id");
	reportdesc	= request.getParameter("report_desc");
	pseriescode	= request.getParameter("pat_ser_grp_code");
	pshortdesc	= request.getParameter("short_desc");

	conn = ConnectionManager.getConnection(request);
	
	stmt = conn.createStatement();
	rset = stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param");
	if(rset.next())
	{
		maintain_doc_or_file = rset.getString(1);
		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 
			maintain_doc_or_file = "F";
	}
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
	if(reportid == null && reportdesc == null && pseriescode == null && pshortdesc == null)
	{
		try
		{
			if(maintain_doc_or_file.equals("D"))
			{
				if(pstmt!=null) pstmt.close();
				pstmt = conn.prepareStatement("SELECT report_id, report_desc FROM sm_report WHERE module_id = 'MP' AND internal_request_yn = 'Y' AND report_id != 'MPBFLLBL' ORDER BY report_desc");
			}
			else
			{
				if(pstmt!=null) pstmt.close();
				pstmt = conn.prepareStatement("select REPORT_ID,REPORT_DESC from sm_report where module_id='MP' and INTERNAL_REQUEST_YN='Y' order by report_desc");
			}
			rset = pstmt.executeQuery();
			focus ="Focusing('report_id')";
			str1.append(" <select name='report_id' id='report_id'><option value='' selected>------------------------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------------------</option> ");
			while(rset.next())
			{
				reportid=rset.getString("REPORT_ID");
				reportdesc=rset.getString("REPORT_DESC");
				str1.append(" <option value=\""+reportid+"\">"+reportdesc+"</option> ");
			}
			str1.append(" </select> ");
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			pstmt = conn.prepareStatement( "select pat_ser_grp_code,short_desc from mp_pat_ser_grp order by short_desc");
			rset = pstmt.executeQuery();
			str2.append(" <select name='pat_ser_grp_code' id='pat_ser_grp_code'><option value='' selected>------------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------</option> ");
			while(rset.next())
			{
				pseriescode=rset.getString("pat_ser_grp_code");
				pshortdesc=rset.getString("short_desc");
				str2.append(" <option value=\""+pseriescode+"\">"+pshortdesc+"</append> ");
			}
			str2.append(" </select> ");
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();
			
				
		}catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174072332 on 28-08-2023
			}
		finally
		{
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}

		newReqType=true;
	}
	else
	{
		newReqType=false;
		
		try
		{
			pstmt = conn.prepareStatement("select report_id,report_desc,pat_ser_grp_code,short_desc from mp_online_reports_vw where report_id=? and pat_ser_grp_code=? ");
			pstmt.setString(1, reportid);
			pstmt.setString(2,pseriescode);
			rset = pstmt.executeQuery();
			rset.next();
			reportid	= rset.getString("report_id");
			reportdesc	= rset.getString("report_desc");
			pseriescode	= rset.getString("pat_ser_grp_code");
			pshortdesc	= rset.getString("short_desc");

			str1.append(" <input type='text' name='report_desc' id='report_desc' value=\""+reportdesc+"\" size='30' maxlength='30' READONLY> ");

			str2.append(" <input type='text' name='short_desc' id='short_desc' value=\""+pshortdesc+"\" size='15' maxlength='15' READONLY> ");

			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();
		}catch(Exception e) { 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174072333 on 28-08-2023
			}
		finally
		{
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}
	}//end else

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(focus));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(str1.toString()));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(str2.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);

		if(newReqType)
		{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else
		{
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(reportid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pseriescode));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}

		if(str1 != null && str1.length() > 0)
		{
			str1.delete(0, str1.length());
		}
		if(str2 != null && str2.length() > 0)
		{
			str2.delete(0, str2.length());
		}
		
            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.InternalRequestReport.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
