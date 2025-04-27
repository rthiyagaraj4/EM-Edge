package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import eCommon.XSSRequestWrapper;

public final class __onlinereports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/OnlineReports.jsp", 1724414439363L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar tp =\"-----Select-----\";\n\t\t\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n                            opt.text=tp;\n                            opt.value=\"\";\n\n                        parent.f_query_add_mod.document.forms[0].visit_type.add(opt);\n                    </script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n                    <script>\n                        var scode=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n                        var temp = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n                        var temp1=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n                        var opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n                        opt.text=temp1;\n                        opt.value=temp;\n                        if (scode==temp)\n                            opt.selected=true;\n                        parent.f_query_add_mod.document.forms[0].visit_type.add(opt);\n                    </script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar temp =\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\t\t\t\tvar opt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt1.text=temp1;\n\t\t\t\t\t\t\t\t\t//opt1.value=temp;\n\t\t\t\t\t\t\t\t\t// Below line added for incident IN017226 by Muthu on 15/12/2009\n\t\t\t\t\t\t\t\t\topt1.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="::";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].report_desc.add(opt1);\n\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].report.value =  \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\t\t</script>\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\t\t\t\tvar opt1=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\topt1.text=temp1;\n\t\t\t\t\t\t\t\t\topt1.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].report_desc.add(opt1);\n\t\t\t\t\t\t\t\t</script>\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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




            request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			Connection con					=	null;
            PreparedStatement pstmt			=	null;
            ResultSet rset					=	null;
			StringBuffer sqlReport			=	null;
            String visitcode="";
            String visitdesc="";
            String common=request.getParameter("Common_Text");
            String scode = request.getParameter("Service_code");
            String facilityId=(String)session.getValue("facility_id");
            String chksrc=request.getParameter("Chksrc");
			String online_mr_notfn_yn = "";
			String moduleId   =	"";
			String reportId   =	"";
            String reportDesc =	"";
			
			int count2 =0;


	        String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            if(scode!=null)
				scode=scode.trim();

			if(chksrc.trim().equals("visit_type"))
			{

			/* The following sql query is used to fetch the visit types from the database table op_visit_type_for_clinic_vw for the corresponding facility and clinic --- Srijagadeesh.*/	

				String sql = "select '*A' visit_type_code,'*All' visit_type_short_desc from dual union select visit_type_code, visit_type_short_desc  from op_visit_type_for_clinic_vw where facility_id='"+facilityId+"' and clinic_code =nvl('"+common.trim()+"',clinic_code)" ;
            try
			{
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
                rset     = pstmt.executeQuery();

                out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey();'><form name='nam1' id='nam1'>");
                
				if(rset != null)
                {

            _bw.write(_wl_block1Bytes, _wl_block1);

                    while( rset.next() )
                    {
                        visitcode=rset.getString("visit_type_code");
                        visitdesc=rset.getString("visit_type_short_desc");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(scode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(visitcode));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block5Bytes, _wl_block5);

	                }
                }

                if(common.equals("*All")){

				sqlReport   = new StringBuffer();				
				String sql1 = "SELECT SUM (DECODE (online_mr_notfn_yn, 'N', 0, 'Y', 1)) b   FROM op_clinic  WHERE facility_id ='"+facilityId+"' AND eff_status = 'E' AND level_of_care_ind = 'E' ";

				pstmt = con.prepareStatement(sql1);
				rset     = pstmt.executeQuery();

					if(rset!= null &&  rset.next() ){					   
			            count2 =rset.getInt("b");
					}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();

					sqlReport.append("select report_desc,report_id,module_id from  sm_report where module_id in ('AE' ,'MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM', 'OPBQTKNO','MPBIRCER','MPDTHCER','OPRNTFMR','OPBMEDCR','OPRFLETR','OPRVSLBL','MPSTBCER','MPBSTLBL','MPBPTLBL') ");

					if (count2 >= 1)
                    {
					  sqlReport.append(" UNION SELECT   report_desc, report_id, module_id FROM sm_report  WHERE module_id = 'FM' AND internal_request_yn = 'Y'  AND report_id ='FMFLRQSL' ");
					}
					sqlReport.append("order by report_desc ");

					pstmt = con.prepareStatement(sqlReport.toString());
					rset     = pstmt.executeQuery();

					if(rset!=null)
						{
							while(rset.next())
							{
								moduleId  = rset.getString("module_id");
								reportId  =	rset.getString("report_id");
								reportDesc=	rset.getString("report_desc");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(reportId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(reportDesc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(reportId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reportId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block11Bytes, _wl_block11);
					   }
						}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();
					if((sqlReport != null) && (sqlReport.length() > 0))
					  {
						sqlReport.delete(0,sqlReport.length());
					  } 
				}
				else 
				{
					String sql1 = "SELECT ONLINE_MR_NOTFN_YN FROM op_clinic where facility_id='"+facilityId+"'  and clinic_code ='"+common.trim()+"' " ;
					sqlReport   = new StringBuffer();

					pstmt = con.prepareStatement(sql1);
					rset     = pstmt.executeQuery();
					if(rset!= null &&  rset.next() ){
					   online_mr_notfn_yn = rset.getString("ONLINE_MR_NOTFN_YN");
					}
					if (rset != null)   rset.close();
					if (pstmt != null) pstmt.close();

					sqlReport.append("select report_desc,report_id,module_id from  sm_report where module_id in ('AE' ,'MP','OP') and internal_request_yn='Y' and report_id not in ('MPBNBFRM', 'OPBQTKNO','MPBIRCER','MPDTHCER','OPRNTFMR','OPBMEDCR','OPRFLETR','OPRVSLBL','MPSTBCER','MPBSTLBL','MPBPTLBL') ");


					if(online_mr_notfn_yn.equals("Y"))
					{
					  sqlReport.append(" UNION SELECT   report_desc, report_id, module_id FROM sm_report  WHERE module_id = 'FM' AND internal_request_yn = 'Y'  AND report_id ='FMFLRQSL' ");
					}
					sqlReport.append("order by report_desc ");


					pstmt = con.prepareStatement(sqlReport.toString());
					rset     = pstmt.executeQuery();

					if(rset!=null)
						{
							while(rset.next())
							{
								moduleId  = rset.getString("module_id");
								reportId =rset.getString("report_id");
								reportDesc=rset.getString("report_desc");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(reportId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(reportDesc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(reportId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block13Bytes, _wl_block13);
					   }
						}
					if((sqlReport != null) && (sqlReport.length() > 0))
					  {
						sqlReport.delete(0,sqlReport.length());
					  } 
				}
				if (rset != null)   rset.close();
                if (pstmt != null) pstmt.close();
            }catch(Exception e) {e.printStackTrace();}
            finally 
			{
              if (pstmt != null) pstmt.close();
              if (rset != null)   rset.close();
				ConnectionManager.returnConnection(con,request); 
            }

            out.println("</form></body></html>");
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
}
