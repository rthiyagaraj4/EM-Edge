package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __orplaceordersecurepin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ORPlaceOrderSecurePIN.jsp", 1743584823771L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-----------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------\n?             100         ?           created\n \n20/01/2012\tIN029143\t  Menaka V\t  <JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in\n\t\t\t\t\t\t\t\t\t  EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.\t\n25/01/2012\t  IN030566\tRamesh G\tWhen we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.\t\n\n27/01/2012\tIN030633\tRamesh G\tWhen the Pin No. is prompted, do not enter the Pin No>Press Enter>A new Window opens.\n31/01/2012\tIN030711\tMenaka V\tWhen the User is not assigned any Pin No. and he enters any Pin\n\t\t\t\t\t\t\t\t\tNo.,Wrong prompt message is displayed\n31/01/2012\tIN030846\tMenaka V\tIn the Prompt Message to enter Pin No. the Cancel Button Caption is aligned \n\t\t\t\t\t\t\t\t\tto the right.\t\t\n15/03/2023\t IN41670\t\t\t\t<Security>Privacy Violation: Autocomplete:AuthorizePinAccess.jsp\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<title>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</title>\n\t<script language=\"javascript\">\n\tfunction makeUpperCase()\n\t{\n\t\tif( (event.keyCode > 96) && (event.keyCode < 123) )\n\t\t{\n\t\t\tevent.keyCode = event.keyCode - 32;\n\t\t}\n\t\treturn true;\n\t}\n\tfunction retModal(obj)\n\t{\n\t\tvar called_frm = document.forms[0].called_frm.value;\n\t\tif(called_frm == \"\")\n\t\t{\n\t\t\tvar returnArray = new Array (\"N\")\n\t\t\tparent.window.returnValue = returnArray;\n\t\t}\n\t}\n\tfunction confirmPasswdchk(obj)\n\t{\n\t\t/*if(document.forms[0].user_id.value==\"\")\n\t\t{\n\t\t\talert(\"Please enter the user name\");\n\t\t\tdocument.forms[0].user_id.focus();\n\t\t\treturn false;\n\t\t}*/\n\t\tif(document.forms[0].passwd.value==\"\")\n\t\t{\n\t\t\t//alert(\"Please enter the Password\");\n\t\t\talert(getMessage(\"ENTER_PIN\",\"OR\"));\n\t\t\tdocument.forms[0].passwd.focus();\n\t\t\treturn false;\n\t\t}\n\t\tvar called_frm = document.forms[0].called_frm.value;\n\t\tvar usr_id=document.forms[0].user_id.value;\n\t\tvar pass_wd=document.forms[0].passwd.value;\n\t\tvar formObj = document.forms[0];\n\t\tbean_id \t\t\t= formObj.bean_id.value;\n\t\tbean_name \t\t\t= formObj.bean_name.value;\n\t\tvar keyObj\t\t\t= formObj.key_obj.value;\t\t//[IN030566]\n\t\tvar patient_id\t\t= formObj.patient_id.value;\t\t//[IN030566]\n\t\tvar query_string =\"\";\n\t\tquery_string\t= \"bean_id=\"+bean_id+\"&bean_name=\"+bean_name+\"&usr_id=\"+usr_id+\"&pass_wd=\"+pass_wd+\"&func_mode=validateUserPIN\";\n\t\t\n\t\t\t\t\t\n\t\t//var xmlDoc  = new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\t\t//var xmlDoc = \"\"; \n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr  = \"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"ORPlaceOrderSecurePINValidation.jsp?\"+query_string, false ) ;\n\t\txmlHttp.send(xmlDoc);\n\t\tif(trimString(xmlHttp.responseText)==\"Y\")\n\t\t{\n\t\t\t//[IN030566] Start\n\t\t\t//var xmlDoc = \"\"; \n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t//var xmlDoc \t\t= new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\t\t\t//var xmlHttp \t= new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\n\t\t\txmlStr\t\t\t= \"<root><SEARCH \" ;\n\t\t\txmlStr \t\t\t+=\" /></root>\" ;\n\t\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open( \"POST\", \"ORPlaceOrderSecurePINTEMPPASSValidation.jsp?mode=Set&keyObj=\"+keyObj+\"&keyValue=\"+pass_wd+\"&patient_id=\"+patient_id, false ) ;\n\t\t\txmlHttp.send( xmlDoc ) ;\n\t\t\tif(trimString(xmlHttp.responseText)!=\"false\")\n\t\t\t{\n\t\t\t\t//window.returnValue = \"true\";\t\t\t\n\t\t\t\t//window.close();\n\t\t\t\tlet dialogBody = parent.document.getElementById(\'dialog-body\');\n\t\t\t    dialogBody.contentWindow.returnValue = \"true\";\n\t\t\t    \n\t\t\t    const dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t\t\t    dialogTag.close();   \n\t\t\t}\n\t\t\t//window.returnValue = \"true\";\t\t\t\n\t\t\t//window.close();\n\t\t\t//[IN030566] Ends\n\t\t}\n\t\telse if(trimString(xmlHttp.responseText)==\"E\")//IN030711 Starts\n\t\t{\n\t\t\talert(getMessage(\"PIN_NOT\",\"OR\"));\n\t\t\treturn false;\n\t\t}//IN030711 Ends\n\t\telse\n\t\t{\n\t\t\t//alert(\"INVALID USER NAME\");\n\t\t\talert(getMessage(\"INVALID_PIN\",\"OR\"));\n\t\t\t//window.close();\n\t\t\treturn false;\n\t\t}\n\t\t\n\t}\n\t//[IN030633] Start.\n\tfunction keyHandel(e)\n\t{\n\t\tvar keynum\t\t\n\t\tif(window.event) // IE\t\n\t\t\tkeynum = e.keyCode\t\n\t\telse if(e.which) // Netscape/Firefox/Opera\t\n\t\t\tkeynum = e.which\n\t\t\n\t\tif(keynum==13){\n\t\t\tconfirmPasswdchk(this);\n\t\t\treturn false;\n\t\t}\n\t\treturn true;\n\t}\n\t//[IN030633] Ends.\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body >\n\t<form name=\"PlaceOrderUserPINForm\" id=\"PlaceOrderUserPINForm\">\n\t\t<table  border=\'0\' align=\"center\" width=\'103%\' cellpadding=\'3\' cellspacing=\'3\'>\n\t\t\t<!--<tr>\n\t\t\t\t<td width=\"50%\" class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"50%\" class=\"fields\">\n\t\t\t\t\t<input type=\'text\' name=\'user_id\' id=\'user_id\' size=\'20\' maxlength=\'20\' onKeyPress=\'return makeUpperCase()\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t</tr>-->\n\t\t\t<tr>\n\t\t\t\t<td width=\"20%\" class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"50%\" class=\"fields\">\n\t\t\t\t<!-- [IN030633]\n\t\t\t\t\t<input type=\'password\' name=\'passwd\' id=\'passwd\' size=\'21\' maxlength=\'64\'> -->\n\t\t\t\t\t<input type=\'password\' name=\'passwd\' id=\'passwd\' size=\'20\' maxlength=\'64\' onkeypress=\"return keyHandel(event)\" autocomplete=\"off\"><!-- [IN030633]  --><img src=\'../../eCommon/images/mandatory.gif\'><!--30846-->  <!--41670 autocomplete=\"off\"-->\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\"></td>\n\t\t\t\t<td width=\"50%\" align=\'right\'><!--IN030846-->\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'auth_ok\' id=\'auth_ok\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onClick =\'return confirmPasswdchk(this);\'><input type=\'button\' class=\'button\' name=\'auth_cancel\' id=\'auth_cancel\'  value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onClick=\'parent.window.close(); return retModal(this);\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<!--<script>\n\t\t\t\t//document.forms[0].user_id.focus();\n\t\t\t\tusr_id.focus();\n\t\t\t</script>-->\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"   >\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t<input type= \'hidden\' name=\"called_frm\" id=\"called_frm\"  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"   >\n\t\t<input type= \'hidden\' name=\"key_obj\" id=\"key_obj\"  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\t\t\t<!-- [IN030566]  -->\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"   >\t<!-- [IN030566]  -->\n\t\t\n\t</form>\n</body>\n</html>\n<script language=\"javascript\">\n\t//document.getElementById(\"checklist_user_pin\").focus();\n</script>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);

	
	String called_frm = request.getParameter("called_frm");
	if(called_frm == null) called_frm="";
	String user_id	= (String)session.getValue("login_user");
	
	//String user_id		= request.getParameter("pract_id");
	String bean_id		= "@OrderEntryBean";
	String bean_name	= "eOR.OrderEntryBean";
	String keyObj	= request.getParameter("keyObj");		//[IN030566]
	String patientId = request.getParameter("patient_id");		//[[IN030566]]

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(keyObj));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PIN.label", java.lang.String .class,"key"));
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
}
