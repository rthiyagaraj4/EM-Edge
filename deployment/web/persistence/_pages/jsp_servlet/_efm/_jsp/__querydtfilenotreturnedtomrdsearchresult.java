package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;
import java.sql.Date;
import java.math.*;
import java.util.*;
import com.ehis.util.*;

public final class __querydtfilenotreturnedtomrdsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryDTFileNotReturnedToMRDSearchResult.jsp", 1709116881109L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Developed By      :    Utpal Sen\n     Created on        :    06/09/2001\n     Module Name       :    DT\\Document Not returned to MRD\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n   <!--  <LINK rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n    <SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n    <SCRIPT src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/QueryFMFileNotReturnedToMRD.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<HEAD>\n<BODY OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n\t<FORM name=\"QueryFMSearchResult\" id=\"QueryFMSearchResult\" action=\"../../eFM/jsp/QueryDTFileNotReturnedToMRDSearchResult.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\n\t <TABLE cellpadding=\"0\" cellspacing=\"0\" align=\'right\' width=\"100%\" > \n\t\t\t\t<TR>\n\t\t\t\t\t<TD >\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<A href=\'javascript:getNext(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n\t\t        <TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"100%\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<TR> \n\t\t\t\t\t\t\t<TD width=\"100%\"  colspan=\'7\' class=\'CAGROUPHEADING\' ><B>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</B></TD>\n\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t<TR><TD colspan=\'7\' class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><FONT size=1><B>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</B></FONT>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD width=\"100%\"  colspan=\'7\' class=\'CAGROUPHEADING\' ><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t    <TR>\n\t\t\t\t       <TD width=\"38%\" class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ><FONT size=1><B>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B><BR>&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</TD>\n\t\t\t\t\t\t<td  width=\"12%\" class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' wrap><CENTER><FONT size=1>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</CENTER>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"10%\" class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><FONT size=1>\n          \t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</TD>\n\t\t\t\t        <TD width=\"10%\" class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><font size=1>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TD>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t\t\t\t        <TD width=\"10%\" class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' style=\'background-color:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ><FONT size=1>\n\t\t\t\t\t       ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</FONT>\n\t\t\t\t\t\t</TD>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<TD width=\"10%\" class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><font size=1>\n\t\t\t\t\t     ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</FONT>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD width=\"10%\" class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><FONT size=1>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t </TD>  \n\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<TR><TD  colspan=\'7\' class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\t\t\tvar p_criteria = \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\';\n\t\t\t\t\tif (p_criteria==\'all\')\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\tvar str = getMessage(\'CAN_NOT_BE_BLANK\',\'Common\');\n\t\t\t\t\t\tstr = str.replace(\'$\',\'Document Storage Location \')\n\t\t\t\t\t\talert(str);\n\t\t\t\t\t}\n\t\t\t\t\telse if (parseInt(p_rec_cnt)==0)\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\t}\n\t\t\t\t</SCRIPT>\n\t\t\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t </TABLE>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<SCRIPT>\n\t\tparent.frames[1].document.forms[0].search.disabled=false;\n\t</SCRIPT>\n\t<INPUT type=\'hidden\' name=\'previousRecord\' id=\'previousRecord\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<INPUT type=\'hidden\' name=\'nextRecord\' id=\'nextRecord\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>   \n\t<INPUT type=\'hidden\' name=\'flag\' id=\'flag\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<INPUT type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>  \n\t<INPUT type=\'hidden\' name=\'noOfRecords\' id=\'noOfRecords\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>     \n\t<INPUT type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'> \n\t<INPUT type=\'hidden\' name=\'fs_locn_id\' id=\'fs_locn_id\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<INPUT type=\'hidden\' name=\'from_search\' id=\'from_search\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<INPUT type=\'hidden\' name=\'out_criteria\' id=\'out_criteria\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n </FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        Connection con   = ConnectionManager.getConnection(request);
        java.sql.Statement stmt   = null;
	    java.sql.Statement stmt1  = null;
		java.sql.Statement stmt2  = null;
        ResultSet rset   = null ;
		ResultSet rset1  = null ;
		ResultSet rset2  = null ;	
		
		String req_start		 = "", req_end = "";
 
		String from				= request.getParameter("from");
		String to				= request.getParameter("to");
        String queryCriteria    = request.getParameter("criteria")    ;
        String flag             = request.getParameter("flag")        ;
        String facility_id      = request.getParameter("facility_id")     ;
        String out_facility_id	= request.getParameter("out_facility_id");
		String out_criteria		= request.getParameter("out_criteria");
		String fs_locn_id		= request.getParameter("fs_locn_id");
		
		String discharge_date_time = "";

		String sql              = "";  
        String classValue       ="";
        String from_search      = request.getParameter("from_search");
		StringBuffer sqlCriteria	= null;
		sqlCriteria					= new StringBuffer();

		if(out_facility_id==null || out_facility_id.equals("null")) out_facility_id="";
		if(out_criteria==null || out_criteria.equals("null")) out_criteria="";
		if(queryCriteria==null || queryCriteria.equals("null")) queryCriteria="";
		if(fs_locn_id==null || fs_locn_id.equals("null")) fs_locn_id="";
		if(facility_id==null || facility_id.equals("null")) facility_id="";
		
	//	int    nextRecord       =         (request.getParameter("nextRecord")==null)? 0:Integer.parseInt(request.getParameter("nextRecord"));
        
        //int    previousRecord   =        (request.getParameter("previousRecord")==null)? 0 :             Integer.parseInt(request.getParameter("previousRecord"));
        
        int counter             = 0;
        int fromRecordNumber    = 0;
        int toRecordNumber      = 0;
        int noOfRecords         = 0;  
		
		int maxRecord	= 0;
	    int start		= 0;
		int end			= 0;
//	    int i			= 1;
		
		if (from == null){ start = 0; } else { start = Integer.parseInt(from); }
	    if (to == null){ end = 5; } else { end = Integer.parseInt(to); }

		req_start  = (request.getParameter("start") == null) ? "0" : request.getParameter("start");
		req_end    = (request.getParameter("end") == null)   ? "0" : request.getParameter("end");        
	
        

        if (from_search==null)from_search="";
		try
		{
	         if (from_search.equals("Y"))
		     {
				if (!out_facility_id.equals(""))
					sqlCriteria.append(" AND  a.curr_facility_id='"+out_facility_id+"' ");
				if (!out_criteria.equals(""))
					sqlCriteria.append( " AND  a.curr_fs_locn_code='"+out_criteria+"' ");
				if (!queryCriteria.equals(""))
					sqlCriteria.append(" AND  a.mr_pat_fs_locn_code='"+queryCriteria+"' ");
				if (!fs_locn_id.equals(""))
					sqlCriteria.append(" AND  a.curr_fs_locn_identity='"+fs_locn_id+"' ");	
			}
			else
			{
				if (!queryCriteria.equals(""))            
					sqlCriteria.append(" AND  a.mr_pat_fs_locn_code='" + queryCriteria + "' ");
			}
			//The following query is the main one to get the records.
			sql = "SELECT a.file_no,a.file_type_desc,a.volume_no,get_patient_line(a.patient_id,'"+localeName+"') patient_line,a.curr_fs_locn_code,a.curr_fs_locn_short_desc,decode(a.curr_fs_locn_identity,	'D','Department','T','Practitioner','C','Clinic','N','Nursingunit','X','External','E','Procedure Unit','Y','Daycare Unit')		   curr_fs_locn_identity,DECODE(a.curr_file_status,'R','Returned','I','Inside','O','Outside',	'L','Lost','T','InTransit','A','Archived','E','Other Facility')curr_file_status, TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time, TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time,(CASE WHEN sysdate > a.return_date_time THEN 'Y' ELSE 'N' END) time_bar,(CASE WHEN a.facility_id<>a.curr_facility_id THEN '(' || a.curr_facility_name ||')' ELSE '&nbsp;' END )curr_facility_name,a.return_criteria,a.no_of_dh_to_return_ip,a.no_of_dh_to_return_op,a.duration_type,a.doc_folder_id, a.doc_folder_name,a.doc_type_name, b.patient_id, b.from_period, b.to_period, b.patient_period_specific,(CASE WHEN b.patient_period_specific='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/yyyy ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/yyyy ') ELSE ', ' || get_patient_line(b.patient_id) END)doc_type,TO_CHAR(a.nia_return_date,'dd/mm/rrrr hh24:mi') nia_return_date FROM fm_curr_locn_vw a,fm_doc_folder b WHERE a.curr_fs_locn_code<>a.mr_pat_fs_locn_code and a.facility_id='"+facility_id+"' AND a.doc_folder_id = b.doc_folder_id(+) AND a.facility_id = b.facility_id "+sqlCriteria+" ORDER BY a.curr_fs_locn_short_desc,a.file_no";
	
			stmt	= con.createStatement();
		    rset    = stmt.executeQuery(sql) ;

            _bw.write(_wl_block8Bytes, _wl_block8);
 if(!(start <= 1)) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start-5)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end-5)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 } if(!((start+5) >= maxRecord)) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start+5)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end+5)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
 } 
            _bw.write(_wl_block13Bytes, _wl_block13);

		        String p_first_curr_fs_locn_code = "";				
				String bgcolor                   = "";
				String nia_bgcolor               = "";
				String return_criteria           ="";
				String no_of_dh_to_return_ip = "";
				String no_of_dh_to_return_op = "";
				String curr_fs_locn_identity = "";
				String duration_type		 = "";
				String sql2					 = "";

				String p_doc_folder_id	 = "";
				String p_doc_folder_name = "";
				String p_doc_type_name	 = "";
				String p_doc_type	     = "";

				int p_rec_cnt	= 0;
				int cnt			= 0; //To Display total No of Documents Groupwise - by Meghanath.
		
				while(rset.next())
				{
					return_criteria		  = rset.getString("return_criteria");
					no_of_dh_to_return_ip = rset.getString("no_of_dh_to_return_ip");
					no_of_dh_to_return_op = rset.getString("no_of_dh_to_return_op");
					curr_fs_locn_identity = rset.getString("curr_fs_locn_identity");
					duration_type  = rset.getString("duration_type");
					p_doc_folder_id  = rset.getString("doc_folder_id")==null?"&nbsp;":rset.getString("doc_folder_id");
					p_doc_folder_name  = rset.getString("doc_folder_name")==null?"&nbsp;":rset.getString("doc_folder_name");
					p_doc_type_name  = rset.getString("doc_type_name")==null?"&nbsp;":rset.getString("doc_type_name");
					p_doc_type  = rset.getString("doc_type")==null?"&nbsp;":rset.getString("doc_type");

					if(return_criteria == null || return_criteria.equals("null")) return_criteria="";
					if(no_of_dh_to_return_ip == null) no_of_dh_to_return_ip="0";
					if(no_of_dh_to_return_op == null) no_of_dh_to_return_op="0";
						if(curr_fs_locn_identity == null ) curr_fs_locn_identity="";
					
					if(duration_type ==null ) duration_type ="";
					int parameter_hours=0;	
					if(duration_type.equals("D"))
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op) * 24;
					}
					else
					{
						parameter_hours = Integer.parseInt(no_of_dh_to_return_op);	
					}
			        if (counter==0)
					{
						p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("curr_fs_locn_short_desc")+" ( " + rset.getString("curr_fs_locn_identity") +") "));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
			        else if(!p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						if(classValue.equals("QRYODD"))
						{
							classValue = "QRYEVEN";
						}
						else if(classValue.equals("QRYEVEN"))
						{
							classValue = "QRYODD";
						}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block19Bytes, _wl_block19);

						cnt = 0;

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rset.getString("curr_fs_locn_short_desc")+" ( " + rset.getString("curr_fs_locn_identity") +") "));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
					counter++ ;
					if(counter % 2 == 0)
			            classValue = "QRYODD";
					else
			            classValue = "QRYEVEN";
						
					String f_no = rset.getString("file_no");

					String sql1                 = "";		
					String no_hours             = "0";
					String nia_no_hours         = "0";
					String returnfile_date_time = "";
		
					sql2=" SELECT to_char(MAX(iss_date_time)+("+parameter_hours+"/24),'dd/mm/rrrr hh24:mi') returndate FROM fm_curr_locn WHERE file_no= '"+f_no+"'";
			
					stmt2	= con.createStatement();
				    rset2    = stmt2.executeQuery(sql2) ;
				
					while(rset2.next())
					{
						returnfile_date_time = rset2.getString("returndate");
						if(returnfile_date_time == null) returnfile_date_time="";
					}
					if(rset2 != null) rset2.close();
					if(stmt2 != null) stmt2.close();
					if(f_no == null) f_no="";
					if(return_criteria !=null && return_criteria.equals("D"))
					{
						sql1 ="SELECT (sysdate - max(discharge_date_time)) *24 diffinhours FROM pr_encounter WHERE facility_id = '"+facility_id+"' and discharge_date_time is not null AND patient_id in (select patient_id FROM fm_movement_log where facility_id = '"+facility_id+"' and file_no='"+f_no+"' AND SENT_DATE_TIME is not null)";
					}
					else
					{
					//	sql1="SELECT (sysdate-max(sent_date_time)) * 24 diffinhours  FROM fm_movement_log WHERE file_no='"+f_no+"'  AND sent_date_time is not null";
						sql1 = "SELECT (sysdate-max(RETURN_DATE_TIME)) diffinhours from fm_curr_locn where FILE_NO ='"+f_no+"'  AND facility_id = '"+facility_id+"' ";
					}
					stmt1	= con.createStatement();
				    rset1    = stmt1.executeQuery(sql1) ;
				
					while(rset1.next())
					{
						no_hours = rset1.getString("diffinhours");
						if(no_hours == null) no_hours="0.00";
						no_hours =  no_hours.substring(0,no_hours.indexOf("."));
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();

				//	if(Integer.parseInt(no_hours) <= parameter_hours)
					if(Integer.parseInt(no_hours) <= 0)
					{
						bgcolor="orange";		
					}
				//	else if(Integer.parseInt(no_hours) > parameter_hours)
					else if(Integer.parseInt(no_hours) > 0)
					{
						bgcolor = "red";		
					}

					if(return_criteria !=null && return_criteria.equals("D"))
					{
						sql2 ="SELECT (sysdate - max(nia_return_date)) *24 nia_diffinhours from fm_curr_locn where facility_id = '"+facility_id+"' and nia_return_date is not null and patient_id in (select patient_id from fm_movement_log WHERE facility_id = '"+facility_id+"' and file_no='"+f_no+"' and sent_date_time is not null)";
					}
					else
					{
						sql2="SELECT (sysdate-max(sent_date_time)) * 24 nia_diffinhours FROM fm_movement_log WHERE facility_id = '"+facility_id+"' and file_no='"+f_no+"'  AND sent_date_time is not null";
					}
					stmt1	 = con.createStatement();
				    rset1    = stmt1.executeQuery(sql2) ;
				
					while(rset1.next())
					{
						nia_no_hours = rset1.getString("nia_diffinhours");
						if(nia_no_hours == null) nia_no_hours="0.00";
						nia_no_hours =  nia_no_hours.substring(0,nia_no_hours.indexOf("."));
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();

					if(curr_fs_locn_identity.equals("Clinic"))
					{
						if(Integer.parseInt(nia_no_hours) <= parameter_hours)
						{
							nia_bgcolor="orange";		
						}
						else if(Integer.parseInt(nia_no_hours) > parameter_hours)
						{
							nia_bgcolor="RED";		
						}	
					}
					else if(curr_fs_locn_identity.equals("N"))
					{
						if(Integer.parseInt(nia_no_hours) < parameter_hours)
						{
							nia_bgcolor="orange";		
						}
						else if(Integer.parseInt(nia_no_hours) > parameter_hours)
						{
							nia_bgcolor="RED";		
						}
					}
					String mysql1 ="SELECT to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time FROM pr_encounter WHERE facility_id = '"+facility_id+"' and  DISCHARGE_DATE_TIME is not null AND patient_id in (select patient_id FROM fm_movement_log WHERE facility_id = '"+facility_id+"' and FILE_NO='"+f_no+"' AND sent_date_time is not null)";
					stmt1	= con.createStatement();
					rset1    = stmt1.executeQuery(mysql1) ;
					discharge_date_time = "&nbsp;";
					if(rset1.next())
					{
						discharge_date_time = rset1.getString("discharge_date_time");
						if(discharge_date_time == null || discharge_date_time.equals("null")) 
							discharge_date_time = "&nbsp";
					}
					if(rset1 != null) rset1.close();
					if(stmt1 != null) stmt1.close();

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_doc_folder_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_doc_folder_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_doc_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_doc_type_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((rset.getString("curr_file_status")==null)?"&nbsp":rset.getString("curr_file_status")+"<br>"+rset.getString("curr_facility_name")+""));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((rset.getString("iss_date_time")==null)?"&nbsp":rset.getString("iss_date_time")));
            _bw.write(_wl_block31Bytes, _wl_block31);

							if(rset.getString("return_date_time") == null || rset.getString("return_date_time").equals(""))
								bgcolor="";

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((rset.getString("return_date_time")==null)?"&nbsp":rset.getString("return_date_time")));
            _bw.write(_wl_block35Bytes, _wl_block35);

						if(rset.getString("nia_return_date") == null || rset.getString("nia_return_date").equals(""))
							nia_bgcolor="";

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(nia_bgcolor));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((rset.getString("nia_return_date")==null)?"&nbsp":rset.getString("nia_return_date")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(discharge_date_time));
            _bw.write(_wl_block40Bytes, _wl_block40);

	                p_first_curr_fs_locn_code = rset.getString("curr_fs_locn_code");
   			       	p_rec_cnt++;
					if(p_first_curr_fs_locn_code.equals(rset.getString("curr_fs_locn_code")))
					{
						cnt++;
					}
				}
				if(cnt !=0)
				{
					if(classValue.equals("QRYODD"))
					{
						classValue = "QRYEVEN";
					}
					else if(classValue.equals("QRYEVEN"))
					{
						classValue = "QRYODD";
					}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block19Bytes, _wl_block19);
				
				}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(start));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(end));
            _bw.write(_wl_block46Bytes, _wl_block46);

		if(rset  != null) rset.close(); 
		if(rset1 != null) rset1.close();
		if(rset2 != null) rset2.close();
		if(stmt  != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
			}
		catch(Exception e)
		{

			out.println("Exception while fetching connection :" + e ) ;

		}
		finally
		{
		   
		  	ConnectionManager.returnConnection(con, request); 
	   }

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(fromRecordNumber));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(toRecordNumber));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(fs_locn_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(from_search));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(out_criteria));
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TotalNoofDocuments.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TotalNoofDocuments.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
