package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __constructexistinguserdesktopmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/ConstructExistingUserDesktopMenu.jsp", 1709121696307L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<html>\n <head>\n </head>\n\t<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t//parent.frameAddModifyCreateUserDesktopResult.document.forms[0].mode.value = \"UPDATE\";\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n</script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		int counter=0;
		StringBuffer menutreesql = new StringBuffer();
		String main_menu_id = "";
		String desktop_chart ="";

		String option_desc = "",option_type="",prev_option_desc = "";
		String option_desc1 = "";
		String option_value ="";
		String header_option_id = "";
		String option_tot_value = "";
		String pre_header_option_id = "";
		//String header_option_desc = "";

		String spc="         ";
		String option_text="";
		int level_no = 1;

		desktop_chart = request.getParameter("desktop_chart")==null?"":request.getParameter("desktop_chart");
		main_menu_id = request.getParameter("main_menu_id")==null?"":request.getParameter("main_menu_id");

		if(menutreesql.length() > 0) menutreesql.delete(0,menutreesql.length());
		
		/*menutreesql.append("select DISTINCT LEVEL as LVL_NO, ");
		menutreesql.append("a.option_id as option_id,");
		menutreesql.append(" a.option_occurance, ");
		menutreesql.append("a.header_option_id as header_option_id,");
		menutreesql.append("a.HEADER_OPTION_OCCURANCE, a.ORDER_SEQ_NO ");
		menutreesql.append("as ORDER_SEQ_NO, nvl((select ");
		menutreesql.append("nvl(USER_DEF_SHORT_DESC,SHORT_DESC)");
		menutreesql.append("||DECODE(OPTION_TYPE,'F',");
		menutreesql.append("'('||HIST_OR_RECORD||')') from ");
		menutreesql.append("ca_option where option_id=a.option_id)");
		menutreesql.append(",(select SHORT_DESC from ca_menu_header ");
		menutreesql.append("where menu_id=a.option_id)) ");
		menutreesql.append("option_desc,nvl((select option_type ");
		menutreesql.append("from ca_option where option_id = ");
		menutreesql.append("a.option_id),'M') option_type from ");
		menutreesql.append("ca_menu_detail a Where desktop_chart= ? ");
		menutreesql.append("and menu_id= ?  start with menu_id= ? and ");
		menutreesql.append("a.HEADER_OPTION_ID = ? and HEADER_OPTION_OCCURANCE=1 and desktop_chart= ? ");
		menutreesql.append("connect by prior ");
		menutreesql.append("a.OPTION_ID=a.HEADER_OPTION_ID and ");
		menutreesql.append("a.OPTION_OCCURANCE = ");
		menutreesql.append("a.HEADER_OPTION_OCCURANCE order by ");
		menutreesql.append("ORDER_SEQ_No"); */

		//menutreesql.append("select 1 as LVL_NO, t.SUMMARY_COMP_ID as option_id ,t.HDR_SUMMARY_COMP_ID as header_option_id ,(select summary_comp_desc from sm_desktop_sum_comp r where r.SUMMARY_COMP_ID = t.HDR_SUMMARY_COMP_ID ) as desc1, t.ORDER_SEQ as ORDER_SEQ_NO,s.SUMMARY_COMP_TYPE,SUMMARY_COMP_DESC option_desc from SM_DESKTOP_SUM_DTL t,SM_DESKTOP_SUM_COMP s where t.DESKTOP_SUMMARY_ID =? and trim(t.SUMMARY_COMP_ID) = s.SUMMARY_COMP_ID order by t.ORDER_SEQ");
		
		
		//menutreesql.append("select DISTINCT LEVEL as LVL_NO,t.summary_comp_id as option_id,	 SUMMARY_COMP_OCC_NUM option_occurance,t.hdr_summary_comp_id as header_option_id,	HDR_SUMMARY_COMP_OCC_NUM HEADER_OPTION_OCCURANCE, ORDER_SEQ as ORDER_SEQ_NO , 		nvl((select nvl(USER_DEF_SHORT_DESC,SHORT_DESC)	||DECODE(OPTION_TYPE,'F','('||HIST_OR_RECORD||')') from ca_option where option_id=t.summary_comp_id),(select SHORT_DESC from ca_menu_header where menu_id=t.summary_comp_id)) option_desc,nvl((select option_type from ca_option where option_id = t.summary_comp_id),'M') option_type from sm_desktop_sum_dtl t Where t.desktop_summary_id = 'HDMENU' start with  t.desktop_summary_id = 'HDMENU' and hdr_summary_comp_occ_num=1 connect by prior t.summary_comp_id= t.hdr_summary_comp_id and SUMMARY_COMP_OCC_NUM = HDR_SUMMARY_COMP_OCC_NUM  order by ORDER_SEQ");
		//menutreesql.append("select DISTINCT LEVEL as LVL_NO,a.option_id as option_id, a.option_occurance, a.header_option_id as header_option_id,	a.HEADER_OPTION_OCCURANCE, a.ORDER_SEQ_NO 	as ORDER_SEQ_NO, nvl((select nvl(USER_DEF_SHORT_DESC,SHORT_DESC)		||DECODE(OPTION_TYPE,'F',	'('||HIST_OR_RECORD||')') from 	ca_option where option_id=a.option_id)	,(select SHORT_DESC from ca_menu_header 	where menu_id=a.option_id)) option_desc,nvl((select option_type 	from ca_option where option_id = a.option_id),'M') option_type  from	ca_menu_detail a Where desktop_chart= 'P' and menu_id= 'SH1'  start with menu_id= 'SH1' and a.HEADER_OPTION_ID = 'SH1' and HEADER_OPTION_OCCURANCE=1   and desktop_chart= 'P' connect by prior	a.OPTION_ID=a.HEADER_OPTION_ID and 	a.OPTION_OCCURANCE = a.HEADER_OPTION_OCCURANCE order by ORDER_SEQ_No");

		menutreesql.append("SELECT DISTINCT LEVEL AS lvl_no,t.summary_comp_id AS option_id, summary_comp_occ_num option_occurance,t.hdr_summary_comp_id AS header_option_id,hdr_summary_comp_occ_num header_option_occurance,                order_seq AS order_seq_no,(select summary_comp_desc from sm_desktop_sum_comp r where r.SUMMARY_COMP_ID = t.SUMMARY_COMP_ID ) as option_desc, (select decode(SUMMARY_COMP_TYPE,'T','M','S','F') from sm_desktop_sum_comp r where r.SUMMARY_COMP_ID = t.SUMMARY_COMP_ID) option_type   FROM sm_desktop_sum_dtl t   WHERE t.desktop_summary_id = ? START WITH t.desktop_summary_id = ? and t.hdr_summary_comp_id=?  AND hdr_summary_comp_occ_num = 1 CONNECT BY PRIOR t.summary_comp_id = t.hdr_summary_comp_id /* AND summary_comp_occ_num = hdr_summary_comp_occ_num */ ORDER BY order_seq");


		try
		{
		
			con = ConnectionManager.getConnection(request);
		
			pstmt = con.prepareStatement(menutreesql.toString());

			pstmt.setString(1,main_menu_id);
			pstmt.setString(2,main_menu_id);
			pstmt.setString(3,main_menu_id);
			/*pstmt.setString(2,main_menu_id);
			pstmt.setString(3,main_menu_id);
			pstmt.setString(4,main_menu_id);
			pstmt.setString(5,desktop_chart); */
		
			rs = pstmt.executeQuery();
			
			out.println("<script>");
				
			
			while(rs.next())
			{
				counter++;

				option_type = rs.getString("option_type");
				if(option_type == null)
					option_type = "";

				option_desc = rs.getString("option_desc");
				
				
				
				
				if(option_desc == null)
					option_desc = "";
				

				
				level_no = rs.getInt("LVL_NO");

				if(option_desc.equals(prev_option_desc) && level_no != 1)
					continue;
				
				prev_option_desc = new String(option_desc);
				
				header_option_id = rs.getString("header_option_id");
				if(header_option_id == null)
					header_option_id = "";

				option_value = rs.getString("option_id");

				if(option_value == null)
					option_value = "";
		
				if(level_no == 1)
				{
				
					option_desc1 =option_desc;
					option_tot_value = option_value+"#1#";
					
				}
				else if(level_no == 2)
				{
					option_desc1 = spc+option_desc;
					option_tot_value = option_value+"#2#"; 
				}
				else if(level_no == 3)
				{
				
				option_desc1 = spc+spc+option_desc;			
				option_tot_value = option_value+"#3#";

				}
				else if(level_no == 4)
				{
					
					option_desc1 = spc+spc+spc+option_desc;
					option_tot_value = option_value+"#4#";

				}
				else if(level_no == 5)
				{
					
					option_desc1 = spc+spc+spc+spc+option_desc;
					option_tot_value = option_value+"#5#";

				}
		
				option_text = option_tot_value+option_type;
		
				//option_text = option_tot_value+option_type;
				//option_text = option_tot_value;

				

				out.println("var opt = parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement('OPTION');");
				out.println("opt.text = '"+option_desc1+"';");
				out.println("opt.value =' "+option_text+"';");

				if(option_type.equals("M") )
				{
					out.println("opt.style.color='RED'");
				}
				else
				{
						out.println("opt.style.color='BLACK'");
				}
			
				//out.println("parent.construct_ca_menu.document.forms[0].MainMenus.add(opt);");	
				out.println("parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.forms[0].MainMenus.add(opt);");	
			pre_header_option_id = header_option_id;
			}
			out.println("</script>");

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
	}

	catch(Exception e)
	{
		out.println("Exception While Getting Exisitng Menu: "+e);
		e.printStackTrace(System.out);
	}

	finally
	{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
if(counter > 0){
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
