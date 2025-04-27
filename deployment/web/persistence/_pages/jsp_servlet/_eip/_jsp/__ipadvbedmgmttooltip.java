package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIP.advbedmgmt.transaction.TransactionConstants;
import eIP.advbedmgmt.transaction.rolebasedaccess.response.Transaction;
import eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListResourceConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.transaction.rolebasedaccess.response.TransactionListResponse;
import eIP.advbedmgmt.transaction.rolebasedaccess.bc.TransactionListBC;
import eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListConstants;
import eIP.advbedmgmt.transaction.rolebasedaccess.request.TransactionListRequest;
import eCommon.Common.CommonBean;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconSection;
import eIP.advbedmgmt.transaction.floorlayout.response.RoomForBedIconSection;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconResponse;
import eIP.advbedmgmt.transaction.floorlayout.bc.BedDetailsBC;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants;
import eIP.advbedmgmt.transaction.floorlayout.request.BedIconRequest;
import eIP.advbedmgmt.transaction.patientfinancial.FinancialInfoConstants;
import eIP.advbedmgmt.transaction.canceladmission.PatientCheckInController;
import eIP.advbedmgmt.transaction.canceladmission.PatientCheckInStatusResponse;
import eIP.advbedmgmt.transaction.canceladmission.PatientCheckInStatusRequest;
import eIP.advbedmgmt.transaction.createbooking.CreateBookingConstants;
import eIP.advbedmgmt.GBMConstants;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ipadvbedmgmttooltip extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtToolTip.jsp", 1709117771661L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n<head>\n  <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n  <link type=\"text/css\" rel=\"stylesheet\" href=\"../../eIP/html/IPAdvBedMgmtStyle.css\"/>\n  <Script src=\"../js/json2.js\" language=\"JavaScript\"></Script>\n  <title></title>\n</head>\n<body class=\"page\"> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<div class=\'box\'>\n\t\t<div class=\'patdtls\'>\n\t\t\t<div class=\'Bannerbg\'>\n\t\t\t\t<div class=\'patphoto\'>\n\t\t\t\t\t<img src=\"../../eCommon/jsp/PatPhotoDisplay.jsp?patient_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" class=\'patphotoimg\'>\n\t\t\t\t\t<!--<img src=\"../../eCommon/images/blank_pat_photo.bmp\" width=\'48\' height=\'40\'>\n\t\t\t\t\t<img src=\"../../eCommon/images/blank_pat_photo.bmp\" class=\'patphotoimg\'>-->\n\t\t\t\t</div>\n\t\t\t\t<div class=\'patdatadtls\'>\n\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"table-layout: fixed;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"2\" class=\'labeltooltip\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="| ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" |";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\'labeltooltip\' style=\"word-wrap:break-word;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="|";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  class=\'labeltooltip\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t<td  class=\'labeltooltip\'>:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t\t<td  class=\'labeltooltip\' align=\'left\'>:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\'imgsection\'>\n\t\t\t\t<table width=\"100%\" height=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t  <tr>\n\t\t\t\t\t\t<!--<td width=\"30\" height=\"30\" align=\"center\" valign=\"middle\"><img src=\"../../eIP/images/icon01.png\" width=\"19\" height=\"19\" /></td>\n\t\t\t\t\t\t<td width=\"30\" height=\"30\" align=\"center\" valign=\"middle\"><img src=\"../../eIP/images/icon02.png\" width=\"19\" height=\"19\" /></td>\n\t\t\t\t\t\t<td width=\"30\" height=\"30\" align=\"center\" valign=\"middle\"><img src=\"../../eIP/images/icon03.png\" width=\"19\" height=\"19\" /></td>\n\t\t\t\t\t\t<td width=\"30\" height=\"30\" align=\"center\" valign=\"middle\"><img src=\"../../eIP/images/ixon04.png\" width=\"19\" height=\"19\" /></td>\n\t\t\t\t\t\t<td align=\"left\" valign=\"middle\">&nbsp;</td>-->\n\t\t\t\t\t\t<td  valign=\"center\">&nbsp;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--   show patient financial icon - this has to be shown always-->\n\t\t\t\t\t\t\t<img src=\"../images/Dollar.png\" title=\"Financial Details\" onclick=\"showPatientFinancials(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<img src=\"../../eCommon/images/PI_Allergies.gif\" onclick=\'callAllery(event,\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\")\' />\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<img src=\"../images/future.gif\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<img src=\"../images/PendingOrders.png\"/>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t  </tr>\n\t\t\t\t</table>\n\t\t\t</div> \n\t\t\t<div class=\'informationbg\'>\n\t\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"informationcontent\" >\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'35%\' class=\'labeltooltipdata\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t\t<td width=\'2%\'  ><b>:</b></td>\n\t\t\t\t\t\t\t<td width=\'63%\' class=\'labeltooltipdata\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'35%\' class=\'labeltooltipdata\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\t\t<td width=\'2%\' ><b>:</b></td>\n\t\t\t\t\t\t\t<td width=\'63%\'  class=\'labeltooltipdata\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'35%\'  class=\'labeltooltipdata\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t</table>\t\t\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\'trnsdiv\'>\n\t\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" valign=\"top\" class=\"Transactions\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n                <td align=\"center\" valign=\"top\" class=\"Transactionsmenu\">\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<div>\n\t\t\t <span style=\"color:#000000\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</span>\n\t\t\t</div>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<div class=\'IPOPRS\' onclick=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\"><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></div>\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<div class=\'IPOPRS\' onclick=\"cancelAdmission(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\t\t<div class=\'IPOPRS\' onclick=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<div class=\'IPOPRS\' onclick=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b></div>\t\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<div class=\'IPOPRS\' onclick=\"patientChart(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\"><b>Patient Chart</b></div>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\n\t\t</td>\n            </tr>\n\t\t</table>\n\t</div>\n\t<div class=\'Footerbg\'></div>\n\t</div>\n  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</body>\n\n\n</html>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\n\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt=null;
	PreparedStatement	pstmt	= null;
	ResultSet rs	= null;
	String facility_id		= (String)session.getAttribute("facility_id");
	String nursing_unit=request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	// get the nursing unit description as well - this is needed for internal processing
	String nursing_unit_desc=request.getParameter("nursing_unit_desc");
	if(nursing_unit_desc == null){
		nursing_unit_desc = "";
	}
	String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String user_id=(String)session.getAttribute("login_user");
	String operStnId=request.getParameter("operStnId")==null?"":request.getParameter("operStnId");
	String trnsAllowed=request.getParameter("trnsAllowed")==null?"":request.getParameter("trnsAllowed");
	String bed_no=request.getParameter("bed_no")==null?"":request.getParameter("bed_no");
	String appl_patient_class=request.getParameter("appl_patient_class")==null?"":request.getParameter("appl_patient_class");
	
	// get the room number and the room name as well - this will be passed from Graphical Bed Management module
	String roomNumber = request.getParameter("room_number");
	if(roomNumber == null){
		roomNumber = "";
	}
	String roomName = request.getParameter("room_name");
	if(roomName == null){
		roomName = "";
	}
	
	
	String patient_id="";
	String patient_name="";
	String practitioner_id="";
	String practitioner_name="";
	String bed_class="";
	String bed_type="";
	String locale				= (String)session.getAttribute("LOCALE");
	String bedNo="";
	String pat_age="";
	String gender="";
	String admissionDateTime="";
	String expDischargeDateTime="";
	String pend_ord_stats="";
	String pat_dtls_unknown="";
	String finalize_yn="";
	// code added for showing bed allocation date time value
	String bed_alloc_date_time = "";
	
	// code added to initialize vars for specialty code and desc
	String specialtyCode = "";
	String specialtyDesc = "";
			
	try{
		con=ConnectionManager.getConnection(request);
		// to get all rooms of nursing unit starts
		//stmt=con.createStatement();
		HashMap ipPatEncData=eIP.IPAdvBedMgmtBean.getPatEncounterData(con,stmt,rs,encounter_id,facility_id,locale,bed_no);
		patient_id=(String)(ipPatEncData.get("patient_id")==null?"":ipPatEncData.get("patient_id"));
		bedNo=(String)(ipPatEncData.get("bedNo")==null?"":ipPatEncData.get("bedNo"));
		bed_class=(String)(ipPatEncData.get("bed_class_short_desc")==null?"":ipPatEncData.get("bed_class_short_desc"));
		bed_type=(String)(ipPatEncData.get("bed_type_short_desc")==null?"":ipPatEncData.get("bed_type_short_desc"));
		patient_name=(String)(ipPatEncData.get("patient_name")==null?"":ipPatEncData.get("patient_name"));
		pat_age=(String)(ipPatEncData.get("pat_age")==null?"":ipPatEncData.get("pat_age"));
		gender=(String)(ipPatEncData.get("gender")==null?"":ipPatEncData.get("gender"));
		pend_ord_stats=(String)(ipPatEncData.get("pend_ord_stats")==null?"N":ipPatEncData.get("pend_ord_stats"));
		pat_dtls_unknown=(String)(ipPatEncData.get("pat_dtls_unknown")==null?"N":ipPatEncData.get("pat_dtls_unknown"));
		finalize_yn=(String)(ipPatEncData.get("finalize_yn")==null?"N":ipPatEncData.get("finalize_yn"));
		practitioner_id=(String)(ipPatEncData.get("practitioner_id")==null?"":ipPatEncData.get("practitioner_id"));		
		practitioner_name=(String)(ipPatEncData.get("practitioner_name")==null?"":ipPatEncData.get("practitioner_name"));		
		admissionDateTime=(String)(ipPatEncData.get("admission_date_time")==null?"":ipPatEncData.get("admission_date_time"));		
		expDischargeDateTime=(String)(ipPatEncData.get("exp_discharge_date_time")==null?"":ipPatEncData.get("exp_discharge_date_time"));
		// get the bed allocation date time value
		bed_alloc_date_time = (String)(ipPatEncData.get("bed_alloc_date_time")==null?"":ipPatEncData.get("bed_alloc_date_time"));
		
		// code added to get specialty code and desc
		specialtyDesc = (String)ipPatEncData.get("specialtyDesc");
		specialtyCode = (String)ipPatEncData.get("specialtyCode");
		
		String retVal="";
		TransactionListResponse transListResponse = null;
		// get the transaction list 
		if(trnsAllowed.equals("Y")){
			//retVal=eIP.IPAdvBedMgmtBean.getIPEncAllowedOperations(con,pstmt,rs,facility_id,encounter_id,nursing_unit,bedNo,patient_id,user_id,operStnId);

			// new code to get the transaction list
			TransactionListRequest transRequest = new TransactionListRequest();
			transRequest.setFacilityId(facility_id);
			transRequest.setEncounterId(encounter_id);
			transRequest.setBedNumber(bed_no);
			transRequest.setLocale(locale);
			transRequest.setLocationCode(nursing_unit);
			transRequest.setLocationType(TransactionListConstants.NU_LOCATION_TYPE);
			transRequest.setNursingUnitCode(nursing_unit);
			transRequest.setPatientId(patient_id);
			
			// get responsibility id from session
			String respId = (String)session.getAttribute("responsibility_id");
			transRequest.setResponsibilityId(respId);
			transRequest.setUserId(user_id);
			
			ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
			TransactionListBC bcInst = (TransactionListBC) context.getBean(TransactionListConstants.BEAN_CLASS_KEY);
			transListResponse = bcInst.getAccessibleTransactions(transRequest);
		}
		if(gender.equals("M")){
			gender=MessageManager.getLabel(locale,"Common.male.label","Common");
		}else if(gender.equals("F")){
			gender=MessageManager.getLabel(locale,"Common.female.label","Common");
		}else if(gender.equals("U")){
			gender=MessageManager.getLabel(locale,"Common.unknown.label","Common");
		}
		
		// code added to get the bed icon section
		// this is similar to the bed icon section part in the main GUI
		// difference is that a particular bed number is passed here
		BedIconRequest bedIconRequest = new BedIconRequest();
		bedIconRequest.setFacilityId(facility_id);
		bedIconRequest.setNursingUnitCode(nursing_unit);
		String blOper = (String) session.getAttribute("bl_operational");
		blOper = CommonBean.checkForNull(blOper,
				FloorLayoutConstants.BILL_OPERATIONAL_DEFAULT_VALUE);
		bedIconRequest.setBlOperational(blOper);
		bedIconRequest.setLangId(locale);
		bedIconRequest.setBedNumber(bed_no);
		
		// get data through BC class
		ApplicationContext context = new ClassPathXmlApplicationContext(
						GBMConstants.SPRING_BEANS_XML_NAME);
		BedDetailsBC bcInst = (BedDetailsBC) context
						.getBean(FloorLayoutConstants.BED_DETAILS_BC_NAME);
		BedIconResponse bedIconResponse = bcInst.getBedIconSectionDetails(bedIconRequest);
		
		String knownAllergyYN="N";
		int futBookCnt = 0;
		int medOverDue = 0;
		int abnormalResCnt = 0;
		int pubResCnt = 0;
		int ordersCnt = 0;
		
		// inspect the icons only when the response is successful
		if(bedIconResponse.isSuccessful()){
			List<RoomForBedIconSection> rooms = bedIconResponse.getRooms();
			// rooms will be filled and will have only one room
			final int ROOM_INDEX = 0;
			RoomForBedIconSection room = rooms.get(ROOM_INDEX);
			List<BedIconSection> beds = room.getBedIcons();
			// bed list also will have only one bed 
			final int BED_INDEX = 0;
			BedIconSection bedIconSection = beds.get(BED_INDEX);
			// allergy
			knownAllergyYN = bedIconSection.getKnownAllergy();
			futBookCnt = bedIconSection.getFutureBookingCount();
			medOverDue = bedIconSection.getMedicationOverDueCount();
			abnormalResCnt = bedIconSection.getAbnormalResultCount();
			pubResCnt = bedIconSection.getPublishedResultCount();
			ordersCnt = bedIconSection.getOrdersCount();
		}
		
		//KNOWN_ALLERGY_YN=request.getParameter("KNOWN_ALLERGY_YN")==null?"N":request.getParameter("KNOWN_ALLERGY_YN");
		//String overdue_count=request.getParameter("overdue_count")==null?"0":request.getParameter("overdue_count");
		//String due_count=request.getParameter("due_count")==null?"0":request.getParameter("due_count");
		//String abnormal_rslt_count=request.getParameter("abnormal_rslt_count")==null?"0":request.getParameter("abnormal_rslt_count");
		

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(!encounter_id.equals("")){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pat_age));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(FinancialInfoConstants.PATIENTID_KEY));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(FinancialInfoConstants.ENCOUNTERID_KEY));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

							// below are the alert icons
							if("Y".equals(knownAllergyYN)){
							
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);

							}
							
            _bw.write(_wl_block22Bytes, _wl_block22);

							if(futBookCnt > 0){
							
            _bw.write(_wl_block23Bytes, _wl_block23);

							}
							
            _bw.write(_wl_block22Bytes, _wl_block22);

							String combinedImageURL = "";
							if((medOverDue > 0) && (abnormalResCnt > 0) && (pubResCnt > 0)){
								combinedImageURL = "../images/mod_abresults_pubresults.png";
							}else{
								if((medOverDue > 0) && (abnormalResCnt > 0)){
									combinedImageURL = "../images/mod_abresults.png";
								}else if((medOverDue > 0) && (pubResCnt > 0)){
									combinedImageURL = "../images/mod_pubresults.png";
								}else if((abnormalResCnt > 0) && (pubResCnt > 0)){
									combinedImageURL = "../images/abresults_pubresults.png";
								}else{
									if(medOverDue > 0){
										combinedImageURL = "../images/mod.png";
									}else if(abnormalResCnt > 0){
										combinedImageURL = "../images/abresults.png";
									}else if(pubResCnt > 0){
										combinedImageURL = "../images/pubresults.png";
									}
								}
							}
							
							if(!combinedImageURL.trim().equals("")){
							
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(combinedImageURL ));
            _bw.write(_wl_block25Bytes, _wl_block25);

							}
							
            _bw.write(_wl_block26Bytes, _wl_block26);

							if(ordersCnt > 0){
							
            _bw.write(_wl_block27Bytes, _wl_block27);

							}
							
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(admissionDateTime));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_alloc_date_time));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(expDischargeDateTime));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

		//StringTokenizer tokenizer= new StringTokenizer(retVal,"||");
		String displayFun="";
		String jsFunName="";
		final String MODE = "modal";
		
		
		// error handling
		if(transListResponse == null || !transListResponse.isSuccessful()){
			String errorMessage = null;
			if(transListResponse == null){
				 errorMessage = BundleManager.getInstance().
							getMessageFromResourceBundle(TransactionListResourceConstants.
									DISPLAY_NO_DATA_KEY, TransactionListResourceConstants.
									RBT_RESOURCE_MESSAGE_FILE_PATH);
			}else if(!transListResponse.isSuccessful()){
				errorMessage = transListResponse.getErrorMessage();
			}
			
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block36Bytes, _wl_block36);

		}else{
			List<Transaction> transactionList = transListResponse.getTransactionList();
			String functionId = null;
			// list will have data - just render it
			for(Transaction transaction : transactionList){
				functionId = transaction.getFunctionId();
				if(TransactionListConstants.ASSIGN_TREAT_PRACT_FUNC_ID.
						equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.AssignTreatingPractitioner.label","Common");
					jsFunName="assignTreatingPract";
				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(jsFunName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
				} else if(TransactionListConstants.CANCEL_ADM_FUNC_ID.equalsIgnoreCase(functionId)){
					
					final String CALL_FROM = "IP";
					final String CALL_FUNCTION = "CancelAdmissionMain.jsp";
					final String JSP_NAME = CALL_FUNCTION;
					final String P_SERVICE_TYPE = "";
					
					final String PATIENT_CHECKIN_ALLOWED_DEFAULT = "N";
					displayFun = MessageManager.getLabel(locale,"Common.CancelAdmission.label","Common");
					PatientCheckInStatusRequest patCheckInStatusRequest = new PatientCheckInStatusRequest();
					patCheckInStatusRequest.setFacilityId(facility_id);
					PatientCheckInController controller = new PatientCheckInController();
					PatientCheckInStatusResponse patCheckInStatusResponse = 
							controller.getPatientCheckInStatus(patCheckInStatusRequest);
					String patCheckInAllowedYN = null;
					if(patCheckInStatusResponse != null){
						patCheckInAllowedYN = patCheckInStatusResponse.getPatientCheckedInStatus();
					}
					if(patCheckInAllowedYN == null || patCheckInAllowedYN.trim().equals("")){
						patCheckInAllowedYN = PATIENT_CHECKIN_ALLOWED_DEFAULT;
					}
					
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitioner_id ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CALL_FROM));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(CALL_FUNCTION));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(JSP_NAME));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patCheckInAllowedYN ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(P_SERVICE_TYPE));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(MODE));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
				}else if(TransactionListConstants.PREP_DISCH_ADV_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"eIP.PrepareDischargeAdvice.label","IP");
					jsFunName="PrepDischrgAdvice";
				
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(jsFunName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pend_ord_stats));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_dtls_unknown));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
				}else if(TransactionListConstants.CANC_DISCH_ADV_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.CancelDischargeAdvice.label","Common");
					jsFunName="CancelDischrgAdvice";
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(jsFunName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pend_ord_stats));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_dtls_unknown));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block44Bytes, _wl_block44);
	
				}else if(TransactionListConstants.DISCH_PATIENT_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.DischargePatient.label","Common");
					jsFunName="DischargePatient";
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(jsFunName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pend_ord_stats));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_dtls_unknown));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
				}else if(TransactionListConstants.ADM_PATIENT_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.AdmitPatient.label","Common");
					jsFunName="admitPatient";
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(jsFunName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appl_patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
				} else if(TransactionListConstants.ASSIGN_BED_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = BundleManager.getInstance().getMessageFromResourceBundle(
							TransactionConstants.ASSIGNBED_MARKARRIVAL_BUNDLE_KEY, 
							TransactionConstants.TRANS_LABELS_RES_FILE_PATH);
					final String SHOW_NU_POPUP = "N";
					final String SHOW_SPECIALTY_POPUP = "Y";
				
            _bw.write(_wl_block45Bytes, _wl_block45);
            _bw.write(_wl_block45Bytes, _wl_block45);
	
				}
			
			}
		
            _bw.write(_wl_block46Bytes, _wl_block46);

		//switch case comparison is only for int in swicth(int), but from java 7 for strings also we can use
		 
            _bw.write(_wl_block47Bytes, _wl_block47);
            _bw.write(_wl_block46Bytes, _wl_block46);

		if(!encounter_id.equals("")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pend_ord_stats));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pat_dtls_unknown));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
			HashMap retMap=eIP.IPAdvBedMgmtBean.getAssignedBedForAdmission(con,pstmt,rs,facility_id,nursing_unit,bedNo,user_id,operStnId);
			if(retMap!=null){
				patient_id=(String)retMap.get("patient_id");
				encounter_id=(String)retMap.get("encounter_id");
				displayFun = MessageManager.getLabel(locale,"eIP.assignbedmarkpatientarrival.label","IP");
				jsFunName="AssignBedMarkArrival";
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(jsFunName));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(operStnId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayFun));
            _bw.write(_wl_block40Bytes, _wl_block40);

			}else{

			}
		  }
		
		}
		
            _bw.write(_wl_block50Bytes, _wl_block50);
  
	}catch(Exception ex){
				ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(con != null)  ConnectionManager.returnConnection(con,request);
	}
  
            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block52Bytes, _wl_block52);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ArrivedDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transaction.label", java.lang.String .class,"key"));
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
}
