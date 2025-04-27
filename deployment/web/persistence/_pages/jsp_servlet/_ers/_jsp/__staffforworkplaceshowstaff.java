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
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __staffforworkplaceshowstaff extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffForWorkplaceShowStaff.jsp", 1709121658683L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<!-- <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script> -->\n<script language=\'javascript\' src=\"../js/StaffForWorkplace.js\"></script>\n<script language=\'javascript\' src= \'../../eCommon/js/FieldFormatMethods.js\'> </script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' ></script>\n<script language=\'javascript\' src=\"../js/RSCommon.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</script>\n<script>\nfunction chkfrto(from,to)\n{\t\tvar chkfrsys=\'\';\n\t\t\n\t\tvar chk =doDateCheckAlert(document.forms[0].sysdate,to);\n\t\tif(chk==false){\n\t\t\talert(getMessage(\"TO_DATE_LESS_SYSDATE\",\"RS\"));\n\t\t\tchkfrsys =\'Y\';\n\t\t\tto.select();\n\t\t\tto.focus();\n\t\t\treturn false;\n\t\t}\n\t\telse{\n\t\t\tchkfrsys = \'\';\n\t\t}\n\t\tif(chkfrsys==\'\'){\n\t\t\n\t\t\tvar chk1 =doDateCheckAlert(from,to);\n\t\t\tif(chk1==false){\n\t\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"RS\"));\n\t\t\t\tto.select();\n\t\t\t\tto.focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\tfunction chksys1(obj){\n\t\tvar chk =doDateCheckAlert(document.forms[0].sysdate,obj);\n\t\tif(chk==false){\n\t\t\talert(getMessage(\"FROM_DATE_LESS_SYSDATE\",\"RS\"));\n\t\t\tobj.select();\n\t\t\tobj.focus();\n\t\t\treturn false;\n\t\t}\n\t}\n\t\n\tfunction oncheck(target,i){\n\t\t\tif(target.checked==true){\n\t\t\teval(\"document.forms[0].eff_status\"+i).value=\"E\";\n\t\t\ttarget.value=\"Y\";\n\t\t}\n\t\telse{\n\t\t\teval(\"document.forms[0].eff_status\"+i).value=\"D\";\n\t\t\ttarget.value=\"N\";\n\t\t}\n\t\treturn;\n\t}\n\t</script>\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<form name=\"workplace_frm_list\" id=\"workplace_frm_list\" action=\'../../servlet/eRS.StaffForWorkplaceServlet\' method=\'POST\' target=\'messageFrame\'>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\"90%\">\n\t\t\t<tr>\n\t\t\t\t<th align=\'left\' width=\'15%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th align=\'left\' width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t<th align=\'left\' width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t<th align=\'center\' width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="* </th>\n\t\t\t\t<th align=\'center\' width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t<th align=\'center\' width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t <tr>\t\n\t\t <td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t <td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t  <td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'><input type=textbox name=\"text1";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"text1";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" size=\'10\'  maxlength=\'10\' readonly>\n\t\t\t\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\"></td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" size=\'10\'  maxlength=\'10\'onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t\t\t\t<img\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" size=\'10\'  maxlength=\'10\'onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><input type=textbox name=\"text2";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"text2";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" size=\'10\' maxlength=\'10\' onblur=\'CheckDate(this);chkfrto(text1";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",this);\'>\n\t\t\t <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text2";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t <td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"\" size=\'10\'  maxlength=\'10\'onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t\t <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\"></td>\n\t\t\t <td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"value=\"\" size=\'10\' maxlength=\'10\' onblur=\'CheckDate(this);chkfrto(text1";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\"></td>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t <input type=\'hidden\' name=\'eff_status";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'eff_status";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'E\'>\n\t\t\t <td class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' align=\'center\'><input type=checkbox name=\"select";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"select";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" onclick=\'return oncheck(this,";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =");\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="> </td>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' value=\'\'>\n\t\t\t <td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t </tr>\n\t\t <input type=\'hidden\' name=\'eff_fro";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'eff_fro";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' value=\'\'>\n\t\t <input type=\'hidden\' name=\'eff_to";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'eff_to";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' value=\'\'>\n\t\t <input type=\'hidden\' name=\'chkd";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'chkd";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value=\'\'> \n\t\t <input type=\'hidden\' name=\'role_type";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'role_type";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t <input type=\'hidden\' name=\'staff_id";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'staff_id";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t <input type=\'hidden\' name=\'staff_type";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'staff_type";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t <input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'db_action";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t \n ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t</script> \n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\n\t\t<input type=hidden name =\"record_Count\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\n\t\t<input type=hidden name =\"workplace_code\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=hidden name =\"sysdate\" value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<input type=hidden name =\"mode\" value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" \n\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  PreparedStatement pstmt1	      = null;
	  PreparedStatement pstmt2	      = null;
	  ResultSet rs2		      = null;
	  ResultSet rs		      = null;
	  ResultSet rs1		      = null;
	
	  String	facilityId 	  = (String) session.getValue( "facility_id" ) ;
	
	  String staff_type="";
	  String staff_type_desc="";
	  String eff_from="";
	  String eff_to="";
	  String eff_status="";
	  String staff_name="";
	  String classValue="";
	  String chkunchk="";
	  String dochkunchk="";
	  String dbaction="";
	  String staff_id="";
	  String role_type1="";
	  String sysdate="";
	  String dbcheck="";
	  java.util.Date date1 =null;
	  java.util.Date date2 =null;
	  int rowIndex =	1;
	  int i= 0;
	  int record_Count= 0;
	  int record_Count1= 0;
	  try{
		con = ConnectionManager.getConnection(request);
		String sel_Sysdate ="select to_char(sysdate,'dd/mm/yyyy'),sysdate from dual";
		pstmt2 = con.prepareStatement(sel_Sysdate);
		rs2 = pstmt2.executeQuery();
		while(rs2!=null  && rs2.next()){
			sysdate =rs2.getString(1);
			date2 =rs2.getDate(2);
		}
		if(pstmt2 != null)
			pstmt2.close();
		if(rs2 != null)
			rs2.close();
		String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
		String workplace_code = request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
		String role_type = request.getParameter("role_type")==null?"":request.getParameter("role_type");
		String staff = request.getParameter("staff")==null?"":request.getParameter("staff");
		
		
		
		String sqlCount="SELECT count(*)  FROM rs_staff_for_workplace a, am_other_staff_type b,am_pract_type c,am_other_staff d,am_practitioner e WHERE a.facility_id = ? AND a.workplace_code =?   AND (? IS NULL OR a.role_type = ?) AND (? IS NULL OR a.staff_id = ?)AND b.other_staff_type(+) = a.staff_type   AND c.pract_type(+) = a.staff_type AND d.other_staff_id(+) = a.staff_id AND e.practitioner_id(+) = a.staff_id UNION ALL (SELECT count(*) FROM am_pract_for_facility_vw a, am_pract_type b   WHERE a.operating_facility_id = ?AND (? IS NULL OR a.practitioner_id = ?)    AND a.eff_status = 'E' AND b.pract_type = a.pract_type AND a.practitioner_id NOT IN (SELECT staff_id FROM rs_staff_for_workplace WHERE facility_id = ? AND workplace_code = ? AND role_type = 'P')) UNION ALL SELECT count(*) FROM am_other_staff_for_facility c, am_other_staff a,am_other_staff_type b WHERE c.facility_id = ? AND (? IS NULL OR c.other_staff_id = ?) AND a.other_staff_id = c.facility_id AND a.eff_status = 'E'AND b.other_staff_type = a.other_staff_type AND a.other_staff_id NOT IN (SELECT staff_id FROM rs_staff_for_workplace WHERE facility_id =? AND workplace_code = ? AND role_type = 'O')";
		//out.println(sqlCount);
		pstmt1 = con.prepareStatement(sqlCount);
		pstmt1.setString(1,facilityId);
		pstmt1.setString(2,workplace_code);
		pstmt1.setString(3,role_type);
		pstmt1.setString(4,role_type);
		pstmt1.setString(5,staff);
		pstmt1.setString(6,staff);
		pstmt1.setString(7,facilityId);
		pstmt1.setString(8,staff);
		pstmt1.setString(9,staff);
		pstmt1.setString(10,facilityId);
		pstmt1.setString(11,workplace_code);
		pstmt1.setString(12,facilityId);
		pstmt1.setString(13,staff);
		pstmt1.setString(14,staff);
		pstmt1.setString(15,facilityId);
		pstmt1.setString(16,workplace_code);
		rs1 = pstmt1.executeQuery();
		/*System.err.println("facilityId in staffforworkplaceshowstaff.jsp 149--->" +facilityId);
		System.err.println("workplace_code in staffforworkplaceshowstaff.jsp 150--->" +workplace_code);
		System.err.println("role_type in staffforworkplaceshowstaff.jsp 151--->" +role_type);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 152-->" +staff);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 153--->" +staff);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 154--->" +facilityId);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 155--->" +staff);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 156--->" +staff);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 157--->" +facilityId);
		System.err.println("workplace_code in staffforworkplaceshowstaff.jsp 158--->" +workplace_code);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 159--->" +facilityId);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 160--->" +facilityId);
		System.err.println("staff in staffforworkplaceshowstaff.jsp 161--->" +facilityId);
		System.err.println("facilityId in staffforworkplaceshowstaff.jsp 162--->" +facilityId);
		System.err.println("workplace_code in staffforworkplaceshowstaff.jsp 163--->" +workplace_code);*/
		
		
		while(rs1!=null  && rs1.next()){
			
			record_Count1 =rs1.getInt(1);
			 record_Count = record_Count+record_Count1;

		}
		//out.println("record_Count1---in servlet---->" +record_Count1);
		//out.println("record_Count---in servlet---->" +record_Count);
		if(pstmt1 != null)
			pstmt1.close();
		if(rs1 != null)
			rs1.close();
	 if(record_Count>0)  {
		// out.println("record_Count--->" +record_Count);

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		String sql1 ="select a.facility_id, a.workplace_code,a.role_type role_type,a.staff_id, a.staff_type,nvl(b.short_desc,c.desc_userdef) staff_type_desc, nvl(d.other_staff_name,e.practitioner_name)staff_name, to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from, to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to, a.eff_status eff_status, 'U' db_action from rs_staff_for_workplace a, am_other_staff_type b, am_pract_type c, am_other_staff d, am_practitioner e where a.facility_id = ? and a.workplace_code = ? and (? is null or a.role_type = ?) and (? is null or a.staff_id = ?) and b.other_staff_type(+) = a.staff_type and c.pract_type(+) = a.staff_type and d.other_staff_id(+) = a.staff_id and e.practitioner_id(+) = a.staff_id union all (select ? facility_id,? workplace_code,'P' role_type,a.practitioner_id staff_id, a.pract_type staff_type, b.desc_userdef staff_type_desc,a.practitioner_name staff_name, null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from am_pract_for_facility_vw a, am_pract_type b where a.operating_facility_id =  ? and (? is null or a.practitioner_id = ?)and a.eff_status = 'E' and b.pract_type = a.pract_type and a.practitioner_id not in (select staff_id from  rs_staff_for_workplace where facility_id = ? and  workplace_code = ? and role_type = 'P') union all select ?  facility_id,? workplace_code,'O' role_type, a.other_staff_id staff_id, a.other_staff_type staff_type, b.short_desc staff_type_desc, a.other_staff_name staff_name, null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from am_other_staff_for_facility c, am_other_staff a, am_other_staff_type b where c.facility_id = ? and (?  is null or c.other_staff_id = ?) and a.other_staff_id = c.other_staff_id and a.eff_status = 'E' and b.other_staff_type = a.other_staff_type and a.other_staff_id not in  (select staff_id from rs_staff_for_workplace 	  where facility_id =? and workplace_code = ?  and role_type = 'O')) order by role_type,staff_name";
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,role_type);
		pstmt.setString(4,role_type);
		pstmt.setString(5,staff);
		pstmt.setString(6,staff);
		pstmt.setString(7,facilityId);
		pstmt.setString(8,workplace_code);
		pstmt.setString(9,facilityId);
		pstmt.setString(10,staff);
		pstmt.setString(11,staff);
		pstmt.setString(12,facilityId);
		pstmt.setString(13,workplace_code);
		pstmt.setString(14,facilityId);
		pstmt.setString(15,workplace_code);
		pstmt.setString(16,facilityId);
		pstmt.setString(17,staff);
		pstmt.setString(18,staff);
		pstmt.setString(19,facilityId);
		pstmt.setString(20,workplace_code);
		rs = pstmt.executeQuery();
		while(rs!=null  && rs.next()){
			classValue=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			
			staff_name =rs.getString("staff_name");
			
			role_type =rs.getString("role_type");
			staff_id =rs.getString("staff_id");
			dbaction =rs.getString("db_action");
			//out.println("dbaction--- in staffforworkplaceshowstaff.jsp--"+dbaction);
			if(staff_id==null)staff_id="";
			if(role_type==null)role_type="";
			if(role_type.equals("P"))
				role_type1 ="Practitioner";
			else
				role_type1 ="Other Staff";

			if(staff_name==null)staff_name="";
			if(dbaction==null)dbaction="";
			staff_type_desc =rs.getString("STAFF_TYPE_DESC");
			staff_type =rs.getString("staff_type");
			if(staff_type_desc==null)staff_type_desc="";
			if(staff_type==null)staff_type="";
			eff_from =rs.getString("eff_date_from");
			if(eff_from==null)eff_from="";
			if(!eff_from.equals("")){
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				date1=formatter1.parse(eff_from);
				eff_from=com.ehis.util.DateUtils.convertDate(eff_from,"DMY","en",locale);
			 }
			eff_status =rs.getString("eff_status");
			if(eff_status==null)eff_status="";
			chkunchk =rs.getString("db_action");
			eff_to =rs.getString("eff_date_to");
			if(eff_to==null) eff_to=""; else eff_to=com.ehis.util.DateUtils.convertDate(eff_to,"DMY","en",locale);
			if(chkunchk==null)chkunchk="";

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(role_type1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(staff_type_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

		if(eff_status.equals("E")){
			//System.err.println("if eff_status is E-->" +eff_status);
			if(!eff_from.equals("")&&!eff_to.equals("")) {

				 int cnt = date1.compareTo(date2);
				 if(cnt<0){
			

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eff_from));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
				else{

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eff_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
			}
			else{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eff_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);

			 }

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eff_to));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
		else{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);

		 }
		 if(chkunchk.equals("U") && eff_status.equals("E")){
			dochkunchk ="checked";
		}
		else{
			 dochkunchk="";
		}
		if(eff_status.equals("E")){

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dochkunchk));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dbcheck));
            _bw.write(_wl_block48Bytes, _wl_block48);

		}
		else{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dochkunchk));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dbcheck));
            _bw.write(_wl_block48Bytes, _wl_block48);

		}

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dbaction));
            _bw.write(_wl_block65Bytes, _wl_block65);

		  i++;
	}
	if(pstmt != null)
		pstmt.close();
	if(rs != null)
		rs.close();
	}
	else{

            _bw.write(_wl_block66Bytes, _wl_block66);

	}

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record_Count));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block72Bytes, _wl_block72);

	}
	catch(Exception e){
		e.printStackTrace() ;
		throw e ;
  }
  finally{
	 if(pstmt != null)
		 pstmt.close();
	 if(rs != null)
		 rs.close();
	 if(pstmt1 != null)
		 pstmt1.close();
	 if(rs1 != null)
		 rs1.close();
	 if(pstmt2 != null)
		 pstmt2.close();
	 if(rs2 != null)
		 rs2.close();
	  ConnectionManager.returnConnection(con,request);
  }

            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RoleType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveTo.label", java.lang.String .class,"key"));
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
}
