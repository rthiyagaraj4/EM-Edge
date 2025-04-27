package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __searchnameprefixsuffixresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/SearchNamePrefixSuffixResult.jsp", 1709118747464L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script Language=\"JavaScript\" src=\"../js/NamePrefix.js\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<BODY  class=\'CONTENT\' onLoad=\'\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n        <p>\n        <table align=\'right\' >\n        <tr>\n            <td>\n                ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n            </td>\n        </tr>\n        </table>\n        <BR>\n        </p>\n\n        <table align=\'center\' border=\"1\" width=\"100%\"cellspacing=\'0\' cellpadding=\'0\'>\n        <th width=\'50%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n        <th width=\'50%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n    </td></tr>\n    </table>\n    <form name=\'dummyform\' id=\'dummyform\' action=\'SearchNamePrefixSuffixResult.jsp\' method=\'post\'>\n        <input type=\'hidden\' name=\'from\' id=\'from\' >\n        <input type=\'hidden\' name=\'to\' id=\'to\' >\n        <input type=\'hidden\' name=\'whereclause\' id=\'whereclause\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type=\'hidden\' name=\'opt\' id=\'opt\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 
request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

    StringBuffer strsql2=new StringBuffer();
	StringBuffer sbQuery = new StringBuffer();
//	String sql ="";									// will be deleted once code walkthrough is done
    StringBuffer strsql1=new StringBuffer();

    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	String opt = request.getParameter("opt");
    int andCheck=0;
    
    if ( whereClause == null || whereClause.equals("")) 
    {
//        sql="";
        
        String name_prefix_suffix= request.getParameter("name_prefix_suffix");
        String name_prefix_suffix_loc_lang  = request.getParameter("name_prefix_suffix_loc_lang");
        String criteria = request.getParameter("criteria");

        if (!(name_prefix_suffix==null || name_prefix_suffix.equals("")) )
        {
            name_prefix_suffix=name_prefix_suffix.toUpperCase();

			if(opt.equals("Prefix"))
			{
				if (criteria.equals("N")) {
					sbQuery.append(" where upper(NAME_PREFIX)= upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_PREFIX)= upper('"+name_prefix_suffix+"')";
					andCheck = 1;
				} else if(criteria.equals("C")) {
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_PREFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_PREFIX) like upper('%"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("S")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_PREFIX) like upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_PREFIX) like upper('"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("E")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_PREFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_PREFIX) like upper('%"+name_prefix_suffix+"')";
					andCheck = 1;
				}
			}
			else if(opt.equals("Suffix"))
			{
				if (criteria.equals("N")) {
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX)= upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_SUFFIX)= upper('"+name_prefix_suffix+"')";
					andCheck = 1;
				} else if(criteria.equals("C")) {
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_SUFFIX) like upper('%"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("S")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX) like upper('");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("%')");
//					sql = " where upper(NAME_SUFFIX) like upper('"+name_prefix_suffix+"%')";
					andCheck = 1;
				} else if(criteria.equals("E")){
					sbQuery.setLength(0);
					sbQuery.append(" where upper(NAME_SUFFIX) like upper('%");
					sbQuery.append(name_prefix_suffix);
					sbQuery.append("')");
//					sql = " where upper(NAME_SUFFIX) like upper('%"+name_prefix_suffix+"')";
					andCheck = 1;
				}
			}
        }
        
        if (!(name_prefix_suffix_loc_lang==null || name_prefix_suffix_loc_lang.equals("")) )
        {
            if (sbQuery.toString().equals(" "))
            {
				sbQuery.setLength(0);
				sbQuery.append(" where ");
//                sql = " where ";
            }
            else
            {
				sbQuery.append(" and ");
//                sql += " and ";
            }

            InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( name_prefix_suffix_loc_lang.getBytes()), "UTF-8" ) ;
            name_prefix_suffix_loc_lang = (new BufferedReader(reader)).readLine() ;

			if(opt.equals("Prefix"))
			{
				if (criteria.equals("N"))
				{
					sbQuery.append(" NAME_PREFIX_LOC_LANG='");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_PREFIX_LOC_LANG='"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
				else if(criteria.equals("C")) {
					sbQuery.append(" NAME_PREFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_PREFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("S")){
					sbQuery.append(" NAME_PREFIX_LOC_LANG like '");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_PREFIX_LOC_LANG like '"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("E")){
					sbQuery.append(" NAME_PREFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_PREFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
			}
			else if(opt.equals("Suffix"))
			{
				if (criteria.equals("N"))
				{
					sbQuery.append(" NAME_SUFFIX_LOC_LANG='");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG='"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
				else if(criteria.equals("C")) {
					sbQuery.append(" NAME_SUFFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("S")){
					sbQuery.append(" NAME_SUFFIX_LOC_LANG like '");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("%'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG like '"+name_prefix_suffix_loc_lang+"%'";
					andCheck = 1;
				}
				else if(criteria.equals("E")){
					sbQuery.append(" NAME_SUFFIX_LOC_LANG like '%");
					sbQuery.append(name_prefix_suffix_loc_lang);
					sbQuery.append("'");
//					sql = sql + " NAME_SUFFIX_LOC_LANG like '%"+name_prefix_suffix_loc_lang+"'";
					andCheck = 1;
				}
			}
		}
    }
    else
    {
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//        sql = whereClause;
        InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( sbQuery.toString().getBytes()), "UTF-8" ) ;
		sbQuery.setLength(0);
		sbQuery.append((new BufferedReader(reader)).readLine());
//        sql = (new BufferedReader(reader)).readLine() ;     
        reader.close();
    }

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	String prompt		= "";
	String prompt_local	= "";	
	
	Connection conn = null; 
    Statement stmt=null;
    ResultSet rs=null;
    int maxRecord = 0;
    
    try
    {
		if(opt.equals("Prefix"))
		{	
			prompt		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NamePrefix.label","common_labels");
			prompt_local = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NamePrefixinOtherLanguage.label","mp_labels");		

			strsql1.append("select count(*) as total from mp_name_prefix ");
			strsql1.append(sbQuery.toString());
			strsql2.append("select NAME_PREFIX,NAME_PREFIX_LOC_LANG from mp_name_prefix ");
			strsql2.append(sbQuery.toString());
			strsql2.append( " order by NAME_PREFIX");
		}
		else if(opt.equals("Suffix"))
		{
			prompt		 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NameSuffix.label","common_labels");
			prompt_local = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels");		
		
			strsql1.append("select count(*) as total from mp_name_suffix ");
			strsql1.append(sbQuery.toString());
			strsql2.append("select NAME_SUFFIX,NAME_SUFFIX_LOC_LANG from mp_name_suffix ");
			strsql2.append(sbQuery.toString());
			strsql2.append(" order by NAME_SUFFIX");
		}
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strsql1.toString());
			rs.next();
			maxRecord = rs.getInt("total");
			rs = stmt.executeQuery(strsql2.toString()); 
		
            _bw.write(_wl_block7Bytes, _wl_block7);

                        if ( !(start <= 1) )
                        {
                            out.println("<A HREF='javascript:nextSet("+(start-14)+","+(end-14)+")' text-decoration='none'>Previous</A>");
                        }

                        if ( !( (start+14) > maxRecord ) )
                        {
                            out.println("<A HREF='javascript:nextSet("+(start+14)+","+(end+14)+")' text-decoration='none'>Next</A>");
                        }
                
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(prompt));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(prompt_local));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if ( start != 1 )
                for( int j=1; j<start; i++,j++ ) {
                    rs.next() ;
                }

            String classValue = "" ;

            while ( rs.next() && i<=end )
            {
                if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                    classValue = "QRYODD" ;

                out.println("<tr><td   class='" + classValue + "' align='left'>");
        
                String name_prefix_suffix    = rs.getString(1);
                String name_prefix_suffix_loc_lang   = rs.getString(2);
                String name1		  = name_prefix_suffix;
                String name_loc_lang1 = name_prefix_suffix_loc_lang;
                
                if(name_prefix_suffix==null || name_prefix_suffix.equals("null"))
                {
                    name_prefix_suffix="&nbsp;";
                    name1="";
                }
                if(name_prefix_suffix_loc_lang==null || name_prefix_suffix_loc_lang.equals("null"))
                {
                    name_prefix_suffix_loc_lang="&nbsp;";
                    name_loc_lang1="";
                }
    
                out.println("<a id='np"+i+"' href=\"javascript:closeWin('np"+i+"')\">");
                out.println(name_prefix_suffix+"</a></td>");
                
                if(classValue.equals("QRYEVEN"))    classValue = "QRYEVENOTHLANG";
                else if(classValue.equals("QRYODD"))    classValue = "QRYODDOTHLANG";
                
                out.println("<td  class='" + classValue + "' >");
                out.println("<a id='nplc"+i+"' href=\"javascript:closeWin('nplc"+i+"')\">");
                out.println(name_prefix_suffix_loc_lang+"</a></td></tr>");
                i++;

                if(classValue.equals("QRYEVENOTHLANG"))    classValue = "QRYEVEN";
                else if(classValue.equals("QRYODDOTHLANG"))    classValue = "QRYODD";
            }//endwhile

        if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
    }
    catch(Exception e)
    {
        out.println(e.toString());
    }
    finally
    {
        if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
        
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sbQuery.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(opt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
