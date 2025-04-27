package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __textarea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/TextArea.jsp", 1709119374055L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n<script lanaguage=\'javascript\'>\n\tfunction windowClosing()\n\t{\n\n\t\t//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700\n\t\t//Added for Dentist Comments\n\t   \tif(document.forms[0].flagForPrint.value == \"Y\"){\n\t\t\tif((document.forms[0].txtCheck.value).length > 1000){\n\t\t\t\talert(getMessage(\"APP-OH000132\",\'OH\'));\n\t\t\t}\n\n\t\t\telse{\n\t\t\t\tvar formObj = document.forms[0];\n\t\t\t\t//var remarks = formObj.txtCheck.value;\n\t\t\t\t/*var dentist_comments =document.getElementById(\"remarks_txt\").value;\n\t\t\t\tdentist_comments = encodeURIComponent(dentist_comments);\n\t\t\t\tdentist_comments = encodeURIComponent(dentist_comments);\n\t\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\t\tvar chart_num = formObj.chart_num.value;  */\n\t\t\t\tvar dentist_comments =document.getElementById(\"remarks_txt\").value;\n\t\t\t\t//alert(dentist_comments)\n\t\t\t\tformObj.dentist_comments.value = encodeURIComponent(dentist_comments);\n\t\t\t\t\n\t\t\t\t var xmlDoc=\"\";\n\t\t\t\t var xmlHttp = new XMLHttpRequest();\n\t\t\t\t var arrObj = formObj.elements;\n\t\t\t\t var frmObjs = new Array()\n\t\t\t\t if(formObj.name == null){\n\t\t\t\t\tfrmObjs = formObj ;\n\t\t\t\t }\n\t\t\t\t else{\n\t\t\t\t\tfrmObjs[0] = formObj ;\n\t\t\t\t }\n\t\t\t\t var xmlStr =\"<root><SEARCH \";\n\t\t\t\t for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {\n\t\t\t\t\tformObj = frmObjs[frmCount];\n\t\t\t\t\tvar arrObj = formObj.elements;\n\t\t\t\t\tfor(var i=0;i<arrObj.length;i++) {\n\t\t\t\t\t\tval = arrObj[i].value;\n\t\t\t\t\t\t//alert(\"Name is ::\" + arrObj[i].name);\n\t\t\t\t\t\t//alert(\"Value is ::\" + val);\n\t\t\t\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\"){\n\t\t\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t//\t}\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t//alert(\"xmlStr ::: \" + xmlStr);\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t//beforePost(xmlStr) ;\n\t\t\txmlHttp.open(\"POST\", \"PrintChartValidation.jsp?func_mode=updateDentistComments\", false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tresponseText = xmlHttp.responseText;\n\t\t\t//alert(responseText);\n\t\t\twindow.close();\t\n\t\t\t//return xmlHttp.responseText  ;\n\t\t\t\t/*var xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&remarks=\"+dentist_comments;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"PrintChartValidation.jsp?func_mode=updateDentistComments&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar update_dentist_comments_retVal = localTrimString(xmlHttp.responseText);\t  \n\t\t\t\t//window.returnValue=update_dentist_comments_retVal; \n\t\t\t\t//window.returnValue=remarks;\n\t\t\t\twindow.close();\t   \n\t\t\t} */\n\t\t\t}\n\t\t}\n\t\t//\n\t\telse if((document.forms[0].txtCheck.value).length > 200){\n\t\t\talert(getMessage(\"APP-OH00014\",\'OH\'));\n\t\t}\n\t\telse{\n\t\t\tvar remarks = document.forms[0].txtCheck.value;\n\t\t\twindow.returnValue=remarks;\n\t\t\twindow.close();\n\t\t}\n\t}\n\n\tfunction setValue(){\n\t\t//var remarks = document.forms[0].txtCheck.value;\n\t\twindow.returnValue=\'CL_REM\';\n\t\twindow.close();\n\t}\n\n\t//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700\n\tfunction localTrimString(sInString) {\n\t  sInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n\t  return sInString.replace( /\\s+$/g, \"\" );// strip trailing\n\t}\n\n\tfunction displayRemarks(){\n\t\tif(document.forms[0].flagForPrint.value == \"Y\"){\n\t\t\tvar formObj = document.forms[0];\n\t\t\t\n\t\t\tvar patient_id = formObj.patient_id.value;\n\t\t\tvar chart_num = formObj.chart_num.value;\n\t\t\tvar oh_chart_level = formObj.oh_chart_level.value;\n\t\t\tvar other_chart_facility_id = formObj.other_chart_facility_id.value;\n\n\t\t\tvar remarks = \"\";\n\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\tvar params = \"patient_id=\"+patient_id+\"&chart_num=\"+chart_num+\"&oh_chart_level=\"+oh_chart_level+\"&other_chart_facility_id=\"+other_chart_facility_id;\n\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"DentalTrmtValidation.jsp?func_mode=getDentistComments&\"+params,false);\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tvar dentist_comments_retVal = localTrimString(xmlHttp.responseText);\n\n\t\t\tdentist_comments_retVal = trimString(dentist_comments_retVal);\n\t\t\tdentist_comments_retVal = encodeURIComponent(dentist_comments_retVal);\n\t\t\n\t\t\tformObj.remarks.value = decodeURIComponent(dentist_comments_retVal);\n\n\t\t\t// added on 01/03/2010 for DECODE dentistComments \n\n\t\t\t//var remarks = trimString(dentist_comments_retVal);\n\t\t\t//formObj.remarks.value = decodeURIComponent(remarks);\n\n\t\t\t//var res = checkSpl(formObj.remarks.value);\n\t\t\tif(formObj.remarks.value == \"null\" || formObj.remarks.value == null){\n\t\t\t\tdocument.getElementById(\"remarks_txt\").value = \"\";\n\t\t\t}\t\n\t\t\telse{\n\t\t\t\tdocument.getElementById(\"remarks_txt\").value = formObj.remarks.value;\n\t\t\t}\n\n\n\t\t\t//window.returnValue=update_dentist_comments_retVal; \n\t\t\t//window.returnValue = remarks;\n\t\t}\n\t}\n\n\tfunction replaceGreaterThan(){\n\t\t//var res = checkSpl(obj.value);\n\t\tvar result_remarks = document.getElementById(\"remarks_txt\").value;\n\t\tif(document.forms[0].flagForPrint.value == \"Y\"){\n\t\t\tdocument.getElementById(\"remarks_txt\").value = result_remarks.replace(/>/g,\"\"); \n\t\t}\n\t}\n\tfunction checkSpl( val ) {\n\t\tvar result = \"\" ;\n\t\tvar ch = \"\" ;\n\n\t\tvar indVal = 0;\n\t\twhile ( (indVal = val.indexOf(\'\\n\',indVal)) != -1 )\n\t\t{\n\t\t\tval = val.replace(\"\\n\",\"\\\"\")\n\t\t}\n\n\t\tvar spChars = new Array( \"<\", \">\", \"&\", \"\\\"\", \"\'\") ;\n\t\tvar chChars = new Array( \"&lt;\", \"&gt;\", \"&amp;\", \"&quot;\", \"&apos;\") ;\n\t\tfor(i=0; i<val.length; i++) {\n\t\t\tfor(j=0; j<spChars.length; j++) {\n\t\t\t\tif ( val.substring(i,i+1) == spChars[j] ) {\n\t\t\t\t\tch = chChars[j] ;\n\t\t\t\t\tj=spChars.length ;\n\t\t\t\t} else {\n\t\t\t\t\tch = val.substring(i,i+1) ;\n\t\t\t\t}\n\t\t\t}\n\t\t\tresult += ch ;\n\t\t}\n\t\treturn result ;\n\t}  \n\t//End\n\t\n/*\n\tfunction replaceQuote(){\n\t   var formObj = document.forms[0];\n\t   var str = formObj.remarks.value;\n\t   var repStr = str.replace(/\\\'/g,\"#\"); //s.replace(/\\./g, \"!\"); \n\t}\n\t*/\n\n\t\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<TITLE>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n</HEAD>\n\n<BODY class=\"MESSAGE\" OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onLoad=\"displayRemarks()\">\n<form>\n<table  cellspacing=\'0\'>\n<tr>\n\t<td>\n\t\t<!-- <textarea name=\'txtCheck\' rows=\'5\' cols=\'67\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="  onblur=\'return replaceGreaterThan(this)\' onBlur=\"makeValidString(this)\" id=\'remarks_txt\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </textarea> -->\n\t\t<textarea name=\'txtCheck\' rows=\'5\' cols=\'67\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  onBlur=\"makeValidString(this)\" id=\'remarks_txt\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </textarea>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'MESSAGE\' align=\'center\'>\n\t\t<!-- <input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onClick=\'replaceGreaterThan();windowClosing();\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="> -->\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\'windowClosing();\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\"setValue()\">\n\t\t\n</td>\n</tr>\n</table>\n\t<!--Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700\n\tAdded for Dentist Comments-->\n  <input type=\"hidden\" name=\'flagForPrint\' id=\'flagForPrint\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n  <input type=\"hidden\" name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n  <input type=\"hidden\" name=\'chart_num\' id=\'chart_num\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n  <input type=\"hidden\" name=\'oh_chart_level\' id=\'oh_chart_level\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n  <input type=\"hidden\" name=\'other_chart_facility_id\' id=\'other_chart_facility_id\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n  <input type=\"hidden\" name=\'remarks\' id=\'remarks\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" > \n  <input type=\"hidden\" name=\'dentist_comments\' id=\'dentist_comments\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" > \n  <input type=\"hidden\" name=\'asOnDate\' id=\'asOnDate\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" > \n   <!-- -->\n</form>\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block5Bytes, _wl_block5);
 
		String title=checkForNull(request.getParameter("heading"));
		String remarks=checkForNull(request.getParameter("remarks"));
		remarks = java.net.URLDecoder.decode(remarks,"UTF-8");
		if(remarks.equals("undefined") ){
			remarks = "";
		}
		String readOnly="";
		String disabled="";
		String readOnlyYN=checkForNull(request.getParameter("readOnlyYN"));
		if(readOnlyYN.equals("Y")){	   
			readOnly="readOnly";
			disabled = "disabled";
		}
		//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
		String flagForPrint = request.getParameter("flagForPrint"); //Dentist Comments
		String patient_id = request.getParameter("patient_id"); 
		String chart_num = request.getParameter("chart_num"); 
		String oh_chart_level = request.getParameter("oh_chart_level"); 
		String other_chart_facility_id = request.getParameter("other_chart_facility_id"); 
		String asOnDate = request.getParameter("asOnDate"); 
		String dentist_comments = request.getParameter("dentist_comments"); 
		//
		//remarks = remarks.replace(">","GRATERSIGN");
		//remarks = remarks.replace("<","LESSERSIGN");
		//StringBuffer comments = new StringBuffer();
		
		//comments.append(checkForNull(request.getParameter("remarks")));
		
	 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(title));
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(flagForPrint));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dentist_comments));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(asOnDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
