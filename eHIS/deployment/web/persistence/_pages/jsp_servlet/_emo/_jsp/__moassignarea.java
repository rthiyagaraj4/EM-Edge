package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __moassignarea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOAssignArea.jsp", 1709118399634L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<!--<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>-->\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<script language=\'javascript\' src=\'../../eMO/js/MOManageDeceased.js\'></script>\n<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n\n<!--<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n\n</head>\n<body onKeyDown = \'lockKey()\' onLoad=\'clearBed1()\' >\n<center>\n<br>\n<form name=\'MOMDAssgnTmtAreaForm\' id=\'MOMDAssgnTmtAreaForm\' method=\'POST\' action=\"../../servlet/eMO.MOManageDeceasedAssignAreaServlet\" target=messageFrame>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<input type=\'hidden\' name=\'system_date\' id=\'system_date\'        value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t<input type=\'hidden\' name=\'body_received_date\' id=\'body_received_date\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t<tr>\n\t\t\t<th  align=\"left\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =":&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=label colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t<tr style=\'height:20px;\'>\n\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\n\t\t<td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\n\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\t\n\t\t\n\t\t<td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\n\t</tr>\n\n\t<tr>\n\t\t\t<td class=\'LABEL\'  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\n\t\t\t<td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\n\t\t\t<td class=\'LABEL\' >&nbsp;</td>\t\n\n\t\t\t<td class=\'QUERYDATA\' >&nbsp;</td>\t\n\t</tr>\n\t\n\t<tr>\n\t\t\t<td class=label colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\n\n\t<tr>\n\t\t\t<th align=\'centert\' width=\'25%\' colspan=\'2\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t<th align=\'center\' width=\'25%\' colspan=\'2\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t</tr>\n\t\n\t<tr>\n\t\t\t<td class=label colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\n\t<TR>\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\n\t\t\t<td class=\'QUERYDATA\'width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td class=\'fields\' COLSPAN=\'2\'>\n\n\t\t\t\t<select name=\'area_code\' id=\'area_code\'  onchange=clearBed();>\n\t\t\t\t<option value=\'\'>---------- ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ----------</option>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="> ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </option>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</select>&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\t\n\t\t</td>\n\t</tr>\n\t\n\t<tr>\n\t\t\t<td class=\'LABEL\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t\t<td class=\'QUERYDATA\' align=\'left\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\n\t\t\t<input type=\'hidden\' name=\'old_bed_no\' id=\'old_bed_no\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\n\t\t     <td class=\'fields\' COLSPAN=\'2\'>\n\t\t\t<input type=\'text\' name=\'bed_no\' id=\'bed_no\' size=\'8\' disabled maxlength=\'8\'onKeyPress=\"return CheckForSpecChars(event)\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  onBlur=\'BedCheck();\' ><input type=button class=button value=\'?\' name=\'bed_button\' id=\'bed_button\' disabled onClick=\'searchBed(this,bed_no);\' ></td>\n\t</tr>\t\t\n\n\t<tr> \n\t\t\t<td class=\'LABEL\'  >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t<td class=\'fields\' COLSPAN=\'2\'>\n\t\t \t<input type=\'text\' name=\'assign_tmt_area_time\' id=\'assign_tmt_area_time\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' size=\'16\' maxlength=\'16\' onblur=\'validateDate2(this);\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"document.forms[0].assign_tmt_area_time.select();return showCalendar(\'assign_tmt_area_time\', null, \'hh:mm\' );\"style=\"cursor=\'hand\'\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\n\t</tr>\t\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\n\t<tr>\n\t\t\t<td class=\'LABEL\' >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td class=\'QUERYDATA\' id = \'rfidtag\' align=\'left\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t<input type=\'hidden\' name=\'old_rfidtag\' id=\'old_rfidtag\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t     <td class=\'fields\' COLSPAN=\'2\'>\n\t\t\t<input type=\'text\' name=\'RFID_Tag\' id=\'RFID_Tag\' size=\'20\'  maxlength=\'20\' onBlur=\'blurRFID(this);\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ><input type=button class=button value=\'?\' name=\'RFID_Tag_button\' id=\'RFID_Tag_button\'  onClick=\'searchRFID(this,RFID_Tag);\' ></td>\n\t</tr>\t\t\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n<!-- \t<tr>\n\t\t\t<td class=\'LABEL\'  align=\'right\' nowrap width=\'10%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t<td align=\'left\'>\n\t\t\t <input type=\'checkbox\'  name=\'printcommand\' id=\'printcommand\' value=\'Y\' onClick=\'\'  > \n\t\t\t</td>\n\t\t\t<td align=\'left\'>&nbsp;</td>\n\t</tr> -->\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<tr><td colspan=8 class=label>&nbsp;</td></tr>\n\t</table>\n\t<p align=\'center\'>\n\t<input type=\'button\' class=\'BUTTON\' name=\'ok\' id=\'ok\'\t  value=\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'   onClick=\'return assignArea();\'>&nbsp;\n\t<input type=\'button\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\'cancelOperation()\'>\n\t</p>\n\t<br>\n\t\t<input type=\"Hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\'hidden\' name=\'sys_date_time\' id=\'sys_date_time\'\tvalue=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'\t\tvalue=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=\'hidden\' name=\'area_desc\' id=\'area_desc\'\t\tvalue=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'\t\tvalue=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=\'hidden\' name=\'assignDtime\' id=\'assignDtime\'\t\tvalue=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\'hidden\' name=\'select_pmstatus\' id=\'select_pmstatus\'\t\tvalue=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=\'hidden\' name=\'area_type\' id=\'area_type\'\t\tvalue=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=\'hidden\' name=\'assign_area_code\' id=\'assign_area_code\'\t\tvalue=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<input type=\'hidden\' name=\'CLAIMANT_TYPE\' id=\'CLAIMANT_TYPE\'\t\tvalue=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t<input type=\'hidden\' name=\'RELEASE_TO_FACILITY\' id=\'RELEASE_TO_FACILITY\'\t\tvalue=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t</form>\n\t</center>\n\t</body>\n\t</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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
	 request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String locale = ((String)session.getAttribute("LOCALE"));
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;
	Statement			stmt	=	null;
	ResultSet			rset	=	null;
	String sqlstr				=	"";	
	String area_code			=	"";
	String short_desc			=	"";
	String select_registration	=	"";
	String select_name			=	"";
	String select_sex			=	"";
	String select_area_desc		=	"";
	String sysdate				=	"";
	String select_pmyn			=	"";
	String assign_area_code		=	"";
	String select_pmstatus		=	"";
	String facility_id			=	"";
	String sys_date				=	"";
	String sys_date_time		=	"";
	String sys_date_converted	=	"";
	String bed_no				=	"";
	String rfid_tag_num				=	"";
	String patient_id          =	"";
	String area_prop			=	"";
	String assignDtime          =   "";
	String area_type            ="";
	String CLAIMANT_TYPE		=""; //Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	String RELEASE_TO_FACILITY  =""; //Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	assign_area_code	=	request.getParameter("assign_area_code");	
	assign_area_code	=	((assign_area_code==null) || (assign_area_code.equals(""))) ? "" : assign_area_code;
	select_registration	=	(request.getParameter("select_registration")==null)? "" : request.getParameter("select_registration");
	select_name			=	(request.getParameter("select_name")==null)? "" : request.getParameter("select_name");
	select_sex			=	(request.getParameter("select_sex")==null)? "" : request.getParameter("select_sex");
	select_area_desc	=	(request.getParameter("select_area_desc")==null)? "" : request.getParameter("select_area_desc");
	select_area_desc	=	java.net.URLDecoder.decode(select_area_desc);
	select_pmyn			=	request.getParameter("select_pmyn");
	select_pmyn			=	((select_pmyn==null) || (select_pmyn.equals(""))) ? "" : select_pmyn;
	select_pmstatus		=	request.getParameter("select_pmstatus");
	select_pmstatus		=	((select_pmstatus==null) || (select_pmstatus.equals(""))) ? "" : select_pmstatus;
	bed_no				=	request.getParameter("bed_no");
	area_type           =(request.getParameter("area_type")==null)? "" : request.getParameter("area_type");
	bed_no				=	((bed_no==null) || (bed_no.equals(""))) ? "" : bed_no;
	patient_id			=	request.getParameter("patient_id");
	patient_id			=	((patient_id==null) || (patient_id.equals(""))) ? "" : patient_id;
	CLAIMANT_TYPE	=	request.getParameter("CLAIMANT_TYPE");	//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	CLAIMANT_TYPE	=	((CLAIMANT_TYPE==null) || (CLAIMANT_TYPE.equals(""))) ? "" : CLAIMANT_TYPE; //Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY	=	request.getParameter("RELEASE_TO_FACILITY");//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	RELEASE_TO_FACILITY	=	((RELEASE_TO_FACILITY==null) || (RELEASE_TO_FACILITY.equals(""))) ? "" : RELEASE_TO_FACILITY;//Added Aginst Bru-HIMS-CRF-366 [IN-039612]
	try
	{
		con					=	(Connection)ConnectionManager.getConnection(request);
		facility_id			=	(String)session.getValue("facility_id");
		String sql2			=	"select to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_date from dual";
		stmt				=	con.prepareStatement(sql2);
		rset				=	stmt.executeQuery(sql2);
		if(rset!=null && rset.next())
		{
			sys_date=rset.getString(1);
			if(sys_date!=null && !sys_date.equals(""))
				sys_date_converted = DateUtils.convertDate(sys_date,"DMYHM","en",localeName); 	
		}
		stmt.close();
		rset.close();
		StringBuffer sql1	= new StringBuffer();
		sql1.append("select  to_char(ASSIGN_DATE_TIME,'dd/mm/yyyy hh24:mi')ASSIGN_DATE_TIME  from MO_MORTUARY_REGN where REGISTRATION_NO=? and FACILITY_ID =?");
		pstmt				=	con.prepareStatement(sql1.toString());
		pstmt.setString(1,select_registration) ;
		pstmt.setString(2,facility_id) ;
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
		sys_date_time	= rs.getString(1);
		sysdate 		= (sys_date_time == null)?"":sys_date_time;
		
		assignDtime=sysdate;

		if(assignDtime!=null && !assignDtime.equals(""))
			assignDtime = DateUtils.convertDate(assignDtime,"DMYHM","en",localeName); 	
		
		sql1.setLength(0);
		pstmt.close();
		rs.close();
		if (sysdate.equals(""))
		{
			sysdate=sys_date;
		}  
		String body_received_date="";
		String ser_desc="";
        
		//sql1.append("select body_received_date,service_desc from mo_mortuary_regn_vw where REGISTRATION_NO =? and FACILITY_ID =?");
		sql1.append("select body_received_date,RFID_TAG_NUM, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,'"+localeName+"','2') service_desc from mo_mortuary_regn_vw where REGISTRATION_NO =? and FACILITY_ID =?");

		pstmt = con.prepareStatement(sql1.toString());
        pstmt.setString(1,select_registration) ;
		pstmt.setString(2,facility_id) ;
		rs=pstmt.executeQuery();
 	    while(rs.next())
		{
		   body_received_date = rs.getString(1);
		   rfid_tag_num			  = rs.getString(2)==null?"":rs.getString(2);
		   ser_desc			  = rs.getString(3);
		}
		sql1.setLength(0);
		pstmt.close();
		rs.close();
		JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
		json			 = eMO.MOCommonBean.getMOParam(con, facility_id); 
		String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(body_received_date));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(select_registration));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(select_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(select_sex));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ser_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(select_area_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
	
		if (assign_area_code.equalsIgnoreCase("Unassigned"))
		{
			//Condition Newly Added Against Bru-HIMS-CRF-366 [IN-039612]	
			if (select_pmyn.equalsIgnoreCase("Y") && CLAIMANT_TYPE.equalsIgnoreCase("F")){
				sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' order by short_desc";
			}
		else if (select_pmyn.equalsIgnoreCase("Y")){
			sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('R') order by short_desc";
		}
		else if (select_pmyn.equalsIgnoreCase("N"))
		{
		 	sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('P') order by short_desc";
		}
		}else			
		{
			//Condition Newly Added Against Bru-HIMS-CRF-366 [IN-039612]	
			if (select_pmyn.equalsIgnoreCase("Y") && CLAIMANT_TYPE.equalsIgnoreCase("F")){
				sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' order by short_desc";
			}
		
		else if (select_pmyn.equalsIgnoreCase("Y")){
			sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('R') order by short_desc";
		}
			else if(select_pmyn.equalsIgnoreCase("N"))
			{
				sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E' and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('P') order by short_desc";
			}
		}		
		if ((select_pmstatus.equalsIgnoreCase("E")) || (select_pmstatus.equalsIgnoreCase("C")))
		{
			sqlstr	=	"select area_code, short_desc from MO_AREA_LANG_VW where eff_status='E'  and facility_id = '"+facilityId+"' and language_id='"+locale+"' and Area_Type not in ('P') order by short_desc";
		}
		stmt	=	con.createStatement();
	    rset	=	stmt.executeQuery(sqlstr);
		
		
		while (rset!=null && rset.next())
		{
			area_code=rset.getString("area_code");
			short_desc=rset.getString("short_desc");
			if(assign_area_code.equals(area_code))	
				{
					area_prop	   	= "selected";
				}
				else
				{
					area_prop	    = "";
				}
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(area_prop));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
			if(rset!=null) rset.close();
		    if(stmt!=null) stmt.close(); 
		
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(assignDtime));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(sys_date_converted));
            _bw.write(_wl_block35Bytes, _wl_block35);

if(enable_rfid_yn.equals("Y")) //  added by mujafar for ML-MMOH-CRF-0996
{

            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rfid_tag_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rfid_tag_num));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rfid_tag_num));
            _bw.write(_wl_block40Bytes, _wl_block40);

}


            _bw.write(_wl_block41Bytes, _wl_block41);
	
		if(pstmt!=null) pstmt.close();
		if(stmt!=null)   stmt.close();
		if(rs!=null)     rs.close();
		if(rset!=null)   rset.close();
	}
	catch(Exception e)
	{
		out.println("Exception@1: " +e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(select_registration));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(select_area_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(assignDtime));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(select_pmstatus));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(assign_area_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
//Added Against Bru-HIMS-CRF-366 [IN-039612] 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(CLAIMANT_TYPE));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(RELEASE_TO_FACILITY));
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RegNo.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.current.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.AssignReAssign.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.area.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RFIDTag.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
