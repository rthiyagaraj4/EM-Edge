package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __getproccode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eCA/jsp/getProcCode.jsp", 1698814669577L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\r\n--------------------------------------------------------------------------------------------------------------\r\nDate       \t\tEdit History\tName        \tDescription\r\n--------------------------------------------------------------------------------------------------------------\r\n?             \t100            \t?           \tcreated\r\n19/06/2013    \tIN035719\t\tRamesh G\tSystem displays script error while recording the procedure.This issue is happening only for certain Terminology code.\r\n\r\n---------------------------------------------------------------------------------------------------------------\r\n-->\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\r\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t\t\t\t<script>\r\n\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).description1.value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\r\n\t\t\t\t\t\t</script>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\r\n\t\t\t\t\t\t\t\t\t<script>\r\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).description.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\r\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).record_type.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\r\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).cause_indicator.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\r\n\t\t\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).description1.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\r\n\t\t\t\t\t\t\t\t\t</script>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t\t\t\t<script> \r\n\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).description.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\r\n\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).description1.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\r\n\t\t\t\t\t\t\t</script>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t<script>\r\n\t\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).description.value=\"\"; top.content.workAreaFrame.frame2.document.forms(0).description1.value=\"\"; top.content.workAreaFrame.frame2.document.forms(0).code.focus();\r\n\t\t\t\t\t\t\t\ttop.content.workAreaFrame.frame2.document.forms(0).code.select();\r\n\t\t\t\t\t\t\t\tdocument.write(\'OP0017 - Invalid procedure code\');\r\n\t\t\t\t\t\t\t</script>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" <script>\r\n\t\t\t\t top.content.workAreaFrame.frame2.document.forms(0).description1.value=\"\";\r\n\t\t\t\t</script>\r\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
 	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con=null;
PreparedStatement stmt = null;
ResultSet rs = null ;
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block4Bytes, _wl_block4);

	try{
		String p_code   =   request.getParameter("p_code");
		if(p_code ==null)   p_code = "" ;
			p_code          =   p_code.trim();
		String p_scheme =   request.getParameter("p_scheme");
		if(p_scheme == null)p_scheme="";
			p_scheme = p_scheme.trim();
		String validate_dttime =   request.getParameter("validate_dttime");
			validate_dttime = (validate_dttime == null?"N":"Y") ;
		String term_set_id   =   request.getParameter("term_set_id");
		if(term_set_id ==null)   term_set_id = "" ;
			term_set_id          =   term_set_id.trim();
		String term_code   =   request.getParameter("term_code");
		if(term_code ==null)   term_code = "" ;
			term_code          =   term_code.trim();
		if(validate_dttime.equals("Y")){
			String to_dttime = request.getParameter("to_dttime") ;
			GregorianCalendar  cal = new GregorianCalendar ();
			cal.set(Calendar.SECOND,0 ) ; 
			cal.set(Calendar.MILLISECOND,0 ) ; 

			java.util.StringTokenizer toks = new java.util.StringTokenizer(to_dttime," ") ;
			String dt = toks.nextToken() ;
			String tme = toks.nextToken() ;
			
			String[] dtarr = new String[3] ;
			toks = new java.util.StringTokenizer(dt,"/") ;
			dtarr[0] = toks.nextToken() ;
			dtarr[1] = toks.nextToken() ;
			dtarr[2] = toks.nextToken() ;

			
			String tmearr[] = new String[2] ;
			toks = new java.util.StringTokenizer(tme,":") ;
			tmearr[0] = toks.nextToken() ;
			tmearr[1] = toks.nextToken() ;
			
			GregorianCalendar  newcal= new GregorianCalendar () ;
			newcal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dtarr[0]) ) ; 
			newcal.set(Calendar.MONTH,(Integer.parseInt(dtarr[1])-1) ) ; 
			newcal.set(Calendar.YEAR,Integer.parseInt(dtarr[2]) ) ; 
			newcal.set(Calendar.HOUR,Integer.parseInt(tmearr[0]) ) ; 
			newcal.set(Calendar.MINUTE,Integer.parseInt(tmearr[1]) ) ;  
			newcal.set(Calendar.SECOND,0 ) ; 
			newcal.set(Calendar.MILLISECOND,0 ) ; 
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script></head>") ;
			out.println("<body class='message' onKeyDown='lockKey()'>"); //INVALID_PROC_DATE_TIME
			/*out.println(cal) ;
			out.println(newcal) ; */

			if(cal.before(newcal)){
				String s = "<script>"+
				   "alert(top.content.workAreaFrame.frame2.getMessage('INVALID_PROC_DATE_TIME'))\n" +
					"top.content.workAreaFrame.frame2.document.forms(0).date.select()\n"+
					"top.content.workAreaFrame.frame2.document.forms(0).date.focus()\n"+
					"</script>" ;
					
					out.println(s) ;
			}
			out.println("</body></html>") ;
		}else{
			if (!(p_code == null || p_code.equals("null")||p_code.length()==0)){		
				con=ConnectionManager.getConnection(request);
				boolean chkk=false;
				String p_desc ="";
				String p_cause_indicator="";
				String p_record_type="";
				String sql="";
				//out.println("<script language=javascript>alert('  p_scheme = "+p_scheme+"')</script>");
				if (p_scheme.equals("3"))
				{
					sql="Select cpt_code,short_desc from mr_cpt_code where cpt_code = ?";
						
					stmt = con.prepareStatement(sql);
					stmt.setString(1,p_code);
					rs = stmt.executeQuery();
					if (rs.next())
					{
						chkk=true;
						p_desc  = rs.getString("short_desc");
						
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block6Bytes, _wl_block6);

						//out.println(a1);
						if(rs != null)rs.close();
						if(stmt != null)stmt.close();
					}else{
						out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body onKeyDown = 'lockKey()' CLASS='MESSAGE'>"+
										   "<script>"+
							"top.content.workAreaFrame.frame2.document.forms(0).code.focus();"+
							"top.content.workAreaFrame.frame2.document.forms(0).code.select();"+
							"document.write('OP0017 - Invalid procedure code')"+
							"</script></body><html>");
					}

				}//Here
				else if (p_scheme.equals("4") || p_scheme.equals("6")){
					sql="Select diag_code,short_desc,record_type,cause_indicator from mr_icd_code where record_type='O' and diag_code = ?";

					stmt = con.prepareStatement(sql);
					stmt.setString(1,p_code);
					rs = stmt.executeQuery();
					if(rs!=null){
						if(rs.next())
						{
							chkk=true;
							p_desc  = rs.getString("short_desc");
							p_record_type=rs.getString("record_type");
							p_cause_indicator=rs.getString("cause_indicator");
							
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_record_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_cause_indicator));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

									//out.println(a1);
									if(rs != null)rs.close();
									if(stmt != null)stmt.close();
						}
					}

					if(!chkk)
					{
							out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body onKeyDown = 'lockKey()' CLASS='MESSAGE'>"+
							"<script>"+
								"top.content.workAreaFrame.frame2.document.forms(0).description.value='' ;"+
								"top.content.workAreaFrame.frame2.document.forms(0).code.focus();"+
								"top.content.workAreaFrame.frame2.document.forms(0).code.select();"+
								"document.write('OP0017 - Invalid procedure code')"+
								"</script></body><html>");
					}
				}//else ends
			}else if (!(term_set_id.equals("") && term_code.equals(""))){		
				con=ConnectionManager.getConnection(request);
			
				boolean rs_chkk=false;
				String long_desc ="";
				String short_desc="";
			
				String term_code_sql="";

				if (!term_code.equals(""))
				{
					term_code_sql="select term_code,short_desc ,long_desc from mr_term_code where term_set_id like upper(?) and term_code like upper(?)";
					stmt = con.prepareStatement(term_code_sql);
					stmt.setString(1,term_set_id);//term_set_id
					stmt.setString(2,term_code);//term_code
					rs = stmt.executeQuery();
					if(rs.next())
					{
						rs_chkk=true;
						//IN035719 starts 
						//short_desc  = rs.getString("short_desc").trim();					
						//long_desc	= rs.getString("long_desc").trim();					
						StringBuffer long_desc_ = new StringBuffer();
						StringBuffer short_desc_ = new StringBuffer();
						String short_desc_arr[] = ((String)rs.getString("short_desc")).split("\n");
						for(int i = 0; i < short_desc_arr.length; i++){
							short_desc_.append((String)(((short_desc_arr[i]).trim()).replaceAll("\n"," ")));
						}							
						String long_desc_arr[] = ((String)rs.getString("long_desc")).split("\n");
						for(int i = 0; i < long_desc_arr.length; i++){
							long_desc_.append((String)(((long_desc_arr[i]).trim()).replaceAll("\n"," ")));								
						}
						short_desc	= short_desc_.toString();
						long_desc	= long_desc_.toString();
						//IN035719 ends
						
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

						//out.println(a1);
					}
					StringBuffer a2 = new StringBuffer();
					a2.append("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script>");
				
					if(long_desc !=null && !long_desc.equals(""))
					{
						a2.append("top.content.workAreaFrame.frame2.document.forms(0).exclamation.style.visibility='visible'"	);
						
					}else{
					a2.append("top.content.workAreaFrame.frame2.document.forms(0).exclamation.style.visibility='hidden'");		
					}
					a2.append("</script></head><body onKeyDown = 'lockKey()' CLASS='MESSAGE'></body></html>");
					out.println(a2.toString());
					
					if(rs != null)rs.close();
					if(stmt != null)stmt.close();

					if(!rs_chkk)
					{
						
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
				}
			}else{
			 
            _bw.write(_wl_block16Bytes, _wl_block16);


			}
        }
        
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
	}catch(Exception e){
            //out.println(e);//common-icn-0181
	    e.printStackTrace();//COMMON-ICN-0181
            out.println("<html><head><link  rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body onKeyDown = 'lockKey()' CLASS='MESSAGE'></body>");
    }finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
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
