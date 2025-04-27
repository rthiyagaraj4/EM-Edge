package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __cahomepagenotesnew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAHomePageNotesNew.jsp", 1709115538184L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'styleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script language=javascript src=\'../../eCA/js/CAMainMyTasks.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n</HEAD>\n<BODY OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<!--<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n<form>\n<!--<table border=\'0\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n<tr><td  colspan=\'5\' class=\'COMMONTOOLBARFUNCTION\' style=\'border:0\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b>\n</td></tr>\n</table> -->\n\n<table cellspacing=\'0\'  cellpadding=3 border=1 width=\'100%\' align=\'center\'> \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' nowrap>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:authorizeNotes();\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="(0)\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\n\t\t\t<TR>\n\t\t\t\t<TD class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' nowrap>\n\t\t\t\t\t<b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b>\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' nowrap>&nbsp;&nbsp;&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:reviewNotes(\"P\");\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =")</a>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="(0)\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:reviewNotes(\"S\");\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t</td></tr>\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:reviewNotes(\"A\");\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")\n\t\t\t\t\t\t</a>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >&nbsp;</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</table>\n<input type=\'hidden\' name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"></input>\n<form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	Connection con = null;
	
	String classValue = "";
	String note_type="",note_count="";
	String cou="0";
	String speCount = "0";
	int totalCount = 0;
    //String applicable_yn="";
	StringBuffer str = new StringBuffer();
	String	respid				= (String)	session.getValue("responsibility_id");
	int i = 0;
	try
	{
		
	PreparedStatement pstmt = null;
	ResultSet rset			=null;
	PreparedStatement pstmtComp = null;
	ResultSet rsComp = null;
		
		con=ConnectionManager.getConnection(request);

		String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) 
		session.getValue("practitioner_type");
		
		String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");
		
		String fid		=	(String)session.getValue("facility_id");
		String Clin_id	=	(String)session.getValue("ca_practitioner_id");
		String User_id	=	(String)session.getValue("login_user");
		String resp_id=	(String) session.getValue("responsibility_id");
		
		String sqlPstmt="";
		String comp_desc = "";
		String group_desc = "";
		String sql = "";
		
		//sqlPstmt="SELECT COMP_ID, NVL((SELECT 'Y' FROM ca_personalized_home_page WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID=CA_HOME_PAGE_COMP.COMP_ID  AND ROWNUM=1), 'N') applicable_yn FROM CA_HOME_PAGE_COMP where  COMP_ID in ('PEND_SIGN') or GROUP_COMP_ID in('PEND_REVW')";

		sql = "select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = 'PEND_REVW'";
		pstmtComp = con.prepareStatement(sql);
		rsComp = pstmtComp.executeQuery();
		if(rsComp.next())
			group_desc = rsComp.getString(1);
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();

		sqlPstmt="SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID in ('PEND_SIGN','PEND_RV_SL','PEND_RV_SP','PEND_RV_AL') ";

		pstmtComp = con.prepareStatement(sqlPstmt);

		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
		
		
		rsComp = pstmtComp.executeQuery();
	
		int k = 0;
		
		while(rsComp.next())
		{
			k = k+1;

			//if ( k % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
			comp_desc = rsComp.getString("COMP_DESC");
			if(rsComp.getString("COMP_ID").equals("PEND_SIGN"))
			{
				sql="select sum(grptot) from (select  count(*)  grptot  from ca_encntr_note_audit_log ii where facility_id= ? and action_type = 'SN' and ACTION_STATUS ='RQ' and action_by_id = ? and exists (select 1 from ca_encntr_note a, ca_note_type_for_resp b where a.FACILITY_ID=ii.facility_id and a.ACCESSION_NUM=ii.ACCESSION_NUM   and b.NOTE_TYPE=a.NOTE_TYPE	  and b.RESP_ID=?)        union all  select   count(*) grptot from ca_encntr_note c , ca_note_type_for_resp b where  c.facility_id= ? and c.event_status='1'   and c.added_by_id = ? and c.CONTR_MOD_ACCESSION_NUM is null and b.NOTE_TYPE=c.NOTE_TYPE  and b.RESP_ID=? )";

					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,fid);
					pstmt.setString(2,Clin_id);
					pstmt.setString(3,respid);
					pstmt.setString(4,fid);
					pstmt.setString(5,User_id);
					pstmt.setString(6,respid);
					rset=pstmt.executeQuery();

					while (rset.next())
					{
						cou=rset.getString(1)==null?"0":rset.getString(1);				
					}

					if(rset!=null)rset.close();
					if(pstmt!=null)pstmt.close();

						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if (Integer.parseInt(cou)!=0) { 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cou));
            _bw.write(_wl_block14Bytes, _wl_block14);
 }else{ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
 }
				
					
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
				
		else if(rsComp.getString("COMP_ID").equals("PEND_RV_SL") || rsComp.getString("COMP_ID").equals("PEND_RV_SP") || rsComp.getString("COMP_ID").equals("PEND_RV_AL"))
		{
			note_type = "";
			note_count = "";
			str = new StringBuffer();

			//pending reviews
			//classValue = "CAQUERYEVEN";  //CAQUERYODD

			sql="select count(*) grptot from ca_encntr_note_audit_log_view a,ca_note_type_for_resp B where a.action_by_id = ? and a.action_status = 'RQ'  and  a.action_type in ('RV','RS') AND A.NOTE_TYPE = B.NOTE_TYPE AND B.RESP_ID = ? and a.facility_id = ? and a.event_status != '9'" ;

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,Clin_id);
			pstmt.setString(2,respid);
			pstmt.setString(3,(String) session.getValue("facility_id"));
			rset=pstmt.executeQuery();

			while (rset.next())
			{
				cou=rset.getString(1);	
			}

			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
			
			sql = "select count(*) grptot from ca_encntr_note_audit_log_view a,ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id = ? and a.action_by_group_code = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?)  and a.action_status = 'RQ'  and  a.action_type in ('RV','RS','FS') and b.PRIVILEGE_TYPE in ('3','4') and a.facility_id = ? and a.event_status != '9'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,resp_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,(String) session.getValue("facility_id"));
			rset=pstmt.executeQuery();

			while (rset.next())
			{
				speCount=rset.getString(1);					
			}
			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
			totalCount = Integer.parseInt(cou) + Integer.parseInt(speCount);
			
			if(i == 0)
			{
			
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
 
				i = i+1;
				k = k+1;

				//if(classValue.equals("CAQUERYODD"))
					//classValue = "CAQUERYEVEN";
				//else if(classValue.equals("CAQUERYEVEN"))
					//classValue = "CAQUERYODD";
			}
				if(rsComp.getString("COMP_ID").equals("PEND_RV_SL"))
				{
					//classValue = "CAQUERYODD"; 
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
 
						if (Integer.parseInt(cou)!=0)
						{
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cou));
            _bw.write(_wl_block24Bytes, _wl_block24);
 
						}
						else
						{ 
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
						}
			
            _bw.write(_wl_block27Bytes, _wl_block27);

					
				}
				else if(rsComp.getString("COMP_ID").equals("PEND_RV_SP"))
				{
					//classValue = "CAQUERYEVEN"; 
					
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
 
						if (Integer.parseInt(speCount)!=0)
						{ 
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(speCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
 
						}
						else
						{ 
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
						} 
			
            _bw.write(_wl_block29Bytes, _wl_block29);

					
				}
				else if(rsComp.getString("COMP_ID").equals("PEND_RV_AL"))
				{
					//classValue = "CAQUERYODD"; 
					
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
 
						if (totalCount!=0)
						{ 
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totalCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
 
						}
						else
						{ 
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
						}
			
            _bw.write(_wl_block27Bytes, _wl_block27);

					
				}
			}			
		}
		for(int j=k+1;j<=6;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}

		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in CAHomePageNotesNew.jsp "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
}
