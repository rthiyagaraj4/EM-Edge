package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __secondaryresources extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SecondaryResources.jsp", 1742299439691L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n -->\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eOA/js/SecondaryResource.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script> \nfunction enable_chk(Obj,token) //ADDED FOR ML-MMOH-SCF-3103\n{\n\tvar sys_dt=document.forms[0].sysdt.value;\n\tvar appt_dt=document.forms[0].appt_date.value;\n\tvar sys_tm=document.forms[0].systm.value;\n\tvar appt_tm=token;\n\tif(sys_dt==appt_dt)\n\t{\n\t\t\n\t\tvar fromtimeharray=sys_tm.split(\":\");\n\t\tvar from_time=appt_tm.split(\":\");\n\n\t\tvar fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);\n\t\tvar tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);\n\tif( Date.parse(fromhtm) >= Date.parse(tohtm)){\n\t\t\talert(getMessage(\"FR_TIME_CAN_NOT_SYS_TIME\",\"OA\"));\n\t\t\tObj.checked=false;\n\t\t\t}\n\n\t}\n\n}\n\nfunction validate() //ADDED FOR ML-MMOH-SCF-3103\n{ \n\tvar sel=\"N\";\n\tvar ret_str=\"\";\n\tvar sel_man=\"\";\n\tvar tmparr=\"\";\n\tvar sec_req=document.forms[0].sec_req.value;\nif(document.forms[0].ret_value)\n\t{\n\t\tvar nos=document.forms[0].ret_value.length;\n\n\t\tfor(var i=0;i<nos;i++){\n\t\t\tif(document.forms[0].chk[i].checked){\n\t\t\t\tsel=\"Y\";\t\n\t\t\t\tret_str=ret_str+document.forms[0].ret_value[i].value+\",Y\"+\"@\";\n\t\t\t\ttmparr=document.forms[0].ret_value[i].value.split(\",\");\n\t\t\t\tsel_man=sel_man+tmparr[4]+\",\";\n\t\t\t}else{\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t}else{\n\t\tif(document.forms[0].chk)\n\t\t{\n\t\tif(document.forms[0].chk.checked){\n\t\t\tsel=\"Y\";\t\t\t\n\t\t\tret_str=ret_str+document.forms[0].ret_value.value+\",Y\"+\"@\";\n\t\t\ttmparr=document.forms[0].ret_value.value.split(\",\");\n\t\t\tsel_man=sel_man+tmparr[4]+\",\";\n\t\t}else{\n\t\t}\n\t}\n\t}\n\tdocument.forms[0].selectMandatory.value=sel_man;\n\tvar sec_resorces_req=document.forms[0].sec_resorces_req.value;\n\tvar sec_resorces=document.forms[0].sec_resorces.value;\n\n\tif(sel_man.length >1)\n\n\t\tsel_man=sel_man.substring(0,sel_man.length -1);\n\t\tsel=\"Y\";\ndocument.forms[0].selectedResources.value=ret_str;\n\nif(sel_man.length>0)\n\t{\nparent.frames[0].document.forms[0].sec_sel.value=ret_str;\n  return true;\n\t}else\n\t{\n\tparent.frames[0].document.forms[0].sec_sel.value=\'\';\n\treturn false;\n\t}\n\t\n}\n</script>\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onscroll=\'scrollTitle();\'>\n<form name=\"recur_day_results_this\" id=\"recur_day_results_this\" method=\"post\">\n<font id=\'pp\'></font>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<div id=\'div1\'>\n<table cellpadding=0 cellspacing=0 width=\"100%\" border=\'0\'  align=\'center\'>\n<tr><td class=label><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</td></tr></table></div> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<table cellpadding=0 cellspacing=0 width=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" border=\'0\'  align=\'center\'>\n\t\t<tr><td>\n\t\t<div  id=\'divTitleTable\'>\n\t\t<table cellpadding=0 cellspacing=0 width=\'100%\' border=\'1\'  align=\'center\'>\n\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\n\t\t\t\t\t\t <th  align=middle width=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<br>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="-";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </table></div></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\tparent.frames[0].document.forms[0].globalFlag.value=\'false\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\n\t\t\t\t<tr><td>\n\t\t\t    <table cellpadding=0 cellspacing=0 width=\'100%\' border=\'1\' align=\'center\'>\n\t\t\t\t<tr align=middle>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<td class=\'OAQRYODD\' valign=\'abstop\' align=middle width=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><table border=\'1\'  width=\'100%\'  cellpadding=\'0\'  cellspacing=\'0\'  >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" - ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" &nbsp;<input type=\'checkbox\'  name=\'chk\' id=\'chk\'   onclick=\"enable_chk(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'ret_value\' id=\'ret_value\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'><input type=\'hidden\' name=\'ret_srl_no\' id=\'ret_srl_no\' value=\'\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'><input type=\'hidden\' name=\'ret_srl_no\' id=\'ret_srl_no\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td></tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" <input type=\'checkbox\'  name=\'chk\' id=\'chk\'   onclick=\"enable_chk(this,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td></tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t<tr><td class=\'slotFull\'  width=\'20%\' nowrap title=\'Appointment Exists\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<input type=\"checkbox\" name=chk id=chk value=\"\" style=\"visibility:hidden\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ret_value\" id=\"ret_value\" value=\"\"><input type=\'hidden\' name=\'ret_srl_no\' id=\'ret_srl_no\' value=\'\'></td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<tr><td class=\'slotBlocked\' width=\'20%\' nowrap title=\'Block Exists\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="<input type=\"checkbox\" name=chk id=chk value=\"\" style=\"visibility:hidden\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"ret_value\" id=\"ret_value\" value=\"\"><input type=\'hidden\' name=\'ret_srl_no\' id=\'ret_srl_no\' value=\'\'></td></tr>\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</table></td>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n </tr>\n\t</table> \n\t</td></tr></table>\n\t<input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t<input type=\'hidden\' name=\'sysdt\' id=\'sysdt\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<input type=\'hidden\' name=\'systm\' id=\'systm\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type=\'hidden\' name=\'sec_resorces_req\' id=\'sec_resorces_req\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<input type=\'hidden\' name=\'sec_resorces_req1\' id=\'sec_resorces_req1\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t<input type=\'hidden\' name=\'sec_resorces\' id=\'sec_resorces\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\'hidden\' name=\'sec_resorcesT\' id=\'sec_resorcesT\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\'hidden\' name=\'sec_req\' id=\'sec_req\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<input type=\'hidden\' name=\'first_set_value\' id=\'first_set_value\' value=\'\'>\n\t<input type=\'hidden\' name=\'sec_set_value\' id=\'sec_set_value\' value=\'\'>\n\t<input type=\'hidden\' name=\'sel_secondary\' id=\'sel_secondary\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<input type=\'hidden\' name=\'sec_res_id\' id=\'sec_res_id\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t<input type=\'hidden\' name=\'selectedResources\' id=\'selectedResources\' value=\'\'>\n\t<input type=\'hidden\' name=\'selectMandatory\' id=\'selectMandatory\' value=\'\'>\n\t<input type=\'hidden\' name=\'SecResFunc\' id=\'SecResFunc\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\'hidden\' name=\'from_page\' id=\'from_page\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t<input type=\'hidden\' name=\'secold_val\' id=\'secold_val\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t<input type=\'hidden\' name=\'chk_val\' id=\'chk_val\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\n\n\n</form>\n\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n<script>\nvar x=document.forms[0].SecResFunc.value;\nvar y=document.forms[0].sel_secondary.value;\nif (x==\"SecResFunc\" && y!=\'\'){\n\tretain();\n}\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

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
				


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
				

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String clinic_code=request.getParameter("Clinic_Code");
		if(clinic_code ==null)clinic_code="";
		String From_time_param=request.getParameter("From_time");
		if(From_time_param ==null)From_time_param="";
		String To_time_param=request.getParameter("To_time");
		if(To_time_param ==null)To_time_param="";
		String sec_req=request.getParameter("sec_req");
		String Appt_date=request.getParameter("Appt_date");
		if(Appt_date ==null)Appt_date="";
		String from_page=request.getParameter("from_page");
		if(from_page==null)from_page="";
				
		String row_cnt=request.getParameter("row_cnt");
		if(row_cnt==null)row_cnt="";
		String sec_resorces=request.getParameter("sec_resorces");
		if(sec_resorces ==null)sec_resorces="";
		String sec_resorces_req=request.getParameter("sec_resorces_req");
		String sec_resorces_req1=request.getParameter("sec_resorces_req");
		String sec_resorces1=request.getParameter("sec_resorces1");
		String sel_secondary=(String) session.getValue("SEC_RES_SEL");
		String facilityid=(String)session.getValue("facility_id");
		String clinic_name = request.getParameter("clinic_name_sec");
		if(clinic_name ==null)clinic_name="";
		String care_locn_desc =request.getParameter("care_locn_desc_sec");
		if(care_locn_desc ==null) care_locn_desc="";
		String res_pri_class_desc = request.getParameter("res_pri_class_desc");
		if(res_pri_class_desc ==null) res_pri_class_desc="";
		String pract_pri_name=request.getParameter("pract_name_pri");
		if(pract_pri_name==null) pract_pri_name="";
		String visit_type_desc = request.getParameter("visit_type_des");
		if(visit_type_desc ==null) visit_type_desc="";
		String secold_val	=(String) session.getValue("sec_resc_val_old");
		if(secold_val ==null) secold_val="";

		String chk_val=request.getParameter("chk_val");
		if(chk_val ==null) chk_val="";
		String sec_res_id="";
		String sec_res_name="";
		String SecResFunc=request.getParameter("from")==null?"":request.getParameter("from");
		String systm =request.getParameter("ServerTime");
		if(systm ==null) systm="";
		String sysdt=request.getParameter("ServerDate");
		if(sysdt ==null) sysdt="";
		String token="";
		String token1="";
		String res_id1="";
		String time_tb_type="";
		int cpRs= 0;
		int cpRs1=0;
		int cpRs2=0;
		int cpRs3=0;
		

		java.util.ArrayList arrlst=new java.util.ArrayList();
		java.util.ArrayList arrlst2=new java.util.ArrayList();
		java.util.ArrayList arrlst3=new java.util.ArrayList();
		java.util.ArrayList arrlst1=new java.util.ArrayList();
		java.util.ArrayList arrlstmain1=new java.util.ArrayList();
		//java.util.ArrayList resTypeArr=new java.util.ArrayList();
		java.util.ArrayList element1=new java.util.ArrayList();
		java.util.ArrayList element2=new java.util.ArrayList();
		String str="";
		String prevToken="";
		String prevToken1="";
		Connection conn = null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		//ResultSet rs3=null;
		String res_id="";
		String res_id2="";
		String resor_class="";
		String res_name="";
		String res_description="";
		StringBuffer str1=new StringBuffer();
		StringBuffer str2=new StringBuffer();
		String srl_no="";
		String status="";
		String classValue="";
		String checked="";
		int xy=0;
		int xyz=0;
		String totSoltsBooked="";
		int availableSlots=0;
		String totSlots="";
		int noOfCol=0;
		String width="";
		String tabWidth="";
		int ijk=0;
		String locale=(String)session.getAttribute("LOCALE"); 

		

		

            _bw.write(_wl_block8Bytes, _wl_block8);
try{
		conn = ConnectionManager.getConnection(request);
		stmt=conn.createStatement();	
		
		StringBuffer secRes=new StringBuffer();
		String tok="";
		String resc_desc="";
		
		StringTokenizer st = new StringTokenizer(sec_req,"-");
		StringTokenizer st1=null;
		String resCF="",man="";
		StringBuffer mandatory=new StringBuffer("");
		String mandatory1="";
		StringBuffer sec_resorces_req_one=new StringBuffer("");
		String sec_resorces_req_two="";
		String secRes_one="";
		sec_resorces_req_one.append(sec_resorces_req);
				

			while(st.hasMoreTokens())
			{
				 tok=st.nextToken();
				 st1=new StringTokenizer(tok,"*");
				 resCF=st1.nextToken();
				 man=st1.nextToken();

				 secRes.append("'");
				 secRes.append(resCF);
				 secRes.append("',");
				 sec_resorces_req_one.append(man);
				 sec_resorces_req_one.append(",");
				 if (man.equals("Y"))
				 {
					mandatory.append(((resCF.equals("E"))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels"):(resCF.equals("P"))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"):(resCF.equals("O"))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels"):com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")));
					mandatory.append("-");
				}
			}
			 if (secRes.length()>1)
			{
			 secRes_one=secRes.toString();
			 secRes_one=secRes_one.substring(0,secRes.length()-1);
			 sec_resorces=secRes_one;
			}
			 if (sec_resorces_req_one.length()>1)
			{
				 sec_resorces_req_two=sec_resorces_req_one.toString();
			 sec_resorces_req_two=sec_resorces_req_two.substring(0,secRes.length()-1);
			}
			 if (mandatory.length()>1)
			{
				 mandatory1=mandatory.toString();
				 mandatory1=mandatory1.substring(0,mandatory1.length()-1);
			}

		
	 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mandatory1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((mandatory1.length()>1)?"&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>":""));
            _bw.write(_wl_block11Bytes, _wl_block11);


	//str="select nvl(practitioner_id,'*') practitioner_id,resource_class,nvl(TOTAL_SLOTS_BOOKED,'0') TOTAL_SLOTS_BOOKED,MAX_PATIENTS_PER_DAY from oa_clinic_schedule where clinic_code='"+clinic_code+"'  and  clinic_date=to_date('"+Appt_date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and primary_resource_yn='N' and resource_class in ("+secRes_one+")and time_table_type in (1,2) order by resource_class,resource_type";
	//str="select nvl(practitioner_id,'*') practitioner_id,resource_class,nvl(TOTAL_SLOTS_BOOKED,'0') TOTAL_SLOTS_BOOKED,MAX_PATIENTS_PER_DAY from oa_clinic_schedule where clinic_code=?  and  clinic_date=to_date(?,'dd/mm/yyyy') and facility_id=? and primary_resource_yn='N' and resource_class in (?)and time_table_type in (1,2) order by resource_class,resource_type";
	str = "SELECT NVL(practitioner_id, '*') practitioner_id, resource_class, NVL(TOTAL_SLOTS_BOOKED, '0') TOTAL_SLOTS_BOOKED, MAX_PATIENTS_PER_DAY " +
      "FROM oa_clinic_schedule " +
      "WHERE clinic_code = ? AND clinic_date = TO_DATE(?, 'dd/mm/yyyy') AND facility_id = ? " +
      "AND primary_resource_yn = 'N' AND resource_class IN (" + secRes_one + ") " +
      "AND time_table_type IN (1,2) " +
      "ORDER BY resource_class, resource_type"; // Modified to use dynamic secRes_one ML-MMOH-SCF-3103
	//rs=stmt.executeQuery(str);
	pstmt = conn.prepareStatement(str);
	pstmt.setString(1,clinic_code);
	pstmt.setString(2,Appt_date);
	pstmt.setString(3,facilityid);
/*  pstmt.setString(4,secRes_one); */ //COMMENTED FOR ML-MMOH-SCF-3103
	rs = pstmt.executeQuery(); 

	 if(rs !=null ) 
	{
		while(rs.next())
		{
			arrlst.add(rs.getString("practitioner_id"));
			arrlst.add(rs.getString("resource_class"));
			if(rs.getString("resource_class").equals("P"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(rs.getString("resource_class").equals("R"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(rs.getString("resource_class").equals("E"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(rs.getString("resource_class").equals("O"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				}
				arrlst.add(resc_desc);
			arrlst.add(rs.getString("TOTAL_SLOTS_BOOKED"));
			arrlst.add(rs.getString("MAX_PATIENTS_PER_DAY"));
		}

	} 
	 noOfCol=(arrlst.size()/5);
  switch(noOfCol){
	case 1: width="'100%'";tabWidth="'100%'";break;
	case 2: width="'50%'";tabWidth="'100%'";break;
	case 3: width="'33%'";tabWidth="'100%'";break;
	case 4: width="'25%'";tabWidth="'100%'";break;
	case 5: width="'20%'";tabWidth="'100%'";break;
  }
					
	if(arrlst.size()>0)
	{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tabWidth));
            _bw.write(_wl_block13Bytes, _wl_block13);

					for (int i=0;i<arrlst.size();i+=5)
					{
						resor_class=(String) arrlst.get(i+1);
						sec_res_id=resor_class;
						
						res_id=(String) arrlst.get(i);
						res_id2=res_id;
						if(res_id.equals("*"))
						{
							res_id="";
							res_id2="*";
						}
						sec_res_name=(String) arrlst.get(i+2);	
						if(resor_class.equals("P"))
						{
							//str1  = "select a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc from am_practitioner_lang_vw a, am_pract_type_lang_vw b where nvl(a.practitioner_id,'x')=nvl('"+res_id+"','x') and b.pract_type=a.pract_type and a.language_id = '"+locale+"' and a.language_id = b.language_id ";

							str1.append("select a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc from am_practitioner_lang_vw a, am_pract_type_lang_vw b where b.pract_type=a.pract_type and a.language_id = '"+locale+"' and a.language_id = b.language_id ");

							if(res_id.equals("")){
								str1.append(" and a.practitioner_id is null");
							}else{
								str1.append(" and a.practitioner_id ='"+res_id+"'");
							}
						}else if(resor_class.equals("R"))
						{
							//str1  = "select a.room_type res_type, a.short_desc descrip, b.short_desc res_desc from am_facility_room_lang_vw a, am_care_locn_type_lang_vw b where nvl(a.room_num,'x')=nvl('"+res_id+"','x') and a.OPERATING_FACILITY_ID='"+facilityid+"' and a.room_type=b.LOCN_TYPE and a.language_id = '"+locale+"' and a.language_id = b.language_id";
							str1.append("select a.room_type res_type, a.short_desc descrip, b.short_desc res_desc from am_facility_room_lang_vw a, am_care_locn_type_lang_vw b where a.OPERATING_FACILITY_ID='"+facilityid+"' and a.room_type=b.LOCN_TYPE and a.language_id = '"+locale+"' and a.language_id = b.language_id ");
							if(res_id.equals("")){
								str1.append(" and a.room_num is null");
							}else{
								str1.append(" and a.room_num ='"+res_id+"'");
							}

						}else
						{
							//str1  = "select a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc from am_resource_lang_vw a, am_resource_type_lang_vw b where nvl(a.resource_id,'x')=nvl('"+res_id+"','x') and a.facility_id= '"+facilityid+"' and a.resource_Class='"+resor_class+"' and a.resource_type=b.resource_type and a.language_id = '"+locale+"' and a.language_id = b.language_id";
							str1.append("select a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc from am_resource_lang_vw a, am_resource_type_lang_vw b where a.facility_id= '"+facilityid+"' and a.resource_Class='"+resor_class+"' and a.resource_type=b.resource_type and a.language_id = '"+locale+"' and a.language_id = b.language_id ");
							if(res_id.equals("")){
								str1.append(" and a.resource_id is null");
							}else{
								str1.append(" and a.resource_id ='"+res_id+"'");
							}
						}
						rs1=stmt.executeQuery(str1.toString());

						str1.setLength(0);
					
						if(rs1!=null && rs1.next())
						{
							res_name= rs1.getString("descrip") ;
							res_description= rs1.getString("res_desc") ;
							//resTypeArr.add(res_description);
						}
						if(rs1 !=null) rs1.close();
						totSoltsBooked=(String)arrlst.get(i+3);
						totSlots=(String)arrlst.get(i+4);
						availableSlots=Integer.parseInt(totSlots)-Integer.parseInt(totSoltsBooked);
						 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(width));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sec_res_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_description));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(totSoltsBooked));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(totSlots));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(availableSlots));
            _bw.write(_wl_block20Bytes, _wl_block20);
	
							
						//str2="select resource_class,time_table_type,srl_no,nvl(schedule_status,'N') status,to_char(slot_slab_start_time,'HH24:mi') sttm,to_char(slot_slab_end_time,'HH24:mi') endtm,slot_slab_start_time from oa_clinic_schedule_slot_slab where clinic_code='"+clinic_code+"' and facility_id= '"+facilityid+"' and nvl(practitioner_id,'x')=nvl('"+res_id+"','x') and clinic_date=to_date('"+Appt_date+"','dd/mm/yyyy') and resource_class='"+resor_class+"' order by slot_slab_start_time,srl_no";
						str2.append("select resource_class,time_table_type,srl_no,nvl(schedule_status,'N') status,to_char(slot_slab_start_time,'HH24:mi') sttm,to_char(slot_slab_end_time,'HH24:mi') endtm,slot_slab_start_time from oa_clinic_schedule_slot_slab where clinic_code='"+clinic_code+"' and facility_id= '"+facilityid+"' ");
						if(res_id.equals("")){
							str2.append(" and practitioner_id is null");
						}else{
							str2.append(" and practitioner_id ='"+res_id+"'");
						}
						str2.append(" and clinic_date=to_date('"+Appt_date+"','dd/mm/yyyy') and resource_class='"+resor_class+"' order by slot_slab_start_time,srl_no ");

						rs2=stmt.executeQuery(str2.toString());
						str2.setLength(0);

						if(rs2 !=null )
						{
							arrlst3=new java.util.ArrayList();
							xy=0;
							while(rs2.next())
							{
									
								arrlst2=new java.util.ArrayList();
								arrlst2.add(res_id2);
								arrlst2.add(res_name);						
								arrlst2.add(rs2.getString("srl_no"));
								arrlst2.add(rs2.getString("time_table_type"));
								arrlst2.add(rs2.getString("status"));
								arrlst2.add(rs2.getString("sttm"));
								arrlst2.add(rs2.getString("endtm"));
								arrlst2.add(rs2.getString("resource_class"));
								arrlst3.add(arrlst2);	
								xy++;
							}
								if(xy>xyz)
								{
									xyz=xy;
								}

							arrlstmain1.add(arrlst3);

						}
						if(rs2 !=null) rs2.close();
					}//end of for loop
				
				
            _bw.write(_wl_block21Bytes, _wl_block21);
}else { 
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block23Bytes, _wl_block23);
	
			
						
	for (int i=0;i<arrlstmain1.size();i++)
	{

		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(width));
            _bw.write(_wl_block25Bytes, _wl_block25);


		 element1=(ArrayList) arrlstmain1.get(i);
			int new_indx=0;
			ijk=0;

			for (int j=0;j<element1.size();j++)
			{
				 element2=(ArrayList) element1.get(j);
		
				for (int jk=0;jk<element2.size();jk+=8)
				{

						
					try
					{
						res_id1=(String) element2.get(0);
						token=(String) element2.get(5);
						token1=(String) element2.get(6);
						status=(String) element2.get(4);
						srl_no=(String) element2.get(2);
						time_tb_type=(String)element2.get(3);
						resor_class=(String) element2.get(7);
					}catch(Exception ex){
						token="";
						token1="";
						status="";
					
					}
				
				if ( ijk % 2 == 0 )
					classValue = "OAQRYEVEN" ;
				else
					classValue = "OAQRYODD" ;
				  if (SecResFunc.equals("")){ 
                  if (!(time_tb_type.equals("2")&& prevToken.equals(token)&&prevToken1.equals(token1))) {
					
					 cpRs= token.compareTo(From_time_param);
					 cpRs1=token.compareTo(To_time_param);
					 cpRs2=token1.compareTo(From_time_param);
					 cpRs3=token1.compareTo(To_time_param);

					
					if ((cpRs>=0 &&cpRs1<=0) && (cpRs2>=0 &&cpRs3<=0)) {
						//checked="checked";
						checked="";
					}else{
						checked="";
					}
					
				prevToken=token;
				prevToken1=token1;
			}else{
			checked="";
			}
			}
									

				if(status.equals("N")){

						
				if(arrlst1.size() >0){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(token));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(from_page.equals("")) {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_id1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Appt_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resor_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(time_tb_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_id1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Appt_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resor_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(time_tb_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_cnt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(token));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(from_page.equals("")) {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_id1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Appt_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resor_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(time_tb_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_id1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Appt_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resor_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(time_tb_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_cnt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
 }
            _bw.write(_wl_block40Bytes, _wl_block40);
}else if(status.equals("1")){
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(token));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else if(status.equals("B")){ 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(token));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(token1));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
			
				
				new_indx++;
					
				}
				ijk++;

			element2.clear();

			}
			
			
            _bw.write(_wl_block45Bytes, _wl_block45);
element1.clear();
									

}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(Appt_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(sysdt));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(systm));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(sec_resorces_req_one.toString()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(sec_resorces_req1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sec_resorces));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(sec_resorces1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(sec_req));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(sel_secondary));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(sec_res_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(SecResFunc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(secold_val));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block60Bytes, _wl_block60);

	//if (rs3!=null) rs3.close();
	if (rs!=null) rs.close();
	if (rs1!=null) rs1.close();
	if(rs2 !=null)rs2.close();
	if (stmt!=null) stmt.close();
	arrlst.clear();
	arrlst2.clear();
	arrlst3.clear();
	arrlst1.clear();
	arrlstmain1.clear();
	element1.clear();
	element2.clear();
	//resTypeArr.clear();
}catch(Exception ex){
	ex.printStackTrace();

}finally
{
  if (conn !=null) ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block61Bytes, _wl_block61);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.available.label", java.lang.String .class,"key"));
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
