package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import oracle.sql.*;
import oracle.jdbc.driver.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;

public final class __xhviewmessagesimulatoetreetext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHViewMessageSimulatoeTreeText.jsp", 1709122425756L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n \n<HEAD>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n</HEAD>\n <script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\" ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script> \n<script language=\'javascript\' src=\'../../eXH/js/ViewServerProcessErrors.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n<script>\nfunction formload()\n{\n   var message=getMessage(\'XH0087\',\'XH\');\n\t  alert(message);\t\t\n\t  document.forms[0].Msg_text.focus();\n}\n</script>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\' onLoad=\"formload();\" >\n<form>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<table cellspacing=0 cellpadding=3 width=\"100%\" align=\"center\"> \n<tr>\n\t<td class=\'fields\'><TEXTAREA NAME=\"Msg_text\" ROWS=\"40\" COLS=\"65\" onblur=\"funSaveOption()\"></TEXTAREA></td> \n</tr> \n<tr>\n</tr> \n</table>\n<input type=hidden name=\"applicationName\" id=\"applicationName\" id=\"applicationName\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=hidden name=\"facilityName\" id=\"facilityName\" id=\"facilityName\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=hidden name=\"protocol_mode\" id=\"protocol_mode\" id=\"protocol_mode\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=hidden name=\"sub_module\" id=\"sub_module\" id=\"sub_module\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=hidden name=\"applicationId\" id=\"applicationId\" id=\"applicationId\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=hidden name=\"facilityId\" id=\"facilityId\" id=\"facilityId\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=hidden name=\"msgId\" id=\"msgId\" id=\"msgId\" value=\'\'>\n<input type=hidden name=\"ProtocolID\" id=\"ProtocolID\" id=\"ProtocolID\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=hidden name=\"event_type\" id=\"event_type\" id=\"event_type\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\t\t   \t  \n</form>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<script>\nfunction funSaveOption() \t\t\t \t \n{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\n\t\t\t//  !=null || document.forms[0].Msg_text.value!=\"\"\n\t\tif(document.forms[0].Msg_text.value){  \t\t\tparent.f_query_add_mod_tree.document.location.href=\"../../eXH/jsp/XHViewMessageSimulateDisplay.jsp?applicationName=\"+document.forms[0].applicationName.value+\"&applicationID=\"+document.forms[0].applicationId.value+\t\"&facilityID=\"+document.forms[0].facilityId.value+\"&facilityName=\"+document.forms[0].facilityName.value+\"&protocol_link_id=\"+document.forms[0].ProtocolID.value+\"&even_type=\"+document.forms[0].event_type.value+\"&Msg_text=\"+escape(document.forms[0].Msg_text.value);\n\t\t} \n\t\telse\n\t\t{\n\n\t\t}\n}\n function windowclose()\t\t\t\t\t\t\t    \t\t\t\t\t   \n {\t\t\t\t\t\t\t\t\t    \t\t   \n\t window.close();\t\t\t   \t\t\t\t\t\t\t    \t\t\t\t       \n }\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t   \n</BODY>\t\t\t\t\t\t\t\t\t\t\t\t\t    \n</HTML> \t\t\t\t\t\t\t\t\t\t \n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String eventName=XHDBAdapter.checkNull(request.getParameter("event"));
String standard_code=XHDBAdapter.checkNull(request.getParameter("standard_code"));
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eventName));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String url="";
	String event_name=""; 
	String applicationId = "";
	String facilityId = "";
	String msgId = "";
	String eventType = "";
	String ProtocolID = "";							    
	String Msq_txt = "";
	String MsgText = "";		   
	String Standard_code = "";
	String Message_syntax = "";
	String Standard_symbols = "";
	String errorMsg = "";
	String event="";
	String Standard_type = "";
	String msgstatus = "";	
	String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
	String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
	String protocol_mode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
	String sub_module = request.getParameter("sub_module");
	String srlNo = request.getParameter("srlNo");
    applicationId = request.getParameter("applicationID"); 
    facilityId = request.getParameter("facilityID");
    msgId = request.getParameter("msgID");
    ProtocolID = request.getParameter("protocol_link_id");
	String event_type = request.getParameter("event_type");
	Connection dbConn = null;												 
	Statement stmt = null; 
	ResultSet rs = null;
  String sqlstr=""; 
String Element_desc="";
try
{ 
	dbConn = ConnectionManager.getConnection(request);
}
catch(Exception w)
{
	System.out.println("Errors in ViewElementTreeText.jsp "+w);
}
try
{
	
	if(protocol_mode.equals("Inbound")||protocol_mode.equals("inbound")) 
	{
		protocol_mode="I";  										    
	} 
	else if(protocol_mode.equals("Outbound")||protocol_mode.equals("outbound"))
	{
		protocol_mode="O";
	}

							 			 


}
catch(Exception e)
{
	System.out.println("Errors in ViewElementTreeText.jsp "+e);
}
finally
	{
	 try{
			if(rs!=null)	   
			{
				rs.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
			ConnectionManager.returnConnection(dbConn);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewElementTreeText.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }
	} 



 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(applicationName));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(applicationId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(ProtocolID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(event_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
