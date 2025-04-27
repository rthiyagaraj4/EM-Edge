package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __timetablebreak extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TimeTableBreak.jsp", 1709119279646L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n<!--\n\tDeveloped by \t:\tR.Nanda Kumar\n\tCreated on \t:\t17/02/2001\n\tModule\t\t:\tOA\n\tFunction\t:\tThis function is used to maintain Break Time\n\t\t\t\tof the Time Table Function.\n-->\n \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<HTML>\n\t<HEAD>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"> </link>\n\t -->";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"> </script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"> </script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"> \t\t</script>\n\t<script language=\"javascript\" src=\"../../eOA/js/TimeTable.js\">\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</HEAD>\n\t<BODY OnMouseDown=\"CodeArrest()\"onKeyDown = \'lockKey()\' >\n\t<FORM name=\"TimeTableBreak\" id=\"TimeTableBreak\">\n\n\n\n\t<TABLE WIDTH=\'100%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'>\n\t<TR>\n\t<TD CLASS=\'BORDER\'>\n\t<TABLE WIDTH=\'250%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'  ALIGN=\'CENTER\'>\n\t\t<TR>\n\t\t\t<TD class=\'BORDER\'>\n\t\t\t\t<TABLE WIDTH=\'100%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\' ALIGN=\'CENTER\'>\n\t\t\t\t\t<TH align=\'left\'>Break Time</TH>\n\t\t\t\t</TABLE>\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n\n\t<TABLE WIDTH=\'100%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'  ALIGN=\'CENTER\'>\n\n\t\t<TR>\n\t\t\t<TD class=\"label\" align=\'right\' width=\'34%\'>&nbsp;&nbsp;</TD>\n\t\t\t<TD class=\"label\" align=\'left\' width=\'10%\' >&nbsp;&nbsp;&nbsp;From Time</TD>\n\t\t\t<TD class=\"label\" align=\'right\' width=\'10%\'>&nbsp;</TD>\n\t\t\t<TD class=\"label\" align=\'left\' width=\'46%\' >&nbsp;&nbsp;&nbsp;To Time </TD>\n\t\t</TR>\n\n\t</TABLE>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<TABLE WIDTH=\'100%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'  ALIGN=\'CENTER\'>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t<TR>\n\t\t\t<TD class=\"label\" align=\'right\' width=\'34%\'>&nbsp;&nbsp;</TD>\n\t\t\t<TD class=\"label\" align=\'left\' width=\'10%\' >&nbsp;&nbsp;\n\t\t\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'b_from_time";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' id=\'b_from_time";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\t\tonKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\")\'\n\t\t\tonBlur=\'ChkTime(this);CallFromBreakTimeValidation(this,\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="); \'></TD>\n\n\t\t\t<TD class=\"label\" align=\'right\' width=\'10%\'>&nbsp;</TD>\n\t\t\t<TD class=\"label\" align=\'left\' width=\'46%\' >&nbsp;&nbsp;\n\t\t\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'b_to_time";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' id=\'b_to_time";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' \n\t\t\tonKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\'\n\t\t\tonBlur=\'validateBkTime(\"document.forms[0].b_from_time";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",this,";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =");\' ></TD>\n\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</TABLE>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<TR>\n\t\t\t\t<TD class=\"label\" align=\'right\' width=\'33%\'>&nbsp;&nbsp;</TD>\n\t\t\t\t<TD class=\"label\" align=\'left\' width=\'10%\' >&nbsp;&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t <INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'b_from_time";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' VALUE=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'\n\t\t\t\t\t\tonKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\")\'\n\t\t\t\t\t onBlur=\'ChkTime(this);CallFromBreakTimeValidation(this,";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =");\'></TD>\n\n\t\t\t\t\t <TD class=\"label\" align=\'right\' width=\'10%\'>&nbsp;</TD>\n\t\t\t\t\t <TD class=\"label\" align=\'left\' width=\'45%\' >&nbsp;&nbsp;\n\t\t\t\t\t <INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'b_to_time";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'\t\n\t\t\t\t\t onKeyUp=\'javascript:formatBreakFrToTime(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\")\'onBlur=\'validateBkTime(\"document.forms[0].b_from_time";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =");\'></TD>\n\t\t\t\t\t </TR>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t</TABLE>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</TD>\n</TR>\n</TABLE>\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

		Connection con = null;
		Statement stmt   	= null ;
		ResultSet rs	   	= null;
try {
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String p_clinic_code	= request.getParameter("clinic_code") ;
		String p_pract_id	= request.getParameter("pract_id") ;if(p_pract_id == null || p_pract_id.equals("null")) p_pract_id="";
		String p_day_no		= request.getParameter("day_no") ;
		String p_disp		= request.getParameter("disp") ;
		StringBuffer sql		=new StringBuffer() ;

		if (p_disp.equals("M"))
		{
			sql 	= sql.append("select to_char(break_start_time,'hh24:mi')start_time,to_char(break_end_time,'hh24:mi')end_time from oa_clinic_break where clinic_code = '"+p_clinic_code+"' and ");
			sql=sql.append( "day_no = '"+p_day_no+"' and nvl(practitioner_id,'X') = nvl('"+p_pract_id+"','X') and facility_id = '"+fac_id+"' order by 1,2 ") ;
			rs	= stmt.executeQuery(sql.toString()) ;
		}


            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		if (p_disp.equals("A"))
		{

            _bw.write(_wl_block5Bytes, _wl_block5);

			int i = 1;
			for( i=1;i<6;i++)
			{
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(i));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
		
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	else if (p_disp.equals("M"))
	{


            _bw.write(_wl_block5Bytes, _wl_block5);

			int i = 1;
			String fr="";
			String to="";
			boolean bool=true;
			for( i=1;i<6;i++)
			{
		
            _bw.write(_wl_block17Bytes, _wl_block17);

					   if(bool  && rs.next())
					   {
					   	fr=rs.getString("start_time");
					   	to=rs.getString("end_time");
						
					   }
					   else
					   {
					   	fr="";
					   	to="";
					   	bool=false;
					
					   }
						
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fr));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
			
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_disp));
            _bw.write(_wl_block28Bytes, _wl_block28);

	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
