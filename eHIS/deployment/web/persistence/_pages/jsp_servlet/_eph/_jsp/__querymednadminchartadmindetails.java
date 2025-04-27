package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __querymednadminchartadmindetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryMednAdminChartAdminDetails.jsp", 1736413747116L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 28/10/2005-->\n ";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/QueryMednAdminChart.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</head>\n\n\t<!-- <body style=\"margin-top:10px\"> -->\n\t<body style=\"margin-top:10px\" onMouseDown=\"\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<TABLE width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\'0\' align=\'center\'>\n\t\t\t\t\t<tr id=\'verbalorderWinessDtl\' style=\'display:none\'>\n\t\t\t\t\t\t<td colspan=\'6\' class = \'label\' STYLE=\"COLOR:Red;FONT-SIZE:9PT;FONT-FAMILY:\'VERDANA\';\">&nbsp;*&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =":&nbsp;<label id=\'verbalWitness\'></label>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<Td ALIGN=\"LEFT\" width=\'25%\' STYLE=\"BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\" id=\"admin_dtls\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t</Td>\n\t\t\t\t\t\t<Td ALIGN=\"LEFT\"  width=\'15%\' STYLE=\"BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\" id=\"admin_pract_position\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t</Td>\n\t\t\t\t\t\t<Td ALIGN=\"LEFT\"  width=\'15%\' STYLE=\"BACKGROUND-COLOR:#FFD7D7;COLOR:Red;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\" id=\"admin_self\" >\n\t\t\t\t\t\t\t<label id=\"lbladmin_self\" style=\'display:none;\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</label>\n\t\t\t\t\t\t</Td>\n\t\t\t\t\t\t<Td ALIGN=\"LEFT\"  width=\'22%\' STYLE=\"BACKGROUND-COLOR:#FFD7D7;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\" id=\"admin_at\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t</Td>\n\t\t\t\t\t\t<Td ALIGN=\"right\"  width=\'25%\' id=\"practname\" Style=\"background-color:#FFD7D7;FONT-SIZE:8PT;FONT-FAMILY:\'VERDANA\';\"></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td width=\'1%\' class = \'label\' style=\'text-align:right;\' ><button id=\"Closebutton\" onclick=\"closeAdminDtl(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\" title=\'Close Admin Detail\' ><img src=\"../../eCommon/images/disabled.gif\"  height=\'17\'  width=\'17\' style=\"cursor:pointer;\"></button></td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<!-- <td width=\'1%\' class = \'label\' style=\'display:none;\'></td> -->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 align=\"center\" topmargin=\'0\' WIDTH=\"99%\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<table id=\"adminTable\" name=\"PatientTable\" id=\"PatientTable\" border=\"1\"  WIDTH=\"100%\" cellpadding=\"0\" cellspacing=\"0\"  align=\"center\" topmargin=\'0\'>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<tr id=\"header\" name=\"header\">\n\t\t\t\t\t\t\t<td  class=\'COLUMNHEADER\' width=\"30%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"5%\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"18%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t<!-- Added for MMOH-CRF-0911 start-->\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"18%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t<!-- Added for MMOH-CRF-0911 end-->\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"24%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"24%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<tr id=\"header\" name=\"header\">\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"25%\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<tr id=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" name=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t<script>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"verbalorderWinessDtl\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"verbalWitness\").innerHTML=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"practname\").innerHTML=\"Ordering Practitioner:<B>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</B>&nbsp;\";\n\t\t\t\t\t\t\t\t\t\t//document.getElementById(\"admin_pract_position\").innerHTML=\"Position:<B>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</B>\";\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_pract_position\").innerHTML=\"Position:<B>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</B>\"; //inc 44744\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_self\").innerHTML=\"Self Admin:<B>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</B>\";\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_at\").innerHTML=\"Administered At:<b>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</B>\";\n\t\t\t\t\t\t\t\t\t\t//document.getElementById(\"admin_dtls\").innerHTML=\"Administered By:<b>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administered At:<b>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</b>\"; //Added for SRR20056-SCF-9733[Inc:38353] //Commented for ML-BRU-SCF-1040 [IN:043831]\n\t\t\t\t\t\t\t\t\t\t//Changed index from 6 to 13 to retrieve admin recorded by data instead of practioner name for  IN043190\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_dtls\").innerHTML=\"Administered By:<b>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</b>\"; //Added for ML-BRU-SCF-1040 [IN:043831]\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_dtls\").innerHTML=\'Recorded  By:<b>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</b>&nbsp;&nbsp;\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_pract_position\").innerHTML=\'&nbsp;\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_self\").innerHTML=\'&nbsp;\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"admin_at\").innerHTML=\'Recorded At:<b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</b>\';\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"practname\").innerHTML=\'Ordering Practitioner:<B>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</B>\';\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../images/changeddosageindicator.gif\" align=\"center\" id=\"chng_dose_ind\" title=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="-------------------------------------------";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></img>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =":</B>&nbsp;&nbsp;";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'6\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="><b>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" colspan=\'2\'><b>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =":</b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t <td class=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&nbsp;:</b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td> \n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =": </b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\tcloseAdminDtl(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\');\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t</body>\n\t\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n</html>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

        request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String  callFrom			=	request.getParameter("callFrom")==null?"":request.getParameter("callFrom");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
		if(callFrom.equals("SCH")){

            _bw.write(_wl_block9Bytes, _wl_block9);

		}

            _bw.write(_wl_block10Bytes, _wl_block10);

		String bean_id				= "QueryMednAdminChartBean";
		String bean_name			= "ePH.QueryMednAdminChartBean";
		QueryMednAdminChartBean bean= (QueryMednAdminChartBean)getBeanObject( bean_id,bean_name ,request);
			bean.setLanguageId(locale); //added for ml-mmoh-scf-1463
		String  encounterid			=	request.getParameter("encounter_id");
		String  schdate				=	request.getParameter("schdatetime");
		String  ord_drug_code		=	request.getParameter("ord_drug_code");
		String  order_id			=	request.getParameter("order_id");
		String  facility_id			=	request.getParameter("facility_id");
		String  adminyn				=	request.getParameter("adminyn");
		String patient_class		=	request.getParameter("patient_class");
		String order_line_num		=  request.getParameter("order_line_num")==null?"1":request.getParameter("order_line_num"); //newly added for inc 30030
		String sch_dosage_uom_code	=	request.getParameter("sch_dosage_uom_code")==null?"":request.getParameter("sch_dosage_uom_code");
		String  drug_desc			=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String  admintime			=	request.getParameter("admintime");
		String te_qty				=	request.getParameter("te_qty");
		String iv_prep_yn			=	request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String dosage_seq_no		=  request.getParameter("dosage_seq_no")==null?"1":request.getParameter("dosage_seq_no"); // Added for PMG2014-CRF-0026 [IN:052701]
		String admin_by_type="", self_admin_by="";
		String admin_recorded_date_time="";// Added for MMOH-CRF-0911
		String admin_drug_code   = "";//BRU-CRF-399.1
		String split_dose_yn = "";
		String position = "";//inc 44744
		String witness_by=""; // Added for AAKH-CRF-0023[IN:038259] 
		String admin_reason=""; // Added for SKR-CRF-0037 [IN:037656]
		boolean searched			=	request.getParameter( "searched" ) == null ? false : true  ;
		String expiry_date ="";//code added for SKR-SCF-1002[IN048681]
		try{
			encounterid		 = CommonBean.checkForNull( encounterid);
			schdate			 = CommonBean.checkForNull( schdate );
			//schdate			 = com.ehis.util.DateUtils.convertDate(schdate,"DMY","en",locale);//added for inc 44498 //Commented for  RUT-SCF-0376 [IN:046818]
			ord_drug_code	 = CommonBean.checkForNull( ord_drug_code );
			order_id		 = CommonBean.checkForNull( order_id );
			facility_id		 = CommonBean.checkForNull( facility_id );
			HashMap sqlMap		= new HashMap();
			ArrayList chkFields = new ArrayList();
		//include all the common parameters.
			StringBuffer sql = new StringBuffer();
	
			if (adminyn.equals("Y")){
				if(patient_class.equals("IP")||patient_class.equals("DC")){
				  //sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT3");
				  //sql="SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADMIN_TIME, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY, D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION , nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),e.drug_desc) drug_desc ,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code,    A.ADMIN_REMARKS,  'Batch Id: '||NVL(B.BATCH_ID,'-- ')||' Expiry Date: '||    NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE    language_id=? and TRADE_ID=B.TRADE_ID ),'-- ')  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS,TO_CHAR(A.ADR_RECORDED_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS ,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM  ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 2),'') ALT_PRES_BASE_UOM ,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num  ) dosage_type FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, ip_nursing_unit_lang_vw f, ph_medn_trn_reason_lang_vw g WHERE    F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND   A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id AND      A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND    E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND   A.FACILITY_ID=? AND   A.ENCOUNTER_ID=? AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id(+) = ? AND f.language_id = d.language_id AND g.language_id (+)= ?";//changed for position value inc 44113
				  // Added for MMOH-CRF-0911 start TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time end
				  sql.append("SELECT  DECODE (f.short_desc, NULL, (SELECT clinic_code FROM op_clinic_lang_vw WHERE facility_id = a.facility_id AND language_id(+) = e.language_id AND clinic_code = a.admin_nursing_unit_code), f.short_desc) short_desc, b.ADMIN_DRUG_CODE, TO_CHAR(A.ADMIN_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADMIN_TIME, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY, D.PRACTITIONER_NAME, d.POSITION_DESC POSITION , nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 1),e.drug_desc) drug_desc ,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code, A.ADMIN_REMARKS, 'Batch Id: '||NVL(B.BATCH_ID,'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM AM_TRADE_NAME_lang_vw WHERE language_id=? and TRADE_ID=B.TRADE_ID ),'-- ') || ' Expiry Date: ' BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS,TO_CHAR(A.ADR_RECORDED_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME, A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS ,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 1),'') ALT_PRES_BASE_UOM ,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph where or_order_line_ph.order_id = A.order_id AND or_order_line_ph.order_line_num = A.order_line_num ) dosage_type,(SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by, (select REASON_DESC from ph_medn_trn_reason_lang_vw where reason_code=b.ADMIN_REASON_CODE and language_id(+)=e.language_id AND appl_trn_type in ('MR','M') )ADMIN_REASON, NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') EXPIRY_DATE,TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, ip_nursing_unit_lang_vw f, ph_medn_trn_reason_lang_vw g, or_order_line ordln WHERE F.FACILITY_ID(+) = A.FACILITY_ID AND F.NURSING_UNIT_CODE (+) = A.ADMIN_NURSING_UNIT_CODE  AND A.FACILITY_ID= b.FACILITY_ID AND A.ENCOUNTER_ID= b.ENCOUNTER_ID AND a.order_id = b.order_id and a.dosage_seq_no = b.dosage_seq_no AND A.order_id=c.order_id AND a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND c.ord_pract_id=D.practitioner_id  AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id(+) = ? AND f.language_id(+) = ? AND g.language_id (+)= ? ");  //AND F.FACILITY_ID=B.FACILITY_ID  && code ' NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') ' remove from batch details and taken separate field for SKR-SCF-1002[IN048681] // AND ROWNUM < 2 changed to AND ROWNUM < 1 for ML-BRU-SCF-1726 [IN:064702]  //AND appl_trn_type in ('MR','M') added for IN74075
			   } 
			   else{
					//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT3A");
					//sql="SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADMIN_TIME,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by,  (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY,D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION,  nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),e.drug_desc) drug_desc,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code,    A.ADMIN_REMARKS,  'Batch Id: '||NVL(B.BATCH_ID,'--')||' Expiry Date: '||    NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE    language_id=? and  TRADE_ID=B.TRADE_ID ),'-- ')  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME ,   'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME , A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM  ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 2),'') ALT_PRES_BASE_UOM,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph    where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num  ) dosage_type FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, op_clinic_lang_vw f, ph_medn_trn_reason_lang_vw g WHERE    F.FACILITY_ID=A.FACILITY_ID AND F.clinic_code=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND   A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id AND      A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id AND a.dosage_seq_no = b.dosage_seq_no AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE  AND    E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND   A.FACILITY_ID=? AND   A.ENCOUNTER_ID=? AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id (+)= ? AND f.language_id = d.language_id AND g.language_id (+)= ? AND a.ORDER_LINE_NUM=?";  //AND a.dosage_seq_no = b.dosage_seq_no and ORDER_LINE_NUM newly added for incident 30030
				  // Added for MMOH-CRF-0911 start TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time end
					sql.append("SELECT  F.SHORT_DESC, b.ADMIN_DRUG_CODE,   TO_CHAR(A.ADMIN_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADMIN_TIME,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by,  (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY,D.PRACTITIONER_NAME, d.POSITION_DESC POSITION,  nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 1),e.drug_desc) drug_desc,   b.ADMIN_DOSAGE_QTY,   B.admin_dosage_uom_code, A.ADMIN_REMARKS, 'Batch Id: '||NVL(B.BATCH_ID,'--')||' Trade Name: '||NVL((SELECT SHORT_NAME FROM  AM_TRADE_NAME_lang_vw WHERE language_id=? and  TRADE_ID=B.TRADE_ID ),'-- ') || ' Expiry Date: '  BATCH_DETAILS, G.REASON_DESC, A.ADR_REMARKS, TO_CHAR(A.ADR_RECORDED_DATE_TIME , 'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME , A.ADR_RECORDED_BY,A.ADMN_DOSE_CHNG_REMARKS,nvl((SELECT am_get_desc.am_uom(pres_base_uom,?,2) FROM  ph_drug, ph_disp_dtl WHERE ph_disp_dtl.disp_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = A.order_id AND ph_disp_dtl.order_line_no = A.order_line_num  AND ROWNUM < 2),'') ALT_PRES_BASE_UOM,(SELECT DOSAGE_TYPE  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) dosage_type, (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by, (select REASON_DESC from ph_medn_trn_reason_lang_vw where reason_code=b.ADMIN_REASON_CODE and language_id(+)=e.language_id AND appl_trn_type in ('MR','M'))ADMIN_REASON , NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') EXPIRY_DATE,TO_CHAR (a.admin_recorded_date_time, 'DD/MM/YYYY HH24:MI' ) admin_recorded_date_time,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM ph_medn_admin_dtl b, or_order c,am_practitioner_lang_vw d, ph_medn_admin a, ph_drug_lang_vw e, op_clinic_lang_vw f, ph_medn_trn_reason_lang_vw g, or_order_line ordln WHERE F.FACILITY_ID=A.FACILITY_ID AND F.clinic_code=A.ADMIN_NURSING_UNIT_CODE AND F.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID= b.FACILITY_ID AND A.ENCOUNTER_ID= b.ENCOUNTER_ID AND  a.order_id = b.order_id and a.dosage_seq_no = b.dosage_seq_no AND A.order_id=c.order_id AND a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND  c.ord_pract_id=D.practitioner_id AND a.dosage_seq_no = b.dosage_seq_no AND A.SCH_DATE_TIME=b.SCH_DATE_TIME AND  A.ORD_DRUG_CODE=  b.ORD_DRUG_CODE AND E.DRUG_CODE(+)=B.ADMIN_DRUG_CODE AND A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND G.REASON_CODE(+) = A.ADR_REASON_CODE AND A.ORDER_ID=? AND g.appl_trn_type(+)='M' AND d.language_id = ? AND e.language_id (+)= ? AND f.language_id(+) = ? AND g.language_id (+)= ? AND a.ORDER_LINE_NUM=? ");  //changed for position value inc 44113 && code ' NVL(TO_CHAR(B.EXPIRY_DATE,'dd/mm/yyyy'),'-- ') ' remove from batch details and taken separate field for SKR-SCF-1002[IN048681] // AND ROWNUM < 2 changed to AND ROWNUM < 1 for ML-BRU-SCF-1726 [IN:064702]  
					//AND appl_trn_type in ('MR','M') added for IN74075
				}
			}
			else if(patient_class.equals("IP")||patient_class.equals("DC")){
				//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT4");
				//sql="SELECT  F.SHORT_DESC,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? )  ADMIN_RECORDED_BY,A.non_ADMIN_REMARKS,  D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION,g.reason_desc,A.ADMN_DOSE_CHNG_REMARKS FROM   OR_ORDER c,  am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,IP_NURSING_UNIT_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g WHERE   F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id and g.REASON_CODE(+) = a.NON_ADMIN_CODE   AND g.appl_trn_type(+)='M'  AND   A.FACILITY_ID=?  AND   A.ENCOUNTER_ID=?  AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy')  AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=?  and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ?";//changed for position value inc 44113
				sql.append("SELECT  F.SHORT_DESC,(select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY,A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? )  ADMIN_RECORDED_BY,A.non_ADMIN_REMARKS, D.PRACTITIONER_NAME, d.POSITION_DESC POSITION ,g.reason_desc,A.ADMN_DOSE_CHNG_REMARKS, (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM OR_ORDER c,  am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,IP_NURSING_UNIT_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g, or_order_line ordln WHERE F.FACILITY_ID=A.FACILITY_ID AND F.NURSING_UNIT_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id and g.REASON_CODE(+) = a.NON_ADMIN_CODE AND g.appl_trn_type(+)='M'  AND A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND  a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=?  and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ? ");//and a.dosage_seq_no=? removed for MMS-KH-SCF-0023
			}
			else {
				//sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT4A");
				//sql="SELECT F.SHORT_DESC, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? )  ADMIN_RECORDED_BY ,A.non_ADMIN_REMARKS,  D.PRACTITIONER_NAME, d.PRACT_TYPE_DESC POSITION,g.reason_desc,A.ADMN_DOSE_CHNG_REMARKS FROM   OR_ORDER c,  am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,op_clinic_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g WHERE   F.FACILITY_ID=A.FACILITY_ID AND F.clinic_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  and g.REASON_CODE(+) = a.NON_ADMIN_CODE   AND g.appl_trn_type(+)='M' AND   A.FACILITY_ID=?  AND   A.ENCOUNTER_ID=?  AND   TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI')  AND   A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=?  and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ?";//changed for position value inc 44113
				sql.append("SELECT F.SHORT_DESC, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_BY and LANGUAGE_ID=? ) ADMIN_BY, A.Admin_by_type, a.self_admin_by, (select APPL_USER_NAME from SM_APPL_USER_LANG_VW where APPL_USER_ID = A.ADMIN_RECORDED_BY and LANGUAGE_ID=? ) ADMIN_RECORDED_BY ,A.non_ADMIN_REMARKS,  D.PRACTITIONER_NAME, d.POSITION_DESC POSITION,g.reason_desc, A.ADMN_DOSE_CHNG_REMARKS, (SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE appl_user_id = ordln.verbal_order_witness_by_id AND language_id = ?) witness_by,(SELECT SPLIT_DOSE_YN  FROM  or_order_line_ph where or_order_line_ph.order_id =   A.order_id AND or_order_line_ph.order_line_num = A.order_line_num) SPLIT_DOSE_YN FROM   OR_ORDER c, am_practitioner_lang_vw d,  PH_MEDN_ADMIN A,op_clinic_lang_vw F, PH_MEDN_TRN_REASON_LANG_VW g, or_order_line ordln WHERE F.FACILITY_ID=A.FACILITY_ID AND F.clinic_CODE=A.ADMIN_NURSING_UNIT_CODE AND C.ORDERING_FACILITY_ID=F.FACILITY_ID AND A.order_id=c.order_id AND  c.ord_pract_id=D.practitioner_id  and g.REASON_CODE(+) = a.NON_ADMIN_CODE AND g.appl_trn_type(+)='M' AND A.FACILITY_ID=?  AND A.ENCOUNTER_ID=? AND  a.order_id = ordln.order_id and A.ORDER_LINE_NUM = ORDLN.ORDER_LINE_NUM AND TO_CHAR(A.SCH_DATE_TIME,'dd/mm/yyyy')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy') AND TO_CHAR(A.SCH_DATE_TIME,'HH24:MI')=TO_CHAR(TO_DATE(?,'HH24:MI'),'HH24:MI') AND A.ORD_DRUG_CODE=nvl(?,A.ORD_DRUG_CODE) AND A.ORDER_ID=? and d.language_id =f.language_id and f.language_id =? AND g.LANGUAGE_ID(+) = ? ");//and a.dosage_seq_no=? removed for MMS-KH-SCF-0023
			}
		//	if(!dosage_seq_no.equals(""))
			//	sql.append(" and a.dosage_seq_no=? "); //commented for SKR-SCF-1259
			chkFields.add(locale); 
			chkFields.add(locale);
			if (adminyn.equals("Y")){
				chkFields.add(locale); 
				chkFields.add(locale);    
				chkFields.add(locale);    
			}  
			chkFields.add(locale);   // Added for AAKH-CRF-0023[IN:038259] - start
			chkFields.add(bean.getFacilityId());
			chkFields.add(encounterid);
			chkFields.add(schdate);
			chkFields.add(admintime);
			chkFields.add(ord_drug_code);
			chkFields.add(order_id);
			chkFields.add(locale); 
			chkFields.add(locale);
			if (adminyn.equals("Y")){				 
				chkFields.add(locale); 
				chkFields.add(locale); 
			}  
			//the below condtion is newly added for inc 30030
			if (adminyn.equals("Y")){
				if( !patient_class.equals("IP") && !patient_class.equals("DC") ){ // && !patient_class.equals("DC") added for Alpha-PH- MAR Chart for Daycare Patients[IN036701]
					chkFields.add(order_line_num);	
				}
			}
			//if(!dosage_seq_no.equals(""))
			//	chkFields.add(dosage_seq_no);	 // Added for PMG2014-CRF-0026 [IN:052701] as per discussion with PMG we are commented against SKR-SCF-1259
			System.err.println("QueryMednAdminChartAdminDetails.jsp======sql====131===>"+sql);
			//End of concatenating search conditions
			sqlMap.put( "sqlData",  sql.toString());
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			int namedisplayed=0;
			if (adminyn.equals("Y") ) {
				displayFields.add("DRUG_DESC");	//0
				displayFields.add("ADMIN_DOSAGE_QTY");
				displayFields.add("ADMIN_TIME");
				displayFields.add("BATCH_DETAILS");
				displayFields.add("ADMIN_REMARKS");
				displayFields.add("ADMIN_DOSAGE_UOM_CODE");
				displayFields.add("PRACTITIONER_NAME");
				displayFields.add("ADMIN_BY"); //7
				displayFields.add("SHORT_DESC");
				displayFields.add("REASON_DESC");
				displayFields.add("ADR_REMARKS");	//10
				displayFields.add("ADR_RECORDED_DATE_TIME");
				displayFields.add("ADR_RECORDED_BY");
				displayFields.add("ADMIN_RECORDED_BY");
				displayFields.add("ADMN_DOSE_CHNG_REMARKS");
				displayFields.add("ALT_PRES_BASE_UOM");
				displayFields.add("DOSAGE_TYPE");
				displayFields.add("POSITION");	//17
				displayFields.add("ADMIN_BY_TYPE");	//18
				displayFields.add("SELF_ADMIN_BY");	//19
				displayFields.add("WITNESS_BY");	//20 // Added for AAKH-CRF-0023[IN:038259] - start
				displayFields.add("ADMIN_REASON");	//21 // Added for Bru-HIMS-CRF-403[IN044541]
				displayFields.add("EXPIRY_DATE");	//22 //code  added for SKR-SCF-1002[IN048681] 				 
				displayFields.add("ADMIN_RECORDED_DATE_TIME");//Added for MMOH-CRF-0911 
				displayFields.add("ADMIN_DRUG_CODE");//Added for MMOH-CRF-399.1 
				displayFields.add("SPLIT_DOSE_YN"); //added for ML-MMOH-SCF-1767


			}
			else{
				displayFields.add("NON_ADMIN_REMARKS");//0
				displayFields.add("PRACTITIONER_NAME");
				displayFields.add("ADMIN_BY");
				displayFields.add("SHORT_DESC");
				displayFields.add("reason_desc");//4
				displayFields.add("ADMIN_RECORDED_BY");//5
				displayFields.add("WITNESS_BY");//6 // Added for AAKH-CRF-0023[IN:038259] - start
			}
			
			funcMap.put("displayFields", displayFields );
			funcMap.put("chkFields", chkFields );
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap,funcMap,request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

						//if(callFrom.equals("SCH")){ // commented for PMG2014-CRF-0026 [IN:052701]

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block18Bytes, _wl_block18);

						//}
						//else{

            _bw.write(_wl_block19Bytes, _wl_block19);

						//}

            _bw.write(_wl_block20Bytes, _wl_block20);

				if (result.get(1)!=""){

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block22Bytes, _wl_block22);

				}

            _bw.write(_wl_block23Bytes, _wl_block23);
		
					if (adminyn.equals("Y") ){

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
					else{

            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String classvalue="";					
					for(int recCount=2; recCount<result.size(); recCount++){

						if ( recCount % 2 == 0 )
							classvalue = "QRYEVENSMALL" ;
						else
							classvalue = "QRYODDSMALL" ;
						records=(ArrayList) result.get( recCount );

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);

						for(int colCount=0; colCount<records.size(); colCount++){
							if  (namedisplayed==0){
								namedisplayed=1;
								if (adminyn.equals("Y")) {
									admin_by_type=(String)records.get(18)==null?"":(String)records.get(18);
									self_admin_by=(String)records.get(19)==null?"":(String)records.get(19);
									position =(String)records.get(17)==null?"":(String)records.get(17);//inc 44744
									admin_reason=(String)records.get(21)==null?"":(String)records.get(21); // Added for Bru-HIMS-CRF-403[IN044541]
									witness_by=(String)records.get(20)==null?"":(String)records.get(20); // Added for AAKH-CRF-0023[IN:038259] - start
									admin_recorded_date_time=(String)records.get(23)==null?"":(String)records.get(23); //Added for MMOH-CRF-0911
									admin_drug_code = (String)records.get(24)==null?"":(String)records.get(24);//BRU-CRF-399
									split_dose_yn = (String)records.get(25)==null?"":(String)records.get(25); //added for ML-MMOH-SCF-1767
							

            _bw.write(_wl_block35Bytes, _wl_block35);

										if(!witness_by.equals("")){ // Added for AAKH-CRF-0023[IN:038259] - End

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(witness_by));
            _bw.write(_wl_block37Bytes, _wl_block37);

										}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((String)records.get(6)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)records.get(17)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(position));
            _bw.write(_wl_block41Bytes, _wl_block41);

										if(!admin_by_type.equals("") && !admin_by_type.equals("U")&&!self_admin_by.equals("")){

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)records.get(19)));
            _bw.write(_wl_block43Bytes, _wl_block43);

										}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)records.get(8)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)records.get(6)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((String)records.get(8)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((String)records.get(13)));
            _bw.write(_wl_block48Bytes, _wl_block48);

								}
								else {
									witness_by=(String)records.get(6)==null?"":(String)records.get(6); // Added for AAKH-CRF-0023[IN:038259] - start

            _bw.write(_wl_block35Bytes, _wl_block35);

										if(!witness_by.equals("")){ // Added for AAKH-CRF-0023[IN:038259] 

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(witness_by));
            _bw.write(_wl_block37Bytes, _wl_block37);

										}

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)records.get(5)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((String)records.get(3)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block52Bytes, _wl_block52);

								}
							}
							if (adminyn.equals("Y")){
								if((colCount > 4 && colCount <9) || colCount>=13)
									continue;
							}
							else{
								if (colCount>0)
									continue;
							}
							String dkVal = (String)records.get( colCount )==null?"":(String)records.get( colCount );
							if(colCount==0){	
								if (adminyn.equals("Y")){
									if(iv_prep_yn.equals("6") || iv_prep_yn.equals("0") || iv_prep_yn.equals("2") || iv_prep_yn.equals("4")|| iv_prep_yn.equals("8")){
										dkVal = drug_desc+"&nbsp;" ;
									}	
								}
							}							
							if(dkVal == null || (dkVal.trim().equals(""))){	
								if(colCount==0){
									dkVal = drug_desc+"&nbsp;" ;
								}
								else if(colCount==1)
									dkVal = "" ;
								else
									dkVal = "&nbsp;" ;
							}

							if (colCount==1){
								out.println("<td class="+classvalue+" nowrap>");
								if(!admin_drug_code.equals(ord_drug_code)){//BRU-CRF-399.1
								/*String dosage_dtl = bean.getAltDosageDetails(ord_drug_code,admin_drug_code,order_id,order_line_num);
								if(!split_dose_yn.equals("Y"))  //added for ML-MMOh-SCF-1767
								te_qty = dosage_dtl.split("~")[0];
								*/
								if(split_dose_yn.equals("Y")){ //ML-MMOH-SCF-1799.1
									te_qty = bean.getSplitDosage(order_id,order_line_num,admintime);
								}
										
								if(te_qty==null || te_qty.equals("") || te_qty.equals("00")) //added for MMS-KH-SCF-0008
									te_qty = "1";
								
								if(!te_qty.equals("") && Float.parseFloat(te_qty) < 1.0){
										te_qty = Float.parseFloat(te_qty)+"";
								}

								out.println(te_qty+"");
								/*if(!split_dose_yn.equals("Y")) //added for ML-MMOh-SCF-1767 and reverted against ML-MMOH-SCF-1841.1
									out.println(dosage_dtl.split("~")[2]+"");								
								else */
									out.println(bean.getUomDisplay(facility_id,sch_dosage_uom_code)); //added for ML-MMOh-SCF-1767
								}else{
									if(split_dose_yn.equals("Y")){ //ML-MMOH-SCF-1799
										te_qty = bean.getSplitDosage(order_id,order_line_num,admintime);
									}
									if(!te_qty.equals("") && Float.parseFloat(te_qty) < 1.0){
										te_qty = Float.parseFloat(te_qty)+"";
									}
									out.println(te_qty+"");
									out.println(bean.getUomDisplay(facility_id,sch_dosage_uom_code));								
								}
								//out.println(bean.getUomDisplay(facility_id,records.get(5).toString()));
							//	out.println(bean.getUomDisplay(facility_id,sch_dosage_uom_code));															
								out.println("</td>");						
								out.println("<td class='"+classvalue+"' nowrap>");
								if (adminyn.equals("Y")){
									if(!dkVal.equals("") && Float.parseFloat(dkVal) < 1.0){
										dkVal = Float.parseFloat(dkVal)+"";
									}
									
									if(((String)records.get(colCount+14)!=null && !(((String)records.get( colCount +14)).equals(""))) && ((String)records.get(colCount+15)).equals("Q")){
										out.println(dkVal+" "+(String)records.get( colCount +14));
									}
									else{
										// Commented for SKR-SCF-0304
									    out.println(dkVal+" "+bean.getUomDisplay(facility_id,(String)records.get(colCount+4)));//changed sch_dosage_uom_code to (String)records.get(colCount+4)  for CRF-399.1
										//out.println(te_qty+" "+bean.getUomDisplay(facility_id,sch_dosage_uom_code)); //added for SKR-SCF-0304
									}
								}
								else{
									out.println(dkVal+"&snbp;");
								}
							//	if((Float.parseFloat(te_qty))!=(Float.parseFloat(dkVal)))
								//{
									if(((String)records.get( colCount +13))!=null && ((String)records.get( colCount +13))!=""){
										String reason_code = (String)records.get( colCount +13);
										String admn_chng_dose_reason_desc = (String) bean. getAdmn_chng_dose_reason_desc(reason_code);

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels") +"\n"));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf("\n"+admn_chng_dose_reason_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
				
										//	out.println("<img src='../images/changeddosageindicator.gif' align='center' id='chng_dose_ind' title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ChangedAdminDosageReason.label", "ph_labels")+"\n-------------------------------------------\n"+admn_chng_dose_reason_desc+"'></img>");
								}
								out.println("</td>");
							}
							else if (colCount==2){	
								out.println("<td class='"+classvalue+"'>");								
								out.println(com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale));
								out.println("</td>");
							}
							else if (colCount==3){
							// Added for MMOH-CRF-0911 start- added for ML-MMOH-SCF-0913
								out.println("<td class='"+classvalue+"'>");								
								out.println(com.ehis.util.DateUtils.convertDate(admin_recorded_date_time,"DMYHM","en",locale));
								out.println("</td>");

								// Added for MMOH-CRF-0911 end -added for ML-MMOH-SCF-0913 and ARYU-SCF-0061 

							if (dkVal.indexOf("--")>0){	
									out.println("<td class='"+classvalue+"'>");
									out.println("&nbsp;");
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'><textarea readonly style='height:30px;width:2in'>");
									expiry_date = (String)records.get(22)==null?"":(String)records.get(22);//code  added for SKR-SCF-1002[IN048681] --Start										
									if(!expiry_date.equals("--"))
										expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);//code  added for SKR-SCF-1002[IN048681]--End									
									out.println(dkVal+expiry_date );//code '+expiry_date' added for SKR-SCF-1002[IN048681]								
									out.println("</textarea></td>");
								}
							}

							else if (colCount==4){
							
								if (dkVal.equals("&nbsp;")){	
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal);
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'>");
									if(!admin_reason.equals("")){

            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(admin_reason));
            _bw.write(_wl_block1Bytes, _wl_block1);

									}
									out.println("<br><textarea readonly style='height:30px;width:2in'>");
									out.println(dkVal);
									out.println("</textarea></td>");
								}
							}
							else if(colCount == 9 ){
								if( !dkVal.equals("&nbsp;")){

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block61Bytes, _wl_block61);

								}
							}
							else if(colCount == 10){
								if( !dkVal.equals("&nbsp;")){

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block61Bytes, _wl_block61);

								}
							}
							else if(colCount == 11){
								if( !dkVal.equals("&nbsp;")){
									if(!(dkVal.equals("")) && !(locale.equals("en"))){ //added for IN25266 --04/01/2011-- priya
										dkVal =  com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale);
									}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block67Bytes, _wl_block67);

								}
							}
							else if(colCount == 12 ){
								if( !dkVal.equals("&nbsp;")){

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block69Bytes, _wl_block69);

								}
							}
							else {
								if(colCount == 0 && adminyn.equals("N") ){
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal+" &nbsp <br>Reason:"+(String)records.get(4));
									out.println("</td>");
								}
								else{
									out.println("<td class='"+classvalue+"'>");
									out.println(dkVal);
									out.println("</td>");
								}
							}
						}
					}			//end of record count

            _bw.write(_wl_block70Bytes, _wl_block70);

			}
			else{  

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block72Bytes, _wl_block72);

			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryMednAdminChartAdminDetails.jsp", searched) );
		}//end of try
		catch (Exception e){
			e.printStackTrace();
		}

            _bw.write(_wl_block73Bytes, _wl_block73);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.VerbalOrderWitnessedBy.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.selfadmin.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetails.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Prescribed.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administered.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Dose.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Administration.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Date/TimeRecorded.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchDetails.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationRemarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NonAdministrationRemarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PostAdministrationDetails.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RecordedDateTime.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RecordedBy.label", java.lang.String .class,"key"));
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
}
