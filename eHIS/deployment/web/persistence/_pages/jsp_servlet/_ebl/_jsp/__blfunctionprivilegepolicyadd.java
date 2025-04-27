package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eBL.BLFunctionPrivilegeBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blfunctionprivilegepolicyadd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFunctionPrivilegePolicyAdd.jsp", 1737915976389L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="    \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLFunctionPrivilegePolicy.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n\t<form name=\'frmPolicyAdd\' id=\'frmPolicyAdd\' action=\"\">\n\t\t<table id=\'tblPayerDetails\' name=\'tblPayerDetails\' width=\'98%\' align=\"center\" class=\'grid\' border=\'1\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'26%\' nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'26%\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'9%\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'4%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr style=\"visibility: collapse;\">\n\t\t\t\t<td class=\'fields\' width=\'26%\' nowrap>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'26%\' nowrap>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'26%\' nowrap>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'9%\' nowrap>\n\t\t\t\t\t&nbsp;\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'9%\' nowrap>\n\t\t\t\t\t&nbsp;\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'4%\' nowrap>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t <tr rowValue=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t<td class=\'fields\' width=\'26%\' nowrap>\n\t\t\t\t\t<input type=\'text\' name=\'custGrpCode_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'custGrpCode_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' size=\"15\" onblur=\"if(this.value!=\'\'){ callCommonValidation(1,custGrpDesc_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =",custGrpCode_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =",1,custGrpCode_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =",custCode_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="); } else{ fnClearCode(custGrpDesc_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'custGrpDesc_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'custGrpDesc_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' size=\"30\" onblur=\"if(this.value!=\'\'){ callCommonValidation(1,custGrpDesc_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =",2,custGrpCode_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="); } else{ fnClearCode(custGrpCode_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"custGrpBtn_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"custGrpBtn_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" value=\'?\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onClick=\"callCommonValidation(1,custGrpCode_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",custGrpDesc_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",3,custGrpCode_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =");\" tabindex=\'2\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'26%\' nowrap>\n\t\t\t\t\t<input type=\'text\' name=\'custCode_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'custCode_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' size=\"15\" onblur=\"if(this.value!=\'\'){ callCommonValidation(2,custDesc_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="); } else{ fnClearCode(custDesc_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'custDesc_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'custDesc_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' size=\"30\" onblur=\"if(this.value!=\'\'){ callCommonValidation(2,custDesc_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="); } else{ fnClearCode(custCode_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"custBtn_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"custBtn_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" onClick=\"callCommonValidation(2,custDesc_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =");\" tabindex=\'2\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'26%\' nowrap>\n\t\t\t\t\t<input type=\'text\' name=\'policyCode_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'policyCode_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' size=\"15\" onblur=\"if(this.value!=\'\'){ callCommonValidation(3,policyDesc_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =",policyCode_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="); } else{ fnClearCode(policyDesc_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'policyDesc_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'policyDesc_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' size=\"30\" onblur=\"if(this.value!=\'\'){ callCommonValidation(3,policyDesc_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="); } else{ fnClearCode(policyCode_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"policyBtn_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"policyBtn_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" onClick=\"callCommonValidation(3,policyDesc_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =");\" tabindex=\'2\'>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'9%\' nowrap>\n\t\t\t\t\t<input type=\"text\" name=\'effFrom_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'effFrom_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' size=\'6\' onblur=\'isValidDate(this);checkDates(this,effTo_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =");\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'effFrom_ctrl_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onClick=\'return showCalendar(\"effFrom_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\")\' />\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'9%\' nowrap>\n\t\t\t\t\t<input type=\"text\" name=\'effTo_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'effTo_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' size=\'6\' onblur=\'isValidDate(this);checkDates(effFrom_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =",this);\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'effTo_ctrl_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' name=\'effTo_ctrl_";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' onClick=\'return showCalendar(\"effTo_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\")\' />\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' width=\'4%\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t<input type=\"checkbox\" name=\'allowableYn_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'allowableYn_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'  ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">\n\t\t\t\t\t<input type=\'hidden\' name=\'status_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'status_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<script>makeFieldsDisable(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');</script>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\'  value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n\t\t<input type=\'hidden\' name=\'mode\'  value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n\t\t\n\t\t<input type=\'hidden\' name=\'userType\' id=\'userType\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t<input type=\'hidden\' name=\'userCode\' id=\'userCode\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n\t\t<input type=\'hidden\' name=\'functionId\' id=\'functionId\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t\t<input type=\'hidden\' name=\'privilegeCode\' id=\'privilegeCode\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t\t<input type=\'hidden\' name=\'effectiveDate\' id=\'effectiveDate\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n\t\t<input type=\'hidden\' name=\'privilegeKey\' id=\'privilegeKey\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t<input type=\'hidden\' name=\'allowedYn\' id=\'allowedYn\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\' value=\'\'>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );
	
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


private String checkForNull(String inputString) {
	return (inputString == null) ? "" : inputString;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8"); 
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String userType = checkForNull(request.getParameter("userType"));
	String userCode = checkForNull(request.getParameter("userCode"));
	String mode = checkForNull(request.getParameter("mode")); 
	String functionId = checkForNull(request.getParameter("functionId"));
	String privilegeCode = checkForNull(request.getParameter("privilegeCode"));
	String effectiveDate = checkForNull(request.getParameter("effectiveDate"));
	String allowedYn = checkForNull(request.getParameter("allowedYn"));
	String privilegeKey = facility_id+"~"+userType+"~"+userCode+"~"+functionId+"~"+privilegeCode;
	
	String beanId = "FunctionPrivilegeBean";
	String beanName = "eBL.BLFunctionPrivilegeBean";
	String readonly = "";
	String disabled = "";
	ArrayList<BLFunctionPrivilegeBean> payerList = null;
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	BLFunctionPrivilegeBean funcPrivilegeBean = null;
	HashMap<String,ArrayList<BLFunctionPrivilegeBean>> payerMap = null;
	try{
		con = ConnectionManager.getConnection(request);
		funcPrivilegeBean = (BLFunctionPrivilegeBean) getBeanObject(beanId, beanName, request);
		if(funcPrivilegeBean.getPayerDtlMap() == null){
			funcPrivilegeBean.setPayerDtlMap(new HashMap<String,ArrayList<BLFunctionPrivilegeBean>>());			
		}
		payerMap = funcPrivilegeBean.getPayerDtlMap();
		if(payerMap.containsKey(privilegeKey)){
			payerList = payerMap.get(privilegeKey);
		}
		/*if(payerList == null || payerList.isEmpty()){
			payerList = new ArrayList<BLFunctionPrivilegeBean>();
			payerList.add(new BLFunctionPrivilegeBean());
		}*/
	}
	catch(Exception e){
		System.err.println("Exception in BLFunctionPrivilegePolicyAdd->"+e);
	}
	finally{
		ConnectionManager.returnConnection(con);
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			if(!(payerList == null || payerList.isEmpty())){
				int tableIndex = 1;
				String checked = "";
			for (BLFunctionPrivilegeBean bean : payerList) {
				if("I".equals(bean.getStatus())){
					readonly = "";
					disabled = "";
				}
				else if("U".equals(bean.getStatus())){
					readonly = "readonly";
					disabled = "disabled";
				}
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getCustGrpCode()) ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getCustGrpDesc()) ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getCustCode()) ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getCustDesc()) ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getPolicyCode()) ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getPolicyDesc()) ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getEffFromDate()) ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getEffToDate()) ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block67Bytes, _wl_block67);
if("Y".equals(bean.getAllowable())){ 
						checked = "Checked";
					}
					else{
						checked = "";
					}
					
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(checked ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(bean.getStatus()) ));
            _bw.write(_wl_block73Bytes, _wl_block73);
if("U".equals(bean.getStatus())){ 
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block75Bytes, _wl_block75);

				}
			tableIndex++;
			}			
			}
			
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(mode ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(userType));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(userCode));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(functionId ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(privilegeCode));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(effectiveDate ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(privilegeKey ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(allowedYn ));
            _bw.write(_wl_block86Bytes, _wl_block86);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ALLOWED_YN.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
