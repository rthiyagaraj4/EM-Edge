package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.DateFormat;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.*;
import eXH.XHDBAdapter;
import java.io.*;
import java.util.*;

public final class __tracknotificationtable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/TrackNotificationTable.jsp", 1732991743273L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 ="\n\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eXH/html/xhtab.css\'></link>\n\n<title>Track Notification Tabular Content</title>\n</head>\n\n<body>\n \n\t<div name=\"tableData\" id=\"tab\"\n\t\tstyle=\"width: 100%; overflow: auto; height: 350px;\">\n\n\t\t<table onload=\"resubmitUser()\">\n\t\t\t<tr align=\"center\">\n\t\t\t\t<td align=\"center\"> \n\t\t\t\t\t<table id=\"tableDetails\" border=\"1\" style=\"width: 90%; border-style: double;\">\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\t\t\t\t\t<tr align=\"center\" style=\"height: 10px;\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<th class=label align=\"center\"\n\t\t\t\t\t\t\t\tstyle=\"color: white; background-color: #898FBD; font-weight: bold;\">Select\n\t\t\t\t\t\t\t\t\tAll<input type=\"checkbox\" name=\"checkAll\" id=\"checkAll\" id=\"checkAll\"\n\t\t\t\t\t\t\t\tonclick=\"selectAll(this);\" /></th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t<th class=label align=\"center\"\n\t\t\t\t\t\t\t\tstyle=\"color: white; background-color: #898FBD; font-weight: bold;\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t</th>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t</tr>\n\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"isTableDataPresent\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<tr align=\"center\" style=\"font-size: 8pt;background-color: #FAA4A4;\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<tr align=\"center\" style=\"font-size: 8pt;\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<td align=\"center\" style=\"font-size: 8pt;\"><input type=\"checkbox\" name=\"checkAll\" id=\"checkAll\" id=\"checkingBox\"/></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td align=\"center\" style=\"font-size: 8pt;\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<input type=\"hidden\" id=\"isTableDataPresent\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'/>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\t<div>\n\n\t\t<div class=\"btn\">\n\t\t\t<INPUT class=BUTTON type=button value=\"Export\" onclick=\"exporting();\" />\n\t\t</div>\n\t</div>\n\t\n\t<input type=\'hidden\' name=\'app_id\' id=\'app_id\' id=\'app_id\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=\'hidden\' name=\'event_type\' id=\'event_type\' id=\'event_type\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'notification_status\' id=\'notification_status\' id=\'notification_status\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'specimen_from_date\' id=\'specimen_from_date\' id=\'specimen_from_date\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=\'hidden\' name=\'specimen_to_date\' id=\'specimen_to_date\' id=\'specimen_to_date\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=\'hidden\' name=\'onlyRequiredColumnCompleteQuery\' id=\'onlyRequiredColumnCompleteQuery\' id=\'onlyRequiredColumnCompleteQuery\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	ResultSet rs= null;
	ResultSet rs1 = null;
	ResultSetMetaData rsmd = null;
	String app_id = request.getParameter("app_id");
	String event_type = request.getParameter("event_type");
	String notification_status = request.getParameter("notification_status");
	String specimen_from_date = (String)request.getParameter("specimen_from_date");
	String specimen_to_date = (String)request.getParameter("specimen_to_date");
	Statement stmt = null;
	int columnCount;
	int columnCount1;
	String columnHeader = null;
	int totalRowCount;
	String rowCountingQuery = null;
	String onlyRequiredColumnQuery = null;
	String onlyRequiredColumnCompleteQuery = null;
	int lengthOfString;
	List listColumns = new ArrayList();
	String columnsFromNotify = null;
	
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	Date fromDate = dateFormat.parse(specimen_from_date);
	Date toDate = dateFormat.parse(specimen_to_date);
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	String fromDateString = formatter.format(fromDate);
	String toDateString = formatter.format(toDate);
	
	Date actualFromDate =  formatter.parse(fromDateString);
	Date actualToDate =  formatter.parse(toDateString);
	
	String actualFromDateString = actualFromDate.toString();
	String actualToDateString = actualToDate.toString();


            _bw.write(_wl_block3Bytes, _wl_block3);

					try {
						con = ConnectionManager.getConnection();
						String fetchSelectedColumnQuery = "Select ELEMENT_ID From XH_APPL_ELEMENT Where APPLICATION_ID = ? And IN_USE_YN = 'Y' Order By To_Number(ELE_POS)";					
						pst = con.prepareStatement(fetchSelectedColumnQuery);
						pst.setString(1, app_id);
						rs = pst.executeQuery();
						columnCount = rs.getMetaData().getColumnCount();
	
			
						while(rs.next()){ 
							for(int i = 1; i<=columnCount; i++){
								onlyRequiredColumnQuery = rs.getString(i);
								listColumns.add(onlyRequiredColumnQuery);
							} 
						}
					

					   String strArr =  listColumns.toString();
					   String s1 = strArr.replace("[", ""); 
					   onlyRequiredColumnCompleteQuery = s1.replace("]", "");
					   
				if(notification_status.equals("Failed")){
					//columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					//String actualFailedQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ? AND (SUBMISSION_STATUS IN ('Not Submitted','Failed') OR DELIVERY_STATUS IN ('Failed'))" ;
					String actualFailedQuery = "select " + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ? AND (SUBMISSION_STATUS IN ('Not Submitted','Failed') OR DELIVERY_STATUS IN ('Failed'))" ;
					pst1 = con.prepareStatement(actualFailedQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
					
				}
				
				if(notification_status.equals("Success")){
					//columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					//String actualSuccessQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					String actualSuccessQuery = "select " + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					pst1 = con.prepareStatement(actualSuccessQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
				}
				
				// below code is for selecting only the rows that are SUCCESS and DELIVERED
				
				/* if(notification_status.equals("Sent")){
					columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					String actualSuccessQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Success') AND DELIVERY_STATUS IN ('Delivered') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?"; 
					pst1 = con.prepareStatement(actualSuccessQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
				} */
				
				if(notification_status.equals("All")){
					//columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					//String actualAllQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Not Submitted','Failed','Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					String actualAllQuery = "select " + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Not Submitted','Failed','Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					pst1 = con.prepareStatement(actualAllQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
				}
				
				columnCount1 = rs1.getMetaData().getColumnCount();
				boolean tableDataPresent = false;
				
				System.out.println("onlyRequiredColumnCompleteQuery: "+onlyRequiredColumnCompleteQuery);


			
            _bw.write(_wl_block4Bytes, _wl_block4);

							for(int i = 1; i<=columnCount1; i++){
				
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( rs1.getMetaData().getColumnName(i) ));
            _bw.write(_wl_block6Bytes, _wl_block6);

							}
					
				
            _bw.write(_wl_block7Bytes, _wl_block7);

						while(rs1.next()){ 
							tableDataPresent = true;
							
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tableDataPresent ));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(rs1.getString("MESSAGE_STATUS").equals("E")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

						 	
							for(int i = 1; i<=columnCount1; i++){ 
								String tableData = rs1.getString(i);
								if(rs1.wasNull()){
									tableData = " ";
								}
								
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( tableData ));
            _bw.write(_wl_block14Bytes, _wl_block14);
	} 
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
						
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(tableDataPresent ));
            _bw.write(_wl_block17Bytes, _wl_block17);
 }
			catch (Exception e1) {
 		System.out.println("TrackNotificationTable.jsp Exc1 : "
 				+ e1.toString());
 		e1.printStackTrace(System.err);
 	} finally {
 		if (rs1 != null)
 			rs1.close();
 		if (pst1 != null)
 			pst1.close();
 		if (rs != null)
 			rs.close();
 		if (pst != null)
 			pst.close();
 	}
 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( app_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( event_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( notification_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( specimen_from_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( specimen_to_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( onlyRequiredColumnCompleteQuery));
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
