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
import java.io.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __staffforworkplaceshowworkplace extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffForWorkplaceShowWorkplace.jsp", 1709121658839L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\"../js/StaffForWorkplace.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src= \'../../eCommon/js/FieldFormatMethods.js\'> </script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' ></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</script>\n<script>\n\tfunction chkfrto(from,to)\n\t{\n\t\tvar chk2 =\'\';\n\t\tvar chk =doDateCheckAlert(document.forms[0].sysdate,to);\n\t\tif(chk==false){\n\t\t\talert(getMessage(\"TO_DATE_LESS_SYSDATE\",\"RS\"));\n\t\t\tchkfrsys =\'Y\';\n\t\t\tto.select();\n\t\t\tto.focus();\n\t\t\tchk2 =\'Y\';\n\t\t}\n\t\tif(chk2==\'\')\n\t\t{\n\t\tvar chk1 =doDateCheckAlert(from,to);\n\t\tif(chk1==false){\n\t\t\talert(getMessage(\"TO_DT_GR_EQ_FM_DT\",\"RS\"));\n\t\t\tto.select();\n\t\t\tto.focus();\n\t\t\t//return false;\n\t\t}\n\t\t}\n\t}\n\tfunction chksys1(obj)\n\t{\n\t\tvar chk =doDateCheckAlert(document.forms[0].sysdate,obj);\n\t\tif(chk==false){\n\t\t\talert(getMessage(\"FROM_DATE_LESS_SYSDATE\",\"RS\"));\n\t\t\tobj.select();\n\t\t\tobj.focus();\n\t\t\t//return false;\n\t\t}\n\t}\n\t\n\tfunction oncheck(target){\n\tif(target.checked==true)\n\t\t{\n\t\ttarget.value=\"Y\";\n\t\t//eval(\"document.forms[0].eff_status\"+i).value=\"E\";\n\t/*alert(eval(\"document.forms[0].eff_status\"+i).value);\n\talert(i);*/\n\t\t}\n\telse if(target.checked==false)\n\t\t{\n\t\ttarget.value=\"N\";\n\t\t//eval(\"document.forms[0].eff_status\"+i).value=\"D\";\n\t\t/*alert(eval(\"document.forms[0].eff_status\"+i).value);\n\t\t\talert(i);*/\n\t\t}\n\treturn;\n}\n\t</script>\n <body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n <form name=\"workplace_frm_list\" id=\"workplace_frm_list\" action=\'../../servlet/eRS.StaffForWorkplaceServlet\' method=\'POST\' target=\'messageFrame\'>\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\"90%\">\n\t\t\t<tr>\n\t\t\t\t<th align=\'left\' width=\'20%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\t\t<th align=\'left\' width=\'30%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th align=\'center\' width=\'15%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" *</th>\n\t\t\t\t<th align=\'center\' width=\'15%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t<th align=\'center\' width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t <tr>\t\n\t\t <td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t <td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n    \t  <td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><input type=textbox name=\"text1";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"text1";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" size=\'10\'  maxlength=\'10\' readonly>\n\t\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"></td>\n\t\t  <td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><input type=textbox name=\"text2";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"text2";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\'10\'  maxlength=\'10\' readonly>\n\t\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text2";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\"></td>\n\t\t\t  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t  <td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" size=\'10\'  maxlength=\'10\'onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\"></td>\n\t\t\t  <td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\'10\'  maxlength=\'10\' onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text2";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\"></td>\n\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t <td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" size=\'10\'  maxlength=\'10\'onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=\'10\' maxlength=\'10\' onblur=\'CheckDate(this);chkfrto(text1";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",this);\'>\n\t\t  <img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text2";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" value=\"\" size=\'10\'  maxlength=\'10\'onblur=\'CheckDate(this);chksys1(this);\'>\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text1";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\"></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"value=\"\" size=\'10\' maxlength=\'10\' onblur=\'CheckDate(this);chkfrto(text1";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =",this);\'>\n\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'text2";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\')\"></td>\n\n\t\t\t ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\n\t\t <td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' align=\'center\'><input type=checkbox name=\"select";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"select";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\"\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" onclick=\'return oncheck(this);\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="> </td>\n\t\t\t ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t \n\t\t <td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t </tr>\n\t\t\t \n\t\t\t <input type=\'hidden\' name=\'eff_fro";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'eff_fro";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' value=\'\'>\n\t\t\t <input type=\'hidden\' name=\'eff_to";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'eff_to";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' value=\'\'>\n\t\t\t <input type=\'hidden\' name=\'chkd";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'chkd";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value=\'\'> \n\t\t\t <input type=\'hidden\' name=\'workplace_code";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'workplace_code";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t <input type=\'hidden\' name=\'db_action";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'db_action";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t <input type=\'hidden\' name=\'eff_status";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'eff_status";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' value=\'\'>\n\t\t\t\n\t\t ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script> \n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t <input type=\'hidden\' name=\'staff_type\' id=\'staff_type\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t<input type=hidden name =\"record_Count\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t<input type=hidden name =\"staff\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t<input type=hidden name =\"role_type\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t\t<input type=hidden name =\"sysdate\" value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t<input type=hidden name =\"mode\" value=\'2\'>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" \n\n\t</table>\n\t</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  PreparedStatement pstmt1	      = null;
	  PreparedStatement pstmt2	      = null;
	  ResultSet rs		      = null;
	  ResultSet rs1		      = null;
	  ResultSet rs2		      = null;
	  PreparedStatement pstmt4	      = null;
	  ResultSet rs4		      = null;
	  String	facilityId 	  = (String) session.getValue( "facility_id" ) ;
	
	  String staff_type="";
	  String locn_type_desc="";
	  String eff_from="";
	  String eff_to="";
	  String eff_status="";
	  String work_place_desc="";
	  String workplace_code="";
	  String classValue="";
	  String chkunchk="";
	  String dochkunchk="";
	  String dbaction="";
	  String sysdate="";
	  String disp_locn="";
	  String disp_wrk="";
	  java.util.Date date1 =null;
	  java.util.Date date2 =null;	
	  String dbcheck="";
	  int rowIndex =	1;
	  int i= 0;
	  int record_Count= 0;
	  int record_Count1= 0;
	  try
  {
		con = ConnectionManager.getConnection(request);
		String sel_Sysdate ="select to_char(sysdate,'dd/mm/yyyy'),sysdate from dual";
		pstmt4 = con.prepareStatement(sel_Sysdate);
		rs4 = pstmt4.executeQuery();
		while(rs4!=null && rs4.next())
		{
			sysdate =rs4.getString(1);
			date2 =rs4.getDate(2);
		 }
		 if(pstmt4 != null)
			 pstmt4.close();
		 if(rs4 != null)
			 rs4.close();

		String mode	   = request.getParameter("mode") ;
		 if( mode==null) mode="";
		String locn_type = request.getParameter("locn_type");
		String role_type = request.getParameter("role_type");
		if(locn_type==null) locn_type = "";
		if(role_type==null) role_type = "";

		String staff = request.getParameter("staff");
		if(staff==null) staff = "";
	

	String sqlCount="SELECT COUNT (*)   FROM rs_staff_for_workplace a, am_care_locn_type b, rs_workplace c  WHERE a.facility_id = ? AND a.role_type = ? AND a.staff_id = ? AND c.facility_id = a.facility_id AND c.workplace_code = a.workplace_code AND b.locn_type(+) = c.locn_type AND (?  IS NULL OR c.locn_type = ?) UNION ALL SELECT COUNT (*) b FROM rs_workplace a, am_care_locn_type b WHERE a.facility_id = ? AND (?  IS NULL OR a.locn_type = ? ) AND a.eff_status = 'E' AND b.locn_type(+) = a.locn_type AND (a.facility_id, workplace_code) NOT IN (SELECT facility_id, workplace_code FROM rs_staff_for_workplace WHERE facility_id = ? AND role_type = ? AND staff_id = ? )";
		//out.println(sqlCount);
		pstmt1 = con.prepareStatement(sqlCount);
		pstmt1.setString(1,facilityId);
		pstmt1.setString(2,role_type);
		pstmt1.setString(3,staff);
		pstmt1.setString(4,locn_type);
		pstmt1.setString(5,locn_type);
		pstmt1.setString(6,facilityId);
		pstmt1.setString(7,locn_type);
		pstmt1.setString(8,locn_type);
		pstmt1.setString(9,facilityId);
		pstmt1.setString(10,role_type);
		pstmt1.setString(11,staff);
		rs1 = pstmt1.executeQuery();
		while(rs1!=null  && rs1.next()){
			record_Count1 =rs1.getInt(1);
			 record_Count = record_Count+record_Count1;
		}
		 if(pstmt1 != null)
			 pstmt1.close();
		 if(rs1 != null)
			 rs1.close();
	 
	 if(record_Count>0)
	  {
	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		//String sql1 ="select b.short_desc locn_type_desc, a.workplace_code, c.workplace_desc workplace_desc,to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from,to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to,a.eff_status eff_status, 'U' db_action from rs_staff_for_workplace a, am_care_locn_type b, rs_workplace c where a.facility_id =? and a.role_type =? and a.staff_id = ? and c.facility_id = a.facility_id and  c.workplace_code = a.workplace_code and b.locn_type(+) = c.locn_type and ( ? is null or c.locn_type = ?) union all select b.short_desc locn_type_desc, a.workplace_code, a.workplace_desc workplace_desc,	null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from rs_workplace a, am_care_locn_type b where a.facility_id =? and (? is null or a.locn_type = ?) and  a.eff_status = 'E' and b.locn_type(+) = a.locn_type and (a.facility_id,workplace_code) not in (select facility_id,workplace_code from rs_staff_for_workplace where facility_id =? and role_type = ? and staff_id =?)order by locn_type_desc, workplace_desc";
		String sql1 ="select b.short_desc locn_type_desc, a.workplace_code, c.workplace_desc workplace_desc,to_char(a.eff_date_from,'dd/mm/yyyy') eff_date_from,to_char(a.eff_date_to,'dd/mm/yyyy') eff_date_to,a.eff_status eff_status, 'U' db_action from rs_staff_for_workplace a, am_care_locn_type_lang_vw b, rs_workplace_lang_vw c where a.facility_id =? and a.role_type =? and a.staff_id = ? and c.facility_id = a.facility_id and  c.workplace_code = a.workplace_code and c.language_id = ? and b.locn_type(+) = c.locn_type and b.language_id(+) = ? and ( ? is null or c.locn_type = ?) union all select b.short_desc locn_type_desc, a.workplace_code, a.workplace_desc workplace_desc,null eff_date_from, null eff_date_to, 'E' eff_status, 'I' db_action from rs_workplace a, am_care_locn_type b where a.facility_id =? and (? is null or a.locn_type = ?) and  a.eff_status = 'E' and b.locn_type(+) = a.locn_type and (a.facility_id,workplace_code) not in (select facility_id,workplace_code from rs_staff_for_workplace where facility_id =? and role_type = ? and staff_id =?)order by locn_type_desc, workplace_desc";
		//out.println(sql1);
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,role_type);
		pstmt.setString(3,staff);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locn_type);
		pstmt.setString(7,locn_type);
		pstmt.setString(8,facilityId);
		pstmt.setString(9,locn_type);
		pstmt.setString(10,locn_type);
		pstmt.setString(11,facilityId);
		pstmt.setString(12,role_type);
		pstmt.setString(13,staff);
		rs = pstmt.executeQuery();
		while(rs!=null  && rs.next()){
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;						
			work_place_desc  =rs.getString("workplace_desc")==null?"":rs.getString("workplace_desc");
			
			workplace_code =rs.getString("workplace_code")==null?"":rs.getString("workplace_code");
			dbaction =rs.getString("db_action")==null?"":rs.getString("db_action");
			locn_type_desc =rs.getString("locn_type_desc")==null?"":rs.getString("locn_type_desc");
			eff_from =rs.getString("eff_date_from")==null?"":rs.getString("eff_date_from");
			if(!eff_from.equals("")){
				SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
				date1=formatter1.parse(eff_from);
				eff_from=com.ehis.util.DateUtils.convertDate(eff_from,"DMY","en",locale);
			 }
			chkunchk =rs.getString("db_action")==null?"":rs.getString("db_action");
			eff_to =rs.getString("eff_date_to")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("eff_date_to"),"DMY","en",locale);
			eff_status =rs.getString("eff_status")==null?"":rs.getString("eff_status");
			//out.println(date1);
			if(locn_type_desc.equals(""))
				disp_locn="&nbsp;";
			else
	 				disp_locn=locn_type_desc;
			if(work_place_desc.equals(""))
				disp_wrk="&nbsp;";
			else
	 				disp_wrk=work_place_desc;

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disp_locn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disp_wrk));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(eff_status.equals("E")){
		if(!eff_from.equals("")&&!eff_to.equals(""))
		  {
		 int cnt = date1.compareTo(date2);
		 if(cnt<0)
		 {
		 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eff_from));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eff_to));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else
			  {
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eff_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eff_to));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);

			  }}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eff_from));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(eff_to));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
}}else{
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
			 if(chkunchk.equals("U") && eff_status.equals("E"))
			 {
			  dochkunchk ="checked";
			 }
		 else 
			 {
			 dochkunchk="";
			 }if(eff_status.equals("E"))
		 {
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dochkunchk));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dbcheck));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dochkunchk));
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
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dbaction));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);

			 i++;
		 }
		 if(pstmt != null)
			 pstmt.close();
		 if(rs != null)
			 rs.close();

	  }
	else
		  {
            _bw.write(_wl_block64Bytes, _wl_block64);
}
		
	  String sel_SType = "";
	  if(role_type.equals("P"))
	   sel_SType = "SELECT pract_type FROM AM_PRACTITIONER WHERE  PRACTITIONER_ID = ?";
	   else
	    sel_SType = "SELECT other_staff_type FROM AM_OTHER_STAFF WHERE  OTHER_STAFF_ID = ?";

	  pstmt2 = con.prepareStatement(sel_SType);
	  pstmt2.setString(1,staff);
		rs2 = pstmt2.executeQuery();
		while((rs2!=null)&&(rs2.next())) {
		staff_type  =rs2.getString(1);
	  }
		 if(pstmt2 != null)
			 pstmt2.close();
		 if(rs2 != null)
			 rs2.close();
		
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(record_Count));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(staff));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block70Bytes, _wl_block70);

  }catch(Exception e){
	  out.println("Error is--->"+e);
  }
  finally {
  		 if(pstmt4 != null)
			 pstmt4.close();
		 if(rs4 != null)
			 rs4.close();
		 if(pstmt2 != null)
			 pstmt2.close();
		 if(rs2 != null)
			 rs2.close();
		 if(pstmt1 != null)
			 pstmt1.close();
		 if(rs1 != null)
			 rs1.close();
		 if(pstmt != null)
			 pstmt.close();
		 if(rs != null)
			 rs.close();
	  ConnectionManager.returnConnection(con,request);
}


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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkPlace.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveTo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
