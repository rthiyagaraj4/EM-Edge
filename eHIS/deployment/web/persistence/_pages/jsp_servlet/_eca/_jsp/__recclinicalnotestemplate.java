package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.w3c.dom.*;
import java.sql.*;
import eCA.*;
import eCA.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotestemplate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesTemplate.jsp", 1736742050948L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<?xml version=\'1.0\' encoding=\"UTF-8\"?>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!--IN071264-->\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea.xsl\"?>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea_SplVald.xsl\"?>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingView.xsl\"?>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!--<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingView__SplVald.xsl\"?>--><!--IN063963-->\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingView_SplVald.xsl\"?><!--IN063963-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<DOCUMENT FORM-NAME=\"RecClinicalNotesTemplateForm\" ID=\"RecClinicalNotesTemplateForm\">\n<SITE-SPECIFIC RESTRICT_RIGHT_CLICK=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  FORMULA_COMP_DELETE_ENABLE=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' ></SITE-SPECIFIC><!--IN069884-SITE_SPECIFIC--> <!-- IN072304 -->\n<CSS sStyle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/showModalDialog.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/dchk.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/DateUtils.js\'></SCRIPT><!--Added for IN071708 -->\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart1.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart2.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCommon/js/CommonCalendar.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js\'></SCRIPT>\n<!--included for 10261 in 07/06/09-->\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/SpeciltyEvents.js\'></SCRIPT>\n\n<STYLE type=\"text/css\">\n\t.READONLY\n\t{\n\t\tBACKGROUND-COLOR: #C0C0C0;\n\t}\n</STYLE>\n<STYLE>\n\ttextarea {\n\t  \tresize: none;\n\t}\n</STYLE>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<!-- IN072304 -->\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<HIDDEN-FIELD NAME=\"CACalanderFun\" VALUE=\"Y\"></HIDDEN-FIELD>  \n<HIDDEN-FIELD NAME=\"sec_hdg_code\" VALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"sec_content_type\" VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"child_sec_hdg_code\" VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"child_sec_content_type\" VALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"template_exists\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"template_mode\" VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"patient_id\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"encounter_id\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"systemDate99999A\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"systemDateTime99999A\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"template_title\" VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"dispResLinkHYMLYN\" VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></HIDDEN-FIELD><!--IN061907-->\n<HIDDEN-FIELD NAME=\"locale\" VALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></HIDDEN-FIELD><!--Added for IN071708 -->\n</DOCUMENT>\n\n\n\n\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "application/xml;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("application/xml;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//IN041284 Start.
	String dispResLinkHYMLYN 		=(request.getParameter("dispResLinkHYMLYN")==null)?"N":(String)request.getParameter("dispResLinkHYMLYN");	
	String noteSplCharValidate 		=(request.getParameter("noteSplCharValidate")==null)?"N":(String)request.getParameter("noteSplCharValidate"); //IN059571	
	
//IN069884, starts
ArrayList funcIds = new ArrayList();
funcIds.add("REC_CLI_NTS_RESTRICT_RIGHT_CLK");
funcIds.add("FORMULA_COMP_DELETE_ENABLE");  //IN072304
CaAdapter obj = new CaAdapter();
obj.setSiteSpecific(funcIds,"CA");
String is_ss_restrict_right_click = obj.isSiteSpecific("REC_CLI_NTS_RESTRICT_RIGHT_CLK")?"Y":"N";
String formulaCompDelOptionEnable = obj.isSiteSpecific("FORMULA_COMP_DELETE_ENABLE")?"Y":"N";  //IN072304
//IN069884, ends
if("Y".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){

            _bw.write(_wl_block2Bytes, _wl_block2);

//IN059571 Start. 
}else if("Y".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){

            _bw.write(_wl_block3Bytes, _wl_block3);

}else if("N".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){

            _bw.write(_wl_block4Bytes, _wl_block4);

}else if("N".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){

            _bw.write(_wl_block5Bytes, _wl_block5);

//IN059571 End.
} //IN041284
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

	//StringBuffer traceBeanOBJ = new StringBuffer();

	//traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesTemplate.jsp at 8  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("episode_id")+"**patient_id**"+request.getParameter("patient_id")+"**");

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(is_ss_restrict_right_click));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(formulaCompDelOptionEnable));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Connection			con					=	null;
	PreparedStatement	pstmt				=	null;
	ResultSet			rs					=	null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	boolean	templateExists					=	false;

	String  locale							=	(String) p.getProperty("LOCALE");
	String	templateMode					=	"Insert";
	String	curr_sec_hdg_code				=	"";
	String	curr_section_type				=	"";
	String	curr_child_sec_hdg_code			=	"";
	String	sub_sec_content_type			=	"";
	String	childSecContentType				=	"";
	String	patientId						=	"";
	String	encounter_id					=	"";
	String  systemDateTime					=	""; 
	String  systemDate						=	""; 
	String  template_title						=	""; 
	//
	/*String  DISCR_MSR_ID						=	"";
	String  NUM_REF_LOW						=	"";
	String  NUM_REF_HIGH						=	"";
	String  NUM_CRIT_LOW						=	"";
	String  NUM_CRIT_HIGH						=	"";
	String  START_AGE_DAYS						=	"";
	String  END_AGE_DAYS						=	""; */
	String  dob						=	"";
	String  sex						=	"";
	
	
	
	
	StringBuffer contentXML=new StringBuffer();

	try
	{
	con	= ConnectionManager.getConnection(request);
	String query1 = " Select  to_char(sysdate, 'dd/mm/yyyy hh24:mi') systemDateTime, to_char(sysdate, 'dd/mm/yyyy') systemDate  from dual  ";
	pstmt		=	con.prepareStatement(query1);
	rs			=	pstmt.executeQuery();

	if(rs.next())
	{
		systemDateTime		= rs.getString("systemDateTime");
		systemDate			= rs.getString("systemDate");
	}
	
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();

	curr_sec_hdg_code		= (request.getParameter("curr_sec_hdg_code")==null)?"":request.getParameter("curr_sec_hdg_code");
	curr_section_type		= (request.getParameter("curr_section_type")==null)?"":request.getParameter("curr_section_type");
	curr_child_sec_hdg_code = (request.getParameter("curr_child_sec_hdg_code")==null)?"":request.getParameter("curr_child_sec_hdg_code");
	template_title = (request.getParameter("template_title")==null)?"":request.getParameter("template_title");
	patientId				= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id			= (request.getParameter("episode_id")==null)?"":request.getParameter("episode_id");
	sex			= (request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	dob			= (request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	//IN071264 Starts
	String auto_save_yn ="N";
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	String existingContentXMLTemp	=	"";
	String beanContentXMLTemp	=	"";
	//IN071264 Ends
	String existingContentXML	=	"";
	String beanContentXML	=	"";
	String ageDependentCompIds = "",compDependentAgeGrps="";
	
	String strKey	=	"";

	strKey = patientId + "~"+ encounter_id;
	strKey = strKey.trim();
	
	sectionBean.getPatientSection(strKey);
	
	if(curr_section_type.equals("T") )
	{
		//IN071264 Starts
		// existingContentXML=(String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
		  if("Y".equals(auto_save_yn)){
			 existingContentXMLTemp=(String)sectionBean.getSectionContent("temp"+curr_sec_hdg_code,"temp"+curr_child_sec_hdg_code);
		 }
		 if(null!=existingContentXMLTemp && !"".equals(existingContentXMLTemp)){
			 existingContentXML =existingContentXMLTemp;
		 }
		 else{
			 existingContentXML=(String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
		 }
		//IN071264 Ends

		
		if(existingContentXML == null)
			existingContentXML = "";

		
		sub_sec_content_type = sectionBean.getSectionLevel(curr_sec_hdg_code,curr_child_sec_hdg_code);

	}

	//traceBeanOBJ.append("existingContentXML  ..."+existingContentXML);	

	if(existingContentXML!=null && !existingContentXML.equals(""))
	{		
		eCA.DomParser parser = new eCA.DomParser();
		StringBuffer sectionContentXML = new StringBuffer(existingContentXML);		
		sectionContentXML = parser.updateXMLLanguageIDValues(sectionContentXML, locale);
		existingContentXML = sectionContentXML.toString();		
		
		//[IN032326]existingContentXML = existingContentXML.replaceAll("&lt;br&gt;","");
		contentXML.append(existingContentXML);
		templateMode	=	"Update";
		templateExists =   true;
	}

		
		if(templateMode.equals("Insert"))//get the XML content from the master table 
		{
			
			String query = " Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ";

			pstmt =	con.prepareStatement(query);
								
			if(sub_sec_content_type.equals("S") && curr_section_type.equals("T"))
				
				pstmt.setString(1,curr_child_sec_hdg_code);
			
			else if(curr_section_type.equals("T"))
			
				pstmt.setString(1,curr_sec_hdg_code);
			
			rs	= pstmt.executeQuery();			
			
			if(rs.next())
			{
				ageDependentCompIds = rs.getString(1)==null?"":rs.getString(1); 
				compDependentAgeGrps = rs.getString(2)==null?"":rs.getString(2);
				Clob clb = rs.getClob(3);				

				if(clb!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
					String line = null;

					while((line=r.readLine()) != null) 
					{
						contentXML.append(line);
					}
				}

				
			}
			
	
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
	
			if(!ageDependentCompIds.equals(""))
			{
				
				
				String functionSQL = "Select ca_comp_visibility(?,?) from dual";
				pstmt =con.prepareStatement(functionSQL);
				pstmt.setString(1,compDependentAgeGrps);
				pstmt.setString(2,patientId);
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					String ageDependentResults = rs.getString(1);
					
					
					eCA.AgeGroupCodeDependencyParser ageGroupBeanObj=new eCA.AgeGroupCodeDependencyParser();
					contentXML = ageGroupBeanObj.removeAgeDependentComponents(contentXML,ageDependentCompIds,ageDependentResults);
				}
				
			}
	
		/*	if (!locale.equals("en"))
			{
				if ((contentXML != null) && !(contentXML.toString().equals(""))){
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,curr_sec_hdg_code,locale,contentXML);
					contentXML = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}		
			if(curr_section_type.equals("T"))
			{			
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{							
					eCA.TemplateRangeParser tempRangeParse = new eCA.TemplateRangeParser(con,curr_sec_hdg_code,sex,dob,contentXML);
					contentXML = tempRangeParse.getRangePlacedXML();
					tempRangeParse = null; 							
				}
			} */

			if (!locale.equals("en") && curr_section_type.equals("T"))
			{
				HashMap<String,String> paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",curr_sec_hdg_code);
				paramMap.put("LOCALE",locale);
				paramMap.put("SEX",sex);
				paramMap.put("DOB",dob);
				paramMap.put("RANGE_PASER_YN","Y");
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,contentXML);
					contentXML = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}else if(curr_section_type.equals("T"))
			{			
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{							
					eCA.TemplateRangeParser tempRangeParse = new eCA.TemplateRangeParser(con,curr_sec_hdg_code,sex,dob,contentXML);
					contentXML = tempRangeParse.getRangePlacedXML();
					tempRangeParse = null; 							
				}
			} 
				
			
			if(curr_section_type.equals("T"))
				sectionBean.setSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code,contentXML.toString());		
				
				putObjectInBean("sectionBean",sectionBean,session);

				beanContentXML = (String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
				
				if(contentXML.length() > 0){
					contentXML.delete(0,contentXML.length());
				}
				contentXML.append(beanContentXML);

			//	traceBeanOBJ.append("curr_section_type  ..."+curr_section_type+"...ContentXML in NotesTemplate at 216 ..."+sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code));
			templateExists =   true;
		}
		else if(templateMode.equals("Update"))//get the content from the bean and display 
		{
			if (! locale.equals("en") )
			{
				HashMap<String,String> paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",curr_sec_hdg_code);
				paramMap.put("LOCALE",locale);				
				paramMap.put("RANGE_PASER_YN","N");
				eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,contentXML);
			//	contentXML = tempLangParse.getLangReplacedXML(); //Commentted --[IN033507]
				tempLangParse = null;
			}

		}
		
		System.out.println("************* Content XML **********  "+contentXML.toString());
			

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(
		
		(contentXML.toString()).replaceAll("<FORMULA-COMP", "<FORMULA-COMP FORMULA_COMP_DELETE_ENABLE='"+formulaCompDelOptionEnable+"'")
		
		));
            _bw.write(_wl_block12Bytes, _wl_block12);

		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		//out.println("Exception@2: "+e);//common-icn-0181
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);


	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(childSecContentType));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(templateExists));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(templateMode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(systemDate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(systemDateTime));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(template_title));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dispResLinkHYMLYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
