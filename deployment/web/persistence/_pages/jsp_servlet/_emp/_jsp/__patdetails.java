package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatDetails.jsp", 1715084162192L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>parent.f_query_add_mod.document.getElementById(\'used_status\').value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\t\n//\t\talert(parent.document.frames[1].document.forms[0].used_status.value);\n\t\t</script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t\t<Script language=\"JavaScript\">\n\t\t\t\n\t\t\tvar temp = \"parent.f_query_add_mod.document.getElementById(\'siteorfac\').firstChild.nodeValue =\'Facility\';\";\n\t\t\teval(temp);\t\n\n\n\t\t\tparent.f_query_add_mod.document.getElementById(\'siteorfac\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'site_or_facility_id\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'sno\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'start_srl_no\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'maxlabel\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'max_srl_no\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st1\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st2\').style.visibility=\'visible\';\n\n\n\n\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility_id.disabled=false;\n\n\t\t\tparent.f_query_add_mod.document.forms[0].pat_no_ctrl.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\n\t\t\tparent.f_query_add_mod.document.getElementById(\'mr_section_code_tr\').style.visibility=\'visible\';\n\t\t\tparent.result.location.href = \"../../eCommon/html/blank.html\";\n\t\t</Script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t\t\t<script>\t\n\t\t\t\tvar tp =\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"--- \"\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value=\"\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility_id.add(opt);\t\t\t\t\t\n\t\t\t</script>\t        \n\t\t\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility_id.add(opt);\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility.value=\"F\";\n\n\t\t\tparent.f_query_add_mod.document.forms[0].start_srl_no.value=\"\";\n\t\t\tparent.f_query_add_mod.document.forms[0].max_srl_no.value=\"\";\n\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\n\t\t<Script language=\"JavaScript\">\n\t\t\t\n\t\t\tvar temp1 = \"parent.f_query_add_mod.document.getElementById(\'siteorfac\').firstChild.nodeValue =\'Site\';\";\n\t\t\teval(temp1);\n\n\t\t\tparent.f_query_add_mod.document.getElementById(\'siteorfac\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'site_or_facility_id\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'sno\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'start_srl_no\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'maxlabel\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'max_srl_no\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st1\').style.visibility=\'visible\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st2\').style.visibility=\'visible\';\n\n\n\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility_id.disabled=false;\n\t\t\tparent.f_query_add_mod.document.forms[0].start_srl_no.disabled=false;\n\t\t\tparent.f_query_add_mod.document.forms[0].max_srl_no.disabled=false;\n\t\t\tparent.f_query_add_mod.document.forms[0].start_srl_no.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tparent.f_query_add_mod.document.forms[0].max_srl_no.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tif(parent.f_query_add_mod.document.forms[0].start_srl_no.value!=\"\" && parent.f_query_add_mod.document.forms[0].max_srl_no.value!=\"\")\n\t\t\t{\n\t\t\tparent.f_query_add_mod.document.forms[0].max_srl_no.readOnly = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].start_srl_no.readOnly = true;\n\t\t\tparent.f_query_add_mod.document.forms[0].readonly_flag.value =\"Y\";\n\t\t\t}\n\t\t\t\n\t\t\tvar pat_ser_grp_code1=parent.f_query_add_mod.document.getElementById(\'pat_ser_grp_code\').value;\n\n\t\t\tparent.f_query_add_mod.document.forms[0].pat_no_ctrl.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\tparent.f_query_add_mod.document.getElementById(\'mr_section_code_tr\').style.visibility=\'hidden\';\n\t\t\tparent.result.location.href = \"../../eMP/jsp/addPatientNumberingDetail_Result.jsp?pat_ser_grp_code=\"+pat_ser_grp_code1;\n\t\t</Script>\n\n\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<script>\n\t\t\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility_id.add(opt);\n\t\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility.value=\"S\";\n\t\t\t</script>\n\t\t\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\n\t<script>\t\n\n\t\tvar n=parent.f_query_add_mod.document.forms[0].mr_section_code.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.remove(\"mr_section_code\");\t\t\t\t\n\n\t\t}\t\t\t\t\t\n\t\tvar tp =\" --\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"--- \"\n\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);\t\t\t\t\t\n\n\t</script>\t        \n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t\t<script>\n\t\t\t//alert(\"here\");\n\n\t\t\tvar temp = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);\n\t\t</script>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t<script language=\'Javascript\'>\n\n\t\t\t\t\n\t\t\t//alert(parent.document.frames[1].document.forms[0].used_status.value);\n\t\t\tparent.f_query_add_mod.document.getElementById(\'gen_pid_using_alt_id1_rule_yn\').value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\n\t\t\t//alert(parent.document.frames[1].document.forms[0].gen_pid_using_alt_id1_rule_yn.value);\n\n\t\t\tparent.f_query_add_mod.document.getElementById(\'mr_section_code_tr\').style.visibility=\'hidden\';\n\n\t\t\tparent.f_query_add_mod.document.getElementById(\'siteorfac\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'site_or_facility_id\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'sno\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'start_srl_no\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'maxlabel\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'max_srl_no\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st1\').style.visibility=\'hidden\';\n\t\t\tparent.f_query_add_mod.document.getElementById(\'st2\').style.visibility=\'hidden\';\n\n\n\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility.value=\"\";\n\t\t\tparent.f_query_add_mod.document.forms[0].site_or_facility_id.value=\"\";\n\t\t\t//parent.document.frames[1].document.forms[0].site_or_facility_id.disabled=true;\n\t\t\t//parent.document.frames[1].document.forms[0].start_srl_no.value=\"\";\n\t\t\t//parent.document.frames[1].document.forms[0].max_srl_no.value=\"\";\n\t\t\t//parent.document.frames[1].document.forms[0].start_srl_no.disabled=true;\n\t\t\t//parent.document.frames[1].document.forms[0].max_srl_no.disabled=true;\n\t\t\tparent.f_query_add_mod.document.forms[0].readonly_flag.value =\"Y\";\n\n\t\t\tvar pat_ser_grp_code1=parent.f_query_add_mod.document.getElementById(\'pat_ser_grp_code\').value;\n\t\t\tparent.result.location.href = \"../../eMP/jsp/addPatientNumberingDetail_Result.jsp?pat_ser_grp_code=\"+pat_ser_grp_code1;\n\n\t\t\t</script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<script>parent.f_query_add_mod.document.getElementById(\'pref_val\').value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t</script>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t<script>\n\t\t\t\t\n\t\t\n\t\t\t//alert(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\");\n\t\t//\talert(\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\");\n\t\t\tparent.f_query_add_mod.document.getElementById(\'max_srl_no\').maxLength=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\tparent.f_query_add_mod.document.getElementById(\'start_srl_no\').maxLength=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\n\t\t\t\n\t\t\n\t\t</script>\n\t\t\n\t\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t<script>\n\t\t\t\t\n\t\t//alert(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\");\n\t\tparent.f_query_add_mod.document.forms[0].max_srl_no.maxLength=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\tparent.f_query_add_mod.document.forms[0].start_srl_no.maxLength=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\n\t\t\n\t\t\n\t</script>\n\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\n\t<script>\n\t\t\n\t\t//alert(\"1\");\n\t\tvar n=parent.f_query_add_mod.document.forms[0].mr_section_code.options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.remove(\"mr_section_code\");\t\t\t\t\n\n\t\t}\t\t\t\t\t\n\t\tvar tp =\" ---\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"--- \"\n\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);\t\t\t\t\t\n\n\t</script>\t        \n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\t\t<script>\n\t\t\t\t//alert(\"2\");\n\t\t\t\tvar n=parent.f_query_add_mod.document.forms[0].mr_section_code.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.remove(\"mr_section_code\");\t\t\t\t\n\t\t\t\n\t\t\t\t}\t\t\t\t\t\n\t\t\t\tvar tp =\" --\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"--- \"\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value=\"\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);\t\t\t\t\t\n\n\t\t\t</script>\t        \n\t\t\t\t\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\t\t\t\t<script>\n\t\t\t\t\t//alert(\"here\");\n\t\t\t\t\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\topt.text=temp1;\n\t\t\t\t\topt.value=temp;\n\t\t\t\t\tparent.f_query_add_mod.document.forms[0].mr_section_code.add(opt);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	ResultSet reset=null;
	ResultSet rstt=null;
	ResultSet rs=null;
	ResultSet rst=null;			
	ResultSet rss=null;
	ResultSet rset1=null;

	String moduleid="";
	String moduledesc="";
	String common=request.getParameter("Common_Text");	
	String common1=request.getParameter("Common_Text1");
	String chksrc = request.getParameter("Chksrc");
	String used_status = "";
	String scheme_id = "";

	String start_srl_no="";
	String max_srl_no="";
	String gen_pid_using_alt_id1_rule_yn1="";
	String pid_use_alt_id1_or_sys_gen="";



	try
	{
	con = ConnectionManager.getConnection(request);

	if(chksrc.trim().equals("forpatnum")) 
		{			
			String st="";
		try
		{	
//Added by sen on 3/07/2004
		try {
			String strsql = "select used_status from mp_pat_ser_facility where pat_ser_grp_code = '"+common.trim()+"' ";	

			
			pstmt = con.prepareStatement(strsql);
			reset=pstmt.executeQuery();					
			if(reset.next())
				{
				used_status = reset.getString("used_status")==null?"":reset.getString("used_status");
				}
					
			
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(used_status));
            _bw.write(_wl_block7Bytes, _wl_block7);


		}
		catch (Exception e)
		{
		}
		finally{
			if(pstmt!=null)pstmt.close();
			if(reset!=null)reset.close();
		}
//addition ends



			String sq="select pat_no_ctrl,scheme_id from mp_pat_ser_grp where  pat_ser_grp_code ='"+ common.trim() + "'"; 
			pstmt1 = con.prepareStatement(sq);
			rset = pstmt1.executeQuery();	
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
			if(rset.next())
			{
				 st=rset.getString("pat_no_ctrl");
				 scheme_id=rset.getString("scheme_id")==null ? "" : rset.getString("scheme_id");
			}	
		}catch(Exception e) { /* out.println("ERROR IN ST FETCHING :"+e.toString()); */ e.printStackTrace();}
		
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rset != null) rset.close();
		}

		if(st.equals("U"))
		{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(st));
            _bw.write(_wl_block9Bytes, _wl_block9);

			
		
		try{
			String sql2="select facility_id,facility_name from sm_facility_param order by facility_name"; 
			pstmt1 = con.prepareStatement(sql2);
			rs = pstmt1.executeQuery();


            _bw.write(_wl_block10Bytes, _wl_block10);
				
				while( rs.next() ) 
				{
					moduleid = rs.getString( "facility_id" ) ;	
					moduledesc= rs.getString( "facility_name" );

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
			   			
					
			 }
			
            _bw.write(_wl_block14Bytes, _wl_block14);

	
		}catch(Exception e) 
		{ /* out.println("ERROR IN U FETCHING :"+e.toString()); */
	    	e.printStackTrace();
		}
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rs != null) rs.close();
		}
			
			}	
		else if(st.equals("Z"))
		{

			String sql1="select START_SRL_NO,MAX_SRL_NO from mp_pat_ser_facility where pat_ser_grp_code='"+common.trim()+"'";

			pstmt1 = con.prepareStatement(sql1);
			rset = pstmt1.executeQuery();	
			//out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'><form name='nam1' id='nam1'>");
			if(rset.next())
			{
				 start_srl_no=rset.getString("START_SRL_NO");
				 max_srl_no=rset.getString("MAX_SRL_NO");
			}	
			

				if (pstmt1 != null) pstmt1.close();
				if (rset != null) rset.close();

	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start_srl_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(max_srl_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(st));
            _bw.write(_wl_block18Bytes, _wl_block18);


		try{
			String stt="select site_id,site_name from sm_site_param ";
			pstmt1 = con.prepareStatement(stt);
			rset = pstmt1.executeQuery();
			rset.next();
			moduleid=rset.getString("site_id");
			moduledesc=rset.getString("site_name");
		}catch(Exception e) { /* out.println(e.toString()); */
		e.printStackTrace();}
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rset != null) rset.close();
		}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block21Bytes, _wl_block21);


//CODE FOR MR SECTION

try{
	String srt="select mr_section_code,short_name from mr_section where mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name "; 		
	pstmt1 = con.prepareStatement(srt);
	rstt = pstmt1.executeQuery();	


            _bw.write(_wl_block22Bytes, _wl_block22);
				
	 while( rstt.next() ) 
	 {
		moduleid = rstt.getString( "mr_section_code" ) ;	
		moduledesc= rstt.getString( "short_name" ) ;

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
	

	 }

}catch(Exception e) { /* out.println("Error MR Section "+e.toString()); */ e.printStackTrace();}
finally
{
if (pstmt1 != null) pstmt1.close();
if (rstt != null) rstt.close();
}
}


else
	{
	
	
			String sqt1="select gen_pid_using_alt_id1_rule_yn,pid_use_alt_id1_or_sys_gen from MP_PAT_SER_GRP where pat_ser_grp_code='"+common.trim()+"'";

			pstmt1 = con.prepareStatement(sqt1);
			rset1 = pstmt1.executeQuery();	
			
			if(rset1.next())
			{
				gen_pid_using_alt_id1_rule_yn1 = rset1.getString("gen_pid_using_alt_id1_rule_yn");
				pid_use_alt_id1_or_sys_gen = rset1.getString("pid_use_alt_id1_or_sys_gen");			
				
			}	
			

				if (pstmt1 != null) pstmt1.close();
				if (rset1 != null) rset1.close();

			if(gen_pid_using_alt_id1_rule_yn1.equals("Y") && pid_use_alt_id1_or_sys_gen.equals("A"))
			{
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(gen_pid_using_alt_id1_rule_yn1));
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
	}







	try{
		pstmt1=con.prepareStatement("select patient_id_length from mp_param");
		rset = pstmt1.executeQuery();	
		if(rset.next())
		{
			int patlen=rset.getInt("patient_id_length");
			if(scheme_id.equals("VDG"))
			{
			patlen=patlen-1;
			}
			int patlen2=patlen-2;

		try{				
			if(pstmt1!=null) pstmt1.close();
			pstmt1=con.prepareStatement("select prefix_reqd_yn from mp_pat_ser_grp where pat_ser_grp_code ='"+common.trim()+"'"); 
			rst=pstmt1.executeQuery();	
			if(rst.next())
			{
				String pxreq=rst.getString("prefix_reqd_yn");
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pxreq));
            _bw.write(_wl_block29Bytes, _wl_block29);

				if(pxreq.equals("Y"))
				{
				

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patlen));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patlen2));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patlen2));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patlen2));
            _bw.write(_wl_block34Bytes, _wl_block34);
	


				}
				else
				{


            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pxreq));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patlen));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patlen));
            _bw.write(_wl_block38Bytes, _wl_block38);


				}
				
			}

		
	}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
	finally
	{
		if (pstmt1 != null) pstmt1.close();
		if (rst != null) rst.close();
		if (rset!=null) rset.close();
	}		 		
		}
		out.println("</form></body></html>");
}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
finally
{
if (pstmt1 != null) pstmt1.close();
if (rset != null) rset.close();
}
	}
	else if(chksrc.trim().equals("formrsect")) 
		{		
	//select prefix_reqd_yn from mp_pat_ser_grp where pat_ser_grp_code ='"+common.trim()+"'"; 
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
	
	String sr="";
	String slct="";
try{	
	pstmt1 = con.prepareStatement(" select pat_no_ctrl from mp_pat_ser_grp where pat_ser_grp_code='"+common1.trim()+"'");
	rss=pstmt1.executeQuery();	
	if(rss.next())
	{
		slct=rss.getString("pat_no_ctrl");
		//rss.close();	
	}
}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
finally
{
	if (pstmt1 != null) pstmt1.close();
	if (rss != null) rss.close();
}

	
 if(slct.trim().equals("Z"))
 {
	try{
	sr="select mr_section_code,short_name from mr_section where mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name "; 	
	pstmt1 = con.prepareStatement(sr);
	rstt = pstmt1.executeQuery();	
	

            _bw.write(_wl_block39Bytes, _wl_block39);
				
	 while( rstt.next() ) 
	 {
		moduleid = rstt.getString( "mr_section_code" ) ;	
		moduledesc= rstt.getString( "short_name" ) ;

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
	

	 }

}catch(Exception e) { /* out.println(e.toString()); */ e.printStackTrace();}
finally
{
	if (pstmt1 != null) pstmt1.close();
	if (rstt != null) rstt.close();
}
	
 }
	
	else if(slct.trim().equals("U"))
	{
try{		 	
	sr="select mr_section_code,short_name from mr_section where facility_id='"+common.trim()+"' and mr_section_type ='C' and  eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_name ";  
	pstmt1 = con.prepareStatement(sr);
	rstt = pstmt1.executeQuery();	
	

            _bw.write(_wl_block40Bytes, _wl_block40);
				
				while( rstt.next() ) 
				{
					moduleid = rstt.getString( "mr_section_code" ) ;	
					moduledesc= rstt.getString( "short_name" ) ;

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(moduleid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(moduledesc));
            _bw.write(_wl_block42Bytes, _wl_block42);
	

			 }
		}catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace(); }
		finally
		{
			if (pstmt1 != null) pstmt1.close();
			if (rstt != null) rstt.close();
		}

	}
	out.println("</form></body></html>");
}

	}catch(Exception e){/* out.println(e); */ e.printStackTrace();}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
