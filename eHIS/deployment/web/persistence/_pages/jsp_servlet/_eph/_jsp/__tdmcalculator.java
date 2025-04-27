package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tdmcalculator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TDMCalculator.jsp", 1709121501249L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 25/10/2005-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<Title>TDM Calculator</Title>\n<head>\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'type=\'text/css\'></link>\n<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\n\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/ADRReporting.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../ePH/js/TDMCalculator.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<!--<title>Adverse Drug Reaction</title>!-->\n</head>\n<!-- <body> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<form name=\"formTdmCalc\" id=\"formTdmCalc\">\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n<!--\n<td class=\'label\'colspan=3>&nbsp;C<sub>post</sub>\n<input type=\'text\'  name=\"Cpost\" id=\"Cpost\" size=\'15\'  maxlength=\"10\" >\n</td>\n</tr>\n<tr>\n\n<td class=\'label\' colspan=3>&nbsp;C<sub>pre</sub>&nbsp;\n<input type=\'text\'  name=\"Cpre\" id=\"Cpre\"  size=\'15\'  maxlength=\"10\" >\n</td>\n</tr>\n!-->\n<tr>\n<td align = \'left\' width=\"40%\" colspan=1>&nbsp;</td>\n<td align = \'left\'  colspan=1>&nbsp;</td>\n<td class=\'label\' align = \'right\'  colspan=1>&nbsp;<label  style=\'font-size:10;\'  id=\"clk\" >&nbsp;</label></td>\n</tr>\n<tr >\n<td align = \'left\' width=\"40%\" colspan=1>&nbsp;<SELECT name=\"result_type\" id=\"result_type\" onchange=\"dispFormula(this)\">\n\t\t\t<option value=\"\">-------------Select----------------------</option>\n\t\t\t<option value=\"KE\">Elimination rate constant (hr<sup> -1</sup>)</option>\n\t\t\t<option value=\"DSGINTVL\">Dosing intervals (hrs)</option>\n\t\t\t<option value=\"DSGHLF\">Dosing intervals (1/2 hrs)</option>\n\t\t\t<option value=\"VLDSN\">Volume distribution (L/kg)</option>\n\t\t\t<option value=\"NWTRGH\">new dose (mg) for trough concentration</option>\n\t\t\t<option value=\"NWPK\">new dose (mg) for Peak concentration</option>\n\t\t\t<option value=\"WTHLDPRE\">Withold time (hr) Pre Level </option>\n\t\t\t<option value=\"WTHLDPOST\">Withold time (hr) Post Level </option>\n\t\t\t<!--<option value=\"WTHLDPREPST\">Withold time (hr) Pre & Post Level </option>!-->\n\t\t\t<option value=\"CRCL\">CrCl (ml/min)  </option>\n\t\t\t<option value=\"CLA\">Clearance (L/hr)</option>\n\t\t\t<option value=\"MINS\">Exp Min Serum Conc at steady state (mcg/ml) </option>\n\t\t\t<option value=\"MAXS\">Exp Max Serum Conc at steady state (mcg/ml) </option>\n\t\t\t<option value=\"DSE\">Dose(mg) </option>\n\t\t\t\n\t\t\t</SELECT>\n\t\t</td>\n\n\t\t<td  class=\'label\'  align = \'left\' colspan=2 >\n       <label id=\"fdisp\" style=\"visibility:hidden;\" ></label></td>\n&nbsp;</td>\n\t\t</td>\n\t\t</tr>\n\n<tr>\n<td align = \'left\' width=\"40%\" colspan=1>&nbsp;</td>\n<td align = \'left\'  colspan=1>&nbsp;</td>\n<td align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n<tr>\n<td align = \'left\' width=\"40%\" colspan=1>&nbsp;</td>\n<td align = \'right\'  colspan=1>&nbsp;<input type=\'radio\' name=\"male\" id=\"male\" style=\"visibility:hidden\" value=\"\" onclick=\"dispMal(this)\" checked></input><label  style=\'font-size:10;\'  id=\"malelb\" style=\"visibility:hidden;\">Male</label>&nbsp;<input type=\'radio\' id=\"female\" name=\"female\" id=\"female\" style=\"visibility:hidden;\" value=\"\" onclick=\"dispFem(this)\"></input><label  style=\'font-size:9;\'  id=\"femlb\" style=\"visibility:hidden;\">Female</label></td>\n<td align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n<div id=\"divtxt_1\"  >\n\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n<tr>\n<td align = \'right\' width=\"40%\" colspan=1>&nbsp;</td>\n<td align = \'left\'  class=\'label\'  colspan=1><label  style=\'font-size:9;\'  id=\"txtlbl_1\" style=\"visibility:hidden;\"></label>&nbsp;<input type=\'text\'  name=\"txt1\" id=\"txt1\"  size=\'15\'  maxlength=\"15\" style=\"visibility:hidden;\" onKeyPress=\"return allowValidNumber(this,event);\"></td>\n<td align = \'left\' colspan=1>&nbsp;</td>\n</tr>\n</table>\n</div>\n<div id=\"divtxt_2\"  >\n\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n\n<tr>\n<td align = \'right\' width=\"40%\" colspan=1>&nbsp;</td>\n<td align = \'left\'  class=\'label\'  colspan=1><label  style=\'font-size:9;\' id=\"txtlbl_2\" style=\"visibility:hidden;\"></label>&nbsp;<input type=\'text\'  name=\"txt2\" id=\"txt2\"  size=\'15\'  maxlength=\"15\" style=\"visibility:hidden;\" onKeyPress=\"return allowValidNumber(this,event);\">\n</td>\n<td align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n</table>\n</div>\n<div id=\"divtxt_3\"  >\n\n\n\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n\n\n\n<tr>\n<td align = \'right\' width=\"40%\" colspan=1>&nbsp;</td>\n<td align = \'left\'  class=\'label\'  colspan=1><label  style=\'font-size:9;\' id=\"txtlbl_3\" style=\"visibility:hidden;\"></label>&nbsp;<input type=\'text\'  name=\"txt3\" id=\"txt3\"  size=\'15\'  maxlength=\"15\" style=\"visibility:hidden;\" onKeyPress=\"return allowValidNumber(this,event);\">\n</td>\n<td align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n</table>\n</div>\n\n<div id=\"divtxt_4\"  >\n\n\n\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n<tr>\n<td align = \'right\' width=\"40%\" colspan=1></td>\n<td align = \'left\'  class=\'label\'  colspan=1><label  style=\'font-size:9;\'  id=\"txtlbl_4\" style=\"visibility:hidden;\"></label>&nbsp;<input type=\'text\' name=\"txt4\" id=\"txt4\"  size=\'15\'  maxlength=\"15\" style=\"visibility:hidden;\" onKeyPress=\"return allowValidNumber(this,event);\">\n</td>\n\n<td align = \'left\' colspan=1>&nbsp;</td>\n</tr>\n</table>\n\n</div>\n\n<div id=\"divtxt_5\" >\n\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n<tr>\n<td align = \'right\' width=\"40%\" colspan=1></td>\n<td align = \'left\'  class=\'label\'  colspan=1><label  style=\'font-size:9;\'  id=\"txtlbl_5\" style=\"visibility:hidden;\"></label>&nbsp;<input type=\'text\' name=\"txt5\" id=\"txt5\"  size=\'15\'  maxlength=\"15\" style=\"visibility:hidden;\" onKeyPress=\"return allowValidNumber(this,event);\">\n</td>\n\n<td align = \'left\' colspan=1>&nbsp;</td>\n</tr>\n</table>\n</div>\n<table align=\"center\"  border=\"0\" colspan=3  width=\"100%\" cellspacing=\"0\"   cellpadding=\"0\" >\n<tr>\n<td  colspan=1 width=\"40%\" >&nbsp;</td>\n<td  colspan=1>&nbsp;</td>\n<td  colspan=1>&nbsp;</td>\n</tr>\n\n\n\t\t<tr>\n\t\t<td align = \'left\' width=\"40%\" colspan=1>&nbsp;</td>\n        <td align = \'left\' colspan=1><input type=\"button\" class=\"button\" value=\"Calculate\" name=\"Ke\" id=\"Ke\" onclick=\"TdmCalc(this)\" style=\"visibility:hidden;\">&nbsp;&nbsp;&nbsp;</td>\n\t\t<td align = \'left\' colspan=1>&nbsp;</td>\n\t\t</tr>\n\n<tr>\n<td  colspan=1 width=\"40%\" >&nbsp;</td>\n<td  colspan=1>&nbsp;</td>\n<td  colspan=1>&nbsp</td>\n</tr>\n\n<tr>\n<td  colspan=1 width=\"40%\" >&nbsp;</td>\n<td class=\'label\' align = \'left\'  colspan=1><label  style=\'font-size:9;\'  id=\"Reslgnd\" style=\"visibility:hidden;\"></label><strong><label  style=\'font-size:12;\' id=\"Keresult\" style=\"visibility:hidden;\"></label></strong>&nbsp;&nbsp;<label  style=\'font-size:9;\' id=\"Resunit\" style=\"visibility:hidden;\"></label></td>\n<td  colspan=1>&nbsp;</td>\n</tr>\n\n<tr>\n<td  colspan=1 width=\"40%\" >&nbsp;</td>\n<td  colspan=1>&nbsp;</td>\n<td  colspan=1>&nbsp;</td>\n</tr>\n\n<tr >\n<td class=\'label\' align = \'left\'  width=\"40%\"  colspan=1><dfn><label  style=\'font-size:10;\' id=\"footlbl_1\" style=\"visibility:hidden;\"></label></dfn></td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n<tr >\n<td class=\'label\' align = \'left\' width=\"40%\"  colspan=1><dfn><label  style=\'font-size:10;\' id=\"footlbl_2\" style=\"visibility:hidden;\"></label></dfn></td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n<tr>\n<td class=\'label\' align = \'left\' width=\"40%\"  colspan=1><dfn><label  style=\'font-size:10;\' id=\"footlbl_3\" style=\"visibility:hidden;\"></label></dfn></td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n<tr>\n<td class=\'label\' align = \'left\' width=\"40%\"  colspan=1><dfn><label  style=\'font-size:10;\' id=\"footlbl_4\" style=\"visibility:hidden;\"> </label></dfn></td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n<tr>\n<td class=\'label\' align = \'left\' width=\"40%\"  colspan=1><dfn><label  style=\'font-size:10;\' id=\"footlbl_5\" style=\"visibility:hidden;\"></label></dfn></td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n<td class=\'label\' align = \'left\'  colspan=1>&nbsp;</td>\n</tr>\n\n\n\n</table>\n\n<input type=\"hidden\" name=\"Kflag\" id=\"Kflag\"\tvalue=\"\">\n<input type=\"hidden\" name=\"Kval\" id=\"Kval\"\tvalue=\"\">\n\n\n\n</form>\n<script type=\"text/javascript\" language=\"JavaScript\">\nvar int=self.setInterval(\"getClockTime()\",50);\ntop.resizeBy(-100,-100)\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
 String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
