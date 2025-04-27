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
import webbeans.eCommon.*;

public final class __searchicdcodequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/SearchicdcodeQueryResult.jsp", 1742302048781L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t\t<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t<script>\n\n\t\t\tasync function showLongDescription(term_code,term_set_id){\n\t\t\t\tvar dialogHeight= \"320px\" ;\n\t\t\t\tvar dialogWidth = \"350px\" ;\n\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\t\t\tawait window.showModalDialog(\"../../eMR/jsp/PatProblemDialogLongDesc.jsp?term_code=\"+term_code+\"&term_set_id=\"+term_set_id,\"\",features);\n\t\t\t}\n\t\t\tfunction closewindow(Dcode){\n\t\t\t\t/* window.parent.parent.returnValue=Dcode;\n\t\t\t\tparent.parent.parent.document.getElementById(\"dialog_tag\").close(); */\n\t\t\t\t// window.parent.parent.close();\n\t\t\t\twindow.returnValue=Dcode;\n\t\t\t\twindow.close();\n\t\t\t\t/* parent.parent.parent.document.querySelectorAll(\'#dialog-body\')[parent.parent.parent.document.querySelectorAll(\'#dialog-body\').length-1].contentWindow.returnValue=Dcode;\n\t\t\t\tparent.parent.parent.document.querySelectorAll(\'#dialog_tag\')[parent.parent.parent.document.querySelectorAll(\'#dialog_tag\').length-1].close(); */\n\t\t\t}\n\t\t\tfunction scrollTitle(){\n\t\t\t\tvar y = parent.codedesc.document.body.scrollTop;\n\t\t\t\tif(y == 0){\n\t\t\t\t\tparent.codedesc.document.getElementById(\"divDataTitle\").style.position = \'static\';\n\t\t\t\t}else{\n\t\t\t\t\tparent.codedesc.document.getElementById(\"divDataTitle\").style.position = \'relative\';\n\t\t\t\t\tparent.codedesc.document.getElementById(\"divDataTitle\").style.posTop  = y-2;\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tfunction alignWidth(){\n\t\t\t\t\tvar totalRows =  parent.codedesc.document.getElementById(\"dataTable\").rows.length;\n\t\t\t\t\tvar counter = totalRows-1;\n\t\t\t\t\tvar temp = parent.codedesc.document.getElementById(\"dataTitleTable\").rows[0].cells.length;\n\t\t\t\t\tfor(var i=0;i<temp;i++) {\n\t\t\t\t\t\tparent.codedesc.document.getElementById(\"dataTitleTable\").rows[0].cells[i].width=parent.codedesc.document.getElementById(\"dataTable\").rows[counter].cells[i].offsetWidth;\t\n\t\t\t\t\t}\n\t\t}\n\t\t\t\n\t\t\tfunction longDescToolTip(term_code, long_desc) {\n\t\t\t    var tab_data = \"<td class=\'label\'>\" + term_code + \"</td>\";\n\t\t\t    var tab_data2 = \"<td class=\'label\'>\" + long_desc + \"</td>\";\n\t\t\t    var final_table = \"<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'>\" + \n\t\t\t                      \"<tr>\" + \n\t\t\t                      tab_data + \n\t\t\t                      tab_data2 + \n\t\t\t                      \"</tr></table>\";\n\t\t\t    \n\t\t\t    return final_table;\n\t\t\t}\n\t\t\t/*\n\t\t\tfunction alignWidth(){\n\n\t\t\tvar totalRows =  parent.codedesc.document.getElementById(\"dataTable\").rows.length;\n\n\t\t\tvar counter = totalRows-1;\n\t\t\tvar temp = parent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTitleTable\").rows(0).cells.length;\n\t\t\tfor(var i=0;i<temp;i++) {\n\t\t\tparent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTitleTable\").rows(0).cells(i).width=parent.TermCodeSearchKWResultFrame.document.getElementById(\"dataTable\").rows(counter).cells(i).offsetWidth;\n\n\t\t\t}\n\t\t\t}\n\t\t\t*/\n\t\t\t</script>\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<body  onScroll=\'scrollTitle()\' onKeyDown=\'lockKey()\'>\n\t\t\t<form name=\'query_form\' id=\'query_form\'>\n\t\t\t\t<!-- <div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t\t\t\t<table border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t</div> -->\n\t\t\t\t<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<th align=\'center\' width=\'\' nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t\t\t<th align=\'center\' width=\'\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<th align=\'center\' width=\'\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<th align=\'center\' width=\'\'  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<tr style=\'visibility:hidden\'>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</form>\n\t\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eOT/js/wz_tooltip.js\'></script>\n\t\t</body>\n\t</html>\n\t\t<script>\n\t\talignWidth();\n\t\tparent.frames[0].document.forms[0].Search.disabled=false;\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
request.setCharacterEncoding("UTF-8");
StringBuffer sql			= new StringBuffer();
String term_code		= "";
String long_desc		= "";
String short_desc		= "";
String notifiable			= "";
String sensitive			= "";
//String code_indicator = "";
String sensitive_disp	 = "";
String notifiable_disp = "";
String age_spec_ind_val	= "";
String age_spec_ind			= "";
String gender_spec_ind		= "";
String term_set_id				= "";
String select_yn				= "";

Connection conn				= null; 
PreparedStatement stmt   =  null;
ResultSet rs						= null;
PreparedStatement stmt_1  = null;
ResultSet rs_1					= null;
conn		= ConnectionManager.getConnection(request);
boolean toolTip_diagnosis	=  eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS"); 


try{
		String clearPage = request.getParameter("clearResultPage")==null?"":request.getParameter("clearResultPage");
		if(clearPage.equals("y")){
		  /*Below line Added for this incident [IN:040385]*/
		  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		  out.println("<script>parent.frames[0].document.forms[0].Search.disabled = false</script>");			  
          //End this incident [IN:040385]		  
		}
		else{
		String from_code		=	checkForNull(request.getParameter("from_code"));
		String to_code			=	checkForNull(request.getParameter("to_code"));
		String searchby			=	checkForNull(request.getParameter("Search_By"));
		String searchcriteria	=	checkForNull(request.getParameter("Search_Criteria"));
		String searchtext		=	checkForNull(request.getParameter("Search_Text"));
		String sensitive_yn	=	checkForNull(request.getParameter("sensitive_yn"));
		String notifiable_yn	=	checkForNull(request.getParameter("notifiable_yn"));
		String sensitivity_appl_yn =	checkForNull(request.getParameter("sensitivity_appl_yn"));
		String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
		if(sensitivity_appl_yn.equals("N"))
			sensitive_disp = "display:none";
		String notification_appl_yn	=	 checkForNull(request.getParameter("notification_appl_yn"));
		if(notification_appl_yn.equals("N"))
		notifiable_disp	 = "display:none";
		String age_group_appl_yn		=	checkForNull(request.getParameter("age_group_appl_yn"));
		//String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
		String sex	 =	checkForNull(request.getParameter("Sex"));	
		String dob  =	checkForNull(request.getParameter("Dob"));
		//modified on 15-07-08 for SCR 4827
		String title  = checkForNull(request.getParameter("title"));
		if(title.equals("ICD10 Code List")){
			term_set_id =checkForNull(request.getParameter("p_diag_scheme_desc"));
		}else{
			term_set_id =checkForNull(request.getParameter("term_set_id"));
		}
		String code_indicator =checkForNull(request.getParameter("code_indicator"));
		String dagger_independent_yn ="";//Added On 1/23/2010 For SRR-CRF-303.2
		term_set_id	 = term_set_id.trim();
		searchtext		 = searchtext.toUpperCase();
		int i =0;
		if(age_group_appl_yn.equals("Y")){
			//String sql_age_spec_ind = " select case when sysdate-to_date('"+dob+"','dd/mm/yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date('"+dob+"','dd/mm/yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date('"+dob+"','dd/mm/yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
			String sql_age_spec_ind = "SELECT age_group_code from AM_AGE_GROUP where 1 = check_age_between (to_date(?,'dd-mm-yyyy'),min_age,age_unit,max_age + 1,age_unit_max)and GENDER = ?";
			stmt_1 = conn.prepareStatement(sql_age_spec_ind);
			/*stmt_1.setString(1,dob);
			stmt_1.setString(2,dob);
			stmt_1.setString(3,dob);
			*/
			stmt_1.setString(1,dob);
			stmt_1.setString(2,sex);
			rs_1 = stmt_1.executeQuery();
			while(rs_1.next())
			age_spec_ind_val = rs_1.getString(1);	
			if(age_spec_ind_val==null)
			age_spec_ind_val="";
		}		

		if(rs_1!= null) rs_1.close();
		if(stmt_1!= null) stmt_1.close();

		if(searchby.equals("D")) {
		//Maheshwaran added for the HSA-CRF-0234
		if(diagnosis_by_long_desc_yn.equals("Y"))
		sql.append(" upper(long_desc)  like upper(?)");//Maheshwaran
		else
		sql.append(" upper(short_desc)  like upper(?)");//Maheshwaran
		}
		else 
		sql.append(" upper(term_code)  like upper(?)");

		/*
		if(searchcriteria.equals("S"))  
		sql.append("'"+searchtext+"%'");
		else if(searchcriteria.equals("E"))
		sql.append("'%"+searchtext+"'");
		else if(searchcriteria.equals("C"))
		sql.append("'%"+searchtext+"%'");
		*/
		/*	if(sex.equals("F"))
		sql.append(" and GENDER_SPEC_IND = 'F' ");
		else if(sex.equals("M"))
		sql.append(" and GENDER_SPEC_IND = 'M' ");*/

		if(sensitive_yn.equals("Y")) 
		sql.append(" and  SENSITIVE_YN = 'Y' ");
		else if (sensitive_yn.equals("N")) 
		sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");

		if(notifiable_yn.equals("Y"))  
		sql.append(" and NOTIFIABLE_YN = 'Y'");
		else if (notifiable_yn.equals("N"))  
		sql.append(" and nvl(NOTIFIABLE_YN,'N') ='N'");

		if(!code_indicator.equals("")){
			sql.append(" and  code_indicator = ?");
		}else{
			sql.append(" and ( code_indicator in ('C','D','E','A') or code_indicator is null )");	
		}
		sql.append(" and EFF_STATUS='E'");	
		sql.append(" and LANGUAGE_ID='"+locale+"'");// Language Id is added for IN023648 	

		//sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");		


		sql.append(" and TERM_CODE between '"+from_code+"' and '"+to_code+"'");
		//8/20/2009 Free text Recording
		sql.append(" AND FREE_TEXT_YN = 'N'");
		//11/13/2008 MODIFIED FOR EFFSTAUTS
		sql.append(" ORDER BY TERM_CODE ");    
			/*
				The following query was modified for IN023648.
				Modified On:10/5/2010
			*/
		StringBuffer searchKW_sql = new StringBuffer("select TERM_CODE,LONG_DESC,SHORT_DESC,decode(CODE_INDICATOR,'A','Asterisk(*)','D','Dagger(+)','C','Consequence(C)','E','External Cause Indicator(E)')CODE_INDICATOR,decode(SENSITIVE_YN,'Y','Yes','N','No')SENSITIVE_YN,decode(NOTIFIABLE_YN,'Y','Yes','N','No')NOTIFIABLE_YN,AGE_SPEC_IND,GENDER_SPEC_IND,select_yn,DAGGER_INDEPENDENT_YN from MR_D_"+term_set_id+"_LANG_VW  where");// 
		

		stmt = conn.prepareStatement(searchKW_sql.toString()+sql.toString());
		if(searchcriteria.equals("S")) {  
			stmt.setString(1,searchtext+"%");		
		} else if(searchcriteria.equals("E")) {
			stmt.setString(1,"%"+searchtext);		
		} else if(searchcriteria.equals("C")) {
			stmt.setString(1,"%"+searchtext+"%");		
		} 
		if(!code_indicator.equals(""))
		stmt.setString(2,code_indicator);	
		rs = stmt.executeQuery();

		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
if(!toolTip_diagnosis){ 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
} 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
if(notification_appl_yn.equals("Y") || notification_appl_yn.equals("")){
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
if(sensitivity_appl_yn.equals("Y") || sensitivity_appl_yn.equals("")){
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

					String rowclass = "" ;
					String disp_dagger_dep_ind = "" ;
					while(rs.next()){
						if (i%2==0) 
						rowclass = "QRYEVEN" ;
						else	 
						rowclass = "QRYODD" ;
						term_code			= checkForNull(rs.getString("TERM_CODE"));
						long_desc				= checkForNull(rs.getString("LONG_DESC"));
						short_desc			= checkForNull(rs.getString("SHORT_DESC"));
						code_indicator		= checkForNull(rs.getString("CODE_INDICATOR"));
						notifiable				= checkForNull(rs.getString("NOTIFIABLE_YN"));
						sensitive				= checkForNull(rs.getString("SENSITIVE_YN"));
						age_spec_ind		= checkForNull(rs.getString("AGE_SPEC_IND"));
						gender_spec_ind  = checkForNull(rs.getString("GENDER_SPEC_IND"));
						select_yn				= checkForNull(rs.getString("select_yn"));
						dagger_independent_yn	= checkForNull(rs.getString("DAGGER_INDEPENDENT_YN"));//Added On 1/23/2010 For SRR-CRF-303.2.
//						out.println("=======1============>" +dagger_independent_yn);
						if(dagger_independent_yn.equals("Y")){
							disp_dagger_dep_ind	="display:inline";
						}else{
							disp_dagger_dep_ind	="display:none";
						}
						out.println("<tr style='background-color:;'>");	
						if(age_group_appl_yn.equals("Y") ){
							//if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("") || age_spec_ind.equals("O")||age_spec_ind.equals("M")||age_spec_ind.equals("C")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
							/*Monday, June 08, 2009 modified for IN011172*/
							if ((gender_spec_ind.equals(sex) || gender_spec_ind.equals("") || sex.equals(""))){
							if(select_yn.equals("Y")){
								out.println("<td class='"+rowclass+"' width='' nowrap><a href=javascript:closewindow('"+term_code+"')>" + term_code +"</a></td>");
							}else{
								out.println("<td class='"+rowclass+"' width='' nowrap>" + term_code + "</td>");
							}
							}else{
								out.println("<td title='This Diagnosis Code is not applicable for this patient...' class='"+rowclass+"' width='' nowrap>" + term_code + "</td>");
							}
						}else{
							if(select_yn.equals("Y"))
								out.println("<td class='"+rowclass+"' width='' nowrap><a href=javascript:closewindow('"+term_code+"')>" + term_code +"</a></td>");
							else
								out.println("<td class='"+rowclass+"' width='' nowrap>" + term_code + "</td>");
						}
							/* out.println("<td class='"+rowclass+"' width='' nowrap>");
							out.println(short_desc+"</td>"); */
							if(toolTip_diagnosis){
							out.println("<td class='" + rowclass + "' width='' nowrap " +
						            "onMouseOver=\"Tip(longDescToolTip('" + term_code + "','" + long_desc + "'))\" " +
						            "onMouseOut=\"UnTip()\">");
						out.println(short_desc + "</td>");
							}else{
								 out.println("<td class='"+rowclass+"' width='' nowrap>");
								out.println(short_desc+"</td>"); 
								
							}
						if(!toolTip_diagnosis){
						if(!short_desc.equals(long_desc)){
							//out.println("<td class='"+rowclass+"' align='center' width='' nowrap><a href=javascript:showLongDescription(\""+java.net.URLEncoder.encode(long_desc)+"\") ><b>!</b></a></td>");
							out.println("<td class='"+rowclass+"' align='center' width='' nowrap><a href=javascript:showLongDescription(\""+java.net.URLEncoder.encode(term_code)+"\",\""+java.net.URLEncoder.encode(term_set_id)+"\") ><b>!</b></a></td>");
						}else{
							out.println("<td class='"+rowclass+"' width='' nowrap>&nbsp;</td>");
						}  
						out.println("<td class='"+rowclass+"' width='' nowrap>"+code_indicator+" &nbsp;<img src='../../eCommon/images/mandatory.gif' style='"+disp_dagger_dep_ind+"'>&nbsp;</td>");
						out.println("<td class="+rowclass+" style='"+notifiable_disp+"' width='' nowrap>"+notifiable+"&nbsp;</td>");
						out.println("<td class="+rowclass+" style='"+sensitive_disp+"' width='' nowrap>"+sensitive+"&nbsp;</td>");
						out.println("</tr>");
						i++;
					}
					if(i==0){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
					}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();	
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
if(notification_appl_yn.equals("Y") || notification_appl_yn.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
if(sensitivity_appl_yn.equals("Y") || sensitivity_appl_yn.equals("")){
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
}

}
catch(Exception e)
{
//out.println("Exception is  "+e.toString());
e.printStackTrace();
}
finally	
{
if(conn!=null)
ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CodeIndicator.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Notifiable.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CodeIndicator.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Notifiable.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
