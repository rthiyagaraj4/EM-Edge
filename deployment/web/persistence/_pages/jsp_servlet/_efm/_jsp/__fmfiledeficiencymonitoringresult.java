package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import webbeans.eFM.FileDeficiencyMonitoring;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmfiledeficiencymonitoringresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileDeficiencyMonitoringResult.jsp", 1709116841700L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eFM/js/FMFileDeficiencyMonitoring.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\nfunction OnSelection(EncounterId,FileNo,PatientId,admndate,discdate,found,carelocn, file_type_code, volume_no,row_count)\n{\n\tparent.frames[3].location.href = \"../../eFM/jsp/FMFileDeficiencyMonitoringDetails.jsp?EncounterId=\"+EncounterId+\"&FileNo=\"+FileNo+\"&PatientId=\"+PatientId+\"&Admndate=\"+admndate+\"&Discdate=\"+discdate+\"&Found=\"+found+\"&Carelocn=\"+carelocn+\"&file_type_code=\"+file_type_code+\"&row_count=\"+row_count+\"&volume_no=\"+volume_no;\n\n    //var display_yn = parent.frames[2].document.forms[0].DisplyDetail.value;\n\n\tparent.frames[4].location.href = \"../../eFM/jsp/FMFileDeficiencyMonitoringAdd.jsp?EncounterId=\"+EncounterId+\"&FileNo=\"+FileNo+\"&PatientId=\"+PatientId+\"&Admndate=\"+admndate+\"&Discdate=\"+discdate+\"&Found=\"+found+\"&Carelocn=\"+carelocn+\"&file_type_code=\"+file_type_code+\"&volume_no=\"+volume_no;\n}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\'FileDeficiencyMonitoring_result\' id=\'FileDeficiencyMonitoring_result\'>\n <table id=\'tb1\' border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tvar errors = getMessage(\"FSLOCN_FILE_NOT_EXIST\",\"FM\");\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors;\n\t\t\t\tvar file_no = parent.frames[1].document.forms[0].file_no;\n\t\t\t\tif ((file_no.type != \'hidden\') && (!file_no.disabled))\n\t\t\t\t\tparent.frames[1].document.forms[0].file_no.focus();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\t\t\t\t\t//alert(\"File is in transit so cannot proceed\");\n\t\t\tvar msg=\"\";\n\t\t\tvar curr_file_status=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t \n\t\t\t if(curr_file_status==\"T\")\n\t\t\t{\n\t\t\t msg = getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\'); \t\t\t\t\t\n\t\t\t}\n\t\t\tif(curr_file_status==\"L\")\n\t\t\t{\n\t\t\t msg = getMessage(\'FILE_IS_LOST\',\'FM\'); \t\t\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\talert(msg);\n\tparent.frames[1].document.forms[0].search.disabled=false;\n\tparent.frames[1].document.forms[0].encounter_id.disabled=false;\n\tparent.frames[1].document.forms[0].pat_search.disabled=false;\n\tparent.frames[1].document.forms[0].encounter_id_search.disabled=false;\n\tparent.frames[1].document.forms[0].volume_no.disabled=false;\n\tparent.frames[1].document.forms[0].patient_id.disabled=false;\n\tif (parent.frames[1].document.forms[0].file_type_appl_yn.value == \"N\")\n\t\t\t{\n\tparent.frames[1].document.forms[0].file_no.disabled\t\t=\tfalse;\n\tparent.frames[1].document.forms[0].file_no.value=\"\";\t\t\n\t\t\t}\n\telse if (parent.frames[1].document.forms[0].file_type_appl_yn.value == \"Y\")\n\t\t\t{\n\t   parent.frames[1].document.forms[0].file_type_code.disabled\t=\tfalse;\n\t\tparent.frames[1].document.forms[0].file_type_code.value=\"\";\n\t\t\t}\t\n\t\t\n\t\t\n\t\tparent.frames[1].document.forms[0].cuurfslocn.disabled\t=\tfalse;\n\t\tparent.frames[1].document.forms[0].patient_id.value=\"\";\t\n\t\tparent.frames[1].document.forms[0].patient_id.onblur();\n\t\t//parent.frames[1].document.forms[0].volume_no.value=\"\";\n\t\tparent.frames[1].document.forms[0].encounter_id.value=\"\";\n\t\tparent.deficiency_result.location.href = \'../../eCommon/html/blank.html\';\n\t\tparent.deficiency_detail.location.href = \'../../eCommon/html/blank.html\';\n\t\tparent.deficiency_detail_add.location.href = \'../../eCommon/html/blank.html\';\n\n\t\t\t\n\t\t\t</script>\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar eidar= \"\";\n\t\t\t\t\t\tvar pidar= \"\";\n\t\t\t\t\t\teidar=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'.split(\":\");\n\t\t\t\t\t\tpidar=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'.split(\":\");\t\t\t\t\t\t\n\t\t\t\t\t\tvar elab=\"\"\n\t\t\t\t\t\tvar evalu=\"\"\n\t\t\t\t\t\tvar plab=\"\"\n\t\t\t\t\t\tvar pvalu=\"\"\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(eidar!=null)\n\t\t\t\t\t\t\t{elab=eidar[0];evalu=eidar[1];}\n\t\t\t\t\t\tplab=pidar[0];pvalu=\":\"+pidar[1];\n\n\t\t\t\t\t\tif(elab==null || evalu==\"\")\n\t\t\t\t\t\t\telab=\" \"\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(evalu!=null || evalu!=\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tevalu=\":\"+evalu             \n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'4\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<script>\n\tparent.frames[1].document.forms[0].cuurfslocn.disabled = true;\n\tif (parent.frames[1].document.forms[0].file_no.type != \'hidden\')\n\tparent.frames[1].document.forms[0].file_no.disabled = true;\n\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t<script>\n\t\t\t\t\t\t\t//alert(\"File is in transit so cannot proceed\");\n\t\t\tvar msg=\"\";\n\t\t\t msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"); \t\t\t\t\t\n\t\t\talert(msg);\n\tparent.frames[1].document.forms[0].search.disabled=false;\n\tparent.frames[1].document.forms[0].encounter_id.disabled=false;\n\tparent.frames[1].document.forms[0].pat_search.disabled=false;\n\tparent.frames[1].document.forms[0].encounter_id_search.disabled=false;\n\tparent.frames[1].document.forms[0].volume_no.disabled=false;\n\tparent.frames[1].document.forms[0].patient_id.disabled=false;\n\tif (parent.frames[1].document.forms[0].file_type_appl_yn.value == \"N\")\n\t\t\t{\n\tparent.frames[1].document.forms[0].file_no.disabled\t\t=\tfalse;\n\tparent.frames[1].document.forms[0].file_no.value=\"\";\t\t\n\t\t\t}\n\telse if (parent.frames[1].document.forms[0].file_type_appl_yn.value == \"Y\")\n\t\t\t{\n\t   parent.frames[1].document.forms[0].file_type_code.disabled\t=\tfalse;\n\t\tparent.frames[1].document.forms[0].file_type_code.value=\"\";\n\t\t\t}\t\n\t\t\n\t\t\n\t\tparent.frames[1].document.forms[0].cuurfslocn.disabled\t=\tfalse;\n\t\tparent.frames[1].document.forms[0].patient_id.value=\"\";\t\n\t\tparent.frames[1].document.forms[0].patient_id.onblur();\n\t\t//parent.frames[1].document.forms[0].volume_no.value=\"\";\n\t\tparent.frames[1].document.forms[0].encounter_id.value=\"\";\n\t\tparent.deficiency_result.location.href = \'../../eCommon/html/blank.html\';\n\t\tparent.deficiency_detail.location.href = \'../../eCommon/html/blank.html\';\n\t\tparent.deficiency_detail_add.location.href = \'../../eCommon/html/blank.html\';\n\n\t\t\t\n\t\t\t</script>\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<input type=\'hidden\' name=\'DisplyDetail\' id=\'DisplyDetail\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'pateint_id\' id=\'pateint_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n</table>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n</table>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<script>\n\tparent.frames[1].document.forms[0].search.disabled=false;\n\tparent.frames[1].document.forms[0].encounter_id.disabled=false;\n\tparent.frames[1].document.forms[0].pat_search.disabled=false;\n\tparent.frames[1].document.forms[0].encounter_id_search.disabled=false;\n\tparent.frames[1].document.forms[0].volume_no.disabled=false;\n\tparent.frames[1].document.forms[0].patient_id.disabled=false;\n\tif (parent.frames[1].document.forms[0].file_type_appl_yn.value == \"N\")\n\t\tparent.frames[1].document.forms[0].file_no.disabled\t\t=\tfalse;\n\telse if (parent.frames[1].document.forms[0].file_type_appl_yn.value == \"Y\")\n\t\tparent.frames[1].document.forms[0].file_type_code.disabled\t=\tfalse;\n\t</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</form>\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            webbeans.eFM.FileDeficiencyMonitoring recordSetDeficiency= null;synchronized(session){
                recordSetDeficiency=(webbeans.eFM.FileDeficiencyMonitoring)pageContext.getAttribute("recordSetDeficiency",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSetDeficiency==null){
                    recordSetDeficiency=new webbeans.eFM.FileDeficiencyMonitoring();
                    pageContext.setAttribute("recordSetDeficiency",recordSetDeficiency,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String PatientId		= request.getParameter("PatientID");	


	String FileNo			= request.getParameter("FileNo");	
	String enc_id = request.getParameter("EncounterID");	

	String file_type_code	= request.getParameter("file_type_code");	
	String volume_no		= request.getParameter("volume_no");	

	file_type_code			= ((file_type_code==null)||(file_type_code.equals("null"))) ? "" : file_type_code;
	volume_no				= ((volume_no==null)||(volume_no.equals("null"))) ? "" : volume_no;
	if(PatientId==null)PatientId="";
	if(FileNo==null) FileNo="";
	if(enc_id==null) enc_id="";
	String QuerySql = "";
    String file_type_appl_yn="Y";
	int row_count=0;
	file_type_appl_yn=request.getParameter("file_type_appl_yn");	
	if(file_type_appl_yn==null) file_type_appl_yn="Y";
	String curr_fs_locn_code=request.getParameter("curr_fs_locn_code");	
	if(curr_fs_locn_code==null) curr_fs_locn_code="";
	StringBuffer SelectSqlBuffer	= null;
	StringBuffer SelectSqlBuffer1	= null;
	SelectSqlBuffer					= new StringBuffer();
	SelectSqlBuffer1				= new StringBuffer();

            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	PreparedStatement pstmt2	= null;
	PreparedStatement pstmt3	= null;
	ResultSet rs				= null;
	ResultSet rset				= null;


	PreparedStatement pstmt4		= null;
	ResultSet rs1				= null;



	String facility_id	= (String) session.getValue("facility_id");

	//String sql					= "";
	//String attbCheck			= "";
	String EncounterId			= "";
	String patline				= "";
	String admndate				= "";
	String discdate				= "";
	String carelocn				= "";
	String compstatus			= "";
	String name					= "",id="",en="",pr="";
	String discharge_type		= "", specialty_desc = "", practitioner_name = "";
	String patient_class		= "";
	String disply_detail		= "N";
	String curr_file_status="";
    //String curr_file_status		= "";
     boolean  flag=true;
	HashMap		htRecord		=	null;

	String 	sql1    ="";
	String   sql2    ="";
	int count       =0;
   int count1      =0;

	int found		= 0;
	//int reccount	= 0;
	int i			= 1;
	int rowid		= 1;

	try
	{

	recordSetDeficiency.clearAll();
			
   if(PatientId == null || PatientId.equals("null") || PatientId.equals(""))
		{
			PatientId = "";
			
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{
      if(!file_type_code.equals("") && file_type_appl_yn.equals("Y"))
		{
		pstmt4 = conn.prepareStatement("SELECT curr_file_status FROM fm_curr_locn where facility_id ='"+facility_id+"' AND file_type_code ='"+file_type_code+"' AND volume_no='"+volume_no	+"' and patient_id ='"+PatientId+"'");
		}
		
		if(!FileNo.equals("") && file_type_appl_yn.equals("N"))
		{
		pstmt4 = conn.prepareStatement("SELECT curr_file_status FROM fm_curr_locn where facility_id ='"+facility_id+"' AND file_no ='"+FileNo+"' AND volume_no='"+volume_no	+"' and patient_id ='"+PatientId+"'");
		}
		rs1 = pstmt4.executeQuery();
		if(rs1 != null && rs1.next())
		{
			curr_file_status = rs1.getString(1);
		}
		if(curr_file_status==null) curr_file_status="";
		if(curr_file_status.equals("T") || curr_file_status.equals("L"))
		{
		flag=false;
		
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
	    	if(rs1!=null)	rs1.close();
			if(pstmt4!=null) pstmt4.close();
		
			if(flag)
		    { 
			sql1="select encounter_id from pr_encounter where facility_id ='"+facility_id+"' and patient_id='"+PatientId+"' and encounter_id='"+enc_id+"'";

			pstmt4 = conn.prepareStatement(sql1);
			rs1 = pstmt4.executeQuery();

		if(rs1 != null && rs1.next())
		{
			count ++;
				}
		   if(rs1!=null)	rs1.close();
			if(pstmt4!=null) pstmt4.close();
		
		if(!curr_fs_locn_code.equals(""))
				{
		 if(!file_type_code.equals("") && file_type_appl_yn.equals("Y"))
		  {
		
		sql2="select curr_fs_locn_code  from fm_curr_locn where facility_id ='"+facility_id+"' and patient_id='"+PatientId+"' AND file_type_code ='"+file_type_code+"' AND volume_no='"+volume_no	+"' and curr_fs_locn_code='"+curr_fs_locn_code+"' ";
		}
			
		if(!FileNo.equals("") && file_type_appl_yn.equals("N"))
		{
	sql2="select curr_fs_locn_code  from fm_curr_locn where facility_id ='"+facility_id+"' and patient_id='"+PatientId+"' AND file_no ='"+FileNo+"' AND volume_no='"+volume_no	+"' and curr_fs_locn_code='"+curr_fs_locn_code+"'   ";
		
		}	
			
			
			pstmt4 = conn.prepareStatement(sql2);
				
			rs1 = pstmt4.executeQuery();

		if(rs1 != null && rs1.next())
		{
			count1 ++;
				}
			
			if(count1==0)
					{
              count=0;
					}else{

					}
							
				}
			
			if(count >0)
			{
				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  A.ENCOUNTER_ID" );
				SelectSqlBuffer.append("  , Get_Patient.Get_line_detail('"+facility_id+"','"+enc_id+"','"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ADMN_DATE" );
				SelectSqlBuffer.append("  , A.ASSIGN_CARE_LOCN_CODE" );
				
				SelectSqlBuffer.append(" , A.DISPOSITION_TYPE,DECODE (A.PATIENT_CLASS,'IP', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+localeName+"','2') ,'DC', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+localeName+"','2') , AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,'"+localeName+"','2') ) DISPOSITION_TYPE_DESC "); // added for ML-MMOH-SCF-0715
				
				
				SelectSqlBuffer.append("  , TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY hh24:mi') DISC_DATE" );
				SelectSqlBuffer.append("  , am_get_desc.AM_SPECIALITY(A.SPECIALTY_CODE,'"+localeName+"',2 ) SPECIALTY_DESC" );
				SelectSqlBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') PRACTITIONER_NAME" );
				SelectSqlBuffer.append("  , A.PATIENT_CLASS " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  PR_ENCOUNTER A " );
				SelectSqlBuffer.append("WHERE A.FACILITY_ID = '"+facility_id+"' " );
				SelectSqlBuffer.append("  AND A.ENCOUNTER_ID = '"+enc_id+ "'" );
			    SelectSqlBuffer.append("  AND A.PATIENT_ID = '"+PatientId+"' " );
				SelectSqlBuffer.append("  AND A.DISCHARGE_DATE_TIME IS NOT NULL" );
				
				pstmt1 = conn.prepareStatement(SelectSqlBuffer.toString());
				rs = pstmt1.executeQuery();
				if(rs != null && rs.next())
				{
					EncounterId = rs.getString("ENCOUNTER_ID");
					patline = rs.getString("PLINE");
					String strToken = "|";
					StringTokenizer token=new StringTokenizer(patline,strToken);
					while(token.hasMoreTokens())
					{
						name=token.nextToken();
						id=token.nextToken();
						
						en=token.nextToken();
						pr=token.nextToken();
					}

					admndate = rs.getString("ADMN_DATE");
				if(admndate != null)
				{
					admndate=DateUtils.convertDate(admndate,"DMYHM","en",localeName);
				}
				else
					admndate="";

					discdate = rs.getString("DISC_DATE");

				if(discdate != null)
				{
					discdate=DateUtils.convertDate(discdate,"DMYHM","en",localeName);
				}
				else
					discdate="";

				
					carelocn = rs.getString("ASSIGN_CARE_LOCN_CODE");
					patient_class = rs.getString("patient_class");
					discharge_type = rs.getString("DISPOSITION_TYPE_DESC"); // added for ML-MMOH-SCF-0715
					if (discharge_type==null) discharge_type="";
					specialty_desc = rs.getString("specialty_desc");
					if (specialty_desc==null) specialty_desc="";
					practitioner_name = rs.getString("practitioner_name");
					if (practitioner_name==null) practitioner_name="";
					
					QuerySql = "Select COUNT(*) FROM FM_DEFICIENCY_HDR WHERE FACILITY_ID = ? AND ENCOUNTER_ID = "+EncounterId+" AND FILE_NO = ? AND  VOLUME_NO = ? ";
					pstmt2 = conn.prepareStatement(QuerySql);
					pstmt2.setString(1,facility_id);
					pstmt2.setString(2,FileNo);
					pstmt2.setString(3,volume_no);
					rset = pstmt2.executeQuery();
					if(rset != null && rset.next())
					{
						found = rset.getInt(1);
					}
					if(rset!=null)	rset.close();
					if(pstmt2!=null) pstmt2.close();

					if(found > 0)
					{
						//attbCheck = "CHECKED";
						compstatus = "&nbsp;";
					}
					else
					{
						compstatus = "&nbsp;";
						disply_detail = "Y";
					}
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pr));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(PatientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block16Bytes, _wl_block16);

					
					
					out.println("<tr><td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiondate.label","common_labels")+" :</td>");
					out.println("<td class='data' width='25%'><b>"+admndate+"</td>");
					out.println("<td class='label' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedate.label","common_labels")+" :</td>");
					out.println("<td class='data' width='25%'><b>"+discdate+"</td></tr>");
					out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+" :</td>");
					out.println("<td class='data'><b>"+practitioner_name+"</td>");
					out.println("<td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" :</td>");
					out.println("<td class='data'><b>"+specialty_desc+"</b></td></tr>");
					out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargetype.label","common_labels")+" :</td>");
					out.println("<td class='data'><b>"+discharge_type+"</td>");
					out.println("<td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.EncounterDeficiencyStatus.label","fm_labels")+" :</td>");
					out.println("<td class='data' id='completed_status'><b>"+compstatus+"</b></td></tr>");

            _bw.write(_wl_block17Bytes, _wl_block17);
			i++;
			rowid++;

		 	




			/*SelectSqlBuffer1.append("Select A.FACILITY_ID, A.ENCOUNTER_ID, A.FILE_NO,");
			SelectSqlBuffer1.append("TO_CHAR(A.ADMISSION_DATE,'DD/MM/YYYY hh24:mi') ADMN_DATE,");
			SelectSqlBuffer1.append("TO_CHAR(A.DISCHARGE_DATE,'DD/MM/YYYY hh24:mi') DISC_DATE,");
			SelectSqlBuffer1.append("A.ASSIGN_CARE_LOCN_CODE,");
			SelectSqlBuffer1.append("A.DEFICIENCY_STATUS DEFICIENCY_COMPLETED_STATUS,B.DEFICIENCY_CODE,");
			SelectSqlBuffer1.append("B.RESP_PRACTITIONER_ID,");
			SelectSqlBuffer1.append("TO_CHAR(B.REPORTED_DATE,'DD/MM/YYYY hh24:mi') REP_DATE,");
			SelectSqlBuffer1.append("B.DEFICIENCY_STATUS,");
			SelectSqlBuffer1.append("TO_CHAR(B.RESOLVED_DATE,'DD/MM/YYYY hh24:mi') RES_DATE,");
			SelectSqlBuffer1.append("B.REMARKS, C.SHORT_DESC, D.PRACTITIONER_NAME SHORT_NAME,");
			SelectSqlBuffer1.append("A.FILE_TYPE, A.VOLUME_NO, A.PATIENT_CLASS, A.PATIENT_ID ");
			SelectSqlBuffer1.append("From FM_DEFICIENCY_HDR A, FM_DEFICIENCY_DTL B, FM_DEFICIENCY C,");
			SelectSqlBuffer1.append("AM_PRACTITIONER D Where A.FACILITY_ID = '"+facility_id+"' ");
			SelectSqlBuffer1.append("AND A.ENCOUNTER_ID = "+EncounterId+" ");
			
			if (!FileNo.equals(""))
				SelectSqlBuffer1.append(" AND A.FILE_NO = '"+FileNo+"' ");
			if (!file_type_code.equals(""))
				SelectSqlBuffer1.append(" AND A.FILE_TYPE = '"+file_type_code+"' ");
			if (!volume_no.equals(""))
				SelectSqlBuffer1.append("AND A.VOLUME_NO = '"+volume_no+"' ");
			
			SelectSqlBuffer1.append("AND A.FACILITY_ID = B.FACILITY_ID AND ");
			SelectSqlBuffer1.append("A.ENCOUNTER_ID = B.ENCOUNTER_ID AND A.FILE_NO = B.FILE_NO AND ");
			SelectSqlBuffer1.append("B.DEFICIENCY_CODE = C.DEFICIENCY_CODE AND ");
			SelectSqlBuffer1.append("B.RESP_PRACTITIONER_ID = D.PRACTITIONER_ID AND A.VOLUME_NO = B.VOLUME_NO ");*/
			
			SelectSqlBuffer1.append("SELECT" );
			SelectSqlBuffer1.append("  A.FACILITY_ID" );
			SelectSqlBuffer1.append("  , A.ENCOUNTER_ID" );
			SelectSqlBuffer1.append("  , A.FILE_NO" );
			SelectSqlBuffer1.append("  , TO_CHAR(A.ADMISSION_DATE,'DD/MM/YYYY hh24:mi') ADMN_DATE" );
			SelectSqlBuffer1.append("  , TO_CHAR(A.DISCHARGE_DATE,'DD/MM/YYYY hh24:mi') DISC_DATE" );
			SelectSqlBuffer1.append("  , A.ASSIGN_CARE_LOCN_CODE" );
			SelectSqlBuffer1.append("  , A.DEFICIENCY_STATUS DEFICIENCY_COMPLETED_STATUS" );
			SelectSqlBuffer1.append("  , B.DEFICIENCY_CODE" );
			SelectSqlBuffer1.append("  , B.RESP_PRACTITIONER_ID" );
			SelectSqlBuffer1.append("  , TO_CHAR(B.REPORTED_DATE,'DD/MM/YYYY hh24:mi') REP_DATE" );
			SelectSqlBuffer1.append("  , B.DEFICIENCY_STATUS" );
			SelectSqlBuffer1.append(" ,TO_CHAR(B.RESOLVED_DATE,'DD/MM/YYYY hh24:mi') RES_DATE ");
			SelectSqlBuffer1.append("  , B.REMARKS" );
			SelectSqlBuffer1.append("  , FM_GET_DESC.FM_DEFICIENCY(B.DEFICIENCY_CODE,'"+localeName+"','2') SHORT_DESC" );
			SelectSqlBuffer1.append("  , AM_GET_DESC.AM_PRACTITIONER(B.RESP_PRACTITIONER_ID,'"+localeName+"','1') SHORT_NAME" );
			SelectSqlBuffer1.append("  , A.FILE_TYPE" );
			SelectSqlBuffer1.append("  , A.VOLUME_NO" );
			SelectSqlBuffer1.append("  , A.PATIENT_CLASS" );
			SelectSqlBuffer1.append("  , A.PATIENT_ID " );
			SelectSqlBuffer1.append("FROM" );
			SelectSqlBuffer1.append("  FM_DEFICIENCY_HDR A" );
			SelectSqlBuffer1.append("  , FM_DEFICIENCY_DTL B " );
			SelectSqlBuffer1.append("WHERE A.FACILITY_ID = B.FACILITY_ID " );
			SelectSqlBuffer1.append("  AND A.ENCOUNTER_ID = B.ENCOUNTER_ID " );
			SelectSqlBuffer1.append("  AND A.FILE_NO = B.FILE_NO " );
			SelectSqlBuffer1.append("  AND A.VOLUME_NO = B.VOLUME_NO " );
			SelectSqlBuffer1.append("  AND A.FACILITY_ID = '"+facility_id+"' " );
			SelectSqlBuffer1.append("  AND A.ENCOUNTER_ID = "+EncounterId+" " );
			if (!FileNo.equals(""))
				SelectSqlBuffer1.append(" AND A.FILE_NO = '"+FileNo+"' ");
			if (!volume_no.equals(""))
				SelectSqlBuffer1.append("AND A.VOLUME_NO = '"+volume_no+"' ");

			pstmt3 = conn.prepareStatement(SelectSqlBuffer1.toString());
			rset = pstmt3.executeQuery();
			if(rset != null)
			{
				while(rset.next())
				{
					String resdate = rset.getString("RES_DATE");
					String rep_date = rset.getString("REP_DATE");
					String remarks = rset.getString("REMARKS");

					if(resdate != null )
					{
					resdate=DateUtils.convertDate(resdate,"DMYHM","en",localeName);
					}
					else
						resdate  = "";
					if(rep_date != null )
					{
					rep_date=DateUtils.convertDate(rep_date,"DMYHM","en",localeName);
					}
					else
						rep_date  = "";
					
					if(remarks == null || remarks.equals("null"))	remarks  = "";

					htRecord	=	new HashMap();

					htRecord.put (	"facility_id",rset.getString("FACILITY_ID")==null?"":rset.getString("FACILITY_ID"));
					htRecord.put (	"encounter_id",		rset.getString("ENCOUNTER_ID")==null?"":rset.getString("ENCOUNTER_ID")	);
					htRecord.put (	"file_no",			rset.getString("FILE_NO")==null?"":rset.getString("FILE_NO"));
					htRecord.put (	"file_type",		file_type_code);
					htRecord.put (	"volume_no",		volume_no	);
					htRecord.put (	"patient_class",	patient_class);
					htRecord.put (	"PatientId",	PatientId);
					htRecord.put (	"defi_code",		rset.getString("DEFICIENCY_CODE")==null?"":rset.getString("DEFICIENCY_CODE")	);
					htRecord.put (	"defi_desc",		rset.getString("SHORT_DESC")==null?"":rset.getString("SHORT_DESC")	);
					htRecord.put (	"admission_date",	rset.getString("ADMN_DATE")==null?"":rset.getString("ADMN_DATE")	);
					htRecord.put (	"discharge_date",	rset.getString("DISC_DATE")==null?"":rset.getString("DISC_DATE"));
					htRecord.put (	"care_locn_code",	rset.getString("ASSIGN_CARE_LOCN_CODE")==null?"":rset.getString("ASSIGN_CARE_LOCN_CODE"));
					htRecord.put (	"defi_completed_status",  rset.getString("DEFICIENCY_COMPLETED_STATUS")==null?"":rset.getString("DEFICIENCY_COMPLETED_STATUS"));
					htRecord.put (	"practitioner",			rset.getString("RESP_PRACTITIONER_ID")==null?"":rset.getString("RESP_PRACTITIONER_ID")	);
					htRecord.put (	"practitioner_name",	rset.getString("SHORT_NAME")==null?"":rset.getString("SHORT_NAME")	);
					htRecord.put (	"defi_reported_date",	rep_date);
					htRecord.put (	"defi_status",			rset.getString("DEFICIENCY_STATUS")==null?"":rset.getString("DEFICIENCY_STATUS")	);
					htRecord.put (	"defi_resolved_date",	resdate	);
					htRecord.put (	"defi_remarks",	remarks );
					htRecord.put (	"item_delete_yn",		"N"	);
					htRecord.put (	"header_exist",			"1" );
					htRecord.put (	"operation_mode",		"Modify" );
					htRecord.put (	"record_from",			"DATABASE" );

					recordSetDeficiency.putObject(htRecord);
	
					if(rset.getString("DEFICIENCY_STATUS").equals("O"))
						disply_detail = "Y";
					}
				row_count	=recordSetDeficiency.getSize();
				session.removeAttribute("row_count");
				session.setAttribute("row_count",row_count);
				}
			}  // end of rs.next()
			else
			{
				out.println("<script> var errors = getMessage('PATIENT_NOT_DISCHARGED','FM');	parent.frames[5].document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors; </script>");
			}
			}else
			{
				if(curr_fs_locn_code.equals(""))
				{
				out.println("<script> var errors = getMessage('PATIENT_IS_NOT_INPATIENT','FM');	parent.frames[5].document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors; </script>");
				}else{
		
		
            _bw.write(_wl_block18Bytes, _wl_block18);
		
				}
		
		}


	//	}  // end of rowcount if
	}  // end of PatientId if
	
		
	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
	if((SelectSqlBuffer1 != null) && (SelectSqlBuffer1.length() > 0))
	{
		SelectSqlBuffer1.delete(0,SelectSqlBuffer1.length());
	}
if(rs!=null)	 rs.close();
if(rset!=null)	 rset.close();
if(pstmt!=null)  pstmt.close();
if(pstmt1!=null) pstmt1.close();
if(pstmt2!=null) pstmt2.close();
if(pstmt3!=null) pstmt3.close();
if(rs1!=null)	rs1.close();
if(pstmt4!=null) pstmt4.close();

		}
	}
	
	catch(Exception e){
	out.println("Exception e1 :"+e);
	e.printStackTrace();
	}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}
if(flag)
{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disply_detail));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	
	
	if (i > 1)
	{															out.println("<script>OnSelection('"+EncounterId+"','"+FileNo+"','"+PatientId+"','"+admndate+"','"+discdate+"','"+found+"','"+carelocn+"', '"+file_type_code+"', '"+volume_no+"','"+row_count+"');</script>");
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	}
	else
	{
		out.println("<script>parent.frames[3].location.href = '../../eCommon/html/blank.html';");
		out.println("parent.frames[4].location.href = '../../eCommon/html/blank.html';</script>");
			
            _bw.write(_wl_block23Bytes, _wl_block23);

	}
}

            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Deficiencies.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
