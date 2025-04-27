package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __alternateidexpchk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AlternateIDExpChk.jsp", 1709117707410L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n\n<body class=\'message\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n      <script>\n        msg = parent.f_query_add_mod.getMessage(\"ALT_ID_EXP_WITH_GRACE\",\"MP\")\n        if(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'== 1)\n        {\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alternate_id\").value)\n        }\n        else if(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'== 2)\n        {\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id2_type\").value)\n        }\n        else if(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'== 3)\n        {\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id3_type\").value)\n        }\n        else if(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'== 4)\n        {\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id4_type\").value)\n        }\n        alert(msg);\n      </script>\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n                <script>var alt_days = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n                    msg = parent.f_query_add_mod.getMessage(\"ALT_ID_EXP_WITHIN\",\"MP\")\n                    if(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'== 1)\n                    {\n                        msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alternate_id\").value)\n                    }\n                    else if(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'== 2)\n                    {\n                        msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id2_type\").value)\n                    }\n                    else if(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'== 3)\n                    {\n                        msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id3_type\").value)\n                    }\n                    else if(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'== 4)\n                    {\n                        msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id4_type\").value)\n                    }\n                    alert( (msg +\" \"+alt_days+\' \'+getLabel(\"Common.days.label\",\"Common\")) );\n                    location.href = \'../../eCommon/jsp/error.jsp\'\n\n                </script>\n                ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n    <script>\n        msg = parent.f_query_add_mod.getMessage(\'ALT_ID_EXPIRED\',\'MP\')\n        \n        \n        if(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'== 1)\n        {\n            parent.f_query_add_mod.document.getElementById(\"altid1expdate\").focus();\n            parent.f_query_add_mod.document.getElementById(\"altid1expdate\").select();\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alternate_id\").value)\n        }\n        else if(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'== 2)\n        {\n            parent.f_query_add_mod.document.getElementById(\"alt_id2_exp_date\").focus();\n            parent.f_query_add_mod.document.getElementById(\"alt_id2_exp_date\").select();\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id2_type\").value)\n        }\n        else if(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'== 3)\n        {\n            parent.f_query_add_mod.document.getElementById(\"alt_id3_exp_date\").focus();\n            parent.f_query_add_mod.document.getElementById(\"alt_id3_exp_date\").select();\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id3_type\").value)\n        }\n        else if(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'== 4)\n        {\n            parent.f_query_add_mod.document.getElementById(\"alt_id4_exp_date\").focus();\n            parent.f_query_add_mod.document.getElementById(\"alt_id4_exp_date\").select();\n            msg = msg.replace(\'$\',parent.f_query_add_mod.document.getElementById(\"alt_id4_type\").value)\n        }\n        alert(msg);\n    </script>\n ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
java.sql.Date current_date = null ;
String  alt_id_exp_date = request.getParameter("expiry_date") ;

String alt_id_exp_warn_yn = "" ;
String alt_id_adv_alert_reqd_yn = "";
int alt_id_adv_alert_days = 0 ;
int  alt_id_exp_grace_days = 0 ;
java.util.Date p_alt_id_total_exp_date = null ;
int  IdNo  = Integer.parseInt(request.getParameter("expdateno")) ;
	
int p_alt_id_diff_days = 0;
java.sql.Date p_alt_id_exp_date1 = null;
String flag = "true";

Connection con = null;
Statement stmt = null;
ResultSet rset = null ;

StringBuffer expsql = new StringBuffer();
expsql.append("Select alt_id1_exp_warn_yn,alt_id1_exp_grace_days, alt_id1_adv_alert_reqd_yn, nvl(alt_id1_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ,");

try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement() ;

    if(IdNo == 2)
	{
		if(expsql.length() > 0) expsql.delete(0,expsql.length());
        expsql.append("Select alt_id2_exp_warn_yn,alt_id2_exp_grace_days, alt_id2_adv_alert_reqd_yn, nvl(alt_id2_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ," ) ;
	}
    if(IdNo == 3)
	{
		if(expsql.length() > 0) expsql.delete(0,expsql.length());
        expsql.append("Select alt_id3_exp_warn_yn,alt_id3_exp_grace_days, alt_id3_adv_alert_reqd_yn, nvl(alt_id3_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ," );
	}
    if(IdNo == 4 )
    { 
		if(expsql.length() > 0) expsql.delete(0,expsql.length());
		expsql.append("Select alt_id4_exp_warn_yn,alt_id4_exp_grace_days, alt_id4_adv_alert_reqd_yn, nvl(alt_id4_adv_alert_days,0) alt_id_adv_alert_days,to_date('"+alt_id_exp_date+"','dd/mm/rrrr')-trunc(sysdate) p_alt_id_exp_date ," );
	}

   expsql.append(" trunc(sysdate),to_date( '"+alt_id_exp_date+"','dd/mm/rrrr') from mp_param");
    
    rset = stmt.executeQuery( expsql.toString() );
    if (rset.next()){
    alt_id_exp_warn_yn=rset.getString(1);if(alt_id_exp_warn_yn==null)alt_id_exp_warn_yn="";
    alt_id_exp_grace_days=rset.getInt(2);
    alt_id_adv_alert_reqd_yn = rset.getString(3);if(alt_id_adv_alert_reqd_yn==null) alt_id_adv_alert_reqd_yn="";
    alt_id_adv_alert_days = rset.getInt(4);
    p_alt_id_diff_days = rset.getInt(5);
   
    current_date=rset.getDate(6);
     p_alt_id_exp_date1 = rset.getDate(7);
    }
 
 if(alt_id_exp_warn_yn.equals("Y"))
 {
    
   p_alt_id_total_exp_date=new java.util.Date(p_alt_id_exp_date1.getTime());
   p_alt_id_total_exp_date.setDate(p_alt_id_exp_date1.getDate()+alt_id_exp_grace_days);   
   
   if((p_alt_id_exp_date1.compareTo(current_date))< 0)
   {
    if((p_alt_id_total_exp_date.compareTo(current_date))< 0)
   {
          flag="false";
   }
   else{
   
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block8Bytes, _wl_block8);
}
 }
 }
 
 if(alt_id_adv_alert_reqd_yn.equals("Y"))
 {
    if((p_alt_id_exp_date1.compareTo(current_date))> 0)
    {
        if (p_alt_id_diff_days > 0) 
        {
            if ( p_alt_id_diff_days <= alt_id_adv_alert_days)
            {
                
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(alt_id_adv_alert_days));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block14Bytes, _wl_block14);

            }
        }
    }
 }

if(flag.equals("false"))
{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(IdNo));
            _bw.write(_wl_block19Bytes, _wl_block19);


}
}catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();
}
finally
{
    if (stmt != null) stmt.close();
    if (rset != null) rset.close();
    ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block20Bytes, _wl_block20);
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
