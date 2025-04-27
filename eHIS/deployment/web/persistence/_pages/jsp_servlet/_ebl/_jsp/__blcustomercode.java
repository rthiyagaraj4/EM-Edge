package jsp_servlet._ebl._jsp;

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

public final class __blcustomercode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCustomerCode.jsp", 1741169038007L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	request.setCharacterEncoding("UTF-8");	

	String locale	= (String)session.getAttribute("LOCALE");
	
	try
	{
	 
	con	=	ConnectionManager.getConnection(request);	
	String cust_group_code="",cust_code="",short_name="";

	//unused variable, commented on 09/06/05
	String query_ref_source="",/*facility_id="",*/ slmt_ind="",adm_rec_flag="", strModuleId = "";

	cust_group_code	= 	request.getParameter("cust_group_code");
	slmt_ind		= 	request.getParameter("slmt_ind");
	adm_rec_flag	= 	request.getParameter("adm_rec_flag");
	strModuleId     =   request.getParameter("module_id");

	if(cust_group_code==null) cust_group_code="";
	cust_group_code=cust_group_code.trim();	

	if(slmt_ind==null) slmt_ind="";
	slmt_ind=slmt_ind.trim();	

	if(adm_rec_flag==null) adm_rec_flag="";
	adm_rec_flag=adm_rec_flag.trim();		

	if ( strModuleId == null ) strModuleId="";
	strModuleId = strModuleId.trim();
	

	out.println("<html><head>");

	/*
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");
	*/


	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<link rel='StyleSheet' href='../../eCommon/html/'"+sStyle+" type='text/css'/>");

//	out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>");	

	
		
	stmt = con.createStatement();	
	
		
	out.println("<script language='javascript'>");		

	if (slmt_ind.equals("X") && adm_rec_flag.equals("2"))	
	{		

		query_ref_source="select short_name, cust_code from ar_customer_lang_vw where language_id='"+locale+"' and nvl(patient_flag,'N') = 'Y' and nvl(pat_com_flag,'N') = 'N' and nvl(insurance_yn,'N') = 'Y' and  nvl(cust_group_code,'X') like nvl('"+cust_group_code+"','%') and status is null and  (('"+strModuleId+"' in ('OP','AE') and nvl(op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP') and nvl(ip_yn,'N') = 'Y') or '"+strModuleId+"' = 'MP') order by short_name";

	}

	else if (slmt_ind.equals("X") && adm_rec_flag.equals("1"))	
	{
		query_ref_source="select short_name, cust_code from ar_customer_lang_vw where language_id='"+locale+"' and nvl(patient_flag,'N') = 'Y' and nvl(pat_com_flag,'N') = 'N' and nvl(insurance_yn,'N') = 'N' and nvl(cust_group_code,'X') like nvl('"+cust_group_code+"','%') and status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP') and nvl(ip_yn,'N') = 'Y') or '"+strModuleId+"' = 'MP') order by short_name";
	}
			
	else
	{ 

		query_ref_source="select short_name, cust_code from ar_customer_lang_vw where language_id='"+locale+"' and nvl(patient_flag,'N') = 'Y' and nvl(pat_com_flag,'N') = 'Y' and nvl(cust_group_code,'X') like nvl('"+cust_group_code+"','%') and status is null and (('"+strModuleId+"' in ('OP','AE') and nvl(op_yn,'N') = 'Y') or ('"+strModuleId+"' in ('IP') and nvl(ip_yn,'N') = 'Y') or '"+strModuleId+"' = 'MP') order by short_name";
	
	}	
	
		//out.println("</head><body><br>Query : "+query_ref_source+"</body>");
			
		rs = stmt.executeQuery(query_ref_source);	

		
		out.println("var cust_code	= 'select';");
		out.println("var short_name	= '         ---- Select ----       ';");
		
		out.println("var opt=parent.frames[1].frames[0].document.createElement('OPTION'); ");
		if (cust_group_code.length() > 0) 
		{	out.println("opt.text	=	short_name; ");
			out.println("opt.value	=	cust_code; ");
	
			if (slmt_ind.equals("X") && adm_rec_flag.equals("2"))	
			{	out.println("parent.frames[1].frames[0].document.forms[0].cust_3.add(opt); ");
				out.println("parent.frames[1].frames[0].document.forms[0].cust_3.selectedIndex = 0;");
			}
			else if (slmt_ind.equals("X") && adm_rec_flag.equals("1"))	
			{	out.println("parent.frames[1].frames[0].document.forms[0].cust_2.add(opt); ");
				out.println("parent.frames[1].frames[0].document.forms[0].cust_2.selectedIndex = 0;");
			}
			else			
			{	

			out.println("parent.frames[1].frames[0].document.forms[0].cust_1.add(opt); ");
			out.println("parent.frames[1].frames[0].document.forms[0].cust_1.selectedIndex = 0;");
			}
		}
		while(rs.next())
			{
				
				cust_code	=	rs.getString("cust_code");
				short_name	=	rs.getString("short_name");

				out.println("var cust_code	= '"+cust_code+"';");
				out.println("var short_name	= '"+short_name+"';");

				out.println("var opt = parent.frames[1].frames[0].document.createElement('OPTION'); ");
				out.println("opt.text	=	short_name; ");
				out.println("opt.value	=	cust_code; ");
				if (slmt_ind.equals("X") && adm_rec_flag.equals("2"))	
				{out.println("parent.frames[1].frames[0].document.forms[0].cust_3.add(opt); ");}
				else if (slmt_ind.equals("X") && adm_rec_flag.equals("1"))	
				{out.println("parent.frames[1].frames[0].document.forms[0].cust_2.add(opt); ");}
				else
				{out.println("parent.frames[1].frames[0].document.forms[0].cust_1.add(opt); ");}

			} // end of while
			
			out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE'> </body></html>");
		} // end of try
		catch(Exception e)
		{
			out.println("</script></head><body CLASS='MESSAGE'>");
			out.println("Exception@1 : "+e);
			out.println("</body></html>");
		}
		finally
		{
			if (rs != null)   rs.close();
			if(stmt!=null)	stmt.close();
			ConnectionManager.returnConnection(con, request);
		}
		
		//out.println("</script></head><body CLASS='MESSAGE'> </body></html>");

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
