package jsp_servlet._emr._jsp;

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
import webbeans.eCommon.ConnectionManager;

public final class __adversereactionresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AdverseReactionResult.jsp", 1717399724818L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\">\t</script>\n\t\t<script language=\'javascript\' src=\'../js/AdverseReaction.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<!-- <script language=\"JavaScript\" src=\"../js/eMRmessages.js\"></script> // file not found -->\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t \n\t </head>\n\t<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n\t<form name=\'Adverse_reaction_res\' id=\'Adverse_reaction_res\' action=\'../../servlet/eMR.AdverseReactionServlet\' method=\'post\' target=\'messageFrame\' > \n\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<P>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<td align =\'right\' id=\'prev\'><A HREF=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"Previous\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A></td>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td align =\'right\' id=\'next\'><A HREF=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\",\"Next\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</A></td>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</tr>\n\t\t</td>\n\t\t</table>\n\t\t<br><br>\n\t\t</P>\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'85%\' align=\'center\'>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<input type=\'checkbox\' name=\'selectall\' id=\'selectall\' onClick=\'selectAll_S(this);\' ></th>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' width=\'14%\' nowrap>&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" nowrap width=\'2%\'>&nbsp;<input type=\'checkbox\' id=\'check_box\'name=\'checkBox";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'onClick=\'javascript:checkBoxOnClick(this);\' value=\'\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ><input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'ret_value";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'causative_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'causative_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'reaction_val";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'reaction_val";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n \t\t\t\t<input type=\'hidden\' name=\'cnt\' id=\'cnt\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'eff_status1\' id=\'eff_status1\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'fin_vals\' id=\'fin_vals\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'adv_reac_code\' id=\'adv_reac_code\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'adv_reac_long_desc\' id=\'adv_reac_long_desc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'adv_reac_short_desc\' id=\'adv_reac_short_desc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'eff_status\' id=\'eff_status\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'causative_code_val\' id=\'causative_code_val\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'reaction_fin_val\' id=\'reaction_fin_val\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'reac_code\' id=\'reac_code\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'adv_event_type_ind\' id=\'adv_event_type_ind\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'adv_event_type\' id=\'adv_event_type\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'finalval\' id=\'finalval\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'allergen_code_all\' id=\'allergen_code_all\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'search_txt\' id=\'search_txt\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'isOnApply\' id=\'isOnApply\' value=\'N\'>\n\t\t\t\t<input type=\'hidden\' name=\'cnt_to\' id=\'cnt_to\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'end\' id=\'end\' value=\'\'>\n\n\t\t\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );
	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	? "" : inputString;
		}

		private String checkForNull(String inputString, String defaultValue)
		{
			return (inputString==null)	? defaultValue : inputString;
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle	=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String locale			= (String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		Statement stmt1=null;
		ResultSet rsas=null;
		ResultSet rsas1=null;
		ResultSet rs=null;
		String mode="";
		String checkBoxAttribute="";
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";
		//String from = request.getParameter( "from" )==null?"":request.getParameter("from");
		//String from = checkForNull(request.getParameter("from"));
		
		//String to = request.getParameter( "to" )==null?"":request.getParameter("to") ;
		//String to = checkForNull(request.getParameter("to"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		int start = 0 ;
		int end = 0 ;
		String causative_code="";
		String causative_desc="";
		int m=1;
				String adv_event_type_ind_desc="";
				String reac_code="";
				reac_code=request.getParameter("reac_code");
				if(reac_code ==null ) reac_code="";
				String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
				String adv_event_type_ind=request.getParameter("adv_event_indicator")==null?"":request.getParameter("adv_event_indicator");



				String classValue	 = "";
				String eff_status="";
				String sql_cnt="";
				int maxRecord=0;
				if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
				end = 15 ;
			else
				end = Integer.parseInt( to ) ;


	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
//out.println("<script>alert(\"search_txt :"+search_txt+"\");</script>");
	if(search_by == null) search_by="";
	if(search_txt == null) search_txt="";

	String search_by1="";
	String search_by2="";

	
	if(search_by.equals("01"))
	{
	   search_by1="ALLERGEN_CODE";
	   search_by2="GENERIC_ID";
	}
	else if(search_by.equals("02"))
	{
		search_by1="LONG_DESC";
		search_by2="GENERIC_NAME";
	}

	

		 
            _bw.write(_wl_block9Bytes, _wl_block9);
	try
		{
 
				conn = ConnectionManager.getConnection(request);
				stmt1 = conn.createStatement();
				

	if(adv_event_type.equals("DA"))
			{
			
				if(!search_by.equals("") && !search_txt.equals(""))
				{
					sql_cnt="SELECT count(1) count from (SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' and upper(mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"' and upper(a."+search_by2+")  like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code, mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM MR_ALLERGEN  WHERE  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') and upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') and upper("+search_by2+")  like upper('"+search_txt+"%'))";
				}else
				{
					sql_cnt="SELECT count(1) count from (SELECT a.ALLERGEN_CODE code, a.long_desc description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"'  UNION SELECT ALLERGEN_CODE code, long_desc description,'N' eff_status1 FROM MR_ALLERGEN  WHERE   ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"'))";
				}
				 
			}else
			{
					

			if(!search_by.equals("") && !search_txt.equals(""))
				{
				sql_cnt="SELECT  count(1) count from ( SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1) description, 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code AND upper(mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"'AND upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"'))";
				}else
				{
				sql_cnt="SELECT  count(1) count from ( SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1) description, 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"'))";
				}
//out.println("<script>alert(\"search_txt :"+sql_cnt+"\");</script>");

			}
			rsas1=stmt1.executeQuery(sql_cnt);
			if(rsas1 !=null && rsas1.next())
			{
				maxRecord=rsas1.getInt("count");
			}
		if(adv_event_type_ind.equals("01"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergy.label","common_labels");
					}else if(adv_event_type_ind.equals("02"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels") + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeII.label","mr_labels");
					}else if(adv_event_type_ind.equals("03"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeIII.label","mr_labels");
					}else if(adv_event_type_ind.equals("04"))
					{
						adv_event_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeIV.label","mr_labels");
					}
				int k=0;
				
				String sql_list="";
				if(adv_event_type.equals("DA"))
			{
			
				if(!search_by.equals("") && !search_txt.equals(""))
				{
					sql_list="SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND a.allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) and upper(mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"' and upper(a."+search_by2+")  like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code, mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM MR_ALLERGEN  WHERE ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') AND allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) and upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1))  like upper('"+search_txt+"%') UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') and upper("+search_by2+")  like upper('"+search_txt+"%')";
				}else
				{
					sql_list="SELECT a.ALLERGEN_CODE code,  mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description,'Y' eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' AND  ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND a.allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) UNION SELECT a.GENERIC_ID code, a.GENERIC_NAME description, 'Y' eff_status1 FROM PH_GENERIC_NAME a,mr_adv_rea_cause_agent b where a.generic_id = b.ALLERGEN_CODE and b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' and b.adv_reac_code ='"+reac_code+"'  UNION SELECT ALLERGEN_CODE code,  mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM MR_ALLERGEN  WHERE ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') AND allergen_code NOT IN ( SELECT generic_id FROM ph_generic_name) UNION SELECT GENERIC_ID code, GENERIC_NAME description,'N' eff_status1 FROM PH_GENERIC_NAME  WHERE GENERIC_ID NOT IN(SELECT ALLERGEN_CODE FROM MR_ADV_REA_CAUSE_AGENT WHERE ADV_REAC_CODE='"+reac_code+"' and ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"') ";
				}
				
		

				sql_list=sql_list+" order by description ";



			}else
			{
				//sql_list="SELECT   a.ALLERGEN_CODE code, a.long_desc description,b.eff_status eff_status1 FROM MR_ALLERGEN a, mr_adv_rea_cause_agent b WHERE b.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND a.ALLERGEN_CODE = b.ALLERGEN_CODE AND b.adv_reac_code ='"+reac_code+"' ";

				
				
				if(!search_by.equals("") && !search_txt.equals(""))
				{
				sql_list="SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description , 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code AND upper(mr_get_desc.mr_allergen(b.allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"'AND upper(mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1)) like upper('"+search_txt+"%') AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"')";
				}else
				{
				sql_list="SELECT a.ALLERGEN_CODE code, mr_get_desc.mr_allergen(a.allergen_code,'"+locale+"',1) description, 'Y' eff_status1 FROM mr_adv_rea_cause_agent a, mr_allergen b WHERE  a.adv_reac_code ='"+reac_code+"' AND a.ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND b.ADV_EVENT_TYPE_CODE='"+adv_event_type+"'and a.allergen_code=b.allergen_code UNION SELECT ALLERGEN_CODE code,mr_get_desc.mr_allergen(allergen_code,'"+locale+"',1) description,'N' eff_status1 FROM  MR_ALLERGEN WHERE ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"' AND ADV_EVENT_TYPE_CODE='"+adv_event_type+"' AND ALLERGEN_CODE NOT IN(SELECT DISTINCT ALLERGEN_CODE FROM mr_adv_rea_cause_agent WHERE adv_reac_code ='"+reac_code+"' AND ADV_EVENT_TYPE_IND = '"+adv_event_type_ind+"')";
				}


				sql_list=sql_list+" order by description ";
			}
				rsas=stmt1.executeQuery(sql_list);

            _bw.write(_wl_block10Bytes, _wl_block10);

	int start_val=start-15;
	int end_val=end-15;
		if ( !(start <= 1) )
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start_val));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end_val));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}

		if ( !( (start+15) > maxRecord ) )
			{
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}	
            _bw.write(_wl_block18Bytes, _wl_block18);
if(maxRecord > 0){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}
	
			
			if ( start != 1 )
			 for( int j=1; j<start; m++,j++ ){
			  rsas.next() ;

			  }

			while ( rsas.next() && m<=end )
			{
							causative_code =	rsas.getString("code");
							causative_desc =	rsas.getString("description");
							eff_status     =    rsas.getString("eff_status1");
							if(eff_status ==null) eff_status="";
								if(adv_event_type.equals("DA"))
			{
							if(eff_status.equals("Y") )
							{
								checkBoxAttribute="CHECKED";
							}else {
								checkBoxAttribute="";

							}
			}else
				{
					if(eff_status.equals("Y") )
							{
								checkBoxAttribute="CHECKED";
							}else {
								checkBoxAttribute="";

							}
			}
						if ( m % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(causative_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(k));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(adv_event_type_ind));
            _bw.write(_wl_block34Bytes, _wl_block34);
	
					k=k+1;
					m++;	
					
				  }
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((start+15)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(reac_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(adv_event_type_ind));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(adv_event_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((end+15)));
            _bw.write(_wl_block43Bytes, _wl_block43);

		if(rs !=null) rs.close();
		if(rsas !=null) rsas.close();
		if(stmt1 !=null) stmt1.close();
		if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));				parent.frames[2].location.href='../../eCommon/html/blank.html';</script>");
				}
	}catch(Exception e)
	{
		out.println("Exception "+e);
		e.printStackTrace();

	}finally{
			ConnectionManager.returnConnection(conn,request);

	}
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Allergen.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}
