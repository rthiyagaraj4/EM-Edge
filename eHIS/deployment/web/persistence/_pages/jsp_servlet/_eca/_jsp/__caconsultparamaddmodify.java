package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __caconsultparamaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAConsultParamAddModify.jsp", 1728040773517L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/CAConsultationParam.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\" onload=\'FocusFirstElement();\' onKeyDown=\"lockKey()\">\n\t<form name=\"ca_consultation_param_form\" id=\"ca_consultation_param_form\" action=\"\" method=\"\">\n\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n   <!-- Below five fields mandatory check are added by Archana Dhal on 6/9/2010 for IN021962-->\n\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=0 width=\'100%\'>\n\t\t<tr align=\"left\">\n\t\t\t<th class=\'columnheader\' colspan=\'4\'>IP Consultation</th>\n\t\t</tr>\n\t</table>\n\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=0 width=\'100%\'>\n\t<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'label\'><input type=\"text\" name=\"max_consultation_practitioner\" id=\"max_consultation_practitioner\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'  onblur=\'checkSequence(this);CheckPositiveNumberLocal(this)\' ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'label\'><input type=\"text\" name=\"back_date_consultation\" id=\"back_date_consultation\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"  size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'   onblur=\'checkSequence(this);CheckPositiveNumberLocal(this)\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n    </tr>\n\n\t<tr>\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td class=\'label\'><input type=\"text\" name=\"max_consultation_speciality\" id=\"max_consultation_speciality\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'     onblur=\'checkSequence(this);CheckPositiveNumberLocal(this)\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'label\'><input type=\"text\" name=\"amend_consultation_list\" id=\"amend_consultation_list\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'  onblur=\'checkSequence(this);CheckPositiveNumberLocal(this)\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\n    </tr> \n\n\t<tr>\n\t<td class=\'label\' colspan=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td class=\'label\'colspan=3><input type=\"text\" name=\"min_duration_recquired\" id=\"min_duration_recquired\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'    onblur=\'checkSequence(this);CheckPositiveNumberLocal(this)\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n    </tr>\n\t<tr>\n\t<td class=\'label\' ><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td>\n\t<td class=\'label\' colspan=3 ><input type=\"text\" name=\"ip_consult\" id=\"ip_consult\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" size=2 maxlength=2  disabled  >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t</tr>\n\n\t<tr>\n\t<td class=\'label\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t<td class=\'label\' colspan=3><input type=\"text\" name=\"reg_consult\" id=\"reg_consult\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'  onblur=\'checkSequence(this);CheckPositiveNumberLocal(this);validateLimit(\"R\")\' >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t<td class=\'label\' colspan=3><input type=\"text\" name=\"ref_consult\" id=\"ref_consult\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" size=2 maxlength=2 onkeyPress=\'return allowValidNumber(this,event,2,0)\'  onblur=\'checkSequence(this);CheckPositiveNumberLocal(this);validateLimit(\"F\")\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t</tr>\t\n\t</table>\n\n\t<input type=hidden name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<!--IN065070 starts -->\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=0 width=\'100%\'>\n\t\t<tr align=\"left\">\n\t\t\t<th class=\'columnheader\' colspan=\'4\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</th>\n\t\t</tr>\n\t</table>\n\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=0 width=\'100%\'>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\"47%\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td class=\'label\' width=\"3%\"  align=\'left\'><input type=\'checkbox\' name=\'aemanagePatQueue\' id=\'aemanagePatQueue\' id=\'aemanagePatQueue\' onclick=\'aeManagePatQueueClick()\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/></td>\n\t\t\t<td class=\'label\' width=\"47%\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t<td class=\'label\' width=\"3%\" align=\'left\'><input type=\'checkbox\' name=\'aeCAPatByLocn\' id=\'aeCAPatByLocn\' id=\'aeCAPatByLocn\' onclick=\'aeCAPatByLocnClick()\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="/></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'2\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'aemngType\' id=\'aemngType\' id=\'aemngType\' value=\'PCWE\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td class=\'label\' colspan=\'2\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'aeCAType\' id=\'aeCAType\' id=\'aeCAType\' value=\'PCWE\'  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'2\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'aemngType\' id=\'aemngType\' id=\'aemngType\'  value=\'PCWOE\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td class=\'label\' colspan=\'2\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'aeCAType\' id=\'aeCAType\' id=\'aeCAType\' value=\'PCWOE\'  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'2\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'aemngType\' id=\'aemngType\' id=\'aemngType\' value=\'RUNTIME\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t<td class=\'label\' colspan=\'2\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'aeCAType\' id=\'aeCAType\' id=\'aeCAType\' value=\'RUNTIME\'  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<!--IN065070 ends -->\n\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=0 width=\'100%\'>\n\t\t<tr align=\"left\">\n\t\t\t<th class=\'columnheader\'   colspan=\'4\'>OP Consultation</th>\n\t\t</tr>\n\t</table>\n\n\t<table  align=\'left\' cellpadding=3 cellspacing=0 border=0 width=\'50%\'>\n\t\t<tr>\n\t\t\t<td class=\'label\'>Prompt for Start Consultation in Manage Patient Queue</td>\n\t\t\t<td class=\'label\' colspan=\'3\' align=\'left\'><input type=\'checkbox\' name=\'managePatQueue\' id=\'managePatQueue\' id=\'managePatQueue\' onclick=\'managePatQueueClick()\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="/></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'  align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'mngType\' id=\'mngType\' id=\'mngType\' value=\'PCWE\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="/>Open Patient Chart with Encounter</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'  align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'mngType\' id=\'mngType\' id=\'mngType\'  value=\'PCWOE\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="/>Open Patient Chart without Encounter</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'  align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'mngType\' id=\'mngType\' id=\'mngType\' value=\'RUNTIME\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="/>Prompt for Chart type while opening patient chart</td>\n\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\'>Prompt for Start Consultation in Clinician Access</td>\n\t\t\t<td class=\'label\' align=\'left\'><input type=\'checkbox\' name=\'CAPatByLocn\' id=\'CAPatByLocn\' id=\'CAPatByLocn\' onclick=\'CAPatByLocnClick()\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="/></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'  align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'CAType\' id=\'CAType\' id=\'CAType\' value=\'PCWE\'  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="/>Open Patient Chart with Encounter</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'  align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'CAType\' id=\'CAType\' id=\'CAType\' value=\'PCWOE\'  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="/>Open Patient Chart without Encounter</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' colspan=\'3\'  align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'CAType\' id=\'CAType\' id=\'CAType\' value=\'RUNTIME\'  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="/>Prompt for Chart type while opening patient chart</td>\n\t\t</tr>\n\t\t<!--IN052254 Start.-->\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t<td class=\'label\' align=\'left\'><input type=\'checkbox\' name=\'caRestUnBilled\' id=\'caRestUnBilled\' id=\'caRestUnBilled\' onclick=\'caRestUnBilledClick()\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="/></td>\n\t\t</tr>\n\t\t<!--IN052254 End.-->\n\t</table>\n\t<input type=hidden name=\"isAESiteSpecific\" id=\"isAESiteSpecific\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><!--Added for IN065070-->\n\t</form>\n\t<script>\n\t\t//alert(document.getElementById(\"CAPatByLocn\").value+\" \"+document.getElementById(\"managePatQueue\").value);\n\t\t/*if(document.getElementById(\"CAPatByLocn\").value==\'\'||document.getElementById(\"CAPatByLocn\").value==\'N\')\n\t\t\tdisableRadios(\'CAType\');\n\t\tif(document.getElementById(\"managePatQueue\").value==\'\'||document.getElementById(\"managePatQueue\").value==\'N\')\n\t\t\tdisableRadios(\'mngType\');*/\n\n\t\t\tif(document.getElementById(\"CAPatByLocn\").checked)\n\t\t\t\tenableRadiosOnLoad(document.getElementsByName(\'CAType\'));\n\t\t\telse\n\t\t\t\tdisableRadiosOnLoad(document.getElementsByName(\'CAType\'));\n\t\n\t\t\tif(document.getElementById(\"managePatQueue\").checked)\n\t\t\t\tenableRadiosOnLoad(document.getElementsByName(\'mngType\'));\n\t\t\telse\n\t\t\t\tdisableRadiosOnLoad(document.getElementsByName(\'mngType\'));\n\t\t\t//IN065070 starts \n\t\t\tif(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="){\n\n\t\t\t\tif(document.getElementById(\"aeCAPatByLocn\").checked )\n\t\t\t\t\tenableRadiosOnLoad(document.getElementsByName(\'aeCAType\'));\n\t\t\t\telse\n\t\t\t\t\tdisableRadiosOnLoad(document.getElementsByName(\'aeCAType\'));\n\t\t\t\n\t\t\t\tif(document.getElementById(\"aemanagePatQueue\").checked )\n\t\t\t\t\tenableRadiosOnLoad(document.getElementsByName(\'aemngType\'));\n\t\t\t\telse\n\t\t\t\t\tdisableRadiosOnLoad(document.getElementsByName(\'aemngType\'));\n\t\t\t}\n\t\t\t//IN065070 ends\n\t</script>\n\t</body>\n\t</html>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

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

/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Review			Date 		Description							
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
21/07/2016		IN052254		Ramesh G										MMS-QH-CRF-0204	
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN065070	Raja S		27/10/2017		Ramesh G			ML-MMOH-CRF-0623.1
--------------------------------------------------------------------------------------------------------------------
*/

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

	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

            _bw.write(_wl_block5Bytes, _wl_block5);

    request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try
     {

	   String mode="";
       String max_consultation_practitioner ="";
      String back_date_consultation ="";
       String max_consultation_speciality ="";
       String amend_consultation_list ="";
       String min_duration_recquired ="";
       String max_regular_cons ="";
       String max_referral_cons ="";
	   String mngPatQueue = "";
	   String CAPatByLocn = "";
	   String caRestUnBilled = ""; //IN052254
	   String caRestUnBilledChk = ""; //IN052254
	   String mngPatQueueChk = "";
	   String CAPatByLocnChk = "";
	   String ca_patlist_by_locn_chart_type_chk1 = "";
	   String ca_patlist_by_locn_chart_type_chk2 = "";
	   String ca_patlist_by_locn_chart_type_chk3 = "";

	   String MNG_PAT_QUEUE_chart_type_chk1="";
	   String MNG_PAT_QUEUE_chart_type_chk2="";
	   String MNG_PAT_QUEUE_chart_type_chk3="";

	   String MNG_PAT_QUEUE_chart_type ="";
	   String ca_patlist_by_locn_chart_type ="";
       
	   String mngPatQueueEnableDisable = "";
	   String CAPatByLocnEnableDisable = "";
	   //IN065070 changes starts
	   String ae_curr_emr_patient = "";
	   String ae_curr_emr_patient_chart_type = "";
	   String aePatQueueChk = "";
	   String aePatQueueEnableDisable = "";
   	   String ae_curremr_pat_chart_type_chk1 = "";
	   String ae_curremr_pat_chart_type_chk2 = "";
	   String ae_curremr_pat_chart_type_chk3 = "";
	   String aeCAPatByLocn = "";
	   String aeCAPatByLocnChk = "";
	   String ae_patlist_by_locn_chart_type_chk1 = "";
	   String ae_patlist_by_locn_chart_type_chk2 = "";
	   String ae_patlist_by_locn_chart_type_chk3 = "";
	   String aeCAPatByLocnEnableDisable = "";
	   String ae_patlist_by_locn_chart_type = "";
	   //IN065070 changes ends
	   
	   int rec_exists = 0;
	   int ip_cons = 0;

       mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");

		//IN052254 Start.
		//String SqlQuery = "SELECT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE FROM CA_CONS_PARAM";
		//String SqlQuery = "SELECT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,CA_REST_UNBILLED_PATIENT FROM CA_CONS_PARAM";//Commented for IN065070
		//IN052254 End.
		String SqlQuery = "SELECT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,CA_REST_UNBILLED_PATIENT,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE FROM CA_CONS_PARAM";//Modified for IN065070

		
	   conlCon = ConnectionManager.getConnection(request);
	   pstmt = conlCon.prepareStatement(SqlQuery);
	   rslRst = pstmt.executeQuery();
	   if(rslRst.next())
		{
				rec_exists = 1;			
				max_consultation_practitioner =  rslRst.getString("MAX_CONS_PER_PRACT") == null ? "":  rslRst.getString("MAX_CONS_PER_PRACT");
				max_consultation_speciality =  rslRst.getString("MAX_CONS_PER_SPLTY") == null ? "":rslRst.getString("MAX_CONS_PER_SPLTY");
				back_date_consultation =  rslRst.getString("CONS_BACK_DATE") == null ? "":rslRst.getString("CONS_BACK_DATE");
				amend_consultation_list =  rslRst.getString("AMD_CONS_LIST") == null ? "":rslRst.getString("AMD_CONS_LIST");
				min_duration_recquired =  rslRst.getString("MIN_CONS_DURATION") == null ? "":rslRst.getString("MIN_CONS_DURATION");				
				max_regular_cons =  rslRst.getString("MAX_REGULAR_CONS") == null ? "0":rslRst.getString("MAX_REGULAR_CONS");				
				max_referral_cons =  rslRst.getString("MAX_REFERRAL_CONS") == null ? "0":rslRst.getString("MAX_REFERRAL_CONS");				
				mngPatQueue = rslRst.getString("MNG_PAT_QUEUE") == null ? "":rslRst.getString("MNG_PAT_QUEUE");
				CAPatByLocn = rslRst.getString("CA_PATLIST_BY_LOCN") == null ? "":rslRst.getString("CA_PATLIST_BY_LOCN");
				caRestUnBilled = rslRst.getString("CA_REST_UNBILLED_PATIENT") == null ? "":rslRst.getString("CA_REST_UNBILLED_PATIENT"); //IN052254
				ca_patlist_by_locn_chart_type = rslRst.getString("CA_PATLIST_BY_LOCN_CHART_TYPE") == null ? "":rslRst.getString("CA_PATLIST_BY_LOCN_CHART_TYPE");
				MNG_PAT_QUEUE_chart_type = rslRst.getString("MNG_PAT_QUEUE_CHART_TYPE") == null ? "":rslRst.getString("MNG_PAT_QUEUE_CHART_TYPE");
				//IN065070 changes starts
				ae_curr_emr_patient = rslRst.getString("AE_CURR_EMR_PATIENT") == null ? "N":rslRst.getString("AE_CURR_EMR_PATIENT");
				if("".equals(ae_curr_emr_patient))
					ae_curr_emr_patient="N";
				ae_curr_emr_patient_chart_type = rslRst.getString("AE_CURR_EMR_PATIENT_CHART_TYPE") == null ? "":rslRst.getString("AE_CURR_EMR_PATIENT_CHART_TYPE");
				aeCAPatByLocn = rslRst.getString("AE_CA_PATLIST_BY_LOCN") == null ? "N":rslRst.getString("AE_CA_PATLIST_BY_LOCN");
				if("".equals(aeCAPatByLocn))
					aeCAPatByLocn="N";
				ae_patlist_by_locn_chart_type = rslRst.getString("AE_PATLIST_BY_LOCN_CHART_TYPE") == null ? "":rslRst.getString("AE_PATLIST_BY_LOCN_CHART_TYPE");
				
				
				if(ae_curr_emr_patient.equals("Y"))
				{
					aePatQueueChk = "checked";
					aePatQueueEnableDisable = "";
				}
				else if(ae_curr_emr_patient.equals("N"))
				{
					aePatQueueChk = "";
					aePatQueueEnableDisable = "disabled";
				}

				if(ae_patlist_by_locn_chart_type.equals("PCWE"))
				{	
					ae_patlist_by_locn_chart_type_chk1 = "checked";
					ae_patlist_by_locn_chart_type_chk2 = "";
					ae_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ae_patlist_by_locn_chart_type.equals("PCWOE"))
				{
					ae_patlist_by_locn_chart_type_chk1 = "";
					ae_patlist_by_locn_chart_type_chk2 = "checked";
					ae_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ae_patlist_by_locn_chart_type.equals("RUNTIME"))
				{
					ae_patlist_by_locn_chart_type_chk1 = "";
					ae_patlist_by_locn_chart_type_chk2 = "";
					ae_patlist_by_locn_chart_type_chk3 = "checked";
				}

				if(ae_curr_emr_patient_chart_type.equals("PCWE"))
				{	
					ae_curremr_pat_chart_type_chk1 = "checked";
					ae_curremr_pat_chart_type_chk2 = "";
					ae_curremr_pat_chart_type_chk3 = "";
				}
				else if(ae_curr_emr_patient_chart_type.equals("PCWOE"))
				{
					ae_curremr_pat_chart_type_chk1 = "";
					ae_curremr_pat_chart_type_chk2 = "checked";
					ae_curremr_pat_chart_type_chk3 = "";
				}
				else if(ae_curr_emr_patient_chart_type.equals("RUNTIME"))
				{
					ae_curremr_pat_chart_type_chk1 = "";
					ae_curremr_pat_chart_type_chk2 = "";
					ae_curremr_pat_chart_type_chk3 = "checked";
				}

				if(aeCAPatByLocn.equals("Y"))
				{
					aeCAPatByLocnChk = "checked";
					aeCAPatByLocnEnableDisable = "";
				}
				else if(aeCAPatByLocn.equals("N"))
				{
					aeCAPatByLocnChk = "";
					aeCAPatByLocnEnableDisable = "disabled";
				}
				//IN065070 changed ends

				if(mngPatQueue.equals("Y"))
				{
					mngPatQueueChk = "checked";
					mngPatQueueEnableDisable = "";
				}
				else if(mngPatQueue.equals("N"))
				{
					mngPatQueueChk = "";
					mngPatQueueEnableDisable = "disabled";
				}

				if(CAPatByLocn.equals("Y"))
				{
					CAPatByLocnChk = "checked";
					CAPatByLocnEnableDisable = "";
				}
				else if(CAPatByLocn.equals("N"))
				{
					CAPatByLocnChk = "";
					CAPatByLocnEnableDisable = "disabled";
				}
				//IN052254 Start.
				if("Y".equals(caRestUnBilled))
				{
					caRestUnBilledChk = "checked";					
				}
				else if("N".equals(caRestUnBilled))
				{
					caRestUnBilledChk = "";					
				}				
				//IN052254 End.
				if(ca_patlist_by_locn_chart_type.equals("PCWE"))
				{	
					ca_patlist_by_locn_chart_type_chk1 = "checked";
					ca_patlist_by_locn_chart_type_chk2 = "";
					ca_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ca_patlist_by_locn_chart_type.equals("PCWOE"))
				{
					ca_patlist_by_locn_chart_type_chk1 = "";
					ca_patlist_by_locn_chart_type_chk2 = "checked";
					ca_patlist_by_locn_chart_type_chk3 = "";
				}
				else if(ca_patlist_by_locn_chart_type.equals("RUNTIME"))
				{
					ca_patlist_by_locn_chart_type_chk1 = "";
					ca_patlist_by_locn_chart_type_chk2 = "";
					ca_patlist_by_locn_chart_type_chk3 = "checked";
				}


				if(MNG_PAT_QUEUE_chart_type.equals("PCWE"))
				{	
					MNG_PAT_QUEUE_chart_type_chk1 = "checked";
					MNG_PAT_QUEUE_chart_type_chk2 = "";
					MNG_PAT_QUEUE_chart_type_chk3 = "";
				}
				else if(MNG_PAT_QUEUE_chart_type.equals("PCWOE"))
				{
					MNG_PAT_QUEUE_chart_type_chk1 = "";
					MNG_PAT_QUEUE_chart_type_chk2 = "checked";
					MNG_PAT_QUEUE_chart_type_chk3 = "";
				}
				else if(MNG_PAT_QUEUE_chart_type.equals("RUNTIME"))
				{
					MNG_PAT_QUEUE_chart_type_chk1 = "";
					MNG_PAT_QUEUE_chart_type_chk2 = "";
					MNG_PAT_QUEUE_chart_type_chk3 = "checked";
				}

				if(!max_regular_cons.equals("0")&&!max_referral_cons.equals("0"))
				ip_cons=Integer.parseInt(max_regular_cons)+Integer.parseInt(max_referral_cons);
		
			mode = "modify";
		
		}
		else
		{
			mode = "insert";
		}
//IN065070 starts	   
	boolean isAEStartConsulation = false;
	isAEStartConsulation=CommonBean.isSiteSpecific(conlCon,"AE","AE_START_CONSULTATION");
//IN065070 ends
	  
   
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(max_consultation_practitioner));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(back_date_consultation));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(max_consultation_speciality));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(amend_consultation_list));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(min_duration_recquired));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ip_cons>0?ip_cons:""));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(!max_regular_cons.equals("0")?max_regular_cons:""));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(!max_referral_cons.equals("0")?max_referral_cons:""));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(isAEStartConsulation){
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ae_curr_emr_patient));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(aePatQueueChk));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(aeCAPatByLocn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(aeCAPatByLocnChk));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ae_curremr_pat_chart_type_chk1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(aePatQueueEnableDisable));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ae_patlist_by_locn_chart_type_chk1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(aeCAPatByLocnEnableDisable));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ae_curremr_pat_chart_type_chk2));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(aePatQueueEnableDisable));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ae_patlist_by_locn_chart_type_chk2));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(aeCAPatByLocnEnableDisable));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ae_curremr_pat_chart_type_chk3));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(aePatQueueEnableDisable));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ae_patlist_by_locn_chart_type_chk3));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(aeCAPatByLocnEnableDisable));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(mngPatQueue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(mngPatQueueChk));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(MNG_PAT_QUEUE_chart_type_chk1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mngPatQueueEnableDisable));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(MNG_PAT_QUEUE_chart_type_chk2));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mngPatQueueEnableDisable));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(MNG_PAT_QUEUE_chart_type_chk3));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mngPatQueueEnableDisable));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CAPatByLocn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(CAPatByLocnChk));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ca_patlist_by_locn_chart_type_chk1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(CAPatByLocnEnableDisable));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(ca_patlist_by_locn_chart_type_chk2));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(CAPatByLocnEnableDisable));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ca_patlist_by_locn_chart_type_chk3));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(CAPatByLocnEnableDisable));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(caRestUnBilled));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(caRestUnBilledChk));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(isAEStartConsulation));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(isAEStartConsulation));
            _bw.write(_wl_block59Bytes, _wl_block59);

	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
   }
 catch(Exception e)
 {
	//out.println("Exception in CAConsultParamAddModify.jsp : "+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
 }
finally
 {	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);

 }

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MaxConsultationPractitioner.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BackDateConsultationList.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MaxConsultationSpeciality.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AmendConsultationList.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hrs.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MinDurationRecquired.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Mins.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MaxIPConsChargable.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PerDay.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RegularCons.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PerDay.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReferralCons.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PerDay.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AEConsultation.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PromptStartConsultAEPatQueue.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PromptStartConsultAEPatQueueInCA.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OpenPatChrtwithEnc.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OpenPatChrtwithEnc.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OpenPatChrtWithoutEnc.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OpenPatChrtWithoutEnc.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PromptChartTypeForPatChart.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PromptChartTypeForPatChart.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RestrictUnsettledPatient.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
