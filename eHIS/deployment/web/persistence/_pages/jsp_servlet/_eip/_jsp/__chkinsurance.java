package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class __chkinsurance extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ChkInsurance.jsp", 1709117736378L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>\n\t\t\tvar eff_dt = new Array();\n\t\t\tvar dt = new Array();\n\t\t\tvar effective_dt = \"\";\n\t\t\tvar cr_auth_dt = \"\";\n\n\t\t\tif(!(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' == null || \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' == \'\')) \n\t\t\t{\n\t\t\t\tvar eff_dt_str = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\tif(eff_dt_str==null) \n\t\t\t\t\teff_dt_str=\"\";\n\t\t\t\teff_dt\t=\teff_dt_str.split(\"-\");\n\t\t\t\tif(eff_dt[2]!=null) \n\t\t\t\t\tdt\t\t=\teff_dt[2].split(\" \");\n\t\t\t\tif(dt[0]!=\'undefined\' && eff_dt[1]!=\'undefined\' && eff_dt[0]!=\'undefined\')\n\t\t\t\t{\n\t\t\t\t\teffective_dt = dt[0]+\"/\"+eff_dt[1]+\"/\"+eff_dt[0]\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(!(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' == \'\')) \n\t\t\t{\n\t\t\t\tvar cr_dt = new Array();\n\t\t\t\tvar dt1 = new Array();\n\t\t\t\tvar cr_dt_str = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\tif(cr_dt_str==null) cr_dt_str=\"\";\n\t\t\t\t\tcr_dt = cr_dt_str.split(\"-\");\n\t\t\t\tif(cr_dt[2]!=null) \n\t\t\t\t\tdt1 = cr_dt[2].split(\" \");\n\t\t\t\tif(dt1[0]!=\'undefined\' && cr_dt[1]!=\'undefined\' && cr_dt[0]!=\'undefined\')\n\t\t\t\t{\n\t\t\t\t\tcr_auth_dt = dt1[0]+\"/\"+cr_dt[1]+\"/\"+cr_dt[0]\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_auth_ref.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\tparent.frames[1].frames[2].AdmitPatient_form.credit_auth_date.value=cr_auth_dt;\n\t\t\tparent.frames[1].frames[2].AdmitPatient_form.app_days.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\tparent.frames[1].frames[2].AdmitPatient_form.app_amount.value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\tparent.frames[1].frames[2].AdmitPatient_form.eff_frm_date.value=effective_dt;\n\t\t\tparent.frames[1].frames[2].AdmitPatient_form.insTrackDtlsExists.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
	Connection	con	= null;
	CallableStatement cstmt = null;
	String	credit_auth_ref			=	"",		credit_auth_date		=	"";
	String	app_days				=	"",		app_amount				=	"";
	String	eff_frm_date			=	"",		insTrackDtlsExists		=	"";
	String value2 = request.getParameter("value2");
	if (value2==null) value2="";
	String facilityId = (String) session.getValue("facility_id");
	try
	{
		con	= ConnectionManager.getConnection(request);
		cstmt = con.prepareCall("{ call BL_CHK_INS_CR_AUTH_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		cstmt.setString(1,value2);
		cstmt.setString(2,facilityId);
		cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(7,java.sql.Types.DATE);
		cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(9,java.sql.Types.DATE);
		cstmt.registerOutParameter(10,java.sql.Types.DATE);
		cstmt.registerOutParameter(11,java.sql.Types.INTEGER);
		cstmt.registerOutParameter(12,java.sql.Types.INTEGER);
		cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);

		cstmt.execute();
		
		credit_auth_ref		=	cstmt.getString(8);
		if (credit_auth_ref==null) credit_auth_ref = "";
		credit_auth_date	=	cstmt.getString(9);
		if (credit_auth_date==null) credit_auth_date = "";
		eff_frm_date		=	cstmt.getString(10);
		if (eff_frm_date==null) eff_frm_date = "";
		app_days			=	cstmt.getString(11);
		if (app_days==null) app_days = "";
		app_amount			=	cstmt.getString(12);
		if (app_amount==null) app_amount = "";
		insTrackDtlsExists	=	cstmt.getString(13);
		if (insTrackDtlsExists==null) insTrackDtlsExists = "";
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(eff_frm_date));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eff_frm_date));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(eff_frm_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(credit_auth_date));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(credit_auth_date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(credit_auth_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(credit_auth_ref));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(app_days));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(app_amount));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(insTrackDtlsExists));
            _bw.write(_wl_block13Bytes, _wl_block13);

		if(cstmt!=null) cstmt.close();

	}catch(Exception e)
	{
		out.println("Exception "+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block14Bytes, _wl_block14);
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
