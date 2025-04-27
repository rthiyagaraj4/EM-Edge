package jsp_servlet._esm._jsp;

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

public final class __getuserdesktopvalue extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/GetUserDesktopValue.jsp", 1709121704276L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\t\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t//var opt=parent.f_query_add_mod.frameAddModifyCreateUserDesktop.document.createElement(\"OPTION\");\n\t\t\t\tvar opt = parent.f_query_add_mod.construct_ca_menu.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\t//parent.f_query_add_mod.frameAddModifyCreateUserDesktop.document.CreateDesktop_form.Function_id.add(opt);\n\t\t\t\tparent.f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id.add(opt);\n\t\t\t\t\n\t\t\t \t\n\t\t\t  </script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t<script>\n\t\t\t/*\tvar temp = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tif(temp==\"F\")\n\t\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.forms[0].dektop_id_desc.disabled=true;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].dektop_id_desc1.disabled=true;\n\t\t\t    }\n\t\t\t\t\t\n\t\t\t\tif(temp==\"J\")\n\t\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.forms[0].dektop_id_desc.disabled=false;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].dektop_id_desc1.disabled=false;\n\t\t\t    }\n\t\t\t*/\t\n\t\t\t  </script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n\t\t\n\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\t\t temp = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t temp1=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\tvar opt= parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.Menu.add(opt);\n\t\t\t \t\n\t\t\t\t </script>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t\t<script>\n\t\t\t\t\t\t temp = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"+\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\tvar opt= parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.Menuopts.add(opt);\n\t\t\t \t\n\t\t\t\t </script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\tvar opt= parent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.funcopt.add(opt);\n\t\t\t \t\n\t\t\t\t </script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\tvar opt= parent.f_query_add_mod.construct_ca_menu.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id.add(opt);\n\t\t\t \t\n\t\t\t\t </script>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n        \t<script>\n\t\t           parent.frames[2].location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0\";\n\t\t\t </script>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
 String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block2Bytes, _wl_block2);

   request.setCharacterEncoding("UTF-8"); 

   String module_id=request.getParameter("module_id");
   //String menu_id=request.getParameter("menuid");
   String mode=request.getParameter("mode");
   mode 		 = (mode == null)?"":mode;
   
  
   String dev_tool="";

    Connection con = null;
	try{
		con					      = ConnectionManager.getConnection(request);
	
	if(mode.equals("function")){
	
	try
	{
		String function_id="";
		String function_name="";	
		String sql="";

		//StringBuffer menuoptsql= new StringBuffer();
		//String menu_id_opt		=	"";
		//String short_desc_opt	=	"";
		//String str1				= "";
		//String deft_menu_id				= "";
		//String deft_menu_name				= "";

		
		//con=ConnectionManager.getConnection(request);
		Statement stmt = con.createStatement();
		ResultSet rs;
		//PreparedStatement stmt2 = null; 

		sql ="select function_id, function_name from Sm_Function where module_id='" + module_id + "'  and desktop_appl_yn='Y'  order by  function_name";

		
    	rs = stmt.executeQuery(sql);

		while(rs.next())
		{
			function_id=rs.getString("function_id");
			function_name=rs.getString("function_name");
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
				}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			
				
/*

			sql="Select menu_id,menu_name,root_menu_yn, dev_tool from sm_menu_hdr where  root_menu_yn='Y' and menu_id ='"+menu_id+"'";
				
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()){
					dev_tool=rs.getString("dev_tool");
						*/
						
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dev_tool));
            _bw.write(_wl_block10Bytes, _wl_block10);
	
				//}
				
            _bw.write(_wl_block11Bytes, _wl_block11);

				
	//	if (stmt != null) stmt.close();
		//if (rs != null) rs.close();
				



		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	}
	catch(Exception e) 
	{ 
		out.println("Exception in GetUserDesktopValue.jsp mode = function ..."+e.toString());
		
		e.printStackTrace(System.err);
	}
	finally
	{
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	}
	else if(mode.equals("summary"))
	{

		StringBuffer menuoptsql= new StringBuffer();
		String menu_id_opt		=	"";
		String short_desc_opt	=	"";
		String str1				= "";
		String appl_scope = request.getParameter("appl_scope");

		String deft_menu_id				= "";
		String deft_menu_name				= "";

		
		
	 try{
			
		//con=ConnectionManager.getConnection(request);
		ResultSet rs;
		PreparedStatement stmt2 = null; 


		stmt2=con.prepareStatement("select DESKTOP_SUMMARY_ID,DESKTOP_SUMMARY_NAME from SM_DESKTOP_SUM_HDR where SYS_USER_DEF_IND ='S' AND DESKTOP_SUMMARY_TYPE=? ");
			
			stmt2.setString(1,appl_scope);
			rs=stmt2.executeQuery();
		 while(rs.next())
			{		 
				deft_menu_id=rs.getString("DESKTOP_SUMMARY_ID");
			    deft_menu_name=rs.getString("DESKTOP_SUMMARY_NAME");
			   
			
			
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(deft_menu_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(deft_menu_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
			}
			if(stmt2 != null) stmt2.close();
			if(rs != null) rs.close();
		
		
		menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='T' AND APPLICABLITY_SCOPE=? ");
		
		stmt2= con.prepareStatement(menuoptsql.toString());
		stmt2.setString(1,appl_scope);
		rs=stmt2.executeQuery();
			
				str1="#1#M";  
				
				while(rs.next())
				{ 
					menu_id_opt		=	rs.getString("menu_id");
					short_desc_opt	=	rs.getString("short_desc");

					if(menu_id_opt == null)		menu_id_opt="";
					if(short_desc_opt == null)	short_desc_opt="";

					
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(menu_id_opt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc_opt));
            _bw.write(_wl_block17Bytes, _wl_block17);
	

				//out.println("<option value='"+menu_id_opt+str1+"'>"+short_desc_opt+"</option>");
				}
				if (stmt2 != null) stmt2.close();
				if (rs != null) rs.close();
				
				menuoptsql.delete(0,menuoptsql.length());

			menuoptsql.append("SELECT SUMMARY_COMP_ID menu_id,SUMMARY_COMP_DESC short_desc FROM SM_DESKTOP_SUM_COMP WHERE SUMMARY_COMP_TYPE	='S' AND APPLICABLITY_SCOPE=? ");
		
		stmt2= con.prepareStatement(menuoptsql.toString());
		stmt2.setString(1,appl_scope);
		rs=stmt2.executeQuery();
			
				str1="#2#F";  
				
				while(rs.next())
				{ 
					menu_id_opt		=	rs.getString("menu_id");
					short_desc_opt	=	rs.getString("short_desc");

					if(menu_id_opt == null)		menu_id_opt="";
					if(short_desc_opt == null)	short_desc_opt="";
					
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(menu_id_opt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc_opt));
            _bw.write(_wl_block18Bytes, _wl_block18);
	

				//out.println("<option value='"+menu_id_opt+str1+"'>"+short_desc_opt+"</option>");
				}
				if (stmt2 != null) stmt2.close();
				if (rs != null) rs.close();






		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	}
	else if(mode.equals("CA_summary"))
	{
       // StringBuffer menuoptsql= new StringBuffer();
		String option_id="";
		String long_desc="";
		//String str1				= "";
				
	 try{
			
		//con=ConnectionManager.getConnection(request);
		ResultSet rs;
		PreparedStatement stmt2 = null; 


		stmt2=con.prepareStatement("select OPTION_ID,long_desc from ca_option where DESKTOP_YN='Y' AND OPTION_TYPE='F' and OPEN_IN_MODAL_WINDOW_YN='N' order by 2");
						
			rs=stmt2.executeQuery();
		 while(rs.next())
			{		 
				option_id=rs.getString("OPTION_ID");
			    long_desc=rs.getString("long_desc");
			 		
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
			}
			if(stmt2 != null) stmt2.close();
			if(rs != null) rs.close();

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	 }catch(Exception e) { 
		 out.println(e.toString());
		 e.printStackTrace();
		 }
	finally
	{
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	}
	else
{ 
            _bw.write(_wl_block20Bytes, _wl_block20);
	
}
	}
	catch(Exception e){
		e.toString();
		e.printStackTrace();
		}
	finally {
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
