package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __religionmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ReligionModify.jsp", 1709118719433L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\'../js/Religion.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onLoad=\'FocusFirstElement()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<form name=\'religion_form\' id=\'religion_form\' action=\'../../servlet/eMP.ReligionServlet\' method=\'post\' target=\'messageFrame\'> \t\n\t\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\t\t<div align=\'left\'>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'40%\'>&nbsp;</td>\n\t\t\t\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'60%\' colspan=\'2\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
String religion_code = request.getParameter("religion_code");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to= "";
try{
	out.println("");
	//Connection conn = (Connection) session.getAttribute( "connection" );
	//Connection conn = (Connection) session.getValue( "connection" );
	conn = ConnectionManager.getConnection(request);
	StringBuffer sbQuery = new StringBuffer( "select relgn_code, long_desc, short_desc, eff_date_from, eff_date_to, eff_status from mp_religion where relgn_code= ? ");
	//sbQuery.append(religion_code);
	//sbQuery.append("'");
	pstmt = conn.prepareStatement(sbQuery.toString());
	pstmt.setString(1, religion_code); // Added by lakshmanan for security issue ID 174298094 on 05-09-2023
	rset = pstmt.executeQuery();
	if ((rset != null)  && rset.next()){//modified for the incident 36244

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	out.println( "<input type='text' name='relgn_code' id='relgn_code' value='" + rset.getString("relgn_code") + "' size='4' maxlength='4'  readonly >" ) ;
	out.println("<img src='../images/mandatory.gif'></img>");
	if ( rset.getDate("eff_date_from") != null ){
		 java.util.Date date = rset.getDate("eff_date_from");
		 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 eff_date_from = formatter.format(date);
		 date = null;
		 formatter = null;
	}
	if ( rset.getDate("eff_date_to") != null){
		 java.util.Date date1 = rset.getDate("eff_date_to");
		 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 eff_date_to = formatter.format(date1);
		 date1 = null;
		 formatter = null;
	}

	if ( rset.getString("eff_status").equals("E") ){
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this);' value=\""+rset.getString("long_desc")+"\">");
		 
            _bw.write(_wl_block9Bytes, _wl_block9);
 out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this);' value=\"");
		out.println( rset.getString("short_desc"));
		out.println("\"> <img src='../images/mandatory.gif'></img></td></tr>");	/*out.println("<tr><td width='40%' align='right' class='label'>Effective From </td><td width='13%' align='left'>&nbsp;&nbsp;&nbsp; */
		
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"'>");
		//out.println("</td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To &nbsp;&nbsp;

		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"' >");
		//out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E'");

		String eff_status = rset.getString("eff_status");

		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");

		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
	}
	if ( rset.getString("eff_status").equals("D") ){
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value=\""+rset.getString("long_desc")+"\" readonly>");

		out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value=\"");
		out.println( rset.getString("short_desc"));	
		out.println("\" readonly >&nbsp;<img src='../images/mandatory.gif'></img></td></tr>");
		/*out.println("<tr><td width='40%' align='right' class='label'>Effective From </td><td width='13%' align='left'>&nbsp;&nbsp;&nbsp;*/
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"' readonly>");
	//out.println("</td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To &nbsp;&nbsp;

		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"' readonly></td></tr>");
		//out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		String eff_status = rset.getString("eff_status");
		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");
		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'  value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
	}
	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
	}
}catch ( Exception e ){
	// out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block10Bytes, _wl_block10);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
