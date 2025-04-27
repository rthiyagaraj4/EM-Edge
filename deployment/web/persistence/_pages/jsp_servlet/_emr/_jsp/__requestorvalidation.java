package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __requestorvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RequestorValidation.jsp", 1709119088535L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body class=\'message\' onKeyDown=\'lockKey()\'>         \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\nparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n</script>\n</head>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

		request.setCharacterEncoding("UTF-8");
		String pr_id = request.getParameter("process_id");
		if (pr_id==null||pr_id.equals("null"))
			pr_id="";
		ResultSet rs=null;
		PreparedStatement stmt=null;
		int process = 0;
		if (!pr_id.equals(""))
			process = Integer.parseInt(pr_id);
		Connection con = ConnectionManager.getConnection(request);
        try
        {

// FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
        if ( process == 7 )
        {
        String postal_code = request.getParameter("r_postal");
		if (postal_code==null) postal_code ="";
		String res_area_code = request.getParameter("r_area");
		if (res_area_code==null) res_area_code ="";
		String region_code = request.getParameter("r_region");
		if (region_code==null) region_code ="";
		String res_town_code = request.getParameter("r_town");
		if (res_town_code==null) res_town_code ="";
		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
		
		String sql = "";
		
		if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
	   }
       else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
	   }
	   else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
	   }
	  else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
		}
		//Defaulting area, town, region based on selection.	
        if (!postal_code.equals(""))
		{
			String town_code="";
			
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code a, mp_res_town b where a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{

				town_code = rs.getString(2);
				if (town_code==null) town_code="";
				out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" !=null) parent.frames[1].document.forms[0]."+fieldName+".value='"+town_code+"';");

				out.println("parent.frames[1].document.forms[0]."+fieldName5+".value='"+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"'; </script>");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area a, mp_region b where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code" ;
				if ( stmt != null ) stmt.close();
				if ( rs != null ) rs.close();

				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next())
				{
				out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName1+" != null) parent.frames[1].document.forms[0]."+fieldName1+".value='"+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"';");
				 
				 out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" !=null) parent.frames[1].document.forms[0]."+fieldName2+".value='"+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='"+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='"+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"';</script>");
				}
			}
		}
		if (!res_town_code.equals(""))
		{
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area a, mp_region b where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code ";

			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
			     out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" != null) parent.frames[1].document.forms[0]."+fieldName+".value='"+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"';");
				 
				 out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" !=null) parent.frames[1].document.forms[0]."+fieldName2+".value='"+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='"+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='"+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"';</script>");
			}	
			sql="select postal_code from mp_postal_code where res_town_code = '"+res_town_code+"'";

			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
				out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName1+" !=null) parent.frames[1].document.forms[0]."+fieldName1+".value = '"+(rs.getString("postal_code")==null ? "" : rs.getString("postal_code"))+"'</script>");

			}
			else{
			out.println("<script>parent.frames[1].document.forms[0]."+fieldName1+".value=''</script>");
			}
	}
		if (!res_area_code.equals(""))
		{
			sql = "select region_code,long_desc from mp_region where region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
			out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" !=null) parent.frames[1].document.forms[0]."+fieldName+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName1+" !=null) parent.frames[1].document.forms[0]."+fieldName1+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" !=null) parent.frames[1].document.forms[0]."+fieldName2+".value='"+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"';");
			out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='';");	out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='"+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"';</script>");
			stmt.close();
				
			}
			else
			{
			out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" ) parent.frames[1].document.forms[0]."+fieldName+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName1+") parent.frames[1].document.forms[0]."+fieldName1+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" ) parent.frames[1].document.forms[0]."+fieldName2+".value='';");
			out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='';");
			out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='';</script>");
			}
			out.println("<script>parent.frames[1].document.forms[0]."+fieldName1+".focus();</script>");
			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
		}
		if (!region_code.equals(""))
		{
				
		out.println("<script>if(parent.frames[1].document.forms[0]."+fieldName+" ) parent.frames[1].document.forms[0]."+fieldName+".value='';");
		out.println("if (parent.frames[1].document.forms[0]."+fieldName2+") parent.frames[1].document.forms[0]."+fieldName2+".value='';");
		out.println("if (parent.frames[1].document.forms[0]."+fieldName1+") parent.frames[1].document.forms[0]."+fieldName1+".value='';");
		out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='';");
        out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='';</script>");
	    out.println("<script>parent.frames[1].document.forms[0]."+fieldName2+".focus();</script>");
		
		}        
    }
 }
    catch(Exception e){/* out.println("tst "+e); */e.printStackTrace();}
    finally
    {
        ConnectionManager.returnConnection(con,request);
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
