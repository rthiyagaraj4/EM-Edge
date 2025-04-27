package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recmaternityconscontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecMaternityConsControl.jsp", 1709116207715L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\' />\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<body onKeyDown=\'lockKey()\'>\n\t\t<form name=\'RecMaternityControlForm\' id=\'RecMaternityControlForm\' method=\'post\'>\n\t\t\t<input type=\'hidden\' name=\'prevSecHdgCode\' id=\'prevSecHdgCode\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\n\t\t</form>\n\t</body>\n</html>\n<script>\nif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' == \'Y\' || \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' == \'\')\n{\n\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'==\'V\')\n\t{\t\t\n\t\tparent.recMatConsDetailsFrame.location.href = \'../../eCA/jsp/RecMaternityConsView.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t}\n\telse\n\t{\t\t\n\t\tparent.recMatConsDetailsFrame.location.href = \'../../eCA/jsp/RecMaternityConsDetailPage.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t}\n}\nelse\n{\t\n\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' == \'Y\')\n\t{\n\t//parent.recMatConsDetailsFrame.location.href = \'../../eCA/jsp/RecMaternityConsDetailPage.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t//setTimeout(\'\',3000);\n\t//alert(\"page loaded...\"+parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.closeFlag.value);\n\n//\thtmlVal = \"<html><form name=\'tempForm\' id=\'tempForm\' enctype=\'multipart/form-data\' action=\'../../servlet/eCA.RecMaternityConsServlet?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' method=\'post\'><input type=\'hidden\' name=\'closeFlag\' id=\'closeFlag\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'><input type=\'hidden\' name=\'close_episode_yn\' id=\'close_episode_yn\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><input type=\'hidden\' name=\'outcome_event_code\' id=\'outcome_event_code\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><input type=\'hidden\' name=\'outcome_code\' id=\'outcome_code\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'></form></html>\";\n\thtmlVal = \"<html><form name=\'tempForm\' id=\'tempForm\' enctype=\'multipart/form-data\' action=\'../../servlet/eCA.RecMaternityConsServlet?moduleId=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&patientId=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&sectionType=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&cycle_no=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&splty_event_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&splty_task_code=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&accessionNum=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&closeFlag=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&close_episode_yn=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&outcome_event_code=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&outcome_code=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' method=\'post\'></form></html>\";\n\t\tparent.recMatConsBlankFrame.document.write(htmlVal);\n\t\tparent.recMatConsBlankFrame.document.tempForm.submit();\n\t\n\t}\n\t//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.closeFlag.value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\t\n\t//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.close_episode_yn.value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\t\n\t//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.outcome_event_code.value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\';\t\n\t//parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.outcome_code.value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\';\t\n else {\n\t// alert(\"In closeFlag Else \");\nparent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action=\'../../servlet/eCA.RecMaternityConsServlet\';\n\tparent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target=\'messageFrame\';\n\tparent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method=\'post\';\n\tparent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();\n }\n}\n</script>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );
	
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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean matBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);	



            _bw.write(_wl_block3Bytes, _wl_block3);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

		/*java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;		//Ramesh
		String locale = (String) p.getProperty("LOCALE");									//Ramesh*/

		String sectionType = request.getParameter("sectionType") == null ? "" : request.getParameter("sectionType");
		String moduleId = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		String cycle_no = request.getParameter("cycle_no") == null ? "0" : request.getParameter("cycle_no");
		String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
		String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
		String accessionNum = request.getParameter("accession_number") == null ? "" : request.getParameter("accession_number");
		
		/*****/
		String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");//[CRF-118]

		String tabClick = request.getParameter("tabClick") == null ? "" : request.getParameter("tabClick");
		String modeValue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
		String ageDependentCompIds = "";
		String compDependentAgeGrps = "";
		String ageDependentResults = "";
		String prevSecHdgCode = request.getParameter("prevSecHdgCode") == null ? "" : request.getParameter("prevSecHdgCode");
		String prevSubSecHdgCode = request.getParameter("prevSubSecHdgCode") == null ? "" : request.getParameter("prevSubSecHdgCode");
		String 	grid_component_ids					=		request.getParameter("grid_component_ids");
		 if(grid_component_ids==null) grid_component_ids="";
		String   no_of_rows							=		request.getParameter("no_of_rows");
		
		if(no_of_rows==null) no_of_rows="";

			 

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		eCA.DomParser parser = new eCA.DomParser();
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
		String  locale = (String) p.getProperty("LOCALE");

		Hashtable htParameter=new Hashtable();

		String secHdgCode = request.getParameter("sec_hdg_code") == null ? "" : request.getParameter("sec_hdg_code");
		String subSecHdgCode = request.getParameter("sub_sec_hdg_code") == null ? secHdgCode :  request.getParameter("sub_sec_hdg_code");
		String closeFlag = request.getParameter("closeFlag") == null ? "N" :  request.getParameter("closeFlag");

		String close_episode_yn = request.getParameter("close_episode_yn") == null ? "" :  request.getParameter("close_episode_yn");
		String outcome_event_code = request.getParameter("outcome_event_code") == null ? "" :  request.getParameter("outcome_event_code");
		String outcome_code = request.getParameter("outcome_code") == null ? "" :  request.getParameter("outcome_code");
		String contentXML = "";

		
		//out.println("secHdgCode ="+secHdgCode+"=  subSecHdgCode="+subSecHdgCode+"=");
		Enumeration enumParameter=request.getParameterNames();
		String parameterName="";
		String parameterValue="";
			
		while(enumParameter.hasMoreElements())
		{
			parameterName=(String)enumParameter.nextElement();
			parameterValue = request.getParameter(parameterName) == null  ? "" : request.getParameter(parameterName);
			htParameter.put(parameterName, parameterValue);
			

		}
		
		if(tabClick.equals("Y") || tabClick.equals(""))
		{			

			if(!prevSecHdgCode.equals("") && !prevSubSecHdgCode.equals(""))
			{
				contentXML = (String)matBean.getSectionContent(prevSecHdgCode,prevSubSecHdgCode);

			}

			StringBuffer xmlContent = new StringBuffer();
			StringBuffer sectionContentXML = new StringBuffer();
			
			try
			{
				con = ConnectionManager.getConnection(request);

				if(contentXML == null || contentXML.equals("") || contentXML.equals(" "))
				{
					pstmt = con.prepareStatement(" Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ");				
				
					if(prevSubSecHdgCode.equals("") )
						pstmt.setString	(1,subSecHdgCode);
					else
						pstmt.setString	(1,prevSubSecHdgCode);

					res = pstmt.executeQuery();
					if(res.next())
					{
						ageDependentCompIds = res.getString("AGE_GRP_DEP_COMP_INFO") == null ? "" : res.getString("AGE_GRP_DEP_COMP_INFO");
						compDependentAgeGrps = res.getString("DEP_AGE_GRP_INFO") == null ? "" : res.getString("DEP_AGE_GRP_INFO");
						Clob tmplFormat = res.getClob("TEMPLATE_FORMAT");

						if(tmplFormat != null)
						{

							/*java.io.Reader r = tmplFormat.getCharacterStream();
							char sbuf[] = new char[255];
							int i=0;
							while((i = r.read(sbuf)) != -1) */
							java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
							String line = null;

							while((line=r.readLine()) != null) 
							{
								//xmlContent.append(sbuf,0,i);
								xmlContent.append(line);
							}
						}
					}//end of if - 1
				
					if(res != null) res.close();
					if(pstmt != null) pstmt.close();

					PreparedStatement psAge = null;
					ResultSet rsAge = null;

					if(!ageDependentCompIds.equals(""))
					{
						psAge =con.prepareStatement("Select ca_comp_visibility(?,?) from dual");
						psAge.setString(1,compDependentAgeGrps);
						psAge.setString(2,patientId);
						rsAge = psAge.executeQuery();
						
						if(rsAge.next())
						{
							ageDependentResults = rsAge.getString(1);
							eCA.AgeGroupCodeDependencyParser ageGroupBeanObj=new eCA.AgeGroupCodeDependencyParser();
							xmlContent = ageGroupBeanObj.removeAgeDependentComponents(xmlContent,ageDependentCompIds,ageDependentResults);
						}
						
						if(rsAge!=null) rsAge.close();
						if(psAge!=null) psAge.close();
					}//end f if ageDependentCompIds

					contentXML = xmlContent.toString();
					
				}//end of if contentXML

				//out.println("contentXML ="+contentXML+"=");
				//sectionContentXML.append(contentXML);
				//out.println("sectionContentXML ="+sectionContentXML.toString()+"=");
//				String tempStr = (String) matBean.getSectionContent(prevSecHdgCode,prevSubSecHdgCode);

				 if(!grid_component_ids.equals(""))
				{	
					 
					eCA.GridComponent gridComp = new eCA.GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();			
					gridComp = null;
				}

				sectionContentXML.append(contentXML);	

				//out.println("sectionContentXML later ="+sectionContentXML.toString()+"=");

				StringBuffer sectionContentUpdatedXML=new StringBuffer();
				if(!sectionContentXML.toString().equals("")&&!sectionContentXML.toString().equals(" "))
				{
					//***************************** [CRF-118] Start *****************************					
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
					paramHash.put("#p_patient_id#",patientId);
					paramHash.put("#p_encounter_id#",encounter_id);
					paramHash.put("#p_accNum#",accessionNum);
					paramHash.put("#p_locale#",locale);
					tempParameter = dynamicCompDetails.getDynamicCompDetails(sectionContentXML,paramHash);
					if(tempParameter.size()>0){					
					htParameter.putAll(tempParameter);
					}
					//*****************************[CRF-118] Ends *****************************
					sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);

					parser=null;
					if(!prevSecHdgCode.equals("") && !prevSubSecHdgCode.equals(""))
					{
						
		//				matBean.setSectionValues(prevSecHdgCode,prevSubSecHdgCode,"","","","","","", "","", sectionContentUpdatedXML.toString(), "");
						matBean.setSectionContent(prevSecHdgCode,prevSubSecHdgCode,sectionContentUpdatedXML.toString());
					}
					putObjectInBean("matBean",matBean,session);
				}
				//tempStr = (String) matBean.getSectionContent(prevSecHdgCode,prevSubSecHdgCode);
			}//end of try
			catch(Exception e)
			{
				e.printStackTrace();
				
				//out.println("Exception in try of RecMaternityConsControl.jsp --"+e.toString());//COMMON-ICN-0181			
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
		}//end of if tabClick
		else
		{
			if(!closeFlag.equals("Y"))
				{
				contentXML = (String)matBean.getSectionContent(secHdgCode,subSecHdgCode);

				StringBuffer sectionContentXML = new StringBuffer();
				
				 if(!grid_component_ids.equals(""))
				{
					eCA.GridComponent gridComp = new eCA.GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();
					gridComp = null;
				}

				sectionContentXML.append(contentXML);
				StringBuffer sectionContentUpdatedXML=new StringBuffer();
			
				if(!sectionContentXML.toString().equals("")&&!sectionContentXML.toString().equals(" "))
					{

						sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);
						parser=null;
						matBean.setSectionContent(secHdgCode,subSecHdgCode,sectionContentUpdatedXML.toString());
						putObjectInBean("matBean",matBean,session);
					}
				
				}
		}
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(prevSecHdgCode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(tabClick));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tabClick));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(modeValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(closeFlag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(closeFlag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(close_episode_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(outcome_event_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(outcome_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sectionType));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(splty_event_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(closeFlag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(close_episode_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(outcome_event_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(outcome_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(closeFlag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(close_episode_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(outcome_event_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(outcome_code));
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
