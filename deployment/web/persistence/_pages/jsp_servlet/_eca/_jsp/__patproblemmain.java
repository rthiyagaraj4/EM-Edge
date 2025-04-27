package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patproblemmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatProblemMain.jsp", 1709115217202L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<script language=\'javascript\' src=\'../js/PatProblem.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n    \n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\talert(getMessage(\'CA_DIAG_PROCEDURE\',\'CA\'));\n\t\t</script> \n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<frameset rows=\'20%,3%,*,5%,0%,0%,7%\'  framespacing=0 border=\"0\">\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<frameset rows=\'27%,4%,*,6%,0%\'  framespacing=0 border=\"0\">\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<frame name =\"PatProblemQueryResult\" src=\"PatProblemQueryResult.jsp?Logical_Seq=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&stage_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&stage_desc=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Function=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Patient_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&relationship_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Encounter_Id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Practitioner_Id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&Locn_Code=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&Locn_Type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&f_authorize_yn=N&P_context=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&patient_class=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&called_from_ip=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&Sec_Hdg_Code=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&patient_type=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&Age=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&Dob=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&Sex=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&modal_yn=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&oper_num=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" marginwidth=0 marginheight=0 frameborder=0 noresize> </frame>\n\t\t\t<frame name=\"PatProblemHeader\" src=\"PatProblemHeader.jsp?\"  marginwidth=0 marginheight=0 frameborder=0 noresize> </frame>\n\t\t\t<frame name =\"addModifyPatProblem\" src=\"addModifyPatProblem.jsp?Logical_Seq=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&QueryString=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&visit_adm_date=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&episode_type=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&diag_code=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" marginwidth=0 marginheight=0 frameborder=0 scrolling=\'yes\'  noresize></frame>\n\t\t\t<frame name =\"PatProblemQueryTools\" src=\"PatProblemQueryTools.jsp?Logical_Seq=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&f_authorize_yn=N&Sec_Hdg_Code=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&P_context=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" marginwidth=0 marginheight=0 frameborder=0 scrolling=\'no\'  noresize></frame>\n\t\t\t<frame name=\'support\' src=\'../../eCommon/html/blank.html\' marginwidth=0 marginheight=0 frameborder=0 scrolling=\'no\'  noresize></frame>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<frame name=\'msgframe0\' src=\'../../eCommon/jsp/error.jsp\' marginwidth=0 marginheight=0 frameborder=0 scrolling=\'no\' ></frame> \n\t\t\t\t<frame name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' marginwidth=0 marginheight=0 frameborder=0 scrolling=\'no\' ></frame>\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</html>\n";
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//String a=request.getQueryString();
String facility_id			= (String)session.getValue("facility_id");
String Patient_Id			= request.getParameter("patient_id");
String Encounter_Id			= request.getParameter("episode_id");
String oper_num				= request.getParameter("oper_num")==null?"":request.getParameter("oper_num");

String Practitioner_Id		= "";
String relationship_id		= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
String Locn_Code			= request.getParameter("location_code");
String Locn_Type			= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");

if(Locn_Type.equals("")) 
	Locn_Type="C";

String modal_yn				= request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");


String term_code			= request.getParameter("term_code")==null?"":request.getParameter("term_code");
String Sec_Hdg_Code			= request.getParameter("Sec_Hdg");
String function				= request.getParameter("Function");
String patient_type			= request.getParameter("patient_type");
String context				= request.getParameter("Context");
String logicalseqno			= request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
String called_from_ip = request.getParameter("IP_YN")==null?"N":request.getParameter("IP_YN");

String age = request.getParameter("Age")==null?"":request.getParameter("Age");
String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

Practitioner_Id		= request.getParameter("ip_practitioner_id")==null?"":request.getParameter("ip_practitioner_id");	

if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
		Practitioner_Id		= (String)session.getValue("ca_practitioner_id");	
}

/* Added by Chitra */
String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
//added for notes
String visit_adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
String episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
if(stagecode.equals("A")){
	out.println("<script>window.document.title='Admitting Diagnosis'</script>");
}else if(called_from_ip.equals("N")){
	out.println("<script>window.document.title='Diagnosis'</script>");
}
if(!stagecode.equals("")) Locn_Type = "N";

Connection con = null; //(Connection)session.getValue("connection") ;
PreparedStatement stmt = null;
ResultSet rset = null;
PreparedStatement pstmt	= null;
ResultSet rs = null;
String past_visit="";
boolean func_appl_yn = true;

try
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
	pstmt.setString(1,facility_id);		// facility id
    pstmt.setString(2,"PROCEDURE");		// function
    pstmt.setString(3,Encounter_Id);	// episode_id
    pstmt.setString(4,patient_class);   // episode_type
    pstmt.setString(5,Patient_Id); 

	rs = pstmt.executeQuery();
    while(rs!=null && rs.next())
    {
		past_visit = rs.getString(1);
    }
    if(rs!=null) rs.close();
    if(pstmt!=null) pstmt.close();
             
    // If the Episode is not closed, Continue.
    if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE"))
    {
		func_appl_yn = false;
		
            _bw.write(_wl_block7Bytes, _wl_block7);

    }
	if(func_appl_yn)
	{
		/* ---Ends---  @Added on 08/08/2002 by Prakash.S */
		stmt = con.prepareStatement("select 1 from mr_parameter"); 
		rset = stmt.executeQuery();
		
		String str ="Logical_Seq=" +logicalseqno + "&Function=" + function +"&Patient_Id=" +Patient_Id  +"&Encounter_Id=" +Encounter_Id+"&Practitioner_Id="+ Practitioner_Id + "&Locn_Code=" + Locn_Code+"&Locn_Type=" + Locn_Type+ "&f_authorize_yn=N&P_context="+context+ "&stage_code="+ stagecode+ "&stage_desc="+ stagedesc + "&patient_class=" + patient_class + "&called_from_ip="+called_from_ip;
		

		if(rset.next())
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);
 if(called_from_ip.equals("Y") ||modal_yn.equals("Y")) {
            _bw.write(_wl_block9Bytes, _wl_block9);
 }else {
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(context));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Sec_Hdg_Code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(age));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(context));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(java.net.URLEncoder.encode(str)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(age));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(stagecode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Sec_Hdg_Code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(context));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(stagedesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(age));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
 if(called_from_ip.equals("Y") ||modal_yn.equals("Y")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block41Bytes, _wl_block41);

		}
		else
		{
			out.println("<script>alert(getMessage('DEFINE_MR_PARAM','CA'))</script>");
		}
	}//end of func_appl_yn
	
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
} 
catch (Exception e) 
{
	//out.println("Exception @ try "+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally{
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
}
