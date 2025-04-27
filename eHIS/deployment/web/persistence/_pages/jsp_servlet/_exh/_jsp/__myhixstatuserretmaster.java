package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eXH.XHUtil;
import java.util.*;
import com.ehis.util.*;

public final class __myhixstatuserretmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MyhixStatUserRetMaster.jsp", 1742548187416L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t    \n\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../OP/js/messages.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/ViewEvents.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n\n<script language=\"javascript\">\n\n\nfunction Report()\n{\n\t\n\t\tvar event = \"\";\n\t\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\n\t\tfor(var i = 0; i < checkBoxes.length; i++)\n\t\t{\n\t\t\tif(checkBoxes[i].checked)\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"p_detail_rep\").value = \"Y\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"p_detail_rep\").value = \"N\";\n\t\t\t}\n\t\t}\n\tvar event =  document.getElementById(\"p_summ_type\").value;\n\t\t\n\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = \'../../eCommon/jsp/report_options.jsp\';\n\t    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target=\"messageFrame\";\n\t    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();\n\t\t\n}\nfunction clearSearch()\n{\n   \n   parent.f_query_add_mod.location.reload();\n   parent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\t\n}\n\n\nfunction clearSearchResult()\n{\n   parent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n}\n\nfunction getPatID()\n{\t\t\t\t\t  \n\tvar pat_id=PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'VIEW\');\n\tif( pat_id != null )\t\t\t\t\t\t\n\t\tdocument.forms[0].patient_id.value = pat_id ;\t\t\t\t\t\n}\n\nasync function getUserID(){\n\t\t\tvar tdesc=\"\";\n            var tcode=\"\";\n\n\t\t\tclearSearchResult();\n\t\t\t\n\t\t\tvar retVal =new String();\n            var argumentArray  = new Array() ;\n            var dataNameArray  = new Array() ;\n            var dataValueArray = new Array() ;\n            var dataTypeArray  = new Array() ;\n            var tit= \"User Group\";\t\t\t\n            var target=this.document.getElementById(\"P_APPL_ID\");\n            var User_desc=this.document.getElementById(\"User_desc\");\n\n\t\t\t//sql=\"SELECT CUST_GROUP_CODE code, SHORT_DESC description FROM AR_CUST_GROUP WHERE UPPER(CUST_GROUP_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 \";\n\t\t\tsql=\"SELECT APPL_USER_ID code, APPL_USER_NAME description FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) ORDER BY 1\";\n\n\t\t\targumentArray[0] = sql;\n            argumentArray[1] = dataNameArray ;\n            argumentArray[2] = dataValueArray ;\n            argumentArray[3] = dataTypeArray ;\n//            argumentArray[4] = \"2,1\";\n\t\t    argumentArray[4] = \"1,2\";\n            argumentArray[5] = target.value;\n            argumentArray[6] = DESC_LINK  ;\n            argumentArray[7] = DESC_CODE ;\n            retVal = await CommonLookup( tit, argumentArray );\n\n            if(retVal != null && retVal != \"\" ){\n\t            var ret1=unescape(retVal);\n                arr=ret1.split(\",\");\n                User_desc.value=arr[1];\n                target.value=arr[0];\n            }\n            else{\n                target.value=tdesc;\n                User_desc.value=tcode;\n            }\n\n\t\t\t\t\t\t\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<form name=\"PAYER_CHECK_QUERY_FORM\" id=\"PAYER_CHECK_QUERY_FORM\" method=\"get\" action=\"\">\n<fieldset style=\" border-color:grey;\">\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td class=label width=\"15%\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\n\t\t<td class=\'fields\'>\n\t\t\t<input type=text name=p_fm_date id=\"p_fm_date\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" size=11  > <input type=\'image\' id=\"p_fm_date_img\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'p_fm_date\',\'dd/mm/y\');\"  >\n\t\t</td>\t\n        \n        <td class=label width=\"15%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\n\t\t<td class=\'fields\'>\n\t\t\t<input type=text name=p_to_date id=\"p_to_date\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" size=11  > <input type=\'image\' id=\"p_to_date_img\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'p_to_date\',\'dd/mm/y\');\">\n\t\t</td>\t\t\n</tr>\n<tr>\n\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\n\t<td class=\'fields\'>\n\t\t<INPUT TYPE=\"text\" id=\"patient_id\" name=\"p_patient_id\" id=\"p_patient_id\" align=\"left\" size=\'20\' maxlength=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  value=\"\" onBlur=\"ChangeUpperCase(this);\" >\n\t\t<input type=\"button\" value=\"?\" class=\"button\" name=\'pat_search\' id=\'pat_search\' onClick=\"getPatID()\">\n\t</td>\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\'fields\'>\n\t\t\t<input type=\"hidden\" id=\"User_desc\" >\n\t\t\t<INPUT TYPE=\"text\" id=\"P_APPL_ID\" name=\"P_APPL_ID\" id=\"P_APPL_ID\" onBlur=\'getUserID()\'  value=\"\">\n\t\t\t<input class=\"BUTTON\" type=\"button\"  name=customerGroupIDSearch id=customerGroupIDSearch value=\'?\' onClick=\"getUserID()\">\n\t\t</td>\n\n </tr>\n<tr>\n\t<td class=label width=\"10%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\n\t<td class=\'fields\'>\n\t\t\t\t<select id=\"p_summ_type\" name=\"p_summ_type\" id=\"p_summ_type\" style=\"width: 150px\" >\n\t\t\t\t\t<option value = \'\'>----";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="----</option>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\n\t\t\t\t\t<option value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\n\t\t\t\t</select>\n\t\t\t</td>      \n\t \n    <td class=label width=\"10%\" >Show Details</td>\n    <td><input type=\'checkbox\' id=\'checkbox\' value = \'N\'> </td>\n</tr>\n\n</table>\n\n<table width=\'100%\' cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr align=\"right\">\n\t\t<td colspan=4 class=\'BUTTON\'>\n\t\t<!--<input class=\'BUTTON\' type=\"button\"  ID=\"query\" name=\"query\" id=\"query\" value=\'Search\' onClick=\"Query()\">-->\n\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"report\" name=\"report\" id=\"report\" value=\'Report\' onClick=\"Report()\">\n\t\t<input class=\'BUTTON\' type=\"button\"  ID=\"clear\" name=clear value=\'Clear\' onClick=\"clearSearch()\">\n\t\t</td>\n\t</tr>\n</table>\n\n\n\n\n    <input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"\t\tid=\"p_report_id\"\tvalue=\"XHUSRTSUM\">\n\t<input type=\"hidden\" name=\"p_detail_rep\" id=\"p_detail_rep\"\tid=\"p_detail_rep\"   value=\"N\">\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tid=\"p_language_id\"\tvalue=\"en\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\n\n</fieldset>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String p_fm_date = "";
		String p_to_date = "";
		String status_code = "",status_desc = "";
		String str = "";
		String p_module_id      = "XH" ;
		String p_facility_id    = (String) session.getValue( "facility_id" ) ;
		String p_user_name      = (String) session.getValue( "login_user" ) ;
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		java.util.Date da = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(da);
		cal.add(Calendar.MONTH, -1);
		da = cal.getTime();
		p_fm_date =dateFormat.format(da) ;
		p_to_date = dateFormat.format(new java.util.Date()) ;

		String pid_length="10";
		String uid_length="20";

		Connection conn = null;
		try
		{ 
			pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));	
			uid_length =  (XHUtil.singleParamExeQry("SELECT USER_ID_LENGTH FROM MP_PARAM"));
		
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_fm_date ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_to_date ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pid_length));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);


	Connection con=null;
	Statement stmt=null;
	ResultSet rset=null;
	ArrayList ds_summary = new ArrayList();
	ArrayList ds_summary_test = new ArrayList();// Kapil
	con=ConnectionManager.getConnection(request);
	String sql1="Select  EVENT_NAME,EVENT_TYPE from xh_event_type where EVENT_TYPE in(select event_type from XH_APPLICATION_EVENT_TYPE where application_id = 'MYHIX2' and event_type in ('X01','X02','X04','X05'))";
	stmt=con.createStatement();
	rset=stmt.executeQuery(sql1);

	 while(rset.next()){
		  ds_summary.add(rset.getString("EVENT_NAME"));
		  ds_summary_test.add(rset.getString("EVENT_TYPE"));
		  
	 }
	 if(rset!=null) rset.close();
	 if(stmt!=null) stmt.close();
	 if(con!=null) con.close();
	  
	  
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
for(int i=0;i<ds_summary.size();i++){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ds_summary_test.get(i)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ds_summary.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block24Bytes, _wl_block24);

}catch(Exception e1)
			{
			 out.println("(MyHixStatFailedSendMaster.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}

            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.SummaryType.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
