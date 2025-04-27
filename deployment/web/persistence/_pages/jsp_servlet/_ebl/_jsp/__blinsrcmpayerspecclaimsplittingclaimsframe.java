package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.derby.tools.sysinfo;
import eBL.ClaimSplittingBean;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import eBL.Common.BlRepository;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blinsrcmpayerspecclaimsplittingclaimsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLInsRCMPayerSpecClaimSplittingClaimsFrame.jsp", 1725509317944L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n<html>\r\n<head>\r\n\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/BLInsRCMPayerSpecSupDocConfig.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/BLInsRCMPayerSpecClaimSplitting.js\"></script>\r\n\r\n</head>\r\n\r\n\r\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" >\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n<form  name=\"TypeTableFrm\" id=\'TypeTableFrm\' >\r\n\t<table  border=\'0\' cellpadding=\'1\' cellspacing=\'1\' align=\'center\' width=\'100%\'>\r\n\t\t<tr>\r\n\t\t\t<td class=\'columnheadercenter\' nowrap colspan = 2>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t<tr/>\r\n\t</table>\r\n\t<table  cellpadding=\'10\' cellspacing=\'0\'  align=\"center\" width=\"100%\" name=\"tblType\" id=\"tblType\" border=\"1\"  >\r\n\t\t\r\n\t\t<thead>\r\n\t\t<TR>\r\n\t\t<td  class=\'columnheader\' width=\"3%\" align=\"center\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\r\n\t\t<td  class=\'columnheader\' width=\"15%\" align=\"center\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<img src=\'../../eCommon/images/mandatory.gif\'></td>\r\n\t\t<td  class=\'columnheader\' width=\"15%\" align=\"center\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\r\n\t\t<td  class=\'columnheader\' width=\"25%\" align=\"center\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" <img src=\'../../eCommon/images/mandatory.gif\'></td>\r\n\t\t<td  class=\'columnheader\' width=\"10%\" align=\"center\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\r\n\t\t<td  class=\'columnheader\' width=\"20%\" align=\"center\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\r\n\t\t<td  class=\'columnheader\' width=\"10%\" align=\"center\"></td>\r\n\t\t</TR>\r\n\t\t</thead>\r\n\t\t<tbody>\r\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\r\n\t\t<tr rowvalue=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'tr_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\"loadClassificationDetails(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" >\r\n\t\t\t\t\r\n\t\t\t\t<td class=\'fields\' id=\'td_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="_0\' style=\"text-align:center\">\r\n\t\t\t\t\t<span name=\'sNo_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'sNo_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' id=\'td_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="_1\' style=\"text-align:center\">\r\n\t\t\t\t\t<input type=\'text\' name=\'claimTypeCode_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'claimTypeCode_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'size=\'10\' maxlength=\'3\' onblur=\'if(this.value!=\"\"){claimTypeLookup(claimTypeDesc_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =",claimTypeCode_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =");validateClaimTypeCode(this);}else{clearField(claimTypeDesc_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =");}\'/>\r\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"claimTypeCodeBtn_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"claimTypeCodeBtn_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" value=\'?\' onClick=\"claimTypeLookup(claimTypeDesc_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");validateClaimTypeCode(this);\" tabindex=\'2\'>\r\n\t\t\t\t\t<input type=\'hidden\' name=\'cName_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'cName_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'/>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\'  id=\'td_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="_2\' style=\"text-align:center\">\r\n\t\t\t\t\t<input type=\'text\' name=\'claimTypeDesc_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'claimTypeDesc_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' size=\'20\' maxlength=\'20\' readonly value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' \'/>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' id=\'td_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="_3\' style=\"text-align:center\">\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="  <input type=\"checkbox\" name=\"all_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\"all_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"  onClick=\"validateAndchangeAll(this);\">\r\n\t\t\t\t\t  &nbsp;\r\n\t\t\t\t\t   \r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="  <input type=\"checkbox\" name=\"appl_ip_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\"appl_ip_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" onClick=\"checkEpisodeType(this);\">\r\n\t\t\t\t\t  &nbsp; \t\r\n\t\t\t\t\t  \r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="  <input type=\"checkbox\" name=\"appl_dc_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\"appl_dc_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"  onClick=\"checkEpisodeType(this);\">\r\n\t\t\t\t\t\t&nbsp; \r\n\t\t\t\t\t\t\r\n\t\t\t\t\t  \r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="  <input type=\"checkbox\" name=\"appl_op_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\"appl_op_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"  onClick=\"checkEpisodeType(this);\">\r\n\t\t\t\t\t  &nbsp;\r\n\t\t\t\t\t  \r\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="  <input type=\"checkbox\" name=\"appl_em_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\"appl_em_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" onClick=\"checkEpisodeType(this);\">\r\n\t\t\t\t\t \r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' id=\'td_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="_4\' style=\"text-align:center\">\r\n\t\t\t\t\t<input type=\"checkbox\" name=\"dfltClaimType_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"dfltClaimType_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" onClick=\"changeDfltClaimType(this);\">\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' id=\'td_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="_5\' style=\"text-align:center\">\r\n\t\t\t\t\t<input type=\'text\' name=\'dfltSubgroup_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'dfltSubgroup_";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' size=\'20\' ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" maxlength=\'20\' < value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' onblur=\'if(this.value!=\"\"){claimSubgroupLookup(dfltSubgroup_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =",dfltSubgroupCode_";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =");}else{clearField(claimSubgroupCode_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =");}\'/>\r\n\t\t\t\t\t<input type=\'hidden\' name=\'dfltSubgroupCode_";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'dfltSubgroupCode_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' />\r\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"dfltSubgroupBtn_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" id=\"dfltSubgroupBtn_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" value=\'?\' onClick=\"claimSubgroupLookup(dfltSubgroup_";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =");\" tabindex=\'2\'>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\'fields\' id=\'td_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="_6\' style=\"text-align:center\">\r\n\t\t\t\t<img src=\'../../eCommon/images/MarkError.gif\' name=\"deleteBtn_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"  id=\"deleteBtn_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" onClick=\'deleteTypeRow(this)\' />\r\n\t\t\t\t</td>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t</tr>\r\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\r\n\t</table>\r\n\t<br/>\r\n\t<div style=\"width: 100%; text-align: right; padding:5px\">\r\n\t<input type=\'button\' class=\'button\' name=\"add_btn\"   id=\"add_btn\" value=\'Add\' onClick=\"addTypeRow()\" style=\"margin-right: 2px;\" ></\r\n\t</div>\r\n\t<input type=\'hidden\' name=\'locale\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\r\n\t<input type=\'hidden\' name=\'facility_id\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\r\n\t<input type=\'hidden\' name=\'payerGroup\' id=\'payerGroup\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\r\n\t<input type=\'hidden\' name=\'payer\' id=\'payer\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\r\n\t<input type=\'hidden\' name=\'policy\' id=\'policy\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\r\n\t<input type=\'hidden\' name=\'mode\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\r\n\t<input type=\'hidden\' name=\'typeRowCount\' id=\"typeRowCount\" value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\r\n\t<input type=\'hidden\' name=\'pageInfo\' id=\'pageInfo\' value=\'docsInfo\'>\r\n\t<input type=\'hidden\' name=\'prevClicked\' value=\'N\'>\r\n\t<input type=\'hidden\' name=\'rowClicked\' value = \'\'>\r\n\r\n\r\n    </form>\r\n\r\n</body>\r\n</html>\r\n\r\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );
	
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);


		
	 request.setCharacterEncoding("UTF-8"); 
	 String beanId = "bl_ClaimSplittingBean" ;
	 String beanName = "eBL.ClaimSplittingBean";
	
	 ClaimSplittingBean docBean = (ClaimSplittingBean) getBeanObject(beanId, beanName, request);
	 
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String mode = checkForNull(request.getParameter("mode"));
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");

	
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode")); 
	
	System.out.println("the payer group code is "+payerGroup);
	System.out.println("the payer Code is "+payer);
	System.out.println("the policy code is "+policy);
	
	
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	
	ClaimSplittingBean fmtDtlsBean=null;
	List<ClaimSplittingBean> claimTypes = new ArrayList<ClaimSplittingBean>(); 
	int sNo=1;
	List<ClaimSplittingBean> classTypes = new ArrayList<ClaimSplittingBean>();
	if(docBean.getClassificationList() == null)
	docBean.initMap();
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	
	String readonly = "";
	String disabled = "";

	Connection conn  =  null;
	PreparedStatement stmt = null;
	ResultSet rs =null;
	String sql="";
	int tableIndex=1;
	
	if(mode.equals("modify")){
			
		if(docBean.getClaimTypeList() == null)
		 {
			try{
				con = ConnectionManager.getConnection(request);
				claimTypes=new ArrayList();
				sql= "select claim_type_code,(select short_desc from BL_CLAIM_TYPE lst where stup.claim_type_code=lst.claim_type) claim_type_desc , stup.DFLT_CLAIM_TYPE_YN,stup.APPL_OP_YN,stup.APPL_EM_YN,stup.APPL_DC_YN,stup.APPL_IP_YN, stup.DFLT_CLAIM_SUB_GROUP, (select short_desc from BL_CLAIM_SUBGROUP lst where stup.dflt_claim_sub_group=lst.CLAIM_SUBGROUP_CODE) dflt_claim_sub_group_desc from BL_CLAIM_TYPE_SETUP_HDR stup where stup.CUST_GROUP_CODE=? and stup.CUST_CODE=? and stup.policy_type_code=? and operating_facility_id=? and (status_yn='Y' or status_yn is null)";
				stmt = con.prepareStatement(sql);
				stmt.setString(1,payerGroup);
				stmt.setString(2,payer);
				stmt.setString(3,policy);
				stmt.setString(4,facility_id);
				
				
				rs = stmt.executeQuery();
				while(rs.next()){
					fmtDtlsBean = new ClaimSplittingBean();
					fmtDtlsBean.setPayerCode(payer);
					fmtDtlsBean.setPayerGroupCode(payerGroup);
					fmtDtlsBean.setClaimTypeCode(checkForNull(rs.getString("claim_type_code")));
					fmtDtlsBean.setClaimTypeDesc(checkForNull(rs.getString("claim_type_desc")));
					fmtDtlsBean.setEpisodeIP(checkForNull(rs.getString("APPL_IP_YN"),"N"));
					fmtDtlsBean.setEpisodeDC(checkForNull(rs.getString("APPL_DC_YN"),"N"));
					fmtDtlsBean.setEpisodeER(checkForNull(rs.getString("APPL_EM_YN"),"N"));
					fmtDtlsBean.setEpisodeOP(checkForNull(rs.getString("APPL_OP_YN"),"N"));
					fmtDtlsBean.setDefClaimType(checkForNull(rs.getString("DFLT_CLAIM_TYPE_YN"),"N"));
					fmtDtlsBean.setDefSubGroupCode(checkForNull(rs.getString("DFLT_CLAIM_SUB_GROUP")));
					fmtDtlsBean.setDefSubGroupDesc(checkForNull(rs.getString("dflt_claim_sub_group_desc")));
					
					if(fmtDtlsBean.getEpisodeIP().equals("Y")&&fmtDtlsBean.getEpisodeOP().equals("Y")&&fmtDtlsBean.getEpisodeDC().equals("Y")&&fmtDtlsBean.getEpisodeER().equals("Y")){
							fmtDtlsBean.setEpisodeAll("Y");
					}
					else{
						fmtDtlsBean.setEpisodeAll("N");
					}
					claimTypes.add(fmtDtlsBean);
				}
				docBean.setClaimTypeList(claimTypes);
				
				classTypes=new ArrayList();				
				sql="select stup.claim_type_code,stup.APPL_IP_YN,stup.APPL_OP_YN,APPL_DC_YN,APPL_EM_YN,stup.BLNG_SERV_IND ,blcommonproc.get_description('SERV_CRIT', stup.blng_serv_ind,stup.blng_serv_code,?) AS blng_serv_desc,stup.BLNG_SERV_CODE, stup.CLAIM_SUBGROUP_CODE,(select short_desc from BL_CLAIM_SUBGROUP lst where stup.CLAIM_SUBGROUP_CODE=lst.CLAIM_SUBGROUP_CODE) claim_subgroup_desc  from BL_CLAIM_TYPE_SETUP_DTL stup where CUST_GROUP_CODE=? and CUST_CODE=? and policy_type_code=? and operating_facility_id=? and (status_yn='Y' or status_yn is null)";
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1,locale);
				stmt.setString(2,payerGroup);
				stmt.setString(3,payer);
				stmt.setString(4,policy);
				stmt.setString(5,facility_id);
				rs = stmt.executeQuery();
				
				while(rs.next()){
					fmtDtlsBean = new ClaimSplittingBean();
					fmtDtlsBean.setPayerCode(payer);
					fmtDtlsBean.setPayerGroupCode(payerGroup);
					fmtDtlsBean.setEpisodeIP(checkForNull(rs.getString("APPL_IP_YN"),"N"));
					fmtDtlsBean.setEpisodeOP(checkForNull(rs.getString("APPL_OP_YN"),"N"));
					fmtDtlsBean.setEpisodeDC(checkForNull(rs.getString("APPL_DC_YN"),"N"));
					fmtDtlsBean.setEpisodeER(checkForNull(rs.getString("APPL_EM_YN"),"N"));
					fmtDtlsBean.setClassType(checkForNull(rs.getString("BLNG_SERV_IND")));
					fmtDtlsBean.setBlngServCode(checkForNull(rs.getString("BLNG_SERV_CODE")));
					fmtDtlsBean.setBlngServDesc(checkForNull(rs.getString("blng_serv_desc")));
					fmtDtlsBean.setClaimTypeCode(checkForNull(rs.getString("claim_type_code")));
					fmtDtlsBean.setClaimSubgroup(checkForNull(rs.getString("CLAIM_SUBGROUP_CODE")));
					fmtDtlsBean.setClaimSubgroupDesc(checkForNull(rs.getString("CLAIM_SUBGROUP_DESC")));
					
					if(fmtDtlsBean.getEpisodeIP().equals("Y")&&fmtDtlsBean.getEpisodeOP().equals("Y")&&fmtDtlsBean.getEpisodeDC().equals("Y")&&fmtDtlsBean.getEpisodeER().equals("Y")){
							fmtDtlsBean.setEpisodeAll("Y");
					}
					else{
						fmtDtlsBean.setEpisodeAll("N");
					}
					classTypes.add(fmtDtlsBean);
				}
				
				
			String classificationName="";
			for(int i=0;i<classTypes.size();i++){
				classificationName="";
				classificationName+=classTypes.get(i).getClaimTypeCode();
				System.err.println("classTypesize---->>>"+classTypes.size());
				
					if(classTypes.get(i).getEpisodeAll().equals("Y")){
							 classificationName+="-All";
							
					}else{
							if(classTypes.get(i).getEpisodeIP().equals("Y")) classificationName+="-IP";
							if(classTypes.get(i).getEpisodeOP().equals("Y")) classificationName+="-OP";
							if(classTypes.get(i).getEpisodeDC().equals("Y")) classificationName+="-DC";
							if(classTypes.get(i).getEpisodeER().equals("Y")) classificationName+="-EM";
					}
				
				System.err.println(classificationName);
				System.err.println(classTypes.get(i).getClaimTypeCode());
				boolean sk=docBean.addToClassificationList(classTypes.get(i),classificationName);
				System.err.println("boolean>>>"+sk);
				System.err.println("docBean>>>"+docBean.getClassificationList().get(classificationName).size());
			}
				System.out.println("The classification list size is "+docBean.getClassificationList().size());
			}catch(Exception e){
				
				e.printStackTrace();
			}finally{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn);
				
			}
		
	}
	}
	
		if(docBean.getClaimTypeList() != null){
		  System.out.println(docBean.getClaimTypeList().size());
		  claimTypes=docBean.getClaimTypeList();
		
		}

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		
			ClaimSplittingBean claimType=null;
			if(!(claimTypes == null || claimTypes.isEmpty())){
					
				String checked = "";
				String disableSubgroup="";
				String cName="";
				for(int i=0;i<claimTypes.size();i++){
					disableSubgroup="disabled";
					claimType=claimTypes.get(i);
					cName=claimType.getClaimTypeCode();
					if(claimType.getDefClaimType().equals("Y")) disableSubgroup="";
					if(claimType.getEpisodeAll().equals("Y")){
							 cName+="-All";
							
					}else{
							if(claimType.getEpisodeIP().equals("Y")) cName+="-IP";
							if(claimType.getEpisodeOP().equals("Y")) cName+="-OP";
							if(claimType.getEpisodeDC().equals("Y")) cName+="-DC";
							if(claimType.getEpisodeER().equals("Y")) cName+="-EM";
					}
		
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(claimType.getClaimTypeCode()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cName));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(claimType.getClaimTypeDesc()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(claimType.getEpisodeAll()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(claimType.getEpisodeAll().equals("Y")?"checked ":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(claimType.getEpisodeAll()));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(claimType.getEpisodeIP()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(claimType.getEpisodeIP().equals("Y")?"checked ":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(claimType.getEpisodeIP()));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(claimType.getEpisodeDC()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(claimType.getEpisodeDC().equals("Y")?"checked ":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(claimType.getEpisodeDC()));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(claimType.getEpisodeOP()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(claimType.getEpisodeOP().equals("Y")?"checked ":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(claimType.getEpisodeOP()));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(claimType.getEpisodeER()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(claimType.getEpisodeER().equals("Y")?"checked ":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(claimType.getEpisodeER()));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(claimType.getDefClaimType().equals("Y")?"checked ":""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(claimType.getDefClaimType()));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disableSubgroup));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(claimType.getDefSubGroupDesc()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(claimType.getDefSubGroupCode()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disableSubgroup));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block77Bytes, _wl_block77);

			tableIndex++;
			sNo++;
				}
			}
		
		
		
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(payerGroup));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(policy));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block85Bytes, _wl_block85);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.claimTypes.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Sno.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.claimTypeCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.claimTypeDesc.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.episodeTypes.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.defaultClaimType.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.defaultSubgroup.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IP.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DC.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OP.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EM.label", java.lang.String .class,"key"));
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
}
