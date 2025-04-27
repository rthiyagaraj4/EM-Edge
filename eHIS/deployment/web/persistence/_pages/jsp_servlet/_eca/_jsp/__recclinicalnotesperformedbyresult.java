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

public final class __recclinicalnotesperformedbyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesPerformedByResult.jsp", 1709116178841L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<html>\n\t<head>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n\t<script>\n\tfunction retValue(code,desc)\n\t{\n\t\tdesc = escape(desc)\n\t\tvar retVal  = new Array();\n\t\tretVal[0] = code;\n\t\t//IN040045 starts\n\t\t//retVal[1] = desc;\t\n\t\tretVal[1] = decodeURIComponent(desc);\t\n\t\t//IN040045 ends\n\t\twindow.returnValue = retVal;\n\t\twindow.close();\n\t}\n\n\t</script>\n\t<body onKeyDown=\'lockKey()\'>\n\t<table class=\"grid\" width=\'100%\'  align=center>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheader\' width=\'50%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'columnheader\' width=\'50%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errorMsg = alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n\t\t<script>\n\t\t\tparent.RecClinicalNotesPerformedByCriteriaFrame.document.RecClinicalNotesPerformedByCriteriaForm.Search.disabled = false;\n\t\t</script>\n\n</body>\n</html>\n\n\n\n";
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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?			100				?           		?			?			created
21/01/2014	IN040045		Vijayakumar K	22/01/2014	Dinesh T		CA Transactions --> Patient Chart --> Record Clinical Notes while
																		associating the ?Performed By?, the application is generating  a script error on load of the ?Performed By? modal window.

---------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String loggedUser	= (String) session.getValue("login_user");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String search_text = request.getParameter( "search_text" )==null?"":request.getParameter( "search_text" );
	String search_criteria = request.getParameter( "search_criteria" )==null?"":request.getParameter( "search_criteria" );
	String radBtnVal = (request.getParameter( "radBtnVal" )==null?"":request.getParameter( "radBtnVal" ));
	String note_type = (request.getParameter( "note_type" )==null?"":request.getParameter( "note_type" ));
	//String mode = (request.getParameter( "mode" )==null?"":request.getParameter( "mode" ));

	String code = "";
	String desc = "";
	String classvalue = "";
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

		/*	if(!search_text.equals(""))
			{
				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and upper( phys_prov_id ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause =WhereClause + " and upper( phys_prov_id ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause =WhereClause + " and upper(phys_prov_id) like upper('%" + search_text + "%')";
					}
					
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and  upper( phys_prov_name ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause = WhereClause + " and upper(phys_prov_name ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause = WhereClause + " and upper(phys_prov_name ) like upper('%" + search_text + "%')";
					}
					
				}

			}
			else
			{
				if(radBtnVal.equals("C"))
				{
					WhereClause =WhereClause + " order by phys_prov_id";
				}
				else if(radBtnVal.equals("D"))
				{
					WhereClause =WhereClause + " order by phys_prov_name";
				}
			}
		

			con = ConnectionManager.getConnection(request);

			sql.append("select practitioner_id phys_prov_id, replace(short_name,'','') phys_prov_name from am_practitioner where EFF_STATUS='E' and practitioner_id in (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ?  and b.privilege_type in ('2','3','4') and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id) "); */

			if(!search_text.equals(""))
			{
				if(radBtnVal.equals("C"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and upper( practitioner_id ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause =WhereClause + " and upper( practitioner_id ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause =WhereClause + " and upper(practitioner_id) like upper('%" + search_text + "%')";
					}
					
				}
				else if(radBtnVal.equals("D"))
				{
					if(search_criteria.equals("S"))
					{
						WhereClause =WhereClause + "and  upper( practitioner_name ) like  upper('" + search_text + "%')";
					}
					else if(search_criteria.equals("E"))
					{
						WhereClause = WhereClause + " and upper(practitioner_name ) like upper('%" + search_text + "')";
					}
					else if(search_criteria.equals("C"))
					{
						WhereClause = WhereClause + " and upper(practitioner_name ) like upper('%" + search_text + "%')";
					}
					
				}

			}
		/*	else
			{*/
				if(radBtnVal.equals("C"))
				{
					WhereClause =WhereClause + " order by phys_prov_id";
				}
				else if(radBtnVal.equals("D"))
				{
					WhereClause =WhereClause + " order by phys_prov_name";
				}
			//}
		

			con = ConnectionManager.getConnection(request);

			//if (mode.equals("PR")){
				sql.append("select oa.practitioner_id phys_prov_id, replace(oa.practitioner_name,'','') phys_prov_name from am_practitioner_lang_vw oa  where oa.EFF_STATUS='E' and oa.language_id = ? and exists (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ?  and b.privilege_type in ('2','3','4') and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id and a.appl_user_id NOT IN (?) and a.func_role_id=oa.practitioner_id) ");
			//}else{
			//sql.append("select practitioner_id phys_prov_id, replace(short_name,'','') phys_prov_name from am_practitioner_lang_vw  where EFF_STATUS='E' and language_id = ? and practitioner_id in (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ?  and b.privilege_type in ('2','3','4') and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id) ");
			//}

			sql.append(WhereClause);

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,note_type);
			//if (mode.equals("PR"))
			pstmt.setString(3,loggedUser);

			rs = pstmt.executeQuery();
			/** Modified by kishore kumar N on 19-12-2008 for CRF 0387, applied GRID CSS*/
			classvalue = "gridData";
			while(rs.next())
			{
				/* if ( rowCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
	          else
					classvalue = "QRYODD" ;*/
					/** ends here*/

				code = rs.getString("phys_prov_id");
				desc = rs.getString("phys_prov_name");
				desc = desc.replaceAll("'","");
				desc =  java.net.URLEncoder.encode(desc,"UTF-8");//IN040045
				out.println("<tr>");
				out.println("<td width='50%' class='"+classvalue+"'>");
				out.println("<a class='gridLink' href='javascript():' onclick='retValue(\""+code+"\",\""+desc+"\")'> "+code+" </a> </td>");
				//IN040045 starts
				//out.println("<td width='50%' class='"+classvalue+"'>"+desc+"</td>");
				out.println("<td width='50%' class='"+classvalue+"'>"+java.net.URLDecoder.decode(desc,"UTF-8")+"</td>");
				//IN040045 ends
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
			//out.println("code = "+code+"--------desc = "+desc);
		//	out.println("Exception in RecClinicalNotesPerformedByResult.jsp at line---"+rowCount+"--"+e.toString());//COMMON-ICN-0181
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
