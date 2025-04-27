package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __sspopulatevalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/SSPopulateValues.jsp", 1709119099848L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t   var opt = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t   opt.text=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\t\t   opt.value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\t\t   parent.frames[1].document.getElementById(\"Main_Group\").add(opt);\n\t\t\t\t\t   opt.selected = true;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t   parent.frames[1].document.getElementById(\"Main_Group\").add(opt);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t   parent.frames[1].document.getElementById(\"LEVEL3_CODE\").add(opt);\n\t\t\t\t\t   opt.selected = true;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t   parent.frames[1].document.getElementById(\"LEVEL3_CODE\").add(opt);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n  <script>\n\t   var f=parent.frames[1].frames[0];         \n\t   opt=f.document.createElement(\"OPTION\");\n\t   opt.text=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t   opt.value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t   f.document.getElementById(\"Main_group\").add(opt);\n </script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="       \n  <script>\n\t   var f=parent.frames[1].frames[0];         \n\t   opt=f.document.createElement(\"OPTION\");\n\t   opt.text=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t   f.document.getElementById(\"sub_group\").add(opt);\n\t\t\t  \n </script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n </form>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;
	String str					= "";
	String group_desc			= "";
	String group_code			= "";
	String main_group			= "";
	String report_gr_id			= "";
	String sStyle				= "IeStyle.css";
	String calledFromFinction			= "";
 try
  {
	con	= ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	
	///// if called from PD/PL Report Group function. 
	///// populate_main_group.js function of addModifyReportGroupSetup.jsp
	sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	calledFromFinction = request.getParameter("calledFromFinction");
	if(calledFromFinction == null || calledFromFinction.equals("null")) calledFromFinction = "";
	///// end /////
	if(calledFromFinction.equals("PDPLReportGroup"))
	{
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
		String group_id="";
		String grpDesc ="";
		String ReportID ="";
		String MainGroup ="";
		
		ReportID = request.getParameter("ReportID");
		if(ReportID == null || ReportID.equals("null"))
			ReportID = "";
		MainGroup = request.getParameter("MainGroup");
		if(MainGroup == null || MainGroup.equals("null"))
			MainGroup = "";



		String sql ="select GROUP_CODE, GROUP_DESC from MR_REPORT_GROUPING where REPORT_ID = '"+ReportID+"' and GROUP_CATEGORY = 'M' order by GROUP_DESC ";

        rs = stmt.executeQuery(sql);
		if(rs!=null)
		{  
			while(rs.next())
			{  
				grpDesc = rs.getString("GROUP_DESC")==null?"":rs.getString("GROUP_DESC");
				group_id = rs.getString("GROUP_CODE")==null?"":rs.getString("GROUP_CODE");
				if(group_id.equals(MainGroup))
				{
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(grpDesc));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block4Bytes, _wl_block4);

				}
				else
				{
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(grpDesc));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block5Bytes, _wl_block5);

				}
			}
		}
		if(rs!=null) rs.close();
	}
	///////////////////////////Added for Level3//////////////////////////
	else if(calledFromFinction.equals("PDPLReportGroup_level3"))
	{

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
		String group_id="";
		String grpDesc ="";
		String ReportID ="";
		String MainGroup ="";
		String sub_group_code_l2 ="";
		
		ReportID = request.getParameter("ReportID");
		if(ReportID == null || ReportID.equals("null"))
			ReportID = "";
		MainGroup = request.getParameter("MainGroup");
		if(MainGroup == null || MainGroup.equals("null"))
			MainGroup = "";
		sub_group_code_l2 = request.getParameter("sub_group_code_l2");
		if(sub_group_code_l2 == null || sub_group_code_l2.equals("null"))
			sub_group_code_l2 = "";
		



		String sql ="select GROUP_CODE, GROUP_DESC from MR_REPORT_GROUPING where REPORT_ID = '"+ReportID+"' and GROUP_CATEGORY = 'S' and SUBGROUP_CODE='"+sub_group_code_l2+"'order by GROUP_DESC ";

        rs = stmt.executeQuery(sql);
		if(rs!=null)
		{  
			while(rs.next())
			{  
				grpDesc = rs.getString("GROUP_DESC")==null?"":rs.getString("GROUP_DESC");
				group_id = rs.getString("GROUP_CODE")==null?"":rs.getString("GROUP_CODE");
				if(group_id.equals(MainGroup))
				{
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(grpDesc));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block6Bytes, _wl_block6);

				}
				else
				{
					
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(grpDesc));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block7Bytes, _wl_block7);

				}
			}
		}
		if(rs!=null) rs.close();
	}
	//////////////////////////////////////////////////////////////////
	else
	  {
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
    main_group					= request.getParameter("main_group");
    report_gr_id				= request.getParameter("report_gr_id");
	
	if(main_group==null || main_group.equals("null") || main_group.equals(""))
	{
	
       str="select group_code, group_desc from mr_report_grouping where report_id ='"+report_gr_id+"' and group_category = 'M' order by group_desc ";
	   rs	= stmt.executeQuery(str);
	  
	  while(rs.next())
	  {
		  group_code	= rs.getString("group_code");
		  group_desc	= rs.getString("group_desc");
		  if(group_code==null || group_code.equals("null"))
		  group_code="";
		  if(group_desc==null || group_desc.equals("null"))
		  group_desc="";
          group_code=group_code.trim();
   
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
  }
     if(rs!=null) rs.close();
	}

  else{
	    str	="select group_code, group_desc from mr_report_grouping where report_id ='"+report_gr_id+"' and subgroup_code = '"+main_group+"'and group_category = 'S' order by group_desc " ;
        rs	= stmt.executeQuery(str);
		
		   while(rs.next())
		   {
				group_code	= rs.getString("group_code");
				group_desc	= rs.getString("group_desc");
				if(group_code==null || group_code.equals("null"))
				  group_code="";
				if(group_desc==null || group_desc.equals("null"))
				  group_desc="";

				group_code=group_code.trim();


            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block12Bytes, _wl_block12);

   }
    if(rs!=null) rs.close();//end of while
  }//end of else.
  }//end of first else

            _bw.write(_wl_block13Bytes, _wl_block13);

   if(stmt!=null) stmt.close();
   if(rs!=null) rs.close();
   }
   catch(Exception e)
   {
	   //out.println("Exception in File SSPopulateValues"+e.toString());
	   e.printStackTrace();
   }
   finally
 {
    ConnectionManager.returnConnection(con,request);
 }

            _bw.write(_wl_block14Bytes, _wl_block14);
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
