package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __encsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSearchResult.jsp", 1743491114953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<script>\n\nasync function patientValuables(encID, PatID, locn_code, splty_code)\n{\n\t\n\t\tvar function_name=document.forms[0].call_function.value;\n\t\t document.forms[0].PatientId.value=PatID;\n\t    if(function_name== \"MR_REC_PAT_VAL\")\n\t\t{\n\t\t\t document.forms[0].PatientId.value=\"\";\n\t\t\tvar call_function = \"MR_REC_PAT_VAL\";\n\t\t\tvar FacilityId = document.forms[0].FacilityId.value;\n\t\t\tvar dialogHeight= \"25\" ;\n\t\t\tvar dialogWidth = \"50\" ;\n\t\t\tvar dialogTop \t= \"70\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\n\t\t\tretVal =await  \twindow.showModalDialog(\"../../eMR/jsp/PatientValuablesMain.jsp?encounterId=\"+encID+\"&FacilityId=\"+FacilityId+\"&patientId=\"+PatID+\"&locn_code=\"+locn_code+\"&splty_code=\"+splty_code+\"&call_function=\"+call_function,arguments,features);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].Enc_id.value\t= encID;\n\t\t\tdocument.forms[0].Pat_id.value\t= PatID;\n\t\t\tdocument.forms[0].target=\"messageFrame\";\n\t\t\tdocument.forms[0].action=\'../../servlet/eMR.PatientValuablesServlet\';\n\t\t\tdocument.forms[0].submit();\n\t\t}\n}\n\n\n</script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\"../js/EncSearchMain.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body OnMouseDown=\'CodeArrest();\' onLoad=\'//chkForSelectAll(";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =",";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =")\' onKeyDown=\'lockKey()\'>\n<form name=\'EncSearchResult\' id=\'EncSearchResult\'  action=\"../../eOR/jsp/EncSearchResult.jsp\" method=\"post\"  >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t</table><br><br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<th class=\'columnheadercenter\' nowrap></th>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<th class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<BR><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\'selectAll(this,\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\'></th>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<th class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n \t\t\t\t<th class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th> \n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t<th class=\'columnheadercenter\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</table>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" \n\t\t\t</tr>\n\t\t</table> \n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<TR><td colspan=6 class=\"white\">&nbsp;</td></TR>\n\t\t</table>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<TR>\n<!-- \t\t<th align=\'center\' nowrap>Patient ID</th> -->\n\t\t\t<th class=\'columnheadercenter\' nowrap>Encounter Type</th> \n\t\t\t<th class=\'columnheadercenter\' nowrap>Admission Date</th> \n\t\t\t<th class=\'columnheadercenter\' nowrap>Encounter ID</th>\n\t\t\t<th class=\'columnheadercenter\' nowrap>Location Type</th>\n\t\t\t<th class=\'columnheadercenter\' nowrap>Location</th>\n\t\t\t<th class=\'columnheadercenter\' nowrap>Practitioner</th>\n\t\t\t<th class=\'columnheadercenter\' nowrap>Speciality</th>\n\t\t\t<th class=\'columnheadercenter\' nowrap>Discharge Date</th>\n\t\t</TR>\n\t\t\t<input type=\'hidden\' name=\'tempIDS\' id=\'tempIDS\'  >\n\t\t\t<input type=\'hidden\' name=\'encIDS\' id=\'encIDS\' >\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<script>\n\t\t\tenc_id\t= \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\tdocument.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+\"|\";\n\n\t\t</script>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<script>\n\t\t\tenc_id\t= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\tdocument.forms[0].encIDS.value=document.forms[0].encIDS.value+enc_id+\"|\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</TABLE>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t<input type=\'hidden\' name=\'PatientId\' id=\'PatientId\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\'hidden\' name=\'temp1\' id=\'temp1\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t<input type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\n\t<input type=\'hidden\' name=\'lstPatientClass\' id=\'lstPatientClass\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_exp_date\' id=\'alt_id1_exp_date\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_exp_date\' id=\'alt_id2_exp_date\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\n\t<input type=\'hidden\' name=\'p_discharge_date_from\' id=\'p_discharge_date_from\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\'hidden\' name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\n\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t<input type=\'hidden\' name=\'alt_id1_no\' id=\'alt_id1_no\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\'hidden\' name=\'alt_id2_no\' id=\'alt_id2_no\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\'hidden\' name=\'alt_id3_no\' id=\'alt_id3_no\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t<input type=\'hidden\' name=\'alt_id4_no\' id=\'alt_id4_no\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_type\' id=\'other_alt_type\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t<input type=\'hidden\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t<input type=\'hidden\' name=\"selectAll_yn\" id=\"selectAll_yn\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\'hidden\' name=\"hddEncID\" id=\"hddEncID\" value=\"\">\n\t\n\t<input type=\'hidden\' name=\"p_encounter_id\" id=\"p_encounter_id\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\'hidden\' name=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\'hidden\' name=\"marked_status\" id=\"marked_status\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\n\t<input type=\'hidden\' name=\"Enc_id\" id=\"Enc_id\" value=\"\">\n\t<input type=\'hidden\' name=\"Pat_id\" id=\"Pat_id\" value=\"\">\n\n\t<br><center>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet MedicalReportReq= null;synchronized(session){
                MedicalReportReq=(webbeans.eCommon.RecordSet)pageContext.getAttribute("MedicalReportReq",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(MedicalReportReq==null){
                    MedicalReportReq=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("MedicalReportReq",MedicalReportReq,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
	String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String title =request.getParameter("title")==null?"":request.getParameter("title");	

	if(!title.equals(""))
	{
		out.println("<title>"+title+"</title>");
	}

	String classValue	 = "";
	StringBuffer sqlbuff = new StringBuffer();
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String criteria =request.getParameter("criteria")==null?"":request.getParameter("criteria");	
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");	
	String finalSelect="",temp1="";
	String selectAll_yn=request.getParameter("selectAll_yn")==null?"":request.getParameter("selectAll_yn");

	if(selectAll_yn == null) selectAll_yn="";
	finalSelect=request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
 	if(finalSelect == null) finalSelect="";
	
	String Enc_Type = request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");

	String orderBy=request.getParameter("orderBy");
	if(orderBy == null || orderBy.equals("ET")) 
		orderBy = " to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') desc";
	else if(orderBy.equals("ED")) 
		orderBy = "a.visit_adm_date_time desc";
    String Patient_ID="";
	String SystemDate	=	request.getParameter("SystemDate")==null?"":request.getParameter("SystemDate");
	String alt_id1_exp_date=request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
	if(alt_id1_exp_date == null) alt_id1_exp_date="";
	else
		alt_id1_exp_date = DateUtils.convertDate(alt_id1_exp_date,"DMY",locale,"en");

	String alt_id2_exp_date=request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
	
	if((alt_id2_exp_date == null)|| alt_id2_exp_date.equals("")) 
		alt_id2_exp_date=SystemDate;
	else
		alt_id2_exp_date = DateUtils.convertDate(alt_id2_exp_date,"DMY",locale,"en");

	String p_discharge_date_from=request.getParameter("p_discharge_date_from")==null?"":request.getParameter("p_discharge_date_from");
	if(!(p_discharge_date_from==null || p_discharge_date_from.equals("")))
	{
		if(p_discharge_date_from.length() >10)
			p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMYHM",locale,"en");
		else
			p_discharge_date_from = DateUtils.convertDate(p_discharge_date_from,"DMY",locale,"en");
	}

	String p_discharge_date_to=request.getParameter("p_discharge_date_to")==null?"":request.getParameter("p_discharge_date_to");	
	if(!(p_discharge_date_to==null || p_discharge_date_to.equals("")))
	{
		if(p_discharge_date_to.length() >10)
			p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMYHM",locale,"en");
		else
			p_discharge_date_to = DateUtils.convertDate(p_discharge_date_to,"DMY",locale,"en");
	}

	String national_id_no=request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");

	if(national_id_no == null) national_id_no="";

	String alt_id1_no=request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
	if(alt_id1_no == null) alt_id1_no="";
	
	String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
	if(alt_id2_no == null) alt_id2_no="";
	
	String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
	if(alt_id3_no == null) alt_id3_no="";
	
	String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
	if(alt_id4_no == null) alt_id4_no="";

	String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");	
	if(other_alt_type == null) other_alt_type="";	
	
	String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
	if(other_alt_Id == null) other_alt_Id="";


	temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
	if(temp1 == null) temp1="";

	String mlc_oscc = request.getParameter("marked_status")==null?"":request.getParameter("marked_status");
	String flag="";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";

    req_start       =   (request.getParameter("from")==null)   ?   "0" :   request.getParameter("from");
    req_end         =   (request.getParameter("to")==null)     ?   "0" :   request.getParameter("to");

	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String Encounter_ID="";
	
	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";

	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String no_of_days			=request.getParameter("no_of_days");
	if(no_of_days == null) no_of_days="";
	
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";		

		if(call_function.equals("REPRINT_PAT_VAL"))
		{
			PatientId= "";
		}

	String EncounterId		=	request.getParameter("p_encounter_id") ;

	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String AdmissionDate	=	request.getParameter("AdmissionDate")==null?"":request.getParameter("AdmissionDate") ;
	if(AdmissionDate == null || AdmissionDate.equals("null"))	AdmissionDate = "";
	if(!(AdmissionDate==null || AdmissionDate.equals("")))
	{
		if(AdmissionDate.length() >10)
			AdmissionDate = DateUtils.convertDate(AdmissionDate,"DMYHM",locale,"en");
		else
			AdmissionDate = DateUtils.convertDate(AdmissionDate,"DMY",locale,"en");
	}
	
	String DischargeDate	=	request.getParameter("DischargeDate") ;
	if(DischargeDate	== null || DischargeDate.equals("null"))DischargeDate = "";
	if(!(DischargeDate==null || DischargeDate.equals("")))
	{
		if(DischargeDate.length() >10)
			DischargeDate = DateUtils.convertDate(DischargeDate,"DMYHM",locale,"en");
		else
			DischargeDate = DateUtils.convertDate(DischargeDate,"DMY",locale,"en");
	}

	String Discharge	=	request.getParameter("discharge_val") ;
	if(Discharge	== null || Discharge.equals("null"))Discharge = "";


	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
	}
	

	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" )) ;
	String modal_yn = checkForNull(request.getParameter("modal_yn")) ;



	String install_yn="";
	if(modal_yn.equals("Y"))
		install_yn =checkForNull(request.getParameter( "bl_install_yn" )) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
	{
		if(from.equals(""))start=1;
		else
		start = Integer.parseInt( from ) ;
	}

	if ( to == null )
		end = 10 ;
	else
	{
		if(to.equals(""))end=10;
		else
		end = Integer.parseInt( to ) ;
	}

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Statement stmt_bl			= null;
	ResultSet rs_bl				= null;
	Connection conn = ConnectionManager.getConnection(request);	

try
{
	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("chk"+(i)) != null)
			 {
				 checkedOnes = request.getParameter("chk"+(i));
				 if(!(MedicalReportReq.containsObject(checkedOnes)))
				 {
					 MedicalReportReq.putObject(checkedOnes);
				 }
				 j++;
			 }
		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
		i = 1 ;
//Check for bl_interfaced_yn condition.......added by kishore
	if(!modal_yn.equals("Y"))
	{

		//String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id='"+FacilityId+"'";//common-icn-0180
		String query_bl_interface="select nvl(bl_interfaced_yn,'N') bl_interfaced_yn from ip_param where facility_id=?";//common-icn-0180
		try
		{
			//stmt_bl=conn.createStatement();//common-icn-0180
			pstmt=conn.prepareStatement(query_bl_interface);//common-icn-0180
			pstmt.setString(1, FacilityId);//common-icn-0180
			rs_bl=pstmt.executeQuery();//common-icn-0180
			//rs_bl=stmt_bl.executeQuery(query_bl_interface);//common-icn-0180
			if(rs_bl.next())
			{
				install_yn=rs_bl.getString("bl_interfaced_yn");
			}
		
		if(rs_bl != null) rs_bl.close();
		if(stmt_bl != null) stmt_bl.close(); 
		}
		catch(Exception e)
		{
			//out.println("Exception @try1"+e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
		}
	}


            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(start));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(end));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String Where  = "";

	Where  = " where a.patient_id=b.patient_id and a.facility_id='"+FacilityId+"' ";

	if(!PatientId.equals(""))
	{ 		
		Where  = Where +" and b.patient_id like '"+PatientId+"%' ";
	}

	/**********/
	if(call_function.equals("GEN_PLACE_ORDER") ) 
	{	
		Where  = Where +" and a.attend_practitioner_id is not null ";
		if(Enc_Type.equals("IP") || Enc_Type.equals("DC"))
			Where  = Where +" and a.adt_status in ('00','01')";
		else if(Enc_Type.equals("EM") || Enc_Type.equals("OP"))
			Where  = Where +" and a.visit_status < '07' ";
	}

	if (!(Enc_Type == null || Enc_Type.equals("")) )
	{
	 
		Where = Where + " and upper(PATIENT_CLASS) like upper('"+Enc_Type+"') ";
	}

	if ( !(EncounterId == null || EncounterId.equals("")) )
	{
		Where = Where + " and a.encounter_id like '"+EncounterId+"%'";
	}
	if ( !(alt_id1_exp_date == null || alt_id1_exp_date.equals("")) && !(alt_id2_exp_date == null || alt_id2_exp_date.equals("")))
	{
		Where = Where + " and trunc(a.visit_adm_date_time) between to_date('"+alt_id1_exp_date+"','dd/mm/yyyy') and to_date('"+alt_id2_exp_date+"','dd/mm/yyyy')";
	}

	if ( !(p_discharge_date_from == null || p_discharge_date_from.equals("")) )
	{
	
		Where = Where + " and trunc(a.discharge_date_time) >= to_date('"+p_discharge_date_from+"','dd/mm/yyyy ')";
	}

	if ( !(p_discharge_date_to == null || p_discharge_date_to.equals("")) )
	{
	 
		Where = Where + " and trunc(a.discharge_date_time) <= to_date('"+p_discharge_date_to+"','dd/mm/yyyy ')";
	}

	if ( !(national_id_no == null || national_id_no.equals("")) )
	{
		
		Where = Where + " and upper(b.NATIONAL_ID_NO) like upper('"+national_id_no+"%') ";
	}
	if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
	{
		
		Where = Where + " and upper(b.alt_id1_no) like upper('"+alt_id1_no+"%') ";
	}
	if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
	{
	   
		Where = Where + " and upper(b.alt_id2_no) like upper('"+alt_id2_no+"%') ";
	}
	if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
	{
		 
		Where = Where + " and upper(b.alt_id3_no) like upper('"+alt_id3_no+"%') ";
	}
	if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
	{
		 
		Where = Where + " and upper(b.alt_id4_no) like upper('"+alt_id4_no+"%') ";
	}

	if ( !(other_alt_type == null || other_alt_type.equals("")) )
	{
		
		Where = Where + " and upper(b.oth_alt_id_type) like upper('"+other_alt_type+"%') ";
	}
	if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
	{
		
		Where = Where + " and upper(b.oth_alt_Id_no) like upper('"+other_alt_Id+"%') ";
	}

if ( !(orderBy == null || orderBy.equals("")) )
{
	Where = Where + " order by "+orderBy+" ";
}
	int maxRecord = 0;
	if(!modal_yn.equals("Y"))
	{
		
			if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
			sqlbuff.append("select count(1) from  pr_encounter a, mp_patient b");
			sqlbuff.append(Where);
		
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
		

		pstmt = conn.prepareStatement(sqlbuff.toString());
		rs = pstmt.executeQuery();

		if(rs.next())
		   maxRecord = rs.getInt(1);
	}
	if (maxRecord==0 && !modal_yn.equals("Y"))
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
	else
	{

	    if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
		//sqlbuff.append(" select a.VISIT_ADM_TYPE, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name, ");//common-icn-0180
		sqlbuff.append(" select a.VISIT_ADM_TYPE, a.patient_id, decode(?,'en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name, ");//common-icn-0180
		
		sqlbuff.append(" b.Sex Gender, ");
		sqlbuff.append(" to_char(b.date_of_birth,'dd/mm/yy')birth_date, ");
		sqlbuff.append(" to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date,");
		//sqlbuff.append(" a.encounter_id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') END) Speciality_desc,");//common-icn-0180
		sqlbuff.append(" a.encounter_id, (CASE WHEN a.Specialty_Code IS NOT NULL  THEN AM_GET_DESC.AM_SPECIALITY(a.Specialty_Code,?,'2') END) Speciality_desc,");//common-icn-0180
		
		sqlbuff.append(" a.specialty_code specialty_code,");
		//sqlbuff.append("DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,'"+locale+"','1')) Locn_desc,");//common-icn-0180
		sqlbuff.append("DECODE(a.Assign_Care_Locn_Type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.Facility_Id, a.Assign_Care_Locn_Code,?,'2'), OP_GET_DESC.OP_CLINIC(a.Facility_Id,a.Assign_Care_Locn_Code,?,'1')) Locn_desc,");//common-icn-0180
		
		sqlbuff.append(" a.assign_care_locn_code locn_code, a.attend_practitioner_id,");
		//sqlbuff.append(" (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,'"+locale+"','1') END) Practitioner_Name, a.assign_room_num room_no, a.assign_bed_num bed_no,AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,'"+locale+"','1') Locn_Type, a.assign_care_locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,'"+locale+"','1') Patient_Class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b ");//common-icn-0180
		sqlbuff.append(" (CASE WHEN a.Attend_Practitioner_Id IS NOT NULL  THEN AM_GET_DESC.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') END) Practitioner_Name, a.assign_room_num room_no, a.assign_bed_num bed_no,AM_GET_DESC.AM_CARE_LOCN_TYPE(a.Assign_Care_Locn_Type,?,'1') Locn_Type, a.assign_care_locn_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,AM_GET_DESC.AM_PATIENT_CLASS(a.Patient_Class,?,'1') Patient_Class, a.patient_class patient_class_code, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b ");//common-icn-0180

		sqlbuff.append(Where);
		//out.println(sqlbuff.toString());

		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
		pstmt = conn.prepareStatement(sqlbuff.toString());
		//common-icn-0180 starts
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		pstmt.setString(4, locale);
		pstmt.setString(5, locale);
		pstmt.setString(6, locale);
		pstmt.setString(7, locale);
		//common-icn-0180 starts
		rs = pstmt.executeQuery();

		if(!flag.equals("true"))
		{
			if(!PatientId.equals(""))
			{	
            _bw.write(_wl_block10Bytes, _wl_block10);
	
				if(!call_function.equals("QUERY_MATERNAL_REPORT"))
				{	
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block14Bytes, _wl_block14);

				}
				
            _bw.write(_wl_block15Bytes, _wl_block15);

			}	
			
            _bw.write(_wl_block16Bytes, _wl_block16);

		if ( !(start <= 1) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(start-10)+","+(end-10)+")\" text-decoration='none'>Previous</A>");
		if ( !( (start+10) > maxRecord ) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(start+10)+","+(end+10)+")\" text-decoration='none'>Next</A>");
	
            _bw.write(_wl_block17Bytes, _wl_block17);
	
		if(!call_function.equals("QUERY_MATERNAL_REPORT"))
		{	 
		
            _bw.write(_wl_block18Bytes, _wl_block18);
	
		}	
	   
            _bw.write(_wl_block19Bytes, _wl_block19);
 
		 if(	!call_function.equals("MARK_MLC_OSCC") && 
		!call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") &&  !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")&&
		!call_function.equals("QUERY_MARK_MLC_OSCC") &&
		!call_function.equals("QUERY_MATERNAL_REPORT") &&
		!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS") )
		{	 
		 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(start));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(end));
            _bw.write(_wl_block23Bytes, _wl_block23);

		}	
		 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
	
		if(!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS")) 
		{	
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		}
		
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		if(call_function.equals("QUERY_MARK_MLC_OSCC") || call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL") || call_function.equals("DIAG_RECODE")|| call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{
	  
			if (PatientId.equals("")) 
			{	
			
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			} 
		}	
		if(call_function.equals("QUERY_MATERNAL_REPORT") || call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		}	
		if(!call_function.equals("QUERY_MATERNAL_REPORT") && !call_function.equals("MEDICAL_REPORT_REQUEST") && !call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL")  && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("QUERY_MARK_MLC_OSCC")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
		{	
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		}	
		if( call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		}  
		
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		String chkAttribute		= "";
		String P_DEP_APPL_YN	= "";
		String Patient_Class_code = "";
		String Encounter_Date_display = "";
		

		if ( rs != null )
		{
			if ( start != 1 )

			for( int j=1; j<start; i++,j++ )
				rs.next() ;

				while ( rs.next() && i<=end )
				{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					Patient_ID=rs.getString("patient_id");		

					Patient_Class_code= rs.getString("patient_class_code");
				
					Encounter_ID=rs.getString("encounter_id");	

					String Patient_Name=rs.getString("Patient_Name");				
					String conGender=rs.getString("Gender");				
					String Date_of_Birth=rs.getString("birth_date");				
					String Patient_Class=rs.getString("Patient_class");	
					String Encounter_Date=rs.getString("encounter_date");				
					String con_Speciality=rs.getString("Speciality_desc");				
					String specialty_code=rs.getString("specialty_code");				
					String con_Location=rs.getString("Locn_desc");				
					String locn_code=rs.getString("locn_code");				
					String con_Practitioner=rs.getString("Practitioner_Name");				
					String attend_practitioner_id=rs.getString("attend_practitioner_id");				
					String room_no=rs.getString("room_no");				
					String bed_no=rs.getString("bed_no");				
					String locn_type=rs.getString("Locn_type");		
					String Encounter_Type = rs.getString("Locn_type");
					String assign_care_locn_type = rs.getString("assign_care_locn_type");
					String visit_adm_type= checkForNull(rs.getString("visit_adm_type"));

		if(MedicalReportReq.containsObject(Encounter_ID))  
			chkAttribute = "CHECKED";
		else
			chkAttribute="";

		int recordIndex = MedicalReportReq.indexOfObject(Encounter_ID);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    									    	
			MedicalReportReq.removeObject(recordIndex);

					if(Patient_ID==null	      || Patient_ID.equals("null"))		    
						Patient_ID = "";
					if(Patient_Name==null	  || Patient_Name.equals("null"))				Patient_Name = "";
					if(conGender==null	      || conGender.equals("null"))		    
						conGender = "";

					if(conGender.equals("M"))
					{
						conGender =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					}
					else if (conGender.equals("F"))
					{
						conGender =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					}
					 else 
					{
						conGender =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}

					if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
						Date_of_Birth = "";
					if(Patient_Class==null	  || Patient_Class.equals("null"))
						Patient_Class = "";
					if(Encounter_Date==null	  || Encounter_Date.equals("null"))
					{
						Encounter_Date = "";
						Encounter_Date_display = "";
					}
					else
						Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
					if(Encounter_ID==null	  || Encounter_ID.equals("null"))
						Encounter_ID = "";
					if(con_Speciality==null	  || con_Speciality.equals("null"))
						con_Speciality = "&nbsp;";
					if(con_Location==null	  || con_Location.equals("null"))
						con_Location = "&nbsp;";
					if(con_Practitioner==null || con_Practitioner.equals("null"))
						con_Practitioner = "&nbsp;";
					if(attend_practitioner_id==null || attend_practitioner_id.equals("null"))
						attend_practitioner_id = "";
					if(room_no==null || room_no.equals("null"))
						room_no = "&nbsp;";
					if(bed_no==null || bed_no.equals("null"))
						bed_no = "&nbsp;";
					if(locn_type==null || locn_type.equals("null"))
						locn_type = "&nbsp;";
					if(Encounter_Type==null || Encounter_Type.equals("null"))
						Encounter_Type = "&nbsp;";
					if(assign_care_locn_type==null || assign_care_locn_type.equals("null"))
						assign_care_locn_type = "";

		out.println("<tr>");
		if(!call_function.equals("QUERY_MATERNAL_REPORT"))
		{
			 
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"')\">");	
			out.print("+</a></td>");				
		}

		if(!call_function.equals("MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("TRANSMIT_NOTIFY_REP") && !call_function.equals("CONF_TRANSMIT_NOTIFY_REP")  && !call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT")  &&!call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
		{
			
			out.println("<td align=middle nowrap class='"+classValue+"'><input type=checkbox name='chk"+i+"' id='chk"+i+"' value='"+i+"' onClick='javascript:RemSelectAll();chkServices(this);' /></td>");
		}
        
		
		out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");

		if(!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("DIAG_RECODE")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
		{
				
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				//Patient_Class--Encounter_Type
		}
		if(call_function.equals("MARK_MLC_OSCC") )
		{
		
				
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','MARK_MLC_OSCC','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("DIAG_RECODE"))
		{
			
			
		 if(PatientId.equals(""))
			{	
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosis('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
			out.println("<td nowrap class='"+classValue+"'>" +Patient_ID+"</td>");
			}
		else if(!PatientId.equals(""))
			{ out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosis('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");  
			}
		}
		else if(call_function.equals("MR_REC_PAT_VAL") || call_function.equals("REPRINT_PAT_VAL"))
		{
				
		
			if (!PatientId.equals(""))
			{
					
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"')>"+Encounter_ID+"</a></td>");
			}
			else if(PatientId.equals(""))
			{
					
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:patientValuables('"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+specialty_code+"')>"+Encounter_ID+"</a></td>");
				out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
			}
		}

		else if(call_function.equals("TRANSMIT_NOTIFY_REP"))
		{
			 

			out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososTransmissionDtls('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
		{
				 
			out.println("<td nowrap class='"+classValue+"'><a href=javascript:DiagnososConfirmationDtls('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
		}
		else if(call_function.equals("QUERY_MARK_MLC_OSCC"))
		{
				 
			if (!PatientId.equals(""))
			{
					 
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");
			}
			else if(PatientId.equals(""))
			{
					 
				out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:calladdmodifyMark('"+Encounter_ID+"','QUERY_MARK_MLC_OSCC','"+Patient_ID+"')>"+Patient_ID+"</a></td>");
			}
		}
		else if(call_function.equals("QUERY_MATERNAL_REPORT"))
		{	
				
			out.println("<td align='left' class='"+classValue+"'>");
			out.print("<a href=\"javascript:closeWin('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+""+"')\">");	
			out.print(""+Encounter_ID+"</a></td>");
		}
		else
		{
				
			if(call_function.equals("GEN_PLACE_ORDER"))
			{	
					
				if (!PatientId.equals(""))
			   {
					out.println("<td nowrap class='"+classValue+"'><a href=javascript:callWin('"+Patient_Class_code+"','ORDER_ENTRY','"+Encounter_ID+"','"+Patient_ID+"','"+visit_adm_type+"','"+P_DEP_APPL_YN+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>");

			    } 
			  
				else if(PatientId.equals(""))
			     { 
					  out.println("<td nowrap class='"+classValue+"'><a href=javascript:callWin('"+Patient_Class_code+"','ORDER_ENTRY','"+Encounter_ID+"','"+Patient_ID+"','"+visit_adm_type+"','"+P_DEP_APPL_YN+"','"+FacilityId+"')>"+Encounter_ID+"</a></td>"); 
					  out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
				  }
			}
			else if(call_function.equals("MR_DIAGNOSIS"))
			{

              if (!PatientId.equals(""))
			   {
				out.println("<td nowrap class='"+classValue+"'><a href=javascript:recordDiagnosis('MR_DIAGNOSIS','"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+conGender+"','"+attend_practitioner_id+"','"+Date_of_Birth+"','"+assign_care_locn_type+"','"+Patient_Class_code+"')>"+Encounter_ID+"</a></td>");
			   }
			     else if(PatientId.equals(""))
			     { 


				out.println("<td nowrap class='"+classValue+"'><a href=javascript:recordDiagnosis('MR_DIAGNOSIS','"+Encounter_ID+"','"+Patient_ID+"','"+locn_code+"','"+conGender+"','"+attend_practitioner_id+"','"+Date_of_Birth+"','"+assign_care_locn_type+"','"+Patient_Class_code+"')>"+Encounter_ID+"</a></td>");
				out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+"</td>");
			
				 }
			 }
			else
			{
		
				out.println("<td nowrap class='"+classValue+"'>"+Encounter_ID+"</td>");
			}
		}
		if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
			
			out.println("<td nowrap class='"+classValue+"'>" +Patient_Name+"</td>");
		}
		if(call_function.equals("GEN_PLACE_ORDER") || call_function.equals("MR_DIAGNOSIS"))
		{	
			out.println("<td nowrap class='"+classValue+"'>" +conGender+"</td>");
		}
		if(!call_function.equals("QUERY_MATERNAL_REPORT")&&!call_function.equals("MEDICAL_REPORT_REQUEST")&&!call_function.equals("MARK_MLC_OSCC")&& !call_function.equals("DIAG_RECODE") && !call_function.equals("REPRINT_PAT_VAL") && !call_function.equals("MR_REC_PAT_VAL") && !call_function.equals("QUERY_MARK_MLC_OSCC")&& !call_function.equals("GEN_PLACE_ORDER") && !call_function.equals("MR_DIAGNOSIS"))
		{	
				
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
				//Encounter_Type-Patient_Class
		}
             
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"/"+con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
				out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
				out.println("</tr>");
				i++;
			}
		}

	
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
	else //if(flag.equals("true"))
	{
	/// DISPLAY IN MODAL WINDOW
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block33Bytes, _wl_block33);


	if(!finalSelect.equals("SELECTALL"))
	{
		
		TreeMap ssm=new TreeMap();
		String selitem="";
		selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem");
		selitem=selitem.substring(1);
		selitem=selitem.substring(0,selitem.length()-1);
		
		StringTokenizer st=new StringTokenizer(finalSelect,"~");

		int temp=st.countTokens();
		String practId="";
		/*String objName="";*/
		String enable_dis="";
		for(int u2=0;u2<temp;u2++)
		{
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			practId=st1.nextToken();
			st1.nextToken();
			enable_dis=st1.nextToken();
			if(enable_dis.equals("E"))
			ssm.put(practId,practId);
			else
			{
				if(ssm.containsKey(practId))
				ssm.remove(practId);
			}
		}

		if (rs != null)
		{
			
			int clsCnt=1;

		while(rs.next())
		{
			if(ssm.containsKey(new String(i+"")))
			{
				
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");
				String Encounter_Date_display="";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
				{
						Encounter_Date = "";
						Encounter_Date_display = "";
				}
				else
					Encounter_Date_display = DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);
				
				 Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
				String con_Location=rs.getString("locn_desc");				
				String con_Practitioner=rs.getString("practitioner_name");				
				String locn_type=rs.getString("locn_type");	
				if(locn_type==null	      || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("discharge_date_time");	
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
					Dis_dateTime = "&nbsp;";

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))		Patient_Name = "&nbsp";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "&nbsp";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))		Date_of_Birth = "&nbsp;";
				if(Patient_Class==null	  || Patient_Class.equals("null"))		Patient_Class = "";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))		Encounter_Date = "";
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))		Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))		con_Speciality = "&nbsp;";
				if(con_Location==null	  || con_Location.equals("null"))		con_Location = "&nbsp;";
				if(con_Practitioner==null || con_Practitioner.equals("null"))	con_Practitioner = "&nbsp;";
				out.println("<tr>");				
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date_display+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
				out.println("</tr>");
				clsCnt++;
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rs.getString("encounter_id")));
            _bw.write(_wl_block35Bytes, _wl_block35);

				}
				i++;
			}
			if(clsCnt == 1)
			{
				out.println("<script>alert(getMessage('ENC_CANNOT_BLANK','MR'));parent.window.close();</script>");
				
			}
		}
	}
	else if(finalSelect.equals("SELECTALL"))
	{
		
		if (rs != null)
		{
			int clsCnt=1;
			while(rs.next())
			{
				if ( clsCnt % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				 Patient_ID=rs.getString("patient_id");				
				String Patient_Name=rs.getString("patient_name");				
				String conGender=rs.getString("gender");				
				String Date_of_Birth=rs.getString("birth_date");				
				String Patient_Class=rs.getString("patient_class");	
				String Encounter_Date=rs.getString("encounter_date");				
				 Encounter_ID=rs.getString("encounter_id");				
				String con_Speciality=rs.getString("speciality_desc");				
				String con_Location=rs.getString("locn_desc");				
				String con_Practitioner=rs.getString("practitioner_name");			
				String locn_type=rs.getString("locn_type");		
				if(locn_type==null || locn_type.equals("null"))		    
					locn_type = "";

				String Dis_dateTime =	rs.getString("DISCHARGE_DATE_TIME");	
				if(Dis_dateTime==null	      || Dis_dateTime.equals("null"))		    
					Dis_dateTime = "&nbsp;";

				if(Patient_ID==null	      || Patient_ID.equals("null"))		    
					Patient_ID = "";
				if(Patient_Name==null	  || Patient_Name.equals("null"))
					Patient_Name = "";
				if(conGender==null	      || conGender.equals("null"))		    
					conGender = "";
				if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
					Date_of_Birth = "";
				if(Patient_Class==null	  || Patient_Class.equals("null"))
					Patient_Class = "";
				if(Encounter_Date==null	  || Encounter_Date.equals("null"))
					Encounter_Date = "";
				if(Encounter_ID==null	  || Encounter_ID.equals("null"))
					Encounter_ID = "";
				if(con_Speciality==null	  || con_Speciality.equals("null"))
					con_Speciality = "";
				if(con_Location==null	  || con_Location.equals("null"))
					con_Location = "";
				if(con_Practitioner==null || con_Practitioner.equals("null"))
					con_Practitioner = "";
				out.println("<tr>");				
				out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
				out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
				out.println("</tr>");


            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block37Bytes, _wl_block37);
	

				clsCnt++;
				i++;
			}
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
	}// E.O SelectAll
	
            _bw.write(_wl_block38Bytes, _wl_block38);
	}
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(module));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(start));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(end));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(temp1));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(criteria));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Enc_Type));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(alt_id1_exp_date));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(alt_id2_exp_date));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(p_discharge_date_from));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(p_discharge_date_to));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(alt_id2_no));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(alt_id3_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(alt_id4_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(other_alt_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(other_alt_Id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Encounter_ID));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(selectAll_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(mlc_oscc));
            _bw.write(_wl_block78Bytes, _wl_block78);

}
if(!finalSelect.equals("SELECTALL"))
{
	
	
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	String objName="";
	String enable_dis="";
	int temp=st.countTokens();

	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		else
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}
}catch ( Exception e )
{ 
	//out.println("Expection in EncSearchResult.jsp : "+e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block79Bytes, _wl_block79);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
}
