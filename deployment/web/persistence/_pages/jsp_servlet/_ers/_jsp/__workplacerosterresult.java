package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __workplacerosterresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/WorkplaceRosterResult.jsp", 1709121673714L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tKarabi S.\n*\tCreated On\t\t:\t02 Dec 2004\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eRS/html/RSStylesheet.css\'></link>\n -->\n\n <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script> \n <script src=\"../../eOP/js/Validate.js\" language=\"javascript\"></script>\n<!-- <script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script> -->\n<Script src=\"../../eOA/js/Validate1.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\"onKeyDown = \'lockKey()\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<! -- USH CHECK-OUT -->\n\n<table border=0 width=\'99%\' >\n<tr>\n<td width=\'13%\' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td width=\'7%\' align=right class=ush colspan=2 nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</td>\n\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td width=\'7%\' colspan=2 align=centre class=ush nowrap>&nbsp;&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td width=\'7%\' colspan=2 align=centre class=ush nowrap>&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td width=\'2%\' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</tr>\n</table>\n<table border=1 width=\'99%\'  id=\'colors\'>\n<tr>\n<form name=\'calender1\' id=\'calender1\'>\n<td  align=\"left\" class=\"Day\" width=\"13%\" nowrap><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type=\'hidden\' name=\'u1\' id=\'u1\' value=\'u1\'>\n</td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<td class=\"Day\" width=\"3.5%\" title=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" align=\'center\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</td><input type=\'hidden\' name=\'\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\' id=\'\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\' value=\'\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\'>\n</td>\t\t\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<td class=\"Emptycell\" width=\"3.5%\" align=\"middle\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</form>\n</tr>\n<tr>\n<form name=\'calender1\' id=\'calender1\'>\n<td  align=\"left\" class=\"Day\" width=\"3.5%\" nowrap><b>\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  <input type=\'hidden\' name=\'u1\' id=\'u1\' value=\'u1\'></b></td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" align=\'center\'>&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;\n</td><input type=\'hidden\' name=\'\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<td class=\"Emptycell\" width=\"3.5%\" align=\'center\'>&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</form>\n</tr>\n<form name=\'calender\' id=\'calender\'>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n<tr>\n<td class=\'WRKPV\' width=\'3%\' nowrap><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<td class=\"EmptyCell\" width=\'3%\' align=\'center\' id=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<td class=\"EmptyCell\" id=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\'3%\'>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n</tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</form>\n<script>\nparent.parent.frames[2].frames[0].document.forms[0].p_from_date.value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\nparent.parent.frames[2].frames[0].document.forms[0].p_to_date.value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\nparent.parent.frames[2].frames[0].document.forms[0].p_end.value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</form>\n</body>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
            webbeans.eCommon.RecordSet apptRecordSet= null;synchronized(session){
                apptRecordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("apptRecordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(apptRecordSet==null){
                    apptRecordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("apptRecordSet",apptRecordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

try{
String sch_date="";
String facility_id	=(String)session.getValue( "facility_id" ) ;
String sql_workplace_roster_det="";
String mode	   = request.getParameter("mode") ;
String function_id = request.getParameter( "function_id") ;
String workplace_code= request.getParameter("workplace_code");
String from_date = request.getParameter( "from_date") ;
String to_date= request.getParameter("to_date");
String new_todate=request.getParameter("new_todate");
String next_fromdate=request.getParameter("next_fromdate");
String onclick_of=request.getParameter("onclick_of");

	if(mode ==null) mode="";
	if(function_id ==null) function_id="";
	if(workplace_code ==null) workplace_code="";
	if(from_date ==null) from_date="";
	if(to_date ==null) to_date="";
	if(new_todate ==null) new_todate="";
	if(next_fromdate ==null) next_fromdate="";
	

request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;
PreparedStatement stmt_workplace_roster_det =null;
ResultSet rs_workplace_roster_det=null;
CallableStatement statement2 = null;
try{
try{
		con = ConnectionManager.getConnection(request);
		statement2=con.prepareCall("{call Rs_Get_Dd_Day_String(?,?,?,?,?,?,?,?,?,?)}");
		statement2.setString( 1, from_date) ;
		statement2.setString( 2, to_date) ;
		statement2.setString( 3, onclick_of) ;
		statement2.setString( 4, next_fromdate) ;
		statement2.setString( 5, new_todate) ;
		statement2.registerOutParameter(6,Types.VARCHAR) ;
		statement2.registerOutParameter(7,Types.VARCHAR) ;
		statement2.registerOutParameter(8,Types.VARCHAR) ;
		statement2.registerOutParameter(9,Types.VARCHAR) ;
		statement2.registerOutParameter(10,Types.VARCHAR) ;
		statement2.execute() ;
		}catch(Exception e) {
			e.printStackTrace();
		}
			String date_day = statement2.getString(6);
			String mon_year = statement2.getString(7);
			String new_from_date = statement2.getString(8);
			String new_to_date = statement2.getString(9);
			String end_ind = statement2.getString(10);
				
            if (date_day==null) date_day="";
            StringTokenizer d_token = new StringTokenizer(date_day, "~");
			int d_counter=d_token.countTokens();
			String d_code[]=new String[d_counter];
			String d_code1[]=new String[d_counter];
			String d_code2[]=new String[d_counter];
			int d_track=0;
			while (d_token.hasMoreTokens())
			{
			d_code[d_track]=d_token.nextToken();
			StringTokenizer d_token1 = new StringTokenizer(d_code[d_track], "-");
			d_code1[d_track]=d_token1.nextToken();
			d_code2[d_track]=d_token1.nextToken();
			d_track++;
			}

			StringTokenizer mm_year = new StringTokenizer(mon_year, "|");
			int yy1=mm_year.countTokens();
			String mm_yy[]=new String[yy1];
			int d_track1=0;
			String cc4="0";
			String cc3="0";
			int d_diff1=0;
			int d_diff2=0;
			while (mm_year.hasMoreTokens())
			{
			mm_yy[d_track1]=mm_year.nextToken();
			d_track1++;
			}
			
			if(yy1>2){
				if(mm_yy[3] !=null)
				{
				cc3=mm_yy[3];
				d_diff1=Integer.parseInt(cc3);
				}
			}
			if(yy1>4){
				if(mm_yy[5] !=null)
				{
				cc4=mm_yy[5];
				d_diff2=Integer.parseInt(cc4);
				}
			}

			int d_diff=Integer.parseInt(mm_yy[1]);
					
			sql_workplace_roster_det="select a.Staff_Id, b.staff_name,to_char(a.schedule_date,'dd/mm/yyyy') sch_date,a.shift_mnemonic,(trunc(schedule_date)- trunc(to_date(?,'dd/mm/yyyy'))) cell_no,a.role_type role_type  from 	rs_work_schedule a, am_staff_vw b where a.facility_id = ? and	a.workplace_code = ? and	a.schedule_date between to_date(?,'dd/mm/yyyy') and	to_date(?,'dd/mm/yyyy') and	b.role_type = a.role_type and  b.staff_id = a.staff_id order by b.staff_name, a.schedule_date ";


		try
	    {
		stmt_workplace_roster_det=con.prepareStatement(sql_workplace_roster_det);
		stmt_workplace_roster_det.setString(1,new_from_date);
		stmt_workplace_roster_det.setString(2,facility_id);
		stmt_workplace_roster_det.setString(3,workplace_code);
		stmt_workplace_roster_det.setString(4,new_from_date);
		stmt_workplace_roster_det.setString(5,new_to_date);
		rs_workplace_roster_det=stmt_workplace_roster_det.executeQuery();
		}
		catch(Exception exp)
	    {
			out.println(exp.toString());
	    }

            _bw.write(_wl_block8Bytes, _wl_block8);

for(int p=0;p<14;p++)
{
	if( p == d_diff ){
		String te1=mm_yy[0].substring(0,4)+com.ehis.util.DateUtils.convertDate(mm_yy[0].substring(4),"YY","en",locale);
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(te1));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if( d_diff1 !=0 && p == d_diff1){
		String te2=mm_yy[2].substring(0,4)+com.ehis.util.DateUtils.convertDate(mm_yy[2].substring(4),"YY","en",locale);
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(te2));
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
	else if( d_diff2 !=0 && p == d_diff2){
		String te3=mm_yy[4].substring(0,4)+com.ehis.util.DateUtils.convertDate(mm_yy[4].substring(4),"YY","en",locale);
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(te3));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else
	{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
}

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

for(int u=0;u<d_track;u++){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
for(int u=0;u<(14-d_track);u++){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

for(int u=0;u<d_track;u++){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
for(int u=0;u<(14-d_track);u++){
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);

int cell=0;
String sch_date1="";
String sh_mnemonic="";
String	st_temp = "";
String st = "";
String m[]=new String[14];
String mm[]=new String[14];
int cell_no1[]=new int[100];
int hh=0;
String role_type="";
String role_type1="";

if(rs_workplace_roster_det.next())
{
String flag = "1";
st = rs_workplace_roster_det.getString("Staff_Id");
st_temp = st;

while(flag.equals("1"))
{		

	for(int q = 0; q<14; q++)
	cell_no1[q] = -1;
	while (st_temp.equals(st) && flag.equals("1"))
	{ 
		cell = Integer.parseInt(rs_workplace_roster_det.getString("cell_no"));
		cell_no1[cell]=cell;
		mm[cell] = rs_workplace_roster_det.getString("shift_mnemonic");
		role_type = rs_workplace_roster_det.getString("role_type");
		sch_date = rs_workplace_roster_det.getString("sch_date");

     if(sch_date.equals(sch_date1)&&role_type.equals(role_type1))
     {
	 	m[cell] = sh_mnemonic+"|"+mm[cell];
     }
     else
     {
		m[cell] = mm[cell];
     }
		role_type1 = role_type;
		sch_date1 = sch_date;
		sh_mnemonic = mm[cell];
		
		if (rs_workplace_roster_det.next())
		{
			st = rs_workplace_roster_det.getString("Staff_Id");
     	}
		else
		{
			flag = "0";		
		}
	
	}

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(st_temp));
            _bw.write(_wl_block31Bytes, _wl_block31);

for(int kkk=0;kkk<14;kkk++)
{
   if(cell_no1[kkk]==kkk ){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(kkk));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(m[kkk]));
            _bw.write(_wl_block34Bytes, _wl_block34);

}
else
{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(kkk));
            _bw.write(_wl_block36Bytes, _wl_block36);
				
}
}
/*		build the table using the string*/
for(int kkk=0;kkk<14;kkk++){
	m[kkk] ="&nbsp;";
}
	st_temp = st;
            _bw.write(_wl_block37Bytes, _wl_block37);

		hh++;		
		}
}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(new_from_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(new_to_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(end_ind));
            _bw.write(_wl_block41Bytes, _wl_block41);

}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
try
{
if(statement2 !=null) statement2.close();
if(rs_workplace_roster_det !=null) rs_workplace_roster_det.close();
if(stmt_workplace_roster_det !=null) stmt_workplace_roster_det.close();
ConnectionManager.returnConnection(con,request);
}
catch(Exception exp)
{
	out.println(exp.toString());
}
}

            _bw.write(_wl_block42Bytes, _wl_block42);
 
	} 
catch(Exception e) 
{
	e.printStackTrace();
} 
finally
{

}

            _bw.write(_wl_block43Bytes, _wl_block43);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Staff.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
