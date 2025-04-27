package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.text.*;
import eCA.*;
import eOR.Common.*;
import eOR.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbylocationresultinclude1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByLocationResultInclude1.jsp", 1742180269744L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"referral_id";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"practitioner_Id";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sex";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"unAssigned_yn";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><!--32902-->\n\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'><!--32902-->\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<tr><td class=\'columnheader\' width=\'16px\'>&nbsp;</td><td class=\'columnheader\' width=\'16px\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\'  onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a></td><!--54073-->\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a01\'   href=\"javascript:callForOrderByLoc(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'AT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></td>\n\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t\t\t\t\t\t\t   <td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a></td>\n\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'QN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</a></td>\n\t\t\t\t\t\t\t\t<!--- ML-MMOH-CRF-2069.1--->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a18\'   href=\"javascript:callForOrderByLoc(\'QN2\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</a></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t<!--- ML-MMOH-CRF-2069.1--->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<td class=\'columnheader\' width=\"\" nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\'   nowrap><a style=\'color:white\'   >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a07\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a12\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a13\'   href=\"javascript:callForOrderByLoc(\'SAP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a15\'   href=\"javascript:callForOrderByLoc(\'VT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a09\'   href=\"javascript:callForOrderByLoc(\'VD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap colspan=2><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'QS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a></td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td><!-- IN044246 -->\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a10\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a14\'   href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a></td></tr>\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t    <!--32902 start-->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'><!--32902-->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'><!--32902-->\n\t\t\t\t\t\t\t\t<!--32902 end--->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' width=\'16px\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' width=\'16px\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\'  onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap colspan=\'3\'><a class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a10\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a07\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</a></td><!--Changes suggested by sunil-->\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'IQS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap> ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td><!-- IN044246 -->\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a09\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</a></td>\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t<td class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a18\'   href=\"javascript:callForOrderByLoc(\'PDA\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'><!--32902-->\n\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'><!--32902-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = (String)session.getAttribute("PREFERRED_STYLE") == null?"IeStyle.css":(String)session.getAttribute("PREFERRED_STYLE"); 
            _bw.write(_wl_block0Bytes, _wl_block0);

	Connection  con =null;
	String facility_id=(String)session.getValue("facility_id");
	if(facility_id == null) facility_id="";
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();    
	patdata.setFacility_id(facility_id);
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	PreparedStatement stmtMotherLink = null;
	
	PatListByLocationResult bean ;
	String bean_id = "CA_ca_patListbylocationresult" ;
	String bean_name = "eCA.PatListByLocationResult";
	
	String clinicianId =(String)session.getValue("ca_practitioner_id");

	ResultSet rsPatList = (ResultSet)request.getAttribute("rsPatList");

	
	ResultSet rsMotherLink = null;	
	boolean outpHeader=false, inpHeader=false;
	
	StringBuffer layer = new StringBuffer();
	
	String currcompstring = "", prevcompstring = "`", status =		null,sex="",currpract = null, currvisitdate = null,emergencyYn = null, deceasedYn = null, relationYn = null,className = null,className1 = null, text = null, disp_cls_cons_date =null;                  
	StringTokenizer st = null;
	String n =null, datedisplay = null, practScheduled= null, tempDischargeDate = "";
	boolean header = false;
	String p_queue_status = null; // added for CRF 192 - IN030532
	String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]		
	int count= 1, iterate = 0, end = 0,res_pat_rec_count=0, i=0,k=0,accessRightsViewPatient=0;
			
	
			
	String bar_code_site_yn = "",allow_muti_bedside_review_yn="";//getParam
	iterate=Integer.parseInt(request.getParameter("iterate")); 
	end=Integer.parseInt(request.getParameter("end")); 
	i= Integer.parseInt(request.getParameter("i"));
	

	
	String locn_type=request.getParameter("locn_type");
	bar_code_site_yn=request.getParameter("bar_code_site_yn");

	allow_muti_bedside_review_yn=request.getParameter("allow_muti_bedside_review_yn");

	String decesedColor =request.getParameter("decesedColor");
	String relnreqyn =request.getParameter("relnreqyn");
	String locale =request.getParameter("locale");
	String apgar_score =request.getParameter("apgar_score");
	String queue_status =request.getParameter("queue_status");
	String visit_episode_status =request.getParameter("visit_episode_status");
	String link_allowed_yn =request.getParameter("link_allowed_yn");
	String locationType =request.getParameter("locationType");
	String queueValue =request.getParameter("queueValue");
	String Sdate =request.getParameter("Sdate");
	String unscheduledyn =request.getParameter("unscheduledyn");
	String past=request.getParameter("past");
	String legendstyle=request.getParameter("legendstyle");
	String c4cStatuDisplay=request.getParameter("c4cStatuDisplay");
	String qms_call_counter=request.getParameter("qms_call_counter");
	String qms_interfaced_yn=request.getParameter("qms_interfaced_yn");
	String pre_dis_advc_prep_site_YN=request.getParameter("pre_dis_advc_prep_site_YN");

	String scan_count_required_yn=request.getParameter("scan_count_required_yn");
	String alert_required_yn=request.getParameter("alert_required_yn");
	String remarks_required_yn=request.getParameter("remarks_required_yn");

	String patName=request.getParameter("patName");
	String encounterID=request.getParameter("encounterID");
	String q_num=request.getParameter("q_num");
	String queueNumber=request.getParameter("queueNumber");
	String rowclass=request.getParameter("rowclass");
	String episode_type_desc=request.getParameter("episode_type_desc");
	String bedside_ref_review_status=request.getParameter("bedside_ref_review_status");
	String restPatientYN=request.getParameter("restPatientYN");
	String pi_clinical_stud_gif=request.getParameter("pi_clinical_stud_gif");
	
	Boolean isQMSapplicable = Boolean.parseBoolean(request.getParameter("isQMSapplicable"));
	Boolean isVirtualConsSiteSpec = Boolean.parseBoolean(request.getParameter("isVirtualConsSiteSpec"));
	Boolean isVirtualConsSDGSpec = Boolean.parseBoolean(request.getParameter("isVirtualConsSDGSpec"));
	Boolean qnum_patlist_bylocation = Boolean.parseBoolean(request.getParameter("qnum_patlist_bylocation"));


	Boolean flag = true;

	   String queNoFlag 	=	request.getParameter("queNoFlag")==null?"":request.getParameter("queNoFlag");//ML-MMOH-CRF-2069.1	
		String SECONDARY_TRIAGE_QUEUE_NO 	=	request.getParameter("SECONDARY_TRIAGE_QUEUE_NO")==null?"":request.getParameter("SECONDARY_TRIAGE_QUEUE_NO");//ML-MMOH-CRF-2069.1
		String QueueSecondaryFlag 	=	request.getParameter("QueueSecondaryFlag")==null?"":request.getParameter("QueueSecondaryFlag");//ML-MMOH-CRF-2069.1	
	int counts =Integer.parseInt(request.getParameter("counts"));

	String sqlMotherLink = "select a.patient_id pat_id, replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) ,'''','')  short_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH, a.WEIGHT, a.WEIGHT_UNIT, a.LENGTH ||' cms'  LENGTH_OF_BABY,a.CIRCUMFERENCE ||' cms'  CIRCUMFERENCE_OF_HEAD,a.APGAR_SCORE, b.sex from mp_birth_register a,mp_patient b where  b.patient_id=a.patient_id and a.mother_patient_id= ? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc  ";
			try{
				con = ConnectionManager.getConnection(request);
				Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
				bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
				stmtMotherLink = con.prepareStatement(sqlMotherLink);

				
				while(rsPatList.next() && iterate <=end ) 
				{
	
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025	- IN030466
					
					if(res_pat_rec_count > 0)
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					else
						pi_clinical_stud_gif = "";
					encounterID = rsPatList.getString("EPISODE_ID"); // added for CRF 192 - IN030532				
					p_queue_status = rsPatList.getString("queue_status");  // added for CRF 192 - IN030532
					q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");							
					if(q_num.equals("0")) queueNumber = "&nbsp;";
							else queueNumber = rsPatList.getString("QUEUE_NUM");
					String p_patient_id = rsPatList.getString("patient_id");// CRF 192 - IN030532


					iterate++ ;

					flag=false;
					
					if (k % 2 == 0 )
						rowclass = "gridData";
					else
						rowclass = "gridData";
					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";
						flag = false;			
						if(header == false)
						{
						
            _bw.write(_wl_block3Bytes, _wl_block3);
            {java.lang.String __page ="../../eCA/jsp/PatListByLocationResultHeader01.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block4Bytes, _wl_block4);

							header = true;
							i++;
						}
						rowclass = "gridData";				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";
						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
					    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding endIN072994
						if("U".equals(sex))
							sex = "Unknown";
						sex  = bean.getLabel(pageContext,sex);
						status  = bean.getLabel(pageContext,status);
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
							else if(bedside_ref_review_status.equals("C"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
							else if(bedside_ref_review_status.equals("N")) // IN052595 
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
							else if(bedside_ref_review_status.equals("X"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
							else if(bedside_ref_review_status.equals("S"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
						}
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";						
						st = new StringTokenizer(patient_status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED";
							rowclass = "DECEASED1";
							decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor = "";
						}else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en"))
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									else
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}	
						}
						out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("")) 
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");						
						else
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); //modifid above for CRF-025 IN030466									
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

								out.println("</a></font></td>");
								}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						}	// added for IN048463 - Start
						else {  
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals(""))){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
				
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

									out.println("</a></font></td>");
									}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}						
							else if(!referralRegister|| "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

								out.println("</a></font></td>");
							}
						} // added for IN048463 - End
							out.println("<script language='javascript'>");
							out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
							out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
							out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added forIN072994
						    out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added forIN072994
						    out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added forIN072994
							out.println("</script>");
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("patient_id")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("referral_id")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("sex")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("unAssigned_yn")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block19Bytes, _wl_block19);

						i++;
						k++;
					}else{
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");
						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";
						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date ="&nbsp;";
						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}				
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");
						if(deceasedYn.equals("D")){
							className="CADECEASED"; rowclass = "DECEASED1"; decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";  decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D")){	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date = "&nbsp;";
						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						if(rsPatList.getString("episode_type").equals("O")){
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+ rsPatList.getString("QRYTIME")+"</b>'}</script>");
								
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(locationType.equals("OP")){
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(queueValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(qnum_patlist_bylocation && queNoFlag.equalsIgnoreCase("Y") && QueueSecondaryFlag.equalsIgnoreCase("Y") && (locn_type.equals("EM") || locationType.equals("EM"))){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QNo.label","ca_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
} 
            _bw.write(_wl_block30Bytes, _wl_block30);
 							
								if(isQMSapplicable && locn_type.equals("OP")){ 
								
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

								if(isVirtualConsSiteSpec && "OP".equals(locationType)){
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
								
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(locationType.equals("OP")){
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(locationType.equals("EM")){
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
 }
            _bw.write(_wl_block5Bytes, _wl_block5);

								i++; i++;  outpHeader=true;
							}						
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else
									practScheduled = "Assigned";
								currcompstring = practScheduled;						
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = currvisitdate;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else 
									practScheduled = "Assigned";
								currcompstring = practScheduled+currvisitdate;
							}
							if(!currcompstring.equals("")){
								if(!currcompstring.equals(prevcompstring)){
									i++;
								}
							}	
						    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+ counts++ +"&nbsp;"+c4cStatuDisplay+"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td>");//51817 						
						if(locationType.equals("OP"))	{	
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}else{
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}
						}
						    out.println("<td id='rtc"+i+"' class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td>");
						  //ML-MMOH-CRF-2069.1 start
						    if(qnum_patlist_bylocation && queNoFlag.equalsIgnoreCase("Y")  && QueueSecondaryFlag.equalsIgnoreCase("Y") && (locn_type.equals("EM") || locationType.equals("EM"))){
								
								String qnumber= rsPatList.getString("SECONDARY_TRIAGE_QUEUE_NO")== null?"&nbsp;&nbsp;&nbsp;":rsPatList.getString("SECONDARY_TRIAGE_QUEUE_NO");
								out.println("<td id='rtb"+i+"' class=gridData nowrap>&nbsp;"+qnumber+"</td>");
								
								
							}
							//ML-MMOH-CRF-2069.1 end
							//<!-- 51817 Ends
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT"); // added for  // added for CRF 192 - IN030532 - Start
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1)
							{
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM"))){
									out.println("<td id='rtp"+i+"' class=gridData nowrap><img style='cursor:pointer;' src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> "); //IN000000
								}else{
									out.println(" <td id='rtp"+i+"' class = gridData nowrap>&nbsp;</td> ");//IN000000
								}
							} // END added for CRF 192 - IN030532					
							if(link_allowed_yn.equals("Y")){
								out.println("<td id='rtd"+i+"' class=gridData nowrap><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN000000							
							}else{
								out.println("<td id='rtd"+i+"' class=gridData nowrap><font color="+decesedColor+">"+patName);//IN000000
							}
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
							}
							
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block50Bytes, _wl_block50);

							out.println("</font></td><td id='rte"+i+"' class=gridData nowrap>"+rsPatList.getString("patient_id")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class=gridData nowrap>"+sex+"</td><td id='rth"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td><td id='rti"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("SPLTY_NAME")+"</a></td>");//Added - Changes suggested by sunil
							if(locationType.equals("OP")){
							out.println("<td id='rtq"+i+"' class=gridData nowrap>"+rsPatList.getString("visit_type")+"</td>");
							}
							out.println("<td id='rtj"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtk"+i+"' class=gridData nowrap colspan='2'>"+queue_status+"</td><td id='rtl"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
						if(locationType.equals("EM")){	
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}}
						}
						else if(rsPatList.getString("episode_type").equals("I"))
						{
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else { 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append( "<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}							
							}
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

								if("Y".equals(pre_dis_advc_prep_site_YN)){
							
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

								}
							
            _bw.write(_wl_block65Bytes, _wl_block65);

								i++; i++; inpHeader=true;	
							}
							 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+counts++ +"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap colspan='3'>");//54073
							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink'  href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928													
							}
							else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							out.println("</font></td><td id='rtc"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rtd"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rte"+i+"' class=gridData nowrap>"+sex+"</td>");
							out.println("<td id='rtk"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("BED_NUM")+"</a></td>");
							out.println("<td id='rtl"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("ROOM_NUM")+"</a></td>");
							out.println("<td id='rtf"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rtg"+i+"' class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td id='rth"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rti"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td>");
							out.println("<td id='rtj"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>"); // added for CRF-025 - IN030466//Changes suggested bu sunil
							if(rsPatList.getString("referral_id")!= null){
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}
								else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}else{
								if("N".equals(pre_dis_advc_prep_site_YN)){	
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}
							if("Y".equals(pre_dis_advc_prep_site_YN)){
								if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
									out.println("<td class=gridData nowrap>");
								
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

								out.println("</td></tr>");
								}else{
									out.println("<td class=gridData nowrap>");
								
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

									out.println("</td></tr>");
								}
							}
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");					
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
					   
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block69Bytes, _wl_block69);

						i++; k++;
						prevcompstring = currcompstring; link_allowed_yn="Y";
					}
				}
				/* } */
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();	
			
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
			finally{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.CallTicket.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PreDischargeAdvice.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Prepared.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NotPrepared.label", java.lang.String .class,"key"));
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
}
