package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import webbeans.eCommon.ConnectionManager;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patorderbylocnordersview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PatOrderByLocnOrdersView.jsp", 1709119908000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/PatOrderByLocn.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/RegisterOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!-- Included to call the common view function-->\n \t<Style TYPE=\"text/css\"> </style>\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n <form name=\"PatOrderView\" id=\"PatOrderView\" >\n<table cellpadding=5 cellspacing=2 border=1 width=\"100%\" align=\"center\" class=\"grid\">\n\t<tr>\n\t\t<td CLASS=\"DATA\" align=\"left\"> <font size=\"1\">Patient Name / Orderables </font></td>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<td CLASS=\"OR_ORDERABLES\"  align=\"left\" width=\"30%\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\");\' onMouseOut=\"hideToolTip();\">\n\t\t\t<font size=\"1\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font>\n\t\t</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n\t\t<td CLASS=\"OR_ORDERABLES\" align=\"left\"><font size=\"1\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td CLASS=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" align=\"left\" nowrap>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<!--<table cellpadding=0 cellspacing=0 border=0 align=\"left\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td CLASS=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" align=\"left\" nowrap>--><font size=\"1\"><a class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" href=\"#\" onClick=\'callMenuFunctions(\"View\",\"\",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></font><br><br>\n\t\t\t\t\t\t\t\t<!--</td>\n\t\t\t\t\t\t\t\t<td CLASS=\"LABEL\" align=\"left\" nowrap>-->\n\t\t\t\t\t\t<font size=\"1\">\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"result_str_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"result_str_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t<!--</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>-->\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n</form>\n\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\"  width=\"100%\" height=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"100%\" id=\"td_id\"></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String code 					= request.getParameter( "code" ) ;
	String[] record					= null;
	String[] orderable_record		= null;
	String[] result_record			= null;

	String bean_id 	 				= "Or_PatOrderByLocnBean" ;
	String bean_name 				= "eOR.PatOrderByLocnBean";
	String class_value				= "";
	StringBuffer stPatient			= new StringBuffer();
	//PatOrderByLocnBean bean 		= (PatOrderByLocnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	PatOrderByLocnBean bean			= (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList PatientDetails 		= bean.getNursingUnitPatientDetails(code) ;
	ArrayList OrderableResultDtls	= null;
	ArrayList OrderableDetails 		= null;
	ArrayList ResultDetails 		= null;
	ArrayList Patient				= null;	// ArrayList to store the Patients
	String color 					= "";
	StringBuffer patient_tool_tip	= null;

	int val							= 0;

	/* For Result Details */
	String accession_num			= null;
	String hist_rec_type			= null;
	String contr_sys_event_code		= null;
	String contr_sys_id				= null;
	String ext_image_appl_id		= null;
	String normalcy_ind				= null;
	String hist_data_type			= null;
	String normal_low				= null;
	String normal_high				= null;
	String result_num_uom			= null;
	String result_num				= null;
	String result_str				= null;
	String ext_image_obj_id			= null;
	String long_desc				= null;

	String result_clob				= null;
	StringBuffer disp_value			= null;

	String result_data[] 			= (String[])bean.getAbnormalCondition();
	String high_str					= (result_data[0]==null?"":result_data[0]);
	String low_str					= (result_data[1]==null?"":result_data[1]);
	String abn_str					= (result_data[2]==null?"":result_data[2]);
	String crit_str					= (result_data[3]==null?"":result_data[3]);
	String crit_high_str			= (result_data[4]==null?"":result_data[4]);
	String crit_low_str				= (result_data[5]==null?"":result_data[5]);


	/* End */


            _bw.write(_wl_block5Bytes, _wl_block5);


		if(PatientDetails!=null && PatientDetails.size() > 0) {
			Patient			 = new ArrayList();
			for( int i=0 ; i< PatientDetails.size() ; i++ ) {
				record 		= (String[])PatientDetails.get(i);
				stPatient.append("'"+(record[1]==null?"":record[1])+ "',");
				patient_tool_tip = new StringBuffer();
				patient_tool_tip.append("Patient Id :- "+ (record[1]==null?"":record[1]));
				patient_tool_tip.append("<br> Sex :- "+ (record[3]==null?"":record[3]));
				patient_tool_tip.append("<br> Age :- "+ (record[4]==null?"":record[4]));
				Patient.add(record[1]);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_tool_tip.toString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block8Bytes, _wl_block8);
			patient_tool_tip = null;
		}
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

	if(stPatient!=null && stPatient.length() > 0){
		OrderableDetails = bean.getOrderableDetails(stPatient) ;
			for( int i=0 ; i< OrderableDetails.size() ; i++ ) {
				val			= 0;
				record 		= (String[])OrderableDetails.get(i);
				record[0]	= (record[0]==null?"":record[0]);
				record[1]	= (record[1]==null?"":record[1]);
				record[2]	= (record[2]==null?"":record[2]);

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);

				// To put the Loop and the TD's
				for( int k=0 ; k< PatientDetails.size() ; k++ ) {

				/*if(k % 2 == 0){
					class_value = "QRYEVEN";
				}else{
					class_value = "QRYODD";
				}*/
				class_value="gridData";


            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block13Bytes, _wl_block13);
				if( (((String)Patient.get(k)).equals(record[2])) && val==0) {
					OrderableResultDtls = bean.getOrderableResultDetails(record[1],record[2]); //order_catalog_code and Patient ID
					val++;	//Increment so that Next time, no need to enter
					for( int j=0 ; j< OrderableResultDtls.size() ; j++ ) {
						orderable_record	=  (String[])OrderableResultDtls.get(j);
						orderable_record[0]	= (orderable_record[0]==null?"":orderable_record[0]);
						orderable_record[1]	= (orderable_record[1]==null?"":orderable_record[1]);
						orderable_record[2]	= (orderable_record[2]==null?"":orderable_record[2]);
						orderable_record[6]	= (orderable_record[6]==null?"":orderable_record[6]);

						if(orderable_record[2]!=null && (!orderable_record[2].equals("CO") || !orderable_record[2].equals("CN")) && orderable_record[4].equals("PH"))
							color = "ORYELLOW";
						else if(orderable_record[2]!=null && (orderable_record[2].equals("CN") || orderable_record[2].equals("RJ") || orderable_record[2].equals("RP") || orderable_record[2].equals("FC")) )
							color = "ORCANCEL";
						else if(orderable_record[2]!=null && (orderable_record[2].equals("CD") || orderable_record[2].equals("RS") || orderable_record[2].equals("RA")))
							color = "ORGREEN";
						else if(orderable_record[2]!=null && (orderable_record[2].equals("HD") || orderable_record[2].equals("HC") || orderable_record[2].equals("DC")))
							 color = "OAGREEN";
						else color = "LABEL";

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(color));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(color));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderable_record[1]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(orderable_record[0]));
            _bw.write(_wl_block19Bytes, _wl_block19);

									ResultDetails	= bean.getResultDetails(record[2],orderable_record[1],orderable_record[6]);
 									for( int z=0 ; z< ResultDetails.size() ; z++ ) {
										 result_record		= (String[])ResultDetails.get(z);
										 disp_value			= new StringBuffer();
										 disp_value.append("&nbsp");
										 accession_num		= (result_record[0]==null?"":result_record[0]);
										 hist_rec_type		= (result_record[1]==null?"":result_record[1]);
										 contr_sys_event_code		= (result_record[2]==null?"":result_record[2]);
										 hist_data_type		= (result_record[12]==null?"":result_record[12]);
										 result_num			= (result_record[14]==null?"":result_record[14]);
										 result_num_uom		= (result_record[15]==null?"":result_record[15]);
										 result_str			= (result_record[16]==null?"":result_record[16]);
										 normalcy_ind		= (result_record[17]==null?"":result_record[17]);
										 normal_low			= (result_record[18]==null?"":result_record[18]);
										 normal_high		= (result_record[19]==null?"":result_record[19]);
										 ext_image_obj_id	= (result_record[25]==null?"":result_record[25]);
										 ext_image_appl_id	= (result_record[26]==null?"":result_record[26]);
										 long_desc			= (result_record[39]==null?"":result_record[39]);
										 contr_sys_id			= (result_record[40]==null?"":result_record[40]);

										 if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
											normalcy_ind = "<FONT COLOR='RED' >Abnormal</FONT>";
										 else if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
											normalcy_ind = "<FONT COLOR='MAGENTA'>Critical Abnormal</FONT>";
										 else if(normalcy_ind!=null && !normalcy_ind.equals(""))
											normalcy_ind = "<FONT COLOR='RED' >Abnormal</FONT>";
										 else
											normalcy_ind = "&nbsp;";

										 if(hist_data_type.trim().equals("NUM")){
											disp_value.append(result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;"+"("+normal_low+"-"+normal_high+")"+" "+normalcy_ind);
											if(result_str!=null && !result_str.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewComments('"+i+"_"+j+"_"+k+"_"+z+"')\"> Result Comments </a>");
											}
											result_clob 	= "";//bean.getClobData(accession_num);
											if(result_clob!=null && !result_clob.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewClobData('"+accession_num+"')\"> ");
												disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
											}
										  }else if(hist_data_type.trim().equals("STR")){
											 if(result_str!=null && !result_str.equals(""))
											 {
												disp_value.append("&nbsp;<a href=\"javascript:viewComments('"+i+"_"+j+"_"+k+"_"+z+"')\"> Result Comments </a>");
											 }
											 disp_value.append( " "+normalcy_ind);
											 result_clob	 = "";//bean.getClobData(accession_num);
											 if(result_clob!=null && !result_clob.equals(""))
											 {
											 	disp_value.append( "&nbsp;<a href=\"javascript:viewClobData('"+accession_num+"')\"> ");
												disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
											 }
										   }else if(hist_data_type.trim().equals("TXT")){
											if(result_str!=null && !result_str.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewComments('"+i+"_"+j+"_"+k+"_"+z+"')\"> Result Comments </a>");
											}
											disp_value.append(" "+normalcy_ind);
											result_clob		  = "";//bean.getClobData(accession_num);
											if(result_clob !=null && !result_clob.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewClobData('"+accession_num+"')\"> ");
												disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
											}
										}
										if ((ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_appl_id!=null && !ext_image_appl_id.equals("")) ) {
											//disp_value.append("&nbsp;<IMG SRC='../images/Xray.gif' WIDTH='16' HEIGHT='16' BORDER=0>");
											disp_value.append("&nbsp;<a href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\"> ");
											disp_value.append("<IMG SRC='../../eCA/images/"+ext_image_appl_id+".gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
										}
										out.println("<br>&nbsp;&nbsp;"+long_desc+"&nbsp;&nbsp;"+disp_value.toString()+"<br><br>");

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(z));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(z));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block24Bytes, _wl_block24);
									disp_value = null; // Remove
								} // End of z

            _bw.write(_wl_block25Bytes, _wl_block25);
			}
		}else {
			out.println("&nbsp;");
		} // End of OrderableResultDtls -- for

            _bw.write(_wl_block26Bytes, _wl_block26);
		}  // End of PatientDetails -- for

            _bw.write(_wl_block9Bytes, _wl_block9);
		} // End of OrderableDetails -- for
	}	
            _bw.write(_wl_block27Bytes, _wl_block27);

		putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block28Bytes, _wl_block28);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
