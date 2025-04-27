package jsp_servlet._eam._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __hlthcaresetgtyprestnsmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/HlthCareSetgTypRestnsModify.jsp", 1712922731706L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n <form name=\'HlthCareSetgTypRestns_form\' id=\'HlthCareSetgTypRestns_form\' action=\'../../servlet/eAM.HlthCareSetgTypRestnsServlet\' method=\'post\' target=\'messageFrame\'>\n <BR><BR><BR><BR><BR><BR><BR><BR><BR><div align=\'left\'>\n <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'65%\' align=\'center\'>\n <tr>\n\t <td width=\'40%\'>&nbsp;</td>\n\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td></tr>\n <tr>\n\t <td width=\'60%\' class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t <td width=\'60%\' colspan=\'2\' class=\'fields\'>&nbsp;&nbsp;\n<input type=\'text\' width=\'40%\' name=\'from_short_desc\' id=\'from_short_desc\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' size=\'15\' readonly >\n<input type=\'hidden\' name=\'from_hcare_setting_type_code\' id=\'from_hcare_setting_type_code\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' size=\'2\' >\n\n<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\n\t</td>\n</tr>\n\n\t<tr>\n\t\t<td width=\'60%\'>&nbsp;</td><td width=\'60%\' colspan=\'2\'>&nbsp;</td></tr><tr><td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td width=\'60%\' colspan=\'2\' class=\'fields\'>&nbsp;&nbsp;\n\t\t<input type=\'text\' width=\'40%\' name=\'to_short_desc\' id=\'to_short_desc\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' size=\'15\' readonly >\n\t\t<input type=\'hidden\' name=\'to_hcare_setting_type_code\' id=\'to_hcare_setting_type_code\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' size=\'2\' >\n\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t\n\t</tr>\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

	public boolean datecompare(java.util.Date dt) {
		java.util.Date systemdate=new java.util.Date();
		if(dt.before(systemdate)) return true;
		else return false;
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String from_hcare_setting_type_code="";
String from_desc="";
String to_hcare_setting_type_code="";
String to_desc="";
String ip_referral_yn ="";
String op_referral_yn ="";
String f_hcare_setting_type_code = request.getParameter("from_hcare_setting_type_code");
String t_hcare_setting_type_code = request.getParameter("to_hcare_setting_type_code");

PreparedStatement pstmt=null;
ResultSet rset=null;
Connection conn = null;


            _bw.write(_wl_block2Bytes, _wl_block2);

try{


conn = ConnectionManager.getConnection(request);

String sql = "select from_hcare_setting_type_code,f.short_desc from_desc,to_hcare_setting_type_code,t.short_desc to_desc,ip_referral_yn,op_referral_yn from am_hcare_setting_type_rstrn r,am_hcare_setting_type f,am_hcare_setting_type t where r.from_hcare_setting_type_code = f.hcare_setting_type_code and r.to_hcare_setting_type_code = t.hcare_setting_type_code and from_hcare_setting_type_code='"+f_hcare_setting_type_code+"' and to_hcare_setting_type_code='"+t_hcare_setting_type_code+"'";

pstmt = conn.prepareStatement(sql);
rset = pstmt.executeQuery();

while(rset.next())
	{
		from_hcare_setting_type_code = rset.getString("from_hcare_setting_type_code");
		from_desc=rset.getString("from_desc");
		to_hcare_setting_type_code=rset.getString("to_hcare_setting_type_code");
		to_desc=rset.getString("to_desc");
		ip_referral_yn=rset.getString("ip_referral_yn");
		op_referral_yn=rset.getString("op_referral_yn");

	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(from_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(from_hcare_setting_type_code));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(to_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(to_hcare_setting_type_code ));
            _bw.write(_wl_block13Bytes, _wl_block13);

	out.println("<tr><td width='60%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td  width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.InpatientReferral.label","am_labels")+"</td><td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='checkbox' name='ip_referral_yn' id='ip_referral_yn' value='Y'");
	if  ( ip_referral_yn.equals("Y") )
		out.println("checked >");
	else
		out.println(">");
	out.println("</td></tr>");

	out.println("<tr><td width='60%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td  width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OutpatientReferral.label","am_labels")+"</td><td width='60%' colspan='2' class='fields'>&nbsp;&nbsp;<input type='checkbox' name='op_referral_yn' id='op_referral_yn' value='Y'");
	if  ( op_referral_yn.equals("Y") )
		out.println("checked >");
	else
		out.println(">");
	out.println("</td></tr>");

	out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
//}
	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;

}
catch ( Exception e )
{
 out.println(e.toString());
}
finally{
  
	ConnectionManager.returnConnection(conn,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.FromHealthCareSettingType.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ToHealthCareSettingType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
