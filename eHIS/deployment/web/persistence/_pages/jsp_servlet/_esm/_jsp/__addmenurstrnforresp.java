package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmenurstrnforresp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AddMenuRstrnForResp.jsp", 1709121690120L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction action1(obj)\n\t\t{\n\t\t\t\n\t\t\tvar position=\"\";\n\t\t\tif (obj.checked==true) \n\t\t\t{\n\t\t\t\tposition=obj.name.substring(2,4);\n\n\t\t\t\t\n\t\t\t\tcomp_name=eval(\"document.forms[0].AA\"+position);\n\n\t\t\t\t\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\tcomp_name.checked=false;\n\t\t\t\tcomp_name=eval(\"document.forms[0].AC\"+position);\n\t\t\t\tcomp_name.checked=true;\n\n\t\t\t\tcomp_name1=eval(\"document.forms[0].AX\"+position);\n\t\t\t\tcomp_name1.value=comp_name.value;\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tposition=obj.name.substring(2,4);\n\t\t\t\tcomp_name=eval(\"document.forms[0].AC\"+position);\n\t\t\t\tcomp_name.checked=false;\n\t\t\t\tif(document.forms[0].option_type.value==\"F\")\n\t\t\t\t{\n\t\t\t\t\tcomp_name=eval(\"document.forms[0].AA\"+position);\n\t\t\t\t\tcomp_name.disabled=false;\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\t}\n\n\t\tfunction action2(obj)\n\t\t{\n\t\t\tvar position=\"\";\n\t\t\tif (obj.checked==true) \n\t\t\t{\n\t\t\t\tposition=obj.name.substring(2,4);\n\t\t\t\tcomp_name=eval(\"document.forms[0].AE\"+position);\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\tcomp_name.checked=false;\n\n\t\t\t\tcomp_name=eval(\"document.forms[0].AI\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=false;\n\n\t\t\t\tcomp_name=eval(\"document.forms[0].AU\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=false;\n\n\t\t\t\tcomp_name=eval(\"document.forms[0].AD\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=false;\n\n\t\t\t\tcomp_name=eval(\"document.forms[0].AP\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=false;\n\n\t\t\t\tcomp_name=eval(\"document.forms[0].AQ\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=false;\n\n\t\t\t\tcomp_name=eval(\"document.forms[0].AC\"+position);\n\t\t\t\tcomp_name.checked=true;\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tposition=obj.name.substring(2,4);\n\t\t\t\tcomp_name=eval(\"document.forms[0].AE\"+position);\n\t\t\t\tcomp_name.disabled=false;\n\t\t\t\tcomp_name.checked=false;\n\t\t\t\tcomp_name=eval(\"document.forms[0].AC\"+position);\n\t\t\t\tcomp_name.checked=false;\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\t\n\t\t\t\tcomp_name=eval(\"document.forms[0].AI\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\tcomp_name=eval(\"document.forms[0].AU\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\tcomp_name=eval(\"document.forms[0].AD\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\tcomp_name=eval(\"document.forms[0].AP\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t\tcomp_name=eval(\"document.forms[0].AQ\"+position);\n\t\t\t\tif(comp_name.checked==true)\n\t\t\t\tcomp_name.disabled=true;\n\t\t\t}\n\t\t}\n\n\t\tfunction showSubfunctions(module_id,menu_id,option_sequence_no,function_id,function_name,number)\n\t\t{\n\t\n\t\t\tif(eval(\"document.forms[0].AE\"+number+\".checked\") == false)\n\t\t\t{ \n\t\t\t var subfuncval = eval(\"document.forms[0].SF\"+number+\".value\");\n\n\t\t\t var retVal =    new String();\n\t\t\t var dialogHeight= \"15\" ;\n\t\t\t var dialogWidth = \"40\" ;\n\t\t\t var center = \"1\" ;\n\t\t\t var dialogTop = \"355\";\n\t\t\t var dialogLeft = \"155\";\n\t\t\t var status=\"no\";\n\t\t\t var features    = \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop + \"; dialogLeft :\" + dialogLeft;\n\t\t\t var arguments   = \"\" ;\n\t\t\t retVal = window.showModalDialog(\"../jsp/AddMenuRstrnForSubFunc.jsp?Step=Add&ModuleID=\"+module_id+\"&MenuID=\"+menu_id+\"&OptionSequenceNo=\"+option_sequence_no+\"&FunctionID=\"+function_id+\"&FunctionVal=\"+function_name+\"&SubFunctionValues=\"+subfuncval,arguments,features);\t\n\n\t\t\tif(retVal != null)\t\n\t\t\t\teval(\"document.forms[0].SF\"+number).value = retVal;\n\t\t\telse\n\t\t\t\teval(\"document.forms[0].SF\"+number).value = \"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getMessage(\"FUNCTION_EXCLUDED\",\'SM\'));\n\t\t\t}\n\t\t}\n\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' class=\'CONTENT\' onKeyDown = \'lockKey()\'>\n\t<form name=\'form4\' id=\'form4\'>\n\t\t<table border=1 cellspacing=0 cellpadding=0 align=center width=\'102%\'>\n\t\t<tr>\n\t\t<th rowspan=2 width=\'1%\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t<th rowspan=2 width=\'1%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th rowspan=2 width=\'5%\' align=left>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th rowspan=2 width=\'20%\' align=left>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th width=\'5%\'align=left>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t<th>&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;U&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;P&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q&nbsp;</th>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t<input type=checkbox name=\'AE";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'AE";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' value=\'E\' onclick=\'action1(this)\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t\t<input type=checkbox name=\'AA";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'AA";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\'Y\' onclick=\'action2(this)\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="></td>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t<td align=left class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t\t\t\t<input type=checkbox name=\'AI";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'AI";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\'Y\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=checkbox name=\'AU";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'AU";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  value=\'Y\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=checkbox name=\'AD";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'AD";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" value=\'Y\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=checkbox name=\'AP";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'AP";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="  value=\'Y\' disabled>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=checkbox name=\'AQ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'AQ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" value=\'Y\' disabled>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=checkbox disabled name=\'AC";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'AC";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' value=\'Y\'>&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=hidden name=\'AO";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'AO";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'AM";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'AM";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'AS";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'AS";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'AN";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'AN";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'AX";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'AX";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value=\'\'>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t\t\t\t<input type=checkbox name=\'AE";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' value=\'Y\' onclick=\'action2(this)\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" ></td>\n\t\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t</tds>\t\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\n\n\t\t</table>\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n</html>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

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

        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			Connection con=null;
			Statement stmt = null;
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt = null;
			try{
	        request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			ResultSet rs =null;
			ResultSet prs =null;
			String name=request.getParameter("name");
			if(name==null) name="";
			
			String option_type=request.getParameter("option_type");
			String option_type_desc="";
			String access_disabled="";
	

			if(option_type.equals("M")) 
			{
				option_type_desc="Menu";
				access_disabled="disabled";
			}
			else if(option_type.equals("F")) 
			{
				option_type_desc="Function";
				access_disabled="";
			}


			String resp_id=request.getParameter("resp_id");
			String menu_id=request.getParameter("menu_id");
			String submenu_id=request.getParameter("submenu_id");
			if (submenu_id==null) submenu_id="";
			if(submenu_id.equals("")) submenu_id=menu_id;
			
			String menuid="";
			String function_id="";
			String module_id="";
			String option_sequence_no="";
			String option_descriptor="";

			String insert_access_yn="";
			String update_access_yn="";
			String delete_access_yn="";
			String print_access_yn="";
			String query_only_access_yn="";

			String insert_enabled="disabled";
			String update_enabled="disabled";
			String delete_enabled="disabled";
			String print_enabled="disabled";
			String query_enabled="disabled";

			String insert_checked="";
			String update_checked="";
			String delete_checked="";
			String print_checked="";
			String query_checked="";
			int num=0;
			int i=0;
			int j=1;
			String classValue = "" ;
			
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
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
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		
		if(!name.equals(""))
		{
			
			if(option_type.equals("M"))
			{
					
				num=1;
				String p_menu_id="";
				//String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b where a.menu_id = '"+menu_id+"' or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"' )  and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and a.subMENU_ID not in (Select subMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and OPTION_TYPE='M' )";				
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b where a.menu_id = ? or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ? )  and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper(?) and a.subMENU_ID not in (Select subMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and OPTION_TYPE='M' )";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	menu_id		);
				pstmt1.setString	(	2,	menu_id		);
				pstmt1.setString	(	3,	name+"%"		);
				pstmt1.setString	(	4,	resp_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				String sql="";
				//sql="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN,a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b where (a.menu_id = '"+menu_id+"' or a.menu_id in (Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"' ) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and  a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper('"+name+"%"+"')  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID='"+resp_id+"' and OPTION_TYPE='M') order by b.menu_name";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				sql="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN,a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b where (a.menu_id = ? or a.menu_id in (Select submenu_id  from sm_menu_dtl  where menu_id = ? ) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and  a.option_type='M' and upper(a.OPTION_DESCRIPTOR) like upper(?)  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID=? and OPTION_TYPE='M') order by b.menu_name";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	menu_id		);
				pstmt1.setString	(	2,	menu_id		);
				pstmt1.setString	(	3,	name+"%"		);
				pstmt1.setString	(	4,	resp_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						p_menu_id=rs.getString("menu_id");
						if( p_menu_id==null )p_menu_id="";

						submenu_id=rs.getString("submenu_id");
						if( submenu_id==null )submenu_id="";

						module_id=rs.getString("module_id");
						if( module_id==null )module_id="";

						option_sequence_no=rs.getString("option_sequence_no");

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(num));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(access_disabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(option_type_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(insert_enabled));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(insert_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(num));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(update_enabled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(update_checked));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(num));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(delete_enabled));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(delete_checked));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(print_enabled));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(print_checked));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(num));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(query_enabled));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(query_checked));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(num));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(option_sequence_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(num));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(p_menu_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(num));
            _bw.write(_wl_block56Bytes, _wl_block56);

						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
					out.println("<input type=hidden name=submenu_id value='"+menu_id+"'>");
				}
			}	// second if
			else if(option_type.equals("F"))
			{
					System.err.println("************************");
				String p_menu_id="";
				num=1;
				//String  sql_count="Select count(*) from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='F' ";
				//System.err.println("sql_count================"+sql_count);
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String  sql_count="Select count(*) from SM_MENU_DTL where MENU_ID=? and upper(OPTION_DESCRIPTOR) like upper(?) and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and MENU_ID=? ) and OPTION_TYPE='F' ";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	resp_id		);
				pstmt1.setString	(	4,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}

				//String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='F'"; 
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID=? and upper(OPTION_DESCRIPTOR) like upper(?) and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID=? ) and OPTION_TYPE='F'"; 
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();

				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						menuid = rs.getString("menu_id");
						
						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						option_sequence_no=rs.getString("option_sequence_no");

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);

						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();
						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";
				
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(num));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(num));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(access_disabled));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(option_type_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");

						out.println("<td class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+" value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			
			  
			}
			//Added by Mallikarjuna Reddy on 19/06/2003 for List item Report
			else
				{
				String p_menu_id="";
				
				num=1;
				//String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and MENU_ID='"+submenu_id+"') and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID=? and upper(OPTION_DESCRIPTOR) like upper(?) and FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and MENU_ID=?) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	resp_id		);
				pstmt1.setString	(	4,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				//String	sql =" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and  upper(OPTION_DESCRIPTOR) like upper('"+name+"%"+"') and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID='"+submenu_id+"'  ) and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql =" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID=? and  upper(OPTION_DESCRIPTOR) like upper(?) and  FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where MENU_ID=?  ) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	name+"%"		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						menuid = rs.getString("menu_id");
						
						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						option_sequence_no=rs.getString("option_sequence_no");

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);
						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();

						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");

						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+" value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			//End of Addition by Mallikarjuna Reddy on 19/06/2003 for List item Report
		}	// first if
		else 
		{
			
		
			if(option_type.equals("M"))
			{
				num=1;
				
	
			//String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = '"+menu_id+"' or  a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"') ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M'  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID='"+resp_id+"' and  OPTION_TYPE='M' )";
			//stmt=con.createStatement();
			//rs=stmt.executeQuery(sql_count);
			
			String	sql_count=" Select count(*) from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = ? or  a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ?) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null and a.option_type='M'  and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID=? and  OPTION_TYPE='M' )";
			pstmt1   = con.prepareStatement(sql_count);
			pstmt1.setString	(	1,	menu_id		);
			pstmt1.setString	(	2,	menu_id		);
			pstmt1.setString	(	3,	resp_id		);
			rs		 = pstmt1.executeQuery();
			
				if(rs!=null){
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}

				String p_menu_id="";
				//String	sql ="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN, a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = '"+menu_id+"' or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = '"+menu_id+"') ) and a.submenu_id = b.menu_id  and a.submenu_id is not null   and a.option_type='M' and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and  OPTION_TYPE='M' ) order by b.menu_name  ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql ="Select a.menu_id, a.submenu_id, a.MODULE_ID, a.OPTION_SEQUENCE_NO,a. INSERT_ACCESS_YN, a.UPDATE_ACCESS_YN, a.DELETE_ACCESS_YN, a.PRINT_ACCESS_YN, a.QUERY_ONLY_ACCESS_YN,a.OPTION_DESCRIPTOR from SM_MENU_DTL a, sm_menu_hdr b  where  (a.menu_id = ? or a.menu_id in ( Select submenu_id  from sm_menu_dtl  where menu_id = ?) ) and a.submenu_id = b.menu_id  and a.submenu_id is not null   and a.option_type='M' and a.SUBMENU_ID not in (Select SUBMENU_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and  OPTION_TYPE='M' ) order by b.menu_name  ";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	menu_id		);
				pstmt1.setString	(	2,	menu_id		);
				pstmt1.setString	(	3,	resp_id		);
				rs		 = pstmt1.executeQuery();
				
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						p_menu_id=rs.getString("menu_id");
						if( p_menu_id==null )p_menu_id="";

						submenu_id=rs.getString("submenu_id");
						if(submenu_id==null) submenu_id="";
                       
						module_id=rs.getString("module_id");
						option_sequence_no=rs.getString("option_sequence_no");
                        
						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+"  value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AS"+num+" value='"+submenu_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
             out.println("<input type=hidden name=submenu_id value='"+menu_id+"'>");
			}	// second if
			else if(option_type.equals("F"))
			{
				num=1;
				String p_menu_id="";
				StringBuffer sql_count=new StringBuffer();
				//sql_count.append(" Select count(*) from SM_MENU_DTL ");
				//sql_count.append(" where MENU_ID='"+submenu_id+"' and ");
				//sql_count.append("    ");
				//sql_count.append(" FUNCTION_ID not in ( ");
				//sql_count.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				//sql_count.append(" where RESP_ID='"+resp_id+"' and ");
				//sql_count.append(" MENU_ID='"+submenu_id+"'   ");
				//sql_count.append("  )");
				//sql_count.append("  and OPTION_TYPE='F' ");
				
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count.toString());
				System.err.println("sql_count.toString()============"+sql_count.toString());
				
				sql_count.append(" Select count(*) from SM_MENU_DTL ");
				sql_count.append(" where MENU_ID=? and ");
				sql_count.append("    ");
				sql_count.append(" FUNCTION_ID not in ( ");
				sql_count.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql_count.append(" where RESP_ID=? and ");
				sql_count.append(" MENU_ID=?   ");
				sql_count.append("  )");
				sql_count.append("  and OPTION_TYPE='F' ");
				
				pstmt1   = con.prepareStatement(sql_count.toString());
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				StringBuffer	sql =new StringBuffer();
				//sql.append(" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, ");
				//sql.append(" INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, ");
				//sql.append(" PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, ");
				//sql.append(" OPTION_DESCRIPTOR from SM_MENU_DTL ");
				//sql.append(" where MENU_ID='"+submenu_id+"' and ");
				//sql.append(" FUNCTION_ID not in ( ");
				//sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				//sql.append(" where RESP_ID='"+resp_id+"' and ");
				//sql.append(" MENU_ID='"+submenu_id+"'   ");
				//sql.append("  )");
				//sql.append("  and OPTION_TYPE='F' ");
					
//					out.println(sql);		
//System.err.println("sql====="+sql);	
	//			stmt=con.createStatement();
		//		rs=stmt.executeQuery(sql.toString());
				
				sql.append(" Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO, ");
				sql.append(" INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN, ");
				sql.append(" PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID, ");
				sql.append(" OPTION_DESCRIPTOR from SM_MENU_DTL ");
				sql.append(" where MENU_ID=? and ");
				sql.append(" FUNCTION_ID not in ( ");
				sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql.append(" where RESP_ID=? and ");
				sql.append(" MENU_ID=?   ");
				sql.append("  )");
				sql.append("  and OPTION_TYPE='F' ");
				
				pstmt1   = con.prepareStatement(sql.toString());
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						option_sequence_no=rs.getString("option_sequence_no");
						menuid=rs.getString("menu_id");

						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);
						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();

						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");
						
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+"  value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			}else
				{
				num=1;
				String p_menu_id="";
				//String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and   FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID='"+resp_id+"' and MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql_count);
				
				String  sql_count=" Select count(*) from SM_MENU_DTL where MENU_ID=? and   FUNCTION_ID not in (Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW  where RESP_ID=? and MENU_ID=? ) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql_count);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next())
					{
						i=rs.getInt(1);
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}

				//String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID='"+submenu_id+"' and  FUNCTION_ID not in ( Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID='"+resp_id+"' and  MENU_ID='"+submenu_id+"' ) and OPTION_TYPE='R' ";
				//stmt=con.createStatement();
				//rs=stmt.executeQuery(sql);
				
				String	sql ="Select FUNCTION_ID, MODULE_ID, OPTION_SEQUENCE_NO,INSERT_ACCESS_YN, UPDATE_ACCESS_YN, DELETE_ACCESS_YN,PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, MENU_ID,OPTION_DESCRIPTOR from SM_MENU_DTL where MENU_ID=? and  FUNCTION_ID not in ( Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW where RESP_ID=? and  MENU_ID=? ) and OPTION_TYPE='R' ";
				pstmt1   = con.prepareStatement(sql);
				pstmt1.setString	(	1,	submenu_id		);
				pstmt1.setString	(	2,	resp_id		);
				pstmt1.setString	(	3,	submenu_id		);
				rs		 = pstmt1.executeQuery();
				if(rs!=null)
				{
					while(rs.next() &&  j<=i )
					{
						
						if ( j % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						function_id=rs.getString("function_id");
						module_id=rs.getString("module_id");
						option_sequence_no=rs.getString("option_sequence_no");
						menuid=rs.getString("menu_id");

						option_descriptor=rs.getString("option_descriptor");
						if(option_descriptor==null) option_descriptor="";

						insert_access_yn=rs.getString("insert_access_yn");
						if(insert_access_yn.equals("Y"))
						{
							insert_checked="checked";
							insert_enabled="";
						}
						else{
							insert_checked="";
							insert_enabled="disabled";
						}

						update_access_yn=rs.getString("update_access_yn");
						if(update_access_yn.equals("Y")) 
						{
							update_checked="checked";
							update_enabled="";

						}
						else{
						update_checked="";
						update_enabled="disabled";
						}

						delete_access_yn=rs.getString("delete_access_yn");
						if(delete_access_yn.equals("Y")) 
						{
							delete_checked="checked";
							delete_enabled="";
						}
						else{
						delete_checked="";
						delete_enabled="disabled";
						}

						print_access_yn=rs.getString("print_access_yn");
						if(print_access_yn.equals("Y")) 
						{
						
							print_checked="checked";
							print_enabled="";
						}
						else{
						print_checked="";
						print_enabled="disabled";
						
						}

						query_only_access_yn=rs.getString("query_only_access_yn");
						if(query_only_access_yn.equals("Y")) 
						{
							query_checked="checked";
							query_enabled="";
						}
						else{
							query_checked="";
							query_enabled="disabled";
						}

						int rec_cnt = 0;
						String subfunction_yn = "";
						pstmt = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+option_sequence_no+"' and FUNCTION_ID= '"+function_id+"' ");	
						prs = pstmt.executeQuery();

						if(prs.next())
							rec_cnt = prs.getInt(1);
						if(prs!=null)prs.close();
						if(pstmt!=null)pstmt.close();

						if(rec_cnt > 0)
							subfunction_yn = "Y";
						else
							subfunction_yn = "N";

						out.println("<tr>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AE"+num+" value='E' onclick='action1(this)'></td>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AA"+num+" value='Y' onclick='action2(this)' "+access_disabled+" ></td>");
						out.println("<td align=center class='"+classValue+"'>"+option_type_desc+"</td>");

					if(subfunction_yn.equals("Y"))
						out.println("<td class='"+classValue+"'><a href=\"javascript:showSubfunctions('"+module_id+"','"+menuid+"','"+option_sequence_no+"','"+function_id+"','"+option_descriptor+"','"+num+"')\">"+option_descriptor+"</a></td>");
					else
						out.println("<td class='"+classValue+"'>"+option_descriptor+"</td>");
						
						out.println("<td align=center class='"+classValue+"'><input type=checkbox name=AI"+num+" value='Y' "+insert_enabled+" "+insert_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AU"+num+" "+update_enabled+" value='Y' "+update_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AD"+num+" "+delete_enabled+" value='Y' "+delete_checked+" disabled>&nbsp;&nbsp;<input type=checkbox name=AP"+num+" "+print_enabled+" "+print_checked+"  value='Y' disabled>&nbsp;&nbsp;<input type=checkbox name=AQ"+num+"  "+query_enabled+" "+query_checked+" value='Y' disabled>");
						out.println("<td align=center class='"+classValue+"'><input type=checkbox disabled name=AC"+num+" value='Y'>");
						out.println("<input type=hidden name=AO"+num+" value='"+option_sequence_no+"'>");
						out.println("<input type=hidden name=AF"+num+" value='"+function_id+"'>");
						out.println("<input type=hidden name=AM"+num+" value='"+module_id+"'>");
						out.println("<input type=hidden name=AN"+num+" value='"+p_menu_id+"'>");
						out.println("<input type=hidden name=AX"+num+" value=''>");
						out.println("<input type=hidden name=SF"+num+" value=''>");
						out.println("</tr>");
						num++;
						j++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				}
				out.println("<input type=hidden name=submenu_id value='"+submenu_id+"'>");
			}
				
		}	
		out.println("<input type=hidden name=option_type value='"+option_type+"'>");


            _bw.write(_wl_block62Bytes, _wl_block62);

	if(stmt != null) stmt.close();
	if(pstmt != null) pstmt.close();

}catch(Exception e){out.println(e);}

finally {
		ConnectionManager.returnConnection(con,request);
}			

            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AccessRights.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.AccessLevel.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
