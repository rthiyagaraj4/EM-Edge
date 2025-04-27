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

public final class __quicklinksforrespupdatedesc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QuickLinksForRespUpdateDesc.jsp", 1741317776321L ,"10.3.6.0","Asia/Calcutta")) return true;
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

/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
05/12/2011	  IN29822		 MenakaV	 For quick link & filter when Ist time resposibility is assigned 
										 its taking all links. After logging it shows only 2 responsibilty.

--------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/11/2016	IN062286		Raja S												GDOH-SCF-0217
----------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Properties p = (Properties)session.getValue("jdbc");
	//String locale	= (String) p.getProperty("LOCALE");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;//IN29822
	String locale					=	(String) p.getProperty("LOCALE");//IN29822
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
		String resp_id = (String) session.getValue("responsibility_id");
		StringBuffer sqlQuery	= new StringBuffer();
		StringBuffer sql = new StringBuffer();//IN29822
		int Existance_Count = 0;//IN29822
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
		//String reln_id				= (String)session.getValue("relationship_id");
		String reln_id				= request.getParameter("relationship_id");
		String facilityId			= (String)session.getValue("facility_id");
		if(resp_id == null) resp_id = "";
		if(reln_id == null) reln_id = "";
		
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<script language='javascript'>");
		
		//IN29822 Starts
		sql.append("SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b,        sm_quick_link_list_lang_vw c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'Q' AND c.eff_status = 'E' AND c.language_id = ? AND c.global_yn = 'Y' AND DECODE (c.QUICK_LINK_TYPE,'EX','Y',NVL((SELECT 'Y' FROM CA_OPTION WHERE OPTION_ID = C.OPTION_ID ");
						
						if(patient_id.equals(""))
							sql.append(" AND DESKTOP_YN = 'Y' ");
						else
							sql.append(" AND DESKTOP_YN = 'N' ");
						sql.append("),'N')) = 'Y'"); 

						stmt = con.prepareStatement(sql.toString());
	
						stmt.setString(1,userId);
						stmt.setString(2,resp_id);
						stmt.setString(3,locale);
						rs = stmt.executeQuery();
						if(rs.next())
						{
							Existance_Count = rs.getInt("EXISTANCE_COUNT");
						}
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
		//IN29822 Ends
		
		//sqlQuery.append("select quick_link_ref, a.QUICK_LINK_TYPE, a.quick_link_description, NVL(A.EXTERNAL_URL_APPL, B.EXECUTABLE_NAME) EXECUTABLE_NAME from sm_quick_link_list A, CA_OPTION B, SM_QUICK_LINK_RESP C where A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND B.OPTION_ID(+)=A.OPTION_ID AND NVL(A.EXTERNAL_URL_APPL, B.EXECUTABLE_NAME)  IS NOT NULL  and a.quick_link_description = c.quick_link_description and c.RESP_ID = ? order by 2 ");
		//IN29822 Starts
		//sqlQuery.append("select a.quick_link_ref, a.QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID, B.EXECUTABLE_NAME EXECUTABLE_NAME from sm_quick_link_list A, CA_OPTION B, SM_QUICK_LINK_FOR_USER C where A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND B.OPTION_ID(+)=A.OPTION_ID AND B.EXECUTABLE_NAME IS NOT NULL  and a.quick_link_ref = c.quick_link_ref and c.APPL_USER_ID = ?  and c.LINK_TYPE ='Q' ");
		
		sqlQuery.append("select DISTINCT a.quick_link_ref, a.QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID, B.EXECUTABLE_NAME EXECUTABLE_NAME from sm_quick_link_list A, CA_OPTION B,SM_QUICK_LINK_RESP d,");
		if(Existance_Count>0)
			sqlQuery.append(" SM_QUICK_LINK_FOR_USER C where c.APPL_USER_ID = ?");  
		else
			sqlQuery.append(" SM_QUICK_LINK_RESP C where c.RESP_ID = ?");
		
		sqlQuery.append(" and A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND B.OPTION_ID(+)=A.OPTION_ID AND B.EXECUTABLE_NAME IS NOT NULL  and a.quick_link_ref = d.quick_link_ref and a.quick_link_ref = c.quick_link_ref and d.RESP_ID = ? AND d.link_type = 'Q' and c.LINK_TYPE ='Q'");
		//IN29822 ends
		if(patient_id.equals(""))
		{
			sqlQuery.append(" and B.DESKTOP_YN = 'Y' ");
		}
		else
		{
			sqlQuery.append(" and B.DESKTOP_YN = 'N' ");
			 if(mode.equals("V"))
				sqlQuery.append(" and b.HIST_OR_RECORD = 'H' ");
			if(patient_class.equals(""))
				patient_class = "XT";
			sqlQuery.append(" and b.APPL_"+patient_class+"_YN = 'Y' ");
		}
		
		sqlQuery.append(" and exists (select 1 from ca_appl_task ia where OPTION_ID = a.OPTION_ID and  GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) = 'A' and (ia.BASE_MODULE_ID = 'CA' or exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
					
		if(!patient_id.equals(""))
			sqlQuery.append(" and ( MODULE_GROUP_ID!='SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");

		sqlQuery.append(" ))) ");

		/*Added by Jyothi to fix IN018443, Reason: Selected External Application quick links are not displaying */
		//IN29822 Starts
		//sqlQuery.append(" UNION ALL SELECT DISTINCT a.quick_link_ref, a.quick_link_type, a.quick_link_description, '' option_id,        A.EXTERNAL_URL_APPL FROM sm_quick_link_list a, sm_quick_link_for_user c WHERE a.eff_status = 'E' AND a.global_yn = 'Y' AND c.appl_user_id = ? AND c.link_type = 'Q' AND a.quick_link_ref = c.quick_link_ref AND a.external_url_appl IS NOT NULL AND quick_link_type = 'EX' ");
		sqlQuery.append(" UNION ALL SELECT DISTINCT a.quick_link_ref, a.quick_link_type, a.quick_link_description, '' option_id,        A.EXTERNAL_URL_APPL FROM sm_quick_link_list a,SM_QUICK_LINK_RESP d,"); 
		
		if(Existance_Count>0)
			sqlQuery.append(" SM_QUICK_LINK_FOR_USER C where c.APPL_USER_ID = ?");  
		else
			sqlQuery.append(" SM_QUICK_LINK_RESP C where c.RESP_ID = ?");
		
		sqlQuery.append(" and A.eff_STATUS='E' AND A.GLOBAL_YN='Y' and a.quick_link_ref = d.quick_link_ref and a.quick_link_ref = c.quick_link_ref and d.RESP_ID = ? and c.LINK_TYPE ='Q' AND a.external_url_appl IS NOT NULL AND quick_link_type = 'EX'");
		//IN29822 ends
		/*End: IN018433*/

		sqlQuery.append(" order by 2 ");
			
		//added by Jyothi to fix IN018443
		int indval = 1;
		//End
		
		stmt = con.prepareStatement(sqlQuery.toString());
		//IN29822 Starts
		if(Existance_Count>0)
		{
			stmt.setString(indval++,userId);
		}
		else
		{
			stmt.setString(indval++,resp_id);
		}
			
		//stmt.setString(indval++,userId);
		stmt.setString(indval++,resp_id);
		//IN29822 Ends
		stmt.setString(indval++,resp_id);
		stmt.setString(indval++,reln_id);
		stmt.setString(indval++,facilityId);
		stmt.setString(indval++,episode_id);
		stmt.setString(indval++,patient_id);
		if(!patient_id.equals(""))
		{
			stmt.setString(indval++,speciality_code);
		}
		//added by Jyothi to fix IN018443
		//IN29822 Starts
		//stmt.setString(indval++,userId);
		if(Existance_Count>0)
		{
			stmt.setString(indval++,userId);
		}
		else
		{
			stmt.setString(indval++,resp_id);
		}
		stmt.setString(indval++,resp_id);//IN29822 Ends
		//End
		
		rs = stmt.executeQuery();
		
		out.println("var desc_id	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		out.println("var opt=parent.CommonToolbar.document.createElement('OPTION'); ");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	desc_id; ");
		out.println("parent.CommonToolbar.quick_links.add(opt); ");
		out.println("parent.CommonToolbar.quick_links.selectedIndex = 0;");
		
		while(rs.next())
		{
			
			short_desc	=	rs.getString("QUICK_LINK_DESCRIPTION");
			//desc_id = rs.getString("OPTION_ID") + "|" + rs.getString("QUICK_LINK_TYPE") + "|"+ rs.getString("quick_link_description") + "|" + rs.getString("EXECUTABLE_NAME"); //Commented for IN062286
			desc_id = rs.getString("OPTION_ID") + "|" + rs.getString("QUICK_LINK_TYPE") + "|"+ rs.getString("quick_link_description") + "|" + rs.getString("EXECUTABLE_NAME") + "|" + rs.getString("QUICK_LINK_REF"); //IN062286
			out.println("var desc_id	=\""+desc_id+"\";");
			out.println("var short_desc	=\""+short_desc+"\";");
			out.println("var opt = parent.CommonToolbar.document.createElement('OPTION'); ");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	desc_id; ");
			out.println("parent.CommonToolbar.quick_links.add(opt); ");
		} // end of while
		
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onKeyDown='lockKey()' CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
	
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'>");
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		out.println("</body></html>");
		e.printStackTrace();//COMMON-ICN-0181
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
