package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesprevnotessearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesPrevNotesSearchCriteria.jsp", 1742465475765L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"> -->\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n\t<style type=\'text/css\'>\n\t\n\timg\n\t{\n\t\tborder:0;\n\t}\n\t</style>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<center>\n<form name=\'RecClinicalNotesPrevNotesCriteriaForm\' id=\'RecClinicalNotesPrevNotesCriteriaForm\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t\t<td class=\"LABEL\"  width=\'25%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t<td class=\"fields\" width=\'25%\' ><input type=\'text\' name=\'from_date_time\' id=\'from_date_time\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" size=\'14\' maxLength=\'16\'  onBlur=\'return validateFromAndToDates(this,to_date_time, \"DMYHM\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\'><button id=\"common_calendar\" type=\"button\" style=\"background: none; border: none; padding: 0; margin: 0; display: inline-block;\" onclick=\"return showCalendarValidate(\'from_date_time\');\">\n            <img src=\"../../eCommon/images/CommonCalendar.gif\" alt=\"Calendar Icon\" style=\"width: 100%; height: auto; display: block;\">\n        </button>\n\t\t<td class=\"LABEL\"  width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'to_date_time\' id=\'to_date_time\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=\'14\' maxLength=\'16\'  onBlur=\'return validateFromAndToDates(from_date_time,this,\"DMYHM\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\");\'><button id=\"common_calendar\" type=\"button\" style=\"background: none; border: none; padding: 0; margin: 0; display: inline-block;\" onclick=\"return showCalendarValidate(\'to_date_time\');\">\n            <img src=\"../../eCommon/images/CommonCalendar.gif\" alt=\"Calendar Icon\" style=\"width: 100%; height: auto; display: block;\">\n        </button></td>\n\t</tr>\n\t<tr>\t\n\t\t<td class=\"LABEL\" width=\'25%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\"fields\" width=\'25%\'><SELECT name=\"status\" id=\"status\">\n\t\t<option value=\'0\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t<option value=\'4\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t<option value=\'5\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t</SELECT></td>\n\n\t\t<td class=\"LABEL\" width=\'25%\' > ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=\"fields\" width=\'25%\'><select name=\"note_group\" id=\"note_group\" id=\"note_group\" onchange=\"populateNoteTypesForGroup(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'Prev_Notes\');\">\n\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---------- ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="---------- &nbsp;&nbsp;&nbsp;&nbsp;</option>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</select></td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td class=\"LABEL\" width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t<td class=\"fields\" width=\'25%\'><select name=\"note_type\" id=\"note_type\" >\n\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---------- ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</select></td>\n\t\t\t\n\t<td width=\'25%\'></td>\n\t<td class=\"fields\"  width=\'25%\'> \n\t<input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' class=\'BUTTON\' onClick=\"return showSearchData();\"> &nbsp;\n\t&nbsp;<input type=\'button\' name=\'back\' id=\'back\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\'BUTTON\'onClick=\"switchToNote();\"></td>\n\t</tr>\n\t</table>\n\t\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<img src=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' width=\'100%\' height=\'15\'/> \n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\'\tvalue=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\'\tvalue=\'\'>\n\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\'\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\'hidden\' name=\'appl_task_id\' id=\'appl_task_id\'\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n</form>\n</center>\n</body>\n<script language=\'javascript\'>\nif(validateFromAndToDates(document.getElementById(\"from_date_time\"),document.getElementById(\"to_date_time\"),\"DMYHM\",\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"))\n{\t\n\tparent.RecClinicalNotesPrevNotesSearchDetailFrame.location.href = \"../../eCA/jsp/RecClinicalNotesPrevNotesSearchDetail.jsp?from_date_time=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&to_date_time=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&note_group=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&note_type=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&status=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" \";\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String imgUrl="";
	
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	String styleMap = "";
	if(sStyle.equals("IeStyleBlue.css"))
	{
		styleMap = "Blue";
	}
	else if(sStyle.equals("IeStyleLime.css"))
	{
		styleMap = "Lime";
	}
	else if(sStyle.equals("IeStyleOrange.css"))
	{
		styleMap = "Orange";
	}
	else if(sStyle.equals("IeStyleVoilet.css"))
	{
		styleMap = "Violet";
	}
	else
	{
		styleMap = "";
	}
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection			con1		=	null;
	
	PreparedStatement	pstmt1	=	null;
	PreparedStatement	pstmt2	=	null;
	PreparedStatement	pstmt3	=	null;
	ResultSet			rs1		=	null;
	ResultSet			rs2		=	null;
	ResultSet			rs3		=	null;
	String	query_string		=	"";
	String	from_date_time		=	"",		to_date_time		=	"";
	String  sys_date_time="";
	String  note_type			=	"",		note_type_desc		=	"";
	String  note_group			=	"",		appl_task_id		=	"";
	String  note_group_desc		=	"";
	String parent_note_type="";
	String parent_note_group="";
	String pre_ql_ref=request.getParameter("pre_ql_ref")==null?"":request.getParameter("pre_ql_ref");
	String noteGroupSql="";
	
	if(!pre_ql_ref.equals("")){
	parent_note_type=(request.getParameter("parent_note_type")==null)	?	""	:	request.getParameter("parent_note_type");
	parent_note_group=(request.getParameter("parent_note_group")==null)	?	""	:	request.getParameter("parent_note_group");
	}
	
	
	StringBuffer query_header_details = new StringBuffer();
	String resp_id			=	(String)		session.getValue("responsibility_id");
	String patient_class	=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
//	String categoryId          =   request.getParameter("categ_id")==null?"":request.getParameter("categ_id");
	appl_task_id          =   request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String prev_notes_indicator = request.getParameter("prev_notes")==null?"N":request.getParameter("prev_notes");//IN043031

	//Added By DINESH T for CRF 789
	if(pre_ql_ref.equals(""))
	{
	from_date_time=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	to_date_time=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	}
	
	//IN043031 Starts
	if("Y".equals(prev_notes_indicator))
	{
		try
		{
			con1				=	ConnectionManager.getConnection();
			StringBuilder ca_note_param_qry = new  StringBuilder();
			String curr_date = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			ca_note_param_qry.append("SELECT VW_PREV_NOTE_DAYS FROM CA_NOTE_PARAM WHERE MODULE_ID=?");
			pstmt1		=	con1.prepareStatement(ca_note_param_qry.toString());
			pstmt1.setString(1, "CA");
			rs1=pstmt1.executeQuery();
			while(rs1.next())
			{
				from_date_time = com.ehis.util.DateUtils.minusDate(curr_date, "DMYHM", locale, rs1.getInt("VW_PREV_NOTE_DAYS"), "d");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			rs1.close();
			pstmt1.close();
			if(con1!=null) ConnectionManager.returnConnection(con1,request);
		}
		
	}
	//IN043031 Ends
	
	HashMap funcFilter=new HashMap();
	ArrayList per_from=new ArrayList();
	ArrayList per_to=new ArrayList();
	ArrayList status=new ArrayList();
	String statusValue="0";
	String note_grp_value="";
	String note_type_value="";
	String noteGrp_value="";
	String noteType_value="";
	ArrayList funcCriteria = new ArrayList();
	ArrayList note_grp=new ArrayList();
	ArrayList note_typ=new ArrayList();
	query_string	=	request.getQueryString();
	String	status_sel1="",status_sel2="",status_sel3="";
	try
	{	
		
		con1				=	ConnectionManager.getConnection(request);
		if(!pre_ql_ref.equals(""))
		{
		try
		{
			String defSql=
			"SELECT a.column_id,(SELECT column_desc FROM sm_quick_link_criteria WHERE column_id = a.column_id AND option_id = b.option_id) column_desc,a.value_type, a.actual_value, a.datetime_relative_ind,a.datetime_relative_val, a.datetime_relative_unit,a.relative_field_ref FROM sm_quick_link_defn a, sm_quick_link_list b  WHERE a.quick_link_ref = ? and b.quick_link_ref = a.quick_link_ref";
			pstmt1		=	con1.prepareStatement(defSql);
			pstmt1.setString(1,pre_ql_ref);
			rs1=pstmt1.executeQuery();
			
			funcFilter = new HashMap();
			while(rs1.next())
			{	
				funcCriteria = new ArrayList();
				funcCriteria.add(rs1.getString("column_desc")==null?"":rs1.getString("column_desc"));
				funcCriteria.add(rs1.getString("value_type")==null?"":rs1.getString("value_type"));
				funcCriteria.add(rs1.getString("actual_value")==null?"":rs1.getString("actual_value"));
				funcCriteria.add(rs1.getString("datetime_relative_ind")==null?"":rs1.getString("datetime_relative_ind"));
				funcCriteria.add(rs1.getString("datetime_relative_val")==null?"":rs1.getString("datetime_relative_val"));
				funcCriteria.add(rs1.getString("datetime_relative_unit")==null?"":rs1.getString("datetime_relative_unit"));
				funcCriteria.add(rs1.getString("relative_field_ref")==null?"":rs1.getString("relative_field_ref"));
				funcFilter.put(rs1.getString("column_id"), funcCriteria);
				
			}
		}
	catch(Exception e)
	{
	
	e.printStackTrace();
	}
	finally
	{
		rs1.close();
		pstmt1.close();
	}
		}
	
	
	if(!pre_ql_ref.equals(""))
	{
		per_from=(ArrayList)funcFilter.get("PERIOD_FROM");
		per_to=(ArrayList)funcFilter.get("PERIOD_TO");
		sys_date_time=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);


		//For defaulting from and to period Added By DINESH T
		if(per_from.get(1).toString().equals("R") && per_from.get(3).toString().equals("B") && per_from.get(6)	.toString().equals("SYSDATETIME")&& per_from.get(4).toString()!="")	
		{
		from_date_time=com.ehis.util.DateUtils.minusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_from.get(4).toString()),per_from.get(5).toString());
		}
		else if(per_from.get(1).toString().equals("R") && per_from.get(3).toString().equals("A")&& per_from.get(6)	.toString().equals("SYSDATETIME")&& per_from.get(4).toString()!="")	
		{
		from_date_time=com.ehis.util.DateUtils.plusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_from.get(4).toString()),per_from.get(5).toString());
		}
		else if(per_from.get(6)	.toString().equals("SYSDATETIME"))
			
		{
		from_date_time=sys_date_time;
		}
		else
		{
			from_date_time="";//sys_date_time;
		}

		if(per_to.get(1).toString().equals("R") && per_to.get(3).toString().equals("B") && per_to.get(6).toString().equals("SYSDATETIME")&& per_to.get(4).toString()!="")	
		{
		to_date_time=com.ehis.util.DateUtils.minusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_to.get(4).toString()),per_to.get(5).toString());	
		}
		else if(per_to.get(1).toString().equals("R") && per_to.get(3).toString().equals("A")&&	per_to.get(6).toString().equals("SYSDATETIME")&& per_to.get(4).toString()!="")	
		{
		to_date_time=com.ehis.util.DateUtils.plusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_to.get(4).toString()),per_to.get(5).toString());
		}
		else if(per_to.get(6).toString().equals("SYSDATETIME"))
			to_date_time=sys_date_time;
		else
		{			
		to_date_time="";//sys_date_time;
		}

		//For defaulting status Field  Added By DINESH T
		status=(ArrayList)funcFilter.get("STATUS");
		statusValue=(status.get(2).toString()==""?"0":status.get(2).toString());
		if(statusValue.equals("A"))
			statusValue="4";
		else if(statusValue.equals("M"))
			statusValue="5";
		if(status.get(2).toString().equals("A"))
		{status_sel1="selected";status_sel2="";status_sel3="";}
		else if(status.get(2).toString().equals("M"))
		{status_sel2="selected";status_sel1="";status_sel3="";}
		else
		{status_sel3="selected";status_sel1="";status_sel2="";}

		
	}
	
	

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(status_sel3));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status_sel1));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status_sel2));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
			
		//For defaulting NoteGroup Field  Added By DINESH T
		note_grp=new ArrayList();
		if(!pre_ql_ref.equals(""))
		{
			note_grp=(ArrayList)funcFilter.get("NOTE_GROUP");
			if(note_grp.get(1).toString().equals("A"))
			note_grp_value=note_grp.get(2).toString();
			if(note_grp.get(1).toString().equals("R") && note_grp.get(6).toString().equals("CURR_NOTE_GROUP"))
			note_grp_value=parent_note_group;			
		}
		try
		{
			noteGroupSql="Select note_group, note_group_desc from 	ca_note_group_lang_Vw where 	appl_task_id=?  and language_id = ?	order by 2";
			pstmt2		=	con1.prepareStatement(noteGroupSql);
			pstmt2.setString(1,appl_task_id);
			pstmt2.setString(2,locale);
			rs2			=	pstmt2.executeQuery();
			while(rs2.next())
			{
				note_group		=	rs2.getString("note_group");
				note_group_desc	=	rs2.getString("note_group_desc");
				
				String selectVal="";
				if(note_grp_value.equals(note_group))
				{
					selectVal="selected";
					noteGrp_value=note_grp_value;
				}
				else
					selectVal="";
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selectVal));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

			}
			if(rs2!=null) rs2.close();
			if(pstmt2!=null) pstmt2.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			//if(con1!=null) ConnectionManager.returnConnection(con1,request);
		}
		
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

		try
		{
			//For defaulting NoteType Field  Added By DINESH T
			note_typ=new ArrayList();
			if(!pre_ql_ref.equals(""))
			{
				note_typ=(ArrayList)funcFilter.get("NOTE_TYPE");				
				if(note_typ.get(1).toString().equals("A"))
				note_type_value=note_typ.get(2).toString();
				if(note_typ.get(1).toString().equals("R") && note_typ.get(6).toString().equals("CURR_NOTE_TYPE"))
				note_type_value=parent_note_type;

			}
			query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resp a, sm_resp b,ca_note_type_lang_vw c  where b.resp_id = ?  and b.resp_id = a.resp_id and a.note_type = c.note_type and c.language_id = ?  and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN)='Y'  AND NOTE_GROUP_ID IN ( SELECT NOTE_GROUP FROM CA_NOTE_GROUP  WHERE APPL_TASK_ID=? ");
			if(!noteGrp_value.equals(""))
				query_header_details.append("and note_group=nvl(?,note_group) ");

			query_header_details.append(" ) order by note_type_desc");
			pstmt3		=	con1.prepareStatement(query_header_details.toString());
			pstmt3.setString(1,resp_id);
			pstmt3.setString(2, locale);
			pstmt3.setString(3,patient_class);
			pstmt3.setString(4,appl_task_id);
			if(!noteGrp_value.equals(""))
				pstmt3.setString(5,note_grp_value);

		/*	if(!categoryId.equals(""))
			{
				pstmt3.setString(4,categoryId);
			}*/
			rs3			=	pstmt3.executeQuery();
			while(rs3.next())
			{
				note_type		=	rs3.getString("note_type");
				note_type_desc	=	rs3.getString("note_type_desc");				
				String selectVal="";
				if(note_type_value.equals(note_type))
				{
					selectVal="selected";
					noteType_value=note_type;
				}
				else
					selectVal="";
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selectVal));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

				
			}
			if(rs3!=null) rs3.close();
			if(pstmt3!=null) pstmt3.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			//if(con1!=null) ConnectionManager.returnConnection(con1,request);
		}
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{	
		funcFilter.clear();
		per_from.clear();
		per_to.clear();
		funcCriteria.clear();
		status.clear();
		note_typ.clear();
		note_grp.clear();
		if(con1!=null) ConnectionManager.returnConnection(con1,request);
	}
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!imgUrl.equals(""))
	{ 
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	
	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(noteGrp_value));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(noteType_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(statusValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodfrom.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.periodto.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorized.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Modified.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteGroup.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
