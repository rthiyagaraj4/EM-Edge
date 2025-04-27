package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __canceltransferresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CancelTransferResult.jsp", 1717740216330L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t<script>\n\n\t\t\tfunction resetValues()\n\t\t\t{\t\t\t\t\t\n\t\t\t\t\tform1 =  parent.frames[1].document.forms[0];\n\t\t\t\t\tform1.nursing_unit_lookup.disabled = false;\n\t\t\t\t\tform1.specialty_lookup.disabled = false;\n\t\t\t\t\tform1.pract_id_search.disabled = false;\n\t\t\t\t\tform1.from_date.readOnly = false;\n\t\t\t\t\tform1.to_date.readOnly = false;\n\t\t\t\t\tform1.encounter_id.readOnly = false;\n\t\t\t\t\tform1.patient_id.readOnly = false;\n\t\t\t\t\tform1.patient_search.disabled = false;\n\t\t\t\t\tform1.gender.disabled = false;\n\t\t\t\t\tform1.soundex.disabled = false;\n\t\t\t\t\tform1.search.disabled = false;\n\t\t\t\t\tform1.clear.disabled = false;\n\t\t\t}\n\n\t\t\tfunction closeWin(enc,patid,changefunc)\n\t\t\t{\n\t\t\t\tshowModalCurEnc(enc,patid,changefunc);\n\t\t\t}\n\t\t\tvar locn;\n\t\t\t\n\t\t\tasync function showModal(enc,patid,practid,IPval,sex,pract_count,srlNo,country)\n\t\t\t{\t\n\t\t\t\tvar chk_jsp=document.forms[0].jsp_name.value;\n\t\t\t\tvar tot_count=document.forms[0].total_count.value;\n\t\t\t\tif( document.forms[0].modal.value != \'yes\')\n\t\t\t\t    {\t\t\t\t\t\t\n\t\t\t\t\t\tvar jsp_name=document.forms[0].jsp_name.value;\n\t\t\t\t\t\tvar win_height=document.forms[0].win_height.value;\n\t\t\t\t\t\tif(win_height == \"\") win_height=\"33.4\";\n\t\t\t\t\t\tvar dialogTop=document.forms[0].dialogTop.value;\n\t\t\t\t\t\tif(dialogTop == \"\") dialogTop=\"65\";\n\t\t\t\t\t\tvar win_width=document.forms[0].win_width.value;\n\t\t\t\t\t\tif(win_width == \"\") win_width=\"40\";\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar model_window=document.forms[0].model_window.value;\n\t\t\t\t\t\tif( model_window == \"\") model_window =\"\";\t\t\t\t\t\t\n\t\t\t\t\t\tif( model_window == \'NO\')\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\tparent.parent.frames[1].document.location.href=\"../../eIP/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&srlno=\"+srlNo+\"&country=\"+country+\"&Sex=\"+sex;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if( model_window == \'N\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[3].document.location.href=\"../../eIP/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&srlno=\"+srlNo+\"&country=\"+country+\"&Sex=\"+sex;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse \n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar retVal = \tnew String();\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar dialogHeight= win_height;\n\t\t\t\t\t\t\t\tvar dialogWidth\t= \"49.6\";\n\t\t\t\t\t\t\t\tvar dialogTop = dialogTop;\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar center = \"1\" ;\n\t\t\t\t\t\t\t\tvar status=\"no\";\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\t\t\tretVal = \tawait window.showModalDialog(\"../../eIP/jsp/\"+jsp_name+\"?location_code=\"+IPval+\"&encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&srlno=\"+srlNo+\"&country=\"+country+\"&Sex=\"+sex+\"&mode=modal\",arguments,features);\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\t}\n\t\t\t}\n\t\t\tasync function showModalCurEnc(enc,patid,changefunc)\n\t\t\t{\t\t\t\t\n\t\t\t\tvar call_function = document.forms[0].call_function.value;\n\t\t\t\tvar jsp_name=\"CurrentEncounterMain.jsp\";\n\t\t\t\tvar win_height=document.forms[0].win_height.value;\n\t\t\t\tif(win_height == \"\") win_height=\"33.4\";\n\t\t\t\tvar win_width=document.forms[0].win_width.value;\n\t\t\t\tif(win_width == \"\") win_width=\"49.8\";\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= win_height ;\n\t\t\t\tvar dialogWidth\t= win_width ;\n\t\t\t\tvar dialogTop = \"65\" ;\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&call_function=\"+call_function+\"&patientId=\"+patid,arguments,features);\n\t\t\t\tif(retVal!=null && retVal!=\'\')\n\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t}\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\'>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\tresetValues();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\t\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\t\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}


	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;

	String facility_id = (String)session.getValue("facility_id");
	if( facility_id == null) facility_id="";
	String login_user = (String)session.getValue("login_user");
	if( login_user == null) login_user="";
	String responsibility_id = (String)session.getValue("responsibility_id");
	if( responsibility_id == null) responsibility_id="";
	
	String oper_stn_id = "";
try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();

            _bw.write(_wl_block6Bytes, _wl_block6);

			String call_function =request.getParameter("param");
			if( call_function == null) call_function="";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block11Bytes, _wl_block11);

			try{
			String nurs_unit_code	="";
			StringBuffer where_criteria = new StringBuffer();
			String sql = "";
			String class_val = "QRYEVEN";
			String whereClause = request.getParameter("whereclause");
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			
			String soundex_type			=request.getParameter("soundex");
			String no_of_days			=request.getParameter("no_of_days");
			if(no_of_days == null)   no_of_days = "";

			String nursing_unit_code	="";
			nursing_unit_code=request.getParameter("nursing_unit");
			if( nursing_unit_code == null) nursing_unit_code="";
			String speciality_code		=request.getParameter("Splcode");
			String encounter_id			=request.getParameter("encounter_id");
			String practitioner_id			=request.getParameter("practid");
			String from_date					=request.getParameter("from_date");
			String to_date						=request.getParameter("to_date");
			String patient_id					=request.getParameter("patient_id");
			String gender					=request.getParameter("gender");
			String name_prefix				=request.getParameter("name_prefix");
			String name_suffix				=request.getParameter("name_suffix");
			String first_name				=request.getParameter("first_name");
			String second_name				=request.getParameter("second_name");
			String third_name				=request.getParameter("third_name");
			String family_name				=request.getParameter("family_name");

			String strSerialNumber = "";	
			String strCountry = "";
			String patient_name	="";
			String nursing_unit_short_desc="";
			String bed_no="";			
			String specialty_short_desc="";
			String practitioner_name="";
			String prev_val="";
			String prev_val2="";
			String Sex="";
			String admission_date_time="";
			String discharge_date_time= "";		

				if(name_prefix == null) name_prefix = "";
				if(name_suffix == null) name_suffix = "";
				if(nursing_unit_code == null) nursing_unit_code = "";
				if(speciality_code == null) speciality_code = "";
				if(practitioner_id == null) practitioner_id = "";
				name_prefix=singleToDoubleQuotes(name_prefix);
				name_suffix=singleToDoubleQuotes(name_suffix);
				nursing_unit_code=singleToDoubleQuotes(nursing_unit_code);
				speciality_code=singleToDoubleQuotes(speciality_code);
				practitioner_id=singleToDoubleQuotes(practitioner_id);				
	
			String jsp_name =request.getParameter("jsp_name");
			if( jsp_name == null) jsp_name="";
			String window_styl=request.getParameter("window_styl");
			if( window_styl == null) window_styl="";
			String close_yn	=request.getParameter("close_yn");
			if( close_yn == null) close_yn="";
			String win_top =request.getParameter("win_top");
			if( win_top == null) win_top="";
			String win_height =request.getParameter("win_height");
			if(win_height ==null) win_height="";

			String dialogTop =request.getParameter("dialogTop");
			if(dialogTop ==null) dialogTop="";

			String win_width =request.getParameter("win_width");
			if( win_width == null) win_width="";

			String modal=request.getParameter("modal");
			if(modal == null) modal="";		

			String model_window=request.getParameter("model_window");
			if( model_window == null) model_window="";			

			String p_practitioner_id=request.getParameter("practitioner_id");
			if( p_practitioner_id == null) p_practitioner_id="";

			String call_func=request.getParameter("call_function");
			if(call_func == null) call_func="";
			
			String count_practitioner = "";
			
	
            _bw.write(_wl_block12Bytes, _wl_block12);

				 

				
				
				String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facility_id+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+login_user+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ";
				
	 rs = stmt.executeQuery(operSql);
				
    while(rs.next())
    {
		  oper_stn_id = rs.getString("OPER_STN_ID");
	}
if(oper_stn_id == null) oper_stn_id = "";




				if(whereClause==null)
				{
					//facility_id
					where_criteria.append(" where  A.facility_id ='"+facility_id+"'");
					//nursing_unit_code	
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					where_criteria.append(" and A.to_nursing_unit ='"+nursing_unit_code+"' ");
					else
							where_criteria.append(" and (A.to_nursing_unit in (Select n.nursing_unit_code from ip_nursing_unit n, am_os_user_locn_access_vw b where n.facility_id='"+facility_id+"' and n.facility_id=b.facility_id and n.nursing_unit_code=b.locn_code and n.locn_type=b.locn_type and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"')  or A.to_nursing_unit is null)");
					//speciality_code
					if(speciality_code!=null && !speciality_code.equals(""))
					where_criteria.append(" and A.to_specialty_code='"+speciality_code+"' ");
					//practitioner_id
					if(p_practitioner_id!=null && !p_practitioner_id.equals(""))
					where_criteria.append(" and A.to_practitioner_id='"+practitioner_id+"' ");
					//from_date
					if(from_date!=null && !from_date.equals(""))
					where_criteria.append(" and trunc(A.trn_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
					//to_date
					if(to_date!=null && !to_date.equals(""))
					where_criteria.append(" and trunc(A.trn_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					//patient_id
					if(patient_id!=null && !patient_id.equals(""))
					where_criteria.append(" and A.patient_id like '"+patient_id+"%' ");
					//encounter_id
					if(encounter_id != null && !encounter_id.equals(""))
					where_criteria.append(" and A.encounter_id='"+encounter_id+"' ");
					//gender
					if(gender!=null && !gender.equals(""))
						where_criteria.append(" and B.sex='"+gender+"' ");			
					
					//name_prefix
					if(name_prefix!=null && !name_prefix.equals(""))
						where_criteria.append(" and B.name_prefix='"+name_prefix+"' ");

					//name_suffix
					if(name_suffix!=null && !name_suffix.equals(""))
						where_criteria.append(" and B.name_suffix='"+name_suffix+"' ");


	if(soundex_type.equals("E"))
				{
                
				//first_name
                    if(first_name!=null && !first_name.equals(""))
                        where_criteria.append(" and upper(ethnic_soundex(B.first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");

                    //second_name
                    if(second_name!=null && !second_name.equals(""))
                        where_criteria.append(" and upper(ethnic_soundex(B.second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");

                    //third_name
                    if(third_name!=null && !third_name.equals(""))
                       where_criteria.append(" and upper(ethnic_soundex(B.third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");

                    //family_name
                    if(family_name!=null && !family_name.equals(""))
                       where_criteria.append(" and upper(ethnic_soundex(B.family_name)) like upper(ethnic_soundex('" +family_name+"')) || '%' ");
				}
				else
				{
                    //first_name
                    if(first_name!=null && !first_name.equals(""))
                       where_criteria.append(" and upper(soundex(B.first_name)) like upper(soundex('" +first_name +"')) || '%' ");

                    //second_name
                    if(second_name!=null && !second_name.equals(""))
                        where_criteria.append(" and upper(soundex(B.second_name)) like upper(soundex('" + second_name +"')) || '%' ");

                    //third_name
                    if(third_name!=null && !third_name.equals(""))
                        where_criteria.append(" and upper(soundex(B.third_name)) like upper(soundex('"+ third_name+"')) || '%' ");

                    //family_name
                    if(family_name!=null && !family_name.equals(""))
                        where_criteria.append(" and upper(soundex(B.family_name)) like upper(soundex('" +family_name+"')) || '%' ");
				}

				}
				else
				{
					where_criteria.append(whereClause);
				}
				int start = 0 ;
				int end = 0 ;
				int i=1;

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
				  	end = 9 ;
				else
					end = Integer.parseInt( to ) ;
			
				//sql = "SELECT COUNT(*) FROM ip_adt_trn A,MP_PATIENT B "+where_criteria.toString()+" and A.patient_id=b.patient_id and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T' and A.adt_trn_status != '9' and A.encounter_id not in (select encounter_id from ip_discharge_advice where facility_id = '"+facility_id+"' and dis_adv_status = '0') and A.encounter_id not in (select encounter_id from ip_bed_booking WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0' AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) " ;
				
				sql = "SELECT count(*) FROM ip_adt_trn A, MP_PATIENT B, IP_NURSING_UNIT C, AM_PRACTITIONER D, AM_SPECIALITY E, mp_country F, IP_OPEN_ENCOUNTER G "+where_criteria.toString()+" and A.FACILITY_ID = G.FACILITY_ID AND A.ENCOUNTER_ID = G.ENCOUNTER_ID AND  A.patient_id=b.patient_id and A.facility_id=C.facility_id and A.to_nursing_unit = C.nursing_unit_code and A.to_practitioner_id = D.practitioner_id (+) and A.to_specialty_code = E.speciality_code  (+)  and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T' AND B.NATIONALITY_CODE = F.country_code and nvl(A.adt_trn_status,'x') !='9' AND A.encounter_id not in (select encounter_id from ip_discharge_advice T where facility_id =  '"+facility_id+"' and t.encounter_id = a.encounter_id and dis_adv_status = '0' ) and A.encounter_id not in (select encounter_id from  ip_bed_booking U WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0'  and U.ENCOUNTER_ID = A.ENCOUNTER_ID AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) group by to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') , A.trn_date_time, A.encounter_id, A.patient_id, B.patient_name, B.sex, A.to_nursing_unit, C.short_desc , A.to_practitioner_id , D.practitioner_name , E.short_desc , A.to_bed_no,F.SHORT_NAME";
				rs = stmt.executeQuery(sql);
				int maxRecord=0;
				if(rs.next())
				{
					maxRecord = rs.getInt(1);
				}
				if(stmt!=null)	stmt.close();
				if(rs!=null)		rs.close();
		
				if(maxRecord == 0)
				{
				
            _bw.write(_wl_block13Bytes, _wl_block13);

					return;
				}
		
				//sql = "SELECT to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time, A.trn_date_time datetime,A.encounter_id, A.patient_id, B.patient_name, B.sex, A.to_nursing_unit, C.short_desc to_nursing_unit_short_desc , A.to_practitioner_id , D.practitioner_name practitioner_name, E.short_desc to_specialty_short_desc, A.to_bed_no ,A.srl_no ,F.SHORT_NAME countryname FROM ip_adt_trn A,MP_PATIENT B, IP_NURSING_UNIT C,AM_PRACTITIONER D,AM_SPECIALITY E, mp_country F   "+where_criteria+" and A.patient_id=b.patient_id and A.facility_id=C.facility_id and A.to_nursing_unit = C.nursing_unit_code and A.to_practitioner_id = D.practitioner_id (+) and A.to_specialty_code = E.speciality_code (+) and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T'   AND B.NATIONALITY_CODE = F.country_code    and A.adt_trn_status !='9' and A.encounter_id not in (select encounter_id from ip_discharge_advice where facility_id = '"+facility_id+"' and dis_adv_status = '0') and A.encounter_id not in (select encounter_id from ip_bed_booking WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0' AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) Order by datetime desc ";

				sql = "SELECT to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') trn_date_time, A.trn_date_time datetime, A.encounter_id, A.patient_id, decode('"+localeName+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, B.sex, A.to_nursing_unit, C.short_desc to_nursing_unit_short_desc , A.to_practitioner_id , D.practitioner_name practitioner_name, E.short_desc to_specialty_short_desc, A.to_bed_no, max(srl_no) srl_no, F.SHORT_NAME countryname FROM ip_adt_trn A, MP_PATIENT B, IP_NURSING_UNIT C, AM_PRACTITIONER D, AM_SPECIALITY E, mp_country F, IP_OPEN_ENCOUNTER G "+where_criteria.toString()+" and A.FACILITY_ID = G.FACILITY_ID AND A.ENCOUNTER_ID = G.ENCOUNTER_ID AND  A.patient_id=b.patient_id and A.facility_id=C.facility_id and A.to_nursing_unit = C.nursing_unit_code and A.to_practitioner_id = D.practitioner_id (+) and A.to_specialty_code = E.speciality_code  (+)  and (A.encounter_id,A.srl_no) IN (SELECT X.encounter_id ,MAX(X.srl_no) FROM IP_ADT_TRN X, ip_open_encounter Y WHERE X.Facility_id = '"+facility_id+"' AND X.Trn_type = 'T' AND X.Facility_id = Y.Facility_id AND X.Encounter_id = Y.Encounter_id GROUP BY X.encounter_id ) AND A.Trn_type = 'T' AND B.NATIONALITY_CODE = F.country_code and nvl(A.adt_trn_status,'x') !='9' AND A.encounter_id not in (select encounter_id from ip_discharge_advice T where facility_id =  '"+facility_id+"' and t.encounter_id = a.encounter_id and dis_adv_status = '0' ) and A.encounter_id not in (select encounter_id from  ip_bed_booking U WHERE facility_id = '"+facility_id+"' and BOOKING_TYPE='T' AND booking_status='0' and U.ENCOUNTER_ID = A.ENCOUNTER_ID AND BLOCKED_UNTIL_DATE_TIME > SYSDATE) group by to_char(A.trn_date_time,'dd/mm/rrrr hh24:mi') , A.trn_date_time, A.encounter_id, A.patient_id, B.patient_name, B.sex, A.to_nursing_unit, C.short_desc , A.to_practitioner_id , D.practitioner_name , E.short_desc , A.to_bed_no,F.SHORT_NAME";
			  
				stmt = con.createStatement();

				rs= stmt. executeQuery(sql);
				
				if (( !(start <= 1) ) || ( !( (start+9) > maxRecord ) ))
				{
					out.println("<p><table align='right'><tr><td>");
					if ( !(start <= 1) )
						out.println("<A HREF='../jsp/CancelTransferResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+9) > maxRecord ) )
						out.println("<A HREF='../jsp/CancelTransferResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");	
				}
						out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
						out.println("<tr>");
						out.println("<th>&nbsp;</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransactionDateTime.label","ip_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</th>");
						out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</th>");
						out.println("</tr>");
				if(rs!=null)
					{
						if ( start != 1 )
						for( int j=1; j<start; i++,j++ )
						{
						rs.next() ;
						}						
						while ( rs!=null && rs.next() && i<=end ) 
						{							
														
							admission_date_time=rs.getString("trn_date_time");
							if(admission_date_time == null) admission_date_time="&nbsp;";
							
							specialty_short_desc=rs.getString("To_specialty_short_desc");
							if(specialty_short_desc == null) specialty_short_desc="&nbsp;";

							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null) encounter_id="";

							strSerialNumber = rs.getString("srl_no");
							if(strSerialNumber == null)strSerialNumber="";
							
							
							strCountry = rs.getString("countryname");
							if(strCountry == null )strCountry = "";

							Sex =rs.getString("sex");
							if( Sex == null )Sex="";

							patient_id = rs.getString("patient_id");
							if( patient_id == null) patient_id="";

							patient_name=rs.getString("patient_name");
							if(patient_name == null) patient_name="&nbsp;";

							nurs_unit_code =rs.getString("to_nursing_unit");
							if( nurs_unit_code == null) nurs_unit_code="";
							nursing_unit_short_desc=rs.getString("to_nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

							bed_no = rs.getString("to_bed_no");
							if( bed_no == null) bed_no="&nbsp;";

							practitioner_id=rs.getString("to_practitioner_id");
							if(practitioner_id == null) practitioner_id="";

							practitioner_name=rs.getString("practitioner_name");
							if(practitioner_name == null) practitioner_name="";
						
							if(class_val.equals("QRYEVEN"))
								class_val = "QRYODD";
							else
								class_val = "QRYEVEN";

							out.println("<tr>");

							if( ! (jsp_name.equals("") && modal.equals("") ) )
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									out.println("<td class='CAGROUPHEADING' colspan='8' align='left'>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
								}
								out.println("<td class='"+class_val+"' nowrap> ");									
								out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">");
								out.print("+</a></td>" );
								out.println("<td class='"+class_val+"' nowrap>"+admission_date_time+"</td>");
								out.println("<td class='"+class_val+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+count_practitioner+"','"+strSerialNumber+"','"+strCountry+"')\">"+encounter_id+"</a></td>");						
							}
							else
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									out.println("<td class='CAGROUPHEADING' colspan='8' align='left'>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
								}
						
								out.println("<td nowrap class='"+class_val+"'> ");
								String changeCallFunc = "";
								if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
									changeCallFunc = "Y";
								else
									changeCallFunc = "N";
													
								out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");									
						
								out.print("+</a></td>" );								
								out.println("<td nowrap class='"+class_val+"' nowrap>"+admission_date_time+"</td>");
								out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");
								
							}
							out.println("<td nowrap class='"+class_val+"'>"+patient_id+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+patient_name+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+Sex+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+nursing_unit_short_desc+"</td>");
							out.println("<td nowrap class='"+class_val+"'>"+bed_no+"</td>");
							out.println("</tr>");

							prev_val=specialty_short_desc;
							prev_val2=practitioner_name;							
							i++;
						}
					}
				out.println("</table>");
				if(stmt!=null)	stmt.close();
				if(rs!=null)		rs.close();

				out.println("<script> resetValues(); </script>");
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block24Bytes, _wl_block24);
 } 
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
} 
	catch(Exception e)
	{
				out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con,request);
	}	

            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
