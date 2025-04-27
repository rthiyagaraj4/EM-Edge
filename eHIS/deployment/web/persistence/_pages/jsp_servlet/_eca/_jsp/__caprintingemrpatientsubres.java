package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eOR.Common.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __caprintingemrpatientsubres extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAPrintingEmrPatientSubRes.jsp", 1738424464936L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  \t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'type=\'text/css\' />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/CAPrintingEmrPatient.js\'> </script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ClinicEventParameter.js\'> </script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n<link rel=\"stylesheet\" type=\"text/css\"\n\thref=\"../../eCommon/html/CommonCalendar.css\" />\n<style>\n\t.test{\n\t\tposition:relative;\n\t\tdisplay:block;\n\t}\n\t\t.overlay {\n\t  background: white;\n\t  position: absolute;\n\t  display: block;\n\t }\n</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\"CAPrintingEmrPatientSubRes\" id=\"CAPrintingEmrPatientSubRes\" action=\'../../eOR/jsp/NewProcedureQueryResult.jsp\' method=\"post\">\n\t\t<table width=\"90%\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<input type=\'checkbox\' name=\'select_all\' id=\'select_all\' value=\'N\' ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" onClick=\"selectAll(this,\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\tSelect All\n\t\t\t</td>\n\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<td><input type=\'checkbox\' name=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="_yn\' id=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="_yn\' value=\'N\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" onClick=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');clntParentCheckBox(this,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\"></td>\n\t\t\t\t\n\t\t\t\t<td>\n\t\t\t\t\t<table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td nowrap id=\'orderctl";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' style=\'cursor:pointer\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="onClick=\"displayToolTip1(this,\'imgArrow";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\" onMouseOver=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t</tr>\n\t\t</table>\n\t<table width=\"100%\" height=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr >\n\t\t\t<td align=\"right\" valign=\"middle\">\n\t\t\t\t<input type=\"button\" align=\"right\" value=\"Print\" onClick=\"valsForPrint(\'PRINT\')\">\n\t\t\t\t<input type=\"button\" align=\"right\" value=\"View\" onClick=\"valsForPrint(\'VIEW\')\">\n\t\t\t</td>\n\t\t<tr>\t\n\t</table>\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n         <input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t  <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t  <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t  <input type=\'hidden\' name=\'date_from\' id=\'date_from\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t  <input type=\'hidden\' name=\'date_to\' id=\'date_to\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t  <input type=\'hidden\' name=\'app_hist_types\' id=\'app_hist_types\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t</form>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:12%; visibility:hidden;\' bgcolor=\'blue\' border=\'1\'>\n\t\t\t<div class=\'overlay\' width=\'100%\' id=\'t\' style=\'height:150px; overflow-y: scroll; overflow-x: hidden;\' border=\'1\'>\n\t</div>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
	
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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
07/05/2019		ML-MMOH-CRF-1064	Kamalakannan G		07/05/2019		Ramesh Goli		IN066304
20/06/2019		IN070766			Ramesh Goli			20/06/2019		Ramesh Goli		 Regression-CA-ML-MMOH-CRF-1064/03-Select ALL
---------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
	String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");
	 String bean_id					= "CAClinicalHistoryBean" ;
	 String bean_name				= "eCA.CAClinicalHistoryBean";
	 String selectAllDisable = "disabled";
	
	 CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
	 bean.setLanguageId(localeName); //IN070732
	 LinkedHashMap<String,String> histTypeGenerator = bean.getHistoryTypes();//get all hist type
	 bean.clearParMap();
	 bean.setLanguageId(localeName);
	
	 //LinkedHashMap<String,String> map=bean.updateAllClinicalNotePrintingFlags("CLNT","N");
	 String flag = request.getParameter("flag")==null?"":request.getParameter("flag");
	 if("N".equals(flag)){
		 bean.clearMapObject();
	 }
	 HashMap<String,String> allEvenClass=bean.getAllEventClasses("N");//HashMap for hidden fields
	 HashMap<String,ArrayList<String[]>> applicableRecords = bean.getApplicableRecords(patient_id,date_from,date_to,encounter_id); //get applicable hist type
	 HashMap<String,String> applicableEventClass = new HashMap<String,String>();
	 HashMap<String,HashMap<String,ArrayList<String>>> applicablePrintingValues = bean.applicablePrintingValues(patient_id, date_from, date_to, encounter_id);//MAIN FUNCTION
	 if(applicableRecords.size()!=0)
	 	selectAllDisable = "";
	 for (Map.Entry<String,ArrayList<String[]>> entry : applicableRecords.entrySet()) {
		String key = entry.getKey();
		String result = "";
		Set<String> applicableEventClassList = new HashSet<String>();
		ArrayList<String[]> value = (ArrayList<String[]>)entry.getValue();
		for(int i=0 ; i<value.size(); i++){
			String[] str = value.get(i);
			applicableEventClassList.add(str[0]);
		}
		Iterator iterator = applicableEventClassList.iterator();
		while(iterator.hasNext()){
			if("".equals(result)){
				result = result+iterator.next();
			}else{
				result = result+","+iterator.next();
			}
		}
		applicableEventClass.put(key,result);
		
	 }
	 String appHistTypes = "";
	// System.out.println("applicableRecords==>"+applicableEventClass);
	 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(selectAllDisable));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block10Bytes, _wl_block10);

				int i = 1;
				int j = 1;
				for (Map.Entry<String,String> entry : histTypeGenerator.entrySet()) { 
					String disabled = "disabled";
					Boolean disableClick = false;
					String eventClassList = "";
					if(j==1){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

				for (Map.Entry<String,ArrayList<String[]>> rec : applicableRecords.entrySet()) {
					if((rec.getKey()).equals(entry.getKey())){
						disabled = "";
						disableClick = true;
						if("".equals(appHistTypes)){
							appHistTypes = entry.getKey();
						}else{
							appHistTypes = appHistTypes+"_"+entry.getKey();
						}
						eventClassList = applicableEventClass.get(rec.getKey());
					}
				 }
				
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(entry.getKey()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(entry.getKey()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(eventClassList));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(disableClick){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(entry.getKey()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(eventClassList));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(entry.getValue()));
            _bw.write(_wl_block24Bytes, _wl_block24);

				if(j==5){
					j=1;
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
					j++;
				}
				i++;
				} 
            _bw.write(_wl_block26Bytes, _wl_block26);

		for (Map.Entry<String,String> entry : allEvenClass.entrySet()) {
         
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(entry.getKey()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(entry.getKey()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(entry.getValue()));
            _bw.write(_wl_block30Bytes, _wl_block30);
} 
		//System.out.println("appHistTypes==>"+appHistTypes);
	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(appHistTypes));
            _bw.write(_wl_block36Bytes, _wl_block36);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
