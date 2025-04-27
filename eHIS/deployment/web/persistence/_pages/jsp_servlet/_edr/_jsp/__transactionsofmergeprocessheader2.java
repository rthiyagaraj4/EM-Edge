package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;

public final class __transactionsofmergeprocessheader2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/TransactionsOfMergeProcessHeader2.jsp", 1742359932968L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/TransactionsOfMergeProcess.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\t\n\t<!-- <script language=\"javascript\" src=\"../../eDR/js/DRrowcolor.js\" ></script> -->\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/rowcolor.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<form name=\'group_header_form\' id=\'group_header_form\'>\n\t\t\t<table border=\'0\' width=\'100%\' cellspacing=\'0\' id=\'tb1\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=label width=\'5%\'></td>\n\t\t\t\t\t<td class=label width=\'75%\'></td>\n\t\t\t\t\t<td class=label width=\'20%\'></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t<script> \n\t\t\t\t\t\t\tvar ErrorText = getMessage(\"NO_RECORD\",\"DR\");\n\t\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tvar ErrorText = \'\';\n\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t<tr id=\'_";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t\t\t\t\t\t\t<td class=\'label\' valign=\'top\'><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\")\'>+</a></td>\n\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\'label\'><a name=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onClick=\'changeRowColor(this,3)\' href=\'javascript:callDupGroupDetails(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"E\")\' id=\'_a";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a><br>\n\t\t\t\t\t\t\t\t<font size=1>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td align=\'right\' valign=top class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=hidden name=p_patcount id=p_patcount value=0>\n\t\t\t</form>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str				= "";
	String p_patient_id		= "";
	String p_patient_line	= "";

	int p_pat_count			= 0;
	int p_dup_group_id	    = 0; 
	int p_pat_rec_cnt		= 0;

	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	String sql			= "";
	String strsql1		= "";
	String p_order_by	= "";
	String p_dup_ind	= "";
String locale = (String)session.getAttribute("LOCALE");
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if((whereClause == null || whereClause.equals("")))
		{
			sql	= "";

			p_patient_id	= request.getParameter("patient_id");
			if(p_patient_id == null) p_patient_id = "";
		
			sql	= "WHERE dup_indicator = 'V' AND group_status = 'E' AND patient_id = nvl(('"+p_patient_id+"'), patient_id) ";
		}
		else
		{
			sql = whereClause;
		}

		int x			= 0;
		int time_count	= 0;
		int start		= 0;
		int end			= 0;
		int i			= 1;

		if(from == null) start = 1 ;
		else start = Integer.parseInt( from ) ;

		if(to == null) end = 5 ;
		else end = Integer.parseInt( to ) ;
		
		strsql1="SELECT count(1) AS TOTAL FROM dr_dup_group_vw2 "+  sql + " AND dup_group_id LIKE '%%'";
		rs = stmt.executeQuery(strsql1);
		{
			rs.next();
		} if(rs != null) rs.close();
		
            _bw.write(_wl_block4Bytes, _wl_block4);

				if(p_patient_id.length() > 0)
				{
					str = "SELECT count(1) TOTAL FROM dr_dup_group_vw2 " + sql + " AND dup_group_id LIKE '%%' ";
					rs = stmt.executeQuery(str);
					if(rs.next())
					{
						p_pat_rec_cnt = rs.getInt("total");
					} if(rs != null) rs.close();

					if(p_pat_rec_cnt == 0)
					{
						
            _bw.write(_wl_block5Bytes, _wl_block5);

					}
				}
				else
				{
					
            _bw.write(_wl_block6Bytes, _wl_block6);

				}
				
				str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl ";
				rs	 = stmt.executeQuery(str);
				if(rs.next())
				{
					p_order_by = rs.getString("order_by_for_process_cycle")==null?"":rs.getString("order_by_for_process_cycle");
				} if (rs != null) rs.close();
				
				str  = "SELECT dup_group_id, patient_id,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line, pat_count, mp_patient_added_date, dup_indicator FROM dr_dup_group_vw2 " + sql + " AND dup_group_id LIKE '%%' ";
				if(!p_order_by.equals(""))	
		           {
					str=str+" ORDER BY "+p_order_by;
				   }
				rs	= stmt.executeQuery(str);
				if(rs != null)
				{
					if(start != 1)
						for(int j=1; j<start; i++,j++)
						{	
							rs.next();						  
						}
						while(rs.next() && i <= end)
						{
							x = x + 1;
							time_count++;

							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							p_patient_line	= rs.getString("patient_line");
							p_dup_group_id  = rs.getInt("dup_group_id");
							p_dup_ind		= rs.getString("dup_indicator");
                                                        
							
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_dup_ind));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(x));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block16Bytes, _wl_block16);

								i++;
							}
						} if(rs != null) rs.close();
					
            _bw.write(_wl_block17Bytes, _wl_block17);

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception e :"+e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		
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
