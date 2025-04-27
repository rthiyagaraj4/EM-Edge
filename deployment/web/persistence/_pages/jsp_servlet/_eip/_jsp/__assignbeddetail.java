package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __assignbeddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AssignBedDetail.jsp", 1742367191228L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head> \n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../js/AssignBedDetail.js\' language=\'javascript\'></script>\n\t<script src=\'../js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction ChkNullVal(obj, hiddenCode)\n{\n\tif(obj.value == \'\')\n\t{\n\t\tdocument.forms[0].nursing_unit_desc.value\t= \'\';\n\t\tdocument.forms[0].nursing_unit.value\t\t= \'\';\n\t\tdocument.forms[0].nursing_unit_code.value\t= \'\';\n\t\tvar j=1;\n\t\twhile(j<document.forms[0].service.length)\n\t\t{\n\t\t\tdocument.forms[0].service.remove(j);\n\t\t}\n\t\tdocument.forms[0].Splcode_desc.value\t\t= \'\';\n\t\tdocument.forms[0].Splcode.value\t\t\t\t= \'\';\n\t\tdocument.forms[0].practid.value\t\t\t\t= \'\';\n\t\tdocument.forms[0].pract_desc.value\t\t\t= \'\';\n\t\tdocument.forms[0].team_id.value\t\t\t\t= \'\';\n\t\tdocument.forms[0].to_bed_no.value\t\t\t= \'\';\n\t\tdocument.forms[0].to_room_no.value\t\t\t= \'\';\n\t}\n}\n\nfunction dialogClose()\n{\n\twindow.close();\n}\n\n</script>\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"\'>\n\t<FORM name=\'assign_bed\' id=\'assign_bed\' method=post action=\'../../servlet/eIP.AssignBedServlet\'  target=\"messageFrame\" onLoad=\'PopulateMedicalTeam();\'>\n\t<table cellspacing=0 cellpadding=\'3\' align=\'center\' width=\'100%\' border=\'0\'>\n\t\t<tr><th align=\"left\" style=\"color: white;\" class=\'columnheader\' ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="colspan = \'4\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="colspan = \'7\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </th></tr>\n\t\t<TR>\n\t\t\t<TD class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </TD>\n\t\t\t<TD class=\'querydata\' width=\"25%\"> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" <INPUT TYPE=\"hidden\"  name=\"admission_date_time\" id=\"admission_date_time\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></TD>\n\t\t\t<TD class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TD>\n\t\t\t<TD class=\'querydata\' width=\"25%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" <INPUT TYPE=\"hidden\"  name=\"admission_type_short_desc\" id=\"admission_type_short_desc\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></TD>\n\t\t</TR>\n\t\t<!-- Added by Dharma on Oct 27th against HSA-CRF-0181 [IN:049541] Start -->\n\t\t<TR>\n\t\t\t<TD class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </TD>\n\t\t\t<TD class=\'querydata\' width=\"25%\"> <input type=\'text\' name=\"weight_on_admission\" id=\"weight_on_admission\"   size=15  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="onKeyPress=\'return(ChkNumberInput(this,event,0))\' maxlength=5 onblur=\"return(ChkNumberInput(this,event,0))\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="  onKeyPress=\'return allowValidNumber(this,event,3,3);\' onblur=\" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3);\" maxlength=7 ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="onfocusout=\"calculateBmi();\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" > &nbsp; ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" <input type=\'hidden\' name=\'is_validate_weight_on_admission\' id=\'is_validate_weight_on_admission\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'/> <input type=\'hidden\' name=\'weight_on_admission_unit\' id=\'weight_on_admission_unit\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'/></TD>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<TD class=\'label\' width=\"25%\" colspan=2>&nbsp;</TD>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<TD class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" </TD>\n\t\t\t<TD class=\'querydata\' width=\"25%\"> <input type=\'text\' name=\"height_on_admission\" id=\"height_on_admission\"onKeyPress=\'return allowValidNumber(this,event,3,3);\' onblur=\" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3); \" onfocusout=\"calculateBmi();\" maxlength=7  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" > &nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  \n\t\t\t<input type=\'hidden\' name=\'height_on_admission_unit\' id=\'height_on_admission_unit\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'/></TD>\n\t\t\t\n\t\t\n\t\t\t<TD class=\'label\' width=\"15%\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </TD>\n\t\t\t<TD class=\'querydata\' width=\"25%\"> <input type=\'text\' name=\"bmi\" id=\"bmi\"   size=15    maxlength=7  value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" readonly ></TD>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<input type=\'hidden\' name=\'is_validate_height_on_admission\' id=\'is_validate_height_on_admission\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'/> \n\t\t\t<!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->\n\t\t</TR>\n\t\t<!-- Added by Dharma on Oct 27th against HSA-CRF-0181 [IN:049541] End -->\n\t\t<tr><th align=\"left\" style=\" color: white;\" class=\'columnheader\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </th></tr>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<TR>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</TD>\n\t\t\t<TD class=\'fields\' ><input type=\'text\' name=\"nursing_unit_desc\" id=\"nursing_unit_desc\"  maxlength=15 size=15 tabindex=\'1\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onblur=\"beforeGetNursingUnit(this, \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" onchange=\"ChkNullVal(this,document.forms[0].nurs_desc_hid);\" ><input type=\'button\' class=\'BUTTON\' name=\"nursing_unit_lookup\" id=\"nursing_unit_lookup\" value=\'?\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" onClick=\"getNursingUnit(nursing_unit_desc, \'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');\" tabindex=\'2\'><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"><input type=\'hidden\' name=\'to_speciality_code\' id=\'to_speciality_code\' value=\'\'></input><INPUT TYPE=\"hidden\" readOnly name=\"to_pract_team_id\" id=\"to_pract_team_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"><input type=\'hidden\' name=\'nurs_desc_hid\' id=\'nurs_desc_hid\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></td>\n\t\t\t<td class=\"label\" width=\"20%\" >";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t<td class=\'fields\'><select name=\"service\" id=\"service\" ><option value=\"\">--- ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" ---</option>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</select><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</TD>\n\t\t\t<TD class=\'fields\'><input type=text name=\'Splcode_desc\' id=\'Splcode_desc\' maxlength=15 size=15 width=\"15\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onFocus=\"checkForNursing();\"  onblur=\"beforeGetSpecialty(this, \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\"><input type=button name=\'Splcode_lookup\' id=\'Splcode_lookup\' value=\'?\' class=button onClick=\"getSpecialty(Splcode_desc, \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\"><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"><input type=hidden name=\'Splcode\' id=\'Splcode\' width=\"15\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><INPUT TYPE=\"hidden\" readOnly name=\"speciality\" id=\"speciality\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><input type=hidden name=\"spec_desc_hid\" id=\"spec_desc_hid\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"></td><td colspan=\'4\'></td>\n\t\t</tr>\n\t\t<TR>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</TD>\n\t\t\t<TD class=\'querydata\' >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</TD>\n\t\t\t<TD class=\'label\' width=\'15%\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</TD>\n\t\t\t<TD class=\'fields\' ><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" size=\'30\' maxlength=\'30\' onblur=\"beforeGetPractitioner(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\" onFocus=\"checkForValues();\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" readonly><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onclick = \"getPractitionerLocal(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\');\"><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"><input type=hidden name=\"pract_desc_hid\" id=\"pract_desc_hid\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></td>\t\t\t\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</TD><TD class=\'fields\' ><select name=\"team_id\" id=\"team_id\" onChange=\"getMedicalTeamHead(this);\"><option value=\'\' selected>--- ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\t\t\t\t\n\t\t\t</select><input type=\"hidden\" name=\"selecTeam\" id=\"selecTeam\"></TD>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</TD><TD class=\'querydata\' >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="<INPUT TYPE=\"hidden\" readOnly name=\"ot_date_time\" id=\"ot_date_time\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"></TD>\n\t\t</TR>\n\t\t<!-- Below line modified for this incident [23474] --->\n\t\t<TR>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</TD>\n\t\t\t<TD class=\'fields\'><select name=\'Bedcode\' id=\'Bedcode\'  onChange=\'onBedClassChange();clearBedDetailsOnly();populateDailyRate(this)\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" \n\t\t\tdir=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'><option value=\'\' selected >--- ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" ---\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</TD>\n\t\t<TD class=\'fields\' ><select name=\'Bedtype\' id=\'Bedtype\'  onChange=\'clearBedDetailsOnly();populateDailyRate(this)\' ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =">\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t<script>\n\t\t\t\tvar obj = document.forms[0].Bedtype;\n\t\t\t\tvar length  = obj.length;\n\t\t\t\tfor(i=0;i<length;i++)\n\t\t\t\t\t{\n\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t}\n\t\t\t\t\tvar opt= document.createElement(\'Option\');\n\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"; \n\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\topt.selected = true;\n\t\t\t\t\tobj.add(opt)\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" ---\n\t\t\t</option>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</select><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t</TR>\n\n\t\t<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->\n\t\t<TR>\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</TD>\n\t\t\t<TD class=\'fields\' ><input type=\"text\" name=\"to_bed_no\" id=\"to_bed_no\" readOnly size=8 maxlength=8 value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' onBlur=\"ChangeUpperCase(this);getRoomNo(this);checkForBedNo();check_bed_alcn_val(this);";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="chkforVacantNormalBed();";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" onKeyPress=\'return CheckForSpecChars(event)\'><input name=\"bed_avail_chart\" id=\"bed_avail_chart\" type=\"button\" class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="onblur=\"chkforVacantNormalBed()\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" onclick=\"callBedAvailChart();\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="disabled";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t\t<TD class=\'label\'  >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</TD>\n\t\t\t<TD class=\'fields\' ><input type=\"text\" name=\"to_room_no\" id=\"to_room_no\" value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' size=10 maxlength=10 readonly onBlur=\"specialChar(this,\'Char\')\"></TD>\n\t</TR>\n\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t<tr>\t\n\t\t<TD class=\'label\' width=\'15%\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</TD>\n\t\t<TD class=\'fields\' ><!-- <INPUT TYPE=\"text\" name=\"bed_alloc_date_time\" id=\"bed_alloc_date_time\" id=\"bedallocdate\" size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" onBlur=\'doDateTimeChk123(this)\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\'  disabled >-->\n\t\t<INPUT TYPE=\"text\" name=\"bed_alloc_date_time\" id=\"bed_alloc_date_time\" id=\"bedallocdate\" size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"  onKeyPress=\'return(ChkNumberInput1(this,event,2))\'  disabled ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'> </img> </TD>\n\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t<TD class=\'label\' >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</TD>\n\t\t\t<TD class=\'fields\'> <!--<INPUT TYPE=\"text\" name=\"arrival_date_time\" id=\"arrival_date_time\" id=\"bedarrvldate\" size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" onBlur=\'doDateTimeChk123(this)\' onKeyPress=\'return(ChkNumberInput1(this,event,2))\' disabled >--><INPUT TYPE=\"text\" name=\"arrival_date_time\" id=\"arrival_date_time\" id=\"bedarrvldate\" size=\"16\" maxlength=\"16\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"  onKeyPress=\'return(ChkNumberInput1(this,event,2))\' disabled >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' > </img> </TD>\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t<TD class=\'label\'  width=\'15%\' ></TD>\n\t\t\t<TD class=\'querydata\'></TD>\n\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\n\t</TR>\n\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</TD>\n\t\t\t<TD colspan=\'4\' class=\'fields\'><INPUT TYPE=\"text\" name=\"daily_rate\" id=\"daily_rate\" readOnly ></TD>\n\t\t</TR>\n\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t<TR>\n\t\t\t<TD class=\'label\' colspan=\'4\'><INPUT TYPE=\"hidden\" name=\"daily_rate\" id=\"daily_rate\" readOnly ></TD>\n\t\t</TR>\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t</TABLE>\n\t<table cellspacing=\'0\' cellpadding=\'3\' align=\'center\' width=\'100%\' border=\'0\'>\n\t\t<TR >\n\t\t\t<TD class=\"label\" width=\"25%\"></TD>\n\t\t\t<TD class=\"fields\" width=\"25%\"><INPUT TYPE=\"button\" style=\"visibility:hidden\" value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' class=\'button\' onClick=\'showValuables()\'></TD>\n\t\t\t<TD class=\"label\" width=\"25%\"></TD>\n\t\t\t<TD  class=\"fields\" width=\"25%\"><input type=\'hidden\' name=\"referral_id\" id=\"referral_id\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\n\t\t\t\n\t\t\t<INPUT TYPE=\"button\" name=\"referral\" id=\"referral\" value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' class=\'button\' onClick=\'refDet(document.forms[0].referral_id)\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' name=\"OthAppt\" class=\'button\' onClick=\'showOtherAppointments()\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="<INPUT TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' name=\"record\" class=\'button\' onClick=\'Apply()\'><INPUT class=\'button\' TYPE=\"button\" value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' onClick=\'closeWin()\'></TD>\n\t\t</TR>\n\t</TABLE>\n\t<!--hidden value for bed type code and bed class code has been modified -->\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" >\n\t<input type=\'hidden\' name=\'enable_height_bmi_pat_cls\' id=\'enable_height_bmi_pat_cls\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" ><!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->\n\t<input type=\'hidden\' name=\'isHeightAndBmiEnable\' id=\'isHeightAndBmiEnable\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" ><!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->\n\t<input type=\'hidden\' name=\'room_no\' id=\'room_no\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" >\n\t<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" >\n\t<input type=\'hidden\' name=\'specialty_code\' id=\'specialty_code\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" >\n\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" >\n\t<input type=\'hidden\' name=\'year\' id=\'year\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" >\n\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" >\n\t<input type=\'hidden\' name=\'p_patient_id\' id=\'p_patient_id\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" >\n\t<input type=\'hidden\' name=\'sdate\' id=\'sdate\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\'hidden\' name=\'trn_date\' id=\'trn_date\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\'hidden\' name=\'bed_type_code\' id=\'bed_type_code\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\"\">\n\t<input type=\'hidden\' name=\'bed_class_code\' id=\'bed_class_code\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=\'hidden\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t<input type=\'hidden\' name=\'bl_operational\' id=\'bl_operational\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"> \n\t<input type=\'hidden\' name=\'bedtypecode\' id=\'bedtypecode\' value=\"\">\n\t<input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" >\n\t<input type=\'hidden\' name=\'from_nursing_unit_code\' id=\'from_nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" >\n\t<input type=\'hidden\' name=\"nursing_unit\" id=\"nursing_unit\" width=\"15\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" > \n\t<input type=\'hidden\' name=\'chg_nurs_unit_in_assign_bed_yn\' id=\'chg_nurs_unit_in_assign_bed_yn\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\'hidden\' name=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\"hidden\" name=\"modified_date_val\" id=\"modified_date_val\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"> \n\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" > \n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'ASSIGN_BED\'>\n\t<input type=\'hidden\' name=\'BalnkFlag\' id=\'BalnkFlag\' value=\'Y\'>\n\t<input type=\'hidden\' name=\'dcunitcode\' id=\'dcunitcode\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t<input type=\'hidden\' name=\'patient_gender\' id=\'patient_gender\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t<input type=\'hidden\' name=\'exp_discharge_date_time\' id=\'exp_discharge_date_time\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\t<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t<input type=\'hidden\' name=\'orig_blocked_bed_no\' id=\'orig_blocked_bed_no\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t<input type=\'hidden\' name=\'pat_ser_grp_code\' id=\'pat_ser_grp_code\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t<!-- Added by Sangeetha on 25/05/17 for GDOH-CRF-0151-->\n\t<input type=\'hidden\' name=\'hddfacility\' id=\'hddfacility\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\n\t<script>\n\t\tdocument.forms[0].Bedcode.value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\";\n\t\tvar ref = \"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\";\n\t\tif (ref == \'\')\n\t\t\tdocument.forms[0].referral.style.visibility = \'hidden\';\n\t\n\t\tif(\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" != \"\")\n\t\t{\n\t\t\tdocument.forms[0].to_bed_no.onblur();\n\t\t}\n\t</script>\n\t</FORM>\n\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

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
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	
	String chkreadonly				=	"";
	String encounterId				=	checkForNull(request.getParameter("encounterId"));
	String patientId				=	checkForNull(request.getParameter("patientId"));
	String p_oper_stn_id			=	checkForNull(request.getParameter("oper_stn_id"));
	String setup_bl_dtls_in_ip_yn	=	checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"),"N");
	String pat_check_in_allowed_yn	=	checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
	if(pat_check_in_allowed_yn.equals("Y"))		chkreadonly = "disabled";

	String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");


	Connection connection			=	null;
	Statement statement				=	null;
	ResultSet resultSet				=	null;

	StringBuffer sqlBuffer			=	new StringBuffer();
	String bl_operational			=	(String)session.getValue("bl_operational");
	String facility_id				=	checkForNull((String)session.getValue("facility_id"));
	String loginUser				=	checkForNull((String)session.getValue("login_user"));
	String admission_date_time		=	"";
	String admission_date_time1		=	"";
	String gender					=	"";
	String room_no					=	"";
	String admission_type_short_desc=	"";
	String practitioner_long_name	=	"";
	String specialty_short_desc		=	"";
	String nursing_unit_short_desc	=	"";
	String nursing_unit_code		=	"";
	String bed_class_code			=	"";
	String bed_type_code			=	"";
	String specialtycode			=	"";
	String practitionerid			=	"";
	String age						=	"";
	String year						=	"";
	String patient_class			=	"";
	String to_pract_team_id			=	""; 
	String medDesc					=	"";
	String medCode					=	"";
	String ot_date_time				=	"";
	String sdate					=	"";
	String bed_alloc_date_time_val  =	"";
	String billing_group_id			=	"";
	String billing_group_desc		=	"";
	String referral_id				=	"";
	String attend_pract_id			=	"";
	String attend_pract_name		=	"";
	String service_code				=	"";
	String bed_type_short_desc      =	"";
	String blocked_bed_no			=	"";
	String modified_date			=	"";
	String disable					=	"";
	String dcunitcode				=	"";
	String patient_gender			=	"";
	String exp_discharge_date_time	=	"";
	String date_of_birth			=	"";
	String admission_date_time_converted		=	"";
	String sdate_converted			=	"";
	String ot_date_time_converted	=	"";
	//Changed for PE By Sudhakar
	String bedcode					=	"";
	String beddesc					=	"";
	String pat_ser_grp_code			=	"";
	
	/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));
	String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("A")?"Y":"N");
	int no_of_days							= 0;
	/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	String is_validate_height_on_admission	= (height_on_admn_mandatory.equals("A")?"Y":"N");
	String bmi="";
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527  END*/
	
	
	
	try
	{
		connection	= ConnectionManager.getConnection(request);

		Boolean restrictPseudoBed	= eCommon.Common.CommonBean.isSiteSpecific(connection,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
		Boolean isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(connection, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		//Query Changed for PE By Sudhakar
		//sqlBuffer.append(" select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time1,  a.nursing_unit_code, a.patient_id, b.sex, a.bed_class_code,ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,a.bed_type_code, ip_get_desc.ip_bed_type (bed_type_code, '"+locale+"', 2) bed_type_short_desc, a.blocked_bed_no, am_get_desc.am_practitioner (a.admit_practitioner_id, '"+locale+"', 1 )admit_practitioner_name, a.admit_practitioner_id, a.service_code, am_get_desc.am_speciality (specialty_code, '"+locale+"', 2 ) specialty_short_desc, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, ip_get_desc.ip_nursing_unit (facility_id, nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.room_num room_no, a.team_id, a.specialty_code, a.attend_practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"',1) practitioner_short_name, get_age(b.DATE_OF_BIRTH) age,calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year, a.referral_id, a.dc_unit_code, a.patient_class, to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, to_char(b.DATE_OF_BIRTH,'dd/mm/rrrr') date_of_birth, (select to_char(ot_date_time,'dd/mm/rrrr') from IP_ADT_TRN where trn_type = 'A' and facility_id='"+facility_id+"' and encounter_id='"+encounterId+"') ot_date_time, to_char(a.exp_discharge_date_time ,'dd/mm/rrrr hh24:mi')exp_discharge_date_time,b.pat_ser_grp_code from IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounterId+"' and a.patient_id = b.patient_id ");
		//weight_on_admission,weight_on_admission_unit added by Dharma on 27th Oct 2014 against HSA-CRF-0181 [IN:049541] 
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		sqlBuffer.append(" select a.weight_on_admission,a.weight_on_admission_unit, a.height_on_admission, a.bmi,to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time1,  a.nursing_unit_code, a.patient_id, b.sex, a.bed_class_code,ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,a.bed_type_code, ip_get_desc.ip_bed_type (bed_type_code, '"+locale+"', 2) bed_type_short_desc, a.blocked_bed_no, am_get_desc.am_practitioner (a.admit_practitioner_id, '"+locale+"', 1 )admit_practitioner_name, a.admit_practitioner_id, a.service_code, am_get_desc.am_speciality (specialty_code, '"+locale+"', 2 ) specialty_short_desc, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, ip_get_desc.ip_nursing_unit (facility_id, nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.room_num room_no, a.team_id, a.specialty_code, a.attend_practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"',1) practitioner_short_name, get_age(b.DATE_OF_BIRTH) age,calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year, a.referral_id, a.dc_unit_code, a.patient_class, to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, to_char(b.DATE_OF_BIRTH,'dd/mm/rrrr') date_of_birth, (select to_char(ot_date_time,'dd/mm/rrrr') from IP_ADT_TRN where trn_type = 'A' and facility_id='"+facility_id+"' and encounter_id='"+encounterId+"') ot_date_time, to_char(a.exp_discharge_date_time ,'dd/mm/rrrr hh24:mi')exp_discharge_date_time,b.pat_ser_grp_code, trunc (sysdate) - trunc (b.DATE_OF_BIRTH) no_of_days from IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounterId+"' and a.patient_id = b.patient_id ");
		if (resultSet!=null) resultSet.close();
		if (statement!=null) statement.close();
		statement	= connection.createStatement();
		resultSet		= statement.executeQuery(sqlBuffer.toString());
		
		if((resultSet != null) && (resultSet.next()))
		{
			ot_date_time				=	checkForNull(resultSet.getString("ot_date_time"));
			if(!(ot_date_time.equals("") || ot_date_time == null))
					ot_date_time_converted = DateUtils.convertDate(ot_date_time,"DMY","en",locale);	
			
			sdate						=	checkForNull(resultSet.getString("sdate"));
			if(!(sdate.equals("") || sdate == null))
					sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale); 			
			admission_date_time1		=	checkForNull(resultSet.getString("admission_date_time1"));
			admission_date_time			=	admission_date_time1;
			if(!(admission_date_time.equals("") || admission_date_time == null))
					admission_date_time_converted = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
			gender						=	checkForNull(resultSet.getString("sex"));
			room_no						=	checkForNull(resultSet.getString("room_no"));
			admission_type_short_desc	=	checkForNull(resultSet.getString("admission_short_desc"));
			practitioner_long_name		=	checkForNull(resultSet.getString("admit_practitioner_name"));
			practitionerid				=	checkForNull(resultSet.getString("admit_practitioner_id"));
			specialty_short_desc		=	checkForNull(resultSet.getString("specialty_short_desc"));
			nursing_unit_short_desc		=	checkForNull(resultSet.getString("nursing_unit_short_desc"));
			nursing_unit_code			=	checkForNull(resultSet.getString("nursing_unit_code"));
			service_code				=	checkForNull(resultSet.getString("service_code"));
			bed_class_code				=	checkForNull(resultSet.getString("bed_class_code"));
			beddesc						=	checkForNull(resultSet.getString("bed_class_short_desc"));
			bed_type_code				=	checkForNull(resultSet.getString("bed_type_code"));
			bed_type_short_desc			=	checkForNull(resultSet.getString("bed_type_short_desc"));
			specialtycode				=	checkForNull(resultSet.getString("SPECIALTY_CODE"));
			age							=	checkForNull(resultSet.getString("age"));
			year						=	checkForNull(resultSet.getString("year"));
			referral_id					=	checkForNull(resultSet.getString("referral_id"));
			modified_date				=	checkForNull(resultSet.getString("modified_date"));
			attend_pract_id				=	checkForNull(resultSet.getString("attend_practitioner_id"));
			attend_pract_name			=	checkForNull(resultSet.getString("practitioner_short_name"));
			blocked_bed_no				=	checkForNull(resultSet.getString("blocked_bed_no"));
			to_pract_team_id			=	checkForNull(resultSet.getString("team_id"));
			dcunitcode					=	checkForNull(resultSet.getString("dc_unit_code"));
			patient_class				=	checkForNull(resultSet.getString("patient_class"));
			date_of_birth				=	checkForNull(resultSet.getString("date_of_birth"));
			patient_gender				=	checkForNull(resultSet.getString("sex"));
			exp_discharge_date_time				=	checkForNull(resultSet.getString("exp_discharge_date_time"));
			pat_ser_grp_code			=	checkForNull(resultSet.getString("pat_ser_grp_code"));
			/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
			weight_on_admission			= checkForNull(resultSet.getString("weight_on_admission"));
			weight_on_admission_unit	= checkForNull(resultSet.getString("weight_on_admission_unit"));
			no_of_days					= resultSet.getInt("no_of_days");
			/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  End*/
			
			/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527*/
			height_on_admission			= checkForNull(resultSet.getString("height_on_admission"));
			bmi			= checkForNull(resultSet.getString("bmi"));
			/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 End*/
			
		}   
		
		/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
		if(weight_on_admission.equals("") && weight_on_admission_unit.equals("")){
			/*String lastchar	="";
			int calculate_age	= 0;
			if (age.length() > 0){
				lastchar		= age.substring(age.length() - 1);
				if (!age.contains("Y"))
					calculate_age	= Integer.parseInt(age.substring(0, age.length()-1));
				
			}
			weight_on_admission_unit	= (lastchar.equals("D")?(calculate_age >30 ? "K":"G"):"K");	*/	
			weight_on_admission_unit	= (no_of_days >30 ? "K":"G");		
		}
			weight_on_admission_unit_display	= (weight_on_admission_unit.equals("G")?"Gram":"Kg");
		/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		if(height_on_admission.equals("") && height_on_admission_unit.equals("")){
			height_on_admission_unit	= ("Cm");
		}
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/
		try
		{
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			
			sqlBuffer.append(" select a.short_desc short_desc ,a.team_id, b.practitioner_id from ");
			sqlBuffer.append(" AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id = '"+locale+"' and A.facility_id = '");
			sqlBuffer.append(facility_id);
			sqlBuffer.append("' and a.facility_id = b.facility_id and a.team_id = b.team_id and a.appl_for_ip_yn = 'Y' and b.practitioner_id = '");
			sqlBuffer.append(practitionerid);
			sqlBuffer.append("' and a.team_id='");
			sqlBuffer.append(to_pract_team_id);
			sqlBuffer.append("' ");
			
			if (statement	!=	null)	statement.close();			
			if (resultSet	!=	null)	resultSet.close();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlBuffer.toString());
			
			if ((resultSet != null) && (resultSet.next()))
			{
				 medCode = checkForNull(resultSet.getString("team_id"));
				 medDesc = checkForNull(resultSet.getString("short_desc"));
			}
		
			if(bl_operational.equals("Y"))
			{
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				
				sqlBuffer.append("select a.blng_grp_id, a.short_desc from BL_BLNG_GRP a, BL_EPISODE_FIN_DTLS b where a.blng_grp_id = b.blng_grp_id and b.operating_facility_id = '");
				sqlBuffer.append(facility_id);
				sqlBuffer.append("' and b.episode_id = '");
				sqlBuffer.append(encounterId);
				sqlBuffer.append("' ");
				if(patient_class.equals("DC"))
					sqlBuffer.append("and episode_type = 'D' ");
				else
					sqlBuffer.append("and episode_type = 'I' ");
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlBuffer.toString());
				
				if ((resultSet != null) && (resultSet.next()))
				{
					billing_group_id	= checkForNull(resultSet.getString("BLNG_GRP_ID"));
					billing_group_desc	= checkForNull(resultSet.getString("SHORT_DESC"));
				}
				if (resultSet!=null) resultSet.close();
				if (statement!=null) statement.close();
			}
		}catch(Exception e)
		{
			

			e.printStackTrace();
		} 

	
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!isHeightAndBmiEnable){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(admission_date_time_converted));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(admission_type_short_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(admission_type_short_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(weight_on_admission_unit.equals("G")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
if(isHeightAndBmiEnable){if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) {
            _bw.write(_wl_block22Bytes, _wl_block22);
}}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(weight_on_admission));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(weight_on_admission_unit_display));
if(is_validate_weight_on_admission.equals("Y")) {
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(is_validate_weight_on_admission));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(weight_on_admission_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(!isHeightAndBmiEnable){
            _bw.write(_wl_block29Bytes, _wl_block29);

			}
			else
			{if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) {
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(height_on_admission));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(is_validate_height_on_admission.equals("Y")) {
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block37Bytes, _wl_block37);
}}
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(is_validate_height_on_admission));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!isHeightAndBmiEnable){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);


	if (chg_nurs_unit_in_assign_bed_yn.equals("N") || from_adv_bed_mgmt.equals("Y"))
				disable = "Disabled";
	
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(medCode));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

				String sel			= "";
				String serv_code	= "";
				String service_desc	= "";
				StringBuffer sql_service = new StringBuffer();

				sql_service.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' UNION select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' order by 2 ");

				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql_service.toString());
				if(resultSet!=null )
				{
					while(resultSet.next())
					{
						serv_code  = resultSet.getString("service_code");
						service_desc = resultSet.getString("service_short_desc");
						if (serv_code.equals(service_code))
							sel = "selected";
						else
							sel = "";
						out.println("<option value=\""+serv_code+"\" "+sel+">"+service_desc+" </option> ");
					}
				}
			if (resultSet!=null) resultSet.close();
			if (statement!=null) statement.close();
			
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(specialtycode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(practitioner_long_name));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(attend_pract_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(attend_pract_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(attend_pract_name));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

				String optSelected	=	"";
				if (sqlBuffer.length() > 0)	sqlBuffer.delete(0, sqlBuffer.length());

				sqlBuffer.append(" select team_id, AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id, '"+locale+"','2') team_short_desc from AM_PRACT_FOR_TEAM_VW where facility_id = '");
				sqlBuffer.append(facility_id);
				sqlBuffer.append("' and practitioner_id ='");
				sqlBuffer.append(practitionerid);
				sqlBuffer.append("' and speciality_code = '");
				sqlBuffer.append(specialtycode);
				sqlBuffer.append("' ");
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlBuffer.toString());
				if(resultSet!= null)
				{
					while(resultSet.next())
					{				
						medCode = checkForNull(resultSet.getString("team_id"));
						medDesc = checkForNull(resultSet.getString("team_short_desc"));
						if(medCode.equals(to_pract_team_id))
							optSelected="Selected";
						else
							optSelected="";
					
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(medCode));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(optSelected));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(medDesc));
            _bw.write(_wl_block71Bytes, _wl_block71);
						
					}			
				}
				if (resultSet!=null) resultSet.close();
				if (statement!=null) statement.close();
				
					
			/*Added Below Line code for [AK-SCF-0153] by Senthil */
			String language_direction="";
			int count=0;
			statement=connection.createStatement() ;
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
		   resultSet = statement.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ;
				 
			 if ( resultSet != null && resultSet.next() ) 
			 {
			 count = resultSet.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if (resultSet!=null) resultSet.close();
			if (statement!=null) statement.close();
			/*Added Above Line code for [AK-SCF-0153] by Senthil */
				
				
				
				
				
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(ot_date_time_converted));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(ot_date_time));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(chkreadonly));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

			if(pat_check_in_allowed_yn.equals("Y")){
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(beddesc));
            _bw.write(_wl_block82Bytes, _wl_block82);
}else{
					try{
						statement = connection.createStatement();
						//Commented and changed for PE By Sudhakar
						//String sql2=" select bed_class_code, short_desc from IP_BED_CLASS_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ";
						String sql2="SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facility_id+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.bed_class_code = b.bed_class_code and b.language_id = '"+locale+"' ORDER BY b.short_desc";
						if (resultSet!=null) resultSet.close();
						resultSet = statement.executeQuery(sql2);
							
							if( resultSet != null )
							{
							  while( resultSet.next() )
							  {
								 bedcode   = resultSet.getString(1) ;
								 beddesc   = resultSet.getString(2) ;
								
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bedcode));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(beddesc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            
								}
							}
						if (resultSet!=null) resultSet.close();
						if (statement!=null) statement.close();

						}catch(Exception e) {
							//out.println(e.toString());
							e.printStackTrace();
						}
				}
			
		
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(chkreadonly));
            _bw.write(_wl_block87Bytes, _wl_block87);
if(!bed_type_short_desc.equals("")){
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(bed_type_short_desc));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block90Bytes, _wl_block90);
}else{
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
}
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(blocked_bed_no));
            _bw.write(_wl_block95Bytes, _wl_block95);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block96Bytes, _wl_block96);
 }
            _bw.write(_wl_block97Bytes, _wl_block97);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block98Bytes, _wl_block98);
 }
            _bw.write(_wl_block99Bytes, _wl_block99);
if(from_adv_bed_mgmt.equals("Y")){
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block103Bytes, _wl_block103);

		if(blocked_bed_no.equals("")||blocked_bed_no.equals(null))			
			bed_alloc_date_time_val = sdate_converted;
		else
			bed_alloc_date_time_val = admission_date_time_converted;
	
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(bed_alloc_date_time_val));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(bed_alloc_date_time_val));
            _bw.write(_wl_block107Bytes, _wl_block107);
	
		if(pat_check_in_allowed_yn.equals("Y"))
		{ 
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(sdate_converted));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(sdate_converted));
            _bw.write(_wl_block111Bytes, _wl_block111);
}else {
            _bw.write(_wl_block112Bytes, _wl_block112);
}
            _bw.write(_wl_block113Bytes, _wl_block113);
 if(setup_bl_dtls_in_ip_yn.equals("Y")) { 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
 } else { 
            _bw.write(_wl_block115Bytes, _wl_block115);
 } 
	int opCount=0;
	int ipCount=0;
	int radCount=0;
	String rad_installed_yn="";
	boolean show_appt_btn_yn=false;
	 statement = connection.createStatement();

	resultSet = statement.executeQuery("select count(1) as total from oa_appt where patient_id='"+patientId+"'  and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time");
	if(resultSet!=null && resultSet.next()){
		opCount = resultSet.getInt("total");
	}
	if(statement !=null) statement.close();
	if(resultSet !=null) resultSet.close();


	statement=connection.createStatement();
	resultSet=statement.executeQuery("select nvl(install_yn,'N') as install_yn from sm_module where module_id = 'RD'");
	if(resultSet!=null && resultSet.next())
	{
		rad_installed_yn = resultSet.getString("install_yn");
	}
	

	if (rad_installed_yn == null || rad_installed_yn.equals(""))
	{
		rad_installed_yn="N";
	}

	if(statement !=null) statement.close();
	if(resultSet !=null) resultSet.close();
	if(rad_installed_yn.equals("Y")){

		statement = connection.createStatement();

		resultSet = statement.executeQuery("SELECT count(1) as total FROM RD_APPT where patient_id='"+patientId+"' AND TRUNC (appt_date) >= TRUNC (SYSDATE)");	
		if(resultSet!=null && resultSet.next()){
			radCount = resultSet.getInt("total");
		}


	}

	if(statement !=null) statement.close();
	if(resultSet !=null) resultSet.close();

	statement = connection.createStatement();
		resultSet = statement.executeQuery("select count(1) as total from ip_booking_list where  patient_id='"+patientId+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1");	
		if(resultSet!=null && resultSet.next()){
			ipCount = resultSet.getInt("total");
		}

		if (opCount != 0 || ipCount != 0 || radCount != 0)
		{
			show_appt_btn_yn=true;
		}
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientValuables.label","common_labels")));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraldetails.label","common_labels")));
            _bw.write(_wl_block119Bytes, _wl_block119);
if (show_appt_btn_yn == true){
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FutureAppointments.label","ip_labels")));
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(isHeightAndBmiEnable));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(specialtycode));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(age));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(year));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(admission_date_time1));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(dcunitcode));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(blocked_bed_no));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(blocked_bed_no));
            _bw.write(_wl_block162Bytes, _wl_block162);

	}catch(Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
    finally
    {
        try
		{
			if (resultSet != null)	resultSet.close();
			if (statement != null)	statement.close();
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception ee) 
		{
			//out.println("Error While Closing the connections :"+ee.toString());
			ee.printStackTrace();
		}
    }

            _bw.write(_wl_block163Bytes, _wl_block163);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WeightOnAdmission.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.HeightOnAdmission.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmittingPractitioner.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedAllocationDateTime.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ArrivalDateTime.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DailyRate.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
