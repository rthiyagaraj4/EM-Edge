package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.w3c.dom.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __recclinicalnotestemplateview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesTemplateView.jsp", 1709116200747L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<?xml version=\'1.0\' encoding=\"UTF-8\"?>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea.xsl\"?>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea_SplVald.xsl\"?>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingView.xsl\"?>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingView__SplVald.xsl\"?>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<DOCUMENT FORM-NAME=\"RecClinicalNotesTemplateForm\">\n<CSS sStyle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/dchk.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart1.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart2.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCommon/js/CommonCalendar.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js\'></SCRIPT>\n<!--included for 10261 in 07/06/09-->\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/SpeciltyEvents.js\'></SCRIPT>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<HIDDEN-FIELD NAME=\"systemDate99999A\" VALUE=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"systemDateTime99999A\" VALUE=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></HIDDEN-FIELD>\n</DOCUMENT>\n\t\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "application/xml;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("application/xml;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created 
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory� results in a clinical note section template does not display neatly .	
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN041284 Start.
	String dispResLinkHYMLYN 		=(request.getParameter("dispResLinkHYMLYN")==null)?"N":(String)request.getParameter("dispResLinkHYMLYN");
	String noteSplCharValidate 		=(request.getParameter("noteSplCharValidate")==null)?"N":(String)request.getParameter("noteSplCharValidate"); //IN059571	
if("Y".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){

            _bw.write(_wl_block3Bytes, _wl_block3);

//IN059571 Start. 
}else if("Y".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){

            _bw.write(_wl_block4Bytes, _wl_block4);

}else if("N".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){

            _bw.write(_wl_block5Bytes, _wl_block5);

}else if("N".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){

            _bw.write(_wl_block6Bytes, _wl_block6);

//IN059571 End.	
} //IN041284 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con	= null;
	PreparedStatement pstmt	= null;	
	ResultSet rs = null;

	String sec_hdg_code	= (request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
	StringBuffer contentXML = new StringBuffer();
	String systemDateTime = ""; 
	String systemDate = ""; 
	
	try
	{
		con	= ConnectionManager.getConnection(request);
		String query = " Select TEMPLATE_FORMAT, to_char(sysdate, 'dd/mm/yyyy hh24:mi') systemDateTime, to_char(sysdate, 'dd/mm/yyyy') systemDate  from CA_SECTION_HDG where sec_hdg_code = ? ";
		pstmt		=	con.prepareStatement(query);
		pstmt.setString	(	1,	sec_hdg_code	);		
		rs			=	pstmt.executeQuery();
		if(rs.next())
		{
			Clob clb = rs.getClob(1);
			systemDateTime = rs.getString("systemDateTime");
			systemDate = rs.getString("systemDate");

			if(clb!=null)
			{
				java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
				String line = null;
				while((line=r.readLine()) != null) {
					contentXML.append(line);
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(contentXML.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}			
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
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

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(systemDate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(systemDateTime));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
