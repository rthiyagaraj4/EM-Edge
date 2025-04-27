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

public final class __checkidnoseries extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/CheckIDNoSeries.jsp", 1719912874178L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eDR/js/ChangeIDSeries.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\'  onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tvar errors = getMessage(\"DUPLICATE_ID_NO\",\"DR\") ;\n\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+errors;\t\n\t\t\t\t//parent.frames[1].document.forms[0].p_id_no.select();\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').select();\n\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').focus();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar val = getMessage(\"NAT_ID_CHARS\",\"MP\");\n\t\t\t                val = val.replace(\"@\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\")\n\t\t\t\t\t\t\tval = val.replace(\"#\",getLabel(\"eDR.IDNo.label\",\"DR\"))\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+val;\t\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').select();\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').focus();\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar val = getMessage(\"INVALID_NAT_ID\",\"MP\");\n\t\t\t\t\t\t\t\tval = val.replace(\"#\",getLabel(\"eDR.IDNo.label\",\"DR\"))\n\t\t\t\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+val;\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').select();\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').focus();\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar val = getMessage(\"ALT_ID_CHARS\",\"MP\");\n\t\t\t\t\t\t\t\tval = val.replace(\"$\",getLabel(\"Common.identification.label\",\"Common\"))\n\t\t\t\t\t\t\t\tval = val.replace(\"@\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\");\n\t\t\t\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+val;\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').select();\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').focus();\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(isNaN(parent.frames[1].document.forms[0].p_id_no.value))\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar chk_dig_mes = getMessage(\"ALT_ID_NO\",\"MP\");\n\t\t\t\t\t\t\t\tchk_dig_mes\t\t= chk_dig_mes.replace(\'$\',getLabel(\"eDR.IDNo.label\",\"DR\"));\n\t\t\t\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+chk_dig_mes;\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').select();\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').focus();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar val = getMessage(\"INVALID_NAT_ID\",\"MP\");\n\t\t\t\t\t\t\t\tval = val.replace(\"#\",getLabel(\"eDR.IDNo.label\",\"DR\"))\n\t\t\t\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+val;\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').select();\n\t\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_no\').focus();\n\t\t\t\t\t\t   </script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').disabled = false;\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_gen_pat_id_yn\').value = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' ;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_id_patient_id\').disabled = true;\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_gen_pat_id_yn\').value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
	ResultSet rst			= null;

	String str								= "";
	
	String p_gen_pat_id_yn					= "";
	String nat_id_chk_len					= "";
	String alt_id_chk_len					= "";
	String nat_id_chk_digit_scheme			= "";
	String alt_id_chk_digit_scheme			= "";
	String alt_id1_accept_alphanumeric_yn	= "";
	String result = "TRUE";
	
	int alt_id_length = 0;
	int nat_id_length = 0;

	String p_patient_id				= request.getParameter("p_patient_id");
	String p_id_series1				= request.getParameter("p_id_series1");
	String p_id_series				= request.getParameter("p_id_series");
	String p_id_no					= request.getParameter("p_id_no");
	String alt_id1_unique_yn		= request.getParameter("alt_id1_unique_yn");
	nat_id_chk_len					= request.getParameter("nat_id_chk_len");
	nat_id_chk_digit_scheme			= request.getParameter("nat_id_chk_digit_scheme");
	alt_id_chk_digit_scheme			= request.getParameter("alt_id_chk_digit_scheme");
	alt_id_chk_len					= request.getParameter("alt_id_chk_len");
	alt_id1_accept_alphanumeric_yn	= request.getParameter("alt_id1_accept_alphnum_yn");
	String p_nat_length				= request.getParameter("nat_length");
	String p_alt_length				= request.getParameter("alt_length");

	if(p_nat_length == null) alt_id1_unique_yn = "0";		
	if(p_alt_length == null) alt_id1_unique_yn = "0";

	nat_id_length = Integer.parseInt(p_nat_length);
	alt_id_length = Integer.parseInt(p_alt_length);

	if(p_patient_id == null) p_patient_id = "";
	if(p_id_series1 == null) p_id_series1 = "";
	if(p_id_series == null) p_id_series = "";
	if(p_id_no == null) p_id_no = "";
	if(alt_id1_unique_yn == null) alt_id1_unique_yn = "";	

	if(alt_id_chk_digit_scheme == null) alt_id_chk_digit_scheme = "";
	if(nat_id_chk_len == null) nat_id_chk_len = "N";
	if(nat_id_chk_digit_scheme == null) nat_id_chk_digit_scheme = "";
	if(alt_id_chk_len == null) alt_id_chk_len = "N";
	if(nat_id_chk_digit_scheme == null) nat_id_chk_digit_scheme = "";
	if(alt_id1_accept_alphanumeric_yn == null) alt_id1_accept_alphanumeric_yn = "N";
	
	boolean continue_yn = true;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(p_id_series.equals("N"))
		{
			str = "SELECT count(1) total_records FROM mp_patient WHERE national_id_no = '"+p_id_no+"' " ;
		}
		else if(p_id_series.equals("A") && alt_id1_unique_yn.equals("Y"))
		{
			str = "SELECT count(1) total_records FROM mp_patient WHERE alt_id1_no = '"+p_id_no+"' " ;
		}

		int maxrecord = 0;

		if(p_id_series.equals("N") || (p_id_series.equals("A") && alt_id1_unique_yn.equals("Y")))
		{
			rs = stmt.executeQuery(str);
			while (rs.next())
			{
				maxrecord = rs.getInt("total_records");
			}
		}
		if(maxrecord > 0)
		{
			
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		else
		{
			/*str = "SELECT nat_id_length, nvl(nat_id_chk_len,'N') nat_id_chk_len, nat_id_chk_digit_scheme, alt_id1_length, alt_id1_len_validation_yn, alt_id1_chk_digit_scheme, alt_id1_accept_alphanumeric_yn FROM mp_param";
			rs = stmt.executeQuery(str);

			if(rs.next())
			{
				nat_id_length					= rs.getInt(1);
				nat_id_chk_len					= rs.getString(2);
				nat_id_chk_digit_scheme			= rs.getString(3);
				alt_id_length					= rs.getInt(4);
				alt_id_chk_len					= rs.getString(5);
				alt_id_chk_digit_scheme			= rs.getString(6);
				alt_id1_accept_alphanumeric_yn	= rs.getString(7);

				if(nat_id_chk_len == null) nat_id_chk_len = "N";
					
				if(nat_id_chk_digit_scheme == null) nat_id_chk_digit_scheme = "";
				if(alt_id_chk_len == null) alt_id_chk_len = "N";
				if(alt_id_chk_digit_scheme == null) alt_id_chk_digit_scheme = "";
				if(alt_id1_accept_alphanumeric_yn == null) alt_id1_accept_alphanumeric_yn = "N";
			} if(rs != null) rs.close();*/

			if(p_id_series.equals("N"))
			{
				if(nat_id_chk_len.equals("Y"))
				{
					if(p_id_no.length() != nat_id_length)
					{
						continue_yn = false;
						
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block10Bytes, _wl_block10);

					  }
					}
					if(nat_id_chk_digit_scheme != null)
					{
						str = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_chk_digit_scheme+"'" ;
						rs = stmt.executeQuery(str);
						if(rs.next())
						{
							nat_id_chk_digit_scheme = rs.getString(1);
							
							str = "SELECT "+nat_id_chk_digit_scheme+"('"+p_id_no+"') FROM dual";
							rst = stmt.executeQuery(str);
							if(rst.next())
							{
								result = rst.getString(1);
							} if(rst != null)  rst.close();

						} if(rs != null) rs.close();

						if(!result.equals("TRUE")) 
					    {
							continue_yn = false;
							
            _bw.write(_wl_block11Bytes, _wl_block11);

						}
					}
				}
				else if(p_id_series.equals("A"))
				{
					if(alt_id_chk_len.equals("Y"))
					{
						if(p_id_no.length() != alt_id_length)
						{	
							continue_yn = false;
							
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alt_id_length));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
					}
					if(alt_id1_accept_alphanumeric_yn.equals("N"))
					{ 
						
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
					if(alt_id_chk_digit_scheme != null)
					{
						str = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+alt_id_chk_digit_scheme+"'" ;
						rs = stmt.executeQuery(str);
						if(rs.next())
						{
							alt_id_chk_digit_scheme = rs.getString(1);
							
							str = "SELECT "+alt_id_chk_digit_scheme+"('"+p_id_no+"') FROM dual";
							rst = stmt.executeQuery(str);
							if(rst.next())
							{
								result = rst.getString(1);
							} 
						} if(rs != null) rs.close();

						if(!result.equals("TRUE")) 
					    {
							continue_yn = false;
							
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
					}
				}
				if(continue_yn)
				{
					str = "SELECT pat_ser_grp_code,gen_pat_id_yn FROM mp_pat_ser_grp WHERE pat_ser_grp_code = '"+p_id_series1+"' " ;

					rs = stmt.executeQuery(str);
					while (rs.next())
					{
						p_gen_pat_id_yn = rs.getString("gen_pat_id_yn");
					} if(rs != null) rs.close();

					if (p_gen_pat_id_yn.equals("N"))
					{
						
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_gen_pat_id_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
					else
					{
						
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_gen_pat_id_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				}
			}
			
			if(rs!=null) rs.close();
			if(rst!=null) rst.close();
			if(stmt!=null) stmt.close();
			
		}
		catch (Exception e)
		{
			out.println("Exception e :"+e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
