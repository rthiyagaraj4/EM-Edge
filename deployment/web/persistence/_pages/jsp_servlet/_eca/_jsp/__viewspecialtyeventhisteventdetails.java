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
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewspecialtyeventhisteventdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewSpecialtyEventHistEventDetails.jsp", 1736157593979L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<head> \n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link> \t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ViewSpecialtyEventHist.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n A:link\n{\n    COLOR: yellow\n}\nA:visited\n{\n    COLOR: yellow\n} \n</style>\n\n</head>\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onScroll=\'scrollFrame()\' onResize=\'alignDivs()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'dataForm\' id=\'dataForm\'>\n\t\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t\t<table width=\'100%\' id=\'dataTitleTable\' class=\'grid\' align=\'center\' >\n\t\t\t\t<TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<TH nowrap id=\'visID";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'><a href=\"javascript:collapseColumn(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" title=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</a></TH>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</TR>\n\t\t\t</table>\n\t\t</div>\n\t\t<table class=\'grid\' width=\'100%\' id=\'dataTable\' align=\'center\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<TR height:5%;>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<TH nowrap id=\'visIDup";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' width=\'110px\' style=\'visibility:hidden\'>&nbsp;</TH>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</TR>\n<input type=\'hidden\' name=\'totRows\' id=\'totRows\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\'hidden\' name=\'totCols\' id=\'totCols\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\'hidden\' name=\'allDatesForGraph\' id=\'allDatesForGraph\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n</table>\n</form>\n<script>\n\tsetTimeout(\"alignUnitsAndData()\",300);\n\tsetTimeout(\"alignHeight()\",300);\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
String disc_desc="";
String result_num_uom="";
String disc_id="";
String strTempDt="";
String discr_msr_id="";
String result_type="";
String RESULT_NUM="";
String RESULT_STR="";
String RESULT_DATA="";
String EVENT_CODE="";
String ACCESSION_NUM="";
String tempOnMouseOver = "";
String toolTip = "";
String dateForGraph = "";
String hiddenDateForGraph = "";
boolean image=false;
String classValue="";
ArrayList dateList = new ArrayList();
String to_date=request.getParameter("to_date");
String from_date=request.getParameter("from_date");
LinkedHashMap temp_hashmap			= new LinkedHashMap();
StringBuffer displaydata = new StringBuffer();
StringBuffer datefields = new StringBuffer();
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
	{
		con = ConnectionManager.getConnection(request);
//		pstmt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date FROM CA_SPLTY_DISCR_MSR WHERE  patient_id="+"'"+patient_id+"'"+" AND module_id="+"'"+module_id+"'"+" AND cycle_no="+cycle_no+" AND trans_date>=TO_DATE("+"'"+from_date+"'"+",'dd/mm/yyyy HH24:MI') AND trans_date<=TO_DATE("+"'"+to_date+"'"+",'dd/mm/yyyy HH24:MI') ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi') desc");
		pstmt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi:ss') trans_date FROM CA_SPLTY_DISCR_MSR WHERE  patient_id=? AND module_id=? AND cycle_no=? and TASK_CODE=? AND trans_date between TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') AND  TO_DATE(?,'dd/mm/yyyy HH24:MI:ss')  ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi:ss') desc");

		try
		{
			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,"MCT002");
			pstmt.setString(5,from_date);
			pstmt.setString(6,to_date);

			rs = pstmt.executeQuery();
			while (rs.next())
			{
				strTempDt = rs.getString(1);


				datefields.append(com.ehis.util.DateUtils.convertDate(strTempDt,"DMYHMS","en",locale)+"$$");
				dateList.add(strTempDt);
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//COMMON-ICN-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			//if(rs != null) rs.close();
			//if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	

            _bw.write(_wl_block8Bytes, _wl_block8);

						String strConvDt = "";
						int dateListSize = dateList.size();
						for(int i=0;i<dateListSize;i++)
						{
							strConvDt = com.ehis.util.DateUtils.convertDate((String)dateList.get(i),"DMYHMS","en",locale);
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Clickheretocollapsethecolumn.label","ca_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strConvDt));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
					
            _bw.write(_wl_block14Bytes, _wl_block14);

	try
	{
		
//		pstmt = con.prepareStatement("SELECT DISTINCT A.discr_msr_id discr_msr_id,B.short_desc short_desc,A.result_num_uom uom FROM CA_SPLTY_DISCR_MSR A,  AM_DISCR_MSR B WHERE  A.patient_id="+"'"+patient_id+"'"+" AND A.module_id="+"'"+module_id+"'"+" AND A.cycle_no="+"'"+cycle_no+"'"+" AND A.Discr_msr_id=B.Discr_msr_id AND A.trans_date>=TO_DATE("+"'"+from_date+"'"+",'dd/mm/yyyy HH24:MI') AND A.trans_date<=TO_DATE("+"'"+to_date+"'"+",'dd/mm/yyyy HH24:MI') ORDER BY 1");
		pstmt = con.prepareStatement("SELECT DISTINCT A.discr_msr_id discr_msr_id,B.short_desc short_desc,A.result_num_uom uom FROM CA_SPLTY_DISCR_MSR A,  AM_DISCR_MSR B WHERE  A.patient_id=? AND A.module_id=? AND A.cycle_no=?  and TASK_CODE=? AND A.Discr_msr_id=B.Discr_msr_id AND A.trans_date between TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') AND TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') ORDER BY 1");
		try
		{

			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,"MCT002");
			pstmt.setString(5,from_date);
			pstmt.setString(6,to_date);

			rs = pstmt.executeQuery();
			while (rs.next())
			{
				disc_id = rs.getString(1);
				disc_desc = rs.getString(2);
				result_num_uom= rs.getString(3);
				if(temp_hashmap.containsKey(disc_id))
				disc_id=disc_id+" ";
				temp_hashmap.put(disc_id,disc_desc+"!!"+result_num_uom);
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//COMMON-ICN-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			//if(rs != null) rs.close();
			//if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	int rowsCount=0;
	try{
	Set s;
	Iterator it;
	s = temp_hashmap.entrySet();
	it = s.iterator();
	int i=0;
	while (it.hasNext()){
	String temp_value=it.next().toString();
	String[] hashValues=temp_value.split("=");
	String key=hashValues[0];
	if(i % 2 == 0){
			classValue = "gridDataChart";
		}else{
			classValue = "gridDataChart";
	}

	out.println("<TR>");
	String[] Values=hashValues[1].split("!!");
	if(Values[1].equals("null"))
	Values[1]="";
	dateListSize = dateList.size();
	for(int j=0;j<dateListSize;j++)
	{
		strConvDt=(String)dateList.get(j);

		RESULT_NUM="";
		RESULT_STR="";
		discr_msr_id="";
		result_type="";
		try
		{
		//pstmt = con.prepareStatement("SELECT RESULT_NUM,RESULT_STR,TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date,RESULT_DATA,EVENT_CODE,ACCESSION_NUM,CA_GET_VISIT_HDR_NEW(FACILITY_ID,PATIENT_CLASS,ENCOUNTER_ID,PATIENT_ID, ADDED_BY_ID)||' , Normal Range  ('||NORMAL_LOW||'-'||NORMAL_HIGH ||')' GetTooltip FROM CA_SPLTY_DISCR_MSR WHERE  patient_id="+"'"+patient_id+"'"+" AND module_id="+"'"+module_id+"'"+" AND cycle_no="+cycle_no+" AND DISCR_MSR_ID="+"'"+key+"'"+" AND TO_CHAR(trans_date,'dd/mm/yyyy HH24:MI')=TO_CHAR(TO_DATE("+"'"+strConvDt+"'"+",'dd/mm/yyyy HH24:MI'),'dd/mm/yyyy HH24:MI')");	

		pstmt = con.prepareStatement("SELECT DISCR_MSR_ID,RESULT_TYPE,RESULT_NUM,RESULT_STR,TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi:ss') trans_date,RESULT_DATA,EVENT_CODE,ACCESSION_NUM,CA_GET_VISIT_HDR_NEW(FACILITY_ID,PATIENT_CLASS,ENCOUNTER_ID,PATIENT_ID, ADDED_BY_ID)||' , Normal Range  ('||NORMAL_LOW||'-'||NORMAL_HIGH ||')' GetTooltip FROM CA_SPLTY_DISCR_MSR WHERE  patient_id=? AND module_id=? AND cycle_no=? AND DISCR_MSR_ID=? AND trans_date=TO_DATE(?,'dd/mm/yyyy HH24:MI:SS')");
		
			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,key);
			pstmt.setString(5,strConvDt);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				discr_msr_id = rs.getString("DISCR_MSR_ID")==null?"":rs.getString("DISCR_MSR_ID");
				result_type = rs.getString("RESULT_TYPE")==null?"":rs.getString("RESULT_TYPE");
				RESULT_NUM = rs.getString("RESULT_NUM")==null?" ":rs.getString("RESULT_NUM");
				RESULT_STR = rs.getString("RESULT_STR")==null?" ":rs.getString("RESULT_STR");
				dateForGraph = rs.getString("trans_date")==null?" ":rs.getString("trans_date");
				Clob note=rs.getClob("RESULT_DATA");
				toolTip = rs.getString("GetTooltip") == null ? "" : rs.getString("GetTooltip");
				if(note==null)
					image=false;
				else
					image=true;
				displaydata = new StringBuffer();
				if(note!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) displaydata.append(line+"\n");
				}

				if(displaydata.toString().equals("") || displaydata.toString().equals(" ") || displaydata.toString().equals("null") || displaydata.toString().equals(null) || displaydata.toString()==null || displaydata.toString()=="" || displaydata.toString()==" ")
					image=false;
				else
					image=true;
				EVENT_CODE=rs.getString(5);
				ACCESSION_NUM=rs.getString(6);

				if ((result_type.equals("D") || result_type.equals("A")) && !RESULT_STR.equals(" "))
				{					
					if(com.ehis.util.DateUtils.validDate(RESULT_STR, "DMY", locale))
						RESULT_STR = com.ehis.util.DateUtils.convertDate(RESULT_STR,"DMY","en",locale);
				}
				
			}
			if(RESULT_NUM==null || RESULT_NUM.equals(""))
			{
				RESULT_NUM=" ";
				hiddenDateForGraph = " ";
			}
			else
				hiddenDateForGraph = com.ehis.util.DateUtils.convertDate(dateForGraph,"DMYHMS","en",locale);

			if(RESULT_STR==null)
			RESULT_STR=" ";
			
			String tempToolTip = toolTip.replace('\'',' ');
			if(!image)
			{
			RESULT_DATA="&nbsp;";
			tempOnMouseOver="&nbsp;";
			}
			else
			{
			image=false;
			RESULT_DATA="<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+key+"','"+strConvDt+"','"+ACCESSION_NUM+"','"+EVENT_CODE+"','"+image+"')\">";
			if(!tempToolTip.equals(""))
			{
			tempOnMouseOver="onMouseOver='displayToolTip(\""+tempToolTip+"\");' onMouseOut =hideToolTip(); ";
			}
			}
			out.println("<TD id='visibility"+i+"ID"+j+"' class='"+classValue+"' align='center' style='display' "+tempOnMouseOver+">"+RESULT_NUM+" "+RESULT_STR+" "+RESULT_DATA+" "+"</TD>");
			out.println("<input type='hidden' id='values"+rowsCount+"ForGraphs"+j+"' value='"+hiddenDateForGraph+"^%"+RESULT_NUM+"'>");
			//tempString="&nbsp;";
			out.println("<TD class='"+classValue+"' id='duplicate"+i+"ID"+j+"' style='display:none' width='10%' >&nbsp;</TD>");

		}
		catch(Exception e)
		{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
		
	}
	out.println("</TR>");
	i++;
	rowsCount++;
	}
	}
	catch(Exception e)
		{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
	finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con,request);
		}


            _bw.write(_wl_block15Bytes, _wl_block15);

for(int m=0;m<dateListSize;m++){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(m));
            _bw.write(_wl_block17Bytes, _wl_block17);
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowsCount+1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dateList.size()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(datefields));
            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewSpecialtyEventHistory.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
