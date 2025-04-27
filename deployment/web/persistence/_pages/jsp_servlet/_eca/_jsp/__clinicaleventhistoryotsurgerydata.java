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
import java.math.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __clinicaleventhistoryotsurgerydata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventHistoryOTSurgeryData.jsp", 1738424601775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<HEAD>\n\t\t<TITLE> New Document </TITLE>\n\t\t<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n\t\t<META NAME=\"Author\" CONTENT=\"\">\n\t\t<META NAME=\"Keywords\" CONTENT=\"\">\n\t\t<META NAME=\"Description\" CONTENT=\"\">\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventHistoryNew.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/Encounters.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<FORM name=\"\" id=\"\">\n\t\t\t\n\t\t\t\t<table class=\'grid\' cellspacing=0 cellpadding=0 width=\'100%\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<tr id=\'tableTRId";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<td class=\"CAHIGHERLEVELCOLOR\">\n\t\t\t\t\t\t\t<input type=button name=\'collapseButton";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'collapseButton";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\"collapseButton";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\' + \' onclick=\"collapseExpandNew(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\"> &nbsp; \n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>&nbsp;&nbsp; ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </font>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<table width=\'100%\' id=\'tableId";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' style=\"display:none;\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td id=\'tableTDId";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<input type=\'hidden\' name=\'hist_data_type";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'hist_data_type";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/>\n\t\t\t\t\t<input type=\'hidden\' name=\'accessionNum";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'accessionNum";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'/>\n\t\t\t\t\t<input type=\'hidden\' name=\'event_date_time";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'event_date_time";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'/>\n\t\t\t\t\t<input type=\'hidden\' name=\'contr_sys_event_code";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'contr_sys_event_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'/> \n\t\t\t\t\t<input type=\'hidden\' name=\'encounterId";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'encounterId";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'/>\n\t\t\t\t\t<input type=\'hidden\' name=\'facility_id";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'facility_id";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\'url\' id=\'url\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'clinician_id\' id=\'clinician_id\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'/>\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'login_user_id\' id=\'login_user_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'totalRecords\' id=\'totalRecords\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'strNormalcyInd\' id=\'strNormalcyInd\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'selHistType\' id=\'selHistType\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'currentSelectRecorde\' id=\'currentSelectRecorde\' value=\'\'/>\n\t\t\t\n\t\t</FORM>\n\t\t<script>\n\t\t\tmoveScroll(\'1\',\'SUNT\');\n\t\t</script>\n\t</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
	
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
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
21/09/2020  	IN072760	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.9

---------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	session = request.getSession(false);
	Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String ws_no			= (String) p.getProperty( "client_ip_address" )  ;
	String login_user 		= (String) session.getValue("login_user"); 
	String facilityid 		= (String) session.getValue("facility_id");
	String clinician_id		= (String) session.getValue("ca_practitioner_id");
	String resp_id			= (String) session.getValue("responsibility_id");
	String	login_user_id	= (String) session.getValue("login_user");
	
	
	String bean_id			= "NewClinicalEventHistBean" ;
	String bean_name		= "eCA.NewClinicalEventHistBean";
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	
	String selTab			=  request.getParameter("selTab")==null?"":request.getParameter("selTab");
	
	String called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
	String facility_id  	= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String patient_class	= request.getParameter("ql_patClass")==null?"":request.getParameter("ql_patClass");
	String strEncId			= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String abnormal			= request.getParameter("abnormal")==null?"":request.getParameter("abnormal");
	String eventCls			= request.getParameter("eventCls")==null?"":request.getParameter("eventCls");
	String eventGrp			= request.getParameter("eventGrp")==null?"":request.getParameter("eventGrp");
	String eventItem		= request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String reln_id			= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String date_Ordr		= request.getParameter("date_Ordr")==null?"":request.getParameter("date_Ordr");
	String encounterId 		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String strNormalcyInd 	= request.getParameter("normalcy")==null?"I":request.getParameter("normalcy");
	String fromDate 		= request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	String toDate 			= request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	String grphistory_type	= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");
	String selHistType = request.getParameter("selHistType")==null	?"":request.getParameter("selHistType");
	
	System.out.println("facility_id===="+facility_id);
	String ql_ref= request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
	if(!ql_ref.equals(""))
		strNormalcyInd	= request.getParameter("ql_nlcyInd")==null?"I":request.getParameter("ql_nlcyInd");
	if(date_Ordr.equals(""))
		date_Ordr="D";
	String url				= application.getRealPath("/eCA")+"/";
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
	ArrayList searchData = new ArrayList();		
	searchData = bean.getSelectedClinicalNotesDetails(locale,patient_id,facility_id,clinician_id,resp_id,fromDate,toDate,login_user_id,url,selTab,encounterId,date_Ordr,eventCls,eventGrp,eventItem,selHistType,patient_class);//IN071596
	java.util.Date dt = new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	   

            _bw.write(_wl_block9Bytes, _wl_block9);

					 System.out.println("		ClinicalEventHistoryOTSurgeryData.jsp  ----1---->"+formatter.format(dt));  
					int count = 1;
					for(int i=0;i<searchData.size();i++){
						HashMap<String,String>  resultMap= new HashMap<String,String>();
						resultMap = (HashMap<String,String>)searchData.get(i);
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(count));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(count));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(count));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String)resultMap.get("Event_Date_Time")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)resultMap.get("Note_Type_Desc")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)resultMap.get("hist_data_type")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)resultMap.get("accessionNum")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)resultMap.get("Event_Date_Time")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)resultMap.get("contr_sys_event_code")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)resultMap.get("reEncounterId")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)resultMap.get("reFacilityId")));
            _bw.write(_wl_block32Bytes, _wl_block32);

					count++;
					}
					java.util.Date dt1 = new java.util.Date();
					System.out.println("		ClinicalEventHistoryClinicalNoteData.jsp  ----2---->"+formatter.format(dt1));  
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(url));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(selHistType));
            _bw.write(_wl_block40Bytes, _wl_block40);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
