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
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public final class __viewdeathregisterresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ViewDeathRegisterResult.jsp", 1722864719949L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tModule\t\t\t:\teMR\n\tFunction\t\t\t:\tMR Queries -> View Death Register\n\tDeveloped By \t:\tVinod Babu \n\tCreated On\t \t:\t12/05/2005\n\tModified On\t\t:\t12/05/2005\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t<script>\n\n\t\tasync function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code,finalize_yn,visit_adm_date)\n\t\t{\n\t\t\t\tif(sex==\"Male\"){\n\t\t\t\tsex=\"M\";\n\t\t\t}else if(sex==\"Female\"){\n\t\t\t\tsex=\"F\";\n\t\t\t}\n\t\t\tvar dialogHeight=\"700px\";\n\t\t\tvar dialogWidth=\"900px\";\n\t\t\tvar dialogTop=\"100\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \";\" ;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tretVal = \tawait window.showModalDialog(\"../../eMR/jsp/ViewMDRFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=VIEW_DEATH_REG&episode_type=I&finalize_yn=\"+finalize_yn+\"&visit_adm_date=\"+visit_adm_date,arguments,features);\n\n\t\t\t\t\t//var action_url=\"../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn=\"+finalize_yn;\n//\t\tvar retVal=window.showModalDialog(action_url,title,features);\n\t\tif(retVal==undefined){\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t//var xmlHttp \t= new ActiveXObject( \"Microsoft.XMLHTTP\" );\n\t\t\txmlHttp.open(\"POST\",\"../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals\",false);\n\t\t\txmlHttp.send(null);\t\t\n\t\t\tresponseText=xmlHttp.responseText;\n\t\t}\n\t}\n\t</script>\n </head>\n <body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\n\t<form name=\'ViewDeathRegisterResult_from\' id=\'ViewDeathRegisterResult_from\'   method=\"post\"  target =\"messageFrame\">\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<P>\n\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\n\t\t\t</tr>\n\t\t</table><br>\n\t</P>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\"COLUMNHEADER\" nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</table>\n<br>\n</form>\n</body>\n</html>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);


	request.setCharacterEncoding("UTF-8");
	String FacilityId		= (String) session.getValue( "facility_id" ) ;
	String loginUser = (String)session.getValue("login_user");
	String locale			=(String) session.getAttribute("LOCALE");
	String sql = "";
	String PatientId		=	request.getParameter("PatientId") ;
	String EncounterId		=	request.getParameter("EncounterId") ;
	String DischargeDateFrom	=	request.getParameter("DischargeDateFrom") ;
	String DischargeDateTo	=	request.getParameter("DischargeDateTo") ;
	String AdmnDateFrom	=	request.getParameter("AdmnDateFrom") ;
	String AdmnDateTo	=	request.getParameter("AdmnDateTo") ;
	String PatientClass	=	request.getParameter("PatientClass") ;
	String OrderBy			= 	request.getParameter("OrderBy") ;
/*	The following values are to be taken from MP file natAltIDComponentCriteria.jsp
	NRIC - national_id_no
	Birth Cert - alt_id1_no
	Police ID - alt_id3_no
	Other Alt Type - Other_Alt_Type
	Other Alt No - other_alt_Id
	PMI - alt_id2_no
	Old IC No1 - alt_id4_no
*/


	String NRIC	=	request.getParameter("NRIC") ;
	String Birth_Cert	=	request.getParameter("Birth_Cert") ;
	String PMI	=	request.getParameter("PMI") ;
	String Police_ID	=	request.getParameter("Police_ID") ;
	String Old_IC_No1	=	request.getParameter("Old_IC_No1") ;
	String Other_Alt_ID_Type	=	request.getParameter("Other_Alt_ID_Type") ;
	String Other_Alt_ID_No	=	request.getParameter("Other_Alt_ID_No") ;
	String discharged_yn = "";

	if ( PatientId	== null || PatientId.equals( "null" )   || PatientId.equals( "" )   )  		PatientId = "";
	if ( EncounterId	== null || EncounterId.equals( "null" )  	|| EncounterId.equals( "" )  ) 	EncounterId = "";
	if ( DischargeDateFrom == null || DischargeDateFrom.equals( "null" )  || DischargeDateFrom.equals( "" )  ) 	 DischargeDateFrom = "";
	if ( DischargeDateTo	== null || DischargeDateTo.equals( "null" )  || DischargeDateTo.equals( "" )  )  DischargeDateTo = "31/12/2005";
	if ( AdmnDateFrom == null || AdmnDateFrom.equals( "null" )  || AdmnDateFrom.equals( "" )  ) 	AdmnDateFrom = "";
	if ( AdmnDateTo	== null || AdmnDateTo.equals( "null" )  || AdmnDateTo.equals( "" )   )  AdmnDateTo = "31/12/2005";
	if ( PatientClass	== null || PatientClass.equals( "null" )  || PatientClass.equals( "" )  )  PatientClass = "";
	if ( NRIC	== null || NRIC.equals( "null" )  || NRIC.equals( "" )  )  NRIC = "";
	if ( Birth_Cert	== null || Birth_Cert.equals( "null" )  || Birth_Cert.equals( "" )  )  Birth_Cert = "";
	if ( PMI	== null || PMI.equals( "null" )  || PMI.equals( "" )  )  PMI = "";
	if ( Police_ID	== null || Police_ID.equals( "null" )  || Police_ID.equals( "" )  )  Police_ID = "";
	if ( Old_IC_No1	== null || Old_IC_No1.equals( "null" )  || Old_IC_No1.equals( "" )  )  Old_IC_No1 = "";
	if ( Other_Alt_ID_Type	== null || Other_Alt_ID_Type.equals( "null" )  || Other_Alt_ID_Type.equals( "" )  )  Other_Alt_ID_Type = "";
	if ( Other_Alt_ID_No	== null || Other_Alt_ID_No.equals( "null" )  || Other_Alt_ID_No.equals("" ) ) Other_Alt_ID_No = "";
	if ( OrderBy	== null || OrderBy.equals( "null" )  || OrderBy.equals("" ) ) OrderBy = "";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String finalize_status = "";

	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 12 ;
	else
		end = Integer.parseInt( to ) ;

	Statement stmt		= null;
	ResultSet rs				= null;
	PreparedStatement pstmt		= null;
	Connection conn = null ;	
try 
{
	conn = ConnectionManager.getConnection(request);	

	StringBuffer aesql = new StringBuffer();
	String oper_stn_id = "";
		
	aesql.append(" select oper_stn_id from am_user_for_oper_stn ");
	aesql.append(" where appl_user_id= ? ");
	aesql.append(" and facility_id=  ? ");
		
	pstmt = conn.prepareStatement(aesql.toString());
	pstmt.setString(1, loginUser);
	pstmt.setString(2, FacilityId);
	
	rs = pstmt.executeQuery();
	if(rs.next())
		oper_stn_id=rs.getString(1);

	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	if((aesql != null) && (aesql.length() > 0))
	{
		aesql.delete(0,aesql.length());
	} 


	stmt	= conn.createStatement();
	rs		= stmt.executeQuery("SELECT MAINTAIN_DEATH_REGISTER_YN from am_oper_stn where facility_id ='"+FacilityId+"' and oper_stn_id ='"+oper_stn_id+"'");	
	rs.next();
	String maintain_death_register_yn=rs.getString(1);
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	StringBuffer Where = new StringBuffer();

	//Where.append(" where a.facility_id ='"+FacilityId+"' and b.patient_id = a.patient_id and a.facility_id = c.facility_id and a.encounter_id = c.encounter_id and a.specialty_code = d.speciality_code " );

	Where.append(" where a.facility_id ='"+FacilityId+"' and b.patient_id = a.patient_id and a.facility_id = c.facility_id and a.encounter_id = c.encounter_id " );

	Where.append(" AND (a.facility_id,a.assign_care_locn_type,a.assign_care_locn_code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and MAINTAIN_DEATH_REGISTER_YN = 'Y')   ");


 
	if ( ! NRIC.equals("") )
	Where.append(" and b.national_id_no ='"+NRIC+"'");

	if ( ! Birth_Cert.equals("") )
	Where.append(" and b.alt_id1_no ='"+Birth_Cert+"'");

	if ( ! Police_ID.equals("") )
	Where.append(" and b.alt_id3_no ='"+Police_ID+"'");

	if ( ! Other_Alt_ID_Type.equals("") )
	Where.append(" and b.oth_alt_id_type ='"+Other_Alt_ID_Type+"'");

	if ( ! Other_Alt_ID_No.equals("") )
	Where.append(" and b.oth_alt_id_no ='"+Other_Alt_ID_No+"'");

	if ( ! PMI.equals("") )
	Where.append(" and b.alt_id2_no ='"+PMI +"'");

	if ( ! Old_IC_No1.equals("") )
	Where.append(" and b.alt_id4_no ='"+Old_IC_No1+"'");

	if ( ! PatientId.equals("") )
	Where.append(" and a.patient_id ='"+PatientId+"'");

	if ( ! EncounterId.equals("") )
	Where.append(" and a.encounter_id ='"+EncounterId+"'");

	if ( ! AdmnDateFrom.equals("") )
	Where.append(" and trunc(a.visit_adm_date_time) between  to_date('"+AdmnDateFrom+"','dd/mm/yyyy') and to_date('"+AdmnDateTo+"','dd/mm/yyyy')" );

	if ( ! DischargeDateFrom.equals("") )
	Where.append("and trunc(c.death_date_time) between  to_date('"+DischargeDateFrom+"','dd/mm/yyyy') and to_date('"+DischargeDateTo+"','dd/mm/yyyy')");

	if ( ! PatientClass.equals("") )
	Where.append(" and a.patient_class = '"+PatientClass+"' ");

	if ( ! OrderBy.equals("") )
	{
		if ( OrderBy.equals("ED") )
		{
			Where.append("  ORDER BY visit_adm_date_time ");
		}
		else
 	    if ( OrderBy.equals("ET") )
		{
			Where.append("  ORDER BY location_type ");
		}
	}

	int maxRecord = 0;

	//sql = "SELECT A.ENCOUNTER_ID, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') discharge_date, to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') admission_date, A.PATIENT_ID, B.PATIENT_NAME, decode(B.SEX,'M','Male','F','Female','Unknown') sex, a.attend_practitioner_id, to_char(a.deceased_DATE_TIME,'dd/mm/yyyy hh24:mi') deceased_date, decode(a.assign_care_locn_type, 'N','Nursing Unit', 'Clinic') location_type, (case when a.assign_care_locn_type = 'N' then (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code) else (select short_desc from op_clinic where facility_id = a.facility_id and  clinic_code = a.assign_care_locn_code) end ) location_desc,d.short_desc speciality_name from pr_encounter a, mp_patient b , mr_death_register_hdr c, am_speciality d " + Where.toString(); 

	
	sql = "SELECT A.ENCOUNTER_ID, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') discharge_date, to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') admission_date,A.PATIENT_ID, decode('"+localeName+"', 'en', b.patient_name, Nvl(b.patient_name_loc_lang,b.patient_name)) PATIENT_NAME,B.SEX sex, a.attend_practitioner_id, TO_CHAR (c.death_date_time,      'dd/mm/yyyy hh24:mi') deceased_date, a.assign_care_locn_type location_type,DECODE(a.assign_care_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,'"+localeName+"','2'), 				OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,'"+localeName+"','1')) location_desc, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','2') speciality_name,c.finalize_yn,a.specialty_code,TO_CHAR (b.date_of_birth, 'dd/mm/yyyy') date_of_birth, (select pract_type from am_practitioner where practitioner_id =  c.auth_practitioner_id) pract_type, a.pat_curr_locn_code from pr_encounter a, mp_patient b , mr_death_register_hdr c " + Where.toString(); 
	
	//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	if ( start != 1 )
	{
		 for( int j=1; j<start; i++,j++ )
			  rs.next() ;
	}

	while ( i<=end && rs.next())
	{
		if(maxRecord==0)
		{

	/*if ( (rs != null) )
	{
	   rs.last();
	   maxRecord = rs.getRow();
	   rs.beforeFirst();
	}
	if (maxRecord==0)	
	   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	else
	{*/
  
            _bw.write(_wl_block9Bytes, _wl_block9);

					if ( start > 12) 
						out.println("<td align='right' id='prev'><A HREF='../../eMR/jsp/ViewDeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmnDateFrom="+AdmnDateFrom+"&AdmnDateTo="+AdmnDateTo+"&DischargeDateFrom="+DischargeDateFrom+"&DischargeDateTo="+DischargeDateTo+"&PatientClass="+PatientClass+"&NRIC="+NRIC+"&Birth_Cert="+Birth_Cert+"&PMI="+PMI+"&Police_ID="+Police_ID+"&Old_IC_No1="+Old_IC_No1+"&Other_Alt_ID_Type="+Other_Alt_ID_Type+"&Other_Alt_ID_No="+Other_Alt_ID_No+"&OrderBy="+OrderBy+"&from="+(start-12)+"&to="+(end-12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
					//if ( end < maxRecord )
						out.println("<td align='right'  id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ViewDeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmnDateFrom="+AdmnDateFrom+"&AdmnDateTo="+AdmnDateTo+"&DischargeDateFrom="+DischargeDateFrom+"&DischargeDateTo="+DischargeDateTo+"&PatientClass="+PatientClass+"&NRIC="+NRIC+"&Birth_Cert="+Birth_Cert+"&PMI="+PMI+"&Police_ID="+Police_ID+"&Old_IC_No1="+Old_IC_No1+"&Other_Alt_ID_Type="+Other_Alt_ID_Type+"&Other_Alt_ID_No="+Other_Alt_ID_No+"&OrderBy="+OrderBy+"&from="+(start+12)+"&to="+(end+12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		String classValue	 = "";

		//if ( rs != null )
		//{

				/*if ( start != 1 )
				{
					 for( int j=1; j<start; i++,j++ )
					  rs.next() ;
				}*/

				//while ( rs.next() && i<=end )
				//{
					if ( i % 2 == 0 )
						classValue = "QRYEVENSMALL" ;	 
					else
						classValue = "QRYODDSMALL" ;	  
					String EncounterID		= rs.getString(1);				
					String Discharge_Date	= rs.getString(2);
					String VisitAdmDate		= rs.getString(3);
					String PatientID		= rs.getString(4);
					String PatientName		= rs.getString(5);
					String Sex				= rs.getString(6);
					String Practitioner		= rs.getString(7);
					String Deceased_Date		= rs.getString(8);
					String Locntype		= rs.getString(9);
					String Locn_Desc		= rs.getString(10);
					String speciality_name		= rs.getString(11);
					String finalize_yn		= rs.getString(12);
					String speciality_code		= rs.getString(13);
					String date_of_birth		= rs.getString(14);
					String pract_type		= rs.getString(15);
					String pat_curr_locn_code		= rs.getString(16);
	
					if(!(Discharge_Date==null || Discharge_Date.equals("")))
						discharged_yn = "Y";
					else
						discharged_yn = "N";



					if(finalize_yn.equals("") || finalize_yn == null)
					finalize_yn="N";


					if(Sex.equalsIgnoreCase("M"))
						Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(Sex.equalsIgnoreCase("F"))
						Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					if(Locntype.equalsIgnoreCase("C"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					else if(Locntype.equalsIgnoreCase("E"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					else if(Locntype.equalsIgnoreCase("N"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
					else if(Locntype.equalsIgnoreCase("Y"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				
					if (EncounterID==null	|| EncounterID.equals("null"))		EncounterID = "";

					String VisitAdmDate_display = "";
					if (VisitAdmDate==null	|| VisitAdmDate.equals("null"))
					{
						VisitAdmDate = "&nbsp;";
						VisitAdmDate_display = "&nbsp;";
					}
					else
						VisitAdmDate_display = DateUtils.convertDate(VisitAdmDate,"DMYHM","en",locale);

					if (DischargeDateTo==null	|| DischargeDateTo.equals("null"))	DischargeDateTo = "&nbsp;";
					
					String Deceased_Date_display = "";
					if (Deceased_Date==null	|| Deceased_Date.equals("null"))
					{
						Deceased_Date = "&nbsp;";
						Deceased_Date_display = "&nbsp;";
					}
					else
						Deceased_Date_display = DateUtils.convertDate(Deceased_Date,"DMYHM","en",locale);
				
					if (PatientName==null	|| PatientName.equals("null"))		PatientName = "&nbsp;";
					if (Sex==null			|| Sex.equals("null"))				Sex = "&nbsp;";
					if (Practitioner==null	|| Practitioner.equals("null"))		Practitioner = "";
					if (Locntype==null	|| Locntype.equals("null"))		Locntype = "";
					if (Locn_Desc==null	|| Locn_Desc.equals("null"))		Locn_Desc = "";
					if (speciality_name==null	|| speciality_name.equals("null"))		speciality_name = "";
					if (speciality_code==null	|| speciality_code.equals("null"))speciality_code = "";
					if (date_of_birth==null	|| date_of_birth.equals("null"))date_of_birth = "";
					if (pract_type==null	|| pract_type.equals("null"))pract_type = "";
					if (pat_curr_locn_code==null	|| pat_curr_locn_code.equals("null"))pat_curr_locn_code = "";

					String Discharge_Date_display = "";					
					if (Discharge_Date==null	|| Discharge_Date.equals("null"))
					{
						Discharge_Date = "";
						Discharge_Date_display = "&nbsp;";
					}
					else
						Discharge_Date_display = DateUtils.convertDate(Discharge_Date,"DMYHM","en",locale);

			if(finalize_yn.equals("Y"))
			{
					finalize_status = "Finalized";

					if(maintain_death_register_yn.equals("Y"))
					{
						out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:white'>");
					
						out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+PatientClass+"','"+speciality_code+"','"+Sex+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");

					}
					else
					{
						out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:white'>"+PatientID);

					}
					out.println("</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+PatientName+"</td>");			
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Sex+"</td>");	
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+finalize_status+"</td>");			
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+EncounterID+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+VisitAdmDate_display+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Locntype+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Locn_Desc+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>" +Discharge_Date_display+"</td>");
					out.println("<td align='center' class='"+classValue+"' style='font-weight:normal;background-color:white;text-align:center;'>" +discharged_yn+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>" +Deceased_Date_display+"</td>");
					out.println("</tr>");
			}
			else
			{
				finalize_status = "Recorded";
					if(maintain_death_register_yn.equals("Y"))
					{
					
					out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>");
					out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+PatientClass+"','"+speciality_code+"','"+Sex+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");
					}
					else
					{
						out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+PatientID);	

					}
					out.println("</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+PatientName+"</td>");		
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Sex+"</td>");			
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+finalize_status+"</td>");	
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+EncounterID+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+VisitAdmDate_display+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Locntype+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Locn_Desc+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>" +Discharge_Date_display+"</td>");
					out.println("<td align='center' class='"+classValue+"' style='font-weight:normal;background-color:lightblue;text-align:center;'>" +discharged_yn+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>" +Deceased_Date_display+"</td>");
					out.println("</tr>");

			}
					i++;
					maxRecord++;
	}
			//}
	
            _bw.write(_wl_block13Bytes, _wl_block13);

				if (maxRecord==0)	
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				if(maxRecord<12 || (!rs.next()) )
				{
            _bw.write(_wl_block14Bytes, _wl_block14);
}
				else
				{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	
	//}
}
catch ( Exception e )
{
	e.printStackTrace();
}
finally
{
	out.println("<script>parent.frames[1].document.forms[0].search.disabled=false;</script>");
	try
	{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
	}
	catch(Exception e)
	{
	}
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LocationDesc.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.dischargeYN.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeceasedDate.label", java.lang.String .class,"key"));
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
}
