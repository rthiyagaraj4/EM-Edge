package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import org.json.simple.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __interfacedvitalsigndetals extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/InterfacedVitalSignDetals.jsp", 1742453906686L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCA/js/VitalSign.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<style>\n\t\t//IN072777 Strt.\n\t\t.overFlowDiv{\n\t\t\twidth:100%;\n\t\t\theight:100px;\n\t\t\tbackground-color:White;\n\t\t\toverflow: auto;\n\t\t\toverflow-y: scroll;\n\t\t\tmax-width:100%;\n\t\t\tmax-height:100px;\n\t\t\tborder:none;\n\t\t}\n\t\t//IN072777 End.\n\t\t</style>\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    <body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\t\t\n\t\t<form name = \'VitalSignResultFormDetals\'  method=\"post\" target=\"messageFrame\">\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t <fieldset style=\"border:1px solid Greay;\">\n\t\t\t\t\t\t\t<legend>Chart Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" id=\'select_all\' name=\'select_all\' id=\'select_all\' onClick=\'selectAllChart(this)\' />";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</legend>\n\t\t\t\t\t\t\t<div class=\"overFlowDiv\" id=\"applCharts\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"ChartID";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" Value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<br>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t</fieldset>\n\t\t\t\t\t<br>\n\t\t\t\t\t<!-- IN072777 End. -->\n\t\t\t\t\t<table cellspacing=\'0\' cellpadding=\'0\' align=\'center\' width=\'100%\' border=\'0\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<td align=\"left\" width=\"5%\"  class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\t<img  src=\"..\\..\\eCommon\\images\\tri.gif\" onClick=\"detailsExpended(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\"/>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"left\" valign=\"middle\" class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\"  class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\"  class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t\t\t<input type=\'radio\' name =\"M";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"M";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"\" onClick=\"detailsExpended(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');selectAll(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');getChartDetails(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\"/>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<tr id=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\"display:none;\">\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"5%\" valign=\"middle\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"45%\" valign=\"middle\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"30%\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"..\\..\\eCA\\images\\";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" />\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\" valign=\"middle\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name =\"C";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"C";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" value=\"\" onClick=\"countCheck(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\');\" disabled >\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'CR";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'CR";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" />\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'CV";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'CV";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"left\" width=\"10%\" valign=\"middle\">&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="Total\" id=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="Total\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"/>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"MV";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"MV";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"/>\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t<input type=\"hidden\" name=\"preDisMsrId\" id=\"preDisMsrId\" id=\"preDisMsrId\" value=\"\"/>\n\t\t\t\t\t<input type=\"hidden\" name=\"totDiscCount\" id=\"totDiscCount\" id=\"totDiscCount\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"/>\n\t\t\t\t\t<input type=\"hidden\" name=\'graphMode\' id=\'graphMode\' id=\'graphMode\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'/>\n\t\t\t\t\t<input type=\"hidden\" name=\'encounter_id\' id=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'/>\n\t\t\t\t\t<input type=\"hidden\" name=\'totalDiscrIds\' id=\'totalDiscrIds\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'/>\n\t\t\t\t\t<input type=\"hidden\" name=\'selectedValues\' id=\'selectedValues\' id=\"selectedValues\" value=\'\'/>\n\t\t\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" />\n\t\t\t\t\t<input type=\"hidden\" name=\"totalCharts\" id=\"totalCharts\" id=\"totalCharts\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" />  <!-- IN072777 -->\n\t\t\t\t\t<input type=hidden name=\'selectedChartDetails\' id=\'selectedChartDetails\' value=\'\'> <!-- IN072777-->\n\t\t\t\t\t<input type=\"hidden\" name=\'bed_no\' id=\'bed_no\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'><!-- added for IN017999 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t</form>\n\t\t<script>\n\t\tparent.VitalSignButtonFrm.location.href = \"../../eCA/jsp/VitalSignButtons.jsp?totDiscCount=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&graphMode=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\t\n\t\tparent.VitalSignGraphDetals.location.href = \"../../eCA/jsp/blank.jsp\";\t\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
	
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

/*	
--------------------------------------------------------------------------------------------------------------
 Date       	Edit History	Name       Rev.Date   	Rev.By    		Description
 --------------------------------------------------------------------------------------------------------------
 ?				?				?			?			?				?
 28/06/2020		IN072777		Ramesh G	01/07/2020	Ramesh Goli		AAKH-CRF-0097.2
 31/05/2021     IN017999        Chandrasekar a                          AAKH-CRF-0132.1 
 ---------------------------------------------------------------------------------------------------------------
 */

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = CommonBean.checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id="CAVitalSignBean";
       	String bean_name="eCA.CAVitalSignBean";
		String from_date 	= request.getParameter("From_date")==null?"":request.getParameter("From_date");
		String to_date 		= request.getParameter("To_date")==null?"":request.getParameter("To_date");
		String patient_id 	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String Patient_class= request.getParameter("Patient_class")==null?"":request.getParameter("Patient_class");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
		String selectedDiscret = request.getParameter("selectedDiscret")==null?"":request.getParameter("selectedDiscret"); //IN072777
		String bed_no=request.getParameter("bed_no")==null?"":request.getParameter("bed_no");//Added for IN017999
		int totDiscCount 	= 0;
		String classValue 	= "";
		String recordeddate="";
		StringBuffer totalDiscrId = new StringBuffer();
		ArrayList<String[]> chartDetails = new ArrayList<String[]>();  //IN072777 Strt.
		String count=request.getParameter("count")==null?"":request.getParameter("count");
	
            _bw.write(_wl_block7Bytes, _wl_block7);

			try{
				eCA.CAVitalSignBean bean = (eCA.CAVitalSignBean)getBeanObject(bean_id,bean_name,request);
				HashMap<String,String> valueIndicator = bean.getValueIndication();
				LinkedHashMap<String,ArrayList<String[]>> resultData = bean.getDiscreteCompResult(from_date,to_date,patient_id,encounter_id,bed_no);//Added for IN017999
			
				if(resultData.size() == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
					out.println("parent.VitalSignButtonFrm.location.href = \"../../eCA/jsp/blank.jsp?totDiscCount=\"");
					out.println("</script>");
				}else{
					//IN072777 Strt.
					chartDetails=bean.getAppChartDetails(selectedDiscret);  					
					
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

								for(int j=0;j<chartDetails.size();j++){
									String[] chartIdVal = chartDetails.get(j);
									String checkedVal = "";
									if("Y".equals(chartIdVal[2]))
										checkedVal="Checked";
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(chartIdVal[0] ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checkedVal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chartIdVal[1] ));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

					for(Map.Entry<String,ArrayList<String[]>> entry :resultData.entrySet()){
						ArrayList<String[]> child = entry.getValue();
						classValue="CAFLOWSHEETLEVEL3" ;
						String discr_msr_id=entry.getKey();
						String[] str = child.get(0);
						if(totDiscCount==0)
							totalDiscrId.append(discr_msr_id);
						else
							totalDiscrId.append(','+discr_msr_id);
						totDiscCount++;
						
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block28Bytes, _wl_block28);

						
						int i=0;
						for(String[] arr : child){
							String[] inner  = new String[2];
							inner = arr[0].split("#");
							recordeddate = inner[0];							
							String image=valueIndicator.get(inner[2]);
							
							
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(inner[0]));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(null!=image && !"".equals(image.trim())){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(image));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(inner[1]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(discr_msr_id));
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recordeddate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(inner[1]));
            _bw.write(_wl_block45Bytes, _wl_block45);

							i++;
						}
						
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(discr_msr_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);

					}
					
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totDiscCount));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(graphMode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalDiscrId.toString()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(chartDetails.size()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block60Bytes, _wl_block60);

				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();
			}
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(totDiscCount));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(graphMode));
            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}
