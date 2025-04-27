package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __secresbottom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SecResBottom.jsp", 1709119274224L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n <html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'</link>\n -->\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<SCRIPT>\nfunction calthis(fromWh)\n{\t\n\tvar sec_resorces_req=top.frames[1].frames[0].frames[0].document.forms[0].sec_resorces_req.value;\n\t\n\tvar sec_resorces=top.frames[1].frames[0].frames[0].document.forms[0].sec_resorces.value;\n\t\n\tvar sel_man=\"\";\n\tvar sel=\"N\";\n\tvar xarr=sec_resorces_req.split(\",\");\n\tvar xarr1=sec_resorces.split(\",\");\n\tvar msg=\"\";\n\n\t\t\tfor(var ik=0;ik<xarr1.length;ik++)\n\t\t\t\t{\n\t\t\t\t\tvar arr2=xarr1[ik].replace(\"\'\",\"\");\n\n\t\t\t\t\tarr2=arr2.replace(\"\'\",\"\");\n\t\t\t\t\tif(arr2==\'R\' && xarr[ik]==\'Y\')\n\t\t\t\t\t\tmsg=msg+\"R,\";\n\n\t\t\t\t\tif(arr2==\'E\' && xarr[ik]==\'Y\')\n\t\t\t\t\t\tmsg=msg+\"E,\";\n\n\t\t\t\t\tif(arr2==\'P\' && xarr[ik]==\'Y\')\n\t\t\t\t\t\tmsg=msg+\"P,\";\n\n\t\t\t\t\tif(arr2==\'O\' && xarr[ik]==\'Y\')\n\t\t\t\t\t\tmsg=msg+\"O,\";\n\t\t\t\t}\n\n\t\t\n\t\tvar xarr33=msg.split(\",\");\n\n\t\tvar equ_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_equ.value ;\n\t\tvar room_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_room.value;\n\t\t\n\t\tvar oth_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_other.value;\n\t\tvar pract_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_pract.value;\n\t\tvar flgP=false;\n\t\tvar flgE=false;\n\t\tvar flgO=false;\n\t\tvar flgR=false;\n\t\t\n\t\t\n\t\tif(top.frames[1].frames[0].frames[0].document.getElementById(\"sec_enE\")){\n\t\t\t\n\t\t\tvar ind=equ_val.indexOf(\'Y\');\n\t\t\tif(equ_val==\'\' || (ind==-1)){\n\t\t\t\tflgE=true;\n\t\t\t}\n\t\t}\n\n\t\tif(top.frames[1].frames[0].frames[0].document.getElementById(\"sec_enR\")){\n\t\t\tvar ind=room_val.indexOf(\'Y\');\n\t\t\tif(room_val==\'\' || (ind==-1)){\n\t\t\t\tflgR=true;\n\t\t\t}\n\t\t}\n\n\t\tif(top.frames[1].frames[0].frames[0].document.getElementById(\"sec_enP\")){\n\t\t\tvar ind=pract_val.indexOf(\'Y\');\n\t\t\tif(pract_val==\'\' || (ind==-1)){\n\t\t\t\tflgP=true;\n\t\t\t}\n\t\t}\n\t\tif(top.frames[1].frames[0].frames[0].document.getElementById(\"sec_enO\")){\n\t\t\tvar ind=oth_val.indexOf(\'Y\');\n\t\t\tif(oth_val==\'\' || (ind==-1)){\n\t\t\t\tflgO=true;\n\t\t\t}\n\t\t}\n\tif((flgP || flgO || flgE || flgR) && fromWh==\'Confirm\'){\n\t\talert(getMessage(\"ALL_MAN_RES_NT_SL\",\"OA\"));\n\t\treturn false;\n\t\tparent.frames[2].document.forms[0].Insupd.disabled=true;\n\t}else{\n\t\t\n\n\t\tvar final_val=\'\';\n\t\tif(equ_val==\'\')\n\t\t\tequ_val=\'*\';\n\n\t\tif(room_val==\'\')\n\t\t\troom_val=\'*\';\n\n\t\tif(oth_val==\'\')\n\t\t\toth_val=\'*\';\n\n\t\tif(pract_val==\'\')\n\t\t\tpract_val=\'*\';\n\n\t\tfinal_val=\'E#\'+equ_val+\'||\'+\'R#\'+room_val+\'||\'+\'O#\'+oth_val+\'||\'+\'P#\'+pract_val;\n\t\t\n\t\tvar seleted_values=final_val;\n\t\ttop.frames[0].document.forms[0].sec_sel.value=seleted_values;\n\t\treturn true;\n\t}\n\t\t\n\n\n\t\t\n}\nfunction callFuncs(){\n\tvar SinMul=parent.frames[0].document.forms[0].sec_value_count.value;\n\tvar secReses=parent.frames[0].document.forms[0].SecResCheck.value;\n\t if (secReses==\'Y\'){\n\tif (SinMul==\'Y\'){\nif (parent.frames[1].frames[0].frames[1].document.forms[0]){\nif(parent.frames[1].frames[0].frames[1].validate()){\n\t\n if (calthis(\'Confirm\')){\n\t \nparent.frames[0].validate_allocation_criteria();\n }\n}else{\n\t\n\tsec_res=parent.frames[0].document.forms[0].sec_req.value;\n\t\n\tindex=sec_res.indexOf(\'Y\');\n\tif (index!=-1){\n\talert(getMessage(\"ALL_MAN_RES_NT_SL\",\"OA\"));\n\tparent.frames[2].document.forms[0].Insupd.disabled=true;\n\n\t}else{\n\tparent.frames[0].validate_allocation_criteria();\n\t}\n}\n}else{\n\talert(getMessage(\"SEC_RES_NT_SEL\",\"OA\"));\n\tparent.frames[2].document.forms[0].Insupd.disabled=true;\n}\n\t}\n\telse if (SinMul==\'N\'){\n\t\tif (parent.frames[1].frames[1].document.forms[0]){\n  if (parent.frames[1].frames[1].validate(\'Confirm\')){\n\t\n\tparent.frames[0].validate_allocation_criteria();\n\t}\n\t\t}\n\t}else{\n\tparent.frames[0].validate_allocation_criteria();\n    }\n\t }else if (secReses=\'N\'){\nparent.frames[0].validate_allocation_criteria();\n\t }\n}\n</SCRIPT>\n</head>\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\t<body onKeyDown = \'lockKey()\'>\n\t\t<form name=\"recur_day_results\" id=\"recur_day_results\" method=\"post\">\n\t\t<table cellpadding=0 cellspacing=0 width=\"100%\">\n\t\t<tr><td class=\"OAQRYODD\" align=middle><input type=\"button\" value=\"OK\" class=button onclick=\"parent.frames[1].validate1()\">\n\t\t<input type=\"button\" value=\"Cancel\" class=button onclick=\"parent.frames[1].ret_none1()\">\n\t\t</td></tr>\n\t\t</table>\n\t\t</form>\n\t\t</body>\n\t\t</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<body onKeyDown = \'lockKey()\'>\n\t\t\t\t<form name=\"BookApptBottom\" id=\"BookApptBottom\" method=\'post\'>\n\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td   align=\'left\' colspan=6 width=\"100%\"> \t\n\t\t\t\t\t<input type=\'button\' name=\'past_visits\' id=\'past_visits\' value=\'Previous Encounter\'  class=\"BUTTON\" onClick=\'parent.frames[0].past_visits_view()\' disabled\n\t\t\t\t\t>&nbsp;\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input  type = \'button\' id=\'other_id1\' value = \'Other Appts\' onclick = \'parent.frames[0].show_window(\"Two\")\'  class=\"BUTTON\" ></input>\n\t\t\t\t\t\t<input type = \'hidden\' id=\'OtherAppts\' name=\'OtherAppts\' id=\'OtherAppts\' value = \'Other Appts\' onclick = \'parent.frames[0].show_window(\"Two\")\'  class=\"BUTTON\" ></input>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<input type=\'button\' id=\'sec\' value=\'Secondary Resources\'  class=\"BUTTON\" style=\"visibility:hidden\" onClick=\'show_second()\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'button\' id=\'ffgh\' name=\'clear\' id=\'clear\' value=\'Clear\'  class=\"BUTTON\" onClick=\'parent.frames[0].clearAll1()\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t&nbsp;<input type=\'button\' name=\'Insupd\' id=\'Insupd\' value=\'Confirm Booking\' onClick=\'callFuncs();\' class=\"BUTTON\" >&nbsp;<input type=\'button\' name=\'close\' id=\'close\' value=\'Close\'  class=\"BUTTON\" onClick=\'parent.frames[0].exitval()\' >\n\t\t\t</td>\n\t\t\t</TR>\n   \t\t\t</table>\n\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 
request.setCharacterEncoding("UTF-8");
 String fromPage=request.getParameter("fromPage")==null?"":request.getParameter("fromPage");
 if (!fromPage.equals("BookAppointment"))
 {

 
            _bw.write(_wl_block4Bytes, _wl_block4);
}else{
		
		String patientid=request.getParameter("patientid")==null?"":request.getParameter("patientid");
	
            _bw.write(_wl_block5Bytes, _wl_block5);
if (patientid.equals("")){
            _bw.write(_wl_block6Bytes, _wl_block6);
}
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
