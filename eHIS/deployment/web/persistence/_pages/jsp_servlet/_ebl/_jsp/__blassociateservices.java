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

public final class __blassociateservices extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAssociateServices.jsp", 1731733696861L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210129            7339  \t       \tMOHE-CRF-0050\t\t           Mohana Priya K\n-->\n\n";
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
	PreparedStatement pstmt = null;
	Statement stmt	= null;
	ResultSet rs = null;
	CallableStatement cstmt = null;

	try
	{
		//con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		java.util.Properties p=null;
		p = (java.util.Properties) session.getValue( "jdbc" );
		String WS_NO  = p.getProperty("client_ip_address");
		System.err.println("Parmas passed from Ajax   "+request.getQueryString());
		String facility_id=request.getParameter("facility_id") == null ? "" :request.getParameter("facility_id") ;
		String selectall=request.getParameter("selectall") == null ? "N" :request.getParameter("selectall");
		String servGpCode=request.getParameter("servGpCode") == null ? "N" :request.getParameter("servGpCode");
		String p_serv_ind=request.getParameter("p_serv_ind") == null ? "" :request.getParameter("p_serv_ind");
		String user=request.getParameter("user") == null ? "" :request.getParameter("user");
		String sqlStr="";
		String param1=request.getParameter("servCodeDesc") == null ? "" :request.getParameter("servCodeDesc");
		System.err.println("selectall-"+selectall+" facility_id-"+facility_id+" servGpCode-"+servGpCode+" p_serv_ind-"+p_serv_ind+" user-"+user);
		System.err.println("param1->"+param1);
		System.err.println("select-->"+request.getParameter("selectall"));
		
		String[] arrOfStr = param1.split("@");		
		for(int i=0;i<arrOfStr.length;i++){
			con = ConnectionManager.getConnection(request);
			
			String[] str=arrOfStr[i].split("~");
				String p_serv_item=str[0];
				
		 		cstmt=con.prepareCall("{ call bl_daily_cash_delv_rep. proc_associt_service (?,?,?,?,?,?,?,?,?,?)}");	
				cstmt.setString(1,selectall);
				cstmt.setString(2,facility_id);
				cstmt.setString(3,servGpCode);
				cstmt.setString(4,p_serv_item);
				cstmt.setString(5,p_serv_ind);
				cstmt.setString(6,user);
				cstmt.setString(7,WS_NO);		
				
				System.err.println("1, selectall id-"+selectall);
				System.err.println("2, facility_id-"+facility_id);
				System.err.println("3, servGpCode-"+servGpCode);
				System.err.println("4, p_serv_item-"+p_serv_item);
				System.err.println("5, p_serv_ind-"+p_serv_ind);
				System.err.println("6, user-"+user);
				System.err.println("7, WS_NO-"+WS_NO);
				System.err.println("next params "+i);
				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt.execute();
				str[0]="";
				con.close();
		}
				String messageId=cstmt.getString(9);
				String messageText=cstmt.getString(10);
	
				System.err.println("messageText  "+messageText);
				
				String returnValue= "";
				if(messageId != null || messageText != null){
					if(messageId != null && messageText != null){
						returnValue = "::"+messageText+"~"+messageId+"~";
					}else if(messageId != null &&  messageText == null){
						returnValue = "~"+messageId+"~";
					}else{
						returnValue = "::"+messageText+"~";
					}
				}
				else{
					returnValue ="";
				} 
				//String returnValue ="";
				System.err.println("returnValue  "+returnValue);
				out.println(returnValue); 
				}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from Blassocssrvices.jsp "+e);
					//con.rollback();
				}finally{
					//con.close();
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
