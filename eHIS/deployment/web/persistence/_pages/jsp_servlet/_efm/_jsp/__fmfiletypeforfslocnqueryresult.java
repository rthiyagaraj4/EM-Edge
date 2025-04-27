package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmfiletypeforfslocnqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileTypeforFSLocnQueryResult.jsp", 1742884836392L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t<P><table align=\'right\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t\t</table></P>\n\t\t\t\t\t\t\t<br><br>\n\t\t\t\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td></tr>\n\t\t</table>\n\t</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>");
	
	String whereClause	= request.getParameter("whereclause");
	String facilityId	= (String) session.getValue( "facility_id" ) ;
	
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;

	StringBuffer sql	 = null;
	StringBuffer strsql1 = null;
	StringBuffer strsql2 = null;
	sql					 = new StringBuffer();
	strsql1				 = new StringBuffer();
	strsql2				 = new StringBuffer();
	
	int andCheck = 0;

	if(facilityId==null) facilityId = "";

	if ((whereClause == null || whereClause.equals("")))
	{
		String fs_locn_code			= request.getParameter("fs_locn_code");
		String fs_locn_short_desc   = request.getParameter("fs_locn_short_desc");
		String file_type_code		= request.getParameter("file_type_code");
		String file_type_short_desc = request.getParameter("file_type_short_desc");
		String enabled				= request.getParameter("eff_status");
	
		fs_locn_code	= fs_locn_code.toUpperCase(); 
		file_type_code	= file_type_code.toUpperCase();

		sql.append(" where facility_id = '"+facilityId+"' ");

     	andCheck		= 1;

		if(!(fs_locn_code == null || fs_locn_code.equals("")))
		{
			if (andCheck == 1)
			{
				sql.append(" and ");
				sql.append(" upper(fs_locn_code) like upper('"+fs_locn_code+"%') ");
				andCheck = 1;							
			}
			else
			{
				sql.append(" where upper(fs_locn_code) like upper('"+fs_locn_code+"%') ");
				andCheck = 1;
			}
		}
		if(!(fs_locn_short_desc == null || fs_locn_short_desc.equals(""))) 
		{
			if(andCheck == 1)
			{
				sql.append(" and ");
				sql.append("upper(fs_locn_short_desc) like  upper('"+fs_locn_short_desc+"%') ") ;
			}
			else
			{
				sql.append(" where upper(fs_locn_short_desc) like upper('"+fs_locn_short_desc+"%') ") ;
				andCheck = 1;
			}
		 }
		 if(!(file_type_code == null || file_type_code.equals(""))) 
		 {
			 if(andCheck == 1)
			 {
				 sql.append(" and ");
				 sql.append(" upper(file_type_code) like  upper('"+file_type_code+"%') ");
			 }
			 else
			 {
				 sql.append(" where upper(file_type_code) like upper('"+file_type_code+"%') ");
				 andCheck = 1;
			 }
		 }
		 if(!(file_type_short_desc == null || file_type_short_desc.equals("")))
		 {
			 if ( andCheck == 1 )
			 {
				 sql.append(" and ");
				 sql.append(" upper(file_type_short_desc) like  upper('"+file_type_short_desc+"%') ");
			 }
			 else
			 {
				 sql.append(" where upper(file_type_short_desc) like upper('"+file_type_short_desc+"%') ");
				 andCheck = 1;
			 }
		 }
		 if(!(enabled == null || enabled.equals("")))
		 {
			 if(enabled.equals("E"))
			  {
				  if(andCheck == 0)
				  {
					  sql.append(" where eff_status='E' ");
					  andCheck = 1; 
				  }
				  else
				  sql.append(" and eff_status='E' ");
			   }
			   if (enabled.equals("D"))
			   {
				   if(andCheck == 0 )
				   {
					   sql.append(" where eff_status='D' ");
					   andCheck = 1; 
			        }
			        else
				      sql.append(" and eff_status='D' ");
		        }
		   }
		   String ord[] = request.getParameterValues("orderbycolumns");
		   if(!(ord == null || ord .equals("")))
		   {
					sql.append(" order by ");

					for(int i=0;i < ord.length;i++)
			 		{
						if(i == ord.length - 1)
						{
							sql.append(ord[i]);
						}
						else
						{
							sql.append(ord[i]);
							sql.append(" , ");
						}
					}
				}			
		   }
		   else
		   {
			   sql.append(whereClause);
		   }
		   int start = 0;
		   int end	 = 0;
		   int i	 = 1;
		   if(from == null)
				start = 1;
			else
				start = Integer.parseInt(from);
			if (to == null)
	  			end = 14;
			else
				end = Integer.parseInt(to);

			Connection conn			= null;
			java.sql.Statement stmt	= null;
			ResultSet rset			= null;
			ResultSet rs			= null;

//			int maxRecord	= 0;

			try
			{
				conn = ConnectionManager.getConnection(request) ;
				stmt = conn.createStatement();
		
				/*strsql1.append(" select count(*) as total from FM_FILE_TYPE_FOR_FSL_VW  ");
				strsql1.append(sql);
				rs			   = stmt.executeQuery(strsql1.toString());
				rs.next();
				maxRecord = rs.getInt("total");
				if(rs	!= null) rs.close();
				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));parent.frames[1].location.href ='../../eFM/jsp/FMFileTypeforFSLocnCriteria.jsp';</script>");
				}
				else
				{*/
					strsql2.append(" select  FS_LOCN_CODE, FS_LOCN_SHORT_DESC,EFF_STATUS,FILE_TYPE_CODE,FILE_TYPE_SHORT_DESC from FM_FILE_TYPE_FOR_FSL_VW  ");
					strsql2.append(sql);
							
					rs = stmt.executeQuery(strsql2.toString());

            _bw.write(_wl_block6Bytes, _wl_block6);

						if ( start != 1 )
						 for( int j=1; j<start; i++,j++ )
						 {
							rs.next() ;
						 }
						 String classValue = "" ;
						 int cnt=0;
						 while ( i<=end && rs.next())
						 {
							 if(cnt==0)
							 {
            _bw.write(_wl_block7Bytes, _wl_block7);

										if ( !(start <= 1) )
											out.println("<td align ='right' id='prev'><A HREF=\"../jsp/FMFileTypeforFSLocnQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
											
            _bw.write(_wl_block8Bytes, _wl_block8);

										//if ( !( (start+14) > maxRecord ) )
											out.println("<A HREF=\"../jsp/FMFileTypeforFSLocnQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"\""+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
							 }
							 if ( i % 2 == 0 )
								 classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;
							
							String fs_locn_code1		= rs.getString("FS_LOCN_CODE");
							String fs_locn_short_desc1  = rs.getString("FS_LOCN_SHORT_DESC");
							String effstatus			= rs.getString("EFF_STATUS");
							String file_type_code1		= rs.getString("FILE_TYPE_CODE");
							String file_type_short_desc = rs.getString("FILE_TYPE_SHORT_DESC");
							
						
							out.println("<tr><td class='" + classValue + "'>");
							out.println(fs_locn_code1+"</td><td class='" + classValue + "'>");
							out.println(fs_locn_short_desc1+"</td><td class='" + classValue + "'>");
							out.println(file_type_code1+"</td><td  class='" + classValue + "'>");
							out.println(file_type_short_desc+"</td><td align='center' class='" + classValue + "'>");
							if(effstatus.equals("E")) 
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
						
            _bw.write(_wl_block12Bytes, _wl_block12);
 flag = true;
								} else {
            _bw.write(_wl_block13Bytes, _wl_block13);
}
				//	}//endwhile

					if((sql != null) && (sql.length() >0))
					{
						sql.delete(0,sql.length());
					}
					if((strsql1 != null) && (strsql1.length() >0))
					{
						strsql1.delete(0,strsql1.length());
					}
					if((strsql2 != null) && (strsql2.length() >0))
					{
						strsql2.delete(0,strsql2.length());
					}

					if(rs	!= null) rs.close();
					if(rset	!= null) rset.close();
					if(stmt	!= null) stmt.close();
				}
				catch(Exception e)
				{
					out.println(e.toString());
				}
				finally
				{
					ConnectionManager.returnConnection(conn,request); 
				}

            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileStorageLocation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileStorageLocationDesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filetype.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileTypeDescription.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
