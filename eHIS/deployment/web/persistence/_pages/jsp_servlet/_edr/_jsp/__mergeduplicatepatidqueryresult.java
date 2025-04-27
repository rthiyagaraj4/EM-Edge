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

public final class __mergeduplicatepatidqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergeDuplicatePatIdQueryResult.jsp", 1734170318370L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergeDuplicatePatient.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey();\'>\n\t<form name=\'search_result_form\' id=\'search_result_form\' action=\'../../servlet/eDR.MergeDuplicateServlet\' method=\'post\' target=\'messageFrame\'>\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\t\t<table border=1 cellpadding=0 cellspacing=0 align=\'center\' ID=\'tb1\'>\t\t\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>alert(getMessage(\'TOOMANY_RECORDS_REFINE_SEARCH\',\'DR\'));\t\t\t\t\t \n\t\t\t\t    parent.frames[2].document.getElementById(\'search\').disabled=false;\t\t\t\t\t \n\t\t\t\t\tparent.frames[2].document.getElementById(\'accept\').disabled=true;\n\t\t\t\t\tself.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr>\n\t\t<th class=\'columnheader\' colspan=\'25\' align=left>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t</tr>\t\t\t\n\t\t <tr><th width=\'2%\' class=\'label\' nowrap align=\'center\'><b>+</b></th>\t\n\t\t<th align=\'center\' nowrap><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></th>\n\t\t<!-- <th align=\'center\' nowrap><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></th> -->\n\t\t<th align=\'center\' nowrap><b>S</b></th>\n\t\t<th align=\'center\' nowrap><b>PC</b></th>\n\t\t<th align=\'center\' nowrap><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></th>\n\t\t<th align=\'center\' nowrap><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></th>\n\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<th align=\'center\' nowrap><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></th>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<th align=\'center\' nowrap><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></th>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t  <th nowrap ><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></th>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<th nowrap ><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t \n\t\t\t <th nowrap ><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b></th>\n\t\t\t <th nowrap ><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\n\t\t\n\t\t \n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<td class=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" align=\'center\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t <TD nowrap class=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">&nbsp;</TD>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t <TD nowrap class=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="></TD> \n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" align=\'center\'  nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\t\t\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" nowrap align=\'center\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<td class=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\n\t\t<td class=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t<td class=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\t\t\n\t\t<td class=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\t\n\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t</table>\n\t\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n \n\t \n\t <script>\n        parent.frames[2].document.getElementById(\'search\').disabled=false;\n\t \n\t\tvar count = document.getElementById(\'count\').value ;\t\t \n\t\tif(parseInt(count) > 1 && parseInt(count) <=20) {  \n\t\t\tparent.frames[2].document.getElementById(\'accept\').disabled=false;\n\t\t} else {  \n\t\t   parent.frames[2].document.getElementById(\'accept\').disabled=true;\n\t\t}\n\n\t</script> \n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'delete\'>\n\t<input type=\'hidden\' name=\'fin_query\' id=\'fin_query\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n\t<input type=\'hidden\' name=\'date_form\' id=\'date_form\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'> \n\t<input type=\'hidden\' name=\'date_val\' id=\'date_val\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'> \n\t<input type=\'hidden\' name=\'search_all\' id=\'search_all\' value=\'\'> \n\t<input type=\'hidden\' name=\'p_line\' id=\'p_line\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'> \n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\'Y\'> \n\t<input type=\'hidden\' name=\'asc_desc\' id=\'asc_desc\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'> \n\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

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
	
	String locale = (String)session.getAttribute("LOCALE");
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.PreparedStatement pstmt	= null;	 
	ResultSet rs				= null;
	ResultSet rs1				= null;	 
	StringBuffer fin_querysb	= null;
	StringBuffer date_query		= null;	 
	 
	StringBuffer p_linesb		= null;	 
	String asc_desc="1";	 
	String first_name_init		= "";  
	String second_name_init		= "";
	String third_name_init		= "";
	String family_name_init		= "";
	String first_name_prompt	= "";	
	String second_name_prompt	= "";	
	String third_name_prompt	= "";	
	String family_name_prompt	= "";
	String area_type			= "";
	String classValue			= "";
	String str					= "";	 
	String s_lable					= "";	 
 
	int i					= 1;
	int count				= 0;

	String facilityId	= (String) session.getValue("facility_id");

//	String from			= request.getParameter("from");
//	String to			= request.getParameter("to");
	String p_line		= request.getParameter("p_line")==null?"":request.getParameter("p_line");
	
//	String acc_btn_dis		= request.getParameter("acc_btn_dis")==null?"":request.getParameter("acc_btn_dis");
	String fin_query	= request.getParameter("final_query");
//	String call_again	= "";
	String date_val		= request.getParameter("date_val");
	String date_form	= request.getParameter("date_form");
//	String order_by_val	= request.getParameter("order_by_val");
//	if(order_by_val==null) order_by_val="";
	String all_facil	= request.getParameter("all_facil");
	asc_desc = request.getParameter("asc_desc") == null ? "1" : request.getParameter("asc_desc");
	String date_value = "" ;
	String names_in_oth_lang_yn = "" ;
	try
	{ 
		
	//	call_again	= request.getParameter("call_again");	 
		fin_querysb		= new StringBuffer();
		date_query		= new StringBuffer(); 
		p_linesb		= new StringBuffer();
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();			 
		 if(date_val != null) {			 
			date_value =  DateUtils.convertDate(date_val,"DMY",locale,"en");			
			if(date_form.equals("Y")) {
					date_query.append("");
					date_query.append(" AND ");
					date_query.append("to_number(to_char(date_of_birth,'YYYY')) = "+"to_number(to_char(to_date('"+date_value+"','DD/MM/RRRR'),'YYYY'))");
			}else if(date_form.equals("MY")) {
					date_query.append("");
					date_query.append(" AND ");
					date_query.append("to_date(to_char(date_of_birth,'MMYYYY'),'MMYYYY') = "+"to_date(to_char(to_date('"+date_value+"','DD/MM/RRRR'),'MMYYYY'),'MMYYYY')");
			}else if(date_form.equals("D")) {
					date_query.append("");
					date_query.append(" AND ");
					date_query.append("date_of_birth between to_date('"+date_value+"','dd/mm/yyyy') AND TO_DATE ('"+date_value+" 23:59:59', 'dd/mm/yyyy hh24:mi:ss') ");					   
			}
		}		 
		
        fin_querysb.append(fin_query);
		fin_querysb.append(date_query);
		if(!all_facil.equals("N")) {
				fin_querysb.append(" AND regn_facility_id = '"+facilityId+"'");
		}
				
	 
		
		str="";
		
		if(rs!=null) rs.close();
		
		str="";
		str="SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, nvl(first_name_prompt,'First name') first_name_prompt,nvl(second_name_prompt,'Second name') second_name_prompt, nvl(third_name_prompt,'Third name') third_name_prompt ,nvl(family_name_prompt,'Family name') family_name_prompt,nvl(first_name_loc_lang_prompt,'First Name Loc Lang') first_name_loc_lang_prompt 		,nvl(second_name_loc_lang_prompt,'Second Name Loc Lang') second_name_loc_lang_prompt ,nvl(third_name_loc_lang_prompt,'Third Name Loc Lang') third_name_loc_lang_prompt ,nvl(family_name_loc_lang_prompt,'Family Name Loc Lang') family_name_loc_lang_prompt , accept_national_id_no_yn,nvl(Nat_ID_Prompt,'National ID No') Nat_ID_Prompt, mp_get_desc.mp_alternate_id_type (alt_id1_type, '"+locale+"', 1) alt_id1_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,'"+locale+"', 1) alt_id2_desc,       mp_get_desc.mp_alternate_id_type (alt_id3_type, '"+locale+"', 1) alt_id3_desc, mp_get_desc.mp_alternate_id_type (alt_id4_type, '"+locale+"', 1) alt_id4_desc,accept_oth_alt_id_yn,dflt_sndx_type, res_area_prompt,search_threshold_records,names_in_oth_lang_yn FROM mp_param_lang_vw a, sm_site_param_lang_vw b WHERE a.language_id = '"+locale+"' AND b.language_id = '"+locale+"'";		
		 
		String first_name_loc_lang_prompt = "";
		String second_name_loc_lang_prompt = "";
		String third_name_loc_lang_prompt = "";
		String family_name_loc_lang_prompt = "";
		String accept_national_id_no_yn = "";
		String Nat_ID_Prompt = "";
		String alt_id1_desc = "";
		String alt_id2_desc = "";
		String alt_id3_desc = "";
		String alt_id4_desc = "";
		String accept_oth_alt_id_yn = "";
		rs = stmt.executeQuery(str);
		if(rs!=null)
		{
			if(rs.next())
			{
				first_name_init        =rs.getString("first_name_accept_yn")==null?"":rs.getString("first_name_accept_yn");
				 second_name_init		=rs.getString("second_name_accept_yn")==null?"":rs.getString("second_name_accept_yn");
				 third_name_init		=rs.getString("third_name_accept_yn")==null?"":rs.getString("third_name_accept_yn");
				 family_name_init		=rs.getString("family_name_accept_yn")==null?"":rs.getString("family_name_accept_yn");
				 first_name_prompt		=rs.getString("first_name_prompt")==null?"":rs.getString("first_name_prompt");
				 second_name_prompt		=rs.getString("second_name_prompt")==null?"":rs.getString("second_name_prompt");
				 third_name_prompt		=rs.getString("third_name_prompt")==null?"":rs.getString("third_name_prompt");
				 family_name_prompt		=rs.getString("family_name_prompt")==null?"":rs.getString("family_name_prompt");
				 area_type				=rs.getString("res_area_prompt")==null?"":rs.getString("res_area_prompt");
				 names_in_oth_lang_yn				=rs.getString("names_in_oth_lang_yn")==null?"":rs.getString("names_in_oth_lang_yn");
				 first_name_loc_lang_prompt				=rs.getString("first_name_loc_lang_prompt")==null?"":rs.getString("first_name_loc_lang_prompt");
				 second_name_loc_lang_prompt				=rs.getString("second_name_loc_lang_prompt")==null?"":rs.getString("second_name_loc_lang_prompt");
				 third_name_loc_lang_prompt				=rs.getString("third_name_loc_lang_prompt")==null?"":rs.getString("third_name_loc_lang_prompt");
				 family_name_loc_lang_prompt				=rs.getString("family_name_loc_lang_prompt")==null?"":rs.getString("family_name_loc_lang_prompt");
				 accept_national_id_no_yn				=rs.getString("accept_national_id_no_yn")==null?"":rs.getString("accept_national_id_no_yn");
				 Nat_ID_Prompt				=rs.getString("Nat_ID_Prompt")==null?"":rs.getString("Nat_ID_Prompt");
				 alt_id1_desc				=rs.getString("alt_id1_desc")==null?"":rs.getString("alt_id1_desc");
				 alt_id2_desc				=rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
				 alt_id3_desc				=rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
				 alt_id4_desc				=rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
				 accept_oth_alt_id_yn				=rs.getString("accept_oth_alt_id_yn")==null?"":rs.getString("accept_oth_alt_id_yn");
			}	
		} if(rs!=null) rs.close();

			 
		String modeQuery="select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = '"+locale+"'";
		String cnt_mode = "";
		String prn_label = "";
		String orn_label = "";

		rs = stmt.executeQuery(modeQuery);
		while(rs.next()){
				cnt_mode=rs.getString("contact_mode");
			if(cnt_mode.equals("PRN"))
				prn_label=rs.getString("short_desc")==null?"":rs.getString("short_desc");
			if(cnt_mode.equals("ORN"))
				orn_label=rs.getString("short_desc")==null?"":rs.getString("short_desc");
		}	
		 if(rs!=null) rs.close();	 
	

	StringBuffer sqlQuery = new StringBuffer();
	 
	sqlQuery.append("SELECT patient_id,curr_patient_class,patient_name_loc_lang ,first_name, second_name, third_name, family_name, national_id_no, alt_id1_no, alt_id2_no, alt_id3_no, alt_id4_no, oth_alt_id_no,mp_get_desc.mp_res_area (res_area_code, 'en', 2) area_desc,active_yn, suspend_yn, deceased_yn, sex, (CASE WHEN oth_alt_id_no IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = oth_alt_id_type AND language_id = '"+locale+"') END) other_alt_id_type_desc, TO_CHAR (date_of_birth, 'dd/mm/yyyy') date_of_birth, contact1_no, contact2_no,first_name_loc_lang, second_name_loc_lang, third_name_loc_lang,family_name_loc_lang FROM mp_patient where ");
	if(!fin_querysb.equals(""))
		sqlQuery.append(fin_querysb);	 
		
		rs1 = stmt.executeQuery(sqlQuery.toString());

            _bw.write(_wl_block9Bytes, _wl_block9);

		 
		pstmt=con.prepareStatement(sqlQuery.toString());
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		rs1=pstmt.executeQuery();
	 
		int header = 0;
		
            _bw.write(_wl_block11Bytes, _wl_block11);

		while((rs1 != null && rs1.next())) {				
			count++;
			 
			if(count==21){
				
            _bw.write(_wl_block12Bytes, _wl_block12);

				break;
			}
			
	 
		if(header==0) {		 
	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 		
		if(first_name_init.equals("Y")){
		if(!first_name_prompt.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(first_name_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}}
		if(second_name_init.equals("Y")){
		if(!second_name_prompt.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(second_name_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}}
		if(third_name_init.equals("Y")){
		if(!third_name_prompt.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(third_name_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}}
		if(family_name_init.equals("Y")){
		if(!family_name_prompt.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(family_name_prompt));
            _bw.write(_wl_block20Bytes, _wl_block20);
}}
		if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		if(first_name_init.equals("Y")){
			if(!first_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(first_name_loc_lang_prompt));
            _bw.write(_wl_block22Bytes, _wl_block22);

			} 
		  }		
		if(second_name_init.equals("Y")){
			if(!second_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(second_name_loc_lang_prompt));
            _bw.write(_wl_block22Bytes, _wl_block22);

			} 
		  }		
		if(third_name_init.equals("Y")){
			if(!third_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(third_name_loc_lang_prompt));
            _bw.write(_wl_block22Bytes, _wl_block22);

			} 
		  }		
		if(family_name_init.equals("Y")){
			if(!family_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(family_name_loc_lang_prompt));
            _bw.write(_wl_block22Bytes, _wl_block22);

			} 
		  }
		}
		if(accept_national_id_no_yn.equals("Y")){
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Nat_ID_Prompt));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
		if(!alt_id1_desc.equals("")){
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id1_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
		if(!alt_id2_desc.equals("")){
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}if(!alt_id3_desc.equals("")){
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id3_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}if(!alt_id4_desc.equals("")){
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
		if(accept_oth_alt_id_yn.equals("Y")){
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		if(!area_type.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(area_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
} if(!prn_label.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prn_label));
            _bw.write(_wl_block20Bytes, _wl_block20);
}if(!orn_label.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(orn_label));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
	
		}
		 	
			p_linesb.append(rs1.getString("patient_id"));		 
			p_linesb.append("|");		 
	
		if(i % 2 == 0) classValue = "QRYEVEN" ;
				else classValue = "QRYODD" ;		
		
		if(rs1.getString("deceased_yn").equals("Y")){
			s_lable="DECEASED";
		}else if(rs1.getString("suspend_yn").equals("Y")){
			s_lable="SUSPENDED";
		}else if(rs1.getString("active_yn").equals("N")){
			s_lable="INACTIVE";
		}
	
		out.println("<tr><td class='" + classValue + "' nowrap align='center'>");
		out.println("<a href=javascript:viewPatientDetails('"+rs1.getString("patient_id")+"')>");
		out.println("+</a></td>");
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("patient_id")));
            _bw.write(_wl_block31Bytes, _wl_block31);
			 
		if(s_lable.equals("")){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{ 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(s_lable));
            _bw.write(_wl_block35Bytes, _wl_block35);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("curr_patient_class")==null?"&nbsp;":rs1.getString("curr_patient_class")));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(rs1.getString("sex").equals("M")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
} else if(rs1.getString("sex").equals("F")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
} else if(rs1.getString("sex").equals("U")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(DateUtils.convertDate(rs1.getString("date_of_birth"),"DMY","en",locale)));
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(first_name_init.equals("Y")){
		if(!first_name_prompt.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs1.getString("first_name")==null?"&nbsp;":rs1.getString("first_name")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}}
		if(second_name_init.equals("Y")){
		if(!second_name_prompt.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs1.getString("second_name")==null?"&nbsp;":rs1.getString("second_name")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}}
		if(third_name_init.equals("Y")){
		if(!third_name_prompt.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs1.getString("third_name")==null?"&nbsp;":rs1.getString("third_name")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}}
		if(family_name_init.equals("Y")){
		if(!family_name_prompt.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs1.getString("family_name")==null?"&nbsp;":rs1.getString("family_name")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}}
		if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("patient_name_loc_lang")==null?"&nbsp;":rs1.getString("patient_name_loc_lang")));
            _bw.write(_wl_block31Bytes, _wl_block31);
		
		if(first_name_init.equals("Y")){
			if(!first_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("first_name_loc_lang")==null?"&nbsp;":rs1.getString("first_name_loc_lang")));
            _bw.write(_wl_block40Bytes, _wl_block40);

			} 
		  }
		  if(second_name_init.equals("Y")){
			if(!second_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("second_name_loc_lang")==null?"&nbsp;":rs1.getString("second_name_loc_lang")));
            _bw.write(_wl_block40Bytes, _wl_block40);

			} 
		  }
		  if(third_name_init.equals("Y")){
			if(!third_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("third_name_loc_lang")==null?"&nbsp;":rs1.getString("third_name_loc_lang")));
            _bw.write(_wl_block40Bytes, _wl_block40);

			} 
		  }
		  if(family_name_init.equals("Y")){
			if(!family_name_loc_lang_prompt.equals("")){ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("family_name_loc_lang")==null?"&nbsp;":rs1.getString("family_name_loc_lang")));
            _bw.write(_wl_block40Bytes, _wl_block40);

			} 
		  }
		}
		if(accept_national_id_no_yn.equals("Y")){
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("national_id_no")==null?"&nbsp;":rs1.getString("national_id_no")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
		if(!alt_id1_desc.equals("")){
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("alt_id1_no")==null?"&nbsp;":rs1.getString("alt_id1_no")));
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
		if(!alt_id2_desc.equals("")){
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("alt_id2_no")==null?"&nbsp;":rs1.getString("alt_id2_no")));
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
		if(!alt_id3_desc.equals("")){
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("alt_id3_no")==null?"&nbsp;":rs1.getString("alt_id3_no")));
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
		if(!alt_id4_desc.equals("")){
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("alt_id4_no")==null?"&nbsp;":rs1.getString("alt_id4_no")));
            _bw.write(_wl_block31Bytes, _wl_block31);
} 
		if(accept_oth_alt_id_yn.equals("Y")){
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("other_alt_id_type_desc")==null?"&nbsp;":rs1.getString("other_alt_id_type_desc")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("oth_alt_id_no")==null?"&nbsp;":rs1.getString("oth_alt_id_no")));
            _bw.write(_wl_block31Bytes, _wl_block31);
} if(!area_type.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rs1.getString("area_desc")==null?"&nbsp;":rs1.getString("area_desc")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("contact1_no")==null?"&nbsp;":rs1.getString("contact1_no")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rs1.getString("contact2_no")==null?"&nbsp;":rs1.getString("contact2_no")));
            _bw.write(_wl_block45Bytes, _wl_block45);
	 
			i++;	
			header++;		
		
            _bw.write(_wl_block46Bytes, _wl_block46);
  }// while loop
	
            _bw.write(_wl_block47Bytes, _wl_block47);

		
	if(count==0){				 
				 	
	 	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	} 
		 p_line=p_linesb.toString();
		 

	 	fin_query=fin_querysb.toString();
		if(fin_querysb!=null || fin_querysb.length() >0)
		fin_querysb.setLength(0);
		if(date_query!=null || date_query.length() >0)
		date_query.setLength(0);	 
		if(p_linesb!=null || p_linesb.length() >0)
		p_linesb.setLength(0);
		
		if (rs!=null) rs.close();
		if(stmt !=null) stmt.close();
		if(rs1 != null) rs1.close();
        if(pstmt !=null) pstmt.close();
		 
	}
	catch(Exception es)
	{
		out.println("Exception display query "+es);
		es.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(count));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(fin_query));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(date_form));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(date_value));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_line));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.PossibleDuplicates.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientNameInLocalLang.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OtherAltType.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OtherAltNo.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
