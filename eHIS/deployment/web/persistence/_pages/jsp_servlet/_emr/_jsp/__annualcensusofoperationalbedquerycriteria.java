package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __annualcensusofoperationalbedquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AnnualCensusofoperationalBedQueryCriteria.jsp", 1722236138346L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n<!-- <script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script> -->\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eMR/js/ReportCodeSetup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction execQuery()\n{\n//\tvar Report   = document.forms[0].Report_id.value\n\tvar p_census_date       = document.forms[0].p_census_date.value\n\tvar main_group = document.forms[0].main_group.value\n\tvar sub_group        = document.forms[0].sub_group.value\t\n\tvar bed_class_group        = document.forms[0].bed_class_group.value\n\tvar concatvalues=\"\";\n\tfor (i=0; i< document.forms[0].OrderbyColumns.options.length; i++)\n\t{ \n\t\tconcatvalues=concatvalues+document.forms[0].OrderbyColumns.options[i].value+\"|\";\n\t}\n       parent.frames[1].location.href=\"../../eMR/jsp/AnnualCensusofoperationalBedQueryResult.jsp?p_census_date=\"+p_census_date+\"&main_group=\"+main_group+\"&sub_group=\"+sub_group+\"&bed_class_group=\"+bed_class_group+\"&concatvalues=\"+concatvalues;\n}\nfunction addOrderByCol() { \n\t\tvar from = document.getElementById(\"OrderbyCols\"); \n\t\tif (from.options.length > 0) { \n\t\t\tvar to = document.getElementById(\"OrderbyColumns\"); \n\t\t\tvar element = document.createElement(\"OPTION\"); \n\t\t\telement.text = from.options[from.selectedIndex].text; \n\t\t\telement.value= from.options[from.selectedIndex].value; \n\t\t\tto.add(element); \t\t\t\n\t\t\tfrom.remove(from.selectedIndex); \n\t\t}\n\t} \n\t\n\tfunction removeOrderByCol()\t{ \n\t\tvar from = document.getElementById(\"OrderbyColumns\"); \n\t\tif ( from.options.length > 0 ) { \n\t\t\tvar to = document.getElementById(\"OrderbyCols\");\n\t\t\tvar element = document.createElement(\"OPTION\"); \n\t\t\telement.text = from.options[from.selectedIndex].text; \n\t\t\telement.value = from.options[from.selectedIndex].value; to.add(element);\t\t\t\n\t\t\tfrom.remove(from.selectedIndex); \n\t\t} \n\t}\t\n\t\n \n\tfunction focusObj()\n\t{\n\t\t\tdocument.forms[0].p_census_date.focus();\n\t}\t\n\t\n\t\n</script>\n<form name=\"Report_Group_form11\" id=\"Report_Group_form11\" action=\"../../eMR/jsp/ReportGroupQueryResult.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</head>\n\n\t<body onLoad=\'focusObj();\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<form name=\'report_form_query\' id=\'report_form_query\'>\n\t\t\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t         <th colspan=2 align=\'left\'>Query Criteria</th>\t\t\t\n\t         <tr>\n\t\t\t\t\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t\t\n\t\t\t\t\t<tr>\n   \t\t\t\t        <td align=\'right\' class=\'label\' nowrap>Census Year</td>\n    \t\t\t\t     <td align=\'left\' nowrap>&nbsp;<input type=\'text\' name=\'p_census_date\' id=\'p_census_date\' size=\'4\'  maxlength=\'4\'>    \t \t\t  \t\t\n    \t\t\t\t     </td>\n    \t\t\t\t</tr>\n\t\t\t\t<tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t <td align=\'right\' class=\'label\' nowrap>Level1 Group</td>\n\t\t\t\t\t<td  align=\'left\'>&nbsp;<input type=\"text\" name=\"main_group\" id=\"main_group\" size=\'20\' maxlength=\'20\'></td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t\t \n\t\t\t\t\n\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr>\n\t\t\t\t\t<td align=\'right\' class=\'label\' nowrap>Level2 Group</td>\n\t\t\t\t\t<td  align=\'left\'>&nbsp;<input type=\"text\" name=\"sub_group\" id=\"sub_group\" size=\'20\' maxlength=\'40\'></td>\n\t\t\t\t</tr>\n\n\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\t\n\t\t\t\t\t \n\t\t\t\t <td align=\'right\' class=\'label\' nowrap>Bed Class Group</td>\n\t\t\t\t\t<td  align=\'left\'>&nbsp;<input type=\"text\" name=\"bed_class_group\" id=\"bed_class_group\" size=\'20\' maxlength=\'40\'></td>\n\t\t\t\t</tr>\n\n\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\n\t\t\t\t\t <tr><td colspan=\'2\'></td></tr>\t\n\t\t\t\t\t\t\t  \n\t\n  \t\t\t</table>\n\t\t\t<table width=\'100%\' align=\'center\'>\n\t\t\t <th width=\'20%\' align=\'left\'>Sort Order</th>\n\t\t\t <tr>\n\t\t\t\t<td nowrap  width=\'60%\' >\n\t\t\t\t<p  title=\'Sort Order\'>\n\t\t <table width=\'100%\'><td nowrap  align=\'center\'><b>Select</td><td>&nbsp;</td><td nowrap align=\'center\'><b>Order by</td><tr><td nowrap width=\'45%\'  >\n\t\t\t\t<tr>\n\t\t\t\t    <td width=\"45%\" align=\"center\">\n\t\t\t\t\t\t<Select name=\"OrderbyCols\" id=\"OrderbyCols\" size=\"5\">\n\t\t\t\t\t\t   \n\t\t\t\t\t\t   <Option value=\"CENSUS_YEAR\">Census Year\n\t\t\t\t\t\t   <Option value=\"GROUP_CODE\">Level1 Group\n\t\t\t\t           <Option value=\"SUB_GROUP_CODE\">Level2 Group\n\t\t\t\t\t\t   <Option value=\"BED_CLASS_GROUP_CODE\">Bed Class Group\t\t\t  \n\t\t\t\t\t\t</Select>\n\t\t\t\t    </td>\n\t\t\t\t\t<td align=\'center\' width=\'3%\' >\n\t\t\t\t       <input type=\'button\' name=\'add\' id=\'add\' class=\'button\' onclick=\'addOrderByCol()\' value=\'---->\'> \n\t\t\t\t\t   <input type=\'button\' name=\'add\' id=\'add\' class=\'button\'  value=\'<----\' onclick=\'removeOrderByCol()\'></img>\n\t\t\t\t   </td>\n\t\t\t\t\t<td width=\"45%\" align=\"center\"><Select name=\"OrderbyColumns\" id=\"OrderbyColumns\" size=\"4\" multiple=\"true\"><Option value=\"CENSUS_YEAR\">Census Year </Select></td>\n\t\t\t\t</tr>\n\t\t\t</table><br><br></div>\n\t\t\t<table border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t <td nowrap width=\'100%\' align=\'center\'  ><input type=\'button\' name=\'ExecuteQuery\' id=\'ExecuteQuery\' class=\'Button\'  onclick=\'execQuery()\' Value=\'Execute\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t  </tr>\n\t\t </table> \n\t\t\t\t\t\t\t\t\n\n\t\t\n\t\t<input type=\'hidden\' value=\"\" name=\"concatvalues\" id=\"concatvalues\">\n\t\t<input type=\"hidden\" name=\"Report_id\" id=\"Report_id\" \tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
	
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


	String fid=(String)session.getValue("facility_id") ;
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null || facilityId.equals("")) facilityId=fid;
	String p_report_id		= "MRIPCSOBD" ;
	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	java.sql.Statement stmt=null;
	ResultSet rset=null ;
	ResultSet rset1=null ;
	String dat="";
	String id="";


	try
	{
		con = ConnectionManager.getConnection(request);
 	

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block5Bytes, _wl_block5);
	 }
	  catch(Exception e){/* out.print(e); */e.printStackTrace();}
	  finally
	  {
	  if(stmt!=null)	stmt.close();
	  if(pstmt!=null)	pstmt.close();
	  if(rset!=null)	rset.close();
		ConnectionManager.returnConnection(con,request);

	  }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
