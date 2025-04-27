package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __identifyvalidduplicatedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/IdentifyValidDuplicateDetails.jsp", 1742293133740L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Developed By       :  P.Sudhakaran -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eDR/js/IdentifyValidDuplicates.js\'></script>\n<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].document.getElementById(\'p_patcount\').value = ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="; \n\t\t\t\t\tif(parent.frames[4].document.getElementById(\'duplicatesdetails\').disabled == true)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[4].document.getElementById(\'duplicatesdetails\').disabled = false;\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar ErrorText = getMessage(\'NO_RECORD\',\'DR\');\n\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t\tparent.frames[4].document.getElementById(\'duplicatesdetails\').disabled = true;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<form name=\'group_details_form\' id=\'group_details_form\' action=\'../../servlet/eDR.IdentifyValidDuplicateServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t<table border=\'0\' width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' >\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'7%\' align=\'center\'> <input type=checkbox name=\'selectpatient";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'selectpatient";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onClick=\'javascript:checkDuplicatesDetails(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\' ></td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'15%\' class=\'data\'>&nbsp;&nbsp;&nbsp;&nbsp; ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\'4%\' class=\'label\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<a href=\'javascript:encounterdetails(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\'>E</a>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="E";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t<td width=\'40%\' class=\'data\'   colspan=\'1\' >&nbsp;<font size=1><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\")\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></font><input type=\'hidden\' name=\'selectpatientid";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'selectpatientid";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'></td>\n\t\t\t\t\t\t<td width=\'10%\' align=\'center\'>&nbsp;&nbsp;&nbsp;<input type=\'radio\' name=\'dupindicator";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'dupindicator";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" value=\'V\' onclick=\'assign_value(this,";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =");\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td width=\'10%\' align=\'center\'><input type=\'radio\' name=\'dupindicator";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\'D\'  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" onclick=\'assign_value(this,";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =");\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td width=\'20%\' align=\'center\'><input type=\'radio\' name=\'dupindicator";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" value=\'X\' onclick=\'assign_value(this,";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =");\'><input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'chk_value";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><input type=\'hidden\' name=\'p_value";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'p_value";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td width=\'10%\' align=\'center\'><input type=\'radio\' name=\'dupindicator";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" value=\'E\' onclick=\'assign_value(this,";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =");\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n                        </td>\n\t\t\t\t\t    </tr>\n\t\t\t\t\t    <tr>\n\t\t\t\t\t\t<td width=\'7%\'></td>\n\t\t\t\t\t\t<td width=\'14%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td class=\'data\' colspan=\'6\'><font size=1>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </font></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" <script>\n\t\t\t\t\tvar ErrorText = getMessage(\'NO_RECORD\',\'DR\');\n\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t\tparent.frames[4].document.getElementById(\'duplicatesdetails\').disabled = true;\n\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="               \n \t\t\t</table>\n\t\t\t<input type=hidden name=\"exclude_mode\" id=\"exclude_mode\" value=\"N\">\n\t\t\t<input type=hidden name=patcount id=patcount value=0>\n\t\t\t<input type=hidden name=patient_id1 id=patient_id1 value=\'\'>\n\t\t\t<input type=hidden name=patient_id2 id=patient_id2 value=\'\'>\n\t\t\t<input type=hidden name=p_dup_group_id id=p_dup_group_id value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =">\n\t\t\t<input type=hidden name=p_dup_count id=p_dup_count value=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =">\n\t\t\t<input type=hidden name=p_line id=p_line value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t\t\t<input type=hidden name=count id=count value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n\t\t\t<input type=hidden name=\'final_chk_values\' id=\'final_chk_values\' value=\'\'>\n\t\t\t<input type=hidden name=\'modal\' id=\'modal\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=hidden name=\'del_header\' id=\'del_header\' value=\'N\'>\n\t\t\t<input type=hidden name=\'function_name\' id=\'function_name\' value=\'I\'>\n\t\t\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t</form>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

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

	String locale = (String)session.getAttribute("LOCALE");
	
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	java.sql.Statement	stmt1	= null;
	ResultSet	rs				= null;
     ResultSet	rs1				= null;
	String p_dup_group_id		= "";
	String p_valid_duplicate	= "";
	String p_valid_check		= "";
	String p_dup_check			= "";
	String p_not_check			= "";
	String p_exc_check			= "";
	String p_patient_line		= "";
	String p_line				= "";
	String p_dup_count			= "";
	String p_order_by			= "";
	String str					= "";
	int encounter				= 0;
	StringBuffer p_linesb=null;
	String Facility	="";
     String pat_series="";
	int i = 0;

	try
	{
		p_linesb        = new StringBuffer();
		Facility		= (String) session.getValue("facility_id");
		con				= ConnectionManager.getConnection(request);
		stmt			= con.createStatement();
	   stmt1          = con.createStatement();
		String p_patient_id		= request.getParameter("patient_id");;
		String modal			= request.getParameter("modal");

		if(modal == null) modal = "N";
		
		p_dup_count				= request.getParameter("p_pat_count");

		if(p_patient_id == null)
		{
			p_patient_id = "";
		}

		//str  = "SELECT dup_group_id, pat_count FROM dr_dup_group_vw2 WHERE group_status IN ('U','I') AND system_gen_yn = 'Y' AND patient_id = nvl(('"+p_patient_id+"'), patient_id) ";

		str  = "SELECT b.dup_group_id, pat_count FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND group_status IN ('U','I') AND system_gen_yn = 'Y' AND patient_id = NVL(('"+p_patient_id+"'), patient_id)";
		
		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				p_dup_group_id = rs.getString("dup_group_id");
				p_dup_count    = rs.getString("pat_count") ;
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block9Bytes, _wl_block9);
			
			}
			else
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
		} if(rs != null) rs.close();

		str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
		rs	 = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
		} if(rs != null) rs.close();

		//str   = "SELECT dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate, patient_line,( SELECT Count(*) FROM pr_encounter WHERE patient_id=dr_dup_group_vw2.patient_id) counts FROM dr_dup_group_vw2 WHERE group_status = 'U'  and  dup_group_id='"+p_dup_group_id+"' ORDER BY "+p_order_by+" ";

		str   = "SELECT b.dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line,  ( SELECT COUNT(*) FROM pr_encounter WHERE patient_id=b.patient_id) counts FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND group_status = 'U'  AND b.dup_group_id='"+p_dup_group_id+"' ORDER BY "+p_order_by+" ";		
		
		rs	    = stmt.executeQuery(str);
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(rs != null)
			{
				while(rs.next())
				{
					i++;
					p_patient_id		= rs.getString("patient_id") ;
					p_valid_duplicate	= rs.getString("valid_duplicate");
					p_patient_line		= rs.getString("patient_line") ;
					encounter			= rs.getInt("counts") ;
								

					//p_line	+=	p_patient_id+"|";
					p_linesb.append(p_patient_id);
                    p_linesb.append("|");
					
					if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check	  = "unchecked";
						p_exc_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "checked";
						p_not_check	  = "unchecked";
						p_exc_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check	  = "checked";
						p_exc_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("E"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check	  = "unchecked";
						p_exc_check   = "checked";
					}
				

					String str1="SELECT PAT_SER_GRP_CODE FROM mp_patient WHERE patient_id='"+p_patient_id+"'";
					rs1 = stmt1.executeQuery(str1);
					while(rs1.next())
					{	
					pat_series=rs1.getString("PAT_SER_GRP_CODE");
					}
if(rs1!=null) rs1.close();
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_series));
            _bw.write(_wl_block17Bytes, _wl_block17);
	if(encounter >0)
						{	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_valid_check));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_dup_check));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_not_check));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_valid_duplicate));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_exc_check));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block42Bytes, _wl_block42);

				}
			} 
			p_line=p_linesb.toString();
			
			if(i==0)
		      {     
            _bw.write(_wl_block43Bytes, _wl_block43);
 }if(rs != null) rs.close();
				              
			
			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_line));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Facility));
            _bw.write(_wl_block50Bytes, _wl_block50);

		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block51Bytes, _wl_block51);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
