package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __spltyhomepagehistrepresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpltyHomePageHistRepResult.jsp", 1709116364418L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/SpltyHomePageLinkRep.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t  \t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body onScroll=\"scrollTitle()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<form name=\"RecClinicalNotesLinkMedResultForm\" id=\"RecClinicalNotesLinkMedResultForm\">\t\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr >\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n</td>\n</tr>\n</table>\n</div>\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr  >\n\t\t\t\t<td  >\n\t\t\t\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'1\' width=\'100%\'>\n\t\t\t\t<tr >\n\t\t\t\t<td class=CAHIGHERLEVELCOLOR colspan=2>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"chkbox";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onClick=\"perform(this)\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="     >\n\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\n                <input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'chk_value";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'ret_value";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'D";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t\t\t\t \n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=CAGROUP colspan=2><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n                    <input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="T";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'> \n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' width=\'40%\' >\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onClick=\"performchkbox(this)\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  >\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=CAFOURTHLEVELCOLOR>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="-";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =")\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\n\t\t\t\t\t<img id=\'textimg\' src=\'../../eCA/images/flow_text.gif\' onClick=\"return getText(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\" >\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="E";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'> \n\t\t\t\t\t<input type=\'hidden\' name=\'hist_data_type";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'hist_data_type";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' value = \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\n\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"hidden\" name=\"countcheck\" id=\"countcheck\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\t\t\n\t\n\t\t\n\t\t\t\n\t\t\t\n</table>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</form>\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet Bean= null;synchronized(session){
                Bean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("Bean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(Bean==null){
                    Bean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("Bean",Bean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");

	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String	from_date_time		=	"",		to_date_time		=	"";
	String	from_date_time_th	=	"",		to_date_time_th		=	"";
    String  patient_id = "";
    String  hist_rec_type	 = "";
	String  class1	 = "";
    String  event_group	 = "";
   	String  comp_id_code	 = "";
    String  current_encounter	 = "";
	String	encounter_id = "";
    String  order_by1	 = "";
    String  order_by2	 = "";
    String  event_date_str	 = "";
    String  event_date_str_prev	 = "";
    String  event_group_desc	 = "";
    String  event_group_desc_prev = "";
    String  event_time_str	 = "";
    String  event_desc	 = "";
    String  result_num	 = "";
    String  result_num_uom	 = "";
    String  normalcy	 = "";
	String  normalcy_str	 = "";
    String  normal_low_value_str	 = "";
    String  normal_high_value_str	 = "";
    String  result_str	 = "";
    String  hist_data_exists	 = "";
    String  contr_sys_id	 = "";
    String  accession_num	 = "";
    String  contr_sys_event_code	 = "";
    String  return_format	 = "";
    String  chkbox	 = "N";
    String classValue="";
    String hist_data_type="";
	
	StringBuffer strsql1 = new StringBuffer(" ");

	
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");


	from_date_time_th	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time_th		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
    patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");
	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	class1				=	(request.getParameter("class1")==null)	?	""	:	request.getParameter("class1");
	event_group			=	(request.getParameter("event_group")==null)	?	""	:	request.getParameter("event_group");
	comp_id_code		=	(request.getParameter("comp_id_code")==null)	?	""	:	request.getParameter("comp_id_code");
	current_encounter	=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	order_by1			=	(request.getParameter("order_by1")==null)	?	""	:	request.getParameter("order_by1");
	order_by2			=	(request.getParameter("order_by2")==null)	?	""	:	request.getParameter("order_by2");
	String from 		= 	request.getParameter("from");
	String to 			= 	request.getParameter("to");
	String rowid="";
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	int start = 0 ;
	int end = 0 ;
	int i=1;
	int d=0;
	int t=0;
	int x=0;
	int k=0;
	int time=0;
	int maxRecord =0;
	
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
    
	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

   	try
	{
      con =  ConnectionManager.getConnection(request);
	  StringBuffer str=new StringBuffer();
	  str.append("SELECT COUNT(*) as total FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP and C.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?  AND A.EVENT_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY hh24:mi') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY hh24:mi')");	
		
	  if(!(event_group.equals("")))
	  str.append(" and A.EVENT_GROUP =?");
	  
	  if(!(class1.equals("")))
	  str.append(" and A.EVENT_CLASS =?"); 
	  if(!(comp_id_code.equals("")))
		str.append(" and B.EVENT_CODE =?"); 

	  if (!current_encounter.equals("N"))
			str.append(" and a.encounter_id=? ");

		stmt = con.prepareStatement(str.toString());
	 	
		int st1=0;

		stmt.setString(++st1,patient_id);     
		stmt.setString(++st1,hist_rec_type);
		stmt.setString(++st1,from_date_time_th);
        stmt.setString(++st1,to_date_time_th);

       
	   if(!(event_group.equals("")))
		 stmt.setString(++st1,event_group);
        
	   if(!(class1.equals("")))
		   stmt.setString(++st1,class1);
		if(!(comp_id_code.equals("")))
		stmt.setString(++st1,comp_id_code);
       
	   if (!current_encounter.equals("N"))
			stmt.setString(++st1,encounter_id);	
	   

		rs = stmt.executeQuery();
	    
		if(rs!=null && rs.next())
			maxRecord=rs.getInt("total");
	
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();

		if (maxRecord== 0)
		{
			chkbox="Y";
			
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		
	/*  strsql1.append("SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE,	  A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,'ABNORMAL',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.FACILITY_ID,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?  AND A.EVENT_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY hh24:mi') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY hh24:mi')");	
		
	  if(!(event_group.equals("")))
	  strsql1.append(" and C.EVENT_GROUP =?");
	  
	  if(!(class1.equals("")))
	  strsql1.append(" and A.EVENT_CLASS =?"); 
	  
	  if(!(comp_id_code.equals("")))
		strsql1.append(" and B.EVENT_CODE =?"); 

	  	if (!current_encounter.equals("N"))
			strsql1.append(" and a.encounter_id=? ");

		  
	  if(order_by1.equals("D"))
	   {
		if(order_by2.trim().equals("AS"))
		{
				strsql1.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
		else
		{
			strsql1.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
	  }
	   else if (order_by1.equals("N"))
	   {
		if(order_by2.trim().equals("AS"))
		 {
			strsql1.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
		 }
	    else
		 {
		   strsql1.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
		 }
	   }
		{
		strsql1.append(" ,6,7,8,9,3");
		}
		*/
		//
	  strsql1.append("SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE,	  A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT A.NORMALCY_IND FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.FACILITY_ID,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =?  AND A.EVENT_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY hh24:mi') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY hh24:mi')");	
		
	  if(!(event_group.equals("")))
	  strsql1.append(" and C.EVENT_GROUP =?");
	  
	  if(!(class1.equals("")))
	  strsql1.append(" and A.EVENT_CLASS =?"); 
	  
	  if(!(comp_id_code.equals("")))
		strsql1.append(" and B.EVENT_CODE =?"); 

	  if (!current_encounter.equals("N"))
			strsql1.append(" and a.encounter_id=? ");

		  
	  if(order_by1.equals("D"))
	   {
		if(order_by2.trim().equals("AS"))
		{
				strsql1.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
		else
		{
			strsql1.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
		}
	  }
	   else if (order_by1.equals("N"))
	   {
		if(order_by2.trim().equals("AS"))
		 {
			strsql1.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
		 }
	    else
		 {
		   strsql1.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
		 }
	   }
		{
		strsql1.append(" ,6,7,8,9,3");
		}
		//
	  
		int st=0;
		stmt = con.prepareStatement(strsql1.toString());
		stmt.setString(++st,patient_id);
		stmt.setString(++st,hist_rec_type);
   		stmt.setString(++st,from_date_time_th);
        stmt.setString(++st,to_date_time_th);
       
	   if(!(event_group.equals("")))
	   stmt.setString(++st,event_group);
	
		if(!(class1.equals("")))
		 stmt.setString(++st,class1);
		if(!(comp_id_code.equals("")))
		stmt.setString(++st,comp_id_code);

		if (!current_encounter.equals("N"))
			stmt.setString(++st,encounter_id);	

		rs = stmt.executeQuery();
		
            _bw.write(_wl_block9Bytes, _wl_block9);


if ( !(start <= 1) )
{
	out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
	out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&encounter_id="+encounter_id+"&event_group="+event_group+"&hist_rec_type="+hist_rec_type+"&return_format="+return_format+"&order_by1="+order_by1+"&order_by2="+order_by2+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"'"+"text-decoration='none' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
}
else
{
	out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
}

  if ( !( (start+14) > maxRecord ) )
  {
	out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkHistRepResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&current_encounter="+current_encounter+"&encounter_id="+encounter_id+"&event_group="+event_group+"&hist_rec_type="+hist_rec_type+"&return_format="+return_format+"&order_by1="+order_by1+"&order_by2="+order_by2+"&patient_id="+patient_id+"&from="+(start+14)+"&to="+(end+14)+"'"+" text-decoration='none' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
  }

            _bw.write(_wl_block10Bytes, _wl_block10);
 

	if ( start != 1 )
	{
	    for( int j=1; j<start; i++,j++ )
		{
	       rs.next() ;
	    }
	}

		
		int p=0; 
	 
		while(rs!=null && rs.next() && i<=end)
		{
			 event_date_str=rs.getString("EVENT_DATE_STR")==null?"":rs.getString("EVENT_DATE_STR");
			 event_date_str	=	com.ehis.util.DateUtils.convertDate(event_date_str,"DMY","en",locale);
			 rowid=rs.getString("ROW_ID")==null?"":rs.getString("ROW_ID");
			 event_group_desc=rs.getString("EVENT_GROUP_DESC")==null?"":rs.getString("EVENT_GROUP_DESC");
			 event_time_str=rs.getString("EVENT_TIME_STR")==null?"":rs.getString("EVENT_TIME_STR");
			 event_desc=rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
			 result_num=rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
			 result_num_uom=rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
			 //normalcy_str=rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
			 normalcy = rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
			 //
				if  (normalcy.equals("HIGH_STR"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");										
				else if(normalcy.equals("LOW_STR"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
				else if(normalcy.equals("ABN_STR"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
				else if(normalcy.equals("CRIT_STR"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
				else if(normalcy.equals("CRIT_HIGH_STR"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
				else if(normalcy.equals("CRIT_LOW_STR"))
					normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
				
			 //
			 hist_data_type=rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
			 normal_low_value_str=rs.getString("normal_low_value_str")==null?"0":rs.getString("normal_low_value_str");
		 
			int normal_low_value=(int)Float.parseFloat(normal_low_value_str);
			normal_low_value_str=String.valueOf(normal_low_value);
			
			normal_high_value_str=rs.getString("normal_high_value_str")==null?"0":rs.getString("normal_high_value_str");
		 				
			int normal_high_value=(int)Float.parseFloat(normal_high_value_str);
			normal_high_value_str=String.valueOf(normal_high_value);
			result_str =rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
	   		hist_data_exists =rs.getString("HIST_DATA_EXISTS")==null?"":rs.getString("HIST_DATA_EXISTS");
		    contr_sys_id =rs.getString("CONTR_SYS_ID")==null?"":rs.getString("CONTR_SYS_ID");
			accession_num =rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			contr_sys_event_code =rs.getString("CONTR_SYS_EVENT_CODE")==null?"":rs.getString("CONTR_SYS_EVENT_CODE");

			 if ( i % 2 == 0 )
				 classValue = "QRYEVEN" ;
			 else
				classValue = "QRYODD" ;
		  
			String beankey="";		
			String checkstatus="";		
         
			for(int m=0;m<Bean.getSize();m+=2)
			{
				beankey=Bean.getObject(m).toString();
					
  				if(rowid.equalsIgnoreCase(beankey))
				{
					checkstatus="checked";
                    p++; 
					break;
				}
			}
            
            _bw.write(_wl_block11Bytes, _wl_block11);

					time++;
					if(!event_date_str_prev.equals(event_date_str))
			        {		
						++x;
						d++;
						
						
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(x));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(x));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(x));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(event_date_str));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(x));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(x));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(x));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(x));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(d));
            _bw.write(_wl_block23Bytes, _wl_block23);
event_group_desc_prev="";t=0;}
            _bw.write(_wl_block24Bytes, _wl_block24);

					if(!event_group_desc_prev.equals(event_group_desc))
			       {
					++x;
					t++;
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(x));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(x));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(x));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(x));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(x));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(x));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(x));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(d));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(t));
            _bw.write(_wl_block30Bytes, _wl_block30);
time=1;}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"CAFOURTHLEVELCOLOR")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(++x));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(++x));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(x));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(event_time_str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
if (hist_data_type.equals("NUM")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(result_num_uom));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(normalcy_str));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(normal_low_value_str));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(normal_high_value_str));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if (!result_str.equals("")) 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
					else if (hist_data_type.equals("STR")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
if(hist_data_exists.equals("Y")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(x));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(x));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(x));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(x));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(d));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(t));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(time));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(x));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(x));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(hist_data_type));
            _bw.write(_wl_block56Bytes, _wl_block56);

				i++;
				k++;
				 event_date_str_prev=event_date_str;
				 event_group_desc_prev=event_group_desc;
		}
		
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkMedResult.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(k));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(x));
            _bw.write(_wl_block60Bytes, _wl_block60);
if(chkbox.equals("N"))
{
out.println("<script>perform1()</script>");

}

            _bw.write(_wl_block61Bytes, _wl_block61);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
