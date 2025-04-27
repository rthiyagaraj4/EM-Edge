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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesdocsectiondisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesDocSectionDisplay.jsp", 1738300058088L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n----------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History      Name        \t\tDescription\n----------------------------------------------------------------------------------------------------------------------------\n?            \t100            \t\t?           \t\tcreated\n23/12/2013\t\tIN045932\t\tNijitha S           ML-BRU-SCF-1211 \n20/09/2019\t\tIN071408\t\tSIVABAGYAM M\t\tRAMESH G    20/09/2019\t\t\t\tRegression-OR/RL-Existing Orders and Attached Images\n----------------------------------------------------------------------------------------------------------------------------\n \n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<div id=\"data\" style=\'display:none;\' border=\'0\' width=\'0\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</div>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'section_hdg_code\' id=\'section_hdg_code\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'subsection_hdg_code\' id=\'subsection_hdg_code\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n</form>\n</BODY>\n</HTML>\n<script>\nif(parent.RecClinicalNotesLinkHistNoteAddButtonsFrame != null)\n\tparent.RecClinicalNotesLinkHistNoteAddButtonsFrame.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;\t\t\t\n</script>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

int i=1;
String			patient_id				=	"";
String			encounter_id				=	"";
String			facility_id				=	"";
String			accession_num			=	"";
String			section_hdg_code		=	"";
String			subsection_hdg_code		=	"";
StringBuffer	buf						=	new StringBuffer();
//the following variable will be used to get the raw section content from the database. if it is not a template, the it would not be converted, otherwise it would be.



//the following variable will be used to convert the XML content coming from the database to HTML through the XMLToHTML convertor if the contenttype is a template.
String			notes_section_content	=	"";
String			section_img_content		=	"";
StringBuffer			qry						=	new StringBuffer();
String			sec_content_type			=	"";
String			subsec_content_type			=	"";
String			preserve_format_yn			=	"";
String			image_linked_yn			=	"";
StringBuffer image_qry = new StringBuffer();
Clob			clb=null;
Clob			iclb=null;
java.sql.ResultSet		rs = null;
java.sql.Connection		con = null;
java.sql.PreparedStatement pstmt = null;
java.sql.PreparedStatement ipstmt = null;
java.sql.ResultSet		irs = null;

            _bw.write(_wl_block9Bytes, _wl_block9);

	//facility_id	= (String) session.getValue("facility_id");//IN045932
	facility_id = (request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));//IN045932
	accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));
	section_hdg_code = (request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code"));
	subsection_hdg_code = (request.getParameter("subsection_hdg_code")==null?"":request.getParameter("subsection_hdg_code"));
	patient_id = (request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	encounter_id = (request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"));

	
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

	if (!section_hdg_code.equals(""))
	{
		//qry.append("select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.subsec_hdg_code , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content, NVL(c.PRESERVE_FORMAT_YN, b.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where  facility_id = ? and accession_num = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and a.sec_hdg_code = ?  ");
		qry.append("select 	a.sec_hdg_code , c.content_type sec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.sec_hdg_code,?,'1') sec_hdg_desc , a.subsec_hdg_code , c.content_type subsec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.subsec_hdg_code,?,'1')  subsec_hdg_desc, a.notes_section_content,c.PRESERVE_FORMAT_YN PRESERVE_FORMAT_YN,c.image_linked_yn 	from 	ca_encntr_note_section a ,ca_section_hdg_lang_vw c 	where  	facility_id = ? and 	accession_num = ? and 	c.language_id = ? and 	c.sec_hdg_code=a.SUBSEC_HDG_CODE and 	a.sec_hdg_code = ?  ");

		if (!subsection_hdg_code.equals(""))
			qry.append("and subsec_hdg_code= ? ");

	}
	else
	{
		qry = new StringBuffer();
		qry.append("select  NOTE_CONTENT  from ca_encntr_note where facility_id = ? and accession_num = ?  ");
	}
	
	
	try
	{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry.toString());
		if (!section_hdg_code.equals(""))
		{
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, facility_id);
			pstmt.setString(4, accession_num);
			pstmt.setString(5, locale);
			pstmt.setString(6, section_hdg_code);

			if (!subsection_hdg_code.equals(""))
				pstmt.setString(7, subsection_hdg_code);
		}
		else 
		{
			pstmt.setString(1, facility_id);
			pstmt.setString(2, accession_num);	
		}
		
		rs = pstmt.executeQuery();
	  
		if (!section_hdg_code.equals(""))
	    {
			buf.append("<HTML><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>   <script src='../../eCommon/js/showModalDialog.js' type='text/javascript'></script></HTML>");

       // <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
        //<script src="../../eCommon/js/showModalDialog.js"></script>
      

      

        
      // <BODY onKeyDown='lockKey()'>;
	 
			while(rs.next())
			{
			  notes_section_content = "";
		 
			buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			sec_content_type = rs.getString("sec_content_type");
			image_linked_yn = rs.getString("image_linked_yn")==null?"N":rs.getString("image_linked_yn");
						
			if(!sec_content_type.equals("S"))
			{			
				buf.append("<table width='100%'><tr><td class='NOTEHEADER'>");	
				buf.append(rs.getString("sec_hdg_desc"));
				buf.append("</td></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				clb = rs.getClob("notes_section_content");
				
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

				if(image_linked_yn.equals("Y"))
				{
					image_qry.append("select img_content from ca_encntr_note_section_obj where operating_facility_id = ? and accession_num =? and sec_hdg_code = ? ");
					if(!subsection_hdg_code.equals(""))
					{
						image_qry.append(" and subsec_hdg_code = ? ");
					}
					
					ipstmt	= con.prepareStatement(image_qry.toString());
					ipstmt.setString(1, facility_id);
					ipstmt.setString(2, accession_num);
					ipstmt.setString(3, section_hdg_code);
					if(!subsection_hdg_code.equals(""))
					{
						ipstmt.setString(4, subsection_hdg_code);
					}

					irs = ipstmt.executeQuery();

					while(irs.next())
					{
						iclb = irs.getClob("img_content");

						if(iclb.length()>0)
						{
							
							BufferedReader im  = new BufferedReader(iclb.getCharacterStream() );
							String iline="";
						
							while(iline!=null)
							{
								section_img_content+=iline;
								iline = im.readLine();					
							}
						}

					}


					if(irs!=null)  irs.close();
					if(ipstmt!=null) ipstmt.close();

		

				}
				if(sec_content_type.equals("T"))
				{	
				//IN071408 STARTS			
					/* 
					StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
					url = new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));
					*/						
					String url					= application.getRealPath("/eCA")+"/";
					
				
					preserve_format_yn= rs.getString("preserve_format_yn");
					buf.append("<table width='100%'><tr><td>");	

					if (preserve_format_yn.equals("Y"))
						url		=url+"html/RecClinicalNotesTemplateDispayView.xsl";
					else
						url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";

					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url);
					//IN071408 ENDS
					buf.append(notes_section_content);
					
					buf.append("</table>");	
					//eCA/html/RecClinicalNotesTemplateDispayView.xsl":"eCA/html/RecClinicalNotesTemplateSentenceView.xsl
				}
				else
				{
					buf.append(notes_section_content);
					
					if(!section_img_content.equals(""))
					{

						buf.append("<tr><td colspan='3'><applet name='"+section_hdg_code + subsection_hdg_code+"' code='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='845' height='400' align='baseline'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'><param name='image' value='"+section_img_content+"'></applet> ");
						section_img_content="";
						//buf.append("<tr><td colspan='3'><OBJECT name='"+section_hdg_code + subsection_hdg_code+"' code='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='660' height='360' align='baseline'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'><param name='image' value='"+section_img_content+"'></OBJECT> ");
						//buf.append("<tr><td colspan='3'><OBJECT codetype='application/java'  name='"+section_hdg_code + subsection_hdg_code+"' classid='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='660' height='360' align='baseline' data ='"+section_img_content+"'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'></OBJECT> ");
						//<OBJECT data="http://www.somecompany.com/People/Ian/vacation/family.png" type="image/png">A photo of my family at the lake.</OBJECT> 
					}
				}
			
			}
			else
			{
				subsec_content_type = rs.getString("subsec_content_type");
				if(i==1)
			
					buf.append("<table width='100%'><tr><td class='NOTEHEADER' >" + rs.getString("sec_hdg_desc") + "</td></tr></table>");
				i++;
				buf.append("<table width='100%'><td class='NOTESUBHEADER'>" + rs.getString("subsec_hdg_desc") + "</td></table>");
				clb = rs.getClob("notes_section_content");
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
					//IN071408 STARTS
					/*
					StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
					url= new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));
					*/
					//url.append("html/RecClinicalNotesTemplateDispayView.xsl");
					String url					= application.getRealPath("/eCA")+"/";
					preserve_format_yn= rs.getString("preserve_format_yn");

					if (preserve_format_yn.equals("Y"))
						url		=url+"html/RecClinicalNotesTemplateDispayView.xsl";
					else
						url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";

					
					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url);
					//IN071408 ENDS
					buf.append("<table width='100%'><tr><td>");	
					buf.append(notes_section_content);
					buf.append("</table>");	
				}
				else
					buf.append(notes_section_content);
			}
		}
		if(rs!=null)  rs.close();
		if(pstmt!=null) pstmt.close();
		 buf.append("</BODY></HTML>");
		
	  }
		else
		{
			if (rs.next())
			{
				clb = rs.getClob("NOTE_CONTENT");
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
					buf.append(notes_section_content);
				}
			}
			if(rs!=null)  rs.close();
			if(pstmt!=null) pstmt.close();

		}

	}
	catch(SQLException sqle)
	{
		buf.append("SQL Exception 1 = " + sqle);
		sqle.printStackTrace();
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception se)
	{
		buf.append("Exception = " + se);
		se.printStackTrace();
	}
	finally
	{
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con);
	}
	//buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>");
	buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/ " + sStyle + "'>");

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(buf));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(buf));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(section_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(subsection_hdg_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
