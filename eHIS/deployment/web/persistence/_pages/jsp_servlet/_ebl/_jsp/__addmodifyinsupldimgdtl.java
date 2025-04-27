package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifyinsupldimgdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyInsUpldImgDtl.jsp", 1737915249470L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!--\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n10/12/12      100         Bmohankumar  created\nActs as create and Modify screen for PackageServicegroup\ncalled on click of create button from common tool bar\non submission (apply) request will be submitted to  \n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n<head>\n<title>Upload Documents Window</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script language=\'javascript\'>\n//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550\nfunction callNewImg(){\n\tvar moduleId=document.getElementById(\"strModuleId\").value;\n\tvar patient_id=document.getElementById(\"patient_id\").value;\n\tif(moduleId==\"MP\" &&(patient_id !=\"\" && patient_id !==null)){\n\t\tdocument.location.href=\"../../eBL/jsp/AddModifyInsUpldImgDtlNew.jsp\";\t//GHL-CRF-0550.1\t\n\t}\n}\nfunction viewImage_ghl(ind)\n{\n\t//GHL-CRF-0550.1\n\tvar smt_ind=document.getElementById(\"smt_ind\").value;\n\tif(smt_ind==\'X\'){\n\t\tdat1=document.getElementById(\'line_\'+ind).value ;\n\t}else{\n\t\tif(ind==0){\n\t\t\tdat1=document.getElementById(\'line_\').value;\n\t\t}\n\t\telse{\n\t\t\tdat1=document.getElementById(\'line_\').value + ind;\n\t\t}\n\t}\n\t/* if(ind==0){\n\t\tdat1=document.getElementById(\'line_\').value;\t\n\t}\n\telse{\n\t\tdat1=document.getElementById(\'line_\').value + ind;\n\t}\n */\t\n\t//GHL-CRF-0550.1\n\tvar arguments = \"\";\n\tvar dialogUrl       = \"../../eBL/jsp/BLInsImgShow.jsp?index=\"+dat1+\"&title=Insurance Image\" ;\n\tvar dialogFeatures  = \"dialogHeight:\" + \"20\" + \"; dialogWidth:\" + \"30\" +\" ; scroll=auto; \";\n\twindow.open(dialogUrl);\n}\n\nfunction updateDetails1(ind,blgname,moduleid)\n{\n\tvar billing_grp_name=blgname;\n\tvar strModuleId=moduleid;\n\tvar dat1;\n\t//GHL-CRF-0550.1\n\tvar smt_ind=document.getElementById(\"smt_ind\").value;\n\tif(smt_ind==\'X\'){\n\t\tdat1=document.getElementById(\'line_\'+ind).value ;\n\t}else{\n\t\tif(ind==0){\n\t\t\tdat1=document.getElementById(\'line_\').value;\n\t\t}\n\t\telse{\n\t\t\tdat1=document.getElementById(\'line_\').value + ind;\n\t\t}\n\t}\n\t//GHL-CRF-0550.1\n\tvar checkedRow=document.getElementById(\"checkedRow\").value;\n\tvar policy_no=document.getElementById(\"policy_no\").value;\n\tvar patient_id= $(\'#patient_id\').val();\n\tparent.baseDateDtl.document.location.href=\'../../eBL/jsp/AddModifyInsUpldImgHdr.jsp?index=\'+dat1+\'&mode=U\'+\'&patient_id=\'+patient_id+\'&billing_grp_Name=\'+billing_grp_name+\'&strModuleId=\'+strModuleId+\'&checked_row=\'+checkedRow+\'&policy_no=\'+policy_no;//Added dat against Incident No:9983\n\t//GHL-CRF-0550.1\t\n}\n//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550\n\nasync function viewImage(ind1)\n{\n\tvar dat =eval(\'document.forms[0].line_\'+ind1).value;\n\tvar dialogUrl       = \"../../eBL/jsp/BLInsImgShow.jsp?index=\"+dat+\"&title=Insurance Image\" ;\n\tvar dialogFeatures  = \"dialogHeight:\" + \"20\" + \"; dialogWidth:\" + \"30\" +\" ; scroll=auto; \";\n\tvar returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);\t\n}\n\nfunction updateDetails(ind,billing_grp_name)//V220818 \n{\n\tvar dat =eval(\'document.forms[0].line_\'+ind).value;\n\tvar policy_no=document.getElementById(\"policy_no\").value;\n\tvar patient_id= $(\'#patient_id\').val();\n\tparent.baseDateDtl.document.location.href=\'../../eBL/jsp/AddModifyInsUpldImgHdr.jsp?index=\'+dat+\'&mode=U\'+\'&patient_id=\'+patient_id+\'&billing_grp_Name=\'+billing_grp_name+\'&policy_no=\'+policy_no;\n}\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\'../js/BillingPackageServiceGroup.js\'></script> \n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"callNewImg()\" >\n\t<form name=\"PackageServicegroupHeaderForm\" id=\"PackageServicegroupHeaderForm\" method=\"post\"  action=\"\">  \n\t\n\t<TABLE border=\'0\' cellpadding=\'1\' cellspacing=\'0\' width=\'100%\'>\n\t<tr>\t\t\t\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><!-- Added V191114-Aravindh/GHL-CRF-0550 -->\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<!-- Added V191114-Aravindh/GHL-CRF-0550 -->\n\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'COLUMNHEADER\'nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<!-- Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 -->\n\t</tr>\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t\t<tr>\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<td  class=\'fields\' >&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' nowrap>&nbsp;<a href=\"javascript:updateDetails1(";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a></td>\n\t\t\t\t<td  class=\'fields\' nowrap >&nbsp;<a href=\"javascript:updateDetails(";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\"> &nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a></td>\t<!--V220818-->\n\t\t\t\t<!-- \n\t\t\t\t<td  class=\'fields\'onclick=\"updateDetails(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =",this)\" nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t -->\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<td  class=\'fields\' >&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t</td>\n\t\t\t\t<td class=\'fields\' nowrap>&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t<td  class=\'fields\' nowrap >&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\t\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<td  class=\'fields\' nowrap>&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a></td>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<td  class=\'fields\' nowrap >&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t<td  class=\'fields\' nowrap  >&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t<td  class=\'fields\' nowrap >&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td  class=\'fields\' nowrap>&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t\n\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t \t<input type=\"hidden\"  name =\"line_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  id=\"line_\" value =\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">&nbsp;<!-- GHL-CRF-0550.1 -->\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t <input type=\"hidden\"  name =\"line_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">&nbsp;\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\n\t\t\t<a href=\"javascript:viewImage_ghl(";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =");\" >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</a>\t\t\t\n\t  \t\t\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t</td>\t                 \n\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'fields\' nowrap >&nbsp;<a href=\"javascript:updateDetails(";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =")\"> &nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a></td>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t</td>\n\t\t\t\t<td  class=\'fields\' nowrap >&nbsp;";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t<td class=\'fields\'  nowrap>\n\t\t\t<input type=\"hidden\"  name =\"line_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" value =\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">&nbsp;\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t  \t<a href=\"javascript:viewImage(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</a>\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</td>\t                 \n\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t</table>\t\n\t<input type=\'hidden\' name=\'smt_ind\' id=\'smt_ind\'  id=\'smt_ind\'   value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t<input type=\'hidden\' name=\'strModuleId\' id=\'strModuleId\'  id=\'strModuleId\'   value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'  id=\'patient_id\'   value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t<input type=\'hidden\' name=\'siteSpecUploadDocAll\' id=\'siteSpecUploadDocAll\'  id=\'siteSpecUploadDocAll\'   value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t<input type = \"hidden\"   name =\"totRec\" value =\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\t\n\t<input type=\'hidden\' name=\'patView\' id=\'patView\'  id=\'patView\'   value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<!-- GHL-CRF-0550.1 -->\n\t<input type=\'hidden\' name=\'checkedRow\' id=\'checkedRow\'  id=\'checkedRow\'   value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\'hidden\' name=\'policy_no\' id=\'policy_no\'  id=\'policy_no\'   value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t<!-- GHL-CRF-0550.1 -->\n\t</form>\n\t</body>\n</html>\n\n";
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

/*
Sr No     Version        Incident			SCF/CRF								Developer Name
---------------------------------------------------------------------------------------------------------
1         V220818      	  35245        BL-RBU-GHL-CRF-0005 US001/02-
									Financial details-Upload Documents       Mohanapriya
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	String strModuleId=(String)session.getAttribute("calling_module_id");   //ADDED FOR GHL_0550_CRF
	strModuleId=(strModuleId==null?"":strModuleId);						//ADDED FOR GHL_0550_CRF
	String params = request.getQueryString();	
	
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	String strPatientId = request.getParameter("patient_id"); 
	String strepisode_id = request.getParameter("strepisodeid");
	String strvisit_id=request.getParameter("strvisitid");
	String checkedRow = (request.getParameter("checked_row"));
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	//GHL-CRF-0550.1
	String settlement_ind = (request.getParameter("settlement_ind"));
	settlement_ind=(settlement_ind==null?"":settlement_ind);
	String policy_no = (request.getParameter("policy_no"));
	policy_no=(policy_no==null?"":policy_no);
	boolean settlementIndFlag=false;
	//GHL-CRF-0550.1

            _bw.write(_wl_block7Bytes, _wl_block7);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

	int index=0;
	int cod=0;//GHL-CRF-0550.1
	String applyMode					=	new String();
	String locale						=	"";
	String facilityId					=	"";
	String loggedInUser					=	"";
	String mode							=	"";
	String isUserCanAcess				=	"";
	String bean_id						=	"";
	String bean_name					=	"";
	String modifyStatus     			=	"";
	String sStyle 						=	"";
	String authorized 					=	"";
	String disableAll					=	"";
	String visibilty					=	"";
	String modifyButton					=	"";
	String rowCount						=	"";
	String radVal			 			= 	"off";
	String initialGroupcode				=	""; 
	String initialShortDesc				=	"";
	HashMap 	blInsuranceImageList	=	null;
	BLInsuranceImageBean blInsuranceImageBean 			= 	null;
	BLInsuranceImage	blInsuranceImage = null;	
	String patView="N";
	String smtind = "";
	boolean siteSpecUploadDocAll = false;//Added V191028-Aravindh/GHL-CRF-0550
	Connection con	= null;

	sStyle 							=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	authorized 						=	request.getParameter("authorized")==null?"N":request.getParameter("authorized");
	mode							= 	request.getParameter("mode");
	patView							=	request.getParameter("pat_view")==null?"N":request.getParameter("pat_view");
	isUserCanAcess					= 	(String) session.getValue( "isUserCanAcess" );
	locale 							= 	(String)session.getAttribute("LOCALE");
	facilityId						 = (String) session.getValue( "facility_id" ) ;
	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean"; 

	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request );

	/*	
	When the Page is Loaded check any Image/Data is Present in Cache
	If Data is not Present in Cache - Get Data From Database
	*/
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	con	=	ConnectionManager.getConnection(request);
	siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550

	if(siteSpecUploadDocAll) {
		if (blInsuranceImageBean.getSize() == 0) {
			blInsuranceImageBean.loadInsuranceDBvalues(strPatientId,strModuleId,patView,strepisode_id,strvisit_id);//Added against 9994
		}
	}
	else
	{
		if (blInsuranceImageBean.getSize() == 0) {
				blInsuranceImageBean.loadInsuranceDBvalues(strPatientId);
			}
	}	
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	
	/*	If Data is Present in Cache then Cache Data will be loaded */
	blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	try
	{
		siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
	} catch(Exception ex) {
		System.err.println("Error in AddModifyInsUpldImgDtl.jsp for getting Connection: "+ex);
		ex.printStackTrace();
	}
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(patView.equals("N")){
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
} 
	else{
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
 	if(siteSpecUploadDocAll) { 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(siteSpecUploadDocAll) { 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 }else{ 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
} 
            _bw.write(_wl_block19Bytes, _wl_block19);
 
	Object ob[] =(blInsuranceImageList.keySet()).toArray();
	Arrays.sort(ob); //Added V190612 DHANANAJAY/IN70646
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;//Added V191114-Aravindh/GHL-CRF-0550
	PreparedStatement pstmt4 = null;
	ResultSet rs = null;

try{
	String sql;		
	String strPayerGroupDesc ="";
	String strPayerDesc="";
	String strPolicyDesc="";
	String strBillingGroupDesc = "";//Added V191114-Aravindh/GHL-CRF-0550

	pstmt = con.prepareStatement("select long_desc description from ar_cust_group_lang_vw 	where status is null and language_id = '"+locale+"'  and cust_group_code =?");
	//pstmt1= con.prepareStatement("select long_name description from ar_customer_lang_vw Where cust_group_code =? and language_id = '"+locale+"'  and  cust_code=?"); 
	pstmt1= con.prepareStatement("select long_name description from ar_customer_lang_vw Where language_id = '"+locale+"'  and  cust_code=?");  //Modified Against ICN:9943
	pstmt2= con.prepareStatement("select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facilityId+"' and language_id= '"+locale+"' and policy_type_code =?");
	//Added V191114-Aravindh/GHL-CRF-0550
	pstmt3 = con.prepareStatement("select long_desc blng_grp_desc from bl_blng_grp_lang_vw where blng_grp_id = ? and language_id = '"+locale+"'");
	pstmt4 = con.prepareStatement("select SETTLEMENT_IND from BL_BLNG_GRP where SHORT_DESC=?");
	//Added V191114-Aravindh/GHL-CRF-0550	
	for(index=0;index<ob.length;index++)
	{
		/*Karthik added the below code to handle Session Record retain- Unique identifier for Records added in image Page  - starts */
		String addedFromImagePage="";
		String keyFormList=""+ob[index];
		if(keyFormList.contains("^^^")){
			addedFromImagePage="^^^";
		}
		/*Karthik added the below code to handle Session Record retain- Unique identifier for Records added in image Page  - ends */
		//if(blInsuranceImageList.containsValue(""+ob[index]))
		String arr = ob[index].toString();
		//GHL-CRF-0550.1
		if(siteSpecUploadDocAll){
		String[] val = arr.split("_");
		if(settlement_ind.equals("C") || settlement_ind.equals("R") )
		settlementIndFlag = true;
		 if(settlementIndFlag || val[0].equals(policy_no))
		{  
			
		blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
		if(blInsuranceImage!=null)
		{		
			boolean strCancelChk		 =			blInsuranceImage.getCancelMod();
			String strPayerGroupCode =			blInsuranceImage.getPayerGroupCode();
			strPayerGroupCode=(strPayerGroupCode==null?"":strPayerGroupCode);
			String strPayerCode	=			    blInsuranceImage.getPayerCode();
			strPayerCode=(strPayerCode==null?"":strPayerCode);
			String strPolicyTypeCode=			blInsuranceImage.getPolicyCode();
			strPolicyTypeCode=(strPolicyTypeCode==null?"":strPolicyTypeCode);
			String strPolicyNo		=			blInsuranceImage.getPolicyNo();
			strPolicyNo=(strPolicyNo==null?"":strPolicyNo);
			String strPolicyStartdate=			blInsuranceImage.getStartDate();
			strPolicyStartdate=(strPolicyStartdate==null?"":strPolicyStartdate);
			String strPolicyExpiryDate=			blInsuranceImage.getEndDate();
			strPolicyExpiryDate=(strPolicyExpiryDate==null?"":strPolicyExpiryDate);
			//Added V191114-Aravindh/GHL-CRF-0550
			String strBillingGroup = blInsuranceImage.getBillingGroup();
			strBillingGroup = (strBillingGroup == null?"":strBillingGroup);
			String strdocType = blInsuranceImage.getDocType();
			strdocType = (strdocType==null?"":strdocType);
			String strdocRemarks = blInsuranceImage.getDocRemarks();
			strdocRemarks = (strdocRemarks==null?"":strdocRemarks);
			String strcreditAuthDate = blInsuranceImage.getCreditAuthDate();
			strcreditAuthDate = (strcreditAuthDate==null?"":strcreditAuthDate);
			String strcreditAuthNo= blInsuranceImage.getCreditAuthNo();
			strcreditAuthNo = (strcreditAuthNo==null ? "" : strcreditAuthNo);
			//Added V191114-Aravindh/GHL-CRF-0550
					
			//karthik added image loader for non image cases - starts
			if(blInsuranceImage.getImageLoaded()==false){
				//Modified V191118-Aravindh/GHL-CRF-0550/
					blInsuranceImageBean.loadInsuranceDBImage(strPatientId,strPayerGroupCode,strPayerCode,strPolicyTypeCode,strPolicyNo,strPolicyStartdate,strPolicyExpiryDate,strBillingGroup,strcreditAuthNo,strcreditAuthDate);	
							
				blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
				blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
			}
			//karthik added image loader for non image cases - ends
					
			pstmt.setString(1,strPayerGroupCode);
			rs = pstmt.executeQuery();
			if(rs.next())					
				strPayerGroupDesc=rs.getString(1);		
					else
						strPayerGroupDesc="";
					
					
					/* pstmt1.setString(1,strPayerGroupCode); 
					pstmt1.setString(2,strPayerCode); */	//Commented Against ICN:9943 
					
					pstmt1.setString(1,strPayerCode); //Modified Against ICN:9943
					rs = pstmt1.executeQuery();
					if(rs.next())
						strPayerDesc=rs.getString(1);
					else
						strPayerDesc="";
		
					pstmt2.setString(1,strPolicyTypeCode);
					rs = pstmt2.executeQuery();	
					if(rs.next())		
						strPolicyDesc=rs.getString(1);	
					else
						strPolicyDesc="";
					
					//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
					pstmt3.setString(1,strBillingGroup);
					rs = pstmt3.executeQuery();
					if(rs.next()) {
						strBillingGroupDesc = rs.getString("blng_grp_desc");
						}
						
					pstmt4.setString(1,strBillingGroup);
					rs=pstmt4.executeQuery();
							
					while(rs.next())
					{
						smtind=rs.getString(1);
					}
	
					//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550

			int len;
			len = 1;	  


            _bw.write(_wl_block20Bytes, _wl_block20);
 if(patView.equals("N"))		{
            _bw.write(_wl_block21Bytes, _wl_block21);
	if(strCancelChk==true)
					 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
				else 
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strBillingGroup));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strBillingGroup));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strBillingGroup));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
} 
				else if(patView.equals("Y"))		{ 
            _bw.write(_wl_block31Bytes, _wl_block31);

					if(strCancelChk==true)
						 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
					else 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strBillingGroup));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
			else {
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
 } 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strPayerDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPolicyDesc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyNo));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyStartdate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyExpiryDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strcreditAuthNo));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strcreditAuthDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strdocRemarks));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
			 if(smtind.equals("X")){
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(""+policy_no+"_"+cod));
            _bw.write(_wl_block44Bytes, _wl_block44);
cod++;}
			 else{ //Other Billing Group
		
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(index));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf("^^^1110"));
            _bw.write(_wl_block46Bytes, _wl_block46);
}	
		if(blInsuranceImage.getImageLoaded())
		{
		
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
} 
            _bw.write(_wl_block50Bytes, _wl_block50);

		}	
		}
		}
		//GHL-CRF-0550.1
		else{ ////Added Against Except GHL Site Ends
		blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
		if(blInsuranceImage!=null)
		{		
			boolean strCancelChk		 =			blInsuranceImage.getCancelMod();
			String strPayerGroupCode =			blInsuranceImage.getPayerGroupCode();
			strPayerGroupCode=(strPayerGroupCode==null?"":strPayerGroupCode);
			String strPayerCode	=			    blInsuranceImage.getPayerCode();
			strPayerCode=(strPayerCode==null?"":strPayerCode);
			String strPolicyTypeCode=			blInsuranceImage.getPolicyCode();
			strPolicyTypeCode=(strPolicyTypeCode==null?"":strPolicyTypeCode);
			String strPolicyNo		=			blInsuranceImage.getPolicyNo();
			strPolicyNo=(strPolicyNo==null?"":strPolicyNo);
			String strPolicyStartdate=			blInsuranceImage.getStartDate();
			strPolicyStartdate=(strPolicyStartdate==null?"":strPolicyStartdate);
			String strPolicyExpiryDate=			blInsuranceImage.getEndDate();
			strPolicyExpiryDate=(strPolicyExpiryDate==null?"":strPolicyExpiryDate);
			//Added V191114-Aravindh/GHL-CRF-0550
			String strBillingGroup = blInsuranceImage.getBillingGroup();
			strBillingGroup = (strBillingGroup == null?"":strBillingGroup);
			String strdocType = blInsuranceImage.getDocType();
			strdocType = (strdocType==null?"":strdocType);
			String strdocRemarks = blInsuranceImage.getDocRemarks();
			strdocRemarks = (strdocRemarks==null?"":strdocRemarks);
			String strcreditAuthDate = blInsuranceImage.getCreditAuthDate();
			strcreditAuthDate = (strcreditAuthDate==null?"":strcreditAuthDate);
			String strcreditAuthNo= blInsuranceImage.getCreditAuthNo();
			strcreditAuthNo = (strcreditAuthNo==null ? "" : strcreditAuthNo);
			//Added V191114-Aravindh/GHL-CRF-0550
					
			//karthik added image loader for non image cases - starts
			if(blInsuranceImage.getImageLoaded()==false){
					blInsuranceImageBean.loadInsuranceDBImage(strPatientId,strPayerGroupCode,strPayerCode,strPolicyTypeCode,strPolicyNo,strPolicyStartdate,strPolicyExpiryDate);	
							
				blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
				blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
			}
			//karthik added image loader for non image cases - ends
					
			pstmt.setString(1,strPayerGroupCode);
			rs = pstmt.executeQuery();
			if(rs.next())					
				strPayerGroupDesc=rs.getString(1);		
					else
						strPayerGroupDesc="";
								
					pstmt1.setString(1,strPayerCode); //Modified Against ICN:9943
					rs = pstmt1.executeQuery();
					if(rs.next())
						strPayerDesc=rs.getString(1);
					else
						strPayerDesc="";
		
					pstmt2.setString(1,strPolicyTypeCode);
					rs = pstmt2.executeQuery();	
					if(rs.next())		
						strPolicyDesc=rs.getString(1);	
					else
						strPolicyDesc="";
					pstmt3.setString(1,strBillingGroup);
					rs = pstmt3.executeQuery();
					if(rs.next()) {
						strBillingGroupDesc = rs.getString("blng_grp_desc");
						}
						
					pstmt4.setString(1,strBillingGroup);
					rs=pstmt4.executeQuery();
							
					while(rs.next())
					{
						smtind=rs.getString(1);
					}	

			int len;
			len = 1;	  


            _bw.write(_wl_block20Bytes, _wl_block20);
 if(patView.equals("N"))		{
            _bw.write(_wl_block21Bytes, _wl_block21);
	if(strCancelChk==true)
					 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
				else 
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(index));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block53Bytes, _wl_block53);
} 
				else if(patView.equals("Y"))		{ 
            _bw.write(_wl_block31Bytes, _wl_block31);

					if(strCancelChk==true)
						 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
					else 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
					
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
			else {
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strPayerGroupDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
 } 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strPayerDesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPolicyDesc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyNo));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyStartdate));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyExpiryDate));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(index));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(""+strPayerGroupCode+strPayerCode+strPolicyTypeCode+strPolicyNo+strPolicyStartdate+strPolicyExpiryDate+addedFromImagePage));
            _bw.write(_wl_block57Bytes, _wl_block57);
		
			if(blInsuranceImage.getImageLoaded())
			{
			
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(index));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

			} 
            _bw.write(_wl_block60Bytes, _wl_block60);

		}
		} //Added Against Except GHL Site Ends
	}
}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			if (rs != null)   rs.close();
			if(pstmt!=null)		pstmt.close(); 
			if(pstmt1!=null)	pstmt1.close();
			if(pstmt2!=null)	pstmt2.close();
			if(pstmt4!=null)	pstmt4.close();
			ConnectionManager.returnConnection(con, request);	
		}
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(smtind));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(siteSpecUploadDocAll));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(index));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patView));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(checkedRow));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(policy_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroupId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_START_DATE.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EXPIRY_DATE.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreditAuthNo.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Date.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Show_Documents.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Show_Image.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ViewDocument.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.View_Image.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
