package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import org.json.simple.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aemanagepatgitabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatGITabs.jsp", 1738423087099L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html> \n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script src=\'../../eAE/js/AEManagePatientGI.js\' language=\"javascript\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\tfunction tab_click1(id) \n\t\t{ \n\t\t\tif(prevTabObj == null){\n\t\t\t\tprevTabObj=\"char_tab\";\n\t\t\t}\n\t\t\tselectTab(id);\n\t\t\ttab_click(id);\n\t\t}\n\n</script> \n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'> \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"AEManagePatTabsForm\" id=\"AEManagePatTabsForm\"  onLoad=\"javascript:tab_click(\'char_tab\');\" OnMouseDown=\"CodeArrest()\"> \n\n<table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n  <tr><td class=\'white\'>\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t<li class=\"tablistitem\" title=\"Patient Management\">\n\t\t\t\t<a onclick=\"tab_click1(\'char_tab\')\" class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\'char_tab\' >\n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"char_tabspan\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t</a>\n\t\t\t </li>\n\t\t\t    <li class=\"tablistitem\" title=\"Unassigned List\">\n\t\t\t\t<a onclick=\"tab_click1(\'others_tab\')\" class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"others_tab\" >\n\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"others_tabspan\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t\t\n\t\t\t\t</a>\n\t\t   </li>\n       </ul>\n\t </td>\n   </tr>\n</table>\n\n<table cellspacing=0 cellpadding=0 align=\"center\" width=\"100%\" border=\"0\">\n<tr>\n\t<table id=\'priority_table\' name=\'table_priority\' id=\'table_priority\' border=1 align=\'left\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' style=\'visibility:visible\'>\n\t<tr>\t\t\n\t\n<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->\n\t<!--   <td class=RESUSCITATION id=\"critical\" align=center  style=\'cursor:pointer\' alt=\"Critical\" nowrap onclick=\"showCritical()\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\n\t<td class=OAYELLOW id=\"semicritical\"  align=center style=\'cursor:pointer\' alt=\"Semi-Critical\" onclick=\"showSemiCritical()\" nowrap><font size=2 color=\'black\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\t\n\t<td class=URGENT id=\"noncritical\"  align=center style=\'cursor:pointer\' alt=\"Non-Critical\" nowrap onclick=\"showNonCritical()\"><font color=\'WHITE\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\t\n\t<td class=EMERGENT id=\"Unassigned\"  align=center style=\'cursor:pointer\' alt=\"unassigned\" nowrap onclick=\"showUnassigned()\"><font color=\'WHITE\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></td>-->\n\t\t\n\t\n<!--CRF  SKR-CRF-0021 [IN028173] end-->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<td class=RESUSCITATION id=\"priority_zone_tab_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" alt=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  align=center  style=\'cursor:pointer;background-color:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =";width:210px;break-row;\' nowrap  onclick=\"FnShowPriorityWise(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\">&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t<input type=\'hidden\' name=\'priority_zone_color_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'priority_zone_color_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t\n\t<td class=PATIENTLINECOLOR id=\"others\" style=\'width:210px;break-row;\'  align=center style=\'cursor:pointer\' alt=\"All\" onclick=\"showAll()\" nowrap><font color=\'WHITE\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></td>\t\t\n\t</td>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<td class=RESUSCITATION id=\"priority_zone_tab_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =";width:210px;break-row;\' nowrap onclick=\"FnShowPriorityWise(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<input type=\'hidden\' name=\'priority_zone_color_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\n\t\t\t\t\t<td style=\'width:212px;break-row;\' class=RESUSCITATION id=\"treatment_area_tab_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =";color:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =";\' nowrap onclick=\"FnShowPriorityWise(\'\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'treatmentAreaTab\')\">&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'treatment_tab_color_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'treatment_tab_color_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<input type=\'hidden\' name=\'treatment_area_all_codes\' id=\'treatment_area_all_codes\' id=\"treatment_area_all_codes\" value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<!--End ML-MMOH-CRF-1973-->\n\t</tr>\n\t</table>\n\t<script>\n\t//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023\n\tif(";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="){\n\tvar row_ht =";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="*5;\n\tvar frset = parent.document.getElementsByTagName(\"frameset\")[0];\n\tfrset.rows = \"13%,\"+row_ht+\"%,*,0%\";\n\t}\n\tvar prevTabObj\n\tfunction loadingtab(obj)\n\t\t{\n\t\t alert(\'loadingtab\');\n\t//\t alert(\'document.getElementById(\"char_tab\")  : \'+document.getElementById(\"char_tab\").name);\n\t//\t\t\teval(\"document.getElementById(\"char_tab\")\").className=\"tabClicked\"\n\t//\t\teval(\"document.getElementById(\"char_tabspan\")\").className=\"tabSpanclicked\"\n\t\t}\n\t</script> \n<input type=\'hidden\' name=\'ct_tab_name\' id=\'ct_tab_name\'  >\n<input type=\'hidden\' name=\'toggle_wait_patman\' id=\'toggle_wait_patman\'  value=\"char_tab\">\n<!--  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start-->\n<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'priority_zone_all_codes\' id=\'priority_zone_all_codes\' id=\"priority_zone_all_codes\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n<!--  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 End-->\n<!-- Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17 -->\n<input type=\'hidden\' name=\'boldPriorityZoneTab\' id=\'boldPriorityZoneTab\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->\n<!--Starts-->\n<input type=\'hidden\' name=\'appear_as_tab_yn\' id=\'appear_as_tab_yn\' value=\"\">\n<input type=\'hidden\' name=\'treatment_area_code1\' id=\'treatment_area_code1\' value=\'\' > \n<input type=\'hidden\' name=\'isAppearAsTabEnable\' id=\'isAppearAsTabEnable\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\'hidden\' name=\'clinic_code2\' id=\'clinic_code2\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"> \n<!--Ends-->\n</form>\n</body>\n  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</html>\n ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
 
  /* below lines are add by venkateshs on 29/06/2012 against  the crf SKR-CRF-0021 [IN028173] */
    String sql              ="";
	String color            ="";
	String  green           ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";	
    PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	String locale		    = (String)session.getAttribute("LOCALE");
	Connection con		= null ;
	con				= ConnectionManager.getConnection(request);
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 Start*/
	//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/2017
	Boolean boldPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BOLD_PRIORITY_ZONE_TAB");
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	Boolean rearrangePriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "REARRANGE_PRIORITY_ZONE_TAB");
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts	
	String tabIndicator=(request.getParameter("tabIndicator")==null)? "" : request.getParameter("tabIndicator");
	//Added by santhosh for ML-MMOH-CRF-1973
	String char_tab_aClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabA":"tabClicked";
	String char_tab_spanClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabAspan":"tabSpanclicked";
	String others_tab_aClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabClicked":"tabA";
	String others_tab_spanClass=(checkForNull(tabIndicator).equals("others_tab"))?"tabSpanclicked":"tabAspan";
	//END
	
	Boolean isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); 
	String	short_desc ="";
	String	tab_colour ="";
	String tab_font_colour ="";
	String treat_area_code="";		
	String treatment_area_all_codes="";		
	int tab_count=0;
	int first_tab_cnt=5;	
	String facility_id		=	(String) session.getValue("facility_id");
	String appear_as_tab_yn = "";//Added for ML-MMOH-CRF-1973
	int tab_row_cnt=1;
	ResultSet			rs			=	null;
	String	treatment_area_code				=	"";
	String	clinic_code						=	"";
	String clinic_code2 ="";
	clinic_code=request.getParameter("clinic_code"); 
	clinic_code2=clinic_code;
/*	StringBuffer query_location  = new StringBuffer();
	StringBuffer query_treatment_area = new StringBuffer();
	String where_condition	=	"";
	String  checkout_yn	=	"";
	String  first_clinic_code	=	"";
	int rowIndex =	1;
	String login_user_id	=	(String)session.getValue("login_user");
    String oper_stn_id     =	(request.getParameter("oper_stn_id")==null)? "" : request.getParameter("oper_stn_id");
	*/
	//Ends
	System.err.println("***************************AEManagePatGITabs Called ******************************** ");
	String priority_zone_code				= "";
	String priority_zone_desc			= "";
	String priority_zone_color			= "";
	String priority_zone_all_codes		= "";
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String search_treatment_area_code = checkForNull(request.getParameter("treatment_area_code"));
	Map<String, String> colorMap = new HashMap<String, String>();
	Map<String, String> colorFontMap = new HashMap<String, String>();//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	colorMap.put("G", "Green");
	colorMap.put("R", "Red");
	colorMap.put("Y", "Yellow");
	colorMap.put("U", "ORANGE");
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts
	if(isAppearAsTabEnable){
	colorMap.put("PR", "Purple");
	colorMap.put("BR", "Brown");
	colorMap.put("BL", "Blue");
	colorMap.put("DB", "#00008B");
	colorMap.put("MG", "Magenta");
	colorMap.put("PK", "Pink");
	colorMap.put("CY", "Cyan");
	colorMap.put("GY", "Grey");
	colorFontMap.put("G", "Green");
	colorFontMap.put("R", "Red");
	colorFontMap.put("Y", "Yellow");
	colorFontMap.put("U", "ORANGE");
	colorFontMap.put("PR", "White");
	colorFontMap.put("BR", "White");
	colorFontMap.put("BL", "White");
	colorFontMap.put("DB", "White");
	colorFontMap.put("MG", "White");
	colorFontMap.put("PK", "Black");
	colorFontMap.put("CY", "Black");
	colorFontMap.put("GY", "White");
	}
	//Ends
	System.err.println("colorMap------>"+colorMap);
	System.err.println("colorFontMap------>"+colorFontMap);
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 End*/
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	String priority_zone_desc_unassign			= "";
	String priority_zone_color_unassign			= "";
	String priority_zone_code_unassign			= "";
	
	/*Commented For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start*/
	/*try
	{  
	  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
				
			    pstmt   = con.prepareStatement(sql.toString());
			 	pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				 if (color.equals("R")) {red=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				 if (color.equals("Y")) {yellow=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				 if (color.equals("U")) {unassigned=rset.getString("PRIORITY_ZONE_TAB_DESC");}
				
				 
				 }
	
	
    }catch(Exception e){e.printStackTrace();}
	finally 
	{
	if (rset !=null) rset.close();
	if (pstmt !=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
				
				
				*/
	
 /* CRF  SKR-CRF-0021 [IN028173] end  */
 /*Commented For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{ 


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(char_tab_aClass));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(char_tab_spanClass));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(others_tab_aClass));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(others_tab_spanClass));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(red));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(yellow));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(green));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(unassigned));
            _bw.write(_wl_block19Bytes, _wl_block19);

sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' ";
if(!five_level_triage_appl_yn.equals("Y")){
		sql	= sql + "  and priority_zone not in ('B','W') ";
}
sql= sql + " order by PRIORITY_ZONE_ORDER asc";
pstmt   = con.prepareStatement(sql.toString());
pstmt.setString(1,locale) ;
rset    = pstmt.executeQuery();
while(rset!=null && rset.next())
{
	priority_zone_code	= rset.getString("PRIORITY_ZONE");
	priority_zone_desc	= rset.getString("PRIORITY_ZONE_TAB_DESC");
	priority_zone_color = (rset.getString("PRIORITY_ZONE_COLOR")==null || rset.getString("PRIORITY_ZONE_COLOR")=="")?"":rset.getString("PRIORITY_ZONE_COLOR");
 	if(priority_zone_color.equals("")){
 		priority_zone_color	= colorMap.get(priority_zone_code);
 	}
 	priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";

	if(rearrangePriorityZoneTab && priority_zone_code.equals("U")){ 
			priority_zone_color_unassign = priority_zone_color;
			priority_zone_desc_unassign  = priority_zone_desc;
			priority_zone_code_unassign  = priority_zone_code;
    } else { 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(priority_zone_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block28Bytes, _wl_block28);
}

}

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 //Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	if(rearrangePriorityZoneTab){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(priority_zone_desc_unassign));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(priority_zone_color_unassign));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(priority_zone_desc_unassign));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(priority_zone_code_unassign));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(priority_zone_color_unassign));
            _bw.write(_wl_block34Bytes, _wl_block34);
}  
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts
	try {
	if(isAppearAsTabEnable) 
		{
	//	JSONObject AppearAsTabYNJson		= new JSONObject();
	//	AppearAsTabYNJson = eAE.AECommonBean.getAppearAsTabYN(con,facility_id,treatment_area_code,clinic_code);
	//	appear_as_tab_yn		= (String)AppearAsTabYNJson.get("appear_as_tab_yn");
	//	if(appear_as_tab_yn.equals("Y")) 
	//		{ 
				sql="SELECT TREATMENT_AREA_CODE,short_desc, appear_as_tab_yn, tab_colour FROM ae_tmt_area_for_clinic WHERE appear_as_tab_yn = 'Y' AND facility_id =? AND clinic_code =? and treatment_area_code=NVL(?,treatment_area_code) "; 			
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,facility_id) ;
				pstmt.setString(2,clinic_code) ;
				pstmt.setString(3,search_treatment_area_code) ;
			    rs    = pstmt.executeQuery();			
				while(rs!=null && rs.next())
					{					
					short_desc	= rs.getString("short_desc");
					appear_as_tab_yn	= rs.getString("appear_as_tab_yn");
					tab_colour	= rs.getString("tab_colour");
					treat_area_code	= rs.getString("TREATMENT_AREA_CODE");
					tab_font_colour	= colorFontMap.get(tab_colour);
				 	tab_colour	= colorMap.get(tab_colour);	
					treatment_area_all_codes = treatment_area_all_codes + treat_area_code + ",";				
					
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tab_colour));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tab_font_colour));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(appear_as_tab_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(treat_area_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tab_colour));
            _bw.write(_wl_block42Bytes, _wl_block42);

					tab_count++;
					if(tab_count==4 && first_tab_cnt==5)
						{
						tab_count=0;
						out.println("</tr>");
						out.println("<tr  width='50%'>");
						first_tab_cnt=0;
						tab_row_cnt++;
						}
					else if(tab_count==9)
						{
						tab_count=0;
						out.println("</tr>");
						out.println("<tr  width='50%'>");	
						tab_row_cnt++;
						}	 			
					}
					//System.err.println("tab_row_cnt in AEManagePatGITabs.jsp========"+tab_row_cnt);
			//	}
			
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(treatment_area_all_codes));
            _bw.write(_wl_block44Bytes, _wl_block44);
	}
	
	if (rset !=null) rset.close();
	if (pstmt !=null) pstmt.close();
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(isAppearAsTabEnable));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tab_row_cnt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(five_level_triage_appl_yn ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(priority_zone_all_codes));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(boldPriorityZoneTab));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(isAppearAsTabEnable));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block52Bytes, _wl_block52);
  }catch(Exception e){e.printStackTrace();}
	finally 
	{
	if (rset !=null) rset.close();
	if (pstmt !=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PatientManagement.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.UnassignedList.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
}
