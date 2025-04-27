package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;

public final class __nataltiddob extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/natAltIdDOB.jsp", 1742374855645L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t <script>\n\t\tvarFrameRef = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\tvar op_call = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\tif(op_call == \"reg_pat\" || op_call ==\"ae_reg_pat\")\n\t\t\tvarFrameRef = \"parent.frames[1].frames[0]\";\n\t\tvar obj =eval(varFrameRef).document.getElementById(\'ethnic_group\');\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) {obj.remove(0);}\n\t\tvar element1 = eval(varFrameRef).document.createElement(\'OPTION\');\n\t\telement1.text = \" ------- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ------- \";\n\t\telement1.value= \"\";\n\t\teval(varFrameRef).document.getElementById(\'ethnic_group\').add(element1);\t\n\t\t</script> \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\n\t\t\t\t\t <script>\n\t\t\t\t\tvar element = eval(varFrameRef).document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\teval(varFrameRef).document.getElementById(\'ethnic_group\').add(element);\t\n\t\t\t\t\t</script> \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block2Bytes, _wl_block2);

		String pr_id = request.getParameter("process_id");
		String strFrameRef = request.getParameter("bodyFrameRef");
		String op_call = request.getParameter("op_call");
		
		
		
		if(op_call == null) op_call="";
		int process = Integer.parseInt(pr_id);		
			Connection con = null;
			Statement stmt = null;
			Statement stmt1 = null;
			ResultSet rs = null;
			ResultSet rset = null;
try{
		con = ConnectionManager.getConnection(request);
	//Getting Date of Birth Function
	if ( process == 1 )
	{
		     if(op_call.equals("reg_pat")||op_call.equals("ae_reg_pat"))
					 strFrameRef = "parent.frames[1].frames[0]";
				stmt = con.createStatement();
		
			    int DAYS,MONTHS,AGE;

				int  maxAge		= Integer.parseInt(checkForNull(request.getParameter("maxAge")));				

				String DOB		= checkForNull(request.getParameter("date_of_birth"));
				String DateStr	= DOB;
				if (!localeName.equals("en"))
				{
					DateStr = DateUtils.convertDate(DOB,"DMY",localeName,"en"); 
				}

				String sql = "select calculate_age('"+DateStr+"',1) AGE, calculate_age('"+DateStr+"',2) MONTHS, calculate_age('"+DateStr+"',3) DAYS from dual";
				
				rs = stmt.executeQuery(sql);
				rs.next();
				AGE = rs.getInt("AGE");
				MONTHS = rs.getInt("MONTHS");
				DAYS = rs.getInt("DAYS");
				
				String htmlVal ="";
				
				if(AGE > maxAge) {
					 htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>var m_age = eval("+strFrameRef+").document.getElementById('max_patient_age').value;msg = getMessage('MAX_PATIENT_AGE','MP');msg = msg.replace('#', '$');msg= msg+' '+m_age+' '+ getLabel('Common.Years.label','common');alert(msg);eval("+strFrameRef+").document.getElementById('b_age').value = '';eval("+strFrameRef+").document.getElementById('date_of_birth').focus();eval("+strFrameRef+").document.getElementById('b_age').value='';eval("+strFrameRef+").document.getElementById('b_months').value='';eval("+strFrameRef+").document.getElementById('b_days').value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>";
					 out.println(htmlVal);
				} else if ((AGE == maxAge) && ((MONTHS > 0) ||  (DAYS > 0)) ) {			

					htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>var m_age = eval("+strFrameRef+").document.getElementById('max_patient_age').value;msg = getMessage('MAX_PATIENT_AGE','MP');msg = msg.replace('#', '$');msg= msg+' '+m_age+' '+ getLabel('Common.Years.label','common');alert(msg);eval("+strFrameRef+").document.getElementById('b_age').value = '';eval("+strFrameRef+").document.getElementById('date_of_birth').focus();eval("+strFrameRef+").document.getElementById('b_age').value='';eval("+strFrameRef+").document.getElementById('b_months').value='';eval("+strFrameRef+").document.getElementById('b_days').value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>"; 				
					out.println(htmlVal);					
				} else {
					htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>eval("+strFrameRef+").document.getElementById('b_age').value='"+AGE+"';eval("+strFrameRef+").document.getElementById('b_months').value='"+ MONTHS +"';eval("+strFrameRef+").document.getElementById('b_days').value='"+DAYS+"';"+"</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>";	out.println(htmlVal);
				}
	}
	if ( process == 2 )
		{
			stmt1 = con.createStatement();

			String DAYS,MONTHS,AGE;
		
			DAYS = checkForNull(request.getParameter("b_days"));
			MONTHS = checkForNull(request.getParameter("b_months"));
			AGE = checkForNull(request.getParameter("b_age"));
	
			if ( DAYS.equals("") )
				DAYS = "null";
			if ( MONTHS.equals("") )
				MONTHS = "null";
			if ( AGE.equals("") )
				AGE = "null";

			String DOB = "";
			String sql1 = "select calculate_date_of_birth ("+AGE+","+MONTHS+","+DAYS+") from dual";
			rset = stmt1.executeQuery(sql1);
			if (rset != null)
			{
				rset.next();
		        DOB = rset.getString(1);
			}

			if ( DOB !=null && !DOB.equals("") )
			{
				if (!localeName.equals("en"))
				{
					DOB = DateUtils.convertDate(DOB,"DMY","en",localeName); 
				}
			}

			if(op_call.equals("reg_pat")||op_call.equals("ae_reg_pat"))
					 strFrameRef = "parent.frames[1].frames[0]";

			String  htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>if(eval("+strFrameRef+").document.getElementById('date_of_birth')!=null){			eval("+strFrameRef+").document.getElementById('date_of_birth').value='"+DOB+"';}</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value='"+DOB+"'</body></html>";
			
			out.println(htmlVal);
			if(stmt1!=null) stmt1.close();
			if(rset!=null) rset.close();
	}
	if ( process == 3 )
    {	
		stmt1 = con.createStatement();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strFrameRef));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(op_call));
            _bw.write(_wl_block8Bytes, _wl_block8);
		
		String race_code = request.getParameter("race_code");
		if(race_code == null) race_code="";
		if(!race_code.equals(""))
		{
			String sql = "Select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where language_id = '"+locale+"' and race_code='"+race_code+"' and eff_status='E'   order by 2";
		
			rset = stmt1.executeQuery(sql);
					
			if(rset!=null)
			{
				while (rset.next())
				{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rset.getString("long_desc")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rset.getString("ethnic_group_code")));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
				}
			}
		 }	
			String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'></body></html>";
			out.println(htmlVal);
	}
}catch(Exception e) {/*  out.println(e.toString()); */ e.printStackTrace();}
finally
{
	if (rs != null) rs.close();
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
