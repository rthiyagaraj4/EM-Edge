package jsp_servlet._edr._jsp;

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
import webbeans.*;
import eDR.*;
import java.io.*;
import eCommon.Common.*;

public final class __validatepopulatepatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/ValidatePopulatePatient.jsp", 1742360217015L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\tdocument.forms[0].search.disabled = false;\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num= \';\n\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\tdocument.forms[0].patient_id.select();\n\t\t\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\t\t\tdocument.getElementById(\'pat_name\').innerHTML=\'\'; \n\t\t\t\t\t\tvar ErrorText = getMessage(\'EXCLUDE_DUPLICATE_RECORD\',\'DR\');\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t\t\t\t \n\t\t\t\t\t if(document.forms[0].p_flag_value.value==\"N\")\n\t\t\t\t\t\t\t {\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tdocument.forms[0].patient_id.select();\n\t\t\t\t\t\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'pat_name\').innerHTML=\'\'; \n\t\t\t\t\t\t\t\t\tvar ErrorText = getMessage(\'ONLY_ONE_INPATIENT\',\'DR\');\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\t\t\t\t\t \n\t\t\t\t\t\t\t }\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'p_patient_line\').value = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"\n\t\t\t\t\t\t\t\t\tdocument.forms[0].p_flag_value.value=\"N\";\t\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\'pat_name\').innerHTML = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\n\t\t\t\t\t\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t\t\t\t\t\t\tdocument.forms[0].dup_ind.focus();\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t  }\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n                document.forms[0].patient_id.select();\n\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\tdocument.getElementById(\'pat_name\').innerHTML=\'\'; \n\t\t\t\tvar error= getMessage(\'PAT_DECEASED_NOT_ALLOWED\',\'MP\');\n\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\n\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n                 document.forms[0].patient_id.select();\n\t\t\t\t document.forms[0].patient_id.focus();\n\t\t\t\t document.getElementById(\'pat_name\').innerHTML=\'\'; \n\t\t\t\t var error= getMessage(\'PAT_SUSPENDED_NOT_ALLOWED\',\'MP\');\n\t\t\t\t parent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\n\n\t\t\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n                 document.forms[0].patient_id.select();\n\t\t\t\t document.forms[0].patient_id.focus();\n\t\t\t\t document.getElementById(\'pat_name\').innerHTML=\'\'; \n\t\t\t\t var error= getMessage(\'PAT_INACTIVE_NOT_ALLOWED\',\'MP\'); parent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t    document.getElementById(\'pat_name\').innerHTML = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t\tdocument.forms[0].dup_ind.focus();\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' != \'\') \n\t\t\t\t\tdocument.getElementById(\'pat_name1\').innerHTML=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' != \'\') \n\t\t\t\t\tdocument.getElementById(\'pat_name2\').innerHTML=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"\n\n\t\t\t//\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t   var error= getMessage( \"PATIENT_MERGED_VALID\",\"MP\");\n\t\t\t   error = error.replace(\"#\",\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\");\t\n\t\t\t    if(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' != \'\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\t\t\n\t\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\t} else if(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' != \'\')\t{  \n\t\t\t\t\tdocument.forms[0].patient_id1.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\t\t\n\t\t\t\t\tdocument.forms[0].patient_id1.focus();\n\t\t\t\t} else \tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' != \'\') {  \n\t\t\t\t\tdocument.forms[0].patient_id2.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\t\t\n\t\t\t\t\tdocument.forms[0].patient_id2.focus();\n\t\t\t\t} \n\t\t\t\tif(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'==\'ENTER_DUPLICATES1\') \n\t\t\t\t{ \t\t\t\t\n\t\t\t\t\tdocument.forms[0].patient_id1.value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\tdocument.forms[0].patient_id1.focus();\t\t\t\n\t\t\t\t}\n\t\t\t\talert(error);\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' != \'\')\n\t\t\t\t{\n\t\t\t\t\tdocument.forms[0].patient_id.select();\t\n\t\t\t\t\tdocument.forms[0].patient_id.focus();\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'==\'EXCLUDE_DUPLICATES1\') \n\t\t\t\t\t{ \t\n\t\t\t\t\t\tdocument.getElementById(\'pat_name1\').innerHTML=\'\';\n\t\t\t\t\t} else {\n\t\t\t\t\t\tdocument.getElementById(\'pat_name\').innerHTML=\'\';\t\n\t\t\t\t\t}\n\t\t\t\t\tvar errText = getMessage(\'INVALID_PAT\',\'DR\');\t\t\t\t\t\n\t\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errText;\n\t\t\t\t} else \tif(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' != \'\') { \t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].patient_id1.select();\n\t\t\t\t\tdocument.forms[0].patient_id1.focus();\n\t\t\t\t\tdocument.getElementById(\'pat_name1\').innerHTML=\'\';\n\t\t\t\t\tvar errText = getMessage(\'INVALID_PAT\',\'DR\');\t\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errText;\n\t\t\t\t} else \tif(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' != \'\') { \t\t\t\t\t\n\t\t\t\t\tdocument.forms[0].patient_id2.select();\n\t\t\t\t\tdocument.forms[0].patient_id2.focus();\n\t\t\t\t\tdocument.getElementById(\'pat_name2\').innerHTML=\'\';\n\t\t\t\t\tvar errText = getMessage(\'INVALID_PAT\',\'DR\');\t\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errText;\n\t\t\t\t} \t\n\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'==\'ENTER_DUPLICATES1\') \n\t\t\t\t{\n\t\t\t\t\n\t\t\t\t\tdocument.forms[0].patient_id1.select();\n\t\t\t\t\tdocument.forms[0].patient_id1.focus();\n\t\t\t\t\tdocument.forms[0].search.disabled=true;\n\t\t\t\t\tvar errText = getMessage(\'INVALID_PAT\',\'DR\');\n\t\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+errText;\n\t\t\t\t\n\t\t\t\t} \n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
    webbeans.op.PatientData patdata = new webbeans.op.PatientData();
   	Hashtable hash	= (Hashtable) obj.parseXMLString(request);
 	hash			= (Hashtable) hash.get("SEARCH");
    	 
	String patient_id	= (String) hash.get("Patient_ID");
	String patient_id9	= (String) hash.get("Patient_ID9");
	String patient_id1	= (String) hash.get("Patient_ID1");
	String patient_id2	= (String) hash.get("Patient_ID2");
	String function_id	= (String) hash.get("function_id");	
	String step			= (String)hash.get("step");
    String locale=(String)session.getAttribute("LOCALE");	
	String facility_id			 = (String)session.getValue("facility_id");
	if (patient_id == null || patient_id == "undefined") patient_id = "";
	if (step == null || step == "undefined") step = "";
	if (patient_id9 == null || patient_id9 == "undefined") patient_id9 = "";
	if (patient_id1 == null || patient_id1 == "undefined") patient_id1 = "";
	if (patient_id2 == null || patient_id2 == "undefined") patient_id2 = "";
 	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	int cntPat = 0;

	String p_patient_line = "";
	String pat_id = "";

	//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	Boolean isMergeDeceasedPatIdAppl = false; 
		
	try
	{
		con		= ConnectionManager.getConnection(request);

		isMergeDeceasedPatIdAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"DR","MERGE_DECEASED_PATIENTID");//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
		
		pstmt	= con.prepareStatement("select count(1) from mp_patient where patient_id = ?");

		if(function_id.equals("ENTER_DUPLICATES1"))
		{
			pstmt.setString(1, patient_id9);
		}

		if(function_id.equals("ENTER_DUPLICATES") || function_id.equals("EXCLUDE_DUPLICATES1"))
		{
			pstmt.setString(1, patient_id);
		}
		else
		{
			if(!patient_id1.equals("")) 
			{
				pstmt.setString(1, patient_id1);
			}
			else if(!patient_id2.equals("")) 
			{
				pstmt.setString(1, patient_id2);
			}
		}

		rs = pstmt.executeQuery();
		if(rs != null) 
		{
			if(rs.next()) 
			{
				cntPat = rs.getInt(1);
			}
		} 
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(cntPat > 0)
		{
			if(!patient_id9.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id9,con,locale);
			}
			if(!patient_id.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id,con,locale);
			}
			else if(!patient_id1.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id1,con,locale);
			}
			else if(!patient_id2.equals(""))
			{
				demography d	= new demography();
				p_patient_line	= d.name_age_sex(session ,patient_id2,con,locale);
			}
			if(function_id.equals("ENTER_DUPLICATES1") && step.equals("1"))
			{
				
            _bw.write(_wl_block2Bytes, _wl_block2);

			}
			else
			{

			if (function_id.equals("ENTER_DUPLICATES"))
			{
				int not_dup_cnt = 0;
				String sql = " select count(*) cnt from dr_not_dup_patients where patient_id1 = ? or patient_id2 = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, patient_id);
				pstmt.setString(2, patient_id);

				rs = pstmt.executeQuery();
				if(rs != null && rs.next()) 
				{			
					not_dup_cnt = rs.getInt("cnt");					
				} 
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				if(not_dup_cnt>0)
				{
					
            _bw.write(_wl_block3Bytes, _wl_block3);


				} else {
				
				Boolean isConOGGApplicable	= CommonBean.isSiteSpecific(con, "SM","GGS_OWNER_BKG_JOB");
				String chkst=patdata.CheckStatus(con,patient_id);
				String patstatus = "";
				if(isConOGGApplicable){

						String sqlFn = " select ip_open_check(?) from dual";
						String result = "";
						pstmt = con.prepareStatement(sqlFn);
						pstmt.setString(1, patient_id);

						rs = pstmt.executeQuery();
						if(rs != null && rs.next()){			
							result = rs.getString(1);				
						} 
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(result.equals("Y")){
							patstatus = "CURRENTLY_IN_PATIENT";
						}
						
				}else{
					patstatus=patdata.CheckInPatient(con,patient_id,facility_id);
				}
				
				
				if(patstatus.equals("CURRENTLY_IN_PATIENT")) 
					{					
					
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block6Bytes, _wl_block6);
}

				//Modified by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
				else if(chkst.equals("DECEASED") && !isMergeDeceasedPatIdAppl) 
			    {
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(chkst.equals("SUSPENDED")){
            _bw.write(_wl_block8Bytes, _wl_block8);
}else if(chkst.equals("INACTIVE")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else {
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
				}
			} else if(function_id.equals("EXCLUDE_DUPLICATES1"))
			{ 
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
			else
			{ 
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
		}
	}
	else
	{
								
		     if(!patient_id.equals(""))
				pat_id = patient_id;
			 else if(!patient_id1.equals(""))
				pat_id = patient_id1;
			 else if(!patient_id2.equals(""))
				pat_id = patient_id2;
			 else if(!patient_id9.equals(""))
				pat_id = patient_id9; 
			 
				
		     String patientIdStatus = patdata.CheckStatus(con,pat_id);
				
			  if (patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0 )
			  {
				StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();
				   
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id2));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

					} else { 
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id2));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block33Bytes, _wl_block33);

				}
		//}
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception e :"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
