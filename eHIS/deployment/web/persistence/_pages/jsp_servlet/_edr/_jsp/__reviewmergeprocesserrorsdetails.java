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
import java.util.*;
import com.ehis.util.*;

public final class __reviewmergeprocesserrorsdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/ReviewMergeProcessErrorsDetails.jsp", 1742300737323L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergeDuplicates.js\'></script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction callError()\n\t{\n\t\tvar patient_id=document.forms[0].p_patient_id_er.value;\n\t\tvar ErrorText = \'\';\n\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\n\tvar title = getLabel(\"eDR.ReviewMergeProcessErrors.label\",\"DR\");\n\tvar dialogHeight= \"13\" ;\n\tvar dialogWidth\t= \"35\" ;\n\tvar dialogTop=\"225\";\n\tvar dialogLeft=\"225\";\n\tvar prev=\"prev\";\n\tvar display=\"display\";\n\tvar features= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\twindow.showModalDialog(\'../../eDR/jsp/ReviewMergeProcessErrorMessages.jsp?display=\'+display+\'&patient_id=\'+patient_id+\'&criteria=\'+prev,arguments,features);\n\t}\n\t</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].document.getElementById(\"p_patcount\").value = ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ; \n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar ErrorText = getMessage(\'NO_RECORD\',\'DR\');\n\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\n\t\t\t\t\t<form name=\'group_details_form\' id=\'group_details_form\' action=\'../../servlet/eDR.MergeDuplicateServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t<table border=\'0\' width=\'100%\' cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'4\' class=\'label\'><font color=navy><b>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></font>\n\t\t\t\t</td>\n\t\t\t\n\t\t\t\t\t\n\t\t\t<td >&nbsp;</td>\n\t\t\t<td><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onclick=\"callError();\"></td>\n\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\n\t\t\t</tr>\n\t\t\t<tr><td colspan=\'6\'> &nbsp;</td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'8%\' align=\'center\'> <input type=hidden name=\'selectpatient";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'selectpatient";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\'javascript:checkDuplicatesDetails(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\",\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\")\'></td>\n\t\t\t\t\t\t<td width=\'3%\' class=\'label\' align=\'center\'><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\'>+</a></td>\n\t\t\t\t\t\t<td width=\'48%\' class=\'label\' colspan=\'1\'><font size=\'1\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font></td>\n\t\t\t\t\t\t<td width=\'10%\'class=label align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=0 ALT=\"\"></IMG></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<td width=\'10%\' class=\'label\' align=\'center\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=\'0\' ALT=\"\"></IMG></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<td width=\'20%\' class=\'label\' align=\'center\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'5\'><font size=\'1\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" </font></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\n\t \t</table>\n\n\t\t<input type=hidden name=patcount id=patcount value=0>\n\t\t<input type=hidden name=patient_id1 id=patient_id1 value=\'\'>\n\t\t<input type=hidden name=patient_id2 id=patient_id2 value=\'\'>\n\t\t<input type=hidden name=p_dup_group_id id=p_dup_group_id value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t\t<input type=hidden name=p_patient_id_er id=p_patient_id_er value=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\n\t\t<input type=hidden name=p_dup_count id=p_dup_count value=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n\t\t<input type=hidden name=p_line id=p_line value=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\t\t<input type=hidden name=count id=count value=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n\t\t<input type=hidden name=final_chk_values id=final_chk_values value=\'\'>\n\t\t<input type=hidden name=p_final_dup_group_id id=p_final_dup_group_id value=\'\'>\n\t\t<input type=hidden name=process_start id=process_start value=\'\'>\n\t</form>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
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
	String p_status_upd_date	= "";
String locale = (String)session.getAttribute("LOCALE");

	int i	= 0;
	String patient_id = "";
	String p_patient_id		= request.getParameter("patient_id");
	p_dup_count				= request.getParameter("p_pat_count");
	p_status_upd_date		= request.getParameter("p_status_upd_date");

	if(p_status_upd_date == null || p_status_upd_date.equals("null"))  p_status_upd_date = "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(p_patient_id == null) p_patient_id = ""; 

		str  = "SELECT dup_group_id, pat_count,to_char(status_upd_date,'dd/mm/rrrr')status_upd_date FROM dr_dup_group_vw2 WHERE patient_id = '"+p_patient_id+"'  and dup_indicator = 'V' AND group_status = 'E'";

		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				p_dup_group_id		= rs.getString("dup_group_id");
				p_dup_count			= rs.getString("pat_count");
				p_status_upd_date	= rs.getString("status_upd_date");
				if(p_status_upd_date == null || p_status_upd_date.equals("null")) p_status_upd_date = "";		
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block9Bytes, _wl_block9);
			
			}
			else
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
		} if(rs != null) rs.close();

		if(p_status_upd_date != "")
					p_status_upd_date = DateUtils.convertDate(p_status_upd_date,"DMY","en",locale);
	
		str = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
		rs = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
		} if (rs != null) rs.close();

		str = "SELECT dup_group_id,patient_id,mp_patient_added_date, dup_indicator valid_duplicate,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line FROM dr_dup_group_vw2 WHERE dup_group_id='"+p_dup_group_id+"' AND group_status = 'E' ORDER BY "+p_order_by+" ";
		rs	= stmt.executeQuery(str);
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			int cnt=0;
			if(rs != null)
			{
				while (rs.next())
				{
					i++;

					patient_id		= rs.getString("patient_id") ;
					p_valid_duplicate	= rs.getString("valid_duplicate");
					p_patient_line		= rs.getString("patient_line") ;
					
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
					else if (p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check   = "checked";
					}
					if(cnt==0){
					
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_status_upd_date));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 cnt=1;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

						if(p_valid_check.equals("checked"))
						{
							
            _bw.write(_wl_block25Bytes, _wl_block25);

						}
						
            _bw.write(_wl_block26Bytes, _wl_block26);

						if(p_dup_check.equals("checked"))
						{
							
            _bw.write(_wl_block27Bytes, _wl_block27);

						}
						
            _bw.write(_wl_block28Bytes, _wl_block28);

						if(p_not_check.equals("checked"))
						{
							
            _bw.write(_wl_block25Bytes, _wl_block25);

						}
						
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block30Bytes, _wl_block30);
	}
			} if(rs != null) rs.close();
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_line));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LastProcessedDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Error.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
