package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __getqueryvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/GetQueryValues.jsp", 1712648399176L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<html>\n\t\t\t\t\t<HEAD>\n\t\t\t\t\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\t\t\t\t\t\t</link> -->\n\t\t\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t\t\t\t</HEAD>\n\t\t\t\t\t<body CLASS=\'MESSAGE\'onKeyDown = \'lockKey()\'>\n\t\t\t\t\t<form name=\'nam1\' id=\'nam1\'>\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t<script>\n\t\t\t\t\t\tvar rootyn= \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\';\n\t\t\t\t\t\tvar spc=\"\" ;\n\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].root_menu.value = rootyn;\n\t\t\t\t\t\tvar opt=parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t\tvar access1=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].root_menu.value == \'N\')\n\t\t\t\t\t\t\t\tspc=\"              \" ;\n\t\t\t\t\t\tif(opt_type==\"F\") opt.text= spc  +  \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" ;\n\t\t\t\t\t\telse opt.text= spc  +\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" ;\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" + \"#\" + \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" + \"#\" + opt_type +\"#\"+access1+\"#\"+\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Menu.add(opt);\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<script>\n\n\t\t\t\t\t\t\t\tvar spc=\"          \";\n\t\t\t\t\t\t\t\tvar opt=parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].root_menu.value == \'N\')\n\t\t\t\t\t\t\t\tspc=\"                        \";\n\t\t\t\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\t\tvar access1=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t\t\tif(opt_type==\"F\") opt.text= spc +  \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ;\n\t\t\t\t\t\t\t\telse opt.text=spc +\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ;\n\t\t\t\t\t\t\t\topt.style.color=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\t\t\topt.id=\'t2\';\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Menu.add(opt);\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" <script>spc+=\"              \";</script>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tvar opt=parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\t\t\t\tvar opt_type=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tvar access1=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t\t\t\t\t\t\t\tif(opt_type==\"F\") opt.text= spc +\"              \"+ \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" ;\n\t\t\t\t\t\t\t\t\t\t\t\telse opt.text=spc+\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ;\n\t\t\t\t\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\t\t\t\t\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Menu.add(opt);\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</form>\n\t\t\t\t</body>\n\t\t\t\t\t</html>\n\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
			Connection con=null;
			con = ConnectionManager.getConnection(request);
			Statement stmt1 = con.createStatement();
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1=null;
			PreparedStatement pstmt2=null;
			Statement rootstmt= con.createStatement();
			Statement stmt_resp =null;
			ResultSet rset=null;
			ResultSet rset1=null;
			ResultSet rset2=null;
			ResultSet rootrset=null;
			String common=request.getParameter("Common_Text");
			if(common==null) common="";
			
			String Responsibility=request.getParameter("Responsibility");
			if(Responsibility==null) Responsibility="";
		
			String user_id=request.getParameter("User");
			if(user_id==null) user_id="";
			String chksrc = request.getParameter("Chksrc");

			String menu_id="";
			String option_type="";
			String module_id="";
			String function_id="";
			String submenu_id ="";
			String option_descriptor="";
			String access1="";
			String array[][]=null;
			String root_yn="";
			int row=0;
		    String sStyle	=
            (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  
try{
	if(chksrc.trim().equals("seven1")){
			String dat1 = "";
			try{
				//String	sql_resp="Select A.Resp_Id, B.Resp_Name, B.Menu_Id from SM_RESP_FOR_USER A, SM_RESP B Where upper(A.Appl_User_Id)= upper('"+user_id.trim()+"') and A.Resp_Id = B.Resp_Id  and a.resp_id='"+common.trim()+"' ";
				//stmt_resp=con.createStatement();
				//ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
				
				String	sql_resp="Select A.Resp_Id, B.Resp_Name, B.Menu_Id from SM_RESP_FOR_USER A, SM_RESP B Where upper(A.Appl_User_Id)= upper(?) and A.Resp_Id = B.Resp_Id  and a.resp_id=? ";
				pstmt   = con.prepareStatement(sql_resp);
				pstmt.setString	(	1,	user_id.trim()		);
				pstmt.setString	(	2,	common.trim()		);
				ResultSet rs_resp		 = pstmt.executeQuery();
					if(rs_resp!=null)
						{
							while(rs_resp.next())
							{
								dat1=rs_resp.getString(3);
							}
						if(rs_resp!=null) rs_resp.close();
						if(stmt_resp!=null) stmt_resp.close();
						if(pstmt!=null) pstmt.close();
						}
					}
				catch( Exception e){out.println(e);}
				chksrc="seven";
				common=dat1;
			
				}

			 if(chksrc.trim().equals("seven")) 
				{
					String rootsql=" select ROOT_MENU_YN  from sm_menu_hdr  where MENU_ID='" + common.trim() + "'";
					rootrset=rootstmt.executeQuery(rootsql);
					if(rootrset.next())
					{
						root_yn = rootrset.getString(1);
					}
					if(rootrset!=null)rootrset.close();
					if(rootstmt!=null)rootstmt.close();

				String countsql="select count(*) from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "'";
				rset1=stmt1.executeQuery(countsql);
				if(rset1.next())
				{
				 row=rset1.getInt(1);
				array=new String[row][7];
				if(rset1!=null)rset1.close();
				
				}

				String sql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor,insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1 from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "'";
				if(stmt1!=null) stmt1.close();
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql);
		   		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

				if(rset != null)
				{
					 row=0;
				        while( rset.next() ) 
						{
							array[row][0]=rset.getString(1);
							array[row][1]=rset.getString(2);
							array[row][2]=rset.getString(3);
							array[row][3]=rset.getString(4);
							array[row][4]=rset.getString(5);
							array[row][5]=rset.getString(6);
							array[row][6]=rset.getString(7);
							row++;
						}
					
					}
					if(rset!=null)rset.close();
					if(stmt1!=null) stmt1.close();
					
					String sql1 = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor,insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1  from Sm_Menu_Dtl where Menu_Id=? order by option_sequence_no,srl_no";
					
					pstmt1 = con.prepareStatement(sql1);


					String subsql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor,insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1  from Sm_Menu_Dtl where Menu_Id=? order by option_sequence_no,srl_no";
					
					pstmt2 = con.prepareStatement(subsql);
					
					for(int i=0;i<array.length;i++)
					{

						menu_id = array[i][0]==null ? "" : array[i][0];
						option_type = array[i][1]==null ? "" : array[i][1];
						module_id = array[i][2]==null ? "" : array[i][2];
						function_id = array[i][3]==null ? "" : array[i][3];
						submenu_id = array[i][4]==null ? "" : array[i][4];
						option_descriptor = array[i][5]==null ? "" : array[i][5];
						access1 = array[i][6]==null ? "" : array[i][6];
					
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(root_yn));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(access1));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block12Bytes, _wl_block12);

					String colour = "";
					pstmt1.setString(1,submenu_id.trim());
					rset1=pstmt1.executeQuery();
					if(rset1 != null) {
						while( rset1.next() ) {
							menu_id = rset1.getString( "menu_id" )==null ? "" :  rset1.getString( "menu_id" );
							option_type = rset1.getString( "option_type" )==null ? "" :  rset1.getString( "option_type" );
							module_id = rset1.getString("module_id")==null ? "" : rset1.getString("module_id");
							function_id = rset1.getString("function_id")==null ? "" : rset1.getString("function_id");
							submenu_id = rset1.getString("submenu_id")==null ? "" : rset1.getString("submenu_id");
							option_descriptor = rset1.getString( "option_descriptor" )==null ? "" : rset1.getString( "option_descriptor" );
							access1 = rset1.getString( "access1" )==null ? "" : rset1.getString( "access1" );

							if(submenu_id == null || submenu_id.equals(""))
								colour = "";
							else{
								colour="RED";
								option_type="S";
							}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(access1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(colour));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block19Bytes, _wl_block19);

								
								while(!(submenu_id.equals("") || submenu_id == null ))
								{
																	
									pstmt2.setString(1,submenu_id.trim());
					                rset2=pstmt2.executeQuery();
									if(rset2 != null) {
										while( rset2.next() ) {
											menu_id = rset2.getString( "menu_id" )==null ? "" :  rset2.getString( "menu_id" );
											option_type = rset2.getString( "option_type" )==null ? "" :  rset2.getString( "option_type" );
											module_id = rset2.getString("module_id")==null ? "" : rset2.getString("module_id");
											function_id = rset2.getString("function_id")==null ? "" : rset2.getString("function_id");
											submenu_id = rset2.getString("submenu_id")==null ? "" : rset2.getString("submenu_id");
											option_descriptor = rset2.getString( "option_descriptor" )==null ? "" : rset2.getString( "option_descriptor" );
											access1 = rset2.getString("access1")==null ? "" : rset2.getString("access1");
											if(!(submenu_id == null || submenu_id.equals("")))
											{ 
            _bw.write(_wl_block20Bytes, _wl_block20);
}

				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(option_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(access1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block26Bytes, _wl_block26);

										}
									}if(rset2!=null)rset2.close();
									
									

				
            _bw.write(_wl_block20Bytes, _wl_block20);

								}
						}
					
					
					}if(rset1!=null)rset1.close();
					}
					if(pstmt1 !=null) pstmt1.close();
					if(pstmt2 !=null) pstmt2.close();
			
            _bw.write(_wl_block27Bytes, _wl_block27);

			}

			if(stmt1!=null) stmt1.close();
			if(rootstmt!=null) rootstmt.close();
			if(stmt_resp!=null) stmt_resp.close();
		}catch(Exception e){
			out.println(e);
            e.printStackTrace();
			}
			finally { 
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
