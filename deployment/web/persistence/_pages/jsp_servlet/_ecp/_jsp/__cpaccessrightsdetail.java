package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.HashMap;
import com.ehis.eslp.*;
import java.net.*;
import eCommon.XSSRequestWrapper;

public final class __cpaccessrightsdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/CPAccessRightsDetail.jsp", 1709116575387L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teCP\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tHema Malini B\n*\tCreated On\t\t:\t24 Jan 2005\n\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<script language=\"JavaScript\" src=\"../../eCP/js/common.js\"></script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../js/CpMessages.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n  <script src=\"../js/CPAccessRights.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =",";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =")\' class=\'CONTENT\' >\n<form name=\'detail_form\' id=\'detail_form\' action=\'../../eCP/jsp/CPAccessRightsDetail.jsp\' method=\'post\' >\n\n<table  width=\'95%\' border=0 align=\'center\'>\n<tr>\n<td align=\'right\' class=\'NONURGENT\'>\n\n<input type=hidden name=\'recordArray\' id=\'recordArray\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\n<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'practitioner_name\' id=\'practitioner_name\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\n\n<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n    <a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =")\' text-decoration=\'none\'>Previous</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")\' text-decoration=\'none\'>Next</a>\n    <input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</td>\n</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t\t\t\n\t\t<th width=\'15%\'><fmt:message key=\"Common.practitionertype.label\" bundle=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/></th>\n\t\t<!--<th width=\'15%\' size=\'5\'>Practitioner ID</th>-->\n\t\t<th width=\'20%\'><fmt:message key=\"Common.practitioner.label\" bundle=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/></th>\n\t\t<th width=\'10%\' size=\'5\'>Assess</th>\n\t\t<th width=\'10%\' size=\'5\'>Generate</th>\n\t\t<th width=\'10%\' size=\'5\'>Finalize</th>\n\t\t<th width=\'10%\' size=\'5\'><fmt:message key=\"Common.revise.label\" bundle=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/></th>\n\t\t<th width=\'10%\' size=\'5\'>Evaluate</th>\n\t\t<th width=\'10%\' size=\'5\'><fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/><br><input type=\'checkbox\' name=\'selectall\' id=\'selectall\' onClick=\'selectAll(this,";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\'></th>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ><font size=\'1\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<font size=\'1\'></td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'><font size=\'1\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<font size=\'1\'></td>\n\t\t\t\t<input type=hidden name=\'practitioner_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'practitioner_id";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'><input type=\'checkbox\' name=\'assess";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'assess";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" > \n\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><input type=\'checkbox\' name=\'generate";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'generate";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><input type=\'checkbox\' name=\'finalize";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'finalize";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >\n\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" name=\'revise";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\n\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" name=\'evaluate";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\n\t\t\n\t\t\t\t<input type=hidden name=\'action";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'action";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\n\t\t\t\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" name=\'select";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'> </td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet CPAccessRights= null;synchronized(session){
                CPAccessRights=(webbeans.eCommon.RecordSet)pageContext.getAttribute("CPAccessRights",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(CPAccessRights==null){
                    CPAccessRights=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("CPAccessRights",CPAccessRights,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String facility_id = (String)session.getAttribute("facility_id");
		ArrayList recordArray=new ArrayList();	
		ArrayList resultArray=new ArrayList();

		String chk_practitioner_id="";
		String chk_assess="";
		String chk_generate="";
		String chk_finalize="";
		String chk_revise="";
		String chk_evaluate="";
		String select_yn="Y";
		//String db_action="U";
		String chk_select="";
		String chk_action="";

		String chk_pract="";
		String chk_ass="";
		String chk_gen="";
		String chk_fin="";
		String chk_rev="";
		String chk_eval="";

		String pract_type_desc="";
		String practitioner_name="";

  	    String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

		if (from == null)
			start = 0 ;
		else
			start = Integer.parseInt(from);
		if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
		String req_start=(request.getParameter("start")==null)?"1":request.getParameter("start");
		String req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");

		String pract_type1=(request.getParameter("practitioner_type")==null)?"":request.getParameter("practitioner_type");

		String practitioner_name1=(request.getParameter("practitioner_name")==null)?"":request.getParameter("practitioner_name");

		String practitioner_id1=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");


		Connection con = null;
		PreparedStatement pstmt_initial = null;
		ResultSet rs_initial = null;

		PreparedStatement pstmt=null;
		ResultSet rs=null ;

		try{
			
		con = ConnectionManager.getConnection(request);			
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null){
			
			CPAccessRights.clearAll();
			String sql_initial="select a.pract_type, b.desc_userdef pract_type_desc,a.practitioner_id, a.practitioner_name pract_name,'N' assess_yn,'N' generate_cp_yn,'N' finalize_cp_yn, 'N' revise_cp_yn, 'N' evaluate_cp_yn,	'I' db_action from 	am_practitioner a, am_pract_type b, am_pract_for_facility c where	a.pract_type = nvl(?,a.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or 	  (? is not null and a.practitioner_name like decode('C','S',?||'%','C','%'||?||'%','E','%'||?) )	)and a.practitioner_id not in (select practitioner_id from cp_access_rights where facility_id = ?) and a.eff_status = 'E' and    b.pract_type = a.pract_type and	c.facility_id = ? and c.practitioner_id = a.practitioner_id and c.eff_status = 'E' union all select	b.pract_type, c.desc_userdef pract_type_desc, a.practitioner_id, b.practitioner_name pract_name, a.assess_yn, a.generate_cp_yn, a.finalize_cp_yn, a.revise_cp_yn, a.evaluate_cp_yn, 'U' db_action from 	cp_access_rights a, am_practitioner b, am_pract_type c where a.facility_id = ? and	b.practitioner_id = a.practitioner_id and	b.pract_type = nvl(?,b.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or (? is not null and b.practitioner_name like decode('C','S',?||'%','C','%'||?||'%', 'E','%'||? ))) and	b.eff_status = 'E' and c.pract_type = b.pract_type order by pract_type_desc, pract_name"; 


			pstmt_initial=con.prepareStatement(sql_initial);
			pstmt_initial.setString(1,pract_type1);
			pstmt_initial.setString(2,practitioner_id1);
			pstmt_initial.setString(3,practitioner_name1);
			pstmt_initial.setString(4,practitioner_name1);
			pstmt_initial.setString(5,practitioner_name1);
			pstmt_initial.setString(6,practitioner_name1);
			pstmt_initial.setString(7,practitioner_name1);
			pstmt_initial.setString(8,facility_id);
			pstmt_initial.setString(9,facility_id);
			pstmt_initial.setString(10,facility_id);
			pstmt_initial.setString(11,pract_type1);
			pstmt_initial.setString(12,practitioner_id1);
			pstmt_initial.setString(13,practitioner_name1);
			pstmt_initial.setString(14,practitioner_name1);
			pstmt_initial.setString(15,practitioner_name1);
			pstmt_initial.setString(16,practitioner_name1);
			pstmt_initial.setString(17,practitioner_name1);

			rs_initial = pstmt_initial.executeQuery();

			if(rs_initial !=null){
				while(rs_initial.next()){
						
				recordArray=new ArrayList();
				
				recordArray.add(rs_initial.getString("practitioner_id"));
				recordArray.add(rs_initial.getString("assess_yn"));
				recordArray.add(rs_initial.getString("generate_cp_yn"));
				recordArray.add(rs_initial.getString("finalize_cp_yn"));
				recordArray.add(rs_initial.getString("revise_cp_yn"));
				recordArray.add(rs_initial.getString("evaluate_cp_yn"));
				recordArray.add(rs_initial.getString("db_action"));

				if(rs_initial.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs_initial.getString("db_action").equals("I"))
					   select_yn="N";
						
		 		recordArray.add(7,select_yn);
				CPAccessRights.putObject(recordArray);
		
    			 }
			  }	
	        }
			if(from != null && to != null){
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<(Integer.parseInt(req_end)); i++){
				
			    if(request.getParameter("practitioner_id"+(i)) != null)
				{
					chk_practitioner_id	="";
					chk_assess			="";
					chk_generate        ="";
					chk_finalize		="";
					chk_revise			="";
					chk_evaluate		="";
				    chk_select          ="";
					chk_action          ="";

				 chk_practitioner_id = request.getParameter("practitioner_id"+(i));
	
				
				 if((request.getParameter("assess"+(i)))!=null)
					 chk_assess="Y";
				 else
					 chk_assess="N";
				 if((request.getParameter("generate"+(i)))!=null)
					 chk_generate="Y";
				 else
					  chk_generate="N";
	
				 if((request.getParameter("finalize"+(i)))!=null)
					   chk_finalize="Y";
				 else
					   chk_finalize="N";
				 if((request.getParameter("revise"+(i)))!=null)
					   chk_revise="Y";
				 else
					   chk_revise="N";
				 if((request.getParameter("evaluate"+(i)))!=null)
					   chk_evaluate="Y";
				else
					   chk_evaluate="N";

				 chk_action = request.getParameter("action"+(i));
				

				 if((request.getParameter("select"+(i)))!=null)
					 chk_select="Y";
				 else
					 chk_select="N";
			
		
					    resultArray=new ArrayList();
						resultArray.add(chk_practitioner_id);
						resultArray.add(chk_assess);
						resultArray.add(chk_generate);
						resultArray.add(chk_finalize);
						resultArray.add(chk_revise);
						resultArray.add(chk_evaluate);
						resultArray.add(chk_action);
						resultArray.add(chk_select);
						CPAccessRights.setObject(i,resultArray);
					
						 
				  }
				   }
     
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";


	String sql="select a.pract_type, b.desc_userdef pract_type_desc,a.practitioner_id, a.practitioner_name pract_name,'N' assess_yn,'N' generate_cp_yn,'N' finalize_cp_yn, 'N' revise_cp_yn, 'N' evaluate_cp_yn,	'I' db_action from 	am_practitioner a, am_pract_type b, am_pract_for_facility c where	a.pract_type = nvl(?,a.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or (? is not null and a.practitioner_name like decode('C',	'S',?||'%','C','%'||?||'%','E','%'||?) ))and a.practitioner_id not in (select practitioner_id from cp_access_rights where facility_id = ?) and a.eff_status = 'E' and        b.pract_type = a.pract_type and	c.facility_id = ? and c.practitioner_id = a.practitioner_id and c.eff_status = 'E' union all select	b.pract_type, c.desc_userdef pract_type_desc, a.practitioner_id, b.practitioner_name pract_name, a.assess_yn, a.generate_cp_yn, a.finalize_cp_yn, a.revise_cp_yn, a.evaluate_cp_yn, 'U' db_action from 	cp_access_rights a, am_practitioner b, am_pract_type c where a.facility_id = ? and	b.practitioner_id = a.practitioner_id and	b.pract_type = nvl(?,b.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or   (? is not null and b.practitioner_name like decode('C','S',?||'%',	'C','%'||?||'%', 'E','%'||?))) and	b.eff_status = 'E' and c.pract_type = b.pract_type order by pract_type_desc, pract_name";


try{
	pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1,pract_type1);
			pstmt.setString(2,practitioner_id1);
			pstmt.setString(3,practitioner_name1);
			pstmt.setString(4,practitioner_name1);
			pstmt.setString(5,practitioner_name1);
			pstmt.setString(6,practitioner_name1);
			pstmt.setString(7,practitioner_name1);
			pstmt.setString(8,facility_id);
			pstmt.setString(9,facility_id);
			pstmt.setString(10,facility_id);
			pstmt.setString(11,pract_type1);
			pstmt.setString(12,practitioner_id1);
			pstmt.setString(13,practitioner_name1);
			pstmt.setString(14,practitioner_name1);
			pstmt.setString(15,practitioner_name1);
			pstmt.setString(16,practitioner_name1);
			pstmt.setString(17,practitioner_name1);

	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		 // out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		  }


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(recordArray));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pract_type1));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(practitioner_name1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block18Bytes, _wl_block18);

    if ( !(start <= 1)) {

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block20Bytes, _wl_block20);

    }
    if ( !((start+10) >= maxRecord )){

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block21Bytes, _wl_block21);

    }

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block27Bytes, _wl_block27);
	 

		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
			while((rs.next()) && (i<=end)){ 

					recordArray=new ArrayList();
					 chk_pract="";
					 chk_ass="";
					 chk_gen="";
					 chk_fin="";
					 chk_rev="";
					 chk_eval="";
   				
			recordArray.add(rs.getString("practitioner_id"));
			recordArray.add(rs.getString("assess_yn"));
			recordArray.add(rs.getString("generate_cp_yn"));
			recordArray.add(rs.getString("finalize_cp_yn"));
			recordArray.add(rs.getString("revise_cp_yn"));
			recordArray.add(rs.getString("evaluate_cp_yn"));
			recordArray.add(rs.getString("db_action"));

			if(rs.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs.getString("db_action").equals("I"))
					   select_yn="N";
						
		 	recordArray.add(7,select_yn);

			pract_type_desc=rs.getString("pract_type_desc");
			practitioner_name=rs.getString("pract_name");
									
			 for(int k=0;k<CPAccessRights.getSize();k++)
			 {
				resultArray=(ArrayList)CPAccessRights.getObject(k);
					 								
				if(((String)recordArray.get(0)).equals((String)resultArray.get(0)))
					 {
						 if(resultArray.get(1).equals("Y"))
							 chk_ass="checked";
						 else
							 chk_ass="";

						 if(resultArray.get(2).equals("Y"))
						 	 chk_gen="checked";
						 else
							 chk_gen="";

						 if(resultArray.get(3).equals("Y"))
							 chk_fin="checked";
						 else
							 chk_fin="";

						 if(resultArray.get(4).equals("Y"))
						
							 chk_rev="checked";
						 else
							 chk_rev="";

						 if(resultArray.get(5).equals("Y"))
							 chk_eval="checked";
						 else
							 chk_eval="";

						 if(!resultArray.get(5).equals("Y"))
							 //db_action="checked";
						 //else
							 chk_eval="";

						 if(resultArray.get(7).equals("Y"))
							 chk_pract="checked";
						 else
							 chk_pract="";
						 break;
					 }
				 else
				 {
					 chk_pract="";
					 chk_ass="";
					 chk_gen="";
					 chk_fin="";
					 chk_rev="";
					 chk_eval="";
				 }
			 } //end for
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recordArray.get(0)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordArray.get(1)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chk_ass));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordArray.get(2)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chk_gen));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordArray.get(3)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chk_fin));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(chk_rev));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordArray.get(4)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(chk_eval));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordArray.get(5)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recordArray.get(6)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(chk_pract));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recordArray.get(7)));
            _bw.write(_wl_block54Bytes, _wl_block54);

			i++;
			}		
		 }
			  catch(Exception e){
				 // out.print(e);//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				  if(rs != null){ rs.close(); }
				  if(rs_initial != null){ rs_initial.close(); }
				  if(pstmt != null){ pstmt.close(); }
				  if(pstmt_initial != null){ pstmt_initial.close(); }
					    
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("CPAccessRights", CPAccessRights);

			  }
            _bw.write(_wl_block55Bytes, _wl_block55);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
