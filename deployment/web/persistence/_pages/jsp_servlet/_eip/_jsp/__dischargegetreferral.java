package jsp_servlet._eip._jsp;

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

public final class __dischargegetreferral extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeGetReferral.jsp", 1742378263544L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n        <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>\n\t\t\tvar BodyFrame = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>\n\tvar ref_type = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\tif(ref_type == \'L\')\n\t\tif(eval(BodyFrame).document.getElementById(\'org_type\')) \n\t\t\teval(BodyFrame).document.getElementById(\'org_type\').innerHTML=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"; \n\t</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t\tif(eval(BodyFrame).document.getElementById(\'org_type\')) \n\t\t\teval(BodyFrame).document.getElementById(\'org_type\').innerHTML=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\t\tvar ref_type= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tvar temp\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\tvar temp1\t= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\tvar jsp_val = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\n\t\t\t\tvar hcare_setting_type_desc\t= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\tvar hcare_setting_type\t\t= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\n\t\t\t\tvar hcareOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\thcareOpt.text\t= hcare_setting_type_desc;\n\t\t\t\thcareOpt.value\t= hcare_setting_type;\n\t\t\t\thcareOpt.selected=true;\n\n\t\tif(ref_type == \"L\" || ref_type == \"E\")\n\t\t{\n\t\t\tvar opt3=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\topt3.text=temp1;\n\t\t\topt3.value=temp;\n\t\t\t\n\t\t\tif (jsp_val != \"\")\n\t\t\t{\n\t\t\t\tvar ref_code = eval(BodyFrame).document.forms[0].referral_type.value;\n\t\t\t\tif (ref_code == temp)\n\t\t\t\tif(ref_type == \"L\" || ref_type == \"E\")\n\t\t\t\t{\t\n\t\t\t\t\topt3.selected=true;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\topt3.selected=true;\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\n\t\t\teval(BodyFrame).document.forms[0].referred_to.add(opt3);\n\t\t}\n\t\teval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);\n\t\teval(BodyFrame).document.forms[0].hcare_setting_type_desc.value=hcare_setting_type_desc;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar hcare_setting_type_desc = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\tvar hcare_setting_type_code = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\tvar hcareOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\thcareOpt.text\t= hcare_setting_type_desc;\n\t\t\t\t\thcareOpt.value\t= hcare_setting_type_code;\n\t\t\t\teval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Nursing Unit\";\n\t\t\t\t\t\topt.value=\"N\";\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<script>\n\t\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\"Clinic\";\n\t\t\t\t\topt.value=\"C\";\n\t\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\t\t\teval(BodyFrame).location0_array[ eval(BodyFrame).location0_array.length] = opt;\n\t\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=\"Day Care\";\n\t\t\t\t\topt.value=\"D\";\n\t\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt;\n\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<script>\t\t\t\n\t\t\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"Nursing Unit\";\n\t\t\t\t\t\topt.value=\"N\";\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<script>\n\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\topt.text=\"Clinic\";\n\t\t\t\topt.value=\"C\";\n\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\topt.text=\"Day Care\";\n\t\t\t\topt.value=\"D\";\n\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="           <script>\n\t\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\topt.text=\"Nursing Unit\";\n\t\t\t\topt.value=\"N\";\n\t\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>\n\t\t\topt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\topt.text=\"Clinic\";\n\t\t\topt.value=\"C\";\n\t\t\teval(BodyFrame).document.forms[0].location0.add(opt);\n\t\t\teval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt\n\t\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<script>\n\t\tvar specialty = eval(BodyFrame).document.forms[0].speciality;\n\t\twhile(specialty.options.length > 0)\n\t\t\tspecialty.remove(specialty.options[1]);\n\n\t\tvar specialtyOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\tspecialtyOpt.text\t= \"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\tspecialtyOpt.value\t= \"\";\n\t\teval(BodyFrame).document.forms[0].speciality.add(specialtyOpt);\n\t</script>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t<script>\n\t\t\t\tvar specialtyOpt\t= eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\tspecialtyOpt.text\t= \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\tspecialtyOpt.value\t= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\teval(BodyFrame).document.forms[0].speciality.add(specialtyOpt);\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t<script>\n\t\teval(BodyFrame).document.forms[0].service.value = \"\";\n\t\teval(BodyFrame).document.forms[0].priority.value = \"\";\n\t</script>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<script>\n\t\t\t\tvar referredToCode = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\tvar referredToDesc = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\t\t\n\t\t\t\tvar referredToOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\treferredToOpt.text\t= referredToDesc;\n\t\t\t\treferredToOpt.value = referredToCode;\n\t\t\t\teval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar referredToCode = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\tvar referredToDesc = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\tvar referredToOpt = eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\treferredToOpt.text\t= referredToDesc;\n\t\t\t\t\treferredToOpt.value = referredToCode;\n\t\t\t\t\teval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].speciality.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<script>\n\tvar ref_type= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\tvar org\t\t= \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\tif(ref_type == \'E\' || ref_type == \'X\')\n\t  if(eval(BodyFrame).document.getElementById(\'org_type\')) \n\t\teval(BodyFrame).document.getElementById(\'org_type\').innerHTML=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\tvar org = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\tif(ref_type == \'E\' || ref_type == \'L\')\n\t\tif(eval(BodyFrame).document.getElementById(\'org_type\')) \n\t\teval(BodyFrame).document.getElementById(\'org_type\').innerHTML=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<script>\n\t// If Loaction Type is Clinic, then Referred For is Disabled...\n\t\teval(BodyFrame).document.forms[0].ref_for_ip.disabled = false; \n\t</script>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar opt=eval(BodyFrame).document.createElement(\"OPTION\");\n\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"; \n\t\t\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<script>opt.selected=true;\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location1.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<script>\n\t\t\t// If Loaction Type is Clinic, then Referred For is Disabled...\n\t\t\t\teval(BodyFrame).document.forms[0].ref_for_ip.disabled = true; \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<script> opt.selected=true;\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\teval(BodyFrame).document.forms[0].location1.add(opt);\n//\t\t\t\t\t\teval(BodyFrame).document.forms[0].location1_desc.value=temp1;\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<script> opt.selected=true;\t</script>\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</head>\n<body class=message onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'dummyform\' id=\'dummyform\'></form>\n</body>\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n</html>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		request.setCharacterEncoding("UTF-8"); 
		Connection con			= null;
		ResultSet rs			= null;
		Statement stmt			= null;
		Statement stmt_loc		= null;
		Statement stmt_loc1		= null;
		ResultSet rs_loc		= null;
		ResultSet rs_loc1		= null;
		Statement st_new		= null;

	try{
		con = ConnectionManager.getConnection(request);
		String facility_id	= (String) session.getValue( "facility_id" ) ;
	
		String sql						= "";
		String sql_loc					= "";
		String sql_loc1					= "";
		String org_type					= "";
		String org_type_desc			= "";
		String nursingUnitDesc			= "";
		String nursingUnitCode			= "";
		String clinicDesc				= "";
		String clinicCode				= "";
		String referredtoid				= "";
		String referredtodesc			= "";
		String hcare_setting_type_desc	= "";
		String hcare_setting_type_code	= "";
		String hcare_setting_type		= "";
		
		int ip	= 0;
		int op	= 0;

		String ref_type	=	request.getParameter("ref_type");
		if(ref_type==null) ref_type="";
		
		String loc_type=request.getParameter("loc_type");
		if(loc_type==null) loc_type="";

		String ref_to=request.getParameter("ref_to");
		if(ref_to==null) ref_to="";

		String location1=request.getParameter("location1");
		if(location1==null) location1="";

		String specLoad=request.getParameter("specLoad");
		if(specLoad==null) specLoad="";

		String Option = request.getParameter("Option");
		if(Option == null) Option = "Y";

		String resetHcare = request.getParameter("resetHcare");
		if(resetHcare == null) resetHcare = "N";

		String referred_to_id=request.getParameter("referred_to_id");
		if(referred_to_id==null) referred_to_id="";

		String referred_to_desc=request.getParameter("referred_to_desc");
		if(referred_to_desc==null) referred_to_desc="";

		String loc0=request.getParameter("loc0");
		if(loc0==null) loc0="";

		String src1=request.getParameter("src1");
		if(src1 == null) src1 = "";

		String specialty=request.getParameter("specialty");
		if (specialty == null ) specialty = "";

		String service=request.getParameter("service");
		if (service == null ) service = "";

		String jsp_val=request.getParameter("jsp_val");
		if (jsp_val == null ) jsp_val = "";

		String BodyFrame = request.getParameter("BodyFrame");
		if (BodyFrame == null ) BodyFrame = "";

		String Module = request.getParameter("Module");
		if (Module == null ) Module = "";

		String hcare_type_code = request.getParameter("hcare_type");
		if(hcare_type_code==null) hcare_type_code="";

		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(BodyFrame));
            _bw.write(_wl_block5Bytes, _wl_block5);


/*
	Referral Types	:	Login Facility		[ code : L ]
					:	Enterprise			[ code : E ]
					:	External			[ code : X ]

		Module		: Outpatient MAnagement [ code : OP ]
					: Inpatient MAnagement	[ code : IP ]


*/
/// Setting the Value For [ ORG TYPE ] For Different Referral Types ... 
		
		sql="SELECT Nvl(org_type, ' ') as org_type FROM am_referral WHERE referral_code='"+referred_to_id+"'";

		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
		if(rs.next())
		{
		   org_type=rs.getString("org_type").trim();
		}
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();
	
		if(ref_type.equals("X"))
		{
			if(org_type.equals("G") || org_type.length() == 0 || org_type==null) 			org_type_desc="<b>Government</b>";

			if(org_type.equals("P")) 
				org_type_desc="<b>Private</b>";
		}
		
		if(ref_type.equals("E") || ref_type.equals("L"))
			org_type_desc="<b>Government</b>";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);


if(src1.equals("populateBlankORG"))
{
org_type_desc="<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);

}


/// Func used to Populate Hcare Values based on Referral type & Module...
if(src1.equals("populateHcare"))
{

	if(ref_type.equals("L"))
	{
		/// Func used to Populate Hcare Values If Referral type is Login facilty...

		sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param a, am_hcare_setting_type b where a.facility_id = '"+facility_id+"' and a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name ";	

		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs!=null)
		{
			while(rs.next())
			{
				referredtoid=rs.getString("referred_to_id");
				referredtodesc=rs.getString("referred_to_id_desc");
				hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
				hcare_setting_type=rs.getString("hcare_setting_type_code");
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(jsp_val));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(referred_to_id.equals(referredtoid) || ref_type.equals("L") || ref_type.equals("E")) 
			{
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);

		}// E.O While
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();
	  }// E.O If
	}// E.O if(ref_type.equals("L")
	else
	if(ref_type.equals("E") || ref_type.equals("X"))
	{
		if(Module.equals("IP"))
		{
//			out.println("<script>alert('IP Module & ref_type : "+ref_type+"');</script>");
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is IP...
			String hcareSql = " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) order by SHORT_DESC ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(hcareSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}// E.O While
			if(rs!=null)		rs.close();
			if(stmt!=null)		stmt.close();
			}// E.O if
		}
		else
		if(Module.equals("OP"))
		{
//			out.println("<script>alert('OP Module & ref_type : "+ref_type+"');</script>");
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is OP...
			String hcareSql = " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) order by SHORT_DESC ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(hcareSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hcare_setting_type_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}// E.O While
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();
			}// E.O if
		}
	}// E.O ref_type

	if(ref_type.equals("E") || ref_type.equals("L"))
	{

		/// <<<<< OP + IP >>>>> Value	
		sql_loc="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

		stmt_loc=con.createStatement();
		rs_loc=stmt_loc.executeQuery(sql_loc);
		
		if(rs_loc!=null)
		{
			if (rs_loc.next())
			{
				ip	= rs_loc.getInt(1);
				op	= rs_loc.getInt(2);
			}
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc!= null)stmt_loc.close();		
		}

			if (ip > 0 )
			{
				if (ref_type.equals("L") && op > 0)
				{
					if(Option.equals("Y"))
					{	
            _bw.write(_wl_block22Bytes, _wl_block22);
	}	
            _bw.write(_wl_block23Bytes, _wl_block23);
		}
			else if (op > 0)
			{
				if(Option.equals("Y"))
				{
			
            _bw.write(_wl_block24Bytes, _wl_block24);
	}	
            _bw.write(_wl_block25Bytes, _wl_block25);

			}
			else
			{

            _bw.write(_wl_block26Bytes, _wl_block26);

			}
	}
	else
	if(op>0)
	{
	
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
}

/// Added by Sridhar R on 8 June 2004
/// This will clear all the values of Specialty onChange of Refferal Type & default its initial Values ...
	if(specLoad.equals("1"))
	{
		String Specialty_Desc = "";
		String Specialty_Code = "";

		sql = "Select Short_Desc,Speciality_Code from Am_Speciality where Eff_Status = 'E' order by 1";
		stmt=con.createStatement();
		rs = stmt.executeQuery(sql);

            _bw.write(_wl_block28Bytes, _wl_block28);

		while(rs.next())
		{
			Specialty_Code = rs.getString("Speciality_Code"); 
			Specialty_Desc = rs.getString("Short_Desc");
			if(Specialty_Code==null) Specialty_Code="";
			if(Specialty_Desc==null) Specialty_Desc="";
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Specialty_Desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Specialty_Code));
            _bw.write(_wl_block31Bytes, _wl_block31);

		}
		if(rs!=null)	rs.close();
		if(stmt!= null)stmt.close();		
	
            _bw.write(_wl_block32Bytes, _wl_block32);

	}//E.O SpecLoad
}// E.O if(src1.equals("populateHcare"))

if(src1.equals("populateReferredTo"))
{
	if(ref_type.equals("E"))
	{			
//		out.println("<script>alert('ref_type(E) IP/OP');</script>");

		String HCARE_TYPE_CODE = request.getParameter("hcare_type");
		String referredToSql = " SELECT FACILITY_ID REFERRED_TO_ID, FACILITY_NAME REFERRED_TO_ID_DESC FROM SM_FACILITY_PARAM WHERE FACILITY_ID != '"+facility_id+"' AND  HCARE_SETTING_TYPE_CODE='"+HCARE_TYPE_CODE+"' order by 2";

		stmt=con.createStatement();
		rs=stmt.executeQuery(referredToSql);

		if(rs!=null)
		{
			while(rs.next())
			{
				referredtoid			=	rs.getString("REFERRED_TO_ID");
				referredtodesc			=	rs.getString("REFERRED_TO_ID_DESC");
			
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block35Bytes, _wl_block35);

			}// E.O while
			if(rs!=null)	rs.close();
			if(stmt!= null)stmt.close();		
			}// E.O if
	}// E.O if(ref_type.equals("E"))
	else
	if( ref_type.equals("X"))
	{
		if(Module.equals("IP"))
		{
//			out.println("<script>alert('ref_type(X) & Module(IP)');</script>");

			String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			String referredToSql = "SELECT SHORT_DESC, REFERRAL_CODE FROM AM_REFERRAL WHERE EFF_STATUS = 'E' AND DEST_USE_AT_DISCH_YN = 'Y' AND HEALTHCARE_SETTING_TYPE='"+HCARE_TYPE_CODE+"' order by 1 ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(referredToSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid	=	rs.getString("REFERRAL_CODE");
					referredtodesc	=	rs.getString("SHORT_DESC");
				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block38Bytes, _wl_block38);

				}// E.O while
			if(rs!=null)	rs.close();
			if(stmt!= null)stmt.close();		
			}// E.O if
		}
		else
		if(Module.equals("OP"))
		{
//			out.println("<script>alert('ref_type(X) & Module(OP)');</script>");

			String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			String referredToSql = " SELECT SHORT_DESC, REFERRAL_ID FROM AM_REFERRAL WHERE EFF_STATUS = 'E' AND DEST_USE_AT_CONCL_YN = 'Y' AND HEALTHCARE_SETTING_TYPE = ='"+HCARE_TYPE_CODE+"' order by 1 ";

			stmt=con.createStatement();
			rs=stmt.executeQuery(referredToSql);

			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid	=	rs.getString("REFERRED_TO_ID");
					referredtodesc	=	rs.getString("REFERRED_TO_ID_DESC");
				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block38Bytes, _wl_block38);

				}// E.O while
			}// E.O if
		}
	}
}

// The function will query the SPECIALTY options if Referral Type is External..
if(src1.equals("populateSpecialty"))
{
	String hcare_code   = request.getParameter("hcare_code");
	String ref_to_code	= request.getParameter("ref_to_code");
	if(ref_to_code ==null) ref_to_code  ="";
	if(hcare_code==null) hcare_code="";

	if(ref_type.equals("X"))
	{
		String specialty_short_desc	= "";
		String specialty_code		= "";
		
		String sql_ext_specialty = "Select specialty_code,specialty_short_desc from am_referral_for_specialty_vw where referral_code='"+ref_to_code+"' order by 2";
			
			st_new	= con.createStatement();
			rs		= st_new.executeQuery(sql_ext_specialty);
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code		= rs.getString("specialty_code");
					specialty_short_desc= rs.getString("specialty_short_desc");
					
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
	}	
			if(rs!=null)	rs.close();
			if(st_new!= null)st_new.close();
}
	}//if ref type='X'

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);

}

if(src1.equals("populateORG"))
{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(org_type_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);

}

if(src1.equals("populateLocation"))
{
	/// Func used to Display Location Values based on Location Type...

            _bw.write(_wl_block47Bytes, _wl_block47);


	if(service == null) service = "";

	String referred_to = request.getParameter("ref_to");
	if(referred_to == null) referred_to = "";

/// FOR Location Type = "Clinic"
	if(loc_type.equals("C"))
	{	
		if(!service.equals(""))
		{
			sql_loc1=" SELECT SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' UNION SELECT CLINIC_SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";		
		}
		else if(service.equals(""))
		{
		   sql_loc1=" SELECT SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' order by 1 ";		
		}


		stmt_loc1=con.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				clinicDesc	= rs_loc1.getString("CLINIC_DESC");
				clinicCode	= rs_loc1.getString("CLINIC_CODE");
				
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
if(location1.equals(clinicCode) ) 
				{
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
            _bw.write(_wl_block52Bytes, _wl_block52);

			}// E.O While
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc1!= null)stmt_loc1.close();
		}// E.O If
		
            _bw.write(_wl_block53Bytes, _wl_block53);

	}// E.O if(loc_type.equals("C"))

/// FOR Location Type = "Nursing Unit"
	if (loc_type.equals("N"))
	{
		if(!service.equals(""))
		{
	
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'IP' UNION SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SERVICE_VW WHERE AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'IP' order by 1 ";
		}
		else if(service.equals(""))
		{
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND APPL_PATIENT_CLASS = 'IP' order by 1 ";
		}

		stmt_loc1=con.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);

		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				nursingUnitDesc	= rs_loc1.getString("NU_DESC");
				nursingUnitCode	= rs_loc1.getString("NURSING_UNIT_CODE");
				
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nursingUnitDesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nursingUnitCode));
            _bw.write(_wl_block50Bytes, _wl_block50);
if(location1.equals(nursingUnitCode) ) 
				{
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
            _bw.write(_wl_block55Bytes, _wl_block55);

			}// E.O While
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc1!= null)stmt_loc1.close();
		}// E.O If
	}// E.O if (loc_type.equals("N"))

/// FOR Location Type = "Day Care"
	if (loc_type.equals("D"))
	{
		if(!service.equals(""))
		{ 
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'DC' UNION SELECT NURSING_UNIT_SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' AND APPL_PATIENT_CLASS = 'DC' order by 1 ";
		}
		else if(service.equals(""))
		{ 
		   sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT WHERE EFF_STATUS = 'E' AND FACILITY_ID = '"+referred_to+"' AND APPL_PATIENT_CLASS = 'IP' order by 1 ";
		}
		
		stmt_loc1=con.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				nursingUnitDesc	= rs_loc1.getString("NU_DESC");
				nursingUnitCode	= rs_loc1.getString("NURSING_UNIT_CODE");
				
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nursingUnitDesc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nursingUnitCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
	if(location1.equals(nursingUnitCode)) 
				{	
            _bw.write(_wl_block57Bytes, _wl_block57);
	} 
            _bw.write(_wl_block52Bytes, _wl_block52);

			}// E.O While
			if(rs_loc!=null)	rs_loc.close();
			if(stmt_loc1!= null)stmt_loc1.close();
		}// E.O If
	}// E.O if (loc_type.equals("D"))
}// E.O if(src1.equals("populateLocation"))


            _bw.write(_wl_block58Bytes, _wl_block58);

	}catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		if(stmt!=null)		stmt.close();
		if(rs!=null)		rs.close();
		if(stmt_loc!= null) stmt_loc.close();
		ConnectionManager.returnConnection(con,request);
		if(stmt_loc1!= null)stmt_loc1.close();
		if(rs_loc!=null)	rs_loc.close();
		if(rs_loc1!=null)	rs_loc1.close();
		if(st_new!=null)	st_new.close();
	}
	
            _bw.write(_wl_block59Bytes, _wl_block59);
            _bw.write(_wl_block60Bytes, _wl_block60);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
