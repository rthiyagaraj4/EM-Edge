package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.w3c.dom.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __patientassessmentdisplaydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PatientAssessmentDisplayDetails.jsp", 1736916400322L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<?xml version=\'1.0\' encoding=\"UTF-8\"?>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/PatientAssessmentStyle.xsl\"?> \n<DOCUMENT FORM-NAME=\"PatientAssessmentDisplayDetailsForm\">\n<CSS sStyle=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"/>\n\t\t<script src=\'../../eCP/js/PatientAssessment.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</DOCUMENT>\t\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "application/xml; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("application/xml");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

//This file is saved on 18/10/2005.
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con	= null;
	CallableStatement CalStmt =null;
	String accession_num	= (request.getParameter("accession_num")==null)?"":request.getParameter("accession_num");
	String note_type	= (request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	String facility_id	= (String)session.getAttribute("facility_id")==null?"": (String)session.getAttribute("facility_id");
	if(!accession_num.equals("")){
		StringBuffer contentXML = new StringBuffer();
		//String systemDateTime = ""; 
		//String systemDate = ""; 
		try
		{
			con	= ConnectionManager.getConnection(request);
			CalStmt=con.prepareCall("{call CP_GET_ASSESS_SCORE(?,?,?,?)}");
			CalStmt.setString(1, accession_num);
			CalStmt.setString(2, facility_id);
			CalStmt.setString(3, note_type);
			CalStmt.registerOutParameter(4, Types.CLOB);
			CalStmt.execute();

			Clob clb = CalStmt.getClob(4);

				if(clb!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) {
						contentXML.append(line);
					}
                out.println(contentXML.toString());
				}			
			if(CalStmt!=null) CalStmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
                         e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
	}


            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
