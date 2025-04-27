package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;

public final class __administerdataprocessgetservererr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/AdministerDataProcessGetServerErr.jsp", 1709117564789L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

Connection conn = null;
Statement stmt = null;
ResultSet rs = null; 

Hashtable hash = new Hashtable(); 
String err_msg = "";
String qryProcMsg = "";

try 
{

	hash = (Hashtable)xmlObj.parseXMLString(request);
	hash = (Hashtable)hash.get("SEARCH");

	String procID = (String)hash.get("proc_id");
	String moduleID = procID.substring(0,2);
	String tableName = moduleID + "_proc_msg";
	String fromDate = (String)hash.get("fromDate");
	String toDate = (String)hash.get("toDate");
	String facilityID = (String)hash.get("facilityID");

	/*System.out.println("tableName "+tableName);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) proc_id: "+procID);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) moduleID: "+moduleID);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) fromDate: "+fromDate);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) toDate: "+toDate);
	System.out.println("(AdministerDataProcessGetServerErr.jsp) facilityID: "+facilityID);	 */

	//qResult =	java.net.URLDecoder.decode(qResult);		

/*	if(!proc_date.equals(""))
	{
		sql1 = "SELECT TO_CHAR(msg_date_time, 'DD/MM/YYYY HH24:MI:SS')||' '||err_msg error FROM "+tableName+" WHERE PROC_ID='"+procID+"' AND msg_date_time > TO_DATE('"+proc_date+"','DD/MM/YYYY HH24:MI:SS')  ";		
	}
	else
	{
		sql1 = "SELECT TO_CHAR(msg_date_time, 'DD/MM/YYYY HH24:MI:SS')||' '||err_msg error FROM "+tableName+" WHERE PROC_ID='"+procID+"' ";
	}
*/
	qryProcMsg = "SELECT OPERATING_FACILITY_ID||' - '||" +
							"PROC_ID||' - '||"+
							"FAILED_PROC_ID||' - '||"+
							"MODULE_ID||' - '||"+
							"MSG_DATE_TIME||' - '||"+
							"APP_KEY||' - '||"+
							"APP_MSG||' - '||"+
							"ERR_MSG error "+
				"FROM "+tableName+" WHERE OPERATING_FACILITY_ID = '"+facilityID+"' AND "+
								" PROC_ID = '"+procID+"' AND "+
							//	" MODULE_ID = NVL('"+moduleID+"',MODULE_ID) AND "+								
								" MSG_DATE_TIME BETWEEN to_date('"+fromDate+"','DD/MM/YYYY HH24:MI:SS') AND to_date('"+toDate+"','DD/MM/YYYY HH24:MI:SS')";
	//AND TO_CHAR(msg_date_time, 'MM/DD/YYYY HH:MI:SS AM') > TO_CHAR('"+proc_date+"','MM/DD/YYYY HH:MI:SS AM')  ";

	System.out.println("(AdministerDataProcessServErr.jsp) qryProcMsg: "+qryProcMsg);		 
	conn = ConnectionManager.getConnection();	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(qryProcMsg);
	//System.out.println("Qry Executed...");
	for(int i = 0; i < 100; i++)
	{
		if(rs.next())	err_msg = err_msg + "\n" + (String)rs.getString("error");
		else break;
	}
//	System.out.println("err_msg befr decode: "+err_msg);

	err_msg = java.net.URLEncoder.encode(err_msg);	
	out.println("parent.setServerError('"+err_msg+"')");

} // end of try
catch (Exception e) 
{
	e.printStackTrace(System.err);
}
finally
{
	if(conn != null) ConnectionManager.returnConnection(conn);
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}


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
