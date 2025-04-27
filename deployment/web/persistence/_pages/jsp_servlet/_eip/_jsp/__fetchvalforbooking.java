package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __fetchvalforbooking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FetchValForBooking.jsp", 1742379083943L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n\n<body class=\'message\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\tvar len=parent.document.frames[1].document.frames[2].document.forms[0].source.length;\n\t\t\tvar i=1;\n\t\t\twhile(i<len)\n\t\t\t{\n\t\t\t\tlen=parent.document.frames[1].document.frames[2].document.forms[0].source.length;\n\t\t\t\tparent.document.frames[1].document.frames[2].document.forms[0].source.remove(i);\n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\tvar temp =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\tvar opt=parent.document.frames[1].document.frames[2].document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tvar comp=parent.document.frames[1].document.frames[2].document.forms[0].source;\n\t\t\tcomp.add(opt)\n\t\t</script>\n     ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tvar comp=parent.document.frames[1].document.forms[0].source;\n\t\t\tcomp.add(opt)\n\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\tvar opt=parent.document.frames[1].document.frames[2].document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tvar comp=parent.document.frames[1].document.frames[2].document.forms[0].source;\n\t\t\tcomp.add(opt)\n\t\t</script>\n\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tvar comp=parent.document.frames[1].document.forms[0].source;\n\t\t\tcomp.add(opt)\n\t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<script>\n\t\t\t\tvar temp1 =\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\tvar temp=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\tvar opt=parent.document.frames[1].document.frames[2].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tvar comp=parent.document.frames[1].document.frames[2].document.forms[0].source;\n\t\t\t\tcomp.add(opt)\n\t</script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<script>\n\t\t\tvar temp1 =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\tvar temp=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\t\tvar len=parent.document.frames[1].document.frames[2].document.forms[0].practitioner.length;\n\t\t\tvar i=1;\n\t\t\twhile(i<len)\n\t\t\t{\n\t\t\t\tlen=parent.document.frames[1].document.frames[2].document.forms[0].practitioner.length;\n\t\t\t\tparent.document.frames[1].document.frames[2].document.forms[0].practitioner.remove(i);\n\t\t\t}\n\t\t</script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<script>\n\t\n\tvar len=parent.document.frames[1].document.forms[0].practitioner.length;\n\t\tvar i=1;\n\t\twhile(i<len)\n\t\t{\n\t\t\tlen=parent.document.frames[1].document.forms[0].practitioner.length;\n\t\t\tparent.document.frames[1].document.forms[0].practitioner.remove(i);\n\t\t}\n\t</script>\n\t\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<script>\n\t\t\t\tvar temp1 =\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\tvar opt=parent.document.frames[1].document.frames[2].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tvar comp=parent.document.frames[1].document.frames[2].document.forms[0].practitioner;\n\t\t\t\tcomp.add(opt)\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tvar comp=parent.document.frames[1].document.forms[0].practitioner;\n\t\t\tcomp.add(opt)\n\t\t\t</script>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<script>\n\t\t\tparent.document.frames[1].document.frames[2].document.getElementById(\'pract_type\').innerText=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\t\tparent.document.frames[1].document.getElementById(\'pract_type\').innerText=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\'CANNOT_EXCEED_MAX_SEQ_NO\',\'IP\'));\n\t\t\t\t/* parent.frames[1].document.forms[0].med_service_grp.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].med_service_grp.focus(); */\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\"med_service_grp\").value=\'\';\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\"med_service_grp\").focus();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'CANNOT_EXCEED_MAX_DLY_BKG\',\'IP\'));\n\t\t\t\t/* parent.frames[1].document.forms[0].med_service_grp.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].med_service_grp.focus(); */\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\"med_service_grp\").value=\'\';\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\"med_service_grp\").focus();\n\t\t\t\t</script>\n\t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<script>alert(getMessage(\'CANNOT_EXCEED_MAX_MONTHLY_BKG\',\'IP\'));\n\t\t\t\t/* parent.frames[1].document.forms[0].med_service_grp.value=\'\';\n\t\t\t\tparent.frames[1].document.forms[0].med_service_grp.focus(); */\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\"med_service_grp\").value=\'\';\n\t\t\t\tparent.f_query_add_mod.document.getElementById(\"med_service_grp\").focus();\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="              <script>\n            \t\t/* parent.document.frames[1].document.forms[0].booking_ref_no.value=\"\";\n            \t\tparent.document.frames[1].document.forms[0].booking_ref_no.disabled=true; */\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\"booking_ref_no\").value=\"\";\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\"booking_ref_no\").disabled=true;\n            \t</script>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t<script>\n\t\t\t\t\t/* parent.document.frames[1].document.forms[0].booking_ref_no.value=\"\";\n\t\t\t\t\tparent.document.frames[1].document.forms[0].booking_ref_no.disabled=false; */\t\n\t\t\t\t\t\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\"booking_ref_no\").value=\"\";\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\"booking_ref_no\").disabled=false;\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="              <script>\t\t\t\t\t\t\n\n\t\t\talert(getMessage(\"PREFER_DATE_LT_EXCEEDED\",\'IP\'));\n\n\t\t\tif(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'==\'Y\')\n\t\t\t {\n\t\t\t\tparent.document.frames[1].document.forms[0].pref_adm_date.value = \"\";\n\t\t\t\tparent.document.frames[1].document.getElementById(\'DayVal\').innerHTML = \"\";\n\t\t\t\tparent.document.frames[1].setDateValuesForOTFUnc();\n\t\t\t }\n\t\t\t else\n\t\t\t {\n\t\t\t\tparent.document.frames[1].document.forms[0].pref_adm_date.focus();\t\n\t\t\t\tparent.document.frames[1].document.forms[0].pref_adm_date.value = \"\";\n\t\t\t\tparent.document.frames[1].document.getElementById(\'DayVal\').innerHTML = \"\";\n\t\t\t }\n\t\t</script>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="              <script>                       \n\t\t\tvar spl = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].room_no.value = \'\';\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].room_no.value = \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\t\n\t\t\tif(spl != parent.document.frames[1].document.forms[0].Splcode.value)\n\t\t\t{\n\t\t\tparent.document.frames[1].document.forms[0].Splcode_desc.value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].Splcode.value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].practid_desc.value = \"\";\n\t\t\tparent.document.frames[1].document.forms[0].practid.value = \"\";\n\t\t\t}\n\t\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<script>\t\t\t\n\talert(getMessage(\"INVALID_BED\",\"Common\"));\n\tparent.document.frames[1].document.forms[0].bed_no.value = \'\';\n\tparent.document.frames[1].document.forms[0].room_no.value = \'\';\n\t\n\t</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="              \n\t<script>                       \n            parent.parent.document.frames[1].document.forms[0].room_no.value = \'\';\t\t\t\n\t\t\tparent.document.frames[1].document.forms[0].room_no.value = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\t\n\t\t\tparent.document.frames[1].document.forms[0].bed_class_code.value = \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\tparent.document.frames[1].document.forms[0].nursing_unit.value = \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\';\n\t\t\tparent.document.frames[1].document.forms[0].nursing_unit_desc.value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].override.disabled = false;\n\t\t\t//parent.frames[1].document.forms[0].pract_img.style.visibility=\"visible\";\n\t\t</script>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<script>\n\talert(getMessage(\"INVALID_BED\",\"IP\"));\n\tparent.document.frames[1].document.forms[0].bed_no.value = \'\';\n\tparent.document.frames[1].document.forms[0].room_no.value = \'\';\n\tparent.document.frames[1].document.forms[0].bed_class_code.value = \'\';\n\tparent.document.frames[1].document.forms[0].nursing_unit.value = \'\';\n\tparent.document.frames[1].document.forms[0].nursing_unit_desc.value = \'\';\n\tparent.document.frames[1].document.forms[0].bed_no.focus();\n\t</script>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\';\t\n\t\t\tparent.document.frames[1].document.forms[0].Bedcode.value = \'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\tparent.document.frames[1].document.forms[0].override.disabled = false;\n\t\t\tparent.frames[1].document.forms[0].pract_img.style.visibility=\"visible\";\n\t\t</script>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t<script>\n\talert(getMessage(\"INVALID_BED\",\"IP\"));\n\tparent.document.frames[1].document.forms[0].bed_no.value = \'\';\n\tparent.document.frames[1].document.forms[0].room_no.value = \'\';\n\tparent.document.frames[1].document.forms[0].Bedcode.value = \'\';\n\tparent.document.frames[1].document.forms[0].nursing_unit.value = \'\';\n\tparent.document.frames[1].document.forms[0].nursing_unit_desc.value = \'\';\n\tparent.document.frames[1].document.forms[0].bed_no.focus();\n\t</script>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n\t\n\t<script>\n\t       \n\t    var errval = \'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\t        \n\t\tvar confVal = window.confirm(errval);\n\t\tif (confVal) \n\t\t\twindow.alert(getMessage(\"WELCOME\",\'Common\'));\n\t\telse  \n\t\t\twindow.alert(\"Bye for now!\");\n\t</script>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	String			facilityid	= (String)session.getValue("facility_id");
	Connection		con			= null;
	Statement		stmt		= null;
	ResultSet		rs			= null;
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String source_type  = checkForNull(request.getParameter("source_type"));
		String pract_name   = checkForNull(request.getParameter("pract_name"));
		String pract		= checkForNull(request.getParameter("pract"));
		String param		= checkForNull(request.getParameter("param"));
		String isOTFunc		= checkForNull(request.getParameter("isOTFunc"));
		String facility_name	= "";
		String facility_id		= "";
		String short_desc		= "";
		String clinic_code		= "";
		String short_name		= "";
		String referral_code	= "";
		String practitioner_name= "";
		String practitioner_id	= "";
		String pract_type_desc	= "";
	


            _bw.write(_wl_block8Bytes, _wl_block8);
 
	if(param.equals("msg"))
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	
if(source_type.equals("ZF"))
{	stmt = con.createStatement() ;
	String sql=" Select facility_name,facility_id from SM_FACILITY_PARAM_LANG_VW where language_id = '"+locale+"' and facility_id !='"+facilityid+"'  order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	facility_name=rs.getString("facility_name");
	facility_id=rs.getString("facility_id");
	if(param.equals("msg"))
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
}
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

} // end of source_type.equals("ZF")
if(source_type.equals("OP"))
{
	stmt = con.createStatement() ;
	String sql=" select short_desc, clinic_code from OP_CLINIC where facility_id='"+facilityid+"'  and clinic_type='C' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	short_desc=rs.getString("short_desc");
	clinic_code=rs.getString("clinic_code");
	if(param.equals("msg"))
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
		else
		{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
} // end of source_type.equals("OP")
if(source_type.equals("XF"))
{stmt = con.createStatement() ;
	String sql="Select short_desc, referral_code from AM_REFERRAL_LANG_VW where language_id = '"+locale+"' and eff_status ='E' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	short_name=rs.getString("short_desc");
	referral_code=rs.getString("referral_code");
	if(param.equals("msg"))
	{
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(short_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(referral_code));
            _bw.write(_wl_block18Bytes, _wl_block18);

	}else
	{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(short_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(referral_code));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

}
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

}


if(pract_name.length() > 1)
{
		if(param.equals("msg"))
		{
		
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
		else
		{
	
            _bw.write(_wl_block22Bytes, _wl_block22);
 }

	
	String source	 = checkForNull(request.getParameter("source"));
		
	if(source.equals("ZF"))
	{stmt = con.createStatement() ;
	String sql=" Select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name, practitioner_id from AM_PRACT_FOR_FACILITY where FACILITY_ID='"+pract_name+"' and eff_status ='E' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	practitioner_name=rs.getString("practitioner_name");
	practitioner_id=rs.getString("practitioner_id");
	if(param.equals("msg"))
	{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	else
	{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
}

	if(source.equals("OP"))
	{stmt = con.createStatement() ;
	String sql=" select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name, practitioner_id from AM_PRACT_FOR_FACILITY where facility_id='"+facilityid+"' and eff_status ='E' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	practitioner_name=rs.getString("practitioner_name");
	practitioner_id=rs.getString("practitioner_id");
	if(param.equals("msg"))
	{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
	else
	{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	}
		if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

}


}

	if(pract.length()>1)
	{stmt = con.createStatement() ;
	String sql=" Select AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+locale+"','1') pract_type_desc from AM_PRACT_FOR_FACILITY_VW where practitioner_id='"+pract+"' ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	pract_type_desc=rs.getString("pract_type_desc");
	}
		if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

		if(param.equals("msg"))
		{
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);

}
else
{

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
}
 /*** Disabling the Bed Ref number ***/
 if(source_type.equals("VAL_MED_GRP"))
 { 
   String med_service_grp = request.getParameter("med_service_grp");
   String pref_adm_date = request.getParameter("pref_adm_date").trim();
  
  if(med_service_grp != null && pref_adm_date != null && pref_adm_date.length()>0)
   {   
	   
	    int tot_daily = 99999;
		int tot_monthly = 99999;
		int max_daily = 99999;
		int max_monthly = 99999;
		StringBuffer cntSql = new StringBuffer();
		cntSql.append(" SELECT COUNT(*) tot_daily FROM IP_BOOKING_LIST WHERE ");
		/*Tuesday, April 20, 2010 , modified for Create Booking query tuining*/
		//cntSql.append(" TRUNC(preferred_date) = TRUNC(to_date(?,'dd/mm/rrrr hh24:mi')) ");
		cntSql.append(" preferred_date BETWEEN TRUNC(TO_DATE(?, 'dd/mm/rrrr hh24:mi')) AND TRUNC(TO_DATE(?, 'dd/mm/rrrr hh24:mi')) +0.9999");
		cntSql.append(" and facility_id=?  and med_ser_grp_code=?");
		cntSql.append(" and booking_status != '9'");
		PreparedStatement pstmt = con.prepareStatement(cntSql.toString());
		pstmt.setString(1,pref_adm_date);
		pstmt.setString(2,pref_adm_date);
		pstmt.setString(3,facilityid);
		pstmt.setString(4,med_service_grp);
		rs = pstmt.executeQuery();
		if(rs.next())
	    {
			tot_daily = rs.getInt("tot_daily");
	    }
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		StringBuffer monCount = new StringBuffer();
		monCount.append(" SELECT COUNT(*) tot_monthly FROM IP_BOOKING_LIST ");
		monCount.append(" WHERE TO_CHAR(to_date(?,'dd/mm/rrrr hh24:mi'),'mm/rrrr') = TO_CHAR(PREFERRED_DATE,'mm/rrrr')");
		monCount.append(" and facility_id=? and med_ser_grp_code=?  and booking_status != '9'");
	
		pstmt = con.prepareStatement(monCount.toString()); 
		pstmt.setString(1,pref_adm_date);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,med_service_grp);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			tot_monthly = rs.getInt("tot_monthly");
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		StringBuffer maxBook	= new StringBuffer();
		maxBook.append(" select generate_num_yn, max_no_of_dly_booking,");
		maxBook.append(" max_no_of_mthly_booking, next_seq_no,  max_seq_no ");
		maxBook.append(" from IP_MEDICAL_SERVICE_GROUP where facility_id='"+facilityid+"'");
		maxBook.append(" and med_ser_grp_code='"+med_service_grp+"'  order by 1");
	
		pstmt = con.prepareStatement(maxBook.toString());
        rs = pstmt.executeQuery();
        String str1 = "";
		long max_seq_no = 0;
		long next_seq_no = 0;
        if( rs != null )
        {
          while(rs.next())
          {
            str1		= rs.getString(1);
			max_daily	= rs.getInt("max_no_of_dly_booking");
			max_monthly = rs.getInt("max_no_of_mthly_booking");
			next_seq_no = rs.getLong("next_seq_no");
			max_seq_no	= rs.getLong("max_seq_no");

			if(str1.equals("Y") && next_seq_no > max_seq_no) 
			{	
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
			else if(max_daily!=0 && tot_daily!=0 &&  tot_daily>=max_daily)
		    {	
            _bw.write(_wl_block30Bytes, _wl_block30);
   }
			else if(max_monthly!=0 && tot_monthly!=0 && tot_monthly>=max_monthly )
			{	
            _bw.write(_wl_block31Bytes, _wl_block31);
	}

            if (str1.equals("Y"))
            {           

            _bw.write(_wl_block32Bytes, _wl_block32);
           	
            }
            else
            {

            _bw.write(_wl_block33Bytes, _wl_block33);
			}
		}
	}
        pstmt.close();   
		rs.close();
	}
}
   
/*** Pref Admission Date, AM/PM Validation ***/
if(source_type.equals("VAL_DATE"))
{
	
   String pref_adm_date = request.getParameter("pref_adm_date").trim();
  
   if(pref_adm_date != null && pref_adm_date.length()>0)
   {     
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" SELECT sign(( sysdate+nvl(adv_bed_book_period_bkg,0)-(trunc(to_date('"+pref_adm_date+"','dd/mm/rrrr hh24:mi'))))) as valid_flag from IP_PARAM where facility_id = '"+facilityid+"' ");



        PreparedStatement pstmt = con.prepareStatement(sql1.toString());        
        rs = pstmt.executeQuery();
        int str1=0;       
 	if( rs != null )
	{
	  while(rs.next())
	  {	
	    str1 = rs.getInt(1);       
	   
	    if (str1 < 0)
	     {           

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(isOTFunc));
            _bw.write(_wl_block35Bytes, _wl_block35);
           }
	  }
	}
	pstmt.close(); 
	rs.close();
   }

}
/**Population of Room Number based on the value of Bed number **/
if(source_type.equals("VAL_ROOM_NO"))
{

   String bed_no = request.getParameter("bed_no");   
   String nursingunitcode = request.getParameter("nursunitcode");   
      
   if(bed_no != null)
   {      
		StringBuffer sql1 = new StringBuffer();
		sql1.append( " select room_no, specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc from IP_NURSING_UNIT_BED where facility_id = '"+facilityid+"' AND NURSING_UNIT_CODE='"+nursingunitcode+"' AND BED_NO= '"+bed_no+"' and PSEUDO_BED_YN='N' ");
        PreparedStatement pstmt = con.prepareStatement(sql1.toString());
        rs = pstmt.executeQuery();
        String roomVal= "";

	  if(rs!=null && rs.next())
	  {
	    roomVal = rs.getString(1);  
	    String splty_code = checkForNull(rs.getString(2));
		String splty_desc = checkForNull(rs.getString(3));
	

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roomVal));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(splty_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
           

	}
	 else
	 {	

            _bw.write(_wl_block41Bytes, _wl_block41);
			
	 }
	pstmt.close();
	rs.close();
   }
}
/**From Revise Booking**/
if(source_type.equals("REVISE_VAL_ROOM_NO"))
{
 

   String bed_no = request.getParameter("bed_no");   
   String nursingunitcode = request.getParameter("nursunitcode");   
      
   if(bed_no != null)
   {      
		
	StringBuffer sql1 = new StringBuffer();
	sql1.append(" select room_no,bed_class_code,nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc from IP_NURSING_UNIT_BED where facility_id = '"+facilityid+"' AND NURSING_UNIT_CODE like '"+nursingunitcode+"%' AND BED_NO= '"+bed_no+"'  and PSEUDO_BED_YN='N' ");

        PreparedStatement pstmt = con.prepareStatement(sql1.toString());
		rs = pstmt.executeQuery();
        String roomVal= "";
	    String bed_class = "";
		String nursing_unit_code = "";
		String nursing_unit_desc = "";
	  if(rs!=null && rs.next())
	  {
	    roomVal				= rs.getString(1); 
		bed_class			= rs.getString(2); 
		nursing_unit_code	= rs.getString(3); 
		nursing_unit_desc	= rs.getString(4); 
	    

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(roomVal));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
           
	  }
	 else
	 {	

            _bw.write(_wl_block47Bytes, _wl_block47);
			
	 }
	pstmt.close();  
	rs.close();
   }
   else
{
	}
}

/**From Confirm Booking**/
if(source_type.equals("CONFIRM_VAL_ROOM_NO"))
{
 

   String bed_no = request.getParameter("bed_no");   
   String nursingunitcode = request.getParameter("nursunitcode");   
      
   if(bed_no != null)
   {      
		
	StringBuffer sql1 = new StringBuffer();
	sql1.append(" select room_no,bed_class_code,nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc from IP_NURSING_UNIT_BED where facility_id = '"+facilityid+"' AND NURSING_UNIT_CODE like '"+nursingunitcode+"%' AND BED_NO= '"+bed_no+"'  and PSEUDO_BED_YN='N' ");

        PreparedStatement pstmt = con.prepareStatement(sql1.toString());
		rs = pstmt.executeQuery();
        String roomVal= "";
	    String bed_class = "";
		String nursing_unit_code = "";
		String nursing_unit_desc = "";
	  if(rs!=null && rs.next())
	  {
	    roomVal				= rs.getString(1); 
		bed_class			= rs.getString(2); 
		nursing_unit_code	= rs.getString(3); 
		nursing_unit_desc	= rs.getString(4); 
	    

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(roomVal));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
           
	  }
	 else
	 {	

            _bw.write(_wl_block50Bytes, _wl_block50);
			
	 }
	pstmt.close();  
	rs.close();
   }
   else
{
	}
}

/** Confirm Button for Warnings **/

String error=request.getParameter( "err_num" );
	if ( error != null ) {

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(error));
            _bw.write(_wl_block52Bytes, _wl_block52);

	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}catch(Exception e){out.println(e); 
	e.printStackTrace(System.out) ;			

}
finally
{
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
