package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __ipcanceltransfercriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPCancelTransferCriteria.jsp", 1732024536264L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--Created by Thamizh selvi on  29th Mar 2017 against GDOH-CRF-0124-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n";
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

    private final static java.lang.String  _wl_block7 ="\t\n\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eIP/js/IPCancelTransfer.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t    <Script>\n\t\t\tfunction validSplchars(obj)\n\t\t\t{\t\n\t\t\t\tvar val = obj.value.toUpperCase();\t\t\t\n\t\t\t\tobj.value = val;\t\n\t\t\t\tvar fields=new Array();\n\t\t\t\tvar names=new Array();\n\t\t\t\tfields[0]=obj;\n\t\t\t\tnames[0]=\"Patient ID\";\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(SpecialCharCheck( fields, names,\'\',\"A\",\'\'))\n\t\t\t\t\treturn true;\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction validatePatientId(obj) \n\t\t\t{\n\t\t\t\tvar patId = obj.value;\n\t\t\t\tif(parent.content !=null) {\n\t\t\t\t\tf = parent.content.frames[1];\n\t\t\t\t}else {\n\t\t\t\t\tf = parent.frames[1];\n\t\t\t\t}\n\n\t\t\t\tif(patId!=\"\"){ \n\t\t\t\t\tvar xmlDoc = \"\"\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\t\t\txmlStr =\"<root><SEARCH patientId=\\\"\"+patId+\"\\\" action=\'validatePatId\' /></root>\"\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\t\txmlHttp.open(\"POST\",\"../../eIP/jsp/IPintermediate.jsp\",false)\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\t\tif(responseText!=\"\"){\n\t\t\t\t\t\tvar msg = getMessage(\"INVALID_PATIENT\",\"MP\");\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\tparent.frames[2].location = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tasync function showLookUp(val)\n\t\t\t{\n\t\t\t\tif(val == \'P\')\n\t\t\t\t{\n\t\t\t\t\tvar patientid= await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');\n\t\t\t\t\tif(patientid != null)\n\t\t\t\t\tdocument.getElementById(\"patient_id\").value = patientid;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction submitPage()\n\t\t\t{\n\t\t\t\tif(document.forms[0].patient_id.value==\"\")\n\t\t\t\t{\n\t\t\t\t\tvar msg = getMessage(\"CAN_NOT_BE_BLANK\",\"common\");\n\t\t\t\t\tmsg = msg.replace(\'$\',getLabel(\"Common.patientId.label\",\"Common\"))\n\t\t\t\t\talert(msg);\n\t\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tvar condition=\"\";\n\t\t\t\tpatientId = document.forms[0].patient_id.value;\n\t\t\t\toper_stn = document.forms[0].operstn.value;\n\t\t\t\tparent.frames[2].location.href= \'../../eIP/jsp/IPCancelTransferResult.jsp?&patient_id=\'+patientId+\'&oper_stn_id=\'+oper_stn+\'\';\n\t\t\t\t\t\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\n\t\t\t}\n\t  </Script>\n </head>\n <body onLoad= \'FocusFirstElement()\' onSelect=\"codeArrestThruSelect()\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n <form name=\'CancelTransferForm\' id=\'CancelTransferForm\' action=\'\' target=\'result\' >\n\t<table cellspacing=0 cellpadding=0 width=\'100%\' border=\'0\' align=\'center\'>\n \t\t<tr>\n\t\t <td class=\'label\' width=\"5%\">&nbsp;</td>\n\t\t  <td class=\'label\' width=\"10%\">&nbsp;</td>\n\t\t  <td class=\'label\' width=\"20%\">&nbsp;</td>\n\t\t  <td class=\'label\' width=\"65%\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t  <td class=\'label\' width=\"5%\">&nbsp;</td>\n\t\t  <td class=\'label\' width=\"10%\">&nbsp;</td>\n\t\t  <td class=\'label\' width=\"20%\">&nbsp;</td>\n\t\t  <td class=\'label\' width=\"65%\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"5%\">&nbsp;</td>\n\t\t\t<td class=\'label\' width = \'10%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t<td width = \'20%\' class=\'fields\'><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' size=\'15\' name=\'patient_id\'  id=\'patient_id\'onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);if(validSplchars(this)) validatePatientId(this);\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\"><img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t\t\n\t\t\t<td class=\'fields\' width = \'65%\'><input type=\'button\' class=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onclick=\'submitPage()\'>\n\t\t\t\n\t\t\n\t\t</tr>\n\t\t\n\t\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\n </form>\n </body>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );


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
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection con	= null;
	try
	{
		String Patient_Id_Length	= "";
		String operstn			= checkForNull(request.getParameter("oper_stn_id"));
		String facilityID=(String)session.getValue("facility_id");

		con = ConnectionManager.getConnection(request);
		
		Patient_Id_Length = eCommon.Common.CommonBean.getPatIdLength(con);
		Patient_Id_Length = checkForNull(Patient_Id_Length,"0");

		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facilityID);



            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
}
catch(Exception e)	
{
	out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
