package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __procedurelistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProcedurelistResult.jsp", 1709116070606L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!-- <modifeid by Arvind @03-12-2008> -->\n\n  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\" src=\'../js/ProcedureList.js\'></script>\n\n<SCRIPT>\nfunction Next(inputString)\n{   \n\tvar temp1=\'\'; var increment=5;var tempRowIds = \"\";\t\n\tvar k = parent.frames[0].rowIDArrayProcList.length;\t\n\tvar patient_id    =\tdocument.result_form.patientid.value;\n\tvar proc_code     = document.result_form.proccode.value;\n\tvar service_code  = document.result_form.servicecode.value;\n\tvar code_set      = document.result_form.codeset.value;\n\tvar from_date     = document.result_form.fromdate.value;\n\tvar end_date      = document.result_form.enddate.value;\n\tvar start         = document.result_form.startno.value;\n\tvar end           = document.result_form.endno.value;\n\tvar totcount\t  =\tdocument.result_form.count.value;\n\tvar mode1         = document.result_form.mode.value;\n\t\n\tif( (parseInt(k,10) - parseInt(end,10)) < 6){\n\t\tif(mode1==\"first\")\n\t\t\tincrement = (parseInt(k,10) - (parseInt(end,10)-1))-2;\n\t\telse\n\t\t\tincrement = (parseInt(k,10) - parseInt(end,10))-2;\n\t\t}\n\telse\n\t\tincrement = 4;\n\t\t\t\n\tif(inputString==\'next\')\n\t{   \n\t\tif(mode1==\"first\")\n\t\t\tvar from1=(parseInt(end,10));\n\t\telse\n\t\t\tvar from1=(parseInt(end,10)+1);\n\t\t\tvar to1=(parseInt(from1,10)+parseInt(increment,10));\n\t}\n\tif(inputString==\'prev\')\n\t{   \n\t\tvar to1=(parseInt(start,10)-1);\n\t\tvar from1=(parseInt(to1,10)-4);\n\t}\n\t\n\tfor(var j=parseInt(from1,10);j<=parseInt(to1,10);j++)\n\t\ttemp1+=\"\'\"+parent.frames[0].rowIDArrayProcList[j]+\"\',\";\n\t\t\n\t\t\n\tdocument.location.href=\"../../eCA/jsp/ProcedurelistResult.jsp?from=\"+from1+\"&to=\"+to1+\"&patient_id=\"+patient_id+\"&proc_code=\"+proc_code+\"&service_code=\"+service_code+\"&code_set=\"+code_set+\"&rowIDFields=\"+encodeURIComponent(temp1,\"UTF-8\")+\"&from_date=\"+from_date+\"&end_date=\"+end_date+\"&tot=\"+totcount+\"\";\n}\n</SCRIPT>\n</head>\n\n<body  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onScroll=\'scrollTitleProcResult()\' >\n<form name=\'result_form\' id=\'result_form\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[0].rowIDArrayProcList[";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="]=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<Script language=javascript>\n\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\t\t\t\tparent.procedurelistresult.location.href=\'../../eCommon/html/blank.html\'; \n\t\t\t\t\t\n\t\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t\t\n\t<table class=\'grid\' width=\'100%\' id=\'dataTable\'> \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t<tr style=\'background-color:;\'  onclick=\'refer(this,7);\'>\n\t\t\t\t\t<td class=\'gridData\' width=\'\' nowrap>\n\t\t\t\t\t<a class=\'gridLink\'  href=\'ProcedurelistResultDetail.jsp?facility_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&proc_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&encounter_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&srl_no=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' target=\'procedurelistresultdetail\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n\t\t\t\t\t<td class=\'gridData\' width=\'\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t<td class=\'gridData\' width=\'\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<input type=\"hidden\" name=\"patientid\" id=\"patientid\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"fromdate\" id=\"fromdate\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"enddate\" id=\"enddate\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"proccode\" id=\"proccode\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"codeset\" id=\"codeset\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"servicecode\" id=\"servicecode\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"startno\" id=\"startno\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"endno\" id=\"endno\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\n<tr style=\'visibility:hidden\'>\n<td class=\'columnHeadercenter\' width=\'\' nowrap ><font size=1>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n<td class=\'columnHeadercenter\' width=\'\' nowrap><font size=1>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td>\n<td class=\'columnHeadercenter\' width=\'\' nowrap ><font size=1>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></td>\n</tr>\n\n</table>\n\n</form>\n\t<script>\n\t\t\n\t\tif(parent.procedurelisttitle.formProcedurelistTitle== null)\n\t\t{\n\t\t\tsetTimeout(\'\',500); // waiting for Title page to load\n\t\t\t\n\t\t\tif(parent.procedurelisttitle.formProcedurelistTitle!= null)\n\t\t\t{\n\t\t\t\t\n\t\t\t\tif ((parseInt(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =",10) <=1))\n\t\t\t\t\tparent.procedurelisttitle.document.getElementById(\"prevRecs\").style.visibility = \'hidden\';\n\t\t\t\telse\n\t\t\t\t\tparent.procedurelisttitle.document.getElementById(\"prevRecs\").style.visibility = \'visible\';\t\t\t\n\t\t\t\tvar len=parent.frames[0].rowIDArrayProcList.length;\n\t\t\t\t\n\t\t\t\tif(((parseInt(";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =",10)+5) >= ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="))\n\t\t\t\t\tparent.procedurelisttitle.document.getElementById(\"nextRecs\").style.visibility = \'hidden\';\n\t\t\t\telse\n\t\t\t\t\tparent.procedurelisttitle.document.getElementById(\"nextRecs\").style.visibility = \'visible\';\n\t\t\t}\n\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t\n\t\t\tif ((parseInt(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =",10) <=1))\n\t\t\t\tparent.procedurelisttitle.document.getElementById(\"prevRecs\").style.visibility = \'hidden\';\n\t\t\telse\n\t\t\t\tparent.procedurelisttitle.document.getElementById(\"prevRecs\").style.visibility = \'visible\';\t\t\t\n\t\t\tvar len=parent.frames[0].rowIDArrayProcList.length;\n\t\t\t\n\t\t\tif(((parseInt(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="))\n\t\t\t\tparent.procedurelisttitle.document.getElementById(\"nextRecs\").style.visibility = \'hidden\';\n\t\t\telse\n\t\t\t\tparent.procedurelisttitle.document.getElementById(\"nextRecs\").style.visibility = \'visible\';\n\t\t}\n\t</script> \n\t<script>\n\t\t\tif(parent.procedurelisttitle.document.getElementById(\"dataTitleTable\")==null)\n\t\t\t{\n\t\t\t\tsetTimeout(\"alignHeading();\",300);\n\t\t\t}\n\t\t\telse \n\t\t\t\talignHeading();\n\t\t\t</script>\n</body>\n</html>\n\n\n<!--<script>alignWidthProcResult();</script> -->\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
	String patient_id	="";
	String proc_code	="";
	String service_code	="";
	String from_date	="";
	String end_date		="";
	String strMode		="";
	String classValue	="";
	String code_set		="";
	String code			="";
	String procedure	="";
	String scheme		="";
	String date			="";
	String practitioner	="";
	String service_desc ="";
	String facility_name="";
	String facility_id	="";
	String encounter_id = "";
	String rowIDFields = "";
	String srl_no = "";
	String row_id="";
	String from = "";
	String to = "";
	String called_mod = "";
	
	StringBuffer sql			= new StringBuffer();
	StringBuffer strRowIdQuery	= new StringBuffer();

	int k	  =0;
	int count1=0;
	int start = 0;
	int end = 0;
	int tot=0;
		

	from = request.getParameter("from");
	to = request.getParameter("to");

	//int j = 0;
	if(from==null)
		start = 0;
	else 
		start = Integer.parseInt(from);					

	if(to==null)
		end=5;
	else
		end = Integer.parseInt(to);
    
	tot=request.getParameter("tot")==null?0:Integer.parseInt(request.getParameter("tot"));
	
   	rowIDFields  = request.getParameter("rowIDFields");

	strMode = request.getParameter("mode");

	if(strMode == null || strMode.equals(""))
		strMode = "";
		
	if(rowIDFields == null) 
		rowIDFields="";
    
    
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement pstmt=null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try
	{
		con				= ConnectionManager.getConnection(request);
		rs				=null;
		pstmt			=null;
		
		patient_id		=	request.getParameter("patient_id");
		proc_code		=	request.getParameter("proc_code");
		proc_code		=	proc_code.trim();
		service_code	=	request.getParameter("serv_code");
		code_set		=	request.getParameter("code_set")==null ? "N" : request.getParameter("code_set");
		encounter_id=request.getParameter("encounter_id")== null ? "N" : request.getParameter("encounter_id");
		called_mod=request.getParameter("encounter_id")== null ? "N" : request.getParameter("called_mod");
		
		if (service_code == null) 
			service_code="";

		from_date		=request.getParameter("from_date");
		end_date		=request.getParameter("to_date");
		
		if(patient_id==null)	
			patient_id = "";
		if(proc_code==null)
			proc_code="";
		if(service_code==null)
			service_code="";
		if(code_set==null)
			code_set="";
		if(from_date==null)
			from_date="";
		if(end_date==null)
			end_date="";
		
		from_date	= com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
		end_date	= com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");

		 /* sql.append("Select a.rowid row_id,a.proc_narration procedure,a.proc_code,TERM_SET_DESC scheme, to_char(a.proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name, a.PATIENT_ID, a.SRL_NO,a.proc_date dummydate, (select d.short_desc from am_service d where  d.service_code = c.service_code) service_desc, e.facility_name facility_name , a.facility_id facility_id, a.encounter_id encounter_id from pr_encounter_procedure a, am_practitioner b, pr_encounter c,  sm_facility_param e, mr_term_set f where a.PATIENT_ID = ? and b.practitioner_id=a.practitioner_id and c.facility_id = a.facility_id and c.encounter_id = a.encounter_id and e.facility_id = a.facility_id and f.term_set_id=a.PROC_CODE_SCHEME and ERROR_YN='N' ");
			
		if(!(code_set.equals("")))
			 sql.append( " and a.PROC_CODE_SCHEME=? ");
		
		if(!(proc_code.equals("")))
			 sql.append( " and a.proc_code=? ");
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			 sql.append(" and to_date(a.proc_date) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
		else if((end_date.equals("")) && !(from_date.equals("")))
			 sql.append(" and to_date(a.proc_date) >= to_date(?,'dd/mm/yyyy')");
		else if((from_date.equals("")) && !(end_date.equals("")))
			 sql.append(" and to_date(a.proc_date) <= to_date(?,'dd/mm/yyyy')");
 		else if(!(service_code.equals("")))
			 sql.append( " and c.service_code = ?");

		strRowIdQuery = strRowIdQuery.append(sql.toString());
		
		if (strMode.equals("first") )
		{
			strRowIdQuery = strRowIdQuery.append(" order by dummydate desc "); */
		
			sql.append("Select a.rowid row_id,(select SHORT_DESC from mr_term_code where TERM_CODE = rtrim(a.proc_code) and TERM_SET_ID = a.PROC_CODE_SCHEME) procedure,a.proc_code,TERM_SET_DESC scheme, to_char(a.proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'2') practitioner_name, a.PATIENT_ID, a.SRL_NO,a.proc_date dummydate, AM_GET_DESC.AM_SERVICE(c.service_code,?,'2') service_desc, 			SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1') facility_name , a.facility_id facility_id, a.encounter_id encounter_id from pr_encounter_procedure a, pr_encounter c,  mr_term_set f where a.PATIENT_ID = ? and c.facility_id = a.facility_id and c.encounter_id = a.encounter_id and  f.term_set_id=a.PROC_CODE_SCHEME and ERROR_YN='N' ");
		
		if(!(encounter_id.equals("N")))			
			 sql.append( " and a.encounter_id=? ");		

		if(!(code_set.equals("")))
			 sql.append( " and a.PROC_CODE_SCHEME=? ");		
		
		if(!(proc_code.equals("")))
			 sql.append( " and a.proc_code=? ");
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			 sql.append(" and to_date(a.proc_date) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
		else if((end_date.equals("")) && !(from_date.equals("")))
			 sql.append(" and to_date(a.proc_date) >= to_date(?,'dd/mm/yyyy')");
		else if((from_date.equals("")) && !(end_date.equals("")))
			 sql.append(" and to_date(a.proc_date) <= to_date(?,'dd/mm/yyyy')");
		
		if(!(service_code.equals("")))
			 sql.append( " and c.service_code = ?");

		 
		strRowIdQuery.append("Select a.rowid row_id,a.proc_date dummydate from pr_encounter_procedure a, pr_encounter c,  mr_term_set f where a.PATIENT_ID = ? and c.facility_id = a.facility_id and c.encounter_id = a.encounter_id and  f.term_set_id=a.PROC_CODE_SCHEME and ERROR_YN='N' ");
			
		if(!(code_set.equals("")))
			 strRowIdQuery.append( " and a.PROC_CODE_SCHEME=? ");
		
		if(!(proc_code.equals("")))
			 strRowIdQuery.append( " and a.proc_code=? ");
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			 strRowIdQuery.append(" and to_date(a.proc_date) between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ");
		else if((end_date.equals("")) && !(from_date.equals("")))
			 strRowIdQuery.append(" and to_date(a.proc_date) >= to_date(?,'dd/mm/yyyy')");
		else if((from_date.equals("")) && !(end_date.equals("")))
			 strRowIdQuery.append(" and to_date(a.proc_date) <= to_date(?,'dd/mm/yyyy')");
		
		if(!(service_code.equals("")))
			 strRowIdQuery.append( " and c.service_code = ?");		
		
		
		if (strMode.equals("first") )
		{
			strRowIdQuery.append(" order by dummydate desc ");
			pstmt=con.prepareStatement(strRowIdQuery.toString());
			
				pstmt.setString(++count1,patient_id);			
			
			if(!(code_set.equals("")))
				pstmt.setString(++count1,code_set);

			if(!(proc_code.equals("")))
				pstmt.setString(++count1,proc_code);
			
			if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			{
				pstmt.setString(++count1,from_date);
				pstmt.setString(++count1,end_date);
			}
			else if((end_date.equals("")) && !(from_date.equals("")))
				 pstmt.setString(++count1,from_date);
			else if((from_date.equals("")) && !(end_date.equals("")))
				 pstmt.setString(++count1,end_date);

			if(!(service_code.equals("")))
				 pstmt.setString(++count1,service_code);
			
			rs=pstmt.executeQuery();
						
			while (rs.next())
			{
				row_id=rs.getString("row_id");
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(k));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(java.net.URLEncoder.encode(row_id)));
            _bw.write(_wl_block10Bytes, _wl_block10);


					k++;
					tot++;
								
					if(k <= 5)
						rowIDFields = rowIDFields + "'" + java.net.URLEncoder.encode(row_id) + "'," ;
			}

			if(k==0)
			{ 
				
            _bw.write(_wl_block11Bytes, _wl_block11);
      
			}

			if(rs != null) rs.close();
			if(pstmt  != null) pstmt.close();
		}

            _bw.write(_wl_block12Bytes, _wl_block12);
		
		if(!rowIDFields.equals(""))
	   		sql.append(" and a.rowid in ("+java.net.URLDecoder.decode(rowIDFields.substring(0,rowIDFields.length()-1))+" )");
		sql.append(" order by dummydate desc ");
   		
		
		pstmt=con.prepareStatement(sql.toString());		
		
		count1=0;
		k=0;	
		
		pstmt.setString(++count1,locale);
		pstmt.setString(++count1,locale);
		pstmt.setString(++count1,locale);
		pstmt.setString(++count1,patient_id);	
		
	    if(!(encounter_id.equals("N")))
			pstmt.setString(++count1,encounter_id);

		if(!(code_set.equals("")))
			pstmt.setString(++count1,code_set);

		if(!(proc_code.equals("")))
			pstmt.setString(++count1,proc_code);
		
		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
		{
			pstmt.setString(++count1,from_date);
			pstmt.setString(++count1,end_date);
		}
		else if((end_date.equals("")) && !(from_date.equals("")))
			 pstmt.setString(++count1,from_date);
		else if((from_date.equals("")) && !(end_date.equals("")))
			 pstmt.setString(++count1,end_date);
		if(!(service_code.equals("")))
			 pstmt.setString(++count1,service_code);
		
		rs=pstmt.executeQuery();
       
		if (rs !=null)
        {
        	while(rs.next())
			{
				if ( k%2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				code			=rs.getString("proc_code");
				procedure		=rs.getString("procedure");
				scheme			=rs.getString("scheme");
				date			=rs.getString("proc_date");
				practitioner	=rs.getString("practitioner_name");
				service_desc	=rs.getString("service_desc");
				facility_name	=rs.getString("facility_name");
				facility_id		=rs.getString("facility_id");
				encounter_id	=rs.getString("encounter_id");				
				srl_no			=(rs.getString("srl_no")==null)?"":rs.getString("SRL_NO");
				date			=	com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);
				
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(procedure));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);

				k++;
		      }
		}
			
}
	catch(Exception e)
	{
		//out.print("ERROR"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		
	}
	finally
	{
		if(rs!=null)	rs.close();
		if(pstmt!=null) 	pstmt.close();
		ConnectionManager.returnConnection(con,request);

	}


            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code_set));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(start));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(end));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tot));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strMode));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(start));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tot));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(start));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tot));
            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
