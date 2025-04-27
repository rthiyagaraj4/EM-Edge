package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.PatTaskListRepository;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __pattasklistpopulationresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatTaskListPopulationResult.jsp", 1741318616045L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\nvar ThpatientId =document.getElementById(\'tdPatientId\'+";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =");\nvar \ttdTaskType\t=document.getElementById(\'tdTaskType\'+";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =");\nif(patientId.value !=\'\'||\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==\'9\' || \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"==\'9\')\n{\n\tThpatientId.style.display=\'none\'\n}\nif(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"==\'3\' || \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"==\'3\')\n{\n\ttdTaskType.style.display=\'none\'\n}\n</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</form>\n</body>\n</SCRIPT>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            eCA.PatTaskListRepository patTask= null;{
                patTask=(eCA.PatTaskListRepository)pageContext.getAttribute("patTask");
                if(patTask==null){
                    patTask=new eCA.PatTaskListRepository();
                    pageContext.setAttribute("patTask",patTask);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);


try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	ArrayList arrayStatusDesc = null;
	String taskSelect =  request.getParameter("taskSelect")==null ? "" : request.getParameter("taskSelect");
	String dateTime = request.getParameter("dateTime")==null ? "" :request.getParameter("dateTime");
	//RequestDispatcher reqDispatcher  = null;
	String patientDetail =  request.getParameter("patientDetail")==null ? "" :  request.getParameter("patientDetail");
	if(patientDetail.equals("3") || dateTime.equals("3")||taskSelect.equals("3"))
	{
		out.println("<script>document.getElementById('thTaskType').style.display='none'</script>");
	}
	if(patientDetail.equals("9") || dateTime.equals("9")||taskSelect.equals("9"))
	{
		out.println("<script>document.getElementById('thPatDetails').style.display='none'</script>");
	}

	ArrayList arrayDateTime = null;
	StringTokenizer tokenSpace = null;
	ArrayList arrayTaskType= null;
	ArrayList arrayTask= null;
	ArrayList arrayPriority= null;
	ArrayList arrayPatDetail= null;
	ArrayList arrayStatus= null;
	ArrayList arrayTaskSrlNo = null;	
	ArrayList arrayRemarks=null;
	ArrayList arrayPerformedId=null;
	ArrayList arrayResultType=null;
	boolean Flag = (request.getAttribute("MainGrpFlag")==null) ? false :((Boolean)request.getAttribute("MainGrpFlag")).booleanValue();
	boolean flag =  (request.getAttribute("SubGrpFlag")==null) ? false :((Boolean)request.getAttribute("SubGrpFlag")).booleanValue();
	boolean flag1 = false;
	ArrayList arrayResultId=null;
	ArrayList arrayEncounterId= null;
	ArrayList arrayFacilityId= null;
	ArrayList arrayTaskCategory = null;
	ArrayList arrayScheduleDateTime= null;
	ArrayList arrayOrderId= null;
	ArrayList arrayOrderNum = null;
	ArrayList arrayPatientId = null;
	String adminStatus="";
	ArrayList arrayOrderStatusCode = null;
	ArrayList arrayStageDesc = null;

	ArrayList arrayApplicableYN = new ArrayList();
	ArrayList arrayGuildeLinelength = new ArrayList();
	ArrayList arrayPositionDesc = new ArrayList();

	String encounterId ="";

	String facilityId ="";
	String resultType ="";
	String resultId ="";
	ArrayList retArray =(ArrayList) request.getAttribute("retArray");
	ArrayList mainGrp = (ArrayList) request.getAttribute("MainGrp");
	ArrayList subGrp 	= (ArrayList) request.getAttribute("SubGrp");
	
	ArrayList tempArray=null;
	String classValue="";
	String grpHeading="";
	String prevGrpHeading="";	
	String grpHeadingSecond = "";
	String prevGrpHeadingSecond = "";
	String grpHeadingThird = "";
	String prevGrpHeadingThird = "";String tdColor="";
	StringTokenizer tokenColon = null;
	String time="";
	String taskCode ="";
	String taskTypeCode="";
	String taskDesc="";	
	String tempHeader = "";
	String taskTypeDesc = "";
	String remarks="";
	String performedId = "";
	int indexJ=0;
	int indexK=0;
	int indexI=0;
	int temp=0;
	int noOfRows=0;
	int tempI=0;
	int tempJ=0;
	if(retArray != null)
	{
		arrayDateTime = (ArrayList)retArray.get(0);
		arrayTaskType	 = (ArrayList)retArray.get(1);
		arrayTask	 = (ArrayList)retArray.get(2);
		arrayPriority	 = (ArrayList)retArray.get(3);
		arrayPatDetail	 = (ArrayList)retArray.get(4);
		arrayStatus	 = (ArrayList)retArray.get(5);
		arrayTaskSrlNo= (ArrayList)retArray.get(6);
		arrayRemarks= (ArrayList)retArray.get(7);
		arrayPerformedId= (ArrayList)retArray.get(8);
		arrayResultType= (ArrayList)retArray.get(9);
		arrayResultId= (ArrayList)retArray.get(10);
		arrayEncounterId= (ArrayList)retArray.get(11);
		arrayFacilityId= (ArrayList)retArray.get(12);
		arrayTaskCategory = (ArrayList)retArray.get(13);
		arrayScheduleDateTime= (ArrayList)retArray.get(14);
		arrayOrderId= (ArrayList)retArray.get(15);
		arrayOrderNum = (ArrayList)retArray.get(16);
		arrayPatientId= (ArrayList)retArray.get(17);
		arrayStatusDesc= (ArrayList)retArray.get(18);
		arrayOrderStatusCode= (ArrayList)retArray.get(19);arrayStageDesc= (ArrayList)retArray.get(20);

		arrayApplicableYN = (ArrayList)retArray.get(21);
		arrayGuildeLinelength = (ArrayList)retArray.get(22);
		arrayPositionDesc = (ArrayList)retArray.get(23);
        
		if(taskSelect.equals("6"))
			{
						if(retArray != null)					
						{	
							tempArray =(ArrayList)retArray.get(14);
							
						}
			}
			else if(taskSelect.equals("3"))
			{
					if(retArray != null)					
					{	
						tempArray =(ArrayList)retArray.get(1);
					}
			}
			else
			{
					if(retArray != null)					
					{	
						tempArray =(ArrayList)retArray.get(17);
						flag1 = true;
					}
			}
			
			if(mainGrp != null)
			{
				for(int index =0 ; index < mainGrp.size() ;index++)
				{
					grpHeading = (String)mainGrp.get(index);
					if(grpHeading.indexOf("/") != -1)
					{
						tokenSpace = new StringTokenizer(grpHeading," ");
						grpHeading = tokenSpace.nextToken();
					}
					if(index % 2 ==0) 
						classValue="QRYEVEN" ;
					else
						classValue="QRYODD";
					if(grpHeading.indexOf(":") != -1)						
					{
						tokenColon = new StringTokenizer(grpHeading,":");
						grpHeading = tokenColon.nextToken();
					}
									adminStatus = arrayOrderStatusCode.get(index).toString()==null ? "" :arrayOrderStatusCode.get(index).toString();
							if(adminStatus.equals("D"))
								{
									tdColor = "#CCFFCC";	
								}
								else if(adminStatus.equals("O"))
								{
									tdColor = "#FFFFCC";
								}
								else if(adminStatus.equals("E"))
								{
									tdColor = "#D5006A";
								}
								else if(adminStatus.equals("C"))
								{
									tdColor = "#0099FF";

								}
								else if(adminStatus.equals("F"))
								{
									tdColor = "#FFCCCC";
								}
					if(!grpHeading.equals(prevGrpHeading))
					{
						if(Flag== true)
						tempHeader = arrayPatDetail.get(index).toString();
						else	
						tempHeader = grpHeading;
						out.println("<tr id='mainRow"+indexJ+"'>");
						out.println("<td  nowrap class='CAHIGHERLEVELCOLOR'>&nbsp;</td>");
						out.println("<td class='CAHIGHERLEVELCOLOR' align='center'><a href='javascript:' OnClick='collapseAllMainRows(this,"+indexJ+")'>-</a></td>"+"<td class='CAHIGHERLEVELCOLOR' colspan='8' align='left'>"+tempHeader+"</th>");	
						out.println("</tr>");
						if(!prevGrpHeading.equals(""))
						{
							out.println("<input type='hidden' name='subHeader"+indexK+"' id='subHeader"+indexK+"' value='"+temp+"'>");
							out.println("<input type='hidden' name='lastHeader"+indexK+""+indexI+"' id='lastHeader"+indexK+""+indexI+"' value='"+tempI+"'>");
							out.println("<input type='hidden' name='noOfRows"+indexK+""+indexI+""+tempJ+"' id='noOfRows"+indexK+""+indexI+""+tempJ+"' value='"+noOfRows+"'>");

						}
						prevGrpHeading = grpHeading;
						prevGrpHeadingSecond="";
						indexK=indexJ;
						temp=0;
						indexJ++;
					}
					grpHeadingSecond = subGrp.get(index) == null ? "" : (String)subGrp.get(index);
					if(grpHeadingSecond.indexOf("/") != -1)
					{
						tokenSpace = new StringTokenizer(grpHeadingSecond," ");
						grpHeadingSecond = tokenSpace.nextToken();
					}
					if(grpHeadingSecond.indexOf(":") != -1)						
					{	
						
						tokenColon = new StringTokenizer(grpHeadingSecond,":");
						grpHeadingSecond = tokenColon.nextToken();
					}
					if(!grpHeadingSecond.equals(prevGrpHeadingSecond))
					{
						if(flag== true)
						tempHeader = arrayPatDetail.get(index).toString();
						else	
						tempHeader = grpHeadingSecond;
						out.println("<tr id='subRow"+indexK+""+temp+"'>");
							out.println("<td  nowrap class='PLANSUBHEAD'>&nbsp;</td>");
						out.println("<td class='PLANSUBHEAD'>&nbsp;</td><td class='PLANSUBHEAD' align='center'><a href='javascript:' id='subLink"+indexK+""+temp+"' OnClick='collapseAllSubRows(this,"+indexK+","+temp+")'>-</a></td>"+"<td class='PLANSUBHEAD' colspan='7' align='left'>"+tempHeader+"</th>");	
						out.println("</tr>");
						if(!prevGrpHeadingSecond.equals(""))
						{
							out.println("<input type='hidden' name='lastHeader"+indexK+""+indexI+"' id='lastHeader"+indexK+""+indexI+"' value='"+tempI+"'>");
							out.println("<input type='hidden' name='noOfRows"+indexK+""+indexI+""+tempJ+"' id='noOfRows"+indexK+""+indexI+""+tempJ+"' value='"+noOfRows+"'>");

						}
						prevGrpHeadingSecond = grpHeadingSecond;
						prevGrpHeadingThird ="";
						indexI = temp;
						tempI=0;
						temp++;
						
					}
					grpHeadingThird = (String)tempArray.get(index)==null ? "" : (String)tempArray.get(index);
					if(grpHeadingThird.indexOf("/") != -1)
					{
						tokenSpace = new StringTokenizer(grpHeadingThird," ");
						grpHeadingThird = tokenSpace.nextToken();
					}
					if(grpHeadingThird.indexOf(":") != -1)						
					{	
						
						tokenColon = new StringTokenizer(grpHeadingThird,":");
						grpHeadingThird = tokenColon.nextToken();
					}
					if(!grpHeadingThird.equals(prevGrpHeadingThird))
					{
							if(flag1== true)
						tempHeader = arrayPatDetail.get(index).toString();
						else	
						tempHeader = grpHeadingThird;
						out.println("<tr id='lastRow"+indexK+""+indexI+""+tempI+"'>");
						out.println("<td  nowrap class='CAGROUPHEADING'>&nbsp;</td>");
						out.println("<td class='CAGROUPHEADING'>&nbsp;</td><td class='CAGROUPHEADING'>&nbsp;</td>"+"<td class='CAGROUPHEADING' align='center'><a href='javascript:'  id ='lastLink"+indexK+""+indexI+""+tempI+"' OnClick='collapseAllRows(this,"+indexK+","+indexI+","+tempI+")'>-</a></td><td class='CAGROUPHEADING' colspan='7' align='left'>"+tempHeader+"</td>");	
						out.println("</tr>");

						if(!prevGrpHeadingThird.equals(""))
						{
							
							
							out.println("<input type='hidden' name='noOfRows"+indexK+""+indexI+""+tempJ+"' id='noOfRows"+indexK+""+indexI+""+tempJ+"' value='"+noOfRows+"'>");
						}
						prevGrpHeadingThird = grpHeadingThird;
						tempJ = tempI;
						tempI++;
						noOfRows=0;
					}
				out.println("<tr id ='rowId"+indexK+""+indexI+""+tempJ+""+noOfRows+"'>");	
					out.println("<td nowrap  style='background:"+tdColor+"' class='label' align='center'><B>"+arrayTaskCategory.get(index).toString()+"</B></td>");
				out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
				out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");
				out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");
				tokenColon = new StringTokenizer((String)arrayScheduleDateTime.get(index)," ");
				time = tokenColon.nextToken();
				time = tokenColon.nextToken();
				tokenColon = new StringTokenizer((String)arrayTaskType.get(index),":");
				taskTypeDesc = tokenColon.nextToken();
				taskTypeCode = tokenColon.nextToken();
				
				tokenColon = new StringTokenizer((String)arrayTask.get(index),":");
				taskDesc = tokenColon.nextToken();
				taskCode = tokenColon.nextToken();
				resultType=(String)arrayResultType.get(index) == null ? "" : (String)arrayResultType.get(index);
				resultId=(String)arrayResultId.get(index) == null ? "" : (String)arrayResultId.get(index);
				encounterId = (String)arrayEncounterId.get(index) == null ? "" : (String)arrayEncounterId.get(index);
				facilityId = (String)arrayFacilityId.get(index) == null ? "" : (String)arrayFacilityId.get(index);
				out.println("<td  nowrap class='"+classValue+"'>"+time+"</td>");
				out.println("<td   class='"+classValue+"' id='tdTaskType"+index+"'>"+taskTypeDesc+"</td>");


				String anchor_guideLine = "";
				if (Integer.parseInt((String)arrayGuildeLinelength.get(index)) > 0)
				{
					anchor_guideLine = "&nbsp;&nbsp;<a href='javascript:' onclick='showGuideLine(\"" + taskCode + "\")'><font color='BLUE'>(G)</font></a>";
				}
				else
					anchor_guideLine = "&nbsp;";



				if(adminStatus.equals("D") || adminStatus.equals("O"))
					{
				if(arrayTaskCategory.get(index).toString().equals("I"))
				{
				if( ((String)arrayStatus.get(index)).equals("Pending") && ((String)arrayApplicableYN.get(index)).equals("Y")) 
				{
							if(resultType.equals(""))
							{
									out.println("<td nowrap class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTipForPopulationResult(event,"+index+","+indexK+","+indexI+","+tempJ+","+noOfRows+")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
							
							}
							else
							{
										out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEventsPopulationResult(event,"+index+" ,"+indexK+","+indexI+","+tempJ+","+noOfRows+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
								
							}
					
					}
					else
					{
						out.println("<td    nowrap class='"+classValue+"'>"+taskDesc + anchor_guideLine + "</td>");
					}
				}
				else
					{
							out.println("<td  class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTipForEventsPopulationResult(event,"+index+" ,"+indexK+","+indexI+","+tempJ+","+noOfRows+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
					}
					}
					else
					{
						out.println("<td  class='"+classValue+"' >"+taskDesc+ anchor_guideLine + "</td>");
					}
				out.println("<td  class='"+classValue+"'>"+(String)arrayPriority.get(index)+"</td>");

				out.println("<td  class='"+classValue+"'>" + (String)arrayStageDesc.get(index) + "</td>");
				out.println("<td  class='"+classValue+"'>" + (String)arrayPositionDesc.get(index) + "</td>");

				out.println("<td  nowrap class='"+classValue+"' id='tdPatientId"+index+"'>"+(String)arrayPatDetail.get(index)+"</td>");
				if(!(((String)arrayStatusDesc.get(index)).equals("Performed") || ((String)arrayStatusDesc.get(index)).equals("Not Performed"))) 
						{
							out.println("<td  nowrap class='"+classValue+"'>"+(String)arrayStatus.get(index)+"</td>");
						}
						else
						{
							out.println("<td    nowrap class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTipForPopulationResult1(event,"+index+","+indexK+","+indexI+","+tempJ+","+noOfRows+")'><font color='BLUE'>"+(String)arrayStatus.get(index)+"</font></a><div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='position:absolute;visibility:hidden;'><table id='tooltiptable"+index+"' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
						}
				out.println("<input type='hidden' name='taskType"+index+"' id='taskType"+index+"' value='"+taskTypeCode+"'>");
				out.println("<input type='hidden' name='taskCode"+index+"' id='taskCode"+index+"' value='"+taskCode+"'>");
				out.println("<input type='hidden' name='taskSrlNo"+index+"' id='taskSrlNo"+index+"' value='"+(String)arrayTaskSrlNo.get(index)+"'>");
				remarks = (String)arrayRemarks.get(index) == null ? "" : (String)arrayRemarks.get(index);
				performedId=(String)arrayPerformedId.get(index) == null ? "" : (String)arrayPerformedId.get(index);
				out.println("<input type='hidden' name='remarks"+index+"' id='remarks"+index+"' value='"+remarks+"'>");
				out.println("<input type='hidden' name='performedId"+index+"' id='performedId"+index+"' value='"+performedId+"'>");
				out.println("<input type='hidden' name='performedDate"+index+"' id='performedDate"+index+"' value='"+(String)arrayDateTime.get(index)+"'>");
				out.println("<input type='hidden' name='resultType"+index+"' id='resultType"+index+"' value='"+resultType+"'>");
				out.println("<input type='hidden' name='resultId"+index+"' id='resultId"+index+"' value='"+resultId+"'>");
				out.println("<input type='hidden' name='facilityId"+index+"' id='facilityId"+index+"' value='"+facilityId+"'>"); 
				out.println("<input type='hidden' name='encounterId"+index+"' id='encounterId"+index+"' value='"+encounterId+"'>");

				out.println("<input type='hidden' name='taskCategory"+index+"' id='taskCategory"+index+"' value='"+patTask.checkForNull(arrayTaskCategory.get(index).toString())+"'>");
				out.println("<input type='hidden' name='scheduleDate"+index+"' id='scheduleDate"+index+"' value='"+patTask.checkForNull(arrayScheduleDateTime.get(index).toString())+"'>");
				out.println("<input type='hidden' name='orderId"+index+"' id='orderId"+index+"' value='"+patTask.checkForNull(arrayOrderId.get(index).toString())+"'>");
				out.println("<input type='hidden' name='orderNum"+index+"' id='orderNum"+index+"' value='"+patTask.checkForNull(arrayOrderNum.get(index).toString())+"'>");
				out.println("<input type='hidden' name='patientId"+index+"' id='patientId"+index+"' value='"+patTask.checkForNull(arrayPatientId.get(index).toString())+"'>");
				out.println("<input type='hidden' name='status"+index+"' id='status"+index+"' value='"+patTask.checkForNull(arrayStatus.get(index).toString())+"'>");
				out.println("<input type='hidden' name='adminStatus"+index+"' id='adminStatus"+index+"' value='"+adminStatus+"'>");
				out.println("<input type='hidden' name='priority"+index+"' id='priority"+index+"' value='"+patTask.checkForNull(arrayPriority.get(index).toString())+"'>");
				out.println("</tr>");
				noOfRows++;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(index));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(index));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientDetail));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(taskSelect));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientDetail));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(taskSelect));
            _bw.write(_wl_block13Bytes, _wl_block13);
			}
                
				out.println("<input type='hidden' name='mainHeader' id='mainHeader' value='"+indexJ+"'>");
				out.println("<input type='hidden' name='noOfRows"+indexK+""+indexI+""+tempJ+"' id='noOfRows"+indexK+""+indexI+""+tempJ+"' value='"+noOfRows+"'>");
				out.println("<input type='hidden' name='lastHeader"+indexK+""+indexI+"' id='lastHeader"+indexK+""+indexI+"' value='"+tempI+"'>");
				out.println("<input type='hidden' name='subHeader"+indexK+"' id='subHeader"+indexK+"' value='"+temp+"'>");
				out.println("<input type='hidden' name='count' id='count' value='"+arrayStatus.size()+"'>");
			}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	arrayStatusDesc.clear();
	arrayDateTime.clear();
	arrayTaskType.clear();
	arrayTask.clear();
	arrayPriority.clear();
	arrayPatDetail.clear();
	arrayStatus.clear();
	arrayTaskSrlNo.clear();
	arrayRemarks.clear();
	arrayPerformedId.clear();
	arrayResultType.clear();
	arrayResultId.clear();
	arrayEncounterId.clear();
	arrayFacilityId.clear();
	arrayTaskCategory.clear();
	arrayScheduleDateTime.clear();
	arrayOrderId.clear();
	arrayOrderNum.clear();
	arrayPatientId.clear();
	arrayStageDesc.clear();
	arrayApplicableYN.clear();
	arrayGuildeLinelength.clear();
	arrayPositionDesc.clear();
	retArray.clear();
	mainGrp.clear();
	subGrp.clear();
	tempArray.clear();
	arrayOrderStatusCode.clear(); 
}
catch(Exception ee)
{
	//out.println("Exception from PatTaskListPopulationResult.jsp :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
}


            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
