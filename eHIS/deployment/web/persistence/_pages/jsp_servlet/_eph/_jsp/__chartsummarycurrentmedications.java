package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.*;
import ePH.Common.*;
import eOR.*;
import org.apache.commons.codec.binary.Base64;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarycurrentmedications extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ChartSummaryCurrentMedications.jsp", 1709120641939L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\" src=\"../js/ChartSummaryCurrentMedications.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t\t<style>\n\t\t\tTH {\n\t\t\t   BACKGROUND-COLOR: #8A8A8A;\n\t\t\t   FONT-SIZE:9pt; \n\t\t\t   FONT-WEIGHT: bolder;\n\t\t\t}\n\n\t\t</style>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'ChartSummaryCurrentMedicationsForm\' id=\'ChartSummaryCurrentMedicationsForm\' method=\'post\'>\n\t\t\t<table cellpadding=0 cellspacing=0 border=1 width=\'100%\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t   <table cellpadding=0 cellspacing=0 border=0 width=\'100%\'>\n\t\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t<!--IN035950 Starts-->\n\t\t\t\t\t\t\t<!--<th align=\"left\"><font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>-->\n\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t\t<!--IN035950 Ends-->\n\t\t\t\t\t\t   </tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=1 width=\'100%\'>\n\t\t\t\t\t\t   <tr>\n\t\t\t\t\t\t\t<!--IN035950 Starts-->\n\t\t\t\t\t\t\t<!--<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" width=\"75%\"><font size=1>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" width=\"25%\"><font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>-->\n\t\t\t\t\t\t\t<td class=\"gridData\" width=\"75%\"><font size=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\n\t\t\t\t\t\t\t<td class=\"gridData\" width=\"25%\"><font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<td  class=\"gridData\" width=\"3%\" style=\"background-color:";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" title=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"renewYN";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"renewYN";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" value=\"\" onclick=\'setSelectedRenewOrder(this,\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");checkDuplicate(this,\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" );\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t<td  class=\"gridData\" width=\"5%\" style=\"background-color:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"renewYN";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" value=\"\" style=\'display:none;\' >\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t<img style=\'background-color:white;height:10px;width:10px;\' src=\'../../eCommon/images/enabled.gif\'></img>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t<img style=\'background-color:white;height:10px;width:10px;visibility:hidden\' src=\'../../eCommon/images/enabled.gif\'></img>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<td  class=\"gridData\" width=\"3%\">\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"renewYN";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"\" style=\'display:none;\' >\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<!--Added for Bru-HIMS-CRF-400-End -->\n\t\t\t\t\t\t\t<!--IN035950 Ends-->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\'100%\'>\n\t\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t\t<!--IN035950 Starts-->\n\t\t\t\t\t\t\t\t<!--<th align=\"left\"><font size=1>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</th>-->\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<!--\t<th align=\"left\"><font size=1>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th> -->\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<!--\t<td class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><font size=1>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td> -->\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t<th align=\"left\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</th><!-- IN040966 -->\n\t\t\t\t\t\t\t\t<!--IN035950 Ends-->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t   </table>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=1 width=\'100%\'>\n\t\t\t\t\t\t   <tr>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- <td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td><!-- IN040966 Start-->\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"gridData\" width=\"75%\"><font size=1>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"gridData\" width=\"25%\"><font size=1>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"renewYN";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" value=\"\" style=\'display:none;\' >\n\t\t\t\t\t\t\t\t</td>    <!-- IN040966 End-->\n\t\t\t\t\t\t   </tr>\n\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'OrderId_LineNum";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'OrderId_LineNum";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =",";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'drug_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'drug_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'IV_Prep_yn";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'IV_Prep_yn";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'/>\n\t\t\t<!--  27788 Start. -->\n\t\t\t<input type=\'hidden\' name=\'prefStyleSheet\' id=\'prefStyleSheet\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'content_ID\' id=\'content_ID\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'ReqDb\' id=\'ReqDb\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'enc_id1\' id=\'enc_id1\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'ord_id\' id=\'ord_id\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'/>\n\t\t\t<!-- 27788 End. -->\n\t\t</form>\n\t</body>\n\t<script>\n\t\tdisableDuplicate(); \n\t</script>\n</html>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );
	
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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
14/12/2012		IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
											more appealing. Keeping the display of information more clear and visible.
14/12/2012		IN040966		Chowminya   Order Type name and Order ID of medication doesn?t have background as grey color
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

07/03/2022		27788			Ramesh Goli		07/03/2022		RAMESH G    	MMS-ME-SCF-0067
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	//[IN035950] Starts
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	//27788 Start.
	String prefStyleSheet 	= "";
	String content_ID 		= "";
	String patient_id 		= "";
	String encounter_id	    = "";
	String called_from	    = "";
	String ReqDb	    	= "";
	String enc_id1	    	= "";
	String p_called_from_widget	    = "";
	String ord_id			= "";
	String title = request.getParameter("title");
	String compressed =request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed");
	if("Y".equals(compressed)){		
		patient_id		=	new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		encounter_id	    =	new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));		
	}else{		
		patient_id		=	request.getParameter("patient_id");
		encounter_id	    =	request.getParameter("encounter_id");				
	}
	prefStyleSheet = request.getParameter("prefStyle");//Nijitha
	content_ID = request.getParameter("content_ID")==null?"": request.getParameter("content_ID");	
	called_from	    =	request.getParameter("called_from")==null?"":request.getParameter("called_from"); //Added for MMS-DM-CRF-115.4
	ReqDb	    =	request.getParameter("RepDb")==null?"":request.getParameter("RepDb"); //Added for MMS-DM-CRF-115.4
	enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
	p_called_from_widget	    =	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//&p_called_from_widget=CURRENT_MEDICATION
	
	ord_id	=	request.getParameter("ord_id")==null?"":request.getParameter("ord_id");
	
	//27788 End.
	
	String sessionStyle = "";
	if(prefStyleSheet!=null && !prefStyleSheet.equals("")){
		sessionStyle=prefStyleSheet;
	}//[IN035950] Ends
	String facility_id=(String)session.getValue( "facility_id" );//Added for Bru-HIMS-CRF-400
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale = (String) session.getAttribute("LOCALE");
	
	String	bean_id			=	"ChartSummaryCurrentMedicationsBean" ;
	String	bean_name		=	"ePH.ChartSummaryCurrentMedicationsBean";
	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
	ChartSummaryCurrentMedicationsBean bean = (ChartSummaryCurrentMedicationsBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	if(!p_called_from_widget.equals("CURRENT_MEDICATION"))
		orbean.clearRenewOrders();
	HashMap hmRenewOrders = orbean.getRenewOrderIds();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sessionStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

				String  Order_type_legend="",alt_drug_duration="";
				String drug_name = "",	drug_duration = "",IV_Prep_yn="",order_id="",alternate_order_id="";
				String classValue = "",iv_drug_fluid_continuous_lg="",iv_drug_fluid_intermittent_lg="",iv_without_additives_lg="",drug_status="",allow_renew_from_chart_summ_yn="",single_cont_renew_hrs_behind="",single_cont_renew_hrs_ahead="",renew_yn="", drug_code="";//drug_status,allow_renew_from_chart_summ_yn,single_cont_renew_hrs_behind,single_cont_renew_hrs_ahead Added for Bru-HIMS-CRF-400
				String or_order_line = "", orderKey="", renewChecked="";
				int count=1;
				int k=0;
				//Added for Bru-HIMS-CRF-400-Start
				HashMap PeriodChk=bean.getPeriodChk(facility_id);
				if(PeriodChk.size()>0){
					allow_renew_from_chart_summ_yn=(String)PeriodChk.get("ALLOW_RENEW_FROM_CHART_SUMM_YN");
					single_cont_renew_hrs_behind=(String)PeriodChk.get("SINGLE_CONT_RENEW_HRS_BEHIND");
					single_cont_renew_hrs_ahead=(String)PeriodChk.get("SINGLE_CONT_RENEW_HRS_AHEAD");
				}//Added for Bru-HIMS-CRF-400-End
				HashMap Order_Group		=	new HashMap();
				ArrayList legends	=	new ArrayList();			
				
				Order_Group		=	bean.getCurrentMedicationDetails(patient_id,ord_id,allow_renew_from_chart_summ_yn,single_cont_renew_hrs_behind,single_cont_renew_hrs_ahead,called_from,ReqDb,enc_id1);//allow_renew_from_chart_summ_yn,single_cont_renew_hrs_behind,single_cont_renew_hrs_ahead Added for Bru-HIMS-CRF-400//called_from,enc_id1,ReqDb added for MMS-DM-CRF-115.4

				legends							=	bean.getIVLegends();
				if(legends.size()>0){
					iv_drug_fluid_continuous_lg		=	(String)legends.get(0);
					iv_drug_fluid_intermittent_lg	=	(String)legends.get(1);
					iv_without_additives_lg			=	(String)legends.get(2);
				}
				if (Order_Group.get("count") != null && (!Order_Group.get("count").toString().equals(""))){
					count	=	Integer.parseInt(Order_Group.get("count").toString());
				}
				for(int i=1;i<=(count-1);i++){
				   k++;
				   order_id			=	(String)Order_Group.get("order_id"+i);
				   drug_name		=	(String)Order_Group.get("drug_name"+i);
				   drug_duration	=	(String)Order_Group.get("drug_duration"+i);
				   IV_Prep_yn		=	(String)Order_Group.get("IV_Prep_yn"+i);
				   renew_yn			=   (String)Order_Group.get("RENEW_YN"+i);
				   or_order_line 	= (String)Order_Group.get("or_order_line"+i);
				   drug_code 		= (String)Order_Group.get("DRUG_CODE"+i);
				   renewChecked="";
				   if(hmRenewOrders!=null && hmRenewOrders.containsKey(drug_code)){
					   orderKey = (String)hmRenewOrders.get(drug_code);
					   if(orderKey.equals(order_id+","+or_order_line))
						   renewChecked = "checked";
				   }
				   if(IV_Prep_yn.equals(""))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NormalRx.label","ph_labels");
				   else if(IV_Prep_yn.equals("1"))
					   Order_type_legend	=	iv_drug_fluid_continuous_lg;
				   else if(IV_Prep_yn.equals("2"))
					   Order_type_legend	=	iv_drug_fluid_continuous_lg;
				   else if(IV_Prep_yn.equals("3"))
					   Order_type_legend	=	iv_drug_fluid_intermittent_lg;
				   else if(IV_Prep_yn.equals("4"))
					   Order_type_legend	=	iv_drug_fluid_intermittent_lg;
				   else if(IV_Prep_yn.equals("5"))
					   Order_type_legend	=	iv_without_additives_lg;
				   else if(IV_Prep_yn.equals("6"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompoundingRx.label","ph_labels");
				   else if(IV_Prep_yn.equals("7"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNStandardRegimen.label","ph_labels");
				   else if(IV_Prep_yn.equals("8"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNNONStandardRegimen.label","ph_labels");
				   else if(IV_Prep_yn.equals("9"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyRegimen.label","ph_labels");
				   else if(IV_Prep_yn.equals("0"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyRegimen.label","ph_labels");

					if ( k % 2 == 0 )
						classValue = "QRYODD" ;
					else
						classValue = "QRYEVEN" ;

				   if(IV_Prep_yn.equals("")){

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_duration));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(drug_duration));
            _bw.write(_wl_block19Bytes, _wl_block19);

							if( renew_yn.equals("Y") && !called_from.equals("REROUTE")){//Added for Bru-HIMS-CRF-400-Start 
								drug_status = "#990000";
								if(!p_called_from_widget.equals("CURRENT_MEDICATION")){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(drug_status));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(renewChecked));
            _bw.write(_wl_block28Bytes, _wl_block28);

								}
								else{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(drug_status));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);

									if(renewChecked.equals("checked")){

            _bw.write(_wl_block32Bytes, _wl_block32);

									}
									else{

            _bw.write(_wl_block33Bytes, _wl_block33);

									}

            _bw.write(_wl_block34Bytes, _wl_block34);

								}
							}
							else{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);

							}

            _bw.write(_wl_block37Bytes, _wl_block37);

				}
				else{
					if(!(order_id.equals(alternate_order_id))){

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block39Bytes, _wl_block39);

								//if(sStyle.equals(prefStyleSheet) ){//Commentted - Start  IN040966 

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block41Bytes, _wl_block41);

							//	}
							//	else{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block44Bytes, _wl_block44);

							//	}//Commentted - end  IN040966

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(Order_type_legend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block46Bytes, _wl_block46);

							alt_drug_duration	=	drug_duration;
						}
						else{
							//alt_drug_duration	=	"&nbsp";
						}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(alt_drug_duration));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alt_drug_duration));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);

						alternate_order_id	=	order_id;
					}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(or_order_line));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(IV_Prep_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);

				}//IN035950 Starts
				if(k==0){
					out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
				}
				//IN035950 Ends

            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prefStyleSheet));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(ReqDb));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(enc_id1));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(ord_id));
            _bw.write(_wl_block72Bytes, _wl_block72);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChartSummaryCurrentMedications.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RenewOrder.label", java.lang.String .class,"key"));
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
