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
import com.ehis.util.*;

public final class __mergedpatientiddetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergedPatientIDDetails.jsp", 1719914377807L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<!-- \t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergedPatientIds.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar ErrorText = getMessage(\'NO_RECORD\',\'DR\');\n\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\t\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_patcount\').value = ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\t\t\t\t\n\t\t\t\t\t</script>\t\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<form name=\'group_details_form\' id=\'group_details_form\'>\n\t\t\t\t<table border=\'0\' width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' >\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'center\' width=\'19%\' class=\'data\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\n\t\t\t\t\t\t<td width=\'8%\' class=\'label\' align=\'center\'><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\'>+</a></td>\n\t\t\t\t\t\t<td align=\'center\' width=\'29%\' class=\'label\'><font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\n\t\t\t\t\t\t\t<td width=\'10%\' class=label align=\'center\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=\'0\' ALT=\"\"></IMG>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\'10%\' class=label align=\'center\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\'center\' width=\'22%\' valign=\'top\' class=\'label\' nowrap>\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t<td align=\'center\' width=\'20%\' valign=\'top\' class=\'label\' nowrap>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t \t</table>\n\t\t\t\t<input type=\'hidden\' name=\'patcount\' id=\'patcount\' value=\'0\'>\n\t\t\t\t<input type=\'hidden\' name=\'patient_id1\' id=\'patient_id1\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'patient_id2\' id=\'patient_id2\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'p_dup_group_id\' id=\'p_dup_group_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'p_dup_count\' id=\'p_dup_count\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t</form>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")))? "" : inputString);
}




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

		Connection          con		= null;
		java.sql.Statement	stmt	= null;
		java.sql.Statement	stmt1	= null;
		ResultSet	        rs		= null;
        ResultSet	        rs1		= null;
		 String locale=(String)session.getAttribute("LOCALE");
		String str			     = "";
		String p_dup_group_id	 = "";
		String p_valid_duplicate = "";
		String p_valid_check     = "";
		String p_dup_check       = "";
		String p_dup_count		 = "";
		String added_by_id		 = "";
		String added_date        = "";
		String added_date_display= "";
	   String pat_series="";
		int i	= 0;
		
		String p_patient_id	= checkForNull(request.getParameter("patient_id"));
		p_dup_count			= checkForNull(request.getParameter("p_pat_count"));
		p_dup_group_id=checkForNull(request.getParameter("p_dup_group_id"));
		
		try
		{
			con     = ConnectionManager.getConnection(request);
			stmt	= con.createStatement();
			stmt1	= con.createStatement();  

			if(p_dup_count.equals("") || p_dup_count.equals("0"))
			{
				
            _bw.write(_wl_block9Bytes, _wl_block9);
				
			} else {
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}		
					
			str   = "select merge_trn_id dup_group_id,patient_id,dup_indicator valid_duplicate, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line,added_by_id,to_char(added_date,'dd/mm/yyyy')added_date from dr_merged_patient_vw11 where merge_trn_id='"+p_dup_group_id+"' and nvl(initiating_function_id,0) <> 'MP_CHANGE_PAT_ID' " ;
			
            rs	= stmt.executeQuery(str);
			
            _bw.write(_wl_block12Bytes, _wl_block12);

				if(rs != null)
				{
					while(rs.next())
					{
						i++;
						p_patient_id		= checkForNull(rs.getString("patient_id"));
						p_valid_duplicate	= checkForNull(rs.getString("valid_duplicate"));
						added_date          = checkForNull(rs.getString("added_date"));
						added_by_id         = checkForNull(rs.getString("added_by_id"));
                        						
						if(p_valid_duplicate.equals("V"))
						{
							p_valid_check = "checked";
							p_dup_check   = "unchecked";
						}
						else if (p_valid_duplicate.equals("D"))
						{
							p_valid_check = "unchecked";
							p_dup_check   = "checked";
						}
						
						added_date_display = DateUtils.convertDate(added_date,"DMY","en",locale);

						String str1 = "SELECT PAT_SER_GRP_CODE FROM dr_mp_patient WHERE ";

						if(p_valid_duplicate.equals("V")) {
							str1 = str1+ "VALID_PATIENT_ID = '"+p_patient_id+"'";
						}
						else if(p_valid_duplicate.equals("D")) {
							str1 = str1+ "DUPLICATE_PATIENT_ID = '"+p_patient_id+"'";
						}

						
						rs1 = stmt1.executeQuery(str1);
						if(rs1!=null && rs1.next()) {								pat_series=rs1.getString("PAT_SER_GRP_CODE")==null?"":rs1.getString("PAT_SER_GRP_CODE");
						}
						
						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_series));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_valid_duplicate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);

							if(p_valid_check.equals("checked"))
							{
						    	
            _bw.write(_wl_block18Bytes, _wl_block18);

						   	}
							
            _bw.write(_wl_block19Bytes, _wl_block19);

							if(p_dup_check.equals("checked"))
							{
								
            _bw.write(_wl_block18Bytes, _wl_block18);

							}
							
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(added_by_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(added_date_display));
            _bw.write(_wl_block22Bytes, _wl_block22);

					}
				}
				if(rs != null) rs.close();
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block25Bytes, _wl_block25);

		     if(rs   != null) rs.close();
			if(stmt != null) stmt.close();
		   if(rs1   != null) rs1.close();
			if(stmt1 != null) stmt1.close();
		}
		catch(Exception e)
			{
				out.println("Exception in MergedPatientIDDetails:"+e.toString());
		}
		finally
		{
			
		    ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
