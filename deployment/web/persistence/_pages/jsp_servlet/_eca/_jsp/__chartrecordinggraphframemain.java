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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chartrecordinggraphframemain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingGraphFrameMain.jsp", 1742378977977L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<HTML>\n<HEAD>\n<script language=\'javascript\' src=\'../../eCA/js/ChartRecording.js\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\'JavaScript\'>\n\tvar arrValues = new Array();\n\tvar values2bsent = new Array();\n\tvar dates2bsent = new Array();\n\tvar desc2bsent = new Array();\n\tvar new_total_col ;\n\tvar event_val ;\n\tvar unit_val ;\n\tvar noOfSeries ;\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<script>\n\tif(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' != 0)\n\t\tlocation.href = \'../../eCA/jsp/ChartRecordingGraphFrame.jsp?noOfGroups=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&numOfchkedBoxes=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&encounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&facility_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&axis_range=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&flowsheetGraph=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\telse\n\t\tlocation.href = \'../../eCA/jsp/blank.jsp\';\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?												?
04/02/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005
07/03/2016	IN059461		Ramesh G										This issue happens when chart recorded exactly on shift timings.
11/03/2016	IN059532		Raja S											Alpha-Regression-CA - System doesn't display graph in Clinical 																				Event History.
------------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);


	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	String encounterId = "";
	if(flowsheetGraph.equals("Y"))
		encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	else
		encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");	
	
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = null;

	//(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		if(encounterId.equals("") || encounterId == null)
			encounterId = request.getParameter("encounterId");
		
		if(encounterId.equals(""))
		{
			encounterId ="0";
		}

		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounterId,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounterId,"eCA.ChartRecordingAddGroupBean",session);
	}
		


            _bw.write(_wl_block4Bytes, _wl_block4);


	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String axis_range = request.getParameter("axis_range") == null ? "S" : request.getParameter("axis_range");
	String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");

	//out.println("<script>alert('"+numOfchkedBoxes+"')</script>");

	String allDatesForGraph = request.getParameter("allDatesForGraph") == null ?"" : request.getParameter("allDatesForGraph");
	StringTokenizer strTokDates = new StringTokenizer(allDatesForGraph,"$$");
	ArrayList list = chartingBean.retrieveRecords();
	
	ArrayList tempArrayList = new ArrayList();
	ArrayList dateArrayList = new ArrayList();
	HashMap map = new HashMap();
	StringTokenizer strToken = null;
	StringTokenizer strTokenDatesAndValues = null;
	StringTokenizer strTkTdDatesAndValues = null;
	map = chartingBean.getHashValues();
	
	String keyForMap = "";
	String valueFromMap = "";
	String discrMsrDesc = "";
	String groupNo = "";
	String chkdUnchked = "";
	String datesAndValues = "";
	String tdDatesAndValues = "";
	String discrMsrId = "";		//IN058139.

	String graphDates = "";
	String graphValues = "";
	String graphResultType = ""; //IN059461
	String legendString = "";
	String discrUOM = "";
	StringBuffer descToGraph = new StringBuffer();
	int tempInt = 0;

	ArrayList listForGrp1 = new ArrayList();
	ArrayList listForGrp2 = new ArrayList();
	ArrayList listForGrp3 = new ArrayList();
	ArrayList listForGrp4 = new ArrayList();
	//IN058139 Start.	
	Set<String> disSetForGrp1 = new HashSet<String>();
	Set<String> disSetForGrp2 = new HashSet<String>();
	Set<String> disSetForGrp3 = new HashSet<String>();
	Set<String> disSetForGrp4 = new HashSet<String>();
	//IN058139 End.

	String groupNames = "";
	String datesForGrf = "";
	String valuesForGrf = "";
	String legendForGrf = "";
	String allDatesForGrf = "";
	String allDetailsForGraphs = "";
	String grfDatesAndValues = "";
	String graphDatesAndValues = "";
	StringTokenizer detailsForGrf = null;

	try
	{	
	if(axis_range.equals("S"))
	{
		for(int i=0;i<list.size();i++)
		{
			keyForMap = (String) list.get(i);
			discrMsrId = keyForMap; //IN058139
			valueFromMap = (String) map.get(keyForMap);	
			strToken = new StringTokenizer(valueFromMap,"~");
			discrMsrDesc = strToken.nextToken();
			descToGraph.append(discrMsrDesc+",");
			//groupNo = strToken.nextToken();
			chkdUnchked = strToken.nextToken();
			datesAndValues = strToken.nextToken();
			discrUOM = strToken.nextToken();
			groupNo = strToken.nextToken(); //IN052210
		
			if(!discrUOM.equals(" "))
			{
				legendString = discrMsrDesc + " (" + discrUOM + ")";
			}
			else
				legendString = discrMsrDesc;

			if(legendString.indexOf("%") != -1)
			{
				legendString = legendString.replaceAll("%","%25");
			}
			strTokenDatesAndValues = new StringTokenizer(datesAndValues,">");
			
			while(strTokenDatesAndValues.hasMoreTokens())
			{
				tdDatesAndValues = strTokenDatesAndValues.nextToken();
				strTkTdDatesAndValues = new StringTokenizer(tdDatesAndValues,"^%");
				while(strTkTdDatesAndValues.hasMoreTokens())
				{
					if(tempInt % 2 == 0)
					{
						graphDates = strTkTdDatesAndValues.nextToken();
					}
					else
					{
						graphValues = strTkTdDatesAndValues.nextToken();
						// IN059532 start
						if(flowsheetGraph.equals("Y"))
						graphResultType = "N"; //N is hardcoded.Bcoz results adding temparraylist thru flowsheetview in clinicalEventHistory
						else	// IN059532 end					
							graphResultType = strTkTdDatesAndValues.nextToken(); //IN059461
						if(!graphValues.equals(" "))
						{
							//IN058139 Start.
							//tempArrayList.add(groupNo+"`"+graphDates+"`"+graphValues+"`"+legendString);
							if(!"S".equals(graphResultType)&&!"S1".equals(graphResultType)&&!"S2".equals(graphResultType)&&!"S3".equals(graphResultType)){ //IN059461
								tempArrayList.add(groupNo+"`"+graphDates+"`"+graphValues+"`"+legendString+"`"+discrMsrId);
							} //IN059461
							//IN058139 End.
						}
					}
					tempInt++;
				}
			}
		}

		while(strTokDates.hasMoreTokens())
		{
			allDatesForGrf = (String) strTokDates.nextToken();
			for(int i=0;i<tempArrayList.size();i++)
			{
				allDetailsForGraphs = (String) tempArrayList.get(i);
				detailsForGrf = new StringTokenizer(allDetailsForGraphs,"`");
				groupNames = (String) detailsForGrf.nextToken();
				datesForGrf = (String) detailsForGrf.nextToken();
				valuesForGrf = (String) detailsForGrf.nextToken();
				legendForGrf = (String) detailsForGrf.nextToken();
				discrMsrId = (String) detailsForGrf.nextToken();
				if(datesForGrf.equals(allDatesForGrf))
				{
					if(groupNames.equals("Group 1"))
					{
						listForGrp1.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp1.add(discrMsrId); //IN058139
					}	
					else if(groupNames.equals("Group 2"))
					{
						listForGrp2.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp2.add(discrMsrId); //IN058139
					}
					else if(groupNames.equals("Group 3"))
					{
						listForGrp3.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp3.add(discrMsrId); //IN058139
					}
					else if(groupNames.equals("Group 4"))
					{
						listForGrp4.add(datesForGrf+"`"+valuesForGrf+"`"+legendForGrf);
						disSetForGrp4.add(discrMsrId); //IN058139
					}
				}
			}
		}
	}
	else if(axis_range.equals("M"))
	{
		while(strTokDates.hasMoreTokens())
		{
			allDatesForGrf = (String) strTokDates.nextToken();
			dateArrayList.add(allDatesForGrf);
		}
		for(int i=0;i<list.size();i++)
		{
			keyForMap = (String) list.get(i);
			valueFromMap = (String) map.get(keyForMap);
			strToken = new StringTokenizer(valueFromMap,"~");
			discrMsrDesc = strToken.nextToken();
			//groupNo = strToken.nextToken();
			chkdUnchked = strToken.nextToken();
			datesAndValues = strToken.nextToken();
			discrUOM = strToken.nextToken();
			groupNo = strToken.nextToken();//IN052210
			if(!discrUOM.equals(" "))
			{
				legendString = discrMsrDesc + " (" + discrUOM + ")";
			}
			else
				legendString = discrMsrDesc;

			if(legendString.indexOf("%") != -1)
			{
				legendString = legendString.replaceAll("%","%25");
			}

			strTokenDatesAndValues = new StringTokenizer(datesAndValues,">");
			while(strTokenDatesAndValues.hasMoreTokens())
			{
				tdDatesAndValues = strTokenDatesAndValues.nextToken();
				strTkTdDatesAndValues = new StringTokenizer(tdDatesAndValues,"^%");
				while(strTkTdDatesAndValues.hasMoreTokens())
				{
					graphDates = strTkTdDatesAndValues.nextToken();
					graphValues = strTkTdDatesAndValues.nextToken();
					// IN059532 start
					if(flowsheetGraph.equals("Y"))
					graphResultType = "N";  //N is hardcoded.Bcoz results adding temparraylist thru flowsheetview in clinicalEventHistory
					else	// IN059532 ends
						graphResultType = strTkTdDatesAndValues.nextToken(); //IN059461
					for(int j=0;j<dateArrayList.size();j++)
					{
						if(graphDates.equals(dateArrayList.get(j)))
						{
							if(!"S".equals(graphResultType)&&!"S1".equals(graphResultType)&&!"S2".equals(graphResultType)&&!"S3".equals(graphResultType)){ //IN059461
							grfDatesAndValues = graphDates+"^%"+graphValues;
							graphDatesAndValues = graphDatesAndValues+grfDatesAndValues+">";
							}//IN059461
						}
					}
				}
			}

			if(groupNo.equals("Group 1"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp1.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp1.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}	
			else if(groupNo.equals("Group 2"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp2.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp2.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}
			else if(groupNo.equals("Group 3"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp3.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp3.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}
			else if(groupNo.equals("Group 4"))
			{
				if(!graphDatesAndValues.equals("")){
					//IN058139 Start.
					//listForGrp4.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString);
					listForGrp4.add(discrMsrDesc+"~"+graphDatesAndValues+"~"+legendString+"~"+keyForMap);
					//IN058139 End.
				}
			}
			grfDatesAndValues = "";
			graphDatesAndValues = "";
		}
	}
		chartingBean.addToHashMap("Group 1",listForGrp1);
		chartingBean.addToHashMap("Group 2",listForGrp2);
		chartingBean.addToHashMap("Group 3",listForGrp3);
		chartingBean.addToHashMap("Group 4",listForGrp4);
		chartingBean.addToHashMap("SetGroup 1",new ArrayList<String>(disSetForGrp1)); //IN058139
		chartingBean.addToHashMap("SetGroup 2",new ArrayList<String>(disSetForGrp2));  //IN058139
		chartingBean.addToHashMap("SetGroup 3",new ArrayList<String>(disSetForGrp3)); //IN058139
		chartingBean.addToHashMap("SetGroup 4",new ArrayList<String>(disSetForGrp4)); //IN058139

		if(flowsheetGraph.equals("Y"))
			putObjectInBean("flowsheetBean"+patient_id+encounterId,chartingBean,session);
		else
			putObjectInBean("chartingBean"+patient_id+encounterId,chartingBean,session);
	}
	catch(Exception ex)
	{
		
		ex.printStackTrace();
	}
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(noOfGroups));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(numOfchkedBoxes));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(axis_range));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(flowsheetGraph));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
