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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __searchstdfamilynameresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/SearchStdFamilyNameResult.jsp", 1734083466131L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 11:32 AM -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML><head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../js/StdFamilyName.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head><BODY  class=\'CONTENT\' onLoad=\'\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<p>\n\t\t\t\t<table align=\'right\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n                ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<BR><BR>\n\t\t\t\t\t\t</p>\n\n\t\t\t\t\t\t<table align=\'center\' border=\"1\" width=\"98%\"cellspacing=\'0\' cellpadding=\'0\' id=\'ResultTab\'>\n\t\t\t\t\t\t<th class=\'columnheader\'  width=\'50%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t\t<th class=\'columnheader\' width=\'50%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\"ResultTab\").rows[1].cells[0].click() ;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"nextval\").innerHTML=\" \";\t\n\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n    </td></tr>\n    </table>\n    <form name=\'dummyform\' id=\'dummyform\' action=\'SearchStdFamilyNameResult.jsp\' method=\'post\'>\n        <input type=\'hidden\' name=\'from\' id=\'from\' >\n        <input type=\'hidden\' name=\'to\' id=\'to\' >\n        <input type=\'hidden\' name=\'whereclause\' id=\'whereclause\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n</form>\n\n<script>\n\t\tif( parent.SearchCriteria.document.Search_STD_Family_Name_form.search != null )\n\t\t\tif( parent.SearchCriteria.document.Search_STD_Family_Name_form.search.disabled )\n\t\t\t\tparent.SearchCriteria.document.Search_STD_Family_Name_form.search.disabled = false;\n</script>\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );
	
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    String strsql2="";
    String sql=" ";
    //String strsql1=" ";

    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;

    int andCheck=0;
    
    if ( whereClause == null || whereClause.equals("")) 
    {
        sql=" ";
        String last_name= request.getParameter("last_name");
        String last_name_loc_lang  = request.getParameter("last_name_loc_lang");
        String criteria=request.getParameter("criteria");
       
        if (!(last_name==null || last_name.equals("")) )
        {
            last_name=last_name.toUpperCase();
            
            if (criteria.equals("N")) {
                sql = " where upper(last_name)= upper('"+last_name+"')";
                andCheck = 1;
            } else if(criteria.equals("C")) {
                sql = " where upper(last_name) like upper('%"+last_name+"%')";
                andCheck = 1;
            } else if(criteria.equals("S")){
                sql = " where upper(last_name) like upper('"+last_name+"%')";
                andCheck = 1;
            } else if(criteria.equals("E")){
                sql = " where upper(last_name) like upper('%"+last_name+"')";
                andCheck = 1;
            }
        }
        
        if (!(last_name_loc_lang==null || last_name_loc_lang.equals("")) )
        {
            if (sql.equals(" "))
            {
                sql = " where ";
            }
            else
            {
                sql = sql + " and ";
            }

			 /* below two line was commented by venkatesh s on 03-Aug-2013 against MMS-SCF-0086 [IN:042990]*/
            //InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( last_name_loc_lang.getBytes()), "UTF-8" ) ;
            //last_name_loc_lang = (new BufferedReader(reader)).readLine() ;

            if (criteria.equals("N"))
            {
                sql = sql + " upper(last_name_loc_lang)=upper('"+last_name_loc_lang+"')";
                andCheck = 1;
            }
            else if(criteria.equals("C")) {
                sql = sql + " upper(last_name_loc_lang) like upper('%"+last_name_loc_lang+"%')";
                andCheck = 1;
            }
			else if(criteria.equals("S")){
				sql = sql + "upper(last_name_loc_lang) like upper('"+last_name_loc_lang+"%')";
                andCheck = 1;
			}
			else if(criteria.equals("E")){
				sql = sql + " upper(last_name_loc_lang) like upper('%"+last_name_loc_lang+"')";
                andCheck = 1;
			}
        }
    }
    else
    {
        sql = whereClause;
        InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( sql.getBytes()), "UTF-8" ) ;
        sql = (new BufferedReader(reader)).readLine() ;     
        reader.close();
    }
     
	
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14;
    else
        end = Integer.parseInt( to ) ;

    Connection conn = null; 
    java.sql.Statement stmt=null;
    ResultSet rs=null;
    //int maxRecord = 0;
    
    try
    {
		conn = ConnectionManager.getConnection(request);
        stmt = conn.createStatement();

		/*
        strsql1="select count(*) as total from mp_std_family_name "+sql;
        rs = stmt.executeQuery(strsql1);
        rs.next();
        maxRecord = rs.getInt("total");
		*/
        
        strsql2  ="select last_name,last_name_loc_lang from mp_std_family_name "+sql + " order by last_name";
        rs = stmt.executeQuery(strsql2); 
                 
        if ( start != 1 )
                for( int j=1; j<start; i++,j++ ) {
                    rs.next() ;
                }
			int cnt = 0;
            while (i<=end && rs.next())
            {
				if(cnt == 0)
				{
					
            _bw.write(_wl_block7Bytes, _wl_block7);
                   
                        if ( !(start <= 1) )
                        {
                            out.println("<A HREF='javascript:nextSet("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
                        }

                       out.println("<A id='nextval' HREF='javascript:nextSet("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
                        
                
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				}

				String classValue = "" ;
                if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
                    classValue = "QRYODD" ;
                
        
                String last_name    = rs.getString("last_name");
                String last_name_loc_lang   = rs.getString("last_name_loc_lang");
                String last_name1   = last_name;
                String last_name_loc_lang1  = last_name_loc_lang;
                
                if(last_name==null || last_name.equals("null"))
                {
                    last_name="&nbsp;";
                    last_name1="";
                }
                if(last_name_loc_lang==null || last_name_loc_lang.equals("null"))
                {
                    last_name_loc_lang="&nbsp;";
                    last_name_loc_lang1="";
                }

				out.println("<tr><td   class='" + classValue + "' align='left' onclick=\"closeWin('"+last_name1+"','"+last_name_loc_lang1+"')\">");
    
                out.println("<a href=\"\">");
                out.println(last_name+"</td>");
                
                if(classValue.equals("QRYEVEN"))    classValue = "QRYEVENOTHLANG";
                else if(classValue.equals("QRYODD"))    classValue = "QRYODDOTHLANG";
                
                out.println("<td  class='" + classValue + "' onclick=\"closeWin('"+last_name1+"','"+last_name_loc_lang1+"')\">");
                out.println("<a href=\"\">");
                out.println(last_name_loc_lang+"</td></tr>");   
                i++;
				cnt++;

                if(classValue.equals("QRYEVENOTHLANG"))    classValue = "QRYEVEN";
                else if(classValue.equals("QRYODDOTHLANG"))    classValue = "QRYODD";
            }//endwhile

			if(cnt==0)				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

			if(i == 2)
			{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			}

			if (!rs.next() && cnt!=0 )
			{
			
            _bw.write(_wl_block12Bytes, _wl_block12);
 } 

    }
    catch(Exception e)
    {
        //out.println(e.toString());
		e.printStackTrace();
    }
    finally
    {
        if(stmt!=null)
            stmt.close();
        if(rs!=null)
            rs.close();
        if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
        
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FamilyName.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FamilyNameinOtherLanguage.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
