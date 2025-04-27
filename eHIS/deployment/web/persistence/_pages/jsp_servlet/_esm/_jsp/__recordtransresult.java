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

public final class __recordtransresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/RecordTransResult.jsp", 1709139948356L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction callframe4(obj)\n{\n\nparent.document.frames[3].document.location.href=\'../../eSM/jsp/RecordTransEntry.jsp?tableid=\'+parent.document.frames[0].document.forms[0].tableid.value+\"&code=\"+obj+\"&module_id=\"+parent.document.frames[0].document.forms[0].module_id.value;\n}\nfunction getComments(obj)\n\t{\n\t\t\n\t\tvar code_name = document.forms[0].code_name.value;\n\t\t\n\t\tvar code1 = obj;\n\t\tdocument.forms[0].code.value = code1;\n\t\tvar url\t\t= \'../../eSM/jsp/RecordTransEntry.jsp?tableid=\'+parent.document.frames[0].document.forms[0].tableid.value+\"&code=\"+code1+\"&module_id=\"+parent.document.frames[0].document.forms[0].module_id.value+\"&code_name=\"+code_name;\n\t\tvar dialogTop\t= \"165\";\n\t\tvar dialogHeight= \"24\" ; \n\t\tvar dialogWidth\t= \"40\" ;\t\n\t\tvar dialogLeft\t= \"80\" ;\n\t\t\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status=no;valign=center; dialogLeft: \"+dialogLeft ;\n\t\tvar returnval = window.showModalDialog( url, \'Trans Entry\', features ) ;\t\n\t\tif(returnval == null) returnval=\"\";\n\t\t\n\t\t\n\t}\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \t<body  onLoad=\"FocusFirstElement();\"  onKeyDown = \'lockKey()\'; OnMouseDown=\"CodeArrest()\";> \n\t\t<form name=\'RecordTransForm2\' id=\'RecordTransForm2\'>\n<table align = \'center\'  width=\'80%\'>\n<tr>\n<td class = \'white\' >\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</td>\n</tr>\n</table>\n\t<table align = \'center\' width=\'80%\' cellspacing=0 cellpadding=0 border=\"1\" id=\'tb1\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="                      \n\n\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=\'hidden\' name=\'tableid\' id=\'tableid\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=\'hidden\' name=\'criteria_String\' id=\'criteria_String\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type = \'hidden\' name = \'code\' value = \'X\'>\n\n\n\t\t\t\t\t\t</form>\n</body>\n\n</html>\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con = null;
	java.sql.Statement stmt=null;
	ResultSet rs=null ;
	ResultSet rs4=null ;
	ResultSet rs1=null ;
	try{
	con = ConnectionManager.getConnection(request);
	ArrayList pklist = new ArrayList();
    String tableid = request.getParameter("tableid");
    String criteria_String = request.getParameter("criteria_String");
	if (criteria_String==null) criteria_String ="";
	String classValue="";
	//String othclassValue="";
	String all_column_id = "";
	String oth_all_column_id = "";
	String table_where_cond = "";
	String table_where_cond1 = "";
	String pk_key = "";
	String order_by = "";
	String module_id = request.getParameter("module_id");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	int total_column=0;
	String column_value="";
	String cri_where="";
	int maxRecord=0;
	int k = 0;
	int cw = 0;
	int row_name = 1;
	String sql="";
    int start = 0 ;
    int end = 0 ;
    int l=1;
	if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 15 ;
    else
        end = Integer.parseInt( to ) ;
	stmt=con.createStatement();
		
            _bw.write(_wl_block4Bytes, _wl_block4);

        String where1="";
		String sqlstr1 = "select table_where_cond from sm_record_trans_hdr where table_id= '"+tableid+"'";
			rs4 = stmt.executeQuery(sqlstr1);
            while (rs4!=null&&rs4.next())
			{	
            where1 = rs4.getString(1);
			if(where1==null) where1="1=1";
			}
			sqlstr1 = "select COLUMN_ID from sm_record_trans_dtl where table_id= '"+tableid+"' and  COLUMN_SRL_NO = 2";
			if(rs4!=null)rs4.close();
			rs4 = stmt.executeQuery(sqlstr1);
            while (rs4!=null&&rs4.next())
			{	
			   cri_where = " and upper(" +rs4.getString("column_id")+ " ) like upper('" + criteria_String +"%')";
			}
			String strsql="select count(1) total from  "+tableid +" where " +where1 +cri_where;
		
			 rs1 = stmt.executeQuery(strsql);
			rs1.next();
			maxRecord = rs1.getInt("total");
		if(maxRecord == 0)		out.println("<script>parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';parent.document.frames[2].document.location.href='../../eCommon/html/blank.html';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");

		if ( !(start <= 1) )
    out.println("<A HREF='../../eSM/jsp/RecordTransResult.jsp?tableid="+tableid+"&module_id="+module_id+"&from="+(start-15)+"&to="+(end-15)+"&criteria_String="+criteria_String+"&whereclause="+sql+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+15) > maxRecord ) )
    out.println("<A HREF='../../eSM/jsp/RecordTransResult.jsp?tableid="+tableid+"&module_id="+module_id+"&from="+(start+15)+"&to="+(end+15)+"&criteria_String="+criteria_String+"&whereclause="+sql+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
    
            _bw.write(_wl_block5Bytes, _wl_block5);

		    
		try{
								try{
				     	sql="select count(1) count from sm_record_trans_dtl where table_id= '"+tableid+"'";
						rs=stmt.executeQuery(sql) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 total_column = rs.getInt("count");
 
						   }
    				     }
    				   }
    				    	catch(Exception e){out.println(e.toString());}

						sql="select a.table_where_cond,b.column_id,b.column_display,b.column_pk_yn,a.table_order_by from sm_record_trans_hdr a , sm_record_trans_dtl b  where a.table_id = b.table_id and  a.module_id = b.module_id and b.table_id= '"+tableid+"' order by b.column_srl_no";

						String colid = "";
						if(rs!=null)rs.close();
						rs=stmt.executeQuery(sql) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							  colid = rs.getString("column_id");
							 all_column_id      = all_column_id +","+colid;
							 oth_all_column_id  = oth_all_column_id +","+rs.getString("column_id");
							 table_where_cond = rs.getString("table_where_cond");
							 table_where_cond1 = rs.getString("table_where_cond");
							   if ( table_where_cond == null ) table_where_cond ="where 1=1";
                               else
								  table_where_cond = " Where "+ table_where_cond;

							   if ( table_where_cond1 == null ) table_where_cond1 ="1=1";

							   if (rs.getString("column_display").equals("N"))
							   {
							   all_column_id = all_column_id +","+"null  "+rs.getString("column_id")+"_oth_lang";
							   oth_all_column_id = oth_all_column_id +", "+rs.getString("column_id")+"_oth_lang";
							   total_column++;
							   }
							 order_by       = rs.getString("table_order_by");
							 
							 if (rs.getString("column_pk_yn").equalsIgnoreCase("Y"))
							   {
								pklist.add(colid);
							    pk_key = rs.getString("column_id");
							   }

						   }
    				     }
						
    				   }
    				    	catch(Exception e){out.println(e.toString());}
//shifted here from top 

 try{
					
						cw = (int)(100/total_column);
				     	sql="select column_display,column_width,column_prompt from sm_record_trans_dtl where table_id= '"+tableid+"'";
				      if(rs!=null)rs.close();
						rs=stmt.executeQuery(sql) ;
				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {

							 out.println("<td width='"+cw+"%' class='CAHIGHERLEVELCOLOR' >");
							 out.println(rs.getString("column_prompt"));
							 if (rs.getString("column_display").equals("N"))
							   {	
							      out.println("</td> <td width='"+cw+"%' align = 'right' class='CAHIGHERLEVELCOLOR' > "+rs.getString("column_prompt")+" Loc Lang");   
							   }
							 out.println("</td>");
						   }
    				     }
    				   }
    				    	catch(Exception e){out.println(e.toString());}
				







				     try{
				     	
						sql = "select "+oth_all_column_id.substring(1)+" from "+tableid+"_oth_lang_vw " + table_where_cond+cri_where;

						sql= sql+" union select "+all_column_id.substring(1)+" from "+tableid	+" where "+table_where_cond1+cri_where+"and "+ pk_key + " not in ( select "+ pk_key +" from "+ tableid+"_oth_lang_vw "+table_where_cond+cri_where	+ ") order by " + order_by;
                       if(rs!=null)rs.close();
						rs=stmt.executeQuery(sql) ;
						ResultSetMetaData rsmd = rs.getMetaData();
						if(rs!=null)
					    {
							if ( start != 1 )
						     for( int j=1; j<start; l++,j++ )
						      rs.next() ;
							  while ( rs.next() && l<=end  )    
					  			{
									out.println("</tr><tr style='backgroundColor:'>");
	                           if(k % 2 == 0)
									{	
							         classValue 		  = "QRYODD" ;
									}

		                       else
									{	
  							        classValue 		  = "QRYEVEN" ;
									}
									
								String col_value = "";
								String code = "";
							for (int i=1;i<=total_column;i++)
							 {
							
							  column_value = rs.getString(rsmd.getColumnName(i));
								
							for(int j=0;j<pklist.size();j++)
									 {
										
										if(rsmd.getColumnName(i).equalsIgnoreCase(pklist.get(j).toString()))
										col_value = col_value + column_value;
										
									 }
							 }
							
							 for (int i=1;i<=total_column;i++)
							 {
                                column_value = rs.getString(i);
								
							
								
								if (column_value==null) column_value ="&nbsp;";
								if (i==1) 
								 {
									
									code = column_value;
									out.println("<td width='"+cw+"%' class='"+classValue+"'><a name="+row_name+" onClick='changeRowColor(this,"+total_column+");' href=\"javascript:getComments('"+col_value+"') \">");			out.println(column_value +"</a></td>");
								 }
								else
								 {
                                 String direction ="";
									
								 if (rsmd.getColumnName(i).indexOf("OTH_LANG") >0)
									 {
									
									 direction  ="right";
			                           if(k % 2 == 0)
								         classValue 		  = "QRYODDOTHLANG" ;
				                       else
  									        classValue 		  = "QRYEVENOTHLANG" ;
									}
								 else
									 { 
										
									 direction="left";
										
									 }
									
								 out.println("<td width='"+cw+"%' class='"+classValue+"' align = '"+direction+"'>"+column_value+"</td>");
								 }
							   }
							out.println("</tr>");
							k++;
							row_name++;
							l++;
						   }
    				     }
    				   }
    				    	catch(Exception e){out.println(e.toString());}
						
            _bw.write(_wl_block6Bytes, _wl_block6);

sql ="SELECT COLUMN_ID FROM SM_RECORD_TRANS_DTL WHERE TABLE_ID = '"+tableid+"' and column_pk_yn = 'Y'" ;
String code_name = "";
if(rs!=null)rs.close();
rs=stmt.executeQuery(sql) ;
while(rs.next())
		{
				code_name = code_name+rs.getString(1)+"||";
		}
		
		if(code_name.substring(code_name.length()-2,code_name.length()) .equals("||"))
			code_name = code_name.substring(0,code_name.length()-2);
		
		out.println("<input id=code_name  type='hidden' name= code_name value = '"+code_name+"'>"); 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tableid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(criteria_String));
            _bw.write(_wl_block10Bytes, _wl_block10);
pklist.clear();
	}catch(Exception e){out.println(e);}
finally{
	
if(rs!=null) rs.close();
if(rs1!=null) rs1.close();
if(rs4!=null) rs4.close();
if(stmt!=null) stmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);

}

            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
