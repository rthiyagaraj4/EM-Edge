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

public final class __chartrecordingapplet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingApplet.jsp", 1709115660856L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<body onKeyDown=\"lockKey()\">\n\t<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<applet code=\"LineGraphApplet.class\" codebase=\"../MediPainter/\" archive=\"LineGraphapplet.jar\" width=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" height=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n \n\t<!-- Start Up Parameters -->\n\t<PARAM name=\"LOADINGMESSAGE\" value=\"Flow Sheet Graph Loading - Please Wait...\"> <!-- Message to be displayed on Startup -->\n\t<PARAM name=\"STEXTCOLOR\" value=\"0,0,100\"> <!-- Message Text Color-->\n\t<PARAM name=\"STARTUPCOLOR\" value=\"255,255,255\"> <!-- Applet Background color -->\n\t<!-- Chart Switches -->\n\n\t<PARAM name=\"3D\" value=\"false\"> <!-- 3D mode On/Off -->\n\t<PARAM name=\"grid\" value=\"true\"> <!-- Grid On/Off -->\n\t<PARAM name=\"axis\" value=\"true\"> <!-- Axis On/Off -->\n\t<PARAM name=\"ylabels\" value=\"true\"> <!-- y Labels On/Off -->\n\t<PARAM name=\"outline\" value=\"true\"> <!-- Outline On/Off -->\n\t<PARAM name=\"legend\" value=\"true\"> <!-- Legend On/Off -->\n\n\t<!-- Chart Characteristics -->\n\t<PARAM name=\"nPoints\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"> <!-- Max Number of Points per series-->\n\t<PARAM name=\"nRows\" value=\"10\"> <!-- Number of Rows for the grid -->\n\t<PARAM name=\"vSpace\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"> <!-- Vertical spacing, number of Pixels -->\n\t<PARAM name=\"nSeries\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> <!-- Number of Series -->\n\t<PARAM name=\"hSpace\" value=\"50\"> <!-- Horizontal spacing, Pixels-->\n\t<PARAM name=\"gridxpos\" value=\"250\"> <!-- X position to start grid -->\n\t<PARAM name=\"gridypos\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> <!-- Y position to start grid -->\n\t<PARAM name=\"gridstyle\" value=\"2\"> <!-- grid line style -->\n\t<PARAM name=\"depth3D\" value=\"15\"> <!-- Depth of 3D effect, number of Pixels -->\n\t<PARAM name=\"ndecplaces\" value=\"2\"> <!-- Number of Decimal places to display values -->\n\t<PARAM name=\"labelOrientation\" value=\"5\"> <!-- x axis label orientation -->\n\t<PARAM name=\"labelsY\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> <!-- Y position of x axis labels-->\n\t\n\t<!-- x axis Labels -->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<PARAM name=\"label";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<PARAM name=\"label";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t<!-- Additional font information -->\n\t<PARAM name=\"font14\" value=\"Arial,N,10\"> <!-- Y labels Font -->\n\t<PARAM name=\"font15\" value=\"Arial,N,10\"> <!-- X labels Font -->\n\n\t<!-- Additional color information -->\n\t<PARAM name=\"color14\" value=\"170,170,170\"> <!-- gridcolor -->\n\t<PARAM name=\"color15\" value=\"0,0,255\"> <!-- axiscolor -->\n\t<PARAM name=\"color16\" value=\"0,100,170\"> <!-- floorcolor -->\n\t<PARAM name=\"color17\" value=\"0,0,0\"> <!-- outline color -->\n\t<PARAM name=\"color18\" value=\"50,50,50\"> <!-- label color -->\n\t<PARAM name=\"color19\" value=\"50,50,50\"> <!-- Y color -->\n\n\t<!-- Legend Information -->\n\t<!-- <PARAM name=\"legendfont\" value=\"Arial,N,10\"> \n\t<PARAM name=\"legendposition\" value=\"345,15\">\n\t\n\n\t<!-- Titles - Main, x and y -->\n\t<!-- <PARAM name=\"title\" value=\"text,xpos,ypos,font-type,font-style,font-size,Rcolor,Gcolor,Bcolor\"> -->\n\t<PARAM name=\"xtitle\" value=\"Date/Time |250,";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="|TimesRoman,B,";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="|100,100,200\">\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<PARAM name=\"ytitle\" value=\" |180,";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n \t\t\t<PARAM name=\"ytitle\" value=\" |180,120|TimesRoman,B,12|100,100,200\"> \n\n\n\n\t<!-- Free Form Text -->\n\t<!--<PARAM name=\"textn\" value=\"text,xpos,ypos,font-type,font-style,font-size,Rcolor,Gcolor,Bcolor\"> -->\n\t<!-- <PARAM name=\"text1\" value=\"Note :|80,15|Arial,N,10|100,100,200\">\n\t\n\t<!-- Series Data -->\n\n\n<!--========================added 24-02-2003=====================-->\n\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<PARAM name=\"series";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =",";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =",8|6|8|true|";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="|";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<!-- \t\t\t\t<PARAM name=\"group";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"> -->\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\n\t\n\n\n\n\n\t<!-- Point Data -->\n\t<!-- <PARAM name=\"dataNseriesN\" value=\"value|URL|Target Frame\"> -->\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<PARAM name=\"data";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="series";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\t\t\t\t\t<!--\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t// commented by venkatasubbu pr to get the revised position for the graph\t\n\t\t\t\t\t<PARAM name=\"data";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">  -->\n\t\t<PARAM name=\"data";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"> \n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n<!--========================ends here=======================================-->\n\n\n\t\n\t<PARAM name=\"chartScale\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<PARAM name=\"chartStartY\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"> <!-- Starting Y value -->\n\t<PARAM name=\"noOfGroups\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t</applet>\n\t<!-- <script>alert(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\");</script> -->\n\t</body>\n\t<html>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);
	HashMap tempMap = new HashMap();
	tempMap = chartingBean.getHashValues();

	ArrayList list = chartingBean.retrieveRecords();
	HashMap map = new HashMap();
	StringTokenizer strToken = null;
	map = chartingBean.getHashValues();
	String keyForMap = "";
	String valueFromMap = "";
	String discrMsrDesc = "";
	String groupNo = "";
	String chkdUnchked = "";
	String grpInfo[] = new String[list.size()];
	
	for(int i=0;i<list.size();i++)
	{
		keyForMap = (String) list.get(i);
		valueFromMap = (String) map.get(keyForMap);

		strToken = new StringTokenizer(valueFromMap,"~");
		discrMsrDesc = strToken.nextToken();
		groupNo = strToken.nextToken();
		chkdUnchked = strToken.nextToken();
		grpInfo[i] = groupNo;

	}

            _bw.write(_wl_block2Bytes, _wl_block2);

try
{

	String minValue="100000000000.0";
	int nCtr1 = 0;
	String strTemp="";
	String values = request.getParameter("values")==null?"":request.getParameter("values");

	String dates = request.getParameter("dates")==null?"":request.getParameter("dates");
	String totcols = request.getParameter("totcols")==null?"":request.getParameter("totcols");
	String unit = (request.getParameter("unitval")==null || request.getParameter("unitval").equals(""))?" ":request.getParameter("unitval");
	String event = request.getParameter("eventval")==null?" ":request.getParameter("eventval");

	String seriesCount=request.getParameter("seriescount")==null?"1":request.getParameter("seriescount");
	String noOfGroups=request.getParameter("noOfGroups")==null?"1":request.getParameter("noOfGroups");
	int i=0;
	//******setting the parameter for showing the multiple graphs in diffrent frames****//
	
	/*out.println(values);
	out.println(dates);
	out.println(unit);
	out.println(event);
	out.println(seriesCount);*/


	String vSpace="30";
	String gridyPos="370";
	String labelY="380";
	String xTitle="420";
	String yTitle="350";
	String heightChart="420";
	String fontSize="18";

	if(noOfGroups.equals("4"))
	{
		vSpace  = "10";
		gridyPos= "100";
		labelY  = "110";
		xTitle  = "140";
		yTitle  = "120";
		heightChart="140";
		fontSize="12";
	}
	else if(noOfGroups.equals("3"))
	{
		vSpace  = "10";
		gridyPos= "140";
		labelY  = "150";
		xTitle  = "180";
		yTitle  = "160";
	//	int colorVal=(int)Math.round(Math.random()*1000);
		//int colorVal1=(int)Math.round(Math.random()*1000);
		//colorVal= 100;
		//colorVal1= 75;
		heightChart="250";
		fontSize="12";
		//seriesCount="1";
	}
	else if(noOfGroups.equals("2"))
	{
		vSpace  = "15";
		gridyPos= "180";
		labelY  = "190";
		xTitle  = "220";
		yTitle  = "200";
//		int colorVal=(int)Math.round(Math.random()*1000);
	//	int colorVal1=(int)Math.round(Math.random()*1000);
		heightChart="250";
		fontSize="15";

		//seriesCount="1";
	}
	else if(noOfGroups.equals("1"))
	{
		vSpace  = "30";
		gridyPos= "370";
		labelY  = "380";
		xTitle  = "420";
		yTitle  = "350";
//		int colorVal=(int)Math.round(Math.random()*1000);
	//	int colorVal1=(int)Math.round(Math.random()*1000);
		heightChart="420";
		fontSize="18";

		
	}
	

	//***********************************************************************************
	
	//if(!(unit.equals(""))) unit =  "  /  "+unit;
	//t.println(totcols);
	i = Integer.parseInt(totcols);
	
	i=i+1;
	int width = (i*80)+150;

	if(width > 2000)
		width = 2000;
	if(width < 200)
		width = 200;
		
	int j =1;

	String datinhrs[] = new String[i];
	int k=1;
	String arr[] = new String[i];
	double max = 0.0;
	double min  = 100000000000.0;

	String rowScale      = "";
	String widthChart =""+width;
	

	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(widthChart));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(heightChart));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(totcols));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(vSpace));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(seriesCount));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gridyPos));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(labelY));
            _bw.write(_wl_block12Bytes, _wl_block12);

	HashMap htTemp = new HashMap();
		try
		{
			StringTokenizer st1 = new StringTokenizer(dates,",");
			String firstSet=st1.nextToken();
		
			StringTokenizer st2 = new StringTokenizer(firstSet,"`");
			int nPos =1;
			int nFind = 0;
			String strKey = "";
			String strPos = "";
			String strActPos = "";

			String padding="";
			while(st2.hasMoreTokens())
			{
				if ( j % 2 == 0 )
					padding = "";
				else
					padding = "|-10" ;
				datinhrs[j]= st2.nextToken();
				if (!(seriesCount.equals("1")))
				{
					String strValues = values;
					strKey = "~"+nPos+"`";
					strKey = strKey.trim();

					nFind = strValues.indexOf(strKey);

					if (nFind >=0)
					{

						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(datinhrs[j]));
            out.print( String.valueOf(padding));
            _bw.write(_wl_block15Bytes, _wl_block15);

						j++;
					}
					else
						nCtr1++;

					strPos ="" + nCtr1;	
				
					strActPos = "" + nPos;
					htTemp.put(strActPos,strPos);
					strKey = "";
				}
				else
				{
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(datinhrs[j]));
            out.print( String.valueOf(padding));
            _bw.write(_wl_block17Bytes, _wl_block17);

					j++;
				}
				nPos++;
			}
	
		}
		catch(Exception e)
		{
				
				//out.print("<script>alert('Exception1 @1"+e+"')</script>");//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
		}
		//out.println("<script>alert('"+firstSet+"')</script>");
			
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(xTitle));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fontSize));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if (seriesCount.equals("1"))
	   {
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(yTitle));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fontSize));
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
	   else
            _bw.write(_wl_block22Bytes, _wl_block22);

		try{

			StringTokenizer events = new StringTokenizer(event,",");
			StringTokenizer units  = new StringTokenizer(unit,",");
			int ii=1;
			int cnt = 0;
			int color=175;
			int color1=20;
			while(events.hasMoreTokens())
			{
				String eve=events.nextToken();
				String uni="/ "+units.nextToken();

				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(color));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(color1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(eve));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(uni));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(grpInfo[cnt]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ii));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(grpInfo[cnt]));
            _bw.write(_wl_block30Bytes, _wl_block30);
 
				color-=100;
				color1+=100;
				if(color>255)
					color-=75;
				ii++;
				cnt++;
			}//end while
		}catch(Exception e)
		{
			//out.println("Exception 3"+e);//COMMON-ICN-0181
                         e.printStackTrace();//COMMON-ICN-0181
		}
		
            _bw.write(_wl_block31Bytes, _wl_block31);

	try
	{
		StringTokenizer seriesVal = new StringTokenizer(values,",");

		int jj=1;
		while(seriesVal.hasMoreTokens())
		{
			int position=0;
			String first=seriesVal.nextToken();

			StringTokenizer data=new StringTokenizer(first,"`");
			while(data.hasMoreTokens())
			{
				arr[k] = data.nextToken();
				//added later for position number
				StringTokenizer dataVal=new StringTokenizer(arr[k],"~");
				arr[k] = dataVal.nextToken();
				//if(arr[k].equals("!!!"))
					//arr[k]="";
				position =Integer.parseInt(dataVal.nextToken());
				//ends here
				if(Double.parseDouble(arr[k])<Double.parseDouble(minValue))
				{
					minValue=arr[k];
				}
				if(seriesCount.equals("1"))//when only one graph is there we will skip the date which doesnot have any record...so will not take care of the positions
				{
					
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arr[k]));
            _bw.write(_wl_block17Bytes, _wl_block17);


				}
				else
				{
						int nRevPos = 0;
						
						strTemp = String.valueOf(position);
						String strPos1 = (String)htTemp.get(strTemp);
						
						nRevPos = position  - (Integer.parseInt(strPos1));
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(position));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arr[k]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nRevPos));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arr[k]));
            _bw.write(_wl_block36Bytes, _wl_block36);

				}
					if(Double.parseDouble(arr[k]) > max) max = Double.parseDouble(arr[k]);
					if(Double.parseDouble(arr[k]) < min) min = Double.parseDouble(arr[k]);
				k++;
				
			}
			k=1;
			jj++;
		//-* Find the max and min values*-//
//			double nRows = (max/10);
			double nRows = ((max+1-(Double.parseDouble(minValue)))/10);
			nRows		=  Math.ceil(nRows);	
			
			rowScale      = ""+nRows;

		}	
	}
	catch(Exception e)
	{
		
		//out.print("Exception2 "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	//converting the decimal value to the integer value for minimum y
	long tempLong=(long)Double.parseDouble(minValue);
	minValue=""+tempLong;
	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowScale));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(minValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(grpInfo.length));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(minValue));
            _bw.write(_wl_block41Bytes, _wl_block41);


}
catch(Exception e1)
{
	//out.println("main "+e1);//COMMON-ICN-0181
	e1.printStackTrace();//COMMON-ICN-0181
}

            _bw.write(_wl_block42Bytes, _wl_block42);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
