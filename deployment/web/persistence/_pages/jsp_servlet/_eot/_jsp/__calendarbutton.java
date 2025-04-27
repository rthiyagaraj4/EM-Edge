package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;

public final class __calendarbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CalendarButton.jsp", 1709120180000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n\t<style>\nTD.USH {\n  FONT-FACE: verdana ;\n  FONT-SIZE: 8pt ;\n  BACKGROUND-COLOR: WHITE;\n  COLOR:blue;\n}\n</style>\n\t<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\'>\nfunction moveBack1()\n{\n\tvar frmObj=document.forms[0];\n\tvar from=parseInt(frmObj.start1.value,10);\n\tfrom=from-1;\n\tfrmObj.start1.value=from;\n\tvar date=frmObj.date.value;\n\tvar tmpDate=convertDate(date,from);\n\tvar called_from=frmObj.called_from.value;\n\t//alert(\"tmpDate--->\"+tmpDate)\nvar tdate=0;\n\tvar month=0;\n\tvar year=0;\n\tvar dt=tmpDate.split(\"/\");\n\ttdate=dt[0];\n\tmonth=dt[1];\n\tyear=dt[2];\n\t/*if (year < 100) {\n\t    if (year > 40) {\n\t\tyear = year + 1900;\n\t    }\n\t    else {\n\t\tyear = year + 2000;\n\t    }\n\t}*/\n\tif(month==2){\n\t\tif (year % 4 == 0) {\n\t\t\tif (year % 100 != 0) {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"29\";\n\t\t\t}\n\t\t}else if (year % 400 == 0) {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"29\";\n\t\t\t}\n\t\t\t} else {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"28\";\n\t\t\t}\n\t\t\t}\n\t\t} else {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"28\";\n\t\t\t}\n\t\t}\n\t}\n\n\t\tif(month==2 || month==4 || month==6 || month==8 || month==9 || month==11 || month==1)\n\t{\n\tif(tdate==31){\n\ttdate=\"01\";\n\tmonth=parseInt(month)+parseInt(1);\n\t}\n\t}\n\n\n\tvar manualDate=tdate+\"/\"+month+\"/\"+year;\nvar param =\"sql=\"+frmObj.sql.value+\"&flag=\"+frmObj.flag.value+\"&date=\"+manualDate+\"&speciality_code=\"+frmObj.speciality_code.value+\"&speciality_desc=\"+frmObj.speciality_desc.value+\"&orderid=\"+frmObj.orderid.value+\"&booking_no=\"+frmObj.booking_no.value+\"&called_from=\"+called_from;\n\tif(from <0)\t\n\t\tparam+=\"&from_value=1\";\n\telse \n\t\tparam+=\"&from_value=0\";\n\n\t\tparent.schdule_dtl.location.href = \'../../eOT/jsp/Calenderslot.jsp?\'+param;\n\n}\n\n\nfunction moveForward1()\n{\n\tvar frmObj=document.forms[0];\n\tvar from=parseInt(frmObj.start1.value,10);\n\tfrom=from+1;\n\tfrmObj.start1.value=from;\n\tvar date=frmObj.date.value;\n\tvar tmpDate=convertDate(date,from);\n\tvar tdate=0;\n\tvar month=0;\n\tvar year=0;\n\tvar dt=tmpDate.split(\"/\");\n\ttdate=dt[0];\n\tmonth=dt[1];\n\tyear=dt[2];\n/*\tif (year < 100) {\n\t    if (year > 40) {\n\t\tyear = year + 1900;\n\t    }\n\t    else {\n\t\tyear = year + 2000;\n\t    }\n\t}*/\n\tvar called_from=frmObj.called_from.value;\n\t\n\tif(month==2){\n\t\t\t\n\t\tif (year % 4 == 0) {\n\t\t\tif (year % 100 != 0) {\n\t\t\t\t\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"29\";\n\t\t\t}\n\t\t}else if (year % 400 == 0) {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"29\";\n\t\t\t}\n\t\t\t} else {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"28\";\n\t\t\t}\n\t\t\t}\n\t\t} else {\n\t\t\tif(tdate==29 ||tdate==30 ||tdate==31){\n\t\t\ttdate=\"28\";\n\t\t\t}\n\t\t}\n\t}\n\n\tif(month==2 || month==4 || month==6 || month==8 || month==9 || month==11 || month==1)\n\t{\n\tif(tdate==31){\n\ttdate=\"01\";\n\tmonth=parseInt(month)+parseInt(1);\n\t}\n\t}\n\tvar manualDate=tdate+\"/\"+month+\"/\"+year;\n\tvar param =\"sql=\"+frmObj.sql.value+\"&flag=\"+frmObj.flag.value+\"&date=\"+manualDate+\"&speciality_code=\"+frmObj.speciality_code.value+\"&speciality_desc=\"+frmObj.speciality_desc.value+\"&orderid=\"+frmObj.orderid.value+\"&booking_no=\"+frmObj.booking_no.value+\"&called_from=\"+called_from;\n\tif(from <0)\tparam+=\"&from_value=1\";\n\telse \tparam+=\"&from_value=0\";\n\tparent.schdule_dtl.location.href = \'../../eOT/jsp/Calenderslot.jsp?\'+param;\n}\n\n\nfunction convertDate(date,from){\n\tvar spltDate=new Array();\n\tspltDate=date.split(\"/\");\n\tvar da=parseInt(spltDate[0],10);\n\tvar mon=parseInt(spltDate[1],10);\n\tvar yea=parseInt(spltDate[2],10);\n\n\tif(from<0){ \n\t\tfrom=from * -1;\n\t\tyea = yea - Math.floor(from/12);\n\t\tmon= mon - Math.floor(from%12);\n\t\tif(mon<=0){\n\t\t\t  mon=mon*-1;\n\t\t\t  mon=12-mon;\n\t\t\t  yea=yea-1;\n\t\t}\t         \n\t}else{\n\t\tvar\tadd=mon+from;\n\t\tvar div= Math.floor((add-1)/12);\n\t\tyea=yea+div;\n\t\tmon=(add-1)%12+1;\n\t}\n\tvar strDate= da+\"/\"+mon+\"/\"+yea;\n\treturn strDate;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n </head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form >\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<table border=\"0\" cellpadding=3 cellspacing=\"0\" width=\"100%\">\n<tr>\t\n\t<td align=\'center\' class=\'USH\'>\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\n\t<input type=\'button\' name=\'back\' id=\'back\' value=\'<--\'   onClick=\"moveBack1();\" class=\'BUTTON\'>\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t<input type=\'button\' name=\'forward\' id=\'forward\' value=\'-->\' onClick=\'javascript:moveForward1();\' class=\'BUTTON\'>\n\t</td>\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'start1\' id=\'start1\' value=\'0\'>\n\t<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\'hidden\' name=\'date\' id=\'date\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\'hidden\' name=\'speciality_desc\' id=\'speciality_desc\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\'hidden\' name=\'booking_no\' id=\'booking_no\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\n\n\n    </form>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

//commented this SOP statement by Rajesh on 09/01/09 
String sql=CommonBean.checkForNull(request.getParameter("sql"));
String flag=CommonBean.checkForNull(request.getParameter("flag"));
String date=CommonBean.checkForNull(request.getParameter("date"));
//date = com.ehis.util.DateUtils.convertDate(date,"DMY","en",locale);
String speciality_code=CommonBean.checkForNull(request.getParameter("speciality_code"));
String speciality_desc=CommonBean.checkForNull(request.getParameter("speciality_desc"));
String orderid=CommonBean.checkForNull(request.getParameter("orderid"));
String booking_no=CommonBean.checkForNull(request.getParameter("booking_no"));
String called_from = CommonBean.checkForNull(request.getParameter("called_from"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(orderid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(booking_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
