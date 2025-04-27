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

public final class __accessrightsdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/AccessRightsDtl.jsp", 1709121630731L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tP.Anuradha\n*\tCreated On\t\t:\t19 Jan 2005\n-->\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script> -->\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eRS/js/RSMessages.js\"></script> -->\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/AccessRights.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  onMouseDown=\"CodeArrest()\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =",";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =")\' onKeyDown=\"lockKey()\" >\n<form name=\'AccessRightsDetail_form\' id=\'AccessRightsDetail_form\' action=\"../../eRS/jsp/AccessRightsDtl.jsp\" method=\'post\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table cellpadding=0 cellspacing=0 border=1 width=\"100%\">\n<tr>\n\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th width=\'16%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th width=\'8%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t<th width=\'12%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t<th width=\'15%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t<th width=\'5%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<tr>\n\t<td width=\'20%\' align=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td width=\'16%\' align=\"center\"><input type=checkbox name=\"Setup\" id=\"Setup\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="></input></td>\n\t<td width=\'8%\' align=\"center\"><input type=checkbox name=\"Allocate\" id=\"Allocate\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="></input></td>\n\t<td width=\'12%\' align=\"center\"><input type=checkbox name=\"Reallocate\" id=\"Reallocate\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="></input></td>\n\t<td width=\'15%\' align=\"center\"><input type=checkbox name=\"Cancel\" id=\"Cancel\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="></input></td>\n\t<td width=\'5%\' align=\"center\"><input type=checkbox name=\"select\" id=\"select\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></input></td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</table>\n<input type=hidden name=\"setup\" id=\"setup\" value=\"\">\n<input type=hidden name=\"allocate\" id=\"allocate\" value=\"\">\n<input type=hidden name=\"reallocate\" id=\"reallocate\" value=\"\">\n<input type=hidden name=\"cancel\" id=\"cancel\" value=\"\">\n<input type=hidden name=\"dbaction\" id=\"dbaction\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=hidden name=\"select1\" id=\"select1\" value=\"\">\n<input type=hidden name=\"workplace_code\" id=\"workplace_code\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=hidden name=\"workplace\" id=\"workplace\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<input type=hidden name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=hidden name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n<table border=0 width=\'98%\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t  <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a>\n    <input type=hidden name=\'whichP age\' id=\'whichP age\' value=\'next\'>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</td>\n</tr>\t\n</table>\n<input type=hidden name=\"Record_Count\" id=\"Record_Count\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<table cellpadding=0 cellspacing=0 border=1 id=\"workplace_table\" width=\"100%\">\n<tr>\n<th width=\'40%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th>\n<th width=\'16%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</th>\n<th width=\'8%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</th>\n<th width=\'12%\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n<th width=\'15%\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</th>\n<th width=\'5%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<input type=checkbox name=\"selectall\" id=\"selectall\" onClick=\'selectAll(this,";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")\'></th>\n</tr>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<tr>\n<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" width=\'40%\' align=\"left\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n<td class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" width=\'16%\' align=\"center\"><input type=checkbox name=\"Setup";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"Setup";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="></input></td>\n<td class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" width=\'8%\' align=\"center\"><input type=checkbox name=\"Allocate";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"Allocate";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" width=\'12%\' align=\"center\"><input type=checkbox name=\"Reallocate";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"Reallocate";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" width=\'15%\' align=\"center\"><input type=checkbox name=\"Cancel";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"Cancel";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" width=\'5%\' align=\"center\"><input type=checkbox name=\"select";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"select";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="></input></td>\n<input type=hidden name=\"db_action";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"db_action";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=hidden name=\"workplace_code";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"workplace_code";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n</tr>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</table>\n<input type=hidden name=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=hidden name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            webbeans.eCommon.RecordSet AccessRights= null;synchronized(session){
                AccessRights=(webbeans.eCommon.RecordSet)pageContext.getAttribute("AccessRights",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AccessRights==null){
                    AccessRights=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("AccessRights",AccessRights,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection conn=null;

PreparedStatement stmt=null;
PreparedStatement workplace_stmt=null;
PreparedStatement count_stmt=null;
PreparedStatement stmt_yn=null;

ResultSet workplace_rset=null;
ResultSet count_rset=null;
ResultSet rset=null;
ResultSet rset_yn=null;

conn = ConnectionManager.getConnection(request);
String setup_check="";
String allocate_check="";
String reallocate_check="";
String cancel_check="";
String select_check="";

String workplace1=request.getParameter("workplace");

if(workplace1 == null){workplace1="";}

String workplace_code1=request.getParameter("workplace_code");
String facility_id = (String)session.getAttribute("facility_id");


int start = 0 ;
int end = 0 ;

String from = request.getParameter("from");
String to = request.getParameter("to");

if ( from == null )
		start = 0;
else
		start = Integer.parseInt(from) ;

if ( to == null )
	  	end = 11;
else
		end = Integer.parseInt(to) ;

if(workplace1==null)workplace1="";
if(workplace_code1==null)workplace_code1="";

String user_id=request.getParameter("user_id");
String req_start="";
String req_end="";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);

if(workplace1!="" && workplace_code1!="")
{


            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	String setup="";
    String allocate="";
    String reallocate="";
    String cancel="";
	String dbaction="";

	//String sql_yn="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a,rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code =? and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code =? and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from   rs_access_rights where appl_user_id =?) order by 2";
	String sql_yn="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace_lang_vw  a,rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code =? and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code and a.language_id = ? UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace_lang_vw i where i.facility_id =? and i.workplace_code =? and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from   rs_access_rights where appl_user_id =?) and i.language_id = ? order by 2";

    stmt_yn=conn.prepareStatement(sql_yn);
	stmt_yn.setString(1,user_id);
	stmt_yn.setString(2,facility_id);
	stmt_yn.setString(3,workplace_code1);
	stmt_yn.setString(4,locale);
	stmt_yn.setString(5,user_id);
	stmt_yn.setString(6,facility_id);
	stmt_yn.setString(7,workplace_code1);
	stmt_yn.setString(8,user_id);
	stmt_yn.setString(9,locale);

	rset_yn=stmt_yn.executeQuery();
		if(rset_yn!=null)
	{
		while(rset_yn.next())
		{
			setup=rset_yn.getString("setup_requirement_yn");
			allocate=rset_yn.getString("allocate_yn");
			reallocate=rset_yn.getString("reallocate_yn");
			cancel=rset_yn.getString("cancel_schedule_yn");
			dbaction=rset_yn.getString("db_action");

			if(dbaction.equals("U"))
			{
				select_check="checked";
			}
			else if(dbaction.equals("I"))
			{
				select_check="";
			}


			if(setup.equals("Y"))
			{
				setup_check="checked";
			}
			else
			{
				setup_check="";
			}

			if(allocate.equals("Y"))
			{
				allocate_check="checked";
			}
			else
			{
				allocate_check="";
			}

			if(reallocate.equals("Y"))
			{
				reallocate_check="checked";
			}
			else
			{
				reallocate_check="";
			}

			if(cancel.equals("Y"))
			{
				cancel_check="checked";
			}
			else
			{
				cancel_check="";
			}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(workplace1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(setup_check));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(allocate_check));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(reallocate_check));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cancel_check));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(select_check));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dbaction));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(workplace_code1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(workplace1));
            _bw.write(_wl_block28Bytes, _wl_block28);

}
else if(workplace1=="" && workplace_code1=="")
{
    req_start=(request.getParameter("start")==null)?"0":request.getParameter("start");
	req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");

	String flagSelect=request.getParameter("fromSearch");
	int k=1;

	String setup_yn="";
	String allocate_yn="";
	String reallocate_yn="";
	String cancel_yn="";
	String workplace_value="";
	String select_yn="";
	String db_action="";

    try
	{
	if(flagSelect !=null){
			AccessRights.clearAll();
			//String sqlinsVals="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code, i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn, 'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) order by 2";
			String sqlinsVals="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace_lang_vw a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code and a.language_id = ? UNION ALL select i.workplace_code workplace_code, i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn, 'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace_lang_vw i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) and i.language_id = ? order by 2";
			stmt=conn.prepareStatement(sqlinsVals);
			stmt.setString(1,user_id);
			stmt.setString(2,facility_id);
			stmt.setString(3,locale);
			stmt.setString(4,user_id);
			stmt.setString(5,facility_id);
			stmt.setString(6,user_id);
			stmt.setString(7,locale);

			rset = stmt.executeQuery();
				if(rset !=null){
				while(rset.next()){
						workplace_value=rset.getString("workplace_code");
						setup_yn=rset.getString("setup_requirement_yn");
						allocate_yn=rset.getString("allocate_yn");
						reallocate_yn=rset.getString("reallocate_yn");
						cancel_yn=rset.getString("cancel_schedule_yn");
						db_action=rset.getString("db_action");

						if(db_action.equals("U")) select_yn="Y";
						else if(db_action.equals("I")) select_yn="N";

			  			ArrayList alist1=new ArrayList();

						alist1.add(workplace_value);
						alist1.add(select_yn);
						alist1.add(setup_yn);
						alist1.add(allocate_yn);
						alist1.add(reallocate_yn);
						alist1.add(cancel_yn);
						alist1.add(db_action);

                       AccessRights.putObject(alist1);
				   }
				}	
			}

			String select1="";
			String setup1="";
			String allocate1="";
			String reallocate1="";
			String cancel1="";
			String db_action1="";
			String workplacecode1="";


			if(from != null && to != null){
            	for(k=Integer.parseInt(req_start);k<(Integer.parseInt(req_end)); k++){
					 if(request.getParameter("select"+(k))!=null)
						 select1="Y";
					 else if(request.getParameter("select"+(k))==null)
						 select1="N";
                     if(request.getParameter("Setup"+(k))!=null)
						 setup1="Y";
					 else if(request.getParameter("Setup"+(k))==null)
						 setup1="N";
					 if(request.getParameter("Allocate"+(k))!=null)
						 allocate1="Y";
					 else if(request.getParameter("Allocate"+(k))==null)
						 allocate1="N";
					  if(request.getParameter("Reallocate"+(k))!=null)
						 reallocate1="Y";
					 else if(request.getParameter("Reallocate"+(k))==null)
						 reallocate1="N";
					  if(request.getParameter("Cancel"+(k))!=null)
						 cancel1="Y";
					 else if(request.getParameter("Cancel"+(k))==null)
						 cancel1="N";
					 db_action1=request.getParameter("db_action"+(k));
                     workplacecode1=request.getParameter("workplace_code"+(k));

			 		 ArrayList alist_checkedOnes=new ArrayList();

             			 alist_checkedOnes.add(workplacecode1);
             			 alist_checkedOnes.add(select1);
						 alist_checkedOnes.add(setup1);
						 alist_checkedOnes.add(allocate1);
						 alist_checkedOnes.add(reallocate1);
						 alist_checkedOnes.add(cancel1);
						 alist_checkedOnes.add(db_action1);

						 AccessRights.setObject(k,alist_checkedOnes);
				}
			}


     String sql_count="select count(workplace_code) count from (select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn,nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) order by 2)";

	 count_stmt=conn.prepareStatement(sql_count);
	 count_stmt.setString(1,user_id);
	 count_stmt.setString(2,facility_id);
	 count_stmt.setString(3,user_id);
	 count_stmt.setString(4,facility_id);
	 count_stmt.setString(5,user_id);

    count_rset=count_stmt.executeQuery();
	int record_count=0;
	if(count_rset!=null)
	{
		while(count_rset.next())
		{
			record_count=count_rset.getInt("count");
		}
	}

    String classValue="";

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(start));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(end));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(end));
            _bw.write(_wl_block33Bytes, _wl_block33);

if (!(start<=1))
{

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

}
if (!((start+11)>=record_count))
{

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block47Bytes, _wl_block47);

	//String sql="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn,nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) order by 2";
	String sql="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn,nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace_lang_vw a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code and a.language_id = ? UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace_lang_vw i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) and i.language_id = ? order by 2";

	workplace_stmt=conn.prepareStatement(sql);
	workplace_stmt.setString(1,user_id);
	workplace_stmt.setString(2,facility_id);
	workplace_stmt.setString(3,locale);
	workplace_stmt.setString(4,user_id);
	workplace_stmt.setString(5,facility_id);
	workplace_stmt.setString(6,user_id);
	workplace_stmt.setString(7,locale);

		String workplace_desc="";
		String workplace_code="";
		String workplace="";
		String allocate="";
		String reallocate="";
		String cancel="";
		String setup="";
		String dbaction="";
		String select="";

	workplace_rset=workplace_stmt.executeQuery();

   int i=1;

	if ( start != 0 )
		 for( int j=1; j<=start; i++,j++ )
		 {
			workplace_rset.next() ;
		 }

    if(workplace_rset!=null)
	{
	while ( workplace_rset.next() && i<=end)
	{
		    workplace_code=workplace_rset.getString("workplace_code");
			workplace_desc=workplace_rset.getString("workplace_desc");
         
			for(int l=0;l<AccessRights.getSize();l++)
		    {
				ArrayList al1=new ArrayList();
				al1=(ArrayList)AccessRights.getObject(l);
				workplace=(String)al1.get(0);
				select=(String)al1.get(1);
				setup=(String)al1.get(2);
				allocate=(String)al1.get(3);
				reallocate=(String)al1.get(4);
				cancel=(String)al1.get(5);
				dbaction=(String)al1.get(6);
    			if(workplace_code.equals(workplace))
				{
					if(select.equals("Y"))
					{
						    select_check="checked";
					}
					else if(select.equals("N"))
					{
						    select_check="";
					}
        		    if(setup.equals("Y"))
					{
			            	setup_check="checked";
					}
		            else if(setup.equals("N"))
					{
				            setup_check="";
					}
		            if(allocate.equals("Y"))
					{
						allocate_check="checked";
					}
		            else if(allocate.equals("N"))
					{
				            allocate_check="";
					}
		            if(reallocate.equals("Y"))
					{
				             reallocate_check="checked";
					}
                   	else if(reallocate.equals("N"))
					{
				             reallocate_check="";
					}
		            if(cancel.equals("Y"))
					{
				             cancel_check="checked";
					}
    	            else if(reallocate.equals("N"))
					{
			                 cancel_check="";
					}
					break;
				}
				else
				{
					select_check="";
					setup_check="";
					allocate_check="";
					reallocate_check="";
					cancel_check="";
				}
			}

       	if (i%2 == 0)
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(workplace_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(setup));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(setup_check));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(allocate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allocate_check));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(reallocate));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reallocate_check));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(cancel));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cancel_check));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(select));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(select_check));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(dbaction));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block68Bytes, _wl_block68);

	i++;
	}
}
}
catch(Exception exp)
{
	exp.toString();
}
finally
{
	try
	{
	if(rset_yn!=null) rset_yn.close();
	if(stmt_yn!=null) stmt_yn.close();

	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();

	if(count_rset!=null) count_rset.close();
	if(count_stmt!=null) count_stmt.close();

	if(workplace_rset!=null) workplace_rset.close();
	if(workplace_stmt!=null) workplace_stmt.close();

	ConnectionManager.returnConnection(conn,request);
	session.setAttribute("AccessRights",AccessRights);
	}
	catch(Exception exp)
	{
		exp.toString();
	}
}
}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Workplace.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.SetUpReq.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Allocate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Re-allocate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.CancelSch.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Workplace.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.SetUpReq.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Allocate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Re-allocate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.CancelSch.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
