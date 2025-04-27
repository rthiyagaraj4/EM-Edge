package jsp_servlet._emp._jsp;

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

public final class __changepatacceptpassword extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ChangePatAcceptPassword.jsp", 1742473772804L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n<script src=\'../../eXH/js/ExternalApplication.js\' language=\"javascript\"></script>\n<script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\">\nfunction validate()\n{\n\tvar db_password = document.getElementById(\"db_password\").value;\n\tvar password = document.getElementById(\"password\").value;\n\n\t//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2\n\tvar active_dir_id = document.getElementById(\"active_dir_id\").value;\n\tactive_dir_id = decodeURIComponent(active_dir_id);\n\n\tif(active_dir_id != \"\"){\n\n\t\t\tretValApi = callSingleSignOnAuth(\'AUTH\',active_dir_id,password);\n\n\t\t\tretValApi = retValApi.split(\"$!^\");\n\n\t\t\tretValApi = trimString(retValApi[0]);\n\n\t\t\tif(retValApi != \"Success\"){\n\t\t\t\talert(\"APP-SM0164 \"+retValApi);\n\t\t\t\tdocument.getElementById(\'password\').value=\"\";\n\t\t\t\tdocument.getElementById(\'password\').focus();\n\t\t\t}else{\n\t\t\t\twindow.returnValue=true;\n\t\t\t\twindow.close();\n\t\t\t\t/* let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\tdialogBody.contentWindow.returnValue = true;\n\t\t\t\t\t\n\t\t\t\tconst dialogTag = parent.parent.document.getElementById\t(\"dialog_tag\");    \n\t\t\t\tdialogTag.close(); */\n\t\t\t}\n\t}else{\n\n\t\tif(db_password == password)\n\t\t{\n\t\t\twindow.returnValue=true;\n\t\t\twindow.close();\n\t\t\t/* let dialogBody = parent.document.getElementById(\'dialog-body\');\n\t\t\tdialogBody.contentWindow.returnValue = true;\n\t\t\t\t\n\t\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t\t\tdialogTag.close(); */\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'common\');\n\t\t\tmsg = msg.replace(\'#\',getLabel(\'Common.password.label\',\'common\'));\n\t\t\talert(msg);\n\t\t\tdocument.getElementById(\'password\').value=\"\";\n\t\t\tdocument.getElementById(\'password\').focus();\n\t\t}\n\t}\n}\n\nfunction cancel1()\n{\n\twindow.close();\n\t/* const dialogTag = parent.parent.document.getElementById\t(\"dialog_tag\");    \n    dialogTag.close();  */\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form method=post action=\"\" name=\'accept_password\' id=\'accept_password\' action=\"../../eMP/jsp/ChangePatAcceptPassword.jsp\" target=\"messageFrame\" method=\"post\">\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\"100%\">\n<!--Added for this CRF HSA-CRF-0222 [IN:050567]-->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<tr>\n<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<td class=\'label\' width=\"80%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<tr>\n\t<td class=\'label\' width=\"20%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<!--<td class=\'fields\'><input type=\"password\" onBlur=\"ChangeUpperCase(this);\" onkeypress=\'JavaScrip:if(event.keyCode==13)return false;\' name=\"password\" id=\"password\"></td>-->\n\t<!--//Maheshwaran modified for the MMS-QH-CRF-0149-->\n\t<!--Modified by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->\n\t<td class=\'fields\' width=\"80%\"><input type=\"password\"  onBlur=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" ChangeUpperCase(this); ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onkeypress=\'JavaScript:if(event.keyCode==13)return false;\' name=\"password\" id=\"password\"></td>\n</tr>\n<tr>\n\t<td class=\'button\' width=\"20%\">&nbsp;</td>\n\t<td width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\'button\' type=\"button\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\'validate()\'><input class=\'button\' type=\"button\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onclick=\'cancel1();\'><td>\n</tr>\n</table>\n<input type=\"hidden\" name=\'db_password\' id=\'db_password\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\n<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2--> \n<input type=\"hidden\" name=\'active_dir_id\' id=\'active_dir_id\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\n</form>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
	//Added for this CRF HSA-CRF-0222 [IN:050567]
	String title=checkForNull(request.getParameter("tit")); 
	String received_witnessid=checkForNull(request.getParameter("received_witnessid"));
	String received_pract_name=checkForNull(request.getParameter("received_pract_name"));
	//End CRF HSA-CRF-0222 [IN:050567]

            _bw.write(_wl_block5Bytes, _wl_block5);
if(!title.equals("")){out.println(title);}else{

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Properties p;
p = (java.util.Properties) session.getValue( "jdbc" ) ;
String UserId = p.getProperty( "login_user" ) ;

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
String active_dir_id = (String)session.getAttribute("active_dir_id")==null?"":(String)session.getAttribute("active_dir_id");
active_dir_id = java.net.URLEncoder.encode(active_dir_id,"UTF-8");


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
	String CASE_SENSITIVE_PASSWORD_YN="";//Maheshwaran added for the MMS-QH-CRF-0149
try{
	conn = ConnectionManager.getConnection(request);
	//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		String sql3="select CASE_SENSITIVE_PASSWORD_YN from sm_site_param";
		pstmt = conn.prepareStatement(sql3);
		rset = pstmt.executeQuery();
		if(rset.next())
			{
			CASE_SENSITIVE_PASSWORD_YN=rset.getString("CASE_SENSITIVE_PASSWORD_YN");
			}
		if(pstmt!=null)pstmt.close();	
		if(rset!=null)rset.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
	//Below query modified for this CRF HSA-CRF-0222 [IN:050567]	
	StringBuffer sbQuery = new StringBuffer("select app_password.decrypt(APPL_USER_PASSWORD) as password from sm_appl_user where appl_user_id='");
	if(!received_witnessid.equals(""))
	sbQuery.append(received_witnessid);
	else
	sbQuery.append(UserId);
	sbQuery.append("'");
	pstmt = conn.prepareStatement(sbQuery.toString());

	String password = "" ;

	rset = pstmt.executeQuery();
	try
	{
	rset.next();
	if ( rset != null ) 
	{
		password = rset.getString( "password" ) ;
		//Maheshwaran added for the MMS-QH-CRF-0149
		if(CASE_SENSITIVE_PASSWORD_YN.equals("N"))
		{
		password=password.toUpperCase();
		}
	}
	}
	catch(Exception e)
		{
		System.err.println(e.toString());
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
if(!received_witnessid.equals("")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(received_pract_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(active_dir_id.equals("")){if(CASE_SENSITIVE_PASSWORD_YN.equals("N")) {
            _bw.write(_wl_block15Bytes, _wl_block15);
}}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(password));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(active_dir_id));
            _bw.write(_wl_block20Bytes, _wl_block20);

	if(pstmt != null)
	pstmt.close();

	if(rset != null)
		rset.close();
}catch(Exception e)
{
	
	e.printStackTrace();
}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EnterPassword.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.password.label", java.lang.String .class,"key"));
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
