package jsp_servlet._eip._jsp;

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
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __renewgatepasslookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/RenewGatePassLookupResult.jsp", 1733489412026L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>\n\nasync function ViewEncDetails(pat_id, Enc_id)\n{\n\tvar dialogHeight= \"500px\";\n\tvar dialogWidth = \"1200px\";\n\tvar dialogTop\t= \"72\";\n\tvar status\t\t= \"no\";\n\tvar arguments\t= \"\" ;\n\tvar  patient\t= pat_id;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogTop:\" + dialogTop + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes; status:\" + status;\n\tcall_function = \"RENEW_GATE_PASS\";\n\tbl_install_yn = \"\";\n\tretVal = await window.showModalDialog(\"../../eIP/jsp/CurrentEncounterMain.jsp?encounterId=\"+Enc_id+\"&bl_instal=\"+bl_install_yn+\"&call_function=\"+call_function+\"&patientId=\"+pat_id,arguments,features);\n}\n\n/// added by Sridhar R on 2 Sep 2004\n/// This is used to view the Patient Details ...\nasync function ViewPatDetails(pat_id)\n{\n\tvar dialogHeight= \"90vh\";\n\tvar dialogWidth = \"95vw\";\n\tvar dialogTop\t= \"0vh\";\n\tvar status\t\t= \"no\";\n\tvar arguments\t= \"\" ;\n\tvar  patient\t= pat_id;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogTop:\" + dialogTop + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes; status:\" + status;\n\tvar jsp_name;\n\tjsp_name = \"../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID=\" + patient;\n\tretVal = await window.showModalDialog(jsp_name,arguments,features);\n}\n\n\t\nasync function callPage(lodger_ref_no,chk_in_date,enc_id,attached_to_inpatient_yn,ResultPageName,call_func,nursing_unit_short_desc,lodger_patient_id)\n{\n\tif(enc_id == \'0\') enc_id=\'\';\n\tvar retVal = new String();\n\tvar dialogHeight= \"650px\";\n\tvar dialogWidth = \"1200px\";\n\tvar dialogTop\t= \"72\";\n\n\tvar center\t\t= \"1\" ;\n\tvar status\t\t= \"no\";\n\tvar arguments\t= \"\" ;              \n\tvar call_function\t= \"\";\n\t\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tretVal = await window.showModalDialog(\"../../eIP/jsp/ReleaseBookLodgerDetail.jsp?mode=update&call_function=\"+call_function+\"&lodger_ref_no=\"+lodger_ref_no+\"&EncounterId=\"+enc_id+\"&PatID=\"+lodger_patient_id+\"&chk_in_dttime=\"+chk_in_date+\"&Category=\"+attached_to_inpatient_yn+\"&ResultPageName=\"+ResultPageName+\"&nursing_desc=\"+escape(nursing_unit_short_desc)+\"&\",arguments,features);\n\tparent.frames[2].document.location.reload();                \n\n}\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>                         \n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t<script>\t\t\t\t\n\t\t\tif (parseInt(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\') == 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"nextval\").innerHTML = \" \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n    <input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n    <input type=\'hidden\' name=\'from_date\' id=\'from_date\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n    <input type=\'hidden\' name=\'to_date\' id=\'to_date\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n    <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n    <input type=\'hidden\' name=\'name\' id=\'name\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n    <input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
 
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

/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	SEP-01-2004
/// Funtion			:	This File is called on the click of RenewGatePass Function & will direct the File to ReleaseBookLodgerDetail.jsp..
///	Used to display the Accompanying Persons for Renewal of Gate Pass...


            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	  
	String ResultPageName	= "";
	ResultPageName			= request.getParameter("PageValue")==null?"":request.getParameter("PageValue");
    String call_function    = request.getParameter("call_function");
	Connection con			= null;

	try
	{
		con= ConnectionManager.getConnection(request);
		Statement stmt			= null;
		ResultSet rs			= null;
		Statement stmt_count	= null;
		Statement stmt2			= null;
		ResultSet rs_count		= null;
		ResultSet rs2			= null;
		
		String facility_id		= (String)session.getValue("facility_id");
		StringBuffer sql		= new StringBuffer();
		String sql2				= "";
		String patient_encounter_id2 = "";
		int records_to_show	=	8;

		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		StringBuffer where_criteria	= new StringBuffer();

		String whereClause = request.getParameter("whereclause");
			if(whereClause != null) where_criteria.append(whereClause);

		int p_max_record		 = 0;
		int start=0,end=0;


		String nursing_unit_code=checkForNull(request.getParameter("nursing_unit"));
		String from_date        =checkForNull(request.getParameter("from_date"));
		if(!from_date.equals(""))
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
		
		String to_date          =checkForNull(request.getParameter("to_date"));
		if(!to_date.equals(""))
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
		String name             =checkForNull(request.getParameter("name"));
		String soundex_type		=checkForNull(request.getParameter("soundex"));
		String patient_id		=checkForNull(request.getParameter("patient_id"));
		String gender			=checkForNull(request.getParameter("gender"));
		String name_prefix		=checkForNull(request.getParameter("name_prefix"));
		String name_suffix		=checkForNull(request.getParameter("name_suffix"));
		name_prefix				= singleToDoubleQuotes(name_prefix);
		name_suffix				= singleToDoubleQuotes(name_suffix);
		String first_name		=checkForNull(request.getParameter("first_name"));
		String second_name		=checkForNull(request.getParameter("second_name"));
		String third_name		=checkForNull(request.getParameter("third_name"));
		String family_name		=checkForNull(request.getParameter("family_name"));
		String national_id_no	=checkForNull(request.getParameter("national_id_no"));
		String alt_id1_no		=checkForNull(request.getParameter("alt_id1_no"));
		String alt_id2_no		=checkForNull(request.getParameter("alt_id2_no"));
		String alt_id3_no		=checkForNull(request.getParameter("alt_id3_no"));
		String alt_id4_no		=checkForNull(request.getParameter("alt_id4_no"));
		String other_alt_type	=checkForNull(request.getParameter("other_alt_type"));
		String other_alt_Id		=checkForNull(request.getParameter("other_alt_Id"));
		String loc_lang			= checkForNull(request.getParameter("loc_lang"));
		String searchby = checkForNull(request.getParameter("searchby"));
		if (searchby.equals("")) searchby="S";
		
		String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));

	if(patient_id!=null && !patient_id.equals(""))
		where_criteria.append( " and a.LODGER_PATIENT_ID like'"+patient_id+"%' ");

	if( name!=null && !name.equals("") )// acc per id
		where_criteria.append(" and d.patient_id like '"+name+"%' ");

	if(gender!=null && !gender.equals(""))
		where_criteria.append( " and a.lodger_gender='"+gender+"' ");

	if(name_prefix!=null && !name_prefix.equals(""))
		where_criteria.append(" and a.name_prefix='"+name_prefix+"' ");

	if(name_suffix!=null && !name_suffix.equals(""))
		where_criteria.append( " and a.name_suffix='"+name_suffix+"' ");
	
	if(national_id_no!=null && !national_id_no.equals(""))
		where_criteria.append(" and a.national_id_no='"+national_id_no+"'");
	
	if(alt_id1_no!=null && !alt_id1_no.equals(""))
		where_criteria.append( " and a.alt_id1_no='"+alt_id1_no+"'");

	if(alt_id2_no!=null && !alt_id2_no.equals(""))
		where_criteria.append(" and a.alt_id2_no='"+alt_id2_no+"'");

	if(alt_id3_no!=null && !alt_id3_no.equals(""))
		where_criteria.append(" and a.alt_id3_no='"+alt_id3_no+"'");

	if(alt_id4_no!=null && !alt_id4_no.equals(""))
		where_criteria.append( " and a.alt_id4_no='"+alt_id4_no+"'");

	if(other_alt_type!=null && !other_alt_type.equals(""))
		where_criteria.append( " and a.oth_alt_id_type='"+other_alt_type+"'");

	if(other_alt_Id!=null && !other_alt_Id.equals(""))
		where_criteria.append( " and a.oth_alt_Id_no='"+other_alt_Id+"'");

	if(soundex_type.equals("E"))
	{
		if(first_name!=null && !first_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(a.first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(a.first_name_loc_lang)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
		}

		if(second_name!=null && !second_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(a.second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(a.second_name_loc_lang)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
		}

		if(third_name!=null && !third_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(a.third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(a.third_name_loc_lang)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			String fam_name_search = "";
			if (pat_name_as_multipart_yn.equals("N"))
			{
				StringTokenizer stktok = new StringTokenizer(family_name, " ");
				if (stktok.hasMoreTokens())
					fam_name_search = stktok.nextToken();
				else
					fam_name_search = family_name;
			}
			else
				fam_name_search = family_name;

			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(ethnic_soundex(a.family_name)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");
			else
				where_criteria.append( " and upper(ethnic_soundex(a.family_name_loc_lang)) like upper(ethnic_soundex('" +fam_name_search+"')) || '%' ");

		}
	}
	else if(soundex_type.equals("G"))
	{
		if(first_name!=null && !first_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(soundex(a.first_name)) like upper(soundex('" +first_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(soundex(a.first_name_loc_lang)) like upper(soundex('" +first_name +"')) || '%' ");
		}

		if(second_name!=null && !second_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append( " and upper(soundex(a.second_name)) like upper(soundex('" + second_name +"')) || '%' ");
			else
				where_criteria.append( " and upper(soundex(a.second_name_loc_lang)) like upper(soundex('" + second_name +"')) || '%' ");
		}

		if(third_name!=null && !third_name.equals(""))
		{
			if(loc_lang.equals("en"))
				where_criteria.append(" and upper(soundex(a.third_name)) like upper(soundex('"+ third_name+"')) || '%' ");
			else
				where_criteria.append(" and upper(soundex(a.third_name_loc_lang)) like upper(soundex('"+ third_name+"')) || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			String fam_name_search = "";
			if (pat_name_as_multipart_yn.equals("N"))
			{
				StringTokenizer stktok = new StringTokenizer(family_name, " ");
				if (stktok.hasMoreTokens())
					fam_name_search = stktok.nextToken();
				else
					fam_name_search = family_name;
			}
			else
				fam_name_search = family_name;

			if(loc_lang.equals("en"))
				where_criteria.append(" and upper(soundex(a.family_name)) like upper(soundex('" +fam_name_search+"')) || '%' ");
			else
				where_criteria.append(" and upper(soundex(a.family_name_loc_lang)) like upper(soundex('" +fam_name_search+"')) || '%' ");
		}
	}
	else	
	{
		if (pat_name_as_multipart_yn.equals("Y"))
		{
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(a.first_name) like upper('" +first_name +"') || '%' ");
				else
					where_criteria.append(" and upper(a.first_name_loc_lang) like upper('" +first_name +"') || '%' ");
			}

			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper(a.second_name) like upper('"+second_name+"') || '%' ");
				else
					where_criteria.append(" and upper(a.second_name_loc_lang) like upper('"+second_name+"') || '%' ");
			}

			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(a.third_name) like upper('"+third_name+"') || '%' ");
				else
					where_criteria.append( " and upper(a.third_name_loc_lang) like upper('"+ third_name+"') || '%' ");
			}

			if(family_name!=null && !family_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append( " and upper(a.family_name) like upper('"+family_name+"') || '%' ");
				else
					where_criteria.append( " and upper(a.family_name_loc_lang) like upper('"+family_name+"') || '%' ");
			}
		}
		else
		{						
			if (searchby.equals("C"))
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append( " and upper(a.family_name) like '%' || upper('" +family_name+"') || '%' ");
					else
						where_criteria.append( " and upper(a.family_name_loc_lang) like '%' || upper('" +family_name+"') || '%' ");
				}
			}
			else if (searchby.equals("E"))
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
					else
						where_criteria.append(" and upper(a.family_name) like '%' || upper('" +family_name+"') ");
				}
			}
			else
			{
				if(!family_name.equals(""))
				{
					if(loc_lang.equals("en"))
						where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
					else
						where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
				}
			}
		}
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

		String pat_id		= "";
		String pat_name		= "";
		String acc_id		= "";
		String acc_name		= "";
		String chk_in_time	= "";
		String period_from	= "";
		String period_to	= "";
		String chk_in_time_display	= "";
		String period_from_display	= "";
		String period_to_display	= "";
		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
            where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");

        if(from_date!=null && !from_date.equals(""))
            where_criteria.append(" and trunc(a.check_in_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
        
        if(to_date!=null && !to_date.equals(""))
            where_criteria.append(" and trunc(a.check_in_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");      

	try
	{
		//out.println("count Query : "+sql_count);

		String curr_patID ="";
		String cname= "QRYEVENSMALL" ;
		String prev_patient_id ="&nbsp;";
		String curr_patient_id ="";
		int z=0;
		int cnt=0;
		int endOfRes=1;
		stmt2 = con.createStatement();

		if ( from == null )
			start = 0 ;
		else
			start = Integer.parseInt( from ) ;
		
		if ( to == null )
			end = records_to_show ;
		else
			end = Integer.parseInt( to ) ;

		sql.append("select a.lodger_ref_no ");
        sql.append( ",decode(a.attached_to_inpatient_yn,'Y','Attendant','N','Lodger') Accom_categ, ");
		sql.append(" (CASE WHEN b.NURSING_UNIT_CODE IS NOT NULL THEN (ip_get_desc.IP_NURSING_UNIT('"+facility_id+"',b.NURSING_UNIT_CODE,'"+locale+"',2)) END ) nursing_unit_short_desc ");
        sql.append(",A.attached_to_inpatient_yn  ");
        sql.append( ",a.patient_encounter_id ");
        sql.append( ",d.patient_id ");
        sql.append( ",decode('"+locale+"','en',d.patient_name, nvl(d.patient_name_loc_lang, d.patient_name))patient_name ");
        sql.append( ",a.lodger_patient_id  ");
        sql.append( ",a.lodger_name ");
        sql.append( ",to_char(check_in_date_time, 'dd/mm/rrrr hh24:mi') check_in_date_time , check_in_date_time check_in_date_time1, lodger_gender,");
		sql.append("(CASE WHEN e.reason_for_stay_code IS NOT NULL THEN (ip_get_desc.IP_REASON_FOR_LODGER_STAY(e.reason_for_stay_code,'"+locale+"',2)) END ) reason_for_stay_code,");
		sql.append( " c.encounter_id  ");
        sql.append( ",to_char(f.PERIOD_FROM_DATE, 'dd/mm/rrrr hh24:mi') PERIOD_FROM_DATE");
        sql.append( ",to_char(f.PERIOD_TO_DATE, 'dd/mm/rrrr hh24:mi') PERIOD_TO_DATE");
        sql.append( " from ");
        sql.append( " IP_LODGER_GATE_PASS f ");
		sql.append( " , IP_LODGER_DETAIL a ");
		sql.append( " , IP_NURSING_UNIT b ");
        sql.append( " , ip_open_encounter c ");
		sql.append( " , MP_PATIENT d ");
		sql.append( " ,IP_REASON_FOR_LODGER_STAY e ");
        sql.append( " where ");
        sql.append( " a.facility_id ='"+facility_id+"' ");
        sql.append( " and a.check_out_yn = 'N'  ");
        sql.append( " and f.revised_yn = 'N'  ");
        sql.append( " and b.facility_id(+)=a.facility_id ");
        sql.append( " and b.nursing_unit_code(+)=a.nursing_unit_code ");
        sql.append( " and c.facility_id(+) = a.facility_id ");
        sql.append( " and c.encounter_id(+) = a.patient_encounter_id ");
		sql.append( " and a.lodger_ref_no(+) = f.lodger_ref_no ");
        sql.append( " and d.patient_id(+)=c.patient_id ");
		sql.append( " and a.reason_for_stay_code = e.reason_for_stay_code(+) "); 
		sql.append( where_criteria.toString() );
        sql.append( " ORDER by ");
        sql.append( " patient_id ");
        sql.append( " , lodger_name,lodger_patient_id, check_in_date_time1 desc ");

		
		stmt= con.createStatement();
		rs	= stmt.executeQuery(sql.toString());

		if(start > 1 && (rs != null))
		{
			for(int k=0; k < start ;k++)
				rs.next();
		}
		while( z < records_to_show  && rs.next() )
		{
			if(cnt==0)
			{

			out.println("<p><table align='right'><tr><td>");
			if ( !(start <= 0) )
			out.println("<A  HREF='../jsp/RenewGatePassLookupResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&patient_id="+patient_id+"&name="+name+"&gender="+gender+"&PageValue="+ResultPageName+" '" +
			" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if (endOfRes==1)
			out.println("<A id='nextval' HREF='../jsp/RenewGatePassLookupResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&patient_id="+patient_id+"&name="+name+"&gender="+gender+"&PageValue="+ResultPageName+" '"
			+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			out.println("</td></tr></table></p>");
			out.println("<br><br>");
		
		out.println("<table width='100%' cellspacing=1 cellpadding=0 border=1>") ;
		out.println( "<tr>" ) ;
		out.println( "<th></th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonDetails.label","ip_labels")+"</th>" );
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ChkdInDt.label","ip_labels")+"</th>" );
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodfrom.label","common_labels")+"</th>");
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodto.label","common_labels")+"</th>"); 
		}

				z++;
				if(cname.equals("QRYEVENSMALL"))
					cname = "QRYODDSMALL";
				else
					cname = "QRYEVENSMALL";

					curr_patient_id= rs.getString("lodger_patient_id")== null ? "&nbsp;": rs.getString("lodger_patient_id");
					
				out.println( "<tr>" ) ;
				
				chk_in_time = rs.getString("check_in_date_time");
				if(chk_in_time == null)
				{
					chk_in_time = "&nbsp;";
					chk_in_time_display = "&nbsp;";
				}
				else
					chk_in_time_display = DateUtils.convertDate(chk_in_time,"DMYHM","en",locale);

				period_from=rs.getString("PERIOD_FROM_DATE");
				if(period_from == null)
				{
					period_from = "&nbsp;";
					period_from_display = "&nbsp;";
				}
				else
					period_from_display = DateUtils.convertDate(period_from,"DMYHM","en",locale);

				period_to=rs.getString("PERIOD_TO_DATE");
				if(period_to == null)
				{
					period_to = "&nbsp;";
					period_to_display = "&nbsp;";
				}
				else
					period_to_display = DateUtils.convertDate(period_to,"DMYHM","en",locale);

				acc_id = rs.getString("lodger_patient_id");
					if(acc_id == null) acc_id = "";

				patient_encounter_id2 = rs.getString("patient_encounter_id");
				  if(patient_encounter_id2 == null) patient_encounter_id2 = "";

				if(acc_id.equals(""))
					acc_id = "";
				else
					acc_id = acc_id + "&nbsp;/&nbsp;";
	
				acc_name = rs.getString("lodger_name");
				if(acc_name == null) acc_name = "&nbsp;";

				pat_id = rs.getString("patient_id")== null ? "&nbsp;": rs.getString("patient_id");
				pat_name = rs.getString("patient_name")== null ? "": rs.getString("patient_name");
				
				if(!pat_name.equals(""))
					pat_name = " / "+pat_name;

			if(curr_patID.equals(pat_id))
			{
				pat_id = "";
			}
			else
			{ 
				sql2  = "select get_patient.get_line_detail('"+facility_id+"','"+patient_encounter_id2+"','"+locale+"') display_pline_details from dual";
				rs2	= stmt2.executeQuery(sql2);
				String display_pline= "";

				if(rs2!=null && rs2.next())
				{
					display_pline = rs2.getString("display_pline_details"); 
				}

				out.println (" <tr> ");
				out.println (" <td class='HEADER' ><a style='color:black' href =\"javascript:ViewEncDetails('"+pat_id+"', '"+patient_encounter_id2+"')\">&nbsp;+&nbsp;</a></td> ");
				
				out.println (" <td colspan='4' class='HEADER' nowrap>&nbsp;&nbsp;<a style='color:black' href =\"javascript:ViewPatDetails('"+pat_id+"')\">"+display_pline+"</a></td></tr>") ;
			}
				out.println ( "<td class='"+cname+"'>&nbsp;</td>" ) ;
				pat_id = rs.getString("patient_id")== null ? "&nbsp;": rs.getString("patient_id");
				curr_patID  = pat_id;
				out.println ( "<td class='"+cname+"' nowrap><a href =\"javascript:callPage('" + rs.getString("lodger_ref_no") + "', '"+ rs.getString("check_in_date_time") +"', '"+patient_encounter_id2+"', '"+ rs.getString("attached_to_inpatient_yn") +"','"+ResultPageName+"','"+call_function+"','"+ rs.getString("nursing_unit_short_desc") +"','"+rs.getString("lodger_patient_id")+"')\">" +(acc_id+acc_name)+"</a></td>");
				out.println ( "<td class='"+cname+"' nowrap> "+chk_in_time_display+"</td>" ) ;
				out.println ( "<td class='"+cname+"' nowrap> "+period_from_display+"</td>" ) ;
				out.println ( "<td class='"+cname+"' nowrap> "+period_to_display+"</td>" ) ;
				out.println( "</tr>" ) ;
				prev_patient_id		=	curr_patient_id ;
				p_max_record++;
				cnt++;
			}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_max_record));
            _bw.write(_wl_block10Bytes, _wl_block10);
		out.println("</table>");

			if( !rs.next() && cnt!=0 )
			{
				endOfRes=0;
			
            _bw.write(_wl_block11Bytes, _wl_block11);

			}

	}catch(Exception e) 
	{ 
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally 
	{
		if (stmt != null)		stmt.close();
		if (stmt_count != null) stmt_count.close();
		if (rs != null)			rs.close();  
		if (rs_count != null)	rs_count.close();
		out.print("<script>parent.frames[1].document.forms[0].disabled=false</script>");
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}
    finally
	{
		ConnectionManager.returnConnection(con,request);
    }    

            _bw.write(_wl_block19Bytes, _wl_block19);
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
