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

public final class __procedurelistquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProcedureListQuery.jsp", 1732962580225L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script Language=\"JavaScript\" src=\"../../eCA/js/DateValidation.js\"></script>\n<script Language=\"JavaScript\" src=\'../js/ProcedureList.js\'></script>\n<script Language=\"JavaScript\" src=\'../../eCommon/js/dchk.js\'> </script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../js/GlobalArray.js\'></script>\t\t\n<script language=javascript>\n /*function checkProcedure(obj){\n\t if(obj.value==\"\") return false;\t \n\t\t\tvar s_scheme=top.content.workAreaFrame.procedurelistquery.document.forms[0].s_scheme.value;\n\t\t\tvar s_scheme_desc=top.content.workAreaFrame.procedurelistquery.document.forms[0].s_scheme_desc.value;\n\t\t\tvar search_text=obj.value;\n\t\t\tvar retVal = \t\"\"; //new String();\n\t\t\tvar dialogHeight\t= \"28\" ;\n\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll:no; status:\" + status;\n\t\t\tretVal = window.showModalDialog(\"../../eCA/jsp/ProcSearchMain.jsp?s_scheme=\"+s_scheme+\"&s_scheme_desc=\"+s_scheme_desc+\"&search_text=\"+search_text,arguments,features);\n\n\t\t\tif (!(retVal == null)){\n\t\t\t\tvar vals=retVal.split(\"/\");\n\t\t\t\ttop.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.value=vals[0];\n\t\t\t}else{\n\t\t\t\t\t\ttop.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.value=\"\";\n\t\t\t\t\t\ttop.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.focus();\n\t\t\t}\n}*/\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'Procedure_List\' id=\'Procedure_List\'>\n<BR>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<!--.........................................................--> \n\t<tr>\n                    <td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n                    <td  class=\'fields\' width=\"25%\">\n\t\t\t<select name=\"code_set\" id=\"code_set\"  onChange=\"showTable(this);\" ><option value=\'\'>---------- ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="----------</option>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n        </select><!-- <img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'> -->\n\t\t<input type=\"hidden\" name=\"proc_set\" id=\"proc_set\" value=\"\">\n\t\t<input type=\"hidden\" name=\"proc_set_desc\" id=\"proc_set_desc\" value=\"\">\n\t</td>\n       \n\t\n\t\t<td  width=\"25%\" class=\'label\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t\t\t<input type=\'text\' size=10 maxlength=\'10\' name=\'proc_desc\' id=\'proc_desc\' value=\'\' onBlur=\'getTermCode(this)\' readOnly ><input type=\'hidden\' value=\'\' name=\'proc_code\' id=\'proc_code\'></input><input type=\"button\" class=\'Button\' name=\"searchcode_button1\" id=\"searchcode_button1\" title=\'search_code\' value=\"?\" onClick=\'callTermCode()\' disabled>\n\t\t</td> \n\t\n\t\t</tr><tr>\n\n\t\t\t\t\n\t\t<td  width=\"25%\" class=\'label\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\'text\' size=10 maxlength=\'10\' name=\'from_date\' id=\'from_date\' value=\'\' onblur=\'CheckDate(this);CheckSystemDateLesser(this,to_date, \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"DMY\",\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");\'><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'from_date\');\" > - <input type=\'text\' size=10 maxlength=\'10\' name=\'to_date\' id=\'to_date\' value=\'\' onblur=\'CheckDate(this);CheckSystemDateLesser(from_date,this, \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\");\'><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'to_date\');\" ></td>\n\t\t\t\n\t\t<td class=\'label\' width=\"25%\"  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td class=\'fields\'  width=\"25%\" > \t\n\t\t\t<input type=\'hidden\' size=10 maxlength=\'20\' name=\'serv_code\' id=\'serv_code\' value=\'\'><input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><input type=\'text\' size=10 maxlength=\'20\' name=\'serv_code1\' id=\'serv_code1\' value=\'\' onBlur=\'checkService(this)\'><input type=\"button\" class=\'Button\' name=\"searchcode_button\" id=\"searchcode_button\" title=\'search_code\' value=\"?\" onClick=\'show_service_window()\'> \n\t\t</td>\n\t\t</tr><tr>\n \t\t<td colspan=4 align=\'right\'><input type=\"button\" class=\'Button\' name=\"searchresult_button\" id=\"searchresult_button\" title=\'search_result\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onClick=\'search_result()\'><input type=\"button\" class=\'Button\' name=\"clear_form\" id=\"clear_form\" title=\'clear\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\'clear_result()\'></td>\n\t\t\n\t</tr>\n\t<!-----------------------------....................-->\n</table>\n\n<!-- // added by Arvind @ 03-12-08  -->\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\n\t\t\t\t<!-- end here -->\n\n<input type=hidden value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' name=\'patient_id\'></input>\n<input type=hidden value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' name=\'s_scheme\'></input>\n<input type=hidden value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' name=\'s_scheme_desc\'></input>\n<input type=hidden value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' name=\'modal_yn\'></input>\n<input type=hidden value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' name=\'encounter_id\'></input>\n<input type=hidden value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' name=\'called_mod\'></input>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>\n\t\t\tsearch_result();\n\t\t</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// added by Arvind @ 03-12-08 
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con			=null;
PreparedStatement stmt			=null;
ResultSet rset			=null;
String patient_id		="";
String s_scheme			="";
String s_scheme_desc	="";
String today				="";
String operating_facility_id="";
String practitioner_id1 ="";
String practitioner_type ="";
String encounter_id="";
StringBuffer sql_proc=new StringBuffer(); 
String locale="";
String modal_yn="";
String called_mod="";

try
{
	con = ConnectionManager.getConnection(request);
	patient_id=request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")== null ? "N" : request.getParameter("encounter_id");	
	modal_yn=request.getParameter("modal_yn") == null ? "N" : request.getParameter("modal_yn");	
	called_mod=request.getParameter("called_mod") == null ? "N" : request.getParameter("called_mod");
	
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	if (patient_id==null) patient_id="";
	if (encounter_id==null) encounter_id="";
	operating_facility_id=(String) session.getValue("facility_id");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	locale = (String) p.getProperty("LOCALE");
	practitioner_type=(String)session.getValue("practitioner_type")==null?"":(String)session.getValue("practitioner_type");
	practitioner_id1=(String) session.getValue("ca_practitioner_id");

	String sql="Select proc_code_scheme scheme,decode(proc_code_scheme,'3','CPT4','4','ICD9-CM') scheme_desc from mr_parameter";
	stmt = con.prepareStatement(sql);
	rset = stmt.executeQuery();

	if(rset!=null)
		{
		while(rset.next())
			{
			s_scheme=rset.getString(1);
			s_scheme_desc =rset.getString(2);
			}
		}

		if (rset!=null) rset.close();
		if (stmt!=null) stmt.close();

		today	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
/*
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
		stmt=con.prepareStatement(sql);
		
		rset = stmt.executeQuery();
		if (rset.next())
		{
		today = rset.getString("today");
		}

		if(rset !=null) rset.close();
		if(stmt !=null) stmt.close();
*/	
	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			//stmt = con.createStatement();
			if(sql_proc.length() > 0) sql_proc.delete(0,sql_proc.length());
			sql_proc.append("select a.term_set_id,priority_appl_yn||'='||nature_appl_yn||'='||severity_appl_yn||'='||onset_type_appl_yn||'='||factors_appl_yn||'='||notification_appl_yn term_set_id1,term_set_desc "); 
			sql_proc.append("from mr_term_set a where exists (select 1 from mr_term_set_for_facility where FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from "); sql_proc.append("mr_term_set_for_pract_type where PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from mr_term_set_for_specialty where"); 
			sql_proc.append(" SPECIALTY_CODE in (select SPECIALTY_CODE from pr_encounter where "); sql_proc.append(" facility_id=? and encounter_id=?) AND TERM_SET_ID=A.TERM_SET_ID) and exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND "); 
			sql_proc.append(" TERM_SET_ID=A.TERM_SET_ID or not exists (select 1 from "); 
			sql_proc.append(" mr_term_set_for_pract  where PRACTITIONER_ID=ib.PRACTITIONER_ID) ) and "); sql_proc.append(" Eff_status='E' and proc_spec_yn='Y' order by term_set_desc");
			
			stmt = con.prepareStatement(sql_proc.toString());
			stmt.setString(1,operating_facility_id);
			stmt.setString(2,practitioner_type);

			stmt.setString(3,operating_facility_id);
			stmt.setString(4,encounter_id);

			stmt.setString(5,practitioner_id1);

					
			rset = stmt.executeQuery();


			while(rset.next())
			{
				String proc_desc = rset.getString("term_set_desc");
				String proc_set_id = rset.getString("term_set_id")+"~"+proc_desc;
				
				//String proc_code1 = rset.getString("term_set_id1");
				String temp_proc_set = rset.getString("term_set_id");
				//String proc_sel = "";
				
				if(term_set_id.equals(temp_proc_set))
				{
					out.print("<option value='"+proc_set_id+"' selected >"+proc_desc+"</option>");
				}
				else
				{
					out.print("<option value='"+proc_set_id+"' >"+proc_desc+"</option>");
				}
			}
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();	
			
			}
	catch(Exception ee)
	{
	//out.println("Exception@Connection"+ee);//COMMON-ICN-0181
	ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
		
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(today));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(today));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
  if(!imgUrl.equals("")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(s_scheme));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(s_scheme_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(called_mod));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
	if(called_mod.equals("BL")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ProcedureSet.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProcedureCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
}
