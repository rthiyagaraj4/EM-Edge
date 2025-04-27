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
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __caexternalappldtlresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAExternalApplDtlResult.jsp", 1709115517216L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!-- <modifeid by Archana  @08-12-2008> -->\n        \n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t\t<!-- <link rel=\'stylesheet\' type =\'text/css\'  href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\n<form name=\'CAExternalApplDtlResultForm\' id=\'CAExternalApplDtlResultForm\'>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'right\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table class=\'grid\' width=\'100%\' align=\'center\' >\n\t\t\t\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</table>\n\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");	
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con			=	null ;
		
		String whereClause		=	"";
		String mode		=	"";
		
		String ext_image_appl_id = "";
		String order_category = "";
		String order_type_code = "";
		String order_catalog_code = "";
		String eff_status = "";
		String ext_image_appl_name = "";
		String or_order_category_desc = "";
		String order_type_desc = "";
		String order_catalog_desc = "";
		String facility_name = "";
		String facility_id = "";
		//Modified by Archana @10-12-2008
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
        int pageCnt = Integer.parseInt(MstQryPageCnt);

		StringBuffer strsql = new StringBuffer();
		StringBuffer sql = new StringBuffer();
		StringBuffer strsqll = new StringBuffer();

		PreparedStatement pstmt =null;
		PreparedStatement pstmt1 =null;
		int maxRecord =	 0;
		ResultSet rset=null;
		ResultSet rs = null;

		try	{
		mode="modify";
		whereClause= request.getParameter("whereclause");
		if(whereClause==null) whereClause="";

		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;

		ext_image_appl_id = request.getParameter("ext_image_appl_id")==null?"":request.getParameter("ext_image_appl_id");
		order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");
		order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		order_catalog_code = request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
		eff_status=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
		facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		
		if ((whereClause == null || whereClause.equals("null") || whereClause.equals("")))
		{
				int cnt=0;
				if(!(ext_image_appl_id == null || ext_image_appl_id.equals("null") || ext_image_appl_id.equals("")))
				{
					sql.append(" where upper(ext_image_appl_id) like upper('"+ext_image_appl_id+"%') ");
					cnt++;
				}
				
				if(!(order_category == null  || order_category.equals("null") || order_category.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(order_category) like upper('"+order_category+"%')");
					}
					else
					{
						sql.append(" where upper(order_category) like  upper('"+order_category+"%')");
						cnt = 1;
					}
				}
				
				if(!(order_type_code == null  || order_type_code.equals("null") || order_type_code.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(order_type_code) like upper('"+order_type_code+"%')");
					}
					else
					{
						sql.append(" where upper(order_type_code) like  upper('"+order_type_code+"%')");
						cnt = 1;
					}
				}

				if(!(facility_id == null  || facility_id.equals("null") || facility_id.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(facility_id) like upper('"+facility_id+"%')");
					}
					else
					{
						sql.append(" where upper(facility_id) like  upper('"+facility_id+"%')");
						cnt = 1;
					}
				}

				 if(!(order_catalog_code == null  || order_catalog_code.equals("null") || order_catalog_code.equals("")))
				{
					if(cnt>0)
					{
						sql.append("and upper(order_catalog_code) like upper('"+order_catalog_code+"%')");
					}
					else
					{
						sql.append(" where upper(order_catalog_code) like  upper('"+order_catalog_code+"%')");
						cnt = 1;
					}
				}

				if (!(eff_status == null || eff_status.equals("null") || eff_status.equals("")))
				{
					if( eff_status.equals("E"))
					{
						if(cnt>0)
						{
							sql.append(" and eff_status='Y'");
						}
						else
						{
							sql.append(" where eff_status='Y'");
						}
					}
					if (eff_status.equals("D"))
					{
						if(cnt>0)
						{
							sql.append(" and eff_status='N'");
						}	
						else
						{
							sql.append(" where  eff_status='N'");
						}
					}
				}
			
			String ord[] = request.getParameterValues("orderbycolumns");
				if (!(ord == null  || ord .equals("null") || ord .equals("")))
				{
					sql.append(" order by ");
					for ( int i=0;i < ord.length;i++ )
					{
						if ( i == ord.length - 1 )
						{
							sql.append(ord[i]);
						}
						else
						{
							sql.append(ord[i]+",");
						}
					}			
				}//if ord
			}// if of where clause
			else{
				sql = new StringBuffer();
				sql.append(whereClause);
			}
			int start = 0 ;
			int end = 0 ;
			int i=1;
			if (from == null)
				start = 1 ;
			else
				start = Integer.parseInt(from) ;
			
			if (to == null)
				 end =  pageCnt;
			else
				end = Integer.parseInt(to) ;	

			try
			{
				con  = ConnectionManager.getConnection();

				strsql.append("select count(*) as total from ca_ext_appl_detail ");
				strsql.append(sql.toString());

				
				pstmt = con.prepareStatement(strsql.toString());	
				rs = pstmt.executeQuery();
				rs.next();
				maxRecord = rs.getInt("total");
				
				if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}

				strsqll.append("SELECT (SELECT ext_image_appl_name FROM ca_ext_image_appl  WHERE eff_status = 'E'and ext_image_appl_id = a.ext_image_appl_id	) ext_image_appl_name ,(select SHORT_DESC from OR_ORDER_CATEGORY where order_category = a.order_category ) or_order_category_desc, (select SHORT_DESC from OR_ORDER_TYPE where EFF_STATUS='E' and order_type_code = a.order_type_code ) order_type_desc, (select SHORT_DESC from or_order_catalog where order_catalog_code = a.order_catalog_code )order_catalog_desc, a.eff_status,a.ext_image_appl_id,a.order_category,a.order_type_code,a.order_catalog_code,(select facility_name from sm_facility_param where  status='E' and facility_id = a.facility_id) facility_name ,a.facility_id FROM ca_ext_appl_detail a ");

				strsqll.append(sql.toString());

				pstmt1=con.prepareStatement(strsqll.toString());
				rset = pstmt1.executeQuery();
			}
			catch (Exception e)
			{
				//out.println("Exception in CAExternalApplDtlResult.jsp:"+e.getMessage());//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

							if ( !(start <= 1) )
								out.println("<A class='gridLink' HREF='../../eCA/jsp/CAExternalApplDtlResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'><fmt:message key='Common.previous.label' bundle='${common_labels}'/></A>");
							if ( !( (start+pageCnt) > maxRecord ) )
								out.println("<A class='gridLink' HREF='../../eCA/jsp/CAExternalApplDtlResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'><fmt:message key='Common.next.label' bundle='${common_labels}'/></A>");
							
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
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			
				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
						rset.next() ;
				String classValue= " ";
				while ( rset.next() && i<=end  )
				{
					/*if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;
                     */
                classValue = "gridData";
				
				ext_image_appl_id = rset.getString("ext_image_appl_id")==null?"":rset.getString("ext_image_appl_id");
				order_category      = rset.getString("order_category")==null?"":rset.getString("order_category");
				order_type_code   =  rset.getString("order_type_code")==null?"":rset.getString("order_type_code");
				order_catalog_code =  rset.getString("order_catalog_code")==null?"":rset.getString("order_catalog_code");
				eff_status =  rset.getString("eff_status")==null?"":rset.getString("eff_status");
				ext_image_appl_name = rset.getString("ext_image_appl_name")==null?"":rset.getString("ext_image_appl_name"); 
				or_order_category_desc = rset.getString("or_order_category_desc")==null?"":rset.getString("or_order_category_desc"); 
				order_type_desc = rset.getString("order_type_desc")==null?"*ALL":rset.getString("order_type_desc"); 
				order_catalog_desc  = rset.getString("order_catalog_desc")==null?"ALL":rset.getString("order_catalog_desc"); 				
				facility_name  = rset.getString("facility_name")==null?"ALL":rset.getString("facility_name"); 				
				facility_id  = rset.getString("facility_id")==null?"":rset.getString("facility_id"); 				
				
					out.println("<tr><td class='" + classValue + "'>");
					out.println("<a  class='gridLink' href='../../eCA/jsp/CAExternalApplDtlAddModify.jsp?mode="+mode+"&ext_image_appl_id="+ext_image_appl_id+"&order_category="+order_category+"&order_type_code="+order_type_code+"&order_catalog_code="+order_catalog_code+"&eff_status="+eff_status+"&order_type_desc="+order_type_desc+"&facility_name="+facility_name+"&facility_id="+facility_id+"&order_catalog_desc="+order_catalog_desc+"' target='f_query_add_mod' >");
					out.println(ext_image_appl_name+"</a></td>");
					out.println("<td class='" + classValue + "'>"+or_order_category_desc+"</td><td class='" + classValue + "'>"+order_type_desc+"</td>");
					out.println("<td class='" + classValue + "'>"+order_catalog_desc +"</td>");
					out.println("<td class='" + classValue + "'>"+facility_name +"</td>");
					out.println("<td class='" + classValue + "'>");

						if (eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
							out.println("</td></tr>");
					i++;
				}
				
            _bw.write(_wl_block12Bytes, _wl_block12);

		}//end of 1st try block
		catch (Exception e)
		{
			//out.println("Exception :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(rset!=null)rset.close();
			if(pstmt1!=null)pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderCategory.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityName.label", java.lang.String .class,"key"));
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
