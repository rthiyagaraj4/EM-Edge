package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.Common.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __gcpgenerateplanpreviewtree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGeneratePlanPreviewTree.jsp", 1709116588778L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link><link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCP/html/GCPGeneratePlanMenu.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../js/GCPGeneratePlanMenu.js\"></script>\n<script language=\"JavaScript\" src=\"../js/GCPGenerateCarePlan.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  \t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\'hidden\' name=\'folopen\' id=\'folopen\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<FORM METHOD=POST ACTION=\"\" name=\"previewTreeMenu\" id=\"previewTreeMenu\">\n<script>\n\tvar obj;\n\tobj = new dTree(\'obj\');\n\tobj.add(0,-1,\'<font size=1 style=font-weight:bold style=color:#333><a href=\"#\" onClick=\"showHistoryResults()\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a></font>\');\n\tobj.config.useStatusText=true;\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t // \t\talert(\"i--";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="--rs.getString(27) -";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t  \t\t//alert(\"termcode--";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="-i----";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="---termcode_id---";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="--\");\n\t\tobj.add(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="1\",\"0\",\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\",\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"\",\"\",\"\",\"\");\n\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t\tobj.add(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="1\",\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\",\"\",\"\",\"\",\"\");\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\n\t\t\tobj.add(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",\"\");\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\t\n\t\t\t//obj.add(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\",\"\",\"\");\n\t\t\tobj.add(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\",\"\",\"\");\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\tobj.add(\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\",\"\",\"\",\"\"); \n\t\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</script>\n\t<input type=\"hidden\" name=\"txtNodePoistions\" id=\"txtNodePoistions\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n \t<input type=\"hidden\" name=\"txtCurrentPosition\" id=\"txtCurrentPosition\" value=\"\">\n\t<input type=\"hidden\" name=\"txtToolTips\" id=\"txtToolTips\" value=\"\">\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<script>\n\t\tdocument.write(obj);\n\t\tobj.openAll();\n   \t//\tparent.GeneratePlanPreviewRight.location.href=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n  \t</script>\n\n </form>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);



//Initialize Function specific start 

 String Library = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryDetails.label","cp_labels");//"Library Details";
String lib_short_desc = request.getParameter("lib_short_desc") == null ? "" : request.getParameter("lib_short_desc");
String library_code = request.getParameter("library_code") == null ? "" : request.getParameter("library_code");
String version_no = request.getParameter("version_no") == null ? "" : request.getParameter("version_no");
String termcode_id = request.getParameter("termcode_id") == null ? "" : request.getParameter("termcode_id");
String libdetailvalue = request.getParameter("libdetailvalue") == null ? "" : request.getParameter("libdetailvalue");
String value_str = request.getParameter("value_str") == null ? "" : request.getParameter("value_str");
String record[] =null ;
String record1[] =null ;
int  i= 0,tmp=0;
//out.println("<script>alert('libdetailvalue:::"+libdetailvalue+"---')</script>");

if(libdetailvalue !="" || libdetailvalue!= null)
{
	StringTokenizer stk		= new StringTokenizer(libdetailvalue,"~");
	int cnt=stk.countTokens();int j=0;
	record = new String[cnt] ;
	while(stk.hasMoreTokens()){
		record[j]  = stk.nextToken();
		j++;
	}
}
if(value_str !="" || value_str!= null)
{
	StringTokenizer stk1		= new StringTokenizer(value_str,",");
	int cnt=stk1.countTokens();int j=0;
	record1 = new String[cnt] ;
	while(stk1.hasMoreTokens()){
		record1[j]  = stk1.nextToken();
		j++;
	}
}
//out.println("<script>alert('record1[]:::"+record1.length+"')</script>");

String executable_name		= "../../eCP/jsp/GCPGeneratePlanPreviewDtl.jsp?"+request.getQueryString();
String workAreaFrame		= "GeneratePlanPreviewRight";
String query_executable_name= "";

Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;
String sql = ""  ;
String termset="",termset1="";
String termcode="",termcode1="",intervention="";
String icon = "";
String folopen="";
String folclose="";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(folopen));
            _bw.write(_wl_block10Bytes, _wl_block10);

try
{    
	
	con = ConnectionManager.getConnection(request);
	sql = "SELECT a.LIBRARY_ID,a.VERSION_NO ,a.TERM_SET_ID ,b.Term_Set_Desc Term_Set_Description ,a.TERM_CODE ,c.Short_desc Term_Code_Description ,c.Short_desc Term_Code_Description,a.OUTCOME_CODE ,F.Short_desc Outcome_Description,a.INTERVENTION_CODE ,a.INTERVENTION_TYPE ,a.SEQ_NO  ,a.REL_START_PERIOD,a.REL_START_PERIOD_UNIT,a.FREQ_CODE ,a.FREQ_DURN,a.FREQ_DURN_UNIT ,a.DEPENDENCY_LEVEL ,a.ALT_INTERVENTION_CODE ,a.STAGE_CODE ,a.ACCURACY_INDICATOR,Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))  Start_Date_Time,to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') End_Date_Time ,'<font color=black><b>' || D.Short_Desc ||'</b></font>' || '  Frequency : ' || E.Freq_Desc || ' For '  || a.Freq_Durn || ' ' || g.durn_desc || ' Start Date : ' || Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))   ||  ' End Date :' || to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + 			       (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI')     Build_Diagonis_Intervention,to_char(decode(OUTCOME_TARGET_DURN_UNIT,'D',sysdate+OUTCOME_TARGET_DURN,'H',sysdate+(OUTCOME_TARGET_DURN/24),				'M',sysdate+(OUTCOME_TARGET_DURN/1440),'W',sysdate+(OUTCOME_TARGET_DURN*7),				'L', sysdate+(OUTCOME_TARGET_DURN*30)),'dd/mm/yyyy hh24:mi') OutCome_Target_Date,Decode(a.FREQ_DURN_UNIT,'D','Days','H','Hours','M','Minutes','L','Months','W','Weeks','') Freq_legend,D.Short_Desc Intervention_Desc FROM	CP_INTERVENTION_FOR_OUTCOME A,MR_TERM_SET B,MR_TERM_CODE C,	CA_INTERVENTION D,AM_FREQUENCY E,CP_OUTCOME F,AM_DURATION_TYPE G, CP_OUTCOME_FOR_TERM_CODE H WHERE a.LIBRARY_ID = ? AND a.VERSION_NO = ? and   a.term_set_id = b.term_Set_id and   a.term_set_id = c.term_set_id and   a.term_code   = c.term_code and   a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO and   a.outcome_code = H.outcome_code and   a.intervention_code = d.intervention_Code and   a.intervention_type = 'I' and   a.freq_code = e.freq_Code (+) and   a.freq_durn_Unit = g.durn_type (+) and   a.outcome_Code = f.outcome_code  Order by a.TERM_SET_ID,a.TERM_CODE,a.outcome_code,a.SEQ_NO";
	
			
	ps = con.prepareStatement(sql);
	ps.setString(1,library_code.trim());
	ps.setString(2,version_no.trim());
//	ps.setString(1,"CAREPLAN_TEST");
//	ps.setString(2,"1");
	rs = ps.executeQuery();
				

	//out.println("<script>alert('z::"+z+",rs.getString(27)::"+rs.getString(27)+"')</script>");
		

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Library));
            _bw.write(_wl_block12Bytes, _wl_block12);
  	
	while(rs.next())
	{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString(27) ));
            _bw.write(_wl_block15Bytes, _wl_block15);

		query_executable_name		= executable_name+"&lib_short_desc="+lib_short_desc+"&library_code="+library_code+"&version_no="+version_no;

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString(5) ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(termcode_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(lib_short_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(lib_short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(lib_short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block22Bytes, _wl_block22);
		termset = rs.getString(3);
		if(!termset.equals(termset1)){

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(lib_short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block25Bytes, _wl_block25);
			
			termset1=termset;
		}
		termcode = rs.getString(5);
		if(tmp<record.length){
			termcode_id=record[tmp];
			if(!termcode_id.equals(termcode)){
				folopen		="../../eOR/images/Delete.GIF";
				icon		="../../eOR/images/Delete.GIF";
				folclose	="../../eOR/images/Delete.GIF";
			}else{
				folopen		="../../eCA/images/folderopen.gif";
				folclose	="../../eCA/images/folder.gif";
				//icon		="../../eOR/images/outcome.gif";
				icon		="../../eOR/images/accept.gif";
				tmp++;
			}
		}else{
			folopen		="../../eOR/images/Delete.GIF";
			icon		="../../eOR/images/Delete.GIF";
			folclose	="../../eOR/images/Delete.GIF";
		}
	/*	}else{
			folopen		="../../eOR/images/Delete.GIF";
			icon		="../../eOR/images/Delete.GIF";
			folclose	="../../eOR/images/Delete.GIF";
		}*/
			
		if(!termcode.equals(termcode1)){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(4)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(folclose));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(folopen));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(icon));
            _bw.write(_wl_block27Bytes, _wl_block27);
			termcode1=termcode;	
			intervention=rs.getString(9)+i;
			

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(icon));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(folopen));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(intervention));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(6)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(9)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(folclose));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(folopen));
            _bw.write(_wl_block30Bytes, _wl_block30);
		}		
		if(record1[i].equals("Y"))
			icon="../../eOR/images/accept.bmp";
		else
			icon="../../eOR/images/Delete.GIF";

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rs.getString(27)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(intervention));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(27)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(query_executable_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(27)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(workAreaFrame));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(icon));
            _bw.write(_wl_block32Bytes, _wl_block32);
		i++;	
	}// End of (result set)

 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(executable_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
	
		
}
catch(Exception ee)
{
//	out.println("Exception in Generate Preview Tree "+ee.toString());//COMMON-ICN-0181
     ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
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
}
