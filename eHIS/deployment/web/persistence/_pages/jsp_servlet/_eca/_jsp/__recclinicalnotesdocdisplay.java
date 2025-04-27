package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesdocdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesDocDisplay.jsp", 1709116123136L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<div id=\"data\" style=\'display:none;\' border=\'0\' width=\'0\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</div>\n</form>\n</BODY>\n</HTML>\n<script>\nif(parent.RecClinicalNotesLinkHistNoteAddButtonsFrame != null)\n\tparent.RecClinicalNotesLinkHistNoteAddButtonsFrame.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;\n</script>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
--------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String			accession_num			=	"";
String			facility_id				=	"";
String			section_hdg_code		=	"";
String			subsec_hdg_code			=	"";
StringBuffer	buf						=	new StringBuffer();
//the following variable will be used to get the raw section content from the database. if it is not a template, the it would not be converted, otherwise it would be.



//the following variable will be used to convert the XML content coming from the database to HTML through the XMLToHTML convertor if the contenttype is a template.
String			notes_section_content	=	"";
String			qry						=	"";
String			subsec_content_type			=	"";
java.sql.ResultSet		rs = null;
java.sql.Connection		con = null;
java.sql.PreparedStatement pstmt = null;

            _bw.write(_wl_block9Bytes, _wl_block9);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	//qry = "select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.SUBSEC_HDG_CODE , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where accession_num = ? and facility_id = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and a.sec_hdg_code = ? and a.SUBSEC_HDG_CODE = ?";
	qry="select a.sec_hdg_code , b.content_type sec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.sec_hdg_code,?,'1') sec_hdg_desc , a.SUBSEC_HDG_CODE ,c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content from ca_encntr_note_section a ,ca_section_hdg_LANG_vw c where 	accession_num = ? and 	facility_id = ? and	c.language_id = ? and 	c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and 	a.sec_hdg_code = ? and 	a.SUBSEC_HDG_CODE = ?";
	accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));
	//facility_id = (request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));
	facility_id = (String)session.getValue("facility_id");
	section_hdg_code = (request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code"));
	subsec_hdg_code = (request.getParameter("subsec_hdg_code")==null?"":request.getParameter("subsec_hdg_code"));
	try
	{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry);
		pstmt.setString(1, locale);
		pstmt.setString(2, accession_num);
		pstmt.setString(3, facility_id);
		pstmt.setString(4, locale);
		pstmt.setString(5, section_hdg_code);
		pstmt.setString(6, subsec_hdg_code);
		rs = pstmt.executeQuery();
		buf.append("<link rel=StyleSheet href='../../eCommon/html/" + sStyle + "' type='text/css' />");
		while(rs.next())
		{
			buf.append("&nbsp;&nbsp;&nbsp;");
			buf.append("&nbsp;&nbsp;&nbsp;");
			buf.append("&nbsp;&nbsp;&nbsp;");
			buf.append("<table width='100% '><tr><td class='NOTEHEADER'>");
			buf.append(rs.getString("subsec_hdg_desc"));
			buf.append("</td></tr></table>");
			buf.append("&nbsp;&nbsp;&nbsp;");
			subsec_content_type = rs.getString("subsec_content_type");
			Clob clb = rs.getClob("notes_section_content");
			if(clb.length()>0)
			{
				//java.io.BufferedInputStream r = clb.getAsciiStream();
				BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
				String line="";
				while(line!=null)
				{
					notes_section_content+=line;
					line = d.readLine();					
				}
			}
			if(subsec_content_type.equals("T"))
			{			
				//buf.append("Eureka!!! its a template");
				// IN071335 Changes Start.
				/*
				StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
				url = new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));					
				url.append("html/RecClinicalNotesTemplateSentenceView.xsl");
				notes_section_content = converter.buildHTMLFromXML(notes_section_content,url.toString());
				*/
				String url					= application.getRealPath("/eCA")+"/";
				url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";
				notes_section_content = converter.buildHTMLFromXML(notes_section_content,url); 				
				// IN071335 Changes End.
				buf.append(notes_section_content);
			}
			else
				buf.append(notes_section_content);
		}
	}
	catch(SQLException sqle)
	{
		buf.append("SQL Exception = " + sqle);
		sqle.printStackTrace();
	}
	catch(Exception se)
	{
		buf.append("SQL Exception = " + se);
		se.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();

		if(con!=null)	ConnectionManager.returnConnection(con);
	}
//	buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>");
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(buf));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(buf));
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
