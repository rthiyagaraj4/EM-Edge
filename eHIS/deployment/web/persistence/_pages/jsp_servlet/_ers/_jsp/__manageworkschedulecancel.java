package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __manageworkschedulecancel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleCancel.jsp", 1709121636668L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tP.Anuradha\n*\tCreated On\t\t:\t16 Feb 2005\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eRS/js/RSMessages.js\"></script> -->\n<script language=\"javascript\" src=\"../../eRS/js/ManageWorkScheduleCancel.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t\t<form name=\"ManageWorkScheduleCancel_Form\" id=\"ManageWorkScheduleCancel_Form\" method=\"post\" action=\"../../servlet/eRS.ManageWorkScheduleCancelServlet\" target=\"MessageFrame\">\n\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\">\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\"20%\" class=\"data\" align=\"right\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;&nbsp;</td>\n\t\t\t<td width=\"80%\" class=\"label\" align=\"left\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\">\n\t\t\t<tr>\n\t\t\t<th width=\"30%\" align=\"right\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t<th>&nbsp;</th>\n\t\t\t<th width=\"80%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t<input type=hidden name=\"shift_code";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"shift_code";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\"shift_start_time";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"shift_start_time";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\"shift_end_time";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"shift_end_time";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t\t\t<td class=\"label\" align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t\t<input type=hidden name=\"shift_mnemonic";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"shift_mnemonic";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\"productive_flag";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"productive_flag";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\"shift_indicator";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"shift_indicator";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\"schedule_type";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"schedule_type";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t\t\t<td align=\"center\"><input type=checkbox name=\"select";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"select";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="></input></td>\n\t\t\t\t\t\t\t<input type=hidden name=\"valid_yn";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"valid_yn";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<th>&nbsp;</th>\n\t\t\t<th>&nbsp;</th>\n\t\t\t<th>&nbsp;</th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\">\n\t\t\t<tr>\n\t\t\t<td width=\"20%\" class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;&nbsp;</td>\n\t\t\t<td width=\"80%\" align=\"left\">\n\t\t\t<select name=\"Reason\" id=\"Reason\">\n\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="----</option>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\">&nbsp;\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\"20%\" class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;&nbsp;</td>\n\t\t\t<td width=\"80%\" align=\"left\"><textarea name=\"Remarks\" cols=40 rows=4 size=\"2000\" onblur=\"checkForMax(this);\"></textarea></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\">\n\t\t\t<tr>\n\t\t\t<td width=\"87%\" align=\"right\"><input class=button type=button name=\"apply\" id=\"apply\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'onClick=\"on_apply();\">&nbsp;&nbsp;</td>\n\t\t\t<td width=\"13%\" align=\"left\"><input class=button type=button name=\"close\" id=\"close\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'onClick=\"on_close();\"></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=hidden name=\"schedule_date\" id=\"schedule_date\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t<input type=hidden name=\"total_Records\" id=\"total_Records\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t<input type=hidden name=\"requirement_id\" id=\"requirement_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t<input type=hidden name=\"staff_type\" id=\"staff_type\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<input type=hidden name=\"locn_type\" id=\"locn_type\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type=hidden name=\"role_type\" id=\"role_type\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t<input type=hidden name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<input type=hidden name=\"workplace_code\" id=\"workplace_code\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type=hidden name=\"position_code\" id=\"position_code\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=hidden name=\"staff_id\" id=\"staff_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t<input type=hidden name=\"activity_id\" id=\"activity_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t<input type=hidden name=\"curr_cancel_yn\" id=\"curr_cancel_yn\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=hidden name=\"durn_for_cancel_from_sos\" id=\"durn_for_cancel_from_sos\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t</form>\n\t\t\t</body>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn=null;

	PreparedStatement pstmt=null;
	ResultSet rset=null;

	PreparedStatement pstmt_reason=null;
	ResultSet rset_reason=null;

	PreparedStatement pstmt_sos=null;
	ResultSet rset_sos=null;

	PreparedStatement pstmt_requirement_varying=null;
	ResultSet rset_requirement_varying=null;

	PreparedStatement pstmt_requirement_constant=null;
	ResultSet rset_requirement_constant=null;

	PreparedStatement pstmt_locn=null;
	ResultSet rset_locn=null;

	PreparedStatement pstmt_staff=null;
	ResultSet rset_staff=null;

	PreparedStatement pstmt_sch_type=null;
	ResultSet rset_sch_type=null;


	PreparedStatement pstmt_sch_type1=null;
	ResultSet rset_sch_type1=null;


	PreparedStatement pstmt_activity=null;
	ResultSet rset_activity=null;

	conn = ConnectionManager.getConnection(request);

	int count=0;

	try{
		int cell_no=Integer.parseInt(request.getParameter("p_cell_no")==null?"":request.getParameter("p_cell_no"));
		String date=request.getParameter("p_date")==null?"":request.getParameter("p_date");
		String facility_id=request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
		String workplace_code=request.getParameter("p_workplace_code")==null?"":request.getParameter("p_workplace_code");
		String role_type=request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
		String staff_id=request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
		String position_code=request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
		String p_shift_code=request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");

		String schedule_date="";
		String requirement_id_varying="";
		String requirement_id_constant="";
		String requirement_id="";
		String shift_code="";
		String schedule_type="";
		String shift_desc="";
		String shift_start_time="";
		String shift_mnemonic="";
		String shift_end_time="";
		String valid_yn="";
		String activity="";
		String select_enabled="";
		String productive_flag="";
		String shift_indicator="";

		StringBuffer temp_code = new StringBuffer("'" + p_shift_code + "'");

		while(temp_code.toString().indexOf('|') != -1)	{
		   int index = temp_code.toString().indexOf('|');
		   temp_code.replace(index,index+1,"','");
		}
		p_shift_code = temp_code.toString();
//		p_shift_code=p_shift_code.substring(1,(p_shift_code.length())-1);


		String sql_sch_date="select to_char((to_date(?,'dd/mm/yyyy') + ?),'dd/mm/yyyy') schedule_date from dual";

		pstmt_sch_type1=conn.prepareStatement(sql_sch_date);
		pstmt_sch_type1.setString(1,date);
		pstmt_sch_type1.setInt(2,cell_no);

		rset_sch_type1=pstmt_sch_type1.executeQuery();
		if(rset_sch_type1!=null)	{
		  while(rset_sch_type1.next()) {
			  schedule_date=rset_sch_type1.getString("schedule_date");
		  }
		}
		
		if(pstmt_sch_type1 != null)
			pstmt_sch_type1.close();
		if(rset_sch_type1 != null)
			rset_sch_type1.close();

		String sql_activity="select rs_activity_log_seq.nextval activity_id from dual";
		pstmt_activity=conn.prepareStatement(sql_activity);
		rset_activity=pstmt_activity.executeQuery();

		if(rset_activity!=null)	{
			while(rset_activity.next()){
				activity=rset_activity.getString("activity_id");
			}
		}
		if(pstmt_activity != null)
			pstmt_activity.close();
		if(rset_activity != null)
			rset_activity.close();

		String sql_locn="select locn_type from rs_locn_for_workplace where facility_id=? and workplace_code=?";

		pstmt_locn=conn.prepareStatement(sql_locn);

		pstmt_locn.setString(1,facility_id);
		pstmt_locn.setString(2,workplace_code);

		String locn_type="";

		rset_locn=pstmt_locn.executeQuery();
		if(rset_locn!=null)	{
			while(rset_locn.next()){ 
				locn_type=rset_locn.getString("locn_type");
			}
		}
		if(pstmt_locn != null)
			pstmt_locn.close();
		if(rset_locn != null)
			rset_locn.close();

		String sql_staff="select staff_type from rs_staff_for_workplace where facility_id=? and workplace_code=? and staff_id=? and role_type=?";
		pstmt_staff=conn.prepareStatement(sql_staff);
		pstmt_staff.setString(1,facility_id);
		pstmt_staff.setString(2,workplace_code);
		pstmt_staff.setString(3,staff_id);
		pstmt_staff.setString(4,role_type);

		String staff_type="";

		rset_staff=pstmt_staff.executeQuery();

		if(rset_staff!=null){
			while(rset_staff.next()){
				staff_type=rset_staff.getString("staff_type");
			}
		}
		if(pstmt_staff != null)
			pstmt_staff.close();
		if(rset_staff != null)
			rset_staff.close();

		String sql_sos="select max_continuous_work_duration, curr_shift_cancellation_yn, durn_for_cancel_from_sos from rs_parameter where facility_id = ?";

		pstmt_sos=conn.prepareStatement(sql_sos);

		String curr_cancel_yn="";
		String durn_for_curr_cancel_from_sos="";

		pstmt_sos.setString(1,facility_id);
		rset_sos=pstmt_sos.executeQuery();
		if(rset_sos!=null){
			while(rset_sos.next()){
				curr_cancel_yn=rset_sos.getString("curr_shift_cancellation_yn")==null?"":rset_sos.getString("curr_shift_cancellation_yn");
				durn_for_curr_cancel_from_sos=rset_sos.getString("durn_for_cancel_from_sos")==null?"":rset_sos.getString("durn_for_cancel_from_sos");
			}
		}
		if(pstmt_sos != null)
			pstmt_sos.close();
		if(rset_sos != null)
			rset_sos.close();

		String sql_requirement_varying="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and requirement_type = 'V' and to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to ";

		pstmt_requirement_varying=conn.prepareStatement(sql_requirement_varying);

		pstmt_requirement_varying.setString(1,facility_id);
		pstmt_requirement_varying.setString(2,workplace_code);
		pstmt_requirement_varying.setString(3,schedule_date);

		rset_requirement_varying=pstmt_requirement_varying.executeQuery();
		if(rset_requirement_varying!=null){
			while(rset_requirement_varying.next()){
			requirement_id_varying=rset_requirement_varying.getString("requirement_id");
			}
		}
		if(pstmt_requirement_varying != null)
			pstmt_requirement_varying.close();
		if(rset_requirement_varying != null)
			rset_requirement_varying.close();

		if(requirement_id_varying==""){
			String sql_requirement_constant="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and requirement_type = 'C' and requirement_date_fm is null and requirement_date_to is null";

			pstmt_requirement_constant=conn.prepareStatement(sql_requirement_constant);

			pstmt_requirement_constant.setString(1,facility_id);
			pstmt_requirement_constant.setString(2,workplace_code);


			rset_requirement_constant=pstmt_requirement_constant.executeQuery();
			if(rset_requirement_constant!=null){
				while(rset_requirement_constant.next()){
					requirement_id_constant=rset_requirement_constant.getString("requirement_id");
				}
			}
			if(pstmt_requirement_constant != null)
				pstmt_requirement_constant.close();
			if(rset_requirement_constant != null)
				rset_requirement_constant.close();
		}

		if(requirement_id_varying.equals(""))
			requirement_id=requirement_id_constant;
		else if(!requirement_id_varying.equals(""))
			requirement_id=requirement_id_varying;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(schedule_date));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			//String sql="select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss') shift_end_time,decode('Y','N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift a, rs_work_schedule b where a.shift_code in ("+p_shift_code+") and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key,	to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'),	to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in ("+p_shift_code+") and a.shift_code=b.shift_code";
			String sql="select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss') shift_end_time,decode('Y','N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift_lang_vw a, rs_work_schedule b where a.shift_code in ("+p_shift_code+") and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time and a.language_id = ? union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'), to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in ("+p_shift_code+") and a.shift_code=b.shift_code and a.language_id = ?";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,durn_for_curr_cancel_from_sos);
			pstmt.setString(2,durn_for_curr_cancel_from_sos);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,workplace_code);
			pstmt.setString(5,role_type);
			pstmt.setString(6,staff_id);
			pstmt.setString(7,schedule_date);
			pstmt.setString(8,locale);
			pstmt.setString(9,facility_id);
			pstmt.setString(10,workplace_code);
			pstmt.setString(11,role_type);
			pstmt.setString(12,staff_id);
			pstmt.setString(13,schedule_date);
			pstmt.setString(14,locale);

			rset=pstmt.executeQuery();
			if(rset!=null)	{
				while(rset.next())	{
					productive_flag=rset.getString("productive_flag");
					shift_indicator=rset.getString("shift_indicator");
					shift_code=rset.getString("shift_code");
					shift_desc=rset.getString("shift_desc");
					shift_mnemonic=rset.getString("shift_mnemonic");
					shift_start_time=rset.getString("shift_start_time");
					shift_end_time=rset.getString("shift_end_time");
					valid_yn=rset.getString("valid_yn");
					if(valid_yn.equals("Y")){
						select_enabled="enabled";
						count++;
					}
					else if(valid_yn.equals("N")){
						select_enabled="disabled";
					}

					String sql_sch_type="select schedule_type from rs_work_schedule where facility_id=? and workplace_code=? and schedule_date=to_date(?,'dd/mm/yyyy') and staff_id=? and shift_code=?";

					pstmt_sch_type=conn.prepareStatement(sql_sch_type);

					pstmt_sch_type.setString(1,facility_id);
					pstmt_sch_type.setString(2,workplace_code);
					pstmt_sch_type.setString(3,schedule_date);
					pstmt_sch_type.setString(4,staff_id);
					pstmt_sch_type.setString(5,shift_code);

					rset_sch_type=pstmt_sch_type.executeQuery();

					if(rset_sch_type!=null)	{
						while(rset_sch_type.next()){
							schedule_type=rset_sch_type.getString("schedule_type");

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(shift_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shift_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shift_start_time));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shift_end_time));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shift_mnemonic));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(productive_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shift_indicator));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(schedule_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(select_enabled));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(valid_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);

						}
					}
				    if(pstmt_sch_type!=null) pstmt_sch_type.close();
				   if(rset_sch_type!=null) rset_sch_type.close();

				}
			}
			if(pstmt != null)
				pstmt.close();
			if(rset != null)
				rset.close();

            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

			//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code='CS' order by reason_desc";
			String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where activity_type_code='CS' and language_id = ? order by reason_desc";
			pstmt_reason= conn.prepareStatement(sql_reason);
			pstmt_reason.setString(1,locale);
			rset_reason=pstmt_reason.executeQuery();
			if(rset_reason!=null){
				while(rset_reason.next()){
					String reason_code=rset_reason.getString("reason_code");
					String reason_desc=rset_reason.getString("reason_desc");

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(reason_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(reason_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);

				}
				if(pstmt_reason != null)
					pstmt_reason.close();
				if(rset_reason != null)
					rset_reason.close();
			}

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(schedule_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(requirement_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(activity));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(curr_cancel_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(durn_for_curr_cancel_from_sos));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
		catch(Exception exp){
			out.println(exp.toString());
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();

				if(pstmt_reason!=null) pstmt_reason.close();
				if(rset_reason!=null) rset_reason.close();

				if(pstmt_sos!=null) pstmt_sos.close();
				if(rset_sos!=null) rset_sos.close();

				if(pstmt_requirement_varying!=null) pstmt_requirement_varying.close();
				if(rset_requirement_varying!=null) rset_requirement_varying.close();

				if(pstmt_requirement_constant!=null) pstmt_requirement_constant.close();
				if(rset_requirement_constant!=null) rset_requirement_constant.close();

				if(pstmt_locn!=null) pstmt_locn.close();
				if(rset_locn!=null) rset_locn.close();

				if(pstmt_staff!=null) pstmt_staff.close();
				if(rset_staff!=null) rset_staff.close();

				if(pstmt_sch_type!=null) pstmt_sch_type.close();
				if(rset_sch_type!=null) rset_sch_type.close();

				if(pstmt_activity!=null) pstmt_activity.close();
				if(rset_activity!=null) rset_activity.close();

				ConnectionManager.returnConnection(conn,request);
			}
			catch(Exception exp){
				out.println(exp.toString());
			}
		}

            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ChangeShift.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ScheduleDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.AllocatedShifts.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apply.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
