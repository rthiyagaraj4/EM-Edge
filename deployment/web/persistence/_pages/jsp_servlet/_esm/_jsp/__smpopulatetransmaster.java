package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __smpopulatetransmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/SMPopulateTransMaster.jsp", 1709121724572L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script>\n\t\t\t   parent.frames[1].document.forms[0].language_direction.value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t</script>\n\n\t\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<script> \n\t\t\tvar obj=parent.frames[1].document.forms[0].module_id;\n\t\t\tvar length = obj.length;\n\t\t\tfor(i=0;i<length;i++)\n\t\t\tobj.remove(1);\n\t\t\tvar obj1=parent.frames[1].document.forms[0].master_name;\n\t\t\tvar length1 = obj1.length;\n\t\t\tfor(i=0;i<length1;i++)\n\t\t\tobj1.remove(1);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t         opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt.text=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t     opt.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t parent.frames[1].document.forms[0].module_id.add(opt);\n\t\t\t\t\t \n\t\t\t\t \t\t\n                </script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script> \n\t\t\tvar obj=parent.frames[1].document.forms[0].master_name;\n\t\t\tvar length = obj.length;\n\t\t\tfor(i=0;i<length;i++)\n\t\t\tobj.remove(1);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t parent.frames[1].document.forms[0].master_name.add(opt);\n\t\t\t\t\t \n\t\t\t\t \t\t\n                </script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<script>\n\t\tvar obj=parent.frames[1].document.forms[0].report_id;\n\t</script>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<script>\n\t\t\topt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\topt.value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\tparent.frames[1].document.forms[0].report_id.add(opt);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	Connection con            = null;
	Statement stmt            = null;
	PreparedStatement  pstmt  = null;
	ResultSet rs              = null;
    StringBuffer sql          = new StringBuffer();
	String code               = "";
	String desc               = "";
	String code1              = "";
	String desc1              = "";
	String language_direction = "";
	String language           = request.getParameter("language")==null?"":request.getParameter("language");
	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");
	String module_id        = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String master_name        = request.getParameter("master_name")==null?"":request.getParameter("master_name");	
	try{
		    con = ConnectionManager.getConnection(request);
			sql.setLength(0);
			if(!master_name.equals("SM_RECORD_TRANS")){
			sql.append("select language_direction from sm_language where language_id= '"+language+"'" );
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if ( rs != null && rs.next() ) 
			{
				language_direction = rs.getString("language_direction");
			}
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();		   
			if ( language_direction      == null ) language_direction      = "" ;
		 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block5Bytes, _wl_block5);
	if(ModuleFlag.equals("Y"))
		    {
             try
               {
			  sql.setLength(0);
			  sql.append("select   module_id, module_name  from  sm_module ");
			  /*if(language_direction.equals("R"))
			    {
                  sql.append(" where module_id in ('MP', 'SM', 'OA','PH','AM') ");
				}*/ 
			  sql.append(" order by module_name ");
			  pstmt = con.prepareStatement(sql.toString());
			  rs = pstmt.executeQuery();
			
            _bw.write(_wl_block6Bytes, _wl_block6);
	
					while (rs.next())
					{			
						 code1 = rs.getString("module_id");	
						 if(code1==null) code1="";
				 
						 desc1 = rs.getString("module_name");
						 if(desc1==null) desc1="";
				 	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(desc1));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block9Bytes, _wl_block9);
	}
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
		     }catch(Exception e) { 
				 out.println("Main : "+e.toString());
				 e.printStackTrace();
				 }
			}
           else{
		    sql.setLength(0);
			// In below query TRANS_REQ_YN = 'Y'  is added for SRR20056-SCF-5111 [IN:023565] by suresh M on 24.11.2010

			if(master_code.equals("CA"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') and TRANS_REQ_YN = 'Y' order by table_desc");
				/*if(language_direction.equals("R"))
			    {
                  sql.append(" and MASTER_TABLE_ID IN ('OA_PARAM','PH_DRUG','PH_LABEL_TEXT','PH_ROUTE','AM_FREQUENCY')  ");
				}*/
				//sql.append("order by table_desc");
			}else if(master_code.equals("SM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') and TRANS_REQ_YN = 'Y' order by table_desc");
				/*if(language_direction.equals("R"))
			    {
                  sql.append(" and MASTER_TABLE_ID IN ('SM_SITE_PARAM', 'SM_MENU_HDR', 'SM_APPL_USER', 'MP_CONTACT_MODE', 'SM_RESP', 'SM_FUNCTION', 'MP_PARAM', 'MP_ALTERNATE_ID_TYPE', 'OA_PARAM', 'PH_DRUG','PH_LABEL_TEXT', 'PH_ROUTE', 'AM_FREQUENCY')  ");
				}*/
				//sql.append("order by table_desc");
			}else if(master_code.equals("MM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2) in ('MM','AP') and TRANS_REQ_YN = 'Y' order by table_desc ");
				//sql.append("order by table_desc");
			}else{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' and TRANS_REQ_YN = 'Y' order by table_desc");

				/*if(language_direction.equals("R"))
			    {
                  sql.append(" and MASTER_TABLE_ID IN ('SM_SITE_PARAM', 'SM_MENU_HDR', 'SM_APPL_USER', 'MP_CONTACT_MODE', 'SM_RESP', 'SM_FUNCTION', 'MP_PARAM', 'MP_ALTERNATE_ID_TYPE', 'OA_PARAM','PH_DRUG', 'PH_LABEL_TEXT', 'PH_ROUTE', 'AM_FREQUENCY') ");
				}*/
				//sql.append("order by table_desc");
			}
			 
			stmt= con.createStatement();
			rs = stmt.executeQuery(sql.toString()) ;
            _bw.write(_wl_block10Bytes, _wl_block10);
	
					while (rs.next())
					{			
						 code = rs.getString("master_table_id");	
						 if(code==null) code="";
				 
						 desc = rs.getString("table_desc");
						 if(desc==null) desc="";
				 	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
				
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();


				sql.setLength(0);

		   }
	}else{
            _bw.write(_wl_block12Bytes, _wl_block12);

		sql.append("select report_id,report_desc from sm_report where module_id='"+module_id+"' order by 2,1" );
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()){
			
			String report_id=rs.getString("report_id");
			String report_desc=rs.getString("report_desc");
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(report_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	}
		   
		   
		}catch(Exception e) { 
			e.printStackTrace();
			out.println("Main : "+e.toString());}
	finally
	{
		try{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
