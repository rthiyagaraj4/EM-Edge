package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;

public final class __transactionsofmergeprocessdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/TransactionsOfMergeProcessDetails.jsp", 1717473190691L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/TransactionsOfMergeProcess.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[1].document.getElementById(\"p_patcount\").value = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ; \n\t\t\t\tparent.parent.frames[1].frames[7].document.getElementById(\"\").disabled = false;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\tvar ErrorText = getMessage(\'NO_RECORDS_FOR_REVIEW\',\'DR\');\n\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t <form name=\'group_details_form\' id=\'group_details_form\'>\n\t\t\t<table border=0 width=\'100%\' cellspacing=0 cellpadding=0 >\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'2%\' align=\'center\'>&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\t\t<td width=\'2%\' class=\'label\' align=\'center\'>\n\t\t\t\t\t<a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\", \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" )\'>+&nbsp;</a></td>\n\t\t\t\t\t\n\t\t\t\t\t<td width=\'55%\' class=\'label\' align=\'left\' colspan=\'1\'><font size=\'1\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\n\t\t\t\t\t\n\t\t\t\t\t<td width=\'10%\'  align=\'center\' >\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=0 ALT=\"\" align=\"center\"></IMG>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'10%\'  align=\'center\'>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'20%\' class=\'label\' align=\'center\'>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'5\'><font size=\'1\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </font></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t \t</table>\n\n\t\t\t<input type=\'hidden\' name=\'patcount\' id=\'patcount\' value=\'0\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id1\' id=\'patient_id1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id2\' id=\'patient_id2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'p_dup_group_id\' id=\'p_dup_group_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'p_dup_count\' id=\'p_dup_count\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str				 = "";
	String p_dup_group_id	 = "";
	String p_valid_duplicate = "";
	String p_valid_check     = "";
	String p_dup_check       = "";
	String p_not_check       = "";
	String p_patient_line    = "";
	String p_dup_count		 = "";
	String p_order_by		 = "";
  //  String locale=(String)session.getAttribute("LOCALE");
	int i	= 0;
  
	String p_patient_id		= request.getParameter("patient_id");;
	String p_group_status	= request.getParameter("p_group_status");
	p_dup_count				= request.getParameter("p_pat_count");
	if(p_dup_count==null || p_dup_count.equals("null"))
	   p_dup_count="";
	   
	try
	{
		con	= ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		if(p_patient_id == null) p_patient_id = ""; 
		if(p_group_status.equals("X") || p_group_status.equals("E") )
		{ 
			//When Called from TransactionsOfMergeProcessSearch.jsp
			str  = "select dup_group_id,pat_count from dr_dup_group_vw2 where group_status in ('S','E') and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";
			
		}
		else
		{
			//When Called from TransactionsOfMergeProcessHeader1.jsp
			str  = "select dup_group_id,pat_count from dr_dup_group_vw2 where dup_indicator='V' and group_status='S' and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";
			
		}
        
		rs	= stmt.executeQuery(str);
		if(rs != null && rs.next())
		{
			p_dup_group_id = rs.getString("dup_group_id")==null?"":rs.getString("dup_group_id");
			p_dup_count    = rs.getString("pat_count") ==null?"":rs.getString("pat_count");
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block10Bytes, _wl_block10);
			
		}
		else
		{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		} if(rs != null) rs.close();

		str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
		rs	 = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle")==null?"":rs.getString("order_by_for_process_cycle");
		} if(rs != null) rs.close();
	
		str   = "SELECT dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate,(CASE WHEN INSTR (Get_dup_Patient_line (patient_id,'en'), '#') > 0  THEN SUBSTR (Get_dup_Patient_line (patient_id,'en'), 1,   INSTR (Get_dup_Patient_line (patient_id,'en'), '#') - 1)  ELSE SUBSTR   (Get_Patient_line (patient_id,'en'), 1,   INSTR (Get_Patient_line (patient_id,'en'), '#') - 1 ) END)  patient_line FROM dr_dup_group_vw2 WHERE dup_group_id = '"+p_dup_group_id+"' ORDER BY "+p_order_by+" ";
		rs	= stmt.executeQuery(str);
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			while (rs != null && rs.next())
			{
				i++;
				p_patient_id		= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				p_valid_duplicate	= rs.getString("valid_duplicate")==null?"":rs.getString("valid_duplicate");
				p_patient_line		= rs.getString("patient_line")==null?"":rs.getString("patient_line");

				if(p_valid_duplicate.equals("V"))
				{
					p_valid_check = "checked";
					p_dup_check   = "unchecked";
					p_not_check   = "unchecked";
				}
				else if(p_valid_duplicate.equals("D"))
				{
					p_valid_check = "unchecked";
					p_dup_check   = "checked";
					p_not_check   = "unchecked";
				}
				else if(p_valid_duplicate.equals("X"))
				{
					p_valid_check = "unchecked";
					p_dup_check   = "unchecked";
					p_not_check   = "checked";
				}
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_valid_duplicate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_group_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(p_valid_check.equals("checked")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);
 if(p_dup_check.equals("checked")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(p_not_check.equals("checked")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block22Bytes, _wl_block22);

				} if(rs != null) rs.close();
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block25Bytes, _wl_block25);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
