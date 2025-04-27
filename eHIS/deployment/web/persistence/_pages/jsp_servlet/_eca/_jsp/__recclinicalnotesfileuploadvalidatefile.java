package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesfileuploadvalidatefile extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesFileUploadValidateFile.jsp", 1741272157069L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n\t<head>\n\t<script language=\'javascript\' src=\'../js/NoteImageList.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	private String buildFileName(String remoteHost , String imageUrl)
	{

		int i=0;
		String result = "";
		imageUrl = imageUrl.replaceAll(":","$");
		imageUrl = imageUrl.replaceAll("\\","%");
		String search = "%";
		String sub = "\\";
		
		do { 
			// replace all matching substrings (\\)
				i = imageUrl.indexOf(search);
				if(i != -1) 
				{
					result = imageUrl.substring(0, i);
					result = result + sub;
					result = result + imageUrl.substring(i + search.length());
					imageUrl = result;
				}
		} while(i != -1);	
	
		String filePath = "\\\\"+remoteHost+"\\"+imageUrl;
		return filePath;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	File filecreate;
	boolean record_status = false;
	ArrayList doc_arr = null;
	String note_linked_file_limit_unit = "";
	String docType = "";
	String file_name = "";

	int note_linked_file_limit = 0;
	double paramsize = 0;
	long docSize = 0;

	String file_upload = request.getParameter("file_upload")==null?"":request.getParameter("file_upload");
	String remote_host = request.getRemoteHost();

	docType = "application/pdf";

	try
	{
			con = ConnectionManager.getConnection();
		try
		{
			file_name = buildFileName(remote_host,file_upload);
			filecreate = new File(file_name);
			docSize = filecreate.length();

			doc_arr = new ArrayList();
			String qry_doc_type = "select distinct OBJ_TYPE from ca_appl_linked_obj_type where APPLICABLE_YN = 'Y'";
			pstmt = con.prepareStatement(qry_doc_type);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				doc_arr.add(rs.getString("OBJ_TYPE"));
			}
			
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();

			for(int i =0; i<doc_arr.size(); i++)
			{
					if(docType.equals(doc_arr.get(i)))
					{
						record_status = true;
						break;
					}
					else
					{
						record_status = false;
					}

			}

			if(record_status)
			{
				String docsize_note_param = "select NOTE_LINKED_FILE_LIMIT , NOTE_LINKED_FILE_LIMIT_UNIT from CA_NOTE_PARAM";
				pstmt = con.prepareStatement(docsize_note_param);
				rs = pstmt.executeQuery();

				while(rs.next())
				{
					note_linked_file_limit = rs.getInt("note_linked_file_limit");
					note_linked_file_limit_unit = rs.getString("note_linked_file_limit_unit");
				}

				if(rs!=null)
						rs.close();
				if(pstmt!=null)
						pstmt.close();

				if(note_linked_file_limit_unit.equalsIgnoreCase("K") || note_linked_file_limit_unit.equalsIgnoreCase("KB"))
				{
						paramsize = note_linked_file_limit * 1024;
				}
				if(note_linked_file_limit_unit.equalsIgnoreCase("M") || note_linked_file_limit_unit.equalsIgnoreCase("MB"))
				{
						paramsize = note_linked_file_limit *1024 *1000;
				}
				if(note_linked_file_limit_unit.equalsIgnoreCase("G") || note_linked_file_limit_unit.equalsIgnoreCase("GB"))
				{
						paramsize = note_linked_file_limit *1024 *1000 * 1000;
				}

				if(docSize > paramsize || docSize > ((1024 *1000 * 1000) * 2)) 
				{
					out.println("<script>alert(getMessage('FILE_SIZE_NOT_SUPPORTED','CA'))</script>");
					out.println("top.messageframe.document.location.href='../../eCA/jsp/CAError.jsp'");
				}
				else
				{
					out.println("<script>");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.messageframe.name;");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = 'Record'");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesSectionsFileUploadServlet'");
					out.println("top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById('noterecord_sec').disabled = true");
					out.println("top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit()");
					out.println("</script>");
				}
			}
			else
			{
				out.println("<script>alert(getMessage('FILE_NOT_SUPPORTED','CA'))</script>");
				out.println("top.messageframe.document.location.href='../../eCA/jsp/CAError.jsp'");
			}
		}
		catch(Exception e)
		{
			//out.println("Exception @ RecClinicalNotesFileUploadValidateFile "+e.toString());//common-icn-0181
		        e.printStackTrace();//COMMON-ICN-0181
		}
				

            _bw.write(_wl_block5Bytes, _wl_block5);

	}
	catch(Exception e)
	{
		//out.println("Exception @ RecClinicalNotesFileUploadValidateFile.jsp "+e.toString());
		e.printStackTrace();//COMMON-ICN-0181
		//out.println("Exception @ RecClinicalNotesFileUploadValidateFile.jsp "+e.toString());//common-icn-0181
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
