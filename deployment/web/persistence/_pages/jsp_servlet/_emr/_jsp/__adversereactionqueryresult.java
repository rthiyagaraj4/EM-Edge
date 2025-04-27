package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __adversereactionqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AdverseReactionQueryResult.jsp", 1709118873157L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!-- ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n <Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script> \n<script language=\'javascript\' src=\'../js/AdverseReaction.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</tr>\n\t\t</td>\n\t\t</table>\n\t\t<br><br>\n\t\t</P>\n\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t</td></tr>\n\t\t</table>\n\t\t<br>\n\t\t</BODY>\n\t\t</HTML>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	? "" : inputString;
		}

		private String checkForNull(String inputString, String defaultValue)
		{
			return (inputString==null)	? defaultValue : inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block8Bytes, _wl_block8);

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql		= new StringBuffer();
	String from				= request.getParameter( "from" ) ;
	String to				= request.getParameter( "to" ) ;
	String reaction_code	= request.getParameter("REACTION_CODE");
	String reac_desc		= request.getParameter("a.long_desc");
	String allergen_code	= request.getParameter("b.allergen_code");
	String allergen_desc	= request.getParameter("c.short_desc");
	String adv_event_desc1	= request.getParameter("ADV_EVENT_TYPE_IND_DESC");
	String adv_event_type_code	= request.getParameter("ADV_EVENT_TYPE_CODE");
	 
	String new_code			= "";
	String classValue		= "";


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql	= new StringBuffer();
		int andCheck = 0;

		if ( !(reaction_code == null || reaction_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(REACTION_CODE)  like  upper('"+reaction_code+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(REACTION_CODE)  like  upper('"+reaction_code+"%') ");
				andCheck = 1;
			}
		}

		if ( !(reac_desc == null || reac_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append(" upper(am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1))  like  upper('"+reac_desc+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1))  like  upper('"+reac_desc+"%') ");
				andCheck = 1;
			}
		}

		if ( !(allergen_code == null || allergen_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append(" upper(a.ALLERGEN_CODE)  like  upper('"+allergen_code+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(a.ALLERGEN_CODE)  like  upper('"+allergen_code+"%') ");
				andCheck = 1;
			}
		}

		if ( !(allergen_desc == null || allergen_desc.equals("")) )
		{
			if(adv_event_type_code.equals("DA"))
			{
				if ( andCheck == 1 )
				{	
					sql.append( " and ");
					sql.append(" upper(c.generic_name)  like  upper('"+allergen_desc+"%') ");
				}
				else
				{
					sql = new StringBuffer();
					sql.append(" and upper(c.generic_name)  like  upper('"+allergen_desc+"%') ");
					andCheck = 1;
				}
			}else
			{
				if ( andCheck == 1 )
				{	
					sql.append( " and ");
					sql.append(" upper(c.short_desc)  like  upper('"+allergen_desc+"%') ");
				}
				else
				{
					sql = new StringBuffer();
					sql.append(" and upper(c.short_desc)  like  upper('"+allergen_desc+"%') ");
					andCheck = 1;
				}
			}
		}	
			
		if ( !(adv_event_desc1 == null || adv_event_desc1.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append(" upper(d.ADV_EVENT_TYPE_IND)  like  upper('"+adv_event_desc1+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(d.ADV_EVENT_TYPE_IND)  like  upper('"+adv_event_desc1+"%') ");
				andCheck = 1;
			}
		}	


		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
			}
		}
	} //end of where clause IF
	else 
	{
		sql			= new StringBuffer();
		sql.append(whereClause);
	}

		int start	= 0 ;
		int end		= 0 ;
		int i		= 1;

		if ( from == null )
			start	= 1 ;
		else
			start	= Integer.parseInt( from ) ;

		if ( to == null )
			end		= 10 ;
		else
			end		= Integer.parseInt( to ) ;

		Connection conn		= null;
		Statement stmt		= null;
		ResultSet rs		= null;
		int maxRecord		= 0;
	try
	{
		conn				= ConnectionManager.getConnection(request);
		String strsql2		= "";

	
		 //strsql2="select * from (SELECT a.ADV_REAC_CODE REACTION_CODE, b.long_desc long_desc, b.short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.long_desc causitive_desc,d.ADV_EVENT_TYPE_IND_DESC ADV_EVENT_TYPE_IND_DESC  FROM  mr_adv_rea_cause_agent A, AM_reaction b, MR_ALLERGEN c, MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.ALLERGEN_CODE and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND UNION SELECT a.ADV_REAC_CODE REACTION_CODE, b.long_desc long_desc, b.short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.GENERIC_NAME causitive_desc,d.ADV_EVENT_TYPE_IND_DESC ADV_EVENT_TYPE_IND_DESC FROM  mr_adv_rea_cause_agent A, AM_reaction b, PH_GENERIC_NAME c,MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.GENERIC_ID and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND ) WHERE  eff_status='E' "+sql.toString();
		 /*Friday, February 11, 2011,SRR20056-SCF-6860 [IN:026456]*/
		if(adv_event_type_code.equals("DA"))
		{
			strsql2="SELECT a.ADV_REAC_CODE REACTION_CODE, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1) long_desc, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',2)short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.GENERIC_NAME causitive_desc,mr_get_desc.MR_ADV_EVENT_TYPE_ind(d.ADV_EVENT_TYPE_IND,'"+locale+"',1) ADV_EVENT_TYPE_IND_DESC FROM  mr_adv_rea_cause_agent A, AM_reaction b, PH_GENERIC_NAME_lang_vw c,MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.GENERIC_ID and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND and  a.eff_status='E' and a.ADV_REAC_CODE like ('%%') AND c.language_id = '"+locale+"' "+sql.toString();	
		}else
		{
			strsql2="SELECT a.ADV_REAC_CODE REACTION_CODE, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1) long_desc, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',2)short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.short_desc causitive_desc,mr_get_desc.MR_ADV_EVENT_TYPE_ind(d.ADV_EVENT_TYPE_IND,'"+locale+"',1) ADV_EVENT_TYPE_IND_DESC  FROM  mr_adv_rea_cause_agent A, AM_reaction b, MR_ALLERGEN_LANG_VW c, MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.ALLERGEN_CODE and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND and  a.eff_status='E' and a.ADV_REAC_CODE like ('%%') AND c.language_id = '"+locale+"' "+sql.toString();
		}
		 
		/*Friday, February 11, 2011,commented for SRR20056-SCF-6860 [IN:026456]*/
		//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(strsql2);
		
		/*Friday, February 11, 2011,commented for SRR20056-SCF-6860 [IN:026456]*/
		/*rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		*/

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;

			  }
		while ( rs.next() && i<=end )
		{
			if(maxRecord == 0){
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		if ( !(start <= 1) )
		{
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/AdverseReactionQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql.toString())+"&ADV_EVENT_TYPE_CODE="+adv_event_type_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		}
		//if ( !( (start+10) > maxRecord ) )
		//{
			out.println("<td align ='right' id='next' ><A HREF='../../eMR/jsp/AdverseReactionQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql.toString())+"&ADV_EVENT_TYPE_CODE="+adv_event_type_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		//}
			
            _bw.write(_wl_block10Bytes, _wl_block10);
 //if(maxRecord > 0){ 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			/*if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;

			  }*/

			//while ( rs.next() && i<=end )
			//{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				
				new_code = rs.getString("REACTION_CODE");

				out.println ( "<tr><td class='"+classValue+"'>");
				
            out.print( String.valueOf(new_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

				out.println("<td  class='"+classValue+"'>");
				out.println( rs.getString("long_desc") );
				out.println("</td><td  class='"+classValue+"'>");

				out.println( rs.getString("ALLERGEN_CODE") );
				out.println("</td><td  class='"+classValue+"'>");

				out.println( rs.getString("causitive_desc") );
				out.println("</td><td  class='"+classValue+"'>");

				out.println( rs.getString("ADV_EVENT_TYPE_IND_DESC") );
				out.println("</td><td  class='"+classValue+"' align=center>");

				//if ( rs.getString("eff_status").equals("E") )
				String eff_status		=(rs.getString("eff_status")==null)?"D":rs.getString("eff_status");
				if ( eff_status.equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

				i++;
				maxRecord ++;

			}//endwhile	
		
			
										
				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				boolean flag = false;
				if ( maxRecord < 10 || (!rs.next()) )
				{
					
            _bw.write(_wl_block15Bytes, _wl_block15);
 flag = true;
				}
				else
				{
            _bw.write(_wl_block16Bytes, _wl_block16);

				}	
					
            _bw.write(_wl_block17Bytes, _wl_block17);

	}catch(Exception e){
			out.println("Exception "+e.toString());
			e.printStackTrace();
	}
	finally{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(conn,request);
		}
	
	
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdverseReaction Code.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AllergenCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Allergendesc.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdverseEventTypeIndicator.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
