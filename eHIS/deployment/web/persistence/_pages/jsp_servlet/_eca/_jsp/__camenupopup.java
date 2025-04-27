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
import java.awt.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camenupopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMenuPopup.jsp", 1734514895333L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n\t <!-- <script src=\'../../eCA/js/SwitchBetPatChart.js\' language=\'javascript\'></script><!--IN32540 IE 9 Fix -->\n      ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n        ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n\t\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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

/*
--------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
26/08/2015	IN0052635			Vijayakumar K	26/08/2015		Ramesh Goli			PMG2014-CRF-0020 [IN:052635]
29/12/2015	ICON_COUNT_ISSUE	Vijayakumar K	29/12/2015		Ramesh Goli			Icon count improper
--------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
		String styleMap = "";
		if(sStyle.equals("IeStyleBlue.css"))
		{
			styleMap = "Blue";
		}
		else if(sStyle.equals("IeStyleLime.css"))
		{
			styleMap = "Lime";
		}
		else if(sStyle.equals("IeStyleOrange.css"))
		{
			styleMap = "Orange";
		}
		else if(sStyle.equals("IeStyleVoilet.css"))
		{
			styleMap = "Violet";
		}
		else
		{
			styleMap = "";
		}
		
		Connection con=null;
		PreparedStatement pstmt = null; 
		PreparedStatement pstmtOption = null; 
		PreparedStatement pstmtMenuid = null; 
		ResultSet rsltMnu=null;
		ResultSet rsSelfMnu=null;
		ResultSet rsMenuid=null;
		

            _bw.write(_wl_block5Bytes, _wl_block5);
            eCA._ca_license_rights keyGen= null;{
                keyGen=(eCA._ca_license_rights)pageContext.getAttribute("keyGen");
                if(keyGen==null){
                    keyGen=new eCA._ca_license_rights();
                    pageContext.setAttribute("keyGen",keyGen);
                    _bw.write(_wl_block6Bytes, _wl_block6);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

			
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

		String locale					=	(String) p.getProperty("LOCALE");
		
						
		String respid= (String) session.getValue("responsibility_id");
		 if(respid == null) respid="";
						 
		String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
		
		String total_icon_records = request.getParameter("total_icon_records")==null?"":request.getParameter("total_icon_records");
		String from = request.getParameter("from")==null?"0":request.getParameter("from");
		String to = request.getParameter("to")==null?"":request.getParameter("to");
		String totMenuDisplay = request.getParameter("totMenuDisplay")==null?"":request.getParameter("totMenuDisplay");
		
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String episode_id = request.getParameter("episode_id");
		String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");
		String relationcode="",facility_id="";
		relationcode = request.getParameter("relationship_id");
		String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		String default_yn = "", icon_file_name = "";
		String option_id = "";	
		StringBuffer icons = new StringBuffer("");
		StringBuffer strOption = new StringBuffer();
		String queryString = request.getQueryString()== null?"":request.getQueryString() ;
		String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
		facility_id = (String)session.getValue("facility_id");
		String pract_type =(String) session.getValue("practitioner_type");
		String limit_function_id = request.getParameter("limit_function_id") == null? "" : request.getParameter("limit_function_id");
		boolean pat_sel = false ;
		if( patient_id!=null || episode_id != null )
			pat_sel = true;
		
		int iFrom = 0;
		int iTo = 0;
		
		iFrom = Integer.parseInt(from);
		iTo = Integer.parseInt(to);
				
		int iStart = 0 ;
		int iEnd = 0 ;
		if(iFrom == 0)
			iStart = 1;
		else
			iStart = iFrom;
		
		iEnd = iTo;
		
		int iTotMenuDisplay	= Integer.parseInt(totMenuDisplay);
		int iTotal_icon_records = Integer.parseInt(total_icon_records);

		String option_desc="";
		String executable_name = "";
		String function_id="",function_name="";
		
		StringBuffer pat_icons_sql = new StringBuffer("");
		StringBuilder extraIcons = new StringBuilder();
		
		
		String strMenuId = "SELECT CA_GET_MENU_ID(?,?,?,?,?) MENU_ID FROM DUAL ";
		
		
		
		
		boolean Self_menu_exists = false;
		strOption.append("SELECT '1' FROM ca_custom_option a WHERE practitioner_id = ? and exists (select '1' from ca_option where option_id = a.option_id ");
		if(!patient_id.equals(""))
		{
			strOption.append(" AND DESKTOP_YN = 'N' )" );
		}
		else
		{
			strOption.append(" AND DESKTOP_YN = 'Y' )");
		}

		
	
		try{
			con = ConnectionManager.getConnection(request);
		
			if(!patient_id.equals(""))
			{
		
				pstmtMenuid = con.prepareStatement(strMenuId);
				pstmtMenuid.setString(1,speciality_code);
				pstmtMenuid.setString(2,patient_class);
				pstmtMenuid.setString(3,practitioner_id);
				pstmtMenuid.setString(4,pract_type);
				pstmtMenuid.setString(5,facility_id);
		

				try
				{
					rsMenuid = pstmtMenuid.executeQuery();
							
					if(rsMenuid.next())
					{
						menu_id = rsMenuid.getString("MENU_ID");
					}
					if(rsMenuid!=null) rsMenuid.close();
					if(pstmtMenuid!=null) pstmtMenuid.close();	
				
				}
				catch(Exception ew)
				{ 
				
				}
			}
				
			pstmtOption = con.prepareStatement(strOption.toString());
			pstmtOption.setString(1,practitioner_id);
			rsSelfMnu = pstmtOption.executeQuery();

			if(rsSelfMnu.next())
			{
				Self_menu_exists = true;
			}
			if(rsSelfMnu != null) rsSelfMnu.close();
			if(pstmtOption != null) pstmtOption.close();
		
		
			pat_icons_sql.append(" SELECT    DISTINCT  B.OPTION_ID||B.OPTION_OCCURANCE OPTION_ID  , B.OPTION_ID ONLY_OPTION_ID, NVL(C.USER_DEF_LONG_DESC,C.LONG_DESC)  SHORT_DESC  , C.EXECUTABLE_NAME  , DECODE(?, a.HEADER_OPTION_ID,'0', a.HEADER_OPTION_ID||B.HEADER_OPTION_OCCURANCE) HEADER_OPTION_ID  , a.ORDER_SEQ_NO  , nvl(C.OPEN_IN_MODAL_WINDOW_YN,'N') OPEN_IN_MODAL_WINDOW_YN   , C.HIST_OR_RECORD ");
		
			if(Self_menu_exists)
				pat_icons_sql.append(" , NVL((SELECT 'Y' FROM ca_custom_option WHERE PRACTITIONER_ID = ? AND OPTION_ID = B.OPTION_ID ),'N') default_yn ");
			else
				pat_icons_sql.append("  , C.Dflt_toolbar_option_yn default_yn ");
				
			pat_icons_sql.append(" , C.ICON_FILE_NAME FROM  ( SELECT LEVEL LVL,OPTION_ID,ORDER_SEQ_NO,HEADER_OPTION_ID ,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE   FROM CA_MENU_DETAIL   WHERE MENU_ID=?  ");
			
			if(!patient_id.equals(""))
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'P' " );
			}
			else
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'D' ");
			}
			pat_icons_sql.append(" START WITH HEADER_OPTION_ID=? and HEADER_OPTION_OCCURANCE=1 " );
			
			if(!patient_id.equals(""))
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'P' " );
			}
			else
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'D' ");
			}
			
			pat_icons_sql.append(" CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID AND  OPTION_OCCURANCE=HEADER_OPTION_OCCURANCE) A  ,(SELECT  DISTINCT OPTION_ID,HEADER_OPTION_ID,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE FROM CA_MENU_DETAIL  WHERE MENU_ID=? "); 
		
			if(!patient_id.equals(""))
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'P' " );
				
				if((keyGen.getKey()).equals("CABASIC"))
					pat_icons_sql.append(" AND OPTION_ID not in ( 'CLINICAL_NOTES' ,'CLINICAL_NOTES_NEW','PATCHIEFCOMPLAINT','REL_PAT_TREAT_PAT','CA_TASK_LIST','CA_TASK_LIST_DT')" );
							
			}
			else
			{
				if((keyGen.getKey()).equals("CABASIC"))
					pat_icons_sql.append(" AND OPTION_ID not in ( 'CA_TASK_LIST','REL_PAT_TREAT','CA_TASK_LIST_DT')" );
				pat_icons_sql.append(" AND DESKTOP_CHART = 'D' ");
			}
			
			pat_icons_sql.append(" START WITH MENU_ID=? AND ");
			
			if(!patient_id.equals(""))
			{
				pat_icons_sql.append(" DESKTOP_CHART = 'P' " );
			}
			else
			{
				pat_icons_sql.append("  DESKTOP_CHART = 'D' ");
			}
			pat_icons_sql.append(" AND OPTION_ID IN (SELECT B.OPTION_ID FROM CA_APPL_TASK a, ca_option b WHERE a.option_id=b.option_id and 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?) and (a.BASE_MODULE_ID='CA' or  exists( select 1 from sm_module where install_yn='Y' and MODULE_ID =a.BASE_MODULE_ID ");
			
			if(!patient_id.equals(""))
			{
				pat_icons_sql.append("  and ( MODULE_GROUP_ID!='SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID =a.BASE_MODULE_ID AND  SPECIALITY_CODE =? )) ");
			}

			pat_icons_sql.append(" )) "); 
					
			if (patient_id.equals("") )
			{
				pat_icons_sql.append(" and b.DESKTOP_YN='Y' ");
			}
			else
			{
				if (mode.equals("V"))
					pat_icons_sql.append(" and B.HIST_OR_RECORD='H' ");
				if (patient_class.equals(""))
				{
					patient_class="XT";
				}
				pat_icons_sql.append(" and b.APPL_"+patient_class+"_YN='Y' ");
			}

			pat_icons_sql.append(" ) "); 

			if(!patient_id.equals("") )
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'P' " );
			}
			else
			{
				pat_icons_sql.append(" AND DESKTOP_CHART = 'D' ");
			}

			pat_icons_sql.append("  CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID and HEADER_OPTION_OCCURANCE=OPTION_OCCURANCE ) B   , CA_OPTION_LANG_VW C   WHERE C.LANGUAGE_ID = ?  AND A.OPTION_ID=B.OPTION_ID AND A.HEADER_OPTION_ID=B.HEADER_OPTION_ID AND A.HEADER_OPTION_OCCURANCE=B.HEADER_OPTION_OCCURANCE AND A.OPTION_OCCURANCE=B.OPTION_OCCURANCE AND C.OPTION_ID(+)=B.OPTION_ID  ");
							
			if(Self_menu_exists)
				pat_icons_sql.append(" and NVL((SELECT 'Y' FROM ca_custom_option WHERE PRACTITIONER_ID = ? AND OPTION_ID = B.OPTION_ID ),'N') = 'Y' ");
			else
				pat_icons_sql.append(" and C.Dflt_toolbar_option_yn = 'Y' ");

			pat_icons_sql.append("ORDER BY A.ORDER_SEQ_NO ");
			
			
			pstmt = con.prepareStatement(pat_icons_sql.toString());
			int pstmtindex =1;
			
			pstmt.setString(pstmtindex++,menu_id);
			
			if(Self_menu_exists)
			{
				pstmt.setString(pstmtindex++,practitioner_id);
			}
			pstmt.setString(pstmtindex++,menu_id);
			pstmt.setString(pstmtindex++,menu_id);
			pstmt.setString(pstmtindex++,menu_id);
			pstmt.setString(pstmtindex++,menu_id);
			pstmt.setString(pstmtindex++,respid);
			pstmt.setString(pstmtindex++,relationcode);
			pstmt.setString(pstmtindex++,facility_id);
			pstmt.setString(pstmtindex++,episode_id);
			pstmt.setString(pstmtindex++,patient_id);
			
			if(!patient_id.equals(""))
			{
				pstmt.setString(pstmtindex++,speciality_code);
			}
			
			pstmt.setString(pstmtindex++,locale);
			
			if(Self_menu_exists){
				
				pstmt.setString(pstmtindex++,practitioner_id);
				}
			
			
			rsltMnu = pstmt.executeQuery();
			
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			int counticons = 0;
				
			int i = 0;
			if(rsltMnu != null)
			{
				
				extraIcons.append("<table border='0' align='left' cellpadding='0' cellspacing='0'><tr class='iconBarRow"+styleMap+"'>");
				

				
				while(rsltMnu.next() && (i) < iEnd)
				{
					
					
					if(iStart != 1 && (i+1) <iStart){
					i++;
					continue;
					}
					else i++;
					counticons++;
					if(i<=iEnd){
				
				
						option_desc = rsltMnu.getString("SHORT_DESC")==null?"":rsltMnu.getString("SHORT_DESC");
							
						option_id = rsltMnu.getString("OPTION_ID")==null?"":rsltMnu.getString("OPTION_ID");
				
						executable_name = rsltMnu.getString("EXECUTABLE_NAME");
						icon_file_name = rsltMnu.getString("ICON_FILE_NAME")==null?"":rsltMnu.getString("ICON_FILE_NAME");

						
						if(executable_name != null)
						{
							if(executable_name.indexOf("?") != -1)
							{
								executable_name=executable_name + "&option_id="+option_id+"&"+queryString;
							}
							else
							{
								executable_name=executable_name+"?"+"option_id="+option_id+"&"+queryString;
							}
						}
						
						extraIcons.append("<td><a href='#' class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/"+icon_file_name+"' id='"+option_id+"' onclick=~callFunction('"+option_id+"','"+option_desc+"','"+executable_name+"')~  alt='"+option_desc+"' title='"+option_desc+"'></img></a></td>");
						

					
					}
								
					
				}
				}
				
				//iFrom += iTotMenuDisplay;
				//iTo += iTotMenuDisplay;
				
				//iTotMenuDisplay -= 1;
				if(iStart!=1)
					extraIcons.append("<td class='iconBar'><a href='#' class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/eca_icon_previous.jpeg' id='previous' onclick=~callMenuIcons('&limit_function_id="+limit_function_id+"&menuId="+menu_id+"','"+(iStart-iTotMenuDisplay)+"','"+(iEnd-iTotMenuDisplay)+"','"+iTotal_icon_records+"','Previous')~  alt='Previous' title='Previous'></img></a></td>");
				
				
				//ICON_COUNT_ISSUE starts
				//if(counticons>iTotMenuDisplay)
				if(iEnd<iTotal_icon_records)
				//ICON_COUNT_ISSUE ends
					extraIcons.append("<td class='iconBar'><a href='#' class='imageClass1' onmouseover='hotStateImage(this)' onmouseout='restorePrevState(this)'><img src='../../eCA/images/eca_icon_next.jpeg' id='next' onclick=~callMenuIcons('&limit_function_id="+limit_function_id+"&menuId="+menu_id+"','"+(iStart+iTotMenuDisplay)+"','"+(iEnd+iTotMenuDisplay)+"','"+iTotal_icon_records+"','Next')~  alt='Next' title='Next'></img></a></td>");
				extraIcons.append("</tr></table>");
				String finalString = extraIcons.toString();
			
            _bw.write(_wl_block9Bytes, _wl_block9);

			//out.println("<script>alert();parent.CommonToolbar.displayIcons('"+finalString+"');</script>");
			out.println(finalString);
			if(rsltMnu!= null) rsltMnu.close();
			if(pstmt!=null) pstmt.close();
	
		}
		catch(Exception ex)
		{}
	}
	catch(Exception menuexp)
	{
		menuexp.printStackTrace();
	}
	finally
	{
		try
		{	
			if(rsSelfMnu != null) rsSelfMnu.close();
			if(rsltMnu!= null) rsltMnu.close();
			if(pstmt!=null) pstmt.close();
		
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			//out.println("Exception in CAMenuPopup.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
