package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __annualcensusofbedresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AnnualCensusofBedResult.jsp", 1722236096636L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t<!-- <script src=\'../../eMR/js/eMRmessages.js\' language=\'javascript\'></script> -->\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" Language=\"JavaScript\"></Script>\n\t<script src=\'../../eMR/js/AnnualCensusofBed.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\">\n\n<form name=\"annualCenBedresult\" id=\"annualCenBedresult\" action=\"../../servlet/eMR.AnnualCensusOfBedServlet\" method=\'post\' target=\"messageFrame\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<table cellspacing=0 cellpadding=0 width=\'98%\' border=1 align=\'center\'>\n   <tr>\n\t<th align=\"left\" width=15%>Bed Class Group</th>\t\n    <th align=\"left\" width=45%>Bed Class Group Description</th>\n\t ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<!--Child field Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] -->\n\t\t<th align=\"left\" width=20%>Common&nbsp;Male&nbsp;Female&nbsp;Child&nbsp;<!--Child--></th>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!-- <th width=20%>Order Serial No</th> -->\t\t\n\t\t<th width=20%>Select</th>\n\t</tr>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="    \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"count1\" id=\"count1\" value=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tab_list";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"tab_list";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tab_list_no";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"tab_list_no";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' align=center>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<INPUT TYPE=\"text\" name=\"textr1";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"textr1";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" maxLength=\'3\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"\" maxLength=\'3\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<INPUT TYPE=\"text\" name=\"textr2";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"textr2";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" maxLength=\'3\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"\" maxLength=\'3\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"textr3";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"textr3";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="<INPUT TYPE=\"text\" name=\"textr3";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"textr4";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"textr4";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<INPUT TYPE=\"text\" name=\"textr4";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] Start-->\n\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"textr4";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" maxLength=\'3\' >\n\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] End-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<!-- <td class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' align=center>\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"text";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"text";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=\'6\' maxLength=\'3\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" maxLength=\'3\' onBlur=\"chkvalidnum(this);\"></td> -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t<!--<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' align=center>\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"textr1";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"\" maxLength=\'3\' ><INPUT TYPE=\"text\" name=\"textr2";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"\" maxLength=\'3\' ><INPUT TYPE=\"text\" name=\"textr3";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"\" maxLength=\'3\' >\n\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] Start-->\n\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"textr4";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" size=\'3\' maxLength=\'3\'  onkeypress=\"return allowPositiveNumber()\"  value=\"\" maxLength=\'3\' ></td>\n\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t<!--Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120] End>\n\n\t\t\t\t\t\t\t\t<!-- <td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' align=center>\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"text";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" size=\'6\'  maxLength=\'3\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\" value=\"\" onBlur=\"chkdup(this); chkvalidnum(this);\"></td> -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' align=\'center\'><input type=\'checkbox\' name=\'inc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'inc";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' onClick=\'funchk(this)\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' checked onClick=\'funchk(this)\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t</table>\n\t\t\t\t <input type =\'hidden\' name =\'alphabet\' value =\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'report_id\' value =\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'group_code\' value =\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'sub_group_code\' value =\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'census_date\' value =\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'maxrecord\' value =\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'maxrecord1\' value =\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'concat\' value =\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'mast_table_name_reference\' value =\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'function_name1\' value =\'\'>\n\t\t\t\t <input type =\'hidden\' name =\'level_code\' value =\'\'>\n\n\t\t\t\t \n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rset			= null;
	//ResultSet	rset2			= null;//commented for checkstyle by munisekhar
	//ResultSet	rset3			= null;//commented for checkstyle by munisekhar
	StringBuffer sb=null;
	String classValue			= "";
	//String ord_cat				= "";//commented for checkstyle by munisekhar
	String chkd					= "";
	//String tab_list_no			= "";//commented for checkstyle by munisekhar
	String report_id			= "";
	String group_code			= "";
	String sub_group_code		= "";	
	String type					= "";
	StringBuffer concat		= new StringBuffer("");
	//String code_from			= "";//commented for checkstyle by munisekhar
	//String code_to				= "";//commented for checkstyle by munisekhar
	//String code_desc			= "";//commented for checkstyle by munisekhar
	//String group_type			= "";//commented for checkstyle by munisekhar
	String census_date			= "";
	int		maxrecord			= 0;
	//float   count_float			= 0; //commented for checkstyle by munisekhar
	int		count				= 0;
	int		countr1				= 0;
	int		countr2				= 0;
	int		countr3				= 0;
	int		countr4				= 0;
	try
	{
		type						= checkForNull(request.getParameter("alphabet"));
		report_id					= checkForNull(request.getParameter("report_id"));
		group_code					= checkForNull(request.getParameter("group_code"));
		sub_group_code				= checkForNull(request.getParameter("sub_group_code"));
		census_date		= checkForNull(request.getParameter("census_date"));
		type						= type.trim();
		report_id					= report_id.trim();
		group_code					= group_code.trim();
		sub_group_code				= sub_group_code.trim();
		con				            = ConnectionManager.getConnection(request);
		stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
            _bw.write(_wl_block4Bytes, _wl_block4);
 
	 if(report_id.equals("MRIPCSBD"))
		{
            _bw.write(_wl_block5Bytes, _wl_block5);
}
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	
	 // int p=0; //commented for checkstyle by munisekhar
	  sb = new StringBuffer();
	  
           if(type.equals("BD"))
		  {
				/* sb.append("SELECT BED_CLASS_CODE mast_code, short_desc, 0 cnt1, 0 cnt2, 0 cnt3, 0 cnt4, NULL group_code, 'N' chkd FROM ip_bed_class WHERE BED_CLASS_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  )) UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT short_desc from ip_bed_class where BED_CLASS_CODE = a.BED_CLASS_GROUP_CODE) short_desc,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM MR_ANNUAL_CENSUS_OF_BED a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'" );*/

				//cnt4 removed by by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120]

				 sb.append("SELECT BED_CLASS_CODE mast_code, short_desc, 0 cnt1, 0 cnt2, 0 cnt3,0 cnt4, NULL group_code, 'N' chkd FROM ip_bed_class WHERE BED_CLASS_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  )) UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT short_desc from ip_bed_class where BED_CLASS_CODE = a.BED_CLASS_GROUP_CODE) short_desc,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM MR_ANNUAL_CENSUS_OF_BED a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'" );
		  }
		  else if(type.equals("SP") && report_id.equals("MRIPCSBD"))
		  {
				/*sb.append("SELECT GROUP_CODE mast_code, group_desc short_desc,0 cnt, 0 cnt1, 0 cnt2, 0 cnt3, 0 cnt4, NULL group_code, 'N' chkd FROM mr_report_grouping WHERE report_id =  'MRIPCSBD' AND mast_table_name_reference = 'BD' AND GROUP_CODE NOT IN (SELECT BED_CLASS_GROUP_CODE FROM MR_ANNUAL_CENSUS_OF_BED WHERE ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  ) and to_char(census_year,'YYYY') = '"+census_date+"') UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT group_desc from mr_report_grouping where group_code = a.BED_CLASS_GROUP_CODE) short_desc,0 cnt,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM MR_ANNUAL_CENSUS_OF_BED a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"' and to_char(census_year,'YYYY') = '"+census_date+"'" );*/
				
				//cnt4 removed by by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120]
				sb.append("SELECT GROUP_CODE mast_code, group_desc short_desc,0 cnt, 0 cnt1, 0 cnt2, 0 cnt3,0 cnt4, NULL group_code, 'N' chkd FROM mr_report_grouping WHERE report_id =  'MRIPCSBD' AND mast_table_name_reference = 'BD' AND GROUP_CODE NOT IN (SELECT BED_CLASS_GROUP_CODE FROM MR_ANNUAL_CENSUS_OF_BED WHERE ( GROUP_CODE = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"'  ) and to_char(census_year,'YYYY') = '"+census_date+"') UNION SELECT  a.BED_CLASS_GROUP_CODE mast_code, (SELECT group_desc from mr_report_grouping where group_code = a.BED_CLASS_GROUP_CODE and report_id =  'MRIPCSBD') short_desc,0 cnt,COMM_BED_CNT cnt1,MALE_BED_CNT cnt2,FEMALE_BED_CNT cnt3,CHILD_BED_CNT cnt4, a.group_code, 'Y' chkd FROM MR_ANNUAL_CENSUS_OF_BED a WHERE   a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"' and to_char(census_year,'YYYY') = '"+census_date+"'" );
				//Above query modified for this CRF PER-PD-209
		  }
			int i=1;
			 //String count_float_string="";//commented for checkstyle by munisekhar
			// stmt			= con.createStatement();
		    		    
		//	out.println("SQL = "+sb.toString());	 
			rset	= stmt.executeQuery(sb.toString());
			
			if(rset!=null)
			 {
				rset.last();
				maxrecord = rset.getRow();
				rset.beforeFirst();
				while(rset.next())
				{
					
				    count              = rset.getInt("cnt");
					chkd               = rset.getString("chkd");			
					countr1             = rset.getInt("cnt1");
					countr2             = rset.getInt("cnt2");
					countr3             = rset.getInt("cnt3");
					countr4             = rset.getInt("cnt4");	//Commented by Dharma on Dec 2nd 2014 against HSA-CRF-0205 [IN:050120]			
					count              = rset.getInt("cnt");
   										                   
					 if ( (i+1) % 2 == 0 )
						 classValue = "QRYEVEN" ;
					 else
						 classValue = "QRYODD" ;
						
			       
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rset.getString("MAST_CODE")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(checkForNull(rset.getString("short_desc"))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rset.getString("short_desc"))));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("mast_code")));
            _bw.write(_wl_block17Bytes, _wl_block17);
 //if(countr1 > 0)
							//{
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(report_id.equals("MRIPCSBD"))
								{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(countr1>0){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(countr1));
            _bw.write(_wl_block24Bytes, _wl_block24);
 }else {
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(countr2>0){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(countr2));
            _bw.write(_wl_block29Bytes, _wl_block29);
}else {
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(countr3>0){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(countr3));
            _bw.write(_wl_block24Bytes, _wl_block24);
}else {
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(countr4>0){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(countr4));
            _bw.write(_wl_block24Bytes, _wl_block24);
}else {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(countr4));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(count));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
								else
								{}
						//	 }
						// else 
						//  {  if(report_id.equals("MRIPCSBD"))
						//		{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
//}
						//		else
							//	{}
						//  }
						 if((chkd.equals("N"))||((countr1==0)&&(countr2==0)&&(countr3==0)&&(countr4==0)))
						 {
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chkd));
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
						else 
						{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chkd));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
 i++;
				}
				 if(rset!=null) rset.close(); 
            _bw.write(_wl_block57Bytes, _wl_block57);
		
			}
			   if(maxrecord==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(type));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(report_id ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(sub_group_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(census_date));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(concat.toString()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(type));
            _bw.write(_wl_block67Bytes, _wl_block67);
  if(stmt!=null) stmt.close();
   
   }
  catch(Exception e)
  {
	  //out.println("Exception in File AnnualCensusBedResult"+e.toString());
	  e.printStackTrace();
  }
 finally
 {
    ConnectionManager.returnConnection(con,request);
 }

 
            _bw.write(_wl_block68Bytes, _wl_block68);
            _bw.write(_wl_block69Bytes, _wl_block69);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
