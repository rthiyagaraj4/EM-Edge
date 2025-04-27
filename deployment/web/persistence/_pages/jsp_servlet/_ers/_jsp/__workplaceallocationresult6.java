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

public final class __workplaceallocationresult6 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/WorkplaceAllocationResult6.jsp", 1709121670042L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eRS/html/RSStylesheet.css\'></link>\n --><Script src=\"../../eOP/js/Validate.js\" language=\"javascript\"></Script>\n<!-- <script src=\'../../eOA/js/oamessages.js\' language=\'javascript\'></script> -->\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\"../../eOA/js/Validate1.js\" language=\"javascript\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body >\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table border=0 width=\'99%\' >\n<tr>\n<td width=\'13%\' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td width=\'7%\' align=right class=ush colspan=2 nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</td>\n\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td width=\'7%\' colspan=2 align=centre class=ush nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td width=\'2%\' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n</tr>\n</table>\n\n\n<table border=1 width=\'99%\'  id=\'colors\'>\n\t<tr>\n<form name=\'calender1\' id=\'calender1\'>\n\n\t\t<td  align=\"left\" class=\"Day\" width=\"13%\" nowrap><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type=\'hidden\' name=\'u1\' id=\'u1\' value=\'u1\'>\n\t\t</td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<td class=\"Day\" width=\"3.5%\" title=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" align=\'center\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</td><input type=\'hidden\' name=\'\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"\' id=\'\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\' value=\'\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\'>\n</td>\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<td class=\"EmptyCell\" width=\"3.5%\" align=\"middle\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</form>\n</tr>\n<tr>\n<form name=\'calender1\' id=\'calender1\'>\n\n\t\t<td  align=\"left\" class=\"Day\" width=\"3.5%\" nowrap><b>\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  <input type=\'hidden\' name=\'u1\' id=\'u1\' value=\'u1\'></b></td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\n\t<td class=\"Day\" width=\"3.5%\" title=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" align=\'center\'>&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;\n\t</td><input type=\'hidden\' name=\'\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"\'>\n\n</td>\t\t\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<td class=\"EmptyCell\" width=\"3.5%\" align=\'center\'>&nbsp;&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</form>\n</tr>\n<form name=\'calender\' id=\'calender\'>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<tr\t>\n\t\t<td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' width=\'3%\' nowrap><b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<td class=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" width=\'3%\' align=\'center\' id=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<td  class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" width=\'3%\'>&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t</tr> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n</form>\n<script>\nparent.parent.frames[2].frames[0].document.forms[0].p_from_date.value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'\nparent.parent.frames[2].frames[0].document.forms[0].p_to_date.value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'\nparent.parent.frames[2].frames[0].document.forms[0].p_end.value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'\n</script>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</form>\n</body>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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

/*
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	WorkPlaceAllocationResult6.jsp
*	Purpose 		:
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	13 Dec 2004
*/

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
	String sql_position_aclloc_det="";
	String facility_id = request.getParameter( "facility_id") ;
	String locn_type= request.getParameter("locn_type");
	String workplace_code=request.getParameter("workplace_code");
	String group_by=request.getParameter("group_by");
	String view_opt=request.getParameter("view_opt");
	String from_date = request.getParameter( "from_date") ;
	String to_date= request.getParameter("to_date");
	String new_todate=request.getParameter("new_todate");
	String next_fromdate=request.getParameter("next_fromdate");
	String onclick_of=request.getParameter("onclick_of");
	

	if(facility_id ==null) facility_id="";
	if(locn_type ==null) locn_type="";
	if(workplace_code ==null) workplace_code="";
	if(group_by ==null) group_by="";
	if(view_opt ==null) view_opt="";
	if(from_date ==null) from_date="";
	if(to_date ==null) to_date="";
	if(new_todate ==null) new_todate="";
	if(next_fromdate ==null) next_fromdate="";
	

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;
PreparedStatement stmt_position_aclloc_det =null;
ResultSet rs_position_aclloc_det=null;
CallableStatement cstmt =null;
try{
try{
		con = ConnectionManager.getConnection(request);
		cstmt=con.prepareCall("{call Rs_Get_Dd_Day_String(?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString( 1, from_date) ;
		cstmt.setString( 2, to_date) ;
		cstmt.setString( 3, onclick_of) ;
		cstmt.setString( 4, next_fromdate) ;
		cstmt.setString( 5, new_todate) ;
		cstmt.registerOutParameter(6,Types.VARCHAR) ;
		cstmt.registerOutParameter(7,Types.VARCHAR) ;
		cstmt.registerOutParameter(8,Types.VARCHAR) ;
		cstmt.registerOutParameter(9,Types.VARCHAR) ;
		cstmt.registerOutParameter(10,Types.VARCHAR) ;
		cstmt.execute() ;
		}catch(Exception e) {
			e.printStackTrace();
		}
			String date_day = cstmt.getString(6);
			String mon_year = cstmt.getString(7);
			String new_from_date = cstmt.getString(8);
			String new_to_date = cstmt.getString(9);
			String end_ind = cstmt.getString(10);

			if(cstmt!=null) cstmt.close();
			
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

			//sql_position_aclloc_det="select am_position.position_desc position_desc, trunc(schedule_date) sch_date,(trunc(schedule_date)- to_date(?,'dd/mm/yyyy')) cell_no,	sum(required_staff) required_staff,	sum(allocated_staff) allocated_staff  from rs_work_schedule_summ, am_position, am_shift  where facility_id =?  and (? is null or workplace_code = ?) and schedule_date between to_date(?,'dd/mm/yyyy')	and (to_date(?,'dd/mm/yyyy')) and am_position.position_code = rs_work_schedule_summ.position_code  and am_shift.shift_code = rs_work_schedule_summ.shift_code  and am_shift.shift_indicator = 'P' group by am_position.position_desc,trunc(schedule_date),trunc(schedule_date)-to_date(?,'dd/mm/yyyy') order by position_desc";
			sql_position_aclloc_det="select am_position_lang_vw.position_desc position_desc, trunc(schedule_date) sch_date,(trunc(schedule_date)- to_date(?,'dd/mm/yyyy')) cell_no, sum(required_staff) required_staff, sum(allocated_staff) allocated_staff  from rs_work_schedule_summ, am_position_lang_vw, am_shift  where facility_id =?  and (? is null or workplace_code = ?) and schedule_date between to_date(?,'dd/mm/yyyy') and (to_date(?,'dd/mm/yyyy')) and am_position_lang_vw.position_code = rs_work_schedule_summ.position_code  and am_shift.shift_code = rs_work_schedule_summ.shift_code  and am_shift.shift_indicator = 'P' and am_position_lang_vw.language_id = ? group by am_position_lang_vw.position_desc,trunc(schedule_date),trunc(schedule_date)-to_date(?,'dd/mm/yyyy') order by position_desc";

	try{		
		stmt_position_aclloc_det=con.prepareStatement(sql_position_aclloc_det);
		stmt_position_aclloc_det.setString(1,new_from_date);
		stmt_position_aclloc_det.setString(2,facility_id);
		stmt_position_aclloc_det.setString(3,workplace_code);
		stmt_position_aclloc_det.setString(4,workplace_code);
		stmt_position_aclloc_det.setString(5,new_from_date);
		stmt_position_aclloc_det.setString(6,new_to_date);
		stmt_position_aclloc_det.setString(7,locale);
		stmt_position_aclloc_det.setString(8,new_from_date);

		rs_position_aclloc_det=stmt_position_aclloc_det.executeQuery();
		
		}catch(Exception e)
		{
			out.println("bfr tbl1:"+e);
		}
			

            _bw.write(_wl_block8Bytes, _wl_block8);


for(int p=0;p<14;p++){
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
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(te3));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	else
	{
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	
}


            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

for(int u=0;u<d_track;u++)
{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(d_code2[u]));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
for(int u=0;u<(14-d_track);u++){
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);


for(int u=0;u<d_track;u++){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(d_code1[u]));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
for(int u=0;u<(14-d_track);u++){
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);

String classValue="";
String borderc = "";
int cell=0;
String	position_temp = "";
String classval = "";
String position = "";
int m[]=new int[14];
int n[]=new int[14];
int cell_no1[]=new int[100];
int hh=0;
if(rs_position_aclloc_det.next())
{
String flag = "1";
position = rs_position_aclloc_det.getString("position_desc");
position_temp = position;
int i=0;
while(flag.equals("1"))
{		
	if ( hh % 2 == 0 )
		classValue = "EmptyEven" ;
	else
		classValue = "EmptyOdd" ;

	for(int q = 0; q<14; q++)
		cell_no1[q] = -1;

	while (position_temp.equals(position) && flag.equals("1"))
	{ 
	
		cell = Integer.parseInt(rs_position_aclloc_det.getString("cell_no"));

		cell_no1[cell]=cell;
		m[cell] = Integer.parseInt(rs_position_aclloc_det.getString("allocated_staff"));
		n[cell] = Integer.parseInt(rs_position_aclloc_det.getString("required_staff"));
		
		if (rs_position_aclloc_det.next())
		{
			position = rs_position_aclloc_det.getString("position_desc");
			i++;
		}
		else
		{
			flag = "0";		
		}
	
	}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(position_temp));
            _bw.write(_wl_block33Bytes, _wl_block33);

	for(int kkk=0;kkk<14;kkk++)
	{
		String disp=m[kkk]+"/"+n[kkk];
	if(cell_no1[kkk]==kkk ){ 
		if(m[kkk] == n[kkk])
		{
			classval	=	"OPTIMAL";
		}
		if(m[kkk] > n[kkk])
		{
			classval	=	"ABOVEOPTIMAL";
			
		}
		if(m[kkk] < n[kkk])
		{
			classval	=	"BELOWOPTIMAL";		
		}
		if(( m[kkk] == 0 ) && ( n[kkk] == 0 ))
		{
			classval	=	"EmptyCell";	
			disp="&nbsp;";
		}
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(kkk));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(borderc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block38Bytes, _wl_block38);

			
		borderc = "";				
		}else{
			
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(kkk));
            _bw.write(_wl_block41Bytes, _wl_block41);
				
		}
	}
		
/*		build the table using the string*/
for(int kkk=0;kkk<14;kkk++){
	m[kkk] =0;
	
}
	position_temp = position;
            _bw.write(_wl_block42Bytes, _wl_block42);

		hh++;		
	}
}
if(stmt_position_aclloc_det!=null) stmt_position_aclloc_det.close();
if(rs_position_aclloc_det!=null) rs_position_aclloc_det.close();

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(new_from_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(new_to_date));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(end_ind));
            _bw.write(_wl_block46Bytes, _wl_block46);

}catch(Exception e)
	{out.println(e.toString());}
	finally
	{
		if(stmt_position_aclloc_det!=null) stmt_position_aclloc_det.close();
		if(rs_position_aclloc_det!=null) rs_position_aclloc_det.close();
		if(cstmt!=null) cstmt.close();
		
		ConnectionManager.returnConnection(con,request);	
	}

            _bw.write(_wl_block47Bytes, _wl_block47);
 } catch(Exception e)
	{
		e.printStackTrace();
} 

            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
