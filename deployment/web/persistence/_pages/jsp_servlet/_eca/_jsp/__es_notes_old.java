package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import eCA.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __es_notes_old extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ES_Notes_Old.jsp", 1742385459884L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<div id=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"></div>      \n\n<script>\n\n$(document).ready(function() {\t\n\tsetTimeout(function() {\n\t\tparent.printPage();\n\t}, 1000);\n});\n\n</script>\n<div>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<thead> \n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<tr class=\"breakTrNotes\">\n\t\t\t<th>\n\t\t\t\t<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">\n\t\t\t\t\t<tbody>\n\t\t\t\t\t\t<tr class=\"breakTrNotes\">\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t<td style=\"border-bottom:1px solid green;  text-align: left\" valign=\"bottom\">\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t<td style=\"text-align: left\" valign=\"bottom\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t \t\t\n\t\t\t\t\t\t\t\t<span style=\"font-size: 10pt; font-weight: bold;\"><span style=\"font-family: verdana, geneva, sans-serif\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" - ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t\t\t\t\t</span></span>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</tbody>\n\t\t\t\t</table>\n\t\t\t</th>\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</thead> \n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t \t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<tbody>\n\t\t\t<tr class=\"breakTrNotes\">\n\t\t\t\t<td valign=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</tbody>\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\n\t</table>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\n</div>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
	
	String notesHtmlData = ""; 
	StringBuffer notesHtmlDataBfr = new StringBuffer();

	String labTestDesc = "";
	String notesSql = "", labTestSql = "";
	String whereCond = "";

	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;

	int indexOfTilde = 0;	

	String divID = "", queryColumn="", columnName = "", columnData = "", tableName="";
	String resultUOM="", resultStr = "";
	
	int resultNum = 0;
	
	boolean notesContentFlag = false;

	String[] columnArray = null;
	String[] dataArray = null;
	

	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	divID = request.getParameter("divID")==null?"":request.getParameter("divID");
	queryColumn = request.getParameter("queryColumn")==null?"":request.getParameter("queryColumn");
	columnName = request.getParameter("columnName")==null?"":request.getParameter("columnName");
	columnData = request.getParameter("columnData")==null?"":request.getParameter("columnData");
	tableName = request.getParameter("dataTable")==null?"":request.getParameter("dataTable");
	
	indexOfTilde = columnName.indexOf('~');
	columnData = columnData.replace('>', '#');
	whereCond = columnName + " = \'"+ columnData +"\'";	
	
	if (indexOfTilde>0){
		whereCond = "";
		columnArray = columnName.split("~");
		dataArray = columnData.split("~");
		if (columnArray.length > 0){
			for (int i=0;i<columnArray.length;i++){
				if (i<columnArray.length-1){
					whereCond = whereCond + columnArray[i] + " = \'"+ dataArray[i] +"\' and ";	
				}
				else
				{
					whereCond = whereCond + columnArray[i] + " = \'"+ dataArray[i] +"\'";	
				}
			}			
		}
	}

	try
	{
		con		= ConnectionManager.getConnection(request);

		// To get the Notes Information
		notesSql="select "+queryColumn+" note_content FROM " + tableName + " where "+whereCond;
		stmt=con.createStatement();

		rs=stmt.executeQuery(notesSql);
		
		notesHtmlData = "";
		
		notesContentFlag = false;
		
		int posHtml = 0;
		
		if (rs!=null){
			if(rs.next())
			{
				notesHtmlData = rs.getString("note_content")==null?"":rs.getString("note_content");				
				notesContentFlag = true;
				
				if (notesHtmlData.length() > 0){
					posHtml = notesHtmlData.toLowerCase().indexOf("<html><body>");
					if (posHtml < 0){
						notesHtmlDataBfr.append("<HTML><BODY><PRE>");
						notesHtmlDataBfr.append(notesHtmlData);
						notesHtmlDataBfr.append("</PRE></BODY></HTML>");
						notesHtmlData = "";
						notesHtmlData = notesHtmlDataBfr.toString();	
					}					
				}				
			}
			else
			{
				notesContentFlag = false;
			}			
		}
		
		if (!notesContentFlag)
		{
			resultNum = 0;
			resultUOM = "";
			resultStr = "";
			
			notesSql=" select result_num, result_num_uom, result_str from cr_encounter_detail where " +whereCond;
			stmt=con.createStatement();
			rs=stmt.executeQuery(notesSql);
			notesHtmlData = "";
			
			if (rs!=null){
				if(rs.next())
				{
					resultNum = rs.getInt("result_num");
					resultUOM = rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
					resultStr = rs.getString("result_str")==null?"":rs.getString("result_str");
					
					if (resultNum > 0)
					{
						notesHtmlData = resultNum + " " + resultUOM;
					}
					notesHtmlData = notesHtmlData + resultStr;
					notesContentFlag = false;
				}
			}
			
		}
		
		if (dataArray[0].equalsIgnoreCase("lbin"))
		{
		
			labTestSql = " select short_desc from cr_event_hist_rec_vw where hist_rec_type = '"+dataArray[0]+"' " + 
						 " and event_code_type = '"+dataArray[1]+"' and language_id = '"+locale+"' and event_code = '"+dataArray[3]+"' ";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(labTestSql);
			
			labTestDesc = "";
			
			if (rs!=null)
			{
				if(rs.next())
				{
					labTestDesc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
				}
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(divID));
            _bw.write(_wl_block6Bytes, _wl_block6);

	if (dataArray.length > 0)
	{									

            _bw.write(_wl_block7Bytes, _wl_block7);
 
			if (notesContentFlag) 
			{											
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			
		
            _bw.write(_wl_block9Bytes, _wl_block9);
 
								if (notesContentFlag) 
								{											
							
            _bw.write(_wl_block10Bytes, _wl_block10);

								}
								else
								{
							
            _bw.write(_wl_block11Bytes, _wl_block11);

								} 
							
            _bw.write(_wl_block12Bytes, _wl_block12);
 
									if (notesContentFlag) 
									{											
								
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( labTestDesc ));
            _bw.write(_wl_block14Bytes, _wl_block14);

									}
									else
									{
								
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( labTestDesc ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( notesHtmlData ));
            _bw.write(_wl_block16Bytes, _wl_block16);

									} 
								
            _bw.write(_wl_block17Bytes, _wl_block17);
 
			if (notesContentFlag) 
			{											
		
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			
		
            _bw.write(_wl_block19Bytes, _wl_block19);
 
		if (notesContentFlag) 
		{											
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(notesHtmlData));
            _bw.write(_wl_block21Bytes, _wl_block21);

		}	
		
            _bw.write(_wl_block22Bytes, _wl_block22);

		} 
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	}
	catch(Exception e){
		out.println("Exception: "+e.toString());
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}	

            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
