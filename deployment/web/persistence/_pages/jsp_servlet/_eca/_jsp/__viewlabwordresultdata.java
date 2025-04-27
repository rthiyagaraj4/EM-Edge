package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.*;
import org.apache.poi.hwpf.*;
import java.util.*;
import com.ehis.util.*;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public final class __viewlabwordresultdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewLabWordResultData.jsp", 1709116443947L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t\n\t<body onKeyDown=\'lockKey()\'>\n\t<form name=\'signRepCriteriaForm\' id=\'signRepCriteriaForm\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"FILE_CORRUPTED\",\"CA\"));\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;

		String patient_id	= "";
		String event_code	= "";
		String event_group	= "";
		String event_desc	= "";
		String facility_id	= "";
		String specimen_no	= "";
		String template_name = "";
		java.sql.Blob result_blob = null;
		
		patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		event_code = request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
		event_group = request.getParameter("event_group") == null ? "" : request.getParameter("event_group");
		event_desc = request.getParameter("event_desc") == null ? "" : request.getParameter("event_desc");
		facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
		specimen_no = request.getParameter("specimen_no") == null ? "" : request.getParameter("specimen_no");
		template_name = request.getParameter("template_name") == null ? "" : request.getParameter("template_name");
		DirectoryNode dn = null;
		DirectoryEntry docDirNode = null;
		DocumentEntry wordDocument = null;
		DocumentEntry oneTable = null;
		DocumentEntry data  = null;
		POIFSFileSystem pfs   = null;
		
		try
		{
			con = ConnectionManager.getConnection();
			
			String sql = "select RESULT_FILE_ID, RESULT_DATA from RL_OLE_RESULT_TEXT where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ? and TEMPLATE_NAME = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,specimen_no);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,event_group);
			pstmt.setString(5,event_code);
			pstmt.setString(6,template_name);
			
			rs = pstmt.executeQuery();
			
			while(rs != null  && rs.next())
			{
				result_blob  =  (java.sql.Blob)rs.getBlob("RESULT_DATA");
				POIFSFileSystem fs = new POIFSFileSystem(result_blob.getBinaryStream());
				dn = fs.getRoot();
				docDirNode = (DirectoryEntry) dn.getEntry("Tenant Object");
				wordDocument = (DocumentEntry) docDirNode.getEntry("WordDocument");
				oneTable = (DocumentEntry) docDirNode.getEntry("1Table");
				data = (DocumentEntry) docDirNode.getEntry("Data");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(FileNotFoundException ee)
		{
			
		}

		catch(Exception e)
		{			
			e.printStackTrace();
		}
		finally
		{
			if(wordDocument == null || oneTable == null)
			{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			else
			{
				pfs = new POIFSFileSystem();
				if(wordDocument != null) pfs.createDocument(new DocumentInputStream(wordDocument),"WordDocument");
				if(oneTable != null) pfs.createDocument(new DocumentInputStream(oneTable), "1Table");
				if(data != null) pfs.createDocument(new DocumentInputStream(data), "Data");			
				response.setContentType("application/msword");
				response.setHeader("Content-Disposition","filename=test.doc");
				pfs.writeFilesystem(response.getOutputStream());
			}
			
			if (con != null)ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
