package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __specialitytasksforeventsselection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpecialityTasksForEventsSelection.jsp", 1709116334371L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/SpecialityTasksForEvents.js\"></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\t<form name=\"specialityTasksForEeventSelectForm\" id=\"specialityTasksForEeventSelectForm\"  method =\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.SpecialityTasksForEventsServlet\'>\n\t<BR><BR>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table border=\'1\' cellspacing=\'0\' cellpadding=\'3\' width=\'100%\' align=\'center\'>\n\t<tr id=\'trcoll\'>\n\t\t\t\t\t<td class=\'columnHeader\' colspan=\'4\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\t\t\t\t\t\n\t</tr>\t\n <tr id=\'trcoll\'>\n\t<td class=\"columnheader\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\t\n\t<td class=\"columnheader\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\t\n\t<td class=\"columnheader\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\n </tr>\n\t\n\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\t\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'event_id\' id=\'event_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \'>\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'module\' id=\'module\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \'>\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'code\' id=\'code\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \'>\n\t\t\t\t\t\t\t<input type =\'hidden\' name=\'no_of_trans\' id=\'no_of_trans\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'conc_string\' id=\'conc_string\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'countOfRows\' id=\'countOfRows\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'firstPos\' id=\'firstPos\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'secPos\' id=\'secPos\' value=\'\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\"true\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n</form>\n</table>\n\t\t\t\t  \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</body>\n</html>\n\n";
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
            _bw.write(_wl_block5Bytes, _wl_block5);

  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  eCA.SpecialityTasksForEventsBean taskBean = (eCA.SpecialityTasksForEventsBean)getObjectFromBean("taskBean","eCA.SpecialityTasksForEventsBean",session);
  
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String flag_for_list = request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows = request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			int cnt = 0;
//			String chk="";
//			String disable="disabled";
			int count=0;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	  
	Connection con = null;
	//String mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
	try
	{   
			con = ConnectionManager.getConnection(request);
			String module = request.getParameter("module") == null ? "true" : request.getParameter("module");
			String code = request.getParameter("code") == null ? "" : request.getParameter("code");
			String event_id = request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			String no_of_trans = request.getParameter("no_of_trans") == null ? "" : request.getParameter("no_of_trans");
			 
			

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
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

					if(!mode.equals("modify"))
					{
						  
						PreparedStatement pstmtNoteSections = null;
						ResultSet resNoteSections = null;
						
						//String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

						String splty_task_code = "";
						String splty_task_desc = "";
						String note_seq_num = "";
//						String chief_complaint_sec_yn = "";
						String sqlNoteSec = "";
						String mapValue = "";
						int srlNo = 1;
						try
						{
							con = ConnectionManager.getConnection(request);
							sqlNoteSec = "select  b.SPLTY_TASK_DESC SPLTY_TASK_DESC, a.SPLTY_TASK_CODE  SPLTY_TASK_CODE ,a.ORDER_SEQ_NO  ORDER_SEQ_NO  from CA_SPLTY_TASKS_FOR_EVENTS a, ca_splty_tasks b  where  a.SPLTY_TASK_CODE=b.SPLTY_TASK_CODE  and  a.SPLTY_EVENT_CODE =?";
							pstmtNoteSections = con.prepareStatement(sqlNoteSec);

							pstmtNoteSections.setString(1,event_id);
							resNoteSections = pstmtNoteSections.executeQuery();

							while(resNoteSections.next())
							{
								
								splty_task_code = resNoteSections.getString("SPLTY_TASK_CODE");
								splty_task_desc = resNoteSections.getString("SPLTY_TASK_DESC");
								note_seq_num = resNoteSections.getString("ORDER_SEQ_NO");
								//out.println("splty_task_code ---->" +splty_task_code);
								//out.println("splty_task_desc ---->" +splty_task_desc);
								//out.println("note_seq_num ---->" +note_seq_num);

								
								if(cnt%2 == 0)
									classValue = "QRYEVEN";
								else
									classValue = "QRYODD";

								out.println("<tr id = 'numRows"+cnt+"'>");
								out.println("<td style='display:none'> <input type = 'hidden' value = '"+splty_task_code+"' name = 'splty_task_code"+cnt+"'> </td>");						
								//out.println("<td style='display:none'> <input type='hidden' value = '"+chief_complaint_sec_yn+"' name='chief_complaint_yn"+cnt+"' id='chief_complaint_yn"+cnt+"'> </td>");
								out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+cnt+"','"+srlNo+"')\"> "+srlNo+" </a></td>");
								out.println("<td class='"+classValue+"'> "+splty_task_desc+" </td>");
								out.println("<td class='"+classValue+"' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+cnt+"' id='seq_num_text"+cnt+"' value = ''> </td>");							
								
								//out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='chief_complaint"+cnt+"' id='chief_complaint"+cnt+"'"+disable+"   value='"+chief_complaint_sec_yn+"' "+chk+"						onclick=`addRecord(this,\""+splty_task_code+"\",\""+splty_task_desc+"\",\""+srlNo+"\",\""+cnt+"\")`> </td>");
								
								out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='secChk"+cnt+"' id='secChk"+cnt+"' checked onclick=\"removeRecord(this,'"+splty_task_code+"','"+cnt+"')\"> </td>");
								out.println("</tr>");							
								//out.println("chief_complaint_sec_yn"+chief_complaint_sec_yn);
								mapValue = splty_task_desc + "~" + srlNo ;			
								taskBean.addRecords(splty_task_code,mapValue);
								taskBean.addToList(cnt,splty_task_code);
								cnt++;
								srlNo++;
							}
							
							out.println("<tr style='display:none' id='extraRow'><td align=\"center\" id='extraTD'><a href=\"javaScript:changeColor('"+cnt+"','"+srlNo+"')\">"+srlNo+"</td><td></td><td ></td></tr>");
							putObjectInBean("taskBean",taskBean,session);


							if(resNoteSections != null) resNoteSections.close();
							if(pstmtNoteSections != null) pstmtNoteSections.close();
						}
						catch(Exception e)
						{
							//out.println("Exception in try of SectionForNoteTypeSections.jsp"+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
						finally
						{
							if(con != null) ConnectionManager.returnConnection(con,request);
						}
				}		
           else if(mode.equals("modify"))
			{	
				String keyVal = "";
				String mapVal = "";
//				String chief_complaint = "";
				String heading_seq_num = "";
				String heading_desc = "";
				StringTokenizer strCodeToken = null;
//				String chief_complaint_sect_yn="";
				//StringTokenizer strSeqToken = null;
				int i=0;
				int tempInt = i +1;

				int positionOne = Integer.parseInt(firstPosition);
				positionOne = positionOne - 1;
				int positionTwo = Integer.parseInt(secondPosition);				
				positionTwo = positionTwo - 1;
				int totalRows = Integer.parseInt(noOfRows);
				String codeList = "";
				try
				{	
//					String check="";
					if(!flag_for_list.equals("false"))
					{
						
						if(totalRows < positionTwo)
							positionTwo = positionTwo -1;
						else
							positionTwo = positionTwo;

						int k = 0;
						ArrayList list = taskBean.retrieveArrayList();
						
						for(k=0;k<list.size();k++)
						{
							codeList = (String) list.get(k);
							if(positionOne == k)
							{
								taskBean.addToList(positionTwo,codeList);
								if(positionTwo > positionOne)
								{
									k = list.size();
								}
							}						
						}
						if(positionTwo > positionOne)
						{
							taskBean.removeElement(positionOne);
						}
						else
						{
							taskBean.removeElement(positionOne+1);
						}
						putObjectInBean("taskBean",taskBean,session);
					}
					HashMap recValues = taskBean.getHashValues();
					ArrayList indexList = new ArrayList();
					indexList = taskBean.retrieveArrayList();
					for(i=0; i<indexList.size(); i++)
					{
						tempInt = i +1;
						keyVal = (String)indexList.get(i);
						mapVal = (String)recValues.get(keyVal);
						
						strCodeToken = new StringTokenizer(mapVal,"~");
						while(strCodeToken.hasMoreTokens())
						{
							heading_desc = strCodeToken.nextToken();
							heading_seq_num = strCodeToken.nextToken();
							
							

							/*if(chief_complaint.equals("Y")||chief_complaint.equals("T"))
                            {
								//check="";
								
								disable="disabled";
							}
							else 
                            {
								//check="";
								disable="";
							}
							if(chief_complaint_sect_yn.equals("Y"))

							{
								if(chief_complaint.equals("Y")||chief_complaint.equals("T"))
								{
							
							       check="";
								}
								else 
								{
								check="checked";
								count++;
										
								}
							}
							else
								check="";	  */
							

							if(heading_seq_num.equals(" "))
								heading_seq_num = "";
							else
								heading_seq_num = heading_seq_num;

							if(i%2 ==0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";
							out.println("<tr id = 'numRows"+i+"'>");
							out.println("<td style='display:none'> <input type= hidden value='"+keyVal+"' name='splty_task_code"+i+"' id='splty_task_code"+i+"'> </td>");
							//out.println("<td style='display:none'> <input type='hidden' value='"+chief_complaint+"' name='chief_complaint_yn"+i+"' id='chief_complaint_yn"+i+"' </td>");
							out.println("<td class='"+classValue+"' align='center'> <a href=\"javascript:changeColor('"+i+"','"+tempInt+"')\"> "+tempInt+" </a></td>");
							out.println("<td class='"+classValue+"' > "+heading_desc+" </td>");
							out.println("<td class='"+classValue+"' align='center' style='display:none'> <input type='hidden' name='seq_num_text"+i+"' id='seq_num_text"+i+"' value=''> </td>");
				//out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' name='chief_complaint"+i+"' id='chief_complaint"+i+"'"+disable+" "+check+"  onclick=`addRecord(this,\""+keyVal+"\",\""+heading_desc+"\",\""+heading_seq_num+"\",\""+i+"\")`> </td>");
							
							out.println("<td class='"+classValue+"' align='center'> <input type='checkbox' checked onclick=\"removeRecord(this,'"+keyVal+"','"+i+"')\"> </td>");
							out.println("</tr>");							
						}
					}
					tempInt++;
					out.println("<tr style='display:none' id='extraRow'><td align=\"center\"><a href=\"javaScript:changeColor('"+i+"','"+tempInt+"')\">"+tempInt+"</td><td></td><td></td></tr>");
					cnt = indexList.size();
				}
				catch(Exception e)
				{
				//	out.println("Exception in try of SectionForNoteTypeSections - mode : modify" +e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
			}

			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(event_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(module));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(no_of_trans));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);

	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
			  }
			}
		catch(Exception e){
			//out.println(e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
			}
	}


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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AttachedTasks.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OrderSequenceNumber.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SpecialtyTaskDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
