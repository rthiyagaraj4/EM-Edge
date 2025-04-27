package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainlookupmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainLookupMenu.jsp", 1742377586726L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n \t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\n \n <Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCA/js/CAMainMenuLookup.js\' language=\'javascript\'></script>\n <script src=\'../../eCA/js/SwitchLanguage.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n</head>\n<body  OnMouseDown=\'CodeArrest()\' class=\'CA_COMMON\' onKeyDown=\"lockKey()\"> \n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<FORM METHOD=POST ACTION=\"\" name=\"frmMenu\" id=\"frmMenu\">\n<script>\n\tvar objLookupMenu;\n\tobjLookupMenu = new dTree(\'objLookupMenu\');\n\tobjLookupMenu.add(0,-1,\'<font size=2 style=font-weight:bold style=color:#333>\'+getLabel(\"Common.menu.label\",\"Common\")+\'</font>\');\n\tobjLookupMenu.config.useStatusText=true;\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\n\t\t\t\tobjLookupMenu.add(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'<font style=\"font-weight:bold\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font>\',\'\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'\',\'\');\n\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\tdocument.write(objLookupMenu);\n\t\tobjLookupMenu.openAll();\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\tif(parent.CommonToolbar.HideAndShowLookup != null){\n\t\t\t\tparent.CommonToolbar.HideAndShowLookup.style.visibility = \"hidden\";\n\t\t\t}\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</script>\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	int counter = 0;
	StringBuffer strBuffCAMainChart = null;
	StringBuffer detl_sql = new StringBuffer();
	String option_id = "",header_option_id="",option_desc="";
	String executable_name = "",option_type="";
	String respid="",relationcode="",facilityid="";
	PreparedStatement pstmt = null,pstmtMenu=null;
	Connection con = null;
	ResultSet rs = null,rsMenu=null;
	String queryString = request.getQueryString()== null?"":request.getQueryString() ;
	String patient_id = request.getParameter("patient_id");
	String episode_id = request.getParameter("episode_id");
	
	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
   // String pract_type =(String) session.getValue("practitioner_type");
	respid = (String) session.getValue("responsibility_id");
	if(respid == null) respid="";
	//relationcode = (String)session.getValue("relationship_id");
	relationcode = request.getParameter("relationship_id");
	if(relationcode == null) relationcode = "";
	String icon_file_name = "";
	//String patientclass = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	//String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String menu_id = request.getParameter("menuId")==null?"MED_DFLT":request.getParameter("menuId");

            _bw.write(_wl_block7Bytes, _wl_block7);


	//String strSql="SELECT CA_GET_MENU_ID(?,?,?,?) MENU_ID FROM DUAL ";
	if(detl_sql.length() > 0) detl_sql.delete(0,detl_sql.length());

	detl_sql.append(" SELECT  DISTINCT  B.OPTION_ID||B.OPTION_OCCURANCE OPTION_ID  , NVL(NVL(C.USER_DEF_SHORT_DESC,C.SHORT_DESC),(SELECT SHORT_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) OPTION_DESC  , NVL(NVL(C.USER_DEF_LONG_DESC,C.LONG_DESC) ,(SELECT LONG_DESC FROM CA_MENU_HEADER WHERE MENU_ID=b.OPTION_ID)) FUNCTION_NAME  ,'H' MENU_POSITION  , NVL(C.OPTION_TYPE,'M') OPTION_TYPE  , C.EXECUTABLE_NAME  , DECODE(?, a.HEADER_OPTION_ID,'0', a.HEADER_OPTION_ID||B.HEADER_OPTION_OCCURANCE) HEADER_OPTION_ID  , a.ORDER_SEQ_NO  , nvl(C.OPEN_IN_MODAL_WINDOW_YN,'N') OPEN_IN_MODAL_WINDOW_YN   , C.HIST_OR_RECORD ,C.ICON_FILE_NAME    FROM  ( SELECT LEVEL LVL,OPTION_ID,ORDER_SEQ_NO,HEADER_OPTION_ID ,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE   FROM CA_MENU_DETAIL   WHERE MENU_ID=? AND DESKTOP_CHART = 'P'  START WITH HEADER_OPTION_ID=? and HEADER_OPTION_OCCURANCE=1  AND DESKTOP_CHART = 'P' CONNECT BY PRIOR  OPTION_ID=HEADER_OPTION_ID AND  OPTION_OCCURANCE=HEADER_OPTION_OCCURANCE) A  ,(SELECT  DISTINCT OPTION_ID,HEADER_OPTION_ID,HEADER_OPTION_OCCURANCE,OPTION_OCCURANCE FROM CA_MENU_DETAIL  WHERE MENU_ID=?  AND DESKTOP_CHART = 'P' START WITH  MENU_ID=? AND DESKTOP_CHART = 'P' AND OPTION_ID IN (SELECT B.OPTION_ID FROM CA_APPL_TASK a, ca_option b WHERE a.option_id=b.option_id and 'A'=Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS ,?,?,?,?,?)  and (a.BASE_MODULE_ID='CA' or  exists( select 1 from sm_module where install_yn='Y' and MODULE_ID =a.BASE_MODULE_ID )) and B.HIST_OR_RECORD='H'  )  AND DESKTOP_CHART = 'P'   CONNECT BY PRIOR  HEADER_OPTION_ID =OPTION_ID and HEADER_OPTION_OCCURANCE=OPTION_OCCURANCE ) B   , CA_OPTION_LANG_VW C   WHERE A.OPTION_ID=B.OPTION_ID AND A.HEADER_OPTION_ID=B.HEADER_OPTION_ID AND A.HEADER_OPTION_OCCURANCE=B.HEADER_OPTION_OCCURANCE AND A.OPTION_OCCURANCE=B.OPTION_OCCURANCE AND C.OPTION_ID(+)=B.OPTION_ID   AND C.LANGUAGE_ID = ? ORDER BY A.ORDER_SEQ_NO "); 

     
	try
	{
		con = ConnectionManager.getConnection(request);
	
	
	   /*if (!episode_id.equals(""))
		{
			try
			{
				String strSqln1="SELECT SPECIALTY_CODE, PATIENT_CLASS FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=? ";
				pstmtMenu = con.prepareStatement(strSqln1);
				pstmtMenu.setString(1,facilityid);
				pstmtMenu.setString(2,episode_id);
				rsMenu = pstmtMenu.executeQuery();
			
				if(rs.next())
				{
					patientclass = rsMenu.getString("PATIENT_CLASS");
					if(patientclass == null) patientclass = "";
					speciality_code = rsMenu.getString("SPECIALTY_CODE");
					if(speciality_code == null) speciality_code = "";
				}

				if(rsMenu!=null) rsMenu.close();
				if(pstmtMenu!=null) pstmtMenu.close();	
			}
			catch(Exception ew)
			{ 
				ew.printStackTrace() ;
			}
	    }
		pstmtMenu = con.prepareStatement(strSql);
		pstmtMenu.setString(1,speciality_code);
		pstmtMenu.setString(2,patientclass);
		pstmtMenu.setString(3,practitioner_id);
		pstmtMenu.setString(4,pract_type);



		

		rsMenu = pstmtMenu.executeQuery();

		while(rsMenu.next()){
			menu_id = rsMenu.getString("MENU_ID");
		}

		if(menu_id == null) menu_id="MED_DFLT";*/

		pstmt = con.prepareStatement(detl_sql.toString());
		pstmt.setString(1,menu_id);
		pstmt.setString(2,menu_id);
		pstmt.setString(3,menu_id);
		pstmt.setString(4,menu_id);
		pstmt.setString(5,menu_id);
		pstmt.setString(6,respid);
		pstmt.setString(7,relationcode);
		pstmt.setString(8,facilityid);
		pstmt.setString(9,episode_id);
		pstmt.setString(10,patient_id);
		pstmt.setString(11,locale);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			option_id = rs.getString("OPTION_ID");
			header_option_id = rs.getString("HEADER_OPTION_ID");
			option_desc = rs.getString("OPTION_DESC");
			executable_name = rs.getString("EXECUTABLE_NAME");
			if(executable_name == null) executable_name = "";
			icon_file_name = rs.getString("ICON_FILE_NAME") == null ? "" : rs.getString("ICON_FILE_NAME");

			option_type = rs.getString("OPTION_TYPE");	
			counter++;
			if(executable_name != ""){
				strBuffCAMainChart = new StringBuffer();
				strBuffCAMainChart.append("../../eCA/jsp/CAMainChart.jsp?");
				if(executable_name.indexOf("?") != -1){
					strBuffCAMainChart.append("lookupFileName=");	strBuffCAMainChart.append(executable_name.substring(0,executable_name.indexOf("?")));
					strBuffCAMainChart.append("&");	strBuffCAMainChart.append(executable_name.substring(executable_name.indexOf("?")+1,executable_name.length()));
					strBuffCAMainChart.append("&option_id=");
					strBuffCAMainChart.append(option_id);
					strBuffCAMainChart.append("&");
					strBuffCAMainChart.append(queryString);
					strBuffCAMainChart.append("&");
					strBuffCAMainChart.append("Patient_ID=");
					strBuffCAMainChart.append(patient_id);
					//executable_name+="&option_id="+option_id+"&"+queryString;
				}
				else
				{
					strBuffCAMainChart.append("lookupFileName=");	
					strBuffCAMainChart.append(executable_name);	
					strBuffCAMainChart.append("&option_id=");
					strBuffCAMainChart.append(option_id);
					strBuffCAMainChart.append("&");
					strBuffCAMainChart.append(queryString);
					//executable_name+="?"+"option_id="+option_id+"&"+queryString;		
				}
			}
			
			
		
            _bw.write(_wl_block8Bytes, _wl_block8);
if(option_type.equals("M")){
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(header_option_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(option_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(option_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			else
			{
				//nodePoistions +="$"+counter;
				//out.println("unique= "+(patient_id+episode_id+episode_type+counter));
				
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(header_option_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(option_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strBuffCAMainChart.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(option_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((patient_id+counter)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(icon_file_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		if(rs!= null) rs.close();
		if(rsMenu!= null) rsMenu.close();
		if(pstmt!=null) pstmt.close();
		if(pstmtMenu!=null) pstmtMenu.close();
	}
	
	catch(Exception e)
	{
		e.printStackTrace() ;
		//out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
	}

	finally
	{
		if(con!= null) ConnectionManager.returnConnection(con,request);
        	
	}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
if(counter == 0){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
