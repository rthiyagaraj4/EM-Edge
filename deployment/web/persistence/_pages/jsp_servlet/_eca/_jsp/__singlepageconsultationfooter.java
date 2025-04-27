package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __singlepageconsultationfooter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SinglePageConsultationFooter.jsp", 1709116319075L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=javascript src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'CONTENT\' >\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t<table border=\'2\'cellpadding=\'0\' cellspacing=\'4\' width=\'100%\'><tr><td>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td></tr></table><BR>\n\t\t\n</form>\n</body>\n</html>\n\n";
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

/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036- new file created.
20/09/2019		IN071408		SIVABAGYAM M		RAMESH G    20/09/2019				Regression-OR/RL-Existing Orders and Attached Images
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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

	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String practitioner_name = request.getParameter("practitioner_name") == null ? "" : request.getParameter("practitioner_name");
	String print_date_time = request.getParameter("print_date_time") == null ? "" : request.getParameter("print_date_time");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	Hashtable htParameter=new Hashtable();
	String	section_content			=	"";
	String  sect_template_query		=	"";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	PreparedStatement pstmt2 = null;
	ResultSet rs2 =	null;
	String	section_content_ftr		=	"";
	Connection con  = null;
	int paramIndex = 0;
	HashMap<String,String> paramMap = null;
	String  url1					=	"";
	String  url						=	"";
	//url   = HttpUtils.getRequestURL(request).toString();//IN071408
	//url = url.substring(0,url.indexOf("jsp/"));//IN071408
	url=application.getRealPath("/eCA/")+"/";//IN071408
	url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";//IN071408
	con =  ConnectionManager.getConnection(request);

		try
			{	
				sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);
				pstmt2.setString(1,"V$RF");
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					System.out.println("SinglePageConsultationHeader.jsp:114");
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
							bf_content_reader	= new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
							section_content = new String(arr_notes_content);
							bf_content_reader.close();
							if(section_content == null)
								section_content = "";
						}
						catch(Exception e)
						{
							//out.println("Exception@1-readCLOB :SinglePageConsultationFooter.jsp: "+e);//COMMON-ICN-0181
							e.printStackTrace();
						}
					}
				}

			//6/5/2014 Moved the code from outside of the try catch to inside try catch

			htParameter.put("V$CUR_USR", practitioner_name);
			htParameter.put("V$PRN_DTTIME", print_date_time);

			StringBuffer section_content_new = new StringBuffer(section_content);
			
			if (! locale.equals("en") )
			{
				if(!section_content_new.toString().equals(""))
				{
					paramMap = new HashMap<String,String>();
					paramMap.put("CURR_SEC_HDG_CODE","V$RF");
					paramMap.put("LOCALE",locale);						
					paramMap.put("RANGE_PASER_YN","N");
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
					section_content_new = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}
			
			if(!section_content_new.toString().equals(""))
			{	
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}
			
			if(!(sectionContentUpdatedXML.toString().equals("")))
			{								
				section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
				
			}
	
			}
			
			catch(Exception eee)
			{
				//out.println("Exceptionin SinglePageConsultationFooter.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
				eee.printStackTrace();
			
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			
	


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(section_content_ftr));
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
