package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __validatesysdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/ValidateSysdate.jsp", 1709118436868L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <script>\n      start_date = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\n\t \n    target_date = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n\tif(start_date!=\"\")\n\t\t{\n\tfromDt = start_date.split(\" \");\n\tfromarray = fromDt[0].split(\"/\");\n\tfromtime = fromDt[1].split(\":\");\n\t\n\tfromDt1= target_date.split(\" \");\t\t\n\ttoarray = fromDt1[0].split(\"/\");\n\ttotime = fromDt1[1].split(\":\"); \n\t\n\tstart_date = fromarray[2]+\"/\"+fromarray[1]+\"/\"+fromarray[0]+\" \"+fromtime[0]+\":\"+fromtime[1];\n\ttarget_date = toarray[2]+\"/\"+toarray[1]+\"/\"+toarray[0]+\" \"+totime[0]+\":\"+totime[1];\n\n\n\tst_date = new Date();\n\ttr_date = new Date();\n\tdt_diff  = new Date();\n\n\t// Validates first date \n\tst_datetemp = new Date(start_date);\n\tst_date.setTime(st_datetemp.getTime());\n\n\t// Validates second date \n\ttr_datetemp = new Date(target_date);\n\ttr_date.setTime(tr_datetemp.getTime());\n\n\t// sets difference date to difference of first date and second date\n\n\tdt_diff.setTime(st_date.getTime() - tr_date.getTime());\n\t\t\n\timediff = dt_diff.getTime();\n\t if(imediff>0)\n    {\n\n\t\t\talert(getMessage(\'START_DATE_GREATER_SYSDATE\',\'Common\'))\n\t\t\teval(\"parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".focus()\")\n\t\t\teval(\"parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =".value=\'\'\")\n\t\t\t\n\t\t\t}\n\t\t}\t\n\t </script>\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n <script>\n     start_date = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\tif(start_date!=\"\")\n\t\t{\n\tfromDt = start_date.split(\" \");\n\tfromarray = fromDt[0].split(\"/\");\n\tfromtime = fromDt[1].split(\":\");\n\t\n\tfromDt1= target_date.split(\" \");\t\t\n\ttoarray = fromDt1[0].split(\"/\");\n\ttotime = fromDt1[1].split(\":\"); \n\t\n\tstart_date = fromarray[2]+\"/\"+fromarray[1]+\"/\"+fromarray[0]+\" \"+fromtime[0]+\":\"+fromtime[1];\n\ttarget_date = toarray[2]+\"/\"+toarray[1]+\"/\"+toarray[0]+\" \"+totime[0]+\":\"+totime[1];\n\n\n\tst_date = new Date();\n\ttr_date = new Date();\n\tdt_diff  = new Date();\n\n\t// Validates first date \n\tst_datetemp = new Date(start_date);\n\tst_date.setTime(st_datetemp.getTime());\n\n\t// Validates second date \n\ttr_datetemp = new Date(target_date);\n\ttr_date.setTime(tr_datetemp.getTime());\n\n\t// sets difference date to difference of first date and second date\n\n\tdt_diff.setTime(st_date.getTime() - tr_date.getTime());\n\t\t\n\timediff = dt_diff.getTime();\n\t if(imediff>0)\n    {\n\t\t\talert(getMessage(\'START_DATE_GREATER_SYSDATE\',\'Common\'))\n\t\t\teval(\"parent.frames[3].document.forms[0].";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =".focus()\")\n\t\t\teval(\"parent.frames[3].document.forms[0].";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =".value=\'\'\")\n\t\t\n\t\t\t}\n\t\t}\t\t\n </script>\n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n <script>\n\t//if(eval(Date.parse(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\") )< eval(Date.parse(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")))\n\t\n\tstart_date = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\tif(start_date!=\"\")\n\t\t{\n\tfromDt = start_date.split(\" \");\n\tfromarray = fromDt[0].split(\"/\");\n\tfromtime = fromDt[1].split(\":\");\n\t\n\tfromDt1= target_date.split(\" \");\t\t\n\ttoarray = fromDt1[0].split(\"/\");\n\ttotime = fromDt1[1].split(\":\"); \n\t\n\tstart_date = fromarray[2]+\"/\"+fromarray[1]+\"/\"+fromarray[0]+\" \"+fromtime[0]+\":\"+fromtime[1];\n\ttarget_date = toarray[2]+\"/\"+toarray[1]+\"/\"+toarray[0]+\" \"+totime[0]+\":\"+totime[1];\n\n\nst_date = new Date();\ntr_date = new Date();\ndt_diff  = new Date();\n\n// Validates first date \nst_datetemp = new Date(start_date);\nst_date.setTime(st_datetemp.getTime());\n\n// Validates second date \ntr_datetemp = new Date(target_date);\ntr_date.setTime(tr_datetemp.getTime());\n\n// sets difference date to difference of first date and second date\n\ndt_diff.setTime(st_date.getTime() - tr_date.getTime());\n\t\nimediff = dt_diff.getTime();\n\nif(imediff>0)\n\t{\nalert(getMessage(\'START_DATE_GREATER_SYSDATE\',\'Common\'))\neval(\"parent.frames[2].document.forms[0].";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =".focus()\")\neval(\"parent.frames[2].document.forms[0].";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =".value=\'\'\")\n\t}\n    \n\n\t\t}\n </script>\n ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\n";
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


Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;
String sql         = "";
request.setCharacterEncoding("UTF-8");
String objname=request.getParameter("objname");
if(objname == null) objname="";
String objValue=request.getParameter("objValue");
if(objValue == null) objValue="";

String bodypart=request.getParameter("bodypart");
if(bodypart==null)bodypart="";
String system_date="";
try
{
	
	 sql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date from dual";
	 con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();
	 rs = stmt.executeQuery(sql);
	if(rs != null)
	{
		if(rs.next())
		{
			system_date=rs.getString(1);	
		}
	}          
 
	 if(stmt!=null) stmt.close();
	 if(rs!=null) rs.close();
 
 if(bodypart.equals("deceasedregn1"))
	{
	 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(objValue));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}else

 if(bodypart.equals("bodypart")||bodypart.equals("deceasedregn"))
	{
	 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(objValue));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}else
	
	{
	 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(objValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(objValue));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(objname));
            _bw.write(_wl_block20Bytes, _wl_block20);

	
		}
 }
 catch(Exception ee)
 {
	 ee.printStackTrace();
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();

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
