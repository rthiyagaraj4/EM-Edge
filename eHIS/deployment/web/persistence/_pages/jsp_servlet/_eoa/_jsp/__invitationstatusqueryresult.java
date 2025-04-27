package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __invitationstatusqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/InvitationStatusQueryResult.jsp", 1709119240006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t <head>\n\t\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\n        <script src=\'../../eOA/js/WaitListInvitation.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\n\t\t<body OnMouseDown=\'CodeArrest();\'onKeyDown = \'lockKey()\'  onscroll=\'scrollTitle2()\' >\n\t\t<form name=\'QueryApptForPatient\' id=\'QueryApptForPatient\' >\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\n\t\t\t\t<th  nowrap width=\'7%\'><div  id=\'head1\' class=\'myClass\'>&nbsp;</div></th>\n\t\t\t\t<th  nowrap width=\'25%\'><div  id=\'head2\' class=\'myClass\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</div></th>\n\t\t\t\t<th nowrap width=\'25%\'><div  id=\'head3\' class=\'myClass\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div></th>\n\t\t\t\t<th align=\'center\' nowrap width=\'25%\'><div  id=\'head4\' class=\'myClass\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div></th>\n\t\t\t\t<th   nowrap width=\'25%\'><div  id=\'head5\' class=\'myClass\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div></th>\n\t\t\t\t<th align=\'center\' nowrap width=\'25%\'><div  id=\'head6\' class=\'myClass\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div></th>\n\t\t\t\t<th  nowrap width=\'25%\'><div  id=\'head7\' class=\'myClass\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></th>\n\t\t\t\t<th  nowrap width=\'25%\'><div  id=\'head8\' class=\'myClass\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div></th>\n\t\t\t\t<th  nowrap width=\'25%\'><div  id=\'head9\' class=\'myClass\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div></th>\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<tr onMouseOver=\'hideToolTip()\'>\n\t\t\t\t\t\t\t<td class=\'MRHEADER\' width=\'7%\' nowrap colspan=\'9\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =":";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =": ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" :";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr onMouseOver=\'hideToolTip()\'>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' width=\'7%\' nowrap>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\'14%\' nowrap>\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp; </td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\'8%\'  nowrap> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;<input type=\'hidden\' name=\'wait_num\' id=\'wait_num\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'></td>\t\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" nowrap onClick=hideToolTip() width=\'11%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"  nowrap width=\'10%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' width=\'12%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' width=\'10%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'ret_value\' id=\'ret_value\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<tr onMouseOver=\'hideToolTip()\'>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' width=\'12%\'>\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ALCN_CRITERIA_YN\' id=\'ALCN_CRITERIA_YN\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t\t\n\t\t\t\n\t\t\t</table>\n\t\t\t\t<tr></tr>\n\t\t\t\t<tr></tr><tr></tr>\n\t\t\t\t<table border=\'0\' align=\'right\' width=\'6%\'>\n\n\t</table>\n  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="  \n\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; visibility:hidden;\' bgcolor=\'blue\'>\n<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n<tr><td width=\'100%\' id=\'t\'></td></tr>\n</table>\n</div>\t \n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String fac_id		= (String) session.getValue( "facility_id" ) ;
		String locale=(String)session.getAttribute("LOCALE");
		StringBuffer sql=new StringBuffer("") ;
		String mon	=   request.getParameter("mon")== null?"":request.getParameter("mon");
		String yr	=	request.getParameter("yr")== null?"":request.getParameter("yr");
		String dt	=	request.getParameter("dt")== null?"":request.getParameter("dt");
		String prd = request.getParameter("prd")==null?"":request.getParameter("prd");
		String date_val=dt+"/"+mon+"/"+yr;
		if(date_val ==null) date_val="";
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String ALCN_CRITERIA_YN=request.getParameter("ALCN_CRITERIA_YN");
		if(ALCN_CRITERIA_YN ==null) ALCN_CRITERIA_YN="";
		String nat_id_no=request.getParameter("nat_id_no");
		if(nat_id_no ==null) nat_id_no="";
		String alt_id1_no=request.getParameter("alt_id1_no");
		if(alt_id1_no ==null) alt_id1_no="";
		String alt_id1_type=request.getParameter("alt_id1_type");
		if(alt_id1_type ==null) alt_id1_type="";
		String alt_id2_no=request.getParameter("alt_id2_no"); 
		if(alt_id2_no ==null) alt_id2_no="";
		String alt_id2_type=request.getParameter("alt_id2_type");
		if(alt_id2_type ==null) alt_id2_type="";
		String alt_id3_no=request.getParameter("alt_id3_no");
		if(alt_id3_no ==null) alt_id3_no="";
		String alt_id3_type=request.getParameter("alt_id3_type");
		if(alt_id3_type ==null) alt_id3_type="";
		String alt_id4_no=request.getParameter("alt_id4_no");
		if(alt_id4_no ==null) alt_id4_no="";
		String alt_id4_type=request.getParameter("alt_id4_type");
		if(alt_id4_type ==null) alt_id4_type="";
		String other_alt_Id=request.getParameter("other_alt_Id");
		if(other_alt_Id ==null) other_alt_Id="";
		String other_alt_type=request.getParameter("other_alt_type");
		if(other_alt_type ==null) other_alt_type="";

		String nat_id_code=request.getParameter("nat_id_code");
		if(nat_id_code ==null) nat_id_code="";
		String r_area_code=request.getParameter("r_area");
		if(r_area_code ==null) r_area_code="";
		String m_area_code=request.getParameter("m_area");
		if(m_area_code ==null) m_area_code="";
		String r_region_code=request.getParameter("r_region");
		if(r_region_code ==null) r_region_code="";
		String m_region_code=request.getParameter("m_region");
		if(m_region_code ==null) m_region_code="";
		String r_town_code=request.getParameter("r_town");
		if(r_town_code ==null) r_town_code="";
		String m_town_code=request.getParameter("m_town");
		if(m_town_code ==null) m_town_code="";

		String wait_list_priority=request.getParameter("wait_list_priority");
		if(wait_list_priority ==null) wait_list_priority="";
			
		String classValue	 = "";
		String classValue1="";
		String waitListNo="";
		String priority="";
		String priority_desc="";
		String patientId="";
		String patientName="";
		String preferedDate="";
		String Gender="";
		String gender1="";
		String wait_list_status_code="";
		String age="";
		String waitlist_category_code="";
		String waitlist_cat_desc="";
		String waitlist_category_code_prev="";


		Statement stmt				= null;
		ResultSet rs				= null;
		Connection conn=null;
		Statement st=null;
		PreparedStatement pstmt=null;
		ResultSet rsSet=null;
		ResultSet rsSet1=null;
			java.util.ArrayList arrlst=new java.util.ArrayList();

	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try
{
			conn = ConnectionManager.getConnection(request);
			stmt	 = conn.createStatement();
			StringBuffer sql3 = new StringBuffer();
			String sqlmain="";
			String  first_encounter_date_display="";
			String wait_list_status="";
			String first_encounter_date="";
			StringBuffer sqlmain2= new StringBuffer();
			//sqlmain="select 'I' WAIT_STATUS,count(*) count from pr_wait_list where facility_id = '"+fac_id+"'  and  INVITED_DATE_TIME=to_date('"+date_val+"','dd/mm/yyyy') and WAIT_LIST_STATUS ='I' UNION Select 'S' WAIT_STATUS,COUNT (*) count FROM pr_wait_list  WHERE facility_id ='"+fac_id+"'  and wait_list_status='S'  and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  between   trunc(sysdate - '"+prd+"' )  and  trunc(sysdate+1) UNION Select  'O' WAIT_STATUS, count(*) count FROM pr_wait_list WHERE facility_id = '"+fac_id+"'  and  preferred_date_time   between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)  and wait_list_status='O' ORDER BY WAIT_STATUS ";
			sqlmain="select 'I' WAIT_STATUS,count(*) count from pr_wait_list where facility_id = ? and  INVITED_DATE_TIME=to_date(?,'dd/mm/yyyy') and WAIT_LIST_STATUS ='I' UNION Select 'S' WAIT_STATUS,COUNT (*) count FROM pr_wait_list  WHERE facility_id =?  and wait_list_status='S'  and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy')  between   trunc(sysdate - ? )  and  trunc(sysdate+1) UNION Select  'O' WAIT_STATUS, count(*) count FROM pr_wait_list WHERE facility_id = ?  and  preferred_date_time   between trunc(sysdate - ? ) and trunc(sysdate+1)  and wait_list_status='O' ORDER BY WAIT_STATUS ";
						
			//st= conn.createStatement();
			rsSet=null;
			//rsSet 	= st.executeQuery(sqlmain);
			pstmt = conn.prepareStatement(sqlmain);
			pstmt.setString(1,fac_id);
			pstmt.setString(2,date_val);
			pstmt.setString(3,fac_id);
			pstmt.setString(4,prd);
			pstmt.setString(5,fac_id);
			pstmt.setString(6,prd);
			rsSet = pstmt.executeQuery();
			if (rsSet!=null)
			{
				while(rsSet.next())
				{			
					arrlst.add(rsSet.getString("count"));
				}
			}
			if(arrlst.size()>0)
				{
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				sql.append("select wait_list_no,WAIT_LIST_PRIORITY priority,patient_id,decode('"+locale+"','en',PATIENT_NAME, nvl(patient_name_loc_lang, patient_name)) patient_name,to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time,GENDER, get_age(DATE_OF_BIRTH)age,WAIT_LIST_STATUS, WAITLIST_CATEGORY_CODE, OA_GET_DESC.OA_WAITLIST_CATEGORY(WAITLIST_CATEGORY_CODE,'"+locale+"','1') waitlist_cat_desc,to_char(FIRST_ENCOUNTER_DATE,'dd/mm/yyyy')FIRST_ENCOUNTER_DATE  from pr_wait_list where facility_id = '"+fac_id+"'  and  ( INVITED_DATE_TIME=to_date('"+date_val+"','dd/mm/yyyy') AND wait_list_status='I') or wait_list_status IN ('O', 'S') and preferred_date_time between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)");
					
				sqlmain2.append(sql.toString()+sql3.toString());
				sql3.setLength(0);
				sql.setLength(0);
				
				sqlmain2.append(" ORDER BY WAITLIST_CATEGORY_CODE,WAIT_LIST_PRIORITY DESC ,to_number(WAIT_LIST_NO),PREFERRED_DATE_TIME");
				rs = null;
							
				rs 	= stmt.executeQuery(sqlmain2.toString());
				sqlmain2.setLength(0);
				int rowcolor=0;
				
				if(rs != null)
				{
					int k=0;
					while ( rs.next() )
					{
						waitListNo =rs.getString("wait_list_no");
						if(waitListNo ==null) waitListNo="";
						priority = rs.getString("priority");
						if(priority ==null) priority="";
						if(priority.equals("U"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
						}else if(priority.equals("S"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiurgent.label","common_labels");
						}else if(priority.equals("N"))
						{
							priority_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
						}
						patientId = rs.getString("patient_id");	
						if(patientId==null) patientId="";
						patientName	=rs.getString("patient_name");	
						if (patientName==null) patientName="";
						else
						if (patientName.length() >= 25) patientName=patientName.substring(0,25);
						preferedDate =rs.getString("pref_date_time");
						if(preferedDate ==null) preferedDate="";
						age=rs.getString("age");
						if(age==null) age="";
						
						wait_list_status_code=rs.getString("WAIT_LIST_STATUS");
						if(wait_list_status_code ==null) wait_list_status_code="";

						if(wait_list_status_code.equals("O") )
						{
							wait_list_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
						}else if(wait_list_status_code.equals("I"))
						{
							wait_list_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.invited.label","oa_labels");
						}else if(wait_list_status_code.equals("S"))
						{
							wait_list_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Selected.label","common_labels");
						}

						
						Gender=rs.getString("GENDER");
						if(Gender ==null) Gender="";
						if(Gender.equals("M") )
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						}else if(Gender.equals("F"))
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						}else if(Gender.equals("U"))
						{
							gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}
						waitlist_category_code =rs.getString("WAITLIST_CATEGORY_CODE");
						if(waitlist_category_code ==null) waitlist_category_code="";
						first_encounter_date=rs.getString("FIRST_ENCOUNTER_DATE");
						if(first_encounter_date ==null) first_encounter_date="";
						first_encounter_date_display=DateUtils.convertDate(first_encounter_date,"DMY","en",locale);
						waitlist_cat_desc=rs.getString("WAITLIST_CAT_DESC");
						if(waitlist_cat_desc ==null) waitlist_cat_desc="";
						
						
						

						if ( rowcolor % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						if(wait_list_status_code.equals("O"))
						{
							classValue1="EMERGENT";
						}else if(wait_list_status_code.equals("S"))
						{
							classValue1="ORBROWN";
						}else if(wait_list_status_code.equals("I"))
						{
							classValue1="MRHYPERIII";
						}
						
            _bw.write(_wl_block17Bytes, _wl_block17);

							int cnt_wait_list=0;
							int cnt_invited_list=0;
							int cnt_uninvited_list=0;
							//String oldest_arr_date="";
							//String latest_arr_date="";
							//String lat_invited="";
							
							
							if(!waitlist_category_code.equals(waitlist_category_code_prev)) {
								
								//String sql2="select count(*) count from pr_wait_list where wait_list_status='O' and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL('"+waitlist_category_code+"','X') AND facility_id = '"+fac_id+"' and  preferred_date_time between trunc(sysdate - '"+prd+"' ) and trunc(sysdate+1)";
								//rsSet1 	= st.executeQuery(sql2);
								String sql2="select count(*) count from pr_wait_list where wait_list_status='O' and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL(?,'X') AND facility_id = ? and  preferred_date_time between trunc(sysdate - ? ) and trunc(sysdate+1)";
								pstmt = conn.prepareStatement(sql2);
								pstmt.setString(1,waitlist_category_code);
								pstmt.setString(2,fac_id);
								pstmt.setString(3,prd);
								rsSet1 = pstmt.executeQuery();
								if(rsSet1 !=null && rsSet1.next())
								{
									cnt_wait_list=rsSet1.getInt("count");
								}
								if(rsSet1 !=null)rsSet1.close();
								//String sql4="select count(*) count from pr_wait_list where wait_list_status='I' AND  invited_date_time = TO_DATE ('"+date_val+"', 'dd/mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL('"+waitlist_category_code+"','X')";
								//rsSet1 	= st.executeQuery(sql4);
								String sql4="select count(*) count from pr_wait_list where wait_list_status='I' AND  invited_date_time = TO_DATE (?, 'dd/mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL(?,'X')";
								pstmt = conn.prepareStatement(sql4);
								pstmt.setString(1,date_val);
								pstmt.setString(2,waitlist_category_code);
								rsSet1 = pstmt.executeQuery();
								if(rsSet1 !=null && rsSet1.next())
								{
									cnt_invited_list=rsSet1.getInt("count");
								}
								if(rsSet1 !=null)rsSet1.close();
								//String sql5="select count(*) count from pr_wait_list where wait_list_status='I' AND to_date(to_char(invited_date_time,'mm/yyyy'),'mm/yyyy') = TO_DATE (to_char(sysdate,'mm/yyyy'), 'mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL('"+waitlist_category_code+"','X')";
								//rsSet1 	= st.executeQuery(sql5);
								String sql5="select count(*) count from pr_wait_list where wait_list_status='I' AND to_date(to_char(invited_date_time,'mm/yyyy'),'mm/yyyy') = TO_DATE (to_char(sysdate,'mm/yyyy'), 'mm/yyyy') and NVL(WAITLIST_CATEGORY_CODE,'X')=NVL(? ,'X')";
								pstmt = conn.prepareStatement(sql5);
								pstmt.setString(1,waitlist_category_code);
								rsSet1 = pstmt.executeQuery();
								if(rsSet1 !=null && rsSet1.next())
								{
									cnt_uninvited_list=rsSet1.getInt("count");
								}
								if(rsSet1 !=null)rsSet1.close();
								
								if(rsSet1 !=null)rsSet1.close();
							 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(waitlist_cat_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cnt_wait_list));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cnt_invited_list));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cnt_uninvited_list));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(first_encounter_date_display));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(age));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(gender1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(wait_list_status));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(first_encounter_date_display));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(age));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(gender1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(wait_list_status));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
					
					waitlist_category_code_prev=rs.getString("WAITLIST_CATEGORY_CODE");
					if(waitlist_category_code_prev ==null) waitlist_category_code_prev="";
					
					
					k=k+1;
					rowcolor++;

				}//while loop
		}//if
				
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ALCN_CRITERIA_YN));
            _bw.write(_wl_block45Bytes, _wl_block45);
}// any rec present
arrlst.clear();
	if ( rs != null ) rs.close() ;
	if ( rsSet!=null) rsSet.close();
	if ( stmt != null ) stmt.close() ;
	if ( st != null ) st.close();

}	catch ( Exception e ){
	//out.println(e);
	e.printStackTrace();
}finally
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.first.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ArrivalDate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.waitlistno.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WaitList.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TotalWaitListed.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TotalInvited.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.TotalInvitedForCurrentMonth.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }
}
