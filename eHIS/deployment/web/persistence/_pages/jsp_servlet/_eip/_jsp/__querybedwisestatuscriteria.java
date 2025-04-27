package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __querybedwisestatuscriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryBedWiseStatusCriteria.jsp", 1718186896981L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<script>\nfunction clearAll()\n{\n\tparent.result.location.href=\'../../eCommon/html/blank.html\';\n\tdocument.forms[0].search.disabled=false;\n}\t\n\nfunction submitPage()\n{\t\t\t\t\n\tvar fields=new Array();\n\tfields[0]= document.forms[0].nursing_unit_desc;\n\tfields[1]= document.forms[0].from_date;\n\tfields[2]= document.forms[0].to_date;\n\n\tvar names = new Array();\n\tnames[0]\t= getLabel(\"Common.nursingUnit.label\",\"Common\");\n\tnames[1]\t= getLabel(\"Common.DateFrom.label\",\"Common\")\n\tnames[2]\t= getLabel(\"Common.date.label\",\"Common\")+\" \"+getLabel(\"Common.to.label\",\"Common\");\n\t\n\tif(parent.criteria.checkFields( fields, names, parent.messageFrame))\n\t{\n\t\tvar condition=\"\";\n\t\tdocument.forms[0].search.disabled = true;\n\n\t\tfor(var i=0; i<document.forms[0].elements.length; i++)\n\t\t\tcondition+= document.forms[0].elements[i].name +\"=\"+ escape(document.forms[0].elements[i].value)+\"&\"\n\t\tparent.result.location.href= \"../jsp/QueryBedWiseStatusResult.jsp?\"+condition;\t\n\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t}else\n\t{\n\t\tdocument.forms[0].search.disabled = false;\n\t\tparent.result.location.href=\"../../eCommon/html/blank.html\";\n\t}\n}\n\nfunction beforeGetNursingUnit(target_id,target)\n{\n\tif(document.forms[0].nursing_unit_desc.value != document.forms[0].nursing_unit_hid.value)\n\t{\n\t\tif(document.forms[0].nursing_unit_desc.value != \"\")\n\t\t\tNursingUnitLookup(target_id,target)\n\t\telse\n\t\t\tdocument.forms[0].nursing_unit_code.value = \"\";\n\t}\n}\n\nasync function NursingUnitLookup(target_id,target)\n{\n\tvar facility_id = document.forms[0].facilityid.value;\n\tvar title = getLabel(\"Common.nursingUnit.label\",\"Common\");\n\tvar argumentArray = new Array(8);\n\tvar locale = document.forms[0].locale.value;\n\n\targumentArray[0]=\"select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = \'\"+locale+\"\' and EFF_STATUS like ? and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) \";\n\n\targumentArray[1]=new Array(\"EFF_STATUS\",\"facility_id\");\n\targumentArray[2]=new Array(\"E\",facility_id);\n\targumentArray[3]=new Array(STRING,STRING);\n\targumentArray[4]=\"3,4\";\n\targumentArray[5]=target.value;\n\targumentArray[6]=CODE_DESC_LINK;\n\targumentArray[7]=CODE_DESC;\n\t\t\n\tvar retVal = await CommonLookup(title,argumentArray);\n\t\tvar ret1=unescape(retVal);\n\t\t \tarr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) \n\t \t\t{\n\t\t \t\tarr[0]=\"\";\t\n\t\t \t\tarr[1]=\"\";\n                document.forms[0].nursing_unit_hid.value = \"\";\t\t\t\t\n\t \t\t}\n\n            else{\n\t\t\ttarget_id.value = arr[0]; \n\t\t\ttarget.value = arr[1];\n           document.forms[0].nursing_unit_hid.value = arr[1];\n\t\t\t}\t\t   \n\n}\n\n\nfunction DateCompare(from,to,localeName) \n{\n\tvar fromdate = from.value ;\n\tvar todate = to.value ;\n\t/*Tuesday, November 30, 2010 , SRR20056-SCF-6098 [IN:025257] , added to restrict date field from selecting back date*/\n\tvar dttm = getCurrentDate(\'DMY\' ,localeName);\n\tvar  frmDate1 = fromdate.substring(0,10);\n    var  toDate1 = todate.substring(0,10);\n\n\tif(frmDate1 != null && frmDate1 != \"\")\n\t{\n\t\tif(!isAfter((convertDate(frmDate1,\"DMY\",localeName,\"en\")),(convertDate(dttm,\"DMY\",localeName,\"en\")),\"DMY\",\'en\'))\n\t\t{\n\t\t\tvar msg = getMessage(\"DATE1_LT_DATE2\",\"IP\");\n\t\t\tmsg\t=\tmsg.replace(\"$\",getLabel(\"Common.DateFrom.label\",\"Common\"));\n\t\t\tmsg\t=\tmsg.replace(\"#\",getLabel(\"Common.SystemDate.label\",\"Common\"));\n\t\t\talert(msg);\n\t\t\tfrom.value = \"\";\n\t\t}\n\t}\n\tif(toDate1 != null  && toDate1 != \"\")\n\t{\n\t\tif(!isAfter((convertDate(toDate1,\"DMY\",localeName,\"en\")),(convertDate(dttm,\"DMY\",localeName,\"en\")),\"DMY\",\'en\'))\n\t\t{\n\t\t\tvar msg = getMessage(\"DATE1_LT_DATE2\",\"IP\");\n\t\t\tmsg\t=\tmsg.replace(\"$\",getLabel(\"Common.to.label\",\"Common\"));\n\t\t\tmsg\t=\tmsg.replace(\"#\",getLabel(\"Common.SystemDate.label\",\"Common\"));\n\t\t\talert(msg);\n\t\t\tto.value= \"\";\n\t\t}\n\t}\n\t/**/\n\tvar flg1 = validDateObj(from,\"DMYHM\",localeName);\n\tvar flg2 = validDateObj(to,\"DMYHM\",localeName);\n\tif(flg1 && flg2 )\n\t{\n\t\tvar greg_fromdate = convertDate(from.value,\"DMYHM\",localeName,\"en\");\n\t\tvar greg_todate = convertDate(to.value,\"DMYHM\",localeName,\"en\");\n\t\tif(!isBefore(greg_fromdate,greg_todate,\"DMYHM\",\'en\'))\n\t\t{\n\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\"));\n\t\t\tto.focus();\n\t\t\tto.select();\n\t\t}\t\n\t}\n\treturn true;\n}\n</script>\n\n<body  onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<form name=\'Criteria_Form\' id=\'Criteria_Form\' >\n\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' width=\'30%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;&nbsp;</td>\n\t\t\t\t<td><input type=text  name=\'nursing_unit_desc\' id=\'nursing_unit_desc\' size=\"15\" maxlength=\"15\" align=\"center\" onBlur=\"beforeGetNursingUnit(nursing_unit_code,nursing_unit_desc);\"><input type=\'button\' name=\'nursing_unit\' id=\'nursing_unit\' value=\'?\' class=\'button\' onclick=\'NursingUnitLookup(nursing_unit_code,nursing_unit_desc);\'><input type=\"hidden\" name=\'nursing_unit_code\' id=\'nursing_unit_code\' size=\"4\" maxlength=\"4\" align=\"center\" onBlur=\"return makeValidQueryCriteria(this);\"><input type=\"hidden\" name=\'nursing_unit_hid\' id=\'nursing_unit_hid\' value=\"\"><img align=\'center\' src=\'../../eMP/images/mandatory.gif\'></td>\n\t\t\t\t<td>&nbsp;</td><td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td class =\'fields\' nowrap><input type=\"text\" id=\"fromDateID\" name=\"from_date\" id=\"from_date\" size=16 maxlength=16 value=\"\" onblur=\"DateCompare(this,to_date,\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\') ;\"><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"from_date.focus();return showCalendar(\'fromDateID\',null,\'hh:mm\');\"/><img align=\'center\' src=\'../../eMP/images/mandatory.gif\'></td>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t<td class =\'fields\' nowrap><input type=\"text\"  name=\"to_date\" id=\"to_date\" size=16 maxlength=16 value=\"\" onblur=\"DateCompare(from_date,this,\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\"><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"to_date.focus();return showCalendar(\'to_date\',null,\'hh:mm\');\"/><img align=\'center\' src=\'../../eMP/images/mandatory.gif\'></td>\n\t\t\t</tr>  \n\t\t</table>\n\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t<td align=\'right\' class=\'white\'><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' class=\'button\' onclick=\"clearAll()\"></td>\n\t\t\t\t<input type=hidden name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t<input type=hidden name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t</tr>\t\t\t\t\n\t\t</table>\n\t</form>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	String facilityid = (String)session.getValue("facility_id");
	String locale	  = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateFrom.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
