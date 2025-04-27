package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __getvaluser extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/GetValUser.jsp", 1709121704885L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<SCRIPT LANGUAGE=\"JavaScript\">\n<!--\n//-->\n</SCRIPT>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<html><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link><script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script></HEAD><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'testform\' id=\'testform\'>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar p = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t\t\tvar d = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\t\tif (d ==p)\n\t\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].pract_type.add(element);\n\n\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar p = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\t\tvar d = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\t\t\tif (d ==p)\n\t\t\t\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].pract_type.add(element);\n\n\t\t\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\t\t\tif (p ==d)\n\t\t\t\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].pract_name.add(element);\n\n\t\t\t\t\t\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
	String roletype		= request.getParameter("role_type");
	String practtype = request.getParameter("pract_type");
	String practname = request.getParameter("pract_name");
	int count_am_practitioner_type=0;
	int count_am_practitioner=0;
	//String practitioner_type = request.getParameter("type_practitioner");
	
//	Connection con 	 = (Connection) session.getValue("connection");
	Connection con 	 = null;
	try{
	con = ConnectionManager.getConnection(request);


	Statement stmt=null;
	ResultSet rs = null;
	StringBuffer sql=new StringBuffer();
	String dat="";
	String id="";
	String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


	try{
	
	if (!(roletype.equals("") || roletype == null))
		{			
			if (roletype.equals("P"))
            {
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select count(1) from all_tables where table_name='AM_PRACT_TYPE' ");
			}
			else if (roletype.equals("O"))
			{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select count(1) from am_other_staff_type");
			}
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql.toString()) ;

			if (rs != null)
			{
				while(rs.next())
				{
					count_am_practitioner_type=rs.getInt(1);
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			if(count_am_practitioner_type>0){			
	//END		
			if (practtype.equals("") || practtype==null)
			{
            if (roletype.equals("P"))
            {
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select PRACT_TYPE, DESC_USERDEF from am_pract_type where eff_status = 'E' and sysdate >= nvl(eff_date_from,sysdate) and sysdate <=  nvl(eff_date_to,sysdate) ORDER BY 2");
			if (( practtype!=null) && (!practtype.equals("")) )
			sql.append("   and PRACT_TYPE='"+practtype+"'");
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql.toString()) ;

			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("DESC_USERDEF");
					id=rs.getString("PRACT_TYPE");
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(id));
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
		  }//end of role type pract
		  else if (roletype.equals("O"))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select OTHER_STAFF_TYPE, SHORT_DESC from am_other_staff_type where eff_status = 'E' ORDER BY 2");
					if (( practtype!=null) && (!practtype.equals("")) )
					sql.append("   and OTHER_STAFF_TYPE='"+practtype+"'");
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql.toString()) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("SHORT_DESC");
							id=rs.getString("OTHER_STAFF_TYPE");
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practtype));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
					}
				}//end of role type otherstaff
		}//end of pract type
	}//new
}
if (!(practname.equals("") || practname == null)){
if (!(practtype.equals("") || practtype == null))
		{
		
           if (roletype.equals("P"))
            {
			   if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select count(1) from all_tables where table_name='AM_PRACTITIONER'");
			}
			else if (roletype.equals("O"))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select count(1) from AM_OTHER_STAFF");
			}
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql.toString()) ;
			if (rs != null)
			{
				while(rs.next())
				{
					count_am_practitioner=rs.getInt(1);
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}
			
			if(count_am_practitioner>0){	
            if (roletype.equals("P"))
            { 
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select practitioner_id, SHORT_NAME from am_practitioner where PRACT_TYPE ='"+practtype+"'  and eff_status = 'E' and sysdate >= nvl(eff_date_from,sysdate) and sysdate <=  nvl(eff_date_to,sysdate) ");
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql.toString()) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("SHORT_NAME");
							id=rs.getString("practitioner_id");

				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
					  }
			}//end of role type pract
			else if (roletype.equals("O"))
			{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select OTHER_STAFF_ID, OTHER_STAFF_NAME from AM_OTHER_STAFF where  OTHER_STAFF_TYPE='='"+practtype+"'' and eff_status='E'");
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql.toString()) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("OTHER_STAFF_NAME");
							id=rs.getString("OTHER_STAFF_ID");

				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
						}
			}//end of role type other staff
}//NEW ADDED BY P.SUDHAKARAN end count
}//end
}
	if(rs != null) rs.close();
	if(stmt != null)stmt.close();	
}
catch(Exception e)
{
	out.print(e);
}
sql.setLength(0) ;
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
