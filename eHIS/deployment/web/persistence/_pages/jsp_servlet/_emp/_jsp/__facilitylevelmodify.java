package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __facilitylevelmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/FacilityLevelModify.jsp", 1709118617369L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eMP/js/FacilityLevel.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body  OnMouseDown=\'CodeArrest()\' onLoad=\"FocusFirstElement()\" onKeyDown = \'lockKey()\'>\n<form name=\"facility_level_form\" id=\"facility_level_form\" action=\"../../servlet/eMP.FacilityLevelServlet\" method=\"post\" target=\"messageFrame\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<div align=\"left\">\n <br><br><br><br><br>\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"90%\" align=center>\n    <tr>\n    \t<td width=\"35%\">&nbsp;</td>\n    \t <td width=\"60%\">&nbsp;</td>\n  </tr>\n    <tr>\n      <td width=\"35%\" class=\"label\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n      <td width=\"65%\"  class=\'fields\' ><input type=\"text\" name=\"Facility_Name\" id=\"Facility_Name\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" size=\'40\' readonly></td>\n    </tr>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    </table>\n    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" align=center>\n  \t<tr>\n    \t\t<td class=\'columnheader\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n    \t</tr>\n    </table>\n\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" align=center>\n  \t<tr>\n  \t    \t<td width=\"100%\" class=\"BORDER\">\n  \t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"80%\" align=center>\n               <tr><td colspan=\'\'>&nbsp;</td></tr>\n\t\t\t\t<tr>\n  \t\t\t\t<td class=\"querydata\" colspan=0>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n    \t\t\t\t<td class=\"querydata\" colspan=2>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n    \t\t\t\t<!-- <td align=left width=25% class=\"label\" colspan=2>&nbsp;<b>Default Soundex Type</b></td> -->\n    \t\t\t</tr>\n    \t\t\t<tr>\n    \t\t\t\t<td  class=\"fields\" width=\'50%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t       \t\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    \t\t\t\t</td>\n    \t\t\t\t<td class=\'fields\' width=\'40%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n    \t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n    \t\t\t\t</td>\n\t\t\t\t\t<!--<td align=\"left\" class=\"label\" width=5%>&nbsp;&nbsp;</td>-->\n\t\t\t\t<!-- <td width=30% align=\"left\" class=\"label\">\n\t\t\t\t<select name=\"Soundex\" id=\"Soundex\" >\n                            ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                            </select>\n\t\t\t\t</td> -->\n    \t\t\t\t<!--<td align=\"left\" class=\"label\" width=1%>&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=24% align=\"left\" class=\"label\">Generic\n\t\t\t\t</td>-->\n    \t\t\t</tr>\n\t\t\t\t<tr>\n    \t\t\t\t<td  class=\"fields\" width=5%>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t       \n\t\t\t\t     ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n    \t\t\t\t</td>\n    \t\t\t\t<td  class=\"fields\" width=45%>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t    \t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t    \t</td>\n\t\t\t    \t<!--<td align=\"left\" class=\"label\" width=5%>&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t        </td>\n\t\t\t        <td width=24% align=\"left\" class=\"label\">Ethnic\n\t\t\t\t</td>-->\n\t\t\t</tr>\n  \t\t\t</table>\n\t\t</td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t     <tr>\n\t  \t<td colspan=2>&nbsp;</td>\n  </tr> \n\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n  \t<!-- <tr>\n  \t  \t<th align=left><b>Registration Output</b></th>\n  \t </tr>\n\t  <tr>\n\t  \t<td width=100% class=\"BORDER\">\n\t  \t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n  \t\t\t<tr>\n\t\t\t    \t<td width=23% align=\"right\" class=\"label\">Patient Card Title</td>\n\t\t\t    \t<td width=77% align=\"left\">\n\t\t\t\t&nbsp;<input type=\"text\" name=\"Patient_Card_Title\" id=\"Patient_Card_Title\" size=\"40\" maxlength=\"40\" Value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></td>\n\t\t\t </tr>\n\t\t\t <tr><td width=23% align=\"right\" class=\"label\">Face Sheet Declaration</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_1\' id=\'Face_Sheet_1\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_2\' id=\'Face_Sheet_2\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_3\' id=\'Face_Sheet_3\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_4\' id=\'Face_Sheet_4\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_5\' id=\'Face_Sheet_5\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_6\' id=\'Face_Sheet_6\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_7\' id=\'Face_Sheet_7\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_8\' id=\'Face_Sheet_8\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_9\' id=\'Face_Sheet_9\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></td></tr>\n\t\t\t <tr><td width=23%>&nbsp;</td><td width=77% align=\'left\' valign=\'top\'>&nbsp;<input type=\'text\' name=\'Face_Sheet_10\' id=\'Face_Sheet_10\' size=\'70\' maxlength=\'80\' onBlur=\"makeValidString(this);\" Value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></td></tr>\n\t\t\t\n\t\t\t <tr>\n\t\t\t \t\t\t<td width=\'23%\'>&nbsp;</td>\n\t\t\t \t\t\t<td width=\'77%\'>&nbsp;</td>\n\t\t\t</tr>\n  \t\t</table>\n\t</td>\n</tr>\n -->\n    <input type=\'hidden\' name=\'Facility_Id\' id=\'Facility_Id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n</table>\n</div>\n<input type=\"hidden\" name=\"function1\" id=\"function1\" value=\"modify\">\n<input type=\"hidden\" name=\"terminal_digit_count\" id=\"terminal_digit_count\" value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">\n<input type=\"hidden\" name=\"terminal_digit1_position\" id=\"terminal_digit1_position\" value=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =">\n<input type=\"hidden\" name=\"terminal_digit2_position\" id=\"terminal_digit2_position\" value=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n<input type=\"hidden\" name=\"terminal_digit3_position\" id=\"terminal_digit3_position\" value=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n<input type=\"hidden\" name=\"terminal_digit4_position\" id=\"terminal_digit4_position\" value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =">\n<input type=\"hidden\" name=\"terminal_digit5_position\" id=\"terminal_digit5_position\" value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n<input type=\"hidden\" name=\"terminal_reqd\" id=\"terminal_reqd\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"Numbering\" id=\"Numbering\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"Chart\" id=\"Chart\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
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

            _bw.write(_wl_block1Bytes, _wl_block1);
 String facility_id = request.getParameter("facility_id"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;

	String facility_name = "";
	String Chart = "";
	String Numbering ="";
	String Soundex ="";
	String CardTitle ="";
	String Line1 ="";
	String Line2 ="";
	String Line3 ="";
	String Line4 ="";
	String Line5 ="";
	String Line6 ="";
	String Line7 ="";
	String Line8 ="";
	String Line9 ="";
	String Line10 ="";
	String terminal_digit_count="";
	String terminal_digit1_position="";
	String terminal_digit2_position="";
	String terminal_digit3_position="";
	String terminal_digit4_position="";
	String terminal_digit5_position="";
	String tm_req="";
    PreparedStatement pstmt1 =null;
	ResultSet rs3=null;

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try {
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement("Select facility_name from sm_facility_param where facility_id ='"+facility_id+"' order by facility_name");
		rset = pstmt.executeQuery();
		if (rset.next()) facility_name = rset.getString("facility_name");
		try{
			pstmt1 = con.prepareStatement("Select terminal_digit_reqd_yn from mp_param");
		rs3= pstmt1.executeQuery();
		if(rs3.next())
		{
			tm_req=rs3.getString(1);
			if(tm_req==null)tm_req="N";
		}
		pstmt=con.prepareStatement("select Single_Or_Multi_Files_Ind, Separate_File_No_Yn, Dflt_Sndx_Type,Id_Card_Title,terminal_digit_count, terminal_digit1_position,terminal_digit2_position, terminal_digit3_position,terminal_digit4_position, terminal_digit5_position,Line1_Face_Sheet_Text,Line2_Face_Sheet_Text, Line3_Face_Sheet_Text,Line4_Face_Sheet_Text,Line5_Face_Sheet_Text,Line6_Face_Sheet_Text,  Line7_Face_Sheet_Text,Line8_Face_Sheet_Text,Line9_Face_Sheet_Text,Line10_Face_Sheet_Text from mp_param_for_facility where facility_id='"+facility_id+"'");
			rset = pstmt.executeQuery();
			if(rset.next()) 
			{
		    	terminal_digit_count = rset.getString("terminal_digit_count")==null ? "" : rset.getString("terminal_digit_count");
		    	terminal_digit1_position = rset.getString("terminal_digit1_position")==null ? "" : rset.getString("terminal_digit1_position");
		    	terminal_digit2_position = rset.getString("terminal_digit2_position")==null ? "" : rset.getString("terminal_digit2_position");
		    	terminal_digit3_position = rset.getString("terminal_digit3_position")==null ? "" : rset.getString("terminal_digit3_position");
		    	terminal_digit4_position = rset.getString("terminal_digit4_position")==null ? "" : rset.getString("terminal_digit4_position");
		    	terminal_digit5_position = rset.getString("terminal_digit5_position")==null ? "" : rset.getString("terminal_digit5_position");
			Chart = rset.getString("Single_Or_Multi_Files_Ind")==null ? "S" : rset.getString("Single_Or_Multi_Files_Ind").trim();
			Numbering = rset.getString("Separate_File_No_Yn")==null ? "N" : rset.getString("Separate_File_No_Yn").trim();
			Soundex = rset.getString("Dflt_Sndx_Type")==null ? "" : rset.getString("Dflt_Sndx_Type").trim();
			CardTitle = rset.getString("Id_Card_Title")== null ? "" : rset.getString("Id_Card_Title").trim();
			Line1 = rset.getString("Line1_Face_Sheet_Text")==null ? "" : rset.getString("Line1_Face_Sheet_Text").trim();
			Line2 = rset.getString("Line2_Face_Sheet_Text")==null ? "" : rset.getString("Line2_Face_Sheet_Text").trim();
			Line3 = rset.getString("Line3_Face_Sheet_Text")==null ? "" : rset.getString("Line3_Face_Sheet_Text").trim();
			Line4 = rset.getString("Line4_Face_Sheet_Text")==null ? "" : rset.getString("Line4_Face_Sheet_Text").trim();
			Line5 = rset.getString("Line5_Face_Sheet_Text")==null ? "" : rset.getString("Line5_Face_Sheet_Text").trim();
			Line6 = rset.getString("Line6_Face_Sheet_Text")==null ? "" : rset.getString("Line6_Face_Sheet_Text").trim();
			Line7 = rset.getString("Line7_Face_Sheet_Text")==null ? "" : rset.getString("Line7_Face_Sheet_Text").trim();
			Line8 = rset.getString("Line8_Face_Sheet_Text")==null ? "" : rset.getString("Line8_Face_Sheet_Text").trim();
			Line9 = rset.getString("Line9_Face_Sheet_Text")==null ? "" : rset.getString("Line9_Face_Sheet_Text").trim();
			Line10 = rset.getString("Line10_Face_Sheet_Text") ==null ? "" : rset.getString("Line10_Face_Sheet_Text").trim();
			}
		}catch(Exception e) { out.println(e.toString());}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rset != null) rset.close();
		}
		
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rset != null) rset.close();
		if (pstmt1 != null) pstmt1.close();
		if (rs3 != null) rs3.close();		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block9Bytes, _wl_block9);

			if(tm_req.equals("N"))
			{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

					String Numdisable = "";
					String SeparateCheck = "checked";
					//String MRNSameCheck = "";
					if(Chart.equals("M")) 
						Numdisable = "disabled";
					/*if(Numbering.equals("Y"))
					{
						SeparateCheck = "checked";
						MRNSameCheck = "";
					}
					else
					{
						SeparateCheck = "";
						MRNSameCheck = "checked";
					} */

					if(Chart.equals("S")) out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' value='S' onClick=\"checkNumberingControl('S')\" checked>");
					else out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' onClick=\"checkNumberingControl('S')\" value='S' "+Numdisable+">");
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

					String disableNumbering = "";   
					if(Chart.equals("M")) disableNumbering = "disabled";
					if(Numbering.equals("Y")) out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='Y' "+SeparateCheck+" "+disableNumbering+">"); //"+Numdisable+"
					else out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='Y' "+disableNumbering+">");
				
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

                                if (Soundex.equals(""))
                                    out.println( "<option selected value=''>--Select--" ) ;
                                else
                                    out.println( "<option value=''>--Select--" ) ;

                                if ( Soundex.equals( "G" ) )
                                    out.println( "<option selected value='G'>Generic" ) ;
                                else
                                    out.println( "<option value='G'>Generic" ) ;

                                if ( Soundex.equals( "E" ) )
									out.println( "<option selected value='E'>Ethnic" ) ;
                                else
                                   out.println( "<option value='E'>Ethnic" ) ;

                            
            _bw.write(_wl_block19Bytes, _wl_block19);

					if(Soundex.equals("G")) out.println("<input type='radio' name='Soundex' id='Soundex' value='G' Checked>");
					else out.println("<input type='radio' name='Soundex' id='Soundex' value='G'>");
				
            _bw.write(_wl_block20Bytes, _wl_block20);

					if(Chart.equals("M")) out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' value='M' onClick=\"checkNumberingControl('M')\" checked>");
					else out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' value='M' onClick=\"checkNumberingControl('M')\" >");
				
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

					if(Numbering.equals("N")) out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='N' "+SeparateCheck+" "+disableNumbering+">");
					else out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='N' "+disableNumbering+">"); //"+Numdisable+"
				
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

					if(Soundex.equals("E")) out.println("<input type='radio' name='Soundex' id='Soundex' value='E' Checked>");
					else out.println("<input type='radio' name='Soundex' id='Soundex' value='E'>");
				
            _bw.write(_wl_block25Bytes, _wl_block25);

			if(tm_req.equals("N"))
			{
		
            _bw.write(_wl_block26Bytes, _wl_block26);

			}
	if(tm_req.equals("Y"))
	{
	
            _bw.write(_wl_block27Bytes, _wl_block27);

		
		}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(CardTitle));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Line1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Line2));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Line3));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Line4));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Line5));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Line6));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Line7));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(Line8));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Line9));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(Line10));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(terminal_digit_count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(terminal_digit1_position));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(terminal_digit2_position));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(terminal_digit3_position));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(terminal_digit4_position));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(terminal_digit5_position));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tm_req));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Numbering));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Chart));
            _bw.write(_wl_block49Bytes, _wl_block49);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.MedicalRecordAdministration.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FileMaintenance.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NumberingControl.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.single.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.AllowseparateMRN.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.multiple.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.KeepFileNumbersameasPatientID.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
