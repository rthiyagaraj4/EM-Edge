package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __recordtransentry extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/RecordTransEntry.jsp", 1709139903499L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<title>\n\t<fmt:message key=\"eSM.TranslationManager.label\" bundle=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\"/>\n</title>\n<script>\nfunction validate()\n{\n\tvar leng =\tdocument.forms[0].elements.length;\n\tvar submit = \"Y\";\n\tvar msg = \"\";\n\tfor(i=0;i<leng;i++)\n\t\t{\n\t\t\t\n\t\t  if (document.forms[0].elements(i).type==\"text\" || document.forms[0].elements(i).type==\"textarea\")\n\t\t  {\n\t\t\t\n\t\t    if (document.forms[0].elements(i).value==\"\")\n\t\t    {\n\t\t\t\n\t\t\tmsg= getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\n\t\t\tmsg = msg.replace(\'$\',document.forms[0].elements(i).name);\n\t\t\t\n\t\t\tmsg=msg+\"\\n\";\n\t\t\t\n\t\t\tsubmit = \"N\";\n\t\t\t}\n\t\t  }\n\t\t}\n\tif (submit==\"Y\")\n    {\n\t\tdocument.forms[0].submit();\n\t\twindow.close();\n\t}\n\telse\n\t{\t\n\t\talert(msg);\n\t\treturn false;\n\t}\n}\nfunction checkMaxLength(Obj,length)\n\t{\t\n\t\tvar msg = \"\";\n\t\tif(eval(Obj).value.length > parseInt(length))\n\t\t\t{\n\t\t\tmsg = getMessage(\'OBJ_CANNOT_EXCEED\',\'Common\');\n\t\t\tmsg = msg.replace(\'$\',length);\n\t\t\talert(msg);\n\t\t\tObj.focus();\n\t\t\t}\n\t}\n</script>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\n<object id=\"locale\" classid=\"clsid:C0276E18-D808-4F12-829E-BC186831D396\" CODEBASE=\"../../eCommon/js/Locale.CAB#version=1,0,0,0\"></object>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/locale.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eSM/js/RecordTrans.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n \t<body  onUnload=\'loadEnglish()\' onLoad=\"FocusFirstElement()\";onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\";> \n\t\t<form name=\'RecordTransForm4\' id=\'RecordTransForm4\' action=\'../../servlet/eSM.RecordTransServlet\' method=\'post\' target=\'messageFrame\'>\n<table align = \'center\' width=\'95%\' cellspacing=0 cellpadding=0 border=0>\n\n\t\t<th align = \'left\' colspan=2>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n                    <tr><td>&nbsp;</td><td>&nbsp;</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<tr><td>&nbsp;</td><td >&nbsp;&nbsp;&nbsp;&nbsp;\n<input type=\'hidden\' name=\'tableid\' id=\'tableid\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=\'hidden\' name=\'lang_id\' id=\'lang_id\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\n<input type=\'hidden\' name=\'code\' id=\'code\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\n</td>\n</tr>\n<tr><td colspan=\'2\' align=\'right\'><input type=\'button\' class=\'button\' name=\'btnOK\' id=\'btnOK\' value=\'Record\' onClick=\"validate()\" >&nbsp;<input type=\'button\' class=\'button\' name=\'btnCancel\' id=\'btnCancel\' value=\'Cancel\' onClick=\"javascript:window.close()\" ></td></tr>\n</table>\n\n</form>\n</body>\n</html>\n ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);

          request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	Connection con = null;
	Statement stmt=null;
	Statement stmt1=null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null ;
	ResultSet rs1=null ;
    String tableid = request.getParameter("tableid");

	if (tableid ==null) tableid ="";
    String module_id = request.getParameter("module_id");
	if (module_id ==null) module_id="";
	String code = request.getParameter("code");
	if (code==null) code ="";
	
	String code_name = request.getParameter("code_name");
	if(code_name == null) code_name = "";
	String sql="";
	String sql1="";
	String column_id="";
	String column_width="";
	String column_prompt="";
	String column_display="";
	String column_pk_yn="";
	String lang_id="";
//	String all_column_id="";
//	String column_pk_id="";
	String col_value="";
	//String whereClause="";
	String mode="I";
	int total_columns = 0;
	stmt=con.createStatement();
	stmt1=con.createStatement();
		
            _bw.write(_wl_block5Bytes, _wl_block5);

				     try{
				     	sql="select module_id  from sm_record_trans_hdr where table_id= '"+tableid+"'";

						rs=stmt.executeQuery(sql) ;
						if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 module_id = rs.getString("module_id");
    				       }
						   
    				     }if(rs!=null)rs.close();
    				   }
    				   catch(Exception e){out.println(e.toString());}

					try{
						sql="select language_id, short_name  from sm_language where usage_type= 'O' and rownum<=1";
						
						rs=stmt.executeQuery(sql) ;
						if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 out.println("Other Language : "+rs.getString("short_name")+"</th>");
							 lang_id = rs.getString("language_id");
    				       }
						   
    				     }if(rs!=null)rs.close();
    				   }
    				    	catch(Exception e){out.println(e.toString());}
                    
            _bw.write(_wl_block6Bytes, _wl_block6);

					try{
				     	sql="select column_id,column_width,column_prompt,column_display,column_pk_yn from sm_record_trans_dtl where table_id= '"+tableid+"'";
						
						rs=stmt.executeQuery(sql) ;
						sql1="select " + column_id + " from " + tableid + " where " + code_name  +"='"+code+"'";
						
                       	rs1=stmt1.executeQuery(sql1) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
                             total_columns  ++;
							 column_id		= rs.getString("column_id");
							 column_width   = rs.getString("column_width");
						     column_prompt  = rs.getString("column_prompt");
						     column_display = rs.getString("column_display");
						     column_pk_yn   = rs.getString("column_pk_yn");
							/*if (column_pk_yn.equalsIgnoreCase("Y"))
							    column_pk_id   = rs.getString("column_id");*/
						  col_value="";
						  if (column_display.equalsIgnoreCase("Y"))
							{
							try{
								
						        if(rs1!=null)
							    {
								  while(rs1.next())
					  				{
							        col_value = rs1.getString(1);
									}
									
    							}if(rs1!=null)rs1.close();
    				      	}
							catch(Exception e){out.println(e.toString());}
						   out.println("<tr><td class='label' >"+column_prompt+"</td>");
                           out.println("<td class = 'querydata'>&nbsp; "+col_value+"<input type='hidden' name='"+column_id+"' id='"+column_id+"' size = '"+column_width+"' maxlength = '"+column_width+"' value =\""+col_value+"\" readonly></td><tr><td class='DEFAULTBLANKROW2PT' colspan=6>&nbsp;</td></tr></tr>");
						   }
                         else
							   {
							try{
								
                               
							   sql1="select column_value from sm_record_trans_data where module_id = '"+module_id+"' and table_id = '"+tableid+"' and column_id = '"+column_id+"' and pk_value = '"+code+"' and language_id ='"+lang_id+"'"; 
								
								
								rs1=stmt1.executeQuery(sql1) ;
								if(rs1!=null)
							    {
								  while(rs1.next())
					  				{
							        col_value = rs1.getString(1);
									mode = "U";
									}
									
    							}if(rs1!=null)rs1.close();
    				      	}
							catch(Exception e){out.println(e.toString());}
						   out.println("<tr><td class='label' >"+column_prompt+"</td>");
									out.println("<td >&nbsp;<input type='hidden' name='"+column_id+"1' id='"+column_id+"1' value =\""+column_prompt+"\">");
									if(Integer.parseInt(column_width)<=60)
									out.println("<input id=\""+column_id+"\"  type='text' style='text-align:right' onFocus='loadArabic()' onBlur='loadEnglish()' class='OTHLANGTEXT'  name=\""+column_id+"\"  size = 	'"+column_width+"' maxlength = '"+column_width+"' value =\""+col_value+"\">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>");
									else
									out.println("<table border=0><tr><td><textarea  name=\""+column_id+"\" style='text-align:right' cols='50' onFocus='loadArabic()' onBlur='loadEnglish();checkMaxLength(this,"+column_width+")' onkeypress='checkMaxLimit(this, "+column_width+")' rows='4'>"+col_value+"</textarea></td><td valign='center'><img src='../../eCommon/images/mandatory.gif'></img></td></tr></table>&nbsp;");
									out.println("</td><tr><td class='DEFAULTBLANKROW2PT' colspan=6>&nbsp;</td></tr></tr>");
							   }
						 }
						 
    				   }if(rs!=null)rs.close();
					   if(rs1!=null)rs1.close();
					}
							catch(Exception e){out.println(e.toString());}
						
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tableid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(lang_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}catch(Exception e){}
finally{
	if(stmt!=null) stmt.close();
	if(stmt1!=null) stmt1.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
