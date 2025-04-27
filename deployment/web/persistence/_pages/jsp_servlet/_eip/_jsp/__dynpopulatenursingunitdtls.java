package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __dynpopulatenursingunitdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DynPopulateNursingUnitDtls.jsp", 1709117754897L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n\t<script src=\'../../eIP/js/Booking.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/Booking1.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\tvar opt=parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.frames[1].document.forms[0].nursing_unit.add(opt);\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt		=	null;
	ResultSet rs		=	null;
	String facilityid = (String) session.getValue("facility_id");
	StringBuffer str			=	new StringBuffer();
	String SelectType	= request.getParameter("SelectType");
	String med_code		= request.getParameter("med_code");
	String spy_code		= request.getParameter("spy_code");
	String prt_code		= request.getParameter("prt_code");
	String p_code		= "";
	String p_desc		= "";

	if (med_code==null) med_code="";
	if (spy_code==null) spy_code="";
	if (prt_code==null) prt_code="";

try
{
	con = ConnectionManager.getConnection(request);
	stmt= con.createStatement();

	if (SelectType.equals("M"))
	{
		str.append("SELECT nursing_unit_code,Short_desc FROM IP_NURSING_UNIT WHERE FACILITY_ID='"+facilityid+"' AND NURSING_UNIT_TYPE_CODE IN (SELECT NURSING_UNIT_TYPE_CODE FROM IP_MED_SER_GRP_NURS_UT_TYPE WHERE MED_SER_GRP_CODE='"+med_code+"' AND FACILITY_ID='"+facilityid+"') AND EFF_STATUS='E'  order by 2 ");
	}
	else if (SelectType.equals("S"))
	{
		str.append(" SELECT nursing_unit_code,Short_desc FROM IP_NURSING_UNIT WHERE FACILITY_ID='"+facilityid+"' AND EFF_STATUS='E' AND NURSING_UNIT_TYPE_CODE IN (SELECT NURSING_UNIT_TYPE_CODE FROM IP_MED_SER_GRP_NURS_UT_TYPE WHERE MED_SER_GRP_CODE='"+med_code+"' AND FACILITY_ID='"+facilityid+"') AND NURSING_UNIT_CODE IN (SELECT NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE SPECIALTY_CODE='"+spy_code+"' AND FACILITY_ID='"+facilityid+"') ORDER BY 2 ");
	}
	else if (SelectType.equals("P"))
	{
		str.append(" SELECT a.nursing_unit_code,a.Short_desc FROM IP_NURSING_UNIT a, IP_MED_SER_GRP_NURS_UT_TYPE b, IP_NURS_UNIT_FOR_SPECIALTY c,IP_NURSING_UNIT_FOR_PRACT D WHERE a.FACILITY_ID='"+facilityid+"' AND A.EFF_STATUS='E' AND B.MED_SER_GRP_CODE='"+med_code+"' AND A.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID=C.FACILITY_ID AND A.FACILITY_ID=D.FACILITY_ID AND A.NURSING_UNIT_CODE=C.NURSING_UNIT_CODE AND A.NURSING_UNIT_CODE=D.NURSING_UNIT_CODE AND A.NURSING_UNIT_TYPE_CODE=B.NURSING_UNIT_TYPE_CODE AND C.SPECIALTY_CODE='"+spy_code+"' AND D.PRACTITIONER_ID='"+prt_code+"' ");
	}

	rs = stmt.executeQuery(str.toString());

	if(rs != null)
	{

		while (rs.next())
		{
			p_code				= rs.getString("nursing_unit_code");
			p_desc				= rs.getString("Short_desc");
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
  }
  		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
}catch (Exception e)
{out.println("Exception in tryCatch : "+ e.toString());}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
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
