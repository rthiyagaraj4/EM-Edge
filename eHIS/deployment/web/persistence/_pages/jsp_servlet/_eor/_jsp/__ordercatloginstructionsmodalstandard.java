package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ordercatloginstructionsmodalstandard extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderCatlogInstructionsModalStandard.jsp", 1731586950000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html> \n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<style>\n\ttextarea {\n\t  resize: none;\n\t}\n</style>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction doClose()\t\n{   \n\tdoSync(document.forms[0]);\t\n\t//const dialogTag = parent.document.getElementById(\"dialog_tag\"); \n\tconst diagElement = parent.document.getElementsByTagName(\'dialog\');\n\tfor (var i = 0; i < diagElement.length; i++) {\n\t\tfor (var j = 0; j < diagElement[i].children.length; j++) {\n\t\t\tvar element = diagElement[i].children[j];\n\t\t\tlet dialogSrc = element.src;\n\t\t\tif (typeof dialogSrc !== \'undefined\') {\n\t\t\t\tif (dialogSrc.includes(\'OrderCatlogInstructionsModalStandard.jsp\')) {\n\t\t\t\t   diagElement[i].close(); \n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\t\n    //dialogTag.close(); \n\t//window.close();\n}\n\nfunction checkMaxLimit(obj,maxSize)\t\n{\n\t\tif ( obj.value.length >= maxSize )\n\t\t{\n\t\t\tevent.returnValue = false;\n\t\t}\n}\n\nfunction closeWin()\n{\n\n}\n\nfunction chkLength(Obj,len)\n{\n\tif(Obj.value.length > parseInt(len))\n\t{\n\t\talert(\'The number of characters cannot exceed \'+len);\n\t\tObj.focus();\n\t}\n\n}\n\n/****doSync This function--Sync the current tab to bean before going to other tab********/\nfunction doSync(frmObj){\n\t\n\t/* var xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\t\n\tvar xmlString = buildXml(frmObj);\t\n\txmlDoc.loadXML(xmlString);\n\txmlHttp.open(\"POST\",\"../../eOR/jsp/OrderCatalogInstructionSync.jsp\",false);\n\txmlHttp.send(xmlDoc);  \n\treturn xmlHttp.responseText  ;*/\n\t\n\tvar xmlStr = buildXml(frmObj);\n\t\n\tvar parser = new DOMParser();\n    var xmlDoc = parser.parseFromString(xmlStr, \"text/xml\");\n\t\n\tvar xmlHttp = new XMLHttpRequest();\n    xmlHttp.open(\"POST\", \"../../eOR/jsp/OrderCatalogInstructionSync.jsp\", false);\n    xmlHttp.setRequestHeader(\"Content-Type\", \"text/xml\");\n    \n \t// Send the XML\n    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));\n    // Handle the response\n    var responseText = xmlHttp.responseText;\n    responseText = trimString(responseText);  \n\t\n\treturn responseText;\n}\n/****************this methos is called by the Sync jsp in retrun text******/\nfunction syncStatus(flag)\n{\n//\talert(flag);\t\n\treturn flag ;\n}\n/***********************doSync****************************************/\nfunction buildXml(frmObj){\n\t\n   \n    var arrObj = frmObj.elements;\n\n    var frmObjs = new Array()\n    if(frmObj.name == null)\n        frmObjs = frmObj ;\n    else frmObjs[0] = frmObj ;\n    var xmlStr =\"<root><SEARCH \";\n\n\tfor(var frmCount=0; frmCount<frmObjs.length; frmCount++) {\n\tfrmObj = frmObjs[frmCount]\n\tvar arrObj = frmObj.elements;\n\n\t\tfor(var i=0;i<arrObj.length;i++) {\n\t\t\tvar val = \"\" ;\n\t\t\tif(arrObj[i].type == \"checkbox\") {\n\t\t\t\tif(arrObj[i].checked)\n\t\t\t\t\tval = arrObj[i].value;\n\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t}\n\t\t\telse if(arrObj[i].type == \"radio\") {\n\t\t\t\tif(arrObj[i].checked) {\n\t\t\t\t\tval = arrObj[i].value;\n\t\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(arrObj[i].type == \"select-multiple\" )\n\t\t\t{\n\t\t\t\tfor(var j=0; j<arrObj[i].options.length; j++)\n\t\t\t\t{\n\t\t\t\t\tif(arrObj[i].options[j].selected)\n\t\t\t\t\t\tval+=arrObj[i].options[j].value +\"~\"\n\t\t\t\t}\n\t\t\t\tval= val.substring(0,val.lastIndexOf(\'~\'))\n\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\n\t\t\t}\n\t\t\telse {\n\t\t\t\tval = arrObj[i].value;\n\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t}\n\t\t}\n\t}\n\n    xmlStr +=\" /></root>\";\n\n\t//alert(xmlStr);\n\treturn xmlStr;\n\n}\n\n\n</script>\n\n\n\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\n</head>\n\n\n<body onload=\'\' onUnload =\'closeWin()\'  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\"\n><!-- style=\'background-color:#E2E3F0;\' -->\n<form name=\'StdInstructions\' id=\'StdInstructions\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\'>\n\n\n \n<tr>\n\t<td class=\"fields\" width=\'100%\' ><textarea name=\"pat_preps_or_instrns_txt_is\" rows=\"10\" cols=\"63\" onkeypress=\"checkMaxLimit(this,1000);\" onBlur=\"SPCheckMaxLen(\'Standard Instructions\',this,1000);makeValidString(this);\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</textarea></td>\n\n</tr>\n</table>\n<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\'>\n<tr><td class=\"button\" align=\"right\"><input type=\'Button\' class=\'Button\' name=\'OK\' id=\'OK\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onclick=\'doClose()\'></td></tr>\n\n<input type=\"hidden\" name=\"instructionType\" id=\"instructionType\"  value=\"IS\">\n<input type=\"hidden\" name=\"instrn_content_type\" id=\"instrn_content_type\"  value=\"T\">\n\t\n</table>\n</form>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	 request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

try{
	
	/* Mandatory checks start */
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	

	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name ,request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	HashMap recordStdIntruction =  bean.getInstructionStdByAge("IS") ;

	Object msgTxtObj = recordStdIntruction.get("pat_preps_or_instrns_txt_is");
	String msgTxt = "" ;

	if(msgTxtObj == null )
	msgTxt = "" ;
	else
	msgTxt = (String)msgTxtObj ;
//out.println(msgTxt);


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(msgTxt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);

		putObjectInBean(bean_id,bean,request); 
 
}catch(Exception e){
System.out.println(e.getMessage());
}
            _bw.write(_wl_block12Bytes, _wl_block12);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.StandardInstruction.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
