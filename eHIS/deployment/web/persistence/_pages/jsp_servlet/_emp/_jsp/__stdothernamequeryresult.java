package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __stdothernamequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/StdOtherNameQueryResult.jsp", 1709180140707L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/26/2005 1:43 PM -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t <Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t <script Language=\"JavaScript\" src=\"../js/StdOtherName.js\"></script>\n\t</head>\n\t<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr >\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table><BR><BR>\n\t\t</P>\n\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</td></tr>\n</table>\n<br><center>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</center>\n<form name=\'dummyform\' id=\'dummyform\' action=\'StdOtherNameQueryResult.jsp\' method=\'post\'>\n    <input type=\'hidden\' name=\'from\' id=\'from\' >\n    <input type=\'hidden\' name=\'to\' id=\'to\' >\n    <input type=\'hidden\' name=\'whereclause\' id=\'whereclause\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

    String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();

    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

	String language_direction="";
	int count=0;

    if(!(whereClause == null || whereClause.equals("")) )
    {
		
		sbQuery.append(whereClause);
		
        /*InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( sbQuery.toString().getBytes()), "UTF-8" ) ;
		sbQuery.append((new BufferedReader(reader)).readLine());
		reader.close();*/

    }  //end of where clause IF
    else
    {
		String lastname = request.getParameter("other_name");
        String lastnameloclang = request.getParameter("other_name_loc_lang");
        if (lastnameloclang==null) lastnameloclang = "";
        String enabled = request.getParameter("eff_status");
        
        InputStreamReader reader;

        reader = new InputStreamReader( new ByteArrayInputStream( lastnameloclang.getBytes()), "UTF-8" ) ;
        lastnameloclang = (new BufferedReader(reader)).readLine() ;     

        int andCheck = 0;

        lastname=lastname.toUpperCase();
        
            if ( !(lastname == null || lastname.equals("")) )
            {
				sbQuery.append("where upper(other_name) like '");
				sbQuery.append(lastname);
				sbQuery.append("%'");
                andCheck = 1;
            }
        
            if ( !(lastnameloclang == null || lastnameloclang.equals("")) )
            {
                if ( andCheck == 1 )
                {  
					sbQuery.append(" and ");
					sbQuery.append("other_name_loc_lang like  '");
					sbQuery.append(lastnameloclang);
					sbQuery.append("%'");

                }
                else
                {
					sbQuery.setLength(0);
					sbQuery.append("where other_name_loc_lang like '");
					sbQuery.append(lastnameloclang);
					sbQuery.append("%'");

                    andCheck = 1;
                }
            }
        
        
            if ( !(enabled == null || enabled.equals("")) )
            {
                   
  			String strEffStatus="";
			if(enabled.equals("E"))
				strEffStatus="E";
			else if(enabled.equals("D"))
				strEffStatus="D";
			
			if(andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='"+strEffStatus+"'");
			}else if(!enabled.equals("B")){
				sbQuery.append(" and eff_status='"+strEffStatus+"'");
			}
		      if ( enabled.equals("B") ){
				//Added on 2/22/2005
				if(andCheck == 0){
					sbQuery.setLength(0);
					sbQuery.append(" where (eff_status='E' or eff_status='D') ");
				}else
					sbQuery.append(" and (eff_status='E' or eff_status='D') ");
				
			}
        }
    }       

    String ord[] = request.getParameterValues("orderbycolumns");

	//out.println("ord[] :"+ord);
	
    if ( !(ord == null || ord .equals("")) )
    {
			sbQuery.append(" order by ");

			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);

				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
				}
			}
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

Connection conn = null;
java.sql.Statement stmt=null;
java.sql.PreparedStatement pstmt1=null;
ResultSet rs=null;
ResultSet rs2=null;
//int maxRecord = 0;
try{
    conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

/*rs = stmt.executeQuery("select count(*) as total from mp_std_other_name "+ sbQuery.toString());
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)    {rs.close();rs=null;} ;

if (maxRecord==0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");*/



			if(pstmt1 != null) pstmt1.close();
			if(rs2 != null) rs2.close();
			
			pstmt1 = conn.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E'" );
			
			rs2 = pstmt1.executeQuery() ;
				 
			 if ( rs2 != null && rs2.next() ) 
			 {
			 count = rs2.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "R" ;
			}else
			{
				 language_direction = "L" ;
			}


rs = stmt.executeQuery("select * from mp_std_other_name "+ sbQuery.toString());
boolean oth_lang = false ;


PreparedStatement stmt1 = conn.prepareStatement(" select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP' " );
ResultSet rs1 = stmt1.executeQuery() ;
if( rs1. next())
    oth_lang = true ;

if( rs1 != null ) rs1.close() ;
if( stmt1!= null ) stmt1.close() ;

    

            _bw.write(_wl_block7Bytes, _wl_block7);

    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rs.next() ;

      String classValue = "" ;
	  int cnt=0;

while(i<=end && rs.next())
{
	if(cnt==0)
	{
            _bw.write(_wl_block8Bytes, _wl_block8);

		if ( !(start <= 1) )
		{
			out.println("<td align ='right' id='prev'><A HREF='javascript:nextSet("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		}
		
            _bw.write(_wl_block9Bytes, _wl_block9);


		/*if ( !( (start+14) > maxRecord ) )
		{*/
			out.println("<A HREF='javascript:nextSet("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		//}
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			if( oth_lang )
				out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherNamOtherLang.label","mp_labels")+"</th>") ; 
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
	}
    if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;

    out.println("<tr><td class='" + classValue + "'>");
    String val = rs.getString("other_name");
    if(val == null) val="";
        
    out.println("<a href='../../eMP/jsp/AddModifyStdOtherName.jsp?other_name="+java.net.URLEncoder.encode(val)+"&language_direction="+language_direction+"' target='f_query_add_mod' >");
    out.println(val+"</a></td>");
    if(oth_lang )
    {
        if(classValue .equals("QRYEVEN"))
            classValue =  "QRYEVENOTHLANG";
        else
        classValue = "QRYODDOTHLANG"; 
        
        String val1=rs.getString("other_name_loc_lang");
        if (val1==null)val1="";
        out.println( "<td class='" + classValue 
        + "'");
		if(language_direction.equals("R"))
						{
						out.println("dir='RTL'" ) ;
						}
		out.println(">"+val1); 
        out.println("</td>");
        
        if(classValue.equals("QRYEVENOTHLANG") )
            classValue= "QRYEVEN" ;
        else if(classValue.equals("QRYODDOTHLANG"))
        classValue="QRYODD";
    }
    
    out.println( "<td class='" + classValue +
		"'  align='center'>" ) ;

    if ( rs.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
       out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    i++;
	cnt++;
}
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	
            _bw.write(_wl_block14Bytes, _wl_block14);
 flag = true;
			} else {
            _bw.write(_wl_block15Bytes, _wl_block15);
}

            _bw.write(_wl_block16Bytes, _wl_block16);

    if ( rs!= null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
}catch ( Exception e ){
   // out.println(e.toString());
	e.printStackTrace();
}finally{
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sbQuery.toString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherName.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
