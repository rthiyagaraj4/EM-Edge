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
import java.util.*;
import com.ehis.util.*;

public final class __quicklinksforrespupdatefilter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QuickLinksForRespUpdateFilter.jsp", 1735584347608L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \t\tDescription\n--------------------------------------------------------------------------------------------------------\n?            100            ?           \t\tcreated\n08/12/2011\t IN29865\t\tMenakaV\t \t\t\tCA>Quick Link for Filter>If All the Descriptions are un-checked\n\t\t\t\t\t\t\t\t\t\t\t\tin Customize Descriptions, all the Descriptions defined in Quick Link for Responsibility for the filter is not displayed.\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
	//Properties p = (Properties)session.getValue("jdbc");
	//String locale	= (String) p.getProperty("LOCALE");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;// IN29865
	String locale			= (String) p.getProperty("LOCALE");//IN29865
	String userId=((String) session.getValue("login_user")).trim();

	PreparedStatement stmt = null;
	ResultSet rs = null;
	Connection con = null;
	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
	try
	{
		con	= ConnectionManager.getConnection(request);
	
		String desc_id		= "";
		String short_desc	= "";
		String default_yn	= "";
		String default_yn_sel	= "";
		String ql_ref = "";
		String executable_name = "";
		//IN29865 Starts
		String sql = "";
		int Existance_Count = 0;
		String resp_id	= (String)session.getValue("responsibility_id");
		String login_user	= (String)session.getValue("login_user");
		
		//IN29865 Ends
		int default_count = 0;

		//String resp_id = (String) session.getValue("responsibility_id");
		StringBuffer sqlQuery	= new StringBuffer();
		
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script language='javascript'>");

		String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
		
		//sqlQuery.append("select a.quick_link_ref, a.quick_link_description, B.EXECUTABLE_NAME from sm_quick_link_list A, CA_OPTION B, SM_QUICK_LINK_RESPONSIBILITY C where A.eff_STATUS='E' AND A.option_id = ? AND B.OPTION_ID = A.OPTION_ID and a.quick_link_description = c.quick_link_description and c.RESP_ID = ? order by 2 ");
		/* IN29865 Starts
		sqlQuery.append("select a.quick_link_ref, a.quick_link_description, B.EXECUTABLE_NAME,c.DEFAULT_YN from sm_quick_link_list A, CA_OPTION B, SM_QUICK_LINK_FOR_USER C where A.eff_STATUS='E' AND A.option_id = ? AND B.OPTION_ID = A.OPTION_ID and a.quick_link_ref = c.quick_link_ref and a.FUNCTION_SPEC_YN ='Y' and c.APPL_USER_ID = ?  and c.LINK_TYPE ='F' order by 2 ");
		
		stmt = con.prepareStatement(sqlQuery.toString());
		stmt.setString(1,function_id);
		stmt.setString(2,userId);
		//stmt.setString(2,resp_id);
		rs = stmt.executeQuery();
		IN29865 Ends */
		// IN29865 Starts
		try{
		sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, sm_quick_link_list_lang_vw c  WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id =? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = ? AND c.eff_status = 'E' AND  c.language_id = ? AND c.function_spec_yn = 'Y'";

		stmt = con.prepareStatement(sql);
	
		stmt.setString(1,login_user);
		stmt.setString(2,resp_id);
		stmt.setString(3,function_id);
		stmt.setString(4,locale);
		rs = stmt.executeQuery();
		if(rs.next())
		{
			Existance_Count = rs.getInt("EXISTANCE_COUNT");
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();}
		catch(Exception e1)
		{
		//out.println("Except "+e1);//COMMON-ICN-0181
                 e1.printStackTrace();//COMMON-ICN-0181
		}
		
		sqlQuery.append("select a.quick_link_ref, C.quick_link_description, B.EXECUTABLE_NAME,A.DEFAULT_YN from ");
		if(Existance_Count>0)
			sqlQuery.append(" SM_QUICK_LINK_FOR_USER A ");
		else
			sqlQuery.append(" SM_QUICK_LINK_RESP A ");
		sqlQuery.append(", CA_OPTION B,sm_quick_link_list_lang_vw  C,sm_quick_link_resp d where  c.LANGUAGE_ID = '"+locale+"' and B.option_id = ? and c.FUNCTION_SPEC_YN ='Y' AND B.OPTION_ID  = A.OPTION_ID AND C.QUICK_LINK_REF=A.QUICK_LINK_REF AND C.eff_STATUS='E' AND  a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'F' AND");
		if(Existance_Count>0)
			sqlQuery.append(" A.APPL_USER_ID=?  ");
		else
			sqlQuery.append(" A.RESP_ID=?  ");
		sqlQuery.append(" and A.LINK_TYPE = 'F' order by 2 ");
		
		stmt = con.prepareStatement(sqlQuery.toString());
		stmt.setString(1,function_id);
		stmt.setString(2,resp_id);
		
		if(Existance_Count>0)
			stmt.setString(3,login_user);
		else
			stmt.setString(3,resp_id);
		rs = stmt.executeQuery();
		//IN29865 Ends
		out.println("var desc_id	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		if(function_id.equals("PREVIOUS_NOTES"))
		{
			out.println("var opt=parent.RecClinicalNotesPrevFilterCriteriaFrame.document.createElement('OPTION'); ");
		}else{
			out.println("var opt=parent.CommonToolbar.document.createElement('OPTION'); ");
		}
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	desc_id; ");
		if(function_id.equals("PREVIOUS_NOTES"))
		{ 
			out.println("parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.add(opt); ");
			out.println("parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.selectedIndex = 0;");
		}else{
			out.println("parent.CommonToolbar.filter.add(opt); ");
			out.println("parent.CommonToolbar.filter.selectedIndex = 0;");
		}	
		while(rs.next())
		{
			short_desc	=	rs.getString("QUICK_LINK_DESCRIPTION");
			ql_ref = rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
			executable_name = rs.getString("EXECUTABLE_NAME") == null ? "" : rs.getString("EXECUTABLE_NAME");
			desc_id = ql_ref + "|" + executable_name;
            default_yn	=	rs.getString("DEFAULT_YN")==null?"N":rs.getString("DEFAULT_YN");
			if(function_id.equals("PREVIOUS_NOTES"))
			{
				if(default_yn.equals("Y"))
				{
					default_count++;
					default_yn_sel ="selecetd";
					out.println("var queryString = parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value");
					if(executable_name.indexOf("?") != -1)
						out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"&'+queryString+'&pre_ql_ref="+ql_ref+"'");
					else
						out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"?'+queryString+'&pre_ql_ref="+ql_ref+"'");
				}
				else
				{
					default_yn_sel  ="";
				}
				out.println("var desc_id	=\""+desc_id+"\";");
				out.println("var short_desc	=\""+short_desc+"\";");
				out.println("var opt = parent.RecClinicalNotesPrevFilterCriteriaFrame.document.createElement('OPTION'); ");
				out.println("opt.text	=	short_desc; ");
				out.println("opt.value	=	desc_id; ");
				out.println("opt.selected = '"+default_yn_sel+"'");
				out.println("parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.filter.add(opt); ");
			
			}
			else
			{
				if(default_yn.equals("Y"))
				{
					default_count++;
					default_yn_sel ="selecetd";
					out.println("var queryString = parent.CommonToolbar.refForm.queryString.value");
					if(executable_name.indexOf("?") != -1)
						out.println("top.content.workAreaFrame.location.href='"+executable_name+"&'+queryString+'&ql_ref="+ql_ref+"'");
					else
						out.println("top.content.workAreaFrame.location.href='"+executable_name+"?'+queryString+'&ql_ref="+ql_ref+"'");
				}
				else
				{
					default_yn_sel  ="";
				}
			
				out.println("var desc_id	=\""+desc_id+"\";");
				out.println("var short_desc	=\""+short_desc+"\";");
				out.println("var opt = parent.CommonToolbar.document.createElement('OPTION'); ");
				out.println("opt.text	=	short_desc; ");
				out.println("opt.value	=	desc_id; ");
				out.println("opt.selected = '"+default_yn_sel+"'");
				out.println("parent.CommonToolbar.filter.add(opt); ");
			}
			
		} 
		if(default_count == 0)
		{
			if(function_id.equals("PREVIOUS_NOTES"))
			{
				if(executable_name.equals(""))
				executable_name = "../../eCA/jsp/RecClinicalNotesPrevNotesSearchCriteria.jsp";
			out.println("var queryString = parent.RecClinicalNotesPrevFilterCriteriaFrame.RecClinicalNotesPrevNotesFilterCriteriaForm.query_string.value");
			

			if(executable_name.indexOf("?") != -1)
			{
				out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"&default_yn=N&'+queryString");
			}
			else
			{
				out.println("parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.location.href='"+executable_name+"?default_yn=N&'+queryString");

			}
			}
			else
			{
			//The following block was added for ICN17687 starts here 
			if(executable_name.equals("")){
			String exec_query="select EXECUTABLE_NAME from ca_option where option_id=?";
			PreparedStatement exec_stmt = null;
			ResultSet exec_rs = null;
			exec_stmt = con.prepareStatement(exec_query);
			exec_stmt.setString(1,function_id);
			exec_rs = exec_stmt.executeQuery();
			while(exec_rs.next())
				executable_name=exec_rs.getString("EXECUTABLE_NAME");
			}
			//if(executable_name.equals(""))
				//executable_name = "../../eCA/jsp/FlowSheet.jsp";

			//ends here
			out.println("var queryString = parent.CommonToolbar.refForm.queryString.value");
			
			if(executable_name.indexOf("?") != -1)
			{
				out.println("top.content.workAreaFrame.location.href='"+executable_name+"&default_yn=N&'+queryString");
			}
			else
			{
				out.println("top.content.workAreaFrame.location.href='"+executable_name+"?default_yn=N&'+queryString");

			}
			
			}
		}

		out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
		
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></head><body CLASS='MESSAGE' onKeyDown='lockKey()'>");
		out.println("Exception@1 : "+e);
		out.println("</body></html>");
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
