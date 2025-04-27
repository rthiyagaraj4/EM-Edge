package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __compoundingoverridereason extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/CompoundingOverRideReason.jsp", 1732679990641L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<!-- Modified for IN:072715  -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionComp.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/PhMessages.js\"></script>\n\t\t<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t\t<title>Override Reason</title>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n\t\t<form name=\"DispQueueMgmtHoldReason\" id=\"DispQueueMgmtHoldReason\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"102%\" align=\"center\" border=\"0\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<tr><marquee  bgcolor=\"#CC0000\" scrollamount=\"3\"><font color=\"white\" style=\"font-weight:bold\" size=1>Allergic Description:&nbsp;&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></marquee></tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<th align=\"left\" class=\"COLUMNHEADERCENTER\">&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t<!-- Added for IN:072715 START --> \n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"allergy_remarks_code\" id=\"allergy_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'AO\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.allergy,\'allergy\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </select>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t\t\t\t\t<td align=\"right\"><label onClick=\"showAllergyDetails(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\" style=\"cursor:pointer;color:blue;font-size:9\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</label>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"allergy\" onKeyPress=\"return checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</textarea>&nbsp;<!-- Modified for IN:073485 START -->\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"><!-- Modified for IN:073485 START -->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t</table>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"102%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n\t\t\t\t<tr><td colspan=\"2\"></td></tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\"><marquee bgcolor=\"#FFCC66\" scrollamount=\"3\"><font color=\"black\" style=\"font-weight:bold\" size=1>Daily Dose: Maximum-";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =",Minimum-";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unit Dose: Maximum-";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></marquee></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<th align=\"left\" class=\"data\">&nbsp;Beyond Dose Limit Override Reason&nbsp;&nbsp;</th>\n\t\t\t\t\t<!-- Added for IN:072715 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"dose_remarks_code\" id=\"dose_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'BD\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.exceed_dose,\'exceed_dose\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t\t\t\t\t<td align=\"left\" ><label onClick=\"showMonoGraph(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\"  style=\"cursor:pointer;color:blue;font-size:9\">Overdose Details</label>&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t<!-- modified for ML-MMOH-CRF-1408-->\n\t\t\t\t</tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"exceed_dose\" onKeyPress=\"return checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</textarea>&nbsp;\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\">\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</td>\n</tr>\n<tr><td colspan=\"2\"></td></tr>\n<tr><td colspan=\"2\"></td></tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<tr>\n\t<td colspan=\"2\"><marquee bgcolor=\"#6699FF\" scrollamount=\"3\"><font color=\"black\" style=\"font-weight:bold\" size=1>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font></marquee></td>\n</tr>\n<tr>\n\t<th align=\"left\" class=\"data\">&nbsp;Duplicate Drug Override Reason&nbsp;&nbsp;</th>\n\t<!-- Added for IN:072715 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<td class=\"fields\">&nbsp;\n\t\t\t\t\t<select name=\"dup_drug_remarks_code\" id=\"dup_drug_remarks_code\"  onChange=\"checkOverrideRemarks(this,\'DP\',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.dup_drug,\'dup_drug\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<!-- Added for IN:072715 END -->\n\t<td align=\"left\"><label onClick=\"callCurrentMedication(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\" style=\"cursor:pointer;color:blue;font-size:9\">Duplicate Drugs</label>&nbsp;&nbsp;&nbsp;</td>\n</tr>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n<tr>\n\t<td align=\"left\" colspan=\"2\">&nbsp;<textarea rows=\"3\" cols=\"80\" name=\"dup_drug\" onKeyPress=\"return checkMaxLimit(this,255);\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t</td>\n</tr>\n<tr><td colspan=\"2\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n<tr>\n\t\t\t<td align=\"center\" colspan=\"2\">\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t<input type=\"button\" value=\" Close \" class=\"button\" onClick=\"window.close()\"></td>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<input type=\"button\" value=\" OK \" class=\"button\" onClick=\"validate(document.DispQueueMgmtHoldReason)\"></td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t<input type=\"hidden\" name=\"allergy_yn\" id=\"allergy_yn\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<input type=\"hidden\" name=\"current_rx\" id=\"current_rx\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type=\"hidden\" name=\"limit_ind\" id=\"limit_ind\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<input type=\"hidden\" name=\"srl_no\" id=\"srl_no\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t</form>\n\t\t<!-- Added for IN:072715 start -->\n\t\t\n\t\t<script type=\"text/javascript\">\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\tif(document.DispQueueMgmtHoldReason.allergy!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.allergy.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\tif(document.DispQueueMgmtHoldReason.exceed_dose!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.exceed_dose.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\tif(document.DispQueueMgmtHoldReason.dup_drug!=null)\n\t\t\tdocument.DispQueueMgmtHoldReason.dup_drug.readOnly = true;\n \t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t<!-- Added for IN:072715 end -->\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
	
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
        response.setHeader("Content-Type", "text/html; ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
20/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
25/06/2020  	IN:072715       	Haribabu  	25/06/2020     Manickavasagam     		MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order        
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{
			String generic_id		= CommonBean.checkForNull(request.getParameter("gen_id"));
			String generic_name		= CommonBean.checkForNull(request.getParameter("gen_name"));

			String patient_id		= CommonBean.checkForNull(request.getParameter("pat_id"));
			String encounter_id		= CommonBean.checkForNull(request.getParameter("enc_id"));
			String drug_desc		= CommonBean.checkForNull(request.getParameter("drug_desc"));
			String mono_graph		= CommonBean.checkForNull(request.getParameter("mono_graph"));
			String daily_dose		= CommonBean.checkForNull(request.getParameter("daily_dose"));
			String unit_dose		= CommonBean.checkForNull(request.getParameter("unit_dose"));
			String min_daily_dose	= CommonBean.checkForNull(request.getParameter("min_daily_dose"));
			String min_unit_dose	= CommonBean.checkForNull(request.getParameter("min_unit_dose")); 
			String allergy_yn		= CommonBean.checkForNull(request.getParameter("allergy_yn"));
			String current_rx		= CommonBean.checkForNull(request.getParameter("current_rx"));
			String limit_ind		= CommonBean.checkForNull(request.getParameter("limit_ind"));
			String drug_code		= CommonBean.checkForNull(request.getParameter("drug_code"));
			String srl_no			= CommonBean.checkForNull(request.getParameter("srl_no"));
			String dosage_unit		= CommonBean.checkForNull(request.getParameter("dosage_unit"));
			String order_id		    = CommonBean.checkForNull(request.getParameter("order_id"));
			String order_line_num	= CommonBean.checkForNull(request.getParameter("order_line_num"));
			String drug_db_allergy_flag		= CommonBean.checkForNull(request.getParameter("drug_db_allergy_flag"));
			String drug_db_duptherapy_flag  = CommonBean.checkForNull(request.getParameter("drug_db_duptherapy_flag"));
			String drug_db_interface_yn		= CommonBean.checkForNull(request.getParameter("drug_db_interface_yn"));
			//added for ML-MMOH-CRF-1408 - start
			String max_daily_ceiling_dose   = CommonBean.checkForNull(request.getParameter("max_daily_celing_dose"));
			String min_daily_ceiling_dose   = CommonBean.checkForNull(request.getParameter("min_daily_ceiling_dose"));
			String max_unit_ceiling_dose    = CommonBean.checkForNull(request.getParameter("max_unit_ceiling_dose"));
			String min_unit_ceiling_dose   = CommonBean.checkForNull(request.getParameter("min_unit_ceiling_dose"));
			String dose_unit_desc   = CommonBean.checkForNull(request.getParameter("dose_unit_desc"));
			String dose_unit_desc1   = CommonBean.checkForNull(request.getParameter("dose_unit_desc1"));
			String dosage_std		 = CommonBean.checkForNull(request.getParameter("dosage_std"));
			String drug_db_dosecheck_yn = CommonBean.checkForNull(request.getParameter("drug_db_dosecheck_yn")); //ML-MMOH-CRF-1408
System.err.println("max_daily_ceiling_dose==53=>"+max_daily_ceiling_dose);
			//added for ML-MMOH-CRF-1408 - end
			//Added for IN:072715 start
			String allergy_override_select	= CommonBean.checkForNull(request.getParameter("allergy_remarks_code"));
			String dose_override_select	= CommonBean.checkForNull(request.getParameter("dose_remarks_code"));
			String dup_drug_override_select	= CommonBean.checkForNull(request.getParameter("currentrx_remarks_code"));
			//Added for IN:072715 end
			String allergy			= "";
			String exceed_dose		= "";
			String dup_drug			= "";
			HashMap drugReasons     = new HashMap();
			String allergy_override_reason="";
			String dosage_limit_override_reason="";
			String duplicate_drug_override_reason="";
			String allergy_flag="";
			String doselimit_flag="";
			String currentrx_flag="";

			if (request.getParameter("allergy") != null){
				allergy	= java.net.URLDecoder.decode(request.getParameter("allergy")==null?"":request.getParameter("allergy"),"UTF-8");
			}

			if (request.getParameter("exceed_dose") != null){
				exceed_dose	= java.net.URLDecoder.decode(request.getParameter("exceed_dose")==null?"":request.getParameter("exceed_dose"),"UTF-8");
			}

			if (request.getParameter("dup_drug") != null){
				dup_drug =java.net.URLDecoder.decode(request.getParameter("dup_drug")==null?"":request.getParameter("dup_drug"),"UTF-8");
			}

			String bean_id			= "IVPrescriptionBean"+patient_id+encounter_id;
			String bean_name		= "ePH.IVPrescriptionBean";
			IVPrescriptionBean bean = (IVPrescriptionBean)
			getBeanObject(bean_id,bean_name ,request);

			String pr_bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
			String pr_bean_name				= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 pr_bean		= (PrescriptionBean_1)getBeanObject( pr_bean_id,pr_bean_name, request  ) ;

			String or_bean_name				= "eOR.OrderEntryBean";
			String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name, request  ) ;
			String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

			//Added for IN:072715 START
			Connection con			= null; 
				con				= ConnectionManager.getConnection(request);
			boolean over_ride_remarks_select_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");
			if(con != null)
				ConnectionManager.returnConnection(con,request);
			String sql="select REASON_CODE,REASON_DESC from PH_MEDN_TRN_REASON where APPL_TRN_TYPE=? AND EFF_STATUS='E'";
			ArrayList dose_override_params= new ArrayList();
			dose_override_params.add("BD");
			ArrayList allergy_override_params= new ArrayList();
			allergy_override_params.add("AO");
			ArrayList dup_drug_override_params= new ArrayList();
			dup_drug_override_params.add("DP");
			
			//Added for IN:072715 END
			
			if(!order_id.equals("") && !order_line_num.equals("")){
				drugReasons=bean.getDrugReasons(order_id,order_line_num,"");
				allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
				if(allergy_override_reason == null || !allergy.equals("")) allergy_override_reason="";
				dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
				if(dosage_limit_override_reason == null) dosage_limit_override_reason="";
				duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");
				if((duplicate_drug_override_reason == null) || !dup_drug.equals("")) duplicate_drug_override_reason="";
				/*if(allergy_yn.equals("Y") && !allergy_override_reason.equals("")){
					allergy_flag="disabled";
					allergy_yn="Y";
				}*/
				if(!dosage_limit_override_reason.equals("")) {
					doselimit_flag="disabled";
					//limit_ind="Y";
				}
				/*if(current_rx.equals("Y") && !duplicate_drug_override_reason.equals("")){
					currentrx_flag="disabled";
				 	current_rx	= "Y";
				}*/
			}				
			String called_from		=	orbean.getCalledFromFunction();
			String disable_status	=	"";
			if(called_from!=null && called_from.equals("RENEW_ORDER")) {
				disable_status		=	"disabled";
			}

			if (request.getParameter("allergy") == null && request.getParameter("exceed_dose") == null && request.getParameter("dup_drug") == null) {
				ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
				for(int j=0;j<prescriptionDetails.size();j++){
					HashMap ext_drugData	=(HashMap) prescriptionDetails.get(j);
					String ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
					String ext_srl_no		=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
						if(ext_drugData.containsKey("ALLERGY_REMARKS")) {
							allergy		=	java.net.URLDecoder.decode((String)ext_drugData.get("ALLERGY_REMARKS"));
						}
						if(ext_drugData.containsKey("DOSE_REMARKS")) {
							exceed_dose	=	java.net.URLDecoder.decode((String)ext_drugData.get("DOSE_REMARKS"));
						}

						if(ext_drugData.containsKey("CURRENTRX_REMARKS")) {
							dup_drug	=	java.net.URLDecoder.decode((String)ext_drugData.get("CURRENTRX_REMARKS"));
						}
						//Added for IN:072715 start
						if(allergy_override_select.equals("")){
							allergy_override_select			=java.net.URLDecoder.decode( (String)ext_drugData.get("ALLERGY_REMARKS_CODE"));	  		
						}
						if(dose_override_select.equals("")){
							dose_override_select			=java.net.URLDecoder.decode( (String)ext_drugData.get("DOSE_REMARKS_CODE"));	  		
						}
						if(dup_drug_override_select.equals("")){
							dup_drug_override_select			=java.net.URLDecoder.decode( (String)ext_drugData.get("CURRENTRX_REMARKS_CODE"));	  		
						}
						//Added for IN:072715  end
						break;
					}
				}
			}

            _bw.write(_wl_block9Bytes, _wl_block9);

			//if(drug_db_allergy_flag.equals("N") && (allergy_yn.equals("Y") || !allergy_override_reason.equals(""))){
			if(allergy_yn.equals("Y")){
				HashMap details = null;
				String allergic_indications	= "";
				ArrayList allergyDetails = presBean.populateAllergyDetails(generic_id,patient_id);
				if((allergyDetails==null || allergyDetails.size()==0 )){
					String ATC_allergy = presBean.getATCAllergyAlertGeneric(patient_id,generic_id);
					if(ATC_allergy!=null && !ATC_allergy.equals("0")){
						generic_id = ATC_allergy.substring(0,ATC_allergy.indexOf('~'));
						generic_name = ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
						allergyDetails = presBean.populateAllergyDetails(generic_id,patient_id);
					}
				}
				 for(int i=0;i<allergyDetails.size();i++){
					details=(HashMap) allergyDetails.get(i);
					if(!allergic_indications.equals(""))
						allergic_indications =  allergic_indications+" - ";
					allergic_indications = allergic_indications+(String)details.get("ALLERGIC_INDICATIONS"); //added allergic_indications+ for IN24641 --29/10/2010-- priya
				 }
				if(!allergic_indications.equals("") || !allergy_override_reason.equals("") || !allergy.equals("")) {

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(allergic_indications));
            _bw.write(_wl_block11Bytes, _wl_block11);

				}

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.getOverrideListValues(sql,allergy_override_params,allergy_override_select) ));
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(generic_name,"UTF-8")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_desc,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(allergy_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(allergy));
            out.print( String.valueOf(allergy_override_reason));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
					if(called_from!=null && !called_from.equals("RENEW_ORDER")) { 

            _bw.write(_wl_block24Bytes, _wl_block24);

					}	

            _bw.write(_wl_block25Bytes, _wl_block25);
			}
			if( (limit_ind.equals("N") || !dosage_limit_override_reason.equals(""))) { // changed drug_db_interface_yn to drug_db_dosecheck_yn for ML-MMOH-CRF-1408//drug_db_dosecheck_yn.equals("N") && removed for mms-dm-crf-0209.1

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.getOverrideListValues(sql,dose_override_params,dose_override_select) ));
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mono_graph));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(daily_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(unit_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(min_daily_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(min_unit_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dosage_unit));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dosage_std));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_daily_ceiling_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(min_daily_ceiling_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(max_unit_ceiling_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(min_unit_ceiling_dose));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dose_unit_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dose_unit_desc1));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disable_status));
            out.print( String.valueOf(doselimit_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(exceed_dose));
            out.print( String.valueOf(dosage_limit_override_reason));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(called_from!=null && !called_from.equals("RENEW_ORDER")) { 
            _bw.write(_wl_block34Bytes, _wl_block34);
	}	
            _bw.write(_wl_block35Bytes, _wl_block35);
 }
	
	if(drug_db_duptherapy_flag.equals("N") && (current_rx.equals("Y") || !duplicate_drug_override_reason.equals(""))) {

	  //  out.println("in side line 205");		

		ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
		HashMap  dup_info		=	null;
		String dup_drug_info	=	"";

		if(curr_info.size()>=1) {
			dup_info	  =	(HashMap)curr_info.get(0);
			dup_drug_info = "Patient is Currently On this Medication till :"+dup_info.get("end_date")+";\n";
			dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
		}

		if(!dup_drug_info.equals("") || !duplicate_drug_override_reason.equals("") || !dup_drug.equals("") || current_rx.equals("Y")) {

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dup_drug_info));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(over_ride_remarks_select_appl){ 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.getOverrideListValues(sql,dup_drug_override_params,dup_drug_override_select) ));
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(generic_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
	}	
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disable_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(currentrx_flag));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dup_drug));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(duplicate_drug_override_reason));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(called_from!=null  && !called_from.equals("RENEW_ORDER")) { 
            _bw.write(_wl_block34Bytes, _wl_block34);
	}	
            _bw.write(_wl_block43Bytes, _wl_block43);
 } 
            _bw.write(_wl_block44Bytes, _wl_block44);
 if(called_from!=null && called_from.equals("RENEW_ORDER")) { 
            _bw.write(_wl_block45Bytes, _wl_block45);
	} else {	
            _bw.write(_wl_block46Bytes, _wl_block46);
	}	

				putObjectInBean(bean_id,bean,request);
				putObjectInBean(or_bean_id,orbean,request);
				putObjectInBean(pr_bean_id,pr_bean,request);
				putObjectInBean(presBean_id,presBean,request);

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(allergy_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(current_rx));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(limit_ind));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(over_ride_remarks_select_appl){
            _bw.write(_wl_block55Bytes, _wl_block55);
if(!(allergy_override_select.equals("OTHR"))){
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
if(!(dose_override_select.equals("OTHR"))){
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
if(!(dup_drug_override_select.equals("OTHR"))){
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block59Bytes, _wl_block59);


}catch(Exception exception) {
       exception.printStackTrace();
 }

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergicOverrideReason.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergicDetails.label", java.lang.String .class,"key"));
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
}
