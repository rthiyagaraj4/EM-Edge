package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __textblockintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TextBlockIntermediate.jsp", 1709116402776L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\'../../eCA/js/TextBlock.js\' language=\'javascript\'></script>\n\t\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar returnArray;\n\t\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t var chkVal = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t//alert(chkVal);\n\tif (chkVal==\"Service\")\n\t{\n\t\tretArray = callFunction(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",getLabel(\"Common.service.label\",\'common\'),parent.f_query_add_mod.document.Textblock_form.service_desc)\n\t\t\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.service_desc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.service.value = retArray[0];\t\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.service_desc.value = \'\';\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.service.value = \'\';\t\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"Practitioner\")\n\t{\n\t\tretArray = callFunction(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",getLabel(\'Common.practitioner.label\',\'common\'),parent.f_query_add_mod.document.Textblock_form.practitioner_desc)\n\t\t\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.practitioner_desc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.practitioner.value = retArray[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.practitioner_desc.value =\'\';\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.practitioner.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\telse if (chkVal==\"NoteType\")\n\t{\n\t\tretArray = callFunction(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",getLabel(\"Common.NoteType.label\",\'common\'),parent.f_query_add_mod.document.Textblock_form.Note_Type_Desc)\n\t\t\t\n\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.Note_Type_Desc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.notetype.value = retArray[0];\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.Note_Type_Desc.value =\'\';\n\t\t\t\t\tparent.f_query_add_mod.document.Textblock_form.notetype.value = \'\';\n\t\t\t\t\tparent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n </body>\n</html>\n\n";
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
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String selFunVal="";
	//String Page="";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	//String p_facility_id="";
	String sql = "";
	int count =0;	
	try
	{		
		
			con = ConnectionManager.getConnection(request);
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			if(selFunVal.equals("Service"))
			{
			sql="SELECT service_code code, short_desc description FROM am_service where eff_status='E' and   upper(short_desc) like upper(?) order by 2";
			}
			else if(selFunVal.equals("Practitioner"))
			{
			sql="SELECT practitioner_id code, practitioner_name description FROM am_practitioner where eff_status='E' and   upper(practitioner_name) like upper(?) order by 2";
			}
			else if(selFunVal.equals("NoteType"))
			{
			sql="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type_desc) like upper(?) order by 2";
			}

			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("Service"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.Textblock_form.service_desc.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.Textblock_form.service.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("Practitioner"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.Textblock_form.practitioner_desc.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.Textblock_form.practitioner.value='"+rs.getString(1)+"' ");

					}
				}
				else if (selFunVal.equals("NoteType"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.Textblock_form.Note_Type_Desc.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.Textblock_form.notetype.value='"+rs.getString(1)+"' ");

					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
								
				if(selFunVal.equals("Service"))
				{
				sql="SELECT service_code code, short_desc description FROM am_service where eff_status='E' and upper(service_code) like upper(?) and  upper(short_desc) like upper(?) order by 2";
				}
				else if(selFunVal.equals("Practitioner"))
				{
				sql="SELECT practitioner_id code, practitioner_name description FROM am_practitioner where eff_status='E' and upper(practitioner_id) like upper(?) and  upper(practitioner_name) like upper(?) order by 2";
				}
				else if(selFunVal.equals("NoteType"))
				{
				sql="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) order by 2";
				}
				
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block13Bytes, _wl_block13);

		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in TextBlock intermediate  "+ee.toString());//COMMON-ICN-0181
                  ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
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
