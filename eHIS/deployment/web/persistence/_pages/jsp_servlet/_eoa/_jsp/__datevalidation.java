package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __datevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DateValidation.jsp", 1709119232178L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n\n";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");	

				String date = request.getParameter("date");
				String flag=request.getParameter("flag");
				String changed_date=request.getParameter("changed_date");
				String callingMode=request.getParameter("callingMode");
				String FrmNo=request.getParameter("FrmNo");

				Connection con = null;
				Statement stmt = null;
				PreparedStatement pstmt=null;
				ResultSet rs = null;
				ResultSet rs1=null;
				String wd1="";
				String wd2="";
				String wd3="";
				String sql="";
try
{

	con = ConnectionManager.getConnection(request);
				 stmt = con.createStatement();
		if(flag.equals("right")){

		//sql="SELECT replace(to_char(TO_DATE('"+date+"','Day,Month,dd,yyyy'),'Day,Month,dd,yyyy'),' ','') date_val ,to_char(to_date('"+changed_date+"','dd/mm/yyyy'),'dd/mm/yyyy')day1 from dual";
		sql="SELECT replace(to_char(TO_DATE(?,'Day,Month,dd,yyyy'),'Day,Month,dd,yyyy'),' ','') date_val ,to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy')day1 from dual";
}
		else

		if(flag.equals("left")){

		sql="SELECT replace(to_char(TO_DATE(?,'Day,Month,dd,yyyy'),'Day,Month,dd,yyyy'),' ','') date_val,to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy')day1 from dual";
}
		//rs = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,date);
		pstmt.setString(2,changed_date);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			wd1 = rs.getString("date_val");
			wd2=rs.getString("day1");
		}
		String sql2="select to_date('"+wd2+"', 'dd/mm/yyyy') - to_date(to_char(sysdate, 'dd/mm/yyyy'),'dd/mm/yyyy') dat_val2 from dual";
		rs1=stmt.executeQuery(sql2);
		rs1.next();
		wd3=rs1.getString("dat_val2");
		int check=Integer.parseInt(wd3);

		if(check >= 0 )
		{
			String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>";
			
			if(callingMode.equals("OP") || callingMode.equals("OR") || callingMode.equals("CA"))
			{	
				if(FrmNo.equals("1"))
				{
			
					a1=a1+"parent.document.frames[0].document.forms[0].gggg.value='"+wd1+"';	parent.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
			
				}else if(FrmNo.equals("2"))
				{
				   a1=a1+"parent.document.frames[1].document.frames[0].document.forms[0].gggg.value='"+wd1+"';	parent.document.frames[1].document.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";	
				}else if(FrmNo.equals("3"))
				{
					a1=a1+"parent.document.frames[1].document.frames[0].document.forms[0].gggg.value='"+wd1+"';	parent.document.frames[1].document.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";		
				}
			}else
			{			
			  a1=a1+"parent.frames[1].document.frames[1].document.frames[0].document.forms[0].gggg.value='"+wd1+"';		parent.frames[1].document.frames[1].document.frames[0].document.forms[0].changed_date.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";	
			}
				String a2="<html><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
				 out.println(a2);
		}else{

			String a1="<html><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
			out.println(a1);
			
		}
		
		
	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
	if (stmt != null) stmt.close();
}catch(Exception e) {
 //out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
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
