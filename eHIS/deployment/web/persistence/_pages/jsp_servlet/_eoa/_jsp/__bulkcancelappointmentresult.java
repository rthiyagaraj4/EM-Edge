package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __bulkcancelappointmentresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/BulkCancelAppointmentResult.jsp", 1729083034545L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n    ";
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

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\n\t\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\"../../eOA/js/BulkCancelAppointment.js\"></script>\n\n\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\'onKeyDown = \'lockKey()\' >\n\t<form name=\'QueryApptForPatient\' id=\'QueryApptForPatient\'>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t<!-- <script>\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t</script> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<p align=\'right\'>\n\t\t<table border=\"0\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td align =\'right\' id=\'prev\'><a href=\"../../eOA/jsp/BulkCancelAppointmentResult.jsp?operation_mode=Previous&start_index=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&end_index=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&oper_stn_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&called_for=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&practcode=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&clinic_type=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&res_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&cliniccode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&appttodate=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&apptfromdate=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a></td>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\"../../eOA/jsp/BulkCancelAppointmentResult.jsp?operation_mode=Next&start_index=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</tr>\n\t\t</table>\n\t</p>\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\'id=\'vv\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td> \n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\n\t\t\t\t<tr onMouseOver=\'hideToolTip()\'>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' nowrap><input type=\"checkbox\"  name=\'selectall";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'selectall";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onclick=\"show_second(this,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\" checked></input>\t<a href=\"javascript:callDummy()\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' onClick=\"displaydet_for_sec(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\',\t\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'N\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\')\" nowrap> \n\t\t\t\t\t\t\t<input type=\"checkbox\"  name=\'selectall";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' checked></input><a href=\"javascript:callDummy()\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a></td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td  title = \'Forced Appointment\' class = \'OAFORCED\'  nowrap> <input type=\"checkbox\"  name=\'selectall";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' checked></input>\n\t\t\t\t\t<a href=\"javascript:callDummy()\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" nowrap onClick=hideToolTip()>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<td nowrap class=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<a href=\"javascript:show_Reference_details(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\')\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\n\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" nowrap onClick=hideToolTip()>\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" nowrap >\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&nbsp;,";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t\n\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\t\t\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="  \n\t</table>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t\t</table>\n\t</div>\t \n</center>\n<input type=\'hidden\' name=\'canc_appt_yn\' id=\'canc_appt_yn\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n</form>\n</body>\n<script>\n\t\n\tif(parent.frames[1].document.forms[0].select)\n \tparent.frames[1].document.forms[0].select.disabled=false;\n\n</script>\t\n</html>\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet apptRecordSet= null;synchronized(session){
                apptRecordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("apptRecordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(apptRecordSet==null){
                    apptRecordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("apptRecordSet",apptRecordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	HashMap	htRecord		=	null;
	String	operation_mode	=	"";
	String fac_id		= (String) session.getValue( "facility_id" ) ;
	StringBuffer sql3=new StringBuffer("") ;

	String curr_user_id	=(String) session.getValue( "login_user" ) ;
	String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
	String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
	String apptfromdate	=	request.getParameter("apptfromdate")== null?"":request.getParameter("apptfromdate");
	String appttodate	=	request.getParameter("appttodate") == null?"":request.getParameter("appttodate");
	String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
	String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
	String called_for=request.getParameter("called_for");
	if(called_for==null) called_for="";
	String locale=(String)session.getAttribute("LOCALE");

	apptfromdate=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
	appttodate=DateUtils.convertDate(appttodate,"DMY",locale,"en");
	String patname="";
	String appt_ref_no="";
	String gender="";
	String patientid="";
	String 	apptrefno		="";
	String 	forced_yn		="";
	String cliniccode1		="";
	String patientid1="";
	String gender1="";
	String practitionerid	="";
	String apptdate			= "";
	String overbookedyn ="";	
	String apptslabfromtime= "";
	String apptslabtotime="";
	String canc_appt_yn  =""; 
	String tfr_appt_yn="";
	String tfr_appt_across_catg_yn="";
	String alcn_criteria="";
	String resourcetype="";
	String dis_age			="";
	String appt_duration	="";
	String visit_type_short_desc="";
	String clinic_short_desc="";
	String practitioner_short_name="";
	String referral_id		="";
	String classValue	 = "";
	String appt_day1	 = "";
	String visit_type_ind	 = "";
	String team_id	 = "";
	String appt_status="";
	String carelocndesc="";
	String locnType="";
	String resourceClass="";
	int cnt=0;	
	PreparedStatement stmtps=null;
	String secCnt="";
	ResultSet rsps=null;
	int		lower_limit		=	0,		upper_limit			=	0;
	int		maxDispRecord	=	14;
	String	start_index		=	"",		end_index			=	"";

	operation_mode	=	(request.getParameter("operation_mode")==null)	?	""		:	request.getParameter("operation_mode");
	start_index		=	(request.getParameter("start_index")==null)		?	"0"		:	request.getParameter("start_index");
	end_index		=	(request.getParameter("end_index")==null)		?	"14"	:	request.getParameter("end_index");

	lower_limit		=	Integer.parseInt(start_index);
	upper_limit		=	Integer.parseInt(end_index);



	Statement stmt				= null;
	ResultSet rs				= null;
	Connection conn=null;
	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try 
	{
		conn = ConnectionManager.getConnection(request);
		stmt	 = conn.createStatement();
		
		if (appt_ref_no ==null) appt_ref_no="";
		String oper_stn_id="";


			try
			{
			
				oper_stn_id=request.getParameter("oper_stn_id");
				if(oper_stn_id==null)	oper_stn_id	=	"";

					
					//String sql1 = "";
					StringBuffer sql1 = new StringBuffer();
					StringBuffer sql2 = new StringBuffer();

		

		
 
	sql1=sql1.append("SELECT NVL (b.canc_appt_yn, 'N') canc_appt_yn, (select count(appt_ref_no) cntr from oa_resource_for_appt where appt_ref_no = a.appt_ref_no and FACILITY_ID=a.FACILITY_ID) CNT, team_id, NVL (b.tfr_appt_yn, 'N') tfr_appt_yn, NVL (b.tfr_appt_across_catg_yn, 'N') tfr_appt_across_catg_yn, a.patient_id,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, get_age (a.date_of_birth) age, a.appt_type_code visit_type_ind, a.gender, TO_CHAR (a.appt_date, 'Day') appt_day1, a.appt_ref_no, NVL (a.forced_appt_yn, 'N') forced_appt_yn, TO_CHAR (a.appt_date, 'dd/mm/rrrr') appt_date, NVL (TO_CHAR (a.appt_slab_from_time, 'hh24:mi'),'00:00') appt_slab_from_time, NVL (TO_CHAR (a.appt_slab_to_time, 'hh24:mi'),'00:00') appt_slab_to_time, NVL (TO_CHAR (a.appt_duration, 'hh24:mi'), '00:00') appt_duration, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.CLINIC_CODE,'"+locale+"','1') clinic_short_desc,	decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1'), 'R', a.practitioner_id, AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name , a.clinic_code, a.practitioner_id, a.overbooked_yn, a.referral_id, a.alcn_criteria, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1') care_locn_type_desc, a.care_locn_type_ind,  a.resource_class resource_class_desc, a.resource_class");


	sql2 =sql2.append(" FROM oa_appt a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' and a.facility_id = b.facility_id and b.locn_type !='N' AND a.clinic_code = b.locn_code AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+curr_user_id+"'   AND NVL (a.clinic_code, 'X') = NVL ('"+cliniccode+"', a.clinic_code) AND NVL (a.practitioner_id, 'X') = NVL ('"+practcode+"', NVL (a.practitioner_id, 'X')) AND a.appt_date BETWEEN TO_DATE (NVL ('"+apptfromdate+"', TO_CHAR (SYSDATE, 'dd/mm/yyyy')),'dd/mm/yyyy')AND TO_DATE (NVL ('"+appttodate+"', '31/12/5000'), 'dd/mm/yyyy') AND a.appt_ref_no = NVL ('"+appt_ref_no+"', a.appt_ref_no) AND TRUNC (a.appt_date) >= TRUNC (SYSDATE) AND TO_DATE (   TO_CHAR (a.appt_date, 'dd/mm/yyyy') || ' '|| TO_CHAR (a.appt_time, 'hh24:mi'),'dd/mm/yyyy hh24:mi') >=TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi') AND appt_status != 'A'");

		
			
					
					if(!called_for.equals("")){
						sql2 = sql2.append(" and a.RECUR_WO_SEC_RES='Y'");
					}

					if(!clinic_type.equals("")){
						sql2 = sql2.append(" and a.care_locn_type_ind='"+clinic_type+"'");
					}

					if(!res_type.equals("")){
						sql2 = sql2.append(" and a.resource_class='"+res_type+"' ");
					}

					if(!apptfromdate.equals("")){
						sql2 = sql2.append(" and trunc(to_date('"+apptfromdate+"','dd/mm/yyyy')) >= trunc(sysdate) ");
					}

					
                        
					sql2= sql2.append( " order by a.appt_date,a.appt_slab_from_time, to_number(a.appt_ref_no)") ;

					
					if (rs!=null) rs.close();
					
	/*				rs 	= stmt.executeQuery("select count(1) cnt " + sql2.toString());
					
					if(rs.next())
					{
						
						cnt = rs.getInt("cnt");
						
					}
					if (rs!=null) rs.close(); */
				

						sql3.append(sql1.toString());
						sql3.append(sql2.toString());					
					//out.println("next :" +sql3.toString());
				
					
						rs 	= stmt.executeQuery(sql3.toString());
						sql2.setLength(0);
						sql3.setLength(0);
						apptRecordSet.clearAll();
						if(rs != null)
						{
						
						
					while ( rs != null && rs.next() )
					{
						
						htRecord		= new HashMap();
						try
						{

							tfr_appt_yn				=rs.getString("tfr_appt_yn");	
							secCnt					=rs.getString("CNT");
							tfr_appt_across_catg_yn	=rs.getString("tfr_appt_across_catg_yn");	
							canc_appt_yn			=rs.getString("canc_appt_yn");	
							apptrefno				=rs.getString("appt_ref_no")	;
							forced_yn				=rs.getString("FORCED_APPT_YN")	;
							cliniccode1				=rs.getString("clinic_code"); 
							practitionerid			=rs.getString("practitioner_id"); 
							if(practitionerid==null) practitionerid="";
							apptdate				=rs.getString("appt_date"); 
							overbookedyn 			=rs.getString("overbooked_yn");   
							team_id 				=rs.getString("team_id");
							carelocndesc			=rs.getString("CARE_LOCN_TYPE_DESC") ;
							resourcetype			=rs.getString("resource_class_desc");
							if(resourcetype==null) resourcetype="";
							locnType = rs.getString("care_locn_type_ind");
							resourceClass=rs.getString("resource_class");

							if(resourcetype.equals("P"))
			{
			resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(resourcetype.equals("E"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(resourcetype.equals("R"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(resourcetype.equals("O"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
						}
						catch(Exception e)
						{
							//out.println("Exception@4 : "+e);
							e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
						}
					
						team_id				= rs.getString("team_id")== null?"":rs.getString("team_id");
						patientid1				=rs.getString("patient_id")== null?"":rs.getString("patient_id");
						
						patname					=rs.getString("patient_name")== null?"":rs.getString("patient_name");
						
						dis_age					=rs.getString("age")== null?"":rs.getString("age");
						gender1					=rs.getString("gender")== null?"":rs.getString("gender");
						apptslabfromtime		=rs.getString("appt_slab_from_time")== null?"":rs.getString("appt_slab_from_time");
						apptslabtotime			=rs.getString("appt_slab_to_time")== null?"":rs.getString("appt_slab_to_time");
						appt_duration			=rs.getString("appt_duration")== null?"":rs.getString("appt_duration");
						visit_type_short_desc	=rs.getString("visit_type_short_desc")== null?"":rs.getString("visit_type_short_desc");
						clinic_short_desc		=rs.getString("clinic_short_desc")== null?"":rs.getString("clinic_short_desc");
						practitioner_short_name	=rs.getString("practitioner_short_name")== null?"":rs.getString("practitioner_short_name");
						referral_id				=rs.getString("referral_id")== null?"":rs.getString("referral_id");
						alcn_criteria				=rs.getString("alcn_criteria")== null?"":rs.getString("alcn_criteria");
						appt_day1				=rs.getString("appt_day1")== null?"":rs.getString("appt_day1");
						visit_type_ind			=rs.getString("visit_type_ind")== null?"":rs.getString("visit_type_ind");

						if (practitionerid==null)	practitionerid	=	"";

						

						try
						{
				
						htRecord.put	("tfr_appt_yn",					tfr_appt_yn				);
						htRecord.put	("secCnt",					secCnt				);
						htRecord.put	("tfr_appt_across_catg_yn",		tfr_appt_across_catg_yn	);
						htRecord.put	("canc_appt_yn",				canc_appt_yn			);
						htRecord.put	("apptrefno",					apptrefno				);
						htRecord.put	("carelocndesc", carelocndesc);
						htRecord.put	("resourcetype", resourcetype);
						htRecord.put	("forced_yn",					forced_yn				);
						htRecord.put	("cliniccode1",					cliniccode1				);
						htRecord.put	("practitionerid",				practitionerid			);
						htRecord.put	("apptdate",					apptdate				);
						htRecord.put	("overbookedyn",				overbookedyn 			);
						htRecord.put	("apptslabfromtime",			apptslabfromtime		);
						htRecord.put	("apptslabtotime",				apptslabtotime			);
						htRecord.put	("patientid",					patientid1				);
						htRecord.put	("patname",						patname					);
						htRecord.put	("dis_age",						dis_age					);
						htRecord.put	("gender",						gender1					);
						htRecord.put	("appt_duration",				appt_duration			);
						htRecord.put	("visit_type_short_desc",		visit_type_short_desc	);
						htRecord.put	("clinic_short_desc",			clinic_short_desc		);
						htRecord.put	("practitioner_short_name",		practitioner_short_name	);
						htRecord.put	("referral_id",					referral_id				);
						htRecord.put	("appt_day1",					appt_day1				);
						htRecord.put	("visit_type_ind",				visit_type_ind			);
						htRecord.put	("alcn_criteria",			    alcn_criteria		);
						htRecord.put	("team_id",			    team_id		);
						htRecord.put    ("appt_status", appt_status);
						htRecord.put	("resourceClass",resourceClass);
						htRecord.put	("locnType",locnType);
						apptRecordSet.putObject(htRecord);


						}
					
						catch(Exception e)
						{
							//out.println("Exception@5 : "+e);
							e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
						}
						
					}

					}
			if (rs!=null) rs.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165				
				//out.println("Exception@2 : "+e);
			}
int totalRecords=0;
		 totalRecords = apptRecordSet.getSize();
	
	/*	if(cnt == 0)
					{ */
					
            _bw.write(_wl_block9Bytes, _wl_block9);
	
			//		}else{
		
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		int upper_limit1=0;
		upper_limit1=upper_limit;

			try
		{
			if(upper_limit>totalRecords)	upper_limit1	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit1; i++)
			{
				if(cnt==0)
				{
			
			if(!(lower_limit <= 1))
			{
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((lower_limit-maxDispRecord)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((upper_limit-maxDispRecord)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appttodate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(apptfromdate));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}

			{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((lower_limit+maxDispRecord)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((upper_limit+maxDispRecord)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appttodate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(apptfromdate));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}	
		
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(called_for.equals("")){
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
 }
	/*	try
		{
			if(upper_limit>totalRecords)	upper_limit	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit; i++)
			{ */
				
				htRecord				=		(java.util.HashMap)	apptRecordSet.getObject(i);
				tfr_appt_yn				=		(String)	htRecord.get	("tfr_appt_yn");
				secCnt					=		(String)	htRecord.get	("secCnt");
				tfr_appt_across_catg_yn	=		(String)	htRecord.get	("tfr_appt_across_catg_yn");
				canc_appt_yn			=		(String)	htRecord.get	("canc_appt_yn");			
				apptrefno				=		(String)	htRecord.get	("apptrefno");	carelocndesc	        =		(String)	htRecord.get	("carelocndesc");
				resourcetype			=    (String) htRecord.get ("resourcetype");
				forced_yn				=		(String)	htRecord.get	("forced_yn");	
				
				cliniccode1				=		(String)	htRecord.get	("cliniccode1");		
				practitionerid			=		(String)	htRecord.get	("practitionerid");
				apptdate				=		(String)	htRecord.get	("apptdate");			
				appt_status             =       (String)    htRecord.get    ("appt_status");
				overbookedyn 			=		(String)	htRecord.get	("overbookedyn");		
				apptslabfromtime		=		(String)	htRecord.get	("apptslabfromtime");		
				apptslabtotime			=		(String)	htRecord.get	("apptslabtotime");
				patientid				=		(String)	htRecord.get	("patientid");				
				resourceClass			=		(String)    htRecord.get	("resourceClass");
				locnType				=		(String)	htRecord.get	("locnType");
				if(patientid==null || patientid.equals("")) patientid="&nbsp;";
				patname					=		(String)	htRecord.get	("patname");
				dis_age					=		(String)	htRecord.get	("dis_age");
				if(dis_age==null || dis_age.equals("")) dis_age="&nbsp;";
				gender					=		(String)	htRecord.get	("gender");			
				appt_duration			=		(String)	htRecord.get	("appt_duration");	
				visit_type_short_desc	=		(String)	htRecord.get	("visit_type_short_desc");
				clinic_short_desc		=		(String)	htRecord.get	("clinic_short_desc");	
				if(clinic_short_desc==null || clinic_short_desc.equals("")) clinic_short_desc="&nbsp;";
				practitioner_short_name	=		(String)	htRecord.get	("practitioner_short_name");
				if(practitioner_short_name==null || practitioner_short_name.equals("")) practitioner_short_name="&nbsp;";
				referral_id				=		(String)	htRecord.get	("referral_id");
				if(referral_id==null || referral_id.equals("")) referral_id="&nbsp;";
				
				alcn_criteria				=		(String)	htRecord.get	("alcn_criteria");
				if(alcn_criteria==null || alcn_criteria.equals("")) alcn_criteria="";
				appt_day1				=		(String)	htRecord.get	("appt_day1");
				visit_type_ind				=		(String)	htRecord.get	("visit_type_ind");
				team_id				=		(String)	htRecord.get	("team_id");
				if(appt_day1==null || appt_day1.equals("")) appt_day1="";
				if(visit_type_ind==null || visit_type_ind.equals("")) visit_type_ind="";
				if(team_id==null || team_id.equals("")) team_id="";

												
				if ( rowcolor % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
				classValue = "QRYODD" ;
				
				String apptdate_display="";
				apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
				
            _bw.write(_wl_block31Bytes, _wl_block31);
			
				if(forced_yn.equals("N")){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(called_for.equals("")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cliniccode1));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(appt_day1.trim()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(resourceClass));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
 } else {
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block50Bytes, _wl_block50);
 } 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block53Bytes, _wl_block53);
String tmp_ref_no=apptrefno;
				
				
            _bw.write(_wl_block54Bytes, _wl_block54);
if(called_for.equals("")){
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
if(!secCnt.equals("0")){
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
if(patientid==null){
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{
					out.println(patientid);
				}
				
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(patname));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dis_age));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(appt_duration));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(visit_type_short_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(carelocndesc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(clinic_short_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(resourcetype));
            _bw.write(_wl_block72Bytes, _wl_block72);

				String patname10 = practitioner_short_name == null?"&nbsp;":practitioner_short_name;
				
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(patname10));
            _bw.write(_wl_block74Bytes, _wl_block74);

				String patname11 = referral_id== null?"&nbsp;":referral_id;
				
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(patname11));
            _bw.write(_wl_block75Bytes, _wl_block75);

				rowcolor++;		
				cnt++;
				//htRecord.clear();
				}

		}
		catch(Exception e)
		{
			//out.println("Exception@3 : "+e);
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
//	}

	if(cnt == 0)
	{
            _bw.write(_wl_block76Bytes, _wl_block76);
}

	//boolean flag = false;
	if ( cnt < 14  ) {
	
            _bw.write(_wl_block77Bytes, _wl_block77);
 //flag = true;
			} else {
            _bw.write(_wl_block78Bytes, _wl_block78);
}

		if (rsps!=null) rsps.close();
		if ( rs != null ) rs.close() ;
		if (stmtps!=null) stmtps.close();
	    if ( stmt != null ) stmt.close() ;
	}
	catch ( Exception e )
	{
		//out.println("Exception : "+e);
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{   
		ConnectionManager.returnConnection(conn,request);

	}

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block81Bytes, _wl_block81);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcename.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }
}
