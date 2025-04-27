package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifyhealthriskfactors extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AddModifyHealthRiskFactors.jsp", 1736157586354L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- \n--------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n08/05/2013\t  IN039490\t\tRamesh G \t\tTerm Set->Select the \'Diagnosis Set\'->Select the \'Diagnosis\'->\n\t\t\t\t\t\t\t\t\t\t\tNow unselect the \'Diagnosis Set\' ->System is not refreshing and on clicking \'Apply\' button, Exception error is displayed.\n08/05/2013\t  IN039498\t\tRamesh G \t\tSystem is not filtering the \'Risk factor Type\' and the \'Diagnosis Set\' list values to single value, \n\t\t\t\t\t\t\t\t\t\t\tsince the system is not allowing the user to modify those fields.\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title></title>\n\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/common.js\" \t\t\tlanguage = \"javascript\" ></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" \tlanguage = \"javascript\" ></script>\t\n\t<Script src =\"../../eCommon/js/CommonLookup.js\" \tlanguage = \"JavaScript\" ></Script>\n\t<script src=\"../../eCommon/js/dchk.js\"\t\t\t\tlanguage = \"javascript\" ></script>\n\t<!--<script src=\"../../eCommon/js/CommonCalendar.js\" \tlanguage = \"javascript\" ></script>-->\n\t<script src=\"../../eCommon/js/DateUtils.js\"\t\t\tlanguage = \"javascript\" ></script>\n\t<script src=\'../../eCA/js/HealthRiskFactors.js\' \t\t\tlanguage = \'javascript\' ></script>\n\t<script src=\"../../ePH/js/DrugNameCommonLookup.js\"\tlanguage = \'javascript\' ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body OnMouseDown=\"CodeArrest()\" onload=\'FocusFirstElement();\' onKeyDown=\"lockKey()\">\n\n<form name= \'HealthRiskFactorsfrm\' id= \'HealthRiskFactorsfrm\' action=\"../../servlet/eCA.HealthRiskFactorsSetupServlet\" method=\"post\" target=\"messageFrame\">\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table align=center width = \'95%\'>\n\t<BR><BR><BR>\n\t\t<tr>\n\t\t\t<td align=center>\n\t\t\t\t<table  width = \'70%\'>\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\t\t\t\n\t\t\t\t\t\t<td width = \'70%\'><input type=\'text\' name=\'risk_factor_id\' id=\'risk_factor_id\' size=\"4\" maxLength=\"4\"  onkeypress=\"return CheckForSpecChars(event)\"  onBlur=\"ChangeUpperCase(this)\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  >\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\t\n\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\n\t\t\t\t\t\t<td width = \'70%\'><input type=\'text\' name=\'risk_fact_desc\' id=\'risk_fact_desc\' size=\"30\" maxLength=\"30\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onBlur=\"makeValidString(this)\" onkeypress=\'return CheckForSpecCharsNoCaps(event)\'>\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t</td>  \n\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\t\t\n\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t<!-- [IN039498] Start. -->\n\t\t\t\t\t\t\t<!-- <select name=\"factor_type\" id=\"factor_type\" onchange = \"selectFactoryType();\" style=\'display:none\'> -->\n\t\t\t\t\t\t\t<select name=\"factor_type\" id=\"factor_type\" onchange = \"selectFactoryType();\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" style=\'display:none\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="style=\"width:160px;display;\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t\t\t\t\t<!-- [IN039498] End. -->\n\t\t\t\t\t\t\t\t<option value=\"\"\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">---";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="---</option>\n\t\t\t\t\t\t\t\t<option  value=\"AG\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">Age Group</option>\n\t\t\t\t\t\t\t\t<option  value=\"AL\"\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">Allergy</option>\n\t\t\t\t\t\t\t\t<option  value=\"BM\"\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">BMI</option>\n\t\t\t\t\t\t\t\t<option  value=\"CC\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">Chief Complaint</option>\n\t\t\t\t\t\t\t\t<option  value=\"CA\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">Discrete Measure</option>\n\t\t\t\t\t\t\t\t<option  value=\"LB\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">Lab Results</option>\n\t\t\t\t\t\t\t\t<option  value=\"OR\"\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">Order Catalog</option>\n\t\t\t\t\t\t\t\t<option  value=\"PH\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">Pharmacy Items</option>\n\t\t\t\t\t\t\t\t<option  value=\"RD\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">Radiology</option>\n\t\t\t\t\t\t\t\t<option  value=\"TS\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">Term Set</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t<input type=\"text\" name=\"factor_type_txt\" id=\"factor_type_txt\" size=\"30\" maxLength=\"30\" readonly value=\"\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" style=\'display\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="style=\'display:none\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="/>  <!-- IN039498 -->\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\t\n\t\t\t\t\t\t<td class=label width = \'30%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'  width = \'70%\'><input type=\"checkbox\" name=\"effstatus\" id=\"effstatus\"  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onclick=\"setEffStauts(this);\"></td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t<!-- Age Group Start -->\n\t\t\t\t\t<tr id=\"ageGroup_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'><select name=\"ageGroup_id\" id=\"ageGroup_id\" onchange = \"\" style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"\" disabled>    --- ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ---</option>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<table width=\"30%\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">High</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"AGRFI\" id=\"AGRFI\" value=\"H\" checked /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"25%\">Average</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"AGRFI\" id=\"AGRFI\" value=\"A\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">Low</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"AGRFI\" id=\"AGRFI\" value=\"L\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"agrfiID\" id=\"agrfiID\" value=\"\"/>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"agRemarks\" id=\"agRemarks\" size=\"50\" maxLength=\"100\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t<!-- Age Group End -->\t\t\n\t\t\t\t<!-- Allergy Start -->\n\t\t\t\t\t<tr id=\"allergy_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<select name=\"adverse_event_id\" id=\"adverse_event_id\" onchange = \"populateData(\'AL_A\',this.value)\" style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">    --- ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ---</option>\n\t\t\t\t\t\t\t\t\t\t\t<!--<option  value=\"1\">Test1</option> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\'class=label >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<select name=\"allergen_id\" id=\"allergen_id\"  style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">    --- ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ---</option>\n\t\t\t\t\t\t\t\t\t\t\t<!--<option  value=\"1\">Test1</option>-->\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\'class=label >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<select id=\"allergenStaus\" name=\"allergenStaus\" id=\"allergenStaus\"  style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"AL\" >All</option>\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"AC\" selected >Active</option>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<table width=\"30%\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">High</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"ALRFI\" id=\"ALRFI\" value=\"H\" checked /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"25%\">Average</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"ALRFI\" id=\"ALRFI\" value=\"A\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">Low</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"ALRFI\" id=\"ALRFI\" value=\"L\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"allergenRFIId\" id=\"allergenRFIId\" value=\"\"/>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"50\" maxLength=\"100\" name=\"allergenRemarks\" id=\"allergenRemarks\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- Allergy End -->\n\n\t\t\t\t<!-- BMI Start -->\n\t\t\t\t\t<tr id=\"bmi_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<!--<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>BMI</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'><select name=\"\" id=\"\" onchange = \"\" style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="---</option>\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"UW\">Underweight</option>\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"OW\">Overweight</option>\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"OB\">Obese</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>-->\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"weight_desc\" id=\"weight_desc\" size=\"50\" maxlength=\"50\" value=\"\"  ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" onBlur=\"if(this.value !=\'\')getWeightDiscreateId(weight_desc)\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" readonly ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="  >\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'weight_id\' id=\'weight_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="disabled";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" onClick=\'getWeightDiscreateId(weight_desc)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"height_desc\" id=\"height_desc\" size=\"50\" maxlength=\"50\" value=\"\"  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" onBlur=\"if(this.value !=\'\')getHeightDiscreateId(height_desc)\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" >\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'height_id\' id=\'height_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" onClick=\'getHeightDiscreateId(height_desc)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- BMI End -->\t\n\n\t\t\t\t<!-- Chief Complaint Start -->\n\t\t\t\t\t<tr id=\"chiefComplaint_\" style=\'display:none\'>\t \t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'complaint_desc\' id=\'complaint_desc\' size=\'50\' maxlength=\'50\'   ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" OnBlur =\'getViewCode(this)\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="   value=\"\" ></input>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'complaint_id\' id=\'complaint_id\' value=\'\'/>\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'ComplaintSrch\' id=\'ComplaintSrch\' value=\'?\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" OnClick=\'getViewCode(this);\' class=\'button\' />\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<table width=\"30%\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">High</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"CCRFI\" id=\"CCRFI\" value=\"H\" checked /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"25%\">Average</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"CCRFI\" id=\"CCRFI\" value=\"A\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">Low</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"CCRFI\" id=\"CCRFI\" value=\"L\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"chiefComplaintRFIId\" id=\"chiefComplaintRFIId\" value=\"\"/>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"50\" maxLength=\"100\" name=\"chiefComplaintRemarks\" id=\"chiefComplaintRemarks\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- Chief Complaint End -->\t\n\n\t\t\t\t<!-- Discrete Measure Start -->\n\t\t\t\t\t<tr id=\"discreteMeasure_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'40%\' nowrap>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"discreate_desc\" id=\"discreate_desc\" size=\"50\" maxlength=\"50\" value=\"\" ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="  onBlur=\"if(this.value !=\'\')getDiscreateId(discreate_desc)\" ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" >\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'discreate_id\' id=\'discreate_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" onClick=\'getDiscreateId(discreate_desc)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t\t<td id=\"dmType\" class=label width = \'30%\' nowrap>&nbsp;\n\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t<!-- Discrete Measure End -->\n\n\t\t\t\t<!-- Lab Results Start -->\n\t\t\t\t\t<tr id=\"labResult_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"lbCatalog_desc\" id=\"lbCatalog_desc\" size=\"50\" maxlength=\"50\" value=\"\" ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" onBlur=\"if(this.value !=\'\')getLBCatalogId(lbCatalog_desc)\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'lbCatalog_id\' id=\'lbCatalog_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" onClick=\'getLBCatalogId(lbCatalog_desc)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- Lab Result End -->\t\n\n\t\t\t\t<!-- Order Catalog Start -->\n\t\t\t\t\t<tr id=\"orderCatalog_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"oRCatalog_desc\" id=\"oRCatalog_desc\" size=\"50\" maxlength=\"50\" value=\"\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" onBlur=\"if(this.value !=\'\')getOrderCatalogId(oRCatalog_desc)\" ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'oRCatalog_id\' id=\'oRCatalog_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" onClick=\'getOrderCatalogId(oRCatalog_desc)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- Order Catalog End -->\t\n\n\t\t\t\t<!-- Pharmacy Items Start -->\n\t\t\t\t<tr id=\"pharmacyItems_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"drug_name\" id=\"drug_name\" size=\"50\" maxlength=\"50\" value=\"\" ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" onBlur=\"if(this.value !=\'\')searchForDrug(drug_name)\" ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'drug_id\' id=\'drug_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" onClick=\'searchForDrug(drug_name)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\'class=label >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<select name=\"pharmacyOperator\" id=\"pharmacyOperator\"  style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"AL\" >All</option>\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"AC\" selected>Active</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"CL\" >Closed</option>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<table width=\"30%\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">High</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"PHRFIId\" id=\"PHRFIId\" value=\"H\" checked /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"25%\">Average</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"PHRFIId\" id=\"PHRFIId\" value=\"A\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">Low</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"PHRFIId\" id=\"PHRFIId\" value=\"L\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pharmacyRFIId\" id=\"pharmacyRFIId\" value=\"\"/>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"50\" maxLength=\"100\" name=\"pharmacyRemarks\" id=\"pharmacyRemarks\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- Pharmacy Items End -->\t\n\n\t\t\t\t<!-- Radiology Start -->\n\t\t\t\t<tr id=\"radiology_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"rDCatalog_desc\" id=\"rDCatalog_desc\" size=\"50\" maxlength=\"50\" value=\"\" ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" onBlur=\"if(this.value !=\'\')getRDCatalogId(rDCatalog_desc)\" ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'rDCatalog_id\' id=\'rDCatalog_id\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" onClick=\'getRDCatalogId(rDCatalog_desc)\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\t\n\t\t\t\t<!-- Radiology End -->\t\n\n\t\t\t\t<!-- Term Set Start -->\n\t\t\t\t\t<tr id=\"termSet_\" style=\'display:none\'>\t\t\n\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\'class=label >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<!-- [IN039490] Start-->\n\t\t\t\t\t\t\t\t\t\t<!-- <select name=\"diagnosisSet_code\" id=\"diagnosisSet_code\"  style=\"width:160px;\"> -->\n\t\t\t\t\t\t\t\t\t\t<select name=\"diagnosisSet_code\" id=\"diagnosisSet_code\"  style=\"width:160px;\" onChange=\"clearTermSetDtl();\">\n\t\t\t\t\t\t\t\t\t\t<!-- [IN039490] End.-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" <!-- [IN039498]-->\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'\'>----- ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" -----</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" <!-- [IN039498]-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<!--<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td> -->\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"termSet_desc\" id=\"termSet_desc\" size=\"50\" maxlength=\"50\" value=\"\" readonly>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\'  name=\'termSet_code\' id=\'termSet_code\' value=\"\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'id\' id=\'id\' value=\'?\'  class=\'button\' ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" onClick=\'show_diagnosis()\' >\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\'class=label >";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<select name=\"termSetOperator\" id=\"termSetOperator\"  style=\"width:160px;\">\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"AL\" >All</option>\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"AC\" selected >Active</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<option  value=\"CL\" >Closed</option>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=label width = \'30%\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\t\t\t\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<table width=\"30%\" border=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">High</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"TSRFI\" id=\"TSRFI\" value=\"H\" checked /></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"25%\">Average</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"TSRFI\" id=\"TSRFI\" value=\"A\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"15%\">Low</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\"><input type=\"radio\" name=\"TSRFI\" id=\"TSRFI\" value=\"L\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"termSetRFIId\" id=\"termSetRFIId\" value=\"\"/>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width = \'30%\' class=label >";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t\t\t\t\t\t\t\t\t<td width = \'70%\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" size=\"50\" name=\"termSetRemarks\" id=\"termSetRemarks\" maxLength=\"100\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t<!-- Term Set End -->\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t\t\t\n\t\t\n\t\t<tr>\t\t\n\t\t\t<td>&nbsp;</td>\t\t\t\n\t\t</tr>\n\t\t<tr id=\"displayGrid_\" style=\'display:none\'>\t\t\n\t\t\t<td align=\"center\">\n\t\t\t<DIV style=\"width:100vw;height:75vh;overflow:auto\">\n\t\t\t\t<table cellpadding=\'3\' id=\"CADisplayGrid\" name = \'CADisplayGrid\' cellspacing=\'0\' border=\'0\' width=\"100%\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"100%\" colspan=\"13\">";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\t\t\t\t\t\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"7%\">&nbsp;</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"5%\">&nbsp;</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"5%\">&nbsp;</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"10%\" colspan=\"2\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"10%\" colspan=\"2\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"70%\" colspan=\"6\">&nbsp;</th>\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"7%\">\n\t\t\t\t\t\t\t<input type=\"button\" value=\"-\" onClick=\"deleteRowDisplayGrid(\'CADisplayGrid\')\"/>&nbsp;\n\t\t\t\t\t\t\t<input type=\"button\" value=\"+\" onClick=\"addRowCADisplayGrid(\'CADisplayGrid\',\'ADD\')\"/>\n\t\t\t\t\t\t</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"5%\">Gender</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"5%\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"5%\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"10%\">";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"28%\">";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></th>\n\t\t\t\t\t\t<th class=\'columnHeadercenter\' width=\"5%\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\t\t\t\t<table>\n\t\t\t</DIV>\n\t\t\t</td>\t\t\t\n\t\t</tr>\n\t\t\n\t</table>\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"/>\n\t<input type=\"hidden\" name=\"patientSex\" id=\"patientSex\" value=\"\"/>\n\t<input type=\"hidden\" name=\"factor_type_\" id=\"factor_type_\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t<input type=\"hidden\" name=\"ageGroup_id_\" id=\"ageGroup_id_\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<input type=\"hidden\" name=\"allergen_id_\" id=\"allergen_id_\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<input type=\"hidden\" name=\"diagnosisSet_code_\" id=\"diagnosisSet_code_\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t<input type=\"hidden\" name=\"eff_status\" id=\"eff_status\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"/>\n\t<input type=\"hidden\" name=\"rowId\" id=\"rowId\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"/>\n\t<input type=\"hidden\" name=\"operator_ind\" id=\"operator_ind\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"/>\n\t<input type=\"hidden\" name=\"discreateUOM\" id=\"discreateUOM\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"/>\n\t<input type=\"hidden\" name=\"factor_set_id\" id=\"factor_set_id\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"/>\n\t<input type=\"hidden\" name=\"factor_code\" id=\"factor_code\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\"/>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\"/>\n\t\n\t<script>\n\tif(\"AG\"==\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\"){\t\n\t\tdocument.getElementById(\"ageGroup_\").style=\'display\';\t\t\t\n\t\tdocument.HealthRiskFactorsfrm.factor_type.value=\"AG\";\n\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Age Group\"; //[IN039498]\n\t\tpopulateData(\"AG\",\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\",\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\");\t\t\t\n\t\tvar agradioButtons=document.getElementsByName(\"AGRFI\");\t\t\t\t\t\n\t\tfor(var i=0;i<agradioButtons.length;i++){\t\t\t\t\t\t\n\t\t\tif(agradioButtons[i].value==\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"){\n\t\t\t\tagradioButtons[i].checked=true;\n\t\t\t}\n\t\t}\n\t}else if(\"AL\"==\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\"){\n\t\tdocument.getElementById(\"allergy_\").style=\'display\';\n\t\tdocument.HealthRiskFactorsfrm.factor_type.value=\"AL\";\n\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Allergy\"; //[IN039498]\n\t\tdocument.HealthRiskFactorsfrm.allergenStaus.value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\";\n\t\tpopulateData(\"AL_Query\",\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\");\n\t\tvar agradioButtons=document.getElementsByName(\"ALRFI\");\t\t\t\t\t\n\t\tfor(var i=0;i<agradioButtons.length;i++){\t\t\t\t\t\t\n\t\t\tif(agradioButtons[i].value==\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"){\n\t\t\t\tagradioButtons[i].checked=true;\n\t\t\t}\n\t\t}\n\t}else if(\"CC\"==\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"){\n\t\tdocument.getElementById(\"chiefComplaint_\").style=\'display\';\n\t\tdocument.HealthRiskFactorsfrm.factor_type.value=\"CC\";\n\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Chief Complaint\"; //[IN039498]\n\t\tpopulateData(\"CC\",\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\");\n\t\tvar agradioButtons=document.getElementsByName(\"CCRFI\");\t\t\t\t\t\n\t\tfor(var i=0;i<agradioButtons.length;i++){\t\t\t\t\t\t\n\t\t\tif(agradioButtons[i].value==\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"){\n\t\t\t\tagradioButtons[i].checked=true;\n\t\t\t}\n\t\t}\n\t}else if(\"PH\"==\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"){\n\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Pharmacy Items\"; //[IN039498]\n\t\tdocument.getElementById(\"pharmacyItems_\").style=\'display\';\n\t\tdocument.HealthRiskFactorsfrm.factor_type.value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\";\n\t\tdocument.HealthRiskFactorsfrm.factor_set_id.value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\";\n\t\tdocument.HealthRiskFactorsfrm.factor_code.value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\";\n\t\t\n\t\tpopulateData(\"PH\",\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\");\n\t\t\n\t\tvar agradioButtons=document.getElementsByName(\"PHRFIId\");\t\t\t\t\t\n\t\tfor(var i=0;i<agradioButtons.length;i++){\t\t\t\t\t\t\n\t\t\tif(agradioButtons[i].value==\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\"){\n\t\t\t\tagradioButtons[i].checked=true;\n\t\t\t}\n\t\t}\n\t\tdocument.HealthRiskFactorsfrm.pharmacyOperator.value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\";\n\n\t}else if(\"TS\"==\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"){\n\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Term Set\"; //[IN039498]\n\t\tdocument.getElementById(\"termSet_\").style=\'display\';\n\t\tdocument.HealthRiskFactorsfrm.factor_type.value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\";\n\t\t\n\t\tdocument.HealthRiskFactorsfrm.diagnosisSet_code.value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\";\t\t\n\t\t\n\t\tpopulateData(\"TS\",\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\");\n\t\t\n\t\tvar agradioButtons=document.getElementsByName(\"TSRFI\");\t\t\t\t\t\n\t\tfor(var i=0;i<agradioButtons.length;i++){\t\t\t\t\t\t\n\t\t\tif(agradioButtons[i].value==\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"){\n\t\t\t\tagradioButtons[i].checked=true;\n\t\t\t}\n\t\t}\n\t\tdocument.HealthRiskFactorsfrm.termSetOperator.value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\";\n\n\t}else if(\"CA\"==\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" || \"LB\"==\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" || \"OR\"==\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" || \"RD\"==\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" || \"BM\"==\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" ){\t\t\n\t\tdocument.getElementById(\"displayGrid_\").style=\'display\';\t\t\t\n\t\tdocument.HealthRiskFactorsfrm.factor_type.value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\";\n\t\tif(\"CA\"==\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"){\n\t\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Discrete Measure\"; //[IN039498]\n\t\t\tdocument.getElementById(\"discreteMeasure_\").style=\'display\';\n\t\t\tpopulateData(\"CA_DMS\",\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\");\n\t\t}else if(\"LB\"==\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"){\n\t\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Lab Results\"; //[IN039498]\n\t\t\tdocument.getElementById(\"labResult_\").style=\'display\';\n\t\t\tpopulateData(\"LB_OCC\",\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\");\n\t\t}else if(\"OR\"==\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"){\n\t\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Order Catalog\"; //[IN039498]\n\t\t\tdocument.getElementById(\"orderCatalog_\").style=\'display\';\n\t\t\tpopulateData(\"OR_OCC\",\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\");\n\t\t}else if(\"RD\"==\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"){\n\t\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"Radiology\"; //[IN039498]\n\t\t\tdocument.getElementById(\"radiology_\").style=\'display\';\n\t\t\tpopulateData(\"RD_OCC\",\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\");\n\t\t}\n\t\telse if(\"BM\"==\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"){\n\t\t\tdocument.HealthRiskFactorsfrm.factor_type_txt.value=\"BMI\"; //[IN039498]\n\t\t\tdocument.getElementById(\"bmi_\").style=\'display\';\n\t\t\tpopulateData(\"BM\",\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\",\"WEIGHT\");\n\t\t\tpopulateData(\"BM\",\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\",\"HEIGHT\");\n\t\t}\n\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\t\t\n\t\t\taddRowCADisplayGrid(\"CADisplayGrid\",\"UPDATE\",";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =");\n\t\t\tdocument.getElementById(\"gender\"+";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 =").value = \"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"; \n\t\t\t\n\t\t\tif(\"Y\"==\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"){\n\t\t\t\tdocument.getElementById(\"allAge\"+";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =").checked = true;\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"allAge\"+";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =").checked = false;\n\t\t\t}\n\t\t\tclickAllAge(document.getElementById(\"allAge\"+";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="),";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 =");\n\t\t\tdocument.getElementById(\"startAge\"+";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\";\n\t\t\tdocument.getElementById(\"startAgeUnit\"+";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\";\n\t\t\tdocument.getElementById(\"endAge\"+";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\";\n\t\t\tdocument.getElementById(\"endAgeUnit\"+";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\";\n\t\t\tdocument.getElementById(\"operator\"+";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\";\n\t\t\toperatorChage(document.getElementById(\"operator\"+";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =");\t\t\t\n\t\t\tdocument.getElementById(\"operatorFromValue\"+";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\";\n\t\t\tif(\"B\"==\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\"){\n\t\t\t\tdocument.getElementById(\"operatorToValue\"+";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\";\n\t\t\t}\n\t\t\tif(\"PV\"==\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\"){\n\t\t\t\tdocument.getElementById(\"operatorIncreDecre\"+";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\";\n\t\t\t\tdocument.getElementById(\"operatorOccur\"+";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\";\n\t\t\t}\n\t\t\tvar agradioButtons=eval(\'document.HealthRiskFactorsfrm.riskFactorInd\'+";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =");\n\t\t\tfor(var i=0;i<agradioButtons.length;i++){\t\t\t\t\t\t\n\t\t\t\tif(agradioButtons[i].value==\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\")\n\t\t\t\t\tagradioButtons[i].checked=true;\n\t\t\t}\n\t\t\tdocument.getElementById(\"riskFactorIndValue\"+";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =").value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\";\n\t\t\tdocument.getElementById(\"remarks\"+";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\";\n\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\t\n\t}\n\t</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con				= null;
	ResultSet rs				= null;
	PreparedStatement pstmt		= null;
	
	String mode	   = request.getParameter( "mode" ) ;
	String toDate 			= "";
	String locale			= "";
	String systime 			= "";
	String operator_ind	 	= "";
	String fcator_ind		= "";
	String factor_set_id	= "";
	String factor_code		= "";
	String risk_factor_id	= "";
	String rfiReadOnlyYN	= "";
	String risk_fact_desc	= "";
	String rfdDisabled		= "";
	String factor_type 		= "";
	String rftReadOnlyYN	= "";
	String eff_status		= "E";
	String enabled_checked	= "checked";
	String rowId			= "0";
	
	
	String ageGroup_id		= "";
	String agrfi			= "";
	String ageRemarks		= "";
	
	String allergenId		= "";
	String allergenRFIId	= "";
	String allergenRemarks	= "";
	String allergenStaus	= "";
	
	String chiefComplaintId			= "";
	String chiefComplaintRFIId		= "";
	String chiefComplaintRemarks	= "";
	
	String drugId			="";
	String pharmacyRFIId	= "";
	String pharmacyRemarks	= "";
	String pharmacyOperator	= "";
	
	String diagnosisSetId 	= "";
	String termSetCode		= "";
	String termSetOperator	= "";
	String termSetRFIId		= "";
	String termSetRemarks	= "";	
	
	String discreateMeaserId = "";
	
	ArrayList gridDtls = new ArrayList();
	String discreateUOM		 = "";
	try{
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale 	= (String) p.getProperty("LOCALE");
		toDate 	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		systime	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		
		if("update".equals(mode)){
			rfiReadOnlyYN		= "ReadOnly";
			rfdDisabled 		= "disabled";
			rftReadOnlyYN		= "disabled='disabled'";
			risk_factor_id = request.getParameter("risk_factor_id")==null?"":(String)request.getParameter("risk_factor_id");
			HealthRiskFactorsBean bean = new HealthRiskFactorsBean();
			bean.getHealthRiskFactorsDeatils(risk_factor_id);
			
			factor_type			= (String)bean.getFactorType();
			risk_fact_desc		= (String)bean.getRiskFactorDesc();		
			eff_status			= (String)bean.getEffStatus();
			if("E".equals(eff_status))
				enabled_checked = "checked";
			else
				enabled_checked = "";
			
			if("AG".equals(factor_type)){
				ageGroup_id				= (bean.getAgeGroupId())==null?"":(String)bean.getAgeGroupId();
				agrfi					= (bean.getAgrfi())==null?"":(String)bean.getAgrfi();
				ageRemarks				= (bean.getAgRemarks())==null?"":(String)bean.getAgRemarks();
			}else if("AL".equals(factor_type)){
				allergenId				= (bean.getAllergenId())==null?"":(String)bean.getAllergenId();
				allergenRFIId			= (bean.getAllergenRFIId())==null?"":(String)bean.getAllergenRFIId();
				allergenRemarks			= (bean.getAllergenRemarks())==null?"":(String)bean.getAllergenRemarks();
				allergenStaus			= (bean.getAllergenStaus())==null?"":(String)bean.getAllergenStaus();
			}else if("CC".equals(factor_type)){
				chiefComplaintId		= (bean.getChiefComplaintId())==null?"":(String)bean.getChiefComplaintId();
				chiefComplaintRFIId		= (bean.getChiefComplaintRFIId())==null?"":(String)bean.getChiefComplaintRFIId();
				chiefComplaintRemarks	= (bean.getChiefComplaintRemarks())==null?"":(String)bean.getChiefComplaintRemarks();
			}else if("PH".equals(factor_type)){
				fcator_ind				= (bean.getRiskFactorInd())==null?"":(String)bean.getRiskFactorInd();
				factor_set_id			= (bean.getRiskFactorSetId())==null?"":(String)bean.getRiskFactorSetId();
				factor_code				= (bean.getRiskFactorCode())==null?"":(String)bean.getRiskFactorCode();
				
				drugId					= (bean.getDrugId())==null?"":(String)bean.getDrugId();
				pharmacyRFIId			= (bean.getPharmacyRFIId())==null?"":(String)bean.getPharmacyRFIId();
				pharmacyRemarks			= (bean.getPharmacyRemarks())==null?"":(String)bean.getPharmacyRemarks();
				pharmacyOperator		= (bean.getPharmacyOperator())==null?"":(String)bean.getPharmacyOperator();	
				
			}else if("TS".equals(factor_type)){
				fcator_ind				= (bean.getRiskFactorInd())==null?"":(String)bean.getRiskFactorInd();
				factor_set_id			= (bean.getRiskFactorSetId())==null?"":(String)bean.getRiskFactorSetId();
				factor_code				= (bean.getRiskFactorCode())==null?"":(String)bean.getRiskFactorCode();
				
				diagnosisSetId 			= (bean.getDiagnosisSetId())==null?"":(String)bean.getDiagnosisSetId();
				termSetCode				= (bean.getTermSetCode())==null?"":(String)bean.getTermSetCode();
				termSetOperator			= (bean.getTermSetOperator())==null?"":(String)bean.getTermSetOperator();
				termSetRFIId			= (bean.getTermSetRFIId())==null?"":(String)bean.getTermSetRFIId();
				termSetRemarks			= (bean.getTermSetRemarks())==null?"":(String)bean.getTermSetRemarks();	
				
			}else if("CA".equals(factor_type) || "LB".equals(factor_type) || "OR".equals(factor_type) || "RD".equals(factor_type) || "BM".equals(factor_type) ){
				fcator_ind				= (bean.getRiskFactorInd())==null?"":(String)bean.getRiskFactorInd();
				factor_set_id			= (bean.getRiskFactorSetId())==null?"":(String)bean.getRiskFactorSetId();
				factor_code				= (bean.getRiskFactorCode())==null?"":(String)bean.getRiskFactorCode();
				
				discreateMeaserId		= (bean.getDiscreateMeaserId())==null?"":(String)bean.getDiscreateMeaserId();
				operator_ind			= (bean.getDiscreateMeaserType())==null?"":(String)bean.getDiscreateMeaserType();
				gridDtls  				= (ArrayList)bean.getGridDtls();
				rowId					= ((gridDtls.size())-1)+"";
			}
		}
		//HealthRiskIndicatorBean indiBean = new HealthRiskIndicatorBean();
		//ArrayList indicatorList = indiBean.getRiskIndicatorCode();
	}catch(Exception e){
			e.printStackTrace(System.err);
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(risk_factor_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rfiReadOnlyYN));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(risk_fact_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if("update".equals(mode)){
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rftReadOnlyYN));
            _bw.write(_wl_block29Bytes, _wl_block29);
if("update".equals(mode)){
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(enabled_checked));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ageRemarks));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(allergenRemarks));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
if("insert".equals(mode)){
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if("insert".equals(mode)){
            _bw.write(_wl_block56Bytes, _wl_block56);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
if("insert".equals(mode)){
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(chiefComplaintRemarks));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
if("insert".equals(mode)){
            _bw.write(_wl_block67Bytes, _wl_block67);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block68Bytes, _wl_block68);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
if("insert".equals(mode)){
            _bw.write(_wl_block71Bytes, _wl_block71);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if("insert".equals(mode)){
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block76Bytes, _wl_block76);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
if("insert".equals(mode)){
            _bw.write(_wl_block79Bytes, _wl_block79);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block80Bytes, _wl_block80);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(pharmacyRemarks));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
if("insert".equals(mode)){
            _bw.write(_wl_block87Bytes, _wl_block87);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block88Bytes, _wl_block88);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
if(diagnosisSetId=="" && diagnosisSetId.equals("")){
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
}
            _bw.write(_wl_block93Bytes, _wl_block93);

												try{
													con = ConnectionManager.getConnection(request);
													//[IN039498] Start.
													String temSetQuery ="";
													if(diagnosisSetId!="" && !diagnosisSetId.equals("")){
														temSetQuery="WHERE TERM_SET_ID='"+diagnosisSetId+"'";
													}
													//pstmt = con.prepareStatement("SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET ORDER BY TERM_SET_DESC");
													pstmt = con.prepareStatement("SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET "+temSetQuery+" ORDER BY TERM_SET_DESC");
													//[IN039498] End.
													rs = pstmt.executeQuery();
													while(rs.next())
													{
														String code = rs.getString("term_set_id");
														String desc = rs.getString("term_set_desc");
														out.print("<option value='"+code+"' "+rftReadOnlyYN+">"+desc+"</option>");
														code = null;
														desc = null;
													}
												}catch(Exception e){
												
												}finally{
													if(pstmt!=null)pstmt.close();
													if(rs!=null)rs.close();
													if(con!=null)con.close();
												}
												
											
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
if("update".equals(mode)){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(termSetRemarks));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(ageGroup_id));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(allergenId));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(diagnosisSetId));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(rowId));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(operator_ind));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(discreateUOM));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(factor_set_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(ageGroup_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(agrfi));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(allergenStaus));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(allergenId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(allergenRFIId));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(chiefComplaintId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(chiefComplaintRFIId));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(factor_set_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(drugId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(pharmacyRFIId));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(pharmacyOperator));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(factor_set_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(diagnosisSetId));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(termSetCode));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(diagnosisSetId));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(termSetRFIId));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(termSetOperator));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(factor_set_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(discreateMeaserId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(factor_type));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(factor_set_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(factor_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block162Bytes, _wl_block162);

			for(int i=0;i<gridDtls.size();i++){
				HashMap gridHash=new HashMap();
				gridHash = (HashMap)gridDtls.get(i);
				
				String gender				= (gridHash.get("PATIENT_SEX"))==null?"":(String)gridHash.get("PATIENT_SEX");
				String allAges				= (gridHash.get("ALL_AGE_YN"))==null?"":(String)gridHash.get("ALL_AGE_YN");
				String starAge				= (gridHash.get("START_AGE"))==null?"":(String)gridHash.get("START_AGE");
				String starAgeUnit			= (gridHash.get("START_AGE_UNITS"))==null?"":(String)gridHash.get("START_AGE_UNITS");
				String endAge				= (gridHash.get("END_AGE"))==null?"":(String)gridHash.get("END_AGE");
				String endAgeUnit			= (gridHash.get("END_AGE_UNITS"))==null?"":(String)gridHash.get("END_AGE_UNITS");
				String operator				= (gridHash.get("RISK_FACTOR_OPERATOR"))==null?"":(String)gridHash.get("RISK_FACTOR_OPERATOR");
				String operatorFromValue	= (gridHash.get("RISK_FACTOR_FRM_VAL"))==null?"":(String)gridHash.get("RISK_FACTOR_FRM_VAL");
				String operatorToValue		= (gridHash.get("RISK_FACTOR_TO_VAL"))==null?"":(String)gridHash.get("RISK_FACTOR_TO_VAL");
				String riskFactorInd		= (gridHash.get("RISK_FACTOR_SCORE_IND"))==null?"":(String)gridHash.get("RISK_FACTOR_SCORE_IND");
				String remarks				= (gridHash.get("RISK_FACTOR_MESG"))==null?"":(String)gridHash.get("RISK_FACTOR_MESG");
				String operatorFromUnit		= (gridHash.get("RISK_FACTOR_FRM_UNIT"))==null?"":(String)gridHash.get("RISK_FACTOR_FRM_UNIT");
				String operatorToUnit		= (gridHash.get("RISK_FACTOR_TO_UNIT"))==null?"":(String)gridHash.get("RISK_FACTOR_TO_UNIT");
				String riskFactorOccur		= (gridHash.get("RISK_FACTOR_OCCUR"))==null?"":(String)gridHash.get("RISK_FACTOR_OCCUR");		
		
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(allAges));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(starAge));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(starAgeUnit));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(endAge));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(endAgeUnit));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(operator));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(operatorFromValue));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(operator));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(operatorToValue));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(operator));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(operatorFromUnit));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(riskFactorOccur));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(riskFactorInd));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(riskFactorInd));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(i));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block188Bytes, _wl_block188);
}
            _bw.write(_wl_block189Bytes, _wl_block189);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RiskFactorType.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AgeGrp.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RiskFactorIndicator.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AdverseEventType.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Allergen.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Status.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RiskFactorIndicator.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Weight.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Height.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChiefComplaint.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RiskFactorIndicator.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiscreteMeasure.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LabResults.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OrderCatalog.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DrugName.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Status.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RiskFactorIndicator.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Radiology.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisSet.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TermSet.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Status.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RiskFactorIndicator.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RuleforRiskFactor.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Start.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.End.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllAges.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Age.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Units.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Age.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Units.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Operator.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.High.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Average.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Low.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Remarks.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }
}
