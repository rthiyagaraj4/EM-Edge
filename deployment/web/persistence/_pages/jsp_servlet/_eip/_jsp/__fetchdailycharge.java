package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __fetchdailycharge extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FetchDailyCharge.jsp", 1742378909032L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<script>\n\t\t\t\tparent.frames[1].document.forms[0].daily_rate.value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\tparent.frames[1].document.forms[0].Bedcode.value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\tparent.frames[1].document.forms[0].room_no.value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\tparent.frames[1].document.getElementById(\'roomno\').innerText = parent.frames[1].document.forms[0].room_no.value;\n\t\t\t\t\t\n\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'==\'Y\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n                <script> \n                    var foc_obj = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"; \n\t\t\t\t\talert(parent.frames[1].getMessage(\"BED_CLASS_MISMATCH\",\"IP\"));\n\t\t\t\t\tif(foc_obj != \'\' && foc_obj != \'bed_no\')\n\t\t\t\t{\n\t\t\t\t\t eval(\'parent.frames[1].document.forms[0].\'+foc_obj).focus();\n\t\t\t\t\t parent.frames[1].document.forms[0].bed_no.value = \'\';\n\t\t\t\t\t parent.frames[1].document.getElementById(\'roomno\').innerText = \'\';\n\t\t\t\t}\n                else\n\t\t\t\t{\t\n\t\t\t\t\tparent.frames[1].document.forms[0].bed_no.focus();\n\t\t\t\t\tparent.frames[1].document.forms[0].bed_no.select(); \n\t\t\t\t}\n                </script>\n            ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\n                 <script>\n                    var comp=parent.frames[1].document.forms[0].daily_rate.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n                </script>\n            ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n            <script> \n            </script>\n            ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8"); 
String nursing_unit_code = request.getParameter("nursing_unit_code");
String bed_no=request.getParameter("bed_no");
String flag=request.getParameter("flag");
String submit_yn=request.getParameter("submit_yn");
String setup_bl_dtls_in_ip_yn=request.getParameter("setup_bl_dtls_in_ip_yn");
if( flag == null) flag="";
String Bedcode=request.getParameter("Bedcode");
String bedClasscode=request.getParameter("bed_code");
String foc_obj = request.getParameter("foc_obj");
if(foc_obj == null) foc_obj = "";
if(bedClasscode == null) bedClasscode="";
if(Bedcode == null) Bedcode="";
if (submit_yn==null) submit_yn="N";
if (setup_bl_dtls_in_ip_yn==null) setup_bl_dtls_in_ip_yn="N";

Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;

String facilityid	="";
String dly_charge	="";
String room_no		="";
StringBuffer sql	= new StringBuffer();
facilityid			=(String)session.getValue("facility_id");
try 
{
    con = ConnectionManager.getConnection(request);
    stmt = con.createStatement();
    if(!flag.equals("frombedchart"))
    {
		String bed_class_code="";
		if (setup_bl_dtls_in_ip_yn.equals("Y"))
		{
			sql.append(" Select a.bed_class_code, a.bed_type_code, a.room_no, b.dly_charge from IP_NURSING_UNIT_BED a, BL_IP_BED_TYPE b where facility_id='"+facilityid+"' and nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"' and b.bed_type_code=a.bed_type_code and a.bed_class_code='" +bedClasscode+"' ");
		}
		else
		{
			sql.append(" Select bed_class_code, bed_type_code, room_no from IP_NURSING_UNIT_BED where facility_id='"+facilityid+"' and nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"' and bed_class_code='"+bedClasscode+ "' ");
		}

        try {
            stmt=con.createStatement();
			rs = stmt.executeQuery(sql.toString());
            out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
            if(rs.next())
			{
				bed_class_code=rs.getString("bed_class_code");
				if (setup_bl_dtls_in_ip_yn.equals("Y"))
				{
					dly_charge=rs.getString("dly_charge");
				}
				else
				{
					dly_charge="0.00";
				}
				room_no = rs.getString("room_no");
				
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(dly_charge));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(submit_yn));
            _bw.write(_wl_block6Bytes, _wl_block6);
  
            }
			
            else
            {
            
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(foc_obj));
            _bw.write(_wl_block8Bytes, _wl_block8);

            }
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

        } // end of try
        catch(Exception e)
        {
            out.println(e.toString());
        }
    }
    else
    {
		if(sql.length() > 0)
			sql.delete(0,sql.length());
						
			sql.append(" Select dly_charge from bl_ip_bed_type where bed_type_code='"+Bedcode+"' ");
        try 
        {	
			stmt=con.createStatement();
            rs = stmt.executeQuery(sql.toString());
            out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
            if(rs.next())
            {
            dly_charge=rs.getString("dly_charge");
            
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dly_charge));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
					}
				
            else 
            {
            
            _bw.write(_wl_block11Bytes, _wl_block11);

            }
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

        } // end of try
        catch(Exception e1)
        {
            out.println(e1.toString());
        }
    }
}
catch(Exception e)
{
   out.println(e.toString());
}
finally
{
 if (stmt!=null) stmt.close();
    if (rs!=null) rs.close();
	if(con != null)
    ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
