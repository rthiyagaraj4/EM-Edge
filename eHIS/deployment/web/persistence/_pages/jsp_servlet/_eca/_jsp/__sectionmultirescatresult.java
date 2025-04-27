package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __sectionmultirescatresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SectionMultiResCatResult.jsp", 1709116304401L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <!-- <modifeid by Arvind @06-12-2008> -->\n\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n        <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script src=\'../../eCA/js/Section.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title></title>\n\t\t<base target=\"_self\"></base>\n\t\t</head>\n\t\t<body  class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onload=\'FocusFirstElement()\' onKeyDown=\"lockKey()\">\n\t\t<form name=\"MultiResCatDet_form\" id=\"MultiResCatDet_form\" action=\"../../servlet/eCA.SectionServlet\" method=\"post\" target=\"messageFrame\">\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<table class=\'grid\' border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr><td class=\'columnheader\' colspan=4>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td></tr>\n\t<tr>\n\t<td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'columnheadercenter\'  width=\'\' nowrap >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\n\t</tr>\n   ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\n\t\t\t<tr><td class=\'gridData\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><td class=\'gridData\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><td class=\'gridData\'><input type=\'checkbox\' name =\'select\' value =\'\' onClick=\"removeRec(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\" checked ></td></tr>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t</table>\n\t<input type=hidden value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' name=\'sec_hdg_code\'>\n\t<input type=hidden value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' name=\'locale\'>\n\t<input type=hidden value=\'\' name=\'reslnk_rec_type\' id=\'reslnk_rec_type\'>\n\t<input type=hidden value=\'\' name=\'main_type\' id=\'main_type\'>\n\t<input type=hidden value=\'\' name=\'sub_type\' id=\'sub_type\'>\n\t<input type=hidden value=\'\' name=\'mode\' id=\'mode\'>\n\t</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	String facility_id		=	(String) session.getValue("facility_id");
	String sec_hdg_code=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	int		rowCnt					=	0 ;
	String reslnk_rec_type = "";
	String main_type = "";
	String main_type_desc = "";
	String sub_type = "";
	String sub_type_desc = "";
	String classValue = "";
	String reslnk_rec_type_prev = "";
	//String str_qry = "";
	String rec_type_desc = "";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs   = null;
		ResultSet rs1   = null;
		
		//String details_qry ="select sr.RESULT_LINKED_REC_TYPE,si.SHORT_DESC REC_TYPE_DESC,sr.MAIN_TYPE,sr.SUB_TYPE from CA_SECTION_RESULT_CAT  sr,CR_HIST_REC_TYPE si where sr.RESULT_LINKED_REC_TYPE = si.HIST_REC_TYPE and sr.SEC_HDG_CODE= ? and sr.ADDED_FACILITY_ID= ? order by 1 ";
		String details_qry ="select sr.RESULT_LINKED_REC_TYPE,si.SHORT_DESC REC_TYPE_DESC,sr.MAIN_TYPE,case when sr.RESULT_LINKED_REC_TYPE in ('CLNT') then ca_get_desc.CA_NOTE_GROUP(sr.MAIN_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('RXIN','DIET','LBIN','MEDN','RDIN','PTCR','SUNT','TRET') then or_get_desc.OR_ORDER_type(sr.MAIN_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('ALGY') then mr_get_desc.MR_ADV_EVENT_TYPE(sr.MAIN_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('DIAG') then sr.MAIN_TYPE when sr.RESULT_LINKED_REC_TYPE in ('BLTF','NBDT') then 'ALL' end main_desc, sr.SUB_TYPE, case when sr.RESULT_LINKED_REC_TYPE in ('CLNT') then ca_get_desc.CA_NOTE_TYPE(sr.SUB_TYPE,?,1)  when sr.RESULT_LINKED_REC_TYPE in ('RXIN','DIET','LBIN','MEDN','RDIN','PTCR','SUNT','TRET') then or_get_desc.OR_ORDER_CATALOG (sr.SUB_TYPE,?,1) when sr.RESULT_LINKED_REC_TYPE in ('ALGY','BLTF','FEVT','NBDT') then 'ALL' when sr.SUB_TYPE in ('ALL') then 'ALL' end sub_desc from CA_SECTION_RESULT_CAT  sr,CR_HIST_REC_TYPE si where sr.RESULT_LINKED_REC_TYPE = si.HIST_REC_TYPE and sr.SEC_HDG_CODE= ? and sr.ADDED_FACILITY_ID= ? order by 1 ";
		try
		{

			con = ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(details_qry);
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale);
			stmt.setString(6,sec_hdg_code);
			stmt.setString(7,facility_id);
			rs = stmt.executeQuery();
			

			

	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		while(rs.next())
			{
			rowCnt++;

			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
			
			
			
			reslnk_rec_type	= rs.getString("RESULT_LINKED_REC_TYPE")==null?"":rs.getString("RESULT_LINKED_REC_TYPE");
			main_type		= rs.getString("MAIN_TYPE")==null?"":rs.getString("MAIN_TYPE");
			sub_type		= rs.getString("SUB_TYPE")==null?"":rs.getString("SUB_TYPE");
			rec_type_desc		= rs.getString("REC_TYPE_DESC")==null?"":rs.getString("REC_TYPE_DESC");
			main_type_desc		= rs.getString("main_desc")==null?"":rs.getString("main_desc");
			sub_type_desc		= rs.getString("sub_desc")==null?"":rs.getString("sub_desc");

			if(reslnk_rec_type.equals("DIAG"))
			{
			if(sub_type.equals("A"))
				{
					sub_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				}
			else if(sub_type.equals("D"))
				{
					sub_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				}
			else if(sub_type.equals("I"))
				{
					sub_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				}
			}
			if(reslnk_rec_type.equals("FEVT"))
			{
			if(main_type.equals("FR"))
				{
					main_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FutureReferrals.label","ca_labels");
				}
			else if(main_type.equals("FA"))
				{
					main_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FutureAppointments.label","ca_labels");
				}
			else if(main_type.equals("FO"))
				{
					main_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FutureOrders.label","ca_labels");
				}
			}

			
			if(main_type.equals("ALL"))
				{
					main_type_desc ="ALL";
				}

			if(sub_type.equals("ALL"))
				{
					sub_type_desc ="ALL";
				}

			/*else if (reslnk_rec_type.equals("RXIN")||reslnk_rec_type.equals("DIET")||reslnk_rec_type.equals("LBIN")||reslnk_rec_type.equals("MEDN")||reslnk_rec_type.equals("RDIN")||reslnk_rec_type.equals("PTCR")||reslnk_rec_type.equals("SUNT")||reslnk_rec_type.equals("TRET"))
			{
			
			str_qry = "select oc.SHORT_DESC description,or_get_desc.OR_ORDER_CATEGORY(oc.ORDER_CATEGORY,?,1) order_categ_desc from OR_ORDER_CATALOG_LANG_VW oc where ORDER_CATALOG_CODE= ? and oc.LANGUAGE_ID =?";

			stmt1 = con.prepareStatement(str_qry);
			stmt1.setString(1,locale);
			stmt1.setString(2,sub_type);
			stmt1.setString(3,locale);
			rs1 = stmt.executeQuery();

			while(rs.next())
			{
				main_type_desc		= rs.getString("order_categ_desc")==null?"":rs.getString("order_categ_desc");
				sub_type_desc		= rs.getString("description")==null?"":rs.getString("description");

			}


//end
			} */

			
			//out.println("<option value='"+hist_rec_type+"'>"+short_desc+"</option>" );	
			//out.println("<tr><td class=><td></tr>" );	
			if(!reslnk_rec_type.equals(reslnk_rec_type_prev))
			{
			out.println("<tr><td class='CAGROUP' colspan='7'><font size=1>"+rec_type_desc+"</font></td></tr>");
			}
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(main_type_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_type_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(reslnk_rec_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(main_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sub_type));
            _bw.write(_wl_block17Bytes, _wl_block17);

		 reslnk_rec_type_prev = reslnk_rec_type ;
		
		}
		if(rs1 != null) rs1.close();
		if(stmt1 != null)stmt1.close();	
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();



		}
		catch(Exception e)
		{

		}
		finally
		{

			if(con!=null)
			ConnectionManager.returnConnection(con, request);
		}
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResultCategory.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DeSelect.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
