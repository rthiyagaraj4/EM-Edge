package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.net.*;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesmedserviceresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesMedServiceResult.jsp", 1734666713861L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<!-- added by Kishore Kumar N on 09/12/2008  -->\n\t\n\t<!-- end here -->\n<html>\n\t<head>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n\t<script language=\'javascript\'>\n\tfunction retValue(code,desc)\n\t{\n\t\n\t\tdesc = escape(desc)\n\t\tvar retVal  = new Array();\n\t\tretVal[0] = code;\n\t\tretVal[1] = desc;\t\n\t\twindow.returnValue = retVal;\n\t\twindow.close();\n\t}\n\n\t</script>\n\t<body onKeyDown=\'lockKey()\'>\n\t\t<table width=\'100%\' class=\'grid\'>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'50%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'50%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errorMsg = alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n\t\t<script>\n\t\t\tparent.RecClinicalNotesMedServiceCriteriaFrame.document.RecClinicalNotesMedServiceCriteriaForm.Search.disabled = false;\n\t\t</script>\n\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String search_text = request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" );
	String search_criteria = request.getParameter( "search_criteria" )==null?"":request.getParameter( "search_criteria" );
	String radBtnVal = (request.getParameter( "radBtnVal" )==null?"":request.getParameter( "radBtnVal" ));
	String facility_id = (request.getParameter( "facility_id" )==null?"":request.getParameter( "facility_id" ));
	String ser_spc_yn = (request.getParameter( "ser_spc_yn" )==null?"":request.getParameter( "ser_spc_yn" ));
	String note_type = (request.getParameter( "note_type" )==null?"":request.getParameter( "note_type" ));

	String code = "";
	String desc = "";
	//String classvalue = "";
	String classvalue = "gridData";
	String WhereClause = "";
	StringBuffer sql = new StringBuffer();

	int rowCount = 0;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try
		{
			
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

			if(!search_text.equals(""))
			{
				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and upper( service_code ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause =WhereClause + " and upper( service_code ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause =WhereClause + " and upper(service_code) like upper('%" + search_text + "%')";
					}
					
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and  upper( short_desc ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause = WhereClause + " and upper(short_desc ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause = WhereClause + " and upper(short_desc ) like upper('%" + search_text + "%')";
					}
					
				}

			}
			else
			{
				if(radBtnVal.equals("C"))
				{
					WhereClause =WhereClause + " order by code";
				}
				else if(radBtnVal.equals("D"))
				{
					WhereClause =WhereClause + " order by short_desc";
				}
			}
		

			con = ConnectionManager.getConnection(request);

			//sql.append("select service_code code, replace(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'','')  short_desc from  AM_FACILITY_SERVICE_VW where nvl(eff_status,'E') ='E'  and operating_facility_id = ? ");
			sql.append("select a.service_code code, replace(a.short_desc ,'''','')  short_desc from  am_service_lang_vw a where nvl(a.eff_status,'E') ='E'  and a.LANGUAGE_ID=? and exists (select 1 from AM_FACILITY_SERVICE where  operating_facility_id = ? and SERVICE_CODE=a.SERVICE_CODE ) ");

			if(ser_spc_yn.equals("Y"))
			{
				sql.append(" and exists (select service_code from ca_note_type_by_serv where facility_id=? and note_type = ? and service_code=a.SERVICE_CODE)");
			}

			sql.append(WhereClause);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			
			if(ser_spc_yn.equals("Y"))
			{
				pstmt.setString(3,facility_id);
				pstmt.setString(4,note_type);
			}

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				/* if ( rowCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
	          else
					classvalue = "QRYODD" ;*/

				code = rs.getString("code");
				desc = rs.getString("short_desc");
				desc = desc.replaceAll("'","");
				out.println("<tr>");
				out.println("<td width='50%' class='"+classvalue+"'>");
				out.println("<a class='gridLink' href='javascript():' onclick='retValue(\""+code+"\",\""+desc+"\")'> "+code+" </a> </td>");
				out.println("<td width='50%' class='"+classvalue+"'>"+desc+"</td>");
				out.println("</tr>");

				rowCount++;
			
			}
			rs.close();
			pstmt.close();

			if(rowCount == 0)
			{
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
		}
		catch(Exception e)
		{
			out.println("code = "+code+"--------desc = "+desc);
			//out.println("Exception in RecClinicalNotesMedServiceResult.jsp at line---"+rowCount+"--"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
