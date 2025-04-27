package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __qrypatshrcblank extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QryPatSHRCblank.jsp", 1709116082262L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n      \t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' /> \n\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n   \t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n      \t\n      \t<script>\n\t\t\tvar Highrisk_Status=\"N\";\n\t\t\t\t      \tfunction HighRisk()\n\t\t\t\t      \t{\t\t\n\t\t\t\t      \tvar P_access_type=document.forms[0].P_access_type.value;\n\t\t\t\t\t\t\t\tvar P_access_data=document.forms[0].P_access_data.value;\n\t\t\t\t\t\t\t\tvar Context=document.forms[0].Context.value;\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tif (Highrisk_Status==\"N\")\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tparent.ChartSummaryMedicalAlertsFrame.location.href=\'../../eCA/jsp/AuthorizeHRC.jsp?patientid=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Context=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&jsp_name=QryPatSumHRC.jsp&B_jsp_name=QryPatSHRCblank.jsp&context=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t//document.location.href=call\t\t \n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\t\t/*if(document.forms[0].highrisk.checked==false)\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\t\t}\t\t\t\n\t\t\t     \t</script>\n      \t\n      \t\n  \n</head>     \t\n<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n<form name=\"HRCblank\" id=\"HRCblank\">\n\n\n\n\n<table border align=center cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n<!--<th align=center>High Risk&nbsp;<input type=checkbox \n  name=\"highrisk\" id=\"highrisk\" onclick=HighRisk()>\n</th>-->\n<td align=center>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n</table>\n\n<input type=\"hidden\" name=\"P_access_type\" id=\"P_access_type\" value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n<input type=\"hidden\" name=\"P_access_data\" id=\"P_access_data\" value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\n<input type=\"hidden\" name=\"Context\" id=\"Context\" value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	//Connection conn= (Connection) session.getValue("connection");
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs	 =null;
 
	String patientid=request.getParameter("patientid");
	//String context=request.getParameter("context");
    String context = (String)request.getParameter("PQ");
	if (context==null) context="Y";

	String P_access_type="V";
	String P_access_data="HR";
	String facilityId 		= (String) session.getValue( "facility_id" ) ;
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String login_user=p.getProperty( "login_user" ) ; 
	StringBuffer sql = new StringBuffer();


	sql.append("select '1' from mr_user_access_rights_vw where ");
	sql.append(" facility_id=? and appl_user_id=? and access_type='V' ");

	if (context.equals("Y"))
		sql.append(" and patient_type='C' ");
	else
		sql.append( " and patient_type='O' ");

	sql.append(" and  access_scope='HR'");
	sql.append(" and exists(select 'x' from pr_high_risk_condition where patient_id=? ");
	sql.append(" and close_date is null and rownum<2)");


	try
	{
  	    conn = ConnectionManager.getConnection(request);
		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,facilityId);
		stmt.setString(2,login_user);
		stmt.setString(3,patientid);
		rs=	stmt.executeQuery();
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(context));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(context));
            _bw.write(_wl_block12Bytes, _wl_block12);

		String enable="disabled";
		if(rs!=null)
			if(rs.next())
				enable="";

			out.print("<input type='button' name='highrisk' id='highrisk' value='&nbsp;&nbsp;&nbsp;High Risk&nbsp;&nbsp;&nbsp;&nbsp;' "+enable+" class='button' onclick=HighRisk()>");
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_access_type ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_access_data ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(context ));
            _bw.write(_wl_block16Bytes, _wl_block16);


	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}

catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally{	
	
	if (conn != null) ConnectionManager.returnConnection(conn,request);
}

	
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
