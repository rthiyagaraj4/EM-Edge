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
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __querynamesuffix extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/queryNameSuffix.jsp", 1742366368951L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t</head>\n\t<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<form name=\'query_form\' id=\'query_form\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t\t<BR><BR>\n\t\t</P>\n\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</table>\n<br><center>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n</center>\n<input type=\"hidden\" name=\"language_direction\" id=\"language_direction\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
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

    String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

	String language_direction="";
	int count=0;

    if ( (whereClause == null || whereClause.equals("")) )
    {
//        sql = "";
        String name_suffix = request.getParameter("name_suffix");
		if(name_suffix != null)
		name_suffix=name_suffix.toUpperCase();
        String name_suffix_loc_lang = request.getParameter("name_suffix_loc_lang");
		if(name_suffix_loc_lang != null)
		name_suffix_loc_lang=name_suffix_loc_lang.toUpperCase();
        String enabled = request.getParameter("enabled");
        String baby_sex = request.getParameter("baby_sex");
        String baby_suffix_yn = request.getParameter("baby_suffix_yn");

        int andCheck = 0;

    if ( !(name_suffix == null || name_suffix.equals("")) )
        {
		sbQuery.append("where upper(name_suffix) like '");
		sbQuery.append(name_suffix);
		sbQuery.append("%'");
//        sql = "where mar_status_code like '"+cd+"%'";
        andCheck = 1;
        }
    if ( !(name_suffix_loc_lang == null || name_suffix_loc_lang.equals("")) )
    {
        if ( andCheck == 1 )
        {  
			sbQuery.append(" and ");
			sbQuery.append("upper(name_suffix_loc_lang) like  '");
			sbQuery.append(name_suffix_loc_lang);
			sbQuery.append("%'");
//			sql = sql + " and ";
//          sql = sql + "long_desc like  '"+longdesc+"%'" ;
        }
        else
        {
            sbQuery.setLength(0);
			sbQuery.append("where upper(name_suffix_loc_lang) like '");
			sbQuery.append(name_suffix_loc_lang);
			sbQuery.append("%'");
//			sql = "where long_desc like '"+longdesc+"%'" ;
            andCheck = 1;
        }
    }
	if ( !(baby_sex == null || baby_sex.equals("") || baby_sex.equals("A")) )
    {
        if ( andCheck == 1 )
        {  
			sbQuery.append(" and ");
			sbQuery.append("baby_sex like  '");
			sbQuery.append(baby_sex);
			sbQuery.append("%'");
//			sql = sql + " and ";
//          sql = sql + "long_desc like  '"+longdesc+"%'" ;
        } else{
			sbQuery.setLength(0);
			sbQuery.append("where baby_sex like '");
			sbQuery.append(baby_sex);
			sbQuery.append("%'");
//            sql = "where long_desc like '"+longdesc+"%'" ;
            andCheck = 1;
        }
    }
	
	if ( !(baby_suffix_yn == null || baby_suffix_yn.equals("") || baby_suffix_yn.equals("B")) )
    {
		String baby_suffix_yn1="";
		if(baby_suffix_yn.equals("Y"))
			baby_suffix_yn1="Y";
		else if(baby_suffix_yn.equals("N"))
			baby_suffix_yn1="N";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where baby_suffix_yn='"+baby_suffix_yn1+"'");
		}else{
			sbQuery.append(" and baby_suffix_yn='"+baby_suffix_yn1+"'");
		}
    }
	

    if ( !(enabled == null || enabled.equals("") || enabled.equals("B")) )
    {
/*       if ( enabled.equals("E") )
            {
        if ( andCheck == 0 )
            sql = "where eff_status='E'";
        else
            sql = sql + " and eff_status='E'";
        }
       if ( enabled.equals("D") )
        {
        if ( andCheck == 0 )
            sql = " where  eff_status='D'";
        else
            sql = sql + " and eff_status='D'";
        }
		if ( enabled.equals("B") )
        {
        //out.println(sql );

        // sql = sql; nothing is added to get both E and D
        }
*/
		//Added by Sabarinathan S on 2/21/2005
		String strEffStatus="";
		if(enabled.equals("E"))
			strEffStatus="E";
		else if(enabled.equals("D"))
			strEffStatus="D";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where eff_status='"+strEffStatus+"'");
		}else{
			sbQuery.append(" and eff_status='"+strEffStatus+"'");
		}
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}    
	}else{
		sbQuery.append(" order by name_suffix");
//        sql=sql+" order by name_suffix";
	}
    } //end of where clause IF
    else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
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

//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rs=null;
ResultSet rs1 =null;
ResultSet rs2 =null;
   // int maxRecord = 0;
try{
    conn = ConnectionManager.getConnection(request);

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

  /*  pstmt = conn.prepareStatement("select count(*) as total from mp_name_suffix "+sbQuery.toString());

    rs = pstmt.executeQuery();
    rs.next();
    maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
    if (pstmt != null) pstmt.close();  

	if (maxRecord==0) 					
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
	//out.println("sbQuery----->"+sbQuery);
    pstmt = conn.prepareStatement("select * from mp_name_suffix "+sbQuery.toString());
    rs = pstmt.executeQuery();

	boolean oth_lang = false ;
    pstmt1 = conn.prepareStatement(" select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP' " );
    rs1 = pstmt1.executeQuery () ;
    if( rs1. next())
		oth_lang = true ;
	if (rs1 != null) rs1.close();
	if (pstmt1 != null) pstmt1.close();

            _bw.write(_wl_block7Bytes, _wl_block7);

    if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rs.next() ;
        String classValue = "" ;
		int cnt=0;
while ( i<=end && rs.next())
{
	if(cnt==0)
	{
            _bw.write(_wl_block8Bytes, _wl_block8);

		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryNameSuffix.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryNameSuffix.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			if( oth_lang )
				out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NameSuffixinOtherLanguage.label","mp_labels")+"</th>") ; 
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	}
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;

    String code = rs.getString("name_suffix");
	//out.println("code---->"+code);
    out.println("<tr>");
    out.println("   <td class='" + classValue + "'>");
    out.println("       <a href='../../eMP/jsp/NameSuffixModify.jsp?name_suffix="+java.net.URLEncoder.encode(code)+ "&language_direction="+language_direction+"' target='f_query_add_mod' >");
    out.println(code+"</a>");
    out.println("</td>");

    if(oth_lang )
    {
		/*
        if(classValue .equals("QRYEVEN"))
			classValue =  "QRYEVENOTHLANG";           
		else
		    classValue = "QRYODDOTHLANG"; 
		*/
       
        out.println("<td  class='" + classValue + "'");
		if(language_direction.equals("R"))
				{
				out.println("dir='RTL'");
				}
		out.println(">") ;
        out.println(        (rs.getString("name_suffix_loc_lang") == null? "&nbsp;":rs.getString("name_suffix_loc_lang") ) );
        out.println("</td>" );

		/*        
        if(classValue.equals("QRYEVENOTHLANG") )
            classValue= "QRYEVEN" ;
        else if(classValue.equals("QRYODDOTHLANG"))
			classValue="QRYODD";
		*/
    }

    out.println("<td align='center' class='" + classValue + "'>") ;
    if( rs.getString("baby_suffix_yn").equals("Y") )
            out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
            out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
            
    out.println("</td>");
    out.println("<td align='left' class='" + classValue + "'>") ;
    if(rs.getString("baby_sex").equals("M"))
            out.println("Male");
    else if(rs.getString("baby_sex").equals("F"))
            out.println("Female");
    else if(rs.getString("baby_sex").equals("U"))
            out.println("Both");
    else if(rs.getString("baby_sex").equals("B"))
            out.println("Both");
    out.println("</td>");
    
out.println("<td align='center' class='" + classValue + "'>") ;
    if ( rs.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
       out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    i++;
	cnt++;
    out.println("</td></tr>");
}   
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	
            _bw.write(_wl_block15Bytes, _wl_block15);
 flag = true;
			} else {
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

        
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();      
}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}finally{
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NameSuffix.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BabySuffix.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.BabySex.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
