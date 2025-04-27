package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __addmodifypattypeclass extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/AddModifyPatTypeClass.jsp", 1709113966176L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!-- This form is used to Insert/Delete from Patient Type Class -->\n     <head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eAM/js/PatTypeClass.js\' language=\'JavaScript\'></script>\n     </head>\n     <body OnMouseDown=\'CodeArrest()\' onLoad=\'FocusFirstElement()\' onKeyDown = \'lockKey()\'>\n      \t<form name=\'pattypeclass_form\' id=\'pattypeclass_form\' action=\'../../servlet/eAM.PatTypeClassServlet\' method=\'post\' target=\'messageFrame\'>\n      \t\t<div align=\'left\'>\n      \t\t<center>\n      \t\t<BR>\n      \t\t<BR>\n      \t\t<BR>\n      \t\t<BR>\n      \t\t<BR>\n      \t\t<BR>\n      \t\t<BR>\n      \t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\'>\n      \t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n      \t\t\t\t<td>\n      \t\t\t\t\t&nbsp;\n      \t\t\t\t</td>\n      \t\t\t</tr>\n      \t\t\t\t<tr><td align=\'right\' width=\'30%\' class=\'label\'><fmt:message key=\"Common.patienttype.label\" bundle=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"/></td><td width=\'50%\' colspan=\'2\'>&nbsp;\n\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t    \t</td>\n      \t\t\t\t\t<td>\n      \t\t\t\t\t\t&nbsp;\n      \t\t\t\t\t</td>\n      \t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<tr>\n\t\t\t\t      \t<td>\n\t\t\t\t      \t\t&nbsp;\n\t\t\t\t      \t</td>\n\t\t\t\t      \t<td>\n\t\t\t\t\t\t \t\t&nbsp;\n\t\t\t\t      \t</td>\n      \t\t\t</tr>\n      \t\t\t\t<tr>\n\t\t\t\t\t\t\t\t      \t<td>\n\t\t\t\t\t\t\t\t      \t\t&nbsp;\n\t\t\t\t\t\t\t\t      \t</td>\n\t\t\t\t\t\t\t\t      \t<td>\n\t\t\t\t\t\t\t\t\t\t \t\t&nbsp;\n\t\t\t\t\t\t\t\t      \t</td>\n      \t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n      \t\t</center>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</form>\n     </body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);

					request.setCharacterEncoding("UTF-8");
					String patienttype="";
					//String patientclass="";
					//String codeTextAttribute="";
					//String otherTextAttribute="";
					//String eventFunctionForCase="";
					boolean newPatientTypeClass=false;
					//String sql="";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs=null;
				
            _bw.write(_wl_block5Bytes, _wl_block5);

					patienttype=request.getParameter("patient_type");

					if(patienttype == null ) patienttype= "";
					
					//codeTextAttribute="";
					//otherTextAttribute="";
					newPatientTypeClass=true;
					out.println("&nbsp;<select name='patient_type' id='patient_type' onChange='RemoveAll()'>&nbsp;<option value=''>--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------------</option>");
					
					try{
                    con = ConnectionManager.getConnection(request);
					pstmt 	= con.prepareStatement( "select patient_type,short_desc from am_patient_type where eff_status='E' order by short_desc" ) ;
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_type" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							if (patienttype == null || patienttype=="")
							{
							
								out.println( "<option value=\"" + Value + "\" >" + Label ) ;
							}	
							else
							{								
								if( patienttype.equals(Value))
									out.println( "<option selected value=\"" + Value + "\" >" + Label );
								else
									out.println( "<option  value=\"" + Value + "\" >" + Label );
							}	
						}
					}
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();

					out.println("</select> <img src='../../eCommon/images/mandatory.gif'></img>");
					out.println("</td></tr>");
					
            _bw.write(_wl_block6Bytes, _wl_block6);

					out.println("<table width='80%' cell padding='0' cellspacing='0' border='0' bordercolor='lavender'><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AvailableClasses.label","am_labels")+"</th><th>&nbsp;</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SelectedClasses.label","am_labels")+"</th><tr><td width='40%' align='center'><select name='available_patient_class' id='available_patient_class' size='10' style='width: 125px' >");


					if (patienttype != null && patienttype!="")
					{
						pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
						pstmt.setString	(	1,	patienttype		);
						rs = pstmt.executeQuery() ;
						if( rs != null )
						{
							while( rs.next() )
							{
								String Value 	= rs.getString( "patient_class" ) ;
								String Label 	= rs.getString( "short_desc" ) ;
								out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
							}
						}
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();
					}
					out.println("</select></td>");
					out.println("<td align='center' width='10%'><input type='button' name='add' id='add' class='button' onclick='addOptiontoSelection()'  value='---->'><br><input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOptionfromSelection()'></img></td>");
					out.println("<td width='40%' align='center'><select name='selected_patient_class' id='selected_patient_class' size='10' multiple='true' style='width: 125px' >");
					//out.println("<option value = '' >XXXXXXXXXXXXXXX </option>");

					if (patienttype != null && patienttype!="")
					{
						pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =? ) order by short_desc" ) ;
						pstmt.setString	(	1,	patienttype		);
						rs = pstmt.executeQuery() ;
							if( rs != null )
						{
							while( rs.next() )
							{
								String Value 	= rs.getString( "patient_class" ) ;
								String Label 	= rs.getString( "short_desc" ) ;
								out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
							}
						}
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();
					}
					out.println("</select></td></tr></table>");
					}
					catch(Exception e) { e.printStackTrace();}
					finally {
					  if (rs != null)   rs.close();
					  if (pstmt != null) pstmt.close();
					  ConnectionManager.returnConnection(con,request);
					  
					}



				/*
					out.println("<tr><td width='60%' colspan='2'>&nbsp;&nbsp;<select name='available_patient_class' id='available_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
						if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label +"</option>") ;
						}
					}
						pstmt.close() ;
					out.println("</select></td>");

					out.println("<td width='40%' colspan='2'>&nbsp;&nbsp;<select name='selected_patient_class' id='selected_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
						if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label ) ;
						}
					}
						pstmt.close() ;
					out.println("</select></td></tr>");

				}
				else
				{
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type = '"+patienttype+"') order by short_desc" ) ;
					rs = pstmt.executeQuery() ;
						if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
						}
					}
						pstmt.close() ;
					out.println("</select></td>");
					out.println("<td align='center' width='10%'><input type='button' name='add' id='add' class='button' onclick='addOptiontoSelection()' value='---->'><input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOptionfromSelection()'></td>");
					out.println("<td width='45%' align='center'><select name='selected_patient_class' id='selected_patient_class' size='10' multiple='true'>");

					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
						}
					}
					pstmt.close() ;
					out.println("</select></td></tr></table>");
					out.println("<tr><td width='60%' colspan='2'>&nbsp;&nbsp;<select name='available_patient_class' id='available_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label +"</option>") ;
						}
					}

					pstmt.close() ;
					out.println("</select></td>");

					out.println("<td width='40%' colspan='2'>&nbsp;&nbsp;<select name='selected_patient_class' id='selected_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label ) ;
						}
					}

					pstmt.close() ;
					out.println("</select></td></tr>");
				}*/

				
            _bw.write(_wl_block7Bytes, _wl_block7);
  if(newPatientTypeClass){
            _bw.write(_wl_block8Bytes, _wl_block8);
}else{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
