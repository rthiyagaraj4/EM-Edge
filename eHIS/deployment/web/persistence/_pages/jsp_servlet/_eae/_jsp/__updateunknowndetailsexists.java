package jsp_servlet._eae._jsp;

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

public final class __updateunknowndetailsexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/UpdateUnknownDetailsExists.jsp", 1709113890678L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eAE/js/UpdateUnknownDetails.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n\t<body class=\'message\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<SCRIPT>\n\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"NewPatDltsID\").innerText=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errors = getMessage(\"INVALID_PATIENT\",\'MP\');\n\t\t\t\n\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.value\t\t\t= \'\';\n\t\t\t\t\tparent.frames[1].document.getElementById(\"pat_name\").innerHTML\t\t\t\t\t= \'&nbsp;\';\n\t\t\t\t\tparent.frames[1].document.getElementById(\"pat_ser_grp\").innerHTML\t\t\t\t\t= \'&nbsp;\';\n\t\t\t\t\tparent.frames[1].document.getElementById(\"NewPatDltsID\").innerHTML\t\t\t\t= \'&nbsp;\';\n\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"DeceasedID\").innerHTML = \'&nbsp;\';\n\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value = \"\";\n\t\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[1].document.forms[0].p_id_patient_id.disabled == false)\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.disabled = true;\n\t\t\t\t\tif(parent.frames[1].document.forms[0].pat_search1.disabled == false)\n\t\t\t\t\t\tparent.frames[1].document.forms[0].pat_search1.disabled = true;\n\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+errors;\n\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].patient_id.select();\n\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar error=getMessage(\"PATIENT_MERGED_VALID\",\"MP\");\n\t\t\t\t\terror=error.replace(\'#\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\t\t\t\t\n\t\t\t\t\talert(error);\n\t\t\t\t\tparent.frames[1].document.forms[0].patient_id.value\t\t\t= \'\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\talert(getMessage(\'NOT_UNKNOWN_PATIENT\',\'AE\'));\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].patient_id.value\t\t\t\t\t= \'\';\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.value\t\t\t= \'\';\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"pat_name\").innerHTML\t\t\t\t\t= \'&nbsp;\';\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"pat_ser_grp\").innerHTML\t\t\t\t\t= \'&nbsp;\';\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"NewPatDltsID\").innerHTML\t\t\t\t= \'&nbsp;\';\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"DeceasedID\").innerHTML = \'&nbsp;\';\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value = \"\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].p_id_patient_id.disabled == false)\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.disabled = true;\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].pat_search1.disabled == false)\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].pat_search1.disabled = true;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?&err_num=\";\t\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].patient_id.select();\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"DeceasedID\").innerHTML = \"<B>&nbsp;&nbsp;&nbsp;<fmt:message key=\"Common.deceased.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/></B>\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"DeceasedID\").innerHTML = \"&nbsp;\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].p_existing_series_group.value =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' ;\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"pat_ser_grp\").innerHTML=\"<b>\"+\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"pat_name\").innerText=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.value = \'\';\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.getElementById(\"NewPatDltsID\").innerHTML=\"&nbsp;\";\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].NewPatDltsIDName.value = \"\";\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].p_id_patient_id.disabled == true)\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_id_patient_id.disabled = false;\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].pat_search1.disabled == true)\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].pat_search1.disabled = false;\n\t\t\t\t\t\tparent.parent.frames[2].frames[1].document.forms[0].p_id_patient_id.select();\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	Statement stmt1		= null;
	ResultSet rs1		= null;
	String str					= "";
	String mysql				= "";
	String pat_dtls_unknown_yn	= "";
	String deceased_yn			= "";
	String name					= "";
	String duplicate_id=null;
	String valid_id=null;
	String locale		        = (String)session.getAttribute("LOCALE");
	int count = 0;

	String p_patient_id	= request.getParameter("p_patient_id");
	if(p_patient_id == null || p_patient_id.equals("null")) p_patient_id = "";
	
	String CalledFrom	= request.getParameter("CalledFrom"); //from UpdateUnknownDetails.jsp.jsp/js
	if(CalledFrom == null || CalledFrom.equals("null")) CalledFrom = "";  
	try
	{	
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		stmt1	= con.createStatement();

		mysql = "SELECT GET_PATIENT_LINE('"+p_patient_id+"','"+locale+"') name FROM dual";
		rs = stmt.executeQuery(mysql);
		if(rs != null && rs.next())
		{
			name	= rs.getString("name");
		}if(rs != null) rs.close();	
		if(CalledFrom.equals("NewPatDlts"))
		{
			int ind = name.lastIndexOf(',');
			name	= name.substring(0,ind);
			
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(name));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(name));
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
		else
		{
			mysql = "SELECT count(*) count FROM mp_patient WHERE patient_id = '"+p_patient_id+"' ";
			rs1   = stmt1.executeQuery(mysql);
			if(rs1 != null && rs1.next())
			{
				count = rs1.getInt("count");
			}
			if(rs1 != null) rs1.close();
			String duplicte_check="select DUPLICATE_PATIENT_ID, VALID_PATIENT_ID from DR_MP_PATIENT where DUPLICATE_PATIENT_ID='"+p_patient_id+"'";
			rs1=stmt1.executeQuery(duplicte_check);
			if(rs1 != null && rs1.next())
			{
				duplicate_id = rs1.getString("DUPLICATE_PATIENT_ID");
				valid_id = rs1.getString("VALID_PATIENT_ID");
			}
			if(rs1 != null) rs1.close();

			if(count == 0)
			{
				if(valid_id==null){
				
            _bw.write(_wl_block7Bytes, _wl_block7);

				}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(valid_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
			}
			else
			{
				mysql = "SELECT pat_dtls_unknown_yn,deceased_yn FROM mp_patient WHERE patient_id = '"+p_patient_id+"' ";
				rs1   = stmt1.executeQuery(mysql);
				if(rs1 != null && rs1.next())
				{
					pat_dtls_unknown_yn = rs1.getString("pat_dtls_unknown_yn");
					deceased_yn			= rs1.getString("deceased_yn");
				}if(rs1 != null) rs1.close();	
				if(pat_dtls_unknown_yn.equals("N"))
				{
					
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
				else
				{
					if(deceased_yn.equals("Y"))
					{
						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
					else if(deceased_yn.equals("N"))
					{
						
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
					String p_pat_ser_grp_code = "";
					str = "select pat_ser_grp_code from mp_patient where patient_id='"+p_patient_id+"' " ;
					rs = stmt.executeQuery(str);
					if(rs != null && rs.next())
					{
						p_pat_ser_grp_code = rs.getString("pat_ser_grp_code");
					}if(rs != null) rs.close();
					str = "select short_desc from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"' " ;

					String p_short_desc = "";

					rs = stmt.executeQuery(str);
					if(rs != null && rs.next())
					{
						p_short_desc = rs.getString("short_desc");
					}if(rs != null) rs.close();
					int ind = name.lastIndexOf(',');
					name	= name.substring(0,ind);
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_short_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			}// E.O if(ProceedValue.equals("yes"))
		} 
	}catch (Exception e){e.printStackTrace();}
	finally
	{
		if(rs   != null) rs.close();
		if(rs1  != null) rs1.close();
		if(stmt != null) stmt.close();
		if(stmt1!= null) stmt1.close();
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
