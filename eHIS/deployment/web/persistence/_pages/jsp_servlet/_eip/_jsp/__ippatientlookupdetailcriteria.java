package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __ippatientlookupdetailcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPPatientLookUpDetailCriteria.jsp", 1742387981407L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<script>\n\t\n\t\t\tfunction enableSearchby(obj)\n\t\t\t{\n\t\t\t\tif (obj.value==\'\')\n\t\t\t\t{\n\t\t\t\t\tif (document.forms[0].searchby)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].searchby.disabled=false;\n\t\t\t\t\t\tdocument.forms[0].searchby.value=\'S\';\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif (document.forms[0].searchby)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.forms[0].searchby.disabled=true;\n\t\t\t\t\t\tdocument.forms[0].searchby.value=\'\';\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t\tfunction validSplchars(obj)\n\t\t\t{\t\n\t\t\t\tvar val = obj.value.toUpperCase();\t\t\t\n\t\t\t\tobj.value = val;\t\n\t\t\t\tvar fields=new Array();\n\t\t\t\tvar names=new Array();\n\t\t\t\tfields[0]=obj;\n\t\t\t\tnames[0]=\"Patient ID\";\t\t\t\t\t\t\t\t\t\n\t\t\t\tif(SpecialCharCheck( fields, names,\'\',\"A\",\'\'))\n\t\t\t\t\treturn true;\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tobj.select();\n\t\t\t\t\tobj.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tasync function showLookUp(val)\n            {\n                if(val == \'P\')\n                {\n\t\t\t\t\tvar patientid=await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');\n\t\t\t\t\n\t\t\t\t\tif(patientid != null)\n                    \tdocument.getElementById(\'patient_id\').value = patientid;\n                }else if(val == \'GBMP\'){\n                \t// code added for GBM module - patient search\n                \t// in GBM module has more functionalities\n                \tvar patientId=await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'OTHER\');\n                \t// code modified to check if patient id obtained is valid\n        \t\t    // and then search patient search functionality is performed\n                    if(patientId){\n                    \tdocument.getElementById(\'patient_id\').value = patientId;\n                    \tvar facIdComp = document.getElementById(\"facId\");\n                    \tif(facIdComp){\n                    \t\tvar facId = facIdComp.value;\n                    \t\t//alert(facId);\n                    \t\tperformPatientSearch(patientId,facId);\n                    \t}else{\n                    \t\t//alert(\'Unable to highlight selected patient. Internal system error.\');\n                    \t}\n                    }else{\n                    \t//alert(\'Unable to retrieve selected patient id. Internal system error.\');\n                    }\n                }\n            }\n\n\t\t</script>\n\n\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' style=\'background-color:#3ca0b2;color:#FFFFFF\'  nowrap width = \'25%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\t\t\n\t\t\t\t<td width = \'25%\' class=\'fields\' style=\'background-color:#3ca0b2;color:#FFFFFF\'  nowrap><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' size=\'20\' name=\'patient_id\' id=\'patient_id\' size=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onkeyup=\"patientSrchKeyAction(event,this,\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\" onBlur=\"patientSrchBlurAction(this,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\"><input type=\"button\" class=BUTTON id=\"patient_search\" name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'GBMP\')\"></td>\n\t\t\t\t<td class=\'label\' style=\'background-color:#3ca0b2;color:#FFFFFF\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\' style=\'background-color:#3ca0b2;color:#FFFFFF\'>&nbsp;</td>\n\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\'  nowrap width = \'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\n\t\t\t\t<td width = \'25%\' class=\'fields\'  nowrap><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);validSplchars(this)\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\"></td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t<!-- <td class=\'label\'  width = \'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\n\t\t\t\t<td  width = \'25%\' class=\'fields\'  nowrap><select name=\'gender\' id=\'gender\'>\n\t\t\t\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" --- </option>\n\t\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t\t\t\t<option value=\'U\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td> -->\n\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\n\t\t\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width = \'25%\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td><td width = \'25%\' class=\'fields\'><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);validSplchars(this)\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\"></td>\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td class=\'label\' width = \'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);validSplchars(this)\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\"></td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\n\t\t\t\n\t\t\t\t<!-- <td  width = \'22%\' class=\'fields\'  nowrap><select name=\'gender\' id=\'gender\'><option value=\'\'>--- ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td> -->\n\t\t\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width =\'25%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td><td width =\'22.3%\' class=\'fields\'  ><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);validSplchars(this)\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\"></td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width =\'25%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td><td width =\'25%\' class=\'fields\'  ><input type=\'text\' maxlength=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);validSplchars(this)\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\"></td>\n\t\t\t\t\t<td class=\'label\'  width = \'25%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\n\t\t\t\t<td  width = \'25%\' class=\'fields\'  nowrap><select name=\'gender\' id=\'gender\'>\n\t\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td> \n\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<tr>\n\n\t\t\t\t<td class=\'label\'  width =\'25%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' size=\'20\' id=\'patient_id\' name=\'patient_id\' size=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onKeyPress=\'return(CheckForSpecChars(event))\' onBlur=\'ChangeUpperCase(this);validSplchars(this)\'><input type=\"button\" class=BUTTON name=\"patient_search\" id=\"patient_search\" value=\"?\" onClick=\"javascript:showLookUp(\'P\')\">\n\t\t\t\t\n\t\t\t\t<!--Added by Arthi on 31-Jan-2022 for GHL-CRF-0643-->\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'PatIdMand\'></img> \n                ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<!--End GHL-CRF-0643-->\n\t\t\t\t</td>\n\n\t\t\t\t\t<!-- sep-1-2008 enhancement of Pateient name Search -->\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\n\t\t\t\n\t\t\t\t<td class=\'label\' width = \'25%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\n\t\t\t\t<td class=\'fields\' width = \'25%\'>\n\t\t\t\t<input type=\'text\'  size=\'15\' name=\'patient_name\' id=\'patient_name\' >\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<!-- sep-1-2008 enhancement of Pateient name Search end -->\n\n\t\t\t\t<!-- <td class=\'label\'  width =\'25%\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\n\t\t\t\t<td  width = \'25%\' class=\'fields\'  nowrap><select name=\'gender\' id=\'gender\'>\n\t\t\t\t\t\t<option value=\'\'> --- ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td> -->\n\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\n\t\t\t</tr>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t</table>\n\t\t\t <input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t \n\t\t\t <!-- hidden component to store facility id - this is needed for GBM sub module-->\n\t\t\t <input type=\"hidden\" id=\"facId\" name=\"facId\" id=\"facId\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<!-- \n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'>\n\t\t\t\t\t\t<tr> -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n<!-- \t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr> -->\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<!-- \t\t\t\t\t</tr>\n\t\t\t\t</table>\n -->\n\t\t\t<script>\n\t\t\t\t//enableSearchby(document.forms[0].soundex);\n\t\t\t</script>\n\n\n\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
			String call_function	= request.getParameter("call_function");
				if(call_function == null) call_function= "";
			
			// code added to get the facility id from session
			// this is needed for ABM sub module in IP module
			// facility id is needed for patient search function
			String facility_id=(String) session.getValue("facility_id");
				
	 		Connection con = null;
			Statement stmt1 = null;
	 		Statement stmt2 = null;
	 		Statement stmt3 = null;

	 		ResultSet rs1 = null;
	 		ResultSet rs2 = null;
	 		ResultSet rs3 = null;

			//Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
	        Boolean isPatIdMandAppl =  false;

			try
			{
			con = ConnectionManager.getConnection(request);
			stmt1 = con.createStatement();
	 		stmt2 = con.createStatement();
	 		stmt3 = con.createStatement();
              
            //Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
		    isPatIdMandAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "MAKE_PAT_ID_MAND");

			String Patient_Id_Length =request.getParameter("patient_id_length");
			//Added by kumar on 18/03/2003 for Malaysia Enhancements
			String pat_name_as_multipart_yn = "";
			/*Wednesday, April 28, 2010 , commented for PE since values not used */
			/*
			sql = "Select First_Name_Accept_Yn, First_Name_Order, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn, patient_id_length, pat_name_as_multipart_yn, dflt_sndx_type  from mp_param" ;

			rs1 = stmt1.executeQuery(sql);
			if (rs1 != null)
			{
				while(rs1.next())
				{
					First_Name_Accept_Yn = checkForNull(rs1.getString(1));
					First_Name_Order = rs1.getInt(2);
					First_Name_Prompt = checkForNull(rs1.getString(3));
					Second_Name_Accept_Yn = checkForNull(rs1.getString(4));
					Second_Name_Order = rs1.getInt(5);
					Second_Name_Prompt = checkForNull(rs1.getString(6));
					Third_Name_Accept_Yn = checkForNull(rs1.getString(7));
					Third_Name_Order = rs1.getInt(8);
					Third_Name_Prompt = checkForNull(rs1.getString(9));
					Family_Name_Accept_Yn = checkForNull(rs1.getString(10));
					Family_Name_Order = rs1.getInt(11);
					Family_Name_Prompt = checkForNull(rs1.getString(12));

					Name_Suffix_Accept_Yn = checkForNull(rs1.getString(13));
					Name_Prefix_Accept_Yn = checkForNull(rs1.getString(14));
					Name_Suffix_Prompt = checkForNull(rs1.getString(15));
					Name_Prefix_Prompt = checkForNull(rs1.getString(16));


					First_Name_Reqd_Yn = checkForNull(rs1.getString(17));
					Second_Name_Reqd_Yn = checkForNull(rs1.getString(18));
					Third_Name_Reqd_Yn = checkForNull(rs1.getString(19));
					Family_Name_Reqd_Yn = checkForNull(rs1.getString(20));
					Name_Suffix_Reqd_Yn = checkForNull(rs1.getString(21));
					Name_Prefix_Reqd_Yn = checkForNull(rs1.getString(22));
					Patient_Id_Length = checkForNull(rs1.getString(23));
					pat_name_as_multipart_yn = checkForNull(rs1.getString(24));				
					if (pat_name_as_multipart_yn.equals("N"))
						family_name_length = "40";
					else
						family_name_length = "15";
					
					dflt_sndx_type = checkForNull(rs1.getString(25));

				}
				if(rs1!=null)	 rs1.close();
				if(stmt1!=null)	 stmt1.close();
			}
			*/
			/**/
		
            _bw.write(_wl_block6Bytes, _wl_block6);
if(call_function.equals("adv_bed_mgmt")){	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else if(call_function.equals("TransferPatientOut")){	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}else if(call_function.equals("QueryDischarge") || call_function.equals("AdminHist")){
            _bw.write(_wl_block21Bytes, _wl_block21);
if(!call_function.equals("AdminHist")) {
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block24Bytes, _wl_block24);
}else {
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
	}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
	if(call_function.equals("QueryCancelDischarge"))
				{
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
			else if(call_function.equals("ChangedAdmDtls")){
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
} else{ 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block41Bytes, _wl_block41);
 if(isPatIdMandAppl){ 
            _bw.write(_wl_block42Bytes, _wl_block42);
 } 
            _bw.write(_wl_block43Bytes, _wl_block43);
	if(call_function.equals("IPList"))
				{
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}
					else{
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
	if(call_function.equals("REG_NEWBORN_FOR_IP"))
				{	
					//out.println("<script>document.forms[0].gender.value='F';document.forms[0].gender.disabled=true</script>");
				}	
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
/*
								if ( Name_Prefix_Accept_Yn.equals("Y") )
								{
									out.println("<td  class='LABELLEFT'>&nbsp;&nbsp;"+Name_Prefix_Prompt+"</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) 
								{
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
									out.println("<td  class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
									out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
									out.println("<td class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
									out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}


								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
									out.println("<td  class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
										if(Third_Name_Prompt==null)
											Third_Name_Prompt = "&nbsp";
									out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
									out.println("<td  class='LABELLEFT'>"+ First_Name_Prompt + "</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
									out.println("<td  class='LABELLEFT'>" + Second_Name_Prompt + "</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
										if(Third_Name_Prompt==null)
											Third_Name_Prompt = "&nbsp";
										out.println("<td  class='LABELLEFT'>" + Third_Name_Prompt + "</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
									if(Family_Name_Prompt==null)
										Family_Name_Prompt = "&nbsp";
									out.println("<td  class='LABELLEFT'>" + Family_Name_Prompt + "</td>");
								}


								if ( Name_Suffix_Accept_Yn.equals("Y") )
									out.println("<td  class='LABELLEFT'>"+Name_Suffix_Prompt+"</td>");

							*/	
            _bw.write(_wl_block54Bytes, _wl_block54);
/*
								if ( Name_Prefix_Accept_Yn.equals("Y") )
								{
										out.println("<td align='Left'>&nbsp;&nbsp;<Select name='name_prefix' id='name_prefix' tabIndex='14'>");

										out.println("<Option value=''>---&nbsp"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp---</option>");

									sql="Select Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
									rs2 = stmt2.executeQuery(sql);
									if (rs2 != null)
									{
										while( rs2.next() ) {
											out.println("<Option value=\"" + checkForNull(rs2.getString("Name_Prefix")) + "\">" + checkForNull(rs2.getString("Name_Prefix"))+"</option>");
										}
									if(rs2!=null)	 rs2.close();
									if(stmt2!=null)	 stmt2.close();
									}
									out.println("</Select>");
									if (Name_Prefix_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
									}

								out.println("</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
								{
										out.println("<td align='Left' ><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

									if (First_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
								{
									out.println("<td align='left' ><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  onBlur=\"makeValidQueryCriteria(this);\" tabIndex='15'>");

									if (Second_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
									}

									out.println("</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
								{
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15'  tabIndex='15'>");


									if (Third_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
									}

									out.println("</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
								{
									out.println("<td  align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' tabIndex='15' onBlur=\"makeValidQueryCriteria(this);\">");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value=''  selected>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

									if ( Family_Name_Reqd_Yn.equals("Y") )
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
									}

									out.println("</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 )
								{
									out.println("<td  align='Left'><input type='text' name='first_name' id='first_name' maxlength='15' size='15'  tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

									if (First_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 )
								{
									out.println("<td  align='Left'><input type='text' name='second_name' id='second_name' maxlength='15' size='15'  tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

									if (Second_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
								{
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");

									if (Third_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
									}


									out.println("</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
								{
									out.println("<td align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"'  size='"+family_name_length+"' tabIndex='16' onBlur=\"makeValidQueryCriteria(this);\">");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value='' selected>--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

									if (Family_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y' ></input>");
									}
									else
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
								{
									out.println("<td  align='Left'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

									if (First_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
									}

									out.println("</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
								{
									out.println("<td  align='Left'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

									if (Second_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
								{
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");

									if (Third_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
									}


									out.println("</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
								{
									out.println("<td  align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='17'>");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value='' selected> --- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

									if (Family_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}

								if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
								{
									out.println("<td  align='Left'><input type='text' name='first_name' id='first_name' maxlength='15' size='15' onBlur=\"makeValidQueryCriteria(this);\" tabIndex='18'>");

									if (First_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}
								else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 )
								{
									out.println("<td  align='Left'><input type='text' name='second_name' id='second_name' maxlength='15' size='15' tabIndex='18' onBlur=\"makeValidQueryCriteria(this);\">");

									if (Second_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
									}


									out.println("</td>");
								}
								else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
								{
									out.println("<td  align='Left'><input type='text' name='third_name' id='third_name' maxlength='15' size='15' tabIndex='18' onBlur=\"makeValidQueryCriteria(this);\">");

									if (Third_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
									}

									out.println("</td>");
								}
								else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
								{
									out.println("<td  align='Left'><input type='text' name='family_name' id='family_name' maxlength='"+family_name_length+"' size='"+family_name_length+"' tabIndex='18' onBlur=\"makeValidQueryCriteria(this);\">");
									if (pat_name_as_multipart_yn.equals("N"))
										out.println("<select name='searchby' id='searchby' disabled><option value='' selected> --- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- </option><option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels")+"</option><option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels")+"</option></select>");

									if (Family_Name_Reqd_Yn.equals("Y")  )
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
									}
									out.println("</td>");
								}

								if ( Name_Suffix_Accept_Yn.equals("Y") )
								{
									out.println("<td  align='Left'><Select name='name_suffix' id='name_suffix' tabIndex='19'>");

									out.println("<Option value=''>&nbsp --- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- &nbsp</option>");

									sql="Select Name_Suffix from Mp_Name_Suffix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
									rs3 = stmt3.executeQuery(sql);
									if(rs3 != null ) {
										while(rs3.next()) {
											out.println("<Option value=\"" + checkForNull(rs3.getString("name_suffix")) + "\">" + checkForNull(rs3.getString("Name_Suffix"))+"</option>");
										}
									if(rs3!=null)	 rs3.close();
									if(stmt3!=null)	 stmt3.close();
									}
									if (Name_Suffix_Reqd_Yn.equals("Y")  )
									{
										out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y'></input>");
									}
									else
									{
										out.println("</select><input type='hidden' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='N'></input>");
									}

									out.println("</td>");
								} */
			}
			catch(Exception e)
			{
				out.println(e);
			}
			finally
			{ 
								
				if(stmt1!=null)	 stmt1.close();
				if(stmt2!=null)	 stmt2.close();
				if(stmt3!=null)	 stmt3.close();

				if(rs1!=null)	 rs1.close();
				if(rs2!=null)	 rs1.close();
				if(rs3!=null)	 rs3.close();

				if(con != null)
				ConnectionManager.returnConnection(con,request);				
			}
								
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }
}
