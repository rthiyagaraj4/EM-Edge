package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __disposalrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/DisposalRecord.jsp", 1709120208000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/CheckInOutRecoveryRoom.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\n<script language=\'javascript\'>\nfunction checkDuplicateCode(){\n\t    var formObj = parent.disposal_detail_frame.document.DisposalDetailForm;\n\t\tvar DisposalDetailCode =  formObj.code.value;\n\t\tvar disposal_code = document.DisposalRecordForm.disposal_code.value;\n\t\tvar anatomical_site_code = document.DisposalRecordForm.anatomical_site_code.value;\n\t\tvar DisposalRecordcode =  document.DisposalRecordForm.anatomical_site_code.value+document.DisposalRecordForm.disposal_code.value;\n\t\tif(chkEmpty()){\n\t\tvar k = DisposalDetailCode.indexOf(DisposalRecordcode);\n\t\t if(k>=0){\n\t\t\tvar message =  trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));//\'operations already selected\';\n\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+message\n\t\t\treturn k;\n\t\t} else\n\t\t\treturn 1; //returns one not alphabet \'l\'\n\t}\n\t\n}\n\nfunction chkEmpty(){\n\tvar formObj = document.forms[0]; \n\tvar fields = new Array(formObj.anatomical_site_code,formObj.disposal_code);\n\tvar disposalDetails_title=getLabel(\"eOT.DisposalDetails.Label\",\"OT\");\n\tvar disposal_title=getLabel(\"eOT.Disposal.Label\",\"OT\");\n\tvar names = new Array(disposalDetails_title,disposal_title);\n\tvar messageFrame = parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction resetFields()\n{\n\tvar frmObj = document.forms[0];\n\tfrmObj.anatomical_site_code.value=\'\';\n\tfrmObj.anatomical_site_desc.value=\'\';\n\tfrmObj.disposal_code.value=\'\';\n\tfrmObj.disposal_desc.value=\'\';\n\tfrmObj.given_by.value=\'\';\n\tfrmObj.received_by.value=\'\';\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.anatomicalLookUp.disabled=false;\n\tfrmObj.disposalLookUp.disabled=false;\n\tfrmObj.anatomicalLookUp.focus();\n}\n\nfunction splitString(resultString){\n \n    var arr = resultString.split(\'::\');\n\tvar frmObj = document.forms[0];\n\tfrmObj.anatomical_site_code.value=arr[0];\n\tfrmObj.anatomical_site_desc.value=arr[1];\n\tfrmObj.disposal_code.value=arr[2];\n\tfrmObj.disposal_desc.value=arr[3];\n\tfrmObj.given_by.value=arr[4];\n\tfrmObj.received_by.value=arr[5];\n\tfrmObj.recId.value=arr[6];\n\tfrmObj.mode.value=arr[7];\n\tfrmObj.anatomicalLookUp.disabled=true;\n\tfrmObj.disposalLookUp.disabled=false;\n\t//alert(frmObj.recId.value);\n}\n\n\n\nfunction cancelDisposalDtls()\n{\n\t//var bean_id   = document.getElementById(\"bean_id\").value;\n\t//var bean_name = document.getElementById(\"bean_name\").value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr += \"oper_num=\\\"\"+ document.getElementById(\"oper_num\").value + \"\\\" \";\n\txmlStr += \"slate_user_id=\\\"\"+ document.getElementById(\"slate_user_id\").value + \"\\\" \";\n\txmlStr += \"anatomical_site_code=\\\"\"+ document.getElementById(\"anatomical_site_code\").value + \"\\\" \";\n\txmlStr += \" anatomical_site_desc=\\\"\"+ document.getElementById(\"anatomical_site_desc\").value + \"\\\" \";\n\txmlStr += \"disposal_code=\\\"\"+ document.getElementById(\"disposal_code\").value + \"\\\" \";\n\txmlStr += \" disposal_desc=\\\"\"+ document.getElementById(\"disposal_desc\").value + \"\\\" \";\n\txmlStr += \"given_by=\\\"\"+ document.getElementById(\"given_by\").value + \"\\\" \";\n\txmlStr += \"received_by=\\\"\"+ document.getElementById(\"received_by\").value + \"\\\" \";\n\txmlStr +=\" /></root>\";\n\t//alert(xmlStr);\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\tvar mode=document.getElementById(\"mode\").value;\n\tvar recId=document.getElementById(\"recId\").value;\n\txmlHttp.open(\"POST\",\"ChkInOutRecoveryValidation.jsp?func_mode=cancelDisposalDtls&mode=\"+mode+\"&recId=\"+recId,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\n\tparent.disposal_detail_frame.location.href=\'../../eOT/jsp/DisposalDtls.jsp\';\n\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\tresetFields();\n}\n\nfunction funCheckDeletion(){\n\tfrmObj = document.DisposalRecordForm;\n\tvar mode = frmObj.mode.value;\n\tif(mode==\'I\'){\n\t\tfrmObj.anatomical_site_code.value=\'\';\n\t\tfrmObj.anatomical_site_desc.value=\'\';\n\t\tfrmObj.disposal_code.value=\'\';\n\t\tfrmObj.disposal_desc.value=\'\';\n\t\tfrmObj.given_by.value=\'\';\n\t\tfrmObj.received_by.value=\'\';\n\t} else \n\t\tcancelDisposalDtls()\n}\n\n\tfunction callRecordfunction(){\t\t\n\t\tvar mode = document.DisposalRecordForm.mode.value;\n\t\tif(mode==\'I\'){\n\t\t\tvar p = checkDuplicateCode();\n\t\t\tif(p==1) recordDisposalDtls();\n\t\t\treturn;\n\t\t}\n\t\trecordDisposalDtls();\n}\n\nfunction recordDisposalDtls(){\n\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr += \"oper_num=\\\"\"+ document.getElementById(\"oper_num\").value + \"\\\" \";\n\txmlStr += \"slate_user_id=\\\"\"+ document.getElementById(\"slate_user_id\").value + \"\\\" \";\n\txmlStr += \"anatomical_site_code=\\\"\"+ document.getElementById(\"anatomical_site_code\").value + \"\\\" \";\n\txmlStr += \"anatomical_site_desc=\\\"\"+ document.getElementById(\"anatomical_site_desc\").value + \"\\\" \";\n\txmlStr += \"disposal_code=\\\"\"+ document.getElementById(\"disposal_code\").value + \"\\\" \";\n\txmlStr += \"disposal_desc=\\\"\"+ document.getElementById(\"disposal_desc\").value + \"\\\" \";\n\txmlStr += \"given_by=\\\"\"+ document.getElementById(\"given_by\").value + \"\\\" \";\n\txmlStr += \"received_by=\\\"\"+ document.getElementById(\"received_by\").value + \"\\\" \";\n\txmlStr +=\" /></root>\";\n\t//alert(xmlStr);\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\tvar mode=document.getElementById(\"mode\").value;\n\tvar recId=document.getElementById(\"recId\").value;\n\txmlHttp.open(\"POST\",\"ChkInOutRecoveryValidation.jsp?func_mode=recordDisposalDtls&mode=\"+mode+\'&recId=\'+recId,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\n\t\n\tparent.disposal_detail_frame.location.href=\'../../eOT/jsp/DisposalDtls.jsp\';\n\tresetFields();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'DisposalRecordForm\' id=\'DisposalRecordForm\' action=\'\'>\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr> \n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td> \n\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t   <input type=\'hidden\' name=\'anatomical_site_code\' id=\'anatomical_site_code\'>\n\t   <input type=\'text\' name=\'anatomical_site_desc\' id=\'anatomical_site_desc\' size=\'30\'  value=\'\' >\n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'anatomicalLookUp\' id=\'anatomicalLookUp\' onClick=\'searchAnatomicalSite(anatomical_site_code,anatomical_site_desc);\' > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n </tr>\n\n<tr>\n\t<td class=\"label\" width=\"25%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td> \n\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t\t\t<input type=\'hidden\' name=\'disposal_code\' id=\'disposal_code\'>\n\t\t\t<input type=\'text\' name=\'disposal_desc\' id=\'disposal_desc\' size=\'30\'  value=\'\'  >\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'disposalLookUp\' id=\'disposalLookUp\' onClick=\'searchDisposal(disposal_code,disposal_desc);\' > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t</td> \n\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t\t<input type=\'text\' name=\'given_by\' id=\'given_by\' size=\'15\' maxlength=\'100\'>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\t\t\t\n\t</td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" \n\t</td> \n\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t\t<input type=\'text\' name=\'received_by\' id=\'received_by\' size=\'15\' maxlength=\'100\'>\t\t\t\n\t</td>\n</tr>\n<tr>\n\t<td class=\"fields\" width=\"25%\">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onClick=\'callRecordfunction();\' >\n\t</td>\n\t<td class=\"fields\" width=\"25%\" colspan=\"3\">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onClick=\'funCheckDeletion();\' >\n\t</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));

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

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slate_user_id));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DisposedItem.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Disposal.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.givenby.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedBy.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
