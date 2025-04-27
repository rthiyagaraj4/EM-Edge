package jsp_servlet._esm._jsp;

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

public final class __generateacctperiodvalpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/GenerateAcctPeriodValPopulate.jsp", 1717478662983L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t//\tparent.document.frames[1].document.forms[0].acc_per_year1.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script Language=\'Javascript\'>\n\t\tparent.document.f_query_add_mod.document.forms[0].acc_per_year1.value=\'\';\n\t\tparent.document.f_query_add_mod.document.forms[0].acc_per_year1.focus();\n\t   \talert(getMessage(\"ACC_PER_YEAR_ALREADY_EXISTS\",\'SM\'));\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t var year_scc=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\n\t\t var acc_year=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\n\t\t var year_scc1=eval(year_scc)-1;\n\t\t\n    \t var year_scc2=eval(year_scc)+1;\n\t\t var acc_start_date= parent.document.frames[1].document.forms[0].acc_per_start_date.value;\n\t//\t alert(\"acc_start_date in populate\"+acc_year in populate)\n\n\t\t/*if(acc_year==year_scc || acc_year==year_scc1 ||  acc_year==year_scc2 )\n\t\t{\n\t\t\n\t\t\tparent.document.frames[1].document.forms[0].acc_per_start_date.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\talert(getMessage(\"ACC_PER_START_DATE_VAL\",\'SM\'));\n\t\tparent.document.frames[1].document.forms[0].acc_per_start_date.value=\"\";\n\t   }*/\n\t   parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script>\n\t\t\n\t\tparent.document.frames[1].document.forms[0].acc_per_start_date.value=\"\";\n\t\tparent.document.frames[1].document.forms[0].acc_per_start_date.focus();\n\t\talert(getMessage(\"ACC_PER_DATE_ALREADY_EXISTS\",\'SM\'));\n\t\t parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\n\t\t\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\n";
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

	
	
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt1=null;
	ResultSet rs1 = null;
	String acc_yr="";
	String acc_dt="";
	String acc_dt1="";
	String count="";
	String date="";
	String month="";
	String year="";
	String acc_mon1="";
	String acc_yr1="";

		acc_yr = request.getParameter("acc_per_year1");
		if(acc_yr==null) acc_yr="";

		acc_dt = request.getParameter("acc_per_start_dt");
		if(acc_dt==null) acc_dt="";
		count=request.getParameter("count");
		if(count==null) count="";


		acc_yr=acc_yr.trim();
		acc_dt=acc_dt.trim();


		acc_yr1=DateUtils.convertDate(acc_yr,"YY",localeName,"en");
		acc_dt1=DateUtils.convertDate(acc_dt,"DMY","en",localeName);

		StringTokenizer str=new StringTokenizer(acc_dt1,"/");
		   if (str.hasMoreTokens()) {
			date=str.nextToken();

			month=str.nextToken();
			month = DateUtils.convertDate(month,"MM",localeName,"en");
			
			year=str.nextToken();
			year = DateUtils.convertDate(year,"YY",localeName,"en");
			acc_mon1=date+'/'+month+'/'+year;
			}

	try
	{
	con = ConnectionManager.getConnection(request);

	try
		{

		if(count.equals("year"))
		{
			
			String st ="select * from sy_acc_period_defn where acc_per_year='"+acc_yr1+"'";	
			pstmt = con.prepareStatement(st);

			rs=pstmt.executeQuery();					
			if(!rs.next())
			{	
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(acc_yr.trim()));
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		else
		{
	  
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	}
	
	//out.println("count"+count);
	if(count.equals("date"))
	{
		String st1 ="select * from sy_acc_period_defn where trunc(acc_per_start_date) = trunc(to_date('"+acc_dt+"','dd/mm/yyyy'))";	
			
			pstmt1 = con.prepareStatement(st1);
			rs1 = pstmt1.executeQuery();
			if(!rs1.next())
			{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(year));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(acc_yr));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(acc_mon1.trim()));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
		else
			{
	
            _bw.write(_wl_block14Bytes, _wl_block14);

			}

	}
}
		catch (Exception e)
		{
		}
		finally{
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}

	}catch(Exception e){out.println(e);}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
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
