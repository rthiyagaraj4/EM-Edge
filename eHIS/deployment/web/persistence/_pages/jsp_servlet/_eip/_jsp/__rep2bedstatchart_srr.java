package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __rep2bedstatchart_srr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/rep2BedStatChart_SRR.jsp", 1720629120583L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<HEAD>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\'../../eCommon/js/CommonCalendar.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\t\tasync function searchCode(obj,target)\n\t\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar locale= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n\t\t\tvar dialogHeight= \"28\" ;\n\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql\t\t=\"\";\n\t\t\tvar search_code\t=\"\";\n\t\t\tvar search_desc\t=\"\";\n\t\t\tvar facilityid = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\tvar tit=\"\";\n\n\t\t\tvar allfacilityid\t=\tdocument.forms[0].p_all_facility_id.value;\n\n\t\t\tif(obj.name==\"nursing_unit_code_fm\" || obj.name==\"nursing_unit_code_to\")\n\t\t\t{\n\t\t\t\ttit=getLabel(\'Common.nursingUnit.label\',\'common\');\n\t\t\t\t//sql=\"select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`\"+allfacilityid+\"` and eff_status = `E` \";\n\t\t\t\tsql=\"select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`\"+allfacilityid+\"` and language_id=`\"+locale+\"` and eff_status = `E` \";\n\t\t\t\tsearch_code=\"nursing_unit_code\";\n\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t}\n\t\t\telse if(obj.name==\"Speciality\")\n\t\t\t{\n\t\t\t\tvar tit=getLabel(\'Common.speciality.label\',\'common\');\n\t\t\t\t//sql=\"select speciality_code,short_desc from am_speciality \";\n\t\t\t\tsql=\"select speciality_code,short_desc from am_speciality_lang_vw where language_id=`\"+locale+\"` \";\n\t\t\t\tsearch_code=\"speciality_code\";\n\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t}\n\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\t\t\t\t\t\t\n\t\t\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\t\t\t\n\t\t\t\ttarget.focus();\n\t\t\t}\n\n\tfunction chkVal(obj)\n\t{\n\n\t\tif ( obj.value == \"All\" )\n\t\t{\n\t\t\t\tdocument.forms[0].p_fr_nursing_unit.disabled = true\n\t\t\t\tdocument.forms[0].p_to_nursing_unit.disabled = true\n\t\t\t\tdocument.forms[0].nursing_unit_code_fm.disabled = true\n\t\t\t\tdocument.forms[0].nursing_unit_code_to.disabled = true\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\tdocument.forms[0].p_fr_nursing_unit.disabled = false\n\t\t\t\tdocument.forms[0].p_to_nursing_unit.disabled = false\n\t\t\t\tdocument.forms[0].nursing_unit_code_fm.disabled = false\n\t\t\t\tdocument.forms[0].nursing_unit_code_to.disabled = false\n\t\t}\n\t\t\t\tdocument.forms[0].p_fr_nursing_unit.value = \"\"\n\t\t\t\tdocument.forms[0].p_to_nursing_unit.value = \"\"\n\t}\n\tfunction chkWithSysDt(obj){\n\t\tif(obj.value!=\'\'){\n\n\t\t\tif(isBeforeNow(obj.value,\"DMY\",localeName))\n\t\t\t\treturn true;\n\t\t\telse {\n\t\t\t\talert(getMessage(\"START_DATE_GREATER_SYSDATE\",\"COMMON\"));\n\t\t\t\tobj.select();\n\t\t\t\tobj.focus();\n\t\t\t\treturn false ;\n\t\t\t}\n\t\t}\n}\n\t</script>\n</HEAD>\n\n<BODY onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<br>\n<br>\n<form name=\"repBedStatChartForm\" id=\"repBedStatChartForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n   <th align=\'left\'> ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n   <tr>\n\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\'>\n\t <tr>\t\t\n\t   \t<td width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" &nbsp;</td>\n\t\t<td class=\"fields\" width=\'20%\' >\t\t\t\t\n\t   \t \t<select name=\'p_all_facility_id\' id=\'p_all_facility_id\' onchange =\"chkVal(this)\">\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t</select>\n\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"center\" width=\"35%\">&nbsp;</td>\n\t\t\t<td class=\"querydata\" width=\"20%\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\"querydata\" width=\"40%\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" &nbsp;</td>\n\t\t\t<td class=\"fields\" width=\'20%\' >\n\t\t\t\t<input type=text id=\"p_date_frm\" name=\'p_fm_trn_date\' id=\'p_fm_trn_date\' size=\"10\" maxlength=\"10\" align=\"center\" onblur=\'if(validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")){chkWithSysDt(this);}\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'p_date_frm\');\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t</td>\t\t\n\t\t\t<td class=\"fields\" width=\'40%\' >\n\t\t\t\t<input type=text id=\"p_date_to\" name=\'p_to_trn_date\' id=\'p_to_trn_date\' size=\"10\" maxlength=\"10\" align=\"center\" onblur=\'if(validDateObj(this,\"DMY\",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")){chkWithSysDt(this);}\'><img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'p_date_to\');\"/>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t</tr>\t\n\n\t\t\n\t\t<tr>\n\n\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" &nbsp;</td>\n\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t<input type=text disabled name=\'p_fr_nursing_unit\' id=\'p_fr_nursing_unit\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' disabled name=\'nursing_unit_code_fm\' id=\'nursing_unit_code_fm\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_fr_nursing_unit)\'>\n\t\t\t</td>\t\t\t\n\t\t\t<td class=\"fields\" width=\'40%\'> \n\t\t\t\t<input type=text  disabled name=\'p_to_nursing_unit\' id=\'p_to_nursing_unit\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' disabled name=\'nursing_unit_code_to\' id=\'nursing_unit_code_to\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_to_nursing_unit)\'>\n\t\t\t</td>\t\t\n\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t\t\t<tr>\n\t\t<td align=\'right\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" &nbsp;</td>\n\t\t<td width=\'40%\'>\n\t\t\t<input type=text  name=\'P_SPL_CODE\' id=\'P_SPL_CODE\' size=\"6\" maxlength=\"6\" align=\"center\"><input type=\'button\' name=\'Speciality\' id=\'Speciality\' value=\'?\' class=\'button\' onclick=\'searchCode(this,P_SPL_CODE)\'>\n\t\t</td>\n\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"p_resp_id\" id=\"p_resp_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<!-- <INPUT TYPE=\"hidden\" name=\"p_passing_local_date\" id=\"p_passing_local_date\" value=\"N\"> -->\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<INPUT TYPE=\"hidden\" name=\"P_passing_local_date\" id=\"P_passing_local_date\" value=\"Y\">\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\n\n</form>\n<script>\n\tdocument.forms[0].p_all_facility_id.focus();\n</script>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
	Statement		stmt	= null;
	ResultSet		rset	= null;	
	Connection		con		= null;
	
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBBDSCT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		StringBuffer sql1 = new StringBuffer();
		try
		{
			con		=	ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String fid;
		String fname;
		
		//sql1.append("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ");
		
		String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");
		
		sql1.append("select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ");				

		rset=stmt.executeQuery(sql1.toString());
		if(rset!=null)
		{
		   while(rset.next())
		   {
			fid=rset.getString("facility_id");
			fname=rset.getString("facility_name");
			if(fid.equals("All"))
			out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
			else
			out.println("<option value='"+fid+ "' >"+fname+"</option>");
		   }
		   if(rset !=null) rset.close(); if(stmt != null) stmt.close();

		}
		}catch(Exception e)
		{
			out.println(e);
		}
		finally { 
				ConnectionManager.returnConnection(con,request);
				}

		   

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( p_resp_id ));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(localeName.equals("en"))
	{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	else if(localeName.equals("th"))
	{
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitCode.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecialityCode.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
