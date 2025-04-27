package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __administerdataprocessserverr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/AdministerDataProcessServErr.jsp", 1743588580366L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HEAD> \n<title>Server Errors</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\t\t\t\t\t\t    \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\t\t\t   \n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/AdministerReviewCommunicationProcess.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<Script>\t\t\t\t\t\t\t\t\t\t\t\t  \n\n/** Added for Date Validation **/\n\nfunction ValidateDateTimesp(obj)\n{\n/*\talert(obj.value);\n\tif(!(obj.value==\"\"))\n\t{\n\t\tif(validDateObj(obj,\"DMYHM\",localeName))\n\t\t{\n\t\t\tif(!(isBeforeNow(obj.value,\"DMYHM\",localeName)))\n\t\t\t{\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\tobj.value=\'\';\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\talert(getMessage(\'DT_NLT_CURR_DT\',\'SM\'));\n\t\t\t}\n\t\t}\n\t}\t\n*/\n}\n  function isAfterCurrDate(obj)\n{\n\t/*var date = obj.value.split(\" \");\n\tvar chk_out_date=date[0];\n\tvar chk_out_time=date[1];\n\t\t\tvar locale = document.getElementById(\"locale\").value;\n\t\n\t\t\t\tvar formObj=document.forms[0];\n\n\t\tif(!isAfter(chk_out_date,chk_out_time,\"DMYHM\",locale)){\n\t\t\t\t\tvar msg_1 = getMessage(\"DATE1_NOT_LESSER_THAN_DATE2\",\"OT\");\n\t\t\t\t\tvar msgArr = msg_1.split(\"#\");\n\t\t\t\t\tvar checkin_time = getLabel(\"eOT.CheckedInDateTime.Label\",\"OT\");\n\t\t\t\t\tvar chk_out_dt_time =getLabel(\"eOT.CheckedOutDateTime.Label\",\"OT\");\n\t\t\t\t\talert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);\t\t\t\t\t\t\t\t\n\t\t\t\t\t obj.value=\"\";\n\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t return false;\n\t\t\t}else if(isBeforeNow(chk_out_date,\'DMYHM\',locale)){\n\t\t\t\t\t\treturn true;\n\t\t\t\t}else{\n\t\t\t\t\tvar msg_1 = getMessage(\"DATE1_NOT_GREATER_THAN_DATE2\",\"OT\");\n\t\t\t\t\tvar msgArr = msg_1.split(\"#\");\n\t\t\t\t\tvar checkin_time = getLabel(\"eOT.CheckedOutDateTime.Label\",\"OT\");\n\t\t\t\t\tvar systemdatetime =getLabel(\"Common.SystemDateTime.label\",\"Common\");\n\t\t\t\t\talert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);\n\t\t\t\t\tobj.value=\"\";;\n\t\t\t\t\t\n\t\t\t\t}\t\t   */\n\n\n\n\n\n\n\n\tvar date = obj.value;\n\tvar locale = document.getElementById(\"locale\").value;\t\n\n\tif(isValidDate(obj) && date.length > 0 )\n\t{\n\t\tif(!isBeforeNow(date,\'DMYHM\',locale))\t\t\t\t\t\t\t    \n\t\t{\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\talert(getMessage(\"XH1010\",\'XH\'));\n\t\t\tobj.value = \"\";\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\t\t\t\t\t\t\t\t\t   \n\t\telse\n\t\t{\n\t\t\tif(!compareDates())\n\t\t\t{\n\t\t\t\tobj.value = \"\";\n\t\t\t\tobj.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\t\n}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \nfunction compareDates()\n{\n\tlocale = document.getElementById(\"locale\").value;\n\tmsg_dt1 = document.forms[0].fromDate.value;\n\tmsg_dt2 = document.forms[0].toDate.value;\n\n\tif(msg_dt1.length > 0 && msg_dt2.length > 0)\n\t{\n\t\tif(!isBefore(msg_dt1,msg_dt2,\'DMYHM\',locale))\n\t\t{\n\t\t\talert(getMessage(\"XH1009\",\'XH\'));\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n} \n  function isValidDate(obj)\n{\t\n\tvar date = obj.value;\n\tvar locale = document.getElementById(\"locale\").value;\n\n\tif(date.length > 0 )\t\t \n\t{\n\t\tif(!validDate(date,\'DMYHM\',locale))\n\t\t{\n\t\t\tvar msg = getMessage(\"INVALID_VALUE\",\'COMMON\');\n\t\t\tmsg = msg.replace(\'#\',\'Date Format\');\n\t\t\talert(msg);\n\n\t\t\tobj.value = \"\";\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\t\t\t\t\t\t\t \t\t   \n} \n\nfunction showExcelProcess(flag,obj,action)\n{\t\t\n\n\t var flagch=true;\n\tif(action==\"purge\")\n\t{\n\n\t\t\tvar i=window.confirm(getMessage(\"DELETE_RECORD\",\"common\"));\n\t\t\tif(i==true)\n\t\t\t{\n\t\t\t\tflagch=true;\n\t\t\t}\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\telse\n\t\t\t{\n\t\t\t    flagch=false;\t\t\t\t\t\t\t \t\t\t  \n\t\t\t}\n\t}\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t if(flagch)\n\t{\n\t\tthis.document.forms[0].method = \'POST\';\t\t\t\t\t    \n\t\tthis.document.forms[0].target=\"\";\t\t\t\t\t \n\t\tthis.document.forms[0].action=\'../../servlet/eXH.AdminOraJobExcepToXLServlet?flag=\'+flag+\'&proc_id=\'+obj+\'&action=\'+action+\'&rule=I\';  \n\t\tthis.document.forms[0].submit();   \n\t}\n}\t\t\t\t\t\t\t\t\t\t       \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\nfunction searchErrors()\n{\t\t\t\n\t//alert(this.document.forms[0].proc_date.value);\t\t\t\n\tvar fromDate = this.document.forms[0].fromDate.value;\n\tvar toDate = this.document.forms[0].toDate.value;\n\tvar proc_id = this.document.forms[0].proc_id.value;\n\tvar facilityID = this.document.forms[0].facilityID.value;\t\t    \n\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr = \"<root><SEARCH \";\n\txmlStr += \" fromDate=\\\"\"+fromDate+\"\\\"\";\n\txmlStr += \" toDate=\\\"\"+toDate+\"\\\"\";\n\txmlStr += \" proc_id=\\\"\"+proc_id+\"\\\"\";\n\txmlStr += \" facilityID=\\\"\"+facilityID+\"\\\"\";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"AdministerDataProcessGetServerErr.jsp\",false);\n\txmlHttp.send(xmlDoc);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\n//\talert(xmlHttp.responseText);\n\teval(xmlHttp.responseText);\t\t\n}\n\n</script>\n\n</HEAD>\n\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"AdminDataProc_ServErr\" id=\"AdminDataProc_ServErr\" target=\'\' method=\'post\'> \n\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t\t\t\t \n<tr>\n\t<td class=label>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=fields><input type=\'text\' id=\'facilityID\' name=\'facilityID\' id=\'facilityID\' value=\'\'/>\t\t\t\t\t \n\t<td class=label>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\t\n\t<td class=fields>\n\t<input type=text id=\'fromDate\' name=fromDate  size=19 maxlength=19 onBlur=\'isAfterCurrDate(this);\'> <input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'fromDate\',null,\'hh:mm\')\" >\n\t \t \n\t<td class=label>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t \n\t<td class=fields>\n\t<input type=text id=\'toDate\' name= toDate  size=19 maxlength=19 onBlur=\'isAfterCurrDate(this);\'> \n\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'toDate\',null,\'hh:mm\')\">\n\t\n \t\t  \n\t<td colspan=2><input class=\"button\" type=\"button\" name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onClick=\"showExcelProcess(\'Y\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'result\');\"></td>\n\t<td colspan=2><input class=\"button\" type=\"button\" name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'purge\');\"></td>\n</tr>\t\t\t\t\t\t\t\t\t  \n<!-- \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<tr>\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t<td colspan=7>\n\t\t<textarea name=err_msg rows=22 cols=120 readOnly>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</textarea>\t\n\t</td>\n</tr>\n\n -->\n</table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input TYPE=\"hidden\" name=\"proc_id\" id=\"proc_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input TYPE=\"hidden\" name=\"rule\" id=\"rule\" value=\"I\">\n</form>\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
	
	String locale = ((String)session.getAttribute("LOCALE"));		  
	String procID = XHDBAdapter.checkNull((String)request.getParameter("proc_id"));
	String errMsg = XHDBAdapter.checkNull((String)request.getParameter("err_msg"));

	//System.out.println("(AdministerDataProcessServErr.jsp) procID : "+procID);
	//System.out.println("(AdministerDataProcessServErr.jsp) errMsg : "+errMsg);		  

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(procID));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(procID));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(errMsg));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(procID));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ServerError.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.WriteToXls.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Purge.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
