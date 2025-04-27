package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __quicktext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QuickText.jsp", 1709116108090L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html> \n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction doClose()\n{\n\twindow.close();\n}\n\nfunction loadInit(locale)\n{\n\tvar resComments = window.dialogArguments;\n\t\n\tresComments = unescape(resComments); //ML-BRU-SCF-1642 - IN057138\n\t//IN064071 Start\n\tresComments = resComments.replace( /\\+/g, \' \' );\n\tresComments = resComments.replace(\"%20\",\" \");\n\tresComments = resComments.replace(\"%7E\",\"~\");\n\tresComments = resComments.replace(\"%3A\",\":\");\n\t//IN064071 End\n\t//IN067806 added from below\n\twhile(resComments.indexOf(\"&#126\")!=-1) \n\t\tresComments = resComments.replace(\"&#126\",\"~\");\n\t//IN067806 added from below\n\twhile(resComments.indexOf(\"~ \")!=-1)\n\t\tresComments = resComments.replace(\"~ \",\"\\r\\n\");\n\t/*while(resComments.indexOf(\"`\")!=-1)\n\t\tresComments = resComments.replace(\"`\",\"\'\");*/\n\twhile(resComments.indexOf(\"|\")!=-1)\n\t\tresComments = resComments.replace(\"|\",\"\\\"\");\n\twhile(resComments.indexOf(\"&#92\")!=-1) //ML-BRU-SCF-1642 - IN057138 Start\n\t\tresComments = resComments.replace(\"&#92\",\"\\\\\");\n\twhile(resComments.indexOf(\"&#124\")!=-1) \n\t\tresComments = resComments.replace(\"&#124\",\"|\");\n\twhile(resComments.indexOf(\"&#39\")!=-1) \n\t\tresComments = resComments.replace(\"&#39\",\"\'\");\n\twhile(resComments.indexOf(\"&#96\")!=-1) \n\t\tresComments = resComments.replace(\"&#96\",\"`\");\n\t//IN067806 commented here\n\t/*\n\twhile(resComments.indexOf(\"&#126\")!=-1) \n\t\tresComments = resComments.replace(\"&#126\",\"~\");\n\t*/\n\t//IN067806 Commented here added to top\n\twhile(resComments.indexOf(\"\\\\\\\"\")!=-1) \n\t\tresComments = resComments.replace(\"\\\\\\\"\",\"\\\"\");\t\t\n\twhile(resComments.indexOf(\"&#43\")!=-1) \n\t\tresComments = resComments.replace(\"&#43\",\"+\");\t //ML-BRU-SCF-1642 - IN057138 End\n\t\t\t\n\tvar arr=new Array();\n\tvar temp;\n\tvar tempData = \"\";\t\n\tvar displaydtls = \"\";\t\n\tarr=resComments.split(\",\");\n\t\n\tfor(var index = 0; index < arr.length;index++){\n\t\tif(arr[index].indexOf(\"Transferred Date\")!= -1)//IN67889, starts\n\t\t{\n\t\t\ttemp = arr[index].substring(18,arr[index].length);\n\t\t\ttemp = convertDate(temp,\'DMYHM\',\'en\',locale);\n\t\t\ttemp = \" Transferred Date : \"+temp;\n\t\t\ttempData += temp + \",\";\t\t\t\n\t\t}//IN67889, ends\n\t\t/* //commented for IN069434\n\t\telse if(arr[index].indexOf(\"Date\")!= -1)\n\t\t{\n\t\t\ttemp = arr[index].substring(7,arr[index].length);\n\t\t\ttemp = convertDate(temp,\'DMYHM\',\'en\',locale);\n\t\t\ttemp = \" Date : \"+temp;\n\t\t\ttempData += temp + \",\";\t\t\n\t\t}//commented for IN069434\n\t\t*/\t\t\n\t\telse\n\t\t{\n\t\t\tif(tempData != null || tempData != \"\")\n\t\t\ttempData += arr[index]+ \",\";\n\t\t}\n\t}\n\t//Below line is added by Archana Dhal on 11/24/2010 related to IN025200.\n\tdisplaydtls = tempData.substring(0,tempData.length-1);\n\n\t\n\tdocument.forms[0].comments.value = displaydtls;\t\n\tdocument.forms[0].comments.focus();\n}\n\n\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\'loadInit(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\")\'>\n<form>\n<center>\n\t<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=center>\n\t<tr><td>\n\t<table width=\'50%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=center>\n\t<tr><td align=\'left\'>&nbsp;</td></tr>\n\t<tr>\n\t\t<td align=\'center\'><textarea name=\"comments\" rows=\"12\" cols=\"50\" readOnly></textarea></td>\n\t</tr>\n\t<tr><td align=\'left\'>&nbsp;</td></tr>\n\t<tr><td align=\'right\'><input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'    Ok    \' onclick=\'doClose()\'></td></tr>\n\t<tr><td align=\'left\'>&nbsp;</td></tr>\n</table></td></tr></table>\n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/11/2015	IN057138		Karthi L										Chief Complaint ( Long Text ) which has been recorded  from the Manage Patient ...
11/05/2017	IN064071		Krishna Gowtham		11/05/2017		Ramesh G 	Alpha - CA-Clinical Event History-Flow sheet View-System does not display the 
																			Result Comments properly.
06/06/2018	IN067806		Raja S			06/06/2018		Ramesh G		MO-CRF-20144																	
06/06/2018	IN67889		Dinesh T			06/06/2018		Ramesh G	Transfer Date and Time is not displaying in flowchart --> Result / Remarks Webpage Dialog																			
21/01/2019	IN069434		Raja S			21/01/2019		Ramesh G		ML-MMOH-SCF-1128
-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/*String resComments	= request.getParameter("resultStr");
	
	if( resComments == null) resComments="";
	else
	{
		while(resComments.indexOf("~")!=-1)
		{	
			int a=resComments.indexOf("~");
			StringBuffer temp=new StringBuffer(resComments);
			temp.replace(a,a+1,"\r\n");
			resComments=temp.toString();
		}
		while(resComments.indexOf("`")!=-1)
		{	
			int a=resComments.indexOf("`");
			StringBuffer temp=new StringBuffer(resComments);
			temp.replace(a,a+1,"'");
			resComments=temp.toString();
		}
		while(resComments.indexOf("|")!=-1)
		{	
			int a=resComments.indexOf("|");
			StringBuffer temp=new StringBuffer(resComments);
			temp.replace(a,a+1,"\"");
			resComments=temp.toString();
		}	
	}*/

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResultRemarks.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
