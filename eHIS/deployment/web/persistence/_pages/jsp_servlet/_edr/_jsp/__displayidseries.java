package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __displayidseries extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/DisplayIDSeries.jsp", 1719914095655L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eDR/js/ChangeIDSeries.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\tvar p_nat_id_no = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\n\t\t\tif(p_nat_id_no.length == 0)\n\t\t\t{\t\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'p_id_no\').disabled = false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'p_id_no\').disabled = true;\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'p_id_no\').value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' ;\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'p_id_no\').value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ;\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').vadocument.getElementById(\'\')lue\t= \"\";\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\')p_id_patient_id.disabled = true;\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'p_gen_pat_id_yn\').value = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'p_gen_pat_id_yn\').value = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' ;\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"==\'Y\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').value =  \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.value = \"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tparent.frames[1].document.getElementById(\'p_pat_ser_grp_code\').value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\'prefix_reqd_yn\').value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').disabled = false;\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').readonly = true;\n\t\t\t\tvar errors = \'\' ;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ;\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').value\t= \"\";\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').readonly = false;\n\t\t\t\tvar errors = \'\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String str					= "";
	String p_national_id_no		= "";
	String p_pat_ser_grp_code	= "";
	String p_regn_facility_id	= "";
	String p_gen_pat_id_yn		= "";
	String p_prefix_reqd_yn		= "";

	String p_patient_id	= request.getParameter("p_patient_id");
	String p_id_series  = request.getParameter("p_id_series");
	String p_id_series1	= request.getParameter("p_id_series1");
	String p_id_type    = request.getParameter("p_id_type");

	if(p_patient_id == null) p_patient_id = "";
	if(p_id_series == null) p_id_series = "";
	if(p_id_series1 == null) p_id_series1 = "";
	if(p_id_type == null) p_id_type = "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(p_id_series.equals("N"))
		{
			str = "SELECT national_id_no,regn_facility_id FROM mp_patient WHERE patient_id= '"+p_patient_id+"' " ;
		}
		else if(p_id_series.equals("A"))
		{
			str = "SELECT alt_id1_no national_id_no,regn_facility_id FROM mp_patient WHERE patient_id= '"+p_patient_id+"' " ;
		}

		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_national_id_no = rs.getString("national_id_no");
			p_regn_facility_id = rs.getString("regn_facility_id");
		} if(rs != null) rs.close();
		
		if(p_national_id_no == null) p_national_id_no = "";
		if(p_regn_facility_id == null) p_regn_facility_id = "";

		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_national_id_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_national_id_no));
            _bw.write(_wl_block10Bytes, _wl_block10);


		str = "SELECT pat_ser_grp_code,gen_pat_id_yn,prefix_reqd_yn FROM mp_pat_ser_grp WHERE pat_ser_grp_code = '"+p_id_series1+"' " ;
		rs = stmt.executeQuery(str);
		while (rs.next())
		{
			p_pat_ser_grp_code = rs.getString("pat_ser_grp_code");
			p_gen_pat_id_yn    = rs.getString("gen_pat_id_yn");
			p_prefix_reqd_yn	= rs.getString("prefix_reqd_yn");
		}
	
		if(p_gen_pat_id_yn.equals("Y"))
		{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_national_id_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_gen_pat_id_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		else
		{
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_gen_pat_id_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_prefix_reqd_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_pat_ser_grp_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_pat_ser_grp_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_prefix_reqd_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}

		if(p_gen_pat_id_yn.equals("Y"))
		{
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_gen_pat_id_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);

		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch (Exception e)
	{
		out.println("Excveptuion e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
