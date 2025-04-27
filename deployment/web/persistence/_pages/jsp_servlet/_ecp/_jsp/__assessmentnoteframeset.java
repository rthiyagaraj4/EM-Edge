package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;

public final class __assessmentnoteframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessmentNoteFrameSet.jsp", 1733848545741L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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

	 request.setCharacterEncoding("UTF-8");
	 String locale=(String)session.getAttribute("LOCALE");
	String note_id = request.getParameter("note_id");

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String[] record1=null;
	String assess_note_desc="";
	String inpatient="";
	String outpatient="";
	String emergency = "";
	String external="";
	String pat_class_appl="";
	String pat_class_appl1="";
	String sql = "";
	

try
{
	con = ConnectionManager.getConnection(request);
	
   	sql="select  note_type_desc,inpatient_yn,outpatient_yn,daycare_yn,emergency_yn from ca_note_type_lang_vw where  note_type=? and language_id=?";
	pstmt= con.prepareStatement(sql);	
	pstmt.setString(1,note_id);
	pstmt.setString(2,locale);
    rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{     
				record1 = new String[5];		
				
				assess_note_desc = rs.getString("note_type_desc")==null ? "": rs.getString("note_type_desc");	
				record1[0]=assess_note_desc;
					
				inpatient = rs.getString("inpatient_yn")==null ? "": rs.getString("inpatient_yn");	

				if(inpatient.equals("Y"))
				{
				pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				record1[1]=pat_class_appl;
				}
				else
				{
					pat_class_appl="";
					record1[1]=pat_class_appl;
				}
			
				outpatient = rs.getString("outpatient_yn")==null ? "": rs.getString("outpatient_yn");	
				if(outpatient.equals("Y"))
				{
					pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
					record1[2]=pat_class_appl;
				}
				else
				{
						pat_class_appl="";
						record1[2]=pat_class_appl;
				}
						
				emergency = rs.getString("daycare_yn")==null ? "": rs.getString("daycare_yn");	
				if(emergency.equals("Y"))
				{
					pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
					record1[3]=pat_class_appl;
							
				}
				else
				{
						pat_class_appl="";
						record1[3]=pat_class_appl;
				}		
									
				external =rs.getString("emergency_yn")==null ? "": rs.getString("emergency_yn");	
				if(external.equals("Y"))
				{
							pat_class_appl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
							record1[4]=pat_class_appl;
							
				}
				else
				{
						pat_class_appl="";
						record1[4]=pat_class_appl;
				}

				pat_class_appl1=record1[1]+" "+record1[2]+" "+record1[3]+" "+record1[4]+" ";
				

			out.println( "assignDateRange(\"" + record1[0] + "\",\"" + pat_class_appl1 + "\") ; " ) ;
		}

		}catch(Exception e) {
			//out.println("Main : "+e.toString());//COMMON-ICN-0181
                           e.printStackTrace();//COMMON-ICN-0181
			}
	finally
	{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request); 
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
