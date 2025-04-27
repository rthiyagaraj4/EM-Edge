package jsp_servlet._eop._jsp;

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

public final class __resourcetypefetchval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ResourceTypeFetchVal.jsp", 1715253140149L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n          <html><HEAD>\n\t\t<!-- \t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t\t\t</HEAD>\n\t\t<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey();\'><form name=\'nam1\' id=\'nam1\'>\n         \n\t\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tvar temp=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp;\n\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tvar comp=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\tcomp.add(opt)\n         \t</script>\t  \n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n                <script>\n\t\t\t\t parent.f_query_add_mod.document.forms[0].Gifstatus.value=\"E\";\n\t\t\t\t parent.f_query_add_mod.document.getElementById(\"resourcetype\").style.display=\"\";\n\t\t\t \t</script>\n                     ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n                    <script>\n\t\t\t\t\t parent.f_query_add_mod.document.forms[0].Gifstatus.value=\"\";\n\t\t\t\t     parent.f_query_add_mod.document.getElementById(\"resourcetype\").style.display=\"\";\n\t\t\t \t</script>\n                     ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t      <script>\n\t\t\t\t    var opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t    opt.text=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t    opt.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t    var comp2=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t    comp2.add(opt)\n\t\t\t     </script>   \n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n     </form></body></html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
		String sql1=null;
       	String sql4=null;
		Connection con = null;
		Statement stmt =null;
		ResultSet rset=null;
		
		try{

			con=ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			
			String code1="";
			String desc="";
			String desc1="";
			String name=request.getParameter("visit_type_ind");
			String value=request.getParameter("value");
			String facility_id=request.getParameter("facility_id");
			String sql3=null;
			String func=request.getParameter("function");
			String comp=" ";		
			String comp2="";
			String code2="";
			
		
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(name!=null)
			name=name.trim();
		if(func.equals("Insert"))
			{
			
		if(name.equals("indicator"))
	      	 {
			sql1="select distinct short_desc,visit_type_code from op_visit_type where visit_type_ind='"+value+"' and facility_id='"+facility_id+"' and eff_status='E' ";
			if(sql1!=null)
			     rset=stmt.executeQuery(sql1);
		  comp="parent.f_query_add_mod.document.forms[0].visittype";
		  while(rset.next()) 
			{
				desc=rset.getString(1);
				code1=rset.getString(2);
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block12Bytes, _wl_block12);

		} 
		   
		  if(rset != null) rset.close();
	      
		 }   // If closed here (Indicator)
			if(name.equals("visittype"))
				{
			     
			   String status="Y";
			   sql4="select resource_srl_no from op_resource_type_for_appt where visit_type_code='"+value+"'";
			   	
				if(sql4!=null)
				   rset=stmt.executeQuery(sql4);
				if(!rset.next()&&!value.equals(""))
					{
					status="X";
                    if(status=="X"){
					
            _bw.write(_wl_block13Bytes, _wl_block13);

					}//if closed here
					}
					else
						{
					
            _bw.write(_wl_block14Bytes, _wl_block14);
	  
						} 
						
			 if(rset != null) rset.close();
			}
            comp2="parent.f_query_add_mod.document.forms[0].resourcetype";
		  if(name.equals("resourceclass"))
				{ 
			      if(!value.equals(""))
					{  
				  if(value.equals("P"))
					    sql3="select desc_userdef,pract_type from am_pract_type where eff_status='E'  order by desc_userdef";
					else if(value.equals("R"))
					   sql3="select short_desc,locn_type from am_care_locn_type where care_locn_type_ind='R' order by long_desc";
				   else if(value.equals("E"))
						sql3="select short_desc,resource_type from am_resource_type where eff_status='E' and resource_class='E' order by long_desc";
				    else if(value.equals("O"))
						sql3="select short_desc,resource_type from am_resource_type where eff_status='E' and resource_class='O' order by long_desc";
				 
				  rset=stmt.executeQuery(sql3);
				
				 while(rset.next())
				  {
				     desc1=rset.getString(1);
					 code2=rset.getString(2);
				 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(desc1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(code2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp2));
            _bw.write(_wl_block18Bytes, _wl_block18);

				  }//while close
					}
				}//if closed here	
				      
		if(rset != null) rset.close();
		
		if(stmt != null) stmt.close();
		}//Insert If closed
}catch(Exception e) { out.println(e.toString());}
		finally
	       {
			try{
				if(rset != null ) rset.close();
				if(stmt != null) stmt.close();
			}catch(Exception e){}
			if(con!=null) ConnectionManager.returnConnection(con,request);			
	       }
	
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
