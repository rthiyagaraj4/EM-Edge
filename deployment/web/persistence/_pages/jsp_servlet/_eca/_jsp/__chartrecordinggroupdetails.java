package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chartrecordinggroupdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingGroupDetails.jsp", 1738926674373L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n10/11/2011  IN029392        Menaka      \tClinical Event History>View Graph Select event result and then click View graph\t\t\t\t\t\t\t\t\t\t \n16/08/2019\tIN069564\t\tRamesh Goli\t\tCA-Common-Record Charts\t\t\t\t\t\t\t\t\t \n---------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script src=\'../../eCA/js/ChartRecording.js\' language=\'javascript\'></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t\t\n\t\t\n\t</head>\n\t<body onKeyDown=\"lockKey()\">\n\t\t<form name=\'chartRecordingGrpDetailsForm\' id=\'chartRecordingGrpDetailsForm\'>\n\t\t\t<table class=\'grid\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'CAGROUPHEADING\' align=\'center\' colspan=\'2\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr></tr>\n\t\t\t</table>\n\t\t\t<table class=\'grid\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'CACHARTFOURTHLEVELCOLOR\' align=\'left\' colspan=\'2\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'2\' align=\'left\'><input type=\'radio\' name=\'axis_range\' id=\'axis_range\' value=\'S\' checked>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<input type=\'radio\' name=\'axis_range\' id=\'axis_range\' value=\'M\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\n\t\t\t</table>\n\t\t\t<table width=\'100%\' style=\'border-bottom-color:#666666\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'CAGROUPHEADING\'>\n\t\t\t\t\t<input type=\'button\' name=\'graph\' id=\'graph\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onclick =\'closeWindow()\'><input type=\'button\' name=\'newgroup\' id=\'newgroup\' style=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'radNew\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onclick =\'loadDetailsPage(\"New Group\")\'>\n\t\t\t\t\t<!-- <a class=\'gridLink\' href=\'javascript:loadDetailsPage(\"New Group\")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a> -->\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<div id=\'toolTipDiv\' style=\'position:absolute; width:20%; display:none\'>\n\t\t\t\t<table id=\'toolTiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr><td width=\'100%\' id=\'tdID\'></td></tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<input type=\'hidden\' name=\'grpValueHidden\' id=\'grpValueHidden\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'noOfRecs\' id=\'noOfRecs\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\t\t\t\n\t\t\t<input type=\'hidden\' name=\'grpCount\' id=\'grpCount\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t<input type=\'hidden\' name=\'grpDetails\' id=\'grpDetails\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t<input type=\'hidden\' name=\'no_of_selections\' id=\'no_of_selections\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'selected_events_uom\' id=\'selected_events_uom\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'group1\' id=\'group1\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'group2\' id=\'group2\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=\'hidden\' name=\'group3\' id=\'group3\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type=\'hidden\' name=\'group4\' id=\'group4\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\t\t\t\n\t\t\t<input type=\'hidden\' name=\'grp1Val\' id=\'grp1Val\' value=\'0\'>\t\n\t\t\t<input type=\'hidden\' name=\'grp2Val\' id=\'grp2Val\' value=\'0\'>\t\n\t\t\t<input type=\'hidden\' name=\'grp3Val\' id=\'grp3Val\' value=\'0\'>\t\n\t\t\t<input type=\'hidden\' name=\'grp4Val\' id=\'grp4Val\' value=\'0\'>\n\t\t\t<input type=\'hidden\' name=\'grp1ValTemp\' id=\'grp1ValTemp\' value=\'0\'>\t\n\t\t\t<input type=\'hidden\' name=\'grp2ValTemp\' id=\'grp2ValTemp\' value=\'0\'>\t\n\t\t\t<input type=\'hidden\' name=\'grp3ValTemp\' id=\'grp3ValTemp\' value=\'0\'>\t\n\t\t\t<input type=\'hidden\' name=\'grp4ValTemp\' id=\'grp4ValTemp\' value=\'0\'>\n\t\t\t<input type=\'hidden\' name=\'GroupName1\' id=\'GroupName1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'GroupName2\' id=\'GroupName2\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'GroupName3\' id=\'GroupName3\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'GroupName4\' id=\'GroupName4\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'encounterId\' id=\'encounterId\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'allDatesForGraph\' id=\'allDatesForGraph\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flowsheetGraph\' id=\'flowsheetGraph\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'numOfchkedBoxes\' id=\'numOfchkedBoxes\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t</form>\n\t</body>\n</html>\n\n";
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = "";
	if(flowsheetGraph.equals("Y"))
		encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	else
		encounter_id = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");

		String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");
		//out.println("<script>alert('numOfchkedBoxes = "+numOfchkedBoxes+"');</script>");

	
	eCA.ChartRecordingAddGroupBean chartingBean = null; 
//(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		if(encounter_id.equals("") || encounter_id == null) 
			encounter_id = request.getParameter("encounterId");

		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}




            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

			String displayRad1 = "display:none";
			String displayRad2 = "display:none";
			String displayRad3 = "display:none";
			String displayRad4 = "display:none";
			String displayRadNew = "display";

			int Group1 = 0;
			int Group2 = 0;
			int Group3 = 0;
			int Group4 = 0;

			//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			//String locale = (String) p.getProperty("LOCALE");
			
			String count = request.getParameter("count") == null ? "1" : request.getParameter("count");
			String flagGraph = request.getParameter("flagGraph") == null ? "N" : request.getParameter("flagGraph");
			String sentFromGraph = request.getParameter("sentFromGraph") == null ? "" : request.getParameter("sentFromGraph");
			String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");
			
			String groupName = request.getParameter("groupName") == null ? "" : request.getParameter("groupName");
			String statusChecked = request.getParameter("statusChecked") == null ? "" : request.getParameter("statusChecked");

			String classValue = "";
			String grpDetails = "";
			int i=0;
			int grpCount = 0;

			StringTokenizer strToken = null;
			StringTokenizer strTokenRadBtn = null;
			
		
            _bw.write(_wl_block7Bytes, _wl_block7);


			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			try
			{
				HashMap map = new HashMap();
				
				String keyForMap = "";
				String valueFromMap = "";
				String discrMsrDesc = "";
				String groupNo = "";
				String prevGroupNo = "";
				String chkdUnchked = "";
				String datesValues = "";
				String units = "";
				String radBtnCode = "";
				if(sentFrom.equals("radBtn"))
				{
					strTokenRadBtn = new StringTokenizer(statusChecked,"!!");
				}
				ArrayList list = chartingBean.retrieveRecords();				
				
				if(sentFrom.equals("radBtn"))
				{
					list = chartingBean.retrieveRecords();
					map = chartingBean.getHashValues();
					int size = 	strTokenRadBtn.countTokens();

					for(int k=0;k<size;k++)
					{
						radBtnCode = strTokenRadBtn.nextToken();
						for(int m=0;m<list.size();m++)
						{
							keyForMap = (String) list.get(m);
							valueFromMap = (String) map.get(keyForMap);
							strToken = new StringTokenizer(valueFromMap,"~");
							discrMsrDesc = strToken.nextToken();
							//groupNo = strToken.nextToken();
							chkdUnchked = strToken.nextToken();			
							datesValues = strToken.nextToken();
							units = strToken.nextToken();
							groupNo = strToken.nextToken();  //IN052210
							if(radBtnCode.equals(keyForMap))
							{
								groupNo = groupName;
								//Modification starts for IN29392
								//chartingBean.addRecords(keyForMap,java.net.URLDecoder.decode(discrMsrDesc) + "~" + groupNo + "~" + chkdUnchked + "~" + datesValues + "~" + units);
								//IN052210 Start.
								//chartingBean.addRecords(keyForMap,discrMsrDesc + "~" + groupNo + "~" + chkdUnchked + "~" + datesValues + "~" + units);
								chartingBean.addRecords(keyForMap,discrMsrDesc + "~" + chkdUnchked + "~" + datesValues + "~" + units+ " ~" + groupNo);
								//IN052210 End.
								//Modification ends for IN29392
								if(flowsheetGraph.equals("Y"))
									putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
								else
									putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
								
								m = list.size();
							}
						}
					}
				}
				chartingBean.reArrangeGroups(); //IN069564

				list = chartingBean.retrieveRecords();
				map = chartingBean.getHashValues();
			
				for(int j=1;j<5;j++)
				{
					for(int m=0;m<list.size();m++)
					{
						/*if(i % 2 == 0)
							classValue = "QRYEVEN";
						else
							classValue = "QRYODD";*/

						 classValue="gridData";


						keyForMap = (String) list.get(m);
						valueFromMap = (String) map.get(keyForMap);
						strToken = new StringTokenizer(valueFromMap,"~");
						discrMsrDesc = strToken.nextToken();
						//discrMsrDesc = java.net.URLDecoder.decode(discrMsrDesc);//Modification for IN29392
						//IN052210 Start.
						/*
						groupNo = strToken.nextToken();
						chkdUnchked = strToken.nextToken();		
						strToken.nextToken();*/
						chkdUnchked = strToken.nextToken();	
						datesValues = strToken.nextToken();
						units = strToken.nextToken();
						groupNo = strToken.nextToken();
						//IN052210 End.
						if(groupNo.equals("Group "+j))
						{
							if(!prevGroupNo.equals(groupNo))
							{
								out.println("<tr>");
								//out.println("<td class='CAGROUPHEADING' colspan='2'><img align='left' src='../../eCommon/images/iGridNextDIS16.gif' id='"+groupNo+"'><a class='NormalGroup' href='javascript:loadDetailsPage(\""+groupNo+"\")' title='Click the Group Name to regroup'> ");
								out.println("<td class='NormalGroup' colspan='2' onclick='loadDetailsPage(\""+groupNo+"\")' onmouseover='activateLink(this,\""+j+"\")' onmouseout='deactivateLink(this,\""+j+"\")'><img align='left' src='../../eCommon/images/iGridNextDIS16.gif' id='group"+j+"'>"+groupNo+"</td>");
								//out.println(groupNo);
								//out.println("</td>");							
								out.println("</tr>");
								grpCount++;
							}					
							grpDetails = discrMsrDesc + "^^" + groupNo+ "!!" + grpDetails;
							out.println("<tr>");
							out.println("<td class='"+classValue+"' width='3%'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='chkDiscrMsr"+i+"'  id='"+keyForMap+"' onclick='addToNewGrp(\""+i+"\",\""+groupNo+"\",this)'>");
							out.println("</td>");
							out.println("<td class='"+classValue+"' width='97%'>"+keyForMap+"</td>");
							out.println("</tr>");
							prevGroupNo = groupNo;
							i++;							
							if(groupNo.equals("Group 1"))
							{
								Group1++;								
							}
							if(groupNo.equals("Group 2"))
							{
								Group2++;								
							}
							if(groupNo.equals("Group 3"))
							{
								Group3++;								
							}
							if(groupNo.equals("Group 4"))
							{
								Group4++;								
							}
						}					
					}
				}
				if(flowsheetGraph.equals("Y"))
					putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
				else
					putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);

				if(flagGraph.equals("Y"))
				{
					count = sentFromGraph;
				}
				else
				{
					Integer tempCnt = new Integer(Group1 + Group2 + Group3 + Group4);
					count = tempCnt.toString();
				}

				if(grpCount == 2)
				{
					displayRad1 = "display";
					if(Integer.parseInt(count) > 2)
					{
						displayRad2 = "display";
						displayRadNew = "display";
					}

					if(Group1 == 1)
					{
						displayRad2 = "display:none";
					}
				}
				else if(grpCount == 3)
				{
					displayRad1 = "display";
					displayRad2 = "display";

					if(Integer.parseInt(count) > 3)
					{
						displayRad3 = "display";
						displayRadNew = "display";
					}
				}
				else if(grpCount == 4)
				{
					displayRad1 = "display";
					displayRad2 = "display";
					displayRad3 = "display";
					displayRad4 = "display";
					displayRadNew = "display:none";
				}
				if(flowsheetGraph.equals("Y"))
					putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
				else
					putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);

/*				out.println("group count = "+grpCount);
				out.println("grp1 = "+Group1);
				out.println("grp2 = "+Group2);
				out.println("grp3 = "+Group3);
				out.println("grp4 = "+Group4);*/
			}
			catch(Exception e)
			{
				//out.println("Exception in ChartRecordingGroupDetails.jsp -- "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(displayRadNew));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Group.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(grpCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(grpDetails));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request.getParameter("no_of_selections")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getParameter("selected_events_uom")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Group1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Group2));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Group3));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Group4));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getParameter("facility_id")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(request.getParameter("patient_id")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(request.getParameter("allDatesForGraph")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(flowsheetGraph));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GeneralGraph.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.StandardView.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.single.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.multiple.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.New.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
}
