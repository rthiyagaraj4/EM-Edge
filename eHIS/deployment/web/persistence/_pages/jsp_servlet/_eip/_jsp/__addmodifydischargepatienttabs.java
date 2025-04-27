package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.io.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifydischargepatienttabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addModifyDischargePatientTabs.jsp", 1742366128812L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<HEAD>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/DischargePatient.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/IPPractitionerComponent.js\' language=\'javascript\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<script>\n\nfunction DateValidations(obj) {\n\tif(document.forms[0].patient_class_value.value == \"IP\") \t{\n\t\tif(checkUntilDate(obj))\n\t\t\tcompareServerDate1(obj);\n\t} else if(document.forms[0].patient_class_value.value == \"DC\") {\n\t\tdayCareDateCheck(obj);\n\t}\n}\n\n\nfunction focusNext() {\n\t//document.getElementById(\'tab3\').focus();         \n}\n\nfunction checkform() {\n\tcheckBabyBed();\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" var error = getMessage(\'PATIENT_DESEASED\',\'IP\');\n\t\talert(error);\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="   var error = getMessage(\'DISC_CHKLST_NOT_PREPD\',\'IP\');\n\t\t\talert(error);\n\t\t\twindow.close();\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n}\n\nfunction enableInformName_disch() {\n\n\tif (document.forms[0].inform_to.value != \"\") {\n\t\tdocument.getElementById(\"im\").style.visibility = \'visible\';\n\t\tdocument.forms[0].informed_date.disabled = false;\n\t\tdocument.getElementById(\"infocalimg\").disabled\t= false;\n\t\tdocument.forms[0].informed_name.disabled = false;\n\t} else if (document.forms[0].inform_to.value\t==\t\"\") {\n\t\tdocument.getElementById(\"im\").style.visibility = \'hidden\';\n\t\tdocument.forms[0].informed_date.disabled\t=\ttrue;\n\t\tdocument.forms[0].informed_date.value\t\t=\t\"\";\n\t\tdocument.getElementById(\"infocalimg\").disabled\t=\ttrue;\n\t\tdocument.forms[0].informed_name.disabled\t=\ttrue;\n\t}\n\tif (document.forms[0].inform_to.value\t==\t\"03\") {\n\t\tdocument.forms[0].informed_name.value\t\t=\t\"\";\n\t\tdocument.forms[0].informed_name.disabled\t=\tfalse;\n\t}\t\n\tif ((document.forms[0].inform_to.value == \"01\") || (document.forms[0].inform_to.value == \"02\")) {\n\t\tvar patientid = document.forms[0].patient_id.value;\n\t\tdocument.forms[0].informed_name.disabled\t=\tfalse;\n\t\tvar informTo\t= document.forms[0].inform_to.value;\n\t\tvar disp_pat_name=\'\';\n\t\tif (document.forms[0].inform_to.value == \"01\"){\n\t\t\tdisp_pat_name=document.forms[0].contact1_name.value;\n\t\t}else {\n\t\t\tdisp_pat_name=document.forms[0].contact2_name.value;\n\t\t}\t\t\n\t\tdocument.forms[0].informed_name.value = disp_pat_name;\n   \t\tdocument.forms[0].informed_name.disabled=false;\n\t\tif(disp_pat_name!=\'\')\n\t\t\tdocument.forms[0].informed_name.focus();\n\t\t//var HTMLVal = \" <html><body onKeyDown=\'lockKey()\'><form name=\'dummy_form\' id=\'dummy_form\' method=\'post\'  action=\'../../eIP/jsp/DischargeValidation.jsp\' ><input type=\'hidden\' name=\'field1\' id=\'field1\' value=\'TransferOutForm\'><input type=\'hidden\' name=\'field2\' id=\'field2\' value=\'\"+patientid+\"\'><input type=\'hidden\' name=\'field3\' id=\'field3\' value=\'\"+informTo+\"\'><input type=\'hidden\' name=\'field4\' id=\'field4\' value=\'TransferOutForm\'><input type=\'hidden\' name=\'field5\' id=\'field5\' value=\'Discharge\'></form></body></html>\";\t\t\n\t\t//parent.frames[4].document.write(HTMLVal);\n\t\t//parent.frames[4].document.dummy_form.submit();\n\t} else {\n\t\tdocument.forms[0].informed_name.value\t\t=\t\"\";\n\t}\n}\n</script>\n</head>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<body onLoad=\"checkform();getBedBlkData();";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="calculateBmi(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'DischargePatient_form\' id=\'DischargePatient_form\'  method=\"post\" action=\"../../servlet/eIP.DischargePatientServlet\" target=\"messageFrame\">\n\t<a id=\"tab1\" name=\"tab1\" tabindex=\'0\' ></a> \n<ul id=\"tablist\" class=\"tablist\">\n\t<li class=\"tablistitem\" title=\"Discharge Details\">\n\t\t<a onclick=\"tab_click(\'discharge_details\')\" class=\"tabClicked\" id=\"discharge_details\" >\n\t\t\t<span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t</a>\n\t</li>\n\t<li class=\"tablistitem\" title=\"Additional Discharge Details\">\n\t\t<a onclick=\"tab_click(\'Addl_Discharge_Details\')\" class=\"tabA\" id=\"Addl_Discharge_Details\" >\n\t\t\t<span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t</a>\n\t</li>\n</ul>\n<div style=\"overflow:scroll;height:380px;width:100%;overflow:auto\">\n\t<table cellpadding=\"1\" cellspacing=2 width=\"100%\" border=\"0\" >\n\t\t<td class=label width=\'100%\'>\n\t\t\n\t<table cellpadding=\'1\' cellspacing=2 width=\"100%\" border=\"0\" >\n\t\t<!--<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"2\"></td></tr>-->\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'fileds\' width=\'30%\' nowrap><input type=\'text\' name=\'auth_pract_desc\' id=\'auth_pract_desc\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\'25\' maxlength=\'30\' onChange=\"getPractitionerId(practid,this, \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\"><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerId(practid,auth_pract_desc, \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t</td>\n\n\t\t\t<!-- Added by Ashwini on 13-Jun-2022 for ML-MMOH-CRF-1527.1-->\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td class= \'label\' width=\'8%\'></td>\n\t\t\t\t<td class=\'fields\' width=\'25%\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<!--End ML-MMOH-CRF-1527.1-->\n\n\t\t\t<td class=\'label\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t<td class=\'fileds\' width=\'25%\' nowrap><input type=\'text\' name=\'dischg_pract_desc\' id=\'dischg_pract_desc\'   value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\"><input type=\'hidden\' name=\'dischg_practid\' id=\'dischg_practid\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" ><input type=\'button\' name=\'dischg_pract_id_search\' id=\'dischg_pract_id_search\' value=\'?\' class=\'button\' onClick=\"getPractitionerId(practid,dischg_pract_desc, \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\"><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t\t\t<tr> \n\t<td class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td><td class=\'fields\' width=\'20%\'><SELECT name=\'dischargetype\' id=\'dischargetype\' onchange=\"callValidate1(this.value);\" tabindex = \'5\' dir=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<!--<option value=\'\' selected>-----";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="-----</option>-->\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</SELECT>\n\t<input type=\'hidden\' name=\'discharge_code\' id=\'discharge_code\' value= \"\"  >\n\t<input type=\'hidden\' name=\'dischage_indicator\' id=\'dischage_indicator\' value= \"\"  >\n\t<input type=\'hidden\' name=\'discharge_indicator\' id=\'discharge_indicator\' value= \"\"  >\n\t\n\t</td>\n\t<input type=\'hidden\' name=\'discharge_type\' id=\'discharge_type\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'></input>\n<!-- modified on 2/07/2008 for SCR 3228 -->\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<td class=\'label\' width=\'12%\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td><td class=\'fields\' width=\'20%\' ><SELECT name=\'dischargestatus\' id=\'dischargestatus\' onchange=\'capt_value(this)\' tabindex = \'6\' ><option value=\'\'>---";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="---\n\t\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\' align = \'center\'></img>\n\t<input type=\'hidden\' name=\'discharge_status\' id=\'discharge_status\' value= \"\"  >\n\t<input type=\'hidden\' name=\'dischage_status_indicator\' id=\'dischage_status_indicator\' value= \"\"  ></td>\n\t<input type=\'hidden\' name=\'discharge_stat\' id=\'discharge_stat\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'></input>\n</tr>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<tr>\n\t\t\t<td class=label nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td nowrap class=\'fileds\'><input type=\'text\' disabled name=\'discharge_type1\' id=\'discharge_type1\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'></input></td>\n\t\t\t<input type=\'hidden\' name=\'discharge_type\' id=\'discharge_type\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'></input>\n\n\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"override_yn\" id=\"override_yn\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"> \n\t\t\t\t\t<input type=\"hidden\"  name=\"indicator\" id=\"indicator\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\n\t\t\t<!-- added on 3-07-2008 for SCR 3228 -->\n\n\t\t\t<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\n\t\t\t\t\n\t\t\t\t<td class= \'label\'  width=\'8%\' nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td class=\'fields\' width=\'25%\' nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<input type=\"text\" name=\"discharge_to\" id=\"discharge_to\"  id=\'distext\'  value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \"OnBlur=\'ChangeUpperCase(this);if(this.value != \"\") searchCode(discharge_to_value,this);\'><input type=\'button\' align=\'left\' name=\'discharge_to_value\' id=\'discharge_to_value\' id=\'disbtn\' value=\'?\' class=\'button\' onClick=\'searchCode(this,discharge_to)\'>\t\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\t\t\t\n\t\t\t<td class=label nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t<td nowrap class=\'fileds\'><input type=\'text\' disabled name=\'discharge_status\' id=\'discharge_status\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'></input></td>\n\t\t\t<input type=\'hidden\' name=\'discharge_stat\' id=\'discharge_stat\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'></input>\n           <!-- stat_code stat_desc-->\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<!-- Added by kishore on 8/31/2004  -->\n\t\t<tr>\n\t\t\t<td class=label nowrap>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td nowrap class=\'fileds\'><input type=\"text\" name=\"expected_discharge_date_time\" id=\"expected_discharge_date_time\" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' readOnly size=16 maxlength=16 ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].discharge_date_time.select();return showCalendar(\'date_of_expiry\',null,\'hh:mm\');\" disabled=\'true\' tabindex=-1 /><img align=center src=\"../../eCommon/images/mandatory.gif\"></img></td>\n\n\t\t\t<!-- Added by Ashwini on 13-Jun-2022 for ML-MMOH-CRF-1527.1-->\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t<!--End ML-MMOH-CRF-1527.1-->\n\n\t\t\t<td class=label nowrap>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t<td class=\'fileds\' nowrap><input type=\"text\" name=\"discharge_date_time\" id=\"discharge_date_time\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" size=16 maxlength=16 onblur=\"DateValidations(this);validateLateDischarge();validatePatient(this,\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\');\" onKeyPress=\'return(ChkNumberInput1(this,event,2))\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].discharge_date_time.select();return showCalendar(\'discharge_date_time\',null,\'hh:mm\');\" tabindex=-1/><img align=center src=\"../../eCommon/images/mandatory.gif\"></img></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<tr id=\'late_reason_div\' style=\'display:block\'>\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t\t\t<td>\t\t\t\t\t\t\n\t\t\t\t\t\t<select id=\'late_discharge_reason\' name=\'late_discharge_reason\' id=\'late_discharge_reason\' tabindex=\'0\' onChange=\"getOtherReason();\">\n\t\t\t\t\t\t<option value=\'\'> ---";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="--- </option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t<table cellpadding=\'1\' cellspacing=0 width=\"100%\" border=0>\n\t\t\t\t\t\t<tr id=\'name_div\' style=\'display:none\'>\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'fileds\'><textarea id=\"other_late_discharge_reason\" name=\"other_late_discharge_reason\" tabindex=\'0\' ROWS=\"3\" COLS=\"70\" maxlength=200 onBlur=\"checkOtherReasonMaxlen(this);\" style=\"resize: none;\"></textarea></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"Type_indicator\" id=\"Type_indicator\" value=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" />\n\t\t\t\t\t<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\t\t\t\t<input type=\"hidden\" name=\"disch_reason_mand_yn\" id=\"disch_reason_mand_yn\" value=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" />\n\t\t\t\t<input type=\"hidden\" name=\"hid_late_dis_reason\" id=\"hid_late_dis_reason\" value=\'\' />\n\t\t\t\t<input type=\"hidden\" name=\"edd_crossed\" id=\"edd_crossed\" value=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" />\n\t\t\t\t<input type=\"hidden\" name=\"allow_late_disch_reason\" id=\"allow_late_disch_reason\" value=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" />\n\t\t\t\t<table cellpadding=\'3\' cellspacing=0 width=\"100%\" border=\"0\"> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!-- Added by Ashwini on 13-Jun-2022 for ML-MMOH-CRF-1527.1-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t<td class=label rowspan=\"3\" width=\"18%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t<td class=label rowspan=\"3\" width=\"25%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t<td class=label rowspan=\"3\" width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<!--End ML-MMOH-CRF-1527.1-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t\t<td class=\'fileds\' rowspan=\"3\" colspan=2 ><textarea name=\"discharge_remarks\" ROWS=\"3\" COLS=\"60\"  onBlur=\"checkMaxlen(this);\" style=\"resize: none;\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</textarea></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t<td class=label >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td> <td class=label style=\"color:red;\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td> <td class=label style=\"color:red;\" >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t</tr> \n\t\t\t\t\t<!--<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"2\"></td></tr>-->\n\t\t\t\t</table>\n\t\t </table>\n\n\t\n\t<table cellpadding=\'3\' cellspacing=0 width=\"100%\" border=0 >\n\t<tr><td  colspan=4 class= \"columnheader\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td></tr>\n\t\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"2\"></td></tr>\n\t<tr>\t\t\t\t\n\t\t<td class=label nowrap width=\'25%\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t<td width=\'30%\' class=\'fileds\'><input type=\"checkbox\" value=\"Y\" name=\"deceased_yn\" id=\"deceased_yn\" disabled ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" ></td><td class=label nowrap width=\'20%\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" </td>\n\t\t<td width=\'25%\' class=\'fileds\'><input type=\"text\" id=\"deceased_date\"  name=\"DECEASED_DATE_TIME\" id=\"DECEASED_DATE_TIME\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" size=16 maxlength=16 onblur=\"validateDateTimes(this,\'DE\');\" onKeyPress=\'return(ChkNumberInput1(this,event,2))\' ><img id=\"calcomp\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"\t\t\tdocument.forms[0].DECEASED_DATE_TIME.select();return showCalendar(\'deceased_date\',null,\'hh:mm\');\" />\n\t\t<img id=\'deceasedimg\' style=\'visibility:hidden;\' align=center src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t</td>\n\t</tr> \n\t<tr>\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t<td class=label nowrap>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\t\t<td class=\'fileds\'><input type=\"checkbox\" value=\"N\" name=\"post_mortem_request\" id=\"post_mortem_request\"  ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" onclick=\"bodyrelease(this)\"></td>\n\t\t<td class=label nowrap>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n\t\t<td class=\'fileds\'>\n\t\t<input type=\"text\" id=\"body_released\"  name=\"body_released_date\" id=\"body_released_date\" ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="value=\"\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="size=16 maxlength=16 onblur=\"validateDateTimes(this,\'\');validateBodyReleasedDate(this);\" onKeyPress=\'return(ChkNumberInput1(this,event,2))\' ><img  id=\"calcomp1\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"\t\t\tdocument.forms[0].body_released_date.select();return showCalendar(\'body_released\',null,\'hh:mm\');\"/><img id=\'bodyreleasedImg\' style=\'visibility:hidden;\' align=center src=\"../../eCommon/images/mandatory.gif\"></img></td>\n\t</tr>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t<tr>\n\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</td>\n\t\t<td class=\'fields\'><input type=\"checkbox\" value=\"N\" name=\"body_risk\" id=\"body_risk\" onclick=\"if(this.checked == true){this.value=\'Y\'}else{this.value=\'N\'}\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="></td>\n\t<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023  -->\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t<td class=\'label\'>\n   \t\t<a href=\"javascript:getDeathRegFormAccessionNum(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\',\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\',\'\',\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\',\'\');\" id=\'deathRegFormLink\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</a>\n  \t</td>\n\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t</tr>\n\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"2\"></td></tr>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\n\t<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->\n\t    ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t<td colspan=\'4\' class= \"COLUMNHEADER\">";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t<!--end ML-MMOH-CRF-0354 [IN057191 -->\n\t\t<td  class=\'fileds\'><INPUT TYPE=\"checkbox\" name=\"medico_legal\" id=\"medico_legal\" value=\"Y\" ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="  onClick=\"getMedicoValues(this);enablePolice(this);\" onBlur=\'focusNext();\'><input type=\'hidden\' name=\'dischgsumsigned\' id=\'dischgsumsigned\' value= \"N\" ></td>\n\t\t<td > </td>\n\t\t<td > </td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t<td class=\'fileds\' colspan=\'3\'><INPUT TYPE=\'text\' name=\'pol_rep_no\' id=\'pol_rep_no\' value= \"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" size=\'20\' maxlength=\'30\'><INPUT TYPE=\'hidden\' name=\'pol_rep_no_db\' id=\'pol_rep_no_db\' value= \"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t<td class=\'fileds\' ><INPUT TYPE=\'text\' name=\'pol_stn_id\' id=\'pol_stn_id\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" size=\'20\' maxlength=\'30\'><INPUT TYPE=\'hidden\' name=\'pol_stn_id_db\' id=\'pol_stn_id_db\' value= \"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t</td>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t<td class=\'fileds\'><INPUT TYPE=\'text\' name=\'pol_id\' id=\'pol_id\' onblur=\"focusNext()\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" size=\'20\' maxlength=\'30\'><INPUT TYPE=\'hidden\' name=\'pol_id_db\' id=\'pol_id_db\' value= \"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t</td>\n\t</tr>\n\n<script>\n\n\tdocument.forms[0].pol_rep_no.disabled=true;\n\tdocument.forms[0].pol_stn_id.disabled=true;\n\tdocument.forms[0].pol_id.disabled=true;\n\n</script>\n\t\n\t<!--<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>-->\n\t<tr>\n\t\t<td colspan=2><input type=\"hidden\" value=\"Y\" name=\"new_medicine\" id=\"new_medicine\" ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="></td>\n\t\t<td colspan=2><input type=\"hidden\" value=\"Y\" name=\"discharge_summary_signed\" id=\"discharge_summary_signed\" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="></td>\n\t</tr>\n\n</table>\n</div>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\n\n\n\n\n<a id=\"tab3\" name=\"tab3\" tabindex=\'0\' onfocus=\"javascript:tab_click(\'discharge_details\')\"></a>\n<ul id=\"tablist\" class=\"tablist\">\n\t<li class=\"tablistitem\" title=\"Discharge Details\">\n\t\t<a onclick=\"tab_click(\'discharge_details\')\" class=\"tabA\" id=\"discDetails\" >\n\t\t\t<span class=\"tabASpan\" id=\"\">";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</span>\n\t\t</a>\n\t</li>\n\t<li class=\"tablistitem\" title=\"Additional Discharge Details\">\n\t\t<a onclick=\"tab_click(\'Addl_Discharge_Details\')\" class=\"tabClicked\" id=\"addlDiscDetails\" >\n\t\t\t<span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</span>\n\t\t</a>\n\t</li>\n</ul>\n\n</td></tr>\n</table>\n<table cellpadding=\'1\' cellspacing=0 width=\"100%\" border = \"0\">\n\n\t<tr>\n\t\t<td width=\"97%\" class=\'fileds\'>\n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t<input type=button class=button value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' name=\'bookingappointment\' onclick=\'appointment()\' style=\"width:122\" disabled>\n\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' name=\'bookingappointment\' onclick=\'appointment()\' style=\"width:122\">\n\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t</td><td width=\"3%\"></td>\n\t</tr>\n</table>\n\t\n<BR><BR><BR><BR><BR><BR> <BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\n\n<a id=\"tab2\" name=\"tab2\" tabindex=\'1\' onfocus=\"javascript:tab_click(\'Addl_Discharge_Details\')\"></a>\n<ul id=\"tablist\" class=\"tablist\" style=\"margin-top:-445px;\">\n\t<li class=\"tablistitem\" title=\"Discharge Details\">\n\t\t<a onclick=\"tab_click(\'discharge_details1\')\" class=\"tabA\" id=\"discharge_details1\" >\n\t\t\t<span class=\"tabAspan\" id=\"\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</span>\n\t\t</a>\n\t</li>\n\t<li class=\"tablistitem\" title=\"Additional Discharge Details\">\n\t\t<a onclick=\"tab_click(\'Addl_Discharge_Details\')\" class=\"tabClicked\" id=\"Addl_Discharge_Details1\" >\n\t\t\t<span class=\"tabSpanclicked\" id=\"\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</span>\n\t\t</a>\n\t</li>\n</ul>\n\n\n<table width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' BORDER=\'0\' >\n\t<tr>\n\t\t<td colspan=4 width=\"100%\" class= \"COLUMNHEADER\">";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t</tr>\n\n\n<tr><td class=label colspan=4></td></tr>\n\n<TR>\n\t<TD  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</TD>\n\t<TD   class=\'fileds\' colspan=3><INPUT TYPE=\"text\" name=\"blocking_type\" id=\"blocking_type\" readOnly maxlength=\"30\" size=\"30\" ><input type=\"hidden\" name=\"blocking_type_code\" id=\"blocking_type_code\" value=\"\" ></TD>\n\t</TR>\n\n<TR>\n\t<TD class=\"label\" >";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</TD>\n\t<TD  class=\'fileds\' ><INPUT TYPE=\"text\" name=\"bed_blocking_period\" id=\"bed_blocking_period\" value=\"\" onBlur = \"validSpecialChars(this);CheckNum(this);\" onKeyPress=\"return allowOnlyNumbers(event);\" maxlength=\"3\" size=\"3\" ><B><span class=\'label\'>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</span></B></td>\n</tr>\n\n<TR>\n\t<TD class=\"label\" >";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</TD>\n\t<TD  class=\'fileds\' colspan=3><INPUT TYPE=\"text\" name=\"bed_block_until\" id=\"bed_block_until\" readOnly maxlength=\"15\" size=\"15\" ></TD>\n\t</TR>\n\n<TR>\n\t<TD class=\"label\" >";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</TD>\n\t<TD  colspan=\'3\' class=\"fileds\"><TEXTAREA name=\'bed_block_remarks\' value=\"\" ROWS=\"2\" COLS=\"60\" maxlength=\'60\' onBlur=\"makeValidString(this);checkForMaximum(this.value);\" style=\"resize: none;\"></TEXTAREA></TD>\n</TR>\n</table>\n\n<table width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t<td colspan=4 width=\"100%\" class= \"COLUMNHEADER\">";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n\t</tr>\n\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n</table>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\t\n\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\t\n\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n<div id = \'ab_details\' style=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">  <!--  added by mujafar for ML-MMOH-CRF-0659 -->\n<table width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n\t<tr><td colspan=4 width=\"100%\" class= \"COLUMNHEADER\">";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td></tr>\n\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n</table>\n\n";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\t\t\t\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n</div>\n\n\n<!--\n\n<table width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr><td class=\'DEFAULTBLANKROW\' colspan=4 height=\"4\"></td></tr>\n\t</table>\n\t\n\n-->\n\t<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\t<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\n\n\n\n\t<!-- Added by Sridhar on 5 JUNE 2004 -->\n\t \n\t \n\t <input type=\"hidden\"  name=\"isModifyDiscTypeStatusAppl\" id=\"isModifyDiscTypeStatusAppl\" value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\"> <!--added by mujafar for ML-MMOH-CRF-0659 -->\n\t <input type=\"hidden\"  name=\"absconded_date\" id=\"absconded_date\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t <input type=\"hidden\" name=\"allow_modify_disc_yn\" id=\"allow_modify_disc_yn\" value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"> <!--added by mujafar for ML-MMOH-CRF-0659 -->\n\t \n\t \n\t \n\t <input type=\"hidden\"  name=\"serverDate_display\" id=\"serverDate_display\" value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\">\n\t\n\t<input type=\"hidden\"  name=\"admission_date_time\" id=\"admission_date_time\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t<input type=\"hidden\"  name=\"practitioner_short_name\" id=\"practitioner_short_name\" value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t<input type=\"hidden\"  name=\"admission_short_desc\" id=\"admission_short_desc\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t<input type=\"hidden\"  name=\"specialty_short_desc\" id=\"specialty_short_desc\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t<input type=\"hidden\"  name=\"medical_team\" id=\"medical_team\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\n\t<input type=\"hidden\"  name=\"patient_type_short_desc\" id=\"patient_type_short_desc\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t<input type=\"hidden\"  name=\"nursing_unit_short_desc\" id=\"nursing_unit_short_desc\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t<input type=\"hidden\"  name=\"service_short_desc\" id=\"service_short_desc\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t<input type=\"hidden\"  name=\"bed_no\" id=\"bed_no\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t<input type=\"hidden\"  name=\"room_no\" id=\"room_no\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t<input type=\"hidden\"  name=\"bed_class_short_desc\" id=\"bed_class_short_desc\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t<input type=\"hidden\" name=\"valubles\" id=\"valubles\" value=\"\"> \n\t<input type=\"hidden\" name=\"recorded_by\" id=\"recorded_by\" value=\"\"> \n\t<input type=\"hidden\" name=\"recorded_date\" id=\"recorded_date\" value=\"\"> \n\t<input type=\"hidden\" name=\"valuble_remakrs\" id=\"valuble_remakrs\" value=\"\">\n\t<input type=\"hidden\" name=\"witness_desc\" id=\"witness_desc\" value=\"\">\n\t<input type=\"hidden\" name=\"witness_id\" id=\"witness_id\" value=\"\">\t\n\t<input type=\"hidden\" name=\"cnt_vals\" id=\"cnt_vals\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"> \n\t<!-- Hidden values for schedule appointment-->\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"  value =\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" >\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\"  value =\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" >\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\"  value =\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" >\n\t<input type=\"hidden\" name=\"i_practitioner_id\" id=\"i_practitioner_id\"  value =\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" >\n\t<input type=\"hidden\" name=\"i_clinic_code\" id=\"i_clinic_code\"  value =\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" >\n\t<input type=\"hidden\" name=\"i_appt_ref_no\" id=\"i_appt_ref_no\"  value =\"\">\n\t<input type=\"hidden\" name=\"i_appt_date\" id=\"i_appt_date\"  value =\"\">\n\t<input type=\"hidden\" name=\"callingMode\" id=\"callingMode\"  value =\"OP\">\n\t<!-- End of the addition of hidden values to schedule appointment-->\n\t<input type=\'hidden\' name=\'patient_status\' id=\'patient_status\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t<input type=\"hidden\" name=\"patient_Id\" id=\"patient_Id\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t<input type=\"hidden\" name=\"bed_type_code\" id=\"bed_type_code\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t<input type=\"hidden\" name=\"bed_class_code\" id=\"bed_class_code\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t<input type=\"hidden\" name=\"nursing_unit_code\" id=\"nursing_unit_code\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t<input type=\"hidden\" name=\"patient_type_code\" id=\"patient_type_code\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t<input type=\"hidden\" name=\"subservice_code\" id=\"subservice_code\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t<input type=\"hidden\" name=\"dischargeafterhrs\" id=\"dischargeafterhrs\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t<input type=\"hidden\" name=\"sysdatetime\" id=\"sysdatetime\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t<input type=\"hidden\" name=\"curdateWithoutTime\" id=\"curdateWithoutTime\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t<input type=\"hidden\" name=\"open_to_all_pract_yn\" id=\"open_to_all_pract_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"from_hcare_setting_type_code\" id=\"from_hcare_setting_type_code\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\">\t\n\t<input type=\"hidden\" name=\"disdatechkdays\" id=\"disdatechkdays\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\t\n\t<input type=\"hidden\" name=\"disdatechkdaysunit\" id=\"disdatechkdaysunit\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\t\n\t<input type=\"hidden\" name=\"hcare_setting_type_desc\" id=\"hcare_setting_type_desc\"  value =\'\' >\n\t<input type=\"hidden\" name=\"medicalteam\" id=\"medicalteam\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t<input type=\"hidden\" name=\"locn_type_val\" id=\"locn_type_val\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\t\t\n\t<input type=\"hidden\" name=\"SickLeaveRecordFlag\" id=\"SickLeaveRecordFlag\" value=\"N\">\n\t<input type=\"hidden\" name=\"SickLeaveDetails\" id=\"SickLeaveDetails\" value=\"\">\n\t<input type=\"hidden\" name=\"SickLeaveDetails1\" id=\"SickLeaveDetails1\" value=\"\">\n\t<input type=\"hidden\" name=\"server_date\" id=\"server_date\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t<input type=\"hidden\" name=\"ref_code\" id=\"ref_code\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n\t<input type=\"hidden\" name=\"serv_code\" id=\"serv_code\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t<input type=\"hidden\" name=\"locn_code_value\" id=\"locn_code_value\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t<input type=\"hidden\" name=\"to_specialty_code\" id=\"to_specialty_code\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t<input type=\"hidden\" name=\"accomp_person\" id=\"accomp_person\" value=\"\">\n\t<input type=\"hidden\" name=\"location_val\" id=\"location_val\" value=\"\" >\n\t<input type=\"hidden\" name=\"location1_desc\" id=\"location1_desc\" value=\"\" >\n\t<input type=\"hidden\" name=\"patient_class_value\" id=\"patient_class_value\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" >\n\t<input type=\"hidden\" name=\"target_date\" id=\"target_date\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" >\n\t<input type=\"hidden\" name=\"max_disch_period_for_dc\" id=\"max_disch_period_for_dc\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" >\n\t<div id = \'sep\'><input type=\"hidden\" name=\"seperator\" id=\"seperator\" value=\"abc\"></div>\n\t<input type=\"hidden\" name=\"countValue\" id=\"countValue\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" >\n\t<input type=\"hidden\" name=\"ageValue\" id=\"ageValue\"  >\n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'DISCHARGE_PAT\'>\n\t<input type=\'hidden\' name=\'dead_yn\' id=\'dead_yn\' value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t<input type=\'hidden\' name=\'post_mortem_req_yn\' id=\'post_mortem_req_yn\' value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t<input type=\'hidden\' name=\'maternal_death_yn\' id=\'maternal_death_yn\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t<input type=\'hidden\' name=\'diag_update_period_max_unit\' id=\'diag_update_period_max_unit\' value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t<input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t<input type=\'hidden\' name=\'pseudo_bed_yn\' id=\'pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t<input type=\"hidden\" name=\"mother_status\" id=\"mother_status\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"\">\n\t<input type=\"hidden\" name=\"bl_operational\" id=\"bl_operational\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t<input type=\"hidden\" name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t<input type=\'hidden\' name=\"valid\" id=\"valid\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t<input type=\'hidden\' name=\"from_time\" id=\"from_time\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t<input type=\'hidden\' name=\"max_param_date\" id=\"max_param_date\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t<input type=\'hidden\' name=\"valid_date\" id=\"valid_date\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t<input type=\'hidden\' name=\"proceed\" id=\"proceed\" value=\"Y\">\n\t<input type=\'hidden\' name=\"ip_Trn_Date\" id=\"ip_Trn_Date\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n\t<input type=\'hidden\' name=\"locale1\" id=\"locale1\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n\t<!--Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->\n\t<!--<input type=\'hidden\' name=\'mr_mds_recorded\' id=\'mr_mds_recorded\' value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">-->\n\t<input type=\'hidden\' name=\'contact1_name\' id=\'contact1_name\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\'>\n\t<input type=\'hidden\' name=\'contact2_name\' id=\'contact2_name\' value=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\'>\n\t<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start -->\n\t<input type=\"hidden\" name=\"weight_on_admission\" id=\"weight_on_admission\" value=\"\">\n\t<input type=\"hidden\" name=\"weight_on_admission_unit\" id=\"weight_on_admission_unit\" value=\"\">\n\t<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->\n\t\n\t<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->\n\t<input type=\"hidden\" name=\"height_on_admission\" id=\"height_on_admission\" value=\"\">\n\t<input type=\"hidden\" name=\"height_on_admission_unit\" id=\"height_on_admission_unit\" value=\"\">\n\t<input type=\"hidden\" name=\"bmi\" id=\"bmi\" value=\"\">\n\t\n\t<input type=\"hidden\"  name=\"isHeightAndBmiEnable\" id=\"isHeightAndBmiEnable\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t<!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 End -->\n\n   <!--Added for this CRF HSA-CRF-0263.1 -->\n\t<input type=\"hidden\" name=\"allow_muti_bedside_review_yn\" id=\"allow_muti_bedside_review_yn\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t<!-- End HSA-CRF-0263.1 -->\n\t<!--Added for this CRF HSA-CRF-0306.1 -->\n\t<input type=\"hidden\" name=\"daycare_unit_code\" id=\"daycare_unit_code\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t<input type=\"hidden\" name=\"death_reg_form_accession_num\" id=\"death_reg_form_accession_num\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\"><!-- Added by Ajay Hatwate for AAKH-CRF-0179 -->\n\t<input type =\'hidden\' name= \'callback_mode\' value=\"View\">\n\t\t\n</form>\n<script>\n\n\tdisableAllFields();\n\n\tif (\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\" != \"\")\n\t{\n\t\tdocument.getElementById(\'im\').style.visibility = \"Visible\";\n\t}\n\t\n\t// To perform Neo-natal Discharge if the patient is less than two days old.\n\tvar date_of_birth\t=\t\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\";\n\tvar dobArray\t\t=\tnew Array();\n\tvar sysDate\t\t\t=\tnew Date();\n\tvar dateValue\t\t=\tsysDate.getDate();\n\tvar monthValue\t\t=\tsysDate.getMonth();\n\tvar yearValue\t\t=\tsysDate.getYear();\n\tvar ageValue;\n\tdobArray\t= date_of_birth.split(\"/\");\n\n\tif ( (Math.abs(dobArray[2]) == Math.abs(yearValue)) && (Math.abs(dobArray[1]) == Math.abs(monthValue)) )\n\t{\n\t\tageValue = eval(dateValue) - eval(dobArray[0]); \n\t}\n\tdocument.forms[0].ageValue.value = Math.abs(ageValue);\n\tif (isNaN(document.forms[0].ageValue.value))\n\t\tdocument.forms[0].ageValue.value = \"\";\n\n  </script>\n\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t<script>\n\t\t\tdocument.forms[0].bookingappointment.disabled\t\t\t\t= true;\n\t\t\tdocument.getElementById(\'calImage\').disabled\t\t\t\t\t\t\t\t= true;\n\t\t</script>\n";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con	= null;
	Statement stmt 	= null;
	ResultSet rset	= null;
	ResultSet rset1	= null;
	PreparedStatement pstmt = null; //Added by Aajay Hatwate for AAKH-CRF-0179
	
	JSONObject AllowUserModifyDiscJson = new JSONObject(); 
	JSONObject PatDataJson    = new JSONObject();
	String allow_modify_disc_yn = ""; // added by mujafar for ML-MMOH-CRF-0659 END
	
	con				= ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE");
	boolean isModifyDiscTypeStatusAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","MODIFY_DISC_TYPE_STATUS_YN"); // added by mujafar for ML-MMOH-CRF-0659
	/*end ML-MMOH-CRF-0354 [IN057191] */
	boolean isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527

	stmt			= con.createStatement();
	String locale					= (String)session.getAttribute("LOCALE");
	String bl_operational			= (String)session.getValue("bl_operational");
	String facilityId				= checkForNull((String)session.getAttribute("facility_id"));
	String locn_code				= checkForNull(request.getParameter("location_code"));
	String eid						= checkForNull(request.getParameter("encounter_id"));
	long encounterid				= Long.parseLong(eid);
	String post_mortem_req_yn		= checkForNull(request.getParameter("post_mortem_req_yn"));
	String to_ref_code				= checkForNull(request.getParameter("to_ref_code"));
	String to_specialty_code		= checkForNull(request.getParameter("to_specialty_code"));
	String to_service_code			= checkForNull(request.getParameter("to_service_code"));
	String to_locn_type				= checkForNull(request.getParameter("to_locn_type"));
	String to_locn_code				= checkForNull(request.getParameter("to_locn_code"));
	String med_lgl_case_yn			= checkForNull(request.getParameter("med_lgl_case_yn"),"N");
	String informed_to				= checkForNull(request.getParameter("informed_to"));
	String informed_date_time		= checkForNull(request.getParameter("informed_date_time")); 
	/*String informed_name			= checkForNull(request.getParameter("informed_name"));
	String pol_rep_no				= checkForNull(request.getParameter("pol_rep_no"));
	String pol_stn_id				= checkForNull(request.getParameter("pol_stn_id"));
	String pol_id					= checkForNull(request.getParameter("pol_id"));
	String discharge_narration		= checkForNull(request.getParameter("discharge_narration"));
	String reported_to				= checkForNull(request.getParameter("reported_to"));
	
	String informed_name			= (String)pageContext.getAttribute("informed_name",pageContext.SESSION_SCOPE);
	String pol_rep_no				= (String)pageContext.getAttribute("pol_rep_no",pageContext.SESSION_SCOPE);
	String pol_stn_id				= (String)pageContext.getAttribute("pol_stn_id",pageContext.SESSION_SCOPE);
	String pol_id					= (String)pageContext.getAttribute("pol_id",pageContext.SESSION_SCOPE);
	String discharge_narration		= (String)pageContext.getAttribute("discharge_narration",pageContext.SESSION_SCOPE);
	String reported_to				= (String)pageContext.getAttribute("reported_to",pageContext.SESSION_SCOPE);

	pageContext.removeAttribute("discharge_narration",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("reported_to",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("informed_name",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_rep_no",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_stn_id",pageContext.SESSION_SCOPE);
	pageContext.removeAttribute("pol_id",pageContext.SESSION_SCOPE);*/
	/*
	Hashtable hash					= (Hashtable)obj.parseXMLString( request ) ;
	hash							= (Hashtable)hash.get("SEARCH");
	String  function_name			= (String) hash.get("function_name")==null?"":(String) hash.get("function_name") ;
	String  discharge_narration		= (String) hash.get("discharge_narration")==null?"":(String) hash.get("discharge_narration") ;
	String  reported_to				= (String) hash.get("reported_to")==null?"":(String) hash.get("reported_to") ;
	String  informed_name			= (String) hash.get("informed_name")==null?"":(String) hash.get("informed_name") ;
	String  pol_rep_no				= (String) hash.get("pol_rep_no")==null?"":(String) hash.get("pol_rep_no") ;
	String  pol_stn_id				= (String) hash.get("pol_stn_id")==null?"":(String) hash.get("pol_stn_id") ;
	String  pol_id					= (String) hash.get("pol_id")==null?"":(String) hash.get("pol_id") ;*/
	String discharge_narration		= "";
	String reported_to				= "";
	String informed_name			= "";
	String pol_rep_no				= "";
	String pol_stn_id				= "";
	String pol_id					= "";
	
	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22/08/2023 */
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";

	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023
	if(isDeathRegisterFormAppl){
		enable_death_reg_form	= eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);	

		if(enable_death_reg_form.equals("Y")){
			try{
				pstmt = con.prepareStatement(" SELECT death_reg_form_accession_num FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ?");
				pstmt.setString(1, facilityId);
				pstmt.setString(2, String.valueOf(encounterid));
				rset = pstmt.executeQuery();
				if(rset != null && rset.next()) {
					death_reg_form_accession_num	= checkForNull(rset.getString("death_reg_form_accession_num"));
				}
			if(rset != null) rset.close(); 
			if(pstmt != null) pstmt.close(); 				
			}
			catch(Exception e){
				e.printStackTrace();
		}	
	}
	}
	/* End of AAKH-CRF-0179 */
	try
	{
		rset = stmt.executeQuery("select reported_to,informed_name,pol_rep_no,pol_stn_id,pol_id,discharge_narration from ip_discharge_advice where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' and dis_adv_status = '0'");
		if(rset != null && rset.next()) {
			informed_name			= checkForNull(rset.getString("informed_name"));
			pol_rep_no				= checkForNull(rset.getString("pol_rep_no"));
			pol_stn_id				= checkForNull(rset.getString("pol_stn_id"));
			pol_id					= checkForNull(rset.getString("pol_id"));
			discharge_narration		= checkForNull(rset.getString("discharge_narration"));
			reported_to				= checkForNull(rset.getString("reported_to"));
		}
		if(rset != null) rset.close(); 
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	String admission_date_time		= checkForNull(request.getParameter("admission_date_time"));
	String admission_short_desc		= checkForNull(request.getParameter("admission_short_desc"));
	String specialty_short_desc		= checkForNull(request.getParameter("specialty_short_desc"));
	String practitioner_name		= checkForNull(request.getParameter("practitioner_name"));
	String patient_type_short_desc	= checkForNull(request.getParameter("patient_type_short_desc"));
	String nursing_unit_short_desc	= checkForNull(request.getParameter("nursing_unit_short_desc"));
	String service_short_desc		= checkForNull(request.getParameter("service_short_desc"));
	String bed_no					= checkForNull(request.getParameter("bed_no"));
	String room_no					= checkForNull(request.getParameter("room_no"));
	String bed_class_short_desc		= checkForNull(request.getParameter("bed_class_short_desc"));
	String patient_id				= checkForNull(request.getParameter("patient_id"));
	String bed_type_code			= checkForNull(request.getParameter("bed_type_code"));
	String bed_class_code			= checkForNull(request.getParameter("bed_class_code"));
	String practitioner_id			= checkForNull(request.getParameter("practitioner_id"));
	String specialty_code			= checkForNull(request.getParameter("specialty_code")); 
	String auth_practitioner_id		= checkForNull(request.getParameter("auth_practitioner_id"));

	//String auth_practitioner_name	= checkForNull(request.getParameter("auth_practitioner_name"));
	String auth_practitioner_name	= "";
	String nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
	String service_code				= checkForNull(request.getParameter("service_code"));
	String patient_type				= checkForNull(request.getParameter("patient_type"));
	String gender					= checkForNull(request.getParameter("gender"));
	String date_of_birth			= checkForNull(request.getParameter("date_of_birth"));
	String locn_type				= checkForNull(request.getParameter("locn_type"));
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String patient_status			= checkForNull(request.getParameter("patient_status"));

    String daycare_unit_code = checkForNull(request.getParameter("daycare_unit_code")); //Added for this CRF HSA-CRF-0306.1


	String absconded_date			= checkForNull(request.getParameter("absconded_date"));
	String absconded_yn				= checkForNull(request.getParameter("absconded_yn"));
	String EXPECTED_DISCHARGE_DATE	= checkForNull(request.getParameter("EXPECTED_DISCHARGE_DATE"));
	String subservice_code          = checkForNull(request.getParameter("subservice_code"));
	 //added on 3-07-2008 for SCR 3228
	String discharge_status_code= checkForNull(request.getParameter("discharge_status_code"));
	String Type_indicator           = checkForNull(request.getParameter("indicator"));
	//String function_id		   = checkForNull(request.getParameter("function_id"));

	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));
	String dischg_chklst_app_yn		= checkForNull(request.getParameter("discharge_checklist_app_yn"));
	String bed_block_period_dis		= checkForNull(request.getParameter("bed_block_period_dis"));
	String dis_date_chk_days1		= checkForNull(request.getParameter("dis_date_chk_days"));
	String dis_date_chk_days_unit   = checkForNull(request.getParameter("dis_date_chk_days_unit"));
	String diag_update_period_max_unit  = checkForNull(request.getParameter("diag_update_period_max_unit"));
	String max_disch_period_for_predc	= checkForNull(request.getParameter("max_disch_period_for_predc"));
	String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));
	String pseudo_bed_yn			= checkForNull(request.getParameter("pseudo_bed_yn"),"N");
	String serverDate				= "";
	//String mr_mds_recorded			= "";//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String valid					= "";
	String from_time				= "";
	String max_param_date			= "";
	String valid_date				= "";

	int discharge_after_hrs 		= 0;
	int dis_date_chk_days 			= 0;
	int max_disch_period_for_dc		= 0;

	discharge_after_hrs				= Integer.parseInt(bed_block_period_dis);	
	dis_date_chk_days				= Integer.parseInt(dis_date_chk_days1);
	max_disch_period_for_dc			= Integer.parseInt(max_disch_period_for_predc);

	//  added by mujafar for ML-MMOH-CRF-0659 start


	AllowUserModifyDiscJson =  eIP.IPCommonBean.getIPParam(con,facilityId); // added by mujafar for ML-MMOH-CRF-0659
		allow_modify_disc_yn    =   (String)AllowUserModifyDiscJson.get("allow_modify_disc_yn"); 
			String language_direction="";
			int count=0;
			String pat_dtls_unknown_yn	= "N";
			int patient_age = 0;
			stmt=con.createStatement() ;
			
		PatDataJson  = eIP.IPCommonBean.getPatientDetails(con,locale,patient_id); 
		patient_age  = (Integer)PatDataJson.get("patient_age");
		language_direction=(String)PatDataJson.get("language_direction");
	
//	String indicator				= ""; 
	String ip_Trn_Date				= ""; 
	String dis_highrisk				= "";

//Added for  ML-MMOH-CRF-1611 by lakshmanan 
	boolean isDischrgBillStatus	= eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "DISCHARGE_BILL_STATUS");
	String disc_bill_exists			= ""; 
	String bill_genrt				= "";
	CallableStatement cstmt= null;
	Statement stmtbl 	= null;
	String paid_unpaid_status="";
	String check_msg="";
	if (isDischrgBillStatus) {
	try
	{
	stmtbl=con.createStatement();
	ResultSet rsetBL=null;		
	rsetBL = stmtbl.executeQuery(" SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facilityId+"','"+encounterid+"') disc_bill_exists FROM dual ");
	if(rsetBL.next())
	{
	disc_bill_exists = rsetBL.getString("disc_bill_exists");
	if(disc_bill_exists == null) disc_bill_exists = "";
		}
	if(rsetBL!=null) rsetBL.close();
	if(stmtbl != null) stmtbl.close(); 
	} catch (Exception e)
	{
		//out.println(" Exception in addModifyDischargePatientTabs.jsp : "+e);
		e.printStackTrace();
	}
	
	
	try
	{
		cstmt=con.prepareCall("{call BL_PMNT_STATUS(?,?,?,?,?)}");
		cstmt.setString(1,facilityId);// Facility
		cstmt.setString(2,patient_id);// patient_id
		cstmt.setString(3,eid);// encounter_id
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.execute();
		paid_unpaid_status = 	checkForNull(cstmt.getString(4));
		check_msg = 	checkForNull(cstmt.getString(5));

		cstmt.close();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			if(cstmt!=null) 
				cstmt.close();
		}
		catch(Exception es)
		{
			es.printStackTrace();
		}
	}
	if (disc_bill_exists.equals("Y")){
		bill_genrt="Generated";
	}else {
		bill_genrt="Not Generated";
		paid_unpaid_status="NA";
	}
	}
	// end ML-MMOH-CRF-1611	by lakshmanan


            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//Validation for Discharge Checklist on loading the page.. 
	String disch_chklist_status		="";
	StringBuffer chk_request =new StringBuffer();	
	if(Type_indicator.equals("DS")) {

            _bw.write(_wl_block8Bytes, _wl_block8);
}	

	if(dischg_chklst_app_yn.equals("Y")) {
		chk_request.delete(0, chk_request.length());
		chk_request.append("select disch_summary_signed_yn,informed_yn,disch_chklist_status from  ");
		chk_request.append(" ip_discharge_checklist where facility_id='"+facilityId+"' and ");
		chk_request.append(" encounter_id ="+encounterid+" ");
		rset = stmt.executeQuery(chk_request.toString());
		if(rset != null && rset.next()) {
			disch_chklist_status = rset.getString("disch_chklist_status");
			if(disch_chklist_status == null) disch_chklist_status="";
		}
		if(rset != null) rset.close(); 
		if(!disch_chklist_status.equals("1")) {	
	
            _bw.write(_wl_block9Bytes, _wl_block9);
	}
	}	

            _bw.write(_wl_block10Bytes, _wl_block10);


		String meddesc 					= "";	
		String chk1						= "";
		String chk2						= "";
		String medteamid 				= checkForNull(request.getParameter("medteamid"));
		String dis_val					= "";
		String check_val				= "";
		String target_date				= "";
		String from_hcare_setting_type_code	= "";
		//added on 3-07-2008 for SCR 3228
		String contact1_name			= "";
		String contact2_name			= "";
		String cnt						= "";
	//	String override_yn				="N";
		String dead_yn					= "";
		String maternal_death_yn		= "";	
		String indicator				= checkForNull(request.getParameter("indicator"));	
		String override_yn				= "";	
		String discharge_type_desc		= "";	
		String discharge_status_desc	= "";	
		//Added for the CRF - Bru-HIMS-CRF-0157
		String disch_reason_mand_yn="N";
		String allow_late_discharge_reason="";
		String edd_crossed="N";
		String allow_muti_bedside_review_yn="N"; //Added for this CRF HSA-CRF-0263.1
		try
		{
		/*Friday, April 30, 2010 ,SRR20056-SCF-4436-IN021088 condition added returned_yn = 'N' in where clause of pr_patient_valuables*/		
			int countValue				= 0;
			int mother_status			= 0;
			//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//String sql = "SELECT contact1_name, contact2_name,(SELECT COUNT (*) FROM ip_lodger_detail a WHERE a.facility_id = '"+facilityId+"' AND a.check_out_yn = 'N' AND a.patient_encounter_id = '"+encounterid+"') countvalue,(SELECT TO_CHAR (MAX (trn_date_time), 'dd/mm/rrrr hh24:mi') FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id =  '"+encounterid+"') ip_trn_date, (SELECT hcare_setting_type_code FROM sm_facility_param WHERE facility_id = '"+facilityId+"') hcare_setting_type_code,(mr_mds_recorded_yn ('"+facilityId+"','"+encounterid+"','"+patient_class+"','DA','')) mr_mds_recorded,(SELECT COUNT (*) FROM pr_patient_valuables WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' AND returned_yn = 'N') cnt , (select count(*)  from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+nursing_unit_code+"') m_status, am_get_desc.am_practitioner('"+auth_practitioner_id+"', '"+locale+"', 1) practitioner_name, (TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi')) serverDate FROM mp_pat_rel_contacts WHERE patient_id ='"+patient_id+"' " ;
			//String sql = "SELECT contact1_name, contact2_name,(SELECT COUNT (*) FROM ip_lodger_detail a WHERE a.facility_id = '"+facilityId+"' AND a.check_out_yn = 'N' AND a.patient_encounter_id = '"+encounterid+"') countvalue,(SELECT TO_CHAR (MAX (trn_date_time), 'dd/mm/rrrr hh24:mi') FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id =  '"+encounterid+"') ip_trn_date, (SELECT hcare_setting_type_code FROM sm_facility_param WHERE facility_id = '"+facilityId+"') hcare_setting_type_code,(SELECT COUNT (*) FROM pr_patient_valuables WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' AND returned_yn = 'N') cnt , (select count(*)  from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+nursing_unit_code+"') m_status, am_get_desc.am_practitioner('"+auth_practitioner_id+"', '"+locale+"', 1) practitioner_name, (TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi')) serverDate FROM mp_pat_rel_contacts WHERE patient_id ='"+patient_id+"' " ;
			//Below line modified for this HSA-CRF-0263.1
			String sql = "SELECT contact1_name, contact2_name,(SELECT COUNT (*) FROM ip_lodger_detail a WHERE a.facility_id = '"+facilityId+"' AND a.check_out_yn = 'N' AND a.patient_encounter_id = '"+encounterid+"') countvalue,(SELECT TO_CHAR (MAX (trn_date_time), 'dd/mm/rrrr hh24:mi') FROM ip_adt_trn WHERE facility_id = '"+facilityId+"' AND encounter_id =  '"+encounterid+"') ip_trn_date, (SELECT hcare_setting_type_code FROM sm_facility_param WHERE facility_id = '"+facilityId+"') hcare_setting_type_code,(SELECT COUNT (*) FROM pr_patient_valuables WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"' AND returned_yn = 'N') cnt , (select count(*)  from ip_nursing_unit_bed a, ip_open_encounter b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.main_bed_no = b.bed_num and b.encounter_id = '"+encounterid+"'  and b.facility_id = '"+facilityId+"' and a.occupying_patient_id is not null and a.nursing_unit_code = '"+nursing_unit_code+"') m_status,(select allow_muti_bedside_review_yn from ip_param where FACILITY_ID='"+facilityId+"') allow_muti_bedside_review_yn, am_get_desc.am_practitioner('"+auth_practitioner_id+"', '"+locale+"', 1) practitioner_name, (TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi')) serverDate FROM mp_pat_rel_contacts WHERE patient_id ='"+patient_id+"' " ;
			rset	=	stmt.executeQuery(sql);
			if(rset!=null && rset.next()){
				contact1_name			=	checkForNull(rset.getString("contact1_name"));
				contact2_name			=	checkForNull(rset.getString("contact2_name"));
				countValue				=	rset.getInt("countValue");
				ip_Trn_Date				= rset.getString("ip_trn_date");
				if (patient_class.equals("DC")) {
					from_time			= rset.getString("ip_trn_date");
				}
				from_hcare_setting_type_code = checkForNull(rset.getString("hcare_setting_type_code"));
			//	mr_mds_recorded			= checkForNull(rset.getString("mr_mds_recorded"));//Maheshwaran K commented for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
				cnt=rset.getString("cnt");
				mother_status			= rset.getInt("m_status");
				allow_muti_bedside_review_yn=checkForNull(rset.getString("allow_muti_bedside_review_yn")); //Added for this CRF HSA-CRF-0263.1
				auth_practitioner_name  = rset.getString("practitioner_name");
				serverDate				= rset.getString("serverDate");
			}
			

			// 11/5/2004 - For Day Care Issues starts
			if (patient_class.equals("DC")) {
					StringBuffer sqlBuffer = new StringBuffer();
					if (sqlBuffer.length() > 0)	sqlBuffer.delete(0, sqlBuffer.length());
					sqlBuffer.append(" SELECT TO_CHAR(TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"', 'dd/mm/rrrr hh24:mi' ) MAX_PARAM_DATE,   (CASE WHEN TRUNC (TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN 'N' ELSE 'Y' END ) VALID,   TO_CHAR((CASE WHEN TRUNC (  TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"') != TRUNC (TO_DATE ('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')) THEN trunc(TO_DATE('"+admission_date_time+"', 'DD/MM/rrrr hh24:mi')) ELSE TO_DATE('"+admission_date_time+"', 'dd/mm/rrrr hh24:mi')+ (1 / 24) * '"+max_disch_period_for_dc+"' END), 'dd/mm/rrrr') VALID_DATE,to_char((sysdate+'"+max_disch_period_for_dc+"'/24),'dd/mm/rrrr hh24:mi') target_date   FROM dual");
					//IP_ADT_TRN WHERE   facility_id = '"+facilityId+"' AND encounter_id = '"+encounterid+"'");					
					rset	= stmt.executeQuery(sqlBuffer.toString());
					if ((rset != null) && (rset.next())) {
						valid			= rset.getString("VALID");
						//from_time		= rset.getString("FROM_TIME");
						max_param_date	= rset.getString("MAX_PARAM_DATE");
						valid_date		= rset.getString("VALID_DATE");
						target_date     = rset.getString("target_date");
					}
					//valid_date = valid_date+ " 23:59";
					valid_date = max_param_date; //Modified for AAKH-SCF-0093
			}

			java.text.SimpleDateFormat dateFormat1	= new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
			java.sql.Timestamp sdate				= new Timestamp(System.currentTimeMillis()) ;
			String Sdate							= dateFormat1.format(sdate) ;
			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt						= new java.util.Date();
			String d								= dateFormat.format( dt ) ;
			String curdateWithoutTime				= d;
			String sec								= String.valueOf(dt.getMinutes());			
			if ((sec).length()==1) 
				sec="0"+sec; 
			else sec = sec;			
			d					=	d + " "+String.valueOf(dt.getHours())+":"+sec;
			int hrs				= discharge_after_hrs+dt.getHours();
			java.util.Date dt1	= new java.util.Date(dt.getYear(),dt.getMonth(),dt.getDate(),hrs,dt.getMinutes());
			String d1			= dateFormat.format( dt1 ) ;
			String sec1			= String.valueOf(dt.getMinutes());
			if ((sec1).length()==1) 
				sec1 = "0" + sec1; 
			else sec1 = sec1;

			d1  = d1 + " "+String.valueOf(dt1.getHours())+":"+sec1;
            d						    = checkForNull(request.getParameter("EXPECTED_DISCHARGE_DATE"));
			String dischargetypecode	= checkForNull(request.getParameter("discharge_type_code"));
			String dischargesummaryyn	= checkForNull(request.getParameter("discharge_summary_yn"));
			String takehomenewmedyn		= checkForNull(request.getParameter("take_home_new_med_yn"));
			String death_date_time		= checkForNull(request.getParameter("deceased_date_time"));
			
			d1						    = "";	
			
			if(dischargesummaryyn.equals("Y")) 
				chk1 = "checked";

			if(takehomenewmedyn.equals("Y"))   
				chk2 = "checked";		
	
			String exp_dis_date_display = DateUtils.convertDate(EXPECTED_DISCHARGE_DATE,"DMYHM","en",locale);
			String serverDate_display = DateUtils.convertDate(serverDate,"DMYHM","en",locale);					
			String death_date_time_display = "";
					
					if(death_date_time.equals(""))
						death_date_time_display = "";
					else
						death_date_time_display = DateUtils.convertDate(death_date_time,"DMYHM","en",locale);
			String bmi	= checkForNull(request.getParameter("bmi"));
		try
			{

				rset = stmt.executeQuery("select override_yn, deceased_yn, (IP_GET_DESC.ip_discharge_type('"+dischargetypecode+"','"+locale+"',2)) discharge_type_desc, (IP_GET_DESC.ip_discharge_status('"+discharge_status_code+"','"+locale+"',2)) discharge_status_desc,maternal_death_yn from ip_discharge_type_vw where  eff_status = 'E' and discharge_type_code='"+dischargetypecode+"' ");
				if(rset != null && rset.next()) {
					dead_yn					= checkForNull(rset.getString("deceased_yn"));
					maternal_death_yn		= checkForNull(rset.getString("maternal_death_yn"));
					discharge_type_desc		= checkForNull(rset.getString("discharge_type_desc"));
					override_yn				= checkForNull(rset.getString("override_yn"),"N");
					discharge_status_desc	= checkForNull(rset.getString("discharge_status_desc"));
				}
				if(rset != null) rset.close(); 
				if(stmt != null) stmt.close(); 
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
					
	
            _bw.write(_wl_block11Bytes, _wl_block11);
if(isHeightAndBmiEnable){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(auth_practitioner_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(auth_practitioner_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block21Bytes, _wl_block21);

			if(isHeightAndBmiEnable)
			{
				if(Type_indicator.equals("ED"))
				{
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
			}
			
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(auth_practitioner_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(auth_practitioner_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block27Bytes, _wl_block27);

		
	
	if(isModifyDiscTypeStatusAppl && allow_modify_disc_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0659	
			{
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

		
		String sel="";
		
		JSONArray DischargeTypeArray	= new JSONArray();
		DischargeTypeArray = eIP.IPCommonBean.getDischargeTypes(con,locale,indicator);
		
					for(int i = 0; i < DischargeTypeArray.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeTypeArray.get(i);
							String disCode	= (String) json.get("disCode");
							String disCode1	= (String) json.get("disCode1");
							String disDesc  = (String) json.get("disDesc");
							if(disCode1.equals(dischargetypecode))
								sel="selected";
							else
								sel="";
							
							out.println("<option value='"+disCode+"'" +sel+ ">"+disDesc+"</option>");
						}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dischargetypecode));
            _bw.write(_wl_block33Bytes, _wl_block33);
/*"dir" Added Above Line code for this SCF[AK-SCF-0153]*/
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

	
	
	if(!discharge_status_code.equals(""))
	{
	
	String sel_1="";
	
		JSONArray DischargeStatusArray	= new JSONArray();
		DischargeStatusArray = eIP.IPCommonBean.getDischargeStatus(con,locale,discharge_status_code);
		
					for(int i = 0; i < DischargeStatusArray.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeStatusArray.get(i);
							 String StatusCode	= (String) json.get("StatusCode");
							 String StatusDesc	= (String) json.get("StatusDesc");
							
							if(StatusCode.equals(discharge_status_code))
										 sel_1="selected";
									 else
										sel_1="";									
									out.println("<option value='"+StatusCode+"'" +sel_1+ ">"+StatusDesc+"</option>");
						}
		
	}
	else
	{
		if(indicator.equals("DS"))
			{
				
				JSONArray DischargeStatusA_all_Array	= new JSONArray();
				DischargeStatusA_all_Array = eIP.IPCommonBean.getDischargeStatus_all(con,locale,"DS");
				for(int i = 0; i < DischargeStatusA_all_Array.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeStatusA_all_Array.get(i);
							String code	= (String) json.get("code");
							String desc	= (String) json.get("desc");
							out.println("<option value='"+code+"' >"+desc+"</option>");
							
						}
					
			}
			else 
			{
				JSONArray DischargeStatusA_all_Array	= new JSONArray();
				DischargeStatusA_all_Array = eIP.IPCommonBean.getDischargeStatus_all(con,locale,"DS");
				for(int i = 0; i < DischargeStatusA_all_Array.size(); i++)
						{
							JSONObject json = (JSONObject)DischargeStatusA_all_Array.get(i);
							String code	= (String) json.get("code");
							String desc	= (String) json.get("desc");
							out.println("<option value='"+code+"' >"+desc+"</option>");
							
						}
				
			}

	}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(discharge_status_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
			else
			{
			
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(discharge_type_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(dischargetypecode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block44Bytes, _wl_block44);

			if(isHeightAndBmiEnable)
			{
				if(Type_indicator.equals("ED"))
				{
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 
				String disc_to=eIP.IPCommonBean.getDischargeTo(con,facilityId,encounterid,patient_id,patient_class);
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(disc_to));
            _bw.write(_wl_block48Bytes, _wl_block48);

				}
			}
			
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(discharge_status_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(discharge_status_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(exp_dis_date_display));
            _bw.write(_wl_block55Bytes, _wl_block55);

			if(isHeightAndBmiEnable)
			{
				if(Type_indicator.equals("ED"))
				{
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
			}
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(serverDate_display));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block59Bytes, _wl_block59);

			try{
				allow_late_discharge_reason=request.getParameter("allow_late_discharge_reason");
				disch_reason_mand_yn=request.getParameter("disch_reason_mand_yn");

				if (allow_late_discharge_reason == null || allow_late_discharge_reason.equals("") ){
					allow_late_discharge_reason="N";
				}
				if (allow_late_discharge_reason.equals("Y")){
					java.text.SimpleDateFormat sdf	= new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
					java.util.Date exp_dis_date=sdf.parse(exp_dis_date_display);
					java.util.Date server_date=sdf.parse(serverDate_display);
					if (exp_dis_date.compareTo(server_date) < 0)
					{
						edd_crossed="Y";
						
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

						stmt = con.createStatement();
						rset = stmt.executeQuery("select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1) Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where REASON_FOR_LATE_DISCH_YN = 'Y' and Eff_Status = 'E' order by 1");
						if(rset!=null)
						{
							while(rset.next())
							{
								String contact_code = rset.getString("Contact_Reason_Code");
								String contact_desc = rset.getString("Contact_Reason");
								out.println("<option value='"+contact_code+"'>"+contact_desc+"</option>"); 
							}
						}
						out.println("<option value='others'>Others</option></select>"); 
						if(rset!=null) rset.close();
						if(stmt!=null) stmt.close();
						
            _bw.write(_wl_block63Bytes, _wl_block63);
if(disch_reason_mand_yn != null && disch_reason_mand_yn.equals("Y"))
						{
            _bw.write(_wl_block64Bytes, _wl_block64);
}
						
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
}
					}
				}	
				catch(Exception e){
					e.printStackTrace();
				}
				
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(Type_indicator));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(edd_crossed));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block71Bytes, _wl_block71);

						if(isHeightAndBmiEnable)
						{
							if(Type_indicator.equals("ED"))
							{
            _bw.write(_wl_block72Bytes, _wl_block72);

							}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
}
						}else{
            _bw.write(_wl_block74Bytes, _wl_block74);
}
						
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(discharge_narration));
            _bw.write(_wl_block77Bytes, _wl_block77);
	// Added for  ML-MMOH-CRF-1611
						if (isDischrgBillStatus) { 
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bill_genrt));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(paid_unpaid_status));
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

				
			if ((dischargetypecode != null) && (dead_yn.equals("Y")))
			{
				check_val	= "Checked";
				dis_val		= "";
			}
			else
			{
				check_val	= "";
				dis_val		= "Disabled";
			}
		
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(check_val));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(death_date_time_display));
            _bw.write(_wl_block89Bytes, _wl_block89);

			if ((dischargetypecode != null) && (dead_yn.equals("Y")))
				dis_val		= "";
			else
				dis_val		= "Disabled";

			if ((dischargetypecode != null) && (post_mortem_req_yn.equals("Y")))
				check_val	= "Checked";
			else
				check_val	= "";
		
		
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(dis_val));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(check_val));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
if(dead_yn.equals("Y")){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(serverDate_display));
            _bw.write(_wl_block96Bytes, _wl_block96);
}else{
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);

	if (dischargetypecode != null && dead_yn.equals("Y"))
	{
		out.println("<script>document.getElementById('bodyreleasedImg').style.visibility='visible';</script>");
		out.println("<script>document.forms[0].body_released_date.disabled=false;document.getElementById('calcomp1').disabled=false;</script>");
	}
	else
	{
		out.println("<script>document.getElementById('bodyreleasedImg').style.visibility='hidden';</script>");
		out.println("<script>document.forms[0].body_released_date.disabled=true;document.getElementById('calcomp1').disabled=true;</script>");
	}
	if(dischargetypecode!=null && dischargetypecode.equals("DT"))
		dis_highrisk	=	"";
	else
		dis_highrisk	=	"Disabled";


            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(dis_highrisk));
            _bw.write(_wl_block101Bytes, _wl_block101);
 if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && dead_yn.equals("Y") && !death_reg_form_accession_num.equals("")){ 
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(to_specialty_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(to_locn_code));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
} 
            _bw.write(_wl_block107Bytes, _wl_block107);

			
			String chck_val="";
			String disb_val="";
			if (med_lgl_case_yn.equals("Y")) 
			{
				chck_val = "Checked";
				disb_val = "";
			}
			else 
			{	
				chck_val = "";
				disb_val = "Disabled";
			}
		
            _bw.write(_wl_block108Bytes, _wl_block108);
if(siteSpecific){
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(chck_val));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(pol_rep_no));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(pol_rep_no));
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(pol_stn_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(pol_stn_id));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(pol_id));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(pol_id));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(chk2));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(chk1));
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

			if ((dead_yn.equals("Y")) || (patient_status.equals("3")) )
			{
		
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")));
            _bw.write(_wl_block128Bytes, _wl_block128);

			}else
			{
		
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")));
            _bw.write(_wl_block129Bytes, _wl_block129);

			}
		
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            {java.lang.String __page ="../../eIP/jsp/InformedDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf("dischage_patient")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("informed_to"), weblogic.utils.StringUtils.valueOf(informed_to
                        )},{ weblogic.utils.StringUtils.valueOf("informed_name"), weblogic.utils.StringUtils.valueOf(informed_name
                        )},{ weblogic.utils.StringUtils.valueOf("informed_date_time"), weblogic.utils.StringUtils.valueOf(informed_date_time
                        )},{ weblogic.utils.StringUtils.valueOf("system_date_time"), weblogic.utils.StringUtils.valueOf(Sdate
                        )},{ weblogic.utils.StringUtils.valueOf("encounterID"), weblogic.utils.StringUtils.valueOf(encounterid
                        )},{ weblogic.utils.StringUtils.valueOf("admissiondatetime"), weblogic.utils.StringUtils.valueOf(admission_date_time
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block2Bytes, _wl_block2);

String abscond_details="visibility:hidden"; // added by mujafar for ML-MMOH-CRF-0659
if(Type_indicator.equals("AB"))
{
    abscond_details="visibility:visible"; // added by mujafar for ML-MMOH-CRF-0659
	
	if ((absconded_yn != null) && (absconded_yn.equals("Y")))
	{
		check_val	= "Checked";
		dis_val		= "Disabled";
	}
	else
	{
		check_val	= "";
		dis_val		= "Disabled";
	}
}

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(abscond_details));
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            {java.lang.String __page ="../../eIP/jsp/AbscondingDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("Discharge_Patient")},{ weblogic.utils.StringUtils.valueOf("add_reported"), weblogic.utils.StringUtils.valueOf(reported_to
                        )},{ weblogic.utils.StringUtils.valueOf("dis_val"), weblogic.utils.StringUtils.valueOf(dis_val
                        )},{ weblogic.utils.StringUtils.valueOf("check_val"), weblogic.utils.StringUtils.valueOf(check_val
                        )},{ weblogic.utils.StringUtils.valueOf("absconded_date"), weblogic.utils.StringUtils.valueOf(absconded_date
                        )},{ weblogic.utils.StringUtils.valueOf("def_val"), weblogic.utils.StringUtils.valueOf("true")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(isModifyDiscTypeStatusAppl));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(absconded_date));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(allow_modify_disc_yn));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(serverDate_display));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(admission_short_desc));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(meddesc));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(patient_type_short_desc));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(service_short_desc));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(bed_class_short_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(patient_status));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(patient_type));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(subservice_code));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(discharge_after_hrs));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(serverDate));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(curdateWithoutTime));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(from_hcare_setting_type_code));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(dis_date_chk_days_unit));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(medteamid));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(to_locn_type));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(serverDate));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(to_ref_code));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(to_service_code));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(to_locn_type));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(to_locn_code));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(to_specialty_code));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(target_date));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(countValue));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(dead_yn));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(post_mortem_req_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(maternal_death_yn));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(diag_update_period_max_unit));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(mother_status));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(valid));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(max_param_date));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(valid_date));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(ip_Trn_Date));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block214Bytes, _wl_block214);
/*=mr_mds_recorded*/
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(contact2_name));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(isHeightAndBmiEnable));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(daycare_unit_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(informed_to));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block223Bytes, _wl_block223);

	if(Type_indicator.equals("AB"))
		out.println("<script>document.DischargePatient_form.absconding_date.disabled = true;</script>");

	/// If the value of DECEASED_YN field from ip_discharge_type table...is "Y" the referral Details are disabled as the patient is dead else Enabled ...
	if(cnt.equals("0"))
	{	
		out.println("");
		//out.println("<script>parent.frames[3].document.getElementById('valuble').disabled = true;</script>");
	}
	else if(patient_status.equals("3"))
	{	
            _bw.write(_wl_block224Bytes, _wl_block224);
	}
	else if(patient_status.equals("") && Type_indicator.equals("AB"))
	{
		out.println("<script>document.getElementById('calImage').disabled=true;</script>");

	}
	else if(patient_status.equals("4"))
	{ 
		out.println("<script>document.forms[0].bookingappointment.disabled=true;</script>");
	}
	
	if(rset!=null) rset.close();
	if(rset1!=null) rset1.close();
	if(stmt!=null) stmt.close();
	//if(hash!=null) hash.clear();

	}catch(Exception e)
	{
		//out.print("Exception @ addModifyDischargePatientTabs.jsp"+e);
		e.printStackTrace();
	}	
	finally   
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block225Bytes, _wl_block225);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdditionalDischargeDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AuthorizedPractitioner.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargingPractitioner.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargetype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeStatus.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargetype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeTo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeStatus.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedatetime.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonForLateDischarge.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.otherReason.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeBill.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PayementStatus.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceaseddetails.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceased.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deathdatetime.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PostMortemRequested.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BodyReleasedtoMortuary.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.highriskbody.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeathRegForm.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalLegalCase.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlcdetails.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mlc.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PoliceReportNo.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.station.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdditionalDischargeDetails.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdditionalDischargeDetails.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedBlockDetails.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockType.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockPeriod.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedBlockleduntil.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InformedDetails.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AbscondingDetails.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
