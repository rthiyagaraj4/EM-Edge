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

public final class __recclinicalnotesmodal extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesModal.jsp", 1743594561149L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<!--  <script>alert(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\');</script>   -->\n<html>\n<head>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\tfunction windowUnload(){\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\n\t\txmlStr =\"<root><SEARCH /></root>\" ;\n\t\t\n\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"NotifiableIntermediate.jsp?sessionNFKey=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\",false);\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText = trimString(responseText);\n\t\tif(responseText==\"MakeAsError\"){\n\t\t\twindow.returnValue=responseText;\n\t\t}else{\n\t\t\twindow.returnValue = top.NotifiableNoteFrm.document.NotifiableNoteForm.tempAccession_Num.value;\n\t\t\t\n\t\t}\n\t  }\n\t\n\n\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\' />\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<script>\n\ttop.content.workAreaFrame.location.href =\'../../eCA/jsp/RecClinicalNotes.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<iframe name=\"content\" id=\"content\" frameborder=\"0\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=\'0\' style=\"height:100vh;width:100vw\"></iframe>\n\t\t\t<iframe name=\"NotifiableNoteFrm\" id=\"NotifiableNoteFrm\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/NotifiableNoteHistory.jsp\" frameborder=\'0\' style=\"height:0%;width:100vw\"></iframe>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<!-- IN061988 starts -->\n\t\t\t<script>\n\t\t\tif(!\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' == \'PH_NOTES\')\n\t\t\t\ttop.content.workAreaFrame.location.href =\'../../eCA/jsp/RecClinicalNotes.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t</script>\n\t\t\t<!-- IN061988 ends --->\n\t\t\t<iframe name=\"content\" id=\"content\" frameborder=\"0\" scrolling=\"no\" noresize src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" frameborder=\'0\' style=\"height:100vh;width:100vw\"></iframe>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\t\talert(getMessage(\"INSUFFICIENT_PARAMS\",\"CA\"));\t\n\t\t//alert(\'CA APP-11059  Enough Parameters have not been passed for this function to record Notes. Please Contact your administrator..\');\n\t\t\twindow.close();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</head>\n</html>\n\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100           		?           	created
17/12/2013		IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
12/05/2015		IN053733		Ramesh G		Bru-HIMS-CRF-024.3 
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------
04/02/2016		IN057201		Karthi L											View Forwarded Referral Letter Under Consults
01/11/2016		IN061988		Vijayakumar K										AAKH-CRF-0088.3 [IN:061988]
08/01/2019		IN069251		Prakash			10/09/2018		Ramesh Goli			ML-MMOH-CRF-1130.3
28/02/2025	    68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
----------------------------------------------------------------------------------------------------------------------------------
 */

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block5Bytes, _wl_block5);

//IN053733 Start.
String sessionNFKey=(request.getParameter("patient_id"))+(request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"))+"NFERROR";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sessionNFKey));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//IN053733 End.
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rset = null;	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	


	String respid		= "";
	String strFileName	= "";
	String title		= request.getParameter("title")==null?"":request.getParameter("title");
	String function_id	= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String event_class	= request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String appl_task_id = request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String note_type	= request.getParameter("note_type")==null?"":request.getParameter("note_type");
//	String disp_pat_line_yn	= request.getParameter("disp_pat_line_yn")==null?"N":request.getParameter("disp_pat_line_yn");
	String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String visit_adm_date	= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	String episode_id	= request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String patient_id	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String location_code	= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String speciality_code	= request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String open_in_normal_yn	= request.getParameter("open_in_normal_yn")==null?"N":request.getParameter("open_in_normal_yn");
	String notifiable_code	= request.getParameter("notifiable_code")==null?"":request.getParameter("notifiable_code");  //IN044085 
	String notifiable_emailYN  = request.getParameter("notifiable_emailYN")==null?"N":request.getParameter("notifiable_emailYN");  //IN044085 
	String called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");  //IN053733 
	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");  //IN053733 
	String contr_oth_accession_num = request.getParameter("contr_oth_accession_num")==null?"":request.getParameter("contr_oth_accession_num");  //IN053733
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");  //IN044085
	String deflt_search_mode_from_refral_yn = request.getParameter("deflt_search_mode_from_refral_yn")==null?"":request.getParameter("deflt_search_mode_from_refral_yn");  //ML-MMOH-CRF-0362 [IN057201]  
	String orderStatusCodeHdr = request.getParameter("orderStatusCodeHdr")==null?"":request.getParameter("orderStatusCodeHdr");  //68801
	StringBuffer queryString = new StringBuffer();
	String episode_type = "";
	String speciality_name = "";
	//String speciality_code = "";
	//String location_code = "";

	boolean returnFlag	= false;

	try
	{
		con =  ConnectionManager.getConnection(request);    

		if(appl_task_id.equals(""))
		{
			if(function_id.equals("SPCL_NOTE"))
			{
				if(event_class.equals("MDB$"))
					appl_task_id = "PRE_MEDICAL_BOARD";
				else if(event_class.equals("MDR$"))
					appl_task_id = "MR_MEDICAL_REPORT";
				else
					appl_task_id = "CP_ASSESSMENT";
			}
			else if(function_id.equals("NOTIFIABLEFORM"))
				appl_task_id = "NOTIFIABLEFORM";
		}
	 
		if(appl_task_id.equals(""))
		{
			 try
			{
				 String qry = "select appl_task_id from ca_note_group a , ca_note_type b where b.note_group_id=a.note_group and b.note_type=?";
			 
				stmt = con.prepareStatement(qry);
				stmt.setString(1, note_type);
				
				rset = stmt.executeQuery();
				
				if(rset.next())
				 appl_task_id = rset.getString("appl_task_id");

				if(rset !=null) rset.close();
				if(stmt!= null ) stmt.close();
			}
			catch(Exception e)
			{
			 e.printStackTrace();
			}
		 }
		
		 if(appl_task_id.equals(""))
			returnFlag = true;




		 
	String clinician_id		=	(String)	session.getValue("ca_practitioner_id");
	String clinician_name	=	(String)	session.getValue("practitioner_name");
		
	if(clinician_id == null || clinician_name == null)
	{
		try
		{
			String login_user=(String)session.getValue("login_user");
			String sql= "select a.func_role_id, B.practitioner_name, B.pract_type,c.TAB_MENU_YN ,c.ESTABLISH_RELN_REQ_YN from sm_appl_user a,AM_PRACTITIONER_LANG_VW B,ca_encntr_param c where a.appl_user_id = ? and a.func_role ='P' AND B.PRACTITIONER_ID = A.FUNC_ROLE_ID AND B.LANGUAGE_ID = ?";
			
			String func_role_id="",		practitioner_name="",	pract_type="";

			stmt=con.prepareStatement(sql);
			stmt.setString(1,login_user);
			stmt.setString(2,locale);
			rset=stmt.executeQuery();

			if(rset.next())
			{
				func_role_id=rset.getString(1);
				
				if(func_role_id == null) 
					func_role_id="";

				practitioner_name=rset.getString(2);
				
				if(practitioner_name == null) 
					practitioner_name="";

				pract_type = rset.getString(3);
				
				if(pract_type == null) 
					pract_type="";

				session.putValue("ca_practitioner_id",func_role_id);
				session.putValue("practitioner_name",practitioner_name);
				session.putValue("practitioner_type",pract_type);
			}

			if(rset !=null) rset.close();
			if(stmt!= null ) stmt.close();

			String qry = "select SM_GET_DESC.SM_RESP(?,?,'1') resp_name from dual";
			respid=(String) session.getValue("responsibility_id");
			
			if(respid == null) 
				respid = "";
			
			stmt	=	con.prepareStatement(qry);
			stmt.setString(1,respid);
			stmt.setString(2,locale);
			rset=stmt.executeQuery();
			
			String resp_name = "";
			
			if(rset.next())
				resp_name = rset.getString(1);
		
			if(rset !=null) rset.close();
			if(stmt!= null ) stmt.close();

			session.putValue("resp_name",resp_name);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception @1=" + e);//COMMON-ICN-0181
		}
	}

	if(patient_class.equals("")||location_code.equals("")||speciality_code.equals(""))
	{		
		//queryString = new StringBuffer();
		String patQuery = "select P.PATIENT_CLASS PATIENT_CLASS ,P.EPISODE_ID EPISODE_ID ,to_char(P.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE,SPECIALTY_CODE speciality_code,AM_get_desc.AM_SPECIALITY(SPECIALTY_CODE,?,2) speciality_name,P.ASSIGN_CARE_LOCN_CODE LOCN_CODE from  PR_ENCOUNTER P where  P.PATIENT_ID =? and P.ENCOUNTER_ID =?" ;

		stmt	=	con.prepareStatement(patQuery);
		stmt.setString(1,locale);
		stmt.setString(2,patient_id);
		stmt.setString(3,encounter_id);
		rset=stmt.executeQuery();
	
		if(rset.next())
		{
			patient_class =rset.getString("PATIENT_CLASS")==null?"":rset.getString("PATIENT_CLASS");
			episode_id =rset.getString("EPISODE_ID")==null?"":rset.getString("EPISODE_ID");
			visit_adm_date =rset.getString("VISIT_ADM_DATE")==null?"":rset.getString("VISIT_ADM_DATE");
			speciality_code =rset.getString("speciality_code")==null?"":rset.getString("speciality_code");
			speciality_name =rset.getString("speciality_name")==null?"":rset.getString("speciality_name");
			location_code =rset.getString("LOCN_CODE")==null?"":rset.getString("LOCN_CODE");
		
		}
	}
		if(patient_class.equals("IP")||patient_class.equals("DC"))
			episode_type ="I";
		if(patient_class.equals("OP")||patient_class.equals("EM"))
			episode_type ="O";

		queryString.append("appl_task_id="+appl_task_id);		
		queryString.append("&title="+title);
		queryString.append("&patient_id="+patient_id);
		queryString.append("&encounter_id="+encounter_id);
		queryString.append("&episode_type="+episode_type);
		queryString.append("&visit_adm_date="+visit_adm_date);
		queryString.append("&patient_class="+patient_class);
		queryString.append("&speciality_name="+speciality_name);
		queryString.append("&speciality_code="+speciality_code);
		queryString.append("&location_code="+location_code);
		queryString.append("&function_id="+function_id);
		queryString.append("&notifiable_code="+notifiable_code);	//IN044085
		queryString.append("&notifiable_emailYN="+notifiable_emailYN);	//IN044085
		queryString.append("&accession_num="+accession_num);
		queryString.append("&called_from="+called_from);  //IN053733
		queryString.append("&contr_mod_accession_num="+contr_mod_accession_num);//IN053733
		queryString.append("&contr_oth_accession_num="+contr_oth_accession_num);//IN053733
		queryString.append("&deflt_search_mode_from_refral_yn="+deflt_search_mode_from_refral_yn); //ML-MMOH-CRF-0362 [IN057201]
		queryString.append("&orderStatusCodeHdr="+orderStatusCodeHdr); //68801

		/*	if(queryString.indexOf("&patient_class=") >= 0)
		{
			String temp ="&patient_class="+patient_class ;
			String temp1 ="&patient_class=";
			queryString.replaceAll(temp1,temp);
			
			
		}  */
	


/*
	String strQuery = "SELECT GET_TASK_APPLICABILITY('CLINICAL_NOTES',NULL,?,?,?,?,?)   FROM DUAL";

	stmt = con.prepareStatement(strQuery);
	stmt.setString(1,respid);
	stmt.setString(2,"");
	stmt.setString(3,facility_id);
	stmt.setString(4,encounter_Id);
	stmt.setString(5,patient_id);			

	rset = stmt.executeQuery();

	if(rset.next())
		strApplicability =  rset.getString(1);
*/
	
//	if(strApplicability.equals("A") )
		strFileName = "../../eCA/jsp/RecClinicalNotesModalFrame.jsp?"+request.getQueryString();
//	else
//		strFileName = "../../eCA/jsp/RecClinicalNotesModalFrame.jsp?"+request.getQueryString()+"&appl_task_id="+appl_task_id;

	if(rset !=null) rset.close();
	if(stmt!= null ) stmt.close();
}
catch(Exception e)
{
	e.printStackTrace();
	out.println("Exception @ RecClinicalNotesModal"+e.toString());
}
finally
{
		if (con !=null) ConnectionManager.returnConnection(con,request);
}
//IN069251 starts
	if(appl_task_id.equals("REPLY_NOTES")){
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((title==""?"Reply Notes":title)));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}else{ 
//IN069251 ends

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((title==""?"Record Clinical Notes":title)));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}//IN069251	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(!returnFlag)
	{
	 
	if (open_in_normal_yn.equals("Y"))
	{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(queryString.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
	else
	{
		//IN053733 Start.
		if(!"".equals(notifiable_code)){
			session.setAttribute(sessionNFKey, "");
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strFileName));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
		//IN053733 End.
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(queryString.toString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFileName));
            _bw.write(_wl_block19Bytes, _wl_block19);
} //IN053733
            _bw.write(_wl_block20Bytes, _wl_block20);
}}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
