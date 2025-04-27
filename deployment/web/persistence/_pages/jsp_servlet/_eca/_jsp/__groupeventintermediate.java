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
import java.net.*;
import eCA.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __groupeventintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/GroupEventIntermediate.jsp", 1736157589588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<div class=\"container\">\n\t\t\t\t<table cellspacing=\"0\"  style=\"width:100%;\">\n  \t\t\t\t\t<tr class=\"GridViewScrollItem GridText \">\n   \t\t \t\t\t<td><span>Date</span></td>\n   \t\t \t\t\t<td><span>Time</span></td>\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n   \t\t \t\t\t<td><span>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span></td>\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n                                    </tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t<tr class=\"GridViewScrollItem GridText\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t \t\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t \t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t \t\t\t\t\t\t\t\t<td  width=\"10%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t<td  width=\"10%\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n \t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<table>\n\t\t\t\t\t\t\t\t\t\t<tr>\n       \t \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</table>\n       \t \t\t\t\t\t\t\t\t</td>\n      \t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    \t\t\t\t\t\t\t\t   \n    \t\t\t\t\t\t\t\t   <td>&nbsp;</td>\n    \t\t\t\t\t\t\t   \t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n       \t\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n                                    \n</table>\n</div>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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


	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~ ");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("\\")!=-1) 
			resultStr = resultStr.replaceAll("\\\\","&#92");
		if(resultStr.indexOf("|")!=-1) 
			resultStr = resultStr.replaceAll("\\|","&#124");
		if(resultStr.indexOf("`")!=-1) 
			resultStr = resultStr.replaceAll("`","&#96");			
		if(resultStr.indexOf("'")!=-1) 
			resultStr = resultStr.replaceAll("'","&#39");
		if(resultStr.indexOf("~")!=-1) 
			resultStr = resultStr.replaceAll("~","&#126");
		if(resultStr.indexOf("\"")!=-1) 
			resultStr = resultStr.replaceAll("\"","\\\"");		
		if(resultStr.indexOf("+")!=-1) 
			resultStr = resultStr.replaceAll("\\+","&#43");	
		return resultStr;
	}
//Ramesh Start.
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class) 
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class, String event_class, String moreValues) 
//Ramesh End.
HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type,String enctr_id, String normalcy_str, String fac_id, String strMoreDlt, String ext_image_upld_id, String ext_img_file_locn, String recCountInt, String strPatientId, String dmsExternalLinkYN, String event_code_type, String order_id, String locale, String login_user, String resp_id, String login_at_ws_no, String order_typ_code, String admit_date, String locn_code, String locn_type, String visit_id, String loc_desc, String physician_id, String patient_class, String event_class, String moreValues,String lv_neonate_spec_yn,Boolean isSiteSpecificNeonatalMotherSpecimen)//31792 

	{
		int i = prevK;
		int j = columnNumber;

		String tempToolTip = toolTip.replace('\'',' ');

		String tempString = "";
		String classValue = "";
		String classValueGrn = "";
		String tempStrValue = "";
		String tempOnMouseOver = "";
		String displayStyle = "gridDataChart";
		
		HashMap returnMap = new HashMap();

		eCA.CAExternalLinkDataDTO externalDataDTO = null; 
		eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList();  
		
		String ext_image_appli_id = "";
		String ext_image_obj_id = "";
		String ext_image_source = "";
		String ext_srce_doc_ref_no = "";
		String ext_srce_doc_ref_line_no = "";
		ArrayList externalList = null;

		String labResultModifiedNotifier = ""; 
		classValue = "CACHARTQRYEVEN";

		if(keyList.contains(enctr_id+"`"+histRecType+"`"+sysID+"`"+accessionNum+"`"+sysEventCode))
			displayStyle = "gridDataSelect";
		else
			displayStyle = "gridDataChart";

		if(histDataType.equals("NUM"))
		{
			tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+resultNum+"'>"; 
			if(!tempAdditional.equals(""))
			{
				tempAdditional=replaceSpecialChar(tempAdditional.trim());
				if(tempAdditional.length() > 11)//IN069290(4->11)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,10)+"..</i></a>";//IN069290(3->10)
				else
					tempValue =tempValue+"&nbsp;<i>" +tempAdditional+"</i>";
			}
			if(!textCount.equals("0"))
			{
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
			}
		}
		else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
		{
			if(!tempAdditional.equals("")) 
			{	
				tempAdditional=replaceSpecialChar(tempAdditional);
				
			}

			if(!textCount.equals("0"))
			{
				tempValue = tempValue+ "&nbsp;" +"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">"; 
			}
		}
		else if(histDataType.equals("STR"))
		{
			
			if(tempValue.length() > 4)//IN069290(4->11)
			{
				//IN069290 starts 
				if(tempValue.length() > 11)
					tempStrValue = tempValue.substring(0,10);
				else
					tempStrValue = tempValue;
				//tempStrValue = tempValue.substring(0,3);
				//IN069290 ends
			
				tempValue = replaceSpecialChar(tempValue);
				tempValue=java.net.URLEncoder.encode(tempValue);
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"..</a>";
			}
			if(!normalcy_str.equals(""))
			{
				tempValue = tempValue + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
			}
			if(!textCount.equals("0"))
			{
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
			}
		}

		if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(strStatus)) {
			labResultModifiedNotifier = "<img id='modified_icon' style='display' src='../../eCA/images/modifiedresult.png' alt='Result Modified'>" + "&nbsp;";	
			tempValue = labResultModifiedNotifier + tempValue;
		}

		if(!tempValue.equals(""))
		{
			if(!called_from.equals("OR"))
			{
				if(quickTextCount.equals("0"))
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' style='display:none' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
				else
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
			}
			if(!called_from.equals("OR"))
			{
				if(strStatus.equals("E"))
				{
					 tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\" " ;
				}
				else if(strNormalcyInd.equals("I") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;

					tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+eventCode+i+"ID' style='cursor:pointer;border:0px' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"') \" ";
				}
				else if(strNormalcyInd.equals("C") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+eventCode+i+"ID' style='cursor:pointer;border:0px' align='center' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\" ";
				}
				else
				{
					tempString = tempString + "<TD class='gridDataSelect' background-color: #CDE5FF; style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID'  onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
			}
			else
			{
				if(strStatus.equals("E"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
				else if(legend_type.equals("S"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
					
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
				}
				else if(legend_type.equals("C"))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
				else
				{
					tempString = tempString + "<TD class='"+displayStyle+"' background-color: #CDE5FF; style='cursor:pointer;border:0px' align='center' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
				}
			}
		}
		else
		{
			if(strStatus.equals("E"))
			{
				tempString = tempString + "<TD align='center' class='TD_BROWN' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";
			}
			else
			{
				tempString = tempString + "<TD align='center' background-color: #CDE5FF; class='"+displayStyle+"' id='visibility"+eventCode+i+"ID' onClick=\"return changeColor(this,'"+enctr_id+"','"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','"+histDataType+"',escape('"+java.net.URLEncoder.encode(eventDesc)+"'),'"+resultNum+"','"+textCount+"','"+classValueGrn+"','"+sortEventDateTime+"','"+i+"','"+j+"','"+eventCode+"')\"";				
			}
		}

		if(!tempToolTip.equals("") || !toolTip_ind.equals(""))
		{
			tempOnMouseOver="onMouseOver=\"displayToolTip('"+tempToolTip+"','"+toolTip_ind+"',this)\" onMouseOut =hideToolTip('"+i+"','"+j+"')";
			 tempString = tempString + tempOnMouseOver;
		}

		
		if(tempValue.equals("")) 
		{
			tempValue = "&nbsp;";
		}

		
		if(!extApplID.equals(""))
		{
			if(!("DMS").equals(extApplID)) {
				if(!("DOCUL").equals(extApplID) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))
				{
				
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+extImgID+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}
				else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
				{
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}
				else if (!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
					if(!recCountInt.equals(null) && !recCountInt.equals("")) {
						int recordcount = Integer.parseInt(recCountInt);
						if(recordcount > 0) 
						{	
							tempValue =tempValue+"&nbsp;"+"<a style='cursor:pointer;color:blue;border:0px' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
						}
					}		
				}
			}
		}
		
		
		if("Y".equals(dmsExternalLinkYN)){
			
			try {
				externalList = oEncounterList.getExternalLinkdata(histRecType, sysID, accessionNum, sysEventCode); 
				Iterator iter = externalList.iterator();
				while(iter.hasNext()){
					externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
					ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
					ext_image_obj_id = externalDataDTO.getExt_image_obj_id();
					ext_image_source = externalDataDTO.getExt_image_source();
					ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
					ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();
					
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCommon/images/ExternalDocument.PNG'  title='External Link' onClick=\"return getExtLink('"+strPatientId+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+patient_class+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"; 
				}	
			} catch(Exception ex ){
				System.out.println(" 1517,FlowSheetEventsData.jsp => " + ex.getMessage());
			}
		}
		if(strStatus.equals("P"))
			tempValue = tempValue+" <font color='red'>(Preliminary)</font>";

		if(!deltaFailInd.equals(""))
		{
			tempValue = tempValue+"<font color='red'>["+deltaFailInd+"]</font>";
		}
		if((strNormalcyInd.equals("I") || strNormalcyInd.equals("B") )&& !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
		{
			//tempValue = tempValue+ "<font color='black'><b>["+descCellInd+"]</b></font>";
		}
		//31792 starts
				if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){
				tempString = tempString + ">" + tempValue + "&nbsp;<input type='image' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+accessionNum+"','"+histRecType+"','"+strPatientId+"')\">" + strMoreDlt;
				}
				else{
				tempString = tempString + ">" + tempValue + "&nbsp;<br>" + strMoreDlt;
				}
				//31792 ends
		//Ramesh Start.
		if ("Y".equals(moreValues))
			tempString = tempString + "<a href=\"javascript:callResults('"+ eventDateTime + "','" + eventDateTime
					+ "','" + eventDesc + "','" + histRecType + "','" + event_class + "','" + eventGroup + "','" + eventCode
					+ "')\" title='Click to view other recording of this event for the same time' >More Values...</a>";
		//Ramesh End.
		tempString = tempString + "</TD>";

		try
		{
			returnMap.put("tempString",tempString);
			returnMap.put("histRecType"+i,histRecType);
			returnMap.put("eventClass"+i,eventClass);
			returnMap.put("eventGroup"+i,eventGroup);
			returnMap.put("eventCode"+i,eventCode);
			returnMap.put("eventDateTime"+i+"Map"+j,eventDateTime);
			returnMap.put("resultNum"+i+"Map"+j,resultNum);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return returnMap;
	}// end of drawTD


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
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
13/03/2019	IN069290		Raja S			13/03/2019		Ramehs G		ML-MMOH-CRF-1317
21/02/2020	IN072473	SIVABAGYAM M			21/02/2020		RAMESH G		ML-MMOH-SCF-1477
05/05/2020	IN072901	SIVABAGYAM M		05/05/2020		RAMESH G		ML-MMOH-SCF-1477.1
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
----------------------------------------------------------------------------------------------------------------------------------------------------------
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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8"); 


		String modeId 		=  request.getParameter("Mode")==null ? "" : request.getParameter("Mode"); 
		String bean_id		=  request.getParameter("Mode")==null ? "" : request.getParameter("Mode");
		String bean_name		=  request.getParameter("bean_name")==null ? "" : request.getParameter("bean_name");
		String locale		=  request.getParameter("locale")==null ? "" : request.getParameter("locale");
		String patient_id		=  request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
		String encounter_id		=  request.getParameter("encounter_id")==null ? "" : request.getParameter("encounter_id");
		String from_date		=  request.getParameter("from_date")==null ? "" : request.getParameter("from_date");
		String to_date		=  request.getParameter("to_date")==null ? "" : request.getParameter("to_date");
		String event_class		=  request.getParameter("event_class")==null ? "" : request.getParameter("event_class");
		String grp_code		=  request.getParameter("grp_code")==null ? "" : request.getParameter("grp_code");
		String grpyear		=  request.getParameter("grpyear")==null ? "" : request.getParameter("grpyear");
		String grpmonth 		=  request.getParameter("grpmonth")==null ? "" : request.getParameter("grpmonth");
		String grphistory_type 		=  request.getParameter("grphistory_type")==null ? "" : request.getParameter("grphistory_type");
		String catalog_nature 		=  request.getParameter("orderCatalogNature")==null ? "" : request.getParameter("orderCatalogNature");
		String clinician_id 		=  request.getParameter("clinician_id")==null ? "" : request.getParameter("clinician_id");
		String resp_id 		=  request.getParameter("resp_id")==null ? "" : request.getParameter("resp_id");
		String called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
		String login_user = (String)session.getValue("login_user");
		String strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");	
		boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
		Connection con = null;
		LinkedHashMap groupResultMap = null;
		HashMap tempTRMap = null;
	try 
	{
		ArrayList groupHeaderVal = new ArrayList() ;
		if("GroupDetails".equals(modeId)){
			con = ConnectionManager.getConnection(request);	 
			eCA.PatientBannerGroupLine manageEmailBean = null;
			isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(con,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
			manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

				GroupCompDetailBean bean	= (GroupCompDetailBean)getBeanObject( bean_id, bean_name , request) ; 
				groupHeaderVal=bean.getTestHeader(con,locale,grphistory_type,catalog_nature,event_class,grp_code,grpyear,grpmonth,patient_id,encounter_id,clinician_id,resp_id,from_date,to_date);
				
				
            _bw.write(_wl_block5Bytes, _wl_block5);

                                      for(int i=0;i<groupHeaderVal.size();i++)
                                      {
                                    	  String groupHeader[] =(String[])groupHeaderVal.get(i);
                                      
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(groupHeader[1]));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
                                      
            _bw.write(_wl_block8Bytes, _wl_block8);

								groupResultMap=bean.getGroupDetails(pageContext,con,locale,login_user,grphistory_type,catalog_nature,event_class,grp_code,grpyear,grpmonth,patient_id,encounter_id,clinician_id,resp_id,from_date,to_date);
 								String dateTime ="";
 								LinkedHashMap dateValuesMap = null;//IN072473 changed from hashmap to linked hashmap
 								int tempNumOfCols= 1;//Doubt

 								String tempDisplayEventCode ="";
 								String tempDisplayEventGroup = "";
 								String tempDisplayHistRecType = "";
 								String tempDisplayEventClass ="";
 								String sortEventDateTime ="";
 								String ext_img_file_locn="";
 								String recCountInt = "";
 								String normal_Yn = "";
 								String order_id = "";
 								
 								String login_at_ws_no ="";
 								String order_typ_code = "";
 								String admit_date ="";
 								String locn_code ="";
 								String locn_type="";
 								String visit_id="";
  								String loc_desc="";
  								String physician_id="";
   								String patient_class="";
   								int k=1;
  								 
 								ArrayList keyList = manageEmailBean.returnList2();
 								String dmsExternalLinkYN = manageEmailBean.getExternalDmsLinkYN("RP");
 								int prevK = 0;
 								String tempDate = "";
	 							for (Object key : groupResultMap.keySet()) {
		 							dateTime=(String)key;
		 							dateValuesMap = (LinkedHashMap)groupResultMap.get(key);//IN072473 changed from hashmap to linked hashmap
		 							String[] dt = dateTime.split(" ");
								
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(dt[0].equals(tempDate)){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{ 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dt[0]));
            _bw.write(_wl_block12Bytes, _wl_block12);
		} 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dt[1]));
            _bw.write(_wl_block12Bytes, _wl_block12);
	tempDate=(String)dt[0];
									for(int i=0;i<groupHeaderVal.size();i++)
      								{
      									String groupHeader[] =(String[])groupHeaderVal.get(i);
      									
      									if(dateValuesMap.containsKey(groupHeader[0])){
      										ArrayList<String> eventDetails = new ArrayList<String>() ;
      										eventDetails=(ArrayList)dateValuesMap.get(groupHeader[0]);
      										String reqNum = (String)eventDetails.get(31);
      										//if(reqNum.equals(groupHeader[2])){//commented for IN072901
      											String eventDateTime=(String)eventDetails.get(0);
      											String histDataType=(String)eventDetails.get(5);
      											String resultNum=(String)eventDetails.get(3);
      											String resultStr=(String)eventDetails.get(4);
      											String extApplID=(String)eventDetails.get(6);
      											
      											String sysID=(String)eventDetails.get(7);
      											String accessionNum=(String)eventDetails.get(8);
      											String sysEventCode=(String)eventDetails.get(9);
      											String extImgID=(String)eventDetails.get(10);
      											
      											String toolTip=(String)eventDetails.get(11);
      											String toolTip_ind=(String)eventDetails.get(12);
      											String deltaFailInd=(String)eventDetails.get(13);
      											String quickTextCount=(String)eventDetails.get(14);
      											String strStatus=(String)eventDetails.get(15);
      											String textCount=(String)eventDetails.get(16);
      											
      											String colorCellInd=(String)eventDetails.get(17);
      											String descCellInd=(String)eventDetails.get(18);
      											String normIndicator=(String)eventDetails.get(19);
      											String eventCode=(String)eventDetails.get(20);
      											String eventDesc=(String)eventDetails.get(21);
      											String legend_type=(String)eventDetails.get(22);
      											String normalcy_str=(String)eventDetails.get(23);
      											String fac_id=(String)eventDetails.get(24);
      											String ext_image_upld_id=(String)eventDetails.get(25);
      											String event_code_type=(String)eventDetails.get(26);
      											recCountInt =(String)eventDetails.get(27);
      											ext_img_file_locn =(String)eventDetails.get(28);
												normal_Yn	= (String)eventDetails.get(30);
												String eventClass = (String) eventDetails.get(32); //Ramesh
												String moreValues = (String) eventDetails.get(33); //Ramesh
												String lv_neonate_spec_yn = (String) eventDetails.get(34); //31792
												
      											
      											//if(strNormalcyInd.equals("I") || legend_type.equals("S"))//Need to check for legend_type S wrks only for called_from =OR
												if(strNormalcyInd.equals("I"))
      												colorCellInd = (String)eventDetails.get(29);
      											
      											String tempAdditional = resultStr;
      											String tempValue = "";
      											if(histDataType.equals("NUM")) 
      												tempValue = resultNum;
      											else if(histDataType.equals("STR")) 
      												tempValue = resultStr;
      											else if(histDataType.equals("TXT") || histDataType.equals("IMG") || histDataType.equals("HTM")) 
      												tempValue = "";
      											
      											  
									
      											//Ramesh Start.
      											//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, grp_code, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounter_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class );
      											//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, grp_code, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounter_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,eventClass, moreValues );
      											
												//Ramesh End.
												tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, grphistory_type, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, grp_code, event_class, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,encounter_id,normalcy_str,fac_id, "",ext_image_upld_id, ext_img_file_locn ,recCountInt, patient_id, dmsExternalLinkYN, event_code_type, order_id, locale, login_user, resp_id, login_at_ws_no, order_typ_code, admit_date, locn_code, locn_type, visit_id, loc_desc, physician_id, patient_class,eventClass, moreValues,lv_neonate_spec_yn,isSiteSpecificNeonatalMotherSpecimen );//31792
      											
												prevK++;
      											String tempReturnString = (String) tempTRMap.get("tempString");
      											
      											
      										
      											
      											
      											
      											
      											
      											
      											
 									
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tempReturnString));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
    							  
      									
      								}
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
 


            _bw.write(_wl_block18Bytes, _wl_block18);
}
								

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
