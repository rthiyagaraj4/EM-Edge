package jsp_servlet._emp._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __mpstillbirthdetailsval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MPStillBirthDetailsVal.jsp", 1709118634291L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eMP/js/MPStillBirthDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<BODY class=\'message\' onKeyDown = \'lockKey()\'>\n\t<form>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[0].document.forms[0].age.value =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tparent.frames[0].document.forms[0].licenseNo.value =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t</script>\t\n\t\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\teval(\"parent.frames[0].document.forms[0].stillBirthDate\"+";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =").value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\t\t</script>\t\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =").value =\"\";\n\t\t\t\t\t\t\t\t</script>\t\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[0].document.forms[0].val_done.value =\"Y\";\n\t\t\t</script>\t\n\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</form>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t</body>\n\t</html>\t \n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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

		Connection con						 =  null;
		ResultSet rs 						 =	null;
		PreparedStatement pstmt				 =	null; 

		request.setCharacterEncoding("UTF-8");
	    String locale						=	(String)session.getAttribute("LOCALE");
		String attend_physician_id			=	checkForNull(request.getParameter("attend_physician_id"));
		String pract_flag					=	checkForNull(request.getParameter("pract_flag"));
		String dateformate_flag				=	checkForNull(request.getParameter("dateformate_flag"));
		String stillBirthDates				=	checkForNull(request.getParameter("stillBirthDates"));
		String RecordedDates				=	checkForNull(request.getParameter("RecordedDates"));
		String age							=	"";
		String apc_no						=	"";
		String age_val1                     =   "";
		String year1						=	"";
		String month1						=	"";
		String day1							=	"";
		String hour1						=	"";
		String dateFormat1					=	"";
		StringBuffer sqlPract				=	null;
		StringBuffer sqlDate				=	null;

	
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try
	{
	   con					      = ConnectionManager.getConnection(request);

	if(pract_flag!=null)
		{
		    if(pract_flag.equals("Y"))
			{
			   if(attend_physician_id!=null)
				{
					if(!attend_physician_id.equals(""))
					{
					  sqlPract = new StringBuffer();
					  sqlPract.append("select  get_age(date_of_birth) age,apc_no from am_practitioner_lang_vw where practitioner_id = ? and language_id = '"+locale+"' ");
					  pstmt   = con.prepareStatement(sqlPract.toString());
					  pstmt.setString(1, attend_physician_id);

					  rs		 = pstmt.executeQuery();
					  if(rs!=null && rs.next())
					  {		
						age						= checkForNull(rs.getString("age"));
						apc_no                  = checkForNull(rs.getString("apc_no")); 
					  }//End of if
					if(!age.equals("")) 
					{
						int age_val = age.indexOf("Y");
						age_val1 = age.substring(0,age_val);
				   }
				  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(age_val1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apc_no));
            _bw.write(_wl_block11Bytes, _wl_block11);

					  if(pstmt!=null) pstmt.close();
					  if(rs!=null) rs.close(); 
					  if((sqlPract != null) && (sqlPract.length() > 0))
					  {
						sqlPract.delete(0,sqlPract.length());
					  } 
				  }
				} 
	}
  }
  if(dateformate_flag!=null)
	{
		if(dateformate_flag.equals("Y"))
		{
			sqlDate = new StringBuffer();

			StringTokenizer date1 = new StringTokenizer(stillBirthDates,"#");
			StringTokenizer date2_ref = new StringTokenizer(RecordedDates,"#");

			int i = 0;
			sqlDate.append("select CALCULATE_DATE_OF_BIRTH_YMDH (?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi')) from dual"); // to be changed

			pstmt   = con.prepareStatement(sqlDate.toString());


			while(date1.hasMoreTokens()){
				i++;
				String dd = date1.nextToken();
				String dd_ref = date2_ref.nextToken();  // to be passed to procedure

				StringTokenizer date2 = new StringTokenizer(dd,"^");
					
					while(date2.hasMoreTokens()){
						year1  =date2.nextToken();
						month1 =date2.nextToken();
						day1   =date2.nextToken();
						hour1  =date2.nextToken();
						
						pstmt.setString(1, year1);
						pstmt.setString(2, month1);
						pstmt.setString(3, day1);
						pstmt.setString(4, hour1);
						pstmt.setString(5, dd_ref);							

						boolean entered=true;

						if(year1.equals("0") && month1.equals("0") && day1.equals("0")){
							if( i<=4){
								if(hour1.equals("0")){
									entered=false;
								}
							}else{
								entered=false;
							}

						}
						
							
						if(entered){

								rs = pstmt.executeQuery();

								if (rs != null){
									rs.next();
									dateFormat1 = rs.getString(1);
								}

								
								
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dateFormat1));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}else{
							
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);

						}


				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
	}
}
catch(Exception e){ e.toString(); }
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
