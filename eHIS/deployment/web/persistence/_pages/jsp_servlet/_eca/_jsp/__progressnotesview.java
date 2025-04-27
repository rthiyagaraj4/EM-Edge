package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __progressnotesview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProgressNotesView.jsp", 1709116081700L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/ProgressNotes.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t<form METHOD=POST ACTION=\"\" name=\"progNotesView\" id=\"progNotesView\"  >\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
		
	String progression_ref = request.getParameter("progression_ref")==null?"":request.getParameter("progression_ref");
	String note_group = request.getParameter("note_group")==null?"":request.getParameter("note_group");
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");

	String outData ="";
	String note_group_desc = request.getParameter("note_group_desc")==null?"":request.getParameter("note_group_desc");
	String note_type_desc ="";
	String note_type ="";
	Boolean flag = true;
	
            _bw.write(_wl_block9Bytes, _wl_block9);
	
	String level = request.getParameter("level")==null?"":request.getParameter("level");
	try
	{
		con = ConnectionManager.getConnection(request);

		if(level.equals("PN"))
		{
			String notesViewQry = " SELECT NOTE_TYPE,(select NOTE_GROUP_ID from ca_note_type a where a.NOTE_TYPE = b.NOTE_TYPE ) note_group, (select CA_GET_DESC.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type a  where a.NOTE_TYPE = b.NOTE_TYPE ) note_group_desc, CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_type_desc ,NOTE_CONTENT  FROM CA_ENCNTR_NOTE  B WHERE ACCESSION_NUM IN ( SELECT ACCESSION_NUM FROM CA_PAT_PROGRESSION_DTL WHERE PROGRESSION_REF = ? ) AND EVENT_STATUS !=9 order by note_group_desc, note_type_desc,EVENT_DATE_TIME " ;

			String pre_note_group = "";
		
			try
			{
				pstmt		=	con.prepareStatement(notesViewQry);

				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,progression_ref);
				
				rs	 =	pstmt.executeQuery();
				while(rs.next())
				{
					flag = false;
					note_group = rs.getString("note_group");
					note_group_desc = rs.getString("note_group_desc");
					if(!note_group.equals(pre_note_group))
					{
						if(!outData.equals(""))
						{
							outData = outData + "</TD></TR></TABLE>";
						}
						
						outData = outData+ "<BR><BR><table border=2 bordercolor=#707070 cellspacing=0 width='100%' style='font-family:Verdana' ><tr><td style='background-color:#707070;' colspan='3'><font style='FONT-SIZE:18pt;font-weight:bold;'><u>"+note_group_desc+"</u></font></td></tr> <tr><td colspan='3'>&nbsp;</td></tr> <tr><td colspan='3'> ";
					}

					outData = outData + rs.getString("NOTE_CONTENT")+"<BR><hr style=' height: 3px; color:#707070 ' > <BR>";

					pre_note_group = note_group;
					
				}

				outData = outData + "</TD></TR></TABLE></BODY></HTML>";

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(!flag)
					out.println(outData);
			
			}
			catch (Exception e) 
			{
				e.printStackTrace();			
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
		}
		else if(level.equals("NG"))
	{
		String notesViewQry = " SELECT NOTE_TYPE,CA_GET_DESC.CA_NOTE_GROUP(?,?,2) note_group_desc, CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_type_desc ,NOTE_CONTENT  FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM IN   ( SELECT ACCESSION_NUM FROM CA_PAT_PROGRESSION_DTL WHERE PROGRESSION_REF = ?  ) AND NOTE_TYPE IN ( SELECT NOTE_TYPE FROM CA_NOTE_TYPE WHERE NOTE_GROUP_ID = ? ) AND EVENT_STATUS !=9 order by note_type_desc, EVENT_DATE_TIME" ;
		
		try
			{
				pstmt		=	con.prepareStatement(notesViewQry);

				pstmt.setString(1,note_group);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,progression_ref);
				pstmt.setString(5,note_group);

				rs	 =	pstmt.executeQuery();
				
				outData = "<table border=2 bordercolor=#707070 cellspacing=0 width='100%' style='font-family:Verdana' ><tr><td style='background-color:#707070;' colspan='3'><font style='FONT-SIZE:18pt;font-weight:bold;'><u>"+note_group_desc+"</u></font></td></tr> <tr><td colspan='3'>&nbsp;</td></tr> <tr><td colspan='3'> ";
				//outData = "<tr><td>123"+note_group_desc+"</td></tr>";
				while(rs.next())
				{

					flag = false;
					note_type =  rs.getString("NOTE_TYPE");
					note_type_desc =  rs.getString("note_type_desc");
					note_group_desc =  rs.getString("note_group_desc");
					
					outData = outData + rs.getString("NOTE_CONTENT")+"<BR><hr style=' height: 3px; color:#707070 ' > <BR>";
								
				}

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				outData = outData + "</TD></TR></TABLE></BODY></HTML>";

				if(!flag)
					out.println(outData);		
			}
			catch (Exception e) 
			{
				e.printStackTrace();			
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}	
		}
		else if(level.equals("NT"))
	{
			String notesViewQry = " SELECT NOTE_TYPE,(select CA_GET_DESC.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type a  where a.NOTE_TYPE = b.NOTE_TYPE ) note_group_desc, CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_type_desc ,NOTE_CONTENT  FROM CA_ENCNTR_NOTE b WHERE ACCESSION_NUM = ? " ;
			
			try
				{
					pstmt		=	con.prepareStatement(notesViewQry);

					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,accession_num);
					
					rs	 =	pstmt.executeQuery();
					
					while(rs.next())
					{

						flag = false;
						note_type =  rs.getString("NOTE_TYPE");
						note_type_desc =  rs.getString("note_type_desc");
						note_group_desc =  rs.getString("note_group_desc");
						
						outData = "<BR><BR><HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border=2 bordercolor=#707070 cellspacing=0 width='100%' style='font-family:Verdana' ><tr><td style='background-color:#707070;' colspan='3'><font style='FONT-SIZE:18pt;font-weight:bold;'><u>"+note_group_desc+"</u></font></td></tr> <tr><td colspan='3'>&nbsp;</td></tr> <tr><td colspan='3'>";
						
						
						outData = outData + rs.getString("NOTE_CONTENT")+"<BR><BR>";
						
					
					}
						outData = outData + "</TD></TR></TABLE></BODY></HTML>";

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					if(!flag)
						out.println(outData);
				
				}
				catch (Exception e) 
				{
					e.printStackTrace();			
				}
				finally
				{
					if(con != null) ConnectionManager.returnConnection(con,request);
				}	
			}
		}//end of try - main
		catch(Exception conexp)
		{
			System.out.println("Exception in creation of connection in ProgressNotesView.jsp ---"+conexp.toString());
			conexp.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}

		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'))</script>");		
		}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
