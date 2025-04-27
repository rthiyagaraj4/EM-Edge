package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __querydoctypewisedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryDocTypeWiseDetails.jsp", 1724922773026L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- by Meghanath -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n\t\t<!-- <LINK rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/QueryDocTypeWise.js\'></SCRIPT>\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\t<BODY onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n\t\t<SCRIPT>parent.QueryDocTypeCriteria.document.getElementById(\"tab1\").style.visibility = \"visible\";</SCRIPT>\n\t\t<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\'tab2\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<SCRIPT>\n\t\t\tvar recCount = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\tif(recCount == 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\tparent.QueryDocTypeResult.document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t\telse if(recCount != 0)\n\t\t\t{\n\t\t\t\tfor(i=0;i<5;i++)\n\t\t\t\t{\n\t\t\t\t\tif((document.getElementById(\"tab2\").rows[i+1] != null) && (document.getElementById(\"tab2\").rows[i+1].cells[i] != null))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.QueryDocTypeCriteria.document.getElementById(\"tab1\").rows[0].cells[i].width = document.getElementById(\"tab2\").rows[i+1].cells[i].width;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.QueryDocTypeCriteria.document.forms[0].Search.disabled = \"true\";\n\t</SCRIPT>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</TABLE>\n\t</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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

		String facility_id	 = (String) session.getValue("facility_id");

		Connection conn		 = null;
		Statement stmt		 = null;
		ResultSet rst		 = null;

		conn = ConnectionManager.getConnection(request);
		
		String doc_type_code = "";
		String mysql		 = "";
		String classValue    = "";
		String fromPeriod    = "";
		String toPeriod      = "";

		int i			= 0;
		int recordCount = 0;

		doc_type_code = request.getParameter("doc_type_code");
		if(doc_type_code == null || doc_type_code.equals("null"))
			doc_type_code = "";

		mysql = " SELECT a.doc_folder_id,c.doc_folder_name,TO_CHAR(c.from_period, 'dd/mm/rrrr') from_period,TO_CHAR(c.to_period, 'dd/mm/rrrr') to_period,c.patient_id,b.curr_fs_locn_desc, DECODE(b.curr_file_status,'A','Archive','E','External','I','Inside','L','Lost','O','Outside','R','Returned','T','Transit') curr_file_status FROM fm_encounter_doc_type_link a,fm_curr_locn_vw b,fm_doc_folder c WHERE a.facility_id = c.facility_id AND a.doc_folder_id = c.doc_folder_id AND a.facility_id=b.facility_id AND a.doc_folder_id = b.doc_folder_id AND a.file_no = b.file_no AND a.doc_type_code='"+doc_type_code+"' AND a.facility_id='"+facility_id+"' ORDER BY c.doc_folder_name";
	
		try
		{
			stmt = conn.createStatement();
			rst	 = stmt.executeQuery(mysql);
			
			while(rst != null && rst.next())
			{
				fromPeriod  = rst.getString("from_period");
				toPeriod	= rst.getString("to_period");

				if(fromPeriod == null || fromPeriod.equals("null"))
					fromPeriod = "&nbsp;";
				if(toPeriod == null || toPeriod.equals("null"))
					toPeriod = "&nbsp;";

				classValue =   ((i%2) == 0) ? "QRYEVEN" : "QRYODD";
				
				out.println("<TR><TD class='"+classValue+"' width='20%'><FONT size='1'>");
				out.println(((rst.getString("doc_folder_name")== null) || (rst.getString("doc_folder_name").equals("null"))) ? "" : rst.getString("doc_folder_name")+"</FONT></TD>");

				out.println("<TD class='"+classValue+"' width='25%'><FONT size='1'><CENTER>");
				out.println(fromPeriod+"&nbsp;-&nbsp;"+toPeriod+"</CENTER></FONT></TD>");

				out.println("<TD class='"+classValue+"' width='20%'><FONT size='1'>");
				out.println(((rst.getString("patient_id")== null) || (rst.getString("patient_id").equals("null"))) ? "&nbsp;" : rst.getString("patient_id")+"</FONT></TD>");

				out.println("<TD class='"+classValue+"' width='25%'><FONT size='1'>");
				out.println(((rst.getString("curr_fs_locn_desc")== null) || (rst.getString("curr_fs_locn_desc").equals("null"))) ? "" : rst.getString("curr_fs_locn_desc")+"</FONT></TD>");

				out.println("<TD class='"+classValue+"' width='10%'><FONT size='1'>");
				out.println(((rst.getString("curr_file_status")== null) || (rst.getString("curr_file_status").equals("null"))) ? "" : rst.getString("curr_file_status")+"</FONT></TD></TR>");

				i++;
				recordCount++;
			}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(rst  != null) rst.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
