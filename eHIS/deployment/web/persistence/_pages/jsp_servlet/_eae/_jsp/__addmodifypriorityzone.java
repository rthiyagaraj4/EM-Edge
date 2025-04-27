package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypriorityzone extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AddModifyPriorityZone.jsp", 1738423069253L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\" >\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eIP/html/JQuery/ColorCoding/farbtastic.js\"></script>\n\t\t<link rel=\"stylesheet\" href=\"../../eIP/html/JQuery/ColorCoding/farbtastic.css\" type=\"text/css\" />\n\t\t <script language=\'javascript\' src=\'../../eAE/js/PriorityZone.js\'></script>\n\t  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n   \n  <script>\n\t  $(document).ready(function () {\n\t\t$(\'#colorpicker\').farbtastic(\'#priority_zone_color\');\n\t\t$(\"#colorPickId\").click(function (event){\n\t\t\t$(\"#selectedElem\").css(\'background-color\', $(\"#priority_zone_color\").val());\n\t\t});\n\t  });\n  \n  </script>\n\n\n  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n  <script>\n\t  $(document).ready(function () {\n\t\t$(\'#colorpicker\').farbtastic(\'#waiting_time_color\');\n\t\t$(\"#colorPickId\").click(function (event){\n\t\t\t$(\"#selectedElem\").css(\'background-color\', $(\"#waiting_time_color\").val());\n\t\t});\n\t  });\n  \n  </script>\n\n\n  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n   \n   \n\n\t <body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t <form name=\"priority_zone_form\" id=\"priority_zone_form\" action=\"../../servlet/eAE.AEPriorityZoneServlet\" method=\"post\" target=\"messageFrame\">\n\t <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\'center\' width=\'75%\'>\n\t\t <br><br><br>\n\t    <tr></tr>\n\t\t<tr></tr>\n\t\t<tr>\n\t\t   <td colspan=\'2\' height=\'5\'></td>\n\t\t</tr>\n\t    <tr>\n\t\t      <td class=\'label\'  width=\'50%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t      <td class=\'field\'  width=\'50%\'><input type=\'text\' name=\'priority_zone\' id=\'priority_zone\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' maxLength=\'1\' size=\'1\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" onBlur=\'changeCase(this);\' onKeyPress=\"return CheckForSpecChars(event)\">\n   \t\t      <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t\t\t  </td> \t\n\t\t</tr>\t\n\t\t<tr>\n\t\t   <td colspan=\'2\'></td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t      <td class=\'label\'  width=\'50%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t      <td class=\'field\' width=\'50%\'><input type=\'text\' name=\'priority_zone_desc\' id=\'priority_zone_desc\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" maxLength=\'20\' size=\'20\' onBlur=\"makeValidString(this)\">\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n              </td>\n        </tr>\n\t\t<tr>\n\t\t   <td colspan=\'2\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t      <td class=\'label\'  width=\'50%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t      <td class=\'field\'  width=\'50%\'><input type=\'text\' name=\'priority_zone_tab_desc\' id=\'priority_zone_tab_desc\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" maxLength=\'20\' size=\'20\' onBlur=\"makeValidString(this)\">\n \t\t      <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n              </td>\n        </tr>\n\t\t<tr>\n\t\t   <td colspan=\'2\'></td>\n\t\t</tr>\n\t\t <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start -->\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<tr>\n\t\t <td class=\'label\'  width=\'50%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t      <td class=\'field\' width=\'50%\'>\n\t\t      <input type=\'text\' name=\'selectedElem\' id=\'selectedElem\' id=\'selectedElem\'  maxLength=\'20\' size=\'20\' readonly ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="style=\"background-color:";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><!-- Its Used for Display -->\n\t\t      <input type=\'hidden\' name=\'priority_zone_color\' id=\'priority_zone_color\' id=\'priority_zone_color\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" maxLength=\'20\' size=\'20\' readonly><!-- Its Used for Save -->\n\t  \n              </td>\n\t\t     \n        </tr>\n        ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n       \t\t <input type=\'hidden\' name=\'priority_zone_color\' id=\'priority_zone_color\' id=\'priority_zone_color\' value=\"#ffffff\" >\n        ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n         <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End -->\n\n\n\t\t <!-- Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 Start -->\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\n\t\t      <td class=\'label\'  width=\'50%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t      <td class=\'field\'  width=\'50%\'><input type=\'text\' name=\'waiting_time\' id=\'waiting_time\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" maxLength=\'3\' size=\'3\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'SPCheckPositiveNumber(this);\' /> &nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n \t\t    \n              </td>\n        </tr>\n\t\t<tr>\n\t\t   <td colspan=\'2\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t <td class=\'label\'  width=\'50%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t      <td class=\'field\' width=\'50%\'>\n\t\t     \n\t\t\t <div id=\"selectedElem\" name=\"selectedElem\" class=\'colorcode\' style=\"background-color:";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="; height:30px;width:30px;border: 1px solid;cursor:pointer;\"></div>\n\n\t\t      <input type=\'hidden\' name=\'waiting_time_color\' id=\'waiting_time_color\' id=\'waiting_time_color\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"  />\n\t  \n              </td>\n\t\t     \n        </tr>\n        ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n       \t\t <input type=\'hidden\' name=\'waiting_time_color\' id=\'waiting_time_color\' id=\'waiting_time_color\' value=\"#ffffff\" >\n       \t\t <input type=\'hidden\' name=\'waiting_time\' id=\'waiting_time\' id=\'waiting_time\' value=\"\" >\n        ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n         <!-- Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 End -->\n\n\n\n\t\t<tr>\n\t\t   <td colspan=\'2\'></td>\n\t\t</tr>\n\t\t<!-- Added by Shanmukh on 10th-SEPT-2018 for MMS-DM-CRF-0147-->\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t      <td class=\'field\'  width=\'50%\'><input type=\'checkbox\' name=\'eff_stat\' id=\'eff_stat\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  onClick=\'chkEffStatus(this);chkPatCount(this);\'>\n              </td>\n\t\t\t  <input type=\"hidden\" name=\'eff_status\' id=\'eff_status\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \n\t\t\t  \n\t\t\t  <input type=\"hidden\" name=\"patient_count\" id=\"patient_count\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n        </tr>\n\t\t\n\t\t<tr>\n\t\t   <td colspan=\'2\' height=\'5\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t    \n\t </table> \n\t <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start -->\n\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\n\t\t  <div class=\"ui-layout-center\" style=\"float:right;margin-top:-150px;margin-right:100px;\" id=\'colorpickcontainer\'> \n\t\t\t<div id=\'colorPickId\' class=\'colorPickId\'>\n\t\t\t\t<div id=\"colorpicker\"></div>\n\t\t\t</div>\n\t\t  </div>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t <!-- Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End -->\n\t\t\n\t<input type=\'hidden\' name=\'isPriorityZoneAppl\' id=\'isPriorityZoneAppl\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\t<!--Added By Shanmukh for MMS-DM-CRF-0147-->\t \t\t \n\t\t     <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\t\n\t </form>\n\t\t  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n    </body>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");
String loginUser		= (String)session.getValue("login_user");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String mode						= ""; 

     String priority_zone_result		= request.getParameter("priority_zone");
	 priority_zone_result  = (priority_zone_result == null)?"":priority_zone_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 /*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 Start*/
	 Boolean waitingTimeIndYN			=	CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
	 String waiting_time				= "";
	 String waiting_time_color			= "";
	 /*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 End*/
	

	 String priority_zone				= "";
	 String priority_zone_desc			= "";
	 String priority_zone_tab_desc		= "";
	 String eff_status					= "";

	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
	 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	 String priority_zone_color			= "";
	 String five_level_triage_appl_yn	= (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	 String facility_id					=	(String) session.getValue("facility_id");
	 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
	//Added By Shanmukh for MMS-DM-CRF-0147  start
	Boolean isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");
    	String oper_stn_id="";
	String patient_count="";
	String sql1="";
	String sql2="";
	//End
		mode							= "INSERT";
   
	StringBuffer sql = new StringBuffer("select * from AE_PRIORITY_ZONE where PRIORITY_ZONE=?");
 if(!(priority_zone_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql.toString());
	pstmt.setString(1,priority_zone_result) ;
 	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
	 		priority_zone		= rset.getString("PRIORITY_ZONE");    
			priority_zone		= (priority_zone== null)?"":priority_zone;
			priority_zone_desc				= rset.getString("PRIORITY_ZONE_DESC");
			priority_zone_desc				= ( priority_zone_desc== null)?"": priority_zone_desc;
			priority_zone_tab_desc				= rset.getString("PRIORITY_ZONE_TAB_DESC");
			priority_zone_tab_desc				= (priority_zone_tab_desc== null)?"": priority_zone_tab_desc;
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
			priority_zone_color			= (rset.getString("PRIORITY_ZONE_COLOR")==null || rset.getString("PRIORITY_ZONE_COLOR")=="")?"":rset.getString("PRIORITY_ZONE_COLOR");
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
			
			eff_status					= rset.getString("EFF_STATUS");
			/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 Start*/
			waiting_time			= (rset.getString("WAITING_TIME")==null || rset.getString("WAITING_TIME")=="")?"":rset.getString("WAITING_TIME");
			waiting_time_color			= (rset.getString("WAITING_TIME_COLOR")==null || rset.getString("WAITING_TIME_COLOR")=="")?"#FFFFFF":rset.getString("WAITING_TIME_COLOR");
			/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on Apr 9th 2018 End*/
			
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
					readOnlyAttribute	 = "READONLY";
	   	    }
			mode						 = "MODIFY";
			readOnlyAttribute1			 = "READONLY";
	  }
	  

	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
	  
	  
  } // end of if rta_code_result	  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
	 //Added By Shanmukh for MMS-DM-CRF-0147
	sql2="select oper_stn_id from am_user_for_oper_stn where appl_user_id= '"+loginUser+"' and facility_id='"+facility_id+"'";
    pstmt   = con.prepareStatement(sql2);
    rset = pstmt.executeQuery();
	 while(rset!=null && rset.next()){
		 oper_stn_id=rset.getString("oper_stn_id");
	 }
   
	  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
  
	  if(five_level_triage_appl_yn.equals("Y")){
   
            _bw.write(_wl_block8Bytes, _wl_block8);
}
	  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/  
  if(waitingTimeIndYN){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(priority_zone));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(readOnlyAttribute1));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(priority_zone_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(priority_zone_tab_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
if(five_level_triage_appl_yn.equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!priority_zone_color.equals("")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block21Bytes, _wl_block21);
} 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(priority_zone_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
if(waitingTimeIndYN){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(waiting_time));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(waiting_time_color));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(waiting_time_color));
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
            _bw.write(_wl_block34Bytes, _wl_block34);
if(isPriorityZoneAppl){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block38Bytes, _wl_block38);
 try{
				 sql1="select count(*) patient_count from ae_current_patient a, mp_patient b, op_clinic_lang_vw c where a.facility_id = ? and a.facility_id = c.facility_id and a.patient_id = b.patient_id and c.language_id = ? and a.facility_id=c.facility_id and a.locn_code = c.clinic_code and a.queue_status < '07' and a.priority_zone = ? AND SYSDATE BETWEEN a.check_in_date_time AND (((select reg_attendace_within_hour from ae_param where operating_facility_id =?)/24)+(a.check_in_date_time)) and (a.locn_type, a.locn_code) in (select locn_type, locn_code from am_os_user_locn_access_vw where facility_id =? and Oper_stn_id =? and appl_user_id =? and manage_queue_yn = 'Y' )"; 
			 pstmt   = con.prepareStatement(sql1);
			 pstmt.setString(1,facility_id);
			 pstmt.setString(2,locale);
			 pstmt.setString(3,priority_zone_result);
			 pstmt.setString(4,facility_id);
			 pstmt.setString(5,facility_id);
			 pstmt.setString(6,oper_stn_id);
			 pstmt.setString(7,loginUser);
			 rset = pstmt.executeQuery();
			 while(rset!=null && rset.next()){
				 patient_count=rset.getString("patient_count");
			 }
			}catch(Exception e){e.printStackTrace();}
			 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
if(five_level_triage_appl_yn.equals("Y") || waitingTimeIndYN){
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
	
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(isPriorityZoneAppl));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block46Bytes, _wl_block46);

                if(mode.equals("INSERT"))
					out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].priority_zone.focus();</script>");
				 else
					out.println("<script>document.forms[0].priority_zone_desc.focus();</script>");
		 
            _bw.write(_wl_block47Bytes, _wl_block47);
 } catch(Exception e){e.printStackTrace();}
   finally
    {
    	
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PriorityZoneCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PriorityZoneColorDesc.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PriorityZoneTabDesc.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.ColorIndicator.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.WaitingTimeExceeds.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.Mins.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.WaitingTimeColorIndicator.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
