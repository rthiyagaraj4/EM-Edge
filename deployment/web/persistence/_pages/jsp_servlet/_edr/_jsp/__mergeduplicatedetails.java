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

public final class __mergeduplicatedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergeDuplicateDetails.jsp", 1719914539541L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergeDuplicates.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(parent.frames[1].document.getElementById(\'\') != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_patcount\').value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'; \n\t\t\t\t\t}\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<form name=\'group_details_form\' id=\'group_details_form\' action=\'../../servlet/eDR.MergeDuplicateServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<table border=\'0\' width=\'100%\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\n    \n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'18%\' class=\'data\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t\t\t\t\t\n\t\t\t\t\t<td width=\'3%\' class=\'label\' nowrap><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\'>+</a></td>\n\t\t\t\t\t\t<td class=\'data\' colspan=\'1\' wrap  width=\'48%\'><font size=\'1\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td>\n\t\t\t\t\t\t<td width=\'15%\' class=\'data\' align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t      <IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=0 ALT=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</IMG></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td width=\'15%\'class=\'data\' align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=0 ALT=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</IMG></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<td width=\'20%\' class=\'data\' align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td width=\'3%\' class=\'label\' nowrap></td>\n\t\t\t\t\t\t<td class=\'data\' colspan=\'5\' nowrap><font size=\'1\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </font></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<script>\n\t\t\t\t\t    var ErrorText = getMessage(\'NO_RECORD\',\'DR\');\n\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t</script>\n             ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t   \t \n\t\t\t\t       var ErrorText =\"\"; \n\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t</script>\n\t\t\t\t ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'patcount\' id=\'patcount\' value=\'0\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id1\' id=\'patient_id1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id2\' id=\'patient_id2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'p_dup_group_id\' id=\'p_dup_group_id\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'p_dup_count\' id=\'p_dup_count\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=\'hidden\' name=\'p_line\' id=\'p_line\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<input type=\'hidden\' name=\'final_chk_values\' id=\'final_chk_values\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'p_final_dup_group_id\' id=\'p_final_dup_group_id\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'process_start\' id=\'process_start\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'sys_time\' id=\'sys_time\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\'N\'> \n\t\t\t<input type=\'hidden\' name=\'start_later_time\' id=\'start_later_time\' value=\'\'> \n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
   java.sql.Statement stmt1	= null;
	ResultSet rs1			= null;
	String str					= "";
	String p_dup_group_id		= "";
	String p_valid_duplicate	= "";
	String p_valid_check		= "";
	String p_dup_check			= "";
	String p_not_check			= "";
	String p_patient_line		= "";
	String p_line				= "";
	String p_dup_count			= "";
	String p_order_by			= "";
	String sys_date				= "";
	String sys_time				= "";
	StringBuffer sb				= null;
    String pat_series             ="";
	int i		= 0;
	int j       = 0;
	int flag	= 0;

	String locale = (String)session.getAttribute("LOCALE");
	String p_patient_id	= request.getParameter("patient_id");
	String fromPage		= request.getParameter("fromPage");
	String facility		= request.getParameter("facility1");
	p_dup_count			= request.getParameter("p_pat_count"); 
  
	if(fromPage == null) fromPage = "";
	if(facility == null) facility = "";	
	
	try
	{   
		sb      = new StringBuffer();
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
        stmt1	= con.createStatement(); 
		String sql_sysdate = "SELECT to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'hh24:mi') FROM dual";
		rs = stmt.executeQuery(sql_sysdate);
		while(rs.next())
		{
			sys_date	= rs.getString(1);
			sys_time	= rs.getString(2);
		} if(rs != null) rs.close();

	
		if(p_patient_id == null || p_patient_id.equals("null"))
		{
			p_patient_id = "";
		}
        
		str  = "SELECT dup_group_id, pat_count FROM dr_dup_group_vw2 WHERE group_status = 'I' AND marked_for_merge_yn = 'N' AND patient_id = '"+p_patient_id+"' AND added_facility_id = nvl('"+facility+"', added_facility_id) ";
		rs	= stmt.executeQuery(str);
    	if(rs != null)
		{
			if(rs.next())
			{
				p_dup_group_id = rs.getString("dup_group_id");
				p_dup_count    = rs.getString("pat_count") ;
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block10Bytes, _wl_block10);
			
			}
			
		} if(rs != null) rs.close();
		
		str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
		rs	 = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
			flag = 1;
		} if(rs != null) rs.close();
	
		sb.append("SELECT dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6)  patient_line FROM dr_dup_group_vw2 WHERE dup_group_id = '"+p_dup_group_id+"'");

		if(flag == 1)
		{
			sb.append("order by "+p_order_by+" ");
			flag = 0;
		}
		
		rs	= stmt.executeQuery(sb.toString());
		
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(rs != null)
			{
				while(rs.next())
				    {
					i++;j++;
					p_patient_id		= rs.getString("patient_id");
					p_valid_duplicate	= rs.getString("valid_duplicate");
					p_patient_line		= rs.getString("patient_line");

					if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_not_check   = "unchecked";
						p_dup_check   = "checked";
					}
					else if(p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check   = "checked";
					}
					
					String str1="SELECT PAT_SER_GRP_CODE FROM mp_patient WHERE patient_id='"+p_patient_id+"'";
					rs1 = stmt1.executeQuery(str1);
					while(rs1.next())
					{	
		         pat_series=rs1.getString("PAT_SER_GRP_CODE")==null?"":rs1.getString("PAT_SER_GRP_CODE");
					}
							if(rs1 != null) rs1.close();

					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pat_series));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

						if(p_valid_check.equals("checked"))
						{
							
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
						
            _bw.write(_wl_block17Bytes, _wl_block17);

						if(p_dup_check.equals("checked"))
						{
							
            _bw.write(_wl_block18Bytes, _wl_block18);

						}
						
            _bw.write(_wl_block19Bytes, _wl_block19);

						if(p_not_check.equals("checked"))
						{
							
            _bw.write(_wl_block18Bytes, _wl_block18);

						}
						
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}
				
			} if((j==0) && (!p_patient_id.equals("")))
		       {
				
				
            _bw.write(_wl_block22Bytes, _wl_block22);
 }
				else
		         { 
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_line));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sys_time));
            _bw.write(_wl_block30Bytes, _wl_block30);

				if(sb!=null || sb.length() >0)
				sb.setLength(0);
		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception in THe File MergeDuplicateDetails"+e.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
