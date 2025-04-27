package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __populatenursingunitvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PopulateNursingUnitValues.jsp", 1742451888227L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\"INVALID_NURSING_UNIT\",\"IP\"));\n\t\t\t\tparent.frames[1].frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.frames[1].frames[2].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'tab\').style.visibility=\"hidden\";\n\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'td5\').innerHTML = \"<input type=text name=nursing_unit id=nursing_unit size=4 maxlength=4 onblur=\'ChangeUpperCase(this);PopulateValues(this)\'><input type=button class=button name=\'search_nur_unit\' id=\'search_nur_unit\' value=\'?\' onclick=\'showmodal()\'>\";\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].Search.disabled=true;\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].nursing_unit.select();\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].nursing_unit.focus();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t<script>\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].Search.disabled=false;\n\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'tab\').style.visibility=\'visible\';\t\n\n\t\t\t\tparent.frames[1].frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.frames[1].frames[2].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'td1\').innerHTML=\"<b>";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</b>\";\n\t\t\t\t//modified on 5-06-08\n\t\t\t\tif (parent.frames[1].frames[0].document.forms[0].nursing_unit_type)\n\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].nursing_unit_type.value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'td2\').innerHTML=\"<b>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</b>\";\n\t\t\t\tif (parent.frames[1].frames[0].document.forms[0].age_group)\n\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].age_group.value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t//\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" == \"5\")\n\t\t\t\t{\n\t\t\t\t\tif (parent.frames[1].frames[0].document.forms[0].dept_code)\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].dept_code.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'td3\').innerHTML=\"<b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b>\";\n\t\t\t\t\tif (parent.frames[1].frames[0].document.forms[0].dept_code)\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].dept_code.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t}\n\t\t\n\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'td4\').innerHTML=\"<b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b>\";\n\t\t\t\t//modified on 5-06-08\n\t\t\t\tif (parent.frames[1].frames[0].document.forms[0].service)\n\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].service.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t//\n\t\t\t\tif(parent.frames[1].frames[0].document.getElementById(\'td5\').innerHTML.lastIndexOf(\"<B>\") != -1)\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'td5\').innerHTML = parent.frames[1].frames[0].document.getElementById(\'td5\').innerHTML.substring(0,parent.frames[1].frames[0].document.getElementById(\'td5\').innerHTML.lastIndexOf(\"<B>\"));\n\t\t\t\t}\n\n\t\t\t\tparent.frames[1].frames[0].document.forms[0].Search.focus();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	String facility_id	= (String)session.getValue("facility_id");
	String nursing_unit = request.getParameter("nursing_unit");
	String called_from	= checkForNull(request.getParameter("called_from"));

	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;

	String nursing_unit_type="";
	String age_group="";
	String department="";
	String dept_code = "";
	String service="";
	String nursing_unit_short_desc="";

	try{
		   con = ConnectionManager.getConnection(request);
			out.println("<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body>");
			stmt= con.createStatement();	
			
			String sql_check="Select count(*) from ip_nursing_unit "+
			"where upper(nursing_unit_code)=upper('"+nursing_unit+"') and "+
			"facility_id='"+facility_id+"' and eff_status = 'E' ";
			ResultSet rs_check=stmt.executeQuery(sql_check);
			rs_check.next();
			int count=rs_check.getInt(1);
			if(count==0) 
			{
            _bw.write(_wl_block2Bytes, _wl_block2);
}
			else
			{
				String sql="Select NURSING_UNIT_TYPE_SHORT_DESC, AGE_GROUP_SHORT_DESC, "+
				"DEPT_SHORT_DESC, SERVICE_SHORT_DESC,NURSING_UNIT_SHORT_DESC, DEPT_CODE  "+
				"from IP_NURSING_UNIT_VW where nursing_unit_code='"+nursing_unit+"' and "+
				"facility_id='"+facility_id+"' and eff_status = 'E' ";
			stmt= con.createStatement();	
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				while (rs.next())
				{			
				 nursing_unit_type = rs.getString(1);	
				 if(nursing_unit_type==null) nursing_unit_type="";
				 
				 age_group = rs.getString(2);
				 if(age_group==null) age_group="";
				 
				 department = rs.getString(3);	
				 if(department==null) department="";

				 service = rs.getString(4);	
	
				 nursing_unit_short_desc=rs.getString(5);
				 if(nursing_unit_short_desc==null) nursing_unit_short_desc="";
				 dept_code = rs.getString(6);
				 if (dept_code==null) dept_code = "";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(nursing_unit_type));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(nursing_unit_type));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(age_group));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(age_group));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dept_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(department));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dept_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(service));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(service));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	

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
