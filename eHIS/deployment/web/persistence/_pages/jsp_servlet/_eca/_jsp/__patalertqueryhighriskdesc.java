package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patalertqueryhighriskdesc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatAlertQueryHighRiskDesc.jsp", 1709115981092L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<!-- ****  Modified by kishor kumar n on 04/12/2008 for crf0387 applied new css grid. **** -->\n\t\t\n\t\t\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n   \t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n      \t<script>\n      \tvar srl_no_array = new Array();\n      \tvar prev=0;\n      \tvar i=0;\n      \tfunction rfresh(high_risk_code)\n      \t{\n\t\t\tif(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" == \"Y\"){\n\t\t\t\tparent.parent.PatAlertQueryResult.location.href=\'../../eCA/jsp/PatAlertQueryResult.jsp?&call_from=high_risk&srl_no=\'+srl_no_array[prev]+\'&patient_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'+\'&high_risk_code=\'+high_risk_code+\'&called_from_ip=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t}else{\n\t\t\t\ttop.content.workAreaFrame.PatAlertQueryResult.location.href=\'../../eCA/jsp/PatAlertQueryResult.jsp?&call_from=high_risk&srl_no=\'+srl_no_array[prev]+\'&patient_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t}\n      \t}\n\n      \tfunction refer(ro)\n      \t{\n      \t\tprev=ro.rowIndex;\n\n      \t}\n      \t</script>\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<table name=\"description\" id=\"description\" class=\'grid\' width=\"100%\">\n<form name=fr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t   \tsrl_no_array[i] = ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t   \ti++;\n      \t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</form>\n</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

      	String patient_id = request.getParameter("patient_id");
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
   	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block12Bytes, _wl_block12);

//	Connection conn = (Connection) session.getValue( "connection" ) ;
    Connection conn=null;
//	Statement stmt		=null;
	PreparedStatement stmt=null;
	ResultSet rs		=null;
	
	String sql="";
	int k=1;
	String radio_par=request.getParameter("radio_par");
	if(radio_par==null)
		radio_par="A";
	if (radio_par.equals("A"))
	{
		sql= " and close_date is null ";
	}

            _bw.write(_wl_block13Bytes, _wl_block13);

try
{
	conn=ConnectionManager.getConnection(request);
		StringBuffer strsql =new StringBuffer();
		strsql.append("Select srl_no,MR_GET_DESC.MR_HIGH_RISK(HIGH_RISK_CODE,?,'1') long_desc,HIGH_RISK_CODE from pr_high_risk_condition_vw where patient_id=?" );
		strsql.append(sql);
		strsql.append(" order by 1");
		stmt = conn.prepareStatement(strsql.toString());
		stmt.setString(1,locale);
		stmt.setString(2,patient_id);
		rs = stmt.executeQuery();

		while(rs.next())
		{
			out.println("<tr onclick='javascript:refer(this)'><td class='gridData'>");

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString("srl_no")));
            _bw.write(_wl_block15Bytes, _wl_block15);

			out.println("<input type='hidden' name='srl_no' id='srl_no' value='"+rs.getString("srl_no")+"'>");
			out.println("<a class='gridLink' href='javascript:rfresh(\""+rs.getString("HIGH_RISK_CODE")+"\")'>");
			out.println(rs.getString("long_desc")+"</a></font></td>");
			k++;
		}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e)
{
			//out.println("Exception @ PatAlertQueryHighRiskDesc "+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		
}
finally 
{
			
			if (conn != null) ConnectionManager.returnConnection(conn,request); 
}

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
