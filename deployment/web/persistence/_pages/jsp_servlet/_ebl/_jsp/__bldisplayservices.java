package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bldisplayservices extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDisplayServices.jsp", 1709114097646L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210125             7339  \t       \tMOHE-CRF-0050\t\t           Mohana Priya K\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
 
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		LinkedHashMap<String,String> displayServicesValues = new LinkedHashMap<String,String>();
		String fromServItmCode=request.getParameter("fromServItmCode")==null?"":request.getParameter("fromServItmCode");
		String toServItmCode=request.getParameter("toServItmCode")==null?"":request.getParameter("toServItmCode");
		String sqlStr = "";			
		String shrtDescOpt=request.getParameter("shrtDescOpt")==null?"":request.getParameter("shrtDescOpt");
		String searchTxt=request.getParameter("searchTxt")==null?"":request.getParameter("searchTxt");
		String locale=request.getParameter("locale")==null?"":request.getParameter("locale");
		String serv_item_ind=request.getParameter("serv_item_ind")==null?"":request.getParameter("serv_item_ind");
		String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		
		
		sqlStr="SELECT BLNG_SERV_CODE code,SHORT_DESC description FROM   BL_BLNG_SERV_LANG_VW WHERE  BLNG_SERV_CODE BETWEEN nvl('"+fromServItmCode+"', '!!!!!!!!!!') "+
				"AND    nvl('"+toServItmCode+"', '~~~~~~~~~~')  "+
				"AND    SHORT_DESC LIKE DECODE('"+shrtDescOpt+"', 'S', '"+searchTxt+"'||'%','E', '%'||'"+searchTxt+"','C', '%'||'"+searchTxt+"'||'%','N', '%') ESCAPE '^'   "+
				"AND 	 UPPER(LANGUAGE_ID)=UPPER('"+locale+"')  "+
				"AND    '"+serv_item_ind+"'='S'  "+
				"AND    BLNG_SERV_CODE not in (select serv_item_code from BL_SERV_BY_REPORT_SERV_GROUP where  facility_id='"+facility_id+"' and serv_item_ind='"+serv_item_ind+"')  "+
				"UNION  "+
				"SELECT ITEM_CODE code,SHORT_DESC description "+
				"FROM   MM_ITEM_LANG_VW  "+
				"WHERE  ITEM_CODE BETWEEN nvl('"+fromServItmCode+"', '!!!!!!!!!!')  "+
				"AND    nvl('"+toServItmCode+"', '~~~~~~~~~~')  "+
				"AND    SHORT_DESC LIKE DECODE('"+shrtDescOpt+"', 'S', '"+searchTxt+"'||'%','E', '%'||'"+searchTxt+"','C', '%'||'"+searchTxt+"'||'%','N', '%') ESCAPE '^'   "+
				"AND 	  UPPER(LANGUAGE_ID)=UPPER('"+locale+"')  "+
				"AND    '"+serv_item_ind+"'='I'  "+
				"AND    ITEM_CODE not in (select serv_item_code from BL_SERV_BY_REPORT_SERV_GROUP where  facility_id='"+facility_id+"' and serv_item_ind='"+serv_item_ind+"')"+
						" order by code desc";

		pstmt=con.prepareStatement(sqlStr);
		rs= pstmt.executeQuery();
		JSONArray jsonArr = new JSONArray();
		System.err.println("After Execute Query  ");
		//ResultSetMetaData rsmd = rs.getMetaData();
		if(rs != null){
			while(rs.next()){ 
				JSONObject objservices = new JSONObject();	
				objservices.put("code", rs.getString(1));
				objservices.put("description", rs.getString(2));
				jsonArr.add(objservices);
			}
		}
		System.err.println("JSON jsonArr-->"+jsonArr);
		// set the response content-type
		response.setContentType("application/json");
		PrintWriter out1 = response.getWriter();

		// writing the json-array to the output stream
		out1.print(jsonArr);
		out1.flush();
		}
		catch(Exception e)
		{
			System.err.println("Exception in Catch"+e);
			out.println("Exception @ bldisplayserv "+e);
			e.printStackTrace();
		}finally{
			System.err.println("Inside Finally");
			if(rs==null) {
				System.err.println("Result Set is Empty");
			}
			if(rs!=null) {
				 System.err.println("Result Set Not Empty");
				rs.close();
			}
			if(pstmt!=null) 
				pstmt.close();			
			ConnectionManager.returnConnection(con);
		}
	
            _bw.write(_wl_block5Bytes, _wl_block5);
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
