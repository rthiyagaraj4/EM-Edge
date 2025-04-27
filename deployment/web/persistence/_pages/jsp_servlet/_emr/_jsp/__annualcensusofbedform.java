package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __annualcensusofbedform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AnnualCensusofBedForm.jsp", 1722236026967L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<!-- <script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script> -->\n    <script src=\"../../eCommon/js/common.js\"></script> \n\t<script src=\"../../eCommon/js/messages.js\"></script>\n\t<!-- <script src=\'../../eMR/js/eMRmessages.js\' language=\'javascript\'></script> -->\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/AnnualCensusofBed.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t<script>\n\t</script>\n</head>\n<body OnMouseDown=\"CodeArrest()\" onLoad=\'callClear_l1(\"SP\")\'>\n<form name=\'annualCenBed_form\' id=\'annualCenBed_form\'  action=\'\'  method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n  <input type=hidden name=\"report_gr_id\" id=\"report_gr_id\" value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' align=\'center\'>\n\t<tr>\n      <td colspan=4></td>\n\t</tr>\n\t<tr>\n      <td colspan=4></td>\n\t</tr>\n    <tr>\n      <td colspan=4></td>\n\t</tr>\n\t  <tr>\n      <td colspan=4></td>\n\t</tr>\n\t  <tr>\n\t\t\t<td align=\'right\' width=\'14%\' class=\"label\">Census Year</td>\n\t\t\t\t<td width=\'25%\'  >&nbsp;\n\t\t\t\t\t<input type=text id=\"census_date\" name=\'p_census_date\' id=\'p_census_date\' size=\"4\" onblur=\"CheckYear(this);chkyear_fut(this);\" maxlength=\"4\" align=\"center\" onkeypress=\"return ValidStringrepIPAnnual(event)\" ><input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'census_date\',\'y\',null);\">\n\t\t\t\t\t<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t<td colspan=2></td>\n\t\t\t\t<!-- <td  class=\'label\'  width=14%  align=\'right\'>Serial No</td>\n\t  <td class=\'querydata\' width=\'11%\' id=\'fetchdata\'>&nbsp;</td> -->\n\t\t</tr>\n\t<tr>\n      <td colspan=4></td>\n\t</tr>\n\t<tr>\n      <td colspan=4></td>\n\t</tr>\n<!-- \t<tr>\n      <td colspan=4></td>\n\t</tr>\n\t<tr>\n     <td  class=\'label\'  width=14%  align=\'right\'>\n         Master</td>\n      <td colspan=1>&nbsp;\n      <select name=\"Master\" id=\"Master\" onchange=\"callClear_l1(this);clearMandatory()\">\n\t\t  <option value=\"\">---------Select----------</option>\n\t\t  <option value=\"SP\">Specialty</option>\n\t\t  <option value=\"BD\">Bed Class</option></SELECT> <img   src=\'../../eMP/images/mandatory.gif\'> &nbsp;&nbsp;<td  class=\'label\'  width=14%  align=\'right\'>Serial No</td>\n\t  <td class=\'querydata\' width=\'11%\' id=\'fetchdata\'>&nbsp;</td>\n\t \n</tr>\n<tr>\n      <td colspan=4></td>\n</tr>  -->\n <tr>\n      <td colspan=4></td>\n</tr>\n<tr>\n      <td colspan=4></td>\n</tr>\n <tr>\n      <td colspan=4></td>\n</tr>\n<tr>\n     <td align=right class=\'label\' >\n          Level1 Group\n     </td > \n     <td align=left colspan=3>&nbsp; <textarea rows=2  disabled cols=50 name=\"Main_group_desc\"   onBlur=\"level1(this);\"  readonly></textarea><input disabled type=\"button\" name=\"sub_group11\" id=\"sub_group11\" value=\"?\" class=\"BUTTON\" onClick=\"getLevelGroupId();\">\n\t\t<input type=\"hidden\" name=\"Main_group\" id=\"Main_group\">\n\t\t<img  style=\"visibility:hidden\" src=\'../../eMP/images/mandatory.gif\'  id=\'mand_gif1\'></td>\n\t</tr>\n<tr>\n    <td colspan=4></td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr> \n <tr>\n    <td colspan=4></td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr>\n    <tr>\n    <td align=right class=\'label\'>Level2 Group\n    </td>\n    <td  align=\"left\" colspan=3>&nbsp;\n\t   <textarea rows=2  cols=50  name=\"sub_group1\" readonly></textarea><input type=\"button\" name=\"sub_group12\" id=\"sub_group12\"  value=\"?\" class=\"BUTTON\" onClick=\"getSubGroupId();\">\n  \t   <input type=\"hidden\" name=\"sub_group\" id=\"sub_group\" value=\"\">\n\t\t <img src=\'../../eMP/images/mandatory.gif\' style=\"visibility:hidden\" id=\'mand_gif2\'>\n    </td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr> \n <tr>\n    <td colspan=4></td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr> \n<tr>\n    <td colspan=4></td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr> \n <tr>\n    <td colspan=4></td>\n</tr>\n<tr>\n    <td colspan=4></td>\n</tr>\n\t  <!-- <tr>\n\t\t\t<td>\n\t\t\t\t\t &nbsp;\n            </td>\n\t\t\t<td align=center class=label>\n\t\t\t\t\t From\n            </td>\n\t\t\t\t<td align=center colspan=2 class=label>\n\t\t\t\t\t To\n            \n            </td>\n\t </tr> -->\n\t<tr>\n\t\t<td colspan=4>\n\t<table border=0 width=\'100%\' align=center>\n     <tr>\n     <td  width=\'100%\' id=\'t\'></td>\n\t</tr>\n\t<tr>\n     <td  width=\'100%\' id=\'t1\'></td>\n\t</tr>\n\t\t        \n      </table>\n\t   </td>\n\n\t</tr>\n\t\t<!-- <tr><td class=label width=\'20%\' align=\'right\'>&nbsp;Search By&nbsp;&nbsp;</td><td class=\'label\' align=\'left\' width=\'33%\'><select name=\'searchby\' id=\'searchby\' onchange=\'callhidden();\'><option value=\'C\'>Code</option><option value=\'D\'>Description</option></select>&nbsp;Criteria&nbsp;<select onchange=\'callhidden();\' name=\'searchcriteria\' id=\'searchcriteria\'><option value=\'C\'>Contains</option><option value=\'S\'>Starts With</option><option value=\'E\'>Ends With</option></td><td class=label width=\'20%\' align=right>&nbsp;Text&nbsp;&nbsp;<td align=\'left\' width=\'33%\'><input type=\'text\' size=\'5\' maxlength=\'6\' name=\'alpha_desc\' id=\'alpha_desc\'><img src=\'../../eMP/images/mandatory.gif\'></td><td>&nbsp;</td></tr> -->\n\t\t<!--  <tr>\n      <td colspan=4>&nbsp;</td>\n\n  </tr>  -->\n\t\t<!-- <tr>\n\t\t<td class=label align=right>Tabulation List Desc&nbsp;&nbsp;</td>\n\t\t<td colspan=3><input type=\"text\"></td>\n\t\t</tr>  -->\n\t\t<tr>\n      <td colspan=4></td>\n\n  </tr> \n\t  <tr>\n      <td colspan=4></td>\n\n  </tr> \n\t  <tr>\n      <td colspan=4></td>\n\n  </tr> \n\t<tr>\n\t  <td class=\'label\' align=\"right\">&nbsp;</td>\n     <td class=\'querydata\' id=\'fetchdata1\'>&nbsp;</td>\n    <td colspan=2 align=right>&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"button\" class=\'button\' value=\"Search\" Onclick=\"FetchValues()\"><INPUT TYPE=\"button\" class=\'button\' value=\"Clear\" Onclick=\"clearValues()\">\n  </td>\n</tr>\n</table>\n\t\t<input type=\"hidden\" name=type value=\"\">\t\t\n\t\t<input type=\"hidden\" name=\"Report\" id=\"Report\" \tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t<input type=\"hidden\" name=\"Master\" id=\"Master\" \tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t<input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></input>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n  </form>\n  </body>\n  </html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;
	
            _bw.write(_wl_block4Bytes, _wl_block4);

    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;

	String report_gr_id			= "";   	
	String p_report_id		= "MRIPCSBD" ;
	String master		= "SP" ;
  try
   {
	con				= ConnectionManager.getConnection(request);
	stmt			= con.createStatement();
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(report_gr_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(master));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
 if(stmt!=null) stmt.close();
   if(rs!=null) rs.close();
   }
 catch(Exception e)
 {
	//out.println("Exception in File AnnualCensusofBedForm"+e.toString());
	e.printStackTrace();
 }
 finally
 {
    ConnectionManager.returnConnection(con,request);
 }

            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
